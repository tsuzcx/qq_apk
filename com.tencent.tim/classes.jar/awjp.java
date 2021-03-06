import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatSettingActivity;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.utils.FriendsStatusUtil;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.HWTroopMemberCard;
import com.tencent.mobileqq.data.MessageForLongMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.SpecialCareInfo;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.pluginsdk.ipc.RemoteCommand;
import com.tencent.mobileqq.pluginsdk.ipc.RemoteCommand.OnInvokeFinishLinstener;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.manager.ServerConfigManager.ConfigType;
import mqq.os.MqqHandler;

public class awjp
  extends RemoteCommand
{
  QQAppInterface mApp;
  
  public awjp(QQAppInterface paramQQAppInterface)
  {
    super("troop.troopmemcard.get_app_interface_data");
    this.mApp = paramQQAppInterface;
  }
  
  public Bundle b(Bundle paramBundle, RemoteCommand.OnInvokeFinishLinstener paramOnInvokeFinishLinstener)
  {
    paramOnInvokeFinishLinstener = paramBundle.getString("troopUin");
    String str2 = paramBundle.getString("memUin");
    paramBundle = this.mApp.b().i(paramOnInvokeFinishLinstener, 1, 100);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("chatmsg:");
    if (!TextUtils.isEmpty(str2)) {}
    for (int i = 10;; i = 20)
    {
      Iterator localIterator = paramBundle.iterator();
      int j = 0;
      MessageRecord localMessageRecord;
      do
      {
        if (localIterator.hasNext())
        {
          localMessageRecord = (MessageRecord)localIterator.next();
          if (j <= i) {}
        }
        else
        {
          paramBundle = "";
        }
        try
        {
          paramOnInvokeFinishLinstener = URLEncoder.encode(localStringBuilder.toString(), "UTF-8");
          paramBundle = paramOnInvokeFinishLinstener;
        }
        catch (Throwable paramOnInvokeFinishLinstener)
        {
          for (;;)
          {
            String str1;
            paramOnInvokeFinishLinstener.printStackTrace();
          }
        }
        paramOnInvokeFinishLinstener = new Bundle();
        paramOnInvokeFinishLinstener.putString("msgtoupload", paramBundle);
        return paramOnInvokeFinishLinstener;
      } while ((localMessageRecord == null) || ((!TextUtils.isEmpty(str2)) && (!TextUtils.equals(localMessageRecord.senderuin, str2))));
      if ((localMessageRecord instanceof MessageForPic)) {
        paramOnInvokeFinishLinstener = ((MessageForPic)localMessageRecord).uuid;
      }
      for (str1 = "2";; str1 = "1")
      {
        paramBundle = paramOnInvokeFinishLinstener;
        try
        {
          paramOnInvokeFinishLinstener = paramOnInvokeFinishLinstener.replace("\"", "\\\"");
          paramBundle = paramOnInvokeFinishLinstener;
          paramOnInvokeFinishLinstener = paramOnInvokeFinishLinstener.replace("'", "\\'");
          paramBundle = paramOnInvokeFinishLinstener;
          paramOnInvokeFinishLinstener = paramOnInvokeFinishLinstener.replace("|", "\\|");
          paramBundle = paramOnInvokeFinishLinstener;
          paramOnInvokeFinishLinstener = paramOnInvokeFinishLinstener.replace(":", "\\:");
          paramBundle = paramOnInvokeFinishLinstener;
          paramOnInvokeFinishLinstener = paramOnInvokeFinishLinstener.replace(";", "\\;");
          paramBundle = paramOnInvokeFinishLinstener;
          paramOnInvokeFinishLinstener = paramOnInvokeFinishLinstener.replace("[", "\\[");
          paramBundle = paramOnInvokeFinishLinstener;
          paramOnInvokeFinishLinstener = paramOnInvokeFinishLinstener.replace("]", "\\]");
          paramBundle = paramOnInvokeFinishLinstener;
          paramOnInvokeFinishLinstener = paramOnInvokeFinishLinstener.replace("=", "\\=");
          paramBundle = paramOnInvokeFinishLinstener;
        }
        catch (Throwable paramOnInvokeFinishLinstener)
        {
          for (;;)
          {
            paramOnInvokeFinishLinstener.printStackTrace();
          }
        }
        localStringBuilder.append("[");
        localStringBuilder.append("uin=" + localMessageRecord.senderuin);
        localStringBuilder.append(";");
        localStringBuilder.append("content=" + paramBundle);
        localStringBuilder.append(";");
        localStringBuilder.append("type=" + str1);
        localStringBuilder.append("]");
        j += 1;
        break;
        if (((!(localMessageRecord instanceof MessageForText)) && (!(localMessageRecord instanceof MessageForLongMsg))) || (localMessageRecord.msgtype != -1000)) {
          break;
        }
        paramOnInvokeFinishLinstener = localMessageRecord.msg;
      }
    }
  }
  
  public Bundle invoke(Bundle paramBundle, RemoteCommand.OnInvokeFinishLinstener paramOnInvokeFinishLinstener)
  {
    Bundle localBundle;
    if (paramBundle == null)
    {
      localBundle = null;
      label7:
      return localBundle;
    }
    int i;
    Object localObject2;
    String str1;
    for (;;)
    {
      try
      {
        i = paramBundle.getInt("req_sub_cmd");
        localBundle = new Bundle();
        switch (i)
        {
        case 1001: 
          localBundle = paramBundle;
          if (paramOnInvokeFinishLinstener == null) {
            break label7;
          }
          paramOnInvokeFinishLinstener.onInvokeFinish(paramBundle);
          return paramBundle;
        }
      }
      catch (Exception paramBundle)
      {
        if (QLog.isColorLevel()) {
          QLog.d("TroopMemCardCmd", 2, "invoke Exception hanppend! ExceptionClass = + " + paramBundle.getClass().getName() + "msg = " + paramBundle.getMessage());
        }
        anot.a(this.mApp, "P_CliOper", "BizTechReport", "", "troop_member_card_plugin", "plugin_cmd_exp", 0, 0, paramBundle.getClass().getName(), null, null, null);
        return null;
      }
      paramBundle = b(paramBundle, paramOnInvokeFinishLinstener);
      continue;
      paramBundle = (TroopInfo)paramBundle.getSerializable("troopInfo");
      ((TroopManager)this.mApp.getManager(52)).i(paramBundle);
      paramBundle = localBundle;
      continue;
      paramBundle = paramBundle.getString("troopUin");
      localBundle.putSerializable("troopInfo", ((TroopManager)this.mApp.getManager(52)).b(paramBundle));
      paramBundle = localBundle;
      continue;
      localObject1 = paramBundle.getString("troopUin");
      paramBundle = paramBundle.getString("memUin");
      localBundle.putSerializable("card", ((TroopManager)this.mApp.getManager(52)).a((String)localObject1, paramBundle));
      paramBundle = localBundle;
      continue;
      localObject1 = paramBundle.getString("troopUin");
      localObject2 = paramBundle.getString("memUin");
      paramBundle = (HWTroopMemberCard)paramBundle.getSerializable("card");
      ((TroopManager)this.mApp.getManager(52)).a((String)localObject1, (String)localObject2, paramBundle);
      paramBundle = localBundle;
      continue;
      localObject1 = paramBundle.getString("troopUin");
      localObject2 = paramBundle.getString("memUin");
      byte b = paramBundle.getByte("flag");
      localBundle.putBoolean("result", ((TroopManager)this.mApp.getManager(52)).a((String)localObject1, (String)localObject2, b));
      paramBundle = localBundle;
      continue;
      localObject1 = paramBundle.getString("troopUin");
      localObject2 = paramBundle.getString("memUin");
      str1 = paramBundle.getString("uniqueTitle");
      i = paramBundle.getInt("uniqueTitleExpire");
      ((TroopManager)this.mApp.getManager(52)).n((String)localObject1, (String)localObject2, str1, i);
      paramBundle = localBundle;
      continue;
      paramBundle = paramBundle.getString("troopCode");
      localObject1 = (TroopManager)this.mApp.getManager(52);
      this.mApp.b().N(paramBundle, 1);
      ((TroopManager)localObject1).Fr(paramBundle);
      aqgx.a().a(this.mApp, paramBundle, this.mApp.getCurrentAccountUin(), this.mApp.getApp());
      paramBundle = localBundle;
      continue;
      localObject1 = paramBundle.getString("key");
      paramBundle = (ServerConfigManager.ConfigType)paramBundle.getSerializable("type");
      localBundle.putString("result", this.mApp.a(paramBundle, (String)localObject1));
      paramBundle = localBundle;
      continue;
      paramBundle = paramBundle.getString("uin");
      localObject1 = (acff)this.mApp.getManager(51);
      localObject2 = ((acff)localObject1).b(paramBundle);
      if ((localObject2 == null) || (!((Friends)localObject2).isFriend())) {
        break label1375;
      }
      paramBundle = ((acff)localObject1).a(paramBundle);
      if ((paramBundle == null) || (paramBundle.globalSwitch == 0)) {
        break label1381;
      }
      bool = true;
      label692:
      localBundle.putBoolean("is_special_care", bool);
      paramBundle = localBundle;
    }
    Object localObject1 = paramBundle.getString("uin");
    boolean bool = paramBundle.getBoolean("do_not_disturb");
    paramBundle = this.mApp;
    if (bool) {}
    for (long l1 = anaz.gQ();; l1 = 0L)
    {
      FriendsStatusUtil.a(paramBundle, (String)localObject1, 0, l1, true, false, null, true);
      paramBundle = localBundle;
      break;
      localObject1 = paramBundle.getString("uin");
      bool = paramBundle.getBoolean("is_gather");
      paramBundle = (FriendListHandler)this.mApp.getBusinessHandler(1);
      localObject2 = new ArrayList();
      ((ArrayList)localObject2).add(localObject1);
      paramBundle.a((short)1, (List)localObject2, bool, true);
      paramBundle = localBundle;
      break;
      paramBundle = paramBundle.getString("uin");
      ((FriendListHandler)this.mApp.getBusinessHandler(1)).d(paramBundle, (byte)2);
      localObject1 = this.mApp.getHandler(ChatActivity.class);
      if (localObject1 != null) {
        ((MqqHandler)localObject1).sendMessage(((MqqHandler)localObject1).obtainMessage(16711681, paramBundle));
      }
      localObject1 = this.mApp.getHandler(ChatSettingActivity.class);
      if (localObject1 != null) {
        ((MqqHandler)localObject1).sendMessage(((MqqHandler)localObject1).obtainMessage(16711681, paramBundle));
      }
      if (aqft.rj(paramBundle)) {
        anot.a(this.mApp, "dc00898", "", "", "0X8007FDF", "0X8007FDF", 0, 0, "", "", "", "");
      }
      localObject1 = new Intent("ACTION_DELETE_FRIEND");
      ((Intent)localObject1).putExtra("KEY_DELETE_FRIEND_UIN", paramBundle);
      BaseApplicationImpl.getContext().sendBroadcast((Intent)localObject1);
      paramBundle = localBundle;
      break;
      localObject1 = paramBundle.getString("troopUin");
      paramBundle = paramBundle.getStringArrayList("memberUins");
      ((TroopManager)this.mApp.getManager(52)).aC((String)localObject1, (String)paramBundle.get(0));
      paramBundle = localBundle;
      break;
      localObject1 = paramBundle.getString("troopUin");
      localObject2 = paramBundle.getString("memberUin");
      str1 = paramBundle.getString("troopNick");
      i = paramBundle.getInt("level");
      String str2 = paramBundle.getString("friendNick");
      String str3 = paramBundle.getString("troopRemark");
      int j = paramBundle.getInt("age");
      int k = paramBundle.getInt("sex");
      int m = paramBundle.getInt("distance");
      l1 = paramBundle.getLong("msgseq");
      long l2 = paramBundle.getLong("gagTimeStamp");
      ((TroopManager)this.mApp.getManager(52)).a((String)localObject1, (String)localObject2, str1, i, str2, str3, j, k, m, l1, l2);
      paramBundle = localBundle;
      break;
      paramBundle = paramBundle.getString("troopUin");
      ((acms)this.mApp.getBusinessHandler(20)).Fc(paramBundle);
      paramBundle = localBundle;
      break;
      paramBundle = paramBundle.getString("troopUin");
      ((acms)this.mApp.getBusinessHandler(20)).Fb(paramBundle);
      paramBundle = localBundle;
      break;
      localObject1 = paramBundle.getString("uin");
      paramBundle = "";
      localObject1 = ajnn.a(this.mApp, (String)localObject1, false);
      if (localObject1 != null)
      {
        if (((ajoh)localObject1).type == 1L) {
          paramBundle = this.mApp.getApp().getString(2131695048);
        }
        for (;;)
        {
          i = ((ajoh)localObject1).iconResId;
          localBundle.putString("bind_name", paramBundle);
          localBundle.putInt("bind_icon", i);
          paramBundle = localBundle;
          break;
          if (((ajoh)localObject1).type == 2L) {
            paramBundle = this.mApp.getApp().getString(2131695046);
          } else if (((ajoh)localObject1).type == 3L) {
            paramBundle = this.mApp.getApp().getString(2131695047);
          }
        }
      }
      label1375:
      paramBundle = localBundle;
      break;
      label1381:
      bool = false;
      break label692;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awjp
 * JD-Core Version:    0.7.0.1
 */