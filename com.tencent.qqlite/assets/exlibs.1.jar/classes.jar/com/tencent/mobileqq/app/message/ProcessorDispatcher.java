package com.tencent.mobileqq.app.message;

import android.util.Pair;
import java.util.HashMap;
import java.util.Map;

public class ProcessorDispatcher
  implements ProcessorDispatcherInterface
{
  private static Object jdField_a_of_type_JavaLangObject = new Object();
  private static Map jdField_a_of_type_JavaUtilMap;
  
  public static int a(String paramString)
  {
    return ((Integer)((Pair)jdField_a_of_type_JavaUtilMap.get(paramString)).second).intValue();
  }
  
  public static String a(String paramString)
  {
    return (String)((Pair)jdField_a_of_type_JavaUtilMap.get(paramString)).first;
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
  
  private static void a()
  {
    jdField_a_of_type_JavaUtilMap = new HashMap();
    jdField_a_of_type_JavaUtilMap.put("MessageSvc.GetMsgV4", Pair.create("accost_processor", Integer.valueOf(5002)));
    jdField_a_of_type_JavaUtilMap.put("RegPrxySvc.GetMsgV2", Pair.create("accost_processor", Integer.valueOf(5002)));
    jdField_a_of_type_JavaUtilMap.put("AccostSvc.SvrMsg", Pair.create("accost_processor", Integer.valueOf(5001)));
    jdField_a_of_type_JavaUtilMap.put("ProfileService.Pb.ReqSystemMsg", Pair.create("system_processor", Integer.valueOf(6005)));
    jdField_a_of_type_JavaUtilMap.put("ProfileService.Pb.ReqSystemMsgNew", Pair.create("system_processor", Integer.valueOf(6002)));
    jdField_a_of_type_JavaUtilMap.put("ProfileService.Pb.ReqSystemMsgNew.Friend", Pair.create("system_processor", Integer.valueOf(6001)));
    jdField_a_of_type_JavaUtilMap.put("ProfileService.Pb.ReqSystemMsgNew.Group", Pair.create("system_processor", Integer.valueOf(6003)));
    jdField_a_of_type_JavaUtilMap.put("ProfileService.Pb.ReqNextSystemMsg", Pair.create("system_processor", Integer.valueOf(6004)));
    jdField_a_of_type_JavaUtilMap.put("ProfileService.Pb.ReqSystemMsgRead", Pair.create("system_processor", Integer.valueOf(6006)));
    jdField_a_of_type_JavaUtilMap.put("ProfileService.Pb.ReqSystemMsgAction", Pair.create("system_processor", Integer.valueOf(6007)));
    jdField_a_of_type_JavaUtilMap.put("MessageSvc.PbGetOneDayRoamMsg", Pair.create("c2c_processor", Integer.valueOf(1003)));
    jdField_a_of_type_JavaUtilMap.put("MessageSvc.PbGetRoamMsg", Pair.create("c2c_processor", Integer.valueOf(2001)));
    jdField_a_of_type_JavaUtilMap.put("TransService.ReqOffFilePack", Pair.create("offlinefile_processor", Integer.valueOf(7001)));
    jdField_a_of_type_JavaUtilMap.put("OnlinePush.ReqPush", Pair.create("businessbase_processor", Integer.valueOf(3001)));
    jdField_a_of_type_JavaUtilMap.put("MessageSvc.GroupMsgReadConfirm", Pair.create("troop_processor", Integer.valueOf(9001)));
    jdField_a_of_type_JavaUtilMap.put("MessageSvc.DisMsgReadConfirm", Pair.create("disc_processor", Integer.valueOf(10001)));
    jdField_a_of_type_JavaUtilMap.put("MessageSvc.MsgReadedReport", Pair.create("c2c_processor", Integer.valueOf(10001)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.message.ProcessorDispatcher
 * JD-Core Version:    0.7.0.1
 */