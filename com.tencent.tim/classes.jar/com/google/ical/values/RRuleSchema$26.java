package com.google.ical.values;

import java.text.ParseException;

final class RRuleSchema$26
  implements IcalSchema.XformRule
{
  public Weekday apply(IcalSchema paramIcalSchema, String paramString)
    throws ParseException
  {
    return Weekday.valueOf(paramString.toUpperCase());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.ical.values.RRuleSchema.26
 * JD-Core Version:    0.7.0.1
 */