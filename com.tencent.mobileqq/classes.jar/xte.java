import java.io.File;
import java.util.ArrayList;

class xte
  extends xtb
{
  xte(xtc paramxtc, xtk paramxtk, File paramFile) {}
  
  public void onFailure(String paramString)
  {
    this.jdField_a_of_type_Xtk.onFailure(paramString);
  }
  
  public void onFinish(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_JavaIoFile.exists()) {
      this.jdField_a_of_type_JavaIoFile.delete();
    }
    int i = 0;
    while (i < this.jdField_a_of_type_Xtc.b.size())
    {
      File localFile = new File((String)this.jdField_a_of_type_Xtc.b.get(i));
      if (localFile.exists()) {
        localFile.delete();
      }
      i += 1;
    }
    this.jdField_a_of_type_Xtc.b = new ArrayList();
    this.jdField_a_of_type_Xtk.onFinish(paramBoolean);
  }
  
  public void onProgress(String paramString)
  {
    this.jdField_a_of_type_Xtk.onProgress(paramString);
  }
  
  public void onStart()
  {
    this.jdField_a_of_type_Xtk.onStart();
  }
  
  public void onSuccess(String paramString)
  {
    this.jdField_a_of_type_Xtk.onSuccess(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xte
 * JD-Core Version:    0.7.0.1
 */