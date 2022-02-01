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

public class xel
  implements xwv
{
  private xel(xeg paramxeg) {}
  
  public void L_()
  {
    int i = xeg.a(this.a).b();
    xeg.a(this.a).setSelectionFromBottom(i, 0);
  }
  
  public void a()
  {
    xeg.a(this.a).p();
  }
  
  public void a(CommentEntry paramCommentEntry)
  {
    yck localyck = (yck)wjs.a(11);
    wip localwip = (wip)wjs.a(17);
    boolean bool = xeg.a(this.a).a();
    if ((!xeg.a(this.a).a(bool)) && (xeg.a(this.a).a(bool) == null))
    {
      CommentEntry localCommentEntry = xwr.a(xeg.a(this.a).a(bool) - xeg.a(this.a).a(bool).size());
      xeg.a(this.a).c(localCommentEntry, bool);
      xeg.a(this.a).a(localCommentEntry, bool);
    }
    xeg.a(this.a).a(paramCommentEntry, bool);
    ykq.b("Q.qqstory.player.CommentFloatDialog", "after add comment. mCommentCount = %d, mFanCommentCount = %d, mFanCommentCount = %d.", Integer.valueOf(xeg.a(this.a).a.mCommentCount), Integer.valueOf(xeg.a(this.a).a.mFanCommentCount), Integer.valueOf(xeg.a(this.a).a.mFriendCommentCount));
    int i;
    if (xeg.a(this.a).a.mDenyComment == 1)
    {
      i = 1;
      if (i != 0)
      {
        QQToast.a(BaseApplication.getContext(), 1, anvx.a(2131701675), 0).a();
        paramCommentEntry.status = 2;
      }
      xeg.a(this.a).p();
      ThreadManager.getUIHandler().postDelayed(new CommentFloatDialog.OnCommentHelperCallback.1(this), 50L);
      xeg.a(this.a).a = ((CommentLikeFeedItem)localyck.a(xeg.a(this.a).a));
      if (!xeg.a(this.a).a()) {
        break label347;
      }
      if (!bool) {
        break label334;
      }
      paramCommentEntry.type = 4;
      paramCommentEntry.pbType = 1;
      label313:
      localwip.a(paramCommentEntry);
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
      paramCommentEntry.pbType = xeg.a(this.a).a.getCommentLikeType();
      localwip.b(paramCommentEntry);
    }
  }
  
  public void b(int paramInt)
  {
    boolean bool = xeg.a(this.a).a();
    Object localObject = xeg.a(this.a).a(bool);
    if ((paramInt < 0) || (paramInt >= ((List)localObject).size()))
    {
      ykq.d("Q.qqstory.player.CommentFloatDialog", "delete comment error , IndexOutOfBoundsException , need index = %d , size = %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(((List)localObject).size()) });
      return;
    }
    localObject = (CommentEntry)xeg.a(this.a).a(bool).get(paramInt);
    if (((CommentEntry)localObject).status != 0)
    {
      xeg.a(this.a).a((CommentEntry)localObject, bool);
      return;
    }
    if (!NetworkUtil.isNetSupport(this.a.getContext()))
    {
      QQToast.a(BaseApplication.getContext(), 1, anvx.a(2131701676), 0).a();
      ykq.d("Q.qqstory.player.CommentFloatDialog", "delete comment failed. invalidate network.");
      return;
    }
    ((CommentEntry)localObject).status = 1;
    wfy.a((CommentEntry)localObject, new xem(this, (CommentEntry)localObject, bool));
  }
  
  public void b(CommentEntry paramCommentEntry)
  {
    wgm.a(xeg.a(this.a).a, paramCommentEntry, xeg.c(this.a), xeg.a(this.a), new xen(this));
  }
  
  public void c()
  {
    Object localObject = xeg.a(this.a).a("CommentFloatDialog");
    if (localObject != null) {
      ((zhm)localObject).a(false);
    }
    localObject = xeg.a(this.a).getLayoutParams();
    if (localObject == null) {
      localObject = new ViewGroup.LayoutParams(-1, this.a.getContext().getResources().getDimensionPixelOffset(2131298967));
    }
    for (;;)
    {
      xeg.a(this.a).setLayoutParams((ViewGroup.LayoutParams)localObject);
      return;
      ((ViewGroup.LayoutParams)localObject).height = this.a.getContext().getResources().getDimensionPixelOffset(2131298969);
    }
  }
  
  public void d()
  {
    boolean bool = false;
    Object localObject = xeg.a(this.a).a("CommentFloatDialog");
    if (localObject != null)
    {
      if (xeg.a(this.a) != null)
      {
        if (!xeg.a(this.a).a(xeg.a(this.a).a())) {
          bool = true;
        }
        ((zhm)localObject).a(bool);
      }
    }
    else
    {
      localObject = xeg.a(this.a).getLayoutParams();
      if (localObject != null) {
        break label119;
      }
      localObject = new ViewGroup.LayoutParams(-1, this.a.getContext().getResources().getDimensionPixelOffset(2131298967));
    }
    for (;;)
    {
      xeg.a(this.a).setLayoutParams((ViewGroup.LayoutParams)localObject);
      return;
      ((zhm)localObject).a(false);
      break;
      label119:
      ((ViewGroup.LayoutParams)localObject).height = this.a.getContext().getResources().getDimensionPixelOffset(2131298967);
    }
  }
  
  public void h_(int paramInt)
  {
    xeg.a(this.a).setSelectionFromBottom(xeg.a(this.a).a() + paramInt, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xel
 * JD-Core Version:    0.7.0.1
 */