import android.os.Bundle;
import android.os.Handler;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONObject;

class smi
  implements aprb.a
{
  smi(slz paramslz) {}
  
  public void a(JSONObject paramJSONObject, int paramInt, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("requstTroopNotifyAd", 2, "result = " + paramJSONObject + ", requestCode = " + paramInt);
    }
    if (paramJSONObject != null)
    {
      paramJSONObject = paramJSONObject.optJSONObject("data");
      if (paramJSONObject != null)
      {
        paramJSONObject = paramJSONObject.optJSONObject("8020205751015455");
        if (paramJSONObject != null)
        {
          paramJSONObject = paramJSONObject.optJSONArray("list");
          if ((paramJSONObject != null) && (paramJSONObject.length() > 0))
          {
            paramJSONObject = apbo.c.a(paramJSONObject.optJSONObject(0));
            if (paramJSONObject != null)
            {
              this.this$0.a = paramJSONObject;
              this.this$0.aLY = true;
              if (QLog.isColorLevel()) {
                QLog.d("requstTroopNotifyAd", 2, "apurl = " + this.this$0.a.apurl + ", img = " + this.this$0.a.img + ", rl = " + this.this$0.a.rl);
              }
            }
            if (QLog.isColorLevel()) {
              QLog.d("TroopTipsPopWindow", 2, "requestTroopNotifyAd result ready -----------");
            }
            this.this$0.mUIHandler.sendEmptyMessage(1001);
            return;
          }
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopTipsPopWindow", 2, "requestTroopNotifyAd result null -----------");
    }
    this.this$0.mUIHandler.sendEmptyMessage(1001);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     smi
 * JD-Core Version:    0.7.0.1
 */