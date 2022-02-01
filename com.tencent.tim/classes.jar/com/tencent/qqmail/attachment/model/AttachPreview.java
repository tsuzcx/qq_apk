package com.tencent.qqmail.attachment.model;

import com.tencent.qqmail.model.qmdomain.QMDomain;
import java.util.ArrayList;
import java.util.Iterator;

public class AttachPreview
  extends QMDomain
{
  private ArrayList<String> copyDiskList = new ArrayList();
  private String downloadUrl;
  private boolean enableAttFolder;
  private String icon;
  private String iconOrg;
  private boolean isAudio;
  private boolean isEmbed;
  private boolean isPic;
  private AttachType itype;
  private String iviewtype;
  private String myDisk;
  private String viewType;
  
  public static String formatCopyDiskList(ArrayList<String> paramArrayList)
  {
    Object localObject;
    if (paramArrayList == null)
    {
      localObject = "";
      return localObject;
    }
    Iterator localIterator = paramArrayList.iterator();
    for (paramArrayList = "";; paramArrayList = paramArrayList + (String)localObject + "&sep&")
    {
      localObject = paramArrayList;
      if (!localIterator.hasNext()) {
        break;
      }
      localObject = (String)localIterator.next();
    }
  }
  
  public static String[] parseCopyDiskList(String paramString)
  {
    if ((paramString != null) && (!paramString.equals(""))) {
      return paramString.split("&sep&");
    }
    return null;
  }
  
  public void addCopyDisk(String paramString)
  {
    this.copyDiskList.add(paramString);
  }
  
  public ArrayList<String> getCopyDiskList()
  {
    return this.copyDiskList;
  }
  
  public String getDownloadUrl()
  {
    return this.downloadUrl;
  }
  
  public String getIcon()
  {
    return this.icon;
  }
  
  public String getIconOrg()
  {
    return this.iconOrg;
  }
  
  public AttachType getItype()
  {
    return this.itype;
  }
  
  public String getIviewtype()
  {
    return this.iviewtype;
  }
  
  public String getMyDisk()
  {
    return this.myDisk;
  }
  
  public String getViewType()
  {
    return this.viewType;
  }
  
  public boolean isAudio()
  {
    return this.isAudio;
  }
  
  public boolean isEmbed()
  {
    return this.isEmbed;
  }
  
  public boolean isEnableAttFolder()
  {
    return this.enableAttFolder;
  }
  
  public boolean isPic()
  {
    return this.isPic;
  }
  
  /* Error */
  public boolean parseWithDictionary(com.alibaba.fastjson.JSONObject paramJSONObject)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: iconst_0
    //   4: istore 8
    //   6: iload 4
    //   8: istore 5
    //   10: aload_1
    //   11: ldc 120
    //   13: invokevirtual 126	com/alibaba/fastjson/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   16: astore 10
    //   18: aload 10
    //   20: ifnull +553 -> 573
    //   23: iload 4
    //   25: istore 5
    //   27: aload_0
    //   28: invokevirtual 128	com/tencent/qqmail/attachment/model/AttachPreview:getDownloadUrl	()Ljava/lang/String;
    //   31: aload 10
    //   33: invokestatic 134	com/tencent/qqmail/utilities/common/CommUtils:isNullorBlankorNotEquals	(Ljava/lang/String;Ljava/lang/String;)Z
    //   36: istore 4
    //   38: iload 4
    //   40: ifeq +533 -> 573
    //   43: aload_0
    //   44: aload 10
    //   46: invokestatic 139	com/tencent/qqmail/utilities/qmnetwork/CGIManager:clearSid	(Ljava/lang/String;)Ljava/lang/String;
    //   49: ldc 141
    //   51: ldc 143
    //   53: invokevirtual 147	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   56: invokevirtual 150	com/tencent/qqmail/attachment/model/AttachPreview:setDownloadUrl	(Ljava/lang/String;)V
    //   59: iconst_1
    //   60: istore 6
    //   62: iload 6
    //   64: istore 4
    //   66: aload_1
    //   67: ldc 151
    //   69: invokevirtual 126	com/alibaba/fastjson/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   72: astore 10
    //   74: iload 6
    //   76: istore 5
    //   78: aload 10
    //   80: ifnull +36 -> 116
    //   83: iload 6
    //   85: istore 4
    //   87: aload_0
    //   88: invokevirtual 153	com/tencent/qqmail/attachment/model/AttachPreview:getIcon	()Ljava/lang/String;
    //   91: aload 10
    //   93: invokestatic 134	com/tencent/qqmail/utilities/common/CommUtils:isNullorBlankorNotEquals	(Ljava/lang/String;Ljava/lang/String;)Z
    //   96: istore 7
    //   98: iload 6
    //   100: istore 5
    //   102: iload 7
    //   104: ifeq +12 -> 116
    //   107: aload_0
    //   108: aload 10
    //   110: invokevirtual 156	com/tencent/qqmail/attachment/model/AttachPreview:setIcon	(Ljava/lang/String;)V
    //   113: iconst_1
    //   114: istore 5
    //   116: iload 5
    //   118: istore 4
    //   120: aload_1
    //   121: ldc 158
    //   123: invokevirtual 126	com/alibaba/fastjson/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   126: astore 10
    //   128: iload 5
    //   130: istore 6
    //   132: aload 10
    //   134: ifnull +36 -> 170
    //   137: iload 5
    //   139: istore 4
    //   141: aload_0
    //   142: invokevirtual 160	com/tencent/qqmail/attachment/model/AttachPreview:getIconOrg	()Ljava/lang/String;
    //   145: aload 10
    //   147: invokestatic 134	com/tencent/qqmail/utilities/common/CommUtils:isNullorBlankorNotEquals	(Ljava/lang/String;Ljava/lang/String;)Z
    //   150: istore 7
    //   152: iload 5
    //   154: istore 6
    //   156: iload 7
    //   158: ifeq +12 -> 170
    //   161: aload_0
    //   162: aload 10
    //   164: invokevirtual 163	com/tencent/qqmail/attachment/model/AttachPreview:setIconOrg	(Ljava/lang/String;)V
    //   167: iconst_1
    //   168: istore 6
    //   170: iload 6
    //   172: istore 4
    //   174: aload_1
    //   175: ldc 165
    //   177: invokevirtual 126	com/alibaba/fastjson/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   180: astore 10
    //   182: iload 6
    //   184: istore 5
    //   186: aload 10
    //   188: ifnull +36 -> 224
    //   191: iload 6
    //   193: istore 4
    //   195: aload_0
    //   196: invokevirtual 167	com/tencent/qqmail/attachment/model/AttachPreview:getMyDisk	()Ljava/lang/String;
    //   199: aload 10
    //   201: invokestatic 134	com/tencent/qqmail/utilities/common/CommUtils:isNullorBlankorNotEquals	(Ljava/lang/String;Ljava/lang/String;)Z
    //   204: istore 7
    //   206: iload 6
    //   208: istore 5
    //   210: iload 7
    //   212: ifeq +12 -> 224
    //   215: aload_0
    //   216: aload 10
    //   218: invokevirtual 170	com/tencent/qqmail/attachment/model/AttachPreview:setMyDisk	(Ljava/lang/String;)V
    //   221: iconst_1
    //   222: istore 5
    //   224: iload 5
    //   226: istore 4
    //   228: aload_1
    //   229: ldc 172
    //   231: invokevirtual 176	com/alibaba/fastjson/JSONObject:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   234: ifnull +333 -> 567
    //   237: iload 5
    //   239: istore 4
    //   241: ldc 178
    //   243: aload_1
    //   244: ldc 172
    //   246: invokevirtual 126	com/alibaba/fastjson/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   249: invokevirtual 72	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   252: ifne +315 -> 567
    //   255: iconst_1
    //   256: istore 7
    //   258: iload 5
    //   260: istore 6
    //   262: iload 5
    //   264: istore 4
    //   266: aload_1
    //   267: ldc 172
    //   269: invokevirtual 176	com/alibaba/fastjson/JSONObject:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   272: ifnull +33 -> 305
    //   275: iload 5
    //   277: istore 4
    //   279: aload_0
    //   280: invokevirtual 180	com/tencent/qqmail/attachment/model/AttachPreview:isPic	()Z
    //   283: istore 9
    //   285: iload 5
    //   287: istore 6
    //   289: iload 7
    //   291: iload 9
    //   293: if_icmpeq +12 -> 305
    //   296: aload_0
    //   297: iload 7
    //   299: invokevirtual 184	com/tencent/qqmail/attachment/model/AttachPreview:setIsPic	(Z)V
    //   302: iconst_1
    //   303: istore 6
    //   305: iload 6
    //   307: istore 4
    //   309: aload_1
    //   310: ldc 185
    //   312: invokevirtual 126	com/alibaba/fastjson/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   315: astore 10
    //   317: iload 6
    //   319: istore 7
    //   321: aload 10
    //   323: ifnull +36 -> 359
    //   326: iload 6
    //   328: istore 4
    //   330: aload_0
    //   331: invokevirtual 187	com/tencent/qqmail/attachment/model/AttachPreview:getIviewtype	()Ljava/lang/String;
    //   334: aload 10
    //   336: invokestatic 134	com/tencent/qqmail/utilities/common/CommUtils:isNullorBlankorNotEquals	(Ljava/lang/String;Ljava/lang/String;)Z
    //   339: istore 5
    //   341: iload 6
    //   343: istore 7
    //   345: iload 5
    //   347: ifeq +12 -> 359
    //   350: aload_0
    //   351: aload 10
    //   353: invokevirtual 190	com/tencent/qqmail/attachment/model/AttachPreview:setIviewtype	(Ljava/lang/String;)V
    //   356: iconst_1
    //   357: istore 7
    //   359: iload 7
    //   361: istore 4
    //   363: aload_1
    //   364: ldc 192
    //   366: invokevirtual 126	com/alibaba/fastjson/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   369: astore 10
    //   371: iload 7
    //   373: istore 5
    //   375: aload 10
    //   377: ifnull +36 -> 413
    //   380: iload 7
    //   382: istore 4
    //   384: aload_0
    //   385: invokevirtual 194	com/tencent/qqmail/attachment/model/AttachPreview:getViewType	()Ljava/lang/String;
    //   388: aload 10
    //   390: invokestatic 134	com/tencent/qqmail/utilities/common/CommUtils:isNullorBlankorNotEquals	(Ljava/lang/String;Ljava/lang/String;)Z
    //   393: istore 6
    //   395: iload 7
    //   397: istore 5
    //   399: iload 6
    //   401: ifeq +12 -> 413
    //   404: aload_0
    //   405: aload 10
    //   407: invokevirtual 197	com/tencent/qqmail/attachment/model/AttachPreview:setViewType	(Ljava/lang/String;)V
    //   410: iconst_1
    //   411: istore 5
    //   413: iload 8
    //   415: istore 6
    //   417: iload 5
    //   419: istore 4
    //   421: aload_1
    //   422: ldc 199
    //   424: invokevirtual 176	com/alibaba/fastjson/JSONObject:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   427: ifnull +28 -> 455
    //   430: iload 8
    //   432: istore 6
    //   434: iload 5
    //   436: istore 4
    //   438: ldc 178
    //   440: aload_1
    //   441: ldc 199
    //   443: invokevirtual 126	com/alibaba/fastjson/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   446: invokevirtual 72	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   449: ifne +6 -> 455
    //   452: iconst_1
    //   453: istore 6
    //   455: iload 5
    //   457: istore 4
    //   459: aload_1
    //   460: ldc 199
    //   462: invokevirtual 176	com/alibaba/fastjson/JSONObject:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   465: ifnull +95 -> 560
    //   468: iload 5
    //   470: istore 4
    //   472: aload_0
    //   473: invokevirtual 201	com/tencent/qqmail/attachment/model/AttachPreview:isEnableAttFolder	()Z
    //   476: istore 7
    //   478: iload 6
    //   480: iload 7
    //   482: if_icmpeq +78 -> 560
    //   485: aload_0
    //   486: iload 6
    //   488: invokevirtual 204	com/tencent/qqmail/attachment/model/AttachPreview:setEnableAttFolder	(Z)V
    //   491: iconst_1
    //   492: istore 4
    //   494: iload 4
    //   496: istore 5
    //   498: aload_1
    //   499: ldc 206
    //   501: invokevirtual 176	com/alibaba/fastjson/JSONObject:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   504: ifnull +53 -> 557
    //   507: iload 4
    //   509: istore 5
    //   511: aload_1
    //   512: ldc 206
    //   514: invokevirtual 210	com/alibaba/fastjson/JSONObject:getIntValue	(Ljava/lang/String;)I
    //   517: istore_2
    //   518: iload 4
    //   520: istore 5
    //   522: aload_0
    //   523: invokevirtual 212	com/tencent/qqmail/attachment/model/AttachPreview:getItype	()Lcom/tencent/qqmail/attachment/model/AttachType;
    //   526: invokevirtual 218	com/tencent/qqmail/attachment/model/AttachType:ordinal	()I
    //   529: istore_3
    //   530: iload_2
    //   531: iload_3
    //   532: if_icmpeq +25 -> 557
    //   535: aload_0
    //   536: invokestatic 222	com/tencent/qqmail/attachment/model/AttachType:values	()[Lcom/tencent/qqmail/attachment/model/AttachType;
    //   539: iload_2
    //   540: aaload
    //   541: invokevirtual 226	com/tencent/qqmail/attachment/model/AttachPreview:setItype	(Lcom/tencent/qqmail/attachment/model/AttachType;)V
    //   544: iconst_1
    //   545: ireturn
    //   546: astore_1
    //   547: iload 5
    //   549: ireturn
    //   550: astore_1
    //   551: iconst_1
    //   552: ireturn
    //   553: astore_1
    //   554: iload 4
    //   556: ireturn
    //   557: iload 4
    //   559: ireturn
    //   560: iload 5
    //   562: istore 4
    //   564: goto -70 -> 494
    //   567: iconst_0
    //   568: istore 7
    //   570: goto -312 -> 258
    //   573: iconst_0
    //   574: istore 6
    //   576: goto -514 -> 62
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	579	0	this	AttachPreview
    //   0	579	1	paramJSONObject	com.alibaba.fastjson.JSONObject
    //   517	23	2	i	int
    //   529	4	3	j	int
    //   1	562	4	bool1	boolean
    //   8	553	5	bool2	boolean
    //   60	515	6	bool3	boolean
    //   96	473	7	bool4	boolean
    //   4	427	8	bool5	boolean
    //   283	11	9	bool6	boolean
    //   16	390	10	str	String
    // Exception table:
    //   from	to	target	type
    //   10	18	546	java/lang/Exception
    //   27	38	546	java/lang/Exception
    //   498	507	546	java/lang/Exception
    //   511	518	546	java/lang/Exception
    //   522	530	546	java/lang/Exception
    //   43	59	550	java/lang/Exception
    //   107	113	550	java/lang/Exception
    //   161	167	550	java/lang/Exception
    //   215	221	550	java/lang/Exception
    //   296	302	550	java/lang/Exception
    //   350	356	550	java/lang/Exception
    //   404	410	550	java/lang/Exception
    //   485	491	550	java/lang/Exception
    //   535	544	550	java/lang/Exception
    //   66	74	553	java/lang/Exception
    //   87	98	553	java/lang/Exception
    //   120	128	553	java/lang/Exception
    //   141	152	553	java/lang/Exception
    //   174	182	553	java/lang/Exception
    //   195	206	553	java/lang/Exception
    //   228	237	553	java/lang/Exception
    //   241	255	553	java/lang/Exception
    //   266	275	553	java/lang/Exception
    //   279	285	553	java/lang/Exception
    //   309	317	553	java/lang/Exception
    //   330	341	553	java/lang/Exception
    //   363	371	553	java/lang/Exception
    //   384	395	553	java/lang/Exception
    //   421	430	553	java/lang/Exception
    //   438	452	553	java/lang/Exception
    //   459	468	553	java/lang/Exception
    //   472	478	553	java/lang/Exception
  }
  
  public void setCopyDiskList(ArrayList<String> paramArrayList)
  {
    this.copyDiskList = paramArrayList;
  }
  
  public void setDownloadUrl(String paramString)
  {
    this.downloadUrl = paramString;
  }
  
  public void setEnableAttFolder(boolean paramBoolean)
  {
    this.enableAttFolder = paramBoolean;
  }
  
  public void setIcon(String paramString)
  {
    this.icon = paramString;
  }
  
  public void setIconOrg(String paramString)
  {
    this.iconOrg = paramString;
  }
  
  public void setIsAudio(boolean paramBoolean)
  {
    this.isAudio = paramBoolean;
  }
  
  public void setIsEmbed(boolean paramBoolean)
  {
    this.isEmbed = paramBoolean;
  }
  
  public void setIsPic(boolean paramBoolean)
  {
    this.isPic = paramBoolean;
  }
  
  public void setItype(AttachType paramAttachType)
  {
    this.itype = paramAttachType;
  }
  
  public void setIviewtype(String paramString)
  {
    this.iviewtype = paramString;
  }
  
  public void setMyDisk(String paramString)
  {
    this.myDisk = paramString;
  }
  
  public void setViewType(String paramString)
  {
    this.viewType = paramString;
  }
  
  public String toPlainString()
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    if (getDownloadUrl() != null)
    {
      str = getDownloadUrl().replaceAll("\\\\", "\\\\\\\\");
      localStringBuilder1.append("\"download\":\"").append(str.replaceAll("\"", "\\\\\"")).append("\",");
    }
    if (getIviewtype() != null) {
      localStringBuilder1.append("\"iviewtype\":\"" + getIviewtype()).append("\",");
    }
    if (getItype() != null) {
      localStringBuilder1.append("\"filetype\":\"").append(getItype().ordinal()).append("\",");
    }
    localStringBuilder1.append("\"mydisk\":\"").append(getMyDisk()).append("\",");
    StringBuilder localStringBuilder2 = localStringBuilder1.append("\"ispic\":\"");
    if (isPic())
    {
      str = "1";
      localStringBuilder2.append(str).append("\",");
      localStringBuilder2 = localStringBuilder1.append("\"isAudio\":\"");
      if (!isAudio()) {
        break label240;
      }
    }
    label240:
    for (String str = "1";; str = "0")
    {
      localStringBuilder2.append(str).append("\",");
      localStringBuilder1.append("\"icon\":\"" + getIcon()).append("\"");
      return localStringBuilder1.toString();
      str = "0";
      break;
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append("{");
    localStringBuilder1.append("\"class\":\"AttachPreview\",");
    if (getDownloadUrl() != null) {
      localStringBuilder1.append("\"download\":\"").append(getDownloadUrl().replaceAll("\\\\", "\\\\\\\\").replaceAll("\"", "\\\\\"")).append("\",");
    }
    if (getIviewtype() != null) {
      localStringBuilder1.append("\"iviewtype\":\"" + getIviewtype()).append("\",");
    }
    if (getItype() != null) {
      localStringBuilder1.append("\"filetype\":\"").append(getItype().ordinal()).append("\",");
    }
    localStringBuilder1.append("\"mydisk\":\"" + getMyDisk()).append("\",");
    StringBuilder localStringBuilder2 = localStringBuilder1.append("\"ispic\":\"");
    if (isPic())
    {
      str = "1";
      localStringBuilder2.append(str).append("\",");
      localStringBuilder2 = localStringBuilder1.append("\"isAudio\":\"");
      if (!isAudio()) {
        break label275;
      }
    }
    label275:
    for (String str = "1";; str = "0")
    {
      localStringBuilder2.append(str).append("\",");
      localStringBuilder1.append("\"icon\":\"" + getIcon()).append("\"");
      localStringBuilder1.append("}");
      return localStringBuilder1.toString();
      str = "0";
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.attachment.model.AttachPreview
 * JD-Core Version:    0.7.0.1
 */