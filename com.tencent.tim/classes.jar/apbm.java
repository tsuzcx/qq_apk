import android.os.Bundle;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import org.json.JSONObject;

class apbm
  implements aprb.a
{
  apbm(apbl paramapbl, apsa paramapsa, int paramInt) {}
  
  public void a(JSONObject paramJSONObject, int paramInt, Bundle paramBundle)
  {
    if ((paramJSONObject != null) && (paramJSONObject.optInt("retcode", -1) == 0)) {
      this.jdField_a_of_type_Apsa.aK(this.jdField_a_of_type_Apbl.this$0.sessionInfo.aTl, 0, this.dTa);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apbm
 * JD-Core Version:    0.7.0.1
 */