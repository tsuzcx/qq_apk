import android.content.Context;
import android.text.TextUtils;
import com.tencent.ims.intchk.AppInfo;
import com.tencent.ims.intchk.CheckItem;
import com.tencent.ims.intchk.CheckResult;
import com.tencent.ims.intchk.FetchCheckConfigReq;
import com.tencent.ims.intchk.FetchCheckConfigRsp;
import com.tencent.ims.intchk.ReportCheckResultReq;
import com.tencent.ims.intchk.ReportCheckResultRsp;
import com.tencent.ims.intchk.ReportStrikeResultReq;
import com.tencent.ims.intchk.ReqBody;
import com.tencent.ims.intchk.RspBody;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mqp.app.sec.MQPSecUtil;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public class aroa
  implements arnw.b, arny
{
  private static int ekx = 1;
  private arnx a;
  private int ekB;
  private String mAppVersion;
  private int mStrikeResult = 0;
  private int mStrikeType = 65535;
  private Map<Integer, aroa.a> oH;
  
  public aroa(arnx paramarnx)
  {
    arnw localarnw = paramarnx.a;
    if (localarnw != null) {
      localarnw.setNetTransportEventListener("intchk", this);
    }
    this.a = paramarnx;
  }
  
  /* Error */
  private void WD(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aload_1
    //   3: invokevirtual 61	java/lang/String:trim	()Ljava/lang/String;
    //   6: invokestatic 67	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   9: ifeq +4 -> 13
    //   12: return
    //   13: invokestatic 73	javax/xml/parsers/DocumentBuilderFactory:newInstance	()Ljavax/xml/parsers/DocumentBuilderFactory;
    //   16: astore_3
    //   17: aload_3
    //   18: invokevirtual 77	javax/xml/parsers/DocumentBuilderFactory:newDocumentBuilder	()Ljavax/xml/parsers/DocumentBuilder;
    //   21: new 79	java/io/ByteArrayInputStream
    //   24: dup
    //   25: aload_1
    //   26: invokevirtual 83	java/lang/String:getBytes	()[B
    //   29: invokespecial 86	java/io/ByteArrayInputStream:<init>	([B)V
    //   32: invokevirtual 92	javax/xml/parsers/DocumentBuilder:parse	(Ljava/io/InputStream;)Lorg/w3c/dom/Document;
    //   35: invokeinterface 98 1 0
    //   40: astore_3
    //   41: aload_0
    //   42: iconst_0
    //   43: putfield 34	aroa:mStrikeType	I
    //   46: aload_3
    //   47: ldc 100
    //   49: invokeinterface 106 2 0
    //   54: astore_1
    //   55: aload_1
    //   56: invokevirtual 61	java/lang/String:trim	()Ljava/lang/String;
    //   59: invokevirtual 110	java/lang/String:length	()I
    //   62: ifle +11 -> 73
    //   65: aload_0
    //   66: aload_1
    //   67: invokestatic 116	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   70: putfield 34	aroa:mStrikeType	I
    //   73: aload_0
    //   74: getfield 34	aroa:mStrikeType	I
    //   77: tableswitch	default:+342 -> 419, 1:+27->104, 2:+161->238, 3:+216->293
    //   105: getfield 118	aroa:oH	Ljava/util/Map;
    //   108: ifnull -96 -> 12
    //   111: aload_0
    //   112: getfield 118	aroa:oH	Ljava/util/Map;
    //   115: iconst_1
    //   116: invokestatic 122	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   119: invokeinterface 128 2 0
    //   124: ifeq +290 -> 414
    //   127: aload_0
    //   128: getfield 118	aroa:oH	Ljava/util/Map;
    //   131: iconst_1
    //   132: invokestatic 122	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   135: invokeinterface 132 2 0
    //   140: checkcast 10	aroa$a
    //   143: astore_1
    //   144: aload_1
    //   145: ifnull -133 -> 12
    //   148: new 134	javax/xml/transform/dom/DOMSource
    //   151: dup
    //   152: aload_3
    //   153: invokespecial 137	javax/xml/transform/dom/DOMSource:<init>	(Lorg/w3c/dom/Node;)V
    //   156: astore_3
    //   157: new 139	java/io/StringWriter
    //   160: dup
    //   161: invokespecial 140	java/io/StringWriter:<init>	()V
    //   164: astore_2
    //   165: new 142	javax/xml/transform/stream/StreamResult
    //   168: dup
    //   169: aload_2
    //   170: invokespecial 145	javax/xml/transform/stream/StreamResult:<init>	(Ljava/io/Writer;)V
    //   173: astore 4
    //   175: invokestatic 150	javax/xml/transform/TransformerFactory:newInstance	()Ljavax/xml/transform/TransformerFactory;
    //   178: invokevirtual 154	javax/xml/transform/TransformerFactory:newTransformer	()Ljavax/xml/transform/Transformer;
    //   181: aload_3
    //   182: aload 4
    //   184: invokevirtual 160	javax/xml/transform/Transformer:transform	(Ljavax/xml/transform/Source;Ljavax/xml/transform/Result;)V
    //   187: new 162	org/json/JSONObject
    //   190: dup
    //   191: invokespecial 163	org/json/JSONObject:<init>	()V
    //   194: astore_3
    //   195: aload_3
    //   196: ldc 165
    //   198: aload_2
    //   199: invokevirtual 168	java/io/StringWriter:toString	()Ljava/lang/String;
    //   202: invokevirtual 172	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   205: pop
    //   206: aload_1
    //   207: aload_3
    //   208: invokevirtual 173	org/json/JSONObject:toString	()Ljava/lang/String;
    //   211: aload_0
    //   212: invokeinterface 177 3 0
    //   217: return
    //   218: astore_1
    //   219: aload_1
    //   220: invokevirtual 180	java/lang/Exception:printStackTrace	()V
    //   223: return
    //   224: astore_1
    //   225: aload_1
    //   226: invokevirtual 180	java/lang/Exception:printStackTrace	()V
    //   229: return
    //   230: astore_2
    //   231: aload_2
    //   232: invokevirtual 180	java/lang/Exception:printStackTrace	()V
    //   235: goto -29 -> 206
    //   238: aload_0
    //   239: getfield 118	aroa:oH	Ljava/util/Map;
    //   242: ifnull -230 -> 12
    //   245: aload_2
    //   246: astore_1
    //   247: aload_0
    //   248: getfield 118	aroa:oH	Ljava/util/Map;
    //   251: iconst_2
    //   252: invokestatic 122	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   255: invokeinterface 128 2 0
    //   260: ifeq +20 -> 280
    //   263: aload_0
    //   264: getfield 118	aroa:oH	Ljava/util/Map;
    //   267: iconst_2
    //   268: invokestatic 122	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   271: invokeinterface 132 2 0
    //   276: checkcast 10	aroa$a
    //   279: astore_1
    //   280: aload_1
    //   281: ifnull -269 -> 12
    //   284: aload_1
    //   285: aconst_null
    //   286: aload_0
    //   287: invokeinterface 177 3 0
    //   292: return
    //   293: aload_0
    //   294: getfield 118	aroa:oH	Ljava/util/Map;
    //   297: ifnull -285 -> 12
    //   300: aload_0
    //   301: getfield 118	aroa:oH	Ljava/util/Map;
    //   304: iconst_3
    //   305: invokestatic 122	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   308: invokeinterface 128 2 0
    //   313: ifeq +96 -> 409
    //   316: aload_0
    //   317: getfield 118	aroa:oH	Ljava/util/Map;
    //   320: iconst_3
    //   321: invokestatic 122	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   324: invokeinterface 132 2 0
    //   329: checkcast 10	aroa$a
    //   332: astore_1
    //   333: aload_1
    //   334: ifnull -322 -> 12
    //   337: aload_3
    //   338: ldc 182
    //   340: invokeinterface 186 2 0
    //   345: astore_2
    //   346: aload_2
    //   347: invokeinterface 191 1 0
    //   352: ifeq -340 -> 12
    //   355: aload_2
    //   356: iconst_0
    //   357: invokeinterface 195 2 0
    //   362: checkcast 102	org/w3c/dom/Element
    //   365: ldc 197
    //   367: invokeinterface 106 2 0
    //   372: astore_3
    //   373: new 162	org/json/JSONObject
    //   376: dup
    //   377: invokespecial 163	org/json/JSONObject:<init>	()V
    //   380: astore_2
    //   381: aload_2
    //   382: ldc 199
    //   384: aload_3
    //   385: invokevirtual 172	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   388: pop
    //   389: aload_1
    //   390: aload_2
    //   391: invokevirtual 173	org/json/JSONObject:toString	()Ljava/lang/String;
    //   394: aload_0
    //   395: invokeinterface 177 3 0
    //   400: return
    //   401: astore_3
    //   402: aload_3
    //   403: invokevirtual 180	java/lang/Exception:printStackTrace	()V
    //   406: goto -17 -> 389
    //   409: aconst_null
    //   410: astore_1
    //   411: goto -78 -> 333
    //   414: aconst_null
    //   415: astore_1
    //   416: goto -272 -> 144
    //   419: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	420	0	this	aroa
    //   0	420	1	paramString	String
    //   1	198	2	localStringWriter	java.io.StringWriter
    //   230	16	2	localException1	Exception
    //   345	46	2	localObject1	Object
    //   16	369	3	localObject2	Object
    //   401	2	3	localException2	Exception
    //   173	10	4	localStreamResult	javax.xml.transform.stream.StreamResult
    // Exception table:
    //   from	to	target	type
    //   148	195	218	java/lang/Exception
    //   206	217	218	java/lang/Exception
    //   231	235	218	java/lang/Exception
    //   17	73	224	java/lang/Exception
    //   73	104	224	java/lang/Exception
    //   104	144	224	java/lang/Exception
    //   219	223	224	java/lang/Exception
    //   238	245	224	java/lang/Exception
    //   247	280	224	java/lang/Exception
    //   284	292	224	java/lang/Exception
    //   293	333	224	java/lang/Exception
    //   337	381	224	java/lang/Exception
    //   389	400	224	java/lang/Exception
    //   402	406	224	java/lang/Exception
    //   195	206	230	java/lang/Exception
    //   381	389	401	java/lang/Exception
  }
  
  private intchk.AppInfo a()
  {
    intchk.AppInfo localAppInfo = new intchk.AppInfo();
    localAppInfo.uint32_platform_type.set(1);
    String str = this.a.mContext.getPackageName();
    localAppInfo.bytes_package_name.set(ByteStringMicro.copyFromUtf8(str));
    int i;
    if (TextUtils.isEmpty(this.mAppVersion))
    {
      str = "1.0";
      localAppInfo.bytes_app_version.set(ByteStringMicro.copyFromUtf8(str));
      localAppInfo.uint32_intchk_module_version.set(ekx);
      switch (aroc.getNetType(this.a.mContext))
      {
      default: 
        i = 5;
      }
    }
    for (;;)
    {
      str = aroc.bD(this.a.mContext);
      int j = i;
      if (str != null)
      {
        j = i;
        if (str.contains("wap")) {
          j = 4;
        }
      }
      localAppInfo.uint32_net_type.set(j);
      return localAppInfo;
      str = this.mAppVersion;
      break;
      i = 3;
      continue;
      i = 5;
      continue;
      i = 6;
      continue;
      i = 7;
    }
  }
  
  private void a(intchk.RspBody paramRspBody)
  {
    if (paramRspBody.uint32_result.has()) {}
    for (int i = paramRspBody.uint32_result.get();; i = 2)
    {
      if (i != 1) {
        break label23;
      }
      for (;;)
      {
        label23:
        return;
        label418:
        label431:
        if (paramRspBody.msg_check_config_rsp.has())
        {
          paramRspBody = (intchk.FetchCheckConfigRsp)paramRspBody.msg_check_config_rsp.get();
          if (paramRspBody.uint32_need_intchk.has()) {}
          for (i = paramRspBody.uint32_need_intchk.get();; i = 2)
          {
            if ((i != 1) || (!paramRspBody.rpt_msg_check_item.has())) {
              break label431;
            }
            if (paramRspBody.uint32_intchk_id.has()) {}
            for (i = paramRspBody.uint32_intchk_id.get();; i = 0)
            {
              Object localObject2 = new intchk.ReportCheckResultReq();
              ((intchk.ReportCheckResultReq)localObject2).uint32_intchk_id.set(i);
              Object localObject3 = paramRspBody.rpt_msg_check_item.get();
              i = 0;
              if (i < ((List)localObject3).size())
              {
                paramRspBody = (intchk.CheckItem)((List)localObject3).get(i);
                if (!paramRspBody.uint32_check_item_id.has()) {
                  break label418;
                }
              }
              for (int j = paramRspBody.uint32_check_item_id.get();; j = 0)
              {
                if (paramRspBody.uint32_check_type.has()) {}
                for (int k = paramRspBody.uint32_check_type.get();; k = 1)
                {
                  intchk.CheckResult localCheckResult = new intchk.CheckResult();
                  localCheckResult.uint32_check_item_id.set(j);
                  localCheckResult.uint32_check_type.set(k);
                  switch (k)
                  {
                  }
                  for (;;)
                  {
                    ((intchk.ReportCheckResultReq)localObject2).rpt_msg_check_result.add(localCheckResult);
                    i += 1;
                    break;
                    if (a(paramRspBody)) {}
                    for (j = 1;; j = 2)
                    {
                      localCheckResult.uint32_memchk_result.set(j);
                      break;
                    }
                    localObject1 = aqhs.bytes2HexStr(a(paramRspBody));
                    paramRspBody = (intchk.RspBody)localObject1;
                    if (localObject1 == null) {
                      paramRspBody = "";
                    }
                    localCheckResult.bytes_memreport_result.set(ByteStringMicro.copyFromUtf8(paramRspBody));
                  }
                  paramRspBody = new intchk.ReqBody();
                  paramRspBody.uint32_subcmd.set(2);
                  paramRspBody.msg_app_info.set(a());
                  paramRspBody.msg_report_check_result_req.set((MessageMicro)localObject2);
                  localObject2 = this.a.a;
                  if (localObject2 == null) {
                    break;
                  }
                  Object localObject1 = paramRspBody.toByteArray();
                  localObject3 = ((arnw)localObject2).getCodec("intchk");
                  paramRspBody = (intchk.RspBody)localObject1;
                  if (localObject3 != null) {
                    paramRspBody = ((arnw.a)localObject3).encode(localObject1);
                  }
                  ((arnw)localObject2).send(paramRspBody);
                  return;
                }
              }
            }
          }
        }
      }
    }
  }
  
  private boolean a(intchk.CheckItem paramCheckItem)
  {
    if (paramCheckItem.uint32_start_offset.has()) {}
    for (int i = paramCheckItem.uint32_start_offset.get();; i = 0)
    {
      if (paramCheckItem.uint32_end_offset.has()) {}
      for (int j = paramCheckItem.uint32_end_offset.get();; j = 0)
      {
        if (j <= i) {}
        String str1;
        String str2;
        do
        {
          do
          {
            return false;
            str1 = "";
            if (paramCheckItem.bytes_module_name.has()) {
              str1 = paramCheckItem.bytes_module_name.get().toStringUtf8();
            }
          } while (TextUtils.isEmpty(str1.trim()));
          str2 = "";
          if (paramCheckItem.bytes_match_pattern.has()) {
            str2 = paramCheckItem.bytes_match_pattern.get().toStringUtf8();
          }
        } while (TextUtils.isEmpty(str2.trim()));
        try
        {
          boolean bool = MQPSecUtil.memchk(str1, i, j, aqhs.hexStr2Bytes(str2));
          return bool;
        }
        catch (Throwable paramCheckItem)
        {
          paramCheckItem.printStackTrace();
          return false;
        }
      }
    }
  }
  
  private byte[] a(intchk.CheckItem paramCheckItem)
  {
    if (paramCheckItem.uint32_start_offset.has()) {}
    for (int i = paramCheckItem.uint32_start_offset.get();; i = 0)
    {
      if (paramCheckItem.uint32_end_offset.has()) {}
      for (int j = paramCheckItem.uint32_end_offset.get();; j = 0)
      {
        if (j <= i) {}
        String str;
        do
        {
          return null;
          str = "";
          if (paramCheckItem.bytes_module_name.has()) {
            str = paramCheckItem.bytes_module_name.get().toStringUtf8();
          }
        } while (TextUtils.isEmpty(str.trim()));
        try
        {
          paramCheckItem = MQPSecUtil.memreport(str, i, j);
          return paramCheckItem;
        }
        catch (Throwable paramCheckItem)
        {
          for (;;)
          {
            paramCheckItem.printStackTrace();
            paramCheckItem = null;
          }
        }
      }
    }
  }
  
  private void b(intchk.RspBody paramRspBody)
  {
    int j = 2;
    if (paramRspBody.uint32_result.has()) {}
    for (int i = paramRspBody.uint32_result.get();; i = 2)
    {
      if (i != 1) {}
      do
      {
        do
        {
          return;
        } while (!paramRspBody.msg_report_check_result_rsp.has());
        paramRspBody = (intchk.ReportCheckResultRsp)paramRspBody.msg_report_check_result_rsp.get();
        i = j;
        if (paramRspBody.uint32_need_strike.has()) {
          i = paramRspBody.uint32_need_strike.get();
        }
      } while ((i != 1) || (!paramRspBody.bytes_strike_config.has()));
      if (paramRspBody.uint32_intchk_id.has()) {
        this.ekB = paramRspBody.uint32_intchk_id.get();
      }
      WD(paramRspBody.bytes_strike_config.get().toStringUtf8());
      return;
    }
  }
  
  public void WC(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return;
      try
      {
        paramString = new JSONObject(paramString);
        if (paramString.has("strike_result"))
        {
          this.mStrikeResult = paramString.getInt("strike_result");
          Object localObject = new intchk.ReportStrikeResultReq();
          ((intchk.ReportStrikeResultReq)localObject).uint32_intchk_id.set(this.ekB);
          ((intchk.ReportStrikeResultReq)localObject).uint32_strike_type.set(this.mStrikeType);
          ((intchk.ReportStrikeResultReq)localObject).uint32_strike_result.set(this.mStrikeResult);
          paramString = new intchk.ReqBody();
          paramString.uint32_subcmd.set(3);
          paramString.msg_app_info.set(a());
          paramString.msg_report_strike_result_req.set((MessageMicro)localObject);
          if (this.a != null)
          {
            arnw localarnw = this.a.a;
            if (localarnw != null)
            {
              localObject = paramString.toByteArray();
              arnw.a locala = localarnw.getCodec("intchk");
              paramString = (String)localObject;
              if (locala != null) {
                paramString = locala.encode(localObject);
              }
              localarnw.send(paramString);
              return;
            }
          }
        }
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  public void a(int paramInt, aroa.a parama)
  {
    if (parama == null) {
      return;
    }
    if (this.oH == null) {
      this.oH = new LinkedHashMap();
    }
    this.oH.put(Integer.valueOf(paramInt), parama);
  }
  
  public void f(Object paramObject1, Object paramObject2)
  {
    if (this.a != null)
    {
      Object localObject = this.a.a;
      if (localObject != null)
      {
        paramObject1 = null;
        localObject = ((arnw)localObject).getCodec("intchk");
        if (localObject != null) {
          paramObject1 = (byte[])((arnw.a)localObject).decode(paramObject2);
        }
        if (paramObject1 != null) {
          break label59;
        }
      }
    }
    return;
    label59:
    paramObject2 = new intchk.RspBody();
    int i;
    try
    {
      paramObject2.mergeFrom(paramObject1);
      i = 0;
      if (!paramObject2.uint32_subcmd.has()) {
        break label114;
      }
      i = paramObject2.uint32_subcmd.get();
    }
    catch (InvalidProtocolBufferMicroException paramObject1)
    {
      paramObject1.printStackTrace();
      return;
    }
    a(paramObject2);
    return;
    b(paramObject2);
    return;
    label114:
    switch (i)
    {
    }
  }
  
  public void start(String paramString)
  {
    this.mAppVersion = paramString;
    Object localObject = new intchk.FetchCheckConfigReq();
    ((intchk.FetchCheckConfigReq)localObject).uint32_reserved.set(0);
    paramString = new intchk.ReqBody();
    paramString.uint32_subcmd.set(1);
    paramString.msg_app_info.set(a());
    paramString.msg_check_config_req.set((MessageMicro)localObject);
    arnw localarnw = this.a.a;
    if (localarnw == null) {
      return;
    }
    localObject = paramString.toByteArray();
    arnw.a locala = localarnw.getCodec("intchk");
    paramString = (String)localObject;
    if (locala != null) {
      paramString = locala.encode(localObject);
    }
    localarnw.send(paramString);
  }
  
  public static abstract interface a
  {
    public abstract void exec(String paramString, arny paramarny);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aroa
 * JD-Core Version:    0.7.0.1
 */