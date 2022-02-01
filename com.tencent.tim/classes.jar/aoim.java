import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
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

public class aoim
{
  List<ImageView> AB;
  List<String> AC = new ArrayList();
  ImageView DV;
  ImageView DW;
  ImageView DX;
  Handler.Callback b = new aoir(this);
  Handler handler;
  volatile boolean isAnimating;
  RelativeLayout ki;
  private int radius;
  List<String> uinList = new ArrayList();
  ImageView zt;
  
  public aoim()
  {
    Object localObject = BaseApplicationImpl.getContext();
    this.handler = new Handler(Looper.getMainLooper(), this.b);
    this.radius = wja.dp2px(4.0F, ((Context)localObject).getResources());
    this.AB = new ArrayList();
    this.ki = ((RelativeLayout)View.inflate((Context)localObject, 2131561733, null));
    this.DV = ((ImageView)this.ki.findViewById(2131368376));
    this.DW = ((ImageView)this.ki.findViewById(2131368377));
    this.DX = ((ImageView)this.ki.findViewById(2131368378));
    int i = 0;
    while (i < this.ki.getChildCount())
    {
      localObject = (ImageView)this.ki.getChildAt(i);
      ((ImageView)localObject).setVisibility(8);
      this.AB.add(localObject);
      i += 1;
    }
    this.ki.setVisibility(8);
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
          break label319;
        }
        localObject = (String)paramArrayList.get(i);
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          break label343;
        }
        if (localQQAppInterface == null) {
          break label325;
        }
        Drawable localDrawable = aqhu.c(true);
        localObject = aqdj.a(localQQAppInterface, 1, (String)localObject, 4, localDrawable, localDrawable);
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
    } while (j <= 3);
    label319:
    label325:
    label343:
    paramArrayList = (String)this.uinList.get(3);
    if (localQQAppInterface != null)
    {
      localObject = aqhu.c(true);
      aqdj.a(localQQAppInterface, 1, paramArrayList, 4, (Drawable)localObject, (Drawable)localObject);
    }
    this.handler.sendEmptyMessageDelayed(1, 5000L);
    return;
    this.ki.setVisibility(8);
  }
  
  void ddZ()
  {
    int j = this.DV.getWidth() - wja.dp2px(5.0F, BaseApplicationImpl.getContext().getResources());
    Object localObject1 = ObjectAnimator.ofFloat(this.DX, "translationX", new float[] { 0.0F, j });
    Object localObject2 = ObjectAnimator.ofFloat(this.DX, "alpha", new float[] { 1.0F, 0.0F });
    ((ObjectAnimator)localObject1).setDuration(300);
    ((ObjectAnimator)localObject2).setDuration(300);
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.playTogether(new Animator[] { localObject1, localObject2 });
    localObject2 = new aoip(this, localAnimatorSet);
    localObject1 = new ArrayList();
    int i = 0;
    while (i < 2)
    {
      TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, j, 0.0F, 0.0F);
      localTranslateAnimation.setDuration(300);
      localTranslateAnimation.setFillAfter(true);
      ((List)localObject1).add(localTranslateAnimation);
      i += 1;
    }
    ((TranslateAnimation)((List)localObject1).get(0)).setAnimationListener((Animation.AnimationListener)localObject2);
    i = 0;
    while (i < 2)
    {
      localObject2 = (ImageView)this.AB.get(i);
      ((ImageView)localObject2).clearAnimation();
      ((ImageView)localObject2).startAnimation((Animation)((List)localObject1).get(i));
      i += 1;
    }
    localAnimatorSet.start();
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
    this.handler = null;
    this.b = null;
  }
  
  public void resumeAnimation()
  {
    if ((this.handler != null) && (!this.handler.hasMessages(1))) {
      this.handler.sendEmptyMessageDelayed(1, 5000L);
    }
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
    Object localObject1 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (localObject1 == null) {
      return;
    }
    this.isAnimating = true;
    if (this.zt != null)
    {
      this.zt.clearAnimation();
      this.ki.removeView(this.zt);
    }
    Object localObject2 = BaseApplicationImpl.getContext();
    this.zt = new ImageView((Context)localObject2);
    int i = wja.dp2px(1.0F, ((Context)localObject2).getResources());
    this.zt.setPadding(i, i, i, i);
    this.zt.setBackgroundResource(2130846036);
    localObject2 = new RelativeLayout.LayoutParams(this.DV.getWidth(), this.DV.getHeight());
    ((RelativeLayout.LayoutParams)localObject2).addRule(7, 2131368376);
    ((RelativeLayout.LayoutParams)localObject2).addRule(6, 2131368376);
    this.ki.addView(this.zt, (ViewGroup.LayoutParams)localObject2);
    try
    {
      localObject2 = (String)this.uinList.remove(this.uinList.size() - 1);
      if (QLog.isColorLevel()) {
        QLog.d("MatchViewHolder", 0, "startAnimation targetUin = " + (String)localObject2);
      }
      this.uinList.add(0, localObject2);
      Drawable localDrawable = aqhu.c(true);
      localObject1 = aqdj.a((AppInterface)localObject1, 1, (String)localObject2, 4, localDrawable, localDrawable);
      this.zt.setImageDrawable((Drawable)localObject1);
      localObject1 = new ScaleAnimation(1.0F, 1.2F, 1.0F, 1.2F, 1, 0.5F, 1, 0.5F);
      ((ScaleAnimation)localObject1).setDuration(500);
      ((ScaleAnimation)localObject1).setFillAfter(true);
      ((ScaleAnimation)localObject1).setAnimationListener(new aoin(this));
      this.zt.startAnimation((Animation)localObject1);
      return;
    }
    catch (Exception localException)
    {
      QLog.d("MatchViewHolder", 1, "startAnimation Exception!", localException);
    }
  }
  
  public void stopAnimation()
  {
    if ((this.handler != null) && (this.handler.hasMessages(1))) {
      this.handler.removeMessages(1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aoim
 * JD-Core Version:    0.7.0.1
 */