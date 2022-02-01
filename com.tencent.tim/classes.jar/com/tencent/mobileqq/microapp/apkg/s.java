package com.tencent.mobileqq.microapp.apkg;

import org.json.JSONObject;

public final class s
  implements Cloneable
{
  public u a;
  
  public static s a()
  {
    s locals = new s();
    locals.a = u.a();
    return locals;
  }
  
  public void a(JSONObject paramJSONObject)
  {
    u localu;
    if (this.a != null)
    {
      localu = this.a;
      if (paramJSONObject != null) {
        break label24;
      }
    }
    label24:
    for (paramJSONObject = null;; paramJSONObject = paramJSONObject.optJSONObject("window"))
    {
      localu.a(paramJSONObject);
      return;
    }
  }
  
  public s b()
  {
    try
    {
      locals = (s)super.clone();
      localThrowable1.printStackTrace();
    }
    catch (Throwable localThrowable1)
    {
      try
      {
        locals.a = this.a.b();
        return locals;
      }
      catch (Throwable localThrowable2)
      {
        s locals;
        break label24;
      }
      localThrowable1 = localThrowable1;
      locals = null;
    }
    label24:
    return locals;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.apkg.s
 * JD-Core Version:    0.7.0.1
 */