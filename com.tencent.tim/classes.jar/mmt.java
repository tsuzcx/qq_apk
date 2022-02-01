import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;

final class mmt
  extends jnm.d
{
  mmt(mmr.a parama, int paramInt) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if (this.a != null)
    {
      this.a.ay(paramInt, "");
      if (QLog.isColorLevel()) {
        QLog.d("RIJUGC.PublishVideoHelper", 2, "moveVideo: errorCode = " + paramInt + "callback =" + this.a);
      }
    }
    for (;;)
    {
      lcc.a().aJE();
      return;
      if (QLog.isColorLevel()) {
        QLog.d("RIJUGC.PublishVideoHelper", 2, "moveVideo: errorCode = " + paramInt + "callback is null.");
      }
    }
  }
  
  public boolean a(int paramInt, String paramString, Bundle paramBundle)
  {
    if (this.a != null) {
      this.a.ay(paramInt, paramString);
    }
    QLog.e("RIJUGC.PublishVideoHelper", 1, "moveVideo: columnId = " + this.aTI + "errorCode = " + paramInt + ",errorMsg =" + paramString);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mmt
 * JD-Core Version:    0.7.0.1
 */