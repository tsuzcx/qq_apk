package com.tencent.mobileqq.structmsg.view;

import com.tencent.mobileqq.structmsg.AbsStructMsgTextElement;

public class StructMsgItemTitle
  extends AbsStructMsgTextElement
{
  public boolean c = false;
  public int g = 0;
  
  public StructMsgItemTitle()
  {
    this(null);
  }
  
  public StructMsgItemTitle(String paramString)
  {
    super(paramString, "title");
  }
  
  public String a()
  {
    return "Title";
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    this.c = paramBoolean;
    this.g = paramInt;
  }
  
  protected int c()
  {
    return 2131230796;
  }
  
  public int d()
  {
    if ((this.c) && (this.g != 0)) {
      return -1;
    }
    return -16777216;
  }
  
  public int e()
  {
    return 28;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.view.StructMsgItemTitle
 * JD-Core Version:    0.7.0.1
 */