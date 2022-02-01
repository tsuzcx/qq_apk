import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.TMG.utils.QLog;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.ArrayList;
import java.util.List;

public class afyv
{
  List<ImageView> AB = new ArrayList();
  List<String> AC = new ArrayList();
  Handler.Callback b = new afza(this);
  Handler handler = new Handler(Looper.getMainLooper(), this.b);
  volatile boolean isAnimating;
  RelativeLayout ki;
  int mStyle = 1;
  List<String> uinList = new ArrayList();
  ImageView zr;
  ImageView zs;
  ImageView zt;
  
  public afyv(int paramInt)
  {
    this.mStyle = paramInt;
    jB(paramInt);
  }
  
  private boolean jB(int paramInt)
  {
    int i = 0;
    if (!jC(paramInt)) {
      return false;
    }
    Object localObject = BaseApplicationImpl.getContext();
    switch (paramInt)
    {
    }
    for (;;)
    {
      if (this.zs != null) {
        this.zs.setLayerType(1, null);
      }
      if ((this.ki == null) || (this.ki.getChildCount() <= 0)) {
        break label344;
      }
      paramInt = i;
      while (paramInt < this.ki.getChildCount())
      {
        localObject = this.ki.getChildAt(paramInt);
        if ((localObject instanceof ImageView))
        {
          localObject = (ImageView)localObject;
          ((ImageView)localObject).setVisibility(8);
          this.AB.add(localObject);
        }
        paramInt += 1;
      }
      this.ki = ((RelativeLayout)View.inflate((Context)localObject, 2131561328, null));
      this.zr = ((ImageView)this.ki.findViewById(2131368376));
      this.zs = ((ImageView)this.ki.findViewById(2131368380));
      continue;
      this.ki = ((RelativeLayout)View.inflate((Context)localObject, 2131561349, null));
      this.zr = ((ImageView)this.ki.findViewById(2131368376));
      this.zs = ((ImageView)this.ki.findViewById(2131368377));
      continue;
      this.ki = ((RelativeLayout)View.inflate((Context)localObject, 2131561348, null));
      this.zr = ((ImageView)this.ki.findViewById(2131368376));
      this.zs = ((ImageView)this.ki.findViewById(2131368377));
      continue;
      this.ki = ((RelativeLayout)View.inflate((Context)localObject, 2131561337, null));
      this.zr = ((ImageView)this.ki.findViewById(2131368376));
      this.zs = ((ImageView)this.ki.findViewById(2131368381));
    }
    this.ki.setVisibility(8);
    label344:
    return true;
  }
  
  private boolean jC(int paramInt)
  {
    return (paramInt > 0) && (paramInt <= 4);
  }
  
