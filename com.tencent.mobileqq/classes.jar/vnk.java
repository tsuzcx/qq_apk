import java.io.File;
import java.util.ArrayList;

class vnk
  extends vnh
{
  vnk(vni paramvni, vnq paramvnq, File paramFile) {}
  
  public void onFailure(String paramString)
  {
    this.jdField_a_of_type_Vnq.onFailure(paramString);
  }
  
  public void onFinish(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_JavaIoFile.exists()) {
      this.jdField_a_of_type_JavaIoFile.delete();
    }
    int i = 0;
    while (i < this.jdField_a_of_type_Vni.b.size())
    {
      File localFile = new File((String)this.jdField_a_of_type_Vni.b.get(i));
      if (localFile.exists()) {
        localFile.delete();
      }
      i += 1;
    }
    this.jdField_a_of_type_Vni.b = new ArrayList();
    this.jdField_a_of_type_Vnq.onFinish(paramBoolean);
  }
  
  public void onProgress(String paramString)
  {
    this.jdField_a_of_type_Vnq.onProgress(paramString);
  }
  
  public void onStart()
  {
    this.jdField_a_of_type_Vnq.onStart();
  }
  
  public void onSuccess(String paramString)
  {
    this.jdField_a_of_type_Vnq.onSuccess(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vnk
 * JD-Core Version:    0.7.0.1
 */