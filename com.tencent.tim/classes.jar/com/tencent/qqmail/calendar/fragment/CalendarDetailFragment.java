package com.tencent.qqmail.calendar.fragment;

import android.graphics.BitmapFactory;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.content.ContextCompat;
import com.tencent.androidqqmail.mobileqq.MobileQQEntryActivity;
import com.tencent.androidqqmail.wxapi.WXEntryActivity;
import com.tencent.mm.sdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.sdk.modelmsg.WXWebpageObject;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.calendar.data.QMCalendarFolder;
import com.tencent.qqmail.calendar.data.QMCalendarShare;
import com.tencent.qqmail.calendar.model.QMCalendarManager;
import com.tencent.qqmail.calendar.provider.CalendarProviderManager;
import com.tencent.qqmail.calendar.view.CalColorView;
import com.tencent.qqmail.calendar.watcher.CalendarShareWXUrlWatcher;
import com.tencent.qqmail.calendar.watcher.CalendarStopShareWatcher;
import com.tencent.qqmail.calendar.watcher.LoadCalendarListWatcher;
import com.tencent.qqmail.model.mail.QMComposeDataManager;
import com.tencent.qqmail.utilities.stringextention.StringExtention;
import com.tencent.qqmail.utilities.ui.QMUIHelper;
import com.tencent.qqmail.utilities.ui.QMUIKit;
import com.tencent.qqmail.utilities.uitableview.UITableItemView;
import com.tencent.qqmail.utilities.uitableview.UITableView;
import com.tencent.qqmail.utilities.uitableview.UITableView.ClickListener;
import com.tencent.qqmail.view.QMTopBar;
import com.tencent.wework.api.IWWAPI;
import com.tencent.wework.api.WWAPIFactory;
import com.tencent.wework.api.model.WWMediaLink;
import java.util.ArrayList;
import java.util.Iterator;
import moai.core.watcher.Watchers;
import moai.fragment.base.BaseFragment.TransitionConfig;
import moai.fragment.base.SaveArgumentField;

