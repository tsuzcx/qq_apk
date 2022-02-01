import android.os.Build.VERSION;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.FrameLayout;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.videoshelf.model.template.VideoShelfTemplate;
import dov.com.qq.im.ae.play.AETemplateInfoFragment;

public class axhe
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public axhe(AETemplateInfoFragment paramAETemplateInfoFragment) {}
  
  public void onGlobalLayout()
  {
    if (Build.VERSION.SDK_INT >= 16)
    {
      AETemplateInfoFragment.a(this.this$0).getViewTreeObserver().removeOnGlobalLayoutListener(this);
      if (AETemplateInfoFragment.a(this.this$0) != null) {
        break label50;
      }
    }
    label50:
    float f1;
    float f2;
    do
    {
      do
      {
        return;
        AETemplateInfoFragment.a(this.this$0).getViewTreeObserver().removeGlobalOnLayoutListener(this);
        break;
      } while ((AETemplateInfoFragment.a(this.this$0).getVideoHeight() == 0) || (AETemplateInfoFragment.a(this.this$0).getVideoWidth() == 0));
      f1 = AETemplateInfoFragment.a(this.this$0).getVideoWidth() / AETemplateInfoFragment.a(this.this$0).getVideoHeight();
      i = AETemplateInfoFragment.a(this.this$0).getWidth();
      int j = AETemplateInfoFragment.a(this.this$0).getHeight();
      f2 = i / j;
      if (QLog.isDebugVersion()) {
        QLog.d("AETemplateInfoFragment", 2, new Object[] { "adjust player size---origin w:h=", Integer.valueOf(i), ":", Integer.valueOf(j), " availableRatio(w/h)=", Float.valueOf(f2), " video aspectRation(w/h)=" + f1 });
      }
      if (f1 < f2)
      {
        double d = AETemplateInfoFragment.a(this.this$0).getHeight();
        i = (int)(f1 * d);
        localObject = AETemplateInfoFragment.a(this.this$0).getLayoutParams();
        ((ViewGroup.LayoutParams)localObject).width = i;
        AETemplateInfoFragment.a(this.this$0).setLayoutParams((ViewGroup.LayoutParams)localObject);
        return;
      }
    } while (f1 <= f2);
    int i = (int)(AETemplateInfoFragment.a(this.this$0).getWidth() / f1);
    Object localObject = (ViewGroup.MarginLayoutParams)AETemplateInfoFragment.a(this.this$0).getLayoutParams();
    ((ViewGroup.MarginLayoutParams)localObject).height = i;
    AETemplateInfoFragment.a(this.this$0).setLayoutParams((ViewGroup.LayoutParams)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axhe
 * JD-Core Version:    0.7.0.1
 */