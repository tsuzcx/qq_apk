import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.commonsdk.util.HexUtil;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import eipc.EIPCResult;
import eipc.EIPCServer;

public class axyl
{
  public static void a(String paramString1, ayrk paramayrk, String paramString2, String paramString3)
  {
    if (paramayrk == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("PeakIpcController", 2, "sendPhoto editVideoInfo is null");
      }
      return;
    }
    paramayrk.uniseq = 0L;
    Object localObject = HexUtil.bytes2HexStr(ahav.t(paramString1));
    if (localObject == null)
    {
      QLog.e("PeakIpcController", 1, "sendPic file md5 fail!");
      return;
    }
    paramayrk.fileMd5 = ((String)localObject);
    localObject = new SessionInfo();
    ((SessionInfo)localObject).aTl = paramayrk.uin;
    ((SessionInfo)localObject).cZ = paramayrk.messageType;
    ((SessionInfo)localObject).troopUin = paramayrk.troopUin;
    paramayrk = new Bundle();
    paramayrk.putParcelable("key_session", (Parcelable)localObject);
    paramayrk.putString("key_file_path", paramString1);
    paramayrk.putString("widgetinfo", paramString2);
    paramayrk.putString("key_camera_material_name", paramString3);
    axiy.i("PeakIpcController", "sendPhoto---takeSameName=" + paramString3);
    QIPCClientHelper.getInstance().callServer("PeakIpcModuleServer", "action_pic_start_send", paramayrk, new axyo());
  }
  
  public static void a(String paramString1, String paramString2, ayrk paramayrk, String paramString3, String paramString4)
  {
    axiy.i("PeakIpcController", "sendVideo---takeSameName=" + paramString4);
    paramayrk.uniseq = 0L;
    paramString1 = ayja.a(paramString1, paramString2, paramayrk, paramString3, paramString4);
    paramString2 = new Bundle();
    paramString2.putParcelable("key_intent", paramString1);
    QIPCClientHelper.getInstance().callServer("PeakIpcModuleServer", "action_start_send", paramString2, new axym());
  }
  
  public static void b(ayrk paramayrk)
  {
    if (QLog.isColorLevel()) {
      QLog.i("PeakIpcController", 2, "cancelSendVideoOrPhoto uinseq:" + paramayrk.uniseq);
    }
    Bundle localBundle = new Bundle();
    localBundle.putLong("key_uinsequence", paramayrk.uniseq);
    localBundle.putString("uin", paramayrk.uin);
    localBundle.putInt("uintype", paramayrk.messageType);
    QIPCClientHelper.getInstance().callServer("PeakIpcModuleServer", "action_cancel_send", localBundle, new axyn(paramayrk));
  }
  
  public static void c(ayrk paramayrk)
  {
    if (paramayrk == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("PeakIpcController", 2, "reSendMessage editVideoInfo is null");
      }
      return;
    }
    if (paramayrk.uniseq <= 0L)
    {
      QLog.e("PeakIpcController", 1, "reSendMessage error!");
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putLong("key_uinsequence", paramayrk.uniseq);
    localBundle.putString("uin", paramayrk.uin);
    localBundle.putInt("uintype", paramayrk.messageType);
    QIPCClientHelper.getInstance().callServer("PeakIpcModuleServer", "action_re_send", localBundle, new axyp());
  }
  
  public static void d(MessageRecord paramMessageRecord, int paramInt1, int paramInt2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("key_status", paramInt1);
    localBundle.putInt("key_progress", paramInt2);
    localBundle.putLong("key_uinsequence", paramMessageRecord.uniseq);
    localBundle.putString("uin", paramMessageRecord.frienduin);
    localBundle.putInt("uintype", paramMessageRecord.istroop);
    if ((paramMessageRecord instanceof MessageForShortVideo)) {
      localBundle.putString("key_file_md5", ((MessageForShortVideo)paramMessageRecord).md5);
    }
    for (;;)
    {
      paramMessageRecord = QIPCServerHelper.getInstance().getServer().callClient("com.tencent.mobileqq:peak", 1, "PeakIpcModuleClient", "action_update_status", localBundle);
      boolean bool2 = false;
      boolean bool1 = bool2;
      if (paramMessageRecord != null)
      {
        bool1 = bool2;
        if (paramMessageRecord.data != null) {
          bool1 = paramMessageRecord.data.getBoolean("key_result");
        }
      }
      if (QLog.isColorLevel()) {
        QLog.i("PeakIpcController", 2, "client result:" + bool1);
      }
      return;
      if ((paramMessageRecord instanceof MessageForPic)) {
        localBundle.putString("key_file_md5", ((MessageForPic)paramMessageRecord).md5);
      }
    }
  }
  
  public static String dy(String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("uin", paramString);
    paramString = QIPCClientHelper.getInstance().callServer("PeakIpcModuleServer", "action_get_name", localBundle);
    if ((paramString != null) && (paramString.isSuccess()) && (paramString.data != null))
    {
      paramString = paramString.data.getString("uinname");
      if (QLog.isColorLevel()) {
        QLog.i("PeakIpcController", 2, "getFriendName success name = " + paramString);
      }
      return paramString;
    }
    return null;
  }
  
  public static Pair<Boolean, Boolean> i(String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("troop_uin", paramString);
    paramString = QIPCClientHelper.getInstance().callServer("PeakIpcModuleServer", "action_get_troop_info", localBundle);
    if ((paramString != null) && (paramString.isSuccess()) && (paramString.data != null)) {
      return new Pair(Boolean.valueOf(paramString.data.getBoolean("troop_owner")), Boolean.valueOf(paramString.data.getBoolean("troop_code")));
    }
    return null;
  }
  
  public static void jS(String paramString1, String paramString2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("troop_uin", paramString1);
    localBundle.putString("uin", paramString2);
    QIPCClientHelper.getInstance().callServer("PeakIpcModuleServer", "action_get_troop_member_name", localBundle, new axyq(paramString2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     axyl
 * JD-Core Version:    0.7.0.1
 */