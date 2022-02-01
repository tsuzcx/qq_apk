package com.tencent.qqmail.model.readmail;

import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.attachment.model.Attach;
import com.tencent.qqmail.attachment.model.AttachProtocol;
import com.tencent.qqmail.model.qmdomain.MailBigAttach;
import com.tencent.qqmail.model.qmdomain.MailInformation;
import com.tencent.qqmail.model.uidomain.MailUI;
import com.tencent.qqmail.utilities.stringextention.StringExtention;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

public class BigAttachHelper
{
  public static final long ATTACH_SIZE_IS_FIVE_HUNDRED_MEGABYTE = 524288000L;
  public static final long ATTACH_SIZE_IS_ONE_GIGABYTE = 1073741824L;
  public static final long ATTACH_SIZE_IS_TEN_MEGABYTE = 10485760L;
  public static final String TAG = "BigAttachHelper";
  
  public static boolean attachSizeExcceedTen(Attach paramAttach)
  {
    return StringExtention.sizeStrToLong(paramAttach.getSize()) > 10485760L;
  }
  
  public static boolean attachSizeExcceedTen(MailUI paramMailUI)
  {
    boolean bool2 = false;
    paramMailUI = paramMailUI.getInformation().getAttachList();
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < paramMailUI.size())
      {
        if (attachSizeExcceedTen((Attach)paramMailUI.get(i))) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public static boolean attachSizeOverOnlinePreview(Attach paramAttach)
  {
    return StringExtention.sizeStrToLong(paramAttach.getSize()) > 524288000L;
  }
  
  public static ArrayList<Object> filterExpireBigAttaches(ArrayList<Object> paramArrayList)
  {
    Date localDate = new Date();
    ArrayList localArrayList = new ArrayList();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      Object localObject = paramArrayList.next();
      if (!isBigAttachExpire((MailBigAttach)localObject, localDate)) {
        localArrayList.add(localObject);
      }
    }
    return localArrayList;
  }
  
  public static ArrayList<Object> getExpireBigAttaches(MailUI paramMailUI)
  {
    Object localObject1 = new ArrayList();
    ((ArrayList)localObject1).addAll(paramMailUI.getInformation().getBigAttachList());
    paramMailUI = new Date();
    ArrayList localArrayList = new ArrayList();
    localObject1 = ((ArrayList)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      if (isBigAttachExpire((MailBigAttach)localObject2, paramMailUI)) {
        localArrayList.add(localObject2);
      }
    }
    return localArrayList;
  }
  
  public static boolean hasBigAttach(MailUI paramMailUI)
  {
    return (paramMailUI.getInformation().getBigAttachList() != null) && (paramMailUI.getInformation().getBigAttachList().size() > 0);
  }
  
  public static boolean isAllAttachReady(MailUI paramMailUI)
  {
    paramMailUI = paramMailUI.getInformation().getAttachListNoInlineImg();
    if ((paramMailUI != null) && (paramMailUI.size() > 0))
    {
      int i = 0;
      while (i < paramMailUI.size())
      {
        Attach localAttach = (Attach)paramMailUI.get(i);
        if ((!localAttach.isExist()) && (localAttach.getProtocol() != null) && (!localAttach.getProtocol().getType().equals("inline"))) {
          return false;
        }
        i += 1;
      }
      return true;
    }
    return true;
  }
  
  public static boolean isBigAttachExpire(MailBigAttach paramMailBigAttach, Date paramDate)
  {
    Date localDate = paramMailBigAttach.getExpire();
    if (paramMailBigAttach.isBizNetDiskAttach()) {}
    while ((localDate != null) && (localDate.getTime() != -2L) && (localDate.getTime() - paramDate.getTime() > 0L)) {
      return false;
    }
    return true;
  }
  
  public static boolean isBigAttachesExpire(MailUI paramMailUI)
  {
    return (hasBigAttach(paramMailUI)) && (isBigAttachesExpire(paramMailUI.getInformation().getBigAttachList()));
  }
  
  public static boolean isBigAttachesExpire(ArrayList<Object> paramArrayList)
  {
    Date localDate = new Date();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext()) {
      if (isBigAttachExpire((MailBigAttach)paramArrayList.next(), localDate)) {
        return true;
      }
    }
    return false;
  }
  
  public static boolean isTencentAccount(MailUI paramMailUI)
  {
    return AccountManager.shareInstance().getAccountList().getAccountById(paramMailUI.getInformation().getAccountId()).getEmail().contains("@tencent.com");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.readmail.BigAttachHelper
 * JD-Core Version:    0.7.0.1
 */