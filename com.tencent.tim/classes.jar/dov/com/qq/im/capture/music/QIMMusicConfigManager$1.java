package dov.com.qq.im.capture.music;

import java.util.Iterator;
import java.util.List;

class QIMMusicConfigManager$1
  implements Runnable
{
  QIMMusicConfigManager$1(QIMMusicConfigManager paramQIMMusicConfigManager, int paramInt, boolean paramBoolean, Object paramObject) {}
  
  public void run()
  {
    Iterator localIterator = QIMMusicConfigManager.a(this.this$0).iterator();
    while (localIterator.hasNext()) {
      ((QIMMusicConfigManager.a)localIterator.next()).bI(this.val$step, this.dwl, this.val$data);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.capture.music.QIMMusicConfigManager.1
 * JD-Core Version:    0.7.0.1
 */