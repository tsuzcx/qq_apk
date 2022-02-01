package com.tencent.qqmail.activity.compose;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.model.qmdomain.MailContact;
import com.tencent.qqmail.model.qmdomain.MailGroupContact;
import com.tencent.qqmail.utilities.ui.QMUIHelper;
import com.tencent.qqmail.utilities.ui.QMUIKit;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class QMComposeHeader
  extends LinearLayout
  implements ComposeAddrView.ComposeAddrViewCallback, QMTextField.QMTextFieldCallback
{
  private static String TAG = "QMComposeHeader";
  private ComposeAddrView Bcc;
  private ComposeAddrView CC;
  private QMComposeHeaderCallback callback;
  private QQMailUILabel ccAndBcc;
  private LinearLayout feedbackMailLL;
  private String focusView = "";
  private LinearLayout groupMailLL;
  private ComposeGroupAddrView groupReceiver;
  private TextView hintTV;
  private Account mDefaltSenderAccount;
  private QQMailUILabel mReceiver;
  private QQMailUILabel mSender;
  private LinearLayout normalMailLL;
  private ComposeAddrView receiver;
  private int screenHight = 0;
  private int screenWidth = 0;
  private ComposeCommUI.QMSendType sendType;
  private QMTextField subject;
  
  public QMComposeHeader(Context paramContext)
  {
    super(paramContext);
  }
  
  public QMComposeHeader(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void hideAllAddButton()
  {
    this.receiver.getmContactImage().setVisibility(4);
    this.CC.getmContactImage().setVisibility(4);
    this.Bcc.getmContactImage().setVisibility(4);
  }
  
  private void initCCAndBcc()
  {
    this.ccAndBcc = ((QQMailUILabel)findViewById(2131365164));
    this.ccAndBcc.init();
    this.CC = ((ComposeAddrView)findViewById(2131365163));
    this.CC.setTotalWidth(this.screenWidth);
    this.CC.init(false);
    this.CC.setiType(2);
    this.CC.setHasAddImage(true);
    this.CC.setVisibility(8);
    this.CC.setCallback(this);
    this.Bcc = ((ComposeAddrView)findViewById(2131365162));
    this.Bcc.setTotalWidth(this.screenWidth);
    this.Bcc.init(false);
    this.Bcc.setiType(3);
    this.Bcc.setHasAddImage(true);
    this.Bcc.setVisibility(8);
    this.Bcc.setCallback(this);
    this.mSender = ((QQMailUILabel)findViewById(2131365173));
    this.mSender.init();
    this.mSender.setVisibility(8);
  }
  
  private void initReceiver()
  {
    this.receiver = ((ComposeAddrView)findViewById(2131365171));
    this.receiver.setTotalWidth(this.screenWidth);
    this.receiver.init(false);
    this.receiver.getAddrsViewControl().setExpanded(false);
    this.receiver.setiType(1);
    this.receiver.setHasAddImage(true);
    this.receiver.setCallback(this);
    this.receiver.setVisibility(0);
    this.groupReceiver = ((ComposeGroupAddrView)findViewById(2131365168));
    this.groupReceiver.init();
    this.groupReceiver.setCallback(this);
    this.mReceiver = ((QQMailUILabel)findViewById(2131365172));
    this.mReceiver.init();
    this.mReceiver.setVisibility(8);
    this.mReceiver.setOnClickListener(new QMComposeHeader.1(this));
  }
  
  private void initSubject()
  {
    this.subject = ((QMTextField)findViewById(2131365174));
    this.subject.init();
    this.subject.getPrefixTV().setText(getResources().getString(2131691908));
    this.subject.setCallback(this);
  }
  
  private void initViews()
  {
    this.normalMailLL = ((LinearLayout)findViewById(2131365170));
    this.groupMailLL = ((LinearLayout)findViewById(2131365167));
    this.feedbackMailLL = ((LinearLayout)findViewById(2131365165));
    initReceiver();
    initCCAndBcc();
    initSubject();
    this.hintTV = ((TextView)findViewById(2131365169));
    if ((this.CC.getAddrsViewControl().getMailAddrs().size() > 0) || (this.Bcc.getAddrsViewControl().getMailAddrs().size() > 0)) {
      showCCAndBcc();
    }
  }
  
  private void layout()
  {
    layoutComposeMail(ComposeCommUI.QMSendType.t_SEND_NORMAL_MAIL);
  }
  
  private void layoutForSendType(ComposeCommUI.QMSendType paramQMSendType)
  {
    if ((paramQMSendType == ComposeCommUI.QMSendType.t_SEND_NORMAL_MAIL) || (paramQMSendType == ComposeCommUI.QMSendType.t_SEND_CLOCKED_MAIL)) {
      layoutComposeMail(paramQMSendType);
    }
    while (paramQMSendType != ComposeCommUI.QMSendType.t_SEND_GROUP_MAIL) {
      return;
    }
    layoutComposeGroupMail();
  }
  
  public void addrViewScrollChanged(ComposeAddrView paramComposeAddrView)
  {
    if (this.callback != null) {
      this.callback.addrViewScrollChanged(this, paramComposeAddrView);
    }
  }
  
  public void addrViewTextChanged(ComposeAddrView paramComposeAddrView, String paramString)
  {
    if (this.callback != null) {
      this.callback.addrViewTextChanged(this, paramComposeAddrView, paramString);
    }
  }
  
  public void bindLongClickListener(ComposeMailActivity.LongClickListener paramLongClickListener)
  {
    this.receiver.getAddrsViewControl().setLongClickListener(paramLongClickListener);
    this.Bcc.getAddrsViewControl().setLongClickListener(paramLongClickListener);
    this.CC.getAddrsViewControl().setLongClickListener(paramLongClickListener);
  }
  
  public void bindMoveListener(ComposeMailActivity.OnMoveListener paramOnMoveListener)
  {
    this.receiver.getAddrsViewControl().setOnMoveListener(paramOnMoveListener);
    this.Bcc.getAddrsViewControl().setOnMoveListener(paramOnMoveListener);
    this.CC.getAddrsViewControl().setOnMoveListener(paramOnMoveListener);
  }
  
  public void changeDefaultSenderAccount(Account paramAccount)
  {
    int i = 0;
    this.mDefaltSenderAccount = paramAccount;
    ComposeAddrView[] arrayOfComposeAddrView = new ComposeAddrView[3];
    arrayOfComposeAddrView[0] = this.receiver;
    arrayOfComposeAddrView[1] = this.Bcc;
    arrayOfComposeAddrView[2] = this.CC;
    int j = arrayOfComposeAddrView.length;
    while (i < j)
    {
      ComposeAddrView localComposeAddrView = arrayOfComposeAddrView[i];
      if (localComposeAddrView != null) {
        localComposeAddrView.changeDefaultSenderAccount(paramAccount);
      }
      i += 1;
    }
  }
  
  public void clickAddContactButton(ComposeAddrView paramComposeAddrView)
  {
    if (this.callback != null) {
      this.callback.clickedAddContactButton(this, paramComposeAddrView);
    }
  }
  
  public void clickedAddGroupContactButton(ComposeAddrView paramComposeAddrView)
  {
    if (this.callback != null) {
      this.callback.clickedAddGroupContactButton(this, paramComposeAddrView);
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public void enterForClearFocus(ComposeAddrView paramComposeAddrView, boolean paramBoolean)
  {
    if (this.callback != null) {
      this.callback.enterForClearFocus(this, paramComposeAddrView, paramBoolean);
    }
  }
  
  public int getAddrMinHeight()
  {
    return this.receiver.getUnExpandHeight();
  }
  
  public ArrayList<Object> getAllContact()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = getToContactList().iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(localIterator.next());
    }
    localIterator = getCCContactList().iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(localIterator.next());
    }
    localIterator = getBccContactList().iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(localIterator.next());
    }
    return localArrayList;
  }
  
  public ComposeAddrView getBcc()
  {
    return this.Bcc;
  }
  
  public ArrayList<Object> getBccContactList()
  {
    return this.Bcc.getContactList();
  }
  
  public ComposeAddrView getCC()
  {
    return this.CC;
  }
  
  public ArrayList<Object> getCCContactList()
  {
    return this.CC.getContactList();
  }
  
  public QMComposeHeaderCallback getCallback()
  {
    return this.callback;
  }
  
  public QQMailUILabel getCcAndBcc()
  {
    return this.ccAndBcc;
  }
  
  public int getCcAndBccMinHeight()
  {
    return this.receiver.getUnExpandHeight();
  }
  
  public View getFirstFocusView()
  {
    Object localObject3 = null;
    Object localObject1;
    if (this.sendType == ComposeCommUI.QMSendType.t_SEND_GROUP_MAIL) {
      localObject1 = this.subject.getTextFieldET();
    }
    for (;;)
    {
      Object localObject2 = localObject3;
      if (localObject1 != null)
      {
        localObject2 = localObject3;
        if (((View)localObject1).isFocusable()) {
          localObject2 = localObject1;
        }
      }
      do
      {
        return localObject2;
        if (this.sendType == ComposeCommUI.QMSendType.t_SEND_FEEDBACK_MAIL)
        {
          localObject1 = null;
          break;
        }
        localObject2 = localObject3;
      } while (this.receiver == null);
      localObject1 = this.receiver.getAddrsViewControl();
      if (((MailAddrsViewControl)localObject1).isEditable()) {
        localObject1 = ((MailAddrsViewControl)localObject1).getInputATV();
      } else {
        localObject1 = null;
      }
    }
  }
  
  public ComposeGroupAddrView getGroupReceiver()
  {
    return this.groupReceiver;
  }
  
  public ArrayList<Object> getGroupToContactList()
  {
    return this.groupReceiver.getContactList();
  }
  
  public ComposeAddrView getReceiver()
  {
    return this.receiver;
  }
  
  public QQMailUILabel getReceiverLabel()
  {
    return this.mReceiver;
  }
  
  public ComposeCommUI.QMSendType getSendType()
  {
    return this.sendType;
  }
  
  public QQMailUILabel getSenderLabel()
  {
    return this.mSender;
  }
  
  public int getSenderMinHeight()
  {
    return this.receiver.getUnExpandHeight();
  }
  
  public QMTextField getSubject()
  {
    return this.subject;
  }
  
  public int getSubjectMinHeight()
  {
    return this.subject.getHeight();
  }
  
  public String getSubjectText()
  {
    return this.subject.getText();
  }
  
  public ArrayList<Object> getToContactList()
  {
    if (this.sendType == ComposeCommUI.QMSendType.t_SEND_GROUP_MAIL) {
      return this.groupReceiver.getContactList();
    }
    return this.receiver.getContactList();
  }
  
  public boolean hasCCorBCC()
  {
    return (this.CC.hasContact()) || (this.Bcc.hasContact());
  }
  
  public boolean hasFocusCursor()
  {
    return ((this.receiver != null) && (this.receiver.hasFocusCursor())) || ((this.CC != null) && (this.CC.hasFocusCursor())) || ((this.Bcc != null) && (this.Bcc.hasFocusCursor())) || ((this.subject != null) && (this.subject.hasFocusCursor()));
  }
  
  public void hideCCAndBcc()
  {
    this.ccAndBcc.setVisibility(0);
    this.CC.setVisibility(8);
    this.Bcc.setVisibility(8);
    this.mSender.setVisibility(8);
  }
  
  public void hideHintLabel()
  {
    this.hintTV.setVisibility(8);
  }
  
  public void init(ComposeCommUI.QMSendType paramQMSendType)
  {
    this.sendType = paramQMSendType;
    initViews();
  }
  
  public void inputClickChanged(ComposeAddrView paramComposeAddrView)
  {
    if (this.callback != null) {
      this.callback.onClickChange(this, paramComposeAddrView);
    }
  }
  
  public void inputFocusChanged(ComposeAddrView paramComposeAddrView, boolean paramBoolean)
  {
    hideAllAddButton();
    ImageView localImageView = paramComposeAddrView.getmContactImage();
    int i = paramComposeAddrView.getiType();
    if (!paramBoolean)
    {
      if (localImageView != null) {
        localImageView.setVisibility(4);
      }
      if (((i == 2) || (i == 3)) && (!this.CC.getAddrsViewControl().getInputATV().isFocused()) && (!this.Bcc.getAddrsViewControl().getInputATV().isFocused()) && (!this.CC.hasContact()) && (!this.Bcc.hasContact()) && (this.CC.getAddrsViewControl().isInputAreaEmpty()) && (this.Bcc.getAddrsViewControl().isInputAreaEmpty()))
      {
        i = 100;
        if (this.subject.hasFocus()) {
          i = 300;
        }
        postDelayed(new QMComposeHeader.5(this), i);
      }
    }
    for (;;)
    {
      if (this.callback != null) {
        this.callback.onFocusChange(this, paramComposeAddrView, paramBoolean);
      }
      return;
      if (localImageView != null)
      {
        localImageView.setVisibility(0);
        QMUIKit.expendTouchArea(localImageView);
      }
    }
  }
  
  public void layoutComposeCardMail()
  {
    Object localObject = (MailContact)this.mSender.getOtherInfo();
    if (localObject != null) {}
    for (localObject = ((MailContact)localObject).showText();; localObject = "")
    {
      this.ccAndBcc.setVisibility(8);
      this.mSender.setVisibility(0);
      this.mSender.setTitle((String)localObject);
      this.mSender.getPrefixTV().setText(getResources().getString(2131691905));
      this.mSender.getContentTV().setTextColor(Color.rgb(150, 150, 150));
      this.mSender.setOnClickListener(new QMComposeHeader.4(this));
      this.receiver.getPrefixTV().setText(getResources().getString(2131691907));
      return;
    }
  }
  
  public void layoutComposeFeedBack()
  {
    this.normalMailLL.setVisibility(8);
    this.groupMailLL.setVisibility(8);
    this.feedbackMailLL.setVisibility(8);
    this.subject.setVisibility(8);
  }
  
  public void layoutComposeGroupMail()
  {
    this.receiver.getmContactImage().setVisibility(8);
    this.sendType = ComposeCommUI.QMSendType.t_SEND_GROUP_MAIL;
    this.normalMailLL.setVisibility(8);
    this.groupMailLL.setVisibility(0);
    this.feedbackMailLL.setVisibility(8);
  }
  
  public void layoutComposeMail(ComposeCommUI.QMSendType paramQMSendType)
  {
    this.sendType = paramQMSendType;
    paramQMSendType = (MailContact)this.mSender.getOtherInfo();
    if (paramQMSendType != null) {}
    for (paramQMSendType = paramQMSendType.showText();; paramQMSendType = "")
    {
      this.mSender.setTitle(paramQMSendType);
      this.receiver.getPrefixTV().setText(getResources().getString(2131691903));
      this.mReceiver.getPrefixTV().setText(getResources().getString(2131691903));
      this.mSender.getPrefixTV().setText(getResources().getString(2131691905));
      this.ccAndBcc.getPrefixTV().setText(getResources().getString(2131691906));
      this.CC.getPrefixTV().setText(getResources().getString(2131691901));
      this.Bcc.getPrefixTV().setText(getResources().getString(2131691900));
      this.receiver.getAddrsViewControl().getInputATV().setContentDescription(getResources().getString(2131691903));
      this.CC.getAddrsViewControl().getInputATV().setContentDescription(getResources().getString(2131691901));
      this.Bcc.getAddrsViewControl().getInputATV().setContentDescription(getResources().getString(2131691900));
      this.ccAndBcc.setOnClickListener(new QMComposeHeader.2(this));
      this.mSender.setOnClickListener(new QMComposeHeader.3(this));
      this.normalMailLL.setVisibility(0);
      this.groupMailLL.setVisibility(8);
      this.feedbackMailLL.setVisibility(8);
      return;
    }
  }
  
  public void layoutComposeNote()
  {
    this.sendType = ComposeCommUI.QMSendType.t_SEND_NOTE_MAIL;
    if (this.normalMailLL != null) {
      this.normalMailLL.setVisibility(8);
    }
    if (this.groupMailLL != null) {
      this.groupMailLL.setVisibility(8);
    }
    if (this.feedbackMailLL != null) {
      this.feedbackMailLL.setVisibility(8);
    }
  }
  
  public void onClickChange(QMTextField paramQMTextField)
  {
    if (this.callback != null) {
      this.callback.onClickChange(this, paramQMTextField);
    }
  }
  
  public void onFocusChange(QMTextField paramQMTextField, boolean paramBoolean)
  {
    if (paramBoolean) {
      paramQMTextField.getTextFieldET().setSelection(paramQMTextField.getText().length());
    }
    if (this.callback != null) {
      this.callback.onFocusChange(this, paramQMTextField, paramBoolean);
    }
  }
  
  public void onKeyNext()
  {
    if (this.callback != null) {
      this.callback.enterForClearFocus(this, this.subject, false);
    }
  }
  
  public void restoreFocusCursor()
  {
    if ((this.focusView.equals("to")) && (this.receiver != null)) {
      this.receiver.setFocused(true);
    }
    for (;;)
    {
      this.focusView = "";
      return;
      if ((this.focusView.equals("cc")) && (this.CC != null)) {
        this.CC.setFocused(true);
      } else if ((this.focusView.equals("bcc")) && (this.Bcc != null)) {
        this.Bcc.setFocused(true);
      } else if ((this.focusView.equals("subj")) && (this.subject != null)) {
        this.subject.setFocused(true);
      }
    }
  }
  
  public void saveFocusCursor()
  {
    if ((this.receiver != null) && (this.receiver.hasFocusCursor())) {
      this.focusView = "to";
    }
    do
    {
      return;
      if ((this.CC != null) && (this.CC.hasFocusCursor()))
      {
        this.focusView = "cc";
        return;
      }
      if ((this.Bcc != null) && (this.Bcc.hasFocusCursor()))
      {
        this.focusView = "bcc";
        return;
      }
    } while ((this.subject == null) || (!this.subject.hasFocusCursor()));
    this.focusView = "subj";
  }
  
  public void setCallback(QMComposeHeaderCallback paramQMComposeHeaderCallback)
  {
    this.callback = paramQMComposeHeaderCallback;
  }
  
  public void setGroupReceiver(ComposeGroupAddrView paramComposeGroupAddrView)
  {
    this.groupReceiver = paramComposeGroupAddrView;
  }
  
  public void setGroupToWithContact(MailGroupContact paramMailGroupContact)
  {
    if (paramMailGroupContact == null) {
      return;
    }
    this.groupReceiver.setGroupToWithContact(paramMailGroupContact);
  }
  
  public void setScreenSize(int paramInt1, int paramInt2)
  {
    this.screenHight = paramInt1;
    this.screenWidth = paramInt2;
  }
  
  public void setSendTitle(MailContact paramMailContact)
  {
    if (paramMailContact == null) {
      return;
    }
    this.mSender.setOtherInfo(paramMailContact);
    this.mSender.setTitle(paramMailContact.getAddress());
    this.ccAndBcc.getPrefixTV().setText(getContext().getString(2131691906) + " " + paramMailContact.getAddress());
  }
  
  public void setSendType(ComposeCommUI.QMSendType paramQMSendType)
  {
    this.sendType = paramQMSendType;
    layoutForSendType(paramQMSendType);
  }
  
  public void setSubject(QMTextField paramQMTextField)
  {
    this.subject = paramQMTextField;
  }
  
  public void setSubjectText(String paramString)
  {
    this.subject.setText(paramString);
  }
  
  public void setmSender(QQMailUILabel paramQQMailUILabel)
  {
    this.mSender = paramQQMailUILabel;
  }
  
  public void showCCAndBcc()
  {
    this.ccAndBcc.setVisibility(8);
    this.CC.setVisibility(0);
    this.CC.adjustMailAddrsViewControl();
    this.Bcc.setVisibility(0);
    this.Bcc.adjustMailAddrsViewControl();
    this.mSender.setVisibility(0);
  }
  
  public void showForWardHintLabel()
  {
    this.hintTV.setVisibility(0);
    this.hintTV.setText("邮件转发后会自动带上原文");
  }
  
  public void showReplyHintLabel()
  {
    this.hintTV.setVisibility(0);
    this.hintTV.setText("邮件回复后会自动带上原文");
  }
  
  public void unRegisterListener()
  {
    if (this.receiver != null) {
      this.receiver.unRegisterListener();
    }
    if (this.CC != null) {
      this.CC.unRegisterListener();
    }
    if (this.Bcc != null) {
      this.Bcc.unRegisterListener();
    }
  }
  
  public void updateContactArray(List<MailContact> paramList1, List<MailContact> paramList2)
  {
    int i = 0;
    MailAddrsViewControl.MailAddressAdapter localMailAddressAdapter = this.receiver.getAddrsViewControl().getAdapter();
    if (localMailAddressAdapter != null)
    {
      localMailAddressAdapter.updateLocalContacts(paramList1);
      localMailAddressAdapter.updateRemoteContacts(paramList2);
      localMailAddressAdapter.refreshData();
      paramList1 = new AutoCompleteTextView[3];
      paramList1[0] = this.receiver.getAddrsViewControl().getInputATV();
      paramList1[1] = this.CC.getAddrsViewControl().getInputATV();
      paramList1[2] = this.Bcc.getAddrsViewControl().getInputATV();
      int j = paramList1.length;
      while (i < j)
      {
        paramList2 = paramList1[i];
        if (paramList2 != null) {
          QMUIHelper.triggerFilteringForAutoCompleteTextView(paramList2);
        }
        i += 1;
      }
    }
    paramList1 = new MailAddrsViewControl.MailAddressAdapter(getContext(), paramList1, paramList2);
    this.receiver.getAddrsViewControl().setAddrsAdapter(paramList1);
    this.CC.getAddrsViewControl().setAddrsAdapter(paramList1);
    this.Bcc.getAddrsViewControl().setAddrsAdapter(paramList1);
  }
  
  public static abstract interface QMComposeHeaderCallback
  {
    public abstract void OnClickReceiverTextView();
    
    public abstract void addrViewScrollChanged(QMComposeHeader paramQMComposeHeader, ComposeAddrView paramComposeAddrView);
    
    public abstract void addrViewTextChanged(QMComposeHeader paramQMComposeHeader, ComposeAddrView paramComposeAddrView, String paramString);
    
    public abstract void clickedAddContactButton(QMComposeHeader paramQMComposeHeader, ComposeAddrView paramComposeAddrView);
    
    public abstract void clickedAddGroupContactButton(QMComposeHeader paramQMComposeHeader, ComposeAddrView paramComposeAddrView);
    
    public abstract void enterForClearFocus(QMComposeHeader paramQMComposeHeader, View paramView, boolean paramBoolean);
    
    public abstract void handleSenderButton(QMComposeHeader paramQMComposeHeader);
    
    public abstract void onClickChange(QMComposeHeader paramQMComposeHeader, View paramView);
    
    public abstract void onFocusChange(QMComposeHeader paramQMComposeHeader, View paramView, boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.QMComposeHeader
 * JD-Core Version:    0.7.0.1
 */