import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class uac
  extends jnm.d
{
  uac(uaa paramuaa, uag.a parama, JSONObject paramJSONObject, tzd paramtzd) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.i(uaa.TAG, 2, "onResult appid=" + uaa.b(this.jdField_a_of_type_Uaa).mAppid + ", openid=" + this.jdField_a_of_type_Uag$a.openid + ", openkey=" + this.jdField_a_of_type_Uag$a.openKey + ", code=" + paramInt + ", req param=" + this.aQ);
    }
    if ((paramInt != 0) || (paramArrayOfByte == null))
    {
      ubu.a(this.b, paramInt, "reportScore result error, try again");
      return;
    }
    ubu.a(this.b, tzf.EMPTY);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     uac
 * JD-Core Version:    0.7.0.1
 */