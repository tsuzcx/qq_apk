package com.tencent.mobileqq.activity.selectmember;

import aaxo;
import aaxp;
import aaxq;
import aaxr;
import aaxs;
import aaxt;
import aaxu;
import aaxv;
import aaxw;
import aaxx;
import aaxy;
import aaxz;
import aaye;
import aayf;
import acbn;
import acdu;
import acdv;
import acfd;
import acff;
import acfp;
import acms;
import acnd;
import amoi;
import amoj;
import amok;
import amon;
import amoo;
import amop;
import amos;
import ampt;
import amsf.a;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import anot;
import apbc;
import apbc.c;
import apbc.e;
import apuh;
import aqdf;
import aqft;
import aqgv;
import aqha;
import aqha.a;
import aqhu;
import aqju;
import arhz;
import avfi;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.InnerFrameManager;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.ChatActivityUtils.c;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.SelectedAndSearchBar;
import com.tencent.mobileqq.activity.SelectedAndSearchBar.b;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.fragment.UnitedVerifyMsgEditFragment;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.search.fragment.ContactSearchFragment;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.troop.createNewTroop.NewTroopContactView;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.widget.immersive.ImmersiveUtils;
import iuq;
import ivv;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import jjk.b;
import jkm;
import jlk;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;
import ylm;

