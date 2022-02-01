import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import tencent.im.s2c.msgtype0x210.submsgtype0xc7.submsgtype0xc7.RelationalChainChange;
import tencent.im.s2c.msgtype0x210.submsgtype0xc7.submsgtype0xc7.RelationalChainInfo;
import tencent.im.s2c.msgtype0x210.submsgtype0xc7.submsgtype0xc7.RelationalChainInfos;
import tencent.intimate_relation.intimate_relation.IntimateBuddy;
import tencent.intimate_relation.intimate_relation.IntimateInfo;
import tencent.intimate_relation.intimate_relation.IntimateLadybro;
import tencent.intimate_relation.intimate_relation.IntimateLover;
import tencent.intimate_relation.intimate_relation.SnsRelationInfo;

public class wkz
{
  public wkz.c a;
  public wkz.c b;
  public boolean bdR = true;
  public int changeType;
  public String friendUin;
  public ArrayList<wkz.a> qc;
  public String selfUin;
  
  public static wkz a(submsgtype0xc7.RelationalChainChange paramRelationalChainChange, boolean paramBoolean)
  {
    wkz localwkz = new wkz();
    localwkz.bdR = paramBoolean;
    localwkz.selfUin = String.valueOf(paramRelationalChainChange.uint64_src_uin.get());
    localwkz.friendUin = String.valueOf(paramRelationalChainChange.uint64_dst_uin.get());
    localwkz.changeType = paramRelationalChainChange.uint32_change_type.get();
    if (paramRelationalChainChange.msg_relational_chain_info_old.has()) {
      localwkz.a = wkz.c.a((submsgtype0xc7.RelationalChainInfo)paramRelationalChainChange.msg_relational_chain_info_old.get());
    }
    if (paramRelationalChainChange.msg_relational_chain_info_new.has()) {
      localwkz.b = wkz.c.a((submsgtype0xc7.RelationalChainInfo)paramRelationalChainChange.msg_relational_chain_info_new.get());
    }
    if ((paramRelationalChainChange.rpt_relational_chain_infos.has()) && (paramRelationalChainChange.rpt_relational_chain_infos.size() > 0))
    {
      localwkz.qc = new ArrayList();
      int i = 0;
      while (i < paramRelationalChainChange.rpt_relational_chain_infos.size())
      {
        wkz.a locala = new wkz.a();
        if ((paramRelationalChainChange.rpt_relational_chain_infos.get(i) != null) && (((submsgtype0xc7.RelationalChainInfos)paramRelationalChainChange.rpt_relational_chain_infos.get(i)).msg_relational_chain_info_old.has())) {
          locala.a = wkz.c.a((submsgtype0xc7.RelationalChainInfo)((submsgtype0xc7.RelationalChainInfos)paramRelationalChainChange.rpt_relational_chain_infos.get(i)).msg_relational_chain_info_old.get());
        }
        if ((paramRelationalChainChange.rpt_relational_chain_infos.get(i) != null) && (((submsgtype0xc7.RelationalChainInfos)paramRelationalChainChange.rpt_relational_chain_infos.get(i)).msg_relational_chain_info_new.has())) {
          locala.b = wkz.c.a((submsgtype0xc7.RelationalChainInfo)((submsgtype0xc7.RelationalChainInfos)paramRelationalChainChange.rpt_relational_chain_infos.get(i)).msg_relational_chain_info_new.get());
        }
        localwkz.qc.add(locala);
        i += 1;
      }
    }
    return localwkz;
  }
  
