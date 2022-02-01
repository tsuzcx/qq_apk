package com.google.thirdparty.publicsuffix;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Lists;
import java.util.List;

@GwtCompatible
final class TrieParser
{
  private static final Joiner PREFIX_JOINER = Joiner.on("");
  
  private static int doParseTrieToBuilder(List<CharSequence> paramList, CharSequence paramCharSequence, ImmutableMap.Builder<String, PublicSuffixType> paramBuilder)
  {
    int k = paramCharSequence.length();
    char c1 = '\000';
    int i = 0;
    char c2 = c1;
    if (i < k)
    {
      c1 = paramCharSequence.charAt(i);
      c2 = c1;
      if (c1 != '&')
      {
        c2 = c1;
        if (c1 != '?')
        {
          c2 = c1;
          if (c1 != '!')
          {
            c2 = c1;
            if (c1 != ':')
            {
              if (c1 != ',') {
                break label251;
              }
              c2 = c1;
            }
          }
        }
      }
    }
    paramList.add(0, reverse(paramCharSequence.subSequence(0, i)));
    if ((c2 == '!') || (c2 == '?') || (c2 == ':') || (c2 == ','))
    {
      String str = PREFIX_JOINER.join(paramList);
      if (str.length() > 0) {
        paramBuilder.put(str, PublicSuffixType.fromCode(c2));
      }
    }
    i += 1;
    int j;
    if ((c2 != '?') && (c2 != ','))
    {
      do
      {
        j = i;
        if (i >= k) {
          break label240;
        }
        j = i + doParseTrieToBuilder(paramList, paramCharSequence.subSequence(i, k), paramBuilder);
        if (paramCharSequence.charAt(j) == '?') {
          break;
        }
        i = j;
      } while (paramCharSequence.charAt(j) != ',');
      j += 1;
    }
    for (;;)
    {
      label240:
      paramList.remove(0);
      return j;
      label251:
      i += 1;
      break;
      j = i;
    }
  }
  
  static ImmutableMap<String, PublicSuffixType> parseTrie(CharSequence paramCharSequence)
  {
    ImmutableMap.Builder localBuilder = ImmutableMap.builder();
    int j = paramCharSequence.length();
    int i = 0;
    while (i < j) {
      i += doParseTrieToBuilder(Lists.newLinkedList(), paramCharSequence.subSequence(i, j), localBuilder);
    }
    return localBuilder.build();
  }
  
  private static CharSequence reverse(CharSequence paramCharSequence)
  {
    return new StringBuilder(paramCharSequence).reverse();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.thirdparty.publicsuffix.TrieParser
 * JD-Core Version:    0.7.0.1
 */