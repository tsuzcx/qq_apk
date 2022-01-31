package com.tencent.av.opengl;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class GlStringParser
{
  private char jdField_a_of_type_Char = '\r';
  private Map jdField_a_of_type_JavaUtilMap;
  private char b = '\t';
  
  public GlStringParser()
  {
    this.jdField_a_of_type_Char = '\r';
    this.b = '\t';
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
  }
  
  public GlStringParser(char paramChar1, char paramChar2)
  {
    this.jdField_a_of_type_Char = paramChar1;
    this.b = paramChar2;
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
  }
  
  public GlStringParser(String paramString)
  {
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    a(paramString);
  }
  
  public GlStringParser(Map paramMap)
  {
    this.jdField_a_of_type_JavaUtilMap = paramMap;
  }
  
  public int a(String paramString)
  {
    paramString = (String)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    if (paramString != null) {
      return Integer.parseInt(paramString);
    }
    return 0;
  }
  
  public Boolean a(String paramString)
  {
    paramString = (String)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    if ((paramString != null) && ((paramString.equals("true")) || (paramString.equals("false")))) {
      return Boolean.valueOf(paramString);
    }
    return Boolean.valueOf(false);
  }
  
  public String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localStringBuilder.append(str);
      localStringBuilder.append(this.jdField_a_of_type_Char);
      localStringBuilder.append((String)this.jdField_a_of_type_JavaUtilMap.get(str));
      localStringBuilder.append(this.b);
    }
    localStringBuilder.deleteCharAt(localStringBuilder.length() - 1);
    return localStringBuilder.toString();
  }
  
  public String a(String paramString)
  {
    return (String)this.jdField_a_of_type_JavaUtilMap.get(paramString);
  }
  
  public Map a()
  {
    return this.jdField_a_of_type_JavaUtilMap;
  }
  
  public void a(String paramString)
  {
    if (paramString == null) {}
    for (;;)
    {
      return;
      this.jdField_a_of_type_JavaUtilMap.clear();
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.b);
      paramString = new StringTokenizer(paramString, ((StringBuilder)localObject).toString());
      while (paramString.hasMoreElements())
      {
        String str = paramString.nextToken();
        int i = str.indexOf(this.jdField_a_of_type_Char);
        if (i != -1)
        {
          localObject = str.substring(0, i);
          str = str.substring(i + 1);
          this.jdField_a_of_type_JavaUtilMap.put(localObject, str);
        }
      }
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    this.jdField_a_of_type_JavaUtilMap.put(paramString, Integer.toString(paramInt));
  }
  
  public void a(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString1.indexOf(this.b) != -1) || (paramString1.indexOf(this.jdField_a_of_type_Char) != -1)) {}
    while ((paramString2 == null) || (paramString2.indexOf(this.jdField_a_of_type_Char) != -1) || (paramString2.indexOf(this.b) != -1)) {
      return;
    }
    this.jdField_a_of_type_JavaUtilMap.put(paramString1, paramString2);
  }
  
  public void b(String paramString)
  {
    this.jdField_a_of_type_JavaUtilMap.remove(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.av.opengl.GlStringParser
 * JD-Core Version:    0.7.0.1
 */