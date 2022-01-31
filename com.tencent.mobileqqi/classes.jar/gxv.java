import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.troop.activity.TroopCreateBaseActivity;
import org.json.JSONException;
import org.json.JSONObject;

public class gxv
  implements DialogInterface.OnClickListener
{
  public gxv(TroopCreateBaseActivity paramTroopCreateBaseActivity, String paramString) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = new JSONObject();
    try
    {
      paramDialogInterface.put("result", paramInt);
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopCreateBaseActivity.a(this.jdField_a_of_type_JavaLangString, paramDialogInterface.toString());
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     gxv
 * JD-Core Version:    0.7.0.1
 */