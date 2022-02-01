package com.tencent.qqmail.protocol;

import android.util.Log;
import com.tencent.moai.mailsdk.model.Attachment;
import com.tencent.moai.mailsdk.model.Contact;
import com.tencent.qqmail.attachment.model.Attach;
import com.tencent.qqmail.attachment.model.AttachPreview;
import com.tencent.qqmail.model.mail.QMMailManager;
import com.tencent.qqmail.model.qmdomain.MailContact;
import com.tencent.qqmail.model.qmdomain.MailContent;
import com.tencent.qqmail.model.qmdomain.MailInformation;
import com.tencent.qqmail.model.uidomain.ComposeMailUI;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.stringextention.StringExtention;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.lang3.text.translate.EntityArrays;

public class MailUtil
{
  private static String[][] BASIC_ESCAPE = EntityArrays.BASIC_ESCAPE();
  private static String[][] ISO8859_1_ESCAPE = ;
  private static final String TAG = "MailUtil";
  
  private static ArrayList<Attachment> QMAttaches2Attachments(ArrayList<Object> paramArrayList)
  {
    if (paramArrayList == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      Attach localAttach = (Attach)paramArrayList.next();
      Attachment localAttachment = new Attachment();
      localAttachment.setCid(localAttach.getRemoteId());
      localAttachment.setPath(localAttach.getPreview().getMyDisk());
      localAttachment.setType("attachment");
      localArrayList.add(localAttachment);
    }
    return localArrayList;
  }
  
  private static Contact QMContact2SdkContact(MailContact paramMailContact)
  {
    if (paramMailContact == null) {
      return null;
    }
    return new Contact(paramMailContact.getAddress(), paramMailContact.getNick());
  }
  
  private static ArrayList<Contact> QMContacts2SdkContacts(List<Object> paramList)
  {
    if (paramList == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localArrayList.add(QMContact2SdkContact((MailContact)paramList.next()));
    }
    return localArrayList;
  }
  
  public static com.tencent.moai.mailsdk.model.Mail QMMail2SdkMail(com.tencent.qqmail.model.qmdomain.Mail paramMail, boolean paramBoolean)
  {
    com.tencent.moai.mailsdk.model.Mail localMail = new com.tencent.moai.mailsdk.model.Mail();
    QMMailManager.sharedInstance().fillMailExtra(paramMail, false, false);
    localMail.setMessageId(ComposeMailUI.genMessageId());
    MailInformation localMailInformation = paramMail.getInformation();
    if (localMailInformation != null)
    {
      localMail.setSubject(localMailInformation.getSubject());
      localMail.setFrom(QMContact2SdkContact(localMailInformation.getFrom()));
      localMail.setReplyTo(QMContact2SdkContact(localMailInformation.getReply()));
      localMail.setTo(QMContacts2SdkContacts(localMailInformation.getToList()));
      localMail.setCc(QMContacts2SdkContacts(localMailInformation.getCcList()));
      localMail.setBcc(QMContacts2SdkContacts(localMailInformation.getBccList()));
    }
    localMail.setUtc(localMail.getUtc());
    paramMail = paramMail.getContent();
    if (paramMail != null)
    {
      localMail.setPlainContent(paramMail.getBodyText());
      localMail.setHtmlContent(paramMail.getBody());
    }
    if (paramBoolean) {
      localMail.setAttachments(QMAttaches2Attachments(localMailInformation.getAttachList()));
    }
    return localMail;
  }
  
  private static void appendWhiteSpace(StringBuilder paramStringBuilder)
  {
    if ((paramStringBuilder.length() > 0) && (paramStringBuilder.charAt(paramStringBuilder.length() - 1) != ' ')) {
      paramStringBuilder.append(' ');
    }
  }
  
  public static String getAbstract(String paramString)
  {
    long l = System.currentTimeMillis();
    String str = mergeWhitespace(htmlDecode(getMailContent(paramString)));
    Log.v("MailUtil", "new getMailAbstract, source: " + paramString.length() + ", elapsed: " + (System.currentTimeMillis() - l) + "ms");
    return str;
  }
  
  public static String getMailAbstract(String paramString)
  {
    return getAbstract(paramString);
  }
  
