package com.tencent.qqmail.maillist;

import android.content.res.Resources;
import android.view.View;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.attachment.model.Attach;
import com.tencent.qqmail.maillist.view.MailListItemView;
import com.tencent.qqmail.maillist.view.MailListItemView.MailListItemData;
import com.tencent.qqmail.model.mail.QMMailManager;
import com.tencent.qqmail.model.qmdomain.Mail;
import com.tencent.qqmail.model.qmdomain.MailContent;
import com.tencent.qqmail.model.qmdomain.MailInformation;
import com.tencent.qqmail.model.qmdomain.MailStatus;
import com.tencent.qqmail.protocol.MailUtil;
import com.tencent.qqmail.search.fragment.SearchListAdapter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SearchListViewHelper
{
  private static String TAG = "SearchListViewHelper";
  
  public static View bindItemData(int paramInt, View paramView, SearchListAdapter paramSearchListAdapter, boolean paramBoolean)
  {
    return ListViewHelper.bindItemData(paramInt, paramView, paramSearchListAdapter, paramBoolean);
  }
  
  private static int farthestIndexOfPunctuation(String paramString, int paramInt1, int paramInt2)
  {
    int j = -1;
    int i = j;
    Object localObject;
    if (paramString != null)
    {
      i = j;
      if (paramInt1 >= 0)
      {
        i = j;
        if (paramInt1 < paramString.length())
        {
          localObject = Pattern.compile("[\\p{Punct}]+");
          if (paramInt2 >= 0) {
            break label100;
          }
          if (paramInt1 + paramInt2 < 0) {
            break label90;
          }
          paramString = paramString.substring(paramInt1 + paramInt2, paramInt1);
          localObject = ((Pattern)localObject).matcher(paramString);
          i = j;
          if (((Matcher)localObject).find()) {
            i = paramInt1 - paramString.length() + ((Matcher)localObject).end() - 1;
          }
        }
      }
    }
    label90:
    label100:
    do
    {
      return i;
      paramString = paramString.substring(0, paramInt1);
      break;
      if (paramInt1 + paramInt2 <= paramString.length()) {
        paramString = paramString.substring(paramInt1, paramInt1 + paramInt2);
      }
      for (;;)
      {
        paramString = ((Pattern)localObject).matcher(paramString);
        for (paramInt2 = -1; paramString.find(); paramInt2 = paramString.start()) {}
        paramString.substring(paramInt1);
      }
      i = j;
    } while (paramInt2 <= 0);
    return paramInt1 + paramInt2;
  }
  
  protected static void fillSubjectAndAbstract(MailListItemView.MailListItemData paramMailListItemData, Mail paramMail, String paramString)
  {
    String[] arrayOfString = MailListItemView.getHightLightKeywords();
    String str = pickSubjectByKeywords(paramMail, arrayOfString);
    paramMailListItemData.subjectTitle = (str + paramString);
    paramMail = pickAbstractContentByKeywords(paramMail, arrayOfString);
    paramMailListItemData.abstractText = (paramMail + paramString);
    paramMailListItemData.canSplitAbstractText = false;
  }
  
  private static String getSubStringAroundKeywords(String paramString, String[] paramArrayOfString, int paramInt1, int paramInt2)
  {
    if ((paramString != null) && (!paramString.equals("")) && (paramArrayOfString != null))
    {
      int i = indexOfKeywords(paramString, paramArrayOfString);
      if (i >= 0)
      {
        if (i < paramInt1) {
          return tryCutContentAtStartButAtLeastMinLength(paramString, 0, paramInt1);
        }
        int j = farthestIndexOfPunctuation(paramString, i, 0 - paramInt1);
        if (j > 0) {
          return tryCutContentAtStartButAtLeastMinLength(paramString, j + 1, paramInt1 >> 1);
        }
        return tryCutContentAtStartButAtLeastMinLength(paramString, i + paramInt2, paramInt1);
      }
    }
    return null;
  }
  
  private static String html2Text(Mail paramMail)
  {
    return MailUtil.getMailAbstract(paramMail.getContent().getBody());
  }
  
  private static int indexOfKeywords(String paramString, String[] paramArrayOfString)
  {
    if (paramString != null)
    {
      paramString = paramString.toLowerCase();
      int j = paramArrayOfString.length;
      int i = 0;
      while (i < j)
      {
        String str = paramArrayOfString[i];
        if ((str != null) && (!str.equals("")))
        {
          int k = paramString.indexOf(str.toLowerCase());
          if (k > 0) {
            return k;
          }
        }
        i += 1;
      }
    }
    return -1;
  }
  
  private static String pickAbstractContentByKeywords(Mail paramMail, String[] paramArrayOfString)
  {
    if ((paramMail == null) || (paramMail.getInformation() == null)) {
      paramMail = "";
    }
    String str;
    label271:
    do
    {
      return paramMail;
      str = paramMail.getInformation().getAbstractContent();
      if ((paramArrayOfString != null) && (paramArrayOfString.length > 0) && (paramArrayOfString[0] != null) && (paramMail != null))
      {
        Object localObject1;
        if (paramMail.getStatus().hasAttach())
        {
          if ((paramMail.getInformation().getBigAttachList() == null) || (paramMail.getInformation().getAttachList() == null)) {
            QMMailManager.sharedInstance().updateMailAttaches(paramMail);
          }
          localObject1 = paramMail.getInformation().getBigAttachList();
          ((ArrayList)localObject1).addAll(paramMail.getInformation().getAttachListNoInlineImg());
          localObject1 = ((ArrayList)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            Object localObject2 = ((Iterator)localObject1).next();
            int i = indexOfKeywords(((Attach)localObject2).getName(), paramArrayOfString);
            if (i >= 0) {
              return "附件：" + tryCutContentAtStartButAtLeastMinLength(((Attach)localObject2).getName(), i, 30);
            }
          }
        }
        if (str != null)
        {
          str = str.trim();
          localObject1 = getSubStringAroundKeywords(str, paramArrayOfString, 30, -2);
          if (localObject1 != null) {
            return localObject1;
          }
        }
        if ((paramMail.getContent() == null) || (paramMail.getContent().getBody() == null))
        {
          QMMailManager.sharedInstance().fillMailContent(paramMail);
          if (paramMail.getContent().getBody() != null) {
            break label271;
          }
          paramMail.getContent().setBody("");
        }
        for (;;)
        {
          paramMail = getSubStringAroundKeywords(paramMail.getContent().getBody(), paramArrayOfString, 30, -2);
          if (paramMail == null) {
            break;
          }
          return paramMail;
          localObject1 = html2Text(paramMail);
          paramMail.getContent().setBody((String)localObject1);
        }
      }
      if (str == null) {
        break;
      }
      paramMail = str;
    } while (!str.equals(""));
    return QMApplicationContext.sharedInstance().getResources().getString(2131693123);
  }
  
  private static String pickSubjectByKeywords(Mail paramMail, String[] paramArrayOfString)
  {
    String str = paramMail.getInformation().getSubject();
    if ((paramArrayOfString != null) && (paramArrayOfString.length > 0) && (paramArrayOfString[0] != null))
    {
      paramMail = getSubStringAroundKeywords(str, paramArrayOfString, 16, 0);
      if (paramMail == null) {}
    }
    do
    {
      return paramMail;
      if (str == null) {
        break;
      }
      paramMail = str;
    } while (!str.equals(""));
    return QMApplicationContext.sharedInstance().getResources().getString(2131693126);
  }
  
  private static String tryCutContentAtStartButAtLeastMinLength(String paramString, int paramInt1, int paramInt2)
  {
    String str = paramString;
    if (paramInt1 > 0)
    {
      if (paramInt1 + paramInt2 <= paramString.length()) {
        break label57;
      }
      str = paramString;
      if (paramString.length() > paramInt2) {
        str = "..." + paramString.substring(paramString.length() - paramInt2);
      }
    }
    return str;
    label57:
    return "..." + paramString.substring(paramInt1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.maillist.SearchListViewHelper
 * JD-Core Version:    0.7.0.1
 */