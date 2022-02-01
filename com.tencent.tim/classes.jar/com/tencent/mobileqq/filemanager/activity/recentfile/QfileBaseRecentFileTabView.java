package com.tencent.mobileqq.filemanager.activity.recentfile;

import acdl;
import acfp;
import aeub;
import aeuc;
import agdq;
import agdw;
import aggf;
import aggg;
import aggh;
import aggi;
import aggj;
import aggk;
import aggl;
import aggm;
import aggp;
import aggq;
import aggs;
import aghq;
import aghw;
import agib;
import agie;
import agkf;
import agkh;
import agmz;
import agvl;
import agvn;
import agvq;
import ahao;
import ahau;
import ahau.a;
import ahav;
import ahbj;
import ahbr;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.PorterDuff.Mode;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import anot;
import aobw;
import aqcl;
import aqgq;
import aqha;
import aqha.a;
import aqiw;
import aqju;
import aqoa;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.activity.fileassistant.QfileBaseTabView;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.OfflineFileInfo;
import com.tencent.mobileqq.filemanager.widget.NoFileRelativeLayout;
import com.tencent.mobileqq.filemanager.widget.QfilePinnedHeaderExpandableListView;
import com.tencent.mobileqq.widget.ScrollerRunnable;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.BubblePopupWindow;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import mqq.app.MobileQQ;
import sxx;

