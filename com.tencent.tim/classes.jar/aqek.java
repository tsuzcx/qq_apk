import android.os.Bundle;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.util.NearbyProfileUtil.2;
import tencent.sso.accretion.flower_info.SFlowerInfoRsp;

public class aqek
{
  public static final String[] cp = { "不限", "计算机/互联网/通信", "生产/工艺/制造", "医疗/护理/制药", "金融/银行/投资/保险", "商业/服务业/个体经营", "文化/广告/传媒", "娱乐/艺术/表演", "律师/法务", "教育/培训", "公务员/行政/事业单位", "模特", "空姐", "学生", "其他职业" };
  public static final String[] cq = { "", "IT", "制造", "医疗", "金融", "商业", "文化", "艺术", "法律", "教育", "行政", "模特", "空姐", "学生", "" };
  public static final String[] hI = { "男", "女" };
  public static final String[] hJ;
  public static final String[] hK;
  public static final int[] oS = { 2130846440, 2130846448 };
  public static final int[] oT = { 2130846799, 2130845823, 2130845823, 2130845823, 2130846556, 2130846556, 2130846817, 2130846817, 2130846338, 2130846338, 2130846338, 2130846799, 2130846799, 2130846617, 2130846799 };
  
  static
  {
    hJ = new String[] { "保密", "单身", "恋爱中", "已婚" };
    hK = new String[] { "", "水瓶座", "双鱼座", "白羊座", "金牛座", "双子座", "巨蟹座", "狮子座", "处女座", "天秤座", "天蝎座", "射手座", "摩羯座" };
  }
  
  public static final void a(ajrs paramajrs, QQAppInterface paramQQAppInterface, long paramLong1, String paramString, int paramInt1, byte[] paramArrayOfByte, long paramLong2, boolean paramBoolean1, long paramLong3, boolean paramBoolean2, long paramLong4, int paramInt2)
  {
    if (paramLong1 > 0L)
    {
      if (ProfileActivity.gh(paramInt1))
      {
        paramajrs.a(paramQQAppInterface.getCurrentAccountUin(), "0", 45, paramLong2, (byte)0, 0L, 0L, paramArrayOfByte, "", hB(), 10004, null, paramLong1, true, paramBoolean1, paramLong3, paramBoolean2, paramLong4, paramInt2);
        return;
      }
      if (ProfileActivity.gf(paramInt1))
      {
        paramajrs.a(paramQQAppInterface.getCurrentAccountUin(), "0", 39, paramLong2, (byte)0, 0L, 0L, paramArrayOfByte, "", hB(), 10004, null, paramLong1, true, paramBoolean1, paramLong3, paramBoolean2, paramLong4, paramInt2);
        return;
      }
      if (paramInt1 == 16)
      {
        paramajrs.a(paramQQAppInterface.getCurrentAccountUin(), "0", 46, paramLong2, (byte)0, 0L, 0L, paramArrayOfByte, "", hB(), 10004, null, paramLong1, true, paramBoolean1, paramLong3, paramBoolean2, paramLong4, paramInt2);
        return;
      }
      if (paramInt1 == 38)
      {
        paramajrs.a(paramQQAppInterface.getCurrentAccountUin(), "0", 47, paramLong2, (byte)0, 0L, 0L, paramArrayOfByte, "", hB(), 10004, null, paramLong1, true, paramBoolean1, paramLong3, paramBoolean2, paramLong4, paramInt2);
        return;
      }
      if (paramInt1 == 100)
      {
        paramajrs.a(paramQQAppInterface.getCurrentAccountUin(), "0", 49, paramLong2, (byte)0, 0L, 0L, paramArrayOfByte, "", hB(), 10004, null, paramLong1, true, paramBoolean1, paramLong3, paramBoolean2, paramLong4, paramInt2);
        return;
      }
      if (paramInt1 == 51)
      {
        paramajrs.a(paramQQAppInterface.getCurrentAccountUin(), "0", 51, paramLong2, (byte)0, 0L, 0L, paramArrayOfByte, "", hB(), 10004, null, paramLong1, true, paramBoolean1, paramLong3, paramBoolean2, paramLong4, paramInt2);
        return;
      }
      paramajrs.a(paramQQAppInterface.getCurrentAccountUin(), "0", 41, paramLong2, (byte)0, 0L, 0L, paramArrayOfByte, "", hB(), 10004, null, paramLong1, true, paramBoolean1, paramLong3, paramBoolean2, paramLong4, paramInt2);
      return;
    }
    if (paramString.equals(paramQQAppInterface.getCurrentAccountUin()))
    {
      paramajrs.a(paramQQAppInterface.getCurrentAccountUin(), paramQQAppInterface.getCurrentAccountUin(), 0, 0L, (byte)0, 0L, 0L, null, "", hB(), 10004, null, 0L, true, paramBoolean1, paramLong3, paramBoolean2, paramLong4, paramInt2);
      return;
    }
    int i = 6;
    if (ProfileActivity.gg(paramInt1)) {
      i = 42;
    }
    for (;;)
    {
      paramajrs.a(paramQQAppInterface.getCurrentAccountUin(), paramString, i, paramLong2, (byte)0, 0L, 0L, paramArrayOfByte, "", hB(), 10004, null, 0L, true, paramBoolean1, paramLong3, paramBoolean2, paramLong4, paramInt2);
      return;
      if (ProfileActivity.gh(paramInt1)) {
        i = 45;
      } else if (ProfileActivity.gf(paramInt1)) {
        i = 39;
      } else if (paramInt1 == 16) {
        i = 46;
      } else if (paramInt1 == 38) {
        i = 47;
      } else if (paramInt1 == 51) {
        i = 51;
      }
    }
  }
  
