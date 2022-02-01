import java.io.File;
import java.util.Map;

class wug
  extends wvh
{
  wug(wuf paramwuf, wke paramwke)
  {
    super(paramwke);
  }
  
  protected wvk a(wvj... paramVarArgs)
  {
    wvk localwvk = super.a(paramVarArgs);
    paramVarArgs = paramVarArgs[0];
    String str;
    if (localwvk.jdField_a_of_type_Int == 0) {
      str = paramVarArgs.b.substring(0, paramVarArgs.b.length() - 4);
    }
    try
    {
      zom.d(str);
      label42:
      int i = nof.a(paramVarArgs.b, str);
      if (i == 0)
      {
        if (wuf.a(str, false)) {
          try
          {
            paramVarArgs = this.a.a(new File(str, "config.json"));
            if (paramVarArgs != null)
            {
              yuk.d("FileDownloadTask", "parse config file success !");
              this.a.a.put(str, paramVarArgs);
              return localwvk;
            }
          }
          catch (Exception paramVarArgs)
          {
            for (;;)
            {
              yuk.c("FileDownloadTask", "parse config failed", paramVarArgs);
              paramVarArgs = null;
            }
            yuk.e("FileDownloadTask", "parse config failed : %s, %s", new Object[] { str, "config.json" });
            return new wvk(localwvk.jdField_a_of_type_Wvj, -1, "illegal config file");
          }
        }
        yuk.e("FileDownloadTask", "unzip success, but this is an illegal filter folder : %s", new Object[] { str });
        return new wvk(localwvk.jdField_a_of_type_Wvj, -1, "illegal folder");
      }
      yuk.e("FileDownloadTask", "download success, but unzip failed : %d", new Object[] { Integer.valueOf(i) });
      return new wvk(localwvk.jdField_a_of_type_Wvj, i, "unzip failed");
    }
    catch (Exception localException)
    {
      break label42;
    }
  }
  
  protected void a(wvk arg1)
  {
    yuk.a("FileDownloadTask", "downloadConfigFile onPostExecute : %s", ???);
    if (???.jdField_a_of_type_Int == 0) {
      yuk.d("FileDownloadTask", "get filter resource success : %s", new Object[] { ???.jdField_a_of_type_Wvj.jdField_a_of_type_JavaLangString });
    }
    synchronized (this.a.b)
    {
      wuf.a(this.a, null);
      this.a.d();
      return;
      yuk.d("FileDownloadTask", "get filter resource failed : %d : %s : %s", new Object[] { Integer.valueOf(???.jdField_a_of_type_Int), ???.jdField_a_of_type_JavaLangString, ???.jdField_a_of_type_Wvj.jdField_a_of_type_JavaLangString });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wug
 * JD-Core Version:    0.7.0.1
 */