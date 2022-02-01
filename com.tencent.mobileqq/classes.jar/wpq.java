import android.content.Context;
import android.content.res.Resources;
import android.view.ViewGroup.LayoutParams;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.biz.qqstory.playvideo.floatdialog.CommentFloatDialog.OnCommentHelperCallback.1;
import com.tencent.biz.qqstory.playvideo.floatdialog.StoryPlayerCommentListView;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.List;
import mqq.os.MqqHandler;

public class wpq
  implements xia
{
  private wpq(wpl paramwpl) {}
  
  public void J_()
  {
    int i = wpl.a(this.a).b();
    wpl.a(this.a).setSelectionFromBottom(i, 0);
  }
  
  public void a()
  {
    wpl.a(this.a).p();
  }
  
  public void a(CommentEntry paramCommentEntry)
  {
    xnp localxnp = (xnp)vux.a(11);
    vtu localvtu = (vtu)vux.a(17);
    boolean bool = wpl.a(this.a).a();
    if ((!wpl.a(this.a).a(bool)) && (wpl.a(this.a).a(bool) == null))
    {
      CommentEntry localCommentEntry = xhw.a(wpl.a(this.a).a(bool) - wpl.a(this.a).a(bool).size());
      wpl.a(this.a).c(localCommentEntry, bool);
      wpl.a(this.a).a(localCommentEntry, bool);
    }
    wpl.a(this.a).a(paramCommentEntry, bool);
    xvv.b("Q.qqstory.player.CommentFloatDialog", "after add comment. mCommentCount = %d, mFanCommentCount = %d, mFanCommentCount = %d.", Integer.valueOf(wpl.a(this.a).a.mCommentCount), Integer.valueOf(wpl.a(this.a).a.mFanCommentCount), Integer.valueOf(wpl.a(this.a).a.mFriendCommentCount));
    int i;
    if (wpl.a(this.a).a.mDenyComment == 1)
    {
      i = 1;
      if (i != 0)
      {
        QQToast.a(BaseApplication.getContext(), 1, amtj.a(2131701324), 0).a();
        paramCommentEntry.status = 2;
      }
      wpl.a(this.a).p();
      ThreadManager.getUIHandler().postDelayed(new CommentFloatDialog.OnCommentHelperCallback.1(this), 50L);
      wpl.a(this.a).a = ((CommentLikeFeedItem)localxnp.a(wpl.a(this.a).a));
      if (!wpl.a(this.a).a()) {
        break label347;
      }
      if (!bool) {
        break label334;
      }
      paramCommentEntry.type = 4;
      paramCommentEntry.pbType = 1;
      label313:
      localvtu.a(paramCommentEntry);
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
      paramCommentEntry.pbType = wpl.a(this.a).a.getCommentLikeType();
      localvtu.b(paramCommentEntry);
    }
  }
  
  public void b(int paramInt)
  {
    boolean bool = wpl.a(this.a).a();
    Object localObject = wpl.a(this.a).a(bool);
    if ((paramInt < 0) || (paramInt >= ((List)localObject).size()))
    {
      xvv.d("Q.qqstory.player.CommentFloatDialog", "delete comment error , IndexOutOfBoundsException , need index = %d , size = %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(((List)localObject).size()) });
      return;
    }
    localObject = (CommentEntry)wpl.a(this.a).a(bool).get(paramInt);
    if (((CommentEntry)localObject).status != 0)
    {
      wpl.a(this.a).a((CommentEntry)localObject, bool);
      return;
    }
    if (!NetworkUtil.isNetSupport(this.a.getContext()))
    {
      QQToast.a(BaseApplication.getContext(), 1, amtj.a(2131701325), 0).a();
      xvv.d("Q.qqstory.player.CommentFloatDialog", "delete comment failed. invalidate network.");
      return;
    }
    ((CommentEntry)localObject).status = 1;
    vrd.a((CommentEntry)localObject, new wpr(this, (CommentEntry)localObject, bool));
  }
  
  public void b(CommentEntry paramCommentEntry)
  {
    vrr.a(wpl.a(this.a).a, paramCommentEntry, wpl.c(this.a), wpl.a(this.a), new wps(this));
  }
  
  public void c()
  {
    Object localObject = wpl.a(this.a).a("CommentFloatDialog");
    if (localObject != null) {
      ((yst)localObject).a(false);
    }
    localObject = wpl.a(this.a).getLayoutParams();
    if (localObject == null) {
      localObject = new ViewGroup.LayoutParams(-1, this.a.getContext().getResources().getDimensionPixelOffset(2131298963));
    }
    for (;;)
    {
      wpl.a(this.a).setLayoutParams((ViewGroup.LayoutParams)localObject);
      return;
      ((ViewGroup.LayoutParams)localObject).height = this.a.getContext().getResources().getDimensionPixelOffset(2131298965);
    }
  }
  
  public void d()
  {
    boolean bool = false;
    Object localObject = wpl.a(this.a).a("CommentFloatDialog");
    if (localObject != null)
    {
      if (wpl.a(this.a) != null)
      {
        if (!wpl.a(this.a).a(wpl.a(this.a).a())) {
          bool = true;
        }
        ((yst)localObject).a(bool);
      }
    }
    else
    {
      localObject = wpl.a(this.a).getLayoutParams();
      if (localObject != null) {
        break label119;
      }
      localObject = new ViewGroup.LayoutParams(-1, this.a.getContext().getResources().getDimensionPixelOffset(2131298963));
    }
    for (;;)
    {
      wpl.a(this.a).setLayoutParams((ViewGroup.LayoutParams)localObject);
      return;
      ((yst)localObject).a(false);
      break;
      label119:
      ((ViewGroup.LayoutParams)localObject).height = this.a.getContext().getResources().getDimensionPixelOffset(2131298963);
    }
  }
  
  public void g_(int paramInt)
  {
    wpl.a(this.a).setSelectionFromBottom(wpl.a(this.a).a() + paramInt, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wpq
 * JD-Core Version:    0.7.0.1
 */