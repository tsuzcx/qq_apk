import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.media.MediaMetadataRetriever;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.pic.PresendPicMgr;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import cooperation.qzone.QzonePluginProxyActivity;
import dov.com.qq.im.ae.camera.core.AECircleBroadcastReceiver;
import dov.com.qq.im.ae.camera.core.AECircleBroadcastReceiver.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import mqq.util.WeakReference;

public class awvb
  extends awvf
  implements AECircleBroadcastReceiver.a
{
  private static final String[] db = { "video/mp4", "video/3gpp" };
  private AECircleBroadcastReceiver a;
  private boolean btE;
  private int cfo = 3000;
  private int cfp = 3000;
  private boolean dsH;
  private Dialog g;
  private int mDataType = 0;
  private String mResPath;
  
  private awvb(awuv paramawuv)
  {
    super(paramawuv);
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECircleBroadcastReceiver = new AECircleBroadcastReceiver(this);
    axiy.d("PhotoListLogicAECircle", "[AE Profiler] PhotoListLogicAECircle new");
  }
  
  public static awva a(awuv paramawuv)
  {
    if ((b == null) || (b.bu.get() != paramawuv)) {}
    try
    {
      if ((b == null) || (b.bu.get() != paramawuv)) {
        b = new awvb(paramawuv);
      }
      return b;
    }
    finally {}
  }
  
  private int b(LocalMediaInfo paramLocalMediaInfo)
  {
    long l = paramLocalMediaInfo.mDuration;
    if ((l > 3600000L) || (l < 2000L)) {
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
    if ((this.mResPath == null) && (Build.VERSION.SDK_INT >= 21))
    {
      if (!aqiw.isNetworkAvailable())
      {
        QQToast.a(((awuv)this.bu.get()).getActivity(), acfp.m(2131689983), 0).show(((awuv)this.bu.get()).mTitleBarHeight);
        return;
      }
      this.btE = true;
      showLoading(true);
      return;
    }
    axoe.a(this.mDataType, ((awuv)this.bu.get()).getActivity(), this.mPhotoCommonData, this.mResPath, true);
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECircleBroadcastReceiver.cP(((awuv)this.bu.get()).getActivity());
    showLoading(false);
  }
  
  private void showLoading(boolean paramBoolean)
  {
    if ((this.bu.get() != null) && (!((awuv)this.bu.get()).getActivity().isFinishing()))
    {
      if (!paramBoolean) {
        break label99;
      }
      if (this.g == null)
      {
        this.g = new ReportDialog(((awuv)this.bu.get()).getActivity(), 2131756467);
        this.g.setCancelable(false);
        this.g.setCanceledOnTouchOutside(false);
        this.g.setContentView(2131559761);
      }
      this.g.show();
    }
    label99:
    while ((this.g == null) || (!this.g.isShowing())) {
      return;
    }
    this.g.dismiss();
  }
  
  public Intent a(View paramView, int paramInt)
  {
    paramView = super.a(paramView, paramInt);
    paramView.putExtra("choosed_num", this.mPhotoCommonData.selectedPhotoList.size());
    paramView.putExtra("res_path", this.mResPath);
    LocalMediaInfo localLocalMediaInfo1 = ((awuv)this.bu.get()).a.getItem(paramInt);
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    int m = this.mPhotoCommonData.mediaPathsList.size();
    int k = 0;
    int j = 0;
    int i = paramInt;
    if (k < m)
    {
      String str = (String)this.mPhotoCommonData.mediaPathsList.get(k);
      LocalMediaInfo localLocalMediaInfo2 = (LocalMediaInfo)this.mPhotoCommonData.allMediaInfoHashMap.get(str);
      if (aqfy.getMediaType(localLocalMediaInfo2) != 0) {
        break label281;
      }
      localArrayList1.add(str);
      if ((this.mPhotoCommonData.selectedPhotoList != null) && (this.mPhotoCommonData.selectedPhotoList.contains(str))) {
        localArrayList2.add(Integer.valueOf(j));
      }
      if (localLocalMediaInfo2.position.intValue() != paramInt) {
        break label278;
      }
      i = j;
      label200:
      j += 1;
    }
    label278:
    label281:
    for (;;)
    {
      k += 1;
      break;
      this.mPhotoCommonData.mediaPathsList = localArrayList1;
      paramView.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", localArrayList1);
      paramView.putStringArrayListExtra("PhotoConst.SELECTED_PATHS", this.mPhotoCommonData.selectedPhotoList);
      paramView.putIntegerArrayListExtra("PhotoConst.SELECTED_INDEXS", localArrayList2);
      if (aqfy.getMediaType(localLocalMediaInfo1) == 0) {
        paramView.putExtra("PhotoConst.CURRENT_SELECTED_INDEX", i);
      }
      return paramView;
      break label200;
    }
  }
  
  public void aG(View paramView, int paramInt)
  {
    LocalMediaInfo localLocalMediaInfo;
    if (this.mPhotoCommonData.selectedPhotoList.size() == 0)
    {
      localLocalMediaInfo = ((awuv)this.bu.get()).a.getItem(paramInt);
      switch (b(localLocalMediaInfo))
      {
      default: 
        return;
      case 0: 
        this.mDataType = 1;
        this.mPhotoCommonData.selectedPhotoList.add(localLocalMediaInfo.path);
        this.mPhotoCommonData.selectedIndex.add(Integer.valueOf(paramInt));
        this.mPhotoCommonData.selectedMediaInfoHashMap.put(localLocalMediaInfo.path, localLocalMediaInfo);
        paramView = (LinkedHashMap)aqfy.sSelectItemPosMap.get(this.mPhotoCommonData.albumId);
        if (paramView == null)
        {
          paramView = new LinkedHashMap();
          aqfy.sSelectItemPosMap.put(this.mPhotoCommonData.albumId, paramView);
        }
        break;
      }
    }
    for (;;)
    {
      paramView.put(localLocalMediaInfo.path, Integer.valueOf(((GridLayoutManager)((awuv)this.bu.get()).E.getLayoutManager()).findFirstVisibleItemPosition()));
      paramView = aqfy.sSelectItemAlbum;
      if (!paramView.containsKey(localLocalMediaInfo.path))
      {
        Pair localPair = new Pair(this.mPhotoCommonData.albumId, this.mPhotoCommonData.albumName);
        paramView.put(localLocalMediaInfo.path, localPair);
      }
      if (Build.VERSION.SDK_INT >= 23) {
        if (((awuv)this.bu.get()).getActivity().checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0) {
          paramInt = 1;
        }
      }
      for (;;)
      {
        if (paramInt != 0)
        {
          axiy.i("PhotoListLogicAECircle", "updateWMProps onGetLocation");
          axaq.a().eIt();
        }
        crV();
        this.mPhotoCommonData.selectedPhotoList.clear();
        return;
        paramInt = 0;
        continue;
        QQToast.a(((awuv)this.bu.get()).getActivity(), "请选择2秒到1小时之间的视频", 0).show(((awuv)this.bu.get()).mTitleBarHeight);
        return;
        QQToast.a(((awuv)this.bu.get()).getActivity(), 2131689989, 0).show(((awuv)this.bu.get()).mTitleBarHeight);
        return;
        QQToast.a(((awuv)this.bu.get()).getActivity(), acfp.m(2131689990), 0).show(((awuv)this.bu.get()).mTitleBarHeight);
        return;
        QQToast.a(((awuv)this.bu.get()).getActivity(), acfp.m(2131689988), 0).show(((awuv)this.bu.get()).mTitleBarHeight);
        return;
        QQToast.a(((awuv)this.bu.get()).getActivity(), acfp.m(2131689991), 0).show(((awuv)this.bu.get()).mTitleBarHeight);
        return;
        QQToast.a(((awuv)this.bu.get()).getActivity(), acfp.m(2131689986), 0).show(((awuv)this.bu.get()).mTitleBarHeight);
        return;
        paramInt = 1;
      }
    }
  }
  
  public void initData(Intent paramIntent)
  {
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECircleBroadcastReceiver.cO(((awuv)this.bu.get()).getActivity());
    anjx.a().b("CMD_DOWNLOAD_PTU_BASE_RES", new Bundle());
    super.initData(paramIntent);
    paramIntent = ((awuv)this.bu.get()).getActivity().getIntent().getStringExtra("albumName");
    String str = ((awuv)this.bu.get()).getActivity().getIntent().getStringExtra("albumId");
    if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty(paramIntent)))
    {
      this.mPhotoCommonData.albumName = paramIntent;
      this.mPhotoCommonData.albumId = str;
    }
    this.cfo = 3000;
    this.cfp = 3000;
  }
  
  public void onCheckBoxClick(View paramView, int paramInt, CheckBox paramCheckBox)
  {
    LocalMediaInfo localLocalMediaInfo = ((awuv)this.bu.get()).a.getItem(paramInt);
    int i = aqfy.getMediaType(localLocalMediaInfo);
    if (localLocalMediaInfo.selectStatus != 1) {
      if (this.mDataType == 1)
      {
        if (this.mPhotoCommonData.selectedPhotoList.size() == 1)
        {
          if (i == 0) {
            QQToast.a(((awuv)this.bu.get()).getActivity(), acfp.m(2131689986), 0).show(((awuv)this.bu.get()).mTitleBarHeight);
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
          if (((awuv)this.bu.get()).isGif(localLocalMediaInfo))
          {
            QQToast.a(((awuv)this.bu.get()).getActivity(), acfp.m(2131689984), 0).show(((awuv)this.bu.get()).mTitleBarHeight);
            return;
          }
          if ((localLocalMediaInfo.mediaWidth < 20) || (localLocalMediaInfo.mediaHeight < 20))
          {
            QQToast.a(((awuv)this.bu.get()).getActivity(), acfp.m(2131689981), 0).show(((awuv)this.bu.get()).mTitleBarHeight);
            return;
          }
          if (this.mPhotoCommonData.selectedPhotoList.size() >= 9) {
            QQToast.a(((awuv)this.bu.get()).getActivity(), acfp.m(2131689985), 0).show(((awuv)this.bu.get()).mTitleBarHeight);
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
    boolean bool = super.onQueryPhoto(paramList);
    long l2;
    long l1;
    if (!this.dsH)
    {
      this.dsH = true;
      paramList = (awuv)this.bu.get();
      if ((paramList != null) && (paramList.getActivity() != null))
      {
        paramList = paramList.getActivity().getIntent();
        if (axcg.ay(paramList))
        {
          l2 = System.currentTimeMillis();
          l1 = l2 - paramList.getLongExtra("PhotoConst.timestamp", 0L);
          l2 -= paramList.getLongExtra("PhotoConst.timestamp_last_activity", 0L);
          if ((l1 <= 60000L) && (l2 <= 60000L) && (l1 >= 0L) && (l2 >= 0L)) {
            break label117;
          }
        }
      }
    }
    return bool;
    label117:
    axim.a().aQ(l1, l2);
    return bool;
  }
  
  public void onSendBtnClick(View paramView)
  {
    crV();
  }
  
  public void onTitleBtnCancelClick(View paramView)
  {
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECircleBroadcastReceiver.cP(((awuv)this.bu.get()).getActivity());
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
    if (!paramView.getBooleanExtra("PhotoConst.IS_CALL_IN_PLUGIN", false)) {
      ((awuv)this.bu.get()).startActivity(paramView);
    }
    for (;;)
    {
      ((awuv)this.bu.get()).getActivity().finish();
      aqfy.anim(((awuv)this.bu.get()).getActivity(), false, false);
      return;
      paramView.getStringExtra("PhotoConst.PLUGIN_NAME");
      str2 = paramView.getStringExtra("PhotoConst.PLUGIN_APK");
      String str3 = paramView.getStringExtra("PhotoConst.UIN");
      if ("qzone_plugin.apk".equals(str2))
      {
        QzonePluginProxyActivity.x(paramView, str1);
        avpw.a(((awuv)this.bu.get()).getActivity(), str3, paramView, 2);
      }
    }
  }
  
  public void postInitUI()
  {
    super.postInitUI();
  }
  
  public void qr(String paramString)
  {
    this.mResPath = ankq.aM(((awuv)this.bu.get()).getActivity());
    if (this.btE) {
      crV();
    }
  }
  
  protected void updateButton()
  {
    super.updateButton();
    String str = ((awuv)this.bu.get()).getString(2131717066);
    int i = this.mPhotoCommonData.selectedPhotoList.size();
    if (i != 0) {
      str = str + "(" + i + ")";
    }
    for (;;)
    {
      ((awuv)this.bu.get()).agP.setText(str);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awvb
 * JD-Core Version:    0.7.0.1
 */