  public static void ad(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("key_is_nearby_people_card", true);
    localBundle.putShort("key_new_profile_modified_flag", (short)1);
    if (paramBoolean) {}
    for (int i = 0;; i = 1)
    {
      localBundle.putShort("key_flower_visible_switch", (short)i);
      localBundle.putBoolean("key_nearby_people_card_force_update", true);
      ajrs localajrs = (ajrs)paramQQAppInterface.getBusinessHandler(60);
      if (localajrs == null) {
        break;
      }
      paramQQAppInterface.execute(new NearbyProfileUtil.2(localajrs, localBundle));
      return;
    }
  }
  
  public static boolean ay(int paramInt)
  {
    return (paramInt == -1) || ((paramInt >= 0) && (paramInt < cp.length));
  }
  
  public static boolean bX(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return true;
    }
    String str = paramQQAppInterface.getCurrentAccountUin();
    EntityManager localEntityManager = paramQQAppInterface.a().createEntityManager();
    paramQQAppInterface = null;
    Object localObject = null;
    if (localEntityManager != null)
    {
      paramQQAppInterface = localObject;
      if (!aqmr.isEmpty(str)) {
        paramQQAppInterface = (NearbyPeopleCard)localEntityManager.find(NearbyPeopleCard.class, "uin=?", new String[] { str });
      }
      localEntityManager.close();
    }
    boolean bool;
    if (paramQQAppInterface != null) {
      if (paramQQAppInterface.switchGiftVisible == 0L) {
        bool = true;
      }
    }
    for (;;)
    {
      return bool;
      bool = false;
      continue;
      bool = true;
    }
  }
  
  public static final String fW(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < hJ.length)) {
      return hJ[paramInt];
    }
    return "";
  }
  
  public static final String fX(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt <= 1)) {
      return hI[paramInt];
    }
    return "";
  }
  
  public static final String fY(int paramInt)
  {
    if ((paramInt >= 1) && (paramInt <= 12)) {
      return hK[paramInt];
    }
    return "";
  }
  
  public static final String fZ(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt <= 14)) {
      return cq[paramInt];
    }
    return "";
  }
  
  public static final String ga(int paramInt)
  {
    if ((paramInt >= 1) && (paramInt <= 14)) {
      return cp[paramInt];
    }
    return "";
  }
  
  private static final long hB()
  {
    return 0L | 0x4 | 0x800 | 0x1000 | 0x8000;
  }
  
  public static final int jU(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt <= 1)) {
      return oS[paramInt];
    }
    return 0;
  }
  
  public static final int jV(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt <= 14)) {
      return oT[paramInt];
    }
    return 0;
  }
  
  public static int jW(int paramInt)
  {
    if (paramInt == 1) {
      return 1;
    }
    if (paramInt == 5) {
      return 2;
    }
    if (ProfileActivity.gg(paramInt)) {
      return 3;
    }
    if (paramInt == 21) {
      return 4;
    }
    if (ProfileActivity.gh(paramInt)) {
      return 5;
    }
    return 99;
  }
  
  public static final int y(byte[] paramArrayOfByte)
  {
    int j = 0;
    int i = j;
    flower_info.SFlowerInfoRsp localSFlowerInfoRsp;
    if (paramArrayOfByte != null) {
      localSFlowerInfoRsp = new flower_info.SFlowerInfoRsp();
    }
    try
    {
      localSFlowerInfoRsp.mergeFrom(paramArrayOfByte);
      i = j;
      if (localSFlowerInfoRsp.num.has()) {
        i = localSFlowerInfoRsp.num.get();
      }
      return i;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      for (;;)
      {
        paramArrayOfByte.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqek
 * JD-Core Version:    0.7.0.1
 */