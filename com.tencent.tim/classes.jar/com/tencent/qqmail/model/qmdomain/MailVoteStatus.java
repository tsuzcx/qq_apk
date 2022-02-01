package com.tencent.qqmail.model.qmdomain;

public class MailVoteStatus
  extends QMDomain
{
  private static final long serialVersionUID = 2950094490704942167L;
  private boolean canVote;
  private int count;
  private boolean open;
  
  public int getCount()
  {
    return this.count;
  }
  
  public boolean isCanVote()
  {
    return this.canVote;
  }
  
  public boolean isOpen()
  {
    return this.open;
  }
  
  /* Error */
  public boolean parseWithDictionary(com.alibaba.fastjson.JSONObject paramJSONObject)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 6
    //   3: aload_1
    //   4: ldc 35
    //   6: invokevirtual 41	com/alibaba/fastjson/JSONObject:getLong	(Ljava/lang/String;)Ljava/lang/Long;
    //   9: invokevirtual 47	java/lang/Long:longValue	()J
    //   12: lstore 7
    //   14: aload_1
    //   15: ldc 35
    //   17: invokevirtual 51	com/alibaba/fastjson/JSONObject:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   20: ifnull +138 -> 158
    //   23: aload_0
    //   24: invokevirtual 53	com/tencent/qqmail/model/qmdomain/MailVoteStatus:getCount	()I
    //   27: istore_2
    //   28: iload_2
    //   29: lload 7
    //   31: l2i
    //   32: if_icmpeq +126 -> 158
    //   35: lload 7
    //   37: l2i
    //   38: istore_2
    //   39: aload_0
    //   40: iload_2
    //   41: invokevirtual 57	com/tencent/qqmail/model/qmdomain/MailVoteStatus:setCount	(I)V
    //   44: iconst_1
    //   45: istore_3
    //   46: iload_3
    //   47: istore 5
    //   49: aload_1
    //   50: ldc 58
    //   52: invokevirtual 51	com/alibaba/fastjson/JSONObject:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   55: astore 9
    //   57: iload_3
    //   58: istore 4
    //   60: aload 9
    //   62: ifnull +31 -> 93
    //   65: iload_3
    //   66: istore 5
    //   68: aload 9
    //   70: invokevirtual 64	java/lang/Object:toString	()Ljava/lang/String;
    //   73: ldc 66
    //   75: invokevirtual 72	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   78: istore_3
    //   79: iload_3
    //   80: ifeq +60 -> 140
    //   83: iconst_1
    //   84: istore_3
    //   85: aload_0
    //   86: iload_3
    //   87: invokevirtual 76	com/tencent/qqmail/model/qmdomain/MailVoteStatus:setOpen	(Z)V
    //   90: iconst_1
    //   91: istore 4
    //   93: iload 4
    //   95: istore 5
    //   97: aload_1
    //   98: ldc 78
    //   100: invokevirtual 51	com/alibaba/fastjson/JSONObject:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   103: astore_1
    //   104: aload_1
    //   105: ifnull +50 -> 155
    //   108: iload 4
    //   110: istore 5
    //   112: aload_1
    //   113: invokevirtual 64	java/lang/Object:toString	()Ljava/lang/String;
    //   116: ldc 66
    //   118: invokevirtual 72	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   121: istore 4
    //   123: iload 6
    //   125: istore_3
    //   126: iload 4
    //   128: ifeq +5 -> 133
    //   131: iconst_1
    //   132: istore_3
    //   133: aload_0
    //   134: iload_3
    //   135: invokevirtual 81	com/tencent/qqmail/model/qmdomain/MailVoteStatus:setCanVote	(Z)V
    //   138: iconst_1
    //   139: ireturn
    //   140: iconst_0
    //   141: istore_3
    //   142: goto -57 -> 85
    //   145: astore_1
    //   146: iconst_0
    //   147: ireturn
    //   148: astore_1
    //   149: iconst_1
    //   150: ireturn
    //   151: astore_1
    //   152: iload 5
    //   154: ireturn
    //   155: iload 4
    //   157: ireturn
    //   158: iconst_0
    //   159: istore_3
    //   160: goto -114 -> 46
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	163	0	this	MailVoteStatus
    //   0	163	1	paramJSONObject	com.alibaba.fastjson.JSONObject
    //   27	14	2	i	int
    //   45	115	3	bool1	boolean
    //   58	98	4	bool2	boolean
    //   47	106	5	bool3	boolean
    //   1	123	6	bool4	boolean
    //   12	24	7	l	long
    //   55	14	9	localObject	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   3	28	145	java/lang/Exception
    //   39	44	148	java/lang/Exception
    //   85	90	148	java/lang/Exception
    //   133	138	148	java/lang/Exception
    //   49	57	151	java/lang/Exception
    //   68	79	151	java/lang/Exception
    //   97	104	151	java/lang/Exception
    //   112	123	151	java/lang/Exception
  }
  
  public void setCanVote(boolean paramBoolean)
  {
    this.canVote = paramBoolean;
  }
  
  public void setCount(int paramInt)
  {
    this.count = paramInt;
  }
  
  public void setOpen(boolean paramBoolean)
  {
    this.open = paramBoolean;
  }
  
  public String toString()
  {
    int j = 1;
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("{");
    localStringBuffer.append("\"class\":\"MailVoteStatus\",");
    localStringBuffer.append("\"cnt\":" + getCount() + ",");
    StringBuilder localStringBuilder = new StringBuilder().append("\"open\":");
    if (isOpen())
    {
      i = 1;
      localStringBuffer.append(i + ",");
      localStringBuilder = new StringBuilder().append("\"canvote\":");
      if (!isCanVote()) {
        break label152;
      }
    }
    label152:
    for (int i = j;; i = 0)
    {
      localStringBuffer.append(i);
      localStringBuffer.append("}");
      return localStringBuffer.toString();
      i = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.qmdomain.MailVoteStatus
 * JD-Core Version:    0.7.0.1
 */