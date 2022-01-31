import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.qphone.base.util.QLog;

class xkk
  extends akui
{
  xkk(xkj paramxkj, String paramString)
  {
    super(paramString);
  }
  
  public void onLocationFinish(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.e("LocationPlugin", 2, "onLocationFinish errCode = " + paramInt);
    }
    xki.a(this.a.jdField_a_of_type_Xki, paramSosoLbsInfo, this.a.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     xkk
 * JD-Core Version:    0.7.0.1
 */