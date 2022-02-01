package com.tencent.qqmail.activity.setting;

import android.text.Editable;
import android.view.MotionEvent;
import android.widget.EditText;
import android.widget.Toast;
import com.tencent.qqmail.BaseActivityEx;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.utilities.sharedpreference.SharedPreferenceUtil;
import com.tencent.qqmail.utilities.uitableview.UITableFormItemView;
import com.tencent.qqmail.utilities.uitableview.UITableItemView;
import com.tencent.qqmail.utilities.uitableview.UITableView;
import com.tencent.qqmail.view.QMBaseView;
import com.tencent.qqmail.view.QMTopBar;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SettingTestHostIpActivity
  extends BaseActivityEx
{
  private static final String ACTIVESYNC_CALENDAR_HOST = "ex.qq.com";
  private static final String ACTIVESYNC_CALENDAR_IP = "112.90.139.242";
  private static final String BIZ_HOST = "i.exmail.qq.com";
  private static final String BIZ_IP = "183.60.60.153";
  private static final String EMAIL_FTN_HOST = "ftn.exmail.qq.com";
  private static final String EMAIL_FTN_IP = "112.90.139.205";
  private static final String FTN_HOST = "ftn.mail.qq.com";
  private static final String FTN_IP = "183.60.61.252";
  private static final String OSSLOG_HOST = "oss.mail.qq.com";
  private static final String OSSLOG_IP = "183.60.60.178";
  private static final String RIAMAIL999_HOST = "i.mail.qq.com";
  private static final String RIAMAIL999_IP = "183.60.61.252";
  public static final String TAG = "SettingTestHostIp";
  private static final String UMA_HOST = "qumas.mail.qq.com";
  private static final String UMA_IP = "220.249.245.15";
  private static final String WEBMAIL996_CDN_IP = "10.134.128.169";
  private static final String WEBMAIL996_IP = "112.90.139.206";
  private static final String WEBMAIL_CDN_HOST1 = "rescdn.qqmail.com";
  private static final String WEBMAIL_CDN_HOST2 = "res.mail.qq.com";
  private static final String WEBMAIL_CDN_IP = "14.17.32.57";
  private static final String WEBMAIL_HOST1 = "mail.qq.com";
  private static final String WEBMAIL_HOST2 = "set1.mail.qq.com";
  private static final String WEBMAIL_HOST3 = "set2.mail.qq.com";
  private static final String WEBMAIL_HOST4 = "set3.mail.qq.com";
  private static final String WEBMAIL_HOST5 = "rl.mail.qq.com";
  private static final String WEBMAIL_IP = "183.60.60.251";
  private ConcurrentHashMap<String, List<String>> hostIpMap;
  private UITableItemView mClearButton;
  private UITableView mConfigListTable;
  private UITableView mConfigTable;
  private UITableItemView mConfirmButton;
  private EditText mEditHost;
  private EditText mEditIp;
  private UITableView mOperationTable;
  private QMBaseView mSettingView;
  private UITableItemView mTestingCalendar;
  private UITableItemView mTestingExmail;
  private UITableItemView mTestingFtn;
  private UITableItemView mTestingOsslog;
  private UITableItemView mTestingRiamail999;
  private UITableView mTestingTable;
  private UITableItemView mTestingUMA;
  private UITableItemView mTestingWebmail;
  private UITableItemView mTestingWebmail996;
  
  private void addHostTest(String paramString1, String paramString2)
  {
    if (("".equals(paramString1)) || ("".equals(paramString2)))
    {
      Toast.makeText(QMApplicationContext.sharedInstance(), getString(2131719764), 0).show();
      return;
    }
    if (!isIpv4(paramString2))
    {
      Toast.makeText(QMApplicationContext.sharedInstance(), getString(2131719765), 0).show();
      return;
    }
    Object localObject = (List)this.hostIpMap.get(paramString1);
    if (localObject == null) {
      localObject = new ArrayList();
    }
    for (;;)
    {
      ((List)localObject).add(paramString2);
      this.hostIpMap.put(paramString1, localObject);
      SharedPreferenceUtil.setLocalHostIp(this.hostIpMap);
      Toast.makeText(QMApplicationContext.sharedInstance(), getString(2131719763), 1).show();
      refreshConfigHostList();
      refreshTestingTable();
      return;
      ((List)localObject).clear();
    }
  }
  
  private void clearHostTest()
  {
    SharedPreferenceUtil.removeLocalHostIp();
    Toast.makeText(QMApplicationContext.sharedInstance(), getString(2131719760), 0).show();
    this.hostIpMap.clear();
    refreshConfigHostList();
    refreshTestingTable();
  }
  
  private void createConfigHostListTable()
  {
    this.mConfigListTable = new UITableView(this);
    this.mConfigListTable.setCaption(2131719761);
    this.mSettingView.addContentView(this.mConfigListTable);
  }
  
  private void createConfigView()
  {
    this.mConfigTable = new UITableView(this);
    this.mConfigTable.setCaption(2131719775);
    this.mConfigTable.setFocusableInTouchMode(true);
    this.mSettingView.addContentView(this.mConfigTable);
    this.mEditHost = this.mConfigTable.addFormItem(2131719766).addEditText(2131718837);
    this.mEditHost.setSelection(this.mEditHost.getText().length());
    this.mEditIp = this.mConfigTable.addFormItem(2131719767).addEditText(2131718837);
    this.mEditIp.setSelection(this.mEditIp.getText().length());
    this.mConfigTable.commit();
  }
  
  private void createOperationTable()
  {
    this.mOperationTable = new UITableView(this);
    this.mSettingView.addContentView(this.mOperationTable);
    this.mConfirmButton = this.mOperationTable.addItem(2131719762);
    this.mConfirmButton.hideArrow();
    this.mClearButton = this.mOperationTable.addItem(2131719759);
    this.mClearButton.hideArrow();
    this.mOperationTable.setClickListener(new SettingTestHostIpActivity.1(this));
    this.mOperationTable.commit();
  }
  
  private void createTestingTable()
  {
    this.mTestingTable = new UITableView(this);
    this.mTestingTable.setCaption(2131719770);
    this.mSettingView.addContentView(this.mTestingTable);
  }
  
  private void initTopBar()
  {
    QMTopBar localQMTopBar = getTopBar();
    localQMTopBar.setTitle(2131719767);
    localQMTopBar.setButtonLeftBack();
  }
  
  private boolean isConfigHostIP(String paramString1, String paramString2)
  {
    boolean bool2 = false;
    paramString1 = (List)this.hostIpMap.get(paramString1);
    boolean bool1 = bool2;
    int i;
    if (paramString1 != null)
    {
      bool1 = bool2;
      if (paramString1.size() > 0) {
        i = 0;
      }
    }
    for (;;)
    {
      bool1 = bool2;
      if (i < paramString1.size())
      {
        if (((String)paramString1.get(i)).equals(paramString2)) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  private static boolean isIpv4(String paramString)
  {
    return Pattern.compile("^(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|[1-9])\\.(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\.(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\.(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)$").matcher(paramString).matches();
  }
  
  private boolean isWebMailConfigHostIP()
  {
    return (isConfigHostIP("mail.qq.com", "183.60.60.251")) && (isConfigHostIP("set1.mail.qq.com", "183.60.60.251")) && (isConfigHostIP("set2.mail.qq.com", "183.60.60.251")) && (isConfigHostIP("set3.mail.qq.com", "183.60.60.251")) && (isConfigHostIP("rl.mail.qq.com", "183.60.60.251")) && (isConfigHostIP("rescdn.qqmail.com", "14.17.32.57")) && (isConfigHostIP("res.mail.qq.com", "14.17.32.57"));
  }
  
  private void refreshConfigHostList()
  {
    this.mConfigListTable.clear();
    if (this.hostIpMap != null)
    {
      Iterator localIterator = this.hostIpMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (Map.Entry)localIterator.next();
        String str = (String)((Map.Entry)localObject).getKey();
        localObject = (List)((Map.Entry)localObject).getValue();
        this.mConfigListTable.addItem(str, (String)((List)localObject).get(0)).hideArrow();
      }
    }
    this.mConfigListTable.commit();
  }
  
  private void refreshTestingTable()
  {
    this.mTestingTable.clear();
    this.mTestingUMA = this.mTestingTable.addItem(2131719772);
    this.mTestingUMA.setChecked(isConfigHostIP("qumas.mail.qq.com", "220.249.245.15"));
    this.mTestingOsslog = this.mTestingTable.addItem("连接到osslog测试环境");
    this.mTestingOsslog.setChecked(isConfigHostIP("oss.mail.qq.com", "183.60.60.178"));
    this.mTestingRiamail999 = this.mTestingTable.addItem(2131719771);
    this.mTestingRiamail999.setChecked(isConfigHostIP("i.mail.qq.com", "183.60.61.252"));
    this.mTestingWebmail996 = this.mTestingTable.addItem(2131719774);
    this.mTestingWebmail996.setChecked(isConfigHostIP("mail.qq.com", "112.90.139.206"));
    this.mTestingWebmail = this.mTestingTable.addItem(2131719773);
    this.mTestingWebmail.setChecked(isWebMailConfigHostIP());
    this.mTestingCalendar = this.mTestingTable.addItem("连接到ActiveSync日历测试环境");
    this.mTestingCalendar.setChecked(isConfigHostIP("ex.qq.com", "112.90.139.242"));
    this.mTestingExmail = this.mTestingTable.addItem("连接到exmail测试环境");
    this.mTestingExmail.setChecked(isConfigHostIP("i.exmail.qq.com", "183.60.60.153"));
    this.mTestingFtn = this.mTestingTable.addItem("连接到ftn测试环境");
    this.mTestingFtn.setChecked(isConfigHostIP("ftn.mail.qq.com", "183.60.61.252"));
    this.mTestingTable.setClickListener(new SettingTestHostIpActivity.2(this));
    this.mTestingTable.commit();
  }
  
  private void removeHostTest(String paramString)
  {
    if ((List)this.hostIpMap.get(paramString) == null)
    {
      Toast.makeText(QMApplicationContext.sharedInstance(), getString(2131719768), 0).show();
      return;
    }
    this.hostIpMap.remove(paramString);
    SharedPreferenceUtil.setLocalHostIp(this.hostIpMap);
    Toast.makeText(QMApplicationContext.sharedInstance(), getString(2131719769), 1).show();
    refreshConfigHostList();
    refreshTestingTable();
  }
  
  public void initDataSource() {}
  
  public void initDom()
  {
    initTopBar();
    createConfigView();
    createOperationTable();
    createTestingTable();
    createConfigHostListTable();
  }
  
  public void initUI()
  {
    this.mSettingView = initScrollView(this);
  }
  
  public void onBindEvent(boolean paramBoolean) {}
  
  public boolean onDragBack(MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  public void onRelease() {}
  
  public void refreshData()
  {
    this.hostIpMap = SharedPreferenceUtil.getLocalHostIp();
  }
  
  public void render()
  {
    refreshTestingTable();
    refreshConfigHostList();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.SettingTestHostIpActivity
 * JD-Core Version:    0.7.0.1
 */