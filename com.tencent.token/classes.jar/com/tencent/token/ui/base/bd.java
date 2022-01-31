package com.tencent.token.ui.base;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.token.ui.DownloadAppActivity;
import com.tmsdk.TMSDKContext;

class bd
  implements View.OnClickListener
{
  bd(GuideQQPimSecureTipsView paramGuideQQPimSecureTipsView) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent(this.a.getContext(), DownloadAppActivity.class);
    paramView.putExtra("downloadurl", GuideQQPimSecureTipsView.a(this.a));
    this.a.getContext().startActivity(paramView);
    this.a.setVisibility(8);
    GuideQQPimSecureTipsView.a = true;
    TMSDKContext.saveActionData(1150104);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.base.bd
 * JD-Core Version:    0.7.0.1
 */