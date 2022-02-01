import android.os.Bundle;
import android.util.Pair;
import java.io.File;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class asyx
{
  private List<asyx.a> Kg;
  private int mVersion = 1;
  
  public asyx()
  {
    Pair localPair = e(Et(), 1);
    if (localPair != null)
    {
      this.mVersion = ((Integer)localPair.first).intValue();
      this.Kg = ((List)localPair.second);
    }
    if (this.Kg == null) {
      this.Kg = new LinkedList();
    }
  }
  
  private String Et()
  {
    return asxu.Ek() + File.separator + "QSec.dat";
  }
  
  private Bundle a(Node paramNode)
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
            break label166;
          }
          Object localObject = paramNode.getAttributes();
          if (localObject == null) {
            break label166;
          }
          paramNode = ((NamedNodeMap)localObject).getNamedItem("name");
          if ((paramNode == null) || (paramNode.getNodeType() != 2)) {
            break label166;
          }
          paramNode = paramNode.getNodeValue();
          if (paramNode == null) {
            break label166;
          }
          localObject = ((NamedNodeMap)localObject).getNamedItem("value");
          if ((localObject == null) || (((Node)localObject).getNodeType() != 2)) {
            break label166;
          }
          localObject = ((Node)localObject).getNodeValue();
          if (localObject == null) {
            break label166;
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
      label166:
      i += 1;
    }
  }
  
  private asyx.a a(int paramInt)
  {
    Iterator localIterator = this.Kg.iterator();
    while (localIterator.hasNext())
    {
      asyx.a locala = (asyx.a)localIterator.next();
      if (locala.eok == paramInt) {
        return locala;
      }
    }
    return null;
  }
  
  private asyx.a a(Node paramNode)
  {
    int k = 0;
    do
    {
      for (;;)
      {
        int j;
        int i;
        try
        {
          NamedNodeMap localNamedNodeMap = paramNode.getAttributes();
          if (localNamedNodeMap == null) {
            return null;
          }
          locala = new asyx.a();
          int m = localNamedNodeMap.getLength();
          j = 0;
          if (j >= m) {
            break;
          }
          Object localObject = localNamedNodeMap.item(j);
          if (((Node)localObject).getNodeType() != 2)
          {
            i = k;
          }
          else
          {
            String str = ((Node)localObject).getNodeName();
            localObject = ((Node)localObject).getNodeValue();
            i = k;
            if (str != null)
            {
              i = k;
              if (localObject != null) {
                if (str.equalsIgnoreCase("id"))
                {
                  locala.eok = Integer.parseInt((String)localObject);
                  i = k + 1;
                }
                else if (str.equalsIgnoreCase("type"))
                {
                  locala.mLibType = Integer.parseInt((String)localObject);
                  i = k + 1;
                }
                else if (str.equalsIgnoreCase("flags"))
                {
                  locala.eol = Integer.parseInt((String)localObject);
                  i = k + 1;
                }
                else if (str.equalsIgnoreCase("path"))
                {
                  locala.cGk = ((String)localObject);
                  i = k + 1;
                }
                else
                {
                  i = k;
                  if (str.equalsIgnoreCase("ver"))
                  {
                    locala.cGj = ((String)localObject);
                    i = k + 1;
                  }
                }
              }
            }
          }
        }
        catch (Exception paramNode)
        {
          asyx.a locala;
          paramNode.printStackTrace();
          return null;
        }
        locala.bG = a(paramNode);
        return locala;
        j += 1;
        k = i;
      }
    } while (k == 5);
    return null;
  }
  
  private int b(Element paramElement)
  {
    for (;;)
    {
      int i;
      try
      {
        paramElement = paramElement.getAttributes();
        if (paramElement != null) {
          break label76;
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
        if ((str != null) && (str.equalsIgnoreCase("version")))
        {
          i = Integer.parseInt(localNode.getNodeValue());
          return i;
        }
      }
      else
      {
        return 0;
        label76:
        i = 0;
        continue;
      }
      i += 1;
    }
  }
  
  /* Error */
  private Pair<Integer, List<asyx.a>> b(byte[] paramArrayOfByte, int paramInt)
  {
    // Byte code:
    //   0: invokestatic 200	javax/xml/parsers/DocumentBuilderFactory:newInstance	()Ljavax/xml/parsers/DocumentBuilderFactory;
    //   3: astore 5
    //   5: aload 5
    //   7: invokevirtual 204	javax/xml/parsers/DocumentBuilderFactory:newDocumentBuilder	()Ljavax/xml/parsers/DocumentBuilder;
    //   10: astore 6
    //   12: new 206	java/io/ByteArrayInputStream
    //   15: dup
    //   16: aload_1
    //   17: invokespecial 209	java/io/ByteArrayInputStream:<init>	([B)V
    //   20: astore 5
    //   22: aload 5
    //   24: astore_1
    //   25: aload 6
    //   27: aload 5
    //   29: invokevirtual 215	javax/xml/parsers/DocumentBuilder:parse	(Ljava/io/InputStream;)Lorg/w3c/dom/Document;
    //   32: invokeinterface 221 1 0
    //   37: astore 7
    //   39: aload 5
    //   41: astore_1
    //   42: aload_0
    //   43: aload 7
    //   45: invokespecial 223	asyx:b	(Lorg/w3c/dom/Element;)I
    //   48: istore_3
    //   49: iload_3
    //   50: ifeq +8 -> 58
    //   53: iload_3
    //   54: iload_2
    //   55: if_icmple +46 -> 101
    //   58: aload 5
    //   60: astore_1
    //   61: new 28	android/util/Pair
    //   64: dup
    //   65: iload_3
    //   66: invokestatic 227	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   69: aconst_null
    //   70: invokespecial 230	android/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   73: astore 6
    //   75: aload 6
    //   77: astore_1
    //   78: aload 5
    //   80: ifnull +11 -> 91
    //   83: aload 5
    //   85: invokevirtual 233	java/io/ByteArrayInputStream:close	()V
    //   88: aload 6
    //   90: astore_1
    //   91: aload_1
    //   92: areturn
    //   93: astore_1
    //   94: aload_1
    //   95: invokevirtual 234	java/io/IOException:printStackTrace	()V
    //   98: aload 6
    //   100: areturn
    //   101: aload 5
    //   103: astore_1
    //   104: new 47	java/util/LinkedList
    //   107: dup
    //   108: invokespecial 48	java/util/LinkedList:<init>	()V
    //   111: astore 6
    //   113: aload 5
    //   115: astore_1
    //   116: aload 7
    //   118: invokeinterface 235 1 0
    //   123: astore 7
    //   125: aload 5
    //   127: astore_1
    //   128: aload 7
    //   130: invokeinterface 89 1 0
    //   135: istore 4
    //   137: iconst_0
    //   138: istore_2
    //   139: iload_2
    //   140: iload 4
    //   142: if_icmpge +117 -> 259
    //   145: aload 5
    //   147: astore_1
    //   148: aload 7
    //   150: iload_2
    //   151: invokeinterface 93 2 0
    //   156: astore 8
    //   158: aload 5
    //   160: astore_1
    //   161: aload 8
    //   163: invokeinterface 97 1 0
    //   168: iconst_1
    //   169: if_icmpeq +6 -> 175
    //   172: goto +173 -> 345
    //   175: aload 5
    //   177: astore_1
    //   178: aload 8
    //   180: invokeinterface 146 1 0
    //   185: astore 9
    //   187: aload 9
    //   189: ifnull +156 -> 345
    //   192: aload 5
    //   194: astore_1
    //   195: aload 9
    //   197: ldc 237
    //   199: invokevirtual 154	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   202: ifeq +143 -> 345
    //   205: aload 5
    //   207: astore_1
    //   208: aload_0
    //   209: aload 8
    //   211: invokespecial 239	asyx:a	(Lorg/w3c/dom/Node;)Lasyx$a;
    //   214: astore 8
    //   216: aload 8
    //   218: ifnull +127 -> 345
    //   221: aload 5
    //   223: astore_1
    //   224: aload 6
    //   226: aload 8
    //   228: invokeinterface 243 2 0
    //   233: pop
    //   234: goto +111 -> 345
    //   237: astore 6
    //   239: aload 5
    //   241: astore_1
    //   242: aload 6
    //   244: invokevirtual 121	java/lang/Exception:printStackTrace	()V
    //   247: aload 5
    //   249: ifnull +8 -> 257
    //   252: aload 5
    //   254: invokevirtual 233	java/io/ByteArrayInputStream:close	()V
    //   257: aconst_null
    //   258: areturn
    //   259: aload 5
    //   261: astore_1
    //   262: new 28	android/util/Pair
    //   265: dup
    //   266: iload_3
    //   267: invokestatic 227	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   270: aload 6
    //   272: invokespecial 230	android/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   275: astore 6
    //   277: aload 6
    //   279: astore_1
    //   280: aload 5
    //   282: ifnull -191 -> 91
    //   285: aload 5
    //   287: invokevirtual 233	java/io/ByteArrayInputStream:close	()V
    //   290: aload 6
    //   292: areturn
    //   293: astore_1
    //   294: aload_1
    //   295: invokevirtual 234	java/io/IOException:printStackTrace	()V
    //   298: aload 6
    //   300: areturn
    //   301: astore_1
    //   302: aload_1
    //   303: invokevirtual 234	java/io/IOException:printStackTrace	()V
    //   306: goto -49 -> 257
    //   309: astore 5
    //   311: aconst_null
    //   312: astore_1
    //   313: aload_1
    //   314: ifnull +7 -> 321
    //   317: aload_1
    //   318: invokevirtual 233	java/io/ByteArrayInputStream:close	()V
    //   321: aload 5
    //   323: athrow
    //   324: astore_1
    //   325: aload_1
    //   326: invokevirtual 234	java/io/IOException:printStackTrace	()V
    //   329: goto -8 -> 321
    //   332: astore 5
    //   334: goto -21 -> 313
    //   337: astore 6
    //   339: aconst_null
    //   340: astore 5
    //   342: goto -103 -> 239
    //   345: iload_2
    //   346: iconst_1
    //   347: iadd
    //   348: istore_2
    //   349: goto -210 -> 139
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	352	0	this	asyx
    //   0	352	1	paramArrayOfByte	byte[]
    //   0	352	2	paramInt	int
    //   48	219	3	i	int
    //   135	8	4	j	int
    //   3	283	5	localObject1	Object
    //   309	13	5	localObject2	Object
    //   332	1	5	localObject3	Object
    //   340	1	5	localObject4	Object
    //   10	215	6	localObject5	Object
    //   237	34	6	localException1	Exception
    //   275	24	6	localPair	Pair
    //   337	1	6	localException2	Exception
    //   37	112	7	localObject6	Object
    //   156	71	8	localObject7	Object
    //   185	11	9	str	String
    // Exception table:
    //   from	to	target	type
    //   83	88	93	java/io/IOException
    //   25	39	237	java/lang/Exception
    //   42	49	237	java/lang/Exception
    //   61	75	237	java/lang/Exception
    //   104	113	237	java/lang/Exception
    //   116	125	237	java/lang/Exception
    //   128	137	237	java/lang/Exception
    //   148	158	237	java/lang/Exception
    //   161	172	237	java/lang/Exception
    //   178	187	237	java/lang/Exception
    //   195	205	237	java/lang/Exception
    //   208	216	237	java/lang/Exception
    //   224	234	237	java/lang/Exception
    //   262	277	237	java/lang/Exception
    //   285	290	293	java/io/IOException
    //   252	257	301	java/io/IOException
    //   5	22	309	finally
    //   317	321	324	java/io/IOException
    //   25	39	332	finally
    //   42	49	332	finally
    //   61	75	332	finally
    //   104	113	332	finally
    //   116	125	332	finally
    //   128	137	332	finally
    //   148	158	332	finally
    //   161	172	332	finally
    //   178	187	332	finally
    //   195	205	332	finally
    //   208	216	332	finally
    //   224	234	332	finally
    //   242	247	332	finally
    //   262	277	332	finally
    //   5	22	337	java/lang/Exception
  }
  
  /* Error */
  private byte[] b(int paramInt, List<asyx.a> paramList)
  {
    // Byte code:
    //   0: invokestatic 252	android/util/Xml:newSerializer	()Lorg/xmlpull/v1/XmlSerializer;
    //   3: astore 5
    //   5: new 254	java/io/ByteArrayOutputStream
    //   8: dup
    //   9: invokespecial 255	java/io/ByteArrayOutputStream:<init>	()V
    //   12: astore 4
    //   14: aload 4
    //   16: astore_3
    //   17: aload 5
    //   19: aload 4
    //   21: ldc_w 257
    //   24: invokeinterface 263 3 0
    //   29: aload 4
    //   31: astore_3
    //   32: aload 5
    //   34: aconst_null
    //   35: iconst_1
    //   36: invokestatic 268	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   39: invokeinterface 272 3 0
    //   44: aload 4
    //   46: astore_3
    //   47: aload 5
    //   49: aconst_null
    //   50: ldc_w 274
    //   53: invokeinterface 278 3 0
    //   58: pop
    //   59: aload 4
    //   61: astore_3
    //   62: aload 5
    //   64: aconst_null
    //   65: ldc 191
    //   67: iload_1
    //   68: invokestatic 281	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   71: invokeinterface 285 4 0
    //   76: pop
    //   77: aload 4
    //   79: astore_3
    //   80: aload_2
    //   81: invokeinterface 126 1 0
    //   86: astore_2
    //   87: aload 4
    //   89: astore_3
    //   90: aload_2
    //   91: invokeinterface 132 1 0
    //   96: ifeq +178 -> 274
    //   99: aload 4
    //   101: astore_3
    //   102: aload_2
    //   103: invokeinterface 136 1 0
    //   108: checkcast 6	asyx$a
    //   111: astore 6
    //   113: aload 4
    //   115: astore_3
    //   116: aload 5
    //   118: aconst_null
    //   119: ldc 237
    //   121: invokeinterface 278 3 0
    //   126: pop
    //   127: aload 4
    //   129: astore_3
    //   130: aload 5
    //   132: aconst_null
    //   133: ldc 148
    //   135: aload 6
    //   137: getfield 139	asyx$a:eok	I
    //   140: invokestatic 281	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   143: invokeinterface 285 4 0
    //   148: pop
    //   149: aload 4
    //   151: astore_3
    //   152: aload 5
    //   154: aconst_null
    //   155: ldc 160
    //   157: aload 6
    //   159: getfield 163	asyx$a:mLibType	I
    //   162: invokestatic 281	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   165: invokeinterface 285 4 0
    //   170: pop
    //   171: aload 4
    //   173: astore_3
    //   174: aload 5
    //   176: aconst_null
    //   177: ldc 165
    //   179: aload 6
    //   181: getfield 168	asyx$a:eol	I
    //   184: invokestatic 281	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   187: invokeinterface 285 4 0
    //   192: pop
    //   193: aload 4
    //   195: astore_3
    //   196: aload 5
    //   198: aconst_null
    //   199: ldc 175
    //   201: aload 6
    //   203: getfield 178	asyx$a:cGj	Ljava/lang/String;
    //   206: invokeinterface 285 4 0
    //   211: pop
    //   212: aload 4
    //   214: astore_3
    //   215: aload 5
    //   217: aconst_null
    //   218: ldc 170
    //   220: aload 6
    //   222: getfield 173	asyx$a:cGk	Ljava/lang/String;
    //   225: invokeinterface 285 4 0
    //   230: pop
    //   231: aload 4
    //   233: astore_3
    //   234: aload 5
    //   236: aconst_null
    //   237: ldc 237
    //   239: invokeinterface 288 3 0
    //   244: pop
    //   245: goto -158 -> 87
    //   248: astore_3
    //   249: aload 4
    //   251: astore_2
    //   252: aload_3
    //   253: astore 4
    //   255: aload_2
    //   256: astore_3
    //   257: aload 4
    //   259: invokevirtual 121	java/lang/Exception:printStackTrace	()V
    //   262: aload_2
    //   263: ifnull +7 -> 270
    //   266: aload_2
    //   267: invokevirtual 289	java/io/ByteArrayOutputStream:close	()V
    //   270: aconst_null
    //   271: astore_3
    //   272: aload_3
    //   273: areturn
    //   274: aload 4
    //   276: astore_3
    //   277: aload 5
    //   279: aconst_null
    //   280: ldc_w 274
    //   283: invokeinterface 288 3 0
    //   288: pop
    //   289: aload 4
    //   291: astore_3
    //   292: aload 5
    //   294: invokeinterface 292 1 0
    //   299: aload 4
    //   301: astore_3
    //   302: aload 4
    //   304: invokevirtual 296	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   307: astore_2
    //   308: aload_2
    //   309: astore_3
    //   310: aload 4
    //   312: ifnull -40 -> 272
    //   315: aload 4
    //   317: invokevirtual 289	java/io/ByteArrayOutputStream:close	()V
    //   320: aload_2
    //   321: areturn
    //   322: astore_3
    //   323: aload_3
    //   324: invokevirtual 234	java/io/IOException:printStackTrace	()V
    //   327: aload_2
    //   328: areturn
    //   329: astore_2
    //   330: aload_2
    //   331: invokevirtual 234	java/io/IOException:printStackTrace	()V
    //   334: goto -64 -> 270
    //   337: astore_2
    //   338: aconst_null
    //   339: astore_3
    //   340: aload_3
    //   341: ifnull +7 -> 348
    //   344: aload_3
    //   345: invokevirtual 289	java/io/ByteArrayOutputStream:close	()V
    //   348: aload_2
    //   349: athrow
    //   350: astore_3
    //   351: aload_3
    //   352: invokevirtual 234	java/io/IOException:printStackTrace	()V
    //   355: goto -7 -> 348
    //   358: astore_2
    //   359: goto -19 -> 340
    //   362: astore 4
    //   364: aconst_null
    //   365: astore_2
    //   366: goto -111 -> 255
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	369	0	this	asyx
    //   0	369	1	paramInt	int
    //   0	369	2	paramList	List<asyx.a>
    //   16	218	3	localObject1	Object
    //   248	5	3	localException1	Exception
    //   256	54	3	localObject2	Object
    //   322	2	3	localIOException1	java.io.IOException
    //   339	6	3	localObject3	Object
    //   350	2	3	localIOException2	java.io.IOException
    //   12	304	4	localObject4	Object
    //   362	1	4	localException2	Exception
    //   3	290	5	localXmlSerializer	org.xmlpull.v1.XmlSerializer
    //   111	110	6	locala	asyx.a
    // Exception table:
    //   from	to	target	type
    //   17	29	248	java/lang/Exception
    //   32	44	248	java/lang/Exception
    //   47	59	248	java/lang/Exception
    //   62	77	248	java/lang/Exception
    //   80	87	248	java/lang/Exception
    //   90	99	248	java/lang/Exception
    //   102	113	248	java/lang/Exception
    //   116	127	248	java/lang/Exception
    //   130	149	248	java/lang/Exception
    //   152	171	248	java/lang/Exception
    //   174	193	248	java/lang/Exception
    //   196	212	248	java/lang/Exception
    //   215	231	248	java/lang/Exception
    //   234	245	248	java/lang/Exception
    //   277	289	248	java/lang/Exception
    //   292	299	248	java/lang/Exception
    //   302	308	248	java/lang/Exception
    //   315	320	322	java/io/IOException
    //   266	270	329	java/io/IOException
    //   0	14	337	finally
    //   344	348	350	java/io/IOException
    //   17	29	358	finally
    //   32	44	358	finally
    //   47	59	358	finally
    //   62	77	358	finally
    //   80	87	358	finally
    //   90	99	358	finally
    //   102	113	358	finally
    //   116	127	358	finally
    //   130	149	358	finally
    //   152	171	358	finally
    //   174	193	358	finally
    //   196	212	358	finally
    //   215	231	358	finally
    //   234	245	358	finally
    //   257	262	358	finally
    //   277	289	358	finally
    //   292	299	358	finally
    //   302	308	358	finally
    //   0	14	362	java/lang/Exception
  }
  
  private boolean d(String paramString, int paramInt, List<asyx.a> paramList)
  {
    paramList = b(paramInt, paramList);
    if (paramList == null) {
      return false;
    }
    return new aszk().b(paramString, paramList, null, 1);
  }
  
  private Pair<Integer, List<asyx.a>> e(String paramString, int paramInt)
  {
    Object localObject = null;
    byte[] arrayOfByte = new aszk().b(paramString, null, 1);
    paramString = localObject;
    if (arrayOfByte != null) {
      paramString = b(arrayOfByte, paramInt);
    }
    return paramString;
  }
  
  private boolean mV(int paramInt)
  {
    return a(paramInt) != null;
  }
  
  public boolean a(asyx.a parama, boolean paramBoolean)
  {
    if (mV(parama.eok)) {
      return false;
    }
    this.Kg.add(parama);
    if (paramBoolean) {
      return aIO();
    }
    return true;
  }
  
  public boolean aIO()
  {
    return d(Et(), this.mVersion, this.Kg);
  }
  
  public asyx.a b(int paramInt)
  {
    return a(paramInt);
  }
  
  public void cj(int paramInt, boolean paramBoolean)
  {
    asyx.a locala = a(paramInt);
    if (locala == null) {}
    do
    {
      return;
      this.Kg.remove(locala);
    } while (!paramBoolean);
    d(Et(), this.mVersion, this.Kg);
  }
  
  public List<asyx.a> hc()
  {
    return this.Kg;
  }
  
  public static class a
  {
    Bundle bG;
    String cGj;
    String cGk;
    int eok;
    int eol;
    int mLibType;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     asyx
 * JD-Core Version:    0.7.0.1
 */