import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class xrh
  implements Handler.Callback
{
  private xrg a;
  private int bWC = 18;
  private BaseChatPie c;
  private View.OnClickListener dX = new xrk(this);
  private RelativeLayout el;
  private View.OnTouchListener f = new xrl(this);
  private HashMap<Integer, xrg> gT;
  private RelativeLayout hO;
  private int[] hy = { 2131374819, 2131374819 };
  private QQAppInterface mApp;
  private Context mContext;
  private SessionInfo mSessionInfo;
  private Handler mUIHandler;
  private Animation n;
  private Animation o;
  private Animation.AnimationListener r = new xri(this);
  private Animation.AnimationListener s = new xrj(this);
  
  public xrh(BaseChatPie paramBaseChatPie, QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, RelativeLayout paramRelativeLayout)
  {
    this.mApp = paramQQAppInterface;
    this.mContext = paramContext;
    this.c = paramBaseChatPie;
    this.mSessionInfo = paramSessionInfo;
    this.el = paramRelativeLayout;
    this.gT = new HashMap();
    this.mUIHandler = new Handler(this);
  }
  
  private void a(xrg paramxrg)
  {
    if (paramxrg == null) {
      QLog.d("NavigateBarManager", 1, "show navigate bar, navigateBar == null");
    }
    do
    {
      return;
      this.a = paramxrg;
      Object localObject1 = paramxrg.getView();
      if (localObject1 != null)
      {
        Object localObject2 = ((View)localObject1).getParent();
        if ((localObject2 instanceof ViewGroup)) {
          ((ViewGroup)localObject2).removeView((View)localObject1);
        }
        if (this.hO == null)
        {
          this.hO = new RelativeLayout(this.mContext);
          this.hO.setMinimumHeight(aqnm.dpToPx(45.0F));
          this.hO.setOnClickListener(this.dX);
          this.hO.setOnTouchListener(this.f);
          this.hO.setVisibility(8);
          localObject2 = new RelativeLayout.LayoutParams(-2, -2);
          ((RelativeLayout.LayoutParams)localObject2).addRule(11);
          int i = wp();
          if (i != -1) {
            ((RelativeLayout.LayoutParams)localObject2).addRule(3, i);
          }
          ((RelativeLayout.LayoutParams)localObject2).topMargin = aqnm.dip2px(this.bWC);
          this.el.addView(this.hO, (ViewGroup.LayoutParams)localObject2);
        }
        if (this.o == null)
        {
          this.o = new TranslateAnimation(2, 1.0F, 2, 0.0F, 2, 0.0F, 2, 0.0F);
          this.o.setDuration(500L);
          this.o.setAnimationListener(this.r);
        }
        if (this.n == null)
        {
          this.n = new TranslateAnimation(2, 0.0F, 2, 1.0F, 2, 0.0F, 2, 0.0F);
          this.n.setDuration(500L);
          this.n.setAnimationListener(this.s);
        }
        this.hO.removeAllViews();
        localObject2 = new RelativeLayout.LayoutParams(-2, -2);
        this.hO.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
        this.hO.clearAnimation();
        this.hO.startAnimation(this.o);
        this.hO.setVisibility(0);
        this.mUIHandler.removeMessages(1);
        if (paramxrg.getDuration() > 0L)
        {
          localObject1 = this.mUIHandler.obtainMessage(1);
          ((Message)localObject1).arg1 = paramxrg.id;
          this.mUIHandler.sendMessageDelayed((Message)localObject1, paramxrg.getDuration());
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d("NavigateBarManager", 2, String.format("show navigate bar: %s", new Object[] { paramxrg }));
  }
  
  private void hide()
  {
    if (QLog.isColorLevel()) {
      QLog.d("NavigateBarManager", 2, String.format("hide navigate bar: %s", new Object[] { this.a }));
    }
    if ((this.hO != null) && (this.hO.getVisibility() == 0))
    {
      this.hO.clearAnimation();
      this.hO.startAnimation(this.n);
    }
    if (this.a != null)
    {
      Dr(this.a.id);
      this.a = null;
    }
  }
  
  private int wp()
  {
    Object localObject1 = null;
    int i = 0;
    if (i < this.hy.length)
    {
      View localView = this.el.findViewById(this.hy[i]);
      Object localObject2;
      if (localView != null) {
        if (localObject1 == null) {
          localObject2 = localView;
        }
      }
      for (;;)
      {
        i += 1;
        localObject1 = localObject2;
        break;
        localObject2 = localView;
        if (localView.getBottom() <= localObject1.getBottom()) {
          localObject2 = localObject1;
        }
      }
    }
    if (localObject1 != null) {
      return localObject1.getId();
    }
    return -1;
  }
  
  public void Dq(int paramInt)
  {
    Object localObject;
    if ((paramInt > 0) && (paramInt < 4))
    {
      localObject = null;
      switch (paramInt)
      {
      }
    }
    for (;;)
    {
      if (localObject != null)
      {
        boolean bool = ((xrg)localObject).needShow();
        if (bool) {
          this.gT.put(Integer.valueOf(((xrg)localObject).id), localObject);
        }
        if (QLog.isColorLevel()) {
          QLog.d("NavigateBarManager", 2, String.format("addTask, barId: %s, needShow: %s", new Object[] { Integer.valueOf(((xrg)localObject).id), Boolean.valueOf(bool) }));
        }
      }
      return;
      localObject = new xrf(this.c, this.mApp, this.mContext, this.mSessionInfo, paramInt, 3);
      continue;
      localObject = new xrn(this.c, this.mApp, this.mContext, this.mSessionInfo, paramInt, 3);
      continue;
      localObject = new xrm(this.c, this.mApp, this.mContext, this.mSessionInfo, paramInt, 3);
    }
  }
  
  public void Dr(int paramInt)
  {
    this.gT.remove(Integer.valueOf(paramInt));
    if (QLog.isColorLevel()) {
      QLog.d("NavigateBarManager", 2, String.format("removeTask, barId: %s", new Object[] { Integer.valueOf(paramInt) }));
    }
  }
  
  public void gv(int paramInt)
  {
    if ((this.a != null) && (this.a.id == paramInt)) {
      hide();
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("NavigateBarManager", 2, String.format("hide navigate bar id: %s", new Object[] { Integer.valueOf(paramInt) }));
      }
      return;
      Dr(paramInt);
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      int i = paramMessage.arg1;
      if ((this.a != null) && (i == this.a.id)) {
        hide();
      } else {
        QLog.d("NavigateBarManager", 1, "hide bar msg but not found, barId: " + i);
      }
    }
  }
  
  public void onDestroy()
  {
    if (this.hO != null)
    {
      this.hO.removeAllViews();
      this.hO.setVisibility(8);
      if (this.el.indexOfChild(this.hO) != -1) {
        this.el.removeView(this.hO);
      }
      this.hO = null;
      if (this.a != null) {
        this.a.onDestroy();
      }
      this.a = null;
    }
    if (this.gT != null) {
      this.gT.clear();
    }
    if (QLog.isColorLevel()) {
      QLog.d("NavigateBarManager", 2, "onDestroy");
    }
  }
  
  public void refresh()
  {
    this.gT.entrySet();
    Object localObject1 = null;
    Iterator localIterator = this.gT.entrySet().iterator();
    if (localIterator.hasNext())
    {
      xrg localxrg = (xrg)((Map.Entry)localIterator.next()).getValue();
      Object localObject2;
      if (localObject1 == null) {
        localObject2 = localxrg;
      }
      for (;;)
      {
        localObject1 = localObject2;
        break;
        localObject2 = localxrg;
        if (localxrg.priority <= localObject1.priority) {
          localObject2 = localObject1;
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("NavigateBarManager", 2, String.format("refresh navigate bar: %s", new Object[] { localObject1 }));
    }
    if (localObject1 != null) {
      a(localObject1);
    }
  }
  
  public void setTopMargin(int paramInt)
  {
    this.bWC = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xrh
 * JD-Core Version:    0.7.0.1
 */