package com.tencent.mobileqq.activity;

import ame;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qrcode.activity.AddFriendScannerActivity;
import com.tencent.mobileqq.activity.selectmember.CreateFaceToFaceDiscussionActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.statistics.ReportController;

public class Face2FaceActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  private static final String a = Face2FaceActivity.class.getSimpleName();
  
  private void c()
  {
    ((ImageView)findViewById(2131297129)).setOnClickListener(this);
    ((ImageView)findViewById(2131297130)).setOnClickListener(this);
    setTitle(getString(2131364088), getString(2131364088));
    TextView localTextView = (TextView)findViewById(2131296901);
    localTextView.setVisibility(0);
    localTextView.setContentDescription("返回，按钮");
    localTextView.setOnClickListener(new ame(this));
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2130903198);
    d(2130837633);
    c();
    return true;
  }
  
  public void onClick(View paramView)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("fromFace2FaceActivity", true);
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131297129: 
      localIntent.setClass(this, AddFriendScannerActivity.class);
      startActivity(localIntent);
      ReportController.b(this.app, "CliOper", "", "", "0X80049F1", "0X80049F1", 0, 0, "", "", "", "");
      return;
    }
    localIntent.setClass(this, CreateFaceToFaceDiscussionActivity.class);
    startActivity(localIntent);
    overridePendingTransition(2130968590, 2130968591);
    ReportController.b(this.app, "CliOper", "", "", "0X80049F0", "0X80049F0", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.Face2FaceActivity
 * JD-Core Version:    0.7.0.1
 */