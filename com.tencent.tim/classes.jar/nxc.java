import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.viola.CommonSuspensionGestureLayout;
import com.tencent.biz.pubaccount.readinjoy.viola.ViolaFragment;
import com.tencent.biz.pubaccount.readinjoy.viola.view.ViolaBaseView;
import com.tencent.biz.pubaccount.readinjoy.viola.view.ViolaBaseView.10.1;
import com.tencent.biz.pubaccount.readinjoy.viola.view.ViolaBaseView.e;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.viola.core.ViolaInstance;
import com.tencent.viola.core.ViolaInstance.ViolaPageListener;

public class nxc
  implements ViolaInstance.ViolaPageListener
{
  public nxc(ViolaBaseView paramViolaBaseView) {}
  
  public void onComponentTopIndex(View paramView, float paramFloat)
  {
    if (((ViolaBaseView.a(this.this$0) instanceof ViolaFragment)) && (((ViolaFragment)ViolaBaseView.a(this.this$0)).a() != null)) {
      ((ViolaFragment)ViolaBaseView.a(this.this$0)).a().c(paramView, paramFloat);
    }
  }
  
  public void onDispatchTouchEvent(String paramString, int paramInt1, MotionEvent paramMotionEvent, int paramInt2)
  {
    if (paramString.equals(ViolaBaseView.a(this.this$0).getMasterListRef())) {
      ViolaBaseView.b(this.this$0, paramInt2);
    }
  }
  
  public void onScroll(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean)
  {
    if (paramString.equals(ViolaBaseView.a(this.this$0).getMasterListRef()))
    {
      ViolaBaseView.b(this.this$0, paramInt5);
      ViolaBaseView.b(this.this$0, true);
      if (ViolaBaseView.a(this.this$0) != null) {
        ViolaBaseView.a(this.this$0).a(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramBoolean);
      }
    }
  }
  
  public void onScrollStateChanged(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (ViolaBaseView.a(this.this$0) != null) {
      ViolaBaseView.a(this.this$0).aF(paramString, paramInt1);
    }
    if (paramString.equals(ViolaBaseView.a(this.this$0).getMasterListRef()))
    {
      ViolaBaseView.b(this.this$0, paramInt2);
      ViolaBaseView.b(this.this$0, true);
    }
  }
  
  public void pageOpenSuccess()
  {
    ViolaBaseView.a(this.this$0, 3);
    ThreadManager.post(new ViolaBaseView.10.1(this), 8, null, true);
    if ((!TextUtils.isEmpty(this.this$0.anN)) && (this.this$0.anN.contains("VideoFeeds.js"))) {
      kbp.a(null, null, "0X800AF0E", "0X800AF0E", 0, 0, null, null, null, "" + System.currentTimeMillis(), false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nxc
 * JD-Core Version:    0.7.0.1
 */