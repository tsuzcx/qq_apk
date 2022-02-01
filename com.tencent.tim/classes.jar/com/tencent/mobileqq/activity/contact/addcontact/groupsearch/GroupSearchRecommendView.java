package com.tencent.mobileqq.activity.contact.addcontact.groupsearch;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import anwa;
import aqcx;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.widget.MeasureListView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.ScrollView;
import java.lang.ref.WeakReference;
import jny;
import jny.a;
import jnz;
import tencent.im.troop_search_popclassifc.popclassifc.HotWordItem;
import tencent.im.troop_search_popclassifc.popclassifc.PopHotWordCard;
import yql;
import yql.a;
import yqo;
import yqp;
import yqp.a;
import yqp.b;

public class GroupSearchRecommendView
  extends ScrollView
{
  private TextView Lu;
  public a a;
  private b jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactGroupsearchGroupSearchRecommendView$b;
  private HotRecommendGroupFlowLayout jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactGroupsearchHotRecommendGroupFlowLayout;
  private MeasureListView jdField_a_of_type_ComTencentMobileqqWidgetMeasureListView;
  private jny.a jdField_a_of_type_Jny$a = new yqo(this);
  private yqp.b jdField_a_of_type_Yqp$b;
  private yqp jdField_a_of_type_Yqp;
  private yql.a jdField_b_of_type_Yql$a;
  private yql jdField_b_of_type_Yql;
  private LinearLayout hz;
  private Context mContext;
  private View mFooterView;
  
  public GroupSearchRecommendView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public GroupSearchRecommendView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public GroupSearchRecommendView(Context paramContext, a parama, yql.a parama1, yqp.b paramb)
  {
    super(paramContext);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactGroupsearchGroupSearchRecommendView$a = parama;
    this.mContext = paramContext;
    this.jdField_b_of_type_Yql$a = parama1;
    this.jdField_a_of_type_Yqp$b = paramb;
  }
  
  private void Az(boolean paramBoolean)
  {
    if (anwa.aze())
    {
      this.Lu.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactGroupsearchHotRecommendGroupFlowLayout.setVisibility(8);
      this.hz.setVisibility(8);
      this.mFooterView.setVisibility(8);
    }
    while (paramBoolean) {
      return;
    }
    jnz localjnz = (jnz)this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactGroupsearchGroupSearchRecommendView$a.getApp().getManager(80);
    if ((localjnz.a() != null) && (localjnz.a().rpt_pop_items.size() > 0))
    {
      this.Lu.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactGroupsearchHotRecommendGroupFlowLayout.setVisibility(0);
      this.hz.setVisibility(0);
      this.mFooterView.setVisibility(0);
      this.jdField_a_of_type_Yqp.clearData();
      int i = 0;
      while (i < localjnz.a().rpt_pop_items.size())
      {
        this.jdField_a_of_type_Yqp.a(new yqp.a(((popclassifc.HotWordItem)localjnz.a().rpt_pop_items.get(i)).str_hot_word.get(), ((popclassifc.HotWordItem)localjnz.a().rpt_pop_items.get(i)).str_text_color.get()));
        i += 1;
      }
      this.jdField_a_of_type_Yqp.notifyDataSetChanged();
      return;
    }
    this.Lu.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactGroupsearchHotRecommendGroupFlowLayout.setVisibility(8);
    this.hz.setVisibility(8);
    this.mFooterView.setVisibility(8);
  }
  
  private void ckL()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactGroupsearchGroupSearchRecommendView$b = new b(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetMeasureListView = ((MeasureListView)findViewById(2131370945));
    this.jdField_b_of_type_Yql = new yql(this.mContext, this.jdField_a_of_type_ComTencentMobileqqWidgetMeasureListView, this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactGroupsearchGroupSearchRecommendView$a.getApp().getCurrentUin());
    this.jdField_b_of_type_Yql.a(this.jdField_b_of_type_Yql$a);
    this.mFooterView = new View(this.mContext);
    this.mFooterView.setBackgroundResource(2130851090);
    this.mFooterView.setLayoutParams(new AbsListView.LayoutParams(-1, aqcx.dip2px(this.mContext, 12.0F)));
    this.jdField_a_of_type_ComTencentMobileqqWidgetMeasureListView.setVerticalScrollBarEnabled(false);
    this.jdField_a_of_type_ComTencentMobileqqWidgetMeasureListView.setFastScrollEnabled(false);
    LinearLayout localLinearLayout = new LinearLayout(this.mContext);
    localLinearLayout.addView(this.mFooterView);
    this.jdField_a_of_type_ComTencentMobileqqWidgetMeasureListView.addFooterView(localLinearLayout);
    this.jdField_a_of_type_ComTencentMobileqqWidgetMeasureListView.setAdapter(this.jdField_b_of_type_Yql);
    this.Lu = ((TextView)findViewById(2131380757));
    this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactGroupsearchHotRecommendGroupFlowLayout = ((HotRecommendGroupFlowLayout)findViewById(2131367176));
    this.hz = ((LinearLayout)findViewById(2131370684));
    this.jdField_a_of_type_Yqp = new yqp(this.mContext);
    this.jdField_a_of_type_Yqp.a(this.jdField_a_of_type_Yqp$b);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactGroupsearchHotRecommendGroupFlowLayout.setAdapter(this.jdField_a_of_type_Yqp);
    Az(false);
    setOverScrollMode(0);
    setVerticalScrollBarEnabled(false);
    setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    if (anwa.aze())
    {
      this.Lu.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactGroupsearchHotRecommendGroupFlowLayout.setVisibility(8);
      this.hz.setVisibility(8);
      this.mFooterView.setVisibility(8);
    }
  }
  
  private void ckM()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactGroupsearchGroupSearchRecommendView$b.sendEmptyMessage(1);
  }
  
  private void ckN()
  {
    new jny(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactGroupsearchGroupSearchRecommendView$a.getApp()).a(this.jdField_a_of_type_Jny$a);
  }
  
  public void onCreate()
  {
    setContentView(2131561752);
    ckL();
    ckM();
  }
  
  public void onResume()
  {
    if (this.jdField_b_of_type_Yql != null) {
      this.jdField_b_of_type_Yql.refreshData();
    }
  }
  
  protected final void setContentView(int paramInt)
  {
    ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(paramInt, this, true);
  }
  
  public static abstract interface a
  {
    public abstract Activity getActivity();
    
    public abstract QQAppInterface getApp();
  }
  
  public static class b
    extends Handler
  {
    public WeakReference<GroupSearchRecommendView> mWeakReference;
    
    b(GroupSearchRecommendView paramGroupSearchRecommendView)
    {
      this.mWeakReference = new WeakReference(paramGroupSearchRecommendView);
    }
    
    public void handleMessage(Message paramMessage)
    {
      GroupSearchRecommendView localGroupSearchRecommendView = (GroupSearchRecommendView)this.mWeakReference.get();
      if (localGroupSearchRecommendView == null) {
        return;
      }
      super.handleMessage(paramMessage);
      switch (paramMessage.what)
      {
      default: 
        return;
      case 1: 
        GroupSearchRecommendView.a(localGroupSearchRecommendView);
        return;
      case 2: 
        if (QLog.isColorLevel()) {
          QLog.i("GroupSearchRecommendView", 2, "fetch data successfully");
        }
        GroupSearchRecommendView.a(localGroupSearchRecommendView, false);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.i("GroupSearchRecommendView", 2, "fetch data failed");
      }
      GroupSearchRecommendView.a(localGroupSearchRecommendView, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.groupsearch.GroupSearchRecommendView
 * JD-Core Version:    0.7.0.1
 */