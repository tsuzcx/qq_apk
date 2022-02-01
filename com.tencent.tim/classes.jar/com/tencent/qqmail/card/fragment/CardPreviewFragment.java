package com.tencent.qqmail.card.fragment;

import Override;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.FrameLayout.LayoutParams;
import android.widget.Toast;
import com.tencent.qqlive.module.videoreport.inject.webview.jsinject.JsInjector;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.activity.compose.ComposeMailActivity;
import com.tencent.qqmail.activity.webviewexplorer.BaseSafeWebViewClient;
import com.tencent.qqmail.card.CardSendTypeEnum;
import com.tencent.qqmail.card.QMCardManager;
import com.tencent.qqmail.card.model.QMCardData;
import com.tencent.qqmail.card.model.QMCardPara;
import com.tencent.qqmail.card.util.CardUtil;
import com.tencent.qqmail.card.watcher.BatchLoadCardListWatch;
import com.tencent.qqmail.card.watcher.LoadCardContentWatcher;
import com.tencent.qqmail.card.watcher.SaveCardWatcher;
import com.tencent.qqmail.download.ImageDownloadManager;
import com.tencent.qqmail.download.model.DownloadInfo;
import com.tencent.qqmail.fragment.base.QMBaseFragment.ViewHolder;
import com.tencent.qqmail.marcos.AppConfig;
import com.tencent.qqmail.model.mail.QMSettingManager;
import com.tencent.qqmail.model.mail.watcher.SyncPhotoWatcher;
import com.tencent.qqmail.model.protocol.QMPrivateProtocolManager;
import com.tencent.qqmail.model.qmdomain.MailInformation;
import com.tencent.qqmail.model.uidomain.ComposeMailUI;
import com.tencent.qqmail.model.uidomain.ComposeMailUI.QMComposeMailType;
import com.tencent.qqmail.popularize.JSApiUitil;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.utilities.QMPathManager;
import com.tencent.qqmail.utilities.deviceid.DeviceUtil;
import com.tencent.qqmail.utilities.fileextention.FileDefine;
import com.tencent.qqmail.utilities.fileextention.FileUtil;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import com.tencent.qqmail.utilities.ui.BottomHorizonLineView;
import com.tencent.qqmail.utilities.ui.PressableImageView;
import com.tencent.qqmail.utilities.ui.QMAvatar;
import com.tencent.qqmail.utilities.ui.QMEditDialog;
import com.tencent.qqmail.utilities.ui.QMEditDialog.EditBuilder;
import com.tencent.qqmail.utilities.ui.QMTips;
import com.tencent.qqmail.utilities.validate.ValidateHelper;
import com.tencent.qqmail.view.QMContentLoadingView;
import com.tencent.qqmail.view.QMTopBar;
import com.tencent.qqmail.view.QMWebView;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import moai.core.utilities.string.StringExtention;
import moai.core.watcher.Watchers;
import moai.fragment.app.FragmentActivity;

