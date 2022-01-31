import android.content.Context;
import android.content.res.Resources;
import android.view.ViewGroup.LayoutParams;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.biz.qqstory.playvideo.floatdialog.CommentFloatDialog.OnCommentHelperCallback.1;
import com.tencent.biz.qqstory.playvideo.floatdialog.StoryPlayerCommentListView;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.List;
import mqq.os.MqqHandler;

public class vmq
  implements wfa
{
  private vmq(vml paramvml) {}
  
  public void V_()
  {
    int i = vml.a(this.a).b();
    vml.a(this.a).setSelectionFromBottom(i, 0);
  }
  
  public void a()
  {
    vml.a(this.a).p();
  }
  
  public void a(CommentEntry paramCommentEntry)
  {
    wkp localwkp = (wkp)urr.a(11);
    uqo localuqo = (uqo)urr.a(17);
    boolean bool = vml.a(this.a).a();
    if ((!vml.a(this.a).a(bool)) && (vml.a(this.a).a(bool) == null))
    {
      CommentEntry localCommentEntry = wew.a(vml.a(this.a).a(bool) - vml.a(this.a).a(bool).size());
      vml.a(this.a).c(localCommentEntry, bool);
      vml.a(this.a).a(localCommentEntry, bool);
    }
    vml.a(this.a).a(paramCommentEntry, bool);
    wsv.b("Q.qqstory.player.CommentFloatDialog", "after add comment. mCommentCount = %d, mFanCommentCount = %d, mFanCommentCount = %d.", Integer.valueOf(vml.a(this.a).a.mCommentCount), Integer.valueOf(vml.a(this.a).a.mFanCommentCount), Integer.valueOf(vml.a(this.a).a.mFriendCommentCount));
    int i;
    if (vml.a(this.a).a.mDenyComment == 1)
    {
      i = 1;
      if (i != 0)
      {
        QQToast.a(BaseApplication.getContext(), 1, alpo.a(2131702550), 0).a();
        paramCommentEntry.status = 2;
      }
      vml.a(this.a).p();
      ThreadManager.getUIHandler().postDelayed(new CommentFloatDialog.OnCommentHelperCallback.1(this), 50L);
      vml.a(this.a).a = ((CommentLikeFeedItem)localwkp.a(vml.a(this.a).a));
      if (!vml.a(this.a).a()) {
        break label347;
      }
      if (!bool) {
        break label334;
      }
      paramCommentEntry.type = 4;
      paramCommentEntry.pbType = 1;
      label313:
      localuqo.a(paramCommentEntry);
    }
    for (;;)
    {
      if (i == 0) {
        b(paramCommentEntry);
      }
      return;
      i = 0;
      break;
      label334:
      paramCommentEntry.type = 3;
      paramCommentEntry.pbType = 0;
      break label313;
      label347:
      paramCommentEntry.pbType = vml.a(this.a).a.getCommentLikeType();
      localuqo.b(paramCommentEntry);
    }
  }
  
  public void b(int paramInt)
  {
    boolean bool = vml.a(this.a).a();
    Object localObject = vml.a(this.a).a(bool);
    if ((paramInt < 0) || (paramInt >= ((List)localObject).size()))
    {
      wsv.d("Q.qqstory.player.CommentFloatDialog", "delete comment error , IndexOutOfBoundsException , need index = %d , size = %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(((List)localObject).size()) });
      return;
    }
    localObject = (CommentEntry)vml.a(this.a).a(bool).get(paramInt);
    if (((CommentEntry)localObject).status != 0)
    {
      vml.a(this.a).a((CommentEntry)localObject, bool);
      return;
    }
    if (!bdee.d(this.a.getContext()))
    {
      QQToast.a(BaseApplication.getContext(), 1, alpo.a(2131702551), 0).a();
      wsv.d("Q.qqstory.player.CommentFloatDialog", "delete comment failed. invalidate network.");
      return;
    }
    ((CommentEntry)localObject).status = 1;
    unw.a((CommentEntry)localObject, new vmr(this, (CommentEntry)localObject, bool));
  }
  
  public void b(CommentEntry paramCommentEntry)
  {
    uok.a(vml.a(this.a).a, paramCommentEntry, vml.c(this.a), vml.a(this.a), new vms(this));
  }
  
  public void c()
  {
    Object localObject = vml.a(this.a).a("CommentFloatDialog");
    if (localObject != null) {
      ((xrt)localObject).a(false);
    }
    localObject = vml.a(this.a).getLayoutParams();
    if (localObject == null) {
      localObject = new ViewGroup.LayoutParams(-1, this.a.getContext().getResources().getDimensionPixelOffset(2131298802));
    }
    for (;;)
    {
      vml.a(this.a).setLayoutParams((ViewGroup.LayoutParams)localObject);
      return;
      ((ViewGroup.LayoutParams)localObject).height = this.a.getContext().getResources().getDimensionPixelOffset(2131298804);
    }
  }
  
  public void d()
  {
    boolean bool = false;
    Object localObject = vml.a(this.a).a("CommentFloatDialog");
    if (localObject != null)
    {
      if (vml.a(this.a) != null)
      {
        if (!vml.a(this.a).a(vml.a(this.a).a())) {
          bool = true;
        }
        ((xrt)localObject).a(bool);
      }
    }
    else
    {
      localObject = vml.a(this.a).getLayoutParams();
      if (localObject != null) {
        break label119;
      }
      localObject = new ViewGroup.LayoutParams(-1, this.a.getContext().getResources().getDimensionPixelOffset(2131298802));
    }
    for (;;)
    {
      vml.a(this.a).setLayoutParams((ViewGroup.LayoutParams)localObject);
      return;
      ((xrt)localObject).a(false);
      break;
      label119:
      ((ViewGroup.LayoutParams)localObject).height = this.a.getContext().getResources().getDimensionPixelOffset(2131298802);
    }
  }
  
  public void h_(int paramInt)
  {
    vml.a(this.a).setSelectionFromBottom(vml.a(this.a).a() + paramInt, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vmq
 * JD-Core Version:    0.7.0.1
 */