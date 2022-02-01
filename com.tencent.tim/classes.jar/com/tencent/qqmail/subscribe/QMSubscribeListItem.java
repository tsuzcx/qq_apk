package com.tencent.qqmail.subscribe;

import com.tencent.qqmail.model.mail.cursor.QMSubscribeColumnCursor.Util;
import com.tencent.qqmail.model.qmdomain.SubscribeMail;
import com.tencent.qqmail.utilities.dateextension.DateExtension;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

public class QMSubscribeListItem
{
  private String email;
  private long id;
  private ArrayList<SubscribeMailUI> mArticleList;
  private Date mDate;
  private String mSender;
  
  public ArrayList<SubscribeMailUI> getArticleList()
  {
    return this.mArticleList;
  }
  
  public Date getDate()
  {
    return this.mDate;
  }
  
  public String getDateString()
  {
    return DateExtension.shortDateName(this.mDate);
  }
  
  public String getEmail()
  {
    return this.email;
  }
  
  public long getId()
  {
    return this.id;
  }
  
  public String getSender()
  {
    return this.mSender;
  }
  
  public void setArticleList(ArrayList<SubscribeMailUI> paramArrayList)
  {
    this.mArticleList = paramArrayList;
  }
  
  public void setDate(Date paramDate)
  {
    this.mDate = paramDate;
  }
  
  public void setEmail(String paramString)
  {
    this.email = paramString;
  }
  
  public void setId(long paramLong)
  {
    this.id = paramLong;
  }
  
  public void setSender(String paramString)
  {
    this.mSender = paramString;
  }
  
  public boolean useSnapShot()
  {
    int j;
    if ((this.mArticleList != null) && (this.mArticleList.size() > 0))
    {
      Iterator localIterator = this.mArticleList.iterator();
      int i = 0;
      j = i;
      if (!localIterator.hasNext()) {
        break label99;
      }
      SubscribeMailUI localSubscribeMailUI = (SubscribeMailUI)localIterator.next();
      if (QMSubscribeColumnCursor.Util.isSnapUrl(localSubscribeMailUI.getSubscribe().getBigIcon())) {
        label63:
        return true;
      }
      if ((localSubscribeMailUI.getSubscribe().getBigIcon() == null) || (localSubscribeMailUI.getSubscribe().getBigIcon().equals(""))) {
        break label105;
      }
      i = 1;
    }
    label99:
    label105:
    for (;;)
    {
      break;
      j = 0;
      if (j == 0) {
        break label63;
      }
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.subscribe.QMSubscribeListItem
 * JD-Core Version:    0.7.0.1
 */