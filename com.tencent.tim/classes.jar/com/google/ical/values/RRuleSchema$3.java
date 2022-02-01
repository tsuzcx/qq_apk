package com.google.ical.values;

import java.text.ParseException;

final class RRuleSchema$3
  implements IcalSchema.ParamRule
{
  public void apply(IcalSchema paramIcalSchema, String paramString1, String paramString2, IcalObject paramIcalObject)
    throws ParseException
  {
    paramIcalSchema.badParam(paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.ical.values.RRuleSchema.3
 * JD-Core Version:    0.7.0.1
 */