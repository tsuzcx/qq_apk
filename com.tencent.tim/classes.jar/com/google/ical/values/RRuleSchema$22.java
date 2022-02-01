package com.google.ical.values;

import java.text.ParseException;

final class RRuleSchema$22
  implements IcalSchema.XformRule
{
  public int[] apply(IcalSchema paramIcalSchema, String paramString)
    throws ParseException
  {
    return RRuleSchema.access$400(paramString, 0, 59, paramIcalSchema);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.ical.values.RRuleSchema.22
 * JD-Core Version:    0.7.0.1
 */