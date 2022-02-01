package com.google.ical.values;

import java.text.ParseException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

abstract class AbstractIcalObject
  implements IcalObject
{
  private static final Pattern CONTENT_LINE_RE = Pattern.compile("^((?:[^:;\"]|\"[^\"]*\")+)(;(?:[^:\"]|\"[^\"]*\")+)?:(.*)$");
  static final Pattern ICAL_SPECIALS = Pattern.compile("[:;]");
  private static final Pattern PARAM_RE = Pattern.compile("^;([^=]+)=(?:\"([^\"]*)\"|([^\";:]*))");
  private Map<String, String> extParams = null;
  private String name;
  
  public Map<String, String> getExtParams()
  {
    if (this.extParams == null) {
      this.extParams = new LinkedHashMap();
    }
    return this.extParams;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public boolean hasExtParams()
  {
    return (this.extParams != null) && (!this.extParams.isEmpty());
  }
  
  protected void parse(String paramString, IcalSchema paramIcalSchema)
    throws ParseException
  {
    String str1 = IcalParseUtil.unfoldIcal(paramString);
    Object localObject = CONTENT_LINE_RE.matcher(str1);
    if (!((Matcher)localObject).matches()) {
      paramIcalSchema.badContent(paramString);
    }
    setName(((Matcher)localObject).group(1).toUpperCase());
    str1 = ((Matcher)localObject).group(2);
    paramString = str1;
    if (str1 == null) {
      paramString = "";
    }
    String str2 = ((Matcher)localObject).group(3);
    HashMap localHashMap = new HashMap();
    while (!"".equals(paramString))
    {
      Matcher localMatcher = PARAM_RE.matcher(paramString);
      if (!localMatcher.find()) {
        paramIcalSchema.badPart(paramString, null);
      }
      str1 = paramString.substring(localMatcher.end(0));
      String str3 = localMatcher.group(1).toUpperCase();
      localObject = localMatcher.group(2);
      paramString = (String)localObject;
      if (localObject == null) {
        paramString = localMatcher.group(3);
      }
      if (localHashMap.containsKey(str3)) {
        paramIcalSchema.dupePart(str3);
      }
      localHashMap.put(str3, paramString);
      paramString = str1;
    }
    paramIcalSchema.applyObjectSchema(this.name, localHashMap, str2, this);
  }
  
  public void setName(String paramString)
  {
    this.name = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.ical.values.AbstractIcalObject
 * JD-Core Version:    0.7.0.1
 */