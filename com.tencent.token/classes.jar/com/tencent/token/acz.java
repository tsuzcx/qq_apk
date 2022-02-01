package com.tencent.token;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public final class acz
  extends ahh<Date>
{
  public static final ahk a = new a();
  public final List<DateFormat> b;
  
  public acz()
  {
    ArrayList localArrayList = new ArrayList();
    this.b = localArrayList;
    Locale localLocale = Locale.US;
    localArrayList.add(DateFormat.getDateTimeInstance(2, 2, localLocale));
    if (!Locale.getDefault().equals(localLocale)) {
      localArrayList.add(DateFormat.getDateTimeInstance(2, 2));
    }
    if (ahi.a()) {
      localArrayList.add(ahr.a());
    }
  }
  
  public final void a(aep paramaep, Object paramObject)
  {
    paramObject = (Date)paramObject;
    if (paramObject == null) {}
    try
    {
      paramaep.e();
      break label41;
      paramaep.b(((DateFormat)this.b.get(0)).format(paramObject));
      label41:
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
        return new acz();
      }
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.acz
 * JD-Core Version:    0.7.0.1
 */