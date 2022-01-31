package com.tencent.common.config;

import java.util.HashMap;

public class VibrateSoundStrategy
{
  private static final int jdField_a_of_type_Int = 3300;
  private static VibrateSoundStrategy jdField_a_of_type_ComTencentCommonConfigVibrateSoundStrategy;
  private long jdField_a_of_type_Long;
  private String jdField_a_of_type_JavaLangString = "-1";
  private HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private boolean jdField_a_of_type_Boolean;
  
  public static VibrateSoundStrategy a()
  {
    if (jdField_a_of_type_ComTencentCommonConfigVibrateSoundStrategy == null) {
      jdField_a_of_type_ComTencentCommonConfigVibrateSoundStrategy = new VibrateSoundStrategy();
    }
    return jdField_a_of_type_ComTencentCommonConfigVibrateSoundStrategy;
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean a(String paramString)
  {
    long l2 = System.currentTimeMillis();
    if (this.jdField_a_of_type_Boolean)
    {
      if (paramString == null) {
        return false;
      }
      long l1 = 0L;
      Long localLong = (Long)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
      if (localLong != null) {
        l1 = localLong.longValue();
      }
      if (l2 - l1 <= 3300L) {
        break label97;
      }
    }
    label97:
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_JavaUtilHashMap.put(paramString, Long.valueOf(l2));
      return bool;
      if (l2 - this.jdField_a_of_type_Long <= 3300L) {
        break;
      }
      this.jdField_a_of_type_Long = l2;
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.common.config.VibrateSoundStrategy
 * JD-Core Version:    0.7.0.1
 */