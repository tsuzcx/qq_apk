import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.viola.modules.BridgeModule;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

class tvn
  implements bkzq
{
  tvn(tvm paramtvm, String paramString) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    paramView = new JSONObject();
    for (;;)
    {
      try
      {
        paramView.put("index", paramInt);
        if ((!this.jdField_a_of_type_Tvm.a) || (paramInt != 0)) {
          continue;
        }
        paramView.put("type", 2);
        if (tvm.a(this.jdField_a_of_type_Tvm) != null) {
          ((BridgeModule)tvm.a(this.jdField_a_of_type_Tvm).get()).invokeCallJS(this.jdField_a_of_type_JavaLangString, paramView);
        }
      }
      catch (JSONException paramView)
      {
        continue;
      }
      tvm.a(this.jdField_a_of_type_Tvm).dismiss();
      return;
      paramView.put("type", 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tvn
 * JD-Core Version:    0.7.0.1
 */