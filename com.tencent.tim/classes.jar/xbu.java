import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.LruCache;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.e;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.item.CustomFrameAnimationDrawable;
import com.tencent.mobileqq.activity.aio.item.CustomFrameAnimationDrawable.b;
import com.tencent.mobileqq.activity.aio.item.CustomFrameAnimationDrawable.e;
import com.tencent.mobileqq.activity.aio.item.GivingHeartItemBuilder.10;
import com.tencent.mobileqq.activity.aio.item.GivingHeartItemBuilder.5;
import com.tencent.mobileqq.activity.aio.item.SixCombolEffectView;
import com.tencent.mobileqq.activity.aio.item.SixCombolEffectView.b;
import com.tencent.mobileqq.activity.aio.item.UnlimitedBladeWorks;
import com.tencent.mobileqq.activity.aio.item.UnlimitedBladeWorks.c;
import com.tencent.mobileqq.activity.history.ChatHistoryActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.utils.PokeBigResHandler;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForPoke;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import com.tencent.mobileqq.dinifly.ViewAnimation;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.mobileqq.vas.VasQuickUpdateManager.CallBacker;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.FitSystemWindowsRelativeLayout;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import mqq.os.MqqHandler;

public class xbu
  extends BaseBubbleBuilder
  implements SixCombolEffectView.b
{
  private static int bSY;
  private static int bSZ;
  public static volatile boolean bgT;
  private static Map<Long, MessageForPoke> hI = new ConcurrentHashMap();
  private static Map<Long, MessageForPoke> hJ = new ConcurrentHashMap();
  protected static final Handler mHandler = new Handler(Looper.getMainLooper());
  ViewAnimation a;
  int bPr = -1;
  VasQuickUpdateManager.CallBacker c = new xbu.d();
  aqrd jdField_d_of_type_Aqrd = new xbz(this);
  private VasQuickUpdateManager.CallBacker jdField_d_of_type_ComTencentMobileqqVasVasQuickUpdateManager$CallBacker;
  private View.OnClickListener dQ = new xbu.c();
  Runnable eq = null;
  DiniFlyAnimationView g;
  private Map<Integer, Integer> hK;
  public QQAppInterface mApp;
  private float mStrength = 1.0F;
  private View.OnClickListener onClickListener = new xbu.b(null);
  private LruCache<Long, MessageForPoke> p;
  int pay_type = 1;
  
  public xbu(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.mApp = paramQQAppInterface;
    dn(paramContext);
    jdMethod_do(paramContext);
  }
  
  @Deprecated
  public static boolean I(MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord instanceof MessageForPoke)) {
      return (((MessageForPoke)paramMessageRecord).flag & 0x1) == 1;
    }
    return false;
  }
  
  private int a(xbu.a parama)
  {
    switch (((MessageForPoke)parama.mMessage).interactType)
    {
    default: 
      return ankt.dip2px(parama.strength * 100.0F);
    case 0: 
    case 1: 
      if (parama.strength == 2.0F) {
        return ankt.dip2px(150.0F * parama.strength);
      }
      return ankt.dip2px(parama.strength * 100.0F);
    case 2: 
      return ankt.dip2px(280.0F * parama.strength);
    case 3: 
      return ankt.dip2px(90.0F * parama.strength);
    case 4: 
      return ankt.dip2px(parama.strength * 100.0F);
    case 6: 
      return 0;
    }
    return ankt.dip2px(230.0F * parama.strength);
  }
  
  public static AnimationSet a(Context paramContext, boolean paramBoolean)
  {
    int k = 0;
    AnimationSet localAnimationSet = new AnimationSet(false);
    long l = 350L;
    int[] arrayOfInt = new int[4];
    int[] tmp25_23 = arrayOfInt;
    tmp25_23[0] = '';
    int[] tmp31_25 = tmp25_23;
    tmp31_25[1] = '';
    int[] tmp37_31 = tmp31_25;
    tmp37_31[2] = '';
    int[] tmp43_37 = tmp37_31;
    tmp43_37[3] = '';
    tmp43_37;
    int i;
    int j;
    if (paramBoolean)
    {
      i = wja.dp2px(22.0F, paramContext.getResources());
      j = wja.dp2px(30.0F, paramContext.getResources());
      if (!paramBoolean) {
        break label184;
      }
      paramContext = new int[4];
      paramContext[0] = (-i);
      paramContext[1] = i;
      paramContext[2] = (-j);
      paramContext[3] = j;
      label100:
      j = arrayOfInt.length;
      i = k;
      label107:
      if (i >= j) {
        break label437;
      }
      switch (i)
      {
      }
    }
    for (;;)
    {
      l += arrayOfInt[i];
      i += 1;
      break label107;
      i = wja.dp2px(15.0F, paramContext.getResources());
      j = wja.dp2px(20.0F, paramContext.getResources());
      break;
      label184:
      paramContext = new int[4];
      paramContext[0] = i;
      paramContext[1] = (-i);
      paramContext[2] = j;
      paramContext[3] = (-j);
      break label100;
      TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, paramContext[i], 0.0F, 0.0F);
      localTranslateAnimation.setDuration(arrayOfInt[i]);
      localTranslateAnimation.setStartOffset(l);
      localTranslateAnimation.setInterpolator(new AccelerateInterpolator());
      localAnimationSet.addAnimation(localTranslateAnimation);
      continue;
      localTranslateAnimation = new TranslateAnimation(0.0F, paramContext[i], 0.0F, 0.0F);
      localTranslateAnimation.setDuration(arrayOfInt[i]);
      localTranslateAnimation.setStartOffset(l);
      localTranslateAnimation.setInterpolator(new DecelerateInterpolator());
      localAnimationSet.addAnimation(localTranslateAnimation);
      continue;
      localTranslateAnimation = new TranslateAnimation(0.0F, paramContext[i], 0.0F, 0.0F);
      localTranslateAnimation.setDuration(arrayOfInt[i]);
      l += 80L;
      localTranslateAnimation.setStartOffset(l);
      localTranslateAnimation.setInterpolator(new AccelerateInterpolator());
      localAnimationSet.addAnimation(localTranslateAnimation);
      continue;
      localTranslateAnimation = new TranslateAnimation(0.0F, paramContext[i], 0.0F, 0.0F);
      localTranslateAnimation.setDuration(arrayOfInt[i]);
      localTranslateAnimation.setStartOffset(l);
      localTranslateAnimation.setInterpolator(new DecelerateInterpolator());
      localAnimationSet.addAnimation(localTranslateAnimation);
    }
    label437:
    return localAnimationSet;
  }
  
  private AnimationSet a(boolean paramBoolean)
  {
    AnimationSet localAnimationSet = a(this.mContext, paramBoolean);
    long l = 1270L;
    int[] arrayOfInt2 = new int[6];
    int[] tmp23_21 = arrayOfInt2;
    tmp23_21[0] = 510;
    int[] tmp29_23 = tmp23_21;
    tmp29_23[1] = 120;
    int[] tmp34_29 = tmp29_23;
    tmp34_29[2] = 120;
    int[] tmp39_34 = tmp34_29;
    tmp39_34[3] = 120;
    int[] tmp44_39 = tmp39_34;
    tmp44_39[4] = 120;
    int[] tmp49_44 = tmp44_39;
    tmp49_44[5] = 120;
    tmp49_44;
    int[] arrayOfInt1;
    int i;
    if (paramBoolean)
    {
      arrayOfInt1 = new int[7];
      int[] tmp67_65 = arrayOfInt1;
      tmp67_65[0] = -160;
      int[] tmp73_67 = tmp67_65;
      tmp73_67[1] = -10;
      int[] tmp78_73 = tmp73_67;
      tmp78_73[2] = 'ð';
      int[] tmp84_78 = tmp78_73;
      tmp84_78[3] = -120;
      int[] tmp89_84 = tmp84_78;
      tmp89_84[4] = 70;
      int[] tmp94_89 = tmp89_84;
      tmp94_89[5] = -50;
      int[] tmp99_94 = tmp94_89;
      tmp99_94[6] = 30;
      tmp99_94;
      int j = arrayOfInt2.length;
      i = 0;
      label112:
      if (i >= j) {
        break label447;
      }
      switch (i)
      {
      }
    }
    for (;;)
    {
      l += arrayOfInt2[i];
      i += 1;
      break label112;
      arrayOfInt1 = new int[7];
      int[] tmp173_171 = arrayOfInt1;
      tmp173_171[0] = ' ';
      int[] tmp179_173 = tmp173_171;
      tmp179_173[1] = 10;
      int[] tmp184_179 = tmp179_173;
      tmp184_179[2] = -240;
      int[] tmp190_184 = tmp184_179;
      tmp190_184[3] = 120;
      int[] tmp195_190 = tmp190_184;
      tmp195_190[4] = -70;
      int[] tmp200_195 = tmp195_190;
      tmp200_195[5] = 50;
      int[] tmp205_200 = tmp200_195;
      tmp205_200[6] = -30;
      tmp205_200;
      break;
      TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, arrayOfInt1[i], 0.0F, 0.0F);
      localTranslateAnimation.setDuration(arrayOfInt2[i]);
      localTranslateAnimation.setStartOffset(l);
      localTranslateAnimation.setInterpolator(new LinearInterpolator());
      localAnimationSet.addAnimation(localTranslateAnimation);
      continue;
      localTranslateAnimation = new TranslateAnimation(0.0F, arrayOfInt1[i], 0.0F, 0.0F);
      localTranslateAnimation.setDuration(arrayOfInt2[i]);
      localTranslateAnimation.setStartOffset(l);
      localTranslateAnimation.setInterpolator(new DecelerateInterpolator());
      localAnimationSet.addAnimation(localTranslateAnimation);
      continue;
      localTranslateAnimation = new TranslateAnimation(0.0F, arrayOfInt1[i], 0.0F, 0.0F);
      localTranslateAnimation.setDuration(arrayOfInt2[i]);
      l += 80L;
      localTranslateAnimation.setStartOffset(l);
      localTranslateAnimation.setInterpolator(new AccelerateInterpolator());
      localAnimationSet.addAnimation(localTranslateAnimation);
      continue;
      localTranslateAnimation = new TranslateAnimation(0.0F, arrayOfInt1[i], 0.0F, 0.0F);
      localTranslateAnimation.setDuration(arrayOfInt2[i]);
      localTranslateAnimation.setStartOffset(l);
      localTranslateAnimation.setInterpolator(new DecelerateInterpolator());
      localAnimationSet.addAnimation(localTranslateAnimation);
    }
    label447:
    return localAnimationSet;
  }
  
  private static CustomFrameAnimationDrawable a(CustomFrameAnimationDrawable paramCustomFrameAnimationDrawable)
  {
    int k = 5;
    paramCustomFrameAnimationDrawable.clearFrame();
    paramCustomFrameAnimationDrawable.au(0, 340, 2130838528);
    int i = 0;
    while (i < 6)
    {
      paramCustomFrameAnimationDrawable.au(i, 40, 2130838528 + i);
      i += 1;
    }
    i = 5;
    while (i > 0)
    {
      paramCustomFrameAnimationDrawable.au(i, 30, 2130838528 + i);
      i -= 1;
    }
    i = 0;
    int j;
    for (;;)
    {
      j = k;
      if (i >= 6) {
        break;
      }
      paramCustomFrameAnimationDrawable.au(i, 40, 2130838528 + i);
      i += 1;
    }
    while (j > 0)
    {
      paramCustomFrameAnimationDrawable.au(j, 30, 2130838528 + j);
      j -= 1;
    }
    paramCustomFrameAnimationDrawable.au(0, 160, 2130838528);
    return paramCustomFrameAnimationDrawable;
  }
  
  private void a(long paramLong, MessageForPoke paramMessageForPoke)
  {
    if (this.p == null) {
      this.p = new xbv(this, bSY);
    }
    this.p.put(Long.valueOf(paramLong), paramMessageForPoke);
  }
  
  private void a(CustomFrameAnimationDrawable paramCustomFrameAnimationDrawable)
  {
    int n = 8;
    int i1 = 4;
    paramCustomFrameAnimationDrawable.clearFrame();
    String str = PokeBigResHandler.brt + "/chuo_caidan/chuo_caidan_";
    paramCustomFrameAnimationDrawable.u(0, 340, str + "01.png");
    int j = 0;
    int i = 0;
    while (j < 5)
    {
      paramCustomFrameAnimationDrawable.u(i, 45, str + "0" + (j + 1) + ".png");
      j += 1;
      i += 1;
    }
    j = 4;
    while (j > 0)
    {
      paramCustomFrameAnimationDrawable.u(i, 30, str + "0" + (j + 1) + ".png");
      j -= 1;
      i += 1;
    }
    j = 0;
    int m;
    for (;;)
    {
      k = i1;
      m = i;
      if (j >= 5) {
        break;
      }
      paramCustomFrameAnimationDrawable.u(i, 45, str + "0" + (j + 1) + ".png");
      j += 1;
      i += 1;
    }
    while (k > 0)
    {
      paramCustomFrameAnimationDrawable.u(m, 30, str + "0" + (k + 1) + ".png");
      k -= 1;
      m += 1;
    }
    paramCustomFrameAnimationDrawable.u(m, 240, str + "01.png");
    j = m + 1;
    int k = 0;
    for (;;)
    {
      m = n;
      i = j;
      if (k >= 8) {
        break;
      }
      paramCustomFrameAnimationDrawable.u(j, 30, str + "0" + (k + 1) + ".png");
      k += 1;
      j += 1;
    }
    while (m < 10)
    {
      paramCustomFrameAnimationDrawable.u(i, 150, str + "0" + (m + 1) + ".png");
      m += 1;
      i += 1;
    }
    j = 9;
    if (j >= 0)
    {
      if (j % 2 != 0) {
        break label573;
      }
      k = i + 1;
      paramCustomFrameAnimationDrawable.u(i, 40, str + "0" + (j + 1) + ".png");
      i = k;
    }
    label573:
    for (;;)
    {
      j -= 1;
      break;
      paramCustomFrameAnimationDrawable.u(i, 330, str + "01.png");
      return;
    }
  }
  
  private void a(xbu.a parama, MessageForPoke paramMessageForPoke)
  {
    RelativeLayout.LayoutParams localLayoutParams1 = (RelativeLayout.LayoutParams)parama.h.getLayoutParams();
    Object localObject1 = (RelativeLayout.LayoutParams)((ViewGroup)parama.h.getParent()).getLayoutParams();
    RelativeLayout.LayoutParams localLayoutParams2 = (RelativeLayout.LayoutParams)parama.hD.getLayoutParams();
    Object localObject2 = (RelativeLayout.LayoutParams)parama.sZ.getLayoutParams();
    Object localObject3 = (RelativeLayout.LayoutParams)parama.tb.getLayoutParams();
    Object localObject4 = (RelativeLayout.LayoutParams)parama.a.getLayoutParams();
    RelativeLayout.LayoutParams localLayoutParams3 = (RelativeLayout.LayoutParams)parama.wE.getLayoutParams();
    parama.progressBar.setVisibility(8);
    parama.ta.setVisibility(8);
    parama.tb.setVisibility(8);
    parama.wE.setVisibility(8);
    int i;
    label415:
    label480:
    int j;
    switch (paramMessageForPoke.strength)
    {
    default: 
      parama.strength = this.mStrength;
      cdL();
      if (126 != paramMessageForPoke.interactType) {
        break label1328;
      }
      localLayoutParams1.height = ankt.dip2px(70.0F);
      localLayoutParams1.topMargin = ankt.dip2px(10.0F);
      localLayoutParams1.bottomMargin = ankt.dip2px(10.0F);
      ((RelativeLayout.LayoutParams)localObject2).width = ankt.dip2px(70.0F);
      ((RelativeLayout.LayoutParams)localObject2).height = ankt.dip2px(70.0F);
      parama.h.setScaleType(ImageView.ScaleType.FIT_CENTER);
      parama.sZ.setScaleType(ImageView.ScaleType.FIT_CENTER);
      ((RelativeLayout.LayoutParams)localObject1).height = ankt.dip2px(90.0F);
      localLayoutParams2.leftMargin = 0;
      localLayoutParams2.rightMargin = 0;
      localLayoutParams2.width = ankt.dip2px(90.0F);
      localLayoutParams2.height = ankt.dip2px(90.0F);
      if ((this.hK != null) && (!this.hK.isEmpty()) && (this.hK.containsKey(Integer.valueOf(paramMessageForPoke.subId))))
      {
        i = ((Integer)this.hK.get(Integer.valueOf(paramMessageForPoke.subId))).intValue();
        if ((4 == i) || (5 == i))
        {
          localObject1 = aqhu.g(this.mContext.getResources(), 2130838322);
          localObject4 = aqhu.g(this.mContext.getResources(), 2130838323);
          localObject1 = auqy.a(this.mContext.getResources(), (Bitmap)localObject1, (Bitmap)localObject4);
          parama.tb.setImageDrawable((Drawable)localObject1);
        }
      }
      else
      {
        if (!paramMessageForPoke.isSend()) {
          break label992;
        }
        parama.sZ.setScaleX(1.0F);
        parama.h.setScaleX(1.0F);
        ((RelativeLayout.LayoutParams)localObject2).leftMargin = ankt.dip2px(20.0F);
        ((RelativeLayout.LayoutParams)localObject2).rightMargin = 0;
        ((RelativeLayout.LayoutParams)localObject2).topMargin = ankt.dip2px(10.0F);
        ((RelativeLayout.LayoutParams)localObject2).bottomMargin = 0;
        localObject2 = new File(xks.aVl + paramMessageForPoke.subId + "/pressed.png");
        localObject3 = URLDrawable.URLDrawableOptions.obtain();
        localObject1 = this.mContext.getResources().getDrawable(2130848277);
        ((URLDrawable.URLDrawableOptions)localObject3).mLoadingDrawable = new ColorDrawable();
        ((URLDrawable.URLDrawableOptions)localObject3).mFailedDrawable = ((Drawable)localObject1);
        localObject2 = URLDrawable.getDrawable((File)localObject2, (URLDrawable.URLDrawableOptions)localObject3);
        if ((((URLDrawable)localObject2).getStatus() == 2) || (((URLDrawable)localObject2).getStatus() == 3)) {
          ((URLDrawable)localObject2).restartDownload();
        }
        localObject3 = new File(xks.aVl + paramMessageForPoke.subId + "/normal.png");
        localObject4 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject4).mLoadingDrawable = ((Drawable)localObject1);
        ((URLDrawable.URLDrawableOptions)localObject4).mFailedDrawable = ((Drawable)localObject1);
        localObject1 = URLDrawable.getDrawable((File)localObject3, (URLDrawable.URLDrawableOptions)localObject4);
        localObject3 = new StateListDrawable();
        ((StateListDrawable)localObject3).addState(new int[] { 16842919, 16842910 }, (Drawable)localObject2);
        ((StateListDrawable)localObject3).addState(new int[] { 16842908 }, (Drawable)localObject1);
        ((StateListDrawable)localObject3).addState(new int[0], (Drawable)localObject1);
        ((URLDrawable)localObject1).setURLDrawableListener(new xce(this, (StateListDrawable)localObject3));
        if ((((URLDrawable)localObject1).getStatus() == 2) || (((URLDrawable)localObject1).getStatus() == 3)) {
          ((URLDrawable)localObject1).restartDownload();
        }
        parama.sZ.setImageDrawable((Drawable)localObject3);
        if (xks.G("bubble", paramMessageForPoke.subId)) {
          break label1098;
        }
        i = 1;
        label774:
        if (xks.G("/normal.png", paramMessageForPoke.subId)) {
          break label1103;
        }
        j = 1;
        label790:
        if ((i == 0) || (j == 0)) {
          break label1265;
        }
        if (!xks.q.contains(Integer.valueOf(paramMessageForPoke.subId))) {
          break label1120;
        }
        if ((!xks.s.contains(Integer.valueOf(paramMessageForPoke.subId))) && (!xks.t.contains(Integer.valueOf(paramMessageForPoke.subId)))) {
          break label1109;
        }
        parama.progressBar.setVisibility(0);
      }
      break;
    }
    for (;;)
    {
      parama.h.setImageDrawable((Drawable)localObject1);
      parama.hD.setLayoutParams(localLayoutParams2);
      parama.h.setLayoutParams(localLayoutParams1);
      parama.h.removeAllAnimatorListener();
      parama.h.addAnimatorListener(new xcf(this, parama, paramMessageForPoke));
      return;
      this.mStrength = 1.0F;
      break;
      this.mStrength = 1.3F;
      break;
      this.mStrength = 1.6F;
      break;
      this.mStrength = 2.0F;
      break;
      localObject1 = aqhu.g(this.mContext.getResources(), 2130838320);
      localObject4 = aqhu.g(this.mContext.getResources(), 2130838321);
      localObject1 = auqy.a(this.mContext.getResources(), (Bitmap)localObject1, (Bitmap)localObject4);
      break label415;
      label992:
      parama.sZ.setScaleX(-1.0F);
      parama.h.setScaleX(-1.0F);
      ((RelativeLayout.LayoutParams)localObject2).rightMargin = ankt.dip2px(20.0F);
      ((RelativeLayout.LayoutParams)localObject2).leftMargin = 0;
      ((RelativeLayout.LayoutParams)localObject2).topMargin = ankt.dip2px(10.0F);
      ((RelativeLayout.LayoutParams)localObject2).bottomMargin = 0;
      ((RelativeLayout.LayoutParams)localObject3).leftMargin = (((RelativeLayout.LayoutParams)localObject2).width + ankt.dip2px(10.0F) - ankt.dip2px(6.0F));
      ((RelativeLayout.LayoutParams)localObject3).topMargin = ((int)(ankt.dip2px(80.0F) * parama.strength - ankt.dip2px(34.0F)));
      break label480;
      label1098:
      i = 0;
      break label774;
      label1103:
      j = 0;
      break label790;
      label1109:
      parama.ta.setVisibility(0);
      continue;
      label1120:
      xks.q.add(Integer.valueOf(paramMessageForPoke.subId));
      xks.s.add(Integer.valueOf(paramMessageForPoke.subId));
      xks.t.add(Integer.valueOf(paramMessageForPoke.subId));
      parama.progressBar.setVisibility(0);
      localObject2 = (VasQuickUpdateManager)this.app.getManager(184);
      ((VasQuickUpdateManager)localObject2).downloadItem(21L, "poke.item.effect." + paramMessageForPoke.subId, "getbubbleview");
      ((VasQuickUpdateManager)localObject2).downloadItem(21L, "poke.item.res." + paramMessageForPoke.subId, "getbubbleview");
      ((VasQuickUpdateManager)localObject2).addCallBacker(this.c);
      continue;
      label1265:
      if ((i != 0) || (j != 0)) {
        if ((xks.s.contains(Integer.valueOf(paramMessageForPoke.subId))) || (xks.t.contains(Integer.valueOf(paramMessageForPoke.subId)))) {
          parama.progressBar.setVisibility(0);
        } else {
          parama.ta.setVisibility(0);
        }
      }
    }
    label1328:
    localLayoutParams1.height = ankt.dip2px(90.0F * parama.strength);
    localLayoutParams1.width = a(parama);
    localLayoutParams1.topMargin = ankt.dip2px(0.0F);
    localLayoutParams1.bottomMargin = ankt.dip2px(0.0F);
    ((RelativeLayout.LayoutParams)localObject4).height = ankt.dip2px(90.0F * parama.strength);
    localLayoutParams2.width = ankt.dip2px(90.0F * parama.strength);
    localLayoutParams2.height = ankt.dip2px(90.0F * parama.strength);
    localLayoutParams3.width = ankt.dip2px(90.0F * parama.strength);
    localLayoutParams3.height = ankt.dip2px(90.0F * parama.strength);
    ((RelativeLayout.LayoutParams)localObject2).width = ankt.dip2px(80.0F * parama.strength);
    ((RelativeLayout.LayoutParams)localObject2).height = ankt.dip2px(70.0F * parama.strength);
    ((RelativeLayout.LayoutParams)localObject2).topMargin = ankt.dip2px(10.0F * parama.strength);
    ((RelativeLayout.LayoutParams)localObject2).bottomMargin = ankt.dip2px(10.0F * parama.strength);
    ((RelativeLayout.LayoutParams)localObject1).height = ankt.dip2px(90.0F * parama.strength);
    ((RelativeLayout.LayoutParams)localObject2).leftMargin = 0;
    ((RelativeLayout.LayoutParams)localObject2).rightMargin = 0;
    parama.sZ.setScaleType(ImageView.ScaleType.CENTER_CROP);
    parama.h.setScaleType(ImageView.ScaleType.CENTER_CROP);
    parama.sZ.setScaleX(1.0F);
    parama.h.setScaleX(1.0F);
    localObject1 = aqhu.g(this.mContext.getResources(), 2130838320);
    localObject4 = aqhu.g(this.mContext.getResources(), 2130838321);
    localObject1 = auqy.a(this.mContext.getResources(), (Bitmap)localObject1, (Bitmap)localObject4);
    parama.tb.setImageDrawable((Drawable)localObject1);
    if (paramMessageForPoke.isSendFromLocal())
    {
      localLayoutParams2.rightMargin = this.mContext.getResources().getDimensionPixelSize(2131296405);
      localLayoutParams2.leftMargin = 0;
    }
    for (;;)
    {
      localObject1 = xks.a(paramMessageForPoke.interactType, paramMessageForPoke.isSend(), this.mContext.getResources());
      parama.sZ.setImageDrawable((Drawable)localObject1);
      parama.a.a(paramMessageForPoke, parama.strength);
      break;
      if ((parama.pos == bSZ) && (!paramMessageForPoke.isSend()) && (!(this.mContext instanceof ChatHistoryActivity)) && (!I(paramMessageForPoke)))
      {
        parama.tb.setVisibility(0);
        if (!paramMessageForPoke.hasQuickBackShowed)
        {
          paramMessageForPoke.hasQuickBackShowed = true;
          anot.a(this.app, "CliOper", "", this.sessionInfo.aTl, "0X8008912", "0X8008912", 0, 0, "", "", "", "");
        }
      }
      for (;;)
      {
        localLayoutParams2.leftMargin = ankt.dip2px(10.0F * parama.strength);
        localLayoutParams2.rightMargin = 0;
        ((RelativeLayout.LayoutParams)localObject3).rightMargin = 0;
        switch (paramMessageForPoke.strength)
        {
        default: 
          break;
        case 0: 
          ((RelativeLayout.LayoutParams)localObject3).leftMargin = (((RelativeLayout.LayoutParams)localObject2).width + localLayoutParams2.leftMargin - ankt.dip2px(6.0F));
          ((RelativeLayout.LayoutParams)localObject3).topMargin = ((int)(ankt.dip2px(80.0F) * parama.strength - ankt.dip2px(34.0F)));
          break;
          parama.tb.setVisibility(8);
        }
      }
      ((RelativeLayout.LayoutParams)localObject3).leftMargin = (((RelativeLayout.LayoutParams)localObject2).width + localLayoutParams2.leftMargin - ankt.dip2px(6.0F) - ankt.dip2px(10.0F));
      ((RelativeLayout.LayoutParams)localObject3).topMargin = ((int)(ankt.dip2px(80.0F) * parama.strength - ankt.dip2px(35.0F)));
      continue;
      ((RelativeLayout.LayoutParams)localObject3).leftMargin = (((RelativeLayout.LayoutParams)localObject2).width + localLayoutParams2.leftMargin - ankt.dip2px(6.0F) - ankt.dip2px(20.0F));
      ((RelativeLayout.LayoutParams)localObject3).topMargin = ((int)(ankt.dip2px(80.0F) * parama.strength - ankt.dip2px(36.0F)));
      continue;
      ((RelativeLayout.LayoutParams)localObject3).leftMargin = (((RelativeLayout.LayoutParams)localObject2).width + localLayoutParams2.leftMargin - ankt.dip2px(6.0F) - ankt.dip2px(40.0F));
      ((RelativeLayout.LayoutParams)localObject3).topMargin = ((int)(ankt.dip2px(80.0F) * parama.strength - ankt.dip2px(38.0F)));
    }
  }
  
  private void b(xbu.a parama, MessageForPoke paramMessageForPoke)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    UnlimitedBladeWorks localUnlimitedBladeWorks;
    if ((paramMessageForPoke.isPlayed) && (!paramMessageForPoke.mUnlimitedState.hi) && (!this.mApp.a().nc.containsKey(Long.valueOf(paramMessageForPoke.uniseq))))
    {
      parama.h.clearAnimation();
      parama.h.setVisibility(8);
      parama.h.setImageDrawable(null);
      parama.hD.setVisibility(0);
      if ((parama.pos == bSZ) && (!paramMessageForPoke.isSend()) && (!(this.mContext instanceof ChatHistoryActivity)) && (!I(paramMessageForPoke)))
      {
        parama.tb.setVisibility(0);
        parama.a.clearAnimation();
        if (parama.a.isInit())
        {
          localUnlimitedBladeWorks = parama.a;
          if (paramMessageForPoke.isSend()) {
            break label193;
          }
          label149:
          localUnlimitedBladeWorks.setParams(bool1);
        }
        parama.a.setVisibility(8);
        if (QLog.isColorLevel()) {
          QLog.d("fangdazhao", 2, "[showed]");
        }
      }
    }
    label193:
    label225:
    do
    {
      return;
      parama.tb.setVisibility(8);
      break;
      bool1 = false;
      break label149;
      if (PokeBigResHandler.bKF)
      {
        localUnlimitedBladeWorks = parama.a;
        Context localContext = this.mContext;
        if (!paramMessageForPoke.isSend())
        {
          bool1 = true;
          localUnlimitedBladeWorks.a(localContext, bool1, xks.z(this.mApp), parama.strength);
        }
      }
      else
      {
        if (!paramMessageForPoke.mUnlimitedState.hi) {
          break label408;
        }
        parama.a.setVisibility(0);
        parama.h.clearAnimation();
        parama.h.setVisibility(8);
        parama.h.setImageDrawable(null);
        parama.hD.setVisibility(8);
        parama.tb.setVisibility(8);
        parama.hD.clearAnimation();
        localUnlimitedBladeWorks = parama.a;
        if (paramMessageForPoke.isSend()) {
          break label398;
        }
        bool1 = true;
        localUnlimitedBladeWorks.setMirror(bool1);
        parama.a.setEndListener(new xbx(this, parama, paramMessageForPoke));
        localUnlimitedBladeWorks = parama.a;
        if (paramMessageForPoke.isSend()) {
          break label403;
        }
      }
      for (bool1 = bool2;; bool1 = false)
      {
        localUnlimitedBladeWorks.a(paramMessageForPoke, bool1, parama.strength);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("fangdazhao", 2, "[resume]");
        return;
        bool1 = false;
        break label225;
        bool1 = false;
        break label326;
      }
      if (paramMessageForPoke.mUnlimitedState.aPN)
      {
        parama.h.clearAnimation();
        parama.h.setVisibility(8);
        parama.h.setImageDrawable(null);
        parama.hD.setVisibility(0);
        if ((parama.pos == bSZ) && (!paramMessageForPoke.isSend()) && (!(this.mContext instanceof ChatHistoryActivity)) && (!I(paramMessageForPoke))) {
          parama.tb.setVisibility(0);
        }
        for (;;)
        {
          parama.a.clearAnimation();
          parama.a.setVisibility(8);
          if (!paramMessageForPoke.isPlayed) {
            paramMessageForPoke.setPlayed(this.mApp);
          }
          if (this.mApp.a().nc.containsKey(Long.valueOf(paramMessageForPoke.uniseq))) {
            this.mApp.a().nc.remove(Long.valueOf(paramMessageForPoke.uniseq));
          }
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("fangdazhao", 2, "[show end]");
          return;
          parama.tb.setVisibility(8);
        }
      }
    } while (wja.bcL);
    label326:
    wja.bNG += 1;
    label398:
    label403:
    label408:
    parama.a.setVisibility(0);
    parama.h.clearAnimation();
    parama.h.setVisibility(8);
    parama.h.setImageDrawable(null);
    parama.hD.setVisibility(8);
    parama.tb.setVisibility(8);
    parama.hD.clearAnimation();
    parama.a.setEndListener(new xby(this, parama, paramMessageForPoke));
    if (QLog.isColorLevel()) {
      QLog.i("fangdazhao", 2, "[start]");
    }
    parama.a.start();
    a(paramMessageForPoke.uniseq, paramMessageForPoke);
  }
  
  private String c(ChatMessage paramChatMessage)
  {
    if (TextUtils.isEmpty(paramChatMessage.msg)) {}
    for (paramChatMessage = acfp.m(2131706966);; paramChatMessage = paramChatMessage.msg.substring(1, paramChatMessage.msg.length() - 1)) {
      try
      {
        Integer.parseInt(paramChatMessage);
        return paramChatMessage;
      }
      catch (NumberFormatException localNumberFormatException) {}
    }
    return paramChatMessage;
  }
  
  @TargetApi(17)
  private void c(Activity paramActivity, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PokeItemBuilder", 2, "startPokeWindowAnim " + paramBoolean1);
    }
    this.eq = new GivingHeartItemBuilder.10(this, paramActivity, paramBoolean2, paramBoolean1);
    sHandler.post(this.eq);
  }
  
  public static String cF(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      return "chat_item_for_qqpokenew";
    case 2: 
      return "chat_item_for_qqbixin_light";
    case 3: 
      return "chat_item_for_qqlikenew";
    case 4: 
      return "chat_item_for_qqheartbroken";
    }
    return "chat_item_for_qq666";
  }
  
  private void cdK()
  {
    if ((this.hK == null) || (this.jdField_d_of_type_ComTencentMobileqqVasVasQuickUpdateManager$CallBacker == null)) {
      return;
    }
    ThreadManager.getFileThreadHandler().post(new GivingHeartItemBuilder.5(this));
  }
  
  private void cdL()
  {
    List localList;
    int i;
    if ((this.adapter != null) && ((this.adapter instanceof wki)))
    {
      localList = ((wki)this.adapter).getList();
      if (localList != null) {
        i = localList.size() - 1;
      }
    }
    for (;;)
    {
      if (i >= 0)
      {
        ChatMessage localChatMessage = (ChatMessage)localList.get(i);
        if (((localChatMessage instanceof MessageForPoke)) && (!localChatMessage.isSend())) {
          bSZ = i;
        }
      }
      else
      {
        return;
      }
      i -= 1;
    }
  }
  
  private String d(ChatMessage paramChatMessage)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (TextUtils.isEmpty(paramChatMessage.msg)) {}
    for (paramChatMessage = acfp.m(2131706965);; paramChatMessage = paramChatMessage.msg.substring(1, paramChatMessage.msg.length() - 1)) {
      try
      {
        Integer.parseInt(paramChatMessage);
        localStringBuilder.append("回复" + paramChatMessage + "动作");
        return localStringBuilder.toString();
      }
      catch (NumberFormatException localNumberFormatException)
      {
        localStringBuilder.append("回复" + paramChatMessage + "动作");
      }
    }
    return localStringBuilder.toString();
  }
  
  private void dn(Context paramContext)
  {
    if (bSY == 0) {
      bSY = (paramContext.getResources().getDisplayMetrics().heightPixels - ankt.dip2px(50.0F) * 2) / ankt.dip2px(90.0F);
    }
    if (bSY <= 0) {
      bSY = 10;
    }
  }
  
  private void jdMethod_do(Context paramContext)
  {
    this.g = new DiniFlyAnimationView(paramContext);
    this.g.addAnimatorListener(new xca(this));
    paramContext = new RelativeLayout.LayoutParams(1, 1);
    ViewGroup localViewGroup = (ViewGroup)((ViewGroup)((Activity)this.mContext).getWindow().getDecorView()).getChildAt(0).findViewById(2131362332);
    if (localViewGroup != null) {
      localViewGroup.addView(this.g, paramContext);
    }
    this.a = new ViewAnimation(this.g);
    this.hK = new HashMap();
    this.jdField_d_of_type_ComTencentMobileqqVasVasQuickUpdateManager$CallBacker = new xcb(this);
    cdK();
    if (!(this.mContext instanceof ChatHistoryActivity)) {
      this.mApp.addObserver(this.jdField_d_of_type_Aqrd);
    }
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  public View a(ChatMessage paramChatMessage, BaseBubbleBuilder.e parame, View paramView, BaseChatItemLayout paramBaseChatItemLayout, wlz paramwlz)
  {
    Object localObject1 = paramBaseChatItemLayout.getContext();
    paramBaseChatItemLayout = (MessageForPoke)paramChatMessage;
    xbu.a locala = (xbu.a)parame;
    if (QLog.isColorLevel()) {
      QLog.d("PokeMsg", 2, "type: " + paramBaseChatItemLayout.interactType + " strength: " + paramBaseChatItemLayout.strength);
    }
    parame = paramView;
    if (paramView == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("GivingHeart", 2, "[getBubbleView]:content is null");
      }
      parame = new RelativeLayout((Context)localObject1);
      parame.setId(2131377546);
      paramView = new RelativeLayout((Context)localObject1);
      Object localObject4 = new DiniFlyAnimationView((Context)localObject1);
      locala.h = ((DiniFlyAnimationView)localObject4);
      paramView.addView((View)localObject4);
      parame.addView(paramView, new RelativeLayout.LayoutParams(-2, -2));
      Object localObject3 = new ImageView((Context)localObject1);
      ((ImageView)localObject3).setId(2131375391);
      paramView = aqhu.g(((Context)localObject1).getResources(), 2130838320);
      Object localObject2 = aqhu.g(((Context)localObject1).getResources(), 2130838321);
      ((ImageView)localObject3).setImageDrawable(auqy.a(((Context)localObject1).getResources(), paramView, (Bitmap)localObject2));
      locala.tb = ((ImageView)localObject3);
      parame.addView((View)localObject3);
      UnlimitedBladeWorks localUnlimitedBladeWorks = new UnlimitedBladeWorks((Context)localObject1);
      locala.a = localUnlimitedBladeWorks;
      parame.addView(localUnlimitedBladeWorks);
      RelativeLayout localRelativeLayout = new RelativeLayout((Context)localObject1);
      localRelativeLayout.setId(2131373481);
      ImageView localImageView = new ImageView((Context)localObject1);
      locala.sZ = localImageView;
      localRelativeLayout.addView(localImageView);
      localObject2 = new ProgressBar((Context)localObject1, null, 0);
      ((ProgressBar)localObject2).setIndeterminate(true);
      ((ProgressBar)localObject2).setIndeterminateDrawable(((Context)localObject1).getResources().getDrawable(2130839657));
      locala.progressBar = ((ProgressBar)localObject2);
      localRelativeLayout.addView((View)localObject2);
      paramView = new ImageView((Context)localObject1);
      paramView.setId(2131379203);
      paramView.setImageResource(2130848278);
      locala.ta = paramView;
      localRelativeLayout.addView(paramView);
      locala.hD = localRelativeLayout;
      parame.addView(localRelativeLayout);
      View localView = new View((Context)localObject1);
      parame.addView(localView);
      locala.wE = localView;
      localObject4 = (RelativeLayout.LayoutParams)((DiniFlyAnimationView)localObject4).getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject4).height = ankt.dip2px(90.0F);
      ((RelativeLayout.LayoutParams)localObject4).addRule(12, -1);
      localObject4 = (RelativeLayout.LayoutParams)((ImageView)localObject3).getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject4).height = ankt.dip2px(40.0F);
      ((RelativeLayout.LayoutParams)localObject4).width = ankt.dip2px(40.0F);
      ((ImageView)localObject3).setPadding(ankt.dip2px(6.0F), ankt.dip2px(6.0F), ankt.dip2px(6.0F), ankt.dip2px(6.0F));
      localObject3 = (RelativeLayout.LayoutParams)localUnlimitedBladeWorks.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject3).width = -1;
      ((RelativeLayout.LayoutParams)localObject3).height = ankt.dip2px(90.0F);
      ((RelativeLayout.LayoutParams)localObject3).addRule(12, -1);
      localObject3 = (RelativeLayout.LayoutParams)localRelativeLayout.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject3).width = ankt.dip2px(90.0F);
      ((RelativeLayout.LayoutParams)localObject3).height = ankt.dip2px(90.0F);
      ((RelativeLayout.LayoutParams)localObject3).addRule(12, -1);
      localObject3 = (RelativeLayout.LayoutParams)localImageView.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject3).topMargin = ((Context)localObject1).getResources().getDimensionPixelSize(2131296405);
      ((RelativeLayout.LayoutParams)localObject3).bottomMargin = ((Context)localObject1).getResources().getDimensionPixelSize(2131296405);
      ((RelativeLayout.LayoutParams)localObject3).height = ankt.dip2px(70.0F);
      ((RelativeLayout.LayoutParams)localObject3).width = ankt.dip2px(80.0F);
      localObject1 = (RelativeLayout.LayoutParams)((ProgressBar)localObject2).getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject1).width = ((int)(23.0F * this.mDensity));
      ((RelativeLayout.LayoutParams)localObject1).height = ((int)(23.0F * this.mDensity));
      ((RelativeLayout.LayoutParams)localObject1).addRule(13);
      ((RelativeLayout.LayoutParams)localObject1).leftMargin = ankt.dip2px(10.0F);
      paramView = (RelativeLayout.LayoutParams)paramView.getLayoutParams();
      paramView.width = ((int)(23.0F * this.mDensity));
      paramView.height = ((int)(23.0F * this.mDensity));
      paramView.addRule(12, -1);
      paramView.addRule(11, -1);
      paramView.bottomMargin = ankt.dip2px(10.0F);
    }
    if (QLog.isColorLevel()) {
      QLog.d("GivingHeart", 2, "[getBubbleView]set Holder's contentView");
    }
    parame.setTag(locala);
    a(locala, paramBaseChatItemLayout);
    locala.tb.setOnClickListener(this.dQ);
    parame.setOnTouchListener(paramwlz);
    parame.setOnLongClickListener(paramwlz);
    parame.setOnClickListener(this.onClickListener);
    locala.tb.setContentDescription(d(paramChatMessage));
    if (aTl)
    {
      if ((locala.E != null) && (locala.E.length() > 0)) {
        locala.E.setLength(0);
      }
      parame.setContentDescription(c(paramChatMessage));
    }
    return parame;
  }
  
  public BaseBubbleBuilder.e a()
  {
    return new xbu.a();
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    switch (paramInt)
    {
    default: 
      super.a(paramInt, paramContext, paramChatMessage);
      return;
    case 2131365686: 
      ujt.b(this.mContext, this.app, paramChatMessage);
      return;
    }
    super.m(paramChatMessage);
  }
  
  public void a(View paramView, ChatMessage paramChatMessage)
  {
    if (paramChatMessage.isSend())
    {
      paramView.setPadding(0, 0, 0, 0);
      return;
    }
    paramView.setPadding(0, 0, 0, 0);
  }
  
  public void a(ChatMessage paramChatMessage, Context paramContext, BaseChatItemLayout paramBaseChatItemLayout, BaseBubbleBuilder.e parame, int paramInt1, int paramInt2)
  {
    super.a(paramChatMessage, paramContext, paramBaseChatItemLayout, parame, paramInt1, paramInt2);
    xbu.a locala = (xbu.a)parame;
    MessageForPoke localMessageForPoke = (MessageForPoke)paramChatMessage;
    if (QLog.isColorLevel()) {
      QLog.d("GivingHeart", 2, "====> item num:" + paramInt1 + "  send:" + paramChatMessage.isSend());
    }
    if (wja.bNH > 0)
    {
      localMessageForPoke.setPlayed(this.app);
      localMessageForPoke.mFrameState.aPN = true;
      if (this.mApp.a().nc.containsKey(Long.valueOf(localMessageForPoke.uniseq))) {
        this.mApp.a().nc.remove(Long.valueOf(localMessageForPoke.uniseq));
      }
    }
    if (126 == localMessageForPoke.interactType)
    {
      locala.h.setImageDrawable(null);
      locala.h.setVisibility(8);
      locala.hD.setVisibility(0);
      locala.a.clearAnimation();
      locala.a.setVisibility(8);
      if ((!localMessageForPoke.isSend()) && (locala.pos == bSZ) && (localMessageForPoke.isPlayed) && (!(this.mContext instanceof ChatHistoryActivity)) && (!I(localMessageForPoke))) {
        locala.tb.setVisibility(0);
      }
      if ((!localMessageForPoke.isPlayed) && (!locala.h.isAnimating()))
      {
        if (abrj.a(this.app).cqT != 1) {
          break label345;
        }
        paramInt1 = 0;
        if (paramInt1 != 0)
        {
          abrb.b(this.mApp, "vas_poke", true);
          if (QLog.isColorLevel()) {
            QLog.i("GivingHeart.sprite", 2, "hide sprite (normal) in play.");
          }
        }
        xks.a(this.mApp, paramContext, locala.h, locala, localMessageForPoke.subId, "bubble");
      }
    }
    label345:
    label378:
    label1019:
    do
    {
      Object localObject;
      do
      {
        return;
        paramInt1 = 1;
        break;
        if (localMessageForPoke.isSend())
        {
          hI.put(Long.valueOf(localMessageForPoke.uniseq), localMessageForPoke);
          localObject = (RelativeLayout.LayoutParams)parame.E.getLayoutParams();
          ((RelativeLayout.LayoutParams)localObject).topMargin = 0;
          ((RelativeLayout.LayoutParams)localObject).leftMargin = 0;
          ((RelativeLayout.LayoutParams)localObject).rightMargin = 0;
          if (localMessageForPoke.interactType != 6) {
            break label584;
          }
          if (!localMessageForPoke.isSend()) {
            break label569;
          }
          paramBaseChatItemLayout.setPadding(0, BaseChatItemLayout.paddingTop, BaseChatItemLayout.paddingRight, 0);
        }
        for (;;)
        {
          parame.E.setLayoutParams((ViewGroup.LayoutParams)localObject);
          if ((PokeBigResHandler.bKF) && (!(paramContext instanceof ChatHistoryActivity))) {
            break label601;
          }
          locala.h.clearAnimation();
          locala.h.setVisibility(8);
          locala.hD.setVisibility(0);
          locala.a.clearAnimation();
          locala.a.setVisibility(8);
          paramChatMessage = (PokeBigResHandler)this.app.getBusinessHandler(117);
          if (paramChatMessage != null) {
            paramChatMessage.FO(true);
          }
          if (!localMessageForPoke.isSend()) {
            break;
          }
          localMessageForPoke.setPlayed(this.mApp);
          return;
          hJ.put(Long.valueOf(localMessageForPoke.uniseq), localMessageForPoke);
          break label378;
          paramBaseChatItemLayout.setPadding(BaseChatItemLayout.paddingLeft, BaseChatItemLayout.paddingTop, 0, 0);
          continue;
          paramBaseChatItemLayout.setPadding(BaseChatItemLayout.paddingLeft, BaseChatItemLayout.paddingTop, BaseChatItemLayout.paddingRight, 0);
        }
        if (QLog.isColorLevel()) {
          QLog.d("PokeMsg", 2, "Strength holder = " + locala.strength);
        }
        if ((localMessageForPoke.interactType != 5) || (locala.strength != 2.0F)) {
          break label1019;
        }
        locala.h.setVisibility(8);
        locala.h.setImageDrawable(null);
        locala.a.setVisibility(8);
        if (localMessageForPoke.isPlayed) {
          break label884;
        }
        paramChatMessage = ((FitSystemWindowsRelativeLayout)((ViewGroup)((Activity)this.mContext).getWindow().getDecorView()).getChildAt(0).findViewById(2131362332)).a();
        if (SixCombolEffectView.bVC != 0) {
          break label795;
        }
      } while (wja.bcL);
      locala.hD.setVisibility(8);
      locala.tb.setVisibility(8);
      locala.wE.setVisibility(0);
      paramChatMessage.setListener(this);
      wja.bNG += 1;
      paramChatMessage.a(locala, xks.z(this.app));
      return;
      paramChatMessage = paramChatMessage.a();
      if (locala.mMessage == paramChatMessage)
      {
        switch (SixCombolEffectView.bVC)
        {
        default: 
          a(locala);
          return;
        }
        locala.hD.setVisibility(8);
        locala.tb.setVisibility(8);
        locala.wE.setVisibility(0);
        return;
      }
      a(locala);
      return;
      if (SixCombolEffectView.bVC > 0)
      {
        paramChatMessage = ((FitSystemWindowsRelativeLayout)((ViewGroup)((Activity)this.mContext).getWindow().getDecorView()).getChildAt(0).findViewById(2131362332)).a().a();
        if ((paramChatMessage != null) && (locala.mMessage == paramChatMessage))
        {
          switch (SixCombolEffectView.bVC)
          {
          default: 
            a(locala);
            return;
          }
          locala.hD.setVisibility(8);
          locala.tb.setVisibility(8);
          locala.wE.setVisibility(0);
          return;
        }
        a(locala);
        return;
      }
      a(locala);
      return;
      if (localMessageForPoke.interactType == 6)
      {
        b(locala, localMessageForPoke);
        return;
      }
      locala.a.setVisibility(8);
      if ((localMessageForPoke.isPlayed) && (!localMessageForPoke.mFrameState.hi) && (!this.mApp.a().nc.containsKey(Long.valueOf(localMessageForPoke.uniseq))))
      {
        if (QLog.isColorLevel()) {
          QLog.d("GivingHeart", 2, "[status]has already played");
        }
        locala.h.clearAnimation();
        locala.h.setVisibility(8);
        locala.h.setImageDrawable(null);
        locala.hD.setVisibility(0);
        if ((locala.pos == bSZ) && (!localMessageForPoke.isSend()) && (localMessageForPoke.interactType != 126) && (!(this.mContext instanceof ChatHistoryActivity)) && (!I(localMessageForPoke))) {
          locala.tb.setVisibility(0);
        }
        for (;;)
        {
          locala.a.clearAnimation();
          locala.a.setVisibility(8);
          return;
          locala.tb.setVisibility(8);
        }
      }
      paramInt1 = 0;
      parame = cF(localMessageForPoke.interactType);
      switch (localMessageForPoke.interactType)
      {
      default: 
        paramContext = xkr.aVf + "/chuo_icon/chuo_icon_";
        if ((localMessageForPoke.interactType == 1) || (localMessageForPoke.interactType <= 0) || (localMessageForPoke.interactType > 6)) {
          if (locala.strength == 2.0F)
          {
            paramContext = new BitmapFactory.Options();
            paramContext.inSampleSize = 1;
            paramContext.inMutable = true;
          }
        }
        break;
      }
      for (;;)
      {
        try
        {
          paramContext = aqhu.d(PokeBigResHandler.brt + "/chuo_caidan/chuo_caidan_" + "01.png", paramContext);
          paramContext = new CustomFrameAnimationDrawable(this.mContext.getResources(), paramContext, xkr.a().b(), localMessageForPoke.mFrameState, parame, xks.z(this.mApp));
          a(paramContext);
          paramContext.Db(1);
          if (!paramChatMessage.isSend())
          {
            if (localMessageForPoke.interactType == 5) {
              break label2376;
            }
            paramContext.cdH();
          }
          paramContext.cdJ();
          if (!localMessageForPoke.mFrameState.hi) {
            break label2384;
          }
          locala.h.setVisibility(0);
          locala.hD.setVisibility(8);
          locala.tb.setVisibility(8);
          locala.hD.clearAnimation();
          locala.a.clearAnimation();
          locala.a.setVisibility(8);
          locala.h.setImageDrawable(paramContext);
          paramContext.a(new xcc(this, locala, localMessageForPoke));
          paramContext.resume();
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("GivingHeart", 2, "[status]playing");
          return;
          paramContext = PokeBigResHandler.bru + "/chuo_motion/chuo_motion_";
          paramInt1 = 35;
          break label1311;
          paramContext = PokeBigResHandler.bru + "/bixin_motion/bixin_motion_";
          paramInt1 = 67;
          break label1311;
          paramContext = PokeBigResHandler.bru + "/zan_motion/zan_motion_";
          paramInt1 = 20;
          break label1311;
          paramContext = PokeBigResHandler.bru + "/xinsui_motion/xinsui_motion_";
          paramInt1 = 50;
          break label1311;
          if (localMessageForPoke.isSend())
          {
            paramContext = PokeBigResHandler.bru + "/666send_motion/666send_motion_";
            paramInt1 = 57;
            break label1311;
          }
          paramContext = PokeBigResHandler.bru + "/666receive_motion/666receive_motion_";
          continue;
          paramContext = xkr.aVf + "/dazhao_icon/dazhao_icon_";
        }
        catch (OutOfMemoryError paramContext)
        {
          if (QLog.isColorLevel()) {
            QLog.d("GivingHeart", 2, paramContext.toString());
          }
          paramContext = null;
          continue;
        }
        paramContext = aqhu.g(this.mContext.getResources(), 2130838528);
        paramContext = new CustomFrameAnimationDrawable(this.mContext.getResources(), paramContext, xkr.a().b(), localMessageForPoke.mFrameState, parame, xks.z(this.mApp));
        a(paramContext);
        continue;
        localObject = new BitmapFactory.Options();
        ((BitmapFactory.Options)localObject).inSampleSize = 1;
        ((BitmapFactory.Options)localObject).inMutable = true;
        try
        {
          paramBaseChatItemLayout = aqhu.d(paramContext + "01.png", (BitmapFactory.Options)localObject);
          paramBaseChatItemLayout = new CustomFrameAnimationDrawable(this.mContext.getResources(), paramBaseChatItemLayout, xkr.a().b(), localMessageForPoke.mFrameState, parame, xks.z(this.mApp));
          paramBaseChatItemLayout.clearFrame();
          paramInt2 = 40;
          if (localMessageForPoke.interactType == 2) {
            paramInt2 = 30;
          }
          if ((localMessageForPoke.interactType == 4) && (locala.strength == 2.0F))
          {
            i = 0;
            for (;;)
            {
              if (i >= 20) {
                break label2124;
              }
              if (i + 1 >= 10) {
                break;
              }
              paramBaseChatItemLayout.u(i, paramInt2, paramContext + "0" + (i + 1) + ".png");
              i += 1;
            }
          }
        }
        catch (OutOfMemoryError paramBaseChatItemLayout)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.d("GivingHeart", 2, paramBaseChatItemLayout.toString());
            }
            paramBaseChatItemLayout = null;
            continue;
            paramBaseChatItemLayout.u(i, paramInt2, paramContext + (i + 1) + ".png");
          }
          int i = 20;
          while (i < paramInt1)
          {
            paramBaseChatItemLayout.u(i, paramInt2, paramContext + 21 + ".png");
            i += 1;
            continue;
            i = 0;
            if (i < paramInt1)
            {
              if (i + 1 < 10) {
                paramBaseChatItemLayout.u(i, paramInt2, paramContext + "0" + (i + 1) + ".png");
              }
              for (;;)
              {
                i += 1;
                break;
                paramBaseChatItemLayout.u(i, paramInt2, paramContext + (i + 1) + ".png");
              }
            }
          }
          paramContext = paramBaseChatItemLayout;
        }
        if (localMessageForPoke.mFrameState.hi)
        {
          try
          {
            paramContext = aqhu.d(paramBaseChatItemLayout.a(localMessageForPoke.mFrameState.mCurFrameIndex).mFileName, (BitmapFactory.Options)localObject);
            paramBaseChatItemLayout.G(paramContext);
            paramContext = paramBaseChatItemLayout;
          }
          catch (OutOfMemoryError paramContext)
          {
            for (;;)
            {
              if (QLog.isColorLevel()) {
                QLog.d("GivingHeart", 2, paramContext, new Object[0]);
              }
              paramContext = null;
            }
          }
          catch (NullPointerException paramContext)
          {
            for (;;)
            {
              if (QLog.isColorLevel()) {
                QLog.d("GivingHeart", 2, paramContext, new Object[0]);
              }
              paramContext = null;
            }
          }
          paramContext.Db(2);
        }
      }
      if (localMessageForPoke.mFrameState.aPN)
      {
        locala.h.clearAnimation();
        locala.h.setVisibility(8);
        locala.h.setImageDrawable(null);
        locala.hD.setVisibility(0);
        if ((locala.pos == bSZ) && (!localMessageForPoke.isSend()) && (!(this.mContext instanceof ChatHistoryActivity)) && (!I(localMessageForPoke))) {
          locala.tb.setVisibility(0);
        }
        for (;;)
        {
          locala.a.clearAnimation();
          locala.a.setVisibility(8);
          if (QLog.isColorLevel()) {
            QLog.d("GivingHeart", 2, "[status]played");
          }
          if (!localMessageForPoke.isPlayed) {
            localMessageForPoke.setPlayed(this.mApp);
          }
          if (!this.mApp.a().nc.containsKey(Long.valueOf(localMessageForPoke.uniseq))) {
            break;
          }
          this.mApp.a().nc.remove(Long.valueOf(localMessageForPoke.uniseq));
          return;
          locala.tb.setVisibility(8);
        }
      }
    } while (wja.bcL);
    label569:
    label584:
    label601:
    label884:
    wja.bNG += 1;
    label795:
    label1311:
    label2124:
    label2384:
    locala.h.setVisibility(0);
    label2376:
    locala.hD.setVisibility(8);
    locala.tb.setVisibility(8);
    locala.a.clearAnimation();
    locala.a.setVisibility(8);
    paramContext.a(new xcd(this, locala, localMessageForPoke));
    locala.h.setImageDrawable(paramContext);
    paramContext.start();
    a(localMessageForPoke.uniseq, localMessageForPoke);
    label2730:
    boolean bool2;
    if (locala.strength == 2.0F)
    {
      if (localMessageForPoke.interactType == 2)
      {
        xkr.a().send(1);
        xkr.a().i(2, 1500L, localMessageForPoke.isSend());
      }
    }
    else if ((localMessageForPoke.interactType == 1) || (localMessageForPoke.interactType == 0))
    {
      paramContext = (Activity)this.mContext;
      bool2 = paramChatMessage.isSend();
      if (locala.strength != 2.0F) {
        break label2895;
      }
    }
    label2895:
    for (boolean bool1 = true;; bool1 = false)
    {
      c(paramContext, bool2, bool1);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("GivingHeart", 2, "[status]start to play duobleHit:" + localMessageForPoke.doubleHitState + " type:" + localMessageForPoke.msgtype);
      return;
      if (localMessageForPoke.interactType == 3)
      {
        xkr.a().send(4);
        xkr.a().U(5, 700L);
        break label2730;
      }
      if (localMessageForPoke.interactType != 4) {
        break label2730;
      }
      xkr.a().send(13);
      xkr.a().U(14, 800L);
      break label2730;
    }
  }
  
  public void a(xbu.a parama)
  {
    if (parama != null)
    {
      parama.hD.setVisibility(0);
      parama.a.setVisibility(8);
      if ((parama.pos != bSZ) || (parama.mMessage.isSend()) || ((this.mContext instanceof ChatHistoryActivity)) || (I(parama.mMessage))) {
        break label106;
      }
      parama.tb.setVisibility(0);
    }
    for (;;)
    {
      parama.wE.setVisibility(8);
      if (!((MessageForPoke)parama.mMessage).isPlayed) {
        ((MessageForPoke)parama.mMessage).setPlayed(this.mApp);
      }
      return;
      label106:
      parama.tb.setVisibility(8);
    }
  }
  
  public aqob[] a(View paramView)
  {
    aqoa localaqoa = new aqoa();
    paramView = (wko.a)wja.a(paramView);
    if ((paramView != null) && (paramView.mMessage != null) && ((paramView.mMessage instanceof MessageForPoke)) && (paramView.mMessage.istroop == 0)) {
      a(paramView.mMessage, localaqoa);
    }
    ujt.a(localaqoa, this.mContext, this.sessionInfo.cZ);
    super.e(localaqoa, this.mContext);
    return localaqoa.a();
  }
  
  public String b(ChatMessage paramChatMessage)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramChatMessage.time > 0L) {
      localStringBuilder.append(aqmu.a(this.mContext, 3, paramChatMessage.time * 1000L)).append(" ");
    }
    Object localObject = paramChatMessage.msg.substring(1, paramChatMessage.msg.length() - 1);
    try
    {
      Integer.parseInt((String)localObject);
      String str = "";
      localObject = ((String)localObject).toCharArray();
      int j = localObject.length;
      int i = 0;
      while (i < j)
      {
        char c1 = localObject[i];
        str = str + c1 + " ";
        i += 1;
      }
      if (!paramChatMessage.isSend()) {
        break label289;
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      if (paramChatMessage.isSend()) {
        localStringBuilder.append("我向" + this.sessionInfo.aTn + "发出动作" + (String)localObject);
      }
      for (;;)
      {
        return localStringBuilder.toString();
        localStringBuilder.append(this.sessionInfo.aTn + "发来动作" + (String)localObject);
      }
    }
    localStringBuilder.append("我向" + this.sessionInfo.aTn + "发出动作" + localNumberFormatException);
    for (;;)
    {
      return localStringBuilder.toString();
      label289:
      localStringBuilder.append(this.sessionInfo.aTn + "发来动作" + localNumberFormatException);
    }
  }
  
  public void destroy()
  {
    super.destroy();
    Object localObject = hI.entrySet().iterator();
    MessageForPoke localMessageForPoke;
    while (((Iterator)localObject).hasNext())
    {
      localMessageForPoke = (MessageForPoke)((Map.Entry)((Iterator)localObject).next()).getValue();
      if (!localMessageForPoke.isPlayed) {
        localMessageForPoke.setPlayed(this.app);
      }
      localMessageForPoke.mFrameState.hi = false;
      localMessageForPoke.mFrameState.aPN = true;
      localMessageForPoke.mUnlimitedState.hi = false;
      localMessageForPoke.mUnlimitedState.aPN = true;
    }
    hI.clear();
    localObject = hJ.entrySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      localMessageForPoke = (MessageForPoke)((Map.Entry)((Iterator)localObject).next()).getValue();
      if (!localMessageForPoke.isPlayed) {
        localMessageForPoke.setPlayed(this.app);
      }
      localMessageForPoke.mFrameState.hi = false;
      localMessageForPoke.mFrameState.aPN = true;
      localMessageForPoke.mUnlimitedState.hi = false;
      localMessageForPoke.mUnlimitedState.aPN = true;
    }
    hJ.clear();
    if (this.p != null)
    {
      this.p.evictAll();
      this.p = null;
    }
    if (QLog.isColorLevel()) {
      QLog.i("placeholder", 2, "HIDE_PLACEHOLDER destroy");
    }
    xkr.a().send(20);
    xkr.a().send(21);
    localObject = (VasQuickUpdateManager)this.app.getManager(184);
    ((VasQuickUpdateManager)localObject).removeCallBacker(this.c);
    ((VasQuickUpdateManager)localObject).removeCallBacker(this.jdField_d_of_type_ComTencentMobileqqVasVasQuickUpdateManager$CallBacker);
    if (!(this.mContext instanceof ChatHistoryActivity)) {
      this.mApp.removeObserver(this.jdField_d_of_type_Aqrd);
    }
    wja.bNG = 0;
  }
  
  public class a
    extends BaseBubbleBuilder.e
  {
    UnlimitedBladeWorks a;
    DiniFlyAnimationView h;
    RelativeLayout hD;
    ProgressBar progressBar;
    ImageView sZ;
    float strength;
    ImageView ta;
    ImageView tb;
    public View wE;
    
    public a() {}
  }
  
  class b
    implements View.OnClickListener
  {
    private b() {}
    
    public void onClick(View paramView)
    {
      if ((paramView.getContext() instanceof ChatHistoryActivity)) {}
      xbu.a locala;
      MessageForPoke localMessageForPoke;
      label336:
      label636:
      Object localObject2;
      Object localObject4;
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        wja.bcO = true;
        if (!xbu.this.Rk())
        {
          locala = (xbu.a)wja.a(paramView);
          localMessageForPoke = (MessageForPoke)locala.mMessage;
          if (QLog.isColorLevel()) {
            QLog.d("GivingHeart", 2, "poke onClick() is called, type:" + localMessageForPoke.interactType);
          }
          int i;
          Object localObject1;
          if (126 == localMessageForPoke.interactType)
          {
            if (paramView.findViewById(2131379203).getVisibility() == 0) {}
            for (i = 1;; i = 0)
            {
              if (i == 0) {
                break label336;
              }
              if (!xks.s.contains(Integer.valueOf(localMessageForPoke.subId))) {
                xks.s.add(Integer.valueOf(localMessageForPoke.subId));
              }
              if (!xks.t.contains(Integer.valueOf(localMessageForPoke.subId))) {
                xks.t.add(Integer.valueOf(localMessageForPoke.subId));
              }
              if (!xks.r.contains(Integer.valueOf(localMessageForPoke.subId))) {
                xks.r.add(Integer.valueOf(localMessageForPoke.subId));
              }
              locala.progressBar.setVisibility(0);
              locala.ta.setVisibility(8);
              localObject1 = (VasQuickUpdateManager)xbu.this.app.getManager(184);
              ((VasQuickUpdateManager)localObject1).downloadItem(21L, "poke.item.effect." + localMessageForPoke.subId, "getbubbleview");
              ((VasQuickUpdateManager)localObject1).downloadItem(21L, "poke.item.res." + localMessageForPoke.subId, "getbubbleview");
              ((VasQuickUpdateManager)localObject1).addCallBacker(xbu.this.c);
              break;
            }
            if (!xks.G("bubble", localMessageForPoke.subId))
            {
              QQToast.a(xbu.this.mContext, 0, acfp.m(2131706970), 0).show();
            }
            else
            {
              if (abrj.a(xbu.this.app).cqT == 1) {}
              for (i = 0;; i = 1)
              {
                if (i != 0)
                {
                  abrb.b(xbu.this.mApp, "vas_poke", true);
                  if (QLog.isColorLevel()) {
                    QLog.i("GivingHeart.sprite", 2, "hide sprite (normal) in click.");
                  }
                }
                xks.a(xbu.this.mApp, xbu.this.mContext, locala.h, locala, localMessageForPoke.subId, "bubble");
                break;
              }
            }
          }
          else if (!PokeBigResHandler.bKF)
          {
            locala.h.clearAnimation();
            locala.h.setVisibility(8);
            locala.hD.setVisibility(0);
            QQToast.a(xbu.this.mContext, 0, acfp.m(2131706963), 0).show();
            localObject1 = (PokeBigResHandler)xbu.this.app.getBusinessHandler(117);
            if (localObject1 != null) {
              ((PokeBigResHandler)localObject1).FO(true);
            }
            if (localMessageForPoke.isSend()) {
              localMessageForPoke.setPlayed(xbu.this.mApp);
            }
          }
          else
          {
            i = 0;
            Object localObject5;
            switch (localMessageForPoke.interactType)
            {
            default: 
              localObject1 = xkr.aVf + "/chuo_icon/chuo_icon_";
              localObject5 = xbu.cF(localMessageForPoke.interactType);
              if ((localMessageForPoke.interactType == 1) || (localMessageForPoke.interactType <= 0) || (localMessageForPoke.interactType > 6)) {
                if (locala.strength == 2.0F)
                {
                  localObject1 = new BitmapFactory.Options();
                  ((BitmapFactory.Options)localObject1).inSampleSize = 1;
                  ((BitmapFactory.Options)localObject1).inMutable = true;
                }
              }
              break;
            }
            for (;;)
            {
              try
              {
                localObject1 = aqhu.d(PokeBigResHandler.brt + "/chuo_caidan/chuo_caidan_" + "01.png", (BitmapFactory.Options)localObject1);
                localObject3 = new CustomFrameAnimationDrawable(xbu.this.mContext.getResources(), (Bitmap)localObject1, xkr.a().b(), localMessageForPoke.mFrameState, (String)localObject5, xks.z(xbu.this.mApp));
                xbu.a(xbu.this, (CustomFrameAnimationDrawable)localObject3);
                ((CustomFrameAnimationDrawable)localObject3).Db(1);
                if (!localMessageForPoke.isSend())
                {
                  if (localMessageForPoke.interactType == 5) {
                    break label1715;
                  }
                  ((CustomFrameAnimationDrawable)localObject3).cdH();
                }
                ((CustomFrameAnimationDrawable)localObject3).cdJ();
                ((CustomFrameAnimationDrawable)localObject3).a(new xcg(this, locala, localMessageForPoke));
                if (localMessageForPoke.interactType == 6) {
                  break label2019;
                }
                if ((localMessageForPoke.interactType != 5) || (locala.strength != 2.0F)) {
                  break label1724;
                }
                locala.hD.setVisibility(8);
                locala.tb.setVisibility(8);
                localObject1 = ((FitSystemWindowsRelativeLayout)((ViewGroup)((Activity)xbu.this.mContext).getWindow().getDecorView()).getChildAt(0).findViewById(2131362332)).a();
                locala.wE.setVisibility(0);
                ((SixCombolEffectView)localObject1).a(locala, xks.z(xbu.this.app));
                ((SixCombolEffectView)localObject1).setListener(xbu.this);
                break;
                localObject1 = PokeBigResHandler.bru + "/chuo_motion/chuo_motion_";
                i = 35;
                break label636;
                localObject1 = PokeBigResHandler.bru + "/bixin_motion/bixin_motion_";
                i = 67;
                break label636;
                localObject1 = PokeBigResHandler.bru + "/zan_motion/zan_motion_";
                i = 20;
                break label636;
                localObject1 = PokeBigResHandler.bru + "/xinsui_motion/xinsui_motion_";
                i = 50;
                break label636;
                if (localMessageForPoke.isSend())
                {
                  localObject1 = PokeBigResHandler.bru + "/666send_motion/666send_motion_";
                  i = 57;
                  break label636;
                }
                localObject1 = PokeBigResHandler.bru + "/666receive_motion/666receive_motion_";
                continue;
                localObject1 = xkr.aVf + "/dazhao_icon/dazhao_icon_";
              }
              catch (OutOfMemoryError localOutOfMemoryError1)
              {
                if (QLog.isColorLevel()) {
                  QLog.d("GivingHeart", 2, localOutOfMemoryError1.toString());
                }
                localObject2 = null;
                continue;
              }
              localObject2 = aqhu.g(xbu.this.mContext.getResources(), 2130838528);
              Object localObject3 = new CustomFrameAnimationDrawable(xbu.this.mContext.getResources(), (Bitmap)localObject2, xkr.a().b(), localMessageForPoke.mFrameState, (String)localObject5, xks.z(xbu.this.mApp));
              xbu.b((CustomFrameAnimationDrawable)localObject3);
              continue;
              localObject3 = new BitmapFactory.Options();
              ((BitmapFactory.Options)localObject3).inScaled = true;
              ((BitmapFactory.Options)localObject3).inSampleSize = 1;
              ((BitmapFactory.Options)localObject3).inMutable = true;
              int j;
              for (;;)
              {
                try
                {
                  localObject3 = aqhu.d((String)localObject2 + "01.png", (BitmapFactory.Options)localObject3);
                  localObject5 = new CustomFrameAnimationDrawable(xbu.this.mContext.getResources(), (Bitmap)localObject3, xkr.a().b(), localMessageForPoke.mFrameState, (String)localObject5, xks.z(xbu.this.mApp));
                  ((CustomFrameAnimationDrawable)localObject5).clearFrame();
                  j = 40;
                  if (localMessageForPoke.interactType == 2) {
                    j = 30;
                  }
                  if ((localMessageForPoke.interactType != 4) || (locala.strength != 2.0F)) {
                    break label1603;
                  }
                  k = 0;
                  if (k < 20) {
                    if (k + 1 < 10)
                    {
                      ((CustomFrameAnimationDrawable)localObject5).u(k, j, (String)localObject2 + "0" + (k + 1) + ".png");
                      k += 1;
                      continue;
                    }
                  }
                }
                catch (OutOfMemoryError localOutOfMemoryError2)
                {
                  if (QLog.isColorLevel()) {
                    QLog.d("GivingHeart", 2, localOutOfMemoryError2.toString());
                  }
                  localObject4 = null;
                  continue;
                  ((CustomFrameAnimationDrawable)localObject5).u(k, j, (String)localObject2 + (k + 1) + ".png");
                  continue;
                  k = 20;
                  localObject4 = localObject5;
                }
                if (k >= i) {
                  break;
                }
                ((CustomFrameAnimationDrawable)localObject5).u(k, j, (String)localObject2 + 21 + ".png");
                k += 1;
              }
              label1603:
              int k = 0;
              localObject4 = localObject5;
              if (k < i)
              {
                if (k + 1 < 10) {
                  ((CustomFrameAnimationDrawable)localObject5).u(k, j, (String)localObject2 + "0" + (k + 1) + ".png");
                }
                for (;;)
                {
                  k += 1;
                  break;
                  ((CustomFrameAnimationDrawable)localObject5).u(k, j, (String)localObject2 + (k + 1) + ".png");
                }
                label1715:
                ((CustomFrameAnimationDrawable)localObject4).Db(2);
              }
            }
            label1724:
            locala.h.setImageDrawable((Drawable)localObject4);
            locala.h.setVisibility(0);
            locala.hD.setVisibility(8);
            locala.hD.clearAnimation();
            locala.tb.setVisibility(8);
            locala.a.clearAnimation();
            locala.a.setVisibility(8);
            if (!localMessageForPoke.mFrameState.hi) {
              break;
            }
            ((CustomFrameAnimationDrawable)localObject4).resume();
            if (QLog.isColorLevel()) {
              QLog.d("GivingHeart", 2, "[click]resume to play");
            }
          }
        }
      }
      ((CustomFrameAnimationDrawable)localObject4).start();
      label1869:
      boolean bool2;
      if (locala.strength == 2.0F)
      {
        if (localMessageForPoke.interactType == 2)
        {
          xkr.a().send(1);
          xkr.a().i(2, 1500L, localMessageForPoke.isSend());
        }
      }
      else if ((localMessageForPoke.interactType == 1) || (localMessageForPoke.interactType == 0))
      {
        localObject2 = xbu.this;
        localObject4 = (Activity)xbu.this.mContext;
        bool2 = localMessageForPoke.isSend();
        if (locala.strength != 2.0F) {
          break label2013;
        }
      }
      label2013:
      for (boolean bool1 = true;; bool1 = false)
      {
        xbu.a((xbu)localObject2, (Activity)localObject4, bool2, bool1);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("GivingHeart", 2, "[click]start to play");
        break;
        if (localMessageForPoke.interactType == 3)
        {
          xkr.a().send(4);
          xkr.a().U(5, 700L);
          break label1869;
        }
        if (localMessageForPoke.interactType != 4) {
          break label1869;
        }
        xkr.a().send(13);
        xkr.a().U(14, 800L);
        break label1869;
      }
      label2019:
      if ((PokeBigResHandler.bKF) && (!locala.a.isInit()))
      {
        localObject2 = locala.a;
        localObject4 = xbu.this.mContext;
        if (!localMessageForPoke.isSend())
        {
          bool1 = true;
          ((UnlimitedBladeWorks)localObject2).a((Context)localObject4, bool1, xks.z(xbu.this.mApp), locala.strength);
        }
      }
      else
      {
        localObject2 = locala.a;
        if (localMessageForPoke.isSend()) {
          break label2265;
        }
        bool1 = true;
        ((UnlimitedBladeWorks)localObject2).setParams(bool1);
        localObject2 = locala.a;
        if (localMessageForPoke.isSend()) {
          break label2271;
        }
      }
      label2063:
      label2105:
      label2265:
      label2271:
      for (bool1 = true;; bool1 = false)
      {
        ((UnlimitedBladeWorks)localObject2).setMirror(bool1);
        locala.a.setVisibility(0);
        locala.h.clearAnimation();
        locala.h.setVisibility(8);
        locala.h.setImageDrawable(null);
        locala.hD.setVisibility(8);
        locala.tb.setVisibility(8);
        locala.hD.clearAnimation();
        locala.a.setEndListener(new xch(this, locala, localMessageForPoke));
        if (localMessageForPoke.mUnlimitedState.hi) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.i("fangdazhao", 2, "[click]start to play");
        }
        locala.a.start();
        break;
        bool1 = false;
        break label2063;
        bool1 = false;
        break label2105;
      }
    }
  }
  
  public class c
    implements View.OnClickListener
  {
    public c() {}
    
    public void onClick(View paramView)
    {
      MessageForPoke localMessageForPoke = (MessageForPoke)((xbu.a)wja.a(paramView)).mMessage;
      anot.a(xbu.this.app, "CliOper", "", xbu.this.sessionInfo.aTl, "0X8008913", "0X8008913", 0, 0, "", "", "", "");
      switch (localMessageForPoke.interactType)
      {
      }
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        ujt.a(xbu.this.mApp, BaseApplicationImpl.getContext(), xbu.this.sessionInfo, 1, "", "");
        continue;
        ujt.a(xbu.this.mApp, BaseApplicationImpl.getContext(), xbu.this.sessionInfo, 2, "", "");
        continue;
        ujt.a(xbu.this.mApp, BaseApplicationImpl.getContext(), xbu.this.sessionInfo, 3, "", "");
        continue;
        ujt.a(xbu.this.mApp, BaseApplicationImpl.getContext(), xbu.this.sessionInfo, 4, "", "");
        continue;
        ujt.a(xbu.this.mApp, BaseApplicationImpl.getContext(), xbu.this.sessionInfo, 1, "", "");
        continue;
        ujt.a(xbu.this.mApp, BaseApplicationImpl.getContext(), xbu.this.sessionInfo, 6, "", "");
        continue;
        ujt.a(xbu.this.mApp, BaseApplicationImpl.getContext(), xbu.this.sessionInfo, 5, "", "");
        continue;
        if (!xks.bhd)
        {
          xks.bhd = true;
          xks.a(xbu.this.mApp, localMessageForPoke.subId, localMessageForPoke.name, -1, localMessageForPoke.minVersion, 1);
        }
      }
    }
  }
  
  public class d
    extends VasQuickUpdateManager.CallBacker
  {
    public d() {}
    
    public void callback(long paramLong, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, VasQuickUpdateManager paramVasQuickUpdateManager)
    {
      int i = 1;
      String str;
      if (paramLong == 21L)
      {
        paramString3 = "";
        paramString2 = Integer.valueOf(0);
        if (!paramString1.startsWith("poke.item.effect.")) {
          break label245;
        }
        str = paramString1.substring("poke.item.effect.".length(), paramString1.length());
        paramVasQuickUpdateManager = Integer.valueOf(str);
        paramString2 = paramVasQuickUpdateManager;
        paramString3 = str;
        if (!xks.s.contains(paramVasQuickUpdateManager)) {
          break label337;
        }
        xks.s.remove(paramVasQuickUpdateManager);
        paramString3 = str;
        paramString2 = paramVasQuickUpdateManager;
        paramInt2 = 1;
      }
      for (;;)
      {
        if ((!TextUtils.isEmpty(paramString3)) && (paramInt2 != 0) && (!xks.s.contains(paramString2)) && (!xks.s.contains(paramString2)))
        {
          if (xks.G("bubble", paramString2.intValue())) {
            break label318;
          }
          paramInt2 = 1;
          label142:
          if (xks.G("/normal.png", paramString2.intValue())) {
            break label324;
          }
          label155:
          boolean bool = xks.r.contains(paramString2);
          paramString3 = xbu.this.mContext;
          if ((paramInt2 == 0) || (i == 0) || (!bool)) {
            break label330;
          }
        }
        label318:
        label324:
        label330:
        for (paramString2 = acfp.m(2131706971);; paramString2 = "")
        {
          aqnl.cT(paramString3, paramString2);
          if (QLog.isColorLevel()) {
            QLog.d("GivingHeart", 2, "vas poke download id: " + paramString1 + " , errorcode: " + paramInt1);
          }
          return;
          label245:
          if (!paramString1.startsWith("poke.item.res.")) {
            break label337;
          }
          str = paramString1.substring("poke.item.res.".length(), paramString1.length());
          paramVasQuickUpdateManager = Integer.valueOf(str);
          paramString2 = paramVasQuickUpdateManager;
          paramString3 = str;
          if (!xks.t.contains(paramVasQuickUpdateManager)) {
            break label337;
          }
          xks.t.remove(paramVasQuickUpdateManager);
          paramString3 = str;
          paramString2 = paramVasQuickUpdateManager;
          paramInt2 = 1;
          break;
          paramInt2 = 0;
          break label142;
          i = 0;
          break label155;
        }
        label337:
        paramInt2 = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xbu
 * JD-Core Version:    0.7.0.1
 */