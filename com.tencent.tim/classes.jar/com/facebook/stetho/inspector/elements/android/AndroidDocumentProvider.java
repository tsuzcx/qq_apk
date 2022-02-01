package com.facebook.stetho.inspector.elements.android;

import android.app.Activity;
import android.app.Application;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import com.facebook.stetho.common.Accumulator;
import com.facebook.stetho.common.Predicate;
import com.facebook.stetho.common.ThreadBound;
import com.facebook.stetho.common.Util;
import com.facebook.stetho.common.android.ViewUtil;
import com.facebook.stetho.inspector.elements.Descriptor;
import com.facebook.stetho.inspector.elements.DescriptorMap;
import com.facebook.stetho.inspector.elements.DocumentProvider;
import com.facebook.stetho.inspector.elements.DocumentProviderListener;
import com.facebook.stetho.inspector.elements.NodeDescriptor;
import com.facebook.stetho.inspector.elements.ObjectDescriptor;
import com.facebook.stetho.inspector.helper.ThreadBoundProxy;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;

final class AndroidDocumentProvider
  extends ThreadBoundProxy
  implements DocumentProvider, AndroidDescriptorHost
{
  private static final int INSPECT_HOVER_COLOR = 1077952767;
  private static final int INSPECT_OVERLAY_COLOR = 1090519039;
  private static final long REPORT_CHANGED_INTERVAL_MS = 1000L;
  private final Application mApplication;
  private final DescriptorMap mDescriptorMap;
  private final AndroidDocumentRoot mDocumentRoot;
  private final ViewHighlighter mHighlighter;
  private final InspectModeHandler mInspectModeHandler;
  private boolean mIsReportChangesTimerPosted = false;
  @Nullable
  private DocumentProviderListener mListener;
  private final Runnable mReportChangesTimer = new AndroidDocumentProvider.1(this);
  
  public AndroidDocumentProvider(Application paramApplication, ThreadBound paramThreadBound)
  {
    super(paramThreadBound);
    this.mApplication = ((Application)Util.throwIfNull(paramApplication));
    this.mDocumentRoot = new AndroidDocumentRoot(paramApplication);
    this.mDescriptorMap = new DescriptorMap().beginInit().register(Activity.class, new ActivityDescriptor()).register(AndroidDocumentRoot.class, this.mDocumentRoot).register(Application.class, new ApplicationDescriptor()).register(Dialog.class, new DialogDescriptor());
    DialogFragmentDescriptor.register(this.mDescriptorMap);
    FragmentDescriptor.register(this.mDescriptorMap).register(Object.class, new ObjectDescriptor()).register(TextView.class, new TextViewDescriptor()).register(View.class, new ViewDescriptor()).register(ViewGroup.class, new ViewGroupDescriptor()).register(Window.class, new WindowDescriptor()).setHost(this).endInit();
    this.mHighlighter = ViewHighlighter.newInstance();
    this.mInspectModeHandler = new InspectModeHandler(null);
  }
  
  private void getWindows(Accumulator<Window> paramAccumulator)
  {
    Descriptor localDescriptor = getDescriptor(this.mApplication);
    if (localDescriptor != null)
    {
      paramAccumulator = new AndroidDocumentProvider.2(this, paramAccumulator);
      localDescriptor.getChildren(this.mApplication, paramAccumulator);
    }
  }
  
  public void dispose()
  {
    verifyThreadAccess();
    this.mHighlighter.clearHighlight();
    this.mInspectModeHandler.disable();
    removeCallbacks(this.mReportChangesTimer);
    this.mIsReportChangesTimerPosted = false;
    this.mListener = null;
  }
  
  public Descriptor getDescriptor(Object paramObject)
  {
    if (paramObject == null) {
      return null;
    }
    return this.mDescriptorMap.get(paramObject.getClass());
  }
  
  public View getHighlightingView(Object paramObject)
  {
    Object localObject3;
    if (paramObject == null)
    {
      localObject3 = null;
      return localObject3;
    }
    Class localClass = paramObject.getClass();
    Object localObject2 = null;
    for (Object localObject1 = null;; localObject1 = localObject3)
    {
      localObject3 = localObject1;
      if (localObject1 != null) {
        break;
      }
      localObject3 = localObject1;
      if (localClass == null) {
        break;
      }
      Descriptor localDescriptor = this.mDescriptorMap.get(localClass);
      if (localDescriptor == null) {
        return null;
      }
      localObject3 = localObject1;
      if (localDescriptor != localObject2)
      {
        localObject3 = localObject1;
        if ((localDescriptor instanceof HighlightableDescriptor)) {
          localObject3 = ((HighlightableDescriptor)localDescriptor).getViewForHighlighting(paramObject);
        }
      }
      localClass = localClass.getSuperclass();
      localObject2 = localDescriptor;
    }
  }
  
  public NodeDescriptor getNodeDescriptor(Object paramObject)
  {
    verifyThreadAccess();
    return getDescriptor(paramObject);
  }
  
  public Object getRootElement()
  {
    verifyThreadAccess();
    return this.mDocumentRoot;
  }
  
  public void hideHighlight()
  {
    verifyThreadAccess();
    this.mHighlighter.clearHighlight();
  }
  
  public void highlightElement(Object paramObject, int paramInt)
  {
    verifyThreadAccess();
    paramObject = getHighlightingView(paramObject);
    if (paramObject == null)
    {
      this.mHighlighter.clearHighlight();
      return;
    }
    this.mHighlighter.setHighlightedView(paramObject, paramInt);
  }
  
  public void onAttributeModified(Object paramObject, String paramString1, String paramString2)
  {
    if (this.mListener != null) {
      this.mListener.onAttributeModified(paramObject, paramString1, paramString2);
    }
  }
  
  public void onAttributeRemoved(Object paramObject, String paramString)
  {
    if (this.mListener != null) {
      this.mListener.onAttributeRemoved(paramObject, paramString);
    }
  }
  
  public void setAttributesAsText(Object paramObject, String paramString)
  {
    verifyThreadAccess();
    Descriptor localDescriptor = this.mDescriptorMap.get(paramObject.getClass());
    if (localDescriptor != null) {
      localDescriptor.setAttributesAsText(paramObject, paramString);
    }
  }
  
  public void setInspectModeEnabled(boolean paramBoolean)
  {
    verifyThreadAccess();
    if (paramBoolean)
    {
      this.mInspectModeHandler.enable();
      return;
    }
    this.mInspectModeHandler.disable();
  }
  
  public void setListener(DocumentProviderListener paramDocumentProviderListener)
  {
    verifyThreadAccess();
    this.mListener = paramDocumentProviderListener;
    if ((this.mListener == null) && (this.mIsReportChangesTimerPosted))
    {
      this.mIsReportChangesTimerPosted = false;
      removeCallbacks(this.mReportChangesTimer);
    }
    while ((this.mListener == null) || (this.mIsReportChangesTimerPosted)) {
      return;
    }
    this.mIsReportChangesTimerPosted = true;
    postDelayed(this.mReportChangesTimer, 1000L);
  }
  
  final class InspectModeHandler
  {
    private List<View> mOverlays;
    private final Predicate<View> mViewSelector = new AndroidDocumentProvider.InspectModeHandler.1(this);
    
    private InspectModeHandler() {}
    
    public void disable()
    {
      AndroidDocumentProvider.this.verifyThreadAccess();
      if (this.mOverlays == null) {
        return;
      }
      int i = 0;
      while (i < this.mOverlays.size())
      {
        View localView = (View)this.mOverlays.get(i);
        ((ViewGroup)localView.getParent()).removeView(localView);
        i += 1;
      }
      this.mOverlays = null;
    }
    
    public void enable()
    {
      AndroidDocumentProvider.this.verifyThreadAccess();
      if (this.mOverlays != null) {
        disable();
      }
      this.mOverlays = new ArrayList();
      AndroidDocumentProvider.this.getWindows(new AndroidDocumentProvider.InspectModeHandler.2(this));
    }
    
    final class OverlayView
      extends DocumentHiddenView
    {
      public OverlayView(Context paramContext)
      {
        super();
      }
      
      protected void onDraw(Canvas paramCanvas)
      {
        paramCanvas.drawColor(1090519039);
        super.onDraw(paramCanvas);
      }
      
      public boolean onTouchEvent(MotionEvent paramMotionEvent)
      {
        if ((getParent() instanceof View))
        {
          View localView = ViewUtil.hitTest((View)getParent(), paramMotionEvent.getX(), paramMotionEvent.getY(), AndroidDocumentProvider.InspectModeHandler.this.mViewSelector);
          if ((paramMotionEvent.getAction() != 3) && (localView != null))
          {
            AndroidDocumentProvider.this.mHighlighter.setHighlightedView(localView, 1077952767);
            if ((paramMotionEvent.getAction() == 1) && (AndroidDocumentProvider.this.mListener != null)) {
              AndroidDocumentProvider.this.mListener.onInspectRequested(localView);
            }
          }
        }
        return true;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.facebook.stetho.inspector.elements.android.AndroidDocumentProvider
 * JD-Core Version:    0.7.0.1
 */