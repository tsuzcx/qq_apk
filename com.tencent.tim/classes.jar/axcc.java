import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class axcc
{
  private static final String TAG = axcc.class.getSimpleName();
  
  public static void a(AppInterface paramAppInterface, axbu paramaxbu, String paramString, axcc.b paramb)
  {
    if (paramaxbu == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "startDownloadMaterial is null");
      }
      return;
    }
    b(paramAppInterface, paramaxbu, paramString, paramb);
  }
  
  private static void b(AppInterface paramAppInterface, axbu paramaxbu, String paramString, axcc.b paramb)
  {
    if ((paramaxbu == null) || (paramAppInterface == null)) {}
    for (;;)
    {
      return;
      paramaxbu.startDownloadTime = System.currentTimeMillis();
      paramaxbu.downloading = true;
      aoll localaoll = new aoll();
      localaoll.f = new axcc.a(paramaxbu, paramString, paramb);
      localaoll.bZ = paramaxbu.resurl;
      localaoll.mHttpMethod = 0;
      if (paramaxbu.name == null)
      {
        QLog.i(TAG, 1, "startDownloadMaterial fail, info.name is null, url:" + paramaxbu.resurl);
        return;
      }
      localaoll.atY = new File(paramString, paramaxbu.name).getPath();
      localaoll.mContinuErrorLimit = aqiw.kb(aomi.a().getNetType());
      localaoll.mExcuteTimeLimit = 60000L;
      try
      {
        paramAppInterface.getNetEngine(0).a(localaoll);
        localaoll.f.onUpdateProgeress(localaoll, 1L, 100L);
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i(TAG, 2, "startDownloadMaterial url: " + paramaxbu.resurl);
        return;
      }
      catch (Exception paramAppInterface)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            paramAppInterface.printStackTrace();
          }
        }
      }
    }
  }
  
  static class a
    implements aolm.b
  {
    private axcc.b c;
    private String cTJ;
    private axbu j;
    
    public a(axbu paramaxbu, String paramString, axcc.b paramb)
    {
      this.j = paramaxbu;
      this.cTJ = paramString;
      this.c = paramb;
    }
    
    public void onResp(aomh paramaomh)
    {
      long l2 = 0L;
      if (QLog.isColorLevel()) {
        QLog.i(axcc.TAG, 2, "onResp url: " + this.j.resurl + " resultcode: " + paramaomh.dPy);
      }
      if ((this.j instanceof axbz)) {
        awxe.a((axbz)this.j);
      }
      for (this.j.usable = true;; this.j.usable = axbr.b(this.j))
      {
        this.j.downloading = false;
        if (this.c != null) {
          this.c.a(this.j, this.j.usable);
        }
        if (paramaomh.mErrCode == 0) {
          break;
        }
        axim.a().e(this.j.id, paramaomh.mErrCode, paramaomh.reqCost, 0L, this.j.md5);
        return;
      }
      if ((paramaomh.mErrCode == 0) && (!this.j.usable))
      {
        axim.a().e(this.j.id, 1111, paramaomh.reqCost, 0L, this.j.md5);
        return;
      }
      File localFile = new File(this.cTJ, this.j.name);
      long l1 = l2;
      if (localFile.exists())
      {
        l1 = l2;
        if (localFile.isFile()) {
          l1 = localFile.length();
        }
      }
      axim.a().e(this.j.id, paramaomh.mErrCode, paramaomh.reqCost, l1, this.j.md5);
    }
    
    public void onUpdateProgeress(aomg paramaomg, long paramLong1, long paramLong2)
    {
      this.j.totalLen = paramLong2;
      this.j.eEx = ((int)(100L * paramLong1 / paramLong2));
      if (this.c != null) {
        this.c.a(this.j, this.j.eEx);
      }
    }
  }
  
  public static abstract interface b
  {
    public abstract void a(axbu paramaxbu, int paramInt);
    
    public abstract void a(axbu paramaxbu, boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axcc
 * JD-Core Version:    0.7.0.1
 */