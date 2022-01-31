import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;

class uvk
  extends ssd
{
  uvk(uvj paramuvj, String paramString)
  {
    super(paramString);
  }
  
  public void onLocationFinish(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    super.onLocationFinish(paramInt, paramSosoLbsInfo);
    if ((paramInt == 0) && (paramSosoLbsInfo != null) && (paramSosoLbsInfo.a != null))
    {
      this.a.jdField_a_of_type_Uvg.a = paramSosoLbsInfo.a.a;
      this.a.jdField_a_of_type_Uvg.b = paramSosoLbsInfo.a.b;
      urk.b("Q.qqstory.publish.edit.EditVideoPoi", "onLocationUpdate() latitude=" + this.a.jdField_a_of_type_Uvg.a + " longitude=" + this.a.jdField_a_of_type_Uvg.b);
      if (this.a.jdField_a_of_type_Boolean) {
        this.a.jdField_a_of_type_Uvg.f();
      }
      return;
    }
    this.a.jdField_a_of_type_Uvg.a = 0.0D;
    this.a.jdField_a_of_type_Uvg.b = 0.0D;
    urk.b("Q.qqstory.publish.edit.EditVideoPoi", "onLocationUpdate() error");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uvk
 * JD-Core Version:    0.7.0.1
 */