import java.io.File;
import java.util.ArrayList;

class zmp
  extends zmm
{
  zmp(zmn paramzmn, zmv paramzmv, File paramFile) {}
  
  public void onFailure(String paramString)
  {
    this.jdField_a_of_type_Zmv.onFailure(paramString);
  }
  
  public void onFinish(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_JavaIoFile.exists()) {
      this.jdField_a_of_type_JavaIoFile.delete();
    }
    int i = 0;
    while (i < this.jdField_a_of_type_Zmn.b.size())
    {
      File localFile = new File((String)this.jdField_a_of_type_Zmn.b.get(i));
      if (localFile.exists()) {
        localFile.delete();
      }
      i += 1;
    }
    this.jdField_a_of_type_Zmn.b = new ArrayList();
    this.jdField_a_of_type_Zmv.onFinish(paramBoolean);
  }
  
  public void onProgress(String paramString)
  {
    this.jdField_a_of_type_Zmv.onProgress(paramString);
  }
  
  public void onStart()
  {
    this.jdField_a_of_type_Zmv.onStart();
  }
  
  public void onSuccess(String paramString)
  {
    this.jdField_a_of_type_Zmv.onSuccess(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zmp
 * JD-Core Version:    0.7.0.1
 */