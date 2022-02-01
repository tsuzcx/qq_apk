package com.google.ical.values;

import java.text.ParseException;

final class RRuleSchema$20
  implements IcalSchema.XformRule
{
  public Frequency apply(IcalSchema paramIcalSchema, String paramString)
    throws ParseException
  {
    return Frequency.valueOf(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.ical.values.RRuleSchema.20
 * JD-Core Version:    0.7.0.1
 */