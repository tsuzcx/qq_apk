package com.tencent.qqmail.calendar.fragment;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.qqmail.calendar.util.QMCalendarUtil;
import com.tencent.qqmail.fragment.base.QMBaseFragment.ViewHolder;
import com.tencent.qqmail.utilities.uitableview.UITableItemFactory;
import com.tencent.qqmail.view.QMBaseView;
import com.tencent.qqmail.view.QMTopBar;

public class ReadEventBodyFragment
  extends CalendarBaseFragment
{
  private String bodyText;
  private QMBaseView mBaseView;
  
  public ReadEventBodyFragment()
  {
    super(true);
  }
  
  private void initTopBar()
  {
    QMTopBar localQMTopBar = new QMTopBar(getActivity());
    this.mBaseView.addView(localQMTopBar);
    localQMTopBar.setTitle(getResources().getString(2131694728));
    localQMTopBar.setButtonLeftBack();
    localQMTopBar.setButtonLeftOnclickListener(new ReadEventBodyFragment.1(this));
  }
  
  public void initDataSource() {}
  
  public void initDom(View paramView, QMBaseFragment.ViewHolder paramViewHolder, Bundle paramBundle)
  {
    initTopBar();
    paramView = UITableItemFactory.addBodyTextView(getActivity());
    paramViewHolder = QMCalendarUtil.getValidateBodyText(this.bodyText);
    if (paramViewHolder != null) {
      paramView.setText(paramViewHolder);
    }
    paramView.setBackgroundColor(getResources().getColor(2131167654));
    this.mBaseView.addContentView(paramView);
  }
  
  protected QMBaseView initUI(QMBaseFragment.ViewHolder paramViewHolder)
  {
    this.mBaseView = new QMBaseView(getActivity());
    this.mBaseView.initScrollView();
    this.mBaseView.getRootScrollView().setBackgroundColor(getResources().getColor(2131167681));
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
 * Qualified Name:     com.tencent.qqmail.calendar.fragment.ReadEventBodyFragment
 * JD-Core Version:    0.7.0.1
 */