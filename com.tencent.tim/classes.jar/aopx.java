import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.transfile.ProtoReqManager;
import com.tencent.mobileqq.transfile.ProtoReqManager.c;
import com.tencent.mobileqq.transfile.ProtoReqManager.d;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import tencent.im.cs.cmd0x352.cmd0x352.GetImgUrlRsp;
import tencent.im.cs.cmd0x352.cmd0x352.IPv6Info;
import tencent.im.cs.cmd0x352.cmd0x352.ReqBody;
import tencent.im.cs.cmd0x352.cmd0x352.RspBody;

public class aopx
  extends aoqj
{
  private void a(aoql.a.a parama, cmd0x352.GetImgUrlRsp paramGetImgUrlRsp, aoql.b.l paraml)
    throws UnknownHostException
  {
    int j = 0;
    Object localObject1;
    Object localObject2;
    Object localObject3;
    if (anof.ayA())
    {
      localObject1 = paramGetImgUrlRsp.bytes_big_thumb_down_para.get();
      localObject2 = paramGetImgUrlRsp.bytes_original_down_para.get();
      localObject3 = paramGetImgUrlRsp.bytes_big_down_para.get();
      if (localObject1 != null) {
        break label234;
      }
      localObject1 = null;
      label44:
      if (localObject2 != null) {
        break label244;
      }
      localObject2 = null;
      label52:
      if (localObject3 != null) {
        break label254;
      }
      localObject3 = null;
      label60:
      if (parama.fileType != 65537) {
        break label264;
      }
    }
    for (;;)
    {
      label69:
      paraml.urlPath = ((String)localObject1);
      int i;
      if ((paramGetImgUrlRsp.rpt_uint32_down_ip.has()) && (paramGetImgUrlRsp.rpt_uint32_down_ip.size() > 0) && (paramGetImgUrlRsp.rpt_uint32_down_port.has()) && (paramGetImgUrlRsp.rpt_uint32_down_port.size() > 0))
      {
        parama = paramGetImgUrlRsp.rpt_uint32_down_ip.get();
        localObject1 = paramGetImgUrlRsp.rpt_uint32_down_port.get();
        i = 0;
        for (;;)
        {
          if (i < parama.size())
          {
            localObject2 = new aonh();
            ((aonh)localObject2).mIp = aqoj.bS(((Integer)parama.get(i)).intValue() & 0xFFFFFFFF);
            ((aonh)localObject2).port = ((Integer)((List)localObject1).get(i)).intValue();
            paraml.xp.add(i, localObject2);
            i += 1;
            continue;
            localObject1 = paramGetImgUrlRsp.bytes_thumb_down_para.get();
            break;
            label234:
            localObject1 = ((ByteStringMicro)localObject1).toStringUtf8();
            break label44;
            label244:
            localObject2 = ((ByteStringMicro)localObject2).toStringUtf8();
            break label52;
            label254:
            localObject3 = ((ByteStringMicro)localObject3).toStringUtf8();
            break label60;
            label264:
            localObject1 = localObject3;
            if (parama.fileType == 1) {
              break label69;
            }
            if (parama.fileType != 131075) {
              break label500;
            }
            localObject1 = localObject2;
            break label69;
          }
        }
      }
      if ((paramGetImgUrlRsp.rpt_msg_down_ip6.has()) && (paramGetImgUrlRsp.rpt_msg_down_ip6.size() > 0))
      {
        parama = paramGetImgUrlRsp.rpt_msg_down_ip6.get();
        i = j;
        while (i < parama.size())
        {
          localObject1 = new aonh();
          ((aonh)localObject1).mIp = Inet6Address.getByAddress(((cmd0x352.IPv6Info)parama.get(i)).bytes_ip6.get().toByteArray()).getHostAddress();
          ((aonh)localObject1).port = ((cmd0x352.IPv6Info)parama.get(i)).uint32_port.get();
          ((aonh)localObject1).isIpv6 = true;
          paraml.Bw.add(i, localObject1);
          i += 1;
        }
      }
      if (paramGetImgUrlRsp.bytes_down_domain.has())
      {
        parama = new aonh();
        parama.mIp = paramGetImgUrlRsp.bytes_down_domain.get().toStringUtf8();
        parama.port = 80;
        paraml.xp.add(parama);
        paraml.domain = parama.mIp;
      }
      if (paramGetImgUrlRsp.uint32_https_url_flag.has()) {
        paraml.protocolType = paramGetImgUrlRsp.uint32_https_url_flag.get();
      }
      return;
      label500:
      localObject1 = null;
    }
  }
  
  /* Error */
  void a(int paramInt, aoql.a.k paramk, cmd0x352.ReqBody paramReqBody)
  {
    // Byte code:
    //   0: bipush 16
    //   2: istore 4
    //   4: aload_2
    //   5: checkcast 39	aoql$a$a
    //   8: astore 8
    //   10: new 186	tencent/im/cs/cmd0x352/cmd0x352$GetImgUrlReq
    //   13: dup
    //   14: invokespecial 187	tencent/im/cs/cmd0x352/cmd0x352$GetImgUrlReq:<init>	()V
    //   17: astore 9
    //   19: aload 9
    //   21: iconst_1
    //   22: invokevirtual 191	tencent/im/cs/cmd0x352/cmd0x352$GetImgUrlReq:setHasFlag	(Z)V
    //   25: aload 9
    //   27: getfield 195	tencent/im/cs/cmd0x352/cmd0x352$GetImgUrlReq:uint64_src_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   30: aload 8
    //   32: getfield 198	aoql$a$a:peerUin	Ljava/lang/String;
    //   35: invokestatic 204	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   38: invokevirtual 208	java/lang/Long:longValue	()J
    //   41: invokevirtual 214	com/tencent/mobileqq/pb/PBUInt64Field:set	(J)V
    //   44: aload 9
    //   46: getfield 217	tencent/im/cs/cmd0x352/cmd0x352$GetImgUrlReq:uint32_pic_up_timestamp	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   49: aload 8
    //   51: getfield 220	aoql$a$a:msgTime	I
    //   54: invokevirtual 223	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   57: aload 8
    //   59: getfield 226	aoql$a$a:selfUin	Ljava/lang/String;
    //   62: astore 7
    //   64: aload 7
    //   66: astore_2
    //   67: aload 7
    //   69: ldc 228
    //   71: invokevirtual 234	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   74: ifeq +10 -> 84
    //   77: aload 7
    //   79: iconst_1
    //   80: invokevirtual 238	java/lang/String:substring	(I)Ljava/lang/String;
    //   83: astore_2
    //   84: aload_2
    //   85: invokestatic 204	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   88: invokevirtual 208	java/lang/Long:longValue	()J
    //   91: lstore 5
    //   93: aload 9
    //   95: getfield 241	tencent/im/cs/cmd0x352/cmd0x352$GetImgUrlReq:uint64_dst_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   98: lload 5
    //   100: invokevirtual 214	com/tencent/mobileqq/pb/PBUInt64Field:set	(J)V
    //   103: aload 8
    //   105: getfield 244	aoql$a$a:uuid	Ljava/lang/String;
    //   108: ldc 246
    //   110: invokevirtual 250	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   113: astore_2
    //   114: aload 9
    //   116: getfield 253	tencent/im/cs/cmd0x352/cmd0x352$GetImgUrlReq:bytes_file_resid	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   119: aload_2
    //   120: invokestatic 257	com/tencent/mobileqq/pb/ByteStringMicro:copyFrom	([B)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   123: invokevirtual 260	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   126: aload 9
    //   128: getfield 264	tencent/im/cs/cmd0x352/cmd0x352$GetImgUrlReq:bool_address_book	Lcom/tencent/mobileqq/pb/PBBoolField;
    //   131: aload 8
    //   133: getfield 267	aoql$a$a:cNW	Z
    //   136: invokevirtual 271	com/tencent/mobileqq/pb/PBBoolField:set	(Z)V
    //   139: ldc_w 273
    //   142: aload 8
    //   144: getfield 276	aoql$a$a:storageSource	Ljava/lang/String;
    //   147: invokevirtual 279	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   150: ifeq +151 -> 301
    //   153: aload 9
    //   155: getfield 282	tencent/im/cs/cmd0x352/cmd0x352$GetImgUrlReq:uint32_src_file_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   158: iconst_2
    //   159: invokevirtual 223	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   162: aload 9
    //   164: getfield 285	tencent/im/cs/cmd0x352/cmd0x352$GetImgUrlReq:uint32_req_term	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   167: iconst_5
    //   168: invokevirtual 223	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   171: aload 9
    //   173: getfield 264	tencent/im/cs/cmd0x352/cmd0x352$GetImgUrlReq:bool_address_book	Lcom/tencent/mobileqq/pb/PBBoolField;
    //   176: aload 8
    //   178: getfield 267	aoql$a$a:cNW	Z
    //   181: invokevirtual 271	com/tencent/mobileqq/pb/PBBoolField:set	(Z)V
    //   184: aload 9
    //   186: getfield 288	tencent/im/cs/cmd0x352/cmd0x352$GetImgUrlReq:uint32_req_platform_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   189: bipush 9
    //   191: invokevirtual 223	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   194: aload 9
    //   196: getfield 291	tencent/im/cs/cmd0x352/cmd0x352$GetImgUrlReq:uint32_bu_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   199: iconst_1
    //   200: invokevirtual 223	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   203: aload 8
    //   205: getfield 43	aoql$a$a:fileType	I
    //   208: istore_1
    //   209: iload_1
    //   210: ldc 44
    //   212: if_icmpne +137 -> 349
    //   215: invokestatic 19	anof:ayA	()Z
    //   218: ifeq +123 -> 341
    //   221: bipush 16
    //   223: istore_1
    //   224: iconst_4
    //   225: istore 4
    //   227: aload 9
    //   229: getfield 294	tencent/im/cs/cmd0x352/cmd0x352$GetImgUrlReq:uint32_url_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   232: iload 4
    //   234: invokevirtual 223	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   237: aload 9
    //   239: getfield 297	tencent/im/cs/cmd0x352/cmd0x352$GetImgUrlReq:uint32_url_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   242: iload_1
    //   243: invokevirtual 223	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   246: aload 9
    //   248: getfield 300	tencent/im/cs/cmd0x352/cmd0x352$GetImgUrlReq:bytes_build_ver	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   251: invokestatic 305	aonc:getVersionCode	()Ljava/lang/String;
    //   254: invokestatic 309	com/tencent/mobileqq/pb/ByteStringMicro:copyFromUtf8	(Ljava/lang/String;)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   257: invokevirtual 260	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   260: aload 9
    //   262: getfield 312	tencent/im/cs/cmd0x352/cmd0x352$GetImgUrlReq:uint32_req_transfer_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   265: aload 8
    //   267: getfield 313	aoql$a$a:protocolType	I
    //   270: invokevirtual 223	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   273: aload_3
    //   274: getfield 318	tencent/im/cs/cmd0x352/cmd0x352$ReqBody:rpt_msg_getimg_url_req	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   277: aload 9
    //   279: invokevirtual 321	com/tencent/mobileqq/pb/PBRepeatMessageField:add	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   282: return
    //   283: astore_2
    //   284: aload_2
    //   285: invokevirtual 324	java/lang/Exception:printStackTrace	()V
    //   288: goto -185 -> 103
    //   291: astore_2
    //   292: aload_2
    //   293: invokevirtual 325	java/io/UnsupportedEncodingException:printStackTrace	()V
    //   296: aconst_null
    //   297: astore_2
    //   298: goto -184 -> 114
    //   301: ldc_w 327
    //   304: aload 8
    //   306: getfield 276	aoql$a$a:storageSource	Ljava/lang/String;
    //   309: invokevirtual 279	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   312: ifeq +15 -> 327
    //   315: aload 9
    //   317: getfield 282	tencent/im/cs/cmd0x352/cmd0x352$GetImgUrlReq:uint32_src_file_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   320: iconst_1
    //   321: invokevirtual 223	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   324: goto -162 -> 162
    //   327: aload 9
    //   329: getfield 282	tencent/im/cs/cmd0x352/cmd0x352$GetImgUrlReq:uint32_src_file_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   332: sipush 255
    //   335: invokevirtual 223	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   338: goto -176 -> 162
    //   341: iconst_1
    //   342: istore_1
    //   343: iconst_4
    //   344: istore 4
    //   346: goto -119 -> 227
    //   349: iload_1
    //   350: iconst_1
    //   351: if_icmpne +13 -> 364
    //   354: bipush 6
    //   356: istore 4
    //   358: bipush 8
    //   360: istore_1
    //   361: goto -134 -> 227
    //   364: iload_1
    //   365: ldc 117
    //   367: if_icmpne +8 -> 375
    //   370: iconst_2
    //   371: istore_1
    //   372: goto -145 -> 227
    //   375: iconst_0
    //   376: istore_1
    //   377: iconst_0
    //   378: istore 4
    //   380: goto -153 -> 227
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	383	0	this	aopx
    //   0	383	1	paramInt	int
    //   0	383	2	paramk	aoql.a.k
    //   0	383	3	paramReqBody	cmd0x352.ReqBody
    //   2	377	4	i	int
    //   91	8	5	l	long
    //   62	16	7	str	String
    //   8	297	8	locala	aoql.a.a
    //   17	311	9	localGetImgUrlReq	tencent.im.cs.cmd0x352.cmd0x352.GetImgUrlReq
    // Exception table:
    //   from	to	target	type
    //   57	64	283	java/lang/Exception
    //   67	84	283	java/lang/Exception
    //   84	103	283	java/lang/Exception
    //   103	114	291	java/io/UnsupportedEncodingException
  }
  
  public void a(aoql.a parama)
  {
    if ((parama != null) && (parama.He != null) && (parama.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager != null))
    {
      ProtoReqManager.c localc = new ProtoReqManager.c();
      localc.clW = "LongConn.OffPicDown";
      localc.fW = b(parama.He);
      localc.fi = parama;
      localc.a = this;
      a(parama, localc);
    }
  }
  
  protected void a(ProtoReqManager.d paramd, ProtoReqManager.c paramc, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte, aoql.a parama, aoql.b paramb, achq.a parama1)
  {
    try
    {
      paramd = ((cmd0x352.RspBody)new cmd0x352.RspBody().mergeFrom(paramArrayOfByte)).rpt_msg_getimg_url_rsp.get();
      if ((paramd != null) && (paramd.size() != 0)) {
        break label103;
      }
      throw new Exception("resps null");
    }
    catch (Exception paramd)
    {
      a(-1, -9527, aojn.x("P", -9529L), paramd.getMessage() + " hex:" + HexUtil.bytes2HexStr(paramArrayOfByte), parama1, paramb.Hf);
    }
    return;
    label103:
    Iterator localIterator = paramd.iterator();
    label111:
    while (localIterator.hasNext())
    {
      paramd = (cmd0x352.GetImgUrlRsp)localIterator.next();
      try
      {
        locall = (aoql.b.l)paramb.Hf.get(0);
        try
        {
          locala = (aoql.a.a)parama.He.get(0);
          if (locall == null) {
            continue;
          }
          if (paramFromServiceMsg.getAttributes().containsKey("_attr_send_by_quickHttp")) {
            locall.cOc = ((Boolean)paramFromServiceMsg.getAttribute("_attr_send_by_quickHttp", Boolean.valueOf(false))).booleanValue();
          }
          i = paramd.uint32_result.get();
          if (i != 0) {
            break label307;
          }
          a(locala, paramd, locall);
          a(0, 0, "", "", parama1, locall);
        }
        catch (Exception paramd) {}
      }
      catch (Exception paramd)
      {
        for (;;)
        {
          aoql.a.a locala;
          int i;
          aoql.b.l locall = null;
        }
      }
      if (locall != null)
      {
        a(-1, -9527, aojn.x("P", -9529L), paramd.getMessage() + " hex:" + HexUtil.bytes2HexStr(paramArrayOfByte), parama1, locall);
        continue;
        if (aopy.lR(i))
        {
          this.dOO += 1;
          if (this.dOO < 2)
          {
            parama.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager.b(paramc);
            return;
          }
        }
        if ((i == 201) && (QLog.isColorLevel())) {
          break label384;
        }
      }
    }
    for (;;)
    {
      label307:
      a(-1, -9527, aojn.bH(i), aojn.bH(i), parama1, locall);
      break label111;
      break;
      label384:
      anow.report("Download_C2C_Pic_Request_Error_Param_Check", locala.uuid);
    }
  }
  
  void b(aoql.a parama)
  {
    aoql.b localb = parama.jdField_a_of_type_Aoql$b;
    localb.Hf.clear();
    int i = 0;
    while (i < parama.He.size())
    {
      aoql.b.l locall = new aoql.b.l();
      localb.Hf.add(i, locall);
      i += 1;
    }
  }
  
  byte[] b(List<aoql.a.k> paramList)
  {
    cmd0x352.ReqBody localReqBody = new cmd0x352.ReqBody();
    localReqBody.setHasFlag(true);
    localReqBody.uint32_subcmd.set(2);
    int i = 0;
    while (i < paramList.size())
    {
      a(i, (aoql.a.k)paramList.get(i), localReqBody);
      i += 1;
    }
    switch (aomi.a().getNetType())
    {
    default: 
      i = 6;
    }
    for (;;)
    {
      paramList = aomi.a().getApnType();
      int j = i;
      if (paramList != null)
      {
        j = i;
        if (paramList.contains("wap")) {
          j = 5;
        }
      }
      localReqBody.uint32_net_type.set(j);
      return localReqBody.toByteArray();
      i = 3;
      continue;
      i = 6;
      continue;
      i = 7;
      continue;
      i = 8;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aopx
 * JD-Core Version:    0.7.0.1
 */