package dov.com.qq.im.ae.album.logic;

import awur;
import awvc;
import mqq.util.WeakReference;

public class AEPhotoListLogicBase$9
  implements Runnable
{
  public AEPhotoListLogicBase$9(awvc paramawvc) {}
  
  public void run()
  {
    if (((awur)this.this$0.bu.get()).queryPhotoTask == null) {
      ((awur)this.this$0.bu.get()).excuteQueryPhotoTask();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.album.logic.AEPhotoListLogicBase.9
 * JD-Core Version:    0.7.0.1
 */