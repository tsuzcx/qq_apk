package com.tencent.qqmail.ftn.activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.media.ThumbnailUtils;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.model.QQMailAccount;
import com.tencent.qqmail.animation.ProgressBarCallback;
import com.tencent.qqmail.animation.SmoothProgressBar;
import com.tencent.qqmail.attachment.model.AttachType;
import com.tencent.qqmail.attachment.util.QMAttachUtils;
import com.tencent.qqmail.download.ImageDownloadManager;
import com.tencent.qqmail.download.model.DownloadInfo;
import com.tencent.qqmail.ftn.Ftn.FileInfo;
import com.tencent.qqmail.ftn.FtnManager;
import com.tencent.qqmail.ftn.model.FtnNewInfo;
import com.tencent.qqmail.ftn.model.FtnUI;
import com.tencent.qqmail.ftn.model.FtnUploadInfo;
import com.tencent.qqmail.ftn.util.FtnCommonUtils;
import com.tencent.qqmail.utilities.exception.DevRuntimeException;
import com.tencent.qqmail.utilities.fileextention.FileUtil;
import com.tencent.qqmail.utilities.imageextention.ImageResourceUtil;
import com.tencent.qqmail.utilities.imageextention.ImageUtil;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.stringextention.StringExtention;
import com.tencent.qqmail.utilities.ui.QMUIKit;
import com.tencent.qqmail.utilities.validate.ValidateHelper;
import com.tencent.qqmail.view.QMListItemView;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;

