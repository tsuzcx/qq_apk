import java.io.File;
import java.util.ArrayList;

class wag
  extends wad
{
  wag(wae paramwae, wam paramwam, File paramFile) {}
  
  public void onFailure(String paramString)
  {
    this.jdField_a_of_type_Wam.onFailure(paramString);
  }
  
  public void onFinish(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_JavaIoFile.exists()) {
      this.jdField_a_of_type_JavaIoFile.delete();
    }
    int i = 0;
    while (i < this.jdField_a_of_type_Wae.b.size())
    {
      File localFile = new File((String)this.jdField_a_of_type_Wae.b.get(i));
      if (localFile.exists()) {
        localFile.delete();
      }
      i += 1;
    }
    this.jdField_a_of_type_Wae.b = new ArrayList();
    this.jdField_a_of_type_Wam.onFinish(paramBoolean);
  }
  
  public void onProgress(String paramString)
  {
    this.jdField_a_of_type_Wam.onProgress(paramString);
  }
  
  public void onStart()
  {
    this.jdField_a_of_type_Wam.onStart();
  }
  
  public void onSuccess(String paramString)
  {
    this.jdField_a_of_type_Wam.onSuccess(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     wag
 * JD-Core Version:    0.7.0.1
 */