package com.tencent.qqmail.activity.media;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.protocol.DataCollector;
import java.util.List;

class MeidaBigBucketSelectActivity$6
  implements View.OnClickListener
{
  MeidaBigBucketSelectActivity$6(MeidaBigBucketSelectActivity paramMeidaBigBucketSelectActivity) {}
  
  public void onClick(View paramView)
  {
    if (MediaData.getSelectedInfoList().size() == 0)
    {
      ((CheckBox)this.this$0.findViewById(2131363423)).setChecked(true);
      MediaData.selectItem((MediaItemInfo)MeidaBigBucketSelectActivity.access$300(this.this$0).get(MeidaBigBucketSelectActivity.access$500(this.this$0)), true);
    }
    DataCollector.logEvent("Event_Album_Preview_Select");
    MeidaBigBucketSelectActivity.access$900(this.this$0, -1, null);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.media.MeidaBigBucketSelectActivity.6
 * JD-Core Version:    0.7.0.1
 */