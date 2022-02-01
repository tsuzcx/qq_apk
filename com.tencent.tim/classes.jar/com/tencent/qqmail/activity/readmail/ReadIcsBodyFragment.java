package com.tencent.qqmail.activity.readmail;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import com.tencent.qqmail.calendar.util.QMCalendarUtil;
import com.tencent.qqmail.fragment.base.MailFragment;
import com.tencent.qqmail.fragment.base.QMBaseFragment.ViewHolder;
import com.tencent.qqmail.utilities.uitableview.UITableItemFactory;
import com.tencent.qqmail.view.QMBaseView;
import com.tencent.qqmail.view.QMTopBar;

public class ReadIcsBodyFragment
  extends MailFragment
{
  private String bodyText;
  private TextView bodyTextView;
  private QMBaseView mBaseView;
  
  public ReadIcsBodyFragment()
  {
    super(true);
  }
  
  private void initTopBar()
  {
    QMTopBar localQMTopBar = getTopBar();
    localQMTopBar.setTitle(2131694728);
    localQMTopBar.setButtonLeftBack();
  }
  
  public void initDataSource()
  {
    initTopBar();
    this.bodyTextView = UITableItemFactory.addBodyTextView(getActivity());
    this.mBaseView.addContentView(this.bodyTextView);
  }
  
  public void initDom(View paramView, QMBaseFragment.ViewHolder paramViewHolder, Bundle paramBundle)
  {
    initTopBar();
    paramView = QMCalendarUtil.getValidateBodyText(this.bodyText);
    if (paramView != null) {
      this.bodyTextView.setText(paramView);
    }
  }
  
  public QMBaseView initUI(QMBaseFragment.ViewHolder paramViewHolder)
  {
    this.mBaseView = new QMBaseView(getActivity());
    this.mBaseView.initScrollView();
    this.mBaseView.setBackgroundColor(getResources().getColor(2131167681));
    return this.mBaseView;
  }
  
  public void onBindEvent(boolean paramBoolean) {}
  
  public boolean onDragBack(MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  public void onRelease() {}
  
  public void prepareBodyText(String paramString)
  {
    this.bodyText = paramString;
  }
  
  public int refreshData()
  {
    return 0;
  }
  
  public void render(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.readmail.ReadIcsBodyFragment
 * JD-Core Version:    0.7.0.1
 */