import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.qphone.base.util.QLog;

class ypp
  extends aczc.b
{
  ypp(ypo paramypo, String paramString, acms paramacms, boolean paramBoolean)
  {
    super(paramString);
  }
  
  public void onLocationFinish(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ac_ft.AddContactFindTroopRTLW", 2, "getRecommendTroopList onLocationFinish info = " + paramSosoLbsInfo);
    }
    if (paramInt != 0) {
      QLog.i("ac_ft.AddContactFindTroopRTLW", 1, "getRecommendTroopList onLocationFinish, errorCode=" + paramInt);
    }
    this.f.a(1, this.this$0.uo, 25, this.axa, ypo.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     ypp
 * JD-Core Version:    0.7.0.1
 */