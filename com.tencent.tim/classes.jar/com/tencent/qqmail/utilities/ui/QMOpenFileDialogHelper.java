package com.tencent.qqmail.utilities.ui;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.FileProvider;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.attachment.model.QMqqBrowserInfo;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialog.CustomDialogBuilder;
import com.tencent.qqmail.qmui.dialog.QMUIDialogAction;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.otherapprule.OtherAppConfigUtil;
import java.io.File;
import java.util.List;

public class QMOpenFileDialogHelper
{
  private static final String TAG = "QMOpenFileDialog";
  private Activity activity;
  private Button alwaysBtn;
  private Intent currentIntent;
  private ResolveInfo currentResInfo;
  private File file;
  private boolean hasDownloadQQBrowser;
  private boolean isShowQQBrowser;
  private boolean isTypeSupportQQBrowser;
  private View lastView;
  private OpenFileAdapter listAdapter;
  private WrapContentListView listView;
  private QMUIDialog mDialog;
  private Button onceBtn;
  private boolean onlyOnePackage;
  private PackageManager packageManager;
  private QMqqBrowserInfo qqBrowserInfo;
  private SharedPreferences spreadPreferences;
  private String title;
  private String type;
  private String url;
  
  public QMOpenFileDialogHelper(Activity paramActivity, String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    this.activity = paramActivity;
    this.title = paramString1;
    this.url = paramString2;
    this.type = paramString3;
    this.isTypeSupportQQBrowser = paramBoolean;
    if (!paramString3.equals("url")) {
      this.file = new File(paramString2);
    }
  }
  
  private void initDialog()
  {
    this.listView = ((WrapContentListView)this.activity.getLayoutInflater().inflate(2131559234, null));
    this.listView.setMaxHeight((int)(QMUIKit.getScreenHeight() * 0.6D));
    QMUIDialogAction localQMUIDialogAction1 = new QMUIDialogAction(this.activity, 2131696624, new QMOpenFileDialogHelper.1(this));
    QMUIDialogAction localQMUIDialogAction2 = new QMUIDialogAction(this.activity, 2131696666, new QMOpenFileDialogHelper.2(this));
    this.mDialog = ((QMUIDialog.CustomDialogBuilder)((QMUIDialog.CustomDialogBuilder)((QMUIDialog.CustomDialogBuilder)new QMUIDialog.CustomDialogBuilder(this.activity).setTitle(this.title)).setLayout(this.listView).addAction(localQMUIDialogAction1)).addAction(localQMUIDialogAction2)).create();
    this.mDialog.setOnDismissListener(new QMOpenFileDialogHelper.3(this));
    this.mDialog.setCanceledOnTouchOutside(true);
    this.alwaysBtn = localQMUIDialogAction1.getButton();
    this.onceBtn = localQMUIDialogAction2.getButton();
    this.alwaysBtn.setEnabled(false);
    this.onceBtn.setEnabled(false);
  }
  
  private List<ResolveInfo> initResolveInfos()
  {
    Object localObject = new Intent();
    if ((this.file != null) && (this.file.exists()))
    {
      ((Intent)localObject).addFlags(268435456);
      ((Intent)localObject).setAction("android.intent.action.VIEW");
      ((Intent)localObject).setDataAndType(FileProvider.getUriForFile(this.activity, "call_log", this.file), this.type);
      ((Intent)localObject).addFlags(1);
      QMLog.log(4, "QMOpenFileDialog", "openFile: " + Uri.fromFile(this.file) + ", " + this.type);
      localObject = OtherAppConfigUtil.filterResolveInfos(this.packageManager.queryIntentActivities((Intent)localObject, 65536), this.type);
      if (!this.type.equals("url")) {
        break label260;
      }
      if (this.qqBrowserInfo.isShowDownloadInWebview())
      {
        QMLog.log(4, "QMOpenFileDialog", "show QQBrowser download in webview");
        this.isShowQQBrowser = true;
        this.qqBrowserInfo.setWebviewSpreadCount();
        DataCollector.logEvent("Event_Show_QQbrowser_Download_In_Webview");
      }
    }
    for (;;)
    {
      this.hasDownloadQQBrowser = this.qqBrowserInfo.checkHasDownload("qqBrowser.apk");
      return localObject;
      ((Intent)localObject).setAction("android.intent.action.VIEW");
      ((Intent)localObject).setData(Uri.parse(this.url));
      QMLog.log(4, "QMOpenFileDialog", "openUrl: " + this.url + ", " + this.type);
      break;
      label260:
      if ((this.qqBrowserInfo.isShowDownload(this.isTypeSupportQQBrowser)) || ((localObject != null) && (((List)localObject).size() == 0) && (this.isTypeSupportQQBrowser)))
      {
        QMLog.log(4, "QMOpenFileDialog", "show QQBrowser download");
        this.isShowQQBrowser = true;
        this.qqBrowserInfo.setSpreadCount();
        DataCollector.logEvent("Event_Show_QQbrowser_Download");
      }
    }
  }
  
