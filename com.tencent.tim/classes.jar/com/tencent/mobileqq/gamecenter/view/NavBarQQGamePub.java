package com.tencent.mobileqq.gamecenter.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.widget.navbar.NavBarCommon;
import wja;

public class NavBarQQGamePub
  extends NavBarCommon
{
  private static final String TAG = NavBarQQGamePub.class.getSimpleName();
  private ImageView Au;
  private TextView TU;
  private int dbf;
  private RelativeLayout kG;
  private TextView mTitleTv;
  
  public NavBarQQGamePub(Context paramContext)
  {
    super(paramContext);
    initView();
  }
  
  public NavBarQQGamePub(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    initView();
  }
  
  public NavBarQQGamePub(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    initView();
  }
  
  private void initView()
  {
    this.kG = new RelativeLayout(getContext());
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(wja.dp2px(34.0F, getResources()), wja.dp2px(64.0F, getResources()));
    localLayoutParams.rightMargin = wja.dp2px(52.0F, getResources());
    localLayoutParams.addRule(11);
    localLayoutParams.addRule(15);
    addView(this.kG, localLayoutParams);
    this.Au = new ImageView(getContext());
    this.Au.setImageResource(2130840544);
    this.Au.setId(2131369594);
    localLayoutParams = new RelativeLayout.LayoutParams(wja.dp2px(24.0F, getResources()), wja.dp2px(24.0F, getResources()));
    localLayoutParams.addRule(15);
    this.kG.addView(this.Au, localLayoutParams);
    this.TU = new TextView(getContext());
    this.TU.setText("99+");
    this.TU.setTextColor(-1);
    this.TU.setTextSize(10.0F);
    this.TU.setGravity(17);
    this.TU.setBackgroundResource(2130849582);
    int i = wja.dp2px(1.0F, getResources());
    this.TU.setPadding(i, i, i, i);
    localLayoutParams = new RelativeLayout.LayoutParams(-2, wja.dp2px(16.0F, getResources()));
    localLayoutParams.addRule(10);
    localLayoutParams.addRule(11);
    localLayoutParams.topMargin = wja.dp2px(3.0F, getResources());
    this.kG.addView(this.TU, localLayoutParams);
    this.Au.setOnClickListener(this);
    dqf();
  }
  
  public int Fm()
  {
    return this.dbf;
  }
  
  public void dqf()
  {
    if (this.kG != null) {
      this.kG.setVisibility(8);
    }
  }
  
  public void dqg()
  {
    if (this.kG != null) {
      this.kG.setVisibility(0);
    }
  }
  
  public TextView getTitleTextView()
  {
    if (this.mTitleTv == null) {
      this.mTitleTv = ((TextView)findViewById(2131369627));
    }
    if (this.mTitleTv == null)
    {
      this.mTitleTv = new TextView(getContext());
      QLog.e(TAG, 0, "[getTitleTextView] titleTv is null");
    }
    return this.mTitleTv;
  }
  
  public void setRightImage2(Drawable paramDrawable)
  {
    this.Au.setImageDrawable(paramDrawable);
    this.Au.setVisibility(0);
  }
  
  public void setTitle(String paramString)
  {
    TextView localTextView = (TextView)findViewById(2131379769);
    if (localTextView != null) {
      localTextView.setText(paramString);
    }
  }
  
  public void setUnreadNum(int paramInt)
  {
    dqg();
    if (this.TU != null)
    {
      if (paramInt != 0) {
        break label45;
      }
      this.TU.setVisibility(8);
      if (paramInt <= 99) {
        break label56;
      }
      this.TU.setText("99+");
    }
    for (;;)
    {
      this.dbf = paramInt;
      return;
      label45:
      this.TU.setVisibility(0);
      break;
      label56:
      this.TU.setText("" + paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.view.NavBarQQGamePub
 * JD-Core Version:    0.7.0.1
 */