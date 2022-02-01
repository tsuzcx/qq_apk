import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;

class yyk
  extends wve
{
  yyk(yyj paramyyj, String paramString)
  {
    super(paramString);
  }
  
  public void onLocationFinish(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    super.onLocationFinish(paramInt, paramSosoLbsInfo);
    if ((paramInt == 0) && (paramSosoLbsInfo != null) && (paramSosoLbsInfo.a != null))
    {
      this.a.jdField_a_of_type_Yyg.a = paramSosoLbsInfo.a.a;
      this.a.jdField_a_of_type_Yyg.b = paramSosoLbsInfo.a.b;
      yuk.b("Q.qqstory.publish.edit.EditVideoPoi", "onLocationUpdate() latitude=" + this.a.jdField_a_of_type_Yyg.a + " longitude=" + this.a.jdField_a_of_type_Yyg.b);
      if (this.a.jdField_a_of_type_Boolean) {
        this.a.jdField_a_of_type_Yyg.f();
      }
      return;
    }
    this.a.jdField_a_of_type_Yyg.a = 0.0D;
    this.a.jdField_a_of_type_Yyg.b = 0.0D;
    yuk.b("Q.qqstory.publish.edit.EditVideoPoi", "onLocationUpdate() error");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yyk
 * JD-Core Version:    0.7.0.1
 */