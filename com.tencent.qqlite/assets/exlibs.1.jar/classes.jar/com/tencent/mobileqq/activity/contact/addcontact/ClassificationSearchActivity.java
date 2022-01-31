package com.tencent.mobileqq.activity.contact.addcontact;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Looper;
import android.os.MessageQueue;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import cbw;
import cbx;
import cby;
import cbz;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.pb.addcontacts.AccountSearchPb.record;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ClassificationSearchActivity
  extends SearchBaseActivity
{
  private static SearchResult jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchResult;
  public static final String a = "key_has_more";
  private static final String e = "ClassificationSearchActivity";
  private static final int n = 0;
  private static final int o = 1;
  private static final int p = 2;
  private static final int q = 3;
  private static final int r = 4;
  private static final int t = 0;
  private static final int u = 1;
  private static final int v = 2;
  public int a;
  private View jdField_a_of_type_AndroidViewView;
  private cbz jdField_a_of_type_Cbz;
  private List jdField_a_of_type_JavaUtilList = new ArrayList(20);
  public boolean a;
  int b;
  private HashMap c;
  private boolean d;
  private int s;
  
  public ClassificationSearchActivity()
  {
    this.jdField_c_of_type_JavaUtilHashMap = new HashMap(15);
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
  }
  
  public static void a(Activity paramActivity, Intent paramIntent, SearchResult paramSearchResult)
  {
    jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchResult = paramSearchResult;
    paramActivity.startActivityForResult(paramIntent, 1);
  }
  
  private boolean b(ArrayList paramArrayList)
  {
    if ((paramArrayList != null) && (paramArrayList.size() == 1))
    {
      Object localObject = ((SearchResult)paramArrayList.get(0)).jdField_b_of_type_JavaUtilList;
      if ((localObject != null) && (((List)localObject).size() == 1))
      {
        localObject = (AccountSearchPb.record)((List)localObject).get(0);
        a(((SearchResult)paramArrayList.get(0)).jdField_a_of_type_Int, (AccountSearchPb.record)localObject);
        return true;
      }
    }
    return false;
  }
  
  private String c(SearchBaseActivity.ItemViewHolder paramItemViewHolder, AccountSearchPb.record paramrecord)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    paramItemViewHolder.jdField_a_of_type_JavaLangString = (paramrecord.uin.get() + "");
    paramItemViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(a(paramrecord.uin.get()));
    localStringBuilder.append(paramItemViewHolder.jdField_a_of_type_AndroidWidgetTextView.getText());
    switch (this.f)
    {
    }
    for (;;)
    {
      Bitmap localBitmap = this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(1, paramItemViewHolder.jdField_a_of_type_JavaLangString);
      paramrecord = localBitmap;
      if (localBitmap == null)
      {
        localBitmap = ImageUtil.a();
        paramrecord = localBitmap;
        if (!this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a())
        {
          this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(paramItemViewHolder.jdField_a_of_type_JavaLangString, 1, true, (byte)1);
          paramrecord = localBitmap;
        }
      }
      paramItemViewHolder.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramrecord);
      return localStringBuilder.toString() + "轻触两次进入资料卡";
      localStringBuilder.append(a(paramItemViewHolder, paramrecord));
    }
  }
  
  protected SpannableString a(long paramLong)
  {
    return (SpannableString)this.jdField_c_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong));
  }
  
  protected void a(String paramString)
  {
    super.a(paramString);
    this.jdField_a_of_type_Int = 3;
    this.jdField_a_of_type_Cbz.notifyDataSetChanged();
  }
  
  protected boolean a(ArrayList paramArrayList)
  {
    int i = 0;
    SearchResult localSearchResult = (SearchResult)paramArrayList.get(0);
    if (b(paramArrayList))
    {
      this.jdField_d_of_type_Boolean = true;
      return false;
    }
    if (!localSearchResult.jdField_a_of_type_Boolean) {
      i = 1;
    }
    this.jdField_a_of_type_Int = i;
    if (QLog.isColorLevel()) {
      QLog.d("ClassificationSearchActivity", 2, "is no more page  = " + localSearchResult.jdField_a_of_type_Boolean);
    }
    this.jdField_a_of_type_JavaUtilList = localSearchResult.jdField_b_of_type_JavaUtilList;
    if (!this.jdField_b_of_type_Boolean) {
      this.jdField_c_of_type_JavaUtilHashMap.clear();
    }
    a(this.jdField_c_of_type_JavaUtilHashMap, paramArrayList);
    return true;
  }
  
  protected void c()
  {
    super.c();
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(new cbx(this));
    this.jdField_a_of_type_AndroidWidgetEditText.setContentDescription("搜索栏" + this.jdField_d_of_type_JavaLangString);
    if (this.jdField_a_of_type_AndroidViewView == null)
    {
      this.jdField_a_of_type_AndroidViewView = getLayoutInflater().inflate(2130903456, this.jdField_a_of_type_ComTencentWidgetXListView, false);
      this.jdField_a_of_type_AndroidViewView.setClickable(false);
      this.jdField_a_of_type_AndroidViewView.setFocusable(true);
    }
  }
  
  protected void d()
  {
    super.d();
    int i;
    if (jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchResult != null) {
      if (!jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchResult.jdField_a_of_type_Boolean)
      {
        i = 1;
        this.jdField_a_of_type_Int = i;
        this.jdField_a_of_type_JavaUtilList.addAll(jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchResult.jdField_b_of_type_JavaUtilList);
        this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactSearchFacade.a(jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchResult.jdField_b_of_type_Int);
        ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131298097)).setText(ViewFactory.a(jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchResult.jdField_a_of_type_Int));
        jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchResult = null;
        this.jdField_c_of_type_JavaUtilHashMap.putAll(jdField_a_of_type_JavaUtilHashMap);
        e();
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetEditText.setText(this.jdField_d_of_type_JavaLangString);
      if (!TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)) {
        this.jdField_a_of_type_AndroidWidgetEditText.setSelection(this.jdField_d_of_type_JavaLangString.length() - 1);
      }
      this.s = a();
      return;
      i = 0;
      break;
      if (QLog.isColorLevel()) {
        QLog.d("ClassificationSearchActivity", 2, "searchResult is null");
      }
      k();
    }
  }
  
  public void doOnBackPressed()
  {
    finish();
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    this.jdField_c_of_type_JavaUtilHashMap.clear();
    this.jdField_c_of_type_JavaUtilHashMap = null;
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    if (this.jdField_d_of_type_Boolean)
    {
      Looper.myQueue().addIdleHandler(new cbw(this));
      this.jdField_d_of_type_Boolean = false;
    }
  }
  
  protected void doOnStop()
  {
    super.doOnStop();
    if (this.jdField_d_of_type_Boolean) {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
    }
  }
  
  protected void e()
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder().append("isGetMore = ").append(this.jdField_b_of_type_Boolean).append(" mListData is null = ");
      if (this.jdField_a_of_type_JavaUtilList != null) {
        break label75;
      }
    }
    label75:
    for (boolean bool = true;; bool = false)
    {
      QLog.d("ClassificationSearchActivity", 2, bool);
      if ((this.jdField_b_of_type_Boolean) || (this.jdField_a_of_type_JavaUtilList != null)) {
        break;
      }
      k();
      return;
    }
    if (this.jdField_a_of_type_Cbz == null)
    {
      this.jdField_a_of_type_Cbz = new cbz(this, null);
      this.jdField_a_of_type_Cbz.a(this.jdField_a_of_type_JavaUtilList);
      View localView = this.jdField_a_of_type_AndroidViewView;
      StringBuilder localStringBuilder = new StringBuilder();
      if (this.f == 0)
      {
        localObject = "好友";
        label136:
        localView.setContentDescription((String)localObject + "搜索结果");
        this.jdField_a_of_type_ComTencentWidgetXListView.a(this.jdField_a_of_type_AndroidViewView);
        this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Cbz);
        this.a = this.jdField_a_of_type_Cbz;
      }
    }
    else
    {
      if (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(0) != this.jdField_a_of_type_ComTencentWidgetXListView)
      {
        this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_a_of_type_ComTencentWidgetXListView);
      }
      if (!this.jdField_b_of_type_Boolean) {
        break label277;
      }
      this.jdField_a_of_type_Cbz.a().addAll(this.jdField_a_of_type_JavaUtilList);
    }
    for (;;)
    {
      this.jdField_a_of_type_Cbz.notifyDataSetChanged();
      if (!this.jdField_c_of_type_Boolean) {
        break;
      }
      this.jdField_c_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentWidgetXListView.setSelection(0);
      return;
      localObject = "生活服务";
      break label136;
      label277:
      this.jdField_a_of_type_Cbz.a(this.jdField_a_of_type_JavaUtilList);
    }
  }
  
  public void f()
  {
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactSearchFacade.a(this.jdField_d_of_type_JavaLangString, this.s);
      return;
    }
    String str = this.jdField_a_of_type_AndroidWidgetEditText.getEditableText().toString().trim();
    if (NetworkUtil.e(this))
    {
      m();
      this.jdField_d_of_type_JavaLangString = str;
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactSearchFacade.c();
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactSearchFacade.a(str, this.s);
      this.jdField_c_of_type_Boolean = true;
      return;
    }
    QQToast.a(this, 2131363516, 0).b(getTitleBarHeight());
    this.jdField_a_of_type_Int = 4;
    this.jdField_a_of_type_Cbz.notifyDataSetChanged();
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_Int == 1)
    {
      this.jdField_a_of_type_Int = 2;
      this.jdField_b_of_type_Boolean = true;
      f();
    }
  }
  
  protected void h()
  {
    if (this.jdField_a_of_type_Int == 2)
    {
      this.jdField_a_of_type_Int = 0;
      this.jdField_a_of_type_Cbz.notifyDataSetChanged();
    }
  }
  
  public void onClick(View paramView)
  {
    paramView = paramView.getTag();
    if (paramView != null)
    {
      if (!(paramView instanceof SearchBaseActivity.ItemViewHolder)) {
        break label34;
      }
      paramView = (SearchBaseActivity.ItemViewHolder)paramView;
      a(paramView.jdField_b_of_type_Int, paramView.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record);
    }
    label34:
    while ((!(paramView instanceof cby)) || ((this.jdField_a_of_type_Int != 3) && (this.jdField_a_of_type_Int != 4))) {
      return;
    }
    if (NetworkUtil.e(this)) {}
    for (this.jdField_a_of_type_Int = 1;; this.jdField_a_of_type_Int = 4)
    {
      this.jdField_a_of_type_Cbz.notifyDataSetChanged();
      return;
      QQToast.a(this, 2131363516, 0).b(getTitleBarHeight());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.ClassificationSearchActivity
 * JD-Core Version:    0.7.0.1
 */