  private void setListener()
  {
    this.listView.setOnItemClickListener(new QMOpenFileDialogHelper.4(this));
  }
  
  private void startOpenFile(QMUIDialog paramQMUIDialog, boolean paramBoolean)
  {
    if ((paramBoolean) && (this.currentResInfo != null))
    {
      SharedPreferences.Editor localEditor = this.spreadPreferences.edit();
      localEditor.putString(this.type, this.currentResInfo.activityInfo.packageName);
      localEditor.commit();
    }
    if (this.currentIntent != null)
    {
      this.activity.startActivity(this.currentIntent);
      paramQMUIDialog.dismiss();
    }
  }
  
  public void dismiss()
  {
    if (this.mDialog != null) {
      this.mDialog.dismiss();
    }
  }
  
  public void show()
  {
    this.spreadPreferences = this.activity.getSharedPreferences("spread", 0);
    this.qqBrowserInfo = new QMqqBrowserInfo(this.activity, QMqqBrowserInfo.qqBrowserSupportTypes);
    this.packageManager = this.activity.getPackageManager();
    this.isShowQQBrowser = false;
    this.hasDownloadQQBrowser = false;
    this.onlyOnePackage = false;
    List localList = initResolveInfos();
    if ((localList.size() == 0) && (!this.isShowQQBrowser)) {
      return;
    }
    if (localList.size() == 1) {
      this.onlyOnePackage = true;
    }
    initDialog();
    this.listAdapter = new OpenFileAdapter(this.activity, localList);
    this.listView.setAdapter(this.listAdapter);
    setListener();
    this.mDialog.show();
  }
  
