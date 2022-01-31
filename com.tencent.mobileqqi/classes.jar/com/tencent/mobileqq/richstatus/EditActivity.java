package com.tencent.mobileqq.richstatus;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.ClickableImageSpan;
import com.tencent.mobileqq.widget.ClickableImageSpan.ClickableImageSpanListener;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.MaxHeightRelativelayout;
import cooperation.qzone.LbsData.QzoneGpsInfo;
import cooperation.qzone.LbsData.QzonePoiInfo;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import ggr;
import ggs;
import ggt;
import ggu;
import ggy;
import ggz;
import gha;
import ghb;
import ghc;
import ghd;
import ghe;
import ghf;
import ghg;
import java.util.ArrayList;
import java.util.Arrays;

public class EditActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, AdapterView.OnItemClickListener
{
  public static final int a = 1;
  public static final String a;
  private static final int jdField_b_of_type_Int = 1;
  static final long jdField_b_of_type_Long = 1300L;
  public static final String b = "sp_hot_status";
  private static final boolean jdField_b_of_type_Boolean = true;
  private static final int jdField_c_of_type_Int = 2;
  public static final String c = "param_rich_status";
  private static final int jdField_d_of_type_Int = 47;
  public static final String d = "k_action_id";
  private static final int jdField_e_of_type_Int = 15;
  public static final String e = "k_action_text";
  public static final String f = "k_data_id";
  public static final String g = "k_data_text";
  public static final String h = "k_source";
  private static final String i = " ";
  private static final String j = "...";
  public long a;
  private Intent jdField_a_of_type_AndroidContentIntent;
  private Handler jdField_a_of_type_AndroidOsHandler = new ggs(this);
  private TextWatcher jdField_a_of_type_AndroidTextTextWatcher = new gha(this);
  private View jdField_a_of_type_AndroidViewView;
  private GridView jdField_a_of_type_AndroidWidgetGridView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private IActionListener jdField_a_of_type_ComTencentMobileqqRichstatusIActionListener = new ggr(this);
  private IIconListener jdField_a_of_type_ComTencentMobileqqRichstatusIIconListener = new ggy(this);
  private IStatusListener jdField_a_of_type_ComTencentMobileqqRichstatusIStatusListener = new ggz(this);
  private RichStatus jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus;
  private RichStatusEditText.RichStatusEditListener jdField_a_of_type_ComTencentMobileqqRichstatusRichStatusEditText$RichStatusEditListener = new ghb(this);
  private RichStatusEditText jdField_a_of_type_ComTencentMobileqqRichstatusRichStatusEditText;
  private StatusManager jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager;
  private StatusObserver jdField_a_of_type_ComTencentMobileqqRichstatusStatusObserver = new ggt(this);
  private ClickableImageSpan.ClickableImageSpanListener jdField_a_of_type_ComTencentMobileqqWidgetClickableImageSpan$ClickableImageSpanListener = new ghc(this);
  private ClickableImageSpan jdField_a_of_type_ComTencentMobileqqWidgetClickableImageSpan;
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
  public ActionSheet a;
  private ghg jdField_a_of_type_Ghg;
  private ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList(6);
  private boolean jdField_a_of_type_Boolean = false;
  private View jdField_b_of_type_AndroidViewView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private boolean jdField_c_of_type_Boolean;
  private boolean jdField_d_of_type_Boolean;
  private boolean jdField_e_of_type_Boolean;
  private int f;
  
  static
  {
    jdField_a_of_type_JavaLangString = EditActivity.class.getSimpleName();
  }
  
  public EditActivity()
  {
    this.c = false;
    this.e = true;
    this.jdField_a_of_type_Long = 0L;
  }
  
  private Drawable a(View paramView)
  {
    paramView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
    paramView.layout(0, 0, paramView.getMeasuredWidth(), paramView.getMeasuredHeight());
    Object localObject = new Canvas(Bitmap.createBitmap(paramView.getWidth(), paramView.getHeight(), Bitmap.Config.ARGB_8888));
    ((Canvas)localObject).translate(-paramView.getScrollX(), -paramView.getScrollY());
    paramView.draw((Canvas)localObject);
    paramView.setDrawingCacheEnabled(true);
    localObject = paramView.getDrawingCache().copy(Bitmap.Config.ARGB_8888, true);
    paramView.destroyDrawingCache();
    paramView = new BitmapDrawable(getResources(), (Bitmap)localObject);
    paramView.setBounds(0, 0, ((Bitmap)localObject).getWidth(), ((Bitmap)localObject).getHeight());
    return paramView;
  }
  
