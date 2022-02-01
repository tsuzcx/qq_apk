import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import java.io.File;
import java.util.Map;

class ysk
  extends wlf
{
  public ysk(ysh paramysh)
  {
    super("Q.qqstory.download.preload.FeedVideoPreloader");
  }
  
  public void a(String paramString, int paramInt1, ErrorMessage paramErrorMessage, int paramInt2, wkq paramwkq)
  {
    super.a(paramString, paramInt1, paramErrorMessage, paramInt2, paramwkq);
    a(paramString, paramInt1, paramErrorMessage, paramwkq);
  }
  
  protected void a(String paramString, int paramInt, ErrorMessage paramErrorMessage, wkq paramwkq)
  {
    ysj localysj = this.a.jdField_a_of_type_Ysj;
    if (localysj == null) {}
    label14:
    label168:
    do
    {
      break label14;
      do
      {
        return;
      } while (!TextUtils.equals(paramString, localysj.jdField_a_of_type_JavaLangString));
      if (paramErrorMessage.isFail()) {
        if (!TextUtils.isEmpty(localysj.b)) {
          break label135;
        }
      }
      for (paramErrorMessage = paramErrorMessage.errorMsg;; paramErrorMessage = paramErrorMessage.errorMsg + " | " + paramErrorMessage.errorMsg)
      {
        localysj.b = paramErrorMessage;
        localysj.jdField_a_of_type_Int = (paramInt + 1000);
        if ((!paramwkq.a.containsKey("handleCallback")) || (localysj.jdField_a_of_type_Boolean)) {
          break;
        }
        localysj.jdField_a_of_type_Boolean = true;
        if (!this.a.a(paramString)) {
          break label168;
        }
        if (this.a.jdField_a_of_type_Ysl == null) {
          break;
        }
        this.a.jdField_a_of_type_Ysl.a(paramString, paramwkq.d);
        return;
      }
    } while (this.a.jdField_a_of_type_Ysl == null);
    label135:
    this.a.jdField_a_of_type_Ysl.a(paramString, paramwkq.d, localysj.a());
  }
  
  public void b(String paramString, int paramInt1, File paramFile, int paramInt2, wkq paramwkq)
  {
    super.b(paramString, paramInt1, paramFile, paramInt2, paramwkq);
    a(paramString, paramInt1, new ErrorMessage(), paramwkq);
  }
  
  public void b(String paramString, int paramInt, wkq paramwkq)
  {
    super.b(paramString, paramInt, paramwkq);
    if ((this.a.jdField_a_of_type_Ysl != null) && ((paramInt == 0) || (paramInt == 1))) {
      this.a.jdField_a_of_type_Ysl.b(paramString, paramwkq.d);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ysk
 * JD-Core Version:    0.7.0.1
 */