  class OpenFileAdapter
    extends BaseAdapter
  {
    private LayoutInflater inflater;
    private List<ResolveInfo> resInfo;
    
    public OpenFileAdapter(List<ResolveInfo> paramList)
    {
      this.inflater = LayoutInflater.from(paramList);
      Object localObject;
      this.resInfo = localObject;
    }
    
    private void handleSpreadClick(QMqqBrowserInfo paramQMqqBrowserInfo, View paramView)
    {
      String str;
      if (QMOpenFileDialogHelper.this.type.equals("url"))
      {
        str = "http://mdc.html5.qq.com/d/directdown.jsp?channel_id=10979";
        DataCollector.logEvent("Event_Download_QQbrowser_In_Webview");
      }
      for (;;)
      {
        int i = paramQMqqBrowserInfo.getAPPAction(QMOpenFileDialogHelper.this.activity, "qqBrowser.apk", QMOpenFileDialogHelper.this.hasDownloadQQBrowser);
        if ((i == 3) && (QMOpenFileDialogHelper.this.mDialog != null)) {
          QMOpenFileDialogHelper.this.mDialog.dismiss();
        }
        if (QMOpenFileDialogHelper.this.qqBrowserInfo.downloadOrInstall(QMOpenFileDialogHelper.this.activity, "qqBrowser.apk", str, i) == 2)
        {
          ((Button)paramView).setText(QMOpenFileDialogHelper.this.activity.getResources().getString(2131690404));
          paramView.setEnabled(false);
        }
        return;
        str = "http://mdc.html5.qq.com/d/directdown.jsp?channel_id=10940";
        DataCollector.logEvent("Event_Download_QQbrowser");
      }
    }
    
    public int getCount()
    {
      if (QMOpenFileDialogHelper.this.isShowQQBrowser) {
        return this.resInfo.size() + 1;
      }
      return this.resInfo.size();
    }
    
    public ResolveInfo getItem(int paramInt)
    {
      List localList = this.resInfo;
      int i = paramInt;
      if (QMOpenFileDialogHelper.this.isShowQQBrowser) {
        i = paramInt - 1;
      }
      return (ResolveInfo)localList.get(i);
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      View localView;
      QMOpenFileDialogHelper.ViewHolder localViewHolder;
      if (paramView == null)
      {
        localView = this.inflater.inflate(2131559235, paramViewGroup, false);
        localViewHolder = new QMOpenFileDialogHelper.ViewHolder(QMOpenFileDialogHelper.this, null);
        localViewHolder.icon = ((ImageView)localView.findViewById(2131368855));
        localViewHolder.name = ((TextView)localView.findViewById(2131379431));
        localViewHolder.description = ((TextView)localView.findViewById(2131379430));
        localViewHolder.check = ((ImageView)localView.findViewById(2131368857));
        localViewHolder.download = ((Button)localView.findViewById(2131364094));
        localView.setTag(localViewHolder);
        if ((!QMOpenFileDialogHelper.this.isShowQQBrowser) || (paramInt != 0)) {
          break label465;
        }
        localViewHolder.icon.setImageDrawable(QMOpenFileDialogHelper.this.activity.getResources().getDrawable(2130845839));
        localViewHolder.check.setVisibility(8);
        localViewHolder.name.setText(QMOpenFileDialogHelper.this.activity.getResources().getString(2131700787));
        if (!QMOpenFileDialogHelper.this.type.equals("url")) {
          break label373;
        }
        localViewHolder.description.setText(QMOpenFileDialogHelper.this.activity.getResources().getString(2131700789));
        label221:
        localViewHolder.description.setVisibility(0);
        localViewHolder.download.setVisibility(0);
        localViewHolder.download.setEnabled(true);
        switch (QMOpenFileDialogHelper.this.qqBrowserInfo.getAPPAction(QMOpenFileDialogHelper.this.activity, "qqBrowser.apk", QMOpenFileDialogHelper.this.hasDownloadQQBrowser))
        {
        default: 
          paramView = null;
          label302:
          if (paramView != null) {
            localViewHolder.download.setText(paramView);
          }
          paramView = QMOpenFileDialogHelper.this.qqBrowserInfo;
          localViewHolder.download.setOnClickListener(new QMOpenFileDialogHelper.OpenFileAdapter.1(this, paramView));
        }
      }
      for (;;)
      {
        EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
        return localView;
        localViewHolder = (QMOpenFileDialogHelper.ViewHolder)paramView.getTag();
        localView = paramView;
        break;
        label373:
        localViewHolder.description.setText(QMOpenFileDialogHelper.this.activity.getResources().getString(2131700788));
        break label221;
        paramView = QMOpenFileDialogHelper.this.activity.getResources().getString(2131690536);
        break label302;
        paramView = QMOpenFileDialogHelper.this.activity.getResources().getString(2131690404);
        localViewHolder.download.setEnabled(false);
        break label302;
        paramView = QMOpenFileDialogHelper.this.activity.getResources().getString(2131690409);
        break label302;
        label465:
        localViewHolder.icon.setImageDrawable(getItem(paramInt).loadIcon(QMOpenFileDialogHelper.this.packageManager));
        String str = ((String)getItem(paramInt).loadLabel(QMOpenFileDialogHelper.this.packageManager)).trim();
        int i = str.indexOf("(");
        int j = str.indexOf(")");
        paramView = str;
        if (i != -1)
        {
          paramView = str;
          if (j != -1) {
            paramView = str.replace(str.substring(i, j + 1), "");
          }
        }
        localViewHolder.name.setText(paramView);
        localViewHolder.name.setTextSize(18.0F);
        localViewHolder.name.setGravity(16);
        localViewHolder.description.setVisibility(8);
        localViewHolder.download.setVisibility(8);
        if (QMOpenFileDialogHelper.this.onlyOnePackage)
        {
          QMOpenFileDialogHelper.access$202(QMOpenFileDialogHelper.this, new Intent());
          QMOpenFileDialogHelper.access$302(QMOpenFileDialogHelper.this, getItem(paramInt));
          paramView = QMOpenFileDialogHelper.this.currentResInfo.activityInfo.packageName;
          str = QMOpenFileDialogHelper.this.currentResInfo.activityInfo.name;
          if ((QMOpenFileDialogHelper.this.file != null) && (QMOpenFileDialogHelper.this.file.exists()))
          {
            QMOpenFileDialogHelper.this.currentIntent.addFlags(268435456);
            QMOpenFileDialogHelper.this.currentIntent.setAction("android.intent.action.VIEW");
            QMOpenFileDialogHelper.this.currentIntent.setDataAndType(Uri.fromFile(QMOpenFileDialogHelper.this.file), QMOpenFileDialogHelper.this.type);
          }
          for (;;)
          {
            QMOpenFileDialogHelper.this.currentIntent.setClassName(paramView, str);
            QMOpenFileDialogHelper.this.currentIntent.setComponent(new ComponentName(paramView, str));
            QMOpenFileDialogHelper.this.currentIntent.setPackage(paramView);
            QMOpenFileDialogHelper.this.alwaysBtn.setEnabled(true);
            QMOpenFileDialogHelper.this.onceBtn.setEnabled(true);
            localViewHolder.check.setVisibility(0);
            QMOpenFileDialogHelper.access$602(QMOpenFileDialogHelper.this, localView);
            break;
            QMOpenFileDialogHelper.this.currentIntent.setAction("android.intent.action.VIEW");
            QMOpenFileDialogHelper.this.currentIntent.setData(Uri.parse(QMOpenFileDialogHelper.this.url));
          }
        }
        localViewHolder.check.setVisibility(8);
      }
    }
  }
  
  class ViewHolder
  {
    ImageView check;
    TextView description;
    Button download;
    ImageView icon;
    TextView name;
    
    private ViewHolder() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.ui.QMOpenFileDialogHelper
 * JD-Core Version:    0.7.0.1
 */