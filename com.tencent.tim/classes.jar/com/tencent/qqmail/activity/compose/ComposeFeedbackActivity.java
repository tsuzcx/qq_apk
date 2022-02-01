package com.tencent.qqmail.activity.compose;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.activity.setting.SettingHelpActivity;
import com.tencent.qqmail.attachment.model.Attach;
import com.tencent.qqmail.model.qmdomain.AttachInfo;
import com.tencent.qqmail.model.qmdomain.MailContent;
import com.tencent.qqmail.model.uidomain.ComposeMailUI;
import com.tencent.qqmail.model.uidomain.ComposeMailUI.QMComposeMailType;
import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialog.MessageDialogBuilder;
import com.tencent.qqmail.utilities.log.FeedbackManager;
import com.tencent.qqmail.utilities.log.LogPathManager;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMGeneralCallback;
import com.tencent.qqmail.utilities.stringextention.StringExtention;
import com.tencent.qqmail.utilities.thread.Threads;
import com.tencent.qqmail.utilities.validate.ValidateEmail;
import com.tencent.qqmail.view.QMTopBar;
import java.util.ArrayList;

public class ComposeFeedbackActivity
  extends ComposeMailActivity
{
  private static final String TAG = "ComposeFeedbackActivity";
  private EditText etContactInfo;
  private long feedBackAttachHashId = 0L;
  protected String feedbackToEmail = null;
  private boolean fromMemMonitor = false;
  public boolean hasFinishCompressFeedbackFile = true;
  QMGeneralCallback sendcallback = new ComposeFeedbackActivity.8(this);
  private boolean toggleAddContact = false;
  
  private void buildInputRemindDialog()
  {
    ((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)new QMUIDialog.MessageDialogBuilder(getActivity()).setTitle(2131719842)).setMessage(2131719835).addAction(2131696547, new ComposeFeedbackActivity.13(this))).create().show();
  }
  
  public static Intent createIntent(ComposeMailUI paramComposeMailUI, String paramString)
  {
    Intent localIntent = new Intent(QMApplicationContext.sharedInstance(), ComposeFeedbackActivity.class);
    localIntent.putExtra("fromController", paramString);
    localIntent.putExtra("mail", paramComposeMailUI);
    localIntent.putExtra("animationType", 1);
    return localIntent;
  }
  
  public static Intent createIntent(ComposeMailUI paramComposeMailUI, String paramString1, String paramString2)
  {
    paramComposeMailUI = createIntent(paramComposeMailUI, paramString1);
    paramComposeMailUI.putExtra("appendAddr", true);
    paramComposeMailUI.putExtra("appendAddr", paramString2);
    paramComposeMailUI.putExtra("animationType", 1);
    return paramComposeMailUI;
  }
  
  private boolean filterCanSendByAppAccount(Account paramAccount)
  {
    return paramAccount.getAccountState() == 0;
  }
  
  /* Error */
  private static java.util.List<String> getFeedbackMan()
  {
    // Byte code:
    //   0: new 158	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 159	java/util/ArrayList:<init>	()V
    //   7: astore_3
    //   8: new 161	java/io/BufferedReader
    //   11: dup
    //   12: new 163	java/io/InputStreamReader
    //   15: dup
    //   16: invokestatic 117	com/tencent/qqmail/QMApplicationContext:sharedInstance	()Lcom/tencent/qqmail/QMApplicationContext;
    //   19: invokevirtual 167	com/tencent/qqmail/QMApplicationContext:getResources	()Landroid/content/res/Resources;
    //   22: invokevirtual 173	android/content/res/Resources:getAssets	()Landroid/content/res/AssetManager;
    //   25: ldc 175
    //   27: invokevirtual 181	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   30: invokespecial 184	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   33: invokespecial 187	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   36: astore_1
    //   37: aload_1
    //   38: astore_0
    //   39: aload_1
    //   40: invokevirtual 191	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   43: astore_2
    //   44: aload_2
    //   45: ifnull +54 -> 99
    //   48: aload_1
    //   49: astore_0
    //   50: aload_3
    //   51: aload_2
    //   52: invokeinterface 197 2 0
    //   57: pop
    //   58: goto -21 -> 37
    //   61: astore_2
    //   62: aload_1
    //   63: astore_0
    //   64: bipush 6
    //   66: ldc 8
    //   68: new 199	java/lang/StringBuilder
    //   71: dup
    //   72: invokespecial 200	java/lang/StringBuilder:<init>	()V
    //   75: ldc 202
    //   77: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: aload_2
    //   81: invokevirtual 209	java/io/IOException:toString	()Ljava/lang/String;
    //   84: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: invokevirtual 210	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   90: invokestatic 216	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   93: aload_1
    //   94: invokevirtual 219	java/io/BufferedReader:close	()V
    //   97: aload_3
    //   98: areturn
    //   99: aload_1
    //   100: invokevirtual 219	java/io/BufferedReader:close	()V
    //   103: aload_3
    //   104: areturn
    //   105: astore_0
    //   106: aload_3
    //   107: areturn
    //   108: astore_1
    //   109: aconst_null
    //   110: astore_0
    //   111: aload_0
    //   112: invokevirtual 219	java/io/BufferedReader:close	()V
    //   115: aload_1
    //   116: athrow
    //   117: astore_0
    //   118: aload_3
    //   119: areturn
    //   120: astore_0
    //   121: goto -6 -> 115
    //   124: astore_1
    //   125: goto -14 -> 111
    //   128: astore_2
    //   129: aconst_null
    //   130: astore_1
    //   131: goto -69 -> 62
    // Local variable table:
    //   start	length	slot	name	signature
    //   38	26	0	localBufferedReader1	java.io.BufferedReader
    //   105	1	0	localException1	java.lang.Exception
    //   110	2	0	localObject1	Object
    //   117	1	0	localException2	java.lang.Exception
    //   120	1	0	localException3	java.lang.Exception
    //   36	64	1	localBufferedReader2	java.io.BufferedReader
    //   108	8	1	localObject2	Object
    //   124	1	1	localObject3	Object
    //   130	1	1	localObject4	Object
    //   43	9	2	str	String
    //   61	20	2	localIOException1	java.io.IOException
    //   128	1	2	localIOException2	java.io.IOException
    //   7	112	3	localArrayList	ArrayList
    // Exception table:
    //   from	to	target	type
    //   39	44	61	java/io/IOException
    //   50	58	61	java/io/IOException
    //   99	103	105	java/lang/Exception
    //   8	37	108	finally
    //   93	97	117	java/lang/Exception
    //   111	115	120	java/lang/Exception
    //   39	44	124	finally
    //   50	58	124	finally
    //   64	93	124	finally
    //   8	37	128	java/io/IOException
  }
  
  private void prepareContactInfo()
  {
    Object localObject = (LinearLayout)findViewById(2131365166);
    ((LinearLayout)localObject).setVisibility(0);
    TextView localTextView = (TextView)((LinearLayout)localObject).findViewById(2131365192);
    Button localButton = (Button)((LinearLayout)localObject).findViewById(2131364662);
    localTextView.setText(2131719831);
    localTextView.setVisibility(0);
    this.etContactInfo = ((EditText)((LinearLayout)localObject).findViewById(2131365191));
    if (getIntent().getStringExtra("appendAddr").isEmpty())
    {
      this.etContactInfo.requestFocus();
      this.etContactInfo.requestFocusFromTouch();
      setCurrentFocusView(this.etContactInfo);
    }
    this.etContactInfo.setText(getIntent().getStringExtra("appendAddr"));
    localObject = this.etContactInfo.getText().toString().trim();
    if ((ValidateEmail.verifyQQMailFormat((String)localObject) == 0) && (localObject.split("@")[0].length() <= 18) && (localObject.split("@")[0].length() >= 3) && (!((String)localObject).contains("@")) && (!((String)localObject).isEmpty())) {
      this.etContactInfo.setText((String)localObject + "@qq.com");
    }
    if (!this.etContactInfo.getText().toString().equals("")) {
      localButton.setVisibility(0);
    }
    this.etContactInfo.setOnFocusChangeListener(new ComposeFeedbackActivity.3(this));
    this.etContactInfo.addTextChangedListener(new ComposeFeedbackActivity.4(this, localButton));
    localButton.setOnClickListener(new ComposeFeedbackActivity.5(this));
  }
  
  private void showSelectList()
  {
    Threads.runOnMainThread(new ComposeFeedbackActivity.9(this));
  }
  
  protected String addComplainant(String paramString)
  {
    if (!this.toggleAddContact) {
      return paramString;
    }
    return "-User Contact:" + this.etContactInfo.getText() + " -Complaint:" + paramString;
  }
  
  protected void addNewLine(StringBuilder paramStringBuilder)
  {
    paramStringBuilder.append("<br/>");
  }
  
  public String feedBackContactInfo()
  {
    if (this.etContactInfo.getText().toString().equals("")) {
      return null;
    }
    return "User contact info: " + this.etContactInfo.getText();
  }
  
  public void finish()
  {
    LocalDraftUtils.deleteLocalDraft();
    stopSavingLocalDraft(false);
    if (getIntent().getBooleanExtra("arg_from_setting_feedback", false)) {
      startActivity(SettingHelpActivity.createIntent("https://kf.qq.com/touch/product/mail_app.html?scene_id=kf1866"));
    }
    super.finish();
  }
  
  protected void handleFeedbackAttachFile(ComposeMailUI paramComposeMailUI)
  {
    if ((paramComposeMailUI == null) || (this.bUseLocalDraft) || (paramComposeMailUI.getType() != ComposeMailUI.QMComposeMailType.COMPOSE_TYPE_FEED_BACK)) {
      return;
    }
    this.hasFinishCompressFeedbackFile = false;
    String str = LogPathManager.getInstance().getLogfileZipFilePath();
    AttachInfo localAttachInfo = new AttachInfo();
    localAttachInfo.setAttachPath(str);
    localAttachInfo.setAbsAttachPath(str);
    localAttachInfo.setAttachName("logfile.zip");
    localAttachInfo.setNewAdded(false);
    localAttachInfo.setProcessed(false);
    this.feedBackAttachHashId = Attach.generateHashId(paramComposeMailUI.getComposeDate(), String.valueOf(localAttachInfo.getRealSize()), localAttachInfo.getAttachName());
    localAttachInfo.setHashId(this.feedBackAttachHashId);
    if (paramComposeMailUI.getTotalAttachInfoList() == null) {
      paramComposeMailUI.setTotalAttachInfoList(new ArrayList());
    }
    addAttach(localAttachInfo);
    this.attachHandlingCount += 1;
    runInBackground(new ComposeFeedbackActivity.10(this, str, localAttachInfo, paramComposeMailUI));
  }
  
  public void onClickAttach(ComposeMailView paramComposeMailView, QMComposeAttachItem paramQMComposeAttachItem)
  {
    AttachInfo localAttachInfo = (AttachInfo)paramQMComposeAttachItem.getTag(2131379198);
    if (localAttachInfo == null) {
      return;
    }
    if (localAttachInfo.getHashId() != this.feedBackAttachHashId)
    {
      super.onClickAttach(paramComposeMailView, paramQMComposeAttachItem);
      return;
    }
    paramQMComposeAttachItem.showPressed();
    ((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)new QMUIDialog.MessageDialogBuilder(this).setTitle(2131696424)).setMessage(2131691896).addAction(2131691246, new ComposeFeedbackActivity.12(this))).addAction(0, 2131692498, 2, new ComposeFeedbackActivity.11(this, paramQMComposeAttachItem))).create().show();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.toggleAddContact = getIntent().getBooleanExtra("appendAddr", false);
    this.feedbackToEmail = getIntent().getStringExtra("arg_feedback_to_email");
    if (this.toggleAddContact) {
      prepareContactInfo();
    }
    if (!this.toggleAddContact)
    {
      if (this.feedbackToEmail == null) {
        break label135;
      }
      setFeedbackReceiver(this.feedbackToEmail);
      QMLog.log(4, "ComposeFeedbackActivity", "feedback send to " + this.feedbackToEmail);
    }
    for (;;)
    {
      getTopBar().setButtonRightOnclickListener(new ComposeFeedbackActivity.2(this));
      this.fromMemMonitor = getIntent().getBooleanExtra("fromMemoryMonitor", false);
      this.composeView.focusAtEditor();
      return;
      label135:
      getTopBar().setCenterOnLongClickListener(new ComposeFeedbackActivity.1(this));
    }
  }
  
  protected String otherFeedBackInofForSendMail()
  {
    return "";
  }
  
  public String prepareContentForSendMail(ComposeMailUI paramComposeMailUI)
  {
    super.prepareContentForSendMail(paramComposeMailUI);
    String str = paramComposeMailUI.getContent().getBody();
    Object localObject = str;
    if (paramComposeMailUI.getType() == ComposeMailUI.QMComposeMailType.COMPOSE_TYPE_FEED_BACK)
    {
      localObject = new StringBuilder();
      if (this.toggleAddContact)
      {
        ((StringBuilder)localObject).append(feedBackContactInfo());
        addNewLine((StringBuilder)localObject);
      }
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append(otherFeedBackInofForSendMail());
      str = FeedbackManager.feedBackDeviceInfos();
      ((StringBuilder)localObject).append("<br/>");
      ((StringBuilder)localObject).append("<br/>");
      ((StringBuilder)localObject).append(StringExtention.textToHtml(str));
      localObject = ((StringBuilder)localObject).toString();
    }
    paramComposeMailUI.getContent().setBody((String)localObject);
    return localObject;
  }
  
  protected String prepareFeedbackBodyString(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    return addComplainant(str) + "-" + FeedbackManager.feedBackDeviceInfos();
  }
  
  protected String prepareFeedbackSubject()
  {
    return "";
  }
  
  public void sendFeedBack(View paramView)
  {
    paramView = AccountManager.shareInstance().getAccountList();
    if ((paramView != null) && (paramView.size() > 0))
    {
      paramView = paramView.get(0);
      int i = 1;
      if (!filterCanSendByAppAccount(paramView)) {
        i = 0;
      }
      if (i == 0)
      {
        QMLog.log(4, "ComposeFeedbackActivity", "send conplaint by default account");
        Toast.makeText(QMApplicationContext.sharedInstance(), 2131696468, 0).show();
        runInBackground(new ComposeFeedbackActivity.6(this));
        finish();
        return;
      }
      QMLog.log(4, "ComposeFeedbackActivity", "send conplaint by user account");
      handleSendButton();
      return;
    }
    QMLog.log(4, "ComposeFeedbackActivity", "send conplaint by no account");
    Toast.makeText(QMApplicationContext.sharedInstance(), 2131696468, 0).show();
    runInBackground(new ComposeFeedbackActivity.7(this));
    finish();
  }
  
  protected void setWindowBackgroundColor(String paramString)
  {
    if (paramString.equals("onResume")) {
      setWindowBackgroundColor(-1, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.ComposeFeedbackActivity
 * JD-Core Version:    0.7.0.1
 */