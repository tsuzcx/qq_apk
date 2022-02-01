package com.tencent.qqmail.movenote;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AddNoteCatalogActivity$3
  implements View.OnClickListener
{
  AddNoteCatalogActivity$3(AddNoteCatalogActivity paramAddNoteCatalogActivity) {}
  
  public void onClick(View paramView)
  {
    this.this$0.finish();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.movenote.AddNoteCatalogActivity.3
 * JD-Core Version:    0.7.0.1
 */