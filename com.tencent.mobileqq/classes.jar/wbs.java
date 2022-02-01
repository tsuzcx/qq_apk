import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import java.io.File;
import java.util.Map;

class wbs
  extends wbz
{
  public wbs(wbp paramwbp)
  {
    super("Q.qqstory.download.preload.PlayingListPreloader");
  }
  
  public void a(String paramString, int paramInt1, ErrorMessage paramErrorMessage, int paramInt2, wbk paramwbk)
  {
    super.a(paramString, paramInt1, paramErrorMessage, paramInt2, paramwbk);
    a(paramString, paramInt1, paramErrorMessage, paramwbk);
  }
  
  protected void a(String paramString, int paramInt, ErrorMessage paramErrorMessage, wbk paramwbk)
  {
    wbr localwbr = this.a.jdField_a_of_type_Wbr;
    if (localwbr == null) {}
    label14:
    label169:
    do
    {
      break label14;
      do
      {
        return;
      } while (!TextUtils.equals(paramString, localwbr.jdField_a_of_type_JavaLangString));
      if (paramErrorMessage.isFail()) {
        if (!TextUtils.isEmpty(localwbr.b)) {
          break label136;
        }
      }
      for (paramErrorMessage = paramErrorMessage.errorMsg;; paramErrorMessage = paramErrorMessage.errorMsg + " | " + paramErrorMessage.errorMsg)
      {
        localwbr.b = paramErrorMessage;
        localwbr.jdField_a_of_type_Int = (paramInt + 1000);
        if ((!paramwbk.a.containsKey("handleCallback")) || (localwbr.jdField_a_of_type_Boolean)) {
          break;
        }
        localwbr.jdField_a_of_type_Boolean = true;
        if (!this.a.a(paramString)) {
          break label169;
        }
        if (this.a.jdField_a_of_type_Wbt == null) {
          break;
        }
        this.a.jdField_a_of_type_Wbt.a(paramString, paramwbk.d, paramInt);
        return;
      }
    } while (this.a.jdField_a_of_type_Wbt == null);
    label136:
    this.a.jdField_a_of_type_Wbt.a(paramString, paramwbk.d, localwbr.a(), paramInt);
  }
  
  public void b(String paramString, int paramInt1, File paramFile, int paramInt2, wbk paramwbk)
  {
    super.b(paramString, paramInt1, paramFile, paramInt2, paramwbk);
    a(paramString, paramInt1, new ErrorMessage(), paramwbk);
  }
  
  public void b(String paramString, int paramInt, wbk paramwbk)
  {
    super.b(paramString, paramInt, paramwbk);
    if ((this.a.jdField_a_of_type_Wbt != null) && ((paramInt == 0) || (paramInt == 1))) {
      this.a.jdField_a_of_type_Wbt.b(paramString, paramwbk.d, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wbs
 * JD-Core Version:    0.7.0.1
 */