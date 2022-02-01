import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;

class aicv
  implements jjq.b
{
  aicv(aicu paramaicu, String paramString) {}
  
  public void onResult(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GroupVideoManager", 2, "start slientDownloadPlugin onResult:" + paramInt);
    }
    jjq.a().axn();
    if (paramInt == 1)
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("roomCodeType", 1);
      localBundle.putLong("roomid", Long.valueOf(this.Uf).longValue());
      aicu.a(this.this$0, localBundle, 1001L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aicv
 * JD-Core Version:    0.7.0.1
 */