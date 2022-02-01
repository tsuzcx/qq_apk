import android.view.View;
import android.view.View.OnLayoutChangeListener;
import com.tencent.biz.pubaccount.readinjoy.viola.videonew.VVideoView;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class tmq
  implements View.OnLayoutChangeListener
{
  public tmq(VVideoView paramVVideoView) {}
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    JSONObject localJSONObject;
    if ((VVideoView.a(this.a)) && (this.a.a() != null) && (paramView != null) && (paramView.getWidth() >= paramView.getHeight())) {
      localJSONObject = new JSONObject();
    }
    try
    {
      localJSONObject.put("left", paramInt1);
      localJSONObject.put("top", paramInt2);
      localJSONObject.put("right", paramInt3);
      localJSONObject.put("bottom", paramInt4);
      localJSONObject.put("width", paramView.getWidth());
      localJSONObject.put("height", paramView.getHeight());
      this.a.a("onFullScreenSizeChange", localJSONObject);
      if (QLog.isColorLevel()) {
        QLog.d("VVideoView", 2, "test video onLayoutChange left:" + paramInt1 + ",top:" + paramInt2 + ",right:" + paramInt3 + ",bottom:" + paramInt4 + ",oldLeft:" + paramInt5 + ",oldTop:" + paramInt6 + ",oldRight:" + paramInt7 + ",oldBottom:" + paramInt8);
      }
      return;
    }
    catch (JSONException paramView)
    {
      for (;;)
      {
        paramView.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tmq
 * JD-Core Version:    0.7.0.1
 */