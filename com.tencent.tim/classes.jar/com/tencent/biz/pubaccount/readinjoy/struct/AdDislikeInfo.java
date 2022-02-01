package com.tencent.biz.pubaccount.readinjoy.struct;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.im.oidb.articlesummary.articlesummary.NegFeedback;
import tencent.im.oidb.cmd0x885.oidb_0x885.NegFeedback;

public class AdDislikeInfo
  extends DislikeInfo
{
  public int aRs;
  public int id;
  
  public AdDislikeInfo(articlesummary.NegFeedback paramNegFeedback)
  {
    this.type = 7;
    this.vf = paramNegFeedback.uint64_type_id.get();
    this.id = paramNegFeedback.uint32_id.get();
    this.aRs = paramNegFeedback.uint32_f_id.get();
    this.agQ = paramNegFeedback.bytes_type_desc.get().toStringUtf8();
    this.puin = "";
  }
  
  public AdDislikeInfo(oidb_0x885.NegFeedback paramNegFeedback)
  {
    this.type = 7;
    this.vf = paramNegFeedback.uint64_type_id.get();
    this.id = paramNegFeedback.uint32_id.get();
    this.aRs = paramNegFeedback.uint32_f_id.get();
    this.agQ = paramNegFeedback.bytes_type_desc.get().toStringUtf8();
    this.puin = "";
  }
  
  public String toString()
  {
    return "AdDislikeInfo{id=" + this.id + ", f_id=" + this.aRs + ", tagID=" + this.vf + ", describe='" + this.agQ + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.struct.AdDislikeInfo
 * JD-Core Version:    0.7.0.1
 */