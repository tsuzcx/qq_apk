package com.tencent.mobileqq.filemanager.widget;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.MsgProxyUtils;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.data.FMDataCache;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.model.FriendManager;
import cooperation.qlink.QLAndQQStructDef.SendFileNbyInfo;
import cooperation.qlink.QQProxyForQlink;
import fyz;
import fzb;
import fzc;
import fzd;
import java.util.ArrayList;
import java.util.List;

public class SendBottomBar
  extends RelativeLayout
{
  public ProgressDialog a;
  private Context jdField_a_of_type_AndroidContentContext;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new fyz(this);
  public TextView a;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
  private BaseFileAssistantActivity jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity;
  private TextView b = null;
  private TextView c = null;
  
  public SendBottomBar(Context paramContext)
  {
    super(paramContext, null);
    ((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(2130903506, this);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    d();
  }
  
  public SendBottomBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    ((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(2130903506, this, true);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    d();
  }
  
  private void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity = ((BaseFileAssistantActivity)this.jdField_a_of_type_AndroidContentContext);
    this.c = ((TextView)findViewById(2131232757));
    this.b = ((TextView)findViewById(2131231498));
    this.b.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getAppRuntime());
  }
  
  private void e()
  {
    String str = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.c();
    Object localObject = FMDataCache.b();
    ArrayList localArrayList = new ArrayList();
    QLAndQQStructDef.SendFileNbyInfo localSendFileNbyInfo = new QLAndQQStructDef.SendFileNbyInfo();
    localSendFileNbyInfo.source = 0;
    int i = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.c();
    if (3 == i) {
      localSendFileNbyInfo.source = 2;
    }
    for (;;)
    {
      i = 0;
      while (i < ((ArrayList)localObject).size())
      {
        localArrayList.add(((FileInfo)((ArrayList)localObject).get(i)).c());
        i += 1;
      }
      if (2 == i) {
        localSendFileNbyInfo.source = 1;
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(str, localSendFileNbyInfo, localArrayList);
    localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getIntent();
    boolean bool = ((FriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8)).b(str);
    if (!bool)
    {
      MsgProxyUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str, 1001);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(str, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 1001, -3010, this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131560933));
      ((Intent)localObject).putExtra("tmpsig", FMDataCache.a(str));
    }
    ((Intent)localObject).putExtra("isfriend", bool);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.setResult(-1, this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getIntent());
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.finish();
  }
  
  private void f()
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.e();
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.i();
    if ((1 == i) && (!bool))
    {
      FMDialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, 2131560885, 2131560886, new fzb(this));
      return;
    }
    e();
  }
  
  private void g()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.setResult(-1, null);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.finish();
  }
  
  public void a()
  {
    boolean bool2 = true;
    Object localObject;
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.a() == 5)
    {
      localObject = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131560303) + this.jdField_a_of_type_AndroidContentContext.getString(2131558760) + FMDataCache.a() + this.jdField_a_of_type_AndroidContentContext.getString(2131558761);
      String str = this.jdField_a_of_type_AndroidContentContext.getString(2131558708) + FileUtil.a(FMDataCache.c());
      switch (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.b())
      {
      default: 
        this.c.setText(str);
        label137:
        this.b.setText((CharSequence)localObject);
        localObject = this.b;
        if (FMDataCache.a() > 0L)
        {
          bool1 = true;
          label160:
          ((TextView)localObject).setEnabled(bool1);
          localObject = this.b;
          if (FMDataCache.a() <= 0L) {
            break label261;
          }
        }
        break;
      }
    }
    label261:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      ((TextView)localObject).setSelected(bool1);
      return;
      localObject = this.jdField_a_of_type_AndroidContentContext.getString(2131558702) + this.jdField_a_of_type_AndroidContentContext.getString(2131558760) + FMDataCache.a() + this.jdField_a_of_type_AndroidContentContext.getString(2131558761);
      break;
      this.c.setText(2131560884);
      break label137;
      bool1 = false;
      break label160;
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
      this.jdField_a_of_type_AndroidAppProgressDialog = new ProgressDialog(SplashActivity.a, 2131624405);
      this.jdField_a_of_type_AndroidAppProgressDialog.setCancelable(false);
      this.jdField_a_of_type_AndroidAppProgressDialog.show();
      this.jdField_a_of_type_AndroidAppProgressDialog.getWindow().setContentView(2130903319);
      this.jdField_a_of_type_AndroidAppProgressDialog.setContentView(2130903319);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidAppProgressDialog.findViewById(2131232069));
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if ((FileManagerUtil.a()) && (FMDataCache.a()) && (paramBoolean))
    {
      FMDialogUtil.a(SplashActivity.a, 2131558759, 2131558756, new fzc(this));
      return;
    }
    b();
  }
  
  public void b()
  {
    new fzd(this).execute(new Void[0]);
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_AndroidAppProgressDialog != null) {
      this.jdField_a_of_type_AndroidAppProgressDialog.cancel();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.widget.SendBottomBar
 * JD-Core Version:    0.7.0.1
 */