import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.AntiFraudConfigFileUtil.1;
import com.tencent.mobileqq.utils.AntiFraudConfigFileUtil.2;
import com.tencent.mobileqq.utils.AntiFraudConfigFileUtil.4;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import mqq.os.MqqHandler;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;

public class aqfz
{
  private Bundle bs = new Bundle();
  private Bundle bt = new Bundle();
  private aclm d = new aqga(this);
  private int dZa = -1;
  
  /* Error */
  private void Uz(String paramString)
  {
    // Byte code:
    //   0: invokestatic 49	javax/xml/parsers/DocumentBuilderFactory:newInstance	()Ljavax/xml/parsers/DocumentBuilderFactory;
    //   3: astore 5
    //   5: new 51	java/io/File
    //   8: dup
    //   9: aload_1
    //   10: invokespecial 53	java/io/File:<init>	(Ljava/lang/String;)V
    //   13: astore 7
    //   15: aload 7
    //   17: invokevirtual 57	java/io/File:getName	()Ljava/lang/String;
    //   20: astore 6
    //   22: aload 6
    //   24: iconst_0
    //   25: aload 6
    //   27: ldc 59
    //   29: invokevirtual 65	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   32: invokevirtual 69	java/lang/String:substring	(II)Ljava/lang/String;
    //   35: astore 6
    //   37: aload 5
    //   39: invokevirtual 73	javax/xml/parsers/DocumentBuilderFactory:newDocumentBuilder	()Ljavax/xml/parsers/DocumentBuilder;
    //   42: aload 7
    //   44: invokevirtual 79	javax/xml/parsers/DocumentBuilder:parse	(Ljava/io/File;)Lorg/w3c/dom/Document;
    //   47: invokeinterface 85 1 0
    //   52: astore 8
    //   54: aload_0
    //   55: getfield 34	aqfz:bs	Landroid/os/Bundle;
    //   58: aload 6
    //   60: invokevirtual 89	android/os/Bundle:getBundle	(Ljava/lang/String;)Landroid/os/Bundle;
    //   63: astore 5
    //   65: aload 5
    //   67: ifnull +418 -> 485
    //   70: aload 5
    //   72: ldc 91
    //   74: invokevirtual 95	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   77: astore 5
    //   79: aload 5
    //   81: invokestatic 101	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   84: istore 4
    //   86: iload 4
    //   88: ifne +397 -> 485
    //   91: aload 5
    //   93: invokestatic 106	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   96: istore_2
    //   97: aload 8
    //   99: ldc 91
    //   101: invokeinterface 111 2 0
    //   106: astore 5
    //   108: aload 5
    //   110: invokestatic 106	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   113: istore_3
    //   114: iload_3
    //   115: iload_2
    //   116: if_icmpge +58 -> 174
    //   119: invokestatic 117	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   122: ifeq +362 -> 484
    //   125: ldc 119
    //   127: iconst_2
    //   128: new 121	java/lang/StringBuilder
    //   131: dup
    //   132: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   135: aload 6
    //   137: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: ldc 128
    //   142: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   148: invokestatic 134	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   151: return
    //   152: astore 5
    //   154: aload 5
    //   156: invokevirtual 137	java/lang/Exception:printStackTrace	()V
    //   159: goto +326 -> 485
    //   162: astore 7
    //   164: aload 7
    //   166: invokevirtual 138	java/lang/Throwable:printStackTrace	()V
    //   169: iconst_0
    //   170: istore_3
    //   171: goto -57 -> 114
    //   174: invokestatic 143	com/tencent/mqp/app/sec/ScConfigManager:a	()Lcom/tencent/mqp/app/sec/ScConfigManager;
    //   177: aload_1
    //   178: invokevirtual 147	com/tencent/mqp/app/sec/ScConfigManager:sl	(Ljava/lang/String;)Z
    //   181: ifne +303 -> 484
    //   184: new 22	android/os/Bundle
    //   187: dup
    //   188: invokespecial 23	android/os/Bundle:<init>	()V
    //   191: astore 7
    //   193: aload 5
    //   195: astore_1
    //   196: aload 5
    //   198: invokestatic 101	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   201: ifeq +8 -> 209
    //   204: iconst_0
    //   205: invokestatic 150	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   208: astore_1
    //   209: aload 7
    //   211: ldc 91
    //   213: aload_1
    //   214: invokevirtual 154	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   217: aload_0
    //   218: iload_3
    //   219: putfield 20	aqfz:dZa	I
    //   222: aload 8
    //   224: ldc 156
    //   226: invokeinterface 160 2 0
    //   231: astore_1
    //   232: iconst_0
    //   233: istore_2
    //   234: iload_2
    //   235: aload_1
    //   236: invokeinterface 166 1 0
    //   241: if_icmpge +192 -> 433
    //   244: aload_1
    //   245: iload_2
    //   246: invokeinterface 170 2 0
    //   251: checkcast 108	org/w3c/dom/Element
    //   254: astore 9
    //   256: aload 9
    //   258: ldc 172
    //   260: invokeinterface 111 2 0
    //   265: astore 5
    //   267: new 22	android/os/Bundle
    //   270: dup
    //   271: invokespecial 23	android/os/Bundle:<init>	()V
    //   274: astore 8
    //   276: aload 9
    //   278: ldc 174
    //   280: invokeinterface 160 2 0
    //   285: astore 10
    //   287: iconst_0
    //   288: istore_3
    //   289: iload_3
    //   290: aload 10
    //   292: invokeinterface 166 1 0
    //   297: if_icmpge +58 -> 355
    //   300: aload 10
    //   302: iload_3
    //   303: invokeinterface 170 2 0
    //   308: checkcast 108	org/w3c/dom/Element
    //   311: astore 11
    //   313: new 22	android/os/Bundle
    //   316: dup
    //   317: invokespecial 23	android/os/Bundle:<init>	()V
    //   320: astore 12
    //   322: aload_0
    //   323: aload 12
    //   325: aload 5
    //   327: aload 11
    //   329: invokespecial 177	aqfz:a	(Landroid/os/Bundle;Ljava/lang/String;Lorg/w3c/dom/Element;)V
    //   332: aload 8
    //   334: aload 11
    //   336: ldc 179
    //   338: invokeinterface 111 2 0
    //   343: aload 12
    //   345: invokevirtual 183	android/os/Bundle:putBundle	(Ljava/lang/String;Landroid/os/Bundle;)V
    //   348: iload_3
    //   349: iconst_1
    //   350: iadd
    //   351: istore_3
    //   352: goto -63 -> 289
    //   355: aload 9
    //   357: ldc 185
    //   359: invokeinterface 160 2 0
    //   364: astore 9
    //   366: aload 9
    //   368: invokeinterface 166 1 0
    //   373: ifle +44 -> 417
    //   376: aload 9
    //   378: iconst_0
    //   379: invokeinterface 170 2 0
    //   384: checkcast 108	org/w3c/dom/Element
    //   387: astore 9
    //   389: new 22	android/os/Bundle
    //   392: dup
    //   393: invokespecial 23	android/os/Bundle:<init>	()V
    //   396: astore 10
    //   398: aload_0
    //   399: aload 10
    //   401: aload 5
    //   403: aload 9
    //   405: invokespecial 177	aqfz:a	(Landroid/os/Bundle;Ljava/lang/String;Lorg/w3c/dom/Element;)V
    //   408: aload 8
    //   410: ldc 185
    //   412: aload 10
    //   414: invokevirtual 183	android/os/Bundle:putBundle	(Ljava/lang/String;Landroid/os/Bundle;)V
    //   417: aload 7
    //   419: aload 5
    //   421: aload 8
    //   423: invokevirtual 183	android/os/Bundle:putBundle	(Ljava/lang/String;Landroid/os/Bundle;)V
    //   426: iload_2
    //   427: iconst_1
    //   428: iadd
    //   429: istore_2
    //   430: goto -196 -> 234
    //   433: aload_0
    //   434: getfield 34	aqfz:bs	Landroid/os/Bundle;
    //   437: aload 6
    //   439: aload 7
    //   441: invokevirtual 183	android/os/Bundle:putBundle	(Ljava/lang/String;Landroid/os/Bundle;)V
    //   444: return
    //   445: astore_1
    //   446: invokestatic 117	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   449: ifeq +31 -> 480
    //   452: ldc 119
    //   454: iconst_2
    //   455: new 121	java/lang/StringBuilder
    //   458: dup
    //   459: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   462: ldc 187
    //   464: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   467: aload_1
    //   468: invokevirtual 190	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   471: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   474: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   477: invokestatic 134	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   480: aload_1
    //   481: invokevirtual 137	java/lang/Exception:printStackTrace	()V
    //   484: return
    //   485: iconst_0
    //   486: istore_2
    //   487: goto -390 -> 97
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	490	0	this	aqfz
    //   0	490	1	paramString	String
    //   96	391	2	i	int
    //   113	239	3	j	int
    //   84	3	4	bool	boolean
    //   3	106	5	localObject1	Object
    //   152	45	5	localException	Exception
    //   265	155	5	str1	String
    //   20	418	6	str2	String
    //   13	30	7	localFile	File
    //   162	3	7	localThrowable	Throwable
    //   191	249	7	localBundle1	Bundle
    //   52	370	8	localObject2	Object
    //   254	150	9	localObject3	Object
    //   285	128	10	localObject4	Object
    //   311	24	11	localElement	Element
    //   320	24	12	localBundle2	Bundle
    // Exception table:
    //   from	to	target	type
    //   91	97	152	java/lang/Exception
    //   108	114	162	java/lang/Throwable
    //   5	65	445	java/lang/Exception
    //   70	86	445	java/lang/Exception
    //   97	108	445	java/lang/Exception
    //   108	114	445	java/lang/Exception
    //   119	151	445	java/lang/Exception
    //   154	159	445	java/lang/Exception
    //   164	169	445	java/lang/Exception
    //   174	193	445	java/lang/Exception
    //   196	209	445	java/lang/Exception
    //   209	232	445	java/lang/Exception
    //   234	287	445	java/lang/Exception
    //   289	348	445	java/lang/Exception
    //   355	417	445	java/lang/Exception
    //   417	426	445	java/lang/Exception
    //   433	444	445	java/lang/Exception
  }
  
