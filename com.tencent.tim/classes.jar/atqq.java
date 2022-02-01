import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.WeiYunFileInfo;
import com.tencent.tim.filemanager.activity.cloudfile.QfileCloudFileTabView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class atqq
  extends atsn
{
  public atqq(QfileCloudFileTabView paramQfileCloudFileTabView) {}
  
  protected void L(int paramInt, String paramString1, String paramString2)
  {
    super.L(paramInt, paramString1, paramString2);
    this.this$0.IU(false);
  }
  
  protected void a(Integer paramInteger, long paramLong, String paramString)
  {
    audx.n(paramLong, paramInteger.intValue(), paramString);
  }
  
  protected void a(String paramString, boolean paramBoolean, int paramInt1, long paramLong, List<WeiYunFileInfo> paramList, int paramInt2)
  {
    QfileCloudFileTabView.b(this.this$0, true);
    QfileCloudFileTabView.c(this.this$0, paramBoolean);
    this.this$0.cWN = paramInt2;
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      WeiYunFileInfo localWeiYunFileInfo = (WeiYunFileInfo)localIterator.next();
      if (audx.fM(localWeiYunFileInfo.strFileName) == 0)
      {
        String str = QfileCloudFileTabView.a(this.this$0).a().a(localWeiYunFileInfo.bIk, localWeiYunFileInfo.strFileName, 4, localWeiYunFileInfo);
        if (str != null) {
          localWeiYunFileInfo.bIz = str;
        }
      }
    }
    if (!paramString.equals(this.this$0.id)) {
      return;
    }
    if (QfileCloudFileTabView.b(this.this$0)) {
      this.this$0.wB.clear();
    }
    this.this$0.wB.addAll(paramList);
    if (!this.this$0.id.equalsIgnoreCase("picture")) {
      this.this$0.setListFooter();
    }
    this.this$0.mTimestamp = paramLong;
    this.this$0.cdd = true;
    this.this$0.dfG();
    this.this$0.dfD();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atqq
 * JD-Core Version:    0.7.0.1
 */