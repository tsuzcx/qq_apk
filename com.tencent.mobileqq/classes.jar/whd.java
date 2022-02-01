import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import java.io.File;
import java.util.Map;

class whd
  extends whk
{
  public whd(wha paramwha)
  {
    super("Q.qqstory.download.preload.PlayingListPreloader");
  }
  
  public void a(String paramString, int paramInt1, ErrorMessage paramErrorMessage, int paramInt2, wgv paramwgv)
  {
    super.a(paramString, paramInt1, paramErrorMessage, paramInt2, paramwgv);
    a(paramString, paramInt1, paramErrorMessage, paramwgv);
  }
  
  protected void a(String paramString, int paramInt, ErrorMessage paramErrorMessage, wgv paramwgv)
  {
    whc localwhc = this.a.jdField_a_of_type_Whc;
    if (localwhc == null) {}
    label14:
    label169:
    do
    {
      break label14;
      do
      {
        return;
      } while (!TextUtils.equals(paramString, localwhc.jdField_a_of_type_JavaLangString));
      if (paramErrorMessage.isFail()) {
        if (!TextUtils.isEmpty(localwhc.b)) {
          break label136;
        }
      }
      for (paramErrorMessage = paramErrorMessage.errorMsg;; paramErrorMessage = paramErrorMessage.errorMsg + " | " + paramErrorMessage.errorMsg)
      {
        localwhc.b = paramErrorMessage;
        localwhc.jdField_a_of_type_Int = (paramInt + 1000);
        if ((!paramwgv.a.containsKey("handleCallback")) || (localwhc.jdField_a_of_type_Boolean)) {
          break;
        }
        localwhc.jdField_a_of_type_Boolean = true;
        if (!this.a.a(paramString)) {
          break label169;
        }
        if (this.a.jdField_a_of_type_Whe == null) {
          break;
        }
        this.a.jdField_a_of_type_Whe.a(paramString, paramwgv.d, paramInt);
        return;
      }
    } while (this.a.jdField_a_of_type_Whe == null);
    label136:
    this.a.jdField_a_of_type_Whe.a(paramString, paramwgv.d, localwhc.a(), paramInt);
  }
  
  public void b(String paramString, int paramInt1, File paramFile, int paramInt2, wgv paramwgv)
  {
    super.b(paramString, paramInt1, paramFile, paramInt2, paramwgv);
    a(paramString, paramInt1, new ErrorMessage(), paramwgv);
  }
  
  public void b(String paramString, int paramInt, wgv paramwgv)
  {
    super.b(paramString, paramInt, paramwgv);
    if ((this.a.jdField_a_of_type_Whe != null) && ((paramInt == 0) || (paramInt == 1))) {
      this.a.jdField_a_of_type_Whe.b(paramString, paramwgv.d, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     whd
 * JD-Core Version:    0.7.0.1
 */