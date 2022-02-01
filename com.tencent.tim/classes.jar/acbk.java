import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.Utils;
import com.tencent.mobileqq.apollo.view.QQFrameZipDecoder.2;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import java.io.File;

public class acbk
  extends acbm
  implements acbm.b
{
  public acbk(acbm.c paramc)
  {
    super(null, paramc);
    this.a = this;
  }
  
  public static String jb(String paramString)
  {
    paramString = Utils.Crc64String(paramString);
    String str = abxi.biw;
    return str + paramString + ".zip";
  }
  
  public void a(acbm paramacbm, String paramString1, String paramString2, String paramString3)
  {
    this.mState = 1;
    aquz localaquz = new aquz(paramString1, new File(paramString2));
    localaquz.cWy = true;
    localaquz.cWw = true;
    localaquz.cxX = "apollo_gif";
    localaquz.retryCount = 1;
    localaquz.cWz = true;
    localaquz.cWA = true;
    localaquz.c(new acbl(this, paramString1, paramString2, paramString3));
    paramacbm = BaseApplicationImpl.getApplication();
    if (paramacbm != null)
    {
      paramacbm = paramacbm.getRuntime();
      if (!(paramacbm instanceof QQAppInterface)) {}
    }
    for (paramacbm = (QQAppInterface)paramacbm;; paramacbm = null)
    {
      if (paramacbm != null)
      {
        paramacbm = (aqva)paramacbm.getManager(47);
        if (paramacbm != null)
        {
          paramacbm = paramacbm.a(3);
          if (paramacbm != null) {
            paramacbm.a(localaquz, localaquz.a(), null);
          }
        }
      }
      for (int i = 0;; i = 1)
      {
        if (i != 0) {
          ThreadManager.executeOnNetWorkThread(new QQFrameZipDecoder.2(this, localaquz));
        }
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acbk
 * JD-Core Version:    0.7.0.1
 */