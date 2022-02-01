import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import java.io.File;
import java.util.Map;

class vmx
  extends vne
{
  public vmx(vmu paramvmu)
  {
    super("Q.qqstory.download.preload.PlayingListPreloader");
  }
  
  public void a(String paramString, int paramInt1, ErrorMessage paramErrorMessage, int paramInt2, vmp paramvmp)
  {
    super.a(paramString, paramInt1, paramErrorMessage, paramInt2, paramvmp);
    a(paramString, paramInt1, paramErrorMessage, paramvmp);
  }
  
  protected void a(String paramString, int paramInt, ErrorMessage paramErrorMessage, vmp paramvmp)
  {
    vmw localvmw = this.a.jdField_a_of_type_Vmw;
    if (localvmw == null) {}
    label14:
    label169:
    do
    {
      break label14;
      do
      {
        return;
      } while (!TextUtils.equals(paramString, localvmw.jdField_a_of_type_JavaLangString));
      if (paramErrorMessage.isFail()) {
        if (!TextUtils.isEmpty(localvmw.b)) {
          break label136;
        }
      }
      for (paramErrorMessage = paramErrorMessage.errorMsg;; paramErrorMessage = paramErrorMessage.errorMsg + " | " + paramErrorMessage.errorMsg)
      {
        localvmw.b = paramErrorMessage;
        localvmw.jdField_a_of_type_Int = (paramInt + 1000);
        if ((!paramvmp.a.containsKey("handleCallback")) || (localvmw.jdField_a_of_type_Boolean)) {
          break;
        }
        localvmw.jdField_a_of_type_Boolean = true;
        if (!this.a.a(paramString)) {
          break label169;
        }
        if (this.a.jdField_a_of_type_Vmy == null) {
          break;
        }
        this.a.jdField_a_of_type_Vmy.a(paramString, paramvmp.d, paramInt);
        return;
      }
    } while (this.a.jdField_a_of_type_Vmy == null);
    label136:
    this.a.jdField_a_of_type_Vmy.a(paramString, paramvmp.d, localvmw.a(), paramInt);
  }
  
  public void b(String paramString, int paramInt1, File paramFile, int paramInt2, vmp paramvmp)
  {
    super.b(paramString, paramInt1, paramFile, paramInt2, paramvmp);
    a(paramString, paramInt1, new ErrorMessage(), paramvmp);
  }
  
  public void b(String paramString, int paramInt, vmp paramvmp)
  {
    super.b(paramString, paramInt, paramvmp);
    if ((this.a.jdField_a_of_type_Vmy != null) && ((paramInt == 0) || (paramInt == 1))) {
      this.a.jdField_a_of_type_Vmy.b(paramString, paramvmp.d, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vmx
 * JD-Core Version:    0.7.0.1
 */