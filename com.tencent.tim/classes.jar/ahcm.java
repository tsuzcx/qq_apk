import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.app.MobileQQ;

class ahcm
  implements ahcl.a
{
  ahcm(ahcl paramahcl) {}
  
  public void G(String paramString, Bundle paramBundle)
  {
    QLog.i(ahcl.TAG, 1, "[UniformDL][" + this.a.Zd + "] >>>>>>Download SUCCESS. sdk download path=" + paramString);
    this.a.setStatus(4);
    if (paramString == null)
    {
      QLog.e(ahcl.TAG, 1, "[UniformDL][" + this.a.Zd + "]. download success, but filepath = null");
      b(40, ahcj.em(40), paramBundle);
    }
    label783:
    label821:
    for (;;)
    {
      return;
      if (aqhq.fileExists(this.a.bJr)) {
        this.a.bJr = ahav.kW(this.a.bJr);
      }
      QLog.i(ahcl.TAG, 1, "[UniformDL][" + this.a.Zd + "]. try to rename file to path:" + this.a.bJr);
      Object localObject;
      if (!aqhq.renameFile(new File(paramString), new File(this.a.bJr)))
      {
        QLog.e(ahcl.TAG, 1, "[UniformDL][" + this.a.Zd + "].rename failed. temppath=" + paramString + " save path=" + this.a.bJr);
        localObject = ahbj.getFileDirectoryOf(paramString);
        if (!ahav.wc().equalsIgnoreCase((String)localObject))
        {
          String str = (String)localObject + this.a.mFileName;
          localObject = str;
          if (aqhq.fileExists(str)) {
            localObject = ahav.kW(str);
          }
          QLog.i(ahcl.TAG, 1, "[UniformDL][" + this.a.Zd + "]. rename failed, try to save file to path: " + (String)localObject);
          if (!aqhq.renameFile(new File(paramString), new File((String)localObject)))
          {
            QLog.e(ahcl.TAG, 1, "[UniformDL][" + this.a.Zd + "]. rename failed, try failed save path: " + (String)localObject);
            b(7, ahcj.em(7), paramBundle);
            return;
          }
          this.a.bJr = ((String)localObject);
        }
      }
      else
      {
        QLog.i(ahcl.TAG, 1, "[UniformDL][" + this.a.Zd + "]. rename file success. path:" + this.a.bJr);
        paramString = aglz.a().getApp();
        if (paramString == null) {
          break label783;
        }
        long l1 = -1L;
        long l2 = -1L;
        localObject = ahcn.b.a(paramBundle);
        if (localObject == null) {
          break label743;
        }
        l1 = ((ahcn.b)localObject).aap;
        l2 = ((ahcn.b)localObject).aaq;
        ahav.a(paramString, this.a.Zd, "actFileUfAppBabySdkDownload", System.currentTimeMillis() - this.a.startTime, "", "", "", "", l1, l2, this.a.nFileSize, 0, null);
        ahav.a(paramString, this.a.Zd, "actFileUfAppBabySdkDownloadDetail", System.currentTimeMillis() - this.a.startTime, "", "", "", "", l1, l2, this.a.nFileSize, 0, null);
        anpb.F(paramString.getApplication().getApplicationContext(), paramString.getCurrentAccountUin(), "Complete_download_2_0");
      }
      for (;;)
      {
        if (ahcl.a(this.a) == null) {
          break label821;
        }
        ahcl.a(this.a).a(this.a.bJr, this.a.nFileSize, paramBundle);
        return;
        QLog.e(ahcl.TAG, 1, "[UniformDL][" + this.a.Zd + "]. rename failed 2, try failed save path: " + paramString);
        b(7, ahcj.em(7), paramBundle);
        return;
        label743:
        QLog.w(ahcl.TAG, 1, "[UniformDL][" + this.a.Zd + "].report may failed - 0");
        break;
        QLog.i(ahcl.TAG, 1, "[UniformDL][" + this.a.Zd + "].report failed - 7");
      }
    }
  }
  
  public void b(int paramInt, String paramString, Bundle paramBundle)
  {
    this.a.setStatus(5);
    QQAppInterface localQQAppInterface = aglz.a().getApp();
    if (localQQAppInterface != null)
    {
      long l1 = -1L;
      long l2 = -1L;
      ahcn.b localb = ahcn.b.a(paramBundle);
      if (localb != null)
      {
        l1 = localb.aap;
        l2 = localb.aaq;
      }
      ahav.a(localQQAppInterface, this.a.Zd, "actFileUfAppBabySdkDownload", this.a.startTime, "", "", "", "", paramInt, paramString, l1, l2, this.a.nFileSize, this.a.mUrl, "", 0, paramString, null);
      ahav.a(localQQAppInterface, this.a.Zd, "actFileUfAppBabySdkDownloadDetail", this.a.startTime, "", "", "", "", paramInt, paramString, l1, l2, this.a.nFileSize, this.a.mUrl, "", 0, paramString, null);
      anpb.F(localQQAppInterface.getApplication().getApplicationContext(), localQQAppInterface.getCurrentAccountUin(), "Stop_download_2-0_3-0");
    }
    for (;;)
    {
      if (ahcl.a(this.a) != null) {
        ahcl.a(this.a).b(paramInt, paramString, paramBundle);
      }
      return;
      QLog.w(ahcl.TAG, 1, "[UniformDL][" + this.a.Zd + "].report failed - 6");
    }
  }
  
  public void cE(Bundle paramBundle)
  {
    if (ahcl.a(this.a) != null) {
      ahcl.a(this.a).p(this.a.getProgress(), null);
    }
  }
  
  public void cF(Bundle paramBundle)
  {
    this.a.setStatus(3);
    if (ahcl.a(this.a) != null) {
      ahcl.a(this.a).r(this.a.getProgress(), null);
    }
  }
  
  public void cG(Bundle paramBundle) {}
  
  public void q(int paramInt, Bundle paramBundle)
  {
    this.a.setProgress(paramInt);
    if (ahcl.a(this.a) != null)
    {
      if (paramInt <= 100) {
        break label45;
      }
      ahcl.a(this.a).q(this.a.getProgress(), paramBundle);
    }
    label45:
    while (paramInt - this.a.EQ() <= 0) {
      return;
    }
    this.a.OV(paramInt);
    ahcl.a(this.a).q(paramInt, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahcm
 * JD-Core Version:    0.7.0.1
 */