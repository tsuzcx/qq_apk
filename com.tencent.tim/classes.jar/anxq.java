import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.SubAccountMessage;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MSFServlet;
import mqq.app.NewIntent;
import mqq.app.Packet;
import mqq.observer.SubAccountObserver;
import tencent.im.oidb.cmd0xe34.cmd0xe34.BindUinInfo;
import tencent.im.oidb.cmd0xe34.cmd0xe34.GroupMsgUnreadNumInfo;
import tencent.im.oidb.cmd0xe34.cmd0xe34.LoginSig;
import tencent.im.oidb.cmd0xe34.cmd0xe34.ReqBody;
import tencent.im.oidb.cmd0xe34.cmd0xe34.RspBody;
import tencent.im.oidb.cmd0xe34.cmd0xe34.UnReadInfo;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class anxq
  extends MSFServlet
{
  public static NewIntent a(QQAppInterface paramQQAppInterface, String paramString)
  {
    NewIntent localNewIntent = null;
    if (paramQQAppInterface == null)
    {
      QLog.d("SubAccountServlet", 2, "app is null");
      paramQQAppInterface = localNewIntent;
      return paramQQAppInterface;
    }
    if (QLog.isColorLevel()) {
      QLog.d("SubAccountServlet", 2, "fetchOneTroopNewMsg TIME=" + System.currentTimeMillis());
    }
    Object localObject = (anxr)paramQQAppInterface.getManager(61);
    if (localObject != null) {}
    for (localObject = ((anxr)localObject).getA2(paramString);; localObject = null)
    {
      if ((!TextUtils.isEmpty(paramString)) && (!TextUtils.isEmpty((CharSequence)localObject)))
      {
        localNewIntent = new NewIntent(paramQQAppInterface.getApplication(), anxq.class);
        localNewIntent.putExtra("key_type", 1);
        localNewIntent.putExtra("key_appid", AppSetting.getAppId());
        ArrayList localArrayList1 = new ArrayList(1);
        localArrayList1.add(paramString);
        ArrayList localArrayList2 = new ArrayList(1);
        localArrayList2.add(localObject);
        localNewIntent.putStringArrayListExtra("key_sub_account", localArrayList1);
        localNewIntent.putStringArrayListExtra("key_sub_acc_sig", localArrayList2);
        paramQQAppInterface.startServlet(localNewIntent);
        paramQQAppInterface = localNewIntent;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("SubAccountServlet", 2, new Object[] { "fetchOneTroopNewMsg uin:", paramString });
        return localNewIntent;
      }
      paramQQAppInterface = localNewIntent;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("SubAccountServlet", 2, new Object[] { "fetchOneTroopNewMsg uin:", paramString, " no login sig" });
      return null;
    }
  }
  
  public void R(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    boolean bool3 = paramFromServiceMsg.isSuccess();
    boolean bool2 = false;
    Bundle localBundle = new Bundle();
    boolean bool1 = bool2;
    Object localObject2;
    int i;
    int j;
    if (bool3)
    {
      try
      {
        Object localObject1 = aqnv.J(paramFromServiceMsg.getWupBuffer());
        localObject2 = new oidb_sso.OIDBSSOPkg();
        ((oidb_sso.OIDBSSOPkg)localObject2).mergeFrom((byte[])localObject1);
        bool1 = bool2;
        if (localObject2 == null) {
          break label629;
        }
        i = ((oidb_sso.OIDBSSOPkg)localObject2).uint32_result.get();
        if ((i != 0) || (!((oidb_sso.OIDBSSOPkg)localObject2).bytes_bodybuffer.has()) || (((oidb_sso.OIDBSSOPkg)localObject2).bytes_bodybuffer.get() == null)) {
          break label650;
        }
        localObject1 = ((oidb_sso.OIDBSSOPkg)localObject2).bytes_bodybuffer.get().toByteArray();
        localObject2 = new cmd0xe34.RspBody();
        ((cmd0xe34.RspBody)localObject2).mergeFrom((byte[])localObject1);
        anxk.aob = ((cmd0xe34.RspBody)localObject2).ReqInterval.get();
        localObject1 = ((cmd0xe34.RspBody)localObject2).rpt_unread_info.get();
        if ((localObject1 == null) || (((List)localObject1).size() <= 0)) {
          break label632;
        }
        i = 0;
        if (i >= ((List)localObject1).size()) {
          break label626;
        }
        localObject2 = (cmd0xe34.UnReadInfo)((List)localObject1).get(i);
        l = ((cmd0xe34.UnReadInfo)localObject2).uint64_uin.get();
        j = ((cmd0xe34.UnReadInfo)localObject2).retcode.get();
        localObject3 = (cmd0xe34.GroupMsgUnreadNumInfo)((cmd0xe34.UnReadInfo)localObject2).group_info.get();
        localBundle.putInt("key_new_msg_time", ((cmd0xe34.GroupMsgUnreadNumInfo)localObject3).last_msg_time.get());
        if (!QLog.isColorLevel()) {
          break label710;
        }
        QLog.d("SubAccountServlet", 2, new Object[] { "subAccount:", Long.valueOf(l), " msg_num:", Integer.valueOf(((cmd0xe34.GroupMsgUnreadNumInfo)localObject3).msg_num.get()), " group_num:", Integer.valueOf(((cmd0xe34.GroupMsgUnreadNumInfo)localObject3).group_num.get()), " last_msg_time:", Integer.valueOf(((cmd0xe34.GroupMsgUnreadNumInfo)localObject3).last_msg_time.get()), " fetchTroopMsgInterval:", Long.valueOf(anxk.aob), " retCode:", Integer.valueOf(j) });
      }
      catch (Exception paramFromServiceMsg)
      {
        long l;
        Object localObject3;
        label365:
        QLog.d("SubAccountServlet", 2, paramFromServiceMsg.toString());
        bool1 = false;
      }
      localObject2 = new SubAccountMessage();
      ((SubAccountMessage)localObject2).frienduin = String.valueOf(13002L);
      if (((cmd0xe34.GroupMsgUnreadNumInfo)localObject3).msg_num.get() > 0) {}
      for (j = 1;; j = 0)
      {
        ((SubAccountMessage)localObject2).unreadNum = j;
        ((SubAccountMessage)localObject2).msgtype = -1000;
        ((SubAccountMessage)localObject2).time = ((cmd0xe34.GroupMsgUnreadNumInfo)localObject3).last_msg_time.get();
        ((SubAccountMessage)localObject2).senderuin = String.valueOf(13002L);
        ((SubAccountMessage)localObject2).subUin = String.valueOf(l);
        ((SubAccountMessage)localObject2).istroop = 1;
        ((SubAccountMessage)localObject2).sendername = "群聊消息";
        ((SubAccountMessage)localObject2).msg = "";
        localObject3 = (anxr)getAppRuntime().getManager(61);
        if (localObject3 != null)
        {
          ((anxr)localObject3).a((SubAccountMessage)localObject2);
          ((anxr)localObject3).b((SubAccountMessage)localObject2);
          ((anxr)localObject3).Rz(((SubAccountMessage)localObject2).subUin);
        }
        localObject2 = new anxs();
        ((anxs)localObject2).aLa = paramFromServiceMsg.getUin();
        ((anxs)localObject2).aQf = String.valueOf(l);
        ((anxs)localObject2).cKB = true;
        ((anxs)localObject2).cKC = true;
        ((anxs)localObject2).errorType = 0;
        if (!(getAppRuntime() instanceof QQAppInterface)) {
          break;
        }
        ((QQAppInterface)getAppRuntime()).a().notifyUI(8003, true, localObject2);
        break;
        label606:
        notifyObserver(paramIntent, 1, bool1, localBundle, SubAccountObserver.class);
        return;
      }
      label626:
      bool1 = true;
    }
    for (;;)
    {
      label629:
      break label606;
      label632:
      if (QLog.isColorLevel())
      {
        QLog.d("SubAccountServlet", 2, "unReadInfos is empty");
        break label722;
        bool1 = bool2;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("SubAccountServlet", 2, new Object[] { "result:", Integer.valueOf(i), " hasBody:", Boolean.valueOf(((oidb_sso.OIDBSSOPkg)localObject2).bytes_bodybuffer.has()) });
        bool1 = bool2;
        continue;
        if (j == 0) {
          break label365;
        }
        i += 1;
        break;
      }
      label650:
      label710:
      label722:
      bool1 = false;
    }
  }
  
  public void o(Intent paramIntent, Packet paramPacket)
  {
    Object localObject1 = paramIntent.getStringArrayListExtra("key_sub_account");
    ArrayList localArrayList = paramIntent.getStringArrayListExtra("key_sub_acc_sig");
    if ((localObject1 == null) || (((ArrayList)localObject1).size() == 0) || (localArrayList == null) || (localArrayList.size() == 0)) {
      QLog.e("SubAccountServlet", 2, "subaccountuins is empty");
    }
    do
    {
      return;
      if (localArrayList.size() != ((ArrayList)localObject1).size())
      {
        QLog.e("SubAccountServlet", 2, "uin and sig size not right");
        return;
      }
      int j = paramIntent.getIntExtra("key_appid", -1);
      paramIntent = new cmd0xe34.ReqBody();
      int i = 0;
      for (;;)
      {
        if (i < ((ArrayList)localObject1).size())
        {
          Object localObject2 = (String)((ArrayList)localObject1).get(i);
          cmd0xe34.BindUinInfo localBindUinInfo = new cmd0xe34.BindUinInfo();
          localBindUinInfo.uint32_app_id.set(1001);
          localBindUinInfo.uint32_instance_id.set(j);
          try
          {
            long l = Long.parseLong((String)localObject2);
            localBindUinInfo.uint64_uin.set(l);
            localObject2 = new cmd0xe34.LoginSig();
            ((cmd0xe34.LoginSig)localObject2).uint32_appid.set(16);
            ((cmd0xe34.LoginSig)localObject2).uint32_type.set(8);
            if (!TextUtils.isEmpty((CharSequence)localArrayList.get(i))) {
              ((cmd0xe34.LoginSig)localObject2).bytes_sig.set(ByteStringMicro.copyFrom(aqoj.ag((String)localArrayList.get(i))));
            }
            localBindUinInfo.msg_login_sig.set((MessageMicro)localObject2);
            paramIntent.rpt_bind_uin_info.add(localBindUinInfo);
            i += 1;
          }
          catch (Exception localException)
          {
            for (;;)
            {
              QLog.e("SubAccountServlet", 2, localException.toString());
            }
          }
        }
      }
      localObject1 = new oidb_sso.OIDBSSOPkg();
      ((oidb_sso.OIDBSSOPkg)localObject1).uint32_command.set(3636);
      ((oidb_sso.OIDBSSOPkg)localObject1).uint32_service_type.set(1);
      ((oidb_sso.OIDBSSOPkg)localObject1).bytes_bodybuffer.set(ByteStringMicro.copyFrom(paramIntent.toByteArray()));
      paramPacket.setSSOCommand("OidbSvc.0xe34_1");
      paramPacket.putSendData(aqnv.I(((oidb_sso.OIDBSSOPkg)localObject1).toByteArray()));
    } while (!QLog.isColorLevel());
    QLog.d("SubAccountServlet", 2, "onSendFetchTroopNewMsg");
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    switch (paramIntent.getIntExtra("key_type", 0))
    {
    default: 
      return;
    }
    R(paramIntent, paramFromServiceMsg);
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    switch (paramIntent.getIntExtra("key_type", 0))
    {
    default: 
      return;
    }
    o(paramIntent, paramPacket);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anxq
 * JD-Core Version:    0.7.0.1
 */