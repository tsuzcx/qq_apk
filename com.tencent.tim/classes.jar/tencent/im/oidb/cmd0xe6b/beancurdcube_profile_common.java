package tencent.im.oidb.cmd0xe6b;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import tencent.im.oidb.cmd0xd2d.oidb_cmd0xd2d_common.EduHis;

public final class beancurdcube_profile_common
{
  public static final class BeancurdcubeProfile
    extends MessageMicro<BeancurdcubeProfile>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_beancurdcube_profile_info" }, new Object[] { null }, BeancurdcubeProfile.class);
    public final PBRepeatMessageField<beancurdcube_profile_common.BeancurdcubeProfileInfo> rpt_beancurdcube_profile_info = PBField.initRepeatMessage(beancurdcube_profile_common.BeancurdcubeProfileInfo.class);
  }
  
  public static final class BeancurdcubeProfileInfo
    extends MessageMicro<BeancurdcubeProfileInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 160018, 160090, 160154, 160250, 160258, 192018, 192066, 216298, 218114 }, new String[] { "enum_beancurdcube_profile_type", "uint32_last_modify_time", "msg_nickname", "msg_email", "msg_intro", "msg_birthday", "msg_location", "msg_homeland", "msg_company", "msg_occupation", "msg_education" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), null, null, null, null, null, null, null, null, null }, BeancurdcubeProfileInfo.class);
    public final PBUInt32Field enum_beancurdcube_profile_type = PBField.initUInt32(0);
    public beancurdcube_profile_common.ProfileBirthday msg_birthday = new beancurdcube_profile_common.ProfileBirthday();
    public beancurdcube_profile_common.ProfileCompany msg_company = new beancurdcube_profile_common.ProfileCompany();
    public beancurdcube_profile_common.ProfileEducation msg_education = new beancurdcube_profile_common.ProfileEducation();
    public beancurdcube_profile_common.ProfileEmail msg_email = new beancurdcube_profile_common.ProfileEmail();
    public beancurdcube_profile_common.ProfileHomeLand msg_homeland = new beancurdcube_profile_common.ProfileHomeLand();
    public beancurdcube_profile_common.ProfileIntro msg_intro = new beancurdcube_profile_common.ProfileIntro();
    public beancurdcube_profile_common.ProfileLocation msg_location = new beancurdcube_profile_common.ProfileLocation();
    public beancurdcube_profile_common.ProfileNickname msg_nickname = new beancurdcube_profile_common.ProfileNickname();
    public beancurdcube_profile_common.ProfileOccupation msg_occupation = new beancurdcube_profile_common.ProfileOccupation();
    public final PBUInt32Field uint32_last_modify_time = PBField.initUInt32(0);
  }
  
  public static final class ProfileBirthday
    extends MessageMicro<ProfileBirthday>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "uint32_birthday" }, new Object[] { Integer.valueOf(0) }, ProfileBirthday.class);
    public final PBUInt32Field uint32_birthday = PBField.initUInt32(0);
  }
  
  public static final class ProfileCompany
    extends MessageMicro<ProfileCompany>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField company_name = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "company_name" }, new Object[] { localByteStringMicro }, ProfileCompany.class);
    }
  }
  
  public static final class ProfileEducation
    extends MessageMicro<ProfileEducation>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "msg_edu" }, new Object[] { null }, ProfileEducation.class);
    public oidb_cmd0xd2d_common.EduHis msg_edu = new oidb_cmd0xd2d_common.EduHis();
  }
  
  public static final class ProfileEmail
    extends MessageMicro<ProfileEmail>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_email = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "bytes_email" }, new Object[] { localByteStringMicro }, ProfileEmail.class);
    }
  }
  
  public static final class ProfileHomeLand
    extends MessageMicro<ProfileHomeLand>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "uint32_nation", "uint32_province", "uint32_city", "uint32_district" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, ProfileHomeLand.class);
    public final PBUInt32Field uint32_city = PBField.initUInt32(0);
    public final PBUInt32Field uint32_district = PBField.initUInt32(0);
    public final PBUInt32Field uint32_nation = PBField.initUInt32(0);
    public final PBUInt32Field uint32_province = PBField.initUInt32(0);
  }
  
  public static final class ProfileIntro
    extends MessageMicro<ProfileIntro>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_intro = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "bytes_intro" }, new Object[] { localByteStringMicro }, ProfileIntro.class);
    }
  }
  
  public static final class ProfileLocation
    extends MessageMicro<ProfileLocation>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "uint32_nation", "uint32_province", "uint32_city", "uint32_district" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, ProfileLocation.class);
    public final PBUInt32Field uint32_city = PBField.initUInt32(0);
    public final PBUInt32Field uint32_district = PBField.initUInt32(0);
    public final PBUInt32Field uint32_nation = PBField.initUInt32(0);
    public final PBUInt32Field uint32_province = PBField.initUInt32(0);
  }
  
  public static final class ProfileNickname
    extends MessageMicro<ProfileNickname>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_nickname = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "bytes_nickname" }, new Object[] { localByteStringMicro }, ProfileNickname.class);
    }
  }
  
  public static final class ProfileOccupation
    extends MessageMicro<ProfileOccupation>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "uint32_occupation_id" }, new Object[] { Integer.valueOf(0) }, ProfileOccupation.class);
    public final PBUInt32Field uint32_occupation_id = PBField.initUInt32(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0xe6b.beancurdcube_profile_common
 * JD-Core Version:    0.7.0.1
 */