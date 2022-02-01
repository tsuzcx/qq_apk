package com.tencent.mobileqq.activity.contact.addcontact;

import acej;
import acfd;
import acff;
import acfp;
import amfh;
import amhj;
import amxk;
import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import apuh;
import aqdf;
import aqdf.a;
import aqho;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.AddFriendActivity;
import com.tencent.mobileqq.activity.TroopInfoActivity;
import com.tencent.mobileqq.activity.contact.addcontact.publicaccount.PublicView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.pb.addcontacts.AccountSearchPb.ResultItem;
import com.tencent.pb.addcontacts.AccountSearchPb.hotwordrecord;
import com.tencent.pb.addcontacts.AccountSearchPb.record;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.ReportV4Fragment;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.e;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kbq;
import wja;
import yob;
import yob.a;
import yod;
import yol;
import yom;
import yon;
import yoo;
import yow;
import ysa;

public class SearchBaseFragment
  extends ReportV4Fragment
  implements View.OnClickListener, aqdf.a, AbsListView.e
{
  private static final String TAG = SearchBaseFragment.class.getName();
  protected amhj a;
  private AccountSearchPb.record jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record;
  protected yob a;
  yod jdField_a_of_type_Yod;
  protected int aTM;
  protected String aZi;
  public QQAppInterface app;
  public boolean bnO;
  protected boolean bnP;
  private acfd c;
  protected amfh c;
  protected yob.a c;
  private Handler ca;
  public final int cam = 64;
  aqdf d;
  protected BaseActivity h;
  LinearLayout hu;
  public Map<String, SpannableString> id = new ConcurrentHashMap();
  protected BaseAdapter mAdapter;
  public int mFrom = 0;
  public XListView mListView;
  public int mScrollState = 0;
  public Handler uiHandler = new yom(this);
  
  public SearchBaseFragment()
  {
    this.jdField_c_of_type_Yob$a = new yol(this);
    this.jdField_c_of_type_Amfh = new yon(this);
    this.jdField_c_of_type_Acfd = new yoo(this);
  }
  
  public static SpannableString a(String paramString, List<String> paramList)
  {
    if (paramString == null) {
      return null;
    }
    if (paramList == null) {
      return new SpannableString(paramString);
    }
    int i = paramString.length();
    Object localObject = paramList.iterator();
    int j;
    if (((Iterator)localObject).hasNext())
    {
      j = t((String)((Iterator)localObject).next(), paramString);
      if ((j < 0) || (j >= i)) {
        break label224;
      }
      i = j;
    }
    label224:
    for (;;)
    {
      break;
      localObject = paramString;
      if (i > 8)
      {
        localObject = paramString;
        if (i != paramString.length()) {
          localObject = "…" + paramString.substring(i - 8);
        }
      }
      SpannableString localSpannableString = new SpannableString((CharSequence)localObject);
      paramList = paramList.iterator();
      if (paramList.hasNext())
      {
        String str = (String)paramList.next();
        i = 0;
        for (paramString = (String)localObject;; paramString = paramString.substring(j))
        {
          int k = t(str, paramString);
          if (k < 0) {
            break;
          }
          j = str.length() + k;
          localSpannableString.setSpan(new ForegroundColorSpan(xk()), k + i, i + j, 33);
          i += j;
        }
      }
      return localSpannableString;
    }
  }
  
  public static SpannableString a(String paramString, List<String> paramList, int paramInt)
  {
    if (paramString == null) {
      return null;
    }
    if (paramList == null) {
      return new SpannableString(paramString);
    }
    int i = paramString.length();
    Object localObject = paramList.iterator();
    int j;
    if (((Iterator)localObject).hasNext())
    {
      j = t((String)((Iterator)localObject).next(), paramString);
      if ((j < 0) || (j >= i)) {
        break label466;
      }
      i = j;
    }
    label457:
    label460:
    label466:
    for (;;)
    {
      break;
      j = paramString.length();
      int k;
      if ((i >= 0) && (j > paramInt))
      {
        localObject = h(paramString, paramList);
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          k = ((String)localObject).length();
          if (k < paramInt)
          {
            i += k;
            k = i - paramInt;
            if ((k <= 0) || (i >= paramString.length())) {
              break label460;
            }
          }
        }
      }
      for (localObject = "…" + paramString.substring(k, i) + "…";; localObject = paramString)
      {
        if ((k > 0) && (i >= j))
        {
          paramString = "…" + ((String)localObject).substring(((String)localObject).length() - paramInt, ((String)localObject).length());
          localObject = paramString;
        }
        SpannableString localSpannableString;
        for (;;)
        {
          localSpannableString = new SpannableString((CharSequence)localObject);
          paramList = paramList.iterator();
          if (!paramList.hasNext()) {
            break label457;
          }
          String str = (String)paramList.next();
          paramString = (String)localObject;
          paramInt = 0;
          for (;;)
          {
            j = t(str, paramString);
            if (j < 0) {
              break;
            }
            i = str.length() + j;
            localSpannableString.setSpan(new ForegroundColorSpan(xk()), j + paramInt, paramInt + i, 33);
            paramInt += i;
            paramString = paramString.substring(i);
          }
          paramString = (String)localObject;
          if (k > 0) {
            break;
          }
          paramString = ((String)localObject).substring(0, paramInt) + "…";
          break;
          paramString = paramString.substring(0, paramInt) + "…";
          break;
          paramString = paramString.substring(0, paramInt) + "…";
          break;
          localObject = paramString;
          if (j > paramInt) {
            localObject = paramString.substring(0, paramInt) + "…";
          }
        }
        return localSpannableString;
      }
    }
  }
  
  private static String h(String paramString, List<String> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      if (paramString.indexOf(str) >= 0) {
        return str;
      }
      if (str.toLowerCase().indexOf(str.toLowerCase()) > 0) {
        return str;
      }
    }
    return null;
  }
  
  private static int t(String paramString1, String paramString2)
  {
    int i = paramString2.indexOf(paramString1);
    if (i >= 0) {
      return i;
    }
    return paramString2.toLowerCase().indexOf(paramString1.toLowerCase());
  }
  
  public static int xk()
  {
    int i = -16734752;
    if ("1103".equals(ThemeUtil.curThemeId)) {
      i = -16760704;
    }
    return i;
  }
  
  public boolean A(ArrayList<yow> paramArrayList)
  {
    return true;
  }
  
  protected void Sa()
  {
    if (d() != null)
    {
      if (this.jdField_a_of_type_Yod == null) {
        this.jdField_a_of_type_Yod = new yod(d());
      }
      if (!d().isFinishing()) {
        this.jdField_a_of_type_Yod.show();
      }
    }
  }
  
  protected int a(TextView paramTextView, BaseActivity paramBaseActivity)
  {
    paramTextView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
    int i = paramTextView.getMeasuredHeight();
    float f1 = paramTextView.getMeasuredWidth();
    int j = wja.dp2px(18.0F, paramBaseActivity.getResources());
    float f2 = wja.dp2px(260.0F, paramBaseActivity.getResources());
    float f3 = acej.aV() / 16.0F;
    return i / j + (int)(f1 * f3 / f2);
  }
  
  public SpannableString a(int paramInt, String paramString)
  {
    SpannableString localSpannableString2 = (SpannableString)this.id.get(paramInt + ":" + paramString);
    SpannableString localSpannableString1 = localSpannableString2;
    if (localSpannableString2 == null) {
      localSpannableString1 = new SpannableString(paramString);
    }
    return localSpannableString1;
  }
  
  public SpannableString a(int paramInt, String paramString, SpannableString paramSpannableString)
  {
    return (SpannableString)this.id.put(paramInt + ":" + paramString, paramSpannableString);
  }
  
  protected void a(int paramInt1, AccountSearchPb.record paramrecord, int paramInt2)
  {
    if (d() == null) {
      return;
    }
    switch (paramInt1)
    {
    default: 
      return;
    case 80000000: 
      a(paramrecord);
      return;
    case 80000001: 
      l = paramrecord.code.get();
      if (paramInt2 > 0) {}
      for (;;)
      {
        paramrecord = TroopInfoActivity.c(String.valueOf(l), paramInt2);
        paramrecord.putInt("exposureSource", 3);
        paramrecord.putInt("t_s_f", 1000);
        apuh.a(d(), paramrecord, 2);
        return;
        paramInt2 = 2;
      }
    }
    paramInt1 = paramrecord.account_flag.get();
    PublicView.a(this.app, d(), paramrecord.class_index.get(), String.valueOf(paramrecord.uin.get()), String.valueOf(paramrecord.uin.get()), paramInt1, paramrecord.name.get(), 4);
    kbq localkbq = kbq.a();
    QQAppInterface localQQAppInterface = this.app;
    long l = paramrecord.uin.get();
    String str = paramrecord.name.get();
    if (paramrecord.class_index.get() != 1) {}
    for (boolean bool = true;; bool = false)
    {
      localkbq.a(localQQAppInterface, String.valueOf(l), str, bool);
      return;
    }
  }
  
  public void a(int paramInt1, Object paramObject, int paramInt2, String paramString)
  {
    if (this.uiHandler != null) {
      this.uiHandler.sendMessage(this.uiHandler.obtainMessage(1, paramString));
    }
  }
  
  public void a(b paramb, RichStatus paramRichStatus)
  {
    paramb.richStatus = paramRichStatus;
    if ((paramRichStatus != null) && (!paramRichStatus.isEmpty()))
    {
      if (!TextUtils.isEmpty(paramRichStatus.actionText))
      {
        paramb.actionId = paramRichStatus.actionId;
        return;
      }
      paramb.actionId = 0;
      return;
    }
    paramb.actionId = 0;
  }
  
  protected void a(AccountSearchPb.record paramrecord)
  {
    this.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record = paramrecord;
    AddFriendActivity.a(d(), new SearchResultItem(paramrecord), this.app, true, 2);
  }
  
  protected String b(b paramb, AccountSearchPb.record paramrecord)
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    int j = paramrecord.age.get();
    int i;
    switch (paramrecord.sex.get())
    {
    default: 
      i = -1;
    }
    for (;;)
    {
      ysa.a(paramb.KV, i, j, localStringBuilder1);
      StringBuilder localStringBuilder2 = new StringBuilder();
      if (!TextUtils.isEmpty(paramrecord.province_name.get())) {
        localStringBuilder2.append(paramrecord.province_name.get()).append(" ");
      }
      if (!TextUtils.isEmpty(paramrecord.city_name.get())) {
        localStringBuilder2.append(paramrecord.city_name.get());
      }
      if ((localStringBuilder2.length() == 0) && (!TextUtils.isEmpty(paramrecord.country_name.get()))) {
        localStringBuilder2.append(paramrecord.country_name.get());
      }
      paramb.KW.setText(localStringBuilder2.toString());
      localStringBuilder1.append(localStringBuilder2.toString());
      a(paramb, paramrecord.richStatus);
      return localStringBuilder1.toString();
      i = 0;
      continue;
      i = 1;
    }
  }
  
  public void bc(String paramString, boolean paramBoolean) {}
  
  public void bpm()
  {
    if (this.jdField_a_of_type_Yod != null) {
      this.jdField_a_of_type_Yod.dismiss();
    }
  }
  
  protected String c(b paramb, AccountSearchPb.record paramrecord)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    paramb.KV.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
    paramb.KV.setCompoundDrawablePadding(0);
    paramb.KV.setBackgroundResource(0);
    Drawable localDrawable;
    if ((paramrecord.video_account.has()) && (paramrecord.video_account.get() == 1))
    {
      localDrawable = getResources().getDrawable(2130842619);
      ThemeUtil.setThemeFilter(localDrawable, ThemeUtil.curThemeId);
      paramb.FB.setCompoundDrawablesWithIntrinsicBounds(null, null, localDrawable, null);
      paramb.FB.setCompoundDrawablePadding((int)aqho.convertDpToPixel(BaseApplicationImpl.getContext(), 6.0F));
      if ((!paramrecord.class_index.has()) || (paramrecord.class_index.get() != 1)) {
        break label323;
      }
      if (paramrecord.class_name.has())
      {
        paramb.KV.setText(paramrecord.class_name.get());
        localStringBuilder.append(paramrecord.class_name.get());
      }
      if (paramrecord.brief.has())
      {
        paramb.KW.setText(a(80000002, paramrecord.brief.get()));
        localStringBuilder.append(paramrecord.brief.get());
      }
    }
    for (;;)
    {
      int i = BaseApplicationImpl.getContext().getResources().getColor(2131167379);
      paramb.KV.setTextColor(i);
      return localStringBuilder.toString();
      if ((paramrecord.flag.has()) && (paramrecord.flag.get() == 1L))
      {
        localDrawable = getResources().getDrawable(2130842599);
        ThemeUtil.setThemeFilter(localDrawable, ThemeUtil.curThemeId);
        paramb.FB.setCompoundDrawablesWithIntrinsicBounds(null, null, localDrawable, null);
        paramb.FB.setCompoundDrawablePadding((int)aqho.convertDpToPixel(BaseApplicationImpl.getContext(), 6.0F));
        break;
      }
      paramb.FB.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
      break;
      label323:
      if (paramrecord.class_index.has())
      {
        paramb.KV.setVisibility(8);
        if (paramrecord.brief.has())
        {
          paramb.KW.setText(a(80000002, paramrecord.brief.get()));
          localStringBuilder.append(paramb.KW.getText());
        }
      }
    }
  }
  
  public void ckf()
  {
    if (this.uiHandler != null) {
      this.uiHandler.sendEmptyMessage(2);
    }
  }
  
  public void cki()
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "clearHighLightString");
    }
    this.id.clear();
  }
  
  protected void ckj()
  {
    this.jdField_a_of_type_Yob = new yob(this.app);
    this.jdField_a_of_type_Yob.a(this.jdField_c_of_type_Yob$a);
    this.d = new aqdf(BaseApplicationImpl.getContext(), this.app);
    this.d.a(this);
    this.aTM = ((int)aqho.convertDpToPixel(BaseApplicationImpl.getContext(), 12.0F));
    this.jdField_a_of_type_Amhj = ((amhj)this.app.getManager(15));
    if (this.jdField_a_of_type_Amhj != null) {
      this.jdField_a_of_type_Amhj.addListener(this.jdField_c_of_type_Amfh);
    }
  }
  
  @Deprecated
  public void ckk()
  {
    this.app = ((QQAppInterface)d().getAppRuntime());
    Bundle localBundle = getArguments();
    if (localBundle != null)
    {
      this.mFrom = localBundle.getInt("from_key", 0);
      this.aZi = localBundle.getString("last_key_words");
    }
    ckj();
    if ((localBundle != null) && (!TextUtils.isEmpty(localBundle.getString("start_search_key"))) && (!localBundle.getBoolean("auto_add_and_prohibit_auto_search", false))) {
      bc(localBundle.getString("start_search_key"), false);
    }
  }
  
  public void clear()
  {
    if (this.hu != null) {
      this.hu.removeAllViews();
    }
  }
  
  public BaseActivity d()
  {
    return this.h;
  }
  
  protected void dI(View paramView)
  {
    if (paramView != null)
    {
      if (paramView.getParent() != null) {
        ((ViewGroup)paramView.getParent()).removeView(paramView);
      }
      this.hu.removeAllViews();
      this.hu.addView(paramView);
    }
  }
  
  public void dc(ArrayList<yow> paramArrayList)
  {
    for (;;)
    {
      yow localyow;
      List localList;
      Object localObject1;
      Object localObject2;
      Object localObject3;
      try
      {
        Iterator localIterator = paramArrayList.iterator();
        if (localIterator.hasNext())
        {
          localyow = (yow)localIterator.next();
          localList = localyow.sR;
          localObject1 = localyow.sS.iterator();
          if (!((Iterator)localObject1).hasNext()) {
            break label306;
          }
          localObject2 = (AccountSearchPb.record)((Iterator)localObject1).next();
          localObject3 = ((AccountSearchPb.record)localObject2).name.get();
          if (localyow.resultType == 80000003)
          {
            paramArrayList = SpannableString.valueOf(amxk.a((String)localObject3, (ArrayList)localList, 255));
            a(localyow.resultType, (String)localObject3, paramArrayList);
            paramArrayList = null;
          }
        }
        else
        {
          switch (localyow.resultType)
          {
          case 80000001: 
            if (!TextUtils.isEmpty(paramArrayList))
            {
              localObject3 = a(paramArrayList, localList);
              a(localyow.resultType, paramArrayList, (SpannableString)localObject3);
            }
            if ((localyow.resultType != 80000000) || (TextUtils.isEmpty(((AccountSearchPb.record)localObject2).mobile.get()))) {
              continue;
            }
            paramArrayList = ((AccountSearchPb.record)localObject2).mobile.get();
            localObject2 = a(paramArrayList, localList);
            a(localyow.resultType, paramArrayList, (SpannableString)localObject2);
            continue;
            return;
          }
        }
      }
      catch (Exception paramArrayList)
      {
        if (QLog.isColorLevel()) {
          QLog.d(TAG, 2, "", paramArrayList);
        }
      }
      paramArrayList = a((String)localObject3, localList);
      continue;
      paramArrayList = String.valueOf(((AccountSearchPb.record)localObject2).code.get());
      continue;
      paramArrayList = String.valueOf(((AccountSearchPb.record)localObject2).uin.get());
      continue;
      paramArrayList = String.valueOf(((AccountSearchPb.record)localObject2).brief.get());
      continue;
      label306:
      paramArrayList = localyow.b;
      if ((paramArrayList != null) && (paramArrayList.hotword.has()))
      {
        paramArrayList = paramArrayList.hotword.get();
        localObject1 = SpannableString.valueOf(amxk.a(paramArrayList, (ArrayList)localList, 255));
        a(localyow.resultType, paramArrayList, (SpannableString)localObject1);
      }
      paramArrayList = localyow.sT;
      if ((paramArrayList != null) && (paramArrayList.size() > 0))
      {
        localObject1 = paramArrayList.iterator();
        if (((Iterator)localObject1).hasNext())
        {
          localObject2 = (AccountSearchPb.ResultItem)((Iterator)localObject1).next();
          localObject3 = ((acff)this.app.getManager(51)).e(String.valueOf(((AccountSearchPb.ResultItem)localObject2).uin.get()));
          paramArrayList = "";
          if (localObject3 != null) {
            paramArrayList = ((Friends)localObject3).name;
          }
          if (!TextUtils.isEmpty(paramArrayList))
          {
            localObject3 = a(paramArrayList, localList);
            a(localyow.resultType, paramArrayList, (SpannableString)localObject3);
          }
          localObject3 = ((AccountSearchPb.ResultItem)localObject2).name.get().toStringUtf8();
          if (!TextUtils.isEmpty((CharSequence)localObject3))
          {
            localObject4 = a((String)localObject3, localList, 18);
            a(localyow.resultType, (String)localObject3, (SpannableString)localObject4);
          }
          Object localObject4 = ((AccountSearchPb.ResultItem)localObject2).nick_name.get().toStringUtf8();
          if (!TextUtils.isEmpty(paramArrayList))
          {
            paramArrayList = a((String)localObject4, localList);
            a(localyow.resultType, (String)localObject4, paramArrayList);
          }
          localObject4 = ((AccountSearchPb.ResultItem)localObject2).summary.get().toStringUtf8();
          if (!TextUtils.isEmpty((CharSequence)localObject4)) {
            if (!TextUtils.isEmpty((CharSequence)localObject3)) {
              break label658;
            }
          }
          label658:
          for (paramArrayList = a((String)localObject4, localList);; paramArrayList = a((String)localObject4, localList))
          {
            a(localyow.resultType, (String)localObject4, paramArrayList);
            paramArrayList = ((AccountSearchPb.ResultItem)localObject2).phtot_update.get().toStringUtf8();
            if (TextUtils.isEmpty(paramArrayList)) {
              break;
            }
            localObject2 = a(paramArrayList, localList, 18);
            a(localyow.resultType, paramArrayList, (SpannableString)localObject2);
            break;
          }
        }
      }
    }
  }
  
  @Deprecated
  public void doDestroy()
  {
    this.jdField_a_of_type_Yod = null;
    this.uiHandler = null;
    ViewFactory.a().destory();
    this.jdField_a_of_type_Yob.destory();
    this.jdField_a_of_type_Yob = null;
    if (this.d != null) {
      this.d.destory();
    }
    if (this.jdField_a_of_type_Amhj != null) {
      this.jdField_a_of_type_Amhj.removeListener(this.jdField_c_of_type_Amfh);
    }
  }
  
  protected int getSearchType()
  {
    if ((this.mFrom == 0) || (this.mFrom == 3) || (this.mFrom == 4)) {
      return 80000000;
    }
    if (this.mFrom == 2) {
      return 80000002;
    }
    if (this.mFrom == 5) {
      return 80000003;
    }
    return 80000001;
  }
  
  protected int getTitleBarHeight()
  {
    return BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131299627);
  }
  
  public View getView()
  {
    return this.hu;
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    this.h = ((FragmentActivity)paramActivity);
  }
  
  public void onClick(View paramView) {}
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    ckk();
    d().addObserver(this.jdField_c_of_type_Acfd);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.hu = new LinearLayout(d());
    this.hu.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    this.hu.setOrientation(1);
    this.hu.setClickable(true);
    this.mListView = new XListView(d());
    this.mListView.setCacheColorHint(0);
    this.mListView.setDivider(null);
    this.mListView.setSelector(2130851773);
    this.mListView.setOnScrollListener(this);
    this.mListView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    paramLayoutInflater = this.hu;
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "onDecodeTaskCompleted type = " + paramInt2 + ", uin = " + paramString);
    }
    int i;
    if ((paramBitmap != null) && (this.mScrollState == 0))
    {
      i = this.mListView.getChildCount();
      paramInt1 = 0;
    }
    for (;;)
    {
      Object localObject;
      if (paramInt1 < i)
      {
        localObject = this.mListView.getChildAt(paramInt1).getTag();
        if ((localObject == null) || (!(localObject instanceof b))) {
          break label167;
        }
        localObject = (b)localObject;
        if ((!((b)localObject).uin.equals(paramString)) && (!paramString.equals(((b)localObject).aPj))) {
          break label167;
        }
        if (paramInt2 == 4)
        {
          if (80000001 != ((b)localObject).dataType) {
            break label167;
          }
          ((b)localObject).pV.setImageBitmap(paramBitmap);
        }
      }
      else
      {
        return;
      }
      ((b)localObject).pV.setImageBitmap(paramBitmap);
      return;
      label167:
      paramInt1 += 1;
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    doDestroy();
    d().removeObserver(this.jdField_c_of_type_Acfd);
  }
  
  public void onDetach()
  {
    super.onDetach();
    this.h = null;
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.d.isPausing()) {
      this.d.resume();
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    this.mScrollState = paramInt;
    if (this.mScrollState != 0)
    {
      this.d.edu();
      this.d.pause();
    }
    for (;;)
    {
      if (d() != null)
      {
        paramAbsListView = (InputMethodManager)d().getSystemService("input_method");
        if (paramAbsListView.isActive()) {
          paramAbsListView.hideSoftInputFromWindow(d().getWindow().getDecorView().getWindowToken(), 0);
        }
      }
      return;
      if (this.d.isPausing())
      {
        this.d.resume();
        if (this.mAdapter != null) {
          this.mAdapter.notifyDataSetChanged();
        }
      }
    }
  }
  
  public void refreshList() {}
  
  public void showEmptyView()
  {
    if (d() != null) {
      dI(ViewFactory.a().a(80000006, d(), true));
    }
  }
  
  @Deprecated
  public void t(Handler paramHandler)
  {
    this.ca = paramHandler;
  }
  
  public void uQ(String paramString)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = acfp.m(2131714089);
    }
    QQToast.a(BaseApplicationImpl.getContext(), str, 0).show(getTitleBarHeight());
  }
  
  public static class a
  {
    public TextView FB;
    public TextView KR;
    public TextView KS;
    public TextView KT;
    public String aZj;
    public String aZk;
    public int num;
    public ImageView pV;
    public long rX;
    public String url;
  }
  
  public static class b
  {
    public TextView FB;
    public TextView KU;
    public TextView KV;
    public TextView KW;
    public String aPj;
    public int actionId;
    public AccountSearchPb.record b;
    public boolean bnQ = true;
    public int cao;
    public int dataType;
    public ImageView pV;
    public RichStatus richStatus;
    public String uin;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.SearchBaseFragment
 * JD-Core Version:    0.7.0.1
 */