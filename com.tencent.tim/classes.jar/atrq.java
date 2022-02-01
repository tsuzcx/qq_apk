import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.OfflineFileInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tim.filemanager.activity.recentfile.QfileBaseRecentFileTabView;
import com.tencent.tim.filemanager.activity.recentfile.QfileBaseRecentFileTabView.12.1;
import com.tencent.tim.filemanager.activity.recentfile.QfileBaseRecentFileTabView.12.2;
import com.tencent.tim.filemanager.activity.recentfile.QfileBaseRecentFileTabView.12.3;
import com.tencent.tim.filemanager.activity.recentfile.QfileBaseRecentFileTabView.12.4;
import com.tencent.tim.filemanager.activity.recentfile.QfileBaseRecentFileTabView.12.5;
import java.util.List;

public class atrq
  extends atsn
{
  public atrq(QfileBaseRecentFileTabView paramQfileBaseRecentFileTabView) {}
  
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
    QfileBaseRecentFileTabView.C(this.this$0).a().u(localFileManagerEntity);
    this.this$0.refreshUI();
  }
  
  protected void a(Integer paramInteger, long paramLong, String paramString)
  {
    QfileBaseRecentFileTabView.e(this.this$0, new QfileBaseRecentFileTabView.12.4(this));
    audx.n(paramLong, paramInteger.intValue(), paramString);
  }
  
  protected void a(boolean paramBoolean, long paramLong1, long paramLong2, String paramString, int paramInt)
  {
    QfileBaseRecentFileTabView.b(this.this$0, new QfileBaseRecentFileTabView.12.1(this));
  }
  
  protected void a(boolean paramBoolean, long paramLong1, long paramLong2, String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    FileManagerEntity localFileManagerEntity = QfileBaseRecentFileTabView.D(this.this$0).a().a(paramLong1, paramString1, paramInt1, paramLong2);
    if (localFileManagerEntity == null)
    {
      QLog.e("FMObserver<FileAssistant>", 1, "OnFileCome,but query FileEntity null,uniseq[" + paramLong1 + "], nSessionId[" + paramLong2 + "], strUin[" + audx.kZ(paramString1) + "], peerType[" + paramInt1 + "]");
      return;
    }
    if (!paramBoolean)
    {
      localFileManagerEntity.bDelInFM = false;
      audx.n(paramLong2, paramInt2, paramString2);
    }
    for (;;)
    {
      if ((this.this$0.mUin == null) || (this.this$0.mUin.trim().length() == 0) || (localFileManagerEntity.getCloudType() != 2)) {
        this.this$0.g(localFileManagerEntity);
      }
      QfileBaseRecentFileTabView.E(this.this$0).a().u(localFileManagerEntity);
      QfileBaseRecentFileTabView.c(this.this$0, new QfileBaseRecentFileTabView.12.2(this, paramLong2));
      return;
      paramInt1 = localFileManagerEntity.nOpType;
      if ((paramInt1 == 4) || (paramInt1 == 20) || (paramInt1 == 6)) {
        audx.jQ(paramLong2);
      }
    }
  }
  
  protected void b(long paramLong1, long paramLong2, String paramString, int paramInt)
  {
    FileManagerEntity localFileManagerEntity = QfileBaseRecentFileTabView.G(this.this$0).a().a(paramLong1, paramString, paramInt, paramLong2);
    if (localFileManagerEntity == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FMObserver<FileAssistant>", 2, "OnFileCome,but query FileEntity null,uniseq[" + paramLong1 + "], nSessionId[" + paramLong2 + "], strUin[" + audx.kZ(paramString) + "], peerType[" + paramInt + "]");
      }
      return;
    }
    this.this$0.g(localFileManagerEntity);
    QfileBaseRecentFileTabView.H(this.this$0).a().u(localFileManagerEntity);
    QfileBaseRecentFileTabView.d(this.this$0, new QfileBaseRecentFileTabView.12.3(this));
  }
  
  protected void b(long paramLong, String paramString1, int paramInt, String paramString2)
  {
    super.b(paramLong, paramString1, paramInt, paramString2);
    audx.jQ(paramLong);
    this.this$0.refreshUI();
  }
  
  protected void b(Boolean paramBoolean, List<OfflineFileInfo> paramList)
  {
    QfileBaseRecentFileTabView.a(this.this$0, paramBoolean, paramList);
  }
  
  protected void bJj()
  {
    super.bJj();
    QfileBaseRecentFileTabView.f(this.this$0, new QfileBaseRecentFileTabView.12.5(this));
  }
  
  protected void e(int paramInt, long paramLong, String paramString)
  {
    super.e(paramInt, paramLong, paramString);
    audx.n(paramLong, paramInt, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atrq
 * JD-Core Version:    0.7.0.1
 */