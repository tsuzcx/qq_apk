package com.tencent.qqmail.utilities.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageButton;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QMSearchBar$2
  implements View.OnClickListener
{
  QMSearchBar$2(QMSearchBar paramQMSearchBar) {}
  
  public void onClick(View paramView)
  {
    this.this$0.searchInput.setText("");
    this.this$0.searchInputCleaner.setVisibility(8);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.ui.QMSearchBar.2
 * JD-Core Version:    0.7.0.1
 */