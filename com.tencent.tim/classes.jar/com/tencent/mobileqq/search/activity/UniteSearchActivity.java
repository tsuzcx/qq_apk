package com.tencent.mobileqq.search.activity;

import aclj;
import aclk;
import acnk;
import acnl;
import acnm;
import acnn;
import aenl;
import aenm;
import amju;
import amkb;
import amkd;
import amkf;
import amlm;
import amln;
import amlo;
import amlp;
import amlq;
import amlr;
import amls;
import amub;
import amus;
import amxh;
import amxj;
import amxk;
import amxm;
import amxm.a;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.text.style.BackgroundColorSpan;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import anot;
import anpc;
import apuh;
import aqhv;
import aqik;
import aqjb;
import aqoe.a;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.AbstractGifImage;
import com.tencent.logcat.LogcatUtil;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.search.fragment.AssociateSearchWordsFragment;
import com.tencent.mobileqq.search.fragment.AssociateSearchWordsFragment.a;
import com.tencent.mobileqq.search.fragment.GroupSearchFragment;
import com.tencent.mobileqq.search.fragment.SearchEntryFragment;
import com.tencent.mobileqq.search.model.CompleteUrlSpan;
import com.tencent.mobileqq.search.model.HotWordSearchEntryDataModel.GIFInfo;
import com.tencent.mobileqq.search.model.HotWordSearchEntryDataModel.HotSearchItem;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import com.tencent.mobileqq.search.view.QuickPinyinEditText;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.lang.reflect.Method;
import java.net.URLEncoder;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kxm;
import obt;
import org.json.JSONException;
import org.json.JSONObject;

