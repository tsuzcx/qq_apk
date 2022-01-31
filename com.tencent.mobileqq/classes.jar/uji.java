import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import java.io.File;
import java.util.Map;

class uji
  extends ujp
{
  public uji(ujf paramujf)
  {
    super("Q.qqstory.download.preload.PlayingListPreloader");
  }
  
  public void a(String paramString, int paramInt1, ErrorMessage paramErrorMessage, int paramInt2, uja paramuja)
  {
    super.a(paramString, paramInt1, paramErrorMessage, paramInt2, paramuja);
    a(paramString, paramInt1, paramErrorMessage, paramuja);
  }
  
  protected void a(String paramString, int paramInt, ErrorMessage paramErrorMessage, uja paramuja)
  {
    ujh localujh = this.a.jdField_a_of_type_Ujh;
    if (localujh == null) {}
    label14:
    label169:
    do
    {
      break label14;
      do
      {
        return;
      } while (!TextUtils.equals(paramString, localujh.jdField_a_of_type_JavaLangString));
      if (paramErrorMessage.isFail()) {
        if (!TextUtils.isEmpty(localujh.b)) {
          break label136;
        }
      }
      for (paramErrorMessage = paramErrorMessage.errorMsg;; paramErrorMessage = paramErrorMessage.errorMsg + " | " + paramErrorMessage.errorMsg)
      {
        localujh.b = paramErrorMessage;
        localujh.jdField_a_of_type_Int = (paramInt + 1000);
        if ((!paramuja.a.containsKey("handleCallback")) || (localujh.jdField_a_of_type_Boolean)) {
          break;
        }
        localujh.jdField_a_of_type_Boolean = true;
        if (!this.a.a(paramString)) {
          break label169;
        }
        if (this.a.jdField_a_of_type_Ujj == null) {
          break;
        }
        this.a.jdField_a_of_type_Ujj.a(paramString, paramuja.d, paramInt);
        return;
      }
    } while (this.a.jdField_a_of_type_Ujj == null);
    label136:
    this.a.jdField_a_of_type_Ujj.a(paramString, paramuja.d, localujh.a(), paramInt);
  }
  
  public void b(String paramString, int paramInt1, File paramFile, int paramInt2, uja paramuja)
  {
    super.b(paramString, paramInt1, paramFile, paramInt2, paramuja);
    a(paramString, paramInt1, new ErrorMessage(), paramuja);
  }
  
  public void b(String paramString, int paramInt, uja paramuja)
  {
    super.b(paramString, paramInt, paramuja);
    if ((this.a.jdField_a_of_type_Ujj != null) && ((paramInt == 0) || (paramInt == 1))) {
      this.a.jdField_a_of_type_Ujj.b(paramString, paramuja.d, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     uji
 * JD-Core Version:    0.7.0.1
 */