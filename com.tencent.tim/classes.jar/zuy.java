import android.app.Dialog;
import android.content.Intent;
import android.media.MediaMetadataRetriever;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.AbstractPhotoListActivity.PhotoListAdapter;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.pic.PresendPicMgr;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.GestureSelectGridView;
import cooperation.qzone.QzonePluginProxyActivity;
import dov.com.qq.im.ae.camera.core.AECircleBroadcastReceiver;
import dov.com.qq.im.ae.camera.core.AECircleBroadcastReceiver.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class zuy
  extends ztv
  implements AECircleBroadcastReceiver.a
{
  private static final String[] db = { "video/mp4", "video/3gpp" };
  private AECircleBroadcastReceiver a;
  private boolean btE;
  private boolean btF = true;
  private int cfo = 3000;
  private int cfp = 3000;
  private int cfq = 3600000;
  private Dialog g;
  private int mDataType = 0;
  private String mResPath;
  
  public zuy(NewPhotoListActivity paramNewPhotoListActivity)
  {
    super(paramNewPhotoListActivity);
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECircleBroadcastReceiver = new AECircleBroadcastReceiver(this);
    axiy.d("PhotoListLogicAECircle", "[AE Profiler] PhotoListLogicAECircle new");
  }
  
  private int b(LocalMediaInfo paramLocalMediaInfo)
  {
    long l = paramLocalMediaInfo.mDuration;
    if ((l > this.cfq) || (l < 2000L)) {
      return 1;
    }
    MediaMetadataRetriever localMediaMetadataRetriever = new MediaMetadataRetriever();
    try
    {
      localMediaMetadataRetriever.setDataSource(paramLocalMediaInfo.path);
      int j = Integer.parseInt(localMediaMetadataRetriever.extractMetadata(19));
      int i = Integer.parseInt(localMediaMetadataRetriever.extractMetadata(18));
      paramLocalMediaInfo = localMediaMetadataRetriever.extractMetadata(12);
      if (j <= this.cfp)
      {
        j = this.cfo;
        if (i <= j) {}
      }
      else
      {
        return 2;
      }
      if (!paramLocalMediaInfo.equals(db[0]))
      {
        boolean bool = paramLocalMediaInfo.equals(db[1]);
        if (!bool) {
          return 3;
        }
      }
      return 0;
    }
    catch (Exception paramLocalMediaInfo)
    {
      if (QLog.isColorLevel()) {
        paramLocalMediaInfo.printStackTrace();
      }
      return 5;
    }
    finally
    {
      localMediaMetadataRetriever.release();
    }
  }
  
  private void crV()
  {
    if ((this.mResPath == null) && (Build.VERSION.SDK_INT >= 21) && (this.btF))
    {
      if (!aqiw.isNetworkAvailable())
      {
        QQToast.a(this.mActivity, acfp.m(2131689983), 0).show(((NewPhotoListActivity)this.mActivity).mTitleBarHeight);
        return;
      }
      this.btE = true;
      showLoading(true);
      return;
    }
    axoe.a(this.mDataType, this.mActivity, this.mPhotoCommonData, this.mResPath, this.btF);
    ((NewPhotoListActivity)this.mActivity).finish();
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECircleBroadcastReceiver.cP(this.mActivity);
    showLoading(false);
  }
  
  private void showLoading(boolean paramBoolean)
  {
    if ((this.mActivity != null) && (!((NewPhotoListActivity)this.mActivity).isFinishing()))
    {
      if (!paramBoolean) {
        break label81;
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
    label81:
    while ((this.g == null) || (!this.g.isShowing())) {
      return;
    }
    this.g.dismiss();
  }
  
  public boolean addAndRemovePhotoByGesture(LocalMediaInfo paramLocalMediaInfo, boolean paramBoolean)
  {
    if (((NewPhotoListActivity)this.mActivity).isGif(paramLocalMediaInfo))
    {
      QQToast.a(this.mActivity, acfp.m(2131689984), 0).show(((NewPhotoListActivity)this.mActivity).mTitleBarHeight);
      return false;
    }
    return super.addAndRemovePhotoByGesture(paramLocalMediaInfo, paramBoolean);
  }
  
  public Intent caseNoSingModeImage(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = super.caseNoSingModeImage(paramAdapterView, paramView, paramInt, paramLong);
    paramAdapterView.putExtra("choosed_num", this.mPhotoCommonData.selectedPhotoList.size());
    paramAdapterView.putExtra("res_path", this.mResPath);
    paramAdapterView.putExtra("isneed_edit", this.btF);
    paramView = ((NewPhotoListActivity)this.mActivity).photoListAdapter.getItem(paramInt);
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    int j = 0;
    int m = this.mPhotoCommonData.mediaPathsList.size();
    int k = 0;
    int i = paramInt;
    if (k < m)
    {
      String str = (String)this.mPhotoCommonData.mediaPathsList.get(k);
      LocalMediaInfo localLocalMediaInfo = (LocalMediaInfo)this.mPhotoCommonData.allMediaInfoHashMap.get(str);
      if (aqfy.getMediaType(localLocalMediaInfo) != 0) {
        break label293;
      }
      localArrayList1.add(str);
      if ((this.mPhotoCommonData.selectedPhotoList != null) && (this.mPhotoCommonData.selectedPhotoList.contains(str))) {
        localArrayList2.add(Integer.valueOf(j));
      }
      if (localLocalMediaInfo.position.intValue() != paramInt) {
        break label290;
      }
      i = j;
      label212:
      j += 1;
    }
    label290:
    label293:
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
      return paramAdapterView;
      break label212;
    }
  }
  
  public void caseVideo(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (this.mPhotoCommonData.selectedPhotoList.size() == 0)
    {
      paramView = ((NewPhotoListActivity)this.mActivity).photoListAdapter.getItem(paramInt);
      switch (b(paramView))
      {
      default: 
        return;
      case 0: 
        this.mDataType = 1;
        this.mPhotoCommonData.selectedPhotoList.add(paramView.path);
        this.mPhotoCommonData.selectedIndex.add(Integer.valueOf(paramInt));
        this.mPhotoCommonData.selectedMediaInfoHashMap.put(paramView.path, paramView);
        paramAdapterView = (LinkedHashMap)aqfy.sSelectItemPosMap.get(this.mPhotoCommonData.albumId);
        if (paramAdapterView == null)
        {
          paramAdapterView = new LinkedHashMap();
          aqfy.sSelectItemPosMap.put(this.mPhotoCommonData.albumId, paramAdapterView);
        }
        break;
      }
    }
    for (;;)
    {
      paramAdapterView.put(paramView.path, Integer.valueOf(((NewPhotoListActivity)this.mActivity).mGridView.getFirstVisiblePosition()));
      paramAdapterView = aqfy.sSelectItemAlbum;
      if (!paramAdapterView.containsKey(paramView.path))
      {
        Pair localPair = new Pair(this.mPhotoCommonData.albumId, this.mPhotoCommonData.albumName);
        paramAdapterView.put(paramView.path, localPair);
      }
      crV();
      return;
      QQToast.a(this.mActivity, String.format(acfp.m(2131689980), new Object[] { Integer.valueOf(2) }), 0).show(((NewPhotoListActivity)this.mActivity).mTitleBarHeight);
      return;
      QQToast.a(this.mActivity, acfp.m(2131689989), 0).show(((NewPhotoListActivity)this.mActivity).mTitleBarHeight);
      return;
      QQToast.a(this.mActivity, acfp.m(2131689990), 0).show(((NewPhotoListActivity)this.mActivity).mTitleBarHeight);
      return;
      QQToast.a(this.mActivity, acfp.m(2131689988), 0).show(((NewPhotoListActivity)this.mActivity).mTitleBarHeight);
      return;
      QQToast.a(this.mActivity, acfp.m(2131689991), 0).show(((NewPhotoListActivity)this.mActivity).mTitleBarHeight);
      return;
      QQToast.a(this.mActivity, acfp.m(2131689986), 0).show(((NewPhotoListActivity)this.mActivity).mTitleBarHeight);
      return;
    }
  }
  
  public void initData(Intent paramIntent)
  {
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECircleBroadcastReceiver.cO(this.mActivity);
    anjx.a().b("CMD_DOWNLOAD_PTU_BASE_RES", new Bundle());
    this.mPhotoCommonData.needMediaInfo = true;
    super.initData(paramIntent);
    int i = axcg.y.getId();
    if (axcg.az(((NewPhotoListActivity)this.mActivity).getIntent())) {
      i = axcg.A.getId();
    }
    for (;;)
    {
      axip.a().eI(i, null);
      String str = ((NewPhotoListActivity)this.mActivity).getIntent().getStringExtra("intent_key_uid_for_report");
      paramIntent = str;
      if (TextUtils.isEmpty(str))
      {
        paramIntent = axol.getAppInterface().getCurrentAccountUin();
        ((NewPhotoListActivity)this.mActivity).getIntent().putExtra("intent_key_uid_for_report", paramIntent);
      }
      axip.a().setUin(paramIntent);
      axip.a().eLs();
      axip.a().eLr();
      axip.a().acR(axbk.bS(null));
      paramIntent = ((NewPhotoListActivity)this.mActivity).getIntent().getStringExtra("albumName");
      str = ((NewPhotoListActivity)this.mActivity).getIntent().getStringExtra("albumId");
      if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty(paramIntent)))
      {
        this.mPhotoCommonData.albumName = paramIntent;
        this.mPhotoCommonData.albumId = str;
      }
      this.btF = ((NewPhotoListActivity)this.mActivity).getIntent().getBooleanExtra("isneed_edit", this.btF);
      this.cfo = 3000;
      this.cfp = 3000;
      this.cfq = 60000;
      return;
    }
  }
  
  public void onCheckBoxClick(View paramView, int paramInt, CheckBox paramCheckBox)
  {
    LocalMediaInfo localLocalMediaInfo = ((NewPhotoListActivity)this.mActivity).photoListAdapter.getItem(paramInt);
    int i = aqfy.getMediaType(localLocalMediaInfo);
    if (localLocalMediaInfo.selectStatus != 1) {
      if (this.mDataType == 1)
      {
        if (this.mPhotoCommonData.selectedPhotoList.size() == 1)
        {
          if (i == 0) {
            QQToast.a(this.mActivity, acfp.m(2131689986), 0).show(((NewPhotoListActivity)this.mActivity).mTitleBarHeight);
          }
          return;
        }
        if (this.mPhotoCommonData.selectedPhotoList.size() == 0) {
          if (i == 0) {
            this.mDataType = 0;
          }
        }
      }
    }
    for (;;)
    {
      super.onCheckBoxClick(paramView, paramInt, paramCheckBox);
      return;
      axiy.e("PhotoListLogicAECircle", "[error] size > 1 && mDataType = video");
      continue;
      if (this.mDataType == 0)
      {
        if (i == 0)
        {
          if (((NewPhotoListActivity)this.mActivity).isGif(localLocalMediaInfo))
          {
            QQToast.a(this.mActivity, acfp.m(2131689984), 0).show(((NewPhotoListActivity)this.mActivity).mTitleBarHeight);
            return;
          }
          if ((localLocalMediaInfo.mediaWidth < 20) || (localLocalMediaInfo.mediaHeight < 20))
          {
            QQToast.a(this.mActivity, acfp.m(2131689981), 0).show(((NewPhotoListActivity)this.mActivity).mTitleBarHeight);
            return;
          }
          if (this.mPhotoCommonData.selectedPhotoList.size() >= 9) {
            QQToast.a(this.mActivity, acfp.m(2131689985), 0).show(((NewPhotoListActivity)this.mActivity).mTitleBarHeight);
          }
        }
      }
      else
      {
        axiy.e("PhotoListLogicAECircle", "[error] no know mDataType~");
        continue;
        if (this.mDataType == 1) {
          this.mDataType = 0;
        } else if (this.mDataType != 0) {
          axiy.e("PhotoListLogicAECircle", "[error] no know mDataType~");
        }
      }
    }
  }
  
  public boolean onQueryPhoto(List<LocalMediaInfo> paramList)
  {
    return super.onQueryPhoto(paramList);
  }
  
  public void onSendBtnClick(View paramView)
  {
    ((NewPhotoListActivity)this.mActivity).sendBtn.setClickable(false);
    crV();
  }
  
  public void onTitleBtnCancelClick(View paramView)
  {
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECircleBroadcastReceiver.cP(this.mActivity);
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
      if (this.jdField_a_of_type_Ztu.bti) {
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
    if (!paramView.getBooleanExtra("PhotoConst.IS_CALL_IN_PLUGIN", false)) {
      ((NewPhotoListActivity)this.mActivity).startActivity(paramView);
    }
    for (;;)
    {
      ((NewPhotoListActivity)this.mActivity).finish();
      aqfy.anim(this.mActivity, false, false);
      return;
      paramView.getStringExtra("PhotoConst.PLUGIN_NAME");
      str2 = paramView.getStringExtra("PhotoConst.PLUGIN_APK");
      String str3 = paramView.getStringExtra("PhotoConst.UIN");
      if ("qzone_plugin.apk".equals(str2))
      {
        QzonePluginProxyActivity.x(paramView, str1);
        avpw.a(this.mActivity, str3, paramView, 2);
      }
    }
  }
  
  public void postInitUI()
  {
    super.postInitUI();
  }
  
  public void qr(String paramString)
  {
    this.mResPath = ankq.aM(this.mActivity);
    if (this.btE) {
      crV();
    }
  }
  
  public void updateButton()
  {
    super.updateButton();
    String str = ((NewPhotoListActivity)this.mActivity).getString(2131717066);
    int i = this.mPhotoCommonData.selectedPhotoList.size();
    str = str + " " + i + "/" + this.mPhotoCommonData.maxSelectNum;
    ((NewPhotoListActivity)this.mActivity).sendBtn.setText(str);
    if (i == 0)
    {
      ((NewPhotoListActivity)this.mActivity).sendBtn.setBackgroundResource(2130850768);
      ((NewPhotoListActivity)this.mActivity).sendBtn.setEnabled(false);
      return;
    }
    ((NewPhotoListActivity)this.mActivity).sendBtn.setBackgroundResource(2130838048);
    ((NewPhotoListActivity)this.mActivity).sendBtn.setEnabled(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zuy
 * JD-Core Version:    0.7.0.1
 */