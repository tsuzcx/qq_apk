package com.tencent.qqmail.activity.compose;

import android.view.View;
import android.webkit.WebView;
import android.widget.EditText;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.activity.compose.richeditor.QMUIRichEditor.UpdateInnerHtmlCallback;
import com.tencent.qqmail.model.qmdomain.MailContact;
import com.tencent.qqmail.model.qmdomain.MailGroupContact;
import java.util.ArrayList;
import java.util.List;

public abstract interface ComposeMailView
{
  public abstract void aaddAttachImgAtBegenning(String paramString1, String paramString2);
  
  public abstract void addAttachImg(String paramString1, String paramString2);
  
  public abstract void addAttachImg(String paramString1, String paramString2, int paramInt);
  
  public abstract int adjustAutoCompleteCursor(ComposeAddrView paramComposeAddrView);
  
  public abstract void autoScrollHeader(View paramView, int paramInt);
  
  public abstract void autoScrollToTop();
  
  public abstract void autoSrollContent(int paramInt);
  
  public abstract void bindOnLongClickListener(ComposeMailActivity.LongClickListener paramLongClickListener);
  
  public abstract void bindOnMoveListener(ComposeMailActivity.OnMoveListener paramOnMoveListener);
  
  public abstract void blurEditerFocus();
  
  public abstract void changeDefaultSenderAccount(Account paramAccount);
  
  public abstract void changeEditOriginContentMode(String paramString);
  
  public abstract void focusAtEditor();
  
  public abstract ArrayList<Object> getBccContactList();
  
  public abstract ArrayList<Object> getCCContactList();
  
  public abstract EditText getContentET();
  
  public abstract String getContentText(boolean paramBoolean);
  
  public abstract void getContentTextSynchronously(QMUIRichEditor.UpdateInnerHtmlCallback paramUpdateInnerHtmlCallback);
  
  public abstract View getFirstFocusView();
  
  public abstract QMComposeHeader getHeader();
  
  public abstract int getOriViewHeight();
  
  public abstract String getOriginContent();
  
  public abstract String getSignTemplate();
  
  public abstract ArrayList<Object> getToContactList();
  
  public abstract int getVKBHeight();
  
  public abstract WebView getWebView();
  
  public abstract void hideContentLoading();
  
  public abstract void hideformatToolbar(boolean paramBoolean);
  
  public abstract void initView(ComposeCommUI.QMSendType paramQMSendType);
  
  public abstract boolean isKBShown();
  
  public abstract void layoutComposeCardMail();
  
  public abstract void layoutComposeFeedBack();
  
  public abstract void layoutComposeGroupMail();
  
  public abstract void layoutComposeMail(ComposeCommUI.QMSendType paramQMSendType);
  
  public abstract void release();
  
  public abstract void replaceInlineImageSrc(String paramString1, String paramString2);
  
  public abstract void scrollAutoComplete(ComposeAddrView paramComposeAddrView, int paramInt);
  
  public abstract void scrollClickChange(View paramView, boolean paramBoolean);
  
  public abstract void scrollToTop();
  
  public abstract void setAttachBoardShow(boolean paramBoolean);
  
  public abstract void setCallback(ComposeViewCallback paramComposeViewCallback);
  
  public abstract void setContentText(String paramString, boolean paramBoolean);
  
  public abstract void setDefaultSenderAccount(Account paramAccount);
  
  public abstract void setGroupToTitle(MailGroupContact paramMailGroupContact);
  
  public abstract void setImgSrcAccountId(String paramString, int paramInt);
  
  public abstract void setOriginCardContent(String paramString);
  
  public abstract void setOriginContent(String paramString, float paramFloat1, float paramFloat2);
  
  public abstract void setOriginContentFromPopularize(String paramString);
  
  public abstract void setOriginContentWithQuickReply(String paramString1, String paramString2);
  
  public abstract void setScrollable(boolean paramBoolean);
  
  public abstract void setSendTitle(MailContact paramMailContact);
  
  public abstract void setSendType(ComposeCommUI.QMSendType paramQMSendType);
  
  public abstract void showContentLoading();
  
  public abstract void showContentLoadingError();
  
  public abstract void showformatToolbar(boolean paramBoolean);
  
  public abstract void updateContactArray(List<MailContact> paramList1, List<MailContact> paramList2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.ComposeMailView
 * JD-Core Version:    0.7.0.1
 */