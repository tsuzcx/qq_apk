import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
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
import mqq.app.AppRuntime;

public class rf
  extends Handler
{
  public rf(TroopMemberApiService paramTroopMemberApiService) {}
  
  public void handleMessage(Message paramMessage)
  {
    Object localObject2 = TroopMemberApiService.a(this.a);
    if ((paramMessage == null) || (localObject2 == null) || (!(localObject2 instanceof QQAppInterface))) {}
    Object localObject3;
    do
    {
      return;
      localObject3 = paramMessage.getData();
    } while (localObject3 == null);
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
      Object localObject1 = new Bundle();
      ((Bundle)localObject1).putInt("seq", ((Bundle)localObject3).getInt("seq", -1));
      localObject3 = ((Bundle)localObject3).getString("video_url");
      boolean bool;
      if ((localObject2 instanceof QQAppInterface))
      {
        localObject2 = (TroopInfoManager)((QQAppInterface)localObject2).getManager(33);
        if (localObject2 == null)
        {
          ((Bundle)localObject1).putBoolean("ret", false);
          this.a.a(4, (Bundle)localObject1);
        }
        else if (((TroopInfoManager)localObject2).a())
        {
          new rg(this, (TroopInfoManager)localObject2, (Bundle)localObject1, (String)localObject3).execute(new Void[0]);
        }
        else
        {
          if ((((TroopInfoManager)localObject2).a((String)localObject3)) && (((TroopInfoManager)localObject2).b())) {}
          for (bool = true;; bool = false)
          {
            ((Bundle)localObject1).putBoolean("ret", bool);
            this.a.a(4, (Bundle)localObject1);
            break;
          }
        }
      }
      else
      {
        ((Bundle)localObject1).putBoolean("ret", false);
        this.a.a(4, (Bundle)localObject1);
        continue;
        if (this.a.jdField_a_of_type_ComTencentMobileqqAppBizTroopHandler != null)
        {
          this.a.jdField_a_of_type_ComTencentMobileqqAppBizTroopHandler.g(((Bundle)localObject3).getString("video_url"));
          continue;
          this.a.jdField_a_of_type_ComTencentMobileqqAppQQMapActivityProxy = new QQMapActivityProxy(((AppRuntime)localObject2).getAccount());
          continue;
          this.a.a().a((AppRuntime)localObject2, (Bundle)localObject3);
          continue;
          if (this.a.jdField_a_of_type_ComTencentMobileqqAppLBSHandler != null)
          {
            localObject1 = ((Bundle)localObject3).getString("methord_name");
            int i;
            int j;
            int k;
            if ("getGroupInArea".equals(localObject1))
            {
              localObject1 = ((Bundle)localObject3).getString("areaName");
              i = ((Bundle)localObject3).getInt("lat");
              j = ((Bundle)localObject3).getInt("lon");
              k = ((Bundle)localObject3).getInt("startIndex");
              int m = ((Bundle)localObject3).getInt("count");
              this.a.jdField_a_of_type_ComTencentMobileqqAppLBSHandler.a((String)localObject1, i, j, k, m);
            }
            else if ("getNearbyTroops".equals(localObject1))
            {
              bool = ((Bundle)localObject3).getBoolean("isFirst");
              i = ((Bundle)localObject3).getInt("lat");
              j = ((Bundle)localObject3).getInt("lon");
              k = ((Bundle)localObject3).getInt("sortType");
              localObject1 = ((Bundle)localObject3).getString("strGroupArea");
              this.a.jdField_a_of_type_ComTencentMobileqqAppLBSHandler.a(bool, i, j, k, (String)localObject1);
            }
            else if ("getAreaList".equals(localObject1))
            {
              i = ((Bundle)localObject3).getInt("lat");
              j = ((Bundle)localObject3).getInt("lon");
              k = ((Bundle)localObject3).getInt("radius");
              bool = ((Bundle)localObject3).getBoolean("isClickable");
              this.a.jdField_a_of_type_ComTencentMobileqqAppLBSHandler.a(i, j, k, bool);
              continue;
              localObject1 = new Bundle();
              ((Bundle)localObject1).putInt("seq", ((Bundle)localObject3).getInt("seq", -1));
              localObject3 = ((Bundle)localObject3).getStringArray("paths");
              if (((localObject2 instanceof QQAppInterface)) && (localObject3 != null) && (localObject3.length > 0))
              {
                localObject2 = (RedTouchManager)((AppRuntime)localObject2).getManager(32);
                if (localObject2 != null)
                {
                  int[] arrayOfInt1 = new int[localObject3.length];
                  int[] arrayOfInt2 = new int[localObject3.length];
                  i = 0;
                  if (i < arrayOfInt2.length)
                  {
                    BusinessInfoCheckUpdate.AppInfo localAppInfo = ((RedTouchManager)localObject2).a(localObject3[i]);
                    if (localAppInfo != null)
                    {
                      arrayOfInt1[i] = localAppInfo.iNewFlag.get();
                      arrayOfInt2[i] = localAppInfo.type.get();
                    }
                    for (;;)
                    {
                      i += 1;
                      break;
                      arrayOfInt1[i] = 0;
                      arrayOfInt2[i] = -1;
                    }
                  }
                  ((Bundle)localObject1).putIntArray("iNewFlags", arrayOfInt1);
                  ((Bundle)localObject1).putIntArray("types", arrayOfInt2);
                }
              }
              this.a.a(11, (Bundle)localObject1);
              continue;
              new Bundle().putInt("seq", ((Bundle)localObject3).getInt("seq", -1));
              localObject1 = ((Bundle)localObject3).getString("path");
              if ((localObject2 instanceof QQAppInterface))
              {
                localObject2 = (RedTouchManager)((AppRuntime)localObject2).getManager(32);
                if (localObject2 != null) {
                  ((RedTouchManager)localObject2).b((String)localObject1);
                }
              }
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     rf
 * JD-Core Version:    0.7.0.1
 */