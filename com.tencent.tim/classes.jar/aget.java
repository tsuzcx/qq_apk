import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.cloudfile.QfileCloudFileTabView;
import com.tencent.mobileqq.filemanager.data.WeiYunFileInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class aget
  extends aghq
{
  public aget(QfileCloudFileTabView paramQfileCloudFileTabView) {}
  
  protected void L(int paramInt, String paramString1, String paramString2)
  {
    super.L(paramInt, paramString1, paramString2);
    this.this$0.IU(false);
  }
  
  protected void a(Integer paramInteger, long paramLong, String paramString)
  {
    ahav.n(paramLong, paramInteger.intValue(), paramString);
  }
  
  protected void a(String paramString1, boolean paramBoolean, int paramInt1, String paramString2, List<WeiYunFileInfo> paramList, int paramInt2)
  {
    QfileCloudFileTabView.b(this.this$0, true);
    QfileCloudFileTabView.c(this.this$0, paramBoolean);
    this.this$0.cWN = paramInt2;
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      WeiYunFileInfo localWeiYunFileInfo = (WeiYunFileInfo)localIterator.next();
      paramInt1 = ahav.getFileType(localWeiYunFileInfo.strFileName);
      String str;
      if (paramInt1 == 0)
      {
        str = QfileCloudFileTabView.a(this.this$0).a().a(localWeiYunFileInfo.bIk, localWeiYunFileInfo.encodeUrl, 3, localWeiYunFileInfo);
        if (str != null) {
          localWeiYunFileInfo.bIz = str;
        }
      }
      else if (2 == paramInt1)
      {
        str = QfileCloudFileTabView.b(this.this$0).a().b(localWeiYunFileInfo.bIk, localWeiYunFileInfo.encodeUrl, 2, localWeiYunFileInfo);
        if (str != null) {
          localWeiYunFileInfo.bIz = str;
        }
      }
    }
    if (!paramString1.equals(this.this$0.id)) {
      return;
    }
    if (QfileCloudFileTabView.b(this.this$0)) {
      this.this$0.wB.clear();
    }
    this.this$0.wB.addAll(paramList);
    if (!this.this$0.id.equalsIgnoreCase("picture")) {
      this.this$0.setListFooter();
    }
    this.this$0.bGR = paramString2;
    this.this$0.cdd = true;
    this.this$0.dfG();
    this.this$0.dfD();
  }
  
  protected void a(boolean paramBoolean, long paramLong1, long paramLong2, String paramString, int paramInt)
  {
    this.this$0.b.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aget
 * JD-Core Version:    0.7.0.1
 */