import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.recentfile.QfileBaseRecentFileTabView;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ThumbnailInfo;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class dls
  extends FMObserver
{
  public dls(QfileBaseRecentFileTabView paramQfileBaseRecentFileTabView) {}
  
  protected void a(long paramLong1, long paramLong2, String paramString, int paramInt)
  {
    FileManagerEntity localFileManagerEntity = QfileBaseRecentFileTabView.s(this.a).a().a(paramLong1, paramString, paramInt, paramLong2);
    if (localFileManagerEntity == null)
    {
      QLog.e(QfileBaseRecentFileTabView.a, 1, "OnFileCome,but query FileEntity null,uniseq[" + paramLong1 + "], nSessionId[" + paramLong2 + "], strUin[" + FileManagerUtil.e(paramString) + "], peerType[" + paramInt + "]");
      return;
    }
    this.a.b(localFileManagerEntity);
    QfileBaseRecentFileTabView.t(this.a).a().c(localFileManagerEntity);
    QfileBaseRecentFileTabView.c(this.a, new dlv(this));
  }
  
  protected void a(ThumbnailInfo paramThumbnailInfo)
  {
    if (paramThumbnailInfo == null) {
      return;
    }
    if ((paramThumbnailInfo.a instanceof FileManagerEntity))
    {
      FileManagerEntity localFileManagerEntity = (FileManagerEntity)paramThumbnailInfo.a;
      if ((paramThumbnailInfo.b != null) && (paramThumbnailInfo.b.length() > 0))
      {
        localFileManagerEntity.strThumbPath = paramThumbnailInfo.b;
        QfileBaseRecentFileTabView.o(this.a).a().c(localFileManagerEntity);
      }
    }
    this.a.i();
  }
  
  protected void a(Boolean paramBoolean, List paramList)
  {
    QfileBaseRecentFileTabView.a(this.a, paramBoolean, paramList);
  }
  
  protected void a(boolean paramBoolean, long paramLong1, long paramLong2, String paramString, int paramInt)
  {
    QfileBaseRecentFileTabView.a(this.a, new dlt(this));
  }
  
  protected void a(boolean paramBoolean, long paramLong1, long paramLong2, String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    FileManagerEntity localFileManagerEntity = QfileBaseRecentFileTabView.p(this.a).a().a(paramLong1, paramString1, paramInt1, paramLong2);
    if (localFileManagerEntity == null)
    {
      QLog.e(QfileBaseRecentFileTabView.a, 1, "OnFileCome,but query FileEntity null,uniseq[" + paramLong1 + "], nSessionId[" + paramLong2 + "], strUin[" + FileManagerUtil.e(paramString1) + "], peerType[" + paramInt1 + "]");
      return;
    }
    if (!paramBoolean)
    {
      localFileManagerEntity.bDelInFM = false;
      FileManagerUtil.a(paramLong2, paramInt2, paramString2);
    }
    this.a.b(localFileManagerEntity);
    QfileBaseRecentFileTabView.q(this.a).a().c(localFileManagerEntity);
    QfileBaseRecentFileTabView.b(this.a, new dlu(this, paramLong2));
  }
  
  protected void d()
  {
    super.d();
    QfileBaseRecentFileTabView.d(this.a, new dlw(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     dls
 * JD-Core Version:    0.7.0.1
 */