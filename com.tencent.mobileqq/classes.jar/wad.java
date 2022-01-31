import java.io.File;
import java.util.ArrayList;

class wad
  extends waa
{
  wad(wab paramwab, waj paramwaj, File paramFile) {}
  
  public void onFailure(String paramString)
  {
    this.jdField_a_of_type_Waj.onFailure(paramString);
  }
  
  public void onFinish(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_JavaIoFile.exists()) {
      this.jdField_a_of_type_JavaIoFile.delete();
    }
    int i = 0;
    while (i < this.jdField_a_of_type_Wab.b.size())
    {
      File localFile = new File((String)this.jdField_a_of_type_Wab.b.get(i));
      if (localFile.exists()) {
        localFile.delete();
      }
      i += 1;
    }
    this.jdField_a_of_type_Wab.b = new ArrayList();
    this.jdField_a_of_type_Waj.onFinish(paramBoolean);
  }
  
  public void onProgress(String paramString)
  {
    this.jdField_a_of_type_Waj.onProgress(paramString);
  }
  
  public void onStart()
  {
    this.jdField_a_of_type_Waj.onStart();
  }
  
  public void onSuccess(String paramString)
  {
    this.jdField_a_of_type_Waj.onSuccess(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     wad
 * JD-Core Version:    0.7.0.1
 */