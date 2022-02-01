import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.viola.videonew.barrage.BarrageHandler.1;
import com.tencent.biz.pubaccount.readinjoy.viola.videonew.barrage.BarrageInfo;
import com.tencent.biz.pubaccount.readinjoy.viola.videonew.barrage.BarrageInfo.Sender;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.cmd0xc15.oidb_0xc15.Barrage;
import tencent.im.oidb.cmd0xc15.oidb_0xc15.ReqBody;
import tencent.im.oidb.cmd0xc15.oidb_0xc15.RspBody;
import tencent.im.oidb.cmd0xc15.oidb_0xc15.Sender;

public class tnq
  extends BusinessHandler
{
  private String a;
  
  public tnq(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private BarrageInfo.Sender a(oidb_0xc15.Barrage paramBarrage)
  {
    if (paramBarrage == null) {
      return null;
    }
    if ((paramBarrage.has()) && (paramBarrage.get() != null) && (((oidb_0xc15.Barrage)paramBarrage.get()).rpt_sender.has()) && (((oidb_0xc15.Barrage)paramBarrage.get()).rpt_sender.get() != null))
    {
      BarrageInfo.Sender localSender = new BarrageInfo.Sender();
      paramBarrage = (oidb_0xc15.Sender)paramBarrage.rpt_sender.get();
      localSender.b = a(paramBarrage.bytes_sender_name);
      localSender.jdField_a_of_type_JavaLangString = a(paramBarrage.bytes_avatar_url);
      localSender.c = a(paramBarrage.bytes_avatar_icon_url);
      if (paramBarrage.uint32_is_author.get() == 1) {}
      for (boolean bool = true;; bool = false)
      {
        localSender.jdField_a_of_type_Boolean = bool;
        return localSender;
      }
    }
    return null;
  }
  
  private String a(PBBytesField paramPBBytesField)
  {
    if ((paramPBBytesField.has()) && (paramPBBytesField.get() != null)) {
      return paramPBBytesField.get().toStringUtf8();
    }
    return null;
  }
  
  private ArrayList<BarrageInfo> a(oidb_0xc15.RspBody paramRspBody)
  {
    if (paramRspBody == null) {}
    while ((!paramRspBody.rpt_barrage_list.has()) || (paramRspBody.rpt_barrage_list.get() == null)) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramRspBody.rpt_barrage_list.get().iterator();
    while (localIterator.hasNext())
    {
      paramRspBody = (oidb_0xc15.Barrage)localIterator.next();
      if ((paramRspBody.has()) && (paramRspBody.get() != null))
      {
        BarrageInfo localBarrageInfo = new BarrageInfo();
        localBarrageInfo.jdField_a_of_type_JavaLangString = a(paramRspBody.bytes_barrage_id);
        if (paramRspBody.uint32_barrage_type.has()) {
          localBarrageInfo.jdField_a_of_type_Int = paramRspBody.uint32_barrage_type.get();
        }
        localBarrageInfo.b = a(paramRspBody.bytes_comment);
        localBarrageInfo.a();
        localBarrageInfo.c = a(paramRspBody.bytes_comment_corner_url);
        localBarrageInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewBarrageBarrageInfo$Sender = a(paramRspBody);
        localBarrageInfo.b();
        if (localBarrageInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewBarrageBarrageInfo$Sender != null) {}
        for (paramRspBody = localBarrageInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewBarrageBarrageInfo$Sender.b;; paramRspBody = null)
        {
          if (a(paramRspBody, localBarrageInfo.b)) {
            break label215;
          }
          localArrayList.add(localBarrageInfo);
          break;
        }
        label215:
        if (QLog.isColorLevel()) {
          QLog.d("BarrageHandler", 2, "filter barrage info: " + localBarrageInfo.toString());
        }
      }
    }
    return localArrayList;
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool2 = true;
    Object localObject1 = new oidb_0xc15.RspBody();
    if (parseOIDBPkg(paramFromServiceMsg, paramObject, (MessageMicro)localObject1) == 0) {}
    Bundle localBundle;
    Object localObject2;
    for (boolean bool1 = true;; bool1 = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("BarrageHandler", 2, "handleGetBarrageList: isSuccess=" + bool1);
      }
      localBundle = new Bundle();
      localObject2 = (String)paramToServiceMsg.getAttribute("value_row_key");
      localBundle.putString("value_row_key", (String)localObject2);
      if (TextUtils.equals(this.jdField_a_of_type_JavaLangString, (CharSequence)localObject2)) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("BarrageHandler", 2, "handleGetBarrageList ignore result for rowkey is not equal, mRequestRowkey:" + this.jdField_a_of_type_JavaLangString + " rowKey:" + (String)localObject2);
      }
      return;
    }
    if (bool1) {}
    for (;;)
    {
      try
      {
        paramFromServiceMsg = a(((oidb_0xc15.RspBody)localObject1).bytes_cookie);
        paramObject = a(((oidb_0xc15.RspBody)localObject1).bytes_common_data);
        localBundle.putString("value_cookie", paramFromServiceMsg);
        localBundle.putString("value_common_data", paramObject);
        int i = -1;
        if (((oidb_0xc15.RspBody)localObject1).uint32_barrage_time_interval.has())
        {
          i = ((oidb_0xc15.RspBody)localObject1).uint32_barrage_time_interval.get();
          localBundle.putInt("value_barrage_time_interval", i);
        }
        paramToServiceMsg = a((oidb_0xc15.RspBody)localObject1);
        localBundle.putParcelableArrayList("value_barrage_list", paramToServiceMsg);
        if (((oidb_0xc15.RspBody)localObject1).uint32_has_more_data.has())
        {
          if (((oidb_0xc15.RspBody)localObject1).uint32_has_more_data.get() != 1) {
            continue;
          }
          localBundle.putBoolean("value_has_more_data", bool2);
        }
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          localObject2 = ((StringBuilder)localObject1).append(", barrage_time_interval: ").append(i).append(", rowKey: ").append((String)localObject2).append(", barrageList:, ");
          if (paramToServiceMsg == null) {
            continue;
          }
          paramToServiceMsg = paramToServiceMsg.toString();
          localObject2 = ((StringBuilder)localObject2).append(paramToServiceMsg).append(", sessionParams: ");
          if (paramObject == null) {
            break label462;
          }
          paramToServiceMsg = paramObject;
          paramObject = ((StringBuilder)localObject2).append(paramToServiceMsg);
          if (paramFromServiceMsg == null) {
            continue;
          }
          paramToServiceMsg = paramFromServiceMsg;
          paramObject.append(paramToServiceMsg);
          QLog.d("BarrageHandler", 2, ((StringBuilder)localObject1).toString());
        }
      }
      catch (Exception paramToServiceMsg)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("BarrageHandler", 2, "解析后台返回的数据出错：" + paramToServiceMsg.getMessage());
        continue;
      }
      notifyUI(0, bool1, localBundle);
      return;
      bool2 = false;
      continue;
      paramToServiceMsg = "null";
      continue;
      paramToServiceMsg = "null";
      continue;
      if (QLog.isColorLevel())
      {
        QLog.d("BarrageHandler", 2, "后台返回的列表为空或者请求结果出错！");
        continue;
        label462:
        paramToServiceMsg = "null";
      }
    }
  }
  
  private boolean a(String paramString1, String paramString2)
  {
    int i;
    if ((TextUtils.isEmpty(paramString1)) || (paramString1.trim().length() <= 0))
    {
      i = 1;
      if ((!TextUtils.isEmpty(paramString2)) && (paramString2.trim().length() > 0)) {
        break label55;
      }
    }
    label55:
    for (int j = 1;; j = 0)
    {
      if ((i == 0) || (j == 0)) {
        break label61;
      }
      return true;
      i = 0;
      break;
    }
    label61:
    return false;
  }
  
  public void a(long paramLong, String paramString1, String paramString2, int paramInt1, int paramInt2, tns paramtns)
  {
    ThreadManagerV2.executeOnSubThread(new BarrageHandler.1(this, paramLong, paramString1, paramString2, paramInt1, paramtns, paramInt2));
  }
  
  public void a(long paramLong, String paramString1, String paramString2, int paramInt1, tns paramtns, int paramInt2)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("BarrageHandler", 2, "doFetchBarrageList articleId:" + paramLong + " rowKey:" + paramString1 + " puin:" + paramString2);
      }
      this.jdField_a_of_type_JavaLangString = paramString1;
      oidb_0xc15.ReqBody localReqBody = new oidb_0xc15.ReqBody();
      localReqBody.uint64_article_id.set(paramLong);
      if (!TextUtils.isEmpty(paramString1)) {
        localReqBody.bytes_rowkey.set(ByteStringMicro.copyFromUtf8(paramString1));
      }
      if (TextUtils.isEmpty(paramString2)) {
        localReqBody.bytes_puin.set(ByteStringMicro.copyFromUtf8(paramString2));
      }
      localReqBody.uint32_want_count.set(paramInt1);
      if (paramtns != null)
      {
        if (!TextUtils.isEmpty(paramtns.jdField_a_of_type_JavaLangString)) {
          localReqBody.bytes_cookie.set(ByteStringMicro.copyFromUtf8(paramtns.jdField_a_of_type_JavaLangString));
        }
        if (!TextUtils.isEmpty(paramtns.b)) {
          localReqBody.bytes_common_data.set(ByteStringMicro.copyFromUtf8(paramtns.b));
        }
      }
      paramString2 = makeOIDBPkg("OidbSvc.0xc15", 3093, paramInt2, localReqBody.toByteArray());
      paramString2.addAttribute("value_row_key", paramString1);
      sendPbReq(paramString2);
      if (QLog.isColorLevel())
      {
        paramString2 = new StringBuilder();
        paramString2.append("articleId: ").append(paramLong).append(", rowKey: ").append(paramString1).append(", barrageCounts: ").append(paramInt1).append(", serviceType: ").append(paramInt2);
        QLog.d("BarrageHandler", 2, "3ba package msg: " + paramString2.toString());
      }
      return;
    }
    catch (Exception paramString1)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("BarrageHandler", 2, "make 3ba package error!!, " + paramString1.getMessage());
    }
  }
  
  public void a(long paramLong, String paramString1, String paramString2, tns paramtns)
  {
    a(paramLong, paramString1, paramString2, 0, 0, paramtns);
  }
  
  public Class<? extends BusinessObserver> observerClass()
  {
    return tnr.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    a(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tnq
 * JD-Core Version:    0.7.0.1
 */