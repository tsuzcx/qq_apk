import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.IBuilder;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.ColorUtil;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.DrawableUtil;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.button.ButtonBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.button.ButtonBase.ClickStatus;

public class lry
  extends ButtonBase
{
  private AnimatorSet B = new AnimatorSet();
  private AnimatorSet C = new AnimatorSet();
  private boolean akM;
  private LinearLayout dK;
  private ImageView mImageView;
  private TextView mTextView;
  
  public lry(VafContext paramVafContext)
  {
    super(paramVafContext);
    b(paramVafContext);
  }
  
  private void b(VafContext paramVafContext)
  {
    this.dK = new LinearLayout(paramVafContext.getContext());
    this.mImageView = new ImageView(paramVafContext.getContext());
    this.mTextView = new TextView(paramVafContext.getContext());
    paramVafContext = new LinearLayout.LayoutParams(-2, -2);
    paramVafContext.gravity = 16;
    this.dK.setOrientation(0);
    this.dK.setGravity(1);
    this.dK.addView(this.mImageView, paramVafContext);
    this.dK.addView(this.mTextView, paramVafContext);
    initAnimation();
  }
  
  private void initAnimation()
  {
    this.B.playTogether(new Animator[] { ObjectAnimator.ofFloat(this.mImageView, "scaleX", new float[] { 1.0F, 0.0F }).setDuration(200L), ObjectAnimator.ofFloat(this.mImageView, "scaleY", new float[] { 1.0F, 0.0F }).setDuration(200L) });
    this.B.addListener(new lrz(this));
    this.C.playTogether(new Animator[] { ObjectAnimator.ofFloat(this.mImageView, "scaleX", new float[] { 0.0F, 1.1F, 1.0F }).setDuration(200L), ObjectAnimator.ofFloat(this.mImageView, "scaleY", new float[] { 0.0F, 1.1F, 1.0F }).setDuration(200L) });
    this.C.addListener(new lsa(this));
  }
  
  private void setRealText(CharSequence paramCharSequence)
  {
    this.mTextView.setText(paramCharSequence);
  }
  
  private void startAnimation()
  {
    this.akM = true;
    this.mImageView.setSelected(isSelected());
    this.B.start();
  }
  
  public int getComMeasuredHeight()
  {
    return this.dK.getMeasuredHeight();
  }
  
  public int getComMeasuredWidth()
  {
    return this.dK.getMeasuredWidth();
  }
  
  public View getNativeView()
  {
    return this.dK;
  }
  
  public boolean onClick()
  {
    startAnimation();
    boolean bool2 = super.onClick();
    if (!isSelected()) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      super.setSelected(bool1);
      this.mTextView.setSelected(bool1);
      return bool2;
    }
  }
  
  public void onComLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.dK.layout(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void onComMeasure(int paramInt1, int paramInt2)
  {
    this.dK.measure(paramInt1, paramInt2);
  }
  
  public void onParseValueFinished()
  {
    super.onParseValueFinished();
    this.dK.setClickable(true);
    this.dK.setPadding(this.mPaddingLeft, this.mPaddingTop, this.mPaddingRight, this.mPaddingBottom);
    this.mTextView.setClickable(true);
    this.mTextView.setIncludeFontPadding(false);
    this.mTextView.setTextSize(0, this.mTextSize);
    this.mTextView.setPadding(this.mCompoundDrawablePadding, 0, 0, 0);
    setRealText(this.mText);
  }
  
  public void refresh()
  {
    super.refresh();
  }
  
  public void setBackgroundColorForStates() {}
  
  public void setBackgroundForStates()
  {
    Object localObject = this.dK.getContext();
    localObject = DrawableUtil.getSelector(DrawableUtil.getDrawable((Context)localObject, getStatus(0).background, this.TRANSPARENT_PLACE_HOLDER, this.GRAY_PLACEHOLDER), DrawableUtil.getDrawable((Context)localObject, getStatus(1).background, this.TRANSPARENT_PLACE_HOLDER, this.GRAY_PLACEHOLDER), DrawableUtil.getDrawable((Context)localObject, getStatus(4).background, this.TRANSPARENT_PLACE_HOLDER, this.GRAY_PLACEHOLDER));
    this.dK.setBackgroundDrawable((Drawable)localObject);
  }
  
  public void setCompoundDrawableForStates()
  {
    Object localObject = this.dK.getContext();
    localObject = DrawableUtil.getSelector(DrawableUtil.getDrawable((Context)localObject, getStatus(0).img, this.TRANSPARENT_PLACE_HOLDER, this.GRAY_PLACEHOLDER), DrawableUtil.getDrawable((Context)localObject, getStatus(1).img, this.TRANSPARENT_PLACE_HOLDER, this.GRAY_PLACEHOLDER), DrawableUtil.getDrawable((Context)localObject, getStatus(4).img, this.TRANSPARENT_PLACE_HOLDER, this.GRAY_PLACEHOLDER));
    this.mImageView.setImageDrawable((Drawable)localObject);
  }
  
  public void setSelected(boolean paramBoolean)
  {
    super.setSelected(paramBoolean);
    this.mTextView.setSelected(paramBoolean);
    if (!this.akM) {
      this.mImageView.setSelected(paramBoolean);
    }
  }
  
  public void setText(CharSequence paramCharSequence)
  {
    if (!TextUtils.equals(paramCharSequence, this.mText))
    {
      this.mText = paramCharSequence;
      this.mTextView.setText(paramCharSequence);
    }
  }
  
  public void setTextColorForStates()
  {
    ColorStateList localColorStateList = ColorUtil.getColorStateList(getStatus(0).textColor, getStatus(1).textColor, getStatus(4).textColor);
    this.mTextView.setTextColor(localColorStateList);
  }
  
  public static class a
    implements ViewBase.IBuilder
  {
    public ViewBase build(VafContext paramVafContext)
    {
      return new lry(paramVafContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lry
 * JD-Core Version:    0.7.0.1
 */