import java.io.File;
import java.util.Map;

class uwz
  extends uya
{
  uwz(uwy paramuwy, umx paramumx)
  {
    super(paramumx);
  }
  
  protected uyd a(uyc... paramVarArgs)
  {
    uyd localuyd = super.a(paramVarArgs);
    paramVarArgs = paramVarArgs[0];
    String str;
    if (localuyd.jdField_a_of_type_Int == 0) {
      str = paramVarArgs.b.substring(0, paramVarArgs.b.length() - 4);
    }
    try
    {
      xrg.d(str);
      label42:
      int i = ndr.a(paramVarArgs.b, str);
      if (i == 0)
      {
        if (uwy.a(str, false)) {
          try
          {
            paramVarArgs = this.a.a(new File(str, "config.json"));
            if (paramVarArgs != null)
            {
              wxe.d("FileDownloadTask", "parse config file success !");
              this.a.a.put(str, paramVarArgs);
              return localuyd;
            }
          }
          catch (Exception paramVarArgs)
          {
            for (;;)
            {
              wxe.c("FileDownloadTask", "parse config failed", paramVarArgs);
              paramVarArgs = null;
            }
            wxe.e("FileDownloadTask", "parse config failed : %s, %s", new Object[] { str, "config.json" });
            return new uyd(localuyd.jdField_a_of_type_Uyc, -1, "illegal config file");
          }
        }
        wxe.e("FileDownloadTask", "unzip success, but this is an illegal filter folder : %s", new Object[] { str });
        return new uyd(localuyd.jdField_a_of_type_Uyc, -1, "illegal folder");
      }
      wxe.e("FileDownloadTask", "download success, but unzip failed : %d", new Object[] { Integer.valueOf(i) });
      return new uyd(localuyd.jdField_a_of_type_Uyc, i, "unzip failed");
    }
    catch (Exception localException)
    {
      break label42;
    }
  }
  
  protected void a(uyd arg1)
  {
    wxe.a("FileDownloadTask", "downloadConfigFile onPostExecute : %s", ???);
    if (???.jdField_a_of_type_Int == 0) {
      wxe.d("FileDownloadTask", "get filter resource success : %s", new Object[] { ???.jdField_a_of_type_Uyc.jdField_a_of_type_JavaLangString });
    }
    synchronized (this.a.b)
    {
      uwy.a(this.a, null);
      this.a.d();
      return;
      wxe.d("FileDownloadTask", "get filter resource failed : %d : %s : %s", new Object[] { Integer.valueOf(???.jdField_a_of_type_Int), ???.jdField_a_of_type_JavaLangString, ???.jdField_a_of_type_Uyc.jdField_a_of_type_JavaLangString });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     uwz
 * JD-Core Version:    0.7.0.1
 */