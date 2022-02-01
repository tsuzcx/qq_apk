package com.tencent.qqmail.view;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.model.qmdomain.MailInformation;
import com.tencent.qqmail.model.uidomain.MailUI;

public class ReadMailTitle
  extends FrameLayout
{
  private TextView subjectView;
  
  public ReadMailTitle(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    addView(LayoutInflater.from(paramContext).inflate(2131562943, null));
    initWidget();
  }
  
  private void initWidget()
  {
    this.subjectView = ((TextView)findViewById(2131361813));
  }
  
  public void render(MailUI paramMailUI)
  {
    if (paramMailUI == null) {
      return;
    }
    if ((paramMailUI.getInformation() != null) && (paramMailUI.getInformation().getSubject() != null) && (!paramMailUI.getInformation().getSubject().equals(""))) {
      this.subjectView.setText(paramMailUI.getInformation().getSubject().trim().replaceAll("\n", ""));
    }
    for (;;)
    {
      this.subjectView.setOnLongClickListener(new ReadMailTitle.1(this));
      return;
      this.subjectView.setText(QMApplicationContext.sharedInstance().getResources().getString(2131693126));
    }
  }
  
  public void setSelected(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 2131166571;; i = 2131167595)
    {
      this.subjectView.setBackgroundColor(getResources().getColor(i));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.view.ReadMailTitle
 * JD-Core Version:    0.7.0.1
 */