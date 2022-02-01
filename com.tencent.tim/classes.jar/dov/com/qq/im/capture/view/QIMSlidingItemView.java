package dov.com.qq.im.capture.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import wja;

public class QIMSlidingItemView
  extends LinearLayout
{
  ImageView Fo;
  a a;
  TextView mTextView;
  
  public QIMSlidingItemView(@NonNull Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public QIMSlidingItemView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public QIMSlidingItemView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private void init()
  {
    setOrientation(0);
    setGravity(16);
    this.Fo = new ImageView(getContext());
    this.mTextView = new TextView(getContext());
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(wja.dp2px(13.0F, getResources()), wja.dp2px(12.0F, getResources()));
    localLayoutParams.gravity = 17;
    addView(this.Fo, localLayoutParams);
    this.Fo.setVisibility(8);
    localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
    localLayoutParams.leftMargin = wja.dp2px(4.0F, getResources());
    addView(this.mTextView, localLayoutParams);
  }
  
  public void cB(int paramInt, boolean paramBoolean)
  {
    this.mTextView.setTextColor(paramInt);
    ImageView localImageView;
    if (this.Fo.getVisibility() == 0)
    {
      localImageView = this.Fo;
      if (!paramBoolean) {
        break label41;
      }
    }
    label41:
    for (paramInt = this.a.eIF;; paramInt = this.a.eIE)
    {
      localImageView.setImageResource(paramInt);
      return;
    }
  }
  
  public void lx(int paramInt1, int paramInt2)
  {
    this.mTextView.setGravity(17);
    this.mTextView.setSingleLine();
    this.mTextView.setTextSize(0, paramInt1);
    setPadding(paramInt2, 0, paramInt2, 0);
  }
  
  public void setData(a parama)
  {
    this.a = parama;
    this.mTextView.setText(this.a.mText);
    if (this.a.eIE != 0)
    {
      this.Fo.setImageResource(this.a.eIE);
      this.Fo.setVisibility(0);
    }
  }
  
  public static class a
  {
    public int eIE;
    public int eIF;
    public String mText;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.capture.view.QIMSlidingItemView
 * JD-Core Version:    0.7.0.1
 */