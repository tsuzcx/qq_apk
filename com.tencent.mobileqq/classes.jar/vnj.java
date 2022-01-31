import java.util.ArrayList;

class vnj
  extends vnh
{
  vnj(vni paramvni, vnq paramvnq) {}
  
  public void onFailure(String paramString)
  {
    this.jdField_a_of_type_Vnq.onFailure(paramString);
  }
  
  public void onFinish(boolean paramBoolean)
  {
    vni localvni;
    if (this.jdField_a_of_type_Vni.jdField_a_of_type_JavaUtilArrayList.size() == 0)
    {
      localvni = this.jdField_a_of_type_Vni;
      if (!paramBoolean) {
        break label44;
      }
    }
    label44:
    for (int i = 1;; i = 0)
    {
      localvni.jdField_a_of_type_Int = i;
      vni.jdField_a_of_type_Vni = null;
      this.jdField_a_of_type_Vnq.onFinish(paramBoolean);
      return;
    }
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
 * Qualified Name:     vnj
 * JD-Core Version:    0.7.0.1
 */