import android.text.TextUtils;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import java.util.Map;

public class vep
  extends vfy
{
  private URLDrawable jdField_a_of_type_ComTencentImageURLDrawable;
  private String jdField_a_of_type_JavaLangString;
  
  public vep()
  {
    a(false, true);
  }
  
  public vep(String paramString)
  {
    this();
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a()
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    this.jdField_a_of_type_ComTencentImageURLDrawable = URLDrawable.getDrawable(this.jdField_a_of_type_JavaLangString, localURLDrawableOptions);
    this.jdField_a_of_type_ComTencentImageURLDrawable.setURLDrawableListener(new veq(this));
    if ((this.jdField_a_of_type_ComTencentImageURLDrawable.getStatus() == 1) && (this.jdField_a_of_type_ComTencentImageURLDrawable.getCurrDrawable() != null))
    {
      a("UrlDrawableDownloadJob_dra", this.jdField_a_of_type_ComTencentImageURLDrawable.getCurrDrawable());
      b(true);
      return;
    }
    this.jdField_a_of_type_ComTencentImageURLDrawable.startDownload();
  }
  
  protected void a(Map<String, Object> paramMap)
  {
    if ((paramMap != null) && (!paramMap.isEmpty()) && (paramMap.containsKey("UrlDrawableDownloadJob_iiu"))) {
      this.jdField_a_of_type_JavaLangString = ((String)vgp.a(this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap, "UrlDrawableDownloadJob_iiu", this.jdField_a_of_type_JavaLangString));
    }
  }
  
  public boolean a()
  {
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      return false;
    }
    return super.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vep
 * JD-Core Version:    0.7.0.1
 */