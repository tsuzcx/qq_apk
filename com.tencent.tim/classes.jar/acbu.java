import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatSettingActivity;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.profile.like.PraiseManager;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.util.concurrent.ConcurrentHashMap;
import mqq.os.MqqHandler;

public class acbu
  extends QIPCModule
{
  private static volatile acbu jdField_a_of_type_Acbu;
  private accn jdField_a_of_type_Accn = new acbv(this);
  private Card b;
  boolean bGS = false;
  private alcn c = new alcn();
  private ConcurrentHashMap<String, Bundle> dL = new ConcurrentHashMap(10);
  
  public acbu(String paramString)
  {
    super(paramString);
    this.c.gh = new String[7];
  }
  
  private void N(String paramString1, int paramInt, String paramString2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("key_process_callback_id", paramInt);
    localBundle.putString("key_js_callback_id", paramString2);
    this.dL.put(paramString1, localBundle);
  }
  
  public static acbu a()
  {
    if (jdField_a_of_type_Acbu == null) {}
    try
    {
      if (jdField_a_of_type_Acbu == null) {
        jdField_a_of_type_Acbu = new acbu("BabyQIPCModule");
      }
      return jdField_a_of_type_Acbu;
    }
    finally {}
  }
  
  private EIPCResult a(QQAppInterface paramQQAppInterface, Bundle paramBundle)
  {
    CardHandler localCardHandler = (CardHandler)paramQQAppInterface.getBusinessHandler(2);
    int i;
    int j;
    label78:
    boolean bool;
    label230:
    long l;
    if ((localCardHandler != null) && (this.c.d != null) && (aqiw.isNetSupport(BaseApplication.getContext()))) {
      if (this.c.d.bAvailVoteCnt <= 0)
      {
        i = 1;
        if ((this.c.d.bHaveVotedCnt > 0) || (this.c.d.bAvailVoteCnt > 0)) {
          break label372;
        }
        j = 1;
        if ((i != 0) || (j != 0)) {
          break label398;
        }
        Card localCard = this.b;
        localCard.lVoteCount += 1L;
        this.b.bVoted = 1;
        localCard = this.b;
        localCard.bAvailVoteCnt = ((short)(localCard.bAvailVoteCnt - 1));
        localCardHandler.a(Long.valueOf(paramQQAppInterface.getCurrentAccountUin()).longValue(), Long.valueOf(this.c.e.uin).longValue(), this.c.d.vCookies, this.c.d.favoriteSource, 1, 0);
        bool = ((ajqh)paramQQAppInterface.getManager(207)).ct(Long.valueOf(this.c.d.uin).longValue());
        if (PraiseManager.f(paramQQAppInterface) <= 0) {
          break label383;
        }
        if (!bool) {
          break label378;
        }
        i = 3;
        anot.b(paramQQAppInterface, "CliOper", "", "", "P_prof", "Prof_good", 1, 1, i, Integer.toString(ProfileActivity.eP(this.c.e.bJa)), String.valueOf(1), paramQQAppInterface.getCurrentAccountUin(), this.c.d.uin);
        l = 0L;
      }
    }
    for (;;)
    {
      QLog.i("BabyQIPCModule", 1, "babyqWeb vote, card.bAvailVoteCnt = " + this.c.d.bAvailVoteCnt + ",card.bHaveVotedCnt = " + this.c.d.bHaveVotedCnt + ",card.strVoteLimitedNotice = " + this.c.d.strVoteLimitedNotice);
      paramBundle.putLong("key_request_zan_vote_result", l);
      return EIPCResult.createSuccessResult(paramBundle);
      i = 0;
      break;
      label372:
      j = 0;
      break label78;
      label378:
      i = 2;
      break label230;
      label383:
      if (bool)
      {
        i = 1;
        break label230;
      }
      i = 0;
      break label230;
      label398:
      l = 1L;
      continue;
      l = 2L;
    }
  }
  
  private EIPCResult a(QQAppInterface paramQQAppInterface, Bundle paramBundle, String paramString1, int paramInt, String paramString2)
  {
    if (this.c.e != null)
    {
      paramQQAppInterface = (acff)paramQQAppInterface.getManager(51);
      if (paramQQAppInterface != null) {
        break label74;
      }
    }
    label74:
    for (paramQQAppInterface = null;; paramQQAppInterface = paramQQAppInterface.e(this.c.e.uin))
    {
      if (paramQQAppInterface != null)
      {
        paramBundle.putString("friendUin", this.c.e.uin);
        paramBundle.putByte("mgid", (byte)paramQQAppInterface.groupid);
      }
      if (paramInt == -1) {
        break;
      }
      N(paramString1, paramInt, paramString2);
      return null;
    }
    return EIPCResult.createSuccessResult(paramBundle);
  }
  
  private EIPCResult b(QQAppInterface paramQQAppInterface, Bundle paramBundle)
  {
    if (aqiw.isNetSupport(BaseApplication.getContext()))
    {
      ((FriendListHandler)paramQQAppInterface.getBusinessHandler(1)).d(this.c.e.uin, (byte)2);
      MqqHandler localMqqHandler = paramQQAppInterface.getHandler(ChatActivity.class);
      if (localMqqHandler != null) {
        localMqqHandler.sendMessage(localMqqHandler.obtainMessage(16711681, this.c.e.uin));
      }
      localMqqHandler = paramQQAppInterface.getHandler(ChatSettingActivity.class);
      if (localMqqHandler != null) {
        localMqqHandler.sendMessage(localMqqHandler.obtainMessage(16711681, this.c.e.uin));
      }
      anot.a(paramQQAppInterface, "dc00898", "", "", "0X8007FDF", "0X8007FDF", 0, 0, "", "", "", "");
      return EIPCResult.createSuccessResult(paramBundle);
    }
    return EIPCResult.createResult(-102, paramBundle);
  }
  
  private EIPCResult c(QQAppInterface paramQQAppInterface, Bundle paramBundle)
  {
    acff localacff;
    if ((this.c.e != null) && (ProfileActivity.AllInOne.b(this.c.e)))
    {
      localacff = (acff)paramQQAppInterface.getManager(51);
      if (localacff != null) {
        break label104;
      }
    }
    label104:
    for (paramQQAppInterface = null;; paramQQAppInterface = localacff.e(this.c.e.uin))
    {
      if (paramQQAppInterface != null)
      {
        paramQQAppInterface = localacff.a(String.valueOf(paramQQAppInterface.groupid));
        if (paramQQAppInterface != null)
        {
          paramBundle.putString("key_handle_set_get_group", paramQQAppInterface.group_name);
          QLog.i("BabyQIPCModule", 1, "babyqWeb get group =" + paramQQAppInterface.group_name);
        }
      }
      return EIPCResult.createSuccessResult(paramBundle);
    }
  }
  
  public void a(String paramString, Bundle paramBundle, EIPCResultCallback paramEIPCResultCallback)
  {
    QIPCClientHelper.getInstance().callServer("BabyQIPCModule", paramString, paramBundle, paramEIPCResultCallback);
  }
  
  public void cHc()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BabyQIPCModule", 2, "babyqWeb callWebJSHandledSetGroup");
    }
    if (this.dL.get("setFriendGrouping") != null)
    {
      localBundle = new Bundle();
      localObject2 = (Bundle)this.dL.get("setFriendGrouping");
      localObject1 = ((Bundle)localObject2).getString("key_js_callback_id");
      i = ((Bundle)localObject2).getInt("key_process_callback_id");
      localObject2 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      if ((this.c.e != null) && (ProfileActivity.AllInOne.b(this.c.e)))
      {
        localBundle.putString("key_method_action", "setFriendGrouping");
        localBundle.putString("web_js_call_back_id", (String)localObject1);
        localObject2 = (acff)((QQAppInterface)localObject2).getManager(51);
        if (localObject2 != null) {
          break label191;
        }
        localObject1 = null;
        if (localObject1 != null)
        {
          localObject1 = ((acff)localObject2).a(String.valueOf(((Friends)localObject1).groupid));
          if (localObject1 != null) {
            localBundle.putString("key_handle_set_get_group", ((Groups)localObject1).group_name);
          }
        }
      }
      this.dL.remove("setFriendGrouping");
      callbackResult(i, EIPCResult.createSuccessResult(localBundle));
    }
    label191:
    while (!QLog.isColorLevel()) {
      for (;;)
      {
        Bundle localBundle;
        Object localObject2;
        int i;
        return;
        Object localObject1 = ((acff)localObject2).e(this.c.e.uin);
      }
    }
    QLog.d("BabyQIPCModule", 2, "babyqWeb callWebJSHandledSetGroup");
  }
  
  public void cHd()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (!this.bGS)
    {
      localQQAppInterface.addObserver(this.jdField_a_of_type_Accn);
      this.bGS = true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("BabyQIPCModule", 2, "babyqWeb BabyQFriendStatusWebPlugin init ");
    }
    Object localObject = (acff)localQQAppInterface.getManager(51);
    if (this.b == null)
    {
      this.b = aqep.a(localQQAppInterface, acbn.blz);
      this.c.d = this.b;
    }
    if ((this.b != null) && (localObject != null)) {
      if (!((acff)localObject).isFriend(this.b.uin)) {
        break label154;
      }
    }
    CardHandler localCardHandler;
    label154:
    for (localObject = new ProfileActivity.AllInOne(this.b.uin, 1);; localObject = new ProfileActivity.AllInOne(this.b.uin, 19))
    {
      this.c.e = ((ProfileActivity.AllInOne)localObject);
      localCardHandler = (CardHandler)localQQAppInterface.getBusinessHandler(2);
      if (localCardHandler != null) {
        break;
      }
      return;
    }
    long l = ProfileActivity.a((ProfileActivity.AllInOne)localObject, false);
    localCardHandler.a(localQQAppInterface.getCurrentAccountUin(), this.b.uin, 1, 0L, (byte)1, 0L, 0L, new byte[] { 0 }, "", l, 10004, new byte[] { 0 }, (byte)1);
    localCardHandler.cHJ();
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    QLog.d("BabyQIPCModule", 1, "babyqWeb action = " + paramString);
    if (this.b == null) {
      cHd();
    }
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    String str = null;
    if (paramBundle != null) {
      str = paramBundle.getString("web_js_call_back_id");
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("key_method_action", paramString);
    localBundle.putString("web_js_call_back_id", str);
    if (paramString.equals("getFriendStatus"))
    {
      paramString = (acff)localQQAppInterface.getManager(51);
      if (paramString == null) {
        break label568;
      }
    }
    label560:
    label562:
    label568:
    for (boolean bool = paramString.isFriend(acbn.blz);; bool = false)
    {
      if (bool) {}
      for (long l = 1L;; l = 0L)
      {
        localBundle.putLong("key_get_friend_status", l);
        return EIPCResult.createSuccessResult(localBundle);
      }
      if (paramString.equals("getZanVoteCount"))
      {
        if (this.b != null) {
          localBundle.putLong("key_get_zan_vote_count", this.b.lVoteCount);
        }
        return EIPCResult.createSuccessResult(localBundle);
      }
      if (paramString.equals("requestZan")) {
        return a(localQQAppInterface, localBundle);
      }
      if (paramString.equals("addFriend")) {
        anot.a(localQQAppInterface, "dc00898", "", "", "0X8008274", "0X8008274", 0, 0, "", "", "", "");
      }
      do
      {
        return null;
        if (paramString.equals("sendmsg"))
        {
          localBundle.putParcelable("key_parcel_allinone", this.c.e);
          return EIPCResult.createSuccessResult(localBundle);
        }
        if (paramString.equals("deleteFriend")) {
          return b(localQQAppInterface, localBundle);
        }
        if (paramString.equals("getFriendGrouping")) {
          return c(localQQAppInterface, localBundle);
        }
        if (paramString.equals("setFriendGrouping")) {
          return a(localQQAppInterface, localBundle, paramString, paramInt, str);
        }
        if (paramString.equals("reportFriend"))
        {
          if (this.c.e != null) {}
          try
          {
            localBundle.putString("key_report_msg", stj.a(localQQAppInterface, this.c.e.uin, "", 21001, null));
            return EIPCResult.createSuccessResult(localBundle);
          }
          catch (Exception paramString)
          {
            for (;;)
            {
              QLog.e("BabyQIPCModule", 1, "babyqWeb getReportMsg Exception", paramString);
            }
          }
        }
        if (paramString.equals("getPushStatus"))
        {
          if (this.b.babyQSwitch) {}
          for (l = 1L;; l = 0L)
          {
            localBundle.putLong("key_request_zan_vote_result", l);
            return EIPCResult.createSuccessResult(localBundle);
          }
        }
      } while (!paramString.equals("setPushStatus"));
      if (paramBundle != null)
      {
        l = paramBundle.getLong("key_push_status", 0L);
        label491:
        if (!aqiw.isNetSupport(BaseApplication.getContext())) {
          break label560;
        }
        paramString = (CardHandler)localQQAppInterface.getBusinessHandler(2);
        if (l != 1L) {
          break label562;
        }
      }
      for (bool = true;; bool = false)
      {
        paramString.EC(bool);
        QLog.i("BabyQIPCModule", 1, "babyqWeb set babyQSwitch = " + l);
        break;
        l = 0L;
        break label491;
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acbu
 * JD-Core Version:    0.7.0.1
 */