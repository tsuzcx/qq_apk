import android.text.TextUtils;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;

class atzh
  extends atgd
{
  atzh(atzf paramatzf) {}
  
  public void a(boolean paramBoolean1, FileManagerEntity paramFileManagerEntity, boolean paramBoolean2, int paramInt, String paramString)
  {
    if ((paramFileManagerEntity != null) && (paramFileManagerEntity.nSessionId == this.a.V()) && (paramBoolean2))
    {
      if (QLog.isColorLevel()) {
        QLog.i("C2CFileModel", 2, "onCopyC2CFileToCloud failed.");
      }
      if (athu.v(paramInt, paramBoolean1)) {
        athu.b(this.a.mAppInterface, this.a.mContext, 1);
      }
    }
  }
  
  public void a(boolean paramBoolean, byte[] paramArrayOfByte, long paramLong, FileManagerEntity paramFileManagerEntity, int paramInt, String paramString)
  {
    if ((!TextUtils.isEmpty(paramFileManagerEntity.getFilePath())) && (!TextUtils.isEmpty(this.a.getFilePath())) && (paramFileManagerEntity.getFilePath().equals(this.a.getFilePath())))
    {
      if (QLog.isColorLevel()) {
        QLog.i("C2CFileModel", 2, "onCreateFile failed.");
      }
      if (athu.v(paramInt, paramBoolean)) {
        athu.b(this.a.mAppInterface, this.a.mContext, 1);
      }
    }
  }
  
  public void a(boolean paramBoolean, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, int paramInt1, int paramInt2, String paramString)
  {
    paramArrayOfByte1 = this.a.c.b();
    if ((paramArrayOfByte1 != null) && (Arrays.equals(paramArrayOfByte1.cloudId, paramArrayOfByte2)))
    {
      if (QLog.isColorLevel()) {
        QLog.i("C2CFileModel", 2, "onCopyFile failed.");
      }
      if (athu.v(paramInt2, paramBoolean)) {
        athu.b(this.a.mAppInterface, this.a.mContext, 1);
      }
    }
  }
  
  public void c(boolean paramBoolean1, FileManagerEntity paramFileManagerEntity, boolean paramBoolean2, int paramInt, String paramString)
  {
    if ((paramFileManagerEntity != null) && (paramFileManagerEntity.nSessionId == this.a.V()) && (paramBoolean2))
    {
      if (QLog.isColorLevel()) {
        QLog.i("C2CFileModel", 2, "onCopyDiscFileToCloud failed.");
      }
      if (athu.v(paramInt, paramBoolean1)) {
        athu.b(this.a.mAppInterface, this.a.mContext, 1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atzh
 * JD-Core Version:    0.7.0.1
 */