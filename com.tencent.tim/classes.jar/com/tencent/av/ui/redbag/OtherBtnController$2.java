package com.tencent.av.ui.redbag;

import com.tencent.av.app.VideoAppInterface;
import jih;

public class OtherBtnController$2
  implements Runnable
{
  public OtherBtnController$2(jih paramjih) {}
  
  public void run()
  {
    if (!this.this$0.xu()) {}
    do
    {
      return;
      this.this$0.reset();
    } while (this.this$0.mApp == null);
    if (this.this$0.b != null)
    {
      this.this$0.mApp.deleteObserver(this.this$0.b);
      this.this$0.b = null;
    }
    this.this$0.kT(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.ui.redbag.OtherBtnController.2
 * JD-Core Version:    0.7.0.1
 */