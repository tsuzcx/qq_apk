package com.tencent.qqmail.activity.media;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import androidx.viewpager.widget.PagerAdapter;
import com.alibaba.fastjson.JSONObject;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.attachment.QMAttachManager;
import com.tencent.qqmail.attachment.model.Attach;
import com.tencent.qqmail.attachment.model.AttachPreview;
import com.tencent.qqmail.attachment.model.AttachProtocol;
import com.tencent.qqmail.download.AttachDownloadManager;
import com.tencent.qqmail.download.ImageDownloadManager;
import com.tencent.qqmail.download.loader.TinyImageSeqLoader;
import com.tencent.qqmail.download.model.DownloadInfo;
import com.tencent.qqmail.model.mail.watcher.QMWatcherCenter;
import com.tencent.qqmail.utilities.fileextention.FileUtil;
import com.tencent.qqmail.utilities.imageextention.ImageUtil;
import com.tencent.qqmail.utilities.qmnetwork.QMCallback;
import com.tencent.qqmail.utilities.stringextention.StringExtention;
import com.tencent.qqmail.utilities.thread.Threads;
import com.tencent.qqmail.utilities.ui.QMLoading;
import com.tencent.qqmail.utilities.validate.ValidateHelper;
import com.tencent.qqmail.view.imageview.QMGestureImageView;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import moai.oss.OssHelper;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.cookie.BasicClientCookie;

