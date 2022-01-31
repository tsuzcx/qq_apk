import android.os.Bundle;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.ConditionSearchManager;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.util.NearbyProfileUtil;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class zhz
  implements Runnable
{
  public zhz(CardHandler paramCardHandler, Bundle paramBundle) {}
  
  public void run()
  {
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
    localOIDBSSOPkg.uint32_command.set(1279);
    localOIDBSSOPkg.uint32_result.set(0);
    localOIDBSSOPkg.uint32_service_type.set(9);
    Object localObject2 = ((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppCardHandler.b.getManager(50)).b(this.jdField_a_of_type_ComTencentMobileqqAppCardHandler.b.getCurrentAccountUin());
    Object localObject1 = ByteBuffer.allocate(1000);
    int i;
    if (this.jdField_a_of_type_AndroidOsBundle.containsKey("nick"))
    {
      j = this.jdField_a_of_type_AndroidOsBundle.getString("nick").getBytes().length;
      i = j + 4 + 0;
      ((ByteBuffer)localObject1).putShort((short)20002);
      ((ByteBuffer)localObject1).putShort((short)this.jdField_a_of_type_AndroidOsBundle.getString("nick").getBytes().length);
      ((ByteBuffer)localObject1).put(this.jdField_a_of_type_AndroidOsBundle.getString("nick").getBytes());
      if (QLog.isColorLevel()) {
        QLog.d("CardHandler", 2, "set nick | length = " + j + " | nick = " + this.jdField_a_of_type_AndroidOsBundle.getString("nick"));
      }
    }
    for (int j = 1;; j = 0)
    {
      int k = i;
      int m = j;
      if (this.jdField_a_of_type_AndroidOsBundle.containsKey("sex"))
      {
        j += 1;
        i += 5;
        ((ByteBuffer)localObject1).putShort((short)20009);
        ((ByteBuffer)localObject1).putShort((short)1);
        ((ByteBuffer)localObject1).put((byte)(this.jdField_a_of_type_AndroidOsBundle.getByte("sex") + 1));
        k = i;
        m = j;
        if (QLog.isColorLevel())
        {
          QLog.d("CardHandler", 2, "set sex | sex = " + this.jdField_a_of_type_AndroidOsBundle.getByte("sex"));
          m = j;
          k = i;
        }
      }
      i = k;
      j = m;
      if (this.jdField_a_of_type_AndroidOsBundle.containsKey("birthday"))
      {
        m += 1;
        k += 8;
        ((ByteBuffer)localObject1).putShort((short)26003);
        ((ByteBuffer)localObject1).putShort((short)4);
        ((ByteBuffer)localObject1).putInt(this.jdField_a_of_type_AndroidOsBundle.getInt("birthday"));
        i = k;
        j = m;
        if (QLog.isColorLevel())
        {
          QLog.d("CardHandler", 2, "set birthday | birthday = " + this.jdField_a_of_type_AndroidOsBundle.getInt("birthday") + " | age = " + this.jdField_a_of_type_AndroidOsBundle.getInt("age"));
          j = m;
          i = k;
        }
      }
      k = i;
      int n = j;
      if (this.jdField_a_of_type_AndroidOsBundle.containsKey("profession"))
      {
        k = this.jdField_a_of_type_AndroidOsBundle.getInt("profession");
        int i1 = i;
        m = j;
        if (NearbyProfileUtil.a(k))
        {
          m = j + 1;
          i1 = i + 8;
          ((ByteBuffer)localObject1).putShort((short)27037);
          ((ByteBuffer)localObject1).putShort((short)4);
          ((ByteBuffer)localObject1).putInt(k);
        }
        k = i1;
        n = m;
        if (QLog.isColorLevel())
        {
          QLog.d("CardHandler", 2, "set profession | profession = " + this.jdField_a_of_type_AndroidOsBundle.getInt("profession"));
          n = m;
          k = i1;
        }
      }
      i = k;
      m = n;
      if (this.jdField_a_of_type_AndroidOsBundle.containsKey("company"))
      {
        j = n + 1;
        n = this.jdField_a_of_type_AndroidOsBundle.getString("company").getBytes().length;
        k += n + 4;
        ((ByteBuffer)localObject1).putShort((short)24008);
        ((ByteBuffer)localObject1).putShort((short)n);
        ((ByteBuffer)localObject1).put(this.jdField_a_of_type_AndroidOsBundle.getString("company").getBytes());
        i = k;
        m = j;
        if (QLog.isColorLevel())
        {
          QLog.d("CardHandler", 2, "set company | length = " + n + " | company = " + this.jdField_a_of_type_AndroidOsBundle.getString("company"));
          m = j;
          i = k;
        }
      }
      j = i;
      k = m;
      if (this.jdField_a_of_type_AndroidOsBundle.containsKey("college"))
      {
        m += 1;
        n = this.jdField_a_of_type_AndroidOsBundle.getString("college").getBytes().length;
        i += n + 4;
        ((ByteBuffer)localObject1).putShort((short)20021);
        ((ByteBuffer)localObject1).putShort((short)n);
        ((ByteBuffer)localObject1).put(this.jdField_a_of_type_AndroidOsBundle.getString("college").getBytes());
        j = i;
        k = m;
        if (QLog.isColorLevel())
        {
          QLog.d("CardHandler", 2, "set college | length = " + n + " | college = " + this.jdField_a_of_type_AndroidOsBundle.getString("college"));
          k = m;
          j = i;
        }
      }
      i = j;
      m = k;
      String[] arrayOfString;
      if (this.jdField_a_of_type_AndroidOsBundle.containsKey("location"))
      {
        k += 2;
        j += 24;
        arrayOfString = this.jdField_a_of_type_AndroidOsBundle.getStringArray("location");
        ((ByteBuffer)localObject1).putShort((short)20032).putShort((short)12).putInt(ConditionSearchManager.a(arrayOfString[0])).putInt(ConditionSearchManager.a(arrayOfString[1])).putInt(ConditionSearchManager.a(arrayOfString[2]));
        ((ByteBuffer)localObject1).putShort((short)20041).putShort((short)4).putInt(ConditionSearchManager.a(arrayOfString[3]));
        i = j;
        m = k;
        if (QLog.isColorLevel())
        {
          QLog.d("CardHandler", 2, "set location | location = " + arrayOfString.toString() + ", code one = " + arrayOfString[0]);
          m = k;
          i = j;
        }
      }
      j = i;
      n = m;
      if (this.jdField_a_of_type_AndroidOsBundle.containsKey("hometown"))
      {
        k = m + 2;
        i += 24;
        arrayOfString = this.jdField_a_of_type_AndroidOsBundle.getStringArray("hometown");
        ((ByteBuffer)localObject1).putShort((short)24002).putShort((short)12).putInt(ConditionSearchManager.a(arrayOfString[0])).putInt(ConditionSearchManager.a(arrayOfString[1])).putInt(ConditionSearchManager.a(arrayOfString[2]));
        ((ByteBuffer)localObject1).putShort((short)20043).putShort((short)4).putInt(ConditionSearchManager.a(arrayOfString[3]));
        j = i;
        n = k;
        if (QLog.isColorLevel())
        {
          QLog.d("CardHandler", 2, "set hometown | hometown = " + arrayOfString.toString());
          n = k;
          j = i;
        }
      }
      i = j;
      k = n;
      if (this.jdField_a_of_type_AndroidOsBundle.containsKey("email"))
      {
        m = n + 1;
        n = this.jdField_a_of_type_AndroidOsBundle.getString("email").getBytes().length;
        j += n + 4;
        ((ByteBuffer)localObject1).putShort((short)20011).putShort((short)n).put(this.jdField_a_of_type_AndroidOsBundle.getString("email").getBytes());
        i = j;
        k = m;
        if (QLog.isColorLevel())
        {
          QLog.d("CardHandler", 2, "set email | length = " + n + " | email = " + this.jdField_a_of_type_AndroidOsBundle.getString("email"));
          k = m;
          i = j;
        }
      }
      j = i;
      m = k;
      if (this.jdField_a_of_type_AndroidOsBundle.containsKey("personalNote"))
      {
        k += 1;
        n = this.jdField_a_of_type_AndroidOsBundle.getString("personalNote").getBytes().length;
        i += n + 4;
        ((ByteBuffer)localObject1).putShort((short)20019).putShort((short)n).put(this.jdField_a_of_type_AndroidOsBundle.getString("personalNote").getBytes());
        j = i;
        m = k;
        if (QLog.isColorLevel())
        {
          QLog.d("CardHandler", 2, "set note | length = " + n + " | note = " + this.jdField_a_of_type_AndroidOsBundle.getString("personalNote"));
          m = k;
          j = i;
        }
      }
      i = j;
      k = m;
      if (this.jdField_a_of_type_AndroidOsBundle.containsKey("key_interest_switch"))
      {
        m += 1;
        j += 6;
        ((ByteBuffer)localObject1).putShort((short)-25223);
        ((ByteBuffer)localObject1).putShort((short)2);
        ((ByteBuffer)localObject1).putShort(this.jdField_a_of_type_AndroidOsBundle.getShort("key_interest_switch"));
        i = j;
        k = m;
        if (QLog.isColorLevel())
        {
          QLog.d("CardHandler", 2, "set interest_switch | length = 2 | interest_switch = " + this.jdField_a_of_type_AndroidOsBundle.getShort("key_interest_switch"));
          k = m;
          i = j;
        }
      }
      j = i;
      m = k;
      if (this.jdField_a_of_type_AndroidOsBundle.containsKey("key_joined_group_switch"))
      {
        k += 1;
        i += 6;
        ((ByteBuffer)localObject1).putShort((short)-25219);
        ((ByteBuffer)localObject1).putShort((short)2);
        ((ByteBuffer)localObject1).putShort(this.jdField_a_of_type_AndroidOsBundle.getShort("key_joined_group_switch"));
        j = i;
        m = k;
        if (QLog.isColorLevel())
        {
          QLog.d("CardHandler", 2, "set joined_group_switch | length = 2 | joined_group_switch = " + this.jdField_a_of_type_AndroidOsBundle.getShort("key_joined_group_switch"));
          m = k;
          j = i;
        }
      }
      i = j;
      k = m;
      if (this.jdField_a_of_type_AndroidOsBundle.containsKey("key_ktv_switch"))
      {
        m += 1;
        j += 6;
        ((ByteBuffer)localObject1).putShort((short)-25218);
        ((ByteBuffer)localObject1).putShort((short)2);
        ((ByteBuffer)localObject1).putShort(this.jdField_a_of_type_AndroidOsBundle.getShort("key_ktv_switch"));
        i = j;
        k = m;
        if (QLog.isColorLevel())
        {
          QLog.d("CardHandler", 2, "set ktv_switch | length = 2 | ktv_switch = " + this.jdField_a_of_type_AndroidOsBundle.getShort("key_ktv_switch"));
          k = m;
          i = j;
        }
      }
      j = i;
      m = k;
      if (this.jdField_a_of_type_AndroidOsBundle.containsKey("key_music_switch"))
      {
        k += 1;
        i += 6;
        ((ByteBuffer)localObject1).putShort((short)-25222);
        ((ByteBuffer)localObject1).putShort((short)2);
        ((ByteBuffer)localObject1).putShort(this.jdField_a_of_type_AndroidOsBundle.getShort("key_music_switch"));
        j = i;
        m = k;
        if (QLog.isColorLevel())
        {
          QLog.d("CardHandler", 2, "set music_switch | length = 2 | music_switch = " + this.jdField_a_of_type_AndroidOsBundle.getShort("key_music_switch"));
          m = k;
          j = i;
        }
      }
      i = j;
      k = m;
      if (this.jdField_a_of_type_AndroidOsBundle.containsKey("key_recent_activity_switch"))
      {
        m += 1;
        j += 6;
        ((ByteBuffer)localObject1).putShort((short)-25221);
        ((ByteBuffer)localObject1).putShort((short)2);
        ((ByteBuffer)localObject1).putShort(this.jdField_a_of_type_AndroidOsBundle.getShort("key_recent_activity_switch"));
        i = j;
        k = m;
        if (QLog.isColorLevel())
        {
          QLog.d("CardHandler", 2, "set recent_activity_switch | length = 2 | recent_activity_switch = " + this.jdField_a_of_type_AndroidOsBundle.getShort("key_recent_activity_switch"));
          k = m;
          i = j;
        }
      }
      j = i;
      m = k;
      if (this.jdField_a_of_type_AndroidOsBundle.containsKey("key_star_switch"))
      {
        k += 1;
        i += 6;
        ((ByteBuffer)localObject1).putShort((short)-25220);
        ((ByteBuffer)localObject1).putShort((short)2);
        ((ByteBuffer)localObject1).putShort(this.jdField_a_of_type_AndroidOsBundle.getShort("key_star_switch"));
        j = i;
        m = k;
        if (QLog.isColorLevel())
        {
          QLog.d("CardHandler", 2, "set star_switch | length = 2 | star_switch = " + this.jdField_a_of_type_AndroidOsBundle.getShort("key_star_switch"));
          m = k;
          j = i;
        }
      }
      i = j;
      k = m;
      if (this.jdField_a_of_type_AndroidOsBundle.containsKey("key_eat_switch"))
      {
        m += 1;
        j += 6;
        ((ByteBuffer)localObject1).putShort((short)-25216);
        ((ByteBuffer)localObject1).putShort((short)2);
        ((ByteBuffer)localObject1).putShort(this.jdField_a_of_type_AndroidOsBundle.getShort("key_eat_switch"));
        i = j;
        k = m;
        if (QLog.isColorLevel())
        {
          QLog.d("CardHandler", 2, "set eat_switch | length = 2 | eat_switch = " + this.jdField_a_of_type_AndroidOsBundle.getShort("key_eat_switch"));
          k = m;
          i = j;
        }
      }
      j = i;
      m = k;
      if (this.jdField_a_of_type_AndroidOsBundle.containsKey("key_reader_switch"))
      {
        k += 1;
        i += 6;
        ((ByteBuffer)localObject1).putShort((short)-23555);
        ((ByteBuffer)localObject1).putShort((short)2);
        ((ByteBuffer)localObject1).putShort(this.jdField_a_of_type_AndroidOsBundle.getShort("key_reader_switch"));
        j = i;
        m = k;
        if (QLog.isColorLevel())
        {
          QLog.d("CardHandler", 2, "set reader_switch | length = 2 | reader_switch = " + this.jdField_a_of_type_AndroidOsBundle.getShort("key_reader_switch"));
          m = k;
          j = i;
        }
      }
      i = j;
      k = m;
      if (this.jdField_a_of_type_AndroidOsBundle.containsKey("key_radio_switch"))
      {
        m += 1;
        j += 6;
        ((ByteBuffer)localObject1).putShort((short)-25201);
        ((ByteBuffer)localObject1).putShort((short)2);
        ((ByteBuffer)localObject1).putShort(this.jdField_a_of_type_AndroidOsBundle.getShort("key_radio_switch"));
        i = j;
        k = m;
        if (QLog.isColorLevel())
        {
          QLog.d("CardHandler", 2, "set radio_switch | length = 2 | radio_switch = " + this.jdField_a_of_type_AndroidOsBundle.getShort("key_radio_switch"));
          k = m;
          i = j;
        }
      }
      j = i;
      m = k;
      if (this.jdField_a_of_type_AndroidOsBundle.containsKey("key_comic_switch"))
      {
        k += 1;
        i += 6;
        ((ByteBuffer)localObject1).putShort((short)-25010);
        ((ByteBuffer)localObject1).putShort((short)2);
        ((ByteBuffer)localObject1).putShort(this.jdField_a_of_type_AndroidOsBundle.getShort("key_comic_switch"));
        j = i;
        m = k;
        if (QLog.isColorLevel())
        {
          QLog.d("CardHandler", 2, "set comic_switch | length = 2 | comic_switch = " + this.jdField_a_of_type_AndroidOsBundle.getShort("key_comic_switch"));
          m = k;
          j = i;
        }
      }
      i = j;
      k = m;
      if (this.jdField_a_of_type_AndroidOsBundle.containsKey("key_now_switch"))
      {
        m += 1;
        j += 6;
        ((ByteBuffer)localObject1).putShort((short)-25009);
        ((ByteBuffer)localObject1).putShort((short)2);
        ((ByteBuffer)localObject1).putShort(this.jdField_a_of_type_AndroidOsBundle.getShort("key_now_switch"));
        i = j;
        k = m;
        if (QLog.isColorLevel())
        {
          QLog.d("CardHandler", 2, "set now_switch | length = 2 | now_switch = " + this.jdField_a_of_type_AndroidOsBundle.getShort("key_now_switch"));
          k = m;
          i = j;
        }
      }
      j = i;
      m = k;
      if (this.jdField_a_of_type_AndroidOsBundle.containsKey("key_education_switch"))
      {
        k += 1;
        i += 6;
        ((ByteBuffer)localObject1).putShort((short)-25183);
        ((ByteBuffer)localObject1).putShort((short)2);
        ((ByteBuffer)localObject1).putShort(this.jdField_a_of_type_AndroidOsBundle.getShort("key_education_switch"));
        j = i;
        m = k;
        if (QLog.isColorLevel())
        {
          QLog.d("CardHandler", 2, "set education_switch | length = 2 | education_switch = " + this.jdField_a_of_type_AndroidOsBundle.getShort("key_education_switch"));
          m = k;
          j = i;
        }
      }
      i = j;
      k = m;
      if (this.jdField_a_of_type_AndroidOsBundle.containsKey("key_using_tim_switch"))
      {
        m += 1;
        j += 6;
        ((ByteBuffer)localObject1).putShort((short)-25178);
        ((ByteBuffer)localObject1).putShort((short)2);
        ((ByteBuffer)localObject1).putShort(this.jdField_a_of_type_AndroidOsBundle.getShort("key_using_tim_switch"));
        i = j;
        k = m;
        if (QLog.isColorLevel())
        {
          QLog.d("CardHandler", 2, "set using_tim_switch | length = 2 | using_tim_switch = " + this.jdField_a_of_type_AndroidOsBundle.getShort("key_using_tim_switch"));
          k = m;
          i = j;
        }
      }
      j = i;
      m = k;
      if (this.jdField_a_of_type_AndroidOsBundle.containsKey("key_weishi_switch"))
      {
        k += 1;
        i += 6;
        ((ByteBuffer)localObject1).putShort((short)-23363);
        ((ByteBuffer)localObject1).putShort((short)2);
        ((ByteBuffer)localObject1).putShort(this.jdField_a_of_type_AndroidOsBundle.getShort("key_weishi_switch"));
        j = i;
        m = k;
        if (QLog.isColorLevel())
        {
          QLog.d("CardHandler", 2, "set weishi_switch | length = 2 | weishi_switch = " + this.jdField_a_of_type_AndroidOsBundle.getShort("key_weishi_switch"));
          m = k;
          j = i;
        }
      }
      i = j;
      k = m;
      if (this.jdField_a_of_type_AndroidOsBundle.containsKey("key_personality_label_switch"))
      {
        m += 1;
        j += 6;
        ((ByteBuffer)localObject1).putShort((short)-23408);
        ((ByteBuffer)localObject1).putShort((short)2);
        ((ByteBuffer)localObject1).putShort(this.jdField_a_of_type_AndroidOsBundle.getShort("key_personality_label_switch"));
        i = j;
        k = m;
        if (QLog.isColorLevel())
        {
          QLog.d("CardHandler", 2, "set now_switch | length = 2 | personality_label_switch = " + this.jdField_a_of_type_AndroidOsBundle.getShort("key_personality_label_switch"));
          k = m;
          i = j;
        }
      }
      j = i;
      m = k;
      if (this.jdField_a_of_type_AndroidOsBundle.containsKey("key_extend_friend_switch"))
      {
        k += 1;
        i += 6;
        ((ByteBuffer)localObject1).putShort((short)-23364);
        ((ByteBuffer)localObject1).putShort((short)2);
        ((ByteBuffer)localObject1).putShort(this.jdField_a_of_type_AndroidOsBundle.getShort("key_extend_friend_switch"));
        j = i;
        m = k;
        if (QLog.isColorLevel())
        {
          QLog.d("CardHandler", 2, "set now_switch | length = 2 | extend_friend_switch = " + this.jdField_a_of_type_AndroidOsBundle.getShort("key_extend_friend_switch"));
          m = k;
          j = i;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("CardHandler", 2, "set detail card, field count = " + m);
      }
      if (m == 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppCardHandler.a(31, true, new Object[] { Integer.valueOf(0), localObject2 });
        return;
      }
      localObject2 = ByteBuffer.allocate(j + 7);
      ((ByteBuffer)localObject2).putInt((int)Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppCardHandler.b.getCurrentAccountUin()));
      ((ByteBuffer)localObject2).put((byte)0);
      ((ByteBuffer)localObject2).putShort((short)m);
      ((ByteBuffer)localObject2).put(((ByteBuffer)localObject1).array(), 0, j);
      localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((ByteBuffer)localObject2).array()));
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppCardHandler.a("OidbSvc.0x4ff_9");
      ((ToServiceMsg)localObject1).extraData.putAll(this.jdField_a_of_type_AndroidOsBundle);
      ((ToServiceMsg)localObject1).putWupBuffer(localOIDBSSOPkg.toByteArray());
      ((ToServiceMsg)localObject1).extraData.putBoolean("isSetLoginDays", false);
      ((ToServiceMsg)localObject1).extraData.putBoolean("reqFromCardHandler", true);
      ((ToServiceMsg)localObject1).setTimeout(20000L);
      this.jdField_a_of_type_ComTencentMobileqqAppCardHandler.b((ToServiceMsg)localObject1);
      return;
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zhz
 * JD-Core Version:    0.7.0.1
 */