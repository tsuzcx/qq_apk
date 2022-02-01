import com.tencent.biz.qqcircle.fragments.QCircleBlockContainer;
import com.tencent.biz.qqcircle.report.QCircleReportBean;
import com.tencent.biz.qqcircle.widgets.QCircleCommentListView;
import com.tencent.biz.richframework.part.block.base.NestScrollRecyclerView;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StComment;
import feedcloud.FeedCloudMeta.StReply;
import feedcloud.FeedCloudMeta.StUser;

public class vvs
  implements vth
{
  public vvs(QCircleCommentListView paramQCircleCommentListView, FeedCloudMeta.StComment paramStComment) {}
  
  private void a(boolean paramBoolean, FeedCloudMeta.StComment paramStComment, FeedCloudMeta.StReply paramStReply)
  {
    vrr localvrr;
    Object localObject;
    if (QCircleCommentListView.a(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleCommentListView))
    {
      vrg.a(QCircleCommentListView.a(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleCommentListView), 3, QCircleCommentListView.a(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleCommentListView), this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleCommentListView.e());
      localvrr = vrr.a();
      vrt localvrt = new vrt().a("commentbox");
      if (!paramBoolean) {
        break label200;
      }
      localObject = "comment";
      label62:
      localvrt = localvrt.b((String)localObject).a(QCircleCommentListView.a(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleCommentListView).jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed);
      QCircleReportBean localQCircleReportBean = this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleCommentListView.a().clone();
      if (QCircleCommentListView.a(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleCommentListView).jdField_a_of_type_JavaLangString != null) {
        break label207;
      }
      localObject = this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleCommentListView.a().getModuleIdStr();
      label121:
      localObject = localvrt.a(localQCircleReportBean.setModuleIdStr((String)localObject)).a(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleCommentListView.b());
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
      vrc.a(QCircleCommentListView.a(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleCommentListView), 3, QCircleCommentListView.a(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleCommentListView), this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleCommentListView.d());
      break;
      localObject = "reply";
      break label62;
      localObject = QCircleCommentListView.a(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleCommentListView).jdField_a_of_type_JavaLangString;
      break label121;
    }
  }
  
  public void a(FeedCloudMeta.StComment paramStComment)
  {
    if (QCircleCommentListView.a(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleCommentListView) != null)
    {
      QCircleCommentListView.a(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleCommentListView).a(paramStComment);
      QCircleCommentListView.a(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleCommentListView);
    }
    if (QCircleCommentListView.a(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleCommentListView) != null)
    {
      QLog.d("QCircleCommentPanelPart", 1, "mNeedShowCommentList1");
      QCircleCommentListView.a(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleCommentListView).a().scrollToPosition(0);
    }
    a(true, paramStComment, null);
  }
  
  public void a(FeedCloudMeta.StReply paramStReply)
  {
    if (QCircleCommentListView.a(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleCommentListView) != null)
    {
      int i = QCircleCommentListView.a(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleCommentListView, this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment.id.get());
      QCircleCommentListView.a(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleCommentListView).a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment.id.get(), paramStReply);
      if ((i != -1) && (QCircleCommentListView.a(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleCommentListView) != null)) {
        QCircleCommentListView.a(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleCommentListView).a().scrollBy(0, i);
      }
    }
    a(false, null, paramStReply);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vvs
 * JD-Core Version:    0.7.0.1
 */