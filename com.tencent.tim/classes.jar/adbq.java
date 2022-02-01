import android.text.TextUtils;
import com.tencent.mobileqq.ar.ARPromotionMgr.PromotionConfigInfo.b;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class adbq
  extends adup.a
{
  public String a(aduq.a parama)
  {
    parama = ((PromotionConfigInfo.b)parama.userData).brM;
    if (AudioHelper.aCz()) {
      QLog.w(adca.TAG, 1, "getUnzipDirPath, path[" + parama + "]");
    }
    return parama;
  }
  
  public boolean a(aduq.a parama)
  {
    PromotionConfigInfo.b localb = (PromotionConfigInfo.b)parama.userData;
    localb.cCb = 0;
    boolean bool1 = super.a(parama);
    String str1 = "ARPromotionRDHandler, needDownload[" + bool1 + "], zipItem[" + localb;
    String str4;
    File localFile;
    boolean bool2;
    String str3;
    if (bool1)
    {
      str4 = alan.G("20180426_803_worldcupXXX", localb.md5);
      if (!TextUtils.isEmpty(str4))
      {
        localFile = new File(str4);
        bool2 = localFile.exists();
        str3 = str1 + "], prePath[" + str4 + "], exists[" + bool2;
        if (!bool2) {}
      }
    }
    for (;;)
    {
      String str2;
      try
      {
        str1 = aszr.getFileMD5String(localFile);
        str3 = str3 + "], preMd5[" + str1;
        if (TextUtils.equals(localb.md5, str1))
        {
          str1 = str3 + acfp.m(2131702864);
          bool2 = aqhq.copyFile(str4, b(parama));
          bool1 = super.a(parama);
          parama = str1 + ", copyFile[" + bool2 + "], reCheck[" + bool1 + "]";
          if (!bool1) {
            localb.cCb = 1;
          }
          QLog.w(adca.TAG, 1, parama);
          return bool1;
        }
      }
      catch (Exception localException)
      {
        str2 = "Exception";
        continue;
        parama = str3 + acfp.m(2131702863);
        continue;
      }
      parama = str3;
      continue;
      parama = str2;
    }
  }
  
  public boolean a(aduq.a parama, boolean paramBoolean)
  {
    return false;
  }
  
  public String b(aduq.a parama)
  {
    parama = ((PromotionConfigInfo.b)parama.userData).zipFilePath;
    if (AudioHelper.aCz()) {
      QLog.w(adca.TAG, 1, "getDownloadPath, path[" + parama + "]");
    }
    return parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adbq
 * JD-Core Version:    0.7.0.1
 */