  public static aqfz a()
  {
    return aqfz.a.a;
  }
  
  private void a(Bundle paramBundle, String paramString, Element paramElement)
  {
    try
    {
      i = Integer.parseInt(paramString);
      if ((i == 1) || (i == 2))
      {
        localObject1 = paramElement.getElementsByTagName("TailWording");
        if (((NodeList)localObject1).getLength() > 0)
        {
          localObject2 = new Bundle();
          i = 0;
          while (i < ((NodeList)localObject1).getLength())
          {
            localObject3 = (Element)((NodeList)localObject1).item(i);
            str = ((Element)localObject3).getAttribute("Status");
            paramString = str;
            if (TextUtils.isEmpty(str)) {
              paramString = "0";
            }
            ((Bundle)localObject2).putString(paramString, ((Element)localObject3).getTextContent());
            i += 1;
          }
        }
      }
    }
    catch (Exception paramString)
    {
      int i;
      Object localObject1;
      Object localObject2;
      Object localObject3;
      String str;
      for (;;)
      {
        paramString.printStackTrace();
        i = 0;
      }
      paramBundle.putBundle("TailWording", (Bundle)localObject2);
      paramString = paramElement.getElementsByTagName("Action");
      if (paramString.getLength() > 0)
      {
        paramElement = new Bundle();
        i = 0;
        while (i < paramString.getLength())
        {
          localObject2 = (Element)paramString.item(i);
          str = ((Element)localObject2).getAttribute("PlaceHolder");
          if (TextUtils.isEmpty(str))
          {
            i += 1;
          }
          else
          {
            localObject1 = new Bundle();
            localObject3 = ((Element)localObject2).getAttribute("Type");
            ((Bundle)localObject1).putString("Type", (String)localObject3);
            ((Bundle)localObject1).putString("Name", ((Element)localObject2).getAttribute("Name"));
            if (((String)localObject3).equalsIgnoreCase("openURL")) {
              a((Bundle)localObject1, (Element)localObject2);
            }
            for (;;)
            {
              paramElement.putBundle(str, (Bundle)localObject1);
              break;
              localObject3 = ((Element)localObject2).getElementsByTagName("AlertTitle");
              if (((NodeList)localObject3).getLength() > 0) {
                a((Bundle)localObject1, (Element)((NodeList)localObject3).item(0));
              }
              localObject3 = ((Element)localObject2).getElementsByTagName("AlertText");
              if (((NodeList)localObject3).getLength() > 0) {
                a((Bundle)localObject1, (Element)((NodeList)localObject3).item(0));
              }
              localObject3 = ((Element)localObject2).getElementsByTagName("AlertOtherBtnText");
              if (((NodeList)localObject3).getLength() > 0) {
                a((Bundle)localObject1, (Element)((NodeList)localObject3).item(0));
              }
              localObject2 = ((Element)localObject2).getElementsByTagName("AlertCancelBtnText");
              if (((NodeList)localObject2).getLength() > 0) {
                a((Bundle)localObject1, (Element)((NodeList)localObject2).item(0));
              }
            }
          }
        }
        paramBundle.putBundle("Action", paramElement);
      }
    }
    for (;;)
    {
      return;
      for (paramString = paramElement.getFirstChild(); paramString != null; paramString = paramString.getNextSibling()) {
        if ((paramString instanceof Element))
        {
          paramElement = new Bundle();
          a(paramElement, (Element)paramString);
          paramBundle.putBundle(paramString.getNodeName(), paramElement);
        }
      }
    }
  }
  
