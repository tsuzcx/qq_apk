import java.io.File;
import java.util.Map;

class pto
  extends pue
{
  pto(ptn paramptn, pmy parampmy)
  {
    super(parampmy);
  }
  
  protected pue.b a(pue.a... paramVarArgs)
  {
    pue.b localb = super.a(paramVarArgs);
    paramVarArgs = paramVarArgs[0];
    String str;
    if (localb.errorCode == 0) {
      str = paramVarArgs.avt.substring(0, paramVarArgs.avt.length() - 4);
    }
    try
    {
      rox.fA(str);
      label42:
      int i = jqp.unZipFolder(paramVarArgs.avt, str);
      if (i == 0)
      {
        if (ptn.r(str, false)) {
          try
          {
            paramVarArgs = this.a.a(new File(str, "config.json"));
            if (paramVarArgs != null)
            {
              ram.w("FileDownloadTask", "parse config file success !");
              this.a.fM.put(str, paramVarArgs);
              return localb;
            }
          }
          catch (Exception paramVarArgs)
          {
            for (;;)
            {
              ram.e("FileDownloadTask", "parse config failed", paramVarArgs);
              paramVarArgs = null;
            }
            ram.e("FileDownloadTask", "parse config failed : %s, %s", new Object[] { str, "config.json" });
            return new pue.b(localb.b, -1, "illegal config file");
          }
        }
        ram.e("FileDownloadTask", "unzip success, but this is an illegal filter folder : %s", new Object[] { str });
        return new pue.b(localb.b, -1, "illegal folder");
      }
      ram.e("FileDownloadTask", "download success, but unzip failed : %d", new Object[] { Integer.valueOf(i) });
      return new pue.b(localb.b, i, "unzip failed");
    }
    catch (Exception localException)
    {
      break label42;
    }
  }
  
  protected void a(pue.b arg1)
  {
    ram.b("FileDownloadTask", "downloadConfigFile onPostExecute : %s", ???);
    if (???.errorCode == 0) {
      ram.w("FileDownloadTask", "get filter resource success : %s", new Object[] { ???.b.downloadUrl });
    }
    synchronized (this.a.mz)
    {
      ptn.a(this.a, null);
      this.a.bmM();
      return;
      ram.w("FileDownloadTask", "get filter resource failed : %d : %s : %s", new Object[] { Integer.valueOf(???.errorCode), ???.errorMessage, ???.b.downloadUrl });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pto
 * JD-Core Version:    0.7.0.1
 */