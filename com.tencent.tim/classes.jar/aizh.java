import android.content.DialogInterface.OnClickListener;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Bundle;
import android.preference.PreferenceManager;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.data.TempMsgInfo;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.managers.TempMsgManager.3;
import com.tencent.mobileqq.managers.TempMsgManager.4;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.MobileQQ;
import mqq.manager.Manager;
import mqq.os.MqqHandler;

public class aizh
  implements Manager
{
  private final List<String> CM = new ArrayList();
  private aizh.a a;
  private final String[] ft = { "temp_msg_setting_consult_", "temp_msg_setting_contact_", "temp_msg_setting_interest_v2", "temp_msg_setting_nearby_", "temp_msg_setting_troop_", "temp_msg_setting_circle_v2" };
  private Map<String, Boolean> lE = new HashMap(8);
  private QQAppInterface mApp;
  private String mCurrentUin;
  private EntityManager mEntityManager;
  
  public aizh(QQAppInterface paramQQAppInterface)
  {
    this.mApp = paramQQAppInterface;
    this.mCurrentUin = paramQQAppInterface.getCurrentUin();
    this.lE.clear();
    this.mEntityManager = this.mApp.a().createEntityManager();
    dvG();
  }
  
  private DialogInterface.OnClickListener a(BaseChatPie paramBaseChatPie, short paramShort)
  {
    return new aizj(this, paramBaseChatPie, paramShort);
  }
  
  private String a(short paramShort)
  {
    switch (paramShort)
    {
    default: 
      throw new RuntimeException("getTypeStringFromType failed " + paramShort);
    case -23308: 
      return "temp_msg_setting_troop_";
    case -23309: 
      return "temp_msg_setting_consult_";
    case -23310: 
      return "temp_msg_setting_contact_";
    case -23166: 
      return "temp_msg_setting_interest_v2";
    case -23312: 
      return "temp_msg_setting_nearby_";
    }
    return "temp_msg_setting_circle_v2";
  }
  
  private void a(SessionInfo paramSessionInfo, short paramShort, String paramString, int paramInt, BaseChatPie paramBaseChatPie)
  {
    if (!ng(a(paramShort)))
    {
      paramSessionInfo = String.format(this.mApp.getApplication().getResources().getString(2131720981), new Object[] { paramString, paramString });
      paramSessionInfo = aqha.a(paramBaseChatPie.mContext, 230, acfp.m(2131715215), paramSessionInfo, 2131720979, 2131720980, a(paramBaseChatPie, paramShort), a(paramBaseChatPie, paramShort));
      paramSessionInfo.setOnCancelListener(new aizi(this, paramBaseChatPie));
      paramSessionInfo.setCanceledOnTouchOutside(false);
      paramSessionInfo.show();
      anot.a(this.mApp, "dc00898", "", "", "0X8009977", "0X8009977", b(paramShort), b(paramShort), "", "", "", "");
    }
    while ((!h(paramSessionInfo)) || (!a(a(paramShort), paramSessionInfo))) {
      return;
    }
    a(paramSessionInfo, paramString, paramInt, paramShort);
  }
  
  private boolean ad(String paramString, int paramInt)
  {
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.mApp.getApplication());
    boolean bool1 = nh(paramString);
    if (paramInt == 0) {
      bool1 = localSharedPreferences.getBoolean(paramString + this.mCurrentUin + "_setting", bool1);
    }
    boolean bool2;
    do
    {
      return bool1;
      if (paramInt != 1) {
        break;
      }
      bool2 = localSharedPreferences.getBoolean(paramString + this.mCurrentUin + "_show", bool1);
      bool1 = bool2;
    } while (!bool2);
    localSharedPreferences.edit().putBoolean(paramString + this.mCurrentUin + "_show", false).apply();
    return bool2;
    return false;
  }
  
  private void dvG()
  {
    this.CM.add("temp_msg_setting_interest_v2");
    this.CM.add("temp_msg_setting_circle_v2");
  }
  
  private int e(SessionInfo paramSessionInfo)
  {
    Object localObject = this.mApp.b().f(paramSessionInfo.aTl, paramSessionInfo.cZ);
    if ((1000 == paramSessionInfo.cZ) || (1004 == paramSessionInfo.cZ) || (1022 == paramSessionInfo.cZ)) {}
    for (localObject = ChatActivityUtils.b((List)localObject, paramSessionInfo, this.mApp); localObject == null; localObject = ChatActivityUtils.a((List)localObject, paramSessionInfo, this.mApp)) {
      return paramSessionInfo.cZ;
    }
    return ((MessageRecord)localObject).istroop;
  }
  
  private boolean h(SessionInfo paramSessionInfo)
  {
    paramSessionInfo = this.mApp.b().f(paramSessionInfo.aTl, paramSessionInfo.cZ);
    int i;
    ChatMessage localChatMessage;
    if (paramSessionInfo.size() > 0)
    {
      i = paramSessionInfo.size();
      paramSessionInfo = paramSessionInfo.iterator();
      if (!paramSessionInfo.hasNext()) {
        break label151;
      }
      localChatMessage = (ChatMessage)paramSessionInfo.next();
      if (!localChatMessage.isSend()) {}
    }
    else
    {
      return false;
    }
    if (localChatMessage.senderuin == null) {
      i -= 1;
    }
    for (;;)
    {
      break;
      if (localChatMessage.senderuin.compareTo(this.mApp.getCurrentUin()) == 0) {
        i -= 1;
      } else if (localChatMessage.msgtype == -1034) {
        i -= 1;
      } else if (QLog.isColorLevel()) {
        QLog.d("TempMsgManager", 2, localChatMessage.toString());
      }
    }
    label151:
    if (i > 0) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private boolean nh(String paramString)
  {
    return !this.CM.contains(paramString);
  }
  
  public void a(aizh.a parama)
  {
    this.a = parama;
  }
  
  public void a(SessionInfo paramSessionInfo, BaseChatPie paramBaseChatPie)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TempMsgManager", 2, "onEnterChat" + paramSessionInfo.cZ);
    }
    int j = paramSessionInfo.cZ;
    int i = j;
    if (j == 1000) {
      i = e(paramSessionInfo);
    }
    switch (i)
    {
    case 1004: 
    case 1009: 
    case 1010: 
    case 1020: 
    case 1024: 
    case 1025: 
    case 10004: 
    default: 
      return;
    case 1000: 
      a(paramSessionInfo, (short)-23308, acfp.m(2131715214), i, paramBaseChatPie);
      return;
    case 1006: 
      a(paramSessionInfo, (short)-23310, acfp.m(2131715212), i, paramBaseChatPie);
      return;
    case 1001: 
    case 1003: 
      a(paramSessionInfo, (short)-23312, acfp.m(2131715211), i, paramBaseChatPie);
      return;
    case 10002: 
      a(paramSessionInfo, (short)-23166, acfp.m(2131715213), i, paramBaseChatPie);
      return;
    case 1005: 
      a(paramSessionInfo, (short)-23309, "QQ咨询", i, paramBaseChatPie);
      return;
    }
    a(paramSessionInfo, (short)-23168, acfp.m(2131720731), i, paramBaseChatPie);
  }
  
  public void a(SessionInfo paramSessionInfo, String paramString, int paramInt, short paramShort)
  {
    Object localObject;
    if (paramInt == 1000)
    {
      paramString = aqgv.F(this.mApp, paramSessionInfo.aTm);
      String str = aqgv.a(this.mApp, paramSessionInfo.aTm, true);
      if (QLog.isColorLevel()) {
        QLog.d("TempMsgManager", 2, "getTroopNickName:" + paramString + " new From:" + str);
      }
      paramString = String.format(this.mApp.getApplication().getResources().getString(2131720986), new Object[] { str });
      localObject = new ahwa(paramSessionInfo.aTl, this.mApp.getCurrentAccountUin(), paramString, paramSessionInfo.cZ, -5023, 655381, anaz.gQ());
      Bundle localBundle = new Bundle();
      localBundle.putInt("key_action", 39);
      localBundle.putString("textColor", "");
      localBundle.putString("image_resource", null);
      localBundle.putString("key_action_DATA", paramSessionInfo.aTm);
      ((ahwa)localObject).addHightlightItem(5, str.length() + 5, localBundle);
      paramSessionInfo = new Bundle();
      paramSessionInfo.putInt("key_action", 38);
      paramSessionInfo.putString("textColor", "");
      paramSessionInfo.putString("image_resource", null);
      paramSessionInfo.putString("key_action_DATA", b(paramShort) + "");
      ((ahwa)localObject).addHightlightItem(paramString.length() - 5, paramString.length() - 1, paramSessionInfo);
      paramSessionInfo = (SessionInfo)localObject;
    }
    for (;;)
    {
      localObject = new MessageForUniteGrayTip();
      ((MessageForUniteGrayTip)localObject).initGrayTipMsg(this.mApp, paramSessionInfo);
      ahwb.a(this.mApp, (MessageForUniteGrayTip)localObject);
      if (QLog.isColorLevel()) {
        QLog.d("TempMsgManager", 2, "add gray tip =" + paramString);
      }
      return;
      paramString = String.format(this.mApp.getApplication().getResources().getString(2131720985), new Object[] { paramString });
      paramSessionInfo = new ahwa(paramSessionInfo.aTl, this.mApp.getCurrentAccountUin(), paramString, paramSessionInfo.cZ, -5023, 655381, anaz.gQ());
      localObject = new Bundle();
      ((Bundle)localObject).putInt("key_action", 38);
      ((Bundle)localObject).putString("textColor", "");
      ((Bundle)localObject).putString("image_resource", null);
      ((Bundle)localObject).putString("key_action_DATA", b(paramShort) + "");
      paramSessionInfo.addHightlightItem(paramString.length() - 5, paramString.length() - 1, (Bundle)localObject);
    }
  }
  
  public void a(short paramShort, boolean paramBoolean1, String paramString, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TempMsgManager", 2, "onSetResult t=" + paramShort + " result=" + paramBoolean1 + " fm=" + paramString + " value=" + paramBoolean2);
    }
    if (!paramBoolean1)
    {
      b(paramShort, paramBoolean2, false);
      if (!aqmr.isEmpty(paramString)) {
        ThreadManager.getUIHandler().post(new TempMsgManager.3(this, paramString));
      }
    }
    ThreadManager.getUIHandler().post(new TempMsgManager.4(this, paramShort, paramBoolean1));
  }
  
  public boolean a(String paramString, SessionInfo paramSessionInfo)
  {
    try
    {
      if ((this.mEntityManager.find(TempMsgInfo.class, paramString + paramSessionInfo.aTl) instanceof TempMsgInfo)) {
        return false;
      }
      if (QLog.isColorLevel()) {
        QLog.d("TempMsgManager", 2, "can't tempMsgInfo, insert a new tempMsgInfo! type=" + paramString + "curFriendUin=" + paramSessionInfo.aTl);
      }
      this.mEntityManager.persist(new TempMsgInfo(paramString + paramSessionInfo.aTl, System.currentTimeMillis()));
      return true;
    }
    finally {}
  }
  
  public boolean a(short paramShort)
  {
    String str = a(paramShort);
    return this.CM.contains(str);
  }
  
  public Map<String, Boolean> aq()
  {
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.mApp.getApplication());
    String[] arrayOfString = this.ft;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str = arrayOfString[i];
      if (!this.lE.containsKey(str))
      {
        boolean bool = nh(str);
        this.lE.put(str, Boolean.valueOf(localSharedPreferences.getBoolean(str + this.mCurrentUin + "_setting", bool)));
      }
      i += 1;
    }
    return this.lE;
  }
  
  public int b(short paramShort)
  {
    switch (paramShort)
    {
    default: 
      return 0;
    case -23308: 
      return 1;
    case -23309: 
      return 5;
    case -23310: 
      return 4;
    case -23166: 
      return 3;
    case -23312: 
      return 2;
    }
    return 6;
  }
  
  public void b(short paramShort, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TempMsgManager", 2, "changeSetting t=" + paramShort + " s=" + paramBoolean1 + "sync=" + paramBoolean2);
    }
    Object localObject = a(paramShort);
    if (this.lE.containsKey(localObject))
    {
      this.lE.remove(localObject);
      this.lE.put(localObject, Boolean.valueOf(paramBoolean1));
      PreferenceManager.getDefaultSharedPreferences(this.mApp.getApplication()).edit().putBoolean((String)localObject + this.mCurrentUin + "_setting", paramBoolean1).apply();
      if (paramBoolean2)
      {
        localObject = (CardHandler)this.mApp.getBusinessHandler(2);
        if (localObject != null) {
          if (paramBoolean1) {
            break label210;
          }
        }
      }
    }
    label210:
    for (paramBoolean1 = true;; paramBoolean1 = false)
    {
      ((CardHandler)localObject).a(paramShort, paramBoolean1);
      return;
      this.lE.put(localObject, Boolean.valueOf(paramBoolean1));
      break;
    }
  }
  
  public boolean ng(String paramString)
  {
    if (this.lE.containsKey(paramString)) {
      return ((Boolean)this.lE.get(paramString)).booleanValue();
    }
    boolean bool = ad(paramString, 0);
    this.lE.put(paramString, Boolean.valueOf(bool));
    return bool;
  }
  
  public void onDestroy()
  {
    this.mApp = null;
    this.a = null;
    if (this.mEntityManager != null) {
      this.mEntityManager.close();
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(short paramShort, boolean paramBoolean1, boolean paramBoolean2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aizh
 * JD-Core Version:    0.7.0.1
 */