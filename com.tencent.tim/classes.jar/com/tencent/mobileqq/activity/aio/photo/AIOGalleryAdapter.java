package com.tencent.mobileqq.activity.aio.photo;

import acfp;
import afei;
import agmx;
import ahbj;
import alyn;
import alyp;
import alyr;
import android.annotation.TargetApi;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import anot;
import aoop;
import aqcx;
import aqfv;
import aqhq;
import aqiw;
import avfp;
import axol;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.galleryactivity.AbstractImageAdapter;
import com.tencent.common.galleryactivity.AbstractImageAdapter.URLImageView2;
import com.tencent.image.JpegExifReader;
import com.tencent.image.RegionDrawableData;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.image.VideoDrawable;
import com.tencent.image.VideoDrawable.OnPlayRepeatListener;
import com.tencent.image.VideoDrawable.VideoDrawableParams;
import com.tencent.mobileqq.activity.photo.ProGallery;
import com.tencent.mobileqq.activity.photo.ProGallery.b;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.theme.SkinnableBitmapDrawable;
import com.tencent.widget.AdapterView;
import com.tencent.widget.Gallery.LayoutParams;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import org.json.JSONObject;
import rar;
import rpc;
import skj;
import sxm;
import sxz;
import wja;
import xsf;
import xsg;
import xsh;
import xsk;
import xto;
import xuf;
import xuh;
import xuk;
import xuk.b;
import zti;
import ztj;
import ztn;

