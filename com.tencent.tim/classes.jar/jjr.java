import android.os.SystemClock;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

class jjr
  extends acnd
{
  jjr(jjq paramjjq) {}
  
  protected void a(boolean paramBoolean, String paramString1, int paramInt1, String paramString2, int paramInt2, int paramInt3, String paramString3, String paramString4, int paramInt4, int paramInt5, long paramLong)
  {
    jjq.a locala = (jjq.a)jjq.a(this.b).get(paramLong);
    if (paramBoolean)
    {
      jjq.a(this.b, SystemClock.elapsedRealtime());
      paramString2 = new jjq.c(SystemClock.elapsedRealtime(), paramInt3, paramString2, paramString3, paramString4);
      jjq.a(this.b).put(paramString1, paramString2);
      if (locala != null)
      {
        locala.a(paramInt3, paramString2, paramInt5);
        jjq.a(this.b).delete(paramLong);
        this.b.aAr = paramInt4;
        if (jjq.a(this.b) == null) {
          break label261;
        }
        jjq.a(this.b).onResult(paramInt4);
        jjq.a(this.b, null);
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.e("GroupVideoManager.GVideoGrayConfig", 2, "onGetTroopHideWebConfig record gVideoStrategy:" + paramInt3 + " isSucc:" + paramBoolean);
      }
      return;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("GroupVideoManager.GVideoGrayConfig", 2, "mGVideoGrayConfigListener is null");
      break;
      paramString1 = (jjq.a)jjq.a(this.b).get(paramLong);
      if (paramString1 != null)
      {
        paramString1.a(-1, null, paramInt5);
        jjq.a(this.b).delete(paramLong);
        break;
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("GroupVideoManager.GVideoGrayConfig", 2, "mGVideoGrayConfigListener is null");
      break;
      label261:
      if (QLog.isColorLevel()) {
        QLog.e("GroupVideoManager.GVideoGrayConfig", 2, "mGVideoPreDownloadListener is null");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jjr
 * JD-Core Version:    0.7.0.1
 */