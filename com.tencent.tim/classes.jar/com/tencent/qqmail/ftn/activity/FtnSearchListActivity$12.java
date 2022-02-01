package com.tencent.qqmail.ftn.activity;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.ftn.Ftn.FileInfo;
import com.tencent.qqmail.model.qmdomain.MailBigAttach;

class FtnSearchListActivity$12
  implements AdapterView.OnItemClickListener
{
  FtnSearchListActivity$12(FtnSearchListActivity paramFtnSearchListActivity) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    synchronized (FtnSearchListActivity.access$600(this.this$0).getAdapter())
    {
      Object localObject = ???.getItem(paramInt);
      if ((localObject instanceof FileInfo))
      {
        localObject = (FileInfo)localObject;
        localObject = FtnSearchListActivity.access$2000(this.this$0, (FileInfo)localObject);
        FtnSearchListActivity.access$2100(this.this$0, (MailBigAttach)localObject, paramInt);
      }
      EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.ftn.activity.FtnSearchListActivity.12
 * JD-Core Version:    0.7.0.1
 */