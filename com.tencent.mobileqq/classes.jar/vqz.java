import android.os.Handler;
import android.os.Message;
import java.io.File;

class vqz
  implements bbzl
{
  private String jdField_a_of_type_JavaLangString;
  private vrn jdField_a_of_type_Vrn;
  
  vqz(vrn paramvrn, String paramString)
  {
    this.jdField_a_of_type_Vrn = paramvrn;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a() {}
  
  public void a(int paramInt1, int paramInt2, int paramInt3) {}
  
  public void b()
  {
    Object localObject = new File(this.jdField_a_of_type_JavaLangString.substring(0, this.jdField_a_of_type_JavaLangString.lastIndexOf(".af")).concat("_").concat(String.valueOf(this.jdField_a_of_type_Vrn.c)).concat(".pcm"));
    if (((File)localObject).exists())
    {
      File localFile = new File(this.jdField_a_of_type_JavaLangString);
      if (localFile.exists()) {
        localFile.delete();
      }
      bbdj.a((File)localObject, new File(this.jdField_a_of_type_JavaLangString));
      if (vqx.a() != null)
      {
        localObject = vqx.a().obtainMessage(10);
        ((Message)localObject).obj = this.jdField_a_of_type_Vrn;
        vqx.a().sendMessage((Message)localObject);
      }
    }
  }
  
  public void c() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vqz
 * JD-Core Version:    0.7.0.1
 */