package com.tencent.mobileqq.filemanager.activity.localfile;

import acfp;
import agdq;
import agdu;
import agex;
import agfn;
import agfo;
import agfp;
import agfq;
import agfu;
import agfv;
import agfw;
import aghq;
import aghw;
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
import ahbk;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import anot;
import aqha;
import aqha.a;
import aqju;
import com.tencent.mm.vfs.VFSFile;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.activity.fileassistant.QfileBaseTabView;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.widget.NoFileRelativeLayout;
import com.tencent.mobileqq.filemanager.widget.QfilePinnedHeaderExpandableListView;
import com.tencent.mobileqq.filemanager.widget.QfileTabBarView.a;
import com.tencent.mobileqq.filemanager.widget.ViewerMoreRelativeLayout;
import com.tencent.mobileqq.widget.ScrollerRunnable;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.BubblePopupWindow;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;
import sxx;

public abstract class QfileBaseLocalFileTabView
  extends QfileBaseTabView
{
  public static String TAG = "QfileBaseLocalFileTabView<FileAssistant>";
  public List<QfileTabBarView.a> AS;
  protected LinkedHashMap<String, List<FileInfo>> R;
  private aghq jdField_a_of_type_Aghq = new agfw(this);
  public ViewerMoreRelativeLayout a;
  ScrollerRunnable jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable;
  public agdq b;
  ahbk jdField_b_of_type_Ahbk = null;
  NoFileRelativeLayout jdField_b_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout = null;
  protected QfilePinnedHeaderExpandableListView b;
  protected boolean cde;
  protected boolean cdi;
  boolean cdj;
  public View.OnClickListener eW = new agfp(this);
  public View.OnClickListener eX = new agfv(this);
  public View.OnLongClickListener g = new agfq(this);
  public BubblePopupWindow k = null;
  public View.OnClickListener m = new agfo(this);
  LayoutInflater mInflater = null;
  public View.OnClickListener n = new agfu(this);
  protected ArrayList<FileInfo> wB;
  
  public QfileBaseLocalFileTabView(Context paramContext, List<QfileTabBarView.a> paramList, boolean paramBoolean)
  {
    super(paramContext);
    this.AS = paramList;
    this.cdi = paramBoolean;
    this.R = new LinkedHashMap();
    this.wB = new ArrayList();
  }
  
  private boolean Z(String paramString, int paramInt)
  {
    paramString = ahbj.getExtension(paramString);
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      do
      {
        return false;
        paramString = paramString.toLowerCase();
      } while (((paramInt == 0) && (!".jpg|.bmp|.jpeg|.gif|.png|.ico|".contains(paramString))) || ((paramInt == 2) && (!".swf|.mov|.mp4|.3gp|.avi|.rmvb|.wmf|.mpg|.rm|.asf|.mpeg|.mkv|.wmv|.flv|.f4v|.webm|.mod|.mpe|.fla|.m4r|.m4u|.m4v|.vob|".contains(paramString))));
      if (paramInt != 3) {
        break;
      }
    } while ((!".doc|.docx|.wps|.pages|".contains(paramString)) && (!".xls|.xlsx|.et|.numbers|".contains(paramString)) && (!".pdf|".contains(paramString)) && (!".ppt|.pptx.|.dps|.keynote|".contains(paramString)));
    do
    {
      do
      {
        return true;
        if ((paramInt == 5) && (!".apk|".contains(paramString))) {
          break;
        }
      } while (paramInt != 11);
      if ((".jpg|.bmp|.jpeg|.gif|.png|.ico|".contains(paramString)) || (".swf|.mov|.mp4|.3gp|.avi|.rmvb|.wmf|.mpg|.rm|.asf|.mpeg|.mkv|.wmv|.flv|.f4v|.webm|.mod|.mpe|.fla|.m4r|.m4u|.m4v|.vob|".contains(paramString)) || (".doc|.docx|.wps|.pages|".contains(paramString)) || (".xls|.xlsx|.et|.numbers|".contains(paramString)) || (".pdf|".contains(paramString)) || (".ppt|.pptx.|.dps|.keynote|".contains(paramString))) {
        break;
      }
    } while (!".apk|".contains(paramString));
    return false;
  }
  
  private void bWr()
  {
    try
    {
      this.jdField_b_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout = new NoFileRelativeLayout(a());
      this.jdField_b_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout.setText(2131693529);
      this.jdField_b_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.post(new QfileBaseLocalFileTabView.1(this));
      this.jdField_b_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.addHeaderView(this.jdField_b_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetViewerMoreRelativeLayout = new ViewerMoreRelativeLayout(a());
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetViewerMoreRelativeLayout.setOnClickListener(this.eW);
      this.jdField_b_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.addFooterView(this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetViewerMoreRelativeLayout);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void initListView()
  {
    this.jdField_b_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView = ((QfilePinnedHeaderExpandableListView)findViewById(2131367046));
    this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable = new ScrollerRunnable(this.jdField_b_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView);
    this.jdField_b_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setSelection(0);
    this.jdField_b_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setFocusable(false);
  }
  
  public int Ec()
  {
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetViewerMoreRelativeLayout.getHeight();
  }
  
  public void IU(boolean paramBoolean) {}
  
  protected void IW(boolean paramBoolean)
  {
    String str2 = "";
    String str1;
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.akQ()) {
      if ((this instanceof QfileLocalFileMediaTabView))
      {
        str1 = "0x8009DAF";
        anot.a(this.app, "dc00898", "", "", str1, str1, 0, 0, "", "", "", "");
      }
    }
    for (;;)
    {
      return;
      if ((this instanceof QfileLocalFilePicTabView))
      {
        str1 = "0x8009DB1";
        break;
      }
      if ((this instanceof QfileLocalFileDocTabView))
      {
        str1 = "0x8009DB3";
        break;
      }
      if ((this instanceof QfileLocalFileAppTabView))
      {
        str1 = "0x8009DB5";
        break;
      }
      str1 = str2;
      if (!(this instanceof QfileLocalFileOtherTabView)) {
        break;
      }
      str1 = "0x8009DB7";
      break;
      if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.akP()) && (!paramBoolean)) {
        if ((this instanceof QfileLocalFileMediaTabView)) {
          str1 = "0X8009E49";
        }
      }
      while (!TextUtils.isEmpty(str1))
      {
        anot.a(this.app, "dc00898", "", "", str1, str1, 0, 0, "", "", "", "");
        return;
        if ((this instanceof QfileLocalFilePicTabView))
        {
          str1 = "0X8009E46";
        }
        else if ((this instanceof QfileLocalFileDocTabView))
        {
          str1 = "0X8009E44";
        }
        else if ((this instanceof QfileLocalFileAppTabView))
        {
          str1 = "0X8009E4C";
        }
        else
        {
          str1 = str2;
          if ((this instanceof QfileLocalFileOtherTabView))
          {
            str1 = "0X8009E48";
            continue;
            str1 = str2;
            if (!this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.akP()) {
              if ((this instanceof QfileLocalFileMediaTabView))
              {
                str1 = "0X8009E5B";
              }
              else if ((this instanceof QfileLocalFilePicTabView))
              {
                str1 = "0X8009E58";
              }
              else if ((this instanceof QfileLocalFileDocTabView))
              {
                str1 = "0X8009E56";
              }
              else if ((this instanceof QfileLocalFileAppTabView))
              {
                str1 = "0X8009E5E";
              }
              else
              {
                str1 = str2;
                if ((this instanceof QfileLocalFileOtherTabView)) {
                  str1 = "0X8009E5A";
                }
              }
            }
          }
        }
      }
    }
  }
  
  protected void Nx()
  {
    if (this.jdField_b_of_type_Ahbk != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.a(this.jdField_b_of_type_Ahbk);
      return;
    }
    this.jdField_b_of_type_Ahbk = new agfn(this);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.a(this.jdField_b_of_type_Ahbk);
  }
  
  protected abstract agdq a();
  
  public void a(FileInfo paramFileInfo)
  {
    if (paramFileInfo == null) {
      return;
    }
    b(paramFileInfo);
  }
  
  public void a(FileInfo paramFileInfo, View paramView, boolean paramBoolean)
  {
    this.app.a().aIH();
    if ((akL()) && (!paramBoolean)) {
      if (agmz.d(paramFileInfo))
      {
        agmz.e(paramFileInfo);
        b(paramFileInfo, false);
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.setDocsCheck(true);
        if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.aWg) && (!ahbj.fileExistsAndNotEmpty(paramFileInfo.getPath())))
        {
          ahao.JD(ahav.kY(paramFileInfo.getName()) + acfp.m(2131711039));
          agmz.e(paramFileInfo);
        }
        refreshList();
        deR();
        dgf();
      }
    }
    for (;;)
    {
      IW(akL());
      do
      {
        return;
        agmz.d(paramFileInfo);
        b(paramFileInfo, true);
        if ((!this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.akO()) || (agmz.hasFlag(agmz.cXZ)) || (agmz.e(paramFileInfo))) {
          break;
        }
        paramView = aqha.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, 2131700303);
        paramView.setPositiveButton(2131721303, new aqha.a());
        paramView.show();
        agmz.setFlag(agmz.cXZ);
        ahau.JH("0X800942D");
        break;
        if (H()) {
          break label228;
        }
      } while (!QLog.isColorLevel());
      QLog.i(TAG, 2, "click too fast , wait a minute.");
      return;
      label228:
      aM();
      FileManagerEntity localFileManagerEntity = ahav.a(paramFileInfo);
      Object localObject1 = new agvl(this.app, this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, localFileManagerEntity, 10000);
      if (localFileManagerEntity.nFileType == 0)
      {
        Object localObject2 = new ArrayList();
        if (this.R != null)
        {
          Iterator localIterator = this.R.keySet().iterator();
          while (localIterator.hasNext())
          {
            String str = (String)localIterator.next();
            ((ArrayList)localObject2).addAll((Collection)this.R.get(str));
          }
        }
        agmz.en((ArrayList)localObject2);
        localObject2 = new Bundle();
        ((Bundle)localObject2).putInt("clicked_file_hashcode", paramFileInfo.hashCode());
        ((agvl)localObject1).cB((Bundle)localObject2);
      }
      localObject1 = new agvn(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, (agvq)localObject1);
      ((agvn)localObject1).Oy(8);
      if (((localFileManagerEntity.nFileType == 0) || (localFileManagerEntity.nFileType == 2)) && (paramView != null) && ((paramView.getId() == 2131367020) || (paramView.getId() == 2131368820))) {
        ((agvn)localObject1).k(sxx.getViewRect(paramView));
      }
      ((agvn)localObject1).djN();
      paramView = new ahau.a();
      paramView.bJE = "file_viewer_in";
      paramView.cYX = 80;
      paramView.bJF = ahbj.getExtension(paramFileInfo.getName());
      paramView.nFileSize = paramFileInfo.getSize();
      ahau.a(this.app.getCurrentAccountUin(), paramView);
      ahau.JH("0X8004AE5");
    }
  }
  
  public void a(String paramString1, QfileTabBarView.a parama, List<String> paramList, int paramInt1, TreeMap<Long, FileInfo> paramTreeMap, int paramInt2, String paramString2)
  {
    if ((this.cde) || (paramString1 == null)) {
      QLog.i(TAG, 1, "cancel scanMaxFileInfos bPause[" + this.cde + "]");
    }
    do
    {
      Object localObject;
      int i;
      do
      {
        do
        {
          for (;;)
          {
            return;
            localObject = new VFSFile(paramString1);
            if (!((VFSFile)localObject).isDirectory()) {
              break;
            }
            if (((VFSFile)localObject).getName().indexOf(".") != 0)
            {
              paramString1 = ((VFSFile)localObject).listFiles();
              if (paramString1 != null)
              {
                int j = paramString1.length;
                i = 0;
                while (i < j)
                {
                  localObject = paramString1[i];
                  if (this.cde)
                  {
                    QLog.i(TAG, 1, "cancel scanMaxFileInfos bPause[" + this.cde + "]");
                    return;
                  }
                  a(((VFSFile)localObject).getAbsolutePath(), parama, paramList, paramInt1, paramTreeMap, paramInt2, paramString2);
                  i += 1;
                }
              }
            }
          }
        } while ((!parama.amS()) && (!Z(paramString1, paramInt1)));
        localObject = FileInfo.a(paramString1);
      } while (localObject == null);
      if (parama.amT()) {
        ((FileInfo)localObject).setIgonFilename();
      }
      if (!TextUtils.isEmpty(paramString2))
      {
        i = paramList.indexOf(paramString2);
        paramInt1 = i;
        if (i < 0)
        {
          paramString1 = paramString2;
          if (!paramString2.endsWith("/")) {
            paramString1 = paramString2 + "/";
          }
          paramList.add(paramString1);
          paramInt1 = paramList.size() - 1;
        }
        if (paramInt1 >= 0) {
          ((FileInfo)localObject).setPath(paramInt1 + "");
        }
      }
      ((FileInfo)localObject).setLitePath(true);
      paramTreeMap.put(Long.valueOf(((FileInfo)localObject).getSize()), localObject);
    } while (paramTreeMap.size() <= paramInt2);
    paramTreeMap.pollFirstEntry();
  }
  
  public ListView b()
  {
    return this.jdField_b_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView;
  }
  
  protected abstract void b(FileInfo paramFileInfo);
  
  protected void b(FileInfo paramFileInfo, boolean paramBoolean) {}
  
  public boolean b(FileInfo paramFileInfo)
  {
    if (paramFileInfo == null) {
      return false;
    }
    return c(paramFileInfo);
  }
  
  protected abstract boolean c(FileInfo paramFileInfo);
  
  protected abstract void dfD();
  
  protected void dfE()
  {
    if (this.jdField_b_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout != null) {
      this.jdField_b_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout.setLayoutParams(this.jdField_b_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.getWidth(), this.jdField_b_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.getHeight());
    }
  }
  
  public void dfP()
  {
    if (this.R == null) {
      return;
    }
    Iterator localIterator = new ArrayList(this.R.values()).iterator();
    while (localIterator.hasNext()) {
      agmz.kG((List)localIterator.next());
    }
    int j = this.R.keySet().size();
    int i = 0;
    while (i < j)
    {
      this.jdField_b_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.expandGroup(i);
      i += 1;
    }
    deR();
    this.jdField_b_of_type_Agdq.notifyDataSetChanged();
  }
  
  public void dfQ()
  {
    Iterator localIterator1 = this.R.values().iterator();
    while (localIterator1.hasNext())
    {
      Iterator localIterator2 = ((List)localIterator1.next()).iterator();
      while (localIterator2.hasNext()) {
        agmz.e((FileInfo)localIterator2.next());
      }
    }
    deR();
    this.jdField_b_of_type_Agdq.notifyDataSetChanged();
  }
  
  protected void dgf()
  {
    if ((this.R == null) || (this.R.size() == 0))
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.setCheckAllEnable(false);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.setCheckAllEnable(true);
  }
  
  public void onCreate()
  {
    int i = 0;
    setContentView(2131561024);
    this.mInflater = LayoutInflater.from(a());
    this.app.a().addObserver(this.jdField_a_of_type_Aghq);
    initListView();
    this.jdField_b_of_type_Agdq = a();
    this.jdField_b_of_type_Agdq.a(this.jdField_b_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView);
    bWr();
    if (((this.jdField_b_of_type_Agdq instanceof agdu)) || ((this.jdField_b_of_type_Agdq instanceof agex)))
    {
      this.jdField_b_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setSelector(2131167595);
      this.jdField_b_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setAdapter(this.jdField_b_of_type_Agdq);
      this.jdField_b_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setTranscriptMode(0);
      this.jdField_b_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setWhetherImageTab(true);
      this.jdField_b_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setGridSize(((agdu)this.jdField_b_of_type_Agdq).Eb());
      i = 0;
    }
    while (i < this.jdField_b_of_type_Agdq.getGroupCount())
    {
      this.jdField_b_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.expandGroup(i);
      i += 1;
      continue;
      this.jdField_b_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setSelector(2131167595);
      this.jdField_b_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setAdapter(this.jdField_b_of_type_Agdq);
      this.jdField_b_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setTranscriptMode(0);
      this.jdField_b_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setWhetherImageTab(false);
      while (i < this.jdField_b_of_type_Agdq.getGroupCount())
      {
        this.jdField_b_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.expandGroup(i);
        i += 1;
      }
    }
    setLoadAllRecord(true);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable.stop();
    }
    if (this.runnable != null) {
      ThreadManager.removeJobFromThreadPool(this.runnable, 64);
    }
    this.wB.clear();
    this.R.clear();
    dge();
    if (this.jdField_a_of_type_Aghq != null) {
      this.app.a().deleteObserver(this.jdField_a_of_type_Aghq);
    }
    this.app.a().aIH();
    this.app.a().dgm();
  }
  
  public void onGetMore() {}
  
  public void onPause()
  {
    super.onPause();
    this.cde = true;
  }
  
  public void onResume()
  {
    this.cde = false;
    if ((this.R == null) || (this.R.size() == 0)) {
      dfD();
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.IM(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.akL());
  }
  
  public void onStart()
  {
    if (this.R.size() > 0) {
      refreshList();
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.IM(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.akL());
  }
  
  public void refreshList()
  {
    if ((this.R == null) || (this.R.size() == 0))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.akP()) {
        this.jdField_b_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout.setTopViewHeight(0.5F);
      }
      this.jdField_b_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout.setVisible(true);
      this.jdField_b_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout.setText(2131693538);
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetViewerMoreRelativeLayout != null) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetViewerMoreRelativeLayout.setGone();
      }
    }
    for (;;)
    {
      this.jdField_b_of_type_Agdq.notifyDataSetChanged();
      dfE();
      return;
      if (this.jdField_b_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout != null)
      {
        this.jdField_b_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout.setGone();
        this.jdField_b_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.removeHeaderView(this.jdField_b_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout);
      }
    }
  }
  
  public void refreshUI()
  {
    runOnUiThread(new QfileBaseLocalFileTabView.8(this));
  }
  
  public void setLoadAllRecord(boolean paramBoolean)
  {
    if (paramBoolean) {
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetViewerMoreRelativeLayout != null) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetViewerMoreRelativeLayout.setGone();
      }
    }
    for (;;)
    {
      this.cdj = paramBoolean;
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetViewerMoreRelativeLayout != null) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetViewerMoreRelativeLayout.setVisible();
      }
    }
  }
  
  public void setPos(int paramInt1, int paramInt2)
  {
    if ((paramInt1 < 0) || (paramInt2 < 0)) {}
    while (this.jdField_b_of_type_Agdq.getGroupCount() <= paramInt1) {
      return;
    }
    runOnUiThread(new QfileBaseLocalFileTabView.9(this, paramInt1, paramInt2));
  }
  
  public void setSelect(int paramInt)
  {
    if (this.jdField_b_of_type_Agdq.getGroupCount() <= paramInt) {
      return;
    }
    runOnUiThread(new QfileBaseLocalFileTabView.10(this, paramInt));
  }
  
  public void setTabType(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.localfile.QfileBaseLocalFileTabView
 * JD-Core Version:    0.7.0.1
 */