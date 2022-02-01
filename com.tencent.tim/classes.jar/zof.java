import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.MovementMethod;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.AbstractVideoImage;
import com.tencent.image.ApngImage;
import com.tencent.image.NativeVideoImage;
import com.tencent.image.URLDrawable;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.b;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.ArkFlashChatContainerWrapper;
import com.tencent.mobileqq.activity.aio.item.ShortVideoItemBuilder;
import com.tencent.mobileqq.activity.aio.item.ShortVideoRealItemBuilder;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout;
import com.tencent.mobileqq.activity.miniaio.MiniChatActivity;
import com.tencent.mobileqq.activity.miniaio.MiniChatConstants;
import com.tencent.mobileqq.activity.miniaio.MiniPie.11;
import com.tencent.mobileqq.activity.miniaio.MiniPie.2;
import com.tencent.mobileqq.activity.miniaio.MiniPie.3;
import com.tencent.mobileqq.activity.miniaio.MiniPie.4;
import com.tencent.mobileqq.activity.miniaio.MiniPie.5;
import com.tencent.mobileqq.activity.miniaio.MiniPie.8;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForReplyText.SourceMsgInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.emoticon.EmojiStickerManager;
import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.vas.avatar.VasFaceManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.AbsListView.d;
import com.tencent.widget.AbsListView.e;
import com.tencent.widget.ListView;
import com.tencent.widget.XEditTextEx;
import com.tencent.widget.XPanelContainer;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

