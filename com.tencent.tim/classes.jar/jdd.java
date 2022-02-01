import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import android.widget.ImageView;
import com.tencent.av.ui.QavPanel.d;
import com.tencent.av.widget.shimmer.ShimmerTextView;

public class jdd
  implements View.OnTouchListener
{
  boolean Vx = false;
  public QavPanel.d a;
  Rect aj = new Rect();
  Rect ak = new Rect();
  Rect al = new Rect();
  int auu = -1;
  int axf = 0;
  ShimmerTextView b = null;
  ImageView gG = null;
  ImageView gH = null;
  ImageView gI = null;
  final int mTouchSlop;
  
  public jdd(Context paramContext, ImageView paramImageView1, ImageView paramImageView2, ShimmerTextView paramShimmerTextView, ImageView paramImageView3)
  {
    this.gG = paramImageView1;
    this.gH = paramImageView2;
    this.b = paramShimmerTextView;
    this.gI = paramImageView3;
    this.axf = paramContext.getResources().getDimensionPixelSize(2131298212);
    this.mTouchSlop = ViewConfiguration.get(paramContext).getScaledTouchSlop();
  }
  
  private void mP(int paramInt)
  {
    this.aj.left = (this.ak.left + paramInt - this.auu);
    this.aj.right = (this.ak.right + paramInt - this.auu);
    if (this.aj.right >= this.axf)
    {
      this.aj.right = this.axf;
      this.aj.left = (this.aj.right - this.gG.getWidth());
    }
    if (this.aj.left <= 0)
    {
      this.aj.left = 0;
      this.aj.right = (this.aj.left + this.gG.getWidth());
    }
    this.gG.layout(this.aj.left, this.ak.top, this.aj.right, this.ak.bottom);
    this.gI.layout(this.aj.left, this.al.top, this.al.right, this.al.bottom);
  }
  
  public void a(QavPanel.d paramd)
  {
    this.a = paramd;
  }
  
  void auk()
  {
    this.ak.top = this.gG.getTop();
    this.ak.bottom = this.gG.getBottom();
    this.ak.left = this.gG.getLeft();
    this.ak.right = this.gG.getRight();
    this.aj.left = this.gG.getLeft();
    this.aj.right = this.gG.getRight();
    this.al.top = this.gI.getTop();
    this.al.bottom = this.gI.getBottom();
    this.al.left = this.gI.getLeft();
    this.al.right = this.gI.getRight();
    this.Vx = false;
  }
  
  public void aul()
  {
    mP(this.auu);
    this.b.setVisibility(0);
    this.gH.setVisibility(0);
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int i = (int)paramMotionEvent.getRawX();
    switch (paramMotionEvent.getAction())
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return true;
            this.auu = i;
            auk();
            return true;
            if (this.Vx)
            {
              mP(i);
              return true;
            }
          } while (Math.abs(i - this.auu) <= this.mTouchSlop);
          this.Vx = true;
          this.b.setVisibility(4);
          this.gH.setVisibility(4);
          return true;
          if (this.aj.right != this.axf) {
            break;
          }
        } while (this.a == null);
        this.a.iB(true);
        return true;
      } while (this.aj.right >= this.axf);
      this.gG.layout(this.ak.left, this.ak.top, this.ak.right, this.ak.bottom);
      this.gI.layout(this.al.left, this.al.top, this.al.right, this.al.bottom);
      this.b.setVisibility(0);
      this.gH.setVisibility(0);
    } while (this.a == null);
    this.a.iB(false);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jdd
 * JD-Core Version:    0.7.0.1
 */