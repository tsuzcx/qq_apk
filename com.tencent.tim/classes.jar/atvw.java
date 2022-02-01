import android.util.Base64;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tim.filemanager.activity.FilePreviewActivity.a;
import com.tencent.tim.filemanager.core.WpsFilePreviewController.1;
import mqq.os.MqqHandler;

public class atvw
  extends attt
{
  private String TAG = "WpsFilePreviewController";
  private long Yw;
  private String cIh;
  private String cIi;
  private String cIj;
  private String cIk;
  private String cIl;
  private String cIm;
  private int erh;
  private int eri;
  
  public atvw(int paramInt)
  {
    this.eri = paramInt;
  }
  
  public String EZ()
  {
    return this.cIl;
  }
  
  public int Em()
  {
    switch (this.eri)
    {
    default: 
      QLog.e(this.TAG, 1, "sendCS SourceType[" + this.eri + "] not recognized");
      return 0;
    case 1: 
      return 11;
    case 2: 
      return 12;
    case 3: 
      return 13;
    case 4: 
      return 14;
    case 5: 
      return 15;
    }
    return 16;
  }
  
  public boolean alr()
  {
    if (this.a == null)
    {
      QLog.e(this.TAG, 1, "sendCS callback is null");
      return false;
    }
    QLog.d(this.TAG, 1, "sendCS Uuid:" + this.cIh + " SHA:" + this.cIi + " MD5:" + this.cIj + " FileSize:" + this.Yw);
    if ((this.cIh == null) || (this.cIh.length() == 0))
    {
      QLog.e(this.TAG, 1, "sendCS mstrUuid is null");
      this.a.g(false, this.cIh, this.cIk, this.erh);
      return false;
    }
    if ((this.cIi != null) && (this.cIi.length() != 0)) {
      this.cIk = this.cIi;
    }
    for (;;)
    {
      this.cIk += this.Yw;
      QLog.d(this.TAG, 1, "sendCS strDownloadKey:" + this.cIk);
      ThreadManager.getUIHandler().post(new WpsFilePreviewController.1(this));
      return true;
      if ((this.cIj != null) && (this.cIj.length() != 0)) {
        this.cIk = this.cIj;
      } else if ((this.cIh != null) && (this.cIh.length() != 0)) {
        this.cIk = aqhs.bytes2HexStr(new MD5().getMD5(this.cIh.getBytes(), 0, this.cIh.length()));
      }
    }
  }
  
  public void clear()
  {
    this.a = null;
  }
  
  public void g(byte[] paramArrayOfByte, String paramString)
  {
    if (paramArrayOfByte != null) {
      this.cIl = Base64.encodeToString(paramArrayOfByte, 0);
    }
    this.cIh = paramString;
  }
  
  public int getAppId()
  {
    switch (this.eri)
    {
    default: 
      QLog.e(this.TAG, 1, "sendCS SourceType[" + this.eri + "] not recognized");
    case 3: 
      return 0;
    case 1: 
      return 3;
    case 2: 
      return 106;
    case 4: 
      return 25;
    case 5: 
      return 77;
    }
    return 236;
  }
  
  public String getUin()
  {
    return this.cIm;
  }
  
  public void o(Boolean paramBoolean)
  {
    if (paramBoolean.booleanValue())
    {
      this.erh = 1;
      return;
    }
    this.erh = 2;
  }
  
  public void setUin(String paramString)
  {
    this.cIm = paramString;
  }
  
  public void y(String paramString1, String paramString2, long paramLong)
  {
    this.cIi = paramString1;
    this.cIj = paramString2;
    this.Yw = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atvw
 * JD-Core Version:    0.7.0.1
 */