  private static StringBuilder getMailContent(String paramString)
  {
    String str1 = "< \t\n\r" + '\f';
    str1 = str1 + '(';
    str1 = str1 + ')';
    String str2 = " \t\n\r" + '\f';
    str2 = str2 + '(';
    str2 = str2 + ')';
    StringBuilder localStringBuilder1 = new StringBuilder();
    StringBuilder localStringBuilder2 = new StringBuilder();
    StringBuilder localStringBuilder3 = new StringBuilder();
    int m = paramString.length();
    int i = 0;
    int j;
    if (i < m)
    {
      localStringBuilder2.setLength(0);
      String str3 = localStringBuilder1.toString();
      if (("style".equalsIgnoreCase(str3)) || ("script".equalsIgnoreCase(str3)) || ("noscript".equalsIgnoreCase(str3)) || ("title".equalsIgnoreCase(str3))) {
        j = 1;
      }
      while ((i < m) && (str1.indexOf(paramString.charAt(i)) == -1)) {
        if (j != 0)
        {
          i += 1;
          continue;
          j = 0;
        }
        else
        {
          localStringBuilder2.append(paramString.charAt(i));
          i += 1;
        }
      }
      localStringBuilder3.append(localStringBuilder2);
      if (i < m) {
        break label305;
      }
    }
    label302:
    label305:
    do
    {
      do
      {
        do
        {
          return localStringBuilder3;
          j = i;
          if (paramString.charAt(i) != '<') {
            break;
          }
          i += 1;
        } while (i >= m - 3);
        if (!paramString.substring(i, i + 3).equals("!--")) {
          break;
        }
        j = paramString.indexOf("-->", i);
      } while (j == -1);
      i = j - i + 3 + i;
    } while (i >= m);
    int k;
    label698:
    label742:
    do
    {
      do
      {
        break;
        localStringBuilder1.setLength(0);
        j = i;
        if (paramString.charAt(i) == '/')
        {
          i += 1;
          if (i >= m) {
            break label302;
          }
          while ((i < m) && ("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".indexOf(paramString.charAt(i)) != -1))
          {
            localStringBuilder1.append(paramString.charAt(i));
            i += 1;
          }
          if ((isSameIgnoreCase(localStringBuilder1, "a")) || (isSameIgnoreCase(localStringBuilder1, "b")) || (isSameIgnoreCase(localStringBuilder1, "i")) || (isSameIgnoreCase(localStringBuilder1, "q")) || (isSameIgnoreCase(localStringBuilder1, "span")) || (isSameIgnoreCase(localStringBuilder1, "em")) || (isSameIgnoreCase(localStringBuilder1, "strong")) || (isSameIgnoreCase(localStringBuilder1, "cite")) || (isSameIgnoreCase(localStringBuilder1, "abbr")) || (isSameIgnoreCase(localStringBuilder1, "acronym")) || (isSameIgnoreCase(localStringBuilder1, "label")))
          {
            j = 1;
            if ((j == 0) && (localStringBuilder3.length() > 0) && (i < m - 1)) {
              appendWhiteSpace(localStringBuilder3);
            }
            if (i >= m) {
              break label302;
            }
          }
        }
        for (;;)
        {
          if (i < m)
          {
            k = i + 1;
            j = k;
            if (paramString.charAt(i) == '>') {
              break label698;
            }
            i = k;
            continue;
            j = 0;
            break;
            while ((j < m) && ("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".indexOf(paramString.charAt(j)) != -1))
            {
              localStringBuilder1.append(paramString.charAt(j));
              j += 1;
            }
            if (isSameIgnoreCase(localStringBuilder1, "br")) {
              appendWhiteSpace(localStringBuilder3);
            }
            i = j;
            if (j >= m) {
              return localStringBuilder3;
            }
          }
        }
        j = i;
        i = j;
      } while (j < m);
      return localStringBuilder3;
      while (j < m)
      {
        i = j + 1;
        k = i;
        if (str2.indexOf(paramString.charAt(j)) != -1) {
          break label742;
        }
        j = i;
      }
      k = j;
      if ((localStringBuilder3.length() > 0) && (k < m - 1)) {
        appendWhiteSpace(localStringBuilder3);
      }
      i = k;
    } while (k < m);
    return localStringBuilder3;
  }
  
