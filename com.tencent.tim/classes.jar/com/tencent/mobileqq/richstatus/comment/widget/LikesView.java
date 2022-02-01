package com.tencent.mobileqq.richstatus.comment.widget;

import amhq;
import amhr;
import amhs;
import amhy;
import amhz;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.widget.TextView;
import aofk;
import atau.a;
import java.util.List;
import wja;

public class LikesView
  extends TextView
{
  private String TAG = "LikesView";
  private a a;
  private long aiH;
  private int dBX;
  private Drawable fw;
  private int gT;
  private List<amhq> lF;
  private int mNormalTextColor;
  
  public LikesView(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public LikesView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
    f(paramAttributeSet);
  }
  
  public LikesView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
    f(paramAttributeSet);
  }
  
  private SpannableString a(String paramString1, String paramString2)
  {
    paramString1 = new SpannableString(paramString1);
    paramString1.setSpan(new amhz(this, this.gT, paramString2), 0, paramString1.length(), 33);
    return paramString1;
  }
  
  private SpannableString f()
  {
    SpannableString localSpannableString = new SpannableString("  ");
    int i = wja.dp2px(20.0F, getResources());
    this.fw.setBounds(0, 0, i, i);
    localSpannableString.setSpan(new ImageSpan(this.fw, 0), 0, 1, 33);
    return localSpannableString;
  }
  
  private void f(AttributeSet paramAttributeSet)
  {
    paramAttributeSet = getContext().getTheme().obtainStyledAttributes(paramAttributeSet, atau.a.qV, 0, 0);
    try
    {
      this.gT = paramAttributeSet.getColor(0, getResources().getColor(2131166733));
      this.dBX = paramAttributeSet.getColor(1, getResources().getColor(2131167224));
      return;
    }
    finally
    {
      paramAttributeSet.recycle();
    }
  }
  
  private void init()
  {
    this.mNormalTextColor = getResources().getColor(2131166730);
    this.fw = getResources().getDrawable(2130848312);
  }
  
  public Drawable aO()
  {
    return this.fw;
  }
  
  public void f(List<amhq> paramList, long paramLong)
  {
    this.aiH = paramLong;
    this.lF = paramList;
    notifyDataSetChanged();
  }
  
  public void notifyDataSetChanged()
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    if ((this.lF != null) && (this.lF.size() > 0))
    {
      setVisibility(0);
      localSpannableStringBuilder.append(f());
      int i = 0;
      while (i < this.lF.size())
      {
        amhq localamhq = (amhq)this.lF.get(i);
        if (localamhq != null)
        {
          localSpannableStringBuilder.append(a(localamhq.user.nickName, localamhq.user.uin));
          if (i != this.lF.size() - 1) {
            localSpannableStringBuilder.append(", ");
          }
        }
        i += 1;
      }
      if (this.aiH > 1L) {
        localSpannableStringBuilder.append(String.format(getContext().getResources().getString(2131720341), new Object[] { Long.valueOf(this.aiH) }));
      }
      for (;;)
      {
        setText(new aofk(localSpannableStringBuilder, 3, 12));
        setTextColor(this.mNormalTextColor);
        setMovementMethod(new amhs(this.dBX, getContext().getResources().getColor(2131167595)));
        setOnClickListener(new amhy(this));
        return;
        localSpannableStringBuilder.append(getContext().getResources().getString(2131720340));
      }
    }
    setVisibility(8);
  }
  
  public void setItemColor(int paramInt)
  {
    this.gT = paramInt;
  }
  
  public void setLikSpanDrawable(Drawable paramDrawable)
  {
    this.fw = paramDrawable;
  }
  
  public void setNormalTextColor(int paramInt)
  {
    this.mNormalTextColor = paramInt;
  }
  
  public void setOnItemClickListener(a parama)
  {
    this.a = parama;
  }
  
  public static abstract interface a
  {
    public abstract void onClick(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.comment.widget.LikesView
 * JD-Core Version:    0.7.0.1
 */