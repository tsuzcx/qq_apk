import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class apqy
  implements aprb.a
{
  apqy(apqx paramapqx) {}
  
  public void a(JSONObject paramJSONObject, int paramInt, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d(".troop.change_machine", 2, "getChangeMachineFlag result:" + paramJSONObject);
    }
    int j = 0;
    int k = -1;
    paramInt = k;
    int i = j;
    if (paramJSONObject != null)
    {
      if (paramJSONObject.has("code")) {
        break label88;
      }
      i = j;
      paramInt = k;
    }
    for (;;)
    {
      if ((paramInt == 0) && (i != 0))
      {
        apqx.a(this.this$0);
        this.this$0.ebw();
      }
      return;
      label88:
      k = paramJSONObject.optInt("code");
      paramInt = k;
      i = j;
      if (k == 0)
      {
        i = paramJSONObject.optInt("flag");
        paramInt = k;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apqy
 * JD-Core Version:    0.7.0.1
 */