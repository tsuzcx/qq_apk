package com.tencent.qqmail.protocol.calendar;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class ICalendar
{
  private static final String TAG = "Sync";
  
  private static Parameter extractParameter(ParserState paramParserState)
    throws ICalendar.FormatException
  {
    String str = paramParserState.line;
    int m = str.length();
    Object localObject1 = null;
    int i = -1;
    int j = -1;
    if (paramParserState.index < m)
    {
      int n = str.charAt(paramParserState.index);
      if (n == 58)
      {
        if (localObject1 != null)
        {
          if (i == -1) {
            throw new FormatException("Expected '=' within parameter in " + str);
          }
          ((Parameter)localObject1).value = str.substring(i + 1, paramParserState.index);
        }
        return localObject1;
      }
      Object localObject2;
      int k;
      if (n == 59)
      {
        if (localObject1 != null)
        {
          if (i == -1) {
            throw new FormatException("Expected '=' within parameter in " + str);
          }
          ((Parameter)localObject1).value = str.substring(i + 1, paramParserState.index);
          return localObject1;
        }
        localObject2 = new Parameter();
        j = paramParserState.index;
        k = i;
      }
      label276:
      do
      {
        for (;;)
        {
          paramParserState.index += 1;
          i = k;
          localObject1 = localObject2;
          break;
          if (n != 61) {
            break label276;
          }
          k = paramParserState.index;
          if ((localObject1 == null) || (j == -1)) {
            throw new FormatException("Expected ';' before '=' in " + str);
          }
          ((Parameter)localObject1).name = str.substring(j + 1, k);
          localObject2 = localObject1;
        }
        k = i;
        localObject2 = localObject1;
      } while (n != 34);
      if (localObject1 == null) {
        throw new FormatException("Expected parameter before '\"' in " + str);
      }
      if (i == -1) {
        throw new FormatException("Expected '=' within parameter in " + str);
      }
      if (paramParserState.index > i + 1) {
        throw new FormatException("Parameter value cannot contain a '\"' in " + str);
      }
      i = str.indexOf('"', paramParserState.index + 1);
      if (i < 0) {
        throw new FormatException("Expected closing '\"' in " + str);
      }
      ((Parameter)localObject1).value = str.substring(paramParserState.index + 1, i);
      paramParserState.index = (i + 1);
      return localObject1;
    }
    throw new FormatException("Expected ':' before end of line in " + str);
  }
  
  private static String extractValue(ParserState paramParserState)
    throws ICalendar.FormatException
  {
    String str1 = paramParserState.line;
    if ((paramParserState.index >= str1.length()) || (str1.charAt(paramParserState.index) != ':')) {
      throw new FormatException("Expected ':' before end of line in " + str1);
    }
    String str2 = str1.substring(paramParserState.index + 1);
    paramParserState.index = (str1.length() - 1);
    return str2;
  }
  
  private static String normalizeText(String paramString)
  {
    return paramString.replaceAll("\r\n", "\n").replaceAll("\r", "\n").replaceAll("\n ", "");
  }
  
  public static Component parseCalendar(String paramString)
    throws ICalendar.FormatException
  {
    paramString = parseComponent(null, paramString);
    if ((paramString == null) || (!"VCALENDAR".equals(paramString.getName()))) {
      throw new FormatException("Expected VCALENDAR");
    }
    return paramString;
  }
  
  public static Component parseComponent(Component paramComponent, String paramString)
    throws ICalendar.FormatException
  {
    return parseComponentImpl(paramComponent, normalizeText(paramString));
  }
  
  public static Component parseComponent(String paramString)
    throws ICalendar.FormatException
  {
    return parseComponent(null, paramString);
  }
  
  private static Component parseComponentImpl(Component paramComponent, String paramString)
    throws ICalendar.FormatException
  {
    ParserState localParserState = new ParserState(null);
    localParserState.index = 0;
    String[] arrayOfString = paramString.split("\n");
    int j = arrayOfString.length;
    int i = 0;
    paramString = paramComponent;
    Object localObject = paramComponent;
    paramComponent = paramString;
    paramString = (String)localObject;
    for (;;)
    {
      if (i >= j) {
        return paramString;
      }
      localObject = arrayOfString[i];
      try
      {
        localObject = parseLine((String)localObject, localParserState, paramComponent);
        paramComponent = (Component)localObject;
        localObject = paramString;
        localComponent = paramComponent;
        if (paramString == null)
        {
          localObject = paramComponent;
          localComponent = paramComponent;
        }
      }
      catch (FormatException localFormatException)
      {
        for (;;)
        {
          String str = paramString;
          Component localComponent = paramComponent;
        }
      }
      i += 1;
      paramString = (String)localObject;
      paramComponent = localComponent;
    }
    return paramString;
  }
  
  public static Component parseEvent(String paramString)
    throws ICalendar.FormatException
  {
    paramString = parseComponent(null, paramString);
    if ((paramString == null) || (!"VEVENT".equals(paramString.getName()))) {
      throw new FormatException("Expected VEVENT");
    }
    return paramString;
  }
  
  private static Component parseLine(String paramString, ParserState paramParserState, Component paramComponent)
    throws ICalendar.FormatException
  {
    paramParserState.line = paramString;
    int k = paramParserState.line.length();
    paramParserState.index = 0;
    int i = 0;
    int j;
    for (;;)
    {
      j = i;
      if (paramParserState.index < k)
      {
        i = paramString.charAt(paramParserState.index);
        j = i;
        if (i != 59)
        {
          if (i != 58) {
            break label93;
          }
          j = i;
        }
      }
      paramString = paramString.substring(0, paramParserState.index);
      if ((paramComponent != null) || ("BEGIN".equals(paramString))) {
        break;
      }
      throw new FormatException("Expected BEGIN");
      label93:
      paramParserState.index += 1;
    }
    if ("BEGIN".equals(paramString))
    {
      paramString = new Component(extractValue(paramParserState), paramComponent);
      if (paramComponent != null) {
        paramComponent.addChild(paramString);
      }
      return paramString;
    }
    if ("END".equals(paramString))
    {
      paramString = extractValue(paramParserState);
      if ((paramComponent == null) || (!paramString.equals(paramComponent.getName()))) {
        throw new FormatException("Unexpected END " + paramString);
      }
      return paramComponent.getParent();
    }
    paramString = new Property(paramString);
    if (j == 59) {
      for (;;)
      {
        Parameter localParameter = extractParameter(paramParserState);
        if (localParameter == null) {
          break;
        }
        paramString.addParameter(localParameter);
      }
    }
    paramString.setValue(extractValue(paramParserState));
    paramComponent.addProperty(paramString);
    return paramComponent;
  }
  
  public static class Component
  {
    static final String BEGIN = "BEGIN";
    static final String END = "END";
    private static final String NEWLINE = "\n";
    public static final String VALARM = "VALARM";
    public static final String VCALENDAR = "VCALENDAR";
    public static final String VEVENT = "VEVENT";
    public static final String VFREEBUSY = "VFREEBUSY";
    public static final String VJOURNAL = "VJOURNAL";
    public static final String VTIMEZONE = "VTIMEZONE";
    public static final String VTODO = "VTODO";
    private LinkedList<Component> mChildren = null;
    private final String mName;
    private final Component mParent;
    private final LinkedHashMap<String, ArrayList<ICalendar.Property>> mPropsMap = new LinkedHashMap();
    
    public Component(String paramString, Component paramComponent)
    {
      this.mName = paramString;
      this.mParent = paramComponent;
    }
    
    public void addChild(Component paramComponent)
    {
      getOrCreateChildren().add(paramComponent);
    }
    
    public void addProperty(ICalendar.Property paramProperty)
    {
      String str = paramProperty.getName();
      ArrayList localArrayList2 = (ArrayList)this.mPropsMap.get(str);
      ArrayList localArrayList1 = localArrayList2;
      if (localArrayList2 == null)
      {
        localArrayList1 = new ArrayList();
        this.mPropsMap.put(str, localArrayList1);
      }
      localArrayList1.add(paramProperty);
    }
    
    public List<Component> getComponents()
    {
      return this.mChildren;
    }
    
    public Component getFirstComponent(String paramString)
    {
      if (this.mChildren == null) {
        return null;
      }
      Iterator localIterator = this.mChildren.iterator();
      while (localIterator.hasNext())
      {
        Component localComponent = (Component)localIterator.next();
        if (localComponent.getName().equals(paramString)) {
          return localComponent;
        }
      }
      return null;
    }
    
    public ICalendar.Property getFirstProperty(String paramString)
    {
      paramString = (List)this.mPropsMap.get(paramString);
      if ((paramString == null) || (paramString.size() == 0)) {
        return null;
      }
      return (ICalendar.Property)paramString.get(0);
    }
    
    public String getFirstPropertyValue(String paramString)
    {
      paramString = getFirstProperty(paramString);
      if (paramString == null) {
        return null;
      }
      return paramString.getValue();
    }
    
    public String getName()
    {
      return this.mName;
    }
    
    protected LinkedList<Component> getOrCreateChildren()
    {
      if (this.mChildren == null) {
        this.mChildren = new LinkedList();
      }
      return this.mChildren;
    }
    
    public Component getParent()
    {
      return this.mParent;
    }
    
    public List<ICalendar.Property> getProperties(String paramString)
    {
      return (List)this.mPropsMap.get(paramString);
    }
    
    public Set<String> getPropertyNames()
    {
      return this.mPropsMap.keySet();
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      toString(localStringBuilder);
      localStringBuilder.append("\n");
      return localStringBuilder.toString();
    }
    
    public void toString(StringBuilder paramStringBuilder)
    {
      paramStringBuilder.append("BEGIN");
      paramStringBuilder.append(":");
      paramStringBuilder.append(this.mName);
      paramStringBuilder.append("\n");
      Iterator localIterator1 = getPropertyNames().iterator();
      while (localIterator1.hasNext())
      {
        Iterator localIterator2 = getProperties((String)localIterator1.next()).iterator();
        while (localIterator2.hasNext())
        {
          ((ICalendar.Property)localIterator2.next()).toString(paramStringBuilder);
          paramStringBuilder.append("\n");
        }
      }
      if (this.mChildren != null)
      {
        localIterator1 = this.mChildren.iterator();
        while (localIterator1.hasNext())
        {
          ((Component)localIterator1.next()).toString(paramStringBuilder);
          paramStringBuilder.append("\n");
        }
      }
      paramStringBuilder.append("END");
      paramStringBuilder.append(":");
      paramStringBuilder.append(this.mName);
    }
  }
  
  public static class FormatException
    extends Exception
  {
    public FormatException() {}
    
    public FormatException(String paramString)
    {
      super();
    }
    
    public FormatException(String paramString, Throwable paramThrowable)
    {
      super(paramThrowable);
    }
  }
  
  public static class Parameter
  {
    public String name;
    public String value;
    
    public Parameter() {}
    
    public Parameter(String paramString1, String paramString2)
    {
      this.name = paramString1;
      this.value = paramString2;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      toString(localStringBuilder);
      return localStringBuilder.toString();
    }
    
    public void toString(StringBuilder paramStringBuilder)
    {
      paramStringBuilder.append(this.name);
      paramStringBuilder.append("=");
      paramStringBuilder.append(this.value);
    }
  }
  
  static final class ParserState
  {
    public int index;
    public String line;
  }
  
  public static class Property
  {
    public static final String DTEND = "DTEND";
    public static final String DTSTART = "DTSTART";
    public static final String DURATION = "DURATION";
    public static final String EXDATE = "EXDATE";
    public static final String EXRULE = "EXRULE";
    public static final String RDATE = "RDATE";
    public static final String RRULE = "RRULE";
    private final String mName;
    private LinkedHashMap<String, ArrayList<ICalendar.Parameter>> mParamsMap = new LinkedHashMap();
    private String mValue;
    
    public Property(String paramString)
    {
      this.mName = paramString;
    }
    
    public Property(String paramString1, String paramString2)
    {
      this.mName = paramString1;
      this.mValue = paramString2;
    }
    
    public void addParameter(ICalendar.Parameter paramParameter)
    {
      ArrayList localArrayList2 = (ArrayList)this.mParamsMap.get(paramParameter.name);
      ArrayList localArrayList1 = localArrayList2;
      if (localArrayList2 == null)
      {
        localArrayList1 = new ArrayList();
        this.mParamsMap.put(paramParameter.name, localArrayList1);
      }
      localArrayList1.add(paramParameter);
    }
    
    public ICalendar.Parameter getFirstParameter(String paramString)
    {
      paramString = (ArrayList)this.mParamsMap.get(paramString);
      if ((paramString == null) || (paramString.size() == 0)) {
        return null;
      }
      return (ICalendar.Parameter)paramString.get(0);
    }
    
    public String getName()
    {
      return this.mName;
    }
    
    public Set<String> getParameterNames()
    {
      return this.mParamsMap.keySet();
    }
    
    public List<ICalendar.Parameter> getParameters(String paramString)
    {
      return (List)this.mParamsMap.get(paramString);
    }
    
    public String getValue()
    {
      return this.mValue;
    }
    
    public void setValue(String paramString)
    {
      this.mValue = paramString;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      toString(localStringBuilder);
      return localStringBuilder.toString();
    }
    
    public void toString(StringBuilder paramStringBuilder)
    {
      paramStringBuilder.append(this.mName);
      Iterator localIterator1 = getParameterNames().iterator();
      while (localIterator1.hasNext())
      {
        Iterator localIterator2 = getParameters((String)localIterator1.next()).iterator();
        while (localIterator2.hasNext())
        {
          ICalendar.Parameter localParameter = (ICalendar.Parameter)localIterator2.next();
          paramStringBuilder.append(";");
          localParameter.toString(paramStringBuilder);
        }
      }
      paramStringBuilder.append(":");
      paramStringBuilder.append(this.mValue);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.protocol.calendar.ICalendar
 * JD-Core Version:    0.7.0.1
 */