package com.google.ical.values;

import java.text.ParseException;
import java.util.Map;
import java.util.regex.Pattern;

final class RRuleSchema$5
  implements IcalSchema.ObjectRule
{
  public void apply(IcalSchema paramIcalSchema, Map<String, String> paramMap, String paramString, IcalObject paramIcalObject)
    throws ParseException
  {
    paramIcalSchema.applyParamsSchema("exdtparam", paramMap, paramIcalObject);
    paramMap = RRuleSchema.access$300().split(paramString);
    int j = paramMap.length;
    int i = 0;
    while (i < j)
    {
      paramIcalSchema.applyContentSchema("exdtval", paramMap[i], paramIcalObject);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.ical.values.RRuleSchema.5
 * JD-Core Version:    0.7.0.1
 */