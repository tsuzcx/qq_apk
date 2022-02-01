import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.commonsdk.util.HexUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class agqa
{
  private byte[] dT;
  private byte[] dU;
  private byte[] ee;
  private byte[] ef;
  private final String mFileName;
  private final String mFilePath;
  private final long mFileSize;
  
  public agqa(String paramString1, String paramString2, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4)
  {
    this.mFilePath = paramString1;
    if (!TextUtils.isEmpty(paramString2))
    {
      this.mFileName = paramString2;
      if (TextUtils.isEmpty(this.mFilePath)) {
        break label84;
      }
    }
    label84:
    for (this.mFileSize = new File(this.mFilePath).length();; this.mFileSize = 0L)
    {
      this.ee = paramArrayOfByte1;
      this.ef = paramArrayOfByte2;
      this.dU = paramArrayOfByte3;
      this.dT = paramArrayOfByte4;
      return;
      this.mFileName = ahav.getFileName(paramString1);
      break;
    }
  }
  
  public byte[] ac()
  {
    return this.ee;
  }
  
  public byte[] ad()
  {
    return this.ef;
  }
  
  public byte[] ae()
  {
    return this.dU;
  }
  
  public byte[] af()
  {
    return this.dT;
  }
  
  public void bh(byte[] paramArrayOfByte)
  {
    this.dT = paramArrayOfByte;
  }
  
  public long fZ()
  {
    return this.mFileSize;
  }
  
  public boolean isVaild()
  {
    if (this.mFilePath == null) {
      if (QLog.isColorLevel()) {
        QLog.e("ExcitingTransfer.FileInfo<FileAssistant>", 2, "mFilePath is null");
      }
    }
    do
    {
      return false;
      if (0L != this.mFileSize) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("ExcitingTransfer.FileInfo<FileAssistant>", 2, "mFileSize is 0");
    return false;
    return true;
  }
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("mFilePath:").append(this.mFilePath).append(" mFileName:").append(this.mFileName).append(" mFileSize:").append(this.mFileSize).append(" mBufSha3:");
    if (this.dU != null)
    {
      str = HexUtil.bytes2HexStr(this.dU);
      localStringBuilder = localStringBuilder.append(str).append(" mBufSha:");
      if (this.dT == null) {
        break label157;
      }
      str = HexUtil.bytes2HexStr(this.dT);
      label90:
      localStringBuilder = localStringBuilder.append(str).append(" mBuf10MMdd5:");
      if (this.ef == null) {
        break label163;
      }
      str = HexUtil.bytes2HexStr(this.ef);
      label116:
      localStringBuilder = localStringBuilder.append(str).append(" mBufMdd5:");
      if (this.ee == null) {
        break label169;
      }
    }
    label157:
    label163:
    label169:
    for (String str = HexUtil.bytes2HexStr(this.ee);; str = "")
    {
      return str;
      str = "";
      break;
      str = "";
      break label90;
      str = "";
      break label116;
    }
  }
  
  public String vA()
  {
    return this.mFilePath;
  }
  
  public String vB()
  {
    return this.mFileName;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agqa
 * JD-Core Version:    0.7.0.1
 */