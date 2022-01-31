package com.tencent.mobileqq.data;

import QQService.EVIPSPEC;
import android.database.Cursor;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.contact.OnlineStatusIconHelper;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.PrimaryKeyJoinColumn;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.qphone.base.util.QLog;

@PrimaryKeyJoinColumn(a="uin")
public class Friends
  extends Entity
  implements Cloneable
{
  public static final int CLIENT_DEFAULT = 0;
  public static final int CLIENT_IPHONE = 3;
  public static final int CLIENT_MOBILE = 2;
  public static final int CLIENT_PC = 1;
  public static final int GATHER_TYPE_GATHERED = 1;
  public static final int GATHER_TYPE_NORMAL = 0;
  public static final int GATHER_TYPE_RECOMMENDED = 2;
  private static final int LOGIN_TYPE_OFFLINE = 10;
  public static int MULTI_FLAGS_MASK_SHIELD = 1;
  public static final int NET_2G = 2;
  public static final int NET_3G = 3;
  public static final int NET_4G = 4;
  public static final int NET_UNKNOW = 0;
  public static final int NET_WIFI = 1;
  private static final String TAG = "Friends";
  public static final int TERM_TYPE_ANDROID_PAD = 68104;
  public static final int TERM_TYPE_AOL_CHAOJIHUIYUAN = 73730;
  public static final int TERM_TYPE_AOL_HUIYUAN = 73474;
  public static final int TERM_TYPE_AOL_SQQ = 69378;
  public static final int TERM_TYPE_HRTX_IPHONE = 66566;
  public static final int TERM_TYPE_HRTX_PC = 66561;
  public static final int TERM_TYPE_MC_3G = 65795;
  public static final int TERM_TYPE_MISRO_MSG = 69634;
  public static final int TERM_TYPE_MOBILE_ANDROID = 65799;
  public static final int TERM_TYPE_MOBILE_ANDROID_NEW = 72450;
  public static final int TERM_TYPE_MOBILE_HD = 65805;
  public static final int TERM_TYPE_MOBILE_HD_NEW = 71426;
  public static final int TERM_TYPE_MOBILE_IPAD = 68361;
  public static final int TERM_TYPE_MOBILE_IPAD_NEW = 72194;
  public static final int TERM_TYPE_MOBILE_IPHONE = 67586;
  public static final int TERM_TYPE_MOBILE_OTHER = 65794;
  public static final int TERM_TYPE_MOBILE_PC = 65793;
  public static final int TERM_TYPE_MOBILE_WINPHONE_NEW = 72706;
  public static final int TERM_TYPE_QQ_FORELDER = 70922;
  public static final int TERM_TYPE_QQ_SERVICE = 71170;
  public static final int TERM_TYPE_TV_QQ = 69130;
  public static final int TERM_TYPE_WIN8 = 69899;
  public static final int TERM_TYPE_WINPHONE = 65804;
  public long abilityBits = 0L;
  public int age;
  public String alias;
  @Deprecated
  public byte cNetwork = 0;
  public byte cSpecialFlag;
  public long datetime;
  public byte detalStatusFlag;
  public int eNetwork = 0;
  public short faceid;
  public byte gathtertype = 0;
  public byte gender;
  public int groupid = -1;
  public int iTermType;
  public byte isIphoneOnline;
  public boolean isMqqOnLine;
  @Deprecated
  public byte isRemark = 1;
  public long lastLoginType;
  public int mComparePartInt;
  public String mCompareSpell;
  public byte memberLevel;
  public int multiFlags = 0;
  public String name;
  @notColumn
  public int netTypeIconId;
  @notColumn
  public int netTypeIconIdIphoneOrWphoneNoWifi = 0;
  public int qqVipInfo = 0;
  public String recommReason;
  public String remark;
  public byte[] richBuffer;
  @notColumn
  public RichStatus richStatus;
  public long richTime;
  public long showLoginClient;
  @Deprecated
  public String signature;
  public String smartRemark;
  public byte sqqOnLineState;
  public byte sqqtype;
  public byte status = 10;
  @notColumn
  public String strTermDesc;
  public int superQqInfo = 0;
  public int superVipInfo = 0;
  @unique
  public String uin;
  
  public static boolean isValidUin(long paramLong)
  {
    return paramLong > 10000L;
  }
  
  public static boolean isValidUin(String paramString)
  {
    boolean bool = false;
    try
    {
      long l = Long.valueOf(Long.parseLong(paramString)).longValue();
      if (l > 10000L) {
        bool = true;
      }
      return bool;
    }
    catch (Exception paramString) {}
    return false;
  }
  
  public Object clone()
  {
    try
    {
      localObject = super.clone();
      return localObject;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      do
      {
        Object localObject = this;
      } while (!QLog.isColorLevel());
      QLog.d("Q.contacttab.", 2, "Friends clone failed." + localCloneNotSupportedException.toString());
    }
    return this;
  }
  
  protected boolean entityByCursor(Cursor paramCursor)
  {
    this.uin = paramCursor.getString(paramCursor.getColumnIndex("uin"));
    this.remark = paramCursor.getString(paramCursor.getColumnIndex("remark"));
    this.name = paramCursor.getString(paramCursor.getColumnIndex("name"));
    this.faceid = paramCursor.getShort(paramCursor.getColumnIndex("faceid"));
    this.status = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("status")));
    this.sqqtype = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("sqqtype")));
    this.cSpecialFlag = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("cSpecialFlag")));
    this.groupid = paramCursor.getInt(paramCursor.getColumnIndex("groupid"));
    this.memberLevel = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("memberLevel")));
    if (paramCursor.getInt(paramCursor.getColumnIndex("isMqqOnLine")) != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.isMqqOnLine = bool;
      this.sqqOnLineState = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("sqqOnLineState")));
      this.detalStatusFlag = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("detalStatusFlag")));
      this.datetime = paramCursor.getLong(paramCursor.getColumnIndex("datetime"));
      this.alias = paramCursor.getString(paramCursor.getColumnIndex("alias"));
      this.signature = paramCursor.getString(paramCursor.getColumnIndex("signature"));
      this.isIphoneOnline = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("isIphoneOnline")));
      this.isRemark = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("isRemark")));
      this.iTermType = paramCursor.getInt(paramCursor.getColumnIndex("iTermType"));
      this.qqVipInfo = paramCursor.getInt(paramCursor.getColumnIndex("qqVipInfo"));
      this.superQqInfo = paramCursor.getInt(paramCursor.getColumnIndex("superQqInfo"));
      this.superVipInfo = paramCursor.getInt(paramCursor.getColumnIndex("superVipInfo"));
      this.lastLoginType = paramCursor.getLong(paramCursor.getColumnIndex("lastLoginType"));
      this.showLoginClient = paramCursor.getLong(paramCursor.getColumnIndex("showLoginClient"));
      this.richTime = paramCursor.getLong(paramCursor.getColumnIndex("richTime"));
      this.richBuffer = paramCursor.getBlob(paramCursor.getColumnIndex("richBuffer"));
      this.mComparePartInt = paramCursor.getInt(paramCursor.getColumnIndex("mComparePartInt"));
      this.mCompareSpell = paramCursor.getString(paramCursor.getColumnIndex("mCompareSpell"));
      this.cNetwork = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("cNetwork")));
      this.eNetwork = paramCursor.getInt(paramCursor.getColumnIndex("eNetwork"));
      this.multiFlags = paramCursor.getInt(paramCursor.getColumnIndex("multiFlags"));
      this.abilityBits = paramCursor.getLong(paramCursor.getColumnIndex("abilityBits"));
      this.gathtertype = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("gathtertype")));
      this.smartRemark = paramCursor.getString(paramCursor.getColumnIndex("smartRemark"));
      this.age = paramCursor.getInt(paramCursor.getColumnIndex("age"));
      this.gender = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("gender")));
      this.recommReason = paramCursor.getString(paramCursor.getColumnIndex("recommReason"));
      return true;
    }
  }
  
  public String getFriendNick()
  {
    if (!TextUtils.isEmpty(this.remark)) {
      return this.remark;
    }
    if (!TextUtils.isEmpty(this.name)) {
      return this.name;
    }
    return this.uin;
  }
  
  public String getFriendNickWithAlias()
  {
    if (!TextUtils.isEmpty(this.remark)) {
      return this.remark;
    }
    if (!TextUtils.isEmpty(this.name)) {
      return this.name;
    }
    if (!TextUtils.isEmpty(this.alias)) {
      return this.alias;
    }
    return this.uin;
  }
  
  public long getLastLoginType()
  {
    if (this.lastLoginType == 0L) {
      return 10L;
    }
    return this.lastLoginType;
  }
  
  public int getNetWorkType()
  {
    int j = 2;
    int i;
    if ((this.detalStatusFlag == -55) && ((this.iTermType == 67586) || (this.iTermType == 66566) || (this.iTermType == 72194) || (this.iTermType == 65804) || (this.iTermType == 72706)) && ((this.abilityBits & 1L) == 0L))
    {
      i = j;
      switch (this.netTypeIconIdIphoneOrWphoneNoWifi)
      {
      default: 
        i = this.netTypeIconId;
      }
    }
    OnlineStatusIconHelper localOnlineStatusIconHelper;
    do
    {
      return i;
      return 3;
      return 4;
      if (((this.detalStatusFlag == -55) && (this.iTermType == 68361) && ((this.abilityBits & 1L) == 0L)) || (this.iTermType == 68104) || (this.iTermType == 65805)) {
        return 0;
      }
      localOnlineStatusIconHelper = OnlineStatusIconHelper.a();
      if (this.eNetwork != 0) {
        break;
      }
      if ((this.iTermType == 69378) || (this.iTermType == 73474) || (this.iTermType == 73730)) {
        return 0;
      }
      i = j;
    } while (1 != localOnlineStatusIconHelper.a(this.iTermType, 1));
    if (1 != localOnlineStatusIconHelper.a(this.iTermType, 1)) {
      i = j;
    }
    switch (this.netTypeIconId)
    {
    case 2: 
    default: 
      return this.eNetwork;
    case 1: 
      return 1;
    case 3: 
      return 3;
    }
    return 4;
  }
  
  public RichStatus getRichStatus()
  {
    return getRichStatus(false);
  }
  
  public RichStatus getRichStatus(boolean paramBoolean)
  {
    if (this.richStatus == null)
    {
      if ((this.richTime > 0L) && (paramBoolean)) {
        return RichStatus.a();
      }
      if (this.richTime <= 0L) {
        break label60;
      }
      this.richStatus = RichStatus.a(this.richBuffer);
      this.richStatus.a = this.richTime;
    }
    for (;;)
    {
      return this.richStatus;
      label60:
      this.richStatus = new RichStatus(this.signature);
    }
  }
  
  public int getServiceLevel(EVIPSPEC paramEVIPSPEC)
  {
    switch (paramEVIPSPEC.value())
    {
    default: 
      return 0;
    case 1: 
      return this.qqVipInfo & 0xFFFF;
    case 2: 
      return this.superQqInfo & 0xFFFF;
    }
    return this.superVipInfo & 0xFFFF;
  }
  
  public int getServiceType(EVIPSPEC paramEVIPSPEC)
  {
    switch (paramEVIPSPEC.value())
    {
    default: 
      return 0;
    case 1: 
      return (this.qqVipInfo & 0xFF0000) >>> 16;
    case 2: 
      return (this.superQqInfo & 0xFF0000) >>> 16;
    }
    return (this.superVipInfo & 0xFF0000) >>> 16;
  }
  
  public int getVipIdentifyResId()
  {
    if (isServiceEnabled(EVIPSPEC.E_SP_SUPERVIP)) {
      return 2130839371;
    }
    if (isServiceEnabled(EVIPSPEC.E_SP_QQVIP)) {
      return 2130839448;
    }
    return 0;
  }
  
  public boolean isAndroidIphoneOnline()
  {
    return (!isOffline()) && ((this.iTermType == 67586) || (this.iTermType == 65799) || (this.iTermType == 72450));
  }
  
  public boolean isFriend()
  {
    return this.groupid >= 0;
  }
  
  public boolean isOffline()
  {
    if (this.status == 10) {
      if (this.isMqqOnLine) {
        if (this.detalStatusFlag != 31) {}
      }
    }
    while ((this.status == 11) || ((this.status == 20) && (this.sqqOnLineState == 1)))
    {
      do
      {
        do
        {
          return false;
        } while (this.detalStatusFlag != 51);
        return false;
      } while ((this.detalStatusFlag == 30) || (this.detalStatusFlag == 50) || (this.detalStatusFlag == 60) || (this.detalStatusFlag != 70));
      return false;
    }
    return true;
  }
  
  public boolean isServiceEnabled(EVIPSPEC paramEVIPSPEC)
  {
    boolean bool = true;
    switch (paramEVIPSPEC.value())
    {
    default: 
      bool = false;
    }
    do
    {
      do
      {
        do
        {
          return bool;
        } while ((this.qqVipInfo & 0xFF000000) != 0);
        return false;
      } while ((this.superQqInfo & 0xFF000000) != 0);
      return false;
    } while ((this.superVipInfo & 0xFF000000) != 0);
    return false;
  }
  
  public boolean isShield()
  {
    return (this.multiFlags & MULTI_FLAGS_MASK_SHIELD) > 0;
  }
  
  public void setRichBuffer(byte[] paramArrayOfByte, long paramLong)
  {
    this.richBuffer = paramArrayOfByte;
    this.richTime = paramLong;
    this.richStatus = null;
  }
  
  public void setShieldFlag(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.multiFlags |= MULTI_FLAGS_MASK_SHIELD;
      return;
    }
    this.multiFlags &= (MULTI_FLAGS_MASK_SHIELD ^ 0xFFFFFFFF);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.data.Friends
 * JD-Core Version:    0.7.0.1
 */