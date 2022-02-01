import android.support.v4.app.Fragment;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import com.tencent.biz.pubaccount.readinjoy.viola.CommonSuspensionGestureLayout;
import com.tencent.biz.pubaccount.readinjoy.viola.view.ViolaBaseView;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.viola.core.ViolaInstance;
import org.json.JSONException;
import org.json.JSONObject;

public class tom
  implements View.OnLayoutChangeListener
{
  public tom(ViolaBaseView paramViolaBaseView) {}
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    if (ViolaBaseView.a(this.a) != null) {
      ViolaBaseView.a(this.a).setSize(paramView.getWidth(), paramView.getHeight());
    }
    if ((ViolaBaseView.a(this.a) != null) && (ViolaBaseView.a(this.a).getActivity() != null) && (this.a.a.contains("v_check_nav=1"))) {
      paramView = new JSONObject();
    }
    try
    {
      paramView.put("navigationBarHeight", ViewUtils.PxToDp(CommonSuspensionGestureLayout.a(ViolaBaseView.a(this.a).getActivity())));
      ViolaBaseView.a(this.a).updateInstance(paramView.toString());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tom
 * JD-Core Version:    0.7.0.1
 */