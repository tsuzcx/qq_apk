package com.tencent.qqmail.activity.media;

import android.content.Context;
import android.content.res.Resources;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AbsListView.LayoutParams;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.model.media.QMAlbumManager.QMMediaIntentType;
import com.tencent.qqmail.utilities.imageextention.QMImageLoader;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class MediaBucketGridAdapter
  extends ArrayAdapter<MediaItemInfo>
{
  private static final String TAG = "MediaBucketGridAdapter";
  public static final int VIEW_TYPE_ITEM = 0;
  public static final int VIEW_TYPE_PHOTO = 1;
  private static int countPerLine;
  private static int imageMargin;
  private static QMAlbumManager.QMMediaIntentType intentType;
  private static int itemWidth;
  private static int lastColumnWidth;
  private static int screenWidth;
  private boolean canLoadImage;
  private ClickCheckBoxListener checkBoxListener;
  private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
  private List<MediaItemInfo> itemList;
  private int resId;
  private boolean[] selectedArray;
  private boolean supportCamera = false;
  
  public MediaBucketGridAdapter(Context paramContext, int paramInt, List<MediaItemInfo> paramList, QMAlbumManager.QMMediaIntentType paramQMMediaIntentType, boolean paramBoolean)
  {
    super(paramContext, paramInt, paramList);
    this.itemList = paramList;
    this.resId = paramInt;
    this.selectedArray = new boolean[paramList.size()];
    intentType = paramQMMediaIntentType;
    this.supportCamera = paramBoolean;
  }
  
  private View bindImageRadioData(View paramView, int paramInt)
  {
    ViewHolder localViewHolder;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(getContext()).inflate(2131559770, null);
      localViewHolder = new ViewHolder(null);
      localViewHolder.imageView = ((ImageView)paramView.findViewById(2131379631));
      paramView.setTag(localViewHolder);
      if (!this.supportCamera) {
        break label94;
      }
    }
    label94:
    for (int i = 1;; i = 0)
    {
      ((MediaItemInfo)getItem(paramInt - i)).loadPreviewThumbnail(localViewHolder.imageView, this.canLoadImage, false);
      return paramView;
      localViewHolder = (ViewHolder)paramView.getTag();
      break;
    }
  }
  
  private View bindMediaCheckBoxData(View paramView, int paramInt)
  {
    boolean bool = true;
    Object localObject;
    label101:
    MediaItemInfo localMediaItemInfo;
    label147:
    label165:
    View localView;
    Resources localResources;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(getContext()).inflate(this.resId, null);
      localObject = new ViewHolder(null);
      ((ViewHolder)localObject).imageView = ((ImageView)paramView.findViewById(2131379631));
      ((ViewHolder)localObject).checkBox = ((CheckBox)paramView.findViewById(2131369403));
      ((ViewHolder)localObject).videoView = ((ImageView)paramView.findViewById(2131381473));
      ((ViewHolder)localObject).mask = paramView.findViewById(2131371159);
      paramView.setTag(localObject);
      if (!this.supportCamera) {
        break label325;
      }
      i = 1;
      i = paramInt - i;
      localMediaItemInfo = (MediaItemInfo)getItem(i);
      localMediaItemInfo.loadPreviewThumbnail(((ViewHolder)localObject).imageView, this.canLoadImage, false);
      if (!localMediaItemInfo.isVideo()) {
        break label330;
      }
      ((ViewHolder)localObject).videoView.setVisibility(0);
      if ((i >= this.selectedArray.length) || (this.selectedArray[i] == 0)) {
        break label343;
      }
      localView = ((ViewHolder)localObject).mask;
      localResources = QMApplicationContext.sharedInstance().getResources();
      if (!bool) {
        break label349;
      }
    }
    label325:
    label330:
    label343:
    label349:
    for (int i = 2131165966;; i = 2131167595)
    {
      localView.setBackgroundColor(localResources.getColor(i));
      ((ViewHolder)localObject).checkBox.setChecked(bool);
      ((ViewHolder)localObject).checkBox.setTag(((ViewHolder)localObject).mask);
      localObject = ((ViewHolder)localObject).checkBox;
      ((CheckBox)localObject).setOnClickListener(new MediaBucketGridAdapter.1(this, paramInt, (CheckBox)localObject));
      if (localMediaItemInfo.getModifyDate() > 0L)
      {
        localObject = new Date(localMediaItemInfo.getModifyDate() * 1000L);
        paramView.setContentDescription(getContext().getString(2131720835) + this.dateFormat.format((Date)localObject));
      }
      return paramView;
      localObject = (ViewHolder)paramView.getTag();
      break;
      i = 0;
      break label101;
      ((ViewHolder)localObject).videoView.setVisibility(8);
      break label147;
      bool = false;
      break label165;
    }
  }
  
  private void squareConvertView(View paramView, int paramInt)
  {
    int i = itemWidth;
    AbsListView.LayoutParams localLayoutParams;
    if ((countPerLine != 0) && ((paramInt + 1) % countPerLine == 0))
    {
      paramInt = lastColumnWidth;
      localLayoutParams = (AbsListView.LayoutParams)paramView.getLayoutParams();
      if (localLayoutParams == null) {
        break label64;
      }
      localLayoutParams.width = paramInt;
      localLayoutParams.height = i;
    }
    for (;;)
    {
      paramView.setLayoutParams(localLayoutParams);
      return;
      paramInt = itemWidth;
      break;
      label64:
      localLayoutParams = new AbsListView.LayoutParams(paramInt, i);
    }
  }
  
  public int getCameraCnt()
  {
    if (this.supportCamera) {
      return 1;
    }
    return 0;
  }
  
  public int getItemViewType(int paramInt)
  {
    if ((paramInt == 0) && (this.supportCamera)) {
      return 1;
    }
    return 0;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (getItemViewType(paramInt) == 1)
    {
      if (paramView != null) {
        break label80;
      }
      paramView = LayoutInflater.from(getContext()).inflate(2131559531, paramViewGroup, false);
    }
    label80:
    for (;;)
    {
      squareConvertView(paramView, paramInt);
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
      if (intentType == QMAlbumManager.QMMediaIntentType.QMMediaIntentType_AVATAR) {
        paramView = bindImageRadioData(paramView, paramInt);
      } else {
        paramView = bindMediaCheckBoxData(paramView, paramInt);
      }
    }
  }
  
  public int getViewTypeCount()
  {
    return 2;
  }
  
  public void recycle()
  {
    QMImageLoader.getInstance().clearWaitingTasks(true);
  }
  
  public void setCanLoadImage(boolean paramBoolean)
  {
    this.canLoadImage = paramBoolean;
  }
  
  public void setClickCheckBoxListener(ClickCheckBoxListener paramClickCheckBoxListener)
  {
    this.checkBoxListener = paramClickCheckBoxListener;
  }
  
  public void setItemSize(int paramInt1, int paramInt2)
  {
    itemWidth = paramInt2;
    countPerLine = paramInt1;
    screenWidth = ((WindowManager)QMApplicationContext.sharedInstance().getSystemService("window")).getDefaultDisplay().getWidth();
    imageMargin = (int)QMApplicationContext.sharedInstance().getResources().getDimension(2131296863);
    lastColumnWidth = screenWidth - (itemWidth + imageMargin) * (countPerLine - 1);
  }
  
  public void setSelectedInfoList(List<MediaItemInfo> paramList)
  {
    Arrays.fill(this.selectedArray, false);
    int i = 0;
    if (i < paramList.size())
    {
      MediaItemInfo localMediaItemInfo = (MediaItemInfo)paramList.get(i);
      int j = this.itemList.indexOf(localMediaItemInfo);
      if ((j < 0) || (j >= this.selectedArray.length)) {}
      for (;;)
      {
        i += 1;
        break;
        this.selectedArray[j] = true;
      }
    }
    this.canLoadImage = true;
    notifyDataSetChanged();
  }
  
  public boolean toggleItem(int paramInt)
  {
    boolean[] arrayOfBoolean = this.selectedArray;
    if (this.selectedArray[paramInt] == 0) {}
    for (int i = 1;; i = 0)
    {
      arrayOfBoolean[paramInt] = i;
      return this.selectedArray[paramInt];
    }
  }
  
  public static abstract interface ClickCheckBoxListener
  {
    public abstract boolean canCheck(int paramInt, boolean paramBoolean);
    
    public abstract void onClick(int paramInt, boolean paramBoolean);
  }
  
  static class ViewHolder
  {
    CheckBox checkBox;
    ImageView imageView;
    View mask;
    ImageView videoView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.media.MediaBucketGridAdapter
 * JD-Core Version:    0.7.0.1
 */