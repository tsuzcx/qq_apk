import com.tencent.mobileqq.filemanager.data.WeiYunFileInfo;
import com.tencent.tim.filemanager.activity.cloudfile.QfileCloudFileTabView;
import com.tencent.tim.filemanager.widget.QfilePinnedHeaderExpandableListView.a;

public class atqr
  implements QfilePinnedHeaderExpandableListView.a
{
  private boolean mIsSelected;
  private int mMaxIndex;
  private int mMinIndex;
  
  public atqr(QfileCloudFileTabView paramQfileCloudFileTabView) {}
  
  public void IV(boolean paramBoolean) {}
  
  public void Q(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramInt1 != paramInt3) {
      return;
    }
    paramInt3 = Math.min(paramInt2, paramInt4);
    int i = Math.max(paramInt2, paramInt4);
    if (paramInt4 < paramInt2) {
      this.mMinIndex = Math.min(paramInt4, this.mMinIndex);
    }
    for (;;)
    {
      paramInt2 = paramInt3;
      while (paramInt2 <= i)
      {
        QfileCloudFileTabView.a(this.this$0, (WeiYunFileInfo)this.this$0.a.getChild(paramInt1, paramInt2), this.mIsSelected);
        paramInt2 += 1;
      }
      this.mMaxIndex = Math.max(paramInt4, this.mMaxIndex);
    }
    paramInt2 = this.mMinIndex;
    QfileCloudFileTabView localQfileCloudFileTabView;
    WeiYunFileInfo localWeiYunFileInfo;
    boolean bool;
    if (paramInt2 < paramInt3)
    {
      localQfileCloudFileTabView = this.this$0;
      localWeiYunFileInfo = (WeiYunFileInfo)this.this$0.a.getChild(paramInt1, paramInt2);
      if (!this.mIsSelected) {}
      for (bool = true;; bool = false)
      {
        QfileCloudFileTabView.a(localQfileCloudFileTabView, localWeiYunFileInfo, bool);
        paramInt2 += 1;
        break;
      }
    }
    paramInt2 = i + 1;
    if (paramInt2 <= this.mMaxIndex)
    {
      localQfileCloudFileTabView = this.this$0;
      localWeiYunFileInfo = (WeiYunFileInfo)this.this$0.a.getChild(paramInt1, paramInt2);
      if (!this.mIsSelected) {}
      for (bool = true;; bool = false)
      {
        QfileCloudFileTabView.a(localQfileCloudFileTabView, localWeiYunFileInfo, bool);
        paramInt2 += 1;
        break;
      }
    }
    this.this$0.dfI();
  }
  
  public void ag(int paramInt1, int paramInt2)
  {
    boolean bool = false;
    this.mIsSelected = false;
    this.mMaxIndex = -2147483648;
    this.mMinIndex = 2147483647;
    WeiYunFileInfo localWeiYunFileInfo = (WeiYunFileInfo)this.this$0.a.getChild(paramInt1, paramInt2);
    if (localWeiYunFileInfo == null) {}
    do
    {
      return;
      if (!atwb.c(localWeiYunFileInfo)) {
        bool = true;
      }
      this.mIsSelected = bool;
    } while (!QfileCloudFileTabView.a(this.this$0, localWeiYunFileInfo, this.mIsSelected));
    this.this$0.dfI();
  }
  
  public void ah(int paramInt1, int paramInt2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atqr
 * JD-Core Version:    0.7.0.1
 */