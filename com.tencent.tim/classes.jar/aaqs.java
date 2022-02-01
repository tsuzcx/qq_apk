import android.view.View;
import android.view.View.OnLayoutChangeListener;
import android.widget.TextView;
import com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity;

public class aaqs
  implements View.OnLayoutChangeListener
{
  public aaqs(NewFlowCameraActivity paramNewFlowCameraActivity, int paramInt) {}
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    this.this$0.mTip.removeOnLayoutChangeListener(this);
    NewFlowCameraActivity.a(this.this$0, this.Yv, true);
    this.this$0.mTip.addOnLayoutChangeListener(new aaqt(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aaqs
 * JD-Core Version:    0.7.0.1
 */