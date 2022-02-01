import android.support.v4.app.Fragment;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import com.tencent.biz.pubaccount.readinjoy.viola.CommonSuspensionGestureLayout;
import com.tencent.biz.pubaccount.readinjoy.viola.view.ViolaBaseView;
import com.tencent.viola.core.ViolaInstance;
import org.json.JSONException;
import org.json.JSONObject;

public class nxm
  implements View.OnLayoutChangeListener
{
  public nxm(ViolaBaseView paramViolaBaseView) {}
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    if (ViolaBaseView.a(this.this$0) != null) {
      ViolaBaseView.a(this.this$0).setSize(paramView.getWidth(), paramView.getHeight());
    }
    if ((ViolaBaseView.a(this.this$0) != null) && (ViolaBaseView.a(this.this$0).getActivity() != null) && (this.this$0.anN.contains("v_check_nav=1"))) {
      paramView = new JSONObject();
    }
    try
    {
      paramView.put("navigationBarHeight", aqnm.PxToDp(CommonSuspensionGestureLayout.getNavigationBarHeight(ViolaBaseView.a(this.this$0).getActivity())));
      ViolaBaseView.a(this.this$0).updateInstance(paramView.toString());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nxm
 * JD-Core Version:    0.7.0.1
 */