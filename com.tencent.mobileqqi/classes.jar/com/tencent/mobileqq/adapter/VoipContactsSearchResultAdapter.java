package com.tencent.mobileqq.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.provider.MediaStore.Images.Media;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.international.LocaleString;
import com.tencent.mobileqq.search.ContactsSearchablePhoneContact;
import com.tencent.mobileqq.search.ConversationSearchAdapter.SearchResultCallBack;
import com.tencent.mobileqq.search.IContactSearchable;
import com.tencent.mobileqq.search.SearchAdapterInterface;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.XListView;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class VoipContactsSearchResultAdapter
  extends BaseSearchResultAdapter
  implements SearchAdapterInterface, AbsListView.OnScrollListener
{
  private Context jdField_a_of_type_AndroidContentContext;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  public PhoneContact a;
  private boolean b;
  
  public VoipContactsSearchResultAdapter(QQAppInterface paramQQAppInterface, Context paramContext, XListView paramXListView, List paramList, View.OnClickListener paramOnClickListener, boolean paramBoolean)
  {
    super(paramContext, paramQQAppInterface, paramXListView, paramList);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
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
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    super.a(paramAbsListView, paramInt, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
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
    Object localObject2;
    String str;
    if (paramView == null)
    {
      paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903149, paramViewGroup, false);
      paramViewGroup = new VoipContactsSearchResultAdapter.ViewTag();
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131231407));
      paramViewGroup.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131231408));
      paramViewGroup.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131231411));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131231410));
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131231412));
      paramViewGroup.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131231413));
      paramView.setTag(paramViewGroup);
      localObject1 = (IContactSearchable)getItem(paramInt);
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(((IContactSearchable)localObject1).c());
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setText(((IContactSearchable)localObject1).b());
      paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setImageResource(((IContactSearchable)localObject1).a());
      if (!(this.jdField_a_of_type_AndroidContentContext instanceof SelectMemberActivity)) {
        break label415;
      }
      localObject2 = (SelectMemberActivity)this.jdField_a_of_type_AndroidContentContext;
      str = ((IContactSearchable)localObject1).d();
      if ((((SelectMemberActivity)localObject2).a == null) || (!((SelectMemberActivity)localObject2).a.contains(str))) {
        break label378;
      }
      paramViewGroup.jdField_c_of_type_AndroidWidgetTextView.setText(2131561612);
      label209:
      this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact = null;
      this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact = ((ContactsSearchablePhoneContact)localObject1).jdField_a_of_type_ComTencentMobileqqDataPhoneContact;
      paramViewGroup.jdField_b_of_type_ComTencentMobileqqDataPhoneContact = this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact;
      if (this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact == null) {
        break label502;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.photoUri == null) {
        break label451;
      }
    }
    label526:
    for (;;)
    {
      try
      {
        localObject2 = MediaStore.Images.Media.getBitmap(this.jdField_a_of_type_AndroidContentContext.getContentResolver(), this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.photoUri);
        localObject2 = ImageUtil.a((Bitmap)localObject2, ((Bitmap)localObject2).getWidth(), ((Bitmap)localObject2).getWidth(), ((Bitmap)localObject2).getHeight());
        paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap((Bitmap)localObject2);
        paramViewGroup.jdField_a_of_type_JavaLangString = ((IContactSearchable)localObject1).d();
        paramViewGroup.jdField_a_of_type_Int = ((IContactSearchable)localObject1).b();
        localObject1 = ((IContactSearchable)localObject1).a();
        if (localObject1 != null) {
          break label526;
        }
        paramViewGroup.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
        if (this.jdField_a_of_type_AndroidViewView$OnClickListener != null)
        {
          paramView.setTag(-1, Integer.valueOf(paramInt));
          paramView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        }
        return paramView;
        paramViewGroup = (VoipContactsSearchResultAdapter.ViewTag)paramView.getTag();
        break;
        label378:
        if (((SelectMemberActivity)localObject2).a(str))
        {
          paramViewGroup.jdField_c_of_type_AndroidWidgetTextView.setText(2131562853);
          break label209;
        }
        paramViewGroup.jdField_c_of_type_AndroidWidgetTextView.setText(((IContactSearchable)localObject1).a());
        break label209;
        label415:
        paramViewGroup.jdField_c_of_type_AndroidWidgetTextView.setText(LocaleString.b(BaseApplicationImpl.getContext(), ((IContactSearchable)localObject1).a()));
      }
      catch (IOException localIOException)
      {
        paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(ImageUtil.b());
        continue;
      }
      label451:
      if (this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.uin != null)
      {
        Drawable localDrawable = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.uin);
        paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(localDrawable);
      }
      else
      {
        paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(ImageUtil.b());
        continue;
        label502:
        paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(a(((IContactSearchable)localObject1).d(), ((IContactSearchable)localObject1).b()));
        continue;
        paramViewGroup.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
        paramViewGroup.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.VoipContactsSearchResultAdapter
 * JD-Core Version:    0.7.0.1
 */