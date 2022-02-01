import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.recentfile.QfileBaseRecentFileTabView;
import com.tencent.mobileqq.filemanager.activity.recentfile.QfileBaseRecentFileTabView.10.1;
import com.tencent.mobileqq.filemanager.activity.recentfile.QfileBaseRecentFileTabView.10.2;
import com.tencent.mobileqq.filemanager.activity.recentfile.QfileBaseRecentFileTabView.10.3;
import com.tencent.mobileqq.filemanager.activity.recentfile.QfileBaseRecentFileTabView.10.4;
import com.tencent.mobileqq.filemanager.activity.recentfile.QfileBaseRecentFileTabView.10.5;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.OfflineFileInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class aggg
  extends aghq
{
  public aggg(QfileBaseRecentFileTabView paramQfileBaseRecentFileTabView) {}
  
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
    QfileBaseRecentFileTabView.C(this.this$0).a().u(localFileManagerEntity);
    this.this$0.refreshUI();
  }
  
  protected void a(Integer paramInteger, long paramLong, String paramString)
  {
    QfileBaseRecentFileTabView.e(this.this$0, new QfileBaseRecentFileTabView.10.4(this));
    ahav.n(paramLong, paramInteger.intValue(), paramString);
    awrl.u(this.this$0.a, paramInteger.intValue());
  }
  
  protected void a(boolean paramBoolean, long paramLong1, long paramLong2, String paramString, int paramInt)
  {
    QfileBaseRecentFileTabView.b(this.this$0, new QfileBaseRecentFileTabView.10.1(this));
  }
  
  protected void a(boolean paramBoolean, long paramLong1, long paramLong2, String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    FileManagerEntity localFileManagerEntity = QfileBaseRecentFileTabView.D(this.this$0).a().a(paramLong1, paramString1, paramInt1, paramLong2);
    if (localFileManagerEntity == null)
    {
      QLog.e(QfileBaseRecentFileTabView.TAG, 1, "OnFileCome,but query FileEntity null,uniseq[" + paramLong1 + "], nSessionId[" + paramLong2 + "], strUin[" + ahav.kZ(paramString1) + "], peerType[" + paramInt1 + "]");
      return;
    }
    if (!paramBoolean)
    {
      localFileManagerEntity.bDelInFM = false;
      ahav.n(paramLong2, paramInt2, paramString2);
      awrl.u(this.this$0.a, paramInt2);
    }
    for (;;)
    {
      if ((this.this$0.mUin == null) || (this.this$0.mUin.trim().length() == 0) || (localFileManagerEntity.getCloudType() != 2)) {
        this.this$0.g(localFileManagerEntity);
      }
      QfileBaseRecentFileTabView.E(this.this$0).a().u(localFileManagerEntity);
      QfileBaseRecentFileTabView.c(this.this$0, new QfileBaseRecentFileTabView.10.2(this, paramLong2));
      return;
      paramInt1 = localFileManagerEntity.nOpType;
      if ((paramInt1 == 4) || (paramInt1 == 20) || (paramInt1 == 6)) {
        ahav.jQ(paramLong2);
      }
    }
  }
  
  protected void b(long paramLong1, long paramLong2, String paramString, int paramInt)
  {
    FileManagerEntity localFileManagerEntity = QfileBaseRecentFileTabView.G(this.this$0).a().a(paramLong1, paramString, paramInt, paramLong2);
    if (localFileManagerEntity == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e(QfileBaseRecentFileTabView.TAG, 2, "OnFileCome,but query FileEntity null,uniseq[" + paramLong1 + "], nSessionId[" + paramLong2 + "], strUin[" + ahav.kZ(paramString) + "], peerType[" + paramInt + "]");
      }
      return;
    }
    this.this$0.g(localFileManagerEntity);
    QfileBaseRecentFileTabView.H(this.this$0).a().u(localFileManagerEntity);
    QfileBaseRecentFileTabView.d(this.this$0, new QfileBaseRecentFileTabView.10.3(this));
  }
  
  protected void b(long paramLong, String paramString1, int paramInt, String paramString2)
  {
    super.b(paramLong, paramString1, paramInt, paramString2);
    ahav.jQ(paramLong);
    this.this$0.refreshUI();
  }
  
  protected void b(Boolean paramBoolean, List<OfflineFileInfo> paramList)
  {
    QfileBaseRecentFileTabView.a(this.this$0, paramBoolean, paramList);
  }
  
  protected void bJj()
  {
    super.bJj();
    QfileBaseRecentFileTabView.f(this.this$0, new QfileBaseRecentFileTabView.10.5(this));
  }
  
  protected void e(int paramInt, long paramLong, String paramString)
  {
    super.e(paramInt, paramLong, paramString);
    ahav.n(paramLong, paramInt, paramString);
    awrl.u(this.this$0.a, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aggg
 * JD-Core Version:    0.7.0.1
 */