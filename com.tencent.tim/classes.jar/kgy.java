import android.os.Bundle;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyArticleDetailActivity;
import com.tencent.qphone.base.util.QLog;

public class kgy
  implements skj.a
{
  public kgy(ReadInJoyArticleDetailActivity paramReadInJoyArticleDetailActivity) {}
  
  public void callback(Bundle paramBundle)
  {
    synchronized (this.this$0.lock)
    {
      ReadInJoyArticleDetailActivity.a(this.this$0, paramBundle.getByteArray("decryptResult"));
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyArticleDetail", 2, "请求返回时间" + System.currentTimeMillis());
      }
      if (ReadInJoyArticleDetailActivity.a(this.this$0) == null) {
        this.this$0.hashName = null;
      }
      this.this$0.lock.notifyAll();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kgy
 * JD-Core Version:    0.7.0.1
 */