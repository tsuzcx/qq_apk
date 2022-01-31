package com.tencent.mobileqq.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.recent.cur.DragRelativeLayout;
import com.tencent.mobileqq.activity.recent.cur.DragRelativeLayout.OnDragModeChangedListener;
import com.tencent.mobileqq.activity.recent.cur.DragTextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.SubAccountMessage;
import com.tencent.mobileqq.subaccount.datamanager.SubAccountMessageData;
import com.tencent.widget.AbsListView.LayoutParams;
import fda;
import java.util.List;

public class SubAccountMessageAdapter
  extends BaseAdapter
  implements DragRelativeLayout.OnDragModeChangedListener
{
  private static final int b = 0;
  private static final int c = 1;
  private static final int d = 2;
  private int jdField_a_of_type_Int = 0;
  private Context jdField_a_of_type_AndroidContentContext;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private DragRelativeLayout jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragRelativeLayout;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private List jdField_a_of_type_JavaUtilList;
  private int e = 0;
  private int f = 0;
  private int g = 200;
  
  public SubAccountMessageAdapter(QQAppInterface paramQQAppInterface, List paramList, View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication();
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext);
    this.e = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131427489);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
  }
  
  private View a(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i;
    if (paramView == null)
    {
      paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130904004, null);
      paramViewGroup = new fda(this);
      paramViewGroup.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131234558);
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131234563));
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView = ((DragTextView)paramView.findViewById(2131234566));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131234565));
      paramViewGroup.b = ((TextView)paramView.findViewById(2131234567));
      paramViewGroup.c = ((TextView)paramView.findViewById(2131234564));
      paramView.setTag(paramViewGroup);
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setOnModeChangeListener(this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragRelativeLayout);
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(0);
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setTag(Integer.valueOf(paramInt));
      SubAccountMessageData localSubAccountMessageData = (SubAccountMessageData)getItem(paramInt);
      if ((localSubAccountMessageData != null) && (localSubAccountMessageData.a() != null))
      {
        String str = localSubAccountMessageData.a().sendername;
        Object localObject = str;
        if (TextUtils.isEmpty(str)) {
          localObject = localSubAccountMessageData.a().senderuin;
        }
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
        paramViewGroup.b.setText(localSubAccountMessageData.jdField_a_of_type_JavaLangCharSequence);
        paramViewGroup.c.setText(localSubAccountMessageData.jdField_a_of_type_JavaLangString);
        paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setTag(localSubAccountMessageData.a().senderuin);
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(localSubAccountMessageData.a().senderuin);
        paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
        paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        i = localSubAccountMessageData.a().unreadNum;
        if (i <= 0) {
          break label366;
        }
        paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setVisibility(0);
        if (i <= 99) {
          break label351;
        }
        paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setText("99+");
      }
    }
    for (;;)
    {
      paramViewGroup.jdField_a_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      if (this.jdField_a_of_type_Int != 1) {
        break label377;
      }
      paramViewGroup.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130837875);
      return paramView;
      paramViewGroup = (fda)paramView.getTag();
      break;
      label351:
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setText(String.valueOf(i));
      continue;
      label366:
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setVisibility(4);
    }
    label377:
    if (paramInt == 0)
    {
      paramViewGroup.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130837880);
      return paramView;
    }
    if (paramInt == this.jdField_a_of_type_Int - 1)
    {
      paramViewGroup.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130837877);
      return paramView;
    }
    paramViewGroup.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130837879);
    return paramView;
  }
  
  private View a(View paramView, ViewGroup paramViewGroup)
  {
    View localView = paramView;
    if (paramView == null) {
      localView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130904002, null);
    }
    int i = paramViewGroup.getHeight() - this.e;
    if (i > this.g) {}
    for (;;)
    {
      paramView = new AbsListView.LayoutParams(-1, -1);
      paramView.width = -1;
      paramView.height = i;
      localView.setLayoutParams(paramView);
      localView.setTag(Boolean.valueOf(true));
      return localView;
      i = this.g;
    }
  }
  
  public DragRelativeLayout a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragRelativeLayout;
  }
  
  public void a(DragRelativeLayout paramDragRelativeLayout)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragRelativeLayout = paramDragRelativeLayout;
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragRelativeLayout.a(this, true);
  }
  
  public void a(String paramString, View paramView)
  {
    if ((paramView != null) && (!TextUtils.isEmpty(paramString)))
    {
      paramView = (ImageView)paramView.findViewById(2131234563);
      if (paramView != null)
      {
        Object localObject = paramView.getTag();
        if ((localObject != null) && ((localObject instanceof String)) && (paramString.equals(localObject))) {
          paramView.setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(paramString));
        }
      }
    }
  }
  
  public void a(List paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public void a(boolean paramBoolean, int paramInt, DragRelativeLayout paramDragRelativeLayout)
  {
    if (paramBoolean)
    {
      paramDragRelativeLayout = paramDragRelativeLayout.a();
      if ((paramDragRelativeLayout != null) && (paramDragRelativeLayout.getTag() != null)) {
        ((Integer)paramDragRelativeLayout.getTag()).intValue();
      }
    }
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilList != null) {}
    for (this.jdField_a_of_type_Int = this.jdField_a_of_type_JavaUtilList.size();; this.jdField_a_of_type_Int = 0) {
      return this.jdField_a_of_type_Int;
    }
  }
  
  public Object getItem(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {
      return this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilList != null) {
      return paramInt;
    }
    return 0L;
  }
  
  public int getItemViewType(int paramInt)
  {
    SubAccountMessageData localSubAccountMessageData = (SubAccountMessageData)getItem(paramInt);
    if ((localSubAccountMessageData != null) && (localSubAccountMessageData.a() != null)) {
      return 0;
    }
    return 1;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (getItemViewType(paramInt) == 0) {
      return a(paramInt, paramView, paramViewGroup);
    }
    return a(paramView, paramViewGroup);
  }
  
  public int getViewTypeCount()
  {
    return 2;
  }
  
  public boolean isEnabled(int paramInt)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.SubAccountMessageAdapter
 * JD-Core Version:    0.7.0.1
 */