import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout;
import com.tencent.mobileqq.activity.aio.rebuild.CmGameChatPie.10;
import com.tencent.mobileqq.activity.aio.rebuild.CmGameChatPie.12;
import com.tencent.mobileqq.activity.aio.rebuild.CmGameChatPie.14;
import com.tencent.mobileqq.activity.aio.rebuild.CmGameChatPie.15;
import com.tencent.mobileqq.activity.aio.rebuild.CmGameChatPie.16;
import com.tencent.mobileqq.activity.aio.rebuild.CmGameChatPie.7;
import com.tencent.mobileqq.activity.aio.rebuild.CmGameChatPie.8;
import com.tencent.mobileqq.activity.aio.rebuild.CmGameChatPie.ChatPieMsgListener.1;
import com.tencent.mobileqq.activity.aio.rebuild.CmGameChatPie.ChatPieMsgListener.10;
import com.tencent.mobileqq.activity.aio.rebuild.CmGameChatPie.ChatPieMsgListener.11;
import com.tencent.mobileqq.activity.aio.rebuild.CmGameChatPie.ChatPieMsgListener.12;
import com.tencent.mobileqq.activity.aio.rebuild.CmGameChatPie.ChatPieMsgListener.2;
import com.tencent.mobileqq.activity.aio.rebuild.CmGameChatPie.ChatPieMsgListener.3;
import com.tencent.mobileqq.activity.aio.rebuild.CmGameChatPie.ChatPieMsgListener.4;
import com.tencent.mobileqq.activity.aio.rebuild.CmGameChatPie.ChatPieMsgListener.5;
import com.tencent.mobileqq.activity.aio.rebuild.CmGameChatPie.ChatPieMsgListener.6;
import com.tencent.mobileqq.activity.aio.rebuild.CmGameChatPie.ChatPieMsgListener.7;
import com.tencent.mobileqq.activity.aio.rebuild.CmGameChatPie.ChatPieMsgListener.8;
import com.tencent.mobileqq.activity.aio.rebuild.CmGameChatPie.ChatPieMsgListener.9;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.StartCheckParam;
import com.tencent.mobileqq.apollo.lightGame.DotPollingView;
import com.tencent.mobileqq.apollo.lightGame.QuickInputTipsBar;
import com.tencent.mobileqq.apollo.lightGame.QuickInputTipsBar.a;
import com.tencent.mobileqq.apollo.lightGame.QuickInputTipsBar.b;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.apollo.view.ApolloPanel;
import com.tencent.mobileqq.apollo.view.ApolloPanel.b;
import com.tencent.mobileqq.apollo.view.FrameGifView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.ApolloActionData;
import com.tencent.mobileqq.data.ApolloGameData;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForApollo;
import com.tencent.mobileqq.data.MessageForCmGameTips;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.profile.PersonalityLabel.CornerImageView;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mqq.shared_file_accessor.SharedPreferencesProxyManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XPanelContainer;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Random;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

