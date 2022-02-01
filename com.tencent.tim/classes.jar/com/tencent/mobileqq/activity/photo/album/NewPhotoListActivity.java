package com.tencent.mobileqq.activity.photo.album;

import NS_MOBILE_PHOTO.get_albumlist_num_rsp;
import acbn;
import aeee;
import akln;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.TextView;
import aqfy;
import aqhq;
import azbt;
import azbt.a;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.startup.step.CheckPermission;
import com.tencent.mobileqq.utils.kapalaiadapter.FileProvider7Helper;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.widget.GestureSelectGridView;
import com.tencent.widget.immersive.ImmersiveUtils;
import ilp;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import zts;
import zuc;
import zvz;

public class NewPhotoListActivity
  extends AbstractPhotoListActivity
{
  public TextView Nn;
  public TextView No;
  TextView Np;
  public b a = new b();
  public Handler mHandler = new a(this);
  public Button magicStickBtn;
  public CheckBox qualityCheckBox;
  public TextView qualityTv;
  View yV;
  
  protected boolean R(Intent paramIntent)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramIntent != null)
    {
      boolean bool3 = paramIntent.getBooleanExtra("extra_directly_back", false);
      boolean bool4 = paramIntent.getBooleanExtra("PhotoConst.IS_VIDEO_RECORDED", false);
      bool1 = bool2;
      if (bool3)
      {
        if (!bool4) {
          break label50;
        }
        this.mPhotoListLogic.handleVideoCapture(paramIntent);
      }
    }
    for (;;)
    {
      bool1 = true;
      return bool1;
      label50:
      this.mPhotoListLogic.handlePicCapture(paramIntent);
    }
  }
  
  public void c(List<String> paramList, HashMap<String, LocalMediaInfo> paramHashMap)
  {
    if ((paramList != null) && (paramHashMap != null) && (this.mPhotoListLogic.mPhotoCommonData.allMediaInfoHashMap != null))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        String str = (String)paramList.next();
        if (!paramHashMap.containsKey(str)) {
          paramHashMap.put(str, this.mPhotoListLogic.mPhotoCommonData.allMediaInfoHashMap.get(str));
        }
      }
    }
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
    FileProvider7Helper.setSystemCapture(this, localObject, localIntent);
    startActivityForResult(localIntent, 16);
  }
  
  public void crQ()
  {
    if (((this.mPhotoListData.isShowCamera) && ("$RecentAlbumId".equals(this.mPhotoListLogic.mPhotoCommonData.albumId))) || ((this.mPhotoListData.showCameraInVideo) && ("$VideoAlbumId".equals(this.mPhotoListLogic.mPhotoCommonData.albumId)))) {
      excuteQueryPhotoTask();
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    if (!CheckPermission.isHasStorageReadAndWritePermission(this)) {
      CheckPermission.requestStoreReadAndWritePermission(this, null);
    }
    return true;
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    aeee.e(BaseApplicationImpl.getContext(), 2, true);
  }
  
  protected PhotoListLogic generateLogic()
  {
    int i = getIntent().getIntExtra("enter_from", 0);
    PhotoListLogic localPhotoListLogic = zvz.a(i, this);
    if (QLog.isColorLevel()) {
      QLog.d("PhotoListActivity", 2, "generateLogic:" + localPhotoListLogic.getClass().getName() + " enterFrom:" + i);
    }
    return localPhotoListLogic;
  }
  
  public AbstractAlbumListFragment getAlbumListFragment()
  {
    return new AlbumListFragment();
  }
  
  protected Dialog getDialog()
  {
    ReportDialog localReportDialog = new ReportDialog(this, 2131756467);
    localReportDialog.setContentView(2131559761);
    return localReportDialog;
  }
  
  public Class getJumpActivity()
  {
    return NewPhotoPreviewActivity.class;
  }
  
  public LocalMediaInfo getMediaInfo(String paramString)
  {
    PhotoCommonBaseData localPhotoCommonBaseData = this.mPhotoListLogic.mPhotoCommonData;
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
  
  String hT(String paramString)
  {
    try
    {
      File localFile = new File(paramString);
      Object localObject = paramString;
      if (localFile.exists())
      {
        localObject = localFile.getName();
        String str = acbn.SDCARD_IMG_CAMERA + (String)localObject;
        localObject = paramString;
        if (!str.equals(paramString))
        {
          localObject = new File(acbn.SDCARD_IMG_CAMERA);
          if (!((File)localObject).exists()) {
            ((File)localObject).mkdirs();
          }
          boolean bool2 = localFile.renameTo(new File(str));
          boolean bool1 = bool2;
          if (!bool2) {
            bool1 = aqhq.moveFile(paramString, str);
          }
          QLog.d("PhotoListActivity", 2, new Object[] { "saveToDCIM rename to :", str });
          localObject = paramString;
          if (bool1) {
            localObject = str;
          }
        }
      }
      return localObject;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("PhotoListActivity", 2, "saveToDCIM :", localThrowable);
    }
    return paramString;
  }
  
  protected void initUI()
  {
    RelativeLayout localRelativeLayout = (RelativeLayout)findViewById(2131377546);
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      localRelativeLayout.setFitsSystemWindows(true);
      localRelativeLayout.setPadding(0, ImmersiveUtils.getStatusBarHeight(this), 0, 0);
    }
    this.yV = findViewById(2131368154);
    this.Np = ((TextView)findViewById(2131381344));
    this.magicStickBtn = ((Button)findViewById(2131371047));
    this.qualityCheckBox = ((CheckBox)findViewById(2131375366));
    this.qualityTv = ((TextView)findViewById(2131375372));
    this.Nn = ((TextView)findViewById(2131375367));
    this.No = ((TextView)findViewById(2131368998));
    super.initUI();
    this.mGridView.setOnScrollListener(new zts(this));
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
      this.mPhotoListLogic.onMagicStickClick(paramView, new Bundle(), 2, null);
    }
  }
  
  void processNewIntent(Intent paramIntent)
  {
    if (paramIntent.getBooleanExtra("extra_directly_back", false))
    {
      this.mPhotoListData.needQueryTask = false;
      R(paramIntent);
      QLog.d("PhotoListActivity", 2, "PhotoListActivity onNewIntent() camera back");
      return;
    }
    setIntent(paramIntent);
    this.mPhotoListLogic.initData(paramIntent);
  }
  
  public void zJ(String paramString)
  {
    try
    {
      FileProvider7Helper.savePhotoToSysAlbum(this, paramString);
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
    private final WeakReference<NewPhotoListActivity> mActivity;
    
    public a(NewPhotoListActivity paramNewPhotoListActivity)
    {
      this.mActivity = new WeakReference(paramNewPhotoListActivity);
    }
    
    public void handleMessage(Message paramMessage)
    {
      if ((this.mActivity == null) || (this.mActivity.get() == null)) {}
      Object localObject2;
      Object localObject1;
      do
      {
        do
        {
          return;
          localObject2 = (NewPhotoListActivity)this.mActivity.get();
          localObject1 = ((NewPhotoListActivity)this.mActivity.get()).mPhotoListLogic.mPhotoCommonData.selectedPhotoList;
          switch (paramMessage.what)
          {
          default: 
            return;
          case 0: 
            localObject1 = ((NewPhotoListActivity)localObject2).photoListAdapter;
          }
        } while (localObject1 == null);
        localObject2 = new ArrayList();
        ((List)localObject2).addAll(((AbstractPhotoListActivity.PhotoListAdapter)localObject1).mAllImages);
        paramMessage = paramMessage.getData();
        int i = paramMessage.getInt("ALBUMLIST_POSITION");
        long l = paramMessage.getLong("ALBUMLIST_ITEM_DURATION");
        paramMessage = (LocalMediaInfo)((List)localObject2).get(i);
        paramMessage.mDuration = l;
        ((List)localObject2).set(i, paramMessage);
        ((AbstractPhotoListActivity.PhotoListAdapter)localObject1).setPhotoList((List)localObject2);
        ((AbstractPhotoListActivity.PhotoListAdapter)localObject1).notifyDataSetChanged();
        return;
        ((NewPhotoListActivity)localObject2).mPhotoListLogic.handleVideoEncodeSucceed(paramMessage);
        return;
        ((NewPhotoListActivity)localObject2).cancleProgressDailog();
        QLog.e("PhotoListActivity", 2, new Object[] { "onEncodeError = ", Integer.valueOf(((Integer)paramMessage.obj).intValue()) });
        QQToast.a((Context)localObject2, ((NewPhotoListActivity)localObject2).getResources().getString(2131696898), 0).show();
        return;
      } while (!(paramMessage.obj instanceof String));
      String str = (String)paramMessage.obj;
      paramMessage = (Message)localObject1;
      if (localObject1 == null) {
        paramMessage = new ArrayList();
      }
      QLog.d("PhotoListActivity", 2, new Object[] { "MSG_PHOTO_ENCODE_SUCCEED = ", str });
      if (paramMessage.size() < ((NewPhotoListActivity)localObject2).mPhotoListLogic.mPhotoCommonData.maxSelectNum)
      {
        paramMessage.add(str);
        ((NewPhotoListActivity)localObject2).crQ();
      }
      for (;;)
      {
        ((NewPhotoListActivity)localObject2).zJ(str);
        return;
        QQToast.a((Context)localObject2, String.format(((NewPhotoListActivity)localObject2).getResources().getString(2131696894), new Object[] { Integer.valueOf(((NewPhotoListActivity)localObject2).mPhotoListLogic.mPhotoCommonData.maxSelectNum) }), 0).show();
      }
    }
  }
  
  public class b
    extends akln
  {
    b() {}
    
    public void E(boolean paramBoolean, Bundle paramBundle)
    {
      paramBundle = paramBundle.getSerializable("data");
      if ((paramBoolean) && ((paramBundle instanceof get_albumlist_num_rsp))) {
        ((zuc)NewPhotoListActivity.this.mPhotoListLogic.mOtherCommonData).Ly = ((get_albumlist_num_rsp)paramBundle).album_num;
      }
      BaseApplicationImpl.getApplication().getRuntime().unRegistObserver(NewPhotoListActivity.this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity
 * JD-Core Version:    0.7.0.1
 */