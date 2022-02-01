import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.widget.DrawerFrame.a;

class wsu
  implements DrawerFrame.a
{
  wsu(wsr paramwsr) {}
  
  public void AD(int paramInt)
  {
    wsr.a(this.b);
    if (wsr.a(this.b)) {
      this.b.AD(paramInt);
    }
  }
  
  public void CN(int paramInt)
  {
    if ((!wsr.a(this.b)) && (paramInt == 1)) {
      this.b.cbw();
    }
  }
  
  public void cbB()
  {
    if (this.b.c != null) {
      this.b.c.hideSoftInput();
    }
    if (wsr.a(this.b)) {
      this.b.cbB();
    }
    if (!abrb.S(this.b.mApp)) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        abrb.b(this.b.mApp, "intimate", true);
      }
      return;
    }
  }
  
  public void cbC()
  {
    if (wsr.a(this.b)) {
      this.b.cbC();
    }
  }
  
  public void m(int paramInt, float paramFloat)
  {
    if (wsr.a(this.b)) {
      this.b.m(paramInt, paramFloat);
    }
  }
  
  public void onDrawerClosed()
  {
    wsr.b(this.b);
    if (wsr.a(this.b)) {
      this.b.onDrawerClosed();
    }
    if (abrb.S(this.b.mApp)) {
      abrb.b(this.b.mApp, "intimate", false);
    }
  }
  
  public void onDrawerOpened()
  {
    if (wsr.a(this.b)) {
      this.b.onDrawerOpened();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wsu
 * JD-Core Version:    0.7.0.1
 */