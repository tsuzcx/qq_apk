package cooperation.vip.ar.controller;

import android.view.ViewGroup;
import awlb;
import awlb.a;
import awle;
import com.tencent.qg.sdk.invoke.ModuleEngine;
import cooperation.qzone.util.QZLog;
import cooperation.vip.ar.widget.VipQGGLSurfaceView;

public class VipQGThreeController$2
  implements Runnable
{
  public VipQGThreeController$2(awlb paramawlb) {}
  
  public void run()
  {
    QZLog.e("VipARQGThreeController", 2, new Object[] { "onDrawFrame status CREATE_QGVIEW success next status JS_MODEL_LOAD" });
    QZLog.i("VipARQGThreeController", 1, "createQGView width = " + awlb.a(this.this$0).width + " height = " + awlb.a(this.this$0).height + " shareContext = " + awlb.a(this.this$0).d);
    awlb.a(this.this$0, new VipQGGLSurfaceView(this.this$0.mContext, awlb.a(this.this$0).width, awlb.a(this.this$0).height, awlb.a(this.this$0).d, awlb.a(this.this$0).b, awlb.a(this.this$0).cRd));
    awlb.a(this.this$0).setLimitFrame(-1);
    awlb.a(this.this$0).setOnTouchListener(null);
    awlb.a(this.this$0).setQGEventListener(this.this$0);
    awlb.a(this.this$0).addView(awlb.a(this.this$0));
    awlb.a(this.this$0, new awlb.a(this.this$0));
    if (awlb.a(this.this$0).getModuleEngine() != null) {
      awlb.a(this.this$0).getModuleEngine().registerJsModule(awlb.a(this.this$0));
    }
    awlb.a(this.this$0, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.vip.ar.controller.VipQGThreeController.2
 * JD-Core Version:    0.7.0.1
 */