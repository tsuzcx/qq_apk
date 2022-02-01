package com.tencent.mobileqq.filemanager.activity.cloudfile;

import agdq;
import agdy;
import agea;
import ageb;
import agee;
import agef;
import agej;
import agek;
import agel;
import agem;
import agen;
import ageo;
import aghq;
import aghw;
import agkf;
import agkh;
import agmz;
import agvn;
import agvs;
import ahau;
import ahav;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.widget.TextView;
import anot;
import aqha;
import aqha.a;
import aqju;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.activity.fileassistant.QfileBaseTabView;
import com.tencent.mobileqq.filemanager.data.WeiYunFileInfo;
import com.tencent.mobileqq.filemanager.widget.NoFileRelativeLayout;
import com.tencent.mobileqq.filemanager.widget.QfilePinnedHeaderExpandableListView;
import com.tencent.mobileqq.filemanager.widget.ViewerMoreRelativeLayout;
import com.tencent.mobileqq.widget.ScrollerRunnable;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.BubblePopupWindow;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public abstract class QfileBaseCloudFileTabView
  extends QfileBaseTabView
{
  public static String TAG = "QfileRecentFileActivity<FileAssistant>";
  protected LinkedHashMap<String, List<WeiYunFileInfo>> R = new LinkedHashMap();
  long Yn = -1L;
  private aghq jdField_a_of_type_Aghq = new agej(this);
  public ViewerMoreRelativeLayout a;
  ScrollerRunnable jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable;
  public agdq b;
  NoFileRelativeLayout b;
  public QfilePinnedHeaderExpandableListView b;
  public TextView bG;
  public boolean ccZ;
  Drawable dx;
  public View.OnClickListener eW = new ageo(this);
  public View.OnClickListener eX = new agef(this);
  public View.OnLongClickListener g = new ageb(this);
  public String id;
  public BubblePopupWindow k = null;
  public View.OnClickListener m = new agen(this);
  int mFrom = 0;
  LayoutInflater mInflater = null;
  volatile boolean mPaused = false;
  public View.OnClickListener n = new agee(this);
  public ArrayList<WeiYunFileInfo> wB = new ArrayList();
  
  public QfileBaseCloudFileTabView(Context paramContext)
  {
    super(paramContext);
    this.jdField_b_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout = null;
  }
  
  private void bWr()
  {
    try
    {
      this.jdField_b_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout = new NoFileRelativeLayout(a());
      this.jdField_b_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.addHeaderView(this.jdField_b_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetViewerMoreRelativeLayout = new ViewerMoreRelativeLayout(a());
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetViewerMoreRelativeLayout.setOnClickListener(this.eW);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetViewerMoreRelativeLayout.setGone();
      this.bG = ((TextView)this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetViewerMoreRelativeLayout.findViewById(2131381971));
      this.jdField_b_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.addFooterView(this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetViewerMoreRelativeLayout);
      dfE();
      this.jdField_b_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout.setText(2131693529);
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
  
  protected abstract void IS(boolean paramBoolean);
  
  protected void IT(boolean paramBoolean)
  {
    String str = "";
    if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.akP()) && (!paramBoolean))
    {
      str = "0X8009E72";
      if ("document".equals(this.id)) {
        str = "0X8009E6E";
      }
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(str)) {
        anot.a(this.app, "dc00898", "", "", str, str, 0, 0, "", "", "", "");
      }
      return;
      if ("picture".equals(this.id))
      {
        str = "0X8009E6F";
      }
      else if ("video".equals(this.id))
      {
        str = "0X8009E70";
      }
      else if ("music".equals(this.id))
      {
        str = "0X8009E71";
        continue;
        if (!this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.akP())
        {
          str = "0X8009E65";
          if ("document".equals(this.id)) {
            str = "0X8009E61";
          } else if ("picture".equals(this.id)) {
            str = "0X8009E62";
          } else if ("video".equals(this.id)) {
            str = "0X8009E63";
          } else if ("music".equals(this.id)) {
            str = "0X8009E64";
          }
        }
      }
    }
  }
  
  public void IU(boolean paramBoolean) {}
  
  protected abstract agdq a();
  
  protected ArrayList<WeiYunFileInfo> a(WeiYunFileInfo paramWeiYunFileInfo)
  {
    int j = 0;
    if (this.wB.size() <= 250) {
      return this.wB;
    }
    int i1 = this.wB.indexOf(paramWeiYunFileInfo);
    int i = i1;
    if (i1 == -1)
    {
      if (QLog.isColorLevel()) {
        QLog.i(TAG, 1, "can not find the clicked weiYunFileInfo. targetInfo fileId[" + paramWeiYunFileInfo.bIk + "]");
      }
      i = 0;
    }
    if (i < 100)
    {
      if (this.wB.size() - 1 >= i + 100) {
        break label140;
      }
      i = this.wB.size() - 1;
    }
    for (;;)
    {
      return new ArrayList(this.wB.subList(j, i));
      j = i - 100;
      break;
      label140:
      i += 100;
    }
  }
  
  public void a(WeiYunFileInfo paramWeiYunFileInfo, int paramInt, boolean paramBoolean)
  {
    this.app.a().aIH();
    if ((akL()) && (!paramBoolean)) {
      if (agmz.c(paramWeiYunFileInfo))
      {
        agmz.d(paramWeiYunFileInfo);
        deR();
        refreshList();
      }
    }
    for (;;)
    {
      IT(akL());
      do
      {
        return;
        agmz.c(paramWeiYunFileInfo);
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.setDocsCheck(true);
        if ((!this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.akO()) || (agmz.hasFlag(agmz.cYa))) {
          break;
        }
        paramWeiYunFileInfo = aqha.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, 2131700305);
        paramWeiYunFileInfo.setPositiveButton(2131721303, new aqha.a());
        paramWeiYunFileInfo.show();
        agmz.setFlag(agmz.cYa);
        ahau.JH("0X800942F");
        break;
        if (H()) {
          break label149;
        }
      } while (!QLog.isColorLevel());
      QLog.i(TAG, 2, "click too fast , wait a minute.");
      return;
      label149:
      aM();
      ahau.JH("0X8004AE6");
      agvs localagvs = new agvs(this.app, this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, paramWeiYunFileInfo);
      if (ahav.getFileType(paramWeiYunFileInfo.strFileName) == 0) {
        localagvs.eq(a(paramWeiYunFileInfo));
      }
      paramWeiYunFileInfo = new agvn(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, localagvs);
      paramWeiYunFileInfo.Oy(9);
      paramWeiYunFileInfo.djN();
    }
  }
  
  protected abstract boolean a(WeiYunFileInfo paramWeiYunFileInfo);
  
  public ListView b()
  {
    return this.jdField_b_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView;
  }
  
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
    int i = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getWindow().getDecorView().getHeight() / 2;
    this.jdField_b_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout.setLayoutParams(this.jdField_b_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.getWidth(), i);
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
    setContentView(2131561024);
    this.mInflater = LayoutInflater.from(a());
    this.app.a().addObserver(this.jdField_a_of_type_Aghq);
    initListView();
    this.jdField_b_of_type_Agdq = a();
    this.jdField_b_of_type_Agdq.a(this.jdField_b_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView);
    bWr();
    if ((this.jdField_b_of_type_Agdq instanceof agdy))
    {
      this.jdField_b_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setSelector(2131167595);
      this.jdField_b_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setAdapter(this.jdField_b_of_type_Agdq);
      this.jdField_b_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setTranscriptMode(0);
      this.jdField_b_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setWhetherImageTab(true);
      this.jdField_b_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setGridSize(((agdy)this.jdField_b_of_type_Agdq).Eb());
      i = 0;
      while (i < this.jdField_b_of_type_Agdq.getGroupCount())
      {
        this.jdField_b_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.expandGroup(i);
        i += 1;
      }
    }
    this.jdField_b_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setOnGroupExpandListener(new agea(this));
    this.jdField_b_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setOnGroupCollapseListener(new agek(this));
    this.jdField_b_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setSelector(2131167595);
    this.jdField_b_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setAdapter(this.jdField_b_of_type_Agdq);
    this.jdField_b_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setTranscriptMode(0);
    this.jdField_b_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setWhetherImageTab(false);
    int i = 0;
    while (i < this.jdField_b_of_type_Agdq.getGroupCount())
    {
      this.jdField_b_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.expandGroup(i);
      i += 1;
    }
    this.jdField_b_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.smoothScrollToPosition(0);
    this.jdField_b_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setStackFromBottom(false);
    this.jdField_b_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setTranscriptMode(0);
    if ((this.jdField_b_of_type_Agdq instanceof agdy))
    {
      this.jdField_b_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.getViewTreeObserver().addOnGlobalLayoutListener(new agel(this));
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetViewerMoreRelativeLayout == null) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetViewerMoreRelativeLayout = new ViewerMoreRelativeLayout(getContext());
      }
      this.bG = ((TextView)this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetViewerMoreRelativeLayout.findViewById(2131381971));
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetViewerMoreRelativeLayout.setOnClickListener(this.eW);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetViewerMoreRelativeLayout.setGone();
      return;
    }
    this.jdField_b_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.getViewTreeObserver().addOnGlobalLayoutListener(new agem(this));
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
    if (this.jdField_a_of_type_Aghq != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "onDestroy, del fmObserver");
      }
      this.app.a().deleteObserver(this.jdField_a_of_type_Aghq);
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
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.setDocsCheck(false);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.IM(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.akL());
  }
  
  public void refreshList()
  {
    if (((this.R == null) || (this.R.size() == 0)) && (isEnd()))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.akP()) {
        this.jdField_b_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout.setTopViewHeight(0.5F);
      }
      this.jdField_b_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout.setText(2131693538);
      this.jdField_b_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout.setVisible(true);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetViewerMoreRelativeLayout.setGone();
    }
    for (;;)
    {
      this.jdField_b_of_type_Agdq.notifyDataSetChanged();
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
    runOnUiThread(new QfileBaseCloudFileTabView.14(this));
  }
  
  public void setListFooter()
  {
    if ((this.jdField_b_of_type_Agdq instanceof agdy)) {}
    while ((this.jdField_b_of_type_Agdq.getGroupCount() <= 0) || (!this.jdField_b_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.isGroupExpanded(this.jdField_b_of_type_Agdq.getGroupCount() - 1)) || (this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetViewerMoreRelativeLayout == null)) {
      return;
    }
    if (!isEnd())
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetViewerMoreRelativeLayout.setVisible();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetViewerMoreRelativeLayout.setGone();
  }
  
  public void setSelect(int paramInt)
  {
    if (this.jdField_b_of_type_Agdq.getGroupCount() <= paramInt)
    {
      if (QLog.isColorLevel()) {
        QLog.e(TAG, 1, "setSelect[" + paramInt + "] faild,becouse GroupCount[" + this.jdField_b_of_type_Agdq.getGroupCount() + "]");
      }
      return;
    }
    runOnUiThread(new QfileBaseCloudFileTabView.15(this, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.cloudfile.QfileBaseCloudFileTabView
 * JD-Core Version:    0.7.0.1
 */