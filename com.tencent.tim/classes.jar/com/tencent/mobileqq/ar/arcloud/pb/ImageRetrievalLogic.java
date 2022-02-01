package com.tencent.mobileqq.ar.arcloud.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBDoubleField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

public final class ImageRetrievalLogic
{
  public static final class IRLogicReq
    extends MessageMicro<IRLogicReq>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBInt32Field iBusiness = PBField.initInt32(0);
    public final PBInt32Field iModel = PBField.initInt32(0);
    public final PBInt32Field iScene = PBField.initInt32(0);
    public ImageRetrievalComm.IRUserInfo stUserInfo = new ImageRetrievalComm.IRUserInfo();
    public final PBBytesField vImage = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34, 40 }, new String[] { "stUserInfo", "iBusiness", "iScene", "vImage", "iModel" }, new Object[] { null, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro, Integer.valueOf(0) }, IRLogicReq.class);
    }
  }
  
  public static final class IRLogicRsp
    extends MessageMicro<IRLogicRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 42, 50 }, new String[] { "iRetCode", "sMsg", "vClassInfo", "iBusiness", "sKey", "stBBox" }, new Object[] { Integer.valueOf(0), "", null, Integer.valueOf(0), "", null }, IRLogicRsp.class);
    public final PBInt32Field iBusiness = PBField.initInt32(0);
    public final PBInt32Field iRetCode = PBField.initInt32(0);
    public final PBStringField sKey = PBField.initString("");
    public final PBStringField sMsg = PBField.initString("");
    public ImageRetrievalComm.OD_BBox stBBox = new ImageRetrievalComm.OD_BBox();
    public final PBRepeatMessageField<ImageRetrievalLogic.RetrievalClassInfo> vClassInfo = PBField.initRepeatMessage(ImageRetrievalLogic.RetrievalClassInfo.class);
  }
  
  public static final class LabelSource
    extends MessageMicro<LabelSource>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 8026, 8034 }, new String[] { "stLabelComm", "stLable1003", "stLable1004" }, new Object[] { null, null, null }, LabelSource.class);
    public ImageRetrievalLogic.LabelSourceCommon stLabelComm = new ImageRetrievalLogic.LabelSourceCommon();
    public ImageRetrievalLogic.LabelSource1003 stLable1003 = new ImageRetrievalLogic.LabelSource1003();
    public ImageRetrievalLogic.LabelSource1004 stLable1004 = new ImageRetrievalLogic.LabelSource1004();
  }
  
  public static final class LabelSource1003
    extends MessageMicro<LabelSource1003>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "sTitle", "sISBN" }, new Object[] { "", "" }, LabelSource1003.class);
    public final PBStringField sISBN = PBField.initString("");
    public final PBStringField sTitle = PBField.initString("");
  }
  
  public static final class LabelSource1004
    extends MessageMicro<LabelSource1004>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "sCountry", "sCity", "sTour" }, new Object[] { "", "", "" }, LabelSource1004.class);
    public final PBStringField sCity = PBField.initString("");
    public final PBStringField sCountry = PBField.initString("");
    public final PBStringField sTour = PBField.initString("");
  }
  
  public static final class LabelSourceCommon
    extends MessageMicro<LabelSourceCommon>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "sLabel" }, new Object[] { "" }, LabelSourceCommon.class);
    public final PBStringField sLabel = PBField.initString("");
  }
  
  public static final class RetrievalClassInfo
    extends MessageMicro<RetrievalClassInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 25, 34, 40 }, new String[] { "iClass", "sClass", "dClassProb", "vItem", "iStatus" }, new Object[] { Integer.valueOf(0), "", Double.valueOf(0.0D), null, Integer.valueOf(0) }, RetrievalClassInfo.class);
    public final PBDoubleField dClassProb = PBField.initDouble(0.0D);
    public final PBInt32Field iClass = PBField.initInt32(0);
    public final PBInt32Field iStatus = PBField.initInt32(0);
    public final PBStringField sClass = PBField.initString("");
    public final PBRepeatMessageField<ImageRetrievalLogic.RetrievalItem> vItem = PBField.initRepeatMessage(ImageRetrievalLogic.RetrievalItem.class);
  }
  
  public static final class RetrievalItem
    extends MessageMicro<RetrievalItem>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBDoubleField dProb = PBField.initDouble(0.0D);
    public final PBInt32Field iAutoJump = PBField.initInt32(0);
    public final PBInt32Field iClass = PBField.initInt32(0);
    public final PBInt32Field iNeedCheckLBS = PBField.initInt32(0);
    public final PBInt32Field iSource = PBField.initInt32(0);
    public final PBBytesField sCdbRes = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBStringField sClass = PBField.initString("");
    public final PBStringField sImageId = PBField.initString("");
    public final PBStringField sItemID = PBField.initString("");
    public final PBStringField sJumpUrl = PBField.initString("");
    public final PBStringField sPicUrl = PBField.initString("");
    public final PBStringField sTitle = PBField.initString("");
    public final PBStringField sWiki = PBField.initString("");
    public ImageRetrievalLogic.LabelSource stLabel = new ImageRetrievalLogic.LabelSource();
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 25, 34, 42, 48, 58, 64, 810, 818, 826, 834, 840, 850 }, new String[] { "iClass", "sClass", "dProb", "sItemID", "stLabel", "iSource", "sPicUrl", "iAutoJump", "sTitle", "sWiki", "sJumpUrl", "sCdbRes", "iNeedCheckLBS", "sImageId" }, new Object[] { Integer.valueOf(0), "", Double.valueOf(0.0D), "", null, Integer.valueOf(0), "", Integer.valueOf(0), "", "", "", localByteStringMicro, Integer.valueOf(0), "" }, RetrievalItem.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arcloud.pb.ImageRetrievalLogic
 * JD-Core Version:    0.7.0.1
 */