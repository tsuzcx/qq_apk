package com.google.ical.values;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class IcalSchema
{
  private static final Pattern EXTENSION_PARAM_NAME_RE = Pattern.compile("^X-[A-Z0-9\\-]+$", 2);
  private final Map<String, ContentRule> contentRules;
  private final Map<String, ObjectRule> objectRules;
  private final Map<String, ParamRule> paramRules;
  private final List<String> ruleStack = new ArrayList();
  private final Map<String, XformRule> xformRules;
  
  IcalSchema(Map<String, ParamRule> paramMap, Map<String, ContentRule> paramMap1, Map<String, ObjectRule> paramMap2, Map<String, XformRule> paramMap3)
  {
    this.paramRules = paramMap;
    this.contentRules = paramMap1;
    this.objectRules = paramMap2;
    this.xformRules = paramMap3;
  }
  
  /* Error */
  public void applyContentSchema(String paramString1, String paramString2, IcalObject paramIcalObject)
    throws ParseException
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 52	com/google/ical/values/IcalSchema:ruleStack	Ljava/util/List;
    //   4: aload_1
    //   5: invokeinterface 76 2 0
    //   10: pop
    //   11: aload_0
    //   12: getfield 56	com/google/ical/values/IcalSchema:contentRules	Ljava/util/Map;
    //   15: aload_1
    //   16: invokeinterface 82 2 0
    //   21: checkcast 6	com/google/ical/values/IcalSchema$ContentRule
    //   24: aload_0
    //   25: aload_2
    //   26: aload_3
    //   27: invokeinterface 86 4 0
    //   32: aload_0
    //   33: getfield 52	com/google/ical/values/IcalSchema:ruleStack	Ljava/util/List;
    //   36: aload_0
    //   37: getfield 52	com/google/ical/values/IcalSchema:ruleStack	Ljava/util/List;
    //   40: aload_0
    //   41: getfield 52	com/google/ical/values/IcalSchema:ruleStack	Ljava/util/List;
    //   44: invokeinterface 90 1 0
    //   49: iconst_1
    //   50: isub
    //   51: invokeinterface 93 2 0
    //   56: invokeinterface 96 2 0
    //   61: pop
    //   62: return
    //   63: astore_1
    //   64: aload_0
    //   65: aload_2
    //   66: invokevirtual 100	com/google/ical/values/IcalSchema:badContent	(Ljava/lang/String;)V
    //   69: goto -37 -> 32
    //   72: astore_1
    //   73: aload_0
    //   74: getfield 52	com/google/ical/values/IcalSchema:ruleStack	Ljava/util/List;
    //   77: aload_0
    //   78: getfield 52	com/google/ical/values/IcalSchema:ruleStack	Ljava/util/List;
    //   81: aload_0
    //   82: getfield 52	com/google/ical/values/IcalSchema:ruleStack	Ljava/util/List;
    //   85: invokeinterface 90 1 0
    //   90: iconst_1
    //   91: isub
    //   92: invokeinterface 93 2 0
    //   97: invokeinterface 96 2 0
    //   102: pop
    //   103: aload_1
    //   104: athrow
    //   105: astore_1
    //   106: aload_0
    //   107: aload_2
    //   108: invokevirtual 100	com/google/ical/values/IcalSchema:badContent	(Ljava/lang/String;)V
    //   111: goto -79 -> 32
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	114	0	this	IcalSchema
    //   0	114	1	paramString1	String
    //   0	114	2	paramString2	String
    //   0	114	3	paramIcalObject	IcalObject
    // Exception table:
    //   from	to	target	type
    //   11	32	63	java/lang/NumberFormatException
    //   11	32	72	finally
    //   64	69	72	finally
    //   106	111	72	finally
    //   11	32	105	java/lang/IllegalArgumentException
  }
  
  public void applyObjectSchema(String paramString1, Map<String, String> paramMap, String paramString2, IcalObject paramIcalObject)
    throws ParseException
  {
    this.ruleStack.add(paramString1);
    try
    {
      ((ObjectRule)this.objectRules.get(paramString1)).apply(this, paramMap, paramString2, paramIcalObject);
      return;
    }
    finally
    {
      this.ruleStack.remove(this.ruleStack.get(this.ruleStack.size() - 1));
    }
  }
  
  public void applyParamSchema(String paramString1, String paramString2, String paramString3, IcalObject paramIcalObject)
    throws ParseException
  {
    if (EXTENSION_PARAM_NAME_RE.matcher(paramString2).find())
    {
      paramIcalObject.getExtParams().put(paramString2, paramString3);
      return;
    }
    this.ruleStack.add(paramString1);
    try
    {
      ((ParamRule)this.paramRules.get(paramString1)).apply(this, paramString2, paramString3, paramIcalObject);
      return;
    }
    finally
    {
      this.ruleStack.remove(this.ruleStack.get(this.ruleStack.size() - 1));
    }
  }
  
  public void applyParamsSchema(String paramString, Map<String, String> paramMap, IcalObject paramIcalObject)
    throws ParseException
  {
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      applyParamSchema(paramString, (String)localEntry.getKey(), (String)localEntry.getValue(), paramIcalObject);
    }
  }
  
  /* Error */
  public Object applyXformSchema(String paramString1, String paramString2)
    throws ParseException
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 52	com/google/ical/values/IcalSchema:ruleStack	Ljava/util/List;
    //   4: aload_1
    //   5: invokeinterface 76 2 0
    //   10: pop
    //   11: aload_0
    //   12: getfield 60	com/google/ical/values/IcalSchema:xformRules	Ljava/util/Map;
    //   15: aload_1
    //   16: invokeinterface 82 2 0
    //   21: checkcast 15	com/google/ical/values/IcalSchema$XformRule
    //   24: aload_0
    //   25: aload_2
    //   26: invokeinterface 171 3 0
    //   31: astore_1
    //   32: aload_0
    //   33: getfield 52	com/google/ical/values/IcalSchema:ruleStack	Ljava/util/List;
    //   36: aload_0
    //   37: getfield 52	com/google/ical/values/IcalSchema:ruleStack	Ljava/util/List;
    //   40: aload_0
    //   41: getfield 52	com/google/ical/values/IcalSchema:ruleStack	Ljava/util/List;
    //   44: invokeinterface 90 1 0
    //   49: iconst_1
    //   50: isub
    //   51: invokeinterface 93 2 0
    //   56: invokeinterface 96 2 0
    //   61: pop
    //   62: aload_1
    //   63: areturn
    //   64: astore_1
    //   65: aload_0
    //   66: aload_2
    //   67: invokevirtual 100	com/google/ical/values/IcalSchema:badContent	(Ljava/lang/String;)V
    //   70: new 173	java/lang/AssertionError
    //   73: dup
    //   74: invokespecial 174	java/lang/AssertionError:<init>	()V
    //   77: athrow
    //   78: astore_1
    //   79: aload_0
    //   80: getfield 52	com/google/ical/values/IcalSchema:ruleStack	Ljava/util/List;
    //   83: aload_0
    //   84: getfield 52	com/google/ical/values/IcalSchema:ruleStack	Ljava/util/List;
    //   87: aload_0
    //   88: getfield 52	com/google/ical/values/IcalSchema:ruleStack	Ljava/util/List;
    //   91: invokeinterface 90 1 0
    //   96: iconst_1
    //   97: isub
    //   98: invokeinterface 93 2 0
    //   103: invokeinterface 96 2 0
    //   108: pop
    //   109: aload_1
    //   110: athrow
    //   111: astore_1
    //   112: aload_0
    //   113: aload_2
    //   114: invokevirtual 100	com/google/ical/values/IcalSchema:badContent	(Ljava/lang/String;)V
    //   117: goto -47 -> 70
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	120	0	this	IcalSchema
    //   0	120	1	paramString1	String
    //   0	120	2	paramString2	String
    // Exception table:
    //   from	to	target	type
    //   11	32	64	java/lang/NumberFormatException
    //   11	32	78	finally
    //   65	70	78	finally
    //   70	78	78	finally
    //   112	117	78	finally
    //   11	32	111	java/lang/IllegalArgumentException
  }
  
  public void badContent(String paramString)
    throws ParseException
  {
    throw new ParseException("cannot parse content line [[" + paramString + "]] in " + this.ruleStack, 0);
  }
  
  public void badParam(String paramString1, String paramString2)
    throws ParseException
  {
    throw new ParseException("parameter " + paramString1 + " has bad value [[" + paramString2 + "]] in " + this.ruleStack, 0);
  }
  
  public void badPart(String paramString1, String paramString2)
    throws ParseException
  {
    if (paramString2 != null) {}
    for (paramString2 = " : " + paramString2;; paramString2 = "") {
      throw new ParseException("cannot parse [[" + paramString1 + "]] in " + this.ruleStack + paramString2, 0);
    }
  }
  
  public void dupePart(String paramString)
    throws ParseException
  {
    throw new ParseException("duplicate part [[" + paramString + "]] in " + this.ruleStack, 0);
  }
  
  public void missingPart(String paramString1, String paramString2)
    throws ParseException
  {
    throw new ParseException("missing part " + paramString1 + " from [[" + paramString2 + "]] in " + this.ruleStack, 0);
  }
  
  public static abstract interface ContentRule
  {
    public abstract void apply(IcalSchema paramIcalSchema, String paramString, IcalObject paramIcalObject)
      throws ParseException;
  }
  
  public static abstract interface ObjectRule
  {
    public abstract void apply(IcalSchema paramIcalSchema, Map<String, String> paramMap, String paramString, IcalObject paramIcalObject)
      throws ParseException;
  }
  
  public static abstract interface ParamRule
  {
    public abstract void apply(IcalSchema paramIcalSchema, String paramString1, String paramString2, IcalObject paramIcalObject)
      throws ParseException;
  }
  
  public static abstract interface XformRule
  {
    public abstract Object apply(IcalSchema paramIcalSchema, String paramString)
      throws ParseException;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.ical.values.IcalSchema
 * JD-Core Version:    0.7.0.1
 */