public abstract class QfileBaseRecentFileTabView
  extends QfileBaseTabView
{
  public static String TAG = "<FileAssistant>";
  List<FileManagerEntity> AT = null;
  View CM = null;
  public View CN = null;
  LinkedHashMap<String, List<FileManagerEntity>> R = null;
  TextView St = null;
  public long Yn = -1L;
  private aghq jdField_a_of_type_Aghq = new aggg(this);
  private agie jdField_a_of_type_Agie = new aggp(this);
  ScrollerRunnable jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable;
  private acdl jdField_b_of_type_Acdl = new aggh(this);
  public agdq b;
  NoFileRelativeLayout jdField_b_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout = null;
  QfilePinnedHeaderExpandableListView jdField_b_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView;
  final String bGU = "LastRequestTime";
  private int cWT;
  boolean cdo = false;
  Comparator<FileManagerEntity> comparator = new aggf(this);
  public View.OnClickListener eX = new aggm(this);
  public View.OnLongClickListener g = new a();
  BubblePopupWindow k = null;
  public View.OnClickListener m = new aggk(this);
  int mFrom = 0;
  LayoutInflater mInflater = null;
  volatile boolean mPaused = false;
  public String mUin;
  public View.OnClickListener n = new aggl(this);
  
  public QfileBaseRecentFileTabView(Context paramContext)
  {
    super(paramContext);
    this.jdField_b_of_type_Agdq = null;
    this.R = new LinkedHashMap();
    this.AT = new ArrayList();
  }
  
  public QfileBaseRecentFileTabView(Context paramContext, String paramString)
  {
    super(paramContext);
    this.jdField_b_of_type_Agdq = null;
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
    Collections.sort(paramList, new aggi(this));
    paramBoolean = paramList.iterator();
    label513:
    label516:
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
          break label513;
        }
        localFileManagerEntity = (FileManagerEntity)((Iterator)localObject).next();
        String str = paramList.bHK.replace("/offline", "");
        if ((localFileManagerEntity.Uuid != null) && (localFileManagerEntity.Uuid.equalsIgnoreCase(str))) {
          i = 1;
        }
      }
      for (;;)
      {
        label195:
        if (i != 0) {
          break label516;
        }
        paramList = ahav.a(paramList, 0);
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
          break label195;
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
  
  private void a(boolean paramBoolean, FileManagerEntity paramFileManagerEntity)
  {
    String str2 = "";
    String str1;
    if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.akP()) && (!paramBoolean)) {
      if ((this instanceof QfileRecentAllFileTabView))
      {
        if ((paramFileManagerEntity.nFileType == 13) && (this.cWT == 1)) {
          anot.a(this.app, "dc00898", "", "", "0X800A072", "0X800A072", 0, 0, "", "", "", "");
        }
        str1 = "0X8009E3F";
      }
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(str1)) {
        anot.a(this.app, "dc00898", "", "", str1, str1, 0, 0, "", "", "", "");
      }
      return;
      if ((this instanceof QfileRecentAppFileTabView))
      {
        str1 = "0X8009E76";
      }
      else if ((this instanceof QfileRecentDocFileTabView))
      {
        str1 = "0X8009E40";
      }
      else if ((this instanceof QfileRecentMediaFileTabView))
      {
        str1 = "0X8009E75";
      }
      else if ((this instanceof QfileRecentPicFileTabView))
      {
        str1 = "0X8009E41";
      }
      else
      {
        str1 = str2;
        if ((this instanceof QfileRecentTencentDocFileTabView))
        {
          str1 = "0X800A07A";
          continue;
          str1 = str2;
          if (!this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.akP()) {
            if ((this instanceof QfileRecentAllFileTabView))
            {
              if ((paramFileManagerEntity.nFileType == 13) && (this.cWT == 2)) {
                anot.a(this.app, "dc00898", "", "", "0X800A087", "0X800A087", 0, 0, "", "", "", "");
              }
              str1 = "0X8009E51";
            }
            else if ((this instanceof QfileRecentAppFileTabView))
            {
              str1 = "0X8009E6D";
            }
            else if ((this instanceof QfileRecentDocFileTabView))
            {
              str1 = "0X8009E52";
            }
            else if ((this instanceof QfileRecentMediaFileTabView))
            {
              str1 = "0X8009E6C";
            }
            else if ((this instanceof QfileRecentPicFileTabView))
            {
              str1 = "0X8009E53";
            }
            else
            {
              str1 = str2;
              if ((this instanceof QfileRecentTencentDocFileTabView))
              {
                str1 = str2;
                if (this.cWT == 2) {
                  str1 = "0X800A08C";
                }
              }
            }
          }
        }
      }
    }
  }
  
  private boolean alb()
  {
    if ((ahav.bm(getContext())) && (this.R != null) && (this.R.size() > 0))
    {
      Iterator localIterator = this.R.keySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (String)localIterator.next();
        localObject = ((List)this.R.get(localObject)).iterator();
        if (((Iterator)localObject).hasNext())
        {
          FileManagerEntity localFileManagerEntity = (FileManagerEntity)((Iterator)localObject).next();
          if (localFileManagerEntity.fileSize > agmz.fM()) {}
          for (int i = 1;; i = 0)
          {
            boolean bool = ahav.aZ(localFileManagerEntity.fileName, a().bGo);
            if ((i == 0) && (bool)) {
              break;
            }
            return true;
          }
        }
      }
    }
    return false;
  }
  
  private void bWr()
  {
    try
    {
      this.jdField_b_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout = new NoFileRelativeLayout(a());
      this.jdField_b_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout.setText(2131693539);
      this.jdField_b_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout.setVisible(false);
      this.jdField_b_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.addHeaderView(this.jdField_b_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout);
      this.jdField_b_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout.setGone();
      this.CM = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getLayoutInflater().inflate(2131563166, null, false);
      this.CN = this.CM.findViewById(2131379739);
      this.St = ((TextView)this.CM.findViewById(2131379450));
      ((ImageView)this.CM.findViewById(2131370365)).setColorFilter(-15550475, PorterDuff.Mode.MULTIPLY);
      ((ImageView)this.CM.findViewById(2131364677)).setOnClickListener(new aggj(this));
      this.jdField_b_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.addHeaderView(this.CM);
      this.CN.setVisibility(8);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void dgk()
  {
    this.app.a().a(0, 30, this.jdField_a_of_type_Agie);
    this.app.a().b(0, 30, this.jdField_a_of_type_Agie);
  }
  
  private void i(FileManagerEntity paramFileManagerEntity)
  {
    if (agmz.b(paramFileManagerEntity)) {
      agmz.b(paramFileManagerEntity);
    }
    for (;;)
    {
      if (((this instanceof QfileRecentDocFileTabView)) || ((this instanceof QfileRecentAllFileTabView))) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.setDocsCheck(true);
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.aWg) && (paramFileManagerEntity.cloudType == 3) && (!ahbj.fileExistsAndNotEmpty(paramFileManagerEntity.getFilePath())))
      {
        ahao.JD(ahav.kY(paramFileManagerEntity.fileName) + acfp.m(2131711029));
        agmz.b(paramFileManagerEntity);
      }
      deR();
      refreshList();
      return;
      agmz.a(paramFileManagerEntity);
      if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.akO()) && (!agmz.hasFlag(agmz.cXZ)) && (!agmz.n(paramFileManagerEntity)))
      {
        aqju localaqju = aqha.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, 2131700303);
        localaqju.setPositiveButton(2131721303, new aqha.a());
        localaqju.show();
        agmz.setFlag(agmz.cXZ);
        ahau.JH("0X800942D");
      }
    }
  }
  
  private void initListView()
  {
    this.jdField_b_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView = ((QfilePinnedHeaderExpandableListView)findViewById(2131367046));
    this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable = new ScrollerRunnable(this.jdField_b_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView);
    this.jdField_b_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setSelection(0);
    aqcl.Q(this.jdField_b_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView, false);
    this.jdField_b_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setFocusable(false);
  }
  
  public int Ec()
  {
    return 0;
  }
  
  public void IU(boolean paramBoolean) {}
  
  protected abstract agdq a();
  
  public void a(FileManagerEntity paramFileManagerEntity, View paramView, boolean paramBoolean)
  {
    this.app.a().aIH();
    if ((akL()) && (!paramBoolean)) {
      i(paramFileManagerEntity);
    }
    for (;;)
    {
      a(akL(), paramFileManagerEntity);
      do
      {
        return;
        if (H()) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.i(TAG, 2, "click too fast , wait a minute.");
      return;
      aM();
      Object localObject = new ahau.a();
      ((ahau.a)localObject).bJE = "file_viewer_in";
      ((ahau.a)localObject).cYX = 73;
      if (paramFileManagerEntity.nFileType == 13) {}
      for (((ahau.a)localObject).bJF = "tencentdoc_ext";; ((ahau.a)localObject).bJF = ahbj.getExtension(paramFileManagerEntity.fileName))
      {
        ((ahau.a)localObject).nFileSize = paramFileManagerEntity.fileSize;
        ahau.a(this.app.getCurrentAccountUin(), (ahau.a)localObject);
        ahau.JH("0X8004AE4");
        localObject = new agvl(this.app, this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, paramFileManagerEntity, 10001);
        Bundle localBundle = new Bundle();
        localBundle.putBoolean("from_qlink_enter_recent", this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.akM());
        if ((this.mUin != null) && (this.mUin.trim().length() != 0)) {
          localBundle.putString("c2c_discussion_recentfile", this.mUin);
        }
        ((agvl)localObject).cB(localBundle);
        localObject = new agvn(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, (agvq)localObject);
        ((agvn)localObject).Oy(7);
        if (((paramFileManagerEntity.nFileType == 0) || (paramFileManagerEntity.nFileType == 2)) && (paramView != null) && ((paramView.getId() == 2131367020) || (paramView.getId() == 2131368820)))
        {
          ((agvn)localObject).k(sxx.getViewRect(paramView));
          ((agvn)localObject).JE(true);
        }
        if (paramFileManagerEntity.nFileType != 2) {
          break label398;
        }
        if (!ahbj.fileExistsAndNotEmpty(paramFileManagerEntity.getFilePath())) {
          break;
        }
        ((agvn)localObject).djN();
        return;
      }
      if ((paramFileManagerEntity.isSend()) && (!ahbj.fileExistsAndNotEmpty(paramFileManagerEntity.getFilePath())) && (paramFileManagerEntity.status != 1) && (paramFileManagerEntity.status != -1))
      {
        ahao.JD(acfp.m(2131711028));
        return;
      }
      if (!aqiw.isNetSupport(BaseApplication.getContext()))
      {
        ahao.OS(2131693819);
        return;
      }
      ((agvn)localObject).djN();
      continue;
      label398:
      if (paramFileManagerEntity.nFileType == 13)
      {
        if ((this instanceof QfileRecentAllFileTabView)) {
          aobw.a(paramFileManagerEntity.Uuid, this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, 3, paramFileManagerEntity, this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.app);
        } else if ((this instanceof QfileRecentTencentDocFileTabView)) {
          aobw.a(paramFileManagerEntity.Uuid, this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, 20, paramFileManagerEntity, this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.app);
        }
      }
      else {
        ((agvn)localObject).djN();
      }
    }
  }
  
  public ListView b()
  {
    return this.jdField_b_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView;
  }
  
  public void clearAllForTest() {}
  
  public boolean d(FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity == null) {
      return false;
    }
    return e(paramFileManagerEntity);
  }
  
  abstract void dfD();
  
  protected void dfE()
  {
    int i = this.jdField_b_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.getMeasuredHeight();
    QLog.d(TAG, 2, "================================================================> 高度为" + i);
    if (this.jdField_b_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout != null)
    {
      this.jdField_b_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout.setLayoutParams(this.jdField_b_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.getWidth(), i);
      View localView = this.jdField_b_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout.findViewById(2131380067);
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)localView.getLayoutParams();
      localLayoutParams.height = 0;
      localView.setLayoutParams(localLayoutParams);
    }
  }
  
  /* Error */
  void dgj()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 92	com/tencent/mobileqq/filemanager/activity/recentfile/QfileBaseRecentFileTabView:cdo	Z
    //   6: istore_1
    //   7: iload_1
    //   8: ifeq +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: iconst_1
    //   16: putfield 92	com/tencent/mobileqq/filemanager/activity/recentfile/QfileBaseRecentFileTabView:cdo	Z
    //   19: invokestatic 707	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   22: ifeq +13 -> 35
    //   25: getstatic 57	com/tencent/mobileqq/filemanager/activity/recentfile/QfileBaseRecentFileTabView:TAG	Ljava/lang/String;
    //   28: iconst_2
    //   29: ldc_w 871
    //   32: invokestatic 233	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   35: invokestatic 298	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   38: ifeq +41 -> 79
    //   41: ldc_w 873
    //   44: iconst_1
    //   45: new 183	java/lang/StringBuilder
    //   48: dup
    //   49: invokespecial 184	java/lang/StringBuilder:<init>	()V
    //   52: ldc_w 875
    //   55: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: invokestatic 881	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   61: invokevirtual 883	java/lang/Thread:getId	()J
    //   64: invokevirtual 886	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   67: ldc_w 888
    //   70: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: invokevirtual 197	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   76: invokestatic 890	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   79: new 892	com/tencent/mobileqq/filemanager/activity/recentfile/QfileBaseRecentFileTabView$2
    //   82: dup
    //   83: aload_0
    //   84: invokespecial 893	com/tencent/mobileqq/filemanager/activity/recentfile/QfileBaseRecentFileTabView$2:<init>	(Lcom/tencent/mobileqq/filemanager/activity/recentfile/QfileBaseRecentFileTabView;)V
    //   87: bipush 8
    //   89: aconst_null
    //   90: iconst_1
    //   91: invokestatic 899	com/tencent/mobileqq/app/ThreadManager:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   94: goto -83 -> 11
    //   97: astore_2
    //   98: aload_0
    //   99: monitorexit
    //   100: aload_2
    //   101: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	102	0	this	QfileBaseRecentFileTabView
    //   6	2	1	bool	boolean
    //   97	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	97	finally
    //   14	35	97	finally
    //   35	79	97	finally
    //   79	94	97	finally
  }
  
  public View e()
  {
    return this.jdField_b_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView;
  }
  
  protected boolean e(FileManagerEntity paramFileManagerEntity)
  {
    synchronized (this.AT)
    {
      if (QLog.isDevelopLevel()) {
        QLog.e("crashBUG", 1, "Thread id: " + Thread.currentThread().getId() + " delRecent");
      }
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
  
  public void h(FileManagerEntity paramFileManagerEntity)
  {
    ahbr.b(this.app, this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, paramFileManagerEntity);
  }
  
  protected void kF(List<FileManagerEntity> paramList)
  {
    if (paramList == null) {}
    for (;;)
    {
      return;
      if (this.AT != null) {
        this.AT.clear();
      }
      if (this.AT == null) {
        this.AT = new ArrayList();
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity == null) || (!this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.akI()) || (!this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.akN())) {
        break;
      }
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        FileManagerEntity localFileManagerEntity = (FileManagerEntity)paramList.next();
        if (!ahbr.w(localFileManagerEntity)) {
          this.AT.add(localFileManagerEntity);
        }
      }
    }
    this.AT.addAll(paramList);
  }
  
  public void onCreate()
  {
    int i = 0;
    setContentView(2131561024);
    this.mInflater = LayoutInflater.from(a());
    this.app.a().addObserver(this.jdField_a_of_type_Aghq);
    this.app.addObserver(this.jdField_b_of_type_Acdl);
    initListView();
    this.jdField_b_of_type_Agdq = a();
    this.jdField_b_of_type_Agdq.a(this.jdField_b_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView);
    bWr();
    this.jdField_b_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setSelector(2131167595);
    if ((this.jdField_b_of_type_Agdq instanceof agdw))
    {
      this.jdField_b_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setSelector(2131167595);
      this.jdField_b_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setWhetherImageTab(true);
      this.jdField_b_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setGridSize(((agdw)this.jdField_b_of_type_Agdq).Eb());
      this.jdField_b_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setAdapter(this.jdField_b_of_type_Agdq);
      this.jdField_b_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setTranscriptMode(0);
      i = 0;
      while (i < this.jdField_b_of_type_Agdq.getGroupCount())
      {
        this.jdField_b_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.expandGroup(i);
        i += 1;
      }
    }
    this.jdField_b_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setSelector(2131167595);
    this.jdField_b_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setWhetherImageTab(false);
    this.jdField_b_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setAdapter(this.jdField_b_of_type_Agdq);
    this.jdField_b_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setTranscriptMode(0);
    while (i < this.jdField_b_of_type_Agdq.getGroupCount())
    {
      this.jdField_b_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.expandGroup(i);
      i += 1;
    }
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable.stop();
    }
    if (QLog.isDevelopLevel()) {
      QLog.e("crashBUG", 1, "Thread id: " + Thread.currentThread().getId() + " onDestroy");
    }
    this.AT.clear();
    this.R.clear();
    dge();
    if (this.jdField_a_of_type_Aghq != null) {
      this.app.a().deleteObserver(this.jdField_a_of_type_Aghq);
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
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.IM(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.akL());
    refreshUI();
  }
  
  public void onStart()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.IM(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.akL());
  }
  
  public void refreshList()
  {
    if ((this.R == null) || (this.R.size() == 0))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.akP()) {
        this.jdField_b_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout.setTopViewHeight(0.2F);
      }
      this.jdField_b_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout.setVisible(true);
      if ((this instanceof QfileRecentTencentDocFileTabView))
      {
        this.jdField_b_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout.dmx();
        anot.a(a().app, "dc00898", "", "", "0X800A225", "0X800A225", 0, 0, "", "", "", "");
        this.jdField_b_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setEnabled(false);
        this.CN.setVisibility(8);
      }
    }
    for (;;)
    {
      dfE();
      this.jdField_b_of_type_Agdq.notifyDataSetChanged();
      return;
      if ((this instanceof QfileRecentTDocFileTabView))
      {
        this.jdField_b_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout.dmx();
        anot.a(a().app, "dc00898", "", "", "0X800A08B", "0X800A08B", 0, 0, "", "", "", "");
        break;
      }
      this.jdField_b_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout.dmy();
      break;
      if (this.jdField_b_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout != null)
      {
        this.jdField_b_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout.setGone();
        this.jdField_b_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.removeHeaderView(this.jdField_b_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout);
        this.jdField_b_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setEnabled(true);
        if (alb())
        {
          String str = aeuc.a().ub();
          if (TextUtils.isEmpty(str))
          {
            this.CN.setVisibility(8);
          }
          else
          {
            this.CN.setVisibility(0);
            this.St.setText(str);
          }
        }
        else
        {
          this.CN.setVisibility(8);
        }
      }
    }
  }
  
  public void refreshUI()
  {
    runOnUiThread(new QfileBaseRecentFileTabView.11(this));
  }
  
  public void resetData()
  {
    if ((this.AT != null) && (this.AT.size() > 0))
    {
      dfD();
      if (QLog.isDevelopLevel()) {
        QLog.e("crashBUG", 1, "Thread id: " + Thread.currentThread().getId() + " resetData -> getRecentFileRecords ");
      }
    }
  }
  
  public void setAttribution(int paramInt)
  {
    this.cWT = paramInt;
  }
  
  public void setSelect(int paramInt)
  {
    if (this.jdField_b_of_type_Agdq.getGroupCount() <= paramInt)
    {
      QLog.e(TAG, 1, "setSelect[" + paramInt + "] faild,becouse GroupCount[" + this.jdField_b_of_type_Agdq.getGroupCount() + "]");
      return;
    }
    runOnUiThread(new QfileBaseRecentFileTabView.12(this, paramInt));
  }
  
  public class a
    implements View.OnLongClickListener
  {
    a() {}
    
    public boolean onLongClick(View paramView)
    {
      if ((paramView == null) || (QfileBaseRecentFileTabView.a(QfileBaseRecentFileTabView.this))) {
        return false;
      }
      paramView.setSelected(true);
      aqoa localaqoa = new aqoa();
      localaqoa.dV(2131367525, paramView.getContext().getString(2131721067));
      localaqoa.dV(2131365679, paramView.getContext().getString(2131692505));
      ApolloUtil.a(paramView, QfileBaseRecentFileTabView.n(QfileBaseRecentFileTabView.this), localaqoa);
      QfileBaseRecentFileTabView.this.k = aqgq.a(paramView, localaqoa, new aggq(this, paramView), new aggs(this, paramView));
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.recentfile.QfileBaseRecentFileTabView
 * JD-Core Version:    0.7.0.1
 */