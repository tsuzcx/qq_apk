package com.tencent.qqmail.protocol;

import com.tencent.qqmail.model.ConvertFromProtobuf;
import com.tencent.qqmail.protobuf.BaseProtoBuf;
import java.io.Serializable;

public class MailAttachment
  implements ARTConvert, Serializable
{
  private static final long serialVersionUID = 1L;
  public long attachment_id_;
  @ConvertFromProtobuf(getProtoType=com.tencent.qqmail.protocol.ART.ItemBodyStructureHelper.class, isConvert=true)
  public ItemBodyStructureHelper body_structure_helper_;
  public String cid_;
  public byte[] data_;
  public String display_name_;
  public String exchange_file_uid_;
  public String file_content_type_;
  public long file_download_size_;
  public int file_exist_;
  public String file_name_;
  public long file_size_;
  public long mailId_;
  private byte[] pb_body_structure_helper_;
  public String type_;
  public String url_;
  
  public void ART_ParseProto(BaseProtoBuf paramBaseProtoBuf)
  {
    paramBaseProtoBuf = (com.tencent.qqmail.protocol.ART.MailAttachment)paramBaseProtoBuf;
    this.mailId_ = paramBaseProtoBuf.mailId_;
    this.attachment_id_ = paramBaseProtoBuf.attachment_id_;
    this.file_size_ = paramBaseProtoBuf.file_size_;
    this.file_download_size_ = paramBaseProtoBuf.file_download_size_;
    this.file_exist_ = paramBaseProtoBuf.file_exist_;
    this.file_name_ = paramBaseProtoBuf.file_name_;
    this.display_name_ = paramBaseProtoBuf.display_name_;
    this.type_ = paramBaseProtoBuf.type_;
    this.url_ = paramBaseProtoBuf.url_;
    this.cid_ = paramBaseProtoBuf.cid_;
    this.exchange_file_uid_ = paramBaseProtoBuf.exchange_file_uid_;
    this.file_content_type_ = paramBaseProtoBuf.file_content_type_;
    this.body_structure_helper_ = new ItemBodyStructureHelper();
    this.body_structure_helper_.ART_ParseProto(paramBaseProtoBuf.body_structure_helper_);
  }
  
  public void ART_ToProto(BaseProtoBuf paramBaseProtoBuf) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.protocol.MailAttachment
 * JD-Core Version:    0.7.0.1
 */