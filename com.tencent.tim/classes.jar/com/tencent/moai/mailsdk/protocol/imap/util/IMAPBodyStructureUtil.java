package com.tencent.moai.mailsdk.protocol.imap.util;

import android.util.Log;
import com.tencent.moai.mailsdk.MailParser;
import com.tencent.moai.mailsdk.exception.MessageException;
import com.tencent.moai.mailsdk.model.Attachment;
import com.tencent.moai.mailsdk.model.Mail;
import com.tencent.moai.mailsdk.protocol.imap.model.IMAPBodyStructure;
import com.tencent.moai.mailsdk.protocol.imap.model.IMAPEnvelop;
import com.tencent.moai.mailsdk.protocol.mime.MimeDefine;
import com.tencent.moai.mailsdk.util.FileUtility;
import com.tencent.moai.mailsdk.util.MimeUtility;
import com.tencent.moai.mailsdk.util.StringUtility;
import com.tencent.moai.mailsdk.util.log.Logger;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import moai.oss.OssHelper;

public class IMAPBodyStructureUtil
{
  private static String STR_ATTACHMENT = "attachment";
  private static String STR_FILENAME;
  private static String STR_IMAGE = "image";
  private static String STR_INLINE;
  private static String STR_NAME = "\"name\"";
  private static final String TAG = "IMAPBodyStructureUtil";
  
  static
  {
    STR_FILENAME = "\"filename\"";
    STR_INLINE = "inline";
  }
  
