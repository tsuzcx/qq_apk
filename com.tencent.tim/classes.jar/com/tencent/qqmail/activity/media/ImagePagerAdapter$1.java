package com.tencent.qqmail.activity.media;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.attachment.model.AttachPreviewType;
import com.tencent.qqmail.attachment.util.IntentUtil;
import com.tencent.qqmail.utilities.fileextention.FileUtil;

class ImagePagerAdapter$1
  implements View.OnClickListener
{
  ImagePagerAdapter$1(ImagePagerAdapter paramImagePagerAdapter) {}
  
  public void onClick(View paramView)
  {
    if ((paramView.getTag() instanceof MediaItemInfo))
    {
      MediaItemInfo localMediaItemInfo = (MediaItemInfo)paramView.getTag();
      IntentUtil.openFile((Activity)ImagePagerAdapter.access$000(this.this$0), localMediaItemInfo.getDataPath(), FileUtil.getFileNameSuffix(localMediaItemInfo.getFileName()), AttachPreviewType.LocalVideoAttachPreview);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.media.ImagePagerAdapter.1
 * JD-Core Version:    0.7.0.1
 */