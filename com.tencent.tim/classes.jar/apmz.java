import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Message;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.RotateAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.apollo.activity.HotChatCenterFragment;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.AioPushData;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.troop.navigatebar.TroopAioMsgNavigateBar.1;
import com.tencent.mobileqq.troop.navigatebar.TroopAioMsgNavigateBar.2;
import com.tencent.mobileqq.troop.navigatebar.TroopAioMsgNavigateBar.3;
import com.tencent.mobileqq.troop.navigatebar.TroopAioMsgNavigateBar.4;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.URLThemeImageView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.os.MqqHandler;

public class apmz
  extends apab
  implements View.OnClickListener, Animation.AnimationListener
{
  static long arI = 2147483647L;
  private float Ah;
  private List<Long> HZ = new ArrayList();
  private View Ij;
  private View Ik;
  private Animation X;
  apmt a;
  protected int aOr;
  private Animation aT;
  private Animation aV;
  private TextView aaW;
  private TextView aaX;
  long arJ = arI;
  private long arK;
  protected long arL;
  apnu b;
  private URLThemeImageView c;
  private boolean cPC;
  boolean cPw = false;
  private boolean cRA;
  boolean cRB;
  private boolean cRz;
  private String cqd;
  private String cqe;
  private String cqf;
  private String cqg = "";
  protected int dSI;
  private int dSt = -1;
  public AtomicBoolean ee = new AtomicBoolean(false);
  protected Object fm;
  private Object fn;
  private Object fo;
  protected int mScreenHeight;
  private ImageView rx;
  
  private void Tn(String paramString)
  {
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.aaW.getLayoutParams();
    if (this.c == null) {
      this.c = ((URLThemeImageView)this.Ij.findViewById(2131380206));
    }
    if (this.jdField_a_of_type_Apmt.a(this.dSt, this.c, paramString)) {
      return;
    }
    Object localObject2;
    if ((this.dSt != 1) && (!TextUtils.isEmpty(paramString)))
    {
      if ((!paramString.equals(this.cqg)) && (this.c.getVisibility() == 0))
      {
        this.cqg = paramString;
        this.c.setImageDrawable(aqdj.a(this.app, 1, paramString));
        return;
      }
      this.c.setVisibility(0);
      localObject1 = (LinearLayout.LayoutParams)this.c.getLayoutParams();
      if (this.sessionInfo.cZ == 3000)
      {
        int i = aqcx.dip2px(this.context, 30.0F);
        ((LinearLayout.LayoutParams)localObject1).height = i;
        ((LinearLayout.LayoutParams)localObject1).width = i;
      }
      for (;;)
      {
        this.c.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        localObject1 = (acff)this.app.getManager(51);
        localObject2 = (HotChatManager)this.app.getManager(60);
        if ((localObject2 == null) || (!((HotChatManager)localObject2).kj(this.sessionInfo.aTl)) || (localObject1 == null) || (((acff)localObject1).isFriend(paramString))) {
          break;
        }
        this.c.setImageDrawable(aqdj.a(this.app, 200, paramString, true));
        label260:
        if (this.sessionInfo.cZ == 3000) {
          localLayoutParams.leftMargin = aqcx.dip2px(this.context, 7.0F);
        }
        label287:
        if (this.sessionInfo.cZ != 3000) {
          break label580;
        }
        this.aaW.setLayoutParams(localLayoutParams);
        return;
        ((LinearLayout.LayoutParams)localObject1).setMargins(aqcx.dip2px(this.context, 2.5F), aqcx.dip2px(this.context, 2.5F), 0, aqcx.dip2px(this.context, 2.5F));
      }
      if (this.dSt == 22)
      {
        localObject1 = this.Ij.getTag();
        if (!(localObject1 instanceof apab.a)) {
          break label582;
        }
        long l = ((apab.a)localObject1).shmsgseq;
        localObject1 = this.app.b().c(this.sessionInfo.aTl, this.sessionInfo.cZ, l, 0L);
        if ((localObject1 != null) && (((List)localObject1).size() > 0))
        {
          localObject1 = (MessageRecord)((List)localObject1).get(0);
          label437:
          if ((localObject1 == null) || (!jof.a((MessageRecord)localObject1))) {
            break label582;
          }
          localObject2 = this.context.getResources().getDrawable(2130844459);
        }
      }
    }
    label580:
    label582:
    for (Object localObject1 = URLDrawable.getDrawable(jof.aV(jof.a((MessageRecord)localObject1).aCv), (Drawable)localObject2, (Drawable)localObject2);; localObject1 = null)
    {
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = aqdj.a(this.app, 1, paramString);
      }
      this.c.setImageDrawable((Drawable)localObject2);
      break label260;
      localObject1 = null;
      break label437;
      this.c.setImageDrawable(aqdj.a(this.app, 1, paramString));
      break label260;
      this.c.setVisibility(8);
      if (this.sessionInfo.cZ != 3000) {
        break label287;
      }
      localLayoutParams.leftMargin = aqcx.dip2px(this.context, 14.0F);
      break label287;
      break;
    }
  }
  
  private void WQ(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Navigate.TroopAioMsgNavigateBar", 2, "hideMsgNavigateBarInternal, type = " + paramInt);
    }
    if (this.bvv)
    {
      this.cPC = false;
      this.jdField_b_of_type_Apnu.aJ(this.sessionInfo.aTl, this.sessionInfo.cZ, this.dSt);
      if (paramInt != 0) {
        break label129;
      }
      this.dSt = -1;
    }
    label129:
    while (!aAL())
    {
      if ((this.Ij != null) && (this.X != null) && (this.Ik != null) && (this.Ik.getVisibility() == 0))
      {
        this.Ij.clearAnimation();
        this.Ij.startAnimation(this.X);
      }
      return;
    }
    if ((this.cRA) && (!this.app.b().a().an(this.sessionInfo.aTl, this.sessionInfo.cZ)))
    {
      setChanged();
      notifyObservers(this.Ij.getTag());
    }
    dYs();
  }
  
  public static int a(RelativeLayout paramRelativeLayout, int... paramVarArgs)
  {
    int i = 0;
    if (paramVarArgs == null) {
      return 0;
    }
    int m = 0;
    int j = 0;
    if (i < paramVarArgs.length)
    {
      View localView = paramRelativeLayout.findViewById(paramVarArgs[i]);
      int k = m;
      int n = j;
      if (localView != null)
      {
        if (localView.getVisibility() == 0) {
          break label69;
        }
        n = j;
        k = m;
      }
      for (;;)
      {
        i += 1;
        m = k;
        j = n;
        break;
        label69:
        int i1 = localView.getBottom();
        k = m;
        n = j;
        if (i1 >= j)
        {
          k = paramVarArgs[i];
          n = i1;
        }
      }
    }
    return m;
  }
  
  private void eaI()
  {
    this.cRA = false;
    if ((this.Ik.getVisibility() == 8) && (this.Ij != null) && (this.aT != null))
    {
      this.Ah = 0.0F;
      this.Ij.clearAnimation();
      this.Ij.startAnimation(this.aT);
      this.Ik.setVisibility(0);
      this.Ij.setVisibility(0);
      this.jdField_a_of_type_Apmt.a(this.dSt, this.Ij.getTag(), this.cqe);
    }
  }
  
  private void eaJ()
  {
    ThreadManager.getUIHandler().post(new TroopAioMsgNavigateBar.2(this));
  }
  
  private int g(int... paramVarArgs)
  {
    return a(this.fs, paramVarArgs);
  }
  
  public static boolean ma(int paramInt)
  {
    return (paramInt == 17) || (paramInt == 11) || (paramInt == 100);
  }
  
  public int Lf()
  {
    return this.dSt;
  }
  
  public void WR(int paramInt)
  {
    this.cPw = false;
    ThreadManager.getUIHandler().post(new TroopAioMsgNavigateBar.4(this, paramInt));
  }
  
  public void a(int paramInt, String paramString1, Object paramObject, String paramString2)
  {
    if (this.fs == null) {
      return;
    }
    if (this.Ik == null)
    {
      this.Ik = LayoutInflater.from(this.context).inflate(2131560755, null);
      this.Ik.setVisibility(8);
    }
    if (this.fs.indexOfChild(this.Ik) == -1)
    {
      localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.topMargin = aqcx.dip2px(this.context, 18.0F);
      localLayoutParams.addRule(11);
      this.fs.addView(this.Ik, localLayoutParams);
    }
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.Ik.getLayoutParams();
    int i = g(new int[] { 2131380368, 2131374819, 2131374907, 2131374902 });
    if (i > 0) {
      localLayoutParams.addRule(3, i);
    }
    if (this.Ij == null) {
      this.Ij = this.Ik.findViewById(2131380204);
    }
    this.Ik.setBackgroundResource(17170445);
    this.Ij.setTag(paramObject);
    this.aaX = ((TextView)this.Ij.findViewById(2131380209));
    this.aaW = ((TextView)this.Ij.findViewById(2131380208));
    this.rx = ((ImageView)this.Ij.findViewById(2131380205));
    this.aaX.setText(aqgv.h(this.app, this.sessionInfo.aTl, paramString2));
    this.aaW.setText(paramString1);
    this.aaW.setVisibility(0);
    Tn(paramString2);
    this.Ij.setBackgroundResource(2130844676);
    this.aaW.setTextColor(this.context.getResources().getColor(2131166501));
    this.aaX.setTextColor(this.context.getResources().getColor(2131166501));
    this.rx.setBackgroundResource(2130851830);
    this.Ij.setOnClickListener(this);
    this.jdField_a_of_type_Apmt.a(paramInt, this.aaX, this.aaW, this.rx, this.cqe);
  }
  
  protected void a(apmr.a parama)
  {
    if (this.dSt != 102) {
      return;
    }
    this.cRB = parama.isShow();
    this.cqe = parama.iZ();
    if (this.cRB)
    {
      hZ();
      return;
    }
    dYu();
  }
  
  public boolean aAL()
  {
    if ((!this.bvv) || (this.cPw) || (this.aOr <= 0))
    {
      QLog.d("Navigate.TroopAioMsgNavigateBar", 1, "isNeedToShowNavigateBar exception: isInitSuccess = " + this.bvv + ", mHasShowBar = " + this.cPw + ", mUnreadCount = " + this.aOr);
      return false;
    }
    int i = this.jdField_b_of_type_Apnu.ap(this.sessionInfo.aTl, this.sessionInfo.cZ);
    boolean bool = this.jdField_a_of_type_Apmt.bt(i, this.aOr);
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("isNeedToShowNavigateBar: navigateType:").append(i).append(", mUnreadCount = ").append(this.aOr).append(", isNeedToShow:").append(bool);
      if (!aAM()) {
        break label218;
      }
    }
    label218:
    for (String str = ", mMulNativigateSeqList size:" + this.HZ.size();; str = "")
    {
      QLog.d("Navigate.TroopAioMsgNavigateBar", 2, str);
      return bool;
    }
  }
  
  public boolean aAM()
  {
    return (ma(this.dSt)) && (!aqio.isEmpty(this.HZ));
  }
  
  public boolean aBm()
  {
    return (this.Ik != null) && (this.Ik.getVisibility() != 8);
  }
  
  protected void cbf()
  {
    this.jdField_b_of_type_Apnu.aJ(this.sessionInfo.aTl, this.sessionInfo.cZ, 0);
    this.cPw = false;
    if ((this.Ik != null) && (this.Ij != null))
    {
      this.Ij.clearAnimation();
      this.Ik.setVisibility(8);
      ViewGroup localViewGroup = (ViewGroup)this.Ik.getParent();
      if (localViewGroup != null) {
        localViewGroup.removeView(this.Ik);
      }
    }
    this.jdField_a_of_type_Apmt.cbt();
  }
  
  public View cx()
  {
    return this.Ik;
  }
  
  public void dYs()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Navigate.TroopAioMsgNavigateBar", 2, "showNavigateBarIfNeeded");
    }
    if (!aAL()) {
      return;
    }
    eaF();
    TroopAioMsgNavigateBar.1 local1 = new TroopAioMsgNavigateBar.1(this);
    ThreadManager.getSubThreadHandler().post(local1);
  }
  
  public void dYu()
  {
    ThreadManager.getUIHandler().post(new TroopAioMsgNavigateBar.3(this));
  }
  
  protected void eaF()
  {
    this.dSt = this.jdField_b_of_type_Apnu.ap(this.sessionInfo.aTl, this.sessionInfo.cZ);
    this.HZ = this.jdField_b_of_type_Apnu.x(this.sessionInfo.aTl, this.dSt);
    if (this.sessionInfo.cZ == 1) {
      this.fm = this.jdField_b_of_type_Apnu.u(this.sessionInfo.aTl);
    }
    if (aAM())
    {
      if (this.jdField_b_of_type_Apnu.aR(this.sessionInfo.aTl) != -1L) {
        Collections.sort(this.HZ, new apmz.a(null));
      }
      if (aqio.isEmpty(this.HZ)) {}
    }
    for (this.arL = ((Long)this.HZ.get(this.HZ.size() - 1)).longValue();; this.arL = this.jdField_b_of_type_Apnu.c(this.sessionInfo.cZ, this.sessionInfo.aTl))
    {
      this.arK = this.jdField_b_of_type_Apnu.k(this.sessionInfo.aTl, this.arL);
      if (QLog.isColorLevel()) {
        QLog.d("Navigate.TroopAioMsgNavigateBar", 2, "initNavigateType, mMulNativigateSeqList.size = " + this.HZ.size() + ", navigateType = " + this.dSt + ", navShMsgSeq = " + this.arK + ", navigateSeq = " + this.arL);
      }
      return;
    }
  }
  
  public void eaG()
  {
    this.cPw = true;
    this.fn = null;
    ??? = (TroopManager)this.app.getManager(52);
    if (??? != null)
    {
      ??? = ((TroopManager)???).b(this.sessionInfo.aTl);
      if ((??? != null) && (((TroopInfo)???).hasOrgs())) {
        this.cRz = true;
      }
    }
    long l1;
    Object localObject2;
    if (aAM())
    {
      if (this.cRz)
      {
        ??? = this.app.b().a(this.sessionInfo.aTl, this.sessionInfo.cZ);
        if (??? != null)
        {
          l1 = ((QQMessageFacade.Message)???).shmsgseq;
          long l2 = this.arL;
          anot.a(this.app, "P_CliOper", "Grp_work", "", "use", "his_owner", 0, 0, this.sessionInfo.aTl, "", "", l1 - l2 + "");
        }
      }
      if ((!aqio.isEmpty(this.HZ)) && (this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView != null) && (this.jdField_a_of_type_Wki != null))
      {
        localObject2 = (ChatMessage)this.jdField_a_of_type_Wki.getItem(this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.getFirstVisiblePosition());
        if (localObject2 == null) {}
      }
    }
    for (;;)
    {
      int i;
      synchronized (this.HZ)
      {
        l1 = apab.a.a(this.dSt, ((ChatMessage)localObject2).shmsgseq, ((ChatMessage)localObject2).uniseq);
        i = this.HZ.size() - 1;
        if (i >= 0)
        {
          if (l1 > ((Long)this.HZ.get(i)).longValue()) {
            break label597;
          }
          this.HZ.remove(i);
          break label597;
        }
        this.cqd = this.sessionInfo.aTl;
        l1 = arI;
        ??? = f();
        if (??? != null) {
          l1 = ((MessageRecord)???).shmsgseq;
        }
        localObject2 = this.jdField_a_of_type_Apmt.a(this.dSt, this.HZ, this.arL, this.fm, l1, this.arJ, this.aOr);
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder().append("prepareShowNavigateBar, navigateType = ").append(this.dSt).append(", navigateSeq = ").append(this.arL).append("， mMulNativigateSeqList.size = ").append(aqio.size(this.HZ)).append(", firstMsgSeq = ").append(l1).append(", mTroopLastReadSeq = ").append(this.arJ).append(", unreadCount = ").append(this.aOr).append(", entity = ");
          if (localObject2 == null)
          {
            ??? = "null";
            QLog.d("Navigate.TroopAioMsgNavigateBar", 2, (String)???);
          }
        }
        else
        {
          if (localObject2 != null) {
            break label526;
          }
          this.cRB = false;
          return;
        }
      }
      ??? = localObject3.toString();
      continue;
      label526:
      if ((aAM()) && (aqio.isEmpty(this.HZ))) {}
      for (this.cRB = false;; this.cRB = localObject3.isShow())
      {
        this.cqe = localObject3.iZ();
        this.fo = localObject3.getTag();
        this.cqf = localObject3.hf();
        this.fn = localObject3.V();
        return;
      }
      label597:
      i -= 1;
    }
  }
  
  public void eaH()
  {
    if ((this.dSt != 102) || (!this.cRB)) {
      hZ();
    }
    apmr localapmr;
    do
    {
      return;
      localapmr = this.jdField_a_of_type_Apmt.a(102);
    } while (!(localapmr instanceof apnm));
    ((apnm)localapmr).eaK();
  }
  
  @Nullable
  protected MessageRecord f()
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.jdField_a_of_type_Wki != null)
    {
      localObject1 = localObject2;
      if (this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView != null) {
        localObject1 = (MessageRecord)this.jdField_a_of_type_Wki.getItem(this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.getFirstVisiblePosition());
      }
    }
    return localObject1;
  }
  
  public void fG(long paramLong)
  {
    if ((paramLong > this.arJ) && (this.aOr > 0)) {
      this.aOr -= 1;
    }
    dYs();
  }
  
  protected void hZ()
  {
    int i = 1;
    if ((this.sessionInfo == null) || (TextUtils.isEmpty(this.sessionInfo.aTl)) || (!this.sessionInfo.aTl.equals(this.cqd))) {
      return;
    }
    if (this.cRB)
    {
      a(this.dSt, this.cqe, this.fo, this.cqf);
      eaJ();
      dYh();
      anot.b(null, "dc00898", "", this.sessionInfo.aTl, "qq_vip", "0X800A8FB", 0, 1, 0, "", "", "", "");
      return;
    }
    MessageRecord localMessageRecord = f();
    if (localMessageRecord != null) {
      if ((this.arK <= this.arJ) || (this.arK < localMessageRecord.shmsgseq)) {}
    }
    for (;;)
    {
      if ((i != 0) && (lX(this.dSt)) && (!this.app.b().a().an(this.sessionInfo.aTl, this.sessionInfo.cZ)))
      {
        setChanged();
        notifyObservers(apab.a.a(this.dSt, this.arL, this.aOr));
        if (QLog.isColorLevel()) {
          QLog.d("Navigate.TroopAioMsgNavigateBar.troop.special_msg", 2, "notifyUi==>navigateType = " + this.dSt + ", navigateSeq = " + this.arL + ", navShMsgSeq = " + this.arK);
        }
      }
      dYu();
      return;
      i = 0;
      continue;
      i = 0;
    }
  }
  
  protected long hv()
  {
    return this.arJ;
  }
  
  protected boolean isShow()
  {
    return this.cRB;
  }
  
  public boolean lX(int paramInt)
  {
    return this.jdField_a_of_type_Apmt.lX(paramInt);
  }
  
  public void mM(List<ChatMessage> paramList)
  {
    if ((paramList == null) || (!aAM())) {
      return;
    }
    List localList = this.HZ;
    int i = 0;
    for (;;)
    {
      Object localObject;
      try
      {
        if (i < paramList.size())
        {
          localObject = (ChatMessage)paramList.get(i);
          this.HZ.remove(Long.valueOf(((ChatMessage)localObject).shmsgseq));
          this.HZ.remove(Long.valueOf(((ChatMessage)localObject).uniseq));
          i += 1;
          continue;
        }
        i = this.HZ.size();
        if (QLog.isColorLevel()) {
          QLog.d("Navigate.TroopAioMsgNavigateBar", 2, "removeMsgSeqOnScoll, sizeAfterRemove = " + i);
        }
        if (i == 0) {
          break label354;
        }
        paramList = (apab.a)this.Ij.getTag();
        if ((paramList == null) || ((!paramList.cPu) && (!paramList.cPv))) {
          break label214;
        }
        if (paramList.cPu)
        {
          this.aaW.setText(this.context.getString(2131719487));
          return;
        }
      }
      finally {}
      this.aaW.setText(this.context.getString(2131719508));
      continue;
      label214:
      Resources localResources;
      if ((paramList != null) && (paramList.dSt == 17))
      {
        localObject = this.aaW;
        localResources = this.context.getResources();
        if (i > 99) {}
        for (paramList = "99+";; paramList = Integer.valueOf(i))
        {
          ((TextView)localObject).setText(localResources.getString(2131696129, new Object[] { paramList }));
          break;
        }
      }
      if ((paramList != null) && (paramList.dSt == 100))
      {
        localObject = this.aaX;
        localResources = this.context.getResources();
        if (i > 99) {}
        for (paramList = "99+";; paramList = Integer.valueOf(i))
        {
          ((TextView)localObject).setText(localResources.getString(2131701847, new Object[] { paramList }));
          break;
        }
        label354:
        this.cRA = false;
        dYu();
      }
    }
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if ((this.app == null) || (this.Ik == null) || (this.sessionInfo == null) || (this.Ij == null) || (paramAnimation == null)) {
      return;
    }
    this.app.getHandler(ChatActivity.class).obtainMessage(68).sendToTarget();
    if (paramAnimation.equals(this.X))
    {
      this.Ik.setVisibility(8);
      this.Ij.setVisibility(8);
      if ((this.fn != null) && ((this.fn instanceof AioPushData)))
      {
        paramAnimation = (AioPushData)this.fn;
        if (!paramAnimation.isShow)
        {
          VipUtils.a(this.app, "cmshow", "Apollo", "clk_active", 0, 0, new String[] { String.valueOf(paramAnimation.busId), paramAnimation.actId });
          HotChatCenterFragment.a(this.app, this.context, paramAnimation, this.sessionInfo.aTl);
          return;
        }
        this.fn = null;
      }
      if ((this.cRA) && (!this.app.b().a().an(this.sessionInfo.aTl, this.sessionInfo.cZ)))
      {
        setChanged();
        notifyObservers(this.Ij.getTag());
      }
    }
    this.cPw = false;
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
  
  public void onClick(View paramView)
  {
    if (paramView == null) {
      if (QLog.isDevelopLevel()) {
        QLog.i("Navigate.TroopAioMsgNavigateBar", 4, "TroopAioMsgNavigateBar onClick v == null");
      }
    }
    do
    {
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        switch (paramView.getId())
        {
        default: 
          break;
        case 2131362377: 
          dYu();
        }
      }
    } while (this.sessionInfo == null);
    this.cRA = true;
    anot.b(null, "dc00898", "", this.sessionInfo.aTl, "qq_vip", "0X800A8FC", 0, 1, 0, "", "", "", "");
    if (this.sessionInfo.cZ == 3000) {
      anot.a(this.app, "CliOper", "", "", "0X800621C", "0X800621C", 0, 0, "", "", "", "");
    }
    if (QLog.isColorLevel()) {
      QLog.d("Navigate.TroopAioMsgNavigateBar", 2, "click nav bar: navigateType = " + this.dSt + ", navigateSeq = " + this.arL);
    }
    int i;
    if (ma(this.dSt))
    {
      if (aqio.isEmpty(this.HZ)) {
        break label1140;
      }
      if (this.cRz) {
        anot.a(this.app, "P_CliOper", "Grp_work", "", "use", "Clk_owner", 0, 0, this.sessionInfo.aTl, "", "", "");
      }
      if (!(this.Ij.getTag() instanceof apab.a)) {
        break label1140;
      }
      this.ee.set(true);
      apab.a locala = (apab.a)this.Ij.getTag();
      for (;;)
      {
        int j;
        Object localObject2;
        synchronized (this.HZ)
        {
          i = this.HZ.size();
          long l = ((Long)this.HZ.remove(0)).longValue();
          apab.a.a(this.dSt, l, locala);
          j = this.HZ.size();
          if (QLog.isColorLevel()) {
            QLog.d("Navigate.TroopAioMsgNavigateBar", 2, "sizeAfterClick = " + j + ", mArrowImageRotated = " + this.cPC + ", seq = " + l);
          }
          if (j != 0)
          {
            if (!this.cPC)
            {
              this.rx.startAnimation(this.aV);
              this.cPC = true;
            }
            localObject1 = null;
            if (this.c != null)
            {
              l = ((Long)this.HZ.get(0)).longValue();
              localObject2 = this.app.b().d(this.sessionInfo.aTl, this.sessionInfo.cZ, l);
              localObject1 = localObject2;
              if (localObject2 != null)
              {
                Tn(((MessageRecord)localObject2).senderuin);
                if (this.dSt != 17) {
                  break label697;
                }
                this.aaX.setText(aqgv.h(this.app, this.sessionInfo.aTl, ((MessageRecord)localObject2).senderuin));
                localObject1 = localObject2;
              }
            }
            if (!MessageForQQWalletMsg.isRedPacketMsg((MessageRecord)localObject1)) {
              break label756;
            }
            localObject1 = (MessageForQQWalletMsg)localObject1;
            if ((((MessageForQQWalletMsg)localObject1).messageType != 7) && (((MessageForQQWalletMsg)localObject1).messageType != 8)) {
              break label730;
            }
            this.aaW.setText(this.context.getString(2131719508));
            locala.cPv = true;
          }
          else
          {
            if ((i == 1) || (this.app.b().a().an(this.sessionInfo.aTl, this.sessionInfo.cZ))) {
              break;
            }
            if (QLog.isColorLevel()) {
              QLog.d("Navigate.TroopAioMsgNavigateBar", 2, "onClick notify");
            }
            setChanged();
            notifyObservers(locala);
          }
        }
        label697:
        Object localObject1 = localObject2;
        if (this.dSt == 11)
        {
          this.aaX.setText(acfp.m(2131715523));
          localObject1 = localObject2;
          continue;
          label730:
          this.aaW.setText(this.context.getString(2131719487));
          locala.cPu = true;
          continue;
          label756:
          Resources localResources;
          if (this.dSt == 17)
          {
            locala.cPu = false;
            localObject2 = this.aaW;
            localResources = this.context.getResources();
            if (j > 99) {}
            for (localObject1 = "99+";; localObject1 = Integer.valueOf(j))
            {
              ((TextView)localObject2).setText(localResources.getString(2131696129, new Object[] { localObject1 }));
              break;
            }
          }
          if (this.dSt == 100)
          {
            locala.cPu = false;
            localObject2 = this.aaX;
            localResources = this.context.getResources();
            if (j > 99) {}
            for (localObject1 = "99+";; localObject1 = Integer.valueOf(j))
            {
              ((TextView)localObject2).setText(localResources.getString(2131701847, new Object[] { localObject1 }));
              break;
            }
          }
          if (this.dSt == 11)
          {
            locala.cPu = false;
            this.aaW.setText(acfp.m(2131715521));
          }
        }
      }
      if (!locala.cPu) {
        break label1135;
      }
      i = 1;
    }
    for (;;)
    {
      label947:
      if (i != 0)
      {
        anot.a(this.app, "P_CliOper", "Grp_AIO", "", "AIOchat", "Clk_topmsgcue_hongbao", 0, 0, this.sessionInfo.aTl, "", "", "");
        anot.a(this.app, "dc00899", "Grp_AIO", "", "notice_center_new", "clk_hongbao", 0, 0, this.sessionInfo.aTl, "", "", "");
      }
      for (;;)
      {
        dYu();
        break;
        anot.a(this.app, "P_CliOper", "Grp_AIO", "", "AIOchat", "Clk_topmsgcue_sf", 0, 0, this.sessionInfo.aTl, "", "", "");
        anot.a(this.app, "dc00899", "Grp_AIO", "", "notice_center_new", "clk_special_focus", 0, 0, this.sessionInfo.aTl, "", "", "");
        continue;
        this.jdField_a_of_type_Apmt.b(this.dSt, this.Ij.getTag(), this.cqe);
      }
      label1135:
      i = 0;
      break label947;
      label1140:
      i = 0;
    }
  }
  
  protected void onInit()
  {
    this.jdField_b_of_type_Apnu = ((apnu)this.app.getManager(363));
    this.cPw = false;
    this.arJ = this.app.a().e(this.sessionInfo.aTl, this.sessionInfo.cZ);
    this.aOr = this.app.a().A(this.sessionInfo.aTl, this.sessionInfo.cZ);
    if (QLog.isColorLevel()) {
      QLog.d("Navigate.TroopAioMsgNavigateBar", 2, "onInit: troopUin = " + this.sessionInfo.aTl + ", uinType = " + this.sessionInfo.cZ + ", mUnreadCount = " + this.aOr + ", mTroopLastReadSeq:" + this.arJ);
    }
    if (!((HotChatManager)this.app.getManager(60)).kj(this.sessionInfo.aTl)) {
      this.jdField_b_of_type_Apnu.a(this.sessionInfo.aTl, this.sessionInfo.cZ, 1, this.arJ, this.arJ, "", 0, null);
    }
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    ((Activity)this.context).getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
    this.mScreenHeight = localDisplayMetrics.heightPixels;
    this.dSI = ((int)this.context.getResources().getDimension(2131298391));
    this.aT = new TranslateAnimation(2, 1.0F, 2, 0.0F, 2, 0.0F, 2, 0.0F);
    this.X = new TranslateAnimation(2, 0.0F, 2, 1.0F, 2, 0.0F, 2, 0.0F);
    this.aT.setDuration(500L);
    this.X.setDuration(500L);
    this.aT.setAnimationListener(this);
    this.X.setAnimationListener(this);
    this.aV = new RotateAnimation(0.0F, 180.0F, 1, 0.5F, 1, 0.5F);
    this.aV.setDuration(500L);
    this.aV.setFillAfter(true);
    this.jdField_a_of_type_Apmt = new apmv(this.app, this.context, this, this.sessionInfo);
  }
  
  public void onScroll()
  {
    if ((this.Ij != null) && (this.Ik.getVisibility() == 0))
    {
      Object localObject = (apab.a)this.Ij.getTag();
      if (localObject != null)
      {
        long l2 = ((apab.a)localObject).shmsgseq;
        long l1 = l2;
        if (((apab.a)localObject).uniseq != 0L)
        {
          localObject = this.app.b().a(this.sessionInfo.aTl, this.sessionInfo.cZ, ((apab.a)localObject).uniseq);
          l1 = l2;
          if (localObject != null) {
            l1 = ((MessageRecord)localObject).shmsgseq;
          }
        }
        if (l1 > 0L)
        {
          int i = this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.getFirstVisiblePosition();
          localObject = (ChatMessage)this.jdField_a_of_type_Wki.getItem(i);
          if ((localObject != null) && (((ChatMessage)localObject).shmsgseq <= l1)) {
            dYu();
          }
        }
      }
    }
  }
  
  static class a
    implements Comparator<Long>
  {
    public int compare(Long paramLong1, Long paramLong2)
    {
      int i = 0;
      if (paramLong1.longValue() - paramLong2.longValue() > 0L) {
        i = 1;
      }
      while (paramLong1.longValue() - paramLong2.longValue() >= 0L) {
        return i;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apmz
 * JD-Core Version:    0.7.0.1
 */