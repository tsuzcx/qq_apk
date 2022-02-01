package com.facebook.stetho.inspector.elements.android;

import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import com.facebook.stetho.common.Accumulator;
import java.util.List;

class AndroidDocumentProvider$InspectModeHandler$2
  implements Accumulator<Window>
{
  AndroidDocumentProvider$InspectModeHandler$2(AndroidDocumentProvider.InspectModeHandler paramInspectModeHandler) {}
  
  public void store(Window paramWindow)
  {
    if ((paramWindow.peekDecorView() instanceof ViewGroup))
    {
      paramWindow = (ViewGroup)paramWindow.peekDecorView();
      AndroidDocumentProvider.InspectModeHandler.OverlayView localOverlayView = new AndroidDocumentProvider.InspectModeHandler.OverlayView(this.this$1, AndroidDocumentProvider.access$300(this.this$1.this$0));
      WindowManager.LayoutParams localLayoutParams = new WindowManager.LayoutParams();
      localLayoutParams.width = -1;
      localLayoutParams.height = -1;
      paramWindow.addView(localOverlayView, localLayoutParams);
      paramWindow.bringChildToFront(localOverlayView);
      AndroidDocumentProvider.InspectModeHandler.access$400(this.this$1).add(localOverlayView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.facebook.stetho.inspector.elements.android.AndroidDocumentProvider.InspectModeHandler.2
 * JD-Core Version:    0.7.0.1
 */