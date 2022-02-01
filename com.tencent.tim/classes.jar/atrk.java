import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.tim.filemanager.activity.FMActivity;
import com.tencent.tim.filemanager.activity.localfile.QfileLocalFilePicTabView;
import com.tencent.tim.filemanager.widget.QfilePinnedHeaderExpandableListView.a;

public class atrk
  implements QfilePinnedHeaderExpandableListView.a
{
  private boolean mIsSelected;
  private int mMaxIndex;
  private int mMinIndex;
  
  public atrk(QfileLocalFilePicTabView paramQfileLocalFilePicTabView) {}
  
  public void IV(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      URLDrawable.pause();
      return;
    }
    URLDrawable.resume();
  }
  
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
        QfileLocalFilePicTabView.a(this.this$0, (FileInfo)this.this$0.a.getChild(paramInt1, paramInt2), this.mIsSelected);
        paramInt2 += 1;
      }
      this.mMaxIndex = Math.max(paramInt4, this.mMaxIndex);
    }
    paramInt2 = this.mMinIndex;
    QfileLocalFilePicTabView localQfileLocalFilePicTabView;
    FileInfo localFileInfo;
    boolean bool;
    if (paramInt2 < paramInt3)
    {
      localQfileLocalFilePicTabView = this.this$0;
      localFileInfo = (FileInfo)this.this$0.a.getChild(paramInt1, paramInt2);
      if (!this.mIsSelected) {}
      for (bool = true;; bool = false)
      {
        QfileLocalFilePicTabView.a(localQfileLocalFilePicTabView, localFileInfo, bool);
        paramInt2 += 1;
        break;
      }
    }
    paramInt2 = i + 1;
    if (paramInt2 <= this.mMaxIndex)
    {
      localQfileLocalFilePicTabView = this.this$0;
      localFileInfo = (FileInfo)this.this$0.a.getChild(paramInt1, paramInt2);
      if (!this.mIsSelected) {}
      for (bool = true;; bool = false)
      {
        QfileLocalFilePicTabView.a(localQfileLocalFilePicTabView, localFileInfo, bool);
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
    FileInfo localFileInfo = (FileInfo)this.this$0.a.getChild(paramInt1, paramInt2);
    if (localFileInfo == null) {}
    do
    {
      return;
      if (!atwb.d(localFileInfo)) {
        bool = true;
      }
      this.mIsSelected = bool;
    } while (!QfileLocalFilePicTabView.a(this.this$0, localFileInfo, this.mIsSelected));
    this.this$0.dfI();
  }
  
  public void ah(int paramInt1, int paramInt2)
  {
    if ((this.this$0.b.akM()) || (this.this$0.b.akN()))
    {
      SharedPreferences.Editor localEditor = this.this$0.b.getSharedPreferences("LAST_CHOOSE_", 0).edit();
      localEditor.putInt("GROUP", paramInt1);
      localEditor.putInt("CHILD", (paramInt2 + 1) / 4);
      localEditor.commit();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atrk
 * JD-Core Version:    0.7.0.1
 */