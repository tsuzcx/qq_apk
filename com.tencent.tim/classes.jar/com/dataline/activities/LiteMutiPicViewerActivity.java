package com.dataline.activities;

import acde;
import acdl;
import acqp;
import acxt;
import agne;
import ahao;
import ahav;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AbsListView.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import aqiw;
import bz;
import ca;
import com.dataline.util.file.DLFileInfo;
import com.dataline.util.widget.AsyncImageView;
import com.dataline.util.widget.WaitTextView;
import com.dataline.util.widget.WaitTextView.a;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mm.vfs.VFSFile;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.DataLineMsgSet;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.fileviewer.FileBrowserActivity;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cu;
import cv;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import wja;

public class LiteMutiPicViewerActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, WaitTextView.a
{
  private TextView D;
  private TextView E;
  private acdl jdField_a_of_type_Acdl = new ca(this);
  private GridView jdField_a_of_type_AndroidWidgetGridView;
  private a jdField_a_of_type_ComDatalineActivitiesLiteMutiPicViewerActivity$a;
  private WaitTextView jdField_a_of_type_ComDatalineUtilWidgetWaitTextView;
  private DataLineMsgSet jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet;
  private ProgressBar b;
  private RelativeLayout h;
  private int mEdgePadding;
  private int mHorizontalSpacing;
  private int mImageHeight;
  private int mImageWidth;
  private int mVerticalSpacing;
  private Button p;
  
  private void aC()
  {
    setTitle(2131695403);
    this.rightViewImg.setVisibility(4);
    this.rightViewText.setVisibility(4);
  }
  
  private int b(Activity paramActivity)
  {
    return paramActivity.getWindowManager().getDefaultDisplay().getWidth();
  }
  
  private void bU()
  {
    this.b.setProgress((int)(this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.getTotalProcess() * 100.0F));
    String str = "(" + this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.getCompletedCount() + "/" + this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.getTotalCount() + ")";
    StringBuilder localStringBuilder = new StringBuilder();
    if (this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.isSendFromLocal()) {}
    for (int i = 2131694158;; i = 2131694118)
    {
      str = getString(i) + str;
      this.E.setText(str);
      return;
    }
  }
  
  private void initConfig()
  {
    Display localDisplay = ((WindowManager)getSystemService("window")).getDefaultDisplay();
    this.mEdgePadding = getResources().getDimensionPixelSize(2131297812);
    this.mHorizontalSpacing = getResources().getDimensionPixelSize(2131297814);
    this.mVerticalSpacing = getResources().getDimensionPixelSize(2131297815);
    this.mImageWidth = ((localDisplay.getWidth() - this.mEdgePadding * 2 - this.mHorizontalSpacing * 2) / 3);
    this.mImageHeight = this.mImageWidth;
  }
  
