package com.tencent.biz.pubaccount.readinjoy.widgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.support.annotation.Nullable;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import atau.a;
import nxv;
import nxw;
import nxx;
import org.jetbrains.annotations.NotNull;

public class LimitWordCountEditText
  extends LinearLayout
{
  private EditText U;
  private a a;
  private boolean avw = true;
  private int countLimit;
  private String hint = "";
  private TextView tR;
  private TextWatcher textWatcher;
  private String title = "";
  private TextView titleView;
  
  public LimitWordCountEditText(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    String str1 = "";
    String str2 = "";
    Object localObject2 = str1;
    Object localObject1 = str2;
    float f1 = f2;
    int i = j;
    TypedArray localTypedArray;
    if (paramAttributeSet != null)
    {
      localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, atau.a.qW);
      localObject2 = str1;
      localObject1 = str2;
      f1 = f2;
      i = j;
      if (localTypedArray != null)
      {
        if (!localTypedArray.getBoolean(3, true)) {
          break label275;
        }
        LayoutInflater.from(paramContext).inflate(2131562917, this);
      }
    }
    for (;;)
    {
      i = localTypedArray.getInt(1, 12);
      paramAttributeSet = localTypedArray.getString(2);
      paramContext = paramAttributeSet;
      if (paramAttributeSet == null) {
        paramContext = "";
      }
      localObject1 = localTypedArray.getString(4);
      paramAttributeSet = (AttributeSet)localObject1;
      if (localObject1 == null) {
        paramAttributeSet = "";
      }
      f1 = localTypedArray.getFloat(0, 0.0F);
      localTypedArray.recycle();
      localObject1 = paramAttributeSet;
      localObject2 = paramContext;
      this.U = ((EditText)findViewById(2131366532));
      this.titleView = ((TextView)findViewById(2131379769));
      this.tR = ((TextView)findViewById(2131380892));
      findViewById(2131377546).setOnClickListener(new nxv(this));
      this.textWatcher = new nxw(this);
      this.U.addTextChangedListener(this.textWatcher);
      setHint((String)localObject2);
      setTitle((String)localObject1);
      setCountLimit(i);
      setContentTextSize(f1);
      return;
      label275:
      LayoutInflater.from(paramContext).inflate(2131562916, this);
    }
  }
  
  public EditText b()
  {
    return this.U;
  }
  
  public String getContent()
  {
    return this.U.getText().toString();
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.U.removeTextChangedListener(this.textWatcher);
  }
  
  public int ra()
  {
    return this.U.length();
  }
  
  public void setContent(@NotNull String paramString)
  {
    this.U.setText(paramString);
  }
  
  public void setContentTextSize(float paramFloat)
  {
    if (paramFloat > 0.0F) {
      this.U.setTextSize(1, paramFloat);
    }
  }
  
  public void setCountChangeListener(a parama)
  {
    this.a = parama;
  }
  
  public void setCountLimit(int paramInt)
  {
    if (paramInt > 0)
    {
      this.countLimit = paramInt;
      this.U.setFilters(new InputFilter[] { new InputFilter.LengthFilter(paramInt) });
      this.tR.setText(String.valueOf(paramInt - getContent().length()));
    }
  }
  
  public void setDisableManualEnter(boolean paramBoolean)
  {
    this.avw = paramBoolean;
    this.U.setOnEditorActionListener(new nxx(this, paramBoolean));
  }
  
  public void setHint(String paramString)
  {
    this.hint = paramString;
    this.U.setHint(paramString);
  }
  
  public void setSelectionEnd()
  {
    this.U.post(new LimitWordCountEditText.4(this));
  }
  
  public void setTitle(String paramString)
  {
    this.title = paramString;
    if (paramString.isEmpty())
    {
      this.titleView.setVisibility(8);
      return;
    }
    this.titleView.setVisibility(0);
    this.titleView.setText(paramString);
  }
  
  public void setTitleTypeFace(Typeface paramTypeface)
  {
    this.titleView.setTypeface(paramTypeface);
  }
  
  public static abstract interface a
  {
    public abstract void sb(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.widgets.LimitWordCountEditText
 * JD-Core Version:    0.7.0.1
 */