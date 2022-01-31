import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;

class xbe
  extends uxx
{
  xbe(xbd paramxbd, String paramString)
  {
    super(paramString);
  }
  
  public void onLocationFinish(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    super.onLocationFinish(paramInt, paramSosoLbsInfo);
    if ((paramInt == 0) && (paramSosoLbsInfo != null) && (paramSosoLbsInfo.a != null))
    {
      this.a.jdField_a_of_type_Xba.a = paramSosoLbsInfo.a.a;
      this.a.jdField_a_of_type_Xba.b = paramSosoLbsInfo.a.b;
      wxe.b("Q.qqstory.publish.edit.EditVideoPoi", "onLocationUpdate() latitude=" + this.a.jdField_a_of_type_Xba.a + " longitude=" + this.a.jdField_a_of_type_Xba.b);
      if (this.a.jdField_a_of_type_Boolean) {
        this.a.jdField_a_of_type_Xba.f();
      }
      return;
    }
    this.a.jdField_a_of_type_Xba.a = 0.0D;
    this.a.jdField_a_of_type_Xba.b = 0.0D;
    wxe.b("Q.qqstory.publish.edit.EditVideoPoi", "onLocationUpdate() error");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xbe
 * JD-Core Version:    0.7.0.1
 */