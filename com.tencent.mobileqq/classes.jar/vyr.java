import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashSet;
import java.util.Set;

class vyr
  extends vne
{
  private final Set<String> jdField_a_of_type_JavaUtilSet = new HashSet();
  
  public vyr(vyn paramvyn)
  {
    super("MsgTabStoryVideoPreloader");
  }
  
  public void a(String paramString, int paramInt1, ErrorMessage paramErrorMessage, int paramInt2, vmp paramvmp)
  {
    super.a(paramString, paramInt1, paramErrorMessage, paramInt2, paramvmp);
    if (paramInt2 == 2)
    {
      if (QLog.isColorLevel()) {
        QLog.e("MsgTabStoryVideoPreloader", 2, "download error: vid=" + paramString + " fileType=" + paramInt1, paramErrorMessage);
      }
      this.jdField_a_of_type_Vyn.a(paramvmp.c, true);
    }
  }
  
  public void a(String paramString, int paramInt1, File paramFile, int paramInt2, vmp paramvmp)
  {
    super.a(paramString, paramInt1, paramFile, paramInt2, paramvmp);
    if (paramInt2 == 2)
    {
      if (QLog.isColorLevel()) {
        QLog.i("MsgTabStoryVideoPreloader", 2, "download success before: vid=" + paramString + " fileType=" + paramInt1);
      }
      this.jdField_a_of_type_Vyn.a(paramvmp.c, true);
    }
  }
  
  public void b(String paramString, int paramInt1, File paramFile, int paramInt2, vmp paramvmp)
  {
    super.b(paramString, paramInt1, paramFile, paramInt2, paramvmp);
    if (paramInt2 == 2)
    {
      if (QLog.isColorLevel()) {
        QLog.i("MsgTabStoryVideoPreloader", 2, "download success: vid=" + paramString + " fileType=" + paramInt1);
      }
      this.jdField_a_of_type_Vyn.a(paramvmp.c, this.jdField_a_of_type_JavaUtilSet.add(paramString));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vyr
 * JD-Core Version:    0.7.0.1
 */