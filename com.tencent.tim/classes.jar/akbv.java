import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.RectF;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.PopupWindow;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.nearby.profilecard.InterestGuide.2;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;

public class akbv
  implements Handler.Callback, View.OnClickListener, arir.a
{
  public static Boolean aA;
  public static WeakReference<akbv> hu;
  Handler ar;
  public String mAccount;
  int mCurState = 0;
  float mDensity;
  int mHeight;
  public View mLayout;
  int mMinHeight;
  int mMode = 3;
  PopupWindow mPopup;
  RectF mRectF;
  int[] mTemp;
  int mWidth;
  View[] w;
  
  public akbv(String paramString, View paramView, int paramInt)
  {
    this.mAccount = paramString;
    this.mMode = paramInt;
    paramString = (BounceScrollView)paramView.findViewById(2131363709);
    if (paramString != null) {
      paramString.setScrollListener(new arir(this, paramString.getContext()));
    }
    int i = akfk.mb.length;
    this.mLayout = paramView;
    this.w = new View[i];
    paramInt = 0;
    while (paramInt < i)
    {
      this.w[paramInt] = paramView.findViewById(akfk.mb[paramInt]);
      paramInt += 1;
    }
    this.ar = new auru(Looper.getMainLooper(), this);
    this.ar.sendEmptyMessageDelayed(0, 500L);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (ajrk.isDevelopLevel()) {
      ajrk.f("InterestGuide", "MSG_CHECK_INTEREST", new Object[] { Integer.valueOf(paramMessage.what), Integer.valueOf(this.mCurState), Integer.valueOf(this.mMode), Integer.valueOf(this.mLayout.getMeasuredHeight()) });
    }
    Context localContext;
    int k;
    Object localObject;
    int i;
    int m;
    int j;
    if ((paramMessage.what == 0) && (this.mCurState == 0) && (this.mMode != 1) && (this.mLayout.getMeasuredHeight() > 0))
    {
      if (this.mPopup != null)
      {
        this.mPopup.dismiss();
        this.mPopup = null;
      }
      localContext = this.mLayout.getContext();
      if ((this.mTemp == null) || (this.mRectF == null))
      {
        this.mTemp = new int[2];
        this.mRectF = new RectF();
        paramMessage = localContext.getResources().getDisplayMetrics();
        this.mWidth = paramMessage.widthPixels;
        this.mHeight = paramMessage.heightPixels;
        this.mDensity = paramMessage.density;
        this.mMinHeight = ((int)(this.mDensity * 120.0F));
      }
      k = 0;
      localObject = this.mLayout.findViewById(2131377496);
      if (localObject != null)
      {
        ((View)localObject).getLocationInWindow(this.mTemp);
        paramMessage = ((View)localObject).findViewById(2131379866);
        localObject = ((View)localObject).findViewById(2131370241);
        i = this.mTemp[1];
        k = paramMessage.getMeasuredHeight() + i + ((View)localObject).getMeasuredHeight();
      }
      paramMessage = new int[3];
      Message tmp268_267 = paramMessage;
      tmp268_267[0] = 2131363644;
      Message tmp273_268 = tmp268_267;
      tmp273_268[1] = 2131372294;
      Message tmp278_273 = tmp273_268;
      tmp278_273[2] = 2131368638;
      tmp278_273;
      i = this.mHeight;
      m = 0;
      if (m < paramMessage.length)
      {
        localObject = this.mLayout.findViewById(paramMessage[m]);
        int n;
        if ((localObject != null) && (((View)localObject).getVisibility() == 0))
        {
          ((View)localObject).getLocationInWindow(this.mTemp);
          j = i;
          if (this.mTemp[1] > k)
          {
            j = i;
            if (this.mTemp[1] < i) {
              j = this.mTemp[1];
            }
          }
          n = j;
          if (ajrk.isDevelopLevel())
          {
            ajrk.f("InterestGuide", "checkShowGuide_bottom", new Object[] { Integer.valueOf(m), Integer.valueOf(this.mTemp[0]), Integer.valueOf(this.mTemp[1]), Integer.valueOf(((View)localObject).getMeasuredHeight()) });
            n = j;
          }
        }
        for (;;)
        {
          m += 1;
          i = n;
          break;
          n = i;
          if (ajrk.isDevelopLevel())
          {
            ajrk.f("InterestGuide", "checkShowGuide_bottom", new Object[] { Integer.valueOf(m), localObject });
            n = i;
          }
        }
      }
      this.mRectF.set(0.0F, k, this.mWidth, i);
      if (ajrk.isDevelopLevel()) {
        ajrk.f("InterestGuide", "checkShowGuide", new Object[] { Integer.valueOf(this.mWidth), Integer.valueOf(this.mHeight), Integer.valueOf(this.mMinHeight), Integer.valueOf(k), Integer.valueOf(i) });
      }
      localObject = null;
      i = 0;
      paramMessage = (Message)localObject;
      if (0 == 0)
      {
        paramMessage = (Message)localObject;
        if (i < this.w.length)
        {
          if ((this.w[i] == null) || (this.w[i].getVisibility() != 0)) {}
          do
          {
            i += 1;
            break;
            this.w[i].getLocationInWindow(this.mTemp);
            j = this.w[i].getMeasuredWidth();
            k = this.w[i].getMeasuredHeight();
          } while (!this.mRectF.contains(this.mTemp[0], this.mTemp[1], j + this.mTemp[0], k + this.mTemp[1]));
          paramMessage = this.w[i];
        }
      }
      if (paramMessage != null)
      {
        localObject = new LinearLayout(localContext);
        ((LinearLayout)localObject).setOrientation(1);
        i = Color.parseColor("#BF000000");
        j = this.mTemp[1];
        k = paramMessage.getMeasuredHeight();
        m = this.mHeight - j - k;
        if (j > 0)
        {
          if (m <= this.mMinHeight) {
            break label1003;
          }
          paramMessage = new View(localContext);
          paramMessage.setBackgroundColor(i);
          ((LinearLayout)localObject).addView(paramMessage, new LinearLayout.LayoutParams(this.mWidth, j));
        }
        ((LinearLayout)localObject).addView(new View(localContext), new LinearLayout.LayoutParams(this.mWidth, k));
        if (m > 0)
        {
          if (m <= this.mMinHeight) {
            break label1032;
          }
          paramMessage = LayoutInflater.from(localContext).inflate(2131561447, null);
          ((Button)paramMessage.findViewById(2131363743)).setOnClickListener(this);
        }
      }
    }
    for (;;)
    {
      paramMessage.setBackgroundColor(i);
      ((LinearLayout)localObject).addView(paramMessage, new LinearLayout.LayoutParams(this.mWidth, m));
      if (ajrk.isDevelopLevel()) {
        ajrk.f("InterestGuide", "checkShowGuide", new Object[] { Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m) });
      }
      this.mPopup = new PopupWindow(localContext);
      this.mPopup.setWidth(this.mWidth);
      this.mPopup.setHeight(this.mHeight);
      this.mPopup.setContentView((View)localObject);
      this.mPopup.setBackgroundDrawable(null);
      this.mPopup.setOutsideTouchable(false);
      this.mPopup.showAtLocation(this.mLayout, 51, 0, 0);
      return true;
      label1003:
      paramMessage = LayoutInflater.from(localContext).inflate(2131561448, null);
      ((Button)paramMessage.findViewById(2131363743)).setOnClickListener(this);
      break;
      label1032:
      paramMessage = new View(localContext);
    }
  }
  
  public void onClick(View paramView)
  {
    if (this.mPopup != null)
    {
      this.mPopup.dismiss();
      BounceScrollView localBounceScrollView = (BounceScrollView)this.mLayout.findViewById(2131363709);
      if (localBounceScrollView != null) {
        localBounceScrollView.setScrollListener(null);
      }
      hu = null;
      aA = Boolean.FALSE;
      ThreadManager.post(new InterestGuide.2(this), 5, null, false);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void y(View paramView, int paramInt1, int paramInt2)
  {
    if (paramInt2 == 0)
    {
      this.ar.removeMessages(0);
      if (this.mMode != 1) {
        this.ar.sendEmptyMessageDelayed(0, 100L);
      }
    }
    for (;;)
    {
      this.mCurState = paramInt2;
      return;
      this.ar.removeMessages(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akbv
 * JD-Core Version:    0.7.0.1
 */