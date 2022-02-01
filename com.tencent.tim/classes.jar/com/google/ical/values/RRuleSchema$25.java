package com.google.ical.values;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class RRuleSchema$25
  implements IcalSchema.XformRule
{
  public List<WeekdayNum> apply(IcalSchema paramIcalSchema, String paramString)
    throws ParseException
  {
    paramString = RRuleSchema.access$300().split(paramString);
    ArrayList localArrayList = new ArrayList(paramString.length);
    int n = paramString.length;
    int i = 0;
    while (i < n)
    {
      CharSequence localCharSequence = paramString[i];
      Object localObject = RRuleSchema.access$500().matcher(localCharSequence);
      if (!((Matcher)localObject).matches()) {
        paramIcalSchema.badPart(localCharSequence, null);
      }
      Weekday localWeekday = Weekday.valueOf(((Matcher)localObject).group(2).toUpperCase());
      localObject = ((Matcher)localObject).group(1);
      int k;
      if ((localObject == null) || ("".equals(localObject)))
      {
        k = 0;
        localArrayList.add(new WeekdayNum(k, localWeekday));
        i += 1;
      }
      else
      {
        int j = Integer.parseInt((String)localObject);
        if (j < 0) {}
        for (int m = -j;; m = j)
        {
          if (1 <= m)
          {
            k = j;
            if (53 >= m) {
              break;
            }
          }
          paramIcalSchema.badPart(localCharSequence, null);
          k = j;
          break;
        }
      }
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.ical.values.RRuleSchema.25
 * JD-Core Version:    0.7.0.1
 */