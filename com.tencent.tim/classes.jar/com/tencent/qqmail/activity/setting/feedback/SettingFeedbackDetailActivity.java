package com.tencent.qqmail.activity.setting.feedback;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.activity.compose.ComposeCommUI;
import com.tencent.qqmail.activity.compose.ComposeFeedbackActivity;
import com.tencent.qqmail.activity.media.MediaFolderSelectActivity;
import com.tencent.qqmail.attachment.util.QMAttachUtils;
import com.tencent.qqmail.marcos.AppConfig;
import com.tencent.qqmail.model.qmdomain.AttachInfo;
import com.tencent.qqmail.model.qmdomain.MailContent;
import com.tencent.qqmail.model.qmdomain.MailInformation;
import com.tencent.qqmail.model.uidomain.ComposeMailUI;
import com.tencent.qqmail.model.uidomain.ComposeMailUI.ImageScaleDegree;
import com.tencent.qqmail.model.uidomain.ComposeMailUI.QMComposeMailType;
import com.tencent.qqmail.utilities.uitableview.UITableItemView;
import com.tencent.qqmail.utilities.uitableview.UITableView;
import com.tencent.qqmail.view.QMBaseView;
import com.tencent.qqmail.view.QMTopBar;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SettingFeedbackDetailActivity
  extends ComposeFeedbackActivity
{
  private static final String ARG_DETAIL = "ARG_DETAIL";
  public static final String ARG_FROM_LOGIG = "ARG_FROM_LOGIG";
  private static final String ARG_SCENE = "ARG_SCENE";
  private static final String TAG = "SettingFeedbackDetailActivity";
  private FeedBackDetailInputLayout mFeedBackDetailInputLayout;
  private int mandatoryText;
  private List<Question> questionList = new ArrayList();
  private UITableView questionTableView;
  private String scene;
  private List<UITableItemView> tableItemViews = new ArrayList();
  
  public static Intent createIntent(Serializable paramSerializable, String paramString)
  {
    ComposeMailUI localComposeMailUI = new ComposeMailUI();
    localComposeMailUI.setType(ComposeMailUI.QMComposeMailType.COMPOSE_TYPE_FEED_BACK);
    Intent localIntent = new Intent(QMApplicationContext.sharedInstance(), SettingFeedbackDetailActivity.class);
    localIntent.putExtra("fromController", "setting");
    localIntent.putExtra("mail", localComposeMailUI);
    localIntent.putExtra("ARG_DETAIL", paramSerializable);
    localIntent.putExtra("showKeybord", false);
    localIntent.putExtra("ARG_SCENE", paramString);
    return localIntent;
  }
  
  private int getFirstCheckedPosition()
  {
    int i = 0;
    while (i < this.tableItemViews.size())
    {
      if (((UITableItemView)this.tableItemViews.get(i)).isChecked()) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  private void getQuestionList(StringBuilder paramStringBuilder)
  {
    int i = 0;
    while (i < this.tableItemViews.size())
    {
      if (((UITableItemView)this.tableItemViews.get(i)).isChecked()) {
        paramStringBuilder.append(((Question)this.questionList.get(i)).question).append("/");
      }
      i += 1;
    }
    paramStringBuilder.deleteCharAt(paramStringBuilder.length() - 1);
  }
  
  private QMBaseView initContainer()
  {
    QMBaseView localQMBaseView = new QMBaseView(getActivity());
    localQMBaseView.initScrollView(new FeedbackScrollView(getActivity()));
    RelativeLayout localRelativeLayout = (RelativeLayout)findViewById(2131365360);
    localRelativeLayout.setVisibility(8);
    ((FrameLayout)localRelativeLayout.getParent()).addView(localQMBaseView);
    ((FeedbackScrollView)localQMBaseView.getRootScrollView()).setOnScrollCallback(new SettingFeedbackDetailActivity.5(this));
    return localQMBaseView;
  }
  
  private void initFeedbackDetailInputLayout(Map<String, Object> paramMap, QMBaseView paramQMBaseView)
  {
    this.mFeedBackDetailInputLayout = new FeedBackDetailInputLayout(this, (String)paramMap.get("detailhint"));
    this.mFeedBackDetailInputLayout.setListener(new SettingFeedbackDetailActivity.1(this, paramQMBaseView));
    paramMap = new LinearLayout.LayoutParams(-1, -2);
    paramMap.topMargin = getResources().getDimensionPixelSize(2131299376);
    paramMap.bottomMargin = getResources().getDimensionPixelSize(2131299375);
    this.mFeedBackDetailInputLayout.setLayoutParams(paramMap);
    paramQMBaseView.addContentView(this.mFeedBackDetailInputLayout);
  }
  
  private void initQuestionTableView(Map<String, Object> paramMap, QMBaseView paramQMBaseView)
  {
    this.questionTableView = new UITableView(this);
    paramQMBaseView.addContentView(this.questionTableView);
    this.questionTableView.setCaption((String)paramMap.get("tophint"));
    paramMap = (List)paramMap.get("questionlist");
    int i = 0;
    while (i < paramMap.size())
    {
      paramQMBaseView = (Map)paramMap.get(i);
      String str = (String)paramQMBaseView.get("q");
      this.questionList.add(new Question(str, Integer.valueOf((String)paramQMBaseView.get("pic")).intValue()));
      paramQMBaseView = this.questionTableView.addItem(str);
      this.tableItemViews.add(paramQMBaseView);
      paramQMBaseView.setTailImage(2130850509);
      paramQMBaseView.setChecked(false);
      paramQMBaseView.setOnClickListener(new SettingFeedbackDetailActivity.2(this));
      i += 1;
    }
    this.questionTableView.commit();
  }
  
  private void initTopBar()
  {
    this.scene = getIntent().getStringExtra("ARG_SCENE");
    QMTopBar localQMTopBar = getTopBar();
    localQMTopBar.setTitle(this.scene);
    if (getIntent().getBooleanExtra("ARG_FROM_LOGIG", false))
    {
      localQMTopBar.setButtonLeftIcon(2130841088);
      localQMTopBar.getOnlyButtonLeftIcon().setOnClickListener(new SettingFeedbackDetailActivity.3(this));
    }
    for (;;)
    {
      localQMTopBar.setButtonRightOnclickListener(new SettingFeedbackDetailActivity.4(this));
      return;
      localQMTopBar.setButtonLeftBack();
    }
  }
  
  private List<AttachInfo> makeSureLessThanImagesCountCanAdd(List<AttachInfo> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject;
    if ((paramList == null) || (paramList.size() == 0)) {
      localObject = localArrayList;
    }
    int j;
    do
    {
      return localObject;
      j = this.mFeedBackDetailInputLayout.getImagesCountCanAdd();
      localObject = paramList;
    } while (paramList.size() <= j);
    int i = 0;
    while (i < j)
    {
      localArrayList.add(paramList.get(i));
      i += 1;
    }
    return localArrayList;
  }
  
  @NonNull
  private String prepareMailSubjet()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(ComposeCommUI.FEED_BACK_SUBJECT).append(" v").append(AppConfig.getCodeVersion()).append("-");
    getQuestionList(localStringBuilder);
    return localStringBuilder.toString();
  }
  
  public void finishProcessAttach(AttachInfo paramAttachInfo)
  {
    super.finishProcessAttach(paramAttachInfo);
    runOnMainThread(new SettingFeedbackDetailActivity.6(this, paramAttachInfo));
  }
  
  public List<AttachInfo> handleSelectImage(Intent paramIntent)
  {
    paramIntent = MediaFolderSelectActivity.getSelectedResult();
    MediaFolderSelectActivity.setSelectedResult(null);
    paramIntent = makeSureLessThanImagesCountCanAdd(paramIntent);
    if (paramIntent != null)
    {
      if ((paramIntent.size() > 0) && (!this.hasAttachCache)) {
        this.hasAttachCache = true;
      }
      QMAttachUtils.handleAddAttach(paramIntent, this.composeMail);
    }
    return paramIntent;
  }
  
  public boolean hasDiffer()
  {
    super.hasDiffer();
    return false;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    com.tencent.qqmail.marcos.CommonDefine.SAVE_LOCAL_DRAFT = false;
    super.onCreate(paramBundle);
    initTopBar();
    paramBundle = initContainer();
    HashMap localHashMap = (HashMap)getIntent().getExtras().getSerializable("ARG_DETAIL");
    this.mandatoryText = Integer.valueOf((String)localHashMap.get("mandatorytext")).intValue();
    initQuestionTableView(localHashMap, paramBundle);
    initFeedbackDetailInputLayout(localHashMap, paramBundle);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    com.tencent.qqmail.marcos.CommonDefine.SAVE_LOCAL_DRAFT = true;
  }
  
  public boolean onDragBack(MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  public String otherFeedBackInofForSendMail()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("【场景】").append(this.scene);
    addNewLine(localStringBuilder);
    localStringBuilder.append("【问题】");
    getQuestionList(localStringBuilder);
    addNewLine(localStringBuilder);
    localStringBuilder.append("【详情】").append(this.mFeedBackDetailInputLayout.getInputContent());
    addNewLine(localStringBuilder);
    return localStringBuilder.toString();
  }
  
  public String prepareContentForSendMail(ComposeMailUI paramComposeMailUI)
  {
    super.prepareContentForSendMail(paramComposeMailUI);
    paramComposeMailUI = prepareMailSubjet();
    this.composeMail.getInformation().setSubject(paramComposeMailUI);
    return this.composeMail.getContent().getBody();
  }
  
  public String prepareFeedbackBodyString(String paramString)
  {
    return prepareContentForSendMail(this.composeMail);
  }
  
  public String prepareFeedbackSubject()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    getQuestionList(localStringBuilder);
    return localStringBuilder.toString();
  }
  
  public void setWindowBackgroundColor(String paramString)
  {
    if (paramString.equals("onResume")) {
      setWindowBackgroundColor(getResources().getColor(2131167681), false);
    }
  }
  
  public void showChooseActionSheet()
  {
    this.composeMail.setImageScale(ComposeMailUI.ImageScaleDegree.ImageScaleDegree_Low);
    compressDone();
  }
  
  class Question
  {
    int mandatoryPic;
    String question;
    
    Question(String paramString, int paramInt)
    {
      this.question = paramString;
      this.mandatoryPic = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.feedback.SettingFeedbackDetailActivity
 * JD-Core Version:    0.7.0.1
 */