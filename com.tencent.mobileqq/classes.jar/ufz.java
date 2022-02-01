import UserGrowth.stSchema;
import UserGrowth.stSimpleMetaComment;
import UserGrowth.stSimpleMetaPerson;
import UserGrowth.stSimpleMetaReply;
import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ListView;
import com.tencent.biz.pubaccount.weishi_new.WSFollowFragment;
import com.tencent.biz.pubaccount.weishi_new.download.WSDownloadParams;
import com.tencent.widget.pull2refresh.RecyclerViewWithHeaderFooter;
import com.tencent.widget.pull2refresh.XRecyclerView;
import cooperation.qzone.video.QzoneLiveVideoInterface;
import java.net.URLDecoder;

class ufz
  implements aakb
{
  ufz(ufr paramufr) {}
  
  private void a(stSimpleMetaPerson paramstSimpleMetaPerson, stSchema paramstSchema)
  {
    if (paramstSchema != null)
    {
      switch (paramstSchema.type)
      {
      default: 
        return;
      case 1: 
        paramstSimpleMetaPerson = paramstSchema.miniAppSchema;
        ujx.a().a(ufr.a(this.a), paramstSimpleMetaPerson);
        uqf.c("weishi", "miniShema is :" + paramstSimpleMetaPerson);
        ufr.a(this.a, 1000007, 2);
        return;
      case 2: 
        a(paramstSimpleMetaPerson, paramstSchema.schema);
        return;
      }
      paramstSchema = paramstSchema.H5Url;
      uqf.c("weishi", "h5Url is :" + paramstSchema);
      if ((ufr.a(this.a) instanceof Activity))
      {
        paramstSimpleMetaPerson = new Bundle();
        paramstSimpleMetaPerson.putBoolean("injectrecommend", false);
        paramstSchema = URLDecoder.decode(paramstSchema);
        QzoneLiveVideoInterface.forwardToBrowser((Activity)ufr.a(this.a), paramstSchema, 0, paramstSimpleMetaPerson, null);
        uqf.b("comment", "评论头像点击:" + paramstSchema);
      }
      for (;;)
      {
        ufr.a(this.a, 1000001, 2);
        return;
        uqf.c("comment", "context 不是Activity");
      }
    }
    a(paramstSimpleMetaPerson, paramstSimpleMetaPerson.schema_url);
  }
  
  private void a(stSimpleMetaPerson paramstSimpleMetaPerson, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (paramstSimpleMetaPerson = "weishi://profile?person_id=" + uqt.f();; paramstSimpleMetaPerson = paramString)
    {
      paramString = ufr.a(this.a, paramstSimpleMetaPerson, 13);
      if (zqd.a(ufr.a(this.a)))
      {
        uqh.a(ufr.a(this.a), "biz_src_jc_gzh_weishi", paramstSimpleMetaPerson, paramString.mScene, paramString.mLinkStrategyType, paramString.mEventId);
        ufr.a(this.a, 1000003, 2);
        return;
      }
      ugz.a(ufr.a(this.a), paramString, true);
      ufr.a(this.a, 1000002, 2);
      return;
    }
  }
  
  public void a(View paramView, int paramInt1, int paramInt2, Object paramObject)
  {
    WSDownloadParams localWSDownloadParams;
    switch (paramInt1)
    {
    default: 
      return;
    case 12: 
      paramView = (String)paramObject;
      paramObject = "weishi://profile?person_id=" + paramView;
      localWSDownloadParams = ufr.a(this.a, paramObject, 14);
      paramView = unr.c(this.a.a());
      if (TextUtils.equals(this.a.a(), "focus")) {
        paramView = paramView + ufr.a(this.a);
      }
      break;
    }
    for (;;)
    {
      if (zqd.a(ufr.a(this.a)))
      {
        uqh.a(ufr.a(this.a), "biz_src_jc_gzh_weishi", paramObject, localWSDownloadParams.mScene, localWSDownloadParams.mLinkStrategyType, localWSDownloadParams.mEventId);
        unr.a(this.a.a(), this.a.b(), paramView, 1000003, ufr.a(this.a));
        return;
      }
      ugz.a(ufr.a(this.a), localWSDownloadParams);
      unr.a(this.a.a(), this.a.b(), paramView, 1000002, ufr.a(this.a));
      return;
      ufr.a(this.a, 1000001, 6);
      return;
      paramView = ((stSimpleMetaPerson)paramObject).avatarSchema;
      a((stSimpleMetaPerson)paramObject, paramView);
      return;
      if (!(paramObject instanceof Object[])) {
        break;
      }
      paramObject = (Object[])paramObject;
      if ((paramObject.length <= 1) || (paramObject[0] == null) || (paramObject[1] == null) || (!(paramObject[0] instanceof stSimpleMetaComment)) || (!(paramObject[1] instanceof stSimpleMetaReply))) {
        break;
      }
      paramView = (stSimpleMetaReply)paramObject[1];
      paramObject = (stSimpleMetaComment)paramObject[0];
      if (paramView.poster != null)
      {
        paramObject = paramView.poster.avatarSchema;
        a(paramView.poster, paramObject);
        return;
      }
      a(paramView.poster, null);
      return;
      if (!(paramObject instanceof stSimpleMetaComment)) {
        break;
      }
      paramView = (stSimpleMetaComment)paramObject;
      ufr.a(this.a, paramView, null, 0);
      ufr.a(this.a, 1000001, 1);
      return;
      if (!(paramObject instanceof Object[])) {
        break;
      }
      paramObject = (Object[])paramObject;
      if ((paramObject.length <= 1) || (paramObject[0] == null) || (paramObject[1] == null) || (!(paramObject[0] instanceof stSimpleMetaComment)) || (!(paramObject[1] instanceof stSimpleMetaReply))) {
        break;
      }
      paramView = (stSimpleMetaComment)paramObject[0];
      paramObject = (stSimpleMetaReply)paramObject[1];
      ufr.a(this.a, paramView, paramObject, 0);
      ufr.a(this.a, 1000001, 1);
      return;
      if (!(paramObject instanceof stSimpleMetaComment)) {
        break;
      }
      paramView = (stSimpleMetaComment)paramObject;
      ufr.a(this.a).a(paramView);
      ufr.a(this.a, 1000001, 5);
      return;
      if (!(paramObject instanceof Object[])) {
        break;
      }
      paramView = (Object[])paramObject;
      if ((paramView.length <= 1) || (paramView[0] == null)) {
        break;
      }
      paramObject = (stSimpleMetaComment)paramView[0];
      paramInt1 = ufr.a(this.a).a(paramObject);
      if ((paramInt1 < 0) || (paramView[1] == null)) {
        break;
      }
      int i = ((Integer)paramView[1]).intValue();
      this.a.jdField_a_of_type_AndroidWidgetListView.setSelectionFromTop(paramInt2, i * (paramInt1 * -1));
      return;
      if (!(paramObject instanceof stSimpleMetaComment)) {
        break;
      }
      paramView = (stSimpleMetaComment)paramObject;
      ufr.a(this.a, this.a.a().a(ufr.a(this.a), paramView));
      this.a.jdField_a_of_type_Boolean = true;
      uqf.c("comment", "3 mCommentListChanged:" + this.a.jdField_a_of_type_Boolean + ",clickPosition:" + paramInt2 + ", hashCode" + this.a.hashCode());
      paramObject = this.a;
      if (paramView.isDing == 0) {}
      for (paramInt1 = 1001002;; paramInt1 = 1001001)
      {
        ufr.a(paramObject, paramInt1, 3);
        if (!(ufr.a(this.a) instanceof WSFollowFragment)) {
          break;
        }
        paramInt1 = paramInt2 - 1;
        paramView = ((WSFollowFragment)ufr.a(this.a)).a().a().findViewHolderForAdapterPosition(ufr.b(this.a));
        if (!(paramView instanceof uhz)) {
          break;
        }
        paramView = (uhz)paramView;
        uqf.c("comment", "***getPosition():" + ufr.b(this.a) + ",realPosition:" + paramInt1);
        paramView.a(paramInt1);
        return;
      }
      if (!(paramObject instanceof Object[])) {
        break;
      }
      paramView = (Object[])paramObject;
      if ((paramView.length <= 1) || (paramView[0] == null) || (paramView[1] == null)) {
        break;
      }
      paramObject = (stSimpleMetaComment)paramView[0];
      this.a.a().a(ufr.a(this.a), paramObject, (stSimpleMetaReply)paramView[1]);
      this.a.jdField_a_of_type_Boolean = true;
      uqf.c("comment", "4 mCommentListChanged:" + this.a.jdField_a_of_type_Boolean + ", hashCode" + this.a.hashCode());
      ufr.a(this.a, 1000001, 3);
      return;
    }
  }
  
  public void b(View paramView, int paramInt1, int paramInt2, Object paramObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ufz
 * JD-Core Version:    0.7.0.1
 */