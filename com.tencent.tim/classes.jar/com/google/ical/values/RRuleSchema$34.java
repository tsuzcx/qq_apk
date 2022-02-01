package com.google.ical.values;

import com.google.ical.util.TimeUtils;
import java.text.ParseException;

final class RRuleSchema$34
  implements IcalSchema.ParamRule
{
  public void apply(IcalSchema paramIcalSchema, String paramString1, String paramString2, IcalObject paramIcalObject)
    throws ParseException
  {
    if ("value".equalsIgnoreCase(paramString1))
    {
      if (("date-time".equalsIgnoreCase(paramString2)) || ("date".equalsIgnoreCase(paramString2)) || ("period".equalsIgnoreCase(paramString2)))
      {
        ((RDateList)paramIcalObject).setValueType(IcalValueType.fromIcal(paramString2));
        return;
      }
      paramIcalSchema.badParam(paramString1, paramString2);
      return;
    }
    if ("tzid".equalsIgnoreCase(paramString1))
    {
      String str = paramString2;
      if (paramString2.startsWith("/")) {
        str = paramString2.substring(1).trim();
      }
      paramString2 = TimeUtils.timeZoneForName(str.replaceAll(" ", "_"));
      if (paramString2 == null) {
        paramIcalSchema.badParam(paramString1, str);
      }
      ((RDateList)paramIcalObject).setTzid(paramString2);
      return;
    }
    paramIcalSchema.badParam(paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.ical.values.RRuleSchema.34
 * JD-Core Version:    0.7.0.1
 */