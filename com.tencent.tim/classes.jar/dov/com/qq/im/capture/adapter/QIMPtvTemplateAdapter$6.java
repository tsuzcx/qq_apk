package dov.com.qq.im.capture.adapter;

import axpa;
import ayzs;
import com.tencent.qphone.base.util.QLog;

public class QIMPtvTemplateAdapter$6
  implements Runnable
{
  public QIMPtvTemplateAdapter$6(axpa paramaxpa) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QIMPtvTemplateManager", 2, "start download template runnable");
    }
    this.this$0.a.a(this.this$0.a.a(), this.this$0.b, axpa.a(this.this$0));
    this.this$0.b.downloading = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.capture.adapter.QIMPtvTemplateAdapter.6
 * JD-Core Version:    0.7.0.1
 */