import com.tencent.qphone.base.util.QLog;

class ajef
  extends ajdu
{
  ajef(ajee paramajee) {}
  
  public void bn(boolean paramBoolean, Object paramObject)
  {
    super.bn(paramBoolean, paramObject);
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup.BackupAndMigrateManager", 2, "onGetQrResponse: " + paramObject + ", isSuccess: " + paramBoolean);
    }
    if ((paramBoolean) && ((paramObject instanceof ajer))) {
      ajee.a(this.this$0, (ajer)paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajef
 * JD-Core Version:    0.7.0.1
 */