  public boolean Rt()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.b != null)
    {
      bool1 = bool2;
      if (this.b.a != null)
      {
        bool1 = bool2;
        if (this.b.a.bdT)
        {
          bool1 = bool2;
          if (!TextUtils.isEmpty(this.b.a.aSO))
          {
            bool1 = bool2;
            if (!TextUtils.isEmpty(this.b.a.aSP)) {
              bool1 = true;
            }
          }
        }
      }
    }
    return bool1;
  }
  
  public wkz.b a()
  {
    Object localObject2 = null;
    if (this.changeType == 2)
    {
      localObject1 = localObject2;
      if (this.a != null)
      {
        localObject1 = localObject2;
        if (this.a.a != null)
        {
          localObject1 = new wkz.b();
          ((wkz.b)localObject1).aSJ = this.a.a.aSL;
          ((wkz.b)localObject1).HO = this.a.a.HT;
          ((wkz.b)localObject1).aSK = this.a.a.aSM;
        }
      }
    }
    do
    {
      do
      {
        return localObject1;
        localObject1 = localObject2;
      } while (this.b == null);
      localObject1 = localObject2;
    } while (this.b.a == null);
    Object localObject1 = new wkz.b();
    ((wkz.b)localObject1).aSJ = this.b.a.aSL;
    ((wkz.b)localObject1).HO = this.b.a.HT;
    ((wkz.b)localObject1).aSK = this.b.a.aSM;
    return localObject1;
  }
  
  public int getRelationType()
  {
    if (this.changeType == 2)
    {
      if (this.a != null) {
        return this.a.relation_type;
      }
    }
    else if (this.b != null) {
      return this.b.relation_type;
    }
    return 0;
  }
  
  public String pg()
  {
    if ((this.b != null) && (this.b.a != null)) {
      return this.b.a.icon_static_url;
    }
    return null;
  }
  
  public String ph()
  {
    if ((this.b != null) && (this.b.a != null)) {
      return this.b.a.aSO;
    }
    return null;
  }
  
  public String pi()
  {
    if ((this.b != null) && (this.b.a != null)) {
      return this.b.a.aSP;
    }
    return null;
  }
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ExtSnsRelationChainChangePushInfo{");
    localStringBuilder.append("selfUin:").append(this.selfUin).append(", ");
    localStringBuilder.append("friendUin:").append(this.friendUin).append(", ");
    localStringBuilder.append("changeType:").append(this.changeType).append(", ");
    localStringBuilder.append("old:").append(this.a).append(", ");
    localStringBuilder.append("now:").append(this.b).append(", ");
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  public int vN()
  {
    if (this.changeType == 2)
    {
      if (this.a != null) {
        return this.a.vN();
      }
    }
    else if (this.b != null) {
      return this.b.vN();
    }
    return 0;
  }
  
  public int vO()
  {
    if (this.b != null) {
      return this.b.vN();
    }
    return 0;
  }
  
  public static class a
  {
    public wkz.c a;
    public wkz.c b;
  }
  
  public static class b
  {
    public long HO;
    public String aSJ;
    public String aSK;
    
    public boolean isValid()
    {
      return !TextUtils.isEmpty(this.aSJ);
    }
    
    @NonNull
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("MutualMarkPushGrayTipInfo{");
      localStringBuilder.append("notifyTime:").append(this.HO).append(", ");
      localStringBuilder.append("grayTipTemplate:").append(this.aSJ).append(", ");
      localStringBuilder.append("}");
      return localStringBuilder.toString();
    }
  }
  
  public static class c
  {
    public wkz.c.a a;
    public wkz.c.b a;
    public byte[] co;
    public int relation_type;
    
    public static c a(submsgtype0xc7.RelationalChainInfo paramRelationalChainInfo)
    {
      if (paramRelationalChainInfo != null)
      {
        c localc = new c();
        localc.relation_type = paramRelationalChainInfo.uint64_type.get();
        if (paramRelationalChainInfo.bytes_attr.has()) {
          localc.jdField_a_of_type_Wkz$c$b = wkz.c.b.a(localc.relation_type, paramRelationalChainInfo.bytes_attr.get().toByteArray());
        }
        if (paramRelationalChainInfo.bytes_intimate_info.has()) {
          localc.jdField_a_of_type_Wkz$c$a = wkz.c.a.a(paramRelationalChainInfo.bytes_intimate_info.get().toByteArray());
        }
        if (paramRelationalChainInfo.bytes_mutualmark_alienation.has()) {
          localc.co = paramRelationalChainInfo.bytes_mutualmark_alienation.get().toByteArray();
        }
        return localc;
      }
      return null;
    }
    
    @NonNull
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("ExtSnsRelationalChainPushInfo{");
      localStringBuilder.append("relation_type:").append(this.relation_type).append(", ");
      localStringBuilder.append("mutualMarkInfo:").append(this.jdField_a_of_type_Wkz$c$b).append(", ");
      localStringBuilder.append("intimateInfo:").append(this.jdField_a_of_type_Wkz$c$a).append(", ");
      localStringBuilder.append("relationIconFlag:");
      if ((this.co != null) && (this.co.length > 0))
      {
        int i = 0;
        while ((i < this.co.length) && (i < 10))
        {
          localStringBuilder.append(this.co[0]).append(" ");
          i += 1;
        }
      }
      localStringBuilder.append(", ");
      localStringBuilder.append("}");
      return localStringBuilder.toString();
    }
    
    public int vN()
    {
      if (this.jdField_a_of_type_Wkz$c$b != null) {
        return (int)this.jdField_a_of_type_Wkz$c$b.HQ;
      }
      if ((this.jdField_a_of_type_Wkz$c$a != null) && ((this.relation_type == 1) || (this.relation_type == 2) || (this.relation_type == 3))) {
        return this.jdField_a_of_type_Wkz$c$a.intimate_level;
      }
      return 0;
    }
    
    public static class a
    {
      public int intimate_level;
      
      public static a a(byte[] paramArrayOfByte)
      {
        intimate_relation.IntimateInfo localIntimateInfo = null;
        intimate_relation.SnsRelationInfo localSnsRelationInfo = new intimate_relation.SnsRelationInfo();
        for (;;)
        {
          try
          {
            localSnsRelationInfo.mergeFrom(paramArrayOfByte);
            paramArrayOfByte = localIntimateInfo;
            if (localSnsRelationInfo.intimate_list.has())
            {
              paramArrayOfByte = localIntimateInfo;
              if (localSnsRelationInfo.intimate_list.size() > 0)
              {
                paramArrayOfByte = new a();
                localIntimateInfo = (intimate_relation.IntimateInfo)localSnsRelationInfo.intimate_list.get(0);
                if ((!localIntimateInfo.lover.has()) || (!((intimate_relation.IntimateLover)localIntimateInfo.lover.get()).level.has())) {
                  break label173;
                }
                paramArrayOfByte.intimate_level = ((intimate_relation.IntimateLover)localIntimateInfo.lover.get()).level.get();
              }
            }
            if (QLog.isColorLevel()) {
              QLog.i("ExtSnsIntimateInfo", 1, "parseFrom retInfo:" + paramArrayOfByte);
            }
            return paramArrayOfByte;
          }
          catch (Throwable paramArrayOfByte)
          {
            QLog.i("ExtSnsIntimateInfo", 1, "parseFrom error:" + paramArrayOfByte.getMessage());
            return null;
          }
          label173:
          if ((localIntimateInfo.buddy.has()) && (((intimate_relation.IntimateBuddy)localIntimateInfo.buddy.get()).level.has())) {
            paramArrayOfByte.intimate_level = ((intimate_relation.IntimateBuddy)localIntimateInfo.buddy.get()).level.get();
          } else if ((localIntimateInfo.ladybro.has()) && (((intimate_relation.IntimateLadybro)localIntimateInfo.ladybro.get()).level.has())) {
            paramArrayOfByte.intimate_level = ((intimate_relation.IntimateLadybro)localIntimateInfo.ladybro.get()).level.get();
          }
        }
      }
      
      @NonNull
      public String toString()
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("ExtSnsIntimatePushInfo{");
        localStringBuilder.append("intimate_level:").append(this.intimate_level).append(", ");
        localStringBuilder.append("}");
        return localStringBuilder.toString();
      }
    }
    
    public static class b
    {
      public long HP;
      public long HQ;
      public long HR;
      public long HS;
      public long HT;
      public long HU;
      public long HV;
      public String aSL;
      public String aSM;
      public String aSN = "";
      public String aSO = "";
      public String aSP = "";
      public String aSQ = "";
      public int bOZ;
      public boolean bdS;
      public boolean bdT;
      public String icon_static_url = "";
      
      /* Error */
      public static b a(long paramLong, byte[] paramArrayOfByte)
      {
        // Byte code:
        //   0: aconst_null
        //   1: astore 5
        //   3: iconst_0
        //   4: istore 4
        //   6: new 54	tencent/im/s2c/msgtype0x210/submsgtype0xc7/bussinfo/mutualmark/mutualmark$MutualmarkInfo
        //   9: dup
        //   10: invokespecial 55	tencent/im/s2c/msgtype0x210/submsgtype0xc7/bussinfo/mutualmark/mutualmark$MutualmarkInfo:<init>	()V
        //   13: astore 7
        //   15: aload 7
        //   17: aload_2
        //   18: invokevirtual 59	tencent/im/s2c/msgtype0x210/submsgtype0xc7/bussinfo/mutualmark/mutualmark$MutualmarkInfo:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
        //   21: pop
        //   22: new 2	wkz$c$b
        //   25: dup
        //   26: invokespecial 60	wkz$c$b:<init>	()V
        //   29: astore 6
        //   31: aload 6
        //   33: lload_0
        //   34: putfield 62	wkz$c$b:HP	J
        //   37: aload 7
        //   39: getfield 66	tencent/im/s2c/msgtype0x210/submsgtype0xc7/bussinfo/mutualmark/mutualmark$MutualmarkInfo:uint32_level	Lcom/tencent/mobileqq/pb/PBUInt32Field;
        //   42: invokevirtual 72	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
        //   45: ifeq +17 -> 62
        //   48: aload 6
        //   50: aload 7
        //   52: getfield 66	tencent/im/s2c/msgtype0x210/submsgtype0xc7/bussinfo/mutualmark/mutualmark$MutualmarkInfo:uint32_level	Lcom/tencent/mobileqq/pb/PBUInt32Field;
        //   55: invokevirtual 76	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
        //   58: i2l
        //   59: putfield 78	wkz$c$b:HQ	J
        //   62: aload 7
        //   64: getfield 82	tencent/im/s2c/msgtype0x210/submsgtype0xc7/bussinfo/mutualmark/mutualmark$MutualmarkInfo:uint64_last_action_time	Lcom/tencent/mobileqq/pb/PBUInt64Field;
        //   67: invokevirtual 85	com/tencent/mobileqq/pb/PBUInt64Field:has	()Z
        //   70: ifeq +16 -> 86
        //   73: aload 6
        //   75: aload 7
        //   77: getfield 82	tencent/im/s2c/msgtype0x210/submsgtype0xc7/bussinfo/mutualmark/mutualmark$MutualmarkInfo:uint64_last_action_time	Lcom/tencent/mobileqq/pb/PBUInt64Field;
        //   80: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
        //   83: putfield 90	wkz$c$b:HR	J
        //   86: aload 7
        //   88: getfield 93	tencent/im/s2c/msgtype0x210/submsgtype0xc7/bussinfo/mutualmark/mutualmark$MutualmarkInfo:uint64_last_change_time	Lcom/tencent/mobileqq/pb/PBUInt64Field;
        //   91: invokevirtual 85	com/tencent/mobileqq/pb/PBUInt64Field:has	()Z
        //   94: ifeq +16 -> 110
        //   97: aload 6
        //   99: aload 7
        //   101: getfield 93	tencent/im/s2c/msgtype0x210/submsgtype0xc7/bussinfo/mutualmark/mutualmark$MutualmarkInfo:uint64_last_change_time	Lcom/tencent/mobileqq/pb/PBUInt64Field;
        //   104: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
        //   107: putfield 95	wkz$c$b:HS	J
        //   110: aload 7
        //   112: getfield 98	tencent/im/s2c/msgtype0x210/submsgtype0xc7/bussinfo/mutualmark/mutualmark$MutualmarkInfo:uint32_continue_days	Lcom/tencent/mobileqq/pb/PBUInt32Field;
        //   115: invokevirtual 72	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
        //   118: ifeq +16 -> 134
        //   121: aload 6
        //   123: aload 7
        //   125: getfield 98	tencent/im/s2c/msgtype0x210/submsgtype0xc7/bussinfo/mutualmark/mutualmark$MutualmarkInfo:uint32_continue_days	Lcom/tencent/mobileqq/pb/PBUInt32Field;
        //   128: invokevirtual 76	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
        //   131: putfield 100	wkz$c$b:bOZ	I
        //   134: aload 7
        //   136: getfield 104	tencent/im/s2c/msgtype0x210/submsgtype0xc7/bussinfo/mutualmark/mutualmark$MutualmarkInfo:bytes_wildcard_wording	Lcom/tencent/mobileqq/pb/PBBytesField;
        //   139: invokevirtual 107	com/tencent/mobileqq/pb/PBBytesField:has	()Z
        //   142: ifeq +19 -> 161
        //   145: aload 6
        //   147: aload 7
        //   149: getfield 104	tencent/im/s2c/msgtype0x210/submsgtype0xc7/bussinfo/mutualmark/mutualmark$MutualmarkInfo:bytes_wildcard_wording	Lcom/tencent/mobileqq/pb/PBBytesField;
        //   152: invokevirtual 110	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
        //   155: invokevirtual 116	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
        //   158: putfield 118	wkz$c$b:aSL	Ljava/lang/String;
        //   161: aload 7
        //   163: getfield 121	tencent/im/s2c/msgtype0x210/submsgtype0xc7/bussinfo/mutualmark/mutualmark$MutualmarkInfo:bytes_duplicate_removal_key	Lcom/tencent/mobileqq/pb/PBBytesField;
        //   166: invokevirtual 107	com/tencent/mobileqq/pb/PBBytesField:has	()Z
        //   169: ifeq +19 -> 188
        //   172: aload 6
        //   174: aload 7
        //   176: getfield 121	tencent/im/s2c/msgtype0x210/submsgtype0xc7/bussinfo/mutualmark/mutualmark$MutualmarkInfo:bytes_duplicate_removal_key	Lcom/tencent/mobileqq/pb/PBBytesField;
        //   179: invokevirtual 110	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
        //   182: invokevirtual 116	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
        //   185: putfield 123	wkz$c$b:aSM	Ljava/lang/String;
        //   188: aload 7
        //   190: getfield 126	tencent/im/s2c/msgtype0x210/submsgtype0xc7/bussinfo/mutualmark/mutualmark$MutualmarkInfo:uint64_notify_time	Lcom/tencent/mobileqq/pb/PBUInt64Field;
        //   193: invokevirtual 85	com/tencent/mobileqq/pb/PBUInt64Field:has	()Z
        //   196: ifeq +16 -> 212
        //   199: aload 6
        //   201: aload 7
        //   203: getfield 126	tencent/im/s2c/msgtype0x210/submsgtype0xc7/bussinfo/mutualmark/mutualmark$MutualmarkInfo:uint64_notify_time	Lcom/tencent/mobileqq/pb/PBUInt64Field;
        //   206: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
        //   209: putfield 128	wkz$c$b:HT	J
        //   212: aload 7
        //   214: getfield 131	tencent/im/s2c/msgtype0x210/submsgtype0xc7/bussinfo/mutualmark/mutualmark$MutualmarkInfo:uint64_icon_status	Lcom/tencent/mobileqq/pb/PBUInt64Field;
        //   217: invokevirtual 85	com/tencent/mobileqq/pb/PBUInt64Field:has	()Z
        //   220: ifeq +16 -> 236
        //   223: aload 6
        //   225: aload 7
        //   227: getfield 131	tencent/im/s2c/msgtype0x210/submsgtype0xc7/bussinfo/mutualmark/mutualmark$MutualmarkInfo:uint64_icon_status	Lcom/tencent/mobileqq/pb/PBUInt64Field;
        //   230: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
        //   233: putfield 133	wkz$c$b:HU	J
        //   236: aload 7
        //   238: getfield 136	tencent/im/s2c/msgtype0x210/submsgtype0xc7/bussinfo/mutualmark/mutualmark$MutualmarkInfo:uint64_icon_status_end_time	Lcom/tencent/mobileqq/pb/PBUInt64Field;
        //   241: invokevirtual 85	com/tencent/mobileqq/pb/PBUInt64Field:has	()Z
        //   244: ifeq +16 -> 260
        //   247: aload 6
        //   249: aload 7
        //   251: getfield 136	tencent/im/s2c/msgtype0x210/submsgtype0xc7/bussinfo/mutualmark/mutualmark$MutualmarkInfo:uint64_icon_status_end_time	Lcom/tencent/mobileqq/pb/PBUInt64Field;
        //   254: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
        //   257: putfield 138	wkz$c$b:HV	J
        //   260: aload 7
        //   262: getfield 141	tencent/im/s2c/msgtype0x210/submsgtype0xc7/bussinfo/mutualmark/mutualmark$MutualmarkInfo:uint32_close_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
        //   265: invokevirtual 72	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
        //   268: ifeq +22 -> 290
        //   271: aload 7
        //   273: getfield 141	tencent/im/s2c/msgtype0x210/submsgtype0xc7/bussinfo/mutualmark/mutualmark$MutualmarkInfo:uint32_close_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
        //   276: invokevirtual 76	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
        //   279: ifeq +273 -> 552
        //   282: iconst_1
        //   283: istore_3
        //   284: aload 6
        //   286: iload_3
        //   287: putfield 143	wkz$c$b:bdS	Z
        //   290: aload 7
        //   292: getfield 146	tencent/im/s2c/msgtype0x210/submsgtype0xc7/bussinfo/mutualmark/mutualmark$MutualmarkInfo:bytes_resource_info	Lcom/tencent/mobileqq/pb/PBBytesField;
        //   295: invokevirtual 107	com/tencent/mobileqq/pb/PBBytesField:has	()Z
        //   298: ifeq +188 -> 486
        //   301: new 148	tencent/im/s2c/msgtype0x210/submsgtype0xc7/bussinfo/mutualmark/mutualmark$ResourceInfo_17
        //   304: dup
        //   305: invokespecial 149	tencent/im/s2c/msgtype0x210/submsgtype0xc7/bussinfo/mutualmark/mutualmark$ResourceInfo_17:<init>	()V
        //   308: astore_2
        //   309: aload_2
        //   310: aload 7
        //   312: getfield 146	tencent/im/s2c/msgtype0x210/submsgtype0xc7/bussinfo/mutualmark/mutualmark$MutualmarkInfo:bytes_resource_info	Lcom/tencent/mobileqq/pb/PBBytesField;
        //   315: invokevirtual 110	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
        //   318: invokevirtual 153	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
        //   321: invokevirtual 154	tencent/im/s2c/msgtype0x210/submsgtype0xc7/bussinfo/mutualmark/mutualmark$ResourceInfo_17:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
        //   324: pop
        //   325: aload_2
        //   326: ifnull +160 -> 486
        //   329: aload_2
        //   330: getfield 157	tencent/im/s2c/msgtype0x210/submsgtype0xc7/bussinfo/mutualmark/mutualmark$ResourceInfo_17:bytes_static_url	Lcom/tencent/mobileqq/pb/PBBytesField;
        //   333: invokevirtual 107	com/tencent/mobileqq/pb/PBBytesField:has	()Z
        //   336: ifeq +18 -> 354
        //   339: aload 6
        //   341: aload_2
        //   342: getfield 157	tencent/im/s2c/msgtype0x210/submsgtype0xc7/bussinfo/mutualmark/mutualmark$ResourceInfo_17:bytes_static_url	Lcom/tencent/mobileqq/pb/PBBytesField;
        //   345: invokevirtual 110	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
        //   348: invokevirtual 116	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
        //   351: putfield 39	wkz$c$b:icon_static_url	Ljava/lang/String;
        //   354: aload_2
        //   355: getfield 160	tencent/im/s2c/msgtype0x210/submsgtype0xc7/bussinfo/mutualmark/mutualmark$ResourceInfo_17:bytes_dynamic_url	Lcom/tencent/mobileqq/pb/PBBytesField;
        //   358: invokevirtual 107	com/tencent/mobileqq/pb/PBBytesField:has	()Z
        //   361: ifeq +18 -> 379
        //   364: aload 6
        //   366: aload_2
        //   367: getfield 160	tencent/im/s2c/msgtype0x210/submsgtype0xc7/bussinfo/mutualmark/mutualmark$ResourceInfo_17:bytes_dynamic_url	Lcom/tencent/mobileqq/pb/PBBytesField;
        //   370: invokevirtual 110	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
        //   373: invokevirtual 116	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
        //   376: putfield 41	wkz$c$b:aSN	Ljava/lang/String;
        //   379: aload_2
        //   380: getfield 163	tencent/im/s2c/msgtype0x210/submsgtype0xc7/bussinfo/mutualmark/mutualmark$ResourceInfo_17:bytes_cartoon_url	Lcom/tencent/mobileqq/pb/PBBytesField;
        //   383: invokevirtual 107	com/tencent/mobileqq/pb/PBBytesField:has	()Z
        //   386: ifeq +18 -> 404
        //   389: aload 6
        //   391: aload_2
        //   392: getfield 163	tencent/im/s2c/msgtype0x210/submsgtype0xc7/bussinfo/mutualmark/mutualmark$ResourceInfo_17:bytes_cartoon_url	Lcom/tencent/mobileqq/pb/PBBytesField;
        //   395: invokevirtual 110	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
        //   398: invokevirtual 116	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
        //   401: putfield 43	wkz$c$b:aSO	Ljava/lang/String;
        //   404: aload_2
        //   405: getfield 166	tencent/im/s2c/msgtype0x210/submsgtype0xc7/bussinfo/mutualmark/mutualmark$ResourceInfo_17:bytes_cartoon_md5	Lcom/tencent/mobileqq/pb/PBBytesField;
        //   408: invokevirtual 107	com/tencent/mobileqq/pb/PBBytesField:has	()Z
        //   411: ifeq +18 -> 429
        //   414: aload 6
        //   416: aload_2
        //   417: getfield 166	tencent/im/s2c/msgtype0x210/submsgtype0xc7/bussinfo/mutualmark/mutualmark$ResourceInfo_17:bytes_cartoon_md5	Lcom/tencent/mobileqq/pb/PBBytesField;
        //   420: invokevirtual 110	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
        //   423: invokevirtual 116	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
        //   426: putfield 45	wkz$c$b:aSP	Ljava/lang/String;
        //   429: aload_2
        //   430: getfield 169	tencent/im/s2c/msgtype0x210/submsgtype0xc7/bussinfo/mutualmark/mutualmark$ResourceInfo_17:bytes_word	Lcom/tencent/mobileqq/pb/PBBytesField;
        //   433: invokevirtual 107	com/tencent/mobileqq/pb/PBBytesField:has	()Z
        //   436: ifeq +18 -> 454
        //   439: aload 6
        //   441: aload_2
        //   442: getfield 169	tencent/im/s2c/msgtype0x210/submsgtype0xc7/bussinfo/mutualmark/mutualmark$ResourceInfo_17:bytes_word	Lcom/tencent/mobileqq/pb/PBBytesField;
        //   445: invokevirtual 110	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
        //   448: invokevirtual 116	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
        //   451: putfield 47	wkz$c$b:aSQ	Ljava/lang/String;
        //   454: aload_2
        //   455: getfield 172	tencent/im/s2c/msgtype0x210/submsgtype0xc7/bussinfo/mutualmark/mutualmark$ResourceInfo_17:uint32_play_cartoon	Lcom/tencent/mobileqq/pb/PBUInt32Field;
        //   458: invokevirtual 72	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
        //   461: ifeq +25 -> 486
        //   464: iload 4
        //   466: istore_3
        //   467: aload_2
        //   468: getfield 172	tencent/im/s2c/msgtype0x210/submsgtype0xc7/bussinfo/mutualmark/mutualmark$ResourceInfo_17:uint32_play_cartoon	Lcom/tencent/mobileqq/pb/PBUInt32Field;
        //   471: invokevirtual 76	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
        //   474: iconst_1
        //   475: if_icmpne +5 -> 480
        //   478: iconst_1
        //   479: istore_3
        //   480: aload 6
        //   482: iload_3
        //   483: putfield 174	wkz$c$b:bdT	Z
        //   486: invokestatic 179	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
        //   489: ifeq +29 -> 518
        //   492: ldc 181
        //   494: iconst_1
        //   495: new 183	java/lang/StringBuilder
        //   498: dup
        //   499: invokespecial 184	java/lang/StringBuilder:<init>	()V
        //   502: ldc 186
        //   504: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   507: aload 6
        //   509: invokevirtual 193	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //   512: invokevirtual 196	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   515: invokestatic 200	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
        //   518: aload 6
        //   520: areturn
        //   521: astore_2
        //   522: ldc 181
        //   524: iconst_1
        //   525: new 183	java/lang/StringBuilder
        //   528: dup
        //   529: invokespecial 184	java/lang/StringBuilder:<init>	()V
        //   532: ldc 202
        //   534: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   537: aload_2
        //   538: invokevirtual 205	java/lang/Throwable:getMessage	()Ljava/lang/String;
        //   541: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   544: invokevirtual 196	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   547: invokestatic 200	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
        //   550: aconst_null
        //   551: areturn
        //   552: iconst_0
        //   553: istore_3
        //   554: goto -270 -> 284
        //   557: astore_2
        //   558: ldc 181
        //   560: iconst_1
        //   561: new 183	java/lang/StringBuilder
        //   564: dup
        //   565: invokespecial 184	java/lang/StringBuilder:<init>	()V
        //   568: ldc 207
        //   570: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   573: aload_2
        //   574: invokevirtual 205	java/lang/Throwable:getMessage	()Ljava/lang/String;
        //   577: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   580: invokevirtual 196	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   583: invokestatic 200	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
        //   586: aload 5
        //   588: astore_2
        //   589: goto -264 -> 325
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	592	0	paramLong	long
        //   0	592	2	paramArrayOfByte	byte[]
        //   283	271	3	bool1	boolean
        //   4	461	4	bool2	boolean
        //   1	586	5	localObject	Object
        //   29	490	6	localb	b
        //   13	298	7	localMutualmarkInfo	tencent.im.s2c.msgtype0x210.submsgtype0xc7.bussinfo.mutualmark.mutualmark.MutualmarkInfo
        // Exception table:
        //   from	to	target	type
        //   15	22	521	java/lang/Throwable
        //   309	325	557	java/lang/Throwable
      }
      
      @NonNull
      public String toString()
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("ExtSnsMutualMarkPushInfo{");
        localStringBuilder.append("relation_type:").append(this.HP).append(", ");
        localStringBuilder.append("relation_level:").append(this.HQ).append(", ");
        localStringBuilder.append("last_action_time:").append(this.HR).append(", ");
        localStringBuilder.append("last_change_time:").append(this.HS).append(", ");
        localStringBuilder.append("continue_days:").append(this.bOZ).append(", ");
        localStringBuilder.append("notify_time:").append(this.HT).append(", ");
        localStringBuilder.append("icon_status:").append(this.HU).append(", ");
        localStringBuilder.append("icon_status_end_time:").append(this.HV).append(", ");
        localStringBuilder.append("wildcard_wording:").append(this.aSL).append(", ");
        localStringBuilder.append("gray_tip_duplicate_key:").append(this.aSM).append(", ");
        localStringBuilder.append("icon_static_url:").append(this.icon_static_url).append(", ");
        localStringBuilder.append("icon_dynamic_url:").append(this.aSN).append(", ");
        localStringBuilder.append("icon_cartoon_url:").append(this.aSO).append(", ");
        localStringBuilder.append("icon_cartoon_md5:").append(this.aSP).append(", ");
        localStringBuilder.append("icon_name:").append(this.aSQ).append(", ");
        localStringBuilder.append("user_close_flag:").append(this.bdS).append(", ");
        localStringBuilder.append("play_cartoon:").append(this.bdT).append(", ");
        localStringBuilder.append("}");
        return localStringBuilder.toString();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wkz
 * JD-Core Version:    0.7.0.1
 */