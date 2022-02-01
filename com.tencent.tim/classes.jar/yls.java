import com.tencent.mobileqq.activity.bless.BlessResultActivity;
import com.tencent.mobileqq.activity.bless.BlessResultActivity.a;
import com.tencent.qphone.base.util.QLog;

public class yls
  implements apaz.b
{
  public yls(BlessResultActivity paramBlessResultActivity) {}
  
  public void cju()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BlessResultActivity", 2, "OnUploadVideoListener onUploadSuccess!");
    }
    this.this$0.bno = true;
    this.this$0.aYO = this.this$0.eC(this.this$0.aYL);
    if (this.this$0.b.hasMessages(1003)) {
      this.this$0.b.removeMessages(1003);
    }
    this.this$0.b.sendEmptyMessage(1001);
  }
  
  public void cjv()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BlessResultActivity", 2, "OnUploadVideoListener onUploadStart!");
    }
  }
  
  public void gm(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BlessResultActivity", 2, "OnUploadVideoListener onUploadFail!");
    }
    if (this.this$0.b.hasMessages(1003)) {
      this.this$0.b.removeMessages(1003);
    }
    this.this$0.b.sendEmptyMessage(1003);
  }
  
  public void gn(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BlessResultActivity", 2, "OnUploadVideoListener onUploadStop!");
    }
  }
  
  public void go(long paramLong)
  {
    long l = aqhq.getFileSizes(this.this$0.a.path);
    int i = (int)(100L * paramLong / l);
    if (QLog.isColorLevel()) {
      QLog.d("BlessResultActivity", 2, "OnUploadVideoListener onUploadProcess! rawLen = " + l + ",offset = " + paramLong + ",process = " + i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yls
 * JD-Core Version:    0.7.0.1
 */