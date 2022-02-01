package com.tencent.token;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public final class adk
  extends ahh<Date>
{
  public static final ahk a = new a();
  public final DateFormat b = new SimpleDateFormat("MMM d, yyyy");
  
  public final void a(aep paramaep, Object paramObject)
  {
    paramObject = (Date)paramObject;
    if (paramObject == null) {
      paramObject = null;
    }
    try
    {
      paramObject = this.b.format(paramObject);
      paramaep.b(paramObject);
      return;
    }
    finally {}
  }
  
  public final class a
    implements ahk
  {
    public final <T> ahh<T> a(ahx paramahx, aek<T> paramaek)
    {
      if (paramaek.a == Date.class) {
        return new adk();
      }
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.adk
 * JD-Core Version:    0.7.0.1
 */