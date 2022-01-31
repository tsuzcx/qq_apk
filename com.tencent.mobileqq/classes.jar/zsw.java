import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class zsw
  extends mmn
{
  zsw(zsu paramzsu, ztg paramztg, JSONObject paramJSONObject, zrt paramzrt) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.i(zsu.a, 2, "onResult appid=" + zsu.b(this.jdField_a_of_type_Zsu).a + ", openid=" + this.jdField_a_of_type_Ztg.a + ", openkey=" + this.jdField_a_of_type_Ztg.b + ", code=" + paramInt + ", req param=" + this.jdField_a_of_type_OrgJsonJSONObject);
    }
    if ((paramInt != 0) || (paramArrayOfByte == null))
    {
      zva.a(this.jdField_a_of_type_Zrt, paramInt, "reportScore result error, try again");
      return;
    }
    zva.a(this.jdField_a_of_type_Zrt, zrv.jdField_a_of_type_OrgJsonJSONObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     zsw
 * JD-Core Version:    0.7.0.1
 */