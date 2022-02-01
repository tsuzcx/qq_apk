import android.content.Intent;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.mini.sdk.MiniAppController.ActivityResultListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class asso
  implements MiniAppController.ActivityResultListener
{
  asso(assn paramassn, RequestEvent paramRequestEvent) {}
  
  public boolean doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    JSONArray localJSONArray;
    if (paramInt1 == 10)
    {
      localJSONArray = new JSONArray();
      if ((paramIntent == null) || (paramInt2 != -1)) {
        break label183;
      }
      paramIntent = paramIntent.getParcelableArrayListExtra("result_set");
      paramInt1 = 0;
      for (;;)
      {
        if (paramInt1 < paramIntent.size())
        {
          ResultRecord localResultRecord = (ResultRecord)paramIntent.get(paramInt1);
          try
          {
            localJSONArray.put(new JSONObject().put("uin", localResultRecord.uin).put("name", localResultRecord.name));
            paramInt1 += 1;
          }
          catch (JSONException localJSONException2)
          {
            for (;;)
            {
              localJSONException2.printStackTrace();
            }
          }
        }
      }
    }
    label183:
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      paramIntent = new JSONObject();
      try
      {
        paramIntent.put("persons", localJSONArray);
        if (QLog.isColorLevel()) {
          QLog.i("GroupPlugin", 2, String.format("evaluateCallback [ACTION_REQUEST_OPEN_GROUP_SELECTMEMBERS] %s", new Object[] { paramIntent }));
        }
        if (paramInt1 != 0)
        {
          this.val$req.ok(paramIntent);
          return false;
        }
      }
      catch (JSONException localJSONException1)
      {
        for (;;)
        {
          localJSONException1.printStackTrace();
        }
        this.val$req.fail(paramIntent, "errDesc");
        return false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     asso
 * JD-Core Version:    0.7.0.1
 */