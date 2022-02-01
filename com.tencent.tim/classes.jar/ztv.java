import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.biz.qqstory.takevideo.slideshow.SlideItemInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.component.media.image.ImageManager;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.activity.photo.PhotoCropActivity;
import com.tencent.mobileqq.activity.photo.PhotoCropForPortraitActivity;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.activity.photo.album.AbstractPhotoListActivity.PhotoListAdapter;
import com.tencent.mobileqq.activity.photo.album.AbstractPhotoListActivity.PhotoListAdapter.Holder;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.activity.photo.album.NewPhotoPreviewActivity;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.activity.photo.album.PhotoListLogic.IadapterCallback;
import com.tencent.mobileqq.activity.photo.album.PhotoListLogic.IcheckBoxCallback;
import com.tencent.mobileqq.activity.photo.album.PhotoListLogic.IitemClickCallback;
import com.tencent.mobileqq.activity.photo.album.PhotoListLogic.IonSelectionChangeListener;
import com.tencent.mobileqq.activity.photo.album.PhotoListLogicBase;
import com.tencent.mobileqq.activity.photo.album.PhotoListLogicDefault.10;
import com.tencent.mobileqq.activity.photo.album.PhotoListLogicDefault.11;
import com.tencent.mobileqq.activity.photo.album.PhotoListLogicDefault.2;
import com.tencent.mobileqq.activity.photo.album.PhotoListLogicDefault.6;
import com.tencent.mobileqq.activity.photo.album.PhotoListLogicDefault.8;
import com.tencent.mobileqq.activity.shortvideo.SendVideoActivity.SendVideoInfo;
import com.tencent.mobileqq.activity.shortvideo.ShortVideoPreviewActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pic.PresendPicMgr;
import com.tencent.mobileqq.widget.NumberCheckBox;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.GestureSelectGridView;
import cooperation.qzone.util.QZLog;
import dov.com.tencent.biz.qqstory.takevideo.EditPicActivity;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;

