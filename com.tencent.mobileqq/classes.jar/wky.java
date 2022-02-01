import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import java.io.File;
import java.util.Map;

class wky
  extends wlf
{
  public wky(wkv paramwkv)
  {
    super("Q.qqstory.download.preload.PlayingListPreloader");
  }
  
  public void a(String paramString, int paramInt1, ErrorMessage paramErrorMessage, int paramInt2, wkq paramwkq)
  {
    super.a(paramString, paramInt1, paramErrorMessage, paramInt2, paramwkq);
    a(paramString, paramInt1, paramErrorMessage, paramwkq);
  }
  
  protected void a(String paramString, int paramInt, ErrorMessage paramErrorMessage, wkq paramwkq)
  {
    wkx localwkx = this.a.jdField_a_of_type_Wkx;
    if (localwkx == null) {}
    label14:
    label169:
    do
    {
      break label14;
      do
      {
        return;
      } while (!TextUtils.equals(paramString, localwkx.jdField_a_of_type_JavaLangString));
      if (paramErrorMessage.isFail()) {
        if (!TextUtils.isEmpty(localwkx.b)) {
          break label136;
        }
      }
      for (paramErrorMessage = paramErrorMessage.errorMsg;; paramErrorMessage = paramErrorMessage.errorMsg + " | " + paramErrorMessage.errorMsg)
      {
        localwkx.b = paramErrorMessage;
        localwkx.jdField_a_of_type_Int = (paramInt + 1000);
        if ((!paramwkq.a.containsKey("handleCallback")) || (localwkx.jdField_a_of_type_Boolean)) {
          break;
        }
        localwkx.jdField_a_of_type_Boolean = true;
        if (!this.a.a(paramString)) {
          break label169;
        }
        if (this.a.jdField_a_of_type_Wkz == null) {
          break;
        }
        this.a.jdField_a_of_type_Wkz.a(paramString, paramwkq.d, paramInt);
        return;
      }
    } while (this.a.jdField_a_of_type_Wkz == null);
    label136:
    this.a.jdField_a_of_type_Wkz.a(paramString, paramwkq.d, localwkx.a(), paramInt);
  }
  
  public void b(String paramString, int paramInt1, File paramFile, int paramInt2, wkq paramwkq)
  {
    super.b(paramString, paramInt1, paramFile, paramInt2, paramwkq);
    a(paramString, paramInt1, new ErrorMessage(), paramwkq);
  }
  
  public void b(String paramString, int paramInt, wkq paramwkq)
  {
    super.b(paramString, paramInt, paramwkq);
    if ((this.a.jdField_a_of_type_Wkz != null) && ((paramInt == 0) || (paramInt == 1))) {
      this.a.jdField_a_of_type_Wkz.b(paramString, paramwkq.d, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wky
 * JD-Core Version:    0.7.0.1
 */