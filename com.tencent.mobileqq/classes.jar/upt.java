import android.annotation.TargetApi;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.utils.pngquant.PngQuantUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import java.io.File;
import java.io.IOException;

@TargetApi(14)
public class upt
  extends upy
{
  private final bayf jdField_a_of_type_Bayf;
  public String a;
  private final boolean jdField_a_of_type_Boolean;
  public String b;
  
  public upt(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    QQStoryContext.a();
    this.jdField_a_of_type_Bayf = QQStoryContext.a().a();
  }
  
  private void c()
  {
    bayk localbayk = new bayk();
    localbayk.jdField_a_of_type_Awkh = new upu(this);
    localbayk.i = this.jdField_a_of_type_JavaLangString;
    localbayk.jdField_a_of_type_Boolean = true;
    localbayk.jdField_b_of_type_Int = 196610;
    QQStoryContext.a();
    localbayk.jdField_b_of_type_JavaLangString = QQStoryContext.a().c();
    localbayk.c = "";
    localbayk.jdField_a_of_type_Long = (System.currentTimeMillis() + (Math.random() * 10000.0D));
    this.jdField_a_of_type_Bayf.a(localbayk);
  }
  
  protected void a()
  {
    File localFile2 = new File(this.jdField_a_of_type_JavaLangString);
    if ((!localFile2.exists()) || (localFile2.length() == 0L)) {
      wxe.e("Q.qqstory.publish.upload:ImageFileObject", "file not exit %s", new Object[] { this.jdField_a_of_type_JavaLangString });
    }
    Object localObject;
    if ((this.jdField_a_of_type_Boolean) && (PngQuantUtils.a())) {
      localObject = null;
    }
    try
    {
      File localFile1 = File.createTempFile("temp", "png", localFile2.getParentFile());
      localObject = localFile1;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        wxe.b("Q.qqstory.publish.upload:ImageFileObject", "create file", localIOException);
      }
    }
    if (PngQuantUtils.a(localFile2, localObject))
    {
      localFile2.delete();
      localObject.renameTo(localFile2);
    }
    c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     upt
 * JD-Core Version:    0.7.0.1
 */