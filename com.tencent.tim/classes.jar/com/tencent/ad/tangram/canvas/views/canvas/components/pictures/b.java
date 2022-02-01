package com.tencent.ad.tangram.canvas.views.canvas.components.pictures;

import android.content.Context;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.LinearLayout;
import com.tencent.ad.tangram.canvas.views.AdViewStatus;
import com.tencent.ad.tangram.canvas.views.canvas.components.AdCanvasComponentView;
import com.tencent.ad.tangram.canvas.views.canvas.framework.AdCanvasViewListener;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

public class b
  extends AdCanvasComponentView
{
  private static final String TAG = "GdtCanvasPictureComponentView";
  private a data;
  
  public b(Context paramContext, WeakReference<AdCanvasViewListener> paramWeakReference, a parama)
  {
    super(paramContext, paramWeakReference);
    init(paramContext, parama);
  }
  
  private void init(Context paramContext, a parama)
  {
    if ((parama == null) || (!parama.isValid())) {}
    for (;;)
    {
      return;
      this.data = parama;
      paramContext = new LinearLayout(paramContext);
      paramContext.setGravity(1);
      paramContext.setOrientation(1);
      addView(paramContext);
      setPadding(getData().paddingLeft, getData().paddingTop, getData().paddingRight, getData().paddingBottom);
      parama = this.data.imageList.iterator();
      while (parama.hasNext())
      {
        com.tencent.ad.tangram.canvas.views.canvas.components.picture.a locala = (com.tencent.ad.tangram.canvas.views.canvas.components.picture.a)parama.next();
        if (locala != null)
        {
          a locala1 = new a(locala);
          paramContext.addView(new com.tencent.ad.tangram.canvas.views.canvas.components.picture.b(getContext(), this.canvasViewListener, (com.tencent.ad.tangram.canvas.views.canvas.components.picture.a)com.tencent.ad.tangram.canvas.views.canvas.components.picture.a.class.cast(locala), locala1));
        }
      }
    }
  }
  
  public a getData()
  {
    return this.data;
  }
  
  public AdViewStatus getStatus()
  {
    return this.status;
  }
  
  class a
    implements View.OnTouchListener
  {
    private com.tencent.ad.tangram.canvas.views.canvas.components.picture.a canvasPictureComponentData;
    private final GestureDetector gestureDetector = new GestureDetector(this.listener);
    private GestureDetector.OnGestureListener listener = new b.a.1(this);
    
    public a(com.tencent.ad.tangram.canvas.views.canvas.components.picture.a parama)
    {
      this.canvasPictureComponentData = parama;
    }
    
    public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      return this.gestureDetector.onTouchEvent(paramMotionEvent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.tencent.ad.tangram.canvas.views.canvas.components.pictures.b
 * JD-Core Version:    0.7.0.1
 */