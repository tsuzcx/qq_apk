import android.os.Handler;
import android.os.Message;
import java.io.File;

class vqw
  implements bbzz
{
  private String jdField_a_of_type_JavaLangString;
  private vrk jdField_a_of_type_Vrk;
  
  vqw(vrk paramvrk, String paramString)
  {
    this.jdField_a_of_type_Vrk = paramvrk;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a() {}
  
  public void a(int paramInt1, int paramInt2, int paramInt3) {}
  
  public void b()
  {
    Object localObject = new File(this.jdField_a_of_type_JavaLangString.substring(0, this.jdField_a_of_type_JavaLangString.lastIndexOf(".af")).concat("_").concat(String.valueOf(this.jdField_a_of_type_Vrk.c)).concat(".pcm"));
    if (((File)localObject).exists())
    {
      File localFile = new File(this.jdField_a_of_type_JavaLangString);
      if (localFile.exists()) {
        localFile.delete();
      }
      bbdx.a((File)localObject, new File(this.jdField_a_of_type_JavaLangString));
      if (vqu.a() != null)
      {
        localObject = vqu.a().obtainMessage(10);
        ((Message)localObject).obj = this.jdField_a_of_type_Vrk;
        vqu.a().sendMessage((Message)localObject);
      }
    }
  }
  
  public void c() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vqw
 * JD-Core Version:    0.7.0.1
 */