package com.tencent.mobileqq.troop.homework.recite.ui;

import acfp;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.TextView;
import apjt;
import apju;
import apjv;
import apjw;
import apjx;
import apki;
import aprb.a;
import aprc;
import aqec;
import aqec.a;
import aqfr;
import ausj;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.homework.entry.ui.api.AbsHomeWorkFragment;
import com.tencent.mobileqq.troop.widget.FlowLayout;
import com.tencent.mobileqq.troop.widget.LoadMoreXListView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import rsn;

public class SearchReciteArticleFragment
  extends AbsHomeWorkFragment
  implements aprb.a
{
  protected View IA;
  protected View IB;
  protected boolean Yp;
  protected apki a;
  public a a;
  public c a;
  protected FlowLayout a;
  public LoadMoreXListView a;
  protected volatile long ajN;
  protected aprc b;
  public EditText bC;
  protected aprc c;
  protected boolean cQY;
  InputMethodManager g;
  public int mStartIndex;
  public String mTroopUin;
  
  public static CharSequence c(String paramString1, String paramString2, int paramInt)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {}
    LinkedList localLinkedList;
    int i;
    int j;
    do
    {
      return paramString2;
      localLinkedList = new LinkedList();
      i = 0;
      j = paramString2.length();
      while (i < j)
      {
        if (paramString1.contains(String.valueOf(paramString2.charAt(i)))) {
          localLinkedList.offer(Integer.valueOf(i));
        }
        i += 1;
      }
    } while (localLinkedList.isEmpty());
    paramString1 = new SpannableString(paramString2);
    while (!localLinkedList.isEmpty())
    {
      j = ((Integer)localLinkedList.poll()).intValue();
      i = j + 1;
      while ((!localLinkedList.isEmpty()) && (i == ((Integer)localLinkedList.peek()).intValue()))
      {
        localLinkedList.poll();
        i += 1;
      }
      paramString1.setSpan(new ForegroundColorSpan(paramInt), j, i, 33);
    }
    return paramString1;
  }
  
  public static void ci(Context paramContext, String paramString)
  {
    f(paramContext, paramString, "", -2147483648);
  }
  
  public static void f(Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    Intent localIntent = new Intent();
    String str = paramString2;
    if (paramString2.startsWith("《"))
    {
      str = paramString2;
      if (paramString2.endsWith("》")) {
        str = paramString2.substring(1, paramString2.length() - 1);
      }
    }
    localIntent.putExtra("keywords", str);
    localIntent.putExtra("troop_uin", paramString1);
    AbsHomeWorkFragment.a((Activity)paramContext, SearchReciteArticleFragment.class, localIntent, paramInt, "");
  }
  
  public void RO(boolean paramBoolean)
  {
    int i = 0;
    this.cQY = paramBoolean;
    if (paramBoolean)
    {
      this.IB.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetLoadMoreXListView.setVisibility(0);
      this.IA.setVisibility(8);
      return;
    }
    View localView = this.IB;
    if (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiSearchReciteArticleFragment$a.getCount() != 0) {}
    for (;;)
    {
      localView.setVisibility(i);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetLoadMoreXListView.setVisibility(8);
      this.IA.setVisibility(8);
      return;
      i = 8;
    }
  }
  
  public void SP(@Nullable String paramString) {}
  
  public void SW(String paramString)
  {
    QQAppInterface localQQAppInterface = getQQAppInterface();
    if (localQQAppInterface != null)
    {
      this.ajN = System.currentTimeMillis();
      eak();
      if (QLog.isColorLevel()) {
        QLog.i("SearchReciteArticleFragment", 2, "request search start is " + this.mStartIndex);
      }
      this.b = this.jdField_a_of_type_Apki.a(localQQAppInterface, this, paramString, this.mStartIndex, 10, 10002);
    }
  }
  
  public void a(int paramInt, b paramb)
  {
    this.g.hideSoftInputFromInputMethod(this.bC.getWindowToken(), 0);
    this.bC.clearFocus();
    ausj localausj = ausj.e(getActivity());
    localausj.a(new apjx(this, localausj, paramb, paramInt));
    if (paramb.type != 2) {
      localausj.addButton(acfp.m(2131714144));
    }
    localausj.addButton(acfp.m(2131714128));
    localausj.addCancelButton(acfp.m(2131714135));
    localausj.show();
  }
  
  public void a(JSONObject paramJSONObject, int paramInt, Bundle paramBundle)
  {
    if (this.Yp) {
      return;
    }
    switch (paramInt)
    {
    default: 
      return;
    case 10001: 
      c(paramJSONObject, paramBundle);
      return;
    }
    d(paramJSONObject, paramBundle);
  }
  
  protected void aDR()
  {
    this.bC = ((EditText)findViewById(2131366542));
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetLoadMoreXListView = ((LoadMoreXListView)findViewById(2131377856));
    this.IA = findViewById(2131372437);
    this.IB = findViewById(2131370635);
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetFlowLayout = ((FlowLayout)findViewById(2131367332));
  }
  
  public void b(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    aDR();
    initViews();
    this.bC.requestFocus();
    eaj();
  }
  
  protected void c(JSONObject paramJSONObject, Bundle paramBundle)
  {
    String str2 = "0";
    if (paramJSONObject != null) {
      if (QLog.isColorLevel()) {
        QLog.d("SearchReciteArticleFragment", 2, paramJSONObject.toString());
      }
    }
    for (;;)
    {
      int i;
      String str1;
      try
      {
        i = paramJSONObject.getInt("retcode");
        if (i != 0) {
          continue;
        }
        localObject = paramJSONObject.getJSONObject("result");
        if (localObject == null) {
          break label373;
        }
        i = ((JSONObject)localObject).getInt("errCode");
        if (i != 0) {
          continue;
        }
        JSONArray localJSONArray = ((JSONObject)localObject).optJSONArray("rs");
        if (localJSONArray != null)
        {
          int j = localJSONArray.length();
          if (j != 0)
          {
            i = 0;
            if (i < j)
            {
              String str3 = localJSONArray.optString(i);
              localObject = str3;
              if (str3.startsWith("《"))
              {
                localObject = str3;
                if (str3.endsWith("》")) {
                  localObject = str3.substring(1, str3.length() - 1);
                }
              }
              this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiSearchReciteArticleFragment$a.JH((String)localObject);
              i += 1;
              continue;
            }
            this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiSearchReciteArticleFragment$a.notifyDataSetChanged();
            if (!this.cQY) {
              RO(false);
            }
          }
        }
        i = 1;
        localObject = str2;
      }
      catch (JSONException localJSONException)
      {
        Object localObject;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("SearchReciteArticleFragment", 2, localJSONException, new Object[0]);
        str1 = "-1";
        i = 0;
        continue;
      }
      if (i == 0)
      {
        if ((QLog.isColorLevel()) && (paramBundle != null)) {
          QLog.e("SearchReciteArticleFragment", 2, new Object[] { "onGetKeywordListCallBack server error: ", paramBundle, "\n", paramJSONObject });
        }
        eam();
        paramJSONObject = (JSONObject)localObject;
        if (i != 0)
        {
          i = 1;
          aqfr.b("Grp_edu", "publish_homework", "get_search_keywords", 0, i, new String[] { paramJSONObject });
          return;
          localObject = String.valueOf(i);
          i = 0;
          continue;
          localObject = String.valueOf(i);
          i = 0;
          continue;
          if ((QLog.isColorLevel()) && (paramBundle != null)) {
            QLog.e("SearchReciteArticleFragment", 2, new Object[] { "onGetKeywordListCallBack client error: ", paramBundle });
          }
          paramJSONObject = "-1";
          i = 0;
        }
        else
        {
          i = 2;
        }
      }
      else
      {
        paramJSONObject = str1;
        continue;
        label373:
        i = 0;
        str1 = str2;
      }
    }
  }
  
  protected void d(JSONObject paramJSONObject, Bundle paramBundle)
  {
    boolean bool4 = false;
    boolean bool1 = false;
    int k;
    int i;
    boolean bool3;
    int j;
    boolean bool2;
    if (paramJSONObject != null)
    {
      k = 0;
      i = 0;
      bool3 = true;
      bool1 = true;
      if (this.mStartIndex != 0) {
        break label599;
      }
      j = 1;
      if (QLog.isColorLevel()) {
        QLog.i("SearchReciteArticleFragment", 2, paramJSONObject.toString());
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetLoadMoreXListView.a.uh(true);
      bool2 = bool1;
    }
    for (;;)
    {
      try
      {
        m = paramJSONObject.getInt("retcode");
        if (m != 0) {
          continue;
        }
        bool2 = bool1;
        localObject = paramJSONObject.getJSONObject("result");
        if (localObject == null) {
          break label583;
        }
        bool2 = bool1;
        m = ((JSONObject)localObject).getInt("errCode");
        bool2 = bool1;
        if (((JSONObject)localObject).getInt("is_end") != 0) {
          break label605;
        }
        bool1 = true;
        if (m != 0) {
          continue;
        }
        bool4 = true;
        bool2 = bool1;
        bool3 = bool1;
        if (!((JSONObject)localObject).has("rs")) {
          break label583;
        }
        bool2 = bool1;
        JSONArray localJSONArray = ((JSONObject)localObject).getJSONArray("rs");
        if (localJSONArray == null) {
          break label578;
        }
        bool2 = bool1;
        m = localJSONArray.length();
        if (m == 0) {
          break label578;
        }
        i = 0;
        if (i < m)
        {
          bool2 = bool1;
          this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiSearchReciteArticleFragment$c.a((b)aqec.convertFromJsonObject(localJSONArray.optJSONObject(i), b.class));
          i += 1;
          continue;
        }
        bool2 = bool1;
        this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiSearchReciteArticleFragment$c.rq(((JSONObject)localObject).optString("key", ""));
        bool2 = bool1;
        this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiSearchReciteArticleFragment$c.notifyDataSetChanged();
        bool2 = bool1;
        this.mStartIndex += 10;
        i = 1;
        localObject = "0";
        bool2 = true;
        bool3 = bool1;
        bool1 = bool2;
        bool2 = bool3;
      }
      catch (JSONException localJSONException)
      {
        int m;
        Object localObject;
        bool1 = false;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("SearchReciteArticleFragment", 2, localJSONException, new Object[0]);
        str = "-1";
        i = k;
        continue;
      }
      if ((j != 0) && (i == 0))
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetLoadMoreXListView.setVisibility(8);
        this.IA.setVisibility(0);
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetLoadMoreXListView.a.ax(bool1, bool2);
      if (!bool1)
      {
        if ((QLog.isColorLevel()) && (paramBundle != null)) {
          QLog.e("SearchReciteArticleFragment", 2, new Object[] { "onSearchArticleCallBack server error: ", paramBundle, "\n", paramJSONObject });
        }
        eam();
      }
      paramJSONObject = (JSONObject)localObject;
      if (paramBundle != null)
      {
        localObject = paramBundle.getString("key", "");
        paramBundle = paramBundle.getString("start", "");
        if (bool1)
        {
          i = 1;
          aqfr.b("Grp_edu", "publish_homework", "kewen_search", 0, i, new String[] { localObject, paramBundle, paramJSONObject });
        }
      }
      else
      {
        return;
        bool4 = false;
        bool3 = bool1;
        bool2 = bool1;
        localObject = String.valueOf(m);
        bool1 = bool3;
        bool2 = bool4;
        continue;
        bool2 = false;
        bool1 = true;
        localObject = String.valueOf(m);
        continue;
        if ((QLog.isColorLevel()) && (paramBundle != null)) {
          QLog.e("SearchReciteArticleFragment", 2, new Object[] { "onSearchArticleCallBack client error: ", paramBundle });
        }
        eam();
        paramJSONObject = "-1";
        continue;
      }
      i = 2;
      continue;
      label578:
      i = 0;
      continue;
      label583:
      bool1 = bool3;
      String str = "0";
      bool2 = bool4;
      continue;
      label599:
      j = 0;
      break;
      label605:
      bool1 = false;
    }
  }
  
  protected void eaj()
  {
    QQAppInterface localQQAppInterface = getQQAppInterface();
    if (localQQAppInterface != null)
    {
      eal();
      this.c = this.jdField_a_of_type_Apki.a(localQQAppInterface, this, this.mTroopUin, 10001);
    }
  }
  
  public void eak()
  {
    if (this.b != null)
    {
      this.b.cancel(true);
      this.b = null;
    }
  }
  
  protected void eal()
  {
    if (this.c != null)
    {
      this.c.cancel(true);
      this.c = null;
    }
  }
  
  protected void eam()
  {
    QQToast.a(getActivity(), acfp.m(2131714131), 0).show();
  }
  
  public int getContentLayoutId()
  {
    return 2131560818;
  }
  
  public void init(Bundle paramBundle)
  {
    super.init(paramBundle);
    this.mTroopUin = paramBundle.getString("troop_uin");
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiSearchReciteArticleFragment$a = new a();
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiSearchReciteArticleFragment$c = new c(this);
    this.jdField_a_of_type_Apki = new apki();
    this.g = ((InputMethodManager)getActivity().getSystemService("input_method"));
  }
  
  protected void initViews()
  {
    setTitle(acfp.m(2131714134));
    this.bC.addTextChangedListener(new apjt(this));
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiSearchReciteArticleFragment$a.a = new apju(this);
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetFlowLayout.setAdapter(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiSearchReciteArticleFragment$a);
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetLoadMoreXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiSearchReciteArticleFragment$c);
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetLoadMoreXListView.setOnItemClickListener(new apjv(this));
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetLoadMoreXListView.a.setOnLoadMoreListener(new apjw(this));
    String str = getArguments().getString("keywords", "");
    if (!TextUtils.isEmpty(str)) {
      this.bC.setText(str);
    }
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    super.initWindowStyleAndAnimation(paramActivity);
    paramActivity.getWindow().setSoftInputMode(36);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt2 == 257) && (paramIntent != null))
    {
      paramIntent = paramIntent.getStringExtra("HomeWorkConstants:homework_default_result_key");
      if (TextUtils.isEmpty(paramIntent)) {}
    }
    try
    {
      bK(new JSONObject(paramIntent));
      finish();
      return;
    }
    catch (JSONException paramIntent)
    {
      paramIntent.printStackTrace();
    }
  }
  
  public void onDestroy()
  {
    this.Yp = true;
    eal();
    eak();
    super.onDestroy();
  }
  
  public static class a
    extends BaseAdapter
  {
    public a a;
    protected List<String> sX = new ArrayList();
    
    public void JH(String paramString)
    {
      this.sX.add(paramString);
    }
    
    public int getCount()
    {
      return this.sX.size();
    }
    
    public String getItem(int paramInt)
    {
      return (String)this.sX.get(paramInt);
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      View localView;
      if (paramView == null)
      {
        localView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131560833, null, false);
        paramView = new b();
        paramView.textView = ((TextView)localView.findViewById(2131380958));
        paramView.textView.setOnClickListener(paramView);
        localView.setTag(paramView);
      }
      for (;;)
      {
        Object localObject = getItem(paramInt);
        paramView.position = paramInt;
        paramView.textView.setText((CharSequence)localObject);
        EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
        return localView;
        localObject = (b)paramView.getTag();
        localView = paramView;
        paramView = (View)localObject;
      }
    }
    
    public static abstract interface a
    {
      public abstract void onItemClick(View paramView, int paramInt);
    }
    
    public class b
      implements View.OnClickListener
    {
      int position;
      TextView textView;
      
      protected b() {}
      
      public void onClick(View paramView)
      {
        if (SearchReciteArticleFragment.a.this.a != null) {
          SearchReciteArticleFragment.a.this.a.onItemClick(paramView, this.position);
        }
        EventCollector.getInstance().onViewClicked(paramView);
      }
    }
  }
  
  public static class b
  {
    @aqec.a("kid")
    public String kid;
    @aqec.a("title")
    public String title;
    @aqec.a("type")
    public int type;
    @aqec.a("content_text")
    public String xx;
  }
  
  public static class c
    extends BaseAdapter
  {
    protected SearchReciteArticleFragment b;
    protected String bIC;
    protected List<SearchReciteArticleFragment.b> mDataList = new ArrayList();
    
    public c(SearchReciteArticleFragment paramSearchReciteArticleFragment)
    {
      this.b = paramSearchReciteArticleFragment;
    }
    
    public SearchReciteArticleFragment.b a(int paramInt)
    {
      return (SearchReciteArticleFragment.b)this.mDataList.get(paramInt);
    }
    
    public void a(SearchReciteArticleFragment.b paramb)
    {
      this.mDataList.add(paramb);
    }
    
    public void clearData()
    {
      this.mDataList.clear();
    }
    
    public int getCount()
    {
      return this.mDataList.size();
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      View localView;
      if (paramView == null)
      {
        localView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131560832, null, false);
        paramView = new a();
        paramView.tvTitle = ((TextView)localView.findViewById(2131380976));
        paramView.Vg = ((TextView)localView.findViewById(2131380630));
        localView.setTag(paramView);
      }
      for (;;)
      {
        paramView.position = paramInt;
        Object localObject = a(paramInt);
        paramView.tvTitle.setText(SearchReciteArticleFragment.c(this.bIC, ((SearchReciteArticleFragment.b)localObject).title, Color.parseColor("#00B6F9")));
        paramView.Vg.setText(((SearchReciteArticleFragment.b)localObject).xx);
        EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
        return localView;
        localObject = (a)paramView.getTag();
        localView = paramView;
        paramView = (View)localObject;
      }
    }
    
    public void rq(String paramString)
    {
      this.bIC = paramString;
    }
    
    public class a
    {
      TextView Vg;
      int position;
      TextView tvTitle;
      
      protected a() {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.recite.ui.SearchReciteArticleFragment
 * JD-Core Version:    0.7.0.1
 */