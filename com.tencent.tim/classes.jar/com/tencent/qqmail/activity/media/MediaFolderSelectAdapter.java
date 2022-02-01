package com.tencent.qqmail.activity.media;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class MediaFolderSelectAdapter
  extends ArrayAdapter<MediaItemInfo>
{
  private boolean canLoadImage;
  private final int[] coverCounts;
  private final int resId;
  
  public MediaFolderSelectAdapter(Context paramContext, int paramInt, List<MediaItemInfo> paramList, int[] paramArrayOfInt)
  {
    super(paramContext, paramInt, paramList);
    this.resId = paramInt;
    this.canLoadImage = true;
    this.coverCounts = paramArrayOfInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    if (paramView == null)
    {
      localView = LayoutInflater.from(getContext()).inflate(this.resId, null);
      paramView = new ViewHolder(null);
      paramView.imageView = ((ImageView)localView.findViewById(2131379638));
      paramView.bucketNameTV = ((TextView)localView.findViewById(2131371214));
      paramView.countTV = ((TextView)localView.findViewById(2131371213));
      localView.setTag(paramView);
    }
    for (;;)
    {
      Object localObject = (MediaItemInfo)getItem(paramInt);
      paramView.imageView.setId(((MediaItemInfo)localObject).getId());
      ((MediaItemInfo)localObject).loadPreviewThumbnail(paramView.imageView, this.canLoadImage, false);
      paramView.bucketNameTV.setText(((MediaItemInfo)localObject).getBucketName());
      if ((paramInt < this.coverCounts.length) && (this.coverCounts[paramInt] > 0)) {
        paramView.countTV.setText(this.coverCounts[paramInt] + "张");
      }
      EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
      return localView;
      localObject = (ViewHolder)paramView.getTag();
      localView = paramView;
      paramView = (View)localObject;
    }
  }
  
  public void setCanLoadImage(boolean paramBoolean)
  {
    this.canLoadImage = paramBoolean;
  }
  
  static class ViewHolder
  {
    TextView bucketNameTV;
    TextView countTV;
    ImageView imageView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.media.MediaFolderSelectAdapter
 * JD-Core Version:    0.7.0.1
 */