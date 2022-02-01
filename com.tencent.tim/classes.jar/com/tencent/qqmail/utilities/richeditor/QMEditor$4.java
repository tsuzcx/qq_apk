package com.tencent.qqmail.utilities.richeditor;

import android.text.Spanned;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.LinearLayout;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QMEditor$4
  implements View.OnClickListener
{
  QMEditor$4(QMEditor paramQMEditor) {}
  
  public void onClick(View paramView)
  {
    Spanned localSpanned = new HtmlToSpannedConverter(QMEditor.access$000(this.this$0)).looseConvert();
    QMEditor.access$100(this.this$0).append("\n\n---原始1邮件---\n");
    QMEditor.access$200(this.this$0);
    QMEditor.access$100(this.this$0).append("\n\n");
    QMEditor.access$100(this.this$0).append(localSpanned);
    this.this$0.loadImage(QMEditor.access$100(this.this$0));
    QMEditor.access$300(this.this$0).setVisibility(4);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.richeditor.QMEditor.4
 * JD-Core Version:    0.7.0.1
 */