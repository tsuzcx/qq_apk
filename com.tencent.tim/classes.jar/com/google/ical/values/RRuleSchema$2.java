package com.google.ical.values;

import java.text.ParseException;
import java.util.Map;

final class RRuleSchema$2
  implements IcalSchema.ObjectRule
{
  public void apply(IcalSchema paramIcalSchema, Map<String, String> paramMap, String paramString, IcalObject paramIcalObject)
    throws ParseException
  {
    paramIcalSchema.applyParamsSchema("exrparam", paramMap, paramIcalObject);
    paramIcalSchema.applyContentSchema("recur", paramString, paramIcalObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.ical.values.RRuleSchema.2
 * JD-Core Version:    0.7.0.1
 */