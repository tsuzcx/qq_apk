package com.tencent.mobileqq.activity.contact.addcontact;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Looper;
import android.os.MessageQueue;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import ccb;
import ccc;
import ccd;
import cce;
import ccf;
import ccg;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.mobileqq.util.FaceDecoder.DecodeTaskCompletionListener;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.pb.addcontacts.AccountSearchPb.record;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.XListView;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SearchContactsActivity
  extends SearchBaseActivity
  implements View.OnClickListener, FaceDecoder.DecodeTaskCompletionListener, AbsListView.OnScrollListener
{
  private static final String jdField_a_of_type_JavaLangString = "SearchContactsActivity";
  public static final int b = 0;
  public static final int n = 1;
  public static final int o = 2;
  public static final int p = 3;
  public int a;
  public cce a;
  private ccg jdField_a_of_type_Ccg;
  private ViewFactory.GuideView jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactViewFactory$GuideView;
  ArrayList jdField_a_of_type_JavaUtilArrayList;
  public boolean a;
  private ArrayList b;
  
  private int a(int paramInt)
  {
    switch (paramInt)
    {
    case 80000000: 
    default: 
      return 1;
    }
    return 2;
  }
  
  private SearchResult a(int paramInt)
  {
    if (this.b == null) {
      return null;
    }
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
    {
      SearchResult localSearchResult = (SearchResult)localIterator.next();
      if (localSearchResult.jdField_a_of_type_Int == paramInt) {
        return localSearchResult;
      }
    }
    return null;
  }
  
  private String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "";
    case 80000000: 
      return "0X8004BEE";
    }
    return "0X8004BEF";
  }
  
  private boolean b(ArrayList paramArrayList)
  {
    if ((paramArrayList != null) && (paramArrayList.size() == 1))
    {
      Object localObject = ((SearchResult)paramArrayList.get(0)).b;
      if ((localObject != null) && (((List)localObject).size() == 1))
      {
        localObject = (AccountSearchPb.record)((List)localObject).get(0);
        a(((SearchResult)paramArrayList.get(0)).jdField_a_of_type_Int, (AccountSearchPb.record)localObject);
        return true;
      }
      if ((localObject != null) && (((List)localObject).size() == 2))
      {
        localObject = this.jdField_c_of_type_JavaUtilRegexPattern.matcher(this.d);
        if (QLog.isColorLevel()) {
          QLog.d("SearchContactsActivity", 2, "needJump lastKeywords = " + this.d);
        }
        if (((Matcher)localObject).matches())
        {
          i();
          a(jdField_a_of_type_JavaUtilHashMap, this.b);
          a(((SearchResult)paramArrayList.get(0)).jdField_a_of_type_Int);
          return true;
        }
      }
    }
    return false;
  }
  
  public String a(SearchBaseActivity.ItemViewHolder paramItemViewHolder, ccf paramccf)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = paramccf.jdField_b_of_type_Int;
    paramItemViewHolder.jdField_a_of_type_JavaLangString = (paramccf.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.uin.get() + "");
    if (paramccf.jdField_b_of_type_Int != 80000001)
    {
      paramItemViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(a(paramccf.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.uin.get()));
      localStringBuilder.append(paramItemViewHolder.jdField_a_of_type_AndroidWidgetTextView.getText().toString());
      switch (i)
      {
      default: 
        i = 1;
      }
    }
    for (;;)
    {
      Bitmap localBitmap = this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(i, paramItemViewHolder.jdField_a_of_type_JavaLangString);
      paramccf = localBitmap;
      if (localBitmap == null)
      {
        localBitmap = ImageUtil.a();
        paramccf = localBitmap;
        if (!this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a())
        {
          this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(paramItemViewHolder.jdField_a_of_type_JavaLangString, i, true, (byte)1);
          paramccf = localBitmap;
        }
      }
      paramItemViewHolder.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramccf);
      return localStringBuilder.toString() + "轻触两次进入资料卡";
      paramItemViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(b(paramccf.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.code.get()));
      break;
      localStringBuilder.append(a(paramItemViewHolder, paramccf.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record));
      i = 1;
      continue;
      i = 4;
      paramItemViewHolder.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      paramItemViewHolder.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
      paramItemViewHolder.jdField_b_of_type_AndroidWidgetTextView.setText(paramccf.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.number.get() + "人");
      paramItemViewHolder.c.setText("");
      paramItemViewHolder.d.setText(paramccf.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.brief.get());
      paramItemViewHolder.jdField_b_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131427498));
      paramItemViewHolder.jdField_a_of_type_JavaLangString = String.valueOf(paramccf.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.code.get());
      localStringBuilder.append(paramItemViewHolder.jdField_b_of_type_AndroidWidgetTextView.getText()).append(paramItemViewHolder.d.getText());
    }
  }
  
  ArrayList a(ArrayList paramArrayList)
  {
    int[] arrayOfInt = ViewFactory.a(this.f);
    ArrayList localArrayList = new ArrayList(paramArrayList.size());
    int j = arrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      int k = arrayOfInt[i];
      Iterator localIterator = paramArrayList.iterator();
      while (localIterator.hasNext())
      {
        SearchResult localSearchResult = (SearchResult)localIterator.next();
        if (localSearchResult.jdField_a_of_type_Int == k) {
          localArrayList.add(localSearchResult);
        }
      }
      i += 1;
    }
    return localArrayList;
  }
  
  public void a(int paramInt)
  {
    int i = 1;
    Object localObject = new Intent();
    ((Intent)localObject).putExtra("last_key_words", this.d);
    switch (paramInt)
    {
    default: 
      paramInt = i;
    }
    for (;;)
    {
      ReportController.b(this.app, "CliOper", "", "", "0X8004BF1", "0X8004BF1", paramInt, 0, "", "", "", "");
      return;
      ((Intent)localObject).putExtra("from_key", 0);
      ((Intent)localObject).setClass(this, ClassificationSearchActivity.class);
      ClassificationSearchActivity.a(this, (Intent)localObject, a(paramInt));
      paramInt = i;
      continue;
      localObject = "http://qqweb.qq.com/m/relativegroup/index.html?source=qun_rec&keyword=" + URLEncoder.encode(this.d) + "&sid=AWSAPtjyiVRg92WelXNMAqd0&_bid=165";
      if (QLog.isColorLevel()) {
        QLog.d("SearchContactsActivity", 2, "lastKeywords = " + this.d + " jump url is : " + (String)localObject);
      }
      Intent localIntent = new Intent(this, QQBrowserActivity.class);
      localIntent.putExtra("url", (String)localObject);
      localIntent.putExtra("uin", this.app.a());
      localIntent.putExtra("portraitOnly", true);
      localIntent.putExtra("hide_more_button", true);
      localIntent.putExtra("hide_operation_bar", true);
      localIntent.putExtra("isShowAd", false);
      startActivity(localIntent);
      paramInt = 2;
    }
  }
  
  protected boolean a(ArrayList paramArrayList)
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      this.b = paramArrayList;
      if (!b(this.b))
      {
        this.jdField_a_of_type_JavaUtilArrayList = b(a(paramArrayList));
        i();
        a(jdField_a_of_type_JavaUtilHashMap, this.b);
        return true;
      }
      return false;
    }
    this.jdField_a_of_type_Boolean = false;
    this.b = paramArrayList;
    i();
    a(jdField_a_of_type_JavaUtilHashMap, this.b);
    if (!b(this.b)) {
      a(((SearchResult)paramArrayList.get(0)).jdField_a_of_type_Int);
    }
    return false;
  }
  
  ArrayList b(ArrayList paramArrayList)
  {
    ArrayList localArrayList = new ArrayList(12);
    int k = paramArrayList.size();
    int i = 0;
    while (i < k)
    {
      SearchResult localSearchResult = (SearchResult)paramArrayList.get(i);
      if ((localSearchResult == null) || (localSearchResult.b.size() <= 0))
      {
        i += 1;
      }
      else
      {
        ccf localccf = new ccf();
        localccf.jdField_a_of_type_Int = 0;
        localccf.jdField_a_of_type_JavaLangString = getString(ViewFactory.a(localSearchResult.jdField_a_of_type_Int));
        localArrayList.add(localccf);
        int m = localSearchResult.b.size();
        int j = 0;
        for (;;)
        {
          if (j < 2)
          {
            localccf = new ccf();
            localccf.jdField_a_of_type_Int = 2;
            localccf.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record = ((AccountSearchPb.record)localSearchResult.b.get(j));
            localccf.jdField_b_of_type_Int = localSearchResult.jdField_a_of_type_Int;
            localArrayList.add(localccf);
            if (j < m - 1) {}
          }
          else
          {
            if (m > 2)
            {
              localccf = new ccf();
              localccf.jdField_a_of_type_Int = 1;
              localccf.jdField_b_of_type_Int = localSearchResult.jdField_a_of_type_Int;
              localArrayList.add(localccf);
            }
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d("SearchContactsActivity", 2, "search reuslt : type = " + localSearchResult.jdField_a_of_type_Int + "count = " + localSearchResult.b.size());
            break;
          }
          j += 1;
        }
      }
    }
    return localArrayList;
  }
  
  public void b(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactViewFactory$GuideView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactViewFactory$GuideView.a(a(), paramString);
    }
  }
  
  protected void c()
  {
    super.c();
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(new ccb(this));
    this.jdField_a_of_type_AndroidWidgetEditText.setContentDescription("搜索栏、QQ号、手机号、邮箱、群、生活服务、正在编辑");
    Looper.myQueue().addIdleHandler(new ccc(this));
  }
  
  public void doOnBackPressed()
  {
    l();
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    i();
  }
  
  protected void e()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      k();
    }
    do
    {
      return;
      if (this.jdField_a_of_type_Ccg == null)
      {
        this.jdField_a_of_type_Ccg = new ccg(this, null);
        this.jdField_a_of_type_Ccg.a(this.jdField_a_of_type_JavaUtilArrayList);
        this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Ccg);
        this.a = this.jdField_a_of_type_Ccg;
      }
      if (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(0) != this.jdField_a_of_type_ComTencentWidgetXListView)
      {
        this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_a_of_type_ComTencentWidgetXListView);
      }
      this.jdField_a_of_type_Ccg.a(this.jdField_a_of_type_JavaUtilArrayList);
      this.jdField_a_of_type_Ccg.notifyDataSetChanged();
    } while (!this.jdField_c_of_type_Boolean);
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentWidgetXListView.setSelection(0);
  }
  
  public void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SearchContactsActivity", 2, "doSearch");
    }
    String str = this.jdField_a_of_type_AndroidWidgetEditText.getEditableText().toString().trim();
    if (NetworkUtil.e(this))
    {
      m();
      this.d = str;
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactSearchFacade.c();
      ContactSearchFacade localContactSearchFacade = this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactSearchFacade;
      if (this.jdField_a_of_type_Boolean) {}
      for (int i = this.jdField_a_of_type_Int;; i = 80000002)
      {
        localContactSearchFacade.a(str, i);
        this.jdField_c_of_type_Boolean = true;
        if (!this.jdField_a_of_type_Boolean) {
          break;
        }
        str = a(this.jdField_a_of_type_Int);
        ReportController.b(this.app, "CliOper", "", "", str, str, this.f + 1, 0, "", "", "", "");
        return;
      }
      ReportController.b(this.app, "CliOper", "", "", "0X8004BED", "0X8004BED", this.f + 1, 0, "", "", "", "");
      return;
    }
    QQToast.a(this, 2131363515, 0).b(getTitleBarHeight());
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactViewFactory$GuideView == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactViewFactory$GuideView = ((ViewFactory.GuideView)ViewFactory.a().a(80000002, this, true));
      if (this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactViewFactory$GuideView != null) {}
    }
    while (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(0) == this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactViewFactory$GuideView)
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactViewFactory$GuideView.setListener(new ccd(this));
      a(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactViewFactory$GuideView);
      return;
    }
    a(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactViewFactory$GuideView);
  }
  
  protected void k()
  {
    super.k();
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void onClick(View paramView)
  {
    paramView = paramView.getTag();
    if ((paramView != null) && ((paramView instanceof SearchBaseActivity.ItemViewHolder)))
    {
      paramView = (SearchBaseActivity.ItemViewHolder)paramView;
      a(paramView.jdField_b_of_type_Int, paramView.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record);
      ReportController.b(this.app, "CliOper", "", "", "0X8004BF2", "0X8004BF2", a(paramView.jdField_b_of_type_Int), 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.SearchContactsActivity
 * JD-Core Version:    0.7.0.1
 */