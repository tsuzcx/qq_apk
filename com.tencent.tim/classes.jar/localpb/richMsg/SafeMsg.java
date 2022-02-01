package localpb.richMsg;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class SafeMsg
{
  public static final class SafeMoreInfo
    extends MessageMicro<SafeMoreInfo>
  {
    public static final int STRFROMMOBILE_FIELD_NUMBER = 2;
    public static final int STRFROMNAME_FIELD_NUMBER = 3;
    public static final int STRMSGTXT_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "strMsgTxt", "strFromMobile", "strFromName" }, new Object[] { "", "", "" }, SafeMoreInfo.class);
    public static final SafeMoreInfo __repeatHelper__ = new SafeMoreInfo();
    public final PBStringField strFromMobile = PBField.initString("");
    public final PBStringField strFromName = PBField.initString("");
    public final PBStringField strMsgTxt = PBField.initString("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     localpb.richMsg.SafeMsg
 * JD-Core Version:    0.7.0.1
 */