mc = {}

-- as in https://en.wikipedia.org/w/index.php?title=Letter_frequency&oldid=685029927
-- @return table letterFrequencyEnglish (rank - letter)
local function getLetterFrequencyEnglish()
  local letterFrequencyEnglish = {
    'E', 'T', 'A', 'O', 'I', 'N', 'S', 'H', 'R', 'D', 'L', 'C', 'U', 'M', 'W', 'F', 'G', 'Y', 'P', 'B', 'V', 'K', 'J', 'X', 'Q', 'Z'
  }
  return letterFrequencyEnglish
end

-- helper function to check if table contains a given key
local function contains(table, element)
  for key, _ in pairs(table) do
    if key == element then
      return true
    end
  end
  return false
end

-- count frequency of letters in given cipher
-- @param sting cipher
-- @return table letterFreuqency {letter - {rank}{number of times in cipher}}
local function countLetterFrequency( cipher )
  local letterFreuqency = {}

  -- iterate over cipher, add to letterFreuqency table
  for i = 1, #cipher do
    local char = cipher:sub( i, i )
    char = string.upper( char )

    if contains( letterFreuqency, char ) then
      letterFreuqency[char] = letterFreuqency[char] + 1
    else
      letterFreuqency[char] = 1
    end
  end
  letterFreuqency = sortTable( letterFreuqency )
  return letterFreuqency
end


-- sort a given table
-- @param table t
-- @return result  {letter - {rank}{number of times in cipher}}
function sortTable( t )
    local keys = {}
    for ke in pairs(t) do keys[#keys+1] = ke end
    local order = function(t,a,b) return t[b] < t[a] end
    table.sort(keys, function(a,b) return order(t, a, b) end)

    local result = {}

    -- return array with the letter as key and the ranking and the amount of letters in string
    for k, v in pairs(keys) do
      result[v] = {k, t[v]}
    end

    return result
end


--decode cipher
local function useFrequenciesSimple( cipher, letterFrequencyCipher, letterFrequencyEnglish )
  local plaintext = ''

  for i = 1, #cipher do
    local char = cipher:sub( i, i )
    if letterFrequencyCipher[char][1] <= 5 then
      local c = letterFrequencyCipher[char][1]
      plaintext = plaintext ..  string.lower( letterFrequencyEnglish[c] )
    else
      plaintext = plaintext ..  char
    end
  end

  return plaintext
end

--decode cipher
local function useFrequencies( cipher, letterFrequencyCipher, letterFrequencyEnglish )
  local plaintext = { "1" }

  for i = 1, #cipher do
    local char = cipher:sub( i, i )
    local c = letterFrequencyCipher[char]
    local boolDouble = false

    for k, v in pairs( letterFrequencyCipher ) do
      if ( c[2] == v[2] and c[1] ~= v[1] ) then
        boolDouble = true

        local pt = {""}
        for ke,va in pairs( plaintext ) do
          local newString = va .. letterFrequencyEnglish[c[1]]
          table.insert( pt, newString )
          va = va ..  letterFrequencyEnglish[v[1]]
        end
        for k,v in pairs(pt) do table.insert( plaintext, v ) end
      end
    end

    if boolDouble == false then
      c = c[1]
      for k,v in pairs( plaintext ) do
        v = v .. letterFrequencyEnglish[c]
      end
    end
  end

  for k,v in pairs( plaintext ) do print(v .. 'ah') end
  return plaintext
end

-- return plaintext of given cipher
local function getPlaintext( cipher )
  local letterFrequencyCipher = countLetterFrequency( cipher )
  local letterFrequencyEnglish = getLetterFrequencyEnglish()
  local plaintext = ' ----- useFrequenciesSimple ----- \n'
  plaintext = plaintext .. useFrequenciesSimple( cipher, letterFrequencyCipher, letterFrequencyEnglish )
  plaintext = plaintext .. '\n ----- useFrequencies ----- \n'
  -- useFrequencies( cipher, letterFrequencyCipher, letterFrequencyEnglish )


  -- for key,value in pairs( letterFrequencyEnglish ) do print(key,value) end
  for key,value in pairs( letterFrequencyCipher ) do print(key,value[2]) end
  return plaintext
end

-- decode a given monoalphabetical cipher
mc.decode = function( cipher )
  local plaintext = ""
  plaintext = getPlaintext( cipher )

  print(plaintext)
end

return mc
