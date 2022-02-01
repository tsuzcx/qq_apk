package com.tencent.tim.cloudfile.feeds;

import aaiy;
import aaja;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import ateh;
import atgc;
import aths;
import aths.a;
import athu;
import atik;
import atik.a;
import atin;
import ativ;
import atiz;
import atjx;
import atle;
import atlg;
import atlh;
import atli;
import atlj;
import atlk;
import atll;
import atlm;
import atlo;
import auds;
import aueh;
import augx;
import auhh;
import auhk.g;
import auhw;
import aulh;
import aull;
import aulm;
import aurf;
import auuw.b;
import com.tencent.cloudfile.CloudFile;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tim.filemanager.widget.CloudSendBottomBar;
import com.tencent.tim.teamwork.PadInfo;
import com.tencent.tim.widget.PullRefreshHeader;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.e;
import com.tencent.widget.PinnedDividerSwipListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class CloudFeedListActivity
  extends IphoneTitleBarActivity
  implements Handler.Callback, View.OnClickListener, augx, auhk.g, AbsListView.e
{
  private aaiy jdField_a_of_type_Aaiy;
  aths.a jdField_a_of_type_Aths$a = new atll(this);
  atik.a jdField_a_of_type_Atik$a = new atlk(this);
  private ativ jdField_a_of_type_Ativ;
  private atjx jdField_a_of_type_Atjx;
  private atle jdField_a_of_type_Atle;
  private auhh jdField_a_of_type_Auhh;
  private auhw jdField_a_of_type_Auhw;
  private aulh jdField_a_of_type_Aulh;
  private aull jdField_a_of_type_Aull;
  private auuw.b jdField_a_of_type_Auuw$b = new atlj(this);
  private CloudSendBottomBar jdField_a_of_type_ComTencentTimFilemanagerWidgetCloudSendBottomBar;
  private aaja jdField_b_of_type_Aaja;
  private atlo jdField_b_of_type_Atlo;
  aulm jdField_b_of_type_Aulm = new atlm(this);
  private PullRefreshHeader jdField_b_of_type_ComTencentTimWidgetPullRefreshHeader;
  private PinnedDividerSwipListView c;
  private boolean dhZ;
  private boolean dhv;
  private int epA;
  private int epB;
  private int epC;
  RelativeLayout fD;
  private List<Object> mFeedList = new ArrayList();
  private View mLoadingView;
  private View mRoot;
  public final MqqHandler uiHandler = new aurf(Looper.getMainLooper(), this, true);
  
  private void etT()
  {
    Message localMessage = this.uiHandler.obtainMessage(113);
    localMessage.obj = this.jdField_a_of_type_Auhw.hk();
    this.uiHandler.sendMessage(localMessage);
  }
  
  private void ie()
  {
    this.dhZ = getIntent().getExtras().getBoolean("key_is_from_aio_cloud_selector", false);
    this.epA = getIntent().getIntExtra("key_file_browser_mode", 0);
    if (this.epA == 2)
    {
      this.jdField_a_of_type_Atle.Vq(true);
      this.c.setDragEnable(false);
      this.epB = getIntent().getExtras().getInt("key_bottom_bar_right_action", 0);
      this.epC = getIntent().getExtras().getInt("key_bottom_bar_left_action", 2);
      this.jdField_a_of_type_ComTencentTimFilemanagerWidgetCloudSendBottomBar.setLeftAction(this.epC);
      this.jdField_a_of_type_ComTencentTimFilemanagerWidgetCloudSendBottomBar.setRightAction(this.epB);
      this.jdField_a_of_type_ComTencentTimFilemanagerWidgetCloudSendBottomBar.setVisibility(0);
      this.rightViewImg.setVisibility(8);
      this.rightViewText.setVisibility(0);
      this.rightViewText.setText(2131721058);
      this.rightViewText.setOnClickListener(this);
    }
    for (;;)
    {
      this.jdField_a_of_type_Atle.setMode(this.epA);
      this.c.setAdapter(this.jdField_a_of_type_Atle);
      return;
      this.jdField_b_of_type_Aaja = new aaja(this.c, this.mRoot, this.fD, this, null, 49);
      CloudFileUploadingStatusBar localCloudFileUploadingStatusBar = new CloudFileUploadingStatusBar(getActivity());
      this.jdField_b_of_type_Atlo = new atlo(getActivity(), localCloudFileUploadingStatusBar);
      this.c.addHeaderView(localCloudFileUploadingStatusBar);
    }
  }
  
  private void initUI()
  {
    this.mRoot = findViewById(2131377546);
    this.fD = ((RelativeLayout)findViewById(2131377361));
    this.c = ((PinnedDividerSwipListView)findViewById(2131370527));
    this.c.setDivider(null);
    this.c.setVisibility(8);
    this.mLoadingView = findViewById(2131362669);
    this.mLoadingView.setVisibility(0);
    this.c.setOverscrollHeader(getResources().getDrawable(2130839646));
    this.jdField_b_of_type_ComTencentTimWidgetPullRefreshHeader = ((PullRefreshHeader)LayoutInflater.from(this).inflate(2131559847, this.c, false));
    this.centerView = ((TextView)findViewById(2131369627));
    this.centerView.setText(getResources().getString(2131691582));
    this.rightViewImg.setVisibility(0);
    this.rightViewImg.setImageResource(2130840650);
    this.rightViewImg.setOnClickListener(this);
    this.c.setDragEnable(true);
    this.c.setContentBackground(2130838900);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(aaiy.a);
    localArrayList.add(aaiy.b);
    localArrayList.add(aaiy.e);
    this.jdField_a_of_type_Aaiy = new aaiy(this, localArrayList, this.jdField_a_of_type_Auuw$b);
    this.jdField_a_of_type_Atle = new atle(this.app, this, this);
    this.jdField_a_of_type_Atle.a(new atlh(this));
    this.jdField_a_of_type_Atle.setOnClickListener(new atli(this));
    this.jdField_a_of_type_ComTencentTimFilemanagerWidgetCloudSendBottomBar = ((CloudSendBottomBar)findViewById(2131377980));
  }
  
  private void refreshList()
  {
    this.c.setVisibility(0);
    this.jdField_a_of_type_Atle.mx(this.mFeedList);
    if (this.jdField_a_of_type_Ativ != null)
    {
      if ((this.mFeedList == null) || (this.mFeedList.size() == 0)) {
        this.jdField_a_of_type_Ativ.setVisible(false);
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_Ativ.setVisible(true);
  }
  
  public boolean Pp()
  {
    return isResume();
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 == 0) {}
    Object localObject2;
    switch (paramInt1)
    {
    default: 
      if (paramInt2 == -1)
      {
        localObject2 = null;
        if (paramIntent == null) {
          break label805;
        }
        localObject2 = paramIntent.getParcelableArrayListExtra("key_file_to_be_dealt_with");
      }
      break;
    }
    label805:
    for (Object localObject1 = (FileInfo)paramIntent.getParcelableExtra("key_selected_dir");; localObject1 = null)
    {
      this.jdField_a_of_type_Auhh = ((auhh)this.jdField_a_of_type_Atjx.a(2));
      switch (paramInt1)
      {
      }
      for (;;)
      {
        int i;
        if (paramInt1 == 1002)
        {
          if (paramInt2 == 1122) {
            QQToast.a(this, 2, "权限设置成功", 0).show(getTitleBarHeight());
          }
          if (paramIntent != null)
          {
            localObject1 = paramIntent.getStringExtra("url");
            i = paramIntent.getIntExtra("type", -1);
            if ((localObject1 != null) && (i != -1) && (this.jdField_a_of_type_Auhw != null)) {
              this.jdField_a_of_type_Auhw.gO((String)localObject1, i);
            }
          }
        }
        if (this.jdField_b_of_type_Aaja != null) {
          this.jdField_b_of_type_Aaja.onActivityResult(paramInt1, paramInt2, paramIntent);
        }
        return;
        this.jdField_a_of_type_Atle.notifyDataSetChanged();
        if (this.jdField_a_of_type_ComTencentTimFilemanagerWidgetCloudSendBottomBar == null) {
          break;
        }
        this.jdField_a_of_type_ComTencentTimFilemanagerWidgetCloudSendBottomBar.dmH();
        break;
        if (this.jdField_a_of_type_Auhw == null) {
          break;
        }
        this.jdField_a_of_type_Auhw.aaJ(1);
        break;
        if ((localObject2 != null) && (this.jdField_a_of_type_Auhh != null) && (localObject1 != null) && (((FileInfo)localObject1).Y() != null))
        {
          Object localObject3 = ((List)localObject2).iterator();
          Object localObject4;
          for (i = 0; ((Iterator)localObject3).hasNext(); i = (int)(i + ((FileInfo)localObject4).getSize())) {
            localObject4 = (FileInfo)((Iterator)localObject3).next();
          }
          localObject3 = (atgc)this.app.getManager(373);
          if (i > ((atgc)localObject3).getTotalSpace() - ((atgc)localObject3).it())
          {
            athu.c(this.app, this, 2);
          }
          else
          {
            this.jdField_a_of_type_Auhh.a(((FileInfo)localObject1).Y(), (List)localObject2, 1, null);
            continue;
            if ((localObject1 != null) && (atiz.Ou() > 0))
            {
              localObject2 = atiz.eo().iterator();
              while (((Iterator)localObject2).hasNext())
              {
                localObject3 = ((Iterator)localObject2).next();
                if ((localObject3 instanceof PadInfo)) {
                  ((ateh)this.app.getBusinessHandler(180)).a(((FileInfo)localObject1).Y(), athu.a((PadInfo)localObject3));
                } else if (((localObject3 instanceof FileManagerEntity)) && (this.jdField_a_of_type_Auhh != null) && (((FileInfo)localObject1).Y() != null)) {
                  this.jdField_a_of_type_Auhh.a(((FileManagerEntity)localObject3).cloudFile.pLogicDirKey, aueh.a((FileManagerEntity)localObject3), ((FileInfo)localObject1).Y(), 4);
                }
              }
              atiz.clearSelected();
              continue;
              if ((atiz.Ou() > 0) && (this.jdField_a_of_type_Auhh != null) && (localObject1 != null) && (((FileInfo)localObject1).Y() != null))
              {
                localObject2 = new ArrayList();
                localObject3 = atiz.eo().iterator();
                while (((Iterator)localObject3).hasNext())
                {
                  localObject4 = ((Iterator)localObject3).next();
                  if ((localObject4 instanceof FileManagerEntity)) {
                    ((List)localObject2).add(aueh.a((FileManagerEntity)localObject4));
                  } else if ((localObject4 instanceof atin)) {
                    ((List)localObject2).add(aueh.a((atin)localObject4));
                  }
                }
                if (((List)localObject2).size() != 0) {
                  this.jdField_a_of_type_Auhh.a(((FileInfo)((List)localObject2).get(0)).X(), (List)localObject2, ((FileInfo)localObject1).Y());
                }
                atiz.clearSelected();
                continue;
                localObject1 = paramIntent.getData();
                if (localObject1 != null)
                {
                  new atik(this.jdField_a_of_type_Atik$a).b((Uri)localObject1, this);
                  continue;
                  this.jdField_a_of_type_Atle.notifyDataSetChanged();
                  if (this.jdField_a_of_type_ComTencentTimFilemanagerWidgetCloudSendBottomBar != null)
                  {
                    this.jdField_a_of_type_ComTencentTimFilemanagerWidgetCloudSendBottomBar.dmH();
                    continue;
                    if (this.jdField_a_of_type_Auhw != null) {
                      this.jdField_a_of_type_Auhw.aaJ(1);
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2131558963);
    initUI();
    ie();
    if (this.app == null) {
      if (QLog.isColorLevel()) {
        QLog.d("CloudFeedListActivity", 2, "app is null ");
      }
    }
    for (;;)
    {
      if (this.dhv) {
        this.jdField_a_of_type_Auhw.aaJ(0);
      }
      this.jdField_a_of_type_Ativ = new ativ(this, "sp_key_refresh_time_cloud_feed", this.c, this.jdField_b_of_type_ComTencentTimWidgetPullRefreshHeader, new atlg(this));
      this.c.setDivider(null);
      this.c.setDividerHeight(0);
      this.c.setOverScrollHeader(this.jdField_b_of_type_ComTencentTimWidgetPullRefreshHeader);
      this.c.setOnScrollListener(this.jdField_a_of_type_Ativ);
      this.c.setOverScrollListener(this.jdField_a_of_type_Ativ);
      aths.a().a(this.jdField_a_of_type_Aths$a);
      return true;
      this.jdField_a_of_type_Aull = ((aull)this.app.getManager(372));
      this.jdField_a_of_type_Aulh = ((aulh)this.app.getBusinessHandler(122));
      this.jdField_a_of_type_Atjx = new atjx(this.app, this, this);
      this.jdField_a_of_type_Auhw = this.jdField_a_of_type_Atjx.a(this);
      this.dhv = true;
      this.app.addObserver(this.jdField_b_of_type_Aulm);
    }
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    this.app.removeObserver(this.jdField_b_of_type_Aulm);
    if (this.jdField_a_of_type_Aaiy != null) {
      this.jdField_a_of_type_Aaiy.dismiss();
    }
    if (this.jdField_a_of_type_Atjx != null) {
      this.jdField_a_of_type_Atjx.onDestroy();
    }
    if (this.jdField_a_of_type_Atle != null) {
      this.jdField_a_of_type_Atle.onDestroy();
    }
    if (this.jdField_a_of_type_Auhw != null) {
      this.jdField_a_of_type_Auhw.destroy();
    }
    this.uiHandler.removeCallbacksAndMessages(null);
    aths.a().b(this.jdField_a_of_type_Aths$a);
    if (!this.dhZ) {
      atiz.clearSelected();
    }
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    if (this.jdField_b_of_type_Atlo != null) {
      this.jdField_b_of_type_Atlo.onPause();
    }
    if (this.jdField_a_of_type_Aaiy != null) {
      this.jdField_a_of_type_Aaiy.dismiss();
    }
    if (this.jdField_a_of_type_ComTencentTimFilemanagerWidgetCloudSendBottomBar != null) {
      this.jdField_a_of_type_ComTencentTimFilemanagerWidgetCloudSendBottomBar.doOnPause();
    }
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    if (this.jdField_b_of_type_Atlo != null) {
      this.jdField_b_of_type_Atlo.onResume();
    }
    if (this.jdField_a_of_type_ComTencentTimFilemanagerWidgetCloudSendBottomBar != null) {
      this.jdField_a_of_type_ComTencentTimFilemanagerWidgetCloudSendBottomBar.doOnResume();
    }
    f(true, 3, this.jdField_a_of_type_Auhw.isComplete());
  }
  
  public void f(boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    this.mLoadingView.setVisibility(8);
    this.c.setVisibility(0);
    if (this.jdField_a_of_type_Ativ != null) {
      this.jdField_a_of_type_Ativ.cG(paramBoolean1, paramBoolean2);
    }
    if (paramInt == 1) {
      this.c.springBackOverScrollHeaderView();
    }
    if (paramBoolean1) {
      etT();
    }
    if (paramInt == 0) {
      this.jdField_a_of_type_Auhw.aaJ(1);
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    label93:
    do
    {
      do
      {
        do
        {
          return true;
          if (this.jdField_b_of_type_ComTencentTimWidgetPullRefreshHeader != null)
          {
            if (paramMessage.arg1 != 1) {
              break label93;
            }
            this.jdField_b_of_type_ComTencentTimWidgetPullRefreshHeader.tT(0);
          }
          for (;;)
          {
            paramMessage = new Message();
            paramMessage.what = 112;
            this.uiHandler.sendMessageDelayed(paramMessage, 500L);
            return true;
            this.jdField_b_of_type_ComTencentTimWidgetPullRefreshHeader.tT(1);
          }
        } while (this.c == null);
        this.c.springBackOverScrollHeaderView();
        return true;
        this.uiHandler.removeMessages(114);
      } while (this.jdField_a_of_type_Ativ == null);
      this.jdField_a_of_type_Ativ.lz(false);
      return true;
      paramMessage = (List)paramMessage.obj;
      this.mFeedList.clear();
      this.mFeedList.addAll(paramMessage);
      refreshList();
      return true;
    } while (this.jdField_a_of_type_Auhw == null);
    this.jdField_a_of_type_Auhw.aaJ(1);
    return true;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.jdField_a_of_type_Aaiy != null)
      {
        this.jdField_a_of_type_Aaiy.t(this.fD, this.fD.getWidth() - getResources().getDimensionPixelSize(2131299279), getResources().getDimensionPixelSize(2131299276));
        continue;
        setResult(-1, new Intent());
        doOnBackPressed();
      }
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.jdField_a_of_type_Ativ != null) {
      this.jdField_a_of_type_Ativ.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (this.jdField_a_of_type_Ativ != null) {
      this.jdField_a_of_type_Ativ.onScrollStateChanged(paramAbsListView, paramInt);
    }
  }
  
  public void qw(String paramString)
  {
    auds.D(1, paramString, 0);
  }
  
  public void showSuccessToast(String paramString)
  {
    auds.D(2, paramString, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.cloudfile.feeds.CloudFeedListActivity
 * JD-Core Version:    0.7.0.1
 */