public class CardPreviewFragment
  extends CardBaseFragment
{
  private static final int COMPOSE_TO_REQUEST = 0;
  private static final String TAG = "CardPreviewFragment";
  private final BatchLoadCardListWatch batchLoadCardListWatch = new CardPreviewFragment.3(this);
  private boolean fromSchema;
  private final LoadCardContentWatcher loadCardContentWatcher = new CardPreviewFragment.1(this);
  private final boolean mCanShare;
  private String mCardContent;
  private QMCardData mCardData;
  private final String mCardId;
  private final QMCardManager mCardManager = QMCardManager.shareInstance();
  private boolean mEdited = false;
  private ArrayList<QMCardPara> mEditedCardParaList;
  private QMContentLoadingView mLoadingView;
  private QMTopBar mQMTopBar;
  private ViewGroup mRootView;
  private BottomHorizonLineView mShareBottomView;
  private ShareComponent mShareComponent = new ShareComponent(null);
  private QMTips mTips;
  private final int mTypeId;
  private WebView mWebView;
  private final SyncPhotoWatcher syncPhotoWatcher = new CardPreviewFragment.2(this);
  
  public CardPreviewFragment(int paramInt, QMCardData paramQMCardData)
  {
    this(paramInt, paramQMCardData, true);
  }
  
  public CardPreviewFragment(int paramInt, QMCardData paramQMCardData, boolean paramBoolean)
  {
    this.mTypeId = paramInt;
    this.mCardData = paramQMCardData;
    this.mCardId = paramQMCardData.getCardId();
    this.mCardData.setCardParaList(this.mCardManager.getCardParaListByCardId(this.mCardData.getCardId()));
    if (this.mCardData.getCardParaList() == null) {}
    for (paramInt = i;; paramInt = this.mCardData.getCardParaList().size())
    {
      this.mEditedCardParaList = new ArrayList(paramInt);
      initCardPara();
      this.mCanShare = paramBoolean;
      Log.i("CardPreviewFragment", "CardPreviewFragment cardId:" + this.mCardId);
      return;
    }
  }
  
  public CardPreviewFragment(String paramString)
  {
    this.mTypeId = -1;
    this.mCardData = null;
    this.mCardId = paramString;
    this.mEditedCardParaList = new ArrayList();
    this.mCanShare = true;
    this.fromSchema = true;
    Log.i("CardPreviewFragment", "CardPreviewFragment cardId:" + paramString);
  }
  
  private int getEditedCardParaCount()
  {
    Iterator localIterator = this.mEditedCardParaList.iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      if (!isEditedCardPara((QMCardPara)localIterator.next())) {
        break label44;
      }
      i += 1;
    }
    label44:
    for (;;)
    {
      break;
      return i;
    }
  }
  
  private void gotoComposeCard()
  {
    DataCollector.logEvent("Event_Card_Mail_Send");
    int i = this.mCardManager.getDefaultAccount().getId();
    ComposeMailUI localComposeMailUI = new ComposeMailUI();
    localComposeMailUI.setType(ComposeMailUI.QMComposeMailType.COMPOSE_TYPE_CARD);
    this.mCardData.setCardParaList(this.mEditedCardParaList);
    localComposeMailUI.setCardData(this.mCardData);
    String str = replace(this.mCardData.getMailTitle());
    MailInformation localMailInformation = new MailInformation();
    localMailInformation.setSubject(str);
    localMailInformation.setMessageId(ComposeMailUI.genMessageId());
    localMailInformation.setAccountId(i);
    localComposeMailUI.setInformation(localMailInformation);
    startActivityForResult(ComposeMailActivity.createIntentFromCard(getActivity(), localComposeMailUI), 0);
  }
  
  private void gotoPopularPage()
  {
    startFragment(new CardPopChooseFragment(this.mCardId, CardSendTypeEnum.getSchemaTo(this.mCardData.getFriendType()), this.mCardData.getFriendNum(), this.mCardData.getSeqType()));
  }
  
  private void hideLoading()
  {
    Log.d("CardPreviewFragment", "hideLoading");
    this.mLoadingView.hide();
  }
  
  private void initCardPara()
  {
    Iterator localIterator = this.mCardData.getCardParaList().iterator();
    Object localObject2;
    Object localObject1;
    while (localIterator.hasNext())
    {
      QMCardPara localQMCardPara = (QMCardPara)localIterator.next();
      localObject2 = new QMCardPara(localQMCardPara);
      this.mEditedCardParaList.add(localObject2);
      if (this.mTypeId != 1) {
        switch (localQMCardPara.getType())
        {
        default: 
          break;
        case 0: 
          ((QMCardPara)localObject2).setValue(((QMCardPara)localObject2).getDefaultValue());
          break;
        case 1: 
          localObject1 = this.mCardManager.getDefaultAccount();
          localObject2 = QMSettingManager.sharedInstance().getAccountIconLocal(((Account)localObject1).getEmail(), 3);
          if (localObject2 != null)
          {
            updateCardParamTypeAvatar((Bitmap)localObject2);
          }
          else
          {
            updateCardParamTypeAvatar(new QMAvatar(1, CardUtil.getDefaultSendName()).getBitmap());
            QMPrivateProtocolManager.sharedInstance().loadEmailIconDirectly(((Account)localObject1).getEmail());
          }
          break;
        case 2: 
          localObject1 = CardUtil.getDefaultSendName();
          int i = Math.min(32, localQMCardPara.getLimitCount());
          if ((((String)localObject1).length() <= i) || (i <= 0)) {
            break label218;
          }
          localObject1 = ((String)localObject1).substring(0, i);
        }
      }
    }
    label218:
    for (;;)
    {
      ((QMCardPara)localObject2).setValue((String)localObject1);
      break;
      return;
    }
  }
  
  private void initShareBar()
  {
    this.mShareBottomView = ((BottomHorizonLineView)this.mRootView.findViewById(2131363675));
    if (!this.mCanShare)
    {
      this.mShareBottomView.setVisibility(8);
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.mWebView.getLayoutParams();
      localLayoutParams.bottomMargin = 0;
      this.mWebView.setLayoutParams(localLayoutParams);
    }
    if ((getEditedCardParaCount() > 0) && (this.mTypeId != 1))
    {
      this.mShareBottomView.addItem(2130840864, new CardPreviewFragment.6(this), true);
      this.mShareBottomView.getPressableImageViewByResourcesId(2130840864).setContentDescription(getString(2131720805));
      this.mShareBottomView.toggleRightFixedViewVisiable(true);
    }
    for (;;)
    {
      this.mShareBottomView.addItem(2130840868, new CardPreviewFragment.7(this));
      this.mShareBottomView.getPressableImageViewByResourcesId(2130840868).setContentDescription(getString(2131720806));
      if (DeviceUtil.isWeChatInstalled())
      {
        if (!this.mCardData.isWxShareLimit())
        {
          this.mShareBottomView.addItem(2130840871, new CardPreviewFragment.8(this));
          this.mShareBottomView.getPressableImageViewByResourcesId(2130840871).setContentDescription(getString(2131720808));
        }
        if (!this.mCardData.isCirclelimit())
        {
          this.mShareBottomView.addItem(2130840869, new CardPreviewFragment.9(this));
          this.mShareBottomView.getPressableImageViewByResourcesId(2130840869).setContentDescription(getString(2131720809));
        }
      }
      if ((DeviceUtil.isQQInstalled()) && (!this.mCardData.isQqShareLimit()))
      {
        this.mShareBottomView.addItem(2130840870, new CardPreviewFragment.10(this));
        this.mShareBottomView.getPressableImageViewByResourcesId(2130840870).setContentDescription(getString(2131720807));
      }
      return;
      this.mShareBottomView.toggleRightFixedViewVisiable(false);
    }
  }
  
  private boolean isEditedCardPara(QMCardPara paramQMCardPara)
  {
    return (paramQMCardPara.getType() == 0) || (paramQMCardPara.getType() == 2);
  }
  
  private void onShareComplete()
  {
    this.mEdited = false;
    Log.d("CardPreviewFragment", "onShareComplete");
    this.mTips.hide();
  }
  
  private void onShareError(QMNetworkError paramQMNetworkError)
  {
    this.mEdited = false;
    Log.d("CardPreviewFragment", "onShareError");
    this.mTips.hide();
    Toast.makeText(getActivity(), getActivity().getString(2131691332), 0).show();
  }
  
  private void onShareLoading()
  {
    Log.d("CardPreviewFragment", "onShareLoading");
    this.mTips.showLoading("加载中...");
  }
  
  private String replace(String paramString)
  {
    Iterator localIterator = this.mEditedCardParaList.iterator();
    while (localIterator.hasNext())
    {
      QMCardPara localQMCardPara = (QMCardPara)localIterator.next();
      if ((localQMCardPara.getDomId() != null) && (localQMCardPara.getValue() != null)) {
        paramString = paramString.replace("$" + localQMCardPara.getDomId() + "$", localQMCardPara.getValue());
      }
    }
    return paramString;
  }
  
  private void showEditDialog()
  {
    QMEditDialog.EditBuilder localEditBuilder = new QMEditDialog.EditBuilder(getActivity());
    localEditBuilder.setTopbarLeftListener(2131691246, new CardPreviewFragment.12(this));
    localEditBuilder.setTopbarRightListener(2131693745, new CardPreviewFragment.13(this, localEditBuilder));
    Iterator localIterator = this.mEditedCardParaList.iterator();
    while (localIterator.hasNext())
    {
      QMCardPara localQMCardPara = (QMCardPara)localIterator.next();
      Log.d("CardPreviewFragment", "showEditDialog: Name: " + localQMCardPara.getName() + ", def: " + localQMCardPara.getDefaultValue() + ", val: " + localQMCardPara.getValue());
      if (isEditedCardPara(localQMCardPara))
      {
        String str = localQMCardPara.getName();
        if (localQMCardPara.getValue() == null) {}
        for (localObject = localQMCardPara.getDefaultValue();; localObject = localQMCardPara.getValue())
        {
          localEditBuilder.addItem(str, (String)localObject, localQMCardPara.getDefaultValue(), Integer.valueOf(localQMCardPara.getLimitCount()));
          break;
        }
      }
    }
    Object localObject = localEditBuilder.build();
    ((QMEditDialog)localObject).setUpAnimationListener(new CardPreviewFragment.14(this));
    ((QMEditDialog)localObject).show();
  }
  
  private void showErrView()
  {
    Log.d("CardPreviewFragment", "showErrView");
    this.mShareBottomView.setVisibility(8);
    this.mLoadingView.showTips(2131695454);
  }
  
  private void showLoading()
  {
    Log.d("CardPreviewFragment", "showLoading");
    this.mLoadingView.showLoading(true);
  }
  
  private void updateCardPara()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.mEditedCardParaList.iterator();
    while (localIterator.hasNext())
    {
      QMCardPara localQMCardPara = (QMCardPara)localIterator.next();
      switch (localQMCardPara.getType())
      {
      case 1: 
      default: 
        break;
      case 0: 
      case 2: 
        for (;;)
        {
          localArrayList.add(localQMCardPara);
          break;
          localArrayList.add(localQMCardPara);
          CardUtil.setDefaultSendName(localQMCardPara.getValue());
        }
      }
    }
    if (localArrayList.size() > 0) {
      this.mCardManager.updateCardParaList(localArrayList);
    }
  }
  
  private void updateCardParamTypeAvatar(Bitmap paramBitmap)
  {
    Iterator localIterator = this.mEditedCardParaList.iterator();
    while (localIterator.hasNext())
    {
      QMCardPara localQMCardPara = (QMCardPara)localIterator.next();
      if (localQMCardPara.getType() == 1)
      {
        Object localObject = new ByteArrayOutputStream();
        paramBitmap.compress(Bitmap.CompressFormat.JPEG, 100, (OutputStream)localObject);
        localObject = ((ByteArrayOutputStream)localObject).toByteArray();
        localObject = StringExtention.base64Encode((byte[])localObject, localObject.length);
        localQMCardPara.setValue("data:image/jpg;base64," + (String)localObject);
      }
    }
  }
  
  private void updateContent()
  {
    if (this.mCardContent != null)
    {
      if (!this.mCanShare) {
        break label63;
      }
      this.mShareBottomView.setVisibility(0);
    }
    for (;;)
    {
      if (Build.VERSION.SDK_INT > 16) {
        this.mWebView.getSettings().setMediaPlaybackRequiresUserGesture(false);
      }
      this.mWebView.loadDataWithBaseURL("file://card", this.mCardContent, "text/html", "utf-8", null);
      return;
      label63:
      this.mShareBottomView.setVisibility(8);
    }
  }
  
  private void updateContentWithCardPara()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = this.mEditedCardParaList.iterator();
    while (localIterator.hasNext())
    {
      QMCardPara localQMCardPara = (QMCardPara)localIterator.next();
      if ((localQMCardPara.getDomId() != null) && (localQMCardPara.getValue() != null))
      {
        String str2;
        switch (localQMCardPara.getType())
        {
        default: 
          break;
        case 0: 
        case 2: 
          str2 = localQMCardPara.getDomId();
          if (localQMCardPara.getValue() != null) {}
        case 1: 
          for (String str1 = "";; str1 = localQMCardPara.getValue())
          {
            localStringBuilder.append(String.format("try { for (var i = 0,  doms = document.getElementsByName('%s'); i < doms.length; i++) { doms[i].innerText = '%s'; } } catch(e){} ", new Object[] { str2, str1 }));
            if (localQMCardPara.getType() != 2) {
              break;
            }
            break;
            localStringBuilder.append(String.format("try { for (var i = 0,  doms = document.getElementsByName('%s'); i < doms.length; i++) { doms[i].src = '%s'; } } catch(e){} ", new Object[] { localQMCardPara.getDomId(), localQMCardPara.getValue() }));
            break;
          }
        }
      }
    }
    Log.v("CardPreviewFragment", "updateContentWithCardPara js: " + localStringBuilder.toString());
    JSApiUitil.excuteJavaScript(this.mWebView, localStringBuilder.toString());
  }
  
  public void initDataSource()
  {
    super.initDataSource();
    if (this.mCardData != null)
    {
      this.mCardContent = this.mCardManager.getCardDataContent(this.mCardData.getCardUrl());
      if (this.mCardContent == null)
      {
        showLoading();
        this.mCardManager.loadCardDataContent(this.mCardData.getCardId(), this.mCardData.getCardUrl());
      }
    }
  }
  
  public void initDom(View paramView, QMBaseFragment.ViewHolder paramViewHolder, Bundle paramBundle)
  {
    long l1 = System.currentTimeMillis();
    initTopbar();
    long l2 = System.currentTimeMillis();
    initWebview();
    long l3 = System.currentTimeMillis();
    initShareBar();
    long l4 = System.currentTimeMillis();
    updateContent();
    long l5 = System.currentTimeMillis();
    Log.i("CardPreviewFragment", String.format("initDom [%d][%d,%d,%d,%d]", new Object[] { Long.valueOf(l5 - l1), Long.valueOf(l2 - l1), Long.valueOf(l3 - l2), Long.valueOf(l4 - l3), Long.valueOf(l5 - l4) }));
  }
  
  public void initTopbar()
  {
    this.mQMTopBar = ((QMTopBar)this.mRootView.findViewById(2131380043));
    this.mQMTopBar.setBackgroundColor(0);
    this.mQMTopBar.setButtonLeftBack(2130840867);
    this.mQMTopBar.setButtonLeftOnclickListener(new CardPreviewFragment.5(this));
  }
  
  public View initUI(QMBaseFragment.ViewHolder paramViewHolder)
  {
    long l1 = System.currentTimeMillis();
    this.mRootView = ((ViewGroup)LayoutInflater.from(getActivity()).inflate(2131558826, null));
    paramViewHolder = new ViewGroup.LayoutParams(-1, -1);
    this.mRootView.setLayoutParams(paramViewHolder);
    long l2 = System.currentTimeMillis();
    this.mLoadingView = ((QMContentLoadingView)this.mRootView.findViewById(2131370787));
    this.mLoadingView.setBackgroundResource(2131165531);
    Log.i("CardPreviewFragment", "intiUI time: " + (l2 - l1));
    this.mTips = new QMTips(getActivity());
    this.mTips.setCanceledOnTouchOutside(true);
    return this.mRootView;
  }
  
  public void initWebview()
  {
    this.mWebView = ((QMWebView)this.mRootView.findViewById(2131382171));
    WebSettings localWebSettings = this.mWebView.getSettings();
    localWebSettings.setJavaScriptEnabled(true);
    localWebSettings.setSupportZoom(false);
    localWebSettings.setBuiltInZoomControls(false);
    localWebSettings.setDefaultTextEncodingName("UTF-8");
    localWebSettings.setUseWideViewPort(true);
    localWebSettings.setLoadWithOverviewMode(true);
    localWebSettings.setAppCacheMaxSize(8388608L);
    if (FileUtil.hasSdcard()) {
      localWebSettings.setAppCachePath(QMPathManager.sharedInstance().getQQMailCacheDir());
    }
    localWebSettings.setDomStorageEnabled(true);
    localWebSettings.setDatabaseEnabled(true);
    localWebSettings.setUserAgentString(localWebSettings.getUserAgentString() + " mailapp/" + AppConfig.getCodeVersionName());
    if (Build.VERSION.SDK_INT < 19) {
      localWebSettings.setDatabasePath(FileDefine.INNER_DATA_DIR + "/databases/");
    }
    this.mWebView.requestFocus(130);
    this.mWebView.setWebViewClient(new BaseWebViewClient());
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    switch (paramInt1)
    {
    }
    do
    {
      return;
    } while (paramInt2 != -1);
    popBackStack();
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
    super.onBindEvent(paramBoolean);
    Watchers.bind(this.loadCardContentWatcher, paramBoolean);
    Watchers.bind(this.syncPhotoWatcher, paramBoolean);
    Watchers.bind(this.batchLoadCardListWatch, paramBoolean);
    this.mShareComponent.bind(paramBoolean);
  }
  
  public void onRelease()
  {
    this.mRootView.removeAllViews();
    try
    {
      WebView localWebView = this.mWebView;
      this.mWebView = null;
      localWebView.setWebViewClient(null);
      localWebView.setWebChromeClient(null);
      localWebView.stopLoading();
      localWebView.getSettings().setJavaScriptEnabled(false);
      localWebView.clearHistory();
      localWebView.clearCache(true);
      localWebView.destroy();
      return;
    }
    catch (Exception localException)
    {
      QMLog.log(5, "CardPreviewFragment", "release webview exception", localException);
    }
  }
  
  public int refreshData()
  {
    if ((this.mCardData == null) && (!StringExtention.isNullOrEmpty(this.mCardId)))
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(this.mCardId);
      runInBackground(new CardPreviewFragment.4(this, localArrayList));
    }
    return super.refreshData();
  }
  
  public void render(int paramInt) {}
  
  public class BaseWebViewClient
    extends BaseSafeWebViewClient
  {
    private boolean firstTime = true;
    
    protected BaseWebViewClient() {}
    
    @Override
    public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
    {
      JsInjector.getInstance().onPageStarted(paramWebView);
      super.onPageStarted(paramWebView, paramString, paramBitmap);
    }
    
    public void onSafePageFinished(WebView paramWebView, String paramString)
    {
      if (CardPreviewFragment.this.mWebView == null) {}
      do
      {
        return;
        QMLog.log(4, "CardPreviewFragment", "CardPreviewFragment PageFinish");
      } while (!this.firstTime);
      this.firstTime = false;
      CardPreviewFragment.this.updateContentWithCardPara();
    }
    
    public void onSafePageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
    {
      super.onSafePageStarted(paramWebView, paramString, paramBitmap);
      QMLog.log(4, "CardPreviewFragment", "onPageStarted " + paramString);
    }
  }
  
  class ShareComponent
  {
    private boolean firstReceiveWatcher = true;
    private String h5Url;
    private int saveCardKey = 0;
    private final SaveCardWatcher saveCardWatcher = new CardPreviewFragment.ShareComponent.1(this);
    private ShareLinkToExternal.SharedType sharedType;
    private Bitmap thumb;
    
    private ShareComponent() {}
    
    private void doShare()
    {
      
      String str;
      if ((this.thumb != null) && (this.h5Url != null))
      {
        QMLog.log(4, "CardPreviewFragment", "doShare: h5url: " + this.h5Url);
        str = CardUtil.getFromPlatform(this.sharedType);
        if (this.sharedType != ShareLinkToExternal.SharedType.SHARE_TO_QQ_FRIEND) {
          break label147;
        }
        ShareLinkToExternal.shareToQQFriend(this.h5Url + str, CardPreviewFragment.this.replace(CardPreviewFragment.this.mCardData.getShareTitle()), CardPreviewFragment.this.replace(CardPreviewFragment.this.mCardData.getShareWord()), CardPreviewFragment.this.mCardData.getCardThumbUrl(), CardPreviewFragment.this.getActivity());
      }
      for (;;)
      {
        CardPreviewFragment.this.onShareComplete();
        return;
        try
        {
          label147:
          str = String.format("https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx418ef619e2bf54e6&response_type=code&scope=snsapi_base&state=123&redirect_uri=%s", new Object[] { StringExtention.urlEncode(this.h5Url + str) });
          ShareLinkToExternal.shareToWX(this.sharedType, str, CardPreviewFragment.this.replace(CardPreviewFragment.this.mCardData.getShareTitle()), CardPreviewFragment.this.replace(CardPreviewFragment.this.mCardData.getShareWord()), this.thumb);
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException)
        {
          QMLog.log(6, "CardPreviewFragment", "doShare", localUnsupportedEncodingException);
        }
      }
    }
    
    private void preShare()
    {
      Object localObject;
      if (this.thumb == null)
      {
        localObject = ImageDownloadManager.shareInstance().getThumbBitmapFromLocal(CardPreviewFragment.this.mCardData.getCardThumbUrl());
        if (localObject == null) {
          break label80;
        }
        this.thumb = ((Bitmap)localObject);
      }
      for (;;)
      {
        if (this.h5Url == null)
        {
          localObject = CardPreviewFragment.this.mCardManager.getDefaultAccount();
          CardPreviewFragment.this.mCardManager.saveCard(CardPreviewFragment.this.mCardData.getCardId(), CardPreviewFragment.this.mEditedCardParaList, (Account)localObject);
        }
        return;
        label80:
        localObject = new DownloadInfo();
        ((DownloadInfo)localObject).setUrl(CardPreviewFragment.this.mCardData.getCardThumbUrl());
        ((DownloadInfo)localObject).setImageDownloadListener(new CardPreviewFragment.ShareComponent.2(this));
        ImageDownloadManager.shareInstance().fetchImage((DownloadInfo)localObject);
      }
    }
    
    public void bind(boolean paramBoolean)
    {
      Watchers.bind(this.saveCardWatcher, paramBoolean);
    }
    
    public void share(ShareLinkToExternal.SharedType paramSharedType)
    {
      ValidateHelper.mainThread();
      QMLog.log(4, "CardPreviewFragment", "share sharedType[%s], thumb[%s]", new Object[] { paramSharedType.toString(), CardPreviewFragment.this.mCardData.getCardThumbUrl() });
      Iterator localIterator = CardPreviewFragment.this.mEditedCardParaList.iterator();
      while (localIterator.hasNext())
      {
        QMCardPara localQMCardPara = (QMCardPara)localIterator.next();
        Log.i("CardPreviewFragment", "share_para: name: " + localQMCardPara.getName() + ", value: " + localQMCardPara.getValue());
      }
      int i = CardPreviewFragment.this.mCardManager.getSaveCardKey(CardPreviewFragment.this.mCardData.getCardId(), CardPreviewFragment.this.mEditedCardParaList);
      if (i != this.saveCardKey)
      {
        this.h5Url = null;
        this.thumb = null;
        this.saveCardKey = i;
        this.firstReceiveWatcher = true;
      }
      this.sharedType = paramSharedType;
      if ((this.h5Url == null) || (this.thumb == null))
      {
        CardPreviewFragment.this.onShareLoading();
        preShare();
        return;
      }
      doShare();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.card.fragment.CardPreviewFragment
 * JD-Core Version:    0.7.0.1
 */