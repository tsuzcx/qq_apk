import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.httputils.HttpCommunicator;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class attv
  implements aqoi, attz
{
  private atty a;
  private aqog b;
  private final int cWz;
  private final byte[] dL;
  private final QQAppInterface mApp;
  private final byte[] mCheckSum;
  private final long mFileSize;
  private final int mFileType;
  private boolean mIsStop;
  private final long mSessionId;
  
  private attv(QQAppInterface paramQQAppInterface, long paramLong1, int paramInt1, int paramInt2, String paramString1, String paramString2, long paramLong2)
  {
    this.mApp = paramQQAppInterface;
    this.mSessionId = paramLong1;
    this.cWz = paramInt1;
    this.mFileType = paramInt2;
    this.mCheckSum = HexUtil.hexStr2Bytes(paramString1);
    this.dL = HexUtil.hexStr2Bytes(paramString2);
    this.mFileSize = paramLong2;
  }
  
  public static attv a(QQAppInterface paramQQAppInterface, long paramLong1, int paramInt1, int paramInt2, String paramString1, String paramString2, long paramLong2)
  {
    if (paramString1 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FtnHttpUploader<FileAssistant>", 2, "getFtnHttpUploader strCheckSum is null");
      }
      return null;
    }
    if (paramString1.length() == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FtnHttpUploader<FileAssistant>", 2, "getFtnHttpUploader strCheckSum is empty");
      }
      return null;
    }
    if (paramString2 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FtnHttpUploader<FileAssistant>", 2, "getFtnHttpUploader strSHA is null");
      }
      return null;
    }
    if (paramString2.length() == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FtnHttpUploader<FileAssistant>", 2, "getFtnHttpUploader strSHA is empty");
      }
      return null;
    }
    return new attv(paramQQAppInterface, paramLong1, paramInt1, paramInt2, paramString1, paramString2, paramLong2);
  }
  
  private byte[] a(long paramLong, byte[] paramArrayOfByte)
  {
    int i = this.mCheckSum.length + 2 + 2 + this.dL.length + 20 + paramArrayOfByte.length;
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream(i + 16);
    DataOutputStream localDataOutputStream = new DataOutputStream(localByteArrayOutputStream);
    try
    {
      localDataOutputStream.writeInt(-1412589450);
      localDataOutputStream.writeInt(1007);
      localDataOutputStream.writeInt(0);
      localDataOutputStream.writeInt(i);
      localDataOutputStream.writeShort(this.mCheckSum.length);
      localDataOutputStream.write(this.mCheckSum);
      localDataOutputStream.writeShort(this.dL.length);
      localDataOutputStream.write(this.dL);
      localDataOutputStream.writeInt((int)(this.mFileSize & 0xFFFFFFFF));
      localDataOutputStream.writeInt((int)(paramLong & 0xFFFFFFFF));
      localDataOutputStream.writeInt(paramArrayOfByte.length);
      localDataOutputStream.writeInt((int)(this.mFileSize >> 32));
      localDataOutputStream.writeInt((int)(paramLong >> 32));
      localDataOutputStream.write(paramArrayOfByte, 0, paramArrayOfByte.length);
      paramArrayOfByte = localByteArrayOutputStream.toByteArray();
      label255:
      return paramArrayOfByte;
    }
    catch (IOException paramArrayOfByte)
    {
      paramArrayOfByte = paramArrayOfByte;
      paramArrayOfByte.printStackTrace();
      QLog.e("FtnHttpUploader<FileAssistant>", 1, "packageData exception:" + paramArrayOfByte.toString());
      try
      {
        localByteArrayOutputStream.close();
        localDataOutputStream.close();
        return null;
      }
      catch (Exception paramArrayOfByte)
      {
        return null;
      }
    }
    finally
    {
      try
      {
        localByteArrayOutputStream.close();
        localDataOutputStream.close();
        throw paramArrayOfByte;
      }
      catch (Exception localException1)
      {
        break label255;
      }
    }
  }
  
  private void bc(byte[] paramArrayOfByte)
  {
    paramArrayOfByte = new ByteArrayInputStream(paramArrayOfByte);
    DataInputStream localDataInputStream = new DataInputStream(paramArrayOfByte);
    try
    {
      localDataInputStream.skip(4L);
      if (localDataInputStream.readInt() != 0) {
        this.a.cs(9001, "httpServer retCode!=0");
      }
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        int i;
        long l1;
        long l2;
        localIOException.printStackTrace();
        QLog.e("FtnHttpUploader<FileAssistant>", 1, "unPackageData exception:" + localIOException.toString());
        this.a.cs(9001, "httpServer flag!=0 flag!=1");
        try
        {
          paramArrayOfByte.close();
          localDataInputStream.close();
          return;
        }
        catch (Exception paramArrayOfByte)
        {
          return;
        }
        this.a.cs(9001, "httpServer flag!=0 flag!=1");
      }
    }
    finally
    {
      try
      {
        paramArrayOfByte.close();
        localDataInputStream.close();
        throw localObject;
      }
      catch (Exception paramArrayOfByte)
      {
        break label232;
      }
    }
    try
    {
      paramArrayOfByte.close();
      localDataInputStream.close();
      return;
    }
    catch (Exception paramArrayOfByte) {}
    localDataInputStream.skip(8L);
    i = localDataInputStream.readByte();
    if (i == 0)
    {
      i = localDataInputStream.readInt();
      l1 = localDataInputStream.readInt();
      l2 = i;
      this.a.at(l1 << 32 | l2, null);
    }
    for (;;)
    {
      try
      {
        paramArrayOfByte.close();
        localDataInputStream.close();
        return;
      }
      catch (Exception paramArrayOfByte)
      {
        return;
      }
      if (i != 1) {
        break;
      }
      this.a.onSuccess();
    }
    label232:
  }
  
  public void Hp(String paramString)
  {
    if (this.mIsStop) {
      return;
    }
    this.a.IK(paramString);
  }
  
  public void a(aqog paramaqog1, aqog paramaqog2)
  {
    if (this.mIsStop) {
      if (QLog.isColorLevel()) {
        QLog.e("##########", 2, "nSessionID[" + String.valueOf(this.mSessionId) + "]已经结束,返回");
      }
    }
    do
    {
      return;
      if (paramaqog1 == this.b) {
        break;
      }
      if ((paramaqog1 != null) && (this.b != null))
      {
        QLog.e("FtnHttpUploader<FileAssistant>", 1, "id[" + String.valueOf(this.mSessionId) + "],Req Serial[" + String.valueOf(paramaqog1.Mk()) + "], curRequest Serial[" + String.valueOf(this.b.Mk()) + "]");
        return;
      }
      if (paramaqog1 != null)
      {
        QLog.e("FtnHttpUploader<FileAssistant>", 1, "id[" + String.valueOf(this.mSessionId) + "],Req Serial[" + String.valueOf(paramaqog1.Mk()) + "]");
        return;
      }
    } while (this.b == null);
    QLog.e("FtnHttpUploader<FileAssistant>", 1, "id[" + String.valueOf(this.mSessionId) + "],curRequest Serial[" + String.valueOf(this.b.Mk()) + "]");
    return;
    if (paramaqog2.getResponseCode() == 200) {
      if (paramaqog2.pK("User-ReturnCode") == null) {
        break label374;
      }
    }
    label374:
    for (long l = Long.parseLong(paramaqog2.pK("User-ReturnCode"));; l = 0L)
    {
      if (0L != l)
      {
        this.a.M(paramaqog2.errCode, paramaqog2.getErrorString(), paramaqog2.cuw);
        return;
      }
      bc(paramaqog2.aB());
      return;
      QLog.e("FtnHttpUploader<FileAssistant>", 1, "id[" + String.valueOf(this.mSessionId) + "],decode but response Code [" + paramaqog2.getResponseCode() + "] is not 200");
      return;
    }
  }
  
  public void a(atty paramatty)
  {
    this.a = paramatty;
  }
  
  public boolean a(aqog paramaqog1, aqog paramaqog2, int paramInt)
  {
    return true;
  }
  
  public boolean a(String paramString, long paramLong, byte[] paramArrayOfByte)
  {
    paramArrayOfByte = a(paramLong, paramArrayOfByte);
    if (paramArrayOfByte == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FtnHttpUploader<FileAssistant>", 2, "sendData packageData return null");
      }
      return false;
    }
    this.b = new aqog(paramString, paramArrayOfByte, this);
    this.b.setInstanceFollowRedirects(false);
    this.b.setRequestProperty("cache-control", "no-cache");
    paramString = "gprs";
    if (aqiw.getNetworkType(BaseApplication.getContext()) == 1) {
      paramString = "wifi";
    }
    this.b.setRequestProperty("Net-type", paramString);
    this.b.setRequestMethod("POST");
    this.b.setPriority(1);
    this.b.fileType = this.mFileType;
    this.b.busiType = this.cWz;
    this.b.msgId = String.valueOf(this.mSessionId);
    this.mApp.getHttpCommunicatort().a(this.b);
    return true;
  }
  
  public void b(aqog paramaqog1, aqog paramaqog2)
  {
    if (this.mIsStop) {
      return;
    }
    this.a.M(paramaqog2.errCode, paramaqog2.getErrorString(), paramaqog2.cuw);
  }
  
  public void cancel()
  {
    this.mIsStop = true;
    if (this.b != null)
    {
      this.mApp.getHttpCommunicatort().f(this.b);
      this.b = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     attv
 * JD-Core Version:    0.7.0.1
 */