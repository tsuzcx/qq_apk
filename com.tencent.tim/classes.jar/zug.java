import NS_MOBILE_OPERATION.PicInfo;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.qqstory.takevideo.slideshow.SlideItemInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.component.media.image.ImageManager;
import com.tencent.component.network.utils.NetworkUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.photo.DragGallery;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.PhotoSendParams;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.activity.photo.album.NewPhotoPreviewActivity;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.activity.photo.album.PhotoPreviewLogic.IonCheckedChangedCallback;
import com.tencent.mobileqq.activity.photo.album.PhotoPreviewLogicBase;
import com.tencent.mobileqq.activity.photo.album.PhotoPreviewLogicDefault.5;
import com.tencent.mobileqq.activity.photo.album.PhotoPreviewLogicDefault.9;
import com.tencent.mobileqq.activity.photo.album.preview.BasePreviewAdapter;
import com.tencent.mobileqq.activity.shortvideo.SendVideoActivity.SendVideoInfo;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pic.PresendPicMgr;
import com.tencent.mobileqq.widget.NumberCheckBox;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.BubblePopupWindow;
import com.tencent.widget.DragView;
import com.tencent.widget.HorizontalListView;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import dov.com.tencent.biz.qqstory.takevideo.EditPicActivity;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import mqq.app.AppRuntime;

