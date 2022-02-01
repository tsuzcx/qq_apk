package com.tencent.qqmail.note;

import alld;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.DownloadManager;
import android.app.DownloadManager.Request;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.qqmail.BaseActivity;
import com.tencent.qqmail.QMActivityManager;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.activity.compose.ComposeMailActivity;
import com.tencent.qqmail.activity.compose.ComposeNoteActivity;
import com.tencent.qqmail.activity.compose.NoteCatAdapter;
import com.tencent.qqmail.activity.readmail.MailDeleteAnimation;
import com.tencent.qqmail.activity.webviewexplorer.CardWebViewExplorer;
import com.tencent.qqmail.activity.webviewexplorer.WebViewExplorer;
import com.tencent.qqmail.attachment.util.IntentUtil;
import com.tencent.qqmail.calendar.fragment.CalendarFragmentActivity;
import com.tencent.qqmail.calendar.model.QMCalendarManager;
import com.tencent.qqmail.fragment.base.MailFragmentActivity;
import com.tencent.qqmail.marcos.ChannelDefine;
import com.tencent.qqmail.model.NoteManager;
import com.tencent.qqmail.model.NoteStorage;
import com.tencent.qqmail.model.mail.QMSettingManager;
import com.tencent.qqmail.model.mail.watcher.QMUnlockFolderPwdWatcher;
import com.tencent.qqmail.model.qmdomain.Mail;
import com.tencent.qqmail.model.qmdomain.MailInformation;
import com.tencent.qqmail.model.qmdomain.QMComposeNote;
import com.tencent.qqmail.model.qmdomain.QMNNote;
import com.tencent.qqmail.model.qmdomain.QMNNoteCategory;
import com.tencent.qqmail.model.qmdomain.QMNNoteInformation;
import com.tencent.qqmail.model.qmdomain.QMNNoteStatus;
import com.tencent.qqmail.model.uidomain.ComposeMailUI.QMComposeMailType;
import com.tencent.qqmail.movenote.MoveNoteActivity;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.qmui.popup.QMUIListPopup;
import com.tencent.qqmail.utilities.WebviewUtilities;
import com.tencent.qqmail.utilities.audio.QMAudioPlayBar;
import com.tencent.qqmail.utilities.common.CommUtils;
import com.tencent.qqmail.utilities.contacts.ContactsHelper;
import com.tencent.qqmail.utilities.dateextension.DateExtension;
import com.tencent.qqmail.utilities.deviceid.DeviceUtil;
import com.tencent.qqmail.utilities.imageextention.WebviewCaptureTask;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.observer.IObserver;
import com.tencent.qqmail.utilities.observer.QMNotification;
import com.tencent.qqmail.utilities.stringextention.StringExtention;
import com.tencent.qqmail.utilities.template.Template;
import com.tencent.qqmail.utilities.ui.QMBottomDialog;
import com.tencent.qqmail.utilities.ui.QMBottomDialog.BottomListSheetBuilder;
import com.tencent.qqmail.utilities.ui.QMImageButton;
import com.tencent.qqmail.utilities.ui.QMLoading;
import com.tencent.qqmail.utilities.ui.QMScaleWebViewController;
import com.tencent.qqmail.utilities.ui.QMTips;
import com.tencent.qqmail.utilities.ui.QMUIKit;
import com.tencent.qqmail.view.FolderLockDialog;
import com.tencent.qqmail.view.QMBottomBar;
import com.tencent.qqmail.view.QMTopBar;
import com.tencent.qqmail.view.TitleBarWebView2;
import java.io.File;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.lang3.StringUtils;

