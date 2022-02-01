package com.tencent.mobileqq.utils;

import android.support.v4.util.LruCache;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChnToSpell
{
  private static LruCache<String, b> D = new LruCache(1024);
  private static LruCache<String, b> E = new LruCache(1024);
  private static LruCache<String, c> F = new LruCache(1024);
  public static final String[] hN = { "?", "a", "ai", "an", "ang", "ao", "ba", "bai", "ban", "bang", "bao", "bei", "ben", "beng", "bi", "bian", "biao", "bie", "bin", "bing", "bo", "bu", "ca", "cai", "can", "cang", "cao", "ce", "ceng", "cha", "chai", "chan", "chang", "chao", "che", "chen", "cheng", "chi", "chong", "chou", "chu", "chuai", "chuan", "chuang", "chui", "chun", "chuo", "ci", "cong", "cou", "cu", "cuan", "cui", "cun", "cuo", "da", "dai", "dan", "dang", "dao", "de", "deng", "di", "dian", "diao", "die", "ding", "diu", "dong", "dou", "du", "duan", "dui", "dun", "duo", "e", "en", "er", "fa", "fan", "fang", "fei", "fen", "feng", "fu", "fou", "ga", "gai", "gan", "gang", "gao", "ge", "ji", "gen", "geng", "gong", "gou", "gu", "gua", "guai", "guan", "guang", "gui", "gun", "guo", "ha", "hai", "han", "hang", "hao", "he", "hei", "hen", "heng", "hong", "hou", "hu", "hua", "huai", "huan", "huang", "hui", "hun", "huo", "jia", "jian", "jiang", "qiao", "jiao", "jie", "jin", "jing", "jiong", "jiu", "ju", "juan", "jue", "jun", "ka", "kai", "kan", "kang", "kao", "ke", "ken", "keng", "kong", "kou", "ku", "kua", "kuai", "kuan", "kuang", "kui", "kun", "kuo", "la", "lai", "lan", "lang", "lao", "le", "lei", "leng", "li", "lia", "lian", "liang", "liao", "lie", "lin", "ling", "liu", "long", "lou", "lu", "luan", "lue", "lun", "luo", "ma", "mai", "man", "mang", "mao", "me", "mei", "men", "meng", "mi", "mian", "miao", "mie", "min", "ming", "miu", "mo", "mou", "mu", "na", "nai", "nan", "nang", "nao", "ne", "nei", "nen", "neng", "ni", "nian", "niang", "niao", "nie", "nin", "ning", "niu", "nong", "nu", "nuan", "nue", "yao", "nuo", "o", "ou", "pa", "pai", "pan", "pang", "pao", "pei", "pen", "peng", "pi", "pian", "piao", "pie", "pin", "ping", "po", "pou", "pu", "qi", "qia", "qian", "qiang", "qie", "qin", "qing", "qiong", "qiu", "qu", "quan", "que", "qun", "ran", "rang", "rao", "re", "ren", "reng", "ri", "rong", "rou", "ru", "ruan", "rui", "run", "ruo", "sa", "sai", "san", "sang", "sao", "se", "sen", "seng", "sha", "shai", "shan", "shang", "shao", "she", "shen", "sheng", "shi", "shou", "shu", "shua", "shuai", "shuan", "shuang", "shui", "shun", "shuo", "si", "song", "sou", "su", "suan", "sui", "sun", "suo", "ta", "tai", "tan", "tang", "tao", "te", "teng", "ti", "tian", "tiao", "tie", "ting", "tong", "tou", "tu", "tuan", "tui", "tun", "tuo", "wa", "wai", "wan", "wang", "wei", "wen", "weng", "wo", "wu", "xi", "xia", "xian", "xiang", "xiao", "xie", "xin", "xing", "xiong", "xiu", "xu", "xuan", "xue", "xun", "ya", "yan", "yang", "ye", "yi", "yin", "ying", "yo", "yong", "you", "yu", "yuan", "yue", "yun", "za", "zai", "zan", "zang", "zao", "ze", "zei", "zen", "zeng", "zha", "zhai", "zhan", "zhang", "zhao", "zhe", "zhen", "zheng", "zhi", "zhong", "zhou", "zhu", "zhua", "zhuai", "zhuan", "zhuang", "zhui", "zhun", "zhuo", "zi", "zong", "zou", "zu", "zuan", "zui", "zun", "zuo", "ei", "m", "n", "dia", "cen", "nou", "jv", "qv", "xv", "lv", "nv" };
  public static final String[] hO = { "?", "a", "ai", "an", "ang", "ao", "b-a", "b-ai", "b-an", "b-ang", "b-ao", "b-ei", "b-en", "b-eng", "b-i", "b-ian", "b-iao", "b-ie", "b-in", "b-ing", "b-o", "b-u", "c-a", "c-ai", "c-an", "c-ang", "c-ao", "c-e", "c-eng", "ch-a", "ch-ai", "ch-an", "ch-ang", "ch-ao", "ch-e", "ch-en", "ch-eng", "ch-i", "ch-ong", "ch-ou", "ch-u", "ch-uai", "ch-uan", "ch-uang", "ch-ui", "ch-un", "ch-uo", "c-i", "c-ong", "c-ou", "c-u", "c-uan", "c-ui", "c-un", "c-uo", "d-a", "d-ai", "d-an", "d-ang", "d-ao", "d-e", "d-eng", "d-i", "d-ian", "d-iao", "d-ie", "d-ing", "d-iu", "d-ong", "d-ou", "d-u", "d-uan", "d-ui", "d-un", "d-uo", "e", "en", "er", "f-a", "f-an", "f-ang", "f-ei", "f-en", "f-eng", "f-u", "f-ou", "g-a", "g-ai", "g-an", "g-ang", "g-ao", "g-e", "j-i", "g-en", "g-eng", "g-ong", "g-ou", "g-u", "g-ua", "g-uai", "g-uan", "g-uang", "g-ui", "g-un", "g-uo", "h-a", "h-ai", "h-an", "h-ang", "h-ao", "h-e", "h-ei", "h-en", "h-eng", "h-ong", "h-ou", "h-u", "h-ua", "h-uai", "h-uan", "h-uang", "h-ui", "h-un", "h-uo", "j-ia", "j-ian", "j-iang", "q-iao", "j-iao", "j-ie", "j-in", "j-ing", "j-iong", "j-iu", "j-u", "j-uan", "j-ue", "j-un", "k-a", "k-ai", "k-an", "k-ang", "k-ao", "k-e", "k-en", "k-eng", "k-ong", "k-ou", "k-u", "k-ua", "k-uai", "k-uan", "k-uang", "k-ui", "k-un", "k-uo", "l-a", "l-ai", "l-an", "l-ang", "l-ao", "l-e", "l-ei", "l-eng", "l-i", "l-ia", "l-ian", "l-iang", "l-iao", "l-ie", "l-in", "l-ing", "l-iu", "l-ong", "l-ou", "l-u", "l-uan", "l-ue", "l-un", "l-uo", "m-a", "m-ai", "m-an", "m-ang", "m-ao", "m-e", "m-ei", "m-en", "m-eng", "m-i", "m-ian", "m-iao", "m-ie", "m-in", "m-ing", "m-iu", "m-o", "m-ou", "m-u", "n-a", "n-ai", "n-an", "n-ang", "n-ao", "n-e", "n-ei", "n-en", "n-eng", "n-i", "n-ian", "n-iang", "n-iao", "n-ie", "n-in", "n-ing", "n-iu", "n-ong", "n-u", "n-uan", "n-ue", "y-ao", "n-uo", "o", "ou", "p-a", "p-ai", "p-an", "p-ang", "p-ao", "p-ei", "p-en", "p-eng", "p-i", "p-ian", "p-iao", "p-ie", "p-in", "p-ing", "p-o", "p-ou", "p-u", "q-i", "q-ia", "q-ian", "q-iang", "q-ie", "q-in", "q-ing", "q-iong", "q-iu", "q-u", "q-uan", "q-ue", "q-un", "r-an", "r-ang", "r-ao", "r-e", "r-en", "r-eng", "r-i", "r-ong", "r-ou", "r-u", "r-uan", "r-ui", "r-un", "r-uo", "s-a", "s-ai", "s-an", "s-ang", "s-ao", "s-e", "s-en", "s-eng", "sh-a", "sh-ai", "sh-an", "sh-ang", "sh-ao", "sh-e", "sh-en", "sh-eng", "sh-i", "sh-ou", "sh-u", "sh-ua", "sh-uai", "sh-uan", "sh-uang", "sh-ui", "sh-un", "sh-uo", "s-i", "s-ong", "s-ou", "s-u", "s-uan", "s-ui", "s-un", "s-uo", "t-a", "t-ai", "t-an", "t-ang", "t-ao", "t-e", "t-eng", "t-i", "t-ian", "t-iao", "t-ie", "t-ing", "t-ong", "t-ou", "t-u", "t-uan", "t-ui", "t-un", "t-uo", "w-a", "w-ai", "w-an", "w-ang", "w-ei", "w-en", "w-eng", "w-o", "w-u", "x-i", "x-ia", "x-ian", "x-iang", "x-iao", "x-ie", "x-in", "x-ing", "x-iong", "x-iu", "x-u", "x-uan", "x-ue", "x-un", "y-a", "y-an", "y-ang", "y-e", "y-i", "y-in", "y-ing", "y-o", "y-ong", "y-ou", "y-u", "y-uan", "y-ue", "y-un", "z-a", "z-ai", "z-an", "z-ang", "z-ao", "z-e", "z-ei", "z-en", "z-eng", "zh-a", "zh-ai", "zh-an", "zh-ang", "zh-ao", "zh-e", "zh-en", "zh-eng", "zh-i", "zh-ong", "zh-ou", "zh-u", "zh-ua", "zh-uai", "zh-uan", "zh-uang", "zh-ui", "zh-un", "zh-uo", "z-i", "z-ong", "z-ou", "z-u", "z-uan", "z-ui", "z-un", "z-uo", "ei", "m", "n", "d-ia", "c-en", "n-ou", "j-v", "q-v", "x-v", "l-v", "n-v" };
  private static final String[] hP = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "50", "100", "500", "1000" };
  private static final int[] oX;
  private static Map<String, String[]> og = new HashMap();
  private static short[] p;
  
  static
  {
    oX = new int[] { 0, 47, 58, 64, 91, 96, 123, 8543, 8576, 12295, 19967, 40870, 65280, 65375, 2147483647 };
  }
  
  public static a a(char paramChar)
  {
    a locala = new a();
    switch (Arrays.binarySearch(oX, paramChar))
    {
    default: 
      locala.range = 6;
      locala.csW = String.valueOf(paramChar);
      return locala;
    case -12: 
      locala.range = 1;
      locala.csW = String.valueOf(paramChar);
      return locala;
    case -5: 
      locala.range = 2;
      locala.csW = String.valueOf(paramChar);
      return locala;
    case -7: 
      locala.range = 3;
      locala.csW = String.valueOf(paramChar);
      return locala;
    case -3: 
      locala.range = 4;
      locala.csW = String.valueOf(paramChar);
      return locala;
    }
    locala.range = 5;
    locala.csW = String.valueOf(Character.toLowerCase((char)(paramChar - 65248)));
    return locala;
  }
  
  public static a a(char paramChar, int paramInt)
  {
    a locala = new a();
    if (paramInt == 0)
    {
      if (paramChar == '单')
      {
        locala.range = 5;
        locala.csW = "shan";
        return locala;
      }
      if (paramChar == '仇')
      {
        locala.range = 5;
        locala.csW = "qiu";
        return locala;
      }
      if (paramChar == '曾')
      {
        locala.range = 5;
        locala.csW = "zeng";
        return locala;
      }
    }
    switch (Arrays.binarySearch(oX, paramChar))
    {
    default: 
      if (Character.isHighSurrogate(paramChar))
      {
        locala.range = 0;
        locala.csW = "??";
      }
      break;
    }
    for (;;)
    {
      return locala;
      int i = paramChar - 'Ⅰ';
      paramInt = i;
      if (i >= hP.length) {
        paramInt = i - hP.length;
      }
      locala.range = 1;
      locala.csW = hP[paramInt];
      continue;
      locala.range = 2;
      locala.csW = "ling";
      continue;
      locala.range = 4;
      locala.csW = String.valueOf(paramChar);
      continue;
      locala.range = 3;
      locala.csW = String.valueOf(paramChar);
      continue;
      locala.range = 5;
      locala.csW = hN[p[(paramChar - '一')]];
      continue;
      locala.range = 6;
      locala.csW = String.valueOf(Character.toLowerCase((char)(paramChar - 65248)));
      continue;
      locala.range = 0;
      locala.csW = String.valueOf(paramChar);
    }
  }
  
  public static b a(String paramString, int paramInt)
  {
    if ((paramString == null) || (paramString.length() == 0))
    {
      localObject1 = new b();
      ((b)localObject1).mode = paramInt;
      ((b)localObject1).IJ = new ArrayList();
      ((b)localObject1).csX = "";
    }
    do
    {
      return localObject1;
      if (paramInt != 1) {
        break;
      }
      localObject2 = (b)D.get(paramString);
      localObject1 = localObject2;
    } while (localObject2 != null);
    Object localObject1 = new b();
    ((b)localObject1).mode = paramInt;
    ((b)localObject1).IJ = new ArrayList();
    if (p == null) {
      edH();
    }
    Object localObject2 = new StringBuilder();
    int n = paramString.length();
    int j = paramString.charAt(0);
    if (j == 21333) {
      if (paramInt == 1)
      {
        ((StringBuilder)localObject2).append("shan");
        label153:
        ((b)localObject1).IJ.add(Integer.valueOf(0));
        j = 1;
      }
    }
    for (;;)
    {
      label170:
      if (j < n)
      {
        int i = paramString.charAt(j);
        ((b)localObject1).IJ.add(Integer.valueOf(((StringBuilder)localObject2).length()));
        switch (Arrays.binarySearch(oX, i))
        {
        default: 
          if (Character.isHighSurrogate(i))
          {
            ((StringBuilder)localObject2).append('?');
            ((b)localObject1).IJ.add(Integer.valueOf(((StringBuilder)localObject2).length()));
            ((StringBuilder)localObject2).append('?');
            j += 1;
          }
          break;
        }
        for (;;)
        {
          j += 1;
          break label170;
          if (paramInt != 2) {
            break;
          }
          localObject1 = (b)E.get(paramString);
          if (localObject1 == null) {
            break;
          }
          return localObject1;
          if (paramInt != 2) {
            break label153;
          }
          ((StringBuilder)localObject2).append('s');
          break label153;
          if (j == 20167)
          {
            if (paramInt == 1) {
              ((StringBuilder)localObject2).append("qiu");
            }
            for (;;)
            {
              ((b)localObject1).IJ.add(Integer.valueOf(0));
              j = 1;
              break;
              if (paramInt == 2) {
                ((StringBuilder)localObject2).append('q');
              }
            }
          }
          if (j == 26366)
          {
            if (paramInt == 1) {
              ((StringBuilder)localObject2).append("zeng");
            }
            for (;;)
            {
              ((b)localObject1).IJ.add(Integer.valueOf(0));
              j = 1;
              break;
              if (paramInt == 2) {
                ((StringBuilder)localObject2).append('z');
              }
            }
          }
          if (j == 19975)
          {
            if ((paramString.length() <= 1) || (paramString.charAt(1) != '俟')) {
              break label954;
            }
            if (paramInt == 1)
            {
              ((StringBuilder)localObject2).append("moqi");
              ((b)localObject1).IJ.add(Integer.valueOf(0));
              ((b)localObject1).IJ.add(Integer.valueOf(2));
            }
            for (;;)
            {
              j = 2;
              break;
              if (paramInt == 2)
              {
                ((StringBuilder)localObject2).append("mq");
                ((b)localObject1).IJ.add(Integer.valueOf(0));
                ((b)localObject1).IJ.add(Integer.valueOf(1));
              }
            }
          }
          if ((j != 37325) || (paramString.length() <= 1)) {
            break label954;
          }
          if (paramString.charAt(1) == '庆') {
            if (paramInt == 1)
            {
              ((StringBuilder)localObject2).append("chongqing");
              ((b)localObject1).IJ.add(Integer.valueOf(0));
              ((b)localObject1).IJ.add(Integer.valueOf(5));
            }
          }
          for (;;)
          {
            j = 2;
            break;
            if (paramInt == 2)
            {
              ((StringBuilder)localObject2).append("cq");
              ((b)localObject1).IJ.add(Integer.valueOf(0));
              ((b)localObject1).IJ.add(Integer.valueOf(1));
              continue;
              ((StringBuilder)localObject2).append("z");
            }
          }
          int m = i - 8544;
          int k = m;
          if (m >= hP.length) {
            k = m - hP.length;
          }
          ((StringBuilder)localObject2).append(hP[k]);
          continue;
          if (paramInt == 1)
          {
            ((StringBuilder)localObject2).append("ling");
          }
          else
          {
            ((StringBuilder)localObject2).append('l');
            continue;
            ((StringBuilder)localObject2).append(Character.toLowerCase(i));
            continue;
            ((StringBuilder)localObject2).append(i);
            continue;
            if (paramInt == 1)
            {
              ((StringBuilder)localObject2).append(hN[p[(i - 19968)]]);
            }
            else
            {
              ((StringBuilder)localObject2).append(hN[p[(i - 19968)]].charAt(0));
              continue;
              ((StringBuilder)localObject2).append(Character.toLowerCase((char)(i - 65248)));
              continue;
              ((StringBuilder)localObject2).append(i);
            }
          }
        }
      }
      ((b)localObject1).csX = ((StringBuilder)localObject2).toString();
      if (paramInt == 1) {
        D.put(paramString, localObject1);
      }
      for (;;)
      {
        return localObject1;
        if (paramInt == 2) {
          E.put(paramString, localObject1);
        }
      }
      label954:
      j = 0;
    }
  }
  
  public static c a(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      localObject1 = null;
    }
    do
    {
      return localObject1;
      localObject2 = (c)F.get(paramString);
      localObject1 = localObject2;
    } while (localObject2 != null);
    Object localObject1 = new c();
    ((c)localObject1).IJ = new ArrayList();
    ((c)localObject1).IK = new ArrayList();
    ((c)localObject1).IL = new ArrayList();
    ((c)localObject1).IM = new ArrayList();
    if (p == null) {
      edH();
    }
    Object localObject2 = new StringBuilder();
    StringBuilder localStringBuilder1 = new StringBuilder();
    StringBuilder localStringBuilder2 = new StringBuilder();
    int n = paramString.length();
    int j = paramString.charAt(0);
    if (j == 21333)
    {
      ((StringBuilder)localObject2).append("shan");
      localStringBuilder1.append('s');
      localStringBuilder2.append("sh-an").append("#");
      ((c)localObject1).IK.add(Integer.valueOf(0));
      ((c)localObject1).IL.add(Integer.valueOf(0));
      ((c)localObject1).IM.add(Integer.valueOf(0));
      j = 1;
    }
    for (;;)
    {
      if (j < n)
      {
        int i = paramString.charAt(j);
        ((c)localObject1).IK.add(Integer.valueOf(((StringBuilder)localObject2).length()));
        ((c)localObject1).IL.add(Integer.valueOf(localStringBuilder1.length()));
        ((c)localObject1).IM.add(Integer.valueOf(localStringBuilder2.length()));
        if ((i == 45) || (i == 35))
        {
          ((StringBuilder)localObject2).append(i);
          localStringBuilder1.append(i);
          localStringBuilder2.append('0').append("#");
        }
        for (;;)
        {
          j += 1;
          break;
          if (j == 20167)
          {
            ((StringBuilder)localObject2).append("qiu");
            localStringBuilder1.append('q');
            localStringBuilder2.append("q-iu").append("#");
            ((c)localObject1).IK.add(Integer.valueOf(0));
            ((c)localObject1).IL.add(Integer.valueOf(0));
            ((c)localObject1).IM.add(Integer.valueOf(0));
            j = 1;
            break;
          }
          if (j != 26366) {
            break label1133;
          }
          ((StringBuilder)localObject2).append("zeng");
          localStringBuilder1.append('z');
          localStringBuilder2.append("z-eng").append("#");
          ((c)localObject1).IK.add(Integer.valueOf(0));
          ((c)localObject1).IL.add(Integer.valueOf(0));
          ((c)localObject1).IM.add(Integer.valueOf(0));
          j = 1;
          break;
          switch (Arrays.binarySearch(oX, i))
          {
          default: 
            if (Character.isHighSurrogate(i))
            {
              ((StringBuilder)localObject2).append('?');
              localStringBuilder1.append('?');
              localStringBuilder2.append('?').append("#");
              ((c)localObject1).IK.add(Integer.valueOf(((StringBuilder)localObject2).length()));
              ((c)localObject1).IL.add(Integer.valueOf(localStringBuilder1.length()));
              ((c)localObject1).IM.add(Integer.valueOf(localStringBuilder2.length()));
              ((StringBuilder)localObject2).append('?');
              localStringBuilder1.append('?');
              localStringBuilder2.append('?').append("#");
              j += 1;
            }
            break;
          case -9: 
            int m = i - 8544;
            int k = m;
            if (m >= hP.length) {
              k = m - hP.length;
            }
            ((StringBuilder)localObject2).append(hP[k]);
            localStringBuilder1.append(hP[k]);
            localStringBuilder2.append(hP[k]).append("#");
            break;
          case 7: 
            ((StringBuilder)localObject2).append("ling");
            localStringBuilder1.append('l');
            localStringBuilder2.append("l-ing").append("#");
            break;
          case -5: 
            ((StringBuilder)localObject2).append(Character.toLowerCase(i));
            localStringBuilder1.append(Character.toLowerCase(i));
            localStringBuilder2.append(Character.toLowerCase(i)).append("#");
            break;
          case -7: 
            ((StringBuilder)localObject2).append(i);
            localStringBuilder1.append(i);
            localStringBuilder2.append(i).append("#");
            break;
          case -12: 
            ((StringBuilder)localObject2).append(hN[p[(i - 19968)]]);
            localStringBuilder1.append(hN[p[(i - 19968)]].charAt(0));
            localStringBuilder2.append(hO[p[(i - 19968)]]).append("#");
            break;
          case -14: 
            ((StringBuilder)localObject2).append(Character.toLowerCase((char)(i - 65248)));
            localStringBuilder1.append(Character.toLowerCase((char)(i - 65248)));
            localStringBuilder2.append(Character.toLowerCase((char)(i - 65248))).append("#");
            continue;
            ((StringBuilder)localObject2).append('?');
            localStringBuilder1.append('?');
            localStringBuilder2.append('?').append("#");
          }
        }
      }
      if (localStringBuilder2.length() > 0) {
        localStringBuilder2.deleteCharAt(localStringBuilder2.length() - 1);
      }
      ((c)localObject1).csX = ((StringBuilder)localObject2).toString();
      ((c)localObject1).IJ = ((c)localObject1).IK;
      ((c)localObject1).csY = ((StringBuilder)localObject2).toString();
      ((c)localObject1).csZ = localStringBuilder1.toString();
      ((c)localObject1).cta = localStringBuilder2.toString();
      F.put(paramString, localObject1);
      return localObject1;
      label1133:
      j = 0;
    }
  }
  
  public static String aJ(String paramString, int paramInt)
  {
    return a(paramString, paramInt).csX;
  }
  
  private static void edG()
  {
    if (og.isEmpty())
    {
      og.put("单", new String[] { "shan", "dan", "chan" });
      og.put("折", new String[] { "zhe", "she" });
      og.put("着", new String[] { "zhao", "zhuo", "zhe" });
      og.put("蕃", new String[] { "bo", "fan" });
      og.put("沓", new String[] { "da", "ta" });
      og.put("曝", new String[] { "pu", "bao" });
      og.put("和", new String[] { "he", "huo", "hu" });
      og.put("省", new String[] { "sheng", "xing" });
      og.put("拗", new String[] { "niu", "ao" });
      og.put("臭", new String[] { "chou", "xiu" });
      og.put("度", new String[] { "du", "duo" });
      og.put("差", new String[] { "cha", "chai" });
      og.put("扎", new String[] { "zha", "za" });
      og.put("埋", new String[] { "man", "mai" });
      og.put("盛", new String[] { "sheng", "cheng" });
      og.put("伧", new String[] { "chen", "cang" });
      og.put("伯", new String[] { "bo", "bai" });
      og.put("疟", new String[] { "yao", "nue" });
      og.put("行", new String[] { "hang", "xing" });
      og.put("艾", new String[] { "ai", "yi" });
      og.put("传", new String[] { "chuan", "zhuan" });
      og.put("奇", new String[] { "ji", "qi" });
      og.put("炮", new String[] { "pao", "bao" });
      og.put("给", new String[] { "gei", "ji" });
      og.put("巷", new String[] { "hang", "xiang" });
      og.put("薄", new String[] { "bo", "bao" });
      og.put("簿", new String[] { "bo", "bu" });
      og.put("拓", new String[] { "ta", "tuo" });
      og.put("恶", new String[] { "e", "wu" });
      og.put("便", new String[] { "pian", "bian" });
      og.put("宿", new String[] { "xiu", "su" });
      og.put("藏", new String[] { "zang", "cang" });
      og.put("轧", new String[] { "zha", "ya" });
      og.put("卡", new String[] { "ka", "qia" });
      og.put("调", new String[] { "tiao", "diao" });
      og.put("模", new String[] { "mo", "mu" });
      og.put("没", new String[] { "mei", "mo" });
      og.put("殷", new String[] { "yan", "yin" });
      og.put("还", new String[] { "huan", "hai" });
      og.put("系", new String[] { "xi", "ji" });
      og.put("降", new String[] { "xiang", "jiang" });
      og.put("脯", new String[] { "pu", "fu" });
      og.put("石", new String[] { "dan", "shi" });
      og.put("劲", new String[] { "jing", "jin" });
      og.put("茄", new String[] { "jia", "qie" });
      og.put("刨", new String[] { "bao", "pao" });
      og.put("弹", new String[] { "dan", "tan" });
      og.put("颤", new String[] { "zhan", "chan" });
      og.put("扒", new String[] { "ba", "pa" });
      og.put("数", new String[] { "shu", "shuo" });
      og.put("参", new String[] { "cen", "shen", "can" });
      og.put("会", new String[] { "hui", "kuai" });
      og.put("吓", new String[] { "xia", "he" });
      og.put("胖", new String[] { "pang", "pan" });
      og.put("耙", new String[] { "ba", "pa" });
      og.put("伺", new String[] { "si", "ci" });
      og.put("咳", new String[] { "hai", "ke" });
      og.put("囤", new String[] { "dun", "tun" });
      og.put("澄", new String[] { "deng", "cheng" });
      og.put("得", new String[] { "de", "dei" });
      og.put("屏", new String[] { "ping", "bing" });
      og.put("乐", new String[] { "yue", "le" });
      og.put("了", new String[] { "liao", "le" });
      og.put("吭", new String[] { "keng", "hang" });
      og.put("粘", new String[] { "nian", "zhan" });
      og.put("畜", new String[] { "xu", "chu" });
      og.put("称", new String[] { "chen", "cheng" });
      og.put("弄", new String[] { "long", "nong" });
      og.put("俩", new String[] { "lia", "liang" });
      og.put("露", new String[] { "lu", "lou" });
      og.put("重", new String[] { "zhong", "chong" });
      og.put("率", new String[] { "shuai", "lu" });
      og.put("泊", new String[] { "bo", "po" });
      og.put("朝", new String[] { "chao", "zhao" });
      og.put("校", new String[] { "xiao", "jiao" });
      og.put("强", new String[] { "qiang", "jiang" });
      og.put("塞", new String[] { "se", "sai" });
      og.put("辟", new String[] { "bi", "pi" });
      og.put("都", new String[] { "du", "dou" });
      og.put("匙", new String[] { "chi", "shi" });
      og.put("查", new String[] { "zha", "cha" });
      og.put("曾", new String[] { "zeng", "ceng" });
      og.put("解", new String[] { "xie", "jie" });
      og.put("颉", new String[] { "xie", "jie", "jia" });
      og.put("莘", new String[] { "shen", "xin" });
      og.put("召", new String[] { "shao", "zhao" });
      og.put("仇", new String[] { "qiu", "chou" });
      og.put("区", new String[] { "ou", "qu" });
      og.put("圈", new String[] { "juan", "quan" });
      og.put("炅", new String[] { "gui", "jiong" });
      og.put("秘", new String[] { "bi", "mi", "bei" });
      og.put("尉", new String[] { "wei" });
      og.put("万", new String[] { "wan", "mo" });
      og.put("覃", new String[] { "qin", "tan", "xun" });
      og.put("隗", new String[] { "kui", "wei", "yu" });
      og.put("宓", new String[] { "fu", "mi" });
      og.put("郇", new String[] { "huan", "xun" });
      og.put("种", new String[] { "zhong", "chong" });
      og.put("嚼", new String[] { "jiao", "jue" });
      og.put("咽", new String[] { "yan", "ye" });
      og.put("落", new String[] { "la", "luo" });
      og.put("乘", new String[] { "cheng", "sheng" });
      og.put("佛", new String[] { "fo", "fu" });
      og.put("长", new String[] { "chang", "zhang" });
      og.put("提", new String[] { "ti", "di" });
      og.put("攒", new String[] { "cuan", "zan" });
      og.put("大", new String[] { "dai", "da" });
      og.put("厦", new String[] { "sha", "xia" });
      og.put("觉", new String[] { "jiao", "jue" });
      og.put("车", new String[] { "che", "ju" });
      og.put("禅", new String[] { "chan", "shan" });
      og.put("刹", new String[] { "cha", "sha" });
      og.put("膀", new String[] { "bang", "pang" });
      og.put("剥", new String[] { "bao", "pu" });
      og.put("骠", new String[] { "biao", "piao" });
      og.put("堡", new String[] { "bao", "pu" });
      og.put("爪", new String[] { "zhua", "zhao" });
    }
  }
  
  /* Error */
  private static void edH()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 1725	com/tencent/mobileqq/utils/ChnToSpell:p	[S
    //   6: ifnull +7 -> 13
    //   9: ldc 2
    //   11: monitorexit
    //   12: return
    //   13: sipush 20902
    //   16: newarray short
    //   18: putstatic 1725	com/tencent/mobileqq/utils/ChnToSpell:p	[S
    //   21: sipush 2048
    //   24: newarray byte
    //   26: astore 8
    //   28: iconst_0
    //   29: istore_1
    //   30: getstatic 2088	com/tencent/common/app/BaseApplicationImpl:sApplication	Lcom/tencent/common/app/BaseApplicationImpl;
    //   33: invokevirtual 2092	com/tencent/common/app/BaseApplicationImpl:getResources	()Landroid/content/res/Resources;
    //   36: invokevirtual 2098	android/content/res/Resources:getAssets	()Landroid/content/res/AssetManager;
    //   39: ldc_w 2100
    //   42: invokevirtual 2106	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   45: astore_3
    //   46: aload 8
    //   48: invokestatic 2112	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   51: astore 7
    //   53: new 2114	java/io/BufferedInputStream
    //   56: dup
    //   57: aload_3
    //   58: invokespecial 2117	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   61: astore 4
    //   63: aload 4
    //   65: astore 6
    //   67: aload_3
    //   68: astore 5
    //   70: aload 4
    //   72: aload 8
    //   74: iconst_0
    //   75: sipush 2048
    //   78: invokevirtual 2121	java/io/BufferedInputStream:read	([BII)I
    //   81: iconst_2
    //   82: idiv
    //   83: istore_0
    //   84: iconst_0
    //   85: istore_2
    //   86: iload_0
    //   87: ifeq +83 -> 170
    //   90: iload_2
    //   91: iload_0
    //   92: iadd
    //   93: sipush 20902
    //   96: if_icmpgt +74 -> 170
    //   99: aload 4
    //   101: astore 6
    //   103: aload_3
    //   104: astore 5
    //   106: aload 7
    //   108: iconst_0
    //   109: invokevirtual 2125	java/nio/ByteBuffer:position	(I)Ljava/nio/Buffer;
    //   112: pop
    //   113: aload 4
    //   115: astore 6
    //   117: aload_3
    //   118: astore 5
    //   120: aload 7
    //   122: invokevirtual 2129	java/nio/ByteBuffer:asShortBuffer	()Ljava/nio/ShortBuffer;
    //   125: getstatic 1725	com/tencent/mobileqq/utils/ChnToSpell:p	[S
    //   128: iload_2
    //   129: iload_0
    //   130: sipush 20902
    //   133: iload_2
    //   134: isub
    //   135: invokestatic 2134	java/lang/Math:min	(II)I
    //   138: invokevirtual 2139	java/nio/ShortBuffer:get	([SII)Ljava/nio/ShortBuffer;
    //   141: pop
    //   142: iload_2
    //   143: iload_0
    //   144: iadd
    //   145: istore_2
    //   146: aload 4
    //   148: astore 6
    //   150: aload_3
    //   151: astore 5
    //   153: aload 4
    //   155: aload 8
    //   157: iconst_0
    //   158: sipush 2048
    //   161: invokevirtual 2121	java/io/BufferedInputStream:read	([BII)I
    //   164: iconst_2
    //   165: idiv
    //   166: istore_0
    //   167: goto -81 -> 86
    //   170: aload 4
    //   172: ifnull +8 -> 180
    //   175: aload 4
    //   177: invokevirtual 2142	java/io/BufferedInputStream:close	()V
    //   180: aload_3
    //   181: ifnull +196 -> 377
    //   184: aload_3
    //   185: invokevirtual 2145	java/io/InputStream:close	()V
    //   188: iconst_3
    //   189: istore_0
    //   190: iload_0
    //   191: iconst_1
    //   192: iadd
    //   193: istore_0
    //   194: iload_0
    //   195: istore_1
    //   196: iload_0
    //   197: iconst_3
    //   198: if_icmplt -168 -> 30
    //   201: ldc 2
    //   203: monitorexit
    //   204: return
    //   205: astore_3
    //   206: ldc 2
    //   208: monitorexit
    //   209: aload_3
    //   210: athrow
    //   211: astore 4
    //   213: aload 4
    //   215: invokevirtual 2148	java/io/IOException:printStackTrace	()V
    //   218: goto -38 -> 180
    //   221: astore_3
    //   222: aload_3
    //   223: invokevirtual 2148	java/io/IOException:printStackTrace	()V
    //   226: iconst_3
    //   227: istore_0
    //   228: goto -38 -> 190
    //   231: astore 7
    //   233: aconst_null
    //   234: astore 4
    //   236: aconst_null
    //   237: astore_3
    //   238: aload 4
    //   240: astore 6
    //   242: aload_3
    //   243: astore 5
    //   245: ldc_w 2150
    //   248: iconst_1
    //   249: ldc_w 1743
    //   252: aload 7
    //   254: invokestatic 2156	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   257: aload 4
    //   259: ifnull +8 -> 267
    //   262: aload 4
    //   264: invokevirtual 2142	java/io/BufferedInputStream:close	()V
    //   267: iload_1
    //   268: istore_0
    //   269: aload_3
    //   270: ifnull -80 -> 190
    //   273: aload_3
    //   274: invokevirtual 2145	java/io/InputStream:close	()V
    //   277: iload_1
    //   278: istore_0
    //   279: goto -89 -> 190
    //   282: astore_3
    //   283: aload_3
    //   284: invokevirtual 2148	java/io/IOException:printStackTrace	()V
    //   287: iload_1
    //   288: istore_0
    //   289: goto -99 -> 190
    //   292: astore 4
    //   294: aload 4
    //   296: invokevirtual 2148	java/io/IOException:printStackTrace	()V
    //   299: goto -32 -> 267
    //   302: astore 4
    //   304: aconst_null
    //   305: astore 6
    //   307: aconst_null
    //   308: astore_3
    //   309: aload 6
    //   311: ifnull +8 -> 319
    //   314: aload 6
    //   316: invokevirtual 2142	java/io/BufferedInputStream:close	()V
    //   319: aload_3
    //   320: ifnull +7 -> 327
    //   323: aload_3
    //   324: invokevirtual 2145	java/io/InputStream:close	()V
    //   327: aload 4
    //   329: athrow
    //   330: astore 5
    //   332: aload 5
    //   334: invokevirtual 2148	java/io/IOException:printStackTrace	()V
    //   337: goto -18 -> 319
    //   340: astore_3
    //   341: aload_3
    //   342: invokevirtual 2148	java/io/IOException:printStackTrace	()V
    //   345: goto -18 -> 327
    //   348: astore 4
    //   350: aconst_null
    //   351: astore 6
    //   353: goto -44 -> 309
    //   356: astore 4
    //   358: aload 5
    //   360: astore_3
    //   361: goto -52 -> 309
    //   364: astore 7
    //   366: aconst_null
    //   367: astore 4
    //   369: goto -131 -> 238
    //   372: astore 7
    //   374: goto -136 -> 238
    //   377: iconst_3
    //   378: istore_0
    //   379: goto -189 -> 190
    // Local variable table:
    //   start	length	slot	name	signature
    //   83	296	0	i	int
    //   29	259	1	j	int
    //   85	61	2	k	int
    //   45	140	3	localInputStream	java.io.InputStream
    //   205	5	3	localObject1	Object
    //   221	2	3	localIOException1	java.io.IOException
    //   237	37	3	localObject2	Object
    //   282	2	3	localIOException2	java.io.IOException
    //   308	16	3	localObject3	Object
    //   340	2	3	localIOException3	java.io.IOException
    //   360	1	3	localObject4	Object
    //   61	115	4	localBufferedInputStream	java.io.BufferedInputStream
    //   211	3	4	localIOException4	java.io.IOException
    //   234	29	4	localObject5	Object
    //   292	3	4	localIOException5	java.io.IOException
    //   302	26	4	localObject6	Object
    //   348	1	4	localObject7	Object
    //   356	1	4	localObject8	Object
    //   367	1	4	localObject9	Object
    //   68	176	5	localObject10	Object
    //   330	29	5	localIOException6	java.io.IOException
    //   65	287	6	localObject11	Object
    //   51	70	7	localByteBuffer	java.nio.ByteBuffer
    //   231	22	7	localException1	java.lang.Exception
    //   364	1	7	localException2	java.lang.Exception
    //   372	1	7	localException3	java.lang.Exception
    //   26	130	8	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   3	12	205	finally
    //   13	28	205	finally
    //   175	180	205	finally
    //   184	188	205	finally
    //   201	204	205	finally
    //   206	209	205	finally
    //   213	218	205	finally
    //   222	226	205	finally
    //   262	267	205	finally
    //   273	277	205	finally
    //   283	287	205	finally
    //   294	299	205	finally
    //   314	319	205	finally
    //   323	327	205	finally
    //   327	330	205	finally
    //   332	337	205	finally
    //   341	345	205	finally
    //   175	180	211	java/io/IOException
    //   184	188	221	java/io/IOException
    //   30	46	231	java/lang/Exception
    //   273	277	282	java/io/IOException
    //   262	267	292	java/io/IOException
    //   30	46	302	finally
    //   314	319	330	java/io/IOException
    //   323	327	340	java/io/IOException
    //   46	63	348	finally
    //   70	84	356	finally
    //   106	113	356	finally
    //   120	142	356	finally
    //   153	167	356	finally
    //   245	257	356	finally
    //   46	63	364	java/lang/Exception
    //   70	84	372	java/lang/Exception
    //   106	113	372	java/lang/Exception
    //   120	142	372	java/lang/Exception
    //   153	167	372	java/lang/Exception
  }
  
  public static String[] v(String paramString)
  {
    
    if (og.containsKey(paramString)) {
      return (String[])og.get(paramString);
    }
    return new String[] { aJ(paramString, 1) };
  }
  
  public static class a
  {
    public String csW;
    public int range;
  }
  
  public static class b
  {
    public List<Integer> IJ;
    public String csX;
    public int mode;
  }
  
  public static class c
    extends ChnToSpell.b
  {
    public List<Integer> IK;
    public List<Integer> IL;
    public List<Integer> IM;
    public String csY;
    public String csZ;
    public String cta;
    
    public ChnToSpell.b a()
    {
      ChnToSpell.b localb = new ChnToSpell.b();
      localb.csX = this.csY;
      localb.IJ = this.IK;
      localb.mode = 1;
      return localb;
    }
    
    public ChnToSpell.b b()
    {
      ChnToSpell.b localb = new ChnToSpell.b();
      localb.csX = this.csZ;
      localb.IJ = this.IL;
      localb.mode = 2;
      return localb;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.utils.ChnToSpell
 * JD-Core Version:    0.7.0.1
 */