public class ImagePagerAdapter
  extends PagerAdapter
{
  private static final int HANDLE_DOWNLOAD_PROCESS = 1;
  private static final String TAG = "ImagePagerAdapter";
  private int mAccountId = 0;
  private Context mContext;
  private InnerDownloadHandler mDownloadHandler;
  private HashMap<String, String> mFtnCookies = new HashMap();
  private HashMap<String, JSONObject> mFtnData = new HashMap();
  private TinyImageSeqLoader mImageSeqLoader = null;
  private int mImageType = 1;
  private LayoutInflater mInflater;
  private List<MediaItemInfo> mInfoList = new ArrayList();
  private Handler mLoadImageHandler = new ImagePagerAdapter.6(this);
  private OnItemClickListener mOnItemClickListener;
  private OnItemLongClickListener mOnItemLongClickListener;
  private Object mPrimaryObject;
  private boolean[] mSelectedArray;
  private HashMap<String, TagData> mTagDataCache = new HashMap();
  private ToolbarAnimAction mToolbarAnimAction;
  private View.OnClickListener playVideoClickListener = new ImagePagerAdapter.1(this);
  
  public ImagePagerAdapter(Context paramContext, int paramInt, OnItemClickListener paramOnItemClickListener, OnItemLongClickListener paramOnItemLongClickListener, ToolbarAnimAction paramToolbarAnimAction)
  {
    this.mContext = paramContext;
    this.mOnItemClickListener = paramOnItemClickListener;
    this.mOnItemLongClickListener = paramOnItemLongClickListener;
    this.mToolbarAnimAction = paramToolbarAnimAction;
    this.mInflater = LayoutInflater.from(paramContext);
    this.mAccountId = paramInt;
    this.mDownloadHandler = new InnerDownloadHandler(this);
  }
  
  private void doLoadImage(int paramInt, String paramString1, String paramString2, ArrayList<Cookie> paramArrayList, View paramView, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = paramInt;
    if (paramInt <= 0) {
      i = this.mAccountId;
    }
    long l2 = 0L;
    Object localObject1 = null;
    paramInt = 0;
    Object localObject2;
    long l1;
    Object localObject3;
    if (paramInt < this.mInfoList.size())
    {
      localObject1 = (MediaItemInfo)this.mInfoList.get(paramInt);
      if ((((MediaItemInfo)localObject1).getDataPath() != null) && (((paramBoolean1) && (((MediaItemInfo)localObject1).getDataPath().equals(paramString2))) || ((!paramBoolean1) && (((MediaItemInfo)localObject1).getDataPath().equals(paramString1)))))
      {
        localObject2 = ((MediaItemInfo)localObject1).getFileName();
        paramString2 = ((MediaItemInfo)localObject1).getSourcePath();
        l1 = ((MediaItemInfo)localObject1).getFileSize();
        if (((MediaItemInfo)localObject1).getAttach() == null) {
          break label329;
        }
        l2 = ((MediaItemInfo)localObject1).getAttach().getHashId();
        localObject3 = localObject2;
        localObject2 = localObject1;
        localObject1 = localObject3;
      }
    }
    for (;;)
    {
      if (localObject2 == null)
      {
        ValidateHelper.assertInDebug("", false);
        return;
        paramInt += 1;
        break;
      }
      localObject3 = new DownloadInfo();
      ((DownloadInfo)localObject3).setAccountId(i);
      ((DownloadInfo)localObject3).setMailId(((MediaItemInfo)localObject2).getMailId());
      ((DownloadInfo)localObject3).setUrl(paramString1);
      ((DownloadInfo)localObject3).setKey(paramString1);
      ((DownloadInfo)localObject3).setAttachId(l2);
      ((DownloadInfo)localObject3).setFileName((String)localObject1);
      ((DownloadInfo)localObject3).setFileSize(l1);
      ((DownloadInfo)localObject3).setFilePath(paramString2);
      ((DownloadInfo)localObject3).setCookies(paramArrayList);
      ((DownloadInfo)localObject3).setIsNotify(false);
      ((DownloadInfo)localObject3).setDownloadType(1);
      if (paramBoolean1) {
        ((DownloadInfo)localObject3).setAttachType(1);
      }
      for (;;)
      {
        ((DownloadInfo)localObject3).setAttachDownloadListener(new ImagePagerAdapter.5(this, paramView, (MediaItemInfo)localObject2, paramString1, l2));
        AttachDownloadManager.shareInstance().fetchAttach((DownloadInfo)localObject3);
        return;
        if (paramBoolean2) {
          ((DownloadInfo)localObject3).setAttachType(3);
        } else {
          ((DownloadInfo)localObject3).setAttachType(0);
        }
      }
      l1 = 0L;
      paramString2 = "";
      localObject3 = "";
      localObject2 = localObject1;
      localObject1 = localObject3;
      continue;
      label329:
      localObject3 = localObject1;
      localObject1 = localObject2;
      localObject2 = localObject3;
    }
  }
  
  private void getFtnInfoFromCgi(MediaItemInfo paramMediaItemInfo, String paramString1, String paramString2, View paramView, int paramInt)
  {
    QMCallback localQMCallback1 = new QMCallback();
    localQMCallback1.setOnSuccess(new ImagePagerAdapter.8(this, paramString1, paramMediaItemInfo, paramString2, paramView));
    localQMCallback1.setOnError(new ImagePagerAdapter.9(this, paramView));
    QMCallback localQMCallback2 = new QMCallback();
    localQMCallback2.setOnSuccess(new ImagePagerAdapter.10(this, paramInt, paramString1, paramString2, paramView, paramMediaItemInfo));
    localQMCallback2.setOnError(new ImagePagerAdapter.11(this, paramView));
    AttachDownloadManager.shareInstance().fetchBigAttachData(paramString2, this.mAccountId, localQMCallback1, localQMCallback2);
  }
  
  private void getInfoFromCgiDone(MediaItemInfo paramMediaItemInfo, String paramString1, String paramString2, View paramView)
  {
    String str;
    if ((this.mFtnCookies.containsKey(paramString1)) && (this.mFtnData.containsKey(paramString1)))
    {
      str = (String)((JSONObject)this.mFtnData.get(paramString1)).get("errcode");
      if (str.equals("0")) {
        Threads.runOnMainThread(new ImagePagerAdapter.12(this, paramMediaItemInfo, paramString1, paramString2, paramView));
      }
    }
    else
    {
      return;
    }
    Threads.runOnMainThread(new ImagePagerAdapter.13(this, paramString1, paramString2, paramView, str));
  }
  
  private void handleFtnError(String paramString1, String paramString2, View paramView, String paramString3)
  {
    if ((!"-6".equals(paramString3)) && ((!this.mFtnData.containsKey(paramString1)) || (!this.mFtnCookies.containsKey(paramString1)))) {
      return;
    }
    OssHelper.bigattachOpenFail(new Object[] { Integer.valueOf(78502591), Integer.valueOf(1), "", "", "", "", "", "ImagePagerAdapter", "jpg", "errCode:" + paramString3 });
    postLoadImageMessage(paramView, 3);
    QMWatcherCenter.triggerLoadImageError(0, 0L, paramString1, paramString2, -1, "");
  }
  
  private void handleFtnSuccess(MediaItemInfo paramMediaItemInfo, String paramString1, String paramString2, View paramView)
  {
    if ((!this.mFtnData.containsKey(paramString1)) || (!this.mFtnCookies.containsKey(paramString1))) {
      return;
    }
    Object localObject = (String)this.mFtnCookies.get(paramString1);
    paramString1 = (String)((JSONObject)this.mFtnData.get(paramString1)).get("fileurl");
    paramMediaItemInfo = new TagData(paramMediaItemInfo, null, (QMGestureImageView)paramView.findViewById(2131368846), (TextView)paramView.findViewById(2131373696), paramString1, paramString2, 3, "");
    paramView.setTag(paramMediaItemInfo);
    this.mTagDataCache.put(paramString2, paramMediaItemInfo);
    paramMediaItemInfo = new BasicClientCookie("qm_ftn_key", (String)localObject);
    localObject = new ArrayList();
    ((ArrayList)localObject).add(paramMediaItemInfo);
    doLoadImage(this.mAccountId, paramString1, paramString2, (ArrayList)localObject, paramView, true, false);
  }
  
  private void hideProgressTip(TextView paramTextView)
  {
    if (paramTextView != null) {
      paramTextView.setVisibility(8);
    }
  }
  
  private boolean isImageLoad(MediaItemInfo paramMediaItemInfo)
  {
    boolean bool = false;
    if (paramMediaItemInfo.getAttach() != null)
    {
      paramMediaItemInfo = paramMediaItemInfo.getAttach();
      bool = FileUtil.isFileExist(paramMediaItemInfo.getPreview().getMyDisk());
      if ((paramMediaItemInfo.getProtocol() != null) && (paramMediaItemInfo.getProtocol().getProtocolType() == 0) && (!bool))
      {
        Object localObject = paramMediaItemInfo.getPreview().getCopyDiskList();
        if ((localObject != null) && (((ArrayList)localObject).size() > 0))
        {
          localObject = (String)((ArrayList)localObject).get(0);
          if (!StringExtention.isNullOrEmpty((String)localObject))
          {
            File localFile = new File((String)localObject);
            if (localFile.exists())
            {
              String str1 = FileUtil.rename(FileUtil.getAttachDownloadDir(), paramMediaItemInfo.getName());
              String str2 = FileUtil.getAttachDownloadDir() + str1;
              if (FileUtil.copyFile(localFile, new File(str2)) == 0)
              {
                QMAttachManager.sharedInstance().updateAttachDisk(paramMediaItemInfo.getHashId(), str1, str2, (String)localObject, 0);
                paramMediaItemInfo.getPreview().setMyDisk(str2);
                bool = true;
              }
            }
          }
        }
      }
    }
    else
    {
      return bool;
    }
    return bool;
  }
  
  private void postLoadImageMessage(View paramView, int paramInt)
  {
    Message localMessage = this.mDownloadHandler.obtainMessage();
    localMessage.what = paramInt;
    localMessage.obj = paramView;
    this.mDownloadHandler.sendMessage(localMessage);
  }
  
  private void renderLoadImageFail(View paramView, boolean paramBoolean)
  {
    if (paramView != null)
    {
      paramView.findViewById(2131367774).setVisibility(8);
      paramView.findViewById(2131367776).setVisibility(8);
      paramView.findViewById(2131367013).setVisibility(0);
      if (!paramBoolean) {
        break label128;
      }
      paramView = paramView.findViewById(2131367015);
      if (paramView != null)
      {
        paramView.setVisibility(0);
        TextView localTextView = (TextView)paramView.findViewById(2131367014);
        if (localTextView != null)
        {
          localTextView.setText(2131694054);
          if (this.mContext != null) {
            localTextView.setTextColor(this.mContext.getResources().getColor(2131167539));
          }
        }
        paramView = (TextView)paramView.findViewById(2131368947);
        if (paramView != null) {
          paramView.setVisibility(8);
        }
      }
    }
    return;
    label128:
    paramView.findViewById(2131367015).setVisibility(8);
  }
  
  private void renderLoadImageFail(TagData paramTagData)
  {
    paramTagData.layout.findViewById(2131367774).setVisibility(8);
    paramTagData.layout.findViewById(2131367776).setVisibility(8);
    paramTagData.layout.findViewById(2131367013).setVisibility(0);
  }
  
  private void renderLoadImageSucc(TagData paramTagData, MediaItemInfo paramMediaItemInfo)
  {
    Threads.runOnMainThread(new ImagePagerAdapter.7(this, paramTagData));
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
  
  private void updateLoadImageProgress(String paramString, long paramLong1, long paramLong2, TagData paramTagData)
  {
    paramTagData.progress = ((int)(paramLong1 * 1.0D / (paramLong2 * 1.0D) * 100.0D));
    if (paramTagData.progress < 0) {
      paramTagData.progress = 0;
    }
    for (;;)
    {
      sendHandlerMessage(1, paramTagData);
      return;
      if (paramTagData.progress > 100) {
        paramTagData.progress = 100;
      }
    }
  }
  
  public void abortDownloadAll()
  {
    Iterator localIterator = this.mTagDataCache.entrySet().iterator();
    while (localIterator.hasNext())
    {
      TagData localTagData = (TagData)((Map.Entry)localIterator.next()).getValue();
      if (!isImageLoad(localTagData.info)) {
        ImageDownloadManager.shareInstance().abort(localTagData.imageUrl);
      }
    }
  }
  
  public void change(List<MediaItemInfo> paramList, boolean[] paramArrayOfBoolean)
  {
    this.mInfoList = paramList;
    this.mSelectedArray = paramArrayOfBoolean;
    notifyDataSetChanged();
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    paramViewGroup.removeView((View)paramObject);
    ((View)paramObject).setOnClickListener(null);
    if (((View)paramObject).getTag() != null)
    {
      paramViewGroup = (TagData)((View)paramObject).getTag();
      if (paramViewGroup.bitmap != null)
      {
        paramViewGroup.bitmap.recycle();
        paramViewGroup.layout = null;
        paramViewGroup.imageView = null;
        paramViewGroup.tvProgress = null;
        paramViewGroup.bitmap = null;
      }
      ((View)paramObject).setTag(null);
    }
  }
  
  public int getCount()
  {
    return this.mInfoList.size();
  }
  
  public QMGestureImageView getGestureImageView()
  {
    if (this.mPrimaryObject != null) {
      return (QMGestureImageView)((RelativeLayout)this.mPrimaryObject).findViewById(2131368846);
    }
    return null;
  }
  
  public boolean[] getSelectedArray()
  {
    return this.mSelectedArray;
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    View localView = this.mInflater.inflate(2131559348, paramViewGroup, false);
    Object localObject1 = new QMLoading(QMApplicationContext.sharedInstance(), QMLoading.SIZE_MINI);
    ((RelativeLayout)localView.findViewById(2131367776)).addView((View)localObject1);
    QMGestureImageView localQMGestureImageView = (QMGestureImageView)localView.findViewById(2131368846);
    TextView localTextView = (TextView)localView.findViewById(2131373696);
    MediaItemInfo localMediaItemInfo = (MediaItemInfo)this.mInfoList.get(paramInt);
    localQMGestureImageView.setScaleType(ImageView.ScaleType.FIT_START);
    Object localObject2 = (ImageButton)localView.findViewById(2131373369);
    ((ImageButton)localObject2).setTag(localMediaItemInfo);
    ((ImageButton)localObject2).setOnClickListener(this.playVideoClickListener);
    this.mImageType = localMediaItemInfo.getImageType();
    Object localObject3;
    if (this.mImageType == 1)
    {
      localObject1 = "file://" + localMediaItemInfo.getDataPath();
      if ((this.mImageType != 2) && (this.mImageType != 1)) {
        break label356;
      }
      localObject3 = new TagData(localMediaItemInfo, null, localQMGestureImageView, localTextView, (String)localObject1, (String)localObject1, 2, localMediaItemInfo.getSourcePath());
      localView.setTag(localObject3);
      this.mTagDataCache.put(localObject1, localObject3);
    }
    for (;;)
    {
      new RelativeLayout.LayoutParams(-1, -1).addRule(13);
      paramViewGroup.addView(localView);
      localView.setOnClickListener(new ImagePagerAdapter.2(this, paramInt));
      if (!localMediaItemInfo.isVideo()) {
        break label459;
      }
      paramViewGroup = (TagData)localView.getTag();
      paramViewGroup.bitmap = localMediaItemInfo.getThumbnail();
      paramViewGroup.layout = localView;
      ((ImageButton)localObject2).setVisibility(0);
      renderLoadImageSucc(paramViewGroup, localMediaItemInfo);
      return localView;
      if (this.mImageType != 4)
      {
        localObject1 = localMediaItemInfo.getDataPath();
        break;
      }
      localObject1 = localMediaItemInfo.getAttach().getHashId() + "";
      localMediaItemInfo.setDataPath((String)localObject1);
      break;
      label356:
      if (this.mImageType == 4)
      {
        localObject3 = new TagData(localMediaItemInfo, null, localQMGestureImageView, localTextView, localMediaItemInfo.getAttach().getHashId() + "", (String)localObject1, 4, localMediaItemInfo.getSourcePath());
        localView.setTag(localObject3);
        this.mTagDataCache.put(localMediaItemInfo.getAttach().getHashId() + "", localObject3);
      }
    }
    label459:
    if (isImageLoad(localMediaItemInfo))
    {
      ((ImageButton)localObject2).setVisibility(8);
      localObject3 = ImageUtil.memSafeScaleImage(localMediaItemInfo.getSourcePath(), 1, 1.0F);
      localObject2 = (TagData)localView.getTag();
      paramViewGroup = (ViewGroup)localObject2;
      if (localObject2 == null)
      {
        paramViewGroup = new TagData(localMediaItemInfo, null, localQMGestureImageView, localTextView, (String)localObject1, (String)localObject1, this.mImageType, localMediaItemInfo.getSourcePath());
        localView.setTag(paramViewGroup);
      }
      paramViewGroup.bitmap = ((Bitmap)localObject3);
      paramViewGroup.layout = localView;
      paramViewGroup.filePath = localMediaItemInfo.getAttach().getPreview().getMyDisk();
      renderLoadImageSucc(paramViewGroup, localMediaItemInfo);
      QMWatcherCenter.triggerLoadImageSuccess(localMediaItemInfo.getAccountId(), localMediaItemInfo.getMailId(), "", localMediaItemInfo.getDataPath(), localMediaItemInfo.getAttach().getPreview().getMyDisk(), (Bitmap)localObject3, true);
      this.mTagDataCache.put(localObject1, paramViewGroup);
      return localView;
    }
    if ((this.mImageType == 1) || (this.mImageType == 2))
    {
      doLoadImage(localMediaItemInfo.getAccountId(), (String)localObject1, "", null, localView, false, false);
      return localView;
    }
    if (this.mImageType == 3)
    {
      getFtnInfoFromCgi(localMediaItemInfo, StringExtention.hashKeyForDisk((String)localObject1), (String)localObject1, localView, paramInt);
      return localView;
    }
    doLoadImage(localMediaItemInfo.getAccountId(), (String)localObject1, "", null, localView, false, true);
    return localView;
  }
  
  public boolean isProtocolDownCached(String paramString)
  {
    return this.mTagDataCache.containsKey(paramString);
  }
  
  public boolean isQQMailDownCached(String paramString)
  {
    return this.mTagDataCache.containsKey(paramString);
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == (View)paramObject;
  }
  
  public void recycle()
  {
    Iterator localIterator = this.mTagDataCache.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)((Map.Entry)localIterator.next()).getKey();
      localObject = (TagData)this.mTagDataCache.get(localObject);
      if ((localObject != null) && (((TagData)localObject).bitmap != null))
      {
        ((TagData)localObject).bitmap.recycle();
        ((TagData)localObject).bitmap = null;
      }
    }
    this.mTagDataCache.clear();
    this.mFtnCookies.clear();
    this.mFtnData.clear();
    if (this.mDownloadHandler != null) {
      this.mDownloadHandler.removeCallbacksAndMessages(null);
    }
  }
  
  public void removeImageSeqLoader()
  {
    this.mImageSeqLoader = null;
  }
  
  public void setImageSeqLoader(TinyImageSeqLoader paramTinyImageSeqLoader)
  {
    this.mImageSeqLoader = paramTinyImageSeqLoader;
  }
  
  public void setPrimaryItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    super.setPrimaryItem(paramViewGroup, paramInt, paramObject);
    paramViewGroup = (View)this.mPrimaryObject;
    this.mPrimaryObject = paramObject;
    if ((paramViewGroup != null) && (paramViewGroup != paramObject))
    {
      paramViewGroup = (TagData)paramViewGroup.getTag();
      if ((paramViewGroup != null) && (paramViewGroup.bitmap != null)) {
        paramViewGroup.imageView.setImageBitmap(paramViewGroup.bitmap);
      }
    }
    paramViewGroup = getGestureImageView();
    if (paramViewGroup != null)
    {
      paramViewGroup.setOnClickListener(new ImagePagerAdapter.3(this, paramInt));
      paramViewGroup.setOnLongClickListener(new ImagePagerAdapter.4(this, paramInt));
    }
  }
  
  static class InnerDownloadHandler
    extends Handler
  {
    private WeakReference<ImagePagerAdapter> mOuter;
    
    public InnerDownloadHandler(ImagePagerAdapter paramImagePagerAdapter)
    {
      super();
      this.mOuter = new WeakReference(paramImagePagerAdapter);
    }
    
    public void handleMessage(Message paramMessage)
    {
      ImagePagerAdapter localImagePagerAdapter = (ImagePagerAdapter)this.mOuter.get();
      if (localImagePagerAdapter != null) {}
      switch (paramMessage.what)
      {
      case 2: 
      default: 
        return;
      case 0: 
        localImagePagerAdapter.renderLoadImageSucc((ImagePagerAdapter.TagData)paramMessage.obj, null);
        return;
      case 1: 
        localImagePagerAdapter.renderLoadImageFail((ImagePagerAdapter.TagData)paramMessage.obj);
        return;
      }
      localImagePagerAdapter.renderLoadImageFail((View)paramMessage.obj, true);
    }
  }
  
  public static abstract interface OnItemClickListener
  {
    public abstract void onItemClick(int paramInt, boolean paramBoolean);
  }
  
  public static abstract interface OnItemLongClickListener
  {
    public abstract void onItemLongClick(int paramInt, View paramView);
  }
  
  static class TagData
  {
    public Bitmap bitmap;
    public String filePath;
    public int imageType = 1;
    public String imageUrl;
    public QMGestureImageView imageView;
    public MediaItemInfo info;
    public View layout;
    public String originalUrl;
    public int progress;
    public TextView tvProgress;
    
    TagData(MediaItemInfo paramMediaItemInfo, Bitmap paramBitmap, QMGestureImageView paramQMGestureImageView, TextView paramTextView, String paramString1, String paramString2, int paramInt, String paramString3)
    {
      this.info = paramMediaItemInfo;
      this.bitmap = paramBitmap;
      this.imageView = paramQMGestureImageView;
      this.imageUrl = paramString1;
      this.originalUrl = paramString2;
      this.imageType = paramInt;
      this.tvProgress = paramTextView;
      this.progress = 0;
      this.filePath = paramString3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.media.ImagePagerAdapter
 * JD-Core Version:    0.7.0.1
 */