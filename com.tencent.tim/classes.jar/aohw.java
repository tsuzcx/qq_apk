import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.tofumsg.TofuItem;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.PhotoWall.oidb_PhotoWall.CommRsp;
import tencent.im.oidb.PhotoWall.oidb_PhotoWall.GetPhotoIndexListRsp;
import tencent.im.oidb.PhotoWall.oidb_PhotoWall.PhotoIndexInfoEx;
import tencent.im.oidb.cmd0xe61.oidb_0xe61.BeancurdCubeInfo;

public class aohw
  extends aohn
{
  public aohw(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private JSONObject a(oidb_PhotoWall.GetPhotoIndexListRsp paramGetPhotoIndexListRsp)
    throws JSONException
  {
    Object localObject = "";
    int i;
    int j;
    label40:
    label58:
    int k;
    if (paramGetPhotoIndexListRsp.next_offset.has())
    {
      i = paramGetPhotoIndexListRsp.next_offset.get();
      if (!paramGetPhotoIndexListRsp.uptime.has()) {
        break label182;
      }
      j = paramGetPhotoIndexListRsp.uptime.get();
      if (!paramGetPhotoIndexListRsp.photo_list.has()) {
        break label187;
      }
      paramGetPhotoIndexListRsp = paramGetPhotoIndexListRsp.photo_list.get();
      if ((paramGetPhotoIndexListRsp == null) || (paramGetPhotoIndexListRsp.size() <= 0)) {
        break label192;
      }
      localObject = (oidb_PhotoWall.PhotoIndexInfoEx)paramGetPhotoIndexListRsp.get(0);
      paramGetPhotoIndexListRsp = ((oidb_PhotoWall.PhotoIndexInfoEx)localObject).filekey.get();
      k = ((oidb_PhotoWall.PhotoIndexInfoEx)localObject).ctime.get();
    }
    for (;;)
    {
      localObject = new JSONObject();
      ((JSONObject)localObject).put("nextOffset", i);
      ((JSONObject)localObject).put("upTime", j);
      ((JSONObject)localObject).put("lastFileKey", paramGetPhotoIndexListRsp);
      ((JSONObject)localObject).put("lastCTime", k);
      if (QLog.isColorLevel()) {
        QLog.i("Tofu_NicePicsDataHandler", 2, String.format("updateItemFromRsp.parseRsp data=%s", new Object[] { localObject }));
      }
      return localObject;
      i = -1;
      break;
      label182:
      j = 0;
      break label40;
      label187:
      paramGetPhotoIndexListRsp = null;
      break label58;
      label192:
      k = 0;
      paramGetPhotoIndexListRsp = (oidb_PhotoWall.GetPhotoIndexListRsp)localObject;
    }
  }
  
  public int KG()
  {
    return 10;
  }
  
  public String a(TofuItem paramTofuItem)
  {
    Object localObject1;
    if ((paramTofuItem.bytesFromServer != null) && (paramTofuItem.bytesFromServer.length > 0)) {
      localObject1 = new oidb_PhotoWall.GetPhotoIndexListRsp();
    }
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        ((oidb_PhotoWall.GetPhotoIndexListRsp)localObject1).mergeFrom(paramTofuItem.bytesFromServer);
        int i = (int)((oidb_PhotoWall.GetPhotoIndexListRsp)localObject1).base_time_photo_count.get();
        long l = ((oidb_PhotoWall.GetPhotoIndexListRsp)localObject1).uptime.get();
        localObject2 = ((oidb_PhotoWall.GetPhotoIndexListRsp)localObject1).photo_list.get();
        if (((List)localObject2).size() <= 0) {
          continue;
        }
        localObject1 = ((oidb_PhotoWall.PhotoIndexInfoEx)((List)localObject2).get(0)).burl.get();
        if (((List)localObject2).size() <= 1) {
          continue;
        }
        localObject2 = ((oidb_PhotoWall.PhotoIndexInfoEx)((List)localObject2).get(1)).burl.get();
        localJSONObject.put("key_nice_pics_count", i);
        localJSONObject.put("key_nice_pics_ts", l);
        localJSONObject.put("key_nice_pics_url_1", localObject1);
        localJSONObject.put("key_nice_pics_url_2", localObject2);
        localJSONObject.put("key_frd_uin", paramTofuItem.frdUin);
        paramTofuItem = localJSONObject.toString();
      }
      catch (InvalidProtocolBufferMicroException paramTofuItem)
      {
        Object localObject2;
        QLog.d("Tofu_NicePicsDataHandler", 1, "getBusDataFromRspBytes ex=" + paramTofuItem.getMessage(), paramTofuItem);
        paramTofuItem = null;
        continue;
      }
      catch (JSONException paramTofuItem)
      {
        QLog.d("Tofu_NicePicsDataHandler", 1, "getBusDataFromRspBytes ex=" + paramTofuItem.getMessage(), paramTofuItem);
        paramTofuItem = null;
        continue;
      }
      catch (Exception paramTofuItem)
      {
        QLog.d("Tofu_NicePicsDataHandler", 1, "getBusDataFromRspBytes ex=" + paramTofuItem.getMessage(), paramTofuItem);
      }
      if (QLog.isColorLevel()) {
        QLog.i("Tofu_NicePicsDataHandler", 2, String.format("getBusDataFromRspBytes %s", new Object[] { paramTofuItem }));
      }
      return paramTofuItem;
      localObject1 = null;
      continue;
      localObject2 = null;
      continue;
      paramTofuItem = null;
    }
  }
  
  public boolean a(TofuItem paramTofuItem, boolean paramBoolean, long paramLong, oidb_0xe61.BeancurdCubeInfo paramBeancurdCubeInfo)
  {
    boolean bool7 = super.a(paramTofuItem, paramBoolean, paramLong, paramBeancurdCubeInfo);
    boolean bool3 = false;
    boolean bool5 = false;
    boolean bool6 = false;
    boolean bool4 = false;
    boolean bool1;
    boolean bool2;
    if (bool7)
    {
      paramBeancurdCubeInfo = new oidb_PhotoWall.GetPhotoIndexListRsp();
      bool1 = bool5;
      bool2 = bool6;
    }
    for (;;)
    {
      try
      {
        paramBeancurdCubeInfo.mergeFrom(paramTofuItem.bytesFromServer);
        bool1 = bool5;
        bool2 = bool6;
        oidb_PhotoWall.CommRsp localCommRsp = (oidb_PhotoWall.CommRsp)paramBeancurdCubeInfo.comm_rsp.get();
        if (localCommRsp == null) {
          continue;
        }
        bool1 = bool5;
        bool2 = bool6;
        if (!localCommRsp.result.has()) {
          continue;
        }
        bool1 = bool5;
        bool2 = bool6;
        i = localCommRsp.result.get();
        bool1 = bool5;
        bool2 = bool6;
        if (!paramBeancurdCubeInfo.base_time_photo_count.has()) {
          continue;
        }
        bool1 = bool5;
        bool2 = bool6;
        j = (int)paramBeancurdCubeInfo.base_time_photo_count.get();
        paramBoolean = bool4;
        if (i == 0)
        {
          paramBoolean = bool4;
          if (j > 0)
          {
            bool1 = bool5;
            bool2 = bool6;
            paramBeancurdCubeInfo = a(paramBeancurdCubeInfo);
            if (paramBeancurdCubeInfo == null) {
              continue;
            }
            paramBoolean = true;
            if (!paramBoolean) {
              continue;
            }
            bool1 = paramBoolean;
            bool2 = paramBoolean;
            paramBeancurdCubeInfo = paramBeancurdCubeInfo.toString();
            bool1 = paramBoolean;
            bool2 = paramBoolean;
            paramTofuItem.msg = paramBeancurdCubeInfo;
          }
        }
        bool3 = paramBoolean;
        bool1 = paramBoolean;
        bool2 = paramBoolean;
        if (QLog.isColorLevel())
        {
          bool1 = paramBoolean;
          bool2 = paramBoolean;
          QLog.i("Tofu_NicePicsDataHandler", 2, String.format("updateItemFromRsp resultCode=%d picCnt=%d parseSuc=%b", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Boolean.valueOf(paramBoolean) }));
          bool3 = paramBoolean;
        }
      }
      catch (InvalidProtocolBufferMicroException paramTofuItem)
      {
        int i;
        int j;
        QLog.d("Tofu_NicePicsDataHandler", 1, "updateItemFromRsp exception", paramTofuItem);
        bool3 = bool1;
        continue;
      }
      catch (Exception paramTofuItem)
      {
        QLog.d("Tofu_NicePicsDataHandler", 1, "updateItemFromRsp exception", paramTofuItem);
        bool3 = bool2;
        continue;
      }
      if ((!bool7) || (!bool3)) {
        break label356;
      }
      return true;
      i = -2147483648;
      continue;
      j = 0;
      continue;
      paramBoolean = false;
      continue;
      paramBeancurdCubeInfo = null;
    }
    label356:
    return false;
  }
  
  /* Error */
  public byte[] a(TofuItem paramTofuItem)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: new 73	org/json/JSONObject
    //   6: dup
    //   7: aload_1
    //   8: getfield 205	com/tencent/mobileqq/tofumsg/TofuItem:msg	Ljava/lang/String;
    //   11: invokespecial 225	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   14: astore 9
    //   16: aload 9
    //   18: ldc 78
    //   20: iconst_0
    //   21: invokevirtual 229	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   24: istore_2
    //   25: aload 9
    //   27: ldc 84
    //   29: iconst_0
    //   30: invokevirtual 229	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   33: istore_3
    //   34: aload 9
    //   36: ldc 86
    //   38: ldc 15
    //   40: invokevirtual 233	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   43: astore 8
    //   45: aload 9
    //   47: ldc 91
    //   49: iconst_0
    //   50: invokevirtual 229	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   53: istore 5
    //   55: iload 5
    //   57: istore 4
    //   59: new 235	tencent/im/oidb/PhotoWall/oidb_PhotoWall$GetPhotoIndexListReq
    //   62: dup
    //   63: invokespecial 236	tencent/im/oidb/PhotoWall/oidb_PhotoWall$GetPhotoIndexListReq:<init>	()V
    //   66: astore 9
    //   68: aload 9
    //   70: getfield 239	tencent/im/oidb/PhotoWall/oidb_PhotoWall$GetPhotoIndexListReq:uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   73: aload_1
    //   74: getfield 159	com/tencent/mobileqq/tofumsg/TofuItem:frdUin	J
    //   77: invokevirtual 243	com/tencent/mobileqq/pb/PBUInt64Field:set	(J)V
    //   80: aload 9
    //   82: getfield 246	tencent/im/oidb/PhotoWall/oidb_PhotoWall$GetPhotoIndexListReq:offset	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   85: iload_2
    //   86: invokevirtual 249	com/tencent/mobileqq/pb/PBInt32Field:set	(I)V
    //   89: aload 9
    //   91: getfield 252	tencent/im/oidb/PhotoWall/oidb_PhotoWall$GetPhotoIndexListReq:num	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   94: iconst_2
    //   95: invokevirtual 249	com/tencent/mobileqq/pb/PBInt32Field:set	(I)V
    //   98: aload 9
    //   100: getfield 253	tencent/im/oidb/PhotoWall/oidb_PhotoWall$GetPhotoIndexListReq:uptime	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   103: iload_3
    //   104: invokevirtual 254	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   107: invokestatic 260	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   110: invokevirtual 264	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   113: invokevirtual 269	mqq/app/AppRuntime:getAccount	()Ljava/lang/String;
    //   116: invokestatic 274	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   119: invokevirtual 277	java/lang/Long:longValue	()J
    //   122: lstore 6
    //   124: aload 9
    //   126: getfield 280	tencent/im/oidb/PhotoWall/oidb_PhotoWall$GetPhotoIndexListReq:opuin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   129: lload 6
    //   131: invokevirtual 243	com/tencent/mobileqq/pb/PBUInt64Field:set	(J)V
    //   134: aload 9
    //   136: getfield 283	tencent/im/oidb/PhotoWall/oidb_PhotoWall$GetPhotoIndexListReq:last_filekey	Lcom/tencent/mobileqq/pb/PBStringField;
    //   139: aload 8
    //   141: invokevirtual 285	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   144: aload 9
    //   146: getfield 288	tencent/im/oidb/PhotoWall/oidb_PhotoWall$GetPhotoIndexListReq:last_ctime	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   149: iload 4
    //   151: invokevirtual 254	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   154: aload 9
    //   156: getfield 291	tencent/im/oidb/PhotoWall/oidb_PhotoWall$GetPhotoIndexListReq:base_time	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   159: aload_1
    //   160: getfield 294	com/tencent/mobileqq/tofumsg/TofuItem:lastPullTsSvr	J
    //   163: invokevirtual 243	com/tencent/mobileqq/pb/PBUInt64Field:set	(J)V
    //   166: aload 9
    //   168: invokevirtual 298	tencent/im/oidb/PhotoWall/oidb_PhotoWall$GetPhotoIndexListReq:toByteArray	()[B
    //   171: areturn
    //   172: astore 9
    //   174: iconst_0
    //   175: istore_3
    //   176: iconst_0
    //   177: istore_2
    //   178: ldc 15
    //   180: astore 8
    //   182: ldc 98
    //   184: iconst_1
    //   185: ldc_w 300
    //   188: aload 9
    //   190: invokestatic 181	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   193: goto -134 -> 59
    //   196: astore 9
    //   198: iconst_0
    //   199: istore_3
    //   200: iconst_0
    //   201: istore_2
    //   202: ldc 15
    //   204: astore 8
    //   206: ldc 98
    //   208: iconst_1
    //   209: ldc_w 300
    //   212: aload 9
    //   214: invokestatic 181	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   217: goto -158 -> 59
    //   220: astore 9
    //   222: iconst_0
    //   223: istore_3
    //   224: ldc 15
    //   226: astore 8
    //   228: goto -22 -> 206
    //   231: astore 9
    //   233: ldc 15
    //   235: astore 8
    //   237: goto -31 -> 206
    //   240: astore 9
    //   242: goto -36 -> 206
    //   245: astore 9
    //   247: iconst_0
    //   248: istore_3
    //   249: ldc 15
    //   251: astore 8
    //   253: goto -71 -> 182
    //   256: astore 9
    //   258: ldc 15
    //   260: astore 8
    //   262: goto -80 -> 182
    //   265: astore 9
    //   267: goto -85 -> 182
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	270	0	this	aohw
    //   0	270	1	paramTofuItem	TofuItem
    //   24	178	2	i	int
    //   33	216	3	j	int
    //   1	149	4	k	int
    //   53	3	5	m	int
    //   122	8	6	l	long
    //   43	218	8	str	String
    //   14	153	9	localObject	Object
    //   172	17	9	localJSONException1	JSONException
    //   196	17	9	localException1	Exception
    //   220	1	9	localException2	Exception
    //   231	1	9	localException3	Exception
    //   240	1	9	localException4	Exception
    //   245	1	9	localJSONException2	JSONException
    //   256	1	9	localJSONException3	JSONException
    //   265	1	9	localJSONException4	JSONException
    // Exception table:
    //   from	to	target	type
    //   3	25	172	org/json/JSONException
    //   3	25	196	java/lang/Exception
    //   25	34	220	java/lang/Exception
    //   34	45	231	java/lang/Exception
    //   45	55	240	java/lang/Exception
    //   25	34	245	org/json/JSONException
    //   34	45	256	org/json/JSONException
    //   45	55	265	org/json/JSONException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aohw
 * JD-Core Version:    0.7.0.1
 */