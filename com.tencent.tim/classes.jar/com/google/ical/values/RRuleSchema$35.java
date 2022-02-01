package com.google.ical.values;

import java.text.ParseException;
import java.util.regex.Pattern;

final class RRuleSchema$35
  implements IcalSchema.ContentRule
{
  public void apply(IcalSchema paramIcalSchema, String paramString, IcalObject paramIcalObject)
    throws ParseException
  {
    paramIcalSchema = (RDateList)paramIcalObject;
    paramString = RRuleSchema.access$300().split(paramString);
    paramIcalObject = new DateValue[paramString.length];
    int i = 0;
    while (i < paramString.length)
    {
      paramIcalObject[i] = IcalParseUtil.parseDateValue(paramString[i], paramIcalSchema.getTzid());
      i += 1;
    }
    paramIcalSchema.setDatesUtc(paramIcalObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.ical.values.RRuleSchema.35
 * JD-Core Version:    0.7.0.1
 */