public abstract class zof
  implements Handler.Callback, TextWatcher, View.OnClickListener, auuo, AbsListView.d, AbsListView.e, Observer, znh
{
  static int bEA;
  private TextView Cy;
  protected long Fp = -1L;
  protected TextView MV;
  Boolean T = Boolean.valueOf(true);
  public String TAG = "MiniPie";
  public MovementMethod a;
  aqmn.a jdField_a_of_type_Aqmn$a = new zoh(this);
  private aqmn jdField_a_of_type_Aqmn;
  public XEditTextEx a;
  protected XPanelContainer a;
  zni jdField_a_of_type_Zni;
  znl jdField_a_of_type_Znl;
  protected boolean aSd;
  ImageButton ad;
  QQMessageFacade.b jdField_b_of_type_ComTencentImcoreMessageQQMessageFacade$b;
  public EmoticonMainPanel b;
  MqqHandler jdField_b_of_type_MqqOsMqqHandler;
  int bEg = 0;
  int bEh = 0;
  protected int bEk;
  int bZU = 0;
  public boolean brS;
  private boolean brT;
  private boolean brU;
  protected boolean brV;
  private boolean brW;
  protected boolean brX;
  private boolean brY;
  private acfd c = new zok(this);
  public ViewGroup cL;
  int cdX = 2;
  int cdY = 0;
  private int cdZ;
  public ChatXListView d;
  ViewGroup dG;
  Button eE;
  private boolean es = true;
  WindowManager.LayoutParams f;
  RelativeLayout fs;
  RelativeLayout iB;
  RelativeLayout iC;
  private RelativeLayout iD;
  boolean isResume = false;
  private int keyboardHeight;
  public QQAppInterface mApp;
  public Context mContext;
  float mDensity;
  String mNickName;
  SessionInfo mSessionInfo;
  public MessageForReplyText.SourceMsgInfo mSourceMsgInfo;
  TextView mTitleText;
  WindowManager mWindowManager;
  String uin;
  int uinType;
  protected ImageView vr;
  View xO;
  
  public zof(Context paramContext, SessionInfo paramSessionInfo, QQAppInterface paramQQAppInterface)
  {
    this.jdField_b_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel = null;
    this.mContext = paramContext;
    this.mSessionInfo = paramSessionInfo;
    this.mApp = paramQQAppInterface;
    MiniChatConstants.SCREEN_HEIGHT = this.mContext.getResources().getDisplayMetrics().heightPixels;
    if (MiniChatConstants.SCREEN_HEIGHT <= 0)
    {
      QLog.e(this.TAG, 1, "SCREEN_HEIGHT <= 0 reset to 1080");
      MiniChatConstants.SCREEN_HEIGHT = 1080;
    }
    Ib();
  }
  
  private boolean VA()
  {
    return this.brW;
  }
  
  private void cqo()
  {
    if (this.vr == null) {
      return;
    }
    this.vr.setVisibility(0);
    this.vr.setImageResource(2130850835);
    this.vr.setColorFilter(Color.argb(255, 3, 8, 26));
    if (Build.VERSION.SDK_INT >= 16)
    {
      this.vr.setBackground(null);
      return;
    }
    this.vr.setBackgroundDrawable(null);
  }
  
  private void cqp()
  {
    this.iC.setVisibility(0);
    if (("1103".equals(ThemeUtil.curThemeId)) || ("2920".equals(ThemeUtil.curThemeId)))
    {
      this.iB.setBackgroundResource(2130845743);
      localImageView = (ImageView)this.iD.findViewById(2131369594);
      localImageView.setBackgroundResource(0);
      localImageView.setImageDrawable(this.mContext.getResources().getDrawable(2130851145));
      localImageView = (ImageView)this.iC.findViewById(2131368962);
      Object localObject = localImageView.getLayoutParams();
      if ((localObject instanceof RelativeLayout.LayoutParams))
      {
        localObject = (RelativeLayout.LayoutParams)localObject;
        ((RelativeLayout.LayoutParams)localObject).width = wja.dp2px(35.0F, this.mContext.getResources());
        ((RelativeLayout.LayoutParams)localObject).height = wja.dp2px(35.0F, this.mContext.getResources());
        localImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      localImageView.setBackgroundResource(0);
      localImageView.setImageDrawable(this.mContext.getResources().getDrawable(2130851758));
      this.MV.setTextColor(this.mContext.getResources().getColor(2131167301));
      this.mTitleText.setTextColor(this.mContext.getResources().getColor(2131167301));
      this.MV.setAlpha(0.8F);
      return;
    }
    this.mTitleText.setTextColor(-1);
    this.MV.setTextColor(-1);
    this.MV.setAlpha(0.8F);
    this.iB.setBackgroundResource(2130845742);
    ImageView localImageView = (ImageView)this.iD.findViewById(2131369594);
    localImageView.setBackgroundResource(0);
    if (anlm.ayn()) {
      localImageView.setImageDrawable(this.mContext.getResources().getDrawable(2130845680));
    }
    for (;;)
    {
      localImageView = (ImageView)this.iC.findViewById(2131368962);
      localImageView.setBackgroundResource(0);
      localImageView.setImageDrawable(this.mContext.getResources().getDrawable(2130851759));
      return;
      localImageView.setImageDrawable(this.mContext.getResources().getDrawable(2130851146));
    }
  }
  
  private void cqu()
  {
    if (this.mSessionInfo == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "onAudioVideoBtnClick curType=" + this.mSessionInfo.cZ + " curFriendUin= " + this.mSessionInfo.aTl + " troopUin " + this.mSessionInfo.troopUin);
    }
    jiy.a(this.mApp, this.mContext, this.mSessionInfo, 3);
  }
  
  private void cqx()
  {
    this.mWindowManager.removeView(this.jdField_b_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel);
    this.brS = false;
  }
  
  private void cqy()
  {
    this.mWindowManager.addView(this.jdField_b_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel, this.f);
    this.brS = true;
    this.jdField_b_of_type_MqqOsMqqHandler.post(new MiniPie.4(this));
  }
  
  private void cqz()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "refreshListAdaper dirty " + this.bEk);
    }
    List localList1 = this.jdField_a_of_type_Zni.getList();
    List localList2 = this.mApp.b().a(this.uin, this.uinType, -1L, true);
    EmojiStickerManager.a().a(this.mApp, this.d, this.mSessionInfo.aTl, this.mSessionInfo.cZ, 1, localList2);
    A(localList1, localList2);
    B(localList1, localList2);
    this.bEk = 0;
  }
  
  private boolean hp(int paramInt)
  {
    return (paramInt == 0) || (paramInt == 3000) || (paramInt == 1);
  }
  
  private int q(View paramView)
  {
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    return arrayOfInt[1];
  }
  
  private void zU(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i(this.TAG, 2, "updateListUnRead: " + paramInt);
    }
    if ((paramInt == 0) && (this.Cy != null))
    {
      this.Cy.setText(Integer.toString(paramInt));
      this.Cy.setVisibility(8);
    }
    while (paramInt <= 0) {
      return;
    }
    if (this.Cy == null)
    {
      localObject1 = new TextView(this.mContext);
      ((TextView)localObject1).setId(2131372041);
      ((TextView)localObject1).setBackgroundResource(2130838460);
      ((TextView)localObject1).setGravity(1);
      ((TextView)localObject1).setPadding(0, (int)(2.0F * this.mDensity + 0.5F), 0, 0);
      ((TextView)localObject1).setSingleLine();
      ((TextView)localObject1).setTextColor(-1);
      ((TextView)localObject1).setTextSize(2, 16.0F);
      ((TextView)localObject1).setOnClickListener(this);
      localObject2 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject2).addRule(2, 2131369277);
      ((RelativeLayout.LayoutParams)localObject2).addRule(11);
      ((RelativeLayout.LayoutParams)localObject2).bottomMargin = ((int)(this.mDensity * 10.0F + 0.5F));
      ((RelativeLayout.LayoutParams)localObject2).rightMargin = ((int)(this.mDensity * 10.0F + 0.5F));
      this.fs.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
      this.Cy = ((TextView)localObject1);
    }
    Object localObject2 = this.Cy;
    if (paramInt > 99) {}
    for (Object localObject1 = "99";; localObject1 = Integer.toString(paramInt))
    {
      ((TextView)localObject2).setText((CharSequence)localObject1);
      this.Cy.setVisibility(0);
      return;
    }
  }
  
  protected void A(List<ChatMessage> paramList1, List<ChatMessage> paramList2)
  {
    int i = this.bEk & 0xFFFF0000;
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "listViewSrollPosition tempBindType " + i);
    }
    switch (i)
    {
    case 65536: 
    default: 
      return;
    }
    this.jdField_a_of_type_Zni.a(paramList2, null, 0);
    this.cL.invalidate();
  }
  
  public void Am(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "MiniPie onScrollToButtom");
    }
  }
  
  protected void B(List<ChatMessage> paramList1, List<ChatMessage> paramList2)
  {
    int i = 0xFFFF & this.bEk;
    zos localzos = (zos)a(1);
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "listViewSrollPosition tempScrollType " + i);
    }
    switch (i)
    {
    case 5: 
    case 6: 
    case 7: 
    default: 
      if (localzos != null) {
        this.bEg = localzos.a(paramList1, paramList2, this.bEg);
      }
      break;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 2, "listViewSrollPosition mReadedCnt " + this.bEg + " newSize " + paramList2.size());
      }
      return;
      i = zos.b(this.d, this.bEg, paramList1, paramList2);
      if (i != 0)
      {
        this.bEk = (i + this.bEk);
        B(paramList1, paramList2);
      }
      if (localzos != null)
      {
        this.bEg = localzos.a(paramList1, paramList2, this.bEg);
        continue;
        if (!VA()) {
          this.jdField_b_of_type_MqqOsMqqHandler.post(new MiniPie.5(this));
        }
        for (;;)
        {
          this.bEg = paramList2.size();
          break;
          QLog.w(this.TAG, 1, "listViewSrollPosition: disableScrollBottom");
        }
        if (localzos != null)
        {
          this.bEg = localzos.a(this.d, this.bEg, paramList1, paramList2);
          continue;
          if (localzos != null)
          {
            localzos.a(this.d, 0, paramList1, paramList2);
            i = paramList1.size();
            this.bEg = (paramList2.size() + this.bEg - i);
          }
        }
      }
    }
  }
  
  public void BO(boolean paramBoolean)
  {
    this.brW = paramBoolean;
  }
  
  public void BP(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "setDelaySetRead() called with: delaySetRead = [" + paramBoolean + "]");
    }
    this.brU = paramBoolean;
  }
  
  protected abstract void Ib();
  
  public boolean Vy()
  {
    this.mDensity = this.mApp.getApplication().getResources().getDisplayMetrics().density;
    this.jdField_b_of_type_MqqOsMqqHandler = new MqqHandler(Looper.getMainLooper(), this);
    this.jdField_a_of_type_Znl = new znl(this);
    this.jdField_a_of_type_Znl.CS(3);
    cql();
    initListView();
    aC();
    cqn();
    cqq();
    if (!this.brV)
    {
      cqA();
      dt(this.mContext);
    }
    cqm();
    cqk();
    aIH();
    bHZ();
    this.jdField_b_of_type_ComTencentImcoreMessageQQMessageFacade$b = new QQMessageFacade.b();
    this.jdField_b_of_type_ComTencentImcoreMessageQQMessageFacade$b.context = new wkk(this.mSessionInfo.aTl);
    this.jdField_b_of_type_ComTencentImcoreMessageQQMessageFacade$b.aQk = true;
    return true;
  }
  
  protected boolean Vz()
  {
    return false;
  }
  
  public void W(int paramInt, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "refresh with dirty: " + paramInt + "|dirty " + this.bEk + " delay " + paramLong);
    }
    if (this.bEk == paramInt) {}
    do
    {
      return;
      int i = paramInt & 0xFFFF0000;
      if ((paramInt & 0xFFFF) > (this.bEk & 0xFFFF)) {
        paramInt &= 0xFFFF;
      }
      for (;;)
      {
        this.bEk = (i | paramInt);
        if (QLog.isColorLevel()) {
          QLog.d(this.TAG, 2, "refresh with refreshFlag: " + i + " scrollFlag: " + paramInt);
        }
        if (!this.isResume) {
          break;
        }
        Message localMessage = this.jdField_b_of_type_MqqOsMqqHandler.obtainMessage();
        localMessage.what = 6;
        if (this.jdField_b_of_type_MqqOsMqqHandler.hasMessages(localMessage.what)) {
          this.jdField_b_of_type_MqqOsMqqHandler.removeMessages(localMessage.what);
        }
        this.jdField_b_of_type_MqqOsMqqHandler.sendMessageDelayed(localMessage, paramLong);
        return;
        paramInt = this.bEk & 0xFFFF;
      }
    } while (!QLog.isColorLevel());
    QLog.d(this.TAG, 2, "update hold for not in Resuming ");
  }
  
  public SpannableString a(boolean paramBoolean)
  {
    int i = 0;
    Object localObject = this.mSessionInfo;
    QQAppInterface localQQAppInterface = this.mApp;
    if ((((SessionInfo)localObject).cZ != 1) && (((SessionInfo)localObject).cZ != 3000)) {
      return null;
    }
    if ((this.mSourceMsgInfo == null) || (!TextUtils.isEmpty(this.mSourceMsgInfo.mAnonymousNickName))) {
      return null;
    }
    boolean bool1;
    String str1;
    Context localContext;
    String str2;
    String str3;
    XEditTextEx localXEditTextEx;
    if (((HotChatManager)localQQAppInterface.getManager(60)).a(((SessionInfo)localObject).aTl) != null)
    {
      bool1 = true;
      str1 = aqgv.a(localQQAppInterface, ((SessionInfo)localObject).cZ, ((SessionInfo)localObject).aTl, this.mSourceMsgInfo.mSourceMsgSenderUin + "");
      localContext = this.mContext;
      str2 = ((SessionInfo)localObject).aTl;
      str3 = this.mSourceMsgInfo.mSourceMsgSenderUin + "";
      localXEditTextEx = this.jdField_a_of_type_ComTencentWidgetXEditTextEx;
      if (((SessionInfo)localObject).cZ != 1) {
        break label224;
      }
    }
    label224:
    for (boolean bool2 = true;; bool2 = false)
    {
      localObject = appb.a(localQQAppInterface, localContext, str2, str3, str1, bool1, localXEditTextEx, bool2, true);
      if ((localObject != null) && (((SpannableString)localObject).length() > 0)) {
        break label230;
      }
      return null;
      bool1 = false;
      break;
    }
    label230:
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getEditableText().insert(0, (CharSequence)localObject);
      return localObject;
    }
    if (this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getSelectionStart() < 0) {}
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getEditableText().insert(i, (CharSequence)localObject);
      return localObject;
      i = this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getSelectionStart();
    }
  }
  
  public View a(LayoutInflater paramLayoutInflater, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null) {
      paramLayoutInflater = paramLayoutInflater.inflate(2131558931, paramViewGroup, false);
    }
    for (;;)
    {
      this.cL = ((ViewGroup)paramLayoutInflater.findViewById(2131362332));
      this.fs = ((RelativeLayout)this.cL.findViewById(2131364469));
      return paramLayoutInflater;
      paramLayoutInflater = paramView;
      if (QLog.isColorLevel())
      {
        QLog.d(this.TAG, 2, "setCustomRootView() called hit cache convertView = [" + paramView + "]");
        paramLayoutInflater = paramView;
      }
    }
  }
  
  public <T extends wvr> T a(int paramInt)
  {
    return this.jdField_a_of_type_Znl.a(paramInt);
  }
  
  public void a(int paramInt, View paramView, ListView paramListView)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "MiniPie onNotCompleteVisable");
    }
  }
  
  public void a(ChatMessage paramChatMessage, int paramInt, long paramLong, String paramString)
  {
    if (paramChatMessage == null) {}
    do
    {
      return;
      if (paramLong == 0L) {
        xmb.a(this.mApp, this.mSessionInfo, Long.parseLong(paramChatMessage.senderuin));
      }
      paramString = yfp.a(this.mApp, paramChatMessage, paramInt, paramLong, paramString);
    } while (paramString == null);
    this.mSourceMsgInfo = paramString;
    paramInt = this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getWidth();
    int i = this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getPaddingLeft();
    paramString = appe.a(this.mApp, this.mContext, this.mSourceMsgInfo, paramInt - i, this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getPaint(), null);
    if (paramString != null)
    {
      Drawable localDrawable = paramString.getDrawable();
      Rect localRect = localDrawable.getBounds();
      localDrawable.setBounds(localRect.left, localRect.top + 20, localRect.right, localRect.bottom + 20);
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setCompoundDrawables(null, paramString.getDrawable(), null, null);
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setCompoundDrawablePadding(30);
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setTag(2131374473, paramString);
      this.jdField_a_of_type_AndroidTextMethodMovementMethod = this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getMovementMethod();
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setMovementMethod(appd.getInstance());
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setPadding(this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getPaddingLeft(), this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getPaddingTop(), this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getPaddingLeft(), this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getPaddingBottom());
      if ((this.mSourceMsgInfo != null) && (!this.mApp.getCurrentUin().equals(String.valueOf(this.mSourceMsgInfo.mSourceMsgSenderUin)))) {
        a(false);
      }
      paramInt = this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getMeasuredHeight();
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setMinHeight(paramInt);
    }
    for (;;)
    {
      this.jdField_b_of_type_MqqOsMqqHandler.postDelayed(new MiniPie.11(this), 200L);
      MessageForReplyText.reportReplyMsg(this.mApp, this.mSessionInfo, paramChatMessage);
      return;
      if (this.jdField_a_of_type_AndroidTextMethodMovementMethod != null) {
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setMovementMethod(this.jdField_a_of_type_AndroidTextMethodMovementMethod);
      }
    }
  }
  
  public boolean a(int paramInt, View paramView, ListView paramListView)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "MiniPie onViewCompleteVisableAndReleased");
    }
    cjI();
    return true;
  }
  
  protected void aC()
  {
    this.iB = ((RelativeLayout)this.cL.findViewById(2131377361));
    this.mTitleText = ((TextView)this.iB.findViewById(2131379769));
    this.mTitleText.setText(this.mNickName);
    this.iC = ((RelativeLayout)this.iB.findViewById(2131369579));
    this.iC.setOnClickListener(this);
    this.iC.setVisibility(8);
    this.iD = ((RelativeLayout)this.iB.findViewById(2131377372));
    this.MV = ((TextView)this.iB.findViewById(2131379857));
    this.MV.setVisibility(8);
    ImageView localImageView1 = (ImageView)this.iD.findViewById(2131369594);
    localImageView1.setOnClickListener(this);
    if ((this.brX) && (!this.brV))
    {
      this.vr = ((ImageView)this.iD.findViewById(2131369588));
      this.vr.setOnClickListener(this);
      cqo();
    }
    if (this.brV) {
      cqp();
    }
    if ((this.mSessionInfo.bPu == 2) || (this.mSessionInfo.bPu == 5))
    {
      ImageView localImageView2 = (ImageView)this.iC.findViewById(2131368962);
      Object localObject = localImageView2.getLayoutParams();
      if ((localObject instanceof RelativeLayout.LayoutParams))
      {
        localObject = (RelativeLayout.LayoutParams)localObject;
        ((RelativeLayout.LayoutParams)localObject).width = wja.dp2px(13.5F, this.mContext.getResources());
        ((RelativeLayout.LayoutParams)localObject).height = wja.dp2px(13.5F, this.mContext.getResources());
        localImageView2.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      localImageView2.setImageResource(2130851110);
      this.iC.setVisibility(0);
      localImageView1.setImageResource(2130851259);
      if (Build.VERSION.SDK_INT >= 16) {
        localImageView1.setBackground(null);
      }
    }
    else
    {
      return;
    }
    localImageView1.setBackgroundDrawable(null);
  }
  
  public void aG() {}
  
  public void aIH()
  {
    if (this.brU) {
      return;
    }
    int i = this.mSessionInfo.cZ;
    if ((i != 1033) && (i != 1034))
    {
      i = this.mApp.a().A(this.mSessionInfo.aTl, this.mSessionInfo.cZ);
      anod.T(1, 0, this.mSessionInfo.cZ, i);
    }
    ujt.a(this.mApp, this.mSessionInfo);
    this.mApp.b().a(this.mSessionInfo.aTl, this.mSessionInfo.cZ, true, true);
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    Button localButton = this.eE;
    if (paramEditable.length() > 0) {}
    for (boolean bool = true;; bool = false)
    {
      localButton.setEnabled(bool);
      return;
    }
  }
  
  public void b(int paramInt, View paramView, ListView paramListView)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "MiniPie onViewCompleteVisable");
    }
  }
  
  protected void bFq() {}
  
  protected void bHZ()
  {
    this.mApp.addObserver(this.c);
  }
  
  protected void bIa()
  {
    if (this.mApp == null) {
      return;
    }
    this.mApp.removeObserver(this.c);
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt3 == 0)
    {
      paramCharSequence = (appb[])this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getEditableText().getSpans(paramInt1, paramInt1 + paramInt2, appb.class);
      if (QLog.isDevelopLevel()) {
        QLog.d(this.TAG, 4, "find beforeTextChanged atTroopMemberSpan1 ..." + paramCharSequence.length + ",start = " + paramInt1 + ",before = " + paramInt2);
      }
      if ((paramCharSequence != null) && (paramCharSequence.length > 0))
      {
        this.brY = true;
        znm.report("0X800A9AC", "1");
      }
    }
  }
  
  public void c(int paramInt, View paramView, ListView paramListView)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "MiniPie onViewNotCompleteVisableAndReleased");
    }
  }
  
  protected void cjI()
  {
    if ((this.jdField_a_of_type_Zni != null) && (this.jdField_a_of_type_Zni.getCount() > 0))
    {
      this.Fp = SystemClock.uptimeMillis();
      ((wkk)this.jdField_b_of_type_ComTencentImcoreMessageQQMessageFacade$b.context).fU(this.Fp);
      this.jdField_b_of_type_ComTencentImcoreMessageQQMessageFacade$b.aQi = false;
      this.jdField_b_of_type_ComTencentImcoreMessageQQMessageFacade$b.aQj = true;
      this.mApp.b().a(this.mSessionInfo.aTl, this.mSessionInfo.cZ, 20, this.jdField_b_of_type_ComTencentImcoreMessageQQMessageFacade$b);
      return;
    }
    vY(false);
  }
  
  protected void cqA()
  {
    this.ad = ((ImageButton)this.cL.findViewById(2131362411));
    this.ad.setVisibility(0);
    this.ad.setOnClickListener(this);
    wja.i(this.ad, (int)(this.mDensity * 5.0F + 0.5F), (int)(this.mDensity * 5.0F + 0.5F), 0, 0);
    if (this.brV) {
      this.ad.setVisibility(8);
    }
  }
  
  public void cqB()
  {
    ChatMessage localChatMessage = (ChatMessage)this.mApp.b().c(this.mSessionInfo.aTl, this.mSessionInfo.cZ, this.mSessionInfo.Ic);
    if (localChatMessage != null) {
      a(localChatMessage, 0, xmb.a(this.mApp, this.mSessionInfo, Long.parseLong(localChatMessage.senderuin)), null);
    }
  }
  
  protected void cqk()
  {
    List localList = this.mApp.b().a(this.uin, this.uinType, -1L, false);
    if ((localList != null) && (localList.size() > 0))
    {
      EmojiStickerManager.a().a(this.mApp, this.d, this.mSessionInfo.aTl, this.mSessionInfo.cZ, 1, localList);
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 2, "loadFirstData() called size = [" + localList.size() + "]");
      }
      this.jdField_a_of_type_Zni.a(localList, null, 0);
    }
  }
  
  protected void cql()
  {
    this.uinType = this.mSessionInfo.cZ;
    this.uin = this.mSessionInfo.aTl;
    this.mNickName = this.mSessionInfo.aTn;
    Bundle localBundle = this.mSessionInfo.getExtras();
    if (localBundle != null)
    {
      this.brU = localBundle.getBoolean("KEY_DELAY_SET_READ", false);
      this.brV = localBundle.getBoolean("KEY_IS_IN_MULTI_AIO", false);
    }
  }
  
  protected void cqm()
  {
    if (bEA == 0) {
      bEA = this.mContext.getResources().getInteger(2131427349);
    }
  }
  
  protected void cqn()
  {
    if (this.brV)
    {
      if (("1103".equals(ThemeUtil.curThemeId)) || ("2920".equals(ThemeUtil.curThemeId))) {
        this.cL.setBackgroundResource(2130851035);
      }
    }
    else {
      return;
    }
    this.cL.setBackgroundResource(2130851264);
  }
  
  protected void cqq()
  {
    this.dG = ((ViewGroup)this.cL.findViewById(2131369277));
    this.jdField_a_of_type_ComTencentWidgetXPanelContainer = ((XPanelContainer)this.cL.findViewById(2131377546));
    aG();
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx = ((XEditTextEx)this.cL.findViewById(2131369276));
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.removeTextChangedListener(this);
    try
    {
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setEditableFactory(aofr.a);
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.addTextChangedListener(this);
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setOnClickListener(this);
      this.eE = ((Button)this.cL.findViewById(2131367817));
      this.eE.setOnClickListener(this);
      Object localObject = (PanelIconLinearLayout)this.cL.findViewById(2131372847);
      ((PanelIconLinearLayout)localObject).setPanelIconListener(new zog(this));
      if (this.brV)
      {
        ((PanelIconLinearLayout)localObject).setCustomHeight(wja.dp2px(50.0F, ((PanelIconLinearLayout)localObject).getContext().getResources()));
        ((PanelIconLinearLayout)localObject).a(this.mApp, this.mSessionInfo, null, this.brV);
        if ((this.brV) && (("1103".equals(ThemeUtil.curThemeId)) || ("2920".equals(ThemeUtil.curThemeId))))
        {
          localObject = this.cL.findViewById(2131369285);
          if (localObject != null) {
            ((View)localObject).setBackgroundResource(2130850842);
          }
          this.dG.setBackgroundResource(2130850842);
          this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setBackgroundResource(2130850843);
          this.eE.setBackgroundResource(2130838363);
          this.eE.setTextColor(this.mContext.getResources().getColor(2131167290));
        }
        localObject = new zof.a(null);
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setOnEditorActionListener((TextView.OnEditorActionListener)localObject);
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setOnKeyListener((View.OnKeyListener)localObject);
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e(this.TAG, 1, "input set error", localException);
        continue;
        localException.setCustomHeight(0);
      }
    }
  }
  
  public void cqr() {}
  
  public void cqs()
  {
    if (this.brV)
    {
      tog localtog = this.mApp.a();
      if ((localtog != null) && (localtog.A(this.uin, this.uinType) > 0))
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.TAG, 2, "resumeOthersForMultiAIO() called");
        }
        W(131075, 0L);
      }
    }
  }
  
  public void cqt()
  {
    this.jdField_a_of_type_ComTencentWidgetXPanelContainer.aLz();
    this.jdField_a_of_type_Znl.CS(12);
    ((Activity)this.mContext).finish();
  }
  
  public void cqv()
  {
    if ((this.brS) && (this.jdField_b_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel != null)) {
      cqx();
    }
    this.jdField_b_of_type_MqqOsMqqHandler.postDelayed(new MiniPie.2(this), 200L);
  }
  
  protected void cqw()
  {
    if (this.jdField_b_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel != null)
    {
      if (this.brS) {
        cqx();
      }
    }
    else {
      return;
    }
    this.jdField_b_of_type_MqqOsMqqHandler.postDelayed(new MiniPie.3(this), 200L);
  }
  
  public void doOnDestroy()
  {
    this.jdField_b_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
    this.bEg = 0;
    this.bEh = 0;
    this.jdField_a_of_type_Znl.CS(13);
    ((MediaPlayerManager)this.mApp.getManager(24)).c(this.d);
    this.jdField_a_of_type_Zni.destroy();
    bIa();
    ShortVideoItemBuilder.cec();
    ShortVideoRealItemBuilder.cec();
    if (this.jdField_b_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel != null) {
      this.jdField_b_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.onDestory();
    }
    if (this.jdField_a_of_type_Aqmn != null) {
      this.jdField_a_of_type_Aqmn.destroy();
    }
    wyv.Da(2);
    ArkFlashChatContainerWrapper.Da(2);
  }
  
  public void doOnPause()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "doOnPause() called");
    }
    this.isResume = false;
    this.jdField_a_of_type_Znl.CS(9);
    if (this.jdField_b_of_type_MqqOsMqqHandler != null) {
      this.mApp.removeHandler(MiniChatActivity.class);
    }
    ApngImage.pauseByTag(0);
    ShortVideoItemBuilder.cea();
    ShortVideoRealItemBuilder.cea();
    wyv.Da(0);
    ArkFlashChatContainerWrapper.Da(0);
    NativeVideoImage.pauseAll();
    AbstractGifImage.pauseAll();
    AbstractVideoImage.pauseAll();
  }
  
  public void doOnResume()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "doOnResume() called");
    }
    this.isResume = true;
    this.mApp.setHandler(MiniChatActivity.class, this.jdField_b_of_type_MqqOsMqqHandler);
    this.jdField_a_of_type_Znl.CS(5);
    if (!this.es) {
      zz(this.mSessionInfo.aTl);
    }
    for (;;)
    {
      wyv.Da(1);
      ArkFlashChatContainerWrapper.Da(1);
      ApngImage.playByTag(0);
      NativeVideoImage.resumeAll();
      AbstractGifImage.resumeAll();
      com.etrump.mixlayout.ETTextView.enableAnimation = true;
      AbstractVideoImage.resumeAll();
      if (this.mSessionInfo.bPu == 2) {
        znm.report("0X8009C2F");
      }
      return;
      this.es = false;
    }
  }
  
  public void doOnStart()
  {
    this.jdField_a_of_type_Znl.CS(4);
  }
  
  public void doOnStop()
  {
    ShortVideoItemBuilder.cec();
    ShortVideoRealItemBuilder.cec();
    this.jdField_a_of_type_Znl.CS(10);
  }
  
  protected void dt(Context paramContext)
  {
    this.cdY = ((Activity)paramContext).getWindow().getAttributes().y;
    this.mWindowManager = ((WindowManager)paramContext.getSystemService("window"));
    this.f = new WindowManager.LayoutParams(-1, aqmn.ki(0), 2, 32, -1);
    this.f.gravity = 81;
    this.f.windowAnimations = 2131755378;
    this.jdField_a_of_type_Aqmn = new aqmn(((ViewGroup)((Activity)this.mContext).getWindow().getDecorView().findViewById(16908290)).getChildAt(0), this.mWindowManager.getDefaultDisplay().getHeight(), this.jdField_a_of_type_Aqmn$a);
    this.keyboardHeight = this.jdField_a_of_type_Aqmn.Mg();
    this.keyboardHeight = aqmn.ki(this.keyboardHeight);
    paramContext = new zoi(this);
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime instanceof QQAppInterface))
    {
      int i = this.mContext.getResources().getDimensionPixelSize(2131299627);
      this.jdField_b_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel = ((EmoticonMainPanel)View.inflate(this.mContext, 2131559281, null));
      this.jdField_b_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.setCallBack(paramContext);
      this.jdField_b_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.bYY = true;
      this.jdField_b_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.a((QQAppInterface)localAppRuntime, 100003, this.mContext, i, null, null, false);
      this.jdField_b_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.daq();
      this.f.height = this.keyboardHeight;
      this.jdField_b_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.setDispatchKeyEventListener(new zoj(this));
      return;
    }
    QLog.e(this.TAG, 1, "get QQAppInterface fail");
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      cqz();
      continue;
      zU(paramMessage.arg1);
      continue;
      xov.a(paramMessage, this.d);
      continue;
      boolean bool = aqnl.a(this.mApp, this.d);
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 2, "MSG_EFRESH_FONT_BUBBLE, needRefresh=" + bool);
      }
      if (bool) {
        this.jdField_a_of_type_Zni.notifyDataSetChanged();
      }
    }
  }
  
  protected void initListView()
  {
    this.d = ((ChatXListView)this.cL.findViewById(2131370537));
    this.d.setStackFromBottom(true);
    this.d.setTranscriptMode(0);
    this.d.setOnScrollToButtomListener(this);
    this.d.setOnScrollListener(this);
    if (this.d.getHeaderViewsCount() == 0)
    {
      localObject = new View(this.mContext);
      int i = this.mContext.getResources().getDimensionPixelSize(2131299627);
      ((View)localObject).setLayoutParams(new AbsListView.LayoutParams(-1, i));
      ((View)localObject).setId(2131362463);
      this.d.addHeaderView((View)localObject, null, false);
      this.d.setOverscrollHeaderTop(i);
    }
    vY(true);
    this.d.setOverScrollListener(this);
    this.jdField_a_of_type_Zni = new zni(this.mApp, this.mContext, this.mSessionInfo);
    this.jdField_a_of_type_Zni.a(this.d);
    Object localObject = this.jdField_a_of_type_Zni;
    if (this.mSessionInfo.bPu == 3) {}
    for (boolean bool = true;; bool = false)
    {
      ((zni)localObject).setFrom(bool);
      this.d.setAdapter(this.jdField_a_of_type_Zni);
      return;
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      cqt();
      continue;
      if (this.mSessionInfo.bPu == 2) {
        znm.report("0X8009C31");
      }
      if ((this.mSessionInfo.bPu == 2) || (this.mSessionInfo.bPu == 5))
      {
        Object localObject = wja.a(new Intent(paramView.getContext(), SplashActivity.class), new int[] { 0, 2 });
        ((Intent)localObject).putExtra("uin", this.mSessionInfo.aTl);
        ((Intent)localObject).putExtra("uintype", this.mSessionInfo.cZ);
        ((Intent)localObject).putExtra("troop_uin", this.mSessionInfo.troopUin);
        ((Intent)localObject).putExtra("uinname", this.mSessionInfo.aTn);
        if ((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface)) {
          ((znv)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getBusinessHandler(147)).cpW();
        }
        znx.a().notifyFromMiniAIOToAIO();
        paramView.getContext().startActivity((Intent)localObject);
        cqt();
        continue;
        localObject = (zos)a(1);
        if (localObject != null) {
          ((zos)localObject).bsq();
        }
        this.brY = false;
        int i = 200;
        if (this.mSessionInfo.getExtras() != null) {
          i = this.mSessionInfo.getExtras().getInt("key_mini_msgtab_businame");
        }
        anot.a(null, "dc00898", "", "", "0X800A194", "0X800A194", i, 1, "", "", "", "");
        continue;
        if (QLog.isColorLevel()) {
          QLog.d(this.TAG, 2, "onClick case R.id.input");
        }
        cqv();
        continue;
        if (QLog.isColorLevel()) {
          QLog.d(this.TAG, 2, "onClick case aio_input_right_btn");
        }
        localObject = (ImageButton)paramView;
        if (this.cdZ == 0)
        {
          this.cdZ = 1;
          ((ImageButton)localObject).setImageResource(2130840507);
          this.jdField_a_of_type_ComTencentWidgetXPanelContainer.aLz();
          cqw();
        }
        else
        {
          this.cdZ = 0;
          ((ImageButton)localObject).setImageResource(2130838215);
          cqv();
          continue;
          this.bEg = this.jdField_a_of_type_Zni.getCount();
          if (this.bEg > 0) {
            this.d.setSelectionFromBottom(this.d.getCount() - 1, 0);
          }
          paramView.setVisibility(8);
          continue;
          cqu();
        }
      }
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    paramAbsListView = (zos)a(1);
    if (paramAbsListView != null) {
      paramAbsListView.onScroll(paramInt1, paramInt2, paramInt3);
    }
    this.jdField_a_of_type_Znl.CS(19);
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt == 0)
    {
      xvu.setScrolling(false);
      this.jdField_a_of_type_Zni.bYV();
      VasFaceManager.resume();
      URLDrawable.resume();
      AbstractGifImage.resumeAll();
      AbstractVideoImage.resumeAll();
      ApngImage.playByTag(0);
      com.etrump.mixlayout.ETTextView.enableAnimation = true;
      return;
    }
    AbstractGifImage.pauseAll();
    xvu.setScrolling(true);
    if (paramInt == 2) {
      this.jdField_a_of_type_Zni.bYU();
    }
    for (;;)
    {
      VasFaceManager.pause();
      URLDrawable.pause();
      AbstractGifImage.pauseAll();
      ApngImage.pauseByTag(0);
      com.etrump.mixlayout.ETTextView.enableAnimation = false;
      AbstractVideoImage.pauseAll();
      return;
      this.jdField_a_of_type_Zni.bYV();
    }
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((this.brY) && (paramInt3 == 1) && ((paramCharSequence.charAt(paramInt1) == 65312) || (paramCharSequence.charAt(paramInt1) == '@'))) {
      znm.report("0X800A9AE");
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    if ((paramBoolean) && (!this.brT))
    {
      this.brT = true;
      if ((this.mSessionInfo.bPu == 2) || (this.mSessionInfo.bPu == 5)) {
        this.jdField_b_of_type_MqqOsMqqHandler.postDelayed(new MiniPie.8(this), 200L);
      }
    }
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, hashCode() + " update");
    }
    if (!this.isResume) {}
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            if (!(paramObject instanceof ChatMessage)) {
              break;
            }
            paramObservable = (MessageRecord)paramObject;
            if (QLog.isColorLevel()) {
              QLog.d(this.TAG, 2, "update mr.msgseq" + paramObservable.msgseq + ",time is:" + System.currentTimeMillis() + " status:" + paramObservable.extraflag);
            }
            if (z(paramObservable))
            {
              aIH();
              ((ChatMessage)paramObject).mMsgAnimFlag = true;
              if (paramObservable.isSendFromLocal())
              {
                W(131075, 0L);
                return;
              }
              W(131072, 0L);
              return;
            }
          } while (!QLog.isColorLevel());
          QLog.d(this.TAG, 2, "update--> isNeedUpdate false  isResume " + this.isResume);
          return;
          if (!(paramObject instanceof QQMessageFacade.b)) {
            break;
          }
          paramObservable = (QQMessageFacade.b)paramObject;
          paramObject = (wkk)paramObservable.context;
        } while ((this.mSessionInfo.aTl == null) || (!this.mSessionInfo.aTl.equals(paramObject.pf())));
        if ((this.Fp == paramObject.em()) && (paramObservable.aQk) && (paramObservable.aQh))
        {
          long l = this.Fp + 300L - SystemClock.uptimeMillis();
          if (l > 0L) {}
          for (;;)
          {
            W(131076, l);
            return;
            l = 0L;
          }
        }
      } while (!QLog.isColorLevel());
      QLog.d(this.TAG, 2, "refreshMessageContext sync theSameUinAIO return");
      return;
    } while (!QLog.isColorLevel());
    QLog.d(this.TAG, 2, "update--> do nothing");
  }
  
  protected void vU(boolean paramBoolean)
  {
    if ((paramBoolean) && (this.MV.getVisibility() == 8))
    {
      this.MV.setVisibility(0);
      this.mTitleText.setTextSize(1, 17.0F);
    }
    while ((paramBoolean) || (this.MV.getVisibility() != 0)) {
      return;
    }
    this.MV.setVisibility(8);
    this.mTitleText.setTextSize(1, 17.0F);
  }
  
  protected void vY(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.d.getOverScrollHeaderView() == null)
      {
        if (this.xO == null) {
          this.xO = LayoutInflater.from(this.mContext).inflate(2131559032, null);
        }
        ViewParent localViewParent = this.xO.getParent();
        if (localViewParent != null) {
          ((ViewGroup)localViewParent).removeView(this.xO);
        }
        this.d.setOverScrollHeader(this.xO);
      }
      return;
    }
    this.d.setOverscrollHeader((Drawable)null);
    this.d.setOverScrollHeader((View)null);
  }
  
  protected boolean z(MessageRecord paramMessageRecord)
  {
    return (hp(paramMessageRecord.istroop)) && (hp(this.mSessionInfo.cZ)) && (this.mSessionInfo.aTl.equals(paramMessageRecord.frienduin)) && (this.mSessionInfo.cZ == paramMessageRecord.istroop);
  }
  
  public void zz(String paramString)
  {
    if ((this.uin != null) && (this.uin.equals(paramString))) {
      W(131073, 0L);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d(this.TAG, 2, "onlyRefreshData not me");
  }
  
  class a
    implements View.OnKeyListener, TextView.OnEditorActionListener
  {
    private a() {}
    
    public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
    {
      return false;
    }
    
    public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
    {
      boolean bool2 = false;
      boolean bool1 = bool2;
      if (paramKeyEvent.getKeyCode() == 67)
      {
        bool1 = bool2;
        if (paramKeyEvent.getAction() == 0)
        {
          if (QLog.isColorLevel()) {
            QLog.i(zof.this.TAG, 2, "on delete, start: " + zof.this.a.getSelectionStart() + ", end: " + zof.this.a.getSelectionEnd() + ", span: " + zof.this.a.getTag(2131374473));
          }
          if ((zof.this.a.getSelectionStart() != 0) || (zof.this.a.getSelectionEnd() != 0)) {
            break label243;
          }
          bool1 = bool2;
          if (zof.this.a.getTag(2131374473) != null)
          {
            paramKeyEvent = zof.this.a.getCompoundDrawables();
            zof.this.a.setCompoundDrawables(paramKeyEvent[0], null, paramKeyEvent[2], paramKeyEvent[3]);
            zof.this.a.setTag(2131374473, null);
            zof.this.a.setSelection(0);
            zof.this.a.setMinHeight(wja.dp2px(36.0F, paramView.getResources()));
            zof.this.mSourceMsgInfo = null;
            bool1 = true;
          }
        }
      }
      label243:
      do
      {
        do
        {
          do
          {
            return bool1;
            bool1 = bool2;
          } while (zof.this.a.getTag(2131374473) == null);
          bool1 = bool2;
        } while (Build.VERSION.SDK_INT < 21);
        bool1 = bool2;
      } while (wja.dp2px(36.0F, paramView.getResources()) != zof.this.a.getMinHeight());
      paramInt = zof.this.a.getMeasuredHeight();
      zof.this.a.setMinHeight(paramInt);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zof
 * JD-Core Version:    0.7.0.1
 */