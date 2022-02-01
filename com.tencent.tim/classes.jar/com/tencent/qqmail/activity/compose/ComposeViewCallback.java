package com.tencent.qqmail.activity.compose;

import android.view.View;
import android.widget.EditText;
import com.tencent.qqmail.utilities.richeditor.QMAudioSpan;

public abstract interface ComposeViewCallback
{
  public abstract void OnClickReceiverTextView();
  
  public abstract void OnWebViewClick();
  
  public abstract void OnWebViewDoubleClick();
  
  public abstract void addrViewScrollChanged(ComposeMailView paramComposeMailView, QMComposeHeader paramQMComposeHeader, ComposeAddrView paramComposeAddrView);
  
  public abstract void addrViewTextChanged(ComposeMailView paramComposeMailView, QMComposeHeader paramQMComposeHeader, ComposeAddrView paramComposeAddrView, String paramString);
  
  public abstract void clickAddContactButton(ComposeMailView paramComposeMailView, QMComposeHeader paramQMComposeHeader, ComposeAddrView paramComposeAddrView);
  
  public abstract void clickedAddGroupContactButton(ComposeMailView paramComposeMailView, QMComposeHeader paramQMComposeHeader, ComposeAddrView paramComposeAddrView);
  
  public abstract void contentTextDidChange(ComposeMailView paramComposeMailView, EditText paramEditText);
  
  public abstract void handleSenderButton(ComposeMailView paramComposeMailView, QMComposeHeader paramQMComposeHeader);
  
  public abstract void onClickAttach(ComposeMailView paramComposeMailView, QMComposeAttachItem paramQMComposeAttachItem);
  
  public abstract void onClickAudioSpan(QMAudioSpan paramQMAudioSpan);
  
  public abstract void onClickChange(ComposeMailView paramComposeMailView, QMComposeHeader paramQMComposeHeader, View paramView, boolean paramBoolean);
  
  public abstract void onEditorClick();
  
  public abstract void onFocusChange(ComposeMailView paramComposeMailView, QMComposeHeader paramQMComposeHeader, View paramView, boolean paramBoolean);
  
  public abstract void onFormatToobarChange(boolean paramBoolean);
  
  public abstract void sizeDidChange(View paramView, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.ComposeViewCallback
 * JD-Core Version:    0.7.0.1
 */