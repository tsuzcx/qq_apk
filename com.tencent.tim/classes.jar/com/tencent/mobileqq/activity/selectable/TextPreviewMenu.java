package com.tencent.mobileqq.activity.selectable;

import aavp;
import aavx;
import aawh;
import aawi;
import acfp;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import anot;
import aofz;
import aoga;
import aogb;
import aqiw;
import aqoa;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.TextPreviewActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.widget.ContainerView;
import com.tencent.mobileqq.widget.ParticipleBottomMenuView;
import com.tencent.mobileqq.widget.ParticipleView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.widget.ScrollView;
import java.lang.ref.WeakReference;
import java.util.List;
import wja;
import wta;

public class TextPreviewMenu
  extends aavx<TextPreviewActivity>
{
  private aogb a;
  protected ProgressView a;
  private boolean bAz;
  protected Dialog g;
  private String mSenderUin;
  private int mSessionType;
  private int mUinType = -1;
  private List<String> vw;
  
  public TextPreviewMenu()
  {
    this.jdField_a_of_type_Aogb = new aawi(this);
  }
  
  private void a(Activity paramActivity, QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    wta.a(paramActivity, paramQQAppInterface, paramMessageRecord, 2);
    try
    {
      aofz.hG(getContent(), "TextPreview");
      if (paramBoolean)
      {
        anot.a(paramQQAppInterface, "dc00898", "", "", "0X800A356", "0X800A356", 0, 0, "", "", "", "");
        return;
      }
      anot.a(paramQQAppInterface, "dc00898", "", "", "0X8009F00", "0X8009F00", 0, 0, "", "", "", "");
      return;
    }
    catch (Exception paramActivity)
    {
      if (QLog.isColorLevel()) {
        QLog.e("TextPreviewMenu", 2, paramActivity.toString());
      }
    }
  }
  
  private void a(TextPreviewActivity paramTextPreviewActivity)
  {
    paramTextPreviewActivity.jdField_a_of_type_ComTencentMobileqqWidgetParticipleBottomMenuView.a(paramTextPreviewActivity.jdField_a_of_type_ComTencentMobileqqWidgetParticipleView);
    paramTextPreviewActivity.jdField_a_of_type_ComTencentMobileqqWidgetParticipleBottomMenuView.setOnMenuClickListener(new aawh(this, paramTextPreviewActivity));
    paramTextPreviewActivity.vc.setOnClickListener(this);
    paramTextPreviewActivity.vd.setOnClickListener(this);
    paramTextPreviewActivity.ve.setOnClickListener(this);
    paramTextPreviewActivity.vf.setOnClickListener(this);
  }
  
  private void a(TextPreviewActivity paramTextPreviewActivity, int paramInt1, int paramInt2)
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramTextPreviewActivity.b.getLayoutParams();
    localLayoutParams.bottomMargin = wja.dp2px(paramInt1, paramTextPreviewActivity.getResources());
    localLayoutParams.leftMargin = wja.dp2px(paramInt2, paramTextPreviewActivity.getResources());
    localLayoutParams.rightMargin = wja.dp2px(paramInt2, paramTextPreviewActivity.getResources());
    paramTextPreviewActivity.b.setLayoutParams(localLayoutParams);
    paramTextPreviewActivity.b.post(new TextPreviewMenu.3(this, paramTextPreviewActivity));
  }
  
  private void cX(Intent paramIntent)
  {
    TextPreviewActivity localTextPreviewActivity = (TextPreviewActivity)this.mActivity.get();
    if (localTextPreviewActivity != null) {
      localTextPreviewActivity.startActivityForResult(paramIntent, -1);
    }
  }
  
  private void czN()
  {
    if ((this.vw != null) && (this.vw.size() > 0)) {
      hL(this.vw);
    }
    TextPreviewActivity localTextPreviewActivity;
    do
    {
      do
      {
        return;
        localTextPreviewActivity = (TextPreviewActivity)this.mActivity.get();
      } while (localTextPreviewActivity == null);
      if (!aqiw.isNetSupport(localTextPreviewActivity))
      {
        QQToast.a(localTextPreviewActivity, acfp.m(2131715258), 0).show(localTextPreviewActivity.getResources().getDimensionPixelSize(2131299627));
        return;
      }
    } while (TextUtils.isEmpty(this.content));
    ((aoga)localTextPreviewActivity.app.getBusinessHandler(161)).q(localTextPreviewActivity.app, this.content, this.mSenderUin);
    showProgressDialog();
  }
  
  private void czO()
  {
    TextPreviewActivity localTextPreviewActivity = (TextPreviewActivity)this.mActivity.get();
    if (localTextPreviewActivity != null)
    {
      localTextPreviewActivity.jdField_a_of_type_ComTencentMobileqqWidgetParticipleBottomMenuView.setVisibility(8);
      localTextPreviewActivity.jdField_a_of_type_ComTencentMobileqqWidgetParticipleView.setVisibility(8);
      localTextPreviewActivity.vb.setVisibility(0);
      localTextPreviewActivity.jdField_a_of_type_ComTencentMobileqqWidgetContainerView.setVisibility(0);
      a(localTextPreviewActivity, 135, 20);
    }
  }
  
  private int fR(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return -2;
    case 0: 
      return 1;
    case 1: 
      return 2;
    case 3000: 
      return 4;
    }
    return 3;
  }
  
  private void hL(List<String> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      this.vw = paramList;
      TextPreviewActivity localTextPreviewActivity = (TextPreviewActivity)this.mActivity.get();
      if (localTextPreviewActivity != null)
      {
        localTextPreviewActivity.jdField_a_of_type_ComTencentMobileqqWidgetContainerView.setVisibility(8);
        localTextPreviewActivity.vb.setVisibility(8);
        localTextPreviewActivity.jdField_a_of_type_ComTencentMobileqqWidgetParticipleView.setParticipleItems(paramList);
        localTextPreviewActivity.jdField_a_of_type_ComTencentMobileqqWidgetParticipleView.eim();
        localTextPreviewActivity.jdField_a_of_type_ComTencentMobileqqWidgetParticipleBottomMenuView.eig();
        a(localTextPreviewActivity, 60, 10);
      }
      return;
    }
    QQToast.a(BaseApplicationImpl.getContext(), 1, acfp.m(2131715268), 0).show();
  }
  
  private void hideProgressDialog()
  {
    if (this.g != null)
    {
      this.g.setOnCancelListener(null);
      this.g.dismiss();
    }
  }
  
  private void showProgressDialog()
  {
    Activity localActivity = (Activity)this.mActivity.get();
    if (localActivity != null)
    {
      if (this.g != null) {
        break label138;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectableTextPreviewMenu$ProgressView = new ProgressView(localActivity);
      this.g = new ReportDialog(localActivity);
      if (this.g.getWindow() != null) {
        this.g.getWindow().setBackgroundDrawable(new ColorDrawable(0));
      }
      this.g.setCanceledOnTouchOutside(false);
      this.g.requestWindowFeature(1);
      this.g.setContentView(this.jdField_a_of_type_ComTencentMobileqqActivitySelectableTextPreviewMenu$ProgressView);
      this.g.setOnCancelListener(new a(localActivity));
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectableTextPreviewMenu$ProgressView.setProgressText(acfp.m(2131715269));
      this.g.show();
      return;
      label138:
      this.g.dismiss();
    }
  }
  
  public void a(TextPreviewActivity paramTextPreviewActivity, ContainerView paramContainerView)
  {
    super.a(paramTextPreviewActivity, paramContainerView);
    this.mUinType = paramTextPreviewActivity.uinType;
    this.mSenderUin = paramTextPreviewActivity.senderUin;
    this.bAz = paramTextPreviewActivity.isMultiMsg;
    this.mSessionType = paramTextPreviewActivity.sessionType;
    a(paramTextPreviewActivity);
    paramTextPreviewActivity.app.addObserver(this.jdField_a_of_type_Aogb);
  }
  
  public void a(ContainerView paramContainerView, View paramView)
  {
    super.a(paramContainerView, paramView);
    int i = fR(this.mSessionType);
    anot.a((QQAppInterface)this.n.get(), "dc00898", "", "", "0X8009EFF", "0X8009EFF", i, 0, "", "", "", "");
  }
  
  public void b(ContainerView paramContainerView)
  {
    super.b(paramContainerView);
    paramContainerView = (TextPreviewActivity)this.mActivity.get();
    if ((paramContainerView != null) && (paramContainerView.app != null)) {
      paramContainerView.app.removeObserver(this.jdField_a_of_type_Aogb);
    }
    hideProgressDialog();
  }
  
  public void d(aqoa paramaqoa)
  {
    paramaqoa.Z(2131365509, acfp.m(2131715263), 2130839077);
    paramaqoa.Z(2131367523, acfp.m(2131715261), 2130839086);
    switch (this.mUinType)
    {
    }
    for (;;)
    {
      paramaqoa.Z(2131366733, acfp.m(2131715264), 2130839085);
      return;
      if ((!this.bAz) && (this.mSessionType != -2))
      {
        paramaqoa.Z(2131377133, acfp.m(2131715270), 2130839090);
        continue;
        TextPreviewActivity localTextPreviewActivity = (TextPreviewActivity)this.mActivity.get();
        if ((localTextPreviewActivity != null) && (localTextPreviewActivity.app != null) && (!this.mSenderUin.equals(localTextPreviewActivity.app.getCurrentAccountUin()))) {
          paramaqoa.Z(2131377133, acfp.m(2131715262), 2130839090);
        }
      }
    }
  }
  
  public boolean onBackPress()
  {
    TextPreviewActivity localTextPreviewActivity = (TextPreviewActivity)this.mActivity.get();
    if (localTextPreviewActivity != null)
    {
      if (localTextPreviewActivity.jdField_a_of_type_ComTencentMobileqqWidgetParticipleView.getVisibility() == 0) {}
      for (boolean bool = true;; bool = false)
      {
        if (bool) {
          czO();
        }
        return bool;
      }
    }
    return false;
  }
  
  public void onClick(View paramView)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)this.n.get();
    TextPreviewActivity localTextPreviewActivity = (TextPreviewActivity)this.mActivity.get();
    MessageRecord localMessageRecord;
    boolean bool;
    if (localTextPreviewActivity == null)
    {
      localMessageRecord = null;
      bool = false;
      switch (paramView.getId())
      {
      }
    }
    for (;;)
    {
      if ((paramView.getId() != 2131377931) && (aavp.a().isSelected())) {
        aavp.a().detach();
      }
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      localMessageRecord = localTextPreviewActivity.j;
      break;
      bool = true;
      a(localTextPreviewActivity, localQQAppInterface, localMessageRecord, bool);
      continue;
      wta.a(localTextPreviewActivity, localQQAppInterface, localMessageRecord, 3);
      aofz.N((Activity)paramView.getContext(), getContent());
      anot.a(localQQAppInterface, "dc00898", "", "", "0X8009F01", "0X8009F01", 0, 0, "", "", "", "");
      continue;
      wta.a(localTextPreviewActivity, localQQAppInterface, localMessageRecord, 4);
      if (localQQAppInterface != null) {
        aofz.c((Activity)paramView.getContext(), localQQAppInterface, getContent());
      }
      anot.a(localQQAppInterface, "dc00898", "", "", "0X8009F02", "0X8009F02", 0, 0, "", "", "", "");
      continue;
      aavp.a().O(null);
      continue;
      if (localTextPreviewActivity != null)
      {
        localTextPreviewActivity.setResult(14001, localTextPreviewActivity.getIntent());
        localTextPreviewActivity.finish();
        anot.a(localQQAppInterface, "dc00898", "", "", "0X800A1D1", "0X800A1D1", 4, 0, "", "", "", "");
        continue;
        if (localTextPreviewActivity != null)
        {
          localTextPreviewActivity.wF(getContent());
          anot.a(localQQAppInterface, "dc00898", "", "", "0X800A1D1", "0X800A1D1", 5, 0, "", "", "", "");
          continue;
          czN();
          anot.a(localTextPreviewActivity.app, "dc00898", "", "", "0X800A357", "0X800A357", 1, 0, "", "", "", "");
          continue;
          localTextPreviewActivity.bWc();
        }
      }
    }
  }
  
  public static final class ProgressView
    extends FrameLayout
  {
    private TextView nM;
    
    public ProgressView(Context paramContext)
    {
      super();
      init(paramContext);
    }
    
    public ProgressView(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      init(paramContext);
    }
    
    private void init(Context paramContext)
    {
      LayoutInflater.from(paramContext).inflate(2131562047, this);
      this.nM = ((TextView)findViewById(2131379401));
      findViewById(2131363405).setBackgroundColor(Color.parseColor("#1c1c1d"));
    }
    
    public void setProgressText(CharSequence paramCharSequence)
    {
      if ((paramCharSequence == null) || (paramCharSequence.length() <= 0))
      {
        this.nM.setVisibility(8);
        return;
      }
      this.nM.setVisibility(0);
      this.nM.setText(paramCharSequence);
    }
  }
  
  public static class a
    implements DialogInterface.OnCancelListener
  {
    private final WeakReference<Activity> mHost;
    
    public a(Activity paramActivity)
    {
      this.mHost = new WeakReference(paramActivity);
    }
    
    public void onCancel(DialogInterface paramDialogInterface)
    {
      Activity localActivity = (Activity)this.mHost.get();
      if ((localActivity != null) && (!localActivity.isFinishing())) {
        paramDialogInterface.dismiss();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectable.TextPreviewMenu
 * JD-Core Version:    0.7.0.1
 */