public class ztv
  extends PhotoListLogicBase<NewPhotoListActivity, zuc>
  implements PhotoListLogic.IadapterCallback, PhotoListLogic.IcheckBoxCallback, PhotoListLogic.IitemClickCallback, rmd.a
{
  public ztu a;
  
  public ztv(NewPhotoListActivity paramNewPhotoListActivity)
  {
    super(paramNewPhotoListActivity);
    this.mPhotoListData = new ztu();
    this.a = ((ztu)this.mPhotoListData);
  }
  
  protected zuc a()
  {
    return new ztw(this);
  }
  
  protected void a(Intent paramIntent, boolean paramBoolean, ArrayList<String> paramArrayList)
  {
    int i2 = PhotoUtils.c(this.a.sessionInfo);
    Object localObject1 = new HashMap();
    int j = 0;
    int i = 0;
    int i1 = 0;
    int k = 0;
    while (i1 < paramArrayList.size())
    {
      localObject2 = (String)paramArrayList.get(i1);
      int m;
      if (ImageManager.isNetworkUrl((String)localObject2))
      {
        m = k;
        k = i;
        i = m;
        i1 += 1;
        m = k;
        k = i;
        i = m;
      }
      else
      {
        int n;
        if (((NewPhotoListActivity)this.mActivity).getMediaType((String)localObject2) == 1)
        {
          localObject2 = ((NewPhotoListActivity)this.mActivity).getMediaInfo((String)localObject2);
          n = j;
          m = i;
          if (localObject2 != null)
          {
            localObject3 = new SendVideoActivity.SendVideoInfo();
            ((SendVideoActivity.SendVideoInfo)localObject3).fileSize = ((LocalMediaInfo)localObject2).fileSize;
            ((SendVideoActivity.SendVideoInfo)localObject3).duration = ((LocalMediaInfo)localObject2).mDuration;
            ((HashMap)localObject1).put(Integer.valueOf(k), localObject3);
            m = i + 1;
            n = j;
          }
        }
        for (;;)
        {
          i = k + 1;
          j = n;
          k = m;
          break;
          n = j + 1;
          m = i;
        }
      }
    }
    Object localObject2 = String.valueOf(j);
    Object localObject3 = String.valueOf(i);
    if (!((HashMap)localObject1).isEmpty()) {
      paramIntent.putExtra("PhotoConst.VIDEO_INFOS", (Serializable)localObject1);
    }
    for (i = 1;; i = 0)
    {
      if ((anfr.akV != 0L) && (System.currentTimeMillis() - anfr.akV < 300000L)) {}
      for (boolean bool = true;; bool = false)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PhotoListActivity", 2, "upload video isConfirmed=" + bool + " allowUploadInXGTime=" + anfr.akV);
        }
        if ((!aqiw.isMobileNetWork(BaseApplicationImpl.getContext())) || (bool) || (i == 0)) {
          break;
        }
        localObject1 = ((NewPhotoListActivity)this.mActivity).getResources().getString(2131719478);
        paramIntent = new PhotoListLogicDefault.2(this, paramBoolean, paramIntent, paramArrayList, i2, (String)localObject2, (String)localObject3);
        if (armm.a(this.mActivity, 4, new ztx(this, paramIntent))) {
          aqha.a(this.mActivity, 232, null, (String)localObject1, new zty(this, paramIntent), new ztz(this)).show();
        }
        if (QLog.isColorLevel()) {
          QLog.i("PhotoListActivity", 2, "show shortvideo_mobile_send_confirm dialog");
        }
        return;
      }
      if (paramBoolean) {
        PhotoUtils.a(this.mActivity, paramIntent, paramArrayList, this.a.hw, this.mPhotoCommonData.currentQualityType, false);
      }
      for (;;)
      {
        anot.a(null, "CliOper", "", "", "0X8009AB0", "0X8009AB0", i2, 0, (String)localObject2, (String)localObject3, "", "");
        return;
        PhotoUtils.a(this.mActivity, paramIntent, paramArrayList, this.mPhotoCommonData.currentQualityType, this.a.bjL);
      }
    }
  }
  
  public void a(SlideItemInfo paramSlideItemInfo)
  {
    Object localObject1 = ((NewPhotoListActivity)this.mActivity).photoListAdapter;
    ArrayList localArrayList = this.mPhotoCommonData.selectedPhotoList;
    Object localObject2;
    int i;
    if ((localObject1 != null) && (paramSlideItemInfo != null))
    {
      localObject2 = ((AbstractPhotoListActivity.PhotoListAdapter)localObject1).getPhotoList();
      i = 0;
      if (i >= ((List)localObject2).size()) {
        break label542;
      }
      if (!((LocalMediaInfo)((List)localObject2).get(i)).path.equals(paramSlideItemInfo.mSrcPath)) {
        break label391;
      }
    }
    for (;;)
    {
      if ((i >= 0) && (i < ((List)localObject2).size()))
      {
        paramSlideItemInfo = ((AbstractPhotoListActivity.PhotoListAdapter)localObject1).getItem(i);
        paramSlideItemInfo.selectStatus = 2;
        localObject1 = paramSlideItemInfo.path;
        localObject2 = MimeHelper.getMimeType(paramSlideItemInfo.mMimeType);
        if ((this.a.isSupportVideoCheckbox) && (localObject2 != null) && ("video".equals(localObject2[0])))
        {
          localObject2 = this.a;
          ((ztu)localObject2).videoSelectedCnt -= 1;
          if (this.a.videoSelectedCnt == 1) {
            this.a.selectedVideoInfo = paramSlideItemInfo;
          }
        }
        if ((!TextUtils.isEmpty(paramSlideItemInfo.mMimeType)) && ("image/gif".equals(paramSlideItemInfo.mMimeType)))
        {
          localObject2 = this.a;
          ((ztu)localObject2).gifSelectedCount -= 1;
        }
        this.mPhotoCommonData.selectedPhotoList.remove(localObject1);
        this.mPhotoCommonData.selectedIndex.remove(paramSlideItemInfo.position);
        if (this.mPhotoCommonData.needMediaInfo) {
          this.mPhotoCommonData.selectedMediaInfoHashMap.remove(localObject1);
        }
        zsz.q(((NewPhotoListActivity)this.mActivity).getIntent(), "param_cancelSelNum");
        localObject2 = (HashMap)aqfy.sSelectItemPosMap.get(this.mPhotoCommonData.albumId);
        if (localObject2 != null) {
          ((HashMap)localObject2).remove(localObject1);
        }
        localObject2 = aqfy.sSelectItemAlbum;
        if (((HashMap)localObject2).containsKey(localObject1)) {
          ((HashMap)localObject2).remove(localObject1);
        }
        if (this.mSelectionListener != null) {
          this.mSelectionListener.onSelectionChange(false, paramSlideItemInfo);
        }
        ((NewPhotoListActivity)this.mActivity).updateCheckbox(i, false);
        updateButton();
        rma.a().b(localArrayList, this.mPhotoCommonData.allMediaInfoHashMap);
      }
      label391:
      while (i != -1)
      {
        return;
        i += 1;
        break;
      }
      localArrayList.remove(paramSlideItemInfo.mSrcPath);
      if (this.mPhotoCommonData.needMediaInfo) {
        this.mPhotoCommonData.selectedMediaInfoHashMap.remove(paramSlideItemInfo.mSrcPath);
      }
      zsz.q(((NewPhotoListActivity)this.mActivity).getIntent(), "param_cancelSelNum");
      localObject1 = (HashMap)aqfy.sSelectItemPosMap.get(this.mPhotoCommonData.albumId);
      if (localObject1 != null) {
        ((HashMap)localObject1).remove(paramSlideItemInfo.mSrcPath);
      }
      localObject1 = aqfy.sSelectItemAlbum;
      if (((HashMap)localObject1).containsKey(paramSlideItemInfo.mSrcPath)) {
        ((HashMap)localObject1).remove(paramSlideItemInfo.mSrcPath);
      }
      ((NewPhotoListActivity)this.mActivity).updateCheckboxForDelete();
      updateButton();
      rma.a().b(localArrayList, this.mPhotoCommonData.allMediaInfoHashMap);
      return;
      label542:
      i = -1;
    }
  }
  
  protected void a(LocalMediaInfo paramLocalMediaInfo, int paramInt)
  {
    aqfy.clearCache();
    String str = paramLocalMediaInfo.path;
    Intent localIntent = ((NewPhotoListActivity)this.mActivity).getIntent();
    localIntent.putExtra("ALBUM_NAME", this.mPhotoCommonData.albumName);
    localIntent.putExtra("ALBUM_ID", this.mPhotoCommonData.albumId);
    localIntent.putExtra("PhotoConst.IS_SINGLE_MODE", true);
    localIntent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", this.mPhotoCommonData.selectedPhotoList);
    localIntent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", str);
    localIntent.putExtra("media_info", paramLocalMediaInfo);
    if (localIntent.getBooleanExtra("PhotoConst.MULTI_PREVIEW_IN_SINGLE_MODE", false))
    {
      localIntent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", this.mPhotoCommonData.mediaPathsList);
      localIntent.putExtra("PhotoConst.CURRENT_SELECTED_INDEX", paramLocalMediaInfo.position);
    }
    if (this.a.btn)
    {
      paramLocalMediaInfo = aqfy.sSelectItemAlbum;
      if (!paramLocalMediaInfo.containsKey(str)) {
        paramLocalMediaInfo.put(str, new Pair(this.mPhotoCommonData.albumId, this.mPhotoCommonData.albumName));
      }
      ((NewPhotoListActivity)this.mActivity).recordLastPos(str);
      PhotoUtils.a(this.mActivity, localIntent, this.mPhotoCommonData.selectedPhotoList, 0, this.a.bjL);
      return;
    }
    if (!this.a.bto)
    {
      localIntent.putExtra("PhotoConst.ALLOW_LOCK", false);
      localIntent.setClass(this.mActivity, NewPhotoPreviewActivity.class);
      localIntent.putExtra("PasterConstants.pasters_data", this.a.hx);
      localIntent.putExtra("FROM_WHERE", "FROM_PHOTO_LIST");
      localIntent.putExtra("PhotoConst.SOURCE_FROM", "FROM_SELECT_PHOTO");
      localIntent.addFlags(603979776);
      ((NewPhotoListActivity)this.mActivity).startActivity(localIntent);
      ((NewPhotoListActivity)this.mActivity).finish();
      aqfy.anim(this.mActivity, true, true);
      return;
    }
    paramInt = localIntent.getIntExtra("Business_Origin", 0);
    if ((100 == paramInt) || (102 == paramInt) || (103 == paramInt)) {
      if (100 == paramInt)
      {
        int i = aqep.w(this.mActivity);
        localIntent.putExtra("PhotoConst.CLIP_WIDTH", i);
        localIntent.putExtra("PhotoConst.CLIP_HEIGHT", i);
        localIntent.putExtra("PhotoConst.TARGET_WIDTH", 1080);
        localIntent.putExtra("PhotoConst.TARGET_HEIGHT", 1080);
        localIntent.putExtra("PhotoConst.TARGET_SAMPLE_SIZE", 1620);
        label441:
        localIntent.setClass(this.mActivity, PhotoCropForPortraitActivity.class);
        localIntent.putExtra("PhotoConst.EDIT_MASK_SHAPE_TYPE", zti.fF(paramInt));
      }
    }
    for (;;)
    {
      aqfy.a(localIntent, this.mPhotoCommonData.albumId, str, this.a.isRecodeLastAlbumPath);
      localIntent.putExtra("PHOTOLIST_START_POSITION", ((NewPhotoListActivity)this.mActivity).mGridView.getFirstVisiblePosition());
      break;
      localIntent.putExtra("PhotoConst.IS_WITH_PENDANT", false);
      localIntent.putExtra("PhotoConst.TARGET_WIDTH", 640);
      localIntent.putExtra("PhotoConst.TARGET_HEIGHT", 640);
      break label441;
      localIntent.setClass(this.mActivity, PhotoCropActivity.class);
    }
  }
  
  boolean a(LocalMediaInfo paramLocalMediaInfo, CheckBox paramCheckBox)
  {
    long l;
    if ((paramLocalMediaInfo.selectStatus != 1) && (this.mPhotoCommonData.selectedPhotoList.size() >= this.mPhotoCommonData.maxSelectNum))
    {
      l = System.currentTimeMillis();
      if (l - this.a.lastTimeShowToast >= 1000L)
      {
        QQToast.a(this.mActivity, getExceedMaxSelectNumStr(paramLocalMediaInfo), 0).show(((NewPhotoListActivity)this.mActivity).mTitleBarHeight);
        paramCheckBox.setChecked(false);
        this.a.lastTimeShowToast = l;
        crT();
      }
      return false;
    }
    if ((this.a.cZ == 9501) && (((NewPhotoListActivity)this.mActivity).getIntent().getBooleanExtra("PhotoConst.IS_SEND_FILESIZE_LIMIT", false)) && (paramLocalMediaInfo.selectStatus != 1))
    {
      Iterator localIterator = this.mPhotoCommonData.selectedPhotoList.iterator();
      for (l = 0L; localIterator.hasNext(); l = aqhq.getFileSizes((String)localIterator.next()) + l) {}
      if (aqhq.getFileSizes(paramLocalMediaInfo.path) + l > 52428800L)
      {
        QQToast.a(this.mActivity, "选择图片总大小不能超过50M", 0).show(((NewPhotoListActivity)this.mActivity).mTitleBarHeight);
        paramCheckBox.setChecked(false);
        return false;
      }
    }
    if ((((NewPhotoListActivity)this.mActivity).getIntent().getBooleanExtra("PhotoConst.IS_SEND_GIF_SIZE_LIMIT", false)) && (((NewPhotoListActivity)this.mActivity).isGif(paramLocalMediaInfo)) && (aqhq.getFileSizes(paramLocalMediaInfo.path) > 3145728L))
    {
      QQToast.a(this.mActivity, "图片文件过大", 0).show(((NewPhotoListActivity)this.mActivity).mTitleBarHeight);
      paramCheckBox.setChecked(false);
      return false;
    }
    return (!((zuc)this.mOtherCommonData).VO()) || (aytv.a(this.mActivity, paramLocalMediaInfo));
  }
  
  public boolean addAndRemovePhotoByGesture(LocalMediaInfo paramLocalMediaInfo, boolean paramBoolean)
  {
    boolean bool = false;
    PhotoCommonBaseData localPhotoCommonBaseData = this.mPhotoCommonData;
    String[] arrayOfString = MimeHelper.getMimeType(paramLocalMediaInfo.mMimeType);
    if ((!this.a.isSupportVideoCheckbox) && (arrayOfString != null) && (!"image".equals(arrayOfString[0]))) {}
    long l;
    do
    {
      int i;
      do
      {
        return false;
        i = paramLocalMediaInfo.selectStatus;
      } while (((i == 1) && (paramBoolean)) || ((i == 2) && (!paramBoolean)));
      if ((i != 2) || (!paramBoolean) || (localPhotoCommonBaseData.selectedPhotoList.size() < localPhotoCommonBaseData.maxSelectNum)) {
        break;
      }
      l = System.currentTimeMillis();
    } while (l - this.a.lastTimeShowToast < 700L);
    QQToast.a(this.mActivity, getExceedMaxSelectNumStr(paramLocalMediaInfo), 1000).show(((NewPhotoListActivity)this.mActivity).mTitleBarHeight);
    this.a.lastTimeShowToast = l;
    this.a.hasShownMaxSelectToast = true;
    crT();
    return false;
    this.a.hasShownMaxSelectToast = false;
    if (paramBoolean) {
      b(paramLocalMediaInfo);
    }
    for (;;)
    {
      paramLocalMediaInfo = (NewPhotoListActivity)this.mActivity;
      if (!paramBoolean) {
        bool = true;
      }
      paramLocalMediaInfo.selectLimitRemind(bool);
      return true;
      c(paramLocalMediaInfo);
    }
  }
  
  protected void b(LocalMediaInfo paramLocalMediaInfo)
  {
    f(paramLocalMediaInfo);
  }
  
  public void bvy() {}
  
  protected void c(LocalMediaInfo paramLocalMediaInfo)
  {
    g(paramLocalMediaInfo);
  }
  
  protected void cK(Intent paramIntent)
  {
    ((NewPhotoListActivity)this.mActivity).startActivity(paramIntent);
  }
  
  public void cL(Intent paramIntent)
  {
    if (this.a.btr)
    {
      paramIntent.putExtra("ReceiptMsgManager.EXTRA_KEY_IS_RECEIPT", true);
      paramIntent.putExtra("session_info", ((NewPhotoListActivity)this.mActivity).getIntent().getParcelableExtra("session_info"));
    }
  }
  
  public void caseCamera(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (!aqft.cC())
    {
      QQToast.a(this.mActivity, ((NewPhotoListActivity)this.mActivity).getResources().getString(2131719242), 0).show();
      return;
    }
    ((NewPhotoListActivity)this.mActivity).crP();
  }
  
  public Intent caseNoSingModeImage(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = super.caseNoSingModeImage(paramAdapterView, paramView, paramInt, paramLong);
    paramAdapterView.putExtra("PhotoConst.MY_UIN", this.mPhotoCommonData.myUin);
    paramAdapterView.putExtra("PhotoConst.CURRENT_QUALITY_TYPE", this.mPhotoCommonData.currentQualityType);
    paramAdapterView.putExtra("PhotoConst.SHOW_MAGIC_USE_PASTER", this.a.btm);
    paramAdapterView.putExtra("PhotoConst.editPathMap", zsh.d(this.a.hy));
    paramAdapterView.putExtra("p_e_s_type", 6);
    paramAdapterView.putExtra("PasterConstants.paster_id", this.a.pasterId);
    paramAdapterView.putExtra("PasterConstants.paster_cate_id", this.a.baR);
    paramAdapterView.putExtra("PasterConstants.pasters_data", this.a.hx);
    if ((this.mPhotoCommonData.selectedPhotoList != null) && (this.mPhotoCommonData.selectedPhotoList.size() > 0)) {
      anot.b(null, "CliOper", "", this.mPhotoCommonData.myUin, "0X8005674", "0X8005674", 0, this.mPhotoCommonData.selectedPhotoList.size(), 0, "", "", "", "");
    }
    return paramAdapterView;
  }
  
  public void caseSingleModeImage(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    a(((NewPhotoListActivity)this.mActivity).photoListAdapter.getItem(paramInt), paramInt);
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
      paramAdapterView = aqha.a(this.mActivity, "你选择的视频文件过大，无法发送。");
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
  
  public void cfa()
  {
    PhotoCommonBaseData localPhotoCommonBaseData = this.mPhotoCommonData;
    switch (localPhotoCommonBaseData.currentQualityType)
    {
    case 1: 
    default: 
      return;
    case 0: 
      ((NewPhotoListActivity)this.mActivity).qualityCheckBox.setChecked(false);
      return;
    }
    aqfy.a(((NewPhotoListActivity)this.mActivity).Nn, localPhotoCommonBaseData.selectedPhotoList, localPhotoCommonBaseData.allMediaInfoHashMap, this.a.btq, this.mActivity, this.a.hw, localPhotoCommonBaseData.selectedMediaInfoHashMap);
    ((NewPhotoListActivity)this.mActivity).qualityCheckBox.setChecked(true);
  }
  
  protected void crS()
  {
    PhotoUtils.a(this.mActivity, ((NewPhotoListActivity)this.mActivity).getIntent(), this.mPhotoCommonData.selectedPhotoList, this.mPhotoCommonData.currentQualityType, this.a.bjL);
  }
  
  public void crT()
  {
    if (this.a.btr) {
      anot.a(null, "CliOper", "", "", "0x80083EC", "0x80083EC", 0, 0, "", "", "", "");
    }
  }
  
  void crU()
  {
    Object localObject = rma.a().getPhotoList();
    if (this.a.bts) {
      rma.a().eW((List)localObject);
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      SlideItemInfo localSlideItemInfo = (SlideItemInfo)((Iterator)localObject).next();
      if (localSlideItemInfo != null)
      {
        if (!this.mPhotoCommonData.selectedPhotoList.contains(localSlideItemInfo.mSrcPath)) {
          this.mPhotoCommonData.selectedPhotoList.add(localSlideItemInfo.mSrcPath);
        }
        if (!this.mPhotoCommonData.selectedIndex.contains(localSlideItemInfo.d.position)) {
          this.mPhotoCommonData.selectedIndex.add(localSlideItemInfo.d.position);
        }
        this.mPhotoCommonData.selectedMediaInfoHashMap.put(localSlideItemInfo.mSrcPath, localSlideItemInfo.d);
      }
    }
    if (this.mPhotoCommonData.selectedPhotoList.size() > 0) {
      rma.a().a(this.mPhotoCommonData.selectedPhotoList, this.mPhotoCommonData.allMediaInfoHashMap, false);
    }
  }
  
  protected void d(LocalMediaInfo paramLocalMediaInfo)
  {
    f(paramLocalMediaInfo);
  }
  
  public void doOnDestroy()
  {
    if (this.mPhotoCommonData.isShowQzoneAlbum) {
      BaseApplicationImpl.getApplication().getRuntime().unRegistObserver(((NewPhotoListActivity)this.mActivity).a);
    }
    if (((zuc)this.mOtherCommonData).VO()) {
      rma.a().bvs();
    }
    super.doOnDestroy();
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    aeee.e(BaseApplicationImpl.getContext(), 2, false);
    if (this.a.requestCode == 100016) {
      if (!((NewPhotoListActivity)this.mActivity).getIntent().getBooleanExtra("FROM_QZONR_NO_FINISH", false)) {
        ((NewPhotoListActivity)this.mActivity).finish();
      }
    }
    do
    {
      return;
      ((NewPhotoListActivity)this.mActivity).getIntent().removeExtra("FROM_QZONR_NO_FINISH");
      this.a.requestCode = 0;
      if (((NewPhotoListActivity)this.mActivity).magicStickBtn != null) {
        ((NewPhotoListActivity)this.mActivity).magicStickBtn.setClickable(true);
      }
    } while (!((zuc)this.mOtherCommonData).VO());
    rma.a().onResume();
    rma.a().a(this.a.c);
  }
  
  protected void e(LocalMediaInfo paramLocalMediaInfo)
  {
    g(paramLocalMediaInfo);
  }
  
  public void enterAlbumListFragment(Intent paramIntent)
  {
    super.enterAlbumListFragment(paramIntent);
    paramIntent.putExtra("PhotoConst.CURRENT_QUALITY_TYPE", this.mPhotoCommonData.currentQualityType);
    paramIntent.putExtra("PhotoConst.IS_SHOW_QZONE_ALBUM", this.mPhotoCommonData.isShowQzoneAlbum);
    paramIntent.putExtra("PhotoConst.PHOTO_INFOS", ((zuc)this.mOtherCommonData).selectedQzonePhotos);
    paramIntent.putExtra("peak.myUin", this.mPhotoCommonData.myUin);
  }
  
  public void enterPhotoPreviewActivity(boolean paramBoolean, Intent paramIntent)
  {
    aqfy.clearCache();
    paramIntent.putExtra("PhotoConst.SHOW_ALBUM", false);
    ArrayList localArrayList = this.mPhotoCommonData.selectedPhotoList;
    if (!paramBoolean)
    {
      paramIntent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", localArrayList);
      if ((localArrayList != null) && (localArrayList.size() > 0)) {
        anot.b(null, "CliOper", "", this.mPhotoCommonData.myUin, "0X8004072", "0X8004072", 0, localArrayList.size(), 0, "", "", "", "");
      }
      if ((((zuc)this.mOtherCommonData).selectedQzonePhotos == null) || (((zuc)this.mOtherCommonData).selectedQzonePhotos.size() <= 0)) {
        break label349;
      }
      paramIntent.putExtra("PhotoConst.PHOTO_INFOS", ((zuc)this.mOtherCommonData).selectedQzonePhotos);
      paramIntent.putExtra("PhotoConst.PHOTO_PATHS_FROM_QZONEALBUM", paramIntent.getSerializableExtra("PhotoConst.PHOTO_PATHS_FROM_QZONEALBUM"));
      paramIntent.putExtra("PhotoConst.CURRENT_SELECTED_INDEX", 0);
      paramIntent.putExtra("PhotoConst.USE_URL_PATH", true);
      paramIntent.putExtra("PhotoConst.QZONE_ALBUM_FROM_AIO", paramIntent.getBooleanExtra("PhotoConst.QZONE_ALBUM_FROM_AIO", false));
    }
    for (;;)
    {
      if (this.mPhotoCommonData.needMediaInfo)
      {
        paramIntent.putExtra("PeakConstants.selectedMediaInfoHashMap", this.mPhotoCommonData.selectedMediaInfoHashMap);
        paramIntent.putExtra("PhotoConst.CURRENT_SELECTED_INDEX", 0);
      }
      paramIntent.putExtra("ALBUM_NAME", this.mPhotoCommonData.albumName);
      paramIntent.putExtra("ALBUM_ID", this.mPhotoCommonData.albumId);
      paramIntent.putExtra("FROM_WHERE", "FROM_PHOTO_LIST");
      paramIntent.putExtra("PhotoConst.CURRENT_QUALITY_TYPE", this.mPhotoCommonData.currentQualityType);
      paramIntent.putExtra("PasterConstants.pasters_data", this.a.hx);
      ztu.sPhotoListFirstPos = ((NewPhotoListActivity)this.mActivity).mGridView.getFirstVisiblePosition();
      paramIntent.setClass(this.mActivity, NewPhotoPreviewActivity.class);
      paramIntent.addFlags(603979776);
      startPhotoPreviewActivity(paramIntent);
      aqfy.anim(this.mActivity, true, true);
      return;
      paramIntent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", this.a.currentPhotoPath);
      break;
      label349:
      paramIntent.putExtra("PhotoConst.USE_URL_PATH", false);
    }
  }
  
  public void er(int paramInt1, int paramInt2)
  {
    ArrayList localArrayList = this.mPhotoCommonData.selectedPhotoList;
    GestureSelectGridView localGestureSelectGridView = ((NewPhotoListActivity)this.mActivity).mGridView;
    AbstractPhotoListActivity.PhotoListAdapter localPhotoListAdapter = ((NewPhotoListActivity)this.mActivity).photoListAdapter;
    if ((paramInt1 >= 0) && (paramInt1 < localArrayList.size()) && (paramInt2 >= 0) && (paramInt2 < localArrayList.size()))
    {
      Collections.swap(localArrayList, paramInt1, paramInt2);
      paramInt2 = localGestureSelectGridView.getFirstVisiblePosition();
      int i = localGestureSelectGridView.getLastVisiblePosition();
      paramInt1 = paramInt2;
      while (paramInt1 <= i)
      {
        Object localObject = localPhotoListAdapter.getItem(paramInt1);
        int j = localArrayList.indexOf(((LocalMediaInfo)localObject).path);
        if (j >= 0)
        {
          localObject = (AbstractPhotoListActivity.PhotoListAdapter.Holder)localGestureSelectGridView.getChildAt(((LocalMediaInfo)localObject).position.intValue() - paramInt2).getTag();
          if ((localObject != null) && (((AbstractPhotoListActivity.PhotoListAdapter.Holder)localObject).mCheckBox != null)) {
            ((AbstractPhotoListActivity.PhotoListAdapter.Holder)localObject).mCheckBox.setCheckedNumber(j + 1);
          }
        }
        paramInt1 += 1;
      }
      rma.a().b(localArrayList, this.mPhotoCommonData.allMediaInfoHashMap);
    }
    ((NewPhotoListActivity)this.mActivity).selectLimitRemind(true);
  }
  
  protected void f(LocalMediaInfo paramLocalMediaInfo)
  {
    paramLocalMediaInfo.selectStatus = 1;
    String str = paramLocalMediaInfo.path;
    Object localObject = MimeHelper.getMimeType(paramLocalMediaInfo.mMimeType);
    if ((this.a.isSupportVideoCheckbox) && (localObject != null) && ("video".equals(localObject[0])))
    {
      localObject = this.a;
      ((ztu)localObject).videoSelectedCnt += 1;
      if (this.a.videoSelectedCnt == 1) {
        this.a.selectedVideoInfo = paramLocalMediaInfo;
      }
    }
    if ((!TextUtils.isEmpty(paramLocalMediaInfo.mMimeType)) && ("image/gif".equals(paramLocalMediaInfo.mMimeType)))
    {
      localObject = this.a;
      ((ztu)localObject).gifSelectedCount += 1;
    }
    this.mPhotoCommonData.selectedPhotoList.add(str);
    this.mPhotoCommonData.selectedIndex.add(paramLocalMediaInfo.position);
    if (this.mPhotoCommonData.needMediaInfo) {
      this.mPhotoCommonData.selectedMediaInfoHashMap.put(str, paramLocalMediaInfo);
    }
    zsz.q(((NewPhotoListActivity)this.mActivity).getIntent(), "param_totalSelNum");
    paramLocalMediaInfo = ((NewPhotoListActivity)this.mActivity).getIntent();
    if (!paramLocalMediaInfo.hasExtra("param_initTime")) {
      paramLocalMediaInfo.putExtra("param_initTime", System.currentTimeMillis());
    }
    paramLocalMediaInfo = (LinkedHashMap)aqfy.sSelectItemPosMap.get(this.mPhotoCommonData.albumId);
    if (paramLocalMediaInfo == null)
    {
      paramLocalMediaInfo = new LinkedHashMap();
      aqfy.sSelectItemPosMap.put(this.mPhotoCommonData.albumId, paramLocalMediaInfo);
    }
    for (;;)
    {
      paramLocalMediaInfo.put(str, Integer.valueOf(((NewPhotoListActivity)this.mActivity).mGridView.getFirstVisiblePosition()));
      paramLocalMediaInfo = aqfy.sSelectItemAlbum;
      if (!paramLocalMediaInfo.containsKey(str)) {
        paramLocalMediaInfo.put(str, new Pair(this.mPhotoCommonData.albumId, this.mPhotoCommonData.albumName));
      }
      return;
    }
  }
  
  protected void g(LocalMediaInfo paramLocalMediaInfo)
  {
    paramLocalMediaInfo.selectStatus = 2;
    String str = paramLocalMediaInfo.path;
    Object localObject = MimeHelper.getMimeType(paramLocalMediaInfo.mMimeType);
    if ((this.a.isSupportVideoCheckbox) && (localObject != null) && ("video".equals(localObject[0])))
    {
      localObject = this.a;
      ((ztu)localObject).videoSelectedCnt -= 1;
      if (this.a.videoSelectedCnt == 1) {
        this.a.selectedVideoInfo = paramLocalMediaInfo;
      }
    }
    if ((!TextUtils.isEmpty(paramLocalMediaInfo.mMimeType)) && ("image/gif".equals(paramLocalMediaInfo.mMimeType)))
    {
      localObject = this.a;
      ((ztu)localObject).gifSelectedCount -= 1;
    }
    this.mPhotoCommonData.selectedPhotoList.remove(str);
    this.mPhotoCommonData.selectedIndex.remove(paramLocalMediaInfo.position);
    if (this.mPhotoCommonData.needMediaInfo) {
      this.mPhotoCommonData.selectedMediaInfoHashMap.remove(str);
    }
    zsz.q(((NewPhotoListActivity)this.mActivity).getIntent(), "param_cancelSelNum");
    paramLocalMediaInfo = (HashMap)aqfy.sSelectItemPosMap.get(this.mPhotoCommonData.albumId);
    if (paramLocalMediaInfo != null) {
      paramLocalMediaInfo.remove(str);
    }
    paramLocalMediaInfo = aqfy.sSelectItemAlbum;
    if (paramLocalMediaInfo.containsKey(str)) {
      paramLocalMediaInfo.remove(str);
    }
  }
  
  public String getExceedMaxSelectNumStr(LocalMediaInfo paramLocalMediaInfo)
  {
    int i = this.mPhotoCommonData.maxSelectNum;
    String str = super.getExceedMaxSelectNumStr(paramLocalMediaInfo);
    if (paramLocalMediaInfo != null)
    {
      paramLocalMediaInfo = MimeHelper.getMimeType(paramLocalMediaInfo.mMimeType);
      if ((((zuc)this.mOtherCommonData).VO()) && (!this.a.isSupportVideoCheckbox)) {
        return ((NewPhotoListActivity)this.mActivity).getResources().getString(2131696895, new Object[] { Integer.valueOf(i) });
      }
      if ((this.a.isSupportVideoCheckbox) && (paramLocalMediaInfo != null) && ("video".equals(paramLocalMediaInfo[0])))
      {
        if (((zuc)this.mOtherCommonData).VO()) {
          return ((NewPhotoListActivity)this.mActivity).getResources().getString(2131696896, new Object[] { Integer.valueOf(i) });
        }
        return ((NewPhotoListActivity)this.mActivity).getResources().getString(2131696894, new Object[] { Integer.valueOf(i) });
      }
    }
    return str;
  }
  
  public List<LocalMediaInfo> getLocalMediaInfos()
  {
    int i = -1;
    if (this.mPhotoCommonData.albumId.equals("$RecentAlbumId")) {
      i = 100;
    }
    Object localObject1;
    if (((zuc)this.mOtherCommonData).VO()) {
      if ((!TextUtils.isEmpty(this.mPhotoCommonData.albumId)) && (this.mPhotoCommonData.albumId.equals("$CustomAlbumId")))
      {
        localObject1 = new ArrayList();
        ((List)localObject1).addAll(rma.a().ci());
        aqip.endPile("PEAK", "getAlbumMedias");
        if (localObject1 != null) {
          break label205;
        }
        if (QLog.isColorLevel()) {
          QLog.d("SelectPhotoTrace", 2, "photoList is null");
        }
        localObject2 = null;
      }
    }
    label205:
    do
    {
      do
      {
        do
        {
          return localObject2;
          localObject1 = aqfy.getAlbumMedias(this.mActivity, this.mPhotoCommonData.albumId, this.mPhotoCommonData.albumName, i, this.a.filter, 0, 0, true, null, false, this.a.filterVideoDurationLimit, 1);
          break;
          localObject1 = aqfy.getAlbumMedias(this.mActivity, this.mPhotoCommonData.albumId, this.mPhotoCommonData.albumName, i, this.a.filter, this.a.filterVideoDurationLimit);
          break;
          localObject2 = localObject1;
        } while (this.mPhotoCommonData.selectedPhotoList == null);
        localObject2 = localObject1;
      } while (this.mPhotoCommonData.selectedPhotoList.size() == 0);
      i = 0;
      localObject2 = localObject1;
    } while (i >= this.mPhotoCommonData.selectedPhotoList.size());
    Object localObject2 = (String)this.mPhotoCommonData.selectedPhotoList.get(i);
    int j;
    if (TextUtils.isEmpty((CharSequence)localObject2))
    {
      QZLog.e("PhotoListActivity:QueryPhotoTask", "doInBackground: filter photo error, tempPath null");
      j = i;
    }
    for (;;)
    {
      i = j + 1;
      break;
      j = i;
      if (!new File((String)localObject2).exists()) {
        if ((((String)localObject2).startsWith("http")) && (((zuc)this.mOtherCommonData).selectedQzonePhotos != null))
        {
          j = i;
          if (((zuc)this.mOtherCommonData).selectedQzonePhotos.containsKey(localObject2)) {}
        }
        else
        {
          this.mPhotoCommonData.selectedPhotoList.remove(i);
          i -= 1;
          j = i;
          if (this.mPhotoCommonData.needMediaInfo)
          {
            j = i;
            if (this.mPhotoCommonData.selectedMediaInfoHashMap != null)
            {
              j = i;
              if (this.mPhotoCommonData.selectedMediaInfoHashMap.containsKey(localObject2))
              {
                this.mPhotoCommonData.selectedMediaInfoHashMap.remove(localObject2);
                j = i;
              }
            }
          }
        }
      }
    }
  }
  
  public View getViewCaseCamera(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    return super.getViewCaseCamera(paramInt, paramView, paramViewGroup);
  }
  
  public void handlePicCapture(Intent paramIntent)
  {
    super.handlePicCapture(paramIntent);
    paramIntent = paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
    if ((paramIntent != null) && (paramIntent.size() > 0) && (!TextUtils.isEmpty((CharSequence)paramIntent.get(0)))) {
      ThreadManager.postImmediately(new PhotoListLogicDefault.8(this, (String)paramIntent.get(0)), null, true);
    }
  }
  
  public void handleVideoCapture(Intent paramIntent)
  {
    super.handleVideoCapture(paramIntent);
    ((NewPhotoListActivity)this.mActivity).showProgressDialog();
    long l = System.currentTimeMillis();
    Object localObject = paramIntent.getStringExtra("video_new_fake_vid");
    paramIntent = paramIntent.getStringExtra("file_video_source_dir");
    pog localpog = new pog();
    localpog.rZ(true);
    localObject = pog.a((String)localObject);
    String str = aazd.io(((PublishVideoEntry)localObject).mLocalRawVideoDir);
    if (TextUtils.isEmpty(str))
    {
      QZLog.i("PhotoListActivity", 1, "get target path fail");
      return;
    }
    localpog.a((PublishVideoEntry)localObject, str, false, true, new zub(this, l, str, (PublishVideoEntry)localObject, paramIntent));
  }
  
  public void handleVideoEncodeSucceed(Message paramMessage)
  {
    super.handleVideoEncodeSucceed(paramMessage);
    ((NewPhotoListActivity)this.mActivity).cancleProgressDailog();
    ArrayList localArrayList = this.mPhotoCommonData.selectedPhotoList;
    String str;
    if ((paramMessage.obj instanceof String))
    {
      str = (String)paramMessage.obj;
      QZLog.d("PhotoListActivity", 2, new Object[] { "onEncodeSuccess = ", str });
      paramMessage = localArrayList;
      if (localArrayList == null) {
        paramMessage = new ArrayList();
      }
      if (paramMessage.size() < PhotoCommonBaseData.getInstance().maxSelectNum) {
        break label147;
      }
      QQToast.a(this.mActivity, String.format(((NewPhotoListActivity)this.mActivity).getResources().getString(2131696894), new Object[] { Integer.valueOf(PhotoCommonBaseData.getInstance().maxSelectNum) }), 0).show();
    }
    for (;;)
    {
      ((NewPhotoListActivity)this.mActivity).zJ(str);
      return;
      label147:
      PhotoCommonBaseData.getInstance().selectedPhotoList.add(str);
      ((NewPhotoListActivity)this.mActivity).crQ();
    }
  }
  
  public void initData(Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SelectPhotoTrace", 2, "PhotoListActivity initData(),intent extras is:" + paramIntent.getExtras());
    }
    super.initData(paramIntent);
    this.a.bts = paramIntent.getBooleanExtra("PhotoConst.IS_FROM_EDIT", false);
    zsh.a(this.mActivity, paramIntent, false, this.a.hy);
    this.a.hw = ((HashMap)paramIntent.getSerializableExtra("PhotoConst.PHOTO_PATHS_FROM_QZONEALBUM"));
    if (this.a.hw == null) {
      this.a.hw = new HashMap(1);
    }
    this.mPhotoCommonData.isShowQzoneAlbum = paramIntent.getBooleanExtra("PhotoConst.IS_SHOW_QZONE_ALBUM", false);
    ((zuc)this.mOtherCommonData).selectedQzonePhotos = ((HashMap)paramIntent.getSerializableExtra("PhotoConst.PHOTO_INFOS"));
    this.a.btk = paramIntent.getBooleanExtra("PhotoConst.original_button", false);
    this.a.btl = paramIntent.getBooleanExtra("PhotoConst.quality_count_tv", true);
    this.mPhotoCommonData.myUin = paramIntent.getStringExtra("PhotoConst.MY_UIN");
    this.a.bjL = paramIntent.getBooleanExtra("PhotoConst.HANDLE_DEST_RESULT", false);
    this.a.btn = paramIntent.getBooleanExtra("PhotoConst.IS_SINGLE_DERECTBACK_MODE", false);
    this.a.bto = paramIntent.getBooleanExtra("PhotoConst.IS_SINGLE_NEED_EDIT", false);
    this.a.btp = paramIntent.getBooleanExtra("PhotoConst.IS_CALL_IN_PLUGIN", false);
    this.a.cZ = paramIntent.getIntExtra("uintype", -1);
    this.mPhotoCommonData.currentQualityType = paramIntent.getIntExtra("PhotoConst.CURRENT_QUALITY_TYPE", 0);
    if (paramIntent.getBooleanExtra("PhotoConst.ALWAYS_SHOW_NUMBER_WHEN_ONLY_ONE_IMAGE", false)) {
      this.a.isSingleMode = false;
    }
    this.a.bti = paramIntent.getBooleanExtra("PhotoConst.IS_FINISH_RESTART_INIT_ACTIVITY", false);
    this.a.isSend = paramIntent.getBooleanExtra("PhotoConst.SEND_FLAG", false);
    this.a.userName = paramIntent.getStringExtra("uinname");
    this.a.friendUin = paramIntent.getStringExtra("uin");
    this.mPhotoCommonData.videoSizeLimit = paramIntent.getLongExtra("PhotoConst.PHOTOLIST_KEY_VIDEO_SIZE", 1048576000L);
    this.a.btj = paramIntent.getBooleanExtra("PhotoConst.IS_PREVIEW_VIDEO", true);
    this.mPhotoCommonData.videoDurationLimit = paramIntent.getLongExtra("PhotoConst.PHOTOLIST_KEY_VIDEO_DURATION", 9223372036854775807L);
    try
    {
      this.a.sessionInfo = ((SessionInfo)paramIntent.getParcelableExtra("session_info"));
      if (this.a.isSend)
      {
        paramIntent.removeExtra("PhotoConst.SEND_FLAG");
        PresendPicMgr localPresendPicMgr = PresendPicMgr.a();
        if (localPresendPicMgr != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("PhotoListActivity", 2, "Photo+ send pic,cancel presend!");
          }
          localPresendPicMgr.IP(1004);
        }
        PhotoUtils.a(this.mActivity, paramIntent, this.mPhotoCommonData.selectedPhotoList, this.mPhotoCommonData.currentQualityType, true);
      }
      if (!this.a.btm) {
        this.a.btm = paramIntent.getBooleanExtra("PhotoConst.SHOW_MAGIC_USE_PASTER", false);
      }
      if (this.a.btm)
      {
        this.a.hx = ((HashMap)paramIntent.getSerializableExtra("PasterConstants.pasters_data"));
        this.a.pasterId = paramIntent.getStringExtra("PasterConstants.paster_id");
        this.a.baR = paramIntent.getStringExtra("PasterConstants.paster_cate_id");
      }
      this.a.btr = paramIntent.getBooleanExtra("ReceiptMsgManager.EXTRA_KEY_IS_RECEIPT", false);
      this.a.Lz = paramIntent.getLongExtra("PhotoConst.PHOTOLIST_KEY_MAX_MEDIA_SIZE", -1L);
      if (this.mPhotoCommonData.isShowQzoneAlbum)
      {
        paramIntent = new NewIntent(BaseApplicationImpl.getApplication(), anem.class);
        paramIntent.putExtra("selfuin", Long.valueOf(BaseApplicationImpl.getApplication().getRuntime().getAccount()));
        BaseApplicationImpl.getApplication().getRuntime().registObserver(((NewPhotoListActivity)this.mActivity).a);
        BaseApplicationImpl.getApplication().getRuntime().startServlet(paramIntent);
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("PhotoListActivity", 2, "submit", localException);
        }
      }
    }
  }
  
  public boolean needVedio()
  {
    return super.needVedio();
  }
  
  int o(List<LocalMediaInfo> paramList)
  {
    int i;
    int j;
    int k;
    if (this.a.photoListStartPos == -1)
    {
      i = ztu.sPhotoListFirstPos;
      if (i != -1) {
        break label303;
      }
      Object localObject = (LinkedHashMap)aqfy.sSelectItemPosMap.get(this.mPhotoCommonData.albumId);
      j = i;
      if (localObject != null)
      {
        k = ((LinkedHashMap)localObject).size();
        j = i;
        if (k > 0) {
          j = ((Integer)((LinkedHashMap)localObject).get(localObject.keySet().toArray()[(k - 1)])).intValue();
        }
      }
      i = j;
      if (j == -1)
      {
        i = j;
        if (this.a.isRecodeLastAlbumPath)
        {
          localObject = paramList.iterator();
          k = 0;
          label116:
          i = j;
          if (((Iterator)localObject).hasNext())
          {
            if (((LocalMediaInfo)((Iterator)localObject).next()).selectStatus != 3) {
              break label285;
            }
            i = k;
          }
        }
      }
      localObject = this.mPhotoCommonData.selectedPhotoList;
      j = i;
      if (i == -1)
      {
        j = i;
        if (this.mPhotoCommonData.albumId.equals("$RecentAlbumId"))
        {
          j = i;
          if (!((ArrayList)localObject).isEmpty())
          {
            int m = paramList.size();
            localObject = (String)((ArrayList)localObject).get(((ArrayList)localObject).size() - 1);
            k = 0;
            label220:
            j = i;
            if (k < m)
            {
              if (!((String)localObject).equals(((LocalMediaInfo)paramList.get(k)).path)) {
                break label294;
              }
              j = k;
            }
          }
        }
      }
      label254:
      i = ((NewPhotoListActivity)this.mActivity).photoListAdapter.getCount();
      if (i != 0) {
        break label312;
      }
    }
    label285:
    label294:
    label303:
    label312:
    do
    {
      return 0;
      i = this.a.photoListStartPos;
      break;
      k += 1;
      break label116;
      k += 1;
      break label220;
      ztu.sPhotoListFirstPos = -1;
      j = i;
      break label254;
      if (j > i - 1) {
        return i - 1;
      }
    } while (j < 0);
    return j;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    ArrayList localArrayList = this.mPhotoCommonData.selectedPhotoList;
    if ((QLog.isDevelopLevel()) && (localArrayList != null) && (localArrayList.size() != 0)) {
      QLog.d("PhotoListActivity", 4, "[NewPhotoListActivity] [onActivityResult] selectedPhotoList = " + localArrayList.size());
    }
    this.a.requestCode = paramInt1;
    if (paramInt2 == -1) {
      switch (paramInt1)
      {
      }
    }
    for (;;)
    {
      PhotoUtils.a(this.mActivity, paramInt1, paramInt2, paramIntent, this.a.btp, this.mPhotoCommonData.myUin);
      do
      {
        return;
        ((NewPhotoListActivity)this.mActivity).setResult(-1, paramIntent);
        ((NewPhotoListActivity)this.mActivity).finish();
        break;
        paramIntent = PresendPicMgr.a();
        if (paramIntent != null) {
          paramIntent.cE(this.a.currentPhotoPath, 1008);
        }
        enterPhotoPreviewActivity(true, ((NewPhotoListActivity)this.mActivity).getIntent());
        return;
        paramIntent = new Intent();
        paramIntent.putStringArrayListExtra("PhotoConst.SELECTED_PATHS", localArrayList);
        paramIntent.putExtra("PhotoConst.CURRENT_QUALITY_TYPE", this.mPhotoCommonData.currentQualityType);
        ((NewPhotoListActivity)this.mActivity).setResult(-1, paramIntent);
        ((NewPhotoListActivity)this.mActivity).finish();
        return;
      } while (paramIntent == null);
      this.mPhotoCommonData.selectedPhotoList = paramIntent.getStringArrayListExtra("img_list");
      continue;
      rma.a().a(paramIntent, this.mPhotoCommonData.selectedMediaInfoHashMap);
      continue;
      if (paramInt1 == 17)
      {
        aqfy.sLastAlbumRecordTime = 0L;
        return;
      }
      if ((paramInt1 == 100010) && (((zuc)this.mOtherCommonData).VO())) {
        if (this.a.needQueryTask) {
          ((NewPhotoListActivity)this.mActivity).runOnUiThread(new PhotoListLogicDefault.6(this));
        } else {
          this.a.needQueryTask = true;
        }
      }
    }
  }
  
  public void onBackPressed()
  {
    super.onBackPressed();
  }
  
  public void onCheckBoxClick(View paramView, int paramInt, CheckBox paramCheckBox)
  {
    boolean bool2 = true;
    paramView = this.mPhotoCommonData.selectedPhotoList;
    if (this.a.isSingleMode) {}
    int i;
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("PhotoListActivity", 2, "current select count:" + paramView.size());
      }
      paramView = ((NewPhotoListActivity)this.mActivity).photoListAdapter.getItem(paramInt);
      i = paramView.selectStatus;
    } while (!a(paramView, paramCheckBox));
    if (i != 1)
    {
      bool1 = true;
      label96:
      if (!bool1) {
        break label309;
      }
      d(paramView);
      label106:
      if (this.mSelectionListener != null) {
        this.mSelectionListener.onSelectionChange(bool1, paramView);
      }
      ((NewPhotoListActivity)this.mActivity).updateCheckbox(paramInt, bool1);
      paramView = (NewPhotoListActivity)this.mActivity;
      if (bool1) {
        break label317;
      }
    }
    label309:
    label317:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      paramView.selectLimitRemind(bool1);
      updateButton();
      if (!((zuc)this.mOtherCommonData).VO()) {
        break;
      }
      if (rma.a().getPhotoList().isEmpty())
      {
        i = ((NewPhotoListActivity)this.mActivity).mGridView.getFirstVisiblePosition();
        paramView = ((NewPhotoListActivity)this.mActivity).mGridView.getChildAt(paramInt - i);
        if ((paramView != null) && (((NewPhotoListActivity)this.mActivity).mGridView.getHeight() - paramView.getY() < ((NewPhotoListActivity)this.mActivity).mImageHeight)) {
          ((NewPhotoListActivity)this.mActivity).mGridView.smoothScrollBy(rma.btm, 500);
        }
      }
      rma.a().b(this.mPhotoCommonData.selectedPhotoList, this.mPhotoCommonData.allMediaInfoHashMap);
      return;
      bool1 = false;
      break label96;
      e(paramView);
      break label106;
    }
  }
  
  public void onGestureSelectEnd(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (this.a.isSingleMode) {
      return;
    }
    if (((zuc)this.mOtherCommonData).VO())
    {
      if (rma.a().getPhotoList().isEmpty())
      {
        paramInt2 = ((NewPhotoListActivity)this.mActivity).mGridView.getFirstVisiblePosition();
        localObject = ((NewPhotoListActivity)this.mActivity).mGridView.getChildAt(paramInt1 - paramInt2);
        if ((localObject != null) && (((NewPhotoListActivity)this.mActivity).mGridView.getHeight() - ((View)localObject).getY() < ((NewPhotoListActivity)this.mActivity).mImageHeight)) {
          ((NewPhotoListActivity)this.mActivity).mGridView.smoothScrollBy(rma.btm, 500);
        }
      }
      rma.a().b(this.mPhotoCommonData.selectedPhotoList, this.mPhotoCommonData.allMediaInfoHashMap);
    }
    Object localObject = PresendPicMgr.a();
    if (localObject != null)
    {
      Iterator localIterator = this.a.presendPathSet.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if (((NewPhotoListActivity)this.mActivity).getMediaType(str) != 1) {
          ((PresendPicMgr)localObject).cE(str, 1052);
        }
      }
      localIterator = this.a.cancelPresendPathSet.iterator();
      while (localIterator.hasNext()) {
        ((PresendPicMgr)localObject).fx((String)localIterator.next(), 1013);
      }
    }
    this.a.presendPathSet.clear();
    this.a.cancelPresendPathSet.clear();
  }
  
  public void onMagicStickClick(View paramView, Bundle paramBundle, int paramInt, Intent paramIntent)
  {
    if (this.mPhotoCommonData.selectedPhotoList.size() > 0)
    {
      paramView = ((NewPhotoListActivity)this.mActivity).getIntent();
      paramView.removeExtra("param_initTime");
      paramView.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", this.mPhotoCommonData.selectedPhotoList);
      anot.a(null, "CliOper", "", "", "0x8004B39", "0x8004B39", 0, 0, "", "", "", "");
      paramView = paramIntent;
      if (paramIntent == null) {
        paramView = EditPicActivity.a(this.mActivity, (String)this.mPhotoCommonData.selectedPhotoList.get(0), true, true, true, true, true, paramInt, 99, 5, paramBundle);
      }
      paramView.putExtra("key_enable_edit_title_bar", true);
      cL(paramView);
      cK(paramView);
      ((NewPhotoListActivity)this.mActivity).magicStickBtn.setClickable(false);
    }
  }
  
  public void onPhotoListDatasetDurationChanged(int paramInt, LocalMediaInfo paramLocalMediaInfo)
  {
    Handler localHandler = ((NewPhotoListActivity)this.mActivity).mHandler;
    if (localHandler == null) {}
    do
    {
      do
      {
        return;
        localObject = ((NewPhotoListActivity)this.mActivity).photoListAdapter;
      } while ((localObject == null) || (((AbstractPhotoListActivity.PhotoListAdapter)localObject).mAllImages == null));
      localObject = (LocalMediaInfo)((AbstractPhotoListActivity.PhotoListAdapter)localObject).mAllImages.get(paramInt);
    } while ((localObject == null) || (paramLocalMediaInfo == null) || (((LocalMediaInfo)localObject).path == null) || (paramLocalMediaInfo.path == null) || (!((LocalMediaInfo)localObject).path.equals(paramLocalMediaInfo.path)));
    Object localObject = localHandler.obtainMessage();
    ((Message)localObject).what = 0;
    Bundle localBundle = new Bundle();
    localBundle.putInt("ALBUMLIST_POSITION", paramInt);
    localBundle.putLong("ALBUMLIST_ITEM_DURATION", paramLocalMediaInfo.mDuration);
    ((Message)localObject).setData(localBundle);
    localHandler.sendMessage((Message)localObject);
  }
  
  public void onPreviewBtnClick(View paramView)
  {
    super.onPreviewBtnClick(paramView);
  }
  
  public void onQualityBtnClick(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (paramBoolean) {
      if (aqfy.a(this.mPhotoCommonData.selectedPhotoList, ((zuc)this.mOtherCommonData).cfh, this.mPhotoCommonData.allMediaInfoHashMap, this.a.btq, this.mPhotoCommonData.selectedMediaInfoHashMap) > 0)
      {
        QQToast.a(this.mActivity, ((NewPhotoListActivity)this.mActivity).getResources().getString(2131696907), 0).show(((NewPhotoListActivity)this.mActivity).getResources().getDimensionPixelSize(2131299627));
        this.mPhotoCommonData.currentQualityType = 0;
        ((NewPhotoListActivity)this.mActivity).qualityCheckBox.setChecked(false);
        ((NewPhotoListActivity)this.mActivity).Nn.setVisibility(4);
      }
    }
    for (;;)
    {
      if (!this.a.btl) {
        ((NewPhotoListActivity)this.mActivity).Nn.setVisibility(8);
      }
      return;
      if (aqfy.a(this.mPhotoCommonData.selectedPhotoList, this.mPhotoCommonData.videoSizeLimit, this.mPhotoCommonData.allMediaInfoHashMap, this.a.btq, this.mPhotoCommonData.selectedMediaInfoHashMap) > 0)
      {
        QQToast.a(this.mActivity, ((NewPhotoListActivity)this.mActivity).getResources().getString(2131720265), 0).show(((NewPhotoListActivity)this.mActivity).getResources().getDimensionPixelSize(2131299627));
        aqfy.edE();
      }
      ((NewPhotoListActivity)this.mActivity).qualityCheckBox.setChecked(true);
      this.mPhotoCommonData.currentQualityType = 2;
      aqfy.a(((NewPhotoListActivity)this.mActivity).Nn, this.mPhotoCommonData.selectedPhotoList, this.mPhotoCommonData.allMediaInfoHashMap, this.a.btq, this.mActivity, this.a.hw, this.mPhotoCommonData.selectedMediaInfoHashMap);
      continue;
      this.mPhotoCommonData.currentQualityType = 0;
      ((NewPhotoListActivity)this.mActivity).qualityCheckBox.setChecked(false);
      ((NewPhotoListActivity)this.mActivity).Nn.setVisibility(4);
    }
  }
  
  public boolean onQueryPhoto(List<LocalMediaInfo> paramList)
  {
    boolean bool = false;
    int i;
    if (super.onQueryPhoto(paramList)) {
      if (this.a.firstResume)
      {
        this.a.firstResume = false;
        i = o(paramList);
        if (!((zuc)this.mOtherCommonData).VO()) {
          break label221;
        }
        if ((this.mPhotoCommonData.selectedPhotoList != null) && (this.mPhotoCommonData.selectedPhotoList.size() > 0))
        {
          paramList = (String)this.mPhotoCommonData.selectedPhotoList.get(this.mPhotoCommonData.selectedPhotoList.size() - 1);
          int j = this.mPhotoCommonData.mediaPathsList.indexOf(paramList);
          if ((j >= 0) && (j < ((NewPhotoListActivity)this.mActivity).mGridView.getAdapter().getCount())) {
            ((NewPhotoListActivity)this.mActivity).mGridView.post(new PhotoListLogicDefault.10(this, i));
          }
        }
      }
    }
    for (;;)
    {
      if (((zuc)this.mOtherCommonData).VO())
      {
        ((NewPhotoListActivity)this.mActivity).c(this.mPhotoCommonData.selectedPhotoList, this.mPhotoCommonData.selectedMediaInfoHashMap);
        rma.a().b(this.mPhotoCommonData.selectedPhotoList, this.mPhotoCommonData.allMediaInfoHashMap);
      }
      bool = true;
      return bool;
      label221:
      ((NewPhotoListActivity)this.mActivity).mGridView.post(new PhotoListLogicDefault.11(this, i));
    }
  }
  
  public void onSendBtnClick(View paramView)
  {
    ((NewPhotoListActivity)this.mActivity).sendBtn.setClickable(false);
    if (!this.mPhotoCommonData.selectedPhotoList.isEmpty()) {
      ((NewPhotoListActivity)this.mActivity).recordLastPos((String)this.mPhotoCommonData.selectedPhotoList.get(this.mPhotoCommonData.selectedPhotoList.size() - 1));
    }
    aqfy.clearCache();
    if (this.mPhotoCommonData.selectedPhotoList.size() == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.e("PhotoList", 2, "size == 0");
      }
      return;
    }
    if (((NewPhotoListActivity)this.mActivity).getIntent().getBooleanExtra("PhotoConst.IS_SEND_FILESIZE_LIMIT", false))
    {
      paramView = this.mPhotoCommonData.selectedPhotoList.iterator();
      for (long l = 0L; paramView.hasNext(); l = aqhq.getFileSizes((String)paramView.next()) + l) {}
      if (ahav.amK())
      {
        ahal.a(this.mActivity, 2131693826, 2131693832, new zua(this));
        return;
      }
    }
    submit();
  }
  
  public void onTitleBtnCancelClick(View paramView)
  {
    aqfy.clearSelectItemInfo();
    aqfy.clearCache();
    paramView = PresendPicMgr.a();
    if (paramView != null) {
      paramView.IP(1006);
    }
    paramView = ((NewPhotoListActivity)this.mActivity).getIntent();
    if (this.mPhotoCommonData.selectedPhotoList != null) {}
    for (int i = this.mPhotoCommonData.selectedPhotoList.size();; i = 0)
    {
      zsz.k(paramView, i);
      if (this.a.bti) {
        break;
      }
      if (((zuc)this.mOtherCommonData).VO()) {
        rma.a().setData(rma.a().cj());
      }
      ((NewPhotoListActivity)this.mActivity).finish();
      aqfy.anim(this.mActivity, false, false);
      return;
    }
    paramView = ((NewPhotoListActivity)this.mActivity).getIntent();
    String str1 = paramView.getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
    String str2 = paramView.getStringExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME");
    if (str1 == null)
    {
      QQToast.a(this.mActivity, "请设置INIT_ACTIVITY_CLASS_NAME ", 0).show();
      return;
    }
    paramView.setClassName(str2, str1);
    paramView.removeExtra("PhotoConst.PHOTO_PATHS");
    paramView.removeExtra("PhotoConst.SINGLE_PHOTO_PATH");
    paramView.addFlags(603979776);
    ((NewPhotoListActivity)this.mActivity).startActivity(paramView);
    ((NewPhotoListActivity)this.mActivity).finish();
    aqfy.anim(this.mActivity, false, false);
  }
  
  public void postInitUI()
  {
    Object localObject = ((NewPhotoListActivity)this.mActivity).bottomBar;
    int i;
    if ((this.a.isSingleMode) || (this.a.showMediaType == 2) || (((zuc)this.mOtherCommonData).VO()))
    {
      i = 8;
      ((View)localObject).setVisibility(i);
      ((NewPhotoListActivity)this.mActivity).previewBtn.setOnClickListener(this.mActivity);
      ((NewPhotoListActivity)this.mActivity).sendBtn.setOnClickListener(this.mActivity);
      if (!this.a.btm) {
        break label281;
      }
      ((NewPhotoListActivity)this.mActivity).magicStickBtn.setVisibility(0);
      ((NewPhotoListActivity)this.mActivity).magicStickBtn.setOnClickListener(this.mActivity);
    }
    for (;;)
    {
      if (this.a.btk) {
        ((NewPhotoListActivity)this.mActivity).qualityCheckBox.setOnCheckedChangeListener(this.mActivity);
      }
      updateButton();
      if (((zuc)this.mOtherCommonData).VO())
      {
        this.a.c = new rmd(this.mActivity, this);
        rma.a().a(this.a.c);
        rma.a().bf(this.mActivity);
        crU();
        if (((NewPhotoListActivity)this.mActivity).getIntent().getBooleanExtra("report_first_exposure", true))
        {
          localObject = (rmf)QQStoryContext.c().getBusinessHandler(1);
          if (localObject != null) {
            ((rmf)localObject).clear();
          }
          ((NewPhotoListActivity)this.mActivity).getIntent().putExtra("report_first_exposure", false);
        }
      }
      return;
      i = 0;
      break;
      label281:
      ((NewPhotoListActivity)this.mActivity).magicStickBtn.setVisibility(8);
    }
  }
  
  public void processQueryResult(List<LocalMediaInfo> paramList)
  {
    zsh.a(paramList, null, this.a.hy);
  }
  
  public void processViewCaseImage(AbstractPhotoListActivity.PhotoListAdapter.Holder paramHolder, LocalMediaInfo paramLocalMediaInfo)
  {
    if (zsh.a(paramLocalMediaInfo.path, this.a.hy))
    {
      if (Build.VERSION.SDK_INT >= 21) {
        paramHolder.mPhotoFlagView.setImageDrawable(((NewPhotoListActivity)this.mActivity).getDrawable(2130839600));
      }
      for (;;)
      {
        paramHolder.mPhotoFlagView.setVisibility(0);
        return;
        paramHolder.mPhotoFlagView.setImageResource(2130839600);
      }
    }
    paramHolder.mPhotoFlagView.setVisibility(8);
  }
  
  public void sA(String paramString)
  {
    Intent localIntent = ((NewPhotoListActivity)this.mActivity).getIntent();
    ArrayList localArrayList = this.mPhotoCommonData.selectedPhotoList;
    HashMap localHashMap = this.mPhotoCommonData.selectedMediaInfoHashMap;
    localIntent.putExtra("ALBUM_NAME", this.mPhotoCommonData.albumName);
    localIntent.putExtra("ALBUM_ID", this.mPhotoCommonData.albumId);
    localIntent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", localArrayList);
    localIntent.putStringArrayListExtra("PhotoConst.SELECTED_PATHS", localArrayList);
    int j = localArrayList.size();
    Object localObject = new ArrayList(j);
    int i = 0;
    while (i < j)
    {
      ((ArrayList)localObject).add(Integer.valueOf(i));
      i += 1;
    }
    localIntent.putIntegerArrayListExtra("PhotoConst.SELECTED_INDEXS", (ArrayList)localObject);
    i = localArrayList.indexOf(paramString);
    if ((i > 0) && (i < ((NewPhotoListActivity)this.mActivity).photoListAdapter.getCount()))
    {
      localObject = ((NewPhotoListActivity)this.mActivity).photoListAdapter.getItem(i);
      if ((localObject != null) && (!localHashMap.containsKey(((LocalMediaInfo)localObject).path))) {
        localHashMap.put(((LocalMediaInfo)localObject).path, localObject);
      }
    }
    localIntent.putExtra("PeakConstants.selectedMediaInfoHashMap", localHashMap);
    localIntent.putExtra("PhotoConst.SHOW_ALBUM", false);
    localIntent.putExtra("FROM_WHERE", "FROM_PHOTO_LIST");
    ztu.sPhotoListFirstPos = ((NewPhotoListActivity)this.mActivity).mGridView.getFirstVisiblePosition();
    localIntent.putExtra("PhotoConst.CURRENT_SELECTED_INDEX", localArrayList.indexOf(paramString));
    localIntent.setClass(this.mActivity, NewPhotoPreviewActivity.class);
    localIntent.addFlags(603979776);
    startPhotoPreviewActivity(localIntent);
    aqfy.anim(this.mActivity, true, true);
  }
  
  public void startPhotoPreviewActivity(Intent paramIntent)
  {
    super.startPhotoPreviewActivity(paramIntent);
  }
  
  protected void submit()
  {
    if (this.mPhotoCommonData.albumId.equals("$RecentAlbumId")) {
      anpc.a(this.mActivity).collectPerformance(null, "sendAlbumRecent", true, 0L, 0L, null, "");
    }
    PresendPicMgr localPresendPicMgr;
    for (;;)
    {
      localPresendPicMgr = PresendPicMgr.a();
      if ((!this.a.btm) || ((TextUtils.isEmpty(this.a.pasterId)) && (TextUtils.isEmpty(this.a.baR)))) {
        break;
      }
      ((NewPhotoListActivity)this.mActivity).magicStickBtn.performClick();
      return;
      if ((this.mPhotoCommonData.albumName.equalsIgnoreCase("Camera")) || (this.mPhotoCommonData.albumName.equalsIgnoreCase("camera")) || (this.mPhotoCommonData.albumName.contains("Camera")) || (this.mPhotoCommonData.albumName.contains("camera"))) {
        anpc.a(this.mActivity).collectPerformance(null, "sendAlbumRecent", false, 0L, 0L, null, "");
      } else {
        anpc.a(this.mActivity).collectPerformance(null, "sendAlbumOther", true, 0L, 0L, null, "");
      }
    }
    if (this.mPhotoCommonData.selectedPhotoList != null)
    {
      zsz.j(((NewPhotoListActivity)this.mActivity).getIntent(), this.mPhotoCommonData.selectedPhotoList.size());
      zsz.d(((NewPhotoListActivity)this.mActivity).getIntent(), this.mPhotoCommonData.selectedPhotoList.size(), this.mPhotoCommonData.currentQualityType);
    }
    Intent localIntent = ((NewPhotoListActivity)this.mActivity).getIntent();
    if (this.mPhotoCommonData.currentQualityType == 2)
    {
      if (localPresendPicMgr != null)
      {
        localPresendPicMgr.IP(1008);
        localPresendPicMgr.dDZ();
      }
      anot.a(null, "CliOper", "", "", "0X8005148", "0X8005148", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      localIntent.getStringExtra("PhotoConst.PLUGIN_APK");
      localIntent.getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
      if (this.mPhotoCommonData.needMediaInfo) {
        localIntent.putExtra("PeakConstants.selectedMediaInfoHashMap", this.mPhotoCommonData.selectedMediaInfoHashMap);
      }
      if (this.mPhotoCommonData.selectedPhotoList != null) {
        aarz.hJ(this.mPhotoCommonData.selectedPhotoList);
      }
      cL(localIntent);
      a(localIntent, false, this.mPhotoCommonData.selectedPhotoList);
      return;
      if ((localPresendPicMgr != null) && (!this.a.btr) && (!localIntent.getBooleanExtra("PhotoConst.SEND_NO_PRESEND", false))) {
        localPresendPicMgr.dD(localIntent);
      }
    }
  }
  
  public void updateButton()
  {
    super.updateButton();
    ArrayList localArrayList = this.mPhotoCommonData.selectedPhotoList;
    int i;
    if (localArrayList.size() > 0)
    {
      i = 1;
      if (QLog.isColorLevel()) {
        QLog.d("_photo", 2, "updateButton selectedPhotoList.size()=" + localArrayList.size());
      }
      if (i == 0)
      {
        ((NewPhotoListActivity)this.mActivity).qualityCheckBox.setChecked(false);
        ((NewPhotoListActivity)this.mActivity).qualityCheckBox.setEnabled(false);
        ((NewPhotoListActivity)this.mActivity).qualityTv.setEnabled(false);
        ((NewPhotoListActivity)this.mActivity).Nn.setEnabled(false);
      }
      if (!this.a.btm) {
        break label380;
      }
      if ((localArrayList.size() != 1) || ((((zuc)this.mOtherCommonData).selectedQzonePhotos != null) && (((zuc)this.mOtherCommonData).selectedQzonePhotos.size() > 0)) || (((NewPhotoListActivity)this.mActivity).getMediaType((String)localArrayList.get(0)) != 0)) {
        break label363;
      }
      ((NewPhotoListActivity)this.mActivity).magicStickBtn.setEnabled(true);
    }
    for (;;)
    {
      ((NewPhotoListActivity)this.mActivity).qualityCheckBox.setVisibility(8);
      ((NewPhotoListActivity)this.mActivity).qualityTv.setVisibility(8);
      ((NewPhotoListActivity)this.mActivity).Nn.setVisibility(8);
      if (this.a.btk)
      {
        ((NewPhotoListActivity)this.mActivity).qualityCheckBox.setVisibility(0);
        ((NewPhotoListActivity)this.mActivity).qualityTv.setVisibility(0);
        if (i != 0)
        {
          ((NewPhotoListActivity)this.mActivity).qualityCheckBox.setEnabled(true);
          ((NewPhotoListActivity)this.mActivity).qualityTv.setEnabled(true);
          ((NewPhotoListActivity)this.mActivity).Nn.setEnabled(true);
        }
      }
      cfa();
      if (!this.a.btl) {
        ((NewPhotoListActivity)this.mActivity).Nn.setVisibility(8);
      }
      return;
      i = 0;
      break;
      label363:
      ((NewPhotoListActivity)this.mActivity).magicStickBtn.setEnabled(false);
      continue;
      label380:
      ((NewPhotoListActivity)this.mActivity).magicStickBtn.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     ztv
 * JD-Core Version:    0.7.0.1
 */