import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.app.MobileQQ;

class ahcr
  implements ahcq.a
{
  ahcr(ahcq paramahcq) {}
  
  public void a(String paramString, long paramLong, Bundle paramBundle)
  {
    ahcq.a(this.a);
    this.a.setStatus(4);
    if (aqhq.fileExists(this.a.bJr)) {
      this.a.bJr = ahav.kW(this.a.bJr);
    }
    QLog.i(ahcq.TAG, 1, "[UniformDL][" + this.a.Zd + "]. >>>Download SUCCESS.  save file to: =" + this.a.bJr);
    int i = 1;
    long l2;
    long l1;
    if (paramBundle != null)
    {
      l2 = paramBundle.getLong("EXT_TRANS_SIZE ");
      l1 = paramBundle.getLong("EXT_TTRANS_SIZE ");
      i = paramBundle.getInt("EXT_AUTOTRY_COUNT");
    }
    for (;;)
    {
      if (!aqhq.renameFile(new File(this.a.bJZ), new File(this.a.bJr)))
      {
        QLog.e(ahcq.TAG, 1, "[UniformDL][" + this.a.Zd + "].rename failed.temppath=" + this.a.bJZ + " path=" + this.a.bJr);
        this.a.setStatus(5);
        paramString = ahcj.em(7);
        QQAppInterface localQQAppInterface = aglz.a().getApp();
        if (localQQAppInterface != null)
        {
          ahav.a(localQQAppInterface, this.a.Zd, "actFileUfGenDownload", this.a.startTime, "", "", "", "", 7, paramString, l1, l2, this.a.nFileSize, this.a.mUrl, "", 0, paramString, null);
          ahav.a(localQQAppInterface, this.a.Zd, "actFileUfGenDownloadDetail", this.a.startTime, "", "", "", "", 7, paramString, l1, l2, this.a.nFileSize, this.a.mUrl, "", 0, paramString, null);
          anpb.F(localQQAppInterface.getApplication().getApplicationContext(), localQQAppInterface.getCurrentAccountUin(), "Stop_download_2-0_3-1");
          if (ahcq.a(this.a) != null) {
            ahcq.a(this.a).b(7, paramString, paramBundle);
          }
        }
      }
      for (;;)
      {
        return;
        QLog.w(ahcq.TAG, 1, "[UniformDL][" + this.a.Zd + "].report failed - 5");
        break;
        ahcf.a().JN(this.a.mUrl);
        paramString = aglz.a().getApp();
        if (paramString != null)
        {
          ahav.a(paramString, this.a.Zd, "actFileUfGenDownload", System.currentTimeMillis() - this.a.startTime, "", "", "", "", l1, l2, this.a.nFileSize, i, null);
          ahav.a(paramString, this.a.Zd, "actFileUfGenDownloadDetail", System.currentTimeMillis() - this.a.startTime, "", "", "", "", l1, l2, this.a.nFileSize, i, null);
          anpb.F(paramString.getApplication().getApplicationContext(), paramString.getCurrentAccountUin(), "Complete_download_2_1");
        }
        while (ahcq.a(this.a) != null)
        {
          l1 = paramLong;
          if (this.a.nFileSize > 0L)
          {
            l1 = paramLong;
            if (paramLong <= 0L) {
              l1 = this.a.nFileSize;
            }
          }
          ahcq.a(this.a).a(this.a.bJr, l1, paramBundle);
          return;
          QLog.i(ahcq.TAG, 1, "[UniformDL][" + this.a.Zd + "].report failed - 0");
        }
      }
      l1 = paramLong;
      l2 = paramLong;
    }
  }
  
  public void b(int paramInt, String paramString, Bundle paramBundle)
  {
    ahcq.a(this.a);
    this.a.setStatus(5);
    if (ahcq.a(this.a) != null) {
      ahcq.a(this.a).b(paramInt, paramString, paramBundle);
    }
  }
  
  public void q(int paramInt, Bundle paramBundle)
  {
    this.a.setProgress(paramInt);
    if ((ahcq.a(this.a) != null) && (paramInt - this.a.EQ() > 0))
    {
      this.a.OV(paramInt);
      ahcq.a(this.a).q(paramInt, paramBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahcr
 * JD-Core Version:    0.7.0.1
 */