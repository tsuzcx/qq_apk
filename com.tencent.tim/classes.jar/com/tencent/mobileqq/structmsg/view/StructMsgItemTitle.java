package com.tencent.mobileqq.structmsg.view;

import android.content.Context;
import android.text.Layout;
import android.text.TextUtils;
import android.widget.TextView;
import anqw;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.qphone.base.util.QLog;

public class StructMsgItemTitle
  extends anqw
{
  public boolean cJP;
  public boolean cJZ;
  public int dMq;
  
  public StructMsgItemTitle()
  {
    this(null);
  }
  
  public StructMsgItemTitle(String paramString)
  {
    super(paramString, "title");
  }
  
  public int Kp()
  {
    if ((this.cJP) && (this.dMq != 0)) {
      return -1;
    }
    return -16777216;
  }
  
  public int Kq()
  {
    return 28;
  }
  
  public void Qv(boolean paramBoolean)
  {
    this.cJZ = paramBoolean;
  }
  
  public void b(AbsShareMsg paramAbsShareMsg)
  {
    paramAbsShareMsg.mContentTitle = this.text;
  }
  
  public void bA(boolean paramBoolean, int paramInt)
  {
    this.cJP = paramBoolean;
    this.dMq = paramInt;
  }
  
  public String getLayoutStr()
  {
    return "Title";
  }
  
  public int getTextId()
  {
    return 2131380976;
  }
  
  public Class<? extends TextView> i()
  {
    if (this.cJZ) {
      return TitleTextView.class;
    }
    return super.i();
  }
  
  public static class TitleTextView
    extends TextView
  {
    public int mWidth;
    
    public TitleTextView(Context paramContext)
    {
      super();
    }
    
    private void c(CharSequence paramCharSequence, int paramInt)
    {
      if ((TextUtils.isEmpty(paramCharSequence)) || (paramInt <= 0)) {}
      do
      {
        return;
        i = (int)Math.ceil(Layout.getDesiredWidth(paramCharSequence, getPaint()));
      } while (i <= paramInt);
      int j = (int)Math.floor(getTextSize() * paramInt / i);
      if (QLog.isColorLevel()) {
        QLog.i("StructMsg", 2, "adjustTextSize avail:" + paramInt + " width:" + i + " oldSize:" + getTextSize() + " newSize:" + j);
      }
      int i = j;
      if (j == getTextSize()) {
        i = j - 1;
      }
      setTextSize(0, i);
      c(paramCharSequence, paramInt);
    }
    
    protected void onMeasure(int paramInt1, int paramInt2)
    {
      super.onMeasure(paramInt1, paramInt2);
      this.mWidth = getMeasuredWidth();
      paramInt1 = this.mWidth;
      paramInt2 = getPaddingLeft();
      int i = getPaddingRight();
      c(getText(), paramInt1 - paramInt2 - i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.view.StructMsgItemTitle
 * JD-Core Version:    0.7.0.1
 */