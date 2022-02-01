import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import java.io.File;
import java.util.Map;

class yop
  extends whk
{
  public yop(yom paramyom)
  {
    super("Q.qqstory.download.preload.FeedVideoPreloader");
  }
  
  public void a(String paramString, int paramInt1, ErrorMessage paramErrorMessage, int paramInt2, wgv paramwgv)
  {
    super.a(paramString, paramInt1, paramErrorMessage, paramInt2, paramwgv);
    a(paramString, paramInt1, paramErrorMessage, paramwgv);
  }
  
  protected void a(String paramString, int paramInt, ErrorMessage paramErrorMessage, wgv paramwgv)
  {
    yoo localyoo = this.a.jdField_a_of_type_Yoo;
    if (localyoo == null) {}
    label14:
    label168:
    do
    {
      break label14;
      do
      {
        return;
      } while (!TextUtils.equals(paramString, localyoo.jdField_a_of_type_JavaLangString));
      if (paramErrorMessage.isFail()) {
        if (!TextUtils.isEmpty(localyoo.b)) {
          break label135;
        }
      }
      for (paramErrorMessage = paramErrorMessage.errorMsg;; paramErrorMessage = paramErrorMessage.errorMsg + " | " + paramErrorMessage.errorMsg)
      {
        localyoo.b = paramErrorMessage;
        localyoo.jdField_a_of_type_Int = (paramInt + 1000);
        if ((!paramwgv.a.containsKey("handleCallback")) || (localyoo.jdField_a_of_type_Boolean)) {
          break;
        }
        localyoo.jdField_a_of_type_Boolean = true;
        if (!this.a.a(paramString)) {
          break label168;
        }
        if (this.a.jdField_a_of_type_Yoq == null) {
          break;
        }
        this.a.jdField_a_of_type_Yoq.a(paramString, paramwgv.d);
        return;
      }
    } while (this.a.jdField_a_of_type_Yoq == null);
    label135:
    this.a.jdField_a_of_type_Yoq.a(paramString, paramwgv.d, localyoo.a());
  }
  
  public void b(String paramString, int paramInt1, File paramFile, int paramInt2, wgv paramwgv)
  {
    super.b(paramString, paramInt1, paramFile, paramInt2, paramwgv);
    a(paramString, paramInt1, new ErrorMessage(), paramwgv);
  }
  
  public void b(String paramString, int paramInt, wgv paramwgv)
  {
    super.b(paramString, paramInt, paramwgv);
    if ((this.a.jdField_a_of_type_Yoq != null) && ((paramInt == 0) || (paramInt == 1))) {
      this.a.jdField_a_of_type_Yoq.b(paramString, paramwgv.d);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yop
 * JD-Core Version:    0.7.0.1
 */