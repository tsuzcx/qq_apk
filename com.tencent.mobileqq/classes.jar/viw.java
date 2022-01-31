import android.text.TextUtils;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.Map;

public class viw
  extends vkh
{
  private String a;
  
  public viw()
  {
    a(false, true);
  }
  
  public void a()
  {
    QQStoryContext.a();
    QQAppInterface localQQAppInterface = QQStoryContext.a();
    bayf localbayf = localQQAppInterface.a();
    bayk localbayk = new bayk();
    localbayk.jdField_a_of_type_Awkh = new vix(this);
    localbayk.i = this.a;
    localbayk.jdField_a_of_type_Boolean = true;
    localbayk.jdField_b_of_type_Int = 196610;
    localbayk.jdField_b_of_type_JavaLangString = localQQAppInterface.c();
    localbayk.c = "";
    localbayk.jdField_a_of_type_Long = (System.currentTimeMillis() + (Math.random() * 10000.0D));
    localbayf.a(localbayk);
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
 * Qualified Name:     viw
 * JD-Core Version:    0.7.0.1
 */