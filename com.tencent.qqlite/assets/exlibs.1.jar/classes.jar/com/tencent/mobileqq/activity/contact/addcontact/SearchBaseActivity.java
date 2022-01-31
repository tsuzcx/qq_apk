package com.tencent.mobileqq.activity.contact.addcontact;

import SummaryCard.SearchInfo;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import cbv;
import cbw;
import cbx;
import cby;
import cbz;
import cca;
import com.tencent.mobileqq.activity.AddFriendActivity;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.activity.TroopInfoActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.richstatus.IIconListener;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.mobileqq.util.FaceDecoder.DecodeTaskCompletionListener;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.pb.addcontacts.AccountSearchPb.record;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public class SearchBaseActivity
  extends BaseActivity
  implements View.OnClickListener, FaceDecoder.DecodeTaskCompletionListener, AbsListView.OnScrollListener
{
  private static final String jdField_a_of_type_JavaLangString = SearchBaseActivity.class.getName();
  protected static HashMap a;
  public static final Pattern a;
  public static final String b = "from_key";
  protected static HashMap b;
  public static final String c = "last_key_words";
  public static final int d = 0;
  public static final int e = 1;
  public static final int i = -16734752;
  public static final int j = 0;
  public static final int k = 1;
  public static final int l = 2;
  public static final int m = 3;
  public Handler a;
  protected BaseAdapter a;
  Button jdField_a_of_type_AndroidWidgetButton;
  public EditText a;
  public ImageButton a;
  public LinearLayout a;
  protected ContactSearchFacade.ISearchListener a;
  protected ContactSearchFacade a;
  CustomerLoadingDialog jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactCustomerLoadingDialog;
  protected IIconListener a;
  protected StatusManager a;
  FaceDecoder jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder;
  public XListView a;
  public final Pattern b;
  public boolean b;
  public final int c;
  public final Pattern c;
  protected boolean c;
  protected String d;
  protected int f = 0;
  public int g = 0;
  protected int h;
  
  static
  {
    jdField_a_of_type_JavaUtilRegexPattern = Pattern.compile("^[_a-z0-9-]+(\\.[_a-z0-9-]+)*@[a-z0-9-]+(\\.[a-z0-9-]+)*(\\.[a-z]{2,3})$", 2);
    jdField_a_of_type_JavaUtilHashMap = new HashMap(15);
    jdField_b_of_type_JavaUtilHashMap = new HashMap(8);
  }
  
  public SearchBaseActivity()
  {
    this.jdField_c_of_type_Int = 64;
    this.jdField_b_of_type_JavaUtilRegexPattern = Pattern.compile("[^0-9]");
    this.jdField_c_of_type_JavaUtilRegexPattern = Pattern.compile("^1[0-9]{2}\\d{8}$");
    this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactSearchFacade$ISearchListener = new cbv(this);
    this.jdField_a_of_type_AndroidOsHandler = new cbw(this);
    this.jdField_a_of_type_ComTencentMobileqqRichstatusIIconListener = new cca(this);
  }
  
  protected int a()
  {
    if (this.f == 0) {
      return 80000000;
    }
    return 80000001;
  }
  
  protected SpannableString a(long paramLong)
  {
    return (SpannableString)jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong));
  }
  
  protected String a(SearchBaseActivity.ItemViewHolder paramItemViewHolder, AccountSearchPb.record paramrecord)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject;
    int i1;
    int n;
    switch (paramrecord.sex.get())
    {
    default: 
      localObject = "";
      i1 = 0;
      n = 0;
      localStringBuilder.append((String)localObject);
      if ((i1 == 0) && (paramrecord.age.get() == 0))
      {
        paramItemViewHolder.jdField_b_of_type_AndroidWidgetTextView.setText("");
        paramItemViewHolder.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
        paramItemViewHolder.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
      }
      break;
    }
    for (;;)
    {
      localObject = new StringBuilder();
      if (!TextUtils.isEmpty(paramrecord.province_name.get())) {
        ((StringBuilder)localObject).append(paramrecord.province_name.get()).append(" ");
      }
      if (!TextUtils.isEmpty(paramrecord.city_name.get())) {
        ((StringBuilder)localObject).append(paramrecord.city_name.get());
      }
      if ((((StringBuilder)localObject).length() == 0) && (!TextUtils.isEmpty(paramrecord.country_name.get()))) {
        ((StringBuilder)localObject).append(paramrecord.country_name.get());
      }
      paramItemViewHolder.c.setText(((StringBuilder)localObject).toString());
      localStringBuilder.append(((StringBuilder)localObject).toString());
      a(paramItemViewHolder, paramrecord.richStatus);
      localStringBuilder.append(paramItemViewHolder.d.getText().toString());
      return localStringBuilder.toString();
      i1 = 2130838089;
      n = 2130838759;
      localObject = "男";
      break;
      i1 = 2130838084;
      n = 2130838758;
      localObject = "女";
      break;
      paramItemViewHolder.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      paramItemViewHolder.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(i1, 0, 0, 0);
      paramItemViewHolder.jdField_b_of_type_AndroidWidgetTextView.setBackgroundResource(n);
      paramItemViewHolder.jdField_b_of_type_AndroidWidgetTextView.setText(String.valueOf(paramrecord.age.get()));
      paramItemViewHolder.jdField_b_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131427353));
      localStringBuilder.append(paramItemViewHolder.jdField_b_of_type_AndroidWidgetTextView.getText());
    }
  }
  
  public void a(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onDecodeTaskCompleted type = " + paramInt2 + ", uin = " + paramString);
    }
    int n;
    if ((paramBitmap != null) && (this.g == 0))
    {
      n = this.jdField_a_of_type_ComTencentWidgetXListView.getChildCount();
      paramInt1 = 0;
    }
    for (;;)
    {
      Object localObject;
      if (paramInt1 < n)
      {
        localObject = this.jdField_a_of_type_ComTencentWidgetXListView.getChildAt(paramInt1).getTag();
        if ((localObject == null) || (!(localObject instanceof SearchBaseActivity.ItemViewHolder))) {
          break label154;
        }
        localObject = (SearchBaseActivity.ItemViewHolder)localObject;
        if (!((SearchBaseActivity.ItemViewHolder)localObject).jdField_a_of_type_JavaLangString.equals(paramString)) {
          break label154;
        }
        if (paramInt2 == 4)
        {
          if (80000001 != ((SearchBaseActivity.ItemViewHolder)localObject).jdField_b_of_type_Int) {
            break label154;
          }
          ((SearchBaseActivity.ItemViewHolder)localObject).jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
        }
      }
      else
      {
        return;
      }
      ((SearchBaseActivity.ItemViewHolder)localObject).jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
      return;
      label154:
      paramInt1 += 1;
    }
  }
  
  protected void a(int paramInt, AccountSearchPb.record paramrecord)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 80000000: 
      a(paramrecord);
      return;
    }
    ChatSettingForTroop.a(this, TroopInfoActivity.a(String.valueOf(paramrecord.code.get()), 2), 2);
  }
  
  public void a(int paramInt1, Object paramObject, int paramInt2, String paramString)
  {
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1, paramString));
  }
  
  protected void a(View paramView)
  {
    if (paramView != null)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(paramView);
    }
  }
  
  public void a(SearchBaseActivity.ItemViewHolder paramItemViewHolder, RichStatus paramRichStatus)
  {
    paramItemViewHolder.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus = paramRichStatus;
    if ((paramRichStatus != null) && (!paramRichStatus.a()))
    {
      if (!TextUtils.isEmpty(paramRichStatus.c))
      {
        paramItemViewHolder.jdField_a_of_type_Int = paramRichStatus.jdField_b_of_type_Int;
        Object localObject = this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.a(paramRichStatus.jdField_b_of_type_Int, 200);
        localObject = new BitmapDrawable(getResources(), (Bitmap)localObject);
        int n = this.h;
        ((Drawable)localObject).setBounds(0, 0, Math.round(((Drawable)localObject).getIntrinsicWidth() * 1.0F / ((Drawable)localObject).getIntrinsicHeight() * n), n);
        paramItemViewHolder.d.setCompoundDrawables((Drawable)localObject, null, null, null);
      }
      for (;;)
      {
        paramItemViewHolder.d.setText(paramRichStatus.a(" "));
        return;
        paramItemViewHolder.jdField_a_of_type_Int = 0;
        paramItemViewHolder.d.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
      }
    }
    paramItemViewHolder.jdField_a_of_type_Int = 0;
    paramItemViewHolder.d.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
    paramItemViewHolder.d.setText("");
  }
  
  protected void a(AccountSearchPb.record paramrecord)
  {
    SearchInfo localSearchInfo = new SearchInfo();
    localSearchInfo.lUIN = paramrecord.uin.get();
    localSearchInfo.strNick = paramrecord.name.get();
    localSearchInfo.strMobile = paramrecord.mobile.get();
    localSearchInfo.bIsFriend = ((byte)(int)(paramrecord.relation.get() & 1L));
    localSearchInfo.bInContact = ((byte)(int)(paramrecord.relation.get() & 0x2));
    AddFriendActivity.a(this, localSearchInfo, this.app.a(), null, true);
  }
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    this.g = paramInt;
    if (this.g != 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.c();
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a();
    }
    for (;;)
    {
      paramAbsListView = (InputMethodManager)getSystemService("input_method");
      if (paramAbsListView.isActive()) {
        paramAbsListView.hideSoftInputFromWindow(getWindow().getDecorView().getWindowToken(), 0);
      }
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a())
      {
        this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.b();
        if (this.jdField_a_of_type_AndroidWidgetBaseAdapter != null) {
          this.jdField_a_of_type_AndroidWidgetBaseAdapter.notifyDataSetChanged();
        }
      }
    }
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void a(String paramString)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "搜索失败，请稍后再试";
    }
    QQToast.a(this, str, 0).b(getTitleBarHeight());
  }
  
  protected void a(Map paramMap, ArrayList paramArrayList)
  {
    Iterator localIterator1 = paramArrayList.iterator();
    if (localIterator1.hasNext())
    {
      paramArrayList = (SearchResult)localIterator1.next();
      int n;
      List localList;
      Iterator localIterator2;
      if (paramArrayList.jdField_a_of_type_Int == 80000001)
      {
        n = 1;
        localList = paramArrayList.jdField_a_of_type_JavaUtilList;
        localIterator2 = paramArrayList.b.iterator();
      }
      label264:
      label288:
      for (;;)
      {
        label55:
        AccountSearchPb.record localrecord;
        SpannableString localSpannableString;
        if (localIterator2.hasNext())
        {
          localrecord = (AccountSearchPb.record)localIterator2.next();
          paramArrayList = localrecord.name.get();
          localSpannableString = new SpannableString(paramArrayList);
          Iterator localIterator3 = localList.iterator();
          for (;;)
          {
            if (localIterator3.hasNext())
            {
              String str = (String)localIterator3.next();
              int i1 = paramArrayList.indexOf(str);
              int i2 = str.length();
              if (i1 >= 0)
              {
                localSpannableString.setSpan(new ForegroundColorSpan(-16734752), i1, i2 + i1, 33);
                continue;
                n = 0;
                break;
              }
            }
          }
          paramArrayList = null;
          if (n == 0) {
            break label264;
          }
          jdField_b_of_type_JavaUtilHashMap.put(Long.valueOf(localrecord.code.get()), localSpannableString);
        }
        for (;;)
        {
          if ((paramArrayList == null) || (!QLog.isColorLevel())) {
            break label288;
          }
          QLog.e(jdField_a_of_type_JavaLangString, 2, "重复 uin ！ uin = " + localrecord.uin.get() + " 对应内容：" + paramArrayList.toString());
          break label55;
          break;
          paramArrayList = (SpannableString)paramMap.put(Long.valueOf(localrecord.uin.get()), localSpannableString);
        }
      }
    }
  }
  
  public boolean a(ArrayList paramArrayList)
  {
    return true;
  }
  
  protected SpannableString b(long paramLong)
  {
    return (SpannableString)jdField_b_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong));
  }
  
  protected String b(SearchBaseActivity.ItemViewHolder paramItemViewHolder, AccountSearchPb.record paramrecord)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    paramItemViewHolder.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
    paramItemViewHolder.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(0);
    paramItemViewHolder.jdField_b_of_type_AndroidWidgetTextView.setBackgroundResource(0);
    if ((paramrecord.flag.has()) && (paramrecord.flag.get() == 1L) && (paramrecord.class_index.has()) && (paramrecord.class_index.get() == 20))
    {
      paramItemViewHolder.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 2130838183, 0);
      paramItemViewHolder.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablePadding((int)DisplayUtils.a(this, 6.0F));
      if ((!paramrecord.class_index.has()) || (paramrecord.class_index.get() != 1)) {
        break label242;
      }
      if (paramrecord.class_name.has())
      {
        paramItemViewHolder.jdField_b_of_type_AndroidWidgetTextView.setText(paramrecord.class_name.get());
        localStringBuilder.append(paramrecord.class_name.get());
      }
      if (paramrecord.brief.has())
      {
        paramItemViewHolder.d.setText(paramrecord.brief.get());
        localStringBuilder.append(paramrecord.brief.get());
      }
    }
    for (;;)
    {
      int n = getResources().getColor(2131427498);
      paramItemViewHolder.jdField_b_of_type_AndroidWidgetTextView.setTextColor(n);
      return localStringBuilder.toString();
      paramItemViewHolder.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
      break;
      label242:
      if ((paramrecord.class_index.has()) && (paramrecord.class_index.get() == 20))
      {
        paramItemViewHolder.jdField_b_of_type_AndroidWidgetTextView.setText(2131362460);
        localStringBuilder.append(paramItemViewHolder.jdField_b_of_type_AndroidWidgetTextView.getText());
        if (paramrecord.brief.has())
        {
          paramItemViewHolder.d.setText(paramrecord.brief.get());
          localStringBuilder.append(paramItemViewHolder.d.getText());
        }
      }
    }
  }
  
  protected void c()
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131296955));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131298453));
    this.jdField_a_of_type_AndroidWidgetButton.setTextColor(getResources().getColor(2131427474));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new cbx(this));
    this.jdField_a_of_type_AndroidWidgetButton.setContentDescription(getResources().getString(2131362790));
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131297994));
    this.jdField_a_of_type_AndroidWidgetEditText.setHint(getResources().getString(2131363358));
    this.jdField_a_of_type_AndroidWidgetEditText.setFilters(new InputFilter[] { new InputFilter.LengthFilter(64) });
    this.jdField_a_of_type_AndroidWidgetEditText.setTextSize(0, getResources().getDimension(2131492889));
    this.jdField_a_of_type_AndroidWidgetEditText.setImeOptions(3);
    this.jdField_a_of_type_AndroidWidgetEditText.setSingleLine();
    this.jdField_a_of_type_AndroidWidgetEditText.setOnEditorActionListener(new cby(this));
    this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)findViewById(2131297986));
    this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(new cbz(this));
    this.jdField_a_of_type_ComTencentWidgetXListView = new XListView(this);
    this.jdField_a_of_type_ComTencentWidgetXListView.setCacheColorHint(0);
    this.jdField_a_of_type_ComTencentWidgetXListView.setDivider(null);
    this.jdField_a_of_type_ComTencentWidgetXListView.setSelector(2130839489);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnScrollListener(this);
    this.jdField_a_of_type_ComTencentWidgetXListView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
  }
  
  protected void d()
  {
    Intent localIntent = getIntent();
    if (localIntent.hasExtra("from_key"))
    {
      this.f = localIntent.getIntExtra("from_key", 0);
      this.d = localIntent.getStringExtra("last_key_words");
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2130903543);
    super.getWindow().setBackgroundDrawable(null);
    c();
    j();
    d();
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactCustomerLoadingDialog = null;
    this.jdField_a_of_type_AndroidOsHandler = null;
    ViewFactory.a().a();
    this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactSearchFacade.d();
    this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactSearchFacade = null;
    if (this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.d();
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.b(this.jdField_a_of_type_ComTencentMobileqqRichstatusIIconListener);
    }
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    d(2130837633);
    if (this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a()) {
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.b();
    }
  }
  
  public void e() {}
  
  public void f() {}
  
  public void h()
  {
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2);
  }
  
  protected void i()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "clearHighLightString");
    }
    jdField_a_of_type_JavaUtilHashMap.clear();
    jdField_b_of_type_JavaUtilHashMap.clear();
  }
  
  protected void j()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactSearchFacade = new ContactSearchFacade(this.app);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactSearchFacade.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactSearchFacade$ISearchListener);
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder = new FaceDecoder(this, this.app);
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(this);
    this.h = ((int)DisplayUtils.a(this, 12.0F));
    this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager = ((StatusManager)this.app.getManager(14));
    if (this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusIIconListener);
    }
  }
  
  public void k()
  {
    a(ViewFactory.a().a(80000003, this, true));
  }
  
  public void l()
  {
    super.finish();
    overridePendingTransition(0, 0);
  }
  
  protected void m()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactCustomerLoadingDialog == null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactCustomerLoadingDialog = new CustomerLoadingDialog(this);
    }
    if (!isFinishing()) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactCustomerLoadingDialog.show();
    }
  }
  
  public void n()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactCustomerLoadingDialog != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactCustomerLoadingDialog.dismiss();
    }
  }
  
  public void onClick(View paramView) {}
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.SearchBaseActivity
 * JD-Core Version:    0.7.0.1
 */