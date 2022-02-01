package com.tencent.moai.nativepages;

import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.moai.nativepages.download.AdLandingPagesDownloadResourceHelper.Callback;
import com.tencent.moai.nativepages.model.AdLandingPageInfo;
import com.tencent.moai.nativepages.util.UIUtil;
import java.util.LinkedList;

class AdLandingPagesUI$8
  implements AdLandingPagesDownloadResourceHelper.Callback
{
  AdLandingPagesUI$8(AdLandingPagesUI paramAdLandingPagesUI, AdLandingPageInfo paramAdLandingPageInfo, AdLandingPagesUI.ViewHolder paramViewHolder, View paramView, ImageView paramImageView) {}
  
  public void onDownloadError()
  {
    if ((this.val$pageInfo.backgroundColor != null) && (this.val$pageInfo.backgroundColor.length() > 0))
    {
      int i = Color.parseColor(this.val$pageInfo.backgroundColor);
      this.val$holder.bgIv.setVisibility(8);
      this.val$holder.bgIv.setBackgroundColor(i);
      this.val$holder.linearLayout.setBackgroundColor(i);
      this.val$convertView.setBackgroundColor(i);
      if (i + 16777216 > -1 - i) {
        break label142;
      }
      this.val$holder.nextBtn.setImageDrawable(UIUtil.getDrawable(this.this$0, 2130842302));
      if (AdLandingPagesUI.access$1200(this.this$0).getFirst() == this.val$pageInfo) {
        AdLandingPagesUI.access$1300(this.this$0).setImageDrawable(UIUtil.getDrawable(this.this$0, 2130842302));
      }
    }
    label142:
    do
    {
      return;
      this.val$holder.nextBtn.setImageDrawable(UIUtil.getDrawable(this.this$0, 2130842301));
    } while (AdLandingPagesUI.access$1200(this.this$0).getFirst() != this.val$pageInfo);
    AdLandingPagesUI.access$1300(this.this$0).setImageDrawable(UIUtil.getDrawable(this.this$0, 2130842301));
  }
  
  public void onDownloaded(String paramString)
  {
    paramString = BitmapFactory.decodeFile(paramString);
    if (paramString == null) {
      return;
    }
    this.val$imageView.setImageBitmap(paramString);
  }
  
  public void onStartDownload() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.nativepages.AdLandingPagesUI.8
 * JD-Core Version:    0.7.0.1
 */