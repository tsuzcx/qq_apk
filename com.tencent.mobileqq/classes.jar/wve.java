import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import java.io.File;
import java.util.Map;

class wve
  extends uny
{
  public wve(wvb paramwvb)
  {
    super("Q.qqstory.download.preload.FeedVideoPreloader");
  }
  
  public void a(String paramString, int paramInt1, ErrorMessage paramErrorMessage, int paramInt2, unj paramunj)
  {
    super.a(paramString, paramInt1, paramErrorMessage, paramInt2, paramunj);
    a(paramString, paramInt1, paramErrorMessage, paramunj);
  }
  
  protected void a(String paramString, int paramInt, ErrorMessage paramErrorMessage, unj paramunj)
  {
    wvd localwvd = this.a.jdField_a_of_type_Wvd;
    if (localwvd == null) {}
    label14:
    label168:
    do
    {
      break label14;
      do
      {
        return;
      } while (!TextUtils.equals(paramString, localwvd.jdField_a_of_type_JavaLangString));
      if (paramErrorMessage.isFail()) {
        if (!TextUtils.isEmpty(localwvd.b)) {
          break label135;
        }
      }
      for (paramErrorMessage = paramErrorMessage.errorMsg;; paramErrorMessage = paramErrorMessage.errorMsg + " | " + paramErrorMessage.errorMsg)
      {
        localwvd.b = paramErrorMessage;
        localwvd.jdField_a_of_type_Int = (paramInt + 1000);
        if ((!paramunj.a.containsKey("handleCallback")) || (localwvd.jdField_a_of_type_Boolean)) {
          break;
        }
        localwvd.jdField_a_of_type_Boolean = true;
        if (!this.a.a(paramString)) {
          break label168;
        }
        if (this.a.jdField_a_of_type_Wvf == null) {
          break;
        }
        this.a.jdField_a_of_type_Wvf.a(paramString, paramunj.d);
        return;
      }
    } while (this.a.jdField_a_of_type_Wvf == null);
    label135:
    this.a.jdField_a_of_type_Wvf.a(paramString, paramunj.d, localwvd.a());
  }
  
  public void b(String paramString, int paramInt1, File paramFile, int paramInt2, unj paramunj)
  {
    super.b(paramString, paramInt1, paramFile, paramInt2, paramunj);
    a(paramString, paramInt1, new ErrorMessage(), paramunj);
  }
  
  public void b(String paramString, int paramInt, unj paramunj)
  {
    super.b(paramString, paramInt, paramunj);
    if ((this.a.jdField_a_of_type_Wvf != null) && ((paramInt == 0) || (paramInt == 1))) {
      this.a.jdField_a_of_type_Wvf.b(paramString, paramunj.d);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wve
 * JD-Core Version:    0.7.0.1
 */