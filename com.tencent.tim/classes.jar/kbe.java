import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import com.tencent.biz.pubaccount.PublicAccountManager.2.1;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.mp.mobileqq_mp.ButtonInfo;
import com.tencent.mobileqq.mp.mobileqq_mp.GetPublicAccountMenuResponse;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;

public class kbe
  implements BusinessObserver
{
  kbe(kaw paramkaw, NewIntent paramNewIntent, QQAppInterface paramQQAppInterface, String paramString, Context paramContext, BusinessObserver paramBusinessObserver) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    int i = 0;
    this.a.setObserver(null);
    if (QLog.isColorLevel()) {
      QLog.i("PublicAccountManager", 2, "success:" + String.valueOf(paramBoolean));
    }
    if (!paramBoolean) {
      return;
    }
    for (;;)
    {
      try
      {
        for (;;)
        {
          Object localObject2 = paramBundle.getByteArray("data");
          mobileqq_mp.GetPublicAccountMenuResponse localGetPublicAccountMenuResponse = new mobileqq_mp.GetPublicAccountMenuResponse();
          try
          {
            localGetPublicAccountMenuResponse.mergeFrom((byte[])localObject2);
            long l;
            if (localGetPublicAccountMenuResponse.uin.has())
            {
              l = localGetPublicAccountMenuResponse.uin.get() & 0xFFFFFFFF;
              label101:
              if (localGetPublicAccountMenuResponse.seqno.has()) {
                i = localGetPublicAccountMenuResponse.seqno.get();
              }
              Object localObject3;
              if (xki.hN(String.valueOf(l)))
              {
                localObject3 = localGetPublicAccountMenuResponse.button_info.get();
                if ((localObject3 == null) || (((List)localObject3).size() == 0))
                {
                  localObject2 = localObject3;
                  if (localObject3 == null) {
                    localObject2 = new ArrayList();
                  }
                  localObject3 = new mobileqq_mp.ButtonInfo();
                  ((mobileqq_mp.ButtonInfo)localObject3).id.set(1);
                  ((mobileqq_mp.ButtonInfo)localObject3).event_id.set(1000001);
                  ((mobileqq_mp.ButtonInfo)localObject3).type.set(3);
                  mobileqq_mp.ButtonInfo localButtonInfo = new mobileqq_mp.ButtonInfo();
                  localButtonInfo.id.set(2);
                  localButtonInfo.event_id.set(1000002);
                  localButtonInfo.type.set(3);
                  ((List)localObject2).add(localObject3);
                  ((List)localObject2).add(localButtonInfo);
                  localGetPublicAccountMenuResponse.button_info.set((List)localObject2);
                }
              }
              localObject2 = this.this$0.b(this.val$app, this.val$uin);
              if (!localGetPublicAccountMenuResponse.update_internal.has()) {
                break label483;
              }
              j = localGetPublicAccountMenuResponse.update_internal.get();
              label318:
              if (QLog.isColorLevel()) {
                QLog.d("PublicAccountManager-Menu", 2, "update_internal(s):" + j);
              }
              if (j > 0)
              {
                localObject3 = this.val$context.getSharedPreferences("menuEventSharePre", 0).edit();
                ((SharedPreferences.Editor)localObject3).putLong("menuCacheTime", j * 1000);
                ((SharedPreferences.Editor)localObject3).commit();
              }
              if ((localObject2 != null) && (!((List)localObject2).isEmpty())) {
                break label489;
              }
              paramBundle.putInt("update_type", 1);
              label419:
              j = this.this$0.aH("" + l);
              if (i == j) {
                break;
              }
            }
            while (localGetPublicAccountMenuResponse != null)
            {
              ThreadManager.executeOnSubThread(new PublicAccountManager.2.1(this, localGetPublicAccountMenuResponse, paramInt, paramBoolean, paramBundle));
              return;
              l = 0L;
              break label101;
              label483:
              j = -1;
              break label318;
              label489:
              if (!localGetPublicAccountMenuResponse.update_type.has()) {
                break label526;
              }
              j = localGetPublicAccountMenuResponse.update_type.get();
              paramBundle.putInt("update_type", j);
              break label419;
            }
          }
          catch (Exception localException2) {}
        }
      }
      catch (Exception localException1)
      {
        int j;
        label526:
        Object localObject1 = null;
        continue;
      }
      j = 2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kbe
 * JD-Core Version:    0.7.0.1
 */