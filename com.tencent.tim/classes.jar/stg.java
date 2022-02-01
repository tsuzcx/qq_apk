import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.qphone.base.util.QLog;

class stg
  extends aczc.b
{
  stg(stf paramstf, String paramString)
  {
    super(paramString);
  }
  
  public void onLocationFinish(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.e("LocationPlugin", 2, "onLocationFinish errCode = " + paramInt);
    }
    ste.a(this.a.a, paramSosoLbsInfo, this.a.VA);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     stg
 * JD-Core Version:    0.7.0.1
 */