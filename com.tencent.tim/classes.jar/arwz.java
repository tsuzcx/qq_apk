import android.os.Bundle;
import mqq.manager.WtloginManager;
import mqq.observer.SSOAccountObserver;
import oicq.wlogin_sdk.sharemem.WloginSimpleInfo;
import oicq.wlogin_sdk.tools.RSACrypt;
import oicq.wlogin_sdk.tools.util;

class arwz
  extends SSOAccountObserver
{
  arwz(arwy paramarwy) {}
  
  public void onFailed(String paramString, int paramInt1, int paramInt2, Bundle paramBundle)
  {
    if (this.a.jdField_a_of_type_Arwy$a != null) {
      this.a.jdField_a_of_type_Arwy$a.elT();
    }
  }
  
  public void onGetA1WithA1(String paramString, int paramInt1, byte[] paramArrayOfByte, int paramInt2, Bundle paramBundle)
  {
    if (paramInt1 == 0)
    {
      paramBundle = new WloginSimpleInfo();
      if (this.a.jdField_a_of_type_MqqManagerWtloginManager != null) {
        this.a.jdField_a_of_type_MqqManagerWtloginManager.GetBasicUserInfo(paramString, paramBundle);
      }
      paramString = "" + paramBundle._uin;
      if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0))
      {
        util.LOGD("outA1 buff: " + util.buf_to_string(paramArrayOfByte));
        paramArrayOfByte = new RSACrypt(aroi.a().getContext()).EncryptData(this.a.get_cp_pubkey(aroi.a().getContext(), this.a.awH, 1L), paramArrayOfByte);
        util.LOGD("encrypt buff:" + util.buf_to_string(paramArrayOfByte));
        if (this.a.jdField_a_of_type_Arwy$a != null) {
          this.a.jdField_a_of_type_Arwy$a.G(paramString, paramArrayOfByte);
        }
      }
    }
    while (this.a.jdField_a_of_type_Arwy$a == null) {
      return;
    }
    this.a.jdField_a_of_type_Arwy$a.elT();
  }
  
  public void onUserCancel(String paramString, int paramInt, Bundle paramBundle)
  {
    if (this.a.jdField_a_of_type_Arwy$a != null) {
      this.a.jdField_a_of_type_Arwy$a.elT();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arwz
 * JD-Core Version:    0.7.0.1
 */