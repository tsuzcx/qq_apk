package com.tencent.mobileqq.troop.homework.entry.ui;

import acfp;
import acms;
import acnd;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.util.SparseArrayCompat;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import ankt;
import apgk;
import apgy;
import apgz;
import aphc;
import aphg;
import aphh;
import aphi;
import aphj;
import aphk;
import aphl;
import aphm;
import aphn;
import apho;
import aphp;
import aphq;
import aphr;
import aphs;
import apht;
import aphu;
import aphv;
import aphw;
import aphx;
import aphy;
import apii;
import apij;
import apio;
import apip;
import apiq;
import apkl;
import apkm;
import apkn;
import apko;
import apkp;
import apks;
import apku;
import apkv;
import aple;
import aprc;
import aptl;
import aptl.a;
import apuh;
import aqfr;
import aqha;
import aqhu;
import aqhv;
import aqik;
import aqiw;
import aqju;
import arhz;
import aurd;
import ausj;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.audiopanel.CommonRecordSoundPanel;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.troop.homework.entry.ui.view.InputMethodGuard;
import com.tencent.mobileqq.troop.homework.entry.ui.view.InputMethodGuard.a;
import com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.Pair;
import cooperation.troop_homework.jsp.TroopHWJsPlugin;
import java.io.File;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.TimeZone;
import java.util.TreeSet;
import mqq.manager.TicketManager;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import wja;

