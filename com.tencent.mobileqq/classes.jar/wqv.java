import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import java.io.File;
import java.util.Map;

class wqv
  extends ujp
{
  public wqv(wqs paramwqs)
  {
    super("Q.qqstory.download.preload.FeedVideoPreloader");
  }
  
  public void a(String paramString, int paramInt1, ErrorMessage paramErrorMessage, int paramInt2, uja paramuja)
  {
    super.a(paramString, paramInt1, paramErrorMessage, paramInt2, paramuja);
    a(paramString, paramInt1, paramErrorMessage, paramuja);
  }
  
  protected void a(String paramString, int paramInt, ErrorMessage paramErrorMessage, uja paramuja)
  {
    wqu localwqu = this.a.jdField_a_of_type_Wqu;
    if (localwqu == null) {}
    label14:
    label168:
    do
    {
      break label14;
      do
      {
        return;
      } while (!TextUtils.equals(paramString, localwqu.jdField_a_of_type_JavaLangString));
      if (paramErrorMessage.isFail()) {
        if (!TextUtils.isEmpty(localwqu.b)) {
          break label135;
        }
      }
      for (paramErrorMessage = paramErrorMessage.errorMsg;; paramErrorMessage = paramErrorMessage.errorMsg + " | " + paramErrorMessage.errorMsg)
      {
        localwqu.b = paramErrorMessage;
        localwqu.jdField_a_of_type_Int = (paramInt + 1000);
        if ((!paramuja.a.containsKey("handleCallback")) || (localwqu.jdField_a_of_type_Boolean)) {
          break;
        }
        localwqu.jdField_a_of_type_Boolean = true;
        if (!this.a.a(paramString)) {
          break label168;
        }
        if (this.a.jdField_a_of_type_Wqw == null) {
          break;
        }
        this.a.jdField_a_of_type_Wqw.a(paramString, paramuja.d);
        return;
      }
    } while (this.a.jdField_a_of_type_Wqw == null);
    label135:
    this.a.jdField_a_of_type_Wqw.a(paramString, paramuja.d, localwqu.a());
  }
  
  public void b(String paramString, int paramInt1, File paramFile, int paramInt2, uja paramuja)
  {
    super.b(paramString, paramInt1, paramFile, paramInt2, paramuja);
    a(paramString, paramInt1, new ErrorMessage(), paramuja);
  }
  
  public void b(String paramString, int paramInt, uja paramuja)
  {
    super.b(paramString, paramInt, paramuja);
    if ((this.a.jdField_a_of_type_Wqw != null) && ((paramInt == 0) || (paramInt == 1))) {
      this.a.jdField_a_of_type_Wqw.b(paramString, paramuja.d);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wqv
 * JD-Core Version:    0.7.0.1
 */