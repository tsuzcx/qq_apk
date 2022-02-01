import android.os.Handler;
import com.tencent.qphone.base.util.QLog;

public class adjw
  extends adjl
{
  adjh a;
  boolean bNY = false;
  Handler mHandler;
  
  public adjw(Handler paramHandler)
  {
    this.mHandler = paramHandler;
  }
  
  public void a(adjm paramadjm)
  {
    this.a = ((adjh)paramadjm);
  }
  
  public boolean b(byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    paramBoolean = false;
    StringBuilder localStringBuilder1 = new StringBuilder();
    StringBuilder localStringBuilder2 = new StringBuilder();
    long l = System.currentTimeMillis();
    if (asfh.a(paramArrayOfByte, paramInt1, paramInt2, 0) == 1)
    {
      asfh.b(localStringBuilder1, localStringBuilder2);
      paramBoolean = true;
    }
    if (this.a != null)
    {
      if (!paramBoolean) {
        break label131;
      }
      this.a.G(localStringBuilder1.toString(), localStringBuilder2.toString(), false);
    }
    for (;;)
    {
      if (QLog.isColorLevel())
      {
        if (!paramBoolean) {
          break;
        }
        QLog.d("QRSession.QRRecog", 2, String.format("------> recognize QR suc. type=%s data=%s qrRecog minicode_timecost=%d", new Object[] { localStringBuilder1, localStringBuilder2, Long.valueOf(System.currentTimeMillis() - l) }));
      }
      return paramBoolean;
      label131:
      this.a.c(false, 0.0F);
    }
    QLog.d("QRSession.QRRecog", 2, String.format("------> recognize QR failed. hasQR=%s qrAreaRatio=%s qrRecog minicode_timecost=%d", new Object[] { Boolean.valueOf(false), Float.valueOf(0.0F), Long.valueOf(System.currentTimeMillis() - l) }));
    return paramBoolean;
  }
  
  public int init()
  {
    try
    {
      long l = System.currentTimeMillis();
      Object localObject = new int[2];
      localObject[0] = 2;
      localObject[1] = 1;
      int i = asfh.c(0, "ANY", "UTF-8");
      int j = asfh.d((int[])localObject, localObject.length);
      localObject = asfh.GetVersion();
      if (QLog.isColorLevel()) {
        QLog.d("QRSession.QRRecog", 2, String.format("initQbar time cost:%sms, initResult=%s readerResult=%s version=%s", new Object[] { Long.valueOf(System.currentTimeMillis() - l), Integer.valueOf(i), Integer.valueOf(j), localObject }));
      }
      this.bNY = true;
      return 0;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QRSession.QRRecog", 2, "initQbar fail!", localException);
      }
    }
    return -1;
  }
  
  public void unInit()
  {
    try
    {
      if (this.bNY)
      {
        asfh.Nn();
        this.bNY = false;
      }
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("QRSession.QRRecog", 2, "unInitQbar fail!", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adjw
 * JD-Core Version:    0.7.0.1
 */