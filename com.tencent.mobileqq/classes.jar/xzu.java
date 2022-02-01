import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;

class xzu
  extends vwu
{
  xzu(xzt paramxzt, String paramString)
  {
    super(paramString);
  }
  
  public void onLocationFinish(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    super.onLocationFinish(paramInt, paramSosoLbsInfo);
    if ((paramInt == 0) && (paramSosoLbsInfo != null) && (paramSosoLbsInfo.mLocation != null))
    {
      this.a.jdField_a_of_type_Xzq.a = paramSosoLbsInfo.mLocation.mLat02;
      this.a.jdField_a_of_type_Xzq.b = paramSosoLbsInfo.mLocation.mLon02;
      xvv.b("Q.qqstory.publish.edit.EditVideoPoi", "onLocationUpdate() latitude=" + this.a.jdField_a_of_type_Xzq.a + " longitude=" + this.a.jdField_a_of_type_Xzq.b);
      if (this.a.jdField_a_of_type_Boolean) {
        this.a.jdField_a_of_type_Xzq.g();
      }
      return;
    }
    this.a.jdField_a_of_type_Xzq.a = 0.0D;
    this.a.jdField_a_of_type_Xzq.b = 0.0D;
    xvv.b("Q.qqstory.publish.edit.EditVideoPoi", "onLocationUpdate() error");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xzu
 * JD-Core Version:    0.7.0.1
 */