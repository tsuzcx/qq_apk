package com.tencent.av.ui;

import acfp;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import aqbn;
import com.tencent.av.funchat.AVListImageView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import jfp.a;
import jlg;
import wja;

public class VoiceChangeItemView1
  extends RelativeLayout
  implements View.OnClickListener
{
  jfp.a a = null;
  AVListImageView jdField_b_of_type_ComTencentAvFunchatAVListImageView = null;
  a jdField_b_of_type_ComTencentAvUiVoiceChangeItemView1$a;
  ImageView gQ = null;
  Context mContext;
  int mPosition;
  int mTextColor = -16777216;
  TextView mTextView = null;
  
  public VoiceChangeItemView1(Context paramContext)
  {
    super(paramContext);
    this.mContext = paramContext;
    initView();
  }
  
  public void a(int paramInt1, jfp.a parama, boolean paramBoolean, int paramInt2, a parama1)
  {
    this.mPosition = paramInt1;
    this.jdField_b_of_type_ComTencentAvUiVoiceChangeItemView1$a = parama1;
    this.mTextColor = paramInt2;
    this.a = parama;
    if (parama.type == 0)
    {
      parama1 = this.jdField_b_of_type_ComTencentAvFunchatAVListImageView.getResources();
      if (this.mTextColor == -16777216)
      {
        parama1 = jlg.a(parama1, 2130843045, 2131166238);
        this.jdField_b_of_type_ComTencentAvFunchatAVListImageView.setImageDrawable(parama1);
        label67:
        switch (parama.vipLevel)
        {
        default: 
          this.gQ.setVisibility(8);
        }
      }
    }
    for (;;)
    {
      this.mTextView.setText(parama.name);
      this.mTextView.setTextColor(this.mTextColor);
      setHighlight(paramBoolean);
      setContentDescription(parama.name + acfp.m(2131716863));
      return;
      parama1 = jlg.a(parama1, 2130843045, 2131166275);
      break;
      if (TextUtils.isEmpty(parama.RO)) {
        break label67;
      }
      parama1 = URLDrawable.URLDrawableOptions.obtain();
      paramInt1 = wja.dp2px(60.0F, getResources());
      GradientDrawable localGradientDrawable = new GradientDrawable();
      localGradientDrawable.setColor(getResources().getColor(2131166111));
      localGradientDrawable.setShape(1);
      localGradientDrawable.setSize(paramInt1, paramInt1);
      parama1.mRequestWidth = paramInt1;
      parama1.mRequestHeight = paramInt1;
      parama1.mFailedDrawable = localGradientDrawable;
      parama1.mLoadingDrawable = localGradientDrawable;
      parama1 = URLDrawable.getDrawable(parama.RO, parama1);
      parama1.setTag(aqbn.e(paramInt1, paramInt1));
      parama1.setDecodeHandler(aqbn.b);
      this.jdField_b_of_type_ComTencentAvFunchatAVListImageView.setImageDrawable(parama1);
      break label67;
      this.gQ.setImageResource(2130843161);
      this.gQ.setVisibility(0);
      continue;
      this.gQ.setImageResource(2130843161);
      this.gQ.setVisibility(0);
      continue;
      this.gQ.setImageResource(2130843161);
      this.gQ.setVisibility(0);
    }
  }
  
  public void initView()
  {
    ((LayoutInflater)this.mContext.getSystemService("layout_inflater")).inflate(2131559996, this);
    this.jdField_b_of_type_ComTencentAvFunchatAVListImageView = ((AVListImageView)findViewById(2131382059));
    this.gQ = ((ImageView)findViewById(2131382064));
    this.mTextView = ((TextView)findViewById(2131382063));
    ViewGroup.LayoutParams localLayoutParams = this.jdField_b_of_type_ComTencentAvFunchatAVListImageView.getLayoutParams();
    int i = wja.dp2px(65.0F, getResources());
    localLayoutParams.width = i;
    localLayoutParams.height = i;
    this.jdField_b_of_type_ComTencentAvFunchatAVListImageView.setLayoutParams(localLayoutParams);
    setOnClickListener(this);
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_b_of_type_ComTencentAvUiVoiceChangeItemView1$a != null) {
      this.jdField_b_of_type_ComTencentAvUiVoiceChangeItemView1$a.a(this, this.mPosition);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    this.jdField_b_of_type_ComTencentAvFunchatAVListImageView.dispatchTouchEvent(paramMotionEvent);
    super.onTouchEvent(paramMotionEvent);
    return true;
  }
  
  public void setHighlight(boolean paramBoolean)
  {
    TextView localTextView;
    if ((this.a != null) && (this.a.type == 0))
    {
      this.jdField_b_of_type_ComTencentAvFunchatAVListImageView.setSelected(paramBoolean);
      localTextView = this.mTextView;
      if (!paramBoolean) {
        break label55;
      }
    }
    label55:
    for (int i = -15550475;; i = this.mTextColor)
    {
      localTextView.setTextColor(i);
      return;
      this.jdField_b_of_type_ComTencentAvFunchatAVListImageView.setHighlight(paramBoolean);
      break;
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(VoiceChangeItemView1 paramVoiceChangeItemView1, int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.ui.VoiceChangeItemView1
 * JD-Core Version:    0.7.0.1
 */