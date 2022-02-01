package wf7;

import android.os.Environment;
import android.text.TextUtils;
import com.tencent.wifisdk.services.common.api.e;
import java.io.File;

@Deprecated
public class fm
{
  private static final String TAG = "fm";
  private static fm qt;
  
  public static fm dL()
  {
    if (qt == null) {
      try
      {
        if (qt == null) {
          qt = new fm();
        }
      }
      finally {}
    }
    return qt;
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
    if (hl.ad("com.tencent.wifimanager")) {
      return null;
    }
    Object localObject = dM().getString("ncdk111");
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (hl.ab((String)localObject) == 1)) {
      return new fm.a((String)localObject, false);
    }
    if (dj.f(fq.cr()))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(Environment.getExternalStorageDirectory().getPath());
      ((StringBuilder)localObject).append(File.separator);
      ((StringBuilder)localObject).append(hc.sF);
      ((StringBuilder)localObject).append("com.tencent.wifimanager");
      ((StringBuilder)localObject).append(".apk");
      localObject = ((StringBuilder)localObject).toString();
      if (new File((String)localObject).exists()) {
        return new fm.a((String)localObject, true);
      }
    }
    return null;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     wf7.fm
 * JD-Core Version:    0.7.0.1
 */