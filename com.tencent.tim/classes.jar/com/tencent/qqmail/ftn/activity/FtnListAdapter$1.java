package com.tencent.qqmail.ftn.activity;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.ftn.FtnManager;
import com.tencent.qqmail.ftn.model.FtnUploadInfo;

class FtnListAdapter$1
  implements View.OnClickListener
{
  FtnListAdapter$1(FtnListAdapter paramFtnListAdapter) {}
  
  public void onClick(View paramView)
  {
    Log.v(FtnListAdapter.access$000(), "upload button onclick: " + FtnListAdapter.access$100(this.this$0).isEditing() + ", " + paramView.getTag());
    if (FtnListAdapter.access$100(this.this$0).isEditing()) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      Object localObject = paramView.getTag();
      if ((localObject == null) || ((localObject instanceof FtnUploadInfo)))
      {
        localObject = (FtnUploadInfo)localObject;
        FtnListAdapter.access$200(this.this$0, (FtnUploadInfo)localObject);
        int i = ((FtnUploadInfo)localObject).getState();
        String str = ((FtnUploadInfo)localObject).getFid();
        if (((FtnUploadInfo)localObject).getState() == 2)
        {
          FtnManager.sharedInstance().abortRequest(str);
          paramView.setContentDescription(paramView.getContext().getString(2131718842));
        }
        for (;;)
        {
          localObject = (ImageButton)paramView;
          switch (i)
          {
          default: 
            break;
          case 1: 
            ((ImageButton)localObject).setImageResource(2130850470);
            FtnListAdapter.access$100(this.this$0).showUploadDialog(3);
            break;
            paramView.setContentDescription(paramView.getContext().getString(2131696736));
          }
        }
        ((ImageButton)localObject).setImageResource(2130850470);
        FtnListAdapter.access$100(this.this$0).showUploadDialog(3);
        continue;
        FtnListAdapter.access$100(this.this$0).showUploadDialog(2);
        continue;
        FtnListAdapter.access$100(this.this$0).showUploadDialog(4);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.ftn.activity.FtnListAdapter.1
 * JD-Core Version:    0.7.0.1
 */