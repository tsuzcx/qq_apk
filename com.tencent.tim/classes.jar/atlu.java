import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tim.cloudfile.feeds.CloudPhotoListActivity;
import com.tencent.tim.cloudfile.feeds.CloudPhotoListActivity.b;
import com.tencent.widget.GestureSelectGridView;
import com.tencent.widget.GestureSelectGridView.b;

public class atlu
  implements GestureSelectGridView.b
{
  boolean mIsSelected;
  int mMaxIndex;
  int mMinIndex;
  
  public atlu(CloudPhotoListActivity paramCloudPhotoListActivity) {}
  
  public void onSelectBegin(int paramInt)
  {
    boolean bool = true;
    if (this.a.currentMode == 1) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("OnSelectListener", 2, "onSelectBegin beginIndex:" + paramInt);
    }
    this.a.dih = false;
    this.mIsSelected = false;
    this.mMinIndex = paramInt;
    this.mMaxIndex = paramInt;
    FileManagerEntity localFileManagerEntity = CloudPhotoListActivity.a(this.a).a(paramInt);
    if (!localFileManagerEntity.isSelectable()) {}
    for (;;)
    {
      this.mIsSelected = bool;
      if (!this.a.a(localFileManagerEntity, this.mIsSelected)) {
        break;
      }
      CloudPhotoListActivity.a(this.a);
      CloudPhotoListActivity.a(this.a).invalidateViews();
      return;
      bool = false;
    }
  }
  
  public void onSelectChanged(int paramInt1, int paramInt2)
  {
    if (this.a.currentMode == 1) {}
    int j;
    int k;
    do
    {
      do
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.d("OnSelectListener", 2, "onSelectChanged beginIndex:" + paramInt1 + " selectIndex:" + paramInt2);
        }
        j = Math.min(paramInt1, paramInt2);
        k = Math.max(paramInt1, paramInt2);
        if (paramInt2 >= paramInt1) {
          break;
        }
        i = this.mMinIndex;
        this.mMinIndex = Math.min(paramInt2, this.mMinIndex);
        if (paramInt2 >= i) {
          break label297;
        }
      } while ((this.mIsSelected) && (this.a.dih));
      i -= 1;
      while (i >= paramInt2)
      {
        this.a.a(CloudPhotoListActivity.a(this.a).a(i), this.mIsSelected);
        if ((this.mIsSelected) && (this.a.dih))
        {
          CloudPhotoListActivity.a(this.a);
          CloudPhotoListActivity.a(this.a).invalidateViews();
          return;
        }
        i -= 1;
      }
      i = this.mMaxIndex;
      this.mMaxIndex = Math.max(paramInt2, this.mMaxIndex);
      if (paramInt2 <= i) {
        break;
      }
    } while ((this.mIsSelected) && (this.a.dih));
    i += 1;
    while (i <= paramInt2)
    {
      this.a.a(CloudPhotoListActivity.a(this.a).a(i), this.mIsSelected);
      if ((this.mIsSelected) && (this.a.dih))
      {
        CloudPhotoListActivity.a(this.a);
        CloudPhotoListActivity.a(this.a).invalidateViews();
        return;
      }
      i += 1;
    }
    label297:
    int i = this.mMinIndex;
    CloudPhotoListActivity localCloudPhotoListActivity;
    FileManagerEntity localFileManagerEntity;
    boolean bool;
    if (i < j)
    {
      localCloudPhotoListActivity = this.a;
      localFileManagerEntity = CloudPhotoListActivity.a(this.a).a(i);
      if (!this.mIsSelected) {}
      for (bool = true;; bool = false)
      {
        localCloudPhotoListActivity.a(localFileManagerEntity, bool);
        i += 1;
        break;
      }
    }
    i = k + 1;
    if (i <= this.mMaxIndex)
    {
      localCloudPhotoListActivity = this.a;
      localFileManagerEntity = CloudPhotoListActivity.a(this.a).a(i);
      if (!this.mIsSelected) {}
      for (bool = true;; bool = false)
      {
        localCloudPhotoListActivity.a(localFileManagerEntity, bool);
        i += 1;
        break;
      }
    }
    if (paramInt2 < paramInt1)
    {
      this.mMinIndex = paramInt2;
      if (this.mMaxIndex > paramInt1) {
        this.mMaxIndex = paramInt1;
      }
    }
    for (;;)
    {
      CloudPhotoListActivity.a(this.a);
      CloudPhotoListActivity.a(this.a).invalidateViews();
      return;
      this.mMaxIndex = paramInt2;
      if (this.mMinIndex < paramInt1) {
        this.mMinIndex = paramInt1;
      }
    }
  }
  
  public void onSelectEnd()
  {
    if (this.a.currentMode == 1) {}
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("OnSelectListener", 2, "onSelectEnd");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atlu
 * JD-Core Version:    0.7.0.1
 */