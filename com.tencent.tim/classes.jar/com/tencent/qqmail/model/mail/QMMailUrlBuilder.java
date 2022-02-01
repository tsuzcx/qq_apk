package com.tencent.qqmail.model.mail;

import android.util.Log;
import androidx.annotation.Nullable;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.model.MailAttribute;
import com.tencent.qqmail.model.MailAttributeTag;
import com.tencent.qqmail.model.MailEncode;
import com.tencent.qqmail.model.MailManagerDefines;
import com.tencent.qqmail.model.mail.cursor.IMailListCursor;
import com.tencent.qqmail.model.qmdomain.Mail;
import com.tencent.qqmail.model.qmdomain.MailInformation;
import com.tencent.qqmail.model.qmdomain.MailStatus;
import com.tencent.qqmail.model.qmdomain.MailTag;
import com.tencent.qqmail.model.qmdomain.QMFolder;
import com.tencent.qqmail.utilities.stringextention.StringExtention;
import java.util.ArrayList;
import java.util.Date;

class QMMailUrlBuilder
{
  private static final String TAG = "QMMailUrlBuilder";
  
  private static void checkCursorUtcOrder(IMailListCursor paramIMailListCursor) {}
  
  static void createAllListUrl(StringBuilder paramStringBuilder1, StringBuilder paramStringBuilder2, int paramInt)
  {
    if (AccountManager.shareInstance().getAccountList().isAccountLocked(paramInt)) {}
    for (String str = "1";; str = "0")
    {
      paramStringBuilder1.append("mail_list");
      paramStringBuilder2.append(MailManagerDefines.PARAM_MAIL_LIST_PREFIX_DATA).append("&s=list").append("&folderid=1&folderid=3&folderid=8&folderid=9&folderid=user&folderid=pop&pagesize=200&folderlock=").append(str);
      return;
    }
  }
  
  static void createListUrl(StringBuilder paramStringBuilder1, StringBuilder paramStringBuilder2, QMFolder paramQMFolder)
  {
    paramStringBuilder1.append("mail_list");
    paramStringBuilder2.append(MailManagerDefines.PARAM_MAIL_LIST_PREFIX_DATA).append("&s=list");
    paramStringBuilder1 = new StringBuilder();
    Object localObject = new StringBuilder();
    StringBuilder localStringBuilder = new StringBuilder();
    switch (paramQMFolder.getType())
    {
    case 15: 
    default: 
      paramStringBuilder1.append(paramQMFolder.getRemoteId());
      localObject = StringExtention.replaceWithEncodeURIValue(StringExtention.replaceWithEncodeURIValue(StringExtention.replaceWithEncodeURIValue("&folderid=$fid$&flag=$flag$&tagid=$tag$&folderlock=$lock$", "fid", paramStringBuilder1.toString()), "flag", ((StringBuilder)localObject).toString()), "tag", localStringBuilder.toString());
      if (!AccountManager.shareInstance().getAccountList().isAccountLocked(paramQMFolder.getAccountId())) {
        break;
      }
    }
    for (paramStringBuilder1 = "1";; paramStringBuilder1 = "0")
    {
      paramStringBuilder2.append(StringExtention.replaceWithEncodeURIValue((String)localObject, "lock", paramStringBuilder1));
      return;
      paramStringBuilder1.append("all");
      ((StringBuilder)localObject).append("tag");
      localStringBuilder.append(paramQMFolder.getRemoteId());
      break;
      paramStringBuilder1.append("all");
      ((StringBuilder)localObject).append("star");
      break;
      paramStringBuilder1.append("addrvip");
      ((StringBuilder)localObject).append("addrvip");
      break;
      paramStringBuilder2.append("&flag=new&idx=unreadlist&folderid=1&folderid=3&folderid=8&folderid=9&folderid=subscribe&folderid=pop&folderid=personal");
      return;
    }
  }
  
  static void createSyncPopUrl(StringBuilder paramStringBuilder1, StringBuilder paramStringBuilder2, QMFolder paramQMFolder)
  {
    String str1 = "";
    if (paramQMFolder.getRemoteId() != null) {
      str1 = paramQMFolder.getRemoteId();
    }
    String str2 = "";
    if (paramQMFolder.getPopId() != null) {
      str2 = paramQMFolder.getPopId();
    }
    paramStringBuilder1.append("foldermgr");
    paramStringBuilder2.append("&t=pop_mgr.json&fun=recvpop&channel=1&folderid=$folderid$&acctid=$acctid$".replace("$folderid$", str1).replace("$acctid$", str2));
  }
  
