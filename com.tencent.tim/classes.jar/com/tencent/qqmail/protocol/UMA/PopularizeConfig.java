package com.tencent.qqmail.protocol.UMA;

import com.tencent.qqmail.protobuf.BaseProtoBuf;
import com.tencent.qqmail.protobuf.ByteString;
import java.io.IOException;
import java.util.LinkedList;
import net.jarlehansen.protobuf.ComputeSizeUtil;
import net.jarlehansen.protobuf.input.InputReader;
import net.jarlehansen.protobuf.output.OutputWriter;

public final class PopularizeConfig
  extends BaseProtoBuf
{
  private static final int fieldNumberAbstracts = 12;
  private static final int fieldNumberAction = 20;
  private static final int fieldNumberAdxml = 41;
  private static final int fieldNumberApp_config = 29;
  private static final int fieldNumberApp_install_action = 23;
  private static final int fieldNumberAvatar_md5 = 46;
  private static final int fieldNumberAvatar_url = 45;
  private static final int fieldNumberBanner_height = 18;
  private static final int fieldNumberBanner_position = 4;
  private static final int fieldNumberCondition = 26;
  private static final int fieldNumberConfig_head = 34;
  private static final int fieldNumberConfig_list = 36;
  private static final int fieldNumberConfig_mark = 37;
  private static final int fieldNumberConfig_tool = 35;
  private static final int fieldNumberContent = 13;
  private static final int fieldNumberDuration = 19;
  private static final int fieldNumberEnd_time = 10;
  private static final int fieldNumberFrom_email = 32;
  private static final int fieldNumberFrom_nick = 33;
  private static final int fieldNumberImage_md5 = 7;
  private static final int fieldNumberImage_times = 21;
  private static final int fieldNumberImage_url = 6;
  private static final int fieldNumberIs_stop = 47;
  private static final int fieldNumberNeed_qq_account = 17;
  private static final int fieldNumberNeed_wifi = 40;
  private static final int fieldNumberOpen_url = 8;
  private static final int fieldNumberPage = 3;
  private static final int fieldNumberPopularize_app_name = 22;
  private static final int fieldNumberPopularize_app_version = 30;
  private static final int fieldNumberProduct_id = 48;
  private static final int fieldNumberRelated_id = 28;
  private static final int fieldNumberReport_id = 39;
  private static final int fieldNumberReset = 27;
  private static final int fieldNumberResource_type = 31;
  private static final int fieldNumberSession_type = 38;
  private static final int fieldNumberShow_type = 5;
  private static final int fieldNumberStart_time = 9;
  private static final int fieldNumberSub_abstracts = 44;
  private static final int fieldNumberSub_from_nick = 42;
  private static final int fieldNumberSub_image_md5 = 16;
  private static final int fieldNumberSub_image_url = 15;
  private static final int fieldNumberSub_information = 14;
  private static final int fieldNumberSub_items = 25;
  private static final int fieldNumberSub_subject = 43;
  private static final int fieldNumberSubject = 11;
  private static final int fieldNumberSvr_id = 1;
  private static final int fieldNumberTurn_id = 49;
  private static final int fieldNumberType = 2;
  private static final int fieldNumberWeight = 24;
  public ByteString abstracts;
  public int action = -2147483648;
  public ByteString adxml;
  public PopularizeAppConfig app_config;
  public int app_install_action = -2147483648;
  public ByteString avatar_md5;
  public ByteString avatar_url;
  public double banner_height = 4.9E-324D;
  public int banner_position = -2147483648;
  public int condition = -2147483648;
  public boolean config_head;
  public boolean config_list;
  public boolean config_mark;
  public boolean config_tool;
  public ByteString content;
  public double duration = 4.9E-324D;
  public double end_time = 4.9E-324D;
  public ByteString from_email;
  public ByteString from_nick;
  public ByteString image_md5;
  public int image_times = -2147483648;
  public ByteString image_url;
  public boolean is_stop;
  public boolean need_qq_account;
  public boolean need_wifi;
  public ByteString open_url;
  public int page = -2147483648;
  public ByteString popularize_app_name;
  public ByteString popularize_app_version;
  public int product_id = -2147483648;
  public int related_id = -2147483648;
  public int report_id = -2147483648;
  public boolean reset;
  public int resource_type = -2147483648;
  public int session_type = -2147483648;
  public int show_type = -2147483648;
  public double start_time = 4.9E-324D;
  public ByteString sub_abstracts;
  public ByteString sub_from_nick;
  public ByteString sub_image_md5;
  public ByteString sub_image_url;
  public ByteString sub_information;
  public LinkedList<PopularizeSubItem> sub_items = new LinkedList();
  public ByteString sub_subject;
  public ByteString subject;
  public int svr_id = -2147483648;
  public int turn_id = -2147483648;
  public int type = -2147483648;
  public int weight = -2147483648;
  
  public final int computeSize()
  {
    int j = 0;
    if (this.svr_id != -2147483648) {
      j = 0 + ComputeSizeUtil.computeIntegerSize(1, this.svr_id);
    }
    int i = j;
    if (this.type != -2147483648) {
      i = j + ComputeSizeUtil.computeIntegerSize(2, this.type);
    }
    j = i;
    if (this.page != -2147483648) {
      j = i + ComputeSizeUtil.computeIntegerSize(3, this.page);
    }
    i = j;
    if (this.banner_position != -2147483648) {
      i = j + ComputeSizeUtil.computeIntegerSize(4, this.banner_position);
    }
    j = i;
    if (this.show_type != -2147483648) {
      j = i + ComputeSizeUtil.computeIntegerSize(5, this.show_type);
    }
    i = j;
    if (this.image_url != null) {
      i = j + ComputeSizeUtil.computeByteStringSize(6, this.image_url);
    }
    j = i;
    if (this.image_md5 != null) {
      j = i + ComputeSizeUtil.computeByteStringSize(7, this.image_md5);
    }
    i = j;
    if (this.open_url != null) {
      i = j + ComputeSizeUtil.computeByteStringSize(8, this.open_url);
    }
    j = i;
    if (this.start_time != 4.9E-324D) {
      j = i + ComputeSizeUtil.computeDoubleSize(9, this.start_time);
    }
    i = j;
    if (this.end_time != 4.9E-324D) {
      i = j + ComputeSizeUtil.computeDoubleSize(10, this.end_time);
    }
    j = i;
    if (this.subject != null) {
      j = i + ComputeSizeUtil.computeByteStringSize(11, this.subject);
    }
    i = j;
    if (this.abstracts != null) {
      i = j + ComputeSizeUtil.computeByteStringSize(12, this.abstracts);
    }
    j = i;
    if (this.content != null) {
      j = i + ComputeSizeUtil.computeByteStringSize(13, this.content);
    }
    i = j;
    if (this.sub_information != null) {
      i = j + ComputeSizeUtil.computeByteStringSize(14, this.sub_information);
    }
    j = i;
    if (this.sub_image_url != null) {
      j = i + ComputeSizeUtil.computeByteStringSize(15, this.sub_image_url);
    }
    i = j;
    if (this.sub_image_md5 != null) {
      i = j + ComputeSizeUtil.computeByteStringSize(16, this.sub_image_md5);
    }
    j = i + ComputeSizeUtil.computeBooleanSize(17, this.need_qq_account);
    i = j;
    if (this.banner_height != 4.9E-324D) {
      i = j + ComputeSizeUtil.computeDoubleSize(18, this.banner_height);
    }
    j = i;
    if (this.duration != 4.9E-324D) {
      j = i + ComputeSizeUtil.computeDoubleSize(19, this.duration);
    }
    i = j;
    if (this.action != -2147483648) {
      i = j + ComputeSizeUtil.computeIntegerSize(20, this.action);
    }
    j = i;
    if (this.image_times != -2147483648) {
      j = i + ComputeSizeUtil.computeIntegerSize(21, this.image_times);
    }
    i = j;
    if (this.popularize_app_name != null) {
      i = j + ComputeSizeUtil.computeByteStringSize(22, this.popularize_app_name);
    }
    j = i;
    if (this.app_install_action != -2147483648) {
      j = i + ComputeSizeUtil.computeIntegerSize(23, this.app_install_action);
    }
    i = j;
    if (this.weight != -2147483648) {
      i = j + ComputeSizeUtil.computeIntegerSize(24, this.weight);
    }
    j = i + ComputeSizeUtil.computeListSize(25, 8, this.sub_items);
    i = j;
    if (this.condition != -2147483648) {
      i = j + ComputeSizeUtil.computeIntegerSize(26, this.condition);
    }
    j = i + ComputeSizeUtil.computeBooleanSize(27, this.reset);
    i = j;
    if (this.related_id != -2147483648) {
      i = j + ComputeSizeUtil.computeIntegerSize(28, this.related_id);
    }
    j = i;
    if (this.app_config != null) {
      j = i + ComputeSizeUtil.computeMessageSize(29, this.app_config.computeSize());
    }
    i = j;
    if (this.popularize_app_version != null) {
      i = j + ComputeSizeUtil.computeByteStringSize(30, this.popularize_app_version);
    }
    j = i;
    if (this.resource_type != -2147483648) {
      j = i + ComputeSizeUtil.computeIntegerSize(31, this.resource_type);
    }
    i = j;
    if (this.from_email != null) {
      i = j + ComputeSizeUtil.computeByteStringSize(32, this.from_email);
    }
    j = i;
    if (this.from_nick != null) {
      j = i + ComputeSizeUtil.computeByteStringSize(33, this.from_nick);
    }
    j = j + ComputeSizeUtil.computeBooleanSize(34, this.config_head) + ComputeSizeUtil.computeBooleanSize(35, this.config_tool) + ComputeSizeUtil.computeBooleanSize(36, this.config_list) + ComputeSizeUtil.computeBooleanSize(37, this.config_mark);
    i = j;
    if (this.session_type != -2147483648) {
      i = j + ComputeSizeUtil.computeIntegerSize(38, this.session_type);
    }
    j = i;
    if (this.report_id != -2147483648) {
      j = i + ComputeSizeUtil.computeIntegerSize(39, this.report_id);
    }
    j += ComputeSizeUtil.computeBooleanSize(40, this.need_wifi);
    i = j;
    if (this.adxml != null) {
      i = j + ComputeSizeUtil.computeByteStringSize(41, this.adxml);
    }
    j = i;
    if (this.sub_from_nick != null) {
      j = i + ComputeSizeUtil.computeByteStringSize(42, this.sub_from_nick);
    }
    i = j;
    if (this.sub_subject != null) {
      i = j + ComputeSizeUtil.computeByteStringSize(43, this.sub_subject);
    }
    j = i;
    if (this.sub_abstracts != null) {
      j = i + ComputeSizeUtil.computeByteStringSize(44, this.sub_abstracts);
    }
    i = j;
    if (this.avatar_url != null) {
      i = j + ComputeSizeUtil.computeByteStringSize(45, this.avatar_url);
    }
    j = i;
    if (this.avatar_md5 != null) {
      j = i + ComputeSizeUtil.computeByteStringSize(46, this.avatar_md5);
    }
    j += ComputeSizeUtil.computeBooleanSize(47, this.is_stop);
    i = j;
    if (this.product_id != -2147483648) {
      i = j + ComputeSizeUtil.computeIntegerSize(48, this.product_id);
    }
    j = i;
    if (this.turn_id != -2147483648) {
      j = i + ComputeSizeUtil.computeIntegerSize(49, this.turn_id);
    }
    return j;
  }
  
  public final PopularizeConfig parseFrom(byte[] paramArrayOfByte)
    throws IOException
  {
    this.sub_items.clear();
    paramArrayOfByte = new InputReader(paramArrayOfByte, unknownTagHandler);
    for (int i = getNextFieldNumber(paramArrayOfByte); i > 0; i = getNextFieldNumber(paramArrayOfByte)) {
      if (!populateBuilderWithField(paramArrayOfByte, this, i)) {
        paramArrayOfByte.getPreviousTagDataTypeAndReadContent();
      }
    }
    return this;
  }
  
  public final boolean populateBuilderWithField(InputReader paramInputReader, PopularizeConfig paramPopularizeConfig, int paramInt)
    throws IOException
  {
    int i;
    Object localObject2;
    Object localObject1;
    boolean bool;
    switch (paramInt)
    {
    default: 
      return false;
    case 1: 
      paramPopularizeConfig.svr_id = paramInputReader.readInteger(paramInt);
      return true;
    case 2: 
      paramPopularizeConfig.type = paramInputReader.readInteger(paramInt);
      return true;
    case 3: 
      paramPopularizeConfig.page = paramInputReader.readInteger(paramInt);
      return true;
    case 4: 
      paramPopularizeConfig.banner_position = paramInputReader.readInteger(paramInt);
      return true;
    case 5: 
      paramPopularizeConfig.show_type = paramInputReader.readInteger(paramInt);
      return true;
    case 6: 
      paramPopularizeConfig.image_url = paramInputReader.readByteString(paramInt);
      return true;
    case 7: 
      paramPopularizeConfig.image_md5 = paramInputReader.readByteString(paramInt);
      return true;
    case 8: 
      paramPopularizeConfig.open_url = paramInputReader.readByteString(paramInt);
      return true;
    case 9: 
      paramPopularizeConfig.start_time = paramInputReader.readDouble(paramInt);
      return true;
    case 10: 
      paramPopularizeConfig.end_time = paramInputReader.readDouble(paramInt);
      return true;
    case 11: 
      paramPopularizeConfig.subject = paramInputReader.readByteString(paramInt);
      return true;
    case 12: 
      paramPopularizeConfig.abstracts = paramInputReader.readByteString(paramInt);
      return true;
    case 13: 
      paramPopularizeConfig.content = paramInputReader.readByteString(paramInt);
      return true;
    case 14: 
      paramPopularizeConfig.sub_information = paramInputReader.readByteString(paramInt);
      return true;
    case 15: 
      paramPopularizeConfig.sub_image_url = paramInputReader.readByteString(paramInt);
      return true;
    case 16: 
      paramPopularizeConfig.sub_image_md5 = paramInputReader.readByteString(paramInt);
      return true;
    case 17: 
      paramPopularizeConfig.need_qq_account = paramInputReader.readBoolean(paramInt);
      return true;
    case 18: 
      paramPopularizeConfig.banner_height = paramInputReader.readDouble(paramInt);
      return true;
    case 19: 
      paramPopularizeConfig.duration = paramInputReader.readDouble(paramInt);
      return true;
    case 20: 
      paramPopularizeConfig.action = paramInputReader.readInteger(paramInt);
      return true;
    case 21: 
      paramPopularizeConfig.image_times = paramInputReader.readInteger(paramInt);
      return true;
    case 22: 
      paramPopularizeConfig.popularize_app_name = paramInputReader.readByteString(paramInt);
      return true;
    case 23: 
      paramPopularizeConfig.app_install_action = paramInputReader.readInteger(paramInt);
      return true;
    case 24: 
      paramPopularizeConfig.weight = paramInputReader.readInteger(paramInt);
      return true;
    case 25: 
      paramInputReader = paramInputReader.readMessages(paramInt);
      i = paramInputReader.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramInputReader.get(paramInt);
        localObject1 = new PopularizeSubItem();
        localObject2 = new InputReader((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((PopularizeSubItem)localObject1).populateBuilderWithField((InputReader)localObject2, (PopularizeSubItem)localObject1, getNextFieldNumber((InputReader)localObject2))) {}
        paramPopularizeConfig.sub_items.add(localObject1);
        paramInt += 1;
      }
      return true;
    case 26: 
      paramPopularizeConfig.condition = paramInputReader.readInteger(paramInt);
      return true;
    case 27: 
      paramPopularizeConfig.reset = paramInputReader.readBoolean(paramInt);
      return true;
    case 28: 
      paramPopularizeConfig.related_id = paramInputReader.readInteger(paramInt);
      return true;
    case 29: 
      paramInputReader = paramInputReader.readMessages(paramInt);
      i = paramInputReader.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramInputReader.get(paramInt);
        localObject1 = new PopularizeAppConfig();
        localObject2 = new InputReader((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((PopularizeAppConfig)localObject1).populateBuilderWithField((InputReader)localObject2, (PopularizeAppConfig)localObject1, getNextFieldNumber((InputReader)localObject2))) {}
        paramPopularizeConfig.app_config = ((PopularizeAppConfig)localObject1);
        paramInt += 1;
      }
      return true;
    case 30: 
      paramPopularizeConfig.popularize_app_version = paramInputReader.readByteString(paramInt);
      return true;
    case 31: 
      paramPopularizeConfig.resource_type = paramInputReader.readInteger(paramInt);
      return true;
    case 32: 
      paramPopularizeConfig.from_email = paramInputReader.readByteString(paramInt);
      return true;
    case 33: 
      paramPopularizeConfig.from_nick = paramInputReader.readByteString(paramInt);
      return true;
    case 34: 
      paramPopularizeConfig.config_head = paramInputReader.readBoolean(paramInt);
      return true;
    case 35: 
      paramPopularizeConfig.config_tool = paramInputReader.readBoolean(paramInt);
      return true;
    case 36: 
      paramPopularizeConfig.config_list = paramInputReader.readBoolean(paramInt);
      return true;
    case 37: 
      paramPopularizeConfig.config_mark = paramInputReader.readBoolean(paramInt);
      return true;
    case 38: 
      paramPopularizeConfig.session_type = paramInputReader.readInteger(paramInt);
      return true;
    case 39: 
      paramPopularizeConfig.report_id = paramInputReader.readInteger(paramInt);
      return true;
    case 40: 
      paramPopularizeConfig.need_wifi = paramInputReader.readBoolean(paramInt);
      return true;
    case 41: 
      paramPopularizeConfig.adxml = paramInputReader.readByteString(paramInt);
      return true;
    case 42: 
      paramPopularizeConfig.sub_from_nick = paramInputReader.readByteString(paramInt);
      return true;
    case 43: 
      paramPopularizeConfig.sub_subject = paramInputReader.readByteString(paramInt);
      return true;
    case 44: 
      paramPopularizeConfig.sub_abstracts = paramInputReader.readByteString(paramInt);
      return true;
    case 45: 
      paramPopularizeConfig.avatar_url = paramInputReader.readByteString(paramInt);
      return true;
    case 46: 
      paramPopularizeConfig.avatar_md5 = paramInputReader.readByteString(paramInt);
      return true;
    case 47: 
      paramPopularizeConfig.is_stop = paramInputReader.readBoolean(paramInt);
      return true;
    case 48: 
      paramPopularizeConfig.product_id = paramInputReader.readInteger(paramInt);
      return true;
    }
    paramPopularizeConfig.turn_id = paramInputReader.readInteger(paramInt);
    return true;
  }
  
  public final void writeFields(OutputWriter paramOutputWriter)
    throws IOException
  {
    if (this.svr_id != -2147483648) {
      paramOutputWriter.writeInteger(1, this.svr_id);
    }
    if (this.type != -2147483648) {
      paramOutputWriter.writeInteger(2, this.type);
    }
    if (this.page != -2147483648) {
      paramOutputWriter.writeInteger(3, this.page);
    }
    if (this.banner_position != -2147483648) {
      paramOutputWriter.writeInteger(4, this.banner_position);
    }
    if (this.show_type != -2147483648) {
      paramOutputWriter.writeInteger(5, this.show_type);
    }
    if (this.image_url != null) {
      paramOutputWriter.writeByteString(6, this.image_url);
    }
    if (this.image_md5 != null) {
      paramOutputWriter.writeByteString(7, this.image_md5);
    }
    if (this.open_url != null) {
      paramOutputWriter.writeByteString(8, this.open_url);
    }
    if (this.start_time != 4.9E-324D) {
      paramOutputWriter.writeDouble(9, this.start_time);
    }
    if (this.end_time != 4.9E-324D) {
      paramOutputWriter.writeDouble(10, this.end_time);
    }
    if (this.subject != null) {
      paramOutputWriter.writeByteString(11, this.subject);
    }
    if (this.abstracts != null) {
      paramOutputWriter.writeByteString(12, this.abstracts);
    }
    if (this.content != null) {
      paramOutputWriter.writeByteString(13, this.content);
    }
    if (this.sub_information != null) {
      paramOutputWriter.writeByteString(14, this.sub_information);
    }
    if (this.sub_image_url != null) {
      paramOutputWriter.writeByteString(15, this.sub_image_url);
    }
    if (this.sub_image_md5 != null) {
      paramOutputWriter.writeByteString(16, this.sub_image_md5);
    }
    paramOutputWriter.writeBoolean(17, this.need_qq_account);
    if (this.banner_height != 4.9E-324D) {
      paramOutputWriter.writeDouble(18, this.banner_height);
    }
    if (this.duration != 4.9E-324D) {
      paramOutputWriter.writeDouble(19, this.duration);
    }
    if (this.action != -2147483648) {
      paramOutputWriter.writeInteger(20, this.action);
    }
    if (this.image_times != -2147483648) {
      paramOutputWriter.writeInteger(21, this.image_times);
    }
    if (this.popularize_app_name != null) {
      paramOutputWriter.writeByteString(22, this.popularize_app_name);
    }
    if (this.app_install_action != -2147483648) {
      paramOutputWriter.writeInteger(23, this.app_install_action);
    }
    if (this.weight != -2147483648) {
      paramOutputWriter.writeInteger(24, this.weight);
    }
    paramOutputWriter.writeList(25, 8, this.sub_items);
    if (this.condition != -2147483648) {
      paramOutputWriter.writeInteger(26, this.condition);
    }
    paramOutputWriter.writeBoolean(27, this.reset);
    if (this.related_id != -2147483648) {
      paramOutputWriter.writeInteger(28, this.related_id);
    }
    if (this.app_config != null)
    {
      paramOutputWriter.writeMessage(29, this.app_config.computeSize());
      this.app_config.writeFields(paramOutputWriter);
    }
    if (this.popularize_app_version != null) {
      paramOutputWriter.writeByteString(30, this.popularize_app_version);
    }
    if (this.resource_type != -2147483648) {
      paramOutputWriter.writeInteger(31, this.resource_type);
    }
    if (this.from_email != null) {
      paramOutputWriter.writeByteString(32, this.from_email);
    }
    if (this.from_nick != null) {
      paramOutputWriter.writeByteString(33, this.from_nick);
    }
    paramOutputWriter.writeBoolean(34, this.config_head);
    paramOutputWriter.writeBoolean(35, this.config_tool);
    paramOutputWriter.writeBoolean(36, this.config_list);
    paramOutputWriter.writeBoolean(37, this.config_mark);
    if (this.session_type != -2147483648) {
      paramOutputWriter.writeInteger(38, this.session_type);
    }
    if (this.report_id != -2147483648) {
      paramOutputWriter.writeInteger(39, this.report_id);
    }
    paramOutputWriter.writeBoolean(40, this.need_wifi);
    if (this.adxml != null) {
      paramOutputWriter.writeByteString(41, this.adxml);
    }
    if (this.sub_from_nick != null) {
      paramOutputWriter.writeByteString(42, this.sub_from_nick);
    }
    if (this.sub_subject != null) {
      paramOutputWriter.writeByteString(43, this.sub_subject);
    }
    if (this.sub_abstracts != null) {
      paramOutputWriter.writeByteString(44, this.sub_abstracts);
    }
    if (this.avatar_url != null) {
      paramOutputWriter.writeByteString(45, this.avatar_url);
    }
    if (this.avatar_md5 != null) {
      paramOutputWriter.writeByteString(46, this.avatar_md5);
    }
    paramOutputWriter.writeBoolean(47, this.is_stop);
    if (this.product_id != -2147483648) {
      paramOutputWriter.writeInteger(48, this.product_id);
    }
    if (this.turn_id != -2147483648) {
      paramOutputWriter.writeInteger(49, this.turn_id);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.protocol.UMA.PopularizeConfig
 * JD-Core Version:    0.7.0.1
 */