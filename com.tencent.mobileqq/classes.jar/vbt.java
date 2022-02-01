import com.tencent.biz.qqcircle.fragments.QCircleBlockContainer;
import com.tencent.biz.qqcircle.report.QCircleReportBean;
import com.tencent.biz.richframework.part.block.base.NestScrollRecyclerView;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StComment;
import feedcloud.FeedCloudMeta.StReply;
import feedcloud.FeedCloudMeta.StUser;

class vbt
  implements vwd
{
  vbt(vbr paramvbr, FeedCloudMeta.StComment paramStComment) {}
  
  private void a(boolean paramBoolean, FeedCloudMeta.StComment paramStComment, FeedCloudMeta.StReply paramStReply)
  {
    vud localvud;
    Object localObject;
    if (vbr.a(this.jdField_a_of_type_Vbr))
    {
      vtr.a(vbr.a(this.jdField_a_of_type_Vbr), 3, vbr.a(this.jdField_a_of_type_Vbr), this.jdField_a_of_type_Vbr.a());
      localvud = vud.a();
      vuf localvuf = new vuf().a("commentbox");
      if (!paramBoolean) {
        break label200;
      }
      localObject = "comment";
      label62:
      localvuf = localvuf.b((String)localObject).a(vbr.a(this.jdField_a_of_type_Vbr).jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed);
      QCircleReportBean localQCircleReportBean = this.jdField_a_of_type_Vbr.a().clone();
      if (vbr.a(this.jdField_a_of_type_Vbr).jdField_a_of_type_JavaLangString != null) {
        break label207;
      }
      localObject = this.jdField_a_of_type_Vbr.a().getModuleIdStr();
      label121:
      localObject = localvuf.a(localQCircleReportBean.setModuleIdStr((String)localObject)).a(this.jdField_a_of_type_Vbr.c());
      if (!paramBoolean) {
        break label222;
      }
    }
    label200:
    label207:
    label222:
    for (paramStComment = paramStComment.postUser.id.get();; paramStComment = paramStReply.id.get())
    {
      localvud.a(((vuf)localObject).c(paramStComment));
      return;
      vtn.a(vbr.a(this.jdField_a_of_type_Vbr), 3, vbr.a(this.jdField_a_of_type_Vbr), this.jdField_a_of_type_Vbr.b());
      break;
      localObject = "reply";
      break label62;
      localObject = vbr.a(this.jdField_a_of_type_Vbr).jdField_a_of_type_JavaLangString;
      break label121;
    }
  }
  
  public void a(FeedCloudMeta.StComment paramStComment)
  {
    if (vbr.a(this.jdField_a_of_type_Vbr) != null)
    {
      vbr.a(this.jdField_a_of_type_Vbr).a(paramStComment);
      vbr.a(this.jdField_a_of_type_Vbr);
    }
    if (vbr.a(this.jdField_a_of_type_Vbr) != null)
    {
      QLog.d("QCircleCommentPanelPart", 1, "mNeedShowCommentList1");
      vbr.a(this.jdField_a_of_type_Vbr).a().scrollToPosition(0);
    }
    a(true, paramStComment, null);
  }
  
  public void a(FeedCloudMeta.StReply paramStReply)
  {
    if (vbr.a(this.jdField_a_of_type_Vbr) != null)
    {
      int i = vbr.a(this.jdField_a_of_type_Vbr, this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment.id.get());
      vbr.a(this.jdField_a_of_type_Vbr).a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment.id.get(), paramStReply);
      if ((i != -1) && (vbr.a(this.jdField_a_of_type_Vbr) != null)) {
        vbr.a(this.jdField_a_of_type_Vbr).a().scrollBy(0, i);
      }
    }
    a(false, null, paramStReply);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vbt
 * JD-Core Version:    0.7.0.1
 */