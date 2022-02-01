import android.util.Pair;
import java.util.HashMap;
import java.util.Map;

public class acrg
{
  private static Object cm = new Object();
  private static Map<String, Pair<String, Integer>> jx;
  
  public static Map<String, Pair<String, Integer>> af()
  {
    if (jx == null) {}
    synchronized (cm)
    {
      if (jx == null) {
        cOa();
      }
      return jx;
    }
  }
  
  public static int cD(String paramString)
  {
    return ((Integer)((Pair)jx.get(paramString)).second).intValue();
  }
  
  private static void cOa()
  {
    jx = new HashMap();
    jx.put("MessageSvc.GetMsgV4", Pair.create("accost_processor", Integer.valueOf(5002)));
    jx.put("RegPrxySvc.GetMsgV2", Pair.create("accost_processor", Integer.valueOf(5002)));
    jx.put("AccostSvc.SvrMsg", Pair.create("accost_processor", Integer.valueOf(5001)));
    jx.put("ProfileService.Pb.ReqSystemMsgNew", Pair.create("system_processor", Integer.valueOf(6002)));
    jx.put("ProfileService.Pb.ReqSystemMsgNew.Friend", Pair.create("system_processor", Integer.valueOf(6001)));
    jx.put("ProfileService.Pb.ReqSystemMsgNew.Group", Pair.create("system_processor", Integer.valueOf(6003)));
    jx.put("ProfileService.Pb.ReqSystemMsgRead", Pair.create("system_processor", Integer.valueOf(6006)));
    jx.put("ProfileService.Pb.ReqSystemMsgAction", Pair.create("system_processor", Integer.valueOf(6007)));
    jx.put("OidbSvc.0x5cf_0", Pair.create("system_processor", Integer.valueOf(6008)));
    jx.put("OidbSvc.0x5cf_1", Pair.create("system_processor", Integer.valueOf(6009)));
    jx.put("MessageSvc.PbGetOneDayRoamMsg", Pair.create("c2c_processor", Integer.valueOf(1003)));
    jx.put("MessageSvc.PbGetRoamMsg", Pair.create("c2c_processor", Integer.valueOf(2001)));
    jx.put("PbMessageSvc.PbSearchRoamMsgInCloud", Pair.create("c2c_processor", Integer.valueOf(2005)));
    jx.put("TransService.ReqOffFilePack", Pair.create("offlinefile_processor", Integer.valueOf(7001)));
    jx.put("OnlinePush.ReqPush", Pair.create("businessbase_processor", Integer.valueOf(3001)));
    jx.put("MessageSvc.PbBindUinGetMsg", Pair.create("sub_account_processor", Integer.valueOf(4001)));
    jx.put("PbMessageSvc.PbBindUinMsgReadedConfirm", Pair.create("sub_account_processor", Integer.valueOf(4002)));
    jx.put("OidbSvc.0x5d0_1", Pair.create("sub_account_processor", Integer.valueOf(4003)));
    jx.put("MessageSvc.PbMultiMsgSend", Pair.create("uncommon_msg_processor", Integer.valueOf(8001)));
    jx.put("PbMessageSvc.PbMsgWithDraw", Pair.create("uncommon_msg_processor", Integer.valueOf(8002)));
    jx.put("PbMessageSvc.PbDelOneRoamMsg", Pair.create("uncommon_msg_processor", Integer.valueOf(8003)));
    jx.put("SecSvcBlessingHelper.blessing_helper", Pair.create("uncommon_msg_processor", Integer.valueOf(8004)));
  }
  
  public static String jA(String paramString)
  {
    return (String)((Pair)jx.get(paramString)).first;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acrg
 * JD-Core Version:    0.7.0.1
 */