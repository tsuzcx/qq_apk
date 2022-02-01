package dov.com.tencent.mobileqq.richmedia.capture.view;

import acfp;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.animation.AlphaAnimation;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import ayxh;
import ayxi;
import ayxj;
import com.tencent.common.app.BaseApplicationImpl;
import mqq.app.AppRuntime;
import wja;

public class BeautyBar
  extends LinearLayout
{
  public static long Mq = 1500L;
  public static float ry = 0.6F;
  private a a;
  public SeekBar.OnSeekBarChangeListener c = new ayxi(this);
  private int ciN;
  private LinearLayout.LayoutParams i;
  private boolean inited;
  private int mBeautyValue;
  private Handler mHandler = new ayxh(this);
  private Drawable mThumb_60;
  private TextView mTip;
  private SeekBar n;
  private AlphaAnimation w;
  
  public BeautyBar(Context paramContext)
  {
    super(paramContext);
  }
  
  public BeautyBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public BeautyBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void bc(int paramInt, boolean paramBoolean)
  {
    int k = 0;
    if ((this.mTip == null) || (this.n == null)) {
      return;
    }
    this.mTip.setText(acfp.m(2131703174) + paramInt + "%");
    if (this.i == null) {
      this.i = ((LinearLayout.LayoutParams)this.mTip.getLayoutParams());
    }
    if (this.mThumb_60 != null) {
      k = this.mThumb_60.getIntrinsicWidth();
    }
    for (int j = ((LinearLayout.LayoutParams)this.n.getLayoutParams()).leftMargin + k / 2;; j = 0)
    {
      int m = this.mTip.getWidth();
      int i1 = this.n.getWidth();
      this.i.leftMargin = (j - m / 2 + (i1 - k) * paramInt / 100);
      if (paramInt < 50) {}
      for (this.i.leftMargin = ((int)(this.i.leftMargin - (50.0F - paramInt) / 50.0F * wja.dp2px(7.0F, getResources())));; this.i.leftMargin = ((int)(this.i.leftMargin + (paramInt - 50.0F) / 50.0F * wja.dp2px(5.0F, getResources()))))
      {
        this.mTip.requestLayout();
        if ((paramBoolean) || (this.n.getVisibility() == 0)) {
          break;
        }
        this.mTip.setVisibility(4);
        return;
      }
    }
  }
  
  private void init()
  {
    if (this.inited) {
      return;
    }
    this.inited = true;
    this.n = ((SeekBar)findViewById(2131363379));
    this.n.setMax(100);
    this.n.setOnSeekBarChangeListener(this.c);
    this.w = new AlphaAnimation(1.0F, 0.0F);
    this.w.setAnimationListener(new ayxj(this));
    this.mThumb_60 = getContext().getResources().getDrawable(2130846622);
    this.mTip = ((TextView)findViewById(2131363381));
    this.i = null;
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("beauty_setting", 0);
    String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    int j = localSharedPreferences.getInt("beauty_level" + str, (int)(ry * 100.0F));
    this.n.setProgress(j);
    post(new BeautyBar.4(this, j));
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    init();
  }
  
  public void setBeautyBarListener(a parama)
  {
    this.a = parama;
  }
  
  public static abstract interface a
  {
    public abstract void ada(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.tencent.mobileqq.richmedia.capture.view.BeautyBar
 * JD-Core Version:    0.7.0.1
 */