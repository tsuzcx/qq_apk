import com.tencent.biz.qqcircle.fragments.QCircleBlockContainer;
import com.tencent.biz.qqcircle.report.QCircleReportBean;
import com.tencent.biz.richframework.part.block.base.NestScrollRecyclerView;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StComment;
import feedcloud.FeedCloudMeta.StReply;
import feedcloud.FeedCloudMeta.StUser;

class vad
  implements vth
{
  vad(vab paramvab, FeedCloudMeta.StComment paramStComment) {}
  
  private void a(boolean paramBoolean, FeedCloudMeta.StComment paramStComment, FeedCloudMeta.StReply paramStReply)
  {
    vrr localvrr;
    Object localObject;
    if (vab.a(this.jdField_a_of_type_Vab))
    {
      vrg.a(vab.a(this.jdField_a_of_type_Vab), 3, vab.a(this.jdField_a_of_type_Vab), this.jdField_a_of_type_Vab.a());
      localvrr = vrr.a();
      vrt localvrt = new vrt().a("commentbox");
      if (!paramBoolean) {
        break label200;
      }
      localObject = "comment";
      label62:
      localvrt = localvrt.b((String)localObject).a(vab.a(this.jdField_a_of_type_Vab).jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed);
      QCircleReportBean localQCircleReportBean = this.jdField_a_of_type_Vab.a().clone();
      if (vab.a(this.jdField_a_of_type_Vab).jdField_a_of_type_JavaLangString != null) {
        break label207;
      }
      localObject = this.jdField_a_of_type_Vab.a().getModuleIdStr();
      label121:
      localObject = localvrt.a(localQCircleReportBean.setModuleIdStr((String)localObject)).a(this.jdField_a_of_type_Vab.c());
      if (!paramBoolean) {
        break label222;
      }
    }
    label200:
    label207:
    label222:
    for (paramStComment = paramStComment.postUser.id.get();; paramStComment = paramStReply.id.get())
    {
      localvrr.a(((vrt)localObject).c(paramStComment));
      return;
      vrc.a(vab.a(this.jdField_a_of_type_Vab), 3, vab.a(this.jdField_a_of_type_Vab), this.jdField_a_of_type_Vab.b());
      break;
      localObject = "reply";
      break label62;
      localObject = vab.a(this.jdField_a_of_type_Vab).jdField_a_of_type_JavaLangString;
      break label121;
    }
  }
  
  public void a(FeedCloudMeta.StComment paramStComment)
  {
    if (vab.a(this.jdField_a_of_type_Vab) != null)
    {
      vab.a(this.jdField_a_of_type_Vab).a(paramStComment);
      vab.a(this.jdField_a_of_type_Vab);
    }
    if (vab.a(this.jdField_a_of_type_Vab) != null)
    {
      QLog.d("QCircleCommentPanelPart", 1, "mNeedShowCommentList1");
      vab.a(this.jdField_a_of_type_Vab).a().scrollToPosition(0);
    }
    a(true, paramStComment, null);
  }
  
  public void a(FeedCloudMeta.StReply paramStReply)
  {
    if (vab.a(this.jdField_a_of_type_Vab) != null)
    {
      int i = vab.a(this.jdField_a_of_type_Vab, this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment.id.get());
      vab.a(this.jdField_a_of_type_Vab).a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment.id.get(), paramStReply);
      if ((i != -1) && (vab.a(this.jdField_a_of_type_Vab) != null)) {
        vab.a(this.jdField_a_of_type_Vab).a().scrollBy(0, i);
      }
    }
    a(false, null, paramStReply);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vad
 * JD-Core Version:    0.7.0.1
 */