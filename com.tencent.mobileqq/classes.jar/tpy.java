import android.text.TextUtils;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.Map;

public class tpy
  extends trj
{
  private String a;
  
  public tpy()
  {
    a(false, true);
  }
  
  public void a()
  {
    QQStoryContext.a();
    QQAppInterface localQQAppInterface = QQStoryContext.a();
    ayvv localayvv = localQQAppInterface.a();
    aywa localaywa = new aywa();
    localaywa.jdField_a_of_type_Auoo = new tpz(this);
    localaywa.i = this.a;
    localaywa.jdField_a_of_type_Boolean = true;
    localaywa.jdField_b_of_type_Int = 196610;
    localaywa.jdField_b_of_type_JavaLangString = localQQAppInterface.c();
    localaywa.c = "";
    localaywa.jdField_a_of_type_Long = (System.currentTimeMillis() + (Math.random() * 10000.0D));
    localayvv.a(localaywa);
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
 * Qualified Name:     tpy
 * JD-Core Version:    0.7.0.1
 */