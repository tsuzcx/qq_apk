import android.content.res.Resources;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLImageView;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.tips.TipsManager.1;
import com.tencent.mobileqq.activity.aio.tips.TipsManager.2;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.operation.QQOperationViopTipTask;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XPanelContainer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Observer;
import mqq.os.MqqHandler;

public class yjh
  implements Handler.Callback, yjg
{
  Animation au;
  Animation av;
  Animation aw;
  URLImageView ax;
  protected final MqqHandler b;
  private wiw jdField_b_of_type_Wiw;
  private yjf jdField_b_of_type_Yjf;
  RelativeLayout cV;
  private Observer d;
  private XPanelContainer e;
  RelativeLayout jdField_if;
  private QQAppInterface mApp;
  private ArrayList<yjj> qW;
  public List<QQOperationViopTipTask> qm;
  private SessionInfo sessionInfo;
  int topMargin = riw.dip2px(BaseApplicationImpl.getContext(), 30.0F);
  Animation.AnimationListener u = new yji(this);
  ImageView uj;
  ImageView uk;
  int width = riw.dip2px(BaseApplicationImpl.getContext(), 50.0F);
  
  public yjh(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, wiw paramwiw, XPanelContainer paramXPanelContainer, List<QQOperationViopTipTask> paramList)
  {
    this.jdField_b_of_type_MqqOsMqqHandler = new aurf(Looper.getMainLooper(), this);
    this.mApp = paramQQAppInterface;
    this.sessionInfo = paramSessionInfo;
    this.jdField_b_of_type_Wiw = paramwiw;
    this.e = paramXPanelContainer;
    this.qm = paramList;
  }
  
  private boolean a(yjj paramyjj)
  {
    boolean bool3 = false;
    Object localObject1 = cL(paramyjj.getType());
    int i = -1;
    int[] arrayOfInt = paramyjj.E();
    boolean bool1;
    if (arrayOfInt != null)
    {
      if (this.jdField_b_of_type_Yjf != null) {
        i = this.jdField_b_of_type_Yjf.getType();
      }
      boolean bool2 = true;
      int j = 0;
      Object localObject2 = localObject1;
      if (j < arrayOfInt.length)
      {
        switch (arrayOfInt[j])
        {
        default: 
          bool1 = bool2;
          localObject1 = localObject2;
        }
        for (;;)
        {
          j += 1;
          localObject2 = localObject1;
          bool2 = bool1;
          break;
          localObject1 = localObject2;
          bool1 = bool2;
          if (i == arrayOfInt[j])
          {
            localObject1 = localObject2 + ", not allowed by excludeType: TIPS_TYPE_BAR_DISC_ACTIVE ";
            bool1 = false;
            continue;
            localObject1 = localObject2;
            bool1 = bool2;
            if (i == arrayOfInt[j])
            {
              localObject1 = localObject2 + ", not allowed by excludeType: TIPS_TYPE_BAR_FRAUD ";
              bool1 = false;
              continue;
              localObject1 = localObject2;
              bool1 = bool2;
              if (i == arrayOfInt[j])
              {
                localObject1 = localObject2 + ", not allowed by excludeType: TIPS_TYPE_BAR_FRIEND_HOT ";
                bool1 = false;
                continue;
                localObject1 = localObject2;
                bool1 = bool2;
                if (i == arrayOfInt[j])
                {
                  localObject1 = localObject2 + ", not allowed by excludeType: TIPS_TYPE_BAR_READER ";
                  bool1 = false;
                  continue;
                  localObject1 = localObject2;
                  bool1 = bool2;
                  if (i == arrayOfInt[j])
                  {
                    localObject1 = localObject2 + ", not allowed by excludeType: TIPS_TYPE_BAR_TROOP_ASSIST ";
                    bool1 = false;
                    continue;
                    localObject1 = localObject2;
                    bool1 = bool2;
                    if (i == arrayOfInt[j])
                    {
                      localObject1 = localObject2 + ", not allowed by excludeType: TIPS_TYPE_BAR_VIDEO_STATUS ";
                      bool1 = false;
                      continue;
                      localObject1 = localObject2;
                      bool1 = bool2;
                      if (i == arrayOfInt[j])
                      {
                        localObject1 = localObject2 + ", not allowed by excludeType: TIPS_TYPE_QQ_OPERATE ";
                        bool1 = false;
                        continue;
                        localObject1 = localObject2;
                        bool1 = bool2;
                        if (i == arrayOfInt[j])
                        {
                          localObject1 = localObject2 + ", not allowed by excludeType: TIPS_TYPE_BAR_PUB_ACCOUNT_ASSIST ";
                          bool1 = false;
                          continue;
                          localObject1 = localObject2;
                          bool1 = bool2;
                          if (this.e != null)
                          {
                            localObject1 = localObject2;
                            bool1 = bool2;
                            if (this.e.vm() != 0)
                            {
                              localObject1 = localObject2 + ", not allowed by excludeType: EXCLUDE_TYPE_EXT_PANEL ";
                              bool1 = false;
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
      bool1 = bool2;
      localObject1 = localObject2;
    }
    for (;;)
    {
      if ((bool1) && ((paramyjj instanceof yjf)) && (this.jdField_b_of_type_Yjf != null) && (this.jdField_b_of_type_Yjf.wM() > ((yjf)paramyjj).wM()))
      {
        localObject1 = (String)localObject1 + ", not allowed: priority is low ";
        bool1 = bool3;
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("TipsManager", 2, "allowShow(): result = " + bool1 + " | " + (String)localObject1 + "|curTipsBarType" + i);
        }
        return bool1;
      }
      bool1 = true;
      i = -1;
    }
  }
  
  public static String cL(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return " [Unknow] ";
    case 4: 
      return " [TIPS_BAR_TYPE_DISC_FREQ_CALL] ";
    case 0: 
      return " [TIPS_BAR_TYPE_FRAUD] ";
    case 5: 
      return " [TIPS_BAR_TYPE_HOT_FRIEND_CALL] ";
    case 2: 
      return " [TIPS_BAR_TYPE_VIDEO_STATUS] ";
    case 3: 
      return " [TIPS_BAR_TYPE_TROOP_ASSIST] ";
    case 6: 
      return "[TIPS_QQ_OPERATE] ";
    case 7: 
      return " [TIPS_BAR_TYPE_PUB_ACCOUNT_ASSIT] ";
    case 1: 
      return " [TIPS_BAR_TYPE_READER] ";
    case 1001: 
      return " [GRAY_TIPS_DISC_FREQ_PTT] ";
    case 1000: 
      return " [GRAY_TIPS_FRIEND_FREQ] ";
    case 1002: 
      return " [GRAY_TIPS_SOUGOU_INPUT] ";
    case 1003: 
      return " [GRAY_TIPS_GATHER_CONTACTS] ";
    case 9: 
      return " [TIPS_TYPE_RED_PACKET] ";
    case 10: 
      return " [TIPS_BAR_TYPE_FUN_CALL]";
    case 12: 
      return "[TIPS_TYPE_BAR_LIGHTALK]";
    case 1004: 
      return " [TIPS_TYPE_GRAY_HONGBAO_KEYWORDS] ";
    case 2001: 
      return " [TIPS_TYPE_GRAY_SPECIALCARE]";
    case 15: 
      return " [TIPS_TYPE_BAR_APOLLO_GAME_PARTY]";
    case 17: 
      return " [TIPS_TYPE_MOVIE_TICKET]";
    case 19: 
      return " [TIPS_TYPE_BAR_HW_TROOP]";
    case 20: 
      return "[TIPS_TYPE_BAR_HW_TROOP_SURVEY]";
    case 22: 
      return "[TIPS_TYPE_C2B]";
    }
    return "[TIPS_TYPE_TOGETHER_BUSINESS_TIPS]";
  }
  
  /* Error */
  private RelativeLayout k()
  {
    // Byte code:
    //   0: invokestatic 67	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   3: ldc 243
    //   5: aconst_null
    //   6: invokestatic 249	android/view/View:inflate	(Landroid/content/Context;ILandroid/view/ViewGroup;)Landroid/view/View;
    //   9: checkcast 251	android/widget/RelativeLayout
    //   12: astore_1
    //   13: aload_0
    //   14: aload_1
    //   15: ldc 252
    //   17: invokevirtual 256	android/widget/RelativeLayout:findViewById	(I)Landroid/view/View;
    //   20: checkcast 258	com/tencent/image/URLImageView
    //   23: putfield 260	yjh:ax	Lcom/tencent/image/URLImageView;
    //   26: aload_1
    //   27: astore_2
    //   28: new 262	java/io/File
    //   31: dup
    //   32: getstatic 268	kdm:Ys	Ljava/lang/String;
    //   35: invokespecial 271	java/io/File:<init>	(Ljava/lang/String;)V
    //   38: invokevirtual 274	java/io/File:exists	()Z
    //   41: ifeq +64 -> 105
    //   44: invokestatic 171	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   47: ifeq +12 -> 59
    //   50: ldc 173
    //   52: iconst_2
    //   53: ldc_w 276
    //   56: invokestatic 188	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   59: new 278	java/net/URL
    //   62: dup
    //   63: new 128	java/lang/StringBuilder
    //   66: dup
    //   67: invokespecial 129	java/lang/StringBuilder:<init>	()V
    //   70: ldc_w 280
    //   73: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: getstatic 268	kdm:Ys	Ljava/lang/String;
    //   79: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: invokevirtual 139	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   85: invokespecial 281	java/net/URL:<init>	(Ljava/lang/String;)V
    //   88: invokestatic 287	com/tencent/image/URLDrawable$URLDrawableOptions:obtain	()Lcom/tencent/image/URLDrawable$URLDrawableOptions;
    //   91: invokestatic 293	com/tencent/image/URLDrawable:getDrawable	(Ljava/net/URL;Lcom/tencent/image/URLDrawable$URLDrawableOptions;)Lcom/tencent/image/URLDrawable;
    //   94: astore_2
    //   95: aload_0
    //   96: getfield 260	yjh:ax	Lcom/tencent/image/URLImageView;
    //   99: aload_2
    //   100: invokevirtual 297	com/tencent/image/URLImageView:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   103: aload_1
    //   104: astore_2
    //   105: aload_2
    //   106: areturn
    //   107: astore_3
    //   108: aconst_null
    //   109: astore_1
    //   110: aload_3
    //   111: invokevirtual 300	java/net/MalformedURLException:printStackTrace	()V
    //   114: aload_1
    //   115: astore_2
    //   116: invokestatic 171	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   119: ifeq -14 -> 105
    //   122: ldc 173
    //   124: iconst_2
    //   125: new 128	java/lang/StringBuilder
    //   128: dup
    //   129: invokespecial 129	java/lang/StringBuilder:<init>	()V
    //   132: ldc_w 302
    //   135: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: aload_3
    //   139: invokevirtual 305	java/net/MalformedURLException:getMessage	()Ljava/lang/String;
    //   142: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: invokevirtual 139	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   148: invokestatic 188	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   151: aload_1
    //   152: areturn
    //   153: astore_1
    //   154: aconst_null
    //   155: areturn
    //   156: astore_2
    //   157: aload_1
    //   158: areturn
    //   159: astore_3
    //   160: goto -50 -> 110
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	163	0	this	yjh
    //   12	140	1	localRelativeLayout	RelativeLayout
    //   153	5	1	localThrowable1	Throwable
    //   27	89	2	localObject	Object
    //   156	1	2	localThrowable2	Throwable
    //   107	32	3	localMalformedURLException1	java.net.MalformedURLException
    //   159	1	3	localMalformedURLException2	java.net.MalformedURLException
    // Exception table:
    //   from	to	target	type
    //   0	13	107	java/net/MalformedURLException
    //   0	13	153	java/lang/Throwable
    //   13	26	156	java/lang/Throwable
    //   28	59	156	java/lang/Throwable
    //   59	103	156	java/lang/Throwable
    //   13	26	159	java/net/MalformedURLException
    //   28	59	159	java/net/MalformedURLException
    //   59	103	159	java/net/MalformedURLException
  }
  
  public yjf a()
  {
    return this.jdField_b_of_type_Yjf;
  }
  
  public void a(Observer paramObserver)
  {
    this.d = paramObserver;
  }
  
  public void a(yjj paramyjj)
  {
    if (paramyjj == null) {}
    do
    {
      return;
      if (this.qW == null) {
        this.qW = new ArrayList();
      }
    } while (this.qW.contains(paramyjj));
    this.qW.add(paramyjj);
  }
  
  public boolean a(yim paramyim, Object... paramVarArgs)
  {
    if (paramyim != null)
    {
      if (a(paramyim)) {
        break label29;
      }
      if (QLog.isColorLevel()) {
        QLog.d("TipsManager", 2, "showGrayTips() failure: mTipsMgr not allow");
      }
    }
    label29:
    do
    {
      return false;
      paramVarArgs = paramyim.a(paramVarArgs);
      if (paramVarArgs != null)
      {
        this.mApp.b().b(paramVarArgs, paramVarArgs.selfuin);
        if (QLog.isColorLevel()) {
          QLog.d("TipsManager", 2, "showGrayTips() success: from " + cL(paramyim.getType()));
        }
        return true;
      }
    } while (!QLog.isColorLevel());
    QLog.d("TipsManager", 2, "showGrayTips() failure: MessageRecord null, from " + cL(paramyim.getType()));
    return false;
  }
  
  public boolean a(yjf paramyjf, Object... paramVarArgs)
  {
    if (wja.bcM) {}
    label136:
    do
    {
      do
      {
        return false;
        if (paramyjf == null) {
          break label136;
        }
        if (a(paramyjf)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("TipsManager", 2, "showTipsBar() failure: mTipsMgr not allow");
      return false;
      if (Thread.currentThread() == Looper.getMainLooper().getThread())
      {
        paramVarArgs = paramyjf.a(paramVarArgs);
        this.jdField_b_of_type_Wiw.a(paramVarArgs, paramyjf);
        this.jdField_b_of_type_Yjf = paramyjf;
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("TipsManager", 2, "showTipsBar() success: from " + cL(paramyjf.getType()));
        }
        return true;
        paramVarArgs = new TipsManager.1(this, paramyjf, paramVarArgs);
        this.jdField_b_of_type_MqqOsMqqHandler.post(paramVarArgs);
      }
    } while (!QLog.isColorLevel());
    QLog.d("TipsManager", 2, "showTipsBar() failure: tipsBar == null");
    return false;
  }
  
  public void ciA()
  {
    if (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      if (this.jdField_b_of_type_Wiw != null) {
        this.jdField_b_of_type_Wiw.a(this.jdField_b_of_type_Yjf);
      }
      this.jdField_b_of_type_Yjf = null;
      if (this.qm != null) {
        this.qm.clear();
      }
      return;
    }
    TipsManager.2 local2 = new TipsManager.2(this);
    this.jdField_b_of_type_MqqOsMqqHandler.post(local2);
  }
  
  public void ciB()
  {
    int i = 2131380210;
    int j = 2131380204;
    if ((this.ax == null) || (this.jdField_if == null) || (this.cV == null)) {
      return;
    }
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(this.width, this.width);
    localLayoutParams.addRule(11);
    View localView1 = this.jdField_if.findViewById(2131380210);
    View localView2 = this.jdField_if.findViewById(2131380204);
    if ((localView1 != null) && (localView1.getVisibility() == 0)) {}
    for (;;)
    {
      if ((localView2 != null) && (localView2.getVisibility() == 0)) {
        i = j;
      }
      for (;;)
      {
        j = this.topMargin;
        int k = BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131299627);
        if (i == -1) {
          localLayoutParams.addRule(10);
        }
        for (i = j + k;; i = j)
        {
          localLayoutParams.topMargin = i;
          localLayoutParams.rightMargin = riw.dip2px(BaseApplicationImpl.getContext(), 40.0F);
          this.cV.setLayoutParams(localLayoutParams);
          return;
          localLayoutParams.addRule(3, i);
        }
      }
      i = -1;
    }
  }
  
  public void ciC()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TipsManager", 2, "[removeJdEntry]");
    }
    try
    {
      if ((this.jdField_if != null) && (this.cV != null) && (this.jdField_if.findViewById(2131368601) != null))
      {
        this.cV.setOnClickListener(null);
        this.cV.clearAnimation();
        this.uj = ((ImageView)this.cV.findViewById(2131367349));
        this.uk = ((ImageView)this.cV.findViewById(2131367350));
        if (this.uj != null) {
          this.uj.clearAnimation();
        }
        if (this.uk != null) {
          this.uk.clearAnimation();
        }
        this.cV.startAnimation(this.aw);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("TipsManager", 2, localThrowable.getMessage());
    }
  }
  
  public void destory()
  {
    h(1004, new Object[0]);
    if (this.qW != null) {
      this.qW.clear();
    }
    ciA();
    if (this.jdField_b_of_type_Wiw != null) {
      this.jdField_b_of_type_Wiw.bYt();
    }
    if (this.jdField_b_of_type_MqqOsMqqHandler != null) {
      this.jdField_b_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
    }
    if ((this.jdField_if != null) && (this.cV != null) && (this.jdField_if.indexOfChild(this.cV) != -1))
    {
      this.cV.clearAnimation();
      this.jdField_if.removeView(this.cV);
      this.jdField_if = null;
      this.cV = null;
    }
  }
  
  public void h(int paramInt, Object... paramVarArgs)
  {
    if (this.qW != null)
    {
      Iterator localIterator = this.qW.iterator();
      while (localIterator.hasNext()) {
        ((yjj)localIterator.next()).h(paramInt, paramVarArgs);
      }
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    return false;
  }
  
  public int wN()
  {
    if (this.jdField_b_of_type_Yjf != null) {
      return this.jdField_b_of_type_Yjf.getType();
    }
    return -1;
  }
  
  public void x(View.OnClickListener paramOnClickListener)
  {
    if (this.au == null)
    {
      this.au = new TranslateAnimation(0.0F, 0.0F, -(this.topMargin + this.width), 0.0F);
      this.au.setDuration(208L);
      this.au.setAnimationListener(this.u);
    }
    if (this.av == null)
    {
      this.av = new TranslateAnimation(0.0F, 0.0F, 10.0F, -10.0F);
      this.av.setDuration(150L);
      this.av.setRepeatCount(-1);
      this.av.setRepeatMode(2);
    }
    if (this.aw == null)
    {
      this.aw = new TranslateAnimation(0.0F, 0.0F, 0.0F, -(this.topMargin + this.width));
      this.aw.setDuration(208L);
      this.aw.setFillAfter(true);
      this.aw.setAnimationListener(this.u);
    }
    if (this.cV == null)
    {
      this.cV = k();
      if (this.cV == null) {
        return;
      }
      this.cV.setId(2131368601);
    }
    this.cV.setOnClickListener(paramOnClickListener);
    if (this.jdField_if == null) {
      this.jdField_if = ((RelativeLayout)this.e.findViewById(2131364469));
    }
    if (this.jdField_if.findViewById(2131368601) == null) {
      this.jdField_if.addView(this.cV);
    }
    ciB();
    this.cV.startAnimation(this.au);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yjh
 * JD-Core Version:    0.7.0.1
 */