public class CalendarDetailFragment
  extends CalendarScrollBaseFragment
{
  private final int SHARE_TYPE_MAIL = 0;
  private final int SHARE_TYPE_QQ = 2;
  private final int SHARE_TYPE_WECHAT = 1;
  private final int SHARE_TYPE_WEWORK = 3;
  @SaveArgumentField
  private Account account;
  @SaveArgumentField
  private QMCalendarFolder calendarFolder;
  private CalendarShareWXUrlWatcher calendarShareWXUrlWatcher = new CalendarDetailFragment.3(this);
  private LoadCalendarListWatcher loadCalendarListWatcher = new CalendarDetailFragment.1(this);
  private int shareType = 0;
  private UITableView.ClickListener sharedReceiverClickListener = new CalendarDetailFragment.6(this);
  private CalendarStopShareWatcher stopShareWatcher = new CalendarDetailFragment.2(this);
  
  protected CalendarDetailFragment(QMCalendarFolder paramQMCalendarFolder)
  {
    this.calendarFolder = paramQMCalendarFolder;
  }
  
  private boolean canDeleteFolder()
  {
    if (this.calendarFolder.isShareSystemFolder()) {}
    do
    {
      return true;
      if (!this.calendarFolder.isEditable()) {
        return false;
      }
      if (!this.calendarFolder.isSelfFolder()) {
        return false;
      }
    } while ((this.calendarFolder.isLocalFolder()) || ((QMCalendarManager.getInstance().isActiveSyncAccount(this.calendarFolder.getAccountId())) && (QMCalendarManager.getInstance().getActiveSyncSelfCalendarFolderSize(this.calendarFolder.getAccountId()) > 1)));
    return false;
  }
  
  private boolean canShareFolder()
  {
    if (!this.calendarFolder.isEditable()) {}
    while ((!this.calendarFolder.isSelfFolder()) || (this.calendarFolder.isLocalFolder()) || (!QMCalendarManager.getInstance().isActiveSyncAccount(this.calendarFolder.getAccountId())) || (!this.account.isQQMail()) || (this.account.isBizMail())) {
      return false;
    }
    return true;
  }
  
  private void cancelShareCalendar()
  {
    QMCalendarManager.getInstance().removeCalendarFolder(this.calendarFolder);
  }
  
  private void createCalendarInfoTableView()
  {
    UITableView localUITableView = new UITableView(getActivity());
    this.mContainer.addView(localUITableView);
    UITableItemView localUITableItemView = localUITableView.addItem(getString(2131691091));
    localUITableItemView.setDetail(this.calendarFolder.getName(), UITableItemView.STYLE_GRAY);
    localUITableItemView.limitDetailWidth(true);
    localUITableItemView.getDetailView().setTextSize(2, 16.0F);
    localUITableItemView.getDetailView().setTextColor(ContextCompat.getColor(getActivity(), 2131166577));
    localUITableItemView.hideArrow();
    localUITableView.addItem(getString(2131691056)).setCustomTailView(new CalColorView(getActivity(), QMUIHelper.getCalendarColor(getActivity(), this.calendarFolder)));
    localUITableView.commit();
  }
  
  private void createCancelShareButton()
  {
    UITableView localUITableView = new UITableView(getActivity());
    this.mContainer.addView(localUITableView);
    Button localButton = QMUIKit.getRedFontButton(getActivity(), 2131691054, true);
    localButton.setOnClickListener(new CalendarDetailFragment.8(this));
    localUITableView.addView(localButton);
  }
  
  private void createDeleteButton()
  {
    UITableView localUITableView = new UITableView(getActivity());
    this.mContainer.addView(localUITableView);
    Button localButton = QMUIKit.getRedFontButton(getActivity(), 2131691069, true);
    localButton.setOnClickListener(new CalendarDetailFragment.9(this));
    localUITableView.addView(localButton);
  }
  
  private void createShareButton()
  {
    UITableView localUITableView = new UITableView(getActivity());
    this.mContainer.addView(localUITableView);
    Button localButton = QMUIKit.getBlueFontButton(getActivity(), 2131691199, true);
    localButton.setOnClickListener(new CalendarDetailFragment.7(this));
    localUITableView.addView(localButton);
  }
  
  private void createShareSourceTableView()
  {
    UITableView localUITableView = new UITableView(getActivity());
    localUITableView.setCaption(2131691193);
    this.mContainer.addView(localUITableView);
    localUITableView.addItem(this.calendarFolder.getShareOwner()).hideArrow();
    localUITableView.commit();
  }
  
  private void createSharedToTableView()
  {
    Object localObject = this.calendarFolder.getShareList();
    if ((localObject != null) && (!((ArrayList)localObject).isEmpty()))
    {
      UITableView localUITableView = new UITableView(getActivity());
      localUITableView.setCaption(2131691198);
      this.mContainer.addView(localUITableView);
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        QMCalendarShare localQMCalendarShare = (QMCalendarShare)((Iterator)localObject).next();
        UITableItemView localUITableItemView = localUITableView.addItem(localQMCalendarShare.getDisplayName());
        if (localQMCalendarShare.getState() == 1) {
          localUITableItemView.setContent(getString(2131691194));
        } else if (localQMCalendarShare.getState() == 0) {
          localUITableItemView.setContent(getString(2131691195));
        }
      }
      localUITableView.setClickListener(this.sharedReceiverClickListener);
      localUITableView.commit();
    }
  }
  
  private void deleteCalendar()
  {
    if (this.calendarFolder.isLocalFolder())
    {
      CalendarProviderManager.sharedInstance().deleteCalendarFolder(this.calendarFolder);
      return;
    }
    QMCalendarManager.getInstance().removeCalendarFolder(this.calendarFolder);
  }
  
  private void getShareCalendarUrl()
  {
    QMCalendarManager.getInstance().getShareCalendarFolderWXUrl(this.calendarFolder);
  }
  
  private void shareToMail()
  {
    startFragment(new CalendarShareFragment(this.calendarFolder));
  }
  
  private void shareToQQ(String paramString)
  {
    String str2 = QMComposeDataManager.sharedInstance().getQMDefaultNick(this.account.getId());
    String str3 = getString(2131691200);
    String str1 = str2;
    if (StringExtention.isNullOrEmpty(str2)) {
      str1 = this.account.getName();
    }
    MobileQQEntryActivity.shareLinkToQQ(paramString, String.format(str3, new Object[] { str1 }), getString(2131691201), "https://app.mail.qq.com/app/share/icon_share_cal.png", getActivity());
  }
  
  private void shareToRTX(String paramString)
  {
    IWWAPI localIWWAPI = WWAPIFactory.createWWAPI(getActivity());
    String str1 = QMComposeDataManager.sharedInstance().getQMDefaultNick(this.account.getId());
    WWMediaLink localWWMediaLink = new WWMediaLink();
    localWWMediaLink.thumbUrl = "https://app.mail.qq.com/app/share/icon_share_cal.png";
    localWWMediaLink.webpageUrl = paramString;
    String str2 = getString(2131691200);
    paramString = str1;
    if (StringExtention.isNullOrEmpty(str1)) {
      paramString = this.account.getName();
    }
    localWWMediaLink.title = String.format(str2, new Object[] { paramString });
    localWWMediaLink.description = getString(2131691202);
    localWWMediaLink.appPkg = getString(2131690411);
    localWWMediaLink.appName = getString(2131690411);
    if (!localIWWAPI.sendMessage(localWWMediaLink)) {
      Toast.makeText(getActivity(), getString(2131696561), 0).show();
    }
  }
  
  private void shareToWeChat(String paramString)
  {
    if (WXEntryActivity.canShareToWX(getActivity()))
    {
      QMCalendarManager.logEvent("Event_Calendar_Share_Event");
      Object localObject = new WXWebpageObject();
      ((WXWebpageObject)localObject).webpageUrl = paramString;
      String str1 = QMComposeDataManager.sharedInstance().getQMDefaultNick(this.account.getId());
      localObject = new WXMediaMessage((WXMediaMessage.IMediaObject)localObject);
      String str2 = getString(2131691200);
      paramString = str1;
      if (StringExtention.isNullOrEmpty(str1)) {
        paramString = this.account.getName();
      }
      ((WXMediaMessage)localObject).title = String.format(str2, new Object[] { paramString });
      ((WXMediaMessage)localObject).description = getString(2131691202);
      ((WXMediaMessage)localObject).thumbData = WXEntryActivity.bmpToByteArray(BitmapFactory.decodeResource(getResources(), 2130841425), false);
      WXEntryActivity.shareWebpage(getActivity(), 0, (WXMediaMessage)localObject, 3);
    }
  }
  
  private void stopShareCalendar(int paramInt)
  {
    QMCalendarManager.getInstance().stopShareCalendarFolder(this.calendarFolder, ((QMCalendarShare)this.calendarFolder.getShareList().get(paramInt)).getEmail());
  }
  
  public void initTopbar(View paramView)
  {
    paramView = getTopBar();
    paramView.setTitle(2131691074);
    paramView.setButtonLeftIcon(2130841088);
    paramView.setButtonRightIcon(2130841091);
    paramView.setButtonLeftOnclickListener(new CalendarDetailFragment.4(this));
    paramView.setButtonRightOnclickListener(new CalendarDetailFragment.5(this));
  }
  
  public void onBindEvent(boolean paramBoolean)
  {
    super.onBindEvent(paramBoolean);
    Watchers.bind(this.loadCalendarListWatcher, paramBoolean);
    Watchers.bind(this.stopShareWatcher, paramBoolean);
    Watchers.bind(this.calendarShareWXUrlWatcher, paramBoolean);
  }
  
  public BaseFragment.TransitionConfig onFetchTransitionConfig()
  {
    return SCALE_TRANSITION_CONFIG;
  }
  
  public int refreshData()
  {
    this.calendarFolder = QMCalendarManager.getInstance().getCalendarFolder(this.calendarFolder.getAccountId(), this.calendarFolder.getId());
    if (this.calendarFolder == null)
    {
      finish();
      return 0;
    }
    if (this.calendarFolder.isLocalFolder()) {}
    for (this.account = QMCalendarManager.getInstance().getLocalAccount();; this.account = AccountManager.shareInstance().getAccountList().getAccountById(this.calendarFolder.getAccountId())) {
      return super.refreshData();
    }
  }
  
  public void render(int paramInt)
  {
    super.render(paramInt);
    this.mContainer.removeAllViews();
    createCalendarInfoTableView();
    if (this.calendarFolder.isShareOwnerFolder()) {
      createSharedToTableView();
    }
    for (;;)
    {
      if (canShareFolder()) {
        createShareButton();
      }
      if (canDeleteFolder()) {
        createDeleteButton();
      }
      return;
      if ((this.calendarFolder.isShareReceiverFolder()) && (!this.calendarFolder.isShareSystemFolder()))
      {
        createShareSourceTableView();
        createCancelShareButton();
      }
      else if (!this.calendarFolder.isLocalFolder()) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.fragment.CalendarDetailFragment
 * JD-Core Version:    0.7.0.1
 */