package com.google.ical.values;

import java.text.ParseException;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RDateList
  extends AbstractIcalObject
{
  private DateValue[] datesUtc;
  private TimeZone tzid;
  private IcalValueType valueType;
  
  static
  {
    if (!RDateList.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public RDateList(String paramString, TimeZone paramTimeZone)
    throws ParseException
  {
    setTzid(paramTimeZone);
    parse(paramString, RRuleSchema.instance());
  }
  
  public RDateList(TimeZone paramTimeZone)
  {
    setTzid(paramTimeZone);
    setName("RDATE");
    this.datesUtc = new DateValue[0];
  }
  
  public DateValue[] getDatesUtc()
  {
    if (this.datesUtc != null) {
      return (DateValue[])this.datesUtc.clone();
    }
    return null;
  }
  
  public TimeZone getTzid()
  {
    return this.tzid;
  }
  
  public IcalValueType getValueType()
  {
    return this.valueType;
  }
  
  public void setDatesUtc(DateValue[] paramArrayOfDateValue)
  {
    this.datesUtc = ((DateValue[])paramArrayOfDateValue.clone());
    if (paramArrayOfDateValue.length > 0) {
      if (!(paramArrayOfDateValue[0] instanceof TimeValue)) {
        break label35;
      }
    }
    label35:
    for (paramArrayOfDateValue = IcalValueType.DATE_TIME;; paramArrayOfDateValue = IcalValueType.DATE)
    {
      setValueType(paramArrayOfDateValue);
      return;
    }
  }
  
  public void setTzid(TimeZone paramTimeZone)
  {
    assert (paramTimeZone != null);
    this.tzid = paramTimeZone;
  }
  
  public void setValueType(IcalValueType paramIcalValueType)
  {
    this.valueType = paramIcalValueType;
  }
  
  public String toIcal()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getName().toUpperCase());
    localStringBuilder.append(";TZID=\"").append(this.tzid.getID()).append('"');
    localStringBuilder.append(";VALUE=").append(this.valueType.toIcal());
    Object localObject;
    if (hasExtParams())
    {
      Iterator localIterator = getExtParams().entrySet().iterator();
      while (localIterator.hasNext())
      {
        localObject = (Map.Entry)localIterator.next();
        String str2 = (String)((Map.Entry)localObject).getKey();
        String str1 = (String)((Map.Entry)localObject).getValue();
        localObject = str1;
        if (ICAL_SPECIALS.matcher(str1).find()) {
          localObject = "\"" + str1 + "\"";
        }
        localStringBuilder.append(';').append(str2).append('=').append((String)localObject);
      }
    }
    localStringBuilder.append(':');
    int i = 0;
    while (i < this.datesUtc.length)
    {
      if (i != 0) {
        localStringBuilder.append(',');
      }
      localObject = this.datesUtc[i];
      localStringBuilder.append(localObject);
      if ((localObject instanceof TimeValue)) {
        localStringBuilder.append('Z');
      }
      i += 1;
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.ical.values.RDateList
 * JD-Core Version:    0.7.0.1
 */