public class ReadNoteActivity
  extends BaseActivity
{
  private static HashMap<String, String> IMAGE_MAPPING_POOL = new HashMap();
  public static final String NOTE_EDITSAVE = "NOTE_EDITSAVE";
  public static final String NOTE_MOVE = "NOTE_MOVE";
  public static final String NOTE_TEMPID = "NOTE_TEMPID";
  public static final String N_LOADNOTE_BEFORESEND = "N_LOADNOTE_BEFORESEND";
  public static final String N_LOADNOTE_ERROR = "N_LOADNOTE_ERROR";
  public static final String N_LOADNOTE_PREFETCH = "N_LOADNOTE_PREFETCH";
  public static final String N_LOADNOTE_SUCC = "N_LOADNOTE_SUCC";
  public static final String N_NOTEDELETE_ERROR = "N_NOTEDELETE_ERROR";
  public static final String N_NOTEDELETE_SUCC = "N_NOTEDELETE_SUCC";
  public static final String N_STARNOTE_BEFORESEND = "N_STARNOTE_BEFORESEND";
  public static final String N_STARNOTE_ERROR = "N_STARNOTE_ERROR";
  public static final String N_STARNOTE_PREFETCH = "N_STARNOTE_PREFETCH";
  public static final String N_STARNOTE_SUCC = "N_STARNOTE_SUCC";
  public static final String N_UPDATENOTE_ERROR = "N_UPDATENOTE_ERROR";
  public static final String N_UPDATENOTE_SUCC = "N_UPDATENOTE_SUCC";
  public static final String TAG = "ReadNoteActivity";
  private final String Tag = "ReadNoteActivity";
  private boolean ableFlingToBack = false;
  private int animationType;
  public Button btnReload;
  private Button btnVerify;
  private QMImageButton deleteBtn;
  public IObserver deleteNoteErrorIObserver = new IObserver(new ReadNoteActivity.19(this));
  public IObserver deleteNoteSuccIObserver = new IObserver(new ReadNoteActivity.18(this));
  private QMImageButton editBtn;
  private LinearLayout errorContainer;
  private TextView errorTips;
  private QMUnlockFolderPwdWatcher folderLockWacher = new ReadNoteActivity.1(this);
  private RelativeLayout header;
  public IObserver loadNoteBeforeSendIObserver = new IObserver(new ReadNoteActivity.13(this));
  public IObserver loadNoteErrorIObserver = new IObserver(new ReadNoteActivity.15(this));
  public IObserver loadNotePrefetchIObserver = new IObserver(new ReadNoteActivity.14(this));
  public IObserver loadNoteSuccIObserver = new IObserver(new ReadNoteActivity.12(this));
  private FolderLockDialog lockDialog;
  private QMBottomBar mBottomBar;
  private QMComposeNote mData;
  public String mFromCatalogName = "";
  private QMLoading mLoadingView;
  private NoteCatAdapter mNoteCatAdapter;
  private QMUIListPopup mNoteCatPopup;
  private String mNoteId;
  private ArrayList<String> mNoteList;
  private IObserver mPlayComplete = new IObserver(new ReadNoteActivity.41(this));
  private QMAudioPlayBar mPlayer;
  private int mPosition;
  private QMScaleWebViewController mWebViewController;
  private DisplayMetrics metrics;
  private QMImageButton moreBtn;
  private ImageButton nextBtn;
  public IObserver noteDataChangeObserver = new IObserver(new ReadNoteActivity.6(this));
  public IObserver noteEditSaveIObserver = new IObserver(new ReadNoteActivity.7(this));
  private NoteManager noteManager;
  public IObserver noteMoveIObserver = new IObserver(new ReadNoteActivity.4(this));
  public IObserver noteTempIdObserver = new IObserver(new ReadNoteActivity.5(this));
  private ImageButton previouBtn;
  private LinearLayout progressContainer;
  private QMImageButton starBtn;
  public IObserver starNoteBeforeSendIObserver = new IObserver(new ReadNoteActivity.11(this));
  public IObserver starNoteErrorIObserver = new IObserver(new ReadNoteActivity.9(this));
  public IObserver starNotePrefetchIObserver = new IObserver(new ReadNoteActivity.10(this));
  public IObserver starNoteSuccIObserver = new IObserver(new ReadNoteActivity.8(this));
  private QMTopBar topBar;
  public IObserver updateNoteErrorIObserver = new IObserver(new ReadNoteActivity.16(this));
  public IObserver updateNoteSuccIObserver = new IObserver(new ReadNoteActivity.17(this));
  private FrameLayout webContainer;
  
  private boolean canForward()
  {
    return (!this.mNoteId.contains("compose")) && ((this.mData == null) || (this.mData.status == null) || (!isLocal(this.mData.status.status)));
  }
  
  private String composeAudioTag(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    String str = paramString4;
    if (paramString4 == null) {
      str = "";
    }
    if (paramString3.matches("/^(\\d\\.)+$/")) {}
    for (paramString4 = StringExtention.getHumanReadableSizeString(Long.parseLong(paramString3));; paramString4 = paramString3)
    {
      paramString1 = Template.getTemplateSectionWithName(QMApplicationContext.sharedInstance(), Template.CONTENT_HTML_TEMPLATE, "audio").replace("$audio_src$", paramString1).replace("$audio_title$", paramString2).replace("$audio_size$", paramString3).replace("$audio_display_title$", paramString2).replace("$audio_display_size$", paramString4).replace("$audio_duration$", str);
      Log.i("ReadNoteActivity", "audioTemplate = " + paramString1);
      return paramString1;
    }
  }
  
  private void coverImage()
  {
    FrameLayout localFrameLayout = this.webContainer;
    ImageView localImageView = (ImageView)findViewById(2131362725);
    localFrameLayout.destroyDrawingCache();
    localFrameLayout.setDrawingCacheEnabled(true);
    localFrameLayout.buildDrawingCache();
    localImageView.setImageBitmap(localFrameLayout.getDrawingCache());
    localImageView.setVisibility(0);
  }
  
  private void deleteNote(String paramString)
  {
    try
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(paramString);
      this.deleteBtn.setEnabled(false);
      NoteManager.sharedInstance().deleteNotesWithNotification(localArrayList, null);
      return;
    }
    catch (Exception paramString)
    {
      QMLog.log(6, "ReadNoteActivity", "deleteNote", paramString);
      Log.e("crash", "" + paramString.getMessage());
    }
  }
  
  private void editNote()
  {
    if (this.mPlayer != null) {
      this.mPlayer.close();
    }
    Intent localIntent = new Intent(this, ComposeNoteActivity.class);
    localIntent.putExtra("composeType", "note__");
    localIntent.putExtra("type", ComposeMailUI.QMComposeMailType.COMPOSE_TYPE_NOTE);
    localIntent.putExtra("note", this.mData);
    localIntent.putExtra("noteCatId", this.mData.information.category.getCatalogId());
    startActivity(localIntent);
  }
  
  private String encodeSharp(String paramString)
  {
    return paramString.replaceAll("composemail_(\\d{2,20})#", "composemail_$1%23");
  }
  
  private void goNextNote()
  {
    HashMap localHashMap;
    if (this.mNoteList != null)
    {
      localHashMap = new HashMap();
      if (this.mPosition + 1 != this.mNoteList.size()) {
        break label100;
      }
    }
    label100:
    for (int i = 0;; i = this.mPosition + 1)
    {
      localHashMap.put("position", Integer.valueOf(i));
      localHashMap.put("noteId", this.mNoteList.get(i));
      localHashMap.put("noteList", this.mNoteList);
      renderHeader(NoteManager.sharedInstance().readNoteData((String)this.mNoteList.get(i)));
      reloadNote(localHashMap);
      return;
    }
  }
  
  private void goPreviouNote()
  {
    HashMap localHashMap;
    if (this.mNoteList != null)
    {
      localHashMap = new HashMap();
      if (this.mPosition != 0) {
        break label107;
      }
    }
    label107:
    for (int i = this.mNoteList.size() - 1;; i = this.mPosition - 1)
    {
      if (i != this.mPosition)
      {
        localHashMap.put("position", Integer.valueOf(i));
        localHashMap.put("noteId", this.mNoteList.get(i));
        localHashMap.put("noteList", this.mNoteList);
        renderHeader(NoteManager.sharedInstance().readNoteData((String)this.mNoteList.get(i)));
        reloadNote(localHashMap);
      }
      return;
    }
  }
  
  private void hideErrorView()
  {
    this.errorContainer.setVisibility(8);
  }
  
  private void hideLoading()
  {
    runOnMainThread(new ReadNoteActivity.35(this));
  }
  
  private void hideVerifyError()
  {
    this.errorContainer.setVisibility(8);
    this.btnReload.setVisibility(0);
    this.btnVerify.setVisibility(8);
  }
  
  private void initFootToolBar()
  {
    ReadNoteActivity.27 local27 = new ReadNoteActivity.27(this);
    ReadNoteActivity.28 local28 = new ReadNoteActivity.28(this);
    ReadNoteActivity.29 local29 = new ReadNoteActivity.29(this);
    ReadNoteActivity.30 local30 = new ReadNoteActivity.30(this);
    this.mBottomBar = new QMBottomBar(this);
    ((FrameLayout)findViewById(2131376816)).addView(this.mBottomBar);
    this.starBtn = this.mBottomBar.addButton(2130840805, local27);
    this.deleteBtn = this.mBottomBar.addButton(2130840803, local29);
    this.editBtn = this.mBottomBar.addButton(2130840804, local28);
    this.moreBtn = this.mBottomBar.addButton(2130840806, local30);
    this.starBtn.setContentDescription(getResources().getString(2131720834));
    this.starBtn.setId(2131372494);
    this.editBtn.setContentDescription(getResources().getString(2131720818));
    this.editBtn.setId(2131372493);
    this.deleteBtn.setContentDescription(getResources().getString(2131720816));
    this.deleteBtn.setId(2131372492);
    this.moreBtn.setContentDescription(getResources().getString(2131720838));
    this.moreBtn.setId(2131372501);
  }
  
  private boolean initNoteCatPopup(AdapterView.OnItemClickListener paramOnItemClickListener)
  {
    ArrayList localArrayList1 = NoteManager.sharedInstance().readAllCategory();
    if (localArrayList1.size() == 0) {
      return false;
    }
    ArrayList localArrayList2 = new ArrayList();
    localArrayList2.addAll(localArrayList1);
    this.mNoteCatAdapter = new NoteCatAdapter(QMApplicationContext.sharedInstance(), localArrayList2, this.mData.information.category.getCatalogId());
    this.mNoteCatPopup = new QMUIListPopup(QMApplicationContext.sharedInstance(), 1, this.mNoteCatAdapter);
    this.mNoteCatPopup.setAnimStyle(2);
    this.mNoteCatPopup.setPositionOffsetYWhenBottom(-QMUIKit.dpToPx(10));
    this.mNoteCatPopup.create(QMUIKit.dpToPx(156), QMUIKit.dpToPx(192), paramOnItemClickListener);
    return true;
  }
  
  private void initTopToolBar(String paramString)
  {
    this.topBar.setButtonLeftBack();
    this.topBar.getButtonLeft().setOnClickListener(new ReadNoteActivity.25(this));
    this.topBar.setCenterOnclickListener(new ReadNoteActivity.26(this));
  }
  
  @SuppressLint({"SetJavaScriptEnabled"})
  private void initWebView()
  {
    if (this.mWebViewController == null) {
      return;
    }
    this.mWebViewController.init();
    QMScaleWebViewController localQMScaleWebViewController1 = this.mWebViewController;
    QMScaleWebViewController localQMScaleWebViewController2 = this.mWebViewController;
    localQMScaleWebViewController2.getClass();
    localQMScaleWebViewController1.setJavascriptInterface(new ReadNoteActivity.45(this, localQMScaleWebViewController2));
    localQMScaleWebViewController1 = this.mWebViewController;
    localQMScaleWebViewController2 = this.mWebViewController;
    localQMScaleWebViewController2.getClass();
    localQMScaleWebViewController1.setWebViewClient(new ReadNoteActivity.46(this, localQMScaleWebViewController2));
    localQMScaleWebViewController1 = this.mWebViewController;
    localQMScaleWebViewController2 = this.mWebViewController;
    localQMScaleWebViewController2.getClass();
    localQMScaleWebViewController1.setOnLongClickListener(new ReadNoteActivity.47(this, localQMScaleWebViewController2));
  }
  
  private void innerDialog(String paramString)
  {
    QMBottomDialog.BottomListSheetBuilder localBottomListSheetBuilder = new QMBottomDialog.BottomListSheetBuilder(getActivity());
    localBottomListSheetBuilder.setOnSheetItemClickListener(new ReadNoteActivity.49(this, paramString));
    localBottomListSheetBuilder.addItem(getString(2131692344));
    localBottomListSheetBuilder.addItem(getString(2131689844));
    String str = getExistContactName(paramString);
    if (str.equals("")) {}
    for (paramString = paramString + " " + getResources().getString(2131695686);; paramString = str + "(" + paramString + ") " + getResources().getString(2131693280))
    {
      localBottomListSheetBuilder.setTitle(paramString);
      localBottomListSheetBuilder.build().show();
      return;
    }
  }
  
  private void invalidateWebview()
  {
    if (this.mWebViewController.getWebView() != null) {
      this.mWebViewController.getWebView().invalidate();
    }
  }
  
  private void loadNoteWithNotification()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("NoteId", this.mNoteId);
    resetContent();
    Log.e("profile", "start2");
    NoteManager localNoteManager = NoteManager.sharedInstance();
    if (localNoteManager != null) {
      localNoteManager.loadNoteWithNotification(localHashMap);
    }
  }
  
  private void moreBtnClickPopup()
  {
    QMBottomDialog.BottomListSheetBuilder localBottomListSheetBuilder = new QMBottomDialog.BottomListSheetBuilder(getActivity());
    if (canForward()) {
      localBottomListSheetBuilder.addItem(2130840820, getString(2131696401), getString(2131696401));
    }
    localBottomListSheetBuilder.addItem(2130840827, getString(2131696402), getString(2131696402));
    if (QMSettingManager.sharedInstance().getCalendarDisplay()) {
      localBottomListSheetBuilder.addItem(2130840828, getString(2131695201), getString(2131695201));
    }
    localBottomListSheetBuilder.addItem(2130840839, getString(2131696758), getString(2131696758));
    localBottomListSheetBuilder.setOnSheetItemClickListener(new ReadNoteActivity.36(this));
    localBottomListSheetBuilder.build().show();
  }
  
  private void noteDisapper()
  {
    if (this.mNoteList == null)
    {
      finish();
      return;
    }
    this.mNoteList.remove(this.mPosition);
    if (this.mNoteList.size() == 0)
    {
      finish();
      return;
    }
    this.mPosition -= 1;
    goNextNote();
  }
  
  private void noteForwarMail()
  {
    startActivity(ComposeMailActivity.createIntentForNote(this, this.mData, QMSettingManager.sharedInstance().getDefaultNoteAccountID(), "note__", ComposeMailUI.QMComposeMailType.COMPOSE_TYPE_NOTE_FORWARD));
  }
  
  private void noteMoveTo()
  {
    QMNNoteInformation localQMNNoteInformation = this.mData.information;
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(localQMNNoteInformation.noteId);
    Intent localIntent = new Intent(this, MoveNoteActivity.class);
    localIntent.putExtra("NoteIds", localArrayList);
    localIntent.putExtra("CurrCatalogId", localQMNNoteInformation.category.getCatalogId());
    startActivity(localIntent);
  }
  
  private void noteToCalendar()
  {
    QMNNoteInformation localQMNNoteInformation = this.mData.information;
    startActivity(CalendarFragmentActivity.createIntentToModifySchedule(2, localQMNNoteInformation.noteId, QMSettingManager.sharedInstance().getDefaultNoteAccountID(), localQMNNoteInformation.subject));
    getActivity().overridePendingTransition(2130772401, 2130772430);
  }
  
  private String parseAudioTag(String paramString)
  {
    paramString = Pattern.compile("<audio[^<>]*?src=\"([^<>\"]*?)\"[^<>]*?qmtitle=\"([^<>\"]*?)\"[^<>]*?size=\"([^<>\"]*?)\"[^<>]*?(qmduration=\"([^<>\"]*?)\")?>[^<>]*?</audio>").matcher(paramString);
    StringBuffer localStringBuffer = new StringBuffer();
    while (paramString.find()) {
      paramString.appendReplacement(localStringBuffer, composeAudioTag(paramString.group(1), paramString.group(2), paramString.group(3), paramString.group(5)));
    }
    paramString.appendTail(localStringBuffer);
    return localStringBuffer.toString();
  }
  
  private void readNoteInit()
  {
    this.noteManager = NoteManager.sharedInstance();
    this.mNoteId = getIntent().getStringExtra("noteId");
    Object localObject = this.noteManager.getIdMapping(this.mNoteId);
    if ((localObject != null) && (((String)localObject).length() != 0) && (((String)localObject).contains("___")))
    {
      localObject = ((String)localObject).split("___");
      QMLog.log(4, "algerreadNoteReplaceId", "old:" + this.mNoteId + " new:" + localObject[0]);
      this.mNoteId = localObject[0];
    }
    this.mPosition = getIntent().getIntExtra("position", 0);
    this.mNoteList = ((ArrayList)getIntent().getSerializableExtra("noteList"));
    this.mFromCatalogName = getIntent().getStringExtra("catalogName");
    if (!StringUtils.isBlank(this.mFromCatalogName)) {
      initTopToolBar(this.mFromCatalogName);
    }
    initFootToolBar();
    this.webContainer = ((FrameLayout)findViewById(2131382171));
    this.header = ((RelativeLayout)LayoutInflater.from(this).inflate(2131562947, null));
    this.mWebViewController = new QMScaleWebViewController(this, this.webContainer, this.header, null);
    this.progressContainer = ((LinearLayout)findViewById(2131373701));
    this.mLoadingView = new QMLoading(getApplicationContext());
    ((RelativeLayout)this.progressContainer.findViewById(2131373700)).addView(this.mLoadingView);
    this.mLoadingView.stop();
    this.errorContainer = ((LinearLayout)findViewById(2131366503));
    this.btnReload = ((Button)findViewById(2131377099));
    this.btnVerify = ((Button)findViewById(2131381483));
    this.errorTips = ((TextView)findViewById(2131366515));
    this.btnReload.setOnClickListener(new ReadNoteActivity.2(this));
    this.btnVerify.setOnClickListener(new ReadNoteActivity.3(this));
    renderHeader(this.noteManager.readNoteData(this.mNoteId));
  }
  
  private void registNotification()
  {
    QMNotification.registNotification("NOTE_MOVE", this.noteMoveIObserver);
    QMNotification.registNotification("NOTE_EDITSAVE", this.noteEditSaveIObserver);
    QMNotification.registNotification("NOTE_TEMPID", this.noteTempIdObserver);
    QMNotification.registNotification("NOTE_DATACHANGE", this.noteDataChangeObserver);
    registerLoadNote();
    registerDeleteNote();
    registerStarNote();
    registerUpdateNote();
  }
  
  private void registerAudioCloseEvent()
  {
    QMNotification.registNotification("audioPlayComplete", this.mPlayComplete);
  }
  
  private void reloadNote(HashMap<String, Object> paramHashMap)
  {
    this.mNoteId = ((String)paramHashMap.get("noteId"));
    this.mPosition = ((Integer)paramHashMap.get("position")).intValue();
    loadNoteWithNotification();
  }
  
  private void render(QMNNote paramQMNNote)
  {
    int i = QMSettingManager.sharedInstance().getDefaultNoteAccountID();
    Log.d("ReadNoteActivity", "note：" + paramQMNNote.toString());
    renderHeader(paramQMNNote);
    if (FolderLockDialog.isFolderLock(-4))
    {
      if (getActivity() != null)
      {
        this.lockDialog = new FolderLockDialog(getActivity(), -4, i, this.folderLockWacher);
        this.lockDialog.createDialog(1);
        this.lockDialog.showDialog();
        showVerifyError();
      }
      return;
    }
    hideVerifyError();
    if ((paramQMNNote.content != null) && (this.mWebViewController != null))
    {
      Mail localMail = new Mail();
      localMail.init();
      localMail.getInformation().setAccountId(i);
      renderContent(paramQMNNote.content);
      return;
    }
    Log.d("ReadNoteActivity", "note content null");
  }
  
  private void renderContent(String paramString)
  {
    int i = 0;
    paramString = encodeSharp(parseAudioTag(parseAudioTag(paramString))).replaceAll("file://+localhost", "file://");
    paramString = this.mWebViewController.reFormatHtml(paramString);
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append(Template.getTemplateSectionWithName(QMApplicationContext.sharedInstance(), Template.CONTENT_HTML_TEMPLATE, "main_head"));
    localStringBuilder1.append(paramString);
    localStringBuilder1.append(Template.getTemplateSectionWithName(QMApplicationContext.sharedInstance(), Template.CONTENT_HTML_TEMPLATE, "main_tail"));
    String str = localStringBuilder1.toString();
    localStringBuilder1.setLength(0);
    localStringBuilder1.append("file:///read?t=note");
    localStringBuilder1.append("&pageWidth=").append(this.mWebViewController.getPageWidth());
    paramString = Resources.getSystem().getDisplayMetrics();
    localStringBuilder1.append("&fontSize=").append(18.0F * paramString.scaledDensity / paramString.density);
    boolean bool = QMSettingManager.sharedInstance().getCalendarDisplay();
    if (QMCalendarManager.getInstance().getCountOfAccountEnabled() <= 0) {}
    for (;;)
    {
      StringBuilder localStringBuilder2 = localStringBuilder1.append("&isCalendarOpen=");
      if (i != 0) {}
      for (paramString = "true";; paramString = "false")
      {
        localStringBuilder2.append(paramString);
        this.mWebViewController.loadHTML(localStringBuilder1.toString(), str);
        shakeWebViewWrapper();
        registerAudioCloseEvent();
        return;
      }
      i = bool;
    }
  }
  
  private void renderHeader(QMNNote paramQMNNote)
  {
    if (paramQMNNote == null)
    {
      showErrorView();
      return;
    }
    Object localObject1 = paramQMNNote.status;
    QMNNoteInformation localQMNNoteInformation = paramQMNNote.information;
    Object localObject2 = (TextView)this.header.findViewById(2131376660);
    if ((localQMNNoteInformation.subject == null) || (localQMNNoteInformation.subject.length() == 0))
    {
      ((TextView)localObject2).setText(getString(2131696420));
      if (StringUtils.isBlank(this.mFromCatalogName))
      {
        this.mFromCatalogName = localQMNNoteInformation.category.getCatalogName();
        initTopToolBar(this.mFromCatalogName);
      }
      ((TextView)localObject2).setOnLongClickListener(new ReadNoteActivity.39(this));
      double d = ((QMNNoteStatus)localObject1).updateUTC;
      if (StringUtils.equals("1", NoteStorage.readSortType())) {
        d = ((QMNNoteStatus)localObject1).createUTC;
      }
      localObject1 = DateExtension.fullDateName_yyyyMMddHHmm(new Date(d * 1000L));
      Log.d("ReadNoteActivity", "renderHeader updatetime:" + (String)localObject1);
      localObject2 = this.header.findViewById(2131379853);
      if (!paramQMNNote.status.starred) {
        break label298;
      }
    }
    label298:
    for (int i = 0;; i = 8)
    {
      ((View)localObject2).setVisibility(i);
      ((TextView)this.header.findViewById(2131372490)).setText((CharSequence)localObject1);
      paramQMNNote = (TextView)this.header.findViewById(2131372487);
      paramQMNNote.setText(NoteManager.sharedInstance().findCategoryNameByCid(localQMNNoteInformation.category.getCatalogId()));
      paramQMNNote.setOnClickListener(new ReadNoteActivity.40(this, localQMNNoteInformation, paramQMNNote));
      setNextBtn();
      setPreviouBtn();
      return;
      ((TextView)localObject2).setText(localQMNNoteInformation.subject);
      break;
    }
  }
  
  private void resetContent()
  {
    initWebView();
    showLoading();
    setFootToolbarEnable(false);
  }
  
  private void setFootToolbarEnable(boolean paramBoolean)
  {
    this.starBtn.setEnabled(paramBoolean);
    this.editBtn.setEnabled(paramBoolean);
    this.deleteBtn.setEnabled(paramBoolean);
    this.moreBtn.setEnabled(paramBoolean);
  }
  
  private void setNextBtn()
  {
    this.nextBtn = ((ImageButton)this.topBar.getButtonNext());
    this.nextBtn.setContentDescription(getString(2131720824));
    if ((this.mNoteList == null) || (this.mPosition + 1 == this.mNoteList.size()))
    {
      this.nextBtn.setEnabled(false);
      this.nextBtn.setAlpha(67);
    }
    for (;;)
    {
      this.nextBtn.setOnClickListener(new ReadNoteActivity.33(this));
      return;
      this.nextBtn.setEnabled(true);
      this.nextBtn.setAlpha(255);
    }
  }
  
  private void setPreviouBtn()
  {
    this.previouBtn = ((ImageButton)this.topBar.getButtonPrev());
    this.previouBtn.setContentDescription(getString(2131720826));
    if (this.mPosition == 0)
    {
      this.previouBtn.setEnabled(false);
      this.previouBtn.setAlpha(67);
    }
    for (;;)
    {
      this.previouBtn.setOnClickListener(new ReadNoteActivity.34(this));
      return;
      this.previouBtn.setEnabled(true);
      this.previouBtn.setAlpha(255);
    }
  }
  
  private void shareNoteContent()
  {
    if (this.mWebViewController == null) {
      return;
    }
    QMTips localQMTips = getTips();
    localQMTips.showLoading(getString(2131696752));
    localQMTips.setCanceledOnTouchOutside(false);
    localQMTips.setCanceledWithBackKey(false);
    if (this.header != null) {}
    for (String str = ((TextView)this.header.findViewById(2131376660)).getText().toString();; str = System.currentTimeMillis() + "")
    {
      WebviewCaptureTask.startNewTask(this.mWebViewController.getWebView(), this.header, null, str, new ReadNoteActivity.37(this, localQMTips));
      return;
    }
  }
  
  private void showErrorView()
  {
    this.topBar.setButtonLeftBack();
    this.topBar.getButtonLeft().setOnClickListener(new ReadNoteActivity.38(this));
    this.header.setVisibility(8);
    DataCollector.logException(7, 8, "Event_Error", getString(2131718611), true);
    this.errorContainer.setVisibility(0);
  }
  
  private void showLoading()
  {
    this.mLoadingView.start();
    this.progressContainer.setVisibility(0);
  }
  
  private void showTipsInfo(String paramString)
  {
    getTips().showSuccess(paramString);
  }
  
  private void showVerifyError()
  {
    this.errorContainer.setVisibility(0);
    this.errorTips.setText(getString(2131721674));
    this.btnReload.setVisibility(8);
    this.btnVerify.setVisibility(0);
  }
  
  private void starNote(String paramString, boolean paramBoolean)
  {
    NoteManager.sharedInstance().starNoteWithNotification(paramString, paramBoolean);
  }
  
  private void unRegistNotification()
  {
    QMNotification.unregistNotification("NOTE_MOVE", this.noteMoveIObserver);
    QMNotification.unregistNotification("NOTE_EDITSAVE", this.noteEditSaveIObserver);
    QMNotification.unregistNotification("NOTE_TEMPID", this.noteTempIdObserver);
    QMNotification.unregistNotification("NOTE_DATACHANGE", this.noteDataChangeObserver);
    QMNotification.unregistNotification("audioPlayComplete", this.mPlayComplete);
    unregisterLoadNote();
    unregisterDeleteNote();
    unregisterStarNote();
    unregisterUpdateNote();
  }
  
  private String unionImageTag(String paramString1, String paramString2, String paramString3)
  {
    return paramString1 + paramString2 + paramString3;
  }
  
  protected void confirmStarNote(String paramString, boolean paramBoolean)
  {
    QMBottomDialog.BottomListSheetBuilder localBottomListSheetBuilder = new QMBottomDialog.BottomListSheetBuilder(getActivity());
    localBottomListSheetBuilder.setTitle(2131695667);
    if (!paramBoolean) {}
    for (int i = 2131695669;; i = 2131695672)
    {
      localBottomListSheetBuilder.addItem(getString(i));
      localBottomListSheetBuilder.setOnSheetItemClickListener(new ReadNoteActivity.31(this, paramBoolean, paramString));
      localBottomListSheetBuilder.build().show();
      return;
    }
  }
  
  protected void confirmStarNote(String paramString, boolean paramBoolean, View paramView)
  {
    paramView = new QMBottomDialog.BottomListSheetBuilder(getActivity());
    if (paramBoolean) {
      paramView.addItem(2130840826, getString(2131695672), getString(2131695672));
    }
    for (;;)
    {
      paramView.setOnSheetItemClickListener(new ReadNoteActivity.32(this, paramString, paramBoolean));
      paramView.build().show();
      return;
      paramView.addItem(2130840824, getString(2131695669), getString(2131695669));
    }
  }
  
  public void copy(String paramString)
  {
    CommUtils.copyText(paramString);
    showTipsInfo(getResources().getString(2131692323));
  }
  
  public void createNewContact(String paramString)
  {
    Intent localIntent = new Intent("android.intent.action.INSERT", Uri.withAppendedPath(Uri.parse("content://com.android.contacts"), "contacts"));
    localIntent.putExtra("phone", paramString);
    startActivity(localIntent);
  }
  
  protected void deleteNoteSucc(Object paramObject)
  {
    new MailDeleteAnimation((ImageView)findViewById(2131362725), this.webContainer, this).animationStart();
    noteDisapper();
  }
  
  protected void delteNoteError(Object paramObject) {}
  
  public void dial(String paramString)
  {
    try
    {
      startActivity(new Intent("android.intent.action.VIEW", Uri.parse("qqbookdial:" + paramString)));
      DataCollector.logEvent("Event_Content_Recognize_Has_Wx_Book_Dial");
      return;
    }
    catch (Exception localException)
    {
      startActivity(new Intent("android.intent.action.DIAL", Uri.parse("tel:" + paramString)));
      DataCollector.logEvent("Event_Content_Recognize_Dial");
    }
  }
  
  public void downloadWeChatPhoneBook()
  {
    if (ChannelDefine.isGooglePlay())
    {
      IntentUtil.intentToMarket(getActivity(), "com.tencent.pb");
      return;
    }
    try
    {
      int i = getActivity().getPackageManager().getApplicationEnabledSetting("com.android.providers.downloads");
      if ((i == 2) || (i == 3) || (i == 4))
      {
        Intent localIntent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        localIntent.setData(Uri.parse("package:" + "com.android.providers.downloads"));
        QMLog.log(6, "ReadNoteActivity", "download app not started");
        Toast.makeText(QMApplicationContext.sharedInstance(), "请启动下载应用", 0).show();
        startActivity(localIntent);
        return;
      }
    }
    catch (Exception localException)
    {
      Toast.makeText(QMApplicationContext.sharedInstance(), "找不到下载应用", 0).show();
      return;
    }
    Object localObject1 = getActivity();
    getActivity();
    localObject1 = (DownloadManager)((Activity)localObject1).getSystemService("download");
    Object localObject2 = new File("Download");
    if ((!((File)localObject2).exists()) || (((File)localObject2).isDirectory())) {
      ((File)localObject2).mkdirs();
    }
    localObject2 = new DownloadManager.Request(Uri.parse("http://dianhua.qq.com/cgi-bin/cloudgrptemplate?t=dianhuaben_download&channel=100012"));
    ((DownloadManager.Request)localObject2).setDestinationInExternalPublicDir("Download", "phonebook.apk");
    Toast.makeText(QMApplicationContext.sharedInstance(), "正在下载微信电话本...", 0).show();
    if (Build.VERSION.SDK_INT > 10) {
      ((DownloadManager.Request)localObject2).setNotificationVisibility(1);
    }
    long l = ((DownloadManager)localObject1).enqueue((DownloadManager.Request)localObject2);
    localObject2 = new IntentFilter("android.intent.action.DOWNLOAD_COMPLETE");
    localObject1 = new ReadNoteActivity.53(this, l, (DownloadManager)localObject1);
    getActivity().registerReceiver((BroadcastReceiver)localObject1, (IntentFilter)localObject2);
  }
  
  public void finish()
  {
    coverImage();
    Log.i("readnoteactivity", "readnoteactivity finish");
    if (this.mWebViewController != null)
    {
      this.mWebViewController.destroy();
      this.mWebViewController = null;
    }
    if (QMActivityManager.shareInstance().getActivitySize() <= 1) {
      if (!FolderLockDialog.isFolderLock(-4)) {
        break label81;
      }
    }
    label81:
    for (Intent localIntent = MailFragmentActivity.createIntentToFolderList(QMSettingManager.sharedInstance().getDefaultNoteAccountID());; localIntent = NoteListActivity.createIntent())
    {
      startActivity(localIntent);
      overridePendingTransition(2130772421, 2130772420);
      super.finish();
      return;
    }
  }
  
  public String getExistContactName(String paramString)
  {
    try
    {
      Object localObject = getActivity().getContentResolver();
      Uri localUri = ContactsContract.CommonDataKinds.Phone.CONTENT_URI;
      paramString = "data1 = '" + paramString + "'";
      paramString = alld.query((ContentResolver)localObject, localUri, new String[] { "display_name", "data1" }, paramString, null, null);
      if (paramString == null) {
        return "";
      }
      if (paramString.getCount() == 0)
      {
        paramString.close();
        return "";
      }
      paramString.moveToPosition(0);
      localObject = paramString.getString(paramString.getColumnIndex("display_name"));
      paramString.close();
      return localObject;
    }
    catch (Exception paramString) {}
    return "";
  }
  
  public void insertExistContact(String paramString)
  {
    Intent localIntent = new Intent("android.intent.action.INSERT_OR_EDIT");
    localIntent.setType("vnd.android.cursor.item/contact");
    localIntent.putExtra("phone", paramString);
    startActivity(localIntent);
  }
  
  public boolean isLocal(int paramInt)
  {
    boolean bool2 = false;
    int[] arrayOfInt = new int[4];
    int[] tmp10_8 = arrayOfInt;
    tmp10_8[0] = 1;
    int[] tmp14_10 = tmp10_8;
    tmp14_10[1] = 2;
    int[] tmp18_14 = tmp14_10;
    tmp18_14[2] = 3;
    int[] tmp22_18 = tmp18_14;
    tmp22_18[3] = 5;
    tmp22_18;
    int j = arrayOfInt.length;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        if (arrayOfInt[i] == paramInt) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public boolean isTelEnable()
  {
    Activity localActivity = getActivity();
    getActivity();
    if (((TelephonyManager)localActivity.getSystemService("phone")).getPhoneType() == 0)
    {
      Log.d("donald", "tel false");
      return false;
    }
    Log.d("donald", "tel true");
    return true;
  }
  
  protected void loadNoteBeforeSend(Object paramObject)
  {
    runOnMainThread(new ReadNoteActivity.23(this));
  }
  
  protected void loadNoteError(Object paramObject)
  {
    runOnMainThread(new ReadNoteActivity.22(this));
  }
  
  protected void loadNotePrefetch(Object paramObject)
  {
    runOnMainThread(new ReadNoteActivity.21(this));
  }
  
  @SuppressLint({"NewApi"})
  protected void loadNoteSucc(Object paramObject, boolean paramBoolean)
  {
    if (isDestroyed()) {
      return;
    }
    runOnMainThread(new ReadNoteActivity.24(this, paramObject, paramBoolean));
  }
  
  public void onClickReload(View paramView)
  {
    hideErrorView();
    loadNoteWithNotification();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.animationType = getIntent().getIntExtra("animationType", 0);
    if (this.animationType == 1) {
      overridePendingTransition(2130772401, 2130772430);
    }
    for (;;)
    {
      setContentView(2131558509);
      this.topBar = ((QMTopBar)findViewById(2131374722));
      this.metrics = new DisplayMetrics();
      getWindowManager().getDefaultDisplay().getMetrics(this.metrics);
      readNoteInit();
      registNotification();
      loadNoteWithNotification();
      return;
      if (this.animationType == 2) {
        overridePendingTransition(2130772422, 2130772419);
      }
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    unRegistNotification();
    this.mLoadingView = null;
    if (this.mPlayer != null) {
      this.mPlayer.close();
    }
  }
  
  public boolean onDragBack(MotionEvent paramMotionEvent)
  {
    if (((paramMotionEvent.getAction() & 0xFF) == 0) && (this.mWebViewController != null)) {
      this.ableFlingToBack = WebviewUtilities.isOnLeftEdge(this.mWebViewController.getWebView());
    }
    return this.ableFlingToBack;
  }
  
  public void onResume()
  {
    super.onResume();
  }
  
  public void openUrl(String paramString)
  {
    if ((paramString.startsWith("http://qumas.mail.qq.com/cgi-bin/uma_read_card")) || (paramString.startsWith("https://qumas.mail.qq.com/cgi-bin/uma_read_card"))) {}
    for (paramString = CardWebViewExplorer.createIntent(paramString);; paramString = WebViewExplorer.createIntent(paramString, "", QMSettingManager.sharedInstance().getDefaultNoteAccountID(), false))
    {
      startActivity(paramString);
      return;
    }
  }
  
  public void playAudio(String paramString1, String paramString2, String paramString3)
  {
    runOnMainThread(new ReadNoteActivity.42(this, paramString1, paramString2, paramString3));
  }
  
  public void playAudioWrapper(String paramString1, String paramString2, String paramString3)
  {
    invalidateWebview();
    if (this.mPlayer == null) {
      this.mPlayer = new QMAudioPlayBar(this);
    }
    this.mPlayer.forceClose(true);
    Log.d("jstest", "playAudioWrapper3");
    this.mPlayer.play(paramString2);
    Log.d("jstest", "playAudioWrapper4");
    this.mPlayer.setOnCompleteEvent(new ReadNoteActivity.44(this));
  }
  
  public void registerDeleteNote()
  {
    QMNotification.registNotification("N_NOTEDELETE_ERROR", this.deleteNoteErrorIObserver);
    QMNotification.registNotification("N_NOTEDELETE_SUCC", this.deleteNoteSuccIObserver);
  }
  
  public void registerLoadNote()
  {
    QMNotification.registNotification("N_LOADNOTE_SUCC", this.loadNoteSuccIObserver);
    QMNotification.registNotification("N_LOADNOTE_BEFORESEND", this.loadNoteBeforeSendIObserver);
    QMNotification.registNotification("N_LOADNOTE_PREFETCH", this.loadNotePrefetchIObserver);
    QMNotification.registNotification("N_LOADNOTE_ERROR", this.loadNoteErrorIObserver);
  }
  
  public void registerStarNote()
  {
    QMNotification.registNotification("N_STARNOTE_SUCC", this.starNoteSuccIObserver);
    QMNotification.registNotification("N_STARNOTE_ERROR", this.starNoteErrorIObserver);
    QMNotification.registNotification("N_STARNOTE_PREFETCH", this.starNotePrefetchIObserver);
    QMNotification.registNotification("N_STARNOTE_BEFORESEND", this.starNoteBeforeSendIObserver);
  }
  
  public void registerUpdateNote()
  {
    QMNotification.registNotification("N_UPDATENOTE_ERROR", this.updateNoteErrorIObserver);
    QMNotification.registNotification("N_UPDATENOTE_SUCC", this.updateNoteSuccIObserver);
  }
  
  public String retrieveAllImages(String paramString)
  {
    paramString = Pattern.compile("(<img[^<>]*?src=\")([^<>]*?)(\"[^<>]*?>)").matcher(paramString);
    StringBuffer localStringBuffer = new StringBuffer();
    while (paramString.find())
    {
      String str = paramString.group(1);
      if ((str != null) && (str.length() > 0))
      {
        str = (String)IMAGE_MAPPING_POOL.get(str);
        if (str != null) {
          paramString.appendReplacement(localStringBuffer, unionImageTag(paramString.group(1), str, paramString.group(3)));
        } else {
          paramString.appendReplacement(localStringBuffer, paramString.group(0));
        }
      }
    }
    return localStringBuffer.toString();
  }
  
  public void shakeWebViewWrapper()
  {
    if ((this.mWebViewController != null) && (this.mWebViewController.getWebView() != null)) {
      this.mWebViewController.getWebView().post(new ReadNoteActivity.43(this));
    }
  }
  
  public void showCalendarDialog(String paramString, Long paramLong)
  {
    QMBottomDialog.BottomListSheetBuilder localBottomListSheetBuilder = new QMBottomDialog.BottomListSheetBuilder(getActivity());
    localBottomListSheetBuilder.setOnSheetItemClickListener(new ReadNoteActivity.51(this, paramLong, paramString));
    if (QMSettingManager.sharedInstance().getCalendarDisplay())
    {
      localBottomListSheetBuilder.addItem(getString(2131696292));
      localBottomListSheetBuilder.addItem(getString(2131691484));
    }
    localBottomListSheetBuilder.addItem(getString(2131692324));
    localBottomListSheetBuilder.setTitle(paramString + " " + getResources().getString(2131695684));
    localBottomListSheetBuilder.build().show();
  }
  
  public void showMailToDialog(String paramString)
  {
    QMBottomDialog.BottomListSheetBuilder localBottomListSheetBuilder = new QMBottomDialog.BottomListSheetBuilder(getActivity());
    localBottomListSheetBuilder.setOnSheetItemClickListener(new ReadNoteActivity.50(this, paramString));
    localBottomListSheetBuilder.addItem(getString(2131721918));
    localBottomListSheetBuilder.addItem(getString(2131692324));
    localBottomListSheetBuilder.setTitle(paramString);
    localBottomListSheetBuilder.build().show();
  }
  
  public void showTelDialog(String paramString)
  {
    String str = getExistContactName(paramString);
    QMBottomDialog.BottomListSheetBuilder localBottomListSheetBuilder = new QMBottomDialog.BottomListSheetBuilder(getActivity());
    localBottomListSheetBuilder.setOnSheetItemClickListener(new ReadNoteActivity.48(this, paramString, str));
    if (isTelEnable()) {
      localBottomListSheetBuilder.addItem(getString(2131692640));
    }
    if (ContactsHelper.filterPhoneNum(paramString) != null)
    {
      localBottomListSheetBuilder.addItem(getString(2131720364));
      localBottomListSheetBuilder.addItem(getString(2131721918));
    }
    if (str.equals(""))
    {
      localBottomListSheetBuilder.addItem(getString(2131689836));
      localBottomListSheetBuilder.addItem(getString(2131692324));
      if (!DeviceUtil.isWeChatPhoneBookInstalled()) {
        localBottomListSheetBuilder.addItem(getString(2131721643));
      }
      str = getExistContactName(paramString);
      if (!str.equals("")) {
        break label204;
      }
    }
    label204:
    for (paramString = paramString + " " + getResources().getString(2131695686);; paramString = str + "(" + paramString + ") " + getResources().getString(2131693280))
    {
      localBottomListSheetBuilder.setTitle(paramString);
      localBottomListSheetBuilder.build().show();
      return;
      localBottomListSheetBuilder.addItem(getString(2131693004));
      break;
    }
  }
  
  public void showUrlDialog(String paramString)
  {
    QMBottomDialog.BottomListSheetBuilder localBottomListSheetBuilder = new QMBottomDialog.BottomListSheetBuilder(getActivity());
    localBottomListSheetBuilder.setOnSheetItemClickListener(new ReadNoteActivity.52(this, paramString));
    localBottomListSheetBuilder.addItem(getString(2131696621));
    localBottomListSheetBuilder.addItem(getString(2131692324));
    localBottomListSheetBuilder.setTitle(paramString);
    localBottomListSheetBuilder.build().show();
  }
  
  public void sms(String paramString)
  {
    try
    {
      startActivity(new Intent("android.intent.action.VIEW", Uri.parse("qqbooksms:" + paramString)));
      DataCollector.logEvent("Event_Content_Recognize_Has_Wx_Book_Sms");
      return;
    }
    catch (Exception localException)
    {
      startActivity(new Intent("android.intent.action.SENDTO", Uri.parse("smsto:" + paramString)));
      DataCollector.logEvent("Event_Content_Recognize_Sms");
    }
  }
  
  protected void starNoteBeforeSend(Object paramObject) {}
  
  protected void starNoteError(Object paramObject) {}
  
  protected void starNotePrefetch(Object paramObject) {}
  
  protected void starNoteSucc(Object paramObject)
  {
    runOnMainThread(new ReadNoteActivity.20(this, paramObject));
  }
  
  public void unregisterDeleteNote()
  {
    QMNotification.unregistNotification("N_NOTEDELETE_ERROR", this.deleteNoteErrorIObserver);
    QMNotification.unregistNotification("N_NOTEDELETE_SUCC", this.deleteNoteSuccIObserver);
  }
  
  public void unregisterLoadNote()
  {
    QMNotification.unregistNotification("N_LOADNOTE_SUCC", this.loadNoteSuccIObserver);
    QMNotification.unregistNotification("N_LOADNOTE_BEFORESEND", this.loadNoteBeforeSendIObserver);
    QMNotification.unregistNotification("N_LOADNOTE_PREFETCH", this.loadNotePrefetchIObserver);
    QMNotification.unregistNotification("N_LOADNOTE_ERROR", this.loadNoteErrorIObserver);
  }
  
  public void unregisterStarNote()
  {
    QMNotification.unregistNotification("N_STARNOTE_SUCC", this.starNoteSuccIObserver);
    QMNotification.unregistNotification("N_STARNOTE_ERROR", this.starNoteErrorIObserver);
    QMNotification.unregistNotification("N_STARNOTE_PREFETCH", this.starNotePrefetchIObserver);
    QMNotification.unregistNotification("N_STARNOTE_BEFORESEND", this.starNoteBeforeSendIObserver);
  }
  
  public void unregisterUpdateNote()
  {
    QMNotification.unregistNotification("N_UPDATENOTE_ERROR", this.updateNoteErrorIObserver);
    QMNotification.unregistNotification("N_UPDATENOTE_SUCC", this.updateNoteSuccIObserver);
  }
  
  protected void updateNoteError(Object paramObject) {}
  
  protected void updateNoteSucc(Object paramObject)
  {
    if (paramObject != null)
    {
      this.mData = new QMComposeNote((QMNNote)paramObject);
      return;
    }
    Log.d("ReadNoteActivity", "updateNoteDataCallback onsuccess, but data is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.note.ReadNoteActivity
 * JD-Core Version:    0.7.0.1
 */