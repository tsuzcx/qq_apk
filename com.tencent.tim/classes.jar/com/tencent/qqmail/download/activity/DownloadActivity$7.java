package com.tencent.qqmail.download.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.download.model.DownloadInfo;
import java.util.ArrayList;

class DownloadActivity$7
  implements View.OnClickListener
{
  DownloadActivity$7(DownloadActivity paramDownloadActivity) {}
  
  public void onClick(View paramView)
  {
    ArrayList localArrayList = DownloadActivity.access$600(this.this$0).getSelectDownloadInfo();
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      String[] arrayOfString = new String[localArrayList.size()];
      int i = 0;
      while (i < localArrayList.size())
      {
        arrayOfString[i] = ((DownloadInfo)localArrayList.get(i)).getFilePath();
        i += 1;
      }
      DownloadActivity.access$1300(this.this$0, arrayOfString);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.download.activity.DownloadActivity.7
 * JD-Core Version:    0.7.0.1
 */