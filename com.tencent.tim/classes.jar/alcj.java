import android.os.Build;
import android.text.Spannable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabel;
import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class alcj
{
  public static int a(Random paramRandom, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 0;
    case -1: 
      return a(paramRandom, 18, 24);
    case 0: 
      return a(paramRandom, 22, 30);
    case 1: 
      return a(paramRandom, 30, 40);
    }
    return a(paramRandom, 40, 48);
  }
  
  public static int a(Random paramRandom, int paramInt1, int paramInt2)
  {
    return paramRandom.nextInt(paramInt2 - paramInt1) + paramInt1;
  }
  
  private static void a(alci paramalci)
  {
    boolean bool = b(paramalci.text);
    if (((paramalci.cvY) && (paramalci.text.length() <= 5)) || (!bool))
    {
      paramalci.maxEms = 0;
      return;
    }
    paramalci.maxEms = 4;
  }
  
  public static void a(List<alci> paramList, PersonalityLabel paramPersonalityLabel, float paramFloat)
  {
    if ((paramPersonalityLabel == null) || (paramPersonalityLabel.personalityLabelInfos == null) || (paramPersonalityLabel.personalityLabelInfos.size() <= 0)) {
      return;
    }
    ArrayList localArrayList = new ArrayList(paramPersonalityLabel.getSize());
    int i = 0;
    while (i < paramPersonalityLabel.personalityLabelInfos.size())
    {
      localArrayList.add(new Pair(Long.valueOf(((PersonalityLabelInfo)paramPersonalityLabel.personalityLabelInfos.get(i)).id), ((PersonalityLabelInfo)paramPersonalityLabel.personalityLabelInfos.get(i)).text));
      i += 1;
    }
    Collections.sort(localArrayList, new alcj.a());
    int i5 = paramPersonalityLabel.getSize();
    long l2;
    label161:
    long l1;
    label191:
    Object localObject1;
    int j;
    int m;
    int n;
    int k;
    int i3;
    label217:
    Object localObject2;
    if (!TextUtils.isEmpty(paramPersonalityLabel.getLatestThumbUrl()))
    {
      i = 1;
      if (i == 0) {
        break label283;
      }
      l2 = ((PersonalityLabelInfo)paramPersonalityLabel.personalityLabelInfos.get(0)).id;
      if (i == 0) {
        break label299;
      }
      if (paramPersonalityLabel.getSize() <= 1) {
        break label291;
      }
      l1 = ((PersonalityLabelInfo)paramPersonalityLabel.personalityLabelInfos.get(1)).id;
      localObject1 = new Random();
      j = 0;
      m = 0;
      i = 0;
      n = 0;
      k = 0;
      i3 = 0;
      if (i3 >= localArrayList.size()) {
        break label995;
      }
      localObject2 = paramPersonalityLabel.getLabelById(((Long)((Pair)localArrayList.get(i3)).first).longValue());
      if (localObject2 != null) {
        break label320;
      }
    }
    for (int i1 = n;; i1 = n)
    {
      label265:
      i3 += 1;
      n = i1;
      break label217;
      i = 0;
      break;
      label283:
      l2 = -1L;
      break label161;
      label291:
      l1 = -1L;
      break label191;
      label299:
      l1 = ((PersonalityLabelInfo)paramPersonalityLabel.personalityLabelInfos.get(0)).id;
      break label191;
      label320:
      if (!TextUtils.isEmpty(((PersonalityLabelInfo)localObject2).text)) {
        break label338;
      }
    }
    label338:
    String str = ((PersonalityLabelInfo)localObject2).text.trim();
    alci localalci = new alci();
    localalci.text = str;
    boolean bool = b(str);
    label398:
    int i4;
    label420:
    int i2;
    label544:
    label561:
    int i6;
    if (l2 == ((PersonalityLabelInfo)localObject2).id)
    {
      localalci.bgColor = ((PersonalityLabelInfo)localObject2).bgColor;
      localalci.mode = 2;
      localalci.textColor = ((PersonalityLabelInfo)localObject2).fgColor;
      if (localalci.mode != 2) {
        break label886;
      }
      i4 = 1;
      if ((!(str instanceof Spannable)) && (bool) && ((i4 == 0) || (str.length() <= 4)))
      {
        i2 = n;
        if (i4 == 0)
        {
          i2 = n;
          if (str.length() <= 6) {}
        }
      }
      else
      {
        localalci.cvY = true;
        localalci.cvZ = true;
        i2 = n + 1;
      }
      i1 = i2;
      n = i;
      if (!localalci.cvZ)
      {
        if ((i5 > 1) && (i < 2) && (i != i5 - 1) && (str.length() <= 6)) {
          break label892;
        }
        localalci.cvY = true;
        if (localalci.cvY) {
          break label905;
        }
        n = i + 1;
        i1 = i2;
      }
      a(localalci);
      i6 = b(str);
      if (i4 == 0) {
        break label934;
      }
      if (i6 > 6) {
        break label917;
      }
      i = 2;
      label587:
      i2 = i;
      if (i == 2)
      {
        i2 = i;
        if (j >= 3) {
          i2 = 1;
        }
      }
      i = i2;
      if (i5 <= 1) {
        i = 2;
      }
      i2 = j;
      if (i == 2) {
        i2 = j + 1;
      }
      j = i;
      if (i5 <= 3)
      {
        j = i;
        if (i == 0)
        {
          j = i;
          if (m < 2) {
            j = 1;
          }
        }
      }
      i = j;
      if (m + i2 < 2)
      {
        i = j;
        if (j == 0) {
          i = 1;
        }
      }
      if (m < 4) {
        break label1280;
      }
      if (m < 6) {
        break label963;
      }
      i = -1;
    }
    label1280:
    for (;;)
    {
      label698:
      if (i > 0) {}
      for (j = m + 1;; j = m)
      {
        m = a((Random)localObject1, i);
        if ((i5 <= 3) && (i6 < 8) && (k < 2)) {
          m = 48;
        }
        for (;;)
        {
          if (m == 48) {
            k += 1;
          }
          for (;;)
          {
            localalci.textSize = (m * paramFloat);
            localalci.e.setTextSize(localalci.textSize);
            if (QLog.isColorLevel()) {
              QLog.i("TagUtil", 2, "getTags " + localalci.text + " sizeLevel:" + i + " size:" + localalci.textSize / paramFloat);
            }
            paramList.add(localalci);
            m = j;
            j = i2;
            i = n;
            break label265;
            if (l1 != ((PersonalityLabelInfo)localObject2).id) {
              break label398;
            }
            localalci.bold = true;
            localalci.e.setFakeBoldText(true);
            break label398;
            label886:
            i4 = 0;
            break label420;
            label892:
            localalci.cvY = ((Random)localObject1).nextBoolean();
            break label544;
            label905:
            i1 = i2 + 1;
            n = i;
            break label561;
            label917:
            if (i6 <= 8)
            {
              i = 1;
              break label587;
            }
            i = 0;
            break label587;
            label934:
            if (i6 <= 8)
            {
              i = 2;
              break label587;
            }
            if (i6 <= 12)
            {
              i = 1;
              break label587;
            }
            i = 0;
            break label587;
            label963:
            if (i6 >= 10)
            {
              i = -1;
              break label698;
            }
            if ((i6 < 8) || (!((Random)localObject1).nextBoolean())) {
              break label1280;
            }
            i = -1;
            break label698;
            label995:
            if (n == 0)
            {
              paramPersonalityLabel = (alci)paramList.get(0);
              paramPersonalityLabel.cvY = true;
              a(paramPersonalityLabel);
            }
            if ((i == 0) && (i5 > 1))
            {
              j = 0;
              label1033:
              if (j < paramList.size())
              {
                paramPersonalityLabel = (alci)paramList.get(j);
                if ((!paramPersonalityLabel.cvZ) && (paramPersonalityLabel.text.length() <= 4))
                {
                  paramPersonalityLabel.cvY = false;
                  if (!b(paramPersonalityLabel.text))
                  {
                    paramPersonalityLabel.maxEms = 0;
                    label1096:
                    i += 1;
                  }
                }
              }
            }
            for (;;)
            {
              if (i > 1) {
                break label1265;
              }
              j = 0;
              label1108:
              if (j < i5)
              {
                paramPersonalityLabel = (alci)paramList.get(j);
                localObject1 = (String)((Pair)localArrayList.get(j)).second;
                if (!paramPersonalityLabel.cvY) {
                  break label1261;
                }
                if (nX((String)localObject1)) {
                  break label1188;
                }
              }
              label1188:
              label1261:
              for (;;)
              {
                j += 1;
                break label1108;
                break;
                paramPersonalityLabel.maxEms = 4;
                break label1096;
                j += 1;
                break label1033;
                localObject2 = new alci();
                ((alci)localObject2).text = ((CharSequence)localObject1);
                ((alci)localObject2).bTQ = true;
                ((alci)localObject2).cvY = false;
                ((alci)localObject2).textSize = paramPersonalityLabel.textSize;
                ((alci)localObject2).e.setTextSize(paramPersonalityLabel.textSize);
                paramList.add(localObject2);
                k = i + 1;
                i = k;
                if (k >= 2) {
                  return;
                }
              }
            }
            label1265:
            break;
          }
        }
      }
    }
  }
  
  public static boolean atm()
  {
    return Build.MODEL.contains("vivo X6D");
  }
  
  public static int b(CharSequence paramCharSequence)
  {
    int j = 0;
    int i;
    label18:
    int k;
    if ((paramCharSequence instanceof Spannable))
    {
      paramCharSequence = paramCharSequence.toString();
      i = 0;
      if (j >= paramCharSequence.length()) {
        return i;
      }
      k = paramCharSequence.codePointAt(j);
      if ((k < 32) || (k > 126)) {
        break label63;
      }
      i += 1;
    }
    for (;;)
    {
      j += 1;
      break label18;
      paramCharSequence = (String)paramCharSequence;
      break;
      label63:
      if (k >= 65535)
      {
        i += 1;
        j += 1;
      }
      else
      {
        i += 2;
      }
    }
    return i;
  }
  
  public static boolean b(CharSequence paramCharSequence)
  {
    String str = paramCharSequence.toString();
    StringBuilder localStringBuilder = new StringBuilder(1024);
    localStringBuilder.append("text:").append(str).append(" ");
    int i = 0;
    while (i < paramCharSequence.length())
    {
      int j = str.codePointAt(i);
      if ((j >= 19968) && (j <= 40959))
      {
        i += 1;
      }
      else
      {
        localStringBuilder.append("index:").append(i).append(" unicode:").append(j);
        return false;
      }
    }
    return true;
  }
  
  private static boolean nX(String paramString)
  {
    return b(paramString);
  }
  
  static class a
    implements Comparator<Pair<Long, String>>
  {
    public int compare(Pair<Long, String> paramPair1, Pair<Long, String> paramPair2)
    {
      return alcj.b((CharSequence)paramPair1.second) - alcj.b((CharSequence)paramPair2.second);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alcj
 * JD-Core Version:    0.7.0.1
 */