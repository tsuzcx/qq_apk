package com.tencent.mobileqq.app.message;

import android.annotation.SuppressLint;
import android.util.Pair;
import java.util.HashMap;
import java.util.Map;

public class OnLinePushMsgTypeProcessorDispatcher
  implements ProcessorDispatcherInterface
{
  private static Object jdField_a_of_type_JavaLangObject = new Object();
  private static Map jdField_a_of_type_JavaUtilMap;
  
  public static int a(String paramString)
  {
    return ((Integer)((Pair)jdField_a_of_type_JavaUtilMap.get(paramString)).second).intValue();
  }
  
  public static String a(int paramInt)
  {
    return (String)((Pair)jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt))).first;
  }
  
  public static Map a()
  {
    if (jdField_a_of_type_JavaUtilMap == null) {}
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_JavaUtilMap == null) {
        a();
      }
      return jdField_a_of_type_JavaUtilMap;
    }
  }
  
  @SuppressLint({"UseSparseArrays"})
  private static void a()
  {
    jdField_a_of_type_JavaUtilMap = new HashMap();
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(169), Pair.create("offlinefile_processor", Integer.valueOf(9001)));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(193), Pair.create("video_processor", Integer.valueOf(9002)));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(734), Pair.create("sharp_video_processor", Integer.valueOf(9003)));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(208), Pair.create("ptt_processor", Integer.valueOf(9004)));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(8), Pair.create("grouptmp_processor", Integer.valueOf(9005)));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(132), Pair.create("opentrooptmp_processor", Integer.valueOf(9006)));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(732), Pair.create("enter_opentroop_processor", Integer.valueOf(9007)));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(524), Pair.create("discuss_update_processor", Integer.valueOf(9010)));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(736), Pair.create("info_update_processor", Integer.valueOf(9011)));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(528), Pair.create("0x210_processor", Integer.valueOf(9012)));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(526), Pair.create("slave_master_processor", Integer.valueOf(9013)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.message.OnLinePushMsgTypeProcessorDispatcher
 * JD-Core Version:    0.7.0.1
 */