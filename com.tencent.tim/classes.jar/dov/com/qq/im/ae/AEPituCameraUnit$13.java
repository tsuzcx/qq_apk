package dov.com.qq.im.ae;

import aeah;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.widget.RelativeLayout.LayoutParams;
import awtq;
import awtr;
import awwk;
import axcg;
import axgi;
import axiy;
import dov.com.qq.im.ae.mode.AECaptureMode;
import dov.com.qq.im.ae.view.AECompoundButton;
import dov.com.tencent.mobileqq.richmedia.capture.view.AEPituCameraCaptureButtonLayout;
import wja;

public class AEPituCameraUnit$13
  implements Runnable
{
  public AEPituCameraUnit$13(awtq paramawtq) {}
  
  public void run()
  {
    axiy.i("AEPituCameraUnit", "actionAfterFirstFrame--ui run--BEGIN");
    Object localObject = (ViewStub)awtq.b(this.this$0).findViewById(2131378862);
    if (localObject != null)
    {
      ((ViewStub)localObject).inflate();
      axiy.i("AEPituCameraUnit", "AEPartAction--inflate bottom");
    }
    localObject = (ViewStub)awtq.b(this.this$0).findViewById(2131378864);
    if (localObject != null)
    {
      ((ViewStub)localObject).inflate();
      axiy.i("AEPituCameraUnit", "AEPartAction--inflate captureMode");
    }
    awtq.a(this.this$0, (AEPituCameraCaptureButtonLayout)awtq.b(this.this$0).findViewById(2131364256));
    awtq.a(this.this$0).a(this.this$0, awtq.a(this.this$0), awtq.a(this.this$0));
    localObject = this.this$0.getActivity().getIntent();
    awtq.a(this.this$0).setOriginIntent((Intent)localObject);
    localObject = (RelativeLayout.LayoutParams)awtq.a(this.this$0).getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).bottomMargin = wja.dp2px(-30.0F, awtq.a(this.this$0).getResources());
    awtq.a(this.this$0).setLayoutParams((ViewGroup.LayoutParams)localObject);
    if (!axcg.ay(this.this$0.getActivity().getIntent())) {
      awtq.a(this.this$0).eTW();
    }
    if (awtq.a(this.this$0))
    {
      awtq.a(this.this$0).onResume();
      this.this$0.cox();
    }
    awtq.a(this.this$0).eGd();
    if (awtq.a(this.this$0).shouldStartCamera())
    {
      awtq.e(this.this$0);
      awtq.a(this.this$0).init();
    }
    awtq.a(this.this$0, (AECompoundButton)awtq.b(this.this$0).findViewById(2131365586));
    awtq.a(this.this$0).setOnClickListener(this.this$0);
    awtq.a(this.this$0).setSelected(false);
    awtq.a(this.this$0).setVisibility(8);
    if (awtq.b(this.this$0)) {
      awtq.a(this.this$0, awtq.b(this.this$0));
    }
    awtq.b(this.this$0, (AECompoundButton)awtq.b(this.this$0).findViewById(2131364422));
    awtq.b(this.this$0).setOnClickListener(this.this$0);
    awtq.b(this.this$0).setContentDescription(awtq.b(this.this$0).getResources().getString(2131718862));
    if (!aeah.agb())
    {
      awtq.b(this.this$0).setVisibility(4);
      awtq.b(this.this$0).setEnabled(false);
    }
    if (awtq.a(this.this$0))
    {
      awtq.a(this.this$0).onActivityResume();
      awtq.a(this.this$0).onResume();
    }
    awtq.b(this.this$0).setOnTouchListener(this.this$0);
    if (axcg.oi(awtq.a(this.this$0))) {
      awtq.b(this.this$0).setOnClickListener(new awtr(this));
    }
    awtq.a(this.this$0, true);
    axiy.i("AEPituCameraUnit", "actionAfterFirstFrame--ui run--END");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.AEPituCameraUnit.13
 * JD-Core Version:    0.7.0.1
 */