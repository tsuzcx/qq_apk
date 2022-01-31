import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;

class wwv
  extends uto
{
  wwv(wwu paramwwu, String paramString)
  {
    super(paramString);
  }
  
  public void onLocationFinish(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    super.onLocationFinish(paramInt, paramSosoLbsInfo);
    if ((paramInt == 0) && (paramSosoLbsInfo != null) && (paramSosoLbsInfo.a != null))
    {
      this.a.jdField_a_of_type_Wwr.a = paramSosoLbsInfo.a.a;
      this.a.jdField_a_of_type_Wwr.b = paramSosoLbsInfo.a.b;
      wsv.b("Q.qqstory.publish.edit.EditVideoPoi", "onLocationUpdate() latitude=" + this.a.jdField_a_of_type_Wwr.a + " longitude=" + this.a.jdField_a_of_type_Wwr.b);
      if (this.a.jdField_a_of_type_Boolean) {
        this.a.jdField_a_of_type_Wwr.f();
      }
      return;
    }
    this.a.jdField_a_of_type_Wwr.a = 0.0D;
    this.a.jdField_a_of_type_Wwr.b = 0.0D;
    wsv.b("Q.qqstory.publish.edit.EditVideoPoi", "onLocationUpdate() error");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wwv
 * JD-Core Version:    0.7.0.1
 */