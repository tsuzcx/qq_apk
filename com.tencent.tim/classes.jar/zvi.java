import android.content.Intent;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.activity.photo.album.AbstractPhotoListActivity.PhotoListAdapter;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.activity.photo.album.NewPhotoPreviewActivity;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.activity.shortvideo.ShortVideoPreviewActivity;
import com.tencent.mobileqq.pic.PresendPicMgr;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.GestureSelectGridView;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class zvi
  extends ztv
{
  zvi(NewPhotoListActivity paramNewPhotoListActivity)
  {
    super(paramNewPhotoListActivity);
  }
  
  public void caseVideo(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (!aqft.cC()) {
      QQToast.a(this.mActivity, ((NewPhotoListActivity)this.mActivity).getResources().getString(2131719242), 0).show();
    }
    do
    {
      return;
      paramView = ((NewPhotoListActivity)this.mActivity).photoListAdapter.getItem(paramInt);
    } while (paramView == null);
    paramAdapterView = ((NewPhotoListActivity)this.mActivity).getIntent();
    if (paramView.fileSize > this.mPhotoCommonData.videoSizeLimit)
    {
      paramAdapterView = aqha.a(this.mActivity, "请选择不超过" + (float)this.mPhotoCommonData.videoSizeLimit / 1024.0F / 1024.0F / 1024.0F + "G的视频");
      paramAdapterView.setPositiveButton(2131721079, new aqha.a());
      paramAdapterView.show();
      return;
    }
    if (paramView.mDuration > this.mPhotoCommonData.videoDurationLimit)
    {
      paramAdapterView = aqha.a(this.mActivity, "请选择不超过" + this.mPhotoCommonData.videoDurationLimit / 60L / 1000L + "分钟的视频");
      paramAdapterView.setPositiveButton(2131721079, new aqha.a());
      paramAdapterView.show();
      return;
    }
    Object localObject1 = aqfy.sSelectItemAlbum;
    Object localObject2;
    if (!((HashMap)localObject1).containsKey(paramView.path))
    {
      localObject2 = new Pair(this.mPhotoCommonData.albumId, this.mPhotoCommonData.albumName);
      ((HashMap)localObject1).put(paramView.path, localObject2);
    }
    ((NewPhotoListActivity)this.mActivity).recordLastPos(paramView.path);
    if (!this.a.btj)
    {
      paramAdapterView.putExtra("file_send_path", paramView.path);
      paramAdapterView.putExtra("PhotoConst.IS_VIDEO_SELECTED", true);
      paramAdapterView.putExtra("PhotoConst.VIDEO_SIZE", paramView.fileSize);
      paramAdapterView.putExtra("file_send_duration", paramView.mDuration);
      paramAdapterView.putExtra("file_width", paramView.mediaWidth);
      paramAdapterView.putExtra("file_height", paramView.mediaHeight);
      paramAdapterView.putExtra("media_info", paramView);
      localObject1 = new ArrayList();
      ((ArrayList)localObject1).add(paramView.path);
      PhotoUtils.a(this.mActivity, paramAdapterView, (ArrayList)localObject1, 2, false);
      return;
    }
    if (!this.a.isSingleMode)
    {
      paramView = ((NewPhotoListActivity)this.mActivity).getIntent();
      paramView.putExtra("ALBUM_NAME", this.mPhotoCommonData.albumName);
      paramView.putExtra("ALBUM_ID", this.mPhotoCommonData.albumId);
      localObject1 = ((NewPhotoListActivity)this.mActivity).photoListAdapter.getItem(paramInt);
      paramView.putExtra("PhotoConst.CURRENT_SELECTED_INDEX", ((LocalMediaInfo)localObject1).position);
      paramView.putStringArrayListExtra("PhotoConst.SELECTED_PATHS", this.mPhotoCommonData.selectedPhotoList);
      paramView.putIntegerArrayListExtra("PhotoConst.SELECTED_INDEXS", this.mPhotoCommonData.selectedIndex);
      paramView.putExtra("FROM_WHERE", "FROM_PHOTO_LIST");
      paramView.putExtra("PhotoConst.CURRENT_QUALITY_TYPE", this.mPhotoCommonData.currentQualityType);
      paramView.putExtra("PhotoConst.SHOW_ALBUM", true);
      paramView.putExtra("PhotoConst.SHOW_MAGIC_USE_PASTER", this.a.btm);
      paramView.putExtra("PasterConstants.paster_id", this.a.pasterId);
      paramView.putExtra("PasterConstants.paster_cate_id", this.a.baR);
      ztu.sPhotoListFirstPos = ((NewPhotoListActivity)this.mActivity).mGridView.getFirstVisiblePosition();
      localObject2 = this.mPhotoCommonData.selectedMediaInfoHashMap;
      if (!((HashMap)localObject2).containsKey(((LocalMediaInfo)localObject1).path)) {
        ((HashMap)localObject2).put(((LocalMediaInfo)localObject1).path, localObject1);
      }
      paramView.putExtra("PeakConstants.selectedMediaInfoHashMap", (Serializable)localObject2);
      paramView.putExtra("PasterConstants.pasters_data", this.a.hx);
      paramView.setClass(this.mActivity, NewPhotoPreviewActivity.class);
      paramView.addFlags(603979776);
      if ((this.mPhotoCommonData.selectedPhotoList != null) && (this.mPhotoCommonData.selectedPhotoList.size() > 0)) {
        anot.b(null, "CliOper", "", this.mPhotoCommonData.myUin, "0X8005674", "0X8005674", 0, this.mPhotoCommonData.selectedPhotoList.size(), 0, "", "", "", "");
      }
      if (((zuc)this.mOtherCommonData).VO()) {
        ((NewPhotoListActivity)this.mActivity).startActivityForResult(paramAdapterView, 100010);
      }
      for (;;)
      {
        aqfy.anim(this.mActivity, true, true);
        return;
        ((NewPhotoListActivity)this.mActivity).startActivity(paramView);
        ((NewPhotoListActivity)this.mActivity).finish();
      }
    }
    localObject1 = new Intent(this.mActivity, ShortVideoPreviewActivity.class);
    ((Intent)localObject1).putExtras(paramAdapterView);
    ((Intent)localObject1).putExtra("file_send_path", paramView.path);
    ((Intent)localObject1).putExtra("file_send_size", paramView.fileSize);
    ((Intent)localObject1).putExtra("file_send_duration", paramView.mDuration);
    ((Intent)localObject1).putExtra("file_width", paramView.mediaWidth);
    ((Intent)localObject1).putExtra("file_height", paramView.mediaHeight);
    ((Intent)localObject1).putExtra("uin", this.a.friendUin);
    ((Intent)localObject1).putExtra("uintype", this.a.cZ);
    ((Intent)localObject1).putExtra("file_source", "album");
    ((Intent)localObject1).putExtra("is_from_system_media", paramView.isSystemMeidaStore);
    if (this.a.isSupportVideoCheckbox)
    {
      ((Intent)localObject1).putExtra("PhotoConst.IS_SUPPORT_VIDEO_CHECKBOX", true);
      ((Intent)localObject1).putExtra("PhotoConst.PHOTO_PATHS", this.mPhotoCommonData.selectedPhotoList);
    }
    ((NewPhotoListActivity)this.mActivity).startActivityForResult((Intent)localObject1, 17);
  }
  
  public String getExceedMaxSelectNumStr(LocalMediaInfo paramLocalMediaInfo)
  {
    int i = this.mPhotoCommonData.maxSelectNum;
    if (this.a.showMediaType == 6) {
      return ((NewPhotoListActivity)this.mActivity).getResources().getString(2131696893, new Object[] { Integer.valueOf(i) });
    }
    if (this.a.showMediaType == 2) {
      return ((NewPhotoListActivity)this.mActivity).getResources().getString(2131696897, new Object[] { Integer.valueOf(i) });
    }
    return super.getExceedMaxSelectNumStr(paramLocalMediaInfo);
  }
  
  public void initData(Intent paramIntent)
  {
    super.initData(paramIntent);
  }
  
  public void onTitleBtnCancelClick(View paramView)
  {
    paramView = ((NewPhotoListActivity)this.mActivity).getIntent();
    aqfy.clearSelectItemInfo();
    aqfy.clearCache();
    Object localObject = PresendPicMgr.a();
    if (localObject != null) {
      ((PresendPicMgr)localObject).IP(1006);
    }
    int i;
    if (this.mPhotoCommonData.selectedPhotoList != null)
    {
      i = this.mPhotoCommonData.selectedPhotoList.size();
      zsz.k(paramView, i);
      if (this.a.bti) {
        break label93;
      }
      ((NewPhotoListActivity)this.mActivity).finish();
      aqfy.anim(this.mActivity, false, false);
    }
    label93:
    String str;
    do
    {
      return;
      i = 0;
      break;
      QLog.e("PhotoListLogicMiniApp", 2, "onTitleBtnRightClick");
      localObject = new Intent();
      str = paramView.getStringExtra("PhotoConst.DEST_BROADCAST_ACTION_NAME");
      if (QLog.isColorLevel()) {
        QLog.d("PhotoListLogicMiniApp", 2, String.format("sendPhoto action=%s", new Object[] { str }));
      }
    } while (TextUtils.isEmpty(str));
    if (QLog.isColorLevel()) {
      QLog.d("PhotoListLogicMiniApp", 2, String.format("sendPhoto extras=%s", new Object[] { paramView.getExtras() }));
    }
    ((Intent)localObject).setComponent(null);
    ((Intent)localObject).setAction(str);
    ((Intent)localObject).setFlags(paramView.getFlags() & 0xDFFFFFFF & 0xFBFFFFFF);
    ((NewPhotoListActivity)this.mActivity).sendBroadcast((Intent)localObject);
    ((NewPhotoListActivity)this.mActivity).finish();
    aqfy.anim(this.mActivity, false, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zvi
 * JD-Core Version:    0.7.0.1
 */