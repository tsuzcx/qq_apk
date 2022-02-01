import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.tim.filemanager.activity.localfile.QfileBaseLocalFileTabView;
import com.tencent.tim.filemanager.activity.localfile.QfileBaseLocalFileTabView.12.1;
import com.tencent.tim.filemanager.activity.localfile.QfileBaseLocalFileTabView.12.2;
import com.tencent.tim.filemanager.activity.localfile.QfileBaseLocalFileTabView.12.3;

public class atrc
  extends atsn
{
  public atrc(QfileBaseLocalFileTabView paramQfileBaseLocalFileTabView) {}
  
  protected void a(atwh paramatwh)
  {
    if (paramatwh == null) {}
    FileManagerEntity localFileManagerEntity;
    do
    {
      do
      {
        return;
      } while (!(paramatwh.context instanceof FileManagerEntity));
      localFileManagerEntity = (FileManagerEntity)paramatwh.context;
    } while ((paramatwh.filePath == null) || (paramatwh.filePath.length() <= 0));
    localFileManagerEntity.strThumbPath = paramatwh.filePath;
    QfileBaseLocalFileTabView.c(this.this$0).a().u(localFileManagerEntity);
    this.this$0.refreshUI();
  }
  
  protected void a(boolean paramBoolean, long paramLong1, long paramLong2, String paramString, int paramInt)
  {
    QfileBaseLocalFileTabView.a(this.this$0, new QfileBaseLocalFileTabView.12.1(this));
  }
  
  protected void a(boolean paramBoolean, long paramLong1, long paramLong2, String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    QfileBaseLocalFileTabView.b(this.this$0, new QfileBaseLocalFileTabView.12.2(this, paramLong2, paramBoolean, paramInt2, paramString2));
  }
  
  protected void b(long paramLong, String paramString1, int paramInt, String paramString2)
  {
    super.b(paramLong, paramString1, paramInt, paramString2);
    audx.jQ(paramLong);
  }
  
  protected void bJj()
  {
    super.bJj();
    QfileBaseLocalFileTabView.c(this.this$0, new QfileBaseLocalFileTabView.12.3(this));
  }
  
  protected void e(int paramInt, long paramLong, String paramString)
  {
    super.e(paramInt, paramLong, paramString);
    audx.n(paramLong, paramInt, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atrc
 * JD-Core Version:    0.7.0.1
 */