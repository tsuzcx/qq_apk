package com.tencent.qqmail.activity.media;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import androidx.viewpager.widget.ViewPager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import java.util.List;

class MeidaBigBucketSelectActivity$5
  implements View.OnClickListener
{
  MeidaBigBucketSelectActivity$5(MeidaBigBucketSelectActivity paramMeidaBigBucketSelectActivity, CheckBox paramCheckBox, ImagePagerAdapter paramImagePagerAdapter) {}
  
  private boolean isMoreThanMaxSelectedNum()
  {
    return (MeidaBigBucketSelectActivity.access$800(this.this$0) != -1) && (MediaData.getSelectedInfoList().size() >= MeidaBigBucketSelectActivity.access$800(this.this$0));
  }
  
  public void onClick(View paramView)
  {
    int j = 0;
    if ((isMoreThanMaxSelectedNum()) && (this.val$checkbox.isChecked()))
    {
      this.val$checkbox.setChecked(false);
      if (MeidaBigBucketSelectActivity.access$600(this.this$0) == null) {
        MeidaBigBucketSelectActivity.access$602(this.this$0, MediaBucketGridActivity.createImageLimitDialog(this.this$0));
      }
      MeidaBigBucketSelectActivity.access$600(this.this$0).show();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      int i = MeidaBigBucketSelectActivity.access$200(this.this$0).getCurrentItem();
      boolean[] arrayOfBoolean = this.val$imagePageAdapter.getSelectedArray();
      if (arrayOfBoolean[i] == 0) {
        j = 1;
      }
      arrayOfBoolean[i] = j;
      MediaData.selectItem((MediaItemInfo)MeidaBigBucketSelectActivity.access$300(this.this$0).get(i), arrayOfBoolean[i]);
      MeidaBigBucketSelectActivity.access$700(this.this$0);
      MeidaBigBucketSelectActivity.access$400(this.this$0, i);
      if (arrayOfBoolean[i] != 0) {
        DataCollector.logEvent("Event_compose_Add_Preview");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.media.MeidaBigBucketSelectActivity.5
 * JD-Core Version:    0.7.0.1
 */