public class AIOGalleryAdapter
  extends AbstractImageAdapter
  implements ProGallery.b
{
  long Ju = -1L;
  private long Jv = -1L;
  private GalleryImageStruct jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter$GalleryImageStruct;
  public a a;
  private b jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter$b;
  xto jdField_a_of_type_Xto;
  ztj jdField_a_of_type_Ztj;
  private int aXh = -1;
  public AIOGalleryActivity b;
  private GalleryImageStruct jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter$GalleryImageStruct;
  AIORichMediaData jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
  xuh jdField_b_of_type_Xuh;
  private int bWK = -1;
  public boolean biD;
  boolean biE = false;
  private SparseArray<URLDrawable> by = new SparseArray();
  int loadType;
  private SparseArray<URLDrawable> mActiveDrawable = new SparseArray();
  String mFriendUin;
  private URLDrawable mRawDrawable;
  private int mRawDrawablePosition = -1;
  private int mScreenHeightPx;
  private int mScreenWidthPx;
  int mSessionType;
  long mStartPlayTime = -1L;
  long mVideoDuration = -1L;
  private ArrayList<String> qJ = new ArrayList();
  
  public AIOGalleryAdapter(Context paramContext, xuh paramxuh, boolean paramBoolean, int paramInt)
  {
    this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity = ((AIOGalleryActivity)paramContext);
    this.jdField_b_of_type_Xuh = paramxuh;
    this.mScreenWidthPx = paramContext.getResources().getDisplayMetrics().widthPixels;
    this.mScreenHeightPx = paramContext.getResources().getDisplayMetrics().heightPixels;
    this.biE = paramBoolean;
    this.loadType = paramInt;
    paramContext = this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.getIntent();
    if (paramContext != null)
    {
      this.mSessionType = paramContext.getIntExtra("forward_source_uin_type", -1);
      this.mFriendUin = paramContext.getStringExtra("uin");
    }
  }
  
  private View a(xuf paramxuf, int paramInt, GalleryImageStruct paramGalleryImageStruct)
  {
    AIOFileVideoData localAIOFileVideoData;
    if (this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.biz)
    {
      this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.biz = false;
      anot.a(null, "dc00898", "", "", "0X8009EF3", "0X8009EF3", 1, 0, "", "", "", "");
      localAIOFileVideoData = (AIOFileVideoData)paramxuf.e;
      paramGalleryImageStruct.setPosition(paramInt);
      paramGalleryImageStruct.setImageInfo(paramxuf);
      paramGalleryImageStruct.setIgnoreLayout(false);
      if ((!this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.bix) && (!this.biE))
      {
        this.jdField_b_of_type_Xuh.loadMedias(this.loadType);
        this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.bix = true;
      }
      paramGalleryImageStruct = (Drawable)this.mActiveDrawable.get(paramInt);
      if (!localAIOFileVideoData.hasError()) {
        break label237;
      }
    }
    label561:
    for (;;)
    {
      Object localObject = this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.getLayoutInflater().inflate(2131561544, null);
      ((View)localObject).setTag(2131296400, Boolean.valueOf(true));
      ((View)localObject).setTag(2131296433, Boolean.valueOf(true));
      ((View)localObject).setLayoutParams(new Gallery.LayoutParams(-1, -1));
      URLImageView localURLImageView = (URLImageView)((View)localObject).findViewById(2131373580);
      localURLImageView.setImageDrawable(paramGalleryImageStruct);
      if (localAIOFileVideoData.hasError())
      {
        localURLImageView.setImageDrawable(null);
        return localObject;
        anot.a(null, "dc00898", "", "", "0X8009EF3", "0X8009EF3", 2, 0, "", "", "", "");
        break;
        label237:
        if ((paramGalleryImageStruct != null) && (((URLDrawable)paramGalleryImageStruct).getStatus() == 1))
        {
          onLoadFinish(paramInt, true);
          continue;
        }
        if (!TextUtils.isEmpty(localAIOFileVideoData.bN))
        {
          localObject = new File(localAIOFileVideoData.bN);
          if (!((File)localObject).exists()) {
            break label561;
          }
          paramGalleryImageStruct = URLDrawable.URLDrawableOptions.obtain();
          paramGalleryImageStruct.mRequestWidth = this.mScreenWidthPx;
          paramGalleryImageStruct.mRequestHeight = this.mScreenHeightPx;
          paramGalleryImageStruct.mLoadingDrawable = aoop.TRANSPARENT;
          paramGalleryImageStruct.mPlayGifImage = true;
          paramGalleryImageStruct.mUseExifOrientation = false;
          paramGalleryImageStruct = URLDrawable.getDrawable((File)localObject, paramGalleryImageStruct);
          ((URLDrawable)paramGalleryImageStruct).setTag(Integer.valueOf(1));
          this.mActiveDrawable.put(paramInt, (URLDrawable)paramGalleryImageStruct);
          continue;
        }
        paramGalleryImageStruct = BaseApplicationImpl.getApplication().getResources().getDrawable(2130838158);
        continue;
      }
      if ((paramxuf.isEnterImage) && (!this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.biA)) {
        if (this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.bWH == 1)
        {
          paramxuf = this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity;
          paramxuf.bWH -= 1;
          this.Jv = -1L;
          if (QLog.isColorLevel()) {
            QLog.i(" AIOGalleryAdapter", 1, "FileVideo_AP set hasDoneItemSelectUid = -1");
          }
        }
      }
      for (;;)
      {
        return localObject;
        if (this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.bWH == 0)
        {
          this.Jv = localAIOFileVideoData.id;
          localAIOFileVideoData.biv = true;
          if (QLog.isColorLevel())
          {
            QLog.i(" AIOGalleryAdapter", 1, "FileVideo_AP set hasDoneItemSelectUid = " + this.Jv);
            continue;
            this.Jv = localAIOFileVideoData.id;
            if (QLog.isColorLevel()) {
              QLog.i(" AIOGalleryAdapter", 1, "FileVideo_AP is not EnterImage && isAutoPlayed, set hasDoneItemSelectUid = " + this.Jv);
            }
          }
        }
      }
    }
  }
  
  private URLDrawable a(GalleryImageStruct paramGalleryImageStruct, xuf paramxuf, AIOImageData paramAIOImageData, boolean paramBoolean, int paramInt, File paramFile)
  {
    Object localObject1 = null;
    Object localObject2 = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = this.mScreenWidthPx;
    ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = this.mScreenHeightPx;
    ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = aoop.TRANSPARENT;
    ((URLDrawable.URLDrawableOptions)localObject2).mPlayGifImage = true;
    ((URLDrawable.URLDrawableOptions)localObject2).mUseExifOrientation = false;
    ((URLDrawable.URLDrawableOptions)localObject2).mDecodeFileStrategy = 2;
    if ((paramAIOImageData.EP == 1) && ((paramAIOImageData.bWU & 0x2) == 2)) {
      ((URLDrawable.URLDrawableOptions)localObject2).mUseAutoScaleParams = false;
    }
    if (this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.bix)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter$GalleryImageStruct != null)
      {
        ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter$GalleryImageStruct.getDrawable();
        paramGalleryImageStruct.setTag(2131296389, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter$GalleryImageStruct.getTag(2131296389));
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter$GalleryImageStruct = null;
      }
    }
    else {
      if (paramBoolean) {
        break label407;
      }
    }
    label407:
    label445:
    label453:
    do
    {
      do
      {
        for (;;)
        {
          try
          {
            if (!paramAIOImageData.bjc) {
              continue;
            }
            localObject2 = URLDrawable.getDrawable(paramAIOImageData.cH(2) + "#" + "PART", (URLDrawable.URLDrawableOptions)localObject2);
            localObject1 = localObject2;
            localObject1.setTag(Integer.valueOf(1));
            this.mActiveDrawable.put(paramInt, localObject1);
            a(localObject1, paramGalleryImageStruct, paramxuf, paramInt, paramFile, paramBoolean);
            if (!paramBoolean) {
              break label445;
            }
            paramxuf = paramAIOImageData.aVY;
            paramxuf = aqhq.estimateFileType(paramxuf);
            if (QLog.isColorLevel()) {
              QLog.i(" AIOGalleryAdapter", 2, "getview url is " + localObject1.getURL().toString() + ", file type is " + paramAIOImageData.bM(localObject1.getURL().toString()) + ",extName = " + paramxuf);
            }
            if ((paramBoolean) || (!paramAIOImageData.bjc) || (paramAIOImageData.bim)) {
              break label453;
            }
            this.jdField_b_of_type_Xuh.downloadMedia(paramAIOImageData.id, paramAIOImageData.subId, 2);
            paramxuf = localObject1;
            if (!this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.bix)
            {
              this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter$GalleryImageStruct = paramGalleryImageStruct;
              paramxuf = localObject1;
            }
          }
          catch (Throwable paramGalleryImageStruct)
          {
            paramxuf = localObject1;
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.e(" AIOGalleryAdapter", 2, "[getView] URLDrawable.getDrawable failed.");
            return null;
          }
          return paramxuf;
          if ((paramAIOImageData.cH(1) == null) || (BaseApplicationImpl.sImageCache.get(paramAIOImageData.cH(1)) == null) || (paramAIOImageData.c(1) == null)) {
            break;
          }
          ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = URLDrawable.getDrawable(paramAIOImageData.cH(1), null);
          break;
          localObject2 = URLDrawable.getDrawable(paramFile, (URLDrawable.URLDrawableOptions)localObject2);
          localObject1 = localObject2;
          continue;
          paramxuf = paramAIOImageData.aVX;
        }
        paramxuf = localObject1;
      } while (this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.bix);
      paramxuf = localObject1;
    } while (this.biE);
    this.jdField_b_of_type_Xuh.loadMedias(this.loadType);
    this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.bix = true;
    return localObject1;
  }
  
  private void a(int paramInt, URLDrawable paramURLDrawable, boolean paramBoolean)
  {
    if (paramURLDrawable == null) {}
    do
    {
      return;
      paramURLDrawable = paramURLDrawable.getCurrDrawable();
    } while (!VideoDrawable.class.isInstance(paramURLDrawable));
    ((VideoDrawable)paramURLDrawable).stopAudio();
    int i;
    String str;
    if (this.mStartPlayTime > 0L)
    {
      this.Ju += System.currentTimeMillis() - this.mStartPlayTime;
      paramURLDrawable = this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.getIntent();
      if (paramURLDrawable != null)
      {
        i = paramURLDrawable.getIntExtra("forward_source_uin_type", -1);
        str = paramURLDrawable.getStringExtra("uin");
        new alyr(this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.getApplication().getBaseContext()).a(axol.getAppInterface(), 2001, 0, i, str, this.Ju / 1000L);
        if (this.mSessionType != 1) {}
      }
    }
    for (;;)
    {
      try
      {
        paramURLDrawable = new JSONObject();
        paramURLDrawable.put("author_id", str);
        paramURLDrawable.put("author_type", "1");
        paramURLDrawable.put("video_type", "1");
        paramURLDrawable.put("video_time", this.mVideoDuration + "");
        paramURLDrawable.put("play_time", this.Ju);
        paramURLDrawable.put("content_type", 2);
        paramURLDrawable.put("mobile_type", Build.MODEL);
        paramURLDrawable.put("wifi_ssid", rpc.W(this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.getApplicationContext()));
        paramURLDrawable.put("wifi_mac", rpc.V(this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.getApplicationContext()));
        str = rar.getNetworkType(this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.getApplicationContext());
        if (!paramBoolean) {
          continue;
        }
        i = 2;
        rar.a("story_grp", "play_video_js", 1003, i, new String[] { paramURLDrawable.toString(), "", str, "" });
      }
      catch (Exception paramURLDrawable)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.w(" AIOGalleryAdapter", 2, "reportTroopVideo exception:" + QLog.getStackTraceString(paramURLDrawable));
        continue;
      }
      this.mStartPlayTime = -1L;
      this.Ju = -1L;
      this.mVideoDuration = -1L;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i(" AIOGalleryAdapter", 2, "AIOGalleryAdapter.stopVideoAudio(): position " + paramInt);
      return;
      i = 3;
    }
  }
  
  private void a(int paramInt, xuf paramxuf, AdapterView<?> paramAdapterView, View paramView)
  {
    this.Jv = -1L;
    if ((paramxuf != null) && (AIOImageData.class.isInstance(paramxuf.e)))
    {
      paramxuf = (AIOImageData)paramxuf.e;
      if ((paramxuf.EP == 3) && (paramxuf.c(1) == null) && (paramxuf.c(2) == null) && (paramxuf.c(4) == null) && (paramxuf.size < agmx.fL())) {}
    }
    while (!QLog.isColorLevel())
    {
      return;
      onLoadStart(paramInt, -1);
      return;
    }
    QLog.i(" AIOGalleryAdapter", 2, " onItemSelected():else Data is mVideoDrawable set null");
  }
  
  private void a(URLDrawable paramURLDrawable, GalleryImageStruct paramGalleryImageStruct, xuf paramxuf, int paramInt, File paramFile, boolean paramBoolean)
  {
    boolean bool = true;
    switch (paramURLDrawable.getStatus())
    {
    }
    for (;;)
    {
      paramGalleryImageStruct.setImageDrawable(paramURLDrawable);
      paramGalleryImageStruct.setOriginalImage(paramBoolean);
      if (!this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.bix) {}
      try
      {
        paramURLDrawable.downloadImediatly();
        return;
      }
      catch (Exception paramURLDrawable)
      {
        paramURLDrawable.printStackTrace();
      }
      if (paramxuf.orientation == -2) {}
      try
      {
        paramxuf.orientation = JpegExifReader.readOrientation(paramFile.getAbsolutePath());
        updateRotation(paramGalleryImageStruct, paramURLDrawable, paramxuf.orientation);
        if (paramURLDrawable.getStatus() == 1) {
          onLoadFinish(paramInt, bool);
        }
      }
      catch (Exception paramFile)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e(" AIOGalleryAdapter", 2, "read exif error", paramFile);
          }
          paramxuf.orientation = 1;
          continue;
          bool = false;
        }
      }
    }
  }
  
  private void a(AIOFilePicData paramAIOFilePicData, int paramInt)
  {
    Object localObject2 = paramAIOFilePicData.c(20);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = paramAIOFilePicData.c(18);
      if (localObject1 == null) {}
    }
    else
    {
      paramAIOFilePicData = URLDrawable.URLDrawableOptions.obtain();
      paramAIOFilePicData.mLoadingDrawable = aoop.TRANSPARENT;
      paramAIOFilePicData.mFailedDrawable = aoop.TRANSPARENT;
      paramAIOFilePicData.mPlayGifImage = true;
      paramAIOFilePicData.mUseExifOrientation = false;
      paramAIOFilePicData = URLDrawable.getDrawable((File)localObject1, paramAIOFilePicData);
      paramAIOFilePicData.setTag(Integer.valueOf(1));
      paramAIOFilePicData.startDownload();
      this.mActiveDrawable.put(paramInt, paramAIOFilePicData);
    }
    do
    {
      do
      {
        do
        {
          return;
          localObject1 = paramAIOFilePicData.c(16);
          if (localObject1 == null) {
            break;
          }
          localObject2 = URLDrawable.URLDrawableOptions.obtain();
          ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = aoop.TRANSPARENT;
          ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = aoop.TRANSPARENT;
          URLDrawable.getDrawable((File)localObject1, (URLDrawable.URLDrawableOptions)localObject2).startDownload();
        } while ((!aqiw.isWifiConnected(this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity)) || (paramAIOFilePicData.mFileSize > agmx.fL()));
        this.jdField_b_of_type_Xuh.downloadMedia(paramAIOFilePicData.id, paramAIOFilePicData.subId, 18);
        return;
      } while ((!aqiw.isWifiConnected(this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity)) || (paramAIOFilePicData.mFileSize > agmx.fL()));
      this.jdField_b_of_type_Xuh.downloadMedia(paramAIOFilePicData.id, paramAIOFilePicData.subId, 18);
    } while (!QLog.isDevelopLevel());
    QLog.d(" AIOGalleryAdapter", 4, "onCreateView():Thumb and large pic is not exist, download it. Gallery position is " + paramInt);
  }
  
  private void a(AIOFilePicData paramAIOFilePicData, int paramInt, GalleryImageStruct paramGalleryImageStruct, xuf paramxuf, boolean paramBoolean)
  {
    Object localObject = null;
    if (paramAIOFilePicData.bim)
    {
      paramAIOFilePicData = paramGalleryImageStruct.getDrawable();
      if (!URLDrawable.class.isInstance(paramAIOFilePicData)) {
        break label395;
      }
      localObject = (URLDrawable)paramAIOFilePicData;
      paramAIOFilePicData = ((URLDrawable)localObject).getURL().getRef();
    }
    for (;;)
    {
      if ((paramAIOFilePicData == null) && (ahbj.fileExistsAndNotEmpty(((AIOFilePicData)paramxuf.e).aVW)))
      {
        paramAIOFilePicData = URLDrawable.URLDrawableOptions.obtain();
        paramAIOFilePicData.mLoadingDrawable = aoop.TRANSPARENT;
        paramAIOFilePicData.mFailedDrawable = aoop.TRANSPARENT;
        paramAIOFilePicData = URLDrawable.getDrawable(new File(((AIOFilePicData)paramxuf.e).aVW), paramAIOFilePicData);
        if (paramAIOFilePicData != null)
        {
          paramGalleryImageStruct.setImageDrawable(paramAIOFilePicData);
          paramAIOFilePicData.downloadImediatly();
        }
      }
      do
      {
        do
        {
          do
          {
            return;
          } while ((localObject != null) && (paramAIOFilePicData != null) && (("PART".equals(paramAIOFilePicData)) || ("DISPLAY".equals(paramAIOFilePicData))));
          paramGalleryImageStruct.setImageDrawable(BaseApplicationImpl.getApplication().getResources().getDrawable(2130838158));
          onLoadFinish(paramInt, false);
          this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.a().pG();
        } while (((AIOFilePicData)paramxuf.e).mFileSize < agmx.fL());
        paramGalleryImageStruct.ceB();
        return;
        localFile = paramAIOFilePicData.c(18);
      } while (localFile == null);
      localObject = paramAIOFilePicData.cH(18);
      paramxuf = (xuf)localObject;
      if (paramBoolean) {
        paramxuf = (String)localObject + "#PART";
      }
      localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mUseExifOrientation = false;
      ((URLDrawable.URLDrawableOptions)localObject).mPlayGifImage = true;
      localObject = URLDrawable.getDrawable(localFile, (URLDrawable.URLDrawableOptions)localObject);
      if (((URLDrawable)localObject).getStatus() == 1)
      {
        paramGalleryImageStruct.setImageDrawable((Drawable)localObject);
        onLoadFinish(paramInt, true);
      }
      for (;;)
      {
        paramAIOFilePicData = aqhq.estimateFileType(paramAIOFilePicData.aVX);
        if (QLog.isColorLevel()) {
          QLog.i(" AIOGalleryAdapter", 2, "AIOGalleryAdapter.updateView(): Update large image, position=" + paramInt + "url = " + paramxuf + ",extName = " + paramAIOFilePicData);
        }
        this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.a().dLE();
        return;
        ((URLDrawable)localObject).setTag(Integer.valueOf(1));
        ((URLDrawable)localObject).startDownload();
        paramGalleryImageStruct.setDecodingDrawble((URLDrawable)localObject);
      }
      label395:
      File localFile = null;
      paramAIOFilePicData = (AIOFilePicData)localObject;
      localObject = localFile;
    }
  }
  
  private void a(AIOFileVideoData paramAIOFileVideoData, int paramInt, GalleryImageStruct paramGalleryImageStruct)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mUseExifOrientation = false;
    localURLDrawableOptions.mPlayGifImage = true;
    paramAIOFileVideoData = paramAIOFileVideoData.c(0);
    if (paramAIOFileVideoData != null)
    {
      paramAIOFileVideoData = URLDrawable.getDrawable(paramAIOFileVideoData, localURLDrawableOptions);
      if (paramAIOFileVideoData.getStatus() == 1)
      {
        paramGalleryImageStruct.setImageDrawable(paramAIOFileVideoData);
        onLoadFinish(paramInt, true);
      }
      for (;;)
      {
        this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.a().dLE();
        return;
        paramAIOFileVideoData.setTag(Integer.valueOf(1));
        paramAIOFileVideoData.startDownload();
        paramGalleryImageStruct.setDecodingDrawble(paramAIOFileVideoData);
      }
    }
    paramGalleryImageStruct.setImageDrawable(BaseApplicationImpl.getApplication().getResources().getDrawable(2130838158));
    onLoadFinish(paramInt, true);
  }
  
  private void a(GalleryImageStruct paramGalleryImageStruct, int paramInt)
  {
    if ((this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.bix) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter$GalleryImageStruct != null))
    {
      Drawable localDrawable = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter$GalleryImageStruct.getDrawable();
      paramGalleryImageStruct.setImageDrawable(localDrawable);
      if (URLDrawable.class.isInstance(localDrawable)) {
        this.mActiveDrawable.put(paramInt, (URLDrawable)localDrawable);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter$GalleryImageStruct = null;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i(" AIOGalleryAdapter", 2, "getView(): IMAGE_FILE_ERROR");
      }
      return;
      paramGalleryImageStruct.setImageDrawable(BaseApplicationImpl.getApplication().getResources().getDrawable(2130838158));
      onLoadFinish(paramInt, false);
    }
  }
  
  private void a(GalleryImageStruct paramGalleryImageStruct, int paramInt, xuf paramxuf)
  {
    this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.biA = true;
    AIOFilePicData localAIOFilePicData;
    Object localObject1;
    if (this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.biz)
    {
      this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.biz = false;
      anot.a(null, "dc00898", "", "", "0X8009EF0", "0X8009EF0", 1, 0, "", "", "", "");
      paramGalleryImageStruct.setCenterBtnVisiable(8);
      localAIOFilePicData = (AIOFilePicData)paramxuf.e;
      paramGalleryImageStruct.setPosition(paramInt);
      paramGalleryImageStruct.setImageInfo(paramxuf);
      paramGalleryImageStruct.setIgnoreLayout(false);
      localObject1 = (URLDrawable)this.mActiveDrawable.get(paramInt);
      if ((localObject1 == null) || (((URLDrawable)localObject1).getStatus() != 1)) {
        break label312;
      }
      paramGalleryImageStruct.setImageDrawable((Drawable)localObject1);
      String str = localAIOFilePicData.cH(20);
      localObject2 = ((URLDrawable)localObject1).getURL().toString();
      onLoadFinish(paramInt, true);
      if (((String)localObject2).equals(str)) {
        paramGalleryImageStruct.setOriginalImage(true);
      }
      if (paramxuf.orientation == -2) {
        paramxuf.orientation = JpegExifReader.readOrientation(((URLDrawable)localObject1).getURL().getFile());
      }
      updateRotation(paramGalleryImageStruct, (URLDrawable)localObject1, paramxuf.orientation);
      if (!paramGalleryImageStruct.isOriginalImage()) {
        break label303;
      }
    }
    label303:
    for (paramGalleryImageStruct = localAIOFilePicData.aVY;; paramGalleryImageStruct = localAIOFilePicData.aVX)
    {
      paramGalleryImageStruct = aqhq.estimateFileType(paramGalleryImageStruct);
      if (QLog.isColorLevel()) {
        QLog.i(" AIOGalleryAdapter", 2, "getView(): cache url is " + (String)localObject2 + ", cache type is " + localAIOFilePicData.bM(((URLDrawable)localObject1).getURL().getFile()) + ",extName = + " + paramGalleryImageStruct);
      }
      return;
      anot.a(null, "dc00898", "", "", "0X8009EF0", "0X8009EF0", 2, 0, "", "", "", "");
      break;
    }
    label312:
    Object localObject2 = localAIOFilePicData.c(20);
    if (localObject2 == null)
    {
      localObject1 = localAIOFilePicData.c(18);
      if (localObject1 == null) {}
    }
    for (;;)
    {
      if (localObject2 != null) {}
      for (boolean bool = true;; bool = false)
      {
        a(paramGalleryImageStruct, paramInt, paramxuf, localAIOFilePicData, bool, (File)localObject1);
        return;
      }
      localObject1 = localAIOFilePicData.c(16);
      if (localObject1 != null)
      {
        a(paramGalleryImageStruct, paramInt, paramxuf, localAIOFilePicData, (File)localObject1);
        return;
      }
      if (localAIOFilePicData.mFileSize <= agmx.fL())
      {
        if (localAIOFilePicData.bim) {
          paramGalleryImageStruct.setImageDrawable(BaseApplicationImpl.getApplication().getResources().getDrawable(2130838158));
        }
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.i(" AIOGalleryAdapter", 2, "getView(): No pic");
          }
          if (this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.bix) {
            break;
          }
          return;
          paramGalleryImageStruct.setImageDrawable(aoop.TRANSPARENT);
          this.jdField_b_of_type_Xuh.downloadMedia(localAIOFilePicData.id, localAIOFilePicData.subId, 18);
        }
      }
      if ((!this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.bix) && (!this.biE))
      {
        this.jdField_b_of_type_Xuh.loadMedias(this.loadType);
        this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.bix = true;
      }
      paramGalleryImageStruct.setImageDrawable(BaseApplicationImpl.getApplication().getResources().getDrawable(2130838158));
      paramGalleryImageStruct.ceB();
      paramGalleryImageStruct.setTag(2131296386, Float.valueOf(1.5F));
      return;
      localObject1 = localObject2;
    }
  }
  
  private void a(GalleryImageStruct paramGalleryImageStruct, int paramInt, xuf paramxuf, AIOFilePicData paramAIOFilePicData, File paramFile)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mLoadingDrawable = aoop.TRANSPARENT;
    localURLDrawableOptions.mFailedDrawable = aoop.TRANSPARENT;
    paramFile = URLDrawable.getDrawable(paramFile, localURLDrawableOptions);
    paramGalleryImageStruct.setImageDrawable(paramFile);
    if (!paramAIOFilePicData.bip) {
      if (paramAIOFilePicData.mFileSize <= agmx.fL())
      {
        paramFile.downloadImediatly();
        onLoadStart(paramInt, paramxuf.progress / 100);
        this.jdField_b_of_type_Xuh.downloadMedia(paramAIOFilePicData.id, paramAIOFilePicData.subId, 18);
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i(" AIOGalleryAdapter", 2, "getView(): url is " + paramAIOFilePicData.cH(16) + ", file type is " + 16);
      }
      if (!this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.bix) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter$GalleryImageStruct = paramGalleryImageStruct;
      }
      return;
      if ((!this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.bix) && (!this.biE))
      {
        this.jdField_b_of_type_Xuh.loadMedias(this.loadType);
        this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.bix = true;
        continue;
        if ((!this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.bix) && (!this.biE))
        {
          this.jdField_b_of_type_Xuh.loadMedias(this.loadType);
          this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.bix = true;
        }
      }
    }
  }
  
  private void a(GalleryImageStruct paramGalleryImageStruct, int paramInt, xuf paramxuf, AIOFilePicData paramAIOFilePicData, boolean paramBoolean, File paramFile)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mRequestWidth = this.mScreenWidthPx;
    localURLDrawableOptions.mRequestHeight = this.mScreenHeightPx;
    localURLDrawableOptions.mLoadingDrawable = aoop.TRANSPARENT;
    localURLDrawableOptions.mPlayGifImage = true;
    if (paramBoolean == true)
    {
      paramGalleryImageStruct.setOriginalImage(true);
      File localFile = paramAIOFilePicData.c(18);
      localObject = localFile;
      if (localFile == null) {
        localObject = paramAIOFilePicData.c(16);
      }
      if (localObject != null) {
        paramGalleryImageStruct.setImageDrawable(URLDrawable.getDrawable((File)localObject, localURLDrawableOptions));
      }
    }
    if ((this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.bix) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter$GalleryImageStruct != null))
    {
      localURLDrawableOptions.mLoadingDrawable = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter$GalleryImageStruct.getDrawable();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter$GalleryImageStruct = null;
    }
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = this.mScreenWidthPx;
    ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = this.mScreenHeightPx;
    ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = aoop.TRANSPARENT;
    ((URLDrawable.URLDrawableOptions)localObject).mPlayGifImage = true;
    ((URLDrawable.URLDrawableOptions)localObject).mUseExifOrientation = false;
    localObject = URLDrawable.getDrawable(paramFile, (URLDrawable.URLDrawableOptions)localObject);
    ((URLDrawable)localObject).setTag(Integer.valueOf(1));
    this.mActiveDrawable.put(paramInt, localObject);
    onLoadStart(paramInt, -1);
    switch (((URLDrawable)localObject).getStatus())
    {
    default: 
      paramGalleryImageStruct.setImageDrawable((Drawable)localObject);
      paramGalleryImageStruct.setOriginalImage(paramBoolean);
      if (!paramBoolean) {
        break;
      }
    }
    for (paramGalleryImageStruct = paramAIOFilePicData.aVY;; paramGalleryImageStruct = paramAIOFilePicData.aVX)
    {
      aqhq.estimateFileType(paramGalleryImageStruct);
      if ((!this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.bix) && (!this.biE))
      {
        this.jdField_b_of_type_Xuh.loadMedias(this.loadType);
        this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.bix = true;
      }
      return;
      if (paramxuf.orientation == -2) {
        paramxuf.orientation = JpegExifReader.readOrientation(paramFile.getAbsolutePath());
      }
      paramGalleryImageStruct.setImageDrawable((Drawable)localObject);
      updateRotation(paramGalleryImageStruct, (URLDrawable)localObject, paramxuf.orientation);
      if (((URLDrawable)localObject).getStatus() == 1) {
        bool1 = true;
      }
      onLoadFinish(paramInt, bool1);
      break;
      bool1 = bool2;
      if (((URLDrawable)localObject).getStatus() == 1) {
        bool1 = true;
      }
      onLoadFinish(paramInt, bool1);
      break;
    }
  }
  
  private void a(GalleryImageStruct paramGalleryImageStruct, xuf paramxuf, int paramInt, AIOImageData paramAIOImageData)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mLoadingDrawable = aoop.TRANSPARENT;
    localURLDrawableOptions.mFailedDrawable = aoop.TRANSPARENT;
    localURLDrawableOptions.mUseExifOrientation = false;
    if ((paramAIOImageData.EP == 1) && ((paramAIOImageData.bWU & 0x2) == 2)) {
      localURLDrawableOptions.mUseAutoScaleParams = false;
    }
    paramGalleryImageStruct.setImageDrawable(URLDrawable.getDrawable(paramAIOImageData.cH(8), localURLDrawableOptions));
    onLoadStart(paramInt, paramxuf.progress / 100);
    if (QLog.isColorLevel()) {
      QLog.i(" AIOGalleryAdapter", 2, "getView(): url is " + paramAIOImageData.cH(8) + ", file type is " + 8);
    }
    if (!paramAIOImageData.bim) {
      this.jdField_b_of_type_Xuh.downloadMedia(paramAIOImageData.id, paramAIOImageData.subId, 2);
    }
    for (;;)
    {
      if (!this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.bix)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter$GalleryImageStruct = paramGalleryImageStruct;
        this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.a().vk(true);
      }
      if ((QLog.isDevelopLevel()) && (paramAIOImageData.bjc)) {
        QQToast.a(paramGalleryImageStruct.getContext(), "Refresh temp display image", 2000).show();
      }
      return;
      if ((!this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.bix) && (!this.biE))
      {
        this.jdField_b_of_type_Xuh.loadMedias(this.loadType);
        this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.bix = true;
      }
    }
  }
  
  private void a(GalleryImageStruct paramGalleryImageStruct, xuf paramxuf, int paramInt, AIOImageData paramAIOImageData, File paramFile)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mLoadingDrawable = aoop.TRANSPARENT;
    localURLDrawableOptions.mFailedDrawable = aoop.TRANSPARENT;
    if ((paramAIOImageData.EP == 1) && ((paramAIOImageData.bWU & 0x2) == 2)) {
      localURLDrawableOptions.mUseAutoScaleParams = false;
    }
    paramFile = URLDrawable.getDrawable(paramFile, localURLDrawableOptions);
    paramGalleryImageStruct.setImageDrawable(paramFile);
    if (!paramAIOImageData.bjf)
    {
      paramFile.downloadImediatly();
      onLoadStart(paramInt, paramxuf.progress / 100);
      this.jdField_b_of_type_Xuh.downloadMedia(paramAIOImageData.id, paramAIOImageData.subId, 2);
      if (QLog.isColorLevel()) {
        QLog.i(" AIOGalleryAdapter", 2, "getView(): url is " + paramAIOImageData.cH(1) + ", file type is " + 1);
      }
      if (!this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.bix)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter$GalleryImageStruct = paramGalleryImageStruct;
        this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.a().vk(paramAIOImageData.bje);
      }
      return;
    }
    paramxuf = skj.a();
    paramxuf.bzj();
    paramxuf.a(this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.troopUin, paramAIOImageData, 640, new xsf(this, paramInt, paramGalleryImageStruct, paramAIOImageData));
  }
  
  private void a(GalleryImageStruct paramGalleryImageStruct, xuf paramxuf, URLDrawable paramURLDrawable, AIOImageData paramAIOImageData)
  {
    paramGalleryImageStruct.setImageDrawable(paramURLDrawable);
    String str2 = paramAIOImageData.cH(4);
    String str1 = paramURLDrawable.getURL().toString();
    if (str1.equals(str2)) {
      paramGalleryImageStruct.setOriginalImage(true);
    }
    if (paramxuf.orientation == -2) {}
    try
    {
      paramxuf.orientation = JpegExifReader.readOrientation(paramURLDrawable.getURL().getFile());
      updateRotation(paramGalleryImageStruct, paramURLDrawable, paramxuf.orientation);
      if (paramGalleryImageStruct.isOriginalImage())
      {
        paramGalleryImageStruct = paramAIOImageData.aVY;
        paramGalleryImageStruct = aqhq.estimateFileType(paramGalleryImageStruct);
        if (QLog.isColorLevel()) {
          QLog.i(" AIOGalleryAdapter", 2, "getView(): cache url is " + str1 + ", cache type is " + paramAIOImageData.bM(paramURLDrawable.getURL().getFile()) + ",extName = + " + paramGalleryImageStruct);
        }
        if (paramAIOImageData.bjc) {
          this.jdField_b_of_type_Xuh.downloadMedia(paramAIOImageData.id, paramAIOImageData.subId, 2);
        }
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e(" AIOGalleryAdapter", 2, "read exif error", localException);
        }
        paramxuf.orientation = 1;
        continue;
        paramGalleryImageStruct = paramAIOImageData.aVX;
      }
    }
  }
  
  private void a(AIOImageData paramAIOImageData)
  {
    if (this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.biz)
    {
      this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.biz = false;
      if ((paramAIOImageData.istroop == 1) && (paramAIOImageData.bjg))
      {
        anot.a(null, "dc00898", "", "", "0X8009EF0", "0X8009EF0", 1, 0, "", "", "", "");
        return;
      }
      anot.a(null, "dc00898", "", "", "0X8009EEF", "0X8009EEF", 1, 0, "", "", "", "");
      return;
    }
    if ((paramAIOImageData.istroop == 1) && (paramAIOImageData.bjg))
    {
      anot.a(null, "dc00898", "", "", "0X8009EF0", "0X8009EF0", 2, 0, "", "", "", "");
      return;
    }
    anot.a(null, "dc00898", "", "", "0X8009EEF", "0X8009EEF", 2, 0, "", "", "", "");
  }
  
  private void a(AIOImageData paramAIOImageData, int paramInt)
  {
    Object localObject2 = paramAIOImageData.c(4);
    Object localObject1;
    if (localObject2 == null)
    {
      localObject1 = paramAIOImageData.c(2);
      if (localObject1 == null) {}
    }
    for (;;)
    {
      int i;
      if (localObject2 != null)
      {
        i = 1;
        localObject2 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = aoop.TRANSPARENT;
        ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = aoop.TRANSPARENT;
        ((URLDrawable.URLDrawableOptions)localObject2).mPlayGifImage = true;
        ((URLDrawable.URLDrawableOptions)localObject2).mUseExifOrientation = false;
        if ((paramAIOImageData.EP == 1) && ((paramAIOImageData.bWU & 0x2) == 2)) {
          ((URLDrawable.URLDrawableOptions)localObject2).mUseAutoScaleParams = false;
        }
        if ((i != 0) || (!paramAIOImageData.bjc)) {
          break label162;
        }
        paramAIOImageData = URLDrawable.getDrawable(paramAIOImageData.cH(2) + "#" + "PART", (URLDrawable.URLDrawableOptions)localObject2);
        label135:
        paramAIOImageData.setTag(Integer.valueOf(1));
        paramAIOImageData.startDownload();
        this.mActiveDrawable.put(paramInt, paramAIOImageData);
      }
      label162:
      label299:
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              i = 0;
              break;
              paramAIOImageData = URLDrawable.getDrawable((File)localObject1, (URLDrawable.URLDrawableOptions)localObject2);
              break label135;
            } while ((paramAIOImageData.bin) || (paramAIOImageData.bim) || (paramAIOImageData.bio));
            if (paramAIOImageData.c(1) == null) {
              break label299;
            }
            localObject1 = URLDrawable.URLDrawableOptions.obtain();
            ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = aoop.TRANSPARENT;
            ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = aoop.TRANSPARENT;
            if ((paramAIOImageData.EP == 1) && ((paramAIOImageData.bWU & 0x2) == 2)) {
              ((URLDrawable.URLDrawableOptions)localObject1).mUseAutoScaleParams = false;
            }
            URLDrawable.getDrawable(paramAIOImageData.cH(1), (URLDrawable.URLDrawableOptions)localObject1).startDownload();
          } while ((!aqiw.isWifiConnected(this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity)) || (avfp.ns(paramAIOImageData.mImageType)));
          this.jdField_b_of_type_Xuh.downloadMedia(paramAIOImageData.id, paramAIOImageData.subId, 2);
          return;
        } while ((!aqiw.isWifiConnected(this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity)) || (avfp.ns(paramAIOImageData.mImageType)));
        this.jdField_b_of_type_Xuh.downloadMedia(paramAIOImageData.id, paramAIOImageData.subId, 2);
      } while (!QLog.isDevelopLevel());
      QLog.d(" AIOGalleryAdapter", 4, "onCreateView():Thumb and large pic is not exist, download it. Gallery position is " + paramInt);
      return;
      localObject1 = localObject2;
    }
  }
  
  private void a(AIOImageData paramAIOImageData, String paramString1, String paramString2, GalleryImageStruct paramGalleryImageStruct, int paramInt, xuf paramxuf, boolean paramBoolean)
  {
    if (paramString1 != null) {
      paramAIOImageData.aVX = paramString1;
    }
    if (paramString2 != null) {
      paramAIOImageData.aVW = paramString2;
    }
    if (paramAIOImageData.bim)
    {
      paramString1 = paramGalleryImageStruct.getDrawable();
      if (!URLDrawable.class.isInstance(paramString1)) {
        break label500;
      }
      paramString1 = (URLDrawable)paramString1;
      paramString2 = paramString1.getURL().getRef();
    }
    for (;;)
    {
      if ((paramString1 == null) || (paramString2 == null) || ((!"PART".equals(paramString2)) && (!"DISPLAY".equals(paramString2))))
      {
        paramGalleryImageStruct.setImageDrawable(BaseApplicationImpl.getApplication().getResources().getDrawable(2130838158));
        onLoadFinish(paramInt, false);
        this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.a().pG();
      }
      if (QLog.isColorLevel()) {
        QLog.i(" AIOGalleryAdapter", 2, "AIOGalleryAdapter.updateView(): IMAGE_FILE_ERROR");
      }
      if ((QLog.isDevelopLevel()) && (paramAIOImageData.bjc)) {
        QQToast.a(paramGalleryImageStruct.getContext(), "AIOGalleryAdapter.updateView(): error!", 2000).show();
      }
      return;
      paramString2 = paramAIOImageData.c(2);
      if (paramString2 != null)
      {
        paramString1 = paramAIOImageData.cH(2);
        if (!paramBoolean) {
          break label497;
        }
        paramString1 = paramString1 + "#PART";
      }
      label497:
      for (;;)
      {
        try
        {
          paramxuf.orientation = JpegExifReader.readOrientation(paramString2.getAbsolutePath());
          if (QLog.isColorLevel()) {
            QLog.i(" AIOGalleryAdapter", 2, "AIOGalleryAdapter.updateView(): read orientation:" + paramxuf.orientation);
          }
          paramString2 = URLDrawable.URLDrawableOptions.obtain();
          if (paramAIOImageData.EP == 3)
          {
            paramxuf = paramAIOImageData.c(1);
            if (paramxuf != null)
            {
              paramxuf = URLDrawable.getDrawable(paramxuf, null);
              if (paramxuf.getStatus() == 1)
              {
                paramString2.mLoadingDrawable = paramxuf;
                paramString2.mFailedDrawable = paramxuf;
              }
            }
          }
          paramString2.mUseExifOrientation = false;
          paramString2.mPlayGifImage = true;
          paramString2 = URLDrawable.getDrawable(paramString1, paramString2);
          if ((paramString2.getStatus() == 1) && (!paramAIOImageData.bjc))
          {
            paramGalleryImageStruct.setImageDrawable(paramString2);
            onLoadFinish(paramInt, true);
            paramString2 = aqhq.estimateFileType(paramAIOImageData.aVX);
            if (QLog.isColorLevel()) {
              QLog.i(" AIOGalleryAdapter", 2, "AIOGalleryAdapter.updateView(): Update large image, position=" + paramInt + "url = " + paramString1 + ",extName = " + paramString2);
            }
            paramAIOImageData.bjc = paramBoolean;
            this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.a().dLE();
            return;
          }
        }
        catch (Exception paramString2)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.e(" AIOGalleryAdapter", 2, "read exif error", paramString2);
          continue;
          paramString2.setTag(Integer.valueOf(1));
          paramString2.startDownload();
          paramGalleryImageStruct.setDecodingDrawble(paramString2);
          continue;
        }
        if (paramAIOImageData.c(1) == null) {
          break;
        }
        paramGalleryImageStruct.setImageDrawable(URLDrawable.getDrawable(paramAIOImageData.cH(1), URLDrawable.URLDrawableOptions.obtain()));
        return;
      }
      label500:
      paramString2 = null;
      paramString1 = null;
    }
  }
  
  private void a(AIOShortVideoData paramAIOShortVideoData, int paramInt)
  {
    File localFile = paramAIOShortVideoData.c(0);
    if (localFile != null)
    {
      paramAIOShortVideoData = URLDrawable.URLDrawableOptions.obtain();
      paramAIOShortVideoData.mLoadingDrawable = aoop.TRANSPARENT;
      paramAIOShortVideoData.mFailedDrawable = aoop.TRANSPARENT;
      paramAIOShortVideoData = URLDrawable.getDrawable(localFile, paramAIOShortVideoData);
      paramAIOShortVideoData.startDownload();
      this.by.put(paramInt, paramAIOShortVideoData);
      if (QLog.isColorLevel()) {
        QLog.i(" AIOGalleryAdapter", 2, "AIOGalleryAdapter.onCreateView(): preload thumb, position=" + paramInt);
      }
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            if (!paramAIOShortVideoData.bjB) {
              break;
            }
          } while (!QLog.isColorLevel());
          QLog.i(" AIOGalleryAdapter", 2, "AIOGalleryAdapter.onCreateView(): Video error, position=" + paramInt);
          return;
          if (paramAIOShortVideoData.c(1) == null) {
            break;
          }
          if (paramAIOShortVideoData.mBusiType != 0) {
            this.jdField_b_of_type_Xuh.downloadMedia(paramAIOShortVideoData.id, paramAIOShortVideoData.subId, 0);
          }
        } while (!QLog.isColorLevel());
        QLog.i(" AIOGalleryAdapter", 2, "AIOGalleryAdapter.onCreateView(): Video exist and download thumb, position=" + paramInt);
        return;
      } while (paramAIOShortVideoData.mBusiType == 0);
      this.jdField_b_of_type_Xuh.downloadMedia(paramAIOShortVideoData.id, paramAIOShortVideoData.subId, 1);
    } while (!QLog.isDevelopLevel());
    QLog.d(" AIOGalleryAdapter", 4, "onCreateView():Thumb and video is not exist, download video only. Gallery position is " + paramInt);
  }
  
  private void a(AIOShortVideoData paramAIOShortVideoData, int paramInt, GalleryImageStruct paramGalleryImageStruct)
  {
    if (paramAIOShortVideoData.mBusiType != 0)
    {
      if (!paramAIOShortVideoData.bjB) {
        break label70;
      }
      paramGalleryImageStruct.setImageDrawable(BaseApplicationImpl.getApplication().getResources().getDrawable(2130838158));
      onLoadFinish(paramInt, false);
      if (QLog.isColorLevel()) {
        QLog.i(" AIOGalleryAdapter", 2, "AIOGalleryAdapter.updateView(): IMAGE_FILE_ERROR, position=" + paramInt);
      }
    }
    label70:
    do
    {
      return;
      File localFile = paramAIOShortVideoData.c(1);
      if (localFile != null)
      {
        paramAIOShortVideoData = URLDrawable.URLDrawableOptions.obtain();
        paramAIOShortVideoData.mLoadingDrawable = aoop.TRANSLUCENT;
        paramAIOShortVideoData.mUseMemoryCache = false;
        VideoDrawable.VideoDrawableParams localVideoDrawableParams = new VideoDrawable.VideoDrawableParams();
        localVideoDrawableParams.mPlayVideoFrame = true;
        localVideoDrawableParams.mEnableAntiAlias = true;
        localVideoDrawableParams.mEnableFilter = true;
        paramAIOShortVideoData.mExtraInfo = localVideoDrawableParams;
        paramAIOShortVideoData = URLDrawable.getDrawable(localFile, paramAIOShortVideoData);
        if (paramAIOShortVideoData.getStatus() == 1) {
          paramGalleryImageStruct.setImageDrawable(paramAIOShortVideoData);
        }
        for (;;)
        {
          onLoadFinish(paramInt, true);
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.i(" AIOGalleryAdapter", 2, "AIOGalleryAdapter.updateView(): Update video, position=" + paramInt);
          return;
          paramGalleryImageStruct.setDecodingDrawble(paramAIOShortVideoData);
          paramAIOShortVideoData.startDownload();
        }
      }
    } while ((paramAIOShortVideoData.c(0) == null) || (!QLog.isColorLevel()));
    QLog.i(" AIOGalleryAdapter", 2, "AIOGalleryAdapter.updateView(): thumb downloaded, position=" + paramInt);
  }
  
  private void a(xuf paramxuf, View paramView)
  {
    this.aXh = 1;
    if (QLog.isColorLevel())
    {
      if (paramxuf != null) {
        QLog.i(" AIOGalleryAdapter", 1, "FileVideo_AP unsupport type :" + paramxuf.getClass().getSimpleName());
      }
    }
    else {
      return;
    }
    QLog.i(" AIOGalleryAdapter", 1, "FileVideo_AP unsupport type, image null!");
  }
  
  private void a(boolean paramBoolean1, xuf paramxuf, AIOImageData paramAIOImageData, boolean paramBoolean2, String paramString)
  {
    if (paramBoolean1)
    {
      int i = paramxuf.hashCode();
      this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.bWG = i;
      paramxuf = this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.a();
      paramxuf.Uc(i);
      paramxuf.j(i, paramAIOImageData.width, paramAIOImageData.height);
      paramxuf.bP(i, avfp.ns(paramAIOImageData.mImageType));
      if (paramAIOImageData.bjd) {
        paramxuf.Ue(i);
      }
      if (paramString != null)
      {
        paramxuf.dE(i, paramString);
        paramxuf.bO(i, paramBoolean2);
      }
    }
  }
  
  private void b(GalleryImageStruct paramGalleryImageStruct, xuf paramxuf, int paramInt, AIOImageData paramAIOImageData)
  {
    if (!paramAIOImageData.bjf)
    {
      onLoadStart(paramInt, paramxuf.progress / 100);
      paramGalleryImageStruct.setImageDrawable(aoop.TRANSPARENT);
      this.jdField_b_of_type_Xuh.downloadMedia(paramAIOImageData.id, paramAIOImageData.subId, 2);
      if (QLog.isColorLevel()) {
        QLog.i(" AIOGalleryAdapter", 2, "getView(): No pic");
      }
    }
    for (;;)
    {
      if (!this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.bix) {
        this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.a().vk(paramAIOImageData.bje);
      }
      return;
      if (paramAIOImageData.size <= agmx.fL())
      {
        onLoadStart(paramInt, paramxuf.progress / 100);
        paramGalleryImageStruct.setImageDrawable(aoop.TRANSPARENT);
        paramxuf = skj.a();
        paramxuf.bzj();
        paramxuf.a(this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.troopUin, paramAIOImageData, 383, new xsg(this));
        onLoadStart(paramInt, 0);
        paramxuf.a(this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.troopUin, paramAIOImageData, 640, new xsh(this, paramInt, paramGalleryImageStruct, paramAIOImageData));
      }
      else
      {
        if ((!this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.bix) && (!this.biE)) {
          this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.bix = true;
        }
        paramGalleryImageStruct.setImageDrawable(BaseApplicationImpl.getApplication().getResources().getDrawable(2130838158));
        paramGalleryImageStruct.ceB();
        paramGalleryImageStruct.setTag(2131296386, Float.valueOf(1.5F));
      }
    }
  }
  
  public static Drawable getCoverDrawable(String paramString, int paramInt1, int paramInt2)
  {
    afei localafei = new afei(Color.rgb(214, 214, 214), paramInt1, paramInt2);
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        URLDrawable localURLDrawable = URLDrawable.getDrawable(paramString, localafei, localafei);
        if (localURLDrawable.getStatus() != 1) {
          localURLDrawable.downloadImediatly();
        }
        return localURLDrawable;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.e(" AIOGalleryAdapter", 2, "getCoverDrawable():  getDrawable Exception, coverUrl=" + paramString, localException);
        }
      }
    }
    return localafei;
  }
  
  private String listActiviteDrawables()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Actives: ");
    int i = 0;
    while (i < this.mActiveDrawable.size())
    {
      if (i > 0) {
        localStringBuilder.append(" , ");
      }
      localStringBuilder.append(this.mActiveDrawable.keyAt(i) + 1);
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  private void loadShortVideoCover(String paramString, int paramInt1, int paramInt2, ImageView paramImageView, int paramInt3)
  {
    if (aqhq.fileExistsAndNotEmpty(paramString))
    {
      paramString = ShortVideoUtils.j(paramString);
      if (paramString != null)
      {
        paramString = getCoverDrawable(paramString.toString(), paramInt1, paramInt2);
        if ((paramString instanceof URLDrawable)) {
          this.by.put(paramInt3, (URLDrawable)paramString);
        }
        paramImageView.setImageDrawable(paramString);
      }
    }
    else
    {
      return;
    }
    QLog.d(" AIOGalleryAdapter", 2, "url  is null ");
  }
  
  public xuf a(int paramInt)
  {
    if (this.jdField_a_of_type_Xto == null) {
      return null;
    }
    return this.jdField_a_of_type_Xto.a(paramInt);
  }
  
  public ztn a(AIOShortVideoData paramAIOShortVideoData)
  {
    Object localObject = new File(paramAIOShortVideoData.aWp);
    long l = 0L;
    boolean bool;
    if (((File)localObject).exists())
    {
      l = ((File)localObject).length();
      if (l >= paramAIOShortVideoData.size) {
        break label355;
      }
      bool = true;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d(" AIOGalleryAdapter", 2, "carverW getVideoPlayMedioInfo longvideo GetUrlAction =" + bool);
      }
      if (bool)
      {
        xuk.b localb = xuk.a().a(paramAIOShortVideoData.id);
        if ((localb == null) || (!localb.isValid())) {
          break label349;
        }
        if (QLog.isColorLevel()) {
          QLog.d(" AIOGalleryAdapter", 2, "carverW getVideoPlayMedioInfo  hit cache");
        }
        localObject = new ztn();
        ((ztn)localObject).btf = true;
        ((ztn)localObject).cJ = localb.mUrls;
        ((ztn)localObject).l = localb.l;
        ((ztn)localObject).fileType = localb.fileType;
        ((ztn)localObject).id = paramAIOShortVideoData.id;
        ((ztn)localObject).subid = paramAIOShortVideoData.subId;
      }
      for (;;)
      {
        if ((localObject != null) && (this.biD) && (this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData != null) && (this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.id == paramAIOShortVideoData.id))
        {
          ((ztn)localObject).isMute = true;
          if (QLog.isColorLevel()) {
            QLog.d(" AIOGalleryAdapter", 2, new Object[] { "set playMedioInfo.isMute = ", Boolean.valueOf(this.biD), " data.id = ", Long.valueOf(paramAIOShortVideoData.id) });
          }
        }
        return localObject;
        if (QLog.isColorLevel()) {
          QLog.d(" AIOGalleryAdapter", 2, "initData, #PLAY_CALLER_SHORT_VIDEO#, not exist");
        }
        bool = true;
        break;
        localObject = new ztn();
        ((ztn)localObject).btf = false;
        ((ztn)localObject).id = paramAIOShortVideoData.id;
        ((ztn)localObject).subid = paramAIOShortVideoData.subId;
        ((ztn)localObject).playUrl = paramAIOShortVideoData.aWp;
        ((ztn)localObject).ap = l;
        continue;
        label349:
        localObject = null;
      }
      label355:
      bool = false;
    }
  }
  
  public void a(int paramInt, GalleryImageStruct paramGalleryImageStruct)
  {
    paramGalleryImageStruct = paramGalleryImageStruct.getDrawable();
    if (URLDrawable.class.isInstance(paramGalleryImageStruct)) {
      a(paramInt, (URLDrawable)paramGalleryImageStruct, true);
    }
  }
  
  public void a(b paramb)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter$b = paramb;
  }
  
  public void a(AIORichMediaData paramAIORichMediaData)
  {
    this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData = paramAIORichMediaData;
    this.Jv = paramAIORichMediaData.id;
    this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.Jt = paramAIORichMediaData.id;
  }
  
  public void a(sxm paramsxm)
  {
    super.a(paramsxm);
    this.jdField_a_of_type_Xto = ((xto)paramsxm);
    clearTheOuchCache();
  }
  
  public void a(ztj paramztj)
  {
    this.jdField_a_of_type_Ztj = paramztj;
  }
  
  public void b(int paramInt, View paramView, boolean paramBoolean)
  {
    Object localObject1;
    if ((paramView instanceof AbstractImageAdapter.URLImageView2))
    {
      paramView = (AbstractImageAdapter.URLImageView2)paramView;
      localObject1 = a(paramInt);
      if (localObject1 != null) {
        break label25;
      }
    }
    label25:
    do
    {
      do
      {
        return;
        if (!AIOImageData.class.isInstance(((xuf)localObject1).e)) {
          break;
        }
        localObject2 = (AIOImageData)((xuf)localObject1).e;
      } while ((!paramBoolean) || (((AIOImageData)localObject2).c(8) == null));
      localObject1 = paramView.getDrawable();
      Object localObject2 = ((AIOImageData)localObject2).cH(8);
      localObject2 = (String)localObject2 + "#" + "DISPLAY";
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mLoadingDrawable = ((Drawable)localObject1);
      localURLDrawableOptions.mFailedDrawable = ((Drawable)localObject1);
      localURLDrawableOptions.mPlayGifImage = true;
      localURLDrawableOptions.mUseExifOrientation = false;
      localObject1 = URLDrawable.getDrawable((String)localObject2, localURLDrawableOptions);
      paramView.setDecodingDrawble((URLDrawable)localObject1);
      ((URLDrawable)localObject1).startDownload();
      if (QLog.isColorLevel()) {
        QLog.i(" AIOGalleryAdapter", 2, "AIOGalleryAdapter.updateDisplayView(): Update dp image, position=" + paramInt);
      }
      this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.a().dLD();
      return;
    } while (!AIOShortVideoData.class.isInstance(((xuf)localObject1).e));
  }
  
  public boolean bx(long paramLong)
  {
    if (this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.Jt == paramLong)
    {
      if (QLog.isColorLevel()) {
        QLog.d(" AIOGalleryAdapter", 2, "carverW isNeedAutoPlay true");
      }
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d(" AIOGalleryAdapter", 2, "carverW isNeedAutoPlay false");
    }
    return false;
  }
  
  public void clearTheOuchCache()
  {
    this.mActiveDrawable.clear();
    this.by.clear();
    if ((this.mRawDrawable != null) && (this.mRawDrawable.getStatus() == 0)) {
      this.mRawDrawable.cancelDownload(true);
    }
    this.mRawDrawable = null;
    this.mRawDrawablePosition = -1;
  }
  
  public void destory()
  {
    if (QLog.isColorLevel()) {
      QLog.d(" AIOGalleryAdapter", 2, "destory");
    }
    aqfv.a().clear();
    clearTheOuchCache();
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject;
    if (paramView != null)
    {
      localObject = paramView;
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return localObject;
    }
    GalleryImageStruct localGalleryImageStruct = new GalleryImageStruct(this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity, 0);
    localGalleryImageStruct.setAdjustViewBounds(true);
    xuf localxuf = a(paramInt);
    if ((localxuf == null) || (localxuf.e == null)) {
      QLog.e(" AIOGalleryAdapter", 2, " getView(): position=" + paramInt + " data is null");
    }
    for (;;)
    {
      if ((localxuf != null) && (localxuf.e != null)) {
        break label219;
      }
      localObject = localGalleryImageStruct;
      break;
      if (QLog.isColorLevel()) {
        QLog.i(" AIOGalleryAdapter", 2, " getView(): position=" + paramInt + " uid=" + localxuf.e.id + " isShortVideoAutoPlay=" + this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.biz + " mDataLoaded=" + this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.bix + " entryid=" + this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.Jt);
      }
    }
    label219:
    AIOImageData localAIOImageData;
    boolean bool2;
    boolean bool1;
    label364:
    File localFile;
    if (AIOImageData.class.isInstance(localxuf.e))
    {
      localObject = (AIOImageData)localxuf.e;
      this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.biA = true;
      a((AIOImageData)localObject);
      localGalleryImageStruct.setCenterBtnVisiable(8);
      localAIOImageData = (AIOImageData)localxuf.e;
      localGalleryImageStruct.setPosition(paramInt);
      localGalleryImageStruct.setImageInfo(localxuf);
      localGalleryImageStruct.setIgnoreLayout(false);
      localGalleryImageStruct.yb(localAIOImageData.aWi);
      bool2 = false;
      localObject = (URLDrawable)this.mActiveDrawable.get(paramInt);
      if ((localObject != null) && (((URLDrawable)localObject).getStatus() == 1))
      {
        a(localGalleryImageStruct, localxuf, (URLDrawable)localObject, localAIOImageData);
        bool2 = true;
        if (localGalleryImageStruct.isOriginalImage()) {}
        for (localObject = "original";; localObject = "large")
        {
          bool1 = true;
          a(bool2, localxuf, localAIOImageData, bool1, (String)localObject);
          localObject = localAIOImageData.id + "_" + localAIOImageData.subId;
          if (!this.qJ.contains(localObject))
          {
            this.jdField_b_of_type_Xuh.payFlow(localAIOImageData.id, localAIOImageData.subId);
            this.qJ.add(localObject);
          }
          label453:
          localObject = localGalleryImageStruct;
          break;
        }
      }
      localFile = localAIOImageData.c(4);
      if (localFile != null) {
        break label776;
      }
      localObject = localAIOImageData.c(2);
      if (localObject == null) {}
    }
    for (;;)
    {
      if (localFile != null)
      {
        bool2 = true;
        label502:
        localObject = a(localGalleryImageStruct, localxuf, localAIOImageData, bool2, paramInt, (File)localObject);
        if (!((URLDrawable)localObject).isDownloadStarted()) {
          break label767;
        }
        if (BaseApplicationImpl.sImageCache.get(((URLDrawable)localObject).getURL().toString()) == null) {
          break label569;
        }
        bool1 = true;
        label547:
        if (!bool2) {
          break label575;
        }
        localObject = "original";
      }
      for (;;)
      {
        bool2 = true;
        break label364;
        bool2 = false;
        break label502;
        label569:
        bool1 = false;
        break label547;
        label575:
        localObject = "large";
        continue;
        if (localAIOImageData.c(8) != null)
        {
          a(localGalleryImageStruct, localxuf, paramInt, localAIOImageData);
          bool2 = true;
          localObject = null;
          bool1 = false;
          break label364;
        }
        if ((localAIOImageData.bin) || (localAIOImageData.bim) || (localAIOImageData.bio))
        {
          a(localGalleryImageStruct, paramInt);
          localObject = null;
          bool1 = false;
          break label364;
        }
        localObject = localAIOImageData.c(1);
        if (localObject != null)
        {
          a(localGalleryImageStruct, localxuf, paramInt, localAIOImageData, (File)localObject);
          bool2 = true;
          localObject = null;
          bool1 = false;
          break label364;
        }
        b(localGalleryImageStruct, localxuf, paramInt, localAIOImageData);
        localObject = null;
        bool1 = false;
        break label364;
        if (AIOFilePicData.class.isInstance(localxuf.e))
        {
          a(localGalleryImageStruct, paramInt, localxuf);
          break label453;
        }
        if (!AIOFileVideoData.class.isInstance(localxuf.e)) {
          break label453;
        }
        localObject = a(localxuf, paramInt, localGalleryImageStruct);
        break;
        label767:
        localObject = null;
        bool1 = false;
      }
      label776:
      localObject = localFile;
    }
  }
  
  public void notifyDataSetChanged(boolean paramBoolean)
  {
    super.notifyDataSetChanged();
    if (QLog.isColorLevel()) {
      QLog.d(" AIOGalleryAdapter", 2, "notifyDataSetChanged(): Data changed");
    }
    clearTheOuchCache();
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    int i = this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.getResources().getDisplayMetrics().widthPixels;
    int j = this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.getResources().getDisplayMetrics().heightPixels;
    if ((i != this.mScreenWidthPx) || (j != this.mScreenHeightPx))
    {
      this.mScreenWidthPx = i;
      this.mScreenHeightPx = j;
      URLDrawable.clearMemoryCache();
      clearTheOuchCache();
    }
  }
  
  public View onCreateView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramView = (URLDrawable)this.mActiveDrawable.get(paramInt);
    if (paramView != null) {
      if (paramView.getStatus() == 3) {
        paramView.restartDownload();
      }
    }
    do
    {
      do
      {
        return null;
        paramView = a(paramInt);
      } while (paramView == null);
      if (AIOImageData.class.isInstance(paramView.e))
      {
        a((AIOImageData)paramView.e, paramInt);
        return null;
      }
      if (AIOShortVideoData.class.isInstance(paramView.e))
      {
        a((AIOShortVideoData)paramView.e, paramInt);
        return null;
      }
      if (AIOFilePicData.class.isInstance(paramView.e))
      {
        a((AIOFilePicData)paramView.e, paramInt);
        return null;
      }
    } while (!QLog.isColorLevel());
    QLog.i(" AIOGalleryAdapter", 2, "AIOGalleryAdapter.onCreateView(): nani...");
    return null;
  }
  
  public void onDestroyView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramView = (URLDrawable)this.mActiveDrawable.get(paramInt);
    if (paramView != null)
    {
      if (paramView.getStatus() == 0) {
        paramView.cancelDownload(true);
      }
      this.mActiveDrawable.remove(paramInt);
    }
    this.by.remove(paramInt);
    if (paramInt == this.mRawDrawablePosition)
    {
      if ((this.mRawDrawable != null) && (this.mRawDrawable.getStatus() == 0)) {
        this.mRawDrawable.cancelDownload(true);
      }
      this.mRawDrawable = null;
      this.mRawDrawablePosition = -1;
    }
    if (QLog.isColorLevel()) {
      QLog.d(" AIOGalleryAdapter", 2, listActiviteDrawables());
    }
  }
  
  public void onItemSelected(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    xuf localxuf = a(paramInt);
    if (QLog.isColorLevel())
    {
      QLog.d(" AIOGalleryAdapter", 2, "onItemSelected isShortVideoAutoPlay=" + this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.biz + " hasDoneItemSelectUid=" + this.Jv + " mContext.entryId=" + this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.Jt);
      QLog.i(" AIOGalleryAdapter", 1, "FileVideo_AP call onItemSelected ");
    }
    if ((localxuf != null) && (localxuf.e != null) && (localxuf.e.id != this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.Jt))
    {
      QLog.d(" AIOGalleryAdapter", 2, "onItemSelected not first image.mData.id=" + localxuf.e.id + " entryId=" + this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.Jt);
      this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.Jt = -1L;
    }
    if ((this.biD) && (this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData != null) && (localxuf != null) && (localxuf.e != null) && (this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.id != localxuf.e.id))
    {
      this.biD = false;
      xsk localxsk = (xsk)this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.a.a();
      if (localxsk != null) {
        localxsk.mIsMute = false;
      }
      if (QLog.isColorLevel()) {
        QLog.d(" AIOGalleryAdapter", 2, "onItemSelected, set mIsmute false,  mDataOfBubble.id = " + this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.id + ", image.mData.id + " + localxuf.e.id);
      }
    }
    if ((localxuf != null) && ((AIOShortVideoData.class.isInstance(localxuf.e)) || (AIOFileVideoData.class.isInstance(localxuf.e))))
    {
      ((AudioManager)this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.getSystemService("audio")).requestAudioFocus(null, 3, 2);
      if ((paramView == null) || (!GalleryImageStruct.class.isInstance(paramView))) {
        break label406;
      }
      a(paramInt, localxuf, paramAdapterView, paramView);
    }
    label406:
    while ((paramView == null) || (!(paramView instanceof RelativeLayout)))
    {
      return;
      ((AudioManager)this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.getSystemService("audio")).abandonAudioFocus(null);
      break;
    }
    a(localxuf, paramView);
  }
  
  public void onLoadProgressUpdate(int paramInt1, int paramInt2)
  {
    Object localObject = a(paramInt1);
    if (localObject == null) {}
    AIOFileVideoData localAIOFileVideoData;
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            if (!AIOImageData.class.isInstance(((xuf)localObject).e)) {
              break;
            }
          } while (((AIOImageData)((xuf)localObject).e).bjc);
          super.onLoadProgressUpdate(paramInt1, paramInt2);
          return;
        } while (AIOShortVideoData.class.isInstance(((xuf)localObject).e));
        if (AIOFilePicData.class.isInstance(((xuf)localObject).e))
        {
          super.onLoadProgressUpdate(paramInt1, paramInt2);
          return;
        }
      } while (!AIOFileVideoData.class.isInstance(((xuf)localObject).e));
      localAIOFileVideoData = (AIOFileVideoData)((xuf)localObject).e;
    } while (!localAIOFileVideoData.biu);
    localAIOFileVideoData.progress = paramInt2;
    xsk localxsk = (xsk)this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.a.a();
    float f = (float)(paramInt2 * 100) / 10000.0F;
    if (localAIOFileVideoData.biu) {}
    for (localObject = acfp.m(2131702232) + ahbj.g(((float)localAIOFileVideoData.size * f)) + "/" + ahbj.g(localAIOFileVideoData.size) + ")";; localObject = acfp.m(2131702190) + ahbj.g(((float)localAIOFileVideoData.size * f)) + "/" + ahbj.g(localAIOFileVideoData.size) + ")")
    {
      localxsk.a(localAIOFileVideoData.id, f, (String)localObject);
      return;
    }
  }
  
  public void onLoadProgressUpdate(View paramView, int paramInt) {}
  
  public void onScrollHalfScreenWidth()
  {
    if (this.aXh == 0) {
      if (this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter$GalleryImageStruct != null) {
        this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter$GalleryImageStruct.pause();
      }
    }
    while ((this.aXh != 1) || (this.jdField_a_of_type_Ztj == null) || (!this.jdField_a_of_type_Ztj.VL())) {
      return;
    }
    this.jdField_a_of_type_Ztj.pause();
  }
  
  public void onShowAreaChanged(int paramInt, View paramView, RegionDrawableData paramRegionDrawableData)
  {
    if (!GalleryImageStruct.class.isInstance(paramView)) {}
    do
    {
      return;
      paramView = ((GalleryImageStruct)paramView).getDrawable();
    } while (!URLDrawable.class.isInstance(paramView));
    ((URLDrawable)paramView).updateRegionBitmap(paramRegionDrawableData);
  }
  
  public void onSlot(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (QLog.isColorLevel()) {
      QLog.i(" AIOGalleryAdapter", 2, "AIOGalleryAdapter.onSlot(): position is " + paramInt);
    }
    System.gc();
  }
  
  public void onViewDetached(int paramInt, View paramView, ViewGroup paramViewGroup, boolean paramBoolean)
  {
    if (paramInt == this.mRawDrawablePosition)
    {
      if ((this.mRawDrawable != null) && (this.mRawDrawable.getStatus() == 0)) {
        this.mRawDrawable.cancelDownload(true);
      }
      this.mRawDrawable = null;
      this.mRawDrawablePosition = -1;
      if (QLog.isColorLevel()) {
        QLog.d(" AIOGalleryAdapter", 2, "destory rawDrawable, position: " + paramInt);
      }
    }
    xuf localxuf;
    if (GalleryImageStruct.class.isInstance(paramView))
    {
      paramViewGroup = (GalleryImageStruct)paramView;
      localxuf = a(paramInt);
      if (localxuf != null) {
        break label103;
      }
    }
    label103:
    do
    {
      do
      {
        AIORichMediaData localAIORichMediaData;
        do
        {
          return;
          localAIORichMediaData = localxuf.e;
          if (AIOImageData.class.isInstance(localAIORichMediaData))
          {
            if (URLDrawable.class.isInstance(((GalleryImageStruct)paramView).getDrawable())) {
              this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.a().exit(localxuf.hashCode());
            }
            this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.a().exit();
            return;
          }
        } while (!AIOShortVideoData.class.isInstance(localAIORichMediaData));
        paramView = (URLDrawable)this.mActiveDrawable.get(paramInt);
        if (paramView == null) {
          break;
        }
        paramViewGroup.setImageDrawable(paramView);
      } while (!QLog.isColorLevel());
      QLog.i(" AIOGalleryAdapter", 2, "AIOGalleryAdapter.onViewDetached(): Use thumb cache replace video.");
      return;
      paramViewGroup.setImageDrawable(aoop.TRANSPARENT);
    } while (!QLog.isColorLevel());
    QLog.i(" AIOGalleryAdapter", 2, "AIOGalleryAdapter.onViewDetached(): No thumb, use TRANSPARENT");
  }
  
  public void onscaleBegin(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    GalleryImageStruct localGalleryImageStruct = (GalleryImageStruct)paramView;
    paramView = localGalleryImageStruct.getDrawable();
    paramViewGroup = localGalleryImageStruct.b();
    if (((paramView instanceof URLDrawable)) && (((URLDrawable)paramView).isFakeSize()) && (paramViewGroup == null))
    {
      paramView = ((URLDrawable)paramView).getURL();
      if (("file".equals(paramView.getProtocol())) && (paramView.getRef() == null))
      {
        if ((paramInt != this.mRawDrawablePosition) || (this.mRawDrawable == null)) {
          break label153;
        }
        paramViewGroup = this.mRawDrawable;
        paramView = paramViewGroup;
        if (QLog.isColorLevel())
        {
          paramView = paramViewGroup;
          if (this.mRawDrawable != null)
          {
            QLog.d(" AIOGalleryAdapter", 2, "use exist raw drawable");
            paramView = paramViewGroup;
          }
        }
        if (paramView.getStatus() != 1) {
          break label284;
        }
        localGalleryImageStruct.setIgnoreLayout(true);
        localGalleryImageStruct.setImageDrawable(paramView);
        localGalleryImageStruct.setIgnoreLayout(false);
      }
    }
    label153:
    label284:
    while (!(paramView instanceof SkinnableBitmapDrawable)) {
      for (;;)
      {
        paramView = a(paramInt);
        if (paramView != null) {
          break;
        }
        return;
        if ((QLog.isColorLevel()) && (this.mRawDrawable != null)) {
          QLog.d(" AIOGalleryAdapter", 2, "rawDrawable is exist");
        }
        paramView = paramView.toString() + "#" + "NOSAMPLE";
        paramViewGroup = URLDrawable.URLDrawableOptions.obtain();
        paramViewGroup.mUseExifOrientation = false;
        paramViewGroup.mUseMemoryCache = false;
        paramViewGroup = URLDrawable.getDrawable(paramView, paramViewGroup);
        paramViewGroup.setTag(Integer.valueOf(2));
        this.mRawDrawable = paramViewGroup;
        this.mRawDrawablePosition = paramInt;
        paramView = paramViewGroup;
        if (QLog.isColorLevel())
        {
          QLog.d(" AIOGalleryAdapter", 2, "create rawDrawable, position:" + paramInt);
          paramView = paramViewGroup;
          continue;
          localGalleryImageStruct.setDecodingDrawble(paramView);
          paramView.startDownload();
        }
      }
    }
    return;
    this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.a().Ud(paramView.hashCode());
  }
  
  public void updateCache(URLDrawable paramURLDrawable, int paramInt)
  {
    if (this.mActiveDrawable.get(paramInt) != null) {
      this.mActiveDrawable.put(paramInt, paramURLDrawable);
    }
  }
  
  public void updateView(int paramInt, View paramView, boolean paramBoolean)
  {
    updateView(paramInt, null, null, paramView, paramBoolean);
  }
  
  public void updateView(int paramInt, String paramString1, String paramString2, View paramView, boolean paramBoolean)
  {
    xuf localxuf = a(paramInt);
    if (localxuf == null) {}
    do
    {
      do
      {
        for (;;)
        {
          return;
          if (!(paramView instanceof GalleryImageStruct)) {
            break;
          }
          paramView = (GalleryImageStruct)paramView;
          if (AIOImageData.class.isInstance(localxuf.e)) {
            a((AIOImageData)localxuf.e, paramString1, paramString2, paramView, paramInt, localxuf, paramBoolean);
          }
          while (!this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.bix)
          {
            this.jdField_b_of_type_Xuh.loadMedias(this.loadType);
            this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.bix = true;
            return;
            if (AIOShortVideoData.class.isInstance(localxuf.e)) {
              a((AIOShortVideoData)localxuf.e, paramInt, paramView);
            } else if (AIOFilePicData.class.isInstance(localxuf.e)) {
              a((AIOFilePicData)localxuf.e, paramInt, paramView, localxuf, paramBoolean);
            } else if (AIOFileVideoData.class.isInstance(localxuf.e)) {
              a((AIOFileVideoData)localxuf.e, paramInt, paramView);
            }
          }
        }
      } while ((!(paramView instanceof RelativeLayout)) || (!AIOShortVideoData.class.isInstance(localxuf.e)));
      paramString1 = (AIOShortVideoData)localxuf.e;
    } while (paramString1.mBusiType != 0);
    if (QLog.isColorLevel()) {
      QLog.d(" AIOGalleryAdapter", 2, " updateView loadShortVideoCover");
    }
    paramString2 = (URLImageView)paramView.findViewById(2131373580);
    loadShortVideoCover(paramString1.aWo, paramString1.width, paramString1.height, paramString2, paramInt);
  }
  
  public class GalleryImageStruct
    extends RelativeLayout
  {
    private TextView Ki;
    private TextView Kj;
    public GalleryUrlImageView a;
    private LinearLayout.LayoutParams e;
    public ImageView tM;
    
    public GalleryImageStruct(Context paramContext, int paramInt)
    {
      super();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter$GalleryImageStruct$GalleryUrlImageView = new GalleryUrlImageView(paramContext);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter$GalleryImageStruct$GalleryUrlImageView.setId(2131368820);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter$GalleryImageStruct$GalleryUrlImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
      RelativeLayout.LayoutParams localLayoutParams = null;
      if (paramInt == 0) {
        localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
      }
      for (;;)
      {
        localLayoutParams.addRule(13, -1);
        addView(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter$GalleryImageStruct$GalleryUrlImageView, localLayoutParams);
        this.tM = new ImageView(paramContext);
        this.tM.setId(2131373579);
        this.tM.setImageResource(2130838134);
        localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
        localLayoutParams.addRule(13, -1);
        addView(this.tM, localLayoutParams);
        this.Ki = new TextView(paramContext);
        this.Ki.setText(2131697152);
        this.Ki.setClickable(false);
        this.Ki.setTextSize(aqcx.px2dip(AIOGalleryAdapter.this.b, 30.4F));
        this.Ki.setTextColor(Color.parseColor("#a6a6a6"));
        this.Ki.setVisibility(8);
        paramContext = new RelativeLayout.LayoutParams(-2, -2);
        paramContext.addRule(12);
        paramContext.addRule(14, -1);
        paramContext.bottomMargin = aqcx.px2dip(AIOGalleryAdapter.this.b, 40.0F);
        addView(this.Ki, paramContext);
        if (paramInt == 1) {
          setTag(2131296433, Boolean.valueOf(true));
        }
        if (getLayoutParams() == null) {
          setLayoutParams(new Gallery.LayoutParams(-1, -1));
        }
        return;
        if (paramInt == 1) {
          localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
        }
      }
    }
    
    public boolean T(MotionEvent paramMotionEvent)
    {
      boolean bool2 = false;
      boolean bool1 = bool2;
      if (this.tM != null)
      {
        bool1 = bool2;
        if (this.tM.getVisibility() == 0)
        {
          Rect localRect = new Rect();
          this.tM.getGlobalVisibleRect(localRect);
          bool1 = bool2;
          if (localRect.contains((int)paramMotionEvent.getRawX(), (int)paramMotionEvent.getRawY())) {
            bool1 = true;
          }
        }
      }
      return bool1;
    }
    
    public xuf a()
    {
      return this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter$GalleryImageStruct$GalleryUrlImageView.b;
    }
    
    public URLDrawable b()
    {
      return this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter$GalleryImageStruct$GalleryUrlImageView.mDecoding;
    }
    
    public void ceB()
    {
      this.Ki.setVisibility(0);
    }
    
    public Drawable getDrawable()
    {
      return this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter$GalleryImageStruct$GalleryUrlImageView.getDrawable();
    }
    
    public Bitmap getRegionBmp(Rect paramRect, Matrix paramMatrix, int paramInt1, int paramInt2)
    {
      return this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter$GalleryImageStruct$GalleryUrlImageView.getRegionBmp(paramRect, paramMatrix, paramInt1, paramInt2);
    }
    
    public boolean isOriginalImage()
    {
      return this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter$GalleryImageStruct$GalleryUrlImageView.isOriginalImage;
    }
    
    public void pause() {}
    
    public void rr(int paramInt) {}
    
    public void setAdjustViewBounds(boolean paramBoolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter$GalleryImageStruct$GalleryUrlImageView.setAdjustViewBounds(paramBoolean);
    }
    
    public void setCenterBtnVisiable(int paramInt)
    {
      this.tM.setVisibility(paramInt);
    }
    
    public void setDecodingDrawble(URLDrawable paramURLDrawable)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter$GalleryImageStruct$GalleryUrlImageView.setDecodingDrawble(paramURLDrawable);
    }
    
    public void setIgnoreLayout(boolean paramBoolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter$GalleryImageStruct$GalleryUrlImageView.isOriginalImage = paramBoolean;
    }
    
    public void setImageDrawable(Drawable paramDrawable)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter$GalleryImageStruct$GalleryUrlImageView.setImageDrawable(paramDrawable);
    }
    
    public void setImageInfo(xuf paramxuf)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter$GalleryImageStruct$GalleryUrlImageView.b = paramxuf;
    }
    
    public void setOriginalImage(boolean paramBoolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter$GalleryImageStruct$GalleryUrlImageView.isOriginalImage = paramBoolean;
    }
    
    public void setPosition(int paramInt)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter$GalleryImageStruct$GalleryUrlImageView.mPosition = paramInt;
    }
    
    public void setScaleY(float paramFloat)
    {
      super.setScaleY(paramFloat);
      ViewParent localViewParent = getParent();
      if ((localViewParent != null) && ((localViewParent instanceof ProGallery)) && (((ProGallery)localViewParent).mIsLayoutScale) && (this.Kj != null) && (this.Kj.getVisibility() == 0) && (paramFloat != 0.0F))
      {
        paramFloat = 1.0F / paramFloat;
        if (paramFloat >= 1.0F) {
          break label142;
        }
      }
      for (;;)
      {
        this.Kj.setPivotX(this.Kj.getWidth());
        this.Kj.setPivotY(0.0F);
        this.Kj.setScaleX(paramFloat);
        this.Kj.setScaleY(paramFloat);
        if (QLog.isColorLevel()) {
          QLog.d(" AIOGalleryAdapter", 2, "mSupplyLogo setScale " + this.Kj.getScaleX());
        }
        return;
        label142:
        localViewParent = getParent();
        if ((localViewParent != null) && ((localViewParent instanceof ViewGroup))) {
          ((ViewGroup)getParent()).setClipChildren(false);
        }
      }
    }
    
    public void yb(String paramString)
    {
      if ((paramString != null) && (paramString.length() != 0) && (!paramString.equals("null")))
      {
        TextView localTextView = new TextView(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.b);
        localTextView.setText(acfp.m(2131702219) + paramString);
        localTextView.setClickable(false);
        localTextView.setTextSize(1, 14.0F);
        localTextView.setTextColor(Color.parseColor("#777777"));
        localTextView.setVisibility(0);
        localTextView.setPadding(0, wja.dp2px(10.0F, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.b.getResources()), wja.dp2px(10.0F, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.b.getResources()), 0);
        this.Kj = localTextView;
        paramString = new LinearLayout.LayoutParams(-2, -2);
        paramString.gravity = 5;
        this.e = paramString;
        addView(localTextView, 1, paramString);
      }
    }
    
    public class GalleryUrlImageView
      extends AbstractImageAdapter.URLImageView2
    {
      public xuf b;
      boolean isOriginalImage = false;
      int mPosition;
      
      public GalleryUrlImageView(Context paramContext)
      {
        super();
      }
      
      public void draw(Canvas paramCanvas)
      {
        super.draw(paramCanvas);
      }
      
      public Bitmap getRegionBmp(Rect paramRect, Matrix paramMatrix, int paramInt1, int paramInt2)
      {
        Object localObject = new Rect(0, 0, paramInt1, paramInt2);
        ((Rect)localObject).offset(-paramRect.left, -paramRect.top);
        localObject = new RectF((Rect)localObject);
        Matrix localMatrix = new Matrix();
        paramMatrix.invert(localMatrix);
        paramMatrix = new RectF();
        localMatrix.mapRect(paramMatrix, (RectF)localObject);
        paramMatrix.intersect(0.0F, 0.0F, paramRect.width(), paramRect.height());
        if (QLog.isColorLevel()) {
          QLog.i(" AIOGalleryAdapter", 2, String.format("getRegionBmp dstScreenRectFInImg=%s rawImgRect=%s", new Object[] { paramMatrix, paramRect }));
        }
        float f = paramMatrix.width() / paramMatrix.height();
        int j = (int)(paramInt1 / f);
        int k = zti.getInSampleSize(1280, 1280, paramInt1, j);
        int i = j;
        paramInt2 = paramInt1;
        if (k > 1)
        {
          paramInt2 = paramInt1 / k;
          i = j / k;
        }
        paramRect = Bitmap.createBitmap(paramInt2, i, Bitmap.Config.ARGB_8888);
        localObject = new Canvas(paramRect);
        localMatrix = new Matrix();
        f = paramInt2 / paramMatrix.width();
        localMatrix.postTranslate(-paramMatrix.left, -paramMatrix.top);
        localMatrix.postScale(f, f);
        ((Canvas)localObject).setMatrix(localMatrix);
        draw((Canvas)localObject);
        return paramRect;
      }
      
      public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
      {
        super.onLoadFialed(paramURLDrawable, paramThrowable);
        paramURLDrawable = paramURLDrawable.getURL().getRef();
        if ((paramURLDrawable == null) || (!paramURLDrawable.equals("DISPLAY"))) {
          AIOGalleryAdapter.this.onLoadFinish(this.mPosition, false);
        }
      }
      
      @TargetApi(11)
      public void onLoadSuccessed(URLDrawable paramURLDrawable)
      {
        Object localObject = paramURLDrawable.getURL().getRef();
        if ((localObject != null) && (((String)localObject).equals("NOSAMPLE")))
        {
          this.ignoreLayout = true;
          super.onLoadSuccessed(paramURLDrawable);
          this.ignoreLayout = false;
          AIOGalleryAdapter.this.onLoadFinish(this.mPosition, true);
        }
        for (;;)
        {
          AIOGalleryAdapter.a(AIOGalleryAdapter.this).put(this.mPosition, paramURLDrawable);
          return;
          super.onLoadSuccessed(paramURLDrawable);
          if ((localObject == null) || (!((String)localObject).equals("DISPLAY"))) {
            AIOGalleryAdapter.this.onLoadFinish(this.mPosition, true);
          }
          if (this.b != null)
          {
            if (this.b.orientation == -2) {
              this.b.orientation = paramURLDrawable.getExifOrientation();
            }
            AIOGalleryAdapter.updateRotation((View)getParent(), paramURLDrawable, this.b.orientation);
          }
          localObject = paramURLDrawable.getCurrDrawable();
          if (VideoDrawable.class.isInstance(localObject)) {
            ((VideoDrawable)localObject).setOnPlayRepeatListener(new AIOGalleryAdapter.c(AIOGalleryAdapter.this));
          }
        }
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void db(int paramInt);
  }
  
  public static abstract interface b
  {
    public abstract void a(AIOImageData paramAIOImageData, boolean paramBoolean);
  }
  
  static class c
    implements VideoDrawable.OnPlayRepeatListener
  {
    AIOGalleryAdapter b;
    
    public c(AIOGalleryAdapter paramAIOGalleryAdapter)
    {
      this.b = paramAIOGalleryAdapter;
    }
    
    public void onPlayRepeat(int paramInt)
    {
      if (paramInt != 1) {
        return;
      }
      new Handler(Looper.getMainLooper()).post(new AIOGalleryAdapter.VideoListener.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOGalleryAdapter
 * JD-Core Version:    0.7.0.1
 */