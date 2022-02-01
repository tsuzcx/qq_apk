import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.AbstractPhotoPreviewActivity;
import com.tencent.mobileqq.activity.photo.album.NewPhotoPreviewActivity;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.activity.photo.album.PhotoPreviewBaseData;
import com.tencent.mobileqq.activity.photo.album.PhotoPreviewLogicBase;
import com.tencent.mobileqq.activity.photo.album.preview.BasePreviewAdapter;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.widget.AdapterView;
import dov.com.qq.im.ae.camera.core.AECircleBroadcastReceiver;
import dov.com.qq.im.ae.camera.core.AECircleBroadcastReceiver.a;
import java.util.ArrayList;
import java.util.HashMap;

public class zue
  extends PhotoPreviewLogicBase
  implements AECircleBroadcastReceiver.a
{
  private AECircleBroadcastReceiver a = new AECircleBroadcastReceiver(this);
  private String baU;
  private boolean btE;
  private boolean btF = true;
  private int cfm;
  private Dialog g;
  private int mDataType = 0;
  private String mResPath;
  
  public zue(NewPhotoPreviewActivity paramNewPhotoPreviewActivity)
  {
    super(paramNewPhotoPreviewActivity);
  }
  
  private void crV()
  {
    if ((this.mResPath == null) && (Build.VERSION.SDK_INT >= 21) && (this.btF))
    {
      if (!aqiw.isNetworkAvailable())
      {
        QQToast.a(this.mActivity, acfp.m(2131689983), 0).show(this.mActivity.getResources().getDimensionPixelSize(2131299627));
        return;
      }
      this.btE = true;
      showLoading(true);
      return;
    }
    if (this.mPhotoCommonData.selectedPhotoList.size() == 0)
    {
      if (isGif(this.mActivity.getMediaInfo(this.baU)))
      {
        QQToast.a(this.mActivity, acfp.m(2131689984), 0).show(this.mActivity.getResources().getDimensionPixelSize(2131299627));
        return;
      }
      this.mPhotoCommonData.selectedPhotoList.add(this.baU);
    }
    axoe.a(this.mDataType, this.mActivity, this.mPhotoCommonData, this.mResPath, this.btF);
    this.mActivity.finish();
    this.a.cP(this.mActivity);
    showLoading(false);
  }
  
  private boolean isGif(LocalMediaInfo paramLocalMediaInfo)
  {
    return (paramLocalMediaInfo != null) && ("image/gif".equals(paramLocalMediaInfo.mMimeType));
  }
  
  private void showLoading(boolean paramBoolean)
  {
    if ((this.mActivity != null) && (!this.mActivity.isFinishing()))
    {
      if (!paramBoolean) {
        break label78;
      }
      if (this.g == null)
      {
        this.g = new ReportDialog(this.mActivity, 2131756467);
        this.g.setCancelable(false);
        this.g.setCanceledOnTouchOutside(false);
        this.g.setContentView(2131559761);
      }
      this.g.show();
    }
    label78:
    while ((this.g == null) || (!this.g.isShowing())) {
      return;
    }
    this.g.dismiss();
  }
  
  public void doOnDestroy()
  {
    this.a.cP(this.mActivity);
    super.doOnDestroy();
  }
  
  public void initData(Intent paramIntent)
  {
    super.initData(paramIntent);
    this.cfm = paramIntent.getIntExtra("choosed_num", 0);
    this.mResPath = paramIntent.getStringExtra("res_path");
    this.btF = paramIntent.getBooleanExtra("isneed_edit", this.btF);
    if (this.mResPath == null)
    {
      this.a.cO(this.mActivity);
      anjx.a().b("CMD_DOWNLOAD_PTU_BASE_RES", new Bundle());
    }
  }
  
  public void initUI()
  {
    super.initUI();
    this.mActivity.selectLayout.setVisibility(8);
    this.mActivity.sendBtn.setOnClickListener(new zuf(this));
  }
  
  public void onGalleryItemSelected(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    int i = 1;
    String str = this.mActivity.adapter.getItem(paramInt);
    this.baU = str;
    if (this.mActivity.getMediaType(str) == 1)
    {
      if (i == 0) {
        break label68;
      }
      this.mActivity.selectLayout.setVisibility(8);
    }
    for (;;)
    {
      super.onGalleryItemSelected(paramAdapterView, paramView, paramInt, paramLong);
      return;
      i = 0;
      break;
      label68:
      this.mActivity.selectLayout.setVisibility(0);
    }
  }
  
  public void onSelectClick(View paramView)
  {
    int i = this.mActivity.getCurrentSelectedPostion();
    String str = "";
    if (i != -1) {
      str = (String)this.mPhotoPreviewData.paths.get(i);
    }
    LocalMediaInfo localLocalMediaInfo = this.mActivity.getMediaInfo(str);
    int j = aqfy.getMediaType(localLocalMediaInfo);
    if (!this.mPhotoCommonData.selectedIndex.contains(Integer.valueOf(i)))
    {
      if (this.mPhotoCommonData.needMediaInfo) {
        this.mPhotoCommonData.selectedMediaInfoHashMap.put(str, localLocalMediaInfo);
      }
      if (this.cfm == 9)
      {
        QQToast.a(this.mActivity, acfp.m(2131689985), 0).show(this.mActivity.getResources().getDimensionPixelSize(2131299627));
        return;
      }
      if (isGif(localLocalMediaInfo))
      {
        QQToast.a(this.mActivity, acfp.m(2131689984), 0).show(this.mActivity.getResources().getDimensionPixelSize(2131299627));
        return;
      }
      if ((j == 1) && (this.cfm != 0))
      {
        QQToast.a(this.mActivity, acfp.m(2131689986), 0).show(this.mActivity.getResources().getDimensionPixelSize(2131299627));
        return;
      }
      if (j != 1) {}
    }
    for (;;)
    {
      super.onSelectClick(paramView);
      this.cfm = this.mPhotoCommonData.selectedPhotoList.size();
      return;
      if (this.mPhotoCommonData.needMediaInfo) {
        this.mPhotoCommonData.selectedMediaInfoHashMap.remove(str);
      }
    }
  }
  
  public void qr(String paramString)
  {
    this.mResPath = paramString;
    if (this.btE) {
      crV();
    }
  }
  
  public void updateButton()
  {
    this.mActivity.sendBtn.setClickable(true);
    this.mActivity.sendBtn.setBackgroundResource(2130838048);
    super.updateButton();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zue
 * JD-Core Version:    0.7.0.1
 */