import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.takevideo.slideshow.SlideItemInfo;
import com.tencent.component.media.image.ImageManager;
import com.tencent.mobileqq.activity.PublicFragmentActivity.b;
import com.tencent.mobileqq.activity.PublicFragmentActivityForPeak;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.activity.photo.QzonePhotoPreviewActivity;
import com.tencent.mobileqq.activity.photo.album.AbstractPhotoListActivity.CheckBoxClickedListener;
import com.tencent.mobileqq.activity.photo.album.AbstractPhotoListActivity.PhotoListAdapter;
import com.tencent.mobileqq.activity.photo.album.AbstractPhotoListActivity.PhotoListAdapter.Holder;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.activity.photo.album.NewPhotoPreviewActivity;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.mobileqq.activity.photo.album.logicImp.PhotoListLogicQzone.2;
import com.tencent.mobileqq.activity.shortvideo.SendVideoActivity.SendVideoInfo;
import com.tencent.mobileqq.activity.shortvideo.ShortVideoPreviewActivity;
import com.tencent.mobileqq.pic.PresendPicMgr;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.AdapterView;
import com.tencent.widget.GestureSelectGridView;
import common.config.service.QzoneConfig;
import cooperation.qzone.QZoneVideoDownloadActivity;
import cooperation.qzone.QzonePluginProxyActivity;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.thread.QzoneBaseThread;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.QZLog;
import dov.com.tencent.biz.qqstory.takevideo.EditPicActivity;
import dov.com.tencent.mobileqq.activity.richmedia.QzoneEditPictureActivity;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class zvm
  extends ztv
{
  public static boolean btQ;
  public static boolean ss;
  int CP = 0;
  private int HM;
  private LinkedHashMap<String, LocalMediaInfo> J;
  long LB;
  public String baW = "";
  private boolean btK;
  boolean btL = false;
  boolean btM = false;
  boolean btN = false;
  boolean btO = false;
  private boolean btP;
  protected boolean btR;
  private boolean btS;
  boolean btT = false;
  boolean btU = false;
  private boolean btV;
  private boolean btW;
  private boolean btX;
  int cfh;
  HashMap<String, Integer> hC;
  boolean pN;
  boolean sq;
  private String vc = "";
  
  zvm(NewPhotoListActivity paramNewPhotoListActivity)
  {
    super(paramNewPhotoListActivity);
  }
  
  private void FD(int paramInt)
  {
    HashMap localHashMap = new HashMap();
    switch (paramInt)
    {
    }
    while (localHashMap.size() > 0)
    {
      QLog.i("PhotoListActivity", 2, "begin report");
      anpc.a(BaseApplication.getContext()).collectPerformance(null, "qzoneChoosePhotoCamera", true, 0L, 0L, localHashMap, null, true);
      return;
      if (!this.btK)
      {
        this.btK = true;
        localHashMap.put("exposure", "1");
        QLog.i("PhotoListActivity", 2, "exposure");
        continue;
        localHashMap.put("click_fail", "1");
        QLog.i("PhotoListActivity", 2, "click_fail");
        continue;
        localHashMap.put("click_pass", "1");
        QLog.i("PhotoListActivity", 2, "click_pass");
        continue;
        localHashMap.put("result_video", "1");
        QLog.i("PhotoListActivity", 2, "result_video");
        continue;
        localHashMap.put("result_photo", "1");
        QLog.i("PhotoListActivity", 2, "result_photo");
      }
    }
    QLog.i("PhotoListActivity", 2, "no param");
  }
  
  private void FE(int paramInt)
  {
    int i = 2;
    if (TextUtils.isEmpty(this.vc)) {
      return;
    }
    int m = this.mPhotoCommonData.selectedPhotoList.size();
    int k;
    int j;
    if (m == 0)
    {
      k = 601;
      j = 0;
      switch (paramInt)
      {
      default: 
        return;
      case 2131369579: 
        i = 3;
      }
    }
    for (;;)
    {
      if ((this.CP != 1) || (paramInt != 2131377990)) {
        break label156;
      }
      LpReportInfo_pf00064.allReport(586, 47, 3, String.valueOf(m));
      return;
      k = 600;
      if (m == 1)
      {
        j = 1;
        break;
      }
      j = 2;
      break;
      i = 4;
      continue;
      i = 1;
      continue;
      i = 5;
    }
    label156:
    LpReportInfo_pf00064.allReport(k, j, i);
  }
  
  private void H(int paramInt, Intent paramIntent)
  {
    Intent localIntent = ((NewPhotoListActivity)this.mActivity).getIntent();
    localIntent.putExtra("ALBUM_NAME", this.mPhotoCommonData.albumName);
    localIntent.putExtra("ALBUM_ID", this.mPhotoCommonData.albumId);
    LocalMediaInfo localLocalMediaInfo = ((NewPhotoListActivity)this.mActivity).photoListAdapter.getItem(paramInt);
    int i = localLocalMediaInfo.position.intValue();
    paramInt = i;
    if (!btQ)
    {
      paramInt = i;
      if (aqfy.getMediaType(localLocalMediaInfo) == 1)
      {
        if (this.mPhotoCommonData.mediaPathsList == null) {
          break label607;
        }
        this.mPhotoCommonData.mediaPathsList.clear();
        this.mPhotoCommonData.mediaPathsList.add(localLocalMediaInfo.path);
        if (this.mPhotoCommonData.selectedPhotoList == null) {
          break label624;
        }
        this.mPhotoCommonData.selectedPhotoList.clear();
        label142:
        this.mPhotoCommonData.selectedPhotoList.add(localLocalMediaInfo.path);
        if (this.mPhotoCommonData.selectedIndex == null) {
          break label641;
        }
        this.mPhotoCommonData.selectedIndex.clear();
        label178:
        this.mPhotoCommonData.selectedIndex.add(Integer.valueOf(0));
        if (this.mPhotoCommonData.selectedMediaInfoHashMap == null) {
          break label658;
        }
        this.mPhotoCommonData.selectedMediaInfoHashMap.clear();
        label213:
        this.mPhotoCommonData.selectedMediaInfoHashMap.put(localLocalMediaInfo.path, localLocalMediaInfo);
        paramInt = 0;
        localIntent.putExtra("PhotoConst.IS_SINGLE_MODE", true);
      }
    }
    localIntent.putExtra("PhotoConst.CURRENT_SELECTED_INDEX", paramInt);
    localIntent.putStringArrayListExtra("PhotoConst.SELECTED_PATHS", this.mPhotoCommonData.selectedPhotoList);
    localIntent.putIntegerArrayListExtra("PhotoConst.SELECTED_INDEXS", this.mPhotoCommonData.selectedIndex);
    localIntent.putExtra("FROM_WHERE", "FROM_PHOTO_LIST");
    localIntent.putExtra("PhotoConst.CURRENT_QUALITY_TYPE", this.mPhotoCommonData.currentQualityType);
    localIntent.putExtra("PhotoConst.SHOW_ALBUM", true);
    localIntent.putExtra("PhotoConst.SHOW_MAGIC_USE_PASTER", this.a.btm);
    localIntent.putExtra("PasterConstants.paster_id", this.a.pasterId);
    localIntent.putExtra("PasterConstants.paster_cate_id", this.a.baR);
    ztu.sPhotoListFirstPos = ((NewPhotoListActivity)this.mActivity).mGridView.getFirstVisiblePosition();
    if (!this.mPhotoCommonData.selectedMediaInfoHashMap.containsKey(localLocalMediaInfo.path)) {
      this.mPhotoCommonData.selectedMediaInfoHashMap.put(localLocalMediaInfo.path, localLocalMediaInfo);
    }
    localIntent.putExtra("PeakConstants.selectedMediaInfoHashMap", this.mPhotoCommonData.selectedMediaInfoHashMap);
    localIntent.putExtra("PasterConstants.pasters_data", this.a.hx);
    localIntent.setClass(this.mActivity, NewPhotoPreviewActivity.class);
    if (this.btM) {
      paramIntent.putExtra("PhotoConst.IS_FROM_SHUOSHUO", this.btM);
    }
    localIntent.putExtra("from_qzone", this.btS);
    localIntent.addFlags(603979776);
    if ((this.mPhotoCommonData.selectedPhotoList != null) && (this.mPhotoCommonData.selectedPhotoList.size() > 0)) {
      anot.b(null, "CliOper", "", this.mPhotoCommonData.myUin, "0X8005674", "0X8005674", 0, this.mPhotoCommonData.selectedPhotoList.size(), 0, "", "", "", "");
    }
    if (((zuc)this.mOtherCommonData).VO()) {
      ((NewPhotoListActivity)this.mActivity).startActivityForResult(paramIntent, 100010);
    }
    for (;;)
    {
      aqfy.anim(this.mActivity, true, true);
      return;
      label607:
      this.mPhotoCommonData.mediaPathsList = new ArrayList();
      break;
      label624:
      this.mPhotoCommonData.selectedPhotoList = new ArrayList();
      break label142;
      label641:
      this.mPhotoCommonData.selectedIndex = new ArrayList();
      break label178;
      label658:
      this.mPhotoCommonData.selectedMediaInfoHashMap = new HashMap();
      break label213;
      ((NewPhotoListActivity)this.mActivity).startActivity(localIntent);
      ((NewPhotoListActivity)this.mActivity).finish();
    }
  }
  
  private void a(LocalMediaInfo paramLocalMediaInfo, Intent paramIntent)
  {
    paramIntent.putExtra("file_send_path", paramLocalMediaInfo.path);
    paramIntent.putExtra("PhotoConst.IS_VIDEO_SELECTED", true);
    paramIntent.putExtra("PhotoConst.VIDEO_SIZE", paramLocalMediaInfo.fileSize);
    paramIntent.putExtra("file_send_duration", paramLocalMediaInfo.mDuration);
    paramIntent.putExtra("file_width", paramLocalMediaInfo.mediaWidth);
    paramIntent.putExtra("file_height", paramLocalMediaInfo.mediaHeight);
    paramIntent.putExtra("media_info", paramLocalMediaInfo);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramLocalMediaInfo.path);
    PhotoUtils.a(this.mActivity, paramIntent, localArrayList, 2, false);
  }
  
  private boolean a(LocalMediaInfo paramLocalMediaInfo, Intent paramIntent, String paramString)
  {
    boolean bool = true;
    if (this.btR) {
      if ("qzone_plugin.apk".equals(paramString))
      {
        paramString = paramIntent.getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
        if ((paramString == null) || (paramString.contains("TrimVideoActivity"))) {
          break label245;
        }
        if ((this.mPhotoCommonData.selectedPhotoList != null) && (this.mPhotoCommonData.selectedPhotoList.size() > 0))
        {
          QQToast.a(this.mActivity, "不能同时选择照片和视频", 0).show();
          this.a.btj = false;
          return true;
        }
        if (paramLocalMediaInfo.mDuration >= this.mPhotoCommonData.videoDurationLimit) {
          break label115;
        }
        this.a.btj = true;
      }
    }
    for (;;)
    {
      return false;
      label115:
      this.a.btj = false;
      paramLocalMediaInfo = new StringBuilder();
      long l = this.mPhotoCommonData.videoDurationLimit / 1000L;
      if (l > 60L)
      {
        l /= 60L;
        if (l > 60L) {
          paramLocalMediaInfo.append(l / 60L).append("小时");
        }
      }
      for (;;)
      {
        paramLocalMediaInfo.append("以上的视频不可选");
        QQToast.a(this.mActivity, paramLocalMediaInfo.toString(), 0).show();
        return true;
        paramLocalMediaInfo.append(l).append("分钟");
        continue;
        paramLocalMediaInfo.append(l).append("秒");
      }
      label245:
      if (((zuc)this.mOtherCommonData).VO())
      {
        this.a.btj = true;
      }
      else
      {
        paramString = this.a;
        if (paramLocalMediaInfo.mDuration > this.mPhotoCommonData.videoDurationLimit) {}
        for (bool = true;; bool = false)
        {
          paramString.btj = bool;
          paramIntent.putExtra("PhotoConst.IS_PREVIEW_VIDEO", this.a.btj);
          break;
        }
        if ("qzone_plugin.apk".equals(paramString))
        {
          paramString = paramIntent.getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
          if ((paramString != null) && (!paramString.contains("TrimVideoActivity")))
          {
            if ((this.sq) || (paramLocalMediaInfo.mDuration > this.mPhotoCommonData.videoDurationLimit) || (this.btL) || ((this.btM) && (btQ)))
            {
              this.a.btj = true;
            }
            else
            {
              this.a.btj = false;
              paramIntent.putExtra("support_record", false);
              paramIntent.putExtra("support_trim", true);
              paramIntent.putExtra("PhotoConst.IS_CALL_IN_PLUGIN", false);
              paramIntent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
              paramIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", "cooperation.qzone.QZoneVideoDownloadActivity");
              paramIntent.putExtra("PhotoConst.SHOW_MAGIC_USE_PASTER", this.a.btm);
            }
          }
          else
          {
            if (!((zuc)this.mOtherCommonData).VO()) {
              break;
            }
            this.a.btj = true;
          }
        }
      }
    }
    paramString = this.a;
    if (paramLocalMediaInfo.mDuration > this.mPhotoCommonData.videoDurationLimit) {}
    for (;;)
    {
      paramString.btj = bool;
      paramIntent.putExtra("PhotoConst.IS_PREVIEW_VIDEO", this.a.btj);
      break;
      bool = false;
    }
  }
  
  private Intent b(Intent paramIntent, String paramString)
  {
    if ((this.btM) || (this.btL) || (this.btN) || (this.btW) || (this.btS)) {
      paramIntent = QzoneEditPictureActivity.d(this.mActivity, paramString);
    }
    return paramIntent;
  }
  
  private void b(LocalMediaInfo paramLocalMediaInfo, Intent paramIntent)
  {
    Intent localIntent = new Intent(this.mActivity, ShortVideoPreviewActivity.class);
    localIntent.putExtras(paramIntent);
    localIntent.putExtra("file_send_path", paramLocalMediaInfo.path);
    localIntent.putExtra("file_send_size", paramLocalMediaInfo.fileSize);
    localIntent.putExtra("file_send_duration", paramLocalMediaInfo.mDuration);
    localIntent.putExtra("file_width", paramLocalMediaInfo.mediaWidth);
    localIntent.putExtra("file_height", paramLocalMediaInfo.mediaHeight);
    localIntent.putExtra("uin", this.a.friendUin);
    localIntent.putExtra("uintype", this.a.cZ);
    localIntent.putExtra("file_source", "album");
    localIntent.putExtra("is_from_system_media", paramLocalMediaInfo.isSystemMeidaStore);
    if (this.a.isSupportVideoCheckbox)
    {
      localIntent.putExtra("PhotoConst.IS_SUPPORT_VIDEO_CHECKBOX", true);
      localIntent.putExtra("PhotoConst.PHOTO_PATHS", this.mPhotoCommonData.selectedPhotoList);
    }
    if (((this.btL) || ((this.btM) && (btQ) && (!ss))) && (this.a.isSupportVideoCheckbox)) {
      localIntent.putExtra("preview_only", true);
    }
    ((NewPhotoListActivity)this.mActivity).startActivityForResult(localIntent, 17);
  }
  
  private void cO(Intent paramIntent)
  {
    this.baW = paramIntent.getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
    this.sq = paramIntent.getBooleanExtra("PhotoConst.IS_TRIM_VIDEO_BLACK_LIST", false);
    this.btT = paramIntent.getBooleanExtra("PhotoConst.IS_FROM_DYNAMIC_ALBUM", false);
    this.pN = paramIntent.getBooleanExtra("PhotoConst.IS_FROM_P2V", false);
    this.btP = paramIntent.getBooleanExtra("NEED_QZONE_MACHINE_LEARNING_REPORT", false);
    btQ = paramIntent.getBooleanExtra("QZONE_SUPPORT_MIX_MOOD", false);
    this.btR = paramIntent.getBooleanExtra("QZONE_PEAK_SUPPORT_VIDEO_EDIT_WHEN_PREVIEW", false);
    ss = paramIntent.getBooleanExtra("upload_single_video", false);
    this.CP = paramIntent.getIntExtra("PhotoConst.KEY_SHOW_TYPE", 0);
    this.HM = paramIntent.getIntExtra("PhotoConst.KEY_SHOW_TYPE", -1);
    this.hC = ((HashMap)paramIntent.getSerializableExtra("PhotoConst.PANORAMA_IMAGES"));
    this.btU = paramIntent.getBooleanExtra("PhotoConst.IS_NO_PANORAMA", false);
    this.LB = paramIntent.getLongExtra("PhotoConst.QZONE_COVER_PHOTOLIST_KEY_VIDEO_DURATION", 9223372036854775807L);
    this.btW = paramIntent.getBooleanExtra("from_qzoneshare", false);
    this.vc = paramIntent.getStringExtra("report_from");
  }
  
  private void cP(Intent paramIntent)
  {
    if (paramIntent != null) {
      try
      {
        if (this.J == null) {
          return;
        }
        paramIntent = paramIntent.getSerializableExtra("qzone_album_machine_learning_exposed_media_list");
        if (paramIntent != null)
        {
          paramIntent = ((List)paramIntent).iterator();
          while (paramIntent.hasNext())
          {
            LocalMediaInfo localLocalMediaInfo = (LocalMediaInfo)paramIntent.next();
            this.J.put(localLocalMediaInfo.path, localLocalMediaInfo);
          }
        }
        return;
      }
      catch (Exception paramIntent)
      {
        QLog.e("PhotoListActivity", 2, "restoreUnSelectedExposedData error!", paramIntent);
      }
    }
  }
  
  private void cQ(Intent paramIntent)
  {
    if ((this.mPhotoCommonData.selectedMediaInfoHashMap == null) || (this.J == null)) {
      return;
    }
    for (;;)
    {
      try
      {
        if ((!this.btX) && (((NewPhotoListActivity)this.mActivity).photoListAdapter != null) && (((NewPhotoListActivity)this.mActivity).photoListAdapter.getCount() > 0)) {
          csb();
        }
        int j = QzoneConfig.getInstance().getConfig("PhotoAlbum", "MachineLearningExposedMediaUpperBound", 50) - this.mPhotoCommonData.selectedMediaInfoHashMap.size();
        if (j <= 0) {
          break;
        }
        int i = 0;
        ArrayList localArrayList = new ArrayList();
        Iterator localIterator = this.J.entrySet().iterator();
        if ((localIterator.hasNext()) && (i < j))
        {
          LocalMediaInfo localLocalMediaInfo = (LocalMediaInfo)((Map.Entry)localIterator.next()).getValue();
          if (!this.mPhotoCommonData.selectedMediaInfoHashMap.containsKey(localLocalMediaInfo.path))
          {
            localArrayList.add(localLocalMediaInfo);
            i += 1;
          }
        }
        else
        {
          paramIntent.putExtra("qzone_album_machine_learning_exposed_media_list", (Serializable)localArrayList);
          return;
        }
      }
      catch (Exception paramIntent)
      {
        QLog.e("PhotoListActivity", 2, "prepareExposedMediaInfo error!", paramIntent);
        return;
      }
    }
  }
  
  private void cR(Intent paramIntent)
  {
    String str1 = paramIntent.getStringExtra("PhotoConst.PLUGIN_APK");
    String str2 = paramIntent.getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
    if (("qzone_plugin.apk".equals(str1)) && ("com.qzone.video.activity.TrimVideoActivity".equals(str2)))
    {
      paramIntent.putExtra("PhotoConst.PLUGIN_NAME", "QZone");
      paramIntent.putExtra("PhotoConst.PLUGIN_APK", "qzone_plugin.apk");
      paramIntent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
      paramIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", "com.qzone.publish.ui.activity.QZonePublishMoodRealActivity");
    }
    if ("qzone_plugin.apk".equals(str1)) {
      paramIntent.putExtra("isEmbedInTabActivity", paramIntent.getBooleanExtra("isEmbedInTabActivity", false));
    }
    if ((this.btL) || ((this.btM) && (btQ)) || (this.btO)) {
      paramIntent.putExtra("PeakConstants.selectedMediaInfoHashMap", this.mPhotoCommonData.selectedMediaInfoHashMap);
    }
    if (this.btP) {
      cQ(paramIntent);
    }
    if (this.mPhotoCommonData.selectedPhotoList != null) {
      aarz.hJ(this.mPhotoCommonData.selectedPhotoList);
    }
    cL(paramIntent);
    paramIntent.putExtra("PhotoConst.PANORAMA_IMAGES", this.hC);
    if (1 == this.CP)
    {
      paramIntent.putExtra("PhotoConst.KEY_SHOW_TYPE", 1);
      paramIntent.putExtra("PhotoConst.KEY_SHOW_ORIGIN_TYPE", 1);
    }
    for (;;)
    {
      paramIntent.putExtra("key_state_type", this.HM);
      a(paramIntent, false, this.mPhotoCommonData.selectedPhotoList);
      return;
      paramIntent.putExtra("PhotoConst.KEY_SHOW_TYPE", 0);
    }
  }
  
  private void crZ()
  {
    Object localObject = this.mPhotoCommonData.selectedPhotoList.iterator();
    int j = 0;
    int i = 0;
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      if ((this.mPhotoCommonData.selectedMediaInfoHashMap.containsKey(str)) && (aqfy.getMediaType((LocalMediaInfo)this.mPhotoCommonData.selectedMediaInfoHashMap.get(str)) == 1))
      {
        ((Iterator)localObject).remove();
        i = 1;
      }
      else if ((!this.mPhotoCommonData.selectedMediaInfoHashMap.containsKey(str)) && (!str.startsWith("http://qzs.qq.com")) && (!str.startsWith("https://qzs.qq.com")) && (str.toLowerCase().endsWith(".gif")))
      {
        ((Iterator)localObject).remove();
        j = 1;
      }
    }
    localObject = null;
    if (this.mPhotoCommonData.selectedPhotoList.size() > this.mPhotoCommonData.maxSelectNum)
    {
      localObject = ((NewPhotoListActivity)this.mActivity).getResources().getString(2131696887, new Object[] { Integer.valueOf(this.mPhotoCommonData.maxSelectNum) });
      this.mPhotoCommonData.selectedPhotoList.subList(this.mPhotoCommonData.maxSelectNum, this.mPhotoCommonData.selectedPhotoList.size()).clear();
    }
    for (;;)
    {
      if (localObject != null) {
        QQToast.a(this.mActivity, (CharSequence)localObject, 0).show(((NewPhotoListActivity)this.mActivity).mTitleBarHeight);
      }
      return;
      if (i != 0) {
        localObject = ((NewPhotoListActivity)this.mActivity).getResources().getString(2131696892);
      } else if (j != 0) {
        localObject = ((NewPhotoListActivity)this.mActivity).getResources().getString(2131696891);
      }
    }
  }
  
  private void csa()
  {
    Iterator localIterator = this.mPhotoCommonData.selectedPhotoList.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (aqfy.getMediaType((LocalMediaInfo)this.mPhotoCommonData.selectedMediaInfoHashMap.get(str)) == 1) {
        localIterator.remove();
      }
    }
  }
  
  private void csb()
  {
    if ((((NewPhotoListActivity)this.mActivity).mGridView == null) || (this.J == null)) {
      return;
    }
    Object localObject = d(((NewPhotoListActivity)this.mActivity).mGridView.getFirstVisiblePosition(), ((NewPhotoListActivity)this.mActivity).mGridView.getLastVisiblePosition());
    if ((localObject != null) && (this.J != null))
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        LocalMediaInfo localLocalMediaInfo = (LocalMediaInfo)((Iterator)localObject).next();
        if (!this.J.containsKey(localLocalMediaInfo.path)) {
          this.J.put(localLocalMediaInfo.path, localLocalMediaInfo);
        }
      }
    }
    this.btX = true;
  }
  
  private void csc()
  {
    if ((this.mPhotoCommonData.selectedPhotoList != null) && (this.mPhotoCommonData.selectedPhotoList.size() != 0))
    {
      int i = 0;
      if (i < this.mPhotoCommonData.selectedPhotoList.size())
      {
        String str = (String)this.mPhotoCommonData.selectedPhotoList.get(i);
        int j;
        if (TextUtils.isEmpty(str))
        {
          QZLog.e("PhotoListActivity:QueryPhotoTask", "doInBackground: filter photo error, tempPath null");
          j = i;
        }
        for (;;)
        {
          i = j + 1;
          break;
          j = i;
          if (!new File(str).exists()) {
            if ((str.startsWith("http")) && (((zuc)this.mOtherCommonData).selectedQzonePhotos != null))
            {
              j = i;
              if (((zuc)this.mOtherCommonData).selectedQzonePhotos.containsKey(str)) {}
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
                  if (this.mPhotoCommonData.selectedMediaInfoHashMap.containsKey(str))
                  {
                    this.mPhotoCommonData.selectedMediaInfoHashMap.remove(str);
                    j = i;
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  private void csd()
  {
    Object localObject = avqw.b();
    if ((!((avqw.a)localObject).isAvailable()) || (!alwy.auJ()))
    {
      String str = QzoneConfig.getInstance().getConfig("QZoneTextSetting", "PhotoListCameraNotSupport", "当前不支持拍摄");
      if ((((avqw.a)localObject).getTip() != null) && (((avqw.a)localObject).aLp()))
      {
        str = QzoneConfig.getInstance().getConfig("QZoneTextSetting", "ToastStartLiveVideoFailForMemory", "SD卡不存在或手机内存不足");
        QQToast.a(this.mActivity, str, 0).show();
      }
      for (;;)
      {
        if (((avqw.a)localObject).getTip() != null) {
          QZLog.e("PhotoListActivity", 2, new Object[] { "gotoCamera fail", ((avqw.a)localObject).getTip() });
        }
        FD(2);
        return;
        QQToast.a(this.mActivity, str, 0).show();
      }
    }
    localObject = new Intent(this.mActivity, QZoneVideoDownloadActivity.class);
    ((Intent)localObject).putExtra("extra.busi_type", 3);
    ((Intent)localObject).putExtra("extra_directly_back", true);
    ((Intent)localObject).putExtra("PhotoConst.PLUGIN_APK", "qzone_plugin.apk");
    ((Intent)localObject).putExtra("DirectBackToQzone", true);
    ((Intent)localObject).putExtra("PhotoConst.PHOTO_SELECT_ACTIVITY_CLASS_NAME", NewPhotoListActivity.class.getName());
    ((Intent)localObject).putExtra("pic_confirm_text", ((NewPhotoListActivity)this.mActivity).getString(2131696878));
    ((Intent)localObject).putExtra("enable_edit_video", true);
    ((Intent)localObject).putExtra("enable_input_text", false);
    ((Intent)localObject).putExtra("enable_priv_list", false);
    ((Intent)localObject).putExtra("entry_source", 5);
    ((Intent)localObject).putExtra("support_record", true);
    ((Intent)localObject).putExtra("enable_local_video", false);
    ((Intent)localObject).putExtra("enable_local_button", false);
    ((Intent)localObject).putExtra("go_publish_activity", false);
    ((Intent)localObject).putExtra("enterPtu", false);
    if ("$VideoAlbumId".equals(this.mPhotoCommonData.albumId)) {
      ((Intent)localObject).putExtra("support_pic", false);
    }
    for (;;)
    {
      ((Intent)localObject).putExtra("key_latitude", ((NewPhotoListActivity)this.mActivity).getIntent().getDoubleExtra("key_latitude", 4.9E-324D));
      ((Intent)localObject).putExtra("key_longtitude", ((NewPhotoListActivity)this.mActivity).getIntent().getDoubleExtra("key_longtitude", 4.9E-324D));
      ((NewPhotoListActivity)this.mActivity).startActivity((Intent)localObject);
      FD(3);
      return;
      ((Intent)localObject).putExtra("support_pic", true);
    }
  }
  
  private List<LocalMediaInfo> d(int paramInt1, int paramInt2)
  {
    ArrayList localArrayList = new ArrayList();
    for (;;)
    {
      if ((paramInt1 >= 0) && (paramInt2 >= 0) && (paramInt1 <= paramInt2) && (paramInt1 <= paramInt2)) {
        try
        {
          if (paramInt1 < ((NewPhotoListActivity)this.mActivity).photoListAdapter.getCount())
          {
            LocalMediaInfo localLocalMediaInfo = ((NewPhotoListActivity)this.mActivity).photoListAdapter.getItem(paramInt1);
            if (localLocalMediaInfo.mMimeType.equals("image/jpeg")) {
              localArrayList.add(localLocalMediaInfo);
            }
          }
          paramInt1 += 1;
        }
        catch (Exception localException)
        {
          QLog.e("PhotoListActivity", 2, "getExposedMedia error!", localException);
        }
      }
    }
    return localArrayList;
  }
  
  private void hq(List<LocalMediaInfo> paramList)
  {
    QzoneHandlerThreadFactory.getHandlerThread("Normal_HandlerThread").post(new PhotoListLogicQzone.2(this, paramList));
  }
  
  private void i(LocalMediaInfo paramLocalMediaInfo)
  {
    awdr.a().a(new zvo(this, paramLocalMediaInfo));
  }
  
  private boolean iw(String paramString)
  {
    return "com.qzone.publish.ui.activity.QZoneUploadPhotoRealActivity".equals(paramString);
  }
  
  private boolean ix(String paramString)
  {
    return ("com.qzone.publish.ui.activity.QZonePublishMoodTabActivity".equals(paramString)) || ("com.qzone.publish.ui.activity.QZonePublishMoodRealActivity".equals(paramString)) || ("com.tencent.pubaccount.publish.QQPublicAccountPublishFeedActivity".equals(paramString)) || ("com.tencent.qcircle.QCirclePublishFeedActivity".equals(paramString));
  }
  
  private boolean iy(String paramString)
  {
    return "com.qzone.publish.ui.activity.QZonePublishVoiceMoodActivity".equals(paramString);
  }
  
  private boolean iz(String paramString)
  {
    return ("com.qzone.publish.ui.activity.QZoneUploadPhotoRealActivity".equals(paramString)) || ("com.qzone.publish.ui.activity.QZonePublishMoodRealActivity".equals(paramString)) || ("com.qzone.publish.ui.activity.QZonePublishMoodTabActivity".equals(paramString)) || ("com.qzone.common.activities.FeedActionPanelActivity".equals(paramString)) || ("com.tencent.pubaccount.publish.QQPublicAccountPublishFeedActivity".equals(paramString)) || (this.btT) || (this.btO);
  }
  
  private ArrayList<String> y(String paramString)
  {
    localArrayList = new ArrayList();
    try
    {
      paramString = paramString.split(";");
      if ((paramString != null) && (paramString.length > 0))
      {
        int i = 0;
        while (i < paramString.length)
        {
          localArrayList.add(paramString[i]);
          i += 1;
        }
      }
      return localArrayList;
    }
    catch (NullPointerException paramString)
    {
      QLog.e("PhotoListActivity", 2, "parseBlockPaths error!");
    }
  }
  
  protected void a(Intent paramIntent, boolean paramBoolean, ArrayList<String> paramArrayList)
  {
    int i2 = PhotoUtils.c(this.a.sessionInfo);
    paramArrayList = new HashMap();
    int j = 0;
    int i = 0;
    int i1 = 0;
    int k = 0;
    while (i1 < this.mPhotoCommonData.selectedPhotoList.size())
    {
      Object localObject = (String)this.mPhotoCommonData.selectedPhotoList.get(i1);
      int m;
      if (ImageManager.isNetworkUrl((String)localObject))
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
        if (((NewPhotoListActivity)this.mActivity).getMediaType((String)localObject) == 1)
        {
          localObject = ((NewPhotoListActivity)this.mActivity).getMediaInfo((String)localObject);
          n = j;
          m = i;
          if (localObject != null)
          {
            SendVideoActivity.SendVideoInfo localSendVideoInfo = new SendVideoActivity.SendVideoInfo();
            localSendVideoInfo.fileSize = ((LocalMediaInfo)localObject).fileSize;
            localSendVideoInfo.duration = ((LocalMediaInfo)localObject).mDuration;
            paramArrayList.put(Integer.valueOf(k), localSendVideoInfo);
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
    if (!paramArrayList.isEmpty()) {
      paramIntent.putExtra("PhotoConst.VIDEO_INFOS", paramArrayList);
    }
    if (paramBoolean) {
      PhotoUtils.a(this.mActivity, paramIntent, this.mPhotoCommonData.selectedPhotoList, this.a.hw, this.mPhotoCommonData.currentQualityType, false);
    }
    for (;;)
    {
      anot.a(null, "CliOper", "", "", "0X8009AB0", "0X8009AB0", i2, 0, String.valueOf(j), String.valueOf(i), "", "");
      return;
      PhotoUtils.a(this.mActivity, paramIntent, this.mPhotoCommonData.selectedPhotoList, this.mPhotoCommonData.currentQualityType, this.a.bjL);
    }
  }
  
  public void a(SlideItemInfo paramSlideItemInfo)
  {
    Object localObject = ((NewPhotoListActivity)this.mActivity).photoListAdapter;
    int i;
    if ((localObject != null) && (paramSlideItemInfo != null))
    {
      List localList = ((AbstractPhotoListActivity.PhotoListAdapter)localObject).getPhotoList();
      i = 0;
      if (i >= localList.size()) {
        break label97;
      }
      if (!((LocalMediaInfo)localList.get(i)).path.equals(paramSlideItemInfo.mSrcPath)) {
        break label90;
      }
    }
    for (;;)
    {
      if (i >= 0)
      {
        localObject = ((AbstractPhotoListActivity.PhotoListAdapter)localObject).getItem(i);
        this.hC.remove(((LocalMediaInfo)localObject).path);
      }
      super.a(paramSlideItemInfo);
      return;
      label90:
      i += 1;
      break;
      label97:
      i = -1;
    }
  }
  
  protected void a(LocalMediaInfo paramLocalMediaInfo, int paramInt)
  {
    Intent localIntent = ((NewPhotoListActivity)this.mActivity).getIntent();
    if ((!this.a.btn) && (!this.a.bto) && (this.btM)) {
      localIntent.putExtra("PhotoConst.IS_FROM_SHUOSHUO", this.btM);
    }
    super.a(paramLocalMediaInfo, paramInt);
  }
  
  public boolean addAndRemovePhotoByGesture(LocalMediaInfo paramLocalMediaInfo, boolean paramBoolean)
  {
    boolean bool1 = false;
    if (paramBoolean)
    {
      String[] arrayOfString = MimeHelper.getMimeType(paramLocalMediaInfo.mMimeType);
      if ((!this.a.isSupportVideoCheckbox) || (arrayOfString == null) || (!"video".equals(arrayOfString[0])) || (aqfy.a(this.mActivity, yp(), paramLocalMediaInfo, this.btM))) {}
    }
    boolean bool2;
    do
    {
      return bool1;
      bool2 = super.addAndRemovePhotoByGesture(paramLocalMediaInfo, paramBoolean);
      bool1 = bool2;
    } while (!bool2);
    if (paramBoolean)
    {
      this.hC.put(paramLocalMediaInfo.path, Integer.valueOf(paramLocalMediaInfo.panoramaPhotoType));
      return bool2;
    }
    this.hC.remove(paramLocalMediaInfo.path);
    return bool2;
  }
  
  public void caseCamera(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (!aqft.cC())
    {
      QQToast.a(this.mActivity, ((NewPhotoListActivity)this.mActivity).getResources().getString(2131719242), 0).show();
      return;
    }
    if ((this.btM) || (this.btL))
    {
      csd();
      return;
    }
    ((NewPhotoListActivity)this.mActivity).crP();
  }
  
  public Intent caseNoSingModeImage(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = super.caseNoSingModeImage(paramAdapterView, paramView, paramInt, paramLong);
    paramView = ((NewPhotoListActivity)this.mActivity).photoListAdapter.getItem(paramInt);
    ArrayList localArrayList1;
    ArrayList localArrayList2;
    int i;
    int k;
    if ((this.btM) && (!btQ) && (this.mPhotoCommonData.allMediaInfoHashMap != null))
    {
      localArrayList1 = new ArrayList();
      localArrayList2 = new ArrayList();
      i = paramInt - 1;
      int j = 0;
      int m = this.mPhotoCommonData.mediaPathsList.size();
      k = 0;
      if (k < m)
      {
        String str = (String)this.mPhotoCommonData.mediaPathsList.get(k);
        LocalMediaInfo localLocalMediaInfo = (LocalMediaInfo)this.mPhotoCommonData.allMediaInfoHashMap.get(str);
        if (aqfy.getMediaType(localLocalMediaInfo) != 0) {
          break label309;
        }
        localArrayList1.add(str);
        if ((this.mPhotoCommonData.selectedPhotoList != null) && (this.mPhotoCommonData.selectedPhotoList.contains(str))) {
          localArrayList2.add(Integer.valueOf(j));
        }
        if (localLocalMediaInfo.position.intValue() != paramInt - 1) {
          break label306;
        }
        i = j;
        label200:
        j += 1;
      }
    }
    label306:
    label309:
    for (;;)
    {
      k += 1;
      break;
      this.mPhotoCommonData.mediaPathsList = localArrayList1;
      paramAdapterView.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", localArrayList1);
      paramAdapterView.putStringArrayListExtra("PhotoConst.SELECTED_PATHS", this.mPhotoCommonData.selectedPhotoList);
      paramAdapterView.putIntegerArrayListExtra("PhotoConst.SELECTED_INDEXS", localArrayList2);
      if (aqfy.getMediaType(paramView) == 0) {
        paramAdapterView.putExtra("PhotoConst.CURRENT_SELECTED_INDEX", i);
      }
      paramAdapterView.putExtra("from_qzone", this.btS);
      if (this.btM) {
        paramAdapterView.putExtra("PhotoConst.IS_FROM_SHUOSHUO", this.btM);
      }
      return paramAdapterView;
      break label200;
    }
  }
  
  public void caseSingleModeImage(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    LocalMediaInfo localLocalMediaInfo = ((NewPhotoListActivity)this.mActivity).photoListAdapter.getItem(paramInt);
    if ((this.btN) && (localLocalMediaInfo.mediaWidth > 0) && (localLocalMediaInfo.mediaHeight > 0) && (this.cfh > 0) && (localLocalMediaInfo.fileSize > this.cfh))
    {
      QQToast.a(this.mActivity, ((NewPhotoListActivity)this.mActivity).getResources().getString(2131696968, new Object[] { Integer.valueOf(this.cfh / 1048576) }), 0).show(((NewPhotoListActivity)this.mActivity).getResources().getDimensionPixelSize(2131299627));
      return;
    }
    super.caseSingleModeImage(paramAdapterView, paramView, paramInt, paramLong);
  }
  
  public void caseVideo(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (!aqft.cC()) {
      QQToast.a(this.mActivity, ((NewPhotoListActivity)this.mActivity).getResources().getString(2131719242), 0).show();
    }
    String str1;
    label206:
    do
    {
      do
      {
        return;
        paramAdapterView = ((NewPhotoListActivity)this.mActivity).photoListAdapter.getItem(paramInt);
      } while (paramAdapterView == null);
      paramView = ((NewPhotoListActivity)this.mActivity).getIntent();
      str1 = paramView.getStringExtra("PhotoConst.PLUGIN_APK");
      String str2 = paramView.getStringExtra("video_refer");
      int i = 0;
      if (!TextUtils.isEmpty(str2))
      {
        if ((!str2.contains("QZonePublishMoodTabActivity")) && (!str2.contains("QZoneUploadPhotoRealActivity"))) {
          break label206;
        }
        i = 1;
      }
      while (i != 0)
      {
        paramLong = paramView.getLongExtra("PhotoConst.PHOTOLIST_KEY_VIDEO_CAN_UPLOAD_DURATION", 9223372036854775807L);
        if (paramAdapterView.mDuration > paramLong)
        {
          paramAdapterView = "请选择不超过" + paramLong / 60L / 1000L + "分钟的视频";
          QQToast.a(this.mActivity, paramAdapterView, 0).show(((NewPhotoListActivity)this.mActivity).getTitleBarHeight());
          return;
          i = 0;
        }
        else
        {
          paramLong = avpw.iO();
          if (paramAdapterView.fileSize > paramLong)
          {
            QQToast.a(this.mActivity, "请选择不超过" + (float)paramLong / 1024.0F / 1024.0F / 1024.0F + "G的视频", 0).show(((NewPhotoListActivity)this.mActivity).getTitleBarHeight());
            return;
          }
        }
      }
      if ((i == 0) && (paramAdapterView.fileSize > this.mPhotoCommonData.videoSizeLimit))
      {
        paramAdapterView = aqha.a(this.mActivity, "你选择的视频文件过大，无法发送。");
        paramAdapterView.setPositiveButton(2131721079, new aqha.a());
        paramAdapterView.show();
        return;
      }
      HashMap localHashMap = aqfy.sSelectItemAlbum;
      if (!localHashMap.containsKey(paramAdapterView.path))
      {
        Pair localPair = new Pair(this.mPhotoCommonData.albumId, this.mPhotoCommonData.albumName);
        localHashMap.put(paramAdapterView.path, localPair);
      }
      ((NewPhotoListActivity)this.mActivity).recordLastPos(paramAdapterView.path);
      if (("cover_mall_record_video".equals(str2)) && (paramAdapterView.mDuration / 1000L > this.LB / 1000L))
      {
        paramAdapterView = "视频时间不能超过" + this.LB / 1000L + "s，请重新选择";
        QQToast.a(this.mActivity, paramAdapterView, 0).show(((NewPhotoListActivity)this.mActivity).getTitleBarHeight());
        QLog.i("PhotoListActivity", 1, "QQToast:" + paramAdapterView);
        return;
      }
    } while (a(paramAdapterView, paramView, str1));
    if (!this.a.btj)
    {
      a(paramAdapterView, paramView);
      return;
    }
    if (((this.btL) || (this.btM) || (this.btO) || (((zuc)this.mOtherCommonData).VO())) && ((this.a.isSupportVideoCheckbox) || (this.btR)))
    {
      H(paramInt, paramView);
      return;
    }
    b(paramAdapterView, paramView);
  }
  
  public void enterAlbumListFragment(Intent paramIntent)
  {
    if (this.btP) {
      cQ(paramIntent);
    }
    if (this.btS)
    {
      paramIntent.putExtra("PhotoConst.IS_FROM_QZONE_AND_NEED_FILTER_RECENT_IMAGES", true);
      paramIntent.putExtra("PhotoConst.RECENT_IMAGES_MAX_COUNT", QzoneConfig.getInstance().getConfig("PhotoAlbum", "MaxRecentPhotoNum", 200));
      paramIntent.putExtra("PhotoConst.RECENT_IMAGES_LIMIT_SIZE", QzoneConfig.getInstance().getConfig("PhotoAlbum", "RecentPhotoLimitSize", 20480));
      paramIntent.putExtra("PhotoConst.RECENT_IMAGES_LIMIT_WIDTH", QzoneConfig.getInstance().getConfig("PhotoAlbum", "RecentPhotoLimitWidth", 100));
      String str = QzoneConfig.getInstance().getConfig("PhotoAlbum", "RecentPhotoBlockPaths", "MagazineUnlock");
      ArrayList localArrayList = null;
      if (str != null) {
        localArrayList = y(str);
      }
      paramIntent.putStringArrayListExtra("PhotoConst.RECENT_IMAGES_BLOCK_PATHS", localArrayList);
      paramIntent.putExtra("from_qzone", this.btS);
    }
    super.enterAlbumListFragment(paramIntent);
  }
  
  public void enterPhotoPreviewActivity(boolean paramBoolean, Intent paramIntent)
  {
    paramIntent.putExtra("from_qzone", this.btS);
    paramIntent.putExtra("readSource", this.vc);
    paramIntent.putExtra("p_e_s_type", 3);
    if (this.btM) {
      paramIntent.putExtra("PhotoConst.IS_FROM_SHUOSHUO", this.btM);
    }
    super.enterPhotoPreviewActivity(paramBoolean, paramIntent);
  }
  
  public String getExceedMaxSelectNumStr(LocalMediaInfo paramLocalMediaInfo)
  {
    String str2 = super.getExceedMaxSelectNumStr(paramLocalMediaInfo);
    long l = this.mPhotoCommonData.maxSelectNum;
    String str1 = str2;
    if (paramLocalMediaInfo != null)
    {
      paramLocalMediaInfo = MimeHelper.getMimeType(paramLocalMediaInfo.mMimeType);
      if ((yp() <= 0) && ((!this.a.isSupportVideoCheckbox) || (paramLocalMediaInfo == null) || (!"video".equals(paramLocalMediaInfo[0])))) {
        break label202;
      }
      if ((yp() == l) && (this.a.isSupportVideoCheckbox) && (paramLocalMediaInfo != null) && ("video".equals(paramLocalMediaInfo[0]))) {
        ((NewPhotoListActivity)this.mActivity).getResources().getString(2131696897, new Object[] { Long.valueOf(l) });
      }
      if (!((zuc)this.mOtherCommonData).VO()) {
        break label174;
      }
      str1 = ((NewPhotoListActivity)this.mActivity).getResources().getString(2131696896, new Object[] { Long.valueOf(l) });
    }
    label174:
    label202:
    do
    {
      return str1;
      return ((NewPhotoListActivity)this.mActivity).getResources().getString(2131696894, new Object[] { Long.valueOf(l) });
      str1 = str2;
    } while (this.CP != 1);
    return ((NewPhotoListActivity)this.mActivity).getResources().getString(2131696887, new Object[] { Long.valueOf(l) });
  }
  
  public List<LocalMediaInfo> getLocalMediaInfos()
  {
    int i = -1;
    if (this.mPhotoCommonData.albumId.equals("$RecentAlbumId")) {
      if (!this.btS) {
        break label435;
      }
    }
    label429:
    label435:
    for (i = QzoneConfig.getInstance().getConfig("PhotoAlbum", "MaxRecentPhotoNum", 200);; i = 100)
    {
      int j;
      int k;
      if (((this.btS) && (this.mPhotoCommonData.albumId.equals("$RecentAlbumId"))) || ((this.btT) && (this.btU)))
      {
        j = QzoneConfig.getInstance().getConfig("PhotoAlbum", "RecentPhotoLimitSize", 20480);
        k = QzoneConfig.getInstance().getConfig("PhotoAlbum", "RecentPhotoLimitWidth", 100);
        localObject = QzoneConfig.getInstance().getConfig("PhotoAlbum", "RecentPhotoBlockPaths", "MagazineUnlock");
        if (localObject == null) {
          break label429;
        }
      }
      for (Object localObject = y((String)localObject);; localObject = null)
      {
        localObject = aqfy.getAlbumMedias(this.mActivity, this.mPhotoCommonData.albumId, this.mPhotoCommonData.albumName, i, this.a.filter, j, k, true, (ArrayList)localObject, this.btU, this.a.filterVideoDurationLimit);
        for (;;)
        {
          aqip.endPile("PEAK", "getAlbumMedias");
          if (localObject != null) {
            break;
          }
          if (QLog.isColorLevel()) {
            QLog.d("SelectPhotoTrace", 2, "photoList is null");
          }
          return null;
          if (((zuc)this.mOtherCommonData).VO())
          {
            if ((!TextUtils.isEmpty(this.mPhotoCommonData.albumId)) && (this.mPhotoCommonData.albumId.equals("$CustomAlbumId")))
            {
              localObject = new ArrayList();
              ((List)localObject).addAll(rma.a().ci());
            }
            else
            {
              localObject = aqfy.getAlbumMedias(this.mActivity, this.mPhotoCommonData.albumId, this.mPhotoCommonData.albumName, i, this.a.filter, 0, 0, true, null, false, this.a.filterVideoDurationLimit, 1);
            }
          }
          else {
            localObject = aqfy.getAlbumMedias(this.mActivity, this.mPhotoCommonData.albumId, this.mPhotoCommonData.albumName, i, this.a.filter, this.a.filterVideoDurationLimit);
          }
        }
        if (((this.btM) || (this.btL)) && (QzoneConfig.getInstance().getConfig("PhotoAlbum", "paranoramaOpenCheck", 1) != 0)) {
          hq((List)localObject);
        }
        for (;;)
        {
          csc();
          return localObject;
          QLog.i("PhotoListActivity", 2, "@panoramatest isnot fromqzone");
        }
      }
    }
  }
  
  public View getViewCaseCamera(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if ((this.btM) || (this.btL))
    {
      paramViewGroup = paramView;
      if (paramView == null)
      {
        paramViewGroup = ((NewPhotoListActivity)this.mActivity).photoListAdapter.mInflater.inflate(2131562661, null);
        paramViewGroup.setLayoutParams(new AbsListView.LayoutParams(((NewPhotoListActivity)this.mActivity).mImageWidth, ((NewPhotoListActivity)this.mActivity).mImageHeight));
        FD(1);
      }
      return paramViewGroup;
    }
    return super.getViewCaseCamera(paramInt, paramView, paramViewGroup);
  }
  
  public View getViewCaseImage(int paramInt, View paramView, ViewGroup paramViewGroup, AbstractPhotoListActivity.PhotoListAdapter.Holder paramHolder, AbstractPhotoListActivity.CheckBoxClickedListener paramCheckBoxClickedListener)
  {
    paramView = super.getViewCaseImage(paramInt, paramView, paramViewGroup, paramHolder, paramCheckBoxClickedListener);
    paramViewGroup = ((NewPhotoListActivity)this.mActivity).photoListAdapter.getItem(paramInt);
    if ((paramViewGroup != null) && (paramViewGroup.isPanoramaPhoto()) && ((this.btM) || (this.btL))) {
      paramHolder.mImageViewPanoramaIcon.setVisibility(0);
    }
    return paramView;
  }
  
  public void handlePicCapture(Intent paramIntent)
  {
    FD(5);
    super.handlePicCapture(paramIntent);
  }
  
  public void handleVideoCapture(Intent paramIntent)
  {
    FD(4);
    super.handleVideoCapture(paramIntent);
  }
  
  public void handleVideoEncodeSucceed(Message paramMessage)
  {
    ((NewPhotoListActivity)this.mActivity).cancleProgressDailog();
    int i;
    if ((paramMessage.obj instanceof String))
    {
      paramMessage = (String)paramMessage.obj;
      QZLog.d("PhotoListActivity", 2, new Object[] { "onEncodeSuccess = ", paramMessage });
      if (this.mPhotoCommonData.selectedPhotoList == null) {
        this.mPhotoCommonData.selectedPhotoList = new ArrayList();
      }
      if (!this.btM) {
        break label163;
      }
      i = aqfy.LQ();
      if (this.mPhotoCommonData.selectedPhotoList.size() < this.mPhotoCommonData.maxSelectNum) {
        break label170;
      }
      QQToast.a(this.mActivity, String.format(((NewPhotoListActivity)this.mActivity).getResources().getString(2131696894), new Object[] { Integer.valueOf(this.mPhotoCommonData.maxSelectNum) }), 0).show();
    }
    for (;;)
    {
      ((NewPhotoListActivity)this.mActivity).zJ(paramMessage);
      return;
      label163:
      i = aqfy.LP();
      break;
      label170:
      if (yp() >= i)
      {
        QQToast.a(this.mActivity, String.format(((NewPhotoListActivity)this.mActivity).getResources().getString(2131696899), new Object[] { Integer.valueOf(i) }), 0).show();
      }
      else
      {
        this.mPhotoCommonData.selectedPhotoList.add(paramMessage);
        ((NewPhotoListActivity)this.mActivity).crQ();
      }
    }
  }
  
  public void initData(Intent paramIntent)
  {
    this.btV = paramIntent.getBooleanExtra("from_qzone_slideshow", false);
    ((zuc)this.mOtherCommonData).a(this.btV, this.mPhotoCommonData);
    super.initData(paramIntent);
    cO(paramIntent);
    if (!TextUtils.isEmpty(this.baW))
    {
      this.btL = iw(this.baW);
      this.btM = ix(this.baW);
      this.btN = iy(this.baW);
      this.btS = iz(this.baW);
    }
    if (this.pN)
    {
      this.btO = true;
      this.btM = true;
    }
    if ((this.btL) || (this.btM)) {
      this.mPhotoCommonData.needMediaInfo = true;
    }
    if (this.btP)
    {
      this.J = new LinkedHashMap();
      cP(paramIntent);
    }
    if (this.hC == null) {
      this.hC = new HashMap();
    }
    if (this.btN) {
      this.cfh = paramIntent.getIntExtra("imageSizeLimit", 0);
    }
    if (this.CP == 1) {
      crZ();
    }
    if (this.btR) {
      csa();
    }
    if ((((zuc)this.mOtherCommonData).VO()) && (((NewPhotoListActivity)this.mActivity).getIntent().getIntExtra("qq_sub_business_id", -1) == 3))
    {
      rma.a().xL(22);
      rma.a().xK(14);
      rma.a().bvr();
      ((NewPhotoListActivity)this.mActivity).getIntent().removeExtra("qq_sub_business_id");
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((this.btV) && (paramInt2 == -1) && (paramInt1 != 24747))
    {
      ((NewPhotoListActivity)this.mActivity).setResult(paramInt2, paramIntent);
      ((NewPhotoListActivity)this.mActivity).finish();
      return;
    }
    if ((paramInt2 != -1) && (paramInt1 == 10001) && (this.btV) && (paramIntent != null))
    {
      String str = paramIntent.getStringExtra("PhotoConst.FROM_QQSTORY_SLIDESHOW_DATA");
      if (!TextUtils.isEmpty(str)) {
        aqhq.cn(new File(str).getParent());
      }
      ((NewPhotoListActivity)this.mActivity).setResult(0, paramIntent);
      ((NewPhotoListActivity)this.mActivity).finish();
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onCheckBoxClick(View paramView, int paramInt, CheckBox paramCheckBox)
  {
    LocalMediaInfo localLocalMediaInfo = ((NewPhotoListActivity)this.mActivity).photoListAdapter.getItem(paramInt);
    if (localLocalMediaInfo.selectStatus == 1) {}
    for (int i = 1; i == 0; i = 0)
    {
      String[] arrayOfString = MimeHelper.getMimeType(localLocalMediaInfo.mMimeType);
      if ((!this.a.isSupportVideoCheckbox) || (arrayOfString == null) || (!"video".equals(arrayOfString[0])) || (aqfy.a(this.mActivity, yp(), localLocalMediaInfo, this.btM))) {
        break;
      }
      localLocalMediaInfo.selectStatus = 2;
      return;
    }
    super.onCheckBoxClick(paramView, paramInt, paramCheckBox);
    if (i == 0)
    {
      MimeHelper.getMimeType(localLocalMediaInfo.mMimeType);
      this.hC.put(localLocalMediaInfo.path, Integer.valueOf(localLocalMediaInfo.panoramaPhotoType));
      return;
    }
    MimeHelper.getMimeType(localLocalMediaInfo.mMimeType);
    this.hC.remove(localLocalMediaInfo.path);
  }
  
  public void onMagicStickClick(View paramView, Bundle paramBundle, int paramInt, Intent paramIntent)
  {
    FE(paramView.getId());
    paramView = ((NewPhotoListActivity)this.mActivity).getIntent();
    if (this.mPhotoCommonData.selectedPhotoList.size() > 0)
    {
      paramView.removeExtra("param_initTime");
      paramView.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", this.mPhotoCommonData.selectedPhotoList);
      anot.a(null, "CliOper", "", "", "0x8004B39", "0x8004B39", 0, 0, "", "", "", "");
      paramView = new HashMap(1);
      if ((this.mPhotoCommonData.selectedMediaInfoHashMap != null) && (this.mPhotoCommonData.selectedMediaInfoHashMap.get(this.mPhotoCommonData.selectedPhotoList.get(0)) != null)) {
        paramView.put("param_localmediainfo", this.mPhotoCommonData.selectedMediaInfoHashMap.get(this.mPhotoCommonData.selectedPhotoList.get(0)));
      }
      paramView = b(EditPicActivity.a(this.mActivity, (String)this.mPhotoCommonData.selectedPhotoList.get(0), true, true, true, true, true, 3, 99, 5, paramView), (String)this.mPhotoCommonData.selectedPhotoList.get(0));
      cL(paramView);
      ((NewPhotoListActivity)this.mActivity).startActivity(paramView);
      ((NewPhotoListActivity)this.mActivity).magicStickBtn.setClickable(false);
    }
  }
  
  public void onPreviewBtnClick(View paramView)
  {
    FE(paramView.getId());
    super.onPreviewBtnClick(paramView);
  }
  
  public void onSendBtnClick(View paramView)
  {
    FE(paramView.getId());
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
    Intent localIntent = ((NewPhotoListActivity)this.mActivity).getIntent();
    if (localIntent.getBooleanExtra("PhotoConst.IS_SEND_FILESIZE_LIMIT", false))
    {
      paramView = this.mPhotoCommonData.selectedPhotoList.iterator();
      for (long l = 0L; paramView.hasNext(); l = aqhq.getFileSizes((String)paramView.next()) + l) {}
      if (ahav.amK())
      {
        ahal.a(this.mActivity, 2131693826, 2131693832, new zvp(this));
        return;
      }
    }
    if (this.btW)
    {
      String str = localIntent.getStringExtra("PhotoConst.DEST_ACTIVITY_CLASS_NAME");
      paramView = str;
      if (TextUtils.isEmpty(str)) {
        paramView = localIntent.getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
      }
      localIntent.addFlags(603979776);
      QzonePluginProxyActivity.x(localIntent, paramView);
      paramView = avpw.d.a();
      avpw.a(this.mActivity, paramView, localIntent, -1, null);
      return;
    }
    submit();
  }
  
  public void onTitleBtnCancelClick(View paramView)
  {
    if (paramView != null) {
      FE(paramView.getId());
    }
    paramView = ((NewPhotoListActivity)this.mActivity).getIntent();
    aqfy.clearSelectItemInfo();
    aqfy.clearCache();
    Object localObject = PresendPicMgr.a();
    if (localObject != null) {
      ((PresendPicMgr)localObject).IP(1006);
    }
    if (this.mPhotoCommonData.selectedPhotoList != null) {}
    for (int i = this.mPhotoCommonData.selectedPhotoList.size();; i = 0)
    {
      zsz.k(paramView, i);
      if (this.a.bti) {
        break;
      }
      ((NewPhotoListActivity)this.mActivity).finish();
      aqfy.anim(this.mActivity, false, false);
      return;
    }
    localObject = paramView.getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
    String str1 = paramView.getStringExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME");
    if (localObject == null)
    {
      QQToast.a(this.mActivity, "请设置INIT_ACTIVITY_CLASS_NAME ", 0).show();
      return;
    }
    paramView.setClassName(str1, (String)localObject);
    paramView.removeExtra("PhotoConst.PHOTO_PATHS");
    paramView.removeExtra("PhotoConst.SINGLE_PHOTO_PATH");
    if (this.btL) {
      paramView.removeExtra("PeakConstants.selectedMediaInfoHashMap");
    }
    paramView.addFlags(603979776);
    if (!paramView.getBooleanExtra("PhotoConst.IS_CALL_IN_PLUGIN", false)) {
      ((NewPhotoListActivity)this.mActivity).startActivity(paramView);
    }
    for (;;)
    {
      ((NewPhotoListActivity)this.mActivity).finish();
      aqfy.anim(this.mActivity, false, false);
      return;
      paramView.getStringExtra("PhotoConst.PLUGIN_NAME");
      str1 = paramView.getStringExtra("PhotoConst.PLUGIN_APK");
      String str2 = paramView.getStringExtra("PhotoConst.UIN");
      if ("qzone_plugin.apk".equals(str1))
      {
        QzonePluginProxyActivity.x(paramView, (String)localObject);
        avpw.a(this.mActivity, str2, paramView, 2);
      }
      else if ("qqfav.apk".equals(str1))
      {
        avja.a(this.mActivity, str2, paramView, 2);
      }
      else
      {
        QLog.e("PhotoListActivity", 1, "Watermark has been deleted!");
      }
    }
  }
  
  public void postInitUI()
  {
    super.postInitUI();
    ((NewPhotoListActivity)this.mActivity).mGridView.setOnScrollListener(new zvn(this));
    if ((TextUtils.isEmpty(this.a.customSendBtnText)) && (1 == this.CP))
    {
      String str = ((NewPhotoListActivity)this.mActivity).getString(2131696901);
      ((NewPhotoListActivity)this.mActivity).No.setVisibility(0);
      ((NewPhotoListActivity)this.mActivity).No.setText(((NewPhotoListActivity)this.mActivity).getString(2131696913));
      ((NewPhotoListActivity)this.mActivity).sendBtn.setText(str);
    }
  }
  
  public void startPhotoPreviewActivity(Intent paramIntent)
  {
    if (this.CP == 1)
    {
      PublicFragmentActivity.b.start(this.mActivity, paramIntent, PublicFragmentActivityForPeak.class, QzonePhotoPreviewActivity.class);
      return;
    }
    super.startPhotoPreviewActivity(paramIntent);
  }
  
  protected void submit()
  {
    Intent localIntent = ((NewPhotoListActivity)this.mActivity).getIntent();
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
      zsz.j(localIntent, this.mPhotoCommonData.selectedPhotoList.size());
      zsz.d(localIntent, this.mPhotoCommonData.selectedPhotoList.size(), this.mPhotoCommonData.currentQualityType);
    }
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
      cR(localIntent);
      return;
      if ((localPresendPicMgr != null) && (!this.a.btr)) {
        localPresendPicMgr.dD(localIntent);
      }
    }
  }
  
  public void updateButton()
  {
    boolean bool2 = true;
    boolean bool1 = true;
    super.updateButton();
    String str;
    if (this.a.customSendBtnText != null)
    {
      str = this.a.customSendBtnText;
      if (1 == this.CP) {
        break label209;
      }
      if (this.mPhotoCommonData.selectedPhotoList.size() <= 0) {
        break label204;
      }
      label47:
      if (!bool1) {
        break label233;
      }
      str = str + "(" + this.mPhotoCommonData.selectedPhotoList.size() + ")";
    }
    label204:
    label209:
    label233:
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("_photo", 2, "updateButton selectedPhotoList.size()=" + this.mPhotoCommonData.selectedPhotoList.size());
      }
      ((NewPhotoListActivity)this.mActivity).sendBtn.setText(str);
      ((NewPhotoListActivity)this.mActivity).sendBtn.setEnabled(bool1);
      return;
      if (1 == this.CP)
      {
        str = ((NewPhotoListActivity)this.mActivity).getString(2131696901);
        break;
      }
      str = ((NewPhotoListActivity)this.mActivity).getString(2131696878);
      break;
      bool1 = false;
      break label47;
      if (this.mPhotoCommonData.selectedPhotoList.size() >= 3) {}
      for (bool1 = bool2;; bool1 = false) {
        break;
      }
    }
  }
  
  public int yp()
  {
    Iterator localIterator = this.mPhotoCommonData.selectedMediaInfoHashMap.entrySet().iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      if (QAlbumUtil.getMediaType((LocalMediaInfo)((Map.Entry)localIterator.next()).getValue()) != 1) {
        break label60;
      }
      i += 1;
    }
    label60:
    for (;;)
    {
      break;
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zvm
 * JD-Core Version:    0.7.0.1
 */