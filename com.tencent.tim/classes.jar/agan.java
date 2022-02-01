import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.Interpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.facetoface.Face2FaceAddFriendActivity;
import com.tencent.mobileqq.facetoface.Face2FaceFriendBubbleView;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class agan
{
  public static byte[] lock = new byte[0];
  public List<Face2FaceFriendBubbleView> AI;
  List<Integer> AJ;
  List<Integer> AK;
  List<Integer> AL;
  List<Integer> AM;
  List<Integer> AN = Arrays.asList(new Integer[] { Integer.valueOf(2131367595), Integer.valueOf(2131367597), Integer.valueOf(2131367598), Integer.valueOf(2131367599), Integer.valueOf(2131367600), Integer.valueOf(2131367601), Integer.valueOf(2131367602), Integer.valueOf(2131367603), Integer.valueOf(2131367604), Integer.valueOf(2131367596) });
  public QQAppInterface app;
  public int azH;
  public int azI;
  agba b = null;
  double cE = 0.0D;
  int cVZ = 1;
  int cWa = 0;
  int cWb = -1;
  int cWc = 0;
  int cWd = 0;
  int cWe = 0;
  int cWf = 0;
  boolean ccm = false;
  boolean ccn = false;
  int currentIndex;
  int flag = -1;
  Map<String, Integer> ku;
  RotateAnimation l;
  public Context mContext;
  float mR = 0.0F;
  float wo = 0.0F;
  ImageView zz;
  
  public agan(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    this.app = paramQQAppInterface;
    this.mContext = paramContext;
  }
  
  private static int randInt(int paramInt1, int paramInt2)
  {
    return (int)(Math.random() * (paramInt2 - paramInt1 + 1) + paramInt1);
  }
  
  public void Iy(String paramString)
  {
    if ((this.ku.containsKey(paramString)) && (!this.AJ.contains(paramString))) {
      this.AJ.add(this.ku.get(paramString));
    }
  }
  
  public void Iz(String paramString)
  {
    if (this.ku.containsKey(paramString)) {
      this.AJ.remove(this.ku.get(paramString));
    }
  }
  
  public void NL(int paramInt)
  {
    Face2FaceFriendBubbleView localFace2FaceFriendBubbleView = (Face2FaceFriendBubbleView)this.AI.get(paramInt);
    if ((localFace2FaceFriendBubbleView != null) && (localFace2FaceFriendBubbleView.uU() != null) && (this.ku.containsKey(localFace2FaceFriendBubbleView.uU())))
    {
      this.ku.remove(localFace2FaceFriendBubbleView.uU());
      localFace2FaceFriendBubbleView.setVisibility(4);
      localFace2FaceFriendBubbleView.setStatusWithoutAnimation(1);
      localFace2FaceFriendBubbleView.setClickable(false);
      if (QLog.isColorLevel()) {
        QLog.d(Face2FaceAddFriendActivity.TAG, 2, "removeShowedFriendMap uinToHoleIndex remove( " + localFace2FaceFriendBubbleView.uU() + ", " + paramInt + " )");
      }
    }
  }
  
  public Face2FaceFriendBubbleView a(String paramString)
  {
    Face2FaceFriendBubbleView localFace2FaceFriendBubbleView = null;
    if (this.ku.containsKey(paramString)) {
      localFace2FaceFriendBubbleView = (Face2FaceFriendBubbleView)this.AI.get(((Integer)this.ku.get(paramString)).intValue());
    }
    return localFace2FaceFriendBubbleView;
  }
  
  public void a(agba paramagba, boolean paramBoolean)
  {
    if ((paramagba == null) || (this.mContext == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d(Face2FaceAddFriendActivity.TAG, 2, "startFriendDisappearAnimation disappear data is " + paramagba + " mContext " + this.mContext);
      }
      return;
    }
    Object localObject = paramagba.bGh;
    if ((paramagba instanceof agay)) {
      localObject = paramagba.bGh + "_" + ((agay)paramagba).bGg;
    }
    if (this.ku.containsKey(localObject)) {}
    for (int i = ((Integer)this.ku.get(localObject)).intValue();; i = -1)
    {
      if (i == -1)
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d(Face2FaceAddFriendActivity.TAG, 2, "startFriendDisappearAnimation disappear uin " + paramagba.bGh.substring(0, 4) + " is not in the hole");
        QLog.d(Face2FaceAddFriendActivity.bFZ, 2, "startFriendDisappearAnimation disappear uin " + paramagba.bGh.substring(0, 4) + " is not in the hole");
        this.cWc += 1;
        return;
      }
      localObject = (Face2FaceFriendBubbleView)this.AI.get(i);
      if (paramBoolean)
      {
        ScaleAnimation localScaleAnimation = new ScaleAnimation(1.0F, 0.4F, 1.0F, 0.4F, 1, 0.5F, 1, 0.5F);
        AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
        AnimationSet localAnimationSet = new AnimationSet(true);
        localAnimationSet.addAnimation(localScaleAnimation);
        localAnimationSet.addAnimation(localAlphaAnimation);
        localAnimationSet.setDuration(1000L);
        localAnimationSet.setFillAfter(true);
        localAnimationSet.setInterpolator(new agan.b());
        localAnimationSet.setAnimationListener(new agap(this));
        if (localObject != null) {
          ((Face2FaceFriendBubbleView)localObject).startAnimation(localAnimationSet);
        }
      }
      if (localObject == null) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d(Face2FaceAddFriendActivity.TAG, 2, "startFriendDisappearAnimation disappear uin " + paramagba.bGh.substring(0, 4));
      }
      if (this.AJ.contains(Integer.valueOf(i))) {
        this.AJ.remove(Integer.valueOf(i));
      }
      NL(i);
      ((Face2FaceAddFriendActivity)this.mContext).e(paramagba);
      this.AK.add(Integer.valueOf(i));
      if ((i >= 2) && (i <= 7))
      {
        this.AL.add(Integer.valueOf(i));
        return;
      }
      if (((i < 0) || (i > 1)) && ((i < 8) || (i > 9))) {
        break;
      }
      this.AM.add(Integer.valueOf(i));
      return;
    }
  }
  
  public void a(agba paramagba, boolean paramBoolean1, int paramInt, boolean paramBoolean2, boolean paramBoolean3)
  {
    if ((paramagba == null) || (this.mContext == null)) {
      if (QLog.isColorLevel()) {
        QLog.d(Face2FaceAddFriendActivity.TAG, 2, "startFriendInAnimation  data is " + paramagba + " mContext " + this.mContext);
      }
    }
    int j;
    int i;
    label91:
    Object localObject1;
    do
    {
      do
      {
        return;
        j = -1;
        if (this.AK.size() != 1) {
          break;
        }
        i = ((Integer)this.AK.get(0)).intValue();
      } while (i == -1);
      localObject1 = (Face2FaceFriendBubbleView)this.AI.get(i);
      this.currentIndex = i;
    } while (localObject1 == null);
    this.b = paramagba;
    ((Face2FaceFriendBubbleView)localObject1).a(this.app, paramagba);
    ((Face2FaceFriendBubbleView)localObject1).setVisibility(0);
    ((Face2FaceFriendBubbleView)localObject1).setClickable(true);
    label218:
    Object localObject2;
    int i3;
    int i5;
    int i4;
    int i6;
    int i1;
    int i2;
    label398:
    int m;
    int n;
    label459:
    int k;
    if (QLog.isColorLevel())
    {
      if (!TextUtils.isEmpty(paramagba.bGh)) {
        QLog.d(Face2FaceAddFriendActivity.TAG, 2, "startFriendInAnimation get ( currentUin= " + paramagba.bGh.substring(0, 4) + " , index = " + i + " )");
      }
    }
    else
    {
      this.cVZ = 1;
      this.ccn = false;
      this.flag = -1;
      localObject2 = new int[2];
      this.zz.getLocationOnScreen((int[])localObject2);
      i3 = localObject2[0] + (this.zz.getWidth() >> 1);
      i5 = localObject2[1] + (this.zz.getHeight() >> 1);
      localObject2 = new int[2];
      ((Face2FaceFriendBubbleView)localObject1).getLocationOnScreen((int[])localObject2);
      i4 = localObject2[0] + (((Face2FaceFriendBubbleView)localObject1).getWidth() >> 1);
      i6 = localObject2[1] + (((Face2FaceFriendBubbleView)localObject1).getHeight() >> 1);
      i1 = Math.abs(i3 - i4);
      i2 = Math.abs(i5 - i6);
      this.cE = (i1 / i2);
      j = ((Face2FaceFriendBubbleView)localObject1).getWidth();
      if (i1 != 0) {
        break label1105;
      }
      j = (((Face2FaceFriendBubbleView)localObject1).getHeight() >> 1) + i5;
      if (i6 > i5) {
        j = this.azI - i5 + (((Face2FaceFriendBubbleView)localObject1).getHeight() >> 1);
      }
      m = localObject2[0] + ((Face2FaceFriendBubbleView)localObject1).getWidth();
      n = j - i2;
      if (i6 > i5) {
        this.cVZ = 2;
      }
      if (i4 > i3)
      {
        m = this.azH - localObject2[0];
        if (i6 >= i5) {
          break label1123;
        }
        this.cVZ = 5;
      }
      if (j - i5 < ((Face2FaceFriendBubbleView)localObject1).getHeight() >> 1)
      {
        k = n;
        if (j - (this.azI - i5) < ((Face2FaceFriendBubbleView)localObject1).getHeight() >> 1) {}
      }
      else
      {
        if (i6 >= i5) {
          break label1140;
        }
        k = i5 + (((Face2FaceFriendBubbleView)localObject1).getHeight() >> 1);
        j = localObject2[1] + ((Face2FaceFriendBubbleView)localObject1).getHeight();
        if (i4 >= i3) {
          break label1132;
        }
        this.cVZ = 3;
      }
    }
    for (;;)
    {
      label541:
      m = k * i1 / i2 - i1;
      k = j;
      switch (this.cVZ)
      {
      default: 
        j = m;
        label612:
        double d = this.cE;
        boolean bool = this.ccn;
        localObject2 = new TranslateAnimation(j, 0.0F, k, 0.0F);
        ((TranslateAnimation)localObject2).setDuration(400L);
        ((TranslateAnimation)localObject2).setInterpolator(new agan.b());
        ((TranslateAnimation)localObject2).setAnimationListener(new agao(this, paramagba, i, d, bool, paramBoolean3, paramagba, paramBoolean1, paramBoolean2, (Face2FaceFriendBubbleView)localObject1, paramInt));
        ((Face2FaceFriendBubbleView)localObject1).startAnimation((Animation)localObject2);
        localObject1 = paramagba.bGh;
        if ((paramagba instanceof agay)) {
          localObject1 = paramagba.bGh + "_" + ((agay)paramagba).bGg;
        }
        break;
      }
      for (;;)
      {
        this.ku.put(localObject1, Integer.valueOf(i));
        ((Face2FaceAddFriendActivity)this.mContext).a(paramagba, paramBoolean1, paramBoolean2);
        if (QLog.isColorLevel()) {
          QLog.d(Face2FaceAddFriendActivity.bFZ, 2, "uinToHoleIndex put identify=" + (String)localObject1);
        }
        this.AK.remove(Integer.valueOf(i));
        if (this.AL.contains(Integer.valueOf(i))) {
          this.AL.remove(Integer.valueOf(i));
        }
        while (QLog.isColorLevel())
        {
          QLog.d(Face2FaceAddFriendActivity.TAG, 2, "startFriendInAnimation currentUIn= " + paramagba.bGh.substring(0, 4) + " startAnimation OK");
          return;
          i = j;
          if (this.AK.size() <= 1) {
            break label91;
          }
          if (this.AL.size() == 1)
          {
            i = ((Integer)this.AL.get(0)).intValue();
            break label91;
          }
          if (this.AL.size() > 1)
          {
            i = ((Integer)this.AL.get(randInt(0, this.AL.size() - 1))).intValue();
            break label91;
          }
          if (this.AM.size() == 0)
          {
            i = ((Integer)this.AM.get(0)).intValue();
            break label91;
          }
          i = j;
          if (this.AM.size() <= 1) {
            break label91;
          }
          i = ((Integer)this.AM.get(randInt(0, this.AM.size() - 1))).intValue();
          break label91;
          QLog.d(Face2FaceAddFriendActivity.TAG, 2, "startFriendInAnimation get  currentUin= null");
          break label218;
          label1105:
          j = ((j >> 1) + i3) * i2 / i1;
          break label398;
          label1123:
          this.cVZ = 6;
          break label459;
          label1132:
          this.cVZ = 4;
          break label541;
          label1140:
          if (i6 <= i5) {
            break label1402;
          }
          j = this.azI;
          k = (((Face2FaceFriendBubbleView)localObject1).getHeight() >> 1) + (j - i5);
          j = this.azI - localObject2[1];
          if (i4 < i3)
          {
            this.cVZ = 7;
            break label541;
          }
          this.cVZ = 8;
          break label541;
          j = -m;
          k = -k;
          this.flag = -1;
          this.ccn = false;
          break label612;
          j = -m;
          this.flag = -1;
          this.ccn = true;
          break label612;
          j = -m;
          k = -k;
          this.flag = -1;
          this.ccn = false;
          break label612;
          k = -k;
          this.flag = 1;
          this.ccn = false;
          j = m;
          break label612;
          k = -k;
          this.flag = 1;
          this.ccn = false;
          j = m;
          break label612;
          this.flag = 1;
          this.ccn = true;
          j = m;
          break label612;
          j = -m;
          this.flag = -1;
          this.ccn = true;
          break label612;
          this.flag = 1;
          this.ccn = true;
          j = m;
          break label612;
          if (this.AM.contains(Integer.valueOf(i))) {
            this.AM.remove(Integer.valueOf(i));
          }
        }
      }
      label1402:
      k = j;
      j = n;
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, View paramView, int paramInt, String paramString)
  {
    if (this.mContext == null) {
      return;
    }
    this.azH = this.mContext.getResources().getDisplayMetrics().widthPixels;
    this.azI = this.mContext.getResources().getDisplayMetrics().heightPixels;
    this.zz = ((ImageView)paramView.findViewById(2131365114));
    if ((paramInt == 1) && (!TextUtils.isEmpty(paramString)))
    {
      ((ImageView)paramView.findViewById(2131365115)).setVisibility(4);
      this.zz.setImageResource(2130840374);
      paramQQAppInterface = paramQQAppInterface.a(paramString, (byte)3, false, false);
      if (paramQQAppInterface != null) {
        break label476;
      }
      paramQQAppInterface = aqhu.aL();
    }
    label476:
    for (;;)
    {
      paramString = (ImageView)paramView.findViewById(2131380263);
      paramString.setImageBitmap(paramQQAppInterface);
      paramString.setVisibility(0);
      this.AI = new ArrayList();
      paramInt = 0;
      while (paramInt < 10)
      {
        paramQQAppInterface = (Face2FaceFriendBubbleView)paramView.findViewById(((Integer)this.AN.get(paramInt)).intValue());
        paramQQAppInterface.setStatusWithAnimation(1);
        paramQQAppInterface.setOnClickListener((View.OnClickListener)this.mContext);
        this.AI.add(paramQQAppInterface);
        paramInt += 1;
      }
      this.AJ = new LinkedList();
      this.ku = new HashMap();
      this.AK = new LinkedList();
      this.AK.addAll(Arrays.asList(new Integer[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(4), Integer.valueOf(5), Integer.valueOf(6), Integer.valueOf(7), Integer.valueOf(8), Integer.valueOf(9) }));
      this.AL = new LinkedList();
      this.AL.addAll(Arrays.asList(new Integer[] { Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(4), Integer.valueOf(5), Integer.valueOf(6), Integer.valueOf(7) }));
      this.AM = new LinkedList();
      this.AM.addAll(Arrays.asList(new Integer[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(8), Integer.valueOf(9) }));
      return;
    }
  }
  
  public void bz(int paramInt, boolean paramBoolean)
  {
    if (this.mContext == null) {
      return;
    }
    if (paramInt == 1)
    {
      this.wo = g(45, 180);
      if (g(0, 1) < 0.5D) {
        this.wo *= -1.0F;
      }
    }
    for (long l1 = g(800, 1500);; l1 = 750L)
    {
      RotateAnimation localRotateAnimation = new RotateAnimation(this.mR, this.wo, 1, 0.5F, 1, 0.5F);
      localRotateAnimation.setDuration(l1);
      localRotateAnimation.setFillAfter(true);
      localRotateAnimation.setInterpolator(new agan.a());
      this.zz.startAnimation(localRotateAnimation);
      localRotateAnimation.setAnimationListener(new agaq(this, paramInt, paramBoolean));
      return;
    }
  }
  
  public void clearData()
  {
    this.ku.clear();
    this.AJ.clear();
    this.AK.clear();
    this.AL.clear();
    this.AM.clear();
    this.AI.clear();
  }
  
  public void deD()
  {
    if (this.mContext == null) {
      return;
    }
    long l1 = g(800, 1200);
    float f1 = this.wo;
    int i = (int)g(5, 12);
    if (this.ccm)
    {
      this.ccm = false;
      this.wo = (this.mR - i);
      if (f1 == this.wo) {
        if (this.wo <= this.mR) {
          break label192;
        }
      }
    }
    label192:
    float f2;
    for (this.wo = (this.mR - i);; this.wo = (i + f2))
    {
      this.l = new RotateAnimation(f1, this.wo, 1, 0.5F, 1, 0.5F);
      this.l.setDuration(l1);
      this.l.setFillAfter(true);
      this.l.setInterpolator(new agan.a());
      this.zz.startAnimation(this.l);
      this.l.setAnimationListener(new agar(this));
      return;
      this.ccm = true;
      this.wo = (this.mR + i);
      break;
      f2 = this.mR;
    }
  }
  
  public void deE()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Face2FaceAddFriendActivity", 2, "stopCompassShakeAnimation");
    }
    if (this.l != null) {
      this.l.cancel();
    }
    if (this.zz != null) {
      this.zz.clearAnimation();
    }
  }
  
  public float g(int paramInt1, int paramInt2)
  {
    return (float)(Math.random() * (paramInt2 - paramInt1) + paramInt1);
  }
  
  class a
    implements Interpolator
  {
    a() {}
    
    public float getInterpolation(float paramFloat)
    {
      if (paramFloat == 0.0F) {
        return 0.0F;
      }
      float f = paramFloat * 2.0F;
      if (f >= 2.0F) {
        return 1.0F;
      }
      paramFloat = 0.45F / 4.0F;
      if (f < 1.0F)
      {
        f -= 1.0F;
        d = Math.pow(2.0D, 10.0F * f);
        return (float)(Math.sin((f - paramFloat) * 6.283185307179586D / 0.45F) * (-0.5D * d));
      }
      f -= 1.0F;
      double d = Math.pow(2.0D, -10.0F * f);
      return (float)(Math.sin((f - paramFloat) * 6.283185307179586D / 0.45F) * (0.5D * d)) + 1.0F;
    }
  }
  
  class b
    implements Interpolator
  {
    b() {}
    
    public float getInterpolation(float paramFloat)
    {
      paramFloat -= 1.0F;
      return 1.0F - paramFloat * (paramFloat * paramFloat * paramFloat);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agan
 * JD-Core Version:    0.7.0.1
 */