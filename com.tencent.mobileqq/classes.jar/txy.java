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

public class txy
  implements uqi
{
  private txy(txt paramtxt) {}
  
  public void N_()
  {
    int i = txt.a(this.a).b();
    txt.a(this.a).setSelectionFromBottom(i, 0);
  }
  
  public void a()
  {
    txt.a(this.a).p();
  }
  
  public void a(CommentEntry paramCommentEntry)
  {
    uvx localuvx = (uvx)tcz.a(11);
    tbw localtbw = (tbw)tcz.a(17);
    boolean bool = txt.a(this.a).a();
    if ((!txt.a(this.a).a(bool)) && (txt.a(this.a).a(bool) == null))
    {
      CommentEntry localCommentEntry = uqe.a(txt.a(this.a).a(bool) - txt.a(this.a).a(bool).size());
      txt.a(this.a).c(localCommentEntry, bool);
      txt.a(this.a).a(localCommentEntry, bool);
    }
    txt.a(this.a).a(paramCommentEntry, bool);
    ved.b("Q.qqstory.player.CommentFloatDialog", "after add comment. mCommentCount = %d, mFanCommentCount = %d, mFanCommentCount = %d.", Integer.valueOf(txt.a(this.a).a.mCommentCount), Integer.valueOf(txt.a(this.a).a.mFanCommentCount), Integer.valueOf(txt.a(this.a).a.mFriendCommentCount));
    int i;
    if (txt.a(this.a).a.mDenyComment == 1)
    {
      i = 1;
      if (i != 0)
      {
        bcql.a(BaseApplication.getContext(), 1, ajya.a(2131702178), 0).a();
        paramCommentEntry.status = 2;
      }
      txt.a(this.a).p();
      ThreadManager.getUIHandler().postDelayed(new CommentFloatDialog.OnCommentHelperCallback.1(this), 50L);
      txt.a(this.a).a = ((CommentLikeFeedItem)localuvx.a(txt.a(this.a).a));
      if (!txt.a(this.a).a()) {
        break label347;
      }
      if (!bool) {
        break label334;
      }
      paramCommentEntry.type = 4;
      paramCommentEntry.pbType = 1;
      label313:
      localtbw.a(paramCommentEntry);
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
      paramCommentEntry.pbType = txt.a(this.a).a.getCommentLikeType();
      localtbw.b(paramCommentEntry);
    }
  }
  
  public void b(int paramInt)
  {
    boolean bool = txt.a(this.a).a();
    Object localObject = txt.a(this.a).a(bool);
    if ((paramInt < 0) || (paramInt >= ((List)localObject).size()))
    {
      ved.d("Q.qqstory.player.CommentFloatDialog", "delete comment error , IndexOutOfBoundsException , need index = %d , size = %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(((List)localObject).size()) });
      return;
    }
    localObject = (CommentEntry)txt.a(this.a).a(bool).get(paramInt);
    if (((CommentEntry)localObject).status != 0)
    {
      txt.a(this.a).a((CommentEntry)localObject, bool);
      return;
    }
    if (!bbfj.d(this.a.getContext()))
    {
      bcql.a(BaseApplication.getContext(), 1, ajya.a(2131702179), 0).a();
      ved.d("Q.qqstory.player.CommentFloatDialog", "delete comment failed. invalidate network.");
      return;
    }
    ((CommentEntry)localObject).status = 1;
    sze.a((CommentEntry)localObject, new txz(this, (CommentEntry)localObject, bool));
  }
  
  public void b(CommentEntry paramCommentEntry)
  {
    szs.a(txt.a(this.a).a, paramCommentEntry, txt.c(this.a), txt.a(this.a), new tya(this));
  }
  
  public void c()
  {
    Object localObject = txt.a(this.a).a("CommentFloatDialog");
    if (localObject != null) {
      ((wdb)localObject).a(false);
    }
    localObject = txt.a(this.a).getLayoutParams();
    if (localObject == null) {
      localObject = new ViewGroup.LayoutParams(-1, this.a.getContext().getResources().getDimensionPixelOffset(2131298774));
    }
    for (;;)
    {
      txt.a(this.a).setLayoutParams((ViewGroup.LayoutParams)localObject);
      return;
      ((ViewGroup.LayoutParams)localObject).height = this.a.getContext().getResources().getDimensionPixelOffset(2131298776);
    }
  }
  
  public void d()
  {
    boolean bool = false;
    Object localObject = txt.a(this.a).a("CommentFloatDialog");
    if (localObject != null)
    {
      if (txt.a(this.a) != null)
      {
        if (!txt.a(this.a).a(txt.a(this.a).a())) {
          bool = true;
        }
        ((wdb)localObject).a(bool);
      }
    }
    else
    {
      localObject = txt.a(this.a).getLayoutParams();
      if (localObject != null) {
        break label119;
      }
      localObject = new ViewGroup.LayoutParams(-1, this.a.getContext().getResources().getDimensionPixelOffset(2131298774));
    }
    for (;;)
    {
      txt.a(this.a).setLayoutParams((ViewGroup.LayoutParams)localObject);
      return;
      ((wdb)localObject).a(false);
      break;
      label119:
      ((ViewGroup.LayoutParams)localObject).height = this.a.getContext().getResources().getDimensionPixelOffset(2131298774);
    }
  }
  
  public void f_(int paramInt)
  {
    txt.a(this.a).setSelectionFromBottom(txt.a(this.a).a() + paramInt, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     txy
 * JD-Core Version:    0.7.0.1
 */