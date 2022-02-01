import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ajnq
{
  public static int a(wkz paramwkz)
  {
    long l1 = paramwkz.getRelationType();
    long l2 = paramwkz.vN();
    if (l1 == 17L)
    {
      if (paramwkz.Rt()) {
        return 999;
      }
      return 0;
    }
    return e(l1, l2);
  }
  
  public static ArrayList<ajnq.a> a(QQAppInterface paramQQAppInterface, String paramString, StringBuilder paramStringBuilder)
  {
    Object localObject = Pattern.compile("#(name|icon)_(\\d+)").matcher(paramStringBuilder);
    ArrayList localArrayList = new ArrayList();
    ajnq.a locala;
    int i;
    if (((Matcher)localObject).find())
    {
      locala = new ajnq.a();
      locala.bRK = ((Matcher)localObject).group();
      locala.djS = ((Matcher)localObject).start();
      locala.id = ((Matcher)localObject).group(2);
      if (locala.arf()) {}
      for (i = 2;; i = 1)
      {
        locala.type = i;
        localArrayList.add(locala);
        break;
      }
    }
    localObject = Pattern.compile("\\(([^\\(]+?)\\)\\[([^\\)]+?)\\]").matcher(paramStringBuilder);
    while (((Matcher)localObject).find())
    {
      locala = new ajnq.a();
      locala.type = 3;
      locala.bRK = ((Matcher)localObject).group();
      locala.djS = ((Matcher)localObject).start();
      locala.key = ((Matcher)localObject).group(1);
      locala.url = ((Matcher)localObject).group(2);
      localArrayList.add(locala);
    }
    localObject = Pattern.compile("#image_url\\{([^\\)]+?)\\}").matcher(paramStringBuilder);
    while (((Matcher)localObject).find())
    {
      locala = new ajnq.a();
      locala.type = 4;
      locala.bRK = ((Matcher)localObject).group();
      locala.djS = ((Matcher)localObject).start();
      locala.url = ((Matcher)localObject).group(1);
      locala.key = locala.bRK;
      localArrayList.add(locala);
    }
    Collections.sort(localArrayList, new ajnr());
    localObject = localArrayList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      locala = (ajnq.a)((Iterator)localObject).next();
      if (!TextUtils.isEmpty(locala.bRK))
      {
        i = paramStringBuilder.indexOf(locala.bRK);
        int j = locala.bRK.length() + i;
        if ((i >= 0) && (j <= paramStringBuilder.length()))
        {
          switch (locala.type)
          {
          }
          for (;;)
          {
            if (locala.key == null) {
              locala.key = locala.bRK;
            }
            locala.start = i;
            locala.end = (locala.key.length() + i);
            paramStringBuilder.replace(i, j, locala.key);
            break;
            locala.key = ajnl.l(paramQQAppInterface, locala.id);
            continue;
            locala.key = ajnl.f(paramQQAppInterface, paramString, locala.id);
          }
        }
      }
    }
    return localArrayList;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Friends paramFriends, ExtensionInfo paramExtensionInfo, wkz paramwkz, acrj paramacrj)
  {
    int i = 2097153;
    wkz.b localb = paramwkz.a();
    if (QLog.isColorLevel()) {
      QLog.i("MutualMarkGrayTipsHelper", 2, "checkAndInsertGrayTips grayInfo:" + localb + " onlinePush:" + paramacrj.bdR);
    }
    int j;
    if ((localb != null) && (localb.isValid()))
    {
      j = 0;
      if (TextUtils.isEmpty(localb.aSK)) {
        break label194;
      }
      paramacrj = localb.aSK;
      switch (paramwkz.changeType)
      {
      default: 
        label168:
        i = 2097155;
      }
    }
    for (;;)
    {
      a(paramQQAppInterface, paramFriends, paramExtensionInfo, paramwkz, localb.aSJ, -5040, i, j, paramacrj);
      return;
      label194:
      paramacrj = paramwkz.friendUin + "_" + paramwkz.changeType + "_" + paramacrj.msgSeq + "_" + localb.HO;
      break;
      j = a(paramwkz);
      continue;
      i = 2097154;
      continue;
      if ((paramwkz.a == null) || (paramwkz.b == null)) {
        break label168;
      }
      if (paramwkz.a.vN() > paramwkz.b.vN())
      {
        i = 2097154;
      }
      else
      {
        if (paramwkz.a.vN() >= paramwkz.b.vN()) {
          break label168;
        }
        j = a(paramwkz);
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Friends paramFriends, ExtensionInfo paramExtensionInfo, wkz paramwkz, String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MutualMarkGrayTipsHelper", 2, "insertGrayTips friendUin:" + paramwkz.friendUin + " grayType:" + paramInt1 + " grayID:" + paramInt2 + " subType:" + paramInt3 + " grayTipKey:" + paramString2 + " _grayTipTemplate:" + paramString1);
    }
    if (TextUtils.isEmpty(paramString1)) {
      return;
    }
    Object localObject = paramString1;
    if (paramString1.contains("#nick")) {
      localObject = paramString1.replaceAll("#nick", aqgv.D(paramQQAppInterface, paramwkz.friendUin));
    }
    localObject = new StringBuilder((String)localObject);
    ajoc.a(paramQQAppInterface, paramFriends, paramExtensionInfo, paramwkz, (StringBuilder)localObject);
    paramString1 = a(paramQQAppInterface, paramwkz.friendUin, (StringBuilder)localObject);
    localObject = ((StringBuilder)localObject).toString();
    ahwa localahwa = new ahwa(paramwkz.friendUin, paramwkz.friendUin, (String)localObject, 0, paramInt1, paramInt2, anaz.gQ());
    MessageForUniteGrayTip localMessageForUniteGrayTip = new MessageForUniteGrayTip();
    localMessageForUniteGrayTip.hasRead = 0;
    localMessageForUniteGrayTip.subType = paramInt3;
    localMessageForUniteGrayTip.initGrayTipMsg(paramQQAppInterface, localahwa);
    localMessageForUniteGrayTip.tipParam.bLT = paramString2;
    if (paramInt3 == 998) {
      localMessageForUniteGrayTip.caidanAnimUrl = paramwkz.pg();
    }
    for (;;)
    {
      a(paramQQAppInterface, (String)localObject, localahwa, paramString1);
      localMessageForUniteGrayTip.saveExtInfoToExtStr("mutualmark_id", ajnu.i(paramwkz.getRelationType(), paramwkz.vN()));
      ajoc.a(paramQQAppInterface, paramFriends, paramExtensionInfo, paramwkz, (String)localObject, localahwa, paramString1);
      ahwb.a(paramQQAppInterface, localMessageForUniteGrayTip);
      ajnk.b(paramQQAppInterface, localMessageForUniteGrayTip, localMessageForUniteGrayTip.tipParam.dbK);
      return;
      if (paramInt3 == 999)
      {
        localMessageForUniteGrayTip.caidanAnimUrl = paramwkz.ph();
        localMessageForUniteGrayTip.caidanAnimUrlMd5 = paramwkz.pi();
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, ahwa paramahwa, ArrayList<ajnq.a> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.isEmpty())) {}
    for (;;)
    {
      return;
      paramQQAppInterface = paramArrayList.iterator();
      while (paramQQAppInterface.hasNext())
      {
        paramString = (ajnq.a)paramQQAppInterface.next();
        if (QLog.isColorLevel()) {
          QLog.d("MutualMarkGrayTipsHelper", 2, "handleHighlightInfo item=" + paramString);
        }
        switch (paramString.type)
        {
        default: 
          break;
        case 1: 
          if (!TextUtils.isEmpty(paramString.key))
          {
            paramArrayList = new Bundle();
            paramArrayList.putInt("key_action", 11);
            paramArrayList.putString("key_action_DATA", paramString.key);
            paramahwa.addHightlightItem(paramString.start, paramString.end, paramArrayList);
          }
          break;
        case 2: 
          if (!TextUtils.isEmpty(paramString.key))
          {
            paramArrayList = new Bundle();
            paramArrayList.putString("image_resource", paramString.key);
            paramahwa.addHightlightItem(paramString.start, paramString.end, paramArrayList);
          }
          break;
        case 3: 
          if (!TextUtils.isEmpty(paramString.key))
          {
            paramArrayList = new Bundle();
            paramArrayList.putInt("key_action", 1);
            paramArrayList.putString("key_action_DATA", paramString.url);
            paramahwa.addHightlightItem(paramString.start, paramString.end, paramArrayList);
          }
          break;
        case 4: 
          if (!TextUtils.isEmpty(paramString.key))
          {
            paramArrayList = new Bundle();
            paramArrayList.putString("image_resource", paramString.key);
            paramahwa.addHightlightItem(paramString.start, paramString.end, paramArrayList);
          }
          break;
        }
      }
    }
  }
  
  public static int e(long paramLong1, long paramLong2)
  {
    if ((paramLong1 > 0L) && (paramLong2 >= 0L)) {
      return ajnu.f(paramLong1, paramLong2);
    }
    return 0;
  }
  
  public static class a
  {
    public String bRK;
    public int djS;
    public int end;
    public String id;
    public String key;
    public int start;
    public int type = 0;
    public String url;
    
    public boolean arf()
    {
      if (this.bRK != null) {
        return this.bRK.contains("icon");
      }
      return false;
    }
    
    @NonNull
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("GrayTipHighlightItemInfo{");
      localStringBuilder.append("old_key:").append(this.bRK).append(", ");
      localStringBuilder.append("old_start:").append(this.djS).append(", ");
      localStringBuilder.append("id:").append(this.id).append(", ");
      localStringBuilder.append("start:").append(this.start).append(", ");
      localStringBuilder.append("end:").append(this.end).append(", ");
      localStringBuilder.append("key:").append(this.key).append(", ");
      localStringBuilder.append("url:").append(this.url).append(", ");
      localStringBuilder.append("}");
      return localStringBuilder.toString();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajnq
 * JD-Core Version:    0.7.0.1
 */