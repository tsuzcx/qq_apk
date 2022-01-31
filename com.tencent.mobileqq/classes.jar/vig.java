import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;

class vig
  extends tez
{
  vig(vif paramvif, String paramString)
  {
    super(paramString);
  }
  
  public void onLocationFinish(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    super.onLocationFinish(paramInt, paramSosoLbsInfo);
    if ((paramInt == 0) && (paramSosoLbsInfo != null) && (paramSosoLbsInfo.a != null))
    {
      this.a.jdField_a_of_type_Vic.a = paramSosoLbsInfo.a.a;
      this.a.jdField_a_of_type_Vic.b = paramSosoLbsInfo.a.b;
      veg.b("Q.qqstory.publish.edit.EditVideoPoi", "onLocationUpdate() latitude=" + this.a.jdField_a_of_type_Vic.a + " longitude=" + this.a.jdField_a_of_type_Vic.b);
      if (this.a.jdField_a_of_type_Boolean) {
        this.a.jdField_a_of_type_Vic.f();
      }
      return;
    }
    this.a.jdField_a_of_type_Vic.a = 0.0D;
    this.a.jdField_a_of_type_Vic.b = 0.0D;
    veg.b("Q.qqstory.publish.edit.EditVideoPoi", "onLocationUpdate() error");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vig
 * JD-Core Version:    0.7.0.1
 */