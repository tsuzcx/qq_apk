import android.os.Build;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.earlydownload.xmldata.JpegSoData;
import com.tencent.mobileqq.earlydownload.xmldata.XmlData;
import com.tencent.mobileqq.pic.JpegCompressor;
import com.tencent.mobileqq.pic.JpegSoLoad;
import com.tencent.qphone.base.util.QLog;

public class afey
  extends afeu
{
  boolean bXP = true;
  QQAppInterface mApp = null;
  long mStartTime = 0L;
  
  public afey(QQAppInterface paramQQAppInterface)
  {
    super(ur(), paramQQAppInterface);
    this.mApp = paramQQAppInterface;
  }
  
  public static String ur()
  {
    if ("armeabi-v7a".equalsIgnoreCase(Build.CPU_ABI)) {
      return "qq.android.pic.jpeg.so_v7_820";
    }
    return "qq.android.pic.jpeg.so_v5_820";
  }
  
  public void HL(boolean paramBoolean)
  {
    if (b().loadState == 2)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QJpegSoDownloadHandler", 2, "is in downloading");
      }
      return;
    }
    super.HL(paramBoolean);
  }
  
  public void HO(String paramString)
  {
    String str2 = JpegSoLoad.getJpegSolibPath(BaseApplicationImpl.getContext());
    String str1 = str2 + JpegSoLoad.getLibActualName("jpegc_above820");
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("QJpegSoDownloadHandler", 2, "download success: " + paramString + " ,so path:" + str1);
        }
        aqhq.W(paramString, str2, false);
        str2 = amjg.calcMD5(str1);
        Object localObject2 = b();
        if (!(localObject2 instanceof JpegSoData)) {
          break label335;
        }
        localObject2 = (JpegSoData)localObject2;
        if (QLog.isColorLevel()) {
          QLog.d("QJpegSoDownloadHandler", 2, "doOnDownloadSuccess, soMD5:" + str2 + " soData.SO_MD5:" + ((JpegSoData)localObject2).SO_MD5);
        }
        if (!str2.equalsIgnoreCase(((JpegSoData)localObject2).SO_MD5)) {
          break label335;
        }
        JpegCompressor.jpegcompressLoadSo();
        bool = true;
        if (!bool)
        {
          aqhq.deleteFile(str1);
          aqhq.deleteFile(paramString);
        }
        if (QLog.isColorLevel()) {
          QLog.d("QJpegSoDownloadHandler", 2, "doOnDownloadSuccess,suc:" + bool);
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("QJpegSoDownloadHandler", 2, localException, new Object[0]);
        aqhq.deleteFile(str1);
        aqhq.deleteFile(paramString);
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("QJpegSoDownloadHandler", 2, "doOnDownloadSuccess,suc:" + false);
        continue;
      }
      finally
      {
        aqhq.deleteFile(str1);
        aqhq.deleteFile(paramString);
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("QJpegSoDownloadHandler", 2, "doOnDownloadSuccess,suc:" + false);
      }
      super.HO(paramString);
      return;
      label335:
      boolean bool = false;
    }
  }
  
  public boolean aiV()
  {
    return true;
  }
  
  public void f(XmlData paramXmlData)
  {
    if ((QLog.isColorLevel()) && (paramXmlData != null) && ((paramXmlData instanceof JpegSoData))) {
      QLog.d("QJpegSoDownloadHandler", 2, new Object[] { "doOnServerResp, xmlData=", paramXmlData });
    }
    super.f(paramXmlData);
  }
  
  public Class<? extends XmlData> g()
  {
    return JpegSoData.class;
  }
  
  public int getBusinessId()
  {
    return 10043;
  }
  
  public String un()
  {
    return "qjpegDownloadSoDuration";
  }
  
  public String uo()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afey
 * JD-Core Version:    0.7.0.1
 */