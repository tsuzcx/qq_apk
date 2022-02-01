package com.google.ical.values;

import java.text.ParseException;
import java.util.List;

final class RRuleSchema$13
  implements IcalSchema.ContentRule
{
  public void apply(IcalSchema paramIcalSchema, String paramString, IcalObject paramIcalObject)
    throws ParseException
  {
    ((RRule)paramIcalObject).setByDay((List)paramIcalSchema.applyXformSchema("bywdaylist", paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.ical.values.RRuleSchema.13
 * JD-Core Version:    0.7.0.1
 */