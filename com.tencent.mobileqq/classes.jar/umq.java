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

class umq
  implements zgz
{
  umq(umj paramumj) {}
  
  private void a(stSimpleMetaPerson paramstSimpleMetaPerson, stSchema paramstSchema, int paramInt)
  {
    if (paramstSchema != null)
    {
      switch (paramstSchema.type)
      {
      default: 
        return;
      case 1: 
        paramstSimpleMetaPerson = paramstSchema.miniAppSchema;
        uqs.a().a(umj.a(this.a), paramstSimpleMetaPerson);
        uya.c("weishi", "miniShema is :" + paramstSimpleMetaPerson);
        umj.a(this.a, 1000007, paramInt);
        return;
      case 2: 
        a(paramstSchema.schema, paramInt);
        return;
      }
      paramstSchema = paramstSchema.H5Url;
      uya.c("weishi", "h5Url is :" + paramstSchema);
      if ((umj.a(this.a) instanceof Activity))
      {
        paramstSimpleMetaPerson = new Bundle();
        paramstSimpleMetaPerson.putBoolean("injectrecommend", false);
        paramstSchema = URLDecoder.decode(paramstSchema);
        QzoneLiveVideoInterface.forwardToBrowser((Activity)umj.a(this.a), paramstSchema, 0, paramstSimpleMetaPerson, null);
        uya.b("comment", "评论头像点击:" + paramstSchema);
      }
      for (;;)
      {
        umj.a(this.a, 1000001, paramInt);
        return;
        uya.c("comment", "context 不是Activity");
      }
    }
    paramstSchema = "";
    if (paramstSimpleMetaPerson != null) {
      paramstSchema = paramstSimpleMetaPerson.schema_url;
    }
    a(paramstSchema, paramInt);
  }
  
  private void a(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {
      paramString = "weishi://profile?person_id=" + uyo.f();
    }
    for (;;)
    {
      WSDownloadParams localWSDownloadParams = umj.a(this.a, paramString, 13);
      if (yqu.a(umj.a(this.a)))
      {
        uyc.a(umj.a(this.a), "biz_src_jc_gzh_weishi", paramString, localWSDownloadParams.mScene, localWSDownloadParams.mLinkStrategyType, localWSDownloadParams.mEventId);
        umj.a(this.a, 1000003, paramInt);
        return;
      }
      unq.a(umj.a(this.a), localWSDownloadParams, true);
      umj.a(this.a, 1000002, paramInt);
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
      paramObject = "weishi://feed?feed_id=" + paramView;
      localWSDownloadParams = umj.a(this.a, paramObject, 14);
      paramView = uvl.c(this.a.a());
      if (TextUtils.equals(this.a.a(), "focus")) {
        paramView = paramView + umj.a(this.a);
      }
      break;
    }
    for (;;)
    {
      if (yqu.a(umj.a(this.a)))
      {
        uyc.a(umj.a(this.a), "biz_src_jc_gzh_weishi", paramObject, localWSDownloadParams.mScene, localWSDownloadParams.mLinkStrategyType, localWSDownloadParams.mEventId);
        uvl.a(this.a.a(), this.a.b(), paramView, 1000003, umj.a(this.a));
        return;
      }
      unq.a(umj.a(this.a), localWSDownloadParams);
      uvl.a(this.a.a(), this.a.b(), paramView, 1000002, umj.a(this.a));
      return;
      umj.a(this.a, 1000001, 6);
      if (!(paramObject instanceof stSimpleMetaPerson)) {
        break;
      }
      a((stSimpleMetaPerson)paramObject, ((stSimpleMetaPerson)paramObject).avatarSchema, 6);
      return;
      paramView = ((stSimpleMetaPerson)paramObject).avatarSchema;
      a((stSimpleMetaPerson)paramObject, paramView, 2);
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
        a(paramView.poster, paramObject, 2);
        return;
      }
      a(null, null, 2);
      return;
      if (!(paramObject instanceof stSimpleMetaComment)) {
        break;
      }
      paramView = (stSimpleMetaComment)paramObject;
      umj.a(this.a, paramView, null, 0);
      umj.a(this.a, 1000001, 1);
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
      umj.a(this.a, paramView, paramObject, 0);
      umj.a(this.a, 1000001, 1);
      return;
      if (!(paramObject instanceof stSimpleMetaComment)) {
        break;
      }
      paramView = (stSimpleMetaComment)paramObject;
      umj.a(this.a).a(paramView);
      umj.a(this.a, 1000001, 5);
      return;
      if (!(paramObject instanceof Object[])) {
        break;
      }
      paramView = (Object[])paramObject;
      if ((paramView.length <= 1) || (paramView[0] == null)) {
        break;
      }
      paramObject = (stSimpleMetaComment)paramView[0];
      paramInt1 = umj.a(this.a).a(paramObject);
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
      this.a.a().a(umj.a(this.a), paramView);
      this.a.jdField_a_of_type_Boolean = true;
      uya.c("comment", "3 mCommentListChanged:" + this.a.jdField_a_of_type_Boolean + ",clickPosition:" + paramInt2 + ", hashCode" + this.a.hashCode());
      paramObject = this.a;
      if (paramView.isDing == 0) {}
      for (paramInt1 = 1001002;; paramInt1 = 1001001)
      {
        umj.a(paramObject, paramInt1, 3);
        if (!(umj.a(this.a) instanceof WSFollowFragment)) {
          break;
        }
        paramInt1 = paramInt2 - 1;
        paramView = ((WSFollowFragment)umj.a(this.a)).a().a().findViewHolderForAdapterPosition(umj.b(this.a));
        if (!(paramView instanceof uou)) {
          break;
        }
        paramView = (uou)paramView;
        uya.c("comment", "***getPosition():" + umj.b(this.a) + ",realPosition:" + paramInt1);
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
      this.a.a().a(umj.a(this.a), paramObject, (stSimpleMetaReply)paramView[1]);
      this.a.jdField_a_of_type_Boolean = true;
      uya.c("comment", "4 mCommentListChanged:" + this.a.jdField_a_of_type_Boolean + ", hashCode" + this.a.hashCode());
      umj.a(this.a, 1000001, 3);
      return;
    }
  }
  
  public void b(View paramView, int paramInt1, int paramInt2, Object paramObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     umq
 * JD-Core Version:    0.7.0.1
 */