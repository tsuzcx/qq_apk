package com.tencent.qqmail.inquirymail.cursor;

import com.tencent.qqmail.inquirymail.model.InquiryMail;
import com.tencent.qqmail.model.mail.callback.QMRefreshCallback;

public abstract interface IInquiryMailListCursor
{
  public abstract boolean canLoadMore();
  
  public abstract void close();
  
  public abstract int getCount();
  
  public abstract InquiryMail getItem(int paramInt);
  
  public abstract long getItemId(int paramInt);
  
  public abstract int getState();
  
  public abstract void loadMore();
  
  public abstract void refresh(QMRefreshCallback paramQMRefreshCallback);
  
  public abstract void refresh(boolean paramBoolean, QMRefreshCallback paramQMRefreshCallback);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.inquirymail.cursor.IInquiryMailListCursor
 * JD-Core Version:    0.7.0.1
 */