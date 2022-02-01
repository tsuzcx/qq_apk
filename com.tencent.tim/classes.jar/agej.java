import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.activity.cloudfile.QfileBaseCloudFileTabView;
import com.tencent.mobileqq.filemanager.activity.cloudfile.QfileBaseCloudFileTabView.13.1;
import com.tencent.mobileqq.filemanager.activity.cloudfile.QfileBaseCloudFileTabView.13.2;
import com.tencent.mobileqq.filemanager.activity.cloudfile.QfileBaseCloudFileTabView.13.3;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.WeiYunFileInfo;
import java.util.ArrayList;
import java.util.Iterator;

public class agej
  extends aghq
{
  public agej(QfileBaseCloudFileTabView paramQfileBaseCloudFileTabView) {}
  
  protected void K(String paramString1, String paramString2, boolean paramBoolean)
  {
    paramString2 = agmz.a(paramString1);
    if ((!this.this$0.b(paramString2)) && (this.this$0.wB != null) && (this.this$0.wB.size() > 0))
    {
      paramString2 = this.this$0.wB.iterator();
      while (paramString2.hasNext())
      {
        WeiYunFileInfo localWeiYunFileInfo = (WeiYunFileInfo)paramString2.next();
        if (localWeiYunFileInfo.bIk.equalsIgnoreCase(paramString1) == true) {
          this.this$0.b(localWeiYunFileInfo);
        }
      }
    }
    this.this$0.a.IL(false);
  }
  
  protected void a(agnk paramagnk)
  {
    if (paramagnk == null) {}
    do
    {
      FileManagerEntity localFileManagerEntity;
      do
      {
        return;
        if (!(paramagnk.context instanceof FileManagerEntity)) {
          break;
        }
        localFileManagerEntity = (FileManagerEntity)paramagnk.context;
      } while ((paramagnk.filePath == null) || (paramagnk.filePath.length() <= 0));
      localFileManagerEntity.strThumbPath = paramagnk.filePath;
      QfileBaseCloudFileTabView.k(this.this$0).a().u(localFileManagerEntity);
      this.this$0.refreshUI();
      return;
    } while (!(paramagnk.context instanceof WeiYunFileInfo));
    this.this$0.refreshUI();
  }
  
  protected void a(String paramString1, String paramString2, Integer paramInteger, String paramString3, boolean paramBoolean)
  {
    agmz.a(paramString1);
    ahav.B(paramInteger.intValue(), paramString2);
    this.this$0.a.IL(false);
  }
  
  protected void a(boolean paramBoolean, long paramLong1, long paramLong2, String paramString, int paramInt)
  {
    QfileBaseCloudFileTabView.a(this.this$0, new QfileBaseCloudFileTabView.13.1(this));
  }
  
  protected void a(boolean paramBoolean, long paramLong1, long paramLong2, String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    QfileBaseCloudFileTabView.b(this.this$0, new QfileBaseCloudFileTabView.13.2(this, paramLong2));
  }
  
  protected void bJj()
  {
    super.bJj();
    QfileBaseCloudFileTabView.c(this.this$0, new QfileBaseCloudFileTabView.13.3(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agej
 * JD-Core Version:    0.7.0.1
 */