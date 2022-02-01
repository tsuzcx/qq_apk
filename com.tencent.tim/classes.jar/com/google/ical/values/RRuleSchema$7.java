package com.google.ical.values;

import java.text.ParseException;

final class RRuleSchema$7
  implements IcalSchema.ContentRule
{
  public void apply(IcalSchema paramIcalSchema, String paramString, IcalObject paramIcalObject)
    throws ParseException
  {
    ((RRule)paramIcalObject).setUntil((DateValue)paramIcalSchema.applyXformSchema("enddate", paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.ical.values.RRuleSchema.7
 * JD-Core Version:    0.7.0.1
 */