package wf7;

import android.os.Environment;
import android.text.TextUtils;
import com.tencent.wifisdk.services.common.api.e;
import java.io.File;

@Deprecated
public class fm
{
  private static final String TAG = fm.class.getSimpleName();
  private static fm qt = null;
  
  public static fm dL()
  {
    if (qt == null) {}
    try
    {
      if (qt == null) {
        qt = new fm();
      }
      return qt;
    }
    finally {}
  }
  
  public void J(String paramString)
  {
    dM().b("ncdk103", paramString);
  }
  
  public void K(String paramString)
  {
    dM().b("ncdk111", paramString);
  }
  
  public void aq(int paramInt)
  {
    dM().m("kllims", paramInt);
  }
  
  public e dM()
  {
    return new hh(fq.cr(), "wifisdk_ncf134");
  }
  
  public String dN()
  {
    return dM().getString("ncdk103", null);
  }
  
  public fm.a dO()
  {
    if (hl.ad("com.tencent.wifimanager")) {}
    String str;
    do
    {
      do
      {
        return null;
        str = dM().getString("ncdk111");
        if ((!TextUtils.isEmpty(str)) && (hl.ab(str) == 1)) {
          return new fm.a(str, false);
        }
      } while (!dj.f(fq.cr()));
      str = Environment.getExternalStorageDirectory().getPath() + File.separator + hc.sF + "com.tencent.wifimanager" + ".apk";
    } while (!new File(str).exists());
    return new fm.a(str, true);
  }
  
  public long dP()
  {
    return dM().getLong("kliimt", -1L);
  }
  
  public void dQ()
  {
    dM().L("kliimt");
  }
  
  public int dR()
  {
    return dM().getInt("kllims", -1);
  }
  
  public void dS()
  {
    dM().L("kllims");
  }
  
  public void f(long paramLong)
  {
    dM().a("kliimt", paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wf7.fm
 * JD-Core Version:    0.7.0.1
 */