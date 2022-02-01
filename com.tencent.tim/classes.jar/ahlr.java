import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.businessCard.data.CardOCRInfo;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.forward.ForwardShareCardOption.1;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsShareMsg.a;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTitle;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.net.URLEncoder;
import java.util.List;
import java.util.Set;
import mqq.manager.TicketManager;

public class ahlr
  extends ahgq
{
  acdt a;
  private int atV = -1;
  private acdv jdField_b_of_type_Acdv = new ahlu(this);
  private ashx jdField_b_of_type_Ashx = new ahlt(this);
  AbsStructMsg jdField_b_of_type_ComTencentMobileqqStructmsgAbsStructMsg;
  private String bKO;
  private String bKP;
  private String bKQ;
  private String bKR;
  private String bKS;
  private String bKT;
  private int bPd;
  private boolean chr;
  boolean chs;
  AbsShareMsg d;
  private int dac;
  private String mName;
  private String mTroopName;
  private String mTroopUin;
  private String mUin;
  private int mUinType;
  private acnd o = new ahls(this);
  
  public ahlr(Intent paramIntent)
  {
    super(paramIntent);
  }
  
  private void M(String paramString1, String paramString2, boolean paramBoolean)
  {
    this.chs = true;
    paramString1 = a(this.app, this.mActivity, paramString1, paramString2, paramBoolean);
    this.bf.putByteArray("stuctmsg_bytes", paramString1.getBytes());
    this.d = paramString1;
    dnB();
  }
  
  private View a(String paramString, Drawable paramDrawable)
  {
    View localView = LayoutInflater.from(this.mActivity).inflate(2131559150, null);
    TextView localTextView = (TextView)localView.findViewById(2131381145);
    ImageView localImageView = (ImageView)localView.findViewById(2131369092);
    localTextView.setText(paramString);
    localImageView.setImageDrawable(paramDrawable);
    return localView;
  }
  
  private static anqv a(String paramString)
  {
    anug localanug = new anug();
    localanug.Vs(1);
    localanug.Rn(paramString);
    return localanug;
  }
  
  public static final AbsShareMsg a(QQAppInterface paramQQAppInterface, Activity paramActivity, String paramString1, String paramString2, boolean paramBoolean)
  {
    Object localObject1 = new AbsShareMsg.a(StructMsgForGeneralShare.class);
    if (paramString2 == null)
    {
      paramQQAppInterface = "";
      Object localObject2 = new StringBuilder().append("mqqapi://card/show_pslcard?src_type=internal_phone&source=sharecard&nickname=").append(URLEncoder.encode(paramQQAppInterface));
      if (!paramBoolean) {
        break label295;
      }
      paramString2 = "";
      label47:
      localObject2 = paramString2 + "&version=1&uin=" + paramString1 + "";
      paramString2 = ((AbsShareMsg.a)localObject1).c(84).a(2).a(acfp.m(2131706513) + paramQQAppInterface).a("plugin", "", "AppCmd://OpenContactInfo/?uin=", (String)localObject2, (String)localObject2).d(paramActivity.getResources().getString(2131718646)).a();
      localObject1 = new antd();
      ((anqv)localObject1).Vs(1);
      ((anqv)localObject1).a(new ansr((String)localObject2));
      ((anqv)localObject1).a(new StructMsgItemTitle(paramQQAppInterface));
      if (!paramString1.startsWith("+86")) {
        break label335;
      }
    }
    label295:
    label335:
    for (paramQQAppInterface = paramString1.substring("+86".length(), paramString1.length());; paramQQAppInterface = paramString1)
    {
      if (paramBoolean) {}
      for (paramActivity = acfp.m(2131706536);; paramActivity = acfp.m(2131706518))
      {
        paramQQAppInterface = new anux(paramActivity + paramQQAppInterface);
        paramQQAppInterface.Rp(paramActivity + paramString1);
        ((anqv)localObject1).a(paramQQAppInterface);
        paramString2.addItem(a(acfp.m(2131706543)));
        paramString2.addItem((anqu)localObject1);
        return paramString2;
        paramQQAppInterface = paramString2.trim();
        break;
        paramString2 = "&headtext=" + URLEncoder.encode(aqgv.ps(paramQQAppInterface));
        break label47;
      }
    }
  }
  
  private void c(CardOCRInfo paramCardOCRInfo)
  {
    if (paramCardOCRInfo == null) {
      return;
    }
    Object localObject2 = new AbsShareMsg.a(StructMsgForGeneralShare.class);
    if (paramCardOCRInfo.name == null) {
      paramCardOCRInfo.name = "";
    }
    Object localObject1;
    if ((paramCardOCRInfo.mobilesNum != null) && (paramCardOCRInfo.mobilesNum.size() > 0))
    {
      localObject1 = (String)paramCardOCRInfo.mobilesNum.get(0);
      if (TextUtils.isEmpty((CharSequence)localObject1)) {}
    }
    for (;;)
    {
      Object localObject3 = "url=" + paramCardOCRInfo.picUrl + ";name=" + paramCardOCRInfo.name + ";phone=" + (String)localObject1;
      localObject2 = ((AbsShareMsg.a)localObject2).c(73).a(this.mActivity.getString(2131700746, new Object[] { paramCardOCRInfo.name })).a(2).a("shareBusinessCard", "", (String)localObject3, (String)localObject3, (String)localObject3).d(this.mActivity.getResources().getString(2131720040)).a();
      localObject3 = new anug();
      ((anqv)localObject3).Vs(1);
      ((anqv)localObject3).Rn(this.mActivity.getString(2131700743));
      antd localantd = new antd();
      localantd.Vs(3);
      localantd.a(new ansr(paramCardOCRInfo.picUrl + "/?02"));
      localantd.a(new StructMsgItemTitle(paramCardOCRInfo.name));
      localantd.a(new anux((String)localObject1));
      ((AbsShareMsg)localObject2).addItem((anqu)localObject3);
      ((AbsShareMsg)localObject2).addItem(localantd);
      localObject1 = new Bundle();
      ((Bundle)localObject1).putInt("req_type", 5);
      ((Bundle)localObject1).putString("image_url", paramCardOCRInfo.picUrl);
      adzx.Hj(paramCardOCRInfo.picUrl);
      this.jdField_b_of_type_ComTencentMobileqqStructmsgAbsStructMsg = anre.a(((StructMsgForImageShare)anre.a((Bundle)localObject1)).getBytes());
      this.bf.putByteArray("stuctmsg_bytes", ((AbsShareMsg)localObject2).getBytes());
      dnB();
      return;
      localObject1 = "";
    }
  }
  
  private View cf()
  {
    if (this.d != null)
    {
      new RelativeLayout.LayoutParams(-1, -2).setMargins(wja.dp2px(-15.0F, this.mActivity.getResources()), 0, wja.dp2px(-15.0F, this.mActivity.getResources()), 0);
      if (QLog.isColorLevel()) {
        QLog.d("ForwardOption.ForwardShareCardOption", 2, "updateImageView addStructView");
      }
      return this.d.getPreDialogView(this.mActivity, null);
    }
    return new View(this.mActivity);
  }
  
  private void cl(String paramString, boolean paramBoolean)
  {
    Object localObject = (TicketManager)this.app.getManager(2);
    int i = ((acdu)this.app.getManager(53)).cn(paramString);
    localObject = ((TicketManager)localObject).getSkey(this.app.getAccount());
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      ThreadManager.post(new ForwardShareCardOption.1(this, i, paramString, (String)localObject, paramBoolean), 8, null, false);
      return;
    }
    hideProgressDialog();
    QQToast.a(this.mActivity, -1, acfp.m(2131706541), 0).show(this.mActivity.getResources().getDimensionPixelSize(2131299627));
  }
  
  private void doF()
  {
    String str1 = this.mTroopName;
    if (TextUtils.isEmpty(str1)) {
      str1 = this.mTroopUin;
    }
    for (;;)
    {
      String str2 = apqw.p("", this.mTroopUin, 0) + "100";
      AbsShareMsg localAbsShareMsg = new AbsShareMsg.a(StructMsgForGeneralShare.class).c(15).a(this.mActivity.getString(2131718649) + str1).e(this.bKO).a();
      anqv localanqv = anrd.a(2);
      Object localObject1 = this.mActivity.getString(2131720195);
      Object localObject2 = (TroopManager)this.app.getManager(52);
      if ((localObject2 != null) && (this.mTroopUin != null))
      {
        localObject2 = ((TroopManager)localObject2).b(this.mTroopUin);
        if (localObject2 != null)
        {
          if (TextUtils.isEmpty(((TroopInfo)localObject2).mRichFingerMemo)) {
            break label400;
          }
          localObject2 = ((TroopInfo)localObject2).mRichFingerMemo;
          localObject1 = localObject2;
          if (QLog.isColorLevel())
          {
            QLog.e("ForwardOption.ForwardShareCardOption", 2, "summary=" + (String)localObject2);
            localObject1 = localObject2;
          }
        }
      }
      label400:
      for (;;)
      {
        localanqv.t(str2, str1, (String)localObject1, 1);
        localAbsShareMsg.addItem(a(acfp.m(2131706505)));
        localAbsShareMsg.addItem(localanqv);
        this.bf.putByteArray("stuctmsg_bytes", localAbsShareMsg.getBytes());
        this.d = localAbsShareMsg;
        if (QLog.isColorLevel()) {
          QLog.i("ForwardOption.ForwardShareCardOption", 2, "createTroopCardMsg.mMsgServiceID:" + localAbsShareMsg.mMsgServiceID + " mMsgBrief:" + localAbsShareMsg.mMsgBrief + " mContentTitle:" + localAbsShareMsg.mContentTitle + " mContentSummary:" + localAbsShareMsg.mContentSummary + " mMsgUrl:" + localAbsShareMsg.mMsgUrl + " coverUrl:" + str2 + " mSourceName:" + localAbsShareMsg.mSourceName);
        }
        dnB();
        return;
        if (QLog.isColorLevel()) {
          QLog.e("ForwardOption.ForwardShareCardOption", 2, "can't find troop info! summary use default");
        }
      }
    }
  }
  
  private void doG()
  {
    boolean bool = false;
    if (!aqiw.isNetSupport(BaseApplication.getContext()))
    {
      QQToast.a(this.mActivity, this.mActivity.getString(2131693404), 0).show(this.mActivity.getResources().getDimensionPixelSize(2131299627));
      if (QLog.isColorLevel()) {
        QLog.i("ForwardOption.ForwardShareCardOption", 2, "tryToGetShareLink: net is not supported");
      }
      this.atV = -1;
    }
    am(2131696693);
    if (TroopInfo.isQidianPrivateTroop(this.app, this.mTroopUin))
    {
      localObject = ((TroopManager)this.app.getManager(52)).c(this.mTroopUin);
      ((ashy)this.app.getBusinessHandler(85)).iQ(this.mTroopUin, ((TroopInfo)localObject).troopowneruin);
      return;
    }
    Object localObject = (acms)this.app.getBusinessHandler(20);
    String str = this.mTroopUin;
    if (this.atV == 0) {
      bool = true;
    }
    ((acms)localObject).bI(str, bool);
  }
  
  private void ge(String paramString1, String paramString2)
  {
    if (!asgx.ag(this.app, paramString1)) {}
    do
    {
      return;
      localObject1 = ((acff)this.app.getManager(51)).b(paramString1);
    } while (localObject1 == null);
    Object localObject2 = new AbsShareMsg.a(StructMsgForGeneralShare.class);
    String str2 = "mqqapi://app/action?pkg=com.tencent.mobileqq&account_type=2&uintype=1024&cmp=com.tencent.biz.pubaccount.AccountDetailActivity&uin=" + paramString1 + "&cspecialflag=" + ((Friends)localObject1).cSpecialFlag;
    String str3 = "mqqapi://card/show_pslcard?src_type=internal&card_type=qq_bussiness_account&uin=" + paramString1 + "&version=1&cspecialflag=" + ((Friends)localObject1).cSpecialFlag;
    String str4 = "https://share.mp.qq.com/cgi/share.php?uin=" + paramString1 + "&account_flag=" + -7 + "&jumptype=1&card_type=crm&cspecialflag=" + ((Friends)localObject1).cSpecialFlag;
    String str1 = "mqqapi://card/show_pslcard?src_type=internal&source=sharecard&version=1&uin=" + paramString1;
    Object localObject1 = asgx.H(this.app, paramString1);
    if (TextUtils.isEmpty((CharSequence)localObject1)) {}
    for (;;)
    {
      localObject1 = ((AbsShareMsg.a)localObject2).c(14).a(2).a(1).a(acfp.m(2131706533) + paramString2).a("plugin", str4, "", str2, str3).d(this.mActivity.getResources().getString(2131718642)).a();
      localObject2 = new antd();
      ((anqv)localObject2).Vs(1);
      ((anqv)localObject2).a(new ansr(str1));
      ((anqv)localObject2).a(new StructMsgItemTitle(paramString2));
      ((anqv)localObject2).a(new anux(acfp.m(2131706545) + asgx.I(this.app, paramString1)));
      ((AbsShareMsg)localObject1).addItem(a(acfp.m(2131706537)));
      ((AbsShareMsg)localObject1).addItem((anqu)localObject2);
      this.bf.putByteArray("stuctmsg_bytes", ((AbsShareMsg)localObject1).getBytes());
      this.d = ((AbsShareMsg)localObject1);
      dnB();
      return;
      paramString2 = (String)localObject1;
    }
  }
  
  private void gf(String paramString1, String paramString2)
  {
    Object localObject2 = new AbsShareMsg.a(StructMsgForGeneralShare.class);
    String str1 = "mqqapi://card/show_pslcard?src_type=internal&source=sharecard&version=1&uin=" + paramString1;
    String str2 = "AppCmd://OpenContactInfo/?uin=" + paramString1;
    Object localObject1 = aqgv.o(this.app, paramString1);
    if (TextUtils.isEmpty((CharSequence)localObject1)) {}
    for (;;)
    {
      localObject1 = ((AbsShareMsg.a)localObject2).c(14).a(2).a(1).a(acfp.m(2131706531) + paramString2).a("plugin", "", str2, str1, str1).d(this.mActivity.getResources().getString(2131718642)).a();
      localObject2 = new antd();
      ((anqv)localObject2).Vs(1);
      ((anqv)localObject2).a(new ansr(str1));
      ((anqv)localObject2).a(new StructMsgItemTitle(paramString2));
      ((anqv)localObject2).a(new anux(acfp.m(2131706497) + paramString1));
      ((AbsShareMsg)localObject1).addItem(a(acfp.m(2131706507)));
      ((AbsShareMsg)localObject1).addItem((anqu)localObject2);
      this.bf.putByteArray("stuctmsg_bytes", ((AbsShareMsg)localObject1).getBytes());
      this.d = ((AbsShareMsg)localObject1);
      dnB();
      return;
      paramString2 = (String)localObject1;
    }
  }
  
  private void gg(String paramString1, String paramString2)
  {
    AbsShareMsg localAbsShareMsg = new AbsShareMsg.a(StructMsgForGeneralShare.class).c(15).a(acfp.m(2131706523) + this.mTroopName).e(this.bKQ).a();
    Object localObject = (acdu)this.app.getManager(53);
    if (localObject != null)
    {
      localObject = ((acdu)localObject).a(paramString1);
      if (localObject == null) {}
    }
    for (paramString1 = aqgv.m(this.app, paramString1, ((DiscussionInfo)localObject).ownerUin);; paramString1 = null)
    {
      localObject = paramString1;
      if (TextUtils.isEmpty(paramString1)) {
        localObject = acfp.m(2131706519);
      }
      paramString1 = anrd.a(2);
      paramString1.t(paramString2, this.mTroopName, acfp.m(2131706542) + (String)localObject, 1);
      localAbsShareMsg.addItem(a(acfp.m(2131706503)));
      localAbsShareMsg.addItem(paramString1);
      this.bf.putByteArray("stuctmsg_bytes", localAbsShareMsg.getBytes());
      this.d = localAbsShareMsg;
      return;
    }
  }
  
  public void H(int paramInt, Bundle paramBundle)
  {
    if (!ano()) {
      return;
    }
    this.d = null;
    this.mUinType = paramBundle.getInt("uintype");
    this.mUin = paramBundle.getString("uin");
    this.mName = paramBundle.getString("uinname");
    paramBundle.getString("troop_uin");
    CardOCRInfo localCardOCRInfo = (CardOCRInfo)paramBundle.getParcelable("business_card_ocr");
    boolean bool = paramBundle.getBoolean("bindContact", true);
    this.bf.putString("uin", this.bKR);
    this.bf.putInt("uintype", this.dac);
    this.bf.putString("troop_uin", this.bKT);
    this.bf.putString("uinname", this.bKS);
    switch (this.mUinType)
    {
    }
    for (;;)
    {
      this.bf.putInt("key_forward_ability_type", paramInt);
      return;
      this.mTroopUin = null;
      this.mTroopName = null;
      c(localCardOCRInfo);
      continue;
      this.mTroopUin = null;
      this.mTroopName = null;
      gf(this.mUin, this.mName);
      continue;
      this.mTroopUin = null;
      this.mTroopName = null;
      M(this.mUin, this.mName, bool);
      continue;
      this.mTroopUin = this.mUin;
      this.mTroopName = this.mName;
      this.atV = 0;
      doG();
      continue;
      this.mTroopUin = this.mUin;
      this.mTroopName = this.mName;
      this.chr = true;
      if (!aqiw.isNetSupport(BaseApplication.getContext()))
      {
        QQToast.a(this.mActivity, this.mActivity.getString(2131693404), 0).show(this.mActivity.getResources().getDimensionPixelSize(2131299627));
        return;
      }
      this.a.ah(Long.parseLong(this.mUin), true);
      am(2131696693);
      continue;
      this.mTroopUin = null;
      this.mTroopName = null;
      ge(this.mUin, this.mName);
    }
  }
  
  protected boolean a(aqju paramaqju)
  {
    if (this.jdField_b_of_type_ComTencentMobileqqStructmsgAbsStructMsg != null) {
      paramaqju.addView(this.jdField_b_of_type_ComTencentMobileqqStructmsgAbsStructMsg.getPreDialogView(this.mActivity, null));
    }
    for (;;)
    {
      return true;
      if (this.d != null)
      {
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
        localLayoutParams.setMargins(wja.dp2px(-15.0F, this.mActivity.getResources()), 0, wja.dp2px(-15.0F, this.mActivity.getResources()), 0);
        if (QLog.isColorLevel()) {
          QLog.d("ForwardOption.ForwardShareCardOption", 2, "updateImageView addStructView");
        }
        paramaqju.addView(this.d.getPreDialogView(this.mActivity, null), localLayoutParams);
      }
    }
  }
  
  public boolean anj()
  {
    this.app.addObserver(this.o);
    this.app.addObserver(this.jdField_b_of_type_Acdv);
    this.app.addObserver(this.jdField_b_of_type_Ashx);
    this.a = ((acdt)this.app.getBusinessHandler(6));
    this.bKR = this.mIntent.getStringExtra("curent_aio_uin");
    this.bKS = this.mIntent.getStringExtra("curent_aio_uinname");
    this.dac = this.mIntent.getIntExtra("curent_aio_uin_type", 0);
    this.bKT = this.mIntent.getStringExtra("curent_aio_troop_uin");
    this.bPd = this.mIntent.getIntExtra("forward_type", -1);
    return true;
  }
  
  protected boolean ans()
  {
    return true;
  }
  
  protected View cc()
  {
    View localView1 = null;
    switch (this.mUinType)
    {
    default: 
      localView1 = cf();
    }
    for (;;)
    {
      View localView2 = localView1;
      if (localView1 == null) {
        localView2 = new View(this.mActivity);
      }
      return localView2;
      if (this.jdField_b_of_type_ComTencentMobileqqStructmsgAbsStructMsg != null)
      {
        localView1 = this.jdField_b_of_type_ComTencentMobileqqStructmsgAbsStructMsg.getPreDialogView(this.mActivity, null);
        continue;
        localView1 = a(String.format("[%s]%s", new Object[] { acfp.m(2131706521), this.mName }), aqdj.a(this.app, 1, this.mUin));
        continue;
        localView1 = a(String.format("[%s]%s", new Object[] { acfp.m(2131706546), this.mName }), aqdj.a(this.app, 11, this.mUin));
        continue;
        localView1 = a(String.format("[%s]%s", new Object[] { acfp.m(2131706516), this.mName }), aqdj.a(this.app, 4, this.mUin));
        continue;
        localView1 = a(String.format("[%s]%s", new Object[] { acfp.m(2131706530), this.mName }), aqdj.a(this.app, 101, this.mUin));
        continue;
        localView1 = cf();
      }
    }
  }
  
  protected void dnO()
  {
    super.dnO();
    if (this.chs) {
      anot.a(this.app, "CliOper", "", "", "0X8007012", "0X8007012", 0, 0, "", "", "", "");
    }
  }
  
  protected void dnr()
  {
    if (anx()) {
      this.cs.add(S);
    }
    if (anv()) {
      this.cs.add(U);
    }
    if (anw()) {
      this.cs.add(T);
    }
    int i = ((ajdo)this.app.getManager(11)).xy();
    if ((i >= 9) || ((this.bPd == 23) && ((i == 1) || (i == 2) || (i == 6) || (i == 7) || (i == 3)))) {
      this.cs.add(Y);
    }
    this.cs.add(ac);
    if (QLog.isColorLevel()) {
      QLog.d("ForwardOption.ForwardShareCardOption", 2, "build forward ability in state=" + i + ", type=" + this.bPd);
    }
  }
  
  protected void dnv()
  {
    anot.a(this.app, "CliOper", "", "", "0X80056B4", "0X80056B4", 0, 0, "", "", "", "");
    super.dnv();
    if (this.chs) {
      anot.a(this.app, "CliOper", "", "", "0X8007013", "0X8007013", 0, 0, "", "", "", "");
    }
  }
  
  public String getTitle()
  {
    return this.mActivity.getString(2131720041);
  }
  
  public void onDestroy()
  {
    if (this.o != null) {
      this.app.removeObserver(this.o);
    }
    if (this.jdField_b_of_type_Acdv != null) {
      this.app.removeObserver(this.jdField_b_of_type_Acdv);
    }
    if (this.jdField_b_of_type_Ashx != null) {
      this.app.removeObserver(this.jdField_b_of_type_Ashx);
    }
    super.onDestroy();
  }
  
  public String wo()
  {
    String str = null;
    if (!TextUtils.isEmpty(this.bKS)) {
      str = this.bKS;
    }
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahlr
 * JD-Core Version:    0.7.0.1
 */