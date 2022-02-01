package com.tencent.mobileqq.troop.homework.recite.ui;

import acfp;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import apjy;
import apjz;
import apka;
import apki;
import aprb.a;
import aprc;
import apuw;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.homework.entry.ui.api.AbsHomeWorkFragment;
import com.tencent.mobileqq.troop.homework.recite.data.ArticleInfo;
import com.tencent.mobileqq.troop.homework.recite.data.ParagraphInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONObject;

public class SelectReciteParagraphFragment
  extends AbsHomeWorkFragment
  implements aprb.a
{
  protected static final String cpI = acfp.m(2131714243);
  protected static final String cpJ = acfp.m(2131714244);
  protected XListView X;
  protected boolean Yp;
  protected apki a;
  protected aprc a;
  public ArticleInfo a;
  public a a;
  protected String cpK;
  public Set<Integer> dg = new HashSet();
  protected Button hp;
  public String mTroopUin;
  
  public static void a(Context paramContext, String paramString1, String paramString2, ArrayList<Integer> paramArrayList, int paramInt)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("kid", paramString2);
    localIntent.putExtra("troop_uin", paramString1);
    if (paramArrayList != null) {
      localIntent.putExtra("selected_list", paramArrayList);
    }
    AbsHomeWorkFragment.a((Activity)paramContext, SelectReciteParagraphFragment.class, localIntent, paramInt, "");
  }
  
  public static void f(Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    a(paramContext, paramString1, paramString2, new ArrayList(0), paramInt);
  }
  
  public void SP(@Nullable String paramString) {}
  
  public void a(JSONObject paramJSONObject, int paramInt, Bundle paramBundle)
  {
    if (this.Yp) {
      return;
    }
    switch (paramInt)
    {
    default: 
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataArticleInfo = ArticleInfo.onHandleGetArticleDetail(paramBundle, paramJSONObject);
    if (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataArticleInfo == null)
    {
      eam();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiSelectReciteParagraphFragment$a = new a(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataArticleInfo.paragraphs, this.dg);
    this.X.setAdapter(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiSelectReciteParagraphFragment$a);
    eap();
  }
  
  public void b(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    ean();
    initView();
    eao();
  }
  
  protected void eam()
  {
    QQToast.a(getActivity(), acfp.m(2131714240), 0).show();
  }
  
  protected void ean()
  {
    this.X = ((XListView)findViewById(2131372851));
    this.hp = ((Button)findViewById(2131363960));
  }
  
  protected void eao()
  {
    QQAppInterface localQQAppInterface = getQQAppInterface();
    if (localQQAppInterface != null) {
      this.jdField_a_of_type_Aprc = this.jdField_a_of_type_Apki.a(localQQAppInterface, this, this.cpK, null, 10003);
    }
  }
  
  public void eap()
  {
    if (this.dg.isEmpty())
    {
      this.hp.setText(acfp.m(2131714241));
      this.hp.setEnabled(false);
    }
    while (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiSelectReciteParagraphFragment$a == null) {
      return;
    }
    this.hp.setEnabled(true);
    Iterator localIterator = this.dg.iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      int j = ((Integer)localIterator.next()).intValue();
      String str = this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiSelectReciteParagraphFragment$a.a(j).content_html;
      if (str == null) {
        break label199;
      }
      i = str.length() + i;
    }
    label199:
    for (;;)
    {
      break;
      if (this.dg.size() == this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiSelectReciteParagraphFragment$a.getCount())
      {
        this.hp.setText(String.format(acfp.m(2131714242), new Object[] { Integer.valueOf(i) }));
        return;
      }
      this.hp.setText(String.format(cpI, new Object[] { apka.R(new ArrayList(this.dg)), Integer.valueOf(i) }));
      return;
    }
  }
  
  public int getContentLayoutId()
  {
    return 2131560819;
  }
  
  public void init(Bundle paramBundle)
  {
    super.init(paramBundle);
    this.mTroopUin = paramBundle.getString("troop_uin", "");
    this.cpK = paramBundle.getString("kid", "");
    paramBundle = paramBundle.getIntegerArrayList("selected_list");
    if ((paramBundle != null) && (!paramBundle.isEmpty())) {
      this.dg.addAll(paramBundle);
    }
    this.jdField_a_of_type_Apki = new apki();
  }
  
  protected void initView()
  {
    setTitle(acfp.m(2131714239));
    this.X.setOnItemClickListener(new apjy(this));
    this.hp.setOnClickListener(new apjz(this));
    eap();
  }
  
  public void onDestroy()
  {
    this.Yp = true;
    if (this.jdField_a_of_type_Aprc != null) {
      this.jdField_a_of_type_Aprc.cancel(true);
    }
    super.onDestroy();
  }
  
  public static class a
    extends BaseAdapter
  {
    protected Set<Integer> dg;
    protected List<ParagraphInfo> mDataList;
    
    public a(List<ParagraphInfo> paramList, Set<Integer> paramSet)
    {
      this.mDataList = paramList;
      this.dg = paramSet;
    }
    
    public ParagraphInfo a(int paramInt)
    {
      return (ParagraphInfo)this.mDataList.get(paramInt);
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
      View localView = paramView;
      if (paramView == null) {
        localView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131560834, paramViewGroup, false);
      }
      Object localObject1 = (CheckBox)localView.findViewById(2131364585);
      paramView = (TextView)localView.findViewById(2131380630);
      ((CheckBox)localObject1).setChecked(this.dg.contains(Integer.valueOf(paramInt)));
      Object localObject2 = a(paramInt);
      localObject1 = String.format(SelectReciteParagraphFragment.cpJ, new Object[] { Integer.valueOf(((ParagraphInfo)localObject2).pid + 1) });
      localObject2 = new SpannableString((String)localObject1 + ((ParagraphInfo)localObject2).content_html);
      ((SpannableString)localObject2).setSpan(new apuw(paramViewGroup.getContext(), paramViewGroup.getContext().getResources().getColor(2131167378), 17, 4, 3, 12, Color.parseColor("#777777"), (String)localObject1), 0, ((String)localObject1).length(), 33);
      paramView.setText((CharSequence)localObject2);
      EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
      return localView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.recite.ui.SelectReciteParagraphFragment
 * JD-Core Version:    0.7.0.1
 */