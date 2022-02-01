import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.qphone.base.util.QLog;

class ivd
  implements ivc.b.a
{
  ivd(ivc paramivc, long paramLong) {}
  
  public void C(int paramInt1, int paramInt2, int paramInt3)
  {
    QLog.w("ShareChat", 1, "onFinish, choosedChannel[" + paramInt1 + "], choosedLinkType[" + paramInt2 + "], result[" + paramInt3 + "], seq[" + this.kQ + "]");
    jjk.b.ce(paramInt1, paramInt2);
    if (paramInt3 == 2) {
      jjk.b.g(paramInt1, paramInt2, 99, null);
    }
  }
  
  public void D(int paramInt1, int paramInt2, int paramInt3)
  {
    QLog.w("ShareChat", 1, "onQRForward, choosedChannel[" + paramInt1 + "], choosedLinkType[" + paramInt2 + "], result[" + paramInt3 + "], seq[" + this.kQ + "]");
    if (paramInt3 == 2) {
      jjk.b.g(paramInt1, paramInt2, 99, null);
    }
  }
  
  public Bitmap a(long paramLong)
  {
    if (this.a.mApp == null) {
      return null;
    }
    return this.a.mApp.a(this.a.QE, (byte)1, false, false);
  }
  
  public TroopInfoData a()
  {
    return this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData;
  }
  
  public String aR(int paramInt)
  {
    return null;
  }
  
  public String d(long paramLong, int paramInt)
  {
    Object localObject;
    if (this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity == null) {
      localObject = null;
    }
    String str;
    do
    {
      return localObject;
      str = ivc.a(this.a, paramInt);
      localObject = str;
    } while (!TextUtils.isEmpty(str));
    this.a.g(paramLong, this.a.oi, this.a.atS);
    return str;
  }
  
  public String getDesc()
  {
    return ivc.a(this.a.mApp, this.a.QE);
  }
  
  public String hh()
  {
    return ivc.dw(this.a.QE);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ivd
 * JD-Core Version:    0.7.0.1
 */