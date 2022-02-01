package com.tencent.qqmini.miniapp.widget.camera;

import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy.ICommandListenr;
import com.tencent.qqmini.sdk.launcher.log.QMLog;

class MiniAppCamera$6$1
  implements ChannelProxy.ICommandListenr
{
  MiniAppCamera$6$1(MiniAppCamera.6 param6) {}
  
  public void onFailure(String paramString)
  {
    QMLog.i("MiniAppCamera", "compress failed " + paramString);
    MiniAppCamera.access$400(this.this$1.this$0, this.this$1.val$srcPath, this.this$1.val$req);
  }
  
  public void onFinish(boolean paramBoolean)
  {
    QMLog.i("MiniAppCamera", "compress finish " + paramBoolean);
    MiniAppCamera.access$300(this.this$1.this$0);
  }
  
  public void onProgress(String paramString)
  {
    QMLog.i("MiniAppCamera", "compress progress " + paramString);
  }
  
  public void onStart()
  {
    QMLog.i("MiniAppCamera", "compress start");
  }
  
  public void onSuccess(String paramString)
  {
    QMLog.i("MiniAppCamera", "compress success " + paramString);
    MiniAppCamera.access$400(this.this$1.this$0, this.this$1.val$outPath, this.this$1.val$req);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.widget.camera.MiniAppCamera.6.1
 * JD-Core Version:    0.7.0.1
 */