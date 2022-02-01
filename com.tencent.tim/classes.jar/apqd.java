import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.troop.troopCard.VisitorTroopCardFragment;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONObject;

class apqd
  implements aprb.a
{
  apqd(appx paramappx) {}
  
  public void a(JSONObject paramJSONObject, int paramInt, Bundle paramBundle)
  {
    switch (paramInt)
    {
    }
    label295:
    label820:
    do
    {
      for (;;)
      {
        return;
        if (paramJSONObject != null)
        {
          try
          {
            paramInt = ((Integer)paramJSONObject.get("retcode")).intValue();
            paramJSONObject = (JSONObject)paramJSONObject.get("result");
            if ((paramInt != 0) || (paramJSONObject == null)) {
              continue;
            }
            if (QLog.isColorLevel()) {
              QLog.i("VisitorTroopCardFragment.VisitorTroopCardPresenter", 2, "checkApiState onResult. retCode = " + paramInt + "\n");
            }
            paramBundle = (JSONObject)paramJSONObject.get("basics");
            Object localObject2;
            String str;
            int i;
            Object localObject1;
            if (paramBundle != null)
            {
              paramBundle = (JSONArray)paramBundle.get("datas");
              if (paramBundle != null)
              {
                paramInt = 0;
                if (paramInt < paramBundle.length())
                {
                  localObject2 = (JSONObject)paramBundle.get(paramInt);
                  str = (String)((JSONObject)localObject2).get("name");
                  i = ((Integer)((JSONObject)localObject2).get("state")).intValue();
                  localObject1 = (String)((JSONObject)localObject2).get("api");
                  localObject2 = (String)((JSONObject)localObject2).get("msg");
                  if (!QLog.isColorLevel()) {
                    break label1008;
                  }
                  QLog.i("VisitorTroopCardFragment.VisitorTroopCardPresenter", 2, "checkApiState onResult, basics name = " + str + " state = " + i + " api = " + (String)localObject1 + " msg = " + (String)localObject2 + "\n");
                  break label1008;
                }
              }
            }
            paramBundle = (JSONObject)paramJSONObject.get("friendlink");
            if (paramBundle != null)
            {
              paramBundle = (JSONArray)paramBundle.get("datas");
              if (paramBundle != null)
              {
                paramInt = 0;
                if (paramInt < paramBundle.length())
                {
                  localObject2 = (JSONObject)paramBundle.get(paramInt);
                  str = (String)((JSONObject)localObject2).get("name");
                  i = ((Integer)((JSONObject)localObject2).get("state")).intValue();
                  localObject1 = (String)((JSONObject)localObject2).get("api");
                  localObject2 = (String)((JSONObject)localObject2).get("msg");
                  if (("add_group".equals(localObject1)) && (i != 1)) {
                    appx.a(this.this$0).ebb();
                  }
                  if (!QLog.isColorLevel()) {
                    break label1015;
                  }
                  QLog.i("VisitorTroopCardFragment.VisitorTroopCardPresenter", 2, "checkApiState onResult, friendlink name = " + str + " state = " + i + " api = " + (String)localObject1 + " msg= " + (String)localObject2 + "\n");
                  break label1015;
                }
              }
            }
            paramInt = ((Integer)paramJSONObject.get("appid")).intValue();
            if (QLog.isColorLevel()) {
              QLog.i("VisitorTroopCardFragment.VisitorTroopCardPresenter", 2, "checkApiState onResult, appid =" + paramInt + "\n");
            }
            paramJSONObject = (JSONObject)paramJSONObject.get("qqpay");
            if (paramJSONObject == null) {
              continue;
            }
            paramJSONObject = (JSONArray)paramJSONObject.get("datas");
            if (paramJSONObject == null) {
              continue;
            }
            paramInt = 0;
            while (paramInt < paramJSONObject.length())
            {
              localObject1 = (JSONObject)paramJSONObject.get(paramInt);
              paramBundle = (String)((JSONObject)localObject1).get("name");
              i = ((Integer)((JSONObject)localObject1).get("state")).intValue();
              str = (String)((JSONObject)localObject1).get("api");
              localObject1 = (String)((JSONObject)localObject1).get("msg");
              if (QLog.isColorLevel()) {
                QLog.i("VisitorTroopCardFragment.VisitorTroopCardPresenter", 2, "checkApiState onResult, qqpay name = " + paramBundle + " state = " + i + " api = " + str + " msg= " + (String)localObject1 + "\n");
              }
              paramInt += 1;
            }
            if (!QLog.isColorLevel()) {
              continue;
            }
          }
          catch (Exception paramJSONObject) {}
          QLog.d("VisitorTroopCardFragment.VisitorTroopCardPresenter", 2, "checkApiState onResult " + paramJSONObject.toString());
          return;
          if ((appx.a(this.this$0) != null) && (paramJSONObject != null)) {
            try
            {
              paramJSONObject = (JSONObject)paramJSONObject.get("data");
              if (paramJSONObject != null)
              {
                paramJSONObject = (JSONObject)paramJSONObject.get("key");
                if (paramJSONObject != null)
                {
                  paramInt = ((Integer)paramJSONObject.get("retCode")).intValue();
                  paramBundle = (String)paramJSONObject.get("retMsg");
                  if (paramInt != 0) {
                    break label921;
                  }
                  if (appx.a(this.this$0) != null) {
                    appx.a(this.this$0).wy(true);
                  }
                  apqe.I(9, new Object());
                  if (QLog.isColorLevel())
                  {
                    QLog.i("VisitorTroopCardFragment.VisitorTroopCardPresenter", 2, "joinGroup onResult retCode = " + paramInt + " retMsg = " + paramBundle);
                    return;
                  }
                }
              }
            }
            catch (Exception paramJSONObject)
            {
              appx.a(this.this$0).uV(appx.a(this.this$0).getString(2131721365));
            }
          }
        }
      }
    } while (!QLog.isColorLevel());
    QLog.e("VisitorTroopCardFragment.VisitorTroopCardPresenter", 2, "joinGroup onResult " + paramJSONObject.toString());
    return;
    label921:
    paramJSONObject = appx.a(this.this$0).getString(2131721365);
    switch (paramInt)
    {
    }
    for (;;)
    {
      appx.a(this.this$0).uV(paramJSONObject);
      break label820;
      paramJSONObject = appx.a(this.this$0).getString(2131721360);
      continue;
      paramJSONObject = appx.a(this.this$0).getString(2131721366);
      continue;
      label1008:
      paramInt += 1;
      break;
      label1015:
      paramInt += 1;
      break label295;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apqd
 * JD-Core Version:    0.7.0.1
 */