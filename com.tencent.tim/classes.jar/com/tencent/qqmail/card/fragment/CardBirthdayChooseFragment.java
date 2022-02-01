package com.tencent.qqmail.card.fragment;

import android.os.Build.VERSION;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.RotateAnimation;
import android.webkit.WebSettings;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.card.QMCardManager;
import com.tencent.qqmail.card.cursor.QMBirthdayFriendListCursor;
import com.tencent.qqmail.card.model.QMCardData;
import com.tencent.qqmail.card.model.QMCardFriendInfo;
import com.tencent.qqmail.card.model.QMCardPara;
import com.tencent.qqmail.card.util.CardUtil;
import com.tencent.qqmail.card.watcher.BatchLoadCardListWatch;
import com.tencent.qqmail.card.watcher.LoadBirthdayFriendListWatcher;
import com.tencent.qqmail.card.watcher.SaveCardWatcher;
import com.tencent.qqmail.fragment.base.QMBaseFragment.ViewHolder;
import com.tencent.qqmail.model.mail.callback.QMRefreshCallback;
import com.tencent.qqmail.model.qmdomain.MailContact;
import com.tencent.qqmail.model.qmdomain.MailContent;
import com.tencent.qqmail.model.qmdomain.MailInformation;
import com.tencent.qqmail.model.task.QMSendMailTask;
import com.tencent.qqmail.model.task.QMTaskManager;
import com.tencent.qqmail.model.uidomain.ComposeMailUI;
import com.tencent.qqmail.model.uidomain.ComposeMailUI.QMComposeMailType;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.utilities.QMPathManager;
import com.tencent.qqmail.utilities.fileextention.FileDefine;
import com.tencent.qqmail.utilities.fileextention.FileUtil;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.stringextention.StringExtention;
import com.tencent.qqmail.utilities.template.Template;
import com.tencent.qqmail.utilities.thread.Threads;
import com.tencent.qqmail.view.QMContentLoadingView;
import com.tencent.qqmail.view.QMTopBar;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import moai.core.watcher.Watchers;
import moai.fragment.base.BaseFragment.TransitionConfig;
import moai.view.SafeWebView;