  private Drawable a(boolean paramBoolean)
  {
    View localView = ((LayoutInflater)getSystemService("layout_inflater")).inflate(2130903261, null);
    ImageView localImageView = (ImageView)localView.findViewById(2131231862);
    TextView localTextView = (TextView)localView.findViewById(2131231863);
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.jdField_c_of_type_JavaLangString;
    Object localObject1 = localObject2;
    if (this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.jdField_d_of_type_JavaLangString != null) {
      localObject1 = (String)localObject2 + this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.jdField_d_of_type_JavaLangString;
    }
    localObject2 = localObject1;
    if (((String)localObject1).length() > 15) {
      localObject2 = ((String)localObject1).substring(0, 14) + "...";
    }
    localTextView.setText((CharSequence)localObject2);
    localImageView.setImageBitmap(this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.b, 200));
    localTextView.setPressed(paramBoolean);
    if (paramBoolean) {
      localView.setBackgroundResource(2130839652);
    }
    for (;;)
    {
      return a(localView);
      localView.setBackgroundResource(2130839651);
    }
  }
  
  private void a(Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      paramBundle = paramBundle.getByteArray("param_rich_status");
      if ((paramBundle.length != 0) && (paramBundle.length > 0)) {
        this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus = RichStatus.a(paramBundle);
      }
    }
    int k = (int)getIntent().getLongExtra("k_action_id", 0L);
    Object localObject;
    if (k != 0)
    {
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus = new RichStatus(null);
      this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.b = k;
      paramBundle = this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.b);
      localObject = this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus;
      if (paramBundle != null)
      {
        paramBundle = paramBundle.jdField_d_of_type_JavaLangString;
        ((RichStatus)localObject).jdField_c_of_type_JavaLangString = paramBundle;
        this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.jdField_c_of_type_Int = ((int)getIntent().getLongExtra("k_data_id", 0L));
        this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.jdField_d_of_type_JavaLangString = getIntent().getStringExtra("k_data_text");
      }
    }
    for (;;)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.jdField_a_of_type_JavaUtilArrayList;
      paramBundle = (Bundle)localObject;
      if (localObject == null)
      {
        paramBundle = new ArrayList();
        this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.jdField_a_of_type_JavaUtilArrayList = paramBundle;
      }
      while (paramBundle.size() < 2) {
        paramBundle.add(null);
      }
      paramBundle = " ";
      break;
      if (this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus == null) {
        this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus = ((RichStatus)this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.a().clone());
      }
    }
  }
  
  private void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatusEditText.setEnabled(paramBoolean);
    this.jdField_a_of_type_AndroidViewView.setEnabled(paramBoolean);
    this.jdField_b_of_type_AndroidViewView.setEnabled(paramBoolean);
    d(paramBoolean);
    if (!paramBoolean) {}
    for (boolean bool = true;; bool = false)
    {
      b(bool);
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetClickableImageSpan != null) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetClickableImageSpan.a(paramBoolean);
      }
      return;
    }
  }
  
  private void b(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(a(), d());
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(getString(2131559266));
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
    }
    while (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
  }
  
  private void c(boolean paramBoolean)
  {
    if (paramBoolean) {
      k();
    }
    if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.jdField_c_of_type_JavaLangString))
    {
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      return;
    }
    this.jdField_b_of_type_AndroidViewView.setVisibility(0);
    if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.jdField_e_of_type_JavaLangString))
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(2131562922);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840361);
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(getResources().getColorStateList(2131362108));
      this.jdField_b_of_type_AndroidWidgetTextView.setContentDescription("连按两次添加位置信息");
      return;
    }
    this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.jdField_e_of_type_JavaLangString);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130838104);
    this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(getResources().getColorStateList(2131362085));
    this.jdField_b_of_type_AndroidWidgetTextView.setContentDescription("所在地:" + this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.jdField_e_of_type_JavaLangString + "连按两次添加位置信息");
  }
  
  private void f(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.jdField_c_of_type_JavaLangString == null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetClickableImageSpan != null) {
        this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatusEditText.a(this.jdField_a_of_type_ComTencentMobileqqWidgetClickableImageSpan, true, true);
      }
      return;
    }
    ClickableImageSpan localClickableImageSpan = new ClickableImageSpan(a(false), a(true));
    localClickableImageSpan.a(this.jdField_a_of_type_ComTencentMobileqqWidgetClickableImageSpan$ClickableImageSpanListener);
    localClickableImageSpan.a(this.jdField_a_of_type_Boolean);
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetClickableImageSpan != null) {
      localClickableImageSpan.getDrawable().setState(this.jdField_a_of_type_ComTencentMobileqqWidgetClickableImageSpan.getDrawable().getState());
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetClickableImageSpan != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatusEditText.a(this.jdField_a_of_type_ComTencentMobileqqWidgetClickableImageSpan, localClickableImageSpan);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetClickableImageSpan = localClickableImageSpan;
      if (!paramBoolean) {
        break;
      }
      k();
      return;
      this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatusEditText.getText().insert(0, "[S]");
      int k = "[S]".length();
      this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatusEditText.setSpan(localClickableImageSpan, 0, k);
    }
  }
  
  private void i()
  {
    setTitle(getString(2131559265));
    b(2131562656, this);
    d(true);
    ((MaxHeightRelativelayout)findViewById(2131234520)).setMaxHeight((int)(getResources().getDisplayMetrics().heightPixels * 0.31D));
    this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatusEditText = ((RichStatusEditText)findViewById(2131233373));
    this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatusEditText.setEditListener(this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatusEditText$RichStatusEditListener);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131231169));
    this.jdField_a_of_type_AndroidWidgetTextView.setText("");
    this.jdField_a_of_type_AndroidViewView = findViewById(2131234522);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    if (!this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
    this.k.setContentDescription(this.k.getText() + "按钮");
    this.m.setContentDescription(this.m.getText() + "按钮");
    this.jdField_a_of_type_AndroidViewView.setContentDescription("做什么按钮");
    this.jdField_b_of_type_AndroidViewView = findViewById(2131234521);
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130839660);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131231862));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131231863));
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131234523));
      this.jdField_a_of_type_AndroidWidgetGridView = ((GridView)findViewById(2131234525));
      this.jdField_a_of_type_AndroidWidgetGridView.setOnItemClickListener(this);
      this.jdField_a_of_type_Ghg = new ghg(this, null);
      this.jdField_a_of_type_AndroidWidgetGridView.setAdapter(this.jdField_a_of_type_Ghg);
      if (this.jdField_a_of_type_JavaUtilArrayList.size() == 0) {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(4);
      }
    }
    else
    {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
  }
  
  private void j()
  {
    this.e = false;
    this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatusEditText.setText("");
    f(false);
    ArrayList localArrayList = this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.jdField_a_of_type_JavaUtilArrayList;
    if (localArrayList.get(0) != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatusEditText.getText().append((CharSequence)localArrayList.get(0));
    }
    if (localArrayList.get(1) != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatusEditText.getText().append((CharSequence)localArrayList.get(1));
    }
    c(false);
    this.e = true;
    k();
  }
  
  private void k()
  {
    if (!this.e) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetClickableImageSpan != null) {}
    for (int k = Math.max(this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatusEditText.getText().getSpanEnd(this.jdField_a_of_type_ComTencentMobileqqWidgetClickableImageSpan), 0);; k = 0)
    {
      int m = this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatusEditText.getText().length();
      this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.jdField_a_of_type_JavaUtilArrayList.set(0, this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatusEditText.getText().subSequence(k, m).toString());
      this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.jdField_a_of_type_JavaUtilArrayList.set(1, null);
      k = this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.b();
      String str = Integer.toString(47 - k);
      if (k > 47)
      {
        SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(str);
        localSpannableStringBuilder.setSpan(new ForegroundColorSpan(-65536), 0, str.length(), 33);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(localSpannableStringBuilder);
        return;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setText(str);
      return;
    }
  }
  
  private void l()
  {
    this.d = false;
    this.jdField_a_of_type_Ghg.notifyDataSetChanged();
    this.jdField_a_of_type_AndroidWidgetGridView.postDelayed(new ggu(this), 200L);
  }
  
  protected void a(int paramInt)
  {
    QQToast.a(a(), paramInt, 0).b(d());
  }
  
  public void d()
  {
    ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Rich_status", "Clk_what2do", 0, 0, "", "", "", "");
    startActivityForResult(new Intent(this, ActionListActivity.class), 1);
    overridePendingTransition(2130968591, 2130968595);
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Object localObject;
    if (paramInt2 == -1)
    {
      if (paramInt1 != 1) {
        break label172;
      }
      if (this.jdField_a_of_type_AndroidContentIntent != null) {
        break label153;
      }
      this.jdField_a_of_type_AndroidContentIntent = paramIntent;
      this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.b = ((int)this.jdField_a_of_type_AndroidContentIntent.getLongExtra("k_action_id", 0L));
      this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("k_action_text");
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.jdField_c_of_type_JavaLangString))
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.b);
        RichStatus localRichStatus = this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus;
        if (localObject == null) {
          break label165;
        }
        localObject = ((ActionInfo)localObject).jdField_d_of_type_JavaLangString;
        label103:
        localRichStatus.jdField_c_of_type_JavaLangString = ((String)localObject);
      }
      this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.jdField_c_of_type_Int = ((int)paramIntent.getLongExtra("k_data_id", 0L));
      this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.jdField_d_of_type_JavaLangString = paramIntent.getStringExtra("k_data_text");
      f(true);
      c(true);
      g();
    }
    label153:
    label165:
    label172:
    do
    {
      do
      {
        return;
        this.jdField_a_of_type_AndroidContentIntent.putExtras(paramIntent);
        break;
        localObject = " ";
        break label103;
      } while (paramInt1 != 2);
      paramIntent = (LbsData.QzonePoiInfo)paramIntent.getParcelableExtra("key_select_poi");
    } while (paramIntent == null);
    this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.jdField_e_of_type_JavaLangString = paramIntent.b;
    if (paramIntent.a != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.f = paramIntent.a.a;
      this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.jdField_e_of_type_Int = paramIntent.a.b;
    }
    c(true);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2130903987);
    this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager = ((StatusManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(13));
    if (this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager == null)
    {
      a(2131561658);
      finish();
      return false;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.a())
    {
      a(2131562809);
      finish();
      return false;
    }
    a(paramBundle);
    i();
    this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusIActionListener);
    this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusIIconListener);
    j();
    this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatusEditText.addTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
    this.f = getIntent().getIntExtra("k_source", -1);
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusObserver);
      this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.a();
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 1000L);
    }
    return true;
  }
  
  protected void doOnDestroy()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatusEditText != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatusEditText.setEnabled(false);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetClickableImageSpan != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetClickableImageSpan.a(null);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.b(this.jdField_a_of_type_ComTencentMobileqqRichstatusIIconListener);
      this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.b(this.jdField_a_of_type_ComTencentMobileqqRichstatusIActionListener);
      this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.b(this.jdField_a_of_type_ComTencentMobileqqRichstatusIStatusListener);
    }
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusObserver);
    super.doOnDestroy();
  }
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    if (this.f == -1) {
      this.f = getIntent().getIntExtra("k_source", -1);
    }
    doOnActivityResult(1, -1, paramIntent);
  }
  
  protected void doOnPause()
  {
    h();
    super.doOnPause();
  }
  
  protected void doOnRestoreInstanceState(Bundle paramBundle)
  {
    this.e = false;
    super.doOnRestoreInstanceState(paramBundle);
    this.e = true;
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
  }
  
  protected void doOnSaveInstanceState(Bundle paramBundle)
  {
    paramBundle.putByteArray("param_rich_status", this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.a());
    super.doOnSaveInstanceState(paramBundle);
  }
  
  protected void doOnStart()
  {
    this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatusEditText.setVisibility(0);
    super.doOnStart();
  }
  
  protected void doOnStop()
  {
    this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatusEditText.setVisibility(4);
    super.doOnStop();
  }
  
  public void e()
  {
    ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Rich_status", "Clk_where", 0, 0, "", "", "", "");
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    QZoneHelper.UserInfo localUserInfo = QZoneHelper.UserInfo.a();
    localUserInfo.jdField_a_of_type_JavaLangString = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a();
    localUserInfo.b = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.e();
    localUserInfo.jdField_c_of_type_JavaLangString = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getSid();
    QZoneHelper.d(this, localUserInfo, 2);
    overridePendingTransition(2130968591, 2130968595);
  }
  
  void f()
  {
    this.jdField_a_of_type_ComTencentWidgetActionSheet = ((ActionSheet)ActionSheetHelper.a(this, null));
    this.jdField_a_of_type_ComTencentWidgetActionSheet.a(2131561788, 0);
    this.jdField_a_of_type_ComTencentWidgetActionSheet.a(2131561919, 3);
    this.jdField_a_of_type_ComTencentWidgetActionSheet.d(2131561746);
    this.jdField_a_of_type_ComTencentWidgetActionSheet.a(new ghd(this));
    this.jdField_a_of_type_ComTencentWidgetActionSheet.setOnDismissListener(new ghe(this));
  }
  
  public void g()
  {
    new Handler().postDelayed(new ghf(this), 500L);
  }
  
  void h()
  {
    ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatusEditText.getWindowToken(), 0);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      if (!NetworkUtil.e(this)) {
        a(2131562446);
      }
      break;
    case 2131234522: 
    case 2131234521: 
      do
      {
        return;
        d();
        return;
      } while (System.currentTimeMillis() - this.jdField_a_of_type_Long < 1300L);
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.jdField_e_of_type_JavaLangString))
      {
        e();
        return;
      }
      if (this.jdField_a_of_type_ComTencentWidgetActionSheet == null) {
        f();
      }
      h();
      this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.b() > 47)
    {
      a(2131562929);
      return;
    }
    paramView = this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus;
    if (TextUtils.isEmpty((CharSequence)this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.jdField_a_of_type_JavaUtilArrayList.get(0))) {}
    for (int k = 0;; k = 1)
    {
      paramView.jdField_d_of_type_Int = k;
      if (!Arrays.equals(this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.a().a(), this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.a())) {
        this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus, this.f);
      }
      setResult(-1);
      finish();
      return;
    }
  }
  
  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AdapterView localAdapterView = null;
    paramInt = ((Integer)paramView.getTag()).intValue();
    ActionInfo localActionInfo = this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.a(paramInt);
    if (localActionInfo == null) {}
    label29:
    Intent localIntent;
    do
    {
      return;
      localIntent = new Intent();
      localIntent.putExtra("k_action_id", localActionInfo.jdField_i_of_type_Int);
      localIntent.putExtra("k_action_text", localActionInfo.jdField_d_of_type_JavaLangString);
      if (localActionInfo.j == 1)
      {
        this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.b = paramInt;
        paramView = this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus;
        if (localActionInfo != null) {}
        for (paramAdapterView = localActionInfo.jdField_d_of_type_JavaLangString;; paramAdapterView = " ")
        {
          paramView.jdField_c_of_type_JavaLangString = paramAdapterView;
          this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.jdField_c_of_type_Int = 0;
          this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.jdField_d_of_type_JavaLangString = null;
          f(true);
          c(true);
          return;
        }
      }
    } while (localActionInfo.j == 0);
    for (;;)
    {
      try
      {
        paramInt = localActionInfo.j;
        switch (paramInt)
        {
        default: 
          paramAdapterView = null;
          localAdapterView = paramAdapterView;
          if (localAdapterView == null) {
            break label29;
          }
          this.jdField_a_of_type_AndroidContentIntent = localIntent;
          startActivityForResult(localAdapterView, 1);
          return;
        }
      }
      catch (Exception paramView)
      {
        paramAdapterView = localException;
        continue;
      }
      paramAdapterView = new Intent(this, ActionListActivity.class);
      try
      {
        paramAdapterView.putExtra("k_action_id", localActionInfo.jdField_i_of_type_Int);
      }
      catch (Exception paramView) {}
    }
    for (;;)
    {
      for (;;)
      {
        for (;;)
        {
          for (;;)
          {
            localAdapterView = paramAdapterView;
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.e("Q.richstatus.", 2, paramView.getStackTrace().toString());
            localAdapterView = paramAdapterView;
            break;
            paramAdapterView = new Intent(this, ActionGridActivity.class);
            try
            {
              paramAdapterView.putExtra("k_action_id", localActionInfo.jdField_i_of_type_Int);
            }
            catch (Exception paramView) {}
          }
          continue;
          paramView = localActionInfo.jdField_e_of_type_JavaLangString.replace("$A", this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a());
          paramAdapterView = new Intent(this, ActionUrlActivity.class);
          try
          {
            paramAdapterView.putExtra("key_params_qq", paramView);
          }
          catch (Exception paramView) {}
        }
        continue;
        paramView = new Intent(this, Class.forName(localActionInfo.h));
        try
        {
          paramView.putExtra("param_plugin_gesturelock", true);
          paramAdapterView = paramView;
          if (localActionInfo.jdField_i_of_type_JavaLangString == null) {
            break;
          }
          paramView.putExtra("key_params_qq", this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.a(localActionInfo.jdField_i_of_type_JavaLangString, localActionInfo.jdField_i_of_type_Int, 0, ""));
          paramAdapterView = paramView;
        }
        catch (Exception localException)
        {
          paramAdapterView = paramView;
          paramView = localException;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.EditActivity
 * JD-Core Version:    0.7.0.1
 */