package com.tencent.viola.utils;

import android.content.Context;
import android.view.OrientationEventListener;

class OrientationDetector$2
  extends OrientationEventListener
{
  OrientationDetector$2(OrientationDetector paramOrientationDetector, Context paramContext, OrientationDetector.OnOrientationChangedListener paramOnOrientationChangedListener)
  {
    super(paramContext);
  }
  
  public void onOrientationChanged(int paramInt)
  {
    if (!OrientationDetector.access$300(this.this$0, paramInt)) {}
    label197:
    for (;;)
    {
      return;
      int j = OrientationDetector.access$100(this.this$0);
      int i;
      if (((paramInt >= 0) && (paramInt <= OrientationDetector.access$400(this.this$0))) || (paramInt > 360 - OrientationDetector.access$400(this.this$0))) {
        i = 1;
      }
      for (;;)
      {
        if (i == OrientationDetector.access$100(this.this$0)) {
          break label197;
        }
        OrientationDetector.access$102(this.this$0, i);
        if (this.val$listener == null) {
          break;
        }
        this.val$listener.onOrientationChanged(i);
        return;
        if ((paramInt > 90 - OrientationDetector.access$500(this.this$0)) && (paramInt <= OrientationDetector.access$500(this.this$0) + 90))
        {
          i = 8;
        }
        else if ((paramInt > 180 - OrientationDetector.access$400(this.this$0)) && (paramInt <= OrientationDetector.access$400(this.this$0) + 180))
        {
          i = 9;
        }
        else
        {
          i = j;
          if (paramInt > 270 - OrientationDetector.access$500(this.this$0))
          {
            i = j;
            if (paramInt <= OrientationDetector.access$500(this.this$0) + 270) {
              i = 0;
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.viola.utils.OrientationDetector.2
 * JD-Core Version:    0.7.0.1
 */