public class xxh
  extends BaseChatPie
  implements QuickInputTipsBar.a
{
  public static boolean bkr;
  private TextView KA;
  private TextView KB;
  private TextView KC;
  private TextView KD;
  private TextView KE;
  private TextView Ky;
  private TextView Kz;
  private aqju S;
  private aqju T;
  private abmf jdField_a_of_type_Abmf;
  protected achq a;
  private DotPollingView jdField_a_of_type_ComTencentMobileqqApolloLightGameDotPollingView;
  private QuickInputTipsBar jdField_a_of_type_ComTencentMobileqqApolloLightGameQuickInputTipsBar;
  private FrameGifView jdField_a_of_type_ComTencentMobileqqApolloViewFrameGifView;
  public MessageForCmGameTips a;
  private xxh.a jdField_a_of_type_Xxh$a;
  private xxh.b jdField_a_of_type_Xxh$b;
  private Handler.Callback jdField_b_of_type_AndroidOsHandler$Callback = new xxn(this);
  private FrameGifView jdField_b_of_type_ComTencentMobileqqApolloViewFrameGifView;
  private int bSO;
  private int bXN;
  private int bXO;
  private boolean bkl;
  public boolean bkm;
  private boolean bkn;
  private boolean bko;
  private boolean bkp;
  private boolean bkq;
  private boolean bks;
  private boolean bkt;
  private boolean bku;
  private boolean bkv;
  private boolean bkw;
  private boolean bkx;
  private RelativeLayout hY;
  private RelativeLayout hZ;
  private CornerImageView i;
  private RelativeLayout ia;
  private RelativeLayout ib;
  private TextView mC;
  private boolean mPaused;
  private boolean mShowing;
  private int mSrc = 319;
  private Handler mSubHandler = new auru(ThreadManager.getSubThreadLooper(), this.jdField_b_of_type_AndroidOsHandler$Callback);
  private List<ApolloGameData> sq;
  private ImageView tX;
  public View.OnClickListener x = new xxi(this);
  
  public xxh(QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, FragmentActivity paramFragmentActivity, Context paramContext)
  {
    super(paramQQAppInterface, paramViewGroup, paramFragmentActivity, paramContext);
    this.jdField_a_of_type_Achq = new xxk(this);
    ((abhh)paramQQAppInterface.getManager(153)).a().b(this);
  }
  
  private void DB(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      this.KB.setVisibility(0);
      this.KC.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqApolloLightGameDotPollingView.setVisibility(8);
      this.KD.setVisibility(8);
      this.KE.setVisibility(8);
      return;
    case 1: 
      this.KB.setVisibility(8);
      this.KC.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqApolloLightGameDotPollingView.setVisibility(0);
      this.KD.setVisibility(8);
      this.KE.setVisibility(8);
      return;
    }
    this.KB.setVisibility(8);
    this.KC.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqApolloLightGameDotPollingView.setVisibility(8);
    this.KD.setVisibility(0);
    this.KE.setVisibility(0);
  }
  
  private void K(List<QuickInputTipsBar.b> paramList, int paramInt)
  {
    if (paramList == null) {
      return;
    }
    int j = wja.dp2px(7.0F, a().getResources());
    if (aqgz.getDesity() <= 2.0F) {
      j = wja.dp2px(9.0F, a().getResources());
    }
    QuickInputTipsBar.b localb = abmi.a(paramInt);
    if (localb != null)
    {
      paramList.add(localb);
      return;
    }
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      localb = new QuickInputTipsBar.b();
      localb.mId = 1;
      localb.mText = acfp.m(2131704058);
      paramList.add(localb);
      return;
    case 7: 
      localb = new QuickInputTipsBar.b();
      localb.mId = 7;
      localb.mText = new aofk(aofy.fx(193), 3, j);
      paramList.add(localb);
      return;
    case 6: 
      localb = new QuickInputTipsBar.b();
      localb.mId = 6;
      localb.mText = acfp.m(2131704073);
      paramList.add(localb);
      return;
    case 5: 
      localb = new QuickInputTipsBar.b();
      localb.mId = 5;
      localb.mText = acfp.m(2131704068);
      paramList.add(localb);
      return;
    case 4: 
      localb = new QuickInputTipsBar.b();
      localb.mId = 4;
      localb.mText = new aofk(aofy.fx(209), 3, j);
      paramList.add(localb);
      return;
    case 3: 
      localb = new QuickInputTipsBar.b();
      localb.mId = 3;
      localb.mText = acfp.m(2131704066);
      paramList.add(localb);
      return;
    case 2: 
      localb = new QuickInputTipsBar.b();
      localb.mId = 2;
      localb.mText = new aofk(aofy.fx(192), 3, j);
      paramList.add(localb);
      return;
    }
    localb = new QuickInputTipsBar.b();
    localb.mId = 1;
    localb.mText = acfp.m(2131704057);
    paramList.add(localb);
  }
  
  private void R(String paramString, int paramInt1, int paramInt2)
  {
    this.bkw = true;
    if (paramInt1 == 0)
    {
      paramInt2 = (int)(System.currentTimeMillis() / 1000L - paramInt2);
      if (paramInt2 > 86400)
      {
        paramString = (int)Math.ceil(paramInt2 / 86400.0D) + acfp.m(2131704065);
        this.Cu.setText(paramString);
        zH(false);
        if (this.uiHandler != null) {
          this.uiHandler.removeMessages(16777215);
        }
        if (this.bko) {
          this.jdField_a_of_type_Wnc.bZM();
        }
        if (this.jdField_a_of_type_ComTencentMobileqqApolloLightGameQuickInputTipsBar != null)
        {
          this.fs.removeView(this.jdField_a_of_type_ComTencentMobileqqApolloLightGameQuickInputTipsBar);
          this.jdField_a_of_type_ComTencentMobileqqApolloLightGameQuickInputTipsBar = null;
        }
        this.bks = false;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 2, new Object[] { "updateUserStatus status:", Integer.valueOf(paramInt1) });
      }
      return;
      if (paramInt2 > 3600)
      {
        paramString = (int)Math.ceil(paramInt2 / 3600.0D) + acfp.m(2131704069);
        break;
      }
      paramString = (int)Math.ceil(paramInt2 / 60.0D) + acfp.m(2131704063);
      break;
      this.bks = true;
      this.Cu.setText(acfp.m(2131720456));
      if (this.uiHandler != null)
      {
        this.uiHandler.removeMessages(16777215);
        this.uiHandler.sendEmptyMessageDelayed(16777215, 500L);
      }
    }
  }
  
  private void a(String paramString, xxh.b paramb, int paramInt)
  {
    boolean bool;
    if (paramInt == 4)
    {
      bool = true;
      this.bkq = bool;
      this.bkv = true;
      if (this.uiHandler != null)
      {
        this.uiHandler.removeMessages(16777215);
        this.uiHandler.sendEmptyMessageDelayed(16777215, 500L);
      }
      if (this.ia == null) {
        break label69;
      }
      DB(paramInt);
    }
    label69:
    do
    {
      return;
      bool = false;
      break;
      if (paramb == null)
      {
        QLog.e(this.TAG, 1, "[updateFriendAndShield] info is null.");
        return;
      }
      this.jdField_a_of_type_Xxh$b = paramb;
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 2, "[updateFriendAndShield] friUin:" + paramString + ", " + paramb.toString());
      }
      l(this.sessionInfo.aTl, this.app.getCurrentUin(), this.sessionInfo.aTn, 0);
      if (this.mActivity.getIntent() != null)
      {
        paramString = this.mActivity.getIntent();
        bool = paramString.getBooleanExtra("key_show_one_more_page", false);
        if (QLog.isColorLevel()) {
          QLog.d(this.TAG, 2, new Object[] { "[updateFriendAndShield] show one more page:", Boolean.valueOf(bool) });
        }
        if (bool)
        {
          paramString = paramString.getStringExtra("key_req_data");
          w(ApolloUtil.z(paramString, "gameId"), ApolloUtil.z(paramString, "scoreState"), paramString);
        }
      }
      if ((!TextUtils.isEmpty(paramb.nickName)) && (this.mActivity != null) && (this.mActivity.getIntent() != null))
      {
        paramString = this.mActivity.getIntent().getStringExtra("uinname");
        if ((TextUtils.isEmpty(paramString)) && (this.mTitleText != null))
        {
          this.sessionInfo.aTn = paramString;
          this.mTitleText.setText(this.sessionInfo.aTn);
        }
      }
    } while (paramb.relationShip == 4);
    this.ia = ((RelativeLayout)LayoutInflater.from(this.mContext).inflate(2131558997, null));
    this.ia.setOnClickListener(this.x);
    this.i = ((CornerImageView)this.ia.findViewById(2131369645));
    this.mC = ((TextView)this.ia.findViewById(2131380814));
    this.KB = ((TextView)this.ia.findViewById(2131363769));
    this.KC = ((TextView)this.ia.findViewById(2131381030));
    this.jdField_a_of_type_ComTencentMobileqqApolloLightGameDotPollingView = ((DotPollingView)this.ia.findViewById(2131366115));
    this.KD = ((TextView)this.ia.findViewById(2131363768));
    this.KE = ((TextView)this.ia.findViewById(2131380898));
    this.tX = ((ImageView)this.ia.findViewById(2131369893));
    this.Ky = ((TextView)this.ia.findViewById(2131380552));
    this.ib = ((RelativeLayout)this.ia.findViewById(2131377431));
    this.Kz = ((TextView)this.ia.findViewById(2131380603));
    this.KA = ((TextView)this.ia.findViewById(2131380575));
    if ((paramb.age <= 0) && (TextUtils.isEmpty(paramb.city)) && (paramb.sex <= 0))
    {
      this.KA.setVisibility(0);
      label608:
      this.Ky.setText(paramb.age + acfp.m(2131704067));
      this.Kz.setText(paramb.city);
      this.i.setRadius(wja.dp2px(25.0F, this.mContext.getResources()));
      this.i.setImageURL(paramb.aWT);
      if (!TextUtils.isEmpty(paramb.nickName)) {
        break label1075;
      }
      this.mC.setText(paramb.uin);
      label705:
      this.KB.setBackgroundDrawable(abmh.a(this.mContext, wja.dp2px(80.0F, this.mContext.getResources()), wja.dp2px(30.0F, this.mContext.getResources()), "#000000"));
      this.KB.setTextColor(abmh.b(Color.parseColor("#ffec00"), Color.parseColor("#80ffec00")));
      this.KD.setBackgroundDrawable(abmh.a(this.mContext, wja.dp2px(60.0F, this.mContext.getResources()), wja.dp2px(23.0F, this.mContext.getResources()), "#000000"));
      this.KD.setTextColor(abmh.b(Color.parseColor("#ffec00"), Color.parseColor("#80ffec00")));
      this.KB.setOnClickListener(this.x);
      this.KD.setOnClickListener(this.x);
      DB(paramb.relationShip);
      paramString = new RelativeLayout.LayoutParams(-1, wja.dp2px(66.0F, this.mContext.getResources()));
      paramString.addRule(3, 2131377361);
      if (!this.aey) {
        break label1089;
      }
    }
    label1075:
    label1089:
    for (paramString.topMargin -= wja.dp2px(3.0F, this.app.getApplication().getResources());; paramString.topMargin = 0)
    {
      this.Kz.getViewTreeObserver().addOnPreDrawListener(new xxs(this, paramb));
      this.cL.addView(this.ia, paramString);
      if (((this.jdField_a_of_type_Wki.getList().size() != 0) && (!(this.jdField_a_of_type_Wki.getList().get(0) instanceof MessageForCmGameTips))) || (this.jdField_a_of_type_ComTencentMobileqqDataMessageForCmGameTips == null)) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForCmGameTips.needTopPadding = true;
      this.jdField_a_of_type_Wki.notifyDataSetChanged();
      return;
      if (paramb.age > 0) {
        this.Ky.setVisibility(0);
      }
      if (!TextUtils.isEmpty(paramb.city)) {
        this.ib.setVisibility(0);
      }
      if ((paramb.sex != 1) && (paramb.sex != 2)) {
        break label608;
      }
      this.tX.setVisibility(0);
      break label608;
      this.mC.setText(paramb.nickName);
      break label705;
    }
  }
  
  private void cfJ()
  {
    ThreadManagerV2.excute(new CmGameChatPie.8(this), 16, null, false);
  }
  
  private void cfK()
  {
    if ((this.sessionInfo != null) && (!TextUtils.isEmpty(this.sessionInfo.aTl)) && (new Random().nextBoolean()) && (abmk.gM(this.sessionInfo.aTl)))
    {
      abmi localabmi = ((abhh)this.app.getManager(153)).a();
      int j = (int)(System.currentTimeMillis() / 1000L);
      this.bSO = j;
      this.bXN = j;
      localabmi.gF(this.jdField_a_of_type_Abmf.gameId, this.bSO);
    }
  }
  
  private void cfL()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "checkTipsBarLayout");
    }
    if (this.bkt) {
      QLog.i(this.TAG, 1, "checkTipsBarLayout mQuickBarClickRemoved");
    }
    do
    {
      return;
      if ((!this.bkv) || (!this.bkw) || (!this.bku))
      {
        QLog.d(this.TAG, 1, new Object[] { "checkTipsBarLayout mMateStateChecked:", Boolean.valueOf(this.bkv), " mOnLineStateChecked:", Boolean.valueOf(this.bkw), " mAudioOnLineChecked:", Boolean.valueOf(this.bku) });
        return;
      }
      if (this.bks) {
        break;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqApolloLightGameQuickInputTipsBar != null)
      {
        this.fs.removeView(this.jdField_a_of_type_ComTencentMobileqqApolloLightGameQuickInputTipsBar);
        this.jdField_a_of_type_ComTencentMobileqqApolloLightGameQuickInputTipsBar = null;
      }
    } while (!QLog.isColorLevel());
    QLog.d(this.TAG, 2, "checkTipsBarLayout !mFriendOnLine");
    return;
    if (this.jdField_a_of_type_ComTencentMobileqqApolloLightGameQuickInputTipsBar == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqApolloLightGameQuickInputTipsBar = new QuickInputTipsBar(a(), null);
      localObject = new RelativeLayout.LayoutParams(-1, wja.dp2px(48.0F, a().getResources()));
      ((RelativeLayout.LayoutParams)localObject).addRule(2, 2131369277);
      this.fs.addView(this.jdField_a_of_type_ComTencentMobileqqApolloLightGameQuickInputTipsBar, (ViewGroup.LayoutParams)localObject);
      this.jdField_a_of_type_ComTencentMobileqqApolloLightGameQuickInputTipsBar.setTipsClickListener(this);
    }
    Object localObject = new ArrayList();
    QLog.d(this.TAG, 1, new Object[] { "checkTipsBarLayout mIsMate:", Boolean.valueOf(this.bkq), " mFriendAudioOnLine:", Boolean.valueOf(this.bkp), " sLaunchGameFromAIO:", Boolean.valueOf(bkr) });
    if (this.bkq) {
      if (this.bkp) {
        if (bkr)
        {
          K((List)localObject, 7);
          K((List)localObject, 5);
          K((List)localObject, 3);
        }
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqApolloLightGameQuickInputTipsBar.hY((List)localObject);
      this.jdField_a_of_type_Wnc.c(wja.dp2px(48.0F, this.mContext.getResources()), false, "cmGame_addFooter", 0);
      this.bko = true;
      return;
      K((List)localObject, 6);
      K((List)localObject, 4);
      K((List)localObject, 2);
      continue;
      if (bkr)
      {
        K((List)localObject, 7);
        K((List)localObject, 1);
        K((List)localObject, 3);
      }
      else
      {
        K((List)localObject, 6);
        K((List)localObject, 1);
        K((List)localObject, 2);
        continue;
        K((List)localObject, 0);
        if (this.bkp)
        {
          if (bkr)
          {
            K((List)localObject, 5);
            K((List)localObject, 3);
          }
          else
          {
            K((List)localObject, 4);
            K((List)localObject, 2);
          }
        }
        else
        {
          K((List)localObject, 1);
          if (bkr) {
            K((List)localObject, 3);
          } else {
            K((List)localObject, 2);
          }
        }
      }
    }
  }
  
  public void Ib()
  {
    this.TAG = "CmGameTemp_CmGameChatPie";
  }
  
  public boolean OL()
  {
    return !isFullScreenMode();
  }
  
  public boolean SY()
  {
    return this.mShowing;
  }
  
  public void V(int paramInt, long paramLong)
  {
    if ((this.sessionInfo == null) || (this.app == null)) {
      return;
    }
    ApolloPanel.b localb = new ApolloPanel.b();
    Object localObject = (abxk)this.app.getManager(155);
    String str = acfp.m(2131704070);
    ApolloGameData localApolloGameData = ((abxk)localObject).a(paramInt);
    if ((localApolloGameData != null) && (!TextUtils.isEmpty(localApolloGameData.name)))
    {
      localObject = ((abxk)localObject).a(localApolloGameData.actionId);
      if (localObject == null) {
        break label184;
      }
      str = ((ApolloActionData)localObject).actionName;
    }
    label184:
    for (;;)
    {
      int j = localApolloGameData.actionId;
      localb.gameName = localApolloGameData.name;
      for (;;)
      {
        localb.actionName = str;
        localb.actionId = j;
        localb.roomId = paramLong;
        localb.gameId = paramInt;
        localb.msgType = 3;
        localb.gameStatus = 0;
        abmh.a(this.app, this.sessionInfo.aTl, localb);
        return;
        localb.gameName = acfp.m(2131704064);
        j = 0;
      }
    }
  }
  
  public void a(abmi.d paramd)
  {
    if (paramd == null)
    {
      QLog.e(this.TAG, 1, "[addTopGame] gameMap is null.");
      return;
    }
    if ((paramd.sc.size() < 3) || (paramd.sc.size() % 3 != 0))
    {
      QLog.e(this.TAG, 1, "[addTopGame] game size is not a multiple of 3.");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 1, "[addTopGame] alreadyAdd:" + this.bkm);
    }
    List localList = this.jdField_a_of_type_Wki.getList();
    if (!this.bkm)
    {
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForCmGameTips = ((MessageForCmGameTips)anbi.d(-7004));
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForCmGameTips.msgtype = -7004;
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForCmGameTips.mIsParsed = true;
      if ((this.ia != null) && (localList.size() == 0)) {
        this.jdField_a_of_type_ComTencentMobileqqDataMessageForCmGameTips.needTopPadding = true;
      }
      anbi.a(this.app, this.jdField_a_of_type_ComTencentMobileqqDataMessageForCmGameTips, this.sessionInfo.aTl, "", 1036);
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForCmGameTips.gameInfo = paramd;
      this.app.b().a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForCmGameTips, this.app.getCurrentUin(), true, false, false, true);
      localList.add(this.jdField_a_of_type_ComTencentMobileqqDataMessageForCmGameTips);
      this.bkm = true;
    }
    ThreadManager.getUIHandler().post(new CmGameChatPie.10(this));
  }
  
  public void a(QuickInputTipsBar.b paramb)
  {
    if ((paramb != null) && (paramb.mText != null) && (!this.bkt))
    {
      ujt.e(this.app, this.mContext, this.sessionInfo, paramb.mText.toString());
      if (this.jdField_a_of_type_ComTencentMobileqqApolloLightGameQuickInputTipsBar != null) {
        this.jdField_a_of_type_ComTencentMobileqqApolloLightGameQuickInputTipsBar.cDn();
      }
      if (this.uiHandler != null)
      {
        this.uiHandler.removeMessages(16777216);
        this.uiHandler.sendEmptyMessageDelayed(16777216, 600L);
        this.bkt = true;
      }
      VipUtils.a(null, "cmshow", "Apollo", "quickMessage", 0, 0, new String[] { String.valueOf(paramb.mId) });
    }
  }
  
  public boolean af(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "[doOnCreate] chatPie:" + this + "," + this.bkl);
    }
    this.aSJ = false;
    this.bkl = true;
    Object localObject = (abhh)this.app.getManager(153);
    ((abhh)localObject).a().BX("page_tag_aio");
    ((abhh)localObject).a().es(this.app.getCurrentUin(), "join");
    localObject = this.mActivity.getIntent().getStringExtra("uin");
    Message localMessage = Message.obtain();
    localMessage.what = 1;
    localMessage.obj = localObject;
    this.mSubHandler.removeMessages(1);
    this.mSubHandler.sendMessage(localMessage);
    return super.af(paramBoolean);
  }
  
  public void bGL()
  {
    Object localObject = (abhh)this.app.getManager(153);
    abmi localabmi = ((abhh)localObject).a();
    localabmi.Y(this.sessionInfo.aTl, this.sessionInfo.cZ, 1);
    localabmi.Cb(this.sessionInfo.aTl);
    localObject = ((abhh)localObject).a();
    if ((ablz.bDL) && (!((ablz)localObject).Yz())) {
      ((ablz)localObject).dd(this.sessionInfo.aTl, 319);
    }
    if ((!TextUtils.isEmpty(((ablz)localObject).rc())) && (((ablz)localObject).rc().equals(this.sessionInfo.aTl))) {
      this.jdField_a_of_type_ComTencentMobileqqApolloViewFrameGifView.setImageResource(2130839445);
    }
    localabmi.df(this.sessionInfo.aTl, 319);
    localabmi.Cc(this.sessionInfo.aTl);
  }
  
  public void bGR()
  {
    super.bGR();
  }
  
  public void bHM()
  {
    super.bHM();
    this.aSc = false;
    vU(true);
    this.Cu.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
    this.cJ.setOnClickListener(null);
    this.cK.setOnClickListener(null);
  }
  
  public void bHZ()
  {
    super.bHZ();
    this.app.addDefaultObservers(this.jdField_a_of_type_Achq);
  }
  
  public void bIM()
  {
    super.bIM();
    this.mTitleText.setMaxEms(7);
    this.mTitleText.setEllipsize(TextUtils.TruncateAt.END);
    Object localObject;
    if (this.jdField_a_of_type_ComTencentMobileqqApolloViewFrameGifView == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqApolloViewFrameGifView = new FrameGifView(this.mContext);
      this.jdField_a_of_type_ComTencentMobileqqApolloViewFrameGifView.setImageResource(2130839443);
      this.jdField_a_of_type_ComTencentMobileqqApolloViewFrameGifView.setScaleType(ImageView.ScaleType.CENTER_CROP);
      this.jdField_a_of_type_ComTencentMobileqqApolloViewFrameGifView.setPlayLoop(true);
      this.jdField_a_of_type_ComTencentMobileqqApolloViewFrameGifView.setGifData(100, null, "https://cmshow.gtimg.cn/client/img/apollo_game_audio_micBig.zip", acbk.jb("https://cmshow.gtimg.cn/client/img/apollo_game_audio_micBig.zip"), false);
      this.jdField_a_of_type_ComTencentMobileqqApolloViewFrameGifView.setOnClickListener(new xxj(this));
      localObject = new RelativeLayout.LayoutParams(wja.dp2px(25.0F, this.mContext.getResources()), wja.dp2px(25.0F, this.mContext.getResources()));
      ((RelativeLayout.LayoutParams)localObject).addRule(15);
      this.gn.addView(this.jdField_a_of_type_ComTencentMobileqqApolloViewFrameGifView, (ViewGroup.LayoutParams)localObject);
    }
    if (this.jdField_b_of_type_ComTencentMobileqqApolloViewFrameGifView == null)
    {
      this.jdField_b_of_type_ComTencentMobileqqApolloViewFrameGifView = new FrameGifView(this.mContext);
      this.jdField_b_of_type_ComTencentMobileqqApolloViewFrameGifView.setImageResource(2130839444);
      this.jdField_b_of_type_ComTencentMobileqqApolloViewFrameGifView.setScaleType(ImageView.ScaleType.CENTER_CROP);
      this.jdField_b_of_type_ComTencentMobileqqApolloViewFrameGifView.setPlayLoop(true);
      this.jdField_b_of_type_ComTencentMobileqqApolloViewFrameGifView.setGifData(100, null, "https://cmshow.gtimg.cn/client/img/apollo_game_audio_micSmall.zip", acbk.jb("https://cmshow.gtimg.cn/client/img/apollo_game_audio_micSmall.zip"), false);
      localObject = new LinearLayout.LayoutParams(wja.dp2px(18.0F, this.mContext.getResources()), wja.dp2px(18.0F, this.mContext.getResources()));
      this.jdField_b_of_type_ComTencentMobileqqApolloViewFrameGifView.setPadding(0, 0, 5, 0);
      ((LinearLayout.LayoutParams)localObject).gravity = 16;
      ((ViewGroup)this.mTitleText.getParent()).addView(this.jdField_b_of_type_ComTencentMobileqqApolloViewFrameGifView, (ViewGroup.LayoutParams)localObject);
    }
    if (!ablz.bDM)
    {
      this.jdField_a_of_type_ComTencentMobileqqApolloViewFrameGifView.setVisibility(8);
      this.jdField_b_of_type_ComTencentMobileqqApolloViewFrameGifView.setVisibility(8);
    }
  }
  
  public void bIa()
  {
    super.bIa();
    this.app.removeObserver(this.jdField_a_of_type_Achq);
  }
  
  public void bp()
  {
    super.bp();
    int j = this.jdField_b_of_type_ComTencentWidgetXPanelContainer.vm();
    if ((this.jdField_b_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout != null) && (j == 21) && (this.sessionInfo.cZ == 1036)) {
      this.jdField_b_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setSelected(21);
    }
  }
  
  public void bs(Intent paramIntent)
  {
    super.bs(paramIntent);
    aqmq.track(null, "AIO_updateSession_business");
    if (this.jdField_a_of_type_Xxh$a == null) {
      this.jdField_a_of_type_Xxh$a = new xxh.a(this);
    }
    ((abhh)this.app.getManager(153)).a().a(this.jdField_a_of_type_Xxh$a);
    aqmq.track("AIO_updateSession_business", null);
    this.mShowing = true;
    cfJ();
  }
  
  public void bt(Intent paramIntent)
  {
    super.bt(paramIntent);
  }
  
  public List<ApolloGameData> cN()
  {
    if (this.sq == null) {
      return null;
    }
    return new ArrayList(this.sq);
  }
  
  public void cfM()
  {
    SharedPreferences localSharedPreferences = SharedPreferencesProxyManager.getInstance().getProxy("apollo_sp", 0);
    if (localSharedPreferences.getBoolean("apollo_audio_intro", true))
    {
      this.hZ = new RelativeLayout(a());
      this.hZ.setBackgroundColor(Color.parseColor("#cf000000"));
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
      ImageView localImageView = new ImageView(a());
      localImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
      localImageView.setId(2131362774);
      Object localObject1 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject1).mRequestWidth = wja.dp2px(200.0F, this.mContext.getResources());
      ((URLDrawable.URLDrawableOptions)localObject1).mRequestHeight = wja.dp2px(100.0F, this.mContext.getResources());
      Object localObject2 = URLDrawable.getDrawable("https://cmshow.gtimg.cn/client/img/cmgame_audio_intro_btn.png", (URLDrawable.URLDrawableOptions)localObject1);
      localImageView.setScaleType(ImageView.ScaleType.FIT_XY);
      localImageView.setImageDrawable((Drawable)localObject2);
      localImageView.setOnClickListener(this.x);
      localObject2 = new RelativeLayout.LayoutParams(wja.dp2px(35.0F, this.mContext.getResources()), wja.dp2px(35.0F, this.mContext.getResources()));
      ((RelativeLayout.LayoutParams)localObject2).addRule(11);
      ((RelativeLayout.LayoutParams)localObject2).addRule(10);
      ((RelativeLayout.LayoutParams)localObject2).setMargins(0, ImmersiveUtils.getStatusBarHeight(BaseApplicationImpl.getApplication()) + wja.dp2px(6.0F, this.mContext.getResources()), wja.dp2px(45.0F, this.mContext.getResources()), 0);
      this.hZ.addView(localImageView, (ViewGroup.LayoutParams)localObject2);
      localImageView = new ImageView(a());
      localObject2 = new RelativeLayout.LayoutParams(wja.dp2px(210.0F, this.mContext.getResources()), wja.dp2px(70.0F, this.mContext.getResources()));
      ((RelativeLayout.LayoutParams)localObject2).addRule(3, 2131362774);
      ((RelativeLayout.LayoutParams)localObject2).addRule(11);
      ((RelativeLayout.LayoutParams)localObject2).setMargins(0, 0, wja.dp2px(40.0F, this.mContext.getResources()), 0);
      localObject1 = URLDrawable.getDrawable("https://cmshow.gtimg.cn/client/img/cmgame_audio_intro_txt.png", (URLDrawable.URLDrawableOptions)localObject1);
      localImageView.setScaleType(ImageView.ScaleType.FIT_XY);
      localImageView.setImageDrawable((Drawable)localObject1);
      this.hZ.addView(localImageView, (ViewGroup.LayoutParams)localObject2);
      this.bkx = true;
      this.hZ.setOnClickListener(new xxl(this));
      ((FrameLayout)a().getWindow().getDecorView()).addView(this.hZ, localLayoutParams);
      QLog.i(this.TAG, 1, "[showOpenAudioIntro] already show audio intro.");
      localSharedPreferences.edit().putBoolean("apollo_audio_intro", false).commit();
    }
  }
  
  public void cfN()
  {
    if (this.bkx) {
      QLog.d(this.TAG, 1, "[showAddPlaymateIntro] isShow intro return.");
    }
    SharedPreferences localSharedPreferences;
    do
    {
      return;
      if (this.jdField_a_of_type_Xxh$b == null)
      {
        QLog.d(this.TAG, 1, "[showAddPlaymateIntro] friendInfo is null return.");
        return;
      }
      localSharedPreferences = SharedPreferencesProxyManager.getInstance().getProxy("apollo_sp", 0);
    } while ((!localSharedPreferences.getBoolean("apollo_add_playMate_intro", true)) || (this.jdField_a_of_type_Xxh$b.relationShip != 0));
    this.hY = new RelativeLayout(a());
    this.hY.setBackgroundColor(Color.parseColor("#cf000000"));
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
    this.bXO = 0;
    ImageView localImageView = new ImageView(a());
    localImageView.setScaleType(ImageView.ScaleType.FIT_XY);
    localImageView.setId(2131362773);
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = wja.dp2px(200.0F, this.mContext.getResources());
    ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = wja.dp2px(100.0F, this.mContext.getResources());
    localImageView.setImageDrawable(URLDrawable.getDrawable("https://cmshow.gtimg.cn/client/img/add_playmate_intro.png", (URLDrawable.URLDrawableOptions)localObject));
    localImageView.setOnClickListener(this.x);
    RelativeLayout.LayoutParams localLayoutParams1 = new RelativeLayout.LayoutParams(wja.dp2px(91.0F, this.mContext.getResources()), wja.dp2px(41.0F, this.mContext.getResources()));
    localLayoutParams1.addRule(11);
    localLayoutParams1.addRule(10);
    localLayoutParams1.setMargins(0, ImmersiveUtils.getStatusBarHeight(BaseApplicationImpl.getApplication()) + wja.dp2px(57.0F, this.mContext.getResources()), wja.dp2px(10.0F, this.mContext.getResources()), 0);
    this.hY.addView(localImageView, localLayoutParams1);
    localImageView = new ImageView(a());
    localLayoutParams1 = new RelativeLayout.LayoutParams(wja.dp2px(210.0F, this.mContext.getResources()), wja.dp2px(70.0F, this.mContext.getResources()));
    localLayoutParams1.addRule(3, 2131362773);
    localLayoutParams1.addRule(11);
    localLayoutParams1.setMargins(0, 0, wja.dp2px(40.0F, this.mContext.getResources()), 0);
    localObject = URLDrawable.getDrawable("https://cmshow.gtimg.cn/client/img/add_playmate_intro1.png", (URLDrawable.URLDrawableOptions)localObject);
    localImageView.setScaleType(ImageView.ScaleType.FIT_XY);
    localImageView.setImageDrawable((Drawable)localObject);
    this.hY.addView(localImageView, localLayoutParams1);
    this.hY.setOnClickListener(new xxm(this));
    QLog.i(this.TAG, 1, "[showAddPlaymateIntro] already show addplaymate intro.");
    ((FrameLayout)a().getWindow().getDecorView()).addView(this.hY, localLayoutParams);
    this.bkx = true;
    localSharedPreferences.edit().putBoolean("apollo_add_playMate_intro", false).commit();
  }
  
  public void doOnDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "[doOnDestory] chatPie:" + this + "," + this.bkl);
    }
    this.bkm = false;
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForCmGameTips != null)
    {
      this.app.b().b(this.jdField_a_of_type_ComTencentMobileqqDataMessageForCmGameTips, false);
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForCmGameTips = null;
    }
    abhh localabhh = (abhh)this.app.getManager(153);
    localabhh.a().cDm();
    localabhh.a().b(this.jdField_a_of_type_Xxh$a);
    localabhh.a().BY("page_tag_aio");
    if (this.bkl)
    {
      localabhh.a().Cd(oL());
      this.bkl = false;
    }
    this.jdField_a_of_type_Xxh$a = null;
    if (this.jdField_a_of_type_Abmf != null)
    {
      this.jdField_a_of_type_Abmf.dismiss();
      this.jdField_a_of_type_Abmf = null;
    }
    super.doOnDestroy();
    this.mShowing = false;
    this.mSubHandler.removeCallbacksAndMessages(null);
    bkr = false;
    if (this.S != null) {
      this.S.dismiss();
    }
    if (this.T != null) {
      this.T.dismiss();
    }
    if (this.hY != null)
    {
      zI(true);
      this.hY = null;
      this.bkx = false;
    }
    if (this.hZ != null)
    {
      zJ(true);
      this.hZ = null;
      this.bkx = false;
    }
    localabhh.a().b(null);
    localabhh.a().de(oL(), 319);
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    this.mPaused = true;
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    this.ps.setVisibility(8);
    abhh localabhh = (abhh)this.app.getManager(153);
    if (this.mPaused) {
      localabhh.a().wakeup();
    }
    this.mPaused = false;
    this.bkn = false;
    if (bkr)
    {
      this.uiHandler.removeMessages(16777215);
      this.uiHandler.sendEmptyMessageDelayed(16777215, 500L);
    }
  }
  
  public void doOnStart()
  {
    super.doOnStart();
    if ((this.mActivity.getIntent() != null) && (!this.mActivity.getIntent().getBooleanExtra("key_show_one_more_page", false))) {
      cfM();
    }
  }
  
  public void doOnStop()
  {
    super.doOnStop();
    this.bkn = true;
  }
  
  public void f(int paramInt, long paramLong, String paramString)
  {
    if (this.sessionInfo == null) {
      return;
    }
    CmGameStartChecker.StartCheckParam localStartCheckParam = new CmGameStartChecker.StartCheckParam(paramInt, true, "message", paramLong, 1, 0, this.sessionInfo.cZ, ApolloGameUtil.a(this.app, this.sessionInfo.cZ, this.sessionInfo.aTl), this.sessionInfo.aTl, this.mSrc, null);
    localStartCheckParam.mTempAIOUin = this.sessionInfo.aTl;
    localStartCheckParam.mTempAIONickName = this.sessionInfo.aTn;
    localStartCheckParam.disableMinGame = true;
    localStartCheckParam.mRobotOpenId = paramString;
    localStartCheckParam.src = 318001;
    ApolloGameUtil.a(this.mActivity, localStartCheckParam);
    bkr = true;
    abmh.b(this.app, this.sessionInfo.aTl, this.sessionInfo.cZ, paramInt, paramLong);
  }
  
  public void gf(long paramLong)
  {
    ThreadManagerV2.getUIHandlerV2().post(new CmGameChatPie.16(this, paramLong));
  }
  
  public void gs(List<ApolloGameData> paramList)
  {
    this.sq = paramList;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return super.handleMessage(paramMessage);
      cfL();
      continue;
      if (this.jdField_a_of_type_ComTencentMobileqqApolloLightGameQuickInputTipsBar != null)
      {
        this.fs.removeView(this.jdField_a_of_type_ComTencentMobileqqApolloLightGameQuickInputTipsBar);
        this.jdField_a_of_type_ComTencentMobileqqApolloLightGameQuickInputTipsBar = null;
        continue;
        if (this.jdField_a_of_type_ComTencentMobileqqApolloLightGameQuickInputTipsBar != null)
        {
          this.fs.removeView(this.jdField_a_of_type_ComTencentMobileqqApolloLightGameQuickInputTipsBar);
          this.jdField_a_of_type_ComTencentMobileqqApolloLightGameQuickInputTipsBar = null;
          continue;
          Object localObject = (String)paramMessage.obj;
          if ("dialog_type_permission".equals(localObject))
          {
            if (this.T == null)
            {
              localObject = aqha.a(a(), 230).setMessage(a().getString(2131697844)).setTitle(a().getString(2131697845)).setNegativeButton(2131721058, new xxp(this));
              if (!jll.i(a())) {
                break label218;
              }
            }
            label218:
            for (int j = 2131697846;; j = 2131697847)
            {
              this.T = ((aqju)localObject).setPositiveButton(j, new xxo(this));
              this.T.show();
              break;
            }
          }
          if ("dialog_type_confirm".equals(localObject))
          {
            if (this.S == null) {
              this.S = aqha.a(a(), 230).setMessage(acfp.m(2131704071)).setPositiveButton(a().getString(2131721079), new xxr(this)).setNegativeButton(a().getString(2131721058), new xxq(this));
            }
            this.S.show();
          }
        }
      }
    }
  }
  
  public void k(Object paramObject)
  {
    super.k(paramObject);
    switch (((Integer)paramObject).intValue())
    {
    default: 
      return;
    case 4: 
      VipUtils.a(null, "cmshow", "Apollo", "picClick", 0, 0, new String[] { "" });
      return;
    case 3: 
      VipUtils.a(null, "cmshow", "Apollo", "expressionClick", 0, 0, new String[] { "" });
      return;
    }
    VipUtils.a(null, "cmshow", "Apollo", "gameClick", 0, 0, new String[] { "" });
  }
  
  public void l(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    if (paramInt == 3)
    {
      paramString1 = new ahwa(paramString1, paramString2, acfp.m(2131704061), this.sessionInfo.cZ, -5040, 2359297, anaz.gQ());
      paramString2 = new MessageForUniteGrayTip();
      paramString2.initGrayTipMsg(this.app, paramString1);
      ahwb.a(this.app, paramString2);
    }
    String str2;
    SharedPreferences localSharedPreferences;
    long l;
    do
    {
      do
      {
        return;
        str2 = "apollo_add_playMate_gray_tip" + paramString2 + "_" + paramString1 + "_" + paramInt;
        localSharedPreferences = SharedPreferencesProxyManager.getInstance().getProxy("apollo_sp", 0);
      } while (!localSharedPreferences.getBoolean(str2, true));
      l = anaz.gQ();
      str1 = "";
      if (paramInt != 0) {
        break;
      }
    } while ((this.jdField_a_of_type_Xxh$b != null) && (this.jdField_a_of_type_Xxh$b.relationShip == 4));
    String str1 = acfp.m(2131704074);
    for (;;)
    {
      paramString1 = new ahwa(paramString1, paramString2, str1, this.sessionInfo.cZ, -5040, 2359297, l);
      paramString2 = new MessageForUniteGrayTip();
      paramString2.initGrayTipMsg(this.app, paramString1);
      ahwb.a(this.app, paramString2);
      localSharedPreferences.edit().putBoolean(str2, false).commit();
      return;
      if (paramInt == 1) {
        str1 = acfp.m(2131704072) + paramString3 + acfp.m(2131704062);
      } else if (paramInt == 2) {
        str1 = acfp.m(2131704059) + paramString3 + acfp.m(2131704060);
      }
    }
  }
  
  public boolean onBackEvent()
  {
    if (this.bkx)
    {
      zI(true);
      zJ(true);
      return true;
    }
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      super.onClick(paramView);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      VipUtils.a(null, "cmshow", "Apollo", "returnBtn", 0, 0, new String[] { "" });
      continue;
      VipUtils.a(null, "cmshow", "Apollo", "dataEntry", 0, 0, new String[] { "" });
      continue;
      VipUtils.a(null, "cmshow", "Apollo", "inputBoxClick", 0, 0, new String[] { "" });
    }
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if ((paramObject != null) && ((paramObject instanceof MessageRecord)) && ((paramObject instanceof ChatMessage)))
    {
      ChatMessage localChatMessage = (ChatMessage)paramObject;
      if (localChatMessage.senderuin.equals(this.sessionInfo.aTl))
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.TAG, 2, "[update] get friend message,update friend status");
        }
        this.mSubHandler.removeMessages(1);
        Message localMessage = Message.obtain();
        localMessage.what = 1;
        localMessage.obj = localChatMessage.selfuin;
        this.mSubHandler.sendMessageDelayed(localMessage, 60000L);
        ThreadManager.getUIHandler().post(new CmGameChatPie.7(this));
      }
    }
    super.update(paramObservable, paramObject);
  }
  
  public void w(int paramInt1, int paramInt2, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, new Object[] { "[showOneMoreGameView] gameId:", Integer.valueOf(paramInt1), ",isWinner:", Integer.valueOf(paramInt2), ",reqData:", paramString });
    }
    this.bXO += 1;
    if (this.jdField_a_of_type_Xxh$b != null)
    {
      this.mActivity.getIntent().putExtra("key_show_one_more_page", false);
      ThreadManager.getUIHandler().post(new CmGameChatPie.12(this, paramInt1, paramInt2, paramString));
    }
    do
    {
      return;
      this.mActivity.getIntent().putExtra("key_show_one_more_page", true);
      this.mActivity.getIntent().putExtra("key_req_data", paramString);
    } while (!QLog.isColorLevel());
    QLog.d(this.TAG, 2, "[showOneMoreGameView] friendInfo is null,update intent extra param");
  }
  
  public void yj(String paramString)
  {
    if (this.ia != null)
    {
      this.cL.removeView(this.ia);
      l(paramString, this.app.getCurrentAccountUin(), this.jdField_a_of_type_Xxh$b.nickName, 2);
      if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForCmGameTips != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqDataMessageForCmGameTips.needTopPadding = false;
        this.jdField_a_of_type_Wki.notifyDataSetChanged();
      }
    }
  }
  
  public void yk(String paramString)
  {
    Message localMessage = Message.obtain();
    localMessage.what = 16777218;
    localMessage.obj = paramString;
    this.uiHandler.removeMessages(16777218);
    this.uiHandler.sendMessage(localMessage);
  }
  
  public void zG(boolean paramBoolean)
  {
    ThreadManager.getUIHandler().post(new CmGameChatPie.14(this, paramBoolean));
  }
  
  public void zH(boolean paramBoolean)
  {
    ThreadManager.getUIHandler().post(new CmGameChatPie.15(this, paramBoolean));
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, new Object[] { "updateFriendVoiceStatus isVoiceOpen:", Boolean.valueOf(paramBoolean) });
    }
    this.bkp = paramBoolean;
    this.bku = true;
    if (this.uiHandler != null)
    {
      this.uiHandler.removeMessages(16777215);
      this.uiHandler.sendEmptyMessageDelayed(16777215, 500L);
    }
  }
  
  public void zI(boolean paramBoolean)
  {
    if ((this.hY != null) && (this.bkx))
    {
      ((FrameLayout)a().getWindow().getDecorView()).removeView(this.hY);
      this.hY = null;
      this.bkx = false;
      if (paramBoolean) {
        VipUtils.a(null, "cmshow", "Apollo", "guideOfAddFriend", 0, 0, new String[] { "2" });
      }
    }
  }
  
  public void zJ(boolean paramBoolean)
  {
    if ((this.hZ != null) && (this.bkx))
    {
      ((FrameLayout)a().getWindow().getDecorView()).removeView(this.hZ);
      this.hZ = null;
      this.bkx = false;
      if (paramBoolean) {
        VipUtils.a(null, "cmshow", "Apollo", "guideOfAudio", 0, 0, new String[] { "2" });
      }
    }
  }
  
  public static class a
    extends abmi.a
  {
    private WeakReference<xxh> er;
    
    a(xxh paramxxh)
    {
      this.er = new WeakReference(paramxxh);
    }
    
    public void S(String paramString, int paramInt1, int paramInt2)
    {
      if (QLog.isColorLevel()) {
        QLog.d("CmGameTemp_CmGameChatPie", 2, "[onQueryUserStatus] friendUin:" + paramString + ",status:" + paramInt1 + ",lastTs:" + paramInt2);
      }
      super.S(paramString, paramInt1, paramInt2);
      xxh localxxh = (xxh)this.er.get();
      if ((localxxh == null) || (localxxh.sessionInfo == null)) {}
      while (!localxxh.sessionInfo.aTl.equals(paramString)) {
        return;
      }
      ThreadManager.getUIHandler().post(new CmGameChatPie.ChatPieMsgListener.11(this, localxxh, paramString, paramInt1, paramInt2));
    }
    
    public void a(String paramString, abmi.d paramd)
    {
      xxh localxxh = (xxh)this.er.get();
      if ((localxxh == null) || (localxxh.sessionInfo == null)) {}
      while ((TextUtils.isEmpty(paramString)) || (!paramString.equals(localxxh.sessionInfo.aTl))) {
        return;
      }
      localxxh.a(paramd);
    }
    
    public void a(String paramString, xxh.b paramb)
    {
      xxh localxxh = (xxh)this.er.get();
      if ((localxxh == null) || (localxxh.sessionInfo == null)) {}
      while ((TextUtils.isEmpty(paramString)) || (!paramString.equals(localxxh.sessionInfo.aTl))) {
        return;
      }
      ThreadManager.getUIHandler().post(new CmGameChatPie.ChatPieMsgListener.1(this, localxxh, paramString, paramb));
    }
    
    public void a(boolean paramBoolean, int paramInt1, long paramLong, int paramInt2)
    {
      super.a(paramBoolean, paramInt1, paramLong, paramInt2);
      xxh localxxh = (xxh)this.er.get();
      if ((localxxh == null) || (localxxh.sessionInfo == null)) {}
      do
      {
        do
        {
          return;
          if (!paramBoolean)
          {
            QLog.e("CmGameTemp_CmGameChatPie", 1, "onCreateRoomId createSuccess:false");
            ThreadManager.getUIHandler().post(new CmGameChatPie.ChatPieMsgListener.7(this, localxxh));
            return;
          }
        } while (localxxh.app == null);
        if (xxh.a(localxxh) != paramInt2) {
          break label215;
        }
        if (!abmk.gM(localxxh.sessionInfo.aTl)) {
          break;
        }
      } while (xxh.a(localxxh) == null);
      String str = xxh.a(localxxh).re();
      if (xxh.d(localxxh) == paramInt2)
      {
        abmh.a(localxxh.app, localxxh.sessionInfo.aTl, str, paramLong, paramInt1);
        localxxh.gf(paramLong);
        return;
      }
      localxxh.V(paramInt1, paramLong);
      ThreadManagerV2.getUIHandlerV2().postDelayed(new CmGameChatPie.ChatPieMsgListener.8(this, localxxh, paramInt1, paramLong, str), 1500L);
      return;
      ((abhh)localxxh.app.getManager(153)).a().x(localxxh.sessionInfo.aTl, paramInt1, paramLong);
      return;
      label215:
      QLog.e("CmGameTemp_CmGameChatPie", 1, "onCreateRoomId chatPie.mCreateRoomReqCode != reqCode, reqCode:" + paramInt2);
    }
    
    public void a(boolean paramBoolean, String paramString, int paramInt, long paramLong)
    {
      super.a(paramBoolean, paramString, paramInt, paramLong);
      xxh localxxh = (xxh)this.er.get();
      if ((localxxh == null) || (localxxh.sessionInfo == null) || (localxxh.app == null)) {}
      while ((TextUtils.isEmpty(paramString)) || (!paramString.equals(localxxh.sessionInfo.aTl))) {
        return;
      }
      if (paramBoolean) {
        localxxh.V(paramInt, paramLong);
      }
      ThreadManager.getUIHandler().post(new CmGameChatPie.ChatPieMsgListener.2(this, localxxh, paramBoolean));
    }
    
    public void a(boolean paramBoolean, String paramString1, int paramInt, long paramLong, String paramString2)
    {
      super.a(paramBoolean, paramString1, paramInt, paramLong, paramString2);
      if (QLog.isColorLevel()) {
        QLog.d("CmGameTemp_CmGameChatPie", 2, "[onCheckRobotModeRsp] friendUin:" + paramString1 + ",gameId:" + paramInt + ",roomId:" + paramLong);
      }
      xxh localxxh = (xxh)this.er.get();
      if ((localxxh == null) || (localxxh.sessionInfo == null) || (localxxh.app == null)) {}
      while ((TextUtils.isEmpty(paramString1)) || (!paramString1.equals(localxxh.sessionInfo.aTl)) || (!paramBoolean)) {
        return;
      }
      long l = System.currentTimeMillis() - abmh.NU;
      if (l > 1500L)
      {
        localxxh.f(paramInt, paramLong, paramString2);
        return;
      }
      ThreadManagerV2.getUIHandlerV2().postDelayed(new CmGameChatPie.ChatPieMsgListener.12(this, localxxh, paramInt, paramLong, paramString2), 1500L - l);
    }
    
    public void a(boolean paramBoolean1, boolean paramBoolean2, String paramString, int paramInt, long paramLong)
    {
      super.a(paramBoolean1, paramBoolean2, paramString, paramInt, paramLong);
      xxh localxxh = (xxh)this.er.get();
      if ((localxxh == null) || (localxxh.sessionInfo == null)) {}
      do
      {
        do
        {
          return;
        } while ((TextUtils.isEmpty(paramString)) || (!paramString.equals(localxxh.sessionInfo.aTl)) || (!paramBoolean1));
        if (xxh.a(localxxh))
        {
          QLog.e("CmGameTemp_CmGameChatPie", 1, "onOneMoreGameRspFinish chatPie.mStoped");
          return;
        }
      } while ((!paramBoolean2) || (localxxh.app == null) || (xxh.a(localxxh) == null));
      paramString = new CmGameStartChecker.StartCheckParam(xxh.a(localxxh).gameId, true, "message", xxh.a(localxxh).roomId, 1, 0, localxxh.sessionInfo.cZ, ApolloGameUtil.a(localxxh.app, localxxh.sessionInfo.cZ, localxxh.sessionInfo.aTl), localxxh.sessionInfo.aTl, xxh.c(localxxh), null);
      paramString.mTempAIOUin = localxxh.sessionInfo.aTl;
      paramString.mTempAIONickName = localxxh.sessionInfo.aTn;
      paramString.disableMinGame = true;
      ApolloGameUtil.a(localxxh.mActivity, paramString);
      xxh.bkr = true;
      abmh.b(localxxh.app, localxxh.sessionInfo.aTl, localxxh.sessionInfo.cZ, paramInt, paramLong);
    }
    
    public void aZ(String paramString, boolean paramBoolean)
    {
      super.aZ(paramString, paramBoolean);
      paramString = (xxh)this.er.get();
      if ((paramString == null) || (paramString.sessionInfo == null)) {
        return;
      }
      paramString.zH(paramBoolean);
    }
    
    public void b(boolean paramBoolean, String paramString, int paramInt, long paramLong)
    {
      xxh localxxh = (xxh)this.er.get();
      if ((localxxh == null) || (localxxh.sessionInfo == null) || (localxxh.app == null)) {}
      while ((TextUtils.isEmpty(paramString)) || (!paramString.equals(localxxh.sessionInfo.aTl))) {
        return;
      }
      if (!paramBoolean) {
        abmh.a(localxxh.app, localxxh.sessionInfo.aTl, localxxh.sessionInfo.cZ, paramInt, paramLong);
      }
      if (xxh.a(localxxh))
      {
        QLog.e("CmGameTemp_CmGameChatPie", 1, "onPushOneMoreGameMsgRsp chatPie.mStoped");
        return;
      }
      ThreadManager.getUIHandler().post(new CmGameChatPie.ChatPieMsgListener.10(this, paramBoolean, localxxh, paramInt, paramLong));
    }
    
    public void cF(String paramString, int paramInt)
    {
      super.cF(paramString, paramInt);
      xxh localxxh = (xxh)this.er.get();
      if ((localxxh == null) || (localxxh.sessionInfo == null)) {}
      while ((TextUtils.isEmpty(paramString)) || (!paramString.equals(localxxh.oL()))) {
        return;
      }
      if (paramInt == 0) {}
      for (boolean bool = false;; bool = true)
      {
        localxxh.zH(bool);
        return;
      }
    }
    
    public void f(String paramString, int paramInt, List<MessageForApollo> paramList)
    {
      super.f(paramString, paramInt, paramList);
      xxh localxxh = (xxh)this.er.get();
      if ((localxxh == null) || (localxxh.sessionInfo == null)) {}
      QQAppInterface localQQAppInterface;
      do
      {
        do
        {
          return;
          if (xxh.a(localxxh) != null) {
            xxh.a(localxxh).dismiss();
          }
        } while ((TextUtils.isEmpty(paramString)) || (!paramString.equals(localxxh.sessionInfo.aTl)));
        localQQAppInterface = localxxh.app;
      } while (localQQAppInterface == null);
      if ((paramList == null) || (paramList.isEmpty()))
      {
        QLog.e("CmGameChatPie", 1, "onAcceptMyInvite msgs == null || msgs.isEmpty()");
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("CmGameChatPie", 2, new Object[] { "onAcceptMyInvite friendUin:", paramString, " msgs.size:", Integer.valueOf(paramList.size()) });
      }
      if (xxh.a(localxxh))
      {
        QLog.e("CmGameChatPie", 1, "onAcceptMyInvite chatPie.mStoped");
        return;
      }
      paramString = (MessageForApollo)paramList.get(0);
      paramString = new CmGameStartChecker.StartCheckParam(paramString.gameId, paramString.isSend(), "message", paramString.roomId, 1, 0, localxxh.sessionInfo.cZ, ApolloGameUtil.a(localQQAppInterface, localxxh.sessionInfo.cZ, localxxh.sessionInfo.aTl), localxxh.sessionInfo.aTl, xxh.c(localxxh), paramString.gameName);
      paramString.mTempAIOUin = localxxh.sessionInfo.aTl;
      paramString.mTempAIONickName = localxxh.sessionInfo.aTn;
      paramString.disableMinGame = true;
      ApolloGameUtil.a(localxxh.mActivity, paramString);
      xxh.bkr = true;
    }
    
    public void r(String paramString, List<ApolloGameData> paramList)
    {
      super.r(paramString, paramList);
      xxh localxxh = (xxh)this.er.get();
      if ((localxxh == null) || (localxxh.sessionInfo == null)) {}
      do
      {
        do
        {
          return;
        } while ((TextUtils.isEmpty(paramString)) || (!paramString.equals(localxxh.sessionInfo.aTl)));
        localxxh.gs(paramList);
      } while (localxxh.a == null);
      localxxh.a.cGk();
    }
    
    public void u(String paramString, int paramInt, long paramLong)
    {
      xxh localxxh = (xxh)this.er.get();
      if ((localxxh == null) || (localxxh.sessionInfo == null)) {}
      while ((TextUtils.isEmpty(paramString)) || (!paramString.equals(localxxh.sessionInfo.aTl))) {
        return;
      }
      ThreadManager.getUIHandler().post(new CmGameChatPie.ChatPieMsgListener.9(this, localxxh, paramInt, paramLong));
    }
    
    public void yl(String paramString)
    {
      super.yl(paramString);
      if (QLog.isColorLevel()) {
        QLog.d("CmGameTemp_CmGameChatPie", 2, "[onPushPlaymateExitAio] friendUin:" + paramString);
      }
      if (TextUtils.isEmpty(paramString)) {}
      xxh localxxh;
      do
      {
        return;
        localxxh = (xxh)this.er.get();
      } while ((localxxh == null) || (localxxh.sessionInfo == null) || (!paramString.equals(localxxh.oL())));
      localxxh.l(paramString, localxxh.app.getCurrentUin(), "", 3);
    }
    
    public void ym(String paramString)
    {
      xxh localxxh = (xxh)this.er.get();
      if ((localxxh == null) || (localxxh.sessionInfo == null)) {}
      while ((TextUtils.isEmpty(paramString)) || (!paramString.equals(localxxh.sessionInfo.aTl))) {
        return;
      }
      ThreadManager.getUIHandler().post(new CmGameChatPie.ChatPieMsgListener.3(this, localxxh, paramString));
    }
    
    public void yn(String paramString)
    {
      xxh localxxh = (xxh)this.er.get();
      if ((localxxh == null) || (localxxh.sessionInfo == null)) {}
      while ((TextUtils.isEmpty(paramString)) || (!paramString.equals(localxxh.sessionInfo.aTl))) {
        return;
      }
      ThreadManager.getUIHandler().post(new CmGameChatPie.ChatPieMsgListener.4(this, localxxh, paramString));
    }
    
    public void yo(String paramString)
    {
      xxh localxxh = (xxh)this.er.get();
      if ((localxxh == null) || (localxxh.sessionInfo == null)) {}
      while ((TextUtils.isEmpty(paramString)) || (!paramString.equals(localxxh.sessionInfo.aTl))) {
        return;
      }
      ThreadManager.getUIHandler().post(new CmGameChatPie.ChatPieMsgListener.5(this, localxxh, paramString));
    }
    
    public void yp(String paramString)
    {
      xxh localxxh = (xxh)this.er.get();
      if ((localxxh == null) || (localxxh.sessionInfo == null)) {}
      while ((TextUtils.isEmpty(paramString)) || (!paramString.equals(localxxh.sessionInfo.aTl))) {
        return;
      }
      ThreadManager.getUIHandler().post(new CmGameChatPie.ChatPieMsgListener.6(this, localxxh, paramString));
    }
  }
  
  public static class b
  {
    public String aWT;
    public int age;
    public String city;
    public String nickName;
    public String province;
    public int relationShip;
    public int sex;
    public String uin;
    
    public String toString()
    {
      StringBuffer localStringBuffer = new StringBuffer("UserInfo{");
      localStringBuffer.append("age=").append(this.age);
      localStringBuffer.append(", sex=").append(this.sex);
      localStringBuffer.append(", nickName='").append(this.nickName).append('\'');
      localStringBuffer.append(", province='").append(this.province).append('\'');
      localStringBuffer.append(", city='").append(this.city).append('\'');
      localStringBuffer.append(", headPic='").append(this.aWT).append('\'');
      localStringBuffer.append(", relationShip=").append(this.relationShip);
      localStringBuffer.append(", uin='").append(this.uin).append('\'');
      localStringBuffer.append('}');
      return localStringBuffer.toString();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xxh
 * JD-Core Version:    0.7.0.1
 */