import Wallet.RedPackGrapInfo;
import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory.RedPacketInfo;
import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory.c;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.qwallet.TroopUnAccalimedRedPacketList.a;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.QQWalletAioBodyReserve;
import com.tencent.mobileqq.data.QQWalletRedPacketMsg;
import com.tencent.mobileqq.data.QQWalletTransferMsgElem;
import com.tencent.qphone.base.util.QLog;

public class xlw
  implements CustomizeStrategyFactory.c
{
  RedPackGrapInfo jdField_a_of_type_WalletRedPackGrapInfo;
  MessageForQQWalletMsg jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg = null;
  xvk jdField_a_of_type_Xvk;
  xvt jdField_a_of_type_Xvt;
  public QQAppInterface app;
  int bVc;
  public Context context;
  aqdf d;
  BaseChatPie e;
  SessionInfo sessionInfo;
  
  public xlw(QQAppInterface paramQQAppInterface, Context paramContext, String paramString, int paramInt, BaseChatPie paramBaseChatPie)
  {
    this.app = paramQQAppInterface;
    this.context = paramContext;
    this.e = paramBaseChatPie;
    this.d = new aqdf(paramQQAppInterface);
    this.jdField_a_of_type_Xvk = new xvk(paramContext);
    this.sessionInfo = new SessionInfo();
    this.sessionInfo.aTl = paramString;
    this.sessionInfo.cZ = paramInt;
  }
  
  public FrameLayout.LayoutParams a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(paramInt1, paramInt2);
    localLayoutParams.gravity = 48;
    localLayoutParams.leftMargin = paramInt3;
    localLayoutParams.topMargin = paramInt4;
    return localLayoutParams;
  }
  
  public FrameLayout a(LinearLayout paramLinearLayout)
  {
    if ((paramLinearLayout == null) || (this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg == null)) {
      return null;
    }
    this.jdField_a_of_type_Xvt = new xvt();
    this.jdField_a_of_type_Xvt.mMessage = this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg;
    this.jdField_a_of_type_Xvt.layout = this.jdField_a_of_type_Xvk.b(this.jdField_a_of_type_Xvt, this.context);
    this.jdField_a_of_type_Xvt.layout.setTag(this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg);
    Object localObject1 = paramLinearLayout.findViewById(2131375427);
    if (QLog.isColorLevel()) {
      QLog.d("TroopUnAccalimedRedPacketList", 2, new Object[] { Boolean.valueOf(localObject1 instanceof RelativeLayout) });
    }
    float f = this.context.getResources().getDisplayMetrics().density;
    int i = (int)(173.0F * f + 0.5F);
    int j = (int)(255.0F * f + 0.5F);
    int k = (int)(6.5F * f + 0.5F);
    int m = (int)(f * 7.5F + 0.5F);
    Object localObject2;
    if (localObject1 == null)
    {
      localObject2 = new FrameLayout(this.context);
      this.jdField_a_of_type_Xvt.layout = this.jdField_a_of_type_Xvk.b(this.jdField_a_of_type_Xvt, this.context);
      this.jdField_a_of_type_Xvt.layout.setTag(this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg);
      ((FrameLayout)localObject2).addView(this.jdField_a_of_type_Xvt.layout, a(i, j, k, m));
      View localView = paramLinearLayout.findViewById(2131375456);
      localObject1 = localObject2;
      if (this.jdField_a_of_type_Xvt.c != null)
      {
        localObject1 = new RelativeLayout.LayoutParams(i, j);
        if (localView == null) {
          break label305;
        }
        localView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        paramLinearLayout.addView((View)localObject2, -1, -1);
        localObject1 = localObject2;
      }
    }
    for (;;)
    {
      a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg);
      return localObject1;
      label305:
      ((FrameLayout)localObject2).addView(this.jdField_a_of_type_Xvt.c, (ViewGroup.LayoutParams)localObject1);
      break;
      localObject1 = ((View)localObject1).getParent();
      if ((localObject1 instanceof FrameLayout))
      {
        localObject1 = (FrameLayout)localObject1;
        ((FrameLayout)localObject1).removeAllViews();
        this.jdField_a_of_type_Xvt.layout = this.jdField_a_of_type_Xvk.b(this.jdField_a_of_type_Xvt, this.context);
        this.jdField_a_of_type_Xvt.layout.setTag(this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg);
        ((FrameLayout)localObject1).addView(this.jdField_a_of_type_Xvt.layout, a(i, j, k, m));
        localObject2 = new RelativeLayout.LayoutParams(i, j);
        paramLinearLayout = paramLinearLayout.findViewById(2131375456);
        if (paramLinearLayout != null) {
          paramLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        } else {
          ((FrameLayout)localObject1).addView(this.jdField_a_of_type_Xvt.c, (ViewGroup.LayoutParams)localObject2);
        }
      }
      else
      {
        localObject1 = null;
      }
    }
  }
  
  public void a(RedPackGrapInfo paramRedPackGrapInfo)
  {
    this.jdField_a_of_type_WalletRedPackGrapInfo = paramRedPackGrapInfo;
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg = new MessageForQQWalletMsg();
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.frienduin = this.sessionInfo.aTl;
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.senderuin = (paramRedPackGrapInfo.lUin + "");
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.messageType = paramRedPackGrapInfo.iMsgType;
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg = new QQWalletRedPacketMsg();
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.redPacketId = paramRedPackGrapInfo.sBiilNo;
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.authkey = paramRedPackGrapInfo.sAuthKey;
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.redtype = paramRedPackGrapInfo.iRedType;
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.redChannel = paramRedPackGrapInfo.iRedChannel;
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.envelopeid = paramRedPackGrapInfo.iEnvelopeId;
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.envelopeid = 0;
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.envelopeName = paramRedPackGrapInfo.sName;
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.specifyUinList = paramRedPackGrapInfo.vecGrapUin;
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem = new QQWalletTransferMsgElem();
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem.title = paramRedPackGrapInfo.sTitle;
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem.themeId = paramRedPackGrapInfo.iSubjectId;
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem.resourceType = paramRedPackGrapInfo.iResourceType;
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem.skinId = paramRedPackGrapInfo.iSkinId;
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem.effectsId = paramRedPackGrapInfo.iEffectsId;
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem.skinId = 0;
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem.effectsId = 0;
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem.special_pop_id = paramRedPackGrapInfo.iSpecialPopId;
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem.soundRecordDuration = paramRedPackGrapInfo.iSoundRecordDuration;
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem.content = paramRedPackGrapInfo.sContent;
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem.actionsPriority = "3|2|1";
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem.nativeAndroid = ("red?id=" + paramRedPackGrapInfo.sBiilNo);
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem.songId = paramRedPackGrapInfo.iSongId;
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem.songFlag = paramRedPackGrapInfo.iSongFlag;
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem.lastPinyin = paramRedPackGrapInfo.hbIdiomLastPY;
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.body = new QQWalletAioBodyReserve(paramRedPackGrapInfo.sReserve);
    if (this.sessionInfo.aTl.equals(paramRedPackGrapInfo.lUin + "")) {
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.issend = 1;
    }
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.istroop = this.sessionInfo.cZ;
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.messageType != 6) {
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.fromHBList = 1;
    }
    this.bVc = xvz.fm(paramRedPackGrapInfo.iMsgType);
    if ((this.bVc == 4) && (paramRedPackGrapInfo.iSkinId > 0)) {
      this.bVc = 0;
    }
  }
  
  public void a(MessageForQQWalletMsg paramMessageForQQWalletMsg)
  {
    int i = xvz.fm(paramMessageForQQWalletMsg.messageType);
    paramMessageForQQWalletMsg = xvz.a(this.app, this.jdField_a_of_type_Xvt, paramMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem, i, this);
    if ((paramMessageForQQWalletMsg instanceof xvw)) {
      ((xvw)paramMessageForQQWalletMsg).a(new aqdf(this.app));
    }
    try
    {
      paramMessageForQQWalletMsg.onCreate();
      paramMessageForQQWalletMsg.cfl();
      paramMessageForQQWalletMsg.cfm();
      paramMessageForQQWalletMsg.cfi();
      paramMessageForQQWalletMsg.cfn();
      paramMessageForQQWalletMsg.onResume();
      return;
    }
    catch (Throwable paramMessageForQQWalletMsg) {}
  }
  
  public boolean a(FrameLayout paramFrameLayout, RedPackGrapInfo paramRedPackGrapInfo, TroopUnAccalimedRedPacketList.a parama)
  {
    if (paramFrameLayout == null) {
      return false;
    }
    this.jdField_a_of_type_Xvk.a(parama);
    paramFrameLayout = (RelativeLayout)paramFrameLayout.findViewById(2131375427);
    if (paramFrameLayout == null) {
      return false;
    }
    if ((MessageForQQWalletMsg)paramFrameLayout.getTag() == null) {
      return false;
    }
    if (this.context != null) {
      this.context.getString(2131717318);
    }
    return this.jdField_a_of_type_Xvk.a(this.app, this.e, paramFrameLayout, this.sessionInfo, this.bVc, paramRedPackGrapInfo.iSkinId, "");
  }
  
  public void onSucc(int paramInt, CustomizeStrategyFactory.RedPacketInfo paramRedPacketInfo)
  {
    MessageForQQWalletMsg localMessageForQQWalletMsg;
    if ((paramRedPacketInfo != null) && ((paramRedPacketInfo.h instanceof MessageForQQWalletMsg)))
    {
      localMessageForQQWalletMsg = (MessageForQQWalletMsg)paramRedPacketInfo.h;
      switch (paramInt)
      {
      }
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            if (paramRedPacketInfo.skinType == 1) {
              a(localMessageForQQWalletMsg);
            }
          } while ((paramRedPacketInfo.skinType != 3) || (paramRedPacketInfo.specailBackgroundAnimInfo == null));
          a(localMessageForQQWalletMsg);
          return;
        } while (paramRedPacketInfo.animInfo == null);
        a(localMessageForQQWalletMsg);
        return;
      } while (paramRedPacketInfo.background == null);
      a(localMessageForQQWalletMsg);
      return;
    } while ((!paramRedPacketInfo.Rs()) && (paramRedPacketInfo.dv == null));
    a(localMessageForQQWalletMsg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xlw
 * JD-Core Version:    0.7.0.1
 */