public class CardBirthdayChooseFragment
  extends CardBaseFragment
{
  public static final int DEFAULT_SHOW_COUNT_WITH_EXPAND_BTN = 3;
  public static final int MAX_SHOW_COUNT_WITHOUT_EXPAND_BTN = 4;
  private static final String PREVIEW_URL = "qqmai://card/preview";
  private static final String TAG = "CardBirthdayChooseFragment";
  private long TEN_O_CLOCK = 36000000L;
  private final BatchLoadCardListWatch batchLoadCardListWatcher = new CardBirthdayChooseFragment.15(this);
  private Account defaultSendAccount = AccountManager.shareInstance().getAccountList().getFirstQQAccount();
  private QMBirthdayFriendListCursor friendListCursor = this.mCardManager.getBirthdayFriendList();
  private boolean fromSchema = false;
  private boolean isLoading = false;
  private final LoadBirthdayFriendListWatcher loadBirthdayFriendListWatcher = new CardBirthdayChooseFragment.2(this);
  private CardBirthdayChooseAdapter mAdapter;
  private QMCardData mCardData;
  private String mCardId;
  private final QMCardManager mCardManager = QMCardManager.shareInstance();
  private int mCurrentDegree = 0;
  private FrameLayout mExpandContainer;
  private ImageView mExpandIcon;
  private TextView mExpandTv;
  private ListView mListView;
  private QMContentLoadingView mLoadingView;
  private View mRootView;
  private ImageView mSendTimingCheckBox;
  private LinearLayout mSendTimingTipContainer;
  private QMTopBar mTopBar;
  private SafeWebView mWebView;
  private final QMRefreshCallback refreshCallback = new CardBirthdayChooseFragment.1(this);
  private int saveCardKey = 0;
  private final SaveCardWatcher saveCardWatcher = new CardBirthdayChooseFragment.10(this);
  
  public CardBirthdayChooseFragment() {}
  
  public CardBirthdayChooseFragment(QMCardData paramQMCardData)
  {
    this.mCardData = paramQMCardData;
    initCardPara();
  }
  
  public CardBirthdayChooseFragment(String paramString)
  {
    this.mCardData = this.mCardManager.getCardDataByCardId(paramString);
    initCardPara();
    this.mCardId = paramString;
    this.fromSchema = true;
  }
  
  private long calculateClockCardSendTime(long paramLong)
  {
    long l = System.currentTimeMillis();
    paramLong = 1000L * paramLong;
    if (l >= paramLong) {
      return 0L;
    }
    return this.TEN_O_CLOCK + paramLong;
  }
  
  private void handleSendMail(String paramString)
  {
    Object localObject5 = this.mAdapter.getSelectFriend();
    if (this.fromSchema) {
      onBackPressed();
    }
    for (;;)
    {
      Object localObject2;
      label43:
      Object localObject3;
      Object localObject4;
      Object localObject6;
      Object localObject1;
      Object localObject7;
      long l;
      label206:
      MailContact localMailContact;
      if (this.mSendTimingCheckBox.isSelected())
      {
        DataCollector.logEvent("Event_Card_Birthday_Timer_Send");
        localObject2 = ((ArrayList)localObject5).iterator();
        if (((Iterator)localObject2).hasNext())
        {
          localObject3 = (QMCardFriendInfo)((Iterator)localObject2).next();
          localObject4 = QMTaskManager.sharedInstance(1);
          localObject5 = new QMSendMailTask();
          localObject6 = new ComposeMailUI();
          ((ComposeMailUI)localObject6).setOriginAccountId(this.defaultSendAccount.getId());
          ((ComposeMailUI)localObject6).getInformation().setAccountId(this.defaultSendAccount.getId());
          ((ComposeMailUI)localObject6).getContent().setBody(paramString);
          localObject1 = new MailInformation();
          ((MailInformation)localObject1).setSubject(this.mCardData.getName());
          ((MailInformation)localObject1).setMessageId(ComposeMailUI.genMessageId());
          ((MailInformation)localObject1).setAccountId(this.defaultSendAccount.getId());
          ((ComposeMailUI)localObject6).setInformation((MailInformation)localObject1);
          localObject7 = new ArrayList();
          l = calculateClockCardSendTime(((QMCardFriendInfo)localObject3).getToDayTo());
          if (l != 0L) {
            break label449;
          }
          ((ComposeMailUI)localObject6).setType(ComposeMailUI.QMComposeMailType.COMPOSE_TYPE_CARD);
          localMailContact = new MailContact();
          if (StringExtention.isNullOrEmpty(((QMCardFriendInfo)localObject3).getEmail())) {
            break label466;
          }
          localObject1 = ((QMCardFriendInfo)localObject3).getEmail();
          label233:
          localMailContact.setAddress((String)localObject1);
          localMailContact.setName(((QMCardFriendInfo)localObject3).getNickName());
          localMailContact.setNick(((QMCardFriendInfo)localObject3).getNickName());
        }
      }
      try
      {
        localMailContact.setId(Long.parseLong(((QMCardFriendInfo)localObject3).getId()));
        label273:
        ((ArrayList)localObject7).add(localMailContact);
        ((ComposeMailUI)localObject6).getInformation().setToList((ArrayList)localObject7);
        ((ComposeMailUI)localObject6).setCardData(this.mCardData);
        ((QMSendMailTask)localObject5).setAccountId(this.defaultSendAccount.getId());
        ((QMSendMailTask)localObject5).setMail((ComposeMailUI)localObject6);
        Threads.runInBackground(new CardBirthdayChooseFragment.8(this, (QMTaskManager)localObject4, (QMSendMailTask)localObject5));
        QMCardManager.shareInstance().updateBirthdayFriendSend(((QMCardFriendInfo)localObject3).getId(), true);
        break label43;
        localObject1 = new HashMap();
        if ((localObject5 == null) || (((ArrayList)localObject5).size() == 0))
        {
          ((HashMap)localObject1).put(CardGalleryFragment.BIRTHDAY_CAKE_SHOW_EXTRA, Integer.valueOf(1));
          setFragmentResult(-1, (HashMap)localObject1);
          popBackStack();
          return;
        }
        localObject2 = CardGalleryFragment.BIRTHDAY_CAKE_SHOW_EXTRA;
        if (((ArrayList)localObject5).size() == this.friendListCursor.getCount()) {}
        for (int i = 0;; i = 1)
        {
          ((HashMap)localObject1).put(localObject2, Integer.valueOf(i));
          setFragmentResult(-1, (HashMap)localObject1);
          popBackStack();
          break;
        }
        label449:
        ((ComposeMailUI)localObject6).setType(ComposeMailUI.QMComposeMailType.COMPOSE_TYPE_CLOCKED_CARD);
        ((ComposeMailUI)localObject6).setClockSendTime(l);
        break label206;
        label466:
        localObject1 = ((QMCardFriendInfo)localObject3).getUin() + "@qq.com";
        break label233;
        DataCollector.logEvent("Event_Card_Birthday_Send");
        localObject1 = QMTaskManager.sharedInstance(1);
        localObject2 = new QMSendMailTask();
        localObject3 = new ComposeMailUI();
        ((ComposeMailUI)localObject3).setOriginAccountId(this.defaultSendAccount.getId());
        ((ComposeMailUI)localObject3).getInformation().setAccountId(this.defaultSendAccount.getId());
        ((ComposeMailUI)localObject3).getContent().setBody(paramString);
        paramString = new MailInformation();
        paramString.setSubject(this.mCardData.getName());
        paramString.setMessageId(ComposeMailUI.genMessageId());
        paramString.setAccountId(this.defaultSendAccount.getId());
        ((ComposeMailUI)localObject3).setInformation(paramString);
        localObject4 = new ArrayList();
        ((ComposeMailUI)localObject3).setType(ComposeMailUI.QMComposeMailType.COMPOSE_TYPE_CARD);
        localObject5 = ((ArrayList)localObject5).iterator();
        for (;;)
        {
          if (((Iterator)localObject5).hasNext())
          {
            localObject6 = (QMCardFriendInfo)((Iterator)localObject5).next();
            localObject7 = new MailContact();
            if (!StringExtention.isNullOrEmpty(((QMCardFriendInfo)localObject6).getEmail()))
            {
              paramString = ((QMCardFriendInfo)localObject6).getEmail();
              label676:
              ((MailContact)localObject7).setAddress(paramString);
              ((MailContact)localObject7).setName(((QMCardFriendInfo)localObject6).getNickName());
              ((MailContact)localObject7).setNick(((QMCardFriendInfo)localObject6).getNickName());
            }
          }
          try
          {
            ((MailContact)localObject7).setId(Long.parseLong(((QMCardFriendInfo)localObject6).getId()));
            label715:
            ((ArrayList)localObject4).add(localObject7);
            QMCardManager.shareInstance().updateBirthdayFriendSend(((QMCardFriendInfo)localObject6).getId(), true);
            continue;
            paramString = ((QMCardFriendInfo)localObject6).getUin() + "@qq.com";
            break label676;
            ((ComposeMailUI)localObject3).getInformation().setToList((ArrayList)localObject4);
            ((ComposeMailUI)localObject3).setCardData(this.mCardData);
            ((QMSendMailTask)localObject2).setAccountId(this.defaultSendAccount.getId());
            ((QMSendMailTask)localObject2).setMail((ComposeMailUI)localObject3);
            Threads.runInBackground(new CardBirthdayChooseFragment.9(this, (QMTaskManager)localObject1, (QMSendMailTask)localObject2));
            return;
          }
          catch (Exception paramString)
          {
            break label715;
          }
        }
      }
      catch (Exception localException)
      {
        break label273;
      }
    }
  }
  
  private void hideLoadingView()
  {
    this.mListView.setVisibility(0);
    this.mWebView.setVisibility(0);
    this.mLoadingView.hide();
  }
  
  private void initCardPara()
  {
    if (this.mCardData != null)
    {
      ArrayList localArrayList = this.mCardManager.getCardParaListByCardId(this.mCardData.getCardId());
      if ((localArrayList != null) && (localArrayList.size() > 0))
      {
        Iterator localIterator = localArrayList.iterator();
        while (localIterator.hasNext())
        {
          QMCardPara localQMCardPara = (QMCardPara)localIterator.next();
          String str1;
          if (localQMCardPara.getType() == 2)
          {
            String str2 = CardUtil.getDefaultSendName();
            int i = Math.min(32, localQMCardPara.getLimitCount());
            str1 = str2;
            if (str2.length() > i)
            {
              str1 = str2;
              if (i > 0) {
                str1 = str2.substring(0, i);
              }
            }
            localQMCardPara.setValue(str1);
          }
          else if (localQMCardPara.getType() == 0)
          {
            if (localQMCardPara.getDefaultValue() != null) {}
            for (str1 = localQMCardPara.getDefaultValue();; str1 = "")
            {
              localQMCardPara.setValue(str1);
              break;
            }
          }
        }
      }
      this.mCardData.setCardParaList(localArrayList);
    }
  }
  
  private void initListView()
  {
    this.mListView = ((ListView)this.mRootView.findViewById(2131370584));
    this.mExpandContainer = ((FrameLayout)this.mRootView.findViewById(2131366576));
    this.mExpandTv = ((TextView)this.mRootView.findViewById(2131366573));
    this.mExpandIcon = ((ImageView)this.mRootView.findViewById(2131366577));
    this.mListView.setOnItemClickListener(new CardBirthdayChooseFragment.11(this));
    this.mExpandContainer.setOnClickListener(new CardBirthdayChooseFragment.12(this));
  }
  
  private void initOther()
  {
    this.mLoadingView = ((QMContentLoadingView)this.mRootView.findViewById(2131370787));
    this.mLoadingView.setBackgroundResource(2131165531);
    this.mSendTimingTipContainer = ((LinearLayout)this.mRootView.findViewById(2131378008));
    this.mSendTimingCheckBox = ((ImageView)this.mRootView.findViewById(2131378007));
    this.mSendTimingCheckBox.setSelected(true);
    this.mSendTimingTipContainer.setOnClickListener(new CardBirthdayChooseFragment.13(this));
  }
  
  private void initTopBar()
  {
    this.mTopBar = ((QMTopBar)this.mRootView.findViewById(2131380043));
    this.mTopBar.setButtonLeftNormal(2131691246);
    this.mTopBar.setButtonRightBlue(2131719473);
    this.mTopBar.setTitle(2131691890);
    this.mTopBar.getButtonLeft().setOnClickListener(new CardBirthdayChooseFragment.6(this));
    this.mTopBar.getButtonRight().setOnClickListener(new CardBirthdayChooseFragment.7(this));
  }
  
  private void initWebView()
  {
    this.mWebView = ((SafeWebView)this.mRootView.findViewById(2131382171));
    this.mWebView.setHorizontalScrollBarEnabled(false);
    WebSettings localWebSettings = this.mWebView.getSettings();
    localWebSettings.setSupportZoom(false);
    localWebSettings.setBuiltInZoomControls(false);
    localWebSettings.setUseWideViewPort(true);
    localWebSettings.setLoadWithOverviewMode(true);
    localWebSettings.setDefaultTextEncodingName("UTF-8");
    localWebSettings.setAppCacheMaxSize(8388608L);
    if (FileUtil.hasSdcard()) {
      localWebSettings.setAppCachePath(QMPathManager.sharedInstance().getQQMailCacheDir());
    }
    localWebSettings.setDomStorageEnabled(true);
    localWebSettings.setDatabaseEnabled(true);
    if (Build.VERSION.SDK_INT < 19) {
      localWebSettings.setDatabasePath(FileDefine.INNER_DATA_DIR + "/databases/");
    }
    this.mWebView.setWebViewClient(new CardBirthdayChooseFragment.14(this));
    updateContent(this.mCardData);
  }
  
  private void recoverSendCard()
  {
    this.mTopBar.getButtonLeft().setEnabled(true);
    this.mTopBar.getButtonRight().setEnabled(true);
  }
  
  private void refreshCursor(boolean paramBoolean)
  {
    this.isLoading = true;
    runInBackground(new CardBirthdayChooseFragment.3(this, paramBoolean));
  }
  
  private void showEmptyView()
  {
    this.mListView.setVisibility(8);
    this.mWebView.setVisibility(8);
    this.mTopBar.getButtonRight().setEnabled(false);
    this.mLoadingView.showTips(2131691298);
  }
  
  private void showErrorView()
  {
    this.mListView.setVisibility(8);
    this.mWebView.setVisibility(8);
    this.mLoadingView.showTips(2131691298);
  }
  
  private void showListView()
  {
    if (this.mAdapter == null)
    {
      this.mAdapter = new CardBirthdayChooseAdapter(getActivity(), this.friendListCursor);
      this.mListView.setAdapter(this.mAdapter);
      this.mListView.setVisibility(0);
      if ((this.friendListCursor == null) || (this.friendListCursor.getCount() <= 4)) {
        break label119;
      }
      this.mExpandContainer.setVisibility(0);
    }
    for (;;)
    {
      this.mExpandTv.setText(String.format(getString(2131691272), new Object[] { Integer.valueOf(this.mAdapter.getSelectFriend().size()) }));
      return;
      this.mAdapter.notifyDataSetChanged();
      break;
      label119:
      this.mExpandContainer.setVisibility(8);
    }
  }
  
  private void showLoadingView()
  {
    this.mListView.setVisibility(8);
    this.mWebView.setVisibility(8);
    this.mLoadingView.showLoading(true);
  }
  
  private void syncBirthdayFriends()
  {
    this.isLoading = true;
    runInBackground(new CardBirthdayChooseFragment.4(this));
  }
  
  private void updateContent(QMCardData paramQMCardData)
  {
    if (paramQMCardData != null)
    {
      hideLoadingView();
      String str = Template.getTemplate(getActivity(), Template.CONTENT_HTML_CARD);
      HashMap localHashMap = CardUtil.allReplaceIntem();
      localHashMap.put(Integer.valueOf(2131691305), ".greetingCard_previewBtn {display: none !important;} .greetingCard_thanksBtn {display: none !important;}");
      localHashMap.put(Integer.valueOf(2131691313), paramQMCardData.getCardMailUrl());
      localHashMap.put(Integer.valueOf(2131691312), paramQMCardData.getCardOnePxUrl());
      localHashMap.put(Integer.valueOf(2131691306), "qqmai://card/preview");
      localHashMap.put(Integer.valueOf(2131691304), paramQMCardData.getMailWord());
      localHashMap.put(Integer.valueOf(2131691310), CardUtil.getDefaultSendName());
      paramQMCardData = CardUtil.replaceContentInSequence(str, localHashMap);
      this.mWebView.loadDataWithBaseURL("file:///read?t=mail", paramQMCardData, "text/html", "UTF-8", null);
    }
  }
  
  public void initDataSource() {}
  
  public View initUI(QMBaseFragment.ViewHolder paramViewHolder)
  {
    this.mRootView = LayoutInflater.from(getActivity()).inflate(2131558819, null);
    this.mRootView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    initTopBar();
    initListView();
    initOther();
    initWebView();
    return this.mRootView;
  }
  
  public void onBackPressed()
  {
    if (this.fromSchema) {
      startActivity(CardFragmentActivity.createIntentToGallery(this.mCardManager.getJumpCardDefaulType(), true));
    }
    super.onBackPressed();
  }
  
  public void onBindEvent(boolean paramBoolean)
  {
    Watchers.bind(this.loadBirthdayFriendListWatcher, paramBoolean);
    Watchers.bind(this.saveCardWatcher, paramBoolean);
    Watchers.bind(this.batchLoadCardListWatcher, paramBoolean);
  }
  
  public BaseFragment.TransitionConfig onFetchTransaction()
  {
    return SCALE_TRANSITION_CONFIG;
  }
  
  public int refreshData()
  {
    if (CardUtil.hasTodayGotBirthFriend())
    {
      refreshCursor(false);
      if (this.mCardData != null) {
        break label77;
      }
      if (StringExtention.isNullOrEmpty(this.mCardId)) {
        break label70;
      }
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(this.mCardId);
      runInBackground(new CardBirthdayChooseFragment.5(this, localArrayList));
    }
    for (;;)
    {
      return super.refreshData();
      syncBirthdayFriends();
      break;
      label70:
      showErrorView();
      continue;
      label77:
      updateContent(this.mCardData);
    }
  }
  
  public void render(int paramInt)
  {
    Log.v("zktest", "isLoading:" + this.isLoading);
    if (!this.isLoading)
    {
      if ((this.friendListCursor == null) || (this.friendListCursor.getCount() == 0)) {
        showEmptyView();
      }
    }
    else {
      return;
    }
    QMLog.log(4, "CardBirthdayChooseFragment", "birth friend count:" + this.friendListCursor.getCount());
    showListView();
    hideLoadingView();
  }
  
  public void rotateArrow(boolean paramBoolean)
  {
    if ((this.mCurrentDegree == 180) && (paramBoolean)) {}
    while ((this.mCurrentDegree == 0) && (!paramBoolean)) {
      return;
    }
    int i = this.mCurrentDegree;
    int j = (this.mCurrentDegree + 180) % 360;
    this.mCurrentDegree = j;
    RotateAnimation localRotateAnimation = new RotateAnimation(i, j, 1, 0.5F, 1, 0.5F);
    localRotateAnimation.setFillAfter(true);
    localRotateAnimation.setDuration(260L);
    this.mExpandIcon.startAnimation(localRotateAnimation);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.card.fragment.CardBirthdayChooseFragment
 * JD-Core Version:    0.7.0.1
 */