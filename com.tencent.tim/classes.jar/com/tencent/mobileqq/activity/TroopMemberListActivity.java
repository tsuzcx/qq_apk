package com.tencent.mobileqq.activity;

import abdw;
import abeg;
import abeg.a;
import accc;
import acdt;
import acdu;
import acdv;
import acff;
import acfp;
import acle;
import acms;
import acnd;
import aldj;
import alud;
import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.Editable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewStub;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import anlm;
import anot;
import anov;
import aofe;
import apdg;
import apdg.a;
import apmb;
import apqz;
import apsz;
import aptw;
import aqfr;
import aqft;
import aqgv;
import aqhu;
import aqiw;
import aqpm;
import ausj;
import ausj.a;
import auuw;
import auuw.a;
import com.tencent.biz.pubaccount.PublicAccountBrowser;
import com.tencent.biz.troop.EditUniqueTitleActivity;
import com.tencent.mobileqq.activity.chathistory.TroopMemberHistoryFragment;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.troop.honor.widget.TroopHonorView;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.widget.IndexView;
import com.tencent.mobileqq.widget.IndexView.a;
import com.tencent.mobileqq.widget.IndexView.b;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.TroopMemberListSlideItem;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.c;
import com.tencent.widget.PinnedDividerSwipListView;
import com.tencent.widget.ThemeImageView;
import com.tencent.widget.XListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import cooperation.troop.TroopFileProxyActivity;
import java.lang.ref.WeakReference;
import java.text.DecimalFormat;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import jnm;
import jnm.d;
import org.json.JSONArray;
import org.json.JSONObject;
import rpq;
import tbb;
import tencent.im.oidb.cmd0x74f.oidb_cmd0x74f.Range;
import tencent.im.oidb.cmd0x74f.oidb_cmd0x74f.ReqBody;
import tencent.im.oidb.cmd0xa2a.oidb_0xa2a.UserInfo;
import waz;
import wba;
import wbb;
import wbc;
import wbd;
import wbe;
import wbf;
import wbg;
import wbh;
import wbi;
import wbk;
import wbl;
import wbm;
import wbn;
import wbo;
import wbp;
import wbr;
import wbs;
import wbt;
import wbu;
import wbv;
import wbw;
import wbx;
import wby;
import wbz;
import wca;
import wcb;
import wcc;
import wcd;
import wce;
import wcf;
import wcg;
import wch;
import wci;
import wcj;
import wck;
import wcl;
import wcm;
import wco;
import wja;

