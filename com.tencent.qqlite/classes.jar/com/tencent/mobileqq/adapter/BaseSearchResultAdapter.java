package com.tencent.mobileqq.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.search.ConversationSearchAdapter.SearchResultCallBack;
import com.tencent.mobileqq.search.ISearchable;
import com.tencent.mobileqq.search.SearchTask;
import com.tencent.mobileqq.search.SearchTask.SearchTaskCallBack;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.mobileqq.util.FaceDecoder.DecodeTaskCompletionListener;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseSearchResultAdapter
  extends BaseAdapter
  implements SearchTask.SearchTaskCallBack, FaceDecoder.DecodeTaskCompletionListener, AbsListView.OnScrollListener
{
  private int jdField_a_of_type_Int = 0;
  protected ConversationSearchAdapter.SearchResultCallBack a;
  private SearchTask jdField_a_of_type_ComTencentMobileqqSearchSearchTask = null;
  private FaceDecoder jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder;
  private XListView jdField_a_of_type_ComTencentWidgetXListView;
  private String jdField_a_of_type_JavaLangString;
  private List jdField_a_of_type_JavaUtilList;
  boolean jdField_a_of_type_Boolean = false;
  private String jdField_b_of_type_JavaLangString;
  private List jdField_b_of_type_JavaUtilList;
  
  public BaseSearchResultAdapter(Context paramContext, QQAppInterface paramQQAppInterface, XListView paramXListView, List paramList)
  {
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
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqSearchSearchTask != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqSearchSearchTask.cancel(true);
      this.jdField_a_of_type_ComTencentMobileqqSearchSearchTask = null;
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
  
  public void a(int paramInt, List paramList)
  {
    this.jdField_b_of_type_JavaUtilList.clear();
    this.jdField_b_of_type_JavaUtilList.addAll(paramList);
    paramList.clear();
    if (this.jdField_a_of_type_ComTencentMobileqqSearchConversationSearchAdapter$SearchResultCallBack != null) {
      this.jdField_a_of_type_ComTencentMobileqqSearchConversationSearchAdapter$SearchResultCallBack.a(paramInt);
    }
    notifyDataSetChanged();
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
  
  public void a(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    if (this.jdField_a_of_type_ComTencentMobileqqSearchSearchTask != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqSearchSearchTask.cancel(true);
      this.jdField_a_of_type_ComTencentMobileqqSearchSearchTask = null;
    }
    this.jdField_a_of_type_ComTencentMobileqqSearchSearchTask = new SearchTask(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaUtilList, this);
    this.jdField_a_of_type_ComTencentMobileqqSearchSearchTask.a();
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
    if (this.jdField_b_of_type_JavaUtilList != null)
    {
      this.jdField_b_of_type_JavaUtilList.clear();
      notifyDataSetChanged();
    }
  }
  
  public void b(List paramList)
  {
    this.jdField_b_of_type_JavaUtilList.addAll(paramList);
    notifyDataSetChanged();
  }
  
  public void c()
  {
    this.jdField_a_of_type_JavaLangString = null;
    b();
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqSearchSearchTask != null) {
      this.jdField_a_of_type_ComTencentMobileqqSearchSearchTask.cancel(true);
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.BaseSearchResultAdapter
 * JD-Core Version:    0.7.0.1
 */