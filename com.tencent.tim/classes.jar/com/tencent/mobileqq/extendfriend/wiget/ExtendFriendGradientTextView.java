package com.tencent.mobileqq.extendfriend.wiget;

import android.content.Context;
import android.graphics.Canvas;
import android.support.annotation.Nullable;
import android.text.Layout;
import android.util.AttributeSet;
import aofk;
import awif;
import com.etrump.mixlayout.ETTextView;
import com.tencent.mobileqq.widget.ProfileCardExtendFriendView;
import ko;

public class ExtendFriendGradientTextView
  extends ETTextView
{
  ProfileCardExtendFriendView a;
  public String bFY;
  int cVm = 10;
  int cVn = 0;
  public boolean cbM;
  boolean cbN = true;
  public String content;
  
  public ExtendFriendGradientTextView(Context paramContext)
  {
    super(paramContext);
  }
  
  public ExtendFriendGradientTextView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ExtendFriendGradientTextView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if ((getETLayout() != null) && (getETLayout().getLines() > this.cVm))
    {
      this.cVn = (this.cVm * getETLayout().a(0).length);
      setShowMoreButton(true);
    }
    while ((getLayout() == null) || (getLayout().getLineCount() <= this.cVm)) {
      return;
    }
    this.cVn = getLayout().getLineStart(this.cVm);
    setShowMoreButton(true);
  }
  
  public void setCardView(ProfileCardExtendFriendView paramProfileCardExtendFriendView)
  {
    this.a = paramProfileCardExtendFriendView;
  }
  
  public void setContent(String paramString)
  {
    if (this.content != null) {}
    for (String str = this.content;; str = "")
    {
      this.content = str;
      if ((paramString != null) && (!this.content.equals(paramString)))
      {
        this.content = paramString;
        if ((this.bFY == null) || (!this.cbN)) {
          break;
        }
        setETContent(this.bFY);
      }
      return;
    }
    setETContent(paramString);
  }
  
  public void setETContent(String paramString)
  {
    super.setTextMsg(new aofk(awif.sj(paramString), 3, 24));
  }
  
  public void setFold(boolean paramBoolean)
  {
    this.cbN = paramBoolean;
    if (paramBoolean)
    {
      if (this.bFY == null) {}
      for (String str = this.content;; str = this.bFY)
      {
        setETContent(str);
        return;
      }
    }
    setETContent(this.content);
  }
  
  public void setShowMoreButton(boolean paramBoolean)
  {
    if (paramBoolean != this.cbM)
    {
      this.cbM = paramBoolean;
      this.bFY = this.content.substring(0, this.cVn);
      this.a.TJ(paramBoolean);
      setETContent(this.bFY);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.wiget.ExtendFriendGradientTextView
 * JD-Core Version:    0.7.0.1
 */