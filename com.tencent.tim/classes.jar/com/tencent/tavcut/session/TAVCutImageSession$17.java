package com.tencent.tavcut.session;

import android.util.SparseArray;
import com.tencent.tavcut.util.DurationUtil;
import com.tencent.weseevideo.composition.image.WSImageRender;

class TAVCutImageSession$17
  implements Runnable
{
  TAVCutImageSession$17(TAVCutImageSession paramTAVCutImageSession, int paramInt) {}
  
  public void run()
  {
    if (TAVCutImageSession.access$200(this.this$0).get(this.val$index) == null) {
      return;
    }
    if ((this.this$0.renderChainManagers.get(this.val$index) == null) || (TAVCutImageSession.access$300(this.this$0).get(this.val$index) == null))
    {
      DurationUtil.start("initRenderEnvironment");
      TAVCutImageSession.access$500(this.this$0, this.val$index);
      DurationUtil.end("initRenderEnvironment");
    }
    ((WSImageRender)TAVCutImageSession.access$300(this.this$0).get(this.val$index)).render(new TAVCutImageSession.17.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tavcut.session.TAVCutImageSession.17
 * JD-Core Version:    0.7.0.1
 */