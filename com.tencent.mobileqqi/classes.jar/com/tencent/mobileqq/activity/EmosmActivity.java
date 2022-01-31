package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;
import ckc;
import ckd;
import cke;
import ckf;
import ckg;
import ckh;
import cki;
import ckj;
import ckk;
import ckl;
import com.tencent.mobileqq.app.EmosmHandler;
import com.tencent.mobileqq.app.EmosmObserver;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emosm.view.DragSortAdapter;
import com.tencent.mobileqq.emosm.view.DragSortController;
import com.tencent.mobileqq.emosm.view.DragSortListView;
import com.tencent.mobileqq.emosm.view.DragSortListView.DropListener;
import com.tencent.mobileqq.emosm.view.DragSortListView.RemoveListener;
import com.tencent.mobileqq.emoticon.EmoticonController;
import com.tencent.mobileqq.emoticon.EmoticonPackageChangedListener;
import com.tencent.mobileqq.emoticon.EmoticonPackageDownloadListener;
import com.tencent.mobileqq.model.EmoticonManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticAssist;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.MobileQQ;

public class EmosmActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, RadioGroup.OnCheckedChangeListener
{
  public static final int a = 1;
  public static final String a = "extra_launch_source";
  public static final int b = 2;
  public static final String b = "extra_launch_mode";
  public static final int c = 1;
  private static final String jdField_c_of_type_JavaLangString = "EmosmActivity";
  public static final int d = 2;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private RadioButton jdField_a_of_type_AndroidWidgetRadioButton;
  private RadioGroup jdField_a_of_type_AndroidWidgetRadioGroup;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private EmosmObserver jdField_a_of_type_ComTencentMobileqqAppEmosmObserver = new ckc(this);
  private DragSortAdapter jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortAdapter;
  private DragSortListView.DropListener jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView$DropListener = new ckl(this);
  private DragSortListView.RemoveListener jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView$RemoveListener = new ckd(this);
  private DragSortListView jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView;
  private EmoticonPackageChangedListener jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonPackageChangedListener;
  private EmoticonPackageDownloadListener jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonPackageDownloadListener;
  private EmoticonManager jdField_a_of_type_ComTencentMobileqqModelEmoticonManager;
  public QQProgressDialog a;
  private Runnable jdField_a_of_type_JavaLangRunnable;
  private WeakReference jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(this);
  private ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  public boolean a;
  private RadioButton jdField_b_of_type_AndroidWidgetRadioButton;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  public boolean b;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  public boolean c;
  private int e;
  private int f;
  private int g;
  private int h;
  
