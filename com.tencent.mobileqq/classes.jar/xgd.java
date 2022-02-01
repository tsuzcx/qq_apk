import android.text.TextUtils;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.Map;

public class xgd
  extends xho
{
  private String a;
  
  public xgd()
  {
    a(false, true);
  }
  
  public void a()
  {
    QQStoryContext.a();
    QQAppInterface localQQAppInterface = QQStoryContext.a();
    beyb localbeyb = localQQAppInterface.a();
    beyg localbeyg = new beyg();
    localbeyg.jdField_a_of_type_Azrg = new xge(this);
    localbeyg.i = this.a;
    localbeyg.jdField_a_of_type_Boolean = true;
    localbeyg.jdField_b_of_type_Int = 196610;
    localbeyg.jdField_b_of_type_JavaLangString = localQQAppInterface.c();
    localbeyg.c = "";
    localbeyg.jdField_a_of_type_Long = (System.currentTimeMillis() + (Math.random() * 10000.0D));
    localbeyb.a(localbeyg);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xgd
 * JD-Core Version:    0.7.0.1
 */