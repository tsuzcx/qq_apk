package com.tencent.mobileqq.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.search.ConversationSearchAdapter.SearchResultCallBack;
import com.tencent.mobileqq.search.IContactSearchable;
import com.tencent.mobileqq.search.SearchAdapterInterface;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.List;

public class ContactsSearchResultAdapter
  extends BaseSearchResultAdapter
  implements SearchAdapterInterface, AbsListView.OnScrollListener
{
  private Context jdField_a_of_type_AndroidContentContext;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private boolean b;
  
  public ContactsSearchResultAdapter(QQAppInterface paramQQAppInterface, Context paramContext, XListView paramXListView, List paramList, View.OnClickListener paramOnClickListener, boolean paramBoolean)
  {
    super(paramContext, paramQQAppInterface, paramXListView, paramList);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
    this.b = paramBoolean;
  }
  
  public void a()
  {
    super.a();
  }
  
  public void a(ConversationSearchAdapter.SearchResultCallBack paramSearchResultCallBack)
  {
    this.a = paramSearchResultCallBack;
  }
  
  public void b()
  {
    super.b();
  }
  
  public void e()
  {
    super.d();
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject;
    SelectMemberActivity localSelectMemberActivity;
    String str;
    if (paramView == null)
    {
      paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903125, paramViewGroup, false);
      paramViewGroup = new ContactsSearchResultAdapter.ViewTag();
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131296873));
      paramViewGroup.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131296874));
      paramViewGroup.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131296877));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131296876));
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131296879));
      paramViewGroup.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131296878));
      paramView.setTag(paramViewGroup);
      localObject = (IContactSearchable)getItem(paramInt);
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(((IContactSearchable)localObject).a());
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setText(((IContactSearchable)localObject).c());
      paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setImageResource(((IContactSearchable)localObject).a());
      if (!(this.jdField_a_of_type_AndroidContentContext instanceof SelectMemberActivity)) {
        break label343;
      }
      localSelectMemberActivity = (SelectMemberActivity)this.jdField_a_of_type_AndroidContentContext;
      str = ((IContactSearchable)localObject).d();
      if ((localSelectMemberActivity.a == null) || (!localSelectMemberActivity.a.contains(str))) {
        break label306;
      }
      paramViewGroup.jdField_c_of_type_AndroidWidgetTextView.setText(2131363239);
      label209:
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(a(((IContactSearchable)localObject).d(), ((IContactSearchable)localObject).b()));
      paramViewGroup.jdField_a_of_type_JavaLangString = ((IContactSearchable)localObject).d();
      paramViewGroup.jdField_a_of_type_Int = ((IContactSearchable)localObject).b();
      localObject = ((IContactSearchable)localObject).a();
      if (localObject != null) {
        break label358;
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
      label306:
      if (localSelectMemberActivity.a(str))
      {
        paramViewGroup.jdField_c_of_type_AndroidWidgetTextView.setText(2131363240);
        break label209;
      }
      paramViewGroup.jdField_c_of_type_AndroidWidgetTextView.setText(((IContactSearchable)localObject).b());
      break label209;
      label343:
      paramViewGroup.jdField_c_of_type_AndroidWidgetTextView.setText(((IContactSearchable)localObject).b());
      break label209;
      label358:
      paramViewGroup.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
      paramViewGroup.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.ContactsSearchResultAdapter
 * JD-Core Version:    0.7.0.1
 */