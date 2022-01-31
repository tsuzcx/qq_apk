import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import java.io.File;
import java.util.Map;

class vcg
  extends sva
{
  public vcg(vcd paramvcd)
  {
    super("Q.qqstory.download.preload.FeedVideoPreloader");
  }
  
  public void a(String paramString, int paramInt1, ErrorMessage paramErrorMessage, int paramInt2, sul paramsul)
  {
    super.a(paramString, paramInt1, paramErrorMessage, paramInt2, paramsul);
    a(paramString, paramInt1, paramErrorMessage, paramsul);
  }
  
  protected void a(String paramString, int paramInt, ErrorMessage paramErrorMessage, sul paramsul)
  {
    vcf localvcf = this.a.jdField_a_of_type_Vcf;
    if (localvcf == null) {}
    label14:
    label168:
    do
    {
      break label14;
      do
      {
        return;
      } while (!TextUtils.equals(paramString, localvcf.jdField_a_of_type_JavaLangString));
      if (paramErrorMessage.isFail()) {
        if (!TextUtils.isEmpty(localvcf.b)) {
          break label135;
        }
      }
      for (paramErrorMessage = paramErrorMessage.errorMsg;; paramErrorMessage = paramErrorMessage.errorMsg + " | " + paramErrorMessage.errorMsg)
      {
        localvcf.b = paramErrorMessage;
        localvcf.jdField_a_of_type_Int = (paramInt + 1000);
        if ((!paramsul.a.containsKey("handleCallback")) || (localvcf.jdField_a_of_type_Boolean)) {
          break;
        }
        localvcf.jdField_a_of_type_Boolean = true;
        if (!this.a.a(paramString)) {
          break label168;
        }
        if (this.a.jdField_a_of_type_Vch == null) {
          break;
        }
        this.a.jdField_a_of_type_Vch.a(paramString, paramsul.d);
        return;
      }
    } while (this.a.jdField_a_of_type_Vch == null);
    label135:
    this.a.jdField_a_of_type_Vch.a(paramString, paramsul.d, localvcf.a());
  }
  
  public void b(String paramString, int paramInt1, File paramFile, int paramInt2, sul paramsul)
  {
    super.b(paramString, paramInt1, paramFile, paramInt2, paramsul);
    a(paramString, paramInt1, new ErrorMessage(), paramsul);
  }
  
  public void b(String paramString, int paramInt, sul paramsul)
  {
    super.b(paramString, paramInt, paramsul);
    if ((this.a.jdField_a_of_type_Vch != null) && ((paramInt == 0) || (paramInt == 1))) {
      this.a.jdField_a_of_type_Vch.b(paramString, paramsul.d);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vcg
 * JD-Core Version:    0.7.0.1
 */