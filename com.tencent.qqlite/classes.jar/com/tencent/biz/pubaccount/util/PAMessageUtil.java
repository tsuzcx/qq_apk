package com.tencent.biz.pubaccount.util;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.data.PAMessage.Item;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class PAMessageUtil
{
  private static final String A = "nativejump";
  private static final String B = "more";
  private static final String C = "icons";
  private static final String D = "rflag";
  private static final String E = "rna";
  private static final String F = "aru";
  private static final String G = "iru";
  private static final String H = "ard";
  private static final String I = "irs";
  private static final String J = "desc";
  public static final int a = 1;
  public static final String a = "open_local";
  public static final int b = 2;
  public static final String b = "msg";
  public static final int c = 3;
  public static final String c = "type";
  public static final int d = 1;
  public static final String d = "meta";
  public static final int e = 0;
  public static final String e = "appmsg";
  public static final String f = "msg";
  public static final String g = "item";
  public static final String h = "title";
  public static final String i = "cover";
  public static final String j = "digest";
  public static final String k = "url";
  public static final String l = "action";
  public static final String m = "actionData";
  public static final String n = "a_actionData";
  public static final String o = "i_actionData";
  public static final String p = "appid";
  public static final String q = "time";
  public static final String r = "flag";
  public static final String s = "sender";
  public static final String t = "name";
  public static final String u = "email";
  public static final String v = "icon";
  public static final String w = "icon";
  public static final String x = "iosurl";
  public static final String y = "androidurl";
  public static final String z = "needlogin";
  
  private static PAMessage.Item a(Node paramNode)
  {
    PAMessage.Item localItem = new PAMessage.Item();
    paramNode = paramNode.getChildNodes();
    int i3 = paramNode.getLength();
    int i1 = 0;
    if (i1 < i3)
    {
      Object localObject2 = paramNode.item(i1);
      Object localObject1 = a((Node)localObject2);
      Object localObject3 = ((Node)localObject2).getNodeName();
      if (((String)localObject3).equals("cover")) {
        localItem.cover = ((String)localObject1);
      }
      for (;;)
      {
        i1 += 1;
        break;
        if (((String)localObject3).equals("digest"))
        {
          if (localItem.digestList == null) {
            localItem.digestList = new ArrayList();
          }
          localItem.digestList.add(localObject1);
        }
        else if (((String)localObject3).equals("title"))
        {
          localItem.title = ((String)localObject1);
          localObject1 = ((Node)localObject2).getAttributes();
          localItem.mVideoFlag = 0;
          if ((localObject1 != null) && (((NamedNodeMap)localObject1).getLength() > 0))
          {
            localObject1 = ((NamedNodeMap)localObject1).getNamedItem("rflag");
            if (localObject1 != null) {
              try
              {
                localItem.mVideoFlag = Integer.parseInt(((Node)localObject1).getNodeValue());
              }
              catch (NumberFormatException localNumberFormatException) {}
            }
          }
        }
        else if (((String)localObject3).equals("url"))
        {
          localObject2 = ((Node)localObject2).getAttributes();
          long l2;
          long l1;
          if ((localObject2 != null) && (((NamedNodeMap)localObject2).getLength() > 0))
          {
            localObject3 = ((NamedNodeMap)localObject2).getNamedItem("action");
            if (localObject3 != null) {
              localItem.actionUrl = ((Node)localObject3).getNodeValue();
            }
            localObject3 = ((NamedNodeMap)localObject2).getNamedItem("actionData");
            Node localNode2 = ((NamedNodeMap)localObject2).getNamedItem("a_actionData");
            Node localNode3 = ((NamedNodeMap)localObject2).getNamedItem("i_actionData");
            localObject2 = ((NamedNodeMap)localObject2).getNamedItem("appid");
            if (localObject3 != null) {
              localItem.actionData = ((Node)localObject3).getNodeValue();
            }
            if (localNode2 != null) {
              localItem.a_actionData = localNode2.getNodeValue();
            }
            if (localNode3 != null) {
              localItem.i_actionData = localNode3.getNodeValue();
            }
            l2 = 0L;
            l1 = l2;
          }
          try
          {
            if (!TextUtils.isEmpty(((Node)localObject2).getNodeValue())) {
              l1 = Long.parseLong(((Node)localObject2).getNodeValue());
            }
            localItem.appId = l1;
            localItem.url = localNumberFormatException;
          }
          catch (Exception localException)
          {
            for (;;)
            {
              l1 = l2;
              if (QLog.isColorLevel())
              {
                QLog.d(PAMessageUtil.class.getSimpleName(), 2, localException.getMessage(), localException);
                l1 = l2;
              }
            }
          }
        }
        else if (((String)localObject3).equals("flag"))
        {
          localItem.flag = Integer.parseInt(localNumberFormatException);
        }
        else if (((String)localObject3).equals("icon"))
        {
          localItem.icon = localNumberFormatException;
        }
        else if (((String)localObject3).equals("icon"))
        {
          localItem.source = localNumberFormatException;
        }
        else if (((String)localObject3).equals("time"))
        {
          localItem.time = Long.valueOf(localNumberFormatException).longValue();
        }
        else
        {
          NodeList localNodeList;
          label572:
          Node localNode1;
          if (((String)localObject3).equals("sender"))
          {
            localNodeList = localException.getChildNodes();
            int i4 = localNodeList.getLength();
            int i2 = 0;
            if (i2 < i4)
            {
              localNode1 = localNodeList.item(i2);
              localObject3 = localNode1.getNodeName();
              if (!((String)localObject3).equals("email")) {
                break label626;
              }
              localItem.senderEmail = localNode1.getNodeValue();
            }
            for (;;)
            {
              i2 += 1;
              break label572;
              break;
              label626:
              if (((String)localObject3).equals("name")) {
                localItem.senderName = localNode1.getNodeValue();
              }
            }
          }
          if (((String)localObject3).equals("androidurl")) {
            localItem.androidUrl = localNodeList;
          } else if (((String)localObject3).equals("iosurl")) {
            localItem.iosUrl = localNodeList;
          } else if (((String)localObject3).equals("needlogin"))
          {
            if (Integer.valueOf(localNodeList).intValue() == 1) {
              localItem.needLogin = true;
            }
          }
          else if (((String)localObject3).equals("nativejump")) {
            localItem.nativeJumpString = localNodeList;
          } else if (((String)localObject3).equals("icons")) {
            localItem.iconsString = localNodeList;
          } else if (((String)localObject3).equals("rna")) {
            localItem.rankListName = localNodeList;
          } else if (((String)localObject3).equals("aru")) {
            localItem.a_rankListUrl = b(localNode1);
          } else if (((String)localObject3).equals("iru")) {
            localItem.i_rankListUrl = localNodeList;
          } else if (((String)localObject3).equals("ard")) {
            localItem.rankListDownload = b(localNode1);
          } else if (((String)localObject3).equals("irs")) {
            localItem.rankListSchema = localNodeList;
          } else if (((String)localObject3).equals("desc")) {
            localItem.desc = localNodeList;
          }
        }
      }
    }
    return localItem;
  }
  
  /* Error */
  public static com.tencent.mobileqq.data.PAMessage a(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aload_0
    //   4: ifnonnull +10 -> 14
    //   7: aload 6
    //   9: astore 5
    //   11: aload 5
    //   13: areturn
    //   14: invokestatic 313	javax/xml/parsers/DocumentBuilderFactory:newInstance	()Ljavax/xml/parsers/DocumentBuilderFactory;
    //   17: invokevirtual 317	javax/xml/parsers/DocumentBuilderFactory:newDocumentBuilder	()Ljavax/xml/parsers/DocumentBuilder;
    //   20: astore 7
    //   22: aload 6
    //   24: astore 5
    //   26: aload 7
    //   28: ifnull -17 -> 11
    //   31: new 319	java/io/ByteArrayInputStream
    //   34: dup
    //   35: aload_0
    //   36: invokevirtual 323	java/lang/String:getBytes	()[B
    //   39: invokespecial 326	java/io/ByteArrayInputStream:<init>	([B)V
    //   42: astore_0
    //   43: aload 7
    //   45: aload_0
    //   46: invokevirtual 332	javax/xml/parsers/DocumentBuilder:parse	(Ljava/io/InputStream;)Lorg/w3c/dom/Document;
    //   49: astore_0
    //   50: aload 6
    //   52: astore 5
    //   54: aload_0
    //   55: ifnull -44 -> 11
    //   58: aload_0
    //   59: invokeinterface 338 1 0
    //   64: astore 5
    //   66: new 340	com/tencent/mobileqq/data/PAMessage
    //   69: dup
    //   70: invokespecial 341	com/tencent/mobileqq/data/PAMessage:<init>	()V
    //   73: astore_0
    //   74: aload_0
    //   75: new 162	java/util/ArrayList
    //   78: dup
    //   79: invokespecial 163	java/util/ArrayList:<init>	()V
    //   82: putfield 345	com/tencent/mobileqq/data/PAMessage:items	Ljava/util/ArrayList;
    //   85: aload 5
    //   87: invokeinterface 132 1 0
    //   92: astore 6
    //   94: aload 6
    //   96: invokeinterface 138 1 0
    //   101: istore_3
    //   102: iconst_0
    //   103: istore_1
    //   104: aload_0
    //   105: astore 5
    //   107: iload_1
    //   108: iload_3
    //   109: if_icmpge -98 -> 11
    //   112: aload 6
    //   114: iload_1
    //   115: invokeinterface 141 2 0
    //   120: astore 5
    //   122: aload 5
    //   124: invokestatic 144	com/tencent/biz/pubaccount/util/PAMessageUtil:a	(Lorg/w3c/dom/Node;)Ljava/lang/String;
    //   127: astore 7
    //   129: aload 5
    //   131: invokeinterface 148 1 0
    //   136: ldc 47
    //   138: invokevirtual 154	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   141: ifeq +43 -> 184
    //   144: aload_0
    //   145: aload 7
    //   147: invokestatic 268	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   150: invokevirtual 271	java/lang/Integer:intValue	()I
    //   153: putfield 347	com/tencent/mobileqq/data/PAMessage:type	I
    //   156: iload_1
    //   157: iconst_1
    //   158: iadd
    //   159: istore_1
    //   160: goto -56 -> 104
    //   163: astore_0
    //   164: aload_0
    //   165: invokevirtual 350	javax/xml/parsers/ParserConfigurationException:printStackTrace	()V
    //   168: aconst_null
    //   169: areturn
    //   170: astore_0
    //   171: aload_0
    //   172: invokevirtual 351	org/xml/sax/SAXException:printStackTrace	()V
    //   175: aconst_null
    //   176: areturn
    //   177: astore_0
    //   178: aload_0
    //   179: invokevirtual 352	java/io/IOException:printStackTrace	()V
    //   182: aconst_null
    //   183: areturn
    //   184: aload 5
    //   186: invokeinterface 148 1 0
    //   191: ldc 54
    //   193: invokevirtual 154	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   196: ifeq +74 -> 270
    //   199: aload 5
    //   201: invokeinterface 132 1 0
    //   206: astore 5
    //   208: aload 5
    //   210: invokeinterface 138 1 0
    //   215: istore 4
    //   217: iconst_0
    //   218: istore_2
    //   219: iload_2
    //   220: iload 4
    //   222: if_icmpge -66 -> 156
    //   225: aload 5
    //   227: iload_2
    //   228: invokeinterface 141 2 0
    //   233: astore 7
    //   235: aload 7
    //   237: invokeinterface 356 1 0
    //   242: iconst_1
    //   243: if_icmpne +20 -> 263
    //   246: aload 7
    //   248: invokestatic 358	com/tencent/biz/pubaccount/util/PAMessageUtil:a	(Lorg/w3c/dom/Node;)Lcom/tencent/mobileqq/data/PAMessage$Item;
    //   251: astore 7
    //   253: aload_0
    //   254: getfield 345	com/tencent/mobileqq/data/PAMessage:items	Ljava/util/ArrayList;
    //   257: aload 7
    //   259: invokevirtual 359	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   262: pop
    //   263: iload_2
    //   264: iconst_1
    //   265: iadd
    //   266: istore_2
    //   267: goto -48 -> 219
    //   270: aload 5
    //   272: invokeinterface 148 1 0
    //   277: ldc 50
    //   279: invokevirtual 154	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   282: ifeq -126 -> 156
    //   285: aload 5
    //   287: invokeinterface 132 1 0
    //   292: astore 5
    //   294: aload 5
    //   296: invokeinterface 138 1 0
    //   301: istore 4
    //   303: iconst_0
    //   304: istore_2
    //   305: iload_2
    //   306: iload 4
    //   308: if_icmpge -152 -> 156
    //   311: aload 5
    //   313: iload_2
    //   314: invokeinterface 141 2 0
    //   319: astore 8
    //   321: aload 8
    //   323: invokestatic 144	com/tencent/biz/pubaccount/util/PAMessageUtil:a	(Lorg/w3c/dom/Node;)Ljava/lang/String;
    //   326: astore 7
    //   328: aload 8
    //   330: invokeinterface 148 1 0
    //   335: astore 8
    //   337: aload 8
    //   339: ldc 88
    //   341: invokevirtual 363	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   344: ifeq +18 -> 362
    //   347: aload_0
    //   348: aload 7
    //   350: invokestatic 247	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   353: invokevirtual 251	java/lang/Long:longValue	()J
    //   356: putfield 366	com/tencent/mobileqq/data/PAMessage:sendTime	J
    //   359: goto -203 -> 156
    //   362: aload 8
    //   364: ldc 11
    //   366: invokevirtual 363	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   369: ifeq +9 -> 378
    //   372: aload_0
    //   373: aload 7
    //   375: putfield 369	com/tencent/mobileqq/data/PAMessage:moreText	Ljava/lang/String;
    //   378: iload_2
    //   379: iconst_1
    //   380: iadd
    //   381: istore_2
    //   382: goto -77 -> 305
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	385	0	paramString	String
    //   103	57	1	i1	int
    //   218	164	2	i2	int
    //   101	9	3	i3	int
    //   215	94	4	i4	int
    //   9	303	5	localObject1	Object
    //   1	112	6	localNodeList	NodeList
    //   20	354	7	localObject2	Object
    //   319	44	8	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   14	22	163	javax/xml/parsers/ParserConfigurationException
    //   43	50	170	org/xml/sax/SAXException
    //   43	50	177	java/io/IOException
  }
  
  /* Error */
  public static com.tencent.mobileqq.data.PAMessage a(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull +5 -> 6
    //   4: aconst_null
    //   5: areturn
    //   6: new 319	java/io/ByteArrayInputStream
    //   9: dup
    //   10: aload_0
    //   11: invokespecial 326	java/io/ByteArrayInputStream:<init>	([B)V
    //   14: astore_3
    //   15: new 376	java/io/ObjectInputStream
    //   18: dup
    //   19: aload_3
    //   20: invokespecial 379	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   23: astore_1
    //   24: aload_1
    //   25: astore_0
    //   26: aload_1
    //   27: invokevirtual 383	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   30: checkcast 340	com/tencent/mobileqq/data/PAMessage
    //   33: astore_2
    //   34: aload_1
    //   35: ifnull +7 -> 42
    //   38: aload_1
    //   39: invokevirtual 386	java/io/ObjectInputStream:close	()V
    //   42: aload_3
    //   43: invokevirtual 387	java/io/ByteArrayInputStream:close	()V
    //   46: aload_2
    //   47: astore_0
    //   48: aload_0
    //   49: areturn
    //   50: astore_0
    //   51: aload_0
    //   52: invokevirtual 352	java/io/IOException:printStackTrace	()V
    //   55: aload_2
    //   56: astore_0
    //   57: goto -9 -> 48
    //   60: astore_2
    //   61: aconst_null
    //   62: astore_1
    //   63: aload_1
    //   64: astore_0
    //   65: aload_2
    //   66: invokevirtual 352	java/io/IOException:printStackTrace	()V
    //   69: aload_1
    //   70: ifnull +7 -> 77
    //   73: aload_1
    //   74: invokevirtual 386	java/io/ObjectInputStream:close	()V
    //   77: aload_3
    //   78: invokevirtual 387	java/io/ByteArrayInputStream:close	()V
    //   81: aconst_null
    //   82: astore_0
    //   83: goto -35 -> 48
    //   86: astore_0
    //   87: aload_0
    //   88: invokevirtual 352	java/io/IOException:printStackTrace	()V
    //   91: aconst_null
    //   92: astore_0
    //   93: goto -45 -> 48
    //   96: astore_2
    //   97: aconst_null
    //   98: astore_1
    //   99: aload_1
    //   100: astore_0
    //   101: aload_2
    //   102: invokevirtual 388	java/lang/ClassNotFoundException:printStackTrace	()V
    //   105: aload_1
    //   106: ifnull +7 -> 113
    //   109: aload_1
    //   110: invokevirtual 386	java/io/ObjectInputStream:close	()V
    //   113: aload_3
    //   114: invokevirtual 387	java/io/ByteArrayInputStream:close	()V
    //   117: aconst_null
    //   118: astore_0
    //   119: goto -71 -> 48
    //   122: astore_0
    //   123: aload_0
    //   124: invokevirtual 352	java/io/IOException:printStackTrace	()V
    //   127: aconst_null
    //   128: astore_0
    //   129: goto -81 -> 48
    //   132: astore_2
    //   133: aconst_null
    //   134: astore_1
    //   135: aload_1
    //   136: astore_0
    //   137: aload_2
    //   138: invokevirtual 389	java/lang/OutOfMemoryError:printStackTrace	()V
    //   141: aload_1
    //   142: ifnull +7 -> 149
    //   145: aload_1
    //   146: invokevirtual 386	java/io/ObjectInputStream:close	()V
    //   149: aload_3
    //   150: invokevirtual 387	java/io/ByteArrayInputStream:close	()V
    //   153: aconst_null
    //   154: astore_0
    //   155: goto -107 -> 48
    //   158: astore_0
    //   159: aload_0
    //   160: invokevirtual 352	java/io/IOException:printStackTrace	()V
    //   163: aconst_null
    //   164: astore_0
    //   165: goto -117 -> 48
    //   168: astore_2
    //   169: aconst_null
    //   170: astore_1
    //   171: aload_1
    //   172: astore_0
    //   173: aload_2
    //   174: invokevirtual 390	java/lang/Exception:printStackTrace	()V
    //   177: aload_1
    //   178: ifnull +7 -> 185
    //   181: aload_1
    //   182: invokevirtual 386	java/io/ObjectInputStream:close	()V
    //   185: aload_3
    //   186: invokevirtual 387	java/io/ByteArrayInputStream:close	()V
    //   189: aconst_null
    //   190: astore_0
    //   191: goto -143 -> 48
    //   194: astore_0
    //   195: aload_0
    //   196: invokevirtual 352	java/io/IOException:printStackTrace	()V
    //   199: aconst_null
    //   200: astore_0
    //   201: goto -153 -> 48
    //   204: astore_1
    //   205: aconst_null
    //   206: astore_0
    //   207: aload_0
    //   208: ifnull +7 -> 215
    //   211: aload_0
    //   212: invokevirtual 386	java/io/ObjectInputStream:close	()V
    //   215: aload_3
    //   216: invokevirtual 387	java/io/ByteArrayInputStream:close	()V
    //   219: aload_1
    //   220: athrow
    //   221: astore_0
    //   222: aload_0
    //   223: invokevirtual 352	java/io/IOException:printStackTrace	()V
    //   226: goto -7 -> 219
    //   229: astore_1
    //   230: goto -23 -> 207
    //   233: astore_2
    //   234: goto -63 -> 171
    //   237: astore_2
    //   238: goto -103 -> 135
    //   241: astore_2
    //   242: goto -143 -> 99
    //   245: astore_2
    //   246: goto -183 -> 63
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	249	0	paramArrayOfByte	byte[]
    //   23	159	1	localObjectInputStream	java.io.ObjectInputStream
    //   204	16	1	localObject1	Object
    //   229	1	1	localObject2	Object
    //   33	23	2	localPAMessage	com.tencent.mobileqq.data.PAMessage
    //   60	6	2	localIOException1	java.io.IOException
    //   96	6	2	localClassNotFoundException1	java.lang.ClassNotFoundException
    //   132	6	2	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   168	6	2	localException1	Exception
    //   233	1	2	localException2	Exception
    //   237	1	2	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   241	1	2	localClassNotFoundException2	java.lang.ClassNotFoundException
    //   245	1	2	localIOException2	java.io.IOException
    //   14	202	3	localByteArrayInputStream	java.io.ByteArrayInputStream
    // Exception table:
    //   from	to	target	type
    //   38	42	50	java/io/IOException
    //   42	46	50	java/io/IOException
    //   15	24	60	java/io/IOException
    //   73	77	86	java/io/IOException
    //   77	81	86	java/io/IOException
    //   15	24	96	java/lang/ClassNotFoundException
    //   109	113	122	java/io/IOException
    //   113	117	122	java/io/IOException
    //   15	24	132	java/lang/OutOfMemoryError
    //   145	149	158	java/io/IOException
    //   149	153	158	java/io/IOException
    //   15	24	168	java/lang/Exception
    //   181	185	194	java/io/IOException
    //   185	189	194	java/io/IOException
    //   15	24	204	finally
    //   211	215	221	java/io/IOException
    //   215	219	221	java/io/IOException
    //   26	34	229	finally
    //   65	69	229	finally
    //   101	105	229	finally
    //   137	141	229	finally
    //   173	177	229	finally
    //   26	34	233	java/lang/Exception
    //   26	34	237	java/lang/OutOfMemoryError
    //   26	34	241	java/lang/ClassNotFoundException
    //   26	34	245	java/io/IOException
  }
  
  public static String a(Node paramNode)
  {
    if (paramNode.getNodeType() == 3) {}
    Object localObject;
    for (paramNode = paramNode.getNodeValue();; paramNode = ((StringBuilder)localObject).toString())
    {
      localObject = paramNode;
      if (paramNode == null) {
        localObject = "";
      }
      return localObject;
      localObject = new StringBuilder();
      paramNode = paramNode.getChildNodes();
      int i2 = paramNode.getLength();
      int i1 = 0;
      while (i1 < i2)
      {
        Node localNode = paramNode.item(i1);
        if (localNode.getNodeType() == 3) {
          ((StringBuilder)localObject).append(localNode.getNodeValue());
        }
        i1 += 1;
      }
    }
  }
  
  public static boolean a(String paramString, Context paramContext)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    new Bundle();
    Uri.parse(paramString).getPath();
    return false;
  }
  
  /* Error */
  public static byte[] a(com.tencent.mobileqq.data.PAMessage paramPAMessage)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull +5 -> 6
    //   4: aconst_null
    //   5: areturn
    //   6: new 417	java/io/ByteArrayOutputStream
    //   9: dup
    //   10: invokespecial 418	java/io/ByteArrayOutputStream:<init>	()V
    //   13: astore_3
    //   14: new 420	java/io/ObjectOutputStream
    //   17: dup
    //   18: aload_3
    //   19: invokespecial 423	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   22: astore_2
    //   23: aload_2
    //   24: astore_1
    //   25: aload_2
    //   26: aload_0
    //   27: invokevirtual 427	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   30: aload_2
    //   31: astore_1
    //   32: aload_3
    //   33: invokevirtual 430	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   36: astore_0
    //   37: aload_2
    //   38: ifnull +7 -> 45
    //   41: aload_2
    //   42: invokevirtual 431	java/io/ObjectOutputStream:close	()V
    //   45: aload_3
    //   46: invokevirtual 432	java/io/ByteArrayOutputStream:close	()V
    //   49: aload_0
    //   50: areturn
    //   51: astore_1
    //   52: aload_1
    //   53: invokevirtual 352	java/io/IOException:printStackTrace	()V
    //   56: aload_0
    //   57: areturn
    //   58: astore_0
    //   59: aconst_null
    //   60: astore_2
    //   61: aload_2
    //   62: astore_1
    //   63: aload_0
    //   64: invokevirtual 389	java/lang/OutOfMemoryError:printStackTrace	()V
    //   67: aload_2
    //   68: ifnull +7 -> 75
    //   71: aload_2
    //   72: invokevirtual 431	java/io/ObjectOutputStream:close	()V
    //   75: aload_3
    //   76: invokevirtual 432	java/io/ByteArrayOutputStream:close	()V
    //   79: aconst_null
    //   80: areturn
    //   81: astore_0
    //   82: aload_0
    //   83: invokevirtual 352	java/io/IOException:printStackTrace	()V
    //   86: aconst_null
    //   87: areturn
    //   88: astore_0
    //   89: aconst_null
    //   90: astore_2
    //   91: aload_2
    //   92: astore_1
    //   93: aload_0
    //   94: invokevirtual 352	java/io/IOException:printStackTrace	()V
    //   97: aload_2
    //   98: ifnull +7 -> 105
    //   101: aload_2
    //   102: invokevirtual 431	java/io/ObjectOutputStream:close	()V
    //   105: aload_3
    //   106: invokevirtual 432	java/io/ByteArrayOutputStream:close	()V
    //   109: aconst_null
    //   110: areturn
    //   111: astore_0
    //   112: aload_0
    //   113: invokevirtual 352	java/io/IOException:printStackTrace	()V
    //   116: aconst_null
    //   117: areturn
    //   118: astore_0
    //   119: aconst_null
    //   120: astore_1
    //   121: aload_1
    //   122: ifnull +7 -> 129
    //   125: aload_1
    //   126: invokevirtual 431	java/io/ObjectOutputStream:close	()V
    //   129: aload_3
    //   130: invokevirtual 432	java/io/ByteArrayOutputStream:close	()V
    //   133: aload_0
    //   134: athrow
    //   135: astore_1
    //   136: aload_1
    //   137: invokevirtual 352	java/io/IOException:printStackTrace	()V
    //   140: goto -7 -> 133
    //   143: astore_0
    //   144: goto -23 -> 121
    //   147: astore_0
    //   148: goto -57 -> 91
    //   151: astore_0
    //   152: goto -91 -> 61
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	155	0	paramPAMessage	com.tencent.mobileqq.data.PAMessage
    //   24	8	1	localObjectOutputStream1	java.io.ObjectOutputStream
    //   51	2	1	localIOException1	java.io.IOException
    //   62	64	1	localObjectOutputStream2	java.io.ObjectOutputStream
    //   135	2	1	localIOException2	java.io.IOException
    //   22	80	2	localObjectOutputStream3	java.io.ObjectOutputStream
    //   13	117	3	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    // Exception table:
    //   from	to	target	type
    //   41	45	51	java/io/IOException
    //   45	49	51	java/io/IOException
    //   14	23	58	java/lang/OutOfMemoryError
    //   71	75	81	java/io/IOException
    //   75	79	81	java/io/IOException
    //   14	23	88	java/io/IOException
    //   101	105	111	java/io/IOException
    //   105	109	111	java/io/IOException
    //   14	23	118	finally
    //   125	129	135	java/io/IOException
    //   129	133	135	java/io/IOException
    //   25	30	143	finally
    //   32	37	143	finally
    //   63	67	143	finally
    //   93	97	143	finally
    //   25	30	147	java/io/IOException
    //   32	37	147	java/io/IOException
    //   25	30	151	java/lang/OutOfMemoryError
    //   32	37	151	java/lang/OutOfMemoryError
  }
  
  /* Error */
  public static com.tencent.mobileqq.data.PAMessage b(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload_0
    //   4: ifnonnull +8 -> 12
    //   7: aload 4
    //   9: astore_3
    //   10: aload_3
    //   11: areturn
    //   12: invokestatic 313	javax/xml/parsers/DocumentBuilderFactory:newInstance	()Ljavax/xml/parsers/DocumentBuilderFactory;
    //   15: invokevirtual 317	javax/xml/parsers/DocumentBuilderFactory:newDocumentBuilder	()Ljavax/xml/parsers/DocumentBuilder;
    //   18: astore 5
    //   20: aload 4
    //   22: astore_3
    //   23: aload 5
    //   25: ifnull -15 -> 10
    //   28: new 319	java/io/ByteArrayInputStream
    //   31: dup
    //   32: aload_0
    //   33: invokevirtual 323	java/lang/String:getBytes	()[B
    //   36: invokespecial 326	java/io/ByteArrayInputStream:<init>	([B)V
    //   39: astore_0
    //   40: aload 5
    //   42: aload_0
    //   43: invokevirtual 332	javax/xml/parsers/DocumentBuilder:parse	(Ljava/io/InputStream;)Lorg/w3c/dom/Document;
    //   46: astore_0
    //   47: aload 4
    //   49: astore_3
    //   50: aload_0
    //   51: ifnull -41 -> 10
    //   54: aload_0
    //   55: invokeinterface 338 1 0
    //   60: astore 5
    //   62: aload 4
    //   64: astore_3
    //   65: aload 5
    //   67: invokeinterface 148 1 0
    //   72: ldc 43
    //   74: invokevirtual 154	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   77: ifeq -67 -> 10
    //   80: new 340	com/tencent/mobileqq/data/PAMessage
    //   83: dup
    //   84: invokespecial 341	com/tencent/mobileqq/data/PAMessage:<init>	()V
    //   87: astore_0
    //   88: aload_0
    //   89: new 162	java/util/ArrayList
    //   92: dup
    //   93: invokespecial 163	java/util/ArrayList:<init>	()V
    //   96: putfield 345	com/tencent/mobileqq/data/PAMessage:items	Ljava/util/ArrayList;
    //   99: aload 5
    //   101: invokeinterface 132 1 0
    //   106: astore 4
    //   108: iconst_0
    //   109: istore_1
    //   110: aload 4
    //   112: invokeinterface 138 1 0
    //   117: istore_2
    //   118: aload_0
    //   119: astore_3
    //   120: iload_1
    //   121: iload_2
    //   122: if_icmpge -112 -> 10
    //   125: aload 4
    //   127: iload_1
    //   128: invokeinterface 141 2 0
    //   133: astore_3
    //   134: aload_3
    //   135: invokestatic 144	com/tencent/biz/pubaccount/util/PAMessageUtil:a	(Lorg/w3c/dom/Node;)Ljava/lang/String;
    //   138: astore 5
    //   140: aload_3
    //   141: invokeinterface 148 1 0
    //   146: ldc 47
    //   148: invokevirtual 154	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   151: ifeq +43 -> 194
    //   154: aload_0
    //   155: aload 5
    //   157: invokestatic 268	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   160: invokevirtual 271	java/lang/Integer:intValue	()I
    //   163: putfield 347	com/tencent/mobileqq/data/PAMessage:type	I
    //   166: iload_1
    //   167: iconst_1
    //   168: iadd
    //   169: istore_1
    //   170: goto -52 -> 118
    //   173: astore_0
    //   174: aload_0
    //   175: invokevirtual 350	javax/xml/parsers/ParserConfigurationException:printStackTrace	()V
    //   178: aconst_null
    //   179: areturn
    //   180: astore_0
    //   181: aload_0
    //   182: invokevirtual 351	org/xml/sax/SAXException:printStackTrace	()V
    //   185: aconst_null
    //   186: areturn
    //   187: astore_0
    //   188: aload_0
    //   189: invokevirtual 352	java/io/IOException:printStackTrace	()V
    //   192: aconst_null
    //   193: areturn
    //   194: aload_3
    //   195: invokeinterface 148 1 0
    //   200: ldc 58
    //   202: invokevirtual 154	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   205: ifeq -39 -> 166
    //   208: aload_3
    //   209: invokestatic 358	com/tencent/biz/pubaccount/util/PAMessageUtil:a	(Lorg/w3c/dom/Node;)Lcom/tencent/mobileqq/data/PAMessage$Item;
    //   212: astore_3
    //   213: aload_0
    //   214: getfield 345	com/tencent/mobileqq/data/PAMessage:items	Ljava/util/ArrayList;
    //   217: aload_3
    //   218: invokevirtual 359	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   221: pop
    //   222: goto -56 -> 166
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	225	0	paramString	String
    //   109	61	1	i1	int
    //   117	6	2	i2	int
    //   9	209	3	localObject1	Object
    //   1	125	4	localNodeList	NodeList
    //   18	138	5	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   12	20	173	javax/xml/parsers/ParserConfigurationException
    //   40	47	180	org/xml/sax/SAXException
    //   40	47	187	java/io/IOException
  }
  
  private static String b(Node paramNode)
  {
    if (paramNode == null) {}
    do
    {
      return null;
      paramNode = paramNode.getChildNodes();
    } while (paramNode == null);
    JSONObject localJSONObject = new JSONObject();
    int i1 = 0;
    for (;;)
    {
      if (i1 < paramNode.getLength())
      {
        Node localNode = paramNode.item(i1);
        try
        {
          localJSONObject.put(localNode.getNodeName(), a(localNode));
          i1 += 1;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            localException.printStackTrace();
          }
        }
      }
    }
    return localJSONObject.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.PAMessageUtil
 * JD-Core Version:    0.7.0.1
 */