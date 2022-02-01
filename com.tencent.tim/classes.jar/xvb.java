import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory;
import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory.RedPacketInfo;
import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory.c;
import com.tencent.mobileqq.activity.qwallet.redpacket.IRedPacket;
import com.tencent.mobileqq.activity.qwallet.redpacket.RedPacketManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.QQWalletRedPacketMsg;
import com.tencent.mobileqq.data.QQWalletTransferMsgElem;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.widget.AnimationView;
import com.tencent.mobileqq.widget.AnimationView.Player;
import com.tencent.mobileqq.widget.RoundImageView;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.QWalletPicHelper;
import java.util.Map;

public class xvb
  implements xvg
{
  protected long JE = aqgz.hK();
  protected CustomizeStrategyFactory.RedPacketInfo a;
  protected CustomizeStrategyFactory.c a;
  public MessageForQQWalletMsg a;
  public QQWalletRedPacketMsg a;
  public xvt a;
  protected QQAppInterface app;
  protected CustomizeStrategyFactory.RedPacketInfo b;
  protected int bXA;
  protected int bXB;
  protected int bXC;
  protected int bXD;
  protected int bXE;
  protected int bXF = 2130848111;
  protected int bXG;
  protected int bXy;
  protected int bXz;
  protected boolean bka;
  boolean bkb;
  protected Context context;
  protected int effectsId;
  public QQWalletTransferMsgElem elem;
  protected int skinId;
  
  public xvb(QQAppInterface paramQQAppInterface, xvt paramxvt, QQWalletTransferMsgElem paramQQWalletTransferMsgElem, int paramInt, CustomizeStrategyFactory.c paramc)
  {
    this.app = paramQQAppInterface;
    this.jdField_a_of_type_Xvt = paramxvt;
    this.context = paramxvt.layout.getContext();
    this.elem = paramQQWalletTransferMsgElem;
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg = ((MessageForQQWalletMsg)paramxvt.mMessage);
    this.jdField_a_of_type_ComTencentMobileqqDataQQWalletRedPacketMsg = this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg;
    this.bXG = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCustomizeStrategyFactory$c = paramc;
    float f = this.context.getResources().getDisplayMetrics().density;
    this.bXy = ((int)(160.0F * f + 0.5F));
    this.bXz = ((int)(240.0F * f + 0.5F));
    this.bXA = ((int)(90.0F * f + 0.5F));
    this.bXB = ((int)(17.0F * f + 0.5F));
    this.bXC = ((int)(40.0F * f + 0.5F));
    this.bXE = ((int)(f * 24.0F + 0.5F));
    this.bXD = (this.bXy - this.bXB);
    this.skinId = paramQQWalletTransferMsgElem.skinId;
    this.effectsId = paramQQWalletTransferMsgElem.effectsId;
    this.bkb = SU();
    if (this.bkb) {
      this.effectsId = 0;
    }
    this.bka = RedPacketManager.getInstance().isRiskSwitchOpen();
    if (QLog.isColorLevel()) {
      QLog.d("BaseViewHolder", 2, "isRedPacketOpened=" + this.bkb + ",isRiskWritchOpen=" + this.bka + ",skinId=" + this.skinId + ",effectsId=" + this.effectsId + ",elem=" + paramQQWalletTransferMsgElem + ",qqWalletMsg=" + this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg);
    }
  }
  
  protected boolean SS()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCustomizeStrategyFactory$RedPacketInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCustomizeStrategyFactory$RedPacketInfo.icon != null))
    {
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(this.bXC, this.bXC);
      localLayoutParams.gravity = 17;
      ImageView localImageView = new ImageView(this.context);
      localImageView.setImageBitmap(this.jdField_a_of_type_ComTencentMobileqqActivityAioCustomizeStrategyFactory$RedPacketInfo.icon);
      this.jdField_a_of_type_Xvt.hk.addView(localImageView, localLayoutParams);
      return true;
    }
    return false;
  }
  
  public boolean ST()
  {
    if ((this.jdField_a_of_type_Xvt == null) || (this.jdField_a_of_type_Xvt.Kv == null)) {
      return false;
    }
    this.jdField_a_of_type_Xvt.Kv.setVisibility(0);
    this.jdField_a_of_type_Xvt.Kv.setTextColor(-8947849);
    this.jdField_a_of_type_Xvt.Kv.setTag(null);
    if (!this.bka) {}
    this.jdField_a_of_type_Xvt.Kv.setText("QQ红包");
    return false;
  }
  
  protected boolean SU()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg == null) || (this.jdField_a_of_type_ComTencentMobileqqDataQQWalletRedPacketMsg == null)) {}
    while ((this.jdField_a_of_type_ComTencentMobileqqDataQQWalletRedPacketMsg.isOpened) || ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.istroop == 1) && (aaca.a(2, this.jdField_a_of_type_ComTencentMobileqqDataQQWalletRedPacketMsg.redPacketId, this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg) != null))) {
      return true;
    }
    return false;
  }
  
  protected boolean a(zxi paramzxi)
  {
    boolean bool2 = false;
    boolean bool1;
    if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg == null) || (this.jdField_a_of_type_ComTencentMobileqqDataQQWalletRedPacketMsg == null)) {
      bool1 = true;
    }
    do
    {
      do
      {
        do
        {
          return bool1;
          bool1 = bool2;
        } while (paramzxi == null);
        if (paramzxi.isOpen) {
          return true;
        }
        bool1 = bool2;
      } while (this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.istroop != 1);
      bool1 = bool2;
    } while (aaca.a(2, paramzxi.redBagId, this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg) == null);
    return true;
  }
  
  public void cfi()
  {
    if ((this.jdField_a_of_type_Xvt == null) || (this.jdField_a_of_type_Xvt.hU == null)) {}
    label641:
    label644:
    for (;;)
    {
      return;
      Object localObject2;
      long l1;
      try
      {
        Object localObject1 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_Xvt.hU.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject1).width = this.bXy;
        ((RelativeLayout.LayoutParams)localObject1).height = this.bXz;
        localObject2 = this.jdField_a_of_type_Xvt.hU.getChildAt(0);
        localObject1 = BaseApplicationImpl.getApplication().getApplicationContext().getResources().getDrawable(2130848102);
        long l2 = 0L;
        if (!(localObject2 instanceof RoundImageView)) {
          break label390;
        }
        localObject2 = (RoundImageView)localObject2;
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCustomizeStrategyFactory$RedPacketInfo == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCustomizeStrategyFactory$RedPacketInfo.background == null)) {
          break label358;
        }
        ((RoundImageView)localObject2).setmRadius(0, false);
        ((RoundImageView)localObject2).setImageDrawable(QWalletPicHelper.getDrawableForAIO(this.jdField_a_of_type_ComTencentMobileqqActivityAioCustomizeStrategyFactory$RedPacketInfo.background, (Drawable)localObject1));
        l1 = l2;
        if (xlr.hN != null)
        {
          l1 = l2;
          if (!xlr.hN.isEmpty())
          {
            l1 = l2;
            if (xlr.hN.containsKey(Integer.valueOf(this.skinId))) {
              l1 = ((Long)xlr.hN.get(Integer.valueOf(this.skinId))).longValue();
            }
          }
        }
        if ((NetConnInfoCenter.getServerTimeMillis() - l1 <= 500L) || (this.skinId <= 0) || ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.messageType != 2) && (this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.messageType != 3))) {
          continue;
        }
        anot.a(this.app, "P_CliOper", "Vip_pay_mywallet", "", "wallet", "wrap.aio.show", 0, 0, "" + this.skinId, "", "", "");
        xlr.hN.put(this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg, Long.valueOf(NetConnInfoCenter.getServerTimeMillis()));
        return;
      }
      catch (Throwable localThrowable) {}
      if (QLog.isColorLevel())
      {
        QLog.e("BaseViewHolder", 1, "handleBackgroud throw exception: " + localThrowable.getLocalizedMessage());
        return;
        label358:
        if (Build.VERSION.SDK_INT >= 18) {
          ((RoundImageView)localObject2).setmRadius(rpq.dip2px(this.context, 4.0F), false);
        }
        ((RoundImageView)localObject2).setImageDrawable(localThrowable);
        return;
        label390:
        Drawable localDrawable;
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCustomizeStrategyFactory$RedPacketInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCustomizeStrategyFactory$RedPacketInfo.background != null))
        {
          localDrawable = QWalletPicHelper.getDrawableForAIO(this.jdField_a_of_type_ComTencentMobileqqActivityAioCustomizeStrategyFactory$RedPacketInfo.background, localThrowable);
          if (Build.VERSION.SDK_INT < 16)
          {
            this.jdField_a_of_type_Xvt.hU.setBackgroundDrawable(localDrawable);
            if ((xlr.hN == null) || (xlr.hN.isEmpty()) || (!xlr.hN.containsKey(Integer.valueOf(this.skinId)))) {
              break label641;
            }
          }
        }
        for (l1 = ((Long)xlr.hN.get(this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg)).longValue();; l1 = 0L)
        {
          if ((NetConnInfoCenter.getServerTimeMillis() - l1 <= 500L) || (this.skinId <= 0) || ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.messageType != 2) && (this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.messageType != 3))) {
            break label644;
          }
          anot.a(this.app, "P_CliOper", "Vip_pay_mywallet", "", "wallet", "wrap.aio.show", 0, 0, "" + this.skinId, "", "", "");
          xlr.hN.put(this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg, Long.valueOf(NetConnInfoCenter.getServerTimeMillis()));
          return;
          this.jdField_a_of_type_Xvt.hU.setBackground(localDrawable);
          break;
          this.jdField_a_of_type_Xvt.hU.setBackgroundResource(2130848102);
          return;
        }
      }
    }
  }
  
  public void cfj()
  {
    if ((this.jdField_a_of_type_Xvt == null) || (this.jdField_a_of_type_Xvt.hX == null)) {}
    while (this.jdField_a_of_type_Xvt.hX.getChildCount() == 0) {
      return;
    }
    this.jdField_a_of_type_Xvt.hX.removeAllViews();
  }
  
  protected void cfk()
  {
    if ((this.jdField_a_of_type_Xvt == null) || (this.jdField_a_of_type_Xvt.hk == null)) {}
    do
    {
      return;
      this.jdField_a_of_type_Xvt.hk.setVisibility(0);
      ((RelativeLayout.LayoutParams)this.jdField_a_of_type_Xvt.hk.getLayoutParams()).topMargin = this.bXC;
    } while (this.jdField_a_of_type_Xvt.hk.getChildCount() == 0);
    this.jdField_a_of_type_Xvt.hk.removeAllViews();
  }
  
  public void cfl()
  {
    cfk();
    if (!SS())
    {
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(this.bXC, this.bXC);
      localLayoutParams.gravity = 17;
      ImageView localImageView = new ImageView(this.context);
      localImageView.setImageResource(this.bXF);
      this.jdField_a_of_type_Xvt.hk.addView(localImageView, localLayoutParams);
    }
  }
  
  public void cfm()
  {
    if ((this.jdField_a_of_type_Xvt == null) || (this.jdField_a_of_type_Xvt.title == null)) {
      return;
    }
    this.jdField_a_of_type_Xvt.title.setVisibility(0);
    if ((this.elem != null) && (!TextUtils.isEmpty(this.elem.title)))
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCustomizeStrategyFactory$RedPacketInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCustomizeStrategyFactory$RedPacketInfo.isHideTitle == 1) && (!this.bka))
      {
        this.jdField_a_of_type_Xvt.title.setText("");
        return;
      }
      int j = aqmr.getWordCount(this.elem.title);
      int i = 18;
      if (j <= 8)
      {
        j = this.bXD / 4;
        i = j;
        if (j > this.bXE) {
          i = this.bXE;
        }
        i = aqcx.px2dip(this.context, i);
      }
      this.jdField_a_of_type_Xvt.title.setTextSize(i);
      this.jdField_a_of_type_Xvt.title.setText(this.elem.title);
      return;
    }
    this.jdField_a_of_type_Xvt.title.setText("");
  }
  
  public void cfn()
  {
    if ((this.jdField_a_of_type_Xvt == null) || (this.jdField_a_of_type_Xvt.b == null) || (this.jdField_a_of_type_Xvt.c == null)) {}
    do
    {
      return;
      this.jdField_a_of_type_Xvt.b.stop();
      this.jdField_a_of_type_Xvt.c.stop();
      if (this.jdField_a_of_type_Xvt.tS != null) {
        this.jdField_a_of_type_Xvt.tS.setVisibility(8);
      }
      this.jdField_a_of_type_Xvt.b.setVisibility(8);
      this.jdField_a_of_type_Xvt.c.setVisibility(8);
      AnimationView.Player localPlayer = this.jdField_a_of_type_Xvt.b.getPlayer();
      if ((localPlayer instanceof xvu)) {
        ((xvu)localPlayer).a(this.jdField_a_of_type_Xvt.b);
      }
      localPlayer = this.jdField_a_of_type_Xvt.c.getPlayer();
      if ((localPlayer instanceof xvu)) {
        ((xvu)localPlayer).a(this.jdField_a_of_type_Xvt.c);
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCustomizeStrategyFactory$RedPacketInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCustomizeStrategyFactory$RedPacketInfo.animInfo != null))
      {
        this.jdField_a_of_type_Xvt.b.setVisibility(0);
        this.jdField_a_of_type_Xvt.b.setAnimationFromInfo(this.jdField_a_of_type_ComTencentMobileqqActivityAioCustomizeStrategyFactory$RedPacketInfo.animInfo);
        this.jdField_a_of_type_Xvt.b.play();
      }
    } while ((this.b == null) || (this.b.specailBackgroundAnimInfo == null));
    this.jdField_a_of_type_Xvt.c.setVisibility(0);
    this.jdField_a_of_type_Xvt.c.setAnimationFromInfo(this.b.specailBackgroundAnimInfo);
    this.jdField_a_of_type_Xvt.c.play();
  }
  
  public void cfo()
  {
    if ((this.jdField_a_of_type_Xvt == null) || (this.jdField_a_of_type_Xvt.hW == null)) {}
    do
    {
      return;
      this.jdField_a_of_type_Xvt.hW.setVisibility(8);
    } while (this.jdField_a_of_type_Xvt.hW.getChildCount() <= 0);
    this.jdField_a_of_type_Xvt.hW.removeAllViews();
  }
  
  public void onCreate()
  {
    if (this.bka)
    {
      this.skinId = 0;
      this.effectsId = 0;
    }
    do
    {
      return;
      if (this.skinId > 0)
      {
        localRedPacketInfo = new CustomizeStrategyFactory.RedPacketInfo();
        localRedPacketInfo.h = this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg;
        localRedPacketInfo.type = 5;
        localRedPacketInfo.skinId = this.skinId;
        localRedPacketInfo.skinType = 1;
        localRedPacketInfo.isHideTitle = this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.getIsHideTitleDefault();
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCustomizeStrategyFactory$RedPacketInfo = CustomizeStrategyFactory.a().a(this.app, localRedPacketInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioCustomizeStrategyFactory$c);
      }
    } while ((this.effectsId <= 0) || (this.JE <= 720L));
    CustomizeStrategyFactory.RedPacketInfo localRedPacketInfo = new CustomizeStrategyFactory.RedPacketInfo();
    localRedPacketInfo.beginTime = System.currentTimeMillis();
    localRedPacketInfo.h = this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg;
    localRedPacketInfo.type = 5;
    localRedPacketInfo.bigAnimId = this.effectsId;
    localRedPacketInfo.skinType = 3;
    this.b = CustomizeStrategyFactory.a().a(this.app, localRedPacketInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioCustomizeStrategyFactory$c);
  }
  
  public void onResume()
  {
    if ((this.jdField_a_of_type_Xvt == null) || (this.jdField_a_of_type_Xvt.hV == null)) {
      return;
    }
    if (!SU())
    {
      this.jdField_a_of_type_Xvt.hV.setVisibility(8);
      return;
    }
    this.jdField_a_of_type_Xvt.hV.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xvb
 * JD-Core Version:    0.7.0.1
 */