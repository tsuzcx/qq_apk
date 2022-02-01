import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.biz.qqstory.takevideo.slideshow.SlideItemInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.NewPhotoPreviewActivity;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.activity.richmedia.EditLocalVideoActivity;
import com.tencent.mobileqq.widget.NumberCheckBox;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import dov.com.tencent.biz.qqstory.takevideo.EditPicActivity;
import dov.com.tencent.mobileqq.activity.richmedia.QzoneEditPictureActivity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class zwo
  extends zug
  implements zug.a
{
  int CP = 0;
  public boolean Fg;
  protected boolean btR;
  boolean btV;
  public boolean bug;
  boolean buh;
  private HashMap<String, Integer> hC;
  
  protected zwo(NewPhotoPreviewActivity paramNewPhotoPreviewActivity)
  {
    super(paramNewPhotoPreviewActivity);
  }
  
  private int yq()
  {
    int j;
    int k;
    if (this.mPhotoCommonData.selectedPhotoList != null)
    {
      j = 0;
      int i = 0;
      k = i;
      if (j >= this.mPhotoCommonData.selectedPhotoList.size()) {
        break label75;
      }
      String str = (String)this.mPhotoCommonData.selectedPhotoList.get(j);
      if (((NewPhotoPreviewActivity)this.mActivity).getMediaType(str) != 1) {
        break label77;
      }
      i += 1;
    }
    label75:
    label77:
    for (;;)
    {
      j += 1;
      break;
      k = 0;
      return k;
    }
  }
  
  protected boolean VP()
  {
    return !this.Fg;
  }
  
  public void b(SlideItemInfo paramSlideItemInfo)
  {
    int i = 0;
    if (i < this.a.paths.size()) {
      if (!((String)this.a.paths.get(i)).equals(paramSlideItemInfo.mSrcPath)) {}
    }
    for (;;)
    {
      if ((i >= 0) && (i < this.a.paths.size()) && (this.hC != null)) {
        this.hC.remove(this.a.paths.get(i));
      }
      return;
      i += 1;
      break;
      i = -1;
    }
  }
  
  public void crX()
  {
    int i = ((NewPhotoPreviewActivity)this.mActivity).getCurrentSelectedPostion();
    if (i != -1)
    {
      String str = (String)this.a.paths.get(i);
      if (this.Fg)
      {
        if (this.mPhotoCommonData.selectedMediaInfoHashMap == null) {
          this.mPhotoCommonData.selectedMediaInfoHashMap = new HashMap();
        }
        LocalMediaInfo localLocalMediaInfo = ((NewPhotoPreviewActivity)this.mActivity).getMediaInfo(str);
        this.mPhotoCommonData.selectedMediaInfoHashMap.put(str, localLocalMediaInfo);
        if (this.hC == null) {
          this.hC = new HashMap();
        }
        if (localLocalMediaInfo != null) {
          this.hC.put(str, Integer.valueOf(localLocalMediaInfo.panoramaPhotoType));
        }
      }
    }
  }
  
  public void initData(Intent paramIntent)
  {
    this.a.btm = true;
    super.initData(paramIntent);
    this.hC = ((HashMap)paramIntent.getSerializableExtra("PhotoConst.PANORAMA_IMAGES"));
    this.CP = paramIntent.getIntExtra("PhotoConst.KEY_SHOW_TYPE", 0);
    this.btR = paramIntent.getBooleanExtra("QZONE_PEAK_SUPPORT_VIDEO_EDIT_WHEN_PREVIEW", false);
    this.btV = paramIntent.getBooleanExtra("from_qzone_slideshow", false);
    ((zuc)this.mOtherCommonData).a(this.btV, this.mPhotoCommonData);
    this.Fg = paramIntent.getBooleanExtra("from_qzone", false);
    this.bug = paramIntent.getBooleanExtra("fromQzonePhotoGroup", false);
    this.buh = paramIntent.getBooleanExtra("PhotoConst.IS_FROM_SHUOSHUO", false);
    if (this.btV) {
      rma.a().xK(19);
    }
  }
  
  public void initUI()
  {
    super.initUI();
    if (this.btR) {
      ((NewPhotoPreviewActivity)this.mActivity).magicStickBtn.setVisibility(0);
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((this.btV) && (paramInt2 == -1))
    {
      ((NewPhotoPreviewActivity)this.mActivity).setResult(paramInt2, null);
      ((NewPhotoPreviewActivity)this.mActivity).finish();
      return;
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onMagicStickClick(View paramView, int paramInt1, Bundle paramBundle, int paramInt2, Intent paramIntent)
  {
    paramInt1 = ((NewPhotoPreviewActivity)this.mActivity).getCurrentSelectedPostion();
    if (paramInt1 != -1) {
      this.a.baT = ((String)this.a.paths.get(paramInt1));
    }
    if (this.a.baT != null)
    {
      anot.a(null, "CliOper", "", "", "0x8004B39", "0x8004B39", 0, 0, "", "", "", "");
      paramBundle = new Intent();
      if (this.mPhotoCommonData.selectedMediaInfoHashMap == null) {
        break label587;
      }
    }
    label587:
    for (paramView = (LocalMediaInfo)this.mPhotoCommonData.selectedMediaInfoHashMap.get(this.a.baT);; paramView = null)
    {
      if ((this.btR) && (aqfy.getMediaType(paramView) == 1) && (this.Fg) && (this.a.btm))
      {
        new HashMap(1).put("param_localmediainfo", paramView);
        paramBundle = new Intent(BaseApplicationImpl.getContext(), EditLocalVideoActivity.class);
        paramBundle.putExtras(((NewPhotoPreviewActivity)this.mActivity).getIntent());
        paramBundle.putExtra("PhotoConst.PLUGIN_APK", "qzone_plugin.apk");
        paramBundle.putExtra("PhotoConst.PLUGIN_NAME", "QZone");
        paramBundle.putExtra("DirectBackToQzone", true);
        paramBundle.putExtra("qzone_plugin_activity_name", "com.tencent.pubaccount.publish.QQPublicAccountPublishFeedActivity");
        paramBundle.putExtra("short_video_refer", getClass().getName());
        paramBundle.putExtra("PhotoConst.EDIT_LOCAL_VIDEO_ENTRY", 1);
        paramBundle.putExtra("file_send_path", this.a.baT);
        paramBundle.putExtra("PhotoConst.VIDEO_SIZE", paramView.fileSize);
        paramBundle.putExtra("file_send_duration", paramView.mDuration);
        paramBundle.putExtra("file_width", paramView.mediaWidth);
        paramBundle.putExtra("file_height", paramView.mediaHeight);
        paramView = paramBundle;
      }
      for (;;)
      {
        paramView.putExtra("PhotoConst.CURRENT_QUALITY_TYPE", this.mPhotoCommonData.currentQualityType);
        paramView.putExtra("PhotoConst.SEND_BUSINESS_TYPE", this.a.cfi);
        ((NewPhotoPreviewActivity)this.mActivity).startActivity(paramView);
        ((NewPhotoPreviewActivity)this.mActivity).overridePendingTransition(2130772077, 2130772079);
        ((NewPhotoPreviewActivity)this.mActivity).magicStickBtn.setClickable(false);
        paramView = ((NewPhotoPreviewActivity)this.mActivity).getIntent();
        if ((paramView != null) && (paramView.hasExtra("custom_photopreview_editbtn_reportActionName")))
        {
          paramView = paramView.getStringExtra("custom_photopreview_editbtn_reportActionName");
          if (paramView != null) {
            anot.a(null, "CliOper", "", "", paramView, paramView, 0, 0, "", "", "", "");
          }
        }
        LpReportInfo_pf00064.allReport(603, 4, 1);
        return;
        if (this.a.btm)
        {
          paramView = new HashMap(1);
          if ((this.mPhotoCommonData.selectedMediaInfoHashMap != null) && ((LocalMediaInfo)this.mPhotoCommonData.selectedMediaInfoHashMap.get(this.a.baT) != null)) {
            paramView.put("param_localmediainfo", this.mPhotoCommonData.selectedMediaInfoHashMap.get(this.a.baT));
          }
          if (this.Fg) {
            paramView = QzoneEditPictureActivity.d(this.mActivity, this.a.baT);
          } else {
            paramView = EditPicActivity.a(this.mActivity, this.a.baT, true, true, true, true, true, 3, 99, 4, paramView);
          }
        }
        else
        {
          paramView = paramBundle;
        }
      }
    }
  }
  
  public void onSelectClick(View paramView)
  {
    int i = ((NewPhotoPreviewActivity)this.mActivity).getCurrentSelectedPostion();
    if (this.mPhotoCommonData.selectedIndex.contains(Integer.valueOf(i)))
    {
      if ((this.mPhotoCommonData.selectedIndex.indexOf(Integer.valueOf(i)) >= 0) && (i != -1) && (this.hC != null)) {
        this.hC.remove(this.a.paths.get(i));
      }
      super.onSelectClick(paramView);
      return;
    }
    if (i != -1) {}
    for (String str = (String)this.a.paths.get(i);; str = "")
    {
      LocalMediaInfo localLocalMediaInfo = ((NewPhotoPreviewActivity)this.mActivity).getMediaInfo(str);
      if ((this.Fg) && (this.a.paths != null) && (((NewPhotoPreviewActivity)this.mActivity).getMediaType(str) == 1) && (!aqfy.a(this.mActivity, yq(), localLocalMediaInfo, ((zuc)this.mOtherCommonData).VO())))
      {
        ((NewPhotoPreviewActivity)this.mActivity).selectedBox.setChecked(false);
        return;
      }
      if (i == -1) {
        break;
      }
      str = (String)this.a.paths.get(i);
      if ((!this.Fg) && (!((zuc)this.mOtherCommonData).VO())) {
        break;
      }
      if (this.mPhotoCommonData.selectedMediaInfoHashMap == null) {
        this.mPhotoCommonData.selectedMediaInfoHashMap = new HashMap();
      }
      localLocalMediaInfo = ((NewPhotoPreviewActivity)this.mActivity).getMediaInfo(str);
      this.mPhotoCommonData.selectedMediaInfoHashMap.put(str, localLocalMediaInfo);
      if (this.hC == null) {
        this.hC = new HashMap();
      }
      if (localLocalMediaInfo == null) {
        break;
      }
      this.hC.put(str, Integer.valueOf(localLocalMediaInfo.panoramaPhotoType));
      break;
    }
  }
  
  protected void submit()
  {
    if (this.bug)
    {
      localObject1 = new Intent();
      ((Intent)localObject1).putIntegerArrayListExtra("PhotoConst.SELECTED_INDEXS", this.mPhotoCommonData.selectedIndex);
      ((NewPhotoPreviewActivity)this.mActivity).setResult(-1, (Intent)localObject1);
      ((NewPhotoPreviewActivity)this.mActivity).finish();
      return;
    }
    Object localObject1 = ((NewPhotoPreviewActivity)this.mActivity).getSubmitPhotoList();
    Object localObject2;
    Object localObject3;
    if ((this.Fg) && (this.mPhotoCommonData.selectedPhotoList != null) && (this.mPhotoCommonData.selectedPhotoList.isEmpty()) && (((ArrayList)localObject1).size() == 1))
    {
      localObject2 = (String)((ArrayList)localObject1).get(0);
      localObject3 = ((NewPhotoPreviewActivity)this.mActivity).getMediaInfo((String)localObject2);
      if (localObject3 != null)
      {
        if (this.hC == null) {
          this.hC = new HashMap();
        }
        this.hC.put(localObject2, Integer.valueOf(((LocalMediaInfo)localObject3).panoramaPhotoType));
        if (this.mPhotoCommonData.selectedMediaInfoHashMap != null)
        {
          this.mPhotoCommonData.selectedMediaInfoHashMap.clear();
          this.mPhotoCommonData.selectedMediaInfoHashMap.put(localObject2, localObject3);
        }
      }
      if ((((NewPhotoPreviewActivity)this.mActivity).getMediaType((String)localObject2) == 1) && (!aqfy.a(this.mActivity, yq(), (LocalMediaInfo)localObject3, this.buh)))
      {
        ((NewPhotoPreviewActivity)this.mActivity).sendBtn.setClickable(true);
        return;
      }
    }
    if (localObject1 != null)
    {
      zsz.gi(((ArrayList)localObject1).size(), this.a.totalPicCount);
      zsz.d(((NewPhotoPreviewActivity)this.mActivity).getIntent(), ((ArrayList)localObject1).size(), this.mPhotoCommonData.currentQualityType);
    }
    Intent localIntent = ((NewPhotoPreviewActivity)this.mActivity).getIntent();
    if (localObject1 != null) {
      aarz.hJ((List)localObject1);
    }
    if ((this.Fg) || (((zuc)this.mOtherCommonData).VO()))
    {
      localIntent.putExtra("PeakConstants.selectedMediaInfoHashMap", this.mPhotoCommonData.selectedMediaInfoHashMap);
      localIntent.putExtra("PhotoConst.PANORAMA_IMAGES", this.hC);
    }
    if (1 == this.CP) {
      localIntent.putExtra("PhotoConst.KEY_SHOW_TYPE", 1);
    }
    for (;;)
    {
      a(localIntent, false, ((NewPhotoPreviewActivity)this.mActivity).getSubmitPhotoList());
      if (!localIntent.getBooleanExtra("custom_photopreview_sendbtn_report", false)) {
        break;
      }
      localObject3 = localIntent.getStringExtra("custom_photopreview_sendbtn_reportActionName");
      localObject2 = localIntent.getStringExtra("custom_photopreview_sendbtn_album_reportReverse2");
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = localIntent.getStringExtra("custom_photopreview_sendbtn_camera_reportReverse2");
      }
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = localIntent.getStringExtra("custom_photopreview_sendbtn_reportReverse2");
      }
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      if ((localObject3 == null) || (localObject1 == null)) {
        break;
      }
      anot.a(null, "CliOper", "", "", (String)localObject3, (String)localObject3, 0, 0, (String)localObject1, "", "", "");
      return;
      localIntent.putExtra("PhotoConst.KEY_SHOW_TYPE", 0);
    }
  }
  
  public void updateButton()
  {
    boolean bool2 = true;
    super.updateButton();
    Object localObject;
    if (((zuc)this.mOtherCommonData).VO())
    {
      localObject = ((NewPhotoPreviewActivity)this.mActivity).getString(2131701769);
      if (this.CP == 1) {
        localObject = ((NewPhotoPreviewActivity)this.mActivity).getString(2131696901);
      }
      if (this.a.customSendBtnText == null) {
        break label388;
      }
      localObject = this.a.customSendBtnText;
    }
    label388:
    for (;;)
    {
      if ((this.mPhotoCommonData.selectedPhotoList != null) && (this.mPhotoCommonData.selectedPhotoList.size() > 0) && (this.CP == 1))
      {
        Button localButton = ((NewPhotoPreviewActivity)this.mActivity).sendBtn;
        if (this.mPhotoCommonData.selectedPhotoList.size() >= 3)
        {
          bool1 = true;
          label132:
          localButton.setEnabled(bool1);
          ((NewPhotoPreviewActivity)this.mActivity).sendBtn.setText((String)localObject + "(" + this.mPhotoCommonData.selectedPhotoList.size() + ")");
        }
      }
      else if (this.btR)
      {
        ((NewPhotoPreviewActivity)this.mActivity).sendBtn.setText((CharSequence)localObject);
        if (((zuc)this.mOtherCommonData).VO()) {
          ((NewPhotoPreviewActivity)this.mActivity).sendBtn.setEnabled(false);
        }
        if ((this.Fg) && (this.a.paths != null)) {
          ((NewPhotoPreviewActivity)this.mActivity).magicStickBtn.setEnabled(true);
        }
        ((NewPhotoPreviewActivity)this.mActivity).qualityCheckBox.setOnCheckedChangeListener(null);
        localObject = ((NewPhotoPreviewActivity)this.mActivity).qualityCheckBox;
        if (this.mPhotoCommonData.currentQualityType != 2) {
          break label383;
        }
      }
      label383:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        ((CheckBox)localObject).setChecked(bool1);
        ((NewPhotoPreviewActivity)this.mActivity).qualityCheckBox.setOnCheckedChangeListener(this.mActivity);
        if (this.mPhotoCommonData.currentQualityType == 2) {
          ((NewPhotoPreviewActivity)this.mActivity).qualityTv.setTextColor(-16734752);
        }
        cfa();
        return;
        localObject = ((NewPhotoPreviewActivity)this.mActivity).getString(2131696878);
        break;
        bool1 = false;
        break label132;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zwo
 * JD-Core Version:    0.7.0.1
 */