  private void initUI()
  {
    this.jdField_a_of_type_AndroidWidgetGridView = ((GridView)findViewById(2131373232));
    this.h = ((RelativeLayout)findViewById(2131368843));
    this.D = ((TextView)findViewById(2131368844));
    this.E = ((TextView)findViewById(2131368845));
    this.E.setTextColor(getResources().getColor(2131167304));
    this.b = ((ProgressBar)findViewById(2131368838));
    this.p = ((Button)findViewById(2131368829));
    this.D.setOnClickListener(this);
    this.p.setOnClickListener(this);
    this.jdField_a_of_type_ComDatalineUtilWidgetWaitTextView = new WaitTextView(this);
    this.jdField_a_of_type_ComDatalineUtilWidgetWaitTextView.setRefreshListener(this);
    this.jdField_a_of_type_ComDatalineUtilWidgetWaitTextView.setGravity(17);
    this.jdField_a_of_type_ComDatalineUtilWidgetWaitTextView.setTextColor(getResources().getColor(2131167385));
    this.jdField_a_of_type_ComDatalineUtilWidgetWaitTextView.setTextSize(1, 16.0F);
    this.jdField_a_of_type_ComDatalineUtilWidgetWaitTextView.setPadding(0, 0, 0, wja.dp2px(50.0F, getResources()));
    AbsListView.LayoutParams localLayoutParams = new AbsListView.LayoutParams(b(this), -2);
    this.jdField_a_of_type_ComDatalineUtilWidgetWaitTextView.setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_AndroidWidgetGridView.setNumColumns(3);
    this.jdField_a_of_type_AndroidWidgetGridView.setColumnWidth(this.mImageWidth);
    this.jdField_a_of_type_AndroidWidgetGridView.setVerticalSpacing(this.mVerticalSpacing * 2);
    this.jdField_a_of_type_AndroidWidgetGridView.setHorizontalSpacing(this.mHorizontalSpacing * 2);
    this.jdField_a_of_type_AndroidWidgetGridView.setPadding(this.mEdgePadding, this.jdField_a_of_type_AndroidWidgetGridView.getPaddingTop(), this.mEdgePadding, this.jdField_a_of_type_AndroidWidgetGridView.getPaddingBottom());
    this.jdField_a_of_type_AndroidWidgetGridView.setSelector(new ColorDrawable(0));
    this.jdField_a_of_type_ComDatalineActivitiesLiteMutiPicViewerActivity$a = new a(null);
    this.jdField_a_of_type_AndroidWidgetGridView.setAdapter(this.jdField_a_of_type_ComDatalineActivitiesLiteMutiPicViewerActivity$a);
    resetBottomBar();
  }
  
