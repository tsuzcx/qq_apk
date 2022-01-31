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

public class cqm
  implements Runnable
{
  public cqm(CardHandler paramCardHandler, Bundle paramBundle) {}
  
  public void run()
  {
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
    localOIDBSSOPkg.uint32_command.set(1279);
    localOIDBSSOPkg.uint32_result.set(0);
    localOIDBSSOPkg.uint32_service_type.set(9);
    Object localObject2 = ((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppCardHandler.a.getManager(43)).b(this.jdField_a_of_type_ComTencentMobileqqAppCardHandler.a.a());
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
      if (this.jdField_a_of_type_AndroidOsBundle.containsKey("key_xuan_yan"))
      {
        m += 1;
        n = this.jdField_a_of_type_AndroidOsBundle.getByteArray("key_xuan_yan").length;
        j += n + 4;
        ((ByteBuffer)localObject1).putShort((short)27035);
        ((ByteBuffer)localObject1).putShort((short)n);
        ((ByteBuffer)localObject1).put(this.jdField_a_of_type_AndroidOsBundle.getByteArray("key_xuan_yan"));
        i = j;
        k = m;
        if (QLog.isColorLevel())
        {
          QLog.d("CardHandler", 2, "set xuan_yan | length = " + n + " | xuan_yan = " + this.jdField_a_of_type_AndroidOsBundle.getByteArray("key_xuan_yan"));
          k = m;
          i = j;
        }
      }
      j = i;
      m = k;
      if (this.jdField_a_of_type_AndroidOsBundle.containsKey("key_new_nickname"))
      {
        k += 1;
        n = this.jdField_a_of_type_AndroidOsBundle.getString("key_new_nickname").getBytes().length;
        i += n + 4;
        ((ByteBuffer)localObject1).putShort((short)27034);
        ((ByteBuffer)localObject1).putShort((short)this.jdField_a_of_type_AndroidOsBundle.getString("key_new_nickname").getBytes().length);
        ((ByteBuffer)localObject1).put(this.jdField_a_of_type_AndroidOsBundle.getString("key_new_nickname").getBytes());
        j = i;
        m = k;
        if (QLog.isColorLevel())
        {
          QLog.d("CardHandler", 2, "set new_nickname | length = " + n + " | new_nickname = " + this.jdField_a_of_type_AndroidOsBundle.getString("key_new_nickname"));
          m = k;
          j = i;
        }
      }
      i = j;
      k = m;
      if (this.jdField_a_of_type_AndroidOsBundle.containsKey("key_marital_status"))
      {
        m += 1;
        j += 5;
        ((ByteBuffer)localObject1).putShort((short)27036);
        ((ByteBuffer)localObject1).putShort((short)1);
        ((ByteBuffer)localObject1).put(this.jdField_a_of_type_AndroidOsBundle.getByte("key_marital_status"));
        i = j;
        k = m;
        if (QLog.isColorLevel())
        {
          QLog.d("CardHandler", 2, "set marital_status | length = 1 | marital_status = " + this.jdField_a_of_type_AndroidOsBundle.getByte("key_marital_status"));
          k = m;
          i = j;
        }
      }
      j = i;
      m = k;
      if (this.jdField_a_of_type_AndroidOsBundle.containsKey("key_qzone_switch"))
      {
        k += 1;
        i += 6;
        ((ByteBuffer)localObject1).putShort((short)-25225);
        ((ByteBuffer)localObject1).putShort((short)2);
        ((ByteBuffer)localObject1).putShort(this.jdField_a_of_type_AndroidOsBundle.getShort("key_qzone_switch"));
        j = i;
        m = k;
        if (QLog.isColorLevel())
        {
          QLog.d("CardHandler", 2, "set qzone_switch | length = 2 | qzone_switch = " + this.jdField_a_of_type_AndroidOsBundle.getShort("key_qzone_switch"));
          m = k;
          j = i;
        }
      }
      i = j;
      k = m;
      if (this.jdField_a_of_type_AndroidOsBundle.containsKey("key_hobby_switch"))
      {
        m += 1;
        j += 6;
        ((ByteBuffer)localObject1).putShort((short)-25224);
        ((ByteBuffer)localObject1).putShort((short)2);
        ((ByteBuffer)localObject1).putShort(this.jdField_a_of_type_AndroidOsBundle.getShort("key_hobby_switch"));
        i = j;
        k = m;
        if (QLog.isColorLevel())
        {
          QLog.d("CardHandler", 2, "set hobby_switch | length = 2 | hobby_switch = " + this.jdField_a_of_type_AndroidOsBundle.getShort("key_hobby_switch"));
          k = m;
          i = j;
        }
      }
      j = i;
      m = k;
      if (this.jdField_a_of_type_AndroidOsBundle.containsKey("key_new_profile_modified_flag"))
      {
        k += 1;
        i += 6;
        ((ByteBuffer)localObject1).putShort((short)-25040);
        ((ByteBuffer)localObject1).putShort((short)2);
        ((ByteBuffer)localObject1).putShort(this.jdField_a_of_type_AndroidOsBundle.getShort("key_new_profile_modified_flag"));
        j = i;
        m = k;
        if (QLog.isColorLevel())
        {
          QLog.d("CardHandler", 2, "set new_profile_modified_flag | length = 2 | flag = " + this.jdField_a_of_type_AndroidOsBundle.getShort("key_new_profile_modified_flag"));
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
      ((ByteBuffer)localObject2).putInt((int)Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppCardHandler.a.a()));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cqm
 * JD-Core Version:    0.7.0.1
 */