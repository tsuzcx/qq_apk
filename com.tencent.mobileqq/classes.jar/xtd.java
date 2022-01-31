import java.util.ArrayList;

class xtd
  extends xtb
{
  xtd(xtc paramxtc, xtk paramxtk) {}
  
  public void onFailure(String paramString)
  {
    this.jdField_a_of_type_Xtk.onFailure(paramString);
  }
  
  public void onFinish(boolean paramBoolean)
  {
    xtc localxtc;
    if (this.jdField_a_of_type_Xtc.jdField_a_of_type_JavaUtilArrayList.size() == 0)
    {
      localxtc = this.jdField_a_of_type_Xtc;
      if (!paramBoolean) {
        break label44;
      }
    }
    label44:
    for (int i = 1;; i = 0)
    {
      localxtc.jdField_a_of_type_Int = i;
      xtc.jdField_a_of_type_Xtc = null;
      this.jdField_a_of_type_Xtk.onFinish(paramBoolean);
      return;
    }
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
 * Qualified Name:     xtd
 * JD-Core Version:    0.7.0.1
 */