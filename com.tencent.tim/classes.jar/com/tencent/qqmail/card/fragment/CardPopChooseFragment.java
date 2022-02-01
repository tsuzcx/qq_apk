package com.tencent.qqmail.card.fragment;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.RotateAnimation;
import android.webkit.WebSettings;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.nineoldandroids.animation.ValueAnimator;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.activity.compose.ComposeContactsActivity;
import com.tencent.qqmail.card.QMCardManager;
import com.tencent.qqmail.card.model.QMCardData;
import com.tencent.qqmail.card.model.QMCardPara;
import com.tencent.qqmail.card.util.CardUtil;
import com.tencent.qqmail.card.view.CardAvatarChooseView;
import com.tencent.qqmail.card.watcher.BatchLoadCardListWatch;
import com.tencent.qqmail.card.watcher.LoadQQHotFriendWatcher;
import com.tencent.qqmail.card.watcher.SaveCardWatcher;
import com.tencent.qqmail.fragment.base.QMBaseFragment.ViewHolder;
import com.tencent.qqmail.model.mail.watcher.SyncPhotoWatcher;
import com.tencent.qqmail.model.protocol.QMPrivateProtocolManager;
import com.tencent.qqmail.model.qmdomain.MailContact;
import com.tencent.qqmail.model.qmdomain.MailContact.ContactType;
import com.tencent.qqmail.model.qmdomain.MailContent;
import com.tencent.qqmail.model.qmdomain.MailInformation;
import com.tencent.qqmail.model.task.QMSendMailTask;
import com.tencent.qqmail.model.task.QMTaskManager;
import com.tencent.qqmail.model.uidomain.ComposeMailUI;
import com.tencent.qqmail.model.uidomain.ComposeMailUI.QMComposeMailType;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.qmui.layout.QMUIFloatLayout;
import com.tencent.qqmail.trd.guava.Lists;
import com.tencent.qqmail.utilities.QMMath;
import com.tencent.qqmail.utilities.QMPathManager;
import com.tencent.qqmail.utilities.fileextention.FileDefine;
import com.tencent.qqmail.utilities.fileextention.FileUtil;
import com.tencent.qqmail.utilities.sharedpreference.SharedPreferenceUtil;
import com.tencent.qqmail.utilities.stringextention.StringExtention;
import com.tencent.qqmail.utilities.template.Template;
import com.tencent.qqmail.utilities.thread.Threads;
import com.tencent.qqmail.utilities.ui.PressableImageView;
import com.tencent.qqmail.utilities.ui.QMUIKit;
import com.tencent.qqmail.view.QMContentLoadingView;
import com.tencent.qqmail.view.QMTopBar;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import moai.core.watcher.Watchers;
import moai.view.SafeWebView;