  static void getCursorUrl(StringBuilder paramStringBuilder, Mail paramMail)
  {
    getCursorUrl(paramStringBuilder, paramMail, true);
  }
  
  static void getCursorUrl(StringBuilder paramStringBuilder, Mail paramMail, boolean paramBoolean)
  {
    String str;
    if (paramMail != null)
    {
      paramMail = paramMail.getInformation();
      str = paramMail.getRemoteId();
      paramMail = String.valueOf(paramMail.getDate().getTime() / 1000L);
    }
    for (;;)
    {
      getCursorUrl(paramStringBuilder, str, paramMail, paramBoolean);
      return;
      paramMail = "";
      str = "";
    }
  }
  
  static void getCursorUrl(StringBuilder paramStringBuilder, String paramString1, String paramString2, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (String str = "max";; str = "since")
    {
      paramStringBuilder.append(StringExtention.replaceWithEncodeURIValue(StringExtention.replaceWithEncodeURIValue(StringExtention.replaceWithEncodeURIValue("&cursor=$cur$&cursorutc=$utc$&cursorid=$id$&cursorcount=20", "cur", str), "id", paramString1), "utc", paramString2));
      return;
    }
  }
  
  private static byte[] getIncrementalBytes(IMailListCursor paramIMailListCursor, ArrayList<Object[]> paramArrayList)
  {
    checkCursorUtcOrder(paramIMailListCursor);
    int n = paramIMailListCursor.getCount();
    if (n > 0)
    {
      if (n <= 500) {
        break label750;
      }
      n = 500;
    }
    label526:
    label747:
    label750:
    for (;;)
    {
      byte[] arrayOfByte1 = new byte[8000];
      MailAttributeTag localMailAttributeTag = new MailAttributeTag(0, null);
      MailAttribute localMailAttribute = new MailAttribute(false, false, false, 0, localMailAttributeTag);
      byte[] arrayOfByte2 = new byte[4];
      int i = 0;
      int k = 0;
      int i1 = 0;
      Mail localMail;
      MailStatus localMailStatus;
      MailInformation localMailInformation;
      if (i1 < n)
      {
        localMail = paramIMailListCursor.getItem(i1);
        localMailStatus = localMail.getStatus();
        localMailInformation = localMail.getInformation();
        if ((localMailStatus == null) || (localMailInformation == null)) {
          break label747;
        }
        if (localMailInformation.getUtc() != null) {}
      }
      for (;;)
      {
        i1 += 1;
        break;
        paramArrayList.add(new Object[] { Long.valueOf(localMailInformation.getId()), localMailInformation.getRemoteId(), Boolean.valueOf(localMailStatus.isSubscribeMail()) });
        localMailAttribute.detail = localMail.isRead();
        localMailAttribute.unread = localMailStatus.isUnread();
        localMailAttribute.star = localMailStatus.isStarred();
        if (localMailStatus.isConversation()) {}
        for (int j = localMailInformation.getConvCount();; j = 0)
        {
          localMailAttribute.conv_count = j;
          if ((localMailInformation.getTagList() == null) || (localMailInformation.getTagList().size() <= 0)) {
            break;
          }
          localMailAttribute.tag.tag_ids = new int[localMailInformation.getTagList().size()];
          localMailAttribute.tag.tag_count = localMailAttribute.tag.tag_ids.length;
          j = 0;
          while (j < localMailAttribute.tag.tag_count)
          {
            localMailAttribute.tag.tag_ids[j] = Integer.parseInt(((MailTag)localMailInformation.getTagList().get(j)).getTagId());
            j += 1;
          }
        }
        localMailAttributeTag.tag_count = 0;
        localMailAttributeTag.tag_ids = null;
        j = (int)(localMailInformation.getUtc().getTime() * 0.001D);
        if (i1 == 0)
        {
          if (!MailEncode.TIM_OK(j)) {}
        }
        else
        {
          for (int i2 = write4ByteBuffer(k, j, arrayOfByte2, arrayOfByte1) + k;; i2 = write2ByteBuffer(k, m, arrayOfByte2, arrayOfByte1) + k)
          {
            m = 0;
            if (localMailAttribute.detail) {
              m = 1;
            }
            i = m;
            if (localMailAttribute.unread) {
              i = m | 0x2;
            }
            m = i;
            if (localMailAttribute.star) {
              m = i | 0x4;
            }
            i = m;
            if (localMailAttribute.tag.tag_count > 0) {
              i = m | 0x8;
            }
            m = i;
            if (localMailAttribute.conv_count > 0) {
              m = i | 0x10;
            }
            if (MailEncode.NUM_OK(m)) {
              break label526;
            }
            i = j;
            break;
            m = i - j;
            MailEncode.htonl(m, arrayOfByte2);
            if (!MailEncode.TIM_DIFF_OK(m)) {
              break;
            }
          }
          int m = writeBuffer(i2, m, arrayOfByte2, arrayOfByte1) + i2;
          i = m;
          if (localMailAttribute.tag.tag_count > 0)
          {
            if (!MailEncode.NUM_OK(localMailAttribute.tag.tag_count))
            {
              i = j;
              continue;
            }
            m += writeBuffer(m, localMailAttribute.tag.tag_count, arrayOfByte2, arrayOfByte1);
            i2 = 0;
            i = m;
            if (i2 < localMailAttribute.tag.tag_count)
            {
              if (!MailEncode.NUM_OK(localMailAttribute.tag.tag_ids[i2])) {
                m = k;
              }
              for (;;)
              {
                i2 += 1;
                break;
                m += writeBuffer(m, localMailAttribute.tag.tag_ids[i2], arrayOfByte2, arrayOfByte1);
              }
            }
          }
          if (localMailAttribute.conv_count > 0)
          {
            if (!MailEncode.NUM_OK(localMailAttribute.conv_count))
            {
              i = j;
            }
            else
            {
              k = i + writeBuffer(i, localMailAttribute.conv_count, arrayOfByte2, arrayOfByte1);
              i = j;
              continue;
              paramIMailListCursor = new byte[k];
              System.arraycopy(arrayOfByte1, 0, paramIMailListCursor, 0, k);
              return paramIMailListCursor;
              return null;
            }
          }
          else
          {
            k = i;
            i = j;
          }
        }
      }
    }
  }
  
