import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;

class vid
  extends tew
{
  vid(vic paramvic, String paramString)
  {
    super(paramString);
  }
  
  public void onLocationFinish(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    super.onLocationFinish(paramInt, paramSosoLbsInfo);
    if ((paramInt == 0) && (paramSosoLbsInfo != null) && (paramSosoLbsInfo.a != null))
    {
      this.a.jdField_a_of_type_Vhz.a = paramSosoLbsInfo.a.a;
      this.a.jdField_a_of_type_Vhz.b = paramSosoLbsInfo.a.b;
      ved.b("Q.qqstory.publish.edit.EditVideoPoi", "onLocationUpdate() latitude=" + this.a.jdField_a_of_type_Vhz.a + " longitude=" + this.a.jdField_a_of_type_Vhz.b);
      if (this.a.jdField_a_of_type_Boolean) {
        this.a.jdField_a_of_type_Vhz.f();
      }
      return;
    }
    this.a.jdField_a_of_type_Vhz.a = 0.0D;
    this.a.jdField_a_of_type_Vhz.b = 0.0D;
    ved.b("Q.qqstory.publish.edit.EditVideoPoi", "onLocationUpdate() error");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vid
 * JD-Core Version:    0.7.0.1
 */