package com.dataline.activities;

import acbn;
import acde;
import acdl;
import acxt;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Window;
import android.widget.TextView;
import com.dataline.util.file.DLFileInfo;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.DataLineMsgSet;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.widget.XListView;
import cv;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;
import v;
import x;

public class DLFilesViewerActivity
  extends IphoneTitleBarActivity
  implements Observer
{
  public static String TAG = "DLFilesViewerActivity";
  private acdl jdField_a_of_type_Acdl = new x(this);
  private DataLineMsgSet jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet;
  private cv jdField_a_of_type_Cv;
  private XListView mListView;
  
  private void aB()
  {
    Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.values().iterator();
    int i = 1;
    int j = 0;
    DataLineMsgRecord localDataLineMsgRecord;
    DLFileInfo localDLFileInfo;
    if (localIterator.hasNext())
    {
      localDataLineMsgRecord = (DataLineMsgRecord)localIterator.next();
      localDLFileInfo = cv.a(localDataLineMsgRecord);
      if (((localDLFileInfo.state != 0) && (localDLFileInfo.state != 3)) || (j != 0)) {
        break label217;
      }
      j = 1;
    }
    label128:
    label151:
    label214:
    label217:
    for (;;)
    {
      int k;
      if ((localDLFileInfo.state == 5) && (localDataLineMsgRecord.strMoloKey != null))
      {
        acde localacde = (acde)this.app.getBusinessHandler(8);
        if (!localDataLineMsgRecord.bIsApkFile) {
          break label151;
        }
        if (localacde.isInstalled(localDataLineMsgRecord.strMoloKey))
        {
          k = 1;
          label122:
          localDataLineMsgRecord.nAppStatus = k;
        }
      }
      else
      {
        if ((localDLFileInfo.state == 5) || (i == 0)) {
          break label214;
        }
        i = 0;
      }
      for (;;)
      {
        break;
        k = 0;
        break label122;
        localDataLineMsgRecord.nAppStatus = 1;
        break label128;
        if (i == 0)
        {
          this.rightViewText.setVisibility(0);
          if (j != 0)
          {
            this.rightViewText.setText(getString(2131695383));
            return;
          }
          this.rightViewText.setText(getString(2131695382));
          return;
        }
        this.rightViewText.setVisibility(8);
        return;
      }
    }
  }
  
  private void aC()
  {
    DataLineMsgRecord localDataLineMsgRecord = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.getFirstItem();
    if ((this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.getGroupType() == -2335) && (localDataLineMsgRecord.bIsApkFile)) {
      setTitle(2131695384);
    }
    for (;;)
    {
      this.leftView.setVisibility(0);
      this.leftView.setText(getString(2131695446));
      aB();
      this.rightViewText.setOnClickListener(new v(this));
      return;
      setTitle(2131695401);
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    int i = getIntent().getIntExtra("dl_files_groupid", 0);
    this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet = this.app.a().a(0).a(i);
    if (this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet == null) {
      this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet = this.app.a().a(1).a(i);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet == null)
    {
      finish();
      return false;
    }
    getWindow().setBackgroundDrawableResource(2131165572);
    setContentView(2131559179);
    getWindow().setBackgroundDrawable(null);
    aC();
    findViewById(2131367073);
    this.mListView = ((XListView)findViewById(2131367072));
    this.mListView.setStackFromBottom(true);
    this.jdField_a_of_type_Cv = new cv(this, this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet, this, this.app);
    this.mListView.setAdapter(this.jdField_a_of_type_Cv);
    paramBundle = LayoutInflater.from(getActivity()).inflate(2131559032, null);
    this.mListView.setOverscrollHeader(getActivity().getResources().getDrawable(2130845711));
    this.mListView.setOverScrollHeader(paramBundle);
    addObserver(this.jdField_a_of_type_Acdl);
    paramBundle = this.app.b();
    if (paramBundle != null) {
      paramBundle.addObserver(this);
    }
    this.mListView.setSelection(this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.getTotalCount() - 1);
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.jdField_a_of_type_Acdl != null) {
      removeObserver(this.jdField_a_of_type_Acdl);
    }
    if (this.app.b() != null) {
      this.app.b().deleteObserver(this);
    }
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    aB();
    this.jdField_a_of_type_Cv.notifyDataSetChanged();
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if ((paramObject instanceof DataLineMsgRecord))
    {
      this.jdField_a_of_type_Cv.notifyDataSetChanged();
      aB();
    }
    do
    {
      do
      {
        return;
        if (!(paramObject instanceof QQMessageFacade.Message)) {
          break;
        }
      } while (!((QQMessageFacade.Message)paramObject).frienduin.endsWith(String.valueOf(acbn.bkw)));
      this.jdField_a_of_type_Cv.notifyDataSetChanged();
      aB();
      return;
    } while ((!(paramObject instanceof RecentUser)) || (!((RecentUser)paramObject).uin.endsWith(String.valueOf(acbn.bkw))));
    this.jdField_a_of_type_Cv.notifyDataSetChanged();
    aB();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.dataline.activities.DLFilesViewerActivity
 * JD-Core Version:    0.7.0.1
 */