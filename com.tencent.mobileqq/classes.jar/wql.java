import java.io.File;
import java.util.Map;

class wql
  extends wrm
{
  wql(wqk paramwqk, wgj paramwgj)
  {
    super(paramwgj);
  }
  
  protected wrp a(wro... paramVarArgs)
  {
    wrp localwrp = super.a(paramVarArgs);
    paramVarArgs = paramVarArgs[0];
    String str;
    if (localwrp.jdField_a_of_type_Int == 0) {
      str = paramVarArgs.b.substring(0, paramVarArgs.b.length() - 4);
    }
    try
    {
      zkr.d(str);
      label42:
      int i = nmk.a(paramVarArgs.b, str);
      if (i == 0)
      {
        if (wqk.a(str, false)) {
          try
          {
            paramVarArgs = this.a.a(new File(str, "config.json"));
            if (paramVarArgs != null)
            {
              yqp.d("FileDownloadTask", "parse config file success !");
              this.a.a.put(str, paramVarArgs);
              return localwrp;
            }
          }
          catch (Exception paramVarArgs)
          {
            for (;;)
            {
              yqp.c("FileDownloadTask", "parse config failed", paramVarArgs);
              paramVarArgs = null;
            }
            yqp.e("FileDownloadTask", "parse config failed : %s, %s", new Object[] { str, "config.json" });
            return new wrp(localwrp.jdField_a_of_type_Wro, -1, "illegal config file");
          }
        }
        yqp.e("FileDownloadTask", "unzip success, but this is an illegal filter folder : %s", new Object[] { str });
        return new wrp(localwrp.jdField_a_of_type_Wro, -1, "illegal folder");
      }
      yqp.e("FileDownloadTask", "download success, but unzip failed : %d", new Object[] { Integer.valueOf(i) });
      return new wrp(localwrp.jdField_a_of_type_Wro, i, "unzip failed");
    }
    catch (Exception localException)
    {
      break label42;
    }
  }
  
  protected void a(wrp arg1)
  {
    yqp.a("FileDownloadTask", "downloadConfigFile onPostExecute : %s", ???);
    if (???.jdField_a_of_type_Int == 0) {
      yqp.d("FileDownloadTask", "get filter resource success : %s", new Object[] { ???.jdField_a_of_type_Wro.jdField_a_of_type_JavaLangString });
    }
    synchronized (this.a.b)
    {
      wqk.a(this.a, null);
      this.a.d();
      return;
      yqp.d("FileDownloadTask", "get filter resource failed : %d : %s : %s", new Object[] { Integer.valueOf(???.jdField_a_of_type_Int), ???.jdField_a_of_type_JavaLangString, ???.jdField_a_of_type_Wro.jdField_a_of_type_JavaLangString });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wql
 * JD-Core Version:    0.7.0.1
 */