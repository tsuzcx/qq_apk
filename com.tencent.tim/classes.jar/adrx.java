import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.protofile.getappinfo.GetAppInfoProto.AndroidInfo;
import com.tencent.protofile.getappinfo.GetAppInfoProto.GetAppinfoResponse;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

class adrx
  implements BusinessObserver
{
  adrx(adrw paramadrw, Activity paramActivity) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    String str = this.val$activity.getString(2131690514);
    localObject1 = str;
    if (paramBoolean) {
      localObject2 = str;
    }
    for (;;)
    {
      try
      {
        paramBundle = paramBundle.getByteArray("data");
        localObject1 = str;
        if (paramBundle != null)
        {
          localObject2 = str;
          GetAppInfoProto.GetAppinfoResponse localGetAppinfoResponse = new GetAppInfoProto.GetAppinfoResponse();
          localObject2 = str;
          localGetAppinfoResponse.mergeFrom(paramBundle);
          localObject1 = str;
          localObject2 = str;
          if (localGetAppinfoResponse.has())
          {
            localObject1 = str;
            localObject2 = str;
            if (localGetAppinfoResponse.ret.get() == 0)
            {
              localObject1 = str;
              localObject2 = str;
              if (localGetAppinfoResponse.androidInfo != null)
              {
                localObject2 = str;
                paramBundle = localGetAppinfoResponse.androidInfo;
                localObject2 = str;
                if (paramBundle.messagetail != null) {
                  continue;
                }
                localObject1 = "";
                localObject2 = localObject1;
                ((String)localObject1).trim();
              }
            }
          }
        }
      }
      catch (Exception paramBundle)
      {
        localObject1 = localObject2;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("ArkWebModule", 2, paramBundle.getMessage());
        localObject1 = localObject2;
        continue;
      }
      paramBundle = (Bundle)localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        paramBundle = this.val$activity.getString(2131690514);
      }
      localObject1 = this.val$activity.getString(2131690515);
      this.a.GO(String.format((String)localObject1, new Object[] { paramBundle }));
      adrw.a(this.a).show();
      return;
      localObject2 = str;
      localObject1 = paramBundle.messagetail.get();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adrx
 * JD-Core Version:    0.7.0.1
 */