  private static StringBuilder htmlDecode(StringBuilder paramStringBuilder)
  {
    int j;
    int i;
    if (paramStringBuilder.length() > 0)
    {
      j = paramStringBuilder.lastIndexOf("&");
      i = j;
      if (j == -1) {
        return paramStringBuilder;
      }
    }
    else
    {
      i = 0;
    }
    StringBuilder localStringBuilder = new StringBuilder(12);
    int k = paramStringBuilder.indexOf(";", i);
    String str1;
    if (k != -1)
    {
      localStringBuilder.setLength(0);
      localStringBuilder.append(paramStringBuilder, i, k + 1);
      if ((localStringBuilder.length() > 3) && (localStringBuilder.length() < 11))
      {
        if (localStringBuilder.charAt(1) != '#') {
          break label258;
        }
        if (Character.toLowerCase(localStringBuilder.charAt(2)) != 'x') {
          break label196;
        }
        str1 = localStringBuilder.substring(3, localStringBuilder.length() - 1);
      }
    }
    label258:
    label270:
    label401:
    label406:
    for (;;)
    {
      try
      {
        j = Integer.valueOf(str1.trim(), 16).intValue();
        if ((j < 65535) && (j > 0)) {
          paramStringBuilder.replace(i, k + 1, String.valueOf((char)j));
        }
        if (i <= 0) {
          break;
        }
        i = paramStringBuilder.lastIndexOf("&", i - 1);
        if (i == -1) {
          break;
        }
      }
      catch (Exception localException1)
      {
        j = -1;
        continue;
      }
      label196:
      String str2 = localStringBuilder.substring(2, localStringBuilder.length() - 1);
      try
      {
        j = Integer.valueOf(str2.trim()).intValue();
        if ((j >= 65535) || (j <= 0)) {
          continue;
        }
        paramStringBuilder.replace(i, k + 1, String.valueOf((char)j));
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          j = -1;
        }
      }
      String[][] arrayOfString = ISO8859_1_ESCAPE;
      int m = arrayOfString.length;
      j = 0;
      String[] arrayOfString1;
      if (j < m)
      {
        arrayOfString1 = arrayOfString[j];
        if (isSame(localStringBuilder, (String)arrayOfString1[1])) {
          paramStringBuilder.replace(i, k + 1, String.valueOf(arrayOfString1[0].charAt(0)));
        }
      }
      for (j = 1;; j = 0)
      {
        if (j != 0) {
          break label406;
        }
        arrayOfString = BASIC_ESCAPE;
        m = arrayOfString.length;
        j = 0;
        for (;;)
        {
          if (j >= m) {
            break label401;
          }
          arrayOfString1 = arrayOfString[j];
          if (isSame(localStringBuilder, (String)arrayOfString1[1]))
          {
            paramStringBuilder.replace(i, k + 1, String.valueOf(arrayOfString1[0].charAt(0)));
            break;
            j += 1;
            break label270;
          }
          j += 1;
        }
        break;
      }
    }
  }
  
  private static boolean isSame(StringBuilder paramStringBuilder, String paramString)
  {
    int i = paramString.length();
    if (paramStringBuilder.length() != i) {
      return false;
    }
    int j = 0;
    for (;;)
    {
      if (i == 0) {
        break label45;
      }
      if (paramString.charAt(j) != paramStringBuilder.charAt(j)) {
        break;
      }
      j += 1;
      i -= 1;
    }
    label45:
    return true;
  }
  
  private static boolean isSameIgnoreCase(StringBuilder paramStringBuilder, String paramString)
  {
    return paramStringBuilder.toString().equalsIgnoreCase(paramString);
  }
  
  private static String mergeWhitespace(StringBuilder paramStringBuilder)
  {
    int i = 0;
    int k = paramStringBuilder.length();
    StringBuilder localStringBuilder = new StringBuilder(paramStringBuilder.length());
    char c1 = ' ';
    for (;;)
    {
      int j;
      if (i < k)
      {
        j = i + 1;
        char c2 = paramStringBuilder.charAt(i);
        if ((c2 != ' ') && ((c2 != ' ') || (c1 != ' ')))
        {
          localStringBuilder.append(c1);
          c1 = c2;
          i = j;
        }
      }
      else
      {
        return localStringBuilder.toString();
      }
      i = j;
    }
  }
  
  public static String removeContentTag(String paramString)
  {
    long l = System.currentTimeMillis();
    String str = paramString;
    if (!StringExtention.isNullOrEmpty(paramString))
    {
      paramString = htmlDecode(new StringBuilder(paramString.replaceAll("<.*?>", "")));
      QMLog.log(3, "MailUtil", "remove content tag time:" + (System.currentTimeMillis() - l));
      str = paramString.toString();
    }
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.protocol.MailUtil
 * JD-Core Version:    0.7.0.1
 */