public class TroopMemberListActivity
  extends BaseActivity
  implements IndexView.a, IndexView.b, AdapterView.c
{
  private static int bLR = 1000;
  public static double bx = 10.0D;
  public int BL = 0;
  public TextView Bi;
  public Dialog G;
  public TextView Gk;
  protected TextView Gl;
  public long Hm;
  public long Hn;
  private long Ho;
  private long Hp;
  private long[] T;
  private long[] U;
  private long[] V;
  public Dialog W;
  protected acdt a;
  public alud a;
  public c a;
  public e a;
  protected DiscussionInfo a;
  public TroopInfoData a;
  public PinnedDividerSwipListView a;
  public String aKI = "";
  public boolean aLZ = false;
  public String aPW = "";
  public String aPX = "";
  protected String aQK = "";
  public String aQL = "";
  protected String aQM;
  protected String aQN;
  protected String aQO;
  protected String aQP;
  protected String aQQ;
  protected String aQR;
  public String aQS = "2";
  protected String aQT = "https://qun.qq.com/qunpay/gifts/rank_list.html?troopUin=%1$s&_wv=1031&_bid=2204";
  public final String aQU = "param_seq_name";
  public final String aQV = "param_seq_days";
  public final String aQW = "param_deleted_uins";
  private String aQX = acfp.m(2131715913);
  protected String aQY = "";
  public String aQZ = "";
  public String aRa = "";
  protected String aRb;
  public boolean aUo;
  public boolean aYy = true;
  public boolean aaC;
  protected ImageButton ae;
  public EditText ay;
  public acdv b;
  public acnd b;
  public TroopInfo b;
  protected IndexView b;
  public int bLG;
  protected int bLH = 0;
  public int bLI;
  protected int bLJ = -1;
  protected int bLK = 2147483647;
  protected int bLL;
  public int bLM;
  public int bLN;
  public int bLO = 50;
  private int bLP = -1;
  private int bLQ;
  public boolean bap;
  protected boolean bba;
  public boolean bbn;
  public boolean bbo;
  public boolean bbp;
  protected boolean bbq;
  protected boolean bbr;
  private boolean bbs;
  private boolean bbt;
  private boolean bbu = true;
  private boolean bbv;
  private boolean bbw;
  public boolean bbx;
  public boolean bby = true;
  public int bfM;
  public double bw = 0.0D;
  public auuw c;
  public View.OnClickListener cn = new wbx(this);
  private String[] cu;
  private String[] cv;
  protected Drawable dD;
  public View.OnClickListener dv = new wby(this);
  public View.OnClickListener dw = new wcm(this);
  public View.OnClickListener dx = new waz(this);
  private DecimalFormat e = new DecimalFormat("#.##");
  protected RelativeLayout ex;
  protected RelativeLayout gW;
  protected ausj.a h = new wbp(this);
  protected RelativeLayout hh;
  public RelativeLayout hi;
  protected RelativeLayout hj;
  public TextView kn;
  public ausj mActionSheet;
  protected float mDensity = 1.5F;
  public int mFrom = 0;
  public Handler mHandler = new wbw(this);
  public int mItemHeight;
  protected LayoutInflater mLayoutInflater;
  protected View mLoadingView;
  public ProgressBar mProgressBar;
  public LinearLayout mRootView;
  public List<a> mSearchResultList = new ArrayList();
  public TextView mTitle;
  public View mTitleBar;
  public LinearLayout mTitleLayout;
  protected String mTroopName = "";
  public String mTroopUin = "";
  protected XListView o;
  public ArrayList<String> pM = new ArrayList();
  private ArrayList<String> pN = new ArrayList();
  private ArrayList<String> pO = new ArrayList();
  private ArrayList<String> pP = new ArrayList();
  private ArrayList<String> pQ = new ArrayList();
  private ArrayList<String> pR = new ArrayList();
  protected ArrayList<String> pS = new ArrayList();
  public List<a> pr = new ArrayList();
  private List<oidb_cmd0x74f.Range> range = new ArrayList();
  protected List<DiscussionMemberInfo> rn;
  protected List<String> ro = new ArrayList();
  protected View root;
  public List<String> rp = new ArrayList();
  protected List<String> rq = new ArrayList();
  public ImageView ru;
  public ImageView rv;
  protected View sq;
  private View vy;
  
  public TroopMemberListActivity()
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData = new TroopInfoData();
    this.jdField_b_of_type_Acdv = new wcb(this);
    this.jdField_b_of_type_Acnd = new wcd(this);
  }
  
  private void BP(int paramInt)
  {
    LinearLayout localLinearLayout = (LinearLayout)this.c.getContentView().findViewById(2131365360);
    int i = 0;
    if (i < localLinearLayout.getChildCount())
    {
      Object localObject = localLinearLayout.getChildAt(i);
      auuw.a locala = (auuw.a)((View)localObject).getTag();
      if (locala != null)
      {
        localObject = (TextView)((View)localObject).findViewById(2131379576);
        if (localObject != null)
        {
          if (locala.id != paramInt) {
            break label98;
          }
          ((TextView)localObject).setTextColor(getResources().getColor(2131167315));
        }
      }
      for (;;)
      {
        i += 1;
        break;
        label98:
        ((TextView)localObject).setTextColor(getResources().getColor(2131167304));
      }
    }
  }
  
  private void G(List<TroopMemberInfo> paramList, int paramInt)
  {
    if (paramList == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopMemberListActivityget_troop_member", 2, "processConvertTroopMemberInfo2AtTroopMember, processIndex:" + paramInt);
    }
    ArrayList localArrayList = new ArrayList();
    acff localacff = (acff)this.app.getManager(51);
    aptw localaptw = (aptw)this.app.getManager(203);
    int j = paramList.size();
    int i = 0;
    if (i < j)
    {
      TroopMemberInfo localTroopMemberInfo = (TroopMemberInfo)paramList.get(i);
      if (localTroopMemberInfo != null)
      {
        if (!aqft.rl(localTroopMemberInfo.memberuin)) {
          break label244;
        }
        if ((this.mFrom != 2) || ((!localTroopMemberInfo.memberuin.equals(this.aPW)) && (!this.aPX.contains(localTroopMemberInfo.memberuin)))) {
          break label165;
        }
      }
      for (;;)
      {
        i += 1;
        break;
        label165:
        if (((this.rq == null) || (!this.rq.contains(localTroopMemberInfo.memberuin))) && ((this.mFrom != 20) || (!localaptw.gM(localTroopMemberInfo.memberuin))) && (!localTroopMemberInfo.memberuin.equals("50000000")))
        {
          localArrayList.add(a(localTroopMemberInfo, localacff));
          continue;
          label244:
          if (QLog.isColorLevel()) {
            QLog.d("TroopMemberListActivityget_troop_member", 2, "processConvertTroopMemberInfo2AtTroopMember, continued, tmi.memberuin:" + localTroopMemberInfo.memberuin);
          }
        }
      }
    }
    paramList = this.mHandler.obtainMessage(12, localArrayList);
    paramList.arg1 = paramInt;
    this.mHandler.sendMessage(paramList);
  }
  
  private boolean QQ()
  {
    int i;
    if ((this.mFrom == 3) || (this.mFrom == 2) || (this.mFrom == 14))
    {
      i = 1;
      if (this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo == null) {
        break label85;
      }
      long l = this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo.dwGroupClassExt;
      if ((l != 10009L) && (l != 10010L) && (l != 10011L)) {
        break label85;
      }
    }
    label85:
    for (int j = 1;; j = 0)
    {
      if ((i != 0) && (j != 0))
      {
        return true;
        i = 0;
        break;
      }
      return false;
    }
  }
  
  private static void a(QQAppInterface paramQQAppInterface, TextView paramTextView, View paramView, String paramString, int paramInt)
  {
    if ((paramQQAppInterface == null) || (paramTextView == null) || (paramView == null) || (TextUtils.isEmpty(paramString))) {}
    int i;
    do
    {
      do
      {
        do
        {
          return;
        } while (!((aptw)paramQQAppInterface.getManager(203)).gM(paramString));
        int j = paramView.getWidth();
        i = j;
        if (j == 0)
        {
          paramView.measure(0, 0);
          i = paramView.getMeasuredWidth();
        }
        if (i != 0) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("TroopMemberListActivityget_troop_member", 2, "checkAdjustNicknameMaxWidthWithRobotMask nRobotMaskWidth error");
      return;
      paramInt -= i;
      if (paramInt > 0) {
        paramTextView.setMaxWidth(paramInt);
      }
    } while (!QLog.isColorLevel());
    QLog.d("TroopMemberListActivityget_troop_member", 2, "checkAdjustNicknameMaxWidthWithRobotMask nRobotMaskWidth:" + i + " nTargetMaxWidth:" + paramInt);
  }
  
  private void a(boolean paramBoolean1, String paramString1, boolean paramBoolean2, int paramInt1, int paramInt2, String paramString2, String paramString3, boolean paramBoolean3)
  {
    int i;
    Object localObject2;
    Object localObject1;
    Object localObject3;
    if ((this.mFrom == 3) && (!this.bap) && (this.bLH != 1))
    {
      i = 1;
      if ((!this.bap) && (paramBoolean3) && (this.hh != null))
      {
        localObject2 = (TextView)this.hh.findViewById(2131380814);
        localObject1 = getString(2131721411);
        ((TextView)localObject2).setText((CharSequence)localObject1);
        localObject2 = (TextView)this.hh.findViewById(2131377102);
        ((TextView)localObject2).setText("");
        ((ImageView)this.hh.findViewById(2131369767)).setBackgroundDrawable(aqhu.aW());
        localObject3 = (ImageView)this.hh.findViewById(2131373912);
        ((ImageView)localObject3).setVisibility(8);
        if (i != 0)
        {
          ((ImageView)localObject3).setVisibility(0);
          ((ImageView)localObject3).setOnClickListener(new wce(this));
          ((TextView)localObject2).setTextSize(12.0F);
        }
        this.hh.setOnClickListener(new wcf(this, (String)localObject1));
        if (!this.bbt)
        {
          this.hh.setVisibility(0);
          this.hh.setEnabled(false);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("TroopMemberListActivityget_troop_member", 2, "onGetAtAllRemianCountInfo:" + paramBoolean1 + ", " + paramString1 + ", " + paramBoolean2 + ", " + paramInt1 + ", " + paramString2 + ", " + paramString3);
      }
      if ((this.hh != null) && (this.dD != null))
      {
        ((Animatable)this.dD).stop();
        this.dD = null;
        ((TextView)this.hh.findViewById(2131377102)).setCompoundDrawables(null, null, null, null);
      }
      if ((this.hh != null) && (this.hh.getVisibility() != 8))
      {
        this.hh.setEnabled(true);
        if ((paramBoolean1) && (paramString1 != null)) {
          break label390;
        }
      }
    }
    label390:
    do
    {
      return;
      i = 0;
      break;
      ((TextView)this.hh.findViewById(2131380814)).setTextColor(getResources().getColor(2131167304));
      localObject1 = (TextView)this.hh.findViewById(2131377102);
      localObject2 = acfp.m(2131715932);
      localObject3 = (Button)this.hh.findViewById(2131372652);
      ((Button)localObject3).setVisibility(8);
      ((Button)localObject3).setOnClickListener(new wcg(this));
      i = ((acle)this.app.getBusinessHandler(13)).AX();
      if (this.mFrom != 11) {
        break label773;
      }
    } while (!paramString1.equals(this.aKI));
    this.bLG = paramInt2;
    if ((paramBoolean2) && (paramInt1 > 0))
    {
      paramBoolean1 = true;
      label528:
      this.bbp = paramBoolean1;
      if (!this.bbp) {
        break label678;
      }
      this.aQL = (acfp.m(2131715936) + paramInt1 + acfp.m(2131715939));
      ((TextView)localObject1).setText(this.aQL);
      paramString1 = (String)localObject2 + "," + this.aQL;
      label615:
      paramString2 = paramString1;
      if (this.jdField_b_of_type_ComTencentMobileqqWidgetIndexView.getVisibility() == 0)
      {
        paramString2 = (LinearLayout.LayoutParams)((TextView)localObject1).getLayoutParams();
        paramString2.rightMargin = wja.dp2px(20.0F, getResources());
        ((TextView)localObject1).setLayoutParams(paramString2);
      }
    }
    for (paramString2 = paramString1;; paramString2 = (String)localObject2 + "," + paramString1)
    {
      this.hh.setContentDescription(paramString2);
      return;
      paramBoolean1 = false;
      break label528;
      label678:
      if (paramInt1 == 0)
      {
        this.aQL = acfp.m(2131715998);
        paramString1 = (String)localObject2 + ",剩余0次";
        ((TextView)localObject1).setText("剩余0次");
        break label615;
      }
      this.aQL = "";
      paramString1 = (String)localObject2 + "," + acfp.m(2131715997);
      ((TextView)localObject1).setText("");
      break label615;
      label773:
      if (!paramString1.equals(this.mTroopUin)) {
        break;
      }
      this.bbp = paramBoolean2;
      this.aQL = paramString3;
      if (TextUtils.isEmpty(paramString2))
      {
        QLog.e("TroopMemberListActivityget_troop_member", 1, "updateUIForAtAllRemainedCount remainTips empty");
        return;
      }
      paramString1 = paramString2;
      if (!this.bbp)
      {
        paramString1 = paramString2;
        if (i != 3)
        {
          ((Button)localObject3).setVisibility(0);
          paramString2 = paramString2 + ",\n超级会员可继续使用";
          ((TextView)localObject1).setGravity(21);
          ((TextView)localObject1).setLineSpacing(this.mDensity * 5.0F, 1.0F);
          paramInt1 = (int)(acfp.m(2131715994).length() * 12 * this.mDensity);
          new DisplayMetrics();
          paramInt2 = (int)(getResources().getDisplayMetrics().widthPixels - 227.0F * this.mDensity - 5.0F * this.mDensity);
          paramString1 = paramString2;
          if (paramInt1 > paramInt2)
          {
            ((TextView)localObject1).setSingleLine(false);
            ((TextView)localObject1).setLines(2);
            ((TextView)localObject1).setWidth(paramInt2);
            ((TextView)localObject1).setEllipsize(TextUtils.TruncateAt.END);
            paramString1 = paramString2;
          }
        }
      }
      paramString2 = new SpannableString(paramString1);
      paramString3 = Pattern.compile("[^0-9]").matcher(paramString1).replaceAll("").trim();
      if (!TextUtils.isEmpty(paramString3))
      {
        paramInt1 = paramString1.indexOf(paramString3);
        paramInt2 = paramString3.length();
        paramString2.setSpan(new ForegroundColorSpan(-48606), paramInt1, paramInt2 + paramInt1, 33);
      }
      if (paramString1.contains(acfp.m(2131716004)))
      {
        paramInt1 = paramString1.indexOf(acfp.m(2131716005));
        paramInt2 = acfp.m(2131715922).length();
        paramString2.setSpan(new ForegroundColorSpan(-48606), paramInt1, paramInt2 + paramInt1, 33);
      }
      ((TextView)localObject1).setText(paramString2);
    }
  }
  
  private void am(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((this.mFrom == 20) || (this.mFrom == 21)) {
      this.Gl.setText(String.format(acfp.m(2131715983), new Object[] { Integer.valueOf(paramInt3) }));
    }
    for (;;)
    {
      this.mProgressBar.setProgress(paramInt3);
      return;
      this.Gl.setText(String.format(acfp.m(2131715919), new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
    }
  }
  
  private void au(Message paramMessage)
  {
    if (paramMessage == null) {
      return;
    }
    if ((this.hi != null) && (this.hi.getVisibility() == 0)) {
      this.hi.setVisibility(8);
    }
    if (this.hj.getVisibility() == 8) {
      this.hj.setVisibility(0);
    }
    paramMessage = (Object[])paramMessage.obj;
    if ((paramMessage != null) && (paramMessage.length == 3))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$c.D = ((LinkedHashMap)paramMessage[0]);
      this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$c.ad = ((int[])paramMessage[1]);
      this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$c.k = ((String[])paramMessage[2]);
      QLog.d(".troop.troopManagerVASH", 2, new Object[] { "obj.length==3, refreshUI List count: ", Integer.valueOf(this.pr.size()) });
      if (this.pr.size() != 0)
      {
        bXf();
        bXi();
        if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$c == null) {
          break label302;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$c.notifyDataSetChanged();
        this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$c.bSJ();
      }
    }
    for (;;)
    {
      for (;;)
      {
        this.jdField_a_of_type_ComTencentWidgetPinnedDividerSwipListView.setVisibility(0);
        if ((!this.bbq) || (this.mFrom == 11)) {
          hg();
        }
        bXe();
        return;
        if ((paramMessage == null) || (paramMessage.length != 1)) {
          break;
        }
        try
        {
          this.pr.clear();
          this.pr.addAll((List)paramMessage[0]);
          QLog.d(".troop.troopManagerVASH", 2, new Object[] { "refreshUI List count: ", Integer.valueOf(this.pr.size()) });
          break;
        }
        finally {}
      }
      label302:
      this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$c = new c();
      this.jdField_a_of_type_ComTencentWidgetPinnedDividerSwipListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$c);
    }
  }
  
  public static void b(QQAppInterface paramQQAppInterface, long paramLong, jnm.d paramd)
  {
    oidb_cmd0x74f.ReqBody localReqBody = new oidb_cmd0x74f.ReqBody();
    localReqBody.uint64_group_code.set(paramLong);
    jnm.b(paramQQAppInterface, paramd, localReqBody.toByteArray(), "OidbSvc.0x74f_1", 1871, 1);
  }
  
  private void bSH()
  {
    this.W = new ReportDialog(this);
    this.W.setCanceledOnTouchOutside(true);
    this.W.requestWindowFeature(1);
    this.W.getWindow().setSoftInputMode(36);
    this.W.setContentView(2131563018);
    Object localObject = this.W.getWindow().getAttributes();
    ((WindowManager.LayoutParams)localObject).x = 0;
    ((WindowManager.LayoutParams)localObject).y = 0;
    ((WindowManager.LayoutParams)localObject).width = -1;
    ((WindowManager.LayoutParams)localObject).windowAnimations = 16973824;
    ((WindowManager.LayoutParams)localObject).gravity = 51;
    this.W.getWindow().setBackgroundDrawable(new ColorDrawable());
    localObject = (InputMethodManager)getSystemService("input_method");
    if ((ImmersiveUtils.isSupporImmersive() == 1) && (Build.VERSION.SDK_INT < 24))
    {
      this.W.getWindow().addFlags(67108864);
      int i = getResources().getColor(2131167361);
      new SystemBarCompact(this.W, true, i).init();
      View localView = this.W.findViewById(2131377546);
      localView.setFitsSystemWindows(true);
      localView.setPadding(0, ImmersiveUtils.getScreenHeight(), 0, 0);
    }
    this.o = ((XListView)this.W.findViewById(2131377779));
    this.o.setBackgroundDrawable(getResources().getDrawable(2130838900));
    this.o.setDividerHeight(0);
    this.mSearchResultList.clear();
    this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$e = new e(this.mSearchResultList);
    this.o.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$e);
    this.o.setOnTouchListener(new wbl(this, (InputMethodManager)localObject));
    this.ay = ((EditText)this.W.findViewById(2131366542));
    this.ay.addTextChangedListener(new g());
    this.root = this.W.findViewById(2131377546);
    this.ae = ((ImageButton)this.W.findViewById(2131368696));
    this.sq = this.W.findViewById(2131372437);
    this.ex = ((RelativeLayout)this.W.findViewById(2131377207));
    this.ae.setOnClickListener(new wbm(this));
    this.ex.setOnClickListener(new wbn(this));
  }
  
  private void bXd()
  {
    if (this.c == null)
    {
      ArrayList localArrayList = new ArrayList(this.cu.length);
      int i = 0;
      while (i < this.cu.length)
      {
        auuw.a locala = new auuw.a();
        locala.title = this.cu[i];
        locala.id = i;
        locala.contentDescription = this.cu[i];
        localArrayList.add(locala);
        i += 1;
      }
      this.c = auuw.a(this, localArrayList, new wbs(this), null, rpq.dip2px(this, 135.0F), false);
      this.c.setTouchInterceptor(new wcc(this));
      BP(this.BL);
    }
    this.c.showAsDropDown(this.rv, -(rpq.dip2px(this, 135.0F) - this.rv.getWidth()), 0);
  }
  
  private void bXf()
  {
    if (((this.aPX != null) && (this.aPX.contains(this.app.getCurrentAccountUin()))) || ((this.aPW != null) && (this.aPW.equals(this.app.getCurrentAccountUin())))) {}
    for (int i = 1;; i = 0)
    {
      if ((!this.aUo) && (i != 0) && ((this.mFrom == 0) || (this.mFrom == 17)) && (System.currentTimeMillis() > this.Ho)) {
        ThreadManager.post(new TroopMemberListActivity.20(this), 8, null, true);
      }
      return;
    }
  }
  
  private void bXg()
  {
    if (this.vy != null) {
      return;
    }
    this.vy = getLayoutInflater().inflate(2131563263, this.jdField_a_of_type_ComTencentWidgetPinnedDividerSwipListView, false);
    TextView localTextView = (TextView)this.vy.findViewById(2131369124);
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(NetConnInfoCenter.getServerTime() * 1000L);
    Iterator localIterator = this.range.iterator();
    Object localObject;
    while (localIterator.hasNext())
    {
      localObject = (oidb_cmd0x74f.Range)localIterator.next();
      this.pO.add(String.valueOf(((oidb_cmd0x74f.Range)localObject).uint32_days.get()));
      this.pN.add(((oidb_cmd0x74f.Range)localObject).string_name.get());
    }
    localIterator = this.pr.iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      localObject = (a)localIterator.next();
      if (((a)localObject).Hr == 0L) {
        ((a)localObject).Hr = ((a)localObject).Hq;
      }
      if (TextUtils.isEmpty(a(((a)localObject).Hr, localCalendar, this.pO, this.pN))) {
        break label353;
      }
      i += 1;
    }
    label353:
    for (;;)
    {
      break;
      localTextView.setText(i + "");
      if ((this.aPW != null) && (this.aPW.equals(this.app.getCurrentAccountUin()))) {}
      for (int j = 0;; j = 1)
      {
        this.vy.setOnClickListener(new wbk(this, i, j));
        bXh();
        this.jdField_a_of_type_ComTencentWidgetPinnedDividerSwipListView.addHeaderView(this.vy);
        anot.a(this.app, "dc00899", "Grp_mber", "", "mber_list", "exp_inacmem", 0, 0, this.mTroopUin, "" + j, "", "");
        return;
      }
    }
  }
  
  private void bXh()
  {
    Object localObject;
    DisplayMetrics localDisplayMetrics;
    if ((this.vy != null) && (this.jdField_b_of_type_ComTencentMobileqqWidgetIndexView != null))
    {
      localObject = this.vy.findViewById(2131377283);
      if ((localObject != null) && ((((View)localObject).getLayoutParams() instanceof ViewGroup.MarginLayoutParams)))
      {
        localObject = (ViewGroup.MarginLayoutParams)((View)localObject).getLayoutParams();
        if (localObject != null)
        {
          localDisplayMetrics = getResources().getDisplayMetrics();
          if (this.jdField_b_of_type_ComTencentMobileqqWidgetIndexView.getVisibility() != 0) {
            break label83;
          }
          ((ViewGroup.MarginLayoutParams)localObject).rightMargin = ((int)(localDisplayMetrics.density * 26.0F));
        }
      }
    }
    return;
    label83:
    ((ViewGroup.MarginLayoutParams)localObject).rightMargin = ((int)(localDisplayMetrics.density * 18.0F));
  }
  
  private void bXj()
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$c.ru.size();
    if (i > 0)
    {
      String str = MessageFormat.format(acfp.m(2131715985), new Object[] { Integer.valueOf(i) });
      this.Gk.setEnabled(true);
      this.Gk.setText(str);
      this.Gk.setOnClickListener(new wbr(this));
      return;
    }
    this.Gk.setEnabled(false);
    this.Gk.setText(acfp.m(2131716011));
  }
  
  public static Intent c(Context paramContext, String paramString, int paramInt)
  {
    paramContext = new Intent(paramContext, TroopMemberListActivity.class);
    paramContext.putExtra("troop_uin", paramString);
    paramContext.putExtra("param_from", paramInt);
    return paramContext;
  }
  
  private void gd(List<Long> paramList)
  {
    if (paramList.size() < 1) {
      return;
    }
    ReportDialog localReportDialog = new ReportDialog(this, 2131756467);
    localReportDialog.setContentView(2131559304);
    ((TextView)localReportDialog.findViewById(2131365867)).setText(getString(2131692538));
    TextView localTextView = (TextView)localReportDialog.findViewById(2131365863);
    CheckBox localCheckBox = (CheckBox)localReportDialog.findViewById(2131364575);
    Object localObject;
    if ((localTextView.getLayoutParams() instanceof RelativeLayout.LayoutParams))
    {
      localObject = (RelativeLayout.LayoutParams)localTextView.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).addRule(14);
      localTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    if ((localCheckBox.getLayoutParams() instanceof RelativeLayout.LayoutParams))
    {
      localObject = (RelativeLayout.LayoutParams)localCheckBox.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).addRule(14);
      localCheckBox.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    boolean bool;
    if ((!this.bap) && (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.allowMemberKick == 1))
    {
      bool = true;
      if (paramList.size() != 1) {
        break label291;
      }
      localTextView.setText(getString(2131695182));
      localCheckBox.setText(getString(2131718684));
    }
    for (;;)
    {
      if (bool) {
        localCheckBox.setVisibility(8);
      }
      localTextView = (TextView)localReportDialog.findViewById(2131365852);
      localObject = (TextView)localReportDialog.findViewById(2131365858);
      localTextView.setText(17039360);
      ((TextView)localObject).setText(17039370);
      localTextView.setOnClickListener(new wbz(this, localReportDialog));
      ((TextView)localObject).setOnClickListener(new wca(this, paramList, localCheckBox, bool, localReportDialog));
      localReportDialog.show();
      return;
      bool = false;
      break;
      label291:
      localTextView.setText(getString(2131696120));
      localCheckBox.setText(getString(2131696122));
    }
  }
  
  private void hf()
  {
    this.hj.setVisibility(8);
    am(0, this.bLQ, 0);
    this.mHandler.sendEmptyMessageDelayed(14, 800L);
  }
  
  private int vF()
  {
    int i = 1;
    switch (this.mFrom)
    {
    }
    for (;;)
    {
      if (this.bbt) {
        i = 3;
      }
      return i;
      i = 2;
    }
  }
  
  public void O(String paramString)
  {
    if ("$".equals(paramString)) {
      this.jdField_a_of_type_ComTencentWidgetPinnedDividerSwipListView.setSelection(0);
    }
    int i;
    do
    {
      return;
      i = this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$c.m(paramString);
    } while (i == -1);
    this.jdField_a_of_type_ComTencentWidgetPinnedDividerSwipListView.setSelection(i + this.jdField_a_of_type_ComTencentWidgetPinnedDividerSwipListView.getHeaderViewsCount());
  }
  
  public void Qq()
  {
    String[] arrayOfString;
    int i;
    label55:
    int j;
    if (this.mFrom == 9)
    {
      arrayOfString = getResources().getStringArray(2130969888);
      if ((this.mFrom != 0) && (this.mFrom != 17) && (this.mFrom != 22)) {
        break label165;
      }
      if (!this.bap) {
        break label113;
      }
      i = arrayOfString.length;
      this.mActionSheet = ausj.b(this);
      j = 0;
      label65:
      if (j >= i) {
        break label203;
      }
      if (!this.aUo) {
        break label267;
      }
      if (!acfp.m(2131715949).equals(arrayOfString[j])) {
        break label188;
      }
    }
    label267:
    for (;;)
    {
      j += 1;
      break label65;
      arrayOfString = getResources().getStringArray(2130969886);
      break;
      label113:
      if ((this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo != null) && (this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo.mMemberInvitingFlag))
      {
        if (this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo.cGroupOption != 3)
        {
          i = arrayOfString.length - 1;
          break label55;
        }
        i = arrayOfString.length - 2;
        break label55;
      }
      i = arrayOfString.length - 2;
      break label55;
      label165:
      if (this.mFrom == 9)
      {
        i = arrayOfString.length;
        break label55;
      }
      i = arrayOfString.length - 5;
      break label55;
      label188:
      if (j == 2)
      {
        this.mActionSheet.addButton(arrayOfString[j]);
        label203:
        if ((!this.bap) && (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.allowMemberKick == 1) && (arrayOfString.length >= 3)) {
          this.mActionSheet.addButton(arrayOfString[3], 3);
        }
        this.mActionSheet.addCancelButton(2131721058);
        this.mActionSheet.a(this.h);
        this.mActionSheet.show();
        return;
        if (j == 3)
        {
          this.mActionSheet.addButton(arrayOfString[j], 3);
        }
        else
        {
          this.mActionSheet.addButton(arrayOfString[j]);
          if (arrayOfString[j].equals(acfp.m(2131715909))) {
            anot.a(this.app, "dc00899", "Grp_mber", "", "mber_list", "exp_Add", 0, 0, this.mTroopUin, "", "", "");
          }
        }
      }
    }
  }
  
  public a a(DiscussionMemberInfo paramDiscussionMemberInfo, acff paramacff)
  {
    a locala = new a();
    locala.uin = paramDiscussionMemberInfo.memberUin.trim();
    Friends localFriends = null;
    if (paramacff != null) {
      localFriends = paramacff.b(paramDiscussionMemberInfo.memberUin);
    }
    locala.displayName = paramDiscussionMemberInfo.getDiscussionMemberName();
    locala.faceid = 0;
    locala.pinyinFirst = ChnToSpell.aJ(locala.displayName, 2);
    locala.vW(ChnToSpell.aJ(locala.displayName, 1));
    if ((localFriends != null) && (localFriends.isFriend()) && (localFriends.remark != null) && (localFriends.remark.length() > 0))
    {
      locala.wT(localFriends.remark);
      locala.wW(ChnToSpell.aJ(locala.remark, 1));
      locala.wU(ChnToSpell.aJ(locala.remark, 2));
    }
    for (;;)
    {
      if ((paramDiscussionMemberInfo.memberName != null) && (paramDiscussionMemberInfo.memberName.length() > 0))
      {
        locala.wX(paramDiscussionMemberInfo.memberName);
        locala.wZ(ChnToSpell.aJ(paramDiscussionMemberInfo.memberName, 1));
        locala.wY(ChnToSpell.aJ(paramDiscussionMemberInfo.memberName, 2));
      }
      if (this.jdField_a_of_type_Alud != null) {
        this.jdField_a_of_type_Alud.b(locala);
      }
      return locala;
      if ((paramDiscussionMemberInfo.inteRemark != null) && (paramDiscussionMemberInfo.inteRemark.length() > 0))
      {
        locala.wT(paramDiscussionMemberInfo.inteRemark);
        locala.wW(ChnToSpell.aJ(paramDiscussionMemberInfo.inteRemark, 1));
        locala.wU(ChnToSpell.aJ(paramDiscussionMemberInfo.inteRemark, 2));
      }
    }
  }
  
  public a a(TroopMemberInfo paramTroopMemberInfo, acff paramacff)
  {
    a locala = new a();
    locala.uin = paramTroopMemberInfo.memberuin.trim();
    Friends localFriends = null;
    if (paramacff != null) {
      localFriends = paramacff.b(paramTroopMemberInfo.memberuin);
    }
    locala.displayName = aqgv.c(this.app, this.mTroopUin, locala.uin, true);
    locala.faceid = paramTroopMemberInfo.faceid;
    locala.pinyinFirst = ChnToSpell.aJ(locala.displayName, 2);
    locala.vW(ChnToSpell.aJ(locala.displayName, 1));
    if ((paramTroopMemberInfo.friendnick != null) && (paramTroopMemberInfo.friendnick.length() > 0))
    {
      locala.wQ(paramTroopMemberInfo.friendnick);
      locala.wS(paramTroopMemberInfo.pyAll_friendnick);
      locala.wR(paramTroopMemberInfo.pyFirst_friendnick);
    }
    double d1;
    if ((localFriends != null) && (localFriends.isFriend()) && (localFriends.remark != null) && (localFriends.remark.length() > 0))
    {
      locala.wT(localFriends.remark);
      locala.wW(ChnToSpell.aJ(locala.remark, 1));
      locala.wU(ChnToSpell.aJ(locala.remark, 2));
      locala.wV(localFriends.remark);
      if ((paramTroopMemberInfo.troopColorNick != null) && (paramTroopMemberInfo.troopColorNick.length() > 0))
      {
        locala.wX(paramTroopMemberInfo.troopColorNick);
        locala.wZ(paramTroopMemberInfo.pyAll_troopnick);
        locala.wY(paramTroopMemberInfo.pyFirst_troopnick);
      }
      locala.Hr = paramTroopMemberInfo.last_active_time;
      locala.Hq = paramTroopMemberInfo.join_time;
      locala.level = paramTroopMemberInfo.level;
      locala.realLevel = paramTroopMemberInfo.realLevel;
      locala.Ht = paramTroopMemberInfo.credit_level;
      locala.isTroopFollowed = paramTroopMemberInfo.isTroopFollowed;
      locala.Hs = paramTroopMemberInfo.active_point;
      locala.mIsShielded = paramTroopMemberInfo.mIsShielded;
      locala.bLX = paramTroopMemberInfo.globalTroopLevel;
      d1 = ((TroopManager)this.app.getManager(52)).a(this.mTroopUin, locala.uin);
      if ((d1 == -1000.0D) || (d1 == -100.0D)) {
        break label704;
      }
      double d2 = d1 / 1000.0D;
      d1 = d2;
      if (d2 < 0.01D) {
        d1 = 0.01D;
      }
      if (d1 <= 10.0D) {
        break label669;
      }
      locala.aRr = ((int)d1 + "km");
    }
    for (;;)
    {
      if ((paramTroopMemberInfo.mUniqueTitleExpire - NetConnInfoCenter.getServerTime() > 0L) || (paramTroopMemberInfo.mUniqueTitleExpire == -1))
      {
        locala.mUniqueTitle = paramTroopMemberInfo.mUniqueTitle;
        locala.mUniqueTitleExpire = paramTroopMemberInfo.mUniqueTitleExpire;
      }
      if (this.jdField_a_of_type_Alud != null) {
        this.jdField_a_of_type_Alud.b(locala);
      }
      locala.mVipType = paramTroopMemberInfo.mVipType;
      locala.mVipLevel = paramTroopMemberInfo.mVipLevel;
      locala.mVipTemplateId = paramTroopMemberInfo.mBigClubTemplateId;
      locala.bLY = paramTroopMemberInfo.mBigClubVipType;
      locala.bLZ = paramTroopMemberInfo.mBigClubVipLevel;
      locala.mBigClubTemplateId = paramTroopMemberInfo.mBigClubTemplateId;
      locala.aRs = paramTroopMemberInfo.honorList;
      return locala;
      if ((paramTroopMemberInfo.autoremark == null) || (paramTroopMemberInfo.autoremark.length() <= 0)) {
        break;
      }
      if ((this.aUo) && (paramTroopMemberInfo.autoremark.equals(paramTroopMemberInfo.memberuin)))
      {
        locala.wT(TroopInfo.QIDIAN_TROOP_MEMBER_DEF_NICK);
        locala.wW(ChnToSpell.aJ(TroopInfo.QIDIAN_TROOP_MEMBER_DEF_NICK, 1));
        locala.wU(ChnToSpell.aJ(TroopInfo.QIDIAN_TROOP_MEMBER_DEF_NICK, 2));
        break;
      }
      locala.wT(paramTroopMemberInfo.autoremark);
      locala.wW(paramTroopMemberInfo.pyAll_autoremark);
      locala.wU(paramTroopMemberInfo.pyFirst_autoremark);
      break;
      label669:
      locala.aRr = (this.e.format(d1) + "km");
      continue;
      label704:
      locala.aRr = "";
    }
  }
  
  public a a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopMemberListActivityget_troop_member", 2, "removeItem:" + paramString);
    }
    int i = 0;
    for (;;)
    {
      try
      {
        if (i < this.pr.size())
        {
          a locala = (a)this.pr.get(i);
          if ((locala != null) && (locala.uin.equals(paramString)))
          {
            paramString = (a)this.pr.remove(i);
            return paramString;
          }
        }
        else
        {
          return null;
        }
      }
      finally {}
      i += 1;
    }
  }
  
  public h a(String paramString, boolean paramBoolean)
  {
    Object localObject1;
    int j;
    int i;
    if (paramBoolean)
    {
      localObject1 = this.o;
      j = ((ViewGroup)localObject1).getChildCount();
      i = 0;
    }
    for (;;)
    {
      if (i >= j) {
        break label134;
      }
      Object localObject2 = ((ViewGroup)localObject1).getChildAt(i);
      if ((((View)localObject2).getTag() != null) && ((((View)localObject2).getTag() instanceof h)))
      {
        localObject2 = (h)((View)localObject2).getTag();
        if ((((h)localObject2).uin != null) && (((h)localObject2).uin.equals(paramString)))
        {
          if (QLog.isColorLevel()) {
            QLog.d("TroopMemberListActivityget_troop_member", 2, "findListItemHolderByUin:" + i);
          }
          return localObject2;
          localObject1 = this.jdField_a_of_type_ComTencentWidgetPinnedDividerSwipListView;
          break;
        }
      }
      i += 1;
    }
    label134:
    return null;
  }
  
  public String a(long paramLong, Calendar paramCalendar, ArrayList<String> paramArrayList1, ArrayList<String> paramArrayList2)
  {
    if ((paramArrayList2.size() == 0) || (paramArrayList1.size() == 0)) {
      return null;
    }
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(1000L * paramLong);
    int j = paramCalendar.get(1);
    int k = localCalendar.get(1);
    int m = paramCalendar.get(6);
    int n = localCalendar.get(6);
    int i = paramArrayList2.size() - 1;
    while (i >= 0)
    {
      if ((j - k) * 365 + m - n >= Integer.parseInt((String)paramArrayList1.get(i))) {
        return (String)paramArrayList2.get(i);
      }
      i -= 1;
    }
    return null;
  }
  
  protected List<a> a(List<a> paramList, String paramString1, String paramString2)
  {
    int n = 1;
    int i1 = paramList.size();
    int k;
    int j;
    label79:
    int m;
    if (i1 > 0)
    {
      i = 0;
      if (i < i1)
      {
        a locala = (a)paramList.get(i);
        if ((paramString1 != null) && (paramString1.equals(locala.uin)))
        {
          paramList.remove(i);
          paramList.add(0, locala);
        }
      }
      else
      {
        k = 1;
        j = 1;
        i = j;
        m = n;
        if (k >= i1) {
          break label173;
        }
        paramString1 = (a)paramList.get(k);
        if ((!paramString2.contains(paramString1.uin)) || (paramString1.level != 332)) {
          break label459;
        }
        paramList.remove(k);
        paramList.add(j, paramString1);
      }
    }
    label173:
    label447:
    label450:
    label453:
    label456:
    label459:
    for (int i = j + 1;; i = j)
    {
      k += 1;
      j = i;
      break label79;
      i += 1;
      break;
      if (m < i1)
      {
        paramString1 = (a)paramList.get(m);
        if ((!paramString2.contains(paramString1.uin)) || (paramString1.level != 333)) {
          break label456;
        }
        paramList.remove(m);
        paramList.add(i, paramString1);
        i += 1;
      }
      for (;;)
      {
        m += 1;
        break;
        j = i;
        if (j < i1)
        {
          paramString1 = (a)paramList.get(j);
          if (paramString1.level != 332) {
            break label453;
          }
          paramList.remove(j);
          paramList.add(i, paramString1);
          i += 1;
        }
        for (;;)
        {
          j += 1;
          break;
          j = i;
          if (j < i1)
          {
            paramString1 = (a)paramList.get(j);
            if (paramString1.level != 333) {
              break label450;
            }
            paramList.remove(j);
            paramList.add(i, paramString1);
            i += 1;
          }
          for (;;)
          {
            j += 1;
            break;
            j = i;
            if (j < i1)
            {
              paramString1 = (a)paramList.get(j);
              if (!paramString2.contains(paramString1.uin)) {
                break label447;
              }
              paramList.remove(j);
              paramList.add(i, paramString1);
              i += 1;
            }
            for (;;)
            {
              j += 1;
              break;
              return paramList;
            }
          }
        }
      }
    }
  }
  
  public void a(a parama)
  {
    int i = 3;
    if ((parama != null) && (parama.bbC))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$c.rt.clear();
      parama = new Intent();
      parama.putExtra("result", new JSONArray().toString());
      setResult(-1, parama);
      anot.a(this.app, "P_CliOper", "Grp_work", "", "create", "Clk_none", 0, 0, this.mTroopUin, "", "", "");
      finish();
    }
    label94:
    label633:
    do
    {
      do
      {
        Object localObject2;
        do
        {
          break label94;
          do
          {
            return;
          } while ((parama == null) || (parama.uin == null));
          if (this.mFrom == 1)
          {
            if (this.app.getCurrentAccountUin().equals(parama.uin))
            {
              localObject1 = new ProfileActivity.AllInOne(parama.uin, 0);
              ((ProfileActivity.AllInOne)localObject1).nickname = aqgv.n(this.app, parama.uin);
              ((ProfileActivity.AllInOne)localObject1).bIZ = 3;
              ((ProfileActivity.AllInOne)localObject1).bJa = 4;
              ProfileActivity.b(this, (ProfileActivity.AllInOne)localObject1);
              return;
            }
            dz(parama.uin, parama.displayName);
            return;
          }
          if (this.mFrom == 2)
          {
            localObject1 = getIntent();
            ((Intent)localObject1).putExtra("troop_uin", this.mTroopUin);
            ((Intent)localObject1).putExtra("member_uin", parama.uin);
            localObject2 = new TroopAdmin();
            ((TroopAdmin)localObject2).uin = parama.uin;
            ((TroopAdmin)localObject2).faceid = parama.faceid;
            ((TroopAdmin)localObject2).name = parama.displayName;
            ((Intent)localObject1).putExtra("member_info", (Parcelable)localObject2);
            setResult(-1, (Intent)localObject1);
            finish();
            return;
          }
          if ((this.mFrom == 3) || (this.mFrom == 11) || (this.mFrom == 16))
          {
            localObject1 = getIntent();
            if (this.bbt)
            {
              ((Intent)localObject1).putExtra("member_display_name", parama.displayName);
              ((Intent)localObject1).putExtra("isApollo", true);
            }
            for (;;)
            {
              ((Intent)localObject1).putExtra("member_uin", parama.uin);
              ((Intent)localObject1).putExtra("troop_uin", this.mTroopUin);
              setResult(-1, (Intent)localObject1);
              finish();
              return;
              ((Intent)localObject1).putExtra("member_display_name", parama.displayName);
            }
          }
          if ((this.mFrom != 0) && (this.mFrom != 4) && (this.mFrom != 9) && (this.mFrom != 15) && (this.mFrom != 17) && (this.mFrom != 22)) {
            break;
          }
          wP(parama.uin);
        } while (this.mFrom != 22);
        aqfr.b("Grp_idol", "mber_list", "clk", 0, 0, new String[] { this.mTroopUin });
        return;
        if (this.mFrom == 5)
        {
          if ((this.aPW != null) && (this.aPW.equals(parama.uin)))
          {
            startActivityForResult(EditUniqueTitleActivity.a(this, 1, this.mTroopUin, parama.uin, i, parama.mUniqueTitle), 2);
            this.aRb = parama.uin;
            localObject1 = this.app;
            localObject2 = this.mTroopUin;
            i = this.BL;
            if (!this.bby) {
              break label633;
            }
          }
          for (parama = "1";; parama = "0")
          {
            anot.a((QQAppInterface)localObject1, "P_CliOper", "Grp_manage", "", "mber_title", "Clk_person_list", 0, 0, (String)localObject2, String.valueOf(i), parama, "");
            return;
            if ((this.aPX != null) && (this.aPX.contains(parama.uin)))
            {
              i = 2;
              break;
            }
            i = 1;
            break;
          }
        }
        if (this.mFrom == 14)
        {
          localObject1 = getIntent();
          ((Intent)localObject1).putExtra("member_uin", parama.uin);
          ((Intent)localObject1).putExtra("member_display_name", parama.displayName);
          ((Intent)localObject1).putExtra("troop_uin", this.mTroopUin);
          ((Intent)localObject1).putExtra("troop_gift_from", this.aQK);
          setResult(-1, (Intent)localObject1);
          finish();
          return;
        }
        if ((this.mFrom == 12) || (this.mFrom == 20))
        {
          if (this.bLK == 1)
          {
            this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$c.rt.clear();
            this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$c.rt.add(parama);
            parama = new Intent();
            localObject1 = new JSONArray();
            if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$c.rt != null)
            {
              localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$c.rt.iterator();
              for (;;)
              {
                if (((Iterator)localObject2).hasNext())
                {
                  a locala = (a)((Iterator)localObject2).next();
                  JSONObject localJSONObject = new JSONObject();
                  try
                  {
                    localJSONObject.put("uin", locala.uin);
                    localJSONObject.put("nick", locala.displayName);
                    ((JSONArray)localObject1).put(localJSONObject);
                  }
                  catch (Exception localException)
                  {
                    for (;;)
                    {
                      if (QLog.isColorLevel()) {
                        QLog.d("TroopMemberListActivityget_troop_member", 2, "json put error");
                      }
                    }
                  }
                }
              }
            }
            parama.putExtra("result", ((JSONArray)localObject1).toString());
            setResult(-1, parama);
            finish();
            return;
          }
          if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$c.rt.contains(parama)) {
            this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$c.rt.remove(parama);
          }
          for (;;)
          {
            this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$c.notifyDataSetChanged();
            return;
            if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$c.rt.size() < this.bLK)
            {
              this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$c.rt.add(parama);
            }
            else if (this.bLK == 1)
            {
              this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$c.rt.clear();
              this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$c.rt.add(parama);
            }
            else
            {
              QQToast.a(this, getResources().getString(this.bLM, new Object[] { Integer.valueOf(this.bLK) }), 0).show();
            }
          }
        }
        if ((this.mFrom != 18) && (this.mFrom != 19)) {
          break;
        }
        localObject1 = new Intent();
        ((Intent)localObject1).putExtra("troop_uin", this.mTroopUin);
        ((Intent)localObject1).putExtra("member_uin", parama.uin);
        PublicFragmentActivity.start(this, (Intent)localObject1, TroopMemberHistoryFragment.class);
      } while (this.mFrom != 19);
      parama = ((TroopManager)this.app.getManager(52)).b(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.app.getCurrentAccountUin());
      aqfr.b("Grp_edu", "teachermsg", "showsomeone", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, aqfr.c(parama) });
      return;
    } while (this.mFrom != 23);
    Object localObject1 = new Intent();
    ((Intent)localObject1).putExtra(TroopFileProxyActivity.cjr, this.mTroopUin);
    ((Intent)localObject1).putExtra("filter_member_name", parama.nickname);
    ((Intent)localObject1).putExtra("filter_uin", Long.valueOf(parama.uin));
    ((Intent)localObject1).putExtra("folderPath", "/");
    ((Intent)localObject1).putExtra("param_from", 6000);
    TroopFileProxyActivity.a(this, (Intent)localObject1, this.app.getCurrentAccountUin());
  }
  
  protected void a(h paramh, a parama, Bitmap paramBitmap, boolean paramBoolean1, boolean paramBoolean2)
  {
    String str;
    label84:
    Object localObject;
    label153:
    label364:
    int k;
    if (paramBoolean1)
    {
      str = this.aRa;
      paramh.bbE = paramBoolean1;
      paramh.b.setVisibility(0);
      paramh.Gn.setVisibility(8);
      paramh.Gm.setVisibility(8);
      paramh.pQ.setImageBitmap(paramBitmap);
      if ((this.BL != 1) && (this.BL != 5)) {
        break label867;
      }
      if (parama.isOnline) {
        break label854;
      }
      paramh.pQ.setAlpha(165);
      if ((this.aLZ) || (QQ()) || (parama.bLX == -100) || (parama.bLX == 0)) {
        break label889;
      }
      paramh.Gu.setVisibility(8);
      paramh.Gu.setText("LV" + parama.bLX);
      VipUtils.a(this.app, this, getResources(), paramh, parama);
      if ((this.mFrom != 13) || (!paramBoolean1)) {
        break label901;
      }
      paramBitmap = parama.displayName + "(" + parama.uin + ")";
      localObject = new SpannableString(paramBitmap);
      ((SpannableString)localObject).setSpan(new ForegroundColorSpan(-7829368), parama.displayName.length(), paramBitmap.length(), 18);
      paramh.fe.setText((CharSequence)localObject);
      label265:
      if ((paramBoolean2) && (paramh.lA != null))
      {
        paramBitmap = acfp.m(2131715905) + parama.remark;
        paramh.lA.setText(paramBitmap);
      }
      paramh.uin = parama.uin;
      paramh.type = 1;
      paramh.Gq.setText("");
      paramh.vA.setTag(Boolean.valueOf(paramBoolean1));
      if (this.mFrom != 9) {
        break label986;
      }
      paramh.Go.setVisibility(8);
      paramh.Gr.setOnClickListener(this.dv);
      paramh.uM.setOnClickListener(this.dv);
      paramh.b.setOnClickListener(this.cn);
      if ((!this.bbn) && (!this.bbo)) {
        break label1001;
      }
      paramh.vz.setOnClickListener(this.dv);
      paramh.vz.setClickable(true);
      if (this.bbo) {
        paramh.b.setOnClickListener(null);
      }
      label445:
      k = 0;
      if ((this.mFrom != 1) && (this.mFrom != 13)) {
        break label1131;
      }
      paramh.fe.setContentDescription(getString(2131692883) + paramh.fe.getText().toString());
      paramh.vA.setBackgroundResource(2130850669);
      if (this.mFrom != 13) {
        break label1048;
      }
      paramh.uM.setVisibility(0);
      label534:
      if (!str.equals(parama.uin)) {
        break label1120;
      }
      paramh.b.TR(false);
    }
    int i;
    int j;
    for (;;)
    {
      paramh.uM.setContentDescription(String.format(getString(2131692861), new Object[] { paramh.fe.getText().toString() }));
      paramh.Gr.setContentDescription(getString(2131692860));
      i = k;
      if (paramh.vB != null)
      {
        paramBitmap = (aptw)this.app.getManager(203);
        if ((paramBitmap == null) || (!paramBitmap.gM(parama.uin))) {
          break label2404;
        }
        j = 1;
        label647:
        if (j == 0) {
          break label2410;
        }
        paramh.vB.setVisibility(0);
      }
      label660:
      if (this.aUo) {
        paramh.Gu.setVisibility(8);
      }
      paramBitmap = new StringBuffer();
      paramBitmap.append(paramh.fe.getText().toString());
      if ((paramBoolean2) && (paramh.lA != null)) {
        paramBitmap.append(paramh.lA.getText());
      }
      if (paramh.Go.getVisibility() == 0) {
        paramBitmap.append(paramh.Go.getText().toString());
      }
      if (paramh.Gu.getVisibility() == 0) {
        paramBitmap.append(paramh.Gu.getText().toString());
      }
      if (paramh.a.getVisibility() == 0) {
        paramBitmap.append(paramh.a.Bt());
      }
      if ((paramh.uM.getVisibility() == 0) && (this.bbo))
      {
        if (i == 0) {
          break label2422;
        }
        parama = "已选中";
        label827:
        paramBitmap.append(parama);
      }
      paramh.vz.setContentDescription(paramBitmap.toString());
      return;
      str = this.aQZ;
      break;
      label854:
      paramh.pQ.setAlpha(255);
      break label84;
      label867:
      paramh.pQ.setAlpha(255);
      paramh.Gu.setVisibility(8);
      break label84;
      label889:
      paramh.Gu.setVisibility(8);
      break label153;
      label901:
      if (paramBoolean2)
      {
        paramBitmap = new aofe(parama.nickname, 16).k();
        paramh.fe.setText(paramBitmap);
        aqpm.a(this.app, paramh.fe, paramBitmap);
        break label265;
      }
      paramBitmap = new aofe(parama.displayName, 16).k();
      paramh.fe.setText(paramBitmap);
      aqpm.a(this.app, paramh.fe, paramBitmap);
      break label265;
      label986:
      paramh.Go.setTag(Boolean.valueOf(paramBoolean1));
      break label364;
      label1001:
      if (this.mFrom == 21)
      {
        paramh.vz.setOnClickListener(null);
        paramh.vz.setClickable(false);
        break label445;
      }
      paramh.vz.setOnClickListener(null);
      paramh.vz.setClickable(false);
      break label445;
      label1048:
      if (this.mFrom == 21)
      {
        paramh.uM.setVisibility(0);
        break label534;
      }
      if ((this.aPW != null) && (!parama.uin.equals(this.aPW)))
      {
        paramh.uM.setVisibility(0);
        break label534;
      }
      paramh.uM.setVisibility(8);
      paramh.b.TS(false);
      break label534;
      label1120:
      paramh.b.TS(false);
    }
    label1131:
    paramh.Go.setText("");
    boolean bool1;
    label1153:
    label1177:
    boolean bool2;
    label1208:
    boolean bool3;
    boolean bool4;
    if (!TextUtils.isEmpty(parama.mUniqueTitle))
    {
      bool1 = true;
      if ((parama.uin == null) || (!parama.uin.equals(this.aPW))) {
        break label1458;
      }
      paramBoolean1 = true;
      if ((this.aPX == null) || (parama.uin == null) || (!this.aPX.contains(parama.uin))) {
        break label1464;
      }
      bool2 = true;
      bool3 = this.app.getCurrentAccountUin().equals(this.aPW);
      bool4 = this.app.getCurrentAccountUin().equals(parama.uin);
      if (this.mFrom != 5) {
        break label1589;
      }
      paramh.Gs.setVisibility(0);
      paramh.Go.setVisibility(8);
      paramh.a.setVisibility(8);
      paramh.Gt.setVisibility(0);
      localObject = "";
      j = 0;
      if ((!bool1) || (anlm.ayn())) {
        break label1470;
      }
      paramBitmap = apdg.a().a(302, bool1, paramBoolean1, bool2);
      if (paramBitmap == null) {
        break label2429;
      }
      i = paramBitmap.bgColor;
      paramBitmap = parama.mUniqueTitle;
    }
    for (;;)
    {
      label1331:
      if (!TextUtils.isEmpty(paramBitmap))
      {
        paramh.Gs.setText(paramBitmap);
        apdg.i(paramh.Gs, i);
        label1355:
        paramBitmap = (aptw)this.app.getManager(203);
        if ((paramBitmap == null) || (!paramBitmap.gM(parama.uin))) {
          break label2119;
        }
        i = 1;
      }
      for (;;)
      {
        if (this.bbn)
        {
          if ((this.mFrom != 21) && ((paramBoolean1) || ((!bool3) && (bool2)) || ((!bool3) && (i != 0))))
          {
            paramh.uM.setVisibility(8);
            paramh.b.TS(false);
            i = k;
            break;
            bool1 = false;
            break label1153;
            label1458:
            paramBoolean1 = false;
            break label1177;
            label1464:
            bool2 = false;
            break label1208;
            label1470:
            if (paramBoolean1)
            {
              locala = apdg.a().a(300, bool1, paramBoolean1, bool2);
              i = j;
              paramBitmap = (Bitmap)localObject;
              if (locala == null) {
                break label1331;
              }
              i = locala.bgColor;
              paramBitmap = locala.title;
              break label1331;
            }
            i = j;
            paramBitmap = (Bitmap)localObject;
            if (!bool2) {
              break label1331;
            }
            apdg.a locala = apdg.a().a(301, bool1, paramBoolean1, bool2);
            i = j;
            paramBitmap = (Bitmap)localObject;
            if (locala == null) {
              break label1331;
            }
            i = locala.bgColor;
            paramBitmap = locala.title;
            break label1331;
            paramh.Gs.setVisibility(8);
            break label1355;
            label1589:
            paramBitmap = "";
            j = 0;
            bool1 = false;
            if (this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo != null) {
              bool1 = this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo.isQidianPrivateTroop();
            }
            if ((!bool1) && (!this.aLZ)) {}
            localObject = apdg.a().a(paramBoolean1, bool2);
            if (localObject != null)
            {
              paramBitmap = ((apdg.a)localObject).title;
              j = ((apdg.a)localObject).bgColor;
            }
            if (this.mFrom == 11) {
              paramBitmap = "";
            }
            i = 1;
            if (this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo != null)
            {
              if (1 == this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo.cGroupRankUserFlag) {
                i = 1;
              }
            }
            else
            {
              label1692:
              if (((!anlm.ayn()) && (i != 0)) || (!paramBoolean1)) {
                break label1990;
              }
              localObject = String.format(getString(2131689555), new Object[0]);
              label1724:
              if (((anlm.ayn()) || (i == 0)) && (!paramBoolean1) && ((TextUtils.isEmpty((CharSequence)localObject)) || (QQ()))) {
                break label2031;
              }
              paramh.Go.setVisibility(0);
              paramh.Go.setText((CharSequence)localObject);
              apdg.i(paramh.Go, j);
              label1781:
              paramBitmap = (apmb)this.app.getManager(346);
              if (!paramBitmap.qD(this.mTroopUin)) {
                break label2063;
              }
              paramBitmap = paramBitmap.aX(parama.aRs);
              if ((paramBitmap == null) || (paramBitmap.size() <= 0)) {
                break label2043;
              }
              paramh.a.setHonorList(paramBitmap);
              paramh.a.setVisibility(0);
              label1844:
              if (this.aLZ)
              {
                paramBitmap = apdg.a().a(parama.level, false, false, false);
                if ((paramBitmap == null) || (!apqz.mf(parama.level))) {
                  break label2095;
                }
                if ((TextUtils.isEmpty(paramBitmap.title)) || (anlm.ayn())) {
                  break label2083;
                }
                paramh.Gp.setVisibility(0);
                paramh.Gp.setText(paramBitmap.title);
                apdg.i(paramh.Gp, paramBitmap.bgColor);
              }
            }
            for (;;)
            {
              if ((this.mFrom == 9) || (this.mFrom == 12)) {
                break label2105;
              }
              if ((parama.uin == null) || (!parama.uin.equals(this.app.getCurrentAccountUin()))) {
                break label2107;
              }
              paramh.Gq.setText(getString(2131696176));
              break;
              i = 0;
              break label1692;
              label1990:
              if (!anlm.ayn())
              {
                localObject = paramBitmap;
                if (i != 0) {
                  break label1724;
                }
              }
              localObject = paramBitmap;
              if (!bool2) {
                break label1724;
              }
              localObject = String.format(getString(2131689554), new Object[0]);
              break label1724;
              label2031:
              paramh.Go.setVisibility(8);
              break label1781;
              label2043:
              paramh.a.setHonorList(null);
              paramh.a.setVisibility(8);
              break label1844;
              label2063:
              paramh.a.setHonorList(null);
              paramh.a.setVisibility(8);
              break label1844;
              label2083:
              paramh.Gp.setVisibility(8);
              continue;
              label2095:
              paramh.Gp.setVisibility(8);
            }
            label2105:
            break label1355;
            label2107:
            paramh.Gq.setText("");
            break label1355;
            label2119:
            i = 0;
            continue;
          }
          paramh.uM.setVisibility(0);
          paramh.vA.setBackgroundResource(2130850669);
          if (str.equals(parama.uin))
          {
            paramh.b.TR(false);
            i = k;
            break;
          }
          paramh.b.TS(false);
          i = k;
          break;
        }
      }
      if (this.bbo)
      {
        if ((paramBoolean1) || ((!bool3) && (bool2)) || (bool4))
        {
          i = 1;
          label2215:
          if (i == 0) {
            break label2241;
          }
          paramh.uM.setVisibility(8);
          i = 0;
        }
        for (;;)
        {
          break;
          i = 0;
          break label2215;
          label2241:
          paramh.uM.setVisibility(0);
          if ((parama.uin != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$c.ru.contains(parama.uin)))
          {
            paramh.vA.setBackgroundResource(2130841267);
            i = 1;
          }
          else
          {
            paramh.vA.setBackgroundResource(2130841263);
            i = 0;
          }
        }
      }
      if (this.mFrom == 20)
      {
        paramh.uM.setVisibility(0);
        if ((parama.uin != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$c.rt.contains(parama)))
        {
          paramh.vA.setBackgroundResource(2130841267);
          i = 1;
          break;
        }
        paramh.vA.setBackgroundResource(2130841263);
        i = k;
        break;
      }
      paramh.uM.setVisibility(8);
      paramh.b.TS(false);
      i = k;
      break;
      label2404:
      j = 0;
      break label647;
      label2410:
      paramh.vB.setVisibility(8);
      break label660;
      label2422:
      parama = "未选中";
      break label827;
      label2429:
      i = 0;
      paramBitmap = "";
    }
  }
  
  protected Object[] a(String paramString)
  {
    int i = 0;
    long l1;
    Object localObject;
    long l2;
    int j;
    try
    {
      this.pr.clear();
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("TroopMemberListActivityget_troop_member", 2, "getDiscussionMemberFromDB, uin:" + paramString);
        }
        l1 = System.currentTimeMillis();
        localObject = (acff)this.app.getManager(51);
        this.rn = ((acdu)this.app.getManager(53)).z(paramString);
        l2 = System.currentTimeMillis();
        if (QLog.isColorLevel()) {
          QLog.d("TroopMemberListActivityget_troop_member", 2, "getDiscussionMemberFromDB, queryTime:" + (l2 - l1));
        }
        if (this.rn == null) {
          break label557;
        }
        j = this.rn.size();
        if (i < j)
        {
          paramString = (DiscussionMemberInfo)this.rn.get(i);
          if (paramString == null) {
            break label562;
          }
          if ((paramString.memberUin != null) && (paramString.memberUin.trim().length() > 0) && (!paramString.memberUin.trim().equalsIgnoreCase("0")))
          {
            if (((this.mFrom == 2) && (paramString.memberUin.equals(this.aPW))) || ((this.mFrom == 1) && (this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo != null) && (paramString.memberUin.equals(this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo.inheritOwnerUin)))) {
              break label562;
            }
            paramString = a(paramString, (acff)localObject);
            this.pr.add(paramString);
          }
        }
      }
      catch (Exception paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.d("TroopMemberListActivityget_troop_member", 2, "getDiscussionMemberFromDB:" + paramString.toString());
        }
        paramString = null;
        return paramString;
        if (!QLog.isColorLevel()) {
          break label562;
        }
        QLog.d("TroopMemberListActivityget_troop_member", 2, "getDiscussionMemberFromDB, continued:" + paramString.memberUin);
      }
      catch (OutOfMemoryError paramString)
      {
        for (;;)
        {
          label321:
          if (QLog.isColorLevel()) {
            QLog.d("TroopMemberListActivityget_troop_member", 2, "getDiscussionMemberFromDB:" + paramString.toString());
          }
        }
      }
      if (this.app.a() == null) {
        break label569;
      }
    }
    finally {}
    this.app.a().notifyRefreshTroopMember();
    for (;;)
    {
      l2 = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d("TroopMemberListActivityget_troop_member", 2, "getDiscussionMemberFromDB, TotalTime:" + (l2 - l1) + ", listSize:" + this.pr.size() + ", dbSize:" + i);
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$c.c();
      if ((localObject != null) && (localObject.length == 3))
      {
        paramString = new Object[3];
        paramString[0] = localObject[0];
        paramString[1] = localObject[1];
        paramString[2] = localObject[2];
        break label321;
      }
      paramString = null;
      break label321;
      label557:
      i = 0;
      continue;
      label562:
      i += 1;
      break;
      label569:
      i = j;
    }
  }
  
  /* Error */
  public Object[] a(String paramString, List<String> paramList)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 1187	java/lang/System:currentTimeMillis	()J
    //   5: lstore_3
    //   6: new 240	java/util/ArrayList
    //   9: dup
    //   10: invokespecial 241	java/util/ArrayList:<init>	()V
    //   13: astore 5
    //   15: aload_0
    //   16: getfield 464	com/tencent/mobileqq/activity/TroopMemberListActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   19: bipush 51
    //   21: invokevirtual 470	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   24: checkcast 472	acff
    //   27: astore 6
    //   29: aload_0
    //   30: getfield 464	com/tencent/mobileqq/activity/TroopMemberListActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   33: invokevirtual 2172	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/data/QQEntityManagerFactory;
    //   36: invokevirtual 2178	com/tencent/mobileqq/data/QQEntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   39: astore 7
    //   41: aload_2
    //   42: invokeinterface 1231 1 0
    //   47: astore_2
    //   48: aload_2
    //   49: invokeinterface 1236 1 0
    //   54: ifeq +85 -> 139
    //   57: aload 7
    //   59: ldc_w 485
    //   62: iconst_0
    //   63: ldc_w 2180
    //   66: iconst_2
    //   67: anewarray 496	java/lang/String
    //   70: dup
    //   71: iconst_0
    //   72: aload_1
    //   73: aastore
    //   74: dup
    //   75: iconst_1
    //   76: aload_2
    //   77: invokeinterface 1239 1 0
    //   82: checkcast 496	java/lang/String
    //   85: aastore
    //   86: aconst_null
    //   87: aconst_null
    //   88: aconst_null
    //   89: aconst_null
    //   90: invokevirtual 2186	com/tencent/mobileqq/persistence/EntityManager:query	(Ljava/lang/Class;ZLjava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;
    //   93: astore 8
    //   95: aload 8
    //   97: ifnull -49 -> 48
    //   100: aload 8
    //   102: invokeinterface 479 1 0
    //   107: ifle -59 -> 48
    //   110: aload 5
    //   112: aload_0
    //   113: aload 8
    //   115: iconst_0
    //   116: invokeinterface 483 2 0
    //   121: checkcast 485	com/tencent/mobileqq/data/TroopMemberInfo
    //   124: aload 6
    //   126: invokevirtual 514	com/tencent/mobileqq/activity/TroopMemberListActivity:a	(Lcom/tencent/mobileqq/data/TroopMemberInfo;Lacff;)Lcom/tencent/mobileqq/activity/TroopMemberListActivity$a;
    //   129: invokeinterface 517 2 0
    //   134: pop
    //   135: goto -87 -> 48
    //   138: astore_1
    //   139: invokestatic 439	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   142: ifeq +34 -> 176
    //   145: ldc_w 441
    //   148: iconst_2
    //   149: new 443	java/lang/StringBuilder
    //   152: dup
    //   153: invokespecial 444	java/lang/StringBuilder:<init>	()V
    //   156: ldc_w 2188
    //   159: invokevirtual 450	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: invokestatic 1187	java/lang/System:currentTimeMillis	()J
    //   165: lload_3
    //   166: lsub
    //   167: invokevirtual 2133	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   170: invokevirtual 457	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   173: invokestatic 460	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   176: aload_0
    //   177: monitorexit
    //   178: iconst_1
    //   179: anewarray 859	java/lang/Object
    //   182: dup
    //   183: iconst_0
    //   184: aload 5
    //   186: aastore
    //   187: areturn
    //   188: astore_1
    //   189: aload_0
    //   190: monitorexit
    //   191: aload_1
    //   192: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	193	0	this	TroopMemberListActivity
    //   0	193	1	paramString	String
    //   0	193	2	paramList	List<String>
    //   5	161	3	l	long
    //   13	172	5	localArrayList	ArrayList
    //   27	98	6	localacff	acff
    //   39	19	7	localEntityManager	com.tencent.mobileqq.persistence.EntityManager
    //   93	21	8	localList	List
    // Exception table:
    //   from	to	target	type
    //   29	48	138	java/lang/Exception
    //   48	95	138	java/lang/Exception
    //   100	135	138	java/lang/Exception
    //   2	29	188	finally
    //   29	48	188	finally
    //   48	95	188	finally
    //   100	135	188	finally
    //   139	176	188	finally
  }
  
  protected void aC()
  {
    if (this.mFrom == 1)
    {
      this.mTitle.setText(getString(2131692878));
      this.Bi.setVisibility(4);
      this.Gk.setText(getString(2131721066));
      this.Gk.setVisibility(0);
      this.Gk.setContentDescription(getString(2131692882));
      this.Gk.setOnClickListener(this.dx);
      if (this.rv.getVisibility() != 0) {
        break label1221;
      }
      this.kn.setVisibility(0);
      if ((this.BL >= 0) && (this.BL < this.cv.length)) {
        this.kn.setText(this.cv[this.BL]);
      }
    }
    for (;;)
    {
      if (this.BL == 8)
      {
        this.kn.setVisibility(0);
        this.kn.setText(acfp.m(2131715923));
      }
      if (this.mFrom == 14) {
        this.kn.setVisibility(8);
      }
      this.mTitleLayout.setFocusable(true);
      this.mTitleLayout.setContentDescription(this.mTitle.getText().toString() + this.kn.getText().toString());
      return;
      if (this.mFrom == 2)
      {
        this.mTitle.setText(getString(2131689852));
        this.Gk.setVisibility(8);
        this.ru.setVisibility(8);
        this.ru.setImageResource(2130840663);
        this.rv.setVisibility(0);
        this.Bi.setOnClickListener(new wci(this));
        break;
      }
      if (this.mFrom == 3)
      {
        this.mTitle.setText(getString(2131698722));
        this.Bi.setText(2131721058);
        this.Gk.setVisibility(8);
        this.ru.setVisibility(8);
        this.ru.setImageResource(2130840663);
        this.rv.setVisibility(0);
        this.Bi.setOnClickListener(new wcj(this));
        break;
      }
      if (this.mFrom == 11)
      {
        this.mTitle.setText(getString(2131698724));
        this.Bi.setText(2131721058);
        this.Gk.setVisibility(8);
        this.ru.setVisibility(8);
        this.rv.setVisibility(8);
        this.Bi.setOnClickListener(new wck(this));
        break;
      }
      if (this.mFrom == 5)
      {
        this.mTitle.setText(getString(2131698542));
        if (this.aQM == null) {
          this.aQM = getString(2131691039);
        }
        this.Bi.setOnClickListener(this.dx);
        this.ru.setVisibility(8);
        this.rv.setVisibility(0);
        this.ru.setImageResource(2130840663);
        break;
      }
      if ((this.mFrom == 14) || (this.mFrom == 16))
      {
        if ((this.aQO != null) && (!TextUtils.isEmpty(this.aQO))) {
          this.mTitle.setText(this.aQO);
        }
        this.Bi.setVisibility(8);
        this.ru.setVisibility(8);
        this.rv.setVisibility(8);
        this.Gk.setText(2131699499);
        this.Gk.setVisibility(0);
        this.Gk.setOnClickListener(this.dx);
        break;
      }
      if (this.mFrom == 15)
      {
        this.mTitle.setText(2131721424);
        this.Gk.setText(2131721064);
        this.Gk.setVisibility(0);
        this.Gk.setOnClickListener(this.dw);
        this.Bi.setOnClickListener(this.dx);
        this.ru.setVisibility(8);
        this.rv.setVisibility(8);
        break;
      }
      if ((this.mFrom == 12) || (this.mFrom == 20) || (this.mFrom == 21))
      {
        if (this.aQP != null) {
          this.mTitle.setText(this.aQP);
        }
        this.Bi.setOnClickListener(this.dx);
        this.ru.setVisibility(8);
        this.rv.setVisibility(8);
        if (this.bLK == 1)
        {
          this.Gk.setVisibility(8);
          break;
        }
        this.Gk.setText(getString(2131721066));
        this.Gk.setVisibility(0);
        this.Gk.setContentDescription(getString(2131692882));
        break;
      }
      if (this.mFrom == 18)
      {
        this.mTitle.setText(2131721317);
        this.Gk.setVisibility(8);
        this.Bi.setOnClickListener(this.dx);
        this.rv.setVisibility(8);
        this.ru.setVisibility(8);
        break;
      }
      if (this.mFrom == 19)
      {
        this.ru.setVisibility(8);
        this.rv.setVisibility(8);
        this.mTitle.setText(acfp.m(2131715914));
        this.Bi.setOnClickListener(new wcl(this));
        break;
      }
      if (this.mFrom == 23)
      {
        this.mTitle.setText(2131721317);
        this.Gk.setVisibility(8);
        this.Bi.setOnClickListener(this.dx);
        this.rv.setVisibility(8);
        this.ru.setVisibility(8);
        break;
      }
      this.mTitle.setText(acfp.m(2131715981));
      if ((this.aQO != null) && (!TextUtils.isEmpty(this.aQO))) {
        this.mTitle.setText(this.aQO);
      }
      if (this.aQM == null) {
        this.aQM = getString(2131691039);
      }
      this.Bi.setOnClickListener(this.dx);
      this.Gk.setVisibility(8);
      this.Gk.setText(2131721066);
      if (this.mFrom != 4)
      {
        this.ru.setVisibility(0);
        this.ru.setImageResource(2130840663);
        this.ru.setContentDescription(getString(2131699738));
        if (this.mFrom == 22) {
          break;
        }
        this.rv.setVisibility(0);
        break;
      }
      this.ru.setVisibility(8);
      this.rv.setVisibility(8);
      break;
      label1221:
      this.kn.setVisibility(8);
    }
  }
  
  protected void aDR()
  {
    this.mRootView = ((LinearLayout)findViewById(2131380352));
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      this.mRootView.setFitsSystemWindows(true);
    }
    this.mTitleBar = findViewById(2131379791);
    this.mTitle = ((TextView)findViewById(2131369627));
    this.kn = ((TextView)findViewById(2131369571));
    this.mTitleLayout = ((LinearLayout)findViewById(2131364395));
    this.Bi = ((TextView)findViewById(2131369579));
    if ((this.mFrom == 3) || (this.mFrom == 11))
    {
      this.Bi.setVisibility(8);
      this.Bi = ((TextView)findViewById(2131369581));
      this.Bi.setVisibility(0);
    }
    this.Gk = ((TextView)findViewById(2131369612));
    this.ru = ((ImageView)findViewById(2131369594));
    this.jdField_a_of_type_ComTencentWidgetPinnedDividerSwipListView = ((PinnedDividerSwipListView)findViewById(2131380348));
    this.jdField_b_of_type_ComTencentMobileqqWidgetIndexView = ((IndexView)findViewById(2131369142));
    this.mLoadingView = findViewById(2131377037);
    this.hj = ((RelativeLayout)findViewById(2131370576));
    this.hi = ((RelativeLayout)findViewById(2131370795));
    this.mProgressBar = ((ProgressBar)this.hi.findViewById(2131368614));
    this.Gl = ((TextView)this.hi.findViewById(2131370818));
    this.ru.setContentDescription(getString(2131699738));
    this.rv = ((ImageView)findViewById(2131369595));
    this.rv.setBackgroundResource(2130844665);
    this.rv.setContentDescription(getString(2131721316));
  }
  
  public void af(String paramString1, String paramString2, String paramString3)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.i("TroopMemberListActivityget_troop_member", 2, "doReport, actionName=" + paramString1 + " ext2=" + paramString2 + " ext3=" + paramString3 + " from=" + this.mFrom);
      }
      if (this.mFrom == 1) {
        return;
      }
      if (this.mFrom == 11) {
        return;
      }
      if (this.mFrom != 9) {
        break label179;
      }
      if (this.bLJ != 1) {
        break label172;
      }
      paramString2 = "suc_pay_list";
    }
    catch (Exception paramString1)
    {
      while (QLog.isColorLevel())
      {
        QLog.i("TroopMemberListActivityget_troop_member", 2, "doReport:" + paramString1.toString());
        return;
        label172:
        paramString2 = "un_pay_list";
      }
      label179:
      anot.a(this.app, "P_CliOper", "Grp_mber", "", "mber_list", paramString1, 0, 0, this.mTroopUin, paramString2, paramString3, "");
    }
    anot.a(this.app, "P_CliOper", "Grp_pay", "", paramString2, paramString1, 0, 0, this.mTroopUin, paramString3, "", "");
    return;
  }
  
  public void ayl()
  {
    if (this.mFrom == 11) {
      anot.a(this.app, "CliOper", "", "", "0X8006217", "0X8006217", 0, 0, "", "", "", "");
    }
    int i = this.mTitleBar.getHeight();
    Object localObject = new TranslateAnimation(0.0F, 0.0F, 0.0F, -i);
    ((TranslateAnimation)localObject).setDuration(300L);
    ((TranslateAnimation)localObject).setFillAfter(true);
    this.mRootView.startAnimation((Animation)localObject);
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, -i, 0.0F);
    localTranslateAnimation.setDuration(300L);
    ((TranslateAnimation)localObject).setAnimationListener(new wbt(this, (TranslateAnimation)localObject, localTranslateAnimation, i));
    this.W.setOnDismissListener(new wbu(this));
    this.ay.setText("");
    this.ay.setSelection(0);
    this.ay.requestFocus();
    localObject = (Button)this.W.findViewById(2131363801);
    ((Button)localObject).setVisibility(0);
    ((Button)localObject).setOnClickListener(new wbv(this));
    this.mSearchResultList.clear();
    this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$e.notifyDataSetChanged();
    this.aaC = true;
  }
  
  protected void bXe()
  {
    if ((this.mFrom == 2) || (this.mFrom == 3) || (this.mFrom == 11) || (this.mFrom == 0) || (this.mFrom == 17) || (this.mFrom == 5) || (this.mFrom == 9) || (this.mFrom == 22)) {
      if ((this.mFrom == 9) && (this.bLJ == 1))
      {
        this.ru.setVisibility(8);
        this.rv.setVisibility(8);
      }
    }
    for (;;)
    {
      return;
      this.ru.setOnClickListener(new wba(this));
      this.rv.setOnClickListener(new wbb(this));
      if ((this.mFrom == 0) || (this.mFrom == 9) || (this.mFrom == 17) || (this.mFrom == 22)) {
        this.Gk.setOnClickListener(new wbc(this));
      }
      while ((this.aUo) && (!this.bap) && ((this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo == null) || (!this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo.mMemberInvitingFlag) || (this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo.cGroupOption == 3)))
      {
        this.ru.setVisibility(8);
        return;
        if (this.mFrom == 7)
        {
          this.ru.setVisibility(8);
          this.rv.setVisibility(8);
        }
        else if ((this.mFrom == 12) || (this.mFrom == 20))
        {
          this.Gk.setOnClickListener(new wbd(this));
        }
        else if (this.mFrom == 21)
        {
          this.Gk.setOnClickListener(new wbe(this));
        }
        else if (this.mFrom == 22)
        {
          this.rv.setVisibility(8);
        }
      }
    }
  }
  
  public void bXi()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$c != null) && (QLog.isColorLevel())) {
      QLog.d("TroopMemberListActivityget_troop_member", 2, String.format("checkShowCharIndexView item: %s, other: %s, char: %s", new Object[] { Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$c.mItemCount), Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$c.bMe), Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$c.bMd) }));
    }
    int i = this.jdField_b_of_type_ComTencentMobileqqWidgetIndexView.getVisibility();
    if (this.BL == 0) {
      if (this.mFrom == 11) {
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$c != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$c.mItemCount > 6) && (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$c.bMd > 1)) {
          this.jdField_b_of_type_ComTencentMobileqqWidgetIndexView.setVisibility(0);
        }
      }
    }
    for (;;)
    {
      if (i != this.jdField_b_of_type_ComTencentMobileqqWidgetIndexView.getVisibility()) {
        bXh();
      }
      return;
      if (this.mFrom == 0)
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$c != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$c.mItemCount + this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$c.bMe >= this.bLO) && (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$c.bMd > 1)) {
          this.jdField_b_of_type_ComTencentMobileqqWidgetIndexView.setVisibility(0);
        } else {
          this.jdField_b_of_type_ComTencentMobileqqWidgetIndexView.setVisibility(4);
        }
      }
      else if ((this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$c != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$c.mItemCount >= this.bLO) && (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$c.bMd > 1))
      {
        this.jdField_b_of_type_ComTencentMobileqqWidgetIndexView.setVisibility(0);
      }
      else
      {
        this.jdField_b_of_type_ComTencentMobileqqWidgetIndexView.setVisibility(4);
        continue;
        this.jdField_b_of_type_ComTencentMobileqqWidgetIndexView.setVisibility(4);
      }
    }
  }
  
  public void bXk()
  {
    boolean bool = true;
    Dialog localDialog;
    if (this.G == null)
    {
      this.G = new ReportDialog(this, 2131756467);
      this.G.setContentView(2131558460);
      localDialog = this.G;
      if (this.mFrom == 1) {
        break label76;
      }
    }
    for (;;)
    {
      localDialog.setCancelable(bool);
      ((TextView)this.G.findViewById(2131365863)).setText(getString(2131719519));
      return;
      label76:
      bool = false;
    }
  }
  
  public void bXl()
  {
    Intent localIntent = new Intent(this, PublicAccountBrowser.class);
    String str = "https://web.qun.qq.com/statistics/index.html?_bid=149&_wv=3&gc=" + this.mTroopUin;
    localIntent.putExtra("url", str);
    startActivity(localIntent);
    if (QLog.isColorLevel()) {
      QLog.d("TroopMemberListActivityget_troop_member", 2, "showMemberDstribute:" + str);
    }
    af("Clk_mberdist", this.aQS, "");
  }
  
  protected void bXm()
  {
    ThreadManager.post(new TroopMemberListActivity.44(this), 8, null, true);
    af("Clk_invite", this.aQS, "");
  }
  
  void bXn()
  {
    if (!this.bbs)
    {
      ViewStub localViewStub = (ViewStub)findViewById(2131380390);
      if (localViewStub != null) {
        ((LinearLayout)localViewStub.inflate().findViewById(2131380391)).setOnTouchListener(new wch(this));
      }
    }
  }
  
  public void bXo()
  {
    if (!isResume()) {}
    for (;;)
    {
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$c != null) {}
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$c.notifyDataSetChanged();
        if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$e == null) {
          continue;
        }
        try
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$e.notifyDataSetChanged();
          return;
        }
        catch (Throwable localThrowable1)
        {
          localThrowable1.printStackTrace();
          return;
        }
      }
      catch (Throwable localThrowable2)
      {
        for (;;)
        {
          localThrowable2.printStackTrace();
        }
      }
    }
  }
  
  protected void bcH()
  {
    hf();
    if (this.mFrom == 9) {
      ThreadManager.post(new TroopMemberListActivity.25(this), 8, null, true);
    }
    for (;;)
    {
      return;
      Object localObject1;
      Object localObject2;
      long l1;
      long l2;
      if ((this.mFrom != 15) && (this.mFrom != 1) && (this.mFrom != 11) && (this.mFrom != 16))
      {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(13));
        localObject1 = null;
        if ((this.mFrom != 11) && (this.mFrom != 1) && (this.mFrom != 16) && (aqiw.isNetworkAvailable(this)))
        {
          localObject2 = getSharedPreferences("last_update_time" + this.app.getCurrentAccountUin(), 4);
          l1 = ((SharedPreferences)localObject2).getLong("key_last_update_time" + this.mTroopUin, 0L);
          l2 = Math.abs(System.currentTimeMillis() - l1);
          int i = 0;
          if (this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo != null) {
            i = this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo.wMemberNum;
          }
          int j = ((SharedPreferences)localObject2).getInt("key_last_update_num" + this.mTroopUin, 0);
          ((SharedPreferences)localObject2).edit().putInt("key_last_update_num" + this.mTroopUin, i).commit();
          if (QLog.isColorLevel()) {
            QLog.d("TroopMemberListActivityget_troop_member", 2, "fillData, lastUpdateTime:" + l1 + " timeDiff:" + l2 / 1000L / 60L + " min  curMemberNum:" + i + " lastUpdateMemberNum:" + j);
          }
          localObject2 = (acms)this.app.getBusinessHandler(20);
          if (localObject2 != null)
          {
            this.bbq = true;
            this.Hm = System.currentTimeMillis();
            ((acms)localObject2).a(true, this.mTroopUin, this.aKI, true, vF(), this.Hm, 0);
            if (QLog.isColorLevel()) {
              QLog.d("TroopMemberListActivityget_troop_member", 2, "fillData, TroopHandler.getTroopMemberList(), troopUin: " + this.aKI + " troopCode: " + this.mTroopUin);
            }
          }
          if (localObject2 == null) {}
        }
      }
      try
      {
        ((acms)localObject2).a(Long.parseLong(this.mTroopUin), 0L, 1, 0, 0);
        if (this.mFrom == 3)
        {
          l1 = getSharedPreferences("last_update_time" + this.app.getCurrentAccountUin(), 4).getLong("key_troop_info_last_update" + this.mTroopUin, 0L);
          l2 = Math.abs(l1 - System.currentTimeMillis());
          if (QLog.isColorLevel()) {
            QLog.d("TroopMemberListActivityget_troop_member", 2, "fillData, TroopInfo lastUpdateTime:" + l1 + " timeDiff:" + l2 / 1000L / 60L);
          }
          if (l2 > 60000L)
          {
            localObject2 = (acms)this.app.getBusinessHandler(20);
            if (localObject2 != null)
            {
              this.Hn = System.currentTimeMillis();
              ((acms)localObject2).Fa(this.mTroopUin);
              ((acms)localObject2).a(1, accc.Z(this.mTroopUin), 0L, 2, 0, 0, true);
              if (QLog.isColorLevel()) {
                QLog.d("TroopMemberListActivityget_troop_member", 2, "fillData, getGroupInfoReq, mTroopUin:" + this.mTroopUin);
              }
            }
          }
        }
        if (localObject1 != null) {
          ThreadManager.post((Runnable)localObject1, 8, null, true);
        }
        if (this.mFrom != 14) {
          continue;
        }
        ((apsz)this.app.getManager(113)).a(this.mTroopUin, new wbo(this));
        return;
        localObject1 = new TroopMemberListActivity.26(this);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.i("TroopMemberListActivityget_troop_member", 2, localException.toString());
          }
        }
      }
    }
  }
  
  protected void bcu()
  {
    Object localObject = (ViewGroup)findViewById(2131377361);
    if (localObject != null) {
      IphoneTitleBarActivity.setLayerType((View)localObject);
    }
    localObject = findViewById(2131379791);
    if (localObject != null) {
      IphoneTitleBarActivity.setLayerType((View)localObject);
    }
    localObject = (TextView)findViewById(2131369579);
    if (localObject != null) {
      IphoneTitleBarActivity.setLayerType((View)localObject);
    }
  }
  
  public void cs(String paramString, int paramInt)
  {
    if ("$".equals(paramString)) {
      if ((this.mFrom == 11) && (paramInt == 1)) {
        anot.a(this.app, "CliOper", "", "", "0X800621B", "0X800621B", 0, 0, "", "", "", "");
      }
    }
    while ((this.mFrom != 11) || (paramInt != 0)) {
      return;
    }
    anot.a(this.app, "CliOper", "", "", "0X800621A", "0X800621A", 0, 0, "", "", "", "");
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    int i = 0;
    Object localObject1 = (acff)this.app.getManager(51);
    Object localObject2 = (TroopManager)this.app.getManager(52);
    if (paramInt2 == -1) {
      switch (paramInt1)
      {
      }
    }
    do
    {
      do
      {
        do
        {
          for (;;)
          {
            return;
            paramInt1 = i;
            if (paramIntent != null)
            {
              paramInt1 = i;
              if (paramIntent.getBooleanExtra("isNeedFinish", false)) {
                paramInt1 = 1;
              }
            }
            if (paramInt1 != 0)
            {
              paramIntent = new Intent();
              paramIntent.putExtra("isNeedFinish", true);
              setResult(-1, paramIntent);
              finish();
              return;
            }
            ThreadManager.post(new TroopMemberListActivity.1(this, paramIntent, (acff)localObject1, (TroopManager)localObject2), 8, null, true);
            return;
            if (paramIntent != null)
            {
              paramIntent = paramIntent.getStringArrayListExtra("param_deleted_uins");
              if (paramIntent.size() > 0)
              {
                paramIntent = paramIntent.iterator();
                while (paramIntent.hasNext()) {
                  a((String)paramIntent.next());
                }
              }
            }
          }
        } while (paramIntent == null);
        paramIntent = paramIntent.getStringExtra("roomId");
      } while (paramIntent == null);
      localObject1 = aqgv.b(this.app, getApplicationContext(), paramIntent);
      localObject2 = wja.a(new Intent(this, SplashActivity.class), null);
      ((Intent)localObject2).putExtra("uin", paramIntent);
      ((Intent)localObject2).putExtra("uintype", 3000);
      ((Intent)localObject2).putExtra("uinname", (String)localObject1);
      ((Intent)localObject2).putExtra("isBack2Root", true);
      ((Intent)localObject2).setFlags(67108864);
      startActivity((Intent)localObject2);
      finish();
      return;
      switch (paramInt1)
      {
      default: 
        return;
      }
    } while (TextUtils.isEmpty(this.aRb));
    ThreadManager.post(new TroopMemberListActivity.2(this, (acff)localObject1), 8, null, true);
  }
  
  public void doOnBackPressed()
  {
    if (this.mFrom == 11) {
      anot.a(this.app, "CliOper", "", "", "0X8006215", "0X8006215", 0, 0, "2", "", "", "");
    }
    super.doOnBackPressed();
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    if (Build.VERSION.SDK_INT >= 11) {
      getWindow().setFlags(16777216, 16777216);
    }
    Object localObject = getIntent().getExtras();
    this.mTroopUin = ((Bundle)localObject).getString("troop_uin");
    this.mTroopName = ((Bundle)localObject).getString("troop_info_name");
    this.aQK = ((Bundle)localObject).getString("troop_gift_from");
    this.aQM = ((Bundle)localObject).getString("leftViewText");
    this.bbr = ((Bundle)localObject).getBoolean("param_is_pop_up_style", false);
    this.mFrom = ((Bundle)localObject).getInt("param_from", 0);
    this.aQN = ((Bundle)localObject).getString("param_troop_fee_project_id");
    this.bLJ = ((Bundle)localObject).getInt("param_troop_fee_entrance_type", -1);
    this.aQY = ((Bundle)localObject).getString("callback");
    this.bbt = ((Bundle)localObject).getBoolean("param_troop_send_apollo_msg", false);
    this.bLQ = ((Bundle)localObject).getInt("TROOP_INFO_MEMBER_NUM", 0);
    this.BL = ((Bundle)localObject).getInt("sort_type", 0);
    this.bLK = ((Bundle)localObject).getInt("param_pick_max_num", this.bLK);
    this.pS = ((Bundle)localObject).getStringArrayList("param_pick_selected_list");
    this.rp = ((Bundle)localObject).getStringArrayList("param_delete_filter_member_list");
    this.rq = ((Bundle)localObject).getStringArrayList("param_hide_filter_member_list");
    this.bLM = ((Bundle)localObject).getInt("param_pick_max_num_exceeds_wording", 2131699798);
    this.aQP = ((Bundle)localObject).getString("param_pick_title_string", this.aQP);
    this.bbw = ((Bundle)localObject).getBoolean("param_filter_robot", false);
    if (this.mFrom == 17) {
      new anov(this.app).a("dc00899").b("Grp_online").c("mber_list").d("exp_onlineList").a(1).a(new String[] { this.mTroopUin }).report();
    }
    if (this.mFrom == 22) {
      aqfr.b("Grp_idol", "mber_list", "exp", 0, 0, new String[] { this.mTroopUin });
    }
    if ((this.mFrom == 9) && (TextUtils.isEmpty(this.aQN)) && (QLog.isColorLevel())) {
      QLog.e("TroopMemberListActivityget_troop_member.troop.troop_fee", 2, "TextUtils.isEmpty(mTroopFeeProjectId)");
    }
    if (this.mFrom == 14)
    {
      this.BL = 7;
      this.bbu = false;
    }
    this.bLH = ((Bundle)localObject).getInt("param_chat_mode", 0);
    this.aQO = ((Bundle)localObject).getString("custom_title_name");
    String str1 = ((Bundle)localObject).getString("param_from");
    if (str1 != null) {}
    boolean bool;
    try
    {
      this.mFrom = Integer.parseInt(str1);
      if (QLog.isColorLevel()) {
        QLog.d("TroopMemberListActivityget_troop_member", 2, "doOnCreate, troopCode=" + this.mTroopUin + " troopUin=" + this.aKI + " from=" + this.mFrom);
      }
      if (this.bbr) {
        setTheme(2131755343);
      }
      super.doOnCreate(paramBundle);
      this.aUo = TroopInfo.isQidianPrivateTroop(this.app, this.mTroopUin);
      if (QLog.isColorLevel()) {
        QLog.d("TroopMemberListActivityget_troop_member", 2, "doOnCreate, mIsQidianPrivateTroop = " + this.aUo + ", mTroopUin = " + this.mTroopUin);
      }
      setContentView(2131563260);
      aDR();
      if (this.bLQ == 0)
      {
        paramBundle = ((TroopManager)this.app.getManager(52)).b(this.mTroopUin);
        if (paramBundle != null) {
          this.bLQ = paramBundle.wMemberNum;
        }
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      try
      {
        this.aYy = ThemeUtil.isDefaultTheme();
        if (this.mFrom == 15)
        {
          this.BL = 6;
          this.pQ = ((Bundle)localObject).getStringArrayList("param_seq_days");
          this.pP = ((Bundle)localObject).getStringArrayList("param_seq_name");
        }
        if ((this.BL == 1) || (this.BL == 8)) {
          ((acms)this.app.getBusinessHandler(20)).Fl(this.mTroopUin);
        }
        if (this.BL == 5) {
          ((acms)this.app.getBusinessHandler(20)).Fm(this.mTroopUin);
        }
        this.jdField_a_of_type_Acdt = ((acdt)this.app.getBusinessHandler(6));
        this.mLayoutInflater = getLayoutInflater();
        this.mDensity = getResources().getDisplayMetrics().density;
        paramBundle = (TroopManager)this.app.getManager(52);
        localObject = (acdu)this.app.getManager(53);
        if ((paramBundle != null) && (localObject != null)) {
          if ((this.mFrom == 1) || (this.mFrom == 11) || (this.mFrom == 16))
          {
            this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo = ((acdu)localObject).a(this.mTroopUin);
            this.aKI = this.mTroopUin;
            if ((this.mFrom != 5) || (this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo == null) || (this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo.isTroopOwner(this.app.getCurrentAccountUin()))) {
              break label1096;
            }
            finish();
            return false;
            localNumberFormatException = localNumberFormatException;
            localNumberFormatException.printStackTrace();
          }
        }
      }
      catch (Throwable paramBundle)
      {
        for (;;)
        {
          paramBundle.printStackTrace();
        }
        this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo = paramBundle.b(this.mTroopUin);
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin = this.mTroopUin;
        if ((this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo != null) && (this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo.isHomeworkTroop())) {}
        for (bool = true;; bool = false)
        {
          this.aLZ = bool;
          this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.updateForTroopInfo(this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo, getCurrentAccountUin());
          if (this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo == null) {
            break label1068;
          }
          this.aKI = this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo.troopcode;
          this.bbs = TroopInfo.hasPayPrivilege(this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo.troopPrivilegeFlag, 32);
          break;
        }
        label1068:
        finish();
        return false;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopMemberListActivityget_troop_member", 2, "doOnCreate, app.getManager(QQAppInterface.FRIEND_MANAGER) is null");
    }
    finish();
    return false;
    label1096:
    int i;
    int j;
    int k;
    int m;
    label1422:
    label1523:
    String str2;
    if ((this.mFrom == 1) || (this.mFrom == 11) || (this.mFrom == 16))
    {
      addObserver(this.jdField_b_of_type_Acdv);
      if ((this.bbt) && (this.mFrom == 3)) {
        this.BL = 2;
      }
      if (this.mFrom == 0)
      {
        paramBundle = getResources().getDisplayMetrics();
        i = Math.max(paramBundle.widthPixels, paramBundle.heightPixels);
        j = getTitleBarHeight();
        k = ImmersiveUtils.getStatusBarHeight(this);
        m = (int)(60.0F * this.mDensity);
        this.bLN = getResources().getDimensionPixelSize(2131299710);
        this.mItemHeight = getResources().getDimensionPixelSize(2131296929);
        if (this.mItemHeight == 0) {
          this.mItemHeight = ((int)(paramBundle.density * 58.0F));
        }
        this.bfM = (i - j - k - m);
        this.bLO = ((this.bfM - this.bLN) / this.mItemHeight);
        this.jdField_a_of_type_Alud = new alud(this);
        if (QLog.isColorLevel()) {
          QLog.i("TroopMemberListActivityget_troop_member", 2, String.format("init h: %s, ah: %s, indexH: %s, itemH: %s, count: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(this.bfM), Integer.valueOf(this.bLN), Integer.valueOf(this.mItemHeight), Integer.valueOf(this.bLO) }));
        }
      }
      if (this.mFrom == 1) {
        break label1936;
      }
      if (this.mFrom != 11) {
        break label1742;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo != null)
      {
        this.aPW = this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo.ownerUin;
        if ((this.aPW == null) || (!this.aPW.equals(this.app.getCurrentAccountUin()))) {
          break label1736;
        }
        bool = true;
        this.bap = bool;
      }
      anot.a(this.app, "CliOper", "", "", "0X8006214", "0X8006214", 0, 0, "", "", "", "");
      if (this.mFrom == 21) {
        this.bbn = true;
      }
      localObject = getResources().getStringArray(2130969894);
      paramBundle = getResources().getStringArray(2130969893);
      if ((this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo != null) && (this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo.isKingBattleTroop())) {
        break label2052;
      }
      this.cu = ((String[])localObject);
      this.cv = paramBundle;
      aC();
      initListView();
      bcH();
      bcu();
      localObject = "4";
      paramBundle = (Bundle)localObject;
      switch (this.mFrom)
      {
      default: 
        paramBundle = (Bundle)localObject;
      case 1: 
        label1587:
        str2 = "2";
        if ((this.aPW != null) && (this.aPW.equals(this.app.getCurrentAccountUin()))) {
          localObject = "0";
        }
        break;
      }
    }
    for (;;)
    {
      this.aQS = ((String)localObject);
      af("exp", paramBundle, (String)localObject);
      if (this.mFrom == 14) {
        bXn();
      }
      if (this.mFrom == 18) {
        anot.a(this.app, "dc00899", "Grp_chatRecord", "", "chatRecor_mber", "mber_exp", 0, 0, this.mTroopUin, "", "", "");
      }
      if (this.mFrom == 3) {
        ((acms)this.app.getBusinessHandler(20)).Fh(this.mTroopUin);
      }
      return true;
      this.app.addObserver(this.jdField_b_of_type_Acnd, true);
      break;
      label1736:
      bool = false;
      break label1422;
      label1742:
      this.bbn = false;
      if (this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo != null)
      {
        if (this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo.troopowneruin != null) {
          this.aPW = this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo.troopowneruin;
        }
        if (this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo.Administrator != null) {
          this.aPX = this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo.Administrator;
        }
        if (((this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo.troopowneruin != null) && (this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo.troopowneruin.equals(this.app.getCurrentAccountUin()))) || ((this.aPX != null) && (this.aPX.contains(this.app.getCurrentAccountUin()))))
        {
          bool = true;
          label1853:
          this.bap = bool;
        }
      }
      while (QLog.isColorLevel())
      {
        QLog.d("TroopMemberListActivityget_troop_member", 2, "doOnCreate, mTroopInfo admin: " + this.aPX + "  owner:" + this.aPW);
        break;
        bool = false;
        break label1853;
        if (QLog.isColorLevel()) {
          QLog.d("TroopMemberListActivityget_troop_member", 2, "doOnCreate, mTroopInfo==null");
        }
      }
      label1936:
      this.bbn = true;
      this.aQZ = "";
      if (this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo != null) {
        this.aPW = this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo.ownerUin;
      }
      for (;;)
      {
        if ((this.aPW != null) && (this.aPW.equals(this.app.getCurrentAccountUin()))) {
          this.bap = true;
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("TroopMemberListActivityget_troop_member", 2, "doOnCreate, mDiscussionInfo owner: " + this.aPW);
        break;
        if (QLog.isColorLevel()) {
          QLog.d("TroopMemberListActivityget_troop_member", 2, "doOnCreate, mDiscussionInfo==null");
        }
      }
      label2052:
      k = 0;
      m = 1;
      j = m;
      i = k;
      if (this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo.showGameSwitchStatus == 1)
      {
        j = m;
        i = k;
        if (this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo.gameSwitchStatus == 1)
        {
          i = 1;
          j = 2;
        }
      }
      this.cu = new String[localObject.length + j];
      k = 0;
      int n = localObject.length;
      m = 0;
      while (m < n)
      {
        str2 = localObject[m];
        this.cu[k] = str2;
        m += 1;
        k += 1;
      }
      this.cu[k] = getResources().getString(2131721455);
      if (i != 0) {
        this.cu[(k + 1)] = getResources().getString(2131721454);
      }
      this.cv = new String[j + paramBundle.length];
      j = 0;
      m = paramBundle.length;
      k = 0;
      while (k < m)
      {
        localObject = paramBundle[k];
        this.cv[j] = localObject;
        k += 1;
        j += 1;
      }
      this.cv[j] = getResources().getString(2131721456);
      if (i == 0) {
        break label1523;
      }
      this.cv[(j + 1)] = getResources().getString(2131721454);
      break label1523;
      paramBundle = "0";
      break label1587;
      paramBundle = "1";
      break label1587;
      paramBundle = "2";
      break label1587;
      paramBundle = "3";
      break label1587;
      localObject = str2;
      if (this.aPX != null)
      {
        localObject = str2;
        if (this.aPX.contains(this.app.getCurrentAccountUin())) {
          localObject = "1";
        }
      }
    }
  }
  
  public void doOnDestroy()
  {
    this.bba = true;
    try
    {
      this.mHandler.removeCallbacksAndMessages(null);
      label13:
      if (this.jdField_a_of_type_Alud != null)
      {
        this.jdField_a_of_type_Alud.destroy();
        this.jdField_a_of_type_Alud = null;
      }
      try
      {
        removeObserver(this.jdField_b_of_type_Acdv);
        removeObserver(this.jdField_b_of_type_Acnd);
        label48:
        if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$e != null) {
          this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$e.destroy();
        }
        super.doOnDestroy();
        if ((this.G != null) && (this.G.isShowing())) {
          this.G.dismiss();
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$c != null) {
          this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$c.destroy();
        }
        if ((this.mActionSheet != null) && (this.mActionSheet.isShowing())) {
          this.mActionSheet.dismiss();
        }
        if ((this.W != null) && (this.W.isShowing())) {
          this.W.dismiss();
        }
        return;
      }
      catch (Exception localException1)
      {
        break label48;
      }
    }
    catch (Exception localException2)
    {
      break label13;
    }
  }
  
  public boolean doOnKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && (this.mFrom != 1) && (this.mFrom != 13) && (this.mFrom != 21) && ((this.bbo) || (this.bbn)))
    {
      this.bbo = false;
      this.ru.setVisibility(0);
      if (this.mFrom != 22) {
        this.rv.setVisibility(0);
      }
      this.Gk.setVisibility(8);
      this.Bi.setVisibility(8);
      this.Bi = ((TextView)findViewById(2131369579));
      this.Bi.setVisibility(0);
      this.Bi.setOnClickListener(this.dx);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$c != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$c.bSJ();
      }
      return true;
    }
    return super.doOnKeyDown(paramInt, paramKeyEvent);
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    try
    {
      getWindow().setSoftInputMode(48);
      label13:
      if (this.mTitleBar != null)
      {
        this.mTitleBar.destroyDrawingCache();
        this.mTitleBar.requestLayout();
        this.mTitleBar.invalidate();
      }
      if (this.jdField_a_of_type_Alud != null) {
        this.jdField_a_of_type_Alud.onResume();
      }
      return;
    }
    catch (Exception localException)
    {
      break label13;
    }
  }
  
  public void doOnStop()
  {
    super.doOnStop();
    getWindow().setSoftInputMode(16);
  }
  
  protected void dz(String paramString1, String paramString2)
  {
    paramString2 = (acff)this.app.getManager(51);
    if (paramString2 != null)
    {
      if (paramString2.isFriend(paramString1))
      {
        paramString1 = new ProfileActivity.AllInOne(paramString1, 20);
        paramString1.pa = 20;
        paramString1.troopUin = this.aKI;
        paramString1.troopcode = this.mTroopUin;
        paramString1.bJa = 4;
        ProfileActivity.b(this, paramString1);
      }
    }
    else {
      return;
    }
    paramString1 = new ProfileActivity.AllInOne(paramString1, 21);
    paramString1.pa = 21;
    paramString1.subSourceId = 11;
    paramString1.troopUin = this.aKI;
    paramString1.troopcode = this.mTroopUin;
    paramString1.bJa = 4;
    ProfileActivity.b(this, paramString1);
  }
  
  public void finish()
  {
    if ((this.mFrom == 9) && ((this.bbx) || (this.bLI != this.pr.size())))
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("key_troop_fee_notify_js_data_changed", true);
      localIntent.putExtra("callback", this.aQY);
      setResult(-1, localIntent);
    }
    super.finish();
    if (this.bbr) {
      overridePendingTransition(0, 2130771990);
    }
    if (this.mFrom == 12) {
      overridePendingTransition(0, 2130772013);
    }
  }
  
  public void hg()
  {
    this.mHandler.removeMessages(14);
    if ((this.hi != null) && (this.hi.getVisibility() == 0)) {
      this.hi.setVisibility(8);
    }
  }
  
  protected void initListView()
  {
    View localView = getLayoutInflater().inflate(2131563269, this.jdField_a_of_type_ComTencentWidgetPinnedDividerSwipListView, false);
    this.gW = ((RelativeLayout)localView.findViewById(2131377783));
    this.hh = ((RelativeLayout)localView.findViewById(2131362674));
    this.hh.setVisibility(8);
    TextView localTextView;
    int i;
    label124:
    int j;
    label142:
    Object localObject;
    if (ThemeUtil.isDefaultTheme())
    {
      this.hh.setBackgroundResource(2130839642);
      localTextView = (TextView)this.hh.findViewById(2131380814);
      this.bLL = ((LinearLayout.LayoutParams)localTextView.getLayoutParams()).leftMargin;
      if ((this.mFrom != 3) || (!this.bap) || (this.bLH == 1)) {
        break label845;
      }
      i = 1;
      if ((this.mFrom != 11) || (!this.bap)) {
        break label850;
      }
      j = 1;
      if ((i != 0) || (j != 0))
      {
        localObject = getString(2131721411);
        localTextView.setText((CharSequence)localObject);
        localTextView = (TextView)this.hh.findViewById(2131377102);
        localTextView.setText("");
        ((ImageView)this.hh.findViewById(2131369767)).setBackgroundDrawable(aqhu.aW());
        ImageView localImageView = (ImageView)this.hh.findViewById(2131373912);
        localImageView.setVisibility(8);
        if (i != 0)
        {
          localImageView.setVisibility(0);
          localImageView.setOnClickListener(new wbf(this));
          localTextView.setTextSize(12.0F);
        }
        this.hh.setOnClickListener(new wbg(this, (String)localObject));
        if (!this.bbt)
        {
          this.hh.setVisibility(0);
          this.hh.setEnabled(false);
        }
        localObject = (acms)this.app.getBusinessHandler(20);
        if (aqiw.isNetSupport(BaseApplication.getContext())) {
          break label855;
        }
        QQToast.a(this, 1, 2131696270, 0).show(getTitleBarHeight());
      }
      if ((this.mFrom != 3) || (this.bap) || (this.bLH == 1)) {
        break label954;
      }
      i = 1;
      label365:
      if ((this.mFrom != 11) || (this.bap)) {
        break label959;
      }
      j = 1;
      label383:
      if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isNewTroop) && ((i != 0) || (j != 0)))
      {
        localObject = (acms)this.app.getBusinessHandler(20);
        if (aqiw.isNetSupport(BaseApplication.getContext())) {
          break label964;
        }
        QQToast.a(this, 1, 2131696270, 0).show(getTitleBarHeight());
      }
      label441:
      localObject = (EditText)this.gW.findViewById(2131366542);
      ((Button)this.gW.findViewById(2131363801)).setVisibility(8);
      if (this.mFrom != 19) {
        break label1025;
      }
      localView = getLayoutInflater().inflate(2131563261, this.jdField_a_of_type_ComTencentWidgetPinnedDividerSwipListView, false);
      localView.setOnClickListener(new wbh(this));
      this.jdField_a_of_type_ComTencentWidgetPinnedDividerSwipListView.addHeaderView(localView);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$c = new c();
      this.jdField_a_of_type_ComTencentWidgetPinnedDividerSwipListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$c);
      if ((this.mFrom == 19) || (this.mFrom == 21)) {
        this.gW.setVisibility(8);
      }
      if ((this.mFrom != 9) && (this.mFrom != 19)) {
        bSH();
      }
      ((EditText)localObject).setOnTouchListener(new wbi(this));
      this.jdField_b_of_type_ComTencentMobileqqWidgetIndexView.setIndex(new String[] { "$", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "#" });
      this.jdField_b_of_type_ComTencentMobileqqWidgetIndexView.setOnIndexChangedListener(this);
      if (this.mFrom == 11) {
        this.jdField_b_of_type_ComTencentMobileqqWidgetIndexView.setOnIndexChangedListener2(this);
      }
      return;
      this.hh.setBackgroundResource(2130839639);
      break;
      label845:
      i = 0;
      break label124;
      label850:
      j = 0;
      break label142;
      label855:
      if ((this.jdField_a_of_type_Acdt != null) && (this.mFrom == 11)) {
        this.jdField_a_of_type_Acdt.eF(this.app.getCurrentAccountUin(), this.aKI);
      }
      for (;;)
      {
        this.dD = getResources().getDrawable(2130839657);
        localTextView.setCompoundDrawablesWithIntrinsicBounds(this.dD, null, null, null);
        ((Animatable)this.dD).start();
        break;
        if (localObject != null) {
          ((acms)localObject).eF(this.app.getCurrentAccountUin(), this.mTroopUin);
        }
      }
      label954:
      i = 0;
      break label365;
      label959:
      j = 0;
      break label383;
      label964:
      if ((this.jdField_a_of_type_Acdt != null) && (this.mFrom == 11))
      {
        this.jdField_a_of_type_Acdt.eF(this.app.getCurrentAccountUin(), this.aKI);
        break label441;
      }
      if (localObject == null) {
        break label441;
      }
      ((acms)localObject).eF(this.app.getCurrentAccountUin(), this.mTroopUin);
      break label441;
      label1025:
      if ((this.mFrom != 9) && (this.mFrom != 15)) {
        this.jdField_a_of_type_ComTencentWidgetPinnedDividerSwipListView.addHeaderView(localView);
      }
    }
  }
  
  public void m(int[] paramArrayOfInt)
  {
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length == 0) || (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$c == null)) {
      break label16;
    }
    label16:
    while (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$c.mItemCount + this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$c.bMe > 16) {
      return;
    }
    int k = 1;
    int i = 0;
    int j = 0;
    label44:
    int n = i;
    int m = j;
    if (k < paramArrayOfInt.length)
    {
      m = paramArrayOfInt[k] - paramArrayOfInt[(k - 1)] - 1;
      if (m > 0) {}
    }
    for (;;)
    {
      k += 1;
      break label44;
      int i1 = j + this.bLN;
      j = this.mItemHeight * m;
      if (i1 + j > this.bfM)
      {
        j = m;
        do
        {
          k = j - 1;
          m = this.bLN * k;
          if (i1 + m <= this.bfM) {
            break;
          }
          j = k;
        } while (k > 0);
        n = i + k;
        m = i1 + m;
        if (this.mItemHeight + m > this.bfM) {
          this.bLO = (n + 1);
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("TroopMemberListActivityget_troop_member", 2, String.format("updateMaxItemCount, max: %s", new Object[] { Integer.valueOf(this.bLO) }));
        return;
      }
      j = i1 + j;
      i += m;
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    getWindow().getDecorView().invalidate();
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong) {}
  
  /* Error */
  public void q(String paramString, List<TroopMemberInfo> paramList)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 243	com/tencent/mobileqq/activity/TroopMemberListActivity:pr	Ljava/util/List;
    //   6: invokeinterface 938 1 0
    //   11: aload_0
    //   12: dconst_0
    //   13: putfield 358	com/tencent/mobileqq/activity/TroopMemberListActivity:bw	D
    //   16: aload_0
    //   17: iconst_m1
    //   18: putfield 360	com/tencent/mobileqq/activity/TroopMemberListActivity:bLP	I
    //   21: aload_0
    //   22: iconst_0
    //   23: putfield 553	com/tencent/mobileqq/activity/TroopMemberListActivity:bLQ	I
    //   26: invokestatic 439	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   29: ifeq +30 -> 59
    //   32: ldc_w 441
    //   35: iconst_2
    //   36: new 443	java/lang/StringBuilder
    //   39: dup
    //   40: invokespecial 444	java/lang/StringBuilder:<init>	()V
    //   43: ldc_w 3072
    //   46: invokevirtual 450	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: aload_1
    //   50: invokevirtual 450	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: invokevirtual 457	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   56: invokestatic 460	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   59: aload_0
    //   60: invokestatic 1187	java/lang/System:currentTimeMillis	()J
    //   63: putfield 556	com/tencent/mobileqq/activity/TroopMemberListActivity:Hp	J
    //   66: aload_2
    //   67: ifnull +15 -> 82
    //   70: aload_2
    //   71: astore 8
    //   73: aload_2
    //   74: invokeinterface 3074 1 0
    //   79: ifeq +528 -> 607
    //   82: new 240	java/util/ArrayList
    //   85: dup
    //   86: invokespecial 241	java/util/ArrayList:<init>	()V
    //   89: astore_2
    //   90: aload_0
    //   91: getfield 464	com/tencent/mobileqq/activity/TroopMemberListActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   94: invokevirtual 2172	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/data/QQEntityManagerFactory;
    //   97: invokevirtual 2178	com/tencent/mobileqq/data/QQEntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   100: astore 8
    //   102: aload 8
    //   104: iconst_1
    //   105: ldc_w 485
    //   108: invokevirtual 3079	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   111: bipush 19
    //   113: anewarray 496	java/lang/String
    //   116: dup
    //   117: iconst_0
    //   118: ldc_w 3080
    //   121: aastore
    //   122: dup
    //   123: iconst_1
    //   124: ldc_w 3081
    //   127: aastore
    //   128: dup
    //   129: iconst_2
    //   130: ldc_w 3082
    //   133: aastore
    //   134: dup
    //   135: iconst_3
    //   136: ldc_w 3083
    //   139: aastore
    //   140: dup
    //   141: iconst_4
    //   142: ldc_w 3084
    //   145: aastore
    //   146: dup
    //   147: iconst_5
    //   148: ldc_w 3085
    //   151: aastore
    //   152: dup
    //   153: bipush 6
    //   155: ldc_w 3086
    //   158: aastore
    //   159: dup
    //   160: bipush 7
    //   162: ldc_w 3087
    //   165: aastore
    //   166: dup
    //   167: bipush 8
    //   169: ldc_w 3089
    //   172: aastore
    //   173: dup
    //   174: bipush 9
    //   176: ldc_w 3091
    //   179: aastore
    //   180: dup
    //   181: bipush 10
    //   183: ldc_w 3093
    //   186: aastore
    //   187: dup
    //   188: bipush 11
    //   190: ldc_w 3094
    //   193: aastore
    //   194: dup
    //   195: bipush 12
    //   197: ldc_w 3095
    //   200: aastore
    //   201: dup
    //   202: bipush 13
    //   204: ldc_w 3096
    //   207: aastore
    //   208: dup
    //   209: bipush 14
    //   211: ldc_w 3097
    //   214: aastore
    //   215: dup
    //   216: bipush 15
    //   218: ldc_w 3098
    //   221: aastore
    //   222: dup
    //   223: bipush 16
    //   225: ldc_w 3099
    //   228: aastore
    //   229: dup
    //   230: bipush 17
    //   232: ldc_w 3100
    //   235: aastore
    //   236: dup
    //   237: bipush 18
    //   239: ldc_w 3101
    //   242: aastore
    //   243: ldc_w 3103
    //   246: iconst_1
    //   247: anewarray 496	java/lang/String
    //   250: dup
    //   251: iconst_0
    //   252: aload_1
    //   253: aastore
    //   254: aconst_null
    //   255: aconst_null
    //   256: aconst_null
    //   257: aconst_null
    //   258: invokevirtual 3106	com/tencent/mobileqq/persistence/EntityManager:query	(ZLjava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   261: astore_1
    //   262: aload_1
    //   263: ifnull +289 -> 552
    //   266: aload_1
    //   267: invokeinterface 3111 1 0
    //   272: ifeq +274 -> 546
    //   275: new 485	com/tencent/mobileqq/data/TroopMemberInfo
    //   278: dup
    //   279: invokespecial 3112	com/tencent/mobileqq/data/TroopMemberInfo:<init>	()V
    //   282: astore 9
    //   284: aload 9
    //   286: aload_1
    //   287: iconst_0
    //   288: invokeinterface 3113 2 0
    //   293: putfield 488	com/tencent/mobileqq/data/TroopMemberInfo:memberuin	Ljava/lang/String;
    //   296: aload 9
    //   298: aload_1
    //   299: iconst_1
    //   300: invokeinterface 3113 2 0
    //   305: invokestatic 3116	java/lang/Boolean:parseBoolean	(Ljava/lang/String;)Z
    //   308: putfield 1594	com/tencent/mobileqq/data/TroopMemberInfo:mIsShielded	Z
    //   311: aload 9
    //   313: aload_1
    //   314: iconst_2
    //   315: invokeinterface 3113 2 0
    //   320: putfield 1625	com/tencent/mobileqq/data/TroopMemberInfo:mUniqueTitle	Ljava/lang/String;
    //   323: aload 9
    //   325: aload_1
    //   326: iconst_3
    //   327: invokeinterface 3118 2 0
    //   332: putfield 1570	com/tencent/mobileqq/data/TroopMemberInfo:level	I
    //   335: aload 9
    //   337: aload_1
    //   338: iconst_4
    //   339: invokeinterface 3121 2 0
    //   344: putfield 1588	com/tencent/mobileqq/data/TroopMemberInfo:active_point	J
    //   347: aload 9
    //   349: aload_1
    //   350: iconst_5
    //   351: invokeinterface 3121 2 0
    //   356: putfield 1578	com/tencent/mobileqq/data/TroopMemberInfo:credit_level	J
    //   359: aload 9
    //   361: aload_1
    //   362: bipush 6
    //   364: invokeinterface 3121 2 0
    //   369: putfield 1564	com/tencent/mobileqq/data/TroopMemberInfo:last_active_time	J
    //   372: aload 9
    //   374: aload_1
    //   375: bipush 7
    //   377: invokeinterface 3121 2 0
    //   382: putfield 1567	com/tencent/mobileqq/data/TroopMemberInfo:join_time	J
    //   385: aload 9
    //   387: aload_1
    //   388: bipush 8
    //   390: invokeinterface 3113 2 0
    //   395: putfield 3123	com/tencent/mobileqq/data/TroopMemberInfo:troopnick	Ljava/lang/String;
    //   398: aload 9
    //   400: aload_1
    //   401: bipush 9
    //   403: invokeinterface 3113 2 0
    //   408: putfield 1558	com/tencent/mobileqq/data/TroopMemberInfo:pyAll_troopnick	Ljava/lang/String;
    //   411: aload 9
    //   413: aload_1
    //   414: bipush 10
    //   416: invokeinterface 3113 2 0
    //   421: putfield 1561	com/tencent/mobileqq/data/TroopMemberInfo:pyFirst_troopnick	Ljava/lang/String;
    //   424: aload 9
    //   426: aload_1
    //   427: bipush 11
    //   429: invokeinterface 3113 2 0
    //   434: putfield 1534	com/tencent/mobileqq/data/TroopMemberInfo:friendnick	Ljava/lang/String;
    //   437: aload 9
    //   439: aload_1
    //   440: bipush 12
    //   442: invokeinterface 3113 2 0
    //   447: putfield 1540	com/tencent/mobileqq/data/TroopMemberInfo:pyAll_friendnick	Ljava/lang/String;
    //   450: aload 9
    //   452: aload_1
    //   453: bipush 13
    //   455: invokeinterface 3113 2 0
    //   460: putfield 1546	com/tencent/mobileqq/data/TroopMemberInfo:pyFirst_friendnick	Ljava/lang/String;
    //   463: aload 9
    //   465: aload_1
    //   466: bipush 14
    //   468: invokeinterface 3113 2 0
    //   473: putfield 1663	com/tencent/mobileqq/data/TroopMemberInfo:autoremark	Ljava/lang/String;
    //   476: aload 9
    //   478: aload_1
    //   479: bipush 15
    //   481: invokeinterface 3113 2 0
    //   486: putfield 1669	com/tencent/mobileqq/data/TroopMemberInfo:pyAll_autoremark	Ljava/lang/String;
    //   489: aload 9
    //   491: aload_1
    //   492: bipush 16
    //   494: invokeinterface 3113 2 0
    //   499: putfield 1672	com/tencent/mobileqq/data/TroopMemberInfo:pyFirst_autoremark	Ljava/lang/String;
    //   502: aload 9
    //   504: aload_1
    //   505: bipush 17
    //   507: invokeinterface 3118 2 0
    //   512: putfield 1574	com/tencent/mobileqq/data/TroopMemberInfo:realLevel	I
    //   515: aload 9
    //   517: aload_1
    //   518: bipush 18
    //   520: invokeinterface 3113 2 0
    //   525: putfield 1555	com/tencent/mobileqq/data/TroopMemberInfo:troopColorNick	Ljava/lang/String;
    //   528: aload_2
    //   529: aload 9
    //   531: invokeinterface 517 2 0
    //   536: pop
    //   537: aload_1
    //   538: invokeinterface 3126 1 0
    //   543: ifne -268 -> 275
    //   546: aload_1
    //   547: invokeinterface 3129 1 0
    //   552: aload 8
    //   554: invokevirtual 3130	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   557: invokestatic 1187	java/lang/System:currentTimeMillis	()J
    //   560: lstore 6
    //   562: aload_2
    //   563: astore 8
    //   565: invokestatic 439	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   568: ifeq +39 -> 607
    //   571: ldc_w 441
    //   574: iconst_2
    //   575: new 443	java/lang/StringBuilder
    //   578: dup
    //   579: invokespecial 444	java/lang/StringBuilder:<init>	()V
    //   582: ldc_w 3132
    //   585: invokevirtual 450	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   588: lload 6
    //   590: aload_0
    //   591: getfield 556	com/tencent/mobileqq/activity/TroopMemberListActivity:Hp	J
    //   594: lsub
    //   595: invokevirtual 2133	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   598: invokevirtual 457	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   601: invokestatic 460	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   604: aload_2
    //   605: astore 8
    //   607: aload 8
    //   609: ifnull +13 -> 622
    //   612: aload 8
    //   614: invokeinterface 3074 1 0
    //   619: ifeq +26 -> 645
    //   622: invokestatic 439	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   625: ifeq +13 -> 638
    //   628: ldc_w 441
    //   631: iconst_2
    //   632: ldc_w 3134
    //   635: invokestatic 460	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   638: aload_0
    //   639: invokevirtual 932	com/tencent/mobileqq/activity/TroopMemberListActivity:hg	()V
    //   642: aload_0
    //   643: monitorexit
    //   644: return
    //   645: aload 8
    //   647: invokeinterface 479 1 0
    //   652: istore 4
    //   654: aload_0
    //   655: iload 4
    //   657: putfield 553	com/tencent/mobileqq/activity/TroopMemberListActivity:bLQ	I
    //   660: iload 4
    //   662: getstatic 211	com/tencent/mobileqq/activity/TroopMemberListActivity:bLR	I
    //   665: idiv
    //   666: istore 5
    //   668: iload 4
    //   670: getstatic 211	com/tencent/mobileqq/activity/TroopMemberListActivity:bLR	I
    //   673: irem
    //   674: ifne +195 -> 869
    //   677: iconst_0
    //   678: istore_3
    //   679: aload_0
    //   680: iload_3
    //   681: iload 5
    //   683: iadd
    //   684: putfield 360	com/tencent/mobileqq/activity/TroopMemberListActivity:bLP	I
    //   687: iconst_0
    //   688: istore_3
    //   689: iload_3
    //   690: iload 4
    //   692: if_icmpge +42 -> 734
    //   695: new 3136	com/tencent/mobileqq/activity/TroopMemberListActivity$35
    //   698: dup
    //   699: aload_0
    //   700: aload 8
    //   702: iload_3
    //   703: getstatic 211	com/tencent/mobileqq/activity/TroopMemberListActivity:bLR	I
    //   706: iload_3
    //   707: iadd
    //   708: iconst_1
    //   709: isub
    //   710: iload 4
    //   712: invokestatic 3139	java/lang/Math:min	(II)I
    //   715: invokespecial 3142	com/tencent/mobileqq/activity/TroopMemberListActivity$35:<init>	(Lcom/tencent/mobileqq/activity/TroopMemberListActivity;Ljava/util/List;II)V
    //   718: bipush 8
    //   720: aconst_null
    //   721: iconst_1
    //   722: invokestatic 1196	com/tencent/mobileqq/app/ThreadManager:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   725: iload_3
    //   726: getstatic 211	com/tencent/mobileqq/activity/TroopMemberListActivity:bLR	I
    //   729: iadd
    //   730: istore_3
    //   731: goto -42 -> 689
    //   734: invokestatic 439	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   737: ifeq -95 -> 642
    //   740: ldc_w 441
    //   743: iconst_2
    //   744: new 443	java/lang/StringBuilder
    //   747: dup
    //   748: invokespecial 444	java/lang/StringBuilder:<init>	()V
    //   751: ldc_w 3144
    //   754: invokevirtual 450	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   757: iload 4
    //   759: invokevirtual 453	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   762: ldc_w 3146
    //   765: invokevirtual 450	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   768: aload_0
    //   769: getfield 360	com/tencent/mobileqq/activity/TroopMemberListActivity:bLP	I
    //   772: invokevirtual 453	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   775: invokevirtual 457	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   778: invokestatic 460	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   781: goto -139 -> 642
    //   784: astore_1
    //   785: invokestatic 439	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   788: ifeq -146 -> 642
    //   791: ldc_w 441
    //   794: iconst_2
    //   795: new 443	java/lang/StringBuilder
    //   798: dup
    //   799: invokespecial 444	java/lang/StringBuilder:<init>	()V
    //   802: ldc_w 3148
    //   805: invokevirtual 450	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   808: aload_1
    //   809: invokevirtual 2148	java/lang/Exception:toString	()Ljava/lang/String;
    //   812: invokevirtual 450	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   815: invokevirtual 457	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   818: invokestatic 460	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   821: goto -179 -> 642
    //   824: astore_1
    //   825: aload_0
    //   826: monitorexit
    //   827: aload_1
    //   828: athrow
    //   829: astore_1
    //   830: invokestatic 439	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   833: ifeq -191 -> 642
    //   836: ldc_w 441
    //   839: iconst_2
    //   840: new 443	java/lang/StringBuilder
    //   843: dup
    //   844: invokespecial 444	java/lang/StringBuilder:<init>	()V
    //   847: ldc_w 3148
    //   850: invokevirtual 450	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   853: aload_1
    //   854: invokevirtual 2151	java/lang/OutOfMemoryError:toString	()Ljava/lang/String;
    //   857: invokevirtual 450	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   860: invokevirtual 457	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   863: invokestatic 460	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   866: goto -224 -> 642
    //   869: iconst_1
    //   870: istore_3
    //   871: goto -192 -> 679
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	874	0	this	TroopMemberListActivity
    //   0	874	1	paramString	String
    //   0	874	2	paramList	List<TroopMemberInfo>
    //   678	193	3	i	int
    //   652	106	4	j	int
    //   666	18	5	k	int
    //   560	29	6	l	long
    //   71	630	8	localObject	Object
    //   282	248	9	localTroopMemberInfo	TroopMemberInfo
    // Exception table:
    //   from	to	target	type
    //   26	59	784	java/lang/Exception
    //   59	66	784	java/lang/Exception
    //   73	82	784	java/lang/Exception
    //   82	262	784	java/lang/Exception
    //   266	275	784	java/lang/Exception
    //   275	546	784	java/lang/Exception
    //   546	552	784	java/lang/Exception
    //   552	562	784	java/lang/Exception
    //   565	604	784	java/lang/Exception
    //   612	622	784	java/lang/Exception
    //   622	638	784	java/lang/Exception
    //   638	642	784	java/lang/Exception
    //   645	677	784	java/lang/Exception
    //   679	687	784	java/lang/Exception
    //   695	731	784	java/lang/Exception
    //   734	781	784	java/lang/Exception
    //   2	26	824	finally
    //   26	59	824	finally
    //   59	66	824	finally
    //   73	82	824	finally
    //   82	262	824	finally
    //   266	275	824	finally
    //   275	546	824	finally
    //   546	552	824	finally
    //   552	562	824	finally
    //   565	604	824	finally
    //   612	622	824	finally
    //   622	638	824	finally
    //   638	642	824	finally
    //   645	677	824	finally
    //   679	687	824	finally
    //   695	731	824	finally
    //   734	781	824	finally
    //   785	821	824	finally
    //   830	866	824	finally
    //   26	59	829	java/lang/OutOfMemoryError
    //   59	66	829	java/lang/OutOfMemoryError
    //   73	82	829	java/lang/OutOfMemoryError
    //   82	262	829	java/lang/OutOfMemoryError
    //   266	275	829	java/lang/OutOfMemoryError
    //   275	546	829	java/lang/OutOfMemoryError
    //   546	552	829	java/lang/OutOfMemoryError
    //   552	562	829	java/lang/OutOfMemoryError
    //   565	604	829	java/lang/OutOfMemoryError
    //   612	622	829	java/lang/OutOfMemoryError
    //   622	638	829	java/lang/OutOfMemoryError
    //   638	642	829	java/lang/OutOfMemoryError
    //   645	677	829	java/lang/OutOfMemoryError
    //   679	687	829	java/lang/OutOfMemoryError
    //   695	731	829	java/lang/OutOfMemoryError
    //   734	781	829	java/lang/OutOfMemoryError
  }
  
  public void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
  
  protected void vv(String paramString)
  {
    long l1 = System.currentTimeMillis();
    this.aRa = "";
    this.mSearchResultList.clear();
    this.root.getLayoutParams().height = -1;
    if ((paramString == null) || (paramString.trim().length() == 0))
    {
      this.ae.setVisibility(8);
      this.o.setVisibility(8);
      this.sq.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$e.notifyDataSetChanged();
      return;
    }
    this.ae.setVisibility(0);
    this.o.setVisibility(0);
    paramString = paramString.toLowerCase();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList3 = new ArrayList();
    aptw localaptw = (aptw)this.app.getManager(203);
    int i = 0;
    for (;;)
    {
      a locala;
      try
      {
        if (i >= this.pr.size()) {
          break label964;
        }
        locala = (a)this.pr.get(i);
        if ((this.bbw) && (localaptw.gM(locala.uin))) {
          break label1142;
        }
        locala.aRf = "";
        locala.aRg = "";
        if ((paramString.equals(locala.aRl)) || (paramString.equals(locala.aRn)) || (paramString.equals(locala.aRm)))
        {
          locala.aRf = locala.aRl;
          localArrayList1.add(locala);
          if (!QLog.isColorLevel()) {
            break label1142;
          }
          QLog.d("TroopMemberListActivityget_troop_member", 2, "refreshSearchResultList:" + locala.uin + "," + locala.aRf);
        }
      }
      finally {}
      if ((paramString.equals(locala.remark)) || (paramString.equals(locala.aRk)) || (paramString.equals(locala.aRj)))
      {
        locala.aRf = locala.remark;
        localArrayList1.add(locala);
      }
      else if ((paramString.equals(locala.nickname)) || (paramString.equals(locala.aRi)) || (paramString.equals(locala.aRh)))
      {
        locala.aRf = locala.nickname;
        localArrayList1.add(locala);
      }
      else if (paramString.equals(locala.uin))
      {
        if (!this.aUo)
        {
          locala.aRf = locala.uin;
          localArrayList1.add(locala);
        }
      }
      else if ((locala.aRl.indexOf(paramString) == 0) || (locala.aRn.indexOf(paramString) == 0) || (locala.aRm.indexOf(paramString) == 0))
      {
        locala.aRf = locala.aRl;
        locala.aRg = locala.aRm;
        localArrayList2.add(locala);
      }
      else if ((locala.remark.indexOf(paramString) == 0) || (locala.aRk.indexOf(paramString) == 0) || (locala.aRj.indexOf(paramString) == 0))
      {
        locala.aRf = locala.remark;
        locala.aRg = locala.aRj;
        localArrayList2.add(locala);
      }
      else if ((locala.nickname.indexOf(paramString) == 0) || (locala.aRi.indexOf(paramString) == 0) || (locala.aRh.indexOf(paramString) == 0))
      {
        locala.aRf = locala.nickname;
        locala.aRg = locala.aRh;
        localArrayList2.add(locala);
      }
      else if (locala.uin.indexOf(paramString) == 0)
      {
        if (!this.aUo)
        {
          locala.aRf = locala.uin;
          locala.aRg = locala.uin;
          localArrayList2.add(locala);
        }
      }
      else if ((locala.aRl.indexOf(paramString) > 0) || (locala.aRn.indexOf(paramString) > 0) || (locala.aRm.indexOf(paramString) > 0))
      {
        locala.aRf = locala.aRl;
        localArrayList3.add(locala);
      }
      else if ((locala.remark.indexOf(paramString) > 0) || (locala.aRk.indexOf(paramString) > 0) || (locala.aRj.indexOf(paramString) > 0))
      {
        locala.aRf = locala.remark;
        localArrayList3.add(locala);
      }
      else if ((locala.nickname.indexOf(paramString) > 0) || (locala.aRi.indexOf(paramString) > 0) || (locala.aRh.indexOf(paramString) > 0))
      {
        locala.aRf = locala.nickname;
        localArrayList3.add(locala);
      }
      else if ((locala.uin.indexOf(paramString) > 0) && (!this.aUo))
      {
        locala.aRf = locala.uin;
        localArrayList3.add(locala);
        continue;
        label964:
        Collections.sort(localArrayList2, new f());
        this.mSearchResultList.addAll(localArrayList1);
        this.mSearchResultList.addAll(localArrayList2);
        this.mSearchResultList.addAll(localArrayList3);
        if (this.mSearchResultList.isEmpty()) {
          this.sq.setVisibility(0);
        }
        for (;;)
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$e.notifyDataSetChanged();
          long l2 = System.currentTimeMillis();
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.i("TroopMemberListActivityget_troop_member", 2, "refreshSearchResultList:" + paramString + "," + (l2 - l1) + "," + this.mSearchResultList.size() + "," + this.pr.size());
          return;
          this.sq.setVisibility(8);
        }
        label1142:
        i += 1;
      }
    }
  }
  
  public void wN(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopMemberListActivityget_troop_member", 2, "removeSearchItem:" + paramString);
    }
    List localList = this.mSearchResultList;
    int i = 0;
    for (;;)
    {
      try
      {
        if (i < this.mSearchResultList.size())
        {
          a locala = (a)this.mSearchResultList.get(i);
          if ((locala != null) && (locala.uin.equals(paramString))) {
            this.mSearchResultList.remove(i);
          }
        }
        else
        {
          return;
        }
      }
      finally {}
      i += 1;
    }
  }
  
  public void wO(String paramString)
  {
    boolean bool = true;
    if (QLog.isColorLevel()) {
      QLog.d("TroopMemberListActivityget_troop_member", 2, "kickOutDiscussionMember:" + paramString);
    }
    for (;;)
    {
      try
      {
        if (this.G == null)
        {
          this.G = new ReportDialog(this, 2131756467);
          this.G.setContentView(2131558460);
          Dialog localDialog = this.G;
          if (this.mFrom != 1)
          {
            localDialog.setCancelable(bool);
            ((TextView)this.G.findViewById(2131365863)).setText(getString(2131692859));
          }
        }
        else
        {
          this.G.show();
          this.jdField_a_of_type_Acdt.Z(Long.parseLong(this.aKI), Long.valueOf(paramString).longValue());
          return;
        }
      }
      catch (Exception paramString)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("TroopMemberListActivityget_troop_member", 2, "kickOutDiscussionMember:" + paramString.toString());
      }
      bool = false;
    }
  }
  
  protected void wP(String paramString)
  {
    if (((aptw)this.app.getManager(203)).c(this, this.mTroopUin, Long.parseLong(paramString))) {
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("selfSet_leftViewText", getString(2131721410));
    if ((this.aQO != null) && (!TextUtils.isEmpty(this.aQO))) {
      localBundle.putString("custom_leftbackbutton_name", getString(2131691039));
    }
    aldj.a(this.app, this, this.mTroopUin, paramString, 1, 1, localBundle);
    this.aRb = paramString;
    af("Clk_item", this.aQS, "");
  }
  
  public static class SearchDialogDismissRunnable
    implements Runnable
  {
    private WeakReference<TroopMemberListActivity> mActivityRef;
    
    public SearchDialogDismissRunnable(TroopMemberListActivity paramTroopMemberListActivity)
    {
      this.mActivityRef = new WeakReference(paramTroopMemberListActivity);
    }
    
    public void run()
    {
      TroopMemberListActivity localTroopMemberListActivity = (TroopMemberListActivity)this.mActivityRef.get();
      if (localTroopMemberListActivity != null)
      {
        localTroopMemberListActivity.aaC = false;
        int i = localTroopMemberListActivity.mTitleBar.getHeight();
        localTroopMemberListActivity.mRootView.offsetTopAndBottom(-i);
        localTroopMemberListActivity.mTitleBar.setVisibility(0);
        TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, -i, 0.0F);
        localTranslateAnimation.setDuration(300L);
        localTroopMemberListActivity.mRootView.startAnimation(localTranslateAnimation);
        ((InputMethodManager)localTroopMemberListActivity.getSystemService("input_method")).hideSoftInputFromWindow(localTroopMemberListActivity.getWindow().peekDecorView().getWindowToken(), 0);
      }
    }
  }
  
  public static class TroopAdmin
    implements Parcelable
  {
    public static final Parcelable.Creator<TroopAdmin> CREATOR = new wco();
    public short faceid;
    public String name;
    public String pinyinFirst;
    public String uin;
    
    public TroopAdmin() {}
    
    private TroopAdmin(Parcel paramParcel)
    {
      this.uin = paramParcel.readString();
      this.faceid = ((short)paramParcel.readInt());
      this.name = paramParcel.readString();
      this.pinyinFirst = paramParcel.readString();
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public boolean equals(Object paramObject)
    {
      if ((paramObject instanceof TroopAdmin))
      {
        paramObject = (TroopAdmin)paramObject;
        if (this.uin != null) {
          return this.uin.equals(paramObject.uin);
        }
      }
      return false;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeString(this.uin);
      paramParcel.writeInt(this.faceid);
      paramParcel.writeString(this.name);
      paramParcel.writeString(this.pinyinFirst);
    }
  }
  
  public static class a
  {
    public long Hq;
    public long Hr;
    public long Hs;
    public long Ht;
    public String aRf = "";
    public String aRg = "";
    public String aRh = "";
    public String aRi = "";
    public String aRj = "";
    public String aRk = "";
    public String aRl = "";
    public String aRm = "";
    public String aRn = "";
    public String aRo = "";
    public String aRp = "";
    public String aRq = "";
    public String aRr = "";
    public String aRs;
    public int bLX;
    public int bLY;
    public int bLZ;
    public int bMa;
    public int bMb;
    public int bMc;
    public boolean bbC;
    public String displayName = "";
    public double distance = -100.0D;
    public short faceid;
    public boolean isOnline;
    public boolean isTroopFollowed;
    public int level;
    public String levelName = "";
    public int mBigClubTemplateId;
    public boolean mIsShielded;
    public String mUniqueTitle;
    public int mUniqueTitleExpire;
    public int mVipLevel;
    public int mVipTemplateId;
    public int mVipType;
    public String nickname = "";
    public String pinyinAll = "";
    public String pinyinFirst = "";
    public int realLevel;
    public String remark = "";
    public String uin;
    
    public void vW(String paramString)
    {
      String str = paramString;
      if (paramString == null) {
        str = "";
      }
      this.pinyinAll = str;
    }
    
    public void wQ(String paramString)
    {
      String str = paramString;
      if (paramString == null) {
        str = "";
      }
      this.nickname = str;
    }
    
    public void wR(String paramString)
    {
      String str = paramString;
      if (paramString == null) {
        str = "";
      }
      this.aRh = str;
    }
    
    public void wS(String paramString)
    {
      String str = paramString;
      if (paramString == null) {
        str = "";
      }
      this.aRi = str;
    }
    
    public void wT(String paramString)
    {
      String str = paramString;
      if (paramString == null) {
        str = "";
      }
      this.remark = str;
    }
    
    public void wU(String paramString)
    {
      String str = paramString;
      if (paramString == null) {
        str = "";
      }
      this.aRj = str;
    }
    
    public void wV(String paramString)
    {
      String str = paramString;
      if (paramString == null) {
        str = "";
      }
      this.aRo = str;
    }
    
    public void wW(String paramString)
    {
      String str = paramString;
      if (paramString == null) {
        str = "";
      }
      this.aRk = str;
    }
    
    public void wX(String paramString)
    {
      String str = paramString;
      if (paramString == null) {
        str = "";
      }
      this.aRl = str;
    }
    
    public void wY(String paramString)
    {
      String str = paramString;
      if (paramString == null) {
        str = "";
      }
      this.aRm = str;
    }
    
    public void wZ(String paramString)
    {
      String str = paramString;
      if (paramString == null) {
        str = "";
      }
      this.aRn = str;
    }
  }
  
  class b
    implements Animation.AnimationListener
  {
    int bDt;
    View rl;
    
    public void onAnimationEnd(Animation paramAnimation)
    {
      this.this$0.mHandler.postDelayed(new TroopMemberListActivity.AnimationEndClearListener.1(this), 0L);
    }
    
    public void onAnimationRepeat(Animation paramAnimation) {}
    
    public void onAnimationStart(Animation paramAnimation)
    {
      paramAnimation = (String)this.rl.getTag();
      if ((this.bDt == 1) && (paramAnimation.equals("left")))
      {
        this.rl.clearAnimation();
        this.bDt = 6;
      }
      if ((this.bDt == 0) && (paramAnimation.equals("right")))
      {
        this.rl.clearAnimation();
        this.bDt = 6;
      }
    }
  }
  
  public class c
    extends abdw
  {
    public LinkedHashMap<String, List<TroopMemberListActivity.a>> D = new LinkedHashMap();
    public String aRt;
    public int[] ad = new int[0];
    public int bMd;
    public int bMe;
    public String[] k = new String[0];
    public int mItemCount;
    public List<TroopMemberListActivity.a> rt = new ArrayList();
    public List<String> ru = new ArrayList();
    protected List<String> rv;
    protected List<String> rw;
    protected List<oidb_0xa2a.UserInfo> rx;
    
    public c()
    {
      super(TroopMemberListActivity.this.app, TroopMemberListActivity.this.jdField_a_of_type_ComTencentWidgetPinnedDividerSwipListView, true);
      if ((TroopMemberListActivity.this.mFrom == 1) || (TroopMemberListActivity.this.mFrom == 11)) {
        this$1 = TroopMemberListActivity.this.getString(2131692858);
      }
      for (;;)
      {
        this.aRt = TroopMemberListActivity.this;
        return;
        if (TroopMemberListActivity.this.mFrom == 5) {
          this$1 = TroopMemberListActivity.this.getString(2131698538);
        } else {
          this$1 = TroopMemberListActivity.this.getString(2131721450);
        }
      }
    }
    
    public String a(String[] paramArrayOfString, long paramLong, Calendar paramCalendar)
    {
      if (paramLong == 0L) {
        return paramArrayOfString[7];
      }
      Calendar localCalendar = Calendar.getInstance();
      localCalendar.setTimeInMillis(1000L * paramLong);
      int i = (paramCalendar.get(1) - localCalendar.get(1)) * 365 + paramCalendar.get(6) - localCalendar.get(6);
      if (i <= 0) {
        return paramArrayOfString[0];
      }
      if (i <= 7) {
        return paramArrayOfString[1];
      }
      if (i <= 30) {
        return paramArrayOfString[2];
      }
      if (i <= 90) {
        return paramArrayOfString[3];
      }
      if (i <= 180) {
        return paramArrayOfString[4];
      }
      if (i <= 365) {
        return paramArrayOfString[5];
      }
      return paramArrayOfString[6];
    }
    
    public int ag()
    {
      if (TroopMemberListActivity.this.mFrom == 9) {
        return 0;
      }
      return 2131559497;
    }
    
    public String b(String[] paramArrayOfString, long paramLong, Calendar paramCalendar)
    {
      Calendar localCalendar = Calendar.getInstance();
      if (paramLong > 0L) {
        localCalendar.setTimeInMillis(1000L * paramLong);
      }
      int i;
      for (;;)
      {
        i = (paramCalendar.get(1) - localCalendar.get(1)) * 365 + paramCalendar.get(6) - localCalendar.get(6);
        if (i > 0) {
          break;
        }
        return paramArrayOfString[0];
        localCalendar.set(1, 2012);
        localCalendar.set(2, 5);
        localCalendar.set(5, 1);
      }
      if (i <= 7) {
        return paramArrayOfString[1];
      }
      if (i <= 30) {
        return paramArrayOfString[2];
      }
      if (i <= 90) {
        return paramArrayOfString[3];
      }
      if (i <= 180) {
        return paramArrayOfString[4];
      }
      if (i <= 365) {
        return paramArrayOfString[5];
      }
      if (i <= 730) {
        return paramArrayOfString[6];
      }
      if (i <= 1095) {
        return paramArrayOfString[7];
      }
      if (i <= 1825) {
        return paramArrayOfString[8];
      }
      if (i <= 2555) {
        return paramArrayOfString[9];
      }
      if (i <= 3650) {
        return paramArrayOfString[10];
      }
      return paramArrayOfString[11];
    }
    
    public void b(View paramView, int paramInt)
    {
      if ((TroopMemberListActivity.this.mFrom == 9) || (TroopMemberListActivity.this.mFrom == 19)) {
        if (paramView != null) {
          paramView.setVisibility(8);
        }
      }
      while ((this.ad.length <= 0) || (this.k.length <= 0)) {
        return;
      }
      paramInt = Arrays.binarySearch(this.ad, paramInt);
      if (paramInt < 0) {
        paramInt = -(paramInt + 1) - 1;
      }
      for (;;)
      {
        List localList = (List)this.D.get(this.k[paramInt]);
        if ((localList != null) && (localList.size() > 1))
        {
          ((TextView)paramView).setText(this.k[paramInt] + TroopMemberListActivity.this.getString(2131721950, new Object[] { Integer.valueOf(localList.size()) }));
          if (!TroopMemberListActivity.this.aYy) {
            break label207;
          }
          paramView.setBackgroundResource(2130838900);
        }
        for (;;)
        {
          paramView.setPadding((int)(10.0F * TroopMemberListActivity.this.mDensity), 0, 0, 0);
          return;
          ((TextView)paramView).setText(this.k[paramInt]);
          break;
          label207:
          paramView.setBackgroundResource(2130851103);
        }
      }
    }
    
    public void bSJ()
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopMemberListActivityget_troop_member", 2, "mAdapter.notifyDataSetChanged2()");
      }
      QLog.d(".troop.troopManagerVASH", 2, new Object[] { "notifyDataSetChanged2 List count: ", Integer.valueOf(TroopMemberListActivity.this.pr.size()) });
      Object[] arrayOfObject = c();
      if (arrayOfObject == null) {
        if (QLog.isColorLevel()) {
          QLog.d("TroopMemberListActivityget_troop_member", 2, "constructHashStruct result == null!");
        }
      }
      do
      {
        return;
        if (arrayOfObject.length >= 3)
        {
          this.D = ((LinkedHashMap)arrayOfObject[0]);
          this.ad = ((int[])arrayOfObject[1]);
          this.k = ((String[])arrayOfObject[2]);
          TroopMemberListActivity.this.runOnUiThread(new TroopMemberListActivity.ListAdapter.1(this));
          return;
        }
      } while ((arrayOfObject.length != 0) || ((TroopMemberListActivity.this.mFrom != 13) && (TroopMemberListActivity.this.mFrom != 21)));
      this.D.clear();
      this.ad = new int[0];
      this.k = new String[0];
      notifyDataSetChanged();
    }
    
    @SuppressLint({"UseSparseArrays"})
    public Object[] c()
    {
      long l1 = System.currentTimeMillis();
      LinkedHashMap localLinkedHashMap = new LinkedHashMap();
      Object localObject6 = (aptw)TroopMemberListActivity.this.app.getManager(203);
      Object localObject9;
      Object localObject10;
      Object localObject7;
      ArrayList localArrayList1;
      Object localObject8;
      Object localObject3;
      int i;
      for (;;)
      {
        ArrayList localArrayList2;
        TroopMemberListActivity.a locala;
        synchronized (TroopMemberListActivity.this)
        {
          if (TroopMemberListActivity.this.BL != 0) {
            break label1513;
          }
          localObject9 = new ArrayList();
          localObject10 = new ArrayList();
          localObject7 = new ArrayList();
          localArrayList1 = new ArrayList();
          localArrayList2 = new ArrayList();
          localObject8 = new ArrayList();
          this.mItemCount = 0;
          this.bMd = 0;
          this.bMe = 0;
          Iterator localIterator = TroopMemberListActivity.this.pr.iterator();
          if (!localIterator.hasNext()) {
            break;
          }
          locala = (TroopMemberListActivity.a)localIterator.next();
          if (((aptw)localObject6).gM(locala.uin))
          {
            if ((TroopMemberListActivity.this.mFrom == 5) || (TroopMemberListActivity.this.mFrom == 2) || (TroopMemberListActivity.f(TroopMemberListActivity.this))) {
              continue;
            }
            ((List)localObject8).add(locala);
          }
        }
        if ((TroopMemberListActivity.this.mFrom == 12) || (TroopMemberListActivity.this.mFrom == 20))
        {
          if ((TroopMemberListActivity.this.aQR != null) && (TroopMemberListActivity.this.aQR.contains(locala.uin))) {
            localArrayList2.add(locala);
          }
          if ((TroopMemberListActivity.this.aQQ != null) && (TroopMemberListActivity.this.aQQ.contains(locala.uin)) && (!this.rt.contains(locala))) {
            this.rt.add(locala);
          }
          if ((TroopMemberListActivity.this.pS != null) && (TroopMemberListActivity.this.pS.contains(locala.uin)) && (!this.rt.contains(locala)))
          {
            this.rt.add(locala);
            TroopMemberListActivity.this.pS.remove(locala.uin);
          }
        }
        if ((TroopMemberListActivity.this.mFrom != 13) && (TroopMemberListActivity.this.mFrom != 21))
        {
          if ((!TroopMemberListActivity.this.aLZ) && ((locala.isTroopFollowed) || (TroopMemberListActivity.this.ro.contains(locala.uin)))) {
            ((List)localObject9).add(locala);
          }
          if ((!TroopMemberListActivity.this.aLZ) && (locala.mIsShielded)) {
            localArrayList1.add(locala);
          }
          if ((!locala.uin.equals(TroopMemberListActivity.this.app.getCurrentAccountUin())) && (locala.Ht == 1L)) {
            ((List)localObject10).add(locala);
          }
        }
        if (((TroopMemberListActivity.this.aPW != null) && (TroopMemberListActivity.this.aPW.equals(locala.uin))) || ((TroopMemberListActivity.this.aPX != null) && (TroopMemberListActivity.this.aPX.contains(locala.uin))) || ((TroopMemberListActivity.this.aLZ) && ((locala.level == 332) || (locala.level == 333))))
        {
          ((List)localObject7).add(locala);
          if (QLog.isColorLevel()) {
            QLog.d("zivonchen", 2, "constructHashStruct uin = " + locala.uin + ", name = " + locala.nickname + ", level = " + locala.level);
          }
        }
        else if ((TroopMemberListActivity.this.mFrom == 5) && (!TextUtils.isEmpty(locala.mUniqueTitle)))
        {
          ((List)localObject7).add(locala);
        }
        else
        {
          if (locala.pinyinFirst == null) {
            break label4524;
          }
          if (locala.pinyinFirst.length() == 0) {
            break label4524;
          }
          for (;;)
          {
            localObject4 = localObject3;
            if (((String)localObject3).length() == 1)
            {
              i = ((String)localObject3).charAt(0);
              if ((65 > i) || (i > 90)) {
                break label4532;
              }
              label807:
              localObject4 = ((String)localObject3).toUpperCase();
            }
            label814:
            if (localObject1.get(localObject4) == null) {
              localObject1.put(localObject4, new ArrayList());
            }
            this.mItemCount += 1;
            ((List)localObject1.get(localObject4)).add(locala);
            break;
            localObject3 = locala.pinyinFirst.substring(0, 1);
          }
        }
      }
      localObject6 = new TroopMemberListActivity.d(0, true);
      Object localObject4 = new LinkedHashMap();
      label976:
      label1375:
      char c;
      label1442:
      label1513:
      Object localObject2;
      label1691:
      label2000:
      label2280:
      label2921:
      int j;
      if (TroopMemberListActivity.this.mFrom == 19)
      {
        if (((List)localObject7).size() > 0)
        {
          Collections.sort((List)localObject7, (Comparator)localObject6);
          TroopMemberListActivity.this.a((List)localObject7, TroopMemberListActivity.this.aPW, TroopMemberListActivity.this.aPX);
          ((LinkedHashMap)localObject4).put(TroopMemberListActivity.a(TroopMemberListActivity.this), localObject7);
        }
      }
      else
      {
        for (;;)
        {
          if (TroopMemberListActivity.this.aUo) {
            localObject1.remove(TroopMemberListActivity.this.getString(2131720413));
          }
          localObject3 = new int[localObject1.keySet().size()];
          localObject4 = new String[localObject3.length];
          ??? = localObject1.keySet().iterator();
          if (localObject3.length != 0) {
            break label4297;
          }
          return new Object[0];
          if (TroopMemberListActivity.this.mFrom == 21)
          {
            this.bMd = 0;
            Collections.sort((List)localObject7, (Comparator)localObject6);
            ((LinkedHashMap)localObject4).put(acfp.m(2131715941), TroopMemberListActivity.this.pr);
            break label4555;
          }
          if ((((List)localObject9).size() > 0) && (TroopMemberListActivity.this.mFrom != 12))
          {
            Collections.sort((List)localObject9, (Comparator)localObject6);
            ((LinkedHashMap)localObject4).put(TroopMemberListActivity.this.getString(2131720413), localObject9);
          }
          if ((localArrayList1.size() > 0) && (TroopMemberListActivity.this.mFrom != 3))
          {
            Collections.sort(localArrayList1, (Comparator)localObject6);
            ((LinkedHashMap)localObject4).put(TroopMemberListActivity.this.getString(2131721432), localArrayList1);
          }
          if ((((List)localObject10).size() > 0) && (TroopMemberListActivity.this.mFrom != 3))
          {
            Collections.sort((List)localObject10, (Comparator)localObject6);
            ((LinkedHashMap)localObject4).put(TroopMemberListActivity.this.getString(2131692346), localObject10);
          }
          if (((List)localObject7).size() > 0)
          {
            Collections.sort((List)localObject7, (Comparator)localObject6);
            this.bMe += ((List)localObject7).size();
            TroopMemberListActivity.this.a((List)localObject7, TroopMemberListActivity.this.aPW, TroopMemberListActivity.this.aPX);
            if (!TroopMemberListActivity.this.aLZ) {
              break label1442;
            }
          }
          for (localObject3 = TroopMemberListActivity.a(TroopMemberListActivity.this);; localObject3 = this.aRt)
          {
            ((LinkedHashMap)localObject4).put(localObject3, localObject7);
            if (((List)localObject8).size() <= 0) {
              break label4562;
            }
            Collections.sort((List)localObject8, (Comparator)localObject6);
            this.bMe += ((List)localObject8).size();
            ((LinkedHashMap)localObject4).put(TroopMemberListActivity.this.getString(2131721452), localObject8);
            break label4562;
            if (c > 'Z') {
              break;
            }
            if (localObject1.get(String.valueOf(c)) == null) {
              break label4568;
            }
            this.bMd += 1;
            Collections.sort((List)localObject1.get(String.valueOf(c)), (Comparator)localObject6);
            ((LinkedHashMap)localObject4).put(String.valueOf(c), localObject1.get(String.valueOf(c)));
            break label4568;
          }
          if (localObject1.get("#") != null)
          {
            this.bMd += 1;
            Collections.sort((List)localObject1.get("#"), (Comparator)localObject6);
            ((LinkedHashMap)localObject4).put("#", localObject1.get("#"));
          }
          localObject1.clear();
          break label4555;
          if (TroopMemberListActivity.this.BL == 2)
          {
            localObject4 = TroopMemberListActivity.this.getResources().getStringArray(2130969889);
            localObject3 = Calendar.getInstance();
            ((Calendar)localObject3).setTimeInMillis(NetConnInfoCenter.getServerTime() * 1000L);
            localObject6 = TroopMemberListActivity.this.pr.iterator();
            while (((Iterator)localObject6).hasNext())
            {
              localObject7 = (TroopMemberListActivity.a)((Iterator)localObject6).next();
              if (TextUtils.isEmpty(((TroopMemberListActivity.a)localObject7).aRq)) {
                ((TroopMemberListActivity.a)localObject7).aRq = a((String[])localObject4, ((TroopMemberListActivity.a)localObject7).Hr, (Calendar)localObject3);
              }
              if (localObject1.get(((TroopMemberListActivity.a)localObject7).aRq) == null) {
                localObject1.put(((TroopMemberListActivity.a)localObject7).aRq, new ArrayList());
              }
              ((List)localObject1.get(((TroopMemberListActivity.a)localObject7).aRq)).add(localObject7);
            }
            localObject3 = new LinkedHashMap();
            i = localObject4.length - 1;
            if (i >= 0)
            {
              if (localObject1.get(localObject4[i]) == null) {
                break label4576;
              }
              Collections.sort((List)localObject1.get(localObject4[i]), new TroopMemberListActivity.d(2, false));
              ((LinkedHashMap)localObject3).put(localObject4[i], localObject1.get(localObject4[i]));
              break label4576;
            }
            localObject1.clear();
            localObject2 = localObject3;
          }
          else if (TroopMemberListActivity.this.BL == 6)
          {
            if (TroopMemberListActivity.d(TroopMemberListActivity.this).size() == 0) {
              return null;
            }
            localObject3 = Calendar.getInstance();
            ((Calendar)localObject3).setTimeInMillis(NetConnInfoCenter.getServerTime() * 1000L);
            localObject4 = TroopMemberListActivity.this.pr.iterator();
            while (((Iterator)localObject4).hasNext())
            {
              localObject6 = (TroopMemberListActivity.a)((Iterator)localObject4).next();
              if (TextUtils.isEmpty(((TroopMemberListActivity.a)localObject6).aRq))
              {
                if (((TroopMemberListActivity.a)localObject6).Hr == 0L) {
                  ((TroopMemberListActivity.a)localObject6).Hr = ((TroopMemberListActivity.a)localObject6).Hq;
                }
                ((TroopMemberListActivity.a)localObject6).aRq = TroopMemberListActivity.this.a(((TroopMemberListActivity.a)localObject6).Hr, (Calendar)localObject3, TroopMemberListActivity.d(TroopMemberListActivity.this), TroopMemberListActivity.e(TroopMemberListActivity.this));
              }
              if (localObject2.get(((TroopMemberListActivity.a)localObject6).aRq) == null) {
                localObject2.put(((TroopMemberListActivity.a)localObject6).aRq, new ArrayList());
              }
              if (!TextUtils.isEmpty(((TroopMemberListActivity.a)localObject6).aRq)) {
                ((List)localObject2.get(((TroopMemberListActivity.a)localObject6).aRq)).add(localObject6);
              }
            }
            localObject3 = new LinkedHashMap();
            i = TroopMemberListActivity.e(TroopMemberListActivity.this).size() - 1;
            if (i >= 0)
            {
              if (localObject2.get(TroopMemberListActivity.e(TroopMemberListActivity.this).get(i)) == null) {
                break label4583;
              }
              Collections.sort((List)localObject2.get(TroopMemberListActivity.e(TroopMemberListActivity.this).get(i)), new TroopMemberListActivity.d(2, false));
              ((LinkedHashMap)localObject3).put(TroopMemberListActivity.e(TroopMemberListActivity.this).get(i), localObject2.get(TroopMemberListActivity.e(TroopMemberListActivity.this).get(i)));
              break label4583;
            }
            localObject2.clear();
            localObject2 = localObject3;
          }
          else
          {
            if (TroopMemberListActivity.this.BL != 3) {
              break;
            }
            localObject4 = TroopMemberListActivity.this.getResources().getStringArray(2130969890);
            localObject3 = Calendar.getInstance();
            ((Calendar)localObject3).setTimeInMillis(NetConnInfoCenter.getServerTime() * 1000L);
            localObject6 = TroopMemberListActivity.this.pr.iterator();
            while (((Iterator)localObject6).hasNext())
            {
              localObject7 = (TroopMemberListActivity.a)((Iterator)localObject6).next();
              if (TextUtils.isEmpty(((TroopMemberListActivity.a)localObject7).aRp)) {
                ((TroopMemberListActivity.a)localObject7).aRp = b((String[])localObject4, ((TroopMemberListActivity.a)localObject7).Hq, (Calendar)localObject3);
              }
              if (localObject2.get(((TroopMemberListActivity.a)localObject7).aRp) == null) {
                localObject2.put(((TroopMemberListActivity.a)localObject7).aRp, new ArrayList());
              }
              ((List)localObject2.get(((TroopMemberListActivity.a)localObject7).aRp)).add(localObject7);
            }
            localObject3 = new LinkedHashMap();
            i = localObject4.length - 1;
            if (i >= 0)
            {
              if (localObject2.get(localObject4[i]) == null) {
                break label4590;
              }
              Collections.sort((List)localObject2.get(localObject4[i]), new TroopMemberListActivity.d(3, false));
              ((LinkedHashMap)localObject3).put(localObject4[i], localObject2.get(localObject4[i]));
              break label4590;
            }
            localObject2.clear();
            localObject2 = localObject3;
          }
        }
        if (TroopMemberListActivity.this.BL == 1)
        {
          localObject3 = new ArrayList();
          localObject4 = new ArrayList();
          localObject7 = new ArrayList();
          localObject8 = new ArrayList();
          localObject9 = TroopMemberListActivity.this.pr.iterator();
          while (((Iterator)localObject9).hasNext())
          {
            localObject10 = (TroopMemberListActivity.a)((Iterator)localObject9).next();
            if (((aptw)localObject6).gM(((TroopMemberListActivity.a)localObject10).uin))
            {
              if ((TroopMemberListActivity.this.mFrom != 5) && (TroopMemberListActivity.this.mFrom != 2) && (!TroopMemberListActivity.f(TroopMemberListActivity.this))) {
                if ((this.rv != null) && (this.rv.contains(((TroopMemberListActivity.a)localObject10).uin)))
                {
                  ((List)localObject3).add(localObject10);
                  ((TroopMemberListActivity.a)localObject10).isOnline = true;
                }
                else
                {
                  ((List)localObject8).add(localObject10);
                  ((TroopMemberListActivity.a)localObject10).isOnline = false;
                }
              }
            }
            else if ((this.rv != null) && (this.rv.contains(((TroopMemberListActivity.a)localObject10).uin)))
            {
              ((TroopMemberListActivity.a)localObject10).isOnline = true;
              if (((TroopMemberListActivity.this.aPW != null) && (TroopMemberListActivity.this.aPW.equals(((TroopMemberListActivity.a)localObject10).uin))) || ((TroopMemberListActivity.this.aPX != null) && (TroopMemberListActivity.this.aPX.contains(((TroopMemberListActivity.a)localObject10).uin))) || ((TroopMemberListActivity.this.aLZ) && ((((TroopMemberListActivity.a)localObject10).level == 332) || (((TroopMemberListActivity.a)localObject10).level == 333)))) {
                ((List)localObject4).add(localObject10);
              } else {
                ((List)localObject7).add(localObject10);
              }
            }
            else
            {
              ((TroopMemberListActivity.a)localObject10).isOnline = false;
              ((List)localObject8).add(localObject10);
            }
          }
          localObject2.clear();
          Collections.sort((List)localObject3, new TroopMemberListActivity.d(1, false));
          if (((List)localObject3).size() > 0) {
            localObject2.put(TroopMemberListActivity.this.getString(2131721452), localObject3);
          }
          if (((List)localObject4).size() > 0)
          {
            Collections.sort((List)localObject4, new TroopMemberListActivity.d(1, false));
            TroopMemberListActivity.this.a((List)localObject4, TroopMemberListActivity.this.aPW, TroopMemberListActivity.this.aPX);
            if (!TroopMemberListActivity.this.aLZ) {
              break label2921;
            }
          }
          for (localObject3 = TroopMemberListActivity.this.getString(2131696615);; localObject3 = TroopMemberListActivity.this.getString(2131696614))
          {
            localObject2.put(localObject3, localObject4);
            Collections.sort((List)localObject7, new TroopMemberListActivity.d(1, false));
            if (((List)localObject7).size() > 0) {
              localObject2.put(TroopMemberListActivity.this.getString(2131721448), localObject7);
            }
            Collections.sort((List)localObject8, new TroopMemberListActivity.d(1, false));
            if (((List)localObject8).size() <= 0) {
              break;
            }
            localObject2.put(TroopMemberListActivity.this.getString(2131721447), localObject8);
            break;
          }
        }
        if (TroopMemberListActivity.this.BL == 7)
        {
          localObject3 = new ArrayList();
          localObject4 = new ArrayList();
          localObject6 = new ArrayList();
          localObject7 = new ArrayList();
          j = TroopMemberListActivity.this.pr.size();
          localObject8 = new HashMap(j);
          i = 0;
          while (i < j)
          {
            localObject9 = (TroopMemberListActivity.a)TroopMemberListActivity.this.pr.get(i);
            ((TroopMemberListActivity.a)localObject9).bMa = 0;
            ((HashMap)localObject8).put(((TroopMemberListActivity.a)localObject9).uin, localObject9);
            i += 1;
          }
          if (TroopMemberListActivity.a(TroopMemberListActivity.this) != null)
          {
            i = 0;
            label3070:
            if (i < TroopMemberListActivity.a(TroopMemberListActivity.this).length)
            {
              localObject9 = (TroopMemberListActivity.a)((HashMap)localObject8).remove(String.valueOf(TroopMemberListActivity.a(TroopMemberListActivity.this)[i]));
              if (localObject9 == null) {
                break label4600;
              }
              ((List)localObject3).add(localObject9);
              break label4600;
            }
          }
          if (TroopMemberListActivity.b(TroopMemberListActivity.this) != null)
          {
            i = 0;
            label3134:
            if (i < TroopMemberListActivity.b(TroopMemberListActivity.this).length)
            {
              localObject9 = (TroopMemberListActivity.a)((HashMap)localObject8).remove(String.valueOf(TroopMemberListActivity.b(TroopMemberListActivity.this)[i]));
              if (localObject9 == null) {
                break label4607;
              }
              ((List)localObject4).add(localObject9);
              break label4607;
            }
          }
          if (TroopMemberListActivity.c(TroopMemberListActivity.this) != null)
          {
            i = 0;
            label3198:
            if (i < TroopMemberListActivity.c(TroopMemberListActivity.this).length)
            {
              localObject9 = (TroopMemberListActivity.a)((HashMap)localObject8).remove(String.valueOf(TroopMemberListActivity.c(TroopMemberListActivity.this)[i]));
              if (localObject9 == null) {
                break label4614;
              }
              ((List)localObject6).add(localObject9);
              break label4614;
            }
          }
          localObject8 = ((HashMap)localObject8).entrySet().iterator();
          while (((Iterator)localObject8).hasNext()) {
            ((List)localObject7).add(((Map.Entry)((Iterator)localObject8).next()).getValue());
          }
          Collections.sort((List)localObject3, new TroopMemberListActivity.d(2, true));
          if (!((List)localObject3).isEmpty()) {
            localObject2.put(acfp.m(2131715974), localObject3);
          }
          if (!((List)localObject4).isEmpty()) {
            localObject2.put(acfp.m(2131715948), localObject4);
          }
          if (!((List)localObject6).isEmpty()) {
            localObject2.put(acfp.m(2131715993), localObject6);
          }
          Collections.sort((List)localObject7, new TroopMemberListActivity.d(2, true));
          if (((List)localObject7).isEmpty()) {
            break label4621;
          }
          localObject2.put(acfp.m(2131715940), localObject7);
          break label4621;
        }
        if (TroopMemberListActivity.this.BL == 8)
        {
          localObject3 = new ArrayList();
          localObject4 = new ArrayList();
          localObject6 = new HashMap();
          if (this.rx != null)
          {
            j = this.rx.size();
            i = 0;
            while (i < j)
            {
              localObject7 = (oidb_0xa2a.UserInfo)this.rx.get(i);
              ((HashMap)localObject6).put(String.valueOf(((oidb_0xa2a.UserInfo)localObject7).uin.get()), localObject7);
              i += 1;
            }
          }
          localObject7 = TroopMemberListActivity.this.pr.iterator();
          while (((Iterator)localObject7).hasNext())
          {
            localObject8 = (TroopMemberListActivity.a)((Iterator)localObject7).next();
            localObject9 = (oidb_0xa2a.UserInfo)((HashMap)localObject6).get(((TroopMemberListActivity.a)localObject8).uin);
            if (localObject9 != null)
            {
              ((List)localObject3).add(localObject8);
              ((TroopMemberListActivity.a)localObject8).bMb = ((oidb_0xa2a.UserInfo)localObject9).score.get();
            }
            else
            {
              ((List)localObject4).add(localObject8);
            }
          }
          if (((List)localObject3).size() > 0)
          {
            Collections.sort((List)localObject3, new TroopMemberListActivity.d(8, false));
            localObject2.put(acfp.m(2131715954), localObject3);
          }
          if (((List)localObject4).size() <= 0) {
            break label4624;
          }
          Collections.sort((List)localObject4, new TroopMemberListActivity.d(8, false));
          localObject2.put(acfp.m(2131716008), localObject4);
          break label4624;
        }
        if (TroopMemberListActivity.this.BL == 4)
        {
          localObject3 = new LinkedHashMap();
          localObject4 = TroopMemberListActivity.this.getResources().getStringArray(2130969884);
          localObject6 = acfp.m(2131715942);
          localObject7 = TroopMemberListActivity.this.pr.iterator();
          while (((Iterator)localObject7).hasNext())
          {
            localObject8 = (TroopMemberListActivity.a)((Iterator)localObject7).next();
            j = ((TroopMemberListActivity.a)localObject8).level;
            i = j;
            if (j >= 10000) {
              i = ((TroopMemberListActivity.a)localObject8).level - 10000;
            }
            if ((i >= 321) && (i <= 327))
            {
              localObject9 = localObject4[(i - 321)];
              if (((LinkedHashMap)localObject3).get(localObject9) == null) {
                ((LinkedHashMap)localObject3).put(localObject9, new ArrayList());
              }
              ((List)((LinkedHashMap)localObject3).get(localObject9)).add(localObject8);
            }
            else
            {
              if (((LinkedHashMap)localObject3).get(localObject6) == null) {
                ((LinkedHashMap)localObject3).put(localObject6, new ArrayList());
              }
              ((List)((LinkedHashMap)localObject3).get(localObject6)).add(localObject8);
            }
          }
          i = localObject4.length - 1;
        }
      }
      for (;;)
      {
        if (i >= 0)
        {
          if (((LinkedHashMap)localObject3).get(localObject4[i]) != null)
          {
            Collections.sort((List)((LinkedHashMap)localObject3).get(localObject4[i]), new TroopMemberListActivity.d(0, false));
            localObject2.put(localObject4[i], ((LinkedHashMap)localObject3).get(localObject4[i]));
          }
        }
        else
        {
          if (((LinkedHashMap)localObject3).get(localObject6) != null)
          {
            Collections.sort((List)((LinkedHashMap)localObject3).get(localObject6), new TroopMemberListActivity.d(0, false));
            localObject2.put(localObject6, ((LinkedHashMap)localObject3).get(localObject6));
          }
          tbb.a(null, "846", "205607", "", "84601", "1", "145");
          break label976;
          if (TroopMemberListActivity.this.BL == 5)
          {
            localObject3 = new ArrayList();
            localObject4 = new ArrayList();
            localObject7 = TroopMemberListActivity.this.pr.iterator();
            while (((Iterator)localObject7).hasNext())
            {
              localObject8 = (TroopMemberListActivity.a)((Iterator)localObject7).next();
              if (!((aptw)localObject6).gM(((TroopMemberListActivity.a)localObject8).uin)) {
                if ((this.rw != null) && (this.rw.contains(((TroopMemberListActivity.a)localObject8).uin)))
                {
                  ((TroopMemberListActivity.a)localObject8).isOnline = true;
                  ((List)localObject3).add(localObject8);
                }
                else
                {
                  ((TroopMemberListActivity.a)localObject8).isOnline = false;
                  ((List)localObject4).add(localObject8);
                }
              }
            }
            localObject2.clear();
            Collections.sort((List)localObject3, new TroopMemberListActivity.d(0, false));
            if (((List)localObject3).size() > 0) {
              localObject2.put(TroopMemberListActivity.this.getString(2131721355), localObject3);
            }
            Collections.sort((List)localObject4, new TroopMemberListActivity.d(0, false));
            if (((List)localObject4).size() > 0) {
              localObject2.put(TroopMemberListActivity.this.getString(2131721354), localObject4);
            }
          }
          break label976;
          label4297:
          localObject3[0] = 0;
          i = 1;
          while (i < localObject3.length)
          {
            j = localObject3[i];
            int m = localObject3[(i - 1)];
            localObject3[i] = (((List)localObject2.get(((Iterator)???).next())).size() + m + 1 + j);
            i += 1;
          }
          ??? = localObject2.keySet().iterator();
          i = 0;
          while (((Iterator)???).hasNext())
          {
            localObject4[i] = ((String)((Iterator)???).next());
            i += 1;
          }
          if (TroopMemberListActivity.this.mFrom == 0) {
            TroopMemberListActivity.this.m((int[])localObject3);
          }
          long l2 = System.currentTimeMillis();
          if (QLog.isColorLevel()) {
            QLog.d("TroopMemberListActivityget_troop_member", 2, "constructHashStruct, time:" + (l2 - l1) + ", sortType:" + TroopMemberListActivity.this.BL + ", listSize:" + TroopMemberListActivity.this.pr.size());
          }
          return new Object[] { localObject2, localObject3, localObject4 };
          label4524:
          localObject3 = "#";
          break;
          label4532:
          if ((97 <= i) && (i <= 122)) {
            break label807;
          }
          localObject4 = "#";
          break label814;
          label4555:
          localObject2 = localObject4;
          break label976;
          label4562:
          c = 'A';
          break label1375;
          label4568:
          c = (char)(c + '\001');
          break label1375;
          label4576:
          i -= 1;
          break label1691;
          label4583:
          i -= 1;
          break label2000;
          label4590:
          i -= 1;
          break label2280;
          break label976;
          label4600:
          i += 1;
          break label3070;
          label4607:
          i += 1;
          break label3134;
          label4614:
          i += 1;
          break label3198;
          label4621:
          break label976;
          label4624:
          break label976;
        }
        i -= 1;
      }
    }
    
    public int getCount()
    {
      if (TroopMemberListActivity.this.mFrom == 9) {
        if (TroopMemberListActivity.this.pr != null) {}
      }
      while (this.ad.length == 0)
      {
        return 0;
        return TroopMemberListActivity.this.pr.size();
      }
      int i = this.ad[(this.ad.length - 1)];
      return ((List)this.D.get(this.k[(this.k.length - 1)])).size() + i + 1;
    }
    
    public Object getItem(int paramInt)
    {
      Object localObject2 = null;
      Object localObject1;
      if (TroopMemberListActivity.this.mFrom == 9)
      {
        localObject1 = localObject2;
        if (paramInt >= 0)
        {
          localObject1 = localObject2;
          if (paramInt <= TroopMemberListActivity.this.pr.size() - 1) {
            localObject1 = TroopMemberListActivity.this.pr.get(paramInt);
          }
        }
      }
      do
      {
        return localObject1;
        i = Arrays.binarySearch(this.ad, paramInt);
        localObject1 = localObject2;
      } while (i >= 0);
      int i = -(i + 1) - 1;
      return (TroopMemberListActivity.a)((List)this.D.get(this.k[i])).get(paramInt - this.ad[i] - 1);
    }
    
    public long getItemId(int paramInt)
    {
      return 0L;
    }
    
    public int getItemViewType(int paramInt)
    {
      if (TroopMemberListActivity.e(TroopMemberListActivity.this))
      {
        int i = Arrays.binarySearch(this.ad, paramInt);
        if (i < 0)
        {
          i = -(i + 1) - 1;
          TroopMemberListActivity.a locala = (TroopMemberListActivity.a)((List)this.D.get(this.k[i])).get(paramInt - this.ad[i] - 1);
          if ((TextUtils.isEmpty(locala.aRl)) && (!TextUtils.isEmpty(locala.aRo)) && (!TextUtils.isEmpty(locala.nickname)) && (!locala.nickname.equals(locala.aRo))) {
            return 1;
          }
        }
      }
      return 0;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      boolean bool = true;
      int i = getItemViewType(paramInt);
      Object localObject1;
      label67:
      Object localObject2;
      if (paramView == null) {
        if (i == 0)
        {
          localObject1 = TroopMemberListActivity.this.mLayoutInflater.inflate(2131563264, paramViewGroup, false);
          paramView = new TroopMemberListActivity.h((View)localObject1, false);
          if (!TroopMemberListActivity.this.aYy) {
            break label282;
          }
          paramView.b.setBackgroundResource(2130839642);
          ((View)localObject1).setTag(paramView);
          localObject2 = paramView;
          paramView = (View)localObject1;
          localObject1 = localObject2;
          label83:
          ((TroopMemberListActivity.h)localObject1).uin = "";
          if (TroopMemberListActivity.this.mFrom != 9) {
            break label307;
          }
          localObject2 = (TroopMemberListActivity.a)TroopMemberListActivity.this.pr.get(paramInt);
          ((TroopMemberListActivity.h)localObject1).Gr.setTag(((TroopMemberListActivity.a)localObject2).uin);
          ((TroopMemberListActivity.h)localObject1).uM.setTag(((TroopMemberListActivity.a)localObject2).uin);
          ((TroopMemberListActivity.h)localObject1).vz.setTag(((TroopMemberListActivity.a)localObject2).uin);
          ((TroopMemberListActivity.h)localObject1).b.setTag(Integer.valueOf(paramInt));
          TroopMemberListActivity.this.a((TroopMemberListActivity.h)localObject1, (TroopMemberListActivity.a)localObject2, e(((TroopMemberListActivity.a)localObject2).uin, 2), false, false);
          label195:
          if ((((TroopMemberListActivity.h)localObject1).vC != null) && (TroopMemberListActivity.this.b != null))
          {
            if (TroopMemberListActivity.this.b.getVisibility() != 0) {
              break label1094;
            }
            ((TroopMemberListActivity.h)localObject1).vC.setVisibility(0);
          }
        }
      }
      for (;;)
      {
        EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
        return paramView;
        localObject1 = TroopMemberListActivity.this.mLayoutInflater.inflate(2131563268, paramViewGroup, false);
        paramView = new TroopMemberListActivity.h((View)localObject1, true);
        break;
        label282:
        paramView.b.setBackgroundResource(2130839639);
        break label67;
        localObject1 = (TroopMemberListActivity.h)paramView.getTag();
        break label83;
        label307:
        int j = Arrays.binarySearch(this.ad, paramInt);
        if (j < 0)
        {
          j = -(j + 1) - 1;
          localObject2 = (TroopMemberListActivity.a)((List)this.D.get(this.k[j])).get(paramInt - this.ad[j] - 1);
          ((TroopMemberListActivity.h)localObject1).Gr.setTag(((TroopMemberListActivity.a)localObject2).uin);
          ((TroopMemberListActivity.h)localObject1).uM.setTag(((TroopMemberListActivity.a)localObject2).uin);
          ((TroopMemberListActivity.h)localObject1).vz.setTag(((TroopMemberListActivity.a)localObject2).uin);
          ((TroopMemberListActivity.h)localObject1).b.setTag(Integer.valueOf(paramInt));
          Object localObject3;
          if (((TroopMemberListActivity.a)localObject2).bbC)
          {
            localObject3 = new aofe(((TroopMemberListActivity.a)localObject2).displayName, 16).k();
            ((TroopMemberListActivity.h)localObject1).fe.setText((CharSequence)localObject3);
            aqpm.a(TroopMemberListActivity.this.app, ((TroopMemberListActivity.h)localObject1).fe, (Spannable)localObject3);
            ((TroopMemberListActivity.h)localObject1).pQ.setImageResource(2130840081);
            ((TroopMemberListActivity.h)localObject1).b.setOnClickListener(TroopMemberListActivity.this.cn);
            if (TroopMemberListActivity.this.mFrom == 12)
            {
              if (!this.rt.contains(localObject2)) {
                break label605;
              }
              ((TroopMemberListActivity.h)localObject1).eL.setVisibility(0);
            }
          }
          for (;;)
          {
            if (!TroopMemberListActivity.this.bbo) {
              break label618;
            }
            ((TroopMemberListActivity.h)localObject1).vD.setVisibility(8);
            break;
            localObject3 = TroopMemberListActivity.this;
            Bitmap localBitmap = e(((TroopMemberListActivity.a)localObject2).uin, 2);
            if (i == 1) {}
            for (;;)
            {
              ((TroopMemberListActivity)localObject3).a((TroopMemberListActivity.h)localObject1, (TroopMemberListActivity.a)localObject2, localBitmap, false, bool);
              break;
              bool = false;
            }
            label605:
            ((TroopMemberListActivity.h)localObject1).eL.setVisibility(8);
          }
          label618:
          if (TroopMemberListActivity.this.jdField_a_of_type_Alud == null) {
            break label195;
          }
          TroopMemberListActivity.this.jdField_a_of_type_Alud.a((TroopMemberListActivity.h)localObject1, (TroopMemberListActivity.a)localObject2);
          if (((TroopMemberListActivity.h)localObject1).vD.getVisibility() != 0) {
            break label195;
          }
          i = VipUtils.km(2);
          ((TroopMemberListActivity.h)localObject1).fe.setMaxWidth(i);
          TroopMemberListActivity.b(TroopMemberListActivity.this.app, ((TroopMemberListActivity.h)localObject1).fe, ((TroopMemberListActivity.h)localObject1).vB, ((TroopMemberListActivity.a)localObject2).uin, i);
          break label195;
        }
        ((TroopMemberListActivity.h)localObject1).b.TS(false);
        ((TroopMemberListActivity.h)localObject1).b.setVisibility(8);
        ((TroopMemberListActivity.h)localObject1).Gm.setVisibility(8);
        ((TroopMemberListActivity.h)localObject1).eL.setVisibility(8);
        ((TroopMemberListActivity.h)localObject1).b.setOnClickListener(null);
        ((TroopMemberListActivity.h)localObject1).Gr.setTag("");
        ((TroopMemberListActivity.h)localObject1).uM.setTag("");
        ((TroopMemberListActivity.h)localObject1).vz.setTag("");
        ((TroopMemberListActivity.h)localObject1).b.setTag(Integer.valueOf(-1));
        if ((TroopMemberListActivity.this.mFrom == 9) || (TroopMemberListActivity.this.mFrom == 19))
        {
          ((TroopMemberListActivity.h)localObject1).Gn.setVisibility(8);
          label826:
          if (TroopMemberListActivity.this.mFrom == 12)
          {
            localObject2 = (List)this.D.get(this.k[j]);
            i = paramInt - this.ad[j] - 1;
            if ((i >= 0) && (i < ((List)localObject2).size()))
            {
              localObject2 = (TroopMemberListActivity.a)((List)localObject2).get(i);
              if (!this.rt.contains(localObject2)) {
                break label1081;
              }
              ((TroopMemberListActivity.h)localObject1).eL.setVisibility(0);
            }
          }
        }
        for (;;)
        {
          ((TroopMemberListActivity.h)localObject1).b.setContentDescription("");
          break;
          ((TroopMemberListActivity.h)localObject1).Gn.setVisibility(0);
          localObject2 = (List)this.D.get(this.k[j]);
          if (localObject2 == null) {
            break label826;
          }
          if (TroopMemberListActivity.this.getString(2131721452).equals(String.valueOf(this.k[j])))
          {
            ((TroopMemberListActivity.h)localObject1).Gn.setText(String.valueOf(this.k[j]));
            break label826;
          }
          ((TroopMemberListActivity.h)localObject1).Gn.setText(String.valueOf(this.k[j]) + TroopMemberListActivity.this.getString(2131721950, new Object[] { Integer.valueOf(((List)localObject2).size()) }));
          break label826;
          label1081:
          ((TroopMemberListActivity.h)localObject1).eL.setVisibility(8);
        }
        label1094:
        ((TroopMemberListActivity.h)localObject1).vC.setVisibility(8);
      }
    }
    
    public int getViewTypeCount()
    {
      return 2;
    }
    
    public int m(String paramString)
    {
      int i;
      if (this.k != null)
      {
        i = 0;
        if (i >= this.k.length) {
          break label53;
        }
        if (!this.k[i].equals(paramString)) {}
      }
      for (;;)
      {
        if (i >= 0)
        {
          return this.ad[i];
          i += 1;
          break;
        }
        return -1;
        return -1;
        label53:
        i = -1;
      }
    }
    
    public boolean t(int paramInt)
    {
      if (TroopMemberListActivity.this.mFrom == 9) {}
      while (Arrays.binarySearch(this.ad, paramInt) < 0) {
        return false;
      }
      return true;
    }
  }
  
  public static class d
    implements Comparator<TroopMemberListActivity.a>
  {
    int BL = -1;
    boolean bbD = false;
    
    public d(int paramInt, boolean paramBoolean)
    {
      this.BL = paramInt;
      this.bbD = paramBoolean;
    }
    
    public int a(TroopMemberListActivity.a parama1, TroopMemberListActivity.a parama2)
    {
      int i = -1;
      int k = 1;
      int j = 1;
      if (this.BL == 0) {
        i = parama1.pinyinFirst.compareToIgnoreCase(parama2.pinyinFirst);
      }
      label89:
      do
      {
        do
        {
          do
          {
            do
            {
              return i;
              if (this.BL != 2) {
                break label89;
              }
              if (parama1.Hr == parama2.Hr) {
                return 0;
              }
              if (parama1.Hr <= parama2.Hr) {
                break;
              }
            } while (this.bbD);
            return 1;
            if (this.bbD) {}
            for (i = j;; i = -1) {
              return i;
            }
            if (this.BL != 3) {
              break label149;
            }
            if (parama1.Hq == parama2.Hq) {
              return 0;
            }
            if (parama1.Hq <= parama2.Hq) {
              break;
            }
          } while (this.bbD);
          return 1;
          if (this.bbD) {}
          for (i = k;; i = -1) {
            return i;
          }
          if (this.BL != 1) {
            break label208;
          }
          if (parama1.bLX != parama2.bLX) {
            break;
          }
          j = parama1.displayName.compareToIgnoreCase(parama2.displayName);
          if (j == 0) {
            return 0;
          }
        } while (j <= 0);
        return 1;
      } while (parama1.bLX >= parama2.bLX);
      label149:
      return 1;
      label208:
      if (this.BL == 8)
      {
        if (parama1.bMb == parama2.bMb) {
          return parama1.pinyinFirst.compareToIgnoreCase(parama2.pinyinFirst);
        }
        return parama2.bMb - parama1.bMb;
      }
      return 0;
    }
  }
  
  public class e
    extends abeg
  {
    public List<TroopMemberListActivity.a> mList;
    
    public e()
    {
      super(TroopMemberListActivity.this.app, TroopMemberListActivity.this.o, 1, true);
      Object localObject;
      this.mList = localObject;
    }
    
    public int getCount()
    {
      if (this.mList == null) {
        return 0;
      }
      return this.mList.size();
    }
    
    public Object getItem(int paramInt)
    {
      if ((paramInt >= 0) && (paramInt < this.mList.size())) {
        return this.mList.get(paramInt);
      }
      return null;
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public int getItemViewType(int paramInt)
    {
      if (TroopMemberListActivity.e(TroopMemberListActivity.this))
      {
        TroopMemberListActivity.a locala = (TroopMemberListActivity.a)this.mList.get(paramInt);
        if ((TextUtils.isEmpty(locala.aRl)) && (!TextUtils.isEmpty(locala.aRo)) && (!TextUtils.isEmpty(locala.nickname)) && (!locala.nickname.equals(locala.aRo))) {
          return 1;
        }
      }
      return 0;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      int i = getItemViewType(paramInt);
      Object localObject1;
      Object localObject2;
      label59:
      boolean bool;
      if (paramView == null) {
        if (i == 0)
        {
          localObject1 = TroopMemberListActivity.this.mLayoutInflater.inflate(2131563264, paramViewGroup, false);
          paramView = new TroopMemberListActivity.h((View)localObject1, false);
          ((View)localObject1).setTag(paramView);
          localObject2 = paramView;
          paramView = (View)localObject1;
          localObject1 = localObject2;
          localObject2 = (TroopMemberListActivity.a)this.mList.get(paramInt);
          ((TroopMemberListActivity.h)localObject1).Gr.setTag(((TroopMemberListActivity.a)localObject2).uin);
          ((TroopMemberListActivity.h)localObject1).uM.setTag(((TroopMemberListActivity.a)localObject2).uin);
          ((TroopMemberListActivity.h)localObject1).vz.setTag(((TroopMemberListActivity.a)localObject2).uin);
          ((TroopMemberListActivity.h)localObject1).b.setTag(Integer.valueOf(paramInt));
          TroopMemberListActivity localTroopMemberListActivity = TroopMemberListActivity.this;
          Bitmap localBitmap = a(1, ((TroopMemberListActivity.a)localObject2).uin);
          if (i != 1) {
            break label343;
          }
          bool = true;
          label152:
          localTroopMemberListActivity.a((TroopMemberListActivity.h)localObject1, (TroopMemberListActivity.a)localObject2, localBitmap, true, bool);
          if (TroopMemberListActivity.this.mFrom == 12)
          {
            if (!TroopMemberListActivity.this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$c.rt.contains(localObject2)) {
              break label349;
            }
            ((TroopMemberListActivity.h)localObject1).eL.setVisibility(0);
          }
        }
      }
      for (;;)
      {
        if (TroopMemberListActivity.this.jdField_a_of_type_Alud != null)
        {
          TroopMemberListActivity.this.jdField_a_of_type_Alud.a((TroopMemberListActivity.h)localObject1, (TroopMemberListActivity.a)localObject2);
          if (((TroopMemberListActivity.h)localObject1).vD.getVisibility() == 0)
          {
            i = VipUtils.km(2);
            ((TroopMemberListActivity.h)localObject1).fe.setMaxWidth(i);
            TroopMemberListActivity.b(TroopMemberListActivity.this.app, ((TroopMemberListActivity.h)localObject1).fe, ((TroopMemberListActivity.h)localObject1).vB, ((TroopMemberListActivity.a)localObject2).uin, i);
          }
        }
        EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
        return paramView;
        localObject1 = TroopMemberListActivity.this.mLayoutInflater.inflate(2131563268, paramViewGroup, false);
        paramView = new TroopMemberListActivity.h((View)localObject1, true);
        break;
        localObject1 = (TroopMemberListActivity.h)paramView.getTag();
        break label59;
        label343:
        bool = false;
        break label152;
        label349:
        ((TroopMemberListActivity.h)localObject1).eL.setVisibility(8);
      }
    }
    
    public int getViewTypeCount()
    {
      return 2;
    }
  }
  
  public class f
    implements Comparator<TroopMemberListActivity.a>
  {
    public f() {}
    
    public int a(TroopMemberListActivity.a parama1, TroopMemberListActivity.a parama2)
    {
      return parama1.aRg.compareToIgnoreCase(parama2.aRg);
    }
  }
  
  public class g
    implements TextWatcher
  {
    protected g() {}
    
    public void afterTextChanged(Editable paramEditable)
    {
      paramEditable = TroopMemberListActivity.this.ay.getText().toString().trim();
      TroopMemberListActivity.this.vv(paramEditable);
    }
    
    public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
    
    public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  }
  
  public static class h
    extends abeg.a
  {
    public TextView Gm;
    public TextView Gn;
    public TextView Go;
    public TextView Gp;
    public TextView Gq;
    public TextView Gr;
    public TextView Gs;
    public TextView Gt;
    public TextView Gu;
    public TroopHonorView a;
    public TroopMemberListSlideItem b;
    public boolean bbE;
    public ImageView eL;
    public TextView fe;
    public LinearLayout gF;
    public TextView lA;
    public View uM;
    public View vA;
    public View vB;
    public View vC;
    public View vD;
    public View vz;
    
    public h(View paramView, boolean paramBoolean)
    {
      this.Gm = ((TextView)paramView.findViewById(2131380704));
      this.Gn = ((TextView)paramView.findViewById(2131380761));
      this.b = ((TroopMemberListSlideItem)paramView.findViewById(2131380336));
      this.vz = paramView.findViewById(2131378486);
      this.uM = paramView.findViewById(2131365684);
      this.vA = paramView.findViewById(2131365685);
      this.pQ = ((ImageView)paramView.findViewById(2131369767));
      if ((this.pQ instanceof ThemeImageView)) {
        ((ThemeImageView)this.pQ).setSupportMaskView(false);
      }
      this.Go = ((TextView)paramView.findViewById(2131380801));
      this.Gp = ((TextView)paramView.findViewById(2131380802));
      this.fe = ((TextView)paramView.findViewById(2131380814));
      this.vB = paramView.findViewById(2131380904);
      this.gF = ((LinearLayout)paramView.findViewById(2131369808));
      this.Gq = ((TextView)paramView.findViewById(2131380551));
      this.Gr = ((TextView)paramView.findViewById(2131363898));
      this.vC = paramView.findViewById(2131377326);
      this.Gs = ((TextView)paramView.findViewById(2131381279));
      this.Gt = ((TextView)paramView.findViewById(2131362978));
      this.eL = ((ImageView)paramView.findViewById(2131364585));
      this.Gu = ((TextView)paramView.findViewById(2131380737));
      this.vD = paramView.findViewById(2131362205);
      this.a = ((TroopHonorView)paramView.findViewById(2131380290));
      if (paramBoolean) {
        this.lA = ((TextView)paramView.findViewById(2131377105));
      }
      this.bbE = false;
    }
  }
  
  public static class i
    extends abeg.a
  {
    public TextView Gn;
    public TextView fe;
    public RelativeLayout hk;
    public View lo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopMemberListActivity
 * JD-Core Version:    0.7.0.1
 */