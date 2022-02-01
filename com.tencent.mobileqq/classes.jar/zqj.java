import java.util.ArrayList;

class zqj
  extends zqh
{
  zqj(zqi paramzqi, zqq paramzqq) {}
  
  public void onFailure(String paramString)
  {
    this.jdField_a_of_type_Zqq.onFailure(paramString);
  }
  
  public void onFinish(boolean paramBoolean)
  {
    zqi localzqi;
    if (this.jdField_a_of_type_Zqi.jdField_a_of_type_JavaUtilArrayList.size() == 0)
    {
      localzqi = this.jdField_a_of_type_Zqi;
      if (!paramBoolean) {
        break label44;
      }
    }
    label44:
    for (int i = 1;; i = 0)
    {
      localzqi.jdField_a_of_type_Int = i;
      zqi.jdField_a_of_type_Zqi = null;
      this.jdField_a_of_type_Zqq.onFinish(paramBoolean);
      return;
    }
  }
  
  public void onProgress(String paramString)
  {
    this.jdField_a_of_type_Zqq.onProgress(paramString);
  }
  
  public void onStart()
  {
    this.jdField_a_of_type_Zqq.onStart();
  }
  
  public void onSuccess(String paramString)
  {
    this.jdField_a_of_type_Zqq.onSuccess(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zqj
 * JD-Core Version:    0.7.0.1
 */