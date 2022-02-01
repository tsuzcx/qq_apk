package com.tencent.mobileqq.ar.ARRenderModel;

import adbc;
import addp;
import android.text.TextUtils;

public class Interactive3DRenderable$11
  implements Runnable
{
  public Interactive3DRenderable$11(addp paramaddp, String paramString) {}
  
  public void run()
  {
    if ((addp.a(this.this$0) != null) && (!TextUtils.isEmpty(this.val$path))) {
      addp.a(this.this$0).h(addp.a(this.this$0) + this.val$path, true, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRenderModel.Interactive3DRenderable.11
 * JD-Core Version:    0.7.0.1
 */