import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.stickerbubble.StickerBubbleAnimationView;
import com.tencent.mobileqq.activity.aio.stickerbubble.StickerBubbleAnimationView.b;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ygb
{
  private StickerBubbleAnimationView a;
  private StickerBubbleAnimationView.b jdField_b_of_type_ComTencentMobileqqActivityAioStickerbubbleStickerBubbleAnimationView$b = new ygc(this);
  private StickerBubbleAnimationView jdField_b_of_type_ComTencentMobileqqActivityAioStickerbubbleStickerBubbleAnimationView;
  private boolean bmr;
  private boolean bms;
  private StickerBubbleAnimationView.b c = new ygd(this);
  private Context mContext = BaseApplicationImpl.getContext();
  private List<WeakReference<ygb.a>> sv = new LinkedList();
  private List<WeakReference<ygb.a>> sw = new LinkedList();
  
  public static ygb a()
  {
    return ygb.b.b();
  }
  
  private void d(ViewGroup paramViewGroup, View paramView)
  {
    new RelativeLayout.LayoutParams(-1, -1);
    if (paramView.getParent() != null) {
      if (paramView.getParent() != paramViewGroup)
      {
        ((ViewGroup)paramView.getParent()).removeView(paramView);
        paramViewGroup.addView(paramView);
      }
    }
    for (;;)
    {
      paramView.bringToFront();
      return;
      paramViewGroup.addView(paramView);
    }
  }
  
  private void fD(View paramView)
  {
    if (paramView.getParent() == null) {
      return;
    }
    ((ViewGroup)paramView.getParent()).removeView(paramView);
  }
  
  private void gy(List<WeakReference<ygb.a>> paramList)
  {
    try
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        ygb.a locala = (ygb.a)((WeakReference)paramList.next()).get();
        if (locala != null) {
          locala.cia();
        }
      }
    }
    finally {}
  }
  
  private void gz(List<WeakReference<ygb.a>> paramList)
  {
    Iterator localIterator = new ArrayList(paramList).iterator();
    while (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      ygb.a locala = (ygb.a)localWeakReference.get();
      if (locala != null) {
        locala.cib();
      } else {
        paramList.remove(localWeakReference);
      }
    }
  }
  
  public StickerBubbleAnimationView a(Context paramContext)
  {
    paramContext = d(paramContext);
    if (this.bms)
    {
      if (QLog.isColorLevel()) {
        QLog.d("StickerBubbleAnimationViewHolder", 2, "hideSendAnimationView: " + paramContext);
      }
      fD(paramContext);
      this.bms = false;
    }
    return paramContext;
  }
  
  public StickerBubbleAnimationView a(ViewGroup paramViewGroup, Context paramContext)
  {
    paramContext = d(paramContext);
    if (!this.bms)
    {
      if (QLog.isColorLevel()) {
        QLog.d("StickerBubbleAnimationViewHolder", 2, "showSendAnimationView: " + paramContext.getParent() + " / " + paramViewGroup);
      }
      d(paramViewGroup, paramContext);
      this.bms = true;
    }
    return paramContext;
  }
  
  public void a(ygb.a parama)
  {
    try
    {
      this.sv.add(new WeakReference(parama));
      return;
    }
    finally
    {
      parama = finally;
      throw parama;
    }
  }
  
  public StickerBubbleAnimationView b(Context paramContext)
  {
    paramContext = c(paramContext);
    if (this.bmr)
    {
      if (QLog.isColorLevel()) {
        QLog.d("StickerBubbleAnimationViewHolder", 2, "hideReceiveAnimationView: " + paramContext);
      }
      fD(paramContext);
      this.bmr = false;
    }
    return paramContext;
  }
  
  public StickerBubbleAnimationView b(ViewGroup paramViewGroup, Context paramContext)
  {
    paramContext = c(paramContext);
    if (!this.bmr)
    {
      if (QLog.isColorLevel()) {
        QLog.d("StickerBubbleAnimationViewHolder", 2, "showReceiveAnimationView: " + paramContext.getParent() + " / " + paramViewGroup);
      }
      d(paramViewGroup, paramContext);
      this.bmr = true;
    }
    return paramContext;
  }
  
  public void b(ygb.a parama)
  {
    try
    {
      this.sw.add(new WeakReference(parama));
      return;
    }
    finally
    {
      parama = finally;
      throw parama;
    }
  }
  
  public StickerBubbleAnimationView c(Context paramContext)
  {
    if (this.a == null)
    {
      this.a = new StickerBubbleAnimationView(paramContext);
      this.a.setShowText(false);
      this.a.setId(2131378777);
      this.a.setAnimationCallback(this.jdField_b_of_type_ComTencentMobileqqActivityAioStickerbubbleStickerBubbleAnimationView$b);
    }
    return this.a;
  }
  
  public void chZ()
  {
    if (QLog.isColorLevel()) {
      QLog.d("StickerBubbleAnimationViewHolder", 2, "cleanView");
    }
    if (this.bmr) {
      b(this.mContext);
    }
    if (this.bms) {
      a(this.mContext);
    }
    this.a = null;
    this.jdField_b_of_type_ComTencentMobileqqActivityAioStickerbubbleStickerBubbleAnimationView = null;
  }
  
  public StickerBubbleAnimationView d(Context paramContext)
  {
    if (this.jdField_b_of_type_ComTencentMobileqqActivityAioStickerbubbleStickerBubbleAnimationView == null)
    {
      this.jdField_b_of_type_ComTencentMobileqqActivityAioStickerbubbleStickerBubbleAnimationView = new StickerBubbleAnimationView(paramContext);
      this.jdField_b_of_type_ComTencentMobileqqActivityAioStickerbubbleStickerBubbleAnimationView.setId(2131378777);
      this.jdField_b_of_type_ComTencentMobileqqActivityAioStickerbubbleStickerBubbleAnimationView.setAnimationCallback(this.c);
    }
    return this.jdField_b_of_type_ComTencentMobileqqActivityAioStickerbubbleStickerBubbleAnimationView;
  }
  
  public static abstract interface a
  {
    public abstract void cia();
    
    public abstract void cib();
  }
  
  static class b
  {
    @SuppressLint({"StaticFieldLeak"})
    private static ygb b = new ygb(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     ygb
 * JD-Core Version:    0.7.0.1
 */