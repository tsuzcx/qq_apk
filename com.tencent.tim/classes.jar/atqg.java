import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.WeiYunFileInfo;
import com.tencent.tim.filemanager.activity.FMActivity;
import com.tencent.tim.filemanager.activity.cloudfile.QfileBaseCloudFileTabView;
import com.tencent.tim.filemanager.activity.cloudfile.QfileBaseCloudFileTabView.15.1;
import com.tencent.tim.filemanager.activity.cloudfile.QfileBaseCloudFileTabView.15.2;
import com.tencent.tim.filemanager.activity.cloudfile.QfileBaseCloudFileTabView.15.3;
import java.util.ArrayList;
import java.util.Iterator;

public class atqg
  extends atsn
{
  public atqg(QfileBaseCloudFileTabView paramQfileBaseCloudFileTabView) {}
  
  protected void K(String paramString1, String paramString2, boolean paramBoolean)
  {
    paramString2 = atwb.a(paramString1);
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
    this.this$0.b.IL(false);
  }
  
  protected void a(atwh paramatwh)
  {
    if (paramatwh == null) {}
    do
    {
      FileManagerEntity localFileManagerEntity;
      do
      {
        return;
        if (!(paramatwh.context instanceof FileManagerEntity)) {
          break;
        }
        localFileManagerEntity = (FileManagerEntity)paramatwh.context;
      } while ((paramatwh.filePath == null) || (paramatwh.filePath.length() <= 0));
      localFileManagerEntity.strThumbPath = paramatwh.filePath;
      QfileBaseCloudFileTabView.m(this.this$0).a().u(localFileManagerEntity);
      this.this$0.refreshUI();
      return;
    } while (!(paramatwh.context instanceof WeiYunFileInfo));
    this.this$0.refreshUI();
  }
  
  protected void a(String paramString1, String paramString2, Integer paramInteger, String paramString3, boolean paramBoolean)
  {
    atwb.a(paramString1);
    audx.B(paramInteger.intValue(), paramString2);
    this.this$0.b.IL(false);
  }
  
  protected void a(boolean paramBoolean, long paramLong1, long paramLong2, String paramString, int paramInt)
  {
    QfileBaseCloudFileTabView.a(this.this$0, new QfileBaseCloudFileTabView.15.1(this));
  }
  
  protected void a(boolean paramBoolean, long paramLong1, long paramLong2, String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    QfileBaseCloudFileTabView.b(this.this$0, new QfileBaseCloudFileTabView.15.2(this, paramLong2));
  }
  
  protected void bJj()
  {
    super.bJj();
    QfileBaseCloudFileTabView.c(this.this$0, new QfileBaseCloudFileTabView.15.3(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atqg
 * JD-Core Version:    0.7.0.1
 */