  private void a(Bundle paramBundle, Element paramElement)
  {
    String str = paramElement.getNodeName();
    paramElement = paramElement.getFirstChild();
    Object localObject2;
    for (Object localObject1 = ""; paramElement != null; localObject1 = localObject2)
    {
      localObject2 = localObject1;
      if ((paramElement instanceof Text)) {
        localObject2 = (String)localObject1 + paramElement.getNodeValue();
      }
      paramElement = paramElement.getNextSibling();
    }
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {
      paramBundle.putString(str, (String)localObject1);
    }
  }
  
  private void parse(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("UinSafety.WordingConfigFileUtil", 2, "parse config file:" + paramString);
    }
    paramString = pn(paramString);
    if (paramString != null) {
      Uz(paramString);
    }
  }
  
  public Object a(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    ThreadManager.getFileThreadHandler().post(new AntiFraudConfigFileUtil.2(this, paramString1));
    Bundle localBundle1 = null;
    Bundle localBundle2 = this.bs.getBundle(paramString1);
    paramString1 = localBundle1;
    if (localBundle2 != null)
    {
      localBundle2 = localBundle2.getBundle(Integer.toString(paramInt1));
      paramString1 = localBundle1;
      if (localBundle2 != null)
      {
        Bundle localBundle3 = localBundle2.getBundle(Integer.toString(paramInt2));
        paramString1 = localBundle1;
        if (localBundle3 != null)
        {
          localBundle1 = localBundle3.getBundle(paramString2);
          paramString1 = localBundle1;
          if (localBundle1 == null)
          {
            localBundle2 = localBundle2.getBundle("PublicElement");
            paramString1 = localBundle1;
            if (localBundle2 != null) {
              paramString1 = localBundle2.getBundle(paramString2);
            }
          }
        }
      }
    }
    return paramString1;
  }
  
  public long aX(String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext()).getLong(paramString + "_" + "LastModifiedTime", 0L);
  }
  
  public long aY(String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext()).getLong(paramString + "_" + "EffectTime", 0L);
  }
  
  public void bf(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (paramQQAppInterface == null) {}
    long l1;
    long l2;
    do
    {
      return;
      paramQQAppInterface.addObserver(this.d);
      l1 = aX(paramString);
      l2 = aY(paramString);
    } while (System.currentTimeMillis() - l1 < l2 * 1000L);
    acll localacll = (acll)paramQQAppInterface.getBusinessHandler(34);
    paramQQAppInterface = paramString;
    if (TextUtils.equals(paramString, "SensMsgTipsCfg")) {
      paramQQAppInterface = "SenstiveMessageTipsCfg";
    }
    localacll.EQ(paramQQAppInterface);
  }
  
  public void bh(String paramString1, String paramString2, String paramString3)
  {
    int i = this.bt.getInt(paramString2, 0);
    if ((i == 1) || (i == 3)) {
      return;
    }
    try
    {
      this.bt.putInt(paramString2, 1);
      ThreadManager.post(new AntiFraudConfigFileUtil.4(this, paramString1, paramString3, paramString2), 5, null, false);
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        localThrowable.printStackTrace();
      }
    }
  }
  
  public void bk(String paramString, long paramLong)
  {
    SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext()).edit();
    localEditor.putLong(paramString + "_" + "LastModifiedTime", paramLong);
    localEditor.commit();
  }
  
  public void bl(String paramString, long paramLong)
  {
    SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext()).edit();
    localEditor.putLong(paramString + "_" + "EffectTime", paramLong);
    localEditor.commit();
  }
  
  /* Error */
  public void f(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 11
    //   3: aconst_null
    //   4: astore 12
    //   6: aconst_null
    //   7: astore 13
    //   9: aload_1
    //   10: ifnull +11 -> 21
    //   13: aload_1
    //   14: aload_0
    //   15: getfield 32	aqfz:d	Laclm;
    //   18: invokevirtual 310	com/tencent/mobileqq/app/QQAppInterface:addObserver	(Lacci;)V
    //   21: aload_2
    //   22: invokestatic 101	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   25: ifeq +4 -> 29
    //   28: return
    //   29: aload_2
    //   30: ldc_w 379
    //   33: invokevirtual 216	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   36: ifeq +51 -> 87
    //   39: aload_0
    //   40: aload_2
    //   41: invokevirtual 312	aqfz:aX	(Ljava/lang/String;)J
    //   44: lstore 6
    //   46: aload_0
    //   47: aload_2
    //   48: invokevirtual 314	aqfz:aY	(Ljava/lang/String;)J
    //   51: lstore 8
    //   53: aload_1
    //   54: ifnull -26 -> 28
    //   57: invokestatic 320	java/lang/System:currentTimeMillis	()J
    //   60: lload 6
    //   62: lsub
    //   63: lload 8
    //   65: ldc2_w 321
    //   68: lmul
    //   69: lcmp
    //   70: iflt -42 -> 28
    //   73: aload_1
    //   74: bipush 34
    //   76: invokevirtual 326	com/tencent/mobileqq/app/QQAppInterface:getBusinessHandler	(I)Laccg;
    //   79: checkcast 328	acll
    //   82: aload_2
    //   83: invokevirtual 339	acll:EQ	(Ljava/lang/String;)V
    //   86: return
    //   87: aload_2
    //   88: ldc_w 330
    //   91: invokevirtual 216	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   94: ifeq -66 -> 28
    //   97: aload_0
    //   98: aload_2
    //   99: invokevirtual 382	aqfz:po	(Ljava/lang/String;)Ljava/lang/String;
    //   102: astore 14
    //   104: aload_0
    //   105: ldc_w 330
    //   108: invokevirtual 258	aqfz:pn	(Ljava/lang/String;)Ljava/lang/String;
    //   111: astore 15
    //   113: aload 14
    //   115: invokestatic 101	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   118: istore 10
    //   120: aload_0
    //   121: getfield 20	aqfz:dZa	I
    //   124: iconst_m1
    //   125: if_icmpne +21 -> 146
    //   128: aload 14
    //   130: invokestatic 101	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   133: ifne +13 -> 146
    //   136: aload_0
    //   137: aload_0
    //   138: aload 15
    //   140: invokevirtual 385	aqfz:fd	(Ljava/lang/String;)I
    //   143: putfield 20	aqfz:dZa	I
    //   146: aload_0
    //   147: getfield 20	aqfz:dZa	I
    //   150: iconst_2
    //   151: if_icmpge +6 -> 157
    //   154: iconst_1
    //   155: istore 10
    //   157: aload 14
    //   159: astore_1
    //   160: iload 10
    //   162: ifeq +135 -> 297
    //   165: invokestatic 283	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   168: invokevirtual 389	com/tencent/qphone/base/util/BaseApplication:getAssets	()Landroid/content/res/AssetManager;
    //   171: ldc_w 391
    //   174: invokevirtual 397	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   177: astore_1
    //   178: aload_1
    //   179: astore_2
    //   180: aload 12
    //   182: astore 11
    //   184: new 399	java/io/FileOutputStream
    //   187: dup
    //   188: aload 15
    //   190: invokespecial 400	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   193: astore 12
    //   195: sipush 4096
    //   198: newarray byte
    //   200: astore_2
    //   201: aload_1
    //   202: aload_2
    //   203: invokevirtual 406	java/io/InputStream:read	([B)I
    //   206: istore 5
    //   208: iload 5
    //   210: ifle +114 -> 324
    //   213: aload 12
    //   215: aload_2
    //   216: iconst_0
    //   217: iload 5
    //   219: invokevirtual 412	java/io/OutputStream:write	([BII)V
    //   222: goto -21 -> 201
    //   225: astore_2
    //   226: aload 12
    //   228: astore 13
    //   230: aload_2
    //   231: astore 12
    //   233: aload_1
    //   234: astore_2
    //   235: aload 13
    //   237: astore 11
    //   239: aload 12
    //   241: invokevirtual 137	java/lang/Exception:printStackTrace	()V
    //   244: aload_1
    //   245: ifnull +7 -> 252
    //   248: aload_1
    //   249: invokevirtual 415	java/io/InputStream:close	()V
    //   252: aload 13
    //   254: ifnull +8 -> 262
    //   257: aload 13
    //   259: invokevirtual 416	java/io/OutputStream:close	()V
    //   262: aload 14
    //   264: astore_1
    //   265: aload 15
    //   267: invokestatic 421	ahbj:isFileExists	(Ljava/lang/String;)Z
    //   270: ifeq +27 -> 297
    //   273: aload 15
    //   275: invokestatic 426	com/tencent/mobileqq/utils/SecUtil:getFileMd5	(Ljava/lang/String;)Ljava/lang/String;
    //   278: astore_1
    //   279: aload_0
    //   280: ldc_w 330
    //   283: aload_1
    //   284: invokevirtual 429	aqfz:ij	(Ljava/lang/String;Ljava/lang/String;)V
    //   287: aload_0
    //   288: aload_0
    //   289: aload 15
    //   291: invokevirtual 385	aqfz:fd	(Ljava/lang/String;)I
    //   294: putfield 20	aqfz:dZa	I
    //   297: aload_1
    //   298: aload 4
    //   300: invokestatic 334	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   303: ifne -275 -> 28
    //   306: aload_3
    //   307: invokestatic 101	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   310: ifne -282 -> 28
    //   313: aload_0
    //   314: ldc_w 330
    //   317: aload 4
    //   319: aload_3
    //   320: invokevirtual 431	aqfz:bh	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   323: return
    //   324: aload_1
    //   325: ifnull +7 -> 332
    //   328: aload_1
    //   329: invokevirtual 415	java/io/InputStream:close	()V
    //   332: aload 12
    //   334: ifnull -72 -> 262
    //   337: aload 12
    //   339: invokevirtual 416	java/io/OutputStream:close	()V
    //   342: goto -80 -> 262
    //   345: astore_1
    //   346: aload_1
    //   347: invokevirtual 432	java/io/IOException:printStackTrace	()V
    //   350: goto -88 -> 262
    //   353: astore_1
    //   354: aload_1
    //   355: invokevirtual 432	java/io/IOException:printStackTrace	()V
    //   358: goto -96 -> 262
    //   361: astore_3
    //   362: aconst_null
    //   363: astore_1
    //   364: aload_1
    //   365: ifnull +7 -> 372
    //   368: aload_1
    //   369: invokevirtual 415	java/io/InputStream:close	()V
    //   372: aload 11
    //   374: ifnull +8 -> 382
    //   377: aload 11
    //   379: invokevirtual 416	java/io/OutputStream:close	()V
    //   382: aload_3
    //   383: athrow
    //   384: astore_1
    //   385: aload_1
    //   386: invokevirtual 432	java/io/IOException:printStackTrace	()V
    //   389: goto -7 -> 382
    //   392: astore_3
    //   393: aload_2
    //   394: astore_1
    //   395: goto -31 -> 364
    //   398: astore_3
    //   399: aload 12
    //   401: astore 11
    //   403: goto -39 -> 364
    //   406: astore 12
    //   408: aconst_null
    //   409: astore_1
    //   410: goto -177 -> 233
    //   413: astore 12
    //   415: goto -182 -> 233
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	418	0	this	aqfz
    //   0	418	1	paramQQAppInterface	QQAppInterface
    //   0	418	2	paramString1	String
    //   0	418	3	paramString2	String
    //   0	418	4	paramString3	String
    //   206	12	5	i	int
    //   44	17	6	l1	long
    //   51	13	8	l2	long
    //   118	43	10	bool	boolean
    //   1	401	11	localObject1	Object
    //   4	396	12	localObject2	Object
    //   406	1	12	localException1	Exception
    //   413	1	12	localException2	Exception
    //   7	251	13	localObject3	Object
    //   102	161	14	str1	String
    //   111	179	15	str2	String
    // Exception table:
    //   from	to	target	type
    //   195	201	225	java/lang/Exception
    //   201	208	225	java/lang/Exception
    //   213	222	225	java/lang/Exception
    //   328	332	345	java/io/IOException
    //   337	342	345	java/io/IOException
    //   248	252	353	java/io/IOException
    //   257	262	353	java/io/IOException
    //   165	178	361	finally
    //   368	372	384	java/io/IOException
    //   377	382	384	java/io/IOException
    //   184	195	392	finally
    //   239	244	392	finally
    //   195	201	398	finally
    //   201	208	398	finally
    //   213	222	398	finally
    //   165	178	406	java/lang/Exception
    //   184	195	413	java/lang/Exception
  }
  
  public int fd(String paramString)
  {
    DocumentBuilderFactory localDocumentBuilderFactory = DocumentBuilderFactory.newInstance();
    try
    {
      paramString = new File(paramString);
      String str = paramString.getName();
      str.substring(0, str.lastIndexOf("."));
      paramString = localDocumentBuilderFactory.newDocumentBuilder().parse(paramString).getDocumentElement().getAttribute("Version");
      try
      {
        int i = Integer.parseInt(paramString);
        return i;
      }
      catch (Throwable paramString)
      {
        paramString.printStackTrace();
        return -1;
      }
      return -1;
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d("UinSafety.WordingConfigFileUtil", 2, "exception occurred." + paramString.getMessage());
      }
      paramString.printStackTrace();
    }
  }
  
  public String getAttribute(String paramString1, String paramString2)
  {
    Object localObject = paramString1;
    if (!TextUtils.isEmpty(paramString1))
    {
      localObject = paramString1;
      if (TextUtils.equals("SenstiveMessageTipsCfg", paramString1)) {
        localObject = "SensMsgTipsCfg";
      }
    }
    ThreadManager.getFileThreadHandler().post(new AntiFraudConfigFileUtil.1(this, (String)localObject));
    paramString1 = null;
    localObject = this.bs.getBundle((String)localObject);
    if (localObject != null) {
      paramString1 = ((Bundle)localObject).getString(paramString2);
    }
    return paramString1;
  }
  
  public void ij(String paramString1, String paramString2)
  {
    SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext()).edit();
    localEditor.putString(paramString1 + "_" + "MD5", paramString2);
    localEditor.commit();
  }
  
  public String pn(String paramString)
  {
    return BaseApplication.getContext().getFilesDir().getPath() + "/" + paramString + ".xml";
  }
  
  public String po(String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext()).getString(paramString + "_" + "MD5", null);
  }
  
  static class a
  {
    static aqfz a = new aqfz(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqfz
 * JD-Core Version:    0.7.0.1
 */