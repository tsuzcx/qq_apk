package cooperation.qzone.share;

import com.tencent.widget.immersive.ImmersiveUtils;

class QZoneShareActivity$1
  implements Runnable
{
  QZoneShareActivity$1(QZoneShareActivity paramQZoneShareActivity) {}
  
  public void run()
  {
    if (ImmersiveUtils.a(this.this$0.getWindow())) {
      this.this$0.recreate();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qzone.share.QZoneShareActivity.1
 * JD-Core Version:    0.7.0.1
 */