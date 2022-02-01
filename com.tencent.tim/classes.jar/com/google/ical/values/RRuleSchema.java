package com.google.ical.values;

import java.text.ParseException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

class RRuleSchema
  extends IcalSchema
{
  private static final Pattern COMMA = Pattern.compile(",");
  private static final Map<String, IcalSchema.ContentRule> CONTENT_RULES;
  private static final Pattern NUM_DAY;
  private static final Map<String, IcalSchema.ObjectRule> OBJECT_RULES;
  private static final Map<String, IcalSchema.ParamRule> PARAM_RULES;
  private static final Pattern RRULE_PARTS;
  private static final Pattern SEMI = Pattern.compile(";");
  private static final Map<String, IcalSchema.XformRule> XFORM_RULES;
  private static final Pattern X_NAME_RE = Pattern.compile("^X-", 2);
  
  static
  {
    RRULE_PARTS = Pattern.compile("^(FREQ|UNTIL|COUNT|INTERVAL|BYSECOND|BYMINUTE|BYHOUR|BYDAY|BYMONTHDAY|BYYEARDAY|BYWEEKDAY|BYWEEKNO|BYMONTH|BYSETPOS|WKST|X-[A-Z0-9\\-]+)=(.*)", 2);
    NUM_DAY = Pattern.compile("^([+\\-]?\\d\\d?)?(SU|MO|TU|WE|TH|FR|SA)$", 2);
    HashMap localHashMap1 = new HashMap();
    HashMap localHashMap2 = new HashMap();
    HashMap localHashMap3 = new HashMap();
    HashMap localHashMap4 = new HashMap();
    localHashMap3.put("RRULE", new RRuleSchema.1());
    localHashMap3.put("EXRULE", new RRuleSchema.2());
    RRuleSchema.3 local3 = new RRuleSchema.3();
    localHashMap1.put("rrulparam", local3);
    localHashMap1.put("exrparam", local3);
    localHashMap2.put("recur", new RRuleSchema.4());
    localHashMap3.put("EXDATE", new RRuleSchema.5());
    localHashMap2.put("FREQ", new RRuleSchema.6());
    localHashMap2.put("UNTIL", new RRuleSchema.7());
    localHashMap2.put("COUNT", new RRuleSchema.8());
    localHashMap2.put("INTERVAL", new RRuleSchema.9());
    localHashMap2.put("BYSECOND", new RRuleSchema.10());
    localHashMap2.put("BYMINUTE", new RRuleSchema.11());
    localHashMap2.put("BYHOUR", new RRuleSchema.12());
    localHashMap2.put("BYDAY", new RRuleSchema.13());
    localHashMap2.put("BYMONTHDAY", new RRuleSchema.14());
    localHashMap2.put("BYYEARDAY", new RRuleSchema.15());
    localHashMap2.put("BYWEEKNO", new RRuleSchema.16());
    localHashMap2.put("BYMONTH", new RRuleSchema.17());
    localHashMap2.put("BYSETPOS", new RRuleSchema.18());
    localHashMap2.put("WKST", new RRuleSchema.19());
    localHashMap4.put("freq", new RRuleSchema.20());
    localHashMap4.put("enddate", new RRuleSchema.21());
    localHashMap4.put("byseclist", new RRuleSchema.22());
    localHashMap4.put("byminlist", new RRuleSchema.23());
    localHashMap4.put("byhrlist", new RRuleSchema.24());
    localHashMap4.put("bywdaylist", new RRuleSchema.25());
    localHashMap4.put("weekday", new RRuleSchema.26());
    localHashMap4.put("bymodaylist", new RRuleSchema.27());
    localHashMap4.put("byyrdaylist", new RRuleSchema.28());
    localHashMap4.put("bywknolist", new RRuleSchema.29());
    localHashMap4.put("bymolist", new RRuleSchema.30());
    localHashMap4.put("bysplist", new RRuleSchema.31());
    localHashMap3.put("RDATE", new RRuleSchema.32());
    localHashMap3.put("EXDATE", new RRuleSchema.33());
    localHashMap1.put("rdtparam", new RRuleSchema.34());
    localHashMap1.put("rrulparam", local3);
    localHashMap1.put("exrparam", local3);
    localHashMap2.put("rdtval", new RRuleSchema.35());
    PARAM_RULES = Collections.unmodifiableMap(localHashMap1);
    CONTENT_RULES = Collections.unmodifiableMap(localHashMap2);
    OBJECT_RULES = Collections.unmodifiableMap(localHashMap3);
    XFORM_RULES = Collections.unmodifiableMap(localHashMap4);
  }
  
  private RRuleSchema()
  {
    super(PARAM_RULES, CONTENT_RULES, OBJECT_RULES, XFORM_RULES);
  }
  
  static RRuleSchema instance()
  {
    return new RRuleSchema();
  }
  
  private static int[] parseIntList(String paramString, int paramInt1, int paramInt2, IcalSchema paramIcalSchema)
    throws ParseException
  {
    String[] arrayOfString = COMMA.split(paramString);
    int[] arrayOfInt = new int[arrayOfString.length];
    int i = arrayOfString.length;
    for (;;)
    {
      i -= 1;
      if (i < 0) {
        break;
      }
      try
      {
        int j = Integer.parseInt(arrayOfString[i]);
        int k = Math.abs(j);
        if ((paramInt1 > k) || (paramInt2 < k)) {
          paramIcalSchema.badPart(paramString, null);
        }
        arrayOfInt[i] = j;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        paramIcalSchema.badPart(paramString, localNumberFormatException.getMessage());
      }
    }
    return arrayOfInt;
  }
  
  private static int[] parseUnsignedIntList(String paramString, int paramInt1, int paramInt2, IcalSchema paramIcalSchema)
    throws ParseException
  {
    String[] arrayOfString = COMMA.split(paramString);
    int[] arrayOfInt = new int[arrayOfString.length];
    int i = arrayOfString.length;
    for (;;)
    {
      i -= 1;
      if (i < 0) {
        break;
      }
      try
      {
        int j = Integer.parseInt(arrayOfString[i]);
        if ((paramInt1 > j) || (paramInt2 < j)) {
          paramIcalSchema.badPart(paramString, null);
        }
        arrayOfInt[i] = j;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        paramIcalSchema.badPart(paramString, localNumberFormatException.getMessage());
      }
    }
    return arrayOfInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.ical.values.RRuleSchema
 * JD-Core Version:    0.7.0.1
 */