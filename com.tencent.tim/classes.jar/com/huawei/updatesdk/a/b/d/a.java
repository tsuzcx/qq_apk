package com.huawei.updatesdk.a.b.d;

import com.huawei.updatesdk.a.b.d.a.d;
import java.util.HashMap;
import java.util.Map;

public class a
{
  private static final Map<String, Class> a = new HashMap();
  
  public static d a(String paramString)
    throws InstantiationException, IllegalAccessException
  {
    Class localClass = (Class)a.get(paramString);
    if (localClass == null) {
      throw new InstantiationException("ResponseBean class not found, method:" + paramString);
    }
    return (d)localClass.newInstance();
  }
  
  public static void a(String paramString, Class paramClass)
  {
    a.put(paramString, paramClass);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.updatesdk.a.b.d.a
 * JD-Core Version:    0.7.0.1
 */