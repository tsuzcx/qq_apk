package com.alibaba.fastjson.parser;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONType;
import com.alibaba.fastjson.parser.deserializer.ExtraProcessable;
import com.alibaba.fastjson.parser.deserializer.ExtraProcessor;
import com.alibaba.fastjson.parser.deserializer.ExtraTypeProvider;
import com.alibaba.fastjson.parser.deserializer.FieldDeserializer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.util.FieldInfo;
import com.alibaba.fastjson.util.TypeUtils;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class JavaBeanDeserializer
  implements ObjectDeserializer
{
  public final JavaBeanInfo beanInfo;
  private final Class<?> clazz;
  private ConcurrentMap<String, Object> extraFieldDeserializers;
  private final FieldDeserializer[] fieldDeserializers;
  private final FieldDeserializer[] sortedFieldDeserializers;
  
  public JavaBeanDeserializer(ParserConfig paramParserConfig, Class<?> paramClass, Type paramType)
  {
    this(paramParserConfig, paramClass, paramType, JavaBeanInfo.build(paramClass, paramClass.getModifiers(), paramType, false, true, true, true, paramParserConfig.propertyNamingStrategy));
  }
  
  public JavaBeanDeserializer(ParserConfig paramParserConfig, Class<?> paramClass, Type paramType, JavaBeanInfo paramJavaBeanInfo)
  {
    this.clazz = paramClass;
    this.beanInfo = paramJavaBeanInfo;
    this.sortedFieldDeserializers = new FieldDeserializer[paramJavaBeanInfo.sortedFields.length];
    int k = paramJavaBeanInfo.sortedFields.length;
    int i = 0;
    while (i < k)
    {
      paramType = paramParserConfig.createFieldDeserializer(paramParserConfig, paramClass, paramJavaBeanInfo.sortedFields[i]);
      this.sortedFieldDeserializers[i] = paramType;
      i += 1;
    }
    this.fieldDeserializers = new FieldDeserializer[paramJavaBeanInfo.fields.length];
    k = paramJavaBeanInfo.fields.length;
    i = j;
    while (i < k)
    {
      paramParserConfig = getFieldDeserializer(paramJavaBeanInfo.fields[i].name);
      this.fieldDeserializers[i] = paramParserConfig;
      i += 1;
    }
  }
  
  /* Error */
  private <T> T deserialze(DefaultJSONParser paramDefaultJSONParser, Type paramType, Object paramObject1, Object paramObject2)
  {
    // Byte code:
    //   0: aload_2
    //   1: ldc 86
    //   3: if_acmpeq +9 -> 12
    //   6: aload_2
    //   7: ldc 88
    //   9: if_acmpne +8 -> 17
    //   12: aload_1
    //   13: invokevirtual 94	com/alibaba/fastjson/parser/DefaultJSONParser:parse	()Ljava/lang/Object;
    //   16: areturn
    //   17: aload_1
    //   18: getfield 98	com/alibaba/fastjson/parser/DefaultJSONParser:lexer	Lcom/alibaba/fastjson/parser/JSONLexer;
    //   21: astore 32
    //   23: aload 32
    //   25: getfield 104	com/alibaba/fastjson/parser/JSONLexer:token	I
    //   28: istore 12
    //   30: iload 12
    //   32: bipush 8
    //   34: if_icmpne +12 -> 46
    //   37: aload 32
    //   39: bipush 16
    //   41: invokevirtual 108	com/alibaba/fastjson/parser/JSONLexer:nextToken	(I)V
    //   44: aconst_null
    //   45: areturn
    //   46: aload 32
    //   48: getfield 112	com/alibaba/fastjson/parser/JSONLexer:disableCircularReferenceDetect	Z
    //   51: istore 21
    //   53: aload_1
    //   54: getfield 116	com/alibaba/fastjson/parser/DefaultJSONParser:contex	Lcom/alibaba/fastjson/parser/ParseContext;
    //   57: astore 26
    //   59: aload 4
    //   61: ifnull +3444 -> 3505
    //   64: aload 26
    //   66: ifnull +3439 -> 3505
    //   69: aload 26
    //   71: getfield 121	com/alibaba/fastjson/parser/ParseContext:parent	Lcom/alibaba/fastjson/parser/ParseContext;
    //   74: astore 26
    //   76: aconst_null
    //   77: astore 25
    //   79: aconst_null
    //   80: astore 22
    //   82: aconst_null
    //   83: astore 24
    //   85: iload 12
    //   87: bipush 13
    //   89: if_icmpne +37 -> 126
    //   92: aload 32
    //   94: bipush 16
    //   96: invokevirtual 108	com/alibaba/fastjson/parser/JSONLexer:nextToken	(I)V
    //   99: aload 4
    //   101: astore_3
    //   102: aload 4
    //   104: ifnonnull +10 -> 114
    //   107: aload_0
    //   108: aload_1
    //   109: aload_2
    //   110: invokevirtual 125	com/alibaba/fastjson/parser/JavaBeanDeserializer:createInstance	(Lcom/alibaba/fastjson/parser/DefaultJSONParser;Ljava/lang/reflect/Type;)Ljava/lang/Object;
    //   113: astore_3
    //   114: iconst_0
    //   115: ifeq +3 -> 118
    //   118: aload_1
    //   119: aload 26
    //   121: invokevirtual 129	com/alibaba/fastjson/parser/DefaultJSONParser:setContext	(Lcom/alibaba/fastjson/parser/ParseContext;)V
    //   124: aload_3
    //   125: areturn
    //   126: iload 12
    //   128: bipush 14
    //   130: if_icmpne +64 -> 194
    //   133: aload_0
    //   134: getfield 50	com/alibaba/fastjson/parser/JavaBeanDeserializer:beanInfo	Lcom/alibaba/fastjson/parser/JavaBeanInfo;
    //   137: getfield 132	com/alibaba/fastjson/parser/JavaBeanInfo:supportBeanToArray	Z
    //   140: ifne +3368 -> 3508
    //   143: aload 32
    //   145: getfield 135	com/alibaba/fastjson/parser/JSONLexer:features	I
    //   148: getstatic 141	com/alibaba/fastjson/parser/Feature:SupportArrayToBean	Lcom/alibaba/fastjson/parser/Feature;
    //   151: getfield 144	com/alibaba/fastjson/parser/Feature:mask	I
    //   154: iand
    //   155: ifeq +33 -> 188
    //   158: goto +3350 -> 3508
    //   161: iload 11
    //   163: ifeq +31 -> 194
    //   166: aload_0
    //   167: aload_1
    //   168: aload_2
    //   169: aload_3
    //   170: aload 4
    //   172: invokespecial 147	com/alibaba/fastjson/parser/JavaBeanDeserializer:deserialzeArrayMapping	(Lcom/alibaba/fastjson/parser/DefaultJSONParser;Ljava/lang/reflect/Type;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   175: astore_2
    //   176: iconst_0
    //   177: ifeq +3 -> 180
    //   180: aload_1
    //   181: aload 26
    //   183: invokevirtual 129	com/alibaba/fastjson/parser/DefaultJSONParser:setContext	(Lcom/alibaba/fastjson/parser/ParseContext;)V
    //   186: aload_2
    //   187: areturn
    //   188: iconst_0
    //   189: istore 11
    //   191: goto -30 -> 161
    //   194: iload 12
    //   196: bipush 12
    //   198: if_icmpeq +144 -> 342
    //   201: iload 12
    //   203: bipush 16
    //   205: if_icmpeq +137 -> 342
    //   208: aload 32
    //   210: invokevirtual 151	com/alibaba/fastjson/parser/JSONLexer:isBlankInput	()Z
    //   213: istore 21
    //   215: iload 21
    //   217: ifeq +15 -> 232
    //   220: iconst_0
    //   221: ifeq +3 -> 224
    //   224: aload_1
    //   225: aload 26
    //   227: invokevirtual 129	com/alibaba/fastjson/parser/DefaultJSONParser:setContext	(Lcom/alibaba/fastjson/parser/ParseContext;)V
    //   230: aconst_null
    //   231: areturn
    //   232: iload 12
    //   234: iconst_4
    //   235: if_icmpne +31 -> 266
    //   238: aload 32
    //   240: invokevirtual 155	com/alibaba/fastjson/parser/JSONLexer:stringVal	()Ljava/lang/String;
    //   243: invokevirtual 160	java/lang/String:length	()I
    //   246: ifne +20 -> 266
    //   249: aload 32
    //   251: invokevirtual 162	com/alibaba/fastjson/parser/JSONLexer:nextToken	()V
    //   254: iconst_0
    //   255: ifeq +3 -> 258
    //   258: aload_1
    //   259: aload 26
    //   261: invokevirtual 129	com/alibaba/fastjson/parser/DefaultJSONParser:setContext	(Lcom/alibaba/fastjson/parser/ParseContext;)V
    //   264: aconst_null
    //   265: areturn
    //   266: new 164	java/lang/StringBuffer
    //   269: dup
    //   270: invokespecial 165	java/lang/StringBuffer:<init>	()V
    //   273: ldc 167
    //   275: invokevirtual 171	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   278: aload 32
    //   280: invokevirtual 174	com/alibaba/fastjson/parser/JSONLexer:info	()Ljava/lang/String;
    //   283: invokevirtual 171	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   286: astore_2
    //   287: aload_3
    //   288: instanceof 157
    //   291: ifeq +14 -> 305
    //   294: aload_2
    //   295: ldc 176
    //   297: invokevirtual 171	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   300: aload_3
    //   301: invokevirtual 179	java/lang/StringBuffer:append	(Ljava/lang/Object;)Ljava/lang/StringBuffer;
    //   304: pop
    //   305: new 181	com/alibaba/fastjson/JSONException
    //   308: dup
    //   309: aload_2
    //   310: invokevirtual 184	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   313: invokespecial 187	com/alibaba/fastjson/JSONException:<init>	(Ljava/lang/String;)V
    //   316: athrow
    //   317: astore_2
    //   318: aload 4
    //   320: astore 23
    //   322: aload 22
    //   324: ifnull +10 -> 334
    //   327: aload 22
    //   329: aload 23
    //   331: putfield 191	com/alibaba/fastjson/parser/ParseContext:object	Ljava/lang/Object;
    //   334: aload_1
    //   335: aload 26
    //   337: invokevirtual 129	com/alibaba/fastjson/parser/DefaultJSONParser:setContext	(Lcom/alibaba/fastjson/parser/ParseContext;)V
    //   340: aload_2
    //   341: athrow
    //   342: aload_1
    //   343: getfield 194	com/alibaba/fastjson/parser/DefaultJSONParser:resolveStatus	I
    //   346: iconst_2
    //   347: if_icmpne +8 -> 355
    //   350: aload_1
    //   351: iconst_0
    //   352: putfield 194	com/alibaba/fastjson/parser/DefaultJSONParser:resolveStatus	I
    //   355: aload_0
    //   356: getfield 58	com/alibaba/fastjson/parser/JavaBeanDeserializer:sortedFieldDeserializers	[Lcom/alibaba/fastjson/parser/deserializer/FieldDeserializer;
    //   359: arraylength
    //   360: istore 16
    //   362: iconst_0
    //   363: istore 14
    //   365: aload 4
    //   367: astore 23
    //   369: aload 25
    //   371: astore 22
    //   373: iload 14
    //   375: iload 16
    //   377: if_icmpge +3109 -> 3486
    //   380: aload 23
    //   382: astore 25
    //   384: aload_0
    //   385: getfield 58	com/alibaba/fastjson/parser/JavaBeanDeserializer:sortedFieldDeserializers	[Lcom/alibaba/fastjson/parser/deserializer/FieldDeserializer;
    //   388: iload 14
    //   390: aaload
    //   391: astore 30
    //   393: aload 23
    //   395: astore 25
    //   397: aload 30
    //   399: getfield 198	com/alibaba/fastjson/parser/deserializer/FieldDeserializer:fieldInfo	Lcom/alibaba/fastjson/util/FieldInfo;
    //   402: astore 28
    //   404: aload 23
    //   406: astore 25
    //   408: aload 28
    //   410: getfield 201	com/alibaba/fastjson/util/FieldInfo:fieldClass	Ljava/lang/Class;
    //   413: astore 29
    //   415: iconst_0
    //   416: istore 12
    //   418: iconst_0
    //   419: istore 15
    //   421: aconst_null
    //   422: astore 4
    //   424: iconst_0
    //   425: istore 13
    //   427: lconst_0
    //   428: lstore 19
    //   430: fconst_0
    //   431: fstore 10
    //   433: dconst_0
    //   434: dstore 7
    //   436: dload 7
    //   438: dstore 5
    //   440: fload 10
    //   442: fstore 9
    //   444: iload 13
    //   446: istore 11
    //   448: lload 19
    //   450: lstore 17
    //   452: aload 30
    //   454: ifnull +2976 -> 3430
    //   457: aload 23
    //   459: astore 25
    //   461: aload 28
    //   463: getfield 205	com/alibaba/fastjson/util/FieldInfo:nameHashCode	J
    //   466: lstore 17
    //   468: aload 23
    //   470: astore 25
    //   472: aload 29
    //   474: getstatic 210	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   477: if_acmpeq +10 -> 487
    //   480: aload 29
    //   482: ldc 207
    //   484: if_acmpne +201 -> 685
    //   487: aload 23
    //   489: astore 25
    //   491: aload 32
    //   493: lload 17
    //   495: invokevirtual 214	com/alibaba/fastjson/parser/JSONLexer:scanFieldInt	(J)I
    //   498: istore 11
    //   500: aload 23
    //   502: astore 25
    //   504: aload 32
    //   506: getfield 217	com/alibaba/fastjson/parser/JSONLexer:matchStat	I
    //   509: ifle +143 -> 652
    //   512: iconst_1
    //   513: istore 13
    //   515: aconst_null
    //   516: astore 4
    //   518: iconst_1
    //   519: istore 12
    //   521: fconst_0
    //   522: fstore 9
    //   524: lconst_0
    //   525: lstore 17
    //   527: dload 7
    //   529: dstore 5
    //   531: iload 13
    //   533: ifne +3044 -> 3577
    //   536: aload 23
    //   538: astore 25
    //   540: aload 32
    //   542: aload_1
    //   543: getfield 221	com/alibaba/fastjson/parser/DefaultJSONParser:symbolTable	Lcom/alibaba/fastjson/parser/SymbolTable;
    //   546: invokevirtual 225	com/alibaba/fastjson/parser/JSONLexer:scanSymbol	(Lcom/alibaba/fastjson/parser/SymbolTable;)Ljava/lang/String;
    //   549: astore 27
    //   551: aload 27
    //   553: ifnonnull +1119 -> 1672
    //   556: aload 23
    //   558: astore 25
    //   560: aload 32
    //   562: getfield 104	com/alibaba/fastjson/parser/JSONLexer:token	I
    //   565: istore 15
    //   567: iload 15
    //   569: bipush 13
    //   571: if_icmpne +2984 -> 3555
    //   574: aload 23
    //   576: astore 25
    //   578: aload 32
    //   580: bipush 16
    //   582: invokevirtual 108	com/alibaba/fastjson/parser/JSONLexer:nextToken	(I)V
    //   585: aload 22
    //   587: astore 4
    //   589: aload 23
    //   591: astore 22
    //   593: aload 22
    //   595: astore 23
    //   597: aload 22
    //   599: ifnonnull +2563 -> 3162
    //   602: aload 24
    //   604: ifnonnull +2477 -> 3081
    //   607: aload_0
    //   608: aload_1
    //   609: aload_2
    //   610: invokevirtual 125	com/alibaba/fastjson/parser/JavaBeanDeserializer:createInstance	(Lcom/alibaba/fastjson/parser/DefaultJSONParser;Ljava/lang/reflect/Type;)Ljava/lang/Object;
    //   613: astore 23
    //   615: aload 4
    //   617: astore_2
    //   618: aload 4
    //   620: ifnonnull +13 -> 633
    //   623: aload_1
    //   624: aload 26
    //   626: aload 23
    //   628: aload_3
    //   629: invokevirtual 228	com/alibaba/fastjson/parser/DefaultJSONParser:setContext	(Lcom/alibaba/fastjson/parser/ParseContext;Ljava/lang/Object;Ljava/lang/Object;)Lcom/alibaba/fastjson/parser/ParseContext;
    //   632: astore_2
    //   633: aload_2
    //   634: ifnull +9 -> 643
    //   637: aload_2
    //   638: aload 23
    //   640: putfield 191	com/alibaba/fastjson/parser/ParseContext:object	Ljava/lang/Object;
    //   643: aload_1
    //   644: aload 26
    //   646: invokevirtual 129	com/alibaba/fastjson/parser/DefaultJSONParser:setContext	(Lcom/alibaba/fastjson/parser/ParseContext;)V
    //   649: aload 23
    //   651: areturn
    //   652: dload 7
    //   654: dstore 5
    //   656: fload 10
    //   658: fstore 9
    //   660: lload 19
    //   662: lstore 17
    //   664: aload 23
    //   666: astore 25
    //   668: aload 32
    //   670: getfield 217	com/alibaba/fastjson/parser/JSONLexer:matchStat	I
    //   673: bipush 254
    //   675: if_icmpne +2755 -> 3430
    //   678: aload 22
    //   680: astore 4
    //   682: goto +2832 -> 3514
    //   685: aload 23
    //   687: astore 25
    //   689: aload 29
    //   691: getstatic 231	java/lang/Long:TYPE	Ljava/lang/Class;
    //   694: if_acmpeq +10 -> 704
    //   697: aload 29
    //   699: ldc 230
    //   701: if_acmpne +83 -> 784
    //   704: aload 23
    //   706: astore 25
    //   708: aload 32
    //   710: lload 17
    //   712: invokevirtual 235	com/alibaba/fastjson/parser/JSONLexer:scanFieldLong	(J)J
    //   715: lstore 17
    //   717: aload 23
    //   719: astore 25
    //   721: aload 32
    //   723: getfield 217	com/alibaba/fastjson/parser/JSONLexer:matchStat	I
    //   726: ifle +25 -> 751
    //   729: iconst_1
    //   730: istore 13
    //   732: iconst_0
    //   733: istore 11
    //   735: aconst_null
    //   736: astore 4
    //   738: iconst_1
    //   739: istore 12
    //   741: fconst_0
    //   742: fstore 9
    //   744: dload 7
    //   746: dstore 5
    //   748: goto -217 -> 531
    //   751: dload 7
    //   753: dstore 5
    //   755: fload 10
    //   757: fstore 9
    //   759: iload 13
    //   761: istore 11
    //   763: aload 23
    //   765: astore 25
    //   767: aload 32
    //   769: getfield 217	com/alibaba/fastjson/parser/JSONLexer:matchStat	I
    //   772: bipush 254
    //   774: if_icmpne +2656 -> 3430
    //   777: aload 22
    //   779: astore 4
    //   781: goto +2733 -> 3514
    //   784: aload 29
    //   786: ldc 157
    //   788: if_acmpne +71 -> 859
    //   791: aload 23
    //   793: astore 25
    //   795: aload 32
    //   797: lload 17
    //   799: invokevirtual 239	com/alibaba/fastjson/parser/JSONLexer:scanFieldString	(J)Ljava/lang/String;
    //   802: astore 4
    //   804: aload 23
    //   806: astore 25
    //   808: aload 32
    //   810: getfield 217	com/alibaba/fastjson/parser/JSONLexer:matchStat	I
    //   813: ifle +25 -> 838
    //   816: iconst_1
    //   817: istore 13
    //   819: iconst_0
    //   820: istore 11
    //   822: iconst_1
    //   823: istore 12
    //   825: fconst_0
    //   826: fstore 9
    //   828: lconst_0
    //   829: lstore 17
    //   831: dload 7
    //   833: dstore 5
    //   835: goto -304 -> 531
    //   838: aload 23
    //   840: astore 25
    //   842: aload 32
    //   844: getfield 217	com/alibaba/fastjson/parser/JSONLexer:matchStat	I
    //   847: bipush 254
    //   849: if_icmpne +2615 -> 3464
    //   852: aload 22
    //   854: astore 4
    //   856: goto +2658 -> 3514
    //   859: aload 23
    //   861: astore 25
    //   863: aload 29
    //   865: getstatic 242	java/lang/Boolean:TYPE	Ljava/lang/Class;
    //   868: if_acmpeq +10 -> 878
    //   871: aload 29
    //   873: ldc 241
    //   875: if_acmpne +74 -> 949
    //   878: aload 23
    //   880: astore 25
    //   882: aload 32
    //   884: lload 17
    //   886: invokevirtual 246	com/alibaba/fastjson/parser/JSONLexer:scanFieldBoolean	(J)Z
    //   889: invokestatic 250	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   892: astore 4
    //   894: aload 23
    //   896: astore 25
    //   898: aload 32
    //   900: getfield 217	com/alibaba/fastjson/parser/JSONLexer:matchStat	I
    //   903: ifle +25 -> 928
    //   906: iconst_1
    //   907: istore 13
    //   909: iconst_0
    //   910: istore 11
    //   912: iconst_1
    //   913: istore 12
    //   915: fconst_0
    //   916: fstore 9
    //   918: lconst_0
    //   919: lstore 17
    //   921: dload 7
    //   923: dstore 5
    //   925: goto -394 -> 531
    //   928: aload 23
    //   930: astore 25
    //   932: aload 32
    //   934: getfield 217	com/alibaba/fastjson/parser/JSONLexer:matchStat	I
    //   937: bipush 254
    //   939: if_icmpne +2503 -> 3442
    //   942: aload 22
    //   944: astore 4
    //   946: goto +2568 -> 3514
    //   949: aload 23
    //   951: astore 25
    //   953: aload 29
    //   955: getstatic 253	java/lang/Float:TYPE	Ljava/lang/Class;
    //   958: if_acmpeq +10 -> 968
    //   961: aload 29
    //   963: ldc 252
    //   965: if_acmpne +83 -> 1048
    //   968: aload 23
    //   970: astore 25
    //   972: aload 32
    //   974: lload 17
    //   976: invokevirtual 257	com/alibaba/fastjson/parser/JSONLexer:scanFieldFloat	(J)F
    //   979: fstore 9
    //   981: aload 23
    //   983: astore 25
    //   985: aload 32
    //   987: getfield 217	com/alibaba/fastjson/parser/JSONLexer:matchStat	I
    //   990: ifle +25 -> 1015
    //   993: iconst_1
    //   994: istore 13
    //   996: iconst_0
    //   997: istore 11
    //   999: aconst_null
    //   1000: astore 4
    //   1002: iconst_1
    //   1003: istore 12
    //   1005: lconst_0
    //   1006: lstore 17
    //   1008: dload 7
    //   1010: dstore 5
    //   1012: goto -481 -> 531
    //   1015: dload 7
    //   1017: dstore 5
    //   1019: iload 13
    //   1021: istore 11
    //   1023: lload 19
    //   1025: lstore 17
    //   1027: aload 23
    //   1029: astore 25
    //   1031: aload 32
    //   1033: getfield 217	com/alibaba/fastjson/parser/JSONLexer:matchStat	I
    //   1036: bipush 254
    //   1038: if_icmpne +2392 -> 3430
    //   1041: aload 22
    //   1043: astore 4
    //   1045: goto +2469 -> 3514
    //   1048: aload 23
    //   1050: astore 25
    //   1052: aload 29
    //   1054: getstatic 260	java/lang/Double:TYPE	Ljava/lang/Class;
    //   1057: if_acmpeq +11 -> 1068
    //   1060: aload 29
    //   1062: ldc_w 259
    //   1065: if_acmpne +82 -> 1147
    //   1068: aload 23
    //   1070: astore 25
    //   1072: aload 32
    //   1074: lload 17
    //   1076: invokevirtual 264	com/alibaba/fastjson/parser/JSONLexer:scanFieldDouble	(J)D
    //   1079: dstore 5
    //   1081: aload 23
    //   1083: astore 25
    //   1085: aload 32
    //   1087: getfield 217	com/alibaba/fastjson/parser/JSONLexer:matchStat	I
    //   1090: ifle +24 -> 1114
    //   1093: iconst_1
    //   1094: istore 13
    //   1096: iconst_0
    //   1097: istore 11
    //   1099: aconst_null
    //   1100: astore 4
    //   1102: iconst_1
    //   1103: istore 12
    //   1105: fconst_0
    //   1106: fstore 9
    //   1108: lconst_0
    //   1109: lstore 17
    //   1111: goto -580 -> 531
    //   1114: fload 10
    //   1116: fstore 9
    //   1118: iload 13
    //   1120: istore 11
    //   1122: lload 19
    //   1124: lstore 17
    //   1126: aload 23
    //   1128: astore 25
    //   1130: aload 32
    //   1132: getfield 217	com/alibaba/fastjson/parser/JSONLexer:matchStat	I
    //   1135: bipush 254
    //   1137: if_icmpne +2293 -> 3430
    //   1140: aload 22
    //   1142: astore 4
    //   1144: goto +2370 -> 3514
    //   1147: aload 23
    //   1149: astore 25
    //   1151: aload 28
    //   1153: getfield 267	com/alibaba/fastjson/util/FieldInfo:isEnum	Z
    //   1156: ifeq +94 -> 1250
    //   1159: aload 23
    //   1161: astore 25
    //   1163: aload_1
    //   1164: getfield 271	com/alibaba/fastjson/parser/DefaultJSONParser:config	Lcom/alibaba/fastjson/parser/ParserConfig;
    //   1167: aload 29
    //   1169: invokevirtual 275	com/alibaba/fastjson/parser/ParserConfig:getDeserializer	(Ljava/lang/reflect/Type;)Lcom/alibaba/fastjson/parser/deserializer/ObjectDeserializer;
    //   1172: instanceof 277
    //   1175: ifeq +75 -> 1250
    //   1178: aload 23
    //   1180: astore 25
    //   1182: aload 32
    //   1184: lload 17
    //   1186: invokevirtual 280	com/alibaba/fastjson/parser/JSONLexer:scanFieldSymbol	(J)J
    //   1189: lstore 17
    //   1191: aload 23
    //   1193: astore 25
    //   1195: aload 32
    //   1197: getfield 217	com/alibaba/fastjson/parser/JSONLexer:matchStat	I
    //   1200: ifle +25 -> 1225
    //   1203: iconst_1
    //   1204: istore 12
    //   1206: iconst_1
    //   1207: istore 11
    //   1209: aload 23
    //   1211: astore 25
    //   1213: aload 30
    //   1215: lload 17
    //   1217: invokevirtual 284	com/alibaba/fastjson/parser/deserializer/FieldDeserializer:getEnumByHashCode	(J)Ljava/lang/Enum;
    //   1220: astore 4
    //   1222: goto +2305 -> 3527
    //   1225: iload 15
    //   1227: istore 11
    //   1229: aload 23
    //   1231: astore 25
    //   1233: aload 32
    //   1235: getfield 217	com/alibaba/fastjson/parser/JSONLexer:matchStat	I
    //   1238: bipush 254
    //   1240: if_icmpne +2287 -> 3527
    //   1243: aload 22
    //   1245: astore 4
    //   1247: goto +2267 -> 3514
    //   1250: aload 29
    //   1252: ldc_w 286
    //   1255: if_acmpne +71 -> 1326
    //   1258: aload 23
    //   1260: astore 25
    //   1262: aload 32
    //   1264: lload 17
    //   1266: invokevirtual 290	com/alibaba/fastjson/parser/JSONLexer:scanFieldIntArray	(J)[I
    //   1269: astore 4
    //   1271: aload 23
    //   1273: astore 25
    //   1275: aload 32
    //   1277: getfield 217	com/alibaba/fastjson/parser/JSONLexer:matchStat	I
    //   1280: ifle +25 -> 1305
    //   1283: iconst_1
    //   1284: istore 13
    //   1286: iconst_0
    //   1287: istore 11
    //   1289: iconst_1
    //   1290: istore 12
    //   1292: fconst_0
    //   1293: fstore 9
    //   1295: lconst_0
    //   1296: lstore 17
    //   1298: dload 7
    //   1300: dstore 5
    //   1302: goto -771 -> 531
    //   1305: aload 23
    //   1307: astore 25
    //   1309: aload 32
    //   1311: getfield 217	com/alibaba/fastjson/parser/JSONLexer:matchStat	I
    //   1314: bipush 254
    //   1316: if_icmpne +2092 -> 3408
    //   1319: aload 22
    //   1321: astore 4
    //   1323: goto +2191 -> 3514
    //   1326: aload 29
    //   1328: ldc_w 292
    //   1331: if_acmpne +71 -> 1402
    //   1334: aload 23
    //   1336: astore 25
    //   1338: aload 32
    //   1340: lload 17
    //   1342: invokevirtual 296	com/alibaba/fastjson/parser/JSONLexer:scanFieldFloatArray	(J)[F
    //   1345: astore 4
    //   1347: aload 23
    //   1349: astore 25
    //   1351: aload 32
    //   1353: getfield 217	com/alibaba/fastjson/parser/JSONLexer:matchStat	I
    //   1356: ifle +25 -> 1381
    //   1359: iconst_1
    //   1360: istore 13
    //   1362: iconst_0
    //   1363: istore 11
    //   1365: iconst_1
    //   1366: istore 12
    //   1368: fconst_0
    //   1369: fstore 9
    //   1371: lconst_0
    //   1372: lstore 17
    //   1374: dload 7
    //   1376: dstore 5
    //   1378: goto -847 -> 531
    //   1381: aload 23
    //   1383: astore 25
    //   1385: aload 32
    //   1387: getfield 217	com/alibaba/fastjson/parser/JSONLexer:matchStat	I
    //   1390: bipush 254
    //   1392: if_icmpne +1994 -> 3386
    //   1395: aload 22
    //   1397: astore 4
    //   1399: goto +2115 -> 3514
    //   1402: aload 29
    //   1404: ldc_w 298
    //   1407: if_acmpne +71 -> 1478
    //   1410: aload 23
    //   1412: astore 25
    //   1414: aload 32
    //   1416: lload 17
    //   1418: invokevirtual 302	com/alibaba/fastjson/parser/JSONLexer:scanFieldDoubleArray	(J)[D
    //   1421: astore 4
    //   1423: aload 23
    //   1425: astore 25
    //   1427: aload 32
    //   1429: getfield 217	com/alibaba/fastjson/parser/JSONLexer:matchStat	I
    //   1432: ifle +25 -> 1457
    //   1435: iconst_1
    //   1436: istore 13
    //   1438: iconst_0
    //   1439: istore 11
    //   1441: iconst_1
    //   1442: istore 12
    //   1444: fconst_0
    //   1445: fstore 9
    //   1447: lconst_0
    //   1448: lstore 17
    //   1450: dload 7
    //   1452: dstore 5
    //   1454: goto -923 -> 531
    //   1457: aload 23
    //   1459: astore 25
    //   1461: aload 32
    //   1463: getfield 217	com/alibaba/fastjson/parser/JSONLexer:matchStat	I
    //   1466: bipush 254
    //   1468: if_icmpne +1896 -> 3364
    //   1471: aload 22
    //   1473: astore 4
    //   1475: goto +2039 -> 3514
    //   1478: aload 29
    //   1480: ldc_w 304
    //   1483: if_acmpne +71 -> 1554
    //   1486: aload 23
    //   1488: astore 25
    //   1490: aload 32
    //   1492: lload 17
    //   1494: invokevirtual 308	com/alibaba/fastjson/parser/JSONLexer:scanFieldFloatArray2	(J)[[F
    //   1497: astore 4
    //   1499: aload 23
    //   1501: astore 25
    //   1503: aload 32
    //   1505: getfield 217	com/alibaba/fastjson/parser/JSONLexer:matchStat	I
    //   1508: ifle +25 -> 1533
    //   1511: iconst_1
    //   1512: istore 13
    //   1514: iconst_0
    //   1515: istore 11
    //   1517: iconst_1
    //   1518: istore 12
    //   1520: fconst_0
    //   1521: fstore 9
    //   1523: lconst_0
    //   1524: lstore 17
    //   1526: dload 7
    //   1528: dstore 5
    //   1530: goto -999 -> 531
    //   1533: aload 23
    //   1535: astore 25
    //   1537: aload 32
    //   1539: getfield 217	com/alibaba/fastjson/parser/JSONLexer:matchStat	I
    //   1542: bipush 254
    //   1544: if_icmpne +1798 -> 3342
    //   1547: aload 22
    //   1549: astore 4
    //   1551: goto +1963 -> 3514
    //   1554: aload 29
    //   1556: ldc_w 310
    //   1559: if_acmpne +71 -> 1630
    //   1562: aload 23
    //   1564: astore 25
    //   1566: aload 32
    //   1568: lload 17
    //   1570: invokevirtual 314	com/alibaba/fastjson/parser/JSONLexer:scanFieldDoubleArray2	(J)[[D
    //   1573: astore 4
    //   1575: aload 23
    //   1577: astore 25
    //   1579: aload 32
    //   1581: getfield 217	com/alibaba/fastjson/parser/JSONLexer:matchStat	I
    //   1584: ifle +25 -> 1609
    //   1587: iconst_1
    //   1588: istore 13
    //   1590: iconst_0
    //   1591: istore 11
    //   1593: iconst_1
    //   1594: istore 12
    //   1596: fconst_0
    //   1597: fstore 9
    //   1599: lconst_0
    //   1600: lstore 17
    //   1602: dload 7
    //   1604: dstore 5
    //   1606: goto -1075 -> 531
    //   1609: aload 23
    //   1611: astore 25
    //   1613: aload 32
    //   1615: getfield 217	com/alibaba/fastjson/parser/JSONLexer:matchStat	I
    //   1618: bipush 254
    //   1620: if_icmpne +1700 -> 3320
    //   1623: aload 22
    //   1625: astore 4
    //   1627: goto +1887 -> 3514
    //   1630: aload 23
    //   1632: astore 25
    //   1634: aload 32
    //   1636: aload 28
    //   1638: getfield 205	com/alibaba/fastjson/util/FieldInfo:nameHashCode	J
    //   1641: invokevirtual 317	com/alibaba/fastjson/parser/JSONLexer:matchField	(J)Z
    //   1644: ifeq +1669 -> 3313
    //   1647: iconst_1
    //   1648: istore 13
    //   1650: iconst_0
    //   1651: istore 11
    //   1653: aconst_null
    //   1654: astore 4
    //   1656: iconst_0
    //   1657: istore 12
    //   1659: fconst_0
    //   1660: fstore 9
    //   1662: lconst_0
    //   1663: lstore 17
    //   1665: dload 7
    //   1667: dstore 5
    //   1669: goto -1138 -> 531
    //   1672: ldc_w 319
    //   1675: aload 27
    //   1677: if_acmpne +395 -> 2072
    //   1680: aload 23
    //   1682: astore 25
    //   1684: aload 32
    //   1686: bipush 58
    //   1688: invokevirtual 323	com/alibaba/fastjson/parser/JSONLexer:nextTokenWithChar	(C)V
    //   1691: aload 23
    //   1693: astore 25
    //   1695: aload 32
    //   1697: getfield 104	com/alibaba/fastjson/parser/JSONLexer:token	I
    //   1700: istore 11
    //   1702: iload 11
    //   1704: iconst_4
    //   1705: if_icmpne +285 -> 1990
    //   1708: aload 23
    //   1710: astore 25
    //   1712: aload 32
    //   1714: invokevirtual 155	com/alibaba/fastjson/parser/JSONLexer:stringVal	()Ljava/lang/String;
    //   1717: astore 4
    //   1719: aload 23
    //   1721: astore 25
    //   1723: ldc_w 325
    //   1726: aload 4
    //   1728: invokevirtual 329	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1731: ifeq +54 -> 1785
    //   1734: aload 23
    //   1736: astore 25
    //   1738: aload 26
    //   1740: getfield 191	com/alibaba/fastjson/parser/ParseContext:object	Ljava/lang/Object;
    //   1743: astore 23
    //   1745: aload 23
    //   1747: astore 25
    //   1749: aload 32
    //   1751: bipush 13
    //   1753: invokevirtual 108	com/alibaba/fastjson/parser/JSONLexer:nextToken	(I)V
    //   1756: aload 23
    //   1758: astore 25
    //   1760: aload 32
    //   1762: getfield 104	com/alibaba/fastjson/parser/JSONLexer:token	I
    //   1765: bipush 13
    //   1767: if_icmpeq +259 -> 2026
    //   1770: aload 23
    //   1772: astore 25
    //   1774: new 181	com/alibaba/fastjson/JSONException
    //   1777: dup
    //   1778: ldc_w 331
    //   1781: invokespecial 187	com/alibaba/fastjson/JSONException:<init>	(Ljava/lang/String;)V
    //   1784: athrow
    //   1785: aload 23
    //   1787: astore 25
    //   1789: ldc_w 333
    //   1792: aload 4
    //   1794: invokevirtual 329	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1797: ifeq +67 -> 1864
    //   1800: aload 23
    //   1802: astore 25
    //   1804: aload 26
    //   1806: getfield 121	com/alibaba/fastjson/parser/ParseContext:parent	Lcom/alibaba/fastjson/parser/ParseContext;
    //   1809: astore_2
    //   1810: aload 23
    //   1812: astore 25
    //   1814: aload_2
    //   1815: getfield 191	com/alibaba/fastjson/parser/ParseContext:object	Ljava/lang/Object;
    //   1818: ifnull +16 -> 1834
    //   1821: aload 23
    //   1823: astore 25
    //   1825: aload_2
    //   1826: getfield 191	com/alibaba/fastjson/parser/ParseContext:object	Ljava/lang/Object;
    //   1829: astore 23
    //   1831: goto -86 -> 1745
    //   1834: aload 23
    //   1836: astore 25
    //   1838: aload_1
    //   1839: new 335	com/alibaba/fastjson/parser/DefaultJSONParser$ResolveTask
    //   1842: dup
    //   1843: aload_2
    //   1844: aload 4
    //   1846: invokespecial 338	com/alibaba/fastjson/parser/DefaultJSONParser$ResolveTask:<init>	(Lcom/alibaba/fastjson/parser/ParseContext;Ljava/lang/String;)V
    //   1849: invokevirtual 342	com/alibaba/fastjson/parser/DefaultJSONParser:addResolveTask	(Lcom/alibaba/fastjson/parser/DefaultJSONParser$ResolveTask;)V
    //   1852: aload 23
    //   1854: astore 25
    //   1856: aload_1
    //   1857: iconst_1
    //   1858: putfield 194	com/alibaba/fastjson/parser/DefaultJSONParser:resolveStatus	I
    //   1861: goto -116 -> 1745
    //   1864: aload 23
    //   1866: astore 25
    //   1868: ldc_w 344
    //   1871: aload 4
    //   1873: invokevirtual 329	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1876: ifeq +83 -> 1959
    //   1879: aload 26
    //   1881: astore_2
    //   1882: aload 23
    //   1884: astore 25
    //   1886: aload_2
    //   1887: getfield 121	com/alibaba/fastjson/parser/ParseContext:parent	Lcom/alibaba/fastjson/parser/ParseContext;
    //   1890: ifnull +15 -> 1905
    //   1893: aload 23
    //   1895: astore 25
    //   1897: aload_2
    //   1898: getfield 121	com/alibaba/fastjson/parser/ParseContext:parent	Lcom/alibaba/fastjson/parser/ParseContext;
    //   1901: astore_2
    //   1902: goto -20 -> 1882
    //   1905: aload 23
    //   1907: astore 25
    //   1909: aload_2
    //   1910: getfield 191	com/alibaba/fastjson/parser/ParseContext:object	Ljava/lang/Object;
    //   1913: ifnull +16 -> 1929
    //   1916: aload 23
    //   1918: astore 25
    //   1920: aload_2
    //   1921: getfield 191	com/alibaba/fastjson/parser/ParseContext:object	Ljava/lang/Object;
    //   1924: astore 23
    //   1926: goto -181 -> 1745
    //   1929: aload 23
    //   1931: astore 25
    //   1933: aload_1
    //   1934: new 335	com/alibaba/fastjson/parser/DefaultJSONParser$ResolveTask
    //   1937: dup
    //   1938: aload_2
    //   1939: aload 4
    //   1941: invokespecial 338	com/alibaba/fastjson/parser/DefaultJSONParser$ResolveTask:<init>	(Lcom/alibaba/fastjson/parser/ParseContext;Ljava/lang/String;)V
    //   1944: invokevirtual 342	com/alibaba/fastjson/parser/DefaultJSONParser:addResolveTask	(Lcom/alibaba/fastjson/parser/DefaultJSONParser$ResolveTask;)V
    //   1947: aload 23
    //   1949: astore 25
    //   1951: aload_1
    //   1952: iconst_1
    //   1953: putfield 194	com/alibaba/fastjson/parser/DefaultJSONParser:resolveStatus	I
    //   1956: goto -211 -> 1745
    //   1959: aload 23
    //   1961: astore 25
    //   1963: aload_1
    //   1964: new 335	com/alibaba/fastjson/parser/DefaultJSONParser$ResolveTask
    //   1967: dup
    //   1968: aload 26
    //   1970: aload 4
    //   1972: invokespecial 338	com/alibaba/fastjson/parser/DefaultJSONParser$ResolveTask:<init>	(Lcom/alibaba/fastjson/parser/ParseContext;Ljava/lang/String;)V
    //   1975: invokevirtual 342	com/alibaba/fastjson/parser/DefaultJSONParser:addResolveTask	(Lcom/alibaba/fastjson/parser/DefaultJSONParser$ResolveTask;)V
    //   1978: aload 23
    //   1980: astore 25
    //   1982: aload_1
    //   1983: iconst_1
    //   1984: putfield 194	com/alibaba/fastjson/parser/DefaultJSONParser:resolveStatus	I
    //   1987: goto -242 -> 1745
    //   1990: aload 23
    //   1992: astore 25
    //   1994: new 181	com/alibaba/fastjson/JSONException
    //   1997: dup
    //   1998: new 346	java/lang/StringBuilder
    //   2001: dup
    //   2002: invokespecial 347	java/lang/StringBuilder:<init>	()V
    //   2005: ldc_w 349
    //   2008: invokevirtual 352	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2011: iload 11
    //   2013: invokestatic 357	com/alibaba/fastjson/parser/JSONToken:name	(I)Ljava/lang/String;
    //   2016: invokevirtual 352	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2019: invokevirtual 358	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2022: invokespecial 187	com/alibaba/fastjson/JSONException:<init>	(Ljava/lang/String;)V
    //   2025: athrow
    //   2026: aload 23
    //   2028: astore 25
    //   2030: aload 32
    //   2032: bipush 16
    //   2034: invokevirtual 108	com/alibaba/fastjson/parser/JSONLexer:nextToken	(I)V
    //   2037: aload 23
    //   2039: astore 25
    //   2041: aload_1
    //   2042: aload 26
    //   2044: aload 23
    //   2046: aload_3
    //   2047: invokevirtual 228	com/alibaba/fastjson/parser/DefaultJSONParser:setContext	(Lcom/alibaba/fastjson/parser/ParseContext;Ljava/lang/Object;Ljava/lang/Object;)Lcom/alibaba/fastjson/parser/ParseContext;
    //   2050: pop
    //   2051: aload 22
    //   2053: ifnull +10 -> 2063
    //   2056: aload 22
    //   2058: aload 23
    //   2060: putfield 191	com/alibaba/fastjson/parser/ParseContext:object	Ljava/lang/Object;
    //   2063: aload_1
    //   2064: aload 26
    //   2066: invokevirtual 129	com/alibaba/fastjson/parser/DefaultJSONParser:setContext	(Lcom/alibaba/fastjson/parser/ParseContext;)V
    //   2069: aload 23
    //   2071: areturn
    //   2072: aload 27
    //   2074: astore 31
    //   2076: ldc_w 360
    //   2079: aload 27
    //   2081: if_acmpne +275 -> 2356
    //   2084: aload 23
    //   2086: astore 25
    //   2088: aload 32
    //   2090: bipush 58
    //   2092: invokevirtual 323	com/alibaba/fastjson/parser/JSONLexer:nextTokenWithChar	(C)V
    //   2095: aload 23
    //   2097: astore 25
    //   2099: aload 32
    //   2101: getfield 104	com/alibaba/fastjson/parser/JSONLexer:token	I
    //   2104: iconst_4
    //   2105: if_icmpne +236 -> 2341
    //   2108: aload 23
    //   2110: astore 25
    //   2112: aload 32
    //   2114: invokevirtual 155	com/alibaba/fastjson/parser/JSONLexer:stringVal	()Ljava/lang/String;
    //   2117: astore 28
    //   2119: aload 23
    //   2121: astore 25
    //   2123: aload 32
    //   2125: bipush 16
    //   2127: invokevirtual 108	com/alibaba/fastjson/parser/JSONLexer:nextToken	(I)V
    //   2130: aload 23
    //   2132: astore 25
    //   2134: aload_2
    //   2135: instanceof 21
    //   2138: ifeq +56 -> 2194
    //   2141: aload 23
    //   2143: astore 25
    //   2145: aload 28
    //   2147: aload_2
    //   2148: checkcast 21	java/lang/Class
    //   2151: invokevirtual 363	java/lang/Class:getName	()Ljava/lang/String;
    //   2154: invokevirtual 329	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2157: ifeq +37 -> 2194
    //   2160: aload 23
    //   2162: astore 25
    //   2164: aload 32
    //   2166: getfield 104	com/alibaba/fastjson/parser/JSONLexer:token	I
    //   2169: bipush 13
    //   2171: if_icmpne +1142 -> 3313
    //   2174: aload 23
    //   2176: astore 25
    //   2178: aload 32
    //   2180: invokevirtual 162	com/alibaba/fastjson/parser/JSONLexer:nextToken	()V
    //   2183: aload 22
    //   2185: astore 4
    //   2187: aload 23
    //   2189: astore 22
    //   2191: goto -1598 -> 593
    //   2194: aload 23
    //   2196: astore 25
    //   2198: aload_0
    //   2199: aload_1
    //   2200: getfield 271	com/alibaba/fastjson/parser/DefaultJSONParser:config	Lcom/alibaba/fastjson/parser/ParserConfig;
    //   2203: aload_0
    //   2204: getfield 50	com/alibaba/fastjson/parser/JavaBeanDeserializer:beanInfo	Lcom/alibaba/fastjson/parser/JavaBeanInfo;
    //   2207: aload 28
    //   2209: invokevirtual 367	com/alibaba/fastjson/parser/JavaBeanDeserializer:getSeeAlso	(Lcom/alibaba/fastjson/parser/ParserConfig;Lcom/alibaba/fastjson/parser/JavaBeanInfo;Ljava/lang/String;)Lcom/alibaba/fastjson/parser/JavaBeanDeserializer;
    //   2212: astore 27
    //   2214: aconst_null
    //   2215: astore 24
    //   2217: aload 27
    //   2219: astore 4
    //   2221: aload 27
    //   2223: ifnonnull +67 -> 2290
    //   2226: aload 23
    //   2228: astore 25
    //   2230: aload 28
    //   2232: aload_1
    //   2233: getfield 271	com/alibaba/fastjson/parser/DefaultJSONParser:config	Lcom/alibaba/fastjson/parser/ParserConfig;
    //   2236: getfield 371	com/alibaba/fastjson/parser/ParserConfig:defaultClassLoader	Ljava/lang/ClassLoader;
    //   2239: invokestatic 377	com/alibaba/fastjson/util/TypeUtils:loadClass	(Ljava/lang/String;Ljava/lang/ClassLoader;)Ljava/lang/Class;
    //   2242: astore 24
    //   2244: aload 23
    //   2246: astore 25
    //   2248: aload_2
    //   2249: invokestatic 381	com/alibaba/fastjson/util/TypeUtils:getClass	(Ljava/lang/reflect/Type;)Ljava/lang/Class;
    //   2252: astore_2
    //   2253: aload_2
    //   2254: ifnull +21 -> 2275
    //   2257: aload 24
    //   2259: ifnull +67 -> 2326
    //   2262: aload 23
    //   2264: astore 25
    //   2266: aload_2
    //   2267: aload 24
    //   2269: invokevirtual 385	java/lang/Class:isAssignableFrom	(Ljava/lang/Class;)Z
    //   2272: ifeq +54 -> 2326
    //   2275: aload 23
    //   2277: astore 25
    //   2279: aload_1
    //   2280: getfield 271	com/alibaba/fastjson/parser/DefaultJSONParser:config	Lcom/alibaba/fastjson/parser/ParserConfig;
    //   2283: aload 24
    //   2285: invokevirtual 275	com/alibaba/fastjson/parser/ParserConfig:getDeserializer	(Ljava/lang/reflect/Type;)Lcom/alibaba/fastjson/parser/deserializer/ObjectDeserializer;
    //   2288: astore 4
    //   2290: aload 23
    //   2292: astore 25
    //   2294: aload 4
    //   2296: aload_1
    //   2297: aload 24
    //   2299: aload_3
    //   2300: invokeinterface 388 4 0
    //   2305: astore_2
    //   2306: aload 22
    //   2308: ifnull +10 -> 2318
    //   2311: aload 22
    //   2313: aload 23
    //   2315: putfield 191	com/alibaba/fastjson/parser/ParseContext:object	Ljava/lang/Object;
    //   2318: aload_1
    //   2319: aload 26
    //   2321: invokevirtual 129	com/alibaba/fastjson/parser/DefaultJSONParser:setContext	(Lcom/alibaba/fastjson/parser/ParseContext;)V
    //   2324: aload_2
    //   2325: areturn
    //   2326: aload 23
    //   2328: astore 25
    //   2330: new 181	com/alibaba/fastjson/JSONException
    //   2333: dup
    //   2334: ldc_w 390
    //   2337: invokespecial 187	com/alibaba/fastjson/JSONException:<init>	(Ljava/lang/String;)V
    //   2340: athrow
    //   2341: aload 23
    //   2343: astore 25
    //   2345: new 181	com/alibaba/fastjson/JSONException
    //   2348: dup
    //   2349: ldc_w 392
    //   2352: invokespecial 187	com/alibaba/fastjson/JSONException:<init>	(Ljava/lang/String;)V
    //   2355: athrow
    //   2356: aload 23
    //   2358: astore 27
    //   2360: aload 24
    //   2362: astore 25
    //   2364: aload 23
    //   2366: ifnonnull +936 -> 3302
    //   2369: aload 23
    //   2371: astore 27
    //   2373: aload 24
    //   2375: astore 25
    //   2377: aload 24
    //   2379: ifnonnull +923 -> 3302
    //   2382: aload 23
    //   2384: astore 25
    //   2386: aload_0
    //   2387: aload_1
    //   2388: aload_2
    //   2389: invokevirtual 125	com/alibaba/fastjson/parser/JavaBeanDeserializer:createInstance	(Lcom/alibaba/fastjson/parser/DefaultJSONParser;Ljava/lang/reflect/Type;)Ljava/lang/Object;
    //   2392: astore 23
    //   2394: aload 23
    //   2396: ifnonnull +21 -> 2417
    //   2399: aload 23
    //   2401: astore 25
    //   2403: new 394	java/util/HashMap
    //   2406: dup
    //   2407: aload_0
    //   2408: getfield 67	com/alibaba/fastjson/parser/JavaBeanDeserializer:fieldDeserializers	[Lcom/alibaba/fastjson/parser/deserializer/FieldDeserializer;
    //   2411: arraylength
    //   2412: invokespecial 396	java/util/HashMap:<init>	(I)V
    //   2415: astore 24
    //   2417: aload 23
    //   2419: astore 27
    //   2421: aload 24
    //   2423: astore 25
    //   2425: iload 21
    //   2427: ifne +875 -> 3302
    //   2430: aload 23
    //   2432: astore 25
    //   2434: aload_1
    //   2435: aload 26
    //   2437: aload 23
    //   2439: aload_3
    //   2440: invokevirtual 228	com/alibaba/fastjson/parser/DefaultJSONParser:setContext	(Lcom/alibaba/fastjson/parser/ParseContext;Ljava/lang/Object;Ljava/lang/Object;)Lcom/alibaba/fastjson/parser/ParseContext;
    //   2443: astore 27
    //   2445: aload 27
    //   2447: astore 22
    //   2449: iload 13
    //   2451: ifeq +486 -> 2937
    //   2454: iload 12
    //   2456: ifne +31 -> 2487
    //   2459: aload 30
    //   2461: aload_1
    //   2462: aload 23
    //   2464: aload_2
    //   2465: aload 24
    //   2467: invokevirtual 400	com/alibaba/fastjson/parser/deserializer/FieldDeserializer:parseField	(Lcom/alibaba/fastjson/parser/DefaultJSONParser;Ljava/lang/Object;Ljava/lang/reflect/Type;Ljava/util/Map;)V
    //   2470: aload 32
    //   2472: getfield 104	com/alibaba/fastjson/parser/JSONLexer:token	I
    //   2475: bipush 16
    //   2477: if_icmpne +522 -> 2999
    //   2480: aload 22
    //   2482: astore 4
    //   2484: goto +1030 -> 3514
    //   2487: aload 23
    //   2489: ifnonnull +144 -> 2633
    //   2492: aload 29
    //   2494: getstatic 210	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   2497: if_acmpeq +10 -> 2507
    //   2500: aload 29
    //   2502: ldc 207
    //   2504: if_acmpne +45 -> 2549
    //   2507: iload 11
    //   2509: invokestatic 403	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2512: astore 4
    //   2514: aload 24
    //   2516: aload 28
    //   2518: getfield 73	com/alibaba/fastjson/util/FieldInfo:name	Ljava/lang/String;
    //   2521: aload 4
    //   2523: invokeinterface 409 3 0
    //   2528: pop
    //   2529: aload 32
    //   2531: getfield 217	com/alibaba/fastjson/parser/JSONLexer:matchStat	I
    //   2534: iconst_4
    //   2535: if_icmpne -65 -> 2470
    //   2538: aload 22
    //   2540: astore 4
    //   2542: aload 23
    //   2544: astore 22
    //   2546: goto -1953 -> 593
    //   2549: aload 29
    //   2551: getstatic 231	java/lang/Long:TYPE	Ljava/lang/Class;
    //   2554: if_acmpeq +10 -> 2564
    //   2557: aload 29
    //   2559: ldc 230
    //   2561: if_acmpne +13 -> 2574
    //   2564: lload 17
    //   2566: invokestatic 412	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2569: astore 4
    //   2571: goto -57 -> 2514
    //   2574: aload 29
    //   2576: getstatic 253	java/lang/Float:TYPE	Ljava/lang/Class;
    //   2579: if_acmpeq +10 -> 2589
    //   2582: aload 29
    //   2584: ldc 252
    //   2586: if_acmpne +17 -> 2603
    //   2589: new 252	java/lang/Float
    //   2592: dup
    //   2593: fload 9
    //   2595: invokespecial 415	java/lang/Float:<init>	(F)V
    //   2598: astore 4
    //   2600: goto -86 -> 2514
    //   2603: aload 29
    //   2605: getstatic 260	java/lang/Double:TYPE	Ljava/lang/Class;
    //   2608: if_acmpeq +11 -> 2619
    //   2611: aload 29
    //   2613: ldc_w 259
    //   2616: if_acmpne -102 -> 2514
    //   2619: new 259	java/lang/Double
    //   2622: dup
    //   2623: dload 5
    //   2625: invokespecial 418	java/lang/Double:<init>	(D)V
    //   2628: astore 4
    //   2630: goto -116 -> 2514
    //   2633: aload 4
    //   2635: ifnonnull +290 -> 2925
    //   2638: aload 29
    //   2640: getstatic 210	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   2643: if_acmpeq +10 -> 2653
    //   2646: aload 29
    //   2648: ldc 207
    //   2650: if_acmpne +80 -> 2730
    //   2653: aload 28
    //   2655: getfield 421	com/alibaba/fastjson/util/FieldInfo:fieldAccess	Z
    //   2658: ifeq +57 -> 2715
    //   2661: aload 29
    //   2663: getstatic 210	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   2666: if_acmpne +49 -> 2715
    //   2669: aload 30
    //   2671: aload 23
    //   2673: iload 11
    //   2675: invokevirtual 425	com/alibaba/fastjson/parser/deserializer/FieldDeserializer:setValue	(Ljava/lang/Object;I)V
    //   2678: goto -149 -> 2529
    //   2681: astore_2
    //   2682: new 181	com/alibaba/fastjson/JSONException
    //   2685: dup
    //   2686: new 346	java/lang/StringBuilder
    //   2689: dup
    //   2690: invokespecial 347	java/lang/StringBuilder:<init>	()V
    //   2693: ldc_w 427
    //   2696: invokevirtual 352	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2699: aload 28
    //   2701: getfield 73	com/alibaba/fastjson/util/FieldInfo:name	Ljava/lang/String;
    //   2704: invokevirtual 352	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2707: invokevirtual 358	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2710: aload_2
    //   2711: invokespecial 430	com/alibaba/fastjson/JSONException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   2714: athrow
    //   2715: aload 30
    //   2717: aload 23
    //   2719: iload 11
    //   2721: invokestatic 403	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2724: invokevirtual 433	com/alibaba/fastjson/parser/deserializer/FieldDeserializer:setValue	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   2727: goto -198 -> 2529
    //   2730: aload 29
    //   2732: getstatic 231	java/lang/Long:TYPE	Ljava/lang/Class;
    //   2735: if_acmpeq +10 -> 2745
    //   2738: aload 29
    //   2740: ldc 230
    //   2742: if_acmpne +46 -> 2788
    //   2745: aload 28
    //   2747: getfield 421	com/alibaba/fastjson/util/FieldInfo:fieldAccess	Z
    //   2750: ifeq +23 -> 2773
    //   2753: aload 29
    //   2755: getstatic 231	java/lang/Long:TYPE	Ljava/lang/Class;
    //   2758: if_acmpne +15 -> 2773
    //   2761: aload 30
    //   2763: aload 23
    //   2765: lload 17
    //   2767: invokevirtual 436	com/alibaba/fastjson/parser/deserializer/FieldDeserializer:setValue	(Ljava/lang/Object;J)V
    //   2770: goto -241 -> 2529
    //   2773: aload 30
    //   2775: aload 23
    //   2777: lload 17
    //   2779: invokestatic 412	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2782: invokevirtual 433	com/alibaba/fastjson/parser/deserializer/FieldDeserializer:setValue	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   2785: goto -256 -> 2529
    //   2788: aload 29
    //   2790: getstatic 253	java/lang/Float:TYPE	Ljava/lang/Class;
    //   2793: if_acmpeq +10 -> 2803
    //   2796: aload 29
    //   2798: ldc 252
    //   2800: if_acmpne +50 -> 2850
    //   2803: aload 28
    //   2805: getfield 421	com/alibaba/fastjson/util/FieldInfo:fieldAccess	Z
    //   2808: ifeq +23 -> 2831
    //   2811: aload 29
    //   2813: getstatic 253	java/lang/Float:TYPE	Ljava/lang/Class;
    //   2816: if_acmpne +15 -> 2831
    //   2819: aload 30
    //   2821: aload 23
    //   2823: fload 9
    //   2825: invokevirtual 439	com/alibaba/fastjson/parser/deserializer/FieldDeserializer:setValue	(Ljava/lang/Object;F)V
    //   2828: goto -299 -> 2529
    //   2831: aload 30
    //   2833: aload 23
    //   2835: new 252	java/lang/Float
    //   2838: dup
    //   2839: fload 9
    //   2841: invokespecial 415	java/lang/Float:<init>	(F)V
    //   2844: invokevirtual 433	com/alibaba/fastjson/parser/deserializer/FieldDeserializer:setValue	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   2847: goto -318 -> 2529
    //   2850: aload 29
    //   2852: getstatic 260	java/lang/Double:TYPE	Ljava/lang/Class;
    //   2855: if_acmpeq +11 -> 2866
    //   2858: aload 29
    //   2860: ldc_w 259
    //   2863: if_acmpne +50 -> 2913
    //   2866: aload 28
    //   2868: getfield 421	com/alibaba/fastjson/util/FieldInfo:fieldAccess	Z
    //   2871: ifeq +23 -> 2894
    //   2874: aload 29
    //   2876: getstatic 260	java/lang/Double:TYPE	Ljava/lang/Class;
    //   2879: if_acmpne +15 -> 2894
    //   2882: aload 30
    //   2884: aload 23
    //   2886: dload 5
    //   2888: invokevirtual 442	com/alibaba/fastjson/parser/deserializer/FieldDeserializer:setValue	(Ljava/lang/Object;D)V
    //   2891: goto -362 -> 2529
    //   2894: aload 30
    //   2896: aload 23
    //   2898: new 259	java/lang/Double
    //   2901: dup
    //   2902: dload 5
    //   2904: invokespecial 418	java/lang/Double:<init>	(D)V
    //   2907: invokevirtual 433	com/alibaba/fastjson/parser/deserializer/FieldDeserializer:setValue	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   2910: goto -381 -> 2529
    //   2913: aload 30
    //   2915: aload 23
    //   2917: aload 4
    //   2919: invokevirtual 433	com/alibaba/fastjson/parser/deserializer/FieldDeserializer:setValue	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   2922: goto -393 -> 2529
    //   2925: aload 30
    //   2927: aload 23
    //   2929: aload 4
    //   2931: invokevirtual 433	com/alibaba/fastjson/parser/deserializer/FieldDeserializer:setValue	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   2934: goto -405 -> 2529
    //   2937: aload_0
    //   2938: aload_1
    //   2939: aload 31
    //   2941: aload 23
    //   2943: aload_2
    //   2944: aload 24
    //   2946: invokespecial 445	com/alibaba/fastjson/parser/JavaBeanDeserializer:parseField	(Lcom/alibaba/fastjson/parser/DefaultJSONParser;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/reflect/Type;Ljava/util/Map;)Z
    //   2949: ifne +29 -> 2978
    //   2952: aload 32
    //   2954: getfield 104	com/alibaba/fastjson/parser/JSONLexer:token	I
    //   2957: bipush 13
    //   2959: if_icmpne +539 -> 3498
    //   2962: aload 32
    //   2964: invokevirtual 162	com/alibaba/fastjson/parser/JSONLexer:nextToken	()V
    //   2967: aload 22
    //   2969: astore 4
    //   2971: aload 23
    //   2973: astore 22
    //   2975: goto -2382 -> 593
    //   2978: aload 32
    //   2980: getfield 104	com/alibaba/fastjson/parser/JSONLexer:token	I
    //   2983: bipush 17
    //   2985: if_icmpne -515 -> 2470
    //   2988: new 181	com/alibaba/fastjson/JSONException
    //   2991: dup
    //   2992: ldc_w 447
    //   2995: invokespecial 187	com/alibaba/fastjson/JSONException:<init>	(Ljava/lang/String;)V
    //   2998: athrow
    //   2999: aload 32
    //   3001: getfield 104	com/alibaba/fastjson/parser/JSONLexer:token	I
    //   3004: bipush 13
    //   3006: if_icmpne +21 -> 3027
    //   3009: aload 32
    //   3011: bipush 16
    //   3013: invokevirtual 108	com/alibaba/fastjson/parser/JSONLexer:nextToken	(I)V
    //   3016: aload 22
    //   3018: astore 4
    //   3020: aload 23
    //   3022: astore 22
    //   3024: goto -2431 -> 593
    //   3027: aload 32
    //   3029: getfield 104	com/alibaba/fastjson/parser/JSONLexer:token	I
    //   3032: bipush 18
    //   3034: if_icmpeq +12 -> 3046
    //   3037: aload 32
    //   3039: getfield 104	com/alibaba/fastjson/parser/JSONLexer:token	I
    //   3042: iconst_1
    //   3043: if_icmpne +455 -> 3498
    //   3046: new 181	com/alibaba/fastjson/JSONException
    //   3049: dup
    //   3050: new 346	java/lang/StringBuilder
    //   3053: dup
    //   3054: invokespecial 347	java/lang/StringBuilder:<init>	()V
    //   3057: ldc_w 449
    //   3060: invokevirtual 352	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3063: aload 32
    //   3065: getfield 104	com/alibaba/fastjson/parser/JSONLexer:token	I
    //   3068: invokestatic 357	com/alibaba/fastjson/parser/JSONToken:name	(I)Ljava/lang/String;
    //   3071: invokevirtual 352	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3074: invokevirtual 358	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3077: invokespecial 187	com/alibaba/fastjson/JSONException:<init>	(Ljava/lang/String;)V
    //   3080: athrow
    //   3081: aload_0
    //   3082: getfield 67	com/alibaba/fastjson/parser/JavaBeanDeserializer:fieldDeserializers	[Lcom/alibaba/fastjson/parser/deserializer/FieldDeserializer;
    //   3085: arraylength
    //   3086: istore 12
    //   3088: iload 12
    //   3090: anewarray 4	java/lang/Object
    //   3093: astore_2
    //   3094: iconst_0
    //   3095: istore 11
    //   3097: iload 11
    //   3099: iload 12
    //   3101: if_icmpge +36 -> 3137
    //   3104: aload_2
    //   3105: iload 11
    //   3107: aload 24
    //   3109: aload_0
    //   3110: getfield 67	com/alibaba/fastjson/parser/JavaBeanDeserializer:fieldDeserializers	[Lcom/alibaba/fastjson/parser/deserializer/FieldDeserializer;
    //   3113: iload 11
    //   3115: aaload
    //   3116: getfield 198	com/alibaba/fastjson/parser/deserializer/FieldDeserializer:fieldInfo	Lcom/alibaba/fastjson/util/FieldInfo;
    //   3119: getfield 73	com/alibaba/fastjson/util/FieldInfo:name	Ljava/lang/String;
    //   3122: invokeinterface 453 2 0
    //   3127: aastore
    //   3128: iload 11
    //   3130: iconst_1
    //   3131: iadd
    //   3132: istore 11
    //   3134: goto -37 -> 3097
    //   3137: aload_0
    //   3138: getfield 50	com/alibaba/fastjson/parser/JavaBeanDeserializer:beanInfo	Lcom/alibaba/fastjson/parser/JavaBeanInfo;
    //   3141: getfield 457	com/alibaba/fastjson/parser/JavaBeanInfo:creatorConstructor	Ljava/lang/reflect/Constructor;
    //   3144: astore_3
    //   3145: aload_3
    //   3146: ifnull +76 -> 3222
    //   3149: aload_0
    //   3150: getfield 50	com/alibaba/fastjson/parser/JavaBeanDeserializer:beanInfo	Lcom/alibaba/fastjson/parser/JavaBeanInfo;
    //   3153: getfield 457	com/alibaba/fastjson/parser/JavaBeanInfo:creatorConstructor	Ljava/lang/reflect/Constructor;
    //   3156: aload_2
    //   3157: invokevirtual 463	java/lang/reflect/Constructor:newInstance	([Ljava/lang/Object;)Ljava/lang/Object;
    //   3160: astore 23
    //   3162: aload 4
    //   3164: ifnull +10 -> 3174
    //   3167: aload 4
    //   3169: aload 23
    //   3171: putfield 191	com/alibaba/fastjson/parser/ParseContext:object	Ljava/lang/Object;
    //   3174: aload_1
    //   3175: aload 26
    //   3177: invokevirtual 129	com/alibaba/fastjson/parser/DefaultJSONParser:setContext	(Lcom/alibaba/fastjson/parser/ParseContext;)V
    //   3180: aload 23
    //   3182: areturn
    //   3183: astore_2
    //   3184: new 181	com/alibaba/fastjson/JSONException
    //   3187: dup
    //   3188: new 346	java/lang/StringBuilder
    //   3191: dup
    //   3192: invokespecial 347	java/lang/StringBuilder:<init>	()V
    //   3195: ldc_w 465
    //   3198: invokevirtual 352	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3201: aload_0
    //   3202: getfield 50	com/alibaba/fastjson/parser/JavaBeanDeserializer:beanInfo	Lcom/alibaba/fastjson/parser/JavaBeanInfo;
    //   3205: getfield 457	com/alibaba/fastjson/parser/JavaBeanInfo:creatorConstructor	Ljava/lang/reflect/Constructor;
    //   3208: invokevirtual 468	java/lang/reflect/Constructor:toGenericString	()Ljava/lang/String;
    //   3211: invokevirtual 352	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3214: invokevirtual 358	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3217: aload_2
    //   3218: invokespecial 430	com/alibaba/fastjson/JSONException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   3221: athrow
    //   3222: aload_0
    //   3223: getfield 50	com/alibaba/fastjson/parser/JavaBeanDeserializer:beanInfo	Lcom/alibaba/fastjson/parser/JavaBeanInfo;
    //   3226: getfield 472	com/alibaba/fastjson/parser/JavaBeanInfo:factoryMethod	Ljava/lang/reflect/Method;
    //   3229: astore_3
    //   3230: aload 22
    //   3232: astore 23
    //   3234: aload_3
    //   3235: ifnull -73 -> 3162
    //   3238: aload_0
    //   3239: getfield 50	com/alibaba/fastjson/parser/JavaBeanDeserializer:beanInfo	Lcom/alibaba/fastjson/parser/JavaBeanInfo;
    //   3242: getfield 472	com/alibaba/fastjson/parser/JavaBeanInfo:factoryMethod	Ljava/lang/reflect/Method;
    //   3245: aconst_null
    //   3246: aload_2
    //   3247: invokevirtual 478	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   3250: astore 23
    //   3252: goto -90 -> 3162
    //   3255: astore_2
    //   3256: new 181	com/alibaba/fastjson/JSONException
    //   3259: dup
    //   3260: new 346	java/lang/StringBuilder
    //   3263: dup
    //   3264: invokespecial 347	java/lang/StringBuilder:<init>	()V
    //   3267: ldc_w 480
    //   3270: invokevirtual 352	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3273: aload_0
    //   3274: getfield 50	com/alibaba/fastjson/parser/JavaBeanDeserializer:beanInfo	Lcom/alibaba/fastjson/parser/JavaBeanInfo;
    //   3277: getfield 472	com/alibaba/fastjson/parser/JavaBeanInfo:factoryMethod	Ljava/lang/reflect/Method;
    //   3280: invokevirtual 481	java/lang/reflect/Method:toString	()Ljava/lang/String;
    //   3283: invokevirtual 352	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3286: invokevirtual 358	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3289: aload_2
    //   3290: invokespecial 430	com/alibaba/fastjson/JSONException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   3293: athrow
    //   3294: astore_2
    //   3295: aload 4
    //   3297: astore 22
    //   3299: goto -2977 -> 322
    //   3302: aload 27
    //   3304: astore 23
    //   3306: aload 25
    //   3308: astore 24
    //   3310: goto -861 -> 2449
    //   3313: aload 22
    //   3315: astore 4
    //   3317: goto +197 -> 3514
    //   3320: iconst_0
    //   3321: istore 13
    //   3323: iconst_0
    //   3324: istore 11
    //   3326: iconst_0
    //   3327: istore 12
    //   3329: fconst_0
    //   3330: fstore 9
    //   3332: lconst_0
    //   3333: lstore 17
    //   3335: dload 7
    //   3337: dstore 5
    //   3339: goto -2808 -> 531
    //   3342: iconst_0
    //   3343: istore 13
    //   3345: iconst_0
    //   3346: istore 11
    //   3348: iconst_0
    //   3349: istore 12
    //   3351: fconst_0
    //   3352: fstore 9
    //   3354: lconst_0
    //   3355: lstore 17
    //   3357: dload 7
    //   3359: dstore 5
    //   3361: goto -2830 -> 531
    //   3364: iconst_0
    //   3365: istore 13
    //   3367: iconst_0
    //   3368: istore 11
    //   3370: iconst_0
    //   3371: istore 12
    //   3373: fconst_0
    //   3374: fstore 9
    //   3376: lconst_0
    //   3377: lstore 17
    //   3379: dload 7
    //   3381: dstore 5
    //   3383: goto -2852 -> 531
    //   3386: iconst_0
    //   3387: istore 13
    //   3389: iconst_0
    //   3390: istore 11
    //   3392: iconst_0
    //   3393: istore 12
    //   3395: fconst_0
    //   3396: fstore 9
    //   3398: lconst_0
    //   3399: lstore 17
    //   3401: dload 7
    //   3403: dstore 5
    //   3405: goto -2874 -> 531
    //   3408: iconst_0
    //   3409: istore 13
    //   3411: iconst_0
    //   3412: istore 11
    //   3414: iconst_0
    //   3415: istore 12
    //   3417: fconst_0
    //   3418: fstore 9
    //   3420: lconst_0
    //   3421: lstore 17
    //   3423: dload 7
    //   3425: dstore 5
    //   3427: goto -2896 -> 531
    //   3430: iconst_0
    //   3431: istore 13
    //   3433: aconst_null
    //   3434: astore 4
    //   3436: iconst_0
    //   3437: istore 12
    //   3439: goto -2908 -> 531
    //   3442: iconst_0
    //   3443: istore 13
    //   3445: iconst_0
    //   3446: istore 11
    //   3448: iconst_0
    //   3449: istore 12
    //   3451: fconst_0
    //   3452: fstore 9
    //   3454: lconst_0
    //   3455: lstore 17
    //   3457: dload 7
    //   3459: dstore 5
    //   3461: goto -2930 -> 531
    //   3464: iconst_0
    //   3465: istore 13
    //   3467: iconst_0
    //   3468: istore 11
    //   3470: iconst_0
    //   3471: istore 12
    //   3473: fconst_0
    //   3474: fstore 9
    //   3476: lconst_0
    //   3477: lstore 17
    //   3479: dload 7
    //   3481: dstore 5
    //   3483: goto -2952 -> 531
    //   3486: aconst_null
    //   3487: astore 29
    //   3489: aconst_null
    //   3490: astore 28
    //   3492: aconst_null
    //   3493: astore 30
    //   3495: goto -3080 -> 415
    //   3498: aload 22
    //   3500: astore 4
    //   3502: goto +12 -> 3514
    //   3505: goto -3429 -> 76
    //   3508: iconst_1
    //   3509: istore 11
    //   3511: goto -3350 -> 161
    //   3514: iload 14
    //   3516: iconst_1
    //   3517: iadd
    //   3518: istore 14
    //   3520: aload 4
    //   3522: astore 22
    //   3524: goto -3151 -> 373
    //   3527: iload 12
    //   3529: istore 13
    //   3531: iconst_0
    //   3532: istore 15
    //   3534: iload 11
    //   3536: istore 12
    //   3538: fconst_0
    //   3539: fstore 9
    //   3541: lconst_0
    //   3542: lstore 17
    //   3544: iload 15
    //   3546: istore 11
    //   3548: dload 7
    //   3550: dstore 5
    //   3552: goto -3021 -> 531
    //   3555: iload 15
    //   3557: bipush 16
    //   3559: if_icmpne -1887 -> 1672
    //   3562: aload 22
    //   3564: astore 4
    //   3566: goto -52 -> 3514
    //   3569: astore_2
    //   3570: aload 25
    //   3572: astore 23
    //   3574: goto -3252 -> 322
    //   3577: aconst_null
    //   3578: astore 31
    //   3580: goto -1224 -> 2356
    //   3583: astore_2
    //   3584: goto -3262 -> 322
    //   3587: astore_2
    //   3588: aload 22
    //   3590: astore 23
    //   3592: aload 4
    //   3594: astore 22
    //   3596: goto -3274 -> 322
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	3599	0	this	JavaBeanDeserializer
    //   0	3599	1	paramDefaultJSONParser	DefaultJSONParser
    //   0	3599	2	paramType	Type
    //   0	3599	3	paramObject1	Object
    //   0	3599	4	paramObject2	Object
    //   438	3113	5	d1	double
    //   434	3115	7	d2	double
    //   442	3098	9	f1	float
    //   431	684	10	f2	float
    //   161	3386	11	i	int
    //   28	3509	12	j	int
    //   425	3105	13	k	int
    //   363	3156	14	m	int
    //   419	3141	15	n	int
    //   360	18	16	i1	int
    //   450	3093	17	l1	long
    //   428	695	19	l2	long
    //   51	2375	21	bool	boolean
    //   80	3515	22	localObject1	Object
    //   320	3271	23	localObject2	Object
    //   83	3226	24	localObject3	Object
    //   77	3494	25	localObject4	Object
    //   57	3119	26	localParseContext	ParseContext
    //   549	2754	27	localObject5	Object
    //   402	3089	28	localObject6	Object
    //   413	3075	29	localClass	Class
    //   391	3103	30	localFieldDeserializer	FieldDeserializer
    //   2074	1505	31	localObject7	Object
    //   21	3043	32	localJSONLexer	JSONLexer
    // Exception table:
    //   from	to	target	type
    //   92	99	317	finally
    //   107	114	317	finally
    //   133	158	317	finally
    //   166	176	317	finally
    //   208	215	317	finally
    //   238	254	317	finally
    //   266	305	317	finally
    //   305	317	317	finally
    //   342	355	317	finally
    //   355	362	317	finally
    //   2638	2646	2681	java/lang/IllegalAccessException
    //   2653	2678	2681	java/lang/IllegalAccessException
    //   2715	2727	2681	java/lang/IllegalAccessException
    //   2730	2738	2681	java/lang/IllegalAccessException
    //   2745	2770	2681	java/lang/IllegalAccessException
    //   2773	2785	2681	java/lang/IllegalAccessException
    //   2788	2796	2681	java/lang/IllegalAccessException
    //   2803	2828	2681	java/lang/IllegalAccessException
    //   2831	2847	2681	java/lang/IllegalAccessException
    //   2850	2858	2681	java/lang/IllegalAccessException
    //   2866	2891	2681	java/lang/IllegalAccessException
    //   2894	2910	2681	java/lang/IllegalAccessException
    //   2913	2922	2681	java/lang/IllegalAccessException
    //   3149	3162	3183	java/lang/Exception
    //   3238	3252	3255	java/lang/Exception
    //   623	633	3294	finally
    //   384	393	3569	finally
    //   397	404	3569	finally
    //   408	415	3569	finally
    //   461	468	3569	finally
    //   472	480	3569	finally
    //   491	500	3569	finally
    //   504	512	3569	finally
    //   540	551	3569	finally
    //   560	567	3569	finally
    //   578	585	3569	finally
    //   668	678	3569	finally
    //   689	697	3569	finally
    //   708	717	3569	finally
    //   721	729	3569	finally
    //   767	777	3569	finally
    //   795	804	3569	finally
    //   808	816	3569	finally
    //   842	852	3569	finally
    //   863	871	3569	finally
    //   882	894	3569	finally
    //   898	906	3569	finally
    //   932	942	3569	finally
    //   953	961	3569	finally
    //   972	981	3569	finally
    //   985	993	3569	finally
    //   1031	1041	3569	finally
    //   1052	1060	3569	finally
    //   1072	1081	3569	finally
    //   1085	1093	3569	finally
    //   1130	1140	3569	finally
    //   1151	1159	3569	finally
    //   1163	1178	3569	finally
    //   1182	1191	3569	finally
    //   1195	1203	3569	finally
    //   1213	1222	3569	finally
    //   1233	1243	3569	finally
    //   1262	1271	3569	finally
    //   1275	1283	3569	finally
    //   1309	1319	3569	finally
    //   1338	1347	3569	finally
    //   1351	1359	3569	finally
    //   1385	1395	3569	finally
    //   1414	1423	3569	finally
    //   1427	1435	3569	finally
    //   1461	1471	3569	finally
    //   1490	1499	3569	finally
    //   1503	1511	3569	finally
    //   1537	1547	3569	finally
    //   1566	1575	3569	finally
    //   1579	1587	3569	finally
    //   1613	1623	3569	finally
    //   1634	1647	3569	finally
    //   1684	1691	3569	finally
    //   1695	1702	3569	finally
    //   1712	1719	3569	finally
    //   1723	1734	3569	finally
    //   1738	1745	3569	finally
    //   1749	1756	3569	finally
    //   1760	1770	3569	finally
    //   1774	1785	3569	finally
    //   1789	1800	3569	finally
    //   1804	1810	3569	finally
    //   1814	1821	3569	finally
    //   1825	1831	3569	finally
    //   1838	1852	3569	finally
    //   1856	1861	3569	finally
    //   1868	1879	3569	finally
    //   1886	1893	3569	finally
    //   1897	1902	3569	finally
    //   1909	1916	3569	finally
    //   1920	1926	3569	finally
    //   1933	1947	3569	finally
    //   1951	1956	3569	finally
    //   1963	1978	3569	finally
    //   1982	1987	3569	finally
    //   1994	2026	3569	finally
    //   2030	2037	3569	finally
    //   2041	2051	3569	finally
    //   2088	2095	3569	finally
    //   2099	2108	3569	finally
    //   2112	2119	3569	finally
    //   2123	2130	3569	finally
    //   2134	2141	3569	finally
    //   2145	2160	3569	finally
    //   2164	2174	3569	finally
    //   2178	2183	3569	finally
    //   2198	2214	3569	finally
    //   2230	2244	3569	finally
    //   2248	2253	3569	finally
    //   2266	2275	3569	finally
    //   2279	2290	3569	finally
    //   2294	2306	3569	finally
    //   2330	2341	3569	finally
    //   2345	2356	3569	finally
    //   2386	2394	3569	finally
    //   2403	2417	3569	finally
    //   2434	2445	3569	finally
    //   2459	2470	3583	finally
    //   2470	2480	3583	finally
    //   2492	2500	3583	finally
    //   2507	2514	3583	finally
    //   2514	2529	3583	finally
    //   2529	2538	3583	finally
    //   2549	2557	3583	finally
    //   2564	2571	3583	finally
    //   2574	2582	3583	finally
    //   2589	2600	3583	finally
    //   2603	2611	3583	finally
    //   2619	2630	3583	finally
    //   2638	2646	3583	finally
    //   2653	2678	3583	finally
    //   2682	2715	3583	finally
    //   2715	2727	3583	finally
    //   2730	2738	3583	finally
    //   2745	2770	3583	finally
    //   2773	2785	3583	finally
    //   2788	2796	3583	finally
    //   2803	2828	3583	finally
    //   2831	2847	3583	finally
    //   2850	2858	3583	finally
    //   2866	2891	3583	finally
    //   2894	2910	3583	finally
    //   2913	2922	3583	finally
    //   2925	2934	3583	finally
    //   2937	2967	3583	finally
    //   2978	2999	3583	finally
    //   2999	3016	3583	finally
    //   3027	3046	3583	finally
    //   3046	3081	3583	finally
    //   607	615	3587	finally
    //   3081	3094	3587	finally
    //   3104	3128	3587	finally
    //   3137	3145	3587	finally
    //   3149	3162	3587	finally
    //   3184	3222	3587	finally
    //   3222	3230	3587	finally
    //   3238	3252	3587	finally
    //   3256	3294	3587	finally
  }
  
  private <T> T deserialzeArrayMapping(DefaultJSONParser paramDefaultJSONParser, Type paramType, Object paramObject1, Object paramObject2)
  {
    paramObject2 = paramDefaultJSONParser.lexer;
    Object localObject = createInstance(paramDefaultJSONParser, paramType);
    int k = this.sortedFieldDeserializers.length;
    int i = 0;
    if (i < k) {
      if (i != k - 1) {
        break label1828;
      }
    }
    label532:
    label543:
    label1828:
    for (int j = 93;; j = 44)
    {
      FieldDeserializer localFieldDeserializer = this.sortedFieldDeserializers[i];
      FieldInfo localFieldInfo = localFieldDeserializer.fieldInfo;
      paramType = localFieldInfo.fieldClass;
      char c;
      for (;;)
      {
        try
        {
          if (paramType != Integer.TYPE) {
            break label312;
          }
          j = (int)paramObject2.scanLongValue();
          if (localFieldInfo.fieldAccess)
          {
            localFieldInfo.field.setInt(localObject, j);
            if (paramObject2.ch != ',') {
              break;
            }
            j = paramObject2.bp + 1;
            paramObject2.bp = j;
            if (j >= paramObject2.len)
            {
              c = '\032';
              paramObject2.ch = c;
              paramObject2.token = 16;
              break label1819;
            }
          }
          else
          {
            localFieldDeserializer.setValue(localObject, new Integer(j));
            continue;
          }
          c = paramObject2.text.charAt(j);
        }
        catch (IllegalAccessException paramDefaultJSONParser)
        {
          throw new JSONException("set " + localFieldInfo.name + "error", paramDefaultJSONParser);
        }
      }
      if (paramObject2.ch == ']')
      {
        j = paramObject2.bp + 1;
        paramObject2.bp = j;
        if (j >= paramObject2.len) {}
        for (c = '\032';; c = paramObject2.text.charAt(j))
        {
          paramObject2.ch = c;
          paramObject2.token = 15;
          break;
        }
      }
      paramObject2.nextToken();
      break label1819;
      label312:
      if (paramType == String.class)
      {
        if (paramObject2.ch == '"')
        {
          paramType = paramObject2.scanStringValue('"');
          if (!localFieldInfo.fieldAccess) {
            break label532;
          }
          localFieldInfo.field.set(localObject, paramType);
          label355:
          if (paramObject2.ch != ',') {
            break label558;
          }
          j = paramObject2.bp + 1;
          paramObject2.bp = j;
          if (j < paramObject2.len) {
            break label543;
          }
        }
        for (c = '\032';; c = paramObject2.text.charAt(j))
        {
          paramObject2.ch = c;
          paramObject2.token = 16;
          break label1819;
          if ((paramObject2.ch == 'n') && (paramObject2.text.startsWith("null", paramObject2.bp)))
          {
            paramObject2.bp += 4;
            j = paramObject2.bp;
            if (paramObject2.bp >= paramObject2.len) {}
            for (c = '\032';; c = paramObject2.text.charAt(j))
            {
              paramObject2.ch = c;
              paramType = null;
              break;
            }
          }
          throw new JSONException("not match string. feild : " + paramObject1);
          localFieldDeserializer.setValue(localObject, paramType);
          break label355;
        }
        if (paramObject2.ch == ']')
        {
          j = paramObject2.bp + 1;
          paramObject2.bp = j;
          if (j >= paramObject2.len) {}
          for (c = '\032';; c = paramObject2.text.charAt(j))
          {
            paramObject2.ch = c;
            paramObject2.token = 15;
            break;
          }
        }
        paramObject2.nextToken();
      }
      else if (paramType == Long.TYPE)
      {
        long l = paramObject2.scanLongValue();
        if (localFieldInfo.fieldAccess)
        {
          localFieldInfo.field.setLong(localObject, l);
          if (paramObject2.ch != ',') {
            break label763;
          }
          j = paramObject2.bp + 1;
          paramObject2.bp = j;
          if (j < paramObject2.len) {
            break label748;
          }
        }
        label748:
        for (c = '\032';; c = paramObject2.text.charAt(j))
        {
          paramObject2.ch = c;
          paramObject2.token = 16;
          break label1819;
          localFieldDeserializer.setValue(localObject, new Long(l));
          break;
        }
        label763:
        if (paramObject2.ch == ']')
        {
          j = paramObject2.bp + 1;
          paramObject2.bp = j;
          if (j >= paramObject2.len) {}
          for (c = '\032';; c = paramObject2.text.charAt(j))
          {
            paramObject2.ch = c;
            paramObject2.token = 15;
            break;
          }
        }
        paramObject2.nextToken();
      }
      else if (paramType == Boolean.TYPE)
      {
        boolean bool = paramObject2.scanBoolean();
        if (localFieldInfo.fieldAccess)
        {
          localFieldInfo.field.setBoolean(localObject, bool);
          if (paramObject2.ch != ',') {
            break label964;
          }
          j = paramObject2.bp + 1;
          paramObject2.bp = j;
          if (j < paramObject2.len) {
            break label949;
          }
        }
        for (c = '\032';; c = paramObject2.text.charAt(j))
        {
          paramObject2.ch = c;
          paramObject2.token = 16;
          break label1819;
          localFieldDeserializer.setValue(localObject, Boolean.valueOf(bool));
          break;
        }
        label964:
        if (paramObject2.ch == ']')
        {
          j = paramObject2.bp + 1;
          paramObject2.bp = j;
          if (j >= paramObject2.len) {}
          for (c = '\032';; c = paramObject2.text.charAt(j))
          {
            paramObject2.ch = c;
            paramObject2.token = 15;
            break;
          }
        }
        paramObject2.nextToken();
      }
      else if (paramType.isEnum())
      {
        j = paramObject2.ch;
        String str;
        if (j == 34)
        {
          str = paramObject2.scanSymbol(paramDefaultJSONParser.symbolTable);
          if (str == null)
          {
            paramType = null;
            localFieldDeserializer.setValue(localObject, paramType);
            if (paramObject2.ch != ',') {
              break label1252;
            }
            j = paramObject2.bp + 1;
            paramObject2.bp = j;
            if (j < paramObject2.len) {
              break label1237;
            }
          }
        }
        label1237:
        for (c = '\032';; c = paramObject2.text.charAt(j))
        {
          paramObject2.ch = c;
          paramObject2.token = 16;
          break label1819;
          paramType = Enum.valueOf(paramType, str);
          break;
          if ((j >= 48) && (j <= 57))
          {
            j = (int)paramObject2.scanLongValue();
            paramType = ((EnumDeserializer)((DefaultFieldDeserializer)localFieldDeserializer).getFieldValueDeserilizer(paramDefaultJSONParser.config)).values[j];
            break;
          }
          throw new JSONException("illegal enum." + paramObject2.info());
        }
        label1252:
        if (paramObject2.ch == ']')
        {
          j = paramObject2.bp + 1;
          paramObject2.bp = j;
          if (j >= paramObject2.len) {}
          for (c = '\032';; c = paramObject2.text.charAt(j))
          {
            paramObject2.ch = c;
            paramObject2.token = 15;
            break;
          }
        }
        paramObject2.nextToken();
      }
      else if ((paramType == Date.class) && (paramObject2.ch == '1'))
      {
        localFieldDeserializer.setValue(localObject, new Date(paramObject2.scanLongValue()));
        if (paramObject2.ch == ',')
        {
          j = paramObject2.bp + 1;
          paramObject2.bp = j;
          if (j >= paramObject2.len) {}
          for (c = '\032';; c = paramObject2.text.charAt(j))
          {
            paramObject2.ch = c;
            paramObject2.token = 16;
            break;
          }
        }
        if (paramObject2.ch == ']')
        {
          j = paramObject2.bp + 1;
          paramObject2.bp = j;
          if (j >= paramObject2.len) {}
          for (c = '\032';; c = paramObject2.text.charAt(j))
          {
            paramObject2.ch = c;
            paramObject2.token = 15;
            break;
          }
        }
        paramObject2.nextToken();
      }
      else
      {
        int m;
        if (paramObject2.ch == '[')
        {
          m = paramObject2.bp + 1;
          paramObject2.bp = m;
          if (m >= paramObject2.len)
          {
            c = '\032';
            paramObject2.ch = c;
            paramObject2.token = 14;
          }
        }
        for (;;)
        {
          localFieldDeserializer.parseField(paramDefaultJSONParser, localObject, localFieldInfo.fieldType, null);
          if (j != 93) {
            break label1711;
          }
          if (paramObject2.token == 15) {
            break label1819;
          }
          throw new JSONException("syntax error");
          c = paramObject2.text.charAt(m);
          break;
          if (paramObject2.ch == '{')
          {
            m = paramObject2.bp + 1;
            paramObject2.bp = m;
            if (m >= paramObject2.len) {}
            for (c = '\032';; c = paramObject2.text.charAt(m))
            {
              paramObject2.ch = c;
              paramObject2.token = 12;
              break;
            }
          }
          paramObject2.nextToken();
        }
        if ((j == 44) && (paramObject2.token != 16))
        {
          throw new JSONException("syntax error");
          if (paramObject2.ch == ',')
          {
            i = paramObject2.bp + 1;
            paramObject2.bp = i;
            if (i >= paramObject2.len) {}
            for (c = '\032';; c = paramObject2.text.charAt(i))
            {
              paramObject2.ch = c;
              paramObject2.token = 16;
              return localObject;
            }
          }
          paramObject2.nextToken();
          return localObject;
        }
      }
      label558:
      label949:
      i += 1;
      label1711:
      break;
    }
  }
  
  private boolean parseField(DefaultJSONParser paramDefaultJSONParser, String paramString, Object paramObject, Type paramType, Map<String, Object> paramMap)
  {
    JSONLexer localJSONLexer = paramDefaultJSONParser.lexer;
    Object localObject2 = getFieldDeserializer(paramString);
    Object localObject1 = localObject2;
    boolean bool;
    Object localObject3;
    int j;
    Object localObject4;
    Class localClass;
    if (localObject2 == null)
    {
      bool = paramString.startsWith("is");
      localObject3 = this.sortedFieldDeserializers;
      j = localObject3.length;
      i = 0;
      localObject1 = localObject2;
      if (i < j)
      {
        localObject1 = localObject3[i];
        localObject4 = ((FieldDeserializer)localObject1).fieldInfo;
        localClass = ((FieldInfo)localObject4).fieldClass;
        localObject4 = ((FieldInfo)localObject4).name;
        if (!((String)localObject4).equalsIgnoreCase(paramString)) {
          break label217;
        }
      }
    }
    label93:
    int i = Feature.SupportNonPublicField.mask;
    localObject2 = localObject1;
    if (localObject1 == null) {
      if ((paramDefaultJSONParser.lexer.features & i) == 0)
      {
        localObject2 = localObject1;
        if ((i & this.beanInfo.parserFeatures) == 0) {}
      }
      else
      {
        if (this.extraFieldDeserializers == null)
        {
          localObject2 = new ConcurrentHashMap(1, 0.75F, 1);
          localObject3 = this.clazz.getDeclaredFields();
          j = localObject3.length;
          i = 0;
          label178:
          if (i < j)
          {
            localClass = localObject3[i];
            localObject4 = localClass.getName();
            if (getFieldDeserializer((String)localObject4) != null) {}
            for (;;)
            {
              i += 1;
              break label178;
              label217:
              if ((bool) && ((localClass == Boolean.TYPE) || (localClass == Boolean.class)) && (((String)localObject4).equalsIgnoreCase(paramString.substring(2)))) {
                break label93;
              }
              i += 1;
              break;
              int k = localClass.getModifiers();
              if (((k & 0x10) == 0) && ((k & 0x8) == 0)) {
                ((ConcurrentHashMap)localObject2).put(localObject4, localClass);
              }
            }
          }
          this.extraFieldDeserializers = ((ConcurrentMap)localObject2);
        }
        localObject3 = this.extraFieldDeserializers.get(paramString);
        localObject2 = localObject1;
        if (localObject3 != null)
        {
          if (!(localObject3 instanceof FieldDeserializer)) {
            break label354;
          }
          localObject2 = (FieldDeserializer)localObject3;
        }
      }
    }
    while (localObject2 == null)
    {
      parseExtra(paramDefaultJSONParser, paramObject, paramString);
      return false;
      label354:
      localObject1 = (Field)localObject3;
      ((Field)localObject1).setAccessible(true);
      localObject1 = new FieldInfo(paramString, ((Field)localObject1).getDeclaringClass(), ((Field)localObject1).getType(), ((Field)localObject1).getGenericType(), (Field)localObject1, 0, 0);
      localObject2 = new DefaultFieldDeserializer(paramDefaultJSONParser.config, this.clazz, (FieldInfo)localObject1);
      this.extraFieldDeserializers.put(paramString, localObject2);
    }
    localJSONLexer.nextTokenWithChar(':');
    ((FieldDeserializer)localObject2).parseField(paramDefaultJSONParser, paramObject, paramType, paramMap);
    return true;
  }
  
  protected Object createInstance(DefaultJSONParser paramDefaultJSONParser, Type paramType)
  {
    int i = 0;
    Object localObject;
    if (((paramType instanceof Class)) && (this.clazz.isInterface()))
    {
      paramType = (Class)paramType;
      localObject = Thread.currentThread().getContextClassLoader();
      if ((paramDefaultJSONParser.lexer.features & Feature.OrderedField.mask) != 0) {}
      for (boolean bool = true;; bool = false)
      {
        paramDefaultJSONParser = new JSONObject(bool);
        localObject = Proxy.newProxyInstance((ClassLoader)localObject, new Class[] { paramType }, paramDefaultJSONParser);
        return localObject;
      }
    }
    if (this.beanInfo.defaultConstructor == null) {
      return null;
    }
    label259:
    for (;;)
    {
      try
      {
        paramType = this.beanInfo.defaultConstructor;
        if (this.beanInfo.defaultConstructorParameterSize == 0)
        {
          paramType = paramType.newInstance(new Object[0]);
          localObject = paramType;
          if (paramDefaultJSONParser == null) {
            break;
          }
          localObject = paramType;
          if ((paramDefaultJSONParser.lexer.features & Feature.InitStringFieldAsEmpty.mask) == 0) {
            break;
          }
          paramDefaultJSONParser = this.beanInfo.fields;
          int j = paramDefaultJSONParser.length;
          localObject = paramType;
          if (i >= j) {
            break;
          }
          localObject = paramDefaultJSONParser[i];
          if (((FieldInfo)localObject).fieldClass != String.class) {
            break label259;
          }
          ((FieldInfo)localObject).set(paramType, "");
          break label259;
        }
        paramType = paramType.newInstance(new Object[] { paramDefaultJSONParser.contex.object });
        continue;
        i += 1;
      }
      catch (Exception paramDefaultJSONParser)
      {
        throw new JSONException("create instance error, class " + this.clazz.getName(), paramDefaultJSONParser);
      }
    }
  }
  
  public Object createInstance(Map<String, Object> paramMap, ParserConfig paramParserConfig)
    throws IllegalAccessException, IllegalArgumentException, InvocationTargetException
  {
    Object localObject1 = null;
    Object localObject2;
    if (this.beanInfo.creatorConstructor == null)
    {
      localObject1 = createInstance(null, this.clazz);
      paramMap = paramMap.entrySet().iterator();
      while (paramMap.hasNext())
      {
        Object localObject3 = (Map.Entry)paramMap.next();
        localObject2 = getFieldDeserializer((String)((Map.Entry)localObject3).getKey());
        if (localObject2 != null)
        {
          localObject3 = ((Map.Entry)localObject3).getValue();
          Method localMethod = ((FieldDeserializer)localObject2).fieldInfo.method;
          if (localMethod != null) {
            localMethod.invoke(localObject1, new Object[] { TypeUtils.cast(localObject3, localMethod.getGenericParameterTypes()[0], paramParserConfig) });
          } else {
            ((FieldDeserializer)localObject2).fieldInfo.field.set(localObject1, TypeUtils.cast(localObject3, ((FieldDeserializer)localObject2).fieldInfo.fieldType, paramParserConfig));
          }
        }
      }
      paramMap = localObject1;
    }
    do
    {
      return paramMap;
      localObject2 = this.beanInfo.fields;
      int j = localObject2.length;
      paramParserConfig = new Object[j];
      int i = 0;
      while (i < j)
      {
        paramParserConfig[i] = paramMap.get(localObject2[i].name);
        i += 1;
      }
      paramMap = localObject1;
    } while (this.beanInfo.creatorConstructor == null);
    try
    {
      paramMap = this.beanInfo.creatorConstructor.newInstance(paramParserConfig);
      return paramMap;
    }
    catch (Exception paramMap)
    {
      throw new JSONException("create instance error, " + this.beanInfo.creatorConstructor.toGenericString(), paramMap);
    }
  }
  
  public <T> T deserialze(DefaultJSONParser paramDefaultJSONParser, Type paramType, Object paramObject)
  {
    return deserialze(paramDefaultJSONParser, paramType, paramObject, null);
  }
  
  protected FieldDeserializer getFieldDeserializer(String paramString)
  {
    int i = 0;
    if (paramString == null) {
      return null;
    }
    if (this.beanInfo.ordered)
    {
      while (i < this.sortedFieldDeserializers.length)
      {
        if (this.sortedFieldDeserializers[i].fieldInfo.name.equalsIgnoreCase(paramString)) {
          return this.sortedFieldDeserializers[i];
        }
        i += 1;
      }
      return null;
    }
    int j = this.sortedFieldDeserializers.length;
    i = 0;
    j -= 1;
    while (i <= j)
    {
      int k = i + j >>> 1;
      int m = this.sortedFieldDeserializers[k].fieldInfo.name.compareTo(paramString);
      if (m < 0) {
        i = k + 1;
      } else if (m > 0) {
        j = k - 1;
      } else {
        return this.sortedFieldDeserializers[k];
      }
    }
    return null;
  }
  
  protected JavaBeanDeserializer getSeeAlso(ParserConfig paramParserConfig, JavaBeanInfo paramJavaBeanInfo, String paramString)
  {
    if (paramJavaBeanInfo.jsonType == null)
    {
      paramJavaBeanInfo = null;
      return paramJavaBeanInfo;
    }
    Class[] arrayOfClass = paramJavaBeanInfo.jsonType.seeAlso();
    int j = arrayOfClass.length;
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        break label104;
      }
      paramJavaBeanInfo = paramParserConfig.getDeserializer(arrayOfClass[i]);
      if ((paramJavaBeanInfo instanceof JavaBeanDeserializer))
      {
        paramJavaBeanInfo = (JavaBeanDeserializer)paramJavaBeanInfo;
        Object localObject = paramJavaBeanInfo.beanInfo;
        if (((JavaBeanInfo)localObject).typeName.equals(paramString)) {
          break;
        }
        localObject = getSeeAlso(paramParserConfig, (JavaBeanInfo)localObject, paramString);
        paramJavaBeanInfo = (JavaBeanInfo)localObject;
        if (localObject != null) {
          break;
        }
      }
      i += 1;
    }
    label104:
    return null;
  }
  
  void parseExtra(DefaultJSONParser paramDefaultJSONParser, Object paramObject, String paramString)
  {
    Object localObject1 = paramDefaultJSONParser.lexer;
    if ((paramDefaultJSONParser.lexer.features & Feature.IgnoreNotMatch.mask) == 0) {
      throw new JSONException("setter not found, class " + this.clazz.getName() + ", property " + paramString);
    }
    ((JSONLexer)localObject1).nextTokenWithChar(':');
    localObject1 = null;
    Object localObject2 = null;
    Object localObject3 = paramDefaultJSONParser.extraTypeProviders;
    if (localObject3 != null)
    {
      localObject3 = ((List)localObject3).iterator();
      for (localObject1 = localObject2; ((Iterator)localObject3).hasNext(); localObject1 = ((ExtraTypeProvider)((Iterator)localObject3).next()).getExtraType(paramObject, paramString)) {}
    }
    if (localObject1 == null)
    {
      localObject1 = paramDefaultJSONParser.parse();
      if (!(paramObject instanceof ExtraProcessable)) {
        break label178;
      }
      ((ExtraProcessable)paramObject).processExtra(paramString, localObject1);
    }
    for (;;)
    {
      return;
      localObject1 = paramDefaultJSONParser.parseObject((Type)localObject1);
      break;
      label178:
      paramDefaultJSONParser = paramDefaultJSONParser.extraProcessors;
      if (paramDefaultJSONParser != null)
      {
        paramDefaultJSONParser = paramDefaultJSONParser.iterator();
        while (paramDefaultJSONParser.hasNext()) {
          ((ExtraProcessor)paramDefaultJSONParser.next()).processExtra(paramObject, paramString, localObject1);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.alibaba.fastjson.parser.JavaBeanDeserializer
 * JD-Core Version:    0.7.0.1
 */