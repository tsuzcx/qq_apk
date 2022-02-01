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

public class xof
  implements ygp
{
  private xof(xoa paramxoa) {}
  
  public void P_()
  {
    int i = xoa.a(this.a).b();
    xoa.a(this.a).setSelectionFromBottom(i, 0);
  }
  
  public void a()
  {
    xoa.a(this.a).p();
  }
  
  public void a(CommentEntry paramCommentEntry)
  {
    yme localyme = (yme)wth.a(11);
    wse localwse = (wse)wth.a(17);
    boolean bool = xoa.a(this.a).a();
    if ((!xoa.a(this.a).a(bool)) && (xoa.a(this.a).a(bool) == null))
    {
      CommentEntry localCommentEntry = ygl.a(xoa.a(this.a).a(bool) - xoa.a(this.a).a(bool).size());
      xoa.a(this.a).c(localCommentEntry, bool);
      xoa.a(this.a).a(localCommentEntry, bool);
    }
    xoa.a(this.a).a(paramCommentEntry, bool);
    yuk.b("Q.qqstory.player.CommentFloatDialog", "after add comment. mCommentCount = %d, mFanCommentCount = %d, mFanCommentCount = %d.", Integer.valueOf(xoa.a(this.a).a.mCommentCount), Integer.valueOf(xoa.a(this.a).a.mFanCommentCount), Integer.valueOf(xoa.a(this.a).a.mFriendCommentCount));
    int i;
    if (xoa.a(this.a).a.mDenyComment == 1)
    {
      i = 1;
      if (i != 0)
      {
        QQToast.a(BaseApplication.getContext(), 1, anzj.a(2131701089), 0).a();
        paramCommentEntry.status = 2;
      }
      xoa.a(this.a).p();
      ThreadManager.getUIHandler().postDelayed(new CommentFloatDialog.OnCommentHelperCallback.1(this), 50L);
      xoa.a(this.a).a = ((CommentLikeFeedItem)localyme.a(xoa.a(this.a).a));
      if (!xoa.a(this.a).a()) {
        break label347;
      }
      if (!bool) {
        break label334;
      }
      paramCommentEntry.type = 4;
      paramCommentEntry.pbType = 1;
      label313:
      localwse.a(paramCommentEntry);
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
      paramCommentEntry.pbType = xoa.a(this.a).a.getCommentLikeType();
      localwse.b(paramCommentEntry);
    }
  }
  
  public void b(int paramInt)
  {
    boolean bool = xoa.a(this.a).a();
    Object localObject = xoa.a(this.a).a(bool);
    if ((paramInt < 0) || (paramInt >= ((List)localObject).size()))
    {
      yuk.d("Q.qqstory.player.CommentFloatDialog", "delete comment error , IndexOutOfBoundsException , need index = %d , size = %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(((List)localObject).size()) });
      return;
    }
    localObject = (CommentEntry)xoa.a(this.a).a(bool).get(paramInt);
    if (((CommentEntry)localObject).status != 0)
    {
      xoa.a(this.a).a((CommentEntry)localObject, bool);
      return;
    }
    if (!bhnv.d(this.a.getContext()))
    {
      QQToast.a(BaseApplication.getContext(), 1, anzj.a(2131701090), 0).a();
      yuk.d("Q.qqstory.player.CommentFloatDialog", "delete comment failed. invalidate network.");
      return;
    }
    ((CommentEntry)localObject).status = 1;
    wpm.a((CommentEntry)localObject, new xog(this, (CommentEntry)localObject, bool));
  }
  
  public void b(CommentEntry paramCommentEntry)
  {
    wqa.a(xoa.a(this.a).a, paramCommentEntry, xoa.c(this.a), xoa.a(this.a), new xoh(this));
  }
  
  public void c()
  {
    Object localObject = xoa.a(this.a).a("CommentFloatDialog");
    if (localObject != null) {
      ((zti)localObject).a(false);
    }
    localObject = xoa.a(this.a).getLayoutParams();
    if (localObject == null) {
      localObject = new ViewGroup.LayoutParams(-1, this.a.getContext().getResources().getDimensionPixelOffset(2131298898));
    }
    for (;;)
    {
      xoa.a(this.a).setLayoutParams((ViewGroup.LayoutParams)localObject);
      return;
      ((ViewGroup.LayoutParams)localObject).height = this.a.getContext().getResources().getDimensionPixelOffset(2131298900);
    }
  }
  
  public void d()
  {
    boolean bool = false;
    Object localObject = xoa.a(this.a).a("CommentFloatDialog");
    if (localObject != null)
    {
      if (xoa.a(this.a) != null)
      {
        if (!xoa.a(this.a).a(xoa.a(this.a).a())) {
          bool = true;
        }
        ((zti)localObject).a(bool);
      }
    }
    else
    {
      localObject = xoa.a(this.a).getLayoutParams();
      if (localObject != null) {
        break label119;
      }
      localObject = new ViewGroup.LayoutParams(-1, this.a.getContext().getResources().getDimensionPixelOffset(2131298898));
    }
    for (;;)
    {
      xoa.a(this.a).setLayoutParams((ViewGroup.LayoutParams)localObject);
      return;
      ((zti)localObject).a(false);
      break;
      label119:
      ((ViewGroup.LayoutParams)localObject).height = this.a.getContext().getResources().getDimensionPixelOffset(2131298898);
    }
  }
  
  public void g_(int paramInt)
  {
    xoa.a(this.a).setSelectionFromBottom(xoa.a(this.a).a() + paramInt, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xof
 * JD-Core Version:    0.7.0.1
 */