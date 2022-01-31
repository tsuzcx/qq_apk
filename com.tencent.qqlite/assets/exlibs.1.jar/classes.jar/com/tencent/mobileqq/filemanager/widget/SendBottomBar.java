package com.tencent.mobileqq.filemanager.widget;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.data.FMDataCache;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.filemanager.util.IClickListener_Ver51;
import dwd;
import dwe;
import dwg;
import dwh;

public class SendBottomBar
  extends RelativeLayout
{
  public ProgressDialog a;
  private Context jdField_a_of_type_AndroidContentContext;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new dwd(this);
  public TextView a;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
  private BaseFileAssistantActivity jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity;
  private IClickListener_Ver51 jdField_a_of_type_ComTencentMobileqqFilemanagerUtilIClickListener_Ver51;
  private View.OnClickListener jdField_b_of_type_AndroidViewView$OnClickListener = new dwe(this);
  private TextView jdField_b_of_type_AndroidWidgetTextView = null;
  private TextView c = null;
  private TextView d = null;
  private TextView e = null;
  
  public SendBottomBar(Context paramContext)
  {
    super(paramContext, null);
    ((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(2130903424, this);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    d();
  }
  
  public SendBottomBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    ((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(2130903424, this, true);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    d();
  }
  
  private void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity = ((BaseFileAssistantActivity)this.jdField_a_of_type_AndroidContentContext);
    this.d = ((TextView)findViewById(2131298028));
    this.e = ((TextView)findViewById(2131298029));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131296941));
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
    this.c = ((TextView)findViewById(2131298027));
    this.c.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getAppRuntime());
  }
  
  private void e()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.setResult(-1, null);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.finish();
  }
  
  public void a()
  {
    boolean bool3 = true;
    Object localObject;
    String str1;
    label207:
    boolean bool1;
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.a() == 5)
    {
      localObject = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131362192) + this.jdField_a_of_type_AndroidContentContext.getString(2131362019) + FMDataCache.a() + this.jdField_a_of_type_AndroidContentContext.getString(2131362020);
      String str2 = this.jdField_a_of_type_AndroidContentContext.getString(2131361969) + FileUtil.a(FMDataCache.c());
      str1 = str2;
      if (FMDataCache.d() > 0L) {
        str1 = str2 + this.jdField_a_of_type_AndroidContentContext.getString(2131361970) + FileUtil.a(FMDataCache.d());
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.b();
      int i = this.c.getVisibility();
      if ((i != 4) && (i != 8)) {
        break label343;
      }
      this.e.setVisibility(0);
      this.d.setVisibility(8);
      this.e.setText(str1);
      if (FileManagerUtil.a() == null) {
        break label372;
      }
      bool1 = true;
      label215:
      this.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      localObject = this.jdField_b_of_type_AndroidWidgetTextView;
      if (FMDataCache.a() <= 0L) {
        break label377;
      }
      bool2 = true;
      label240:
      ((TextView)localObject).setEnabled(bool2);
      this.c.setEnabled(bool1);
      localObject = this.jdField_b_of_type_AndroidWidgetTextView;
      if (FMDataCache.a() <= 0L) {
        break label382;
      }
    }
    label343:
    label372:
    label377:
    label382:
    for (boolean bool2 = bool3;; bool2 = false)
    {
      ((TextView)localObject).setSelected(bool2);
      this.c.setSelected(bool1);
      return;
      localObject = this.jdField_a_of_type_AndroidContentContext.getString(2131361963) + this.jdField_a_of_type_AndroidContentContext.getString(2131362019) + FMDataCache.a() + this.jdField_a_of_type_AndroidContentContext.getString(2131362020);
      break;
      this.d.setVisibility(0);
      this.e.setVisibility(8);
      this.d.setText(str1);
      break label207;
      bool1 = false;
      break label215;
      bool2 = false;
      break label240;
    }
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidAppProgressDialog != null) {
      c();
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramInt);
      if (!this.jdField_a_of_type_AndroidAppProgressDialog.isShowing()) {
        this.jdField_a_of_type_AndroidAppProgressDialog.show();
      }
      return;
      this.jdField_a_of_type_AndroidAppProgressDialog = new ProgressDialog(SplashActivity.sTopActivity, 2131624119);
      this.jdField_a_of_type_AndroidAppProgressDialog.setCancelable(false);
      this.jdField_a_of_type_AndroidAppProgressDialog.show();
      this.jdField_a_of_type_AndroidAppProgressDialog.getWindow().setContentView(2130903271);
      this.jdField_a_of_type_AndroidAppProgressDialog.setContentView(2130903271);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidAppProgressDialog.findViewById(2131297431));
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if ((FileManagerUtil.a()) && (FMDataCache.a()) && (paramBoolean))
    {
      FMDialogUtil.a(this.jdField_a_of_type_AndroidContentContext, 2131362018, 2131362016, new dwg(this));
      return;
    }
    b();
  }
  
  public void b()
  {
    new dwh(this).execute(new Void[0]);
  }
  
  public void c()
  {
    try
    {
      if ((this.jdField_a_of_type_AndroidAppProgressDialog != null) && (this.jdField_a_of_type_AndroidAppProgressDialog.isShowing())) {
        this.jdField_a_of_type_AndroidAppProgressDialog.cancel();
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void setClickListener(IClickListener_Ver51 paramIClickListener_Ver51)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilIClickListener_Ver51 = paramIClickListener_Ver51;
  }
  
  public void setEditBtnVisible(boolean paramBoolean)
  {
    TextView localTextView = this.c;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localTextView.setVisibility(i);
      a();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.widget.SendBottomBar
 * JD-Core Version:    0.7.0.1
 */