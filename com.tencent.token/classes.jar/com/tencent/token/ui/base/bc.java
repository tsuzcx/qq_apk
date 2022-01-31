package com.tencent.token.ui.base;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.token.ui.DownloadAppActivity;
import com.tmsdk.TMSDKContext;

class bc
  implements View.OnClickListener
{
  bc(GuideQQPimSecureDialog paramGuideQQPimSecureDialog) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent(this.a.getContext(), DownloadAppActivity.class);
    paramView.putExtra("downloadurl", "http://qqwx.qq.com/s?aid=index&p=1&c=107013&vt=1&pf=0");
    this.a.getContext().startActivity(paramView);
    this.a.a();
    TMSDKContext.saveActionData(1150103);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.base.bc
 * JD-Core Version:    0.7.0.1
 */