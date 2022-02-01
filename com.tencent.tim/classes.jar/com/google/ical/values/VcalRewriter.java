package com.google.ical.values;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class VcalRewriter
{
  private static final String DATE = "[0-9]{8,}(?:T[0-9]{6}Z?)?";
  private static final Pattern VCAL_RRULE = Pattern.compile("^((?:RRULE|EXRULE)(?:;[\\w-]+=(?:\"[^\"]*\"|[^;:\"]*))*:)(D|W|M[DP]|Y[DM])([0-9]*)((?:\\s+(?:MO|TU|WE|TH|FR|SA|SU|LD|(?:[0-9]{1,3}[+-]?)))*)(?:\\s+(?:#([0-9]+)|([0-9]{8,}(?:T[0-9]{6}Z?)?)))?$", 2);
  private static final Pattern WHITESPACE = Pattern.compile("\\s+");
  
  private static void join(StringBuilder paramStringBuilder, String paramString, String[] paramArrayOfString)
  {
    if (paramArrayOfString.length != 0)
    {
      paramStringBuilder.append(paramArrayOfString[0]);
      int i = 1;
      while (i < paramArrayOfString.length)
      {
        paramStringBuilder.append(paramString).append(paramArrayOfString[i]);
        i += 1;
      }
    }
  }
  
  static String rewriteRule(String paramString)
  {
    Object localObject1 = VCAL_RRULE.matcher(paramString.trim());
    if (!((Matcher)localObject1).matches()) {
      return paramString;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    paramString = ((Matcher)localObject1).group(1);
    String str1 = ((Matcher)localObject1).group(2).toUpperCase();
    Object localObject2 = ((Matcher)localObject1).group(3);
    String str3 = ((Matcher)localObject1).group(4).trim().toUpperCase();
    String str2 = ((Matcher)localObject1).group(5);
    localObject1 = ((Matcher)localObject1).group(6);
    localStringBuilder.append(paramString);
    int i;
    label226:
    char c;
    switch (str1.charAt(0))
    {
    default: 
      throw new AssertionError();
    case 'Y': 
      paramString = Frequency.YEARLY;
      localStringBuilder.append("FREQ=").append(paramString.name());
      if ((!"".equals(localObject2)) && (!"1".equals(localObject2))) {
        localStringBuilder.append(";INTERVAL=").append((String)localObject2);
      }
      if ("".equals(str3)) {
        break label416;
      }
      localObject2 = WHITESPACE.split(str3);
      i = 0;
      if (i < localObject2.length)
      {
        str3 = localObject2[i];
        c = str3.charAt(str3.length() - 1);
        switch (c)
        {
        }
      }
      break;
    case 'M': 
    case 'W': 
    case 'D': 
      for (;;)
      {
        if (str3.equals("LD")) {
          localObject2[i] = "-1";
        }
        i += 1;
        break label226;
        paramString = Frequency.MONTHLY;
        break;
        paramString = Frequency.WEEKLY;
        break;
        paramString = Frequency.DAILY;
        break;
        localObject2[i] = str3.substring(0, str3.length() - 1);
        continue;
        localObject2[i] = (c + str3.substring(0, str3.length() - 1));
      }
    }
    switch (1.$SwitchMap$com$google$ical$values$Frequency[paramString.ordinal()])
    {
    default: 
      label416:
      if (str2 != null) {
        if (!"0".equals(str2)) {
          break;
        }
      }
      break;
    }
    for (;;)
    {
      return localStringBuilder.toString();
      if ('D' == str1.charAt(1))
      {
        localStringBuilder.append(";BYYEARDAY=");
        join(localStringBuilder, ",", (String[])localObject2);
        break;
      }
      localStringBuilder.append(";BYMONTH=");
      join(localStringBuilder, ",", (String[])localObject2);
      break;
      if ('P' == str1.charAt(1))
      {
        localStringBuilder.append(";BYDAY=");
        int k = 0;
        i = 0;
        int j = 0;
        if (k >= localObject2.length) {
          break;
        }
        int n = i;
        int m = j;
        if (Character.isLetter(localObject2[k].charAt(0))) {
          if (k > j)
          {
            m = j;
            j = i;
            i = j;
            if (m < k)
            {
              if (j != 0) {
                localStringBuilder.append(',');
              }
              for (;;)
              {
                localStringBuilder.append(localObject2[m]).append(localObject2[k]);
                m += 1;
                break;
                j = 1;
              }
            }
          }
          else
          {
            if (i == 0) {
              break label655;
            }
            localStringBuilder.append(',');
          }
        }
        for (;;)
        {
          localStringBuilder.append(localObject2[k]);
          m = k + 1;
          n = i;
          k += 1;
          i = n;
          j = m;
          break;
          label655:
          i = 1;
        }
      }
      localStringBuilder.append(";BYMONTHDAY=");
      join(localStringBuilder, ",", (String[])localObject2);
      break;
      localStringBuilder.append(";BYDAY=");
      join(localStringBuilder, ",", (String[])localObject2);
      break;
      localStringBuilder.append(";COUNT=").append(str2);
      continue;
      if (localObject1 != null)
      {
        paramString = ((String)localObject1).toUpperCase();
        localStringBuilder.append(";UNTIL=").append(paramString);
        if ((!paramString.endsWith("Z")) && (paramString.indexOf('T') >= 0)) {
          localStringBuilder.append('Z');
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.ical.values.VcalRewriter
 * JD-Core Version:    0.7.0.1
 */