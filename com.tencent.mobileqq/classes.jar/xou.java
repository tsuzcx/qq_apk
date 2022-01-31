import java.util.ArrayList;

class xou
  extends xos
{
  xou(xot paramxot, xpb paramxpb) {}
  
  public void onFailure(String paramString)
  {
    this.jdField_a_of_type_Xpb.onFailure(paramString);
  }
  
  public void onFinish(boolean paramBoolean)
  {
    xot localxot;
    if (this.jdField_a_of_type_Xot.jdField_a_of_type_JavaUtilArrayList.size() == 0)
    {
      localxot = this.jdField_a_of_type_Xot;
      if (!paramBoolean) {
        break label44;
      }
    }
    label44:
    for (int i = 1;; i = 0)
    {
      localxot.jdField_a_of_type_Int = i;
      xot.jdField_a_of_type_Xot = null;
      this.jdField_a_of_type_Xpb.onFinish(paramBoolean);
      return;
    }
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
 * Qualified Name:     xou
 * JD-Core Version:    0.7.0.1
 */