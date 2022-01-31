package com.tencent.qbardemo;

import android.content.Intent;
import android.graphics.Paint;
import android.hardware.Camera;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.tencent.token.ch;
import com.tencent.token.ui.GetOtherBarcodeActivity;

class MainActivity$1
  extends Handler
{
  MainActivity$1(MainActivity paramMainActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    int i = 0;
    switch (paramMessage.what)
    {
    case 4: 
    default: 
      return;
    case 1: 
      switch (paramMessage.arg1)
      {
      default: 
        return;
      case 0: 
        MainActivity.access$002(this.this$0, false);
        if (MainActivity.access$100(this.this$0) >= 1)
        {
          MainActivity.access$200(this.this$0).getPen().setColor(-65536);
          MainActivity.access$200(this.this$0).invalidate();
        }
        while (MainActivity.access$300(this.this$0) != null)
        {
          MainActivity.access$300(this.this$0).setOneShotPreviewCallback(MainActivity.access$400(this.this$0));
          return;
          MainActivity.access$108(this.this$0);
          MainActivity.access$200(this.this$0).getPen().setColor(-256);
          MainActivity.access$200(this.this$0).invalidate();
        }
      case 1: 
        MainActivity.access$102(this.this$0, 0);
        MainActivity.access$200(this.this$0).setDrawLineImage(false);
        MainActivity.access$200(this.this$0).invalidate();
        this.this$0.showResult(paramMessage.getData());
        return;
      }
      this.this$0.showResult(paramMessage.getData());
      return;
    case 2: 
      this.this$0.doFocus();
      return;
    }
    String str = "";
    if (paramMessage.arg1 == 0)
    {
      i = paramMessage.arg2;
      str = (String)paramMessage.obj;
    }
    paramMessage = new Intent(this.this$0, GetOtherBarcodeActivity.class);
    Bundle localBundle = new Bundle();
    localBundle.putString("barcode_result", MainActivity.access$500(this.this$0));
    localBundle.putInt("url_id", i);
    localBundle.putString("url_txt", str);
    paramMessage.putExtra("com.tencent.input_param", localBundle);
    this.this$0.startActivityForResult(paramMessage, 1);
    ch.a().a(System.currentTimeMillis(), 10);
    this.this$0.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.qbardemo.MainActivity.1
 * JD-Core Version:    0.7.0.1
 */