public class zug
  extends PhotoPreviewLogicBase<NewPhotoPreviewActivity, zuc>
  implements PhotoPreviewLogic.IonCheckedChangedCallback, rmd.a
{
  public zud a;
  zug.a a;
  
  public zug(NewPhotoPreviewActivity paramNewPhotoPreviewActivity)
  {
    super(paramNewPhotoPreviewActivity);
    this.jdField_a_of_type_Zug$a = null;
    this.mOnCheckedChangedCallback = this;
    this.mPhotoPreviewData = new zud();
    this.jdField_a_of_type_Zud = ((zud)this.mPhotoPreviewData);
  }
  
  private void btE()
  {
    ((NewPhotoPreviewActivity)this.mActivity).mEnableLiuHai = false;
    ((NewPhotoPreviewActivity)this.mActivity).top_blackLH = ((LinearLayout)((NewPhotoPreviewActivity)this.mActivity).findViewById(2131363559));
    ((NewPhotoPreviewActivity)this.mActivity).bottom_blackLH = ((RelativeLayout)((NewPhotoPreviewActivity)this.mActivity).findViewById(2131363557));
    if (((zuc)this.mOtherCommonData).VO()) {
      ((NewPhotoPreviewActivity)this.mActivity).mEnableLiuHai = ayxa.a(((NewPhotoPreviewActivity)this.mActivity).top_blackLH, ((NewPhotoPreviewActivity)this.mActivity).bottom_blackLH, 0);
    }
    while (((NewPhotoPreviewActivity)this.mActivity).top_blackLH == null) {
      return;
    }
    ViewGroup.LayoutParams localLayoutParams = ((NewPhotoPreviewActivity)this.mActivity).top_blackLH.getLayoutParams();
    localLayoutParams.height = ayxa.sNotchHeight;
    ((NewPhotoPreviewActivity)this.mActivity).top_blackLH.setLayoutParams(localLayoutParams);
    ((NewPhotoPreviewActivity)this.mActivity).top_blackLH.setVisibility(0);
    ((NewPhotoPreviewActivity)this.mActivity).mEnableLiuHai = true;
  }
  
  protected void FA(int paramInt)
  {
    Object localObject1 = PresendPicMgr.a(null);
    if (this.mPhotoCommonData.selectedPhotoList.size() >= this.mPhotoCommonData.maxSelectNum)
    {
      long l = System.currentTimeMillis();
      if (l - this.jdField_a_of_type_Zud.lastTimeShowToast >= 700L)
      {
        QQToast.a(this.mActivity, ((NewPhotoPreviewActivity)this.mActivity).getExceedMaxSelectNumStr(), 1000).show(this.jdField_a_of_type_Zud.titleBarHeight);
        this.jdField_a_of_type_Zud.lastTimeShowToast = l;
        if (this.jdField_a_of_type_Zud.btr) {
          anot.a(null, "CliOper", "", "", "0x80083EC", "0x80083EC", 0, 0, "", "", "", "");
        }
      }
      ((NewPhotoPreviewActivity)this.mActivity).selectedBox.setChecked(false);
    }
    Object localObject2;
    LocalMediaInfo localLocalMediaInfo;
    do
    {
      return;
      if (paramInt == -1) {
        break;
      }
      localObject2 = (String)this.jdField_a_of_type_Zud.paths.get(paramInt);
      localLocalMediaInfo = ((NewPhotoPreviewActivity)this.mActivity).getMediaInfo((String)localObject2);
    } while ((this.mPhotoCommonData.currentQualityType == 2) && (VQ()));
    if ((((zuc)this.mOtherCommonData).VO()) && (!aytv.a(this.mActivity, localLocalMediaInfo)))
    {
      ((NewPhotoPreviewActivity)this.mActivity).selectedBox.setChecked(false);
      return;
    }
    if ((((NewPhotoPreviewActivity)this.mActivity).getIntent().getBooleanExtra("PhotoConst.IS_SEND_GIF_SIZE_LIMIT", false)) && (akyr.lP((String)localObject2)) && (aqhq.getFileSizes((String)localObject2) > 3145728L))
    {
      QQToast.a(this.mActivity, "图片文件过大", 0).show(this.jdField_a_of_type_Zud.titleBarHeight);
      ((NewPhotoPreviewActivity)this.mActivity).selectedBox.setChecked(false);
      return;
    }
    if ((localObject1 != null) && (!this.jdField_a_of_type_Zud.btB) && (((NewPhotoPreviewActivity)this.mActivity).getMediaType((String)this.jdField_a_of_type_Zud.paths.get(paramInt)) != 1)) {
      ((PresendPicMgr)localObject1).cE((String)this.jdField_a_of_type_Zud.paths.get(paramInt), this.jdField_a_of_type_Zud.busiType);
    }
    localObject1 = (String)this.jdField_a_of_type_Zud.paths.get(paramInt);
    this.mPhotoCommonData.selectedPhotoList.add(localObject1);
    if (this.jdField_a_of_type_Zud.hz != null)
    {
      localObject2 = (PhotoSendParams)this.jdField_a_of_type_Zud.hz.get(localObject1);
      if ((this.jdField_a_of_type_Zud.hA != null) && (localObject2 != null)) {
        this.jdField_a_of_type_Zud.hA.put(localObject1, localObject2);
      }
    }
    if (this.jdField_a_of_type_Zud.hB != null)
    {
      localObject2 = (PicInfo)this.jdField_a_of_type_Zud.hB.get(localObject1);
      if ((this.jdField_a_of_type_Zud.selectedQzonePhotos != null) && (localObject2 != null)) {
        this.jdField_a_of_type_Zud.selectedQzonePhotos.put(localObject1, localObject2);
      }
    }
    this.mPhotoCommonData.selectedIndex.add(Integer.valueOf(paramInt));
    if (((zuc)this.mOtherCommonData).VO())
    {
      if (this.mPhotoCommonData.selectedMediaInfoHashMap == null) {
        this.mPhotoCommonData.selectedMediaInfoHashMap = new HashMap();
      }
      localObject2 = ((NewPhotoPreviewActivity)this.mActivity).getMediaInfo((String)localObject1);
      this.mPhotoCommonData.selectedMediaInfoHashMap.put(localObject1, localObject2);
    }
    ((NewPhotoPreviewActivity)this.mActivity).setCheckedNumber((String)localObject1);
    updateButton();
  }
  
  protected void FB(int paramInt)
  {
    PresendPicMgr localPresendPicMgr = PresendPicMgr.a(null);
    ((NewPhotoPreviewActivity)this.mActivity).selectedBox.setChecked(false);
    int i = this.mPhotoCommonData.selectedIndex.indexOf(Integer.valueOf(paramInt));
    if (i >= 0)
    {
      this.mPhotoCommonData.selectedIndex.remove(i);
      if (paramInt != -1)
      {
        this.mPhotoCommonData.selectedPhotoList.remove(this.jdField_a_of_type_Zud.paths.get(paramInt));
        if (this.jdField_a_of_type_Zud.selectedQzonePhotos != null) {
          this.jdField_a_of_type_Zud.selectedQzonePhotos.remove(this.jdField_a_of_type_Zud.paths.get(paramInt));
        }
        if (this.jdField_a_of_type_Zud.hA != null) {
          this.jdField_a_of_type_Zud.hA.remove(this.jdField_a_of_type_Zud.paths.get(paramInt));
        }
        if (localPresendPicMgr != null) {
          localPresendPicMgr.fx((String)this.jdField_a_of_type_Zud.paths.get(paramInt), 1014);
        }
      }
    }
    updateButton();
    if ((this.mPhotoCommonData.selectedIndex.size() == 0) && (!this.jdField_a_of_type_Zud.btB)) {
      this.jdField_a_of_type_Zud.btD = false;
    }
  }
  
  public void FC(int paramInt)
  {
    ((NewPhotoPreviewActivity)this.mActivity).bottomBar.setVisibility(paramInt);
  }
  
  protected void G(TextView paramTextView)
  {
    Object localObject1 = ((NewPhotoPreviewActivity)this.mActivity).getResources();
    Object localObject2 = this.mPhotoCommonData.selectedPhotoList.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      String str = (String)((Iterator)localObject2).next();
      if ((!NetworkUtils.isNetworkUrl(str)) && (((NewPhotoPreviewActivity)this.mActivity).getMediaType(str) == 1)) {
        paramTextView.setText(((Resources)localObject1).getString(2131696911));
      }
    }
    int i = aqfy.a(this.mPhotoCommonData.selectedPhotoList, this.mPhotoCommonData.allMediaInfoHashMap, false, this.jdField_a_of_type_Zud.hA, this.mPhotoCommonData.selectedMediaInfoHashMap);
    localObject2 = PhotoUtils.a(this.mActivity, i);
    if ((this.mPhotoCommonData.selectedPhotoList.size() == 0) || (((String)localObject2).equals("0"))) {}
    for (localObject1 = ((Resources)localObject1).getString(2131696911);; localObject1 = ((Resources)localObject1).getString(2131696911) + "(共" + (String)localObject2 + ")")
    {
      paramTextView.setText((CharSequence)localObject1);
      return;
    }
  }
  
  protected boolean VP()
  {
    return true;
  }
  
  protected boolean VQ()
  {
    int i = ((NewPhotoPreviewActivity)this.mActivity).getCurrentSelectedPostion();
    if ((((zuc)this.mOtherCommonData).VO()) && (i != -1) && (new File((String)this.jdField_a_of_type_Zud.paths.get(i)).length() > aopb.hm()))
    {
      QQToast.a(this.mActivity, ((NewPhotoPreviewActivity)this.mActivity).getResources().getString(2131696907), 0).show(((NewPhotoPreviewActivity)this.mActivity).getResources().getDimensionPixelSize(2131299627));
      ((NewPhotoPreviewActivity)this.mActivity).selectedBox.setChecked(false);
      return true;
    }
    return false;
  }
  
  protected zuc a()
  {
    return new zuh(this);
  }
  
  protected zww a()
  {
    return new zww(this);
  }
  
  public void a(Intent paramIntent, boolean paramBoolean, ArrayList<String> paramArrayList)
  {
    i2 = 0;
    i = -1;
    int j;
    int k;
    int i1;
    try
    {
      m = PhotoUtils.c((SessionInfo)paramIntent.getParcelableExtra("session_info"));
      HashMap localHashMap = new HashMap();
      j = 0;
      i = 0;
      int n = 0;
      k = 0;
      for (;;)
      {
        if (n >= paramArrayList.size()) {
          break label324;
        }
        localObject1 = (String)paramArrayList.get(n);
        if (!ImageManager.isNetworkUrl((String)localObject1)) {
          break;
        }
        i1 = k;
        k = i;
        i = i1;
        n += 1;
        i1 = k;
        k = i;
        i = i1;
      }
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        m = i;
        if (QLog.isColorLevel())
        {
          QLog.e("PhotoPreviewActivity", 2, "submit", localException1);
          m = i;
        }
      }
    }
    if (((NewPhotoPreviewActivity)this.mActivity).getMediaType((String)localObject1) == 1)
    {
      localObject1 = ((NewPhotoPreviewActivity)this.mActivity).getMediaInfo((String)localObject1);
      localObject2 = new SendVideoActivity.SendVideoInfo();
      i += 1;
      if (((((LocalMediaInfo)localObject1).mDuration > 1200000L) || (((LocalMediaInfo)localObject1).fileSize > 1048576000L)) && (VP()))
      {
        QQToast.a(this.mActivity, ((NewPhotoPreviewActivity)this.mActivity).getResources().getString(2131720243), 0).show(((NewPhotoPreviewActivity)this.mActivity).getResources().getDimensionPixelSize(2131299627));
        ((NewPhotoPreviewActivity)this.mActivity).finish();
      }
    }
    label324:
    do
    {
      return;
      ((SendVideoActivity.SendVideoInfo)localObject2).fileSize = ((LocalMediaInfo)localObject1).fileSize;
      ((SendVideoActivity.SendVideoInfo)localObject2).duration = ((LocalMediaInfo)localObject1).mDuration;
      localException1.put(Integer.valueOf(k), localObject2);
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
      try
      {
        paramIntent.setExtrasClassLoader(SessionInfo.class.getClassLoader());
        if (localException1.isEmpty()) {
          break label710;
        }
        paramIntent.putExtra("PhotoConst.VIDEO_INFOS", localException1);
        i = 1;
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          boolean bool;
          String str;
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
              PhotoUtils.a(this.mActivity, paramIntent, paramArrayList, this.jdField_a_of_type_Zud.hA, this.mPhotoCommonData.currentQualityType, true);
              ((NewPhotoPreviewActivity)this.mActivity).setResult(-1);
              ((NewPhotoPreviewActivity)this.mActivity).finish();
            }
            for (;;)
            {
              anot.a(null, "CliOper", "", "", "0X8009AB1", "0X8009AB1", m, 0, (String)localObject1, (String)localObject2, "", "");
              return;
              PhotoUtils.a(this.mActivity, paramIntent, paramArrayList, this.mPhotoCommonData.currentQualityType, this.jdField_a_of_type_Zud.bjL);
            }
            i = 0;
          }
        }
      }
      if ((anfr.akV == 0L) || (System.currentTimeMillis() - anfr.akV >= 300000L)) {
        break label601;
      }
      bool = true;
      if (QLog.isColorLevel()) {
        QLog.d("PhotoPreviewActivity", 2, "upload video isConfirmed=" + bool + " allowUploadInXGTime=" + anfr.akV);
      }
      if ((!aqiw.isMobileNetWork(BaseApplicationImpl.getContext())) || (bool) || (i == 0) || (!VP())) {
        break label607;
      }
      str = ((NewPhotoPreviewActivity)this.mActivity).getResources().getString(2131719478);
      paramIntent = new PhotoPreviewLogicDefault.5(this, paramBoolean, paramIntent, paramArrayList, m, (String)localObject1, (String)localObject2);
      if (armm.a(this.mActivity, 4, new zum(this, paramIntent))) {
        aqha.a(this.mActivity, 232, null, str, new zun(this, paramIntent), new zuo(this)).show();
      }
    } while (!QLog.isColorLevel());
    QLog.i("PhotoPreviewActivity", 2, "show shortvideo_mobile_send_confirm dialog");
  }
  
  public void a(SlideItemInfo paramSlideItemInfo)
  {
    if (paramSlideItemInfo == null) {
      return;
    }
    if (this.jdField_a_of_type_Zug$a != null) {
      this.jdField_a_of_type_Zug$a.b(paramSlideItemInfo);
    }
    int i = 0;
    label24:
    if (i < this.jdField_a_of_type_Zud.paths.size()) {
      if (!((String)this.jdField_a_of_type_Zud.paths.get(i)).equals(paramSlideItemInfo.mSrcPath)) {}
    }
    for (;;)
    {
      if (i >= 0)
      {
        if (!this.mPhotoCommonData.selectedIndex.contains(Integer.valueOf(i))) {
          break;
        }
        ((NewPhotoPreviewActivity)this.mActivity).selectedBox.setChecked(false);
        int j = this.mPhotoCommonData.selectedIndex.indexOf(Integer.valueOf(i));
        if (j >= 0)
        {
          this.mPhotoCommonData.selectedPhotoList.remove(this.jdField_a_of_type_Zud.paths.get(i));
          this.mPhotoCommonData.selectedIndex.remove(j);
          if (this.jdField_a_of_type_Zud.selectedQzonePhotos != null) {
            this.jdField_a_of_type_Zud.selectedQzonePhotos.remove(this.jdField_a_of_type_Zud.paths.get(i));
          }
          if (this.jdField_a_of_type_Zud.hA != null) {
            this.jdField_a_of_type_Zud.hA.remove(this.jdField_a_of_type_Zud.paths.get(i));
          }
        }
        updateButton();
        zK((String)this.jdField_a_of_type_Zud.paths.get(i));
        return;
        i += 1;
        break label24;
      }
      this.mPhotoCommonData.selectedPhotoList.remove(paramSlideItemInfo.mSrcPath);
      updateButton();
      ((NewPhotoPreviewActivity)this.mActivity).setCheckedNumber(paramSlideItemInfo.mSrcPath);
      zK(paramSlideItemInfo.mSrcPath);
      return;
      i = -1;
    }
  }
  
  public void bvy()
  {
    if (this.jdField_a_of_type_Zug$a != null) {
      this.jdField_a_of_type_Zug$a.crX();
    }
    String str = "";
    if (((NewPhotoPreviewActivity)this.mActivity).getCurrentSelectedPostion() != -1)
    {
      str = (String)this.jdField_a_of_type_Zud.paths.get(((NewPhotoPreviewActivity)this.mActivity).getCurrentSelectedPostion());
      this.mPhotoCommonData.selectedPhotoList.add(str);
      this.mPhotoCommonData.selectedIndex.add(Integer.valueOf(((NewPhotoPreviewActivity)this.mActivity).getCurrentSelectedPostion()));
      if (((zuc)this.mOtherCommonData).VO())
      {
        if (this.mPhotoCommonData.selectedMediaInfoHashMap == null) {
          this.mPhotoCommonData.selectedMediaInfoHashMap = new HashMap();
        }
        LocalMediaInfo localLocalMediaInfo = ((NewPhotoPreviewActivity)this.mActivity).getMediaInfo(str);
        this.mPhotoCommonData.selectedMediaInfoHashMap.put(str, localLocalMediaInfo);
      }
    }
    ((NewPhotoPreviewActivity)this.mActivity).setCheckedNumber(str);
    updateButton();
    zK((String)this.jdField_a_of_type_Zud.paths.get(((NewPhotoPreviewActivity)this.mActivity).getCurrentSelectedPostion()));
  }
  
  public void cfa()
  {
    switch (this.mPhotoCommonData.currentQualityType)
    {
    case 1: 
    default: 
      return;
    case 0: 
      ((NewPhotoPreviewActivity)this.mActivity).qualityTv.setText(((NewPhotoPreviewActivity)this.mActivity).getString(2131696911));
      ((NewPhotoPreviewActivity)this.mActivity).qualityCheckBox.setChecked(false);
      return;
    }
    G(((NewPhotoPreviewActivity)this.mActivity).qualityTv);
    ((NewPhotoPreviewActivity)this.mActivity).qualityCheckBox.setChecked(true);
  }
  
  protected void crW()
  {
    int k = 0;
    float f = 16.0F / acej.aV();
    int i;
    if ((((NewPhotoPreviewActivity)this.mActivity).getResources().getDisplayMetrics().densityDpi < 400) || (Build.VERSION.SDK_INT <= 21))
    {
      i = 1;
      if ((f >= 1.0F) && (i == 0)) {
        break label269;
      }
      if (i == 0) {
        break label270;
      }
      f = 0.7F * f;
    }
    label269:
    label270:
    for (;;)
    {
      int j = k;
      if (QLog.isColorLevel())
      {
        QLog.d("PhotoPreviewActivity", 2, "need scale,reqWidth:" + ((NewPhotoPreviewActivity)this.mActivity).reqWidth + " scale:" + f);
        j = k;
      }
      label121:
      if (j < ((NewPhotoPreviewActivity)this.mActivity).bottomBar.getChildCount())
      {
        View localView = ((NewPhotoPreviewActivity)this.mActivity).bottomBar.getChildAt(j);
        localView.setScaleX(f);
        localView.setScaleY(f);
        RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localView.getLayoutParams();
        if (j == ((NewPhotoPreviewActivity)this.mActivity).bottomBar.getChildCount() - 1) {
          localLayoutParams.rightMargin = ((int)(localLayoutParams.rightMargin * f));
        }
        for (;;)
        {
          localView.setLayoutParams(localLayoutParams);
          j += 1;
          break label121;
          i = 0;
          break;
          localLayoutParams.leftMargin = ((int)(localLayoutParams.leftMargin * f));
          if ((i != 0) && (f < 1.0F)) {
            localLayoutParams.leftMargin = ((int)(localLayoutParams.leftMargin * f));
          }
        }
      }
      return;
    }
  }
  
  public void doOnDestroy()
  {
    if (((zuc)this.mOtherCommonData).VO()) {
      rma.a().bvs();
    }
    if ((this.jdField_a_of_type_Zud.cameraType == 103) && (this.jdField_a_of_type_Zud.paths != null)) {}
    try
    {
      Object localObject = (String)this.jdField_a_of_type_Zud.paths.get(0);
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = BaseApplicationImpl.sImageCache.remove((String)localObject + "#short_video_camera_preview_cache");
        if ((localObject instanceof Bitmap))
        {
          if (QLog.isColorLevel()) {
            QLog.d("PhotoPreviewActivity", 2, "recycle short video preview cache");
          }
          aeah.b((Bitmap)localObject);
        }
      }
    }
    catch (Throwable localThrowable)
    {
      label121:
      break label121;
    }
    super.doOnDestroy();
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    ivv.o(BaseApplicationImpl.getContext(), true);
    arlc.sendWindowVisibleBroadcast(BaseApplicationImpl.getContext(), false);
    aeee.e(BaseApplicationImpl.getContext(), 2, false);
    if (((NewPhotoPreviewActivity)this.mActivity).magicStickBtn != null) {
      ((NewPhotoPreviewActivity)this.mActivity).magicStickBtn.setClickable(true);
    }
    if (((zuc)this.mOtherCommonData).VO())
    {
      rma.a().onResume();
      rma.a().a(this.jdField_a_of_type_Zud.d);
      rma.a().b(this.mPhotoCommonData.selectedPhotoList, this.mPhotoCommonData.allMediaInfoHashMap);
    }
  }
  
  public void er(int paramInt1, int paramInt2)
  {
    if ((paramInt1 >= 0) && (paramInt1 < this.mPhotoCommonData.selectedPhotoList.size()) && (paramInt2 >= 0) && (paramInt2 < this.mPhotoCommonData.selectedPhotoList.size()))
    {
      Collections.swap(this.mPhotoCommonData.selectedPhotoList, paramInt1, paramInt2);
      if (this.jdField_a_of_type_Zud.d != null)
      {
        String str = this.jdField_a_of_type_Zud.d.nb();
        if (!TextUtils.isEmpty(str)) {
          ((NewPhotoPreviewActivity)this.mActivity).setCheckedNumber(str);
        }
      }
      rma.a().b(this.mPhotoCommonData.selectedPhotoList, this.mPhotoCommonData.allMediaInfoHashMap);
    }
  }
  
  public void flashPicCheckedChanged(boolean paramBoolean)
  {
    this.jdField_a_of_type_Zud.btB = paramBoolean;
    int i;
    if (paramBoolean)
    {
      this.jdField_a_of_type_Zud.btD = true;
      Object localObject = ((NewPhotoPreviewActivity)this.mActivity).qualityCheckBox;
      if (!paramBoolean)
      {
        paramBoolean = true;
        ((CheckBox)localObject).setChecked(paramBoolean);
        ((NewPhotoPreviewActivity)this.mActivity).qualityTv.setTextColor(2147483647);
        if ((this.mPhotoCommonData.selectedPhotoList.isEmpty()) && (((NewPhotoPreviewActivity)this.mActivity).gallery.getFirstVisiblePosition() < this.jdField_a_of_type_Zud.paths.size()))
        {
          ((NewPhotoPreviewActivity)this.mActivity).selectLayout.performClick();
          updateButton();
        }
        if (((NewPhotoPreviewActivity)this.mActivity).getMediaType((String)this.jdField_a_of_type_Zud.paths.get(((NewPhotoPreviewActivity)this.mActivity).getCurrentSelectedPostion())) == 1) {
          break label396;
        }
        i = 1;
        label154:
        if ((this.jdField_a_of_type_Zud.btC) && (((NewPhotoPreviewActivity)this.mActivity).popup == null) && (i != 0))
        {
          this.jdField_a_of_type_Zud.btC = false;
          BaseApplicationImpl.getApplication().getSharedPreferences(BaseApplicationImpl.getApplication().getRuntime().getAccount(), 4).edit().putBoolean("showFlashPic", false).commit();
          ((NewPhotoPreviewActivity)this.mActivity).popup = new BubblePopupWindow(-2, -2);
          localObject = new TextView(this.mActivity);
          i = wja.dp2px(10.0F, ((NewPhotoPreviewActivity)this.mActivity).getResources());
          ((TextView)localObject).setPadding(i, 0, i, 0);
          ((TextView)localObject).setTextColor(-1);
          ((TextView)localObject).setText("选中的图片每人只能查看一次");
          ((TextView)localObject).setTextSize(14.0F);
          ((NewPhotoPreviewActivity)this.mActivity).popup.setContentView((View)localObject);
          ((NewPhotoPreviewActivity)this.mActivity).popup.setFocusable(false);
          ((NewPhotoPreviewActivity)this.mActivity).popup.showAsDropDown(((NewPhotoPreviewActivity)this.mActivity).flashTv);
        }
        if (this.jdField_a_of_type_Zud.cZ != 0) {
          break label401;
        }
        anot.a(null, "dc00898", "", "", "0X8006997", "0X8006997", 0, 0, "", "", "", "");
      }
    }
    label396:
    label401:
    do
    {
      do
      {
        return;
        paramBoolean = false;
        break;
        i = 0;
        break label154;
        if (this.jdField_a_of_type_Zud.cZ == 3000)
        {
          anot.a(null, "dc00898", "", "", "0X8006998", "0X8006998", 0, 0, "", "", "", "");
          return;
        }
      } while (this.jdField_a_of_type_Zud.cZ != 1);
      anot.a(null, "dc00898", "", "", "0X8006999", "0X8006999", 0, 0, "", "", "", "");
      return;
      ((NewPhotoPreviewActivity)this.mActivity).qualityTv.setTextColor(-1);
    } while (((NewPhotoPreviewActivity)this.mActivity).popup == null);
    ((NewPhotoPreviewActivity)this.mActivity).popup.dismiss();
  }
  
  public void initData(Intent paramIntent)
  {
    this.jdField_a_of_type_Zud.canUseURL = paramIntent.getBooleanExtra("PhotoConst.USE_URL_PATH", false);
    super.initData(paramIntent);
    aarz.AK("preview create");
    this.jdField_a_of_type_Zud.btC = BaseApplicationImpl.getApplication().getSharedPreferences(BaseApplicationImpl.getApplication().getRuntime().getAccount(), 4).getBoolean("showFlashPic", true);
    this.jdField_a_of_type_Zud.cameraType = paramIntent.getIntExtra("camera_type", 1);
    this.jdField_a_of_type_Zud.btA = false;
    this.jdField_a_of_type_Zud.cfi = paramIntent.getIntExtra("PhotoConst.SEND_BUSINESS_TYPE", -1);
    this.jdField_a_of_type_Zud.cfj = paramIntent.getIntExtra("camera_front_back", 0);
    this.jdField_a_of_type_Zud.filterId = paramIntent.getIntExtra("camera_filter_id", -1);
    this.jdField_a_of_type_Zud.cfl = paramIntent.getIntExtra("camera_capture_method", -1);
    this.jdField_a_of_type_Zud.btx = paramIntent.getBooleanExtra("PhotoConst.IS_FROM_EDIT", false);
    this.jdField_a_of_type_Zud.btr = paramIntent.getBooleanExtra("ReceiptMsgManager.EXTRA_KEY_IS_RECEIPT", false);
    this.jdField_a_of_type_Zud.hz = ((HashMap)paramIntent.getSerializableExtra("PhotoConst.PHOTO_PATHS_FROM_QZONEALBUM"));
    this.jdField_a_of_type_Zud.hB = ((HashMap)paramIntent.getSerializableExtra("PhotoConst.PHOTO_INFOS"));
    this.jdField_a_of_type_Zud.editPathMap = ((HashMap)paramIntent.getSerializableExtra("PhotoConst.editPathMap"));
    if (this.jdField_a_of_type_Zud.editPathMap == null) {
      this.jdField_a_of_type_Zud.editPathMap = new HashMap();
    }
    this.jdField_a_of_type_Zud.selectedQzonePhotos = new HashMap(1);
    if (this.jdField_a_of_type_Zud.hB != null) {
      this.jdField_a_of_type_Zud.selectedQzonePhotos.putAll(this.jdField_a_of_type_Zud.hB);
    }
    this.jdField_a_of_type_Zud.hA = new HashMap(1);
    if (this.jdField_a_of_type_Zud.hz != null) {
      this.jdField_a_of_type_Zud.hA.putAll(this.jdField_a_of_type_Zud.hz);
    }
    if (QLog.isColorLevel()) {
      QLog.d("aioSendPhotos", 2, "mCanUseURL:" + this.jdField_a_of_type_Zud.canUseURL + " mSelectedSendParams size:" + this.jdField_a_of_type_Zud.hA.size());
    }
    this.mPhotoCommonData.videoSizeLimit = paramIntent.getLongExtra("PhotoConst.PHOTOLIST_KEY_VIDEO_SIZE", 1048576000L);
    this.jdField_a_of_type_Zud.bjL = paramIntent.getBooleanExtra("PhotoConst.HANDLE_DEST_RESULT", false);
    this.jdField_a_of_type_Zud.btw = paramIntent.getBooleanExtra("PhotoConst.SHOULD_SEND_RAW_PHOTO", false);
    if (!this.jdField_a_of_type_Zud.btm) {
      this.jdField_a_of_type_Zud.btm = paramIntent.getBooleanExtra("PhotoConst.SHOW_MAGIC_USE_PASTER", false);
    }
    if ("FROM_QZONE_PHOTO_LIST".equals(this.jdField_a_of_type_Zud.from)) {
      this.jdField_a_of_type_Zud.btm = false;
    }
    if (this.jdField_a_of_type_Zud.btm)
    {
      this.jdField_a_of_type_Zud.hx = ((HashMap)paramIntent.getSerializableExtra("PasterConstants.pasters_data"));
      this.jdField_a_of_type_Zud.pasterId = paramIntent.getStringExtra("PasterConstants.paster_id");
      this.jdField_a_of_type_Zud.baR = paramIntent.getStringExtra("PasterConstants.paster_cate_id");
    }
    this.jdField_a_of_type_Zud.cZ = paramIntent.getIntExtra("uintype", -1);
    this.jdField_a_of_type_Zud.btp = paramIntent.getBooleanExtra("PhotoConst.IS_CALL_IN_PLUGIN", false);
    this.jdField_a_of_type_Zud.btz = paramIntent.getBooleanExtra("PhotoConst.IS_SINGLE_DERECTBACK_MODE", false);
    this.mPhotoCommonData.currentQualityType = paramIntent.getIntExtra("PhotoConst.CURRENT_QUALITY_TYPE", 0);
    this.jdField_a_of_type_Zud.isSend = paramIntent.getBooleanExtra("PhotoConst.SEND_FLAG", false);
    if (this.jdField_a_of_type_Zud.isSend)
    {
      paramIntent.removeExtra("PhotoConst.SEND_FLAG");
      PresendPicMgr localPresendPicMgr = PresendPicMgr.a(null);
      if (localPresendPicMgr != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PhotoPreviewActivity", 2, "Photo+ send pic,cancel presend!");
        }
        localPresendPicMgr.IP(1003);
      }
      PhotoUtils.a(this.mActivity, paramIntent, this.mPhotoCommonData.selectedPhotoList, this.mPhotoCommonData.currentQualityType, true);
    }
    this.jdField_a_of_type_Zud.cfk = paramIntent.getIntExtra("key_pic_to_edit_from", 0);
  }
  
  public void initUI()
  {
    btE();
    if (Build.VERSION.SDK_INT == 19)
    {
      localObject = ((NewPhotoPreviewActivity)this.mActivity).getWindow().getDecorView();
      ((View)localObject).setSystemUiVisibility(((View)localObject).getSystemUiVisibility() | 0x4 | 0x100 | 0x1000);
    }
    super.initUI();
    Object localObject = ((NewPhotoPreviewActivity)this.mActivity).getResources();
    ((NewPhotoPreviewActivity)this.mActivity).reqWidth = ((Resources)localObject).getDisplayMetrics().widthPixels;
    ((NewPhotoPreviewActivity)this.mActivity).reqHeight = ((Resources)localObject).getDisplayMetrics().heightPixels;
    ((NewPhotoPreviewActivity)this.mActivity).mNeedStatusTrans = true;
    ((NewPhotoPreviewActivity)this.mActivity).mActNeedImmersive = false;
    ((NewPhotoPreviewActivity)this.mActivity).p = ((HorizontalListView)((NewPhotoPreviewActivity)this.mActivity).findViewById(2131367344));
    ((NewPhotoPreviewActivity)this.mActivity).yW = ((NewPhotoPreviewActivity)this.mActivity).findViewById(2131367342);
    ((NewPhotoPreviewActivity)this.mActivity).a = new ztt((NewPhotoPreviewActivity)this.mActivity);
    ((NewPhotoPreviewActivity)this.mActivity).a.setData(this.mPhotoCommonData.selectedPhotoList);
    ((NewPhotoPreviewActivity)this.mActivity).p.setAdapter(((NewPhotoPreviewActivity)this.mActivity).a);
    ((NewPhotoPreviewActivity)this.mActivity).p.setOnItemClickListener(((NewPhotoPreviewActivity)this.mActivity).a);
    if (needShowMultiPhoto())
    {
      ((NewPhotoPreviewActivity)this.mActivity).p.setVisibility(0);
      ((NewPhotoPreviewActivity)this.mActivity).yW.setVisibility(0);
    }
    if (this.jdField_a_of_type_Zud.showBar)
    {
      ((NewPhotoPreviewActivity)this.mActivity).topBar.setVisibility(0);
      if (((zuc)this.mOtherCommonData).VO()) {
        ((NewPhotoPreviewActivity)this.mActivity).bottomBar.setVisibility(4);
      }
    }
    else
    {
      if ((this.jdField_a_of_type_Zud.btA) && (this.jdField_a_of_type_Zud.selectedQzonePhotos.size() == 0))
      {
        ((NewPhotoPreviewActivity)this.mActivity).flashPicCb.setVisibility(0);
        ((NewPhotoPreviewActivity)this.mActivity).flashTv.setVisibility(0);
        ((NewPhotoPreviewActivity)this.mActivity).flashPicCb.setOnCheckedChangeListener(this.mActivity);
        ((NewPhotoPreviewActivity)this.mActivity).flashTv.setOnClickListener(new zui(this));
        ((NewPhotoPreviewActivity)this.mActivity).flashPicCb.setContentDescription("闪照");
        ((NewPhotoPreviewActivity)this.mActivity).flashTv.setContentDescription("闪照");
      }
      ((NewPhotoPreviewActivity)this.mActivity).qualityCheckBox.setOnCheckedChangeListener(this.mActivity);
      if (!this.jdField_a_of_type_Zud.btw) {
        break label885;
      }
      ((NewPhotoPreviewActivity)this.mActivity).qualityCheckBox.setVisibility(0);
      ((NewPhotoPreviewActivity)this.mActivity).qualityTv.setVisibility(0);
      label516:
      if (!this.jdField_a_of_type_Zud.btm) {
        break label918;
      }
      ((NewPhotoPreviewActivity)this.mActivity).magicStickBtn.setVisibility(0);
    }
    for (;;)
    {
      ((NewPhotoPreviewActivity)this.mActivity).magicStickBtn.setOnClickListener(new zuj(this));
      ((NewPhotoPreviewActivity)this.mActivity).sendBtn.setOnClickListener(new zuk(this));
      updateButton();
      if ((this.jdField_a_of_type_Zud.btz) || (this.jdField_a_of_type_Zud.isSingleMode))
      {
        ((NewPhotoPreviewActivity)this.mActivity).selectedBox.setVisibility(8);
        ((NewPhotoPreviewActivity)this.mActivity).selectLayout.setVisibility(8);
        ((NewPhotoPreviewActivity)this.mActivity).qualityCheckBox.setVisibility(8);
        ((NewPhotoPreviewActivity)this.mActivity).qualityTv.setVisibility(8);
      }
      if (this.jdField_a_of_type_Zud.cZ == 1001)
      {
        ((NewPhotoPreviewActivity)this.mActivity).qualityCheckBox.setVisibility(8);
        ((NewPhotoPreviewActivity)this.mActivity).qualityTv.setVisibility(8);
      }
      crW();
      if (((zuc)this.mOtherCommonData).VO())
      {
        ((NewPhotoPreviewActivity)this.mActivity).backToPhotoListBtn.setText("");
        ((NewPhotoPreviewActivity)this.mActivity).titleView.setVisibility(8);
        if (((NewPhotoPreviewActivity)this.mActivity).getCurrentSelectedPostion() != -1) {
          zK((String)this.jdField_a_of_type_Zud.paths.get(((NewPhotoPreviewActivity)this.mActivity).getCurrentSelectedPostion()));
        }
      }
      float f = ((NewPhotoPreviewActivity)this.mActivity).getResources().getDisplayMetrics().density;
      wja.i(((NewPhotoPreviewActivity)this.mActivity).magicStickBtn, (int)(10.0F * f + 0.5F), (int)(10.0F * f + 0.5F), (int)(10.0F * f + 0.5F), (int)(f * 10.0F + 0.5F));
      return;
      ((NewPhotoPreviewActivity)this.mActivity).bottomBar.setVisibility(0);
      break;
      label885:
      ((NewPhotoPreviewActivity)this.mActivity).qualityCheckBox.setVisibility(8);
      ((NewPhotoPreviewActivity)this.mActivity).qualityTv.setVisibility(8);
      break label516;
      label918:
      ((NewPhotoPreviewActivity)this.mActivity).magicStickBtn.setVisibility(8);
    }
  }
  
  public boolean needShowMultiPhoto()
  {
    return false;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 24747)
    {
      rma.a().a(paramIntent, this.mPhotoCommonData.selectedMediaInfoHashMap);
      return;
    }
    if (paramInt1 == 18001)
    {
      ((NewPhotoPreviewActivity)this.mActivity).t(paramInt1, paramInt2, paramIntent);
      return;
    }
    if (paramInt1 == 18002)
    {
      ((NewPhotoPreviewActivity)this.mActivity).s(paramInt1, paramInt2, paramIntent);
      return;
    }
    if (paramInt1 == 18003)
    {
      ((NewPhotoPreviewActivity)this.mActivity).r(paramInt1, paramInt2, paramIntent);
      return;
    }
    if (paramInt1 == 10000)
    {
      u(paramInt1, paramInt2, paramIntent);
      return;
    }
    PhotoUtils.a(this.mActivity, paramInt1, paramInt2, paramIntent, this.jdField_a_of_type_Zud.btp, this.mPhotoCommonData.myUin);
  }
  
  public void onBackPressed(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Zud.btx) {
      rma.a().setData(rma.a().cj());
    }
    Intent localIntent1 = ((NewPhotoPreviewActivity)this.mActivity).getIntent();
    localIntent1.putExtra("PhotoConst.SEND_BUSINESS_TYPE", this.jdField_a_of_type_Zud.cfi);
    if ("FROM_PHOTO_LIST".equals(this.jdField_a_of_type_Zud.from))
    {
      localIntent1.setClass(this.mActivity, NewPhotoListActivity.class);
      localIntent1.putExtra("PhotoConst.CURRENT_QUALITY_TYPE", this.mPhotoCommonData.currentQualityType);
      if (this.jdField_a_of_type_Zud.isSingleMode) {
        localIntent1.removeExtra("PhotoConst.PHOTO_PATHS");
      }
    }
    for (;;)
    {
      localIntent1.putExtra("PhotoConst.PHOTO_PATHS_FROM_QZONEALBUM", this.jdField_a_of_type_Zud.hA);
      localIntent1.putExtra("PhotoConst.PHOTO_INFOS", this.jdField_a_of_type_Zud.selectedQzonePhotos);
      ((NewPhotoPreviewActivity)this.mActivity).startActivity(localIntent1);
      label149:
      if (localIntent1.getBooleanExtra("keep_selected_status_after_finish", false))
      {
        localIntent1 = new Intent();
        localIntent1.putStringArrayListExtra("PhotoConst.SELECTED_PATHS", this.mPhotoCommonData.selectedPhotoList);
        localIntent1.putIntegerArrayListExtra("PhotoConst.SELECTED_INDEXS", this.mPhotoCommonData.selectedIndex);
        localIntent1.putExtra("PhotoConst.CURRENT_QUALITY_TYPE", this.mPhotoCommonData.currentQualityType);
        localIntent1.putExtra("PhotoConst.editPathMap", this.jdField_a_of_type_Zud.editPathMap);
        ((NewPhotoPreviewActivity)this.mActivity).setResult(-1, localIntent1);
      }
      ((NewPhotoPreviewActivity)this.mActivity).finish();
      if (paramBoolean) {
        try
        {
          ((NewPhotoPreviewActivity)this.mActivity).overridePendingTransition(2130772077, 2130772079);
          return;
          localIntent1.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", this.mPhotoCommonData.selectedPhotoList);
          localIntent1.putExtra("PhotoConst.editPathMap", this.jdField_a_of_type_Zud.editPathMap);
          continue;
          if (!"FROM_QZONE_PHOTO_LIST".equals(this.jdField_a_of_type_Zud.from)) {
            break label149;
          }
          Intent localIntent2 = new Intent();
          localIntent2.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", this.mPhotoCommonData.selectedPhotoList);
          localIntent2.putExtra("PhotoConst.PHOTO_PATHS_FROM_QZONEALBUM", this.jdField_a_of_type_Zud.hA);
          localIntent2.putExtra("PhotoConst.CURRENT_QUALITY_TYPE", this.mPhotoCommonData.currentQualityType);
          localIntent2.putExtra("PeakConstants.selectedMediaInfoHashMap", this.mPhotoCommonData.selectedMediaInfoHashMap);
          ((NewPhotoPreviewActivity)this.mActivity).setResult(-1, localIntent2);
        }
        catch (Exception localException)
        {
          while (!QLog.isColorLevel()) {}
          QLog.d("PhotoPreviewActivity", 2, "[PhotoPreviewActivity] overridePendingTransition=" + localException);
          return;
        }
      }
    }
    aqfy.anim(this.mActivity, true, false);
  }
  
  public void onGalleryItemSelected(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhotoPreviewActivity", 2, " onItemSelected position=" + paramInt);
    }
    super.onGalleryItemSelected(paramAdapterView, paramView, paramInt, paramLong);
    paramAdapterView = ((NewPhotoPreviewActivity)this.mActivity).adapter.getItem(paramInt);
    int i;
    if (((NewPhotoPreviewActivity)this.mActivity).getMediaType(paramAdapterView) == 1) {
      i = 1;
    }
    for (;;)
    {
      if (i != 0)
      {
        paramView.setContentDescription("视频" + paramInt);
        if (((NewPhotoPreviewActivity)this.mActivity).popup != null) {
          ((NewPhotoPreviewActivity)this.mActivity).popup.dismiss();
        }
      }
      try
      {
        for (;;)
        {
          ((NewPhotoPreviewActivity)this.mActivity).b.setOriginRect(((NewPhotoPreviewActivity)this.mActivity).getMediaInfo((String)this.jdField_a_of_type_Zud.paths.get(paramInt)).thumbRect);
          if (((zuc)this.mOtherCommonData).VO())
          {
            if (paramAdapterView != null) {
              ((NewPhotoPreviewActivity)this.mActivity).setCheckedNumber(paramAdapterView);
            }
            zK((String)this.jdField_a_of_type_Zud.paths.get(paramInt));
          }
          return;
          i = 0;
          break;
          paramView.setContentDescription("照片" + paramInt);
        }
      }
      catch (Exception paramView)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("PhotoPreviewActivity", 2, aurp.getStackTraceAsString(paramView));
          }
        }
      }
    }
  }
  
  public void onMagicStickClick(View paramView, int paramInt1, Bundle paramBundle, int paramInt2, Intent paramIntent)
  {
    int i = ((NewPhotoPreviewActivity)this.mActivity).getCurrentSelectedPostion();
    if (i != -1) {
      this.jdField_a_of_type_Zud.baT = ((String)this.jdField_a_of_type_Zud.paths.get(i));
    }
    if (this.jdField_a_of_type_Zud.baT != null)
    {
      anot.a(null, "CliOper", "", "", "0x8004B39", "0x8004B39", 0, 0, "", "", "", "");
      if (this.jdField_a_of_type_Zud.btm)
      {
        paramView = paramIntent;
        if (paramIntent == null) {
          paramView = EditPicActivity.a(this.mActivity, this.jdField_a_of_type_Zud.baT, true, true, true, true, true, paramInt2, 99, 4, paramBundle);
        }
        paramView.putExtra("PhotoConst.CURRENT_QUALITY_TYPE", this.mPhotoCommonData.currentQualityType);
        if (!this.jdField_a_of_type_Zud.btB) {
          break label348;
        }
        paramView.putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1040);
        if (paramInt1 != -1) {
          break label366;
        }
        ((NewPhotoPreviewActivity)this.mActivity).startActivity(paramView);
        label172:
        ((NewPhotoPreviewActivity)this.mActivity).magicStickBtn.setClickable(false);
        paramView = ((NewPhotoPreviewActivity)this.mActivity).getIntent();
        if ((paramView != null) && (paramView.hasExtra("custom_photopreview_editbtn_reportActionName")))
        {
          paramView = paramView.getStringExtra("custom_photopreview_editbtn_reportActionName");
          if (paramView != null) {
            anot.a(null, "CliOper", "", "", paramView, paramView, 0, 0, "", "", "", "");
          }
        }
        if ((needShowMultiPhoto()) && (this.jdField_a_of_type_Zud.cfk > 0))
        {
          paramInt2 = this.jdField_a_of_type_Zud.cfk;
          paramView = new StringBuilder();
          if (this.mPhotoCommonData.selectedPhotoList == null) {
            break label381;
          }
        }
      }
    }
    label348:
    label366:
    label381:
    for (paramInt1 = this.mPhotoCommonData.selectedPhotoList.size();; paramInt1 = 0)
    {
      anot.a(null, "dc00898", "", "", "0X800A06D", "0X800A06D", paramInt2, 0, paramInt1 + "", "", "", "");
      LpReportInfo_pf00064.allReport(603, 4, 1);
      return;
      paramView.putExtra("PhotoConst.SEND_BUSINESS_TYPE", this.jdField_a_of_type_Zud.cfi);
      break;
      ((NewPhotoPreviewActivity)this.mActivity).startActivityForResult(paramView, paramInt1);
      break label172;
    }
  }
  
  public void onQualityBtnClick(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      paramCompoundButton = ((NewPhotoPreviewActivity)this.mActivity).flashPicCb;
      if (!paramBoolean)
      {
        paramBoolean = true;
        paramCompoundButton.setChecked(paramBoolean);
        ((NewPhotoPreviewActivity)this.mActivity).flashTv.setTextColor(2147483647);
        if (aqfy.a(this.mPhotoCommonData.selectedPhotoList, ((zuc)this.mOtherCommonData).cfh, this.mPhotoCommonData.allMediaInfoHashMap, true, this.mPhotoCommonData.selectedMediaInfoHashMap) <= 0) {
          break label178;
        }
        QQToast.a(this.mActivity, ((NewPhotoPreviewActivity)this.mActivity).getResources().getString(2131696907), 0).show(((NewPhotoPreviewActivity)this.mActivity).getResources().getDimensionPixelSize(2131299627));
        this.mPhotoCommonData.currentQualityType = 0;
        ((NewPhotoPreviewActivity)this.mActivity).qualityTv.setText(((NewPhotoPreviewActivity)this.mActivity).getString(2131696911));
        ((NewPhotoPreviewActivity)this.mActivity).qualityCheckBox.setChecked(false);
      }
      label178:
      do
      {
        do
        {
          do
          {
            do
            {
              int j;
              do
              {
                return;
                paramBoolean = false;
                break;
                if (!this.mPhotoCommonData.selectedPhotoList.isEmpty()) {
                  break label665;
                }
                j = ((NewPhotoPreviewActivity)this.mActivity).gallery.getFirstVisiblePosition();
              } while (j >= this.jdField_a_of_type_Zud.paths.size());
              long l = new File((String)this.jdField_a_of_type_Zud.paths.get(j)).length();
              if (((NewPhotoPreviewActivity)this.mActivity).getMediaType((String)this.jdField_a_of_type_Zud.paths.get(j)) == 1) {}
              for (int i = 1; (i == 0) && (l > aopb.hm()); i = 0)
              {
                QQToast.a(this.mActivity, ((NewPhotoPreviewActivity)this.mActivity).getResources().getString(2131696907), 0).show(((NewPhotoPreviewActivity)this.mActivity).getResources().getDimensionPixelSize(2131299627));
                this.mPhotoCommonData.currentQualityType = 0;
                ((NewPhotoPreviewActivity)this.mActivity).qualityTv.setText(((NewPhotoPreviewActivity)this.mActivity).getString(2131696911));
                ((NewPhotoPreviewActivity)this.mActivity).qualityCheckBox.setChecked(false);
                return;
              }
              if ((i != 0) && (l > 104345600L))
              {
                QQToast.a(this.mActivity, ((NewPhotoPreviewActivity)this.mActivity).getResources().getString(2131720265), 0).show(((NewPhotoPreviewActivity)this.mActivity).getResources().getDimensionPixelSize(2131299627));
                aqfy.edE();
              }
              ((NewPhotoPreviewActivity)this.mActivity).setCheckedNumber("", 1);
              this.mPhotoCommonData.selectedPhotoList.add(this.jdField_a_of_type_Zud.paths.get(j));
              this.mPhotoCommonData.selectedIndex.add(Integer.valueOf(j));
              ((NewPhotoPreviewActivity)this.mActivity).qualityCheckBox.setChecked(true);
              this.mPhotoCommonData.currentQualityType = 2;
              G(((NewPhotoPreviewActivity)this.mActivity).qualityTv);
              updateButton();
              paramCompoundButton = PresendPicMgr.a();
              if ((paramCompoundButton != null) && (((NewPhotoPreviewActivity)this.mActivity).getMediaType((String)this.jdField_a_of_type_Zud.paths.get(j)) != 1)) {
                paramCompoundButton.cE((String)this.jdField_a_of_type_Zud.paths.get(j), this.jdField_a_of_type_Zud.busiType);
              }
              paramCompoundButton = ((NewPhotoPreviewActivity)this.mActivity).getIntent();
            } while ((paramCompoundButton == null) || (!paramCompoundButton.hasExtra("custom_photopreview_rawcheckbox_reportActionName")));
            paramCompoundButton = paramCompoundButton.getStringExtra("custom_photopreview_rawcheckbox_reportActionName");
          } while (paramCompoundButton == null);
          anot.a(null, "CliOper", "", "", paramCompoundButton, paramCompoundButton, 0, 0, "", "", "", "");
          return;
          if (aqfy.a(this.mPhotoCommonData.selectedPhotoList, 104345600L, this.mPhotoCommonData.allMediaInfoHashMap, true, this.mPhotoCommonData.selectedMediaInfoHashMap) > 0)
          {
            QQToast.a(this.mActivity, ((NewPhotoPreviewActivity)this.mActivity).getResources().getString(2131720265), 0).show(((NewPhotoPreviewActivity)this.mActivity).getResources().getDimensionPixelSize(2131299627));
            aqfy.edE();
          }
          ((NewPhotoPreviewActivity)this.mActivity).qualityCheckBox.setChecked(true);
          this.mPhotoCommonData.currentQualityType = 2;
          G(((NewPhotoPreviewActivity)this.mActivity).qualityTv);
          paramCompoundButton = ((NewPhotoPreviewActivity)this.mActivity).getIntent();
        } while ((paramCompoundButton == null) || (!paramCompoundButton.hasExtra("custom_photopreview_rawcheckbox_reportActionName")));
        paramCompoundButton = paramCompoundButton.getStringExtra("custom_photopreview_rawcheckbox_reportActionName");
      } while (paramCompoundButton == null);
      label665:
      anot.a(null, "CliOper", "", "", paramCompoundButton, paramCompoundButton, 0, 0, "", "", "", "");
      return;
    }
    ((NewPhotoPreviewActivity)this.mActivity).qualityCheckBox.setChecked(false);
    this.mPhotoCommonData.currentQualityType = 0;
    ((NewPhotoPreviewActivity)this.mActivity).qualityTv.setText(((NewPhotoPreviewActivity)this.mActivity).getString(2131696911));
    ((NewPhotoPreviewActivity)this.mActivity).flashTv.setTextColor(-1);
  }
  
  public void onSelectClick(View paramView)
  {
    ((NewPhotoPreviewActivity)this.mActivity).getResources();
    int i = ((NewPhotoPreviewActivity)this.mActivity).getCurrentSelectedPostion();
    if (this.mPhotoCommonData.selectedIndex.contains(Integer.valueOf(i))) {
      FB(i);
    }
    for (;;)
    {
      if ((((zuc)this.mOtherCommonData).VO()) && (i != -1)) {
        zK((String)this.jdField_a_of_type_Zud.paths.get(i));
      }
      LpReportInfo_pf00064.allReport(603, 2);
      return;
      FA(i);
    }
  }
  
  public void sA(String paramString)
  {
    int j = 0;
    if ((((zuc)this.mOtherCommonData).VO()) && (!this.jdField_a_of_type_Zud.bty))
    {
      this.jdField_a_of_type_Zud.paths.clear();
      this.jdField_a_of_type_Zud.paths.addAll(this.mPhotoCommonData.selectedPhotoList);
      this.mPhotoCommonData.selectedIndex.clear();
      i = 0;
      while (i < this.mPhotoCommonData.selectedPhotoList.size())
      {
        this.mPhotoCommonData.selectedIndex.add(Integer.valueOf(i));
        i += 1;
      }
      ((NewPhotoPreviewActivity)this.mActivity).adapter.notifyDataSetChanged();
      this.jdField_a_of_type_Zud.bty = true;
    }
    int i = this.jdField_a_of_type_Zud.paths.indexOf(paramString);
    if (i < 0) {
      i = j;
    }
    for (;;)
    {
      ((NewPhotoPreviewActivity)this.mActivity).gallery.setSelection(i);
      return;
    }
  }
  
  protected void submit()
  {
    if ((this.jdField_a_of_type_Zud.btm) && ((!TextUtils.isEmpty(this.jdField_a_of_type_Zud.pasterId)) || (!TextUtils.isEmpty(this.jdField_a_of_type_Zud.baR)))) {
      ((NewPhotoPreviewActivity)this.mActivity).magicStickBtn.performClick();
    }
    ArrayList localArrayList = ((NewPhotoPreviewActivity)this.mActivity).getSubmitPhotoList();
    Intent localIntent = ((NewPhotoPreviewActivity)this.mActivity).getIntent();
    if (localArrayList != null)
    {
      zsz.gi(localArrayList.size(), this.jdField_a_of_type_Zud.totalPicCount);
      zsz.d(localIntent, localArrayList.size(), this.mPhotoCommonData.currentQualityType);
    }
    PresendPicMgr localPresendPicMgr = PresendPicMgr.a(null);
    if (this.mPhotoCommonData.currentQualityType == 2)
    {
      if ((this.mPhotoCommonData.selectedPhotoList.size() == 0) && (localArrayList.size() == 1) && (aqhq.getFileSizes((String)localArrayList.get(0)) > aopb.hm()))
      {
        QQToast.a(this.mActivity, ((NewPhotoPreviewActivity)this.mActivity).getResources().getString(2131696907), 0).show(((NewPhotoPreviewActivity)this.mActivity).getResources().getDimensionPixelSize(2131299627));
        ((NewPhotoPreviewActivity)this.mActivity).sendBtn.setClickable(true);
        return;
      }
      if (localPresendPicMgr != null)
      {
        localPresendPicMgr.IP(1010);
        localPresendPicMgr.dDZ();
      }
      anot.a(null, "CliOper", "", "", "0X800515C", "0X800515C", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Zud.bjL) {
        ((NewPhotoPreviewActivity)this.mActivity).topBar.setVisibility(4);
      }
      if (localArrayList != null) {
        aarz.hJ(localArrayList);
      }
      if (((zuc)this.mOtherCommonData).VO()) {
        localIntent.putExtra("PeakConstants.selectedMediaInfoHashMap", this.mPhotoCommonData.selectedMediaInfoHashMap);
      }
      if (this.jdField_a_of_type_Zud.btr)
      {
        localIntent.putExtra("ReceiptMsgManager.EXTRA_KEY_IS_RECEIPT", true);
        localIntent.putExtra("session_info", localIntent.getParcelableExtra("session_info"));
      }
      a(localIntent, this.mPhotoCommonData.containNetImage(), ((NewPhotoPreviewActivity)this.mActivity).getSubmitPhotoList());
      return;
      if ((localPresendPicMgr != null) && (this.mPhotoCommonData.selectedPhotoList.size() > 0) && (!this.jdField_a_of_type_Zud.btB) && (!this.jdField_a_of_type_Zud.btD) && (!this.jdField_a_of_type_Zud.btr) && (!localIntent.getBooleanExtra("PhotoConst.SEND_NO_PRESEND", false))) {
        localPresendPicMgr.dD(localIntent);
      }
    }
  }
  
  void u(int paramInt1, int paramInt2, Intent paramIntent)
  {
    boolean bool = false;
    if ((paramInt2 == -1) && (paramIntent != null))
    {
      if (!paramIntent.getBooleanExtra("PhotoConst.SEND_ORIGIN", false)) {
        bool = true;
      }
      if (bool) {
        break label32;
      }
    }
    label32:
    String str2;
    String str1;
    do
    {
      do
      {
        return;
        str2 = paramIntent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
      } while (str2 == null);
      ThreadManager.excute(new PhotoPreviewLogicDefault.9(this, str2), 64, null, true);
      if (QLog.isColorLevel()) {
        QLog.i("PhotoPreviewActivity", 2, "onActivityResultForMultiEdit hasEdit:" + bool + ", picPath:" + str2);
      }
      str1 = paramIntent.getStringExtra("key_multi_edit_source_path");
      paramInt1 = this.jdField_a_of_type_Zud.paths.indexOf(str1);
    } while (paramInt1 < 0);
    if (this.jdField_a_of_type_Zud.editPathMap.containsValue(str1)) {}
    for (paramIntent = zsh.b(this.jdField_a_of_type_Zud.editPathMap, str1);; paramIntent = str1)
    {
      this.jdField_a_of_type_Zud.editPathMap.put(paramIntent, str2);
      this.jdField_a_of_type_Zud.paths.add(paramInt1, str2);
      this.jdField_a_of_type_Zud.paths.remove(paramInt1 + 1);
      paramInt2 = this.mPhotoCommonData.selectedPhotoList.indexOf(str1);
      if (paramInt2 >= 0)
      {
        this.mPhotoCommonData.selectedPhotoList.add(paramInt2, str2);
        this.mPhotoCommonData.selectedPhotoList.remove(paramInt2 + 1);
      }
      ((NewPhotoPreviewActivity)this.mActivity).adapter.notifyDataSetChanged();
      ((NewPhotoPreviewActivity)this.mActivity).a.notifyDataSetChanged();
      ((NewPhotoPreviewActivity)this.mActivity).gallery.setSelection(paramInt1);
      paramIntent = PresendPicMgr.a();
      if (paramIntent == null) {
        break;
      }
      paramIntent.fx(str1, 1003);
      paramIntent.cE(str2, this.jdField_a_of_type_Zud.busiType);
      return;
    }
  }
  
  public void updateButton()
  {
    Object localObject = ((NewPhotoPreviewActivity)this.mActivity).getResources();
    if (this.jdField_a_of_type_Zud.btw)
    {
      localObject = ((Resources)localObject).getString(2131696942);
      if (this.jdField_a_of_type_Zud.customSendBtnText == null) {
        break label780;
      }
      localObject = this.jdField_a_of_type_Zud.customSendBtnText;
    }
    label265:
    label780:
    for (;;)
    {
      int i;
      label76:
      boolean bool1;
      int j;
      if ((this.mPhotoCommonData.selectedPhotoList != null) && (this.mPhotoCommonData.selectedPhotoList.size() > 0))
      {
        i = 1;
        if (i == 0) {
          break label552;
        }
        if ((!this.jdField_a_of_type_Zud.btz) && (!this.jdField_a_of_type_Zud.isSingleMode)) {
          break label426;
        }
        ((NewPhotoPreviewActivity)this.mActivity).sendBtn.setEnabled(true);
        ((NewPhotoPreviewActivity)this.mActivity).sendBtn.setText((CharSequence)localObject);
        bool1 = this.mPhotoCommonData.selectedIndex.contains(Integer.valueOf(((NewPhotoPreviewActivity)this.mActivity).getCurrentSelectedPostion()));
        if (((NewPhotoPreviewActivity)this.mActivity).getCurrentSelectedPostion() == -1) {
          break label717;
        }
        if (((NewPhotoPreviewActivity)this.mActivity).getMediaType((String)this.jdField_a_of_type_Zud.paths.get(((NewPhotoPreviewActivity)this.mActivity).getCurrentSelectedPostion())) == 1) {
          break label695;
        }
        j = 1;
        label206:
        boolean bool2 = aqfy.isNetUrl((String)this.jdField_a_of_type_Zud.paths.get(((NewPhotoPreviewActivity)this.mActivity).getCurrentSelectedPostion()));
        if (((i != 0) && (!bool1)) || (j == 0) || (bool2)) {
          break label700;
        }
        ((NewPhotoPreviewActivity)this.mActivity).magicStickBtn.setEnabled(true);
        if (((NewPhotoPreviewActivity)this.mActivity).a != null)
        {
          if (!needShowMultiPhoto()) {
            break label734;
          }
          if (((NewPhotoPreviewActivity)this.mActivity).p.getVisibility() == 4)
          {
            ((NewPhotoPreviewActivity)this.mActivity).yW.setVisibility(0);
            ((NewPhotoPreviewActivity)this.mActivity).p.setVisibility(0);
          }
          ((NewPhotoPreviewActivity)this.mActivity).a.notifyDataSetChanged();
        }
      }
      for (;;)
      {
        if ((bool1) || (this.mPhotoCommonData.selectedPhotoList.size() < this.mPhotoCommonData.maxSelectNum)) {
          break label765;
        }
        ((NewPhotoPreviewActivity)this.mActivity).selectedBox.setActivated(true);
        return;
        if (((zuc)this.mOtherCommonData).VO())
        {
          localObject = ((Resources)localObject).getString(2131701769);
          break;
        }
        localObject = ((Resources)localObject).getString(2131696878);
        break;
        i = 0;
        break label76;
        label426:
        ((NewPhotoPreviewActivity)this.mActivity).sendBtn.setEnabled(true);
        cfa();
        Button localButton;
        if (((zuc)this.mOtherCommonData).VO())
        {
          localButton = ((NewPhotoPreviewActivity)this.mActivity).sendBtn;
          if (this.mPhotoCommonData.selectedPhotoList.size() < 2) {
            break label547;
          }
        }
        label547:
        for (bool1 = true;; bool1 = false)
        {
          localButton.setEnabled(bool1);
          ((NewPhotoPreviewActivity)this.mActivity).sendBtn.setText((String)localObject + "(" + this.mPhotoCommonData.selectedPhotoList.size() + ")");
          break;
        }
        label552:
        ((NewPhotoPreviewActivity)this.mActivity).sendBtn.setText((CharSequence)localObject);
        if (((zuc)this.mOtherCommonData).VO()) {
          ((NewPhotoPreviewActivity)this.mActivity).sendBtn.setEnabled(false);
        }
        ((NewPhotoPreviewActivity)this.mActivity).qualityCheckBox.setOnCheckedChangeListener(null);
        localObject = ((NewPhotoPreviewActivity)this.mActivity).qualityCheckBox;
        if (this.mPhotoCommonData.currentQualityType == 2) {}
        for (bool1 = true;; bool1 = false)
        {
          ((CheckBox)localObject).setChecked(bool1);
          ((NewPhotoPreviewActivity)this.mActivity).qualityCheckBox.setOnCheckedChangeListener(this.mActivity);
          if (this.mPhotoCommonData.currentQualityType == 2) {
            ((NewPhotoPreviewActivity)this.mActivity).qualityTv.setTextColor(-14782465);
          }
          cfa();
          break;
        }
        label695:
        j = 0;
        break label206;
        label700:
        ((NewPhotoPreviewActivity)this.mActivity).magicStickBtn.setEnabled(false);
        break label265;
        label717:
        ((NewPhotoPreviewActivity)this.mActivity).magicStickBtn.setEnabled(false);
        break label265;
        label734:
        ((NewPhotoPreviewActivity)this.mActivity).yW.setVisibility(4);
        ((NewPhotoPreviewActivity)this.mActivity).p.setVisibility(4);
      }
      label765:
      ((NewPhotoPreviewActivity)this.mActivity).selectedBox.setActivated(false);
      return;
    }
  }
  
  void zK(String paramString)
  {
    if (((zuc)this.mOtherCommonData).VO())
    {
      if (this.jdField_a_of_type_Zud.d == null) {
        this.jdField_a_of_type_Zud.d = new rmd(this.mActivity, this);
      }
      rma.a().a(this.jdField_a_of_type_Zud.d);
      rma.a().b(this.mPhotoCommonData.selectedPhotoList, this.mPhotoCommonData.allMediaInfoHashMap);
      rma.a().bf(this.mActivity);
      this.jdField_a_of_type_Zud.d.xH(this.mPhotoCommonData.selectedPhotoList.indexOf(paramString));
      if (((NewPhotoPreviewActivity)this.mActivity).mEnableLiuHai)
      {
        paramString = (RelativeLayout)((NewPhotoPreviewActivity)this.mActivity).findViewById(2131379748);
        ((ViewGroup)paramString.getParent()).removeView(paramString);
        Object localObject = paramString.getLayoutParams();
        localObject = new RelativeLayout.LayoutParams(((ViewGroup.LayoutParams)localObject).width, ((ViewGroup.LayoutParams)localObject).height);
        ((RelativeLayout.LayoutParams)localObject).addRule(10, -1);
        ((RelativeLayout.LayoutParams)localObject).topMargin = aqnm.dip2px(8.0F);
        ((NewPhotoPreviewActivity)this.mActivity).bottom_blackLH.addView(paramString, (ViewGroup.LayoutParams)localObject);
      }
      ((NewPhotoPreviewActivity)this.mActivity).bottomBar.setVisibility(4);
    }
  }
  
  public static abstract interface a
  {
    public abstract void b(SlideItemInfo paramSlideItemInfo);
    
    public abstract void crX();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zug
 * JD-Core Version:    0.7.0.1
 */