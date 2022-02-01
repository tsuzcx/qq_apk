package com.tencent.biz.pubaccount;

import aalb;
import abdi;
import acbn;
import acfd;
import acja;
import acje;
import acrp;
import acxw;
import adai;
import adam;
import ahty;
import ahua;
import amxe;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.content.ComponentName;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import anot;
import anre;
import ansi;
import anze;
import aqdj;
import aqep;
import aqgo;
import aqiw;
import aqiy;
import aqmp;
import arhz;
import arwv;
import asgx;
import ausj;
import auss;
import avjj;
import com.tencent.biz.pubaccount.AccountDetail.activity.PubAccountMoreInfoActivity;
import com.tencent.biz.pubaccount.AccountDetail.view.AccountDetailTopGestureLayout;
import com.tencent.biz.pubaccount.AccountDetail.view.AccountDetailXListView;
import com.tencent.biz.pubaccount.AccountDetail.view.AccountDetailXListView.b;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianDailyManager;
import com.tencent.biz.pubaccount.util.ProfileParams;
import com.tencent.biz.pubaccount.util.ProfileParams.CurLoginUsr;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.URLDrawable;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.fling.FlingGestureHandler;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.minigame.publicaccount.MiniGamePublicAccountHelper;
import com.tencent.mobileqq.mp.mobileqq_mp.FollowRequest;
import com.tencent.mobileqq.mp.mobileqq_mp.GetPublicAccountDetailInfoRequest;
import com.tencent.mobileqq.mp.mobileqq_mp.GetPublicAccountDetailInfoResponse;
import com.tencent.mobileqq.mp.mobileqq_mp.UnFollowRequest;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.widget.ListView;
import cooperation.qzone.contentbox.QZoneMsgActivity;
import java.io.File;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import jqs;
import jtg;
import juc;
import jue;
import jvr;
import jvs;
import jvt;
import jvu;
import jvv;
import jvw;
import jvx;
import jvy;
import jvz;
import jwa;
import jwb;
import jwc;
import jwd;
import jwe;
import jwf;
import jwg;
import jwh;
import jwi;
import jwj;
import jwk;
import jwl;
import jwm;
import jwn;
import jzs.a;
import kbp;
import kbs;
import kbu;
import kec;
import keo;
import kvs;
import kxm;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.manager.TicketManager;
import mqq.observer.BusinessObserver;
import mqq.os.MqqHandler;
import nyn;
import obg;
import ocp;
import odv;
import ogj;
import org.json.JSONArray;
import org.json.JSONObject;
import smu;
import smu.a;
import swe;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsgAction;
import tencent.mobileim.structmsg.structmsg.SystemMsgActionInfo;
import vbg;
import vbi.a;
import vbi.b;
import vnj;
import xki;

