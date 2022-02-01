import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.biuAndCommentMix.RIJBiuAndCommentMixDataManager.1;
import com.tencent.biz.pubaccount.readinjoy.biuAndCommentMix.RIJBiuAndCommentRequestData;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.cmd0xe16.oidb_cmd0xe16.CardJumpInfo;
import tencent.im.oidb.cmd0xe16.oidb_cmd0xe16.KeyInfo;
import tencent.im.oidb.cmd0xe16.oidb_cmd0xe16.RspBody;

public class kqd
  implements kqe.a
{
  private kqd.a jdField_a_of_type_Kqd$a;
  private kqe jdField_a_of_type_Kqe;
  
  public kqd()
  {
    Object localObject = kxm.a();
    if (localObject != null)
    {
      localObject = (lcd)((QQAppInterface)localObject).getManager(163);
      if (localObject != null)
      {
        this.jdField_a_of_type_Kqe = ((lcd)localObject).b().a();
        if (this.jdField_a_of_type_Kqe != null) {
          this.jdField_a_of_type_Kqe.a(this);
        }
        QLog.d("RIJBiuAndCommentMixDataManager", 1, "RIJBiuAndCommentMixDataManager init");
      }
    }
  }
  
  private kqf a(oidb_cmd0xe16.RspBody paramRspBody, int paramInt, ToServiceMsg paramToServiceMsg)
  {
    kqf localkqf = new kqf();
    localkqf.setResultCode(paramInt);
    if (paramRspBody.msg_key_info.has())
    {
      if (paramRspBody.msg_key_info.uint64_feeds_id.has()) {
        localkqf.setFeedsId(String.valueOf(paramRspBody.msg_key_info.uint64_feeds_id.get()));
      }
      if (paramRspBody.msg_key_info.uint32_feeds_type.has()) {
        localkqf.setFeedsType(paramRspBody.msg_key_info.uint32_feeds_type.get());
      }
      if ((!paramRspBody.msg_key_info.str_sub_comment_id.has()) || (TextUtils.isEmpty(paramRspBody.msg_key_info.str_sub_comment_id.get()))) {
        break label455;
      }
      localkqf.setCommentId(paramRspBody.msg_key_info.str_sub_comment_id.get());
    }
    for (;;)
    {
      if (paramRspBody.msg_card_jump_info.has())
      {
        if ((paramRspBody.msg_card_jump_info.bytes_card_jump_url.has()) && (!TextUtils.isEmpty(paramRspBody.msg_card_jump_info.bytes_card_jump_url.get().toStringUtf8()))) {
          localkqf.mr(paramRspBody.msg_card_jump_info.bytes_card_jump_url.get().toStringUtf8());
        }
        if ((paramRspBody.msg_card_jump_info.bytes_comment_btn_url.has()) && (!TextUtils.isEmpty(paramRspBody.msg_card_jump_info.bytes_comment_btn_url.get().toStringUtf8()))) {
          localkqf.ms(paramRspBody.msg_card_jump_info.bytes_comment_btn_url.get().toStringUtf8());
        }
        if (paramRspBody.msg_card_jump_info.uint32_available.has()) {
          localkqf.px(paramRspBody.msg_card_jump_info.uint32_available.get());
        }
        if (paramRspBody.msg_card_jump_info.bytes_share_url.has()) {
          localkqf.mp(paramRspBody.msg_card_jump_info.bytes_share_url.get().toStringUtf8());
        }
      }
      if ((paramToServiceMsg != null) && (paramToServiceMsg.getAttributes() != null))
      {
        paramRspBody = (RIJBiuAndCommentRequestData)paramToServiceMsg.getAttributes().get("request_data_entry");
        if (paramRspBody != null)
        {
          localkqf.mq(paramRspBody.getContentString());
          localkqf.setListShowType(paramRspBody.getListShowType());
          localkqf.setCommentType(paramRspBody.getCommentType());
          localkqf.setReplyCommentId(paramRspBody.getReplyCommentId());
          localkqf.setReplyParentCommentId(paramRspBody.getReplyParentCommentId());
          localkqf.setReplyUin(paramRspBody.getReplyUin());
          localkqf.setIsSecondReply(paramRspBody.isIsSecondReply());
          localkqf.setContentSrc(paramRspBody.getContentSrc());
        }
        paramRspBody = paramToServiceMsg.getAttributes().get("article_attributes");
        if ((paramRspBody instanceof ArticleInfo)) {
          localkqf.b((ArticleInfo)paramRspBody);
        }
      }
      QLog.d("RIJBiuAndCommentMixDataManager", 1, "onBiuAndCommentMixSend RIJBiuAndCommentRespData info is" + localkqf.toString());
      return localkqf;
      label455:
      if ((paramRspBody.msg_key_info.str_comment_id.has()) && (!TextUtils.isEmpty(paramRspBody.msg_key_info.str_comment_id.get()))) {
        localkqf.setCommentId(paramRspBody.msg_key_info.str_comment_id.get());
      }
    }
  }
  
  public static void a(String paramString1, String paramString2, int paramInt1, int paramInt2, boolean paramBoolean, String paramString3, String paramString4, ArticleInfo paramArticleInfo)
  {
    if (paramArticleInfo == null) {
      QLog.d("RIJBiuAndCommentMixDataManager", 1, "createLocalComment article info is null");
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("comment", paramString1);
      localJSONObject.put("commentId", paramString3);
      localJSONObject.put("isSecondReply", paramBoolean);
      localJSONObject.put("replyUin", paramString4);
      paramString1 = ktr.a(paramArticleInfo);
      if (paramString1 != null) {
        paramString1.a(paramString1.a(paramInt1, localJSONObject.toString()), paramString2, paramInt2);
      }
      return;
    }
    catch (JSONException paramString1)
    {
      for (;;)
      {
        paramString1.printStackTrace();
      }
    }
  }
  
  private void a(kqf paramkqf)
  {
    if ((paramkqf == null) || (paramkqf.a() == null))
    {
      QLog.d("RIJBiuAndCommentMixDataManager", 2, "reportMixCommentBiuResult | respData or mArticleInfo is null");
      return;
    }
    ArticleInfo localArticleInfo = paramkqf.a();
    paramkqf = "";
    try
    {
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("rowkey", localArticleInfo.innerUniqueID);
      ((JSONObject)localObject).put("article_id", localArticleInfo.mArticleID);
      ((JSONObject)localObject).put("content_type", 1);
      ((JSONObject)localObject).put("time", System.currentTimeMillis() / 1000L);
      localObject = ((JSONObject)localObject).toString();
      paramkqf = (kqf)localObject;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        QLog.d("RIJBiuAndCommentMixDataManager", 2, localJSONException.getMessage());
      }
    }
    kbp.a(null, ksz.a(localArticleInfo), "0X800AC6A", "0X800AC6A", 0, 0, String.valueOf(localArticleInfo.mArticleID), "", localArticleInfo.innerUniqueID, paramkqf, false);
  }
  
  public void a(ArticleInfo paramArticleInfo, RIJBiuAndCommentRequestData paramRIJBiuAndCommentRequestData)
  {
    if ((paramArticleInfo == null) || (paramRIJBiuAndCommentRequestData == null)) {
      QLog.d("RIJBiuAndCommentMixDataManager", 1, "requestCreateBiuAndCommentMixComment someThing is null");
    }
    while (this.jdField_a_of_type_Kqe == null) {
      return;
    }
    QLog.d("RIJBiuAndCommentMixDataManager", 1, "requestCreateBiuAndCommentMixComment goTo pbRequest");
    this.jdField_a_of_type_Kqe.a(paramArticleInfo, paramRIJBiuAndCommentRequestData);
  }
  
  public void a(kqd.a parama)
  {
    this.jdField_a_of_type_Kqd$a = parama;
    QLog.d("RIJBiuAndCommentMixDataManager", 1, "setBiuAndCommentListener");
  }
  
  public void clear()
  {
    this.jdField_a_of_type_Kqe.aEL();
    this.jdField_a_of_type_Kqe = null;
    this.jdField_a_of_type_Kqd$a = null;
    QLog.d("RIJBiuAndCommentMixDataManager", 1, "onDestroy clear info");
  }
  
  public void n(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    oidb_cmd0xe16.RspBody localRspBody = new oidb_cmd0xe16.RspBody();
    int i = lup.parseOIDBPkg(paramFromServiceMsg, paramObject, localRspBody);
    paramToServiceMsg = a(localRspBody, i, paramToServiceMsg);
    ThreadManager.getUIHandler().post(new RIJBiuAndCommentMixDataManager.1(this, paramToServiceMsg, i));
    if (i == 0) {
      a(paramToServiceMsg);
    }
  }
  
  public static abstract interface a
  {
    public abstract void b(kqf paramkqf);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kqd
 * JD-Core Version:    0.7.0.1
 */