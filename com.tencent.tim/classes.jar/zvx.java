import android.content.Intent;
import android.view.View;
import android.widget.CheckBox;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.AbstractPhotoListActivity.PhotoListAdapter;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.widget.QQToast;
import java.util.ArrayList;
import java.util.Iterator;

class zvx
  extends ztv
{
  private final long LC = 600000L;
  private final int cft = 1024;
  
  protected zvx(NewPhotoListActivity paramNewPhotoListActivity)
  {
    super(paramNewPhotoListActivity);
  }
  
  boolean d(LocalMediaInfo paramLocalMediaInfo)
  {
    if (aqfy.getMediaType(paramLocalMediaInfo) == 1) {}
    for (int i = 1; (i != 0) && (paramLocalMediaInfo.mDuration > 600000L); i = 0)
    {
      QQToast.a(this.mActivity, acfp.m(2131709551) + 10L + acfp.m(2131709563), 0).show();
      return false;
    }
    Iterator localIterator = this.mPhotoCommonData.selectedPhotoList.iterator();
    for (long l = 0L; localIterator.hasNext(); l = aqhq.getFileSizes((String)localIterator.next()) + l) {}
    if (aqhq.getFileSizes(paramLocalMediaInfo.path) + l > 1073741824L)
    {
      QQToast.a(this.mActivity, acfp.m(2131709557) + "1.0G" + acfp.m(2131709586), 0).show();
      return false;
    }
    return true;
  }
  
  public String getExceedMaxSelectNumStr(LocalMediaInfo paramLocalMediaInfo)
  {
    int i = this.mPhotoCommonData.maxSelectNum;
    if (this.a.isSupportVideoCheckbox) {
      return ((NewPhotoListActivity)this.mActivity).getString(2131699664, new Object[] { Integer.valueOf(i) });
    }
    return ((NewPhotoListActivity)this.mActivity).getString(2131699665, new Object[] { Integer.valueOf(i) });
  }
  
  public void initData(Intent paramIntent)
  {
    super.initData(paramIntent);
  }
  
  public void onCheckBoxClick(View paramView, int paramInt, CheckBox paramCheckBox)
  {
    LocalMediaInfo localLocalMediaInfo = ((NewPhotoListActivity)this.mActivity).photoListAdapter.getItem(paramInt);
    if (localLocalMediaInfo == null) {
      super.onCheckBoxClick(paramView, paramInt, paramCheckBox);
    }
    while (!d(localLocalMediaInfo)) {
      return;
    }
    super.onCheckBoxClick(paramView, paramInt, paramCheckBox);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zvx
 * JD-Core Version:    0.7.0.1
 */