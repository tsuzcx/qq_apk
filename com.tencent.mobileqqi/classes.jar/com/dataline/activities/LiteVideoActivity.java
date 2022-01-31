package com.dataline.activities;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.KeyEvent;
import android.view.WindowManager;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.TextView;
import cn;
import co;
import com.dataline.util.file.FileUtil;
import com.dataline.util.file.ImageInfo;
import com.dataline.util.file.SendInfo;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.DataLineHandler.EFILETYPE;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import cp;
import cq;
import cr;
import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;

public class LiteVideoActivity
  extends IphoneTitleBarActivity
{
  public static String a;
  private static Comparator jdField_a_of_type_JavaUtilComparator = new cr();
  public static final String b = "NEED_WARNING_WHEN_OVER_5M_IN_G234";
  private static int jdField_c_of_type_Int = 0;
  private static final int e = 4;
  int jdField_a_of_type_Int;
  private DisplayMetrics jdField_a_of_type_AndroidUtilDisplayMetrics = null;
  private AdapterView.OnItemClickListener jdField_a_of_type_AndroidWidgetAdapterView$OnItemClickListener = new cq(this);
  private GridView jdField_a_of_type_AndroidWidgetGridView = null;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private LiteVideoActivity.ImageAdapter jdField_a_of_type_ComDatalineActivitiesLiteVideoActivity$ImageAdapter = null;
  private ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  public boolean a;
  int jdField_b_of_type_Int;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private ArrayList jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  private boolean jdField_b_of_type_Boolean = false;
  private String jdField_c_of_type_JavaLangString = null;
  private int d = 0;
  private int f;
  private int g;
  private int h;
  
  static
  {
    jdField_a_of_type_JavaLangString = "LiteVideoActivity";
    jdField_c_of_type_Int = 5242880;
  }
  
  public LiteVideoActivity()
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
  private void a(ImageInfo paramImageInfo)
  {
    if ((!this.jdField_a_of_type_JavaUtilArrayList.contains(paramImageInfo)) && (this.jdField_a_of_type_JavaUtilArrayList.add(paramImageInfo))) {
      j();
    }
    if ((this.m != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)) {
      d(true);
    }
  }
  
  private boolean a(ImageInfo paramImageInfo)
  {
    return this.jdField_a_of_type_JavaUtilArrayList.contains(paramImageInfo);
  }
  
  private boolean a(String paramString)
  {
    if (!new File(paramString).exists())
    {
      i();
      return false;
    }
    return true;
  }
  
  private int b()
  {
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  private void b(ImageInfo paramImageInfo)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList.remove(paramImageInfo)) {
      j();
    }
    if ((this.m != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() == 0)) {
      d(false);
    }
  }
  
  private boolean c()
  {
    return super.b();
  }
  
  private void d()
  {
    Object localObject = ((WindowManager)getSystemService("window")).getDefaultDisplay();
    this.h = getResources().getDimensionPixelSize(2131427458);
    this.f = getResources().getDimensionPixelSize(2131427456);
    this.g = getResources().getDimensionPixelSize(2131427457);
    this.jdField_a_of_type_Int = ((((Display)localObject).getWidth() - this.h * 2 - this.f * 3) / 4);
    this.jdField_b_of_type_Int = this.jdField_a_of_type_Int;
    localObject = getIntent();
    if (localObject != null) {
      this.jdField_a_of_type_Boolean = ((Intent)localObject).getBooleanExtra("NEED_WARNING_WHEN_OVER_5M_IN_G234", true);
    }
  }
  
  private void e()
  {
    setTitle(2131558512);
    if (this.jdField_a_of_type_AndroidWidgetTextView == null) {
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131231376));
    }
    this.jdField_b_of_type_AndroidWidgetTextView = this.k;
    if (this.jdField_b_of_type_AndroidWidgetTextView != null) {
      this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(new cn(this));
    }
    b(2131558516, new co(this));
    if (b() == 0)
    {
      d(false);
      return;
    }
    d(true);
  }
  
  private void f()
  {
    Intent localIntent = new Intent();
    localIntent.putParcelableArrayListExtra("sendInfo", this.jdField_b_of_type_JavaUtilArrayList);
    setResult(-1, localIntent);
    if (this.jdField_a_of_type_JavaUtilArrayList != null) {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
    }
    finish();
  }
  
  private boolean f()
  {
    if (b() >= 20)
    {
      h();
      return false;
    }
    return true;
  }
  
  private void g()
  {
    FMDialogUtil.a(a(), 2131558759, 2131558756, new cp(this));
  }
  
  private void h()
  {
    QQToast localQQToast = new QQToast(this);
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
    localQQToast.a(2130837933);
    localQQToast.c(2000);
    localQQToast.b(2131558517);
    localQQToast.b(localDisplayMetrics.heightPixels / 2);
  }
  
  private void i()
  {
    QQToast localQQToast = new QQToast(this);
    localQQToast.a(2130837933);
    localQQToast.c(2000);
    localQQToast.b(2131558519);
    localQQToast.b(this.jdField_a_of_type_AndroidUtilDisplayMetrics.heightPixels / 2);
  }
  
  private void j()
  {
    int i = b();
    setTitle(this.jdField_c_of_type_JavaLangString + "(" + Integer.toString(i) + "/20)");
  }
  
  public SendInfo a(ImageInfo paramImageInfo)
  {
    SendInfo localSendInfo = null;
    String str3 = paramImageInfo.a();
    String str2 = FileUtil.c(this, str3);
    String str1 = str2;
    if (str2 == null) {
      str1 = FileUtil.a(this);
    }
    long l = ((DataLineHandler)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(8)).a(null, str1, DataLineHandler.EFILETYPE.FILE_TYPE_VIDEO, 0L, 0, 0, 0, false);
    if (a(paramImageInfo)) {
      localSendInfo = SendInfo.a(str3, str1, l);
    }
    QLog.d(jdField_a_of_type_JavaLangString, 2, "mediaPath:" + str3 + ", thumbPath:" + str1 + ", msgId:" + l);
    return localSendInfo;
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2130903191);
    e();
    d();
    this.jdField_c_of_type_JavaLangString = ((String)getResources().getText(2131558512));
    this.jdField_a_of_type_AndroidWidgetGridView = ((GridView)findViewById(2131230904));
    this.jdField_a_of_type_AndroidWidgetGridView.setSelector(new ColorDrawable(0));
    this.jdField_a_of_type_AndroidWidgetGridView.setScrollBarStyle(0);
    this.jdField_a_of_type_AndroidWidgetGridView.setNumColumns(4);
    this.jdField_a_of_type_AndroidWidgetGridView.setColumnWidth(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_AndroidWidgetGridView.setHorizontalSpacing(this.f);
    this.jdField_a_of_type_AndroidWidgetGridView.setVerticalSpacing(this.g);
    this.jdField_a_of_type_AndroidWidgetGridView.setPadding(this.h, this.jdField_a_of_type_AndroidWidgetGridView.getPaddingTop(), this.h, this.jdField_a_of_type_AndroidWidgetGridView.getPaddingBottom());
    this.jdField_a_of_type_ComDatalineActivitiesLiteVideoActivity$ImageAdapter = new LiteVideoActivity.ImageAdapter(this, this);
    this.jdField_a_of_type_AndroidWidgetGridView.setAdapter(this.jdField_a_of_type_ComDatalineActivitiesLiteVideoActivity$ImageAdapter);
    this.jdField_a_of_type_AndroidWidgetGridView.setOnItemClickListener(this.jdField_a_of_type_AndroidWidgetAdapterView$OnItemClickListener);
    return true;
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      setResult(0, null);
      finish();
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.dataline.activities.LiteVideoActivity
 * JD-Core Version:    0.7.0.1
 */