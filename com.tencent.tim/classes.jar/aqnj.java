import android.os.Handler;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.json.JSONObject;

final class aqnj
  extends aquy
{
  aqnj(QQAppInterface paramQQAppInterface) {}
  
  public void onDone(aquz paramaquz)
  {
    super.onDone(paramaquz);
    paramaquz = new File(aqni.cum);
    if (paramaquz.exists())
    {
      paramaquz = aqhq.b(paramaquz, -1);
      if (!TextUtils.isEmpty(paramaquz)) {}
      try
      {
        paramaquz = Base64.decode(paramaquz, 0);
        SecretKeySpec localSecretKeySpec = new SecretKeySpec("xydata3456789012xydata3456789012".getBytes(), "AES");
        IvParameterSpec localIvParameterSpec = new IvParameterSpec("xydata3456789012".getBytes());
        Cipher localCipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
        localCipher.init(2, localSecretKeySpec, localIvParameterSpec);
        paramaquz = new JSONObject(new String(localCipher.doFinal(paramaquz)));
        if (QLog.isColorLevel()) {
          QLog.d("VasResourceCheckUtil", 2, "decode json success, content = " + paramaquz.toString());
        }
        aqni.eB(this.val$app);
        aqni.mUIHandler.sendMessage(aqni.mUIHandler.obtainMessage(257));
        return;
      }
      catch (Exception paramaquz)
      {
        QLog.e("VasResourceCheckUtil", 1, "decode json fail: " + paramaquz.getMessage());
        aqni.mUIHandler.sendMessage(aqni.mUIHandler.obtainMessage(259));
        return;
      }
    }
    aqni.mUIHandler.sendMessage(aqni.mUIHandler.obtainMessage(258));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqnj
 * JD-Core Version:    0.7.0.1
 */