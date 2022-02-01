import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.av.ReqGroupVideo.ReqCreateShareUrl;
import com.tencent.av.share.AVSchema;
import com.tencent.av.share.ShareChat.SharePanel.1;
import com.tencent.av.share.ShareChat.SharePanel.2;
import com.tencent.av.share.ShareChat.SharePanel.3;
import com.tencent.av.share.ShareChat.SharePanel.4;
import com.tencent.av.share.ShareChat.SharePanel.5;
import com.tencent.biz.qrcode.activity.QRDisplayActivity;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity.b;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.b;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONObject;

public class ivc
{
  String QE;
  protected String QF;
  protected String QG;
  protected BaseActivity a;
  protected TroopInfoData a;
  ivc.a jdField_a_of_type_Ivc$a = null;
  ivc.b jdField_a_of_type_Ivc$b;
  int atS;
  boolean gV = false;
  QQAppInterface mApp;
  long oi;
  
  public ivc()
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData = new TroopInfoData();
  }
  
  public static aqhv a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString)
  {
    aqhv localaqhv = new aqhv(paramQQAppInterface, paramContext);
    if ((paramContext instanceof JumpActivity))
    {
      paramQQAppInterface = ((JumpActivity)paramContext).getIntent();
      if (paramQQAppInterface != null) {
        localaqhv.fj("from_url_InternalCheck", paramQQAppInterface.getStringExtra("url"));
      }
    }
    paramContext = aqik.c(paramString, "?");
    paramQQAppInterface = paramContext[0];
    paramContext = paramContext[1];
    paramQQAppInterface = paramQQAppInterface.split("//");
    if (paramQQAppInterface.length != 2) {
      return null;
    }
    localaqhv.source = paramString;
    localaqhv.cti = "mqqavshare://";
    localaqhv.ctj = paramQQAppInterface[1];
    paramQQAppInterface = "parser, jumpStr[" + paramString + "], server_name[" + localaqhv.cti + "], action_name[" + localaqhv.ctj + "]";
    paramString = paramContext.split("&");
    int j = paramString.length;
    int i = 0;
    while (i < j)
    {
      String[] arrayOfString = paramString[i].split("=");
      paramContext = paramQQAppInterface;
      if (arrayOfString.length == 2)
      {
        paramContext = aqik.decode(arrayOfString[1], false);
        localaqhv.fj(arrayOfString[0], paramContext);
        paramContext = paramQQAppInterface + ", [" + arrayOfString[0] + "]=[" + paramContext + "]";
      }
      i += 1;
      paramQQAppInterface = paramContext;
    }
    QLog.w("ShareChat", 1, paramQQAppInterface);
    return localaqhv;
  }
  
  static String a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (paramQQAppInterface == null) {
      return null;
    }
    paramString = aqgv.h(paramQQAppInterface, paramString, paramQQAppInterface.getCurrentAccountUin());
    return paramString + paramQQAppInterface.getApp().getString(2131694566);
  }
  
  static String a(ivc.b.a parama)
  {
    String str = null;
    if (parama != null) {
      str = parama.getDesc();
    }
    return str;
  }
  
  static void a(long paramLong, Context paramContext)
  {
    if (paramContext == null) {
      return;
    }
    QLog.w("ShareChat", 1, "finishJumpActivity, seq[" + paramLong + "]");
    Intent localIntent = new Intent();
    localIntent.setAction("BroadcastReceiverFinishActivity");
    paramContext.sendBroadcast(localIntent);
  }
  
  static void a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    long l = AudioHelper.hG();
    StringBuilder localStringBuilder = new StringBuilder().append("forward, url[").append(paramString2).append("], fromchannel[").append(paramInt).append("], seq[").append(l).append("], app[");
    if (paramQQAppInterface != null) {}
    for (boolean bool = true;; bool = false)
    {
      QLog.w("ShareChat", 1, bool + "], context[" + paramContext + "]");
      if ((paramQQAppInterface != null) && (paramContext != null) && (!TextUtils.isEmpty(paramString2))) {
        break;
      }
      return;
    }
    new ivc.b(l, 0).a(paramContext, paramString1, new ivf(paramString2, paramQQAppInterface, paramString1, paramInt, l, new WeakReference(paramContext)));
  }
  
  public static void a(QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity, View paramView, Intent paramIntent)
  {
    int i = paramIntent.getIntExtra("param_entrance", 0);
    String str = paramIntent.getStringExtra("group_uin");
    if (i == 35)
    {
      jjk.b.axg();
      a(paramQQAppInterface, paramBaseActivity, paramView, str);
      return;
    }
    long l = paramIntent.getLongExtra("room_id", 0L);
    i = paramIntent.getIntExtra("room_create_time", 0);
    jjk.b.axb();
    new ivc().a(paramQQAppInterface, paramBaseActivity, str, l, i);
  }
  
  static void a(QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity, View paramView, String paramString)
  {
    aprg.j(paramBaseActivity, paramString);
  }
  
  public static boolean a(aqhv paramaqhv)
  {
    if ("avshare/group".equals(paramaqhv.ctj)) {
      return b(paramaqhv);
    }
    if ("avshare/forward".equals(paramaqhv.ctj)) {
      return d(paramaqhv);
    }
    return false;
  }
  
  private String aQ(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 0: 
      return this.QF;
    }
    return this.QG;
  }
  
  static String b(ivc.b.a parama)
  {
    if (parama != null) {
      return parama.hh();
    }
    return null;
  }
  
  public static boolean b(aqhv paramaqhv)
  {
    if (!"avshare/group".equals(paramaqhv.ctj)) {
      return false;
    }
    String str = (String)paramaqhv.attrs.get("guid");
    if (TextUtils.isEmpty(str)) {
      return false;
    }
    AudioHelper.rw("handle_startGAudio");
    Intent localIntent = new Intent();
    localIntent.putExtra("public_fragment_window_feature", 1);
    localIntent.addFlags(268435456);
    localIntent.putExtra("guid", str);
    PublicFragmentActivity.b.start(paramaqhv.context, localIntent, PublicTransFragmentActivity.class, AVSchema.class);
    jjk.b.axc();
    return true;
  }
  
  static boolean c(aqhv paramaqhv)
  {
    if (!paramaqhv.aCO())
    {
      paramaqhv = (String)paramaqhv.attrs.get("from_url_InternalCheck");
      QLog.w("ShareChat", 1, "handle_forward, KEY_CurrentUrl[" + paramaqhv + "]");
      if (!TextUtils.isEmpty(paramaqhv))
      {
        paramaqhv = paramaqhv.replace('\\', '/');
        if ((paramaqhv.startsWith("https://web.qun.qq.com/")) || (paramaqhv.startsWith("http://web.qun.qq.com/"))) {
          return true;
        }
      }
      return false;
    }
    return true;
  }
  
  public static boolean d(aqhv paramaqhv)
  {
    if (!"avshare/forward".equals(paramaqhv.ctj)) {
      return false;
    }
    if (!c(paramaqhv)) {
      return false;
    }
    String str1 = (String)paramaqhv.attrs.get("url");
    Object localObject1 = (String)paramaqhv.attrs.get("exp");
    String str2 = (String)paramaqhv.attrs.get("guin");
    Object localObject2 = (String)paramaqhv.attrs.get("fromchannel");
    if (TextUtils.isEmpty(str1)) {
      return false;
    }
    int i = (int)aqmr.stringToLong("ShareChat", (String)localObject2);
    if (i == 0) {
      return false;
    }
    jjk.b.ak(i, str2);
    AudioHelper.rw("handle_forward");
    long l1 = aqmr.stringToLong("ShareChat", (String)localObject1);
    long l2 = AudioHelper.hF();
    if (l1 < l2)
    {
      paramaqhv = QQToast.a(paramaqhv.context, 2131694567, 1);
      paramaqhv.setAutoTextSize();
      paramaqhv.show();
      QLog.w("ShareChat", 1, "handle_forward, expTime[" + l1 + "], curTime[" + l2 + "]");
      return true;
    }
    if (((TroopManager)paramaqhv.getApp().getManager(52)).b(str2) == null)
    {
      if (QLog.isColorLevel()) {
        QLog.w("ShareChat", 1, "handle_forward, troopUin[" + str2 + "]");
      }
      paramaqhv = QQToast.a(paramaqhv.context, 2131694567, 1);
      paramaqhv.setAutoTextSize();
      paramaqhv.show();
      return true;
    }
    localObject1 = paramaqhv.getApp();
    localObject2 = (apsw)((QQAppInterface)localObject1).getManager(48);
    boolean bool1 = ((apsw)localObject2).hs(str2);
    boolean bool2 = ((apsw)localObject2).eL(str2);
    if ((!bool1) && (!bool2))
    {
      if (AudioHelper.aCz()) {
        QLog.w("ShareChat", 1, "handle_forward, troopUin[" + str2 + "], isAdmin[" + bool1 + "], isOwner[" + bool2 + "]");
      }
      paramaqhv = QQToast.a(paramaqhv.context, 2131694568, 1);
      paramaqhv.setAutoTextSize();
      paramaqhv.show();
      return true;
    }
    paramaqhv.cUe = false;
    if ((paramaqhv.context instanceof JumpActivity)) {
      ((JumpActivity)paramaqhv.context).bPU();
    }
    a((QQAppInterface)localObject1, paramaqhv.context, str2, str1, i);
    return true;
  }
  
  static String dw(String paramString)
  {
    return apqw.p("", paramString, 0) + "100";
  }
  
  static String getTitle(Context paramContext)
  {
    return paramContext.getString(2131694563);
  }
  
  void a(QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity, String paramString, long paramLong, int paramInt)
  {
    int i = 1;
    int j = 0;
    this.QE = paramString;
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    this.mApp = paramQQAppInterface;
    this.oi = paramLong;
    this.atS = paramInt;
    if (!vz()) {
      return;
    }
    a(paramQQAppInterface, paramString);
    paramQQAppInterface = aqji.a().a(paramString);
    long l = AudioHelper.hG();
    if (paramQQAppInterface == null)
    {
      h(l, paramLong, paramInt);
      paramInt = j;
      if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim())
      {
        paramInt = j;
        if (!TroopInfo.isQidianPrivateTroop((QQAppInterface)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getAppRuntime(), this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin))
        {
          if ((!TroopInfo.hasPayPrivilege(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mTroopPrivilegeFlag, 128)) || (!TroopInfo.hasPayPrivilege(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mTroopPrivilegeFlag, 512))) {
            break label315;
          }
          paramInt = 1;
          label152:
          if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.cGroupOption != 1) {
            break label321;
          }
          label163:
          if ((paramInt | i) == 0) {
            break label327;
          }
        }
      }
    }
    label315:
    label321:
    label327:
    for (paramInt = j;; paramInt = -1)
    {
      this.jdField_a_of_type_Ivc$b = new ivc.b(l, paramInt);
      this.jdField_a_of_type_Ivc$b.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.QE, new ivd(this, l));
      return;
      this.QF = paramQQAppInterface.QF;
      this.QG = paramQQAppInterface.QG;
      QLog.w("ShareChat", 1, "ShareChat, 从缓存中找到url, groupUin[" + paramString + "], m_share_url_with_no_sig[" + this.QF + "], m_share_url[" + this.QG + "], seq[" + l + "], mSharePanel[" + this.jdField_a_of_type_Ivc$b + "]");
      break;
      paramInt = 0;
      break label152;
      i = 0;
      break label163;
    }
  }
  
  void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    ((acms)paramQQAppInterface.getBusinessHandler(20)).bJ(paramString, false);
    if (this.jdField_a_of_type_Ivc$a == null)
    {
      this.jdField_a_of_type_Ivc$a = new ivc.a(null);
      this.jdField_a_of_type_Ivc$a.QD = paramString;
      paramQQAppInterface.addObserver(this.jdField_a_of_type_Ivc$a);
    }
  }
  
  void g(long paramLong1, long paramLong2, int paramInt)
  {
    QLog.w("ShareChat", 1, "reRequest, mIsRequesting[" + this.gV + "], seq[" + paramLong1 + "]");
    if (this.gV) {
      return;
    }
    vz();
    h(paramLong1, paramLong2, paramInt);
  }
  
  void h(long paramLong1, long paramLong2, int paramInt)
  {
    this.gV = true;
    long l = aqmr.stringToLong("ShareChat", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopCard;
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = aqgv.b(this.mApp, this.mApp.getCurrentAccountUin(), true);
    }
    localObject2 = localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      localObject2 = this.mApp.getCurrentAccountUin();
    }
    int i = 3;
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bOwner) {
      i = 1;
    }
    for (;;)
    {
      localObject1 = new ive(this);
      QLog.w("ShareChat", 1, "requestGetUrlFromServer, share_name[" + (String)localObject2 + "], role[" + i + "], troopUin[" + l + "], roomID[" + paramLong2 + "], roomCreateTime[" + paramInt + "], seq[" + paramLong1 + "]");
      ReqGroupVideo.ReqCreateShareUrl localReqCreateShareUrl = new ReqGroupVideo.ReqCreateShareUrl();
      localReqCreateShareUrl.uint64_uin.set(this.mApp.getLongAccountUin());
      localReqCreateShareUrl.uint64_group_code.set(l);
      localReqCreateShareUrl.uint64_room_id.set(paramLong2);
      localReqCreateShareUrl.uint32_room_create_time.set(paramInt);
      localReqCreateShareUrl.group_name.set(ByteStringMicro.copyFromUtf8(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopName));
      localReqCreateShareUrl.share_name.set(ByteStringMicro.copyFromUtf8((String)localObject2));
      localReqCreateShareUrl.role.set(i);
      ijl.a(paramLong1, this.mApp, "QQRTCSvc.group_video_create_share_url", localReqCreateShareUrl, (ijl.b)localObject1);
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bAdmin) {
        i = 2;
      }
    }
  }
  
  boolean vz()
  {
    TroopInfo localTroopInfo = ((TroopManager)this.mApp.getManager(52)).c(this.QE);
    if (localTroopInfo == null)
    {
      QLog.w("ShareChat", 1, "initData fail, mGroupUin[" + this.QE + "]");
      return false;
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.updateForTroopInfo(localTroopInfo, this.mApp.getCurrentAccountUin());
    return true;
  }
  
  class a
    extends acnd
  {
    String QD;
    
    private a() {}
    
    protected void a(boolean paramBoolean, TroopInfo paramTroopInfo, String paramString)
    {
      if (paramTroopInfo == null) {}
      do
      {
        return;
        paramTroopInfo = paramTroopInfo.troopuin;
      } while ((TextUtils.isEmpty(this.QD)) || (!TextUtils.equals(this.QD, paramTroopInfo)));
      ivc.this.mApp.removeObserver(this);
      if (this == ivc.this.a) {
        ivc.this.a = null;
      }
      QLog.w("ShareChat", 1, "onGetSimpleTroopInfoResult, isSuc[" + paramBoolean + "]");
      ivc.this.vz();
    }
    
    protected void jc(boolean paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.w("ShareChat", 1, "onUpdateTroopList, isSuccess[" + paramBoolean + "]");
      }
    }
  }
  
  public static class b
  {
    String QE = null;
    public ivc.b.a a;
    ivc.b.b a;
    int atU = -1;
    int atV;
    ShareActionSheetBuilder mShareActionSheetBuilder;
    final long seq;
    
    b(long paramLong, int paramInt)
    {
      this.jdField_a_of_type_Ivc$b$b = new ivc.b.b();
      this.jdField_a_of_type_Ivc$b$a = null;
      this.atV = paramInt;
      this.seq = paramLong;
    }
    
    private void a(long paramLong, Context paramContext, int paramInt, ivc.b.a parama, String paramString)
    {
      String str = ivc.b(parama);
      ArrayList localArrayList = new ArrayList();
      if (!TextUtils.isEmpty(str)) {
        localArrayList.add(str);
      }
      str = paramContext.getString(2131694564) + paramString;
      Bundle localBundle = new Bundle();
      localBundle.putString("title", ivc.getTitle(paramContext));
      localBundle.putString("desc", ivc.a(parama));
      localBundle.putLong("req_share_id", 0L);
      localBundle.putString("detail_url", paramString);
      localBundle.putString("url", paramString);
      localBundle.putStringArrayList("image_url", localArrayList);
      localBundle.putString("troop_wording", str);
      localBundle.putString("bizname", "JoinTroopLink");
      localBundle.putParcelable("PARAM_ActivityResultReceiver", new ShareChat.SharePanel.1(this, new Handler(), paramLong, paramInt));
      avqq.a((AppInterface)BaseApplicationImpl.getApplication().getRuntime(), paramContext, localBundle, null, 145);
      if (QLog.isColorLevel()) {
        QLog.w("ShareChat", 1, "shareToQzone, shareLink[" + paramString + "], seq[" + paramLong + "]");
      }
    }
    
    private void a(long paramLong, Context paramContext, boolean paramBoolean, int paramInt, String paramString, ivc.b.a parama)
    {
      String str1 = String.valueOf(System.currentTimeMillis());
      Bitmap localBitmap = null;
      if (parama != null) {
        localBitmap = parama.a(paramLong);
      }
      localBitmap = apzg.R(localBitmap);
      String str2 = ivc.getTitle(paramContext);
      parama = ivc.a(parama);
      int i;
      if (paramBoolean)
      {
        i = 3;
        b(paramContext, str1, i, paramInt);
        if (!paramBoolean) {
          break label159;
        }
        WXShareHelper.a().a(str1, str2, localBitmap, parama, paramString);
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.w("ShareChat", 1, "shareToWX, mWXTransaction[" + str1 + "], bFriendCircle[" + paramBoolean + "], shareLink[" + paramString + "], seq[" + paramLong + "]");
        }
        return;
        i = 2;
        break;
        label159:
        paramContext = apzg.c(parama, paramContext);
        WXShareHelper.a().b(str1, str2, localBitmap, paramContext, paramString);
      }
    }
    
    private void b(long paramLong, Context paramContext, int paramInt, ivc.b.a parama, String paramString)
    {
      paramString = paramContext.getString(2131694564) + paramString;
      if (QLog.isColorLevel()) {
        QLog.w("ShareChat", 1, "copyTroopLink, text[" + paramString + "], seq[" + paramLong + "]");
      }
      parama = (ClipboardManager)paramContext.getSystemService("clipboard");
      paramString = ClipData.newPlainText("troop_url", paramString);
      alkw.a(parama, paramString);
      parama.setPrimaryClip(paramString);
      QQToast.a(paramContext, 2, 2131694565, 0).show();
      C(4, paramInt, 2);
    }
    
    private void d(long paramLong, Context paramContext)
    {
      if (this.jdField_a_of_type_Ivc$b$a == null)
      {
        QLog.w("ShareChat", 1, "tryToGetShareLink, mIHandle为空");
        return;
      }
      String str = this.jdField_a_of_type_Ivc$b$a.d(paramLong, this.atV);
      if (TextUtils.isEmpty(str))
      {
        boolean bool = aqiw.isNetSupport(null);
        QLog.w("ShareChat", 1, "tryToGetShareLink, url为空, isConn[" + bool + "], mChoosedChannel[" + this.atU + "], mChoosedLinkType[" + this.atV + "], seq[" + paramLong + "]");
        if ((!bool) && (this.atU != 4))
        {
          QQToast.a(paramContext, paramContext.getString(2131693404), 0).show();
          if (QLog.isColorLevel()) {
            QLog.w("ShareChat", 1, "tryToGetShareLink, !isNetSupport, mChoosedChannel[" + this.atU + "]");
          }
        }
        for (;;)
        {
          C(this.atU, this.atV, 3);
          return;
          QQToast.a(paramContext, acfp.m(2131714359), 0).show();
        }
      }
      switch (this.atU)
      {
      default: 
        return;
      case 0: 
        c(paramLong, paramContext, this.atV, this.jdField_a_of_type_Ivc$b$a, str);
        return;
      case 3: 
        a(paramLong, paramContext, true, this.atV, str, this.jdField_a_of_type_Ivc$b$a);
        return;
      case 2: 
        a(paramLong, paramContext, false, this.atV, str, this.jdField_a_of_type_Ivc$b$a);
        return;
      case 1: 
        a(paramLong, paramContext, this.atV, this.jdField_a_of_type_Ivc$b$a, str);
        return;
      case 4: 
        b(paramLong, paramContext, this.atV, this.jdField_a_of_type_Ivc$b$a, str);
        return;
      }
      d(paramLong, paramContext, this.atV, this.jdField_a_of_type_Ivc$b$a, str);
    }
    
    public void C(int paramInt1, int paramInt2, int paramInt3)
    {
      if (this.jdField_a_of_type_Ivc$b$a != null) {
        this.jdField_a_of_type_Ivc$b$a.C(paramInt1, paramInt2, paramInt3);
      }
      aqO();
    }
    
    void a(Context paramContext, String paramString, ivc.b.a parama)
    {
      this.QE = paramString;
      this.jdField_a_of_type_Ivc$b$a = parama;
      this.jdField_a_of_type_Ivc$b$b.seq = this.seq;
      bv(paramContext);
      this.mShareActionSheetBuilder.show();
    }
    
    void aqO()
    {
      this.atU = -1;
    }
    
    void b(long paramLong, Context paramContext)
    {
      this.atV = 0;
      d(paramLong, paramContext);
    }
    
    void b(Context paramContext, String paramString, int paramInt1, int paramInt2)
    {
      WXShareHelper.a().a(new ivg(this, paramString, paramContext, paramInt1, paramInt2));
    }
    
    void bv(Context paramContext)
    {
      if (this.mShareActionSheetBuilder != null) {
        return;
      }
      this.mShareActionSheetBuilder = new ShareActionSheetBuilder(paramContext);
      this.mShareActionSheetBuilder.setActionSheetTitle(paramContext.getString(2131720177));
      this.mShareActionSheetBuilder.setActionSheetItems(apzg.a(paramContext, true));
      this.mShareActionSheetBuilder.setOnDismissListener(new ivh(this));
      this.mShareActionSheetBuilder.setItemClickListener(this.jdField_a_of_type_Ivc$b$b);
    }
    
    void c(long paramLong, Context paramContext)
    {
      this.atV = 1;
      d(paramLong, paramContext);
    }
    
    public void c(long paramLong, Context paramContext, int paramInt, ivc.b.a parama, String paramString)
    {
      if (parama == null) {
        return;
      }
      try
      {
        Object localObject3 = ivc.getTitle(paramContext);
        String str1 = ivc.getTitle(paramContext);
        String str2 = ivc.a(parama);
        String str3 = ivc.b(parama);
        Object localObject2 = paramContext.getString(2131694562);
        Object localObject1 = new JSONObject();
        ((JSONObject)localObject1).put("prompt", localObject3);
        localObject3 = new JSONObject();
        ((JSONObject)localObject3).put("forward", true);
        ((JSONObject)localObject3).put("autosize", true);
        ((JSONObject)localObject1).put("config", localObject3);
        ((JSONObject)localObject1).put("app", "com.tencent.qqavchat");
        ((JSONObject)localObject1).put("ver", "0.0.0.1");
        ((JSONObject)localObject1).put("view", "qqavchat");
        localObject3 = new JSONObject();
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("title", str1);
        localJSONObject.put("desc", str2);
        localJSONObject.put("preview", str3);
        localJSONObject.put("tag", localObject2);
        localJSONObject.put("jumpUrl", paramString);
        parama = parama.aR(0);
        if (!TextUtils.isEmpty(parama))
        {
          paramString = new JSONObject();
          paramString.put("type", parama);
          paramString.put("name", parama);
          paramString.put("reportType", "898");
          paramString.put("r2", aqmr.stringToLong("ShareChat", this.QE));
          localJSONObject.put("report", paramString);
        }
        ((JSONObject)localObject3).put("news", localJSONObject);
        ((JSONObject)localObject1).put("meta", localObject3);
        localObject2 = ((JSONObject)localObject1).toString();
        parama = ((JSONObject)localObject1).getString("app");
        paramString = ((JSONObject)localObject1).getString("ver");
        str1 = ((JSONObject)localObject1).getString("view");
        str2 = ((JSONObject)localObject1).getString("config");
        str3 = ((JSONObject)localObject1).getString("meta");
        localObject1 = ((JSONObject)localObject1).getString("prompt");
        QLog.w("ShareChat", 1, "shareToMobileQQ, data[" + (String)localObject2 + "], appName[" + parama + "], appMinVersion[" + paramString + "], appView[" + str1 + "], config[" + str2 + "], metaList[" + str3 + "], promptText[" + (String)localObject1 + "], seq[" + paramLong + "]");
        localObject2 = new Intent();
        ((Intent)localObject2).putExtra("forward_type", 27);
        ((Intent)localObject2).putExtra("is_ark_display_share", true);
        ((Intent)localObject2).putExtra("forward_ark_app_name", parama);
        ((Intent)localObject2).putExtra("forward_ark_app_view", str1);
        ((Intent)localObject2).putExtra("forward_ark_app_ver", paramString);
        ((Intent)localObject2).putExtra("forward_ark_app_prompt", (String)localObject1);
        ((Intent)localObject2).putExtra("forward_ark_app_meta", str3);
        ((Intent)localObject2).putExtra("forward_ark_app_config", str2);
        ((Intent)localObject2).putExtras(aqjn.a.a(parama, str1, paramString, str3, paramContext.getResources().getDisplayMetrics().scaledDensity, null, null));
        ((Intent)localObject2).putExtra("PARAM_ActivityResultReceiver", new ShareChat.SharePanel.2(this, new Handler(), paramLong, paramInt));
        ahgq.P(paramContext, (Intent)localObject2);
        return;
      }
      catch (Exception parama)
      {
        QLog.w("ShareChat", 1, "shareToMobileQQ, Exception, seq[" + paramLong + "]", parama);
        QQToast.a(paramContext, acfp.m(2131714361), 0).show();
        C(0, paramInt, 3);
      }
    }
    
    void d(long paramLong, Context paramContext, int paramInt, ivc.b.a parama, String paramString)
    {
      TroopInfoData localTroopInfoData = parama.a();
      if (localTroopInfoData == null)
      {
        C(5, paramInt, 3);
        return;
      }
      Intent localIntent = new Intent(paramContext, QRDisplayActivity.class);
      localIntent.putExtra("title", paramContext.getString(2131717027));
      int i;
      if (TextUtils.isEmpty(localTroopInfoData.troopName))
      {
        localIntent.putExtra("nick", localTroopInfoData.newTroopName);
        parama = (AppInterface)BaseApplicationImpl.getApplication().getRuntime();
        localIntent.putExtra("url", paramString);
        localIntent.putExtra("uin", localTroopInfoData.troopUin);
        if (!localTroopInfoData.bOwner) {
          break label324;
        }
        i = 0;
        label122:
        localIntent.putExtra("adminLevel", i);
        localIntent.putExtra("type", 11);
        localIntent.putExtra("GroupFlagExt", localTroopInfoData.dwGroupFlagExt);
        localIntent.putExtra("AuthGroupType", localTroopInfoData.dwAuthGroupType);
        if (!(parama instanceof QQAppInterface)) {
          break label344;
        }
      }
      label324:
      label344:
      for (parama = (QQAppInterface)parama;; parama = null)
      {
        boolean bool = TroopInfo.isQidianPrivateTroop(parama, localTroopInfoData.troopUin);
        localIntent.putExtra("isQidianPrivateTroop", bool);
        if (bool) {
          localIntent.putExtra("groupOwner", localTroopInfoData.troopowneruin);
        }
        localIntent.putExtra("PARAM_QRForwardReceiver", new ShareChat.SharePanel.3(this, new Handler(), paramLong, paramInt));
        localIntent.putExtra("PARAM_ActivityResultReceiver", new ShareChat.SharePanel.4(this, new Handler(), paramLong, paramInt));
        ThreadManager.post(new ShareChat.SharePanel.5(this, parama, localTroopInfoData, localIntent, paramContext, paramInt), 8, null, true);
        return;
        localIntent.putExtra("nick", localTroopInfoData.troopName);
        break;
        if (localTroopInfoData.bAdmin)
        {
          i = 1;
          break label122;
        }
        i = 2;
        break label122;
      }
    }
    
    protected void e(long paramLong, Context paramContext)
    {
      ausj localausj = (ausj)auss.a(paramContext, null);
      localausj.addButton(2131721502);
      localausj.addButton(2131721503);
      localausj.addCancelButton(2131721058);
      localausj.setOnDismissListener(new ivi(this, paramLong));
      localausj.a(new ivj(this, paramLong, localausj));
      switch (this.atU)
      {
      case 4: 
      default: 
        paramContext = paramContext.getString(2131721500);
      }
      for (;;)
      {
        localausj.setMainTitle(paramContext);
        localausj.show();
        return;
        paramContext = String.format(paramContext.getString(2131691495), new Object[] { paramContext.getString(2131721501) });
        continue;
        paramContext = String.format(paramContext.getString(2131691495), new Object[] { paramContext.getString(2131721504) });
        continue;
        paramContext = String.format(paramContext.getString(2131691495), new Object[] { paramContext.getString(2131721088) });
        continue;
        paramContext = String.format(paramContext.getString(2131691495), new Object[] { paramContext.getString(2131720185) });
        continue;
        paramContext = acfp.m(2131714360);
      }
    }
    
    public String toString()
    {
      return this.seq + "";
    }
    
    public static abstract interface a
    {
      public abstract void C(int paramInt1, int paramInt2, int paramInt3);
      
      public abstract void D(int paramInt1, int paramInt2, int paramInt3);
      
      public abstract Bitmap a(long paramLong);
      
      public abstract TroopInfoData a();
      
      public abstract String aR(int paramInt);
      
      public abstract String d(long paramLong, int paramInt);
      
      public abstract String getDesc();
      
      public abstract String hh();
    }
    
    class b
      implements AdapterView.OnItemClickListener
    {
      long seq = 0L;
      
      b() {}
      
      public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
      {
        Object localObject = paramView.getTag();
        if (localObject == null) {}
        Context localContext;
        do
        {
          EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
          return;
          localContext = paramAdapterView.getContext();
          if (ivc.b.this.mShareActionSheetBuilder != null) {
            ivc.b.this.mShareActionSheetBuilder.dismiss();
          }
        } while (ivc.b.this.a == null);
        label140:
        int i;
        switch (((ShareActionSheetBuilder.b)localObject).b.action)
        {
        default: 
          ivc.b.this.atU = ((int)paramLong);
          if ((paramLong == 2L) || (paramLong == 3L)) {
            if (!WXShareHelper.a().isWXinstalled()) {
              i = 2131721935;
            }
          }
          break;
        }
        for (;;)
        {
          if (i != -1)
          {
            QQToast.a(localContext, localContext.getString(i), 0).show();
            ivc.b.this.C(ivc.b.this.atU, ivc.b.this.atV, 3);
            break;
            paramLong = 0L;
            break label140;
            paramLong = 1L;
            break label140;
            paramLong = 3L;
            break label140;
            paramLong = 2L;
            break label140;
            paramLong = 4L;
            break label140;
            paramLong = 5L;
            break label140;
            paramLong = 7L;
            break label140;
            if (WXShareHelper.a().isWXsupportApi()) {
              break label422;
            }
            i = 2131721936;
            continue;
          }
          QLog.w("ShareChat", 1, "onItemClick, mChoosedChannel[" + ivc.b.this.atU + "], position[" + paramInt + "], id[" + paramLong + "], seq[" + this.seq + "], mChoosedLinkType[" + ivc.b.this.atV + "]");
          if (ivc.b.this.atV == -1) {
            ivc.b.this.e(this.seq, localContext);
          }
          for (;;)
          {
            break;
            ivc.b.this.b(this.seq, localContext);
          }
          label422:
          i = -1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ivc
 * JD-Core Version:    0.7.0.1
 */