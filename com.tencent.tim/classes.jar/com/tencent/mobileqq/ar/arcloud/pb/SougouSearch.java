package com.tencent.mobileqq.ar.arcloud.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

public final class SougouSearch
{
  public static final class CardV2
    extends MessageMicro<CardV2>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 34, 42 }, new String[] { "template_name", "is_recommended", "card_properties", "carousel", "subcards" }, new Object[] { "", Boolean.valueOf(false), null, null, null }, CardV2.class);
    public final PBRepeatMessageField<SougouSearch.MapItem> card_properties = PBField.initRepeatMessage(SougouSearch.MapItem.class);
    public final PBRepeatMessageField<CarouselUnitV2> carousel = PBField.initRepeatMessage(CarouselUnitV2.class);
    public final PBBoolField is_recommended = PBField.initBool(false);
    public final PBRepeatMessageField<CardV2> subcards = PBField.initRepeatMessage(CardV2.class);
    public final PBStringField template_name = PBField.initString("");
    
    public static final class CarouselUnitV2
      extends MessageMicro<CarouselUnitV2>
    {
      static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "card_properties" }, new Object[] { null }, CarouselUnitV2.class);
      public final PBRepeatMessageField<SougouSearch.MapItem> card_properties = PBField.initRepeatMessage(SougouSearch.MapItem.class);
    }
  }
  
  public static final class ClientRequestBodyV2
    extends MessageMicro<ClientRequestBodyV2>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 34 }, new String[] { "device", "sentences" }, new Object[] { null, "" }, ClientRequestBodyV2.class);
    public SougouSearch.DeviceV2 device = new SougouSearch.DeviceV2();
    public final PBRepeatField<String> sentences = PBField.initRepeat(PBStringField.__repeatHelper__);
  }
  
  public static final class DeviceV2
    extends MessageMicro<DeviceV2>
  {
    public static final int Android = 1;
    public static final int IOS = 0;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "platform" }, new Object[] { Integer.valueOf(0) }, DeviceV2.class);
    public final PBEnumField platform = PBField.initEnum(0);
  }
  
  public static final class MapItem
    extends MessageMicro<MapItem>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "key", "value" }, new Object[] { "", "" }, MapItem.class);
    public final PBStringField key = PBField.initString("");
    public final PBStringField value = PBField.initString("");
  }
  
  public static final class ServerResponseBodyV2
    extends MessageMicro<ServerResponseBodyV2>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32, 40 }, new String[] { "cards", "request_class", "container_properties", "is_recommended", "session_id" }, new Object[] { null, "", null, Boolean.valueOf(false), Long.valueOf(0L) }, ServerResponseBodyV2.class);
    public final PBRepeatMessageField<SougouSearch.CardV2> cards = PBField.initRepeatMessage(SougouSearch.CardV2.class);
    public final PBRepeatMessageField<SougouSearch.MapItem> container_properties = PBField.initRepeatMessage(SougouSearch.MapItem.class);
    public final PBBoolField is_recommended = PBField.initBool(false);
    public final PBStringField request_class = PBField.initString("");
    public final PBInt64Field session_id = PBField.initInt64(0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arcloud.pb.SougouSearch
 * JD-Core Version:    0.7.0.1
 */