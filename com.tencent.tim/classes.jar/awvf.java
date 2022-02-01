import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import com.tencent.biz.qqstory.takevideo.slideshow.SlideItemInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.component.media.image.ImageManager;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.activity.photo.album.NewPhotoPreviewActivity;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.activity.shortvideo.SendVideoActivity.SendVideoInfo;
import com.tencent.mobileqq.activity.shortvideo.ShortVideoPreviewActivity;
import com.tencent.mobileqq.pic.PresendPicMgr;
import com.tencent.mobileqq.widget.NumberCheckBox;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.util.QZLog;
import dov.com.qq.im.ae.album.logic.AEPhotoListLogicDefault.1;
import dov.com.qq.im.ae.album.logic.AEPhotoListLogicDefault.7;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import mqq.util.WeakReference;

public class awvf
  extends awvc<awuv>
  implements awva.a, awva.b, awva.c, rmd.a
{
  public ztu a;
  
  protected awvf(awuv paramawuv)
  {
    super(paramawuv);
    this.jdField_a_of_type_Awva$c = this;
    this.jdField_a_of_type_Awva$a = this;
    this.jdField_a_of_type_Awva$b = this;
    this.mPhotoListData = new ztu();
    this.jdField_a_of_type_Ztu = ((ztu)this.mPhotoListData);
  }
  
  public Intent a(View paramView, int paramInt)
  {
    paramView = super.a(paramView, paramInt);
    paramView.putExtra("PhotoConst.MY_UIN", this.mPhotoCommonData.myUin);
    paramView.putExtra("PhotoConst.CURRENT_QUALITY_TYPE", this.mPhotoCommonData.currentQualityType);
    paramView.putExtra("PhotoConst.SHOW_MAGIC_USE_PASTER", this.jdField_a_of_type_Ztu.btm);
    paramView.putExtra("PhotoConst.editPathMap", zsh.d(this.jdField_a_of_type_Ztu.hy));
    paramView.putExtra("p_e_s_type", 6);
    paramView.putExtra("PasterConstants.paster_id", this.jdField_a_of_type_Ztu.pasterId);
    paramView.putExtra("PasterConstants.paster_cate_id", this.jdField_a_of_type_Ztu.baR);
    paramView.putExtra("PasterConstants.pasters_data", this.jdField_a_of_type_Ztu.hx);
    if ((this.mPhotoCommonData.selectedPhotoList != null) && (this.mPhotoCommonData.selectedPhotoList.size() > 0)) {
      anot.b(null, "CliOper", "", this.mPhotoCommonData.myUin, "0X8005674", "0X8005674", 0, this.mPhotoCommonData.selectedPhotoList.size(), 0, "", "", "", "");
    }
    return paramView;
  }
  
  protected void a(Intent paramIntent, boolean paramBoolean, ArrayList<String> paramArrayList)
  {
    int i2 = PhotoUtils.c(this.jdField_a_of_type_Ztu.sessionInfo);
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
        if (((awuv)this.bu.get()).getMediaType((String)localObject2) == 1)
        {
          localObject2 = ((awuv)this.bu.get()).getMediaInfo((String)localObject2);
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
        localObject1 = ((awuv)this.bu.get()).getResources().getString(2131719478);
        paramIntent = new AEPhotoListLogicDefault.1(this, paramBoolean, paramIntent, paramArrayList, i2, (String)localObject2, (String)localObject3);
        if (armm.a(((awuv)this.bu.get()).getActivity(), 4, new awvg(this, paramIntent))) {
          aqha.a(((awuv)this.bu.get()).getActivity(), 232, null, (String)localObject1, new awvh(this, paramIntent), new awvi(this)).show();
        }
        if (QLog.isColorLevel()) {
          QLog.i("PhotoListActivity", 2, "show shortvideo_mobile_send_confirm dialog");
        }
        return;
      }
      if (paramBoolean) {
        PhotoUtils.a(((awuv)this.bu.get()).getActivity(), paramIntent, paramArrayList, this.jdField_a_of_type_Ztu.hw, this.mPhotoCommonData.currentQualityType, false);
      }
      for (;;)
      {
        anot.a(null, "CliOper", "", "", "0X8009AB0", "0X8009AB0", i2, 0, (String)localObject2, (String)localObject3, "", "");
        return;
        PhotoUtils.a(((awuv)this.bu.get()).getActivity(), paramIntent, paramArrayList, this.mPhotoCommonData.currentQualityType, this.jdField_a_of_type_Ztu.bjL);
      }
    }
  }
  
  protected void a(awur.c paramc, LocalMediaInfo paramLocalMediaInfo)
  {
    if (zsh.a(paramLocalMediaInfo.path, this.jdField_a_of_type_Ztu.hy))
    {
      if (Build.VERSION.SDK_INT >= 21) {
        paramc.mPhotoFlagView.setImageDrawable(((awuv)this.bu.get()).getActivity().getDrawable(2130839600));
      }
      for (;;)
      {
        paramc.mPhotoFlagView.setVisibility(0);
        return;
        paramc.mPhotoFlagView.setImageResource(2130839600);
      }
    }
    paramc.mPhotoFlagView.setVisibility(8);
  }
  
  public void a(SlideItemInfo paramSlideItemInfo)
  {
    Object localObject1 = ((awuv)this.bu.get()).a;
    ArrayList localArrayList = this.mPhotoCommonData.selectedPhotoList;
    Object localObject2;
    int i;
    if ((localObject1 != null) && (paramSlideItemInfo != null))
    {
      localObject2 = ((awur.a)localObject1).getPhotoList();
      i = 0;
      if (i >= ((List)localObject2).size()) {
        break label563;
      }
      if (!((LocalMediaInfo)((List)localObject2).get(i)).path.equals(paramSlideItemInfo.mSrcPath)) {
        break label403;
      }
    }
    for (;;)
    {
      if ((i >= 0) && (i < ((List)localObject2).size()))
      {
        paramSlideItemInfo = ((awur.a)localObject1).getItem(i);
        paramSlideItemInfo.selectStatus = 2;
        localObject1 = paramSlideItemInfo.path;
        localObject2 = MimeHelper.getMimeType(paramSlideItemInfo.mMimeType);
        if ((this.jdField_a_of_type_Ztu.isSupportVideoCheckbox) && (localObject2 != null) && ("video".equals(localObject2[0])))
        {
          localObject2 = this.jdField_a_of_type_Ztu;
          ((ztu)localObject2).videoSelectedCnt -= 1;
          if (this.jdField_a_of_type_Ztu.videoSelectedCnt == 1) {
            this.jdField_a_of_type_Ztu.selectedVideoInfo = paramSlideItemInfo;
          }
        }
        if ((!TextUtils.isEmpty(paramSlideItemInfo.mMimeType)) && ("image/gif".equals(paramSlideItemInfo.mMimeType)))
        {
          localObject2 = this.jdField_a_of_type_Ztu;
          ((ztu)localObject2).gifSelectedCount -= 1;
        }
        this.mPhotoCommonData.selectedPhotoList.remove(localObject1);
        this.mPhotoCommonData.selectedIndex.remove(paramSlideItemInfo.position);
        if (this.mPhotoCommonData.needMediaInfo) {
          this.mPhotoCommonData.selectedMediaInfoHashMap.remove(localObject1);
        }
        zsz.q(((awuv)this.bu.get()).getActivity().getIntent(), "param_cancelSelNum");
        localObject2 = (HashMap)aqfy.sSelectItemPosMap.get(this.mPhotoCommonData.albumId);
        if (localObject2 != null) {
          ((HashMap)localObject2).remove(localObject1);
        }
        localObject2 = aqfy.sSelectItemAlbum;
        if (((HashMap)localObject2).containsKey(localObject1)) {
          ((HashMap)localObject2).remove(localObject1);
        }
        if (this.jdField_a_of_type_Awva$d != null) {
          this.jdField_a_of_type_Awva$d.onSelectionChange(false, paramSlideItemInfo);
        }
        ((awuv)this.bu.get()).updateCheckbox(i, false);
        updateButton();
        rma.a().b(localArrayList, this.mPhotoCommonData.allMediaInfoHashMap);
      }
      label403:
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
      zsz.q(((awuv)this.bu.get()).getActivity().getIntent(), "param_cancelSelNum");
      localObject1 = (HashMap)aqfy.sSelectItemPosMap.get(this.mPhotoCommonData.albumId);
      if (localObject1 != null) {
        ((HashMap)localObject1).remove(paramSlideItemInfo.mSrcPath);
      }
      localObject1 = aqfy.sSelectItemAlbum;
      if (((HashMap)localObject1).containsKey(paramSlideItemInfo.mSrcPath)) {
        ((HashMap)localObject1).remove(paramSlideItemInfo.mSrcPath);
      }
      ((awuv)this.bu.get()).updateCheckboxForDelete();
      updateButton();
      rma.a().b(localArrayList, this.mPhotoCommonData.allMediaInfoHashMap);
      return;
      label563:
      i = -1;
    }
  }
  
  public void aF(View paramView, int paramInt) {}
  
  public void aG(View paramView, int paramInt)
  {
    if (!aqft.cC()) {
      QQToast.a(((awuv)this.bu.get()).getActivity(), ((awuv)this.bu.get()).getResources().getString(2131719242), 0).show();
    }
    do
    {
      return;
      paramView = ((awuv)this.bu.get()).a.getItem(paramInt);
    } while (paramView == null);
    Object localObject1 = ((awuv)this.bu.get()).getActivity().getIntent();
    if (paramView.fileSize > this.mPhotoCommonData.videoSizeLimit)
    {
      paramView = aqha.a(((awuv)this.bu.get()).getActivity(), "你选择的视频文件过大，无法发送。");
      paramView.setPositiveButton(2131721079, new aqha.a());
      paramView.show();
      return;
    }
    Object localObject2 = aqfy.sSelectItemAlbum;
    if (!((HashMap)localObject2).containsKey(paramView.path))
    {
      Pair localPair = new Pair(this.mPhotoCommonData.albumId, this.mPhotoCommonData.albumName);
      ((HashMap)localObject2).put(paramView.path, localPair);
    }
    ((awuv)this.bu.get()).recordLastPos(paramView.path);
    if (!this.jdField_a_of_type_Ztu.btj)
    {
      ((Intent)localObject1).putExtra("file_send_path", paramView.path);
      ((Intent)localObject1).putExtra("PhotoConst.IS_VIDEO_SELECTED", true);
      ((Intent)localObject1).putExtra("PhotoConst.VIDEO_SIZE", paramView.fileSize);
      ((Intent)localObject1).putExtra("file_send_duration", paramView.mDuration);
      ((Intent)localObject1).putExtra("file_width", paramView.mediaWidth);
      ((Intent)localObject1).putExtra("file_height", paramView.mediaHeight);
      ((Intent)localObject1).putExtra("media_info", paramView);
      localObject2 = new ArrayList();
      ((ArrayList)localObject2).add(paramView.path);
      PhotoUtils.a(((awuv)this.bu.get()).getActivity(), (Intent)localObject1, (ArrayList)localObject2, 2, false);
      return;
    }
    if (!this.jdField_a_of_type_Ztu.isSingleMode)
    {
      paramView = ((awuv)this.bu.get()).getActivity().getIntent();
      paramView.putExtra("ALBUM_NAME", this.mPhotoCommonData.albumName);
      paramView.putExtra("ALBUM_ID", this.mPhotoCommonData.albumId);
      localObject1 = ((awuv)this.bu.get()).a.getItem(paramInt);
      paramView.putExtra("PhotoConst.CURRENT_SELECTED_INDEX", ((LocalMediaInfo)localObject1).position);
      paramView.putStringArrayListExtra("PhotoConst.SELECTED_PATHS", this.mPhotoCommonData.selectedPhotoList);
      paramView.putIntegerArrayListExtra("PhotoConst.SELECTED_INDEXS", this.mPhotoCommonData.selectedIndex);
      paramView.putExtra("FROM_WHERE", "FROM_PHOTO_LIST");
      paramView.putExtra("PhotoConst.CURRENT_QUALITY_TYPE", this.mPhotoCommonData.currentQualityType);
      paramView.putExtra("PhotoConst.SHOW_ALBUM", true);
      paramView.putExtra("PhotoConst.SHOW_MAGIC_USE_PASTER", this.jdField_a_of_type_Ztu.btm);
      paramView.putExtra("PasterConstants.paster_id", this.jdField_a_of_type_Ztu.pasterId);
      paramView.putExtra("PasterConstants.paster_cate_id", this.jdField_a_of_type_Ztu.baR);
      ztu.sPhotoListFirstPos = ((GridLayoutManager)((awuv)this.bu.get()).E.getLayoutManager()).findFirstVisibleItemPosition();
      localObject2 = this.mPhotoCommonData.selectedMediaInfoHashMap;
      if (!((HashMap)localObject2).containsKey(((LocalMediaInfo)localObject1).path)) {
        ((HashMap)localObject2).put(((LocalMediaInfo)localObject1).path, localObject1);
      }
      paramView.putExtra("PeakConstants.selectedMediaInfoHashMap", (Serializable)localObject2);
      paramView.putExtra("PasterConstants.pasters_data", this.jdField_a_of_type_Ztu.hx);
      paramView.setClass(((awuv)this.bu.get()).getActivity(), NewPhotoPreviewActivity.class);
      paramView.addFlags(603979776);
      if ((this.mPhotoCommonData.selectedPhotoList != null) && (this.mPhotoCommonData.selectedPhotoList.size() > 0)) {
        anot.b(null, "CliOper", "", this.mPhotoCommonData.myUin, "0X8005674", "0X8005674", 0, this.mPhotoCommonData.selectedPhotoList.size(), 0, "", "", "", "");
      }
      ((awuv)this.bu.get()).startActivity(paramView);
      ((awuv)this.bu.get()).getActivity().finish();
      aqfy.anim(((awuv)this.bu.get()).getActivity(), true, true);
      return;
    }
    localObject2 = new Intent(((awuv)this.bu.get()).getActivity(), ShortVideoPreviewActivity.class);
    ((Intent)localObject2).putExtras((Intent)localObject1);
    ((Intent)localObject2).putExtra("file_send_path", paramView.path);
    ((Intent)localObject2).putExtra("file_send_size", paramView.fileSize);
    ((Intent)localObject2).putExtra("file_send_duration", paramView.mDuration);
    ((Intent)localObject2).putExtra("file_width", paramView.mediaWidth);
    ((Intent)localObject2).putExtra("file_height", paramView.mediaHeight);
    ((Intent)localObject2).putExtra("uin", this.jdField_a_of_type_Ztu.friendUin);
    ((Intent)localObject2).putExtra("uintype", this.jdField_a_of_type_Ztu.cZ);
    ((Intent)localObject2).putExtra("file_source", "album");
    ((Intent)localObject2).putExtra("is_from_system_media", paramView.isSystemMeidaStore);
    if (this.jdField_a_of_type_Ztu.isSupportVideoCheckbox)
    {
      ((Intent)localObject2).putExtra("PhotoConst.IS_SUPPORT_VIDEO_CHECKBOX", true);
      ((Intent)localObject2).putExtra("PhotoConst.PHOTO_PATHS", this.mPhotoCommonData.selectedPhotoList);
    }
    ((awuv)this.bu.get()).startActivityForResult((Intent)localObject2, 17);
  }
  
  public void aH(View paramView, int paramInt)
  {
    if (!aqft.cC())
    {
      QQToast.a(((awuv)this.bu.get()).getActivity(), ((awuv)this.bu.get()).getResources().getString(2131719242), 0).show();
      return;
    }
    ((awuv)this.bu.get()).crP();
  }
  
  public void bvy() {}
  
  public View cI()
  {
    return super.cI();
  }
  
  public void cL(Intent paramIntent)
  {
    if (this.jdField_a_of_type_Ztu.btr)
    {
      paramIntent.putExtra("ReceiptMsgManager.EXTRA_KEY_IS_RECEIPT", true);
      paramIntent.putExtra("session_info", ((awuv)this.bu.get()).getActivity().getIntent().getParcelableExtra("session_info"));
    }
  }
  
  public void cfa() {}
  
  public void crT()
  {
    if (this.jdField_a_of_type_Ztu.btr) {
      anot.a(null, "CliOper", "", "", "0x80083EC", "0x80083EC", 0, 0, "", "", "", "");
    }
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    aeee.e(BaseApplicationImpl.getContext(), 2, false);
    if (this.jdField_a_of_type_Ztu.requestCode == 100016)
    {
      if (!((awuv)this.bu.get()).getActivity().getIntent().getBooleanExtra("FROM_QZONR_NO_FINISH", false)) {
        ((awuv)this.bu.get()).getActivity().finish();
      }
    }
    else {
      return;
    }
    ((awuv)this.bu.get()).getActivity().getIntent().removeExtra("FROM_QZONR_NO_FINISH");
    this.jdField_a_of_type_Ztu.requestCode = 0;
  }
  
  public void enterAlbumListFragment(Intent paramIntent)
  {
    super.enterAlbumListFragment(paramIntent);
    paramIntent.putExtra("PhotoConst.CURRENT_QUALITY_TYPE", this.mPhotoCommonData.currentQualityType);
    paramIntent.putExtra("PhotoConst.IS_SHOW_QZONE_ALBUM", this.mPhotoCommonData.isShowQzoneAlbum);
    paramIntent.putExtra("peak.myUin", this.mPhotoCommonData.myUin);
  }
  
  protected void enterPhotoPreviewActivity(boolean paramBoolean, Intent paramIntent)
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
    }
    for (;;)
    {
      paramIntent.putExtra("PhotoConst.USE_URL_PATH", false);
      if (this.mPhotoCommonData.needMediaInfo)
      {
        paramIntent.putExtra("PeakConstants.selectedMediaInfoHashMap", this.mPhotoCommonData.selectedMediaInfoHashMap);
        paramIntent.putExtra("PhotoConst.CURRENT_SELECTED_INDEX", 0);
      }
      paramIntent.putExtra("ALBUM_NAME", this.mPhotoCommonData.albumName);
      paramIntent.putExtra("ALBUM_ID", this.mPhotoCommonData.albumId);
      paramIntent.putExtra("FROM_WHERE", "FROM_PHOTO_LIST");
      paramIntent.putExtra("PhotoConst.CURRENT_QUALITY_TYPE", this.mPhotoCommonData.currentQualityType);
      paramIntent.putExtra("PasterConstants.pasters_data", this.jdField_a_of_type_Ztu.hx);
      ztu.sPhotoListFirstPos = ((GridLayoutManager)((awuv)this.bu.get()).E.getLayoutManager()).findFirstVisibleItemPosition();
      paramIntent.setClass(((awuv)this.bu.get()).getActivity(), NewPhotoPreviewActivity.class);
      paramIntent.addFlags(603979776);
      startPhotoPreviewActivity(paramIntent);
      aqfy.anim(((awuv)this.bu.get()).getActivity(), true, true);
      return;
      paramIntent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", this.jdField_a_of_type_Ztu.currentPhotoPath);
    }
  }
  
  public void er(int paramInt1, int paramInt2)
  {
    ArrayList localArrayList = this.mPhotoCommonData.selectedPhotoList;
    RecyclerView localRecyclerView = ((awuv)this.bu.get()).E;
    awur.a locala = ((awuv)this.bu.get()).a;
    if ((paramInt1 >= 0) && (paramInt1 < localArrayList.size()) && (paramInt2 >= 0) && (paramInt2 < localArrayList.size()))
    {
      Collections.swap(localArrayList, paramInt1, paramInt2);
      paramInt2 = ((GridLayoutManager)localRecyclerView.getLayoutManager()).findFirstVisibleItemPosition();
      int i = ((GridLayoutManager)localRecyclerView.getLayoutManager()).findLastVisibleItemPosition();
      paramInt1 = paramInt2;
      while (paramInt1 <= i)
      {
        Object localObject = locala.getItem(paramInt1);
        int j = localArrayList.indexOf(((LocalMediaInfo)localObject).path);
        if (j >= 0)
        {
          localObject = (awur.c)localRecyclerView.getChildViewHolder(localRecyclerView.getChildAt(((LocalMediaInfo)localObject).position.intValue() - paramInt2));
          if ((localObject != null) && (((awur.c)localObject).mCheckBox != null)) {
            ((awur.c)localObject).mCheckBox.setCheckedNumber(j + 1);
          }
        }
        paramInt1 += 1;
      }
      rma.a().b(localArrayList, this.mPhotoCommonData.allMediaInfoHashMap);
    }
    ((awuv)this.bu.get()).selectLimitRemind(true);
  }
  
  protected String getExceedMaxSelectNumStr(LocalMediaInfo paramLocalMediaInfo)
  {
    int i = this.mPhotoCommonData.maxSelectNum;
    String str2 = super.getExceedMaxSelectNumStr(paramLocalMediaInfo);
    String str1 = str2;
    if (paramLocalMediaInfo != null)
    {
      paramLocalMediaInfo = MimeHelper.getMimeType(paramLocalMediaInfo.mMimeType);
      str1 = str2;
      if (this.jdField_a_of_type_Ztu.isSupportVideoCheckbox)
      {
        str1 = str2;
        if (paramLocalMediaInfo != null)
        {
          str1 = str2;
          if ("video".equals(paramLocalMediaInfo[0])) {
            str1 = ((awuv)this.bu.get()).getResources().getString(2131696894, new Object[] { Integer.valueOf(i) });
          }
        }
      }
    }
    return str1;
  }
  
  public List<LocalMediaInfo> getLocalMediaInfos()
  {
    int i = -1;
    if (this.mPhotoCommonData.albumId.equals("$RecentAlbumId")) {
      i = 100;
    }
    List localList = aqfy.getAlbumMedias(((awuv)this.bu.get()).getActivity(), this.mPhotoCommonData.albumId, this.mPhotoCommonData.albumName, i, this.jdField_a_of_type_Ztu.filter, this.jdField_a_of_type_Ztu.filterVideoDurationLimit);
    aqip.endPile("PEAK", "getAlbumMedias");
    if (localList == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SelectPhotoTrace", 2, "photoList is null");
      }
      return null;
    }
    if ((this.mPhotoCommonData.selectedPhotoList != null) && (this.mPhotoCommonData.selectedPhotoList.size() != 0))
    {
      i = 0;
      while (i < this.mPhotoCommonData.selectedPhotoList.size())
      {
        if (TextUtils.isEmpty((String)this.mPhotoCommonData.selectedPhotoList.get(i))) {
          QZLog.e("PhotoListActivity:QueryPhotoTask", "doInBackground: filter photo error, tempPath null");
        }
        i += 1;
      }
    }
    return localList;
  }
  
  public void handleVideoEncodeSucceed(Message paramMessage)
  {
    super.handleVideoEncodeSucceed(paramMessage);
    ((awuv)this.bu.get()).cancleProgressDailog();
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
      if (paramMessage.size() < this.mPhotoCommonData.maxSelectNum) {
        break label167;
      }
      QQToast.a(((awuv)this.bu.get()).getActivity(), String.format(((awuv)this.bu.get()).getResources().getString(2131696894), new Object[] { Integer.valueOf(this.mPhotoCommonData.maxSelectNum) }), 0).show();
    }
    for (;;)
    {
      ((awuv)this.bu.get()).zJ(str);
      return;
      label167:
      this.mPhotoCommonData.selectedPhotoList.add(str);
      ((awuv)this.bu.get()).crQ();
    }
  }
  
  public void initData(Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SelectPhotoTrace", 2, "PhotoListActivity initData(),intent extras is:" + paramIntent.getExtras());
    }
    super.initData(paramIntent);
    this.jdField_a_of_type_Ztu.bts = paramIntent.getBooleanExtra("PhotoConst.IS_FROM_EDIT", false);
    zsh.a(((awuv)this.bu.get()).getActivity(), paramIntent, false, this.jdField_a_of_type_Ztu.hy);
    this.jdField_a_of_type_Ztu.hw = ((HashMap)paramIntent.getSerializableExtra("PhotoConst.PHOTO_PATHS_FROM_QZONEALBUM"));
    if (this.jdField_a_of_type_Ztu.hw == null) {
      this.jdField_a_of_type_Ztu.hw = new HashMap(1);
    }
    this.mPhotoCommonData.isShowQzoneAlbum = paramIntent.getBooleanExtra("PhotoConst.IS_SHOW_QZONE_ALBUM", false);
    this.jdField_a_of_type_Ztu.btk = paramIntent.getBooleanExtra("PhotoConst.original_button", false);
    this.jdField_a_of_type_Ztu.btl = paramIntent.getBooleanExtra("PhotoConst.quality_count_tv", true);
    this.mPhotoCommonData.myUin = paramIntent.getStringExtra("PhotoConst.MY_UIN");
    this.jdField_a_of_type_Ztu.bjL = paramIntent.getBooleanExtra("PhotoConst.HANDLE_DEST_RESULT", false);
    this.jdField_a_of_type_Ztu.btn = paramIntent.getBooleanExtra("PhotoConst.IS_SINGLE_DERECTBACK_MODE", false);
    this.jdField_a_of_type_Ztu.bto = paramIntent.getBooleanExtra("PhotoConst.IS_SINGLE_NEED_EDIT", false);
    this.jdField_a_of_type_Ztu.btp = paramIntent.getBooleanExtra("PhotoConst.IS_CALL_IN_PLUGIN", false);
    this.jdField_a_of_type_Ztu.cZ = paramIntent.getIntExtra("uintype", -1);
    this.mPhotoCommonData.currentQualityType = paramIntent.getIntExtra("PhotoConst.CURRENT_QUALITY_TYPE", 0);
    if (paramIntent.getBooleanExtra("PhotoConst.ALWAYS_SHOW_NUMBER_WHEN_ONLY_ONE_IMAGE", false)) {
      this.jdField_a_of_type_Ztu.isSingleMode = false;
    }
    this.jdField_a_of_type_Ztu.bti = paramIntent.getBooleanExtra("PhotoConst.IS_FINISH_RESTART_INIT_ACTIVITY", false);
    this.jdField_a_of_type_Ztu.isSend = paramIntent.getBooleanExtra("PhotoConst.SEND_FLAG", false);
    this.jdField_a_of_type_Ztu.userName = paramIntent.getStringExtra("uinname");
    this.jdField_a_of_type_Ztu.friendUin = paramIntent.getStringExtra("uin");
    this.mPhotoCommonData.videoSizeLimit = paramIntent.getLongExtra("PhotoConst.PHOTOLIST_KEY_VIDEO_SIZE", 1048576000L);
    this.jdField_a_of_type_Ztu.btj = paramIntent.getBooleanExtra("PhotoConst.IS_PREVIEW_VIDEO", true);
    this.mPhotoCommonData.videoDurationLimit = paramIntent.getLongExtra("PhotoConst.PHOTOLIST_KEY_VIDEO_DURATION", 9223372036854775807L);
    try
    {
      this.jdField_a_of_type_Ztu.sessionInfo = ((SessionInfo)paramIntent.getParcelableExtra("session_info"));
      if (this.jdField_a_of_type_Ztu.isSend)
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
        PhotoUtils.a(((awuv)this.bu.get()).getActivity(), paramIntent, this.mPhotoCommonData.selectedPhotoList, this.mPhotoCommonData.currentQualityType, true);
      }
      if (!this.jdField_a_of_type_Ztu.btm) {
        this.jdField_a_of_type_Ztu.btm = paramIntent.getBooleanExtra("PhotoConst.SHOW_MAGIC_USE_PASTER", false);
      }
      if (this.jdField_a_of_type_Ztu.btm)
      {
        this.jdField_a_of_type_Ztu.hx = ((HashMap)paramIntent.getSerializableExtra("PasterConstants.pasters_data"));
        this.jdField_a_of_type_Ztu.pasterId = paramIntent.getStringExtra("PasterConstants.paster_id");
        this.jdField_a_of_type_Ztu.baR = paramIntent.getStringExtra("PasterConstants.paster_cate_id");
      }
      this.jdField_a_of_type_Ztu.btr = paramIntent.getBooleanExtra("ReceiptMsgManager.EXTRA_KEY_IS_RECEIPT", false);
      this.jdField_a_of_type_Ztu.Lz = paramIntent.getLongExtra("PhotoConst.PHOTOLIST_KEY_MAX_MEDIA_SIZE", -1L);
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
  
  public void onCheckBoxClick(View paramView, int paramInt, CheckBox paramCheckBox)
  {
    boolean bool2 = true;
    paramView = this.mPhotoCommonData.selectedPhotoList;
    if (this.jdField_a_of_type_Ztu.isSingleMode) {}
    LocalMediaInfo localLocalMediaInfo;
    int i;
    long l;
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("PhotoListActivity", 2, "current select count:" + paramView.size());
      }
      localLocalMediaInfo = ((awuv)this.bu.get()).a.getItem(paramInt);
      i = localLocalMediaInfo.selectStatus;
      if ((i == 1) || (paramView.size() < this.mPhotoCommonData.maxSelectNum)) {
        break;
      }
      l = System.currentTimeMillis();
    } while (l - this.jdField_a_of_type_Ztu.lastTimeShowToast < 1000L);
    QQToast.a(((awuv)this.bu.get()).getActivity(), getExceedMaxSelectNumStr(localLocalMediaInfo), 0).show(((awuv)this.bu.get()).mTitleBarHeight);
    paramCheckBox.setChecked(false);
    this.jdField_a_of_type_Ztu.lastTimeShowToast = l;
    crT();
    return;
    Object localObject1;
    if ((this.jdField_a_of_type_Ztu.cZ == 9501) && (((awuv)this.bu.get()).getActivity().getIntent().getBooleanExtra("PhotoConst.IS_SEND_FILESIZE_LIMIT", false)) && (i != 1))
    {
      localObject1 = paramView.iterator();
      for (l = 0L; ((Iterator)localObject1).hasNext(); l = aqhq.getFileSizes((String)((Iterator)localObject1).next()) + l) {}
      if (aqhq.getFileSizes(localLocalMediaInfo.path) + l > 52428800L)
      {
        QQToast.a(((awuv)this.bu.get()).getActivity(), "选择图片总大小不能超过50M", 0).show(((awuv)this.bu.get()).mTitleBarHeight);
        paramCheckBox.setChecked(false);
        return;
      }
    }
    if ((((awuv)this.bu.get()).getActivity().getIntent().getBooleanExtra("PhotoConst.IS_SEND_GIF_SIZE_LIMIT", false)) && (((awuv)this.bu.get()).isGif(localLocalMediaInfo)) && (aqhq.getFileSizes(localLocalMediaInfo.path) > 3145728L))
    {
      QQToast.a(((awuv)this.bu.get()).getActivity(), "图片文件过大", 0).show(((awuv)this.bu.get()).mTitleBarHeight);
      paramCheckBox.setChecked(false);
      return;
    }
    boolean bool1;
    label460:
    Object localObject2;
    if (i == 1)
    {
      i = 2;
      localLocalMediaInfo.selectStatus = i;
      if (localLocalMediaInfo.selectStatus != 1) {
        break label950;
      }
      bool1 = true;
      paramCheckBox = localLocalMediaInfo.path;
      localObject1 = PresendPicMgr.a();
      if (!bool1) {
        break label956;
      }
      localObject2 = MimeHelper.getMimeType(localLocalMediaInfo.mMimeType);
      ztu localztu;
      if ((this.jdField_a_of_type_Ztu.isSupportVideoCheckbox) && (localObject2 != null) && ("video".equals(localObject2[0])))
      {
        localztu = this.jdField_a_of_type_Ztu;
        localztu.videoSelectedCnt += 1;
        if (this.jdField_a_of_type_Ztu.videoSelectedCnt == 1) {
          this.jdField_a_of_type_Ztu.selectedVideoInfo = localLocalMediaInfo;
        }
      }
      if ((!TextUtils.isEmpty(localLocalMediaInfo.mMimeType)) && ("image/gif".equals(localLocalMediaInfo.mMimeType)))
      {
        localztu = this.jdField_a_of_type_Ztu;
        localztu.gifSelectedCount += 1;
      }
      paramView.add(paramCheckBox);
      this.mPhotoCommonData.selectedIndex.add(localLocalMediaInfo.position);
      if (this.mPhotoCommonData.needMediaInfo) {
        this.mPhotoCommonData.selectedMediaInfoHashMap.put(paramCheckBox, localLocalMediaInfo);
      }
      if ((localObject1 != null) && (localObject2 != null) && (localObject2[0] != null) && (!"video".equals(localObject2[0]))) {
        ((PresendPicMgr)localObject1).ay(paramCheckBox, 1052, ((awuv)this.bu.get()).getActivity().getIntent().getIntExtra("entrance", 0));
      }
      zsz.q(((awuv)this.bu.get()).getActivity().getIntent(), "param_totalSelNum");
      paramView = ((awuv)this.bu.get()).getActivity().getIntent();
      if (!paramView.hasExtra("param_initTime")) {
        paramView.putExtra("param_initTime", System.currentTimeMillis());
      }
      paramView = (LinkedHashMap)aqfy.sSelectItemPosMap.get(this.mPhotoCommonData.albumId);
      if (paramView != null) {
        break label1209;
      }
      paramView = new LinkedHashMap();
      aqfy.sSelectItemPosMap.put(this.mPhotoCommonData.albumId, paramView);
    }
    label950:
    label1209:
    for (;;)
    {
      paramView.put(paramCheckBox, Integer.valueOf(((GridLayoutManager)((awuv)this.bu.get()).E.getLayoutManager()).findFirstVisibleItemPosition()));
      paramView = aqfy.sSelectItemAlbum;
      if (!paramView.containsKey(paramCheckBox)) {
        paramView.put(paramCheckBox, new Pair(this.mPhotoCommonData.albumId, this.mPhotoCommonData.albumName));
      }
      label877:
      if (this.jdField_a_of_type_Awva$d != null) {
        this.jdField_a_of_type_Awva$d.onSelectionChange(bool1, localLocalMediaInfo);
      }
      ((awuv)this.bu.get()).updateCheckbox(paramInt, bool1);
      paramView = (awuv)this.bu.get();
      if (!bool1) {}
      for (bool1 = bool2;; bool1 = false)
      {
        paramView.selectLimitRemind(bool1);
        updateButton();
        return;
        i = 1;
        break;
        bool1 = false;
        break label460;
        label956:
        localObject2 = MimeHelper.getMimeType(localLocalMediaInfo.mMimeType);
        if ((this.jdField_a_of_type_Ztu.isSupportVideoCheckbox) && (localObject2 != null) && ("video".equals(localObject2[0])))
        {
          localObject2 = this.jdField_a_of_type_Ztu;
          ((ztu)localObject2).videoSelectedCnt -= 1;
          if (this.jdField_a_of_type_Ztu.videoSelectedCnt == 1) {
            this.jdField_a_of_type_Ztu.selectedVideoInfo = localLocalMediaInfo;
          }
        }
        if ((!TextUtils.isEmpty(localLocalMediaInfo.mMimeType)) && ("image/gif".equals(localLocalMediaInfo.mMimeType)))
        {
          localObject2 = this.jdField_a_of_type_Ztu;
          ((ztu)localObject2).gifSelectedCount -= 1;
        }
        paramView.remove(paramCheckBox);
        this.mPhotoCommonData.selectedIndex.remove(localLocalMediaInfo.position);
        if (this.mPhotoCommonData.needMediaInfo) {
          this.mPhotoCommonData.selectedMediaInfoHashMap.remove(paramCheckBox);
        }
        if (localObject1 != null) {
          ((PresendPicMgr)localObject1).fx(paramCheckBox, 1013);
        }
        zsz.q(((awuv)this.bu.get()).getActivity().getIntent(), "param_cancelSelNum");
        paramView = (HashMap)aqfy.sSelectItemPosMap.get(this.mPhotoCommonData.albumId);
        if (paramView != null) {
          paramView.remove(paramCheckBox);
        }
        paramView = aqfy.sSelectItemAlbum;
        if (!paramView.containsKey(paramCheckBox)) {
          break label877;
        }
        paramView.remove(paramCheckBox);
        break label877;
      }
    }
  }
  
  public void onMagicStickClick(View paramView, Bundle paramBundle, int paramInt, Intent paramIntent) {}
  
  public void onPhotoListDatasetDurationChanged(int paramInt, LocalMediaInfo paramLocalMediaInfo)
  {
    Handler localHandler = ((awuv)this.bu.get()).mHandler;
    if (localHandler == null) {}
    do
    {
      do
      {
        return;
        localObject = ((awuv)this.bu.get()).a;
      } while ((localObject == null) || (((awur.a)localObject).mAllImages == null));
      localObject = (LocalMediaInfo)((awur.a)localObject).mAllImages.get(paramInt);
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
  
  public boolean onQueryPhoto(List<LocalMediaInfo> paramList)
  {
    int m = 0;
    if (this.bu.get() == null) {}
    while (!super.onQueryPhoto(paramList)) {
      return false;
    }
    int i;
    int j;
    int k;
    if (this.jdField_a_of_type_Ztu.firstResume)
    {
      this.jdField_a_of_type_Ztu.firstResume = false;
      if (this.jdField_a_of_type_Ztu.photoListStartPos != -1) {
        break label344;
      }
      i = ztu.sPhotoListFirstPos;
      if (i != -1) {
        break label373;
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
        if (this.jdField_a_of_type_Ztu.isRecodeLastAlbumPath)
        {
          localObject = paramList.iterator();
          k = 0;
          label157:
          i = j;
          if (((Iterator)localObject).hasNext())
          {
            if (((LocalMediaInfo)((Iterator)localObject).next()).selectStatus != 3) {
              break label355;
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
            int n = paramList.size();
            localObject = (String)((ArrayList)localObject).get(((ArrayList)localObject).size() - 1);
            k = m;
            label262:
            j = i;
            if (k < n)
            {
              if (!((String)localObject).equals(((LocalMediaInfo)paramList.get(k)).path)) {
                break label364;
              }
              j = k;
            }
          }
        }
      }
      label296:
      i = ((awuv)this.bu.get()).a.getItemCount();
      if (i != 0) {
        break label382;
      }
    }
    for (;;)
    {
      ((awuv)this.bu.get()).E.post(new AEPhotoListLogicDefault.7(this));
      return true;
      label344:
      i = this.jdField_a_of_type_Ztu.photoListStartPos;
      break;
      label355:
      k += 1;
      break label157;
      label364:
      k += 1;
      break label262;
      label373:
      ztu.sPhotoListFirstPos = -1;
      j = i;
      break label296;
      label382:
      if ((j > i - 1) || (j >= 0)) {}
    }
  }
  
  public void onSendBtnClick(View paramView)
  {
    if (!this.mPhotoCommonData.selectedPhotoList.isEmpty()) {
      ((awuv)this.bu.get()).recordLastPos((String)this.mPhotoCommonData.selectedPhotoList.get(this.mPhotoCommonData.selectedPhotoList.size() - 1));
    }
    aqfy.clearCache();
    if (this.mPhotoCommonData.selectedPhotoList.size() == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.e("PhotoList", 2, "size == 0");
      }
      return;
    }
    if (((awuv)this.bu.get()).getActivity().getIntent().getBooleanExtra("PhotoConst.IS_SEND_FILESIZE_LIMIT", false))
    {
      paramView = this.mPhotoCommonData.selectedPhotoList.iterator();
      for (long l = 0L; paramView.hasNext(); l = aqhq.getFileSizes((String)paramView.next()) + l) {}
      if (ahav.amK())
      {
        ahal.a(((awuv)this.bu.get()).getActivity(), 2131693826, 2131693832, new awvj(this));
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
    paramView = ((awuv)this.bu.get()).getActivity().getIntent();
    if (this.mPhotoCommonData.selectedPhotoList != null) {}
    for (int i = this.mPhotoCommonData.selectedPhotoList.size();; i = 0)
    {
      zsz.k(paramView, i);
      if (this.jdField_a_of_type_Ztu.bti) {
        break;
      }
      ((awuv)this.bu.get()).getActivity().finish();
      aqfy.anim(((awuv)this.bu.get()).getActivity(), false, false);
      return;
    }
    paramView = ((awuv)this.bu.get()).getActivity().getIntent();
    String str1 = paramView.getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
    String str2 = paramView.getStringExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME");
    if (str1 == null)
    {
      QQToast.a(((awuv)this.bu.get()).getActivity(), "请设置INIT_ACTIVITY_CLASS_NAME ", 0).show();
      return;
    }
    paramView.setClassName(str2, str1);
    paramView.removeExtra("PhotoConst.PHOTO_PATHS");
    paramView.removeExtra("PhotoConst.SINGLE_PHOTO_PATH");
    paramView.addFlags(603979776);
    ((awuv)this.bu.get()).startActivity(paramView);
    ((awuv)this.bu.get()).getActivity().finish();
    aqfy.anim(((awuv)this.bu.get()).getActivity(), false, false);
  }
  
  public void postInitUI()
  {
    updateButton();
  }
  
  public void processQueryResult(List<LocalMediaInfo> paramList)
  {
    zsh.a(paramList, null, this.jdField_a_of_type_Ztu.hy);
  }
  
  public void sA(String paramString)
  {
    Intent localIntent = ((awuv)this.bu.get()).getActivity().getIntent();
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
    if ((i > 0) && (i < ((awuv)this.bu.get()).a.getItemCount()))
    {
      localObject = ((awuv)this.bu.get()).a.getItem(i);
      if ((localObject != null) && (!localHashMap.containsKey(((LocalMediaInfo)localObject).path))) {
        localHashMap.put(((LocalMediaInfo)localObject).path, localObject);
      }
    }
    localIntent.putExtra("PeakConstants.selectedMediaInfoHashMap", localHashMap);
    localIntent.putExtra("PhotoConst.SHOW_ALBUM", false);
    localIntent.putExtra("FROM_WHERE", "FROM_PHOTO_LIST");
    ztu.sPhotoListFirstPos = ((GridLayoutManager)((awuv)this.bu.get()).E.getLayoutManager()).findFirstVisibleItemPosition();
    localIntent.putExtra("PhotoConst.CURRENT_SELECTED_INDEX", localArrayList.indexOf(paramString));
    localIntent.setClass(((awuv)this.bu.get()).getActivity(), NewPhotoPreviewActivity.class);
    localIntent.addFlags(603979776);
    startPhotoPreviewActivity(localIntent);
    aqfy.anim(((awuv)this.bu.get()).getActivity(), true, true);
  }
  
  public void startPhotoPreviewActivity(Intent paramIntent)
  {
    super.startPhotoPreviewActivity(paramIntent);
  }
  
  protected void submit()
  {
    if (this.mPhotoCommonData.albumId.equals("$RecentAlbumId")) {
      anpc.a(((awuv)this.bu.get()).getActivity()).collectPerformance(null, "sendAlbumRecent", true, 0L, 0L, null, "");
    }
    PresendPicMgr localPresendPicMgr;
    for (;;)
    {
      localPresendPicMgr = PresendPicMgr.a();
      if ((!this.jdField_a_of_type_Ztu.btm) || ((TextUtils.isEmpty(this.jdField_a_of_type_Ztu.pasterId)) && (TextUtils.isEmpty(this.jdField_a_of_type_Ztu.baR)))) {
        break;
      }
      return;
      if ((this.mPhotoCommonData.albumName.equalsIgnoreCase("Camera")) || (this.mPhotoCommonData.albumName.equalsIgnoreCase("camera")) || (this.mPhotoCommonData.albumName.contains("Camera")) || (this.mPhotoCommonData.albumName.contains("camera"))) {
        anpc.a(((awuv)this.bu.get()).getActivity()).collectPerformance(null, "sendAlbumRecent", false, 0L, 0L, null, "");
      } else {
        anpc.a(((awuv)this.bu.get()).getActivity()).collectPerformance(null, "sendAlbumOther", true, 0L, 0L, null, "");
      }
    }
    if (this.mPhotoCommonData.selectedPhotoList != null)
    {
      zsz.j(((awuv)this.bu.get()).getActivity().getIntent(), this.mPhotoCommonData.selectedPhotoList.size());
      zsz.d(((awuv)this.bu.get()).getActivity().getIntent(), this.mPhotoCommonData.selectedPhotoList.size(), this.mPhotoCommonData.currentQualityType);
    }
    Intent localIntent = ((awuv)this.bu.get()).getActivity().getIntent();
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
      if ((localPresendPicMgr != null) && (!this.jdField_a_of_type_Ztu.btr) && (!localIntent.getBooleanExtra("PhotoConst.SEND_NO_PRESEND", false))) {
        localPresendPicMgr.dD(localIntent);
      }
    }
  }
  
  protected void updateButton()
  {
    super.updateButton();
    ArrayList localArrayList = this.mPhotoCommonData.selectedPhotoList;
    if ((localArrayList.size() <= 0) || (QLog.isColorLevel())) {
      QLog.d("_photo", 2, "updateButton selectedPhotoList.size()=" + localArrayList.size());
    }
    cfa();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awvf
 * JD-Core Version:    0.7.0.1
 */