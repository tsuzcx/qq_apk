package com.tencent.qqmail.utilities.common;

import android.text.TextUtils;
import android.util.Base64;
import com.tencent.qqmail.attachment.model.AttachPreview;
import com.tencent.qqmail.attachment.util.QMAttachUtils;
import com.tencent.qqmail.model.qmdomain.MailBigAttach;
import com.tencent.qqmail.model.qmdomain.MailEditAttach;
import com.tencent.qqmail.trd.guava.Lists;
import com.tencent.qqmail.utilities.dateextension.DateExtension;
import com.tencent.qqmail.utilities.fileextention.FileUtil;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMUrlUtil;
import com.tencent.qqmail.utilities.stringextention.StringExtention;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class QMMailContentParser
{
  public static final String CID_TOKEN = "cid:";
  public static String Tag = QMMailContentParser.class.getSimpleName();
  
  public static List<String> findAllCidsAndViewfile(String paramString)
  {
    Object localObject = findAllImages(paramString);
    paramString = Lists.newArrayList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      if ((str.startsWith("cid:")) || (QMUrlUtil.isViewFile(str))) {
        paramString.add(str);
      }
    }
    return paramString;
  }
  
  public static List<String> findAllEntities(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      paramString = Collections.emptyList();
      return paramString;
    }
    Matcher localMatcher = Pattern.compile("src=[\"']?([^<>\"'\\s]*)").matcher(paramString);
    ArrayList localArrayList = Lists.newArrayList();
    for (;;)
    {
      paramString = localArrayList;
      if (!localMatcher.find()) {
        break;
      }
      paramString = localMatcher.group(1);
      if (paramString.startsWith("file://localhost")) {
        localArrayList.add(paramString);
      }
    }
  }
  
  public static List<String> findAllImages(String paramString)
  {
    ArrayList localArrayList = Lists.newArrayList();
    if (paramString == null) {}
    for (;;)
    {
      return localArrayList;
      paramString = Pattern.compile("<img[^>]*?src=([\"'])(.*?)\\1[^>]*?>", 2).matcher(paramString);
      while (paramString.find())
      {
        String str = paramString.group(2);
        if (!localArrayList.contains(str)) {
          localArrayList.add(str);
        }
      }
    }
  }
  
  public static List<String> findAllLocalImages(String paramString)
  {
    Object localObject = findAllImages(paramString);
    paramString = Lists.newArrayList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      if (str.startsWith("file://localhost")) {
        paramString.add(str);
      }
    }
    return paramString;
  }
  
  public static ArrayList<MailBigAttach> findBigAttach(String paramString)
  {
    int i = 0;
    ArrayList localArrayList1 = new ArrayList();
    if ((paramString == null) || (paramString.isEmpty())) {
      return localArrayList1;
    }
    Object localObject1 = "";
    int m;
    boolean bool;
    label73:
    ArrayList localArrayList2;
    String str;
    label101:
    Object localObject2;
    int j;
    if (paramString.contains("FoxmailClientBigAttachEntry"))
    {
      localObject1 = "<div\\s+.*?id\\s*=\\s*\\\"*FoxmailClientBigAttach.*";
      m = 1;
      paramString = Pattern.compile((String)localObject1, 2).matcher(paramString.replaceAll("(\\t|\\r|\\n)*", ""));
      if (!paramString.find()) {
        break label656;
      }
      bool = true;
      if (!bool) {
        break label977;
      }
      localArrayList2 = new ArrayList();
      str = paramString.group();
      if (m == 0) {
        break label662;
      }
      paramString = "(<a style=.*?)</span()>";
      localObject2 = Pattern.compile(paramString, 2);
      paramString = ((Pattern)localObject2).matcher(str);
      i = 0;
      if (m == 0) {
        break label986;
      }
      localObject1 = paramString;
      if (!paramString.find())
      {
        i = 1;
        localObject2 = Pattern.compile("<div class=\\s*.{0,2}FoxmailClientBigAttachEntry(.*?)</span>", 2);
        localObject1 = ((Pattern)localObject2).matcher(str);
      }
      if (((Matcher)localObject1).find()) {
        break label668;
      }
      paramString = Pattern.compile("<div class=\\\"foxmail_hugeattachment_item(.*?)</a></div>", 2).matcher(str);
      i = 0;
      j = 1;
    }
    for (;;)
    {
      label176:
      int i2 = 0;
      int k = 0;
      int i1 = 0;
      int i3 = 0;
      int n;
      if (paramString.find())
      {
        localObject2 = paramString.group(1);
        localArrayList2.add(new MailBigAttach(bool));
        ((MailBigAttach)localArrayList2.get(i)).setOrderIndex(i);
        localObject1 = Pattern.compile("<a.*?href=\\\\?\"([^\"]*)\"", 2).matcher((CharSequence)localObject2);
        n = i1;
        if (((Matcher)localObject1).find())
        {
          localObject1 = ((Matcher)localObject1).group(1);
          n = i1;
          if (localObject1 != null)
          {
            n = i1;
            if (!((String)localObject1).equals(""))
            {
              localObject1 = ((String)localObject1).replace("&amp;", "&");
              ((MailBigAttach)localArrayList2.get(i)).getPreview().setDownloadUrl((String)localObject1);
              n = 1;
            }
          }
        }
        localObject1 = Pattern.compile("<span.*?style=[^>]*>.*?,(.*?) ?(到期|Expired|Expires)?\\)", 2).matcher((CharSequence)localObject2);
        i1 = i2;
        if (((Matcher)localObject1).find())
        {
          localObject1 = ((Matcher)localObject1).group(1);
          if ((!((String)localObject1).contains("年")) && (!((String)localObject1).contains("月"))) {
            break label743;
          }
          localObject1 = DateExtension.getTimeStringFromDate((String)localObject1, DateExtension.sf_y_m_d_h_m_chn);
        }
      }
      label577:
      label596:
      label983:
      for (;;)
      {
        label379:
        i1 = i2;
        if (!((String)localObject1).equals(""))
        {
          ((MailBigAttach)localArrayList2.get(i)).setExpire(Long.parseLong((String)localObject1) * 1000L);
          i1 = 1;
        }
        localObject1 = Pattern.compile("<span.*?style=[^>]*>\\s*\\((.*?),", 2).matcher((CharSequence)localObject2);
        i2 = k;
        if (((Matcher)localObject1).find())
        {
          i2 = k;
          if (((Matcher)localObject1).group(1) != null)
          {
            i2 = k;
            if (!((Matcher)localObject1).group(1).equals(""))
            {
              ((MailBigAttach)localArrayList2.get(i)).setSize(((Matcher)localObject1).group(1).replace(" ", ""));
              i2 = 1;
            }
          }
        }
        if ((m != 0) && (j != 0))
        {
          localObject1 = Pattern.compile(">([^<]*)</a>\\s*<span.*?style=", 2).matcher((CharSequence)localObject2);
          if (((Matcher)localObject1).find())
          {
            k = i3;
            if (((Matcher)localObject1).group(1) != null)
            {
              k = i3;
              if (!((Matcher)localObject1).group(1).equals(""))
              {
                ((MailBigAttach)localArrayList2.get(i)).setName(((Matcher)localObject1).group(1));
                k = 1;
              }
            }
            if ((k == 0) || (i2 == 0) || (n == 0)) {
              break label980;
            }
            if (i1 == 0) {
              break label959;
            }
            localArrayList1.add(localArrayList2.get(i));
            i += 1;
          }
        }
        for (;;)
        {
          break label176;
          if (paramString.contains("foxmail_hugeattachment"))
          {
            localObject1 = "<div\\s+.*?class\\s*=\\s*\\\"*foxmail_hugeattachment.*";
            m = 1;
            break;
          }
          m = i;
          if (!paramString.contains("QQMailBigAttach")) {
            break;
          }
          localObject1 = "<div\\s+.*?id\\s*=\\s*\\\"*QQMailBigAttach.*";
          m = i;
          break;
          bool = false;
          break label73;
          paramString = "<span.*?class=\\s*.{0,2}qqmailbgattach(.*?)</span>\\s*</span>";
          break label101;
          if ((((Matcher)localObject1).group().contains("到期")) || (((Matcher)localObject1).group().contains("Expired")) || (((Matcher)localObject1).group().contains("Expires")))
          {
            paramString = ((Pattern)localObject2).matcher(str);
            k = 0;
            j = i;
            i = k;
            break label176;
          }
          paramString = Pattern.compile("<div class=\\s*.{0,2}FoxmailClientBigAttachEntry(.*?)</span>", 2).matcher(str);
          i = 0;
          j = 1;
          break label176;
          label743:
          if (((String)localObject1).contains("无限期"))
          {
            localObject1 = "-1";
            break label379;
          }
          str = ((String)localObject1).replace("Expires on", "").trim();
          localObject1 = DateExtension.getTimeStringFromDate(str, DateExtension.sf_y_m_d_h_m_eng);
          if (!StringExtention.isNullOrEmpty((String)localObject1)) {
            break label983;
          }
          localObject1 = DateExtension.getTimeStringFromDate(str, DateExtension.mmm_d_yyy_h_m_s);
          break label379;
          localObject1 = Pattern.compile("<span\\s*class\\s*=\\s*\\\"*foxmail_hugeattachment_filename\\s*\\\">(.*?)</span>", 2).matcher((CharSequence)localObject2);
          k = i3;
          if (!((Matcher)localObject1).find()) {
            break label577;
          }
          k = i3;
          if (((Matcher)localObject1).group(1) == null) {
            break label577;
          }
          k = i3;
          if (((Matcher)localObject1).group(1).equals("")) {
            break label577;
          }
          ((MailBigAttach)localArrayList2.get(i)).setName(((Matcher)localObject1).group(1));
          k = 1;
          break label577;
          localObject1 = Pattern.compile("<a.*?href[^>]*>\\s*(.*?)\\s*</a>", 2).matcher((CharSequence)localObject2);
          k = i3;
          if (!((Matcher)localObject1).find()) {
            break label577;
          }
          k = i3;
          if (((Matcher)localObject1).group(1) == null) {
            break label577;
          }
          k = i3;
          if (((Matcher)localObject1).group(1).equals("")) {
            break label577;
          }
          ((MailBigAttach)localArrayList2.get(i)).setName(((Matcher)localObject1).group(1));
          k = 1;
          break label577;
          ((MailBigAttach)localArrayList2.get(i)).setExpire(-2L);
          break label596;
          return localArrayList1;
        }
      }
      label656:
      label662:
      label668:
      label959:
      label977:
      label980:
      label986:
      i = 0;
      j = 0;
    }
  }
  
  public static ArrayList<MailEditAttach> findEditAttach(String paramString)
  {
    int i = 0;
    ArrayList localArrayList1 = new ArrayList();
    if (StringExtention.isNullOrEmpty(paramString)) {
      return localArrayList1;
    }
    String str1 = "";
    if (paramString.contains("QQMailEditAttach")) {
      str1 = "<div\\s+.*?id\\s*=\\s*\\\"*QQMailEditAttach.*";
    }
    paramString = Pattern.compile(str1, 2).matcher(paramString.replaceAll("(\\t|\\r|\\n)*", ""));
    if (paramString.find())
    {
      ArrayList localArrayList2 = new ArrayList();
      paramString = paramString.group();
      Matcher localMatcher1 = Pattern.compile("<span.*?class=\\s*.{0,2}qqmaileditattach(.*?)</span>\\s*</span>", 2).matcher(paramString);
      for (;;)
      {
        if (localMatcher1.find())
        {
          String str2 = localMatcher1.group(1);
          localArrayList2.add(new MailEditAttach(true));
          Matcher localMatcher2 = Pattern.compile("qqmail_editattach_name\\s*=\\s*\"([^\"]*)\"", 2).matcher(str2);
          paramString = "";
          str1 = paramString;
          if (localMatcher2.find()) {
            str1 = localMatcher2.group(1);
          }
          try
          {
            str1 = new String(Base64.decode(str1, 0), "gb18030");
            paramString = str1;
            ((MailEditAttach)localArrayList2.get(i)).setName(paramString);
            str1 = paramString;
            paramString = QMAttachUtils.attachFileType(FileUtil.getFileNameSuffix(str1));
            ((MailEditAttach)localArrayList2.get(i)).setType(paramString);
            paramString = Pattern.compile("https?:\\/\\/res\\.mail\\.qq\\.com\\/zh_CN\\/htmledition\\/images\\/fj\\/fu_(.*)\\.gif", 2).matcher(str2);
            if (paramString.find())
            {
              paramString = paramString.group(1);
              ((MailEditAttach)localArrayList2.get(i)).setIcon(paramString);
            }
            paramString = Pattern.compile("<a(.|\\r|\\n)*?href\\s*=\\s*\"([^\"]*)\"", 2).matcher(str2);
            if (paramString.find())
            {
              paramString = paramString.group(2);
              if ((paramString != null) && (!paramString.equals("")))
              {
                paramString = paramString.replace("&amp;", "&");
                ((MailEditAttach)localArrayList2.get(i)).setUrl(paramString);
              }
            }
            paramString = Pattern.compile("qqmail_editattach_dockey\\s*=\\s*\"([^\"]*)\"", 2).matcher(str2);
            if (paramString.find())
            {
              paramString = paramString.group(1);
              ((MailEditAttach)localArrayList2.get(i)).setKey(paramString);
            }
            paramString = Pattern.compile("qqmail_editattach_size\\s*=\\s*\"([^\"]*)\"", 2).matcher(str2);
            if (paramString.find()) {
              paramString = paramString.group(1);
            }
          }
          catch (Exception localException1)
          {
            try
            {
              str1 = StringExtention.getHumanReadableSizeString(Long.valueOf(paramString).longValue());
              ((MailEditAttach)localArrayList2.get(i)).setSize(str1);
              localArrayList1.add(localArrayList2.get(i));
              i += 1;
              continue;
              localException1 = localException1;
              QMLog.log(6, Tag, "findEditAttach decode name Error");
              localException1.printStackTrace();
            }
            catch (Exception localException2)
            {
              for (;;)
              {
                QMLog.log(6, Tag, "findEditAttach size:" + paramString + ",exception:" + localException2.toString());
              }
            }
          }
        }
      }
    }
    return localArrayList1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.common.QMMailContentParser
 * JD-Core Version:    0.7.0.1
 */