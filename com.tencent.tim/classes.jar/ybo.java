import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;

class ybo
  extends aghq
{
  ybo(ybl paramybl) {}
  
  protected void a(agnk paramagnk)
  {
    if (paramagnk == null) {}
    do
    {
      FileManagerEntity localFileManagerEntity;
      do
      {
        do
        {
          return;
        } while (!(paramagnk.context instanceof FileManagerEntity));
        localFileManagerEntity = (FileManagerEntity)paramagnk.context;
      } while ((paramagnk.filePath == null) || (paramagnk.filePath.length() <= 0));
      localFileManagerEntity.strThumbPath = paramagnk.filePath;
      this.this$0.app.a().u(localFileManagerEntity);
    } while (ybl.a(this.this$0) == null);
    ybl.a(this.this$0).notifyDataSetChanged();
  }
  
  protected void a(boolean paramBoolean, long paramLong1, long paramLong2, String paramString, int paramInt)
  {
    if (ybl.a(this.this$0) != null) {
      ybl.a(this.this$0).notifyDataSetChanged();
    }
  }
  
  protected void a(boolean paramBoolean, long paramLong1, long paramLong2, String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiForwardActivity", 2, "OnFileTransferEnd : isSuccess[" + paramBoolean + "], uniseq[" + paramLong1 + "], nSessionId[" + paramLong2 + paramString1 + "], peerType[" + paramInt1 + "]");
    }
    if (ybl.a(this.this$0) != null) {
      ybl.a(this.this$0).notifyDataSetChanged();
    }
  }
  
  protected void c(long paramLong1, long paramLong2, String paramString, int paramInt)
  {
    if (ybl.a(this.this$0) != null) {
      ybl.a(this.this$0).notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     ybo
 * JD-Core Version:    0.7.0.1
 */