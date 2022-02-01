package com.tencent.qqmail.download.activity;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.moai.downloader.file.DownloadFileUtil;
import com.tencent.moai.downloader.model.DownloadTask;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.attachment.QMAttachManager;
import com.tencent.qqmail.attachment.model.Attach;
import com.tencent.qqmail.attachment.model.AttachPreview;
import com.tencent.qqmail.attachment.model.AttachType;
import com.tencent.qqmail.attachment.util.QMAttachUtils;
import com.tencent.qqmail.download.AttachDownloadManager;
import com.tencent.qqmail.download.ImageDownloadManager;
import com.tencent.qqmail.download.cursor.DownloadInfoCursor;
import com.tencent.qqmail.download.listener.OnStateClickListener;
import com.tencent.qqmail.download.model.DownloadInfo;
import com.tencent.qqmail.download.util.DownloadUtil;
import com.tencent.qqmail.ftn.util.FtnCommonUtils;
import com.tencent.qqmail.model.qmdomain.MailBigAttach;
import com.tencent.qqmail.qmui.view.QMUIProgressBar;
import com.tencent.qqmail.trd.guava.Lists;
import com.tencent.qqmail.utilities.fileextention.FileUtil;
import com.tencent.qqmail.utilities.imageextention.ImageResourceUtil;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkConfig;
import com.tencent.qqmail.utilities.stringextention.StringExtention;
import com.tencent.qqmail.utilities.thread.Threads;
import com.tencent.qqmail.utilities.ui.HorizontalScrollItemView;
import com.tencent.qqmail.utilities.ui.ItemScrollListView;
import com.tencent.qqmail.utilities.ui.ItemScrollListView.ItemScrollAdapter;
import com.tencent.qqmail.utilities.validate.ValidateHelper;
import com.tencent.qqmail.view.QMListItemView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;

