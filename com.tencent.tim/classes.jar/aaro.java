import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.maxvideo.mediadevice.AVCodec;
import com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr;
import com.tencent.mobileqq.activity.richmedia.view.FSurfaceViewLayout;
import com.tencent.mobileqq.shortvideo.mediadevice.PreviewContext;
import com.tencent.mobileqq.widget.CircleProgress;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.HorizontalListView;
import java.util.concurrent.atomic.AtomicBoolean;

public class aaro
  implements Animator.AnimatorListener
{
  public aaro(NewFlowCameraActivity paramNewFlowCameraActivity) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (!this.this$0.bxQ)
    {
      if (aaqh.cix == 2) {
        this.this$0.mCamera.dQo();
      }
      this.this$0.ca.set(true);
      if (NewFlowCameraActivity.i(this.this$0))
      {
        AVCodec.get().retake();
        ram.i("PTV.NewFlowCameraActivity", "AVCodec.get().retake() by mbRetake flag");
        NewFlowCameraActivity.i(this.this$0, false);
      }
      this.this$0.c.jdField_a_of_type_Aatf.cwG();
      if (NewFlowCameraActivity.j(this.this$0))
      {
        if (aaqh.cix != 1) {
          break label235;
        }
        NewFlowCameraActivity.a(this.this$0, true);
      }
      for (;;)
      {
        this.this$0.c.mStartTime = System.currentTimeMillis();
        this.this$0.c.bL = 0.0D;
        this.this$0.a.cyS();
        this.this$0.c.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext.reset();
        this.this$0.cwt();
        if (QLog.isColorLevel()) {
          QLog.d("PTV.NewFlowCameraActivity", 2, "start recording start time=" + this.this$0.c.mStartTime);
        }
        this.this$0.bxQ = true;
        if (this.this$0.bxw) {
          this.this$0.mListView.setVisibility(4);
        }
        return;
        label235:
        this.this$0.mCamera.PS(true);
      }
    }
    if (this.this$0.bxw) {
      this.this$0.wr.setImageDrawable(null);
    }
    paramAnimator = (RelativeLayout.LayoutParams)this.this$0.wr.getLayoutParams();
    int i = wja.dp2px(59.0F, this.this$0.getResources());
    paramAnimator.width = i;
    paramAnimator.height = i;
    paramAnimator.addRule(13);
    this.this$0.wr.setLayoutParams(paramAnimator);
    paramAnimator = (RelativeLayout.LayoutParams)this.this$0.e.getLayoutParams();
    i = wja.dp2px(84.0F, this.this$0.getResources());
    paramAnimator.width = i;
    paramAnimator.height = i;
    paramAnimator.addRule(13);
    this.this$0.e.setLayoutParams(paramAnimator);
    this.this$0.e.setProgress(0.0F);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    this.this$0.bxQ = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aaro
 * JD-Core Version:    0.7.0.1
 */