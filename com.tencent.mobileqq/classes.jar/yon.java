import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;

class yon
  extends wlp
{
  yon(yom paramyom, String paramString)
  {
    super(paramString);
  }
  
  public void onLocationFinish(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    super.onLocationFinish(paramInt, paramSosoLbsInfo);
    if ((paramInt == 0) && (paramSosoLbsInfo != null) && (paramSosoLbsInfo.mLocation != null))
    {
      this.a.jdField_a_of_type_Yoj.a = paramSosoLbsInfo.mLocation.mLat02;
      this.a.jdField_a_of_type_Yoj.b = paramSosoLbsInfo.mLocation.mLon02;
      ykq.b("Q.qqstory.publish.edit.EditVideoPoi", "onLocationUpdate() latitude=" + this.a.jdField_a_of_type_Yoj.a + " longitude=" + this.a.jdField_a_of_type_Yoj.b);
      if (this.a.jdField_a_of_type_Boolean) {
        this.a.jdField_a_of_type_Yoj.g();
      }
      return;
    }
    this.a.jdField_a_of_type_Yoj.a = 0.0D;
    this.a.jdField_a_of_type_Yoj.b = 0.0D;
    ykq.b("Q.qqstory.publish.edit.EditVideoPoi", "onLocationUpdate() error");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yon
 * JD-Core Version:    0.7.0.1
 */