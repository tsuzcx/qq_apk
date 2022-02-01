import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.biz.pubaccount.readinjoy.view.KandianTipFloatingWindow.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.os.MqqHandler;

public class nde
  implements View.OnClickListener, Animation.AnimationListener
{
  protected Animation X;
  private nde.a a;
  private View containerView;
  
  public void close()
  {
    close(true);
  }
  
  public void close(boolean paramBoolean)
  {
    if ((this.a == null) || (this.containerView == null)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("KandianTipFloatingWindow", 2, "close tip window , type : " + this.a.type + ", uin : " + this.a.xl);
    }
    this.a = null;
    if (paramBoolean)
    {
      this.containerView.startAnimation(this.X);
      return;
    }
    this.containerView.setVisibility(8);
  }
  
  public void doReport(int paramInt)
  {
    if (this.a == null) {
      return;
    }
    if ((this.a.type != 0) || (this.a.type == 1)) {}
    switch (paramInt)
    {
    }
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if ((paramAnimation.equals(this.X)) && (this.containerView != null)) {
      this.containerView.setVisibility(8);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
  
  public void onClick(View paramView)
  {
    doReport(2);
    nde.a locala = this.a;
    if ((locala != null) && (locala.onClickListener != null)) {
      ThreadManager.getUIHandler().postDelayed(new KandianTipFloatingWindow.1(this, locala, paramView), 250L);
    }
    close();
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public static class a
  {
    public int aXS = -1;
    public int aXT = -1;
    public String alh;
    public String ali;
    public View.OnClickListener onClickListener;
    public int priority;
    public String text;
    public int type;
    public long xl = -1L;
    
    public boolean equals(Object paramObject)
    {
      boolean bool2 = false;
      boolean bool1 = bool2;
      if ((paramObject instanceof a))
      {
        paramObject = (a)paramObject;
        bool1 = bool2;
        if (this.type == paramObject.type)
        {
          bool1 = bool2;
          if (this.priority == paramObject.priority)
          {
            bool1 = bool2;
            if (this.aXS == paramObject.aXS)
            {
              bool1 = bool2;
              if (this.xl == paramObject.xl)
              {
                bool1 = bool2;
                if (this.aXT == paramObject.aXT)
                {
                  bool1 = bool2;
                  if (TextUtils.equals(this.text, paramObject.text))
                  {
                    bool1 = bool2;
                    if (TextUtils.equals(this.ali, paramObject.ali))
                    {
                      bool1 = bool2;
                      if (TextUtils.equals(this.alh, paramObject.alh)) {
                        bool1 = true;
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
      return bool1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nde
 * JD-Core Version:    0.7.0.1
 */