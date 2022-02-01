import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import java.io.File;
import java.util.Map;

class yiq
  extends wbz
{
  public yiq(yin paramyin)
  {
    super("Q.qqstory.download.preload.FeedVideoPreloader");
  }
  
  public void a(String paramString, int paramInt1, ErrorMessage paramErrorMessage, int paramInt2, wbk paramwbk)
  {
    super.a(paramString, paramInt1, paramErrorMessage, paramInt2, paramwbk);
    a(paramString, paramInt1, paramErrorMessage, paramwbk);
  }
  
  protected void a(String paramString, int paramInt, ErrorMessage paramErrorMessage, wbk paramwbk)
  {
    yip localyip = this.a.jdField_a_of_type_Yip;
    if (localyip == null) {}
    label14:
    label168:
    do
    {
      break label14;
      do
      {
        return;
      } while (!TextUtils.equals(paramString, localyip.jdField_a_of_type_JavaLangString));
      if (paramErrorMessage.isFail()) {
        if (!TextUtils.isEmpty(localyip.b)) {
          break label135;
        }
      }
      for (paramErrorMessage = paramErrorMessage.errorMsg;; paramErrorMessage = paramErrorMessage.errorMsg + " | " + paramErrorMessage.errorMsg)
      {
        localyip.b = paramErrorMessage;
        localyip.jdField_a_of_type_Int = (paramInt + 1000);
        if ((!paramwbk.a.containsKey("handleCallback")) || (localyip.jdField_a_of_type_Boolean)) {
          break;
        }
        localyip.jdField_a_of_type_Boolean = true;
        if (!this.a.a(paramString)) {
          break label168;
        }
        if (this.a.jdField_a_of_type_Yir == null) {
          break;
        }
        this.a.jdField_a_of_type_Yir.a(paramString, paramwbk.d);
        return;
      }
    } while (this.a.jdField_a_of_type_Yir == null);
    label135:
    this.a.jdField_a_of_type_Yir.a(paramString, paramwbk.d, localyip.a());
  }
  
  public void b(String paramString, int paramInt1, File paramFile, int paramInt2, wbk paramwbk)
  {
    super.b(paramString, paramInt1, paramFile, paramInt2, paramwbk);
    a(paramString, paramInt1, new ErrorMessage(), paramwbk);
  }
  
  public void b(String paramString, int paramInt, wbk paramwbk)
  {
    super.b(paramString, paramInt, paramwbk);
    if ((this.a.jdField_a_of_type_Yir != null) && ((paramInt == 0) || (paramInt == 1))) {
      this.a.jdField_a_of_type_Yir.b(paramString, paramwbk.d);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yiq
 * JD-Core Version:    0.7.0.1
 */