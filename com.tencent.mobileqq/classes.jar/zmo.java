import java.util.ArrayList;

class zmo
  extends zmm
{
  zmo(zmn paramzmn, zmv paramzmv) {}
  
  public void onFailure(String paramString)
  {
    this.jdField_a_of_type_Zmv.onFailure(paramString);
  }
  
  public void onFinish(boolean paramBoolean)
  {
    zmn localzmn;
    if (this.jdField_a_of_type_Zmn.jdField_a_of_type_JavaUtilArrayList.size() == 0)
    {
      localzmn = this.jdField_a_of_type_Zmn;
      if (!paramBoolean) {
        break label44;
      }
    }
    label44:
    for (int i = 1;; i = 0)
    {
      localzmn.jdField_a_of_type_Int = i;
      zmn.jdField_a_of_type_Zmn = null;
      this.jdField_a_of_type_Zmv.onFinish(paramBoolean);
      return;
    }
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
 * Qualified Name:     zmo
 * JD-Core Version:    0.7.0.1
 */