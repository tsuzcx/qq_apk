package com.tencent.mobileqq.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.contact.SearchResultDialog.HistoryListChangeListener;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.international.LocaleString;
import com.tencent.mobileqq.search.ConversationSearchAdapter.SearchResultCallBack;
import com.tencent.mobileqq.search.IContactSearchable;
import com.tencent.mobileqq.search.SearchAdapterInterface;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.XListView;
import fcl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ContactsSearchResultAdapter
  extends BaseSearchResultAdapter
  implements SearchAdapterInterface, AbsListView.OnScrollListener
{
  private Context jdField_a_of_type_AndroidContentContext;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private SearchResultDialog.HistoryListChangeListener jdField_a_of_type_ComTencentMobileqqActivityContactSearchResultDialog$HistoryListChangeListener;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private HashMap jdField_a_of_type_JavaUtilHashMap = new ContactsSearchResultAdapter.1(this);
  private boolean b;
  
  public ContactsSearchResultAdapter(QQAppInterface paramQQAppInterface, Context paramContext, XListView paramXListView, List paramList, View.OnClickListener paramOnClickListener, boolean paramBoolean, SearchResultDialog.HistoryListChangeListener paramHistoryListChangeListener)
  {
    super(paramContext, paramQQAppInterface, paramXListView, paramList);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
    this.b = paramBoolean;
    this.jdField_a_of_type_ComTencentMobileqqActivityContactSearchResultDialog$HistoryListChangeListener = paramHistoryListChangeListener;
  }
  
  private String a(String paramString)
  {
    String str = paramString;
    if (paramString != null)
    {
      str = paramString;
      if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString)) {
        str = BaseApplicationImpl.getContext().getString(((Integer)this.jdField_a_of_type_JavaUtilHashMap.get(paramString)).intValue());
      }
    }
    return str;
  }
  
  public void a()
  {
    super.a();
  }
  
  public void a(ConversationSearchAdapter.SearchResultCallBack paramSearchResultCallBack)
  {
    this.a = paramSearchResultCallBack;
  }
  
  public void d()
  {
    super.c();
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject1;
    label198:
    Object localObject2;
    String str;
    if (paramView == null)
    {
      paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903149, paramViewGroup, false);
      paramViewGroup = new ContactsSearchResultAdapter.ViewTag();
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131231408));
      paramViewGroup.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131231409));
      paramViewGroup.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131231412));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131231411));
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131231413));
      paramViewGroup.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131231414));
      paramViewGroup.d = ((ImageView)paramView.findViewById(2131231415));
      paramView.setTag(paramViewGroup);
      localObject1 = (IContactSearchable)getItem(paramInt);
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(((IContactSearchable)localObject1).c());
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setText(((IContactSearchable)localObject1).b());
      paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setImageResource(((IContactSearchable)localObject1).a());
      if (!this.b) {
        break label351;
      }
      paramViewGroup.d.setVisibility(0);
      paramViewGroup.d.setOnClickListener(new fcl(this, (IContactSearchable)localObject1));
      if (!(this.jdField_a_of_type_AndroidContentContext instanceof SelectMemberActivity)) {
        break label426;
      }
      localObject2 = (SelectMemberActivity)this.jdField_a_of_type_AndroidContentContext;
      str = ((IContactSearchable)localObject1).d();
      if ((((SelectMemberActivity)localObject2).a == null) || (!((SelectMemberActivity)localObject2).a.contains(str))) {
        break label383;
      }
      paramViewGroup.jdField_c_of_type_AndroidWidgetTextView.setText(2131561612);
      label254:
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(a(((IContactSearchable)localObject1).d(), ((IContactSearchable)localObject1).b()));
      paramViewGroup.jdField_a_of_type_JavaLangString = ((IContactSearchable)localObject1).d();
      paramViewGroup.jdField_a_of_type_Int = ((IContactSearchable)localObject1).b();
      localObject1 = ((IContactSearchable)localObject1).a();
      if (localObject1 != null) {
        break label490;
      }
      paramViewGroup.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_AndroidViewView$OnClickListener != null)
      {
        paramView.setTag(-1, Integer.valueOf(paramInt));
        paramView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      }
      return paramView;
      paramViewGroup = (ContactsSearchResultAdapter.ViewTag)paramView.getTag();
      break;
      label351:
      localObject2 = (RelativeLayout.LayoutParams)paramViewGroup.jdField_c_of_type_AndroidWidgetTextView.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject2).addRule(11, -1);
      paramViewGroup.jdField_c_of_type_AndroidWidgetTextView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      break label198;
      label383:
      if (((SelectMemberActivity)localObject2).a(str))
      {
        paramViewGroup.jdField_c_of_type_AndroidWidgetTextView.setText(2131562853);
        break label254;
      }
      paramViewGroup.jdField_c_of_type_AndroidWidgetTextView.setText(LocaleString.b(BaseApplicationImpl.getContext(), ((IContactSearchable)localObject1).a()));
      break label254;
      label426:
      localObject2 = ((IContactSearchable)localObject1).a();
      if ((this.b) && (this.jdField_a_of_type_JavaUtilHashMap.containsKey(localObject2)))
      {
        localObject2 = a((String)localObject2);
        paramViewGroup.jdField_c_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
        break label254;
      }
      paramViewGroup.jdField_c_of_type_AndroidWidgetTextView.setText(LocaleString.b(BaseApplicationImpl.getContext(), (String)localObject2));
      break label254;
      label490:
      paramViewGroup.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
      paramViewGroup.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.ContactsSearchResultAdapter
 * JD-Core Version:    0.7.0.1
 */