  private static ArrayList<IMAPBodyStructure> filterRootBodyStructure(ArrayList<IMAPBodyStructure> paramArrayList)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramArrayList.size() == 1)
    {
      paramArrayList = (IMAPBodyStructure)paramArrayList.get(0);
      paramArrayList.setBodyId("1");
      localArrayList.add(paramArrayList);
    }
    for (;;)
    {
      return localArrayList;
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        IMAPBodyStructure localIMAPBodyStructure = (IMAPBodyStructure)paramArrayList.next();
        if (!localIMAPBodyStructure.getBodyId().equals("0")) {
          localArrayList.add(localIMAPBodyStructure);
        } else if (!localIMAPBodyStructure.getContentType().equals(MimeDefine.MULTIPART)) {
          Logger.log(4, "IMAPBodyStructureUtil", "filter root:" + localIMAPBodyStructure.toString());
        }
      }
    }
  }
  
  public static ArrayList<IMAPBodyStructure> filterTextBodyStructure(ArrayList<IMAPBodyStructure> paramArrayList)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        IMAPBodyStructure localIMAPBodyStructure = (IMAPBodyStructure)paramArrayList.next();
        if (MimeDefine.TEXT.equalsIgnoreCase(localIMAPBodyStructure.getContentType())) {
          localArrayList.add(localIMAPBodyStructure);
        }
      }
    }
    return localArrayList;
  }
  
  private static void foldBodyStructure(ArrayList<IMAPBodyStructure> paramArrayList, IMAPBodyStructure paramIMAPBodyStructure)
  {
    paramArrayList.add(paramIMAPBodyStructure);
    if ((paramIMAPBodyStructure.getBodies() != null) && (!paramIMAPBodyStructure.getBodies().isEmpty()) && (!paramIMAPBodyStructure.isMessageRfc()))
    {
      paramIMAPBodyStructure = paramIMAPBodyStructure.getBodies().iterator();
      while (paramIMAPBodyStructure.hasNext()) {
        foldBodyStructure(paramArrayList, (IMAPBodyStructure)paramIMAPBodyStructure.next());
      }
    }
  }
  
  private static String getAttachmentName(IMAPBodyStructure paramIMAPBodyStructure)
    throws IOException
  {
    int k = 6;
    if ((paramIMAPBodyStructure.isMessageRfc()) && (paramIMAPBodyStructure.getEnvelope() != null)) {
      return MimeUtility.decodeText(paramIMAPBodyStructure.getEnvelope().getSubject()) + ".eml";
    }
    Object localObject = null;
    int j;
    int i;
    if (!StringUtility.isNullOrEmpty(paramIMAPBodyStructure.getContentParam()))
    {
      localObject = paramIMAPBodyStructure.getContentParam();
      j = ((String)localObject).toLowerCase().indexOf(STR_NAME);
      if (j == -1)
      {
        j = ((String)localObject).toLowerCase().indexOf(STR_FILENAME);
        i = 10;
      }
    }
    for (;;)
    {
      if ((j == -1) && (!StringUtility.isNullOrEmpty(paramIMAPBodyStructure.getDispositionParam())))
      {
        paramIMAPBodyStructure = paramIMAPBodyStructure.getDispositionParam();
        int m = paramIMAPBodyStructure.toLowerCase().indexOf(STR_NAME);
        localObject = paramIMAPBodyStructure;
        i = k;
        j = m;
        if (m == -1)
        {
          j = paramIMAPBodyStructure.toLowerCase().indexOf(STR_FILENAME);
          i = 10;
          localObject = paramIMAPBodyStructure;
        }
      }
      for (;;)
      {
        Logger.log(4, "IMAPBodyStructureUtil", "attachNameParam:" + (String)localObject);
        if (j == -1) {
          return "";
        }
        String str = "";
        k = ((String)localObject).indexOf("\"", j + i);
        if (k != -1)
        {
          i = ((String)localObject).indexOf("\"", k + 1);
          if (i == -1) {
            return "";
          }
        }
        for (;;)
        {
          try
          {
            paramIMAPBodyStructure = ((String)localObject).substring(k + 1, i);
            return MimeUtility.decodeText(paramIMAPBodyStructure);
          }
          catch (Exception paramIMAPBodyStructure)
          {
            Logger.log(5, "IMAPBodyStructureUtil", Log.getStackTraceString(paramIMAPBodyStructure));
            paramIMAPBodyStructure = "";
            continue;
          }
          i = ((String)localObject).indexOf('{', i + j);
          paramIMAPBodyStructure = str;
          if (i != -1)
          {
            j = ((String)localObject).indexOf('}', k + 1);
            if (j == -1) {
              return "";
            }
            try
            {
              i = Integer.parseInt(((String)localObject).substring(i + 1, j));
              paramIMAPBodyStructure = str;
              if (i > 0)
              {
                paramIMAPBodyStructure = str;
                if (j + i < ((String)localObject).length())
                {
                  paramIMAPBodyStructure = ((String)localObject).substring(j + 1);
                  localObject = paramIMAPBodyStructure;
                  if (paramIMAPBodyStructure.charAt(0) == '\r')
                  {
                    localObject = paramIMAPBodyStructure;
                    if (paramIMAPBodyStructure.charAt(1) == '\n') {
                      localObject = paramIMAPBodyStructure.substring(2);
                    }
                  }
                  paramIMAPBodyStructure = str;
                  if (((String)localObject).length() >= i) {
                    paramIMAPBodyStructure = ((String)localObject).substring(0, i);
                  }
                }
              }
            }
            catch (Exception paramIMAPBodyStructure)
            {
              for (;;)
              {
                Logger.log(5, "IMAPBodyStructureUtil", paramIMAPBodyStructure.getMessage());
                i = 0;
              }
            }
          }
        }
      }
      i = 6;
      continue;
      i = -1;
      j = -1;
    }
  }
  
  public static boolean isAttachmentBodyPart(IMAPBodyStructure paramIMAPBodyStructure)
  {
    boolean bool2 = true;
    String str1 = paramIMAPBodyStructure.getContentType();
    String str2 = paramIMAPBodyStructure.getContentSubtype();
    String str3 = paramIMAPBodyStructure.getContentParam();
    String str4 = paramIMAPBodyStructure.getDispositionParam();
    String str5 = paramIMAPBodyStructure.getDisposition();
    String str6 = paramIMAPBodyStructure.getContentId();
    boolean bool1;
    if ((str1 == null) || (str1.equalsIgnoreCase(MimeDefine.NIL)) || (str2 == null) || (str2.equalsIgnoreCase(MimeDefine.NIL))) {
      bool1 = false;
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    return bool1;
                    if (StringUtility.isNullOrEmpty(str5)) {
                      break;
                    }
                    bool1 = bool2;
                  } while (str5.toLowerCase().contains(STR_INLINE));
                  bool1 = bool2;
                } while (str5.toLowerCase().contains(STR_ATTACHMENT));
                if (StringUtility.isNullOrEmpty(str3)) {
                  break;
                }
                bool1 = bool2;
              } while (str3.toLowerCase().contains(STR_NAME));
              bool1 = bool2;
            } while (str3.toLowerCase().contains(STR_FILENAME));
            if (StringUtility.isNullOrEmpty(str4)) {
              break;
            }
            bool1 = bool2;
          } while (str4.toLowerCase().contains(STR_NAME));
          bool1 = bool2;
        } while (str4.toLowerCase().contains(STR_FILENAME));
        bool1 = bool2;
      } while (!StringUtility.isNullOrEmpty(str6));
      bool1 = bool2;
    } while (paramIMAPBodyStructure.isMessageRfc());
    return false;
  }
  
  public static boolean isInlineImageBodyPart(IMAPBodyStructure paramIMAPBodyStructure)
  {
    String str1 = paramIMAPBodyStructure.getContentType();
    String str2 = paramIMAPBodyStructure.getContentSubtype();
    String str3 = paramIMAPBodyStructure.getDisposition();
    paramIMAPBodyStructure = paramIMAPBodyStructure.getContentId();
    if ((str1 == null) || (str1.equalsIgnoreCase(MimeDefine.NIL)) || (str2 == null) || (str2.equalsIgnoreCase(MimeDefine.NIL))) {}
    while (((!StringUtility.isNullOrEmpty(str3)) && (str3.toLowerCase().contains(STR_ATTACHMENT))) || (StringUtility.isNullOrEmpty(paramIMAPBodyStructure)) || (StringUtility.isNullOrEmpty(str1)) || (!str1.equalsIgnoreCase(STR_IMAGE))) {
      return false;
    }
    return true;
  }
  
  public static boolean isMailBodyPart(IMAPBodyStructure paramIMAPBodyStructure)
  {
    String str1 = paramIMAPBodyStructure.getContentType();
    String str2 = paramIMAPBodyStructure.getContentSubtype();
    String str3 = paramIMAPBodyStructure.getContentParam();
    paramIMAPBodyStructure = paramIMAPBodyStructure.getDispositionParam();
    if ((str1 == null) || (str1.equalsIgnoreCase(MimeDefine.NIL)) || (str2 == null) || (str2.equalsIgnoreCase(MimeDefine.NIL))) {}
    while (((!StringUtility.isNullOrEmpty(str3)) && ((str3.toLowerCase().contains(STR_NAME)) || (str3.toLowerCase().contains(STR_FILENAME)))) || ((!StringUtility.isNullOrEmpty(paramIMAPBodyStructure)) && ((paramIMAPBodyStructure.toLowerCase().contains(STR_NAME)) || (paramIMAPBodyStructure.toLowerCase().contains(STR_FILENAME)))) || (!MimeDefine.TEXT.equalsIgnoreCase(str1)) || ((!MimeDefine.PLAIN.equalsIgnoreCase(str2)) && (!MimeDefine.HTML.equalsIgnoreCase(str2)) && (!MimeDefine.CALENDAR.equalsIgnoreCase(str2)))) {
      return false;
    }
    return true;
  }
  
  public static ArrayList<Attachment> parseAttachmentByBodyStructure(ArrayList<IMAPBodyStructure> paramArrayList)
    throws MessageException
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    IMAPBodyStructure localIMAPBodyStructure;
    Attachment localAttachment;
    if (i < paramArrayList.size())
    {
      localIMAPBodyStructure = (IMAPBodyStructure)paramArrayList.get(i);
      localAttachment = new Attachment();
      localAttachment.setImapBodyStructure(localIMAPBodyStructure);
      localAttachment.setSize((localIMAPBodyStructure.getSize() * 0.75D));
      localAttachment.setCid(MailParser.getAttachmentContentId(localIMAPBodyStructure.getContentId()));
      if (isInlineImageBodyPart(localIMAPBodyStructure)) {
        localAttachment.setType("inline");
      }
    }
    label247:
    for (;;)
    {
      try
      {
        String str = getAttachmentName(localIMAPBodyStructure);
        if (!StringUtility.isNullOrEmpty(str)) {
          break label247;
        }
        Logger.log(6, "IMAPBodyStructureUtil", "cannot find attach name:" + localIMAPBodyStructure.toString());
        OssHelper.imapAttachNameNull(new Object[] { localIMAPBodyStructure.toString() });
        str = FileUtility.generateSeqAttachName(i + 1, localIMAPBodyStructure);
        Logger.log(4, "IMAPBodyStructureUtil", "get attach name:" + str);
        localAttachment.setName(str);
        localArrayList.add(localAttachment);
        i += 1;
      }
      catch (IOException paramArrayList)
      {
        throw new MessageException(2, "decode attach name fail " + paramArrayList.getMessage());
      }
      localAttachment.setType("attachment");
      continue;
      return localArrayList;
    }
  }
  
  public static ArrayList<IMAPBodyStructure> parseBodyStructure(IMAPBodyStructure paramIMAPBodyStructure)
  {
    ArrayList localArrayList = new ArrayList();
    foldBodyStructure(localArrayList, paramIMAPBodyStructure);
    return filterRootBodyStructure(localArrayList);
  }
  
  public static void setMailBodyStructure(Mail paramMail, ArrayList<IMAPBodyStructure> paramArrayList)
    throws MessageException
  {
    if ((paramMail != null) && (paramArrayList != null))
    {
      localArrayList1 = new ArrayList();
      localArrayList2 = new ArrayList();
      localStringBuilder1 = new StringBuilder("mail bodies:");
      localStringBuilder2 = new StringBuilder("attach bodies:");
      localStringBuilder3 = new StringBuilder("unknown bodies:");
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        localIMAPBodyStructure = (IMAPBodyStructure)paramArrayList.next();
        if (isMailBodyPart(localIMAPBodyStructure))
        {
          localArrayList1.add(localIMAPBodyStructure);
          localStringBuilder1.append(localIMAPBodyStructure.toString()).append("\r\n");
        }
        else if (isAttachmentBodyPart(localIMAPBodyStructure))
        {
          localArrayList2.add(localIMAPBodyStructure);
          localStringBuilder2.append(localIMAPBodyStructure.toString()).append("\r\n");
        }
        else if (!localIMAPBodyStructure.getContentType().equals(MimeDefine.MULTIPART))
        {
          localStringBuilder3.append(localIMAPBodyStructure.toString()).append("\r\n");
        }
      }
      Logger.log(4, "IMAPBodyStructureUtil", "uid:" + paramMail.getRemoteId() + ", " + localStringBuilder1.toString() + "\r\n" + localStringBuilder2.toString() + "\r\n" + localStringBuilder3.toString());
      paramMail.setBodyStructures(localArrayList1);
      paramMail.setAttachments(parseAttachmentByBodyStructure(localArrayList2));
    }
    while ((paramMail == null) || (paramArrayList != null))
    {
      ArrayList localArrayList1;
      ArrayList localArrayList2;
      StringBuilder localStringBuilder1;
      StringBuilder localStringBuilder2;
      StringBuilder localStringBuilder3;
      IMAPBodyStructure localIMAPBodyStructure;
      return;
    }
    Logger.log(6, "IMAPBodyStructureUtil", "uid:" + paramMail.getRemoteId() + " null bodyList");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.protocol.imap.util.IMAPBodyStructureUtil
 * JD-Core Version:    0.7.0.1
 */