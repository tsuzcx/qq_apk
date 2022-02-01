import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

class ajrh
  implements ahcj.b
{
  ajrh(ajrf paramajrf) {}
  
  public void a(String paramString, long paramLong, Bundle paramBundle)
  {
    if (!TextUtils.isEmpty(paramString)) {
      QLog.d(ajrf.a(this.this$0), 2, "onDownloadSucess,filePath:" + paramString);
    }
  }
  
  public void b(int paramInt, String paramString, Bundle paramBundle)
  {
    QLog.d(ajrf.a(this.this$0), 2, "onDownloadFailed,errCode=" + paramInt);
  }
  
  public void p(int paramInt, Bundle paramBundle) {}
  
  public void q(int paramInt, Bundle paramBundle) {}
  
  public void r(int paramInt, Bundle paramBundle) {}
  
  public void s(int paramInt, Bundle paramBundle) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajrh
 * JD-Core Version:    0.7.0.1
 */