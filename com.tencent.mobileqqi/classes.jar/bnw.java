import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.biz.troop.TroopMemberApiPlugin;
import com.tencent.biz.troop.TroopMemberApiService;
import com.tencent.mobileqq.app.BizTroopHandler;
import com.tencent.mobileqq.app.FriendsManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQMapActivityProxy;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.model.TroopInfoManager;
import com.tencent.mobileqq.troop.utils.TroopGagMgr;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import mqq.app.AppRuntime;

public class bnw
  extends Handler
{
  public bnw(TroopMemberApiService paramTroopMemberApiService) {}
  
  public void handleMessage(Message paramMessage)
  {
    Object localObject1 = TroopMemberApiService.a(this.a);
    if ((paramMessage == null) || (localObject1 == null) || (!(localObject1 instanceof QQAppInterface))) {}
    Object localObject2;
    do
    {
      return;
      localObject2 = paramMessage.getData();
    } while (localObject2 == null);
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      super.handleMessage(paramMessage);
      return;
      this.a.b = paramMessage.replyTo;
      continue;
      this.a.b = null;
      continue;
      if (QLog.isColorLevel()) {
        QLog.d("troopMember", 2, "request server to get member list in qq process");
      }
      this.a.jdField_a_of_type_ComTencentMobileqqAppTroopHandler.a(((Bundle)localObject2).getBoolean("refresh"), ((Bundle)localObject2).getString("troopUin"), ((Bundle)localObject2).getString("troopCode"));
      continue;
      localObject1 = ((Bundle)localObject2).getLongArray("uinsToFocus");
      if ((localObject1 != null) && (localObject1.length != 0))
      {
        Object localObject3 = new ArrayList(localObject1.length);
        int j = localObject1.length;
        int i = 0;
        while (i < j)
        {
          ((List)localObject3).add(Long.valueOf(localObject1[i]));
          i += 1;
        }
        this.a.jdField_a_of_type_ComTencentMobileqqAppTroopHandler.a(((Bundle)localObject2).getBoolean("isAdd"), ((Bundle)localObject2).getLong("troopUin"), (List)localObject3);
        continue;
        localObject1 = ((Bundle)localObject2).getLongArray("uinsToDelete");
        if ((localObject1 != null) && (localObject1.length != 0))
        {
          localObject3 = new ArrayList(localObject1.length);
          j = localObject1.length;
          i = 0;
          while (i < j)
          {
            ((List)localObject3).add(Long.valueOf(localObject1[i]));
            i += 1;
          }
          this.a.jdField_a_of_type_ComTencentMobileqqAppTroopHandler.a(((Bundle)localObject2).getLong("troopUin"), (List)localObject3, ((Bundle)localObject2).getBoolean("isBlack"));
          continue;
          this.a.jdField_a_of_type_ComTencentMobileqqAppTroopHandler.h(((Bundle)localObject2).getString("groupCode"));
          continue;
          localObject1 = (FriendManager)((AppRuntime)localObject1).getManager(8);
          if (localObject1 == null) {}
          for (localObject1 = null;; localObject1 = ((FriendManager)localObject1).a(((Bundle)localObject2).getString("troopUin")))
          {
            localObject3 = new Bundle();
            ((Bundle)localObject3).putInt("seq", ((Bundle)localObject2).getInt("seq", -1));
            if (localObject1 != null) {
              ((Bundle)localObject3).putAll(TroopMemberApiService.a((TroopInfo)localObject1));
            }
            TroopMemberApiService.a(this.a, 8, (Bundle)localObject3);
            break;
          }
          localObject3 = ((Bundle)localObject2).getString("troopUin");
          Object localObject4 = ((Bundle)localObject2).getString("memberUin");
          long l = ((Bundle)localObject2).getLong("seconds");
          ((TroopGagMgr)((QQAppInterface)localObject1).getManager(44)).a((String)localObject3, (String)localObject4, l);
          localObject1 = new Bundle();
          ((Bundle)localObject1).putInt("seq", ((Bundle)localObject2).getInt("seq", -1));
          TroopMemberApiService.a(this.a, 10, (Bundle)localObject1);
          continue;
          localObject3 = ((Bundle)localObject2).getString("troopUin");
          localObject4 = ((Bundle)localObject2).getString("memberUin");
          localObject1 = (FriendsManagerImp)((AppRuntime)localObject1).getManager(8);
          Object localObject5 = new Bundle();
          ((Bundle)localObject5).putInt("seq", ((Bundle)localObject2).getInt("seq", -1));
          ((Bundle)localObject5).putString("memberNick", ((FriendsManagerImp)localObject1).b((String)localObject3, (String)localObject4));
          TroopMemberApiService.a(this.a, 11, (Bundle)localObject5);
          continue;
          localObject4 = new Bundle();
          ((Bundle)localObject4).putInt("seq", ((Bundle)localObject2).getInt("seq", -1));
          localObject5 = ((Bundle)localObject2).getParcelableArray("list");
          Bundle[] arrayOfBundle = new Bundle[localObject5.length];
          FriendsManagerImp localFriendsManagerImp = (FriendsManagerImp)((AppRuntime)localObject1).getManager(8);
          int k = localObject5.length;
          j = 0;
          if (j < k)
          {
            Bundle localBundle1 = (Bundle)localObject5[j];
            Bundle localBundle2 = new Bundle();
            localObject2 = localBundle1.getString("uin");
            Friends localFriends = localFriendsManagerImp.a((String)localObject2);
            if ((localFriends != null) && (localFriends.isFriend()))
            {
              i = 1;
              label812:
              if ((i == 0) || (TextUtils.isEmpty(localFriends.remark))) {
                break label1071;
              }
              localObject1 = localFriends.remark;
              label834:
              localObject1 = TroopMemberApiPlugin.a((String)localObject1);
              localBundle2.putString("displayName", (String)localObject1);
              localObject3 = ChnToSpell.a((String)localObject1, 1);
              if (localObject3 != null) {
                localBundle2.putString("displayNamePinyinAll", (String)localObject3);
              }
              localObject1 = ChnToSpell.a((String)localObject1, 2);
              if (localObject1 != null) {
                localBundle2.putString("displayNamePinyinFirst", (String)localObject1);
              }
              if ((i != 0) && (!TextUtils.isEmpty(localFriends.remark)))
              {
                localObject1 = TroopMemberApiPlugin.a(localFriends.remark);
                localBundle2.putString("remark", (String)localObject1);
                localObject3 = ChnToSpell.a((String)localObject1, 1);
                if (localObject3 != null) {
                  localBundle2.putString("remarkPinyinAll", (String)localObject3);
                }
                localObject1 = ChnToSpell.a((String)localObject1, 2);
                if (localObject1 != null) {
                  localBundle2.putString("remarkPinyinFirst", (String)localObject1);
                }
              }
              i = -1;
              localObject1 = localFriendsManagerImp.a(localBundle1.getString("troopuin"));
              if (localObject1 != null)
              {
                if ((((TroopInfo)localObject1).troopowneruin == null) || (!((TroopInfo)localObject1).troopowneruin.equalsIgnoreCase((String)localObject2))) {
                  break label1158;
                }
                i = 2;
              }
            }
            for (;;)
            {
              localBundle2.putString("levelName", (String)((TroopInfo)localObject1).getTroopLevelMap().get(Integer.valueOf(localBundle1.getInt("level"))));
              localBundle2.putInt("status", i);
              arrayOfBundle[j] = localBundle2;
              j += 1;
              break;
              i = 0;
              break label812;
              label1071:
              localObject3 = localBundle1.getString("troopnick");
              localObject1 = localObject3;
              if (!TextUtils.isEmpty((CharSequence)localObject3)) {
                break label834;
              }
              if (i != 0)
              {
                localObject1 = localFriends.name;
                break label834;
              }
              localObject3 = localBundle1.getString("autoremark");
              localObject1 = localObject3;
              if (!TextUtils.isEmpty((CharSequence)localObject3)) {
                break label834;
              }
              localObject3 = localBundle1.getString("friendnick");
              localObject1 = localObject3;
              if (!TextUtils.isEmpty((CharSequence)localObject3)) {
                break label834;
              }
              localObject1 = localObject2;
              break label834;
              label1158:
              if ((((TroopInfo)localObject1).Administrator != null) && (((TroopInfo)localObject1).Administrator.contains((CharSequence)localObject2))) {
                i = 1;
              } else {
                i = 0;
              }
            }
          }
          ((Bundle)localObject4).putParcelableArray("resultList", arrayOfBundle);
          TroopMemberApiService.a(this.a, 9, (Bundle)localObject4);
          continue;
          localObject3 = new Bundle();
          ((Bundle)localObject3).putInt("seq", ((Bundle)localObject2).getInt("seq", -1));
          localObject2 = ((Bundle)localObject2).getString("video_url");
          if ((localObject1 instanceof QQAppInterface))
          {
            localObject1 = (TroopInfoManager)((QQAppInterface)localObject1).getManager(35);
            if (localObject1 == null)
            {
              ((Bundle)localObject3).putBoolean("ret", false);
              TroopMemberApiService.a(this.a, 12, (Bundle)localObject3);
            }
            else if (((TroopInfoManager)localObject1).a())
            {
              new bnx(this, (TroopInfoManager)localObject1, (Bundle)localObject3, (String)localObject2).execute(new Void[0]);
            }
            else
            {
              if ((((TroopInfoManager)localObject1).a((String)localObject2)) && (((TroopInfoManager)localObject1).b())) {}
              for (boolean bool = true;; bool = false)
              {
                ((Bundle)localObject3).putBoolean("ret", bool);
                TroopMemberApiService.a(this.a, 12, (Bundle)localObject3);
                break;
              }
            }
          }
          else
          {
            ((Bundle)localObject3).putBoolean("ret", false);
            TroopMemberApiService.a(this.a, 12, (Bundle)localObject3);
            continue;
            if (this.a.jdField_a_of_type_ComTencentMobileqqAppBizTroopHandler != null)
            {
              this.a.jdField_a_of_type_ComTencentMobileqqAppBizTroopHandler.f(((Bundle)localObject2).getString("video_url"));
              continue;
              this.a.jdField_a_of_type_ComTencentMobileqqAppQQMapActivityProxy = new QQMapActivityProxy(((AppRuntime)localObject1).getAccount());
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     bnw
 * JD-Core Version:    0.7.0.1
 */