public class UniteSearchActivity
  extends FragmentActivity
  implements amkb, amkf, amxm.a, TextWatcher, TextView.OnEditorActionListener, AssociateSearchWordsFragment.a
{
  private static UniteSearchActivity jdField_a_of_type_ComTencentMobileqqSearchActivityUniteSearchActivity;
  public static HotWordSearchEntryDataModel.HotSearchItem b;
  public static boolean cDe = true;
  public static boolean cDk;
  public static volatile boolean cDl;
  public static String caM;
  public static String caN;
  public static String caO;
  public static int dCE;
  public static int dCJ;
  public static int dCK;
  public static double latitude;
  public static long launchTime;
  public static double longitude;
  public static String mSessionId;
  public static String mVsKey;
  public static long startTime = -1L;
  protected Button C;
  protected ImageView Dt;
  View GS;
  View GT;
  public View GU;
  public acnl a;
  acnm jdField_a_of_type_Acnm;
  public acnn a;
  protected CancelReceiver a;
  final a jdField_a_of_type_ComTencentMobileqqSearchActivityUniteSearchActivity$a = new a();
  public AssociateSearchWordsFragment a;
  public GroupSearchFragment a;
  public SearchEntryFragment a;
  private CharSequence ad;
  protected ImageButton as;
  acnk b;
  public QuickPinyinEditText b;
  public boolean cDj = true;
  public boolean cDm = true;
  private boolean cDn;
  private boolean cDo;
  private boolean cDp;
  public boolean cDq;
  public String caJ;
  private String caP;
  private int dCA = -1;
  public int dCL = 10000;
  final Handler dn = new amlr(this);
  public byte[] fp = null;
  public int from = -1;
  protected FragmentManager mFragmentManager;
  protected Handler mHandler;
  amxm mSoftKeyboardStateHelper;
  public int source;
  
  static
  {
    dCK = -1;
    caN = "";
    caO = "";
    mSessionId = "";
    dCE = -1;
  }
  
  public UniteSearchActivity()
  {
    this.jdField_a_of_type_Acnn = new amlm(this);
    this.jdField_a_of_type_Acnl = new amln(this);
  }
  
  private void Hp(int paramInt)
  {
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.uniteSearch.UniteSearchActivity", 2, "showFragment  fragment=" + paramInt);
        }
        if (this.app == null)
        {
          if (this.app == null)
          {
            localObject1 = getAppRuntime();
            if ((localObject1 instanceof QQAppInterface)) {
              this.app = ((QQAppInterface)localObject1);
            }
          }
          if (this.app == null)
          {
            QLog.e("Q.uniteSearch.UniteSearchActivity", 1, "showFragment() called app == null!");
            finish();
            return;
          }
        }
        if (paramInt == this.dCA) {
          continue;
        }
        this.dCA = paramInt;
        Object localObject1 = this.mFragmentManager.beginTransaction();
        switch (paramInt)
        {
        case 1: 
          this.GS.setVisibility(8);
          this.GT.setVisibility(8);
          this.GU.setVisibility(0);
          amub.a(null, 0, this.from, "0X8009D29", 0, 0, null, null);
          break;
        case 4: 
          if (this.mFragmentManager.findFragmentByTag("search_entry_layout") != null) {
            break label206;
          }
        }
      }
      finally {}
      Se(paramInt);
      label206:
      localObject2.show(this.jdField_a_of_type_ComTencentMobileqqSearchFragmentSearchEntryFragment);
      localObject2.commitAllowingStateLoss();
      this.GS.setVisibility(0);
      this.GT.setVisibility(8);
      this.GU.setVisibility(8);
      continue;
      if (this.mFragmentManager.findFragmentByTag("associated_words") == null) {
        Se(paramInt);
      }
      localObject2.show(this.jdField_a_of_type_ComTencentMobileqqSearchFragmentAssociateSearchWordsFragment);
      localObject2.commitAllowingStateLoss();
      this.GS.setVisibility(8);
      this.GT.setVisibility(0);
      this.GU.setVisibility(8);
    }
  }
  
  public static void a(Activity paramActivity, String paramString, int paramInt1, long paramLong, HotWordSearchEntryDataModel.HotSearchItem paramHotSearchItem, int paramInt2)
  {
    a(paramActivity, paramString, paramInt1, paramLong, paramHotSearchItem, paramInt2, null);
  }
  
  public static void a(Activity paramActivity, String paramString, int paramInt1, long paramLong, HotWordSearchEntryDataModel.HotSearchItem paramHotSearchItem, int paramInt2, HotWordSearchEntryDataModel.GIFInfo paramGIFInfo)
  {
    dCK = paramInt1;
    if (QLog.isColorLevel()) {
      QLog.d("searchUtils", 2, "fromType:" + paramInt1);
    }
    if (paramInt1 == 12) {
      anot.a(null, "CliOper", "", "", "0X8006501", "0X8006501", paramInt1, 0, "1", "", "", "");
    }
    for (;;)
    {
      Intent localIntent = new Intent(paramActivity, UniteSearchActivity.class);
      localIntent.putExtra("keyword", paramString);
      localIntent.putExtra("fromType", paramInt1);
      localIntent.putExtra("source", paramInt2);
      localIntent.putExtra("searchEngineKey", paramLong);
      localIntent.putExtra("home_hot_word", paramHotSearchItem);
      localIntent.putExtra("home_gif_info", paramGIFInfo);
      paramActivity.startActivity(localIntent);
      paramActivity.overridePendingTransition(0, 2130772403);
      launchTime = System.currentTimeMillis();
      cDk = false;
      amxk.d("search", "tab", "searchbar", 0, 0, new String[] { amxk.fc(paramInt1) });
      return;
      anot.a(null, "CliOper", "", "", "0X8005021", "0X8005021", paramInt1, 0, "1", "", "", "");
    }
  }
  
  public static void b(Activity paramActivity, String paramString, int paramInt1, int paramInt2)
  {
    a(paramActivity, paramString, paramInt1, 0L, null, paramInt2);
  }
  
  public static boolean bi(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.uniteSearch.UniteSearchActivity", 2, "useNewProtocol， source:" + paramInt1 + " from:" + paramInt2);
    }
    switch (paramInt2)
    {
    default: 
      return true;
    }
    return false;
  }
  
  private void dOf()
  {
    this.fp = null;
    if (TextUtils.isEmpty(this.caJ)) {
      this.GU.setVisibility(4);
    }
    this.jdField_a_of_type_ComTencentMobileqqSearchFragmentGroupSearchFragment.resetData();
  }
  
  private void dOi()
  {
    if (jdField_b_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$HotSearchItem == null)
    {
      this.jdField_b_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setHint(2131719308);
      return;
    }
    this.jdField_b_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setHint(jdField_b_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$HotSearchItem.title);
    this.jdField_b_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setTag(jdField_b_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$HotSearchItem);
    this.jdField_b_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setCursorVisible(true);
  }
  
  private void dOj()
  {
    if (this.source == 1) {
      anpc.report("tim_msg_tab_search_click_search_exp");
    }
  }
  
  private void initView()
  {
    this.jdField_b_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText = ((QuickPinyinEditText)super.findViewById(2131366542));
    this.mSoftKeyboardStateHelper = new amxm(super.findViewById(2131377546));
    this.jdField_b_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setHint(amkd.yZ());
    this.jdField_b_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setHintTextColor(-1431918938);
    if (Build.VERSION.SDK_INT >= 26) {}
    try
    {
      View.class.getMethod("setImportantForAutofill", new Class[] { Integer.TYPE }).invoke(this.jdField_b_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText, new Object[] { Integer.valueOf(8) });
      this.jdField_b_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setImeOptions(3);
      this.jdField_b_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setOnEditorActionListener(this);
      this.jdField_b_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.addTextChangedListener(this);
      cDe = false;
      this.mSoftKeyboardStateHelper.a(this);
      this.as = ((ImageButton)super.findViewById(2131368696));
      this.as.setOnClickListener(new amlo(this));
      this.C = ((Button)super.findViewById(2131363801));
      this.C.setVisibility(0);
      this.C.setText(2131721058);
      this.C.setOnClickListener(new amlp(this));
      this.Dt = ((ImageView)super.findViewById(2131369671));
      this.Dt.setVisibility(0);
      this.Dt.setOnClickListener(new amlq(this));
      this.jdField_b_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.getInputExtras(true).putInt("QUICK_SEARCH", 1);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.w("Q.uniteSearch.UniteSearchActivity", 2, "disable auto fill error", localException);
      }
    }
  }
  
  private int jb(int paramInt)
  {
    switch (paramInt)
    {
    case 1: 
    default: 
      return 1;
    case 2: 
      return 2;
    case 21: 
      return 3;
    }
    return 10;
  }
  
  public static void p(Activity paramActivity, String paramString, int paramInt)
  {
    a(paramActivity, paramString, paramInt, 0L, null, 0);
  }
  
  public static void v(Context paramContext, String paramString, int paramInt)
  {
    dCK = paramInt;
    if (QLog.isColorLevel()) {
      QLog.d("searchUtils", 2, "fromType:" + paramInt);
    }
    if (paramInt == 12) {
      anot.a(null, "CliOper", "", "", "0X8006501", "0X8006501", paramInt, 0, "1", "", "", "");
    }
    for (;;)
    {
      Intent localIntent = new Intent(paramContext, UniteSearchActivity.class);
      localIntent.putExtra("keyword", paramString);
      localIntent.putExtra("fromType", paramInt);
      paramContext.startActivity(localIntent);
      cDk = false;
      launchTime = System.currentTimeMillis();
      amxk.d("search", "tab", "searchbar", 0, 0, new String[] { amxk.fc(paramInt) });
      return;
      anot.a(null, "CliOper", "", "", "0X8005021", "0X8005021", paramInt, 0, "1", "", "", "");
    }
  }
  
  public void IM()
  {
    ((InputMethodManager)getSystemService("input_method")).showSoftInput(this.jdField_b_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText, 0);
  }
  
  public int IQ()
  {
    return 1;
  }
  
  public int IR()
  {
    switch (this.from)
    {
    case 22: 
    case 23: 
    case 24: 
    default: 
      return this.from;
    case 21: 
      return 3;
    }
    return 10;
  }
  
  public void Iq(String paramString)
  {
    dOf();
    this.GU.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqSearchFragmentGroupSearchFragment.PQ(paramString);
    this.jdField_a_of_type_ComTencentMobileqqSearchFragmentGroupSearchFragment.bt(null);
    Hp(1);
    dOj();
  }
  
  public void PM(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      this.caJ = paramString;
      this.jdField_b_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setText(paramString);
      this.as.setVisibility(0);
      if (QLog.isColorLevel()) {
        QLog.d("Q.uniteSearch.UniteSearchActivity", 2, "onAssociateWordClick keyword = " + paramString);
      }
      this.jdField_b_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setSelection(paramString.length());
    }
  }
  
  void Po(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("searchUtils", 2, "showSearchHistory,  isShow: " + paramBoolean);
    }
    if (this.GS == null) {}
    do
    {
      return;
      if ((paramBoolean) && (this.GS.getVisibility() != 0) && (this.from != 12))
      {
        Hp(4);
        return;
      }
    } while (((paramBoolean) || (this.GS.getVisibility() != 0)) && (this.from != 12));
    Hp(1);
  }
  
  void Se(int paramInt)
  {
    FragmentTransaction localFragmentTransaction = this.mFragmentManager.beginTransaction();
    switch (paramInt)
    {
    default: 
    case 4: 
      do
      {
        return;
      } while (this.jdField_a_of_type_ComTencentMobileqqSearchFragmentSearchEntryFragment != null);
      this.jdField_a_of_type_ComTencentMobileqqSearchFragmentSearchEntryFragment = new SearchEntryFragment();
      amub.a(this.app, new ReportModelDC02528().module("all_result").action("exp_entryweb").ver2(amub.eZ(this.from)).session_id(this.app.getCurrentAccountUin() + System.currentTimeMillis()));
      this.jdField_a_of_type_ComTencentMobileqqSearchFragmentSearchEntryFragment.mApp = this.app;
      String str;
      switch (this.from)
      {
      default: 
        str = "kSearchMessageTab";
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentMobileqqSearchFragmentSearchEntryFragment.caV = str;
        this.jdField_a_of_type_ComTencentMobileqqSearchFragmentSearchEntryFragment.mSource = this.source;
        this.jdField_a_of_type_ComTencentMobileqqSearchFragmentSearchEntryFragment.mFrom = this.from;
        localFragmentTransaction.add(2131366488, this.jdField_a_of_type_ComTencentMobileqqSearchFragmentSearchEntryFragment, "search_entry_layout");
        localFragmentTransaction.commitAllowingStateLoss();
        this.GS.setVisibility(0);
        return;
        str = "kSearchMessageTab";
        continue;
        str = "kSearchContactTab";
        continue;
        str = "kSearchDynamicTab";
        continue;
        str = "kSearchReadInJoyTab";
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqSearchFragmentAssociateSearchWordsFragment == null) {
      this.jdField_a_of_type_ComTencentMobileqqSearchFragmentAssociateSearchWordsFragment = new AssociateSearchWordsFragment();
    }
    localFragmentTransaction.add(2131363021, this.jdField_a_of_type_ComTencentMobileqqSearchFragmentAssociateSearchWordsFragment, "associated_words");
    localFragmentTransaction.commitAllowingStateLoss();
  }
  
  public void Uy(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqSearchFragmentGroupSearchFragment.dCV = paramInt;
  }
  
  protected GroupSearchFragment a()
  {
    try
    {
      long l = getIntent().getLongExtra("searchEngineKey", 0L);
      if (l > 0L)
      {
        GroupSearchFragment localGroupSearchFragment1 = GroupSearchFragment.a(this.from, this.source, l);
        localGroupSearchFragment1.Ps(cDk);
        return localGroupSearchFragment1;
      }
    }
    catch (Exception localException)
    {
      GroupSearchFragment localGroupSearchFragment2 = GroupSearchFragment.a(this.from, this.source);
      localGroupSearchFragment2.Ps(cDk);
      return localGroupSearchFragment2;
    }
  }
  
  public String a(EditText paramEditText, boolean paramBoolean, CharSequence paramCharSequence)
  {
    String str = paramEditText.getText().toString();
    SpannableStringBuilder localSpannableStringBuilder = (SpannableStringBuilder)paramEditText.getText();
    if (localSpannableStringBuilder != null)
    {
      CompleteUrlSpan[] arrayOfCompleteUrlSpan = (CompleteUrlSpan[])localSpannableStringBuilder.getSpans(0, localSpannableStringBuilder.toString().length(), CompleteUrlSpan.class);
      if (arrayOfCompleteUrlSpan.length != 0)
      {
        int i = localSpannableStringBuilder.getSpanStart(arrayOfCompleteUrlSpan[0]);
        localSpannableStringBuilder.getSpanEnd(arrayOfCompleteUrlSpan[0]);
        if (paramBoolean) {}
        for (paramCharSequence = paramCharSequence.toString().substring(0, i + 1);; paramCharSequence = str.toString().substring(0, i))
        {
          paramEditText.removeTextChangedListener(this);
          paramEditText.setText(paramCharSequence);
          paramEditText.setSelection(paramCharSequence.length());
          paramEditText.addTextChangedListener(this);
          return paramCharSequence;
        }
      }
    }
    return paramEditText.getText().toString().trim();
  }
  
  public void aI(String paramString, long paramLong)
  {
    this.dn.removeMessages(101);
    this.dn.sendEmptyMessageDelayed(101, paramLong);
    this.jdField_a_of_type_ComTencentMobileqqSearchActivityUniteSearchActivity$a.key = paramString;
    this.jdField_a_of_type_ComTencentMobileqqSearchActivityUniteSearchActivity$a.time = (System.currentTimeMillis() + paramLong);
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqSearchFragmentSearchEntryFragment != null) {
      this.jdField_a_of_type_ComTencentMobileqqSearchFragmentSearchEntryFragment.afterTextChanged(paramEditable);
    }
    paramEditable = a(this.jdField_b_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText, this.cDp, this.ad);
    if ((this.cDp) && (paramEditable.equals(this.caJ))) {}
    do
    {
      return;
      boolean bool = bi(this.source, this.from);
      if ((!bool) && (this.jdField_a_of_type_ComTencentMobileqqSearchFragmentGroupSearchFragment.dCV != 6)) {
        this.cDq = true;
      }
      if ((bool) && (this.jdField_a_of_type_ComTencentMobileqqSearchFragmentGroupSearchFragment.dCV != 6)) {
        this.cDq = true;
      }
      if (TextUtils.isEmpty(caO)) {
        caO = this.app.getAccount() + System.currentTimeMillis();
      }
      if (!this.jdField_b_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.awp()) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("Q.uniteSearch.UniteSearchActivity", 2, "正在输入拼音，不触发文本变动逻辑。 keyword=" + paramEditable);
    return;
    this.caJ = paramEditable;
    caM = paramEditable;
    this.jdField_a_of_type_ComTencentMobileqqSearchFragmentGroupSearchFragment.keyword = this.caJ;
    if (TextUtils.isEmpty(paramEditable))
    {
      amxk.b("home_page", "exp_home", new String[] { "" + jc(this.from) });
      this.as.setVisibility(8);
      dOf();
      this.jdField_a_of_type_ComTencentMobileqqSearchFragmentGroupSearchFragment.clearSearchResult();
      if (this.jdField_a_of_type_ComTencentMobileqqSearchFragmentAssociateSearchWordsFragment != null) {
        this.jdField_a_of_type_ComTencentMobileqqSearchFragmentAssociateSearchWordsFragment.md(null);
      }
      if (cDl)
      {
        cDl = false;
        if (this.jdField_a_of_type_ComTencentMobileqqSearchFragmentSearchEntryFragment != null) {
          this.jdField_a_of_type_ComTencentMobileqqSearchFragmentSearchEntryFragment.refresh();
        }
      }
      Po(true);
    }
    for (;;)
    {
      if (!paramEditable.equals(this.caJ))
      {
        amxk.ako = 0L;
        dCE = 2;
      }
      if (!TextUtils.isEmpty(this.caP)) {
        Po(TextUtils.isEmpty(paramEditable));
      }
      if (this.jdField_a_of_type_ComTencentMobileqqSearchFragmentAssociateSearchWordsFragment == null) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqSearchFragmentAssociateSearchWordsFragment.md(null);
      return;
      this.as.setVisibility(0);
      if ((this.jdField_a_of_type_ComTencentMobileqqSearchFragmentSearchEntryFragment != null) && (this.from != 25) && (this.from != 26))
      {
        Iq(paramEditable);
        Po(false);
      }
      else if (!this.cDm)
      {
        cDe = true;
        Iq(paramEditable);
      }
      else
      {
        aI(paramEditable, 0L);
      }
    }
  }
  
  public boolean avZ()
  {
    if (this.jdField_b_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText == null) {
      return false;
    }
    return this.jdField_b_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.awp();
  }
  
  public boolean awa()
  {
    return this.cDq;
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    boolean bool = false;
    if ((TextUtils.isEmpty(paramCharSequence)) && (paramInt1 == 0) && (paramInt2 == 0) && (this.cDo))
    {
      this.cDo = false;
      aqoe.a.clear();
      aqoe.a.atq = System.nanoTime();
    }
    if (paramInt3 == 0) {
      bool = true;
    }
    this.cDp = bool;
    this.ad = ("" + paramCharSequence);
  }
  
  public Fragment c()
  {
    return this.jdField_a_of_type_ComTencentMobileqqSearchFragmentGroupSearchFragment;
  }
  
  protected void dOg()
  {
    if (!bi(this.source, this.from))
    {
      this.jdField_a_of_type_Acnm = ((acnm)this.app.getBusinessHandler(111));
      this.jdField_b_of_type_Acnk = null;
      return;
    }
    this.jdField_a_of_type_Acnm = null;
    this.jdField_b_of_type_Acnk = ((acnk)this.app.getBusinessHandler(152));
  }
  
  protected void dOh()
  {
    int i = jb(this.from);
    if (this.jdField_a_of_type_Acnm != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.uniteSearch.UniteSearchActivity", 2, "getUniteSearchDiscovery use old protocl");
      }
      this.jdField_a_of_type_Acnm.q(this.app, i);
    }
    do
    {
      return;
      if (this.jdField_b_of_type_Acnk != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.uniteSearch.UniteSearchActivity", 2, "getUniteSearchDiscovery use new protocl");
        }
        this.jdField_b_of_type_Acnk.p(this.app, i);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.d("Q.uniteSearch.UniteSearchActivity", 2, "getUniteSearchDiscovery error");
  }
  
  public void dOk()
  {
    if (this.jdField_a_of_type_Acnm != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.uniteSearch.UniteSearchActivity", 2, "sendAssociationWordRequest use old protocl");
      }
      if ((this.from == 25) || (this.from == 26)) {
        this.jdField_a_of_type_Acnm.m(this.jdField_a_of_type_ComTencentMobileqqSearchActivityUniteSearchActivity$a.key, 1, true);
      }
    }
    do
    {
      return;
      this.jdField_a_of_type_Acnm.m(this.jdField_a_of_type_ComTencentMobileqqSearchActivityUniteSearchActivity$a.key, 1, false);
      return;
      if (this.jdField_b_of_type_Acnk != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.uniteSearch.UniteSearchActivity", 2, "sendAssociationWordRequest use new protocl");
        }
        this.jdField_b_of_type_Acnk.FI(this.jdField_a_of_type_ComTencentMobileqqSearchActivityUniteSearchActivity$a.key);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.d("Q.uniteSearch.UniteSearchActivity", 2, "sendAssociationWordRequest error");
  }
  
  public void diu()
  {
    if (QLog.isColorLevel()) {
      QLog.d("searchUtils", 2, "cancelType-2 ResultModule:" + amxj.zq());
    }
    if ((this.GU != null) && (this.GU.getVisibility() == 0)) {
      amub.a(this.app, 0, this.from, "0X8009D2A", 0, 0, null, null);
    }
    for (;;)
    {
      amub.a(this.app, new ReportModelDC02528().module("all_result").action("cancel").ver1(vo()).ver2(amub.eZ(this.from)).ver3(caO).ver6(caN).session_id(this.app.getCurrentAccountUin() + System.currentTimeMillis()));
      ((InputMethodManager)BaseApplicationImpl.getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.jdField_b_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.getWindowToken(), 0);
      dCE = 0;
      finish();
      return;
      amub.a(this.app, 0, this.from, "0X8009D17", 0, 0, null, null);
    }
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqSearchFragmentGroupSearchFragment != null) && (this.jdField_a_of_type_ComTencentMobileqqSearchFragmentGroupSearchFragment.rc != null) && (this.jdField_a_of_type_ComTencentMobileqqSearchFragmentGroupSearchFragment.rc.size() > 0)) {
      gR();
    }
    if (paramInt1 == 1300) {
      if ((-1 == paramInt2) && (paramIntent != null))
      {
        paramIntent = paramIntent.getStringExtra("roomId");
        if (paramIntent != null)
        {
          apuh.f(this, paramIntent, true);
          anot.a(this.app, "CliOper", "", "", "0X8006360", "0X8006360", 0, 0, "", "", "", "");
        }
      }
    }
    do
    {
      String str;
      do
      {
        do
        {
          return;
          if (paramInt1 != 561253) {
            break;
          }
        } while ((-1 != paramInt2) || (paramIntent == null));
        str = paramIntent.getStringExtra("keyword");
      } while (TextUtils.isEmpty(str));
      mVsKey = paramIntent.getStringExtra("vsKey");
      dCJ = paramIntent.getIntExtra("vsSource", 1);
      this.jdField_a_of_type_ComTencentMobileqqSearchFragmentGroupSearchFragment.Ps(true);
      this.jdField_b_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setText(str);
      this.jdField_b_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setSelection(str.length());
      Iq(str);
      gR();
      return;
    } while (paramInt1 != this.dCL);
    if (this.jdField_a_of_type_ComTencentMobileqqSearchFragmentSearchEntryFragment != null) {
      this.jdField_a_of_type_ComTencentMobileqqSearchFragmentSearchEntryFragment.refresh();
    }
    this.jdField_b_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setText("");
  }
  
  public void doOnBackPressed()
  {
    super.doOnBackPressed();
    amub.a(this.app, new ReportModelDC02528().module("all_result").action("return").ver1(vo()).ver2(amub.eZ(this.from)).ver3(caO).ver6(caN).session_id(this.app.getCurrentAccountUin() + System.currentTimeMillis()));
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    Object localObject;
    if (jdField_a_of_type_ComTencentMobileqqSearchActivityUniteSearchActivity != null)
    {
      paramBundle = jdField_a_of_type_ComTencentMobileqqSearchActivityUniteSearchActivity;
      jdField_a_of_type_ComTencentMobileqqSearchActivityUniteSearchActivity = this;
      paramBundle.finish();
      this.mHandler = new Handler();
      this.from = super.getIntent().getIntExtra("fromType", -1);
      this.app.addObserver(this.jdField_a_of_type_Acnn);
      this.app.addObserver(this.jdField_a_of_type_Acnl);
      dCE = -1;
      this.mFragmentManager = super.getSupportFragmentManager();
      int i = jb(this.from);
      if (i == -1) {
        break label915;
      }
      caN = i + "_" + this.app.getAccount() + "_" + System.currentTimeMillis();
      setContentView(getLayoutId());
      paramBundle = super.findViewById(2131377546);
      if ((this.mNeedStatusTrans) && (ImmersiveUtils.isSupporImmersive() == 1)) {
        paramBundle.setFitsSystemWindows(true);
      }
      this.source = super.getIntent().getIntExtra("source", 0);
      dOg();
      initView();
      this.caJ = super.getIntent().getStringExtra("keyword");
      localObject = (HotWordSearchEntryDataModel.HotSearchItem)super.getIntent().getSerializableExtra("home_hot_word");
      if ((localObject != null) && (!TextUtils.isEmpty(((HotWordSearchEntryDataModel.HotSearchItem)localObject).title)))
      {
        jdField_b_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$HotSearchItem = (HotWordSearchEntryDataModel.HotSearchItem)localObject;
        dOi();
        amxk.b("home_page", "hot_list", new String[] { jdField_b_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$HotSearchItem.title, String.valueOf(IR()) });
      }
      localObject = getResources().getDisplayMetrics();
      amxk.b("home_page", "active_search", new String[] { "" + jc(this.from), ((DisplayMetrics)localObject).widthPixels + "*" + ((DisplayMetrics)localObject).heightPixels });
      localObject = new JSONObject();
    }
    for (;;)
    {
      try
      {
        ((JSONObject)localObject).put("project", amub.zn());
        ((JSONObject)localObject).put("event_src", "client");
        ((JSONObject)localObject).put("experiment_id", amub.cce);
        amub.a(this.app, new ReportModelDC02528().module("all_result").action("active_search").ver2(amub.eZ(this.from)).ver7(((JSONObject)localObject).toString()).session_id(this.app.getCurrentAccountUin() + System.currentTimeMillis()));
        if (TextUtils.isEmpty(this.caJ)) {
          amxk.b("home_page", "exp_home", new String[] { "" + jc(this.from) });
        }
        localObject = super.getSupportFragmentManager();
        this.jdField_a_of_type_ComTencentMobileqqSearchFragmentGroupSearchFragment = a();
        ((FragmentManager)localObject).beginTransaction().replace(2131368204, this.jdField_a_of_type_ComTencentMobileqqSearchFragmentGroupSearchFragment).commit();
        startTime = System.currentTimeMillis();
        this.Dt.setVisibility(8);
        if (this.from == 12) {
          this.jdField_b_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setHint(String.format(getResources().getString(2131698738), new Object[] { obt.a(this.app, getApplicationContext()) }));
        }
        this.caP = aclj.q(this.app);
        if ((!TextUtils.isEmpty(this.caP)) && (this.from != 12) && (this.from != 14) && (this.jdField_a_of_type_ComTencentMobileqqSearchFragmentSearchEntryFragment != null)) {
          this.jdField_a_of_type_ComTencentMobileqqSearchFragmentSearchEntryFragment.refresh();
        }
        this.cDo = true;
        this.GS = paramBundle.findViewById(2131366488);
        this.GT = paramBundle.findViewById(2131363021);
        this.GU = paramBundle.findViewById(2131368204);
        if (TextUtils.isEmpty(this.caJ))
        {
          Hp(4);
          this.jdField_b_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.dEb = 50;
          this.jdField_b_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setFilters(new InputFilter[] { new InputFilter.LengthFilter(50) });
          this.jdField_a_of_type_ComTencentMobileqqSearchActivityUniteSearchActivity$CancelReceiver = new CancelReceiver();
          paramBundle = new IntentFilter();
          paramBundle.addAction("com.tencent.mobileqq.search.cancel");
          super.registerReceiver(this.jdField_a_of_type_ComTencentMobileqqSearchActivityUniteSearchActivity$CancelReceiver, paramBundle);
          dOh();
          if (TextUtils.isEmpty(this.caJ)) {
            break label963;
          }
          if (this.caJ.length() > 50) {
            this.caJ = this.caJ.substring(0, 50);
          }
          if (QLog.isColorLevel()) {
            QLog.i("Q.uniteSearch.UniteSearchActivity", 2, "自动搜索 isViewCreated:" + this.jdField_a_of_type_ComTencentMobileqqSearchFragmentGroupSearchFragment.isViewCreated);
          }
          this.jdField_a_of_type_ComTencentMobileqqSearchFragmentGroupSearchFragment.cDA = true;
          if (this.from == 4) {
            Uy(6);
          }
          com.tencent.image.AbstractGifImage.DoAccumulativeRunnable.DELAY = 0;
          AbstractGifImage.resumeAll();
          return true;
          jdField_a_of_type_ComTencentMobileqqSearchActivityUniteSearchActivity = this;
          break;
          label915:
          caN = "";
        }
      }
      catch (JSONException localJSONException)
      {
        QLog.e("Q.uniteSearch.UniteSearchActivity", 2, "e = " + localJSONException);
        continue;
        Hp(3);
        continue;
      }
      try
      {
        label963:
        paramBundle = (HotWordSearchEntryDataModel.GIFInfo)super.getIntent().getSerializableExtra("home_gif_info");
        if ((this.from == 25) && (amju.a(paramBundle))) {
          continue;
        }
        this.mHandler.postDelayed(new UniteSearchActivity.3(this), 500L);
      }
      catch (Exception paramBundle)
      {
        for (;;)
        {
          paramBundle.printStackTrace();
          paramBundle = null;
        }
      }
    }
  }
  
  /* Error */
  public void doOnDestroy()
  {
    // Byte code:
    //   0: getstatic 948	com/tencent/mobileqq/search/activity/UniteSearchActivity:jdField_a_of_type_ComTencentMobileqqSearchActivityUniteSearchActivity	Lcom/tencent/mobileqq/search/activity/UniteSearchActivity;
    //   3: aload_0
    //   4: if_acmpne +7 -> 11
    //   7: aconst_null
    //   8: putstatic 948	com/tencent/mobileqq/search/activity/UniteSearchActivity:jdField_a_of_type_ComTencentMobileqqSearchActivityUniteSearchActivity	Lcom/tencent/mobileqq/search/activity/UniteSearchActivity;
    //   11: aload_0
    //   12: getfield 1091	com/tencent/mobileqq/search/activity/UniteSearchActivity:jdField_a_of_type_ComTencentMobileqqSearchActivityUniteSearchActivity$CancelReceiver	Lcom/tencent/mobileqq/search/activity/UniteSearchActivity$CancelReceiver;
    //   15: ifnull +16 -> 31
    //   18: aload_0
    //   19: aload_0
    //   20: getfield 1091	com/tencent/mobileqq/search/activity/UniteSearchActivity:jdField_a_of_type_ComTencentMobileqqSearchActivityUniteSearchActivity$CancelReceiver	Lcom/tencent/mobileqq/search/activity/UniteSearchActivity$CancelReceiver;
    //   23: invokespecial 1156	android/support/v4/app/FragmentActivity:unregisterReceiver	(Landroid/content/BroadcastReceiver;)V
    //   26: aload_0
    //   27: aconst_null
    //   28: putfield 1091	com/tencent/mobileqq/search/activity/UniteSearchActivity:jdField_a_of_type_ComTencentMobileqqSearchActivityUniteSearchActivity$CancelReceiver	Lcom/tencent/mobileqq/search/activity/UniteSearchActivity$CancelReceiver;
    //   31: aload_0
    //   32: getfield 144	com/tencent/mobileqq/search/activity/UniteSearchActivity:dn	Landroid/os/Handler;
    //   35: bipush 101
    //   37: invokevirtual 714	android/os/Handler:removeMessages	(I)V
    //   40: aload_0
    //   41: getfield 951	com/tencent/mobileqq/search/activity/UniteSearchActivity:mHandler	Landroid/os/Handler;
    //   44: aconst_null
    //   45: invokevirtual 1159	android/os/Handler:removeCallbacksAndMessages	(Ljava/lang/Object;)V
    //   48: aload_0
    //   49: getfield 178	com/tencent/mobileqq/search/activity/UniteSearchActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   52: aload_0
    //   53: getfield 131	com/tencent/mobileqq/search/activity/UniteSearchActivity:jdField_a_of_type_Acnn	Lacnn;
    //   56: invokevirtual 1162	com/tencent/mobileqq/app/QQAppInterface:removeObserver	(Lacci;)V
    //   59: aload_0
    //   60: getfield 178	com/tencent/mobileqq/search/activity/UniteSearchActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   63: aload_0
    //   64: getfield 136	com/tencent/mobileqq/search/activity/UniteSearchActivity:jdField_a_of_type_Acnl	Lacnl;
    //   67: invokevirtual 1162	com/tencent/mobileqq/app/QQAppInterface:removeObserver	(Lacci;)V
    //   70: invokestatic 1167	amxe:a	()Lamxe;
    //   73: invokevirtual 1170	amxe:release	()V
    //   76: iconst_m1
    //   77: putstatic 96	com/tencent/mobileqq/search/activity/UniteSearchActivity:dCK	I
    //   80: aload_0
    //   81: invokevirtual 908	com/tencent/mobileqq/search/activity/UniteSearchActivity:gR	()V
    //   84: aload_0
    //   85: getfield 364	com/tencent/mobileqq/search/activity/UniteSearchActivity:jdField_b_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText	Lcom/tencent/mobileqq/search/view/QuickPinyinEditText;
    //   88: iconst_0
    //   89: invokevirtual 1173	com/tencent/mobileqq/search/view/QuickPinyinEditText:setFocusable	(Z)V
    //   92: aload_0
    //   93: getfield 364	com/tencent/mobileqq/search/activity/UniteSearchActivity:jdField_b_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText	Lcom/tencent/mobileqq/search/view/QuickPinyinEditText;
    //   96: iconst_0
    //   97: invokevirtual 1176	com/tencent/mobileqq/search/view/QuickPinyinEditText:setFocusableInTouchMode	(Z)V
    //   100: aload_0
    //   101: getfield 364	com/tencent/mobileqq/search/activity/UniteSearchActivity:jdField_b_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText	Lcom/tencent/mobileqq/search/view/QuickPinyinEditText;
    //   104: bipush 8
    //   106: invokevirtual 1177	com/tencent/mobileqq/search/view/QuickPinyinEditText:setVisibility	(I)V
    //   109: aload_0
    //   110: getfield 364	com/tencent/mobileqq/search/activity/UniteSearchActivity:jdField_b_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText	Lcom/tencent/mobileqq/search/view/QuickPinyinEditText;
    //   113: invokevirtual 1181	com/tencent/mobileqq/search/view/QuickPinyinEditText:getParent	()Landroid/view/ViewParent;
    //   116: ifnull +20 -> 136
    //   119: aload_0
    //   120: getfield 364	com/tencent/mobileqq/search/activity/UniteSearchActivity:jdField_b_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText	Lcom/tencent/mobileqq/search/view/QuickPinyinEditText;
    //   123: invokevirtual 1181	com/tencent/mobileqq/search/view/QuickPinyinEditText:getParent	()Landroid/view/ViewParent;
    //   126: checkcast 1183	android/view/ViewGroup
    //   129: aload_0
    //   130: getfield 364	com/tencent/mobileqq/search/activity/UniteSearchActivity:jdField_b_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText	Lcom/tencent/mobileqq/search/view/QuickPinyinEditText;
    //   133: invokevirtual 1186	android/view/ViewGroup:removeView	(Landroid/view/View;)V
    //   136: aload_0
    //   137: getfield 364	com/tencent/mobileqq/search/activity/UniteSearchActivity:jdField_b_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText	Lcom/tencent/mobileqq/search/view/QuickPinyinEditText;
    //   140: aload_0
    //   141: invokevirtual 1187	com/tencent/mobileqq/search/view/QuickPinyinEditText:removeTextChangedListener	(Landroid/text/TextWatcher;)V
    //   144: aload_0
    //   145: getfield 364	com/tencent/mobileqq/search/activity/UniteSearchActivity:jdField_b_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText	Lcom/tencent/mobileqq/search/view/QuickPinyinEditText;
    //   148: aconst_null
    //   149: invokevirtual 460	com/tencent/mobileqq/search/view/QuickPinyinEditText:setOnEditorActionListener	(Landroid/widget/TextView$OnEditorActionListener;)V
    //   152: getstatic 427	android/os/Build$VERSION:SDK_INT	I
    //   155: bipush 23
    //   157: if_icmplt +52 -> 209
    //   160: getstatic 1192	android/os/Build:MANUFACTURER	Ljava/lang/String;
    //   163: ldc_w 1194
    //   166: invokevirtual 738	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   169: ifeq +40 -> 209
    //   172: aload_0
    //   173: ldc_w 1196
    //   176: invokestatic 1200	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   179: invokevirtual 1203	com/tencent/mobileqq/search/activity/UniteSearchActivity:getSystemService	(Ljava/lang/Class;)Ljava/lang/Object;
    //   182: astore_1
    //   183: aload_1
    //   184: ifnull +75 -> 259
    //   187: aload_1
    //   188: invokevirtual 1207	java/lang/Object:getClass	()Ljava/lang/Class;
    //   191: ldc_w 1209
    //   194: invokevirtual 1213	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   197: astore_2
    //   198: aload_2
    //   199: iconst_1
    //   200: invokevirtual 1218	java/lang/reflect/Field:setAccessible	(Z)V
    //   203: aload_2
    //   204: aload_1
    //   205: aconst_null
    //   206: invokevirtual 1222	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   209: aconst_null
    //   210: putstatic 1226	amxk:cm	Landroid/graphics/Paint;
    //   213: iconst_m1
    //   214: putstatic 106	com/tencent/mobileqq/search/activity/UniteSearchActivity:dCE	I
    //   217: aload_0
    //   218: getfield 354	com/tencent/mobileqq/search/activity/UniteSearchActivity:jdField_a_of_type_ComTencentMobileqqSearchFragmentGroupSearchFragment	Lcom/tencent/mobileqq/search/fragment/GroupSearchFragment;
    //   221: ifnull +10 -> 231
    //   224: aload_0
    //   225: getfield 354	com/tencent/mobileqq/search/activity/UniteSearchActivity:jdField_a_of_type_ComTencentMobileqqSearchFragmentGroupSearchFragment	Lcom/tencent/mobileqq/search/fragment/GroupSearchFragment;
    //   228: invokevirtual 1229	com/tencent/mobileqq/search/fragment/GroupSearchFragment:destroyEngine	()V
    //   231: aload_0
    //   232: invokevirtual 908	com/tencent/mobileqq/search/activity/UniteSearchActivity:gR	()V
    //   235: invokestatic 1234	amkl:clearCache	()V
    //   238: aload_0
    //   239: invokespecial 1236	android/support/v4/app/FragmentActivity:doOnDestroy	()V
    //   242: bipush 100
    //   244: putstatic 1123	com/tencent/image/AbstractGifImage$DoAccumulativeRunnable:DELAY	I
    //   247: invokestatic 1241	amus:onDestroy	()V
    //   250: return
    //   251: astore_1
    //   252: aload_1
    //   253: invokevirtual 1149	java/lang/Exception:printStackTrace	()V
    //   256: goto -225 -> 31
    //   259: invokestatic 152	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   262: ifeq -53 -> 209
    //   265: ldc 154
    //   267: iconst_2
    //   268: ldc_w 1243
    //   271: invokestatic 174	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   274: goto -65 -> 209
    //   277: astore_1
    //   278: invokestatic 152	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   281: ifeq -72 -> 209
    //   284: ldc 154
    //   286: iconst_2
    //   287: aload_1
    //   288: invokestatic 1247	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   291: invokestatic 174	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   294: goto -85 -> 209
    //   297: astore_1
    //   298: invokestatic 152	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   301: ifeq -92 -> 209
    //   304: ldc 154
    //   306: iconst_2
    //   307: aload_1
    //   308: invokestatic 1247	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   311: invokestatic 174	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   314: goto -105 -> 209
    //   317: astore_1
    //   318: ldc 154
    //   320: iconst_1
    //   321: aload_1
    //   322: invokestatic 1247	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   325: invokestatic 189	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   328: goto -86 -> 242
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	331	0	this	UniteSearchActivity
    //   182	23	1	localObject	Object
    //   251	2	1	localException1	Exception
    //   277	11	1	localException2	Exception
    //   297	11	1	localError1	java.lang.Error
    //   317	5	1	localError2	java.lang.Error
    //   197	7	2	localField	java.lang.reflect.Field
    // Exception table:
    //   from	to	target	type
    //   11	31	251	java/lang/Exception
    //   80	136	277	java/lang/Exception
    //   136	183	277	java/lang/Exception
    //   187	209	277	java/lang/Exception
    //   259	274	277	java/lang/Exception
    //   80	136	297	java/lang/Error
    //   136	183	297	java/lang/Error
    //   187	209	297	java/lang/Error
    //   259	274	297	java/lang/Error
    //   238	242	317	java/lang/Error
  }
  
  public void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    startTime = -1L;
    amus.onPause();
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    amus.onResume();
    if (!this.cDj) {
      amub.a(null, new ReportModelDC02528().module("all_result").action("return").ver2(amub.eZ(this.from)).ver3(caO).ver6(caN));
    }
    this.cDj = false;
    caO = "";
  }
  
  public void doOnStart() {}
  
  public void doOnStop()
  {
    super.doOnStop();
    if ((!aqoe.a.cUV) && (aqoe.a.itemType != 1))
    {
      aqoe.a.atr += (System.nanoTime() - aqoe.a.atq) / 1000000L;
      aqoe.a.ats += (System.nanoTime() - aqoe.a.dS) / 1000000L;
    }
    if (this.jdField_b_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText != null)
    {
      this.jdField_b_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.clearFocus();
      ((InputMethodManager)BaseApplicationImpl.getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.jdField_b_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.getWindowToken(), 0);
    }
  }
  
  public void doOnWindowFocusChanged(boolean paramBoolean)
  {
    super.doOnWindowFocusChanged(paramBoolean);
    if ((paramBoolean) && (!this.cDn))
    {
      this.cDn = true;
      anpc.a(BaseApplicationImpl.getApplication()).collectPerformance(this.app.getCurrentAccountUin(), "GroupSearchLaunchTime", true, System.currentTimeMillis() - launchTime, 0L, null, "", false);
    }
  }
  
  public void fM(String paramString, int paramInt)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      this.caJ = paramString;
      amub.a(null, new ReportModelDC02528().module("all_result").action("clk_thinkword_list").ver1(vo()).ver2(amub.eZ(this.from)).ver3(caO).ver6(caN).ver7("{\"clk_index\":" + (paramInt - 1) + ",\"experiment_id\":" + amub.cce + "}").ver4(paramString));
      this.jdField_b_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.removeTextChangedListener(this);
      this.jdField_b_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setText(paramString);
      this.as.setVisibility(0);
      this.jdField_b_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.addTextChangedListener(this);
      if (QLog.isColorLevel()) {
        QLog.d("Q.uniteSearch.UniteSearchActivity", 2, "onAssociateWordClick keyword = " + paramString);
      }
      this.jdField_b_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setSelection(paramString.length());
      if (bi(this.source, this.from)) {}
      fN(paramString, 2);
    }
    gR();
  }
  
  public void fN(String paramString, int paramInt)
  {
    String str2 = aenm.a().bzV;
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = "https://sou.qq.com/kandian/kd.html?_bid=3216&_wv=3&_wwv=1293&_wvSb=0&keyword=$KEYWORD$&from=$FROM$";
    }
    str1 = str1.replace("$KEYWORD$", URLEncoder.encode(this.caJ));
    if ((this.from == 25) || (this.from == 26)) {
      if (paramInt == 2)
      {
        str1 = str1.replace("$FROM$", "kandian_thinkword");
        str1 = str1.replace("$SEARCHID$", "" + URLEncoder.encode(caN)).replace("$SEQNO$", "" + URLEncoder.encode(caO));
        amxk.b(this.app, this, str1, this.dCL);
      }
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqSearchFragmentSearchEntryFragment != null) && ((TextUtils.equals(this.jdField_a_of_type_ComTencentMobileqqSearchFragmentSearchEntryFragment.caV, "kSearchDynamicTab")) || (this.from == 25) || (this.from == 26)))
      {
        ((aclk)((QQAppInterface)kxm.getAppRuntime()).getManager(299)).EO(paramString);
        this.jdField_a_of_type_ComTencentMobileqqSearchFragmentSearchEntryFragment.refresh();
      }
      dOj();
      return;
      str1 = str1.replace("$FROM$", "kandian_search");
      break;
      dOf();
      this.GU.setVisibility(0);
      Uy(paramInt);
      this.jdField_a_of_type_ComTencentMobileqqSearchFragmentGroupSearchFragment.PQ(paramString);
      this.jdField_a_of_type_ComTencentMobileqqSearchFragmentGroupSearchFragment.bt(null);
      Hp(1);
    }
  }
  
  public void finish()
  {
    if (cDk) {
      anot.a(this.app, "CliOper", "", "", "0X8007E2D", "0X8007E2D", 0, dCE, "", "", "", "");
    }
    setResult(-1);
    super.finish();
    overridePendingTransition(0, 2130772403);
  }
  
  public void gR()
  {
    ((InputMethodManager)BaseApplicationImpl.getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.jdField_b_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.getWindowToken(), 0);
    this.jdField_b_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.clearFocus();
  }
  
  public double getLat()
  {
    return latitude;
  }
  
  protected int getLayoutId()
  {
    return 2131563292;
  }
  
  public int jc(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return paramInt;
    }
    return 3;
  }
  
  public long[] m()
  {
    return new long[0];
  }
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 3) || ((paramKeyEvent != null) && (paramKeyEvent.getKeyCode() == 66)))
    {
      if ((paramKeyEvent != null) && (paramKeyEvent.getAction() != 1)) {
        return true;
      }
      paramTextView = this.jdField_b_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.getText().toString().trim();
      LogcatUtil.uC(paramTextView);
      if (aqjb.WEB_URL.matcher(paramTextView).matches())
      {
        this.caJ = paramTextView;
        this.jdField_b_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.performClick();
      }
      if ((TextUtils.isEmpty(paramTextView)) && ((this.jdField_b_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.getTag() instanceof HotWordSearchEntryDataModel.HotSearchItem)))
      {
        String str = jdField_b_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$HotSearchItem.recallWord;
        paramKeyEvent = ((HotWordSearchEntryDataModel.HotSearchItem)this.jdField_b_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.getTag()).jumpUrl;
        paramTextView = paramKeyEvent;
        if (TextUtils.isEmpty(paramKeyEvent))
        {
          if ((this.from == 25) || (this.from == 26))
          {
            paramTextView = "kandian_tabword";
            paramTextView = amxh.k(str, 6, paramTextView);
          }
        }
        else
        {
          if (TextUtils.isEmpty(paramTextView)) {
            break label492;
          }
          paramKeyEvent = aqik.c(this.app, this, paramTextView);
          if (paramKeyEvent == null) {
            break label398;
          }
          paramKeyEvent.ace();
        }
        for (;;)
        {
          amxk.b("all_result", "clk_wording", new String[] { str, String.valueOf(IR()) });
          amub.a(this.app, new ReportModelDC02528().module("hot_list").action("clk_default_word").ver2(amub.eZ(this.from)).ver4(str).ver7("{experiment_id:" + amub.cce + "}"));
          if (((this.from == 25) || (this.from == 26)) && (this.jdField_a_of_type_Acnm != null)) {
            this.jdField_a_of_type_Acnm.d(this.app, "clk_default_word", str, amub.eZ(this.from), null);
          }
          amkl.cDb = true;
          if ((this.jdField_a_of_type_ComTencentMobileqqSearchFragmentSearchEntryFragment != null) && ((this.from == 25) || (this.from == 26)))
          {
            ((aclk)((QQAppInterface)kxm.getAppRuntime()).getManager(299)).EO(str);
            this.jdField_a_of_type_ComTencentMobileqqSearchFragmentSearchEntryFragment.refresh();
          }
          return true;
          paramTextView = "hotword";
          break;
          label398:
          if (amxk.oO(paramTextView))
          {
            amxk.E(this, str, paramTextView);
          }
          else if ((paramTextView.startsWith("http://")) || (paramTextView.startsWith("https://")))
          {
            paramKeyEvent = new Intent(this, QQBrowserActivity.class);
            paramKeyEvent.putExtra("url", paramTextView);
            paramKeyEvent.putExtra("search_title", str);
            startActivity(paramKeyEvent);
          }
          else if (QLog.isColorLevel())
          {
            QLog.d("Q.uniteSearch.UniteSearchActivity", 2, "onEditorAction jumpUrl is illegal");
            continue;
            label492:
            if (QLog.isColorLevel()) {
              QLog.d("Q.uniteSearch.UniteSearchActivity", 2, "onEditorAction jumpUrl is empty");
            }
          }
        }
      }
      if (!TextUtils.isEmpty(paramTextView))
      {
        this.caJ = paramTextView;
        caM = paramTextView;
        if (bi(this.source, this.from)) {}
        fN(paramTextView, 1);
        amub.a(null, new ReportModelDC02528().module("all_result").action("clk_search_button").ver1(paramTextView).ver2(amub.eZ(this.from)).ver3(caO).ver6(caN));
      }
      for (;;)
      {
        gR();
        return true;
        if ((this.jdField_b_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.getTag() instanceof HotWordSearchEntryDataModel.HotSearchItem))
        {
          paramTextView = this.jdField_b_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.getHint().toString();
          this.caJ = paramTextView;
          caM = paramTextView;
          this.jdField_b_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setText(paramTextView);
          this.jdField_b_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setSelection(paramTextView.length());
        }
      }
    }
    return false;
  }
  
  protected void onRestart()
  {
    super.onRestart();
    if ((!aqoe.a.cUV) && (aqoe.a.itemType != 1))
    {
      aqoe.a.atq = System.nanoTime();
      aqoe.a.dS = System.nanoTime();
    }
  }
  
  public void onRestoreInstanceState(Bundle paramBundle)
  {
    if (this.jdField_b_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText != null) {
      this.jdField_b_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.removeTextChangedListener(this);
    }
    super.onRestoreInstanceState(paramBundle);
    if (this.jdField_b_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText != null) {
      this.jdField_b_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.addTextChangedListener(this);
    }
  }
  
  public void onSoftKeyboardClosed()
  {
    this.jdField_b_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setCursorVisible(false);
  }
  
  public void onSoftKeyboardOpened(int paramInt)
  {
    this.jdField_b_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setCursorVisible(true);
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void p(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    if (paramBoolean2)
    {
      SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(paramString);
      localSpannableStringBuilder.setSpan(new BackgroundColorSpan(858244351), 0, paramString.length(), 33);
      localSpannableStringBuilder.setSpan(new amls(this), 0, paramString.length(), 33);
      this.jdField_b_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setMovementMethod(LinkMovementMethod.getInstance());
      if (paramBoolean1) {
        this.jdField_b_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setText(localSpannableStringBuilder);
      }
      for (;;)
      {
        this.jdField_b_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setSelection(paramString.length());
        label98:
        if (this.from != 26) {
          break;
        }
        this.mHandler.postDelayed(new UniteSearchActivity.9(this), 500L);
        return;
        this.jdField_b_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.removeTextChangedListener(this);
        this.jdField_b_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setText(localSpannableStringBuilder);
        this.jdField_b_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.addTextChangedListener(this);
        this.as.setVisibility(0);
        dOf();
        Hp(4);
      }
    }
    if (paramBoolean1) {
      this.jdField_b_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setText(paramString);
    }
    for (;;)
    {
      this.jdField_b_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setSelection(paramString.length());
      break label98;
      break;
      this.jdField_b_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.removeTextChangedListener(this);
      this.jdField_b_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setText(paramString);
      this.jdField_b_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.addTextChangedListener(this);
    }
  }
  
  public String vo()
  {
    return this.jdField_b_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.getText().toString();
  }
  
  public double z()
  {
    return longitude;
  }
  
  public class CancelReceiver
    extends BroadcastReceiver
  {
    public CancelReceiver() {}
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      if ("com.tencent.mobileqq.search.cancel".equals(paramIntent.getAction())) {
        UniteSearchActivity.this.finish();
      }
    }
  }
  
  class a
  {
    public volatile String key;
    public volatile long time;
    
    a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.search.activity.UniteSearchActivity
 * JD-Core Version:    0.7.0.1
 */