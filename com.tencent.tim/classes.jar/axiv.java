import android.support.annotation.IntRange;
import android.support.annotation.Nullable;
import android.support.annotation.WorkerThread;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class axiv
{
  public static axiv a()
  {
    return axiv.c.a;
  }
  
  @WorkerThread
  private static void b(String paramString1, String paramString2, axiv.a parama)
  {
    axiy.i("AEDownloader", "realDownload---url=" + paramString1 + ", saveName=" + paramString2);
    AppInterface localAppInterface = axol.getAppInterface();
    if (localAppInterface == null)
    {
      if (parama != null) {
        parama.j(null);
      }
      axiy.e("AEDownloader", "realDownload---FAIL appInterface is null");
    }
    do
    {
      return;
      aoll localaoll = new aoll();
      localaoll.f = new axiv.b(paramString1, paramString2, parama);
      localaoll.bZ = paramString1;
      localaoll.mHttpMethod = 0;
      localaoll.atY = new File(paramString2).getPath();
      localaoll.mContinuErrorLimit = aqiw.kb(aomi.a().getNetType());
      localaoll.mExcuteTimeLimit = 60000L;
      try
      {
        localAppInterface.getNetEngine(0).a(localaoll);
        return;
      }
      catch (Exception paramString1)
      {
        if (QLog.isColorLevel()) {
          paramString1.printStackTrace();
        }
        axiy.e("AEDownloader", "realDownload---exception: ", paramString1);
      }
    } while (parama == null);
    parama.j(null);
  }
  
  public void a(String paramString1, String paramString2, axiv.a parama)
  {
    b(paramString1, paramString2, parama);
  }
  
  public static abstract interface a
  {
    public abstract void j(@Nullable aomh paramaomh);
    
    public abstract void onProgressUpdate(@IntRange(from=0L, to=100L) int paramInt);
  }
  
  static class b
    implements aolm.b
  {
    private axiv.a a;
    private String cUZ;
    private String url;
    
    b(String paramString1, String paramString2, axiv.a parama)
    {
      this.url = paramString1;
      this.cUZ = paramString2;
      this.a = parama;
    }
    
    public void onResp(aomh paramaomh)
    {
      axiy.i("AEDownloader", "onResp url: " + this.url + " resultcode: " + paramaomh.mResult);
      if (this.a != null) {
        this.a.j(paramaomh);
      }
    }
    
    public void onUpdateProgeress(aomg paramaomg, long paramLong1, long paramLong2)
    {
      if (this.a != null) {
        this.a.onProgressUpdate((int)((float)paramLong1 / (float)paramLong2) * 100);
      }
    }
  }
  
  public static class c
  {
    public static axiv a = new axiv();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axiv
 * JD-Core Version:    0.7.0.1
 */