public class CardPopChooseFragment
  extends CardBaseFragment
{
  private static final int FRIEND_LIST_TO_REQUEST = 0;
  private static final int MAX_SIZE_ONE_LINE = 5;
  private static final String PREVIEW_URL = "qqmai://card/preview";
  private String TAG = "CardPopChooseFragment";
  private boolean avatarLoadingFinish = false;
  private SyncPhotoWatcher avatarWatcher = new CardPopChooseFragment.10(this);
  private final BatchLoadCardListWatch batchLoadCardListWatcher = new CardPopChooseFragment.14(this);
  private List<CardAvatarChooseView> cardAvatarChooseViewList = Lists.newArrayList();
  private boolean cardDataLoadingFinish = false;
  private List<MailContact> contactHasAddToLayoutList = Lists.newArrayList();
  private boolean isContentLoadFinish = false;
  private boolean isFromSchema = false;
  private final LoadQQHotFriendWatcher loadQQHotFriendWatcher = new CardPopChooseFragment.16(this);
  private FrameLayout mAddLayout;
  private List<MailContact> mBaseContactList;
  private QMCardData mCardData;
  private String mCardId;
  private QMCardManager mCardManager = QMCardManager.shareInstance();
  private int mCellHeight;
  private int mCellWidth;
  private QMUIFloatLayout mChooseContainer;
  private int mCurrentDegree = 0;
  private FrameLayout mExpandContainer;
  private ImageView mExpandIcon;
  private TextView mExpandTv;
  private boolean mIsExtended;
  private QMContentLoadingView mLoadingView;
  private List<MailContact> mMailContactList = Lists.newArrayList();
  private int mOneLineShownCount;
  private int mRealLines;
  private View mRootView;
  private QMTopBar mTopBar;
  private SafeWebView mWebView;
  private int saveCardKey;
  private final SaveCardWatcher saveCardWatcher = new CardPopChooseFragment.15(this);
  private String schemaTo;
  private int schemaToToSel;
  private int schemaToTotal;
  @NonNull
  private AccountList sendAccountList = AccountManager.shareInstance().getAccountList();
  
  public CardPopChooseFragment(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    DataCollector.logEvent("Event_Card_Popularize_Show");
    this.mCardId = paramString1;
    this.schemaTo = paramString2;
    this.schemaToTotal = paramInt1;
    this.schemaToToSel = paramInt2;
    this.mCardData = this.mCardManager.getCardDataByCardId(this.mCardId);
    initCardPara();
  }
  
  public CardPopChooseFragment(String paramString1, String paramString2, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    this(paramString1, paramString2, paramInt1, paramInt2);
    this.isFromSchema = paramBoolean;
  }
  
  private int calcAvatarChooseItemWidth()
  {
    int i = getResources().getDimensionPixelSize(2131296814);
    int k = getResources().getDimensionPixelSize(2131296816);
    int j = getResources().getDimensionPixelSize(2131296820);
    k += j * 2;
    int m = QMUIKit.getScreenWidth() - (i - j) * 2;
    this.mOneLineShownCount = Math.min(m / k, 5);
    int n = m - this.mOneLineShownCount * k;
    m = i - j;
    j = m;
    i = k;
    if (n > 0)
    {
      j = n / this.mOneLineShownCount;
      i = k + j;
      j = m - j / 2;
    }
    this.mChooseContainer.setPadding(j, this.mChooseContainer.getPaddingTop(), j, this.mChooseContainer.getPaddingBottom());
    return i;
  }
  
  private void expandAnim()
  {
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.mChooseContainer.getLayoutParams();
    if (this.mIsExtended) {}
    for (ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { this.mCellHeight, this.mCellHeight * this.mRealLines });; localValueAnimator = ValueAnimator.ofInt(new int[] { this.mCellHeight * this.mRealLines, this.mCellHeight }))
    {
      localValueAnimator.addUpdateListener(new CardPopChooseFragment.11(this, localLayoutParams));
      localValueAnimator.setDuration(300L);
      localValueAnimator.start();
      return;
    }
  }
  
  private View generateCellView(MailContact paramMailContact)
  {
    CardAvatarChooseView localCardAvatarChooseView = new CardAvatarChooseView(getActivity());
    localCardAvatarChooseView.setLayoutParams(new ViewGroup.LayoutParams(this.mCellWidth, this.mCellHeight));
    localCardAvatarChooseView.setPadding(0, getResources().getDimensionPixelSize(2131296821), 0, 0);
    localCardAvatarChooseView.setAvatar(paramMailContact, true);
    localCardAvatarChooseView.setOnClickListener(new CardPopChooseFragment.9(this, localCardAvatarChooseView, paramMailContact));
    this.cardAvatarChooseViewList.add(localCardAvatarChooseView);
    return localCardAvatarChooseView;
  }
  
  private void handleNewSelectedAddress(boolean paramBoolean, Intent paramIntent)
  {
    if (paramBoolean)
    {
      this.mChooseContainer.removeView(this.mAddLayout);
      paramIntent = ComposeContactsActivity.getAllCheckedContacts().iterator();
    }
    label271:
    for (;;)
    {
      Object localObject;
      if (paramIntent.hasNext())
      {
        localObject = (MailContact)paramIntent.next();
        if ((!this.contactHasAddToLayoutList.contains(localObject)) && (!this.mMailContactList.contains(localObject)))
        {
          String str1 = ((MailContact)localObject).getAddress();
          String str2 = ((MailContact)localObject).getUin();
          Iterator localIterator = this.contactHasAddToLayoutList.iterator();
          while (localIterator.hasNext())
          {
            MailContact localMailContact = (MailContact)localIterator.next();
            if ((localMailContact.getAddress().equals(str1)) || ((!str2.equals("")) && (localMailContact.getUin().equals(str2)))) {
              selectCellView((MailContact)localObject);
            }
          }
        }
      }
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          break label271;
        }
        this.mMailContactList.add(localObject);
        this.contactHasAddToLayoutList.add(localObject);
        localObject = generateCellView((MailContact)localObject);
        this.mChooseContainer.addView((View)localObject);
        break;
        selectCellView((MailContact)localObject);
        break;
        paramIntent = this.mTopBar.getButtonRight();
        if (this.mMailContactList.size() > 0) {}
        for (paramBoolean = true;; paramBoolean = false)
        {
          paramIntent.setEnabled(paramBoolean);
          this.mChooseContainer.addView(this.mAddLayout);
          layoutWithCollapseExpand(true);
          return;
        }
      }
    }
  }
  
  private void handleSendMail(String paramString)
  {
    DataCollector.logEvent("Event_Card_Popularize_Send");
    onBackPressed();
    Object localObject2 = new ArrayList();
    long l = System.currentTimeMillis();
    Object localObject1 = SharedPreferenceUtil.getCardSendContactHashMap();
    Object localObject3 = this.mMailContactList.iterator();
    Object localObject4;
    while (((Iterator)localObject3).hasNext())
    {
      localObject4 = (MailContact)((Iterator)localObject3).next();
      ((ArrayList)localObject2).add(localObject4);
      ((ConcurrentHashMap)localObject1).put(((MailContact)localObject4).getAddress(), Long.valueOf(l));
    }
    SharedPreferenceUtil.setCardSendContactHashMap((ConcurrentHashMap)localObject1);
    localObject1 = this.sendAccountList.getDefaultMailAccount();
    if (localObject1 == null) {}
    for (;;)
    {
      return;
      Object localObject5;
      if (((Account)localObject1).isQQMail())
      {
        localObject3 = QMTaskManager.sharedInstance(1);
        localObject4 = new QMSendMailTask();
        localObject5 = new ComposeMailUI();
        ((ComposeMailUI)localObject5).setOriginAccountId(((Account)localObject1).getId());
        ((ComposeMailUI)localObject5).getInformation().setAccountId(((Account)localObject1).getId());
        ((ComposeMailUI)localObject5).getContent().setBody(paramString);
        ((ComposeMailUI)localObject5).setCardData(this.mCardData);
        ((ComposeMailUI)localObject5).createComposeCache();
        paramString = new MailInformation();
        ((ComposeMailUI)localObject5).setInformation(paramString);
        paramString.setSubject(this.mCardData.getName());
        paramString.setAccountId(((Account)localObject1).getId());
        paramString.setDate(new Date());
        paramString.setMessageId(ComposeMailUI.genMessageId());
        ((ComposeMailUI)localObject5).setType(ComposeMailUI.QMComposeMailType.COMPOSE_TYPE_CARD);
        ((ComposeMailUI)localObject5).getInformation().setToList((ArrayList)localObject2);
        ((QMSendMailTask)localObject4).setAccountId(((Account)localObject1).getId());
        ((QMSendMailTask)localObject4).setMail((ComposeMailUI)localObject5);
        Threads.runInBackground(new CardPopChooseFragment.12(this, (QMTaskManager)localObject3, (QMSendMailTask)localObject4));
        return;
      }
      int i = 0;
      while (i < this.mMailContactList.size())
      {
        localObject2 = QMTaskManager.sharedInstance(1);
        localObject3 = new QMSendMailTask();
        localObject4 = new ComposeMailUI();
        ((ComposeMailUI)localObject4).setOriginAccountId(((Account)localObject1).getId());
        ((ComposeMailUI)localObject4).getInformation().setAccountId(((Account)localObject1).getId());
        ((ComposeMailUI)localObject4).getContent().setBody(paramString);
        ((ComposeMailUI)localObject4).setCardData(this.mCardData);
        ((ComposeMailUI)localObject4).createComposeCache();
        localObject5 = new MailInformation();
        ((ComposeMailUI)localObject4).setInformation((MailInformation)localObject5);
        ((MailInformation)localObject5).setSubject(this.mCardData.getName());
        ((MailInformation)localObject5).setAccountId(((Account)localObject1).getId());
        ((MailInformation)localObject5).setDate(new Date());
        ((MailInformation)localObject5).setMessageId(ComposeMailUI.genMessageId());
        ((MailInformation)localObject5).setReferences("");
        Object localObject6 = this.mMailContactList.get(i);
        ((MailInformation)localObject5).setToList(Lists.newArrayList(new Object[] { localObject6 }));
        ((QMSendMailTask)localObject3).setAccountId(((Account)localObject1).getId());
        ((QMSendMailTask)localObject3).setMail((ComposeMailUI)localObject4);
        ((QMSendMailTask)localObject3).setId(QMMath.hashInt(localObject6.hashCode() + "^" + ((ComposeMailUI)localObject4).getComposeId()));
        Threads.runInBackground(new CardPopChooseFragment.13(this, (QMTaskManager)localObject2, (QMSendMailTask)localObject3));
        i += 1;
      }
    }
  }
  
  private void hideLoading()
  {
    this.mLoadingView.hide();
  }
  
  private void initAvatarZoneView()
  {
    int i;
    int j;
    if (this.schemaToTotal > this.mBaseContactList.size())
    {
      i = this.mBaseContactList.size();
      j = 0;
      label28:
      if (j >= i) {
        break label186;
      }
      if ((this.schemaToToSel != 1) && (this.schemaToTotal < this.mBaseContactList.size())) {
        break label112;
      }
      this.mMailContactList.add(this.mBaseContactList.get(j));
      this.contactHasAddToLayoutList.add(this.mBaseContactList.get(j));
    }
    for (;;)
    {
      j += 1;
      break label28;
      i = this.schemaToTotal;
      break;
      label112:
      int k = new Random().nextInt(this.mBaseContactList.size());
      localObject = (MailContact)this.mBaseContactList.get(k);
      this.mMailContactList.add(localObject);
      this.contactHasAddToLayoutList.add(localObject);
      this.mBaseContactList.remove(localObject);
    }
    label186:
    Object localObject = this.mMailContactList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      View localView = generateCellView((MailContact)((Iterator)localObject).next());
      this.mChooseContainer.addView(localView);
    }
    this.mChooseContainer.removeView(this.mAddLayout);
    this.mChooseContainer.addView(this.mAddLayout);
    layoutWithCollapseExpand(true);
    this.mExpandContainer.setOnClickListener(new CardPopChooseFragment.8(this));
    localObject = this.mTopBar.getButtonRight();
    if (this.mMailContactList.size() > 0) {}
    for (boolean bool = true;; bool = false)
    {
      ((View)localObject).setEnabled(bool);
      return;
    }
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
  
  private void initChooseContainer()
  {
    int i = getResources().getDimensionPixelSize(2131296821);
    this.mChooseContainer = ((QMUIFloatLayout)this.mRootView.findViewById(2131364601));
    this.mExpandContainer = ((FrameLayout)this.mRootView.findViewById(2131366576));
    this.mExpandTv = ((TextView)this.mRootView.findViewById(2131366573));
    this.mExpandIcon = ((ImageView)this.mRootView.findViewById(2131366577));
    this.mCellWidth = calcAvatarChooseItemWidth();
    this.mCellHeight = getResources().getDimensionPixelSize(2131296815);
    this.mAddLayout = new FrameLayout(getActivity());
    this.mAddLayout.setPadding(0, i, 0, i);
    this.mAddLayout.setLayoutParams(new ViewGroup.LayoutParams(this.mCellWidth, this.mCellHeight));
    PressableImageView localPressableImageView = new PressableImageView(getActivity());
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    localLayoutParams.gravity = 49;
    localPressableImageView.setLayoutParams(localLayoutParams);
    localPressableImageView.setImageResource(2130840866);
    this.mAddLayout.addView(localPressableImageView);
    localPressableImageView.setOnClickListener(new CardPopChooseFragment.3(this));
  }
  
  private void initTopBar()
  {
    this.mTopBar = ((QMTopBar)this.mRootView.findViewById(2131380043));
    this.mTopBar.setButtonLeftNormal(2131691246);
    this.mTopBar.setButtonRightBlue(2131719473);
    this.mTopBar.setTitle(2131691317);
    this.mTopBar.getButtonLeft().setOnClickListener(new CardPopChooseFragment.1(this));
    this.mTopBar.getButtonRight().setOnClickListener(new CardPopChooseFragment.2(this));
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
    this.mWebView.setWebViewClient(new CardPopChooseFragment.4(this));
  }
  
  private void layoutWithCollapseExpand(boolean paramBoolean)
  {
    updateContactsLines();
    TextView localTextView;
    if ((this.mRealLines > 1) && (paramBoolean))
    {
      i = 1;
      if (this.contactHasAddToLayoutList.size() + 1 > this.mOneLineShownCount) {
        break label80;
      }
      this.mExpandContainer.setVisibility(8);
      localTextView = this.mExpandTv;
      if (!this.mIsExtended) {
        break label148;
      }
    }
    label148:
    for (int i = 2131691271;; i = 2131691273)
    {
      localTextView.setText(i);
      rotateArrow(this.mIsExtended);
      return;
      i = 0;
      break;
      label80:
      this.mExpandContainer.setVisibility(0);
      if (i != 0) {
        this.mIsExtended = true;
      }
      for (this.mChooseContainer.getLayoutParams().height = (this.mCellHeight * this.mRealLines);; this.mChooseContainer.getLayoutParams().height = this.mCellHeight)
      {
        this.mExpandContainer.requestLayout();
        break;
        this.mIsExtended = false;
      }
    }
  }
  
  private void recoverSendCard()
  {
    this.mTopBar.getButtonLeft().setEnabled(true);
    this.mTopBar.getButtonRight().setEnabled(true);
  }
  
  private void selectCellView(MailContact paramMailContact)
  {
    Iterator localIterator = this.cardAvatarChooseViewList.iterator();
    while (localIterator.hasNext())
    {
      CardAvatarChooseView localCardAvatarChooseView = (CardAvatarChooseView)localIterator.next();
      if ((localCardAvatarChooseView.getTag().equals(paramMailContact.getAddress())) && (!localCardAvatarChooseView.getChecked()))
      {
        this.mMailContactList.add(paramMailContact);
        localCardAvatarChooseView.setChecked(true);
      }
    }
  }
  
  private void showErrView()
  {
    this.mLoadingView.showTips(2131695454);
  }
  
  private void showLoading()
  {
    this.mLoadingView.showLoading(true);
  }
  
  private void updateContactsLines()
  {
    int i = this.contactHasAddToLayoutList.size() + 1;
    if (i % this.mOneLineShownCount == 0) {
      i /= this.mOneLineShownCount;
    }
    for (;;)
    {
      this.mRealLines = i;
      return;
      i = i / this.mOneLineShownCount + 1;
    }
  }
  
  private void updateContent()
  {
    this.cardDataLoadingFinish = true;
    if (this.avatarLoadingFinish) {
      hideLoading();
    }
    if (this.isContentLoadFinish) {
      return;
    }
    String str = Template.getTemplate(getActivity(), Template.CONTENT_HTML_CARD);
    HashMap localHashMap = CardUtil.allReplaceIntem();
    localHashMap.put(Integer.valueOf(2131691305), ".greetingCard_previewBtn {display: none !important;} .greetingCard_thanksBtn {display: none !important;}");
    localHashMap.put(Integer.valueOf(2131691313), this.mCardData.getCardMailUrl());
    localHashMap.put(Integer.valueOf(2131691312), this.mCardData.getCardOnePxUrl());
    localHashMap.put(Integer.valueOf(2131691306), "qqmai://card/preview");
    localHashMap.put(Integer.valueOf(2131691304), this.mCardData.getMailWord());
    localHashMap.put(Integer.valueOf(2131691310), CardUtil.getDefaultSendName());
    str = CardUtil.replaceContentInSequence(str, localHashMap);
    this.mWebView.loadDataWithBaseURL("file:///read?t=mail", str, "text/html", "UTF-8", null);
  }
  
  public void initDataSource()
  {
    Account localAccount = this.sendAccountList.getFirstQQAccount();
    if (localAccount == null) {
      return;
    }
    int j = localAccount.getId();
    int[] arrayOfInt = new int[0];
    String str = this.schemaTo;
    int i = -1;
    switch (str.hashCode())
    {
    default: 
      switch (i)
      {
      default: 
        arrayOfInt = new int[7];
        arrayOfInt[0] = MailContact.ContactType.NormalContact.ordinal();
        arrayOfInt[1] = MailContact.ContactType.PhoneContact.ordinal();
        arrayOfInt[2] = MailContact.ContactType.ProtocolContact.ordinal();
        arrayOfInt[3] = MailContact.ContactType.GroupContact.ordinal();
        arrayOfInt[4] = MailContact.ContactType.QQFriendContact.ordinal();
        arrayOfInt[5] = MailContact.ContactType.DomainContact.ordinal();
        arrayOfInt[6] = MailContact.ContactType.HistoryContact.ordinal();
      }
      break;
    }
    for (;;)
    {
      showLoading();
      if (this.schemaTo.equals("qqhot")) {
        break label287;
      }
      runInBackground(new CardPopChooseFragment.5(this, new int[] { j }, arrayOfInt));
      return;
      if (!str.equals("hot")) {
        break;
      }
      i = 0;
      break;
      if (!str.equals("qq")) {
        break;
      }
      i = 1;
      break;
      if (!str.equals("qqhot")) {
        break;
      }
      i = 2;
      break;
      arrayOfInt = new int[1];
      arrayOfInt[0] = MailContact.ContactType.HistoryContact.ordinal();
      continue;
      arrayOfInt = new int[1];
      arrayOfInt[0] = MailContact.ContactType.QQFriendContact.ordinal();
    }
    label287:
    runInBackground(new CardPopChooseFragment.6(this, localAccount));
  }
  
  public View initUI(QMBaseFragment.ViewHolder paramViewHolder)
  {
    this.mRootView = LayoutInflater.from(getActivity()).inflate(2131558825, null);
    this.mRootView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    initTopBar();
    initChooseContainer();
    initWebView();
    this.mLoadingView = ((QMContentLoadingView)this.mRootView.findViewById(2131370787));
    this.mLoadingView.setBackgroundResource(2131165531);
    return this.mRootView;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    switch (paramInt1)
    {
    default: 
      return;
    }
    if (paramInt2 == -1) {}
    for (boolean bool = true;; bool = false)
    {
      handleNewSelectedAddress(bool, paramIntent);
      return;
    }
  }
  
  public void onBackPressed()
  {
    if (this.isFromSchema) {
      startActivity(CardFragmentActivity.createIntentToGallery(this.mCardManager.getJumpCardDefaulType(), true));
    }
    super.onBackPressed();
  }
  
  public void onBindEvent(boolean paramBoolean)
  {
    Watchers.bind(this.batchLoadCardListWatcher, paramBoolean);
    Watchers.bind(this.saveCardWatcher, paramBoolean);
    Watchers.bind(this.loadQQHotFriendWatcher, paramBoolean);
    QMPrivateProtocolManager.sharedInstance().bindSyncPhotoWatcher(this.avatarWatcher, paramBoolean);
  }
  
  public int refreshData()
  {
    if (this.mCardData == null) {
      if (!StringExtention.isNullOrEmpty(this.mCardId))
      {
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(this.mCardId);
        runInBackground(new CardPopChooseFragment.7(this, localArrayList));
      }
    }
    for (;;)
    {
      return super.refreshData();
      showErrView();
      continue;
      updateContent();
    }
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
 * Qualified Name:     com.tencent.qqmail.card.fragment.CardPopChooseFragment
 * JD-Core Version:    0.7.0.1
 */