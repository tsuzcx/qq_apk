import android.text.TextUtils;
import java.io.File;
import java.util.Map;

public class whl
  extends wje
{
  private String a;
  public xcs a;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean;
  
  public whl()
  {
    this("", null, false);
  }
  
  public whl(String paramString1, String paramString2, boolean paramBoolean)
  {
    a(false, true);
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_c_of_type_JavaLangString = paramString2;
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
  
  public void a()
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      a(this.jdField_a_of_type_JavaLangString);
      return;
    }
    b(false);
  }
  
  public void a(String paramString)
  {
    File localFile1 = new File(this.jdField_c_of_type_JavaLangString);
    try
    {
      File localFile2 = localFile1.getParentFile();
      if ((localFile2 != null) && (!localFile2.exists())) {
        localFile2.mkdirs();
      }
      if (localFile1.exists()) {
        localFile1.delete();
      }
    }
    catch (Exception localException)
    {
      label45:
      break label45;
    }
    this.jdField_a_of_type_Xcs = new xcp();
    this.jdField_a_of_type_Xcs.a(paramString, 0, 0, new whm(this, paramString));
  }
  
  protected void a(Map<String, Object> paramMap)
  {
    if ((paramMap != null) && (!paramMap.isEmpty()))
    {
      if (paramMap.containsKey("DownloadPic2FileJob_iiu")) {
        this.jdField_a_of_type_JavaLangString = ((String)a("DownloadPic2FileJob_iiu"));
      }
      if (paramMap.containsKey("DownloadPic2FileJob_isfp")) {
        this.jdField_c_of_type_JavaLangString = ((String)a("DownloadPic2FileJob_isfp"));
      }
      if (paramMap.containsKey("DownloadPic2FileJob_IN_ROUND")) {
        this.jdField_c_of_type_Boolean = ((Boolean)a("DownloadPic2FileJob_IN_ROUND")).booleanValue();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     whl
 * JD-Core Version:    0.7.0.1
 */