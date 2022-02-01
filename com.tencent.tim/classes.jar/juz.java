import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import tencent.im.oidb.cmd0x487.oidb_0x487.GroupList;
import tencent.im.oidb.cmd0x487.oidb_0x487.RspBody;

class juz
  extends jnm.d
{
  juz(juk paramjuk) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PubAccountMoreInfoActivity.bindTroop", 2, "onResult, errorCode=" + paramInt);
    }
    int i;
    if ((paramInt != -1) && (paramArrayOfByte != null))
    {
      try
      {
        paramBundle = new oidb_0x487.RspBody();
        paramBundle.mergeFrom(paramArrayOfByte);
        k = paramBundle.uint32_result.get();
        if (k != 0) {
          break label463;
        }
        paramArrayOfByte = new ArrayList();
        if (!paramBundle.msg_groups.has()) {
          break label458;
        }
        localObject1 = paramBundle.msg_groups.get();
        if (localObject1 == null) {
          break label458;
        }
        int j = ((List)localObject1).size();
        i = 0;
        paramInt = j;
        if (i < j)
        {
          localObject2 = ((oidb_0x487.GroupList)((List)localObject1).get(i)).uint64_groupcode.get() + "";
          ((oidb_0x487.GroupList)((List)localObject1).get(i)).bytes_group_name.get().toStringUtf8();
          paramArrayOfByte.add(localObject2);
          if (paramArrayOfByte.size() < 3) {
            break label469;
          }
          paramInt = j;
        }
      }
      catch (Exception paramArrayOfByte)
      {
        int k;
        Object localObject1;
        Object localObject2;
        while (QLog.isColorLevel())
        {
          QLog.e("PubAccountMoreInfoActivity.bindTroop", 2, "getBindedTroops, exception=" + paramArrayOfByte.toString());
          return;
          paramInt = 0;
          continue;
          paramInt = 0;
        }
      }
      this.b.ju.clear();
      this.b.ju.addAll(paramArrayOfByte);
      if (paramBundle.uint32_privilege_flag.has())
      {
        localObject1 = this.b;
        if (paramBundle.uint32_privilege_flag.get() != 1) {
          break label478;
        }
      }
    }
    label458:
    label463:
    label469:
    label478:
    for (boolean bool = true;; bool = false)
    {
      ((juk)localObject1).abR = bool;
      localObject1 = (apsa)this.b.app.getManager(132);
      localObject2 = new Bundle();
      ((Bundle)localObject2).putBoolean("mIsAbleBindTroop", this.b.abR);
      ((Bundle)localObject2).putStringArrayList("mBindedTroopUins", paramArrayOfByte);
      ((apsa)localObject1).H(this.b.mUin, (Bundle)localObject2);
      this.b.azU();
      if (QLog.isColorLevel())
      {
        if (paramBundle.bytes_errmsg.has()) {}
        for (paramArrayOfByte = paramBundle.bytes_errmsg.get().toStringUtf8();; paramArrayOfByte = "")
        {
          QLog.d("PubAccountMoreInfoActivity.bindTroop", 2, "onResult, ret=" + k + "," + paramInt + "," + paramArrayOfByte + "," + this.b.abR);
          return;
        }
      }
      return;
      i += 1;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     juz
 * JD-Core Version:    0.7.0.1
 */