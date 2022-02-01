import android.util.Base64;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tim.filemanager.util.FileManagerReporter.1;
import java.security.Key;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Random;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.json.JSONObject;

public class audw
{
  public static void JH(String paramString)
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject != null) && ((localObject instanceof QQAppInterface))) {}
    for (localObject = (QQAppInterface)localObject;; localObject = null)
    {
      if (localObject == null) {
        return;
      }
      audw.b localb = new audw.b();
      localb.bJE = paramString;
      localb.bJD = paramString;
      if (localb.cew) {}
      for (int i = 0;; i = 1)
      {
        anot.b((QQAppInterface)localObject, "CliOper", "", "", localb.bJD, localb.bJE, localb.cYX, localb.cYY, i, String.valueOf(localb.uTime), localb.bJH, audw.b.a(localb), localb.bJF);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("FileManagerReporter<FileAssistant>", 2, "report key:" + paramString);
        return;
      }
    }
  }
  
  public static void a(audw.a parama)
  {
    if (!QLog.isColorLevel()) {
      return;
    }
    ThreadManager.executeOnNetWorkThread(new FileManagerReporter.1(parama));
  }
  
  public static void a(String paramString, audw.b paramb)
  {
    BaseApplicationImpl.getContext();
    paramString = BaseApplicationImpl.getApplication().getRuntime();
    if ((paramString != null) && ((paramString instanceof QQAppInterface))) {}
    for (paramString = (QQAppInterface)paramString;; paramString = null)
    {
      if (paramb.cew) {}
      for (int i = 0;; i = 1)
      {
        anot.b(paramString, "CliOper", "", "", paramb.bJD, paramb.bJE, paramb.cYX, paramb.cYY, i, String.valueOf(paramb.uTime), paramb.bJH, audw.b.a(paramb), paramb.bJF);
        return;
      }
    }
  }
  
  public static JSONObject u(JSONObject paramJSONObject)
    throws Exception
  {
    int i = 0;
    paramJSONObject = paramJSONObject.toString().getBytes("UTF-8");
    try
    {
      Object localObject1 = new StringBuffer();
      Object localObject2 = new Random();
      while (i < 16)
      {
        ((StringBuffer)localObject1).append("0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".charAt(((Random)localObject2).nextInt("0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".length())));
        i += 1;
      }
      localObject1 = ((StringBuffer)localObject1).toString();
      Object localObject3 = new SecretKeySpec(MessageDigest.getInstance("MD5").digest(((String)localObject1).getBytes("UTF-8")), "AES/CBC/PKCS5Padding");
      localObject2 = Cipher.getInstance("AES/CBC/PKCS5Padding");
      ((Cipher)localObject2).init(1, (Key)localObject3, new IvParameterSpec("2017121316360000".getBytes()));
      localObject3 = new byte[((Cipher)localObject2).getOutputSize(paramJSONObject.length)];
      i = ((Cipher)localObject2).update(paramJSONObject, 0, paramJSONObject.length, (byte[])localObject3, 0);
      ((Cipher)localObject2).doFinal((byte[])localObject3, i);
      paramJSONObject = Base64.encodeToString((byte[])localObject3, 0);
      localObject1 = ((String)localObject1).getBytes("UTF-8");
      localObject3 = Base64.decode("MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBAKf7LdO3hhKCFZnyjsZPA4kiVHXR7sapvh4jEDJoUakc2qzXyhe3iDAdVFKMm9VUCmqIqXnuSqMbNG60lNVahnkCAwEAAQ==", 0);
      localObject2 = KeyFactory.getInstance("RSA");
      localObject3 = (RSAPublicKey)((KeyFactory)localObject2).generatePublic(new X509EncodedKeySpec((byte[])localObject3));
      ((KeyFactory)localObject2).getAlgorithm();
      localObject2 = Cipher.getInstance("RSA/ECB/PKCS1Padding");
      ((Cipher)localObject2).init(1, (Key)localObject3);
      localObject3 = new byte[((Cipher)localObject2).getOutputSize(localObject1.length)];
      i = ((Cipher)localObject2).update((byte[])localObject1, 0, localObject1.length, (byte[])localObject3, 0);
      ((Cipher)localObject2).doFinal((byte[])localObject3, i);
      localObject1 = Base64.encodeToString((byte[])localObject3, 0);
      localObject2 = new JSONObject();
      ((JSONObject)localObject2).put("key", localObject1);
      ((JSONObject)localObject2).put("value", paramJSONObject);
      return localObject2;
    }
    catch (Exception paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
    return null;
  }
  
  public static class a
  {
    public long LE;
    public String biz;
    public String filename;
    public HashMap<String, String> qi;
    public long sessionId;
    public String uin;
  }
  
  public static class b
  {
    public String bJD = "share_file";
    public String bJE;
    public String bJF;
    private String bJG;
    public String bJH;
    public int cYX = 0;
    public int cYY = 1;
    public boolean cew = true;
    public long nFileSize;
    public long uTime;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     audw
 * JD-Core Version:    0.7.0.1
 */