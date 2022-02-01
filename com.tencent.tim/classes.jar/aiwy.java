import android.util.Log;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class aiwy
{
  private static final Pattern Z = Pattern.compile("(?<=\\()-?[0-9]*,-?[0-9]*(?=\\))");
  private static final aiwy.a a = new aiwy.a(null);
  private static final Pattern mPattern = Pattern.compile("(?<=\\[).*?(?=\\])");
  private int mOffset;
  private final String mString;
  private ArrayList<aiwp> xw = new ArrayList();
  
  public aiwy(String paramString)
  {
    this.mString = paramString;
  }
  
  private void Ma(String paramString)
  {
    if ((paramString == null) || (paramString.equals(""))) {
      return;
    }
    Object localObject3 = mPattern.matcher(paramString);
    Object localObject2 = new ArrayList();
    int i = -1;
    int j = -1;
    label36:
    Object localObject1;
    if (((Matcher)localObject3).find())
    {
      localObject1 = ((Matcher)localObject3).group();
      if (localObject1 != null) {
        break label396;
      }
      localObject1 = "";
    }
    label396:
    for (;;)
    {
      for (;;)
      {
        int k = paramString.indexOf("[" + (String)localObject1 + "]");
        if ((j != -1) && (k - j > i + 2))
        {
          String str1 = paramString.substring(i + j + 2, k);
          Iterator localIterator = ((ArrayList)localObject2).iterator();
          while (localIterator.hasNext())
          {
            String str2 = (String)localIterator.next();
            aiwp localaiwp = new aiwp();
            if (a(str2, localaiwp) != -1L)
            {
              a(str1, localaiwp);
              this.xw.add(localaiwp);
            }
          }
          ((ArrayList)localObject2).clear();
        }
        ((ArrayList)localObject2).add(localObject1);
        i = ((String)localObject1).length();
        j = k;
        break label36;
        if (((ArrayList)localObject2).isEmpty()) {
          break;
        }
        j = i + 2 + j;
        i = j;
        try
        {
          if (j > paramString.length()) {
            i = paramString.length();
          }
          paramString = paramString.substring(i).trim();
          if ((paramString.length() == 0) && (this.mOffset == 0))
          {
            paramString = ((ArrayList)localObject2).iterator();
            do
            {
              if (!paramString.hasNext()) {
                break;
              }
              i = dq((String)paramString.next());
            } while (i == 2147483647);
            this.mOffset = i;
            return;
          }
        }
        catch (Exception paramString)
        {
          Log.e("ParsingQrc", paramString.toString());
          return;
        }
      }
      localObject1 = ((ArrayList)localObject2).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        localObject3 = new aiwp();
        if (a((String)localObject2, (aiwp)localObject3) != -1L)
        {
          a(paramString, (aiwp)localObject3);
          this.xw.add(localObject3);
        }
      }
      break;
    }
  }
  
  private long a(String paramString, aiwp paramaiwp)
  {
    String[] arrayOfString = paramString.split("\\,");
    if (arrayOfString.length < 2)
    {
      paramString = paramString.split("\\:");
      if ((this.mOffset == 0) && (paramString[0].equalsIgnoreCase("offset"))) {
        this.mOffset = Integer.parseInt(paramString[1]);
      }
    }
    while (arrayOfString.length != 2) {
      return -1L;
    }
    try
    {
      long l1 = Long.parseLong(arrayOfString[1]);
      long l2 = Long.parseLong(arrayOfString[0]);
      paramaiwp.mDuration = l1;
      paramaiwp.mStartTime = l2;
      return l2;
    }
    catch (Exception paramString) {}
    return -1L;
  }
  
  private aiwm a(String paramString, int paramInt1, int paramInt2, aiwm paramaiwm)
  {
    long l2 = 0L;
    paramString = paramString.split("\\,");
    if (paramString.length < 2) {}
    while (paramString.length != 2) {
      return null;
    }
    long l4 = Long.parseLong(paramString[1]);
    long l3 = Long.parseLong(paramString[0]);
    long l1 = l4;
    if (l4 < 0L) {
      l1 = 0L;
    }
    if (l3 < 0L) {}
    for (;;)
    {
      return new aiwm(l2, l1, paramInt1, paramInt2);
      l2 = l3;
    }
  }
  
  private void a(String paramString, aiwp paramaiwp)
  {
    label244:
    for (;;)
    {
      ArrayList localArrayList;
      try
      {
        paramaiwp.mText = "";
        if (paramString == null) {
          break;
        }
        if (paramString.equals("")) {
          return;
        }
        Matcher localMatcher = Z.matcher(paramString);
        localArrayList = new ArrayList();
        Object localObject1 = "";
        if (localMatcher.find())
        {
          Object localObject2 = localMatcher.group();
          if (localObject2 != null) {
            break label244;
          }
          localObject2 = "";
          int i = paramString.indexOf("(" + (String)localObject2 + ")");
          int j = ((String)localObject1).length();
          String str1 = (String)localObject1 + paramString.substring(0, i);
          String str2 = paramString.substring(i + ((String)localObject2).length() + 2, paramString.length());
          paramString = null;
          if (localArrayList.size() > 0) {
            paramString = (aiwm)localArrayList.get(localArrayList.size() - 1);
          }
          localObject2 = a((String)localObject2, j, str1.length(), paramString);
          localObject1 = str1;
          paramString = str2;
          if (localObject2 == null) {
            continue;
          }
          localArrayList.add(localObject2);
          localObject1 = str1;
          paramString = str2;
          continue;
        }
        paramaiwp.mText = ((String)localObject1);
      }
      catch (Exception paramString)
      {
        Log.e("ParsingQrc", "", paramString);
        return;
      }
      paramaiwp.xv = localArrayList;
      return;
    }
  }
  
  private int dq(String paramString)
  {
    int j = 0;
    paramString = paramString.split("\\:");
    int i = j;
    try
    {
      if (paramString.length == 2)
      {
        i = j;
        if ("offset".equalsIgnoreCase(paramString[0])) {
          i = Integer.parseInt(paramString[1].trim());
        }
      }
      return i;
    }
    catch (Exception paramString)
    {
      Log.e("ParsingQrc", paramString.toString());
    }
    return 0;
  }
  
  /* Error */
  public aiwn b()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 51	aiwy:mString	Ljava/lang/String;
    //   4: astore_2
    //   5: aload_2
    //   6: ifnull +64 -> 70
    //   9: aload_2
    //   10: ldc 222
    //   12: invokevirtual 226	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   15: ifeq +57 -> 72
    //   18: aload_2
    //   19: ldc 222
    //   21: invokevirtual 94	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   24: istore_1
    //   25: iload_1
    //   26: iconst_m1
    //   27: if_icmpeq +43 -> 70
    //   30: aload_2
    //   31: invokevirtual 132	java/lang/String:length	()I
    //   34: ldc 222
    //   36: invokevirtual 132	java/lang/String:length	()I
    //   39: iload_1
    //   40: iadd
    //   41: iconst_1
    //   42: iadd
    //   43: if_icmple +27 -> 70
    //   46: aload_2
    //   47: iload_1
    //   48: ldc 222
    //   50: invokevirtual 132	java/lang/String:length	()I
    //   53: iadd
    //   54: invokevirtual 138	java/lang/String:substring	(I)Ljava/lang/String;
    //   57: astore_2
    //   58: aload_2
    //   59: invokevirtual 141	java/lang/String:trim	()Ljava/lang/String;
    //   62: ldc 228
    //   64: invokevirtual 231	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   67: ifne +10 -> 77
    //   70: aconst_null
    //   71: areturn
    //   72: iconst_m1
    //   73: istore_1
    //   74: goto -49 -> 25
    //   77: aload_2
    //   78: aload_2
    //   79: ldc 228
    //   81: invokevirtual 94	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   84: ldc 228
    //   86: invokevirtual 132	java/lang/String:length	()I
    //   89: iadd
    //   90: invokevirtual 138	java/lang/String:substring	(I)Ljava/lang/String;
    //   93: astore_2
    //   94: aload_2
    //   95: invokevirtual 141	java/lang/String:trim	()Ljava/lang/String;
    //   98: ldc 233
    //   100: invokevirtual 231	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   103: ifeq -33 -> 70
    //   106: aload_2
    //   107: aload_2
    //   108: ldc 233
    //   110: invokevirtual 94	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   113: ldc 233
    //   115: invokevirtual 132	java/lang/String:length	()I
    //   118: iadd
    //   119: invokevirtual 138	java/lang/String:substring	(I)Ljava/lang/String;
    //   122: astore_2
    //   123: aload_2
    //   124: ldc 235
    //   126: invokevirtual 226	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   129: ifeq +131 -> 260
    //   132: aload_2
    //   133: ldc 235
    //   135: invokevirtual 238	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   138: istore_1
    //   139: iload_1
    //   140: iconst_m1
    //   141: if_icmpeq -71 -> 70
    //   144: aload_2
    //   145: iconst_0
    //   146: iload_1
    //   147: invokevirtual 98	java/lang/String:substring	(II)Ljava/lang/String;
    //   150: astore_2
    //   151: aload_2
    //   152: ldc 233
    //   154: invokevirtual 226	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   157: ifeq +108 -> 265
    //   160: aload_2
    //   161: ldc 233
    //   163: invokevirtual 238	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   166: istore_1
    //   167: iload_1
    //   168: iconst_m1
    //   169: if_icmpeq -99 -> 70
    //   172: aload_2
    //   173: iconst_0
    //   174: iload_1
    //   175: invokevirtual 98	java/lang/String:substring	(II)Ljava/lang/String;
    //   178: astore_2
    //   179: new 240	java/io/BufferedReader
    //   182: dup
    //   183: new 242	java/io/StringReader
    //   186: dup
    //   187: aload_2
    //   188: invokespecial 244	java/io/StringReader:<init>	(Ljava/lang/String;)V
    //   191: invokespecial 247	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   194: astore_3
    //   195: aload_3
    //   196: astore_2
    //   197: aload_3
    //   198: invokevirtual 250	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   201: astore 4
    //   203: aload 4
    //   205: ifnull +65 -> 270
    //   208: aload_3
    //   209: astore_2
    //   210: aload_0
    //   211: aload 4
    //   213: invokevirtual 141	java/lang/String:trim	()Ljava/lang/String;
    //   216: invokespecial 252	aiwy:Ma	(Ljava/lang/String;)V
    //   219: goto -24 -> 195
    //   222: astore 4
    //   224: aload_3
    //   225: astore_2
    //   226: ldc 149
    //   228: aload 4
    //   230: invokevirtual 150	java/lang/Exception:toString	()Ljava/lang/String;
    //   233: invokestatic 156	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   236: pop
    //   237: aload_3
    //   238: ifnull -168 -> 70
    //   241: aload_3
    //   242: invokevirtual 255	java/io/BufferedReader:close	()V
    //   245: aconst_null
    //   246: areturn
    //   247: astore_2
    //   248: ldc 149
    //   250: aload_2
    //   251: invokevirtual 256	java/io/IOException:toString	()Ljava/lang/String;
    //   254: invokestatic 156	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   257: pop
    //   258: aconst_null
    //   259: areturn
    //   260: iconst_m1
    //   261: istore_1
    //   262: goto -123 -> 139
    //   265: iconst_m1
    //   266: istore_1
    //   267: goto -100 -> 167
    //   270: aload_3
    //   271: astore_2
    //   272: aload_0
    //   273: getfield 49	aiwy:xw	Ljava/util/ArrayList;
    //   276: getstatic 40	aiwy:a	Laiwy$a;
    //   279: invokestatic 262	java/util/Collections:sort	(Ljava/util/List;Ljava/util/Comparator;)V
    //   282: aload_3
    //   283: astore_2
    //   284: new 264	aiwn
    //   287: dup
    //   288: iconst_2
    //   289: aload_0
    //   290: getfield 143	aiwy:mOffset	I
    //   293: aload_0
    //   294: getfield 49	aiwy:xw	Ljava/util/ArrayList;
    //   297: invokespecial 267	aiwn:<init>	(IILjava/util/ArrayList;)V
    //   300: astore 4
    //   302: aload_3
    //   303: ifnull +7 -> 310
    //   306: aload_3
    //   307: invokevirtual 255	java/io/BufferedReader:close	()V
    //   310: aload 4
    //   312: areturn
    //   313: astore_2
    //   314: ldc 149
    //   316: aload_2
    //   317: invokevirtual 256	java/io/IOException:toString	()Ljava/lang/String;
    //   320: invokestatic 156	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   323: pop
    //   324: goto -14 -> 310
    //   327: astore_3
    //   328: aconst_null
    //   329: astore_2
    //   330: aload_2
    //   331: ifnull +7 -> 338
    //   334: aload_2
    //   335: invokevirtual 255	java/io/BufferedReader:close	()V
    //   338: aload_3
    //   339: athrow
    //   340: astore_2
    //   341: ldc 149
    //   343: aload_2
    //   344: invokevirtual 256	java/io/IOException:toString	()Ljava/lang/String;
    //   347: invokestatic 156	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   350: pop
    //   351: goto -13 -> 338
    //   354: astore_3
    //   355: goto -25 -> 330
    //   358: astore 4
    //   360: aconst_null
    //   361: astore_3
    //   362: goto -138 -> 224
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	365	0	this	aiwy
    //   24	243	1	i	int
    //   4	222	2	localObject1	Object
    //   247	4	2	localIOException1	java.io.IOException
    //   271	13	2	localObject2	Object
    //   313	4	2	localIOException2	java.io.IOException
    //   329	6	2	localObject3	Object
    //   340	4	2	localIOException3	java.io.IOException
    //   194	113	3	localBufferedReader	java.io.BufferedReader
    //   327	12	3	localObject4	Object
    //   354	1	3	localObject5	Object
    //   361	1	3	localObject6	Object
    //   201	11	4	str	String
    //   222	7	4	localException1	Exception
    //   300	11	4	localaiwn	aiwn
    //   358	1	4	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   197	203	222	java/lang/Exception
    //   210	219	222	java/lang/Exception
    //   272	282	222	java/lang/Exception
    //   284	302	222	java/lang/Exception
    //   241	245	247	java/io/IOException
    //   306	310	313	java/io/IOException
    //   179	195	327	finally
    //   334	338	340	java/io/IOException
    //   197	203	354	finally
    //   210	219	354	finally
    //   226	237	354	finally
    //   272	282	354	finally
    //   284	302	354	finally
    //   179	195	358	java/lang/Exception
  }
  
  static class a
    implements Comparator<aiwp>
  {
    public int a(aiwp paramaiwp1, aiwp paramaiwp2)
    {
      if (paramaiwp1.mStartTime >= paramaiwp2.mStartTime) {
        return 1;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aiwy
 * JD-Core Version:    0.7.0.1
 */