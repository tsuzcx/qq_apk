import android.os.Handler;
import android.os.Message;
import java.io.File;

class zhd
  implements bila
{
  private String jdField_a_of_type_JavaLangString;
  private zhr jdField_a_of_type_Zhr;
  
  zhd(zhr paramzhr, String paramString)
  {
    this.jdField_a_of_type_Zhr = paramzhr;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a() {}
  
  public void a(int paramInt1, int paramInt2, int paramInt3) {}
  
  public void ai_()
  {
    Object localObject = new File(this.jdField_a_of_type_JavaLangString.substring(0, this.jdField_a_of_type_JavaLangString.lastIndexOf(".af")).concat("_").concat(String.valueOf(this.jdField_a_of_type_Zhr.c)).concat(".pcm"));
    if (((File)localObject).exists())
    {
      File localFile = new File(this.jdField_a_of_type_JavaLangString);
      if (localFile.exists()) {
        localFile.delete();
      }
      bhmi.a((File)localObject, new File(this.jdField_a_of_type_JavaLangString));
      if (zhb.a() != null)
      {
        localObject = zhb.a().obtainMessage(10);
        ((Message)localObject).obj = this.jdField_a_of_type_Zhr;
        zhb.a().sendMessage((Message)localObject);
      }
    }
  }
  
  public void aj_() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zhd
 * JD-Core Version:    0.7.0.1
 */