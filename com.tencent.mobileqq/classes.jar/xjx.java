import android.os.Handler;
import android.os.Message;
import java.io.File;

class xjx
  implements bedj
{
  private String jdField_a_of_type_JavaLangString;
  private xkl jdField_a_of_type_Xkl;
  
  xjx(xkl paramxkl, String paramString)
  {
    this.jdField_a_of_type_Xkl = paramxkl;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a() {}
  
  public void a(int paramInt1, int paramInt2, int paramInt3) {}
  
  public void b()
  {
    Object localObject = new File(this.jdField_a_of_type_JavaLangString.substring(0, this.jdField_a_of_type_JavaLangString.lastIndexOf(".af")).concat("_").concat(String.valueOf(this.jdField_a_of_type_Xkl.c)).concat(".pcm"));
    if (((File)localObject).exists())
    {
      File localFile = new File(this.jdField_a_of_type_JavaLangString);
      if (localFile.exists()) {
        localFile.delete();
      }
      bdhb.a((File)localObject, new File(this.jdField_a_of_type_JavaLangString));
      if (xjv.a() != null)
      {
        localObject = xjv.a().obtainMessage(10);
        ((Message)localObject).obj = this.jdField_a_of_type_Xkl;
        xjv.a().sendMessage((Message)localObject);
      }
    }
  }
  
  public void c() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xjx
 * JD-Core Version:    0.7.0.1
 */