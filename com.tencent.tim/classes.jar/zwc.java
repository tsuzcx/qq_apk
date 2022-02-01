import NS_MOBILE_OPERATION.PicInfo;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.component.media.image.ImageManager;
import com.tencent.component.network.utils.NetworkUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.PhotoSendParams;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.activity.photo.SendPhotoActivity;
import com.tencent.mobileqq.activity.photo.album.AbstractPhotoPreviewActivity;
import com.tencent.mobileqq.activity.photo.album.NewPhotoPreviewActivity;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.activity.photo.album.logicImp.PhotoPreviewLogicAIO.2;
import com.tencent.mobileqq.activity.photo.album.preview.BasePreviewAdapter;
import com.tencent.mobileqq.activity.shortvideo.SendVideoActivity.SendVideoInfo;
import com.tencent.mobileqq.pic.PresendPicMgr;
import com.tencent.mobileqq.widget.NumberCheckBox;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.BinderWarpper;
import com.tencent.util.Pair;
import com.tencent.widget.AdapterView;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class zwc
  extends zug
{
  private aqmd a;
  boolean btH = false;
  boolean btI = false;
  protected boolean bue;
  protected boolean buf;
  public boolean isFromAIO;
  
  zwc(NewPhotoPreviewActivity paramNewPhotoPreviewActivity)
  {
    super(paramNewPhotoPreviewActivity);
  }
  
  void FF(int paramInt)
  {
    ((NewPhotoPreviewActivity)this.mActivity).magicStickBtn.setVisibility(paramInt);
    ((NewPhotoPreviewActivity)this.mActivity).qualityCheckBox.setVisibility(paramInt);
    ((NewPhotoPreviewActivity)this.mActivity).qualityTv.setVisibility(paramInt);
    if (paramInt == 0)
    {
      if (!this.jdField_a_of_type_Zud.btw)
      {
        ((NewPhotoPreviewActivity)this.mActivity).qualityCheckBox.setVisibility(8);
        ((NewPhotoPreviewActivity)this.mActivity).qualityTv.setVisibility(8);
      }
      if (!this.jdField_a_of_type_Zud.btm) {
        ((NewPhotoPreviewActivity)this.mActivity).magicStickBtn.setVisibility(8);
      }
      if ((this.jdField_a_of_type_Zud.btA) && (this.jdField_a_of_type_Zud.selectedQzonePhotos.size() == 0))
      {
        ((NewPhotoPreviewActivity)this.mActivity).flashPicCb.setVisibility(0);
        ((NewPhotoPreviewActivity)this.mActivity).flashTv.setVisibility(0);
        ((NewPhotoPreviewActivity)this.mActivity).flashPicCb.setOnCheckedChangeListener(this.mActivity);
        ((NewPhotoPreviewActivity)this.mActivity).flashTv.setOnClickListener(new zwd(this));
        ((NewPhotoPreviewActivity)this.mActivity).flashPicCb.setContentDescription("闪照");
        ((NewPhotoPreviewActivity)this.mActivity).flashTv.setContentDescription("闪照");
      }
    }
    while (((NewPhotoPreviewActivity)this.mActivity).flashPicCb.getVisibility() != 0) {
      return;
    }
    ((NewPhotoPreviewActivity)this.mActivity).flashPicCb.setVisibility(paramInt);
    ((NewPhotoPreviewActivity)this.mActivity).flashTv.setVisibility(paramInt);
  }
  
  void FG(int paramInt)
  {
    ((NewPhotoPreviewActivity)this.mActivity).magicStickBtn.setVisibility(paramInt);
    ((NewPhotoPreviewActivity)this.mActivity).qualityCheckBox.setVisibility(0);
    ((NewPhotoPreviewActivity)this.mActivity).qualityTv.setVisibility(0);
    if (((NewPhotoPreviewActivity)this.mActivity).flashPicCb.getVisibility() == 0)
    {
      ((NewPhotoPreviewActivity)this.mActivity).flashPicCb.setVisibility(paramInt);
      ((NewPhotoPreviewActivity)this.mActivity).flashTv.setVisibility(paramInt);
    }
  }
  
  protected void G(TextView paramTextView)
  {
    Object localObject = this.mPhotoCommonData.selectedPhotoList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      if ((!NetworkUtils.isNetworkUrl(str)) && (((NewPhotoPreviewActivity)this.mActivity).getMediaType(str) == 1)) {
        paramTextView.setText(((NewPhotoPreviewActivity)this.mActivity).getString(2131696911));
      }
    }
    int i = aqfy.a(this.mPhotoCommonData.selectedPhotoList, this.mPhotoCommonData.allMediaInfoHashMap, true, this.jdField_a_of_type_Zud.hA, this.mPhotoCommonData.selectedMediaInfoHashMap);
    if (i == 0)
    {
      paramTextView.setText(((NewPhotoPreviewActivity)this.mActivity).getString(2131696911));
      return;
    }
    localObject = PhotoUtils.a(this.mActivity, i);
    if ((this.mPhotoCommonData.selectedPhotoList.size() == 0) || (((String)localObject).equals("0"))) {}
    for (localObject = ((NewPhotoPreviewActivity)this.mActivity).getString(2131696911);; localObject = ((NewPhotoPreviewActivity)this.mActivity).getString(2131696911) + "(共" + (String)localObject + ")")
    {
      paramTextView.setText((CharSequence)localObject);
      return;
    }
  }
  
  protected boolean VQ()
  {
    Object localObject = (String)this.jdField_a_of_type_Zud.paths.get(((NewPhotoPreviewActivity)this.mActivity).getCurrentSelectedPostion());
    if (((NewPhotoPreviewActivity)this.mActivity).getMediaType((String)localObject) == 1)
    {
      localObject = ((NewPhotoPreviewActivity)this.mActivity).getMediaInfo((String)localObject);
      if ((localObject != null) && (((LocalMediaInfo)localObject).fileSize > 104345600L))
      {
        QQToast.a(this.mActivity, ((NewPhotoPreviewActivity)this.mActivity).getResources().getString(2131720265), 0).show(((NewPhotoPreviewActivity)this.mActivity).getResources().getDimensionPixelSize(2131299627));
        aqfy.edE();
      }
      return false;
    }
    return super.VQ();
  }
  
  public Intent a(ArrayList<String> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() <= 0)) {
      return null;
    }
    Intent localIntent = ((NewPhotoPreviewActivity)this.mActivity).getIntent();
    localIntent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", paramArrayList);
    localIntent.putExtra("PhotoConst.editPathMap", this.jdField_a_of_type_Zud.editPathMap);
    localIntent.putExtra("PhotoConst.CURRENT_QUALITY_TYPE", this.mPhotoCommonData.currentQualityType);
    return localIntent;
  }
  
  public void a(Intent paramIntent, boolean paramBoolean, ArrayList<String> paramArrayList)
  {
    localPair = new Pair(new ArrayList(), new ArrayList());
    if (this.jdField_a_of_type_Aqmd != null)
    {
      localObject1 = this.jdField_a_of_type_Aqmd;
      if (this.mPhotoCommonData.currentQualityType == 2) {
        bool = true;
      }
    }
    for (;;)
    {
      paramArrayList = ((aqmd)localObject1).a(paramArrayList, bool, this.mPhotoCommonData.selectedMediaInfoHashMap, this.mPhotoCommonData.allMediaInfoHashMap);
      ((ArrayList)localPair.first).addAll((Collection)paramArrayList.first);
      ((ArrayList)localPair.second).addAll((Collection)paramArrayList.second);
      paramIntent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS_BY_FILE", (ArrayList)localPair.second);
      i2 = 0;
      i = -1;
      try
      {
        m = PhotoUtils.c((SessionInfo)paramIntent.getParcelableExtra("session_info"));
        paramArrayList = new HashMap();
        j = 0;
        i = 0;
        int n = 0;
        k = 0;
        for (;;)
        {
          if (n < ((ArrayList)localPair.first).size())
          {
            localObject1 = (String)((ArrayList)localPair.first).get(n);
            if (ImageManager.isNetworkUrl((String)localObject1))
            {
              i1 = k;
              k = i;
              i = i1;
              n += 1;
              i1 = k;
              k = i;
              i = i1;
              continue;
              bool = false;
              break;
              ((ArrayList)localPair.first).addAll(paramArrayList);
            }
          }
        }
      }
      catch (Exception paramArrayList)
      {
        int j;
        int k;
        int i1;
        for (;;)
        {
          m = i;
          if (QLog.isColorLevel())
          {
            QLog.e("PhotoPreviewActivity", 2, "submit", paramArrayList);
            m = i;
          }
        }
        if (((NewPhotoPreviewActivity)this.mActivity).getMediaType((String)localObject1) == 1)
        {
          localObject1 = ((NewPhotoPreviewActivity)this.mActivity).getMediaInfo((String)localObject1);
          localObject2 = new SendVideoActivity.SendVideoInfo();
          i += 1;
          ((SendVideoActivity.SendVideoInfo)localObject2).fileSize = ((LocalMediaInfo)localObject1).fileSize;
          ((SendVideoActivity.SendVideoInfo)localObject2).duration = ((LocalMediaInfo)localObject1).mDuration;
          paramArrayList.put(Integer.valueOf(k), localObject2);
        }
        for (;;)
        {
          i1 = k + 1;
          k = i;
          i = i1;
          break;
          j += 1;
        }
        localObject1 = String.valueOf(j);
        localObject2 = String.valueOf(i);
      }
    }
    try
    {
      paramIntent.setExtrasClassLoader(SessionInfo.class.getClassLoader());
      if (paramArrayList.isEmpty()) {
        break label798;
      }
      paramIntent.putExtra("PhotoConst.VIDEO_INFOS", paramArrayList);
      i = 1;
    }
    catch (Exception paramArrayList)
    {
      for (;;)
      {
        i = i2;
        if (QLog.isColorLevel())
        {
          QLog.d("PhotoPreviewActivity", 2, "put extra Exception");
          i = i2;
          continue;
          bool = false;
          continue;
          if (paramBoolean)
          {
            PhotoUtils.a(this.mActivity, paramIntent, (ArrayList)localPair.first, this.jdField_a_of_type_Zud.hA, this.mPhotoCommonData.currentQualityType, true);
            ((NewPhotoPreviewActivity)this.mActivity).setResult(-1);
            ((NewPhotoPreviewActivity)this.mActivity).finish();
          }
          for (;;)
          {
            anot.a(null, "CliOper", "", "", "0X8009AB1", "0X8009AB1", m, 0, (String)localObject1, (String)localObject2, "", "");
            return;
            PhotoUtils.a(this.mActivity, paramIntent, (ArrayList)localPair.first, this.mPhotoCommonData.currentQualityType, this.jdField_a_of_type_Zud.bjL);
          }
          i = 0;
        }
      }
    }
    if ((anfr.akV != 0L) && (System.currentTimeMillis() - anfr.akV < 300000L))
    {
      bool = true;
      if (QLog.isColorLevel()) {
        QLog.d("PhotoPreviewActivity", 2, "upload video isConfirmed=" + bool + " allowUploadInXGTime=" + anfr.akV);
      }
      if ((!aqiw.isMobileNetWork(BaseApplicationImpl.getContext())) || (bool) || (i == 0) || (!VP())) {
        break label676;
      }
      paramArrayList = ((NewPhotoPreviewActivity)this.mActivity).getResources().getString(2131719478);
      paramIntent = new PhotoPreviewLogicAIO.2(this, paramBoolean, paramIntent, localPair, m, (String)localObject1, (String)localObject2);
      if (armm.a(this.mActivity, 4, new zwe(this, paramIntent))) {
        aqha.a(this.mActivity, 232, null, paramArrayList, new zwf(this, paramIntent), new zwg(this)).show();
      }
      if (QLog.isColorLevel()) {
        QLog.i("PhotoPreviewActivity", 2, "show shortvideo_mobile_send_confirm dialog");
      }
    }
  }
  
  public void initData(Intent paramIntent)
  {
    this.jdField_a_of_type_Zud.btm = true;
    this.isFromAIO = paramIntent.getBooleanExtra("PhotoConst.QZONE_ALBUM_FROM_AIO", false);
    this.btH = paramIntent.getBooleanExtra("KEY_IS_ANONYMOUS", false);
    this.bue = paramIntent.getBooleanExtra("input_full_screen_mode", false);
    this.buf = paramIntent.getBooleanExtra("input_full_screen_click", false);
    super.initData(paramIntent);
    if (!this.jdField_a_of_type_Zud.isSingleMode)
    {
      Object localObject = (BinderWarpper)paramIntent.getParcelableExtra("binder_presendService");
      if (localObject != null)
      {
        if (PresendPicMgr.a(null) != null) {
          PresendPicMgr.a(null).release();
        }
        localObject = PresendPicMgr.b(akxc.a.a(((BinderWarpper)localObject).binder));
        this.jdField_a_of_type_Zud.busiType = 1037;
        paramIntent = (String)paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS").get(0);
        if (((NewPhotoPreviewActivity)this.mActivity).getMediaType(paramIntent) != 1) {
          ((PresendPicMgr)localObject).cE(paramIntent, this.jdField_a_of_type_Zud.busiType);
        }
      }
    }
    this.jdField_a_of_type_Zud.customSendBtnText = ((NewPhotoPreviewActivity)this.mActivity).getResources().getString(2131696942);
    if (this.bue) {
      this.jdField_a_of_type_Zud.customSendBtnText = ((NewPhotoPreviewActivity)this.mActivity).getResources().getString(2131696878);
    }
    zsz.crE();
    if (this.mPhotoCommonData.currentQualityType == 2) {
      this.btI = true;
    }
    paramIntent = new aqmd().a(((zuc)this.mOtherCommonData).cfh).b(this.mPhotoCommonData.videoSizeLimit);
    if ((!this.btH) && (!this.jdField_a_of_type_Zud.btr)) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Aqmd = paramIntent.a(bool);
      return;
    }
  }
  
  public void initUI()
  {
    super.initUI();
    if ((this.isFromAIO) && (this.jdField_a_of_type_Zud.hA.size() != 0)) {
      ((NewPhotoPreviewActivity)this.mActivity).magicStickBtn.setVisibility(8);
    }
    if (this.buf)
    {
      super.FC(8);
      ((NewPhotoPreviewActivity)this.mActivity).selectedBox.setVisibility(8);
      ((NewPhotoPreviewActivity)this.mActivity).titleView.setVisibility(8);
    }
  }
  
  public boolean needShowMultiPhoto()
  {
    return (this.mPhotoCommonData.selectedPhotoList != null) && (!this.mPhotoCommonData.selectedPhotoList.isEmpty());
  }
  
  public void onGalleryItemSelected(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    LocalMediaInfo localLocalMediaInfo = ((NewPhotoPreviewActivity)this.mActivity).getMediaInfo(((NewPhotoPreviewActivity)this.mActivity).adapter.getItem(paramInt));
    if ((localLocalMediaInfo != null) && (((NewPhotoPreviewActivity)this.mActivity).getMediaType(localLocalMediaInfo.path) == 1)) {
      if ((this.jdField_a_of_type_Zud.cZ == 0) || (this.jdField_a_of_type_Zud.cZ == 1) || (this.jdField_a_of_type_Zud.cZ == 3000)) {
        FG(8);
      }
    }
    for (;;)
    {
      super.onGalleryItemSelected(paramAdapterView, paramView, paramInt, paramLong);
      return;
      FF(8);
      continue;
      FF(0);
    }
  }
  
  public void onMagicStickClick(View paramView, int paramInt1, Bundle paramBundle, int paramInt2, Intent paramIntent)
  {
    paramBundle.putBoolean("key_multi_edit_pic", true);
    paramBundle.putBoolean("key_enable_edit_title_bar", true);
    super.onMagicStickClick(paramView, 10000, paramBundle, 2, null);
  }
  
  public void onQualityBtnClick(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      ((NewPhotoPreviewActivity)this.mActivity).flashPicCb.setChecked(false);
      ((NewPhotoPreviewActivity)this.mActivity).flashTv.setTextColor(2147483647);
      if (this.jdField_a_of_type_Aqmd != null)
      {
        if (this.btI) {
          break label175;
        }
        this.jdField_a_of_type_Aqmd.a(this.mActivity, this.mPhotoCommonData.selectedPhotoList, paramBoolean, this.mPhotoCommonData.selectedMediaInfoHashMap, this.mPhotoCommonData.allMediaInfoHashMap);
      }
      for (;;)
      {
        this.mPhotoCommonData.currentQualityType = 2;
        ((NewPhotoPreviewActivity)this.mActivity).qualityCheckBox.setChecked(true);
        updateButton();
        paramCompoundButton = ((NewPhotoPreviewActivity)this.mActivity).getIntent();
        if ((paramCompoundButton != null) && (paramCompoundButton.hasExtra("custom_photopreview_rawcheckbox_reportActionName")))
        {
          paramCompoundButton = paramCompoundButton.getStringExtra("custom_photopreview_rawcheckbox_reportActionName");
          if (paramCompoundButton != null) {
            anot.a(null, "CliOper", "", "", paramCompoundButton, paramCompoundButton, 0, 0, "", "", "", "");
          }
        }
        return;
        label175:
        this.btI = false;
      }
    }
    ((NewPhotoPreviewActivity)this.mActivity).flashTv.setTextColor(-1);
    this.mPhotoCommonData.currentQualityType = 0;
    cfa();
  }
  
  public void onSelectClick(View paramView)
  {
    ((NewPhotoPreviewActivity)this.mActivity).getResources();
    paramView = PresendPicMgr.a(null);
    int k = ((NewPhotoPreviewActivity)this.mActivity).getCurrentSelectedPostion();
    int i;
    if (this.mPhotoCommonData.selectedIndex.contains(Integer.valueOf(k)))
    {
      ((NewPhotoPreviewActivity)this.mActivity).selectedBox.setChecked(false);
      i = this.mPhotoCommonData.selectedIndex.indexOf(Integer.valueOf(k));
      if (i >= 0)
      {
        this.mPhotoCommonData.selectedIndex.remove(i);
        if (k != -1)
        {
          this.mPhotoCommonData.selectedPhotoList.remove(this.jdField_a_of_type_Zud.paths.get(k));
          if (this.jdField_a_of_type_Zud.selectedQzonePhotos != null) {
            this.jdField_a_of_type_Zud.selectedQzonePhotos.remove(this.jdField_a_of_type_Zud.paths.get(k));
          }
          if (this.jdField_a_of_type_Zud.hA != null) {
            this.jdField_a_of_type_Zud.hA.remove(this.jdField_a_of_type_Zud.paths.get(k));
          }
          if (paramView != null) {
            paramView.fx((String)this.jdField_a_of_type_Zud.paths.get(k), 1014);
          }
        }
      }
      updateButton();
      if ((this.mPhotoCommonData.selectedIndex.size() == 0) && (!this.jdField_a_of_type_Zud.btB)) {
        this.jdField_a_of_type_Zud.btD = false;
      }
      LpReportInfo_pf00064.allReport(603, 2);
      return;
    }
    int j;
    label284:
    long l;
    Object localObject;
    if (this.mPhotoCommonData.selectedPhotoList.size() >= this.mPhotoCommonData.maxSelectNum)
    {
      i = 1;
      if (i == 0) {
        break label482;
      }
      j = 2;
      anot.a(null, "dc00898", "", "", "0X800AB6E", "0X800AB6E", j, 0, "", "", "", "");
      if (i == 0) {
        break label501;
      }
      l = System.currentTimeMillis();
      if (l - this.jdField_a_of_type_Zud.lastTimeShowToast >= 700L)
      {
        localObject = this.mActivity;
        if (!this.bue) {
          break label487;
        }
      }
    }
    label482:
    label487:
    for (paramView = ((NewPhotoPreviewActivity)this.mActivity).getResources().getString(2131696893, new Object[] { Integer.valueOf(this.mPhotoCommonData.maxSelectNum) });; paramView = ((NewPhotoPreviewActivity)this.mActivity).getExceedMaxSelectNumStr())
    {
      QQToast.a((Context)localObject, paramView, 1000).show(this.jdField_a_of_type_Zud.titleBarHeight);
      this.jdField_a_of_type_Zud.lastTimeShowToast = l;
      if (this.jdField_a_of_type_Zud.btr) {
        anot.a(null, "CliOper", "", "", "0x80083EC", "0x80083EC", 0, 0, "", "", "", "");
      }
      ((NewPhotoPreviewActivity)this.mActivity).selectedBox.setChecked(false);
      return;
      i = 0;
      break;
      j = 1;
      break label284;
    }
    label501:
    AbstractPhotoPreviewActivity localAbstractPhotoPreviewActivity;
    if (k != -1)
    {
      localObject = (String)this.jdField_a_of_type_Zud.paths.get(k);
      ((NewPhotoPreviewActivity)this.mActivity).getMediaInfo((String)localObject);
      if ((paramView != null) && (!this.jdField_a_of_type_Zud.btB) && (((NewPhotoPreviewActivity)this.mActivity).getMediaType((String)this.jdField_a_of_type_Zud.paths.get(k)) != 1)) {
        paramView.cE((String)this.jdField_a_of_type_Zud.paths.get(k), this.jdField_a_of_type_Zud.busiType);
      }
      paramView = (String)this.jdField_a_of_type_Zud.paths.get(k);
      this.mPhotoCommonData.selectedPhotoList.add(paramView);
      if (this.jdField_a_of_type_Zud.hz != null)
      {
        localObject = (PhotoSendParams)this.jdField_a_of_type_Zud.hz.get(paramView);
        if ((this.jdField_a_of_type_Zud.hA != null) && (localObject != null)) {
          this.jdField_a_of_type_Zud.hA.put(paramView, localObject);
        }
      }
      if (this.jdField_a_of_type_Zud.hB != null)
      {
        localObject = (PicInfo)this.jdField_a_of_type_Zud.hB.get(paramView);
        if ((this.jdField_a_of_type_Zud.selectedQzonePhotos != null) && (localObject != null)) {
          this.jdField_a_of_type_Zud.selectedQzonePhotos.put(paramView, localObject);
        }
      }
      this.mPhotoCommonData.selectedIndex.add(Integer.valueOf(k));
      ((NewPhotoPreviewActivity)this.mActivity).setCheckedNumber(paramView);
      if (this.jdField_a_of_type_Aqmd != null)
      {
        localObject = this.jdField_a_of_type_Aqmd;
        localAbstractPhotoPreviewActivity = this.mActivity;
        if (this.mPhotoCommonData.currentQualityType != 2) {
          break label837;
        }
      }
    }
    label837:
    for (boolean bool = true;; bool = false)
    {
      ((aqmd)localObject).a(localAbstractPhotoPreviewActivity, paramView, bool, this.mPhotoCommonData.selectedMediaInfoHashMap, this.mPhotoCommonData.allMediaInfoHashMap, true);
      updateButton();
      break;
    }
  }
  
  protected void submit()
  {
    Object localObject4 = ((NewPhotoPreviewActivity)this.mActivity).getIntent();
    Object localObject3;
    Object localObject2;
    int i;
    if (this.jdField_a_of_type_Zud.btB)
    {
      ((Intent)localObject4).putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1040);
      if (this.jdField_a_of_type_Zud.cZ == 0)
      {
        anot.a(null, "dc00898", "", "", "0X80069A6", "0X80069A6", 0, 0, "", "", "", "");
        anot.a(null, "dc00898", "", "", "0X800699A", "0X800699A", 0, 0, "", "", "", "");
      }
    }
    else
    {
      if ((localObject4 != null) && (((Intent)localObject4).getBooleanExtra("custom_photopreview_sendbtn_report", false)))
      {
        localObject3 = ((Intent)localObject4).getStringExtra("custom_photopreview_sendbtn_reportActionName");
        localObject2 = ((Intent)localObject4).getStringExtra("custom_photopreview_sendbtn_album_reportReverse2");
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = ((Intent)localObject4).getStringExtra("custom_photopreview_sendbtn_camera_reportReverse2");
        }
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = ((Intent)localObject4).getStringExtra("custom_photopreview_sendbtn_reportReverse2");
        }
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        if ((localObject3 != null) && (localObject1 != null)) {
          anot.a(null, "CliOper", "", "", (String)localObject3, (String)localObject3, 0, 0, (String)localObject1, "", "", "");
        }
      }
      if ((!needShowMultiPhoto()) || (this.jdField_a_of_type_Zud.cfk <= 0)) {
        break label608;
      }
      localObject1 = this.mPhotoCommonData.selectedPhotoList.iterator();
      i = 0;
    }
    for (;;)
    {
      if (!((Iterator)localObject1).hasNext()) {
        break label518;
      }
      localObject2 = (String)((Iterator)localObject1).next();
      localObject3 = this.jdField_a_of_type_Zud.editPathMap.values().iterator();
      for (;;)
      {
        if (((Iterator)localObject3).hasNext())
        {
          localObject4 = (String)((Iterator)localObject3).next();
          if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (!TextUtils.isEmpty((CharSequence)localObject4)) && (((String)localObject2).equals(localObject4)))
          {
            i += 1;
            continue;
            if (this.jdField_a_of_type_Zud.cZ == 3000)
            {
              anot.a(null, "dc00898", "", "", "0X80069A7", "0X80069A7", 0, 0, "", "", "", "");
              anot.a(null, "dc00898", "", "", "0X800699B", "0X800699B", 0, 0, "", "", "", "");
              break;
            }
            if (this.jdField_a_of_type_Zud.cZ != 1) {
              break;
            }
            anot.a(null, "dc00898", "", "", "0X80069A8", "0X80069A8", 0, 0, "", "", "", "");
            anot.a(null, "dc00898", "", "", "0X800699C", "0X800699C", 0, 0, "", "", "", "");
            break;
          }
        }
      }
    }
    label518:
    Object localObject1 = new StringBuilder();
    int j;
    if (this.mPhotoCommonData.selectedPhotoList != null)
    {
      j = this.mPhotoCommonData.selectedPhotoList.size();
      anot.a(null, "dc00898", "", "", "0X800A070", "0X800A070", 0, 0, j + "", i + "", "", "");
      label608:
      if (!"FROM_QZONE_PHOTO_LIST".equals(this.jdField_a_of_type_Zud.from)) {
        break label842;
      }
      localObject1 = ((NewPhotoPreviewActivity)this.mActivity).getSubmitPhotoList();
      if ((localObject1 != null) && (((ArrayList)localObject1).size() == 1))
      {
        localObject1 = (String)((ArrayList)localObject1).get(0);
        if ((localObject1 != null) && (((String)localObject1).startsWith("http")))
        {
          localObject2 = (PhotoSendParams)this.jdField_a_of_type_Zud.hz.get(localObject1);
          if (localObject2 != null) {
            this.jdField_a_of_type_Zud.hA.put(localObject1, localObject2);
          }
        }
      }
      if (this.mPhotoCommonData.selectedPhotoList.size() != 0)
      {
        if (((NewPhotoPreviewActivity)this.mActivity).getIntent().getParcelableExtra("PhotoConst.sendToAIOIntent") == null) {
          break label828;
        }
        localObject1 = (Intent)((NewPhotoPreviewActivity)this.mActivity).getIntent().getParcelableExtra("PhotoConst.sendToAIOIntent");
        label760:
        ((Intent)localObject1).setExtrasClassLoader(avfo.class.getClassLoader());
        ((Intent)localObject1).putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1052);
        ((Intent)localObject1).putExtra("PhotoConst.DEST_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
        ((Intent)localObject1).putExtra("PhotoConst.DEST_ACTIVITY_CLASS_NAME", SendPhotoActivity.class.getName());
        a((Intent)localObject1, true, ((NewPhotoPreviewActivity)this.mActivity).getSubmitPhotoList());
      }
    }
    label828:
    label842:
    do
    {
      return;
      j = 0;
      break;
      localObject1 = ((NewPhotoPreviewActivity)this.mActivity).getIntent();
      break label760;
      if (!this.bue) {
        break label891;
      }
      localObject1 = a(((NewPhotoPreviewActivity)this.mActivity).getSubmitPhotoList());
    } while (localObject1 == null);
    ((NewPhotoPreviewActivity)this.mActivity).setResult(-1, (Intent)localObject1);
    ((NewPhotoPreviewActivity)this.mActivity).finish();
    return;
    label891:
    super.submit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zwc
 * JD-Core Version:    0.7.0.1
 */