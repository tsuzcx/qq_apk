import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import java.io.File;
import java.util.Map;

class vcd
  extends sux
{
  public vcd(vca paramvca)
  {
    super("Q.qqstory.download.preload.FeedVideoPreloader");
  }
  
  public void a(String paramString, int paramInt1, ErrorMessage paramErrorMessage, int paramInt2, sui paramsui)
  {
    super.a(paramString, paramInt1, paramErrorMessage, paramInt2, paramsui);
    a(paramString, paramInt1, paramErrorMessage, paramsui);
  }
  
  protected void a(String paramString, int paramInt, ErrorMessage paramErrorMessage, sui paramsui)
  {
    vcc localvcc = this.a.jdField_a_of_type_Vcc;
    if (localvcc == null) {}
    label14:
    label168:
    do
    {
      break label14;
      do
      {
        return;
      } while (!TextUtils.equals(paramString, localvcc.jdField_a_of_type_JavaLangString));
      if (paramErrorMessage.isFail()) {
        if (!TextUtils.isEmpty(localvcc.b)) {
          break label135;
        }
      }
      for (paramErrorMessage = paramErrorMessage.errorMsg;; paramErrorMessage = paramErrorMessage.errorMsg + " | " + paramErrorMessage.errorMsg)
      {
        localvcc.b = paramErrorMessage;
        localvcc.jdField_a_of_type_Int = (paramInt + 1000);
        if ((!paramsui.a.containsKey("handleCallback")) || (localvcc.jdField_a_of_type_Boolean)) {
          break;
        }
        localvcc.jdField_a_of_type_Boolean = true;
        if (!this.a.a(paramString)) {
          break label168;
        }
        if (this.a.jdField_a_of_type_Vce == null) {
          break;
        }
        this.a.jdField_a_of_type_Vce.a(paramString, paramsui.d);
        return;
      }
    } while (this.a.jdField_a_of_type_Vce == null);
    label135:
    this.a.jdField_a_of_type_Vce.a(paramString, paramsui.d, localvcc.a());
  }
  
  public void b(String paramString, int paramInt1, File paramFile, int paramInt2, sui paramsui)
  {
    super.b(paramString, paramInt1, paramFile, paramInt2, paramsui);
    a(paramString, paramInt1, new ErrorMessage(), paramsui);
  }
  
  public void b(String paramString, int paramInt, sui paramsui)
  {
    super.b(paramString, paramInt, paramsui);
    if ((this.a.jdField_a_of_type_Vce != null) && ((paramInt == 0) || (paramInt == 1))) {
      this.a.jdField_a_of_type_Vce.b(paramString, paramsui.d);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vcd
 * JD-Core Version:    0.7.0.1
 */