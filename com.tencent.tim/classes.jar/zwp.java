import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mobileqq.activity.photo.DragGallery;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.NewPhotoPreviewActivity;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import dov.com.tencent.biz.qqstory.takevideo.EditPicActivity;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

public class zwp
  extends zug
{
  private Dialog ak;
  private boolean btZ;
  private boolean bui;
  private boolean buj;
  private boolean buk;
  
  zwp(NewPhotoPreviewActivity paramNewPhotoPreviewActivity)
  {
    super(paramNewPhotoPreviewActivity);
  }
  
  public void initData(Intent paramIntent)
  {
    super.initData(paramIntent);
    this.btZ = paramIntent.getBooleanExtra("from_readinjoy_slideshow", false);
    this.bui = paramIntent.getBooleanExtra("from_readinjoy_ugc_deliver", false);
    this.buj = paramIntent.getBooleanExtra("from_readinjoy_ugc_deliver_preview", false);
    this.buk = paramIntent.getBooleanExtra("from_readinjoy_ugc", false);
    ((zuc)this.mOtherCommonData).a(this.btZ, this.mPhotoCommonData);
  }
  
  public void initUI()
  {
    super.initUI();
    if (((zuc)this.mOtherCommonData).VO()) {
      ((NewPhotoPreviewActivity)this.mActivity).titleView.setVisibility(8);
    }
    label239:
    do
    {
      for (;;)
      {
        if (this.bui)
        {
          ((NewPhotoPreviewActivity)this.mActivity).findViewById(2131365705).setVisibility(0);
          ((NewPhotoPreviewActivity)this.mActivity).findViewById(2131365705).setOnClickListener(new zwq(this));
        }
        if (((this.a.btz) || (this.a.isSingleMode)) && (!this.bui)) {
          ((NewPhotoPreviewActivity)this.mActivity).magicStickBtn.setVisibility(8);
        }
        if (!this.buj) {
          break label239;
        }
        ((NewPhotoPreviewActivity)this.mActivity).magicStickBtn.setVisibility(0);
        if ((this.a.paths.size() > 1) && (this.mPhotoCommonData.selectedPhotoList.size() > 1)) {
          break;
        }
        ((NewPhotoPreviewActivity)this.mActivity).magicStickBtn.setEnabled(true);
        return;
        if (this.bui)
        {
          ((NewPhotoPreviewActivity)this.mActivity).selectLayout.setVisibility(8);
          ((NewPhotoPreviewActivity)this.mActivity).sendBtn.setVisibility(8);
        }
      }
      ((NewPhotoPreviewActivity)this.mActivity).magicStickBtn.setEnabled(false);
      return;
    } while (!this.buk);
    ((NewPhotoPreviewActivity)this.mActivity).magicStickBtn.setVisibility(0);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 10013)
    {
      if ((paramInt2 == -1) && (this.btZ))
      {
        ((NewPhotoPreviewActivity)this.mActivity).setResult(paramInt2, paramIntent);
        ((NewPhotoPreviewActivity)this.mActivity).finish();
      }
      do
      {
        do
        {
          return;
        } while (!this.btZ);
        paramIntent = paramIntent.getStringExtra("PhotoConst.FROM_QQSTORY_SLIDESHOW_DATA");
      } while (TextUtils.isEmpty(paramIntent));
      aqhq.cn(new File(paramIntent).getParent());
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
      if (!this.a.btm) {
        break label511;
      }
      if ((!this.bui) && (!this.buk) && (!this.buj)) {
        break label415;
      }
      if (this.bui)
      {
        paramInt1 = ((NewPhotoPreviewActivity)this.mActivity).gallery.getFirstVisiblePosition();
        if (paramInt1 < this.a.paths.size()) {
          this.a.baT = ((String)this.a.paths.get(paramInt1));
        }
      }
      paramView = EditPicActivity.a(this.mActivity, this.a.baT, true, true, true, true, true, 8);
      paramView.putExtra("PhotoConst.CURRENT_QUALITY_TYPE", this.mPhotoCommonData.currentQualityType);
      if (!this.a.btB) {
        break label547;
      }
      paramView.putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1040);
      label214:
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
      if ((needShowMultiPhoto()) && (this.a.cfk > 0))
      {
        paramInt2 = this.a.cfk;
        paramView = new StringBuilder();
        if (this.mPhotoCommonData.selectedPhotoList == null) {
          break label564;
        }
      }
    }
    label415:
    label547:
    label564:
    for (paramInt1 = this.mPhotoCommonData.selectedPhotoList.size();; paramInt1 = 0)
    {
      anot.a(null, "dc00898", "", "", "0X800A06D", "0X800A06D", paramInt2, 0, paramInt1 + "", "", "", "");
      LpReportInfo_pf00064.allReport(603, 4, 1);
      return;
      paramView = new HashMap(1);
      if ((this.mPhotoCommonData.selectedMediaInfoHashMap != null) && ((LocalMediaInfo)this.mPhotoCommonData.selectedMediaInfoHashMap.get(this.a.baT) != null)) {
        paramView.put("param_localmediainfo", this.mPhotoCommonData.selectedMediaInfoHashMap.get(this.a.baT));
      }
      paramView = EditPicActivity.a(this.mActivity, this.a.baT, true, true, true, true, true, paramInt2, 99, 4, paramView);
      break;
      label511:
      paramView = new Bundle();
      paramView = EditPicActivity.a(this.mActivity, this.a.baT, true, true, true, true, true, 2, 99, 4, paramView);
      break;
      paramView.putExtra("PhotoConst.SEND_BUSINESS_TYPE", this.a.cfi);
      break label214;
    }
  }
  
  protected void submit()
  {
    if (this.btZ)
    {
      rmc.a(this.mActivity, this.mPhotoCommonData.selectedPhotoList);
      ((NewPhotoPreviewActivity)this.mActivity).sendBtn.setClickable(true);
      return;
    }
    super.submit();
  }
  
  public void updateButton()
  {
    super.updateButton();
    if ((this.mPhotoCommonData.selectedPhotoList != null) && (this.mPhotoCommonData.selectedPhotoList.size() > 0)) {}
    for (int i = 1;; i = 0)
    {
      if ((i != 0) && (!this.a.btz) && (!this.a.isSingleMode) && (this.bui)) {
        ((NewPhotoPreviewActivity)this.mActivity).magicStickBtn.setEnabled(true);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zwp
 * JD-Core Version:    0.7.0.1
 */