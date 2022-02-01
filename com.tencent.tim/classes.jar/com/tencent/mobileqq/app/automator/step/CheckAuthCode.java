package com.tencent.mobileqq.app.automator.step;

import accy;
import accz;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;

public class CheckAuthCode
  extends AsyncStep
{
  private accz c;
  
  public int od()
  {
    if (this.c == null)
    {
      this.c = new a(null);
      this.a.app.addDefaultObservers(this.c);
    }
    if (((accy)this.a.app.getBusinessHandler(4)).ZM()) {
      return 2;
    }
    return 7;
  }
  
  public void onDestroy()
  {
    if (this.c != null)
    {
      this.a.app.removeObserver(this.c);
      this.c = null;
    }
  }
  
  class a
    extends accz
  {
    private a() {}
    
    public void bx(boolean paramBoolean1, boolean paramBoolean2)
    {
      CheckAuthCode.this.setResult(7);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.CheckAuthCode
 * JD-Core Version:    0.7.0.1
 */