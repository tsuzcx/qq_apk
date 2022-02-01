package com.tencent.qqmail.maillist;

import java.io.Serializable;

public class SearchHistoryItem
  implements Serializable
{
  private static final String ENCODING = "ISO-8859-1";
  static final String SEARCH_TAG_ALL = "all";
  private static final String SEARCH_TAG_RECEIVER = "receiver";
  private static final String SEARCH_TAG_SENDER = "sender";
  private static final String SEARCH_TAG_SUBJECT = "subject";
  private static final long serialVersionUID = -3668996773367116570L;
  private String mSearchContent;
  private String mSearchTag;
  private long mSearchTime;
  
  public SearchHistoryItem()
  {
    this.mSearchContent = null;
    this.mSearchTime = 0L;
    this.mSearchTag = null;
  }
  
  private SearchHistoryItem(String paramString1, long paramLong, String paramString2)
  {
    this.mSearchContent = paramString1;
    this.mSearchTime = paramLong;
    this.mSearchTag = paramString2;
  }
  
  /* Error */
  static SearchHistoryItem string2Object(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: aload_0
    //   3: ifnull +90 -> 93
    //   6: new 47	java/io/ObjectInputStream
    //   9: dup
    //   10: new 49	java/io/ByteArrayInputStream
    //   13: dup
    //   14: aload_0
    //   15: invokevirtual 55	java/lang/String:getBytes	()[B
    //   18: iconst_0
    //   19: invokestatic 61	android/util/Base64:decode	([BI)[B
    //   22: invokespecial 64	java/io/ByteArrayInputStream:<init>	([B)V
    //   25: invokespecial 67	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   28: astore_0
    //   29: aload_0
    //   30: invokevirtual 71	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   33: checkcast 2	com/tencent/qqmail/maillist/SearchHistoryItem
    //   36: astore_1
    //   37: aload_0
    //   38: ifnull +7 -> 45
    //   41: aload_0
    //   42: invokevirtual 74	java/io/ObjectInputStream:close	()V
    //   45: aload_1
    //   46: areturn
    //   47: astore_0
    //   48: aload_0
    //   49: invokevirtual 77	java/lang/Exception:printStackTrace	()V
    //   52: aload_1
    //   53: areturn
    //   54: astore_0
    //   55: aconst_null
    //   56: astore_0
    //   57: aload_0
    //   58: ifnull +7 -> 65
    //   61: aload_0
    //   62: invokevirtual 74	java/io/ObjectInputStream:close	()V
    //   65: aconst_null
    //   66: areturn
    //   67: astore_0
    //   68: aload_0
    //   69: invokevirtual 77	java/lang/Exception:printStackTrace	()V
    //   72: aconst_null
    //   73: areturn
    //   74: astore_0
    //   75: aload_1
    //   76: ifnull +7 -> 83
    //   79: aload_1
    //   80: invokevirtual 74	java/io/ObjectInputStream:close	()V
    //   83: aload_0
    //   84: athrow
    //   85: astore_1
    //   86: aload_1
    //   87: invokevirtual 77	java/lang/Exception:printStackTrace	()V
    //   90: goto -7 -> 83
    //   93: aconst_null
    //   94: areturn
    //   95: astore_2
    //   96: aload_0
    //   97: astore_1
    //   98: aload_2
    //   99: astore_0
    //   100: goto -25 -> 75
    //   103: astore_1
    //   104: goto -47 -> 57
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	107	0	paramString	String
    //   1	79	1	localSearchHistoryItem	SearchHistoryItem
    //   85	2	1	localException1	java.lang.Exception
    //   97	1	1	str	String
    //   103	1	1	localException2	java.lang.Exception
    //   95	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   41	45	47	java/lang/Exception
    //   6	29	54	java/lang/Exception
    //   61	65	67	java/lang/Exception
    //   6	29	74	finally
    //   79	83	85	java/lang/Exception
    //   29	37	95	finally
    //   29	37	103	java/lang/Exception
  }
  
  public SearchHistoryItem copy()
  {
    return new SearchHistoryItem(this.mSearchContent, this.mSearchTime, this.mSearchTag);
  }
  
  public String getSearchContent()
  {
    return this.mSearchContent;
  }
  
  String getSearchTag()
  {
    return this.mSearchTag;
  }
  
  long getSearchTime()
  {
    return this.mSearchTime;
  }
  
  public int getSearchType()
  {
    if ("subject".equals(this.mSearchTag)) {
      return 4;
    }
    if ("receiver".equals(this.mSearchTag)) {
      return 2;
    }
    if ("sender".equals(this.mSearchTag)) {
      return 1;
    }
    return 7;
  }
  
  /* Error */
  String object2String()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: new 97	java/io/ByteArrayOutputStream
    //   6: dup
    //   7: invokespecial 98	java/io/ByteArrayOutputStream:<init>	()V
    //   10: astore_2
    //   11: new 100	java/io/ObjectOutputStream
    //   14: dup
    //   15: aload_2
    //   16: invokespecial 103	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   19: astore_1
    //   20: aload_1
    //   21: astore 4
    //   23: aload_2
    //   24: astore_3
    //   25: aload_1
    //   26: aload_0
    //   27: invokevirtual 107	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   30: aload_1
    //   31: astore 4
    //   33: aload_2
    //   34: astore_3
    //   35: aload_1
    //   36: invokevirtual 110	java/io/ObjectOutputStream:flush	()V
    //   39: aload_1
    //   40: astore 4
    //   42: aload_2
    //   43: astore_3
    //   44: aload_2
    //   45: invokevirtual 113	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   48: iconst_0
    //   49: invokestatic 117	android/util/Base64:encodeToString	([BI)Ljava/lang/String;
    //   52: astore 5
    //   54: aload 5
    //   56: astore_3
    //   57: aload_1
    //   58: ifnull +7 -> 65
    //   61: aload_1
    //   62: invokevirtual 118	java/io/ObjectOutputStream:close	()V
    //   65: aload_3
    //   66: astore_1
    //   67: aload_2
    //   68: ifnull +9 -> 77
    //   71: aload_2
    //   72: invokevirtual 119	java/io/ByteArrayOutputStream:close	()V
    //   75: aload_3
    //   76: astore_1
    //   77: aload_1
    //   78: areturn
    //   79: astore_1
    //   80: aload_1
    //   81: invokevirtual 120	java/io/IOException:printStackTrace	()V
    //   84: aload_3
    //   85: areturn
    //   86: astore 5
    //   88: aconst_null
    //   89: astore_1
    //   90: aconst_null
    //   91: astore_2
    //   92: aload_1
    //   93: astore 4
    //   95: aload_2
    //   96: astore_3
    //   97: aload 5
    //   99: invokevirtual 120	java/io/IOException:printStackTrace	()V
    //   102: aload_1
    //   103: ifnull +7 -> 110
    //   106: aload_1
    //   107: invokevirtual 118	java/io/ObjectOutputStream:close	()V
    //   110: aload 6
    //   112: astore_1
    //   113: aload_2
    //   114: ifnull -37 -> 77
    //   117: aload_2
    //   118: invokevirtual 119	java/io/ByteArrayOutputStream:close	()V
    //   121: aconst_null
    //   122: areturn
    //   123: astore_1
    //   124: aload_1
    //   125: invokevirtual 120	java/io/IOException:printStackTrace	()V
    //   128: aconst_null
    //   129: areturn
    //   130: astore_1
    //   131: aconst_null
    //   132: astore 4
    //   134: aconst_null
    //   135: astore_2
    //   136: aload 4
    //   138: ifnull +8 -> 146
    //   141: aload 4
    //   143: invokevirtual 118	java/io/ObjectOutputStream:close	()V
    //   146: aload_2
    //   147: ifnull +7 -> 154
    //   150: aload_2
    //   151: invokevirtual 119	java/io/ByteArrayOutputStream:close	()V
    //   154: aload_1
    //   155: athrow
    //   156: astore_2
    //   157: aload_2
    //   158: invokevirtual 120	java/io/IOException:printStackTrace	()V
    //   161: goto -7 -> 154
    //   164: astore_1
    //   165: aconst_null
    //   166: astore 4
    //   168: goto -32 -> 136
    //   171: astore_1
    //   172: aload_3
    //   173: astore_2
    //   174: goto -38 -> 136
    //   177: astore 5
    //   179: aconst_null
    //   180: astore_1
    //   181: goto -89 -> 92
    //   184: astore 5
    //   186: goto -94 -> 92
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	189	0	this	SearchHistoryItem
    //   19	59	1	localObject1	Object
    //   79	2	1	localIOException1	java.io.IOException
    //   89	24	1	localObject2	Object
    //   123	2	1	localIOException2	java.io.IOException
    //   130	25	1	localObject3	Object
    //   164	1	1	localObject4	Object
    //   171	1	1	localObject5	Object
    //   180	1	1	localObject6	Object
    //   10	141	2	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   156	2	2	localIOException3	java.io.IOException
    //   173	1	2	localObject7	Object
    //   24	149	3	localObject8	Object
    //   21	146	4	localObject9	Object
    //   52	3	5	str	String
    //   86	12	5	localIOException4	java.io.IOException
    //   177	1	5	localIOException5	java.io.IOException
    //   184	1	5	localIOException6	java.io.IOException
    //   1	110	6	localObject10	Object
    // Exception table:
    //   from	to	target	type
    //   61	65	79	java/io/IOException
    //   71	75	79	java/io/IOException
    //   3	11	86	java/io/IOException
    //   106	110	123	java/io/IOException
    //   117	121	123	java/io/IOException
    //   3	11	130	finally
    //   141	146	156	java/io/IOException
    //   150	154	156	java/io/IOException
    //   11	20	164	finally
    //   25	30	171	finally
    //   35	39	171	finally
    //   44	54	171	finally
    //   97	102	171	finally
    //   11	20	177	java/io/IOException
    //   25	30	184	java/io/IOException
    //   35	39	184	java/io/IOException
    //   44	54	184	java/io/IOException
  }
  
  public void setSearchContent(String paramString)
  {
    this.mSearchContent = paramString;
  }
  
  void setSearchTag(String paramString)
  {
    this.mSearchTag = paramString;
  }
  
  public void setSearchTime(long paramLong)
  {
    this.mSearchTime = paramLong;
  }
  
  public void setSearchType(int paramInt)
  {
    if (paramInt == 4)
    {
      this.mSearchTag = "subject";
      return;
    }
    if (paramInt == 2)
    {
      this.mSearchTag = "receiver";
      return;
    }
    if (paramInt == 1)
    {
      this.mSearchTag = "sender";
      return;
    }
    this.mSearchTag = "all";
  }
  
  public String toString()
  {
    return this.mSearchContent + " " + this.mSearchTime + " " + this.mSearchTag;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.maillist.SearchHistoryItem
 * JD-Core Version:    0.7.0.1
 */