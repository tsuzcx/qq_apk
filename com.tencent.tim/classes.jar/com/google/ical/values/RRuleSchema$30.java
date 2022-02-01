package com.google.ical.values;

import java.text.ParseException;

final class RRuleSchema$30
  implements IcalSchema.XformRule
{
  public int[] apply(IcalSchema paramIcalSchema, String paramString)
    throws ParseException
  {
    return RRuleSchema.access$600(paramString, 1, 12, paramIcalSchema);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.ical.values.RRuleSchema.30
 * JD-Core Version:    0.7.0.1
 */