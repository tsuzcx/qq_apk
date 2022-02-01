package com.tencent.qqmail.view;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.qqmail.model.qmdomain.MailStatus;
import com.tencent.qqmail.model.uidomain.MailUI;

public class ReadMailDetailView
  extends FrameLayout
{
  private ReadMailDetailInformationView detailInformationView;
  private LinearLayout detailStatusView;
  private boolean isInit = false;
  private boolean isShowDetail;
  private TextView showDetailButton;
  private View.OnClickListener showDetailOnClickListener;
  private View starView;
  private ViewGroup summaryView;
  private View toppedView;
  private View unreadView;
  
  public ReadMailDetailView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ReadMailDetailView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ReadMailDetailView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void destroy()
  {
    if (this.detailInformationView != null)
    {
      this.detailInformationView.setMailContactClickListener(null);
      this.detailInformationView.setMailGroupContactClickListener(null);
      this.detailInformationView.setShowAttachOnClickListener(null);
      this.detailInformationView = null;
    }
    if (this.showDetailButton != null) {
      this.showDetailButton.setOnClickListener(null);
    }
    this.isInit = false;
  }
  
  public void hideDetailButton()
  {
    if (this.showDetailButton != null) {
      this.showDetailButton.setVisibility(4);
    }
  }
  
  public void initDoms()
  {
    this.detailInformationView = ((ReadMailDetailInformationView)findViewById(2131376657));
    this.showDetailButton = ((TextView)findViewById(2131378295));
    this.toppedView = findViewById(2131379868);
    this.starView = findViewById(2131379853);
    this.unreadView = findViewById(2131379872);
    this.detailStatusView = ((LinearLayout)findViewById(2131365788));
    this.summaryView = ((ViewGroup)this.detailInformationView.findViewById(2131376806));
    this.isInit = true;
  }
  
  public boolean isShowDetail()
  {
    return this.isShowDetail;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (!this.isInit) {
      initDoms();
    }
  }
  
  public void render(MailUI paramMailUI, boolean paramBoolean)
  {
    if (paramMailUI == null) {
      return;
    }
    if (!this.isInit) {
      initDoms();
    }
    this.isShowDetail = paramBoolean;
    if (paramMailUI.getStatus() != null)
    {
      this.showDetailButton.setVisibility(0);
      if (paramBoolean)
      {
        this.showDetailButton.setText(getResources().getString(2131718583));
        this.detailInformationView.render(paramMailUI, paramBoolean);
        if (paramMailUI.getStatus() == null) {
          break label212;
        }
        if (!paramMailUI.getStatus().isStarred()) {
          break label176;
        }
        this.starView.setVisibility(0);
        label90:
        if (!paramMailUI.getStatus().isUnread()) {
          break label188;
        }
        this.unreadView.setVisibility(0);
        label108:
        if (!paramMailUI.getStatus().isTopped()) {
          break label200;
        }
        this.toppedView.setVisibility(0);
      }
    }
    for (;;)
    {
      this.summaryView.getViewTreeObserver().addOnGlobalLayoutListener(new ReadMailDetailView.1(this));
      return;
      this.showDetailButton.setText(getResources().getString(2131718584));
      break;
      this.showDetailButton.setVisibility(8);
      break;
      label176:
      this.starView.setVisibility(8);
      break label90;
      label188:
      this.unreadView.setVisibility(8);
      break label108;
      label200:
      this.toppedView.setVisibility(8);
      continue;
      label212:
      this.starView.setVisibility(8);
      this.unreadView.setVisibility(8);
      this.toppedView.setVisibility(8);
    }
  }
  
  public void setFromFolderType(int paramInt)
  {
    if (this.detailInformationView != null) {
      this.detailInformationView.setFromFolderType(paramInt);
    }
  }
  
  public void setMailContactClickListener(ReadMailDetailInformationView.MailContactClickListener paramMailContactClickListener)
  {
    if (this.detailInformationView != null) {
      this.detailInformationView.setMailContactClickListener(paramMailContactClickListener);
    }
  }
  
  public void setMailGroupContactClickListener(ReadMailDetailInformationView.MailGroupContactClickListener paramMailGroupContactClickListener)
  {
    if (this.detailInformationView != null) {
      this.detailInformationView.setMailGroupContactClickListener(paramMailGroupContactClickListener);
    }
  }
  
  public void setShowAttachOnClickListener(View.OnClickListener paramOnClickListener)
  {
    if (this.detailInformationView != null) {
      this.detailInformationView.setShowAttachOnClickListener(paramOnClickListener);
    }
  }
  
  public void setShowDetail(boolean paramBoolean)
  {
    this.isShowDetail = paramBoolean;
  }
  
  public void setShowDetailOnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.showDetailOnClickListener = paramOnClickListener;
    if (this.showDetailButton != null) {
      this.showDetailButton.setOnClickListener(this.showDetailOnClickListener);
    }
  }
  
  public void showDetailButton()
  {
    if (this.showDetailButton != null) {
      this.showDetailButton.setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.view.ReadMailDetailView
 * JD-Core Version:    0.7.0.1
 */