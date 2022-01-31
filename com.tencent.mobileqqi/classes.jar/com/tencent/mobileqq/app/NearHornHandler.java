package com.tencent.mobileqq.app;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoCell;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoWifi;
import com.tencent.mobileqq.data.HornDetail;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.utils.SecurityUtile;
import com.tencent.pb.near_horn.NearHornPb.DelMyHornReq;
import com.tencent.pb.near_horn.NearHornPb.DelMyHornRsp;
import com.tencent.pb.near_horn.NearHornPb.GPSInfo;
import com.tencent.pb.near_horn.NearHornPb.HornInfo;
import com.tencent.pb.near_horn.NearHornPb.HornReqHead;
import com.tencent.pb.near_horn.NearHornPb.HornRspHead;
import com.tencent.pb.near_horn.NearHornPb.MyHornInfo;
import com.tencent.pb.near_horn.NearHornPb.MyHornListReq;
import com.tencent.pb.near_horn.NearHornPb.MyHornListRsp;
import com.tencent.pb.near_horn.NearHornPb.NearHornListReq;
import com.tencent.pb.near_horn.NearHornPb.NearHornListRsp;
import com.tencent.pb.near_horn.NearHornPb.PublishHornReq;
import com.tencent.pb.near_horn.NearHornPb.PublishHornRsp;
import com.tencent.pb.near_horn.NearHornPb.SosoCell;
import com.tencent.pb.near_horn.NearHornPb.SosoWifi;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import fef;
import feg;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class NearHornHandler
  extends BusinessHandler
{
  public static final int a = 1;
  public static final String a = "NearHornRelated";
  public static final int b = 20;
  public static final int c = 2047;
  public static final int j = 1;
  public static final int k = 2;
  public static final int l = 3;
  public static final int m = 4;
  public static final int n = 5;
  public long a;
  protected Context a;
  public HornDetail a;
  public Boolean a;
  public List a;
  public Boolean b;
  public String b;
  protected List b;
  public Boolean c;
  public String c;
  public List c;
  public int d;
  public Boolean d;
  public String d;
  public int e;
  public String e;
  public int f;
  public String f;
  public int g;
  public String g;
  public int h;
  protected String h;
  public int i = 0;
  
  NearHornHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(false);
    this.jdField_b_of_type_JavaLangBoolean = Boolean.valueOf(false);
    this.jdField_a_of_type_JavaUtilList = null;
    this.jdField_c_of_type_JavaLangBoolean = Boolean.valueOf(false);
    this.jdField_d_of_type_JavaLangBoolean = Boolean.valueOf(false);
    this.jdField_d_of_type_Int = 0;
    this.jdField_e_of_type_Int = 0;
    this.jdField_f_of_type_Int = 0;
    this.jdField_g_of_type_Int = 5;
    this.jdField_h_of_type_Int = 24;
    this.jdField_d_of_type_JavaLangString = "附近暂无新喇叭，超级会员每周可以发布一条喇叭";
    this.jdField_a_of_type_Long = 0L;
    this.jdField_e_of_type_JavaLangString = "";
    this.jdField_f_of_type_JavaLangString = "你的喇叭数量为0，升级为超级会员，每周均可免费发布喇叭";
    this.jdField_g_of_type_JavaLangString = "申请喇叭";
    this.jdField_b_of_type_JavaUtilList = null;
    this.jdField_c_of_type_JavaUtilList = null;
    this.jdField_a_of_type_AndroidContentContext = BaseApplicationImpl.getContext();
    this.jdField_h_of_type_JavaLangString = paramQQAppInterface.a();
    this.jdField_b_of_type_JavaLangString = (this.jdField_h_of_type_JavaLangString + ".npcs");
    this.jdField_c_of_type_JavaLangString = (this.jdField_h_of_type_JavaLangString + "_back_kill.npcs");
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
    this.jdField_c_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  private NearHornPb.HornReqHead a(Boolean paramBoolean, String paramString1, String paramString2)
  {
    NearHornPb.HornReqHead localHornReqHead = new NearHornPb.HornReqHead();
    localHornReqHead.protocol_ver.set(1);
    localHornReqHead.client_plat_id.set(109);
    localHornReqHead.client_ver.set("6.0.2.6602");
    localHornReqHead.os_ver.set(Build.VERSION.SDK);
    localHornReqHead.uin.set(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()));
    if (paramBoolean.booleanValue() == true)
    {
      paramBoolean = new NearHornPb.GPSInfo();
      if ((!paramString1.equals("")) && (!paramString2.equals("1")))
      {
        paramString1 = paramString1.split("&");
        if (paramString1.length > 1)
        {
          int i3 = 0;
          int i4 = 0;
          int i2 = 0;
          int i1 = 0;
          if (i3 < paramString1.length)
          {
            paramString2 = paramString1[i3].split("=");
            int i6;
            int i5;
            if (paramString2[0].equals("lat"))
            {
              i6 = Integer.parseInt(paramString2[1]);
              i5 = i2;
            }
            for (;;)
            {
              i3 += 1;
              i2 = i5;
              i1 = i6;
              break;
              if (paramString2[0].equals("lon"))
              {
                i5 = Integer.parseInt(paramString2[1]);
                i6 = i1;
              }
              else
              {
                i5 = i2;
                i6 = i1;
                if (paramString2[0].equals("alt"))
                {
                  i4 = Integer.parseInt(paramString2[1]);
                  i5 = i2;
                  i6 = i1;
                }
              }
            }
          }
          paramBoolean.lat.set(i1);
          paramBoolean.lon.set(i2);
          paramBoolean.alt.set(i4);
          paramBoolean.eType.set(0);
          localHornReqHead.gps.set(paramBoolean);
          return localHornReqHead;
        }
      }
      long l1 = System.currentTimeMillis();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      paramString1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      if (QLog.isColorLevel()) {
        QLog.i("NearHornRelated", 2, "get soso lbs data time:" + (System.currentTimeMillis() - l1));
      }
      if (paramString1 != null)
      {
        paramBoolean.lat.set(paramString1.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.jdField_a_of_type_Int);
        paramBoolean.lon.set(paramString1.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.b);
        paramBoolean.alt.set(-1);
        paramBoolean.eType.set(0);
        localHornReqHead.gps.set(paramBoolean);
        if (paramString1.jdField_a_of_type_JavaUtilArrayList != null)
        {
          paramBoolean = paramString1.jdField_a_of_type_JavaUtilArrayList.iterator();
          while (paramBoolean.hasNext())
          {
            paramString2 = (SosoInterface.SosoCell)paramBoolean.next();
            NearHornPb.SosoCell localSosoCell = new NearHornPb.SosoCell();
            localSosoCell.mcc.set(paramString2.jdField_a_of_type_Int);
            localSosoCell.mnc.set(paramString2.b);
            localSosoCell.lac.set(paramString2.c);
            localSosoCell.cellid.set(paramString2.jdField_d_of_type_Int);
            localSosoCell.rssi.set(paramString2.jdField_e_of_type_Int);
            localHornReqHead.cells.add(localSosoCell);
          }
        }
        if (paramString1.b != null)
        {
          paramBoolean = paramString1.b.iterator();
          while (paramBoolean.hasNext())
          {
            paramString1 = (SosoInterface.SosoWifi)paramBoolean.next();
            paramString2 = new NearHornPb.SosoWifi();
            paramString2.mac.set(paramString1.jdField_a_of_type_Long);
            paramString2.rssi.set(paramString1.jdField_a_of_type_Int);
            localHornReqHead.wifis.add(paramString2);
          }
        }
      }
    }
    return localHornReqHead;
  }
  
  private String a(String paramString)
  {
    paramString = new StringBuilder(paramString);
    int i2;
    for (int i1 = 0; i1 < paramString.length(); i1 = i2 + 1)
    {
      i2 = i1;
      if (paramString.charAt(i1) == '\024')
      {
        i2 = paramString.charAt(i1 + 1);
        paramString.setCharAt(i1 + 1, (char)(2047 - com.tencent.mobileqq.service.message.MessageUtils.a[i2]));
        i2 = i1 + 1;
      }
    }
    return paramString.toString();
  }
  
  private String b(String paramString)
  {
    paramString = new StringBuilder(paramString);
    int i2;
    for (int i1 = 0; i1 < paramString.length(); i1 = i2 + 1)
    {
      i2 = i1;
      if (paramString.charAt(i1) == '\024')
      {
        i2 = paramString.charAt(i1 + 1);
        paramString.setCharAt(i1 + 1, (char)com.tencent.mobileqq.service.message.MessageUtils.b[(2047 - i2)]);
        i2 = i1 + 1;
      }
    }
    return paramString.toString();
  }
  
  private void b(Object paramObject, String paramString)
  {
    if (paramString == this.jdField_b_of_type_JavaLangString)
    {
      paramString = (List)paramObject;
      paramObject = new ArrayList();
      paramString = paramString.iterator();
      while (paramString.hasNext())
      {
        HornDetail localHornDetail = (HornDetail)((HornDetail)paramString.next()).clone();
        localHornDetail.content = SecurityUtile.b(localHornDetail.content.toString());
        paramObject.add(localHornDetail);
      }
      a(paramObject, this.jdField_b_of_type_JavaLangString);
    }
  }
  
  protected Class a()
  {
    return NearHornObserver.class;
  }
  
  /* Error */
  public Object a(String paramString)
  {
    // Byte code:
    //   0: new 402	java/io/ObjectInputStream
    //   3: dup
    //   4: aload_0
    //   5: getfield 96	com/tencent/mobileqq/app/NearHornHandler:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   8: aload_1
    //   9: invokevirtual 408	android/content/Context:openFileInput	(Ljava/lang/String;)Ljava/io/FileInputStream;
    //   12: invokespecial 411	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   15: astore_3
    //   16: aload_3
    //   17: astore_2
    //   18: aload_3
    //   19: invokevirtual 414	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   22: astore 4
    //   24: aload_3
    //   25: astore_2
    //   26: invokestatic 253	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   29: ifeq +37 -> 66
    //   32: aload_3
    //   33: astore_2
    //   34: ldc 10
    //   36: iconst_2
    //   37: new 105	java/lang/StringBuilder
    //   40: dup
    //   41: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   44: ldc_w 416
    //   47: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: aload_1
    //   51: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: ldc_w 418
    //   57: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   63: invokestatic 261	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   66: aload_3
    //   67: ifnull +7 -> 74
    //   70: aload_3
    //   71: invokevirtual 421	java/io/ObjectInputStream:close	()V
    //   74: aload 4
    //   76: areturn
    //   77: astore_1
    //   78: aload_1
    //   79: invokevirtual 424	java/io/IOException:printStackTrace	()V
    //   82: aload 4
    //   84: areturn
    //   85: astore_1
    //   86: aconst_null
    //   87: astore_3
    //   88: aload_3
    //   89: astore_2
    //   90: aload_1
    //   91: invokevirtual 424	java/io/IOException:printStackTrace	()V
    //   94: aload_3
    //   95: ifnull +7 -> 102
    //   98: aload_3
    //   99: invokevirtual 421	java/io/ObjectInputStream:close	()V
    //   102: aconst_null
    //   103: areturn
    //   104: astore_1
    //   105: aload_1
    //   106: invokevirtual 424	java/io/IOException:printStackTrace	()V
    //   109: goto -7 -> 102
    //   112: astore_1
    //   113: aconst_null
    //   114: astore_3
    //   115: aload_3
    //   116: astore_2
    //   117: aload_1
    //   118: invokevirtual 425	java/lang/ClassNotFoundException:printStackTrace	()V
    //   121: aload_3
    //   122: ifnull -20 -> 102
    //   125: aload_3
    //   126: invokevirtual 421	java/io/ObjectInputStream:close	()V
    //   129: goto -27 -> 102
    //   132: astore_1
    //   133: aload_1
    //   134: invokevirtual 424	java/io/IOException:printStackTrace	()V
    //   137: goto -35 -> 102
    //   140: astore_1
    //   141: aconst_null
    //   142: astore_2
    //   143: aload_2
    //   144: ifnull +7 -> 151
    //   147: aload_2
    //   148: invokevirtual 421	java/io/ObjectInputStream:close	()V
    //   151: aload_1
    //   152: athrow
    //   153: astore_2
    //   154: aload_2
    //   155: invokevirtual 424	java/io/IOException:printStackTrace	()V
    //   158: goto -7 -> 151
    //   161: astore_1
    //   162: goto -19 -> 143
    //   165: astore_1
    //   166: goto -51 -> 115
    //   169: astore_1
    //   170: goto -82 -> 88
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	173	0	this	NearHornHandler
    //   0	173	1	paramString	String
    //   17	131	2	localObjectInputStream1	java.io.ObjectInputStream
    //   153	2	2	localIOException	java.io.IOException
    //   15	111	3	localObjectInputStream2	java.io.ObjectInputStream
    //   22	61	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   70	74	77	java/io/IOException
    //   0	16	85	java/io/IOException
    //   98	102	104	java/io/IOException
    //   0	16	112	java/lang/ClassNotFoundException
    //   125	129	132	java/io/IOException
    //   0	16	140	finally
    //   147	151	153	java/io/IOException
    //   18	24	161	finally
    //   26	32	161	finally
    //   34	66	161	finally
    //   90	94	161	finally
    //   117	121	161	finally
    //   18	24	165	java/lang/ClassNotFoundException
    //   26	32	165	java/lang/ClassNotFoundException
    //   34	66	165	java/lang/ClassNotFoundException
    //   18	24	169	java/io/IOException
    //   26	32	169	java/io/IOException
    //   34	66	169	java/io/IOException
  }
  
  public List a(int paramInt)
  {
    Iterator localIterator2 = null;
    Object localObject = "";
    switch (paramInt)
    {
    }
    try
    {
      for (;;)
      {
        localObject = (List)a((String)localObject);
        if ((localObject == null) || (paramInt != 4)) {
          break;
        }
        localIterator2 = ((List)localObject).iterator();
        while (localIterator2.hasNext())
        {
          HornDetail localHornDetail = (HornDetail)localIterator2.next();
          localHornDetail.content = new QQText(SecurityUtile.a(localHornDetail.content.toString()), 3, 20);
        }
        localObject = this.jdField_b_of_type_JavaLangString;
      }
    }
    catch (Exception localException)
    {
      Iterator localIterator1;
      for (;;)
      {
        localException.printStackTrace();
        localIterator1 = localIterator2;
      }
      if (localIterator1 == null) {
        return new ArrayList();
      }
      return localIterator1;
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    if ("HornSvc1.GetNearHorn".equals(paramFromServiceMsg.getServiceCmd())) {
      if ((paramFromServiceMsg != null) && (!paramFromServiceMsg.isSuccess())) {
        super.a(1, false, null);
      }
    }
    for (;;)
    {
      return;
      paramFromServiceMsg = new NearHornPb.NearHornListRsp();
      try
      {
        paramFromServiceMsg.mergeFrom((byte[])paramObject);
        if (paramFromServiceMsg == null) {
          continue;
        }
        a(paramFromServiceMsg, 1, Boolean.valueOf(paramToServiceMsg.extraData.getBoolean("onlyReadConf", false)));
        return;
        if ("HornSvc2.PublishHorn".equals(paramFromServiceMsg.getServiceCmd()))
        {
          if ((paramFromServiceMsg != null) && (!paramFromServiceMsg.isSuccess()))
          {
            super.a(2, false, null);
            return;
          }
          paramToServiceMsg = new NearHornPb.PublishHornRsp();
        }
        try
        {
          paramToServiceMsg.mergeFrom((byte[])paramObject);
          if (paramToServiceMsg == null) {
            continue;
          }
          paramToServiceMsg = (NearHornPb.NearHornListRsp)paramToServiceMsg.rsp.get();
          if (paramToServiceMsg == null) {
            continue;
          }
          a(paramToServiceMsg, 2, Boolean.valueOf(false));
          return;
          if ("HornSvc2.DelMyHorn".equals(paramFromServiceMsg.getServiceCmd()))
          {
            if ((paramFromServiceMsg != null) && (!paramFromServiceMsg.isSuccess()))
            {
              super.a(3, false, null);
              return;
            }
            paramToServiceMsg = new NearHornPb.DelMyHornRsp();
            try
            {
              paramToServiceMsg.mergeFrom((byte[])paramObject);
              if (paramToServiceMsg == null) {
                continue;
              }
              paramFromServiceMsg = (NearHornPb.HornRspHead)paramToServiceMsg.head.get();
              i1 = paramFromServiceMsg.code.get();
              if (i1 != 0)
              {
                super.a(3, false, new Object[] { Integer.valueOf(i1), Integer.valueOf(paramFromServiceMsg.msg_type.get()), paramFromServiceMsg.msg.get() });
                if (!QLog.isColorLevel()) {
                  continue;
                }
                QLog.i("NearHornRelated", 2, "protocal type 3 return error: retCode:" + i1 + "|msg:" + paramFromServiceMsg.msg.get());
                return;
              }
            }
            catch (Exception paramFromServiceMsg)
            {
              int i1;
              for (;;)
              {
                paramFromServiceMsg.printStackTrace();
              }
              super.a(3, true, new Object[] { Integer.valueOf(i1), paramToServiceMsg.svr_buff.get() });
              return;
            }
          }
          if (!"HornSvc3.GetMyHorn".equals(paramFromServiceMsg.getServiceCmd())) {
            continue;
          }
          if ((paramFromServiceMsg != null) && (!paramFromServiceMsg.isSuccess()))
          {
            super.a(4, false, null);
            return;
          }
          paramToServiceMsg = new NearHornPb.MyHornListRsp();
          try
          {
            paramToServiceMsg.mergeFrom((byte[])paramObject);
            if (paramToServiceMsg == null) {
              continue;
            }
            a(paramToServiceMsg);
            return;
          }
          catch (Exception paramToServiceMsg)
          {
            for (;;)
            {
              paramToServiceMsg = null;
            }
          }
        }
        catch (Exception paramToServiceMsg)
        {
          for (;;)
          {
            paramToServiceMsg = localObject2;
          }
        }
      }
      catch (Exception paramFromServiceMsg)
      {
        for (;;)
        {
          paramFromServiceMsg = localObject1;
        }
      }
    }
  }
  
  public void a(Object paramObject)
  {
    Object localObject2 = (NearHornPb.MyHornListRsp)paramObject;
    Object localObject1 = (NearHornPb.HornRspHead)((NearHornPb.MyHornListRsp)localObject2).head.get();
    int i1 = ((NearHornPb.HornRspHead)localObject1).code.get();
    paramObject = ((NearHornPb.MyHornListRsp)localObject2).svr_buff.get();
    if (i1 != 0)
    {
      super.a(4, false, new Object[] { Integer.valueOf(i1), paramObject, ((NearHornPb.HornRspHead)localObject1).msg.get() });
      if (QLog.isColorLevel()) {
        QLog.i("NearHornRelated", 2, "protocal type 4 return error: retCode:" + i1 + "|msg:" + ((NearHornPb.HornRspHead)localObject1).msg.get());
      }
    }
    do
    {
      return;
      this.jdField_b_of_type_JavaLangBoolean = Boolean.valueOf(((NearHornPb.MyHornListRsp)localObject2).continue_query.get());
      if (((NearHornPb.MyHornListRsp)localObject2).client_buff.get().equals("1")) {}
      for (boolean bool = true;; bool = false)
      {
        localObject1 = Boolean.valueOf(bool);
        this.jdField_c_of_type_JavaUtilList.clear();
        localObject2 = ((NearHornPb.MyHornListRsp)localObject2).my_horns.get().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          NearHornPb.MyHornInfo localMyHornInfo = (NearHornPb.MyHornInfo)((Iterator)localObject2).next();
          HornDetail localHornDetail = new HornDetail();
          localHornDetail.hornKey = localMyHornInfo.horn_key.get();
          localHornDetail.content = new QQText(b(localMyHornInfo.content.get()), 3, 20);
          localHornDetail.distance = localMyHornInfo.distance.get();
          localHornDetail.time = localMyHornInfo.time_interval.get();
          localHornDetail.place = localMyHornInfo.place.get();
          localHornDetail.commentCnt = localMyHornInfo.comment_cnt.get();
          this.jdField_c_of_type_JavaUtilList.add(localHornDetail);
        }
      }
      super.a(4, true, new Object[] { Integer.valueOf(i1), localObject1, this.jdField_c_of_type_JavaUtilList, paramObject });
    } while ((this.jdField_c_of_type_JavaUtilList.isEmpty()) || (!((Boolean)localObject1).booleanValue()));
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(new fef(this));
  }
  
  public void a(Object paramObject, int paramInt, Boolean paramBoolean)
  {
    Object localObject2 = (NearHornPb.NearHornListRsp)paramObject;
    Object localObject1 = (NearHornPb.HornRspHead)((NearHornPb.NearHornListRsp)localObject2).head.get();
    int i2 = ((NearHornPb.HornRspHead)localObject1).code.get();
    paramObject = ((NearHornPb.NearHornListRsp)localObject2).svr_buff.get();
    if (i2 != 0)
    {
      super.a(paramInt, false, new Object[] { Integer.valueOf(i2), paramObject, ((NearHornPb.HornRspHead)localObject1).msg.get() });
      if (QLog.isColorLevel()) {
        QLog.i("NearHornRelated", 2, "protocal type " + paramInt + " return error: retCode:" + i2 + "|msg:" + ((NearHornPb.HornRspHead)localObject1).msg.get());
      }
      return;
    }
    this.jdField_c_of_type_JavaLangBoolean = Boolean.valueOf(true);
    this.jdField_d_of_type_Int = ((NearHornPb.NearHornListRsp)localObject2).free_cnt.get();
    this.jdField_e_of_type_Int = ((NearHornPb.NearHornListRsp)localObject2).pay_cnt.get();
    this.jdField_f_of_type_Int = ((NearHornPb.NearHornListRsp)localObject2).present_cnt.get();
    this.jdField_g_of_type_Int = ((NearHornPb.NearHornListRsp)localObject2).stay_second.get();
    this.jdField_h_of_type_Int = ((NearHornPb.NearHornListRsp)localObject2).horn_word_max.get();
    this.jdField_d_of_type_JavaLangString = ((NearHornPb.NearHornListRsp)localObject2).horn_empty_pmt.get();
    this.jdField_a_of_type_Long = ((NearHornPb.NearHornListRsp)localObject2).now.get();
    this.i = ((NearHornPb.NearHornListRsp)localObject2).horn_valid_time.get();
    this.jdField_f_of_type_JavaLangString = ((NearHornPb.NearHornListRsp)localObject2).no_cnt_hint.get();
    this.jdField_g_of_type_JavaLangString = ((NearHornPb.NearHornListRsp)localObject2).h5_navigation_text.get();
    this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(((NearHornPb.NearHornListRsp)localObject2).continue_query.get());
    this.jdField_b_of_type_JavaUtilList.clear();
    if (((NearHornPb.NearHornListRsp)localObject2).client_buff.get().equals("1")) {}
    Object localObject3;
    for (boolean bool = true;; bool = false)
    {
      localObject1 = Boolean.valueOf(bool);
      localObject2 = ((NearHornPb.NearHornListRsp)localObject2).rpt_horn_info.get().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (NearHornPb.HornInfo)((Iterator)localObject2).next();
        HornDetail localHornDetail = new HornDetail();
        localHornDetail.hornKey = ((NearHornPb.HornInfo)localObject3).horn_key.get();
        localHornDetail.uin = Long.toString(((NearHornPb.HornInfo)localObject3).uin.get());
        localHornDetail.nickName = ((NearHornPb.HornInfo)localObject3).nick.get();
        localHornDetail.distance = ((NearHornPb.HornInfo)localObject3).distance.get();
        localHornDetail.time = ((NearHornPb.HornInfo)localObject3).time_interval.get();
        localHornDetail.place = ((NearHornPb.HornInfo)localObject3).place.get();
        localHornDetail.content = new QQText(b(((NearHornPb.HornInfo)localObject3).horn_content.get()), 3, 20);
        localHornDetail.commentCnt = ((NearHornPb.HornInfo)localObject3).comment_cnt.get();
        localHornDetail.seg = ((NearHornPb.HornInfo)localObject3).seg.get().toByteArray();
        localHornDetail.publishTime = ((NearHornPb.HornInfo)localObject3).publish_time.get();
        localHornDetail.status = ((NearHornPb.HornInfo)localObject3).status.get();
        this.jdField_b_of_type_JavaUtilList.add(localHornDetail);
      }
    }
    localObject2 = paramObject.split("&");
    if ((localObject2.length > 1) && (((Boolean)localObject1).booleanValue()))
    {
      int i1 = 0;
      while (i1 < localObject2.length)
      {
        localObject3 = localObject2[i1].split("=");
        if (localObject3[0].equals("horn_valid_hint")) {
          this.jdField_e_of_type_JavaLangString = localObject3[1];
        }
        i1 += 1;
      }
    }
    super.a(paramInt, true, new Object[] { Integer.valueOf(i2), localObject1, this.jdField_b_of_type_JavaUtilList, paramObject, paramBoolean });
  }
  
  /* Error */
  public void a(Object paramObject, String paramString)
  {
    // Byte code:
    //   0: new 713	java/io/ObjectOutputStream
    //   3: dup
    //   4: aload_0
    //   5: getfield 96	com/tencent/mobileqq/app/NearHornHandler:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   8: aload_2
    //   9: iconst_0
    //   10: invokevirtual 717	android/content/Context:openFileOutput	(Ljava/lang/String;I)Ljava/io/FileOutputStream;
    //   13: invokespecial 720	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   16: astore 4
    //   18: aload 4
    //   20: astore_3
    //   21: aload 4
    //   23: aload_1
    //   24: invokevirtual 723	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   27: aload 4
    //   29: astore_3
    //   30: aload 4
    //   32: invokevirtual 726	java/io/ObjectOutputStream:flush	()V
    //   35: aload 4
    //   37: astore_3
    //   38: invokestatic 253	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   41: ifeq +38 -> 79
    //   44: aload 4
    //   46: astore_3
    //   47: ldc 10
    //   49: iconst_2
    //   50: new 105	java/lang/StringBuilder
    //   53: dup
    //   54: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   57: ldc_w 728
    //   60: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: aload_2
    //   64: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: ldc_w 418
    //   70: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   76: invokestatic 261	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   79: aload 4
    //   81: ifnull +8 -> 89
    //   84: aload 4
    //   86: invokevirtual 729	java/io/ObjectOutputStream:close	()V
    //   89: return
    //   90: astore_1
    //   91: aload_1
    //   92: invokevirtual 424	java/io/IOException:printStackTrace	()V
    //   95: return
    //   96: astore_2
    //   97: aconst_null
    //   98: astore_1
    //   99: aload_1
    //   100: astore_3
    //   101: aload_2
    //   102: invokevirtual 424	java/io/IOException:printStackTrace	()V
    //   105: aload_1
    //   106: ifnull -17 -> 89
    //   109: aload_1
    //   110: invokevirtual 729	java/io/ObjectOutputStream:close	()V
    //   113: return
    //   114: astore_1
    //   115: aload_1
    //   116: invokevirtual 424	java/io/IOException:printStackTrace	()V
    //   119: return
    //   120: astore_1
    //   121: aconst_null
    //   122: astore_3
    //   123: aload_3
    //   124: ifnull +7 -> 131
    //   127: aload_3
    //   128: invokevirtual 729	java/io/ObjectOutputStream:close	()V
    //   131: aload_1
    //   132: athrow
    //   133: astore_2
    //   134: aload_2
    //   135: invokevirtual 424	java/io/IOException:printStackTrace	()V
    //   138: goto -7 -> 131
    //   141: astore_1
    //   142: goto -19 -> 123
    //   145: astore_2
    //   146: aload 4
    //   148: astore_1
    //   149: goto -50 -> 99
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	152	0	this	NearHornHandler
    //   0	152	1	paramObject	Object
    //   0	152	2	paramString	String
    //   20	108	3	localObject	Object
    //   16	131	4	localObjectOutputStream	java.io.ObjectOutputStream
    // Exception table:
    //   from	to	target	type
    //   84	89	90	java/io/IOException
    //   0	18	96	java/io/IOException
    //   109	113	114	java/io/IOException
    //   0	18	120	finally
    //   127	131	133	java/io/IOException
    //   21	27	141	finally
    //   30	35	141	finally
    //   38	44	141	finally
    //   47	79	141	finally
    //   101	105	141	finally
    //   21	27	145	java/io/IOException
    //   30	35	145	java/io/IOException
    //   38	44	145	java/io/IOException
    //   47	79	145	java/io/IOException
  }
  
  public void a(String paramString)
  {
    if (paramString != "")
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        HornDetail localHornDetail = (HornDetail)localIterator.next();
        if (localHornDetail.hornKey.equals(paramString))
        {
          this.jdField_a_of_type_JavaUtilList.remove(localHornDetail);
          this.jdField_d_of_type_JavaLangBoolean = Boolean.valueOf(true);
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(new feg(this, paramString));
    }
  }
  
  public void a(String paramString1, Long paramLong, String paramString2, String paramString3, Boolean paramBoolean)
  {
    NearHornPb.NearHornListReq localNearHornListReq = new NearHornPb.NearHornListReq();
    localNearHornListReq.head.set(a(Boolean.valueOf(true), paramString3, paramString2));
    localNearHornListReq.horn_key.set(paramString1);
    localNearHornListReq.svr_buff.set(paramString3);
    localNearHornListReq.client_buff.set(paramString2);
    localNearHornListReq.publish_time.set(paramLong.longValue());
    localNearHornListReq.conf_only.set(paramBoolean.booleanValue());
    localNearHornListReq.setHasFlag(true);
    paramString1 = a("HornSvc1.GetNearHorn");
    paramString1.extraData.putBoolean("onlyReadConf", paramBoolean.booleanValue());
    paramString1.putWupBuffer(localNearHornListReq.toByteArray());
    b(paramString1);
  }
  
  public void a(String paramString1, String paramString2)
  {
    NearHornPb.PublishHornReq localPublishHornReq = new NearHornPb.PublishHornReq();
    localPublishHornReq.head.set(a(Boolean.valueOf(true), paramString2, "1"));
    localPublishHornReq.content.set(a(paramString1));
    localPublishHornReq.svr_buff.set(paramString2);
    localPublishHornReq.setHasFlag(true);
    paramString1 = a("HornSvc2.PublishHorn");
    paramString1.putWupBuffer(localPublishHornReq.toByteArray());
    b(paramString1);
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    NearHornPb.MyHornListReq localMyHornListReq = new NearHornPb.MyHornListReq();
    localMyHornListReq.head.set(a(Boolean.valueOf(true), paramString3, paramString2));
    localMyHornListReq.horn_key.set(paramString1);
    localMyHornListReq.svr_buff.set(paramString3);
    localMyHornListReq.client_buff.set(paramString2);
    localMyHornListReq.setHasFlag(true);
    paramString1 = a("HornSvc3.GetMyHorn");
    paramString1.putWupBuffer(localMyHornListReq.toByteArray());
    b(paramString1);
  }
  
  public void b(Object paramObject)
  {
    a(5, true, paramObject);
  }
  
  public void b(String paramString1, String paramString2)
  {
    NearHornPb.DelMyHornReq localDelMyHornReq = new NearHornPb.DelMyHornReq();
    localDelMyHornReq.head.set(a(Boolean.valueOf(false), paramString2, "1"));
    localDelMyHornReq.horn_keys.set(paramString1);
    localDelMyHornReq.svr_buff.set(paramString2);
    localDelMyHornReq.setHasFlag(true);
    paramString1 = a("HornSvc2.DelMyHorn");
    paramString1.putWupBuffer(localDelMyHornReq.toByteArray());
    b(paramString1);
  }
  
  public void c(Object paramObject)
  {
    b(paramObject, this.jdField_b_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.NearHornHandler
 * JD-Core Version:    0.7.0.1
 */