  private static byte[] getIncrementalBytesTest(QMMailListCursor paramQMMailListCursor, ArrayList<Object[]> paramArrayList)
  {
    int i1 = paramQMMailListCursor.getCount();
    if (i1 > 0)
    {
      if (i1 <= 500) {
        break label1235;
      }
      i1 = 500;
    }
    label394:
    label413:
    label594:
    label1235:
    for (;;)
    {
      byte[] arrayOfByte1 = new byte[8000];
      MailAttributeTag localMailAttributeTag = new MailAttributeTag(0, null);
      MailAttribute localMailAttribute = new MailAttribute(false, false, false, 0, null);
      byte[] arrayOfByte2 = new byte[4];
      int i = 0;
      int k = 0;
      int i2 = 0;
      Object localObject;
      MailStatus localMailStatus;
      MailInformation localMailInformation;
      if (i2 < i1)
      {
        localObject = paramQMMailListCursor.getItem(i2);
        localMailStatus = ((Mail)localObject).getStatus();
        localMailInformation = ((Mail)localObject).getInformation();
        if ((localMailStatus == null) || (localMailInformation == null)) {
          break label1232;
        }
        if (localMailInformation.getUtc() != null) {}
      }
      for (;;)
      {
        i2 += 1;
        break;
        paramArrayList.add(new Object[] { Long.valueOf(localMailInformation.getId()), localMailInformation.getRemoteId(), Boolean.valueOf(localMailStatus.isSubscribeMail()) });
        localMailAttributeTag.tag_count = 0;
        localMailAttributeTag.tag_ids = null;
        localMailAttribute.detail = ((Mail)localObject).isRead();
        localMailAttribute.unread = localMailStatus.isUnread();
        localMailAttribute.star = localMailStatus.isStarred();
        localMailAttribute.conv_count = 0;
        localMailAttribute.tag = localMailAttributeTag;
        if ((localMailInformation.getTagList() != null) && (localMailInformation.getTagList().size() > 0))
        {
          localMailAttribute.tag.tag_ids = new int[localMailInformation.getTagList().size()];
          localMailAttribute.tag.tag_count = localMailAttribute.tag.tag_ids.length;
          j = 0;
          while (j < localMailAttribute.tag.tag_count)
          {
            localObject = (MailTag)localMailInformation.getTagList().get(j);
            localMailAttribute.tag.tag_ids[j] = Integer.parseInt(((MailTag)localObject).getTagId());
            j += 1;
          }
        }
        if (localMailStatus.isConversation()) {
          localMailAttribute.conv_count = localMailInformation.getConvCount();
        }
        int j = (int)(localMailInformation.getUtc().getTime() * 0.001D);
        if (i2 == 0)
        {
          MailEncode.htonl(j, arrayOfByte2);
          if (MailEncode.TIM_OK(j)) {}
          for (m = 4;; m = 0)
          {
            if (m != 0) {
              break label394;
            }
            break;
          }
          System.arraycopy(arrayOfByte2, 0, arrayOfByte1, k, m);
          n = m + k;
          m = 0;
          if (localMailAttribute.detail) {
            m = 1;
          }
          i = m;
          if (localMailAttribute.unread) {
            i = m | 0x2;
          }
          m = i;
          if (localMailAttribute.star) {
            m = i | 0x4;
          }
          i = m;
          if (localMailAttribute.tag.tag_count > 0) {
            i = m | 0x8;
          }
          m = i;
          if (localMailAttribute.conv_count > 0) {
            m = i | 0x10;
          }
          MailEncode.htonl(m, arrayOfByte2);
          if (!MailEncode.NUM_OK(m)) {
            break label698;
          }
          if (!MailEncode.IS_NUM_1BYTE(m)) {
            break label619;
          }
          i = 1;
        }
        for (;;)
        {
          if (i != 0) {
            break label703;
          }
          i = j;
          break;
          m = i - j;
          MailEncode.htonl(m, arrayOfByte2);
          if (MailEncode.TIM_DIFF_OK(m)) {
            if (MailEncode.IS_TIME_2BYTE(m)) {
              m = 2;
            }
          }
          for (;;)
          {
            if (m != 0) {
              break label594;
            }
            break;
            m = 4;
            arrayOfByte2[0] = ((byte)(arrayOfByte2[0] | 0x80));
            continue;
            m = 0;
          }
          System.arraycopy(arrayOfByte2, 4 - m, arrayOfByte1, k, m);
          n = m + k;
          break label413;
          label619:
          if (MailEncode.IS_NUM_2BYTE(m))
          {
            i = 2;
            arrayOfByte2[2] = ((byte)(arrayOfByte2[2] | 0x80));
          }
          else if (MailEncode.IS_NUM_3BYTE(m))
          {
            i = 3;
            arrayOfByte2[1] = ((byte)(arrayOfByte2[1] | 0x80 | 0x40));
          }
          else
          {
            i = 4;
            arrayOfByte2[0] = ((byte)(arrayOfByte2[0] | 0x80 | 0x40 | 0x20));
            continue;
            i = 0;
          }
        }
        System.arraycopy(arrayOfByte2, 4 - i, arrayOfByte1, n, i);
        int n = i + n;
        int m = n;
        if (localMailAttribute.tag.tag_count > 0)
        {
          i = localMailAttribute.tag.tag_count;
          MailEncode.htonl(i, arrayOfByte2);
          if (MailEncode.NUM_OK(i)) {
            if (MailEncode.IS_NUM_1BYTE(i)) {
              i = 1;
            }
          }
          for (;;)
          {
            if (i != 0) {
              break label859;
            }
            i = j;
            break;
            if (MailEncode.IS_NUM_2BYTE(i))
            {
              i = 2;
              arrayOfByte2[2] = ((byte)(arrayOfByte2[2] | 0x80));
            }
            else if (MailEncode.IS_NUM_3BYTE(i))
            {
              i = 3;
              arrayOfByte2[1] = ((byte)(arrayOfByte2[1] | 0x80 | 0x40));
            }
            else
            {
              i = 4;
              arrayOfByte2[0] = ((byte)(arrayOfByte2[0] | 0x80 | 0x40 | 0x20));
              continue;
              i = 0;
            }
          }
          label859:
          System.arraycopy(arrayOfByte2, 4 - i, arrayOfByte1, n, i);
          n += i;
          int i3 = 0;
          m = n;
          if (i3 < localMailAttribute.tag.tag_count)
          {
            i = localMailAttribute.tag.tag_ids[i3];
            MailEncode.htonl(i, arrayOfByte2);
            if (MailEncode.NUM_OK(i)) {
              if (MailEncode.IS_NUM_1BYTE(i))
              {
                i = 1;
                if (i != 0) {
                  break label1031;
                }
                n = k;
              }
            }
            for (;;)
            {
              i3 += 1;
              break;
              if (MailEncode.IS_NUM_2BYTE(i))
              {
                i = 2;
                arrayOfByte2[2] = ((byte)(arrayOfByte2[2] | 0x80));
                break label932;
              }
              if (MailEncode.IS_NUM_3BYTE(i))
              {
                i = 3;
                arrayOfByte2[1] = ((byte)(arrayOfByte2[1] | 0x80 | 0x40));
                break label932;
              }
              i = 4;
              arrayOfByte2[0] = ((byte)(arrayOfByte2[0] | 0x80 | 0x40 | 0x20));
              break label932;
              i = 0;
              break label932;
              System.arraycopy(arrayOfByte2, 4 - i, arrayOfByte1, n, i);
              n += i;
            }
          }
        }
        if (localMailAttribute.conv_count > 0)
        {
          i = localMailAttribute.conv_count;
          MailEncode.htonl(i, arrayOfByte2);
          if (MailEncode.NUM_OK(i)) {
            if (MailEncode.IS_NUM_1BYTE(i)) {
              i = 1;
            }
          }
          for (;;)
          {
            if (i != 0) {
              break label1180;
            }
            i = j;
            break;
            if (MailEncode.IS_NUM_2BYTE(i))
            {
              i = 2;
              arrayOfByte2[2] = ((byte)(arrayOfByte2[2] | 0x80));
            }
            else if (MailEncode.IS_NUM_3BYTE(i))
            {
              i = 3;
              arrayOfByte2[1] = ((byte)(arrayOfByte2[1] | 0x80 | 0x40));
            }
            else
            {
              i = 4;
              arrayOfByte2[0] = ((byte)(arrayOfByte2[0] | 0x80 | 0x40 | 0x20));
              continue;
              i = 0;
            }
          }
          System.arraycopy(arrayOfByte2, 4 - i, arrayOfByte1, m, i);
          k = m + i;
          i = j;
          continue;
          paramQMMailListCursor = new byte[k];
          System.arraycopy(arrayOfByte1, 0, paramQMMailListCursor, 0, k);
          return paramQMMailListCursor;
          return null;
        }
        else
        {
          i = j;
          k = m;
        }
      }
    }
  }
  
