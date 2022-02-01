import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.viola.modules.BridgeModule;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

class tib
  implements bjoe
{
  tib(tia paramtia, String paramString) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    paramView = new JSONObject();
    for (;;)
    {
      try
      {
        paramView.put("index", paramInt);
        if ((!this.jdField_a_of_type_Tia.a) || (paramInt != 0)) {
          continue;
        }
        paramView.put("type", 2);
        if (tia.a(this.jdField_a_of_type_Tia) != null) {
          ((BridgeModule)tia.a(this.jdField_a_of_type_Tia).get()).invokeCallJS(this.jdField_a_of_type_JavaLangString, paramView);
        }
      }
      catch (JSONException paramView)
      {
        continue;
      }
      tia.a(this.jdField_a_of_type_Tia).dismiss();
      return;
      paramView.put("type", 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tib
 * JD-Core Version:    0.7.0.1
 */