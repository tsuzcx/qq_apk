package com.tencent.qmsp.sdk.c;

import android.os.Bundle;
import android.util.Pair;
import com.tencent.qmsp.sdk.a.b;
import com.tencent.qmsp.sdk.f.k;
import java.io.File;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class j
{
  private static final byte[][] c = { { 20, 67, -74, 67, 2, 50, 117, -18 }, { 51, 117, -95, 83, 39, 52, 121 }, { 9, 121, -79, 101, 32, 47, 101, -28 }, { 44, 116 }, { 49, 105, -93, 69 }, { 35, 124, -78, 71, 61 }, { 53, 113, -89, 72 }, { 43, 113, -66, 69 }, { 51, 113, -65, 85, 43 }, { 51, 117, -95 }, { 20, 125, -96, 80, 96, 63, 118, -23 } };
  private List<a> a;
  private int b = 1;
  
  public j()
  {
    Pair localPair = a(c(), 1);
    if (localPair != null)
    {
      this.b = ((Integer)localPair.first).intValue();
      this.a = ((List)localPair.second);
    }
    if (this.a == null) {
      this.a = new LinkedList();
    }
  }
  
  private int a(Element paramElement)
  {
    for (;;)
    {
      int i;
      try
      {
        paramElement = paramElement.getAttributes();
        if (paramElement != null) {
          break label79;
        }
        return 0;
      }
      catch (Exception paramElement)
      {
        Node localNode;
        String str;
        paramElement.printStackTrace();
      }
      if (i < paramElement.getLength())
      {
        localNode = paramElement.item(i);
        str = localNode.getNodeName();
        if ((str != null) && (str.equalsIgnoreCase(b(1))))
        {
          i = Integer.parseInt(localNode.getNodeValue());
          return i;
        }
      }
      else
      {
        return 0;
        label79:
        i = 0;
        continue;
      }
      i += 1;
    }
  }
  
  private Pair<Integer, List<a>> a(String paramString, int paramInt)
  {
    Object localObject = null;
    byte[] arrayOfByte = new m().a(paramString, null, 1);
    paramString = localObject;
    if (arrayOfByte != null) {
      paramString = a(arrayOfByte, paramInt);
    }
    return paramString;
  }
  
  /* Error */
  private Pair<Integer, List<a>> a(byte[] paramArrayOfByte, int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: invokestatic 114	javax/xml/parsers/DocumentBuilderFactory:newInstance	()Ljavax/xml/parsers/DocumentBuilderFactory;
    //   6: astore 5
    //   8: aload 5
    //   10: invokevirtual 118	javax/xml/parsers/DocumentBuilderFactory:newDocumentBuilder	()Ljavax/xml/parsers/DocumentBuilder;
    //   13: astore 7
    //   15: new 120	java/io/ByteArrayInputStream
    //   18: dup
    //   19: aload_1
    //   20: invokespecial 123	java/io/ByteArrayInputStream:<init>	([B)V
    //   23: astore 5
    //   25: aload 5
    //   27: astore_1
    //   28: aload 7
    //   30: aload 5
    //   32: invokevirtual 129	javax/xml/parsers/DocumentBuilder:parse	(Ljava/io/InputStream;)Lorg/w3c/dom/Document;
    //   35: invokeinterface 135 1 0
    //   40: astore 7
    //   42: aload 5
    //   44: astore_1
    //   45: aload_0
    //   46: aload 7
    //   48: invokespecial 137	com/tencent/qmsp/sdk/c/j:a	(Lorg/w3c/dom/Element;)I
    //   51: istore_3
    //   52: iload_3
    //   53: ifeq +8 -> 61
    //   56: iload_3
    //   57: iload_2
    //   58: if_icmple +28 -> 86
    //   61: aload 5
    //   63: astore_1
    //   64: new 33	android/util/Pair
    //   67: dup
    //   68: iload_3
    //   69: invokestatic 141	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   72: aconst_null
    //   73: invokespecial 144	android/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   76: astore 6
    //   78: aload 5
    //   80: invokevirtual 147	java/io/ByteArrayInputStream:close	()V
    //   83: aload 6
    //   85: areturn
    //   86: aload 5
    //   88: astore_1
    //   89: new 52	java/util/LinkedList
    //   92: dup
    //   93: invokespecial 53	java/util/LinkedList:<init>	()V
    //   96: astore 6
    //   98: aload 5
    //   100: astore_1
    //   101: aload 7
    //   103: invokeinterface 151 1 0
    //   108: astore 7
    //   110: aload 5
    //   112: astore_1
    //   113: aload 7
    //   115: invokeinterface 154 1 0
    //   120: istore 4
    //   122: iconst_0
    //   123: istore_2
    //   124: iload_2
    //   125: iload 4
    //   127: if_icmpge +120 -> 247
    //   130: aload 5
    //   132: astore_1
    //   133: aload 7
    //   135: iload_2
    //   136: invokeinterface 155 2 0
    //   141: astore 8
    //   143: aload 5
    //   145: astore_1
    //   146: aload 8
    //   148: invokeinterface 159 1 0
    //   153: iconst_1
    //   154: if_icmpeq +6 -> 160
    //   157: goto +186 -> 343
    //   160: aload 5
    //   162: astore_1
    //   163: aload 8
    //   165: invokeinterface 76 1 0
    //   170: astore 9
    //   172: aload 9
    //   174: ifnull +169 -> 343
    //   177: aload 5
    //   179: astore_1
    //   180: aload 9
    //   182: aload_0
    //   183: iconst_2
    //   184: invokespecial 79	com/tencent/qmsp/sdk/c/j:b	(I)Ljava/lang/String;
    //   187: invokevirtual 85	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   190: ifeq +153 -> 343
    //   193: aload 5
    //   195: astore_1
    //   196: aload_0
    //   197: aload 8
    //   199: invokespecial 162	com/tencent/qmsp/sdk/c/j:a	(Lorg/w3c/dom/Node;)Lcom/tencent/qmsp/sdk/c/j$a;
    //   202: astore 8
    //   204: aload 8
    //   206: ifnull +137 -> 343
    //   209: aload 5
    //   211: astore_1
    //   212: aload 6
    //   214: aload 8
    //   216: invokeinterface 166 2 0
    //   221: pop
    //   222: goto +121 -> 343
    //   225: astore 6
    //   227: aload 5
    //   229: astore_1
    //   230: aload 6
    //   232: invokevirtual 95	java/lang/Exception:printStackTrace	()V
    //   235: aload 5
    //   237: ifnull +8 -> 245
    //   240: aload 5
    //   242: invokevirtual 147	java/io/ByteArrayInputStream:close	()V
    //   245: aconst_null
    //   246: areturn
    //   247: aload 5
    //   249: astore_1
    //   250: new 33	android/util/Pair
    //   253: dup
    //   254: iload_3
    //   255: invokestatic 141	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   258: aload 6
    //   260: invokespecial 144	android/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   263: astore 6
    //   265: aload 5
    //   267: invokevirtual 147	java/io/ByteArrayInputStream:close	()V
    //   270: aload 6
    //   272: areturn
    //   273: astore_1
    //   274: aload_1
    //   275: invokevirtual 167	java/io/IOException:printStackTrace	()V
    //   278: aload 6
    //   280: areturn
    //   281: astore_1
    //   282: aload_1
    //   283: invokevirtual 167	java/io/IOException:printStackTrace	()V
    //   286: aload 6
    //   288: areturn
    //   289: astore 6
    //   291: aconst_null
    //   292: astore 5
    //   294: goto -67 -> 227
    //   297: astore_1
    //   298: aload_1
    //   299: invokevirtual 167	java/io/IOException:printStackTrace	()V
    //   302: goto -57 -> 245
    //   305: astore 6
    //   307: aload_1
    //   308: astore 5
    //   310: aload 6
    //   312: astore_1
    //   313: aload 5
    //   315: ifnull +8 -> 323
    //   318: aload 5
    //   320: invokevirtual 147	java/io/ByteArrayInputStream:close	()V
    //   323: aload_1
    //   324: athrow
    //   325: astore 5
    //   327: aload 5
    //   329: invokevirtual 167	java/io/IOException:printStackTrace	()V
    //   332: goto -9 -> 323
    //   335: astore_1
    //   336: aload 6
    //   338: astore 5
    //   340: goto -27 -> 313
    //   343: iload_2
    //   344: iconst_1
    //   345: iadd
    //   346: istore_2
    //   347: goto -223 -> 124
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	350	0	this	j
    //   0	350	1	paramArrayOfByte	byte[]
    //   0	350	2	paramInt	int
    //   51	204	3	i	int
    //   120	8	4	j	int
    //   6	313	5	localObject1	Object
    //   325	3	5	localIOException	java.io.IOException
    //   338	1	5	localObject2	Object
    //   1	212	6	localObject3	Object
    //   225	34	6	localException1	Exception
    //   263	24	6	localPair	Pair
    //   289	1	6	localException2	Exception
    //   305	32	6	localObject4	Object
    //   13	121	7	localObject5	Object
    //   141	74	8	localObject6	Object
    //   170	11	9	str	String
    // Exception table:
    //   from	to	target	type
    //   28	42	225	java/lang/Exception
    //   45	52	225	java/lang/Exception
    //   64	78	225	java/lang/Exception
    //   89	98	225	java/lang/Exception
    //   101	110	225	java/lang/Exception
    //   113	122	225	java/lang/Exception
    //   133	143	225	java/lang/Exception
    //   146	157	225	java/lang/Exception
    //   163	172	225	java/lang/Exception
    //   180	193	225	java/lang/Exception
    //   196	204	225	java/lang/Exception
    //   212	222	225	java/lang/Exception
    //   250	265	225	java/lang/Exception
    //   265	270	273	java/io/IOException
    //   78	83	281	java/io/IOException
    //   8	25	289	java/lang/Exception
    //   240	245	297	java/io/IOException
    //   28	42	305	finally
    //   45	52	305	finally
    //   64	78	305	finally
    //   89	98	305	finally
    //   101	110	305	finally
    //   113	122	305	finally
    //   133	143	305	finally
    //   146	157	305	finally
    //   163	172	305	finally
    //   180	193	305	finally
    //   196	204	305	finally
    //   212	222	305	finally
    //   230	235	305	finally
    //   250	265	305	finally
    //   318	323	325	java/io/IOException
    //   8	25	335	finally
  }
  
  private a a(Node paramNode)
  {
    int j = 0;
    a locala;
    int i;
    Object localObject;
    int k;
    String str;
    try
    {
      NamedNodeMap localNamedNodeMap = paramNode.getAttributes();
      if (localNamedNodeMap == null) {
        return null;
      }
      locala = new a();
      int m = localNamedNodeMap.getLength();
      i = 0;
      if (i >= m) {
        break label267;
      }
      localObject = localNamedNodeMap.item(i);
      if (((Node)localObject).getNodeType() != 2)
      {
        k = j;
        break label249;
      }
      str = ((Node)localObject).getNodeName();
      localObject = ((Node)localObject).getNodeValue();
      k = j;
      if (str == null) {
        break label249;
      }
      k = j;
      if (localObject == null) {
        break label249;
      }
      if (str.equalsIgnoreCase(b(3))) {
        locala.a = Integer.parseInt((String)localObject);
      } else if (str.equalsIgnoreCase(b(4))) {
        locala.b = Integer.parseInt((String)localObject);
      }
    }
    catch (Exception paramNode)
    {
      paramNode.printStackTrace();
      return null;
    }
    if (str.equalsIgnoreCase(b(5)))
    {
      locala.c = Integer.parseInt((String)localObject);
    }
    else if (str.equalsIgnoreCase(b(6)))
    {
      locala.e = ((String)localObject);
    }
    else
    {
      k = j;
      if (str.equalsIgnoreCase(b(9))) {
        locala.d = ((String)localObject);
      }
    }
    label249:
    do
    {
      b(paramNode);
      return locala;
      for (;;)
      {
        i += 1;
        j = k;
        break;
        k = j + 1;
      }
    } while (j == 5);
    label267:
    return null;
  }
  
  private boolean a(String paramString, int paramInt, List<a> paramList)
  {
    paramList = a(paramInt, paramList);
    if (paramList == null) {
      return false;
    }
    return new m().a(paramString, paramList, null, 1);
  }
  
  /* Error */
  private byte[] a(int paramInt, List<a> paramList)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: invokestatic 199	android/util/Xml:newSerializer	()Lorg/xmlpull/v1/XmlSerializer;
    //   5: astore 5
    //   7: new 201	java/io/ByteArrayOutputStream
    //   10: dup
    //   11: invokespecial 202	java/io/ByteArrayOutputStream:<init>	()V
    //   14: astore 4
    //   16: aload 4
    //   18: astore_3
    //   19: aload 5
    //   21: aload 4
    //   23: ldc 204
    //   25: invokeinterface 210 3 0
    //   30: aload 4
    //   32: astore_3
    //   33: aload 5
    //   35: aconst_null
    //   36: iconst_1
    //   37: invokestatic 215	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   40: invokeinterface 219 3 0
    //   45: aload 4
    //   47: astore_3
    //   48: aload 5
    //   50: aconst_null
    //   51: aload_0
    //   52: iconst_0
    //   53: invokespecial 79	com/tencent/qmsp/sdk/c/j:b	(I)Ljava/lang/String;
    //   56: invokeinterface 223 3 0
    //   61: pop
    //   62: aload 4
    //   64: astore_3
    //   65: aload 5
    //   67: aconst_null
    //   68: aload_0
    //   69: iconst_1
    //   70: invokespecial 79	com/tencent/qmsp/sdk/c/j:b	(I)Ljava/lang/String;
    //   73: iload_1
    //   74: invokestatic 226	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   77: invokeinterface 230 4 0
    //   82: pop
    //   83: aload 4
    //   85: astore_3
    //   86: aload_2
    //   87: invokeinterface 234 1 0
    //   92: astore_2
    //   93: aload 4
    //   95: astore_3
    //   96: aload_2
    //   97: invokeinterface 240 1 0
    //   102: ifeq +199 -> 301
    //   105: aload 4
    //   107: astore_3
    //   108: aload_2
    //   109: invokeinterface 244 1 0
    //   114: checkcast 6	com/tencent/qmsp/sdk/c/j$a
    //   117: astore 6
    //   119: aload 4
    //   121: astore_3
    //   122: aload 5
    //   124: aconst_null
    //   125: aload_0
    //   126: iconst_2
    //   127: invokespecial 79	com/tencent/qmsp/sdk/c/j:b	(I)Ljava/lang/String;
    //   130: invokeinterface 223 3 0
    //   135: pop
    //   136: aload 4
    //   138: astore_3
    //   139: aload 5
    //   141: aconst_null
    //   142: aload_0
    //   143: iconst_3
    //   144: invokespecial 79	com/tencent/qmsp/sdk/c/j:b	(I)Ljava/lang/String;
    //   147: aload 6
    //   149: getfield 172	com/tencent/qmsp/sdk/c/j$a:a	I
    //   152: invokestatic 226	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   155: invokeinterface 230 4 0
    //   160: pop
    //   161: aload 4
    //   163: astore_3
    //   164: aload 5
    //   166: aconst_null
    //   167: aload_0
    //   168: iconst_4
    //   169: invokespecial 79	com/tencent/qmsp/sdk/c/j:b	(I)Ljava/lang/String;
    //   172: aload 6
    //   174: getfield 173	com/tencent/qmsp/sdk/c/j$a:b	I
    //   177: invokestatic 226	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   180: invokeinterface 230 4 0
    //   185: pop
    //   186: aload 4
    //   188: astore_3
    //   189: aload 5
    //   191: aconst_null
    //   192: aload_0
    //   193: iconst_5
    //   194: invokespecial 79	com/tencent/qmsp/sdk/c/j:b	(I)Ljava/lang/String;
    //   197: aload 6
    //   199: getfield 175	com/tencent/qmsp/sdk/c/j$a:c	I
    //   202: invokestatic 226	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   205: invokeinterface 230 4 0
    //   210: pop
    //   211: aload 4
    //   213: astore_3
    //   214: aload 5
    //   216: aconst_null
    //   217: aload_0
    //   218: bipush 9
    //   220: invokespecial 79	com/tencent/qmsp/sdk/c/j:b	(I)Ljava/lang/String;
    //   223: aload 6
    //   225: getfield 182	com/tencent/qmsp/sdk/c/j$a:d	Ljava/lang/String;
    //   228: invokeinterface 230 4 0
    //   233: pop
    //   234: aload 4
    //   236: astore_3
    //   237: aload 5
    //   239: aconst_null
    //   240: aload_0
    //   241: bipush 6
    //   243: invokespecial 79	com/tencent/qmsp/sdk/c/j:b	(I)Ljava/lang/String;
    //   246: aload 6
    //   248: getfield 179	com/tencent/qmsp/sdk/c/j$a:e	Ljava/lang/String;
    //   251: invokeinterface 230 4 0
    //   256: pop
    //   257: aload 4
    //   259: astore_3
    //   260: aload 5
    //   262: aconst_null
    //   263: aload_0
    //   264: iconst_2
    //   265: invokespecial 79	com/tencent/qmsp/sdk/c/j:b	(I)Ljava/lang/String;
    //   268: invokeinterface 247 3 0
    //   273: pop
    //   274: goto -181 -> 93
    //   277: astore_3
    //   278: aload 4
    //   280: astore_2
    //   281: aload_3
    //   282: astore 4
    //   284: aload_2
    //   285: astore_3
    //   286: aload 4
    //   288: invokevirtual 95	java/lang/Exception:printStackTrace	()V
    //   291: aload_2
    //   292: ifnull +7 -> 299
    //   295: aload_2
    //   296: invokevirtual 248	java/io/ByteArrayOutputStream:close	()V
    //   299: aconst_null
    //   300: areturn
    //   301: aload 4
    //   303: astore_3
    //   304: aload 5
    //   306: aconst_null
    //   307: aload_0
    //   308: iconst_0
    //   309: invokespecial 79	com/tencent/qmsp/sdk/c/j:b	(I)Ljava/lang/String;
    //   312: invokeinterface 247 3 0
    //   317: pop
    //   318: aload 4
    //   320: astore_3
    //   321: aload 5
    //   323: invokeinterface 251 1 0
    //   328: aload 4
    //   330: astore_3
    //   331: aload 4
    //   333: invokevirtual 255	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   336: astore_2
    //   337: aload 4
    //   339: invokevirtual 248	java/io/ByteArrayOutputStream:close	()V
    //   342: aload_2
    //   343: areturn
    //   344: astore_3
    //   345: aload_3
    //   346: invokevirtual 167	java/io/IOException:printStackTrace	()V
    //   349: aload_2
    //   350: areturn
    //   351: astore 4
    //   353: aconst_null
    //   354: astore_2
    //   355: goto -71 -> 284
    //   358: astore_2
    //   359: aload_2
    //   360: invokevirtual 167	java/io/IOException:printStackTrace	()V
    //   363: goto -64 -> 299
    //   366: astore_2
    //   367: aload_3
    //   368: ifnull +7 -> 375
    //   371: aload_3
    //   372: invokevirtual 248	java/io/ByteArrayOutputStream:close	()V
    //   375: aload_2
    //   376: athrow
    //   377: astore_3
    //   378: aload_3
    //   379: invokevirtual 167	java/io/IOException:printStackTrace	()V
    //   382: goto -7 -> 375
    //   385: astore_2
    //   386: goto -19 -> 367
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	389	0	this	j
    //   0	389	1	paramInt	int
    //   0	389	2	paramList	List<a>
    //   1	259	3	localObject1	Object
    //   277	5	3	localException1	Exception
    //   285	46	3	localObject2	Object
    //   344	28	3	localIOException1	java.io.IOException
    //   377	2	3	localIOException2	java.io.IOException
    //   14	324	4	localObject3	Object
    //   351	1	4	localException2	Exception
    //   5	317	5	localXmlSerializer	org.xmlpull.v1.XmlSerializer
    //   117	130	6	locala	a
    // Exception table:
    //   from	to	target	type
    //   19	30	277	java/lang/Exception
    //   33	45	277	java/lang/Exception
    //   48	62	277	java/lang/Exception
    //   65	83	277	java/lang/Exception
    //   86	93	277	java/lang/Exception
    //   96	105	277	java/lang/Exception
    //   108	119	277	java/lang/Exception
    //   122	136	277	java/lang/Exception
    //   139	161	277	java/lang/Exception
    //   164	186	277	java/lang/Exception
    //   189	211	277	java/lang/Exception
    //   214	234	277	java/lang/Exception
    //   237	257	277	java/lang/Exception
    //   260	274	277	java/lang/Exception
    //   304	318	277	java/lang/Exception
    //   321	328	277	java/lang/Exception
    //   331	337	277	java/lang/Exception
    //   337	342	344	java/io/IOException
    //   2	16	351	java/lang/Exception
    //   295	299	358	java/io/IOException
    //   19	30	366	finally
    //   33	45	366	finally
    //   48	62	366	finally
    //   65	83	366	finally
    //   86	93	366	finally
    //   96	105	366	finally
    //   108	119	366	finally
    //   122	136	366	finally
    //   139	161	366	finally
    //   164	186	366	finally
    //   189	211	366	finally
    //   214	234	366	finally
    //   237	257	366	finally
    //   260	274	366	finally
    //   286	291	366	finally
    //   304	318	366	finally
    //   321	328	366	finally
    //   331	337	366	finally
    //   371	375	377	java/io/IOException
    //   2	16	385	finally
  }
  
  private Bundle b(Node paramNode)
  {
    for (;;)
    {
      int i;
      try
      {
        Bundle localBundle = new Bundle();
        NodeList localNodeList = paramNode.getChildNodes();
        int j = localNodeList.getLength();
        i = 0;
        paramNode = localBundle;
        if (i < j)
        {
          paramNode = localNodeList.item(i);
          if (paramNode.getNodeType() != 1) {
            break label174;
          }
          Object localObject = paramNode.getAttributes();
          if (localObject == null) {
            break label174;
          }
          paramNode = ((NamedNodeMap)localObject).getNamedItem(b(7));
          if ((paramNode == null) || (paramNode.getNodeType() != 2)) {
            break label174;
          }
          paramNode = paramNode.getNodeValue();
          if (paramNode == null) {
            break label174;
          }
          localObject = ((NamedNodeMap)localObject).getNamedItem(b(8));
          if ((localObject == null) || (((Node)localObject).getNodeType() != 2)) {
            break label174;
          }
          localObject = ((Node)localObject).getNodeValue();
          if (localObject == null) {
            break label174;
          }
          localBundle.putString(paramNode, (String)localObject);
        }
      }
      catch (Exception paramNode)
      {
        paramNode.printStackTrace();
        paramNode = null;
      }
      return paramNode;
      label174:
      i += 1;
    }
  }
  
  private String b(int paramInt)
  {
    return k.a(c[paramInt]);
  }
  
  private String c()
  {
    return b.a() + File.separator + b(10);
  }
  
  private boolean c(int paramInt)
  {
    return d(paramInt) != null;
  }
  
  private a d(int paramInt)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      if (locala.a == paramInt) {
        return locala;
      }
    }
    return null;
  }
  
  public a a(int paramInt)
  {
    return d(paramInt);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    a locala = d(paramInt);
    if (locala == null) {}
    do
    {
      return;
      this.a.remove(locala);
    } while (!paramBoolean);
    a(c(), this.b, this.a);
  }
  
  public boolean a()
  {
    return a(c(), this.b, this.a);
  }
  
  public boolean a(a parama, boolean paramBoolean)
  {
    if (c(parama.a)) {
      return false;
    }
    this.a.add(parama);
    if (paramBoolean) {
      return a();
    }
    return true;
  }
  
  public List<a> b()
  {
    return this.a;
  }
  
  public static class a
  {
    int a;
    int b;
    int c;
    String d;
    String e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qmsp.sdk.c.j
 * JD-Core Version:    0.7.0.1
 */