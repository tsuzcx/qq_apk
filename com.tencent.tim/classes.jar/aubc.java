import android.text.TextUtils;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;

class aubc
  extends atgd
{
  aubc(auau paramauau) {}
  
  public void a(boolean paramBoolean, MessageForTroopFile paramMessageForTroopFile, int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("TroopFileModel", 2, "onCopyGroupFileToCloud failed.");
    }
    if (athu.v(paramInt, paramBoolean)) {
      athu.b(this.this$0.mAppInterface, this.this$0.mContext, 1);
    }
  }
  
  public void a(boolean paramBoolean, byte[] paramArrayOfByte, long paramLong, FileManagerEntity paramFileManagerEntity, int paramInt, String paramString)
  {
    if ((!TextUtils.isEmpty(paramFileManagerEntity.getFilePath())) && (!TextUtils.isEmpty(this.this$0.getFilePath())) && (paramFileManagerEntity.getFilePath().equals(this.this$0.getFilePath())))
    {
      if (QLog.isColorLevel()) {
        QLog.i("TroopFileModel", 2, "onCreateFile failed.");
      }
      if (athu.v(paramInt, paramBoolean)) {
        athu.b(this.this$0.mAppInterface, this.this$0.mContext, 1);
      }
    }
  }
  
  public void a(boolean paramBoolean, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, int paramInt1, int paramInt2, String paramString)
  {
    paramArrayOfByte1 = this.this$0.c.b();
    if ((paramArrayOfByte1 != null) && (Arrays.equals(paramArrayOfByte1.cloudId, paramArrayOfByte2)))
    {
      if (QLog.isColorLevel()) {
        QLog.i("TroopFileModel", 2, "onCopyFile failed.");
      }
      if (athu.v(paramInt2, paramBoolean)) {
        athu.b(this.this$0.mAppInterface, this.this$0.mContext, 1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aubc
 * JD-Core Version:    0.7.0.1
 */