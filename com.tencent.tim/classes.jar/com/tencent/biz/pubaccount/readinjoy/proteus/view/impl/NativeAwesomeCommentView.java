package com.tencent.biz.pubaccount.readinjoy.proteus.view.impl;

import anbk;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import aofk;
import awit;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.IView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.qphone.base.util.QLog;
import ltc;
import ltd;
import lte;
import ltf;
import mgt;
import soe;

public class NativeAwesomeCommentView
  extends FrameLayout
  implements IView
{
  public static int maxLines = ((Integer)awit.f(mgt.agL, Integer.valueOf(1))).intValue();
  private final String TAG = "ReadInJoyAwesomeCommentView";
  ClickableSpan jdField_a_of_type_AndroidTextStyleClickableSpan = new ltc(this);
  private mgt jdField_a_of_type_Mgt;
  private boolean akO;
  private TextView qa;
  
  public NativeAwesomeCommentView(@NonNull Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public NativeAwesomeCommentView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public NativeAwesomeCommentView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private void init()
  {
    this.qa = ((TextView)inflate(getContext(), 2131560271, this).findViewById(2131380574));
  }
  
  public static void setMaxLines(int paramInt)
  {
    maxLines = paramInt;
  }
  
  public void comLayout(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    onComLayout(true, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public int getComMeasuredHeight()
  {
    if (getVisibility() == 0) {
      return getMeasuredHeight();
    }
    return 0;
  }
  
  public int getComMeasuredWidth()
  {
    if (getVisibility() == 0) {
      return getMeasuredWidth();
    }
    return 0;
  }
  
  public void measureComponent(int paramInt1, int paramInt2)
  {
    onComMeasure(paramInt1, paramInt2);
  }
  
  public void onComLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    layout(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void onComMeasure(int paramInt1, int paramInt2)
  {
    measure(paramInt1, paramInt2);
  }
  
  public void setAwesomeCommentInfo(mgt parammgt)
  {
    int i = 1;
    if ((parammgt == null) || (mgt.aRv == 1))
    {
      setVisibility(8);
      QLog.d("ReadInJoyAwesomeCommentView", 2, "awesomeComment is null");
      return;
    }
    setVisibility(0);
    QLog.d("ReadInJoyAwesomeCommentView", 2, "setAwesomeCommentInfo: " + parammgt);
    this.jdField_a_of_type_Mgt = parammgt;
    Object localObject1 = parammgt.icon_url;
    String str = anbk.nn(parammgt.nick_name);
    Object localObject2 = anbk.nn(parammgt.content);
    localObject2 = new SpannableString("  " + str + ": " + (String)localObject2);
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mLoadingDrawable = new ColorDrawable(0);
    localURLDrawableOptions.mFailedDrawable = getResources().getDrawable(2130843570);
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      localObject1 = URLDrawable.getDrawable((String)localObject1, localURLDrawableOptions);
      ((URLDrawable)localObject1).setBounds(0, 0, parammgt.icon_with * 2, parammgt.icon_height * 2);
      ((URLDrawable)localObject1).setCallback(new ltd(this, (SpannableString)localObject2));
      ((URLDrawable)localObject1).setDownloadListener(new lte(this, (SpannableString)localObject2));
      ((SpannableString)localObject2).setSpan(new soe((Drawable)localObject1), 0, 1, 17);
    }
    if (!TextUtils.isEmpty(str)) {
      i = str.length() + 1;
    }
    ((SpannableString)localObject2).setSpan(this.jdField_a_of_type_AndroidTextStyleClickableSpan, 2, i + 1, 17);
    this.qa.setText(new aofk((CharSequence)localObject2, 7, 16));
    if (maxLines != 0) {
      this.qa.setMaxLines(maxLines);
    }
    for (;;)
    {
      this.qa.setMovementMethod(LinkMovementMethod.getInstance());
      this.qa.setOnClickListener(new ltf(this, parammgt));
      return;
      this.qa.setMaxLines(2147483647);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeAwesomeCommentView
 * JD-Core Version:    0.7.0.1
 */