  private void a(EmoticonPackage paramEmoticonPackage)
  {
    if ((paramEmoticonPackage != null) && (paramEmoticonPackage.jobType == 2))
    {
      EmoticonPackage localEmoticonPackage = this.jdField_a_of_type_ComTencentMobileqqModelEmoticonManager.a(paramEmoticonPackage.kinId);
      if ((localEmoticonPackage != null) && (localEmoticonPackage.kinId != null) && (localEmoticonPackage.kinId.length() > 0))
      {
        localEmoticonPackage.kinId = null;
        this.jdField_a_of_type_ComTencentMobileqqModelEmoticonManager.a(localEmoticonPackage);
      }
      ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "qface_emoji", "delete_qfpkg", 0, 0, paramEmoticonPackage.kinId, "", "", "");
    }
  }
  
  private void d()
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    if (this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortAdapter.clearSelectStatus();
    }
    if ((this.jdField_a_of_type_AndroidWidgetButton != null) && (this.jdField_a_of_type_AndroidWidgetButton.getVisibility() == 0)) {
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqModelEmoticonManager.b();
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      EmoticonPackage localEmoticonPackage;
      if (this.h == 1)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          localEmoticonPackage = (EmoticonPackage)((Iterator)localObject).next();
          if ((!localEmoticonPackage.epId.equals("100000")) && (3 != localEmoticonPackage.jobType)) {
            this.jdField_a_of_type_JavaUtilArrayList.add(localEmoticonPackage);
          }
        }
      }
      if (this.h == 2)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          localEmoticonPackage = (EmoticonPackage)((Iterator)localObject).next();
          if ((3 == localEmoticonPackage.jobType) && (!localEmoticonPackage.epId.equals("100000"))) {
            this.jdField_a_of_type_JavaUtilArrayList.add(localEmoticonPackage);
          }
        }
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortAdapter.notifyDataSetChanged();
    }
  }
  
  public DragSortController a(DragSortListView paramDragSortListView)
  {
    paramDragSortListView = new DragSortController(paramDragSortListView);
    paramDragSortListView.setDragHandleId(2131230761);
    paramDragSortListView.setClickRemoveId(2131230762);
    paramDragSortListView.setRemoveEnabled(true);
    paramDragSortListView.setSortEnabled(true);
    paramDragSortListView.setDragInitMode(0);
    paramDragSortListView.setRemoveMode(0);
    paramDragSortListView.setRemoveOrientation(2);
    return paramDragSortListView;
  }
  
  public void a()
  {
    if (this.jdField_c_of_type_Boolean)
    {
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      EmoticonPackage localEmoticonPackage;
      if (1 == this.h)
      {
        localIterator = this.jdField_a_of_type_ComTencentMobileqqModelEmoticonManager.b().iterator();
        while (localIterator.hasNext())
        {
          localEmoticonPackage = (EmoticonPackage)localIterator.next();
          if ((localEmoticonPackage.type == 1) && (!"100000".equals(localEmoticonPackage.epId))) {
            localArrayList1.add(localEmoticonPackage.epId);
          }
        }
      }
      if (2 == this.h)
      {
        localIterator = this.jdField_a_of_type_ComTencentMobileqqModelEmoticonManager.b().iterator();
        while (localIterator.hasNext())
        {
          localEmoticonPackage = (EmoticonPackage)localIterator.next();
          if ((localEmoticonPackage.type != 1) || ("100000".equals(localEmoticonPackage.epId))) {
            localArrayList1.add(localEmoticonPackage.epId);
          }
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqModelEmoticonManager.c();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext()) {
        localArrayList2.add(((EmoticonPackage)localIterator.next()).epId);
      }
      this.jdField_a_of_type_ComTencentMobileqqModelEmoticonManager.c();
      localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext()) {
        localArrayList2.add(((EmoticonPackage)localIterator.next()).epId);
      }
      this.jdField_a_of_type_ComTencentMobileqqModelEmoticonManager.b(localArrayList1);
      this.jdField_a_of_type_ComTencentMobileqqModelEmoticonManager.b(localArrayList2);
    }
  }
  
  public void a(String paramString)
  {
    paramString = new File(paramString);
    if ((paramString.exists()) && (paramString.isDirectory())) {
      if (paramString.listFiles().length == 0) {
        paramString.delete();
      }
    }
    while (!paramString.exists())
    {
      return;
      File[] arrayOfFile = paramString.listFiles();
      int j = arrayOfFile.length;
      int i = 0;
      while (i < j)
      {
        a(arrayOfFile[i].getAbsolutePath());
        i += 1;
      }
      paramString.delete();
      return;
    }
    paramString.delete();
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2130903232);
    j(2130837729);
    setTitle(2131562424);
    this.p.setImageResource(2130837942);
    this.p.setOnClickListener(new cke(this));
    this.jdField_a_of_type_AndroidWidgetTextView = this.m;
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131562000);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new ckf(this));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131231690));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131231693));
    this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(new ckg(this));
    this.jdField_a_of_type_AndroidWidgetRadioGroup = ((RadioGroup)findViewById(2131231377));
    this.jdField_a_of_type_AndroidWidgetRadioButton = ((RadioButton)findViewById(2131231691));
    this.jdField_b_of_type_AndroidWidgetRadioButton = ((RadioButton)findViewById(2131231692));
    this.jdField_a_of_type_AndroidWidgetRadioButton.setContentDescription(getString(2131562575));
    this.jdField_b_of_type_AndroidWidgetRadioButton.setContentDescription(getString(2131562336));
    this.jdField_a_of_type_AndroidWidgetRadioGroup.setOnCheckedChangeListener(this);
    this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView = ((DragSortListView)findViewById(16908298));
    paramBundle = a(this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView);
    this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.setFloatViewManager(paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.setOnTouchListener(paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.setDragEnabled(false);
    this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.setDelImmediately(false);
    this.jdField_a_of_type_ComTencentMobileqqModelEmoticonManager = ((EmoticonManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(12));
    this.jdField_a_of_type_JavaLangRunnable = new ckh(this);
    paramBundle = getIntent();
    this.h = paramBundle.getIntExtra("extra_launch_mode", 1);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqModelEmoticonManager.b();
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      EmoticonPackage localEmoticonPackage;
      if (this.h == 1)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          localEmoticonPackage = (EmoticonPackage)((Iterator)localObject).next();
          if ((!localEmoticonPackage.epId.equals("100000")) && (1 != localEmoticonPackage.type)) {
            this.jdField_a_of_type_JavaUtilArrayList.add(localEmoticonPackage);
          }
        }
      }
      if (this.h == 2)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          localEmoticonPackage = (EmoticonPackage)((Iterator)localObject).next();
          if ((1 == localEmoticonPackage.type) && (!localEmoticonPackage.epId.equals("100000"))) {
            this.jdField_a_of_type_JavaUtilArrayList.add(localEmoticonPackage);
          }
        }
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortAdapter = new DragSortAdapter(this, this.jdField_a_of_type_JavaUtilArrayList);
    this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortAdapter);
    this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.setDropListener(this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView$DropListener);
    this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.setRemoveListener(this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView$RemoveListener);
    this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.setOnItemClickListener(new cki(this));
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonPackageChangedListener = new ckj(this);
    EmoticonController.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface).a(this.jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonPackageChangedListener);
    this.jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonPackageDownloadListener = new ckk(this);
    EmoticonController.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface).a(this.jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonPackageDownloadListener);
    this.g = paramBundle.getIntExtra("extra_launch_source", 2);
    if (this.g == 2)
    {
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      this.jdField_b_of_type_Boolean = false;
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131562000);
      this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.setDragEnabled(false);
      this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortAdapter.setEditMode(false);
      this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortAdapter.notifyDataSetChanged();
      if (this.h != 1) {
        break label819;
      }
    }
    label819:
    for (int i = 2131231691;; i = 2131231692)
    {
      if (i != this.jdField_a_of_type_AndroidWidgetRadioGroup.getCheckedRadioButtonId()) {
        this.jdField_a_of_type_AndroidWidgetRadioGroup.check(i);
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this);
      ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", "View_mine", 0, 0, "", "", "", "");
      return true;
      if (this.g != 1) {
        break;
      }
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
      this.p.setEnabled(false);
      this.jdField_b_of_type_Boolean = true;
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131561851);
      this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.setDragEnabled(true);
      this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortAdapter.setEditMode(true);
      this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortAdapter.notifyDataSetChanged();
      break;
    }
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    EmoticonController localEmoticonController = EmoticonController.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
    if (localEmoticonController != null)
    {
      localEmoticonController.b(this.jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonPackageChangedListener);
      localEmoticonController.b(this.jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonPackageDownloadListener);
    }
  }
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    if ((paramIntent.getExtras() != null) && (paramIntent.getExtras().getBoolean("back_from_emojimall", false))) {}
  }
  
  protected void doOnPause()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmosmActivity", 2, "emosm activity ..............onPause");
    }
    super.doOnPause();
    b(this.jdField_a_of_type_ComTencentMobileqqAppEmosmObserver);
  }
  
  protected void doOnResume()
  {
    this.jdField_a_of_type_Boolean = false;
    if (QLog.isColorLevel()) {
      QLog.d("EmosmActivity", 2, "emosm activity ..............onResume");
    }
    a(this.jdField_a_of_type_ComTencentMobileqqAppEmosmObserver);
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      ((EmosmHandler)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(11)).a(0, 0);
      i += 1;
    }
    super.doOnResume();
  }
  
  public void finish()
  {
    EmoticonController.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface).b(this.jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonPackageChangedListener);
    EmoticonController.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface).b(this.jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonPackageDownloadListener);
    this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortAdapter.clearCache();
    this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortAdapter.removeUpdateListeners();
    super.finish();
  }
  
  public void onCheckedChanged(RadioGroup paramRadioGroup, int paramInt)
  {
    if (paramInt == 2131231691) {
      this.h = 1;
    }
    for (;;)
    {
      this.jdField_c_of_type_Boolean = false;
      runOnUiThread(this.jdField_a_of_type_JavaLangRunnable);
      return;
      if (paramInt == 2131231692) {
        this.h = 2;
      }
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    }
    if (!NetworkUtil.e(this))
    {
      paramView = new QQToast(this);
      paramView.a(2130837933);
      paramView.c(1500);
      paramView.a(getString(2131559056));
      paramView.b(0);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(getString(2131561933));
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortAdapter.getSelectedPackages();
    this.e = 0;
    this.f = ((List)localObject).size();
    paramView = (EmosmHandler)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(11);
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      paramView.a(Integer.parseInt(((EmoticonPackage)((Iterator)localObject).next()).epId));
      StatisticAssist.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext(), this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), "Delete_ep");
    }
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
  }
  
  protected void onRestart()
  {
    if (QLog.isColorLevel()) {
      QLog.d("", 2, "emosm activity ..............onRestart");
    }
    super.onRestart();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.activity.EmosmActivity
 * JD-Core Version:    0.7.0.1
 */