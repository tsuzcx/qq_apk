import com.music.voice.MusicWrapperJNI;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

public class axse
{
  public static final String cVT = aasa.SDCARD_ROOT + "/Tencent/qim/hum_recognition";
  public static final String cVU = cVT + File.separator + "svm_snr15_random_noise";
  public static final String cVV = cVT + File.separator + "audio_fingerprint.secret";
  public static final String cVW = cVT + File.separator + "audio_fingerprint.txt";
  private float Et;
  private MusicWrapperJNI a = new MusicWrapperJNI();
  private boolean dws;
  private int eGR;
  private int eGS;
  private byte[] ia;
  
  private String Id()
    throws UnsupportedEncodingException, NoSuchAlgorithmException
  {
    long l = System.currentTimeMillis();
    int i = Ru();
    String str1 = axrr.sK("musicopi_12345683" + "a45a1b" + l);
    String str2 = String.format("%.3f,%d", new Object[] { Float.valueOf(10.0F), Integer.valueOf(this.eGS) });
    float f = this.Et;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("v=").append(i).append("&source=").append("musicopi_12345683").append("&time=").append(l).append("&veri_str=").append(str1).append("&cmd=").append("1").append("&info=").append(str2).append("&type=").append("0").append("&session_id=").append(l).append("feature_type=").append(this.eGR).append("&confidence=").append(f * 100.0F).append("");
    return localStringBuilder.toString();
  }
  
  private int Ru()
  {
    int[] arrayOfInt = new int[1];
    this.a.QAFPGetVersion(arrayOfInt);
    return arrayOfInt[0];
  }
  
  private byte[] S(byte[] paramArrayOfByte)
  {
    int i = paramArrayOfByte.length;
    if (i == 0) {
      if (QLog.isColorLevel()) {
        QLog.i("AcousticFingerprint", 2, "generateBytes: invoked. info: audioBytes.length = " + i);
      }
    }
    boolean bool;
    do
    {
      return null;
      if (aPF()) {
        break;
      }
      bool = axrr.aPE();
      if (bool) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i("AcousticFingerprint", 2, "generateBytes: invoked. info: Failed to copy classifier. OK = " + bool);
    return null;
    if (!this.dws) {
      this.dws = aPG();
    }
    int j = this.a.Reset();
    if (((j == -4) || (j == -5)) && (QLog.isColorLevel())) {
      QLog.i("AcousticFingerprint", 2, "generateBytes: invoked. info: resetResult = " + j);
    }
    i = this.a.Process(paramArrayOfByte, i);
    if (((i == -4) || (i == -6)) && (QLog.isColorLevel())) {
      QLog.i("AcousticFingerprint", 2, "generateBytes: invoked. info: processResult = " + i);
    }
    eOA();
    return this.ia;
  }
  
  private byte[] T(byte[] paramArrayOfByte)
    throws UnsupportedEncodingException, NoSuchAlgorithmException
  {
    paramArrayOfByte = S(paramArrayOfByte);
    if (paramArrayOfByte == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("AcousticFingerprint", 2, "body: invoked. info: fingerprintBytes = " + paramArrayOfByte);
      }
      return null;
    }
    Object localObject = Id();
    if (QLog.isColorLevel()) {
      QLog.i("AcousticFingerprint", 2, "body: invoked. info: header = " + (String)localObject);
    }
    localObject = ((String)localObject).getBytes(Charset.forName("UTF-8"));
    byte[] arrayOfByte = new byte[localObject.length + paramArrayOfByte.length];
    System.arraycopy(localObject, 0, arrayOfByte, 0, localObject.length);
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, localObject.length, paramArrayOfByte.length);
    return arrayOfByte;
  }
  
  private byte[] U(byte[] paramArrayOfByte)
    throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException
  {
    SecretKeySpec localSecretKeySpec = new SecretKeySpec("spr_8a2cdeab7b81".getBytes(), "AES");
    Cipher localCipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
    localCipher.init(1, localSecretKeySpec);
    return localCipher.doFinal(paramArrayOfByte);
  }
  
  private boolean aPF()
  {
    File localFile = new File(cVU);
    if (!localFile.exists())
    {
      if (QLog.isColorLevel()) {
        QLog.i("AcousticFingerprint", 2, "isClassifierFileExists: invoked. info: not exist. classifierFile = " + localFile);
      }
      return false;
    }
    return true;
  }
  
  private boolean aPG()
  {
    int i = this.a.Init(cVU);
    if (i == 0) {
      return true;
    }
    if (((i == -1) || (i == -2)) && (QLog.isColorLevel())) {
      QLog.i("AcousticFingerprint", 2, "initWrapperJni: invoked. info: initResult = " + i);
    }
    return false;
  }
  
  private void eOA()
  {
    Object localObject = new int[1];
    float[] arrayOfFloat = new float[1];
    byte[] arrayOfByte = new byte[10240];
    int[] arrayOfInt = new int[1];
    this.a.GetFeature(10000.0F, (int[])localObject, arrayOfFloat, arrayOfByte, arrayOfInt);
    this.eGR = (localObject[0] + 1);
    this.Et = arrayOfFloat[0];
    this.eGS = arrayOfInt[0];
    this.ia = Arrays.copyOfRange(arrayOfByte, 0, this.eGS);
    if (QLog.isColorLevel())
    {
      localObject = String.format("feature_type=%s prob=%s outputLength=%d", new Object[] { Integer.valueOf(localObject[0]), Float.valueOf(arrayOfFloat[0]), Integer.valueOf(arrayOfInt[0]) });
      QLog.i("AcousticFingerprint", 2, "getFeatureJni: invoked. info: fingerprintFeature = " + (String)localObject);
    }
  }
  
  public byte[] V(byte[] paramArrayOfByte)
    throws UnsupportedEncodingException, NoSuchAlgorithmException, IllegalBlockSizeException, InvalidKeyException, BadPaddingException, NoSuchPaddingException
  {
    paramArrayOfByte = T(paramArrayOfByte);
    if (paramArrayOfByte == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("AcousticFingerprint", 2, "bytes: invoked. info: Failed to generate fingerprint body. body = " + paramArrayOfByte);
      }
      return null;
    }
    return U(paramArrayOfByte);
  }
  
  public axse a(float paramFloat)
  {
    if (QLog.isColorLevel()) {
      QLog.i("AcousticFingerprint", 2, "setTimeThreshold: invoked. info: timeMs = " + paramFloat);
    }
    if (paramFloat < 0.0F) {}
    int i;
    do
    {
      return this;
      i = this.a.SetTimeThreashold(paramFloat);
    } while ((i == 0) || (!QLog.isColorLevel()));
    QLog.i("AcousticFingerprint", 2, "setTimeThreasholdJni: invoked. info: Failed. retVal = " + i);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     axse
 * JD-Core Version:    0.7.0.1
 */