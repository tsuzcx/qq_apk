import android.arch.lifecycle.MutableLiveData;
import android.text.TextUtils;
import com.tencent.biz.qqcircle.requests.QCircleGetTabListRequest;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudCommon.BytesEntry;
import feedcloud.FeedCloudCommon.StCommonExt;
import feedcloud.FeedCloudMeta.StGPSV2;
import feedcloud.FeedCloudRead.StGetBusiInfoReq;
import java.util.ArrayList;
import java.util.List;
import qqcircle.QQCircleBase.UserCircleInfo;
import qqcircle.QQCircleFeedBase.StPolyLike;
import qqcircle.QQCircleFeedBase.StTabInfo;

public class vul
  extends zxg
{
  private MutableLiveData<vup<List<QQCircleFeedBase.StTabInfo>>> jdField_a_of_type_AndroidArchLifecycleMutableLiveData = new MutableLiveData();
  private ArrayList<QQCircleFeedBase.StTabInfo> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private ArrayList<QQCircleFeedBase.StPolyLike> b = new ArrayList();
  private ArrayList<QQCircleBase.UserCircleInfo> c = new ArrayList();
  private ArrayList<QQCircleBase.UserCircleInfo> d = new ArrayList();
  
  public MutableLiveData<vup<List<QQCircleFeedBase.StTabInfo>>> a()
  {
    return this.jdField_a_of_type_AndroidArchLifecycleMutableLiveData;
  }
  
  public String a()
  {
    return "QCircleTabViewModel";
  }
  
  public ArrayList<QQCircleFeedBase.StTabInfo> a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public void a(int paramInt)
  {
    uxc.a(paramInt);
    if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0) {
      this.jdField_a_of_type_AndroidArchLifecycleMutableLiveData.setValue(vup.a(false).a(false, this.jdField_a_of_type_JavaUtilArrayList));
    }
    for (;;)
    {
      uxc.a(this.c, this.d);
      return;
      this.jdField_a_of_type_AndroidArchLifecycleMutableLiveData.setValue(vup.a());
    }
  }
  
  public void a(FeedCloudMeta.StGPSV2 paramStGPSV2)
  {
    paramStGPSV2 = new QCircleGetTabListRequest(paramStGPSV2);
    paramStGPSV2.setRetryCount(2);
    paramStGPSV2.setEnableCache(true);
    Object localObject = vri.a().a();
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = ((String)localObject).getBytes();
      FeedCloudCommon.StCommonExt localStCommonExt = new FeedCloudCommon.StCommonExt();
      ArrayList localArrayList = new ArrayList();
      if (localObject != null)
      {
        FeedCloudCommon.BytesEntry localBytesEntry = new FeedCloudCommon.BytesEntry();
        localBytesEntry.key.set("circle_invite");
        localBytesEntry.value.set(ByteStringMicro.copyFrom((byte[])localObject));
        localArrayList.add(localBytesEntry);
        localStCommonExt.mapBytesInfo.set(localArrayList);
        if (paramStGPSV2.mReq != null) {
          paramStGPSV2.mReq.extInfo.set(localStCommonExt);
        }
      }
    }
    this.jdField_a_of_type_AndroidArchLifecycleMutableLiveData.setValue(vup.b());
    a(paramStGPSV2, new vum(this, paramStGPSV2));
  }
  
  public void a(List<QQCircleFeedBase.StTabInfo> paramList, List<QQCircleFeedBase.StPolyLike> paramList1, List<QQCircleBase.UserCircleInfo> paramList2, List<QQCircleBase.UserCircleInfo> paramList3)
  {
    b();
    this.jdField_a_of_type_JavaUtilArrayList.addAll(paramList);
    this.b.addAll(paramList1);
    this.c.addAll(paramList2);
    this.d.addAll(paramList3);
  }
  
  /* Error */
  public void a(boolean paramBoolean, long paramLong, String paramString, feedcloud.FeedCloudRead.StGetBusiInfoRsp paramStGetBusiInfoRsp)
  {
    // Byte code:
    //   0: aload 4
    //   2: invokestatic 188	com/tencent/biz/richframework/network/VSNetworkHelper:a	(Ljava/lang/String;)Z
    //   5: istore 7
    //   7: iload_1
    //   8: ifeq +14 -> 22
    //   11: lload_2
    //   12: lconst_0
    //   13: lcmp
    //   14: ifne +8 -> 22
    //   17: aload 5
    //   19: ifnonnull +20 -> 39
    //   22: aload_0
    //   23: getfield 23	vul:jdField_a_of_type_AndroidArchLifecycleMutableLiveData	Landroid/arch/lifecycle/MutableLiveData;
    //   26: aload 4
    //   28: invokestatic 191	vup:a	(Ljava/lang/String;)Lvup;
    //   31: lload_2
    //   32: invokevirtual 194	vup:a	(J)Lvup;
    //   35: invokevirtual 64	android/arch/lifecycle/MutableLiveData:setValue	(Ljava/lang/Object;)V
    //   38: return
    //   39: ldc 41
    //   41: iconst_1
    //   42: new 196	java/lang/StringBuilder
    //   45: dup
    //   46: invokespecial 197	java/lang/StringBuilder:<init>	()V
    //   49: ldc 199
    //   51: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: iload 7
    //   56: invokevirtual 206	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   59: invokevirtual 209	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   62: invokestatic 214	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   65: new 216	qqcircle/QQCircleFeedBase$StBusiInfoData
    //   68: dup
    //   69: invokespecial 217	qqcircle/QQCircleFeedBase$StBusiInfoData:<init>	()V
    //   72: astore 4
    //   74: aload 5
    //   76: getfield 222	feedcloud/FeedCloudRead$StGetBusiInfoRsp:busiRspData	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   79: invokevirtual 226	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   82: invokevirtual 229	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   85: astore 5
    //   87: aload 4
    //   89: aload 5
    //   91: invokevirtual 233	qqcircle/QQCircleFeedBase$StBusiInfoData:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   94: pop
    //   95: invokestatic 238	uwz:a	()Luwz;
    //   98: aload 5
    //   100: invokevirtual 241	uwz:a	([B)V
    //   103: aload 4
    //   105: getfield 244	qqcircle/QQCircleFeedBase$StBusiInfoData:tabInfos	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   108: invokevirtual 247	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   111: astore 5
    //   113: aload 4
    //   115: getfield 251	qqcircle/QQCircleFeedBase$StBusiInfoData:defaultTabIndex	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   118: invokevirtual 257	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   121: ifeq +34 -> 155
    //   124: aload 5
    //   126: aload 4
    //   128: getfield 251	qqcircle/QQCircleFeedBase$StBusiInfoData:defaultTabIndex	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   131: invokevirtual 259	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   134: invokeinterface 264 2 0
    //   139: checkcast 266	qqcircle/QQCircleFeedBase$StTabInfo
    //   142: getfield 269	qqcircle/QQCircleFeedBase$StTabInfo:tabType	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   145: invokevirtual 259	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   148: istore 6
    //   150: iload 6
    //   152: invokestatic 48	uxc:a	(I)V
    //   155: iload 7
    //   157: ifne +20 -> 177
    //   160: aload_0
    //   161: getfield 28	vul:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   164: invokevirtual 272	java/util/ArrayList:clear	()V
    //   167: aload_0
    //   168: getfield 28	vul:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   171: aload 5
    //   173: invokevirtual 177	java/util/ArrayList:addAll	(Ljava/util/Collection;)Z
    //   176: pop
    //   177: aload 5
    //   179: invokeinterface 273 1 0
    //   184: ifle +179 -> 363
    //   187: aload_0
    //   188: getfield 23	vul:jdField_a_of_type_AndroidArchLifecycleMutableLiveData	Landroid/arch/lifecycle/MutableLiveData;
    //   191: iload 7
    //   193: invokestatic 57	vup:a	(Z)Lvup;
    //   196: iconst_0
    //   197: aload 5
    //   199: invokevirtual 60	vup:a	(ZLjava/lang/Object;)Lvup;
    //   202: invokevirtual 64	android/arch/lifecycle/MutableLiveData:setValue	(Ljava/lang/Object;)V
    //   205: aload 4
    //   207: getfield 276	qqcircle/QQCircleFeedBase$StBusiInfoData:allPolyInfo	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   210: invokevirtual 247	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   213: astore 5
    //   215: aload 5
    //   217: ifnull +51 -> 268
    //   220: iload 7
    //   222: ifne +46 -> 268
    //   225: invokestatic 281	vpp:a	()Lvpp;
    //   228: aload 5
    //   230: invokevirtual 283	vpp:a	(Ljava/util/List;)V
    //   233: invokestatic 281	vpp:a	()Lvpp;
    //   236: aload 4
    //   238: getfield 287	qqcircle/QQCircleFeedBase$StBusiInfoData:rewardData	Lqqcircle/QQCircleFeedBase$StRewardData;
    //   241: getfield 293	qqcircle/QQCircleFeedBase$StRewardData:myMoney	Lcom/tencent/mobileqq/pb/PBInt64Field;
    //   244: invokevirtual 298	com/tencent/mobileqq/pb/PBInt64Field:get	()J
    //   247: l2f
    //   248: invokevirtual 301	vpp:a	(F)V
    //   251: aload_0
    //   252: getfield 30	vul:b	Ljava/util/ArrayList;
    //   255: invokevirtual 272	java/util/ArrayList:clear	()V
    //   258: aload_0
    //   259: getfield 30	vul:b	Ljava/util/ArrayList;
    //   262: aload 5
    //   264: invokevirtual 177	java/util/ArrayList:addAll	(Ljava/util/Collection;)Z
    //   267: pop
    //   268: aload_0
    //   269: getfield 32	vul:c	Ljava/util/ArrayList;
    //   272: invokevirtual 272	java/util/ArrayList:clear	()V
    //   275: aload_0
    //   276: getfield 32	vul:c	Ljava/util/ArrayList;
    //   279: aload 4
    //   281: getfield 304	qqcircle/QQCircleFeedBase$StBusiInfoData:schoolInfos	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   284: invokevirtual 247	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   287: invokevirtual 177	java/util/ArrayList:addAll	(Ljava/util/Collection;)Z
    //   290: pop
    //   291: aload_0
    //   292: getfield 34	vul:d	Ljava/util/ArrayList;
    //   295: invokevirtual 272	java/util/ArrayList:clear	()V
    //   298: aload_0
    //   299: getfield 34	vul:d	Ljava/util/ArrayList;
    //   302: aload 4
    //   304: getfield 307	qqcircle/QQCircleFeedBase$StBusiInfoData:companyInfos	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   307: invokevirtual 247	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   310: invokevirtual 177	java/util/ArrayList:addAll	(Ljava/util/Collection;)Z
    //   313: pop
    //   314: aload 4
    //   316: getfield 304	qqcircle/QQCircleFeedBase$StBusiInfoData:schoolInfos	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   319: invokevirtual 247	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   322: aload 4
    //   324: getfield 307	qqcircle/QQCircleFeedBase$StBusiInfoData:companyInfos	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   327: invokevirtual 247	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   330: invokestatic 67	uxc:a	(Ljava/util/List;Ljava/util/List;)V
    //   333: return
    //   334: astore 4
    //   336: aload 4
    //   338: invokevirtual 310	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:printStackTrace	()V
    //   341: aload_0
    //   342: getfield 23	vul:jdField_a_of_type_AndroidArchLifecycleMutableLiveData	Landroid/arch/lifecycle/MutableLiveData;
    //   345: ldc_w 312
    //   348: invokestatic 191	vup:a	(Ljava/lang/String;)Lvup;
    //   351: invokevirtual 64	android/arch/lifecycle/MutableLiveData:setValue	(Ljava/lang/Object;)V
    //   354: return
    //   355: astore 8
    //   357: iconst_1
    //   358: istore 6
    //   360: goto -210 -> 150
    //   363: aload_0
    //   364: getfield 23	vul:jdField_a_of_type_AndroidArchLifecycleMutableLiveData	Landroid/arch/lifecycle/MutableLiveData;
    //   367: invokestatic 70	vup:a	()Lvup;
    //   370: invokevirtual 64	android/arch/lifecycle/MutableLiveData:setValue	(Ljava/lang/Object;)V
    //   373: goto -168 -> 205
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	376	0	this	vul
    //   0	376	1	paramBoolean	boolean
    //   0	376	2	paramLong	long
    //   0	376	4	paramString	String
    //   0	376	5	paramStGetBusiInfoRsp	feedcloud.FeedCloudRead.StGetBusiInfoRsp
    //   148	211	6	i	int
    //   5	216	7	bool	boolean
    //   355	1	8	localException	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   87	103	334	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   124	150	355	java/lang/Exception
  }
  
  public boolean a()
  {
    return vja.a().a(this);
  }
  
  public ArrayList<QQCircleFeedBase.StPolyLike> b()
  {
    return this.b;
  }
  
  public void b()
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.b.clear();
    this.c.clear();
    this.d.clear();
  }
  
  public ArrayList<QQCircleBase.UserCircleInfo> c()
  {
    return this.c;
  }
  
  public ArrayList<QQCircleBase.UserCircleInfo> d()
  {
    return this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vul
 * JD-Core Version:    0.7.0.1
 */