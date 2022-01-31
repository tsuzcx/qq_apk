import java.util.ArrayList;

class waf
  extends wad
{
  waf(wae paramwae, wam paramwam) {}
  
  public void onFailure(String paramString)
  {
    this.jdField_a_of_type_Wam.onFailure(paramString);
  }
  
  public void onFinish(boolean paramBoolean)
  {
    wae localwae;
    if (this.jdField_a_of_type_Wae.jdField_a_of_type_JavaUtilArrayList.size() == 0)
    {
      localwae = this.jdField_a_of_type_Wae;
      if (!paramBoolean) {
        break label44;
      }
    }
    label44:
    for (int i = 1;; i = 0)
    {
      localwae.jdField_a_of_type_Int = i;
      wae.jdField_a_of_type_Wae = null;
      this.jdField_a_of_type_Wam.onFinish(paramBoolean);
      return;
    }
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
 * Qualified Name:     waf
 * JD-Core Version:    0.7.0.1
 */