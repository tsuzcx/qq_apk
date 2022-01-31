import java.io.File;
import java.util.ArrayList;

class xov
  extends xos
{
  xov(xot paramxot, xpb paramxpb, File paramFile) {}
  
  public void onFailure(String paramString)
  {
    this.jdField_a_of_type_Xpb.onFailure(paramString);
  }
  
  public void onFinish(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_JavaIoFile.exists()) {
      this.jdField_a_of_type_JavaIoFile.delete();
    }
    int i = 0;
    while (i < this.jdField_a_of_type_Xot.b.size())
    {
      File localFile = new File((String)this.jdField_a_of_type_Xot.b.get(i));
      if (localFile.exists()) {
        localFile.delete();
      }
      i += 1;
    }
    this.jdField_a_of_type_Xot.b = new ArrayList();
    this.jdField_a_of_type_Xpb.onFinish(paramBoolean);
  }
  
  public void onProgress(String paramString)
  {
    this.jdField_a_of_type_Xpb.onProgress(paramString);
  }
  
  public void onStart()
  {
    this.jdField_a_of_type_Xpb.onStart();
  }
  
  public void onSuccess(String paramString)
  {
    this.jdField_a_of_type_Xpb.onSuccess(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xov
 * JD-Core Version:    0.7.0.1
 */