public class SelectMemberActivity
  extends FragmentActivity
  implements amsf.a, View.OnClickListener, apbc.c
{
  public static boolean bAJ;
  protected View Ah;
  public View Ai;
  public View Aj;
  protected View Ak;
  View Al;
  public TextView Bi;
  protected TextView GS;
  private long MP;
  public long MQ = 9223372036854775807L;
  long MR = 0L;
  protected TextView OI;
  protected TextView OJ;
  protected ProgressBar W;
  private BroadcastReceiver Z;
  public boolean ZM = true;
  aqdf jdField_a_of_type_Aqdf;
  private avfi jdField_a_of_type_Avfi;
  public InnerFrameManager a;
  private SelectedAndSearchBar.b jdField_a_of_type_ComTencentMobileqqActivitySelectedAndSearchBar$b = new aayf(this);
  public SelectedAndSearchBar a;
  a jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity$a;
  public ylm a;
  public ArrayList<ResultRecord> aQ = new ArrayList();
  public String aRJ;
  private acdv jdField_b_of_type_Acdv;
  private acnd jdField_b_of_type_Acnd;
  private iuq jdField_b_of_type_Iuq;
  public boolean bAK;
  boolean bAL;
  boolean bAM;
  boolean bAN;
  boolean bAO;
  boolean bAP;
  boolean bAQ;
  boolean bAR;
  boolean bAS;
  boolean bAT;
  protected boolean bAU;
  protected boolean bAV;
  public boolean bAW;
  public boolean bAX = true;
  public boolean bAY;
  private boolean bAZ;
  public boolean bBa;
  public boolean bBb;
  public boolean bBc;
  boolean bBd = false;
  boolean bBe;
  public int bGG;
  protected boolean bal = true;
  public boolean bap;
  String beA;
  String beB;
  public String beC = acfp.m(2131714236);
  String beD = "";
  public arhz c;
  public ContactSearchFragment c;
  public int cmq;
  int cmr;
  public int cms;
  protected int cmt;
  public int cmu;
  private int cmv;
  public int cmw = -1;
  InputMethodManager d;
  protected ChatActivityUtils.c d;
  private Button de;
  Bitmap dk;
  protected Bitmap eA;
  public int eK;
  private Drawable em;
  protected Button fx;
  private Map<String, Boolean> iK = new HashMap();
  protected LinearLayout ib;
  boolean isClosed = false;
  protected float mDensity;
  protected int mFrom;
  public final Handler mHandler = new aaxt(this, Looper.getMainLooper());
  public Intent mIntent;
  public TextView mRightBtn;
  protected TextView mTitle;
  public View mTitleBar;
  String mTitleString;
  public int mType;
  private acfd p;
  public Dialog pd;
  private View sd;
  public ArrayList<String> so;
  public ArrayList<String> sp;
  public ArrayList<String> sq;
  public ArrayList<String> sr;
  public ArrayList<String> ss;
  ArrayList<Entity> st;
  public List<String> vA = new ArrayList();
  protected ImageView wN;
  
  public SelectMemberActivity()
  {
    this.jdField_d_of_type_ComTencentMobileqqActivityChatActivityUtils$c = new aaxp(this);
    this.jdField_d_of_type_AndroidViewInputmethodInputMethodManager = null;
  }
  
  private void Be(String paramString)
  {
    if (System.currentTimeMillis() - this.MP > 2000)
    {
      QQToast.a(this, paramString, 2000).show(this.mTitleBar.getHeight());
      this.MP = System.currentTimeMillis();
    }
  }
  
  private void Dj(boolean paramBoolean)
  {
    if (this.mIntent.getBooleanExtra("show_invite_entry", false)) {}
    label387:
    for (;;)
    {
      return;
      int i = this.aQ.size();
      String str1;
      if (i <= 1) {
        if (this.bGG == 3)
        {
          String str2 = this.beA;
          str1 = str2;
          if (i != 1)
          {
            paramBoolean = false;
            str1 = str2;
          }
          if (!paramBoolean) {
            break label342;
          }
          this.mRightBtn.setEnabled(true);
          if (!"1000".equals(ThemeUtil.getCurrentThemeInfo().getString("themeId"))) {
            this.mRightBtn.setAlpha(1.0F);
          }
          this.mRightBtn.setText(str1);
        }
      }
      for (;;)
      {
        if (!AppSetting.enableTalkBack) {
          break label387;
        }
        this.mRightBtn.setContentDescription(this.beA + acfp.m(2131714231) + i + acfp.m(2131714223));
        return;
        if (this.mType == 9654)
        {
          if (i < 1)
          {
            str1 = MessageFormat.format(this.beB, new Object[] { Integer.valueOf(1) });
            break;
          }
          str1 = MessageFormat.format(this.beB, new Object[] { Integer.valueOf(i + 1) });
          break;
        }
        if (((this.eK == 25) && (i == 1)) || ((XK()) && (i == 1)))
        {
          str1 = MessageFormat.format(this.beB, new Object[] { Integer.valueOf(i) });
          break;
        }
        str1 = this.beA;
        break;
        if (this.bGG == 3)
        {
          str1 = this.beA;
          break;
        }
        if (this.mType == 9654)
        {
          str1 = MessageFormat.format(this.beB, new Object[] { Integer.valueOf(i + 1) });
          break;
        }
        str1 = MessageFormat.format(this.beB, new Object[] { Integer.valueOf(i) });
        break;
        label342:
        this.mRightBtn.setEnabled(false);
        if (!"1000".equals(ThemeUtil.getCurrentThemeInfo().getString("themeId"))) {
          this.mRightBtn.setAlpha(0.5F);
        }
        this.mRightBtn.setText(str1);
      }
    }
  }
  
  private void Dk(boolean paramBoolean)
  {
    SelectMemberInnerFrame localSelectMemberInnerFrame;
    if ((this.eK == 38) || (this.eK == 29) || (this.eK == 39))
    {
      if (QLog.isColorLevel()) {
        QLog.i("SelectMemberActivity", 2, "isItemClick：" + paramBoolean);
      }
      localSelectMemberInnerFrame = (SelectMemberInnerFrame)this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.getChildAt(1);
      if ((!paramBoolean) || (this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.uy() != 0)) {
        break label87;
      }
    }
    label87:
    while (!(localSelectMemberInnerFrame instanceof FriendTeamListInnerFrame)) {
      return;
    }
    ResultRecord localResultRecord = null;
    if (this.aQ.size() > 0) {
      localResultRecord = (ResultRecord)this.aQ.get(this.aQ.size() - 1);
    }
    localSelectMemberInnerFrame.a(localResultRecord, this.eK);
  }
  
  private void GM(int paramInt)
  {
    String str;
    switch (paramInt)
    {
    default: 
      if ((this.eK == 11) || (this.eK == 36)) {
        str = getString(2131697776);
      }
      break;
    }
    for (;;)
    {
      this.mHandler.obtainMessage(1, str).sendToTarget();
      QLog.w("SelectMemberActivity", 1, "handleTroopInviteGroupFailed, result[" + paramInt + "], errStr[" + str + "]");
      return;
      str = getString(2131695119);
      continue;
      str = getString(2131695118);
      continue;
      str = getString(2131695121);
      continue;
      str = getString(2131695120);
      continue;
      str = getString(2131695122);
    }
  }
  
  private void GN(int paramInt)
  {
    Be(getString(paramInt));
  }
  
  private boolean XI()
  {
    if ((!this.bap) && (zs() >= 3)) {}
    return true;
  }
  
  private boolean XJ()
  {
    boolean bool = false;
    int i;
    if (this.bGG == 1) {
      if (this.jdField_b_of_type_Iuq != null) {
        i = this.jdField_b_of_type_Iuq.d(Long.valueOf(this.aRJ).longValue(), this.mType) + 0;
      }
    }
    for (;;)
    {
      Iterator localIterator = this.aQ.iterator();
      label50:
      int j;
      if (localIterator.hasNext()) {
        if (((ResultRecord)localIterator.next()).type == 5)
        {
          j = i + 1;
          i = j;
          if (j < 8) {}
        }
      }
      for (;;)
      {
        if (j < 8) {
          bool = true;
        }
        return bool;
        if (this.jdField_a_of_type_Avfi == null) {
          break label141;
        }
        i = this.jdField_a_of_type_Avfi.d(Long.valueOf(this.aRJ).longValue(), this.mType) + 0;
        break;
        break label50;
        j = i;
      }
      label141:
      i = 0;
    }
  }
  
  public static ResultRecord a(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    ResultRecord localResultRecord = new ResultRecord();
    localResultRecord.uin = paramString1;
    localResultRecord.name = paramString2;
    localResultRecord.type = paramInt;
    localResultRecord.QD = paramString3;
    return localResultRecord;
  }
  
  private void bu(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("SelectMemberActivity", 2, "afterCreateTroopSucc, troop[" + paramString + "], entrance[" + this.eK + "]");
    }
    Object localObject = ((TroopManager)this.app.getManager(52)).c(paramString);
    ArrayList localArrayList;
    Iterator localIterator;
    if (localObject == null)
    {
      localObject = "";
      localArrayList = new ArrayList();
      localIterator = this.aQ.iterator();
    }
    for (;;)
    {
      if (!localIterator.hasNext()) {
        break label217;
      }
      ResultRecord localResultRecord = (ResultRecord)localIterator.next();
      if (localResultRecord.type == 5)
      {
        if (localResultRecord.uin.startsWith("pstn")) {
          localResultRecord.uin = localResultRecord.uin.substring("pstn".length());
        }
        localArrayList.add(localResultRecord.uin);
        continue;
        localObject = ((TroopInfo)localObject).troopname;
        break;
      }
      if ((localResultRecord.type == 4) && (localResultRecord.uin.startsWith("+"))) {
        localArrayList.add(localResultRecord.uin);
      }
    }
    label217:
    this.mIntent.putExtra("roomId", paramString);
    this.mIntent.putExtra("discussName", (String)localObject);
    this.mIntent.putExtra("qqPhoneUserList", localArrayList);
    this.mIntent.putExtra("audioType", 2);
    this.mIntent.putExtra("result_uin", paramString);
    this.mIntent.putExtra("result_uintype", 1);
    this.mIntent.putExtra("result_name", (String)localObject);
    if (this.eK == 12) {
      this.mIntent.putExtra("select_memeber_discussion_memeber_count", this.aQ.size() + 1);
    }
    this.mIntent.putParcelableArrayListExtra("result_set", this.aQ);
    setResult(-1, this.mIntent);
    if (this.eK == 27) {
      apuh.f(this, paramString, true);
    }
    finish();
  }
  
  private void cAg()
  {
    if (this.pd != null)
    {
      this.pd.dismiss();
      this.pd = null;
    }
    this.pd = new ReportDialog(this, 2131756467);
    this.pd.setContentView(2131562991);
    this.OJ = ((TextView)this.pd.findViewById(2131365863));
    this.OJ.setText(getString(2131719519));
    this.W = ((ProgressBar)this.pd.findViewById(2131367453));
    this.W.setVisibility(0);
    this.wN = ((ImageView)this.pd.findViewById(2131381312));
    this.wN.setVisibility(4);
  }
  
  private void iA(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SelectMemberActivity", 2, "sendIsResumeBroadcast isNeedSend = " + this.ZM + " ,isResume = " + paramBoolean);
    }
    if (this.ZM) {
      ivv.o(BaseApplicationImpl.getContext(), paramBoolean);
    }
  }
  
  private boolean iZ(String paramString)
  {
    try
    {
      Iterator localIterator = this.aQ.iterator();
      while (localIterator.hasNext())
      {
        boolean bool = TextUtils.equals(((ResultRecord)localIterator.next()).uin, paramString);
        if (bool) {
          return true;
        }
      }
    }
    catch (Throwable paramString) {}
    return false;
  }
  
  private void ix()
  {
    this.jdField_b_of_type_Acdv = new aaxq(this);
    this.jdField_b_of_type_Acnd = new aaxr(this);
    this.p = new aaxs(this);
    addObserver(this.jdField_b_of_type_Acdv);
    addObserver(this.p);
    addObserver(this.jdField_b_of_type_Acnd);
  }
  
  public void Bb(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.w("SelectMemberActivity", 1, "onReusedTroop,troopUin[" + paramString + "], mSubType[" + this.bGG + "], mEntrance[" + this.eK + "]");
    }
    bu(paramString, true);
  }
  
  public void Bc(String paramString)
  {
    ThreadManagerV2.excute(new SelectMemberActivity.8(this, paramString), 32, null, false);
  }
  
  public void Bd(String paramString)
  {
    int i = 0;
    if (i < this.aQ.size())
    {
      if (((ResultRecord)this.aQ.get(i)).uin.equals(paramString))
      {
        this.aQ.remove(i);
        if (this.mType == 9003) {
          if ((this.eK != 15) || (this.jdField_a_of_type_Ylm.ic(paramString))) {
            break label90;
          }
        }
      }
      for (this.cmv -= 1;; this.cmv -= 1) {
        label90:
        do
        {
          i += 1;
          break;
        } while ((this.eK != 32) || (this.jdField_a_of_type_Ylm.ie(paramString)));
      }
    }
    cAh();
  }
  
  public void Bf(String paramString)
  {
    if ((this.eK == 38) || (this.eK == 29) || (this.eK == 39))
    {
      if (!TextUtils.isEmpty(paramString)) {
        break label51;
      }
      if (QLog.isColorLevel()) {
        QLog.i("SelectMemberActivity", 2, "onRelationTroopItemClick: empty");
      }
    }
    return;
    label51:
    if (QLog.isColorLevel()) {
      QLog.i("SelectMemberActivity", 2, "onRelationTroopItemClick: troopUin:" + paramString);
    }
    Bb(paramString);
  }
  
  public void GO(int paramInt)
  {
    long l = aqft.getCurZeroTimeMillis();
    SharedPreferences.Editor localEditor = this.app.getApp().getSharedPreferences(this.app.getAccount(), 0).edit();
    localEditor.putString("not_admin_invite_member_count", l + ":" + paramInt);
    localEditor.commit();
  }
  
  public void GP(int paramInt)
  {
    if (this.eK != 35) {
      return;
    }
    this.bAW = false;
    GQ(paramInt);
    cAj();
  }
  
  void GQ(int paramInt)
  {
    int j = 0;
    int i = 0;
    if (!this.mIntent.getBooleanExtra("param_enable_all_select", false)) {}
    Object localObject;
    do
    {
      return;
      localObject = this.mIntent.getStringExtra("group_uin");
    } while ((TextUtils.isEmpty((CharSequence)localObject)) || ((!this.bAP) && (!this.bAO)));
    if (paramInt != -1)
    {
      if (!this.bAV) {
        break label262;
      }
      j = paramInt - 1;
    }
    for (;;)
    {
      if (j <= this.mIntent.getIntExtra("param_all_select_max_num", this.cms)) {
        this.bAW = true;
      }
      QLog.w("SelectMemberActivity", 1, "isEnableAllSelect, memCount[" + paramInt + "], memFromAPI[" + i + "], finalCount[" + j + "], mIsSelectAllMembers[" + this.bAW + "], mShowMyself[" + this.bAV + "]");
      return;
      if (this.bAP)
      {
        acdu localacdu = (acdu)this.app.getManager(53);
        if (localacdu == null) {
          break label257;
        }
        i = localacdu.cn((String)localObject);
      }
      for (;;)
      {
        j = i - 1;
        break;
        i = j;
        if (this.bAO)
        {
          localObject = ((TroopManager)this.app.getManager(52)).c((String)localObject);
          i = j;
          if (localObject != null)
          {
            i = ((TroopInfo)localObject).wMemberNum;
            continue;
            label257:
            i = 0;
          }
        }
      }
      label262:
      j = paramInt;
    }
  }
  
  boolean XF()
  {
    if ((XL()) || (XM())) {}
    while ((this.eK == 35) || (this.eK == 40)) {
      return true;
    }
    return false;
  }
  
  public boolean XG()
  {
    this.aQ.clear();
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectedAndSearchBar.cz(false);
    cAc();
    cAh();
    return true;
  }
  
  public boolean XH()
  {
    return this.bBe;
  }
  
  boolean XK()
  {
    boolean bool = XL();
    int j = this.aQ.size();
    if (this.so != null) {}
    for (int i = this.so.size(); (bool) && (this.bGG == 0) && (i + j >= 1); i = 0) {
      return true;
    }
    return false;
  }
  
  boolean XL()
  {
    return (this.eK == 27) || (this.eK == 28) || (this.eK == 12) || (this.eK == 29) || (this.eK == 39);
  }
  
  boolean XM()
  {
    return (this.mType == 1) && (this.bGG == 1);
  }
  
  public ResultRecord a(String paramString1, String paramString2, int paramInt, String paramString3, String paramString4)
  {
    ResultRecord localResultRecord = new ResultRecord();
    localResultRecord.uin = paramString1;
    localResultRecord.name = paramString2;
    localResultRecord.type = paramInt;
    localResultRecord.QD = paramString3;
    localResultRecord.SB = paramString4;
    return localResultRecord;
  }
  
  public void a(ResultRecord paramResultRecord, boolean paramBoolean)
  {
    if (this.eK != 30) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity$a != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity$a.b(paramResultRecord, paramBoolean);
    }
    if (this.aQ.isEmpty())
    {
      paramResultRecord = getString(2131692001);
      label46:
      if (this.de == null) {
        break label110;
      }
      this.de.setText(paramResultRecord);
      paramResultRecord = this.de;
      if (this.aQ.isEmpty()) {
        break label112;
      }
    }
    label110:
    label112:
    for (paramBoolean = true;; paramBoolean = false)
    {
      paramResultRecord.setEnabled(paramBoolean);
      return;
      paramResultRecord = getString(2131692002, new Object[] { Integer.valueOf(this.aQ.size()) });
      break label46;
      break;
    }
  }
  
  public void a(a parama)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity$a = parama;
  }
  
  public boolean a(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    boolean bool1;
    if (iX(paramString1))
    {
      bool1 = false;
      Bd(paramString1);
    }
    for (;;)
    {
      if (iY(paramString1))
      {
        Bd(paramString1);
        QQToast.a(this, 1, acfp.m(2131714233), 0).show(getTitleBarHeight());
        anot.a(this.app, "dc00899", "invite_friend", "", "friend_list", "exp_toast_tobechecked", 0, 0, paramString3, "", "", "");
        bool1 = false;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectedAndSearchBar.cz(bool1);
      cAc();
      cAh();
      Dk(true);
      return bool1;
      if ((!a("onListViewItemClick1", false, paramString1, paramString2, paramInt, paramString3)) && (!ak(paramString1, paramString2)) && (b(paramString1, paramString2, paramInt, paramString3)))
      {
        boolean bool2 = true;
        this.aQ.add(a(paramString1, paramString2, paramInt, paramString3));
        bool1 = bool2;
        if (this.mType == 9003) {
          if ((this.eK == 15) && (!this.jdField_a_of_type_Ylm.ic(paramString1)))
          {
            this.cmv += 1;
            bool1 = bool2;
          }
          else
          {
            bool1 = bool2;
            if (this.eK == 32)
            {
              bool1 = bool2;
              if (!this.jdField_a_of_type_Ylm.ie(paramString1))
              {
                this.cmv += 1;
                bool1 = bool2;
              }
            }
          }
        }
      }
      else
      {
        bool1 = false;
      }
    }
  }
  
  public boolean a(String paramString1, String paramString2, int paramInt, String paramString3, String paramString4)
  {
    boolean bool;
    if (iX(paramString1))
    {
      bool = false;
      Bd(paramString1);
    }
    for (;;)
    {
      if (iY(paramString1))
      {
        Bd(paramString1);
        QQToast.a(this, 1, acfp.m(2131714204), 0).show(getTitleBarHeight());
        anot.a(this.app, "dc00899", "invite_friend", "", "friend_list", "exp_toast_tobechecked", 0, 0, paramString3, "", "", "");
        bool = false;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectedAndSearchBar.cz(bool);
      cAc();
      cAh();
      return bool;
      if ((!a("onListViewItemClick2", false, paramString1, paramString2, paramInt, paramString3)) && (b(paramString1, paramString2, paramInt, paramString3)))
      {
        bool = true;
        this.aQ.add(a(paramString1, paramString2, paramInt, paramString3, paramString4));
      }
      else
      {
        bool = false;
      }
    }
  }
  
  boolean a(String paramString1, boolean paramBoolean, String paramString2, String paramString3, int paramInt, String paramString4)
  {
    if ((this.eK == 32) && (paramBoolean) && (this.mIntent.getBooleanExtra("param_enable_all_select", false))) {}
    do
    {
      do
      {
        do
        {
          return false;
          if (this.mType != 3000) {
            break;
          }
        } while (this.aQ.size() < this.cms);
        if ((this.eK == 12) && (this.cms == 1)) {
          GN(2131692889);
        }
        for (;;)
        {
          return true;
          GN(2131692880);
        }
        if (this.mType != 1) {
          break label709;
        }
        if ((this.bAU) && (this.aQ.size() >= this.cms))
        {
          Be(acfp.m(2131714217));
          return true;
        }
        if (this.bGG != 0) {
          break;
        }
      } while (this.aQ.size() < this.cms);
      Be(getString(2131721489));
      return true;
      if (this.bGG != 1) {
        break;
      }
      if (this.aQ.size() >= this.cms)
      {
        GN(2131721489);
        return true;
      }
    } while ((this.eK != 11) || (this.st == null));
    int k = this.st.size() + 1;
    TroopManager localTroopManager = (TroopManager)this.app.getManager(52);
    String str = this.mIntent.getStringExtra("group_uin");
    int i = localTroopManager.c(str).getMemNumForAutoInviteIntoGroup(this.app);
    if (i > k)
    {
      i -= k;
      label278:
      int j = cg().size();
      int m = this.aQ.size();
      paramBoolean = iW(paramString2);
      if (AudioHelper.aCz()) {
        QLog.w("SelectMemberActivity", 1, "isMemberOverLoad[" + paramString1 + "], 可邀请的群外成员到达上限检查, 已经选择群内成员[" + (m - j) + "], 当前群成员[" + k + "], 实际可邀请的群外成员[" + i + "], 已经选择的群外成员[" + j + "], 当前选择的是群成员[" + paramBoolean + "], uin[" + paramString2 + "], name[" + paramString3 + "], type[" + paramInt + "], fromGroupUin[" + paramString4 + "], mResultList[" + this.aQ.size() + "], groupUin[" + str + "], mGroupCode[" + this.aRJ + "]");
      }
      paramInt = j;
      if (!paramBoolean) {
        paramInt = j + 1;
      }
      if (paramInt <= i) {
        break label926;
      }
      paramBoolean = true;
      GN(2131721465);
    }
    for (;;)
    {
      return paramBoolean;
      i = 0;
      break label278;
      if (this.bGG == 3)
      {
        if (this.aQ.size() < this.cms) {
          break;
        }
        Be(getString(2131721463));
        anot.a(null, "dc00899", "Grp_video", "", "invite", "toast_over", 0, 0, this.aRJ, jlk.a(this.app, this.app.getCurrentAccountUin(), this.aRJ) + "", "", "");
        return true;
      }
      if (this.bGG == 4)
      {
        if (this.aQ.size() < this.cms) {
          break;
        }
        Be(getString(2131721315, new Object[] { Integer.valueOf(this.cms) }));
        return true;
      }
      if (this.aQ.size() < this.cms) {
        break;
      }
      if (this.eK == 35) {
        GN(2131721489);
      }
      for (;;)
      {
        return true;
        GN(2131721463);
      }
      label709:
      if (this.mType == 9003)
      {
        if (this.eK == 15)
        {
          paramInt = this.jdField_a_of_type_Ylm.wY();
          if (this.aQ.size() < paramInt) {
            break;
          }
          Be(String.format(getString(2131690933), new Object[] { Integer.valueOf(this.jdField_a_of_type_Ylm.wX()) }));
          return true;
        }
        if (this.eK != 32) {
          break;
        }
        paramInt = this.jdField_a_of_type_Ylm.xc();
        if (this.aQ.size() < paramInt) {
          break;
        }
        Be(String.format(getString(2131690933), new Object[] { Integer.valueOf(this.jdField_a_of_type_Ylm.wZ()) }));
        return true;
      }
      if (this.aQ.size() < this.cms) {
        break;
      }
      i = 0;
      paramInt = i;
      if (this.bAS)
      {
        paramInt = i;
        if (this.so != null) {
          paramInt = this.so.size();
        }
      }
      Be(String.format(getString(2131696700), new Object[] { Integer.valueOf(paramInt + this.cms) }));
      return true;
      label926:
      paramBoolean = false;
    }
  }
  
  public boolean a(List<ResultRecord> paramList, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1) {
      this.aQ.clear();
    }
    HashSet localHashSet = new HashSet(this.aQ.size());
    Object localObject = this.aQ.iterator();
    while (((Iterator)localObject).hasNext()) {
      localHashSet.add(((ResultRecord)((Iterator)localObject).next()).uin);
    }
    if (this.so != null)
    {
      localObject = this.so.iterator();
      while (((Iterator)localObject).hasNext()) {
        localHashSet.add((String)((Iterator)localObject).next());
      }
    }
    paramList = paramList.iterator();
    do
    {
      for (;;)
      {
        if (!paramList.hasNext()) {
          break label345;
        }
        localObject = (ResultRecord)paramList.next();
        if (!localHashSet.contains(((ResultRecord)localObject).uin))
        {
          if ((a("addFriendResults", paramBoolean2, ((ResultRecord)localObject).uin, ((ResultRecord)localObject).name, ((ResultRecord)localObject).type, ((ResultRecord)localObject).QD)) || (ak(((ResultRecord)localObject).uin, ((ResultRecord)localObject).name)) || (!b(((ResultRecord)localObject).uin, ((ResultRecord)localObject).name, ((ResultRecord)localObject).type, ((ResultRecord)localObject).QD))) {
            break;
          }
          this.aQ.add(localObject);
          a((ResultRecord)localObject, true);
          if (this.mType == 9003) {
            if ((this.eK == 15) && (!this.jdField_a_of_type_Ylm.ic(((ResultRecord)localObject).uin))) {
              this.cmv += 1;
            } else if ((this.eK == 32) && (!this.jdField_a_of_type_Ylm.ie(((ResultRecord)localObject).uin))) {
              this.cmv += 1;
            }
          }
        }
      }
    } while (this.mType == 9003);
    label345:
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectedAndSearchBar.cz(true);
    cAc();
    cAh();
    return true;
  }
  
  protected void aC()
  {
    this.Bi.setVisibility(0);
    this.GS.setVisibility(8);
    this.mRightBtn.setVisibility(0);
    this.Bi.setText(2131719436);
    this.Bi.setBackgroundResource(0);
    this.Bi.setPadding(0, 0, 0, 0);
    this.mTitle.setText(this.mTitleString);
    if (AppSetting.enableTalkBack)
    {
      this.mTitle.setContentDescription(this.mTitleString);
      this.Bi.setContentDescription(getString(2131719436));
    }
    if (XF())
    {
      this.mRightBtn.setVisibility(8);
      if (XL())
      {
        this.Bi.setText("");
        this.Bi.setBackgroundResource(2130851758);
        this.GS.setVisibility(8);
      }
    }
    else
    {
      this.Bi.setOnClickListener(new aaxy(this));
      cAc();
      if (this.mIntent.getBooleanExtra("show_invite_entry", false))
      {
        if (this.eK != 35) {
          break label260;
        }
        this.mRightBtn.setText(2131719434);
        jjk.b.axf();
      }
    }
    for (;;)
    {
      this.mRightBtn.setVisibility(0);
      return;
      if (XM())
      {
        this.Bi.setText(2131721058);
        this.Bi.setBackgroundDrawable(null);
        break;
      }
      this.Bi.setText("");
      this.Bi.setBackgroundResource(2130851758);
      break;
      label260:
      this.mRightBtn.setText(2131719435);
    }
  }
  
  @TargetApi(14)
  protected void aDR()
  {
    RelativeLayout localRelativeLayout = (RelativeLayout)findViewById(2131377546);
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      if (Build.VERSION.SDK_INT >= 14) {
        localRelativeLayout.setFitsSystemWindows(true);
      }
      localRelativeLayout.setPadding(0, ImmersiveUtils.getStatusBarHeight(this), 0, 0);
    }
    this.mTitleBar = findViewById(2131379791);
    this.mTitle = ((TextView)findViewById(2131369627));
    this.Bi = ((TextView)findViewById(2131369579));
    this.GS = ((TextView)findViewById(2131369581));
    this.mRightBtn = ((TextView)findViewById(2131369612));
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectedAndSearchBar = ((SelectedAndSearchBar)findViewById(2131377961));
    this.ib = ((LinearLayout)findViewById(2131370565));
    this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager = ((InnerFrameManager)findViewById(2131381914));
    this.Ai = findViewById(2131377207);
    this.Ai.setVisibility(8);
    this.Aj = findViewById(2131379986);
    if (this.Aj != null)
    {
      this.Aj.setVisibility(8);
      this.Aj.setOnClickListener(this);
    }
    this.Ak = findViewById(2131379987);
    if (this.Ak != null) {
      this.Ak.setOnClickListener(this);
    }
    this.Ah = findViewById(2131365523);
    if (XF())
    {
      this.Ah.setVisibility(0);
      this.fx = ((Button)findViewById(2131365522));
      if (this.eK != 35) {
        break label476;
      }
      this.fx.setText(this.beA);
    }
    label476:
    for (boolean bool = true;; bool = false)
    {
      if (this.eK == 40) {
        this.fx.setText(this.beA);
      }
      this.fx.setOnClickListener(this);
      NewTroopContactView.setCreateTroopButtonEnable(this.fx, bool);
      if (XL())
      {
        int i = getIntent().getIntExtra("create_source", 0);
        anot.a(this.app, "dc00899", "Grp_create_new", "", "create_page", "exp_chose", 0, 0, "", "" + i, "", "");
      }
      for (;;)
      {
        this.Al = findViewById(2131377962);
        this.sd = findViewById(2131367180);
        this.de = ((Button)findViewById(2131363914));
        if (this.de != null) {
          this.de.setOnClickListener(this);
        }
        return;
        if (XM())
        {
          this.fx.setText(acfp.m(2131714207));
          cAf();
        }
      }
    }
  }
  
  public void aN(boolean paramBoolean, int paramInt)
  {
    if (this.bGG == 3)
    {
      this.OI = ((TextView)findViewById(2131377938));
      if ((paramBoolean) && (getIntent().getIntExtra("param_member_show_type", 1) == 2))
      {
        this.OI.setVisibility(0);
        this.OI.setText(getString(2131700027, new Object[] { Integer.valueOf(Math.min(paramInt, this.cms)) }));
      }
    }
    else
    {
      return;
    }
    this.OI.setVisibility(0);
    this.OI.setText(getString(2131700029, new Object[] { Integer.valueOf(this.cms) }));
  }
  
  protected boolean ak(String paramString1, String paramString2)
  {
    if (this.mType == 9003)
    {
      if ((this.eK == 15) && (!this.jdField_a_of_type_Ylm.ic(paramString1)) && (this.cmv >= this.jdField_a_of_type_Ylm.wW())) {
        Be(String.format(getString(2131690935), new Object[] { Integer.valueOf(this.jdField_a_of_type_Ylm.wV()) }));
      }
      for (boolean bool1 = true;; bool1 = false)
      {
        boolean bool2 = bool1;
        if (this.eK == 32)
        {
          bool2 = bool1;
          if (!this.jdField_a_of_type_Ylm.ie(paramString1))
          {
            bool2 = bool1;
            if (this.cmv >= this.jdField_a_of_type_Ylm.xb())
            {
              Be(String.format(getString(2131721830), new Object[] { Integer.valueOf(this.jdField_a_of_type_Ylm.xa()) }));
              bool2 = true;
            }
          }
        }
        return bool2;
      }
    }
    return false;
  }
  
  boolean b(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    boolean bool;
    int i;
    if (paramInt == 5)
    {
      bool = XJ();
      if (!bool) {
        QQToast.a(this, 2131719462, 1).show(getTitleBarHeight());
      }
      i = bY(paramString1);
      if (i != 0) {
        break label76;
      }
    }
    label76:
    for (paramInt = 1;; paramInt = 0)
    {
      if (paramInt == 0) {
        QQToast.a(this, i, 1).show(getTitleBarHeight());
      }
      if ((!bool) || (paramInt == 0)) {
        break;
      }
      return true;
    }
    return false;
  }
  
  public void bE(int paramInt, String paramString)
  {
    if ((paramInt == 0) && (!TextUtils.isEmpty(paramString))) {
      anot.a(this.app, "dc00899", "Grp_create", "", "choose_cre", "cre_suc", 0, 0, paramString, "", "", "");
    }
    do
    {
      return;
      paramInt = apbc.e.jG(paramInt);
    } while (paramInt == 0);
    QQToast.a(this, 1, paramInt, 0).show(getTitleBarHeight());
  }
  
  public void bF(int paramInt, String paramString)
  {
    int i = 1;
    if ((QLog.isColorLevel()) || (paramInt != 0)) {
      QLog.w("SelectMemberActivity", 1, "onInviteComplete, retCode[" + paramInt + "], troopUin[" + paramString + "], mSubType[" + this.bGG + "], mEntrance[" + this.eK + "]");
    }
    if (paramInt == 0) {}
    for (paramInt = i; paramInt != 0; paramInt = 0)
    {
      bu(paramString, false);
      return;
    }
    QQToast.a(this, getString(2131692823), 2000).show(this.mTitleBar.getHeight());
  }
  
  void bNU()
  {
    this.jdField_d_of_type_AndroidViewInputmethodInputMethodManager.hideSoftInputFromWindow(getWindow().peekDecorView().getWindowToken(), 0);
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectedAndSearchBar.bVl();
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectedAndSearchBar.bVm();
    this.Ai.setVisibility(8);
    this.bBe = false;
  }
  
  public int bY(String paramString)
  {
    switch (jkm.e(paramString.substring("pstn".length()), true))
    {
    case 0: 
    default: 
      return 0;
    case -1: 
      return 2131719461;
    case 1: 
      return 2131719455;
    case 2: 
      return 2131719456;
    case 3: 
      return 2131719457;
    case 4: 
      return 2131719458;
    case 5: 
      return 2131719459;
    }
    return 2131719460;
  }
  
  public void bp(boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool2 = false;
    boolean bool1;
    Object localObject;
    int i;
    if (!paramBoolean2)
    {
      if (!this.bAZ)
      {
        bool1 = true;
        this.bAZ = bool1;
      }
    }
    else
    {
      localObject = this.Al;
      if (!this.bAZ) {
        break label238;
      }
      i = 0;
      label38:
      ((View)localObject).setVisibility(i);
      s(false, "", "");
      if (!this.bAZ) {
        break label273;
      }
      this.sd.setVisibility(0);
      if (!this.aQ.isEmpty()) {
        break label244;
      }
      localObject = getString(2131692001);
      label87:
      if (this.de != null) {
        this.de.setText((CharSequence)localObject);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectedAndSearchBar.bVl();
      if (this.de != null)
      {
        localObject = this.de;
        bool1 = bool2;
        if (!this.aQ.isEmpty()) {
          bool1 = true;
        }
        ((Button)localObject).setEnabled(bool1);
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity$a != null) && (!paramBoolean2)) {
        this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity$a.bp(true, paramBoolean2);
      }
      if (!paramBoolean1)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivitySelectedAndSearchBar.cz(true);
        cAh();
      }
      bNU();
      paramBoolean1 = this.bAZ;
      localObject = getIntent().getStringExtra("group_uin");
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        ThreadManager.post(new SelectMemberActivity.20(this, paramBoolean1, (String)localObject), 5, null, true);
      }
      return;
      bool1 = false;
      break;
      label238:
      i = 8;
      break label38;
      label244:
      localObject = getString(2131692002, new Object[] { Integer.valueOf(this.aQ.size()) });
      break label87;
      label273:
      this.Ai.setVisibility(8);
      this.Al.setVisibility(8);
      this.sd.setVisibility(8);
    }
  }
  
  protected void cAa()
  {
    setContentView(2131563064);
  }
  
  protected void cAb()
  {
    this.mIntent = getIntent();
    this.mType = this.mIntent.getExtras().getInt("param_type");
    this.bGG = this.mIntent.getExtras().getInt("param_subtype");
    this.mFrom = this.mIntent.getExtras().getInt("param_from");
    this.eK = this.mIntent.getIntExtra("param_entrance", 0);
    this.bBc = this.mIntent.getBooleanExtra("filer_robot", false);
    this.so = this.mIntent.getStringArrayListExtra("param_uins_selected_default");
    this.sp = this.mIntent.getStringArrayListExtra("param_uins_selected_friends");
    this.sq = this.mIntent.getStringArrayListExtra("param_uins_selected_default_clickable");
    if (this.sq != null)
    {
      localObject1 = this.sq.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        this.iK.put(localObject2, Boolean.valueOf(false));
      }
    }
    this.sr = this.mIntent.getStringArrayListExtra("param_uins_hide");
    if (this.sr == null) {
      this.sr = new ArrayList();
    }
    this.sr.add(acbn.blz);
    Object localObject2 = (TroopManager)this.app.getManager(52);
    Object localObject1 = null;
    if (localObject2 != null) {
      localObject1 = ((TroopManager)localObject2).cE();
    }
    if (localObject1 != null)
    {
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        TroopInfo localTroopInfo = (TroopInfo)((Iterator)localObject1).next();
        if (localTroopInfo.isQidianPrivateTroop()) {
          this.sr.add(localTroopInfo.troopuin);
        }
      }
    }
    this.aRJ = this.mIntent.getExtras().getString("param_groupcode");
    this.bap = this.mIntent.getExtras().getBoolean("param_is_troop_admin", true);
    this.cms = this.mIntent.getIntExtra("param_max", 2147483647);
    int i;
    if ((localObject2 != null) && (!TextUtils.isEmpty(this.aRJ)) && (!TextUtils.equals("0", this.aRJ)))
    {
      localObject1 = ((TroopManager)localObject2).b(this.aRJ);
      if (localObject1 != null)
      {
        i = ((TroopInfo)localObject1).wMemberMax - ((TroopInfo)localObject1).wMemberNum;
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("mMaxSelectNumber:").append(this.cms).append(" remain:").append(i).append("  wMemberMax:").append(((TroopInfo)localObject1).wMemberMax).append("  wMemberNum:").append(((TroopInfo)localObject1).wMemberNum).append("  real mMaxSelectNumber").append(Math.min(this.cms, i));
          QLog.d("SelectMemberActivity", 2, ((StringBuilder)localObject2).toString());
        }
        if ((i > 0) && (this.cms > i))
        {
          this.cms = i;
          this.bAU = true;
        }
      }
    }
    this.cmt = this.mIntent.getIntExtra("param_min", 1);
    this.bAV = this.mIntent.getBooleanExtra("param_show_myself", false);
    this.bAK = this.mIntent.getBooleanExtra("param_donot_need_contacts", false);
    this.bAL = this.mIntent.getBooleanExtra("param_donot_need_troop", false);
    this.bAM = this.mIntent.getBooleanExtra("param_donot_need_discussion", false);
    this.bAN = this.mIntent.getBooleanExtra("param_only_friends", false);
    this.bAO = this.mIntent.getBooleanExtra("param_only_troop_member", false);
    this.bAP = this.mIntent.getBooleanExtra("param_only_discussion_member", false);
    this.bAR = this.mIntent.getBooleanExtra("param_only_troop_or_discussion_member", false);
    this.bAQ = this.mIntent.getBooleanExtra("param_face_to_face_troop", false);
    this.bAS = this.mIntent.getBooleanExtra("param_overload_tips_include_default_count", false);
    this.mTitleString = this.mIntent.getStringExtra("param_title");
    if (this.mTitleString == null) {
      this.mTitleString = getString(2131719427);
    }
    this.beA = this.mIntent.getStringExtra("param_done_button_wording");
    if (this.beA == null) {
      this.beA = getString(2131719445);
    }
    this.beB = this.mIntent.getStringExtra("param_done_button_highlight_wording");
    if (this.beB == null) {
      this.beB = (this.beA + "({0})");
    }
    this.bAT = this.mIntent.getBooleanExtra("param_add_passed_members_to_result_set", false);
    this.cmq = this.mIntent.getIntExtra("param_exit_animation", 0);
    this.cmr = this.mIntent.getIntExtra("param_back_button_side", 1);
    this.bBa = this.mIntent.getBooleanExtra("is_put_myself_first", false);
    this.bBb = this.mIntent.getBooleanExtra("is_forbid_only_choose_myself", false);
    if ((this.eK == 14) || (this.eK == 21))
    {
      localObject1 = this.mIntent.getParcelableArrayListExtra("param_default_selected_troop_members");
      if (localObject1 != null) {
        localObject1 = ((ArrayList)localObject1).iterator();
      }
    }
    else
    {
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (ResultRecord)((Iterator)localObject1).next();
        this.aQ.add(localObject2);
        continue;
        if (((this.eK == 32) || (this.eK == 35)) && ((this.bAO) || (this.bAP)))
        {
          GQ(-1);
          localObject1 = this.mIntent.getStringExtra("group_uin");
          if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!this.bAW) && (this.sp != null))
          {
            i = 0;
            if (i < this.sp.size())
            {
              if (!TextUtils.isEmpty((CharSequence)this.sp.get(i)))
              {
                localObject2 = new ResultRecord();
                ((ResultRecord)localObject2).uin = ((String)this.sp.get(i));
                if (!this.bAP) {
                  break label1120;
                }
              }
              label1120:
              for (int j = 2;; j = 1)
              {
                ((ResultRecord)localObject2).type = j;
                ((ResultRecord)localObject2).QD = ((String)localObject1);
                this.aQ.add(localObject2);
                i += 1;
                break;
              }
            }
          }
        }
        else if ((this.eK == 17) && (this.sp != null))
        {
          i = 0;
          while (i < this.sp.size())
          {
            if (!TextUtils.isEmpty((CharSequence)this.sp.get(i)))
            {
              localObject1 = new ResultRecord();
              ((ResultRecord)localObject1).uin = ((String)this.sp.get(i));
              this.aQ.add(localObject1);
            }
            i += 1;
          }
        }
      }
    }
    this.bAX = this.mIntent.getBooleanExtra("is_support_select_from_friend_groups", false);
  }
  
  public void cAc()
  {
    if (this.mFrom == 30) {
      return;
    }
    if (this.aQ.size() >= this.cmt)
    {
      Dj(true);
      return;
    }
    Dj(false);
  }
  
  @SuppressLint({"NewApi"})
  protected void cAd()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectedAndSearchBar.a(this.aQ, this.jdField_a_of_type_Aqdf, this.jdField_a_of_type_ComTencentMobileqqActivitySelectedAndSearchBar$b);
    Iterator localIterator = this.iK.entrySet().iterator();
    Object localObject;
    while (localIterator.hasNext())
    {
      localObject = (Map.Entry)localIterator.next();
      if ((!((Boolean)((Map.Entry)localObject).getValue()).booleanValue()) && ((this.mType != 9654) || (!((String)((Map.Entry)localObject).getKey()).equals(this.app.getCurrentAccountUin()))))
      {
        ResultRecord localResultRecord = new ResultRecord();
        localResultRecord.uin = ((String)((Map.Entry)localObject).getKey());
        localResultRecord.type = -1;
        localResultRecord.QD = "-1";
        this.aQ.add(localResultRecord);
      }
    }
    if (((this.aQ.size() != 0) && ((this.eK == 14) || (this.eK == 21))) || (this.eK == 32))
    {
      localIterator = this.aQ.iterator();
      while (localIterator.hasNext())
      {
        localObject = (ResultRecord)localIterator.next();
        if (this.eK == 32)
        {
          if (((ResultRecord)localObject).type == 1) {
            ((ResultRecord)localObject).name = aqgv.h(this.app, ((ResultRecord)localObject).QD, ((ResultRecord)localObject).uin);
          } else if (((ResultRecord)localObject).type == 2) {
            ((ResultRecord)localObject).name = aqgv.k(this.app, ((ResultRecord)localObject).QD, ((ResultRecord)localObject).uin);
          }
        }
        else {
          ((ResultRecord)localObject).name = aqgv.h(this.app, ((ResultRecord)localObject).QD, ((ResultRecord)localObject).uin);
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectedAndSearchBar.cz(true);
    }
    this.mRightBtn.setOnClickListener(new aaxz(this));
  }
  
  public void cAe()
  {
    if (System.currentTimeMillis() - this.MR < 1500L) {}
    apbc localapbc;
    do
    {
      return;
      this.MR = System.currentTimeMillis();
      localapbc = (apbc)this.app.getManager(32);
    } while (localapbc == null);
    Object localObject = new JSONObject();
    label528:
    for (;;)
    {
      try
      {
        ((JSONObject)localObject).put("group_type", 1);
        ((JSONObject)localObject).put("name", aqgv.n(this.app, this.app.getCurrentAccountUin()) + acfp.m(2131714222));
        ((JSONObject)localObject).put("classify", 10010);
        if ((this.eK != 12) && (this.eK != 36)) {
          ((JSONObject)localObject).put("isJumpAio", 1);
        }
        i = this.eK;
        if (i == 12) {
          i = 3;
        }
        ArrayList localArrayList;
        String str;
        ResultRecord localResultRecord;
        if (this.mFrom != 1002) {
          break;
        }
      }
      catch (JSONException localJSONException1)
      {
        try
        {
          ((JSONObject)localObject).put("create_source", i);
          localapbc.gi(((JSONObject)localObject).toString(), 5);
          anot.a(this.app, "dc00899", "Grp_create_new", "", "create_page", "clk_now", 0, 0, "", "" + i, "", "");
          localArrayList = new ArrayList(this.aQ.size());
          localArrayList.addAll(this.aQ);
          if (this.so == null) {
            continue;
          }
          localObject = this.so.iterator();
          if (!((Iterator)localObject).hasNext()) {
            continue;
          }
          str = (String)((Iterator)localObject).next();
          localResultRecord = new ResultRecord();
          localResultRecord.uin = str;
          localResultRecord.type = 0;
          localResultRecord.QD = "-1";
          localResultRecord.name = aqgv.e(this.app, localResultRecord.uin, localResultRecord.type);
          localArrayList.add(localResultRecord);
          continue;
          if (this.eK == 28)
          {
            i = 5;
            continue;
          }
          if (this.eK == 39)
          {
            i = 8;
            continue;
          }
          if (this.eK == 29)
          {
            i = 2;
            continue;
          }
          if (this.eK != 27) {
            break label528;
          }
          i = getIntent().getIntExtra("create_source", 0);
          continue;
          localJSONException1 = localJSONException1;
          i = 0;
        }
        catch (JSONException localJSONException2)
        {
          continue;
          int i = 0;
        }
        QLog.e("SelectMemberActivity", 1, "createNewTypeDiscussion json error!", localJSONException1);
        continue;
        localapbc.a(this, this, localJSONException1);
        if (this.mFrom == 1003)
        {
          anot.a(this.app, "dc00899", "Grp_create", "", "choose_cre", "clk_cre_main", 0, 0, "", "", "", "");
          return;
        }
      }
      anot.a(this.app, "dc00899", "Grp_create", "", "choose_cre", "clk_cre_conta", 0, 0, "", "", "", "");
      return;
    }
  }
  
  protected void cAf()
  {
    Object localObject = ((TroopManager)this.app.getManager(52)).c(this.aRJ);
    boolean bool1;
    if (localObject != null)
    {
      if ((((TroopInfo)localObject).troopPrivilegeFlag & 0x6100000) != 0L) {
        break label230;
      }
      bool1 = true;
    }
    for (;;)
    {
      boolean bool2 = bool1;
      if (bool1)
      {
        if (!((TroopInfo)localObject).isAdmin()) {
          bool2 = true;
        }
      }
      else
      {
        label54:
        if (((TroopInfo)localObject).maxInviteMemNum <= 0) {
          break label475;
        }
        if (((TroopInfo)localObject).wMemberNum + this.aQ.size() <= ((TroopInfo)localObject).maxInviteMemNum) {
          break label339;
        }
        bool1 = true;
      }
      for (;;)
      {
        label82:
        if (QLog.isColorLevel()) {
          QLog.d("SelectMemberActivity", 2, "refreshInviteTipsBar needAdminCheck = " + bool2 + " needAgree = " + bool1);
        }
        if ((!bool2) && (!bool1))
        {
          this.bBd = false;
          if ((this.eK == 11) || (this.eK == 36)) {
            this.beC = getString(2131697777);
          }
        }
        for (;;)
        {
          if ((this.isClosed) || (!this.bBd) || (TextUtils.isEmpty(this.beD))) {
            break label465;
          }
          this.Aj.setVisibility(0);
          localObject = (TextView)this.Aj.findViewById(2131379988);
          ((TextView)localObject).setText(this.beD);
          ((TextView)localObject).setContentDescription(this.beD);
          return;
          label230:
          if ((((TroopInfo)localObject).troopPrivilegeFlag & 0x2000000) == 33554432L)
          {
            if (((TroopInfo)localObject).wMemberNum + this.aQ.size() > 50)
            {
              bool1 = true;
              break;
            }
            bool1 = false;
            break;
          }
          if ((((TroopInfo)localObject).troopPrivilegeFlag & 0x4000000) == 67108864L)
          {
            if (((TroopInfo)localObject).wMemberNum + this.aQ.size() > 100)
            {
              bool1 = true;
              break;
            }
            bool1 = false;
            break;
          }
          if ((((TroopInfo)localObject).troopPrivilegeFlag & 0x100000) != 1048576L) {
            break label480;
          }
          bool1 = false;
          break;
          bool2 = false;
          break label54;
          label339:
          bool1 = false;
          break label82;
          this.beC = acfp.m(2131714229);
          continue;
          if ((!bool2) && (bool1))
          {
            this.bBd = true;
            this.beD = acfp.m(2131714213);
            this.beC = acfp.m(2131714237);
          }
          else if ((bool2) && (bool1))
          {
            this.bBd = true;
            this.beD = acfp.m(2131714227);
            this.beC = acfp.m(2131714218);
          }
          else if ((bool2) && (!bool1))
          {
            this.bBd = true;
            this.beD = acfp.m(2131714210);
            this.beC = acfp.m(2131714220);
          }
        }
        label465:
        this.Aj.setVisibility(8);
        return;
        label475:
        bool1 = false;
      }
      label480:
      bool1 = false;
    }
  }
  
  protected void cAh()
  {
    boolean bool = false;
    String str = null;
    Iterator localIterator = this.aQ.iterator();
    int i = 0;
    ResultRecord localResultRecord;
    if (localIterator.hasNext())
    {
      localResultRecord = (ResultRecord)localIterator.next();
      if (localResultRecord.type != 5) {
        break label365;
      }
      if (i >= 3) {
        new StringBuilder().append(str).append("…").toString();
      }
    }
    else
    {
      if (this.jdField_c_of_type_ComTencentMobileqqSearchFragmentContactSearchFragment != null) {
        this.jdField_c_of_type_ComTencentMobileqqSearchFragmentContactSearchFragment.N(dx(), this.so);
      }
      if (XF())
      {
        i = this.aQ.size();
        if (i <= 0) {
          break label278;
        }
        if ((this.eK != 35) && (this.eK != 40)) {
          break label235;
        }
        str = MessageFormat.format(this.beB, new Object[] { Integer.valueOf(i) });
        this.fx.setText(str);
        this.fx.setContentDescription(str);
        NewTroopContactView.setCreateTroopButtonEnable(this.fx, true);
      }
      if (XM()) {
        cAf();
      }
      return;
    }
    if (str == null)
    {
      str = localResultRecord.name;
      label196:
      i += 1;
    }
    label235:
    label365:
    for (;;)
    {
      break;
      str = str + "、" + localResultRecord.name;
      break label196;
      if (XL()) {}
      for (str = acfp.m(2131714234);; str = acfp.m(2131714215))
      {
        str = MessageFormat.format(str, new Object[] { Integer.valueOf(i) });
        break;
      }
      if (this.eK == 35)
      {
        str = this.beA;
        bool = true;
      }
      for (;;)
      {
        this.fx.setText(str);
        this.fx.setContentDescription(str);
        NewTroopContactView.setCreateTroopButtonEnable(this.fx, bool);
        break;
        if (this.eK == 40) {
          str = this.beA;
        } else if (XL()) {
          str = acfp.m(2131714208);
        } else {
          str = acfp.m(2131714235);
        }
      }
    }
  }
  
  protected void cAi()
  {
    if ((this.aQ != null) && (this.aQ.size() > 0))
    {
      Object localObject = ch();
      Intent localIntent = new Intent("tencent.video.q2v.SelectMember");
      localIntent.setPackage(this.app.getApplication().getPackageName());
      if (((ArrayList)localObject).size() > 0) {
        localIntent.putParcelableArrayListExtra("SelectMemberList", (ArrayList)localObject);
      }
      int i = this.aQ.size();
      localObject = ((ResultRecord)this.aQ.get(0)).name;
      localIntent.putExtra("InviteCount", i);
      localIntent.putExtra("FirstName", (String)localObject);
      this.app.getApp().sendBroadcast(localIntent);
    }
  }
  
  void cAj()
  {
    int i = 0;
    if (this.eK != 35) {}
    RelativeLayout localRelativeLayout;
    do
    {
      do
      {
        return;
      } while (!this.mIntent.getBooleanExtra("param_enable_all_select", false));
      localRelativeLayout = (RelativeLayout)findViewById(2131377479);
    } while (localRelativeLayout == null);
    if (this.bAW) {}
    for (;;)
    {
      localRelativeLayout.setVisibility(i);
      return;
      i = 8;
    }
  }
  
  public void cR(View paramView)
  {
    Object localObject2 = (ampt)paramView.getTag(2131381960);
    if (localObject2 == null) {}
    String str;
    Object localObject1;
    label229:
    do
    {
      return;
      if (this.eK == 33) {
        anot.a(this.app, "P_CliOper", "Vip_pay_mywallet", "", "wallet", "friendpay.selectpage.searchclick", 0, 0, "", "", "", "");
      }
      paramView = ((ampt)localObject2).getUin();
      str = ((ampt)localObject2).getTitle().toString();
      localObject1 = "-1";
      if ((localObject2 instanceof amoj))
      {
        localObject1 = ((amoj)localObject2).zc();
        if ((localObject2 instanceof amop))
        {
          paramView = ((amop)localObject2).f;
          if (!TextUtils.isEmpty(paramView.uin)) {
            break label229;
          }
          paramView = "pstn" + paramView.mobileNo;
        }
      }
      for (;;)
      {
        if (!(localObject2 instanceof amoi)) {
          break label278;
        }
        paramView = new Bundle();
        paramView.putString("group_uin", ((amoi)localObject2).getUin());
        paramView.putString("group_name", ((amoi)localObject2).za());
        this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.k(7, paramView);
        bNU();
        return;
        if (!(localObject2 instanceof amoo)) {
          break;
        }
        localObject1 = ((amoo)localObject2).mTroopUin;
        break;
        if (paramView.uin.equals("0")) {
          paramView = paramView.nationCode + paramView.mobileCode;
        } else {
          paramView = paramView.uin;
        }
      }
      if ((localObject2 instanceof amon))
      {
        paramView = (amon)localObject2;
        localObject1 = paramView.a();
        if ((!((TroopInfo)localObject1).isAllowCreateDiscuss()) && (!((TroopInfo)localObject1).isTroopOwner(this.app.getCurrentAccountUin())) && (!((TroopInfo)localObject1).isTroopAdmin(this.app.getCurrentAccountUin())))
        {
          QQToast.a(this, 0, getResources().getString(2131699837), 0).show(getResources().getDimensionPixelSize(2131299627));
          return;
        }
        localObject1 = new Bundle();
        ((Bundle)localObject1).putString("group_uin", paramView.getUin());
        ((Bundle)localObject1).putString("group_name", paramView.za());
        this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.k(6, (Bundle)localObject1);
        bNU();
        return;
      }
      if ((localObject2 instanceof amos))
      {
        paramView = (amos)localObject2;
        localObject1 = paramView.a();
        if ((!((TroopInfo)localObject1).isAllowCreateDiscuss()) && (!((TroopInfo)localObject1).isTroopOwner(this.app.getCurrentAccountUin())) && (!((TroopInfo)localObject1).isTroopAdmin(this.app.getCurrentAccountUin())))
        {
          QQToast.a(this, 0, getResources().getString(2131699837), 0).show(getResources().getDimensionPixelSize(2131299627));
          return;
        }
        localObject1 = new Bundle();
        ((Bundle)localObject1).putString("group_uin", paramView.getUin());
        ((Bundle)localObject1).putString("group_name", paramView.za());
        this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.k(6, (Bundle)localObject1);
        bNU();
        return;
      }
      if (iY(paramView))
      {
        QQToast.a(this, 1, acfp.m(2131714226), 0).show(getTitleBarHeight());
        anot.a(this.app, "dc00899", "invite_friend", "", "friend_list", "exp_toast_tobechecked", 0, 0, (String)localObject1, "", "", "");
        return;
      }
    } while (((this.so != null) && (this.so.contains(paramView))) || (iX(paramView)) || (a("onAction", false, paramView, str, -1, (String)localObject1)) || (ak(paramView, str)));
    label278:
    SelectMemberInnerFrame localSelectMemberInnerFrame = (SelectMemberInnerFrame)this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.getCurrentView();
    int i;
    if ((this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.uy() == 5) || (this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.uy() == 0) || (this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.uy() == 4) || (this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.uy() == 3) || (this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.uy() == 8))
    {
      i = -1;
      if ((localObject2 instanceof amoj))
      {
        i = 2;
        if (i != -1) {
          this.aQ.add(a(paramView, str, i, (String)localObject1));
        }
        label749:
        cAh();
        cAc();
        localSelectMemberInnerFrame.notifyDataSetChanged();
        this.jdField_a_of_type_ComTencentMobileqqActivitySelectedAndSearchBar.cz(true);
        this.jdField_a_of_type_ComTencentMobileqqActivitySelectedAndSearchBar.bVl();
        if (this.mType == 9003) {
          if ((this.eK != 15) || (this.jdField_a_of_type_Ylm.ic(paramView))) {
            break label1145;
          }
        }
      }
    }
    for (this.cmv += 1;; this.cmv += 1) {
      label1145:
      do
      {
        Dk(false);
        return;
        if ((localObject2 instanceof amoo))
        {
          i = 1;
          break;
        }
        if ((localObject2 instanceof amok))
        {
          i = 0;
          break;
        }
        if (!(localObject2 instanceof amop)) {
          break;
        }
        if ((paramView.startsWith("pstn")) && (b(paramView, str, 5, (String)localObject1)))
        {
          i = 5;
          break;
        }
        if (paramView.startsWith("+"))
        {
          i = 4;
          break;
        }
        i = 0;
        break;
        if (this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.uy() == 6)
        {
          this.aQ.add(a(paramView, str, 1, localSelectMemberInnerFrame.qN()));
          break label749;
        }
        if (this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.uy() == 7)
        {
          this.aQ.add(a(paramView, str, 2, localSelectMemberInnerFrame.qN()));
          break label749;
        }
        if (this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.uy() == 1)
        {
          if ((paramView.startsWith("pstn")) && (b(paramView, str, 5, localSelectMemberInnerFrame.qN())))
          {
            this.aQ.add(a(paramView, str, 5, localSelectMemberInnerFrame.qN()));
            break label749;
          }
          if (paramView.startsWith("+"))
          {
            this.aQ.add(a(paramView, str, 4, localSelectMemberInnerFrame.qN()));
            break label749;
          }
          this.aQ.add(a(paramView, str, 0, localSelectMemberInnerFrame.qN()));
          break label749;
        }
        if (this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.uy() != 9) {
          break label749;
        }
        localObject1 = a(paramView, str, 1, localSelectMemberInnerFrame.qN());
        localObject2 = new ArrayList(1);
        ((List)localObject2).add(localObject1);
        e((List)localObject2, false);
        break label749;
      } while ((this.eK != 32) || (this.jdField_a_of_type_Ylm.ie(paramView)));
    }
  }
  
  public ArrayList<String> cf()
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < this.aQ.size())
    {
      localArrayList.add(((ResultRecord)this.aQ.get(i)).uin);
      i += 1;
    }
    if (this.so != null) {
      localArrayList.addAll(this.so);
    }
    return localArrayList;
  }
  
  public ArrayList<ResultRecord> cg()
  {
    if ((this.eK == 11) && (this.st != null))
    {
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.aQ.iterator();
      while (localIterator.hasNext())
      {
        ResultRecord localResultRecord = (ResultRecord)localIterator.next();
        if (!iW(localResultRecord.uin)) {
          localArrayList.add(localResultRecord);
        }
      }
      return localArrayList;
    }
    return this.aQ;
  }
  
  protected ArrayList<ResultRecord> ch()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.aQ.iterator();
    while (localIterator.hasNext())
    {
      ResultRecord localResultRecord = (ResultRecord)localIterator.next();
      if (localResultRecord.type == 5)
      {
        if (localResultRecord.uin.startsWith("pstn")) {
          localResultRecord.uin = localResultRecord.uin.substring("pstn".length());
        }
        localArrayList.add(localResultRecord);
      }
    }
    return localArrayList;
  }
  
  public ArrayList<ResultRecord> ci()
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < this.aQ.size())
    {
      localArrayList.add(this.aQ.get(i));
      i += 1;
    }
    if (this.so != null)
    {
      Iterator localIterator = this.so.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        ResultRecord localResultRecord = new ResultRecord();
        localResultRecord.uin = str;
        localResultRecord.type = 0;
        localResultRecord.QD = "-1";
        localResultRecord.name = aqgv.e(this.app, localResultRecord.uin, localResultRecord.type);
        localArrayList.add(localResultRecord);
      }
    }
    return localArrayList;
  }
  
  public void cjw()
  {
    if ((this.mType == 3000) && (XK()))
    {
      cAe();
      return;
    }
    Object localObject1;
    label172:
    Object localObject2;
    Object localObject3;
    int i;
    int j;
    switch (this.mType)
    {
    default: 
      localObject1 = this.mIntent.getStringExtra("group_uin");
      if ((localObject1 != null) && (this.eK == 32) && ((this.bAO) || (this.bAP)))
      {
        this.mIntent.putExtra("group_uin", (String)localObject1);
        if (!this.bAO) {
          break label659;
        }
        localObject1 = ((TroopManager)this.app.getManager(52)).c((String)localObject1);
        this.mIntent.putExtra("group_type", 4);
        if (localObject1 != null)
        {
          this.mIntent.putExtra("group_name", ((TroopInfo)localObject1).troopname);
          this.mIntent.putExtra("group_member_type", ((TroopInfo)localObject1).wMemberNum);
        }
      }
      this.mIntent.putParcelableArrayListExtra("result_set", this.aQ);
      ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(getWindow().peekDecorView().getWindowToken(), 0);
      setResult(-1, this.mIntent);
      finish();
      return;
    case 3000: 
      if (this.bAT)
      {
        localObject1 = this.so.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (String)((Iterator)localObject1).next();
          if (!iZ((String)localObject2))
          {
            localObject3 = new ResultRecord();
            ((ResultRecord)localObject3).uin = ((String)localObject2);
            ((ResultRecord)localObject3).type = 0;
            ((ResultRecord)localObject3).QD = "-1";
            this.aQ.add(localObject3);
          }
        }
      }
      localObject1 = (acff)this.app.getManager(51);
      this.aQ.size();
      localObject2 = this.aQ.iterator();
      i = 0;
      j = 0;
      label347:
      if (((Iterator)localObject2).hasNext())
      {
        localObject3 = (ResultRecord)((Iterator)localObject2).next();
        if (((ResultRecord)localObject3).type == 3) {
          j = 1;
        }
        if (((ResultRecord)localObject3).type != 5)
        {
          i = 1;
          if ((j == 0) || (i == 0)) {
            break;
          }
        }
      }
      label391:
      break;
    }
    for (;;)
    {
      if (j != 0)
      {
        anot.a(this.app, "CliOper", "", "", "Network_circle", "Mutichat_start", 0, 0, "0", "", "", "");
        label434:
        if (this.bGG != 0) {
          break label610;
        }
        anot.a(this.app, "CliOper", "", "", "0X8005446", "0X8005446", 0, 0, "", "", "", "");
        label471:
        if (this.bGG != 0) {
          break label643;
        }
      }
      label643:
      for (j = 2131692828;; j = 2131692819)
      {
        this.jdField_c_of_type_Arhz = new arhz(this, getResources().getDimensionPixelSize(2131299627));
        this.jdField_c_of_type_Arhz.setMessage(j);
        this.jdField_c_of_type_Arhz.show();
        if ((this.bGG == 0) || (i != 0))
        {
          localObject1 = new SelectMemberActivity.12(this, (acff)localObject1);
          ((Thread)localObject1).setName("SelectMemberActivity_addDiscussion");
          ThreadManager.postImmediately((Runnable)localObject1, null, false);
        }
        if (this.bGG == 0) {
          break;
        }
        cAi();
        if (i != 0) {
          break;
        }
        finish();
        return;
        break label347;
        anot.a(this.app, "CliOper", "", "", "Network_circle", "Mutichat_start", 0, 0, "1", "", "", "");
        break label434;
        label610:
        anot.a(this.app, "CliOper", "", "", "0X800674C", "0X800674C", 0, 0, "", "", "", "");
        break label471;
      }
      dq(this.aQ);
      return;
      label659:
      if (!this.bAP) {
        break label172;
      }
      localObject2 = (acdu)this.app.getManager(53);
      localObject3 = ((acdu)localObject2).a((String)localObject1);
      this.mIntent.putExtra("group_type", 8);
      this.mIntent.putExtra("group_member_type", ((acdu)localObject2).cn((String)localObject1));
      if (localObject3 == null) {
        break label172;
      }
      this.mIntent.putExtra("group_name", ((DiscussionInfo)localObject3).discussionName);
      break label172;
      break label391;
    }
  }
  
  protected void czZ()
  {
    this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.onCreate(this);
    this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.setAppIntf(this.app);
    if (this.mFrom == 30)
    {
      this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.k(9, this.mIntent.getExtras());
      return;
    }
    if (this.bAO)
    {
      this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.k(6, this.mIntent.getExtras());
      return;
    }
    if (this.bAP)
    {
      this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.k(7, this.mIntent.getExtras());
      return;
    }
    if (this.bAR)
    {
      this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.yW(3);
      return;
    }
    this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.yW(0);
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 10001)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SelectMemberActivity", 2, "qqstory create share group result:" + paramInt2);
      }
      if (paramInt2 == -1)
      {
        setResult(-1, paramIntent);
        finish();
      }
    }
    while (this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.j(paramInt1, paramInt2, paramIntent);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    setTheme(2131755343);
    super.doOnCreate(paramBundle);
    cAb();
    cAa();
    if ((this.eK == 11) || (this.eK == 36)) {}
    ArrayList localArrayList;
    for (int i = 1;; i = 0)
    {
      if (i == 1) {
        super.getWindow().addFlags(524288);
      }
      this.jdField_a_of_type_Aqdf = new aqdf(this, this.app);
      this.mDensity = getResources().getDisplayMetrics().density;
      aDR();
      aC();
      cAd();
      initSearchBar();
      ix();
      czZ();
      if ((this.mType == 1) && (this.bGG == 1))
      {
        paramBundle = (TroopManager)this.app.getManager(52);
        if (paramBundle != null)
        {
          paramBundle = paramBundle.b(this.aRJ);
          if (paramBundle != null) {
            this.cmu = paramBundle.wMemberNum;
          }
        }
        ThreadManager.post(new SelectMemberActivity.1(this), 8, null, true);
      }
      this.eA = Bitmap.createBitmap(1, 1, Bitmap.Config.ALPHA_8);
      this.dk = aqhu.G();
      if (this.Z == null)
      {
        this.Z = new b();
        paramBundle = new IntentFilter();
        paramBundle.addAction("tencent.av.v2q.StopVideoChat");
        registerReceiver(this.Z, paramBundle);
      }
      if (this.mFrom == 30) {
        bp(true, true);
      }
      if ((this.mType != 9003) && (8998 != this.mType)) {
        break label415;
      }
      this.jdField_a_of_type_Ylm = ((ylm)this.app.getManager(138));
      Object localObject = this.jdField_a_of_type_Ylm.bL();
      if ((localObject == null) || (((ArrayList)localObject).size() <= 0)) {
        break label415;
      }
      paramBundle = (acff)this.app.getManager(51);
      localArrayList = new ArrayList();
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        Friends localFriends = paramBundle.e(str);
        if (localFriends != null) {
          localArrayList.add(a(str, localFriends.getFriendNick(), 0, "-1"));
        }
      }
    }
    e(localArrayList, false);
    label415:
    paramBundle = getIntent().getParcelableArrayListExtra("param_selected_records_for_create_discussion");
    if (paramBundle != null) {
      e(paramBundle, false);
    }
    if (this.mFrom == 1003) {
      anot.a(this.app, "dc00899", "Grp_create", "", "f2f", "clk_f2f_main", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      if (this.eK == 33) {
        anot.a(this.app, "P_CliOper", "Vip_pay_mywallet", "", "wallet", "friendpay.askaio.payershowfriendpay.askaio.payershowfriendpay.askaio.payerclickfriendpay.selectpage.show", 0, 0, "", "", "", "");
      }
      return true;
      if (this.mFrom == 1002) {
        anot.a(this.app, "dc00899", "Grp_create", "", "f2f", "clk_f2f_conta", 0, 0, "", "", "", "");
      }
    }
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.onDestroy();
    removeObserver(this.jdField_b_of_type_Acdv);
    removeObserver(this.p);
    removeObserver(this.jdField_b_of_type_Acnd);
    if ((this.pd != null) && (this.pd.isShowing())) {
      this.pd.dismiss();
    }
    if (this.jdField_a_of_type_Aqdf != null) {
      this.jdField_a_of_type_Aqdf.destory();
    }
    if (this.Z != null)
    {
      unregisterReceiver(this.Z);
      this.Z = null;
    }
    apbc localapbc = (apbc)this.app.getManager(32);
    if (localapbc != null) {
      localapbc.a(this);
    }
  }
  
  public void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    if (QLog.isColorLevel()) {
      QLog.d("SelectMemberActivity", 2, "doOnNewIntent");
    }
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.onPause();
    iA(false);
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.onResume();
    iA(true);
  }
  
  public void doOnStart()
  {
    super.doOnStart();
    getWindow().setSoftInputMode(16);
  }
  
  public void doOnStop()
  {
    super.doOnStop();
    getWindow().setSoftInputMode(48);
    this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.onStop();
  }
  
  public void dq(ArrayList<ResultRecord> paramArrayList)
  {
    if ((paramArrayList.size() > 0) && (this.aRJ.length() > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SelectMemberActivity", 2, "add troop member: troopCode: " + this.aRJ + " member count: " + paramArrayList.size());
      }
      if (!XI())
      {
        QQToast.a(this, 2131696378, 0).show(getTitleBarHeight());
        return;
      }
      if (this.cmu <= 0)
      {
        Object localObject = (TroopManager)this.app.getManager(52);
        if (localObject != null)
        {
          localObject = ((TroopManager)localObject).b(this.aRJ);
          if (localObject != null) {
            this.cmu = ((TroopInfo)localObject).wMemberNum;
          }
        }
      }
      if ((this.MQ > 0L) && (paramArrayList.size() + this.cmu > this.MQ))
      {
        aqha.a(this, acfp.m(2131714232), 2131721058, 2131695116, new aaye(this, paramArrayList), new aqha.a()).show();
        Bc("exp_msgbox");
        return;
      }
      ((acms)this.app.getBusinessHandler(20)).a(this.aRJ, paramArrayList, "");
      cAg();
      this.pd.show();
      Bc("Clk_invite");
      return;
    }
    finish();
  }
  
  public void dr(ArrayList<Entity> paramArrayList)
  {
    this.st = paramArrayList;
  }
  
  public List<String> dx()
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < this.aQ.size())
    {
      localArrayList.add(((ResultRecord)this.aQ.get(i)).uin);
      i += 1;
    }
    return localArrayList;
  }
  
  public boolean e(List<ResultRecord> paramList, boolean paramBoolean)
  {
    return a(paramList, paramBoolean, false);
  }
  
  public void finish()
  {
    if (QLog.isDevelopLevel()) {
      QLog.w("SelectMemberActivity", 1, "finish", new Throwable("打印调用栈"));
    }
    ForwardRecentActivity.a(this.mIntent, this);
    super.finish();
    if (this.Z != null)
    {
      unregisterReceiver(this.Z);
      this.Z = null;
    }
    switch (this.cmq)
    {
    default: 
      overridePendingTransition(0, 2130771990);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectedAndSearchBar.QG()) {
        bNU();
      }
      return;
      overridePendingTransition(2130772000, 2130772001);
      continue;
      overridePendingTransition(0, 2130772013);
      continue;
      overridePendingTransition(0, 0);
    }
  }
  
  public int getType()
  {
    return this.mType;
  }
  
  public void hg()
  {
    if ((this.mTitle != null) && (this.em != null))
    {
      ((Animatable)this.em).stop();
      this.em = null;
      this.mTitle.setCompoundDrawables(null, null, null, null);
    }
  }
  
  boolean iW(String paramString)
  {
    Iterator localIterator = this.st.iterator();
    while (localIterator.hasNext()) {
      if (TextUtils.equals(((TroopMemberInfo)localIterator.next()).memberuin, paramString)) {
        return true;
      }
    }
    return false;
  }
  
  public boolean iX(String paramString)
  {
    boolean bool2 = false;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < this.aQ.size())
      {
        if (((ResultRecord)this.aQ.get(i)).uin.equals(paramString)) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public boolean iY(String paramString)
  {
    boolean bool2 = false;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < this.vA.size())
      {
        if (((String)this.vA.get(i)).equals(paramString)) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public String in(String paramString)
  {
    TroopManager localTroopManager = (TroopManager)this.app.getManager(52);
    if (localTroopManager != null)
    {
      paramString = localTroopManager.b(paramString);
      if (paramString != null) {
        return paramString.troopcode;
      }
    }
    return null;
  }
  
  public void initSearchBar()
  {
    if (this.jdField_d_of_type_AndroidViewInputmethodInputMethodManager == null) {
      this.jdField_d_of_type_AndroidViewInputmethodInputMethodManager = ((InputMethodManager)getSystemService("input_method"));
    }
    this.Ai.setOnTouchListener(new aaxo(this));
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public boolean onBackEvent()
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivitySelectedAndSearchBar.a()))
    {
      bNU();
      return true;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectedAndSearchBar.QG()) {
      bNU();
    }
    switch (this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.uy())
    {
    }
    for (;;)
    {
      return super.onBackEvent();
      hg();
      this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.yW(0);
      return true;
      if (this.bAR)
      {
        if (this.eK == 27)
        {
          this.mIntent.putParcelableArrayListExtra("result_set", this.aQ);
          ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(getWindow().peekDecorView().getWindowToken(), 0);
          setResult(-1, this.mIntent);
        }
        finish();
      }
      for (;;)
      {
        return true;
        hg();
        this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.yW(0);
      }
      if (this.bAO) {
        finish();
      }
      for (;;)
      {
        return true;
        hg();
        this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.yW(3);
      }
      if (this.bAP) {
        finish();
      }
      for (;;)
      {
        return true;
        hg();
        this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.yW(3);
      }
      this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.yW(0);
      return true;
      finish();
    }
  }
  
  public void onClick(View paramView)
  {
    label157:
    ResultRecord localResultRecord;
    Intent localIntent;
    int i;
    switch (paramView.getId())
    {
    default: 
    case 2131379987: 
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        this.Aj.setVisibility(8);
        this.isClosed = true;
        anot.a(this.app, "dc00899", "invite_friend", "", "friend_list", "Clk_close", 0, 0, this.aRJ, jlk.a(this.app, this.app.getCurrentAccountUin(), this.aRJ) + "", "", "");
      }
    case 2131365522: 
      if (this.eK == 35)
      {
        if (this.aQ.size() >= 1)
        {
          localObject1 = "1";
          anot.a(this.app, "CliOper", "", "", "0X8009E2B", "0X8009E2B", 0, 0, (String)localObject1, "", "", "");
        }
      }
      else
      {
        if ((this.eK != 12) || (this.aQ.size() != 1)) {
          break label459;
        }
        localResultRecord = (ResultRecord)this.aQ.get(0);
        localIntent = new Intent();
        localIntent.putExtra("select_memeber_single_friend", true);
        localIntent.putExtra("select_memeber_single_friend_type", localResultRecord.type);
        if ((localResultRecord.type == 0) && (localResultRecord.type != 1)) {
          break label811;
        }
        i = 1000;
      }
      break;
    }
    for (Object localObject1 = in(localResultRecord.QD);; localObject1 = null)
    {
      if (localResultRecord.type == 2)
      {
        localObject1 = localResultRecord.QD;
        i = 1004;
      }
      for (;;)
      {
        if (localResultRecord.type == 3) {
          i = 1021;
        }
        for (;;)
        {
          Object localObject2 = ((acff)this.app.getManager(51)).e(localResultRecord.uin);
          int j = i;
          if (localObject2 != null)
          {
            j = i;
            if (((Friends)localObject2).isFriend()) {
              j = 0;
            }
          }
          localObject2 = new Bundle();
          ((Bundle)localObject2).putString("uin", localResultRecord.uin);
          ((Bundle)localObject2).putInt("uintype", j);
          ((Bundle)localObject2).putString("uinname", localResultRecord.name);
          ((Bundle)localObject2).putString("troop_uin", (String)localObject1);
          localIntent.putExtras((Bundle)localObject2);
          setResult(-1, localIntent);
          finish();
          break;
          localObject1 = "2";
          break label157;
          if (localResultRecord.type == 4)
          {
            i = 1006;
            continue;
            label459:
            if (XL())
            {
              cAe();
              break;
            }
            if (XM())
            {
              if (this.eK == 11)
              {
                localObject1 = cg();
                if (((ArrayList)localObject1).size() > 0)
                {
                  aqha.a(this, 230, getString(2131697879), getString(2131697759), 2131697614, 2131697626, new aaxu(this, (ArrayList)localObject1), new aaxv(this)).show();
                  break;
                }
                bu(this.mIntent.getStringExtra("group_uin"), false);
                break;
              }
              if (this.eK == 37)
              {
                this.mIntent.putParcelableArrayListExtra("result_set", this.aQ);
                setResult(-1, this.mIntent);
                finish();
                break;
              }
              dq(this.aQ);
              break;
            }
            this.mIntent.putParcelableArrayListExtra("result_set", this.aQ);
            setResult(-1, this.mIntent);
            finish();
            break;
            bNU();
            if (dx().size() == 1)
            {
              localObject1 = (String)dx().get(0);
              if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity$a == null) {
                break;
              }
              this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity$a.Bg((String)localObject1);
              break;
            }
            localObject1 = new Intent();
            ((Intent)localObject1).putExtra("TROOP_UIN", this.mIntent.getStringExtra("group_uin"));
            ((Intent)localObject1).putExtra("hide_title_left_arrow", true);
            PublicFragmentActivity.startForResult(this, (Intent)localObject1, UnitedVerifyMsgEditFragment.class, 10);
            overridePendingTransition(2130772009, 2130772002);
            localObject1 = getIntent().getStringExtra("group_uin");
            if (TextUtils.isEmpty((CharSequence)localObject1)) {
              break;
            }
            ThreadManager.post(new SelectMemberActivity.19(this, (String)localObject1), 5, null, true);
            break;
          }
        }
      }
      label811:
      i = 0;
    }
  }
  
  protected void onRestart()
  {
    super.onRestart();
  }
  
  public void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
  
  public void s(boolean paramBoolean, String paramString1, String paramString2)
  {
    if (paramBoolean)
    {
      this.Bi.setVisibility(0);
      this.Bi.setText(paramString1);
      this.Bi.setOnClickListener(new aaxw(this));
      this.Bi.setBackgroundResource(2130851758);
      this.GS.setVisibility(8);
      IphoneTitleBarActivity.setLayerType(this.Bi);
      if ((this.eK != 14) && (this.eK != 21) && (this.eK != 25) && (this.eK != 35)) {
        break label206;
      }
      if (TextUtils.isEmpty(this.mTitleString)) {
        break label195;
      }
      this.mTitle.setText(this.mTitleString);
      label118:
      if (AppSetting.enableTalkBack)
      {
        this.mTitle.setContentDescription(this.mTitle.getText());
        paramString2 = this.Bi;
        if (!TextUtils.isEmpty(this.Bi.getText())) {
          break label395;
        }
      }
    }
    label395:
    for (paramString1 = acfp.m(2131714228);; paramString1 = this.Bi.getText())
    {
      paramString2.setContentDescription(paramString1);
      this.Bi.postDelayed(new SelectMemberActivity.4(this), 1000L);
      return;
      aC();
      break;
      label195:
      this.mTitle.setText(paramString2);
      break label118;
      label206:
      if (this.bGG == 3)
      {
        this.mTitle.setText(getString(2131700028));
        break label118;
      }
      if (this.mFrom == 30)
      {
        this.mTitleString = getString(2131689787);
        if (!this.mTitle.getText().equals(this.mTitleString)) {
          this.mTitle.setText(this.mTitleString);
        }
        if (this.mRightBtn.getVisibility() != 0) {
          this.mRightBtn.setVisibility(0);
        }
        if (8 != this.GS.getVisibility()) {
          this.GS.setVisibility(8);
        }
        this.Bi.setVisibility(0);
        this.mRightBtn.setVisibility(8);
        this.Bi.setOnClickListener(new aaxx(this));
        if (!AppSetting.enableTalkBack) {
          break label118;
        }
        this.mTitle.setContentDescription(this.mTitleString);
        this.Bi.setContentDescription(getString(2131719436));
        break label118;
      }
      this.mTitle.setText(paramString2);
      break label118;
    }
  }
  
  public int zs()
  {
    int j = 0;
    long l = aqft.getCurZeroTimeMillis();
    Object localObject = this.app.getApp().getSharedPreferences(this.app.getAccount(), 0).getString("not_admin_invite_member_count", null);
    int i = j;
    if (localObject != null) {}
    try
    {
      localObject = ((String)localObject).split(":");
      i = j;
      if (Long.parseLong(localObject[0]) == l) {
        i = Integer.parseInt(localObject[1]);
      }
      return i;
    }
    catch (Exception localException) {}
    return 0;
  }
  
  public static abstract interface a
  {
    public abstract void Bg(String paramString);
    
    public abstract void b(ResultRecord paramResultRecord, boolean paramBoolean);
    
    public abstract void bp(boolean paramBoolean1, boolean paramBoolean2);
  }
  
  class b
    extends BroadcastReceiver
  {
    b() {}
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      paramContext = paramIntent.getAction();
      if ((TextUtils.isEmpty(paramIntent.getPackage())) || (!paramIntent.getPackage().equals(SelectMemberActivity.this.app.getApp().getPackageName()))) {
        if (QLog.isColorLevel()) {
          QLog.d("SelectMemberActivity", 2, "receive broadcast from wrong package:" + paramIntent.getPackage() + ",action:" + paramContext);
        }
      }
      int i;
      int j;
      do
      {
        do
        {
          return;
        } while (!paramContext.equals("tencent.av.v2q.StopVideoChat"));
        i = paramIntent.getIntExtra("stopReason", 0);
        j = paramIntent.getIntExtra("stopReason3rd", -1);
      } while (((i != 0) && (j != 1)) || ((SelectMemberActivity.this.eK != 11) && (SelectMemberActivity.this.eK != 36)));
      if (QLog.isColorLevel()) {
        QLog.d("SelectMemberActivity", 2, "ACTION_STOP_VIDEO_CHAT");
      }
      SelectMemberActivity.this.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectmember.SelectMemberActivity
 * JD-Core Version:    0.7.0.1
 */