import android.text.TextUtils;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.Map;

public class tpv
  extends trg
{
  private String a;
  
  public tpv()
  {
    a(false, true);
  }
  
  public void a()
  {
    QQStoryContext.a();
    QQAppInterface localQQAppInterface = QQStoryContext.a();
    ayvx localayvx = localQQAppInterface.a();
    aywc localaywc = new aywc();
    localaywc.jdField_a_of_type_Auoq = new tpw(this);
    localaywc.i = this.a;
    localaywc.jdField_a_of_type_Boolean = true;
    localaywc.jdField_b_of_type_Int = 196610;
    localaywc.jdField_b_of_type_JavaLangString = localQQAppInterface.c();
    localaywc.c = "";
    localaywc.jdField_a_of_type_Long = (System.currentTimeMillis() + (Math.random() * 10000.0D));
    localayvx.a(localaywc);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tpv
 * JD-Core Version:    0.7.0.1
 */