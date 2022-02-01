public abstract class avtz
{
  public static avua.a a(long paramLong)
  {
    return avua.a().b(paramLong);
  }
  
  public static avua.b a(long paramLong)
  {
    return avua.a().a(paramLong);
  }
  
  public static avua.c a(long paramLong)
  {
    return avua.a().a(paramLong);
  }
  
  public static String a(int paramInt, String paramString1, String paramString2, avtz.b paramb)
  {
    return avua.a().a(paramInt, paramString1, paramString2, paramb);
  }
  
  public static String a(int paramInt, String paramString1, String paramString2, avtz.c paramc)
  {
    return a(paramInt, paramString1, paramString2, true, paramc);
  }
  
  public static String a(int paramInt, String paramString1, String paramString2, boolean paramBoolean, avtz.c paramc)
  {
    return avua.a().a(paramInt, paramString1, paramString2, paramBoolean, paramc);
  }
  
  public static void a(long paramLong, avua.a parama)
  {
    avua.a().a(paramLong, parama);
  }
  
  public static void a(long paramLong, avua.b paramb)
  {
    avua.a().a(paramLong, paramb);
  }
  
  public static void a(long paramLong, avua.c paramc)
  {
    avua.a().a(paramLong, paramc);
  }
  
  public static abstract interface a
  {
    public abstract void d(int paramInt, String paramString1, String paramString2);
  }
  
  public static abstract interface b
    extends avtz.a
  {}
  
  public static abstract interface c
    extends avtz.a
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avtz
 * JD-Core Version:    0.7.0.1
 */