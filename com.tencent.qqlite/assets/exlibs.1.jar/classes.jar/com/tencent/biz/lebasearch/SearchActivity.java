package com.tencent.biz.lebasearch;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.viewplugin.ViewPluginManager;
import com.tencent.biz.widgets.ActiveSearchTipsContainer;
import com.tencent.biz.widgets.ActiveSearchTipsContainer.OnTipClickListener;
import com.tencent.mobileqq.activity.leba.LebaShowListManager;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.observer.GameCenterObserver;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.widget.ExtendInputMethodRelativeLayout;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.mobileqq.widget.InputMethodRelativeLayout.onSizeChangedListenner;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import ng;
import nh;
import ni;
import nj;
import nk;
import nl;
import nm;

public class SearchActivity
  extends BaseActivity
  implements View.OnClickListener, InputMethodRelativeLayout.onSizeChangedListenner
{
  public static final int a = 1;
  public static final String a = "DynamicSearch";
  public static final int b = 2;
  public static final String b = "0X8004AB2";
  public static final int c = 1;
  public static final String c = "0X8004AB4";
  public static final int d = 2;
  public static final String d = "0X8004B21";
  public static final int e = 3;
  public static final String e = "0X8004B22";
  public static final int f = 0;
  public static final String f = "0X8004B23";
  public static final int g = 1;
  public static final String g = "0X8004B24";
  public static final int h = 2;
  public static final String h = "request_type";
  public static final int i = 3;
  public static final String i = "request_keyword";
  InputMethodManager jdField_a_of_type_AndroidViewInputmethodInputMethodManager = null;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  private ImageButton jdField_a_of_type_AndroidWidgetImageButton;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private SearchProtocol.SearchObserver jdField_a_of_type_ComTencentBizLebasearchSearchProtocol$SearchObserver = new nh(this);
  private ViewPluginManager jdField_a_of_type_ComTencentBizViewpluginViewPluginManager;
  private ActiveSearchTipsContainer.OnTipClickListener jdField_a_of_type_ComTencentBizWidgetsActiveSearchTipsContainer$OnTipClickListener = new ni(this);
  private ActiveSearchTipsContainer jdField_a_of_type_ComTencentBizWidgetsActiveSearchTipsContainer;
  private GameCenterObserver jdField_a_of_type_ComTencentMobileqqObserverGameCenterObserver = new ng(this);
  private ExtendInputMethodRelativeLayout jdField_a_of_type_ComTencentMobileqqTroopWidgetExtendInputMethodRelativeLayout;
  AdapterView.OnItemClickListener jdField_a_of_type_ComTencentWidgetAdapterView$OnItemClickListener = new nk(this);
  private XListView jdField_a_of_type_ComTencentWidgetXListView;
  private List jdField_a_of_type_JavaUtilList = new ArrayList();
  private nm jdField_a_of_type_Nm = new nm(this, null);
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  AdapterView.OnItemClickListener jdField_b_of_type_ComTencentWidgetAdapterView$OnItemClickListener = new nl(this);
  private XListView jdField_b_of_type_ComTencentWidgetXListView;
  private List jdField_b_of_type_JavaUtilList = null;
  private RelativeLayout c;
  private RelativeLayout d;
  private int jdField_j_of_type_Int = 1;
  private String jdField_j_of_type_JavaLangString;
  private int k;
  private int l = 0;
  
  private void a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      this.c.setVisibility(8);
      this.d.setVisibility(8);
      this.l = 1;
      return;
    case 2: 
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.c.setVisibility(0);
      this.d.setVisibility(8);
      this.l = 2;
      return;
    case 3: 
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.c.setVisibility(8);
      this.d.setVisibility(0);
      this.l = 3;
      return;
    }
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    this.c.setVisibility(8);
    this.d.setVisibility(8);
    this.l = 0;
  }
  
  public static void a(Activity paramActivity)
  {
    Intent localIntent = new Intent(paramActivity, SearchActivity.class);
    localIntent.putExtra("request_type", 1);
    paramActivity.startActivity(localIntent);
    paramActivity.overridePendingTransition(2130968592, 2130968589);
  }
  
  public static void a(Activity paramActivity, String paramString)
  {
    Intent localIntent = new Intent(paramActivity, SearchActivity.class);
    localIntent.putExtra("request_type", 2);
    localIntent.putExtra("request_keyword", paramString);
    paramActivity.startActivity(localIntent);
    paramActivity.overridePendingTransition(2130968592, 2130968589);
  }
  
  private void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentBizWidgetsActiveSearchTipsContainer.setOnTipsClickListener(this.jdField_a_of_type_ComTencentBizWidgetsActiveSearchTipsContainer$OnTipClickListener);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(((SearchProtocol.WordItem)localIterator.next()).a);
    }
    this.jdField_a_of_type_ComTencentBizWidgetsActiveSearchTipsContainer.a(localArrayList);
    if ((localArrayList.size() != 0) && (paramBoolean))
    {
      a(1);
      return;
    }
    a(0);
  }
  
  private void b(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      a(0);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.jdField_a_of_type_ComTencentWidgetXListView.setEnabled(false);
      this.jdField_a_of_type_AndroidWidgetImageButton.setEnabled(false);
      this.jdField_a_of_type_AndroidWidgetEditText.setEnabled(false);
      this.jdField_a_of_type_AndroidWidgetButton.setText(2131362801);
      this.jdField_a_of_type_AndroidWidgetButton.setContentDescription(getString(2131362657));
      return;
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    this.jdField_a_of_type_ComTencentWidgetXListView.setEnabled(true);
    this.jdField_a_of_type_AndroidWidgetImageButton.setEnabled(true);
    this.jdField_a_of_type_AndroidWidgetEditText.setEnabled(true);
  }
  
  private void c()
  {
    SearchProtocol.b(this.app, this, this.jdField_a_of_type_ComTencentBizLebasearchSearchProtocol$SearchObserver);
    if (this.jdField_j_of_type_Int == 2)
    {
      String str = getIntent().getStringExtra("request_keyword");
      a(str);
      this.jdField_j_of_type_JavaLangString = this.app.a().getSharedPreferences(this.app.getAccount(), 0).getString("active_search_home_hot_word_id", "");
      this.k = 1;
      if (!TextUtils.isEmpty(str))
      {
        SearchProtocol.a(this.app, this, this.jdField_a_of_type_ComTencentBizLebasearchSearchProtocol$SearchObserver, str, this.jdField_b_of_type_JavaUtilList);
        b(true);
      }
    }
  }
  
  private void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetExtendInputMethodRelativeLayout = ((ExtendInputMethodRelativeLayout)findViewById(2131297543));
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetExtendInputMethodRelativeLayout.setOnSizeChangedListenner(this);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131297544));
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131297962));
    this.jdField_a_of_type_AndroidWidgetEditText.setHint("");
    this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131297955));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131298430));
    this.jdField_a_of_type_AndroidWidgetButton.setContentDescription(getString(2131362657));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131297549));
    this.c = ((RelativeLayout)findViewById(2131296866));
    this.jdField_b_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131296867));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131296868));
    this.jdField_b_of_type_ComTencentWidgetXListView.setOnItemClickListener(this.jdField_b_of_type_ComTencentWidgetAdapterView$OnItemClickListener);
    LinearLayout localLinearLayout = new LinearLayout(this);
    localLinearLayout.setOrientation(1);
    localLinearLayout.setLayoutParams(new AbsListView.LayoutParams(-1, (int)DisplayUtils.a(this, 20.0F) + 1));
    TextView localTextView1 = new TextView(this);
    localTextView1.setLayoutParams(new LinearLayout.LayoutParams(-1, 1));
    localTextView1.setBackgroundColor(Color.parseColor("#dedfe0"));
    TextView localTextView2 = new TextView(this);
    localTextView2.setLayoutParams(new LinearLayout.LayoutParams(-1, (int)DisplayUtils.a(this, 20.0F)));
    localTextView2.setBackgroundColor(-1);
    localLinearLayout.addView(localTextView1);
    localLinearLayout.addView(localTextView2);
    this.jdField_b_of_type_ComTencentWidgetXListView.b(localLinearLayout, null, true);
    this.jdField_b_of_type_ComTencentWidgetXListView.setFooterDividersEnabled(false);
    this.jdField_a_of_type_ComTencentBizWidgetsActiveSearchTipsContainer = ((ActiveSearchTipsContainer)findViewById(2131297080));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131297545));
    this.d = ((RelativeLayout)findViewById(2131297547));
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131297548));
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnItemClickListener(this.jdField_a_of_type_ComTencentWidgetAdapterView$OnItemClickListener);
    if (this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager == null) {
      this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager = ((InputMethodManager)getSystemService("input_method"));
    }
    this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetEditText.setImeOptions(3);
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(this.jdField_a_of_type_Nm);
    this.jdField_a_of_type_AndroidWidgetEditText.setOnEditorActionListener(new nj(this));
    this.jdField_a_of_type_AndroidWidgetEditText.setContentDescription(getString(2131362656));
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetEditText.removeTextChangedListener(this.jdField_a_of_type_Nm);
    this.jdField_a_of_type_AndroidWidgetEditText.setText(paramString);
    this.jdField_a_of_type_AndroidWidgetEditText.setSelection(paramString.length());
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(this.jdField_a_of_type_Nm);
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if ((this.l == 1) && (this.jdField_a_of_type_ComTencentBizWidgetsActiveSearchTipsContainer != null))
    {
      this.jdField_a_of_type_ComTencentBizWidgetsActiveSearchTipsContainer.setVisibleHeight((int)(paramInt2 - DisplayUtils.a(this, 87.0F)));
      a(true);
    }
  }
  
  public void b(String paramString)
  {
    if (paramString.equals(""))
    {
      this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetButton.setText(2131362801);
      this.jdField_a_of_type_AndroidWidgetButton.setContentDescription(getString(2131362657));
      if (this.jdField_a_of_type_JavaUtilList.size() == 0)
      {
        a(0);
        return;
      }
      a(1);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetButton.setText(2131362656);
    this.jdField_a_of_type_AndroidWidgetButton.setContentDescription(getString(2131362656));
    SearchProtocol.a(this.app, this, this.jdField_a_of_type_ComTencentBizLebasearchSearchProtocol$SearchObserver, paramString);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    requestWindowFeature(1);
    super.doOnCreate(paramBundle);
    this.jdField_b_of_type_JavaUtilList = LebaShowListManager.a().a();
    this.app.registObserver(this.jdField_a_of_type_ComTencentMobileqqObserverGameCenterObserver);
    setContentView(2130903290);
    d();
    this.jdField_a_of_type_ComTencentBizViewpluginViewPluginManager = new ViewPluginManager(this, "SearchViewPlugin.apk", "1002");
    this.jdField_a_of_type_ComTencentBizViewpluginViewPluginManager.a();
    paramBundle = getIntent();
    if (paramBundle == null) {
      finish();
    }
    do
    {
      return true;
      this.jdField_j_of_type_Int = paramBundle.getIntExtra("request_type", 1);
      c();
      if (this.jdField_j_of_type_Int == 1)
      {
        a(0);
        return true;
      }
    } while (this.jdField_j_of_type_Int != 2);
    a(2);
    ReportController.b(this.app, "CliOper", "", "", "0X8004B21", "0X8004B21", 0, 0, null, null, null, null);
    return true;
  }
  
  protected void doOnDestroy()
  {
    this.app.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqObserverGameCenterObserver);
    super.doOnDestroy();
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
  }
  
  @TargetApi(9)
  protected void doOnResume()
  {
    super.doOnResume();
    if (this.l == 0)
    {
      getWindow().setSoftInputMode(20);
      return;
    }
    getWindow().setSoftInputMode(18);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
    case 2131298430: 
      do
      {
        return;
        if (this.jdField_a_of_type_AndroidWidgetButton.getText().toString().equals(getString(2131362801)))
        {
          ReportController.b(this.app, "CliOper", "", "", "0X8004B23", "0X8004B23", 0, 0, null, null, null, null);
          finish();
          return;
        }
      } while ((!this.jdField_a_of_type_AndroidWidgetButton.getText().toString().equals(getString(2131362656))) || (TextUtils.isEmpty(this.jdField_a_of_type_AndroidWidgetEditText.getText())));
      this.k = 2;
      SearchProtocol.a(this.app, this, this.jdField_a_of_type_ComTencentBizLebasearchSearchProtocol$SearchObserver, this.jdField_a_of_type_AndroidWidgetEditText.getText().toString(), this.jdField_b_of_type_JavaUtilList);
      b(true);
      ReportController.b(this.app, "CliOper", "", "", "0X8004B22", "0X8004B22", 0, 0, null, null, null, null);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetEditText.setText("");
    this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager.showSoftInput(this.jdField_a_of_type_AndroidWidgetEditText, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.biz.lebasearch.SearchActivity
 * JD-Core Version:    0.7.0.1
 */