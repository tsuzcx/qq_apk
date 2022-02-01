import android.animation.ObjectAnimator;
import android.widget.RelativeLayout;
import com.tencent.av.ui.QavPanel.b;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;

public class jbz
{
  final String TAG;
  jbz.a a = null;
  ObjectAnimator aB = null;
  public int awN;
  public RelativeLayout eg = null;
  public boolean isShow = false;
  
  public jbz(RelativeLayout paramRelativeLayout, int paramInt, jbz.a parama)
  {
    this.TAG = ("MenuView_" + paramInt);
    this.eg = paramRelativeLayout;
    this.awN = paramInt;
    this.a = parama;
  }
  
  public void a(long paramLong, boolean paramBoolean, int paramInt, QavPanel.b paramb)
  {
    int i = 4;
    if (this.eg != null) {
      i = this.eg.getVisibility();
    }
    Object localObject = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder().append("HiddenMenuView, isShow[").append(this.isShow).append("], needAnimation[").append(paramBoolean).append("], visibility[").append(i).append("], lastObjectAnimator[");
    if (this.aB != null) {}
    for (boolean bool = true;; bool = false)
    {
      QLog.w((String)localObject, 1, bool + "], seq[" + paramLong + "]");
      cancel();
      if (!paramBoolean) {
        break label320;
      }
      i = lX();
      localObject = null;
      if (paramInt == 2) {
        localObject = ObjectAnimator.ofFloat(this.eg, "TranslationY", new float[] { 0.0F, i });
      }
      if (localObject != null) {
        break;
      }
      if (!AudioHelper.isDev()) {
        break label319;
      }
      paramb = acfp.m(2131710351) + this.isShow + "], height[" + i + "], seq[" + paramLong + "]";
      QLog.w(this.TAG, 1, paramb, new Throwable("打印调用栈"));
      throw new IllegalArgumentException(paramb);
    }
    ((ObjectAnimator)localObject).setDuration(300L);
    ((ObjectAnimator)localObject).addListener(new jca(this, i, paramLong, paramb));
    this.aB = ((ObjectAnimator)localObject);
    ((ObjectAnimator)localObject).start();
    this.isShow = false;
    if (this.a != null) {
      this.a.b(paramLong, this.eg, true);
    }
    label319:
    label320:
    do
    {
      return;
      if (this.a != null) {
        this.a.b(paramLong, this.eg, true);
      }
      if (this.eg != null)
      {
        this.eg.setVisibility(8);
        this.isShow = false;
      }
    } while (this.a == null);
    this.a.b(paramLong, this.eg, false);
  }
  
  public RelativeLayout b()
  {
    return this.eg;
  }
  
  void cancel()
  {
    ObjectAnimator localObjectAnimator = this.aB;
    this.aB = null;
    if (localObjectAnimator != null) {
      localObjectAnimator.cancel();
    }
  }
  
  public int getKey()
  {
    return this.awN;
  }
  
  public void h(long paramLong, boolean paramBoolean, int paramInt)
  {
    if (this.eg == null) {}
    label221:
    label252:
    do
    {
      return;
      Object localObject = this.TAG;
      StringBuilder localStringBuilder = new StringBuilder().append("ShowMenuView, isShow[").append(this.isShow).append("], needAnimation[").append(paramBoolean).append("], lastObjectAnimator[");
      boolean bool;
      int i;
      if (this.aB != null)
      {
        bool = true;
        QLog.w((String)localObject, 1, bool + "], visibility[" + this.eg.getVisibility() + "], seq[" + paramLong + "]");
        cancel();
        if (this.a != null) {
          this.a.a(paramLong, this.eg, true);
        }
        if (!paramBoolean) {
          break label252;
        }
        i = lX();
        localObject = null;
        if (paramInt != 3) {
          break label221;
        }
        localObject = ObjectAnimator.ofFloat(this.eg, "TranslationY", new float[] { i, 0.0F });
      }
      for (;;)
      {
        ((ObjectAnimator)localObject).setDuration(300L);
        ((ObjectAnimator)localObject).addListener(new jcb(this, i, paramLong));
        this.isShow = true;
        this.aB = ((ObjectAnimator)localObject);
        ((ObjectAnimator)localObject).start();
        return;
        bool = false;
        break;
        if (paramInt == 4) {
          localObject = ObjectAnimator.ofFloat(this.eg, "alpha", new float[] { 0.0F, 1.0F });
        }
      }
      this.eg.setVisibility(0);
      this.isShow = true;
    } while (this.a == null);
    this.a.a(paramLong, this.eg, false);
  }
  
  int lX()
  {
    int i = 0;
    if (this.eg != null)
    {
      this.eg.measure(0, 0);
      i = this.eg.getMeasuredHeight();
    }
    return i;
  }
  
  public static abstract interface a
  {
    public abstract void a(long paramLong, RelativeLayout paramRelativeLayout, boolean paramBoolean);
    
    public abstract void b(long paramLong, RelativeLayout paramRelativeLayout, boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jbz
 * JD-Core Version:    0.7.0.1
 */