import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.viola.modules.BridgeModule;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

class tmu
  implements bkhw
{
  tmu(tmt paramtmt, String paramString) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    paramView = new JSONObject();
    for (;;)
    {
      try
      {
        paramView.put("index", paramInt);
        if ((!this.jdField_a_of_type_Tmt.a) || (paramInt != 0)) {
          continue;
        }
        paramView.put("type", 2);
        if (tmt.a(this.jdField_a_of_type_Tmt) != null) {
          ((BridgeModule)tmt.a(this.jdField_a_of_type_Tmt).get()).invokeCallJS(this.jdField_a_of_type_JavaLangString, paramView);
        }
      }
      catch (JSONException paramView)
      {
        continue;
      }
      tmt.a(this.jdField_a_of_type_Tmt).dismiss();
      return;
      paramView.put("type", 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tmu
 * JD-Core Version:    0.7.0.1
 */