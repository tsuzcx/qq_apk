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

public class txr
{
  public static PAMessage.Item a(Node paramNode)
  {
    PAMessage.Item localItem = new PAMessage.Item();
    paramNode = paramNode.getChildNodes();
    int k = paramNode.getLength();
    int i = 0;
    if (i < k)
    {
      Object localObject2 = paramNode.item(i);
      Object localObject1 = a((Node)localObject2);
      Object localObject3 = ((Node)localObject2).getNodeName();
      if (((String)localObject3).equals("cover")) {
        localItem.cover = ((String)localObject1);
      }
      for (;;)
      {
        i += 1;
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
            if (localObject2 != null) {
              l1 = l2;
            }
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
                QLog.d(txr.class.getSimpleName(), 2, localException.getMessage(), localException);
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
          label581:
          Node localNode1;
          if (((String)localObject3).equals("sender"))
          {
            localNodeList = localException.getChildNodes();
            int m = localNodeList.getLength();
            int j = 0;
            if (j < m)
            {
              localNode1 = localNodeList.item(j);
              localObject3 = localNode1.getNodeName();
              if (!((String)localObject3).equals("email")) {
                break label635;
              }
              localItem.senderEmail = localNode1.getNodeValue();
            }
            for (;;)
            {
              j += 1;
              break label581;
              break;
              label635:
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
          } else if (((String)localObject3).equals("area")) {
            localItem.weaArea = localNodeList;
          } else if (((String)localObject3).equals("temper")) {
            localItem.weaTemper = localNodeList;
          } else if (((String)localObject3).equals("wea")) {
            localItem.weather = localNodeList;
          } else if (((String)localObject3).equals("o_wea")) {
            localItem.oneWeather = localNodeList;
          } else if (((String)localObject3).equals("t_wea")) {
            localItem.twoWeather = localNodeList;
          } else if (((String)localObject3).equals("j_url")) {
            localItem.weaJumpUrl = localNodeList;
          } else if (((String)localObject3).equals("e_url")) {
            localItem.weaExposeUrl = localNodeList;
          } else if (((String)localObject3).equals("t")) {
            localItem.type = localNodeList;
          } else if (((String)localObject3).equals("new_time")) {
            localItem.time = Long.valueOf(localNodeList).longValue();
          } else if (((String)localObject3).equals("b_ad")) {
            localItem.isAd = localNodeList;
          } else if (((String)localObject3).equals("n_wea")) {
            localItem.nowTime = localNodeList;
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
    //   14: invokestatic 317	javax/xml/parsers/DocumentBuilderFactory:newInstance	()Ljavax/xml/parsers/DocumentBuilderFactory;
    //   17: invokevirtual 321	javax/xml/parsers/DocumentBuilderFactory:newDocumentBuilder	()Ljavax/xml/parsers/DocumentBuilder;
    //   20: astore 7
    //   22: aload 6
    //   24: astore 5
    //   26: aload 7
    //   28: ifnull -17 -> 11
    //   31: new 323	java/io/ByteArrayInputStream
    //   34: dup
    //   35: aload_0
    //   36: invokevirtual 327	java/lang/String:getBytes	()[B
    //   39: invokespecial 330	java/io/ByteArrayInputStream:<init>	([B)V
    //   42: astore_0
    //   43: aload 7
    //   45: aload_0
    //   46: invokevirtual 336	javax/xml/parsers/DocumentBuilder:parse	(Ljava/io/InputStream;)Lorg/w3c/dom/Document;
    //   49: astore_0
    //   50: aload 6
    //   52: astore 5
    //   54: aload_0
    //   55: ifnull -44 -> 11
    //   58: aload_0
    //   59: invokeinterface 342 1 0
    //   64: astore 5
    //   66: new 344	com/tencent/mobileqq/data/PAMessage
    //   69: dup
    //   70: invokespecial 345	com/tencent/mobileqq/data/PAMessage:<init>	()V
    //   73: astore_0
    //   74: aload_0
    //   75: new 60	java/util/ArrayList
    //   78: dup
    //   79: invokespecial 61	java/util/ArrayList:<init>	()V
    //   82: putfield 349	com/tencent/mobileqq/data/PAMessage:items	Ljava/util/ArrayList;
    //   85: aload 5
    //   87: invokeinterface 24 1 0
    //   92: astore 6
    //   94: aload 6
    //   96: invokeinterface 30 1 0
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
    //   115: invokeinterface 34 2 0
    //   120: astore 5
    //   122: aload 5
    //   124: invokestatic 37	txr:a	(Lorg/w3c/dom/Node;)Ljava/lang/String;
    //   127: astore 7
    //   129: aload 5
    //   131: invokeinterface 41 1 0
    //   136: ldc_w 350
    //   139: invokevirtual 49	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   142: ifeq +43 -> 185
    //   145: aload_0
    //   146: aload 7
    //   148: invokestatic 203	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   151: invokevirtual 206	java/lang/Integer:intValue	()I
    //   154: putfield 352	com/tencent/mobileqq/data/PAMessage:type	I
    //   157: iload_1
    //   158: iconst_1
    //   159: iadd
    //   160: istore_1
    //   161: goto -57 -> 104
    //   164: astore_0
    //   165: aload_0
    //   166: invokevirtual 355	javax/xml/parsers/ParserConfigurationException:printStackTrace	()V
    //   169: aconst_null
    //   170: areturn
    //   171: astore_0
    //   172: aload_0
    //   173: invokevirtual 356	org/xml/sax/SAXException:printStackTrace	()V
    //   176: aconst_null
    //   177: areturn
    //   178: astore_0
    //   179: aload_0
    //   180: invokevirtual 357	java/io/IOException:printStackTrace	()V
    //   183: aconst_null
    //   184: areturn
    //   185: aload 5
    //   187: invokeinterface 41 1 0
    //   192: ldc_w 359
    //   195: invokevirtual 49	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   198: ifeq +74 -> 272
    //   201: aload 5
    //   203: invokeinterface 24 1 0
    //   208: astore 5
    //   210: aload 5
    //   212: invokeinterface 30 1 0
    //   217: istore 4
    //   219: iconst_0
    //   220: istore_2
    //   221: iload_2
    //   222: iload 4
    //   224: if_icmpge -67 -> 157
    //   227: aload 5
    //   229: iload_2
    //   230: invokeinterface 34 2 0
    //   235: astore 7
    //   237: aload 7
    //   239: invokeinterface 363 1 0
    //   244: iconst_1
    //   245: if_icmpne +20 -> 265
    //   248: aload 7
    //   250: invokestatic 365	txr:a	(Lorg/w3c/dom/Node;)Lcom/tencent/mobileqq/data/PAMessage$Item;
    //   253: astore 7
    //   255: aload_0
    //   256: getfield 349	com/tencent/mobileqq/data/PAMessage:items	Ljava/util/ArrayList;
    //   259: aload 7
    //   261: invokevirtual 366	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   264: pop
    //   265: iload_2
    //   266: iconst_1
    //   267: iadd
    //   268: istore_2
    //   269: goto -48 -> 221
    //   272: aload 5
    //   274: invokeinterface 41 1 0
    //   279: ldc_w 368
    //   282: invokevirtual 49	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   285: ifeq -128 -> 157
    //   288: aload 5
    //   290: invokeinterface 24 1 0
    //   295: astore 5
    //   297: aload 5
    //   299: invokeinterface 30 1 0
    //   304: istore 4
    //   306: iconst_0
    //   307: istore_2
    //   308: iload_2
    //   309: iload 4
    //   311: if_icmpge -154 -> 157
    //   314: aload 5
    //   316: iload_2
    //   317: invokeinterface 34 2 0
    //   322: astore 8
    //   324: aload 8
    //   326: invokestatic 37	txr:a	(Lorg/w3c/dom/Node;)Ljava/lang/String;
    //   329: astore 7
    //   331: aload 8
    //   333: invokeinterface 41 1 0
    //   338: astore 8
    //   340: aload 8
    //   342: ldc 166
    //   344: invokevirtual 372	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   347: ifeq +22 -> 369
    //   350: aload_0
    //   351: aload 7
    //   353: invokestatic 170	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   356: invokevirtual 174	java/lang/Long:longValue	()J
    //   359: putfield 375	com/tencent/mobileqq/data/PAMessage:sendTime	J
    //   362: iload_2
    //   363: iconst_1
    //   364: iadd
    //   365: istore_2
    //   366: goto -58 -> 308
    //   369: aload 8
    //   371: ldc_w 377
    //   374: invokevirtual 372	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   377: ifeq +12 -> 389
    //   380: aload_0
    //   381: aload 7
    //   383: putfield 380	com/tencent/mobileqq/data/PAMessage:moreText	Ljava/lang/String;
    //   386: goto -24 -> 362
    //   389: aload 8
    //   391: ldc_w 382
    //   394: invokevirtual 372	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   397: ifeq -35 -> 362
    //   400: aload_0
    //   401: aload 7
    //   403: putfield 384	com/tencent/mobileqq/data/PAMessage:grayTips	Ljava/lang/String;
    //   406: goto -44 -> 362
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	409	0	paramString	String
    //   103	58	1	i	int
    //   220	146	2	j	int
    //   101	9	3	k	int
    //   217	95	4	m	int
    //   9	306	5	localObject1	Object
    //   1	112	6	localNodeList	NodeList
    //   20	382	7	localObject2	Object
    //   322	68	8	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   14	22	164	javax/xml/parsers/ParserConfigurationException
    //   43	50	171	org/xml/sax/SAXException
    //   43	50	178	java/io/IOException
  }
  
  /* Error */
  public static com.tencent.mobileqq.data.PAMessage a(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull +5 -> 6
    //   4: aconst_null
    //   5: areturn
    //   6: new 323	java/io/ByteArrayInputStream
    //   9: dup
    //   10: aload_0
    //   11: invokespecial 330	java/io/ByteArrayInputStream:<init>	([B)V
    //   14: astore_3
    //   15: new 391	java/io/ObjectInputStream
    //   18: dup
    //   19: aload_3
    //   20: invokespecial 394	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   23: astore_1
    //   24: aload_1
    //   25: astore_0
    //   26: aload_1
    //   27: invokevirtual 398	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   30: checkcast 344	com/tencent/mobileqq/data/PAMessage
    //   33: astore_2
    //   34: aload_1
    //   35: ifnull +7 -> 42
    //   38: aload_1
    //   39: invokevirtual 401	java/io/ObjectInputStream:close	()V
    //   42: aload_3
    //   43: invokevirtual 402	java/io/ByteArrayInputStream:close	()V
    //   46: aload_2
    //   47: astore_0
    //   48: aload_0
    //   49: areturn
    //   50: astore_0
    //   51: aload_0
    //   52: invokevirtual 357	java/io/IOException:printStackTrace	()V
    //   55: aload_2
    //   56: astore_0
    //   57: goto -9 -> 48
    //   60: astore_0
    //   61: aconst_null
    //   62: astore_0
    //   63: aload_0
    //   64: ifnull +7 -> 71
    //   67: aload_0
    //   68: invokevirtual 401	java/io/ObjectInputStream:close	()V
    //   71: aload_3
    //   72: invokevirtual 402	java/io/ByteArrayInputStream:close	()V
    //   75: aconst_null
    //   76: astore_0
    //   77: goto -29 -> 48
    //   80: astore_0
    //   81: aload_0
    //   82: invokevirtual 357	java/io/IOException:printStackTrace	()V
    //   85: aconst_null
    //   86: astore_0
    //   87: goto -39 -> 48
    //   90: astore_2
    //   91: aconst_null
    //   92: astore_1
    //   93: aload_1
    //   94: astore_0
    //   95: aload_2
    //   96: invokevirtual 403	java/lang/ClassNotFoundException:printStackTrace	()V
    //   99: aload_1
    //   100: ifnull +7 -> 107
    //   103: aload_1
    //   104: invokevirtual 401	java/io/ObjectInputStream:close	()V
    //   107: aload_3
    //   108: invokevirtual 402	java/io/ByteArrayInputStream:close	()V
    //   111: aconst_null
    //   112: astore_0
    //   113: goto -65 -> 48
    //   116: astore_0
    //   117: aload_0
    //   118: invokevirtual 357	java/io/IOException:printStackTrace	()V
    //   121: aconst_null
    //   122: astore_0
    //   123: goto -75 -> 48
    //   126: astore_2
    //   127: aconst_null
    //   128: astore_1
    //   129: aload_1
    //   130: astore_0
    //   131: aload_2
    //   132: invokevirtual 404	java/lang/OutOfMemoryError:printStackTrace	()V
    //   135: aload_1
    //   136: ifnull +7 -> 143
    //   139: aload_1
    //   140: invokevirtual 401	java/io/ObjectInputStream:close	()V
    //   143: aload_3
    //   144: invokevirtual 402	java/io/ByteArrayInputStream:close	()V
    //   147: aconst_null
    //   148: astore_0
    //   149: goto -101 -> 48
    //   152: astore_0
    //   153: aload_0
    //   154: invokevirtual 357	java/io/IOException:printStackTrace	()V
    //   157: aconst_null
    //   158: astore_0
    //   159: goto -111 -> 48
    //   162: astore_2
    //   163: aconst_null
    //   164: astore_1
    //   165: aload_1
    //   166: astore_0
    //   167: aload_2
    //   168: invokevirtual 405	java/lang/Exception:printStackTrace	()V
    //   171: aload_1
    //   172: ifnull +7 -> 179
    //   175: aload_1
    //   176: invokevirtual 401	java/io/ObjectInputStream:close	()V
    //   179: aload_3
    //   180: invokevirtual 402	java/io/ByteArrayInputStream:close	()V
    //   183: aconst_null
    //   184: astore_0
    //   185: goto -137 -> 48
    //   188: astore_0
    //   189: aload_0
    //   190: invokevirtual 357	java/io/IOException:printStackTrace	()V
    //   193: aconst_null
    //   194: astore_0
    //   195: goto -147 -> 48
    //   198: astore_1
    //   199: aconst_null
    //   200: astore_0
    //   201: aload_0
    //   202: ifnull +7 -> 209
    //   205: aload_0
    //   206: invokevirtual 401	java/io/ObjectInputStream:close	()V
    //   209: aload_3
    //   210: invokevirtual 402	java/io/ByteArrayInputStream:close	()V
    //   213: aload_1
    //   214: athrow
    //   215: astore_0
    //   216: aload_0
    //   217: invokevirtual 357	java/io/IOException:printStackTrace	()V
    //   220: goto -7 -> 213
    //   223: astore_1
    //   224: goto -23 -> 201
    //   227: astore_2
    //   228: goto -63 -> 165
    //   231: astore_2
    //   232: goto -103 -> 129
    //   235: astore_2
    //   236: goto -143 -> 93
    //   239: astore_0
    //   240: aload_1
    //   241: astore_0
    //   242: goto -179 -> 63
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	245	0	paramArrayOfByte	byte[]
    //   23	153	1	localObjectInputStream	java.io.ObjectInputStream
    //   198	16	1	localObject1	Object
    //   223	18	1	localObject2	Object
    //   33	23	2	localPAMessage	com.tencent.mobileqq.data.PAMessage
    //   90	6	2	localClassNotFoundException1	java.lang.ClassNotFoundException
    //   126	6	2	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   162	6	2	localException1	Exception
    //   227	1	2	localException2	Exception
    //   231	1	2	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   235	1	2	localClassNotFoundException2	java.lang.ClassNotFoundException
    //   14	196	3	localByteArrayInputStream	java.io.ByteArrayInputStream
    // Exception table:
    //   from	to	target	type
    //   38	42	50	java/io/IOException
    //   42	46	50	java/io/IOException
    //   15	24	60	java/io/IOException
    //   67	71	80	java/io/IOException
    //   71	75	80	java/io/IOException
    //   15	24	90	java/lang/ClassNotFoundException
    //   103	107	116	java/io/IOException
    //   107	111	116	java/io/IOException
    //   15	24	126	java/lang/OutOfMemoryError
    //   139	143	152	java/io/IOException
    //   143	147	152	java/io/IOException
    //   15	24	162	java/lang/Exception
    //   175	179	188	java/io/IOException
    //   179	183	188	java/io/IOException
    //   15	24	198	finally
    //   205	209	215	java/io/IOException
    //   209	213	215	java/io/IOException
    //   26	34	223	finally
    //   95	99	223	finally
    //   131	135	223	finally
    //   167	171	223	finally
    //   26	34	227	java/lang/Exception
    //   26	34	231	java/lang/OutOfMemoryError
    //   26	34	235	java/lang/ClassNotFoundException
    //   26	34	239	java/io/IOException
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
      int j = paramNode.getLength();
      int i = 0;
      while (i < j)
      {
        Node localNode = paramNode.item(i);
        if (localNode.getNodeType() == 3) {
          ((StringBuilder)localObject).append(localNode.getNodeValue());
        }
        i += 1;
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
    //   6: new 432	java/io/ByteArrayOutputStream
    //   9: dup
    //   10: invokespecial 433	java/io/ByteArrayOutputStream:<init>	()V
    //   13: astore_3
    //   14: new 435	java/io/ObjectOutputStream
    //   17: dup
    //   18: aload_3
    //   19: invokespecial 438	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   22: astore_2
    //   23: aload_2
    //   24: astore_1
    //   25: aload_2
    //   26: aload_0
    //   27: invokevirtual 442	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   30: aload_2
    //   31: astore_1
    //   32: aload_3
    //   33: invokevirtual 445	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   36: astore_0
    //   37: aload_2
    //   38: ifnull +7 -> 45
    //   41: aload_2
    //   42: invokevirtual 446	java/io/ObjectOutputStream:close	()V
    //   45: aload_3
    //   46: invokevirtual 447	java/io/ByteArrayOutputStream:close	()V
    //   49: aload_0
    //   50: areturn
    //   51: astore_1
    //   52: aload_1
    //   53: invokevirtual 357	java/io/IOException:printStackTrace	()V
    //   56: aload_0
    //   57: areturn
    //   58: astore_0
    //   59: aconst_null
    //   60: astore_2
    //   61: aload_2
    //   62: astore_1
    //   63: aload_0
    //   64: invokevirtual 404	java/lang/OutOfMemoryError:printStackTrace	()V
    //   67: aload_2
    //   68: ifnull +7 -> 75
    //   71: aload_2
    //   72: invokevirtual 446	java/io/ObjectOutputStream:close	()V
    //   75: aload_3
    //   76: invokevirtual 447	java/io/ByteArrayOutputStream:close	()V
    //   79: aconst_null
    //   80: areturn
    //   81: astore_0
    //   82: aload_0
    //   83: invokevirtual 357	java/io/IOException:printStackTrace	()V
    //   86: aconst_null
    //   87: areturn
    //   88: astore_0
    //   89: aconst_null
    //   90: astore_2
    //   91: aload_2
    //   92: astore_1
    //   93: aload_0
    //   94: invokevirtual 357	java/io/IOException:printStackTrace	()V
    //   97: aload_2
    //   98: ifnull +7 -> 105
    //   101: aload_2
    //   102: invokevirtual 446	java/io/ObjectOutputStream:close	()V
    //   105: aload_3
    //   106: invokevirtual 447	java/io/ByteArrayOutputStream:close	()V
    //   109: aconst_null
    //   110: areturn
    //   111: astore_0
    //   112: aload_0
    //   113: invokevirtual 357	java/io/IOException:printStackTrace	()V
    //   116: aconst_null
    //   117: areturn
    //   118: astore_0
    //   119: aconst_null
    //   120: astore_1
    //   121: aload_1
    //   122: ifnull +7 -> 129
    //   125: aload_1
    //   126: invokevirtual 446	java/io/ObjectOutputStream:close	()V
    //   129: aload_3
    //   130: invokevirtual 447	java/io/ByteArrayOutputStream:close	()V
    //   133: aload_0
    //   134: athrow
    //   135: astore_1
    //   136: aload_1
    //   137: invokevirtual 357	java/io/IOException:printStackTrace	()V
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
  
  private static String b(Node paramNode)
  {
    if (paramNode == null) {}
    do
    {
      return null;
      paramNode = paramNode.getChildNodes();
    } while (paramNode == null);
    JSONObject localJSONObject = new JSONObject();
    int i = 0;
    for (;;)
    {
      if (i < paramNode.getLength())
      {
        Node localNode = paramNode.item(i);
        try
        {
          localJSONObject.put(localNode.getNodeName(), a(localNode));
          i += 1;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     txr
 * JD-Core Version:    0.7.0.1
 */