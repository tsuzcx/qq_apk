package com.tencent.mobileqq.activity.voip;

import ewv;
import java.util.HashMap;

public class VoipNumberKeySoundPlay
{
  private static VoipNumberKeySoundPlay jdField_a_of_type_ComTencentMobileqqActivityVoipVoipNumberKeySoundPlay = null;
  private final float jdField_a_of_type_Float = 0.2F;
  private final int jdField_a_of_type_Int = 8000;
  private HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private final int b = 1600;
  
  private VoipNumberKeySoundPlay()
  {
    this.jdField_a_of_type_JavaUtilHashMap.put("1", new int[] { 697, 1209 });
    this.jdField_a_of_type_JavaUtilHashMap.put("2", new int[] { 697, 1336 });
    this.jdField_a_of_type_JavaUtilHashMap.put("3", new int[] { 697, 1477 });
    this.jdField_a_of_type_JavaUtilHashMap.put("4", new int[] { 770, 1209 });
    this.jdField_a_of_type_JavaUtilHashMap.put("5", new int[] { 770, 1336 });
    this.jdField_a_of_type_JavaUtilHashMap.put("6", new int[] { 770, 1477 });
    this.jdField_a_of_type_JavaUtilHashMap.put("7", new int[] { 852, 1209 });
    this.jdField_a_of_type_JavaUtilHashMap.put("8", new int[] { 852, 1336 });
    this.jdField_a_of_type_JavaUtilHashMap.put("9", new int[] { 852, 1477 });
    this.jdField_a_of_type_JavaUtilHashMap.put("0", new int[] { 941, 1209 });
    this.jdField_a_of_type_JavaUtilHashMap.put("*", new int[] { 941, 1336 });
    this.jdField_a_of_type_JavaUtilHashMap.put("#", new int[] { 941, 1477 });
  }
  
  public static VoipNumberKeySoundPlay a()
  {
    if (jdField_a_of_type_ComTencentMobileqqActivityVoipVoipNumberKeySoundPlay == null) {
      jdField_a_of_type_ComTencentMobileqqActivityVoipVoipNumberKeySoundPlay = new VoipNumberKeySoundPlay();
    }
    return jdField_a_of_type_ComTencentMobileqqActivityVoipVoipNumberKeySoundPlay;
  }
  
  public void a(String paramString)
  {
    new ewv(this, paramString).start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.activity.voip.VoipNumberKeySoundPlay
 * JD-Core Version:    0.7.0.1
 */