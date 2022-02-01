package org.apache.commons.lang3.text.translate;

import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.HashSet;

public class LookupTranslator
  extends CharSequenceTranslator
{
  private final int longest;
  private final HashMap<String, String> lookupMap = new HashMap();
  private final HashSet<Character> prefixSet = new HashSet();
  private final int shortest;
  
  public LookupTranslator(CharSequence[]... paramVarArgs)
  {
    int j = 2147483647;
    int i;
    if (paramVarArgs != null)
    {
      int i1 = paramVarArgs.length;
      int k = 0;
      i = 0;
      int m;
      for (j = 2147483647; k < i1; j = m)
      {
        CharSequence[] arrayOfCharSequence = paramVarArgs[k];
        this.lookupMap.put(arrayOfCharSequence[0].toString(), arrayOfCharSequence[1].toString());
        this.prefixSet.add(Character.valueOf(arrayOfCharSequence[0].charAt(0)));
        int n = arrayOfCharSequence[0].length();
        m = j;
        if (n < j) {
          m = n;
        }
        if (n <= i) {
          break label161;
        }
        i = n;
        k += 1;
      }
    }
    for (;;)
    {
      this.shortest = j;
      this.longest = i;
      return;
      label161:
      break;
      i = 0;
    }
  }
  
  public int translate(CharSequence paramCharSequence, int paramInt, Writer paramWriter)
    throws IOException
  {
    if (this.prefixSet.contains(Character.valueOf(paramCharSequence.charAt(paramInt))))
    {
      int i = this.longest;
      if (this.longest + paramInt > paramCharSequence.length()) {
        i = paramCharSequence.length() - paramInt;
      }
      while (i >= this.shortest)
      {
        Object localObject = paramCharSequence.subSequence(paramInt, paramInt + i);
        localObject = (String)this.lookupMap.get(((CharSequence)localObject).toString());
        if (localObject != null)
        {
          paramWriter.write((String)localObject);
          return i;
        }
        i -= 1;
      }
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     org.apache.commons.lang3.text.translate.LookupTranslator
 * JD-Core Version:    0.7.0.1
 */