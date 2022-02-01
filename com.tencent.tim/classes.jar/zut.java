import android.content.Intent;
import android.content.res.Resources;
import android.graphics.BitmapFactory.Options;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MediaScanner;
import com.tencent.mobileqq.activity.photo.album.AbstractPhotoListActivity.PhotoListAdapter;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.AdapterView;
import java.util.ArrayList;

public class zut
  extends ztv
{
  zut(NewPhotoListActivity paramNewPhotoListActivity)
  {
    super(paramNewPhotoListActivity);
  }
  
  private void a(LocalMediaInfo paramLocalMediaInfo, Bundle paramBundle)
  {
    if ((this.mActivity == null) || (this.mActivity == null) || (((NewPhotoListActivity)this.mActivity).getIntent() == null)) {}
    while (paramLocalMediaInfo == null) {
      return;
    }
    int i = ((NewPhotoListActivity)this.mActivity).getIntent().getIntExtra("entrance_type", 120);
    aytv.a(this.mActivity, paramLocalMediaInfo.path, paramLocalMediaInfo, 0, (int)paramLocalMediaInfo.mDuration, i, 10023, 0, null, null, false, 11, 14, paramBundle);
  }
  
  private void crY()
  {
    if ((this.mActivity != null) && (this.mActivity != null) && (((NewPhotoListActivity)this.mActivity).getIntent() != null)) {
      ((NewPhotoListActivity)this.mActivity).getIntent().putExtra("key_from_pic_choose", true);
    }
  }
  
  private void h(LocalMediaInfo paramLocalMediaInfo)
  {
    Object localObject;
    if ((paramLocalMediaInfo == null) || (TextUtils.isEmpty(paramLocalMediaInfo.path)) || (this.mActivity == null) || (this.mActivity == null) || (((NewPhotoListActivity)this.mActivity).getIntent() == null))
    {
      localObject = new StringBuilder().append("data error: ");
      if (paramLocalMediaInfo == null)
      {
        paramLocalMediaInfo = "";
        axiy.e("PhotoListLogicAECamera", paramLocalMediaInfo);
      }
    }
    do
    {
      return;
      paramLocalMediaInfo = paramLocalMediaInfo.path;
      break;
      crY();
      if (!axcg.am(((NewPhotoListActivity)this.mActivity).getIntent()))
      {
        ((NewPhotoListActivity)this.mActivity).cancleProgressDailog();
        localObject = new Bundle();
        ((Bundle)localObject).putString("KEY_PIC_TO_VIDEO_LOCAL_PIC_PATH", paramLocalMediaInfo.path);
        ((Bundle)localObject).putBoolean("VIDEO_STORY_PHOTO_LIST_TO_EDIT", true);
        ((NewPhotoListActivity)this.mActivity).getIntent().putExtra("VIDEO_STORY_MEDIA_TYPE", 101);
        a(paramLocalMediaInfo, (Bundle)localObject);
        return;
      }
      localObject = sqo.a().ap(paramLocalMediaInfo.path, "2");
    } while (TextUtils.isEmpty((CharSequence)localObject));
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    aqcu.decodeFile(paramLocalMediaInfo.path, localOptions);
    int i = ankt.SCREEN_WIDTH;
    float f = localOptions.outWidth / localOptions.outHeight;
    int k = alwy.iN(i);
    int m = alwy.iN((int)(k / f));
    int j = k;
    i = m;
    if (m > ayyh.eNn)
    {
      j = alwy.iN((int)(k * ayyh.eNn / m));
      i = ayyh.eNn;
    }
    sqo.a().a(paramLocalMediaInfo.path, (String)localObject, "2", j, i, false, 0, new zux(this, (String)localObject, paramLocalMediaInfo));
  }
  
  public void caseSingleModeImage(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if ((this.mActivity == null) || (this.mActivity == null))
    {
      axiy.e("PhotoListLogicAECamera", "mActivity is null");
      return;
    }
    paramAdapterView = ((NewPhotoListActivity)this.mActivity).photoListAdapter.getItem(paramInt);
    ((NewPhotoListActivity)this.mActivity).showProgressDialog();
    MediaScanner.getInstance(BaseApplicationImpl.getContext()).queryMediaInfoAsync(new zuu(this), paramAdapterView);
  }
  
  public void caseVideo(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if ((this.mActivity == null) || (this.mActivity == null))
    {
      axiy.e("PhotoListLogicAECamera", "mActivity is null.");
      return;
    }
    if (!aqft.cC())
    {
      QQToast.a(this.mActivity, ((NewPhotoListActivity)this.mActivity).getResources().getString(2131719242), 0).show();
      return;
    }
    paramAdapterView = ((NewPhotoListActivity)this.mActivity).photoListAdapter.getItem(paramInt);
    if (paramAdapterView == null)
    {
      axiy.e("PhotoListLogicAECamera", "photoInfo is null.");
      return;
    }
    paramView = ((NewPhotoListActivity)this.mActivity).getIntent();
    paramView.putExtra("file_send_path", paramAdapterView.path);
    paramView.putExtra("PhotoConst.IS_VIDEO_SELECTED", true);
    paramView.putExtra("PhotoConst.VIDEO_SIZE", paramAdapterView.fileSize);
    paramView.putExtra("file_send_duration", paramAdapterView.mDuration);
    paramView.putExtra("file_width", paramAdapterView.mediaWidth);
    paramView.putExtra("file_height", paramAdapterView.mediaHeight);
    paramView.putExtra("media_info", paramAdapterView);
    paramView.putExtra("key_from_pic_choose", true);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramAdapterView.path);
    ((NewPhotoListActivity)this.mActivity).showProgressDialog();
    crY();
    MediaScanner.getInstance(BaseApplicationImpl.getContext()).queryMediaInfoAsync(new zuv(this, paramView, localArrayList), paramAdapterView);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    int j = 0;
    if (((paramInt1 == 10023) || (paramInt1 == 2)) && (paramInt2 == -1))
    {
      if ((this.mActivity != null) && (this.mActivity != null))
      {
        ((NewPhotoListActivity)this.mActivity).setResult(paramInt2, paramIntent);
        ((NewPhotoListActivity)this.mActivity).finish();
      }
    }
    else if (paramInt1 == 10023)
    {
      int i = j;
      if (paramIntent != null)
      {
        i = j;
        if (paramIntent.getBooleanExtra("key_edit_to_photo_list", false)) {
          i = 1;
        }
      }
      if (i != 0) {
        ((NewPhotoListActivity)this.mActivity).finish();
      }
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zut
 * JD-Core Version:    0.7.0.1
 */