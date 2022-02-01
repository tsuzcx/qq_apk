public class abwh
{
  public static void C(int paramInt, String paramString1, String paramString2)
  {
    abwm.C(paramInt, paramString1, paramString2);
  }
  
  public static void Il(int paramInt)
  {
    bU(paramInt, "");
  }
  
  public static void Im(int paramInt)
  {
    bV(paramInt, null);
  }
  
  public static void a(int paramInt1, int paramInt2, int paramInt3, long paramLong, Object... paramVarArgs)
  {
    a(paramInt1, null, paramInt2, paramInt3, paramLong, 0, 0L, paramVarArgs);
  }
  
  public static void a(int paramInt1, int paramInt2, int paramInt3, Object... paramVarArgs)
  {
    a(paramInt1, null, paramInt2, paramInt3, 0L, 0, 0L, paramVarArgs);
  }
  
  public static void a(int paramInt1, String paramString, int paramInt2, int paramInt3, long paramLong1, int paramInt4, long paramLong2, Object... paramVarArgs)
  {
    StringBuilder localStringBuilder = new StringBuilder(paramVarArgs.length * 30);
    int i = 0;
    while (i < paramVarArgs.length)
    {
      localStringBuilder.append(paramVarArgs[i]);
      i += 1;
    }
    abwm.a(paramInt1, paramString, paramInt2, paramInt3, paramLong1, paramInt4, paramLong2, new Object[] { localStringBuilder.toString() });
  }
  
  public static void a(int paramInt1, String paramString, int paramInt2, int paramInt3, Object... paramVarArgs)
  {
    a(paramInt1, paramString, paramInt2, paramInt3, 0L, 0, 0L, paramVarArgs);
  }
  
  public static void a(int paramInt1, String paramString, int paramInt2, Object... paramVarArgs)
  {
    a(paramInt1, paramString, paramInt2, -100, 0L, 0, 0L, paramVarArgs);
  }
  
  public static void a(abwi paramabwi)
  {
    abwm.a(paramabwi);
  }
  
  public static void b(int paramInt1, int paramInt2, Object... paramVarArgs)
  {
    a(paramInt1, null, paramInt2, -100, 0L, 0, 0L, paramVarArgs);
  }
  
  public static void b(int paramInt, String paramString, int... paramVarArgs)
  {
    abwm.b(paramInt, paramString, paramVarArgs);
  }
  
  public static void bU(int paramInt, String paramString)
  {
    C(paramInt, paramString, null);
  }
  
  public static void bV(int paramInt, String paramString)
  {
    abwm.bV(paramInt, paramString);
  }
  
  public static void bl(int paramInt, boolean paramBoolean)
  {
    abwm.bl(paramInt, paramBoolean);
  }
  
  public static void gN(int paramInt1, int paramInt2)
  {
    a(paramInt1, null, paramInt2, -100, 0L, 0, 0L, new Object[] { "" });
  }
  
  public static void v(int paramInt1, String paramString, int paramInt2)
  {
    a(paramInt1, paramString, paramInt2, -100, 0L, 0, 0L, new Object[] { "" });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abwh
 * JD-Core Version:    0.7.0.1
 */