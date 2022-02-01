public class auqu
{
  public static void assertNotNull(Object paramObject)
  {
    assertNotNull((String)null, paramObject);
  }
  
  public static void assertNotNull(String paramString, Object paramObject)
  {
    if (paramObject != null) {}
    for (boolean bool = true;; bool = false)
    {
      assertTrue(paramString, bool);
      return;
    }
  }
  
  public static void assertTrue(String paramString, boolean paramBoolean)
  {
    if (!paramBoolean) {
      fail(paramString);
    }
  }
  
  public static void assertTrue(boolean paramBoolean)
  {
    assertTrue((String)null, paramBoolean);
  }
  
  public static void fail(String paramString)
  {
    if (paramString == null) {
      throw new AssertionError();
    }
    throw new AssertionError(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     auqu
 * JD-Core Version:    0.7.0.1
 */