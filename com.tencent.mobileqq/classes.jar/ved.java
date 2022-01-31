import android.os.Handler;
import android.os.Message;
import java.io.File;

class ved
  implements bawr
{
  private String jdField_a_of_type_JavaLangString;
  private ver jdField_a_of_type_Ver;
  
  ved(ver paramver, String paramString)
  {
    this.jdField_a_of_type_Ver = paramver;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a() {}
  
  public void a(int paramInt1, int paramInt2, int paramInt3) {}
  
  public void b()
  {
    Object localObject = new File(this.jdField_a_of_type_JavaLangString.substring(0, this.jdField_a_of_type_JavaLangString.lastIndexOf(".af")).concat("_").concat(String.valueOf(this.jdField_a_of_type_Ver.c)).concat(".pcm"));
    if (((File)localObject).exists())
    {
      File localFile = new File(this.jdField_a_of_type_JavaLangString);
      if (localFile.exists()) {
        localFile.delete();
      }
      bace.a((File)localObject, new File(this.jdField_a_of_type_JavaLangString));
      if (veb.a() != null)
      {
        localObject = veb.a().obtainMessage(10);
        ((Message)localObject).obj = this.jdField_a_of_type_Ver;
        veb.a().sendMessage((Message)localObject);
      }
    }
  }
  
  public void c() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ved
 * JD-Core Version:    0.7.0.1
 */