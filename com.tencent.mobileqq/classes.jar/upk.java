import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import java.io.File;
import java.util.Map;

class upk
  extends sie
{
  public upk(uph paramuph)
  {
    super("Q.qqstory.download.preload.FeedVideoPreloader");
  }
  
  public void a(String paramString, int paramInt1, ErrorMessage paramErrorMessage, int paramInt2, shp paramshp)
  {
    super.a(paramString, paramInt1, paramErrorMessage, paramInt2, paramshp);
    a(paramString, paramInt1, paramErrorMessage, paramshp);
  }
  
  protected void a(String paramString, int paramInt, ErrorMessage paramErrorMessage, shp paramshp)
  {
    upj localupj = this.a.jdField_a_of_type_Upj;
    if (localupj == null) {}
    label14:
    label168:
    do
    {
      break label14;
      do
      {
        return;
      } while (!TextUtils.equals(paramString, localupj.jdField_a_of_type_JavaLangString));
      if (paramErrorMessage.isFail()) {
        if (!TextUtils.isEmpty(localupj.b)) {
          break label135;
        }
      }
      for (paramErrorMessage = paramErrorMessage.errorMsg;; paramErrorMessage = paramErrorMessage.errorMsg + " | " + paramErrorMessage.errorMsg)
      {
        localupj.b = paramErrorMessage;
        localupj.jdField_a_of_type_Int = (paramInt + 1000);
        if ((!paramshp.a.containsKey("handleCallback")) || (localupj.jdField_a_of_type_Boolean)) {
          break;
        }
        localupj.jdField_a_of_type_Boolean = true;
        if (!this.a.a(paramString)) {
          break label168;
        }
        if (this.a.jdField_a_of_type_Upl == null) {
          break;
        }
        this.a.jdField_a_of_type_Upl.a(paramString, paramshp.d);
        return;
      }
    } while (this.a.jdField_a_of_type_Upl == null);
    label135:
    this.a.jdField_a_of_type_Upl.a(paramString, paramshp.d, localupj.a());
  }
  
  public void b(String paramString, int paramInt1, File paramFile, int paramInt2, shp paramshp)
  {
    super.b(paramString, paramInt1, paramFile, paramInt2, paramshp);
    a(paramString, paramInt1, new ErrorMessage(), paramshp);
  }
  
  public void b(String paramString, int paramInt, shp paramshp)
  {
    super.b(paramString, paramInt, paramshp);
    if ((this.a.jdField_a_of_type_Upl != null) && ((paramInt == 0) || (paramInt == 1))) {
      this.a.jdField_a_of_type_Upl.b(paramString, paramshp.d);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     upk
 * JD-Core Version:    0.7.0.1
 */