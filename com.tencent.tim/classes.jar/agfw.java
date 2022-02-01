import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.localfile.QfileBaseLocalFileTabView;
import com.tencent.mobileqq.filemanager.activity.localfile.QfileBaseLocalFileTabView.7.1;
import com.tencent.mobileqq.filemanager.activity.localfile.QfileBaseLocalFileTabView.7.2;
import com.tencent.mobileqq.filemanager.activity.localfile.QfileBaseLocalFileTabView.7.3;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;

public class agfw
  extends aghq
{
  public agfw(QfileBaseLocalFileTabView paramQfileBaseLocalFileTabView) {}
  
  protected void a(agnk paramagnk)
  {
    if (paramagnk == null) {}
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
    QfileBaseLocalFileTabView.c(this.this$0).a().u(localFileManagerEntity);
    this.this$0.refreshUI();
  }
  
  protected void a(boolean paramBoolean, long paramLong1, long paramLong2, String paramString, int paramInt)
  {
    QfileBaseLocalFileTabView.a(this.this$0, new QfileBaseLocalFileTabView.7.1(this));
  }
  
  protected void a(boolean paramBoolean, long paramLong1, long paramLong2, String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    QfileBaseLocalFileTabView.b(this.this$0, new QfileBaseLocalFileTabView.7.2(this, paramLong2, paramBoolean, paramInt2, paramString2));
  }
  
  protected void b(long paramLong, String paramString1, int paramInt, String paramString2)
  {
    super.b(paramLong, paramString1, paramInt, paramString2);
    ahav.jQ(paramLong);
  }
  
  protected void bJj()
  {
    super.bJj();
    QfileBaseLocalFileTabView.c(this.this$0, new QfileBaseLocalFileTabView.7.3(this));
  }
  
  protected void e(int paramInt, long paramLong, String paramString)
  {
    super.e(paramInt, paramLong, paramString);
    ahav.n(paramLong, paramInt, paramString);
    awrl.u(this.this$0.a, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agfw
 * JD-Core Version:    0.7.0.1
 */