public class PublishHomeWorkFragment
  extends IphoneTitleBarFragment
  implements View.OnClickListener, InputMethodGuard.a
{
  protected ArrayList<String> BX;
  protected List<Pair<Integer, View>> HR = new LinkedList();
  protected List<String> HS;
  protected View Im;
  protected View In;
  protected apgk a;
  public apij a;
  protected arhz a;
  protected b a;
  public InputMethodGuard a;
  public XMediaEditor a;
  public String aFT;
  protected Boolean aI = Boolean.valueOf(true);
  protected FormSimpleItem aJ;
  public FormSimpleItem aK;
  protected long agy;
  protected ausj aq;
  protected long arA;
  public long arB;
  protected acnd b;
  protected apgk b;
  public CommonRecordSoundPanel b;
  protected TroopManager b;
  protected EditText bB;
  public FormSwitchItem bu;
  protected acms c;
  protected SparseArrayCompat<apip> c;
  public boolean cQA;
  public boolean cQB;
  protected boolean cQC;
  protected boolean cQD;
  public boolean cQE;
  protected boolean cQF;
  public boolean cQG;
  protected boolean cQH;
  public boolean cQI;
  protected boolean cQJ;
  public boolean cQx = true;
  protected boolean cQy;
  protected boolean cQz;
  public String cps = "";
  protected String cpt;
  protected String cpv;
  protected String cpw;
  public ViewGroup eB;
  protected ViewGroup eC;
  protected ViewGroup eD;
  protected ViewGroup eE;
  protected ViewGroup eF;
  public QQAppInterface mApp;
  protected int mMode = 1;
  protected BroadcastReceiver mReceiver = new aphr(this);
  protected int mRetryCount;
  protected View mRoot;
  public String mTroopUin = "";
  
  public PublishHomeWorkFragment()
  {
    this.jdField_c_of_type_AndroidSupportV4UtilSparseArrayCompat = new SparseArrayCompat();
  }
  
  private void D(int paramInt1, int paramInt2, Intent paramIntent)
  {
    int i = 0;
    while (i < this.jdField_c_of_type_AndroidSupportV4UtilSparseArrayCompat.size())
    {
      ((apip)this.jdField_c_of_type_AndroidSupportV4UtilSparseArrayCompat.get(this.jdField_c_of_type_AndroidSupportV4UtilSparseArrayCompat.keyAt(i))).onActivityResult(paramInt1, paramInt2, paramIntent);
      i += 1;
    }
  }
  
  private void RI(boolean paramBoolean)
  {
    int i = 0;
    while (i < this.jdField_c_of_type_AndroidSupportV4UtilSparseArrayCompat.size())
    {
      ((apip)this.jdField_c_of_type_AndroidSupportV4UtilSparseArrayCompat.get(this.jdField_c_of_type_AndroidSupportV4UtilSparseArrayCompat.keyAt(i))).RK(paramBoolean);
      i += 1;
    }
  }
  
  private void WL(int paramInt)
  {
    int i = 0;
    while (i < this.jdField_c_of_type_AndroidSupportV4UtilSparseArrayCompat.size())
    {
      ((apip)this.jdField_c_of_type_AndroidSupportV4UtilSparseArrayCompat.get(this.jdField_c_of_type_AndroidSupportV4UtilSparseArrayCompat.keyAt(i))).WM(paramInt);
      i += 1;
    }
  }
  
  protected static View a(Context paramContext, int paramInt1, String paramString, int paramInt2, View.OnClickListener paramOnClickListener, Object paramObject)
  {
    LinearLayout localLinearLayout = new LinearLayout(paramContext);
    localLinearLayout.setClickable(true);
    localLinearLayout.setGravity(16);
    localLinearLayout.setBackgroundResource(2130844628);
    Object localObject = new LinearLayout.LayoutParams(-2, ankt.dip2px(42.0F));
    ((LinearLayout.LayoutParams)localObject).setMargins(ankt.dip2px(12.0F), 0, 0, 0);
    localLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = new TextView(paramContext);
    ((TextView)localObject).setTextColor(Color.parseColor("#5E6379"));
    ((TextView)localObject).setTextSize(1, 14.0F);
    ((TextView)localObject).setText(paramString);
    ((TextView)localObject).setBackgroundColor(0);
    paramString = new LinearLayout.LayoutParams(-2, -2);
    paramString.setMargins(ankt.dip2px(12.0F), 0, ankt.dip2px(24.0F), 0);
    ((TextView)localObject).setLayoutParams(paramString);
    if (paramInt2 > 0)
    {
      paramContext = new ImageView(paramContext);
      paramContext.setScaleType(ImageView.ScaleType.CENTER_CROP);
      paramContext.setImageResource(paramInt2);
      paramString = new LinearLayout.LayoutParams(ankt.dip2px(21.0F), ankt.dip2px(21.0F));
      paramString.setMargins(ankt.dip2px(24.0F), 0, 0, 0);
      paramContext.setLayoutParams(paramString);
      localLinearLayout.addView(paramContext);
    }
    localLinearLayout.addView((View)localObject);
    localLinearLayout.setOnClickListener(paramOnClickListener);
    localLinearLayout.setTag(new a(paramInt1, paramObject));
    return localLinearLayout;
  }
  
  protected static View a(Context paramContext, int paramInt, String paramString1, String paramString2, CompoundButton.OnCheckedChangeListener paramOnCheckedChangeListener, Object paramObject)
  {
    Object localObject = new LinearLayout.LayoutParams(-1, -2);
    LinearLayout localLinearLayout = new LinearLayout(paramContext);
    localLinearLayout.setOrientation(1);
    localLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = new FormSwitchItem(paramContext);
    ((FormSwitchItem)localObject).setText(paramString1);
    ((FormSwitchItem)localObject).setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
    ((FormSwitchItem)localObject).setBgType(0);
    ((FormSwitchItem)localObject).setOnCheckedChangeListener(paramOnCheckedChangeListener);
    paramContext = new TextView(paramContext);
    paramContext.setTextSize(1, 14.0F);
    paramContext.setTextColor(Color.parseColor("#BBBBBB"));
    paramContext.setPadding(ankt.dip2px(12.0F), 0, ankt.dip2px(12.0F), 0);
    paramString1 = new LinearLayout.LayoutParams(-1, -2);
    paramString1.setMargins(0, ankt.dip2px(2.0F), 0, ankt.dip2px(4.0F));
    paramContext.setLayoutParams(paramString1);
    paramContext.setText(paramString2);
    localLinearLayout.addView((View)localObject);
    localLinearLayout.addView(paramContext);
    localLinearLayout.setTag(new a(paramInt, paramObject));
    return localLinearLayout;
  }
  
  private void a(int paramInt, apip paramapip)
  {
    this.jdField_c_of_type_AndroidSupportV4UtilSparseArrayCompat.put(paramInt, paramapip);
  }
  
  private void agf()
  {
    this.jdField_a_of_type_Apij = apii.a(getActivity());
    this.jdField_a_of_type_Apij.a(new aphi(this));
    this.jdField_a_of_type_Apij.a(new aphj(this));
  }
  
  public static void b(Activity paramActivity, @Nullable Bundle paramBundle, @Nullable String paramString)
  {
    Intent localIntent = new Intent();
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    localBundle.putBoolean("hide_title_left_arrow", true);
    localBundle.putString("PublishHomeWorkFragment:valid", "PublishHomeWorkFragment:valid");
    if (!TextUtils.isEmpty(paramString)) {
      localBundle.putString("extra.GROUP_UIN", paramString);
    }
    localIntent.putExtras(localBundle);
    PublicFragmentActivity.start(paramActivity, localIntent, PublishHomeWorkFragment.class);
  }
  
  private void bJ(JSONObject paramJSONObject)
  {
    int i = 0;
    while (i < this.jdField_c_of_type_AndroidSupportV4UtilSparseArrayCompat.size())
    {
      ((apip)this.jdField_c_of_type_AndroidSupportV4UtilSparseArrayCompat.get(this.jdField_c_of_type_AndroidSupportV4UtilSparseArrayCompat.keyAt(i))).bL(paramJSONObject);
      i += 1;
    }
  }
  
  private void bJf()
  {
    a(2, new apio(this, this.mTroopUin));
    a(1, new apiq(this, this.mTroopUin));
  }
  
  private void c(apgk paramapgk)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("homework_id", Long.toString(paramapgk.ary));
    localBundle.putString("group_id", this.mTroopUin);
    localBundle.putString("title", paramapgk.title);
    String str1;
    String str2;
    if (paramapgk.cQo)
    {
      str1 = "1";
      localBundle.putString("need_feedback", str1);
      localBundle.putString("c", paramapgk.content);
      str2 = getActivity().app.getCurrentUin();
      paramapgk = (TicketManager)this.mApp.getManager(2);
      if (paramapgk == null) {
        break label287;
      }
      str1 = paramapgk.getSkey(str2);
      paramapgk = paramapgk.getPskey(str2, "qun.qq.com");
    }
    for (;;)
    {
      HashMap localHashMap = new HashMap();
      localBundle.putString("bkn", "" + apuh.eU(str1));
      localBundle.putString("Cookie", "uin=o" + str2 + ";skey=" + str1 + ";p_uin=o" + str2 + ";p_skey=" + paramapgk);
      localHashMap.put("BUNDLE", localBundle);
      localHashMap.put("CONTEXT", this.mApp.getApp().getApplicationContext());
      new aprc("https://qun.qq.com/cgi-bin/homework/hw/modify_hw.fcg", "POST", new aphs(this), 1000, null).J(localHashMap);
      return;
      str1 = "0";
      break;
      label287:
      paramapgk = null;
      str1 = null;
    }
  }
  
  private boolean cN(long paramLong)
  {
    long l = System.currentTimeMillis() / 1000L;
    if (this.jdField_a_of_type_Apij != null)
    {
      if (paramLong < l + 1L) {
        QQToast.a(getActivity(), 2131699694, 0).show();
      }
    }
    else {
      return false;
    }
    return true;
  }
  
  private void d(apgk paramapgk)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("group_id", this.mTroopUin);
    localBundle.putString("course_id", "0");
    if (!this.cps.isEmpty())
    {
      localBundle.putString("course_name", this.cps);
      localBundle.putString("title", paramapgk.title);
      if (!paramapgk.cQo) {
        break label236;
      }
    }
    int i;
    label236:
    for (String str1 = "1";; str1 = "0")
    {
      localBundle.putString("need_feedback", str1);
      localBundle.putString("c", paramapgk.content);
      localBundle.putString("team_id", "0");
      localBundle.putString("hw_type", "0");
      localBundle.putString("tsfeedback", String.valueOf(this.arB));
      if ((paramapgk.HM == null) || (paramapgk.HM.size() <= 0)) {
        break label287;
      }
      str1 = "[";
      i = 0;
      while (i < paramapgk.HM.size() - 1)
      {
        str1 = str1 + String.valueOf(paramapgk.HM.get(i)) + ",";
        i += 1;
      }
      localBundle.putString("course_name", acfp.m(2131699640));
      break;
    }
    localBundle.putString("syncgids", str1 + String.valueOf(paramapgk.HM.get(i)) + "]");
    label287:
    String str2 = getActivity().app.getCurrentUin();
    paramapgk = (TicketManager)this.mApp.getManager(2);
    if (paramapgk != null)
    {
      str1 = paramapgk.getSkey(str2);
      paramapgk = paramapgk.getPskey(str2, "qun.qq.com");
    }
    for (;;)
    {
      HashMap localHashMap = new HashMap();
      localBundle.putString("bkn", "" + apuh.eU(str1));
      localBundle.putString("Cookie", "uin=o" + str2 + ";skey=" + str1 + ";p_uin=o" + str2 + ";p_skey=" + paramapgk);
      localHashMap.put("BUNDLE", localBundle);
      localHashMap.put("CONTEXT", this.mApp.getApp().getApplicationContext());
      new aprc("https://qun.qq.com/cgi-bin/homework/hw/assign_hw.fcg", "POST", new apht(this), 1000, null).J(localHashMap);
      return;
      paramapgk = null;
      str1 = null;
    }
  }
  
  private void dZy()
  {
    int i = 0;
    while (i < this.jdField_c_of_type_AndroidSupportV4UtilSparseArrayCompat.size())
    {
      ((apip)this.jdField_c_of_type_AndroidSupportV4UtilSparseArrayCompat.get(this.jdField_c_of_type_AndroidSupportV4UtilSparseArrayCompat.keyAt(i))).initUI();
      i += 1;
    }
  }
  
  public static void k(QQAppInterface paramQQAppInterface, Context paramContext, String paramString)
  {
    aptl localaptl = aptl.a();
    Object localObject2 = localaptl.getUrl("troop_create_homework");
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = "https://qun.qq.com/homework/features/sethomework.html?_wv=5123&_bid=2146#role=teacher&gid=<$GC>&content=<$CONTENT>&type=word&from=<$FROM>";
    }
    localObject2 = new aptl.a();
    ((aptl.a)localObject2).crf = paramString;
    ((aptl.a)localObject2).from = "aio";
    ((aptl.a)localObject2).content = "";
    paramString = localaptl.a((String)localObject1, (aptl.a)localObject2);
    if (paramString != null)
    {
      if (!paramString.startsWith("mqqapi://")) {
        break label100;
      }
      paramQQAppInterface = aqik.c(paramQQAppInterface, paramContext, paramString);
      if (paramQQAppInterface != null) {
        paramQQAppInterface.ace();
      }
    }
    label100:
    do
    {
      return;
      paramQQAppInterface = new Intent(paramContext, QQBrowserActivity.class);
      paramQQAppInterface.putExtra("finish_animation_up_down", true);
      paramQQAppInterface.putExtra("url", paramString);
      paramContext.startActivity(paramQQAppInterface);
    } while (!(paramContext instanceof Activity));
    ((Activity)paramContext).overridePendingTransition(2130772367, 2130772002);
  }
  
  private void u(JSONArray paramJSONArray)
  {
    int i = 0;
    while (i < this.jdField_c_of_type_AndroidSupportV4UtilSparseArrayCompat.size())
    {
      ((apip)this.jdField_c_of_type_AndroidSupportV4UtilSparseArrayCompat.get(this.jdField_c_of_type_AndroidSupportV4UtilSparseArrayCompat.keyAt(i))).v(paramJSONArray);
      i += 1;
    }
  }
  
  public void RJ(boolean paramBoolean)
  {
    int i;
    if (paramBoolean)
    {
      View localView = this.Im;
      if (this.cQx)
      {
        i = 0;
        localView.setVisibility(i);
        this.eF.setVisibility(8);
      }
    }
    for (;;)
    {
      RI(paramBoolean);
      return;
      i = 8;
      break;
      this.Im.setVisibility(8);
      ThreadManager.getUIHandler().postDelayed(new PublishHomeWorkFragment.20(this), 20L);
    }
  }
  
  protected void SR(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      if (paramString.has("c"))
      {
        paramString = paramString.getJSONArray("c");
        if (paramString != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.setDataByEdit(paramString);
          ThreadManager.getUIHandler().postDelayed(new PublishHomeWorkFragment.4(this), 550L);
        }
      }
      else
      {
        paramString = new IllegalArgumentException("home work json format error");
        if (QLog.isColorLevel())
        {
          QLog.e("PublishHomeWorkFragment", 2, paramString, new Object[0]);
          return;
        }
      }
    }
    catch (JSONException paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.e("PublishHomeWorkFragment", 2, "parse homework json error", paramString);
      }
    }
  }
  
  public void SS(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PublishHomeWorkFragment", 2, "prepareBeginnerGuide");
    }
    if (TextUtils.isEmpty(paramString)) {}
    label300:
    do
    {
      do
      {
        for (;;)
        {
          return;
          apgz localapgz = this.jdField_b_of_type_ComTencentMobileqqAppTroopManager.a;
          SharedPreferences localSharedPreferences = getActivity().getSharedPreferences("PublishHomeWorkFragment:homework_troop", 0);
          if (localapgz != null) {
            if ((aphc.cph.equals(paramString)) && (localapgz.cQs))
            {
              try
              {
                if (!localSharedPreferences.getBoolean(fM(4), true)) {
                  continue;
                }
                paramString = new File(new URL(localapgz.coW).getFile()).getName();
                paramString = new apgy(this.mApp, localapgz.coW, paramString, localapgz.coX);
                if (QLog.isColorLevel()) {
                  QLog.d("PublishHomeWorkFragment", 2, "prepareBeginnerGuide start download for recite");
                }
                paramString.a(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiPublishHomeWorkFragment$b, 4, true);
                return;
              }
              catch (Exception paramString) {}
              if (QLog.isColorLevel()) {
                QLog.d("PublishHomeWorkFragment", 2, "download manager init error ", paramString);
              }
            }
            else
            {
              if ((!aphc.cpi.equals(paramString)) || (!localapgz.cQt)) {
                break label300;
              }
              try
              {
                if (localSharedPreferences.getBoolean(fM(7), true))
                {
                  paramString = new File(new URL(localapgz.coY).getFile()).getName();
                  paramString = new apgy(this.mApp, localapgz.coY, paramString, localapgz.coZ);
                  if (QLog.isColorLevel()) {
                    QLog.d("PublishHomeWorkFragment", 2, "prepareBeginnerGuide start download for arithmetic");
                  }
                  paramString.a(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiPublishHomeWorkFragment$b, 7, true);
                  return;
                }
              }
              catch (Exception paramString) {}
            }
          }
        }
      } while (!QLog.isColorLevel());
      QLog.d("PublishHomeWorkFragment", 2, "download manager init error ", paramString);
      return;
    } while (!QLog.isColorLevel());
    QLog.d("PublishHomeWorkFragment", 2, "prepareBeginnerGuide course not match");
  }
  
  public void W(int paramInt, String paramString1, String paramString2)
  {
    label63:
    String str2;
    switch (paramInt)
    {
    default: 
      this.cpt = "";
      this.cQH = false;
      this.cpv = paramString1;
      this.cpw = paramString2;
      if (this.mTroopUin == null)
      {
        paramString2 = "";
        str2 = this.cpt;
        if (!this.cQH) {
          break label212;
        }
        if (this.cpv != null) {
          break label204;
        }
        paramString1 = "";
        label86:
        if (this.mMode != 1) {
          break label233;
        }
      }
      break;
    }
    label204:
    label212:
    label233:
    for (String str1 = "1";; str1 = "2")
    {
      aqfr.b("Grp_edu", "homework", "CreateHw_Show", 0, 0, new String[] { paramString2, str2, paramString1, str1 });
      return;
      this.cpt = "classteacher";
      this.cQH = true;
      break;
      this.cpt = "teacher";
      this.cQH = true;
      break;
      this.cpt = "parent";
      this.cQH = false;
      break;
      this.cpt = "student";
      this.cQH = false;
      break;
      paramString2 = this.mTroopUin;
      break label63;
      paramString1 = this.cpv;
      break label86;
      if (this.cpw == null)
      {
        paramString1 = "";
        break label86;
      }
      paramString1 = this.cpw;
      break label86;
    }
  }
  
  public void WK(int paramInt)
  {
    int i = 0;
    boolean bool = ((apip)this.jdField_c_of_type_AndroidSupportV4UtilSparseArrayCompat.get(paramInt)).aBf();
    if ((bool) && (paramInt == 1)) {
      if (this.jdField_a_of_type_Apij != null)
      {
        this.aK.setVisibility(0);
        if (this.mMode == 1)
        {
          if (this.arB == 0L)
          {
            apii localapii = (apii)this.jdField_a_of_type_Apij.a();
            this.arB = apii.hu();
            this.aK.setRightText(Y(this.arB));
          }
          this.aK.setClickable(true);
        }
      }
      else
      {
        if (!bool) {
          break label232;
        }
        this.bu.setEnabled(false);
        this.bu.setChecked(true);
      }
    }
    for (;;)
    {
      if (i >= this.jdField_c_of_type_AndroidSupportV4UtilSparseArrayCompat.size()) {
        return;
      }
      ((apip)this.jdField_c_of_type_AndroidSupportV4UtilSparseArrayCompat.get(this.jdField_c_of_type_AndroidSupportV4UtilSparseArrayCompat.keyAt(i))).ca(paramInt, bool);
      i += 1;
      continue;
      if (this.jdField_a_of_type_Apgk.arx != 0L) {
        this.aK.setRightText(Y(this.jdField_a_of_type_Apgk.arx));
      }
      this.aK.setClickable(false);
      break;
      this.arB = 0L;
      this.aK.setRightText("");
      this.aK.setVisibility(8);
      break;
      label232:
      this.bu.setEnabled(true);
    }
  }
  
  public String Y(long paramLong)
  {
    Object localObject3 = Calendar.getInstance();
    ((Calendar)localObject3).setTimeInMillis(1000L * paramLong);
    ((Calendar)localObject3).setTimeZone(TimeZone.getTimeZone("GMT+8:00"));
    int i = ((Calendar)localObject3).get(1);
    int j = ((Calendar)localObject3).get(2);
    int k = ((Calendar)localObject3).get(5);
    ((Calendar)localObject3).get(7);
    Object localObject2 = String.valueOf(((Calendar)localObject3).get(11));
    Object localObject1 = localObject2;
    if (localObject2 != null)
    {
      localObject1 = localObject2;
      if (((String)localObject2).length() == 1) {
        localObject1 = "0" + (String)localObject2;
      }
    }
    localObject3 = String.valueOf(((Calendar)localObject3).get(12));
    localObject2 = localObject3;
    if (localObject3 != null)
    {
      localObject2 = localObject3;
      if (((String)localObject3).length() == 1) {
        localObject2 = "0" + (String)localObject3;
      }
    }
    return String.valueOf(i) + acfp.m(2131699696) + String.valueOf(j + 1) + acfp.m(2131699695) + String.valueOf(k) + acfp.m(2131699693) + " " + (String)localObject1 + ":" + (String)localObject2;
  }
  
  protected <T extends View> T a(Class<T> paramClass, View paramView)
  {
    if (paramView == null) {}
    for (;;)
    {
      return null;
      if (paramClass.isInstance(paramView)) {
        return (View)paramClass.cast(paramView);
      }
      if ((paramView instanceof ViewGroup))
      {
        paramView = (ViewGroup)paramView;
        int j = paramView.getChildCount();
        int i = 0;
        while (i < j)
        {
          View localView = a(paramClass, paramView.getChildAt(i));
          if (localView != null) {
            return localView;
          }
          i += 1;
        }
      }
    }
  }
  
  protected EditText a(View paramView)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    if (paramView == null) {
      localObject2 = localObject1;
    }
    int j;
    int i;
    label38:
    do
    {
      return localObject2;
      if (!(paramView instanceof ViewGroup)) {
        break;
      }
      j = ((ViewGroup)paramView).getChildCount();
      i = 0;
      localObject1 = localObject2;
      localObject2 = localObject1;
    } while (i >= j);
    localObject2 = a(((ViewGroup)paramView).getChildAt(i));
    if (localObject2 != null) {
      localObject1 = localObject2;
    }
    for (;;)
    {
      i += 1;
      break label38;
      localObject2 = localObject1;
      if (!(paramView instanceof EditText)) {
        break;
      }
      localObject2 = localObject1;
      if (!paramView.isFocused()) {
        break;
      }
      return (EditText)paramView;
    }
  }
  
  public XMediaEditor a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor;
  }
  
  @NonNull
  protected List<String> a(apku paramapku)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramapku != null)
    {
      if (!(paramapku instanceof apkv)) {
        break label50;
      }
      localArrayList.add(acfp.m(2131710271) + "");
    }
    label50:
    do
    {
      return localArrayList;
      if ((paramapku instanceof apks))
      {
        localArrayList.add(acfp.m(2131710254) + "");
        return localArrayList;
      }
      if ((paramapku instanceof apkm))
      {
        localArrayList.add(acfp.m(2131710260) + "");
        return localArrayList;
      }
      if ((paramapku instanceof apkl))
      {
        localArrayList.add(acfp.m(2131710264) + "");
        return localArrayList;
      }
    } while (!(paramapku instanceof apkp));
    localArrayList.add(acfp.m(2131710268) + "");
    return localArrayList;
  }
  
  protected void a(int paramInt, ArrayList<apku> paramArrayList, apgk paramapgk)
  {
    if (paramInt == 0)
    {
      paramapgk = new ArrayList();
      Iterator localIterator = paramArrayList.iterator();
      while (localIterator.hasNext()) {
        paramapgk.addAll(a((apku)localIterator.next()));
      }
      paramapgk = new ArrayList(new TreeSet(paramapgk));
      if (paramapgk.isEmpty())
      {
        paramapgk = "";
        if (this.mRetryCount != 0) {
          break label277;
        }
        this.mRetryCount += 1;
        if ((this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor != null) && (!paramArrayList.isEmpty())) {
          this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.fb(paramArrayList);
        }
        paramArrayList = getString(2131699715, new Object[] { paramapgk });
        QQToast.a(getActivity(), paramArrayList, 0).show();
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PublishHomeWorkFragment", 2, "Error, reason_code = " + paramInt + ", print trace: ", new RuntimeException("UPLOAD_ERROR"));
      }
      return;
      if (paramapgk.size() == 1)
      {
        paramapgk = (String)paramapgk.get(0);
        break;
      }
      paramapgk = (String)paramapgk.get(0) + "、" + (String)paramapgk.get(1) + acfp.m(2131710252);
      break;
      label277:
      paramArrayList = getString(2131699713, new Object[] { paramapgk });
      QQToast.a(getActivity(), paramArrayList, 0).show();
      continue;
      if (paramInt == 1) {
        QQToast.a(getActivity(), 2131699677, 0).show();
      } else if (paramInt == 3) {
        QQToast.a(getActivity(), 2131699709, 0).show();
      } else if (paramInt == 2) {
        QQToast.a(getActivity(), 2131696281, 0).show();
      }
    }
  }
  
  public void a(apgk paramapgk)
  {
    int i = 0;
    this.jdField_a_of_type_Apgk = paramapgk;
    paramapgk = paramapgk.content;
    for (;;)
    {
      try
      {
        paramapgk = new JSONObject(paramapgk).getJSONArray("c");
        if (i < paramapgk.length())
        {
          JSONObject localJSONObject = paramapgk.getJSONObject(i);
          if (localJSONObject != null) {
            bJ(localJSONObject);
          }
        }
        else
        {
          SR(new JSONObject().put("c", paramapgk).toString());
          if ((this.bB != null) && (this.bB.getText().toString().isEmpty()))
          {
            this.bB.setText(this.jdField_a_of_type_Apgk.title);
            this.bB.setFocusable(false);
            this.bB.setFocusableInTouchMode(false);
          }
          return;
        }
      }
      catch (Exception paramapgk)
      {
        return;
      }
      i += 1;
    }
  }
  
  boolean aBd()
  {
    boolean bool2 = true;
    boolean bool1;
    try
    {
      Object localObject = new JSONArray(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.getData());
      int i = ((JSONArray)localObject).length();
      if (i <= 0) {
        return true;
      }
      if (i == 1)
      {
        localObject = ((JSONArray)localObject).getJSONObject(0);
        if (localObject != null)
        {
          String str = ((JSONObject)localObject).getString("type");
          bool1 = bool2;
          if (TextUtils.isEmpty(str)) {
            return bool1;
          }
          if ("str".equals(str))
          {
            boolean bool3 = TextUtils.isEmpty(((JSONObject)localObject).getString("text"));
            bool1 = bool2;
            if (bool3) {
              return bool1;
            }
          }
        }
      }
      return false;
    }
    catch (Exception localException)
    {
      bool1 = false;
    }
    return bool1;
  }
  
  List<Pair<Integer, View>> aW(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    if ((this.jdField_b_of_type_ComTencentMobileqqAppTroopManager != null) && (this.jdField_b_of_type_ComTencentMobileqqAppTroopManager.a != null))
    {
      if (!aphc.cph.equals(paramString)) {
        break label110;
      }
      if (this.jdField_b_of_type_ComTencentMobileqqAppTroopManager.a.cQs)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PublishHomeWorkFragment", 2, "add special entry for recite");
        }
        localArrayList.add(new Pair(Integer.valueOf(1), a(getActivity(), 4, acfp.m(2131710250), 2130840718, new aphp(this), null)));
      }
    }
    label110:
    while ((!aphc.cpi.equals(paramString)) || (!this.jdField_b_of_type_ComTencentMobileqqAppTroopManager.a.cQt)) {
      return localArrayList;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PublishHomeWorkFragment", 2, "add special entry for arithmetic");
    }
    localArrayList.add(new Pair(Integer.valueOf(2), a(getActivity(), 7, acfp.m(2131710272), acfp.m(2131710259), new aphq(this), null)));
    return localArrayList;
  }
  
  List<View> am(int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.HR.iterator();
    while (localIterator.hasNext())
    {
      Pair localPair = (Pair)localIterator.next();
      if ((localPair != null) && (localPair.second != null) && (((View)localPair.second).getTag() != null) && ((((View)localPair.second).getTag() instanceof a)) && (((a)((View)localPair.second).getTag()).dUi == paramInt)) {
        localArrayList.add(localPair.second);
      }
    }
    return localArrayList;
  }
  
  protected void am(int paramInt)
  {
    try
    {
      if (!getActivity().isFinishing())
      {
        if (this.jdField_a_of_type_Arhz == null)
        {
          this.jdField_a_of_type_Arhz = new arhz(getActivity(), getActivity().getTitleBarHeight());
          this.jdField_a_of_type_Arhz.setCancelable(false);
          this.jdField_a_of_type_Arhz.show();
        }
        this.jdField_a_of_type_Arhz.setMessage(paramInt);
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void b(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    this.cQA = paramBoolean;
    if (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor != null) {}
    for (int i = this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.jI(4);; i = 0)
    {
      if ((i > 0) && (!paramBoolean))
      {
        this.bu.setChecked(true);
        this.cQA = true;
        QQToast.a(getActivity(), 0, acfp.m(2131710248), 1).show();
      }
      Object localObject;
      do
      {
        do
        {
          return;
          localObject = am(7);
        } while ((localObject == null) || (((List)localObject).isEmpty()));
        localObject = (FormSwitchItem)a(FormSwitchItem.class, (View)((List)localObject).get(0));
      } while ((localObject == null) || (!((FormSwitchItem)localObject).isChecked()) || (this.cQA));
      aqju localaqju = aqha.a(getActivity(), 230);
      localaqju.setMessage(acfp.m(2131710267)).setNegativeButton(acfp.m(2131710270), new aphl(this)).setPositiveButton(acfp.m(2131710265), new aphk(this, (FormSwitchItem)localObject, paramCompoundButton));
      this.cQA = true;
      paramCompoundButton.setChecked(true);
      localaqju.show();
      return;
    }
  }
  
  protected void b(apgk paramapgk)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.dS();
    ArrayList localArrayList2;
    if ((localObject != null) && (!((ArrayList)localObject).isEmpty()))
    {
      ArrayList localArrayList1 = new ArrayList();
      localArrayList2 = new ArrayList();
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        apku localapku = (apku)((Iterator)localObject).next();
        if (localapku != null) {
          if (localapku.sz() == 1) {
            localArrayList1.add(localapku);
          } else if ((localapku.sz() == 2) || (localapku.sz() == 0)) {
            localArrayList2.add(localapku);
          }
        }
      }
      if (!localArrayList1.isEmpty()) {
        eZ(localArrayList1);
      }
    }
    do
    {
      return;
      if (!localArrayList2.isEmpty())
      {
        a(0, localArrayList2, paramapgk);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.e("PublishHomeWorkFragment", 2, "UPLOAD_ERROR_UNKNOWN_ERROR: unknown error list");
      }
      a(3, localArrayList2, paramapgk);
      return;
      if (paramapgk == null) {
        break;
      }
      am(2131699692);
      if (this.mMode == 1)
      {
        d(paramapgk);
        return;
      }
    } while (this.mMode != 2);
    c(paramapgk);
    return;
    if (QLog.isColorLevel()) {
      QLog.e("PublishHomeWorkFragment", 2, "UPLOAD_ERROR_UNKNOWN_ERROR: homework info is null");
    }
    a(3, null, paramapgk);
  }
  
  protected void b(Pair<Integer, View> paramPair)
  {
    if ((this.eE == null) || (paramPair == null)) {
      return;
    }
    switch (((Integer)paramPair.first).intValue())
    {
    default: 
      return;
    case 1: 
      this.eE.addView((View)paramPair.second);
      return;
    }
    this.eD.addView((View)paramPair.second, 0);
  }
  
  public void bD(boolean paramBoolean, int paramInt)
  {
    if (paramBoolean)
    {
      dZH();
      return;
    }
    if (paramInt == 10022)
    {
      a(1, null, null);
      return;
    }
    if (paramInt == 1002)
    {
      a(2, null, null);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e("PublishHomeWorkFragment", 2, "UPLOAD_ERROR_UNKNOWN_ERROR: server error " + paramInt);
    }
    a(3, null, null);
  }
  
  public void bE(boolean paramBoolean, int paramInt)
  {
    this.cQy = true;
    this.eE.setVisibility(8);
    ThreadManager.getUIHandler().postDelayed(new PublishHomeWorkFragment.19(this), 10L);
    RJ(paramBoolean);
    View localView = this.In;
    if (paramBoolean) {}
    for (paramInt = 8;; paramInt = 0)
    {
      localView.setVisibility(paramInt);
      if (aphc.cpi.equals(this.cps)) {
        this.In.setVisibility(8);
      }
      return;
    }
  }
  
  public void bF()
  {
    if ((this.jdField_a_of_type_Arhz != null) && (this.jdField_a_of_type_Arhz.isShowing())) {}
    try
    {
      this.jdField_a_of_type_Arhz.dismiss();
      label24:
      this.jdField_a_of_type_Arhz = null;
      return;
    }
    catch (Exception localException)
    {
      break label24;
    }
  }
  
  protected void dP(int paramInt, String paramString)
  {
    if (paramInt == 7) {
      if (this.cQB)
      {
        if (this.mTroopUin != null) {
          break label63;
        }
        localObject = "";
        aqfr.b("Grp_edu", "homework", paramString, 0, 0, new String[] { localObject, this.cpt, "1", "{\"type\":\"calculation\"}" });
      }
    }
    label63:
    ArrayList localArrayList;
    JSONArray localJSONArray;
    do
    {
      return;
      localObject = this.mTroopUin;
      break;
      localArrayList = this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.w(paramInt);
      localJSONArray = new JSONArray();
      localObject = localArrayList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        apkn localapkn = (apkn)((Iterator)localObject).next();
        if (localapkn != null) {
          localJSONArray.put(localapkn.af());
        }
      }
    } while (localArrayList.isEmpty());
    if (this.mTroopUin == null) {}
    for (Object localObject = "";; localObject = this.mTroopUin)
    {
      aqfr.b("Grp_edu", "homework", paramString, 0, 0, new String[] { localObject, this.cpt, String.valueOf(localArrayList.size()), localJSONArray.toString() });
      return;
    }
  }
  
  public void dZA()
  {
    if (this.cps == null) {
      this.cps = "";
    }
    if (!TextUtils.isEmpty(this.cps))
    {
      if (QLog.isColorLevel()) {
        QLog.d("PublishHomeWorkFragment", 2, "检测到你是" + this.cps + "老师，将按照需求定制入口");
      }
      List localList = aW(this.cps);
      if (localList != null)
      {
        this.HR.clear();
        this.HR.addAll(localList);
      }
    }
  }
  
  protected void dZB()
  {
    if (this.mContentView == null) {}
    for (;;)
    {
      return;
      this.mRoot = findViewById(2131373823);
      this.In = findViewById(2131380285);
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiViewInputMethodGuard = ((InputMethodGuard)findViewById(2131369299));
      this.eB = ((ViewGroup)getActivity().getLayoutInflater().inflate(2131560812, null, false));
      this.bB = ((EditText)this.eB.findViewById(2131373812));
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor = ((XMediaEditor)findViewById(2131373822));
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.setHeaderView(this.eB);
      this.Im = findViewById(2131363698);
      this.eC = ((ViewGroup)findViewById(2131378627));
      this.eE = ((ViewGroup)findViewById(2131378626));
      this.eD = ((ViewGroup)findViewById(2131378625));
      this.eF = ((ViewGroup)findViewById(2131365085));
      this.aJ = ((FormSimpleItem)findViewById(2131373818));
      this.aJ.setOnClickListener(this);
      this.aK = ((FormSimpleItem)findViewById(2131373825));
      this.aK.setVisibility(8);
      this.aK.setOnClickListener(this);
      this.bu = ((FormSwitchItem)findViewById(2131373819));
      this.bu.setChecked(true);
      this.bu.setOnClickListener(this);
      this.cQA = this.bu.isChecked();
      this.bu.setOnCheckedChangeListener(new aphu(this));
      dZy();
      if (this.mMode == 2)
      {
        this.aJ.setVisibility(8);
        this.bu.setVisibility(8);
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiViewInputMethodGuard.setOnInputMethodChangeListener(this);
      View localView = findViewById(2131373820);
      if (localView != null) {
        localView.setOnClickListener(this);
      }
      localView = findViewById(2131373828);
      if (localView != null) {
        localView.setOnClickListener(this);
      }
      localView = findViewById(2131373834);
      if (localView != null) {
        localView.setOnClickListener(this);
      }
      if (this.jdField_a_of_type_Apij == null) {
        try
        {
          agf();
          if ((this.jdField_a_of_type_Apij.a() instanceof apii))
          {
            apii.a(this.jdField_a_of_type_Apij, (apii)this.jdField_a_of_type_Apij.a());
            return;
          }
        }
        catch (Throwable localThrowable) {}
      }
    }
  }
  
  protected void dZC()
  {
    Bundle localBundle = getArguments();
    if (localBundle != null)
    {
      String str = localBundle.getString("extra.GROUP_UIN");
      this.mMode = localBundle.getInt("publish_homework_mode", 1);
      this.arA = localBundle.getLong("hw_id", 0L);
      if (this.mMode == 1) {
        this.cQE = localBundle.getBoolean("BeginnerGuideFragment:from_beginner_guide", false);
      }
      if (!TextUtils.isEmpty(str))
      {
        this.mTroopUin = str;
        if (QLog.isColorLevel()) {
          QLog.d("PublishHomeWorkFragment", 2, "uin: " + str);
        }
        dZD();
        lN(8000L);
        if (this.mMode == 1) {
          this.jdField_c_of_type_Acms.eY(this.mTroopUin, this.mApp.getCurrentUin());
        }
        if (this.mMode == 2)
        {
          if (this.arA > 0L)
          {
            am(2131699686);
            this.jdField_c_of_type_Acms.hR(this.arA);
          }
        }
        else {
          return;
        }
        QQToast.a(getActivity(), 2131699711, 0).show();
        getActivity().finish();
        return;
      }
      QQToast.a(getActivity(), 2131699711, 0).show();
      getActivity().finish();
      return;
    }
    QQToast.a(getActivity(), 2131699711, 0).show();
    getActivity().finish();
  }
  
  public void dZD()
  {
    Message localMessage = Message.obtain();
    localMessage.what = 513;
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiPublishHomeWorkFragment$b.sendMessage(localMessage);
  }
  
  protected void dZE()
  {
    Object localObject;
    if (!this.HR.isEmpty())
    {
      localObject = this.HR.iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
      } while (((Integer)((Pair)((Iterator)localObject).next()).first).intValue() != 1);
    }
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        RJ(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiViewInputMethodGuard.aBe());
        if ((this.eC.getVisibility() == 8) || (this.eC.getHeight() <= 0))
        {
          localObject = Message.obtain();
          ((Message)localObject).what = 514;
          this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiPublishHomeWorkFragment$b.sendMessageDelayed((Message)localObject, 100L);
        }
        this.eC.setVisibility(0);
        return;
      }
      this.eC.setVisibility(8);
      return;
    }
  }
  
  protected void dZF()
  {
    if ((this.cQz) || (this.HR == null) || (this.HR.isEmpty())) {
      return;
    }
    Iterator localIterator = this.HR.iterator();
    while (localIterator.hasNext()) {
      b((Pair)localIterator.next());
    }
    this.cQz = true;
  }
  
  public void dZG()
    throws JSONException
  {
    Object localObject3 = new JSONArray(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.getData());
    JSONArray localJSONArray = new JSONArray();
    int j = ((JSONArray)localObject3).length();
    String str;
    if (this.mTroopUin == null)
    {
      localObject1 = "";
      str = this.cpt;
      if (this.mMode != 1) {
        break label136;
      }
    }
    label136:
    for (Object localObject2 = "1";; localObject2 = "2")
    {
      aqfr.b("Grp_edu", "homework", "CreateHw_Sub", 0, 0, new String[] { localObject1, str, localObject2 });
      int i = 0;
      while (i < j)
      {
        localObject1 = ((JSONArray)localObject3).optJSONObject(i);
        if (w((JSONObject)localObject1)) {
          localJSONArray.put(localObject1);
        }
        i += 1;
      }
      localObject1 = this.mTroopUin;
      break;
    }
    if (localJSONArray.length() <= 0)
    {
      QQToast.a(getActivity(), 2131699672, 0).show();
      return;
    }
    if (this.BX.contains(this.mTroopUin)) {
      this.BX.remove(this.mTroopUin);
    }
    Object localObject1 = new apgk();
    ((apgk)localObject1).uin = 0L;
    ((apgk)localObject1).title = this.bB.getText().toString();
    if (TextUtils.isEmpty(((apgk)localObject1).title.trim()))
    {
      QQToast.a(getActivity(), 2131699673, 0).show();
      return;
    }
    if (!aqiw.isNetworkAvailable(getActivity()))
    {
      QQToast.a(getActivity(), 0, 2131696270, 0).show();
      return;
    }
    try
    {
      ((apgk)localObject1).uin = Long.parseLong(getActivity().app.getCurrentUin());
      if (TextUtils.isEmpty(this.mTroopUin))
      {
        ((apgk)localObject1).arw = 0L;
        localObject2 = new ArrayList();
        localObject3 = this.BX.iterator();
        for (;;)
        {
          if (((Iterator)localObject3).hasNext())
          {
            ((List)localObject2).add(Long.valueOf(Long.parseLong((String)((Iterator)localObject3).next())));
            continue;
            if (!this.cQB) {
              break;
            }
          }
        }
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    for (;;)
    {
      localJSONArray.put(new JSONObject("{\"type\":\"calculation\"}"));
      u(localJSONArray);
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("c", localJSONArray);
      ((apgk)localObject1).cQo = this.cQA;
      ((apgk)localObject1).content = localJSONObject.toString();
      if (this.mMode == 2)
      {
        ((apgk)localObject1).ary = this.arA;
        ((apgk)localObject1).cQo = this.jdField_a_of_type_Apgk.cQo;
      }
      this.jdField_b_of_type_Apgk = ((apgk)localObject1);
      b((apgk)localObject1);
      return;
      ((apgk)localObject1).arw = Long.parseLong(this.mTroopUin);
      break;
      ((apgk)localObject1).HM = localJSONObject;
    }
  }
  
  public void dZH()
  {
    try
    {
      if (this.mTroopUin != null) {
        break label393;
      }
      str1 = "";
      str3 = this.cpt;
      if (this.jdField_b_of_type_Apgk != null) {
        break label401;
      }
      localObject = "";
      label26:
      if (!this.cQA) {
        break label456;
      }
      str2 = "1";
    }
    catch (Exception localException)
    {
      label393:
      for (;;)
      {
        String str1;
        String str3;
        Object localObject;
        label89:
        continue;
        label143:
        label401:
        label436:
        label444:
        label456:
        String str2 = "0";
      }
    }
    aqfr.b("Grp_edu", "homework", "CreateHw_Complete", 0, 0, new String[] { str1, str3, localObject, str2 });
    if (this.cQI)
    {
      if (this.mTroopUin == null)
      {
        localObject = "";
        aqfr.b("Grp_edu", "homework", "CreateHw_EditTitle", 0, 0, new String[] { localObject });
      }
    }
    else
    {
      WL(1);
      if ((this.jdField_b_of_type_Apgk != null) && (this.jdField_b_of_type_Apgk.cQo))
      {
        if (this.mTroopUin != null) {
          break label436;
        }
        localObject = "";
        aqfr.b("Grp_edu", "homework", "CreateHw_Sub_Open", 0, 0, new String[] { localObject, this.cpt });
      }
      if ((this.jdField_b_of_type_Apgk != null) && (this.jdField_b_of_type_Apgk.HM != null) && (!this.jdField_b_of_type_Apgk.HM.isEmpty())) {
        if (this.mTroopUin != null) {
          break label444;
        }
      }
    }
    for (localObject = "";; localObject = this.mTroopUin)
    {
      aqfr.b("Grp_edu", "homework", "CreateHw_CopyGrp", 0, 0, new String[] { localObject, this.cpt, String.valueOf(this.jdField_b_of_type_Apgk.HM.size()) });
      dP(1, "CreateHw_Pic");
      dP(2, "CreateHw_Video");
      dP(3, "CreateHw_Voice");
      dP(7, "CreateHw_Calculate");
      dP(4, "CreateHw_Recite");
      QQToast.a(getActivity(), 2131699684, 0).show();
      localObject = wja.a(new Intent(getActivity(), SplashActivity.class), new int[] { 2 });
      ((Intent)localObject).addFlags(268435456);
      ((Intent)localObject).putExtra("uin", this.mTroopUin);
      ((Intent)localObject).putExtra("uintype", 1);
      getActivity().startActivity((Intent)localObject);
      getActivity().overridePendingTransition(2130772002, 2130772369);
      return;
      str1 = this.mTroopUin;
      break;
      if (this.jdField_b_of_type_Apgk.content == null)
      {
        localObject = "";
        break label26;
      }
      localObject = this.jdField_b_of_type_Apgk.content;
      break label26;
      localObject = this.mTroopUin;
      break label89;
      localObject = this.mTroopUin;
      break label143;
    }
  }
  
  protected void dZI()
  {
    if (!TextUtils.isEmpty(this.mTroopUin)) {
      HomeWorkTroopSelectorFragment.a(getActivity(), this.mTroopUin, this.BX);
    }
  }
  
  protected void dZJ()
  {
    if (this.aq == null)
    {
      this.aq = ausj.b(getActivity());
      this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel = ((CommonRecordSoundPanel)getActivity().getLayoutInflater().inflate(2131560053, null));
      this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel.setBackgroundColor(-1);
      this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel.a(this.mApp, getActivity(), this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiPublishHomeWorkFragment$b);
      this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel.setTimeOutTime(360000);
      this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel.setMinimumHeight((int)(ankt.cIE * 0.3F));
      this.aq.addView(this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel);
      this.aq.setAnimationTime(50);
      this.aq.getActionContentView().setGravity(17);
      this.aq.a(new aphm(this));
    }
    this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel.reset();
    this.aq.setOutsideDismissEnableCompat(true);
    aurd.cE(getActivity());
    this.aq.show();
  }
  
  protected void dZK()
  {
    this.aq.dismiss();
  }
  
  public void dZL()
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiPublishHomeWorkFragment$b.postDelayed(new PublishHomeWorkFragment.17(this), 400L);
  }
  
  protected void dZz()
  {
    this.mTroopUin = "";
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiPublishHomeWorkFragment$b = new b(this, Looper.getMainLooper());
    this.cQA = false;
    this.BX = new ArrayList();
    this.HS = new ArrayList();
    if (getActivity() == null)
    {
      localObject = null;
      this.mApp = ((QQAppInterface)localObject);
      if (this.mApp != null) {
        break label91;
      }
      getActivity().finish();
    }
    label91:
    do
    {
      return;
      localObject = (QQAppInterface)getActivity().getAppInterface();
      break;
      this.jdField_c_of_type_Acms = ((acms)this.mApp.getBusinessHandler(20));
      this.jdField_b_of_type_ComTencentMobileqqAppTroopManager = ((TroopManager)this.mApp.getManager(52));
      this.jdField_b_of_type_Acnd = new apho(this);
      this.mApp.addObserver(this.jdField_b_of_type_Acnd);
    } while (this.cQJ);
    this.cQJ = true;
    Object localObject = new IntentFilter();
    ((IntentFilter)localObject).addAction("tencent.av.v2q.StartVideoChat");
    ((IntentFilter)localObject).addAction("android.intent.action.PHONE_STATE");
    getActivity().registerReceiver(this.mReceiver, (IntentFilter)localObject);
  }
  
  protected void dd(String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {}
    try
    {
      if (("recite".equals(new JSONObject(paramString).getString("type"))) && (this.bu != null)) {
        this.bu.setChecked(true);
      }
      return;
    }
    catch (Exception paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("PublishHomeWorkFragment", 2, "onSpecialHomeWorkChanged error ", paramString);
    }
  }
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    getActivity().getWindow().setSoftInputMode(16);
    dZz();
    dZC();
    bJf();
    dZB();
    postInitUI();
    if (BaseApplicationImpl.sProcessId != 9) {
      SubmitHomeWorkFragment.cn(getActivity());
    }
  }
  
  protected void eZ(@NonNull ArrayList<apku> paramArrayList)
  {
    ArrayList localArrayList = new ArrayList();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext()) {
      localArrayList.addAll(a((apku)paramArrayList.next()));
    }
    paramArrayList = new ArrayList(new TreeSet(localArrayList));
    if (paramArrayList.isEmpty()) {
      paramArrayList = "";
    }
    for (;;)
    {
      paramArrayList = getString(2131699715, new Object[] { paramArrayList });
      QQToast.a(getActivity(), paramArrayList, 0).show();
      return;
      if (paramArrayList.size() == 1) {
        paramArrayList = (String)paramArrayList.get(0);
      } else {
        paramArrayList = (String)paramArrayList.get(0) + "、" + (String)paramArrayList.get(1) + acfp.m(2131710263);
      }
    }
  }
  
  public String fM(int paramInt)
  {
    return this.mApp.getCurrentUin() + "_" + "PublishHomeWorkFragment:show_beginner_guide" + "_" + paramInt;
  }
  
  public <T extends View> T findViewById(int paramInt)
  {
    return this.mContentView.findViewById(paramInt);
  }
  
  public int getContentLayoutId()
  {
    return 2131560813;
  }
  
  public int getMode()
  {
    return this.mMode;
  }
  
  protected void gk(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PublishHomeWorkFragment", 2, "onBeginnerGuidePrepared at " + paramString);
    }
    if (!isResumed()) {
      return;
    }
    BeginnerGuideFragment.e(getActivity(), getArguments(), paramInt);
    paramString = getActivity().getSharedPreferences("PublishHomeWorkFragment:homework_troop", 0).edit();
    paramString.putBoolean(fM(paramInt), false);
    paramString.apply();
    aurd.cE(getActivity());
  }
  
  protected void hX(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PublishHomeWorkFragment", 2, "onPictureBtnClick");
    }
    int i = this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.jI(1);
    int j = this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.jI(2) + i;
    if (j >= 10)
    {
      if (System.currentTimeMillis() - this.agy >= 2000L)
      {
        QQToast.a(getActivity(), acfp.m(2131710253) + 10 + acfp.m(2131710257), 0).show();
        this.agy = System.currentTimeMillis();
      }
      return;
    }
    if (Build.VERSION.SDK_INT >= 23) {
      if ((getActivity().checkSelfPermission("android.permission.READ_EXTERNAL_STORAGE") == 0) && (getActivity().checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0)) {
        i = 1;
      }
    }
    for (;;)
    {
      if (i == 0)
      {
        getActivity().requestPermissions(new aphg(this, j), 3, new String[] { "android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE" });
        return;
        i = 0;
      }
      else
      {
        paramView = TroopHWJsPlugin.a(10 - j, getActivity(), this.mApp.getCurrentAccountUin());
        paramView.putExtra("HomeWorkConstants:homework_request_code_key", 259);
        startActivityForResult(paramView, 259);
        aurd.cE(getActivity());
        return;
        i = 1;
      }
    }
  }
  
  protected void hY(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PublishHomeWorkFragment", 2, "onVideoBtnClick");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.jI(1) + this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.jI(2) >= 10)
    {
      if (System.currentTimeMillis() - this.agy >= 2000L)
      {
        QQToast.a(getActivity(), acfp.m(2131710249) + 10 + acfp.m(2131710266), 0).show();
        this.agy = System.currentTimeMillis();
      }
      return;
    }
    int i;
    if (Build.VERSION.SDK_INT >= 23) {
      if (getActivity().checkSelfPermission("android.permission.CAMERA") == 0) {
        i = 1;
      }
    }
    for (;;)
    {
      if (i == 0)
      {
        getActivity().requestPermissions(new aphh(this), 3, new String[] { "android.permission.CAMERA" });
        return;
        i = 0;
      }
      else
      {
        this.aFT = TroopHWJsPlugin.c(getActivity(), 260);
        aurd.cE(getActivity());
        return;
        i = 1;
      }
    }
  }
  
  protected void hZ(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PublishHomeWorkFragment", 2, "onRecordBtnClick");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.jI(3) >= 6)
    {
      if (System.currentTimeMillis() - this.agy >= 2000L)
      {
        QQToast.a(getActivity(), acfp.m(2131710251) + 6 + acfp.m(2131710258), 0).show();
        this.agy = System.currentTimeMillis();
      }
      return;
    }
    dZJ();
  }
  
  protected void ia(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PublishHomeWorkFragment", 2, "onClickSelectTime");
    }
    if (this.jdField_a_of_type_Apij == null) {}
    try
    {
      agf();
      if ((this.jdField_a_of_type_Apij.a() instanceof apii)) {
        apii.a(this.jdField_a_of_type_Apij, (apii)this.jdField_a_of_type_Apij.a());
      }
      this.jdField_a_of_type_Apij.show();
      return;
    }
    catch (Throwable paramView) {}
  }
  
  protected void lN(long paramLong)
  {
    Message localMessage = Message.obtain();
    localMessage.what = 515;
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiPublishHomeWorkFragment$b.sendMessageDelayed(localMessage, paramLong);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    boolean bool = false;
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (QLog.isColorLevel()) {
      QLog.d("PublishHomeWorkFragment", 2, new Object[] { "onActivityResult. requestCode=", Integer.valueOf(paramInt1), ", resultCode=", Integer.valueOf(paramInt2) });
    }
    switch (paramInt1)
    {
    }
    for (;;)
    {
      D(paramInt1, paramInt2, paramIntent);
      return;
      Object localObject;
      if ((paramIntent != null) && (paramInt2 == 257))
      {
        int i = paramIntent.getIntExtra("HomeWorkConstants:homework_default_index_key", -2147483648);
        localObject = paramIntent.getStringExtra("HomeWorkConstants:homework_default_result_key");
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          if (i == -2147483648) {
            break label235;
          }
          this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.dQ(i, (String)localObject);
          this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.invalidate();
        }
      }
      for (;;)
      {
        dd((String)localObject, bool);
        if ((!TextUtils.isEmpty((CharSequence)localObject)) && (QLog.isColorLevel())) {
          QLog.d("PublishHomeWorkFragment", 2, "提交新作业->" + (String)localObject);
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("PublishHomeWorkFragment", 2, "return from entry");
        break;
        label235:
        this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.a(apko.a((String)localObject));
        this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.invalidate();
        bool = true;
      }
      if (paramInt2 == -1)
      {
        if (!aqiw.isNetSupport(getActivity()))
        {
          if (QLog.isColorLevel()) {
            QLog.d("PublishHomeWorkFragment", 2, "no network toast from capture");
          }
          QQToast.a(getActivity(), 2131699442, 0).show();
          return;
        }
        aqhu.cn(getActivity(), this.aFT);
        localObject = new apks(this.aFT);
        this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.a((apkn)localObject);
        continue;
        if ((paramIntent != null) && (paramInt2 == 262))
        {
          localObject = paramIntent.getStringArrayListExtra("HomeWorkConstants:homework_async_uin_list_key");
          ArrayList localArrayList = paramIntent.getStringArrayListExtra("HomeWorkConstants:homework_async_name_list_key");
          if (localObject != null)
          {
            this.BX.clear();
            this.BX.addAll((Collection)localObject);
          }
          if (localArrayList != null)
          {
            this.HS.clear();
            this.HS.addAll(localArrayList);
          }
          if (this.aJ != null) {
            if (this.HS.isEmpty()) {
              this.aJ.setRightText("");
            } else if (this.HS.size() == 1) {
              this.aJ.setRightText((CharSequence)this.HS.get(0));
            } else if (this.HS.size() > 1) {
              this.aJ.setRightText((String)this.HS.get(0) + acfp.m(2131710261) + this.HS.size() + acfp.m(2131710256));
            }
          }
        }
      }
    }
  }
  
  public boolean onBackEvent()
  {
    if (!aBd())
    {
      aqju localaqju = aqha.a(getActivity(), 230);
      aphn localaphn = new aphn(this);
      if (this.mMode == 1) {
        localaqju.setMessage(2131699674);
      }
      for (;;)
      {
        localaqju.setPositiveButton(2131699675, localaphn);
        localaqju.setNegativeButton(2131699670, localaphn);
        localaqju.show();
        aurd.cE(getActivity());
        return true;
        if (this.mMode == 2) {
          localaqju.setMessage(2131699655);
        }
      }
    }
    aurd.cE(getActivity());
    return super.onBackEvent();
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
      hX(paramView);
      continue;
      hY(paramView);
      continue;
      hZ(paramView);
      continue;
      dZI();
      continue;
      ia(paramView);
    }
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    if ((this.jdField_b_of_type_Acnd != null) && (this.mApp != null)) {
      this.mApp.removeObserver(this.jdField_b_of_type_Acnd);
    }
    TroopHWJsPlugin.eDX();
    if (this.cQJ)
    {
      getActivity().unregisterReceiver(this.mReceiver);
      this.cQJ = false;
    }
  }
  
  public void onDetach()
  {
    super.onDetach();
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiPublishHomeWorkFragment$b.removeCallbacksAndMessages(null);
  }
  
  public void onFinish()
  {
    super.onFinish();
    if (!this.cQF) {
      getActivity().overridePendingTransition(2130772002, 2130772369);
    }
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    if (paramIntent == null) {
      return;
    }
    switch (paramIntent.getIntExtra("HomeWorkConstants:homework_request_code_key", 0))
    {
    default: 
      return;
    }
    this.cQD = aple.a(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor, paramIntent, this.cQD);
  }
  
  public void onPause()
  {
    super.onPause();
    aurd.cE(getActivity());
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.aI.booleanValue())
    {
      this.aI = Boolean.valueOf(false);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiPublishHomeWorkFragment$b.postDelayed(new PublishHomeWorkFragment.1(this), 300L);
  }
  
  protected void postInitUI()
  {
    setLeftButton(2131699669, new aphv(this));
    setRightButton(2131699683, new aphw(this));
    if (this.mMode == 1) {
      setTitle(getResources().getString(2131699685));
    }
    for (;;)
    {
      this.bB.setOnFocusChangeListener(new aphx(this));
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.setFocusChangeListener(new aphy(this));
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.setSizeLimit(500);
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.setHint(getString(2131699678));
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.setExtraValue("troopuin", this.mTroopUin);
      if (this.mMode == 1) {
        ThreadManager.getUIHandler().postDelayed(new PublishHomeWorkFragment.9(this), 550L);
      }
      this.bB.setFilters(new InputFilter[] { new InputFilter.LengthFilter(15) });
      dZD();
      return;
      if (this.mMode == 2) {
        setTitle(getResources().getString(2131699658));
      }
    }
  }
  
  public Bundle r()
  {
    Bundle localBundle = new Bundle();
    String str;
    if (this.cpt == null)
    {
      str = "";
      localBundle.putString("reportIdentity", str);
      if (!this.cQH) {
        break label69;
      }
      if (this.cpv != null) {
        break label61;
      }
      str = "";
    }
    for (;;)
    {
      localBundle.putString("reportCourse", str);
      return localBundle;
      str = this.cpt;
      break;
      label61:
      str = this.cpv;
      continue;
      label69:
      if (this.cpw == null) {
        str = "";
      } else {
        str = this.cpw;
      }
    }
  }
  
  protected boolean w(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {}
    String str;
    do
    {
      return false;
      str = paramJSONObject.optString("type");
    } while ((TextUtils.isEmpty(str)) || (("str".equals(str)) && (TextUtils.isEmpty(paramJSONObject.optString("text")))));
    return true;
  }
  
  static class a
  {
    public int dUi;
    public Object fk;
    
    public a(int paramInt, Object paramObject)
    {
      this.dUi = paramInt;
      this.fk = paramObject;
    }
  }
  
  public static class b
    extends Handler
  {
    WeakReference<PublishHomeWorkFragment> ib;
    
    b(PublishHomeWorkFragment paramPublishHomeWorkFragment, Looper paramLooper)
    {
      super();
      this.ib = new WeakReference(paramPublishHomeWorkFragment);
    }
    
    public void handleMessage(Message paramMessage)
    {
      super.handleMessage(paramMessage);
      if (QLog.isColorLevel()) {
        QLog.d("PublishHomeWorkFragment", 2, "handle msg " + paramMessage.what);
      }
      PublishHomeWorkFragment localPublishHomeWorkFragment = (PublishHomeWorkFragment)this.ib.get();
      if ((localPublishHomeWorkFragment == null) || (!localPublishHomeWorkFragment.isAdded())) {
        if (QLog.isColorLevel()) {
          QLog.d("PublishHomeWorkFragment", 2, "reference null");
        }
      }
      do
      {
        return;
        switch (paramMessage.what)
        {
        default: 
          return;
        case 3: 
          localPublishHomeWorkFragment.cQC = true;
          localPublishHomeWorkFragment.aq.setOutsideDismissEnableCompat(false);
          return;
        case 515: 
          QLog.d("PublishHomeWorkFragment", 1, "init data time out");
          localPublishHomeWorkFragment.cQG = true;
          refreshUI();
          return;
        case 513: 
          refreshUI();
          return;
        case 514: 
          localPublishHomeWorkFragment.dZE();
          return;
        case 101: 
          localPublishHomeWorkFragment.cQC = false;
          localPublishHomeWorkFragment.dZK();
          return;
        case 102: 
          int i = (int)localPublishHomeWorkFragment.b.v();
          if (i < 1000)
          {
            QQToast.a(localPublishHomeWorkFragment.getActivity(), acfp.m(2131710262), 0).show();
            localPublishHomeWorkFragment.b.reset();
            return;
          }
          if (!aqiw.isNetSupport(localPublishHomeWorkFragment.getActivity()))
          {
            if (QLog.isColorLevel()) {
              QLog.d("PublishHomeWorkFragment", 2, "no network toast");
            }
            QQToast.a(localPublishHomeWorkFragment.getActivity(), 2131699442, 0).show();
            localPublishHomeWorkFragment.cQC = false;
            localPublishHomeWorkFragment.dZK();
            return;
          }
          paramMessage = paramMessage.obj.toString();
          File localFile = new File(paramMessage);
          if (localFile.exists()) {}
          for (long l = localFile.length();; l = 0L)
          {
            paramMessage = new apkm(paramMessage, null, i / 1000, (int)l, localPublishHomeWorkFragment.mTroopUin);
            localPublishHomeWorkFragment.a.a(paramMessage);
            localPublishHomeWorkFragment.cQC = false;
            localPublishHomeWorkFragment.dZK();
            return;
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d("PublishHomeWorkFragment", 2, "parse config from network success");
        }
      } while ((localPublishHomeWorkFragment.cQG) || (paramMessage.obj == null) || (!(paramMessage.obj instanceof String)));
      localPublishHomeWorkFragment.gk((String)paramMessage.obj, paramMessage.arg1);
    }
    
    void refreshUI()
    {
      PublishHomeWorkFragment localPublishHomeWorkFragment = (PublishHomeWorkFragment)this.ib.get();
      if ((localPublishHomeWorkFragment == null) || ((!localPublishHomeWorkFragment.isAdded()) && (localPublishHomeWorkFragment.bB == null))) {}
      do
      {
        return;
        if (localPublishHomeWorkFragment.cps == null) {
          localPublishHomeWorkFragment.cps = "";
        }
      } while (localPublishHomeWorkFragment.mMode != 1);
      Object localObject = Calendar.getInstance();
      int i = ((Calendar)localObject).get(2) + 1;
      int j = ((Calendar)localObject).get(5);
      localObject = localPublishHomeWorkFragment.getString(2131699659, new Object[] { Integer.valueOf(i), Integer.valueOf(j), localPublishHomeWorkFragment.cps }).trim();
      String str1 = localPublishHomeWorkFragment.getString(2131699659, new Object[] { Integer.valueOf(i), Integer.valueOf(j), "" }).trim();
      String str2 = localPublishHomeWorkFragment.bB.getText().toString();
      if ((TextUtils.isEmpty(str2)) || (str1.equals(str2))) {
        localPublishHomeWorkFragment.bB.setText((CharSequence)localObject);
      }
      localPublishHomeWorkFragment.dZF();
      localPublishHomeWorkFragment.dZE();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.entry.ui.PublishHomeWorkFragment
 * JD-Core Version:    0.7.0.1
 */