import android.annotation.TargetApi;
import android.text.TextUtils;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.mobileqq.app.QQAppInterface;

@TargetApi(14)
public class wji
  extends wjk
{
  public String a;
  public wio a;
  public String b;
  
  public wji(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_Wio = new wio();
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
  }
  
  private void c()
  {
    bdzn localbdzn = new bdzn();
    localbdzn.jdField_a_of_type_Ayyt = new wjj(this);
    localbdzn.i = this.jdField_b_of_type_JavaLangString;
    localbdzn.jdField_a_of_type_Boolean = true;
    localbdzn.jdField_b_of_type_Int = 196609;
    QQStoryContext.a();
    localbdzn.jdField_b_of_type_JavaLangString = QQStoryContext.a().c();
    localbdzn.c = "";
    localbdzn.jdField_a_of_type_Long = (System.currentTimeMillis() + (Math.random() * 10000.0D));
    QQStoryContext.a();
    QQStoryContext.a().a().a(localbdzn);
  }
  
  protected void a()
  {
    if ((TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) || (!zkr.c(this.jdField_b_of_type_JavaLangString)))
    {
      Object localObject = ((wix)wpm.a(14)).a(this.jdField_a_of_type_JavaLangString);
      if (((wja)localObject).a.isSuccess())
      {
        this.jdField_b_of_type_JavaLangString = ((wja)localObject).jdField_b_of_type_JavaLangString;
        if ((TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) || (!zkr.c(this.jdField_b_of_type_JavaLangString)))
        {
          yqp.d("Q.qqstory.publish.upload:StoryVideoFileObject  ", "end composite success but file not exist:%s", new Object[] { this.jdField_b_of_type_JavaLangString });
          localObject = new ErrorMessage(940006, String.format("end composite success but file not exist:%s", new Object[] { this.jdField_b_of_type_JavaLangString }));
          ((ErrorMessage)localObject).extraMsg = "composite";
          super.notifyResult(localObject);
        }
      }
      else
      {
        ((wja)localObject).a.extraMsg = "composite";
        super.notifyResult(((wja)localObject).a);
        return;
      }
    }
    wik.a().b(this.jdField_a_of_type_JavaLangString);
    c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wji
 * JD-Core Version:    0.7.0.1
 */