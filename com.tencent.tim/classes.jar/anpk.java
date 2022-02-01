import com.tencent.qmsp.sdk.base.IVendorCallback;
import com.tencent.qphone.base.util.QLog;

class anpk
  implements IVendorCallback
{
  anpk(anpj paramanpj) {}
  
  public void onResult(boolean paramBoolean, String paramString1, String paramString2)
  {
    QLog.d("TimBeaconPrivacyInfo", 2, "getOAID: isEnable:" + paramBoolean + " aaid: " + paramString1 + ", oaid: " + paramString2);
    anpj.a(this.b, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anpk
 * JD-Core Version:    0.7.0.1
 */