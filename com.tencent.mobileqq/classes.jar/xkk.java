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

public class xkk
  implements ycu
{
  private xkk(xkf paramxkf) {}
  
  public void P_()
  {
    int i = xkf.a(this.a).b();
    xkf.a(this.a).setSelectionFromBottom(i, 0);
  }
  
  public void a()
  {
    xkf.a(this.a).p();
  }
  
  public void a(CommentEntry paramCommentEntry)
  {
    yij localyij = (yij)wpm.a(11);
    woj localwoj = (woj)wpm.a(17);
    boolean bool = xkf.a(this.a).a();
    if ((!xkf.a(this.a).a(bool)) && (xkf.a(this.a).a(bool) == null))
    {
      CommentEntry localCommentEntry = ycq.a(xkf.a(this.a).a(bool) - xkf.a(this.a).a(bool).size());
      xkf.a(this.a).c(localCommentEntry, bool);
      xkf.a(this.a).a(localCommentEntry, bool);
    }
    xkf.a(this.a).a(paramCommentEntry, bool);
    yqp.b("Q.qqstory.player.CommentFloatDialog", "after add comment. mCommentCount = %d, mFanCommentCount = %d, mFanCommentCount = %d.", Integer.valueOf(xkf.a(this.a).a.mCommentCount), Integer.valueOf(xkf.a(this.a).a.mFanCommentCount), Integer.valueOf(xkf.a(this.a).a.mFriendCommentCount));
    int i;
    if (xkf.a(this.a).a.mDenyComment == 1)
    {
      i = 1;
      if (i != 0)
      {
        QQToast.a(BaseApplication.getContext(), 1, anni.a(2131700982), 0).a();
        paramCommentEntry.status = 2;
      }
      xkf.a(this.a).p();
      ThreadManager.getUIHandler().postDelayed(new CommentFloatDialog.OnCommentHelperCallback.1(this), 50L);
      xkf.a(this.a).a = ((CommentLikeFeedItem)localyij.a(xkf.a(this.a).a));
      if (!xkf.a(this.a).a()) {
        break label347;
      }
      if (!bool) {
        break label334;
      }
      paramCommentEntry.type = 4;
      paramCommentEntry.pbType = 1;
      label313:
      localwoj.a(paramCommentEntry);
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
      paramCommentEntry.pbType = xkf.a(this.a).a.getCommentLikeType();
      localwoj.b(paramCommentEntry);
    }
  }
  
  public void b(int paramInt)
  {
    boolean bool = xkf.a(this.a).a();
    Object localObject = xkf.a(this.a).a(bool);
    if ((paramInt < 0) || (paramInt >= ((List)localObject).size()))
    {
      yqp.d("Q.qqstory.player.CommentFloatDialog", "delete comment error , IndexOutOfBoundsException , need index = %d , size = %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(((List)localObject).size()) });
      return;
    }
    localObject = (CommentEntry)xkf.a(this.a).a(bool).get(paramInt);
    if (((CommentEntry)localObject).status != 0)
    {
      xkf.a(this.a).a((CommentEntry)localObject, bool);
      return;
    }
    if (!bgnt.d(this.a.getContext()))
    {
      QQToast.a(BaseApplication.getContext(), 1, anni.a(2131700983), 0).a();
      yqp.d("Q.qqstory.player.CommentFloatDialog", "delete comment failed. invalidate network.");
      return;
    }
    ((CommentEntry)localObject).status = 1;
    wlr.a((CommentEntry)localObject, new xkl(this, (CommentEntry)localObject, bool));
  }
  
  public void b(CommentEntry paramCommentEntry)
  {
    wmf.a(xkf.a(this.a).a, paramCommentEntry, xkf.c(this.a), xkf.a(this.a), new xkm(this));
  }
  
  public void c()
  {
    Object localObject = xkf.a(this.a).a("CommentFloatDialog");
    if (localObject != null) {
      ((zpn)localObject).a(false);
    }
    localObject = xkf.a(this.a).getLayoutParams();
    if (localObject == null) {
      localObject = new ViewGroup.LayoutParams(-1, this.a.getContext().getResources().getDimensionPixelOffset(2131298885));
    }
    for (;;)
    {
      xkf.a(this.a).setLayoutParams((ViewGroup.LayoutParams)localObject);
      return;
      ((ViewGroup.LayoutParams)localObject).height = this.a.getContext().getResources().getDimensionPixelOffset(2131298887);
    }
  }
  
  public void d()
  {
    boolean bool = false;
    Object localObject = xkf.a(this.a).a("CommentFloatDialog");
    if (localObject != null)
    {
      if (xkf.a(this.a) != null)
      {
        if (!xkf.a(this.a).a(xkf.a(this.a).a())) {
          bool = true;
        }
        ((zpn)localObject).a(bool);
      }
    }
    else
    {
      localObject = xkf.a(this.a).getLayoutParams();
      if (localObject != null) {
        break label119;
      }
      localObject = new ViewGroup.LayoutParams(-1, this.a.getContext().getResources().getDimensionPixelOffset(2131298885));
    }
    for (;;)
    {
      xkf.a(this.a).setLayoutParams((ViewGroup.LayoutParams)localObject);
      return;
      ((zpn)localObject).a(false);
      break;
      label119:
      ((ViewGroup.LayoutParams)localObject).height = this.a.getContext().getResources().getDimensionPixelOffset(2131298885);
    }
  }
  
  public void g_(int paramInt)
  {
    xkf.a(this.a).setSelectionFromBottom(xkf.a(this.a).a() + paramInt, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xkk
 * JD-Core Version:    0.7.0.1
 */