  static boolean getIncrementalUrl(@Nullable StringBuilder paramStringBuilder, IMailListCursor paramIMailListCursor, ArrayList<Object[]> paramArrayList, boolean paramBoolean)
  {
    paramIMailListCursor = getIncrementalBytes(paramIMailListCursor, paramArrayList);
    if ((paramIMailListCursor == null) || (paramStringBuilder == null)) {
      return false;
    }
    paramIMailListCursor = StringExtention.base64Encode(paramIMailListCursor, paramIMailListCursor.length);
    Log.d("QMMailUrlBuilder", "incremental:" + paramIMailListCursor);
    if (paramBoolean) {}
    for (paramIMailListCursor = StringExtention.replaceWithEncodeURIValue("&incremental_search=$incremental_search$", "incremental_search", paramIMailListCursor);; paramIMailListCursor = StringExtention.replaceWithEncodeURIValue("&incremental=$incremental$", "incremental", paramIMailListCursor))
    {
      paramStringBuilder.append(paramIMailListCursor);
      return true;
    }
  }
  
  private static int write2ByteBuffer(int paramInt1, int paramInt2, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    MailEncode.htonl(paramInt2, paramArrayOfByte1);
    if (MailEncode.IS_TIME_2BYTE(paramInt2)) {
      paramInt2 = 2;
    }
    for (;;)
    {
      System.arraycopy(paramArrayOfByte1, 4 - paramInt2, paramArrayOfByte2, paramInt1, paramInt2);
      return paramInt2;
      paramInt2 = 4;
      paramArrayOfByte1[0] = ((byte)(paramArrayOfByte1[0] | 0x80));
    }
  }
  
