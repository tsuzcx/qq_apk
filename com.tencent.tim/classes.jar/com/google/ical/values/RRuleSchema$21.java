package com.google.ical.values;

import java.text.ParseException;

final class RRuleSchema$21
  implements IcalSchema.XformRule
{
  public DateValue apply(IcalSchema paramIcalSchema, String paramString)
    throws ParseException
  {
    return IcalParseUtil.parseDateValue(paramString.toUpperCase());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.ical.values.RRuleSchema.21
 * JD-Core Version:    0.7.0.1
 */