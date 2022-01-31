package com.dataline.activities;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.dataline.util.DatalineFilesAdapter;
import com.dataline.util.file.DLFileInfo;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.DataLineObserver;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.app.proxy.DataLineMsgProxy;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.DataLineMsgSet;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;
import v;
import y;

public class DLFilesViewerActivity
  extends IphoneTitleBarActivity
  implements Observer
{
  public static final int a = 0;
  public static String a;
  public static final int b = 1;
  public static final String b = "dl_files_groupid";
  public static final int c = 2;
  public static final int d = 3;
  private View jdField_a_of_type_AndroidViewView;
  private DatalineFilesAdapter jdField_a_of_type_ComDatalineUtilDatalineFilesAdapter = null;
  private DataLineObserver jdField_a_of_type_ComTencentMobileqqAppDataLineObserver = new y(this);
  private DataLineMsgSet jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet = null;
  private XListView jdField_a_of_type_ComTencentWidgetXListView;
  
  static
  {
    jdField_a_of_type_JavaLangString = "DLFilesViewerActivity";
  }
  
  private void d()
  {
    Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.values().iterator();
    int i = 1;
    int j = 0;
    DataLineMsgRecord localDataLineMsgRecord;
    DLFileInfo localDLFileInfo;
    if (localIterator.hasNext())
    {
      localDataLineMsgRecord = (DataLineMsgRecord)localIterator.next();
      localDLFileInfo = DatalineFilesAdapter.a(localDataLineMsgRecord);
      if (((localDLFileInfo.a != DLBaseFileViewActivity.DLFileState.SENDING) && (localDLFileInfo.a != DLBaseFileViewActivity.DLFileState.RECVING)) || (j != 0)) {
        break label226;
      }
      j = 1;
    }
    label129:
    label135:
    label160:
    label223:
    label226:
    for (;;)
    {
      int k;
      if ((localDLFileInfo.a == DLBaseFileViewActivity.DLFileState.DONE) && (localDataLineMsgRecord.strMoloKey != null))
      {
        DataLineHandler localDataLineHandler = (DataLineHandler)this.b.a(8);
        if (!localDataLineMsgRecord.bIsApkFile) {
          break label160;
        }
        if (localDataLineHandler.a(localDataLineMsgRecord.strMoloKey))
        {
          k = 1;
          localDataLineMsgRecord.nAppStatus = k;
        }
      }
      else
      {
        if ((localDLFileInfo.a == DLBaseFileViewActivity.DLFileState.DONE) || (i == 0)) {
          break label223;
        }
        i = 0;
      }
      for (;;)
      {
        break;
        k = 0;
        break label129;
        localDataLineMsgRecord.nAppStatus = 1;
        break label135;
        if (i == 0)
        {
          this.m.setVisibility(0);
          if (j != 0)
          {
            this.m.setText(getString(2131558559));
            return;
          }
          this.m.setText(getString(2131558558));
          return;
        }
        this.m.setVisibility(8);
        return;
      }
    }
  }
  
  private void e()
  {
    DataLineMsgRecord localDataLineMsgRecord = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.getFirstItem();
    if ((this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.getGroupType() == -2335) && (localDataLineMsgRecord.bIsApkFile)) {
      setTitle(2131558564);
    }
    for (;;)
    {
      this.k.setVisibility(0);
      this.k.setText(getString(2131558496));
      d();
      this.m.setOnClickListener(new v(this));
      return;
      setTitle(2131558563);
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    int i = getIntent().getIntExtra("dl_files_groupid", 0);
    this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet = this.b.a().a().a(i);
    getWindow().setBackgroundDrawableResource(2131361810);
    setContentView(2130903179);
    getWindow().setBackgroundDrawable(null);
    e();
    this.jdField_a_of_type_AndroidViewView = ((LinearLayout)findViewById(2131231514));
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131231515));
    this.jdField_a_of_type_ComTencentWidgetXListView.setStackFromBottom(true);
    this.jdField_a_of_type_ComDatalineUtilDatalineFilesAdapter = new DatalineFilesAdapter(this, this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet, this, this.b);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComDatalineUtilDatalineFilesAdapter);
    paramBundle = LayoutInflater.from(a()).inflate(2130903136, null);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOverscrollHeader(a().getResources().getDrawable(2130838675));
    this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollHeader(paramBundle);
    a(this.jdField_a_of_type_ComTencentMobileqqAppDataLineObserver);
    paramBundle = this.b.a();
    if (paramBundle != null) {
      paramBundle.addObserver(this);
    }
    this.jdField_a_of_type_ComTencentWidgetXListView.setSelection(this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.getTotalCount() - 1);
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.jdField_a_of_type_ComTencentMobileqqAppDataLineObserver != null) {
      b(this.jdField_a_of_type_ComTencentMobileqqAppDataLineObserver);
    }
    if (this.b.a() != null) {
      this.b.a().deleteObserver(this);
    }
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    d();
    this.jdField_a_of_type_ComDatalineUtilDatalineFilesAdapter.notifyDataSetChanged();
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if ((paramObject instanceof DataLineMsgRecord))
    {
      this.jdField_a_of_type_ComDatalineUtilDatalineFilesAdapter.notifyDataSetChanged();
      d();
    }
    do
    {
      do
      {
        return;
        if (!(paramObject instanceof QQMessageFacade.Message)) {
          break;
        }
      } while (!((QQMessageFacade.Message)paramObject).frienduin.endsWith(String.valueOf(AppConstants.P)));
      this.jdField_a_of_type_ComDatalineUtilDatalineFilesAdapter.notifyDataSetChanged();
      d();
      return;
    } while ((!(paramObject instanceof RecentUser)) || (!((RecentUser)paramObject).uin.endsWith(String.valueOf(AppConstants.P))));
    this.jdField_a_of_type_ComDatalineUtilDatalineFilesAdapter.notifyDataSetChanged();
    d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.dataline.activities.DLFilesViewerActivity
 * JD-Core Version:    0.7.0.1
 */