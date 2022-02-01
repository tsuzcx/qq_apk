import java.io.File;
import java.util.Map;

class vvw
  extends vwx
{
  vvw(vvv paramvvv, vmd paramvmd)
  {
    super(paramvmd);
  }
  
  protected vxa a(vwz... paramVarArgs)
  {
    vxa localvxa = super.a(paramVarArgs);
    paramVarArgs = paramVarArgs[0];
    String str;
    if (localvxa.jdField_a_of_type_Int == 0) {
      str = paramVarArgs.b.substring(0, paramVarArgs.b.length() - 4);
    }
    try
    {
      ypi.d(str);
      label42:
      int i = npo.a(paramVarArgs.b, str);
      if (i == 0)
      {
        if (vvv.a(str, false)) {
          try
          {
            paramVarArgs = this.a.a(new File(str, "config.json"));
            if (paramVarArgs != null)
            {
              xvv.d("FileDownloadTask", "parse config file success !");
              this.a.a.put(str, paramVarArgs);
              return localvxa;
            }
          }
          catch (Exception paramVarArgs)
          {
            for (;;)
            {
              xvv.c("FileDownloadTask", "parse config failed", paramVarArgs);
              paramVarArgs = null;
            }
            xvv.e("FileDownloadTask", "parse config failed : %s, %s", new Object[] { str, "config.json" });
            return new vxa(localvxa.jdField_a_of_type_Vwz, -1, "illegal config file");
          }
        }
        xvv.e("FileDownloadTask", "unzip success, but this is an illegal filter folder : %s", new Object[] { str });
        return new vxa(localvxa.jdField_a_of_type_Vwz, -1, "illegal folder");
      }
      xvv.e("FileDownloadTask", "download success, but unzip failed : %d", new Object[] { Integer.valueOf(i) });
      return new vxa(localvxa.jdField_a_of_type_Vwz, i, "unzip failed");
    }
    catch (Exception localException)
    {
      break label42;
    }
  }
  
  protected void a(vxa arg1)
  {
    xvv.a("FileDownloadTask", "downloadConfigFile onPostExecute : %s", ???);
    if (???.jdField_a_of_type_Int == 0) {
      xvv.d("FileDownloadTask", "get filter resource success : %s", new Object[] { ???.jdField_a_of_type_Vwz.jdField_a_of_type_JavaLangString });
    }
    synchronized (this.a.b)
    {
      vvv.a(this.a, null);
      this.a.d();
      return;
      xvv.d("FileDownloadTask", "get filter resource failed : %d : %s : %s", new Object[] { Integer.valueOf(???.jdField_a_of_type_Int), ???.jdField_a_of_type_JavaLangString, ???.jdField_a_of_type_Vwz.jdField_a_of_type_JavaLangString });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vvw
 * JD-Core Version:    0.7.0.1
 */