package com.tencent.qqmail.model.qmdomain;

import androidx.annotation.Nullable;
import java.util.ArrayList;

public class MailContent
  extends QMDomain
{
  private static final long serialVersionUID = 468803378799822333L;
  private String body;
  private String bodyText;
  private String draft;
  private MailFoldTextList foldText_ = new MailFoldTextList();
  private MailFoldList fold_ = new MailFoldList();
  private String origin;
  private String originText;
  private float scale = -1.0F;
  private float width = -1.0F;
  
  @Nullable
  public String getBody()
  {
    return this.body;
  }
  
  public String getBodyText()
  {
    return this.bodyText;
  }
  
  public String getDraft()
  {
    return this.draft;
  }
  
  public ArrayList<MailFoldItem> getFold()
  {
    return this.fold_.list;
  }
  
  public ArrayList<MailFoldItem> getFoldText()
  {
    return this.foldText_.list;
  }
  
  public String getOrigin()
  {
    return this.origin;
  }
  
  public String getOriginText()
  {
    return this.originText;
  }
  
  public float getScale()
  {
    if (this.scale <= 0.0F) {
      return 1.0F;
    }
    return this.scale;
  }
  
  public float getWidth()
  {
    return this.width;
  }
  
  /* Error */
  public boolean parseWithDictionary(com.alibaba.fastjson.JSONObject paramJSONObject)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 5
    //   3: iconst_0
    //   4: istore 7
    //   6: iload 5
    //   8: istore 4
    //   10: aload_1
    //   11: ldc 77
    //   13: invokevirtual 83	com/alibaba/fastjson/JSONObject:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   16: checkcast 85	java/lang/String
    //   19: astore 9
    //   21: aload 9
    //   23: ifnull +617 -> 640
    //   26: iload 5
    //   28: istore 4
    //   30: aload_0
    //   31: invokevirtual 87	com/tencent/qqmail/model/qmdomain/MailContent:getBody	()Ljava/lang/String;
    //   34: ifnull +39 -> 73
    //   37: iload 5
    //   39: istore 4
    //   41: aload_0
    //   42: invokevirtual 87	com/tencent/qqmail/model/qmdomain/MailContent:getBody	()Ljava/lang/String;
    //   45: ldc 89
    //   47: invokevirtual 93	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   50: ifne +23 -> 73
    //   53: iload 5
    //   55: istore 4
    //   57: aload_0
    //   58: invokevirtual 87	com/tencent/qqmail/model/qmdomain/MailContent:getBody	()Ljava/lang/String;
    //   61: aload 9
    //   63: invokevirtual 93	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   66: istore 5
    //   68: iload 5
    //   70: ifne +570 -> 640
    //   73: aload_0
    //   74: aload 9
    //   76: invokevirtual 97	com/tencent/qqmail/model/qmdomain/MailContent:setBody	(Ljava/lang/String;)V
    //   79: iconst_1
    //   80: istore 6
    //   82: iload 6
    //   84: istore 4
    //   86: aload_1
    //   87: ldc 99
    //   89: invokevirtual 83	com/alibaba/fastjson/JSONObject:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   92: checkcast 85	java/lang/String
    //   95: astore 9
    //   97: iload 6
    //   99: istore 5
    //   101: aload 9
    //   103: ifnull +63 -> 166
    //   106: iload 6
    //   108: istore 4
    //   110: aload_0
    //   111: invokevirtual 101	com/tencent/qqmail/model/qmdomain/MailContent:getBodyText	()Ljava/lang/String;
    //   114: ifnull +43 -> 157
    //   117: iload 6
    //   119: istore 4
    //   121: aload_0
    //   122: invokevirtual 101	com/tencent/qqmail/model/qmdomain/MailContent:getBodyText	()Ljava/lang/String;
    //   125: ldc 89
    //   127: invokevirtual 93	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   130: ifne +27 -> 157
    //   133: iload 6
    //   135: istore 4
    //   137: aload_0
    //   138: invokevirtual 101	com/tencent/qqmail/model/qmdomain/MailContent:getBodyText	()Ljava/lang/String;
    //   141: aload 9
    //   143: invokevirtual 93	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   146: istore 8
    //   148: iload 6
    //   150: istore 5
    //   152: iload 8
    //   154: ifne +12 -> 166
    //   157: aload_0
    //   158: aload 9
    //   160: invokevirtual 104	com/tencent/qqmail/model/qmdomain/MailContent:setBodyText	(Ljava/lang/String;)V
    //   163: iconst_1
    //   164: istore 5
    //   166: iload 5
    //   168: istore 4
    //   170: aload_1
    //   171: ldc 105
    //   173: invokevirtual 83	com/alibaba/fastjson/JSONObject:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   176: checkcast 85	java/lang/String
    //   179: astore 9
    //   181: iload 5
    //   183: istore 6
    //   185: aload 9
    //   187: ifnull +63 -> 250
    //   190: iload 5
    //   192: istore 4
    //   194: aload_0
    //   195: invokevirtual 107	com/tencent/qqmail/model/qmdomain/MailContent:getOrigin	()Ljava/lang/String;
    //   198: ifnull +43 -> 241
    //   201: iload 5
    //   203: istore 4
    //   205: aload_0
    //   206: invokevirtual 107	com/tencent/qqmail/model/qmdomain/MailContent:getOrigin	()Ljava/lang/String;
    //   209: ldc 89
    //   211: invokevirtual 93	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   214: ifne +27 -> 241
    //   217: iload 5
    //   219: istore 4
    //   221: aload_0
    //   222: invokevirtual 107	com/tencent/qqmail/model/qmdomain/MailContent:getOrigin	()Ljava/lang/String;
    //   225: aload 9
    //   227: invokevirtual 93	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   230: istore 8
    //   232: iload 5
    //   234: istore 6
    //   236: iload 8
    //   238: ifne +12 -> 250
    //   241: aload_0
    //   242: aload 9
    //   244: invokevirtual 110	com/tencent/qqmail/model/qmdomain/MailContent:setOrigin	(Ljava/lang/String;)V
    //   247: iconst_1
    //   248: istore 6
    //   250: iload 6
    //   252: istore 4
    //   254: aload_1
    //   255: ldc 112
    //   257: invokevirtual 83	com/alibaba/fastjson/JSONObject:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   260: checkcast 85	java/lang/String
    //   263: astore 9
    //   265: iload 6
    //   267: istore 5
    //   269: aload 9
    //   271: ifnull +63 -> 334
    //   274: iload 6
    //   276: istore 4
    //   278: aload_0
    //   279: invokevirtual 114	com/tencent/qqmail/model/qmdomain/MailContent:getOriginText	()Ljava/lang/String;
    //   282: ifnull +43 -> 325
    //   285: iload 6
    //   287: istore 4
    //   289: aload_0
    //   290: invokevirtual 114	com/tencent/qqmail/model/qmdomain/MailContent:getOriginText	()Ljava/lang/String;
    //   293: ldc 89
    //   295: invokevirtual 93	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   298: ifne +27 -> 325
    //   301: iload 6
    //   303: istore 4
    //   305: aload_0
    //   306: invokevirtual 114	com/tencent/qqmail/model/qmdomain/MailContent:getOriginText	()Ljava/lang/String;
    //   309: aload 9
    //   311: invokevirtual 93	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   314: istore 8
    //   316: iload 6
    //   318: istore 5
    //   320: iload 8
    //   322: ifne +12 -> 334
    //   325: aload_0
    //   326: aload 9
    //   328: invokevirtual 117	com/tencent/qqmail/model/qmdomain/MailContent:setOriginText	(Ljava/lang/String;)V
    //   331: iconst_1
    //   332: istore 5
    //   334: iload 5
    //   336: istore 4
    //   338: aload_1
    //   339: ldc 118
    //   341: invokevirtual 83	com/alibaba/fastjson/JSONObject:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   344: checkcast 85	java/lang/String
    //   347: astore 9
    //   349: iload 5
    //   351: istore 6
    //   353: aload 9
    //   355: ifnull +58 -> 413
    //   358: iload 5
    //   360: istore 4
    //   362: aload_0
    //   363: invokevirtual 120	com/tencent/qqmail/model/qmdomain/MailContent:getScale	()F
    //   366: ldc 36
    //   368: fcmpl
    //   369: ifne +32 -> 401
    //   372: iload 5
    //   374: istore 4
    //   376: aload_0
    //   377: invokevirtual 120	com/tencent/qqmail/model/qmdomain/MailContent:getScale	()F
    //   380: fstore_2
    //   381: iload 5
    //   383: istore 4
    //   385: aload 9
    //   387: invokestatic 126	java/lang/Float:parseFloat	(Ljava/lang/String;)F
    //   390: fstore_3
    //   391: iload 5
    //   393: istore 6
    //   395: fload_2
    //   396: fload_3
    //   397: fcmpl
    //   398: ifeq +15 -> 413
    //   401: aload_0
    //   402: aload 9
    //   404: invokestatic 126	java/lang/Float:parseFloat	(Ljava/lang/String;)F
    //   407: invokevirtual 130	com/tencent/qqmail/model/qmdomain/MailContent:setScale	(F)V
    //   410: iconst_1
    //   411: istore 6
    //   413: iload 6
    //   415: istore 4
    //   417: aload_1
    //   418: ldc 131
    //   420: invokevirtual 83	com/alibaba/fastjson/JSONObject:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   423: checkcast 85	java/lang/String
    //   426: astore 9
    //   428: aload 9
    //   430: ifnull +203 -> 633
    //   433: iload 6
    //   435: istore 4
    //   437: aload_0
    //   438: invokevirtual 133	com/tencent/qqmail/model/qmdomain/MailContent:getWidth	()F
    //   441: ldc 36
    //   443: fcmpl
    //   444: ifne +28 -> 472
    //   447: iload 6
    //   449: istore 4
    //   451: aload_0
    //   452: invokevirtual 133	com/tencent/qqmail/model/qmdomain/MailContent:getWidth	()F
    //   455: fstore_2
    //   456: iload 6
    //   458: istore 4
    //   460: aload 9
    //   462: invokestatic 126	java/lang/Float:parseFloat	(Ljava/lang/String;)F
    //   465: fstore_3
    //   466: fload_2
    //   467: fload_3
    //   468: fcmpl
    //   469: ifeq +164 -> 633
    //   472: aload_0
    //   473: aload 9
    //   475: invokestatic 126	java/lang/Float:parseFloat	(Ljava/lang/String;)F
    //   478: invokevirtual 136	com/tencent/qqmail/model/qmdomain/MailContent:setWidth	(F)V
    //   481: iconst_1
    //   482: istore 4
    //   484: iload 4
    //   486: istore 5
    //   488: aload_0
    //   489: getfield 30	com/tencent/qqmail/model/qmdomain/MailContent:fold_	Lcom/tencent/qqmail/model/qmdomain/MailFoldList;
    //   492: aload_1
    //   493: invokevirtual 138	com/tencent/qqmail/model/qmdomain/MailFoldList:parseWithDictionary	(Lcom/alibaba/fastjson/JSONObject;)Z
    //   496: ifne +150 -> 646
    //   499: iload 4
    //   501: ifeq +108 -> 609
    //   504: goto +142 -> 646
    //   507: iload 4
    //   509: istore 5
    //   511: aload_0
    //   512: getfield 35	com/tencent/qqmail/model/qmdomain/MailContent:foldText_	Lcom/tencent/qqmail/model/qmdomain/MailFoldTextList;
    //   515: aload_1
    //   516: invokevirtual 139	com/tencent/qqmail/model/qmdomain/MailFoldTextList:parseWithDictionary	(Lcom/alibaba/fastjson/JSONObject;)Z
    //   519: istore 6
    //   521: iload 6
    //   523: ifne +12 -> 535
    //   526: iload 7
    //   528: istore 5
    //   530: iload 4
    //   532: ifeq +6 -> 538
    //   535: iconst_1
    //   536: istore 5
    //   538: iload 5
    //   540: istore 4
    //   542: aload_1
    //   543: ldc 140
    //   545: invokevirtual 83	com/alibaba/fastjson/JSONObject:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   548: checkcast 85	java/lang/String
    //   551: astore_1
    //   552: aload_1
    //   553: ifnull +77 -> 630
    //   556: iload 5
    //   558: istore 4
    //   560: aload_0
    //   561: invokevirtual 142	com/tencent/qqmail/model/qmdomain/MailContent:getDraft	()Ljava/lang/String;
    //   564: ifnull +38 -> 602
    //   567: iload 5
    //   569: istore 4
    //   571: aload_0
    //   572: invokevirtual 142	com/tencent/qqmail/model/qmdomain/MailContent:getDraft	()Ljava/lang/String;
    //   575: ldc 89
    //   577: invokevirtual 93	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   580: ifne +22 -> 602
    //   583: iload 5
    //   585: istore 4
    //   587: aload_0
    //   588: invokevirtual 142	com/tencent/qqmail/model/qmdomain/MailContent:getDraft	()Ljava/lang/String;
    //   591: aload_1
    //   592: invokevirtual 93	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   595: istore 6
    //   597: iload 6
    //   599: ifne +31 -> 630
    //   602: aload_0
    //   603: aload_1
    //   604: invokevirtual 145	com/tencent/qqmail/model/qmdomain/MailContent:setDraft	(Ljava/lang/String;)V
    //   607: iconst_1
    //   608: ireturn
    //   609: iconst_0
    //   610: istore 4
    //   612: goto -105 -> 507
    //   615: astore_1
    //   616: iload 4
    //   618: ireturn
    //   619: astore_1
    //   620: iconst_1
    //   621: ireturn
    //   622: astore_1
    //   623: iload 4
    //   625: ireturn
    //   626: astore_1
    //   627: iload 5
    //   629: ireturn
    //   630: iload 5
    //   632: ireturn
    //   633: iload 6
    //   635: istore 4
    //   637: goto -153 -> 484
    //   640: iconst_0
    //   641: istore 6
    //   643: goto -561 -> 82
    //   646: iconst_1
    //   647: istore 4
    //   649: goto -142 -> 507
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	652	0	this	MailContent
    //   0	652	1	paramJSONObject	com.alibaba.fastjson.JSONObject
    //   380	87	2	f1	float
    //   390	78	3	f2	float
    //   8	640	4	bool1	boolean
    //   1	630	5	bool2	boolean
    //   80	562	6	bool3	boolean
    //   4	523	7	bool4	boolean
    //   146	175	8	bool5	boolean
    //   19	455	9	str	String
    // Exception table:
    //   from	to	target	type
    //   10	21	615	java/lang/Exception
    //   30	37	615	java/lang/Exception
    //   41	53	615	java/lang/Exception
    //   57	68	615	java/lang/Exception
    //   542	552	615	java/lang/Exception
    //   560	567	615	java/lang/Exception
    //   571	583	615	java/lang/Exception
    //   587	597	615	java/lang/Exception
    //   73	79	619	java/lang/Exception
    //   157	163	619	java/lang/Exception
    //   241	247	619	java/lang/Exception
    //   325	331	619	java/lang/Exception
    //   401	410	619	java/lang/Exception
    //   472	481	619	java/lang/Exception
    //   602	607	619	java/lang/Exception
    //   86	97	622	java/lang/Exception
    //   110	117	622	java/lang/Exception
    //   121	133	622	java/lang/Exception
    //   137	148	622	java/lang/Exception
    //   170	181	622	java/lang/Exception
    //   194	201	622	java/lang/Exception
    //   205	217	622	java/lang/Exception
    //   221	232	622	java/lang/Exception
    //   254	265	622	java/lang/Exception
    //   278	285	622	java/lang/Exception
    //   289	301	622	java/lang/Exception
    //   305	316	622	java/lang/Exception
    //   338	349	622	java/lang/Exception
    //   362	372	622	java/lang/Exception
    //   376	381	622	java/lang/Exception
    //   385	391	622	java/lang/Exception
    //   417	428	622	java/lang/Exception
    //   437	447	622	java/lang/Exception
    //   451	456	622	java/lang/Exception
    //   460	466	622	java/lang/Exception
    //   488	499	626	java/lang/Exception
    //   511	521	626	java/lang/Exception
  }
  
  public void setBody(String paramString)
  {
    this.body = paramString;
  }
  
  public void setBodyText(String paramString)
  {
    this.bodyText = paramString;
  }
  
  public void setDraft(String paramString)
  {
    this.draft = paramString;
  }
  
  public void setFold(ArrayList<MailFoldItem> paramArrayList)
  {
    this.fold_.list = paramArrayList;
  }
  
  public void setFoldText(ArrayList<MailFoldItem> paramArrayList)
  {
    this.foldText_.list = paramArrayList;
  }
  
  public void setOrigin(String paramString)
  {
    this.origin = paramString;
  }
  
  public void setOriginText(String paramString)
  {
    this.originText = paramString;
  }
  
  public void setScale(float paramFloat)
  {
    this.scale = paramFloat;
  }
  
  public void setWidth(float paramFloat)
  {
    this.width = paramFloat;
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("{");
    localStringBuffer.append("\"class\":\"MailContent\",");
    String str;
    if (getBody() != null)
    {
      str = getBody().replaceAll("\\\\", "\\\\\\\\").replaceAll("\"", "\\\\\"");
      localStringBuffer.append("\"body\":\"" + str + "\",");
    }
    if (getBodyText() != null)
    {
      str = getBodyText().replaceAll("\\\\", "\\\\\\\\").replaceAll("\"", "\\\\\"");
      localStringBuffer.append("\"bodytext\":\"" + str + "\",");
    }
    if (getDraft() != null)
    {
      str = getDraft().replaceAll("\\\\", "\\\\\\\\");
      localStringBuffer.append("\"draft\":\"" + str.replaceAll("\"", "\\\\\"") + "\",");
    }
    if (getOrigin() != null)
    {
      str = getOrigin().replaceAll("\\\\", "\\\\\\\\");
      localStringBuffer.append("\"origin\":\"" + str.replaceAll("\"", "\\\\\"") + "\",");
    }
    if (getOriginText() != null)
    {
      str = getOriginText().replaceAll("\\\\", "\\\\\\\\");
      localStringBuffer.append("\"origintext\":\"" + str.replaceAll("\"", "\\\\\"") + "\",");
    }
    if (this.fold_ != null)
    {
      str = this.fold_.toString();
      localStringBuffer.append(str);
      if (str.length() > 0) {
        localStringBuffer.append(',');
      }
    }
    if (this.foldText_ != null)
    {
      str = this.foldText_.toString();
      localStringBuffer.append(str);
      if (str.length() > 0) {
        localStringBuffer.append(',');
      }
    }
    localStringBuffer.append("\"scale\":\"" + getScale() + "\",");
    localStringBuffer.append("\"width\":\"" + getWidth() + "\"");
    localStringBuffer.append("}");
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.qmdomain.MailContent
 * JD-Core Version:    0.7.0.1
 */