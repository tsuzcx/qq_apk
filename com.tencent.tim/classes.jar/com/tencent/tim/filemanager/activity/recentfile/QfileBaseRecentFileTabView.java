package com.tencent.tim.filemanager.activity.recentfile;

import acdl;
import ahal;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewTreeObserver;
import android.view.Window;
import aqcl;
import aqiw;
import aqnm;
import atpo;
import atps;
import atrl;
import atrm;
import atrn;
import atrq;
import atrr;
import atrs;
import atrt;
import atru;
import atrv;
import atrw;
import atsa;
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
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.data.OfflineFileInfo;
import com.tencent.mobileqq.widget.ScrollerRunnable;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tim.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.tim.filemanager.activity.FMActivity;
import com.tencent.tim.filemanager.activity.fileassistant.QfileBaseTabView;
import com.tencent.tim.filemanager.fileviewer.FileBrowserActivity;
import com.tencent.tim.filemanager.fileviewer.TroopFileDetailBrowserActivity;
import com.tencent.tim.filemanager.widget.NoFileRelativeLayout;
import com.tencent.tim.filemanager.widget.QfilePinnedHeaderExpandableListView;
import com.tencent.widget.BubblePopupWindow;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import mqq.app.MobileQQ;

public abstract class QfileBaseRecentFileTabView
  extends QfileBaseTabView
{
  public static String TAG = "QfileRecentFileActivity<FileAssistant>";
  List<FileManagerEntity> AT = null;
  LinkedHashMap<String, List<FileManagerEntity>> R = null;
  public long Yn = -1L;
  public atpo a;
  ScrollerRunnable jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable;
  QfilePinnedHeaderExpandableListView jdField_a_of_type_ComTencentTimFilemanagerWidgetQfilePinnedHeaderExpandableListView;
  private acdl jdField_b_of_type_Acdl = new atrr(this);
  NoFileRelativeLayout jdField_b_of_type_ComTencentTimFilemanagerWidgetNoFileRelativeLayout = null;
  final String bGU = "LastRequestTime";
  boolean cdo = false;
  protected int cloudType = -1;
  Comparator<FileManagerEntity> comparator = new atrl(this);
  private atsn d = new atrq(this);
  public View.OnClickListener eX = new atrn(this);
  public View.OnLongClickListener g = new atrw(this);
  public BubblePopupWindow k = null;
  public View.OnClickListener m = new atrv(this);
  int mFrom = 0;
  LayoutInflater mInflater = null;
  volatile boolean mPaused = false;
  public String mUin;
  public View.OnClickListener n = new atsa(this);
  
  public QfileBaseRecentFileTabView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Atpo = null;
    this.R = new LinkedHashMap();
    this.AT = new ArrayList();
  }
  
  public QfileBaseRecentFileTabView(Context paramContext, String paramString)
  {
    super(paramContext);
    this.jdField_a_of_type_Atpo = null;
    this.mUin = paramString;
    this.R = new LinkedHashMap();
    this.AT = new ArrayList();
  }
  
  private void a(Boolean paramBoolean, List<OfflineFileInfo> paramList)
  {
    long l;
    if ((paramList == null) || (paramList.size() == 0))
    {
      paramBoolean = this.app.getApplication().getSharedPreferences("OfflineFileMerge" + this.app.getCurrentUin(), 0);
      l = System.currentTimeMillis();
      paramBoolean.edit().putLong("LastRequestTime", l).commit();
      QLog.i(TAG, 1, "megre over list size = 0, updata last process time");
      return;
    }
    Collections.sort(paramList, new atru(this));
    paramBoolean = paramList.iterator();
    label512:
    label515:
    for (;;)
    {
      Object localObject;
      label135:
      FileManagerEntity localFileManagerEntity;
      int i;
      if (paramBoolean.hasNext())
      {
        paramList = (OfflineFileInfo)paramBoolean.next();
        localObject = this.AT.iterator();
        if (!((Iterator)localObject).hasNext()) {
          break label512;
        }
        localFileManagerEntity = (FileManagerEntity)((Iterator)localObject).next();
        String str = paramList.bHK.replace("/offline", "");
        if ((localFileManagerEntity.Uuid != null) && (localFileManagerEntity.Uuid.equalsIgnoreCase(str))) {
          i = 1;
        }
      }
      for (;;)
      {
        label194:
        if (i != 0) {
          break label515;
        }
        paramList = audx.a(paramList, 0);
        if (paramList.nFileType == 0) {
          this.app.a().a(paramList, 5);
        }
        for (;;)
        {
          if (QLog.isDevelopLevel()) {
            QLog.i(TAG, 2, "mergeOfflineList,addEntity:fileName[" + paramList.fileName + "],bSend[" + paramList.bSend + "],Uuid[" + paramList.Uuid + "]");
          }
          paramList.bOnceSuccess = true;
          this.app.a().s(paramList);
          g(paramList);
          break;
          if ((Math.abs(localFileManagerEntity.srvTime - paramList.Zn) >= 60000L) || (localFileManagerEntity.fileSize != paramList.nFileSize) || (localFileManagerEntity.peerUin == null) || (!localFileManagerEntity.peerUin.equalsIgnoreCase(String.valueOf(paramList.uFriendUin))) || (localFileManagerEntity.fileName == null) || (!localFileManagerEntity.fileName.equalsIgnoreCase(paramList.strFileName))) {
            break label135;
          }
          i = 1;
          break label194;
          if (paramList.nFileType == 2)
          {
            localObject = this.app.a().a(paramList);
            if (localObject != null) {
              paramList.strThumbPath = ((String)localObject);
            }
          }
        }
        paramBoolean = this.app.getApplication().getSharedPreferences("OfflineFileMerge" + this.app.getCurrentUin(), 0);
        l = System.currentTimeMillis();
        paramBoolean.edit().putLong("LastRequestTime", l).commit();
        QLog.i(TAG, 1, "process over , updata last process time");
        return;
        i = 0;
      }
    }
  }
  
  private void bWr()
  {
    try
    {
      this.jdField_b_of_type_ComTencentTimFilemanagerWidgetNoFileRelativeLayout = new NoFileRelativeLayout(a());
      this.jdField_a_of_type_ComTencentTimFilemanagerWidgetQfilePinnedHeaderExpandableListView.addHeaderView(this.jdField_b_of_type_ComTencentTimFilemanagerWidgetNoFileRelativeLayout);
      dfE();
      this.jdField_b_of_type_ComTencentTimFilemanagerWidgetNoFileRelativeLayout.showLoadingView();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void dgk()
  {
    this.app.a().bi(2, 0, 30);
  }
  
  private void initListView()
  {
    this.jdField_a_of_type_ComTencentTimFilemanagerWidgetQfilePinnedHeaderExpandableListView = ((QfilePinnedHeaderExpandableListView)findViewById(2131367046));
    this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable = new ScrollerRunnable(this.jdField_a_of_type_ComTencentTimFilemanagerWidgetQfilePinnedHeaderExpandableListView);
    this.jdField_a_of_type_ComTencentTimFilemanagerWidgetQfilePinnedHeaderExpandableListView.setSelection(0);
    aqcl.Q(this.jdField_a_of_type_ComTencentTimFilemanagerWidgetQfilePinnedHeaderExpandableListView, false);
    this.jdField_a_of_type_ComTencentTimFilemanagerWidgetQfilePinnedHeaderExpandableListView.setFocusable(false);
  }
  
  public int Ec()
  {
    return 0;
  }
  
  public void IU(boolean paramBoolean) {}
  
  protected abstract atpo a();
  
  public void aa(FileManagerEntity paramFileManagerEntity)
  {
    this.app.a().aIH();
    if (akL()) {
      if (atwb.b(paramFileManagerEntity))
      {
        atwb.b(paramFileManagerEntity);
        if ((this.jdField_b_of_type_ComTencentTimFilemanagerActivityFMActivity.aWg) && (paramFileManagerEntity.cloudType == 3) && (!aueh.fileExistsAndNotEmpty(paramFileManagerEntity.strFilePath)))
        {
          auds.JD(audx.kY(paramFileManagerEntity.fileName) + "为空文件，无法发送！");
          atwb.b(paramFileManagerEntity);
        }
        deR();
        refreshList();
      }
    }
    do
    {
      return;
      atwb.a(paramFileManagerEntity);
      break;
      if (H()) {
        break label129;
      }
    } while (!QLog.isColorLevel());
    QLog.i(TAG, 2, "click too fast , wait a minute.");
    return;
    label129:
    aM();
    audx.I(paramFileManagerEntity);
    Object localObject = new audw.b();
    ((audw.b)localObject).bJE = "file_viewer_in";
    ((audw.b)localObject).cYX = 73;
    ((audw.b)localObject).bJF = aueh.getExtension(paramFileManagerEntity.fileName);
    ((audw.b)localObject).nFileSize = paramFileManagerEntity.fileSize;
    audw.a(this.app.getCurrentAccountUin(), (audw.b)localObject);
    audw.JH("0X8004AE4");
    localObject = new ForwardFileInfo();
    ((ForwardFileInfo)localObject).Oj(paramFileManagerEntity.getCloudType());
    if (this.cloudType == 5) {
      ((ForwardFileInfo)localObject).setType(10010);
    }
    for (;;)
    {
      ((ForwardFileInfo)localObject).p(paramFileManagerEntity.nSessionId);
      ((ForwardFileInfo)localObject).jB(paramFileManagerEntity.uniseq);
      ((ForwardFileInfo)localObject).setFileName(paramFileManagerEntity.fileName);
      ((ForwardFileInfo)localObject).setFileSize(paramFileManagerEntity.fileSize);
      ((ForwardFileInfo)localObject).setUuid(paramFileManagerEntity.Uuid);
      ((ForwardFileInfo)localObject).setLocalPath(paramFileManagerEntity.getFilePath());
      if ((paramFileManagerEntity.TroopUin == 0L) || (TextUtils.isEmpty(paramFileManagerEntity.strTroopFileID)) || (TextUtils.isEmpty(paramFileManagerEntity.strTroopFilePath))) {
        break;
      }
      ((ForwardFileInfo)localObject).jA(paramFileManagerEntity.TroopUin);
      paramFileManagerEntity = new Intent(a(), TroopFileDetailBrowserActivity.class);
      paramFileManagerEntity.putExtra("fileinfo", (Parcelable)localObject);
      paramFileManagerEntity.putExtra("removemementity", true);
      paramFileManagerEntity.putExtra("forward_from_troop_file", true);
      paramFileManagerEntity.putExtra("not_forward", true);
      a().startActivityForResult(paramFileManagerEntity, 102);
      return;
      ((ForwardFileInfo)localObject).setType(10001);
    }
    Intent localIntent = new Intent(a(), FileBrowserActivity.class);
    localIntent.putExtra("fileinfo", (Parcelable)localObject);
    localIntent.putExtra("from_qlink_enter_recent", this.jdField_b_of_type_ComTencentTimFilemanagerActivityFMActivity.akM());
    if ((this.mUin != null) && (this.mUin.trim().length() != 0)) {
      localIntent.putExtra("c2c_discussion_recentfile", this.mUin);
    }
    if (paramFileManagerEntity.nFileType == 2)
    {
      if (aueh.fileExistsAndNotEmpty(paramFileManagerEntity.getFilePath()))
      {
        a().startActivityForResult(localIntent, 102);
        return;
      }
      if ((paramFileManagerEntity.isSend()) && (!aueh.fileExistsAndNotEmpty(paramFileManagerEntity.getFilePath())) && (paramFileManagerEntity.status != 1) && (paramFileManagerEntity.status != -1))
      {
        auds.JD("请在视频发送完查看。");
        return;
      }
      if ((paramFileManagerEntity.status != 2) && (audx.amK()))
      {
        ahal.a(this.jdField_b_of_type_ComTencentTimFilemanagerActivityFMActivity, 2131693826, 2131693828, new atrm(this, localIntent));
        return;
      }
      if (!aqiw.isNetSupport(BaseApplication.getContext()))
      {
        auds.OS(2131693819);
        return;
      }
      a().startActivityForResult(localIntent, 102);
      return;
    }
    a().startActivityForResult(localIntent, 102);
  }
  
  public boolean d(FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity == null) {
      return false;
    }
    return e(paramFileManagerEntity);
  }
  
  abstract void dfD();
  
  public void dfE()
  {
    int i = this.jdField_b_of_type_ComTencentTimFilemanagerActivityFMActivity.getWindow().getDecorView().getHeight();
    int j = (int)(145.0F * aqnm.getDensity());
    this.jdField_b_of_type_ComTencentTimFilemanagerWidgetNoFileRelativeLayout.setLayoutParams(this.jdField_a_of_type_ComTencentTimFilemanagerWidgetQfilePinnedHeaderExpandableListView.getWidth(), i - j);
  }
  
  /* Error */
  void dgj()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 81	com/tencent/tim/filemanager/activity/recentfile/QfileBaseRecentFileTabView:cdo	Z
    //   6: istore_1
    //   7: iload_1
    //   8: ifeq +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: iconst_1
    //   16: putfield 81	com/tencent/tim/filemanager/activity/recentfile/QfileBaseRecentFileTabView:cdo	Z
    //   19: invokestatic 496	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   22: ifeq +13 -> 35
    //   25: getstatic 50	com/tencent/tim/filemanager/activity/recentfile/QfileBaseRecentFileTabView:TAG	Ljava/lang/String;
    //   28: iconst_2
    //   29: ldc_w 711
    //   32: invokestatic 223	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   35: new 713	com/tencent/tim/filemanager/activity/recentfile/QfileBaseRecentFileTabView$2
    //   38: dup
    //   39: aload_0
    //   40: invokespecial 714	com/tencent/tim/filemanager/activity/recentfile/QfileBaseRecentFileTabView$2:<init>	(Lcom/tencent/tim/filemanager/activity/recentfile/QfileBaseRecentFileTabView;)V
    //   43: bipush 8
    //   45: aconst_null
    //   46: iconst_1
    //   47: invokestatic 720	com/tencent/mobileqq/app/ThreadManager:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   50: goto -39 -> 11
    //   53: astore_2
    //   54: aload_0
    //   55: monitorexit
    //   56: aload_2
    //   57: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	58	0	this	QfileBaseRecentFileTabView
    //   6	2	1	bool	boolean
    //   53	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	53	finally
    //   14	35	53	finally
    //   35	50	53	finally
  }
  
  protected boolean e(FileManagerEntity paramFileManagerEntity)
  {
    synchronized (this.AT)
    {
      Iterator localIterator = this.AT.iterator();
      while (localIterator.hasNext()) {
        if (paramFileManagerEntity == (FileManagerEntity)localIterator.next())
        {
          localIterator.remove();
          return true;
        }
      }
      return false;
    }
  }
  
  public void ei(ArrayList<FileManagerEntity> paramArrayList)
  {
    if (paramArrayList == null) {}
    for (;;)
    {
      return;
      int i = 0;
      while (i < paramArrayList.size())
      {
        g((FileManagerEntity)paramArrayList.get(i));
        i += 1;
      }
    }
  }
  
  public void f(FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity == null) {
      return;
    }
    g(paramFileManagerEntity);
  }
  
  public abstract void g(FileManagerEntity paramFileManagerEntity);
  
  protected boolean mX(int paramInt)
  {
    return (this.cloudType != -1) && (this.cloudType != paramInt);
  }
  
  public void onCreate()
  {
    int i = 0;
    setContentView(2131561024);
    this.mInflater = LayoutInflater.from(a());
    this.app.a().addObserver(this.d);
    this.app.addObserver(this.jdField_b_of_type_Acdl);
    this.jdField_a_of_type_Atpo = a();
    initListView();
    bWr();
    this.jdField_a_of_type_ComTencentTimFilemanagerWidgetQfilePinnedHeaderExpandableListView.setSelector(2131167595);
    this.jdField_a_of_type_ComTencentTimFilemanagerWidgetQfilePinnedHeaderExpandableListView.setGroupIndicator(a().getResources().getDrawable(2130839740));
    if ((this.jdField_a_of_type_Atpo instanceof atps))
    {
      this.jdField_a_of_type_ComTencentTimFilemanagerWidgetQfilePinnedHeaderExpandableListView.setSelector(2131167595);
      this.jdField_a_of_type_ComTencentTimFilemanagerWidgetQfilePinnedHeaderExpandableListView.setGroupIndicator(a().getResources().getDrawable(2130839740));
      this.jdField_a_of_type_ComTencentTimFilemanagerWidgetQfilePinnedHeaderExpandableListView.setWhetherImageTab(true);
      this.jdField_a_of_type_ComTencentTimFilemanagerWidgetQfilePinnedHeaderExpandableListView.setGridSize(((atps)this.jdField_a_of_type_Atpo).Eb());
      this.jdField_a_of_type_ComTencentTimFilemanagerWidgetQfilePinnedHeaderExpandableListView.setAdapter(this.jdField_a_of_type_Atpo);
      this.jdField_a_of_type_ComTencentTimFilemanagerWidgetQfilePinnedHeaderExpandableListView.setTranscriptMode(0);
      i = 0;
      while (i < this.jdField_a_of_type_Atpo.getGroupCount())
      {
        this.jdField_a_of_type_ComTencentTimFilemanagerWidgetQfilePinnedHeaderExpandableListView.expandGroup(i);
        i += 1;
      }
    }
    this.jdField_a_of_type_ComTencentTimFilemanagerWidgetQfilePinnedHeaderExpandableListView.setSelector(2131167595);
    this.jdField_a_of_type_ComTencentTimFilemanagerWidgetQfilePinnedHeaderExpandableListView.setGroupIndicator(a().getResources().getDrawable(2130839740));
    this.jdField_a_of_type_ComTencentTimFilemanagerWidgetQfilePinnedHeaderExpandableListView.setWhetherImageTab(false);
    this.jdField_a_of_type_ComTencentTimFilemanagerWidgetQfilePinnedHeaderExpandableListView.setAdapter(this.jdField_a_of_type_Atpo);
    this.jdField_a_of_type_ComTencentTimFilemanagerWidgetQfilePinnedHeaderExpandableListView.setTranscriptMode(0);
    while (i < this.jdField_a_of_type_Atpo.getGroupCount())
    {
      this.jdField_a_of_type_ComTencentTimFilemanagerWidgetQfilePinnedHeaderExpandableListView.expandGroup(i);
      i += 1;
    }
    if ((this.jdField_a_of_type_Atpo instanceof atps))
    {
      this.jdField_a_of_type_ComTencentTimFilemanagerWidgetQfilePinnedHeaderExpandableListView.getViewTreeObserver().addOnGlobalLayoutListener(new atrs(this));
      return;
    }
    this.jdField_a_of_type_ComTencentTimFilemanagerWidgetQfilePinnedHeaderExpandableListView.getViewTreeObserver().addOnGlobalLayoutListener(new atrt(this));
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable.stop();
    }
    this.AT.clear();
    this.R.clear();
    dge();
    if (this.d != null) {
      this.app.a().deleteObserver(this.d);
    }
    if (this.jdField_b_of_type_Acdl != null) {
      this.app.removeObserver(this.jdField_b_of_type_Acdl);
    }
    this.app.a().aIH();
    this.app.a().dgm();
  }
  
  public void onResume()
  {
    dgj();
    this.jdField_b_of_type_ComTencentTimFilemanagerActivityFMActivity.IM(this.jdField_b_of_type_ComTencentTimFilemanagerActivityFMActivity.akL());
    refreshUI();
  }
  
  public void onStart()
  {
    this.jdField_b_of_type_ComTencentTimFilemanagerActivityFMActivity.IM(this.jdField_b_of_type_ComTencentTimFilemanagerActivityFMActivity.akL());
  }
  
  public void refreshList()
  {
    if ((this.R == null) || (this.R.size() == 0))
    {
      this.jdField_b_of_type_ComTencentTimFilemanagerWidgetNoFileRelativeLayout.aaF(2131693539);
      this.jdField_a_of_type_ComTencentTimFilemanagerWidgetQfilePinnedHeaderExpandableListView.setEnabled(false);
    }
    for (;;)
    {
      this.jdField_a_of_type_Atpo.notifyDataSetChanged();
      return;
      if (this.jdField_b_of_type_ComTencentTimFilemanagerWidgetNoFileRelativeLayout != null)
      {
        this.jdField_b_of_type_ComTencentTimFilemanagerWidgetNoFileRelativeLayout.setGone();
        this.jdField_a_of_type_ComTencentTimFilemanagerWidgetQfilePinnedHeaderExpandableListView.setEnabled(true);
      }
    }
  }
  
  public void refreshUI()
  {
    runOnUiThread(new QfileBaseRecentFileTabView.13(this));
  }
  
  public void resetData()
  {
    if ((this.AT != null) && (this.AT.size() > 0)) {
      dfD();
    }
  }
  
  public void setCloudType(int paramInt)
  {
    this.cloudType = paramInt;
  }
  
  public void setSelect(int paramInt)
  {
    if (this.jdField_a_of_type_Atpo.getGroupCount() <= paramInt)
    {
      QLog.e(TAG, 1, "setSelect[" + paramInt + "] faild,becouse GroupCount[" + this.jdField_a_of_type_Atpo.getGroupCount() + "]");
      return;
    }
    runOnUiThread(new QfileBaseRecentFileTabView.14(this, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.filemanager.activity.recentfile.QfileBaseRecentFileTabView
 * JD-Core Version:    0.7.0.1
 */