  private void updateData(ArrayList<String> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
      QLog.e("MatchViewHolder", 0, "updateData _ uins is null ");
    }
    int j;
    QQAppInterface localQQAppInterface;
    label189:
    Object localObject;
    label225:
    do
    {
      do
      {
        return;
        if (!k(this.AC, paramArrayList)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("MatchViewHolder", 0, "updateData return for same data");
      return;
      if (this.handler.hasMessages(1)) {
        this.handler.removeMessages(1);
      }
      this.uinList.clear();
      this.uinList.addAll(paramArrayList);
      this.AC.clear();
      this.AC.addAll(paramArrayList);
      j = this.uinList.size();
      if (QLog.isColorLevel()) {
        QLog.d("MatchViewHolder", 0, "updateData _ infoListSize = " + j);
      }
      localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      int i;
      ImageView localImageView;
      if (j > 0)
      {
        i = 1;
        if (i == 0) {
          break;
        }
        this.ki.setVisibility(0);
        int k = this.AB.size();
        i = 0;
        if (i >= k) {
          continue;
        }
        localImageView = (ImageView)this.AB.get(i);
        if (i >= j) {
          break label325;
        }
        localObject = (String)paramArrayList.get(i);
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          break label349;
        }
        if (localQQAppInterface == null) {
          break label331;
        }
        Drawable localDrawable = aqhu.c(true);
        localObject = aqdj.a(localQQAppInterface, 1, (String)localObject, 4, localDrawable, localDrawable);
        ((aqdj)localObject).mutate();
        localDrawable = localImageView.getDrawable();
        if ((localDrawable != null) && (localDrawable != localObject) && ((localDrawable instanceof aqdj))) {
          ((aqdj)localDrawable).cancel();
        }
        localImageView.setImageDrawable((Drawable)localObject);
        localImageView.setVisibility(0);
      }
      for (;;)
      {
        i += 1;
        break label189;
        i = 0;
        break;
        localObject = null;
        break label225;
        localImageView.setImageDrawable(aqhu.c(true));
        localImageView.setVisibility(0);
        continue;
        localImageView.setVisibility(8);
      }
    } while (j <= this.AB.size());
    label325:
    label331:
    label349:
    paramArrayList = (String)this.uinList.get(this.uinList.size() - 1);
    if (localQQAppInterface != null)
    {
      localObject = aqhu.c(true);
      aqdj.a(localQQAppInterface, 1, paramArrayList, 4, (Drawable)localObject, (Drawable)localObject);
    }
    this.handler.sendEmptyMessageDelayed(1, 3000L);
    return;
    this.ki.setVisibility(8);
  }
  
