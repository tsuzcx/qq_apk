import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.qphone.base.util.QLog;

class yzd
  extends amky
{
  yzd(yzc paramyzc, String paramString)
  {
    super(paramString);
  }
  
  public void onLocationFinish(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.e("LocationPlugin", 2, "onLocationFinish errCode = " + paramInt);
    }
    yzb.a(this.a.jdField_a_of_type_Yzb, paramSosoLbsInfo, this.a.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     yzd
 * JD-Core Version:    0.7.0.1
 */