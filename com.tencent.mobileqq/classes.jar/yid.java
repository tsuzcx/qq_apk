import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.utils.FileUtils;
import java.io.File;

class yid
  implements bgrj
{
  private String jdField_a_of_type_JavaLangString;
  private yir jdField_a_of_type_Yir;
  
  yid(yir paramyir, String paramString)
  {
    this.jdField_a_of_type_Yir = paramyir;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void onError() {}
  
  public void onPlayEnd()
  {
    Object localObject = new File(this.jdField_a_of_type_JavaLangString.substring(0, this.jdField_a_of_type_JavaLangString.lastIndexOf(".af")).concat("_").concat(String.valueOf(this.jdField_a_of_type_Yir.c)).concat(".pcm"));
    if (((File)localObject).exists())
    {
      File localFile = new File(this.jdField_a_of_type_JavaLangString);
      if (localFile.exists()) {
        localFile.delete();
      }
      FileUtils.copyFile((File)localObject, new File(this.jdField_a_of_type_JavaLangString));
      if (yib.a() != null)
      {
        localObject = yib.a().obtainMessage(10);
        ((Message)localObject).obj = this.jdField_a_of_type_Yir;
        yib.a().sendMessage((Message)localObject);
      }
    }
  }
  
  public void onPlayStop() {}
  
  public void onSlicePlayed(int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yid
 * JD-Core Version:    0.7.0.1
 */