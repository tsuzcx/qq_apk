package com.tencent.qqmail.attachment.activity;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXFragment;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.attachment.model.ImageData;
import com.tencent.qqmail.attachment.util.ImagePagerCache;
import com.tencent.qqmail.attachment.view.FtnGestureImageViewListener;
import com.tencent.qqmail.download.AttachDownloadManager;
import com.tencent.qqmail.download.ImageDownloadManager;
import com.tencent.qqmail.download.model.DownloadInfo;
import com.tencent.qqmail.ftn.FtnManager;
import com.tencent.qqmail.ftn.model.FtnDownloadInfo;
import com.tencent.qqmail.ftn.model.FtnUI;
import com.tencent.qqmail.utilities.observer.IObserver;
import com.tencent.qqmail.utilities.observer.QMNotification;
import com.tencent.qqmail.utilities.stringextention.StringExtention;
import com.tencent.qqmail.utilities.ui.QMLoading;
import com.tencent.qqmail.view.imageview.QMGestureImageView;

public class ImagePagerFragment
  extends ReportAndroidXFragment
{
  private static final String ARG_EXTRA_DATA = "arg_extra_data";
  private static final String ARG_PAGE_TAG = "arg_page_tag";
  private static final int HANDLE_DOWNLOAD_PROCESS = 1;
  public static final String TAG = "ImagePagerFragment";
  private View backView;
  private BitmapDrawable currentBitmapDrawable = null;
  private ImageView fetchImageFailed;
  private LinearLayout fetchImageFailedTips;
  private Handler handler = new Handler();
  private ImageData imageData;
  private Button imageFailRetry;
  private View.OnClickListener imageFailRetryClickListener = new ImagePagerFragment.4(this);
  private View.OnClickListener imagePagerClickListener = new ImagePagerFragment.3(this);
  private QMGestureImageView imageView;
  private FtnGestureImageViewListener imageViewListener;
  private boolean isFragmentAlive = true;
  private QMLoading loadingView;
  private Handler mLoadImageHandler = new ImagePagerFragment.7(this);
  private IObserver mObserverGetDownloadUrlError = new ImagePagerFragment.2(this, null);
  private IObserver mObserverGetDownloadUrlSuccess = new ImagePagerFragment.1(this, null);
  private int position;
  private ImageView prevImageIcon;
  private RelativeLayout progressBar;
  private TextView progressTextView;
  
  private void fixImageFail()
  {
    ImagePagerActivity localImagePagerActivity = (ImagePagerActivity)getActivity();
    this.handler.post(new ImagePagerFragment.6(this, localImagePagerActivity));
    hideFetchImageError();
  }
  
  private void hideFetchImageError()
  {
    this.prevImageIcon.setVisibility(0);
    this.progressBar.setVisibility(0);
    this.fetchImageFailed.setVisibility(8);
    this.fetchImageFailedTips.setVisibility(8);
    this.loadingView.start();
  }
  
  private void hideProgress()
  {
    if (this.progressTextView != null) {
      this.progressTextView.setVisibility(8);
    }
  }
  
  private boolean isFragmentAlive()
  {
    return this.isFragmentAlive;
  }
  
  public static ImagePagerFragment newInstance(int paramInt, String paramString)
  {
    ImagePagerFragment localImagePagerFragment = new ImagePagerFragment();
    Bundle localBundle = new Bundle();
    localBundle.putInt("arg_extra_data", paramInt);
    localBundle.putString("arg_page_tag", paramString);
    localImagePagerFragment.setArguments(localBundle);
    return localImagePagerFragment;
  }
  
  private void recycleBitmapDrawable()
  {
    if (this.currentBitmapDrawable != null)
    {
      Bitmap localBitmap = this.currentBitmapDrawable.getBitmap();
      if ((localBitmap != null) && (!localBitmap.isRecycled())) {
        localBitmap.recycle();
      }
      this.currentBitmapDrawable.setCallback(null);
      this.currentBitmapDrawable = null;
    }
  }
  
  private void registerListener()
  {
    QMNotification.registNotification("actiongetdownloadurlsucc", this.mObserverGetDownloadUrlSuccess);
    QMNotification.registNotification("actiongetdownloadurlerror", this.mObserverGetDownloadUrlError);
  }
  
  private void renderProcess(String paramString, long paramLong1, long paramLong2)
  {
    LoadImageInfo localLoadImageInfo = new LoadImageInfo(null);
    localLoadImageInfo.progress = ((int)(paramLong1 * 1.0D / (paramLong2 * 1.0D) * 100.0D));
    if (localLoadImageInfo.progress >= 100L) {
      localLoadImageInfo.progress = 100L;
    }
    localLoadImageInfo.url = paramString;
    sendHandlerMessage(1, localLoadImageInfo);
  }
  
  private void sendHandlerMessage(int paramInt, Object paramObject)
  {
    if (paramObject == null)
    {
      this.mLoadImageHandler.sendEmptyMessage(paramInt);
      return;
    }
    Message localMessage = this.mLoadImageHandler.obtainMessage();
    localMessage.what = paramInt;
    localMessage.obj = paramObject;
    this.mLoadImageHandler.sendMessage(localMessage);
  }
  
  private void setFragmentAlive(boolean paramBoolean)
  {
    this.isFragmentAlive = paramBoolean;
  }
  
  private void showFetchImageError(String paramString)
  {
    this.prevImageIcon.setVisibility(8);
    this.progressBar.setVisibility(8);
    this.fetchImageFailed.setVisibility(0);
    this.fetchImageFailedTips.setVisibility(0);
    this.loadingView.stop();
  }
  
  private void unregisterListener()
  {
    QMNotification.unregistNotification("actiongetdownloadurlsucc", this.mObserverGetDownloadUrlSuccess);
    QMNotification.unregistNotification("actiongetdownloadurlerror", this.mObserverGetDownloadUrlError);
  }
  
  public void fetchImage()
  {
    if (ImagePagerCache.imageFtnUIs == null) {}
    for (int i = 0; (this.position >= i) || (this.position < 0); i = ImagePagerCache.imageFtnUIs.getCount()) {
      return;
    }
    this.imageData = ImagePagerCache.getImageData(ImagePagerActivity.mUin, this.position);
    Object localObject = FtnManager.sharedInstance().getDownloadInfo(this.imageData.getFid());
    String str = "";
    if (localObject != null) {
      str = ((FtnDownloadInfo)localObject).getSavePath();
    }
    localObject = new DownloadInfo();
    ((DownloadInfo)localObject).setAccountId(this.imageData.getAccountId());
    ((DownloadInfo)localObject).setFid(this.imageData.getFid());
    ((DownloadInfo)localObject).setFileSize(Long.valueOf(this.imageData.getSize()).longValue());
    ((DownloadInfo)localObject).setUrl(this.imageData.getDownUrl());
    ((DownloadInfo)localObject).setKey(this.imageData.getDownUrl());
    ((DownloadInfo)localObject).setFtnKey(this.imageData.getKey());
    ((DownloadInfo)localObject).setFtnCode(this.imageData.getCode());
    ((DownloadInfo)localObject).setFtnBytes(StringExtention.sizeStrToLong(this.imageData.getSize()));
    ((DownloadInfo)localObject).setFileName(this.imageData.getName());
    ((DownloadInfo)localObject).setFilePath(str);
    ((DownloadInfo)localObject).setIsNotify(false);
    ((DownloadInfo)localObject).setDownloadType(1);
    ((DownloadInfo)localObject).setAttachType(2);
    ((DownloadInfo)localObject).setAttachDownloadListener(new ImagePagerFragment.5(this));
    AttachDownloadManager.shareInstance().fetchAttach((DownloadInfo)localObject);
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    if (ImagePagerActivity.class.isInstance(getActivity())) {
      fetchImage();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setFragmentAlive(true);
    if (getArguments() != null) {}
    for (int i = getArguments().getInt("arg_extra_data");; i = -1)
    {
      this.position = i;
      return;
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131559348, paramViewGroup, false);
    this.imageViewListener = new FtnGestureImageViewListener((ImagePagerActivity)getActivity());
    this.imageView = ((QMGestureImageView)paramLayoutInflater.findViewById(2131368846));
    this.imageView.setGestureImageViewListener(this.imageViewListener);
    this.imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
    this.progressTextView = ((TextView)paramLayoutInflater.findViewById(2131373696));
    this.backView = paramLayoutInflater.findViewById(2131367775);
    this.prevImageIcon = ((ImageView)paramLayoutInflater.findViewById(2131367774));
    this.fetchImageFailed = ((ImageView)paramLayoutInflater.findViewById(2131367013));
    this.imageFailRetry = ((Button)paramLayoutInflater.findViewById(2131368947));
    this.fetchImageFailedTips = ((LinearLayout)paramLayoutInflater.findViewById(2131367015));
    this.progressBar = ((RelativeLayout)paramLayoutInflater.findViewById(2131367776));
    this.loadingView = new QMLoading(QMApplicationContext.sharedInstance(), QMLoading.SIZE_MINI);
    this.progressBar.addView(this.loadingView);
    this.backView.setOnClickListener(this.imagePagerClickListener);
    this.imageView.setOnClickListener(this.imagePagerClickListener);
    this.imageFailRetry.setOnClickListener(this.imageFailRetryClickListener);
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.imageData != null) {
      ImageDownloadManager.shareInstance().abort(this.imageData.getDownUrl());
    }
    if (this.imageView != null) {
      this.imageView.setImageDrawable(null);
    }
    recycleBitmapDrawable();
    setFragmentAlive(false);
  }
  
  public void onPause()
  {
    super.onPause();
    unregisterListener();
  }
  
  public void onResume()
  {
    super.onResume();
    this.imageViewListener.resetStatus();
    registerListener();
  }
  
  class LoadImageInfo
  {
    public long progress;
    public String url;
    
    private LoadImageInfo() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.attachment.activity.ImagePagerFragment
 * JD-Core Version:    0.7.0.1
 */