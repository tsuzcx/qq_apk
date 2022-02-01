import android.os.Build.VERSION;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.RelativeLayout;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.videoshelf.model.template.VideoShelfTemplate;
import dov.com.qq.im.ae.play.AEVideoShelfEditFragment;

public class axhi
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public axhi(AEVideoShelfEditFragment paramAEVideoShelfEditFragment) {}
  
  public void onGlobalLayout()
  {
    double d;
    int i;
    if (Build.VERSION.SDK_INT >= 16)
    {
      AEVideoShelfEditFragment.a(this.this$0).getViewTreeObserver().removeOnGlobalLayoutListener(this);
      d = 0.0D;
      if ((AEVideoShelfEditFragment.a(this.this$0) == null) || (AEVideoShelfEditFragment.a(this.this$0).getVideoHeight() == 0)) {
        break label345;
      }
      d = AEVideoShelfEditFragment.a(this.this$0).getVideoWidth() / AEVideoShelfEditFragment.a(this.this$0).getVideoHeight();
      if (d < 1.0D) {
        break label253;
      }
      i = 1;
    }
    for (;;)
    {
      label79:
      Object localObject;
      if (i != 0) {
        if (d < 3.0D)
        {
          i = (int)(AEVideoShelfEditFragment.a(this.this$0).getWidth() / d);
          localObject = (ViewGroup.MarginLayoutParams)AEVideoShelfEditFragment.a(this.this$0).getLayoutParams();
          ((ViewGroup.MarginLayoutParams)localObject).height = i;
          AEVideoShelfEditFragment.a(this.this$0).setLayoutParams((ViewGroup.LayoutParams)localObject);
          AEVideoShelfEditFragment.a(this.this$0, AEVideoShelfEditFragment.a(this.this$0).getWidth());
          AEVideoShelfEditFragment.b(this.this$0, ((ViewGroup.MarginLayoutParams)localObject).height);
        }
      }
      for (;;)
      {
        if (QLog.isDebugVersion()) {
          QLog.d("AEVideoShelfEditFrag", 2, new Object[] { "centerView onGlobalLayout: ratio=", Double.valueOf(d), ", wxh=", Integer.valueOf(AEVideoShelfEditFragment.a(this.this$0)), "x", Integer.valueOf(AEVideoShelfEditFragment.b(this.this$0)) });
        }
        return;
        AEVideoShelfEditFragment.a(this.this$0).getViewTreeObserver().removeGlobalOnLayoutListener(this);
        break;
        label253:
        i = 0;
        break label79;
        if (d > 0.3333333333333333D)
        {
          i = (int)(AEVideoShelfEditFragment.a(this.this$0).getHeight() * d);
          localObject = AEVideoShelfEditFragment.a(this.this$0).getLayoutParams();
          ((ViewGroup.LayoutParams)localObject).width = i;
          AEVideoShelfEditFragment.a(this.this$0).setLayoutParams((ViewGroup.LayoutParams)localObject);
          AEVideoShelfEditFragment.a(this.this$0, ((ViewGroup.LayoutParams)localObject).width);
          AEVideoShelfEditFragment.b(this.this$0, AEVideoShelfEditFragment.a(this.this$0).getHeight());
        }
      }
      label345:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axhi
 * JD-Core Version:    0.7.0.1
 */