import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.mobileqq.app.soso.SosoInterface.a;
import com.tencent.qphone.base.util.QLog;

class asgy
  extends SosoInterface.a
{
  asgy(asgx paramasgx, int paramInt1, boolean paramBoolean1, boolean paramBoolean2, long paramLong, boolean paramBoolean3, boolean paramBoolean4, String paramString1, String paramString2, int paramInt2, String paramString3, int paramInt3, String paramString4, String paramString5, String paramString6)
  {
    super(paramInt1, paramBoolean1, paramBoolean2, paramLong, paramBoolean3, paramBoolean4, paramString1);
  }
  
  public void onLocationFinish(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    double d2 = 0.0D;
    if (QLog.isColorLevel()) {
      QLog.d("QidianManager", 2, "onLocationFinish(): BEGIN errCode=" + paramInt);
    }
    String str;
    double d1;
    if ((paramInt == 0) && (paramSosoLbsInfo != null) && (paramSosoLbsInfo.a != null)) {
      if (paramSosoLbsInfo.a.address != null)
      {
        str = paramSosoLbsInfo.a.address;
        if (QLog.isColorLevel()) {
          QLog.d("QidianManager", 2, "onLocationFinish() latitude=" + paramSosoLbsInfo.a.cd + ", longitude=" + paramSosoLbsInfo.a.ce + ", address=" + str);
        }
        d1 = paramSosoLbsInfo.a.cd;
        d2 = paramSosoLbsInfo.a.ce;
      }
    }
    for (;;)
    {
      this.this$0.a(this.cEF, this.cWY, true, d1, d2, this.cEG, this.ema, this.cEH, this.cEI, this.cEJ);
      return;
      str = "";
      break;
      d1 = 0.0D;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     asgy
 * JD-Core Version:    0.7.0.1
 */