package com.tencent.qqmail.activity.sdcardfileexplorer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.protocol.DataCollector;
import java.util.List;

class SdcardFileExplorer$6
  implements View.OnClickListener
{
  SdcardFileExplorer$6(SdcardFileExplorer paramSdcardFileExplorer) {}
  
  public void onClick(View paramView)
  {
    DataCollector.logEvent("Event_Compose_File_Count");
    Intent localIntent = new Intent();
    Bundle localBundle = new Bundle();
    int j = FileExplorer.getSelectPaths().size();
    String[] arrayOfString = new String[j];
    int i = 0;
    while (i < j)
    {
      arrayOfString[i] = ((String)FileExplorer.getSelectPaths().get(i));
      i += 1;
    }
    localBundle.putStringArray("filePathArray", arrayOfString);
    localIntent.putExtras(localBundle);
    this.this$0.setResult(-1, localIntent);
    this.this$0.finish();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.sdcardfileexplorer.SdcardFileExplorer.6
 * JD-Core Version:    0.7.0.1
 */