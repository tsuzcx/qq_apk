package com.tencent.mobileqq.utils;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Hashtable;

public class ChnToSpell
{
  public static final int a = 1;
  private static InputStream jdField_a_of_type_JavaIoInputStream;
  private static final String jdField_a_of_type_JavaLangString = "qq_uni2py.db";
  private static Hashtable jdField_a_of_type_JavaUtilHashtable = new Hashtable(128);
  private static final int[] jdField_a_of_type_ArrayOfInt;
  public static final String[] a;
  private static short[] jdField_a_of_type_ArrayOfShort;
  public static final int b = 2;
  private static Hashtable jdField_b_of_type_JavaUtilHashtable = new Hashtable(128);
  private static final String[] jdField_b_of_type_ArrayOfJavaLangString;
  public static final int c = 19968;
  public static final int d = 40869;
  private static final int e = 2048;
  private static final int f = 8544;
  private static final int g = 8575;
  private static final int h = 12295;
  private static final int i = 65281;
  private static final int j = 65374;
  private static final int k = 33;
  private static final int l = 65248;
  private static final int m = 5;
  private static final int n = -3;
  private static final int o = -5;
  private static final int p = -7;
  private static final int q = -10;
  private static final int r = -12;
  
  static
  {
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "?", "a", "ai", "an", "ang", "ao", "ba", "bai", "ban", "bang", "bao", "bei", "ben", "beng", "bi", "bian", "biao", "bie", "bin", "bing", "bo", "bu", "ca", "cai", "can", "cang", "cao", "ce", "ceng", "cha", "chai", "chan", "chang", "chao", "che", "chen", "cheng", "chi", "chong", "chou", "chu", "chuai", "chuan", "chuang", "chui", "chun", "chuo", "ci", "cong", "cou", "cu", "cuan", "cui", "cun", "cuo", "da", "dai", "dan", "dang", "dao", "de", "deng", "di", "dian", "diao", "die", "ding", "diu", "dong", "dou", "du", "duan", "dui", "dun", "duo", "e", "en", "er", "fa", "fan", "fang", "fei", "fen", "feng", "fu", "fou", "ga", "gai", "gan", "gang", "gao", "ge", "ji", "gen", "geng", "gong", "gou", "gu", "gua", "guai", "guan", "guang", "gui", "gun", "guo", "ha", "hai", "han", "hang", "hao", "he", "hei", "hen", "heng", "hong", "hou", "hu", "hua", "huai", "huan", "huang", "hui", "hun", "huo", "jia", "jian", "jiang", "qiao", "jiao", "jie", "jin", "jing", "jiong", "jiu", "ju", "juan", "jue", "jun", "ka", "kai", "kan", "kang", "kao", "ke", "ken", "keng", "kong", "kou", "ku", "kua", "kuai", "kuan", "kuang", "kui", "kun", "kuo", "la", "lai", "lan", "lang", "lao", "le", "lei", "leng", "li", "lia", "lian", "liang", "liao", "lie", "lin", "ling", "liu", "long", "lou", "lu", "luan", "lue", "lun", "luo", "ma", "mai", "man", "mang", "mao", "me", "mei", "men", "meng", "mi", "mian", "miao", "mie", "min", "ming", "miu", "mo", "mou", "mu", "na", "nai", "nan", "nang", "nao", "ne", "nei", "nen", "neng", "ni", "nian", "niang", "niao", "nie", "nin", "ning", "niu", "nong", "nu", "nuan", "nue", "yao", "nuo", "o", "ou", "pa", "pai", "pan", "pang", "pao", "pei", "pen", "peng", "pi", "pian", "piao", "pie", "pin", "ping", "po", "pou", "pu", "qi", "qia", "qian", "qiang", "qie", "qin", "qing", "qiong", "qiu", "qu", "quan", "que", "qun", "ran", "rang", "rao", "re", "ren", "reng", "ri", "rong", "rou", "ru", "ruan", "rui", "run", "ruo", "sa", "sai", "san", "sang", "sao", "se", "sen", "seng", "sha", "shai", "shan", "shang", "shao", "she", "shen", "sheng", "shi", "shou", "shu", "shua", "shuai", "shuan", "shuang", "shui", "shun", "shuo", "si", "song", "sou", "su", "suan", "sui", "sun", "suo", "ta", "tai", "tan", "tang", "tao", "te", "teng", "ti", "tian", "tiao", "tie", "ting", "tong", "tou", "tu", "tuan", "tui", "tun", "tuo", "wa", "wai", "wan", "wang", "wei", "wen", "weng", "wo", "wu", "xi", "xia", "xian", "xiang", "xiao", "xie", "xin", "xing", "xiong", "xiu", "xu", "xuan", "xue", "xun", "ya", "yan", "yang", "ye", "yi", "yin", "ying", "yo", "yong", "you", "yu", "yuan", "yue", "yun", "za", "zai", "zan", "zang", "zao", "ze", "zei", "zen", "zeng", "zha", "zhai", "zhan", "zhang", "zhao", "zhe", "zhen", "zheng", "zhi", "zhong", "zhou", "zhu", "zhua", "zhuai", "zhuan", "zhuang", "zhui", "zhun", "zhuo", "zi", "zong", "zou", "zu", "zuan", "zui", "zun", "zuo", "ei", "m", "n", "dia", "cen", "nou", "jv", "qv", "xv", "lv", "nv" };
    jdField_b_of_type_ArrayOfJavaLangString = new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "50", "100", "500", "1000" };
    jdField_a_of_type_ArrayOfInt = new int[] { 0, 64, 91, 96, 123, 8543, 8576, 12295, 19967, 40870, 65280, 65375, 2147483647 };
  }
  
  public static String a(String paramString, int paramInt)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      localObject = "";
    }
    String str;
    do
    {
      return localObject;
      if (paramInt != 1) {
        break;
      }
      str = (String)jdField_a_of_type_JavaUtilHashtable.get(paramString);
      localObject = str;
    } while (str != null);
    if (jdField_a_of_type_ArrayOfShort == null) {
      a();
    }
    Object localObject = new StringBuilder();
    int i5 = paramString.length();
    int i2 = paramString.charAt(0);
    if (i2 == 21333) {
      if (paramInt == 1)
      {
        ((StringBuilder)localObject).append("shan");
        label96:
        ((StringBuilder)localObject).append("shan");
        i2 = 1;
      }
    }
    for (;;)
    {
      label107:
      if (i2 < i5)
      {
        int i1 = paramString.charAt(i2);
        switch (Arrays.binarySearch(jdField_a_of_type_ArrayOfInt, i1))
        {
        default: 
          if (Character.isHighSurrogate(i1))
          {
            ((StringBuilder)localObject).append('?');
            i2 += 1;
          }
          break;
        }
        for (;;)
        {
          i2 += 1;
          break label107;
          if (paramInt != 2) {
            break;
          }
          localObject = (String)jdField_b_of_type_JavaUtilHashtable.get(paramString);
          if (localObject == null) {
            break;
          }
          return localObject;
          if (paramInt != 2) {
            break label96;
          }
          ((StringBuilder)localObject).append('s');
          break label96;
          if (i2 == 20167)
          {
            if (paramInt == 1) {
              ((StringBuilder)localObject).append("qiu");
            }
            for (;;)
            {
              i2 = 1;
              break;
              if (paramInt == 2) {
                ((StringBuilder)localObject).append('1');
              }
            }
          }
          if (i2 == 26366)
          {
            if (paramInt == 1) {
              ((StringBuilder)localObject).append("zeng");
            }
            for (;;)
            {
              i2 = 1;
              break;
              if (paramInt == 2) {
                ((StringBuilder)localObject).append('z');
              }
            }
          }
          if ((i2 != 19975) || (paramString.length() <= 1) || (paramString.charAt(1) != '俟')) {
            break label619;
          }
          if (paramInt == 1) {
            ((StringBuilder)localObject).append("moqi");
          }
          for (;;)
          {
            i2 = 2;
            break;
            if (paramInt == 2) {
              ((StringBuilder)localObject).append("mq");
            }
          }
          int i4 = i1 - 8544;
          int i3 = i4;
          if (i4 >= jdField_b_of_type_ArrayOfJavaLangString.length) {
            i3 = i4 - jdField_b_of_type_ArrayOfJavaLangString.length;
          }
          ((StringBuilder)localObject).append(jdField_b_of_type_ArrayOfJavaLangString[i3]);
          continue;
          if (paramInt == 1)
          {
            ((StringBuilder)localObject).append("ling");
          }
          else
          {
            ((StringBuilder)localObject).append('l');
            continue;
            ((StringBuilder)localObject).append(Character.toLowerCase(i1));
            continue;
            ((StringBuilder)localObject).append(i1);
            continue;
            if (paramInt == 1)
            {
              ((StringBuilder)localObject).append(jdField_a_of_type_ArrayOfJavaLangString[jdField_a_of_type_ArrayOfShort[(i1 - 19968)]]);
            }
            else
            {
              ((StringBuilder)localObject).append(jdField_a_of_type_ArrayOfJavaLangString[jdField_a_of_type_ArrayOfShort[(i1 - 19968)]].charAt(0));
              continue;
              ((StringBuilder)localObject).append(Character.toLowerCase((char)(i1 - 65248)));
              continue;
              ((StringBuilder)localObject).append(i1);
            }
          }
        }
      }
      str = ((StringBuilder)localObject).toString();
      if (paramInt == 1)
      {
        jdField_a_of_type_JavaUtilHashtable.put(paramString, str);
        return str;
      }
      localObject = str;
      if (paramInt != 2) {
        break;
      }
      jdField_b_of_type_JavaUtilHashtable.put(paramString, str);
      return str;
      label619:
      i2 = 0;
    }
  }
  
  /* Error */
  private static void a()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_0
    //   2: ldc 2
    //   4: monitorenter
    //   5: getstatic 926	com/tencent/mobileqq/utils/ChnToSpell:jdField_a_of_type_ArrayOfShort	[S
    //   8: ifnull +7 -> 15
    //   11: ldc 2
    //   13: monitorexit
    //   14: return
    //   15: sipush 20902
    //   18: newarray short
    //   20: putstatic 926	com/tencent/mobileqq/utils/ChnToSpell:jdField_a_of_type_ArrayOfShort	[S
    //   23: sipush 2048
    //   26: newarray byte
    //   28: astore 4
    //   30: aload 4
    //   32: invokestatic 980	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   35: astore 5
    //   37: new 982	java/io/BufferedInputStream
    //   40: dup
    //   41: getstatic 984	com/tencent/mobileqq/utils/ChnToSpell:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   44: invokespecial 987	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   47: astore_3
    //   48: aload_3
    //   49: astore_2
    //   50: aload_3
    //   51: aload 4
    //   53: iconst_0
    //   54: sipush 2048
    //   57: invokevirtual 991	java/io/BufferedInputStream:read	([BII)I
    //   60: iconst_2
    //   61: idiv
    //   62: istore_1
    //   63: iload_1
    //   64: ifeq +67 -> 131
    //   67: iload_0
    //   68: iload_1
    //   69: iadd
    //   70: sipush 20902
    //   73: if_icmpgt +58 -> 131
    //   76: aload_3
    //   77: astore_2
    //   78: aload 5
    //   80: iconst_0
    //   81: invokevirtual 995	java/nio/ByteBuffer:position	(I)Ljava/nio/Buffer;
    //   84: pop
    //   85: aload_3
    //   86: astore_2
    //   87: aload 5
    //   89: invokevirtual 999	java/nio/ByteBuffer:asShortBuffer	()Ljava/nio/ShortBuffer;
    //   92: getstatic 926	com/tencent/mobileqq/utils/ChnToSpell:jdField_a_of_type_ArrayOfShort	[S
    //   95: iload_0
    //   96: iload_1
    //   97: sipush 20902
    //   100: iload_0
    //   101: isub
    //   102: invokestatic 1004	java/lang/Math:min	(II)I
    //   105: invokevirtual 1009	java/nio/ShortBuffer:get	([SII)Ljava/nio/ShortBuffer;
    //   108: pop
    //   109: iload_0
    //   110: iload_1
    //   111: iadd
    //   112: istore_0
    //   113: aload_3
    //   114: astore_2
    //   115: aload_3
    //   116: aload 4
    //   118: iconst_0
    //   119: sipush 2048
    //   122: invokevirtual 991	java/io/BufferedInputStream:read	([BII)I
    //   125: iconst_2
    //   126: idiv
    //   127: istore_1
    //   128: goto -65 -> 63
    //   131: aload_3
    //   132: ifnull +7 -> 139
    //   135: aload_3
    //   136: invokevirtual 1012	java/io/BufferedInputStream:close	()V
    //   139: getstatic 984	com/tencent/mobileqq/utils/ChnToSpell:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   142: astore_2
    //   143: aload_2
    //   144: ifnull +13 -> 157
    //   147: getstatic 984	com/tencent/mobileqq/utils/ChnToSpell:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   150: invokevirtual 1015	java/io/InputStream:close	()V
    //   153: aconst_null
    //   154: putstatic 984	com/tencent/mobileqq/utils/ChnToSpell:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   157: ldc 2
    //   159: monitorexit
    //   160: return
    //   161: astore_2
    //   162: ldc 2
    //   164: monitorexit
    //   165: aload_2
    //   166: athrow
    //   167: astore_2
    //   168: aload_2
    //   169: invokevirtual 1018	java/io/IOException:printStackTrace	()V
    //   172: goto -33 -> 139
    //   175: astore_2
    //   176: aload_2
    //   177: invokevirtual 1018	java/io/IOException:printStackTrace	()V
    //   180: goto -27 -> 153
    //   183: astore 4
    //   185: aconst_null
    //   186: astore_3
    //   187: aload_3
    //   188: astore_2
    //   189: aload 4
    //   191: invokevirtual 1019	java/io/FileNotFoundException:printStackTrace	()V
    //   194: aload_3
    //   195: ifnull +7 -> 202
    //   198: aload_3
    //   199: invokevirtual 1012	java/io/BufferedInputStream:close	()V
    //   202: getstatic 984	com/tencent/mobileqq/utils/ChnToSpell:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   205: astore_2
    //   206: aload_2
    //   207: ifnull -50 -> 157
    //   210: getstatic 984	com/tencent/mobileqq/utils/ChnToSpell:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   213: invokevirtual 1015	java/io/InputStream:close	()V
    //   216: aconst_null
    //   217: putstatic 984	com/tencent/mobileqq/utils/ChnToSpell:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   220: goto -63 -> 157
    //   223: astore_2
    //   224: aload_2
    //   225: invokevirtual 1018	java/io/IOException:printStackTrace	()V
    //   228: goto -26 -> 202
    //   231: astore_2
    //   232: aload_2
    //   233: invokevirtual 1018	java/io/IOException:printStackTrace	()V
    //   236: goto -20 -> 216
    //   239: astore 4
    //   241: aconst_null
    //   242: astore_3
    //   243: aload_3
    //   244: astore_2
    //   245: aload 4
    //   247: invokevirtual 1018	java/io/IOException:printStackTrace	()V
    //   250: aload_3
    //   251: ifnull +7 -> 258
    //   254: aload_3
    //   255: invokevirtual 1012	java/io/BufferedInputStream:close	()V
    //   258: getstatic 984	com/tencent/mobileqq/utils/ChnToSpell:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   261: astore_2
    //   262: aload_2
    //   263: ifnull -106 -> 157
    //   266: getstatic 984	com/tencent/mobileqq/utils/ChnToSpell:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   269: invokevirtual 1015	java/io/InputStream:close	()V
    //   272: aconst_null
    //   273: putstatic 984	com/tencent/mobileqq/utils/ChnToSpell:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   276: goto -119 -> 157
    //   279: astore_2
    //   280: aload_2
    //   281: invokevirtual 1018	java/io/IOException:printStackTrace	()V
    //   284: goto -26 -> 258
    //   287: astore_2
    //   288: aload_2
    //   289: invokevirtual 1018	java/io/IOException:printStackTrace	()V
    //   292: goto -20 -> 272
    //   295: astore_3
    //   296: aconst_null
    //   297: astore_2
    //   298: aload_2
    //   299: ifnull +7 -> 306
    //   302: aload_2
    //   303: invokevirtual 1012	java/io/BufferedInputStream:close	()V
    //   306: getstatic 984	com/tencent/mobileqq/utils/ChnToSpell:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   309: astore_2
    //   310: aload_2
    //   311: ifnull +13 -> 324
    //   314: getstatic 984	com/tencent/mobileqq/utils/ChnToSpell:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   317: invokevirtual 1015	java/io/InputStream:close	()V
    //   320: aconst_null
    //   321: putstatic 984	com/tencent/mobileqq/utils/ChnToSpell:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   324: aload_3
    //   325: athrow
    //   326: astore_2
    //   327: aload_2
    //   328: invokevirtual 1018	java/io/IOException:printStackTrace	()V
    //   331: goto -25 -> 306
    //   334: astore_2
    //   335: aload_2
    //   336: invokevirtual 1018	java/io/IOException:printStackTrace	()V
    //   339: goto -19 -> 320
    //   342: astore_3
    //   343: goto -45 -> 298
    //   346: astore 4
    //   348: goto -105 -> 243
    //   351: astore 4
    //   353: goto -166 -> 187
    // Local variable table:
    //   start	length	slot	name	signature
    //   1	112	0	i1	int
    //   62	66	1	i2	int
    //   49	95	2	localObject1	Object
    //   161	5	2	localObject2	Object
    //   167	2	2	localIOException1	IOException
    //   175	2	2	localIOException2	IOException
    //   188	19	2	localObject3	Object
    //   223	2	2	localIOException3	IOException
    //   231	2	2	localIOException4	IOException
    //   244	19	2	localObject4	Object
    //   279	2	2	localIOException5	IOException
    //   287	2	2	localIOException6	IOException
    //   297	14	2	localInputStream	InputStream
    //   326	2	2	localIOException7	IOException
    //   334	2	2	localIOException8	IOException
    //   47	208	3	localBufferedInputStream	java.io.BufferedInputStream
    //   295	30	3	localObject5	Object
    //   342	1	3	localObject6	Object
    //   28	89	4	arrayOfByte	byte[]
    //   183	7	4	localFileNotFoundException1	java.io.FileNotFoundException
    //   239	7	4	localIOException9	IOException
    //   346	1	4	localIOException10	IOException
    //   351	1	4	localFileNotFoundException2	java.io.FileNotFoundException
    //   35	53	5	localByteBuffer	java.nio.ByteBuffer
    // Exception table:
    //   from	to	target	type
    //   5	14	161	finally
    //   15	37	161	finally
    //   135	139	161	finally
    //   139	143	161	finally
    //   147	153	161	finally
    //   153	157	161	finally
    //   157	160	161	finally
    //   162	165	161	finally
    //   168	172	161	finally
    //   176	180	161	finally
    //   198	202	161	finally
    //   202	206	161	finally
    //   210	216	161	finally
    //   216	220	161	finally
    //   224	228	161	finally
    //   232	236	161	finally
    //   254	258	161	finally
    //   258	262	161	finally
    //   266	272	161	finally
    //   272	276	161	finally
    //   280	284	161	finally
    //   288	292	161	finally
    //   302	306	161	finally
    //   306	310	161	finally
    //   314	320	161	finally
    //   320	324	161	finally
    //   324	326	161	finally
    //   327	331	161	finally
    //   335	339	161	finally
    //   135	139	167	java/io/IOException
    //   147	153	175	java/io/IOException
    //   37	48	183	java/io/FileNotFoundException
    //   198	202	223	java/io/IOException
    //   210	216	231	java/io/IOException
    //   37	48	239	java/io/IOException
    //   254	258	279	java/io/IOException
    //   266	272	287	java/io/IOException
    //   37	48	295	finally
    //   302	306	326	java/io/IOException
    //   314	320	334	java/io/IOException
    //   50	63	342	finally
    //   78	85	342	finally
    //   87	109	342	finally
    //   115	128	342	finally
    //   189	194	342	finally
    //   245	250	342	finally
    //   50	63	346	java/io/IOException
    //   78	85	346	java/io/IOException
    //   87	109	346	java/io/IOException
    //   115	128	346	java/io/IOException
    //   50	63	351	java/io/FileNotFoundException
    //   78	85	351	java/io/FileNotFoundException
    //   87	109	351	java/io/FileNotFoundException
    //   115	128	351	java/io/FileNotFoundException
  }
  
  public static void a(Context paramContext)
  {
    if (jdField_a_of_type_ArrayOfShort != null) {}
    while ((paramContext == null) || (jdField_a_of_type_JavaIoInputStream != null)) {
      return;
    }
    try
    {
      jdField_a_of_type_JavaIoInputStream = paramContext.getResources().getAssets().open("qq_uni2py.db");
      return;
    }
    catch (IOException paramContext)
    {
      paramContext.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.ChnToSpell
 * JD-Core Version:    0.7.0.1
 */