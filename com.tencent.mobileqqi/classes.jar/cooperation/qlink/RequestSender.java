package cooperation.qlink;

import android.os.Bundle;

public class RequestSender
{
  public static Bundle a(long paramLong, QLAndQQStructDef.QQ2QlMsgRecord paramQQ2QlMsgRecord)
  {
    Bundle localBundle = new Bundle();
    localBundle.putLong("param.sessionid", paramLong);
    localBundle.putSerializable("param.msgrecord", paramQQ2QlMsgRecord);
    return localBundle;
  }
  
  public static Bundle a(long paramLong, boolean paramBoolean, QLAndQQStructDef.QQ2QlNeedDataOfMsg paramQQ2QlNeedDataOfMsg)
  {
    Bundle localBundle = new Bundle();
    localBundle.putLong("param.sessionid", paramLong);
    localBundle.putBoolean("param.isnewmsg", paramBoolean);
    localBundle.putSerializable("param.newmsgneeddata", paramQQ2QlNeedDataOfMsg);
    return localBundle;
  }
  
  public static Bundle a(String paramString1, long paramLong, String paramString2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("param.uin", paramString1);
    localBundle.putLong("param.sessionid", paramLong);
    localBundle.putString("param.filemd5", paramString2);
    return localBundle;
  }
  
  public static Bundle a(String paramString, QLAndQQStructDef.QQ2QlRecvFileInfo paramQQ2QlRecvFileInfo)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("param.uin", paramString);
    localBundle.putSerializable("param.recvfilefilenbyinfo", paramQQ2QlRecvFileInfo);
    return localBundle;
  }
  
  public static Bundle a(String paramString, QLAndQQStructDef.QQ2QlSendFileInfo paramQQ2QlSendFileInfo)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("param.uin", paramString);
    localBundle.putSerializable("param.sendfilefileinfo", paramQQ2QlSendFileInfo);
    return localBundle;
  }
  
  public static Bundle a(String paramString, QLAndQQStructDef.QQ2QlSendFileInfos paramQQ2QlSendFileInfos)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("param.uin", paramString);
    localBundle.putSerializable("param.sendfilefileinfos", paramQQ2QlSendFileInfos);
    return localBundle;
  }
  
  public static Bundle a(String paramString1, String paramString2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("param.uin", paramString1);
    localBundle.putSerializable("param.headpath", paramString2);
    return localBundle;
  }
  
  public static Bundle a(String paramString, boolean paramBoolean)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("param.uin", paramString);
    localBundle.putBoolean("param.refusemsg", paramBoolean);
    return localBundle;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     cooperation.qlink.RequestSender
 * JD-Core Version:    0.7.0.1
 */