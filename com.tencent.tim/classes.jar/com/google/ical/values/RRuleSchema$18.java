package com.google.ical.values;

import java.text.ParseException;

final class RRuleSchema$18
  implements IcalSchema.ContentRule
{
  public void apply(IcalSchema paramIcalSchema, String paramString, IcalObject paramIcalObject)
    throws ParseException
  {
    ((RRule)paramIcalObject).setBySetPos((int[])paramIcalSchema.applyXformSchema("bysplist", paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.ical.values.RRuleSchema.18
 * JD-Core Version:    0.7.0.1
 */