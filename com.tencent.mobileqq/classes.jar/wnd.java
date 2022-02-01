import android.annotation.TargetApi;
import android.text.TextUtils;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.mobileqq.app.QQAppInterface;

@TargetApi(14)
public class wnd
  extends wnf
{
  public String a;
  public wmj a;
  public String b;
  
  public wnd(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_Wmj = new wmj();
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
  }
  
  private void c()
  {
    beyg localbeyg = new beyg();
    localbeyg.jdField_a_of_type_Azrg = new wne(this);
    localbeyg.i = this.jdField_b_of_type_JavaLangString;
    localbeyg.jdField_a_of_type_Boolean = true;
    localbeyg.jdField_b_of_type_Int = 196609;
    QQStoryContext.a();
    localbeyg.jdField_b_of_type_JavaLangString = QQStoryContext.a().c();
    localbeyg.c = "";
    localbeyg.jdField_a_of_type_Long = (System.currentTimeMillis() + (Math.random() * 10000.0D));
    QQStoryContext.a();
    QQStoryContext.a().a().a(localbeyg);
  }
  
  protected void a()
  {
    if ((TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) || (!zom.c(this.jdField_b_of_type_JavaLangString)))
    {
      Object localObject = ((wms)wth.a(14)).a(this.jdField_a_of_type_JavaLangString);
      if (((wmv)localObject).a.isSuccess())
      {
        this.jdField_b_of_type_JavaLangString = ((wmv)localObject).jdField_b_of_type_JavaLangString;
        if ((TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) || (!zom.c(this.jdField_b_of_type_JavaLangString)))
        {
          yuk.d("Q.qqstory.publish.upload:StoryVideoFileObject  ", "end composite success but file not exist:%s", new Object[] { this.jdField_b_of_type_JavaLangString });
          localObject = new ErrorMessage(940006, String.format("end composite success but file not exist:%s", new Object[] { this.jdField_b_of_type_JavaLangString }));
          ((ErrorMessage)localObject).extraMsg = "composite";
          super.notifyResult(localObject);
        }
      }
      else
      {
        ((wmv)localObject).a.extraMsg = "composite";
        super.notifyResult(((wmv)localObject).a);
        return;
      }
    }
    wmf.a().b(this.jdField_a_of_type_JavaLangString);
    c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wnd
 * JD-Core Version:    0.7.0.1
 */