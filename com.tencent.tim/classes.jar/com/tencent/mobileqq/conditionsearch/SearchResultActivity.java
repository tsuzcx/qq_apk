package com.tencent.mobileqq.conditionsearch;

import SummaryCard.CondFitUser;
import accv;
import accv.d;
import acff;
import acfp;
import aega;
import aegb;
import aegc;
import aegd;
import amfh;
import amhj;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import anot;
import aqdf;
import aqdf.a;
import aqho;
import aqhu;
import aqiw;
import auru;
import auuo;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.widget.InterestLabelTextView;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.e;
import com.tencent.widget.XListView;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SearchResultActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, aqdf.a, AbsListView.e
{
  static final boolean bTE = AppSetting.enableTalkBack;
  private static List<CondFitUser> yQ;
  private long VW;
  accv.d jdField_a_of_type_Accv$d = new aegc(this);
  amhj jdField_a_of_type_Amhj;
  public a a;
  private int aTM;
  accv b;
  amfh jdField_c_of_type_Amfh = new aegd(this);
  private auuo jdField_c_of_type_Auuo = new aegb(this);
  public int cai = 0;
  Set<Long> cj;
  aqdf d;
  private PullRefreshHeader g;
  private Handler.Callback mCallback = new aega(this);
  private Handler mHandler;
  public XListView mListView;
  public int mScrollState = 0;
  public List<CondFitUser> yP;
  
  public static void a(Context paramContext, String paramString, int paramInt1, int paramInt2, int paramInt3, String[] paramArrayOfString1, String[] paramArrayOfString2, int paramInt4, int paramInt5, List<CondFitUser> paramList, boolean paramBoolean)
  {
    Intent localIntent = new Intent(paramContext, SearchResultActivity.class);
    localIntent.putExtra("key_keyword", paramString);
    localIntent.putExtra("key_age_index1", paramInt1);
    localIntent.putExtra("key_age_index2", paramInt2);
    localIntent.putExtra("key_sex_index", paramInt3);
    localIntent.putExtra("key_loc_code", paramArrayOfString1);
    localIntent.putExtra("key_home_code", paramArrayOfString2);
    localIntent.putExtra("key_xingzuo_index", paramInt5);
    localIntent.putExtra("key_job_index", paramInt4);
    localIntent.putExtra("key_has_more", paramBoolean);
    yQ = paramList;
    paramContext.startActivity(localIntent);
  }
  
  private void a(b paramb, RichStatus paramRichStatus)
  {
    paramb.richStatus = paramRichStatus;
    if ((paramRichStatus != null) && (!paramRichStatus.isEmpty()))
    {
      if (!TextUtils.isEmpty(paramRichStatus.actionText))
      {
        paramb.actionId = paramRichStatus.actionId;
        Object localObject = this.jdField_a_of_type_Amhj.i(paramRichStatus.actionId, 200);
        localObject = new BitmapDrawable(getResources(), (Bitmap)localObject);
        int i = this.aTM;
        ((Drawable)localObject).setBounds(0, 0, Math.round(((Drawable)localObject).getIntrinsicWidth() * 1.0F / ((Drawable)localObject).getIntrinsicHeight() * i), i);
        paramb.Rd.setCompoundDrawables((Drawable)localObject, null, null, null);
      }
      for (;;)
      {
        paramb.Rd.setText(paramRichStatus.toSpannableString(""));
        return;
        paramb.actionId = 0;
        paramb.Rd.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
      }
    }
    paramb.actionId = 0;
    paramb.Rd.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
    paramb.Rd.setText("");
  }
  
  private void bcu()
  {
    Object localObject = (ViewGroup)findViewById(2131377361);
    if (localObject != null) {
      IphoneTitleBarActivity.setLayerType((View)localObject);
    }
    localObject = findViewById(2131377498);
    if (localObject != null) {
      IphoneTitleBarActivity.setLayerType((View)localObject);
    }
    localObject = (TextView)findViewById(2131369579);
    if (localObject != null) {
      IphoneTitleBarActivity.setLayerType((View)localObject);
    }
  }
  
  private void cWM()
  {
    if (this.mListView != null)
    {
      this.mListView.setOverScrollHeader(this.g);
      this.mListView.setOverScrollHeight(getResources().getDimensionPixelSize(2131299308));
      this.mListView.setOverScrollListener(this.jdField_c_of_type_Auuo);
    }
  }
  
  private void cWN()
  {
    this.b.addListener(this.jdField_a_of_type_Accv$d);
    Intent localIntent = getIntent();
    String str = localIntent.getStringExtra("key_keyword");
    int i = localIntent.getIntExtra("key_age_index1", 0);
    int j = localIntent.getIntExtra("key_age_index2", 0);
    int k = localIntent.getIntExtra("key_sex_index", 0);
    String[] arrayOfString1 = localIntent.getStringArrayExtra("key_loc_code");
    String[] arrayOfString2 = localIntent.getStringArrayExtra("key_home_code");
    int m = localIntent.getIntExtra("key_xingzuo_index", 0);
    int n = localIntent.getIntExtra("key_job_index", 0);
    this.b.a(true, str, k, i, j, arrayOfString1, arrayOfString2, n, m, 2);
  }
  
  private void cWO()
  {
    if (!aqiw.isNetSupport(this))
    {
      this.cai = 4;
      this.jdField_a_of_type_ComTencentMobileqqConditionsearchSearchResultActivity$a.notifyDataSetChanged();
      return;
    }
    this.b.addListener(this.jdField_a_of_type_Accv$d);
    try
    {
      this.b.a(false, null, 0, 0, 0, null, null, 0, 0, 3);
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SearchResultActivity", 2, localException, new Object[0]);
      }
      this.cai = 0;
      this.jdField_a_of_type_ComTencentMobileqqConditionsearchSearchResultActivity$a.notifyDataSetChanged();
    }
  }
  
  private void inflate()
  {
    if (this.mListView != null)
    {
      this.g = ((PullRefreshHeader)LayoutInflater.from(this).inflate(2131560167, this.mListView, false));
      Drawable localDrawable = getResources().getDrawable(2130839645);
      this.g.setHeaderBgDrawable(localDrawable);
    }
  }
  
  String a(b paramb, CondFitUser paramCondFitUser)
  {
    int j = -15550475;
    StringBuilder localStringBuilder = new StringBuilder();
    paramb.uin = (paramCondFitUser.lUIN + "");
    paramb.FB.setText(paramCondFitUser.strNick);
    localStringBuilder.append(paramCondFitUser.strNick);
    Object localObject2 = this.b.k(paramCondFitUser.locDesc)[1];
    Object localObject1 = localObject2;
    if (((String)localObject2).equals("不限")) {
      localObject1 = "";
    }
    String[] arrayOfString = this.b.k((String)localObject1);
    localObject2 = arrayOfString[1];
    localObject1 = localObject2;
    if (((String)localObject2).equals("不限")) {
      localObject1 = arrayOfString[0];
    }
    localObject2 = localObject1;
    if (((String)localObject1).equals("不限")) {
      localObject2 = "";
    }
    localObject1 = "";
    int i;
    switch (paramCondFitUser.cSex)
    {
    default: 
      i = 0;
      localStringBuilder.append((String)localObject1).append(String.format("%s岁", new Object[] { Long.valueOf(paramCondFitUser.dwAge) })).append((String)localObject2);
      if (i == 0)
      {
        paramb.c.setColorFormat(j);
        paramb.c.setVisibility(0);
        paramb.c.setText(paramCondFitUser.dwAge + "");
        label272:
        if (QLog.isColorLevel()) {
          QLog.i("SearchResultActivity", 2, "bindView jobId=" + paramCondFitUser.iOccupationId);
        }
        if ((paramCondFitUser.iOccupationId <= 0) || (paramCondFitUser.iOccupationId >= accv.dV.length - 1)) {
          break label870;
        }
        paramb.b.setText(accv.dV[paramCondFitUser.iOccupationId]);
        paramb.b.setColorFormat(accv.kg[paramCondFitUser.iOccupationId]);
        paramb.b.setVisibility(0);
        localStringBuilder.append(accv.dV[paramCondFitUser.iOccupationId]);
        label380:
        if ((paramCondFitUser.cConstellationId <= 0) || (paramCondFitUser.cConstellationId >= accv.dT.length)) {
          break label882;
        }
        paramb.d.setText(accv.dT[paramCondFitUser.cConstellationId]);
        paramb.d.setColorFormat(-6065741);
        paramb.d.setVisibility(0);
        localStringBuilder.append(accv.dT[paramCondFitUser.cConstellationId]);
        label445:
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          break label894;
        }
        paramb.e.setVisibility(0);
        paramb.e.setText((CharSequence)localObject2);
        paramb.e.setColorFormat(-8291118);
      }
      break;
    }
    for (;;)
    {
      localObject2 = this.d.b(1, paramb.uin);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject2 = aqhu.G();
        localObject1 = localObject2;
        if (!this.d.isPausing())
        {
          this.d.a(paramb.uin, 1, true, (byte)1);
          localObject1 = localObject2;
        }
      }
      paramb.pV.setImageBitmap((Bitmap)localObject1);
      a(paramb, paramCondFitUser.richStatus);
      localStringBuilder.append(paramb.Rd.getText().toString());
      localObject1 = new StringBuilder("bindview | uin:");
      ((StringBuilder)localObject1).append(paramCondFitUser.lUIN);
      ((StringBuilder)localObject1).append("| nickname:").append(paramCondFitUser.strNick);
      ((StringBuilder)localObject1).append("| sex:").append(paramCondFitUser.cSex);
      ((StringBuilder)localObject1).append("| age:").append(paramCondFitUser.dwAge);
      ((StringBuilder)localObject1).append("| country:").append(paramCondFitUser.dwCountry);
      ((StringBuilder)localObject1).append("| province:").append(paramCondFitUser.dwProvince);
      ((StringBuilder)localObject1).append("| city:").append(paramCondFitUser.dwCity);
      ((StringBuilder)localObject1).append("| occupation:").append(paramCondFitUser.iOccupationId);
      ((StringBuilder)localObject1).append("| horoscope:").append(paramCondFitUser.cConstellationId);
      ((StringBuilder)localObject1).append("| sign:").append(paramb.Rd.getText().toString());
      if (QLog.isColorLevel()) {
        QLog.d("SearchResultActivity", 2, ((StringBuilder)localObject1).toString());
      }
      return localStringBuilder.toString();
      i = 2130841209;
      localObject1 = acfp.m(2131714124);
      break;
      i = 2130841208;
      j = -38511;
      localObject1 = acfp.m(2131714142);
      break;
      paramb.c.setColorFormat(j);
      paramb.c.setCompoundDrawablesWithIntrinsicBounds(i, 0, 0, 0);
      paramb.c.setVisibility(0);
      paramb.c.setText(paramCondFitUser.dwAge + "");
      break label272;
      label870:
      paramb.b.setVisibility(8);
      break label380;
      label882:
      paramb.d.setVisibility(8);
      break label445;
      label894:
      paramb.e.setVisibility(8);
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2131561266);
    setContentBackgroundResource(2130838900);
    setTitle(2131691964);
    setLeftViewName(2131691039);
    bcu();
    this.mHandler = new auru(Looper.getMainLooper(), this.mCallback);
    this.VW = System.currentTimeMillis();
    if (getIntent().getBooleanExtra("key_has_more", false)) {}
    for (int i = 1;; i = 0)
    {
      this.cai = i;
      this.yP = yQ;
      yQ = null;
      if ((this.yP != null) && (this.yP.size() != 0)) {
        break;
      }
      finish();
      return false;
    }
    this.cj = new HashSet();
    this.jdField_a_of_type_Amhj = ((amhj)this.app.getManager(15));
    if (this.jdField_a_of_type_Amhj != null) {
      this.jdField_a_of_type_Amhj.addListener(this.jdField_c_of_type_Amfh);
    }
    this.b = ((accv)this.app.getManager(59));
    this.d = new aqdf(this, this.app);
    this.d.a(this);
    this.aTM = ((int)aqho.convertDpToPixel(this, 12.0F));
    this.mListView = ((XListView)findViewById(2131377546));
    this.mListView.setNeedCheckSpringback(true);
    try
    {
      inflate();
      this.mHandler.sendEmptyMessage(2);
      this.mListView.setOnScrollListener(this);
      this.jdField_a_of_type_ComTencentMobileqqConditionsearchSearchResultActivity$a = new a(null);
      this.mListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqConditionsearchSearchResultActivity$a);
      return true;
    }
    catch (Exception paramBundle)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SearchResultActivity", 2, "infate failure:", paramBundle);
        }
        this.mHandler.sendEmptyMessage(1);
      }
    }
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.d != null)
    {
      this.d.destory();
      this.d = null;
    }
    if (this.b != null) {
      this.b.removeListener(this.jdField_a_of_type_Accv$d);
    }
    if (this.jdField_a_of_type_Amhj != null) {
      this.jdField_a_of_type_Amhj.removeListener(this.jdField_c_of_type_Amfh);
    }
  }
  
  public void onClick(View paramView)
  {
    Object localObject1 = paramView.getTag();
    int i;
    if (localObject1 != null)
    {
      if (!(localObject1 instanceof b)) {
        break label158;
      }
      localObject1 = (b)localObject1;
      if (!this.app.getCurrentAccountUin().equals(((b)localObject1).uin)) {
        break label122;
      }
      i = 0;
    }
    for (;;)
    {
      anot.a(this.app, "CliOper", "", "", "0X8006F0C", "0X8006F0C", 0, 0, "", "", "", "");
      Object localObject2 = new ProfileActivity.AllInOne(((b)localObject1).uin, i);
      ((ProfileActivity.AllInOne)localObject2).nickname = ((b)localObject1).FB.getText().toString();
      ((ProfileActivity.AllInOne)localObject2).bJa = 87;
      ProfileActivity.b(this, (ProfileActivity.AllInOne)localObject2);
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        label122:
        localObject2 = (acff)this.app.getManager(51);
        if ((localObject2 == null) || (!((acff)localObject2).isFriend(((b)localObject1).uin))) {
          break label196;
        }
        i = 1;
        break;
        label158:
        if (((localObject1 instanceof c)) && ((this.cai == 3) || (this.cai == 4)))
        {
          this.cai = 1;
          this.jdField_a_of_type_ComTencentMobileqqConditionsearchSearchResultActivity$a.notifyDataSetChanged();
        }
      }
      label196:
      i = 75;
    }
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if ((paramBitmap != null) && (this.mScrollState == 0))
    {
      paramInt2 = this.mListView.getChildCount();
      paramInt1 = 0;
      while (paramInt1 < paramInt2)
      {
        Object localObject = this.mListView.getChildAt(paramInt1).getTag();
        if ((localObject != null) && ((localObject instanceof b)))
        {
          localObject = (b)localObject;
          if (((b)localObject).uin.equals(paramString)) {
            ((b)localObject).pV.setImageBitmap(paramBitmap);
          }
        }
        paramInt1 += 1;
      }
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
      return;
    }
    if (this.d.isPausing()) {
      this.d.resume();
    }
    this.jdField_a_of_type_ComTencentMobileqqConditionsearchSearchResultActivity$a.notifyDataSetChanged();
  }
  
  public class a
    extends BaseAdapter
  {
    private a() {}
    
    public int getCount()
    {
      int j = SearchResultActivity.this.yP.size();
      if (SearchResultActivity.this.cai != 0) {}
      for (int i = 1;; i = 0) {
        return i + j;
      }
    }
    
    public Object getItem(int paramInt)
    {
      return null;
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public int getItemViewType(int paramInt)
    {
      if (paramInt < SearchResultActivity.this.yP.size()) {
        return 0;
      }
      return 1;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      View localView;
      if (getItemViewType(paramInt) == 0)
      {
        localView = paramView;
        if (paramView == null)
        {
          localView = SearchResultActivity.this.getLayoutInflater().inflate(2131561264, null);
          localView.setOnClickListener(SearchResultActivity.this);
          paramView = new SearchResultActivity.b();
          paramView.pV = ((ImageView)localView.findViewById(2131368406));
          paramView.FB = ((TextView)localView.findViewById(2131372383));
          paramView.Rd = ((TextView)localView.findViewById(2131378401));
          paramView.c = ((InterestLabelTextView)localView.findViewById(2131367941));
          paramView.d = ((InterestLabelTextView)localView.findViewById(2131382387));
          paramView.b = ((InterestLabelTextView)localView.findViewById(2131364332));
          paramView.e = ((InterestLabelTextView)localView.findViewById(2131370841));
          localView.setTag(paramView);
        }
        paramView = (SearchResultActivity.b)localView.getTag();
        CondFitUser localCondFitUser = (CondFitUser)SearchResultActivity.this.yP.get(paramInt);
        paramView = SearchResultActivity.this.a(paramView, localCondFitUser);
        if (SearchResultActivity.bTE) {
          localView.setContentDescription(paramView);
        }
        paramView = localView;
      }
      for (;;)
      {
        EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
        return paramView;
        localView = paramView;
        if (paramView == null)
        {
          localView = SearchResultActivity.this.getLayoutInflater().inflate(2131559672, null);
          localView.setOnClickListener(SearchResultActivity.this);
          paramView = new SearchResultActivity.c();
          localView.setTag(paramView);
          paramView.R = ((ProgressBar)localView.findViewById(2131377037));
          localView.findViewById(2131370781).setVisibility(8);
          paramView.loadingTv = ((TextView)localView.findViewById(2131371975));
        }
        if (SearchResultActivity.this.cai == 1)
        {
          SearchResultActivity.this.cai = 2;
          SearchResultActivity.d(SearchResultActivity.this);
        }
        paramView = (SearchResultActivity.c)localView.getTag();
        if (SearchResultActivity.this.cai == 3)
        {
          paramView.R.setVisibility(8);
          paramView.loadingTv.setText(acfp.m(2131714136));
          paramView = localView;
        }
        else if (SearchResultActivity.this.cai == 2)
        {
          paramView.R.setVisibility(0);
          paramView.loadingTv.setText(acfp.m(2131714127));
          paramView = localView;
        }
        else
        {
          if (SearchResultActivity.this.cai == 4)
          {
            paramView.R.setVisibility(8);
            paramView.loadingTv.setText(acfp.m(2131714126));
          }
          paramView = localView;
        }
      }
    }
    
    public int getViewTypeCount()
    {
      return 2;
    }
  }
  
  public static class b
  {
    public TextView FB;
    public TextView Rd;
    public int actionId;
    public InterestLabelTextView b;
    public InterestLabelTextView c;
    public InterestLabelTextView d;
    public InterestLabelTextView e;
    public ImageView pV;
    public RichStatus richStatus;
    public String uin;
  }
  
  static class c
  {
    public ProgressBar R;
    public TextView loadingTv;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.conditionsearch.SearchResultActivity
 * JD-Core Version:    0.7.0.1
 */