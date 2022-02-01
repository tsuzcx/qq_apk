import java.io.File;
import java.util.Map;

class wkr
  extends wls
{
  wkr(wkq paramwkq, way paramway)
  {
    super(paramway);
  }
  
  protected wlv a(wlu... paramVarArgs)
  {
    wlv localwlv = super.a(paramVarArgs);
    paramVarArgs = paramVarArgs[0];
    String str;
    if (localwlv.jdField_a_of_type_Int == 0) {
      str = paramVarArgs.b.substring(0, paramVarArgs.b.length() - 4);
    }
    try
    {
      zeb.d(str);
      label42:
      int i = nwp.a(paramVarArgs.b, str);
      if (i == 0)
      {
        if (wkq.a(str, false)) {
          try
          {
            paramVarArgs = this.a.a(new File(str, "config.json"));
            if (paramVarArgs != null)
            {
              ykq.d("FileDownloadTask", "parse config file success !");
              this.a.a.put(str, paramVarArgs);
              return localwlv;
            }
          }
          catch (Exception paramVarArgs)
          {
            for (;;)
            {
              ykq.c("FileDownloadTask", "parse config failed", paramVarArgs);
              paramVarArgs = null;
            }
            ykq.e("FileDownloadTask", "parse config failed : %s, %s", new Object[] { str, "config.json" });
            return new wlv(localwlv.jdField_a_of_type_Wlu, -1, "illegal config file");
          }
        }
        ykq.e("FileDownloadTask", "unzip success, but this is an illegal filter folder : %s", new Object[] { str });
        return new wlv(localwlv.jdField_a_of_type_Wlu, -1, "illegal folder");
      }
      ykq.e("FileDownloadTask", "download success, but unzip failed : %d", new Object[] { Integer.valueOf(i) });
      return new wlv(localwlv.jdField_a_of_type_Wlu, i, "unzip failed");
    }
    catch (Exception localException)
    {
      break label42;
    }
  }
  
  protected void a(wlv arg1)
  {
    ykq.a("FileDownloadTask", "downloadConfigFile onPostExecute : %s", ???);
    if (???.jdField_a_of_type_Int == 0) {
      ykq.d("FileDownloadTask", "get filter resource success : %s", new Object[] { ???.jdField_a_of_type_Wlu.jdField_a_of_type_JavaLangString });
    }
    synchronized (this.a.b)
    {
      wkq.a(this.a, null);
      this.a.d();
      return;
      ykq.d("FileDownloadTask", "get filter resource failed : %d : %s : %s", new Object[] { Integer.valueOf(???.jdField_a_of_type_Int), ???.jdField_a_of_type_JavaLangString, ???.jdField_a_of_type_Wlu.jdField_a_of_type_JavaLangString });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wkr
 * JD-Core Version:    0.7.0.1
 */