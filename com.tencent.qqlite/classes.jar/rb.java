import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.biz.apiproxy.QQMusicService;
import com.tencent.biz.troop.TroopMemberApiService;
import com.tencent.mobileqq.app.BizTroopHandler;
import com.tencent.mobileqq.app.LBSHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQMapActivityProxy;
import com.tencent.mobileqq.model.TroopInfoManager;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class rb
  extends Handler
{
  public rb(TroopMemberApiService paramTroopMemberApiService) {}
  
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
    case 3: 
    case 10: 
    default: 
    case 1: 
    case 2: 
    case 4: 
    case 5: 
    case 6: 
    case 7: 
    case 8: 
    case 9: 
    case 11: 
    case 12: 
      for (;;)
      {
        super.handleMessage(paramMessage);
        return;
        this.a.b = paramMessage.replyTo;
        continue;
        this.a.b = null;
        continue;
        localObject3 = new Bundle();
        ((Bundle)localObject3).putInt("seq", ((Bundle)localObject2).getInt("seq", -1));
        localObject2 = ((Bundle)localObject2).getString("video_url");
        boolean bool;
        if ((localObject1 instanceof QQAppInterface))
        {
          localObject1 = (TroopInfoManager)((QQAppInterface)localObject1).getManager(33);
          if (localObject1 == null)
          {
            ((Bundle)localObject3).putBoolean("ret", false);
            this.a.a(4, (Bundle)localObject3);
          }
          else if (((TroopInfoManager)localObject1).a())
          {
            new rc(this, (TroopInfoManager)localObject1, (Bundle)localObject3, (String)localObject2).execute(new Void[0]);
          }
          else
          {
            if ((((TroopInfoManager)localObject1).a((String)localObject2)) && (((TroopInfoManager)localObject1).b())) {}
            for (bool = true;; bool = false)
            {
              ((Bundle)localObject3).putBoolean("ret", bool);
              this.a.a(4, (Bundle)localObject3);
              break;
            }
          }
        }
        else
        {
          ((Bundle)localObject3).putBoolean("ret", false);
          this.a.a(4, (Bundle)localObject3);
          continue;
          if (this.a.jdField_a_of_type_ComTencentMobileqqAppBizTroopHandler != null)
          {
            this.a.jdField_a_of_type_ComTencentMobileqqAppBizTroopHandler.g(((Bundle)localObject2).getString("video_url"));
            continue;
            this.a.jdField_a_of_type_ComTencentMobileqqAppQQMapActivityProxy = new QQMapActivityProxy(((AppRuntime)localObject1).getAccount());
            continue;
            localObject3 = ((Bundle)localObject2).getString("gcode");
            localObject2 = ((Bundle)localObject2).getString("anId");
            localObject4 = AnonymousChatHelper.a().a((String)localObject3, (String)localObject2);
            if ((!TextUtils.isEmpty((CharSequence)localObject4)) && (!TextUtils.isEmpty((CharSequence)localObject3)) && (!TextUtils.isEmpty((CharSequence)localObject2)))
            {
              this.a.a((String)localObject3, (String)localObject2, ((AppRuntime)localObject1).getAccount(), (String)localObject4);
              if (QLog.isDevelopLevel())
              {
                QLog.i("com.tencent.biz.troop.TroopMemberApiService", 4, "anonymous report.");
                continue;
                this.a.a().a((AppRuntime)localObject1, (Bundle)localObject2);
                continue;
                if (this.a.jdField_a_of_type_ComTencentMobileqqAppLBSHandler != null)
                {
                  localObject1 = ((Bundle)localObject2).getString("methord_name");
                  int k;
                  if ("getGroupInArea".equals(localObject1))
                  {
                    localObject1 = ((Bundle)localObject2).getString("areaName");
                    i = ((Bundle)localObject2).getInt("lat");
                    j = ((Bundle)localObject2).getInt("lon");
                    k = ((Bundle)localObject2).getInt("startIndex");
                    int m = ((Bundle)localObject2).getInt("count");
                    this.a.jdField_a_of_type_ComTencentMobileqqAppLBSHandler.a((String)localObject1, i, j, k, m);
                  }
                  else if ("getNearbyTroops".equals(localObject1))
                  {
                    bool = ((Bundle)localObject2).getBoolean("isFirst");
                    i = ((Bundle)localObject2).getInt("lat");
                    j = ((Bundle)localObject2).getInt("lon");
                    k = ((Bundle)localObject2).getInt("sortType");
                    localObject1 = ((Bundle)localObject2).getString("strGroupArea");
                    this.a.jdField_a_of_type_ComTencentMobileqqAppLBSHandler.a(bool, i, j, k, (String)localObject1);
                  }
                  else if ("getAreaList".equals(localObject1))
                  {
                    i = ((Bundle)localObject2).getInt("lat");
                    j = ((Bundle)localObject2).getInt("lon");
                    k = ((Bundle)localObject2).getInt("radius");
                    bool = ((Bundle)localObject2).getBoolean("isClickable");
                    this.a.jdField_a_of_type_ComTencentMobileqqAppLBSHandler.a(i, j, k, bool);
                    continue;
                    localObject3 = new Bundle();
                    ((Bundle)localObject3).putInt("seq", ((Bundle)localObject2).getInt("seq", -1));
                    localObject2 = ((Bundle)localObject2).getStringArray("paths");
                    if (((localObject1 instanceof QQAppInterface)) && (localObject2 != null) && (localObject2.length > 0))
                    {
                      localObject1 = (RedTouchManager)((AppRuntime)localObject1).getManager(32);
                      if (localObject1 != null)
                      {
                        localObject4 = new int[localObject2.length];
                        int[] arrayOfInt = new int[localObject2.length];
                        i = 0;
                        if (i < arrayOfInt.length)
                        {
                          BusinessInfoCheckUpdate.AppInfo localAppInfo = ((RedTouchManager)localObject1).a(localObject2[i]);
                          if (localAppInfo != null)
                          {
                            localObject4[i] = localAppInfo.iNewFlag.get();
                            arrayOfInt[i] = localAppInfo.type.get();
                          }
                          for (;;)
                          {
                            i += 1;
                            break;
                            localObject4[i] = 0;
                            arrayOfInt[i] = -1;
                          }
                        }
                        ((Bundle)localObject3).putIntArray("iNewFlags", (int[])localObject4);
                        ((Bundle)localObject3).putIntArray("types", arrayOfInt);
                      }
                    }
                    this.a.a(11, (Bundle)localObject3);
                    continue;
                    new Bundle().putInt("seq", ((Bundle)localObject2).getInt("seq", -1));
                    localObject2 = ((Bundle)localObject2).getString("path");
                    if ((localObject1 instanceof QQAppInterface))
                    {
                      localObject1 = (RedTouchManager)((AppRuntime)localObject1).getManager(32);
                      if (localObject1 != null) {
                        ((RedTouchManager)localObject1).b((String)localObject2);
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    localObject1 = new Bundle();
    ((Bundle)localObject1).putString("method", "changeAnonymousNick");
    ((Bundle)localObject1).putInt("seq", ((Bundle)localObject2).getInt("seq", -1));
    Object localObject3 = ((Bundle)localObject2).getString("troopUin");
    long l = ((Bundle)localObject2).getLong("bubbleId");
    int i = ((Bundle)localObject2).getInt("headId");
    Object localObject4 = ((Bundle)localObject2).getString("nickName");
    int j = ((Bundle)localObject2).getInt("expireTime");
    if ((!TextUtils.isEmpty((CharSequence)localObject3)) && (!TextUtils.isEmpty((CharSequence)localObject4)))
    {
      AnonymousChatHelper.a().a((String)localObject3, l, i, (String)localObject4, j, "");
      ((Bundle)localObject1).putBoolean("result", true);
    }
    for (;;)
    {
      this.a.a(13, (Bundle)localObject1);
      break;
      ((Bundle)localObject1).putBoolean("result", false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     rb
 * JD-Core Version:    0.7.0.1
 */