  private void resetBottomBar()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.isCanReciveOrResend()) && (!this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.hasSendingOrRecving()))
    {
      this.h.setVisibility(0);
      this.D.setVisibility(0);
      this.E.setVisibility(4);
      this.b.setVisibility(4);
      this.p.setVisibility(4);
      if (this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.isSendFromLocal()) {
        this.D.setText(2131694144);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComDatalineActivitiesLiteMutiPicViewerActivity$a.notifyDataSetChanged();
      return;
      this.D.setText(2131694143);
      continue;
      if (this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.hasSendingOrRecving())
      {
        this.h.setVisibility(0);
        this.D.setVisibility(4);
        this.E.setVisibility(0);
        this.b.setVisibility(0);
        this.p.setVisibility(0);
        bU();
      }
      else
      {
        this.h.setVisibility(8);
      }
    }
  }
  
  private void resetUI()
  {
    this.jdField_a_of_type_ComDatalineUtilWidgetWaitTextView.setText(String.format(getString(2131695419), new Object[] { Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.getTotalCount()) }));
  }
  
  public void bV()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet != null) && (this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.isTimeOut()) && (this.jdField_a_of_type_ComDatalineActivitiesLiteMutiPicViewerActivity$a != null)) {
      this.jdField_a_of_type_ComDatalineActivitiesLiteMutiPicViewerActivity$a.notifyDataSetChanged();
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2131560995);
    int i = getIntent().getIntExtra("dataline_group_id", -1);
    this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet = this.app.a(0).a(i);
    if (this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet == null) {
      this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet = this.app.a(1).a(i);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet == null)
    {
      QLog.e("IphoneTitleBarActivity", 1, "LiteMutiPicViewerActivity mSet is null, so finish");
      finish();
    }
    addObserver(this.jdField_a_of_type_Acdl);
    initConfig();
    initUI();
    aC();
    resetUI();
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.jdField_a_of_type_Acdl != null) {
      removeObserver(this.jdField_a_of_type_Acdl);
    }
    if (this.app.a() != null) {
      this.app.a().diq();
    }
    if (this.jdField_a_of_type_ComDatalineUtilWidgetWaitTextView != null) {
      this.jdField_a_of_type_ComDatalineUtilWidgetWaitTextView.co();
    }
  }
  
  public void onClick(View paramView)
  {
    Object localObject1 = null;
    acde localacde = (acde)this.app.getBusinessHandler(8);
    Object localObject2;
    Object localObject3;
    switch (paramView.getId())
    {
    default: 
    case 2131368844: 
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        if (aqiw.isNetSupport(this))
        {
          ahav.b(this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.isSendFromLocal(), this, new bz(this, localacde));
          this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.setPaused(false);
          if ((this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.getGroupType() == -2000) && (!this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.isSingle())) {
            cu.p(this.app);
          }
          Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.values().iterator();
          localObject2 = null;
          while (localIterator.hasNext())
          {
            DataLineMsgRecord localDataLineMsgRecord = (DataLineMsgRecord)localIterator.next();
            DLFileInfo localDLFileInfo = cv.a(localDataLineMsgRecord);
            if (localDLFileInfo.state == 1)
            {
              localObject3 = localObject2;
              if (localObject2 == null) {
                localObject3 = new ArrayList();
              }
              ((ArrayList)localObject3).add(localDataLineMsgRecord);
              localObject2 = localObject3;
            }
            else
            {
              if (localDLFileInfo.state != 4)
              {
                localObject3 = localObject1;
                if (localDLFileInfo.state != 2) {}
              }
              else if ((localDataLineMsgRecord.fileMsgStatus == 1L) && (localDataLineMsgRecord.strMoloKey != null))
              {
                if (!DataLineMsgSet.isSingle(localDataLineMsgRecord)) {
                  break label334;
                }
                cu.d(this.app);
              }
              for (;;)
              {
                localObject3 = localObject1;
                if (localObject1 == null) {
                  localObject3 = new ArrayList();
                }
                ((List)localObject3).add(Long.valueOf(localDataLineMsgRecord.sessionid));
                int i = DataLineMsgRecord.getDevTypeBySeId(localDataLineMsgRecord.sessionid);
                localDataLineMsgRecord.fileMsgStatus = 0L;
                this.app.b().a(i).ig(localDataLineMsgRecord.msgId);
                localObject1 = localObject3;
                break;
                label334:
                cu.e(this.app);
              }
            }
          }
          if ((localObject2 != null) && (((ArrayList)localObject2).size() > 0)) {
            localacde.z((ArrayList)localObject2, true);
          }
          if ((localObject1 != null) && (((List)localObject1).size() > 0)) {
            localacde.af((List)localObject1);
          }
          resetBottomBar();
        }
        else
        {
          ahao.OS(2131696348);
        }
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.setPaused(true);
    if ((this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.getGroupType() == -2000) && (!this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.isSingle())) {
      cu.o(this.app);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.getGroupType() == -2335) && (!this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.isReportPause))
    {
      this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.isReportPause = true;
      if (!this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.isSingle()) {
        cu.m(this.app);
      }
    }
    else
    {
      label487:
      if ((this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.isSingle()) || (this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.getGroupType() == -2335)) {
        break label541;
      }
      localacde.g(this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.getGroupId(), 0L, false);
    }
    for (;;)
    {
      resetBottomBar();
      break;
      cu.k(this.app);
      break label487;
      label541:
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.values().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (DataLineMsgRecord)((Iterator)localObject1).next();
        localObject3 = cv.a((DataLineMsgRecord)localObject2);
        if ((((DLFileInfo)localObject3).state == 0) || (((DLFileInfo)localObject3).state == 3)) {
          localacde.g(((DataLineMsgRecord)localObject2).groupId, ((DataLineMsgRecord)localObject2).sessionid, false);
        }
      }
    }
  }
  
  class a
    extends BaseAdapter
    implements View.OnClickListener
  {
    private LayoutInflater mInflater = LayoutInflater.from(LiteMutiPicViewerActivity.this);
    
    private a() {}
    
    public int getCount()
    {
      int j = LiteMutiPicViewerActivity.a(LiteMutiPicViewerActivity.this).getTotalCount();
      int k = j % 3;
      int i = j;
      if (k != 0) {
        i = j + (3 - k);
      }
      return i + 1;
    }
    
    public Object getItem(int paramInt)
    {
      if (paramInt > LiteMutiPicViewerActivity.a(LiteMutiPicViewerActivity.this).getTotalCount() - 1) {
        return null;
      }
      return LiteMutiPicViewerActivity.a(LiteMutiPicViewerActivity.this).getAt(paramInt);
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public int getItemViewType(int paramInt)
    {
      if (paramInt == getCount() - 1) {
        return 0;
      }
      if (paramInt > LiteMutiPicViewerActivity.a(LiteMutiPicViewerActivity.this).getTotalCount() - 1) {
        return 1;
      }
      return 2;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      Object localObject2;
      Object localObject1;
      if (paramInt == getCount() - 1) {
        if ((LiteMutiPicViewerActivity.a(LiteMutiPicViewerActivity.this).getComeCount() == LiteMutiPicViewerActivity.a(LiteMutiPicViewerActivity.this).getTotalCount()) || (LiteMutiPicViewerActivity.a(LiteMutiPicViewerActivity.this).isSendFromLocal()) || (LiteMutiPicViewerActivity.a(LiteMutiPicViewerActivity.this).hasSendingOrRecving()))
        {
          LiteMutiPicViewerActivity.a(LiteMutiPicViewerActivity.this).setWaitText(String.format(LiteMutiPicViewerActivity.this.getString(2131695419), new Object[] { Integer.valueOf(LiteMutiPicViewerActivity.a(LiteMutiPicViewerActivity.this).getTotalCount()) }));
          LiteMutiPicViewerActivity.a(LiteMutiPicViewerActivity.this).co();
          localObject2 = LiteMutiPicViewerActivity.a(LiteMutiPicViewerActivity.this);
          localObject1 = paramView;
        }
      }
      for (paramView = (View)localObject2;; paramView = (View)localObject2)
      {
        EventCollector.getInstance().onListGetView(paramInt, (View)localObject1, paramViewGroup, getItemId(paramInt));
        return paramView;
        if (!LiteMutiPicViewerActivity.a(LiteMutiPicViewerActivity.this).isTimeOut())
        {
          i = LiteMutiPicViewerActivity.a(LiteMutiPicViewerActivity.this).getComeCount();
          j = LiteMutiPicViewerActivity.a(LiteMutiPicViewerActivity.this).getTotalCount();
          localObject1 = String.format(LiteMutiPicViewerActivity.this.app.getApp().getString(2131695416), new Object[] { Integer.valueOf(j), Integer.valueOf(j - i) });
          LiteMutiPicViewerActivity.a(LiteMutiPicViewerActivity.this).setWaitText((String)localObject1);
          LiteMutiPicViewerActivity.a(LiteMutiPicViewerActivity.this).cn();
          break;
        }
        LiteMutiPicViewerActivity.a(LiteMutiPicViewerActivity.this).co();
        int i = LiteMutiPicViewerActivity.a(LiteMutiPicViewerActivity.this).getComeCount();
        int j = LiteMutiPicViewerActivity.a(LiteMutiPicViewerActivity.this).getTotalCount();
        localObject1 = String.format(LiteMutiPicViewerActivity.this.app.getApp().getString(2131695414), new Object[] { Integer.valueOf(j), Integer.valueOf(j - i) });
        LiteMutiPicViewerActivity.a(LiteMutiPicViewerActivity.this).setWaitText((String)localObject1);
        break;
        if (paramInt <= LiteMutiPicViewerActivity.a(LiteMutiPicViewerActivity.this).getTotalCount() - 1) {
          break label445;
        }
        localObject2 = paramView;
        if (paramView == null)
        {
          localObject2 = new View(LiteMutiPicViewerActivity.this);
          ((View)localObject2).setLayoutParams(new AbsListView.LayoutParams(LiteMutiPicViewerActivity.a(LiteMutiPicViewerActivity.this), LiteMutiPicViewerActivity.b(LiteMutiPicViewerActivity.this)));
          ((View)localObject2).setPadding(LiteMutiPicViewerActivity.c(LiteMutiPicViewerActivity.this), LiteMutiPicViewerActivity.c(LiteMutiPicViewerActivity.this), LiteMutiPicViewerActivity.c(LiteMutiPicViewerActivity.this), LiteMutiPicViewerActivity.c(LiteMutiPicViewerActivity.this));
        }
        localObject1 = localObject2;
      }
      label445:
      if (paramView == null)
      {
        localObject1 = new LiteMutiPicViewerActivity.b(LiteMutiPicViewerActivity.this);
        paramView = this.mInflater.inflate(2131560994, null);
        ((LiteMutiPicViewerActivity.b)localObject1).i = ((RelativeLayout)paramView.findViewById(2131368134));
        ((LiteMutiPicViewerActivity.b)localObject1).A = paramView.findViewById(2131368838);
        ((LiteMutiPicViewerActivity.b)localObject1).v = ((ImageView)paramView.findViewById(2131361801));
        ((LiteMutiPicViewerActivity.b)localObject1).a = ((AsyncImageView)paramView.findViewById(2131368820));
        ((LiteMutiPicViewerActivity.b)localObject1).a.setLayoutParams(new RelativeLayout.LayoutParams(LiteMutiPicViewerActivity.a(LiteMutiPicViewerActivity.this), LiteMutiPicViewerActivity.b(LiteMutiPicViewerActivity.this)));
        ((LiteMutiPicViewerActivity.b)localObject1).a.setAdjustViewBounds(false);
        ((LiteMutiPicViewerActivity.b)localObject1).a.setScaleType(ImageView.ScaleType.CENTER_CROP);
        ((LiteMutiPicViewerActivity.b)localObject1).a.setDefaultColorDrawable(Color.parseColor("#C8C8C8"));
        ((LiteMutiPicViewerActivity.b)localObject1).a.setIsDrawRound(false);
        ((LiteMutiPicViewerActivity.b)localObject1).a.setAsyncClipSize(LiteMutiPicViewerActivity.a(LiteMutiPicViewerActivity.this), LiteMutiPicViewerActivity.b(LiteMutiPicViewerActivity.this));
        ((LiteMutiPicViewerActivity.b)localObject1).i.setOnClickListener(this);
        ((LiteMutiPicViewerActivity.b)localObject1).i.setTag(localObject1);
        paramView.setTag(localObject1);
        localObject2 = LiteMutiPicViewerActivity.a(LiteMutiPicViewerActivity.this).getAt(paramInt);
        ((LiteMutiPicViewerActivity.b)localObject1).c = ((DataLineMsgRecord)localObject2);
        if (localObject2 != null) {
          break label731;
        }
      }
      label644:
      label731:
      while (((DataLineMsgRecord)localObject2).fileMsgStatus == 1L)
      {
        localObject2 = new ColorDrawable(Color.parseColor("#C8C8C8"));
        ((LiteMutiPicViewerActivity.b)localObject1).a.setImageDrawable((Drawable)localObject2);
        ((LiteMutiPicViewerActivity.b)localObject1).A.setVisibility(8);
        ((LiteMutiPicViewerActivity.b)localObject1).v.setVisibility(8);
        localObject1 = paramView;
        break;
        localObject1 = (LiteMutiPicViewerActivity.b)paramView.getTag();
        break label644;
      }
      if ((((DataLineMsgRecord)localObject2).path != null) && (new VFSFile(((DataLineMsgRecord)localObject2).path).exists()))
      {
        ((LiteMutiPicViewerActivity.b)localObject1).a.setAsyncImage(((DataLineMsgRecord)localObject2).path);
        label780:
        if ((LiteMutiPicViewerActivity.a(LiteMutiPicViewerActivity.this).hasSendingOrRecving()) || ((((DataLineMsgRecord)localObject2).issuc) && (((DataLineMsgRecord)localObject2).fileMsgStatus == 0L))) {
          break label859;
        }
        ((LiteMutiPicViewerActivity.b)localObject1).A.setVisibility(0);
        ((LiteMutiPicViewerActivity.b)localObject1).v.setVisibility(0);
      }
      for (;;)
      {
        localObject1 = paramView;
        break;
        if (((DataLineMsgRecord)localObject2).thumbPath == null) {
          break label780;
        }
        ((LiteMutiPicViewerActivity.b)localObject1).a.setAsyncImage(((DataLineMsgRecord)localObject2).thumbPath);
        break label780;
        label859:
        ((LiteMutiPicViewerActivity.b)localObject1).A.setVisibility(8);
        ((LiteMutiPicViewerActivity.b)localObject1).v.setVisibility(8);
      }
    }
    
    public int getViewTypeCount()
    {
      return 3;
    }
    
    public void onClick(View paramView)
    {
      DataLineMsgRecord localDataLineMsgRecord1 = ((LiteMutiPicViewerActivity.b)paramView.getTag()).c;
      if (localDataLineMsgRecord1 == null) {}
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        FileManagerEntity localFileManagerEntity = ahav.a(localDataLineMsgRecord1);
        ForwardFileInfo localForwardFileInfo = new ForwardFileInfo();
        localForwardFileInfo.setType(10009);
        localForwardFileInfo.Oj(6);
        localForwardFileInfo.p(localFileManagerEntity.nSessionId);
        localForwardFileInfo.setFileName(localDataLineMsgRecord1.filename);
        localForwardFileInfo.jB(localDataLineMsgRecord1.sessionid);
        localForwardFileInfo.setFileSize(localDataLineMsgRecord1.filesize);
        localForwardFileInfo.setLocalPath(localDataLineMsgRecord1.path);
        Intent localIntent = new Intent(LiteMutiPicViewerActivity.this, FileBrowserActivity.class);
        if (localFileManagerEntity.nFileType == 0)
        {
          int i = DataLineMsgRecord.getDevTypeBySeId(localDataLineMsgRecord1.sessionid);
          Object localObject = LiteMutiPicViewerActivity.this.app.a(i).b(localDataLineMsgRecord1.sessionid);
          if (localObject != null)
          {
            ArrayList localArrayList = new ArrayList();
            localObject = ((DataLineMsgSet)localObject).values().iterator();
            while (((Iterator)localObject).hasNext())
            {
              DataLineMsgRecord localDataLineMsgRecord2 = (DataLineMsgRecord)((Iterator)localObject).next();
              if ((localDataLineMsgRecord2.msgtype == -2000) || ((localDataLineMsgRecord2.msgtype == -2005) && (ahav.getFileType(localDataLineMsgRecord2.filename) == 0)) || ((localDataLineMsgRecord2.msgtype == -2335) && (localDataLineMsgRecord2.bIsMoloImage))) {
                if (localDataLineMsgRecord2 == localDataLineMsgRecord1) {
                  localArrayList.add(String.valueOf(localFileManagerEntity.nSessionId));
                } else {
                  localArrayList.add(String.valueOf(ahav.a(localDataLineMsgRecord2).nSessionId));
                }
              }
            }
            localIntent.putStringArrayListExtra("Aio_SessionId_ImageList", localArrayList);
          }
        }
        else
        {
          localIntent.putExtra("fileinfo", localForwardFileInfo);
          LiteMutiPicViewerActivity.this.startActivity(localIntent);
        }
      }
    }
  }
  
  public class b
  {
    public View A;
    public AsyncImageView a;
    public DataLineMsgRecord c;
    public RelativeLayout i;
    public ImageView v;
    
    public b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.dataline.activities.LiteMutiPicViewerActivity
 * JD-Core Version:    0.7.0.1
 */