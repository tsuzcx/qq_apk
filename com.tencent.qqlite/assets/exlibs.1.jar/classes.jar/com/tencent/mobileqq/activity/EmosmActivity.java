package com.tencent.mobileqq.activity;

import alb;
import alc;
import ald;
import ale;
import alf;
import alg;
import alh;
import ali;
import alj;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;
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
import com.tencent.mobileqq.emoticon.EmojiListenerManager;
import com.tencent.mobileqq.emoticon.EmojiManager;
import com.tencent.mobileqq.emoticon.EmoticonPackageChangedListener;
import com.tencent.mobileqq.emoticon.EmoticonPackageDownloadListener;
import com.tencent.mobileqq.model.EmoticonManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EmosmActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, RadioGroup.OnCheckedChangeListener
{
  public static final String a = "extra_launch_source";
  public static final String b = "extra_launch_mode";
  public static final int c = 1;
  private static final String jdField_c_of_type_JavaLangString = "EmosmActivity";
  public static final int d = 2;
  public static final int e = 1;
  public static final int f = 2;
  public int a;
  public Button a;
  private RadioButton jdField_a_of_type_AndroidWidgetRadioButton;
  private RadioGroup jdField_a_of_type_AndroidWidgetRadioGroup;
  public TextView a;
  private EmosmObserver jdField_a_of_type_ComTencentMobileqqAppEmosmObserver = new alb(this);
  public DragSortAdapter a;
  private DragSortListView.DropListener jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView$DropListener = new ali(this);
  private DragSortListView.RemoveListener jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView$RemoveListener = new alj(this);
  public DragSortListView a;
  private EmoticonPackageChangedListener jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonPackageChangedListener;
  private EmoticonPackageDownloadListener jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonPackageDownloadListener;
  public EmoticonManager a;
  public QQProgressDialog a;
  public Runnable a;
  public WeakReference a;
  public ArrayList a;
  public boolean a;
  public int b;
  private RadioButton jdField_b_of_type_AndroidWidgetRadioButton;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  public boolean b;
  TextView jdField_c_of_type_AndroidWidgetTextView;
  public boolean c;
  private int g;
  private int h;
  
  public EmosmActivity()
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(this);
  }
  
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
      ReportController.b(this.app, "CliOper", "", "", "qface_emoji", "delete_qfpkg", 0, 0, paramEmoticonPackage.kinId, "", "", "");
    }
  }
  
  private void c()
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
          if ((!localEmoticonPackage.epId.equals("100000")) && (3 != localEmoticonPackage.jobType) && (1 != localEmoticonPackage.jobType)) {
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
    paramDragSortListView.setDragHandleId(2131296286);
    paramDragSortListView.setClickRemoveId(2131296287);
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
    super.setContentView(2130903196);
    super.d(2130837635);
    super.setTitle(2131364024);
    this.jdField_a_of_type_AndroidWidgetTextView = this.j;
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131364025);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new alc(this));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131297111));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131297115));
    this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(new ald(this));
    this.jdField_a_of_type_AndroidWidgetRadioGroup = ((RadioGroup)super.findViewById(2131297112));
    this.jdField_a_of_type_AndroidWidgetRadioButton = ((RadioButton)super.findViewById(2131297113));
    this.jdField_b_of_type_AndroidWidgetRadioButton = ((RadioButton)super.findViewById(2131297114));
    this.jdField_a_of_type_AndroidWidgetRadioButton.setContentDescription(getString(2131364077));
    this.jdField_b_of_type_AndroidWidgetRadioButton.setContentDescription(getString(2131364078));
    this.jdField_a_of_type_AndroidWidgetRadioGroup.setOnCheckedChangeListener(this);
    this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView = ((DragSortListView)super.findViewById(16908298));
    paramBundle = a(this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView);
    this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.setFloatViewManager(paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.setOnTouchListener(paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.setDragEnabled(false);
    this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.setDelImmediately(false);
    this.jdField_a_of_type_ComTencentMobileqqModelEmoticonManager = ((EmoticonManager)this.app.getManager(13));
    this.jdField_a_of_type_JavaLangRunnable = new ale(this);
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
          if ((!localEmoticonPackage.epId.equals("100000")) && (1 != localEmoticonPackage.type) && (1 != localEmoticonPackage.jobType)) {
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
    this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.setOnItemClickListener(new alf(this));
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonPackageChangedListener = new alg(this);
    localObject = (EmojiManager)this.app.getManager(39);
    ((EmojiManager)localObject).a.a(this.jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonPackageChangedListener);
    this.jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonPackageDownloadListener = new alh(this);
    ((EmojiManager)localObject).a.a(this.jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonPackageDownloadListener);
    this.g = paramBundle.getIntExtra("extra_launch_source", 2);
    if ((this.g == 2) || (this.g == 1))
    {
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      this.jdField_b_of_type_Boolean = false;
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131364025);
      this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.setDragEnabled(false);
      this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortAdapter.setEditMode(false);
      this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortAdapter.notifyDataSetChanged();
    }
    if (this.h == 1) {}
    for (int i = 2131297113;; i = 2131297114)
    {
      if (i != this.jdField_a_of_type_AndroidWidgetRadioGroup.getCheckedRadioButtonId()) {
        this.jdField_a_of_type_AndroidWidgetRadioGroup.check(i);
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this);
      ReportController.b(this.app, "CliOper", "", "", "ep_mall", "View_mine", 0, 0, "", "", "", "");
      return true;
    }
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    EmojiManager localEmojiManager = (EmojiManager)this.app.getManager(39);
    localEmojiManager.a.b(this.jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonPackageChangedListener);
    localEmojiManager.a.b(this.jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonPackageDownloadListener);
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
    super.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppEmosmObserver);
  }
  
  protected void doOnResume()
  {
    this.jdField_a_of_type_Boolean = false;
    if (QLog.isColorLevel()) {
      QLog.d("EmosmActivity", 2, "emosm activity ..............onResume");
    }
    super.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppEmosmObserver);
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      ((EmosmHandler)this.app.a(11)).a(0, 0);
      i += 1;
    }
    super.doOnResume();
  }
  
  public void finish()
  {
    EmojiManager localEmojiManager = (EmojiManager)this.app.getManager(39);
    localEmojiManager.a.b(this.jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonPackageChangedListener);
    localEmojiManager.a.b(this.jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonPackageDownloadListener);
    this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortAdapter.clearCache();
    this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortAdapter.removeUpdateListeners();
    this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortAdapter.removeDownloadListeners();
    super.finish();
  }
  
  public void onCheckedChanged(RadioGroup paramRadioGroup, int paramInt)
  {
    if (paramInt == 2131297113) {
      this.h = 1;
    }
    for (;;)
    {
      this.jdField_c_of_type_Boolean = false;
      super.runOnUiThread(this.jdField_a_of_type_JavaLangRunnable);
      return;
      if (paramInt == 2131297114) {
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
      paramView.a(2130837962);
      paramView.c(1500);
      paramView.a("无网络连接，删除失败");
      paramView.b(0);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(getString(2131364040));
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortAdapter.getSelectedPackages();
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = ((List)localObject).size();
    paramView = (EmosmHandler)this.app.a(11);
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      paramView.a(Integer.parseInt(((EmoticonPackage)((Iterator)localObject).next()).epId));
      ReportController.b(this.app, "CliOper", "", "", "EmosSetting", "EpDelete", 0, 0, "", "", "", "");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.EmosmActivity
 * JD-Core Version:    0.7.0.1
 */