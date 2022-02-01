import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;

class yup
  extends wrj
{
  yup(yuo paramyuo, String paramString)
  {
    super(paramString);
  }
  
  public void onLocationFinish(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    super.onLocationFinish(paramInt, paramSosoLbsInfo);
    if ((paramInt == 0) && (paramSosoLbsInfo != null) && (paramSosoLbsInfo.a != null))
    {
      this.a.jdField_a_of_type_Yul.a = paramSosoLbsInfo.a.a;
      this.a.jdField_a_of_type_Yul.b = paramSosoLbsInfo.a.b;
      yqp.b("Q.qqstory.publish.edit.EditVideoPoi", "onLocationUpdate() latitude=" + this.a.jdField_a_of_type_Yul.a + " longitude=" + this.a.jdField_a_of_type_Yul.b);
      if (this.a.jdField_a_of_type_Boolean) {
        this.a.jdField_a_of_type_Yul.f();
      }
      return;
    }
    this.a.jdField_a_of_type_Yul.a = 0.0D;
    this.a.jdField_a_of_type_Yul.b = 0.0D;
    yqp.b("Q.qqstory.publish.edit.EditVideoPoi", "onLocationUpdate() error");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yup
 * JD-Core Version:    0.7.0.1
 */