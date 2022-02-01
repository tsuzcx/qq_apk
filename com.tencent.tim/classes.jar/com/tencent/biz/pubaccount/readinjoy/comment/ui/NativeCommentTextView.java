package com.tencent.biz.pubaccount.readinjoy.comment.ui;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import com.tencent.biz.pubaccount.readinjoy.comment.data.BaseCommentData;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyYAFolderTextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.IView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import kqy;
import ksm;
import kte;
import ktm;
import kvi;
import kvj;

public class NativeCommentTextView
  extends ReadInJoyYAFolderTextView
  implements View.OnClickListener, View.OnLongClickListener, IView
{
  private String TAG = "NativeCommentTextView";
  private ColorDrawable jdField_c_of_type_AndroidGraphicsDrawableColorDrawable;
  private kte jdField_c_of_type_Kte;
  private ktm e;
  private Context mContext;
  private int mPosition = -1;
  private View mRootView;
  
  public NativeCommentTextView(Context paramContext)
  {
    super(paramContext);
    this.mContext = paramContext;
  }
  
  public NativeCommentTextView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mContext = paramContext;
  }
  
  private void aHr()
  {
    QLog.d(this.TAG, 2, "showAnchorAniation");
    if ((this.e == null) || (this.e.a == null)) {}
    View localView;
    do
    {
      do
      {
        return;
      } while (!this.e.a.isAnchor);
      if (this.jdField_c_of_type_AndroidGraphicsDrawableColorDrawable == null) {
        this.jdField_c_of_type_AndroidGraphicsDrawableColorDrawable = new ColorDrawable(-15550475);
      }
      localView = this.mRootView;
    } while (localView == null);
    QLog.d(this.TAG, 2, "showAnchorAniation start");
    this.e.a.isAnchor = false;
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { 0, 26, 0, 26, 0 });
    localValueAnimator.setDuration(2400L);
    localValueAnimator.setStartDelay(600L);
    localValueAnimator.addUpdateListener(new kvi(this, localView));
    localValueAnimator.start();
  }
  
  private void reset(View paramView)
  {
    this.jdField_c_of_type_AndroidGraphicsDrawableColorDrawable.setAlpha(0);
    paramView.setBackgroundDrawable(this.jdField_c_of_type_AndroidGraphicsDrawableColorDrawable);
  }
  
  public void comLayout(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    onComLayout(true, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public int getComMeasuredHeight()
  {
    return getMeasuredHeight();
  }
  
  public int getComMeasuredWidth()
  {
    return getMeasuredWidth();
  }
  
  public void measureComponent(int paramInt1, int paramInt2)
  {
    onComMeasure(paramInt1, paramInt2);
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    aHr();
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_c_of_type_Kte == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.mPosition == -1)
      {
        setBackgroundResource(2130850224);
        this.jdField_c_of_type_Kte.a(this.e);
      }
      else
      {
        ((ksm)this.jdField_c_of_type_Kte).a(this.e, kqy.a(this.e, this.mPosition));
      }
    }
  }
  
  public void onComLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    layout(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void onComMeasure(int paramInt1, int paramInt2)
  {
    measure(paramInt1, paramInt2);
  }
  
  public boolean onLongClick(View paramView)
  {
    if ((this.mContext == null) || (this.jdField_c_of_type_Kte == null)) {
      return false;
    }
    if (this.mPosition == -1)
    {
      setBackgroundColor(Color.parseColor("#EDEDED"));
      this.jdField_c_of_type_Kte.a(this.jdField_c_of_type_Kte.a(), this, this.e, new kvj(this));
    }
    return true;
  }
  
  public void setCommentModel(ktm paramktm)
  {
    this.e = paramktm;
    if ((this.e == null) || (this.e.a == null)) {
      return;
    }
    setShouldCallClick(true);
    setMaxLines(100);
    setText(this.e.p);
    setSpanText("");
    setOnClickListener(this);
    setOnLongClickListener(this);
    aHr();
  }
  
  public void setModel(kte paramkte, View paramView)
  {
    if ((paramView == null) || (this.mContext == null) || (paramkte == null)) {
      return;
    }
    this.jdField_c_of_type_Kte = paramkte;
    this.mRootView = paramView;
    aHr();
  }
  
  public void setModel(kte paramkte, View paramView, int paramInt)
  {
    if ((paramView == null) || (this.mContext == null) || (paramkte == null)) {
      return;
    }
    this.mPosition = paramInt;
    if ((this.e != null) && (this.e.gy != null) && (this.e.gy.size() > paramInt)) {
      setText((CharSequence)this.e.gy.get(paramInt));
    }
    this.jdField_c_of_type_Kte = paramkte;
    this.mRootView = paramView;
    aHr();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.comment.ui.NativeCommentTextView
 * JD-Core Version:    0.7.0.1
 */