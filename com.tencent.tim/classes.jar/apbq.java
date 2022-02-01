import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.troop.data.TroopFeedsDataManager.3.1;
import com.tencent.mobileqq.troop.data.TroopFeedsDataManager.3.2;
import com.tencent.qphone.base.util.QLog;
import java.util.LinkedHashMap;
import java.util.List;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONObject;

public class apbq
  implements aprb.a
{
  apbq(apbo paramapbo) {}
  
  public void a(JSONObject paramJSONObject, int paramInt, Bundle paramBundle)
  {
    if (paramJSONObject != null) {}
    for (;;)
    {
      try
      {
        if (paramJSONObject.optInt("retcode") == 0) {
          break label723;
        }
        i = paramJSONObject.optInt("ec");
        if (i == 0) {
          break label723;
        }
        i = 0;
        if (i == 0)
        {
          if ((paramInt == 1000) || (paramInt == 1002))
          {
            apbo.e(this.this$0);
            this.this$0.notifyObservers(Integer.valueOf(103));
            if (paramInt == 1002) {
              this.this$0.ah.clear();
            }
          }
          if (QLog.isColorLevel()) {
            QLog.d("TroopFeedsDataManager", 2, "cgi end(failed): " + System.currentTimeMillis());
          }
          return;
        }
      }
      catch (Exception paramBundle)
      {
        paramBundle = paramBundle;
        paramBundle.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.d("TroopFeedsDataManager", 2, "cgi end(suc): " + System.currentTimeMillis());
        }
        if (paramInt == 1000)
        {
          ThreadManager.getSubThreadHandler().post(new TroopFeedsDataManager.3.1(this, paramJSONObject));
          return;
        }
      }
      finally {}
      if (paramInt == 1002)
      {
        ThreadManager.getSubThreadHandler().post(new TroopFeedsDataManager.3.2(this, paramJSONObject));
        return;
      }
      if (paramInt == 1007)
      {
        this.this$0.bS = paramJSONObject;
        apbo.f(this.this$0);
        if (QLog.isColorLevel()) {
          QLog.d("TroopFeedsDataManager", 2, "cgi return. requestCode: GET_TROOP_NOTICE, msg = NOTIFY_REMIND_NOTICE");
        }
        this.this$0.notifyObservers(Integer.valueOf(1011));
        return;
      }
      Object localObject;
      JSONObject localJSONObject;
      if ((paramInt == 1004) || (paramInt == 1003))
      {
        if (QLog.isColorLevel()) {
          QLog.d("TroopFeedsDataManager", 2, "cgi return. requestCode: GET_NOR_NOTICE");
        }
        localObject = paramJSONObject.optJSONArray("feeds");
        paramBundle = paramJSONObject.optJSONArray("inst");
        if ((localObject != null) && (((JSONArray)localObject).length() == 1))
        {
          localJSONObject = ((JSONArray)localObject).optJSONObject(0);
          this.this$0.bS = localJSONObject;
          this.this$0.dTb = paramJSONObject.optInt("ad");
          paramInt = 1;
        }
      }
      for (;;)
      {
        i = paramInt;
        if (paramBundle != null)
        {
          i = paramInt;
          if (paramBundle.length() > 0)
          {
            paramBundle = paramBundle.optJSONObject(0);
            long l2 = paramBundle.optLong("pubt");
            long l1 = 0L;
            if (this.this$0.bS != null) {
              l1 = this.this$0.bS.optLong("pubt");
            }
            i = paramInt;
            if (l2 > l1)
            {
              this.this$0.bS = paramBundle;
              this.this$0.dTb = paramJSONObject.optInt("ad");
              i = 1;
            }
          }
        }
        if (i != 0)
        {
          apbo.g(this.this$0);
          if (QLog.isColorLevel()) {
            QLog.d("TroopFeedsDataManager", 2, "cgi return. NOTIFY_NOR_NOTICE");
          }
          this.this$0.notifyObservers(Integer.valueOf(1007));
          return;
          if ((localObject != null) && (((JSONArray)localObject).length() == 2))
          {
            localJSONObject = ((JSONArray)localObject).optJSONObject(0);
            localObject = ((JSONArray)localObject).optJSONObject(1);
            if (localJSONObject.optLong("pubt") >= ((JSONObject)localObject).optLong("pubt")) {
              this.this$0.bS = localJSONObject;
            }
            for (this.this$0.dTb = paramJSONObject.optInt("ad");; this.this$0.dTb = paramJSONObject.optInt("ad"))
            {
              paramInt = 1;
              break;
              this.this$0.bS = ((JSONObject)localObject);
            }
          }
        }
        else
        {
          apbo.h(this.this$0);
          this.this$0.notifyObservers(Integer.valueOf(1012));
          return;
          if ((paramInt != 1005) && (paramInt != 1006)) {
            break;
          }
          paramJSONObject = apbn.a(paramJSONObject, "" + this.this$0.aj, this.this$0.mApp.getCurrentAccountUin());
          paramBundle = (List)paramJSONObject[0];
          paramJSONObject = (List)paramJSONObject[1];
          this.this$0.mItems = paramJSONObject;
          apbo.i(this.this$0);
          if (paramInt == 1005)
          {
            this.this$0.notifyObservers(Integer.valueOf(1008));
            return;
          }
          this.this$0.notifyObservers(Integer.valueOf(1009));
          return;
        }
        paramInt = 0;
      }
      label723:
      int i = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apbq
 * JD-Core Version:    0.7.0.1
 */