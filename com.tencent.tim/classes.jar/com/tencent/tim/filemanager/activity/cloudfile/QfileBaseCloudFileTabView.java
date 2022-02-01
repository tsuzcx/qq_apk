package com.tencent.tim.filemanager.activity.cloudfile;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import aqnm;
import atpo;
import atpu;
import atpx;
import atpy;
import atpz;
import atqa;
import atqb;
import atqc;
import atqg;
import atqh;
import atqi;
import atqj;
import atqk;
import atql;
import atsn;
import atso;
import attf;
import atti;
import attk;
import atwb;
import audw;
import audx;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.data.WeiYunFileInfo;
import com.tencent.mobileqq.widget.ScrollerRunnable;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tim.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.tim.filemanager.activity.FMActivity;
import com.tencent.tim.filemanager.activity.fileassistant.QfileBaseTabView;
import com.tencent.tim.filemanager.fileviewer.FileBrowserActivity;
import com.tencent.tim.filemanager.widget.NoFileRelativeLayout;
import com.tencent.tim.filemanager.widget.QfilePinnedHeaderExpandableListView;
import com.tencent.tim.filemanager.widget.ViewerMoreRelativeLayout;
import com.tencent.widget.BubblePopupWindow;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public abstract class QfileBaseCloudFileTabView
  extends QfileBaseTabView
{
  public static String TAG = "QfileRecentFileActivity<FileAssistant>";
  private View KI;
  protected LinkedHashMap<String, List<WeiYunFileInfo>> R = new LinkedHashMap();
  long Yn = -1L;
  public atpo a;
  ScrollerRunnable a;
  public QfilePinnedHeaderExpandableListView a;
  public ViewerMoreRelativeLayout a;
  NoFileRelativeLayout b;
  public TextView bG;
  public boolean ccZ;
  private atsn d = new atqg(this);
  protected boolean diB;
  Drawable dx;
  public View.OnClickListener eW = new atql(this);
  public View.OnClickListener eX = new atqc(this);
  public View.OnLongClickListener g = new atpy(this);
  public View.OnClickListener gs = new atpz(this);
  public View.OnClickListener gt = new atqa(this);
  BubblePopupWindow k = null;
  public View.OnClickListener m = new atqk(this);
  int mFrom = 0;
  LayoutInflater mInflater = null;
  volatile boolean mPaused = false;
  public View.OnClickListener n = new atqb(this);
  public ArrayList<WeiYunFileInfo> wB = new ArrayList();
  
  public QfileBaseCloudFileTabView(Context paramContext)
  {
    super(paramContext);
    this.jdField_b_of_type_ComTencentTimFilemanagerWidgetNoFileRelativeLayout = null;
  }
  
  private void bWr()
  {
    try
    {
      this.jdField_b_of_type_ComTencentTimFilemanagerWidgetNoFileRelativeLayout = new NoFileRelativeLayout(a());
      this.jdField_a_of_type_ComTencentTimFilemanagerWidgetQfilePinnedHeaderExpandableListView.addHeaderView(this.jdField_b_of_type_ComTencentTimFilemanagerWidgetNoFileRelativeLayout);
      this.jdField_a_of_type_ComTencentTimFilemanagerWidgetViewerMoreRelativeLayout = new ViewerMoreRelativeLayout(a());
      this.jdField_a_of_type_ComTencentTimFilemanagerWidgetViewerMoreRelativeLayout.setOnClickListener(this.eW);
      this.jdField_a_of_type_ComTencentTimFilemanagerWidgetViewerMoreRelativeLayout.setGone();
      this.bG = ((TextView)this.jdField_a_of_type_ComTencentTimFilemanagerWidgetViewerMoreRelativeLayout.findViewById(2131381971));
      this.jdField_a_of_type_ComTencentTimFilemanagerWidgetQfilePinnedHeaderExpandableListView.addFooterView(this.jdField_a_of_type_ComTencentTimFilemanagerWidgetViewerMoreRelativeLayout);
      dfE();
      this.jdField_b_of_type_ComTencentTimFilemanagerWidgetNoFileRelativeLayout.showLoadingView();
      this.KI = findViewById(2131367048);
      ImageView localImageView = (ImageView)this.KI.findViewById(2131364340);
      TextView localTextView = (TextView)this.KI.findViewById(2131364342);
      View localView = this.KI.findViewById(2131377000);
      localImageView.setBackgroundResource(2130851982);
      localTextView.setText(2131721848);
      localView.setVisibility(8);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void f(WeiYunFileInfo paramWeiYunFileInfo)
  {
    audw.JH("0X8004AE6");
    Object localObject2 = this.app.a().f(paramWeiYunFileInfo.bIk);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject2 = this.app.a().c(paramWeiYunFileInfo.bIk);
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = audx.b(paramWeiYunFileInfo);
      }
    }
    localObject2 = new ForwardFileInfo();
    ((ForwardFileInfo)localObject2).Oj(2);
    ((ForwardFileInfo)localObject2).setType(10003);
    ((ForwardFileInfo)localObject2).p(((FileManagerEntity)localObject1).nSessionId);
    ((ForwardFileInfo)localObject2).setFileName(paramWeiYunFileInfo.strFileName);
    ((ForwardFileInfo)localObject2).setFileId(paramWeiYunFileInfo.bIk);
    ((ForwardFileInfo)localObject2).Oi(paramWeiYunFileInfo.cYi);
    ((ForwardFileInfo)localObject2).setFileSize(paramWeiYunFileInfo.nFileSize);
    paramWeiYunFileInfo = new Intent(this.jdField_b_of_type_ComTencentTimFilemanagerActivityFMActivity, FileBrowserActivity.class);
    paramWeiYunFileInfo.putExtra("fileinfo", (Parcelable)localObject2);
    if (audx.fM(((ForwardFileInfo)localObject2).getFileName()) == 0) {
      paramWeiYunFileInfo.putParcelableArrayListExtra("local_weiyun_list", this.wB);
    }
    this.jdField_b_of_type_ComTencentTimFilemanagerActivityFMActivity.startActivityForResult(paramWeiYunFileInfo, 102);
  }
  
  private void initListView()
  {
    this.jdField_a_of_type_ComTencentTimFilemanagerWidgetQfilePinnedHeaderExpandableListView = ((QfilePinnedHeaderExpandableListView)findViewById(2131367046));
    this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable = new ScrollerRunnable(this.jdField_a_of_type_ComTencentTimFilemanagerWidgetQfilePinnedHeaderExpandableListView);
    this.jdField_a_of_type_ComTencentTimFilemanagerWidgetQfilePinnedHeaderExpandableListView.setSelection(0);
    this.jdField_a_of_type_ComTencentTimFilemanagerWidgetQfilePinnedHeaderExpandableListView.setFocusable(false);
  }
  
  public int Ec()
  {
    return this.jdField_a_of_type_ComTencentTimFilemanagerWidgetViewerMoreRelativeLayout.getHeight();
  }
  
  protected abstract void IS(boolean paramBoolean);
  
  public void IU(boolean paramBoolean) {}
  
  protected abstract atpo a();
  
  public void a(WeiYunFileInfo paramWeiYunFileInfo, int paramInt)
  {
    this.app.a().aIH();
    if (akL()) {
      if (atwb.c(paramWeiYunFileInfo))
      {
        atwb.d(paramWeiYunFileInfo);
        deR();
        refreshList();
      }
    }
    do
    {
      return;
      atwb.c(paramWeiYunFileInfo);
      break;
      if (H()) {
        break label68;
      }
    } while (!QLog.isColorLevel());
    QLog.i(TAG, 2, "click too fast , wait a minute.");
    return;
    label68:
    aM();
    f(paramWeiYunFileInfo);
  }
  
  protected abstract boolean a(WeiYunFileInfo paramWeiYunFileInfo);
  
  public boolean b(WeiYunFileInfo paramWeiYunFileInfo)
  {
    if (paramWeiYunFileInfo == null) {
      return false;
    }
    return a(paramWeiYunFileInfo);
  }
  
  protected abstract void dfD();
  
  public void dfE()
  {
    int i = this.jdField_b_of_type_ComTencentTimFilemanagerActivityFMActivity.getWindow().getDecorView().getHeight();
    int j = (int)(145.0F * aqnm.getDensity());
    this.jdField_b_of_type_ComTencentTimFilemanagerWidgetNoFileRelativeLayout.setLayoutParams(this.jdField_a_of_type_ComTencentTimFilemanagerWidgetQfilePinnedHeaderExpandableListView.getWidth(), i - j);
  }
  
  public void dfF()
  {
    if ((this.bG != null) && (this.dx == null))
    {
      this.dx = getResources().getDrawable(2130839651);
      this.bG.setCompoundDrawablesWithIntrinsicBounds(this.dx, null, null, null);
      ((Animatable)this.dx).start();
    }
  }
  
  public void dfG()
  {
    this.ccZ = false;
    if ((this.bG != null) && (this.dx != null))
    {
      ((Animatable)this.dx).stop();
      this.dx = null;
      this.bG.setCompoundDrawables(null, null, null, null);
    }
  }
  
  public abstract boolean isEnd();
  
  public void onCreate()
  {
    setContentView(2131560997);
    this.mInflater = LayoutInflater.from(a());
    this.app.a().addObserver(this.d);
    this.jdField_a_of_type_Atpo = a();
    initListView();
    bWr();
    if ((this.jdField_a_of_type_Atpo instanceof atpu))
    {
      if (!akI()) {
        this.KI.setVisibility(0);
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentTimFilemanagerWidgetQfilePinnedHeaderExpandableListView.setSelector(2131167595);
        this.jdField_a_of_type_ComTencentTimFilemanagerWidgetQfilePinnedHeaderExpandableListView.setGroupIndicator(a().getResources().getDrawable(2130839740));
        this.jdField_a_of_type_ComTencentTimFilemanagerWidgetQfilePinnedHeaderExpandableListView.setAdapter(this.jdField_a_of_type_Atpo);
        this.jdField_a_of_type_ComTencentTimFilemanagerWidgetQfilePinnedHeaderExpandableListView.setTranscriptMode(0);
        this.jdField_a_of_type_ComTencentTimFilemanagerWidgetQfilePinnedHeaderExpandableListView.setWhetherImageTab(true);
        this.jdField_a_of_type_ComTencentTimFilemanagerWidgetQfilePinnedHeaderExpandableListView.setGridSize(((atpu)this.jdField_a_of_type_Atpo).Eb());
        i = 0;
        while (i < this.jdField_a_of_type_Atpo.getGroupCount())
        {
          this.jdField_a_of_type_ComTencentTimFilemanagerWidgetQfilePinnedHeaderExpandableListView.expandGroup(i);
          i += 1;
        }
        this.KI.setVisibility(8);
      }
    }
    this.KI.setVisibility(8);
    this.jdField_a_of_type_ComTencentTimFilemanagerWidgetQfilePinnedHeaderExpandableListView.setOnGroupExpandListener(new atpx(this));
    this.jdField_a_of_type_ComTencentTimFilemanagerWidgetQfilePinnedHeaderExpandableListView.setOnGroupCollapseListener(new atqh(this));
    this.jdField_a_of_type_ComTencentTimFilemanagerWidgetQfilePinnedHeaderExpandableListView.setSelector(2131167595);
    this.jdField_a_of_type_ComTencentTimFilemanagerWidgetQfilePinnedHeaderExpandableListView.setGroupIndicator(a().getResources().getDrawable(2130839740));
    this.jdField_a_of_type_ComTencentTimFilemanagerWidgetQfilePinnedHeaderExpandableListView.setAdapter(this.jdField_a_of_type_Atpo);
    this.jdField_a_of_type_ComTencentTimFilemanagerWidgetQfilePinnedHeaderExpandableListView.setTranscriptMode(0);
    this.jdField_a_of_type_ComTencentTimFilemanagerWidgetQfilePinnedHeaderExpandableListView.setWhetherImageTab(false);
    int i = 0;
    while (i < this.jdField_a_of_type_Atpo.getGroupCount())
    {
      this.jdField_a_of_type_ComTencentTimFilemanagerWidgetQfilePinnedHeaderExpandableListView.expandGroup(i);
      i += 1;
    }
    this.jdField_a_of_type_ComTencentTimFilemanagerWidgetQfilePinnedHeaderExpandableListView.smoothScrollToPosition(0);
    this.jdField_a_of_type_ComTencentTimFilemanagerWidgetQfilePinnedHeaderExpandableListView.setStackFromBottom(false);
    this.jdField_a_of_type_ComTencentTimFilemanagerWidgetQfilePinnedHeaderExpandableListView.setTranscriptMode(0);
    if ((this.jdField_a_of_type_Atpo instanceof atpu))
    {
      this.jdField_a_of_type_ComTencentTimFilemanagerWidgetQfilePinnedHeaderExpandableListView.getViewTreeObserver().addOnGlobalLayoutListener(new atqi(this));
      if (this.jdField_a_of_type_ComTencentTimFilemanagerWidgetViewerMoreRelativeLayout == null) {
        this.jdField_a_of_type_ComTencentTimFilemanagerWidgetViewerMoreRelativeLayout = new ViewerMoreRelativeLayout(getContext());
      }
      this.bG = ((TextView)this.jdField_a_of_type_ComTencentTimFilemanagerWidgetViewerMoreRelativeLayout.findViewById(2131381971));
      this.jdField_a_of_type_ComTencentTimFilemanagerWidgetViewerMoreRelativeLayout.setOnClickListener(this.eW);
      this.jdField_a_of_type_ComTencentTimFilemanagerWidgetViewerMoreRelativeLayout.setGone();
      return;
    }
    this.jdField_a_of_type_ComTencentTimFilemanagerWidgetQfilePinnedHeaderExpandableListView.getViewTreeObserver().addOnGlobalLayoutListener(new atqj(this));
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    onStop();
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable.stop();
    }
    this.wB.clear();
    this.R.clear();
    dge();
    if (this.d != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "onDestroy, del fmObserver");
      }
      this.app.a().deleteObserver(this.d);
    }
    this.app.a().aIH();
    this.app.a().dgm();
  }
  
  public void onGetMore() {}
  
  public void onStart()
  {
    if (this.R.size() > 0) {
      refreshList();
    }
    this.jdField_b_of_type_ComTencentTimFilemanagerActivityFMActivity.IM(this.jdField_b_of_type_ComTencentTimFilemanagerActivityFMActivity.akL());
  }
  
  public void refreshList()
  {
    if ((this.R == null) || (this.R.size() == 0))
    {
      this.jdField_b_of_type_ComTencentTimFilemanagerWidgetNoFileRelativeLayout.aaF(0);
      this.jdField_a_of_type_ComTencentTimFilemanagerWidgetViewerMoreRelativeLayout.setGone();
    }
    for (;;)
    {
      this.jdField_a_of_type_Atpo.notifyDataSetChanged();
      return;
      if (this.jdField_b_of_type_ComTencentTimFilemanagerWidgetNoFileRelativeLayout != null) {
        this.jdField_b_of_type_ComTencentTimFilemanagerWidgetNoFileRelativeLayout.setGone();
      }
    }
  }
  
  public void refreshUI()
  {
    runOnUiThread(new QfileBaseCloudFileTabView.16(this));
  }
  
  public void setListFooter()
  {
    if ((this.jdField_a_of_type_Atpo instanceof atpu)) {}
    while ((this.jdField_a_of_type_Atpo.getGroupCount() <= 0) || (!this.jdField_a_of_type_ComTencentTimFilemanagerWidgetQfilePinnedHeaderExpandableListView.isGroupExpanded(this.jdField_a_of_type_Atpo.getGroupCount() - 1)) || (this.jdField_a_of_type_ComTencentTimFilemanagerWidgetViewerMoreRelativeLayout == null)) {
      return;
    }
    if (!isEnd())
    {
      this.jdField_a_of_type_ComTencentTimFilemanagerWidgetViewerMoreRelativeLayout.setVisible();
      return;
    }
    this.jdField_a_of_type_ComTencentTimFilemanagerWidgetViewerMoreRelativeLayout.setGone();
  }
  
  public void setSelect(int paramInt)
  {
    if (this.jdField_a_of_type_Atpo.getGroupCount() <= paramInt)
    {
      if (QLog.isColorLevel()) {
        QLog.e(TAG, 1, "setSelect[" + paramInt + "] faild,becouse GroupCount[" + this.jdField_a_of_type_Atpo.getGroupCount() + "]");
      }
      return;
    }
    runOnUiThread(new QfileBaseCloudFileTabView.17(this, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.filemanager.activity.cloudfile.QfileBaseCloudFileTabView
 * JD-Core Version:    0.7.0.1
 */