package com.tencent.qqmail.ftn.activity;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.model.QQMailAccount;
import com.tencent.qqmail.attachment.model.AttachType;
import com.tencent.qqmail.attachment.util.QMAttachUtils;
import com.tencent.qqmail.download.ImageDownloadManager;
import com.tencent.qqmail.download.model.DownloadInfo;
import com.tencent.qqmail.ftn.Ftn.FileInfo;
import com.tencent.qqmail.ftn.model.FtnUI;
import com.tencent.qqmail.ftn.util.FtnCommonUtils;
import com.tencent.qqmail.utilities.fileextention.FileUtil;
import com.tencent.qqmail.utilities.imageextention.ImageResourceUtil;
import com.tencent.qqmail.utilities.stringextention.StringExtention;
import com.tencent.qqmail.utilities.ui.QMUIKit;
import com.tencent.qqmail.utilities.validate.ValidateHelper;
import java.sql.Date;
import java.util.Locale;

public class FtnSearchListAdapter
  extends BaseAdapter
{
  private QQMailAccount account;
  private Context context;
  private FtnUI ftnUI = null;
  private LayoutInflater inflater;
  
  public FtnSearchListAdapter(Context paramContext)
  {
    this.context = paramContext;
    this.inflater = LayoutInflater.from(this.context);
    this.account = AccountManager.shareInstance().getAccountList().getDefaultFtnAccount();
  }
  
  private String getExpireTime(FileInfo paramFileInfo)
  {
    String str = FtnCommonUtils.getExpireTimeString(new Date(paramFileInfo.expiretime * 1000L));
    paramFileInfo = str;
    if (!str.equals("已过期"))
    {
      paramFileInfo = str;
      if (!str.equals("即将过期"))
      {
        paramFileInfo = str;
        if (!str.contains("小时")) {
          paramFileInfo = str + this.context.getString(2131694056);
        }
      }
    }
    return paramFileInfo;
  }
  
  private String getFileName(FileInfo paramFileInfo)
  {
    return paramFileInfo.filename;
  }
  
  private String getFileSize(FileInfo paramFileInfo)
  {
    long l2 = paramFileInfo.filesize;
    long l1 = l2;
    if (l2 < 0L)
    {
      l1 = Math.pow(2.0D, 31.0D);
      l1 = l2 + l1 + l1;
    }
    return StringExtention.getHumanReadableSizeString(l1);
  }
  
  private String getFileType(String paramString)
  {
    return AttachType.valueOf(QMAttachUtils.attachFileType(FileUtil.getFileNameSuffix(paramString))).name().toLowerCase(Locale.getDefault());
  }
  
  private int getViewHolderPosition(View paramView)
  {
    paramView = paramView.getTag();
    if ((paramView instanceof FtnListAdapter.ItemViewHolder)) {
      return ((FtnListAdapter.ItemViewHolder)paramView).position;
    }
    return -1;
  }
  
  private void setThumbByType(String paramString, ImageView paramImageView)
  {
    paramImageView.setImageResource(ImageResourceUtil.getImageResource(paramString, ImageResourceUtil.IMAGE_SIZE_58));
  }
  
  private void setThumbTypeImage(String paramString, ImageView paramImageView, View paramView, int paramInt)
  {
    int i = ImageDownloadManager.shareInstance().isThumbBitmapExistLocal(paramString);
    if ((i == 2) || (i == 1)) {
      paramImageView.setImageBitmap(ImageDownloadManager.shareInstance().getThumbBitmapFromLocal(paramString));
    }
    for (;;)
    {
      DownloadInfo localDownloadInfo = new DownloadInfo();
      localDownloadInfo.setUrl(paramString);
      localDownloadInfo.setImageDownloadListener(new FtnSearchListAdapter.1(this, paramInt, paramView, paramImageView));
      ImageDownloadManager.shareInstance().fetchImage(localDownloadInfo);
      return;
      paramImageView.setImageResource(2130840449);
    }
  }
  
  public int getCount()
  {
    return this.ftnUI.getCount();
  }
  
  public FileInfo getItem(int paramInt)
  {
    return this.ftnUI.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    FileInfo localFileInfo = getItem(paramInt);
    View localView;
    Object localObject;
    if ((paramView == null) || (paramView.getTag() == null))
    {
      localView = this.inflater.inflate(2131559356, paramViewGroup, false);
      paramView = new FtnListAdapter.ItemViewHolder();
      paramView.ftn_filename = ((TextView)localView.findViewById(2131367764));
      paramView.ftn_expiretime = ((TextView)localView.findViewById(2131367753));
      paramView.ftn_thumbnail = ((ImageView)localView.findViewById(2131367778));
      paramView.chevron = ((ImageView)localView.findViewById(2131364597));
      paramView.ftn_filesize = ((TextView)localView.findViewById(2131367765));
      paramView.position = paramInt;
      localView.setTag(paramView);
      paramView.ftn_filename.setText(getFileName(localFileInfo) + QMUIKit.ELLIPSIZE_FIXED);
      paramView.ftn_filesize.setText(getFileSize(localFileInfo));
      paramView.ftn_expiretime.setText(getExpireTime(localFileInfo));
      paramView.ftn_expiretime.setTextColor(this.context.getResources().getColorStateList(2131167519));
      paramView.position = paramInt;
      localObject = getFileType(getFileName(localFileInfo));
      if (!((String)localObject).equals("image")) {
        break label306;
      }
      setThumbTypeImage(FtnCommonUtils.getThumbUrl(this.account.getUin(), localFileInfo.fid, "2", "2", this.account.getId()), paramView.ftn_thumbnail, localView, paramInt);
    }
    for (;;)
    {
      EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
      return localView;
      localObject = (FtnListAdapter.ItemViewHolder)paramView.getTag();
      localView = paramView;
      paramView = (View)localObject;
      break;
      label306:
      setThumbByType((String)localObject, paramView.ftn_thumbnail);
    }
  }
  
  public boolean isUpdateThumbImage(int paramInt, View paramView)
  {
    int i = getViewHolderPosition(paramView);
    return (paramInt >= 0) && (paramInt < getCount()) && (paramInt == i) && (getItem(paramInt).filetype == 1);
  }
  
  public void setFtnUI(FtnUI paramFtnUI)
  {
    ValidateHelper.notNull(paramFtnUI);
    if (this.ftnUI != null)
    {
      this.ftnUI.release();
      this.ftnUI = null;
    }
    this.ftnUI = paramFtnUI;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.ftn.activity.FtnSearchListAdapter
 * JD-Core Version:    0.7.0.1
 */