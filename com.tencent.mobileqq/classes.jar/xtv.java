import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import java.io.File;
import java.util.Map;

class xtv
  extends vne
{
  public xtv(xts paramxts)
  {
    super("Q.qqstory.download.preload.FeedVideoPreloader");
  }
  
  public void a(String paramString, int paramInt1, ErrorMessage paramErrorMessage, int paramInt2, vmp paramvmp)
  {
    super.a(paramString, paramInt1, paramErrorMessage, paramInt2, paramvmp);
    a(paramString, paramInt1, paramErrorMessage, paramvmp);
  }
  
  protected void a(String paramString, int paramInt, ErrorMessage paramErrorMessage, vmp paramvmp)
  {
    xtu localxtu = this.a.jdField_a_of_type_Xtu;
    if (localxtu == null) {}
    label14:
    label168:
    do
    {
      break label14;
      do
      {
        return;
      } while (!TextUtils.equals(paramString, localxtu.jdField_a_of_type_JavaLangString));
      if (paramErrorMessage.isFail()) {
        if (!TextUtils.isEmpty(localxtu.b)) {
          break label135;
        }
      }
      for (paramErrorMessage = paramErrorMessage.errorMsg;; paramErrorMessage = paramErrorMessage.errorMsg + " | " + paramErrorMessage.errorMsg)
      {
        localxtu.b = paramErrorMessage;
        localxtu.jdField_a_of_type_Int = (paramInt + 1000);
        if ((!paramvmp.a.containsKey("handleCallback")) || (localxtu.jdField_a_of_type_Boolean)) {
          break;
        }
        localxtu.jdField_a_of_type_Boolean = true;
        if (!this.a.a(paramString)) {
          break label168;
        }
        if (this.a.jdField_a_of_type_Xtw == null) {
          break;
        }
        this.a.jdField_a_of_type_Xtw.a(paramString, paramvmp.d);
        return;
      }
    } while (this.a.jdField_a_of_type_Xtw == null);
    label135:
    this.a.jdField_a_of_type_Xtw.a(paramString, paramvmp.d, localxtu.a());
  }
  
  public void b(String paramString, int paramInt1, File paramFile, int paramInt2, vmp paramvmp)
  {
    super.b(paramString, paramInt1, paramFile, paramInt2, paramvmp);
    a(paramString, paramInt1, new ErrorMessage(), paramvmp);
  }
  
  public void b(String paramString, int paramInt, vmp paramvmp)
  {
    super.b(paramString, paramInt, paramvmp);
    if ((this.a.jdField_a_of_type_Xtw != null) && ((paramInt == 0) || (paramInt == 1))) {
      this.a.jdField_a_of_type_Xtw.b(paramString, paramvmp.d);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xtv
 * JD-Core Version:    0.7.0.1
 */