import android.os.Handler;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.biuAndCommentMix.RIJBiuAndCommentRequestData;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import tencent.im.oidb.cmd0xe16.oidb_cmd0xe16.CommentInfo;
import tencent.im.oidb.cmd0xe16.oidb_cmd0xe16.ContentInfo;
import tencent.im.oidb.cmd0xe16.oidb_cmd0xe16.ParamInfo;
import tencent.im.oidb.cmd0xe16.oidb_cmd0xe16.ReqBody;
import tencent.im.oidb.cmd0xe16.oidb_cmd0xe16.RspBody;

public class kqe
  extends lir
{
  private kqe.a a;
  
  public kqe(AppInterface paramAppInterface, EntityManager paramEntityManager, ExecutorService paramExecutorService, lun paramlun, Handler paramHandler)
  {
    super(paramAppInterface, paramEntityManager, paramExecutorService, paramlun, paramHandler);
  }
  
  private oidb_cmd0xe16.ReqBody a(RIJBiuAndCommentRequestData paramRIJBiuAndCommentRequestData, ArticleInfo paramArticleInfo)
  {
    oidb_cmd0xe16.ContentInfo localContentInfo = new oidb_cmd0xe16.ContentInfo();
    localContentInfo.str_rowkey.set(paramRIJBiuAndCommentRequestData.getRowKey());
    localContentInfo.uint32_src.set(paramRIJBiuAndCommentRequestData.getContentSrc());
    oidb_cmd0xe16.CommentInfo localCommentInfo = new oidb_cmd0xe16.CommentInfo();
    if (!TextUtils.isEmpty(paramRIJBiuAndCommentRequestData.getContentString()))
    {
      localCommentInfo.str_comment.set(new String(aqgo.decode(paramRIJBiuAndCommentRequestData.getContentString().getBytes(), 0)));
      if (paramRIJBiuAndCommentRequestData.getCommentType() == 2)
      {
        if (!TextUtils.isEmpty(paramRIJBiuAndCommentRequestData.getReplyUin())) {
          localCommentInfo.uint64_sub_author.set(Long.parseLong(paramRIJBiuAndCommentRequestData.getReplyUin()));
        }
        localCommentInfo.str_sub_comment_id.set(paramRIJBiuAndCommentRequestData.getReplyCommentId());
        if (TextUtils.isEmpty(paramRIJBiuAndCommentRequestData.getReplyParentCommentId())) {
          break label235;
        }
        localCommentInfo.str_comment_id.set(paramRIJBiuAndCommentRequestData.getReplyParentCommentId());
      }
    }
    for (;;)
    {
      paramArticleInfo = new oidb_cmd0xe16.ParamInfo();
      paramArticleInfo.bool_diffuse_to_friends.set(paramRIJBiuAndCommentRequestData.isDiffuseToFriends());
      paramArticleInfo.bool_with_biu.set(paramRIJBiuAndCommentRequestData.isBiu());
      paramRIJBiuAndCommentRequestData = new oidb_cmd0xe16.ReqBody();
      paramRIJBiuAndCommentRequestData.msg_comment_info.set(localCommentInfo);
      paramRIJBiuAndCommentRequestData.msg_content_info.set(localContentInfo);
      paramRIJBiuAndCommentRequestData.msg_param_info.set(paramArticleInfo);
      QLog.d("RIJBiuAndCommentMixPBModule", 1, "get0xe16ReqBody :" + paramRIJBiuAndCommentRequestData.toString());
      return paramRIJBiuAndCommentRequestData;
      label235:
      paramArticleInfo = ktr.a(paramArticleInfo);
      if (paramArticleInfo != null)
      {
        paramArticleInfo = paramArticleInfo.eo(paramRIJBiuAndCommentRequestData.getReplyCommentId());
        paramRIJBiuAndCommentRequestData.setReplyParentCommentId(paramArticleInfo);
        localCommentInfo.str_comment_id.set(paramArticleInfo);
      }
    }
  }
  
  private void o(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (this.a != null) {
      this.a.n(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
  }
  
  private void p(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    odv.a(lup.parseOIDBPkg(paramFromServiceMsg, paramObject, new oidb_cmd0xe16.RspBody()), paramToServiceMsg, 2, null);
  }
  
  public void a(ArticleInfo paramArticleInfo, RIJBiuAndCommentRequestData paramRIJBiuAndCommentRequestData)
  {
    if ((paramArticleInfo == null) || (paramRIJBiuAndCommentRequestData == null)) {
      QLog.d("RIJBiuAndCommentMixPBModule", 1, "requestCreateBiuAndCommentMixComment someThing is NULL");
    }
    ToServiceMsg localToServiceMsg;
    do
    {
      return;
      QLog.d("RIJBiuAndCommentMixPBModule", 1, "start request 0xe16 " + paramRIJBiuAndCommentRequestData.toString());
      localToServiceMsg = lup.makeOIDBPkg("OidbSvc.0xe16", 3606, 1, a(paramRIJBiuAndCommentRequestData, paramArticleInfo).toByteArray());
      if ((localToServiceMsg != null) && (localToServiceMsg.getAttributes() != null))
      {
        localToServiceMsg.getAttributes().put("request_data_entry", paramRIJBiuAndCommentRequestData);
        localToServiceMsg.getAttributes().put("article_attributes", paramArticleInfo);
        localToServiceMsg.getAttributes().put("service_type", Integer.valueOf(1));
      }
    } while (localToServiceMsg == null);
    sendPbReq(localToServiceMsg);
    QLog.d("RIJBiuAndCommentMixPBModule", 1, "0xe16 request :" + localToServiceMsg.toString());
  }
  
  public void a(kqe.a parama)
  {
    this.a = parama;
  }
  
  public void aEL()
  {
    this.a = null;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0xe16"))
    {
      Object localObject = paramToServiceMsg.getAttributes().get("service_type");
      if (((localObject instanceof Integer)) && (((Integer)localObject).intValue() == 1))
      {
        o(paramToServiceMsg, paramFromServiceMsg, paramObject);
        p(paramToServiceMsg, paramFromServiceMsg, paramObject);
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void n(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kqe
 * JD-Core Version:    0.7.0.1
 */