public class AccountDetailActivity
  extends BaseActivity
  implements View.OnClickListener, AccountDetailXListView.b
{
  public static int NETWORK_ERROR = -1;
  public static int aDJ;
  public static int aDK = 1;
  public JSONObject J;
  public String Um;
  public String Uq;
  public String Ur;
  public String Us;
  public String Ut;
  protected String Uu;
  protected AccountDetailTopGestureLayout a;
  a jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity$a;
  b jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity$b;
  public ProfileParams a;
  public PublicAccountHandler a;
  public AccountDetail a;
  public ShareActionSheetBuilder a;
  public jtg a;
  protected BusinessObserver a;
  protected smu a;
  swe jdField_a_of_type_Swe;
  public int aDF;
  public int aDG;
  int aDH = 0;
  public int aDI;
  boolean abG = false;
  protected boolean abU;
  public boolean abV;
  public boolean abW;
  public boolean abX;
  public boolean abY = true;
  public boolean abZ = true;
  public boolean aca;
  boolean acb = false;
  private boolean acc;
  private boolean acd;
  private boolean ace;
  boolean acf = false;
  private boolean acg;
  public boolean ach = false;
  public boolean aci;
  boolean acj = false;
  public boolean ack = false;
  boolean acl = false;
  public QQAppInterface app;
  final acje b;
  public AccountDetailXListView b;
  public mobileqq_mp.GetPublicAccountDetailInfoResponse b;
  protected BusinessObserver b;
  Button bH;
  protected Button bI;
  protected Button bJ;
  public Button bK;
  adai jdField_c_of_type_Adai;
  BusinessObserver jdField_c_of_type_MqqObserverBusinessObserver;
  Drawable cq = null;
  adai d;
  protected NewIntent d;
  protected float density;
  public ausj e;
  protected NewIntent e;
  long enterTime;
  LinearLayout errorContainer;
  public int errorStatus = aDJ;
  public RelativeLayout ez;
  NewIntent jdField_f_of_type_MqqAppNewIntent;
  private MqqHandler jdField_f_of_type_MqqOsMqqHandler;
  ImageView hH;
  public ImageView hI;
  public ImageView hJ;
  public ImageView hK;
  View iR;
  public View iS;
  View iT;
  protected View iU;
  protected View iV;
  protected View iW;
  boolean isDestory = false;
  public boolean isFirst;
  private AdapterView.OnItemClickListener itemClickListener = new jwi(this);
  private float mDensity;
  public Handler mHandler = new jwd(this);
  public Intent mIntent;
  arhz mProgress;
  public int mSource = 0;
  private View mask;
  long qN;
  protected ImageView rightViewImg;
  TextView rightViewText;
  int screenHeight = 0;
  public String shareUrl;
  int titleHeight = 0;
  public String uin;
  public ausj v = null;
  
  public AccountDetailActivity()
  {
    this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail = null;
    this.jdField_e_of_type_Ausj = null;
    this.jdField_b_of_type_Acje = new jvr(this);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, Intent paramIntent)
  {
    if ((paramIntent == null) || (!paramIntent.hasExtra("source"))) {
      return;
    }
    switch (paramIntent.getIntExtra("source", 0))
    {
    default: 
      return;
    case 1: 
      kbp.a(paramQQAppInterface, "P_CliOper", "Pb_account_lifeservice", paramString, "0X800574C", "0X800574C", 0, 0, paramString, "", "", "", false);
      return;
    case 2: 
      kbp.a(paramQQAppInterface, "P_CliOper", "Pb_account_lifeservice", paramString, "0X800574D", "0X800574D", 0, 0, paramString, "", "", "", false);
      return;
    case 3: 
      kbp.a(paramQQAppInterface, "P_CliOper", "Pb_account_lifeservice", paramString, "0X800574E", "0X800574E", 0, 0, paramString, "", "", "", false);
      return;
    }
    kbp.a(paramQQAppInterface, "P_CliOper", "Pb_account_lifeservice", paramString, "0X800589D", "0X800589D", 0, 0, paramString, "", "", "", false);
  }
  
  private List<ShareActionSheetBuilder.ActionSheetItem>[] a()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = new ShareActionSheetBuilder.ActionSheetItem();
    ((ShareActionSheetBuilder.ActionSheetItem)localObject).label = super.getString(2131698630);
    ((ShareActionSheetBuilder.ActionSheetItem)localObject).icon = 2130839252;
    ((ShareActionSheetBuilder.ActionSheetItem)localObject).iconNeedBg = true;
    ((ShareActionSheetBuilder.ActionSheetItem)localObject).action = 2;
    ((ShareActionSheetBuilder.ActionSheetItem)localObject).argus = "";
    localArrayList.add(localObject);
    localObject = new ShareActionSheetBuilder.ActionSheetItem();
    ((ShareActionSheetBuilder.ActionSheetItem)localObject).label = super.getString(2131698643);
    ((ShareActionSheetBuilder.ActionSheetItem)localObject).icon = 2130839253;
    ((ShareActionSheetBuilder.ActionSheetItem)localObject).iconNeedBg = true;
    ((ShareActionSheetBuilder.ActionSheetItem)localObject).action = 3;
    ((ShareActionSheetBuilder.ActionSheetItem)localObject).argus = "";
    localArrayList.add(localObject);
    localObject = new ShareActionSheetBuilder.ActionSheetItem();
    ((ShareActionSheetBuilder.ActionSheetItem)localObject).label = super.getString(2131698652);
    ((ShareActionSheetBuilder.ActionSheetItem)localObject).icon = 2130839256;
    ((ShareActionSheetBuilder.ActionSheetItem)localObject).action = 9;
    ((ShareActionSheetBuilder.ActionSheetItem)localObject).argus = "";
    localArrayList.add(localObject);
    localObject = new ShareActionSheetBuilder.ActionSheetItem();
    ((ShareActionSheetBuilder.ActionSheetItem)localObject).label = super.getString(2131698633);
    ((ShareActionSheetBuilder.ActionSheetItem)localObject).icon = 2130839249;
    ((ShareActionSheetBuilder.ActionSheetItem)localObject).action = 10;
    ((ShareActionSheetBuilder.ActionSheetItem)localObject).argus = "";
    localArrayList.add(localObject);
    asgx.g(this, localArrayList);
    localObject = new ArrayList();
    if (yr())
    {
      localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
      localActionSheetItem.label = super.getString(2131697409);
      localActionSheetItem.icon = 2130843495;
      localActionSheetItem.iconNeedBg = true;
      localActionSheetItem.action = 30;
      localActionSheetItem.argus = "";
      ((ArrayList)localObject).add(localActionSheetItem);
    }
    ShareActionSheetBuilder.ActionSheetItem localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = super.getString(2131697470);
    localActionSheetItem.icon = 2130843487;
    localActionSheetItem.iconNeedBg = true;
    localActionSheetItem.action = 31;
    localActionSheetItem.argus = "";
    ((ArrayList)localObject).add(localActionSheetItem);
    localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = super.getString(2131697451);
    localActionSheetItem.icon = 2130843479;
    localActionSheetItem.iconNeedBg = true;
    localActionSheetItem.action = 11;
    localActionSheetItem.argus = "";
    ((ArrayList)localObject).add(localActionSheetItem);
    if (yr())
    {
      localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
      localActionSheetItem.label = super.getString(2131697480);
      localActionSheetItem.icon = 2130843505;
      localActionSheetItem.iconNeedBg = true;
      localActionSheetItem.action = 32;
      localActionSheetItem.argus = "";
      ((ArrayList)localObject).add(localActionSheetItem);
    }
    return (List[])new ArrayList[] { localArrayList, localObject };
  }
  
  private void aAk()
  {
    if (this.ace)
    {
      ogj.c(this, "from_account_detail", 3, true);
      this.ace = false;
    }
  }
  
  private void aAm()
  {
    MiniGamePublicAccountHelper.launchMiniGamePublicAccount(this);
  }
  
  protected static boolean b(AccountDetail paramAccountDetail)
  {
    boolean bool2 = true;
    if (paramAccountDetail == null) {
      return false;
    }
    int i = ocp.getAccountType(paramAccountDetail.accountFlag);
    boolean bool1 = bool2;
    if (i != -2)
    {
      bool1 = bool2;
      if (i != -3)
      {
        if (i != -4) {
          break label42;
        }
        bool1 = bool2;
      }
    }
    for (;;)
    {
      return bool1;
      label42:
      bool1 = bool2;
      if (ocp.F(paramAccountDetail.accountFlag2) != -8L) {
        bool1 = false;
      }
    }
  }
  
  private boolean cW(int paramInt)
  {
    boolean bool2 = false;
    long l1 = anze.a().hf();
    Object localObject = anze.a().a(Long.valueOf(l1));
    boolean bool1 = bool2;
    if (localObject != null)
    {
      int i = ((structmsg.StructMsg)localObject).msg_type.get();
      l1 = ((structmsg.StructMsg)localObject).msg_seq.get();
      long l2 = ((structmsg.StructMsg)localObject).req_uin.get();
      int j = ((structmsg.StructMsg)localObject).msg.sub_type.get();
      int k = ((structmsg.StructMsg)localObject).msg.src_id.get();
      int m = ((structmsg.StructMsg)localObject).msg.sub_src_id.get();
      int n = ((structmsg.StructMsg)localObject).msg.group_msg_type.get();
      localObject = ((structmsg.StructMsg)localObject).msg.actions.get();
      bool1 = bool2;
      if (localObject != null)
      {
        bool1 = bool2;
        if (paramInt < ((List)localObject).size())
        {
          this.app.a().a().a(i, l1, l2, j, k, m, n, (structmsg.SystemMsgActionInfo)((structmsg.SystemMsgAction)((List)localObject).get(paramInt)).action_info.get(), paramInt);
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public static String dX(String paramString)
  {
    if (paramString != null) {
      try
      {
        int i = paramString.indexOf("article_id=");
        if (i > 0)
        {
          String str = paramString.substring(i + 11);
          i = str.indexOf("&");
          paramString = str;
          if (i >= 0) {
            paramString = str.substring(0, i);
          }
          return paramString;
        }
      }
      catch (Exception paramString) {}
    }
    return "";
  }
  
  private boolean jdMethod_do(String paramString)
  {
    Object localObject = this.app.a().a();
    int i = ocp.e(this.app, this.uin);
    RecentUser localRecentUser = ((acxw)localObject).b(paramString, i);
    localObject = localRecentUser;
    if (localRecentUser == null)
    {
      QLog.d("com.tencent.biz.pubaccount.AccountDetailActivity", 1, "isPublicAccoutMsgTabSetTop pUin = " + paramString + " userType = " + i + " not in the msglist");
      localObject = new RecentUser(this.uin, i);
    }
    return ((RecentUser)localObject).showUpTime != 0L;
  }
  
  private void ls(String paramString)
  {
    acxw localacxw = this.app.a().a();
    int i = ocp.e(this.app, this.uin);
    if (i == 1024) {
      QLog.d("com.tencent.biz.pubaccount.AccountDetailActivity", 1, "setOrCancelTop pUin = " + paramString + " userType = " + i + " is UIN_TYPE_BUSINESS_CMR_TMP");
    }
    RecentUser localRecentUser = localacxw.b(paramString, i);
    Object localObject = localRecentUser;
    if (localRecentUser == null)
    {
      QLog.d("com.tencent.biz.pubaccount.AccountDetailActivity", 1, "setOrCancelTop pUin = " + paramString + " userType = " + i + " not in the msglist");
      localObject = new RecentUser(this.uin, i);
    }
    boolean bool = jdMethod_do(paramString);
    if (bool)
    {
      ((RecentUser)localObject).showUpTime = 0L;
      localacxw.e((RecentUser)localObject);
      localObject = this.app.getHandler(Conversation.class);
      if (localObject != null) {
        ((MqqHandler)localObject).sendEmptyMessage(1009);
      }
      if (bool) {
        break label226;
      }
    }
    label226:
    for (bool = true;; bool = false)
    {
      odv.h(i, paramString, bool);
      return;
      ((RecentUser)localObject).showUpTime = (System.currentTimeMillis() / 1000L);
      break;
    }
  }
  
  private boolean yt()
  {
    return Build.VERSION.SDK_INT < 19;
  }
  
  protected void Qq()
  {
    this.jdField_e_of_type_Ausj = ((ausj)auss.a(this, null));
    if ((this.uin.equals("1770946116")) || (jqs.b(this.app, this.uin)))
    {
      this.jdField_e_of_type_Ausj.addButton(2131697472, 5);
      this.jdField_e_of_type_Ausj.addButton(2131697451, 5);
      if (yr()) {
        this.jdField_e_of_type_Ausj.addButton(2131697480, 3);
      }
      this.jdField_e_of_type_Ausj.addCancelButton(2131721058);
      this.jdField_e_of_type_Ausj.a(new jvt(this));
      this.jdField_e_of_type_Ausj.setOnDismissListener(new jvu(this));
      if (!this.jdField_e_of_type_Ausj.isShowing())
      {
        this.ach = false;
        this.jdField_e_of_type_Ausj.show();
      }
      return;
    }
    if (yr()) {
      if ((nyn.f(this.app, this.uin)) || (nyn.i(this.app, this.uin)))
      {
        this.jdField_e_of_type_Ausj.addButton(2131697472, 5);
        this.jdField_e_of_type_Ausj.addButton(2131697451, 5);
        this.jdField_e_of_type_Ausj.addCancelButton(2131721058);
        this.jdField_e_of_type_Ausj.a(new jvv(this));
      }
    }
    for (;;)
    {
      this.jdField_e_of_type_Ausj.setOnDismissListener(new jvz(this));
      if (this.jdField_e_of_type_Ausj.isShowing()) {
        break;
      }
      this.ach = false;
      this.jdField_e_of_type_Ausj.show();
      return;
      if (nyn.e(this.app, this.uin))
      {
        this.jdField_e_of_type_Ausj.addButton(2131697472, 5);
        this.jdField_e_of_type_Ausj.addButton(2131697451, 5);
        if (jdMethod_do(this.uin)) {
          this.jdField_e_of_type_Ausj.addButton(2131697393, 5);
        }
        for (;;)
        {
          this.jdField_e_of_type_Ausj.addCancelButton(2131721058);
          this.jdField_e_of_type_Ausj.a(new jvw(this));
          break;
          this.jdField_e_of_type_Ausj.addButton(2131697469, 5);
        }
      }
      this.jdField_e_of_type_Ausj.addButton(2131697472, 5);
      this.jdField_e_of_type_Ausj.addButton(2131697451, 5);
      if (yr()) {
        this.jdField_e_of_type_Ausj.addButton(2131697480, 3);
      }
      this.jdField_e_of_type_Ausj.addCancelButton(2131721058);
      this.jdField_e_of_type_Ausj.a(new jvx(this));
      continue;
      this.jdField_e_of_type_Ausj.addButton(2131697472, 5);
      this.jdField_e_of_type_Ausj.addButton(2131697451, 5);
      this.jdField_e_of_type_Ausj.addCancelButton(2131721058);
      this.jdField_e_of_type_Ausj.a(new jvy(this));
    }
  }
  
  public acje a()
  {
    return this.jdField_b_of_type_Acje;
  }
  
  public JSONObject a(BaseActivity paramBaseActivity, String paramString)
  {
    for (;;)
    {
      try
      {
        Object localObject1 = paramBaseActivity.app.b().a(paramString, 0, new int[] { -1000, -2000, -2002, -2011, -2022 }, 40);
        paramBaseActivity = new ArrayList();
        if (localObject1 != null)
        {
          i = ((List)localObject1).size();
          if (i > 0)
          {
            if (((MessageRecord)((List)localObject1).get(i - 1)).issend != 0) {
              break label712;
            }
            paramBaseActivity.add(((List)localObject1).get(i - 1));
            if (paramBaseActivity.size() <= 4) {
              break label712;
            }
          }
        }
        localObject1 = new JSONObject();
        JSONArray localJSONArray = new JSONArray();
        JSONObject localJSONObject1 = new JSONObject();
        JSONObject localJSONObject2 = new JSONObject();
        Object localObject2 = this.app.getAccount();
        localJSONObject2.put("qq", localObject2);
        Object localObject3 = ((TicketManager)this.app.getManager(2)).getSkey(this.app.getCurrentAccountUin());
        String str = String.valueOf(NetConnInfoCenter.getServerTime());
        localJSONObject2.put("skey", localObject3);
        localJSONObject2.put("mpUin", paramString);
        localJSONObject2.put("timestamp", "" + str);
        localJSONObject2.put("scene", "201");
        localJSONObject2.put("subAppname", "profile");
        localJSONObject2.put("sign", arwv.encodeHexStr((String)localObject2 + paramString + 201 + str + "jubao@article@123").toLowerCase());
        if (paramBaseActivity != null)
        {
          int j = 0;
          if (j < paramBaseActivity.size())
          {
            paramString = new JSONObject();
            localObject2 = new JSONObject();
            localObject3 = (MessageRecord)paramBaseActivity.get(j);
            if ((localObject3 instanceof MessageForText))
            {
              ((JSONObject)localObject2).put("text", ((MessageRecord)localObject3).msg);
              i = 1;
              paramString.put("content", localObject2);
              paramString.put("messageType", "" + i);
              localJSONArray.put(j, paramString);
              j += 1;
              continue;
            }
            if ((localObject3 instanceof MessageForPic))
            {
              ((JSONObject)localObject2).put("fileUuid", ((MessageForPic)localObject3).uuid);
              i = 2;
              continue;
            }
            if ((localObject3 instanceof MessageForPtt))
            {
              ((JSONObject)localObject2).put("fileUuid", ((MessageForPtt)localObject3).urlAtServer);
              ((JSONObject)localObject2).put("fileType", ((MessageForPtt)localObject3).busiType);
              i = 3;
              continue;
            }
            if ((localObject3 instanceof MessageForShortVideo))
            {
              ((JSONObject)localObject2).put("fileUuid", ((MessageForShortVideo)localObject3).uuid.substring(1));
              i = 4;
              continue;
            }
            if ((localObject3 instanceof MessageForStructing))
            {
              ((JSONObject)localObject2).put("text", new String(ansi.d(avjj.P(anre.a(((MessageRecord)localObject3).msgData).getXmlBytes()), 0), "utf-8"));
              i = 5;
              continue;
            }
          }
          else
          {
            ((JSONObject)localObject1).put("msgNum", "" + paramBaseActivity.size());
            ((JSONObject)localObject1).put("messageList", aqgo.encodeToString(localJSONArray.toString().getBytes("utf-8"), 0));
          }
        }
        else
        {
          localJSONObject1.put("Verify", localJSONObject2);
          localJSONObject1.put("reportData", localObject1);
          return localJSONObject1;
        }
      }
      catch (Exception paramBaseActivity)
      {
        return null;
      }
      int i = 0;
      continue;
      label712:
      i -= 1;
    }
  }
  
  public smu.a a()
  {
    smu.a locala = null;
    if (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail != null)
    {
      locala = new smu.a(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.uin, this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.name, this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.summary);
      locala.bxN = smu.a.bxM;
      locala.isFollowed = yq();
      locala.aDn = kbp.a(this.app, this.uin, this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail);
    }
    return locala;
  }
  
  public void a(AccountDetail paramAccountDetail, boolean paramBoolean)
  {
    ThreadManager.getSubThreadHandler().postDelayed(new AccountDetailActivity.27(this, paramAccountDetail, paramBoolean), 10L);
  }
  
  protected void a(String paramString1, int paramInt, String paramString2, Class<? extends Activity> paramClass)
  {
    a(paramString1, paramInt, paramString2, paramClass, false);
  }
  
  protected void a(String paramString1, int paramInt, String paramString2, Class<? extends Activity> paramClass, boolean paramBoolean)
  {
    if ((TextUtils.equals("2290230341", paramString1)) && (QZoneMsgActivity.e(this, this.app))) {
      return;
    }
    Intent localIntent = new Intent();
    Bundle localBundle = new Bundle();
    if ((getIntent().hasExtra("qidian_chat")) && (getIntent().getBooleanExtra("qidian_chat", false)))
    {
      localIntent.setComponent(new ComponentName(this, SplashActivity.class));
      localBundle.putBoolean("open_chatfragment", true);
    }
    for (;;)
    {
      localBundle.putString("uin", paramString1);
      localBundle.putInt("uintype", paramInt);
      localBundle.putString("uinname", paramString2);
      localIntent.putExtras(localBundle);
      localIntent.setFlags(67108864);
      boolean bool = this.mIntent.getBooleanExtra("need_finish", false);
      if (this.abV)
      {
        localIntent.putExtra("forward_type", -1);
        localIntent.putExtra("forward_text", this.Ut);
        this.abV = false;
      }
      if (bool) {
        super.finish();
      }
      localIntent.putExtra("isforceRequestDetail", paramBoolean);
      localIntent.putExtra("jump_from", 2);
      super.startActivity(localIntent);
      return;
      localIntent.setComponent(new ComponentName(this, paramClass));
    }
  }
  
  void a(vbi.b paramb)
  {
    if (paramb == null) {
      if (QLog.isColorLevel()) {
        QLog.d("com.tencent.biz.pubaccount.AccountDetailActivity", 2, "updateCurrentImage currentImage is null");
      }
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("com.tencent.biz.pubaccount.AccountDetailActivity", 2, "updateCurrentImage uin=" + paramb.toUin + ", state=" + paramb.state);
      }
    } while (paramb.state != 6);
    lu(paramb.filePath);
  }
  
  void aAd()
  {
    this.iU = super.findViewById(2131361933);
    this.iU.setVisibility(8);
    this.aDH = this.iU.getLayoutParams().height;
    this.iV = super.findViewById(2131361890);
    this.iW = super.findViewById(2131364181);
    this.iV.setVisibility(8);
    this.iW.setVisibility(8);
    this.iS = super.findViewById(2131367382);
    this.iS.setVisibility(8);
    this.iT = super.findViewById(2131361891);
    this.iT.setVisibility(8);
    super.setTitle(2131697399);
    this.mProgress = new arhz(this, super.getTitleBarHeight());
    this.mProgress.setCanceledOnTouchOutside(true);
    this.bH = ((Button)super.findViewById(2131377803));
    this.bH.setOnClickListener(this);
    this.bI = ((Button)super.findViewById(2131378001));
    this.bI.setText(2131695276);
    this.bI.setOnClickListener(this);
    this.bI.setVisibility(8);
    this.bJ = ((Button)super.findViewById(2131381240));
    this.bJ.setText(2131695277);
    this.bJ.setOnClickListener(this);
    this.bJ.setVisibility(8);
    this.iR = super.findViewById(2131361892);
    this.iR.setVisibility(8);
  }
  
  public void aAe()
  {
    if (this.jdField_a_of_type_Jtg.abH)
    {
      this.jdField_b_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailXListView.setAdapter(null);
      this.jdField_b_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailXListView.lz(true);
      this.jdField_b_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailXListView.setAdapter(this.jdField_a_of_type_Jtg);
    }
    this.jdField_a_of_type_Jtg.abH = false;
  }
  
  void aAf()
  {
    super.finish();
    vnj.x(this, "");
  }
  
  protected void aAg()
  {
    try
    {
      this.jdField_b_of_type_ComTencentMobileqqMpMobileqq_mp$GetPublicAccountDetailInfoResponse = new mobileqq_mp.GetPublicAccountDetailInfoResponse();
      this.jdField_b_of_type_ComTencentMobileqqMpMobileqq_mp$GetPublicAccountDetailInfoResponse.mergeFrom(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.accountData);
      this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.newGroupInfoList = this.jdField_b_of_type_ComTencentMobileqqMpMobileqq_mp$GetPublicAccountDetailInfoResponse.config_group_info_new.get();
      if (this.jdField_b_of_type_ComTencentMobileqqMpMobileqq_mp$GetPublicAccountDetailInfoResponse.unified_account_descrpition.has())
      {
        this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.unifiedDesrpition = this.jdField_b_of_type_ComTencentMobileqqMpMobileqq_mp$GetPublicAccountDetailInfoResponse.unified_account_descrpition.get();
        this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.parser();
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.seqno = 0;
      return;
    }
    catch (Exception localException) {}
  }
  
  public void aAh()
  {
    Object localObject;
    if (acbn.blP.equals(this.uin)) {
      localObject = new JSONObject();
    }
    try
    {
      ((JSONObject)localObject).put("channel_id", kvs.getChannelId());
      kbp.a(null, "", "0X8009944", "0X8009944", 0, 0, "", "", "", ((JSONObject)localObject).toString(), false);
      aqiy.bk(null, " pubAcc_follow_cancel", this.uin);
      if (QLog.isColorLevel()) {
        QLog.d("com.tencent.biz.pubaccount.AccountDetailActivity", 2, "unfollow");
      }
      oq(2131697481);
      if ((this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail == null) || (ocp.getAccountType(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.accountFlag) == -4))
      {
        if (this.jdField_f_of_type_MqqAppNewIntent != null) {
          this.jdField_f_of_type_MqqAppNewIntent.setObserver(null);
        }
        this.jdField_f_of_type_MqqAppNewIntent = new NewIntent(super.getApplicationContext(), kbs.class);
        this.jdField_f_of_type_MqqAppNewIntent.putExtra("cmd", "unfollow");
        localObject = new mobileqq_mp.UnFollowRequest();
        ((mobileqq_mp.UnFollowRequest)localObject).uin.set((int)Long.parseLong(this.uin));
        ((mobileqq_mp.UnFollowRequest)localObject).account_type.set(getAccountType());
        this.jdField_f_of_type_MqqAppNewIntent.putExtra("data", ((mobileqq_mp.UnFollowRequest)localObject).toByteArray());
        this.jdField_f_of_type_MqqAppNewIntent.putExtra("source", 1);
        this.jdField_c_of_type_MqqObserverBusinessObserver = new jwj(this);
        this.jdField_f_of_type_MqqAppNewIntent.setObserver(this.jdField_c_of_type_MqqObserverBusinessObserver);
        this.app.startServlet(this.jdField_f_of_type_MqqAppNewIntent);
        this.aDG += 1;
        ocp.n(this.app, this.uin);
        if (nyn.i(this.app, this.uin))
        {
          int i = ocp.e(this.app, this.uin);
          aalb.l(this.app, String.valueOf(this.uin), i);
        }
        if (QLog.isColorLevel()) {
          QLog.d("com.tencent.biz.pubaccount.AccountDetailActivity", 2, "unfollow exit");
        }
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.d("com.tencent.biz.pubaccount.AccountDetailActivity", 2, localException.getMessage());
        continue;
        if (this.jdField_d_of_type_Adai != null) {
          this.app.removeObserver(this.jdField_d_of_type_Adai);
        }
        this.jdField_d_of_type_Adai = new adai(new jwk(this));
        this.app.addObserver(this.jdField_d_of_type_Adai);
        adam.a(this.app, false, this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.uin, 1);
        this.aDG += 1;
      }
    }
  }
  
  public void aAi()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountUtilProfileParams != null) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        az(this);
      }
      return;
    }
  }
  
  protected void aAj()
  {
    if (this.mSource == 119)
    {
      doOnBackPressed();
      return;
    }
    ogj.c(this, "from_account_detail", 3, true);
  }
  
  protected void aAl()
  {
    ahua.es(this);
  }
  
  protected void aAn()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder = new ShareActionSheetBuilder(this);
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.setActionSheetTitle(getString(2131720177));
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.setActionSheetItems(a());
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.setItemClickListener(this.itemClickListener);
    }
    try
    {
      for (;;)
      {
        this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.show();
        return;
        this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.setActionSheetItems(a());
      }
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("ShareActionSheet", 2, "actionSheet.show exception=" + localException);
    }
  }
  
  public void aAo()
  {
    Intent localIntent = new Intent(getActivity(), PubAccountMoreInfoActivity.class);
    localIntent.putExtra("uin", this.uin);
    startActivity(localIntent);
  }
  
  public void aAp()
  {
    this.v = ausj.b(this);
    String str = getString(2131697482, new Object[] { getAccountName() });
    this.v.setMainTitle(str);
    this.v.addButton(2131698678, 3);
    this.v.addCancelButton(2131721058);
    this.v.setOnDismissListener(new jwa(this));
    this.v.a(new jwb(this));
    if (!this.v.isShowing())
    {
      this.aci = false;
      this.v.show();
    }
  }
  
  public void aAq()
  {
    if (yq())
    {
      this.abU = true;
      return;
    }
    this.abU = false;
  }
  
  void aAr()
  {
    this.bH.setVisibility(0);
    this.errorContainer.setVisibility(0);
    this.ez.setBackgroundColor(0);
    this.hI.setVisibility(8);
    this.hJ.setVisibility(8);
    this.jdField_b_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailXListView.setVisibility(8);
  }
  
  void aAs()
  {
    this.jdField_a_of_type_Jtg.B(ah());
    this.jdField_a_of_type_Jtg.C(ai());
    this.jdField_a_of_type_Jtg.D(aj());
    this.jdField_a_of_type_Jtg.lw(this.abG);
    this.jdField_a_of_type_Jtg.oi(mZ());
    if (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail != null) {
      this.jdField_a_of_type_Jtg.a(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail);
    }
  }
  
  public void aAt()
  {
    if ((this.mProgress != null) && (this.mProgress.isShowing())) {
      this.mProgress.dismiss();
    }
  }
  
  void aAu()
  {
    if (QLog.isColorLevel()) {
      QLog.d("com.tencent.biz.pubaccount.AccountDetailActivity", 2, "firstFetch");
    }
    azr();
    updateView();
  }
  
  public void aAv()
  {
    if (QLog.isColorLevel()) {
      QLog.d("com.tencent.biz.pubaccount.AccountDetailActivity", 2, "send839PublicAccountDetailInfoRequest");
    }
    kbu.a(Long.valueOf(Long.parseLong(this.uin)), "", new jwe(this));
  }
  
  protected void aAw()
  {
    if (TextUtils.isEmpty(this.uin)) {
      if (QLog.isColorLevel()) {
        QLog.d("com.tencent.biz.pubaccount.AccountDetailActivity", 2, "updateHDFace uin is null");
      }
    }
    do
    {
      return;
      if (aqiw.isWifiConnected(this)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("com.tencent.biz.pubaccount.AccountDetailActivity", 2, "updateHDFace not wifi, so need't update");
    return;
    this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity$b = new b(this.app, this);
    this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity$b.akY();
  }
  
  public void aAx()
  {
    if (TextUtils.isEmpty(this.uin)) {
      if (QLog.isColorLevel()) {
        QLog.d("com.tencent.biz.pubaccount.AccountDetailActivity", 2, "setHDFace uin is null");
      }
    }
    while (this.jdField_a_of_type_Jtg == null) {
      return;
    }
    Drawable localDrawable = aj();
    this.jdField_a_of_type_Jtg.D(localDrawable);
    this.jdField_a_of_type_Jtg.notifyDataSetChanged();
  }
  
  void aJ(Intent paramIntent)
  {
    this.acc = paramIntent.getBooleanExtra("fromBrowser", false);
    this.mSource = paramIntent.getIntExtra("source", 0);
    switch (this.mSource)
    {
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("com.tencent.biz.pubaccount.AccountDetailActivity", 2, "[fromwhere]:" + this.aDI);
      }
      anot.a(this.app, "P_CliOper", "Pb_account_lifeservice", this.uin, "0X8005A24", "0X8005A24", this.aDI, 0, "", "", "", "");
      return;
      this.aDI = 2;
      continue;
      this.aDI = 1;
      continue;
      this.aDI = 0;
      continue;
      this.aDI = 3;
      continue;
      this.aDI = 4;
      continue;
      this.aDI = 5;
      continue;
      this.aDI = 6;
      continue;
      this.aDI = 8;
      continue;
      this.aDI = 9;
      continue;
      this.aDI = 11;
      continue;
      this.aDI = 50;
      continue;
      this.aDI = 12;
      continue;
      this.aDI = 13;
    }
  }
  
  public void aK(Intent paramIntent)
  {
    if ((this.acd) || (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail == null)) {
      return;
    }
    this.acd = true;
    this.acc = paramIntent.getBooleanExtra("fromBrowser", false);
    this.mSource = paramIntent.getIntExtra("source", 0);
    QQAppInterface localQQAppInterface;
    String str;
    int i;
    switch (this.mSource)
    {
    default: 
      if (this.acc) {
        this.aDI = 20;
      }
      if (QLog.isColorLevel()) {
        QLog.d("com.tencent.biz.pubaccount.AccountDetailActivity", 2, "[fromwhere]:" + this.aDI);
      }
      localQQAppInterface = this.app;
      str = this.uin;
      i = this.aDI;
      if (!yq()) {
        break;
      }
    }
    for (paramIntent = "02";; paramIntent = "01")
    {
      anot.a(localQQAppInterface, "dc01160", "Pb_account_lifeservice", str, "0X8007CA0", "0X8007CA0", i, 0, paramIntent, String.valueOf(this.aDI), String.valueOf(kbp.a(this.app, this.uin, this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail)), "");
      return;
      this.aDI = 11;
      break;
      this.aDI = 12;
      break;
      this.aDI = 13;
      break;
      this.aDI = 14;
      break;
      this.aDI = 15;
      break;
      this.aDI = 16;
      break;
      this.aDI = 17;
      break;
      this.aDI = 18;
      break;
      this.aDI = 19;
      break;
      this.aDI = 21;
      break;
    }
  }
  
  Drawable ah()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail == null) {
      return null;
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.configBackgroundImg)) {
      return URLDrawable.getDrawable(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.configBackgroundImg);
    }
    ThreadManager.getSubThreadHandler().postDelayed(new AccountDetailActivity.25(this), 10L);
    return null;
  }
  
  Drawable ai()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail == null) {}
    do
    {
      return null;
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.configBackgroundColor)) {
        this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.configBackgroundColor = "3d7fe3";
      }
      try
      {
        ColorDrawable localColorDrawable = new ColorDrawable(Color.parseColor("#E6" + this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.configBackgroundColor.substring(0, 6)));
        return localColorDrawable;
      }
      catch (StringIndexOutOfBoundsException localStringIndexOutOfBoundsException) {}
    } while (!QLog.isColorLevel());
    QLog.d("com.tencent.biz.pubaccount.AccountDetailActivity", 2, "configBackgroundColor length is not 6!");
    return null;
  }
  
  protected Drawable aj()
  {
    Object localObject;
    if (this.cq != null) {
      localObject = this.cq;
    }
    aqdj localaqdj;
    do
    {
      return localObject;
      localObject = new File(aqep.pe(this.uin));
      if (((File)localObject).isFile())
      {
        lu(((File)localObject).getAbsolutePath());
        return aqdj.a(this.app, 115, this.uin);
      }
      localaqdj = aqdj.a(this.app, 115, this.uin);
      localObject = localaqdj;
    } while (this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity$a != null);
    this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity$a = new a(this);
    addObserver(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity$a);
    return localaqdj;
  }
  
  void az(Activity paramActivity)
  {
    if (this.jdField_a_of_type_Swe == null) {
      this.jdField_a_of_type_Swe = new swe(paramActivity);
    }
    String str = this.app.getApplication().getString(2131720024);
    paramActivity = new jvs(this, paramActivity);
    this.jdField_a_of_type_Swe.c(str, paramActivity);
    this.jdField_a_of_type_Swe.a(paramActivity);
    this.jdField_a_of_type_Swe.show();
  }
  
  protected void azB()
  {
    aqiy.bk(null, "pubAcc_follow_confirm", this.uin);
    if (QLog.isColorLevel()) {
      QLog.d("com.tencent.biz.pubaccount.AccountDetailActivity", 2, "follow uin=" + this.uin);
    }
    this.abX = true;
    this.iS.postDelayed(new AccountDetailActivity.7(this), 3000L);
    oq(2131697407);
    if (ocp.getAccountType(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.accountFlag) == -4)
    {
      this.jdField_e_of_type_MqqAppNewIntent = new NewIntent(super.getApplicationContext(), kbs.class);
      this.jdField_e_of_type_MqqAppNewIntent.putExtra("cmd", "follow");
      mobileqq_mp.FollowRequest localFollowRequest = new mobileqq_mp.FollowRequest();
      localFollowRequest.ext.set("1");
      localFollowRequest.uin.set((int)Long.parseLong(this.uin));
      localFollowRequest.account_type.set(getAccountType());
      this.jdField_e_of_type_MqqAppNewIntent.putExtra("data", localFollowRequest.toByteArray());
      this.jdField_e_of_type_MqqAppNewIntent.putExtra("source", 1);
      this.jdField_b_of_type_MqqObserverBusinessObserver = new jwl(this);
      this.jdField_e_of_type_MqqAppNewIntent.setObserver(this.jdField_b_of_type_MqqObserverBusinessObserver);
      this.app.startServlet(this.jdField_e_of_type_MqqAppNewIntent);
    }
    for (;;)
    {
      this.aDG += 1;
      kbp.g(this.app, this.uin, 1);
      if (QLog.isColorLevel()) {
        QLog.d("com.tencent.biz.pubaccount.AccountDetailActivity", 2, "follow exit");
      }
      return;
      this.ace = true;
      this.app.removeObserver(this.jdField_c_of_type_Adai);
      this.jdField_c_of_type_Adai = new adai(new jwm(this));
      this.app.addObserver(this.jdField_c_of_type_Adai);
      adam.a(this.app, true, this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.uin, 1);
    }
  }
  
  protected void azC()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail != null) {
      this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.accountData = this.jdField_b_of_type_ComTencentMobileqqMpMobileqq_mp$GetPublicAccountDetailInfoResponse.toByteArray();
    }
  }
  
  public void azD()
  {
    if ((TextUtils.isEmpty(this.uin)) || (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail == null)) {
      return;
    }
    if (this.jdField_a_of_type_Smu == null) {
      this.jdField_a_of_type_Smu = new smu(this.app, this, a(), getAccountType(), getShareUrl());
    }
    this.jdField_a_of_type_Smu.Qq();
    PublicAccountHandler.a(this.app, this.uin, "Pb_account_lifeservice", "mp_msg_sys_10", "pbshare_click");
  }
  
  void azE()
  {
    if (QLog.isColorLevel()) {
      QLog.d("com.tencent.biz.pubaccount.AccountDetailActivity", 2, "sendPublicAccountDetailInfoRequest");
    }
    if (this.jdField_d_of_type_MqqAppNewIntent != null) {
      this.jdField_d_of_type_MqqAppNewIntent.setObserver(null);
    }
    this.jdField_d_of_type_MqqAppNewIntent = new NewIntent(super.getApplicationContext(), kbs.class);
    this.jdField_d_of_type_MqqAppNewIntent.putExtra("cmd", "get_detail_info");
    mobileqq_mp.GetPublicAccountDetailInfoRequest localGetPublicAccountDetailInfoRequest = new mobileqq_mp.GetPublicAccountDetailInfoRequest();
    localGetPublicAccountDetailInfoRequest.versionInfo.set("3.4.4,3,3058");
    localGetPublicAccountDetailInfoRequest.version.set(1);
    if (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail != null) {
      localGetPublicAccountDetailInfoRequest.seqno.set(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.seqno);
    }
    try
    {
      for (;;)
      {
        localGetPublicAccountDetailInfoRequest.uin.set((int)Long.parseLong(this.uin));
        label125:
        this.jdField_d_of_type_MqqAppNewIntent.putExtra("data", localGetPublicAccountDetailInfoRequest.toByteArray());
        this.jdField_a_of_type_MqqObserverBusinessObserver = new jwf(this);
        this.jdField_d_of_type_MqqAppNewIntent.setObserver(this.jdField_a_of_type_MqqObserverBusinessObserver);
        this.app.startServlet(this.jdField_d_of_type_MqqAppNewIntent);
        this.aDG += 1;
        if (QLog.isColorLevel()) {
          QLog.d("com.tencent.biz.pubaccount.AccountDetailActivity", 2, "sendPublicAccountDetailInfoRequest exit");
        }
        return;
        localGetPublicAccountDetailInfoRequest.seqno.set(0);
      }
    }
    catch (Exception localException)
    {
      break label125;
    }
  }
  
  @TargetApi(9)
  protected void azo()
  {
    this.jdField_b_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailXListView = ((AccountDetailXListView)super.findViewById(2131361876));
    this.screenHeight = getWindowManager().getDefaultDisplay().getHeight();
    if (Build.VERSION.SDK_INT >= 9) {
      this.jdField_b_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailXListView.setOverScrollMode(2);
    }
    this.jdField_b_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailXListView.setDividerHeight(0);
    this.jdField_b_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailXListView.setRefreshCallback(this);
    azy();
  }
  
  protected void azr()
  {
    azE();
  }
  
  public void azt()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail != null) {
      a(this.uin, 1008, this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.name, ChatActivity.class);
    }
  }
  
  protected void azu()
  {
    ThreadManager.getSubThreadHandler().postDelayed(new AccountDetailActivity.20(this), 10L);
  }
  
  public void azv()
  {
    ThreadManager.getSubThreadHandler().postDelayed(new AccountDetailActivity.3(this), 10L);
  }
  
  public void azw()
  {
    ThreadManager.getSubThreadHandler().postDelayed(new AccountDetailActivity.6(this), 10L);
  }
  
  protected void azx()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail == null) || (this.abG)) {}
    label272:
    for (;;)
    {
      return;
      boolean bool = this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.isShowFollowButton;
      if (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.followType == 1) {
        if ((this.uin.equals("1770946116")) || (jqs.b(this.app, this.uin)))
        {
          this.bI.setVisibility(0);
          this.iS.setVisibility(8);
          this.iU.setVisibility(0);
          if (!yp()) {
            break label253;
          }
          this.iV.setVisibility(0);
          this.iW.setVisibility(0);
          this.iW.setOnClickListener(this);
        }
      }
      for (;;)
      {
        if ((this.bI.getVisibility() != 8) || (this.iS.getVisibility() != 8)) {
          break label272;
        }
        this.iU.setVisibility(8);
        return;
        this.bI.setVisibility(0);
        this.iS.setVisibility(8);
        this.iR.setVisibility(0);
        this.bJ.setVisibility(0);
        this.iU.setVisibility(0);
        break;
        if (bool)
        {
          this.iS.setVisibility(0);
          this.iS.setOnClickListener(this);
        }
        this.bI.setVisibility(8);
        this.iR.setVisibility(8);
        this.bJ.setVisibility(8);
        this.iU.setVisibility(0);
        break;
        label253:
        this.iV.setVisibility(8);
        this.iW.setVisibility(8);
      }
    }
  }
  
  protected void azy()
  {
    if ((this.jdField_a_of_type_Jtg == null) || (this.jdField_b_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailXListView.getAdapter() == null) || ((this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail != null) && (this.jdField_a_of_type_Jtg.a() == null)))
    {
      if (this.jdField_b_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailXListView.getAdapter() != null)
      {
        ((jtg)this.jdField_b_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailXListView.getAdapter()).destroy();
        this.jdField_b_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailXListView.setAdapter(null);
      }
      this.jdField_a_of_type_Jtg = new jtg(this.app, this, this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail, this.uin, this.abG, this.jdField_b_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailXListView, this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailTopGestureLayout);
      this.jdField_a_of_type_Jtg.a(this.hI, this.hJ, this.ez, this.hK, this.bK);
      aAs();
      if (!this.abG) {
        this.jdField_b_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailXListView.lz(false);
      }
      this.jdField_a_of_type_Jtg.a(new jwc(this));
      this.jdField_b_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailXListView.setAdapter(this.jdField_a_of_type_Jtg);
      return;
    }
    aAs();
    this.jdField_a_of_type_Jtg.notifyDataSetChanged();
  }
  
  Drawable b(Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      return null;
    }
    try
    {
      paramBitmap = s(paramBitmap);
      aqmp.fastblur(paramBitmap, 1);
      paramBitmap = new BitmapDrawable(paramBitmap);
      return paramBitmap;
    }
    catch (OutOfMemoryError paramBitmap) {}
    return null;
  }
  
  protected List<jzs.a> b(List<jzs.a> paramList, boolean paramBoolean)
  {
    if (paramBoolean) {
      return paramList;
    }
    ArrayList localArrayList = new ArrayList(2);
    int j = paramList.size();
    int i = 0;
    while (i < j)
    {
      jzs.a locala = (jzs.a)paramList.get(i);
      if ((locala.type == 3) && ((locala.aGH == 7) || (locala.aGH == 8))) {
        localArrayList.add(locala);
      }
      i += 1;
    }
    return localArrayList;
  }
  
  void b(AccountDetail paramAccountDetail)
  {
    if (QLog.isColorLevel()) {
      QLog.d("com.tencent.biz.pubaccount.AccountDetailActivity", 2, "saveAccountDetailToDBAndCache");
    }
    Object localObject = this.app.a().createEntityManager();
    if ((this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail != null) && (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.getId() != -1L))
    {
      if (QLog.isColorLevel()) {
        QLog.d("com.tencent.biz.pubaccount.AccountDetailActivity", 2, paramAccountDetail.name);
      }
      this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.clone(paramAccountDetail);
      if (!((EntityManager)localObject).update(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail)) {
        ((EntityManager)localObject).drop(AccountDetail.class);
      }
    }
    for (;;)
    {
      ((EntityManager)localObject).close();
      localObject = (acja)this.app.getManager(56);
      if ((localObject != null) && (paramAccountDetail != null))
      {
        ((acja)localObject).f(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail);
        if (paramAccountDetail.followType == 1) {
          ((acja)localObject).c(PublicAccountInfo.createPublicAccount(paramAccountDetail, 0L));
        }
      }
      return;
      this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail = paramAccountDetail;
      ((EntityManager)localObject).persist(paramAccountDetail);
    }
  }
  
  void c(AccountDetail paramAccountDetail)
  {
    if (paramAccountDetail == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("com.tencent.biz.pubaccount.AccountDetailActivity", 2, "deleteAccount");
    }
    EntityManager localEntityManager = this.app.a().createEntityManager();
    localEntityManager.remove(paramAccountDetail);
    localEntityManager.close();
  }
  
  String d(Intent paramIntent)
  {
    Object localObject = null;
    if (paramIntent != null) {
      paramIntent = paramIntent.getStringExtra("uin");
    }
    do
    {
      return paramIntent;
      paramIntent = localObject;
    } while (this.jdField_a_of_type_ComTencentBizPubaccountUtilProfileParams == null);
    return this.jdField_a_of_type_ComTencentBizPubaccountUtilProfileParams.a().apc;
  }
  
  public void d(ListView paramListView)
  {
    if (this.ack)
    {
      if (QLog.isColorLevel()) {
        QLog.d("com.tencent.biz.pubaccount.AccountDetailActivity", 2, "startLoadMore: uin=" + this.uin);
      }
      juc.c(this.app, Long.parseLong(this.uin), this.jdField_b_of_type_Acje);
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    do
    {
      do
      {
        return super.dispatchTouchEvent(paramMotionEvent);
      } while (!this.abX);
      this.acj = true;
      return true;
    } while (!this.acj);
    this.acj = false;
    return true;
  }
  
  public void doOnBackPressed()
  {
    int i;
    int j;
    if (this.jdField_a_of_type_ComTencentBizPubaccountUtilProfileParams != null)
    {
      i = 1;
      if (this.abY) {
        break label138;
      }
      j = 1;
      label18:
      if ((i == 0) || (!this.abY)) {
        break label143;
      }
      moveTaskToBack(true);
    }
    for (;;)
    {
      if (!yq()) {
        lt("0X8005B6E");
      }
      if (getIntent().getBooleanExtra("from_newer_guide", false))
      {
        Intent localIntent = new Intent();
        localIntent.putExtra("has_operation", yq());
        localIntent.putExtra("uin", this.uin);
        setResult(-1, localIntent);
      }
      if ((this.jdField_a_of_type_Jtg != null) && (this.jdField_a_of_type_Jtg.a() != null)) {
        this.jdField_a_of_type_Jtg.a().azR();
      }
      super.doOnBackPressed();
      return;
      i = 0;
      break;
      label138:
      j = 0;
      break label18;
      label143:
      if ((i != 0) && (j != 0) && (super.isTaskRoot())) {
        super.startActivity(new Intent(this, SplashActivity.class));
      }
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    this.mNeedStatusTrans = true;
    this.mActNeedImmersive = false;
    this.enterTime = System.currentTimeMillis();
    super.doOnCreate(paramBundle);
    if ((this.mFlingHandler != null) && ((this.mFlingHandler instanceof FlingGestureHandler)))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailTopGestureLayout = new AccountDetailTopGestureLayout(this);
      ((FlingGestureHandler)this.mFlingHandler).setTopLayout(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailTopGestureLayout);
    }
    this.mIntent = getIntent();
    init(this.mIntent);
    if (this.uin != null)
    {
      if ((getClass().equals(AccountDetailActivity.class)) && ((jqs.b(this.app, this.uin)) || (asgx.ag(this.app, this.uin))))
      {
        jqs.a(this, this.mIntent, this.mIntent.getStringExtra("uin"), this.mIntent.getBooleanExtra("need_finish", false), this.mIntent.getIntExtra("source", -1), true, -1);
        finish();
        return true;
      }
      initData();
    }
    aK(this.mIntent);
    super.addObserver(this.jdField_b_of_type_Acje);
    this.acf = this.mIntent.getBooleanExtra("from_js", false);
    if (this.acf)
    {
      aAo();
      finish();
    }
    this.jdField_f_of_type_MqqOsMqqHandler = new MqqHandler(Looper.getMainLooper());
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    super.removeObserver(this.jdField_b_of_type_Acje);
    super.removeObserver(this.jdField_c_of_type_Adai);
    super.removeObserver(this.jdField_d_of_type_Adai);
    super.removeObserver(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity$a);
    this.qN = System.currentTimeMillis();
    long l = (this.qN - this.enterTime) / 1000L;
    String str2 = this.uin;
    String str3 = l + "";
    if (yq()) {}
    for (String str1 = "02";; str1 = "01")
    {
      kbp.a(null, str2, "0X8007800", "0X8007800", 0, 0, str3, "", str1, String.valueOf(kbp.a(this.app, this.uin, this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail)), false);
      if ((this.jdField_a_of_type_Jtg != null) && (this.jdField_a_of_type_Jtg.a() != null)) {
        this.jdField_a_of_type_Jtg.a().azR();
      }
      return;
    }
  }
  
  public void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    this.cq = null;
    this.mIntent = paramIntent;
    init(this.mIntent);
    if (this.uin != null) {
      initData();
    }
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    this.abY = false;
    if (this.mProgress != null) {
      this.mProgress.dismiss();
    }
    this.mProgress = null;
    if ((this.jdField_a_of_type_Jtg != null) && (this.jdField_a_of_type_Jtg.a() != null)) {
      this.jdField_a_of_type_Jtg.a().azQ();
    }
    AbstractGifImage.pauseAll();
  }
  
  protected String getAccountName()
  {
    String str = "";
    if (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail != null) {
      str = this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.name;
    }
    return str;
  }
  
  public int getAccountType()
  {
    return 1;
  }
  
  public String getShareUrl()
  {
    if (this.shareUrl == null)
    {
      int i = ocp.getAccountType(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.accountFlag);
      if ((i != -2) && (i != -5)) {
        break label84;
      }
    }
    label84:
    for (this.shareUrl = ("https://share.mp.qq.com/cgi/share.php?uin=" + this.uin + "&account_flag=" + this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.accountFlag + "&jumptype=1&card_type=public_account");; this.shareUrl = ("https://post.mp.qq.com/tmpl/default/client/article/html/jump.html?action=accountCard&puin=" + this.uin)) {
      return this.shareUrl;
    }
  }
  
  void init(Intent paramIntent)
  {
    this.app = ((QQAppInterface)super.getAppRuntime());
    Object localObject = paramIntent.getExtras();
    if (localObject != null)
    {
      localObject = (ProfileParams)((Bundle)localObject).getParcelable("profile_params");
      if (localObject != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountUtilProfileParams = ((ProfileParams)localObject);
      }
    }
    this.uin = d(paramIntent);
    this.acg = this.mIntent.getBooleanExtra("is_use_style_839", true);
    this.Uq = paramIntent.getStringExtra("report_src_param_type");
    this.Ur = paramIntent.getStringExtra("report_src_param_name");
    this.Us = paramIntent.getStringExtra("weather_share_url");
    this.aDF = paramIntent.getIntExtra("weather_outside_follow_state", 0);
    if (QLog.isColorLevel()) {
      QLog.d("com.tencent.biz.pubaccount.AccountDetailActivity", 2, "[sopType]:" + this.Uq + ",[sopName]:" + this.Ur + ",[weatherShareUrl]:" + this.Us + ",[weatherOutsideFollowState]:" + this.aDF);
    }
    this.Ut = paramIntent.getStringExtra("extvalue");
    this.Uu = paramIntent.getStringExtra("exttype");
    if (!TextUtils.isEmpty(this.Ut))
    {
      if (!"2".equals(this.Uu)) {
        break label249;
      }
      this.abV = true;
    }
    while ((this.uin == null) || (this.app == null))
    {
      return;
      label249:
      if ("1".equals(this.Uu)) {
        this.abW = true;
      }
    }
    this.Um = this.app.getCurrentUin();
    this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountHandler = ((PublicAccountHandler)this.app.getBusinessHandler(11));
    initView();
    aAw();
    aJ(paramIntent);
    this.mDensity = getResources().getDisplayMetrics().density;
  }
  
  public void initData()
  {
    if (yo())
    {
      if (QLog.isColorLevel()) {
        QLog.d("com.tencent.biz.pubaccount.AccountDetailActivity", 2, "initData hasCache");
      }
      this.isFirst = false;
      updateView();
      azr();
      return;
    }
    ThreadManager.getSubThreadHandler().post(new AccountDetailActivity.19(this));
  }
  
  void initView()
  {
    if (QLog.isColorLevel()) {
      QLog.d("com.tencent.biz.pubaccount.AccountDetailActivity", 2, "initView");
    }
    super.setContentView(2131558429);
    this.density = super.getResources().getDisplayMetrics().density;
    View localView = super.findViewById(2131361903);
    if (this.acg)
    {
      localView.setBackgroundColor(-657926);
      tP();
      aAd();
      azo();
      this.mask = super.findViewById(2131374735);
      if (!ThemeUtil.isInNightMode(this.app)) {
        break label130;
      }
      if (this.mask != null) {
        this.mask.setVisibility(0);
      }
    }
    for (;;)
    {
      this.errorContainer = ((LinearLayout)super.findViewById(2131366503));
      return;
      localView.setBackgroundColor(-1);
      break;
      label130:
      if (this.mask != null) {
        this.mask.setVisibility(8);
      }
    }
  }
  
  public void lp(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    Intent localIntent;
    do
    {
      return;
      localIntent = new Intent(this, PublicAccountBrowser.class);
    } while ((this.app == null) || (TextUtils.isEmpty(this.uin)) || (TextUtils.isEmpty(this.app.getAccount())));
    paramString = paramString.replace("${puin}", this.uin).replace("${uin}", this.app.getAccount());
    localIntent.putExtra("uin", this.app.getCurrentAccountUin());
    localIntent.putExtra("url", paramString);
    if (QLog.isColorLevel()) {
      QLog.d("com.tencent.biz.pubaccount.AccountDetailActivity", 2, "jumpWebView url=" + paramString);
    }
    localIntent.putExtra("puin", this.uin);
    localIntent.putExtra("big_brother_source_key", ocp.fq(this.uin));
    paramString = getAccountName();
    if (!TextUtils.isEmpty(paramString)) {
      localIntent.putExtra("source_name", paramString);
    }
    super.startActivity(localIntent);
  }
  
  protected void lq(String paramString)
  {
    ReportDialog localReportDialog = new ReportDialog(this, 2131756467);
    localReportDialog.setContentView(2131561286);
    ((TextView)localReportDialog.findViewById(2131365903)).setVisibility(8);
    TextView localTextView1 = (TextView)localReportDialog.findViewById(2131365891);
    TextView localTextView2 = (TextView)localReportDialog.findViewById(2131365889);
    TextView localTextView3 = (TextView)localReportDialog.findViewById(2131365895);
    localTextView1.setText(paramString);
    localTextView1.setGravity(3);
    localTextView2.setText(2131721058);
    localTextView3.setText(2131692643);
    localReportDialog.setCanceledOnTouchOutside(false);
    localTextView2.setOnClickListener(new jwg(this, localReportDialog));
    localTextView3.setOnClickListener(new jwh(this, paramString));
    try
    {
      localReportDialog.show();
      return;
    }
    catch (Exception paramString) {}
  }
  
  public void lr(String paramString)
  {
    if (paramString == null) {
      paramString = "";
    }
    for (;;)
    {
      kbp.a(this.app, "P_CliOper", "Pb_account_lifeservice", this.uin, "0X8005A27", "0X8005A27", 0, 0, paramString, "", "", "", false);
      return;
    }
  }
  
  void lt(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountUtilProfileParams != null) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        Object localObject2 = this.jdField_a_of_type_ComTencentBizPubaccountUtilProfileParams.getOpenId();
        Object localObject3 = this.jdField_a_of_type_ComTencentBizPubaccountUtilProfileParams.la();
        Object localObject4 = this.jdField_a_of_type_ComTencentBizPubaccountUtilProfileParams.getUin();
        Object localObject1 = localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          localObject1 = "";
        }
        localObject2 = localObject3;
        if (TextUtils.isEmpty((CharSequence)localObject3)) {
          localObject2 = "";
        }
        localObject3 = localObject4;
        if (TextUtils.isEmpty((CharSequence)localObject4)) {
          localObject3 = "";
        }
        long l = System.currentTimeMillis();
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append((String)localObject1).append(",").append("app").append(",").append((String)localObject2).append(",").append((String)localObject3).append(",").append(l);
        anot.b(this.app, "P_CliOper", "Pb_account_lifeservice", "", paramString, paramString, 0, 1, 0, ((StringBuilder)localObject4).toString(), "", "", "");
      }
      return;
    }
  }
  
  void lu(String paramString)
  {
    if ((this.acl) || (this.cq != null)) {
      return;
    }
    this.acl = true;
    ThreadManager.getSubThreadHandler().post(new AccountDetailActivity.33(this, paramString));
  }
  
  public int mZ()
  {
    return this.screenHeight - this.titleHeight - this.aDH - 1;
  }
  
  protected void og(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail != null) {
      this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.mShowMsgFlag = paramInt;
    }
  }
  
  public void oh(int paramInt)
  {
    Toast.makeText(getApplicationContext(), paramInt, 0).show();
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.bH) {
      aAf();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      String str;
      Object localObject;
      if ((paramView == this.iS) || ((this.jdField_a_of_type_Jtg != null) && (paramView == this.jdField_a_of_type_Jtg.bD) && (!yq())) || ((paramView == this.bK) && (!yq())))
      {
        lt("0X8005B6D");
        this.abZ = false;
        azB();
        aAq();
        this.iS.setEnabled(false);
        this.iS.postDelayed(new AccountDetailActivity.30(this), 1000L);
        if (nyn.i(this.app, this.uin)) {
          ((kec)this.app.getBusinessHandler(88)).a(134243868, this.uin, null, null, null, 1L, false);
        }
        kbp.a(this.app, "P_CliOper", "Pb_account_lifeservice", this.uin, "0X8005A25", "0X8005A25", this.aDI, 0, "", "", "", "", false);
        obg.a().a(4, this.uin, 0, UniteSearchActivity.dCK, amxe.a().oJ(this.uin));
        QQAppInterface localQQAppInterface1 = this.app;
        str = this.uin;
        if (yq())
        {
          localObject = "02";
          anot.a(localQQAppInterface1, "dc01160", "Pb_account_lifeservice", str, "0X8007CA1", "0X8007CA1", 0, 0, (String)localObject, String.valueOf(this.aDI), String.valueOf(kbp.a(this.app, this.uin, this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail)), "");
          if (acbn.blP.equals(this.uin)) {
            localObject = new JSONObject();
          }
        }
        else
        {
          try
          {
            ((JSONObject)localObject).put("channel_id", kvs.getChannelId());
            kbp.a(null, "", "0X8009946", "0X8009946", 0, 0, "", "", "", ((JSONObject)localObject).toString(), false);
            continue;
            localObject = "01";
          }
          catch (Exception localException)
          {
            for (;;)
            {
              QLog.d("com.tencent.biz.pubaccount.AccountDetailActivity", 2, localException.getMessage());
            }
          }
        }
      }
      else
      {
        if (paramView == this.bI)
        {
          int j = getIntent().getIntExtra("source", 0);
          int i;
          if ((xki.hN(this.uin)) && (abdi.b(this, this.app)))
          {
            i = 1;
            label419:
            if (i == 0)
            {
              if (!kxm.dD(this.uin)) {
                break label510;
              }
              aAj();
            }
          }
          for (;;)
          {
            anot.a(this.app, "P_CliOper", "Pb_account_lifeservice", this.uin, "0X8004E44", "0X8004E44", 0, 0, this.uin, "", "", "");
            kbp.a(this.app, "P_CliOper", "Pb_account_lifeservice", this.uin, "0X8005A26", "0X8005A26", 0, 0, "", "", "", "", false);
            break;
            i = 0;
            break label419;
            label510:
            if (acbn.blS.equals(this.uin))
            {
              ocp.b(this, this.app);
            }
            else if (j == 120)
            {
              doOnBackPressed();
            }
            else if (TextUtils.equals(acbn.blP, this.uin))
            {
              KandianDailyManager.a(this, true, null, 5);
              if (acbn.blP.equals(this.uin)) {
                kbp.a(null, "", "0X8009945", "0X8009945", 0, 0, "", "", "", "", false);
              }
            }
            else if ((TextUtils.equals("2747277822", this.uin)) && (ahty.anY()))
            {
              if ((getIntent() != null) && (getIntent().getBooleanExtra("fromQGamePub", false))) {
                doOnBackPressed();
              } else {
                aAl();
              }
            }
            else if ((TextUtils.equals("3046055438", this.uin)) && (keo.za()))
            {
              if (this.mSource == 5) {
                doOnBackPressed();
              }
            }
            else if (MiniGamePublicAccountHelper.shouldOpenWebFragment(this.uin))
            {
              aAm();
            }
            else if (!TextUtils.equals(acbn.blU, this.uin))
            {
              azt();
            }
          }
        }
        if (paramView == this.iW)
        {
          jqs.a(this.app, this, getAccountName(), this.uin, "IvrEnterpriseDetailEngineFalse");
          anot.a(this.app, "CliOper", "", "", "0X8004653", "0X8004653", 0, 0, "", "", "", "");
        }
        else if (paramView == this.hH)
        {
          doOnBackPressed();
        }
        else
        {
          if (paramView == this.rightViewImg)
          {
            label825:
            QQAppInterface localQQAppInterface2;
            if (this.abG)
            {
              aAn();
              localQQAppInterface2 = this.app;
              str = this.uin;
              if (!yq()) {
                break label903;
              }
            }
            label903:
            for (localObject = "02";; localObject = "01")
            {
              anot.a(localQQAppInterface2, "dc01160", "Pb_account_lifeservice", str, "0X8007CA5", "0X8007CA5", 0, 0, (String)localObject, String.valueOf(kbp.a(this.app, this.uin, this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail)), "", "");
              break;
              Qq();
              break label825;
            }
          }
          if (paramView == this.bJ)
          {
            aAp();
          }
          else if (paramView.getId() == 2131361904)
          {
            localObject = new Intent(this, AccountMoreDetailActivity.class);
            ((Intent)localObject).putExtra("uin", this.uin);
            b(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail);
            startActivity((Intent)localObject);
          }
        }
      }
    }
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    paramMenu.add("menu");
    return super.onCreateOptionsMenu(paramMenu);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.isDestory = true;
    if (this.mProgress != null) {
      this.mProgress.dismiss();
    }
    this.mProgress = null;
    if (this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity$a != null)
    {
      this.app.removeObserver(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity$a);
      this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity$a = null;
    }
    if (this.jdField_d_of_type_MqqAppNewIntent != null) {
      this.jdField_d_of_type_MqqAppNewIntent.setObserver(null);
    }
    if (this.jdField_f_of_type_MqqAppNewIntent != null) {
      this.jdField_f_of_type_MqqAppNewIntent.setObserver(null);
    }
    if (this.jdField_e_of_type_MqqAppNewIntent != null) {
      this.jdField_e_of_type_MqqAppNewIntent.setObserver(null);
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity$b != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity$b.destroy();
    }
    if (this.jdField_a_of_type_Swe != null) {
      this.jdField_a_of_type_Swe.dismiss();
    }
    if (this.jdField_a_of_type_Jtg != null) {
      this.jdField_a_of_type_Jtg.destroy();
    }
    if (this.jdField_b_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailXListView != null) {
      this.jdField_b_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailXListView.destroy();
    }
  }
  
  public boolean onMenuOpened(int paramInt, Menu paramMenu)
  {
    return false;
  }
  
  public void onResume()
  {
    super.onResume();
    if (isInMultiWindow())
    {
      QQToast.a(this, getString(2131697437), 0).show();
      finish();
      return;
    }
    if ((this.jdField_a_of_type_Jtg != null) && (this.jdField_a_of_type_Jtg.a() != null)) {
      this.jdField_a_of_type_Jtg.a().ly(true);
    }
    AbstractGifImage.resumeAll();
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    if (paramBoolean)
    {
      aqiy.bk("pubAcc_profile_display", null, this.uin);
      this.acb = true;
      return;
    }
    this.acb = false;
  }
  
  protected void oq(int paramInt)
  {
    this.iS.postDelayed(new AccountDetailActivity.2(this, paramInt), 500L);
  }
  
  public void report()
  {
    ThreadManager.getSubThreadHandler().post(new AccountDetailActivity.18(this));
  }
  
  public void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
    getWindow().setFormat(-3);
  }
  
  Bitmap s(Bitmap paramBitmap)
  {
    int k = 0;
    int m = getWindowManager().getDefaultDisplay().getWidth();
    int n = (int)(140.0F * this.density);
    int i = paramBitmap.getHeight();
    int j = paramBitmap.getWidth();
    if (j * n > i * m)
    {
      n = m * i / n;
      m = (j - n) / 2;
      j = n;
    }
    for (;;)
    {
      return Bitmap.createBitmap(paramBitmap, m, k, j, i);
      m = n * j / m;
      k = (i - m) / 2;
      i = m;
      m = 0;
    }
  }
  
  void showLoading(int paramInt)
  {
    if (this.mProgress != null)
    {
      this.mProgress.setMessage(paramInt);
      if (!this.mProgress.isShowing()) {
        this.mProgress.show();
      }
    }
  }
  
  public int[] t()
  {
    int[] arrayOfInt = new int[2];
    Display localDisplay = getWindowManager().getDefaultDisplay();
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    try
    {
      Class.forName("android.view.Display").getMethod("getRealMetrics", new Class[] { DisplayMetrics.class }).invoke(localDisplay, new Object[] { localDisplayMetrics });
      arrayOfInt[0] = localDisplayMetrics.widthPixels;
      arrayOfInt[1] = localDisplayMetrics.heightPixels;
      return arrayOfInt;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return arrayOfInt;
  }
  
  void tP()
  {
    this.ez = ((RelativeLayout)super.findViewById(2131370423));
    this.ez.setOnClickListener(null);
    int j;
    if (yt()) {
      j = (int)(64.0F * this.density);
    }
    for (int i = (int)(4.0F * this.density);; i = (int)(25.0F * this.density))
    {
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, j);
      this.ez.setLayoutParams(localLayoutParams);
      this.ez.setPadding(0, i, 0, 0);
      this.titleHeight = j;
      if (this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailTopGestureLayout != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailTopGestureLayout.setTitleHeight(this.titleHeight);
      }
      this.hH = ((ImageView)super.findViewById(2131370422));
      this.hH.setOnClickListener(this);
      this.rightViewText = ((TextView)super.findViewById(2131369612));
      this.rightViewText.setText("");
      this.rightViewImg = ((ImageView)super.findViewById(2131369594));
      this.rightViewImg.setImageResource(2130844509);
      this.rightViewImg.setContentDescription(getString(2131699738));
      this.rightViewImg.setVisibility(0);
      this.rightViewImg.setOnClickListener(this);
      this.hI = ((ImageView)super.findViewById(2131368751));
      this.hJ = ((ImageView)super.findViewById(2131368711));
      this.hK = ((ImageView)super.findViewById(2131364413));
      this.bK = ((Button)super.findViewById(2131361907));
      this.bK.setOnClickListener(this);
      if (!this.acg) {
        break;
      }
      this.hH.setImageResource(2130851112);
      this.rightViewImg.setImageResource(2130843304);
      return;
      j = (int)(75.0F * this.density);
    }
    this.hH.setImageResource(2130851759);
    this.rightViewImg.setImageResource(2130844509);
  }
  
  @TargetApi(16)
  void updateTopContainer()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail == null) || (!this.abG)) {}
    while (!yq()) {
      return;
    }
    this.bK.setBackgroundDrawable(null);
    this.bK.setText(2131697478);
    this.bK.setAlpha(0.5F);
    ThreadManager.getSubThreadHandler().postDelayed(new AccountDetailActivity.23(this), 0L);
  }
  
  public void updateView()
  {
    if (QLog.isColorLevel()) {
      QLog.d("com.tencent.biz.pubaccount.AccountDetailActivity", 2, "updateView");
    }
    this.abG = b(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail);
    if (QLog.isColorLevel()) {
      QLog.d("com.tencent.biz.pubaccount.AccountDetailActivity", 2, "isSubscriptAccount = " + this.abG);
    }
    if ((this.abG) && (!TextUtils.isEmpty(this.uin))) {
      juc.b(this.app, Long.parseLong(this.uin), this.jdField_b_of_type_Acje);
    }
    if ((this.jdField_b_of_type_ComTencentMobileqqMpMobileqq_mp$GetPublicAccountDetailInfoResponse != null) && (this.jdField_b_of_type_ComTencentMobileqqMpMobileqq_mp$GetPublicAccountDetailInfoResponse.show_flag.has()) && (this.jdField_b_of_type_ComTencentMobileqqMpMobileqq_mp$GetPublicAccountDetailInfoResponse.show_flag.get() == 2)) {}
    for (int i = 1; i != 0; i = 0)
    {
      aAr();
      return;
    }
    updateTopContainer();
    azx();
    azy();
  }
  
  protected boolean yo()
  {
    acja localacja = (acja)this.app.getManager(56);
    if (localacja != null) {
      this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail = localacja.b(this.uin);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("com.tencent.biz.pubaccount.AccountDetailActivity", 2, "loadCache = null");
      }
      return false;
    }
    aAg();
    return true;
  }
  
  protected boolean yp()
  {
    return false;
  }
  
  protected boolean yq()
  {
    int i = -1;
    if (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail != null) {
      i = this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.followType;
    }
    return i == 1;
  }
  
  public boolean yr()
  {
    return (yq()) && (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.isShowFollowButton);
  }
  
  protected boolean yw()
  {
    acja localacja = (acja)this.app.getManager(56);
    if (localacja != null) {
      this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail = localacja.a(this.uin);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("com.tencent.biz.pubaccount.AccountDetailActivity", 2, "loadDatabase = null");
      }
      return false;
    }
    aAg();
    return true;
  }
  
  static class a
    extends acfd
  {
    mqq.util.WeakReference<AccountDetailActivity> p;
    
    public a(AccountDetailActivity paramAccountDetailActivity)
    {
      this.p = new mqq.util.WeakReference(paramAccountDetailActivity);
    }
    
    public void onUpdateCustomHead(boolean paramBoolean, String paramString)
    {
      AccountDetailActivity localAccountDetailActivity = (AccountDetailActivity)this.p.get();
      if (localAccountDetailActivity == null) {}
      while ((localAccountDetailActivity.isDestory) || (!paramBoolean) || (!paramString.equals(localAccountDetailActivity.uin))) {
        return;
      }
      localAccountDetailActivity.aAx();
    }
  }
  
  public static class b
  {
    AccountDetailActivity.c a;
    public vbg a;
    mqq.util.WeakReference<AccountDetailActivity> q;
    
    public b(QQAppInterface paramQQAppInterface, AccountDetailActivity paramAccountDetailActivity)
    {
      this.jdField_a_of_type_Vbg = new vbg(paramQQAppInterface);
      this.jdField_a_of_type_Vbg.toUin = paramAccountDetailActivity.uin;
      this.q = new mqq.util.WeakReference(paramAccountDetailActivity);
      this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity$c = new AccountDetailActivity.c(paramAccountDetailActivity);
    }
    
    public void akY()
    {
      vbi.b localb = new vbi.b();
      localb.toUin = this.jdField_a_of_type_Vbg.toUin;
      localb.fileKey = null;
      if (this.q.get() == null) {
        return;
      }
      this.jdField_a_of_type_Vbg.a((BaseActivity)this.q.get(), localb);
      this.jdField_a_of_type_Vbg.a(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity$c);
      this.jdField_a_of_type_Vbg.e((BaseActivity)this.q.get());
      new jwn(this, localb).execute(new Void[0]);
    }
    
    public void destroy()
    {
      if (this.q.get() != null)
      {
        this.jdField_a_of_type_Vbg.a(null);
        this.jdField_a_of_type_Vbg.d((BaseActivity)this.q.get());
      }
    }
  }
  
  static class c
    implements vbi.a
  {
    java.lang.ref.WeakReference<AccountDetailActivity> bX;
    
    public c(AccountDetailActivity paramAccountDetailActivity)
    {
      this.bX = new java.lang.ref.WeakReference(paramAccountDetailActivity);
    }
    
    public void b(vbi.b paramb)
    {
      if ((this.bX == null) || (this.bX.get() == null)) {
        return;
      }
      ((AccountDetailActivity)this.bX.get()).a(paramb);
      ((AccountDetailActivity)this.bX.get()).aAx();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.AccountDetailActivity
 * JD-Core Version:    0.7.0.1
 */