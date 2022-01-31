import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import java.io.File;
import java.util.Map;

class unr
  extends uny
{
  public unr(uno paramuno)
  {
    super("Q.qqstory.download.preload.PlayingListPreloader");
  }
  
  public void a(String paramString, int paramInt1, ErrorMessage paramErrorMessage, int paramInt2, unj paramunj)
  {
    super.a(paramString, paramInt1, paramErrorMessage, paramInt2, paramunj);
    a(paramString, paramInt1, paramErrorMessage, paramunj);
  }
  
  protected void a(String paramString, int paramInt, ErrorMessage paramErrorMessage, unj paramunj)
  {
    unq localunq = this.a.jdField_a_of_type_Unq;
    if (localunq == null) {}
    label14:
    label169:
    do
    {
      break label14;
      do
      {
        return;
      } while (!TextUtils.equals(paramString, localunq.jdField_a_of_type_JavaLangString));
      if (paramErrorMessage.isFail()) {
        if (!TextUtils.isEmpty(localunq.b)) {
          break label136;
        }
      }
      for (paramErrorMessage = paramErrorMessage.errorMsg;; paramErrorMessage = paramErrorMessage.errorMsg + " | " + paramErrorMessage.errorMsg)
      {
        localunq.b = paramErrorMessage;
        localunq.jdField_a_of_type_Int = (paramInt + 1000);
        if ((!paramunj.a.containsKey("handleCallback")) || (localunq.jdField_a_of_type_Boolean)) {
          break;
        }
        localunq.jdField_a_of_type_Boolean = true;
        if (!this.a.a(paramString)) {
          break label169;
        }
        if (this.a.jdField_a_of_type_Uns == null) {
          break;
        }
        this.a.jdField_a_of_type_Uns.a(paramString, paramunj.d, paramInt);
        return;
      }
    } while (this.a.jdField_a_of_type_Uns == null);
    label136:
    this.a.jdField_a_of_type_Uns.a(paramString, paramunj.d, localunq.a(), paramInt);
  }
  
  public void b(String paramString, int paramInt1, File paramFile, int paramInt2, unj paramunj)
  {
    super.b(paramString, paramInt1, paramFile, paramInt2, paramunj);
    a(paramString, paramInt1, new ErrorMessage(), paramunj);
  }
  
  public void b(String paramString, int paramInt, unj paramunj)
  {
    super.b(paramString, paramInt, paramunj);
    if ((this.a.jdField_a_of_type_Uns != null) && ((paramInt == 0) || (paramInt == 1))) {
      this.a.jdField_a_of_type_Uns.b(paramString, paramunj.d, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     unr
 * JD-Core Version:    0.7.0.1
 */