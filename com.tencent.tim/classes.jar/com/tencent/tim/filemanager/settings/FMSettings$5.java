package com.tencent.tim.filemanager.settings;

import android.app.Activity;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import aqha;
import aqju;
import audm.a;
import audn;
import audp;
import audr;
import audw;
import java.util.List;

public class FMSettings$5
  implements Runnable
{
  public FMSettings$5(audn paramaudn, Activity paramActivity, List paramList, audm.a parama) {}
  
  public void run()
  {
    View localView = RelativeLayout.inflate(this.val$activity, 2131561039, null);
    TextView localTextView = (TextView)localView.findViewById(2131371989);
    localTextView.setText(this.this$0.strMsg);
    ((TextView)localView.findViewById(2131367071)).setText(this.this$0.bJB);
    ProgressBar localProgressBar = (ProgressBar)localView.findViewById(2131367035);
    localProgressBar.setVisibility(8);
    this.this$0.ap = aqha.b(this.val$activity, 0, 2131559136, "下载通知", this.this$0.strMsg + '\n' + this.this$0.bJB, "取消", "确定", new audp(this, localTextView, localProgressBar), new audr(this)).addView(localView);
    audw.JH("0X8005BE1");
    this.this$0.ap.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.filemanager.settings.FMSettings.5
 * JD-Core Version:    0.7.0.1
 */