import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.NewPhotoPreviewActivity;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.activity.photo.album.PhotoListBaseData;
import com.tencent.mobileqq.startup.step.CheckPermission;
import com.tencent.mobileqq.utils.kapalaiadapter.FileProvider7Helper;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class awuv
  extends awur
{
  public Handler mHandler = new awuv.a(this);
  
  public awuo a()
  {
    return new awuu();
  }
  
  protected awva a()
  {
    return awvb.a(this);
  }
  
  public void crP()
  {
    if (ilp.checkAVCameraUsed(BaseApplicationImpl.getContext())) {}
    label27:
    do
    {
      return;
      Intent localIntent = new Intent();
      Object localObject = null;
      try
      {
        File localFile = createImageFile();
        localObject = localFile;
      }
      catch (IOException localIOException)
      {
        break label27;
      }
    } while (localObject == null);
    FileProvider7Helper.setSystemCapture(getActivity(), localObject, localIntent);
    startActivityForResult(localIntent, 16);
  }
  
  public void crQ()
  {
    if (((this.mPhotoListData.isShowCamera) && ("$RecentAlbumId".equals(this.a.mPhotoCommonData.albumId))) || ((this.mPhotoListData.showCameraInVideo) && ("$VideoAlbumId".equals(this.a.mPhotoCommonData.albumId)))) {
      excuteQueryPhotoTask();
    }
  }
  
  protected Dialog getDialog()
  {
    ReportDialog localReportDialog = new ReportDialog(getActivity(), 2131756467);
    localReportDialog.setContentView(2131559761);
    return localReportDialog;
  }
  
  public Class getJumpActivity()
  {
    return NewPhotoPreviewActivity.class;
  }
  
  public LocalMediaInfo getMediaInfo(String paramString)
  {
    PhotoCommonBaseData localPhotoCommonBaseData = this.a.mPhotoCommonData;
    LocalMediaInfo localLocalMediaInfo = null;
    if (localPhotoCommonBaseData.selectedMediaInfoHashMap != null) {
      localLocalMediaInfo = (LocalMediaInfo)localPhotoCommonBaseData.selectedMediaInfoHashMap.get(paramString);
    }
    if ((localLocalMediaInfo == null) && (localPhotoCommonBaseData.allMediaInfoHashMap != null)) {
      localLocalMediaInfo = (LocalMediaInfo)localPhotoCommonBaseData.allMediaInfoHashMap.get(paramString);
    }
    for (;;)
    {
      if ((localLocalMediaInfo != null) && ((localLocalMediaInfo.mediaWidth == 0) || (localLocalMediaInfo.mediaHeight == 0)))
      {
        azbt.a locala = new azbt.a();
        azbt.a(paramString, locala);
        localLocalMediaInfo.mediaWidth = locala.mMetaData[0];
        localLocalMediaInfo.mediaHeight = locala.mMetaData[1];
        localLocalMediaInfo.rotation = locala.mMetaData[2];
        if (localPhotoCommonBaseData.allMediaInfoHashMap != null)
        {
          paramString = (LocalMediaInfo)localPhotoCommonBaseData.allMediaInfoHashMap.get(paramString);
          if ((paramString != null) && ((paramString.mediaWidth == 0) || (paramString.mediaHeight == 0)))
          {
            paramString.mediaWidth = localLocalMediaInfo.mediaWidth;
            paramString.mediaHeight = localLocalMediaInfo.mediaHeight;
            paramString.rotation = localLocalMediaInfo.rotation;
          }
        }
      }
      return localLocalMediaInfo;
    }
  }
  
  public int getMediaType(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (getMediaInfo(paramString) == null)) {
      return -1;
    }
    return aqfy.getMediaType(getMediaInfo(paramString));
  }
  
  protected void initUI(View paramView)
  {
    RelativeLayout localRelativeLayout = (RelativeLayout)paramView.findViewById(2131377546);
    super.initUI(paramView);
    this.E.addOnScrollListener(new awuw(this));
  }
  
  public void onClick(View paramView)
  {
    super.onClick(paramView);
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.a.onMagicStickClick(paramView, new Bundle(), 2, null);
    }
  }
  
  public void onCreate(@Nullable Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (!CheckPermission.isHasStoragePermission(getActivity().getApplicationContext())) {
      CheckPermission.requestStorePermission(getActivity(), null);
    }
  }
  
  public void onPause()
  {
    super.onPause();
    aeee.e(BaseApplicationImpl.getContext(), 2, true);
  }
  
  public void zJ(String paramString)
  {
    try
    {
      FileProvider7Helper.savePhotoToSysAlbum(getActivity(), paramString);
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("PhotoListActivity", 2, "scanMediaFile :", paramString);
    }
  }
  
  static class a
    extends Handler
  {
    private final WeakReference<awuv> mActivity;
    
    public a(awuv paramawuv)
    {
      this.mActivity = new WeakReference(paramawuv);
    }
    
    public void handleMessage(Message paramMessage)
    {
      if ((this.mActivity == null) || (this.mActivity.get() == null)) {}
      Object localObject;
      do
      {
        return;
        localObject = (awuv)this.mActivity.get();
        localArrayList = ((awuv)localObject).jdField_a_of_type_Awva.mPhotoCommonData.selectedPhotoList;
        switch (paramMessage.what)
        {
        default: 
          return;
        case 0: 
          localObject = ((awuv)localObject).jdField_a_of_type_Awur$a;
        }
      } while (localObject == null);
      ArrayList localArrayList = new ArrayList();
      localArrayList.addAll(((awur.a)localObject).mAllImages);
      paramMessage = paramMessage.getData();
      int i = paramMessage.getInt("ALBUMLIST_POSITION");
      long l = paramMessage.getLong("ALBUMLIST_ITEM_DURATION");
      paramMessage = (LocalMediaInfo)localArrayList.get(i);
      paramMessage.mDuration = l;
      localArrayList.set(i, paramMessage);
      ((awur.a)localObject).setPhotoList(localArrayList);
      ((awur.a)localObject).notifyDataSetChanged();
      return;
      ((awuv)this.mActivity.get()).jdField_a_of_type_Awva.handleVideoEncodeSucceed(paramMessage);
      return;
      ((awuv)localObject).cancleProgressDailog();
      QLog.e("PhotoListActivity", 2, new Object[] { "onEncodeError = ", Integer.valueOf(((Integer)paramMessage.obj).intValue()) });
      QQToast.a(((awuv)localObject).getActivity(), ((awuv)localObject).getResources().getString(2131696898), 0).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awuv
 * JD-Core Version:    0.7.0.1
 */