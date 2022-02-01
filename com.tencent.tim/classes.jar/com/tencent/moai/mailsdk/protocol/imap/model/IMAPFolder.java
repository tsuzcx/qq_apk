package com.tencent.moai.mailsdk.protocol.imap.model;

import com.tencent.moai.mailsdk.model.Folder;
import com.tencent.moai.mailsdk.model.Profile;
import com.tencent.moai.mailsdk.protocol.imap.util.BASE64MailboxDecoder;
import com.tencent.moai.mailsdk.util.StringUtility;
import com.tencent.moai.mailsdk.util.log.Logger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;

public class IMAPFolder
  extends Folder
{
  private static final int INVALID_BIT = 16;
  private static final int MARKED_BIT = 4;
  private static final int NO_INFERIORS_BIT = 2;
  private static final int NO_SELECT_BIT = 1;
  private static final byte RECOGNIZE_DRAFTS = 2;
  private static final byte RECOGNIZE_INBOX = 1;
  private static final byte RECOGNIZE_SENT = 8;
  private static final byte RECOGNIZE_SPAM = 16;
  private static final byte RECOGNIZE_TRASH = 4;
  private static final int UNMARKED_BIT = 8;
  private ArrayList<IMAPFolderAttribute> attributeList = new ArrayList();
  private String hierarchyDelimiter;
  
  private static String getFolderName(String paramString1, String paramString2)
  {
    if (StringUtility.isNullOrEmpty(paramString1)) {
      str = "";
    }
    do
    {
      return str;
      str = paramString1;
    } while (StringUtility.isNullOrEmpty(paramString2));
    int i = paramString1.lastIndexOf(paramString2);
    String str = paramString1;
    if (i != -1) {
      str = paramString1.substring(i + paramString2.length());
    }
    return BASE64MailboxDecoder.decode(str);
  }
  
  private static String getFolderParentId(String paramString1, String paramString2)
  {
    if (StringUtility.isNullOrEmpty(paramString1)) {
      return "";
    }
    String str = paramString2;
    if (StringUtility.isNullOrEmpty(paramString2)) {
      str = "-/";
    }
    int i = paramString1.lastIndexOf(str);
    if (i != -1) {
      return paramString1.substring(0, i - str.length() + 1);
    }
    return "";
  }
  
  private static boolean isDeleteBox(String paramString1, String paramString2)
  {
    return (paramString1.contains("已删除")) || (paramString1.equalsIgnoreCase("trash")) || (paramString1.equalsIgnoreCase("deleted messages")) || (paramString2.equalsIgnoreCase("deleted")) || (paramString2.equalsIgnoreCase("deleted items")) || (paramString2.equalsIgnoreCase("deleted messages")) || (paramString2.equalsIgnoreCase("trash")) || (paramString2.equals("已删除")) || (paramString2.equals("已删")) || (paramString2.equals("废件")) || (paramString2.equals("废件箱")) || (paramString2.equals("已删除邮件")) || (paramString2.equals("已删邮件")) || (paramString2.equals("回收站"));
  }
  
  private static boolean isDraftBox(String paramString1, String paramString2)
  {
    return (paramString1.contains("草稿")) || (paramString1.equalsIgnoreCase("draft")) || (paramString1.equalsIgnoreCase("drafts")) || (paramString2.equalsIgnoreCase("draft")) || (paramString2.equalsIgnoreCase("drafts")) || (paramString2.equals("草稿")) || (paramString2.equals("发件")) || (paramString2.equals("草稿夹")) || (paramString2.equals("草稿箱"));
  }
  
  private static boolean isInBox(String paramString1, String paramString2)
  {
    return (paramString1.equalsIgnoreCase("inbox")) || (paramString2.equalsIgnoreCase("inbox")) || (paramString2.equals("收件箱")) || (paramString2.equals("收件夹"));
  }
  
  private static boolean isJunkBox(String paramString1, String paramString2)
  {
    return (paramString1.contains("垃圾")) || (paramString1.equalsIgnoreCase("spam")) || (paramString1.equalsIgnoreCase("junk")) || (paramString2.equalsIgnoreCase("spam")) || (paramString2.equalsIgnoreCase("junk")) || (paramString2.equalsIgnoreCase("junk e-mail")) || (paramString2.equalsIgnoreCase("junk-e-email")) || (paramString2.equals("垃圾")) || (paramString2.equals("垃圾邮件")) || (paramString2.equals("垃圾箱"));
  }
  
  private static boolean isSentBox(String paramString1, String paramString2)
  {
    return (paramString1.contains("已发送")) || (paramString1.equalsIgnoreCase("sent")) || (paramString1.equalsIgnoreCase("sent messages")) || (paramString1.equalsIgnoreCase("outbox")) || (paramString2.equalsIgnoreCase("sent")) || (paramString2.equalsIgnoreCase("sent messages")) || (paramString2.equalsIgnoreCase("sent items")) || (paramString2.equalsIgnoreCase("sent mail")) || (paramString2.equalsIgnoreCase("outbox")) || (paramString2.equals("已发送")) || (paramString2.equals("已发邮件")) || (paramString2.equals("已发送邮件"));
  }
  
  public static ArrayList<IMAPFolder> parseFolderList(ArrayList<IMAPResponse> paramArrayList, Profile paramProfile)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    int k = 0;
    String str1;
    label95:
    int j;
    label103:
    IMAPFolder localIMAPFolder;
    String str2;
    if (k < paramArrayList.size() - 1)
    {
      str1 = ((IMAPResponse)paramArrayList.get(k)).getContent();
      localStringBuilder.append(str1 + "\r\n");
      if (!StringUtility.isNullOrEmpty(str1)) {}
    }
    else
    {
      paramArrayList = localArrayList.iterator();
      j = i;
      if (!paramArrayList.hasNext()) {
        break label1110;
      }
      localIMAPFolder = (IMAPFolder)paramArrayList.next();
      str1 = getFolderName(localIMAPFolder.getPath(), localIMAPFolder.getHierarchyDelimiter());
      i = j;
      if (StringUtility.isNullOrEmpty(localIMAPFolder.getName()))
      {
        str2 = BASE64MailboxDecoder.decode(localIMAPFolder.getPath());
        if (((j & 0x1) != 0) || (!isInBox(str2, str1))) {
          break label954;
        }
        localIMAPFolder.setName("INBOX");
        localIMAPFolder.setType(1);
        i = j | 0x1;
      }
    }
    for (;;)
    {
      j = i;
      if (!StringUtility.isNullOrEmpty(localIMAPFolder.getName())) {
        break label103;
      }
      localIMAPFolder.setName(str1);
      j = i;
      break label103;
      localIMAPFolder = new IMAPFolder();
      j = str1.toLowerCase().indexOf("* list");
      if (j == -1) {
        break label95;
      }
      str2 = str1.substring(j + 6);
      j = str2.indexOf("(");
      int m = str2.indexOf(")");
      if ((j == -1) || (m == -1)) {
        break label95;
      }
      str1 = str2.substring(j + 1, m).toLowerCase(Locale.ENGLISH);
      str2 = str2.substring(m + 1);
      if (str1.indexOf("noselect") != -1) {
        localIMAPFolder.getAttributeList().add(IMAPFolderAttribute.NOSELECT);
      }
      if (str1.indexOf("noinferiors") != -1) {
        localIMAPFolder.getAttributeList().add(IMAPFolderAttribute.NOINFERIORS);
      }
      if (str1.indexOf("hasnochildren") != -1) {
        localIMAPFolder.getAttributeList().add(IMAPFolderAttribute.NOINFERIORS);
      }
      if (str1.indexOf("marked") != -1) {
        localIMAPFolder.getAttributeList().add(IMAPFolderAttribute.MARKED);
      }
      if (str1.indexOf("unmarked") != -1) {
        localIMAPFolder.getAttributeList().add(IMAPFolderAttribute.UNMARKED);
      }
      j = i;
      if (str1.indexOf("inbox") != -1)
      {
        localIMAPFolder.setName("Inbox");
        localIMAPFolder.setType(1);
        j = i | 0x1;
      }
      i = j;
      if (str1.indexOf("drafts") != -1)
      {
        localIMAPFolder.setName("Drafts");
        localIMAPFolder.setType(2);
        i = j | 0x2;
      }
      j = i;
      if (str1.indexOf("trash") != -1)
      {
        localIMAPFolder.setName("Deleted Messages");
        localIMAPFolder.setType(3);
        j = i | 0x4;
      }
      i = j;
      if (str1.indexOf("sent") != -1)
      {
        localIMAPFolder.setName("Sent Messages");
        localIMAPFolder.setType(4);
        i = j | 0x8;
      }
      j = i;
      if (str1.indexOf("junk") != -1)
      {
        localIMAPFolder.setName("Junk");
        localIMAPFolder.setType(5);
        j = i | 0x10;
      }
      i = j;
      if (str1.indexOf("spam") != -1)
      {
        localIMAPFolder.setName("Spam");
        localIMAPFolder.setType(5);
        i = j | 0x10;
      }
      if (str1.indexOf("flagged") != -1)
      {
        localIMAPFolder.setName("Flagged");
        localIMAPFolder.setType(9);
      }
      if (str1.indexOf("important") != -1)
      {
        localIMAPFolder.setName("Important");
        localIMAPFolder.setType(10);
      }
      if (str1.indexOf("all") != -1)
      {
        localIMAPFolder.setName("All");
        localIMAPFolder.setType(8);
      }
      j = str2.indexOf("\"");
      if (j == -1) {}
      do
      {
        do
        {
          do
          {
            k += 1;
            break;
            m = str2.indexOf("\"", j + 1);
          } while (m == -1);
          if (m > j + 1) {
            localIMAPFolder.setHierarchyDelimiter(str2.substring(j + 1, m));
          }
          str1 = str2.substring(m + 1);
          if (str1.charAt(1) != '"') {
            break label942;
          }
          m = str1.indexOf("\"");
        } while (m == -1);
        for (j = str1.indexOf("\"", m + 1); (j != -1) && (str1.charAt(j - 2) == '\\'); j = str1.indexOf("\"", j + 1)) {}
      } while (j == -1);
      for (;;)
      {
        if (j >= m + 1) {
          localIMAPFolder.setPath(str1.substring(m + 1, j));
        }
        localIMAPFolder.setParentId(getFolderParentId(localIMAPFolder.getPath(), localIMAPFolder.getHierarchyDelimiter()));
        localIMAPFolder.setRemoteId(localIMAPFolder.getPath());
        localIMAPFolder.setVirtual(localIMAPFolder.noSelect());
        localIMAPFolder.setTop(localIMAPFolder.getParentId().equals(""));
        localArrayList.add(localIMAPFolder);
        break;
        label942:
        m = 0;
        j = str1.length();
      }
      label954:
      if (((j & 0x2) == 0) && (isDraftBox(str2, str1)))
      {
        localIMAPFolder.setName("Drafts");
        localIMAPFolder.setType(2);
        i = j | 0x2;
      }
      else if (((j & 0x4) == 0) && (isDeleteBox(str2, str1)))
      {
        localIMAPFolder.setName("Deleted Messages");
        localIMAPFolder.setType(3);
        i = j | 0x4;
      }
      else if (((j & 0x8) == 0) && (isSentBox(str2, str1)))
      {
        localIMAPFolder.setName("Sent Messages");
        localIMAPFolder.setType(4);
        i = j | 0x8;
      }
      else
      {
        i = j;
        if ((j & 0x10) == 0)
        {
          i = j;
          if (isJunkBox(str2, str1))
          {
            localIMAPFolder.setName("Spam");
            localIMAPFolder.setType(5);
            i = j | 0x10;
          }
        }
      }
    }
    label1110:
    if ((j & 0x8) == 0) {
      if (paramProfile == null) {
        break label1154;
      }
    }
    label1154:
    for (paramArrayList = paramProfile.getMailAddress();; paramArrayList = "")
    {
      Logger.osslog(new Object[] { "no_sent_box", paramArrayList, localStringBuilder.toString() });
      return localArrayList;
    }
  }
  
  public ArrayList<IMAPFolderAttribute> getAttributeList()
  {
    return this.attributeList;
  }
  
  public String getHierarchyDelimiter()
  {
    return this.hierarchyDelimiter;
  }
  
  public boolean noSelect()
  {
    Iterator localIterator = this.attributeList.iterator();
    while (localIterator.hasNext()) {
      if (((IMAPFolderAttribute)localIterator.next()).equals(IMAPFolderAttribute.NOSELECT)) {
        return true;
      }
    }
    return false;
  }
  
  public void setAttributeList(ArrayList<IMAPFolderAttribute> paramArrayList)
  {
    this.attributeList = paramArrayList;
  }
  
  public void setHierarchyDelimiter(String paramString)
  {
    this.hierarchyDelimiter = paramString;
  }
  
  public static final class IMAPFolderAttribute
  {
    public static final IMAPFolderAttribute INVALID = new IMAPFolderAttribute(16);
    public static final IMAPFolderAttribute MARKED;
    public static final IMAPFolderAttribute NOINFERIORS;
    public static final IMAPFolderAttribute NOSELECT = new IMAPFolderAttribute(1);
    public static final IMAPFolderAttribute UNMARKED;
    private int bit;
    
    static
    {
      NOINFERIORS = new IMAPFolderAttribute(2);
      MARKED = new IMAPFolderAttribute(4);
      UNMARKED = new IMAPFolderAttribute(8);
    }
    
    public IMAPFolderAttribute(int paramInt)
    {
      this.bit = paramInt;
    }
    
    public boolean equal(IMAPFolderAttribute paramIMAPFolderAttribute)
    {
      return this.bit == paramIMAPFolderAttribute.bit;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.protocol.imap.model.IMAPFolder
 * JD-Core Version:    0.7.0.1
 */