import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.miniapp.AKOfflineDownloader.1.1;
import com.tencent.mobileqq.miniapp.AKOfflineDownloader.1.2;
import com.tencent.qphone.base.util.QLog;

public class ajcj
  implements jox
{
  ajcj(ajci paramajci, String paramString1, String paramString2, String paramString3, Object paramObject, long paramLong) {}
  
  public void loaded(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AKOfflineDownloader", 2, "checkUpByBusinessId loaded, code:" + paramInt + ", param :" + paramString);
    }
    if (paramInt == 0)
    {
      if (paramString == null)
      {
        ThreadManagerV2.excute(new AKOfflineDownloader.1.1(this), 64, null, true);
        return;
      }
      if (paramString.contains("url"))
      {
        ajci.b(true, this.val$url, this.val$src, 2, this.val$bid, this.val$tag);
        QLog.d("AKOfflineDownloader", 2, new Object[] { "checkUpByBusinessId load success. contains url. cost=", Long.valueOf(System.currentTimeMillis() - this.val$startTime) });
        return;
      }
      ThreadManagerV2.excute(new AKOfflineDownloader.1.2(this), 64, null, true);
      return;
    }
    ajci.b(false, this.val$url, this.val$src, -1, this.val$bid, this.val$tag);
  }
  
  public void progress(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajcj
 * JD-Core Version:    0.7.0.1
 */