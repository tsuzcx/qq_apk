import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import cooperation.comic.VipComicHelper.1;
import java.lang.ref.WeakReference;
import mqq.app.MobileQQ;

public class avcw
  implements jox
{
  public avcw(VipComicHelper.1 param1) {}
  
  public void loaded(String paramString, int paramInt)
  {
    int j = 0;
    paramString = (QQAppInterface)this.a.eJ.get();
    if (paramString == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ComicHelper", 2, "Finish update offline pkg. code = " + paramInt + ", entry = " + this.a.ewF);
    }
    switch (paramInt)
    {
    }
    for (int i = 0;; i = 1)
    {
      Object localObject = paramString.getApplication().getSharedPreferences("vip_comic_file", 4);
      int k = ((SharedPreferences)localObject).getInt("totalOfflinePkgDownloadCount", 0);
      if (i != 0) {
        j = k + 1;
      }
      if (j != k) {
        ((SharedPreferences)localObject).edit().putInt("totalOfflinePkgDownloadCount", j).apply();
      }
      if (i == 0) {
        break;
      }
      long l = NetConnInfoCenter.getServerTime();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramInt + "|");
      ((StringBuilder)localObject).append(j + "|");
      ((StringBuilder)localObject).append(l + "|");
      ((StringBuilder)localObject).append("|||||");
      annx.b(paramString, "sendtdbank|b_sng_qqvip_qqcomic|offlinePkgDownload", ((StringBuilder)localObject).toString(), true);
      return;
    }
  }
  
  public void progress(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avcw
 * JD-Core Version:    0.7.0.1
 */