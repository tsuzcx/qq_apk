import java.io.File;
import java.util.Map;

class usq
  extends utr
{
  usq(usp paramusp, uio paramuio)
  {
    super(paramuio);
  }
  
  protected utu a(utt... paramVarArgs)
  {
    utu localutu = super.a(paramVarArgs);
    paramVarArgs = paramVarArgs[0];
    String str;
    if (localutu.jdField_a_of_type_Int == 0) {
      str = paramVarArgs.b.substring(0, paramVarArgs.b.length() - 4);
    }
    try
    {
      xmx.d(str);
      label42:
      int i = ndr.a(paramVarArgs.b, str);
      if (i == 0)
      {
        if (usp.a(str, false)) {
          try
          {
            paramVarArgs = this.a.a(new File(str, "config.json"));
            if (paramVarArgs != null)
            {
              wsv.d("FileDownloadTask", "parse config file success !");
              this.a.a.put(str, paramVarArgs);
              return localutu;
            }
          }
          catch (Exception paramVarArgs)
          {
            for (;;)
            {
              wsv.c("FileDownloadTask", "parse config failed", paramVarArgs);
              paramVarArgs = null;
            }
            wsv.e("FileDownloadTask", "parse config failed : %s, %s", new Object[] { str, "config.json" });
            return new utu(localutu.jdField_a_of_type_Utt, -1, "illegal config file");
          }
        }
        wsv.e("FileDownloadTask", "unzip success, but this is an illegal filter folder : %s", new Object[] { str });
        return new utu(localutu.jdField_a_of_type_Utt, -1, "illegal folder");
      }
      wsv.e("FileDownloadTask", "download success, but unzip failed : %d", new Object[] { Integer.valueOf(i) });
      return new utu(localutu.jdField_a_of_type_Utt, i, "unzip failed");
    }
    catch (Exception localException)
    {
      break label42;
    }
  }
  
  protected void a(utu arg1)
  {
    wsv.a("FileDownloadTask", "downloadConfigFile onPostExecute : %s", ???);
    if (???.jdField_a_of_type_Int == 0) {
      wsv.d("FileDownloadTask", "get filter resource success : %s", new Object[] { ???.jdField_a_of_type_Utt.jdField_a_of_type_JavaLangString });
    }
    synchronized (this.a.b)
    {
      usp.a(this.a, null);
      this.a.d();
      return;
      wsv.d("FileDownloadTask", "get filter resource failed : %d : %s : %s", new Object[] { Integer.valueOf(???.jdField_a_of_type_Int), ???.jdField_a_of_type_JavaLangString, ???.jdField_a_of_type_Utt.jdField_a_of_type_JavaLangString });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     usq
 * JD-Core Version:    0.7.0.1
 */