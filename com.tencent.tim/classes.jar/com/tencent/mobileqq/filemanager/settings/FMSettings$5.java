package com.tencent.mobileqq.filemanager.settings;

import acfp;
import ahae.a;
import ahaf;
import ahah;
import ahaj;
import ahau;
import android.app.Activity;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import aqha;
import aqju;
import java.util.List;

public class FMSettings$5
  implements Runnable
{
  public FMSettings$5(ahaf paramahaf, Activity paramActivity, List paramList, ahae.a parama) {}
  
  public void run()
  {
    View localView = RelativeLayout.inflate(this.val$activity, 2131561039, null);
    TextView localTextView = (TextView)localView.findViewById(2131371989);
    localTextView.setText(this.this$0.strMsg);
    ((TextView)localView.findViewById(2131367071)).setText(this.this$0.bJB);
    ProgressBar localProgressBar = (ProgressBar)localView.findViewById(2131367035);
    localProgressBar.setVisibility(8);
    this.this$0.ap = aqha.b(this.val$activity, 0, 2131559136, acfp.m(2131706377), this.this$0.strMsg + '\n' + this.this$0.bJB, acfp.m(2131706376), acfp.m(2131706379), new ahah(this, localTextView, localProgressBar), new ahaj(this)).addView(localView);
    ahau.JH("0X8005BE1");
    this.this$0.ap.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.settings.FMSettings.5
 * JD-Core Version:    0.7.0.1
 */