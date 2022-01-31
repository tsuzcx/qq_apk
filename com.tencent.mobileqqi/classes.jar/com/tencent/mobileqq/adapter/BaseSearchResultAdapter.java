package com.tencent.mobileqq.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.provider.MediaStore.Images.Media;
import android.text.TextUtils;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.search.ConversationSearchAdapter.SearchResultCallBack;
import com.tencent.mobileqq.search.ISearchable;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.mobileqq.util.FaceDecoder.DecodeTaskCompletionListener;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.XListView;
import exk;
import exl;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public abstract class BaseSearchResultAdapter
  extends BaseAdapter
  implements FaceDecoder.DecodeTaskCompletionListener, AbsListView.OnScrollListener
{
  private static Comparator jdField_a_of_type_JavaUtilComparator = new exk();
  private int jdField_a_of_type_Int = 0;
  public ConversationSearchAdapter.SearchResultCallBack a;
  private FaceDecoder jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder;
  private XListView jdField_a_of_type_ComTencentWidgetXListView;
  private exl jdField_a_of_type_Exl = null;
  private String jdField_a_of_type_JavaLangString;
  private List jdField_a_of_type_JavaUtilList;
  public boolean a;
  private String jdField_b_of_type_JavaLangString;
  private List jdField_b_of_type_JavaUtilList;
  
  public BaseSearchResultAdapter(Context paramContext, QQAppInterface paramQQAppInterface, XListView paramXListView, List paramList)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqSearchConversationSearchAdapter$SearchResultCallBack = null;
    this.jdField_a_of_type_ComTencentWidgetXListView = paramXListView;
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnScrollListener(this);
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder = new FaceDecoder(paramContext, paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(this);
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
  }
  
  protected Bitmap a(String paramString, int paramInt)
  {
    Bitmap localBitmap = this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(paramInt, paramString);
    if (localBitmap != null) {
      return localBitmap;
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a()) {
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(paramString, paramInt, true);
    }
    if (paramInt == 1) {
      return ImageUtil.a();
    }
    if (paramInt == 101) {
      return ImageUtil.d();
    }
    if (paramInt == 4) {
      return ImageUtil.c();
    }
    return ImageUtil.a();
  }
  
  protected Bitmap a(String paramString, int paramInt, Context paramContext, QQAppInterface paramQQAppInterface, PhoneContact paramPhoneContact)
  {
    if (paramPhoneContact != null) {
      if (paramPhoneContact.photoUri == null) {}
    }
    do
    {
      try
      {
        paramString = MediaStore.Images.Media.getBitmap(paramContext.getContentResolver(), paramPhoneContact.photoUri);
        paramContext = ImageUtil.a(paramString, paramString.getWidth(), paramString.getWidth(), paramString.getHeight());
        return paramContext;
      }
      catch (IOException paramString)
      {
        return ImageUtil.b();
      }
      if (paramPhoneContact.uin != null) {
        return ((BitmapDrawable)paramQQAppInterface.c(paramPhoneContact.uin)).getBitmap();
      }
      return ImageUtil.b();
      paramQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(paramInt, paramString);
      paramContext = paramQQAppInterface;
    } while (paramQQAppInterface != null);
    if (!this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a()) {
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(paramString, paramInt, true);
    }
    if (paramInt == 1) {
      return ImageUtil.b();
    }
    if (paramInt == 101) {
      return ImageUtil.d();
    }
    if (paramInt == 4) {
      return ImageUtil.c();
    }
    return ImageUtil.b();
  }
  
  public void a()
  {
    if (this.jdField_b_of_type_JavaUtilList != null)
    {
      this.jdField_b_of_type_JavaUtilList.clear();
      notifyDataSetChanged();
    }
  }
  
  public void a(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    int i;
    if ((!this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a()) && ((this.jdField_a_of_type_Int == 0) || (this.jdField_a_of_type_Int == 1)))
    {
      i = this.jdField_a_of_type_ComTencentWidgetXListView.getChildCount();
      paramInt1 = 0;
    }
    for (;;)
    {
      if (paramInt1 < i)
      {
        Object localObject = this.jdField_a_of_type_ComTencentWidgetXListView.getChildAt(paramInt1).getTag();
        if ((localObject != null) && ((localObject instanceof BaseSearchResultAdapter.ViewHolder)))
        {
          localObject = (BaseSearchResultAdapter.ViewHolder)localObject;
          if ((localObject != null) && (!TextUtils.isEmpty(((BaseSearchResultAdapter.ViewHolder)localObject).jdField_a_of_type_JavaLangString)) && (((BaseSearchResultAdapter.ViewHolder)localObject).jdField_a_of_type_JavaLangString.equals(paramString)) && (paramInt2 == ((BaseSearchResultAdapter.ViewHolder)localObject).jdField_a_of_type_Int)) {
            ((BaseSearchResultAdapter.ViewHolder)localObject).jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
          }
        }
      }
      else
      {
        return;
      }
      paramInt1 += 1;
    }
  }
  
  public void a(ISearchable paramISearchable)
  {
    this.jdField_b_of_type_JavaUtilList.remove(paramISearchable);
  }
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentWidgetXListView == null) {}
    for (;;)
    {
      return;
      this.jdField_a_of_type_Int = paramInt;
      if ((paramInt != 0) && (paramInt != 1)) {
        break;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a()) {
        this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.b();
      }
      int i = this.jdField_a_of_type_ComTencentWidgetXListView.getChildCount();
      paramInt = 0;
      while (paramInt < i)
      {
        paramAbsListView = this.jdField_a_of_type_ComTencentWidgetXListView.getChildAt(paramInt).getTag();
        if ((paramAbsListView != null) && ((paramAbsListView instanceof BaseSearchResultAdapter.ViewHolder)))
        {
          paramAbsListView = (BaseSearchResultAdapter.ViewHolder)paramAbsListView;
          if ((paramAbsListView != null) && (!TextUtils.isEmpty(paramAbsListView.jdField_a_of_type_JavaLangString))) {
            paramAbsListView.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(a(paramAbsListView.jdField_a_of_type_JavaLangString, paramAbsListView.jdField_a_of_type_Int));
          }
        }
        paramInt += 1;
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.c();
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a();
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void a(AbsListView paramAbsListView, int paramInt, Context paramContext, QQAppInterface paramQQAppInterface)
  {
    if (this.jdField_a_of_type_ComTencentWidgetXListView == null) {}
    for (;;)
    {
      return;
      this.jdField_a_of_type_Int = paramInt;
      if ((paramInt != 0) && (paramInt != 1)) {
        break;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a()) {
        this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.b();
      }
      int i = this.jdField_a_of_type_ComTencentWidgetXListView.getChildCount();
      paramInt = 0;
      while (paramInt < i)
      {
        paramAbsListView = this.jdField_a_of_type_ComTencentWidgetXListView.getChildAt(paramInt).getTag();
        if ((paramAbsListView != null) && ((paramAbsListView instanceof BaseSearchResultAdapter.ViewHolder)))
        {
          paramAbsListView = (BaseSearchResultAdapter.ViewHolderVoip)paramAbsListView;
          if ((paramAbsListView != null) && (!TextUtils.isEmpty(paramAbsListView.jdField_a_of_type_JavaLangString))) {
            paramAbsListView.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(a(paramAbsListView.jdField_a_of_type_JavaLangString, paramAbsListView.jdField_a_of_type_Int, paramContext, paramQQAppInterface, paramAbsListView.jdField_a_of_type_ComTencentMobileqqDataPhoneContact));
          }
        }
        paramInt += 1;
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.c();
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a();
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    if (this.jdField_a_of_type_Exl != null)
    {
      this.jdField_a_of_type_Exl.cancel(true);
      this.jdField_a_of_type_Exl = null;
    }
    this.jdField_a_of_type_Exl = new exl(this, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaUtilList);
    this.jdField_a_of_type_Exl.execute(new Void[0]);
  }
  
  public void a(List paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    if (this.jdField_a_of_type_JavaLangString != null) {
      a(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString);
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void b()
  {
    this.jdField_a_of_type_JavaLangString = null;
    a();
  }
  
  public void b(List paramList)
  {
    this.jdField_b_of_type_JavaUtilList.addAll(paramList);
    notifyDataSetChanged();
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder != null) {
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.d();
    }
    this.jdField_a_of_type_ComTencentWidgetXListView = null;
  }
  
  public int getCount()
  {
    if (this.jdField_b_of_type_JavaUtilList != null) {
      return this.jdField_b_of_type_JavaUtilList.size();
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    if (this.jdField_b_of_type_JavaUtilList == null) {
      return null;
    }
    return (ISearchable)this.jdField_b_of_type_JavaUtilList.get(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.BaseSearchResultAdapter
 * JD-Core Version:    0.7.0.1
 */