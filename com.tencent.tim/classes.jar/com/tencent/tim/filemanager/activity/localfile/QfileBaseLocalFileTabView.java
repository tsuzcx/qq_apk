package com.tencent.tim.filemanager.activity.localfile;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewTreeObserver;
import android.view.Window;
import aqnm;
import atgc;
import athu;
import atpo;
import atpq;
import atqz;
import atra;
import atrb;
import atrc;
import atrd;
import atre;
import atrf;
import atrg;
import atrh;
import atri;
import atsn;
import atso;
import attf;
import atti;
import atwb;
import auds;
import audw;
import audw.b;
import audx;
import aueh;
import auei;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
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
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

public abstract class QfileBaseLocalFileTabView
  extends QfileBaseTabView
{
  public static String TAG = "QfileRecentFileActivity<FileAssistant>";
  public LinkedHashMap<String, List<FileInfo>> R = new LinkedHashMap();
  long Yn = -1L;
  public atpo a;
  ScrollerRunnable jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable;
  QfilePinnedHeaderExpandableListView jdField_a_of_type_ComTencentTimFilemanagerWidgetQfilePinnedHeaderExpandableListView;
  public ViewerMoreRelativeLayout a;
  auei jdField_b_of_type_Auei = null;
  NoFileRelativeLayout jdField_b_of_type_ComTencentTimFilemanagerWidgetNoFileRelativeLayout = null;
  boolean cdj;
  private atsn d = new atrc(this);
  public View.OnClickListener eW = new atrg(this);
  public View.OnClickListener eX = new atra(this);
  public View.OnLongClickListener g = new atrh(this);
  public View.OnClickListener gt = new atrb(this);
  BubblePopupWindow k = null;
  public View.OnClickListener m = new atrf(this);
  int mFrom = 0;
  LayoutInflater mInflater = null;
  volatile boolean mPaused = false;
  public View.OnClickListener n = new atri(this);
  protected ArrayList<FileInfo> wB = new ArrayList();
  
  public QfileBaseLocalFileTabView(Context paramContext)
  {
    super(paramContext);
  }
  
  private void bWr()
  {
    try
    {
      this.jdField_b_of_type_ComTencentTimFilemanagerWidgetNoFileRelativeLayout = new NoFileRelativeLayout(a());
      this.jdField_a_of_type_ComTencentTimFilemanagerWidgetQfilePinnedHeaderExpandableListView.addHeaderView(this.jdField_b_of_type_ComTencentTimFilemanagerWidgetNoFileRelativeLayout);
      this.jdField_a_of_type_ComTencentTimFilemanagerWidgetViewerMoreRelativeLayout = new ViewerMoreRelativeLayout(a());
      this.jdField_a_of_type_ComTencentTimFilemanagerWidgetViewerMoreRelativeLayout.setOnClickListener(this.eW);
      this.jdField_a_of_type_ComTencentTimFilemanagerWidgetQfilePinnedHeaderExpandableListView.addFooterView(this.jdField_a_of_type_ComTencentTimFilemanagerWidgetViewerMoreRelativeLayout);
      dfE();
      this.jdField_b_of_type_ComTencentTimFilemanagerWidgetNoFileRelativeLayout.showLoadingView();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void dgf()
  {
    if ((this.R == null) || (this.R.size() == 0))
    {
      this.jdField_b_of_type_ComTencentTimFilemanagerActivityFMActivity.setCheckAll(false);
      this.jdField_b_of_type_ComTencentTimFilemanagerActivityFMActivity.setCheckAllEnable(false);
      return;
    }
    this.jdField_b_of_type_ComTencentTimFilemanagerActivityFMActivity.setCheckAllEnable(true);
    Iterator localIterator2;
    do
    {
      Iterator localIterator1 = this.R.values().iterator();
      while (!localIterator2.hasNext())
      {
        if (!localIterator1.hasNext()) {
          break;
        }
        localIterator2 = ((List)localIterator1.next()).iterator();
      }
    } while (atwb.d((FileInfo)localIterator2.next()));
    this.jdField_b_of_type_ComTencentTimFilemanagerActivityFMActivity.setCheckAll(false);
    return;
    this.jdField_b_of_type_ComTencentTimFilemanagerActivityFMActivity.setCheckAll(true);
  }
  
  private void g(FileInfo paramFileInfo)
  {
    FileManagerEntity localFileManagerEntity = audx.a(paramFileInfo);
    Object localObject = new ForwardFileInfo();
    ((ForwardFileInfo)localObject).p(localFileManagerEntity.nSessionId);
    ((ForwardFileInfo)localObject).Oj(3);
    ((ForwardFileInfo)localObject).setType(10000);
    ((ForwardFileInfo)localObject).setLocalPath(paramFileInfo.getPath());
    ((ForwardFileInfo)localObject).setFileName(paramFileInfo.getName());
    ((ForwardFileInfo)localObject).setFileSize(paramFileInfo.getSize());
    Intent localIntent = new Intent(this.jdField_b_of_type_ComTencentTimFilemanagerActivityFMActivity, FileBrowserActivity.class);
    localIntent.putExtra("fileinfo", (Parcelable)localObject);
    if ((localFileManagerEntity.nFileType == 0) || (localFileManagerEntity.nFileType == 1))
    {
      localObject = new ArrayList();
      if (this.R != null)
      {
        Iterator localIterator = this.R.keySet().iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          ((ArrayList)localObject).addAll((Collection)this.R.get(str));
        }
      }
      atwb.en((ArrayList)localObject);
      localIntent.putExtra("clicked_file_hashcode", paramFileInfo.hashCode());
    }
    localObject = new audw.b();
    ((audw.b)localObject).bJE = "file_viewer_in";
    ((audw.b)localObject).cYX = 80;
    ((audw.b)localObject).bJF = aueh.getExtension(paramFileInfo.getName());
    ((audw.b)localObject).nFileSize = paramFileInfo.getSize();
    audw.a(this.app.getCurrentAccountUin(), (audw.b)localObject);
    audw.JH("0X8004AE5");
    this.jdField_b_of_type_ComTencentTimFilemanagerActivityFMActivity.startActivityForResult(localIntent, 102);
    if (localFileManagerEntity.nFileType == 0) {
      this.jdField_b_of_type_ComTencentTimFilemanagerActivityFMActivity.overridePendingTransition(2130772077, 2130772079);
    }
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
  
  public void IU(boolean paramBoolean) {}
  
  protected void Nx()
  {
    if (this.jdField_b_of_type_Auei != null)
    {
      this.jdField_b_of_type_ComTencentTimFilemanagerActivityFMActivity.a(this.jdField_b_of_type_Auei);
      return;
    }
    this.jdField_b_of_type_Auei = new atrd(this);
    this.jdField_b_of_type_ComTencentTimFilemanagerActivityFMActivity.a(this.jdField_b_of_type_Auei);
  }
  
  protected abstract atpo a();
  
  public void a(FileInfo paramFileInfo)
  {
    if (paramFileInfo == null) {
      return;
    }
    b(paramFileInfo);
  }
  
  protected abstract void b(FileInfo paramFileInfo);
  
  public boolean b(FileInfo paramFileInfo)
  {
    if (paramFileInfo == null) {
      return false;
    }
    return c(paramFileInfo);
  }
  
  protected abstract boolean c(FileInfo paramFileInfo);
  
  protected abstract void dfD();
  
  public void dfE()
  {
    int i = this.jdField_b_of_type_ComTencentTimFilemanagerActivityFMActivity.getWindow().getDecorView().getHeight();
    int j = (int)(195.0F * aqnm.getDensity());
    this.jdField_b_of_type_ComTencentTimFilemanagerWidgetNoFileRelativeLayout.setLayoutParams(this.jdField_a_of_type_ComTencentTimFilemanagerWidgetQfilePinnedHeaderExpandableListView.getWidth(), i - j);
  }
  
  public void dfP()
  {
    if (this.R == null) {
      return;
    }
    Iterator localIterator1 = this.R.values().iterator();
    while (localIterator1.hasNext())
    {
      Iterator localIterator2 = ((List)localIterator1.next()).iterator();
      while (localIterator2.hasNext()) {
        atwb.d((FileInfo)localIterator2.next());
      }
    }
    int j = this.R.keySet().size();
    int i = 0;
    while (i < j)
    {
      this.jdField_a_of_type_ComTencentTimFilemanagerWidgetQfilePinnedHeaderExpandableListView.expandGroup(i);
      i += 1;
    }
    deR();
    this.jdField_a_of_type_Atpo.notifyDataSetChanged();
  }
  
  public void dfQ()
  {
    Iterator localIterator1 = this.R.values().iterator();
    while (localIterator1.hasNext())
    {
      Iterator localIterator2 = ((List)localIterator1.next()).iterator();
      while (localIterator2.hasNext()) {
        atwb.e((FileInfo)localIterator2.next());
      }
    }
    deR();
    this.jdField_a_of_type_Atpo.notifyDataSetChanged();
  }
  
  public void f(FileInfo paramFileInfo)
  {
    this.app.a().aIH();
    if (akL()) {
      if (atwb.d(paramFileInfo))
      {
        atwb.e(paramFileInfo);
        if ((this.jdField_b_of_type_ComTencentTimFilemanagerActivityFMActivity.aWg) && (!aueh.fileExistsAndNotEmpty(paramFileInfo.getPath())))
        {
          auds.JD(audx.kY(paramFileInfo.getName()) + "为空文件，无法发送！");
          atwb.e(paramFileInfo);
        }
        deR();
        refreshList();
        dgf();
      }
    }
    do
    {
      return;
      atgc localatgc = (atgc)this.app.getManager(373);
      if ((this.jdField_b_of_type_ComTencentTimFilemanagerActivityFMActivity.dit) && (localatgc.iu() < paramFileInfo.getSize()))
      {
        auds.JG("选择的文件大于" + athu.c((float)localatgc.iu()) + "，添加失败");
        break;
      }
      atwb.d(paramFileInfo);
      break;
      if (H()) {
        break label200;
      }
    } while (!QLog.isColorLevel());
    QLog.i(TAG, 2, "click too fast , wait a minute.");
    return;
    label200:
    aM();
    g(paramFileInfo);
  }
  
  public void onCreate()
  {
    int i = 0;
    setContentView(2131563200);
    this.mInflater = LayoutInflater.from(a());
    this.app.a().addObserver(this.d);
    this.jdField_a_of_type_Atpo = a();
    initListView();
    bWr();
    if ((this.jdField_a_of_type_Atpo instanceof atpq))
    {
      this.jdField_a_of_type_ComTencentTimFilemanagerWidgetQfilePinnedHeaderExpandableListView.setSelector(2131167595);
      this.jdField_a_of_type_ComTencentTimFilemanagerWidgetQfilePinnedHeaderExpandableListView.setGroupIndicator(a().getResources().getDrawable(2130839740));
      this.jdField_a_of_type_ComTencentTimFilemanagerWidgetQfilePinnedHeaderExpandableListView.setAdapter(this.jdField_a_of_type_Atpo);
      this.jdField_a_of_type_ComTencentTimFilemanagerWidgetQfilePinnedHeaderExpandableListView.setTranscriptMode(0);
      this.jdField_a_of_type_ComTencentTimFilemanagerWidgetQfilePinnedHeaderExpandableListView.setWhetherImageTab(true);
      this.jdField_a_of_type_ComTencentTimFilemanagerWidgetQfilePinnedHeaderExpandableListView.setGridSize(((atpq)this.jdField_a_of_type_Atpo).Eb());
      i = 0;
      while (i < this.jdField_a_of_type_Atpo.getGroupCount())
      {
        this.jdField_a_of_type_ComTencentTimFilemanagerWidgetQfilePinnedHeaderExpandableListView.expandGroup(i);
        i += 1;
      }
    }
    this.jdField_a_of_type_ComTencentTimFilemanagerWidgetQfilePinnedHeaderExpandableListView.setSelector(2131167595);
    this.jdField_a_of_type_ComTencentTimFilemanagerWidgetQfilePinnedHeaderExpandableListView.setGroupIndicator(a().getResources().getDrawable(2130839740));
    this.jdField_a_of_type_ComTencentTimFilemanagerWidgetQfilePinnedHeaderExpandableListView.setAdapter(this.jdField_a_of_type_Atpo);
    this.jdField_a_of_type_ComTencentTimFilemanagerWidgetQfilePinnedHeaderExpandableListView.setTranscriptMode(0);
    this.jdField_a_of_type_ComTencentTimFilemanagerWidgetQfilePinnedHeaderExpandableListView.setWhetherImageTab(false);
    while (i < this.jdField_a_of_type_Atpo.getGroupCount())
    {
      this.jdField_a_of_type_ComTencentTimFilemanagerWidgetQfilePinnedHeaderExpandableListView.expandGroup(i);
      i += 1;
    }
    setLoadAllRecord(true);
    if ((this.jdField_a_of_type_Atpo instanceof atpq))
    {
      this.jdField_a_of_type_ComTencentTimFilemanagerWidgetQfilePinnedHeaderExpandableListView.getViewTreeObserver().addOnGlobalLayoutListener(new atqz(this));
      return;
    }
    this.jdField_a_of_type_ComTencentTimFilemanagerWidgetQfilePinnedHeaderExpandableListView.getViewTreeObserver().addOnGlobalLayoutListener(new atre(this));
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable.stop();
    }
    if (this.runnable != null) {
      ThreadManager.remove(this.runnable);
    }
    this.wB.clear();
    this.R.clear();
    dge();
    if (this.d != null) {
      this.app.a().deleteObserver(this.d);
    }
    this.app.a().aIH();
    this.app.a().dgm();
  }
  
  public void onGetMore() {}
  
  public void onResume()
  {
    dfD();
    this.jdField_b_of_type_ComTencentTimFilemanagerActivityFMActivity.IM(this.jdField_b_of_type_ComTencentTimFilemanagerActivityFMActivity.akL());
  }
  
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
    runOnUiThread(new QfileBaseLocalFileTabView.13(this));
  }
  
  public void setLoadAllRecord(boolean paramBoolean)
  {
    if (paramBoolean) {
      if (this.jdField_a_of_type_ComTencentTimFilemanagerWidgetViewerMoreRelativeLayout != null) {
        this.jdField_a_of_type_ComTencentTimFilemanagerWidgetViewerMoreRelativeLayout.setGone();
      }
    }
    for (;;)
    {
      this.cdj = paramBoolean;
      return;
      if (this.jdField_a_of_type_ComTencentTimFilemanagerWidgetViewerMoreRelativeLayout != null) {
        this.jdField_a_of_type_ComTencentTimFilemanagerWidgetViewerMoreRelativeLayout.setVisible();
      }
    }
  }
  
  public void setPos(int paramInt1, int paramInt2)
  {
    if ((paramInt1 < 0) || (paramInt2 < 0)) {}
    while (this.jdField_a_of_type_Atpo.getGroupCount() <= paramInt1) {
      return;
    }
    runOnUiThread(new QfileBaseLocalFileTabView.14(this, paramInt1, paramInt2));
  }
  
  public void setSelect(int paramInt)
  {
    if (this.jdField_a_of_type_Atpo.getGroupCount() <= paramInt) {
      return;
    }
    runOnUiThread(new QfileBaseLocalFileTabView.15(this, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.filemanager.activity.localfile.QfileBaseLocalFileTabView
 * JD-Core Version:    0.7.0.1
 */