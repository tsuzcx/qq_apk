import java.util.ArrayList;

class wac
  extends waa
{
  wac(wab paramwab, waj paramwaj) {}
  
  public void onFailure(String paramString)
  {
    this.jdField_a_of_type_Waj.onFailure(paramString);
  }
  
  public void onFinish(boolean paramBoolean)
  {
    wab localwab;
    if (this.jdField_a_of_type_Wab.jdField_a_of_type_JavaUtilArrayList.size() == 0)
    {
      localwab = this.jdField_a_of_type_Wab;
      if (!paramBoolean) {
        break label44;
      }
    }
    label44:
    for (int i = 1;; i = 0)
    {
      localwab.jdField_a_of_type_Int = i;
      wab.jdField_a_of_type_Wab = null;
      this.jdField_a_of_type_Waj.onFinish(paramBoolean);
      return;
    }
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
 * Qualified Name:     wac
 * JD-Core Version:    0.7.0.1
 */