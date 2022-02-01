import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.forward.ForwardMultServerShare.2;
import com.tencent.mobileqq.mini.share.opensdk.OpenSdkShareModel;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.List<Ltencent.im.oidb.cmd0xdc2.oidb_cmd0xdc2.BatchSendRsp;>;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import tencent.im.oidb.cmd0xb77.oidb_cmd0xb77.ImageInfo;
import tencent.im.oidb.cmd0xb77.oidb_cmd0xb77.ReqBody;
import tencent.im.oidb.cmd0xb77.oidb_cmd0xb77.RspBody;
import tencent.im.oidb.cmd0xdc2.oidb_cmd0xdc2.BatchSendReq;
import tencent.im.oidb.cmd0xdc2.oidb_cmd0xdc2.BatchSendRsp;
import tencent.im.oidb.cmd0xdc2.oidb_cmd0xdc2.ReqBody;

public class ahij
  implements Handler.Callback
{
  private static String TAG = "ForwardMultServerShare";
  private List<ResultRecord> BX;
  private ahhj jdField_a_of_type_Ahhj;
  private OpenSdkShareModel jdField_a_of_type_ComTencentMobileqqMiniShareOpensdkOpenSdkShareModel;
  private final MqqHandler b = new aurf(Looper.getMainLooper(), this);
  private Bundle bf;
  private AbsShareMsg d;
  private boolean isTimeOut;
  private Activity mActivity;
  private QQAppInterface mApp;
  private long uy = -1L;
  
  ahij(Bundle paramBundle)
  {
    this.bf = paramBundle;
    this.jdField_a_of_type_ComTencentMobileqqMiniShareOpensdkOpenSdkShareModel = ((OpenSdkShareModel)paramBundle.getParcelable("KEY_MINI_PROGRAM_SHARE_OBJ"));
  }
  
  private ResultRecord a(long paramLong)
  {
    Iterator localIterator = this.BX.iterator();
    while (localIterator.hasNext())
    {
      ResultRecord localResultRecord = (ResultRecord)localIterator.next();
      if (Long.toString(paramLong).equals(localResultRecord.uin)) {
        return localResultRecord;
      }
    }
    QLog.e(TAG, 1, "recvUin not found");
    return null;
  }
  
  private oidb_cmd0xb77.ImageInfo a(akyf.a parama)
  {
    if (parama == null) {
      return null;
    }
    if (!(parama.data instanceof int[])) {
      return null;
    }
    int[] arrayOfInt = (int[])parama.data;
    if (arrayOfInt.length != 5) {
      return null;
    }
    oidb_cmd0xb77.ImageInfo localImageInfo = new oidb_cmd0xb77.ImageInfo();
    localImageInfo.md5.set(parama.md5);
    localImageInfo.uuid.set(parama.uuid);
    localImageInfo.file_size.set(arrayOfInt[0]);
    localImageInfo.img_type.set(arrayOfInt[1]);
    localImageInfo.width.set(arrayOfInt[2]);
    localImageInfo.height.set(arrayOfInt[3]);
    localImageInfo.original.set(arrayOfInt[4]);
    localImageInfo.file_id.set((int)parama.groupFileID);
    return localImageInfo;
  }
  
  private oidb_cmd0xdc2.ReqBody a(String paramString1, String paramString2, Map<ResultRecord, akyf.a> paramMap)
  {
    oidb_cmd0xdc2.ReqBody localReqBody = new oidb_cmd0xdc2.ReqBody();
    localReqBody.msg_body.set(ahlj.a(this.bf, paramString1, paramString2, null));
    paramString1 = new ArrayList();
    paramString2 = this.BX.iterator();
    if (paramString2.hasNext())
    {
      ResultRecord localResultRecord = (ResultRecord)paramString2.next();
      oidb_cmd0xdc2.BatchSendReq localBatchSendReq = new oidb_cmd0xdc2.BatchSendReq();
      localBatchSendReq.recv_uin.set(ForwardUtils.parseLong(localResultRecord.uin));
      if (localResultRecord.uinType == 0) {
        localBatchSendReq.send_type.set(0);
      }
      for (;;)
      {
        a(paramMap, localResultRecord, localBatchSendReq);
        paramString1.add(localBatchSendReq);
        break;
        if (localResultRecord.uinType == 1) {
          localBatchSendReq.send_type.set(1);
        } else if (localResultRecord.uinType == 3000) {
          localBatchSendReq.send_type.set(2);
        }
      }
    }
    localReqBody.batch_send_req.set(paramString1);
    return localReqBody;
  }
  
  private void a(Intent paramIntent, List<oidb_cmd0xdc2.BatchSendRsp> paramList)
  {
    paramIntent.putExtra("sdk_mult_share_total_count", paramList.size());
    if (paramList.size() == 1)
    {
      localObject1 = (oidb_cmd0xdc2.BatchSendRsp)paramList.get(0);
      if (((oidb_cmd0xdc2.BatchSendRsp)localObject1).err_code.get() == 901503)
      {
        if (QLog.isColorLevel()) {
          QLog.d(TAG, 2, "buildResult SHARE_ERROR_NOT_FRIEND");
        }
        paramIntent.putExtra("sdk_mult_share_result_code", 901503);
        localObject1 = ((oidb_cmd0xdc2.BatchSendRsp)localObject1).rsp_body.wording.get();
        paramList = (List<oidb_cmd0xdc2.BatchSendRsp>)localObject1;
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          paramList = ahlj.bKK;
        }
        paramIntent.putExtra("sdk_mult_share_error_wording", paramList);
        return;
      }
    }
    Object localObject1 = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject2 = (oidb_cmd0xdc2.BatchSendRsp)paramList.next();
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, new Object[] { "rsp.recv_uin=", ((oidb_cmd0xdc2.BatchSendRsp)localObject2).recv_uin, ", rsp.err_msg=", ((oidb_cmd0xdc2.BatchSendRsp)localObject2).err_msg, ", rsp.err_code=", ((oidb_cmd0xdc2.BatchSendRsp)localObject2).err_code });
      }
      if (((oidb_cmd0xdc2.BatchSendRsp)localObject2).err_code.get() != 0)
      {
        localObject2 = a(((oidb_cmd0xdc2.BatchSendRsp)localObject2).recv_uin.get());
        if (localObject2 != null) {
          ((ArrayList)localObject1).add(localObject2);
        }
      }
    }
    if (((ArrayList)localObject1).isEmpty())
    {
      paramIntent.putExtra("sdk_mult_share_result_code", 0);
      return;
    }
    if (((ArrayList)localObject1).size() == this.BX.size())
    {
      paramIntent.putExtra("sdk_mult_share_result_code", 2);
      return;
    }
    paramIntent.putExtra("sdk_mult_share_result_code", 1);
    paramIntent.putParcelableArrayListExtra("sdk_mult_share_fail_record", (ArrayList)localObject1);
  }
  
  private void a(Map<ResultRecord, akyf.a> paramMap, ResultRecord paramResultRecord, oidb_cmd0xdc2.BatchSendReq paramBatchSendReq)
  {
    if (paramMap != null)
    {
      paramMap = a((akyf.a)paramMap.get(paramResultRecord));
      if (paramMap != null) {
        paramBatchSendReq.image_info.set(paramMap);
      }
    }
  }
  
  private void aj(Map<ResultRecord, akyf.a> paramMap)
  {
    paramMap = a(null, null, paramMap);
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if (localAppRuntime == null)
    {
      QLog.e(TAG, 1, "notifyImageSendMessage runtime = null ");
      onError();
      return;
    }
    Bundle localBundle = new Bundle();
    this.uy = System.currentTimeMillis();
    localBundle.putLong("0xdc2_9_sendTime", this.uy);
    QLog.i(TAG, 1, "notifyImageSendMessage OIDBRequest ");
    ahlw.Kj("KEY_STAGE_2_IMAGE_DC2");
    jnm.a(localAppRuntime, new ahim(this), paramMap.toByteArray(), "OidbSvc.0xdc2_9", 3522, 9, localBundle, 0L);
  }
  
  private void doi()
  {
    this.b.sendMessageDelayed(this.b.obtainMessage(93), 500L);
    if ((this.d instanceof StructMsgForImageShare))
    {
      dok();
      return;
    }
    doj();
  }
  
  private void doj()
  {
    QLog.d(TAG, 1, "-->ForwardMultServerShare requestNormalShare");
    WeakReference localWeakReference = new WeakReference(new ahik(this));
    int i = this.bf.getInt("uintype");
    String str1 = this.bf.getString("uin");
    String str2 = this.bf.getString("troop_uin");
    ahlw.Kj("KEY_STAGE_2_SEND_MSG_BY_SERVER");
    AbsShareMsg.sendSdkShareMessageByServer(this.mApp, this.d, str1, i, str2, (akyf)localWeakReference.get());
  }
  
  private void dok()
  {
    QLog.d(TAG, 1, "-->ForwardMultServerShare requestImageShare");
    HashMap localHashMap = new HashMap();
    ahlw.Kj("KEY_STAGE_2_UPLOAD_IMAGE_MULT");
    Iterator localIterator = this.BX.iterator();
    while (localIterator.hasNext()) {
      ThreadManager.post(new ForwardMultServerShare.2(this, (ResultRecord)localIterator.next(), localHashMap), 8, null, false);
    }
  }
  
  private void dol()
  {
    QLog.d(TAG, 1, "reportException");
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (this.BX == null) {}
    for (int i = 0;; i = this.BX.size())
    {
      ForwardUtils.a(localQQAppInterface, "0X800A739", new String[] { Integer.toString(i) });
      return;
    }
  }
  
  private void gb(String paramString1, String paramString2)
  {
    paramString1 = a(paramString1, paramString2, null);
    ahlj.a(this.jdField_a_of_type_ComTencentMobileqqMiniShareOpensdkOpenSdkShareModel, this.bf, paramString1.msg_body);
    paramString2 = BaseApplicationImpl.getApplication().getRuntime();
    if (paramString2 == null)
    {
      QLog.e(TAG, 1, "notifyNormalSendMessage send runtime = null");
      onError();
      return;
    }
    this.uy = System.currentTimeMillis();
    Bundle localBundle = new Bundle();
    localBundle.putLong("0xdc2_9_sendTime", this.uy);
    if (QLog.isColorLevel()) {
      QLog.i(TAG, 2, "notifyNormalSendMessage sendOIDBRequest");
    }
    ahlw.Kj("KEY_STAGE_2_NORMAL_DC2");
    jnm.a(paramString2, new ahin(this), paramString1.toByteArray(), "OidbSvc.0xdc2_9", 3522, 9, localBundle, 0L);
  }
  
  private void kS(List<oidb_cmd0xdc2.BatchSendRsp> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "onShareEnd");
    }
    this.b.removeMessages(94);
    this.b.removeMessages(93);
    Intent localIntent = new Intent(this.mActivity, SplashActivity.class);
    localIntent.putExtra("k_from_login", true);
    localIntent.putExtra("sdk_mult_share_app_name", this.bf.getString("app_name"));
    localIntent.putExtra("sdk_mult_share_source_app_id", this.d.mSourceAppid);
    localIntent.putExtra("sdk_mult_share_msg_service_id", this.d.mMsgServiceID);
    localIntent.putExtra("sdk_mult_share", true);
    a(localIntent, paramList);
    if (this.bf.getInt("forward_type", -1) == 11)
    {
      long l = this.bf.getLong("req_share_id");
      ForwardUtils.a(this.mActivity, this.bf.getString("pkg_name"), localIntent, l);
    }
    if (!this.bf.getBoolean("share_from_aio", false))
    {
      paramList = wja.a(localIntent, new int[] { 2 });
      this.bf.remove("share_from_aio");
    }
    for (;;)
    {
      paramList.putExtra("open_chatfragment", false);
      paramList.putExtra("fragment_id", 1);
      paramList.putExtras(this.bf);
      this.mActivity.startActivity(paramList);
      this.jdField_a_of_type_Ahhj.bT(this.mActivity);
      ForwardUtils.bz(this.mActivity);
      return;
      paramList = wja.a(localIntent, null);
      paramList.putExtra("share_from_aio", true);
    }
  }
  
  private void onError()
  {
    QLog.e(TAG, 1, "onError");
    this.b.removeMessages(94);
    this.b.removeMessages(93);
    this.jdField_a_of_type_Ahhj.bT(this.mActivity);
    ForwardUtils.a(this.mActivity, this.bf, ahlj.bKK);
  }
  
  void b(QQAppInterface paramQQAppInterface, Activity paramActivity)
  {
    this.mApp = paramQQAppInterface;
    this.mActivity = paramActivity;
    this.jdField_a_of_type_Ahhj = new ahhj();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      QLog.d(TAG, 1, "MSG_SDK_SHARE_REQUEST_LOADING_STATUS");
      this.jdField_a_of_type_Ahhj.bS(this.mActivity);
      this.b.sendMessageDelayed(this.b.obtainMessage(94), 10000L);
      continue;
      QLog.d(TAG, 1, "MSG_SDK_SHARE_REQUEST_TIMEOUT_STATUS");
      this.isTimeOut = true;
      if (!this.mActivity.isFinishing())
      {
        this.jdField_a_of_type_Ahhj.bT(this.mActivity);
        ForwardUtils.a(this.mActivity, this.bf, acfp.m(2131706500));
      }
      else
      {
        dol();
      }
    }
  }
  
  void kR(List<ResultRecord> paramList)
  {
    this.BX = paramList;
    if ((paramList == null) || (paramList.isEmpty()))
    {
      QLog.e(TAG, 1, "null == multiTargetWithoutDataLine || multiTargetWithoutDataLine.isEmpty()");
      dol();
      return;
    }
    if (this.mApp == null)
    {
      QLog.e(TAG, 1, " sendArkWithStruct error null == mApp");
      dol();
      return;
    }
    if (this.bf == null)
    {
      QLog.e(TAG, 1, " sendArkWithStruct error null == mExtraData");
      dol();
      return;
    }
    if (this.mActivity == null)
    {
      QLog.e(TAG, 1, " sendArkWithStruct error null == mActivity");
      dol();
      return;
    }
    paramList = anre.a(this.bf);
    if (!(paramList instanceof AbsShareMsg))
    {
      QLog.e(TAG, 1, " sendArkWithStruct error !(structMsg instanceof AbsShareMsg)");
      dol();
      return;
    }
    this.d = ((AbsShareMsg)paramList);
    if (!aqiw.isNetSupport(this.mActivity))
    {
      QLog.d(TAG, 1, "sendArkWithStruct no network");
      ForwardUtils.a(this.mActivity, this.bf, acfp.m(2131706501));
      return;
    }
    doi();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahij
 * JD-Core Version:    0.7.0.1
 */