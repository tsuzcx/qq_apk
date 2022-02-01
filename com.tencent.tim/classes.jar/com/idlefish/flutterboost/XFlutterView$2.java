package com.idlefish.flutterboost;

import io.flutter.embedding.engine.renderer.OnFirstFrameRenderedListener;
import java.util.Iterator;
import java.util.Set;

class XFlutterView$2
  implements OnFirstFrameRenderedListener
{
  XFlutterView$2(XFlutterView paramXFlutterView) {}
  
  public void onFirstFrameRendered()
  {
    XFlutterView.access$102(this.this$0, true);
    Iterator localIterator = XFlutterView.access$200(this.this$0).iterator();
    while (localIterator.hasNext()) {
      ((OnFirstFrameRenderedListener)localIterator.next()).onFirstFrameRendered();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.idlefish.flutterboost.XFlutterView.2
 * JD-Core Version:    0.7.0.1
 */