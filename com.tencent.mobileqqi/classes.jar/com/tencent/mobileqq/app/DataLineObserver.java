package com.tencent.mobileqq.app;

public class DataLineObserver
  implements BusinessObserver
{
  protected void a() {}
  
  protected void a(int paramInt, String paramString) {}
  
  public void a(int paramInt, boolean paramBoolean, Object paramObject)
  {
    Long localLong;
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      paramObject = (Object[])paramObject;
      a(paramBoolean, (Long)paramObject[0], (String)paramObject[1]);
      return;
    case 2: 
      paramObject = (Object[])paramObject;
      localLong = (Long)paramObject[0];
      a(paramBoolean, ((Long)paramObject[1]).longValue(), (String)paramObject[2]);
      return;
    case 3: 
      paramObject = (Object[])paramObject;
      localLong = (Long)paramObject[0];
      b(paramBoolean, ((Long)paramObject[1]).longValue(), (String)paramObject[2]);
      return;
    case 4: 
      paramObject = (Object[])paramObject;
      ((Long)paramObject[0]).longValue();
      a(((Long)paramObject[1]).longValue(), ((Float)paramObject[2]).floatValue());
      return;
    case 5: 
      paramObject = (Object[])paramObject;
      localLong = (Long)paramObject[0];
      a(paramBoolean, ((Long)paramObject[1]).longValue());
      return;
    case 6: 
      paramObject = (Object[])paramObject;
      localLong = (Long)paramObject[0];
      a(((Long)paramObject[1]).longValue(), (String)paramObject[2], DataLineHandler.EFILETYPE.values()[((java.lang.Byte)paramObject[3]).byteValue()], ((Boolean)paramObject[4]).booleanValue(), ((Boolean)paramObject[5]).booleanValue(), ((Long)paramObject[6]).longValue());
      return;
    case 7: 
      paramObject = (Object[])paramObject;
      localLong = (Long)paramObject[0];
      b(((Long)paramObject[1]).longValue(), (String)paramObject[2], DataLineHandler.EFILETYPE.values()[((java.lang.Byte)paramObject[3]).byteValue()], ((Boolean)paramObject[4]).booleanValue(), ((Boolean)paramObject[5]).booleanValue(), ((Long)paramObject[6]).longValue());
      return;
    case 8: 
      paramObject = (Object[])paramObject;
      a(((Integer)paramObject[0]).intValue(), (String)paramObject[1]);
      return;
    case 9: 
      a((String)((Object[])(Object[])paramObject)[0]);
      return;
    case 10: 
      a(((Long)((Object[])(Object[])paramObject)[0]).longValue());
      return;
    }
    a();
  }
  
  protected void a(long paramLong) {}
  
  public void a(long paramLong, float paramFloat) {}
  
  public void a(long paramLong1, String paramString, DataLineHandler.EFILETYPE paramEFILETYPE, boolean paramBoolean1, boolean paramBoolean2, long paramLong2) {}
  
  public void a(String paramString) {}
  
  public void a(boolean paramBoolean, long paramLong) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString) {}
  
  public void a(boolean paramBoolean, Long paramLong, String paramString) {}
  
  public void b(long paramLong1, String paramString, DataLineHandler.EFILETYPE paramEFILETYPE, boolean paramBoolean1, boolean paramBoolean2, long paramLong2) {}
  
  public void b(boolean paramBoolean, long paramLong, String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.DataLineObserver
 * JD-Core Version:    0.7.0.1
 */