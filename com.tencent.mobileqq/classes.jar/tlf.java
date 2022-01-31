import android.content.Context;
import android.content.res.Resources;
import android.view.ViewGroup.LayoutParams;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.biz.qqstory.playvideo.floatdialog.CommentFloatDialog.OnCommentHelperCallback.1;
import com.tencent.biz.qqstory.playvideo.floatdialog.StoryPlayerCommentListView;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.List;
import mqq.os.MqqHandler;

public class tlf
  implements udp
{
  private tlf(tla paramtla) {}
  
  public void P_()
  {
    int i = tla.a(this.a).b();
    tla.a(this.a).setSelectionFromBottom(i, 0);
  }
  
  public void a()
  {
    tla.a(this.a).p();
  }
  
  public void a(CommentEntry paramCommentEntry)
  {
    uje localuje = (uje)sqg.a(11);
    spd localspd = (spd)sqg.a(17);
    boolean bool = tla.a(this.a).a();
    if ((!tla.a(this.a).a(bool)) && (tla.a(this.a).a(bool) == null))
    {
      CommentEntry localCommentEntry = udl.a(tla.a(this.a).a(bool) - tla.a(this.a).a(bool).size());
      tla.a(this.a).c(localCommentEntry, bool);
      tla.a(this.a).a(localCommentEntry, bool);
    }
    tla.a(this.a).a(paramCommentEntry, bool);
    urk.b("Q.qqstory.player.CommentFloatDialog", "after add comment. mCommentCount = %d, mFanCommentCount = %d, mFanCommentCount = %d.", Integer.valueOf(tla.a(this.a).a.mCommentCount), Integer.valueOf(tla.a(this.a).a.mFanCommentCount), Integer.valueOf(tla.a(this.a).a.mFriendCommentCount));
    int i;
    if (tla.a(this.a).a.mDenyComment == 1)
    {
      i = 1;
      if (i != 0)
      {
        bbmy.a(BaseApplication.getContext(), 1, ajjy.a(2131636383), 0).a();
        paramCommentEntry.status = 2;
      }
      tla.a(this.a).p();
      ThreadManager.getUIHandler().postDelayed(new CommentFloatDialog.OnCommentHelperCallback.1(this), 50L);
      tla.a(this.a).a = ((CommentLikeFeedItem)localuje.a(tla.a(this.a).a));
      if (!tla.a(this.a).a()) {
        break label347;
      }
      if (!bool) {
        break label334;
      }
      paramCommentEntry.type = 4;
      paramCommentEntry.pbType = 1;
      label313:
      localspd.a(paramCommentEntry);
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
      paramCommentEntry.pbType = tla.a(this.a).a.getCommentLikeType();
      localspd.b(paramCommentEntry);
    }
  }
  
  public void b(int paramInt)
  {
    boolean bool = tla.a(this.a).a();
    Object localObject = tla.a(this.a).a(bool);
    if ((paramInt < 0) || (paramInt >= ((List)localObject).size()))
    {
      urk.d("Q.qqstory.player.CommentFloatDialog", "delete comment error , IndexOutOfBoundsException , need index = %d , size = %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(((List)localObject).size()) });
      return;
    }
    localObject = (CommentEntry)tla.a(this.a).a(bool).get(paramInt);
    if (((CommentEntry)localObject).status != 0)
    {
      tla.a(this.a).a((CommentEntry)localObject, bool);
      return;
    }
    if (!badq.d(this.a.getContext()))
    {
      bbmy.a(BaseApplication.getContext(), 1, ajjy.a(2131636384), 0).a();
      urk.d("Q.qqstory.player.CommentFloatDialog", "delete comment failed. invalidate network.");
      return;
    }
    ((CommentEntry)localObject).status = 1;
    sml.a((CommentEntry)localObject, new tlg(this, (CommentEntry)localObject, bool));
  }
  
  public void b(CommentEntry paramCommentEntry)
  {
    smz.a(tla.a(this.a).a, paramCommentEntry, tla.c(this.a), tla.a(this.a), new tlh(this));
  }
  
  public void c()
  {
    Object localObject = tla.a(this.a).a("CommentFloatDialog");
    if (localObject != null) {
      ((vqi)localObject).a(false);
    }
    localObject = tla.a(this.a).getLayoutParams();
    if (localObject == null) {
      localObject = new ViewGroup.LayoutParams(-1, this.a.getContext().getResources().getDimensionPixelOffset(2131167675));
    }
    for (;;)
    {
      tla.a(this.a).setLayoutParams((ViewGroup.LayoutParams)localObject);
      return;
      ((ViewGroup.LayoutParams)localObject).height = this.a.getContext().getResources().getDimensionPixelOffset(2131167677);
    }
  }
  
  public void d()
  {
    boolean bool = false;
    Object localObject = tla.a(this.a).a("CommentFloatDialog");
    if (localObject != null)
    {
      if (tla.a(this.a) != null)
      {
        if (!tla.a(this.a).a(tla.a(this.a).a())) {
          bool = true;
        }
        ((vqi)localObject).a(bool);
      }
    }
    else
    {
      localObject = tla.a(this.a).getLayoutParams();
      if (localObject != null) {
        break label119;
      }
      localObject = new ViewGroup.LayoutParams(-1, this.a.getContext().getResources().getDimensionPixelOffset(2131167675));
    }
    for (;;)
    {
      tla.a(this.a).setLayoutParams((ViewGroup.LayoutParams)localObject);
      return;
      ((vqi)localObject).a(false);
      break;
      label119:
      ((ViewGroup.LayoutParams)localObject).height = this.a.getContext().getResources().getDimensionPixelOffset(2131167675);
    }
  }
  
  public void f_(int paramInt)
  {
    tla.a(this.a).setSelectionFromBottom(tla.a(this.a).a() + paramInt, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tlf
 * JD-Core Version:    0.7.0.1
 */