package com.google.ical.values;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class RRuleSchema$4
  implements IcalSchema.ContentRule
{
  public void apply(IcalSchema paramIcalSchema, String paramString, IcalObject paramIcalObject)
    throws ParseException
  {
    Object localObject1 = RRuleSchema.access$000().split(paramString);
    HashMap localHashMap = new HashMap();
    int i = 0;
    while (i < localObject1.length)
    {
      CharSequence localCharSequence = localObject1[i];
      Object localObject2 = RRuleSchema.access$100().matcher(localCharSequence);
      if (!((Matcher)localObject2).matches()) {
        paramIcalSchema.badPart(localCharSequence, null);
      }
      String str = ((Matcher)localObject2).group(1).toUpperCase();
      localObject2 = ((Matcher)localObject2).group(2);
      if (localHashMap.containsKey(str)) {
        paramIcalSchema.dupePart(localCharSequence);
      }
      localHashMap.put(str, localObject2);
      i += 1;
    }
    if (!localHashMap.containsKey("FREQ")) {
      paramIcalSchema.missingPart("FREQ", paramString);
    }
    if ((localHashMap.containsKey("UNTIL")) && (localHashMap.containsKey("COUNT"))) {
      paramIcalSchema.badPart(paramString, "UNTIL & COUNT are exclusive");
    }
    paramString = localHashMap.entrySet().iterator();
    while (paramString.hasNext())
    {
      localObject1 = (Map.Entry)paramString.next();
      if (!RRuleSchema.access$200().matcher((CharSequence)((Map.Entry)localObject1).getKey()).matches()) {
        paramIcalSchema.applyContentSchema((String)((Map.Entry)localObject1).getKey(), (String)((Map.Entry)localObject1).getValue(), paramIcalObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.ical.values.RRuleSchema.4
 * JD-Core Version:    0.7.0.1
 */