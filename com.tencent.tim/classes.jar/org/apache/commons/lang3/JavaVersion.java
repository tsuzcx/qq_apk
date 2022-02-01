package org.apache.commons.lang3;

public enum JavaVersion
{
  JAVA_0_9(1.5F, "0.9"),  JAVA_1_1(1.1F, "1.1"),  JAVA_1_2(1.2F, "1.2"),  JAVA_1_3(1.3F, "1.3"),  JAVA_1_4(1.4F, "1.4"),  JAVA_1_5(1.5F, "1.5"),  JAVA_1_6(1.6F, "1.6"),  JAVA_1_7(1.7F, "1.7"),  JAVA_1_8(1.8F, "1.8"),  JAVA_1_9(1.9F, "1.9"),  JAVA_RECENT(maxVersion(), Float.toString(maxVersion()));
  
  private final String name;
  private final float value;
  
  private JavaVersion(float paramFloat, String paramString)
  {
    this.value = paramFloat;
    this.name = paramString;
  }
  
  static JavaVersion get(String paramString)
  {
    Object localObject2 = null;
    Object localObject1;
    if ("0.9".equals(paramString)) {
      localObject1 = JAVA_0_9;
    }
    int i;
    do
    {
      do
      {
        do
        {
          return localObject1;
          if ("1.1".equals(paramString)) {
            return JAVA_1_1;
          }
          if ("1.2".equals(paramString)) {
            return JAVA_1_2;
          }
          if ("1.3".equals(paramString)) {
            return JAVA_1_3;
          }
          if ("1.4".equals(paramString)) {
            return JAVA_1_4;
          }
          if ("1.5".equals(paramString)) {
            return JAVA_1_5;
          }
          if ("1.6".equals(paramString)) {
            return JAVA_1_6;
          }
          if ("1.7".equals(paramString)) {
            return JAVA_1_7;
          }
          if ("1.8".equals(paramString)) {
            return JAVA_1_8;
          }
          if ("1.9".equals(paramString)) {
            return JAVA_1_9;
          }
          localObject1 = localObject2;
        } while (paramString == null);
        localObject1 = localObject2;
      } while (toFloatVersion(paramString) - 1.0D >= 1.0D);
      i = Math.max(paramString.indexOf('.'), paramString.indexOf(','));
      localObject1 = localObject2;
    } while (Float.parseFloat(paramString.substring(i + 1, Math.max(paramString.length(), paramString.indexOf(',', i)))) <= 0.9F);
    return JAVA_RECENT;
  }
  
  static JavaVersion getJavaVersion(String paramString)
  {
    return get(paramString);
  }
  
  private static float maxVersion()
  {
    float f = toFloatVersion(System.getProperty("java.version", "2.0"));
    if (f > 0.0F) {
      return f;
    }
    return 2.0F;
  }
  
  private static float toFloatVersion(String paramString)
  {
    paramString = paramString.split("\\.");
    if (paramString.length >= 2) {
      try
      {
        float f = Float.parseFloat(paramString[0] + '.' + paramString[1]);
        return f;
      }
      catch (NumberFormatException paramString) {}
    }
    return -1.0F;
  }
  
  public boolean atLeast(JavaVersion paramJavaVersion)
  {
    return this.value >= paramJavaVersion.value;
  }
  
  public String toString()
  {
    return this.name;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     org.apache.commons.lang3.JavaVersion
 * JD-Core Version:    0.7.0.1
 */