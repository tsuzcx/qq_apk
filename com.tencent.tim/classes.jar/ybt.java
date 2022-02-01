import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.troopgift.TroopGiftPanel;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.ChatSettingActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.NearbyChatPie.1;
import com.tencent.mobileqq.activity.aio.rebuild.NearbyChatPie.14;
import com.tencent.mobileqq.activity.aio.rebuild.NearbyChatPie.2;
import com.tencent.mobileqq.activity.aio.rebuild.NearbyChatPie.3;
import com.tencent.mobileqq.activity.aio.rebuild.NearbyChatPie.7;
import com.tencent.mobileqq.activity.aio.rebuild.NearbyChatPie.8;
import com.tencent.mobileqq.activity.aio.rebuild.NearbyChatPie.9;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForDeliverGiftTips;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.nearby.gift.TroopGiftPanelForNearby;
import com.tencent.open.adapter.OpenAppClient;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XEditTextEx;
import java.util.Observable;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.MobileQQ;

public class ybt
  extends BaseChatPie
{
  protected achq a;
  acnd a;
  protected ajtx a;
  protected TroopGiftPanelForNearby a;
  String aXe;
  String aXf = this.mActivity.getIntent().getStringExtra("from_where_to_aio");
  public String aXg;
  aclp jdField_b_of_type_Aclp = new ybv(this);
  ajqz jdField_b_of_type_Ajqz = new ybx(this);
  int bYq = 0;
  public boolean blh;
  protected boolean bli;
  boolean blj = false;
  boolean blk = false;
  boolean bll = false;
  acfd c = new ybu(this);
  byte[] cq = null;
  public boolean isFirstTime = true;
  public int mGender = -1;
  protected boolean mIsFollowed = true;
  
  public ybt(QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, FragmentActivity paramFragmentActivity, Context paramContext)
  {
    super(paramQQAppInterface, paramViewGroup, paramFragmentActivity, paramContext);
    this.jdField_a_of_type_Achq = new ycc(this);
    this.jdField_a_of_type_Acnd = new ybw(this);
  }
  
  private void a(Integer paramInteger, String paramString)
  {
    switch (paramInteger.intValue())
    {
    default: 
      return;
    case 1: 
      ((ajpj)this.app.getManager(106)).go.put(this.sessionInfo.aTl, Integer.valueOf(1));
      paramString = this.app;
      localObject = this.sessionInfo.aTl;
      if (this.sessionInfo.cZ == 1001)
      {
        paramInteger = "2";
        if (this.sessionInfo.cZ == 1001) {}
        acig.a(paramString, (String)localObject, paramInteger, "1", 2, new yca(this));
        paramString = (aizg)this.app.getManager(16);
        localObject = this.app;
        if (this.sessionInfo.cZ != 1001) {
          break label198;
        }
        paramInteger = "0";
        label152:
        if (!paramString.nf(this.sessionInfo.aTl)) {
          break label204;
        }
      }
      label198:
      label204:
      for (paramString = "1";; paramString = "0")
      {
        anot.a((QQAppInterface)localObject, "dc00899", "grp_lbs", "", "c2c_tmp", "follow_aio", 0, 0, paramInteger, "0", paramString, "");
        return;
        paramInteger = "1";
        break;
        paramInteger = "1";
        break label152;
      }
    }
    ChatActivityUtils.a(this.app, this.mActivity, this.sessionInfo.cZ, paramString, this.sessionInfo.phoneNum, false);
    if (this.sessionInfo.cZ == 1010) {
      anot.a(this.app, "CliOper", "", this.sessionInfo.aTl, "0X8004953", "0X8004953", 0, 0, "", "", "", "");
    }
    Object localObject = this.app;
    if (this.sessionInfo.cZ == 1001)
    {
      paramInteger = "0";
      if (!this.mIsFollowed) {
        break label342;
      }
    }
    label342:
    for (paramString = "0";; paramString = "1")
    {
      anot.a((QQAppInterface)localObject, "dc00899", "grp_lbs", "", "c2c_tmp", "block_aio", 0, 0, paramInteger, "0", paramString, "");
      return;
      paramInteger = "1";
      break;
    }
  }
  
  private void cgJ()
  {
    if (a().getIntent().getBooleanExtra("from_newer_guide", false))
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("has_operation", this.blk);
      localIntent.putExtra("uin", a().getIntent().getStringExtra("tinyId"));
      a().setResult(-1, localIntent);
    }
  }
  
  public void Ib()
  {
    this.TAG = "NearbyChatPie";
  }
  
  public boolean OI()
  {
    return true;
  }
  
  public boolean OL()
  {
    aizg localaizg = (aizg)this.app.getManager(16);
    return (!this.mIsFollowed) && (!localaizg.nf(this.sessionInfo.aTl)) && (!isFullScreenMode());
  }
  
  public boolean ON()
  {
    return (this.sessionInfo.cZ != 1001) && (this.sessionInfo.cZ != 10002) && (this.sessionInfo.cZ != 1010);
  }
  
  public void aj(boolean paramBoolean, int paramInt)
  {
    Object localObject1 = (InputMethodManager)a().getSystemService("input_method");
    Object localObject2 = a().getWindow().peekDecorView();
    if ((localObject2 != null) && (((View)localObject2).getWindowToken() != null)) {
      ((InputMethodManager)localObject1).hideSoftInputFromWindow(((View)localObject2).getWindowToken(), 0);
    }
    boolean bool;
    if (this.jdField_a_of_type_Ajtx == null)
    {
      localObject1 = this.app;
      localObject2 = a();
      yby localyby = new yby(this);
      if (this.sessionInfo.cZ == 10002)
      {
        bool = true;
        this.jdField_a_of_type_ComTencentMobileqqNearbyGiftTroopGiftPanelForNearby = new TroopGiftPanelForNearby((QQAppInterface)localObject1, (Context)localObject2, localyby, true, false, bool, this);
        this.jdField_a_of_type_Ajtx = new ajtx(this.app, a(), this.sessionInfo, this.jdField_a_of_type_ComTencentMobileqqNearbyGiftTroopGiftPanelForNearby, this.mAIORootView, false, true);
      }
    }
    else
    {
      localObject1 = this.jdField_a_of_type_Ajtx;
      if (this.sessionInfo.cZ != 10002) {
        break label190;
      }
    }
    label190:
    for (paramInt = 8;; paramInt = 6)
    {
      ((ajtx)localObject1).m(paramBoolean, true, paramInt);
      hidePanel();
      return;
      bool = false;
      break;
    }
  }
  
  public void bGK()
  {
    if (this.bli) {
      return;
    }
    super.bGK();
    yiy localyiy = new yiy(this.app, this.sessionInfo, this.jdField_a_of_type_Yjh);
    localyiy.Eb(this.mGender);
    this.jdField_a_of_type_Yjh.a(localyiy);
  }
  
  public void bGL()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "showAddFriendAndShield() ==== called.");
    }
    Object localObject2;
    RelativeLayout.LayoutParams localLayoutParams;
    if (this.linearLayout == null)
    {
      localObject2 = new ybz(this);
      this.linearLayout = ((LinearLayout)LayoutInflater.from(this.mContext).inflate(2131560143, null));
      this.linearLayout.setId(2131362563);
      this.linearLayout.setVisibility(8);
      localLayoutParams = new RelativeLayout.LayoutParams(-1, (int)this.app.getApplication().getResources().getDimension(2131297949));
      localLayoutParams.addRule(3, 2131377361);
      if (this.aey)
      {
        localLayoutParams.topMargin -= wja.dp2px(3.0F, this.app.getApplication().getResources());
        this.CB = ((TextView)this.linearLayout.findViewById(2131374324));
        TextView localTextView = this.CB;
        if (!this.mIsFollowed) {
          break label578;
        }
        localObject1 = acfp.m(2131708669);
        label181:
        localTextView.setText((CharSequence)localObject1);
        this.CB.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(2131296477));
        this.CB.setContentDescription(this.CB.getText());
        this.CB.setGravity(17);
        this.CB.setOnClickListener((View.OnClickListener)localObject2);
        this.CB.setTag(Integer.valueOf(1));
        this.CA = ((TextView)this.linearLayout.findViewById(2131374325));
        this.CA.setText(acfp.m(2131708671));
        this.CA.setTag(Integer.valueOf(2));
        if ((this.sessionInfo.cZ != 1006) || ((this.sessionInfo.aTo != null) && (!this.sessionInfo.aTo.equals("")))) {
          break label588;
        }
        this.CA.setEnabled(false);
        this.CA.setClickable(false);
        label347:
        this.CA.setGravity(17);
        this.CA.setTextSize(0, this.app.getApplication().getResources().getDimension(2131296477));
        this.CA.setOnClickListener((View.OnClickListener)localObject2);
        ((RelativeLayout.LayoutParams)this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.getLayoutParams()).addRule(3, 2131362563);
        this.cL.addView(this.linearLayout, localLayoutParams);
      }
    }
    else
    {
      this.linearLayout.setVisibility(0);
      localObject1 = this.mAIORootView.findViewById(2131374819);
      if (localObject1 != null)
      {
        localObject2 = (RelativeLayout.LayoutParams)((View)localObject1).getLayoutParams();
        int j = (int)this.mActivity.getResources().getDimension(2131297949) + (int)this.mActivity.getResources().getDimension(2131299627);
        int i = j;
        if (this.aey) {
          i = j - wja.dp2px(3.0F, this.app.getApplication().getResources());
        }
        ((RelativeLayout.LayoutParams)localObject2).topMargin = i;
        ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      }
      localObject2 = this.app;
      if (this.sessionInfo.cZ != 1001) {
        break label607;
      }
    }
    label578:
    label588:
    label607:
    for (Object localObject1 = "0";; localObject1 = "1")
    {
      anot.a((QQAppInterface)localObject2, "dc00899", "grp_lbs", "", "c2c_tmp", "exp_aio_float", 0, 0, (String)localObject1, "", "", "");
      return;
      localLayoutParams.topMargin = 0;
      break;
      localObject1 = acfp.m(2131708668);
      break label181;
      this.CA.setEnabled(true);
      this.CA.setClickable(true);
      break label347;
    }
  }
  
  public void bGT()
  {
    if ((this.sessionInfo.cZ == 1009) || (this.sessionInfo.cZ == 10002) || (this.sessionInfo.cZ == 1001))
    {
      super.bGT();
      return;
    }
    this.ps.setOnClickListener(new ycb(this));
    if (ixa.a().cD(this.app.getCurrentAccountUin()))
    {
      this.ps.setVisibility(0);
      this.ps.setContentDescription(this.mActivity.getResources().getString(2131700698));
      return;
    }
    this.ps.setVisibility(8);
  }
  
  public void bGY()
  {
    Intent localIntent = new Intent(this.mActivity, ChatSettingActivity.class);
    localIntent.putExtra("uin", this.sessionInfo.aTl);
    localIntent.putExtra("uinname", this.sessionInfo.aTn);
    localIntent.putExtra("uintype", this.sessionInfo.cZ);
    localIntent.putExtra("add_friend_source_id", this.sessionInfo.bPt);
    localIntent.putExtra("follow_flag", this.mIsFollowed);
    this.mActivity.startActivityForResult(localIntent, 2000);
  }
  
  public void bHA()
  {
    super.bHA();
  }
  
  public void bHE()
  {
    super.bHE();
  }
  
  public void bHM()
  {
    super.bHM();
    int i;
    if ((this.sessionInfo.cZ == 1001) || (this.sessionInfo.cZ == 10002))
    {
      Object localObject = this.mContext;
      if (this.sessionInfo.cZ != 1001) {
        break label168;
      }
      i = 2131700709;
      localObject = ((Context)localObject).getString(i);
      vU(true);
      this.Cu.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
      this.cJ.setOnClickListener(null);
      this.cK.setOnClickListener(null);
      this.Cu.setText((CharSequence)localObject);
      if (aTl) {
        this.Cu.setContentDescription((CharSequence)localObject);
      }
      if ((this.sessionInfo.cZ != 10002) || (this.app.a().R(this.sessionInfo.aTl) != null)) {
        break label175;
      }
      i = 1;
    }
    for (;;)
    {
      if (i != -1) {
        ajrk.A(this.app, this.sessionInfo.aTl, i);
      }
      return;
      label168:
      i = 2131696065;
      break;
      label175:
      if ((this.sessionInfo.cZ == 1001) && (this.app.a().T(this.sessionInfo.aTl) == null)) {
        i = 0;
      } else {
        i = -1;
      }
    }
  }
  
  public void bHZ()
  {
    super.bHZ();
    this.app.addObserver(this.jdField_a_of_type_Achq);
    this.app.addObserver(this.jdField_b_of_type_Aclp);
    this.app.addObserver(this.jdField_b_of_type_Ajqz);
    this.app.addObserver(this.jdField_a_of_type_Acnd);
    this.app.addObserver(this.c);
  }
  
  public void bHa()
  {
    this.sessionInfo.aTn = aqgv.G(this.app, this.sessionInfo.aTl);
  }
  
  public void bHy()
  {
    super.bHy();
    this.blh = false;
  }
  
  public void bIa()
  {
    super.bIa();
    this.app.removeObserver(this.jdField_a_of_type_Achq);
    this.app.removeObserver(this.jdField_b_of_type_Aclp);
    this.app.removeObserver(this.jdField_b_of_type_Ajqz);
    this.app.removeObserver(this.jdField_a_of_type_Acnd);
    this.app.removeObserver(this.c);
  }
  
  public void bIp()
  {
    if (this.bli) {
      return;
    }
    super.bIp();
  }
  
  public void bJf()
  {
    super.bJf();
    this.jdField_a_of_type_Wvm.a(this);
  }
  
  public void bo(Intent paramIntent)
  {
    String str = paramIntent.getStringExtra("uinname");
    paramIntent = str;
    if (TextUtils.isEmpty(str)) {
      paramIntent = aqgv.G(this.app, this.sessionInfo.aTl);
    }
    this.sessionInfo.aTn = paramIntent;
    this.mActivity.runOnUiThread(new NearbyChatPie.3(this));
    if (QLog.isDevelopLevel()) {
      afck.l(this.TAG, new Object[] { "updateSession_updateTitle", this.sessionInfo.aTn });
    }
  }
  
  public void bs(Intent paramIntent)
  {
    super.bs(paramIntent);
    aqmq.track(null, "AIO_updateSession_business");
    if (this.sessionInfo.cZ == 1009)
    {
      paramIntent = paramIntent.getByteArrayExtra("rich_status_sig");
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 2, "From chatActivity : sameState Sig--->" + aqhs.bytes2HexStr(paramIntent));
      }
      if (paramIntent != null) {
        this.app.a().r(this.sessionInfo.aTl, paramIntent);
      }
    }
    for (;;)
    {
      this.aSu = this.bli;
      if (-1 == this.mGender) {
        ThreadManager.post(new NearbyChatPie.2(this), 8, null, false);
      }
      aqmq.track("AIO_updateSession_business", null);
      return;
      if ((this.sessionInfo.cZ == 1001) || (this.sessionInfo.cZ == 10002))
      {
        this.mGender = paramIntent.getIntExtra("gender", -1);
        byte[] arrayOfByte = paramIntent.getByteArrayExtra("rich_accost_sig");
        if (QLog.isColorLevel()) {
          QLog.d(this.TAG, 2, "From chatActivity : accost Sig--->" + aqhs.bytes2HexStr(arrayOfByte));
        }
        if (arrayOfByte != null) {
          this.app.a().s(this.sessionInfo.aTl, arrayOfByte);
        }
        if (2 == paramIntent.getExtras().getInt("cSpecialFlag")) {
          ujt.h(this.app, this.sessionInfo);
        } else {
          ThreadManager.post(new NearbyChatPie.1(this), 5, null, false);
        }
      }
      else if (this.sessionInfo.cZ == 1010)
      {
        this.mGender = paramIntent.getIntExtra("gender", -1);
        this.bYq = paramIntent.getIntExtra("dating_from_id", 0);
        paramIntent = paramIntent.getByteArrayExtra("rich_date_sig");
        if (paramIntent != null) {
          this.app.a().w(this.sessionInfo.aTl, paramIntent);
        }
      }
    }
  }
  
  public void bzx()
  {
    if (this.jdField_a_of_type_Ajtx != null) {
      this.jdField_a_of_type_Ajtx.hide();
    }
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt2 == -1) && (paramInt1 == 2000) && (paramIntent != null)) {
      this.mIsFollowed = paramIntent.getBooleanExtra("follow_flag", false);
    }
    if ((paramInt1 == 12007) && (this.jdField_a_of_type_ComTencentMobileqqNearbyGiftTroopGiftPanelForNearby != null)) {
      this.jdField_a_of_type_ComTencentMobileqqNearbyGiftTroopGiftPanelForNearby.a(null);
    }
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
  }
  
  public void doOnStop()
  {
    super.doOnStop();
  }
  
  public void g(Intent paramIntent, int paramInt)
  {
    super.g(paramIntent, paramInt);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return super.handleMessage(paramMessage);
    }
    this.blh = false;
    paramMessage = (String)paramMessage.obj;
    ujt.d(this.app, this.mActivity, this.sessionInfo, paramMessage);
    return true;
  }
  
  public boolean onBackEvent()
  {
    cgJ();
    if ((this.jdField_a_of_type_Ajtx != null) && (this.jdField_a_of_type_Ajtx.isShow()))
    {
      this.jdField_a_of_type_Ajtx.hide();
      super.onBackEvent();
      return true;
    }
    return super.onBackEvent();
  }
  
  public void onShow()
  {
    super.onShow();
    ThreadManager.post(new NearbyChatPie.14(this), 8, null, true);
  }
  
  public void send()
  {
    if (this.jdField_a_of_type_ComTencentWidgetXEditTextEx != null) {}
    for (String str = this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString();; str = null)
    {
      super.send();
      if ((this.aXe != null) && (this.aXe.length() > 0) && (this.aXe.equals(str))) {
        ThreadManager.post(new NearbyChatPie.8(this, str), 5, null, false);
      }
      this.aXe = null;
      if ((this.aXf != null) && (this.aXf.equals("nearby_recommend_people")) && (this.isFirstTime)) {
        ThreadManager.post(new NearbyChatPie.9(this), 1, null, false);
      }
      this.blk = true;
      return;
    }
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    super.update(paramObservable, paramObject);
    if (((paramObject instanceof MessageRecord)) && ((paramObject instanceof ChatMessage)))
    {
      paramObservable = (MessageRecord)paramObject;
      if ((paramObservable.istroop == 0) && (!this.bll))
      {
        this.bll = true;
        a().runOnUiThread(new NearbyChatPie.7(this));
      }
      if ((this.sessionInfo.cZ == 1010) && ((this.bYq == 2) || (this.bYq == 3)) && (paramObservable.isSendFromLocal()) && (aqft.equalsWithNullCheck(paramObservable.senderuin, this.app.getCurrentAccountUin())))
      {
        if (this.bYq != 2) {
          break label328;
        }
        anot.a(this.app, "CliOper", "", this.sessionInfo.aTl, "0X8004946", "0X8004946", 0, 0, "", "", "", "");
      }
    }
    for (;;)
    {
      this.bYq = 0;
      if ((!paramObservable.isSendFromLocal()) && (this.sessionInfo.aTl.equals(paramObservable.frienduin)) && ((this.sessionInfo.cZ == paramObservable.istroop) || ((top.fv(this.sessionInfo.cZ)) && (top.fv(paramObservable.istroop)))) && ((this.sessionInfo.cZ == 1001) || (this.sessionInfo.cZ == 10002)) && (paramObservable.msgtype == -3001))
      {
        paramObservable = this.app.b().a();
        if ((paramObservable != null) && (paramObservable.istroop == 1001) && (paramObservable.msgtype == -3001)) {
          OpenAppClient.da(this.mActivity.getApplicationContext(), paramObservable.action);
        }
      }
      if ((this.mActivity.isResume()) && ((paramObject instanceof MessageForDeliverGiftTips))) {
        wi(false);
      }
      return;
      label328:
      anot.a(this.app, "CliOper", "", this.sessionInfo.aTl, "0X8004945", "0X8004945", 0, 0, "", "", "", "");
    }
  }
  
  public void vW(boolean paramBoolean)
  {
    cgJ();
    super.vW(paramBoolean);
  }
  
  public void wh(boolean paramBoolean)
  {
    aj(paramBoolean, TroopGiftPanel.byn);
  }
  
  public boolean z(MessageRecord paramMessageRecord)
  {
    return (this.sessionInfo.aTl.equals(paramMessageRecord.frienduin)) && ((this.sessionInfo.cZ == paramMessageRecord.istroop) || ((top.fv(this.sessionInfo.cZ)) && (top.fv(paramMessageRecord.istroop))));
  }
  
  public void zZ(int paramInt)
  {
    super.zZ(paramInt);
    ((aizh)this.app.getManager(303)).a(this.sessionInfo, this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     ybt
 * JD-Core Version:    0.7.0.1
 */