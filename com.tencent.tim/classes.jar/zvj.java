import android.content.Intent;
import android.view.View;
import android.widget.CheckBox;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.AbstractPhotoListActivity.PhotoListAdapter;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;

public class zvj
  extends ztv
{
  zvj(NewPhotoListActivity paramNewPhotoListActivity)
  {
    super(paramNewPhotoListActivity);
  }
  
  private boolean c(LocalMediaInfo paramLocalMediaInfo)
  {
    if ((paramLocalMediaInfo.mediaWidth < 320) || (paramLocalMediaInfo.mediaHeight < 320))
    {
      paramLocalMediaInfo = aqha.a(this.mActivity, 230, null, acfp.m(2131709572), acfp.m(2131709556), null, null, new zvk(this));
      try
      {
        paramLocalMediaInfo.show();
        return false;
      }
      catch (Exception paramLocalMediaInfo)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("PhotoListLogicNearby", 2, "showLocationFailDialog fail!", paramLocalMediaInfo);
          }
        }
      }
    }
    return true;
  }
  
  public Intent caseNoSingModeImage(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    LocalMediaInfo localLocalMediaInfo = ((NewPhotoListActivity)this.mActivity).photoListAdapter.getItem(paramInt);
    if ((((NewPhotoListActivity)this.mActivity).photoListAdapter.getItemViewType(paramInt) == 0) && (!c(localLocalMediaInfo))) {
      return null;
    }
    return super.caseNoSingModeImage(paramAdapterView, paramView, paramInt, paramLong);
  }
  
  public String getExceedMaxSelectNumStr(LocalMediaInfo paramLocalMediaInfo)
  {
    return acfp.m(2131696195);
  }
  
  public void onCheckBoxClick(View paramView, int paramInt, CheckBox paramCheckBox)
  {
    if (c(((NewPhotoListActivity)this.mActivity).photoListAdapter.getItem(paramInt))) {
      super.onCheckBoxClick(paramView, paramInt, paramCheckBox);
    }
  }
  
  public void startPhotoPreviewActivity(Intent paramIntent)
  {
    if (paramIntent != null) {
      super.startPhotoPreviewActivity(paramIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zvj
 * JD-Core Version:    0.7.0.1
 */