import UserGrowth.stSimpleMetaFeed;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import com.tencent.qphone.base.util.BaseApplication;

public class okf
{
  private Animation ac;
  private Animation ad;
  private Animation ae;
  private Animation af;
  private Animation ag;
  private stSimpleMetaFeed f;
  private AnimationSet h;
  private AnimationSet i;
  private View nv;
  private View nw;
  private TextView uV;
  
  private void qO(boolean paramBoolean)
  {
    if ((this.nv == null) || (this.nw == null)) {
      return;
    }
    if (paramBoolean)
    {
      this.nv.setSelected(true);
      this.nw.setVisibility(0);
      if (this.ac == null) {
        this.ac = AnimationUtils.loadAnimation(BaseApplication.getContext(), 2130772246);
      }
      if (this.ae == null)
      {
        this.ae = AnimationUtils.loadAnimation(BaseApplication.getContext(), 2130772248);
        this.ae.setStartOffset(40L);
      }
      if (this.ad == null)
      {
        this.ad = AnimationUtils.loadAnimation(BaseApplication.getContext(), 2130772247);
        this.ad.setStartOffset(250L);
      }
      if (this.af == null)
      {
        this.af = AnimationUtils.loadAnimation(BaseApplication.getContext(), 2130772249);
        this.af.setStartOffset(290L);
      }
      if (this.h == null)
      {
        this.h = new AnimationSet(true);
        this.h.addAnimation(this.ac);
        this.h.addAnimation(this.ae);
      }
      if (this.i == null)
      {
        this.i = new AnimationSet(true);
        this.i.addAnimation(this.ad);
        this.i.addAnimation(this.af);
      }
      this.nv.startAnimation(this.h);
      this.nw.startAnimation(this.i);
      return;
    }
    this.nv.setSelected(false);
    this.nw.setVisibility(8);
    if (this.ag == null) {
      this.ag = AnimationUtils.loadAnimation(BaseApplication.getContext(), 2130772250);
    }
    this.nv.startAnimation(this.ag);
  }
  
  public void Y(boolean paramBoolean, int paramInt)
  {
    if (this.nv != null) {
      this.nv.setSelected(paramBoolean);
    }
    if (this.nw != null) {
      this.nw.setVisibility(8);
    }
    if (this.uV != null)
    {
      if (paramInt > 0) {
        muj.a(this.uV, paramInt, "0");
      }
    }
    else {
      return;
    }
    this.uV.setText(acfp.m(2131692248));
  }
  
  public void a(stSimpleMetaFeed paramstSimpleMetaFeed, View paramView1, View paramView2, TextView paramTextView, int paramInt, boolean paramBoolean)
  {
    this.f = paramstSimpleMetaFeed;
    this.nv = paramView1;
    this.uV = paramTextView;
    this.nw = paramView2;
    Y(paramBoolean, paramInt);
    qO(paramBoolean);
  }
  
  public View ar()
  {
    return this.nv;
  }
  
  public View as()
  {
    return this.nw;
  }
  
  public stSimpleMetaFeed b()
  {
    return this.f;
  }
  
  public void bfD()
  {
    if (this.h != null)
    {
      this.h.cancel();
      this.h = null;
    }
    if (this.i != null)
    {
      this.i.cancel();
      this.i = null;
    }
    if (this.ag != null)
    {
      this.ag.cancel();
      this.ag = null;
    }
  }
  
  public TextView s()
  {
    return this.uV;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     okf
 * JD-Core Version:    0.7.0.1
 */