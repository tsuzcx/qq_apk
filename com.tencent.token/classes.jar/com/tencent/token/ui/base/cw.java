package com.tencent.token.ui.base;

final class cw
  implements Runnable
{
  private cw(SwitchButton paramSwitchButton) {}
  
  public void run()
  {
    if (!SwitchButton.a(this.a)) {
      return;
    }
    SwitchButton.b(this.a);
    aa.a(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.base.cw
 * JD-Core Version:    0.7.0.1
 */