public class DownloadAdapter
  extends BaseAdapter
  implements ItemScrollListView.ItemScrollAdapter
{
  private static final String TAG = "DownloadAdapter";
  private DownloadInfoCursor cursor;
  private boolean isEditMode = false;
  private Context mContext;
  private OnStateClickListener onStateClickListener;
  private ArrayList<DownloadInfo> selectDownloadInfo = Lists.newArrayList();
  
  public DownloadAdapter(Context paramContext, DownloadInfoCursor paramDownloadInfoCursor, boolean paramBoolean)
  {
    this.mContext = paramContext;
    this.cursor = paramDownloadInfoCursor;
    this.isEditMode = paramBoolean;
  }
  
  private void fillViewHolder(DownloadInfo paramDownloadInfo, ViewHolder paramViewHolder, int paramInt)
  {
    paramViewHolder.mAttachTitleView.setText(paramDownloadInfo.getFileName());
    paramViewHolder.mAttachInfoView.setText(DownloadUtil.getSizeAndDate(paramDownloadInfo));
    paramViewHolder.position = paramInt;
    if (paramDownloadInfo.getStatus() == 4)
    {
      paramViewHolder.mViewStub.setVisibility(8);
      return;
    }
    QMUIProgressBar localQMUIProgressBar;
    ImageView localImageView;
    if ((paramViewHolder.mViewStub instanceof ViewStub))
    {
      paramViewHolder.mViewStub = ((ViewStub)paramViewHolder.mViewStub).inflate();
      localQMUIProgressBar = (QMUIProgressBar)paramViewHolder.mViewStub.findViewById(2131373659);
      localImageView = (ImageView)paramViewHolder.mViewStub.findViewById(2131378709);
      if (paramDownloadInfo.getAttachType() == 2) {
        break label233;
      }
      DownloadInfo localDownloadInfo = AttachDownloadManager.shareInstance().getDownloadInfoByKey(paramDownloadInfo.getKey());
      if (localDownloadInfo == null) {
        break label187;
      }
      localQMUIProgressBar.initProcess((int)(localDownloadInfo.getDownloadSize() * 100.0D / paramDownloadInfo.getFileSize()));
      localImageView.setImageResource(2130840765);
      localImageView.setTag(Boolean.valueOf(true));
    }
    for (;;)
    {
      localImageView.setOnClickListener(new DownloadAdapter.1(this, paramViewHolder, paramInt));
      return;
      paramViewHolder.mViewStub.setVisibility(0);
      break;
      label187:
      localQMUIProgressBar.initProcess((int)(DownloadFileUtil.getTmpFileSize(DownloadUtil.getDownloadTaskId(paramDownloadInfo.getKey())) * 100.0D / paramDownloadInfo.getFileSize()));
      localImageView.setImageResource(2130840764);
      localImageView.setTag(Boolean.valueOf(false));
      continue;
      label233:
      localQMUIProgressBar.initProcess((int)(DownloadFileUtil.getTmpFileSize(DownloadTask.generateHashId(paramDownloadInfo.getFid(), "ftn")) * 100.0D / paramDownloadInfo.getFileSize()));
      if (paramDownloadInfo.getStatus() == 2)
      {
        localImageView.setImageResource(2130840765);
        localImageView.setTag(Boolean.valueOf(true));
      }
      else
      {
        localImageView.setImageResource(2130840764);
        localImageView.setTag(Boolean.valueOf(false));
      }
    }
  }
  
  private Attach generateFtnAttach(DownloadInfo paramDownloadInfo)
  {
    MailBigAttach localMailBigAttach = new MailBigAttach(false);
    localMailBigAttach.setHashId(Attach.generateHashId(0L, paramDownloadInfo.getFileSize() + "", paramDownloadInfo.getFid()));
    localMailBigAttach.setFid(paramDownloadInfo.getFid());
    localMailBigAttach.setAccountId(paramDownloadInfo.getAccountId());
    localMailBigAttach.setName(paramDownloadInfo.getFileName());
    localMailBigAttach.setSize(paramDownloadInfo.getFileSize() + "");
    localMailBigAttach.getPreview().setMyDisk(paramDownloadInfo.getFilePath());
    localMailBigAttach.getPreview().setDownloadUrl(paramDownloadInfo.getUrl());
    Account localAccount = AccountManager.shareInstance().getAccountList().getAccountById(paramDownloadInfo.getAccountId());
    if (localAccount != null) {
      localMailBigAttach.getPreview().setIcon(FtnCommonUtils.getThumbUrl(localAccount.getUin(), paramDownloadInfo.getFid(), "2", "2", localAccount.getId()));
    }
    return localMailBigAttach;
  }
  
  private Attach generateZipInnerAttach(DownloadInfo paramDownloadInfo)
  {
    Attach localAttach = new Attach(false);
    localAttach.setHashId(Attach.generateHashId(paramDownloadInfo.getMailId(), paramDownloadInfo.getFileSize() + "", paramDownloadInfo.getUrl()));
    localAttach.setAccountId(paramDownloadInfo.getAccountId());
    localAttach.setName(paramDownloadInfo.getFileName());
    localAttach.setSize(paramDownloadInfo.getFileSize() + "");
    localAttach.getPreview().setMyDisk(paramDownloadInfo.getFilePath());
    localAttach.getPreview().setDownloadUrl(paramDownloadInfo.getUrl());
    return localAttach;
  }
  
  private int getViewHolderPosition(View paramView)
  {
    paramView = paramView.getTag();
    if ((paramView instanceof ViewHolder)) {
      return ((ViewHolder)paramView).position;
    }
    return -1;
  }
  
  private boolean isItemViewSelected(DownloadInfo paramDownloadInfo)
  {
    Iterator localIterator = this.selectDownloadInfo.iterator();
    while (localIterator.hasNext()) {
      if (((DownloadInfo)localIterator.next()).getId() == paramDownloadInfo.getId()) {
        return true;
      }
    }
    return false;
  }
  
  private void selectDownloadInfo(DownloadInfo paramDownloadInfo)
  {
    this.selectDownloadInfo.add(paramDownloadInfo);
  }
  
  private void setThumbByType(ImageView paramImageView, String paramString)
  {
    paramImageView.setImageResource(ImageResourceUtil.getImageResource(paramString, ImageResourceUtil.IMAGE_SIZE_58));
  }
  
  private void setThumbnail(View paramView, ImageView paramImageView, int paramInt, Attach paramAttach)
  {
    if ((paramImageView == null) || (paramAttach == null)) {}
    String str;
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              str = AttachType.valueOf(QMAttachUtils.attachFileType(FileUtil.getFileNameSuffix(paramAttach.getName()))).name().toLowerCase(Locale.getDefault());
              if ((!str.equals("image")) || (paramAttach.isProtocol()) || (FileUtil.isFileTypeTiff(paramAttach.getName()))) {
                break;
              }
              setThumbByType(paramImageView, str);
            } while (paramAttach.getPreview() == null);
            str = paramAttach.getPreview().getIcon();
          } while (StringExtention.isNullOrEmpty(str));
          str = QMNetworkConfig.getCgiRequestHost(paramAttach.getAccountId()) + str;
          int i = ImageDownloadManager.shareInstance().isThumbBitmapExistLocal(str);
          if ((i != 2) && (i != 1)) {
            break;
          }
          paramView = ImageDownloadManager.shareInstance().getThumbBitmapFromLocal(str);
        } while (paramView == null);
        paramImageView.setImageDrawable(new BitmapDrawable(this.mContext.getResources(), paramView));
        return;
        DownloadInfo localDownloadInfo = new DownloadInfo();
        localDownloadInfo.setAccountId(paramAttach.getAccountId());
        localDownloadInfo.setUrl(str);
        localDownloadInfo.setImageDownloadListener(new DownloadAdapter.2(this, str, paramInt, paramView, paramImageView));
        ImageDownloadManager.shareInstance().fetchImage(localDownloadInfo);
        return;
        if ((!str.equals("image")) || (!paramAttach.isProtocol()) || (FileUtil.isFileTypeTiff(paramAttach.getName()))) {
          break;
        }
        setThumbByType(paramImageView, str);
      } while (paramAttach.getPreview() == null);
      paramAttach = paramAttach.getPreview().getMyDisk();
    } while (StringExtention.isNullOrEmpty(paramAttach));
    ImageDownloadManager.shareInstance().getProtocolImageBitmap(paramAttach, new DownloadAdapter.3(this, paramAttach, paramInt, paramView, paramImageView));
    return;
    setThumbByType(paramImageView, str);
  }
  
  private void unSelectDownloadInfo(DownloadInfo paramDownloadInfo)
  {
    Iterator localIterator = this.selectDownloadInfo.iterator();
    while (localIterator.hasNext())
    {
      DownloadInfo localDownloadInfo = (DownloadInfo)localIterator.next();
      if (localDownloadInfo.getId() == paramDownloadInfo.getId()) {
        this.selectDownloadInfo.remove(localDownloadInfo);
      }
    }
  }
  
  public void changeDownloadState(ViewHolder paramViewHolder, int paramInt)
  {
    boolean bool1;
    if (paramViewHolder != null)
    {
      paramViewHolder = (ImageView)paramViewHolder.mViewStub.findViewById(2131378709);
      if (paramViewHolder != null)
      {
        if (((Boolean)paramViewHolder.getTag()).booleanValue()) {
          break label85;
        }
        bool1 = true;
        if (getOnStateClickListener() == null) {
          break label105;
        }
      }
    }
    label85:
    label105:
    for (boolean bool2 = getOnStateClickListener().onClick(paramInt, getAttachByPosition(paramInt), bool1);; bool2 = false)
    {
      if (bool2)
      {
        if (bool1)
        {
          paramViewHolder.setImageResource(2130840765);
          paramViewHolder.setTag(Boolean.valueOf(true));
        }
      }
      else
      {
        return;
        bool1 = false;
        break;
      }
      paramViewHolder.setImageResource(2130840764);
      paramViewHolder.setTag(Boolean.valueOf(false));
      return;
    }
  }
  
  public Attach getAttachByDownloadInfo(DownloadInfo paramDownloadInfo)
  {
    if (paramDownloadInfo != null)
    {
      int i = paramDownloadInfo.getAttachType();
      if (i == 1) {
        return QMAttachManager.sharedInstance().getBigAttach(paramDownloadInfo.getAttachId());
      }
      if ((i == 3) || (i == 0)) {
        return QMAttachManager.sharedInstance().getAttach(paramDownloadInfo.getAttachId());
      }
      if (i == 2) {
        return generateFtnAttach(paramDownloadInfo);
      }
      if (i == 4) {
        return generateZipInnerAttach(paramDownloadInfo);
      }
    }
    return null;
  }
  
  public Attach getAttachByPosition(int paramInt)
  {
    Attach localAttach = getAttachByDownloadInfo(getItem(paramInt));
    ValidateHelper.notNull(localAttach);
    return localAttach;
  }
  
  public int getCount()
  {
    if (this.cursor == null) {
      return -1;
    }
    return this.cursor.getCount();
  }
  
  public DownloadInfo getItem(int paramInt)
  {
    if (this.cursor != null) {
      return this.cursor.getItem(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    DownloadInfo localDownloadInfo = getItem(paramInt);
    if (localDownloadInfo == null) {
      return 0L;
    }
    return localDownloadInfo.getId();
  }
  
  public OnStateClickListener getOnStateClickListener()
  {
    return this.onStateClickListener;
  }
  
  public ArrayList<DownloadInfo> getSelectDownloadInfo()
  {
    return this.selectDownloadInfo;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject1;
    Object localObject2;
    label179:
    Attach localAttach;
    if (paramView == null)
    {
      paramView = new ViewHolder();
      localObject1 = LayoutInflater.from(this.mContext).inflate(2131559273, paramViewGroup, false);
      paramView.mAttachImgView = ((ImageView)((View)localObject1).findViewById(2131366084));
      paramView.mAttachTitleView = ((TextView)((View)localObject1).findViewById(2131366086));
      paramView.mAttachInfoView = ((TextView)((View)localObject1).findViewById(2131366088));
      paramView.mViewStub = ((View)localObject1).findViewById(2131366085);
      localObject2 = new TextView(this.mContext);
      ((TextView)localObject2).setId(2131377335);
      ((TextView)localObject2).setText(2131692498);
      ((TextView)localObject2).setVisibility(0);
      ItemScrollListView.formatRightViewStyle((TextView)localObject2, 1);
      localObject1 = new HorizontalScrollItemView((View)localObject1, new TextView[] { localObject2 });
      ((View)localObject1).setTag(paramView);
      localObject2 = (QMListItemView)((HorizontalScrollItemView)localObject1).getContentView();
      if (!this.isEditMode) {
        break label276;
      }
      ((QMListItemView)localObject2).setItemToEditMode();
      localObject2 = getItem(paramInt);
      fillViewHolder((DownloadInfo)localObject2, paramView, paramInt);
      localAttach = getAttachByPosition(paramInt);
      if ((localAttach != null) || (((DownloadInfo)localObject2).getStatus() == 4)) {
        break label284;
      }
      ((View)localObject1).setVisibility(8);
    }
    for (;;)
    {
      if (localAttach != null) {
        setThumbnail((View)localObject1, paramView.mAttachImgView, paramInt, localAttach);
      }
      EventCollector.getInstance().onListGetView(paramInt, (View)localObject1, paramViewGroup, getItemId(paramInt));
      return localObject1;
      localObject2 = (ViewHolder)paramView.getTag();
      localObject1 = paramView;
      paramView = (View)localObject2;
      break;
      label276:
      ((QMListItemView)localObject2).setItemToNormalMode();
      break label179;
      label284:
      ((View)localObject1).setVisibility(0);
    }
  }
  
  public boolean hasSelectUnCompleteInfo()
  {
    if ((this.selectDownloadInfo != null) && (this.selectDownloadInfo.size() > 0))
    {
      Iterator localIterator = this.selectDownloadInfo.iterator();
      while (localIterator.hasNext()) {
        if (!DownloadUtil.isDownloadInfoComplete((DownloadInfo)localIterator.next())) {
          return true;
        }
      }
    }
    return false;
  }
  
  public boolean isEditMode()
  {
    return this.isEditMode;
  }
  
  public int isEnabledScroll(int paramInt)
  {
    return 2;
  }
  
  public void setEditMode(boolean paramBoolean)
  {
    this.isEditMode = paramBoolean;
  }
  
  public void setOnStateClickListener(OnStateClickListener paramOnStateClickListener)
  {
    this.onStateClickListener = paramOnStateClickListener;
  }
  
  public boolean toggleSelect(int paramInt)
  {
    DownloadInfo localDownloadInfo = getItem(paramInt);
    if (!isItemViewSelected(localDownloadInfo))
    {
      selectDownloadInfo(localDownloadInfo);
      return true;
    }
    unSelectDownloadInfo(localDownloadInfo);
    return false;
  }
  
  public void updateProgress(ListView paramListView, int paramInt, long paramLong1, long paramLong2)
  {
    int k = paramListView.getHeaderViewsCount();
    int j = paramListView.getFirstVisiblePosition();
    int m = paramListView.getLastVisiblePosition();
    int i = j;
    for (;;)
    {
      if (i <= m)
      {
        if ((i >= k) && (getItem(i - k).getId() == paramInt)) {
          Threads.runOnMainThread(new DownloadAdapter.4(this, paramListView, i - j, paramLong1, paramLong2));
        }
      }
      else {
        return;
      }
      i += 1;
    }
  }
  
  class ViewHolder
  {
    ImageView mAttachImgView;
    TextView mAttachInfoView;
    TextView mAttachTitleView;
    View mViewStub;
    int position;
    
    ViewHolder() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.download.activity.DownloadAdapter
 * JD-Core Version:    0.7.0.1
 */