public class FtnListAdapter
  extends BaseAdapter
{
  private static final int FAKE_VIEW_TYPE = 0;
  private static final int LIST_VIEW_TYPE = 2;
  private static final String TAG = FtnListAdapter.class.getSimpleName();
  private static final int UPLOAD_VIEW_TYPE = 1;
  private HashMap<String, FtnNewInfo> fakeNewItemIndex = new HashMap();
  private ArrayList<FtnNewInfo> fakeNewItems = new ArrayList();
  private final FtnListActivity ftnListActivity;
  private boolean isResetView = false;
  private final ListView listView;
  public final QQMailAccount mAccount = AccountManager.shareInstance().getAccountList().getDefaultFtnAccount();
  private FtnUI mFtnUI = null;
  private HashMap<String, Boolean> resetViewsFinish = new HashMap();
  private FtnUploadInfo selectUploadData = null;
  private ArrayList<FtnUploadInfo> unFinishUploadFiles = new ArrayList();
  private ArrayList<FtnUploadInfo> uploadItems = new ArrayList(4);
  private HashMap<FtnUploadInfo, View> uploadItemsView = new HashMap();
  private HashMap<String, Bitmap> uploadThumbCache = new HashMap();
  private final View.OnClickListener wrapUploadButtonClickListener = new FtnListAdapter.1(this);
  
  public FtnListAdapter(ListView paramListView, FtnListActivity paramFtnListActivity)
  {
    ValidateHelper.notNull(paramListView);
    this.listView = paramListView;
    this.ftnListActivity = paramFtnListActivity;
  }
  
  private ItemViewHolder buildNormalItemViewHolder(View paramView, int paramInt)
  {
    ItemViewHolder localItemViewHolder = new ItemViewHolder();
    localItemViewHolder.ftn_filename = ((TextView)paramView.findViewById(2131367764));
    localItemViewHolder.ftn_expiretime = ((TextView)paramView.findViewById(2131367753));
    localItemViewHolder.ftn_thumbnail = ((ImageView)paramView.findViewById(2131367778));
    localItemViewHolder.chevron = ((ImageView)paramView.findViewById(2131364597));
    localItemViewHolder.ftn_filesize = ((TextView)paramView.findViewById(2131367765));
    localItemViewHolder.position = paramInt;
    localItemViewHolder.needInflate = false;
    paramView.setTag(localItemViewHolder);
    return localItemViewHolder;
  }
  
  private UploadViewHolder buildUploadItemViewHolder(FtnUploadInfo paramFtnUploadInfo, View paramView, int paramInt)
  {
    this.isResetView = true;
    UploadViewHolder localUploadViewHolder = new UploadViewHolder();
    localUploadViewHolder.toggleButton = ((ImageButton)paramView.findViewById(2131381318));
    localUploadViewHolder.toggleButton.setOnClickListener(this.wrapUploadButtonClickListener);
    localUploadViewHolder.progressBar = ((SmoothProgressBar)paramView.findViewById(2131381339));
    localUploadViewHolder.progressBar.setMax(100);
    localUploadViewHolder.progressBar.setDuration(10);
    localUploadViewHolder.progressBar.setPbCallback(paramFtnUploadInfo);
    localUploadViewHolder.progressBar.setSchedule(paramFtnUploadInfo.getSchedule());
    localUploadViewHolder.progressBar.setProgress(paramFtnUploadInfo.getProgress());
    localUploadViewHolder.upload_thumbnail = ((ImageView)paramView.findViewById(2131367780));
    localUploadViewHolder.filename = ((TextView)paramView.findViewById(2131367764));
    localUploadViewHolder.filesize = ((TextView)paramView.findViewById(2131367765));
    localUploadViewHolder.uploadFailed = ((TextView)paramView.findViewById(2131381313));
    localUploadViewHolder.state = paramFtnUploadInfo.getState();
    localUploadViewHolder.sha = paramFtnUploadInfo.getSha();
    paramView.setTag(localUploadViewHolder);
    return localUploadViewHolder;
  }
  
  private void fixToggleBtnStatus(FtnUploadInfo paramFtnUploadInfo, ImageButton paramImageButton)
  {
    if ((paramFtnUploadInfo.getState() == 4) || (paramFtnUploadInfo.getState() == 3)) {
      paramImageButton.setImageResource(2130850470);
    }
    while (paramFtnUploadInfo.getState() != 2) {
      return;
    }
    paramImageButton.setImageResource(2130850473);
  }
  
  private int getViewHolderPosition(View paramView)
  {
    paramView = paramView.getTag();
    if ((paramView instanceof ItemViewHolder)) {
      return ((ItemViewHolder)paramView).position;
    }
    return -1;
  }
  
  @SuppressLint({"NewApi"})
  private Bitmap imageThumbSelfCompress(String paramString)
  {
    return ThumbnailUtils.extractThumbnail(ImageUtil.memSafeScaleImage(paramString, 1, 1.0F), this.ftnListActivity.getResources().getDimensionPixelSize(2131297615), this.ftnListActivity.getResources().getDimensionPixelOffset(2131297615), 2);
  }
  
  private View inflateViewByRes(int paramInt, ViewGroup paramViewGroup)
  {
    return ((LayoutInflater)QMApplicationContext.sharedInstance().getSystemService("layout_inflater")).inflate(paramInt, paramViewGroup, false);
  }
  
  private boolean isFiletypeImage(String paramString)
  {
    return AttachType.valueOf(QMAttachUtils.attachFileType(FileUtil.getFileNameSuffix(paramString))).name().toLowerCase(Locale.getDefault()).equals("image");
  }
  
  private boolean isResetUploadPb(UploadViewHolder paramUploadViewHolder, FtnUploadInfo paramFtnUploadInfo)
  {
    return paramUploadViewHolder.progressBar.getProgress() == 100;
  }
  
  private boolean isUpdateThumbImage(int paramInt, View paramView)
  {
    boolean bool = true;
    Object localObject = getItem(paramInt);
    if (localObject == null) {
      return false;
    }
    int i;
    if ((localObject instanceof FileInfo))
    {
      if (((FileInfo)localObject).filetype != 1) {
        break label117;
      }
      i = 1;
    }
    for (;;)
    {
      if ((paramInt == getViewHolderPosition(paramView)) && (i != 0)) {}
      for (;;)
      {
        return bool;
        if ((localObject instanceof FtnUploadInfo))
        {
          if (!isFiletypeImage(((FtnUploadInfo)localObject).getName())) {
            break label117;
          }
          i = 1;
          break;
        }
        if ((!(localObject instanceof FtnNewInfo)) || (!isFiletypeImage(((FtnNewInfo)localObject).getName()))) {
          break label117;
        }
        i = 1;
        break;
        bool = false;
      }
      label117:
      i = 0;
    }
  }
  
  private void setCurrentUploadItemData(FtnUploadInfo paramFtnUploadInfo)
  {
    this.selectUploadData = paramFtnUploadInfo;
  }
  
  private void setFakeHolderParams(View paramView, ItemViewHolder paramItemViewHolder, FtnNewInfo paramFtnNewInfo)
  {
    String str1 = StringExtention.getHumanReadableSizeString(Long.parseLong(paramFtnNewInfo.getFileSize() + ""));
    String str2 = FtnCommonUtils.getExpireTimeString(new Date(paramFtnNewInfo.getExpireTime() * 1000L));
    String str3 = AttachType.valueOf(QMAttachUtils.attachFileType(FileUtil.getFileNameSuffix(paramFtnNewInfo.getName()))).name().toLowerCase(Locale.getDefault());
    paramItemViewHolder.ftn_filename.setText(paramFtnNewInfo.getName() + QMUIKit.ELLIPSIZE_FIXED);
    paramItemViewHolder.ftn_filesize.setText(str1);
    paramItemViewHolder.ftn_expiretime.setText(str2 + this.ftnListActivity.getResources().getString(2131694056));
    if (str3.equals("image")) {
      setThumbSelfCompress(paramView, paramItemViewHolder.ftn_thumbnail, str3, paramFtnNewInfo.getAbsolutePath(), paramFtnNewInfo.getSha());
    }
    for (;;)
    {
      setItemEditStateWithExpiredState(paramView, true);
      return;
      setThumbByType(paramView, paramItemViewHolder.ftn_thumbnail, str3);
    }
  }
  
  private void setImageDefaultResource(ImageView paramImageView)
  {
    if (paramImageView != null) {
      paramImageView.setImageResource(2130840449);
    }
  }
  
  private void setItemEditStateWithExpiredState(View paramView, boolean paramBoolean)
  {
    Object localObject = (QMListItemView)paramView;
    ItemViewHolder localItemViewHolder = (ItemViewHolder)paramView.getTag();
    Resources localResources = this.ftnListActivity.getResources();
    if (this.ftnListActivity.isEditing())
    {
      ((QMListItemView)localObject).setItemToEditMode();
      paramView = localItemViewHolder.ftn_filename;
      if (paramBoolean) {}
      for (int i = localResources.getColor(2131167519);; i = localResources.getColor(2131167179))
      {
        paramView.setTextColor(i);
        localItemViewHolder.ftn_filesize.setTextColor(localResources.getColor(2131167531));
        localItemViewHolder.ftn_expiretime.setTextColor(localResources.getColor(2131167531));
        return;
      }
    }
    ((QMListItemView)localObject).setItemToNormalMode();
    localObject = localItemViewHolder.ftn_filename;
    if (paramBoolean) {}
    for (paramView = localResources.getColorStateList(2131167519);; paramView = localResources.getColorStateList(2131167179))
    {
      ((TextView)localObject).setTextColor(paramView);
      localItemViewHolder.ftn_filesize.setTextColor(localResources.getColorStateList(2131167531));
      localItemViewHolder.ftn_expiretime.setTextColor(localResources.getColorStateList(2131167531));
      return;
    }
  }
  
  private void setThumbByType(View paramView, ImageView paramImageView, String paramString)
  {
    int i = ImageResourceUtil.getImageResource(paramString, ImageResourceUtil.IMAGE_SIZE_58);
    if (i != -1) {
      paramImageView.setImageResource(i);
    }
  }
  
  private void setThumbSelfCompress(View paramView, ImageView paramImageView, String paramString1, String paramString2, String paramString3)
  {
    if ((paramString2 != null) && (paramString3 != null))
    {
      int i = ImageDownloadManager.shareInstance().isThumbBitmapExistLocalWithKey(paramString3);
      if ((i == 1) || (i == 2))
      {
        paramImageView.setImageBitmap(ImageDownloadManager.shareInstance().getThumbBitmapFromLocalByKey(paramString3));
        return;
      }
      paramView = ImageUtil.fixImageOrientationDirection(imageThumbSelfCompress(paramString2), ImageUtil.getImageOrientation(null, paramString2));
      paramImageView.setImageBitmap(paramView);
      ImageDownloadManager.shareInstance().addImageDiskCache(paramString3, paramView);
      return;
    }
    setImageDefaultResource(paramImageView);
  }
  
  private void setUploadItemParams(View paramView, FtnUploadInfo paramFtnUploadInfo, UploadViewHolder paramUploadViewHolder)
  {
    paramUploadViewHolder.filename.setText(paramFtnUploadInfo.getName() + QMUIKit.ELLIPSIZE_FIXED);
    String str = AttachType.valueOf(QMAttachUtils.attachFileType(FileUtil.getFileNameSuffix(paramFtnUploadInfo.getName()))).name().toLowerCase(Locale.getDefault());
    if (str.equals("image")) {
      setThumbSelfCompress(paramView, paramUploadViewHolder.upload_thumbnail, str, paramFtnUploadInfo.getOriginalPath(), paramFtnUploadInfo.getSha());
    }
    for (;;)
    {
      paramView = StringExtention.getHumanReadableSizeString(Long.parseLong(paramFtnUploadInfo.getFileSize() + ""));
      paramUploadViewHolder.filesize.setText(paramView);
      return;
      setThumbByType(paramView, paramUploadViewHolder.upload_thumbnail, str);
    }
  }
  
  private void setViewHolderImage(View paramView, int paramInt, ImageView paramImageView, String paramString1, String paramString2, String paramString3)
  {
    paramString1 = AttachType.valueOf(QMAttachUtils.attachFileType(FileUtil.getFileNameSuffix(paramString1))).name().toLowerCase(Locale.getDefault());
    if (paramString1.equals("image"))
    {
      paramString1 = FtnCommonUtils.getThumbUrl(this.mAccount.getUin(), paramString2, "2", "2", this.mAccount.getId());
      int i = ImageDownloadManager.shareInstance().isThumbBitmapExistLocal(paramString1);
      if ((i == 2) || (i == 1))
      {
        paramString2 = ImageDownloadManager.shareInstance().getThumbBitmapFromLocal(paramString1);
        if (paramString2 != null) {
          paramImageView.setImageBitmap(paramString2);
        }
      }
      for (;;)
      {
        paramString2 = new DownloadInfo();
        paramString2.setUrl(paramString1);
        paramString2.setImageDownloadListener(new FtnListAdapter.2(this, paramInt, paramView, paramImageView, paramString3));
        ImageDownloadManager.shareInstance().fetchImage(paramString2);
        return;
        paramImageView.setImageResource(2130840449);
        continue;
        paramImageView.setImageResource(2130840449);
      }
    }
    setThumbByType(paramView, paramImageView, paramString1);
  }
  
  private void setViewHolderParams(View paramView, int paramInt, ItemViewHolder paramItemViewHolder, FileInfo paramFileInfo)
  {
    paramItemViewHolder.ftn_filename.setText(paramFileInfo.filename);
    long l2 = paramFileInfo.filesize;
    long l1 = l2;
    if (l2 < 0L)
    {
      l1 = Math.pow(2.0D, 31.0D);
      l1 = l2 + l1 + l1;
    }
    paramItemViewHolder.ftn_filesize.setText(StringExtention.getHumanReadableSizeString(l1));
    Object localObject = new Date(paramFileInfo.expiretime * 1000L);
    String str = FtnCommonUtils.getExpireTimeString((Date)localObject);
    boolean bool = FtnCommonUtils.isNotExpireSoon((Date)localObject).booleanValue();
    localObject = str;
    if (!str.equals("已过期"))
    {
      localObject = str;
      if (!str.equals("即将过期")) {
        localObject = str + this.ftnListActivity.getResources().getString(2131694056);
      }
    }
    paramItemViewHolder.ftn_expiretime.setText((CharSequence)localObject);
    setItemEditStateWithExpiredState(paramView, bool);
    setViewHolderImage(paramView, paramInt, paramItemViewHolder.ftn_thumbnail, paramFileInfo.filename, paramFileInfo.fid, paramFileInfo.sha);
  }
  
  private void showUploadError(ProgressBar paramProgressBar, TextView paramTextView, ImageButton paramImageButton)
  {
    paramProgressBar.setVisibility(8);
    paramTextView.setVisibility(0);
    paramImageButton.setImageResource(2130850470);
  }
  
  private void showUploadItemState(View paramView, int paramInt)
  {
    showUploadItemState(paramView, paramInt, null);
  }
  
  private void showUploadItemState(View paramView, int paramInt, String paramString)
  {
    if ((paramView == null) || (paramInt < 0)) {}
    do
    {
      return;
      paramView = paramView.getTag();
    } while ((paramView == null) || (!(paramView instanceof UploadViewHolder)));
    Object localObject = (UploadViewHolder)paramView;
    paramView = ((UploadViewHolder)localObject).progressBar;
    TextView localTextView = ((UploadViewHolder)localObject).uploadFailed;
    localObject = ((UploadViewHolder)localObject).toggleButton;
    if ((paramInt == 2) || (paramInt == 1)) {
      ((ImageButton)localObject).setContentDescription(((ImageButton)localObject).getContext().getString(2131696736));
    }
    for (;;)
    {
      switch (paramInt)
      {
      default: 
        return;
      case 1: 
        showUploadScanning(paramView, localTextView, (ImageButton)localObject);
        return;
        ((ImageButton)localObject).setContentDescription(((ImageButton)localObject).getContext().getString(2131718842));
      }
    }
    showUploadScanning(paramView, localTextView, (ImageButton)localObject);
    return;
    showUploadPause(paramView, localTextView, (ImageButton)localObject);
    return;
    if (!TextUtils.isEmpty(paramString)) {
      localTextView.setText(paramString);
    }
    showUploadError(paramView, localTextView, (ImageButton)localObject);
  }
  
  private void showUploadPause(ProgressBar paramProgressBar, TextView paramTextView, ImageButton paramImageButton)
  {
    paramProgressBar.setVisibility(0);
    paramTextView.setVisibility(8);
    paramImageButton.setImageResource(2130850470);
  }
  
  private void showUploadScanning(ProgressBar paramProgressBar, TextView paramTextView, ImageButton paramImageButton)
  {
    paramProgressBar.setVisibility(0);
    paramTextView.setVisibility(8);
    paramImageButton.setImageResource(2130850473);
  }
  
  private void updateItemView(View paramView, FtnUploadInfo paramFtnUploadInfo)
  {
    if (this.uploadItemsView.containsKey(paramFtnUploadInfo)) {
      this.uploadItemsView.remove(paramFtnUploadInfo);
    }
    this.uploadItemsView.put(paramFtnUploadInfo, paramView);
  }
  
  private void updateProgress(SmoothProgressBar paramSmoothProgressBar, String paramString, int paramInt1, int paramInt2)
  {
    paramSmoothProgressBar.setTag(paramString);
    paramSmoothProgressBar.setSchedule(paramInt1);
    paramSmoothProgressBar.setProgress(paramInt2);
    paramSmoothProgressBar.setProgressSmooth(paramInt1, false);
  }
  
  public void addFakeNewItem(FtnUploadInfo arg1)
  {
    if (??? != null)
    {
      int i = FtnCommonUtils.getExpireTimeFromNowSecond((int)FtnListActivity.mPreserverDay);
      FtnNewInfo localFtnNewInfo = new FtnNewInfo(???.getFid(), ???.getName(), ???.getSha(), ???.getCreateTime(), i, ???.getFileSize(), ???.getOriginalPath());
      synchronized (this.fakeNewItems)
      {
        this.fakeNewItems.add(0, localFtnNewInfo);
        this.fakeNewItemIndex.put(localFtnNewInfo.getFid(), localFtnNewInfo);
        return;
      }
    }
  }
  
  public void addUnFinishUploadFile(FtnUploadInfo paramFtnUploadInfo)
  {
    this.unFinishUploadFiles.add(paramFtnUploadInfo);
  }
  
  public void changeUploadItemViewState(View paramView, int paramInt)
  {
    if (paramView != null) {
      showUploadItemState(paramView, paramInt);
    }
  }
  
  public void changeUploadItemViewState(FtnUploadInfo paramFtnUploadInfo)
  {
    View localView = getVisibleView(paramFtnUploadInfo);
    if (localView != null) {
      showUploadItemState(localView, paramFtnUploadInfo.getState());
    }
  }
  
  public void changeUploadItemViewState(FtnUploadInfo paramFtnUploadInfo, String paramString)
  {
    View localView = getVisibleView(paramFtnUploadInfo);
    if (localView != null) {
      showUploadItemState(localView, paramFtnUploadInfo.getState(), paramString);
    }
  }
  
  public void clearFtnCache()
  {
    this.uploadItems.clear();
    this.fakeNewItems.clear();
    this.uploadThumbCache.clear();
    this.resetViewsFinish.clear();
    this.uploadItemsView.clear();
    this.fakeNewItemIndex.clear();
  }
  
  public int getCount()
  {
    int j = this.fakeNewItems.size();
    if (this.mFtnUI != null) {}
    for (int i = this.mFtnUI.getCount();; i = 0) {
      return i + (j + this.uploadItems.size());
    }
  }
  
  public FtnUploadInfo getCurrentFtnUploadInfo()
  {
    return this.selectUploadData;
  }
  
  public FtnUploadInfo getCurrentFtnUploadItemData()
  {
    return this.selectUploadData;
  }
  
  public FtnUI getFtnUI()
  {
    return this.mFtnUI;
  }
  
  public Object getItem(int paramInt)
  {
    int i = this.uploadItems.size();
    int j = this.fakeNewItems.size();
    if ((i > 0) && (i > paramInt)) {
      return this.uploadItems.get(paramInt);
    }
    if ((j > 0) && (i + j > paramInt)) {
      return this.fakeNewItems.get(paramInt - i);
    }
    return this.mFtnUI.get(paramInt - i - j);
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public int getItemViewType(int paramInt)
  {
    Object localObject = getItem(paramInt);
    if ((localObject instanceof FtnNewInfo)) {
      return 0;
    }
    if ((localObject instanceof FileInfo)) {
      return 2;
    }
    return 1;
  }
  
  public FtnUploadInfo getUploadItem(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.uploadItems.size())) {
      return (FtnUploadInfo)this.uploadItems.get(paramInt);
    }
    return null;
  }
  
  public int getUploadItemCount()
  {
    return this.uploadItems.size();
  }
  
  public ArrayList<FtnUploadInfo> getUploadItemList()
  {
    return this.uploadItems;
  }
  
  public View getUploadItemView(FtnUploadInfo paramFtnUploadInfo)
  {
    if (this.uploadItemsView.containsKey(paramFtnUploadInfo)) {
      return (View)this.uploadItemsView.get(paramFtnUploadInfo);
    }
    return null;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject1 = getItem(paramInt);
    View localView;
    if ((localObject1 instanceof FileInfo))
    {
      localObject1 = (FileInfo)localObject1;
      if ((paramView != null) && ((paramView.getTag() instanceof ItemViewHolder))) {
        break label616;
      }
      localView = inflateViewByRes(2131559356, paramViewGroup);
      buildNormalItemViewHolder(localView, paramInt);
    }
    for (;;)
    {
      Object localObject2 = (ItemViewHolder)localView.getTag();
      if (((ItemViewHolder)localObject2).needInflate)
      {
        localView = inflateViewByRes(2131559356, paramViewGroup);
        buildNormalItemViewHolder(localView, paramInt);
      }
      for (;;)
      {
        ((QMListItemView)localView).bindItemChevron(((ItemViewHolder)localObject2).chevron);
        ((ItemViewHolder)localObject2).position = paramInt;
        setViewHolderParams(localView, paramInt, (ItemViewHolder)localObject2, (FileInfo)localObject1);
        EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
        return localView;
        if ((localObject1 instanceof FtnUploadInfo))
        {
          this.isResetView = false;
          localObject2 = (FtnUploadInfo)localObject1;
          if ((paramView != null) && ((paramView.getTag() instanceof UploadViewHolder)) && (!((UploadViewHolder)paramView.getTag()).needInflate)) {
            break label607;
          }
          localView = inflateViewByRes(2131559357, paramViewGroup);
          buildUploadItemViewHolder((FtnUploadInfo)localObject2, localView, paramInt);
        }
        for (;;)
        {
          UploadViewHolder localUploadViewHolder = (UploadViewHolder)localView.getTag();
          showUploadItemState(localView, ((FtnUploadInfo)localObject2).getState());
          int i;
          if ((!this.isResetView) && (isResetUploadPb(localUploadViewHolder, (FtnUploadInfo)localObject2)))
          {
            i = ((FtnUploadInfo)localObject2).getProgress();
            int j = FtnCommonUtils.calcProgress(((FtnUploadInfo)localObject2).getUploadedSize(), ((FtnUploadInfo)localObject2).getFileSize(), 0.92D);
            if (i != 0) {
              break label604;
            }
            i = j;
          }
          label296:
          label327:
          label598:
          label604:
          for (;;)
          {
            if ((((FtnUploadInfo)localObject2).getSchedule() > i) || (i + 1 >= 100))
            {
              localUploadViewHolder.progressBar.setPbCallback((ProgressBarCallback)localObject2);
              updateProgress(localUploadViewHolder.progressBar, ((FtnUploadInfo)localObject2).getName(), ((FtnUploadInfo)localObject2).getSchedule(), i);
              localUploadViewHolder.toggleButton.setTag(localObject1);
              fixToggleBtnStatus((FtnUploadInfo)localObject2, localUploadViewHolder.toggleButton);
              setUploadItemParams(localView, (FtnUploadInfo)localObject2, localUploadViewHolder);
              updateItemView(localView, (FtnUploadInfo)localObject2);
              if (!this.ftnListActivity.isEditing()) {
                break label449;
              }
              localView.setEnabled(false);
              localView.findViewById(2131367779).setVisibility(0);
            }
            for (;;)
            {
              localView.setOnClickListener(null);
              localView.setOnLongClickListener(null);
              break;
              break label296;
              localUploadViewHolder.progressBar.setPbCallback((ProgressBarCallback)localObject2);
              updateProgress(localUploadViewHolder.progressBar, ((FtnUploadInfo)localObject2).getName(), ((FtnUploadInfo)localObject2).getSchedule(), ((FtnUploadInfo)localObject2).getProgress());
              break label327;
              localView.setEnabled(true);
              localView.findViewById(2131367779).setVisibility(8);
            }
            if ((localObject1 instanceof FtnNewInfo))
            {
              localObject1 = (FtnNewInfo)localObject1;
              if ((paramView != null) && ((paramView.getTag() instanceof ItemViewHolder))) {
                break label598;
              }
              localView = inflateViewByRes(2131559356, paramViewGroup);
              buildNormalItemViewHolder(localView, paramInt);
            }
            for (;;)
            {
              localObject2 = (ItemViewHolder)localView.getTag();
              ((QMListItemView)localView).bindItemChevron(((ItemViewHolder)localObject2).chevron);
              setFakeHolderParams(localView, (ItemViewHolder)localObject2, (FtnNewInfo)localObject1);
              localView.setOnClickListener(null);
              localView.setOnLongClickListener(null);
              break;
              throw new DevRuntimeException("param type error " + String.valueOf(localObject1));
              localView = paramView;
            }
          }
          label449:
          label607:
          localView = paramView;
        }
      }
      label616:
      localView = paramView;
    }
  }
  
  public int getViewTypeCount()
  {
    return 3;
  }
  
  public View getVisibleView(FtnUploadInfo paramFtnUploadInfo)
  {
    ValidateHelper.notNull(paramFtnUploadInfo);
    int i = this.uploadItems.indexOf(paramFtnUploadInfo);
    int j = this.listView.getFirstVisiblePosition();
    if (i >= 0) {
      return this.listView.getChildAt(i + this.listView.getHeaderViewsCount() - j);
    }
    return null;
  }
  
  public void initResetViewState(String paramString)
  {
    ValidateHelper.notNullAndNotEmpty(paramString);
    if (!this.resetViewsFinish.containsKey(paramString)) {
      this.resetViewsFinish.put(paramString, Boolean.valueOf(true));
    }
  }
  
  public boolean isUnFinishUploadFile(FtnUploadInfo paramFtnUploadInfo)
  {
    return this.unFinishUploadFiles.contains(paramFtnUploadInfo);
  }
  
  public void putUploadItem(FtnUploadInfo paramFtnUploadInfo)
  {
    ValidateHelper.notNull(paramFtnUploadInfo);
    this.uploadItems.add(0, paramFtnUploadInfo);
  }
  
  public void putUploadItemsPause(List<FtnUploadInfo> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      FtnUploadInfo localFtnUploadInfo = (FtnUploadInfo)paramList.next();
      if ((TextUtils.isEmpty(localFtnUploadInfo.getFid())) || (TextUtils.isEmpty(localFtnUploadInfo.getKey())) || (localFtnUploadInfo.getProgress() >= 100))
      {
        QMLog.log(5, TAG, "delete invalid item: " + localFtnUploadInfo.getName() + ", " + localFtnUploadInfo.getProgress() + ", " + localFtnUploadInfo.getUploadedSize() + "/" + localFtnUploadInfo.getFileSize() + ", " + localFtnUploadInfo.getRid());
        FtnManager.sharedInstance().deleteUploadInfo(localFtnUploadInfo.getRid());
      }
      else
      {
        localFtnUploadInfo.setSchedule(localFtnUploadInfo.getProgress());
        localFtnUploadInfo.setOriginalPath(localFtnUploadInfo.getAbsolutePath());
        localFtnUploadInfo.setListActivity(this.ftnListActivity);
        switch (localFtnUploadInfo.getStage())
        {
        default: 
          localFtnUploadInfo.setState(1);
        }
        for (;;)
        {
          if (!this.unFinishUploadFiles.contains(localFtnUploadInfo)) {
            addUnFinishUploadFile(localFtnUploadInfo);
          }
          putUploadItem(localFtnUploadInfo);
          this.ftnListActivity.updateRealPause(localFtnUploadInfo.getFid(), true);
          FtnManager.sharedInstance().insertUploadData(localFtnUploadInfo.getFid(), localFtnUploadInfo);
          break;
          localFtnUploadInfo.setState(3);
        }
      }
    }
    notifyDataSetChanged();
  }
  
  public void putUploadItemsUnFinish(List<FtnUploadInfo> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      FtnUploadInfo localFtnUploadInfo = (FtnUploadInfo)paramList.next();
      if ((localFtnUploadInfo.getSchedule() < 100) && (localFtnUploadInfo.getState() != 8))
      {
        localFtnUploadInfo.setListActivity(this.ftnListActivity);
        if (!this.unFinishUploadFiles.contains(localFtnUploadInfo)) {
          addUnFinishUploadFile(localFtnUploadInfo);
        }
        putUploadItem(localFtnUploadInfo);
      }
    }
    notifyDataSetChanged();
  }
  
  public void removeFakeNewItem(String paramString)
  {
    if (this.fakeNewItemIndex.keySet().contains(paramString))
    {
      FtnNewInfo localFtnNewInfo = (FtnNewInfo)this.fakeNewItemIndex.get(paramString);
      if (this.fakeNewItems.contains(localFtnNewInfo))
      {
        this.fakeNewItems.remove(localFtnNewInfo);
        this.fakeNewItemIndex.remove(paramString);
      }
    }
  }
  
  public void removeUnFinishUploadFile(FtnUploadInfo paramFtnUploadInfo)
  {
    this.unFinishUploadFiles.remove(paramFtnUploadInfo);
  }
  
  public void removeUploadItemData(ArrayList<FtnUploadInfo> paramArrayList, FtnUploadInfo paramFtnUploadInfo, boolean paramBoolean)
  {
    ValidateHelper.notNull(paramFtnUploadInfo);
    FtnManager.sharedInstance().deleteUploadInfo(paramFtnUploadInfo.getRid());
    removeUnFinishUploadFile(paramFtnUploadInfo);
    if (paramArrayList.contains(paramFtnUploadInfo))
    {
      paramArrayList.remove(paramFtnUploadInfo);
      if (paramBoolean) {
        addFakeNewItem(paramFtnUploadInfo);
      }
      notifyDataSetChanged();
    }
    if (getUploadItemCount() == 0) {
      FtnManager.sharedInstance().getList();
    }
  }
  
  public void replaceFakeItem2Real(FtnUI paramFtnUI)
  {
    int j = paramFtnUI.getCount();
    int i = 0;
    if (i < j)
    {
      FileInfo localFileInfo = paramFtnUI.get(i);
      if (localFileInfo == null) {}
      for (;;)
      {
        i += 1;
        break;
        removeFakeNewItem(localFileInfo.fid);
      }
    }
  }
  
  public void setFtnUI(FtnUI paramFtnUI)
  {
    ValidateHelper.notNull(paramFtnUI);
    if (this.mFtnUI != null)
    {
      this.mFtnUI.release();
      this.mFtnUI = null;
    }
    this.mFtnUI = paramFtnUI;
    replaceFakeItem2Real(this.mFtnUI);
    notifyDataSetChanged();
  }
  
  public void setUploadViewHolderState(View paramView, int paramInt)
  {
    if ((paramView == null) || (paramInt < 0)) {}
    do
    {
      do
      {
        return;
        localObject = paramView.getTag();
      } while (!(localObject instanceof UploadViewHolder));
      Object localObject = (UploadViewHolder)localObject;
      ((UploadViewHolder)localObject).state = paramInt;
      paramView.setTag(localObject);
      if (paramInt == 4)
      {
        Log.d(TAG, "upload-state change status -> error");
        return;
      }
      if (paramInt == 3)
      {
        Log.d(TAG, "upload-state change status -> pause");
        return;
      }
      if (paramInt == 1)
      {
        Log.d(TAG, "upload-state change status -> scanning");
        return;
      }
    } while (paramInt != 2);
    Log.d(TAG, "upload-state change status -> uploading");
  }
  
  public void updateUploadProgressBar(FtnUploadInfo paramFtnUploadInfo, int paramInt, double paramDouble)
    throws IllegalThreadStateException
  {
    if (paramFtnUploadInfo == null) {
      return;
    }
    notifyDataSetChanged();
  }
  
  public static class ItemViewHolder
  {
    public ImageView chevron = null;
    public TextView ftn_expiretime = null;
    public TextView ftn_filename = null;
    public TextView ftn_filesize = null;
    public ImageView ftn_thumbnail = null;
    public boolean needInflate;
    public int position;
  }
  
  public static class UploadViewHolder
  {
    public TextView filename;
    public TextView filesize;
    public boolean needInflate;
    public SmoothProgressBar progressBar;
    public String sha;
    public int state = 1;
    public ImageButton toggleButton;
    public TextView uploadFailed;
    public ImageView upload_thumbnail;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.ftn.activity.FtnListAdapter
 * JD-Core Version:    0.7.0.1
 */