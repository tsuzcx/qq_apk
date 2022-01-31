import android.annotation.TargetApi;
import android.text.TextUtils;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.mobileqq.app.QQAppInterface;

@TargetApi(14)
public class upw
  extends upy
{
  public String a;
  public upc a;
  public String b;
  
  public upw(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_Upc = new upc();
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
  }
  
  private void c()
  {
    bayk localbayk = new bayk();
    localbayk.jdField_a_of_type_Awkh = new upx(this);
    localbayk.i = this.jdField_b_of_type_JavaLangString;
    localbayk.jdField_a_of_type_Boolean = true;
    localbayk.jdField_b_of_type_Int = 196609;
    QQStoryContext.a();
    localbayk.jdField_b_of_type_JavaLangString = QQStoryContext.a().c();
    localbayk.c = "";
    localbayk.jdField_a_of_type_Long = (System.currentTimeMillis() + (Math.random() * 10000.0D));
    QQStoryContext.a();
    QQStoryContext.a().a().a(localbayk);
  }
  
  protected void a()
  {
    if ((TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) || (!xrg.c(this.jdField_b_of_type_JavaLangString)))
    {
      Object localObject = ((upl)uwa.a(14)).a(this.jdField_a_of_type_JavaLangString);
      if (((upo)localObject).a.isSuccess())
      {
        this.jdField_b_of_type_JavaLangString = ((upo)localObject).jdField_b_of_type_JavaLangString;
        if ((TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) || (!xrg.c(this.jdField_b_of_type_JavaLangString)))
        {
          wxe.d("Q.qqstory.publish.upload:StoryVideoFileObject  ", "end composite success but file not exist:%s", new Object[] { this.jdField_b_of_type_JavaLangString });
          localObject = new ErrorMessage(940006, String.format("end composite success but file not exist:%s", new Object[] { this.jdField_b_of_type_JavaLangString }));
          ((ErrorMessage)localObject).extraMsg = "composite";
          super.notifyResult(localObject);
        }
      }
      else
      {
        ((upo)localObject).a.extraMsg = "composite";
        super.notifyResult(((upo)localObject).a);
        return;
      }
    }
    uoy.a().b(this.jdField_a_of_type_JavaLangString);
    c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     upw
 * JD-Core Version:    0.7.0.1
 */