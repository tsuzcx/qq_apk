import android.text.TextUtils;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.Map;

public class ven
  extends vfy
{
  private String a;
  
  public ven()
  {
    a(false, true);
  }
  
  public void a()
  {
    QQStoryContext.a();
    QQAppInterface localQQAppInterface = QQStoryContext.a();
    batw localbatw = localQQAppInterface.a();
    baub localbaub = new baub();
    localbaub.jdField_a_of_type_Awfy = new veo(this);
    localbaub.i = this.a;
    localbaub.jdField_a_of_type_Boolean = true;
    localbaub.jdField_b_of_type_Int = 196610;
    localbaub.jdField_b_of_type_JavaLangString = localQQAppInterface.c();
    localbaub.c = "";
    localbaub.jdField_a_of_type_Long = (System.currentTimeMillis() + (Math.random() * 10000.0D));
    localbatw.a(localbaub);
  }
  
  protected void a(Map<String, Object> paramMap)
  {
    if ((paramMap != null) && (!paramMap.isEmpty()) && (paramMap.containsKey("UploadImageJob_in_image_file_path"))) {
      this.a = ((String)a("UploadImageJob_in_image_file_path"));
    }
  }
  
  public boolean a()
  {
    return !TextUtils.isEmpty(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ven
 * JD-Core Version:    0.7.0.1
 */