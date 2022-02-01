package com.tencent.qqmail.model;

import com.tencent.qqmail.model.qmdomain.Mail;
import com.tencent.qqmail.utilities.stringextention.StringExtention;

public class MailListOption
{
  public static final int CONST_PAGESIZE = 5;
  public int accountId;
  public int count;
  public Mail cursor;
  public String flag;
  public String folderId;
  public boolean isAll;
  public boolean isGroupOrConv;
  public boolean isPreread;
  public boolean max;
  public boolean noIncrement;
  public String search;
  public int searchType = 7;
  public String tagId;
  
  public MailListOption() {}
  
  public MailListOption(String paramString)
  {
    String[] arrayOfString;
    if (paramString != "")
    {
      arrayOfString = paramString.split("_", -1);
      if (arrayOfString.length <= 2) {
        break label122;
      }
      this.accountId = Integer.parseInt(arrayOfString[0]);
      if (!arrayOfString[1].equals("zzsearch")) {
        break label114;
      }
      this.search = searchContentDecode(arrayOfString[2]);
      paramString = StringExtention.indexDecode(arrayOfString[3]).split("_");
      if (paramString.length == 2) {
        this.folderId = paramString[1];
      }
      if (paramString.length == 4) {
        _setFilter(paramString);
      }
    }
    for (;;)
    {
      this.count = 5;
      this.max = true;
      this.noIncrement = false;
      return;
      label114:
      _setFilter(arrayOfString);
      continue;
      label122:
      this.isGroupOrConv = true;
      this.folderId = paramString;
    }
  }
  
  private void _setFilter(String[] paramArrayOfString)
  {
    this.accountId = Integer.parseInt(paramArrayOfString[0]);
    this.folderId = paramArrayOfString[1];
    this.flag = paramArrayOfString[2];
    this.tagId = paramArrayOfString[3];
  }
  
  public static MailListOption optionWithIndex(String paramString)
  {
    return new MailListOption(paramString);
  }
  
  private String searchContentDecode(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    return new String(paramString).replaceAll("%5F", "_").replaceAll("%25", "%");
  }
  
  public String getIndex()
  {
    if (this.isGroupOrConv)
    {
      localObject1 = this.folderId;
      return localObject1;
    }
    Object localObject2 = new StringBuilder().append(this.folderId).append("_");
    if (this.flag == null)
    {
      localObject1 = "";
      label44:
      localObject2 = ((StringBuilder)localObject2).append((String)localObject1).append("_");
      if (this.tagId != null) {
        break label132;
      }
    }
    label132:
    for (Object localObject1 = "";; localObject1 = this.tagId)
    {
      localObject2 = (String)localObject1;
      localObject1 = localObject2;
      if (this.search == null) {
        break;
      }
      return "search_" + this.search + "_" + StringExtention.replaceAllWithSeparator((String)localObject2, "_", "", "%5F");
      localObject1 = this.flag;
      break label44;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.MailListOption
 * JD-Core Version:    0.7.0.1
 */