  void ddZ()
  {
    int k = 0;
    int i = this.zr.getWidth();
    Object localObject1 = BaseApplicationImpl.getContext();
    int j = i - ((Context)localObject1).getResources().getDimensionPixelSize(2131298625);
    if (this.mStyle == 2)
    {
      j = ((Context)localObject1).getResources().getDimensionPixelSize(2131298633);
      i -= ((Context)localObject1).getResources().getDimensionPixelSize(2131298631);
    }
    for (;;)
    {
      Object localObject2 = ObjectAnimator.ofFloat(this.zs, "translationX", new float[] { 0.0F, j });
      Object localObject3 = ObjectAnimator.ofFloat(this.zs, "alpha", new float[] { 1.0F, 0.0F });
      ((ObjectAnimator)localObject2).setDuration(300);
      ((ObjectAnimator)localObject3).setDuration(300);
      localObject1 = new AnimatorSet();
      ((AnimatorSet)localObject1).playTogether(new Animator[] { localObject2, localObject3 });
      localObject3 = new afyy(this, (AnimatorSet)localObject1);
      localObject2 = new ArrayList();
      if (this.AB.size() > 1)
      {
        j = 0;
        for (;;)
        {
          if (j < this.AB.size() - 1)
          {
            TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, i, 0.0F, 0.0F);
            localTranslateAnimation.setDuration(300);
            localTranslateAnimation.setFillAfter(true);
            ((List)localObject2).add(localTranslateAnimation);
            j += 1;
            continue;
            if (this.mStyle != 3) {
              break label373;
            }
            j = ((Context)localObject1).getResources().getDimensionPixelSize(2131298636);
            i -= ((Context)localObject1).getResources().getDimensionPixelSize(2131298634);
            break;
          }
        }
        ((TranslateAnimation)((List)localObject2).get(0)).setAnimationListener((Animation.AnimationListener)localObject3);
        i = k;
        while (i < this.AB.size() - 1)
        {
          localObject3 = (ImageView)this.AB.get(i);
          ((ImageView)localObject3).clearAnimation();
          ((ImageView)localObject3).startAnimation((Animation)((List)localObject2).get(i));
          i += 1;
        }
      }
      ((AnimatorSet)localObject1).start();
      return;
      label373:
      i = j;
    }
  }
  
  public void ddz()
  {
    this.handler.removeCallbacksAndMessages(null);
  }
  
  public View getRootView()
  {
    return this.ki;
  }
  
  boolean k(List<String> paramList1, List<String> paramList2)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    int j = paramList1.size();
    int i;
    if (j == paramList2.size())
    {
      if (j <= 0) {
        break label97;
      }
      i = 0;
      bool2 = bool1;
      if (i >= j) {
        break label97;
      }
      String str1 = (String)paramList1.get(i);
      String str2 = (String)paramList2.get(i);
      if ((TextUtils.isEmpty(str1)) || (str1.equals(str2))) {
        break label133;
      }
      bool1 = false;
    }
    label133:
    for (;;)
    {
      i += 1;
      break;
      bool2 = false;
      label97:
      if (QLog.isColorLevel()) {
        QLog.d("MatchViewHolder", 0, "checkListEqual _ result = " + bool2);
      }
      return bool2;
    }
  }
  
  public void onDestroy()
  {
    ddz();
    this.b = null;
  }
  
  public void setUinList(ArrayList<String> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("MatchViewHolder", 0, "setUinList uins = 0");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("MatchViewHolder", 0, "setUinList uins = " + paramArrayList);
    }
    if (this.handler.hasMessages(2)) {
      this.handler.removeMessages(2);
    }
    paramArrayList = Message.obtain(this.handler, 2, paramArrayList);
    this.handler.sendMessage(paramArrayList);
  }
  
  void startAnimation()
  {
    if ((this.zr == null) || (this.zs == null)) {
      QLog.d("MatchViewHolder", 0, "startAnimation headFirst headLast null");
    }
    Object localObject1;
    do
    {
      return;
      localObject1 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    } while (localObject1 == null);
    this.isAnimating = true;
    if (this.zt != null)
    {
      this.zt.clearAnimation();
      this.ki.removeView(this.zt);
    }
    Object localObject2 = BaseApplicationImpl.getContext();
    this.zt = new ImageView((Context)localObject2);
    this.zt.setLayerType(1, null);
    if ((this.mStyle == 2) || (this.mStyle == 3)) {}
    for (int i = wja.dp2px(2.0F, ((Context)localObject2).getResources());; i = wja.dp2px(1.0F, ((Context)localObject2).getResources()))
    {
      this.zt.setPadding(i, i, i, i);
      this.zt.setBackgroundResource(2130846037);
      localObject2 = new RelativeLayout.LayoutParams(this.zr.getWidth(), this.zr.getHeight());
      ((RelativeLayout.LayoutParams)localObject2).addRule(7, 2131368376);
      ((RelativeLayout.LayoutParams)localObject2).addRule(6, 2131368376);
      this.ki.addView(this.zt, (ViewGroup.LayoutParams)localObject2);
      if (this.uinList.size() > 0) {}
      try
      {
        localObject2 = (String)this.uinList.remove(this.uinList.size() - 1);
        if (QLog.isColorLevel()) {
          QLog.d("MatchViewHolder", 0, "startAnimation targetUin = " + (String)localObject2);
        }
        this.uinList.add(0, localObject2);
        Drawable localDrawable = aqhu.c(true);
        localObject1 = aqdj.a((AppInterface)localObject1, 1, (String)localObject2, 4, localDrawable, localDrawable);
        ((aqdj)localObject1).mutate();
        this.zt.setImageDrawable((Drawable)localObject1);
        localObject1 = new ScaleAnimation(1.0F, 1.2F, 1.0F, 1.2F, 1, 0.5F, 1, 0.5F);
        ((ScaleAnimation)localObject1).setDuration(500);
        ((ScaleAnimation)localObject1).setFillAfter(true);
        ((ScaleAnimation)localObject1).setAnimationListener(new afyw(this));
        this.zt.startAnimation((Animation)localObject1);
        return;
      }
      catch (Exception localException)
      {
        QLog.d("MatchViewHolder", 1, "startAnimation Exception!", localException);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afyv
 * JD-Core Version:    0.7.0.1
 */