  private static int write4ByteBuffer(int paramInt1, int paramInt2, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    MailEncode.htonl(paramInt2, paramArrayOfByte1);
    System.arraycopy(paramArrayOfByte1, 0, paramArrayOfByte2, paramInt1, 4);
    return 4;
  }
  
  private static int writeBuffer(int paramInt1, int paramInt2, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    int i = 1;
    MailEncode.htonl(paramInt2, paramArrayOfByte1);
    if (MailEncode.IS_NUM_1BYTE(paramInt2)) {
      paramInt2 = i;
    }
    for (;;)
    {
      System.arraycopy(paramArrayOfByte1, 4 - paramInt2, paramArrayOfByte2, paramInt1, paramInt2);
      return paramInt2;
      if (MailEncode.IS_NUM_2BYTE(paramInt2))
      {
        paramArrayOfByte1[2] = ((byte)(paramArrayOfByte1[2] | 0x80));
        paramInt2 = 2;
      }
      else if (MailEncode.IS_NUM_3BYTE(paramInt2))
      {
        paramArrayOfByte1[1] = ((byte)(paramArrayOfByte1[1] | 0x80 | 0x40));
        paramInt2 = 3;
      }
      else
      {
        paramInt2 = 4;
        paramArrayOfByte1[0] = ((byte)(paramArrayOfByte1[0] | 0x80 | 0x40 | 0x20));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailUrlBuilder
 * JD-Core Version:    0.7.0.1
 */