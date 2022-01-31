import android.annotation.TargetApi;
import android.text.TextUtils;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.mobileqq.app.QQAppInterface;

@TargetApi(14)
public class uln
  extends ulp
{
  public String a;
  public ukt a;
  public String b;
  
  public uln(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_Ukt = new ukt();
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
  }
  
  private void c()
  {
    baub localbaub = new baub();
    localbaub.jdField_a_of_type_Awfy = new ulo(this);
    localbaub.i = this.jdField_b_of_type_JavaLangString;
    localbaub.jdField_a_of_type_Boolean = true;
    localbaub.jdField_b_of_type_Int = 196609;
    QQStoryContext.a();
    localbaub.jdField_b_of_type_JavaLangString = QQStoryContext.a().c();
    localbaub.c = "";
    localbaub.jdField_a_of_type_Long = (System.currentTimeMillis() + (Math.random() * 10000.0D));
    QQStoryContext.a();
    QQStoryContext.a().a().a(localbaub);
  }
  
  protected void a()
  {
    if ((TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) || (!xmx.c(this.jdField_b_of_type_JavaLangString)))
    {
      Object localObject = ((ulc)urr.a(14)).a(this.jdField_a_of_type_JavaLangString);
      if (((ulf)localObject).a.isSuccess())
      {
        this.jdField_b_of_type_JavaLangString = ((ulf)localObject).jdField_b_of_type_JavaLangString;
        if ((TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) || (!xmx.c(this.jdField_b_of_type_JavaLangString)))
        {
          wsv.d("Q.qqstory.publish.upload:StoryVideoFileObject  ", "end composite success but file not exist:%s", new Object[] { this.jdField_b_of_type_JavaLangString });
          localObject = new ErrorMessage(940006, String.format("end composite success but file not exist:%s", new Object[] { this.jdField_b_of_type_JavaLangString }));
          ((ErrorMessage)localObject).extraMsg = "composite";
          super.notifyResult(localObject);
        }
      }
      else
      {
        ((ulf)localObject).a.extraMsg = "composite";
        super.notifyResult(((ulf)localObject).a);
        return;
      }
    }
    ukp.a().b(this.jdField_a_of_type_JavaLangString);
    c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     uln
 * JD-Core Version:    0.7.0.1
 */