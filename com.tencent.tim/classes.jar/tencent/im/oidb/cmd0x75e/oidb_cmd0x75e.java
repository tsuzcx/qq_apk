package tencent.im.oidb.cmd0x75e;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0x75e
{
  public static final class ArticleInfo
    extends MessageMicro<ArticleInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_article_xml = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "bytes_article_xml" }, new Object[] { localByteStringMicro }, ArticleInfo.class);
    }
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 90 }, new String[] { "uint64_uin", "uint32_network_type", "msg_req_para" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), null }, ReqBody.class);
    public oidb_cmd0x75e.ReqPara msg_req_para = new oidb_cmd0x75e.ReqPara();
    public final PBUInt32Field uint32_network_type = PBField.initUInt32(0);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  }
  
  public static final class ReqPara
    extends MessageMicro<ReqPara>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "enum_op_type" }, new Object[] { Integer.valueOf(1) }, ReqPara.class);
    public final PBEnumField enum_op_type = PBField.initEnum(1);
  }
  
  public static final class RspArticle
    extends MessageMicro<RspArticle>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 90 }, new String[] { "enum_op_type", "rpt_article_info" }, new Object[] { Integer.valueOf(1), null }, RspArticle.class);
    public final PBEnumField enum_op_type = PBField.initEnum(1);
    public final PBRepeatMessageField<oidb_cmd0x75e.ArticleInfo> rpt_article_info = PBField.initRepeatMessage(oidb_cmd0x75e.ArticleInfo.class);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 90 }, new String[] { "uint64_uin", "msg_rsp_article" }, new Object[] { Long.valueOf(0L), null }, RspBody.class);
    public oidb_cmd0x75e.RspArticle msg_rsp_article = new oidb_cmd0x75e.RspArticle();
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0x75e.oidb_cmd0x75e
 * JD-Core Version:    0.7.0.1
 */