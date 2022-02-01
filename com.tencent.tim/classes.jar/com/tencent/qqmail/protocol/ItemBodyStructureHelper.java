package com.tencent.qqmail.protocol;

import com.tencent.qqmail.protobuf.BaseProtoBuf;
import com.tencent.qqmail.protocol.ART.MailItemBodyStructureInfo;
import com.tencent.qqmail.utilities.QMMath;
import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;

public class ItemBodyStructureHelper
  implements ARTConvert, Serializable
{
  private static final long serialVersionUID = 1L;
  public MailItemBodyStructureInfo[] body_struture_info_;
  
  public void ART_ParseProto(BaseProtoBuf paramBaseProtoBuf)
  {
    paramBaseProtoBuf = (com.tencent.qqmail.protocol.ART.ItemBodyStructureHelper)paramBaseProtoBuf;
    this.body_struture_info_ = new MailItemBodyStructureInfo[paramBaseProtoBuf.body_struture_info_.size()];
    paramBaseProtoBuf = paramBaseProtoBuf.body_struture_info_.iterator();
    int i = 0;
    while (paramBaseProtoBuf.hasNext())
    {
      MailItemBodyStructureInfo localMailItemBodyStructureInfo = (MailItemBodyStructureInfo)paramBaseProtoBuf.next();
      MailItemBodyStructureInfo localMailItemBodyStructureInfo1 = new MailItemBodyStructureInfo();
      localMailItemBodyStructureInfo1.ART_ParseProto(localMailItemBodyStructureInfo);
      this.body_struture_info_[i] = localMailItemBodyStructureInfo1;
      i += 1;
    }
  }
  
  public void ART_ToProto(BaseProtoBuf paramBaseProtoBuf) {}
  
  public static class MailItemBodyStructureInfo
    implements ARTConvert, Serializable
  {
    private static final long serialVersionUID = 1L;
    public long attachId_;
    public String body_id_;
    public String content_description_;
    public String content_disposition_;
    public String content_line_size_;
    public String content_subtype_;
    public String content_transfer_encoding_;
    public String content_type_;
    public String content_type_params_;
    public long id_;
    public String item_type_;
    public long itemid_;
    public long mailId_;
    
    public static int generateHashId(long paramLong, String paramString)
    {
      return QMMath.hashPositivetInt(paramLong + "_" + paramString);
    }
    
    public void ART_ParseProto(BaseProtoBuf paramBaseProtoBuf)
    {
      paramBaseProtoBuf = (MailItemBodyStructureInfo)paramBaseProtoBuf;
      this.mailId_ = paramBaseProtoBuf.mailId_;
      this.attachId_ = paramBaseProtoBuf.attachId_;
      this.id_ = paramBaseProtoBuf.id_;
      this.itemid_ = paramBaseProtoBuf.itemid_;
      this.item_type_ = paramBaseProtoBuf.item_type_;
      this.body_id_ = paramBaseProtoBuf.body_id_;
      this.content_type_ = paramBaseProtoBuf.content_type_;
      this.content_subtype_ = paramBaseProtoBuf.content_subtype_;
      this.content_type_params_ = paramBaseProtoBuf.content_type_params_;
      this.content_description_ = paramBaseProtoBuf.content_description_;
      this.content_transfer_encoding_ = paramBaseProtoBuf.content_transfer_encoding_;
      this.content_line_size_ = paramBaseProtoBuf.content_line_size_;
      this.content_disposition_ = paramBaseProtoBuf.content_disposition_;
    }
    
    public void ART_ToProto(BaseProtoBuf paramBaseProtoBuf) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.protocol.ItemBodyStructureHelper
 * JD-Core Version:    0.7.0.1
 */