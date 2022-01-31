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

public class tyb
  implements uql
{
  private tyb(txw paramtxw) {}
  
  public void N_()
  {
    int i = txw.a(this.a).b();
    txw.a(this.a).setSelectionFromBottom(i, 0);
  }
  
  public void a()
  {
    txw.a(this.a).p();
  }
  
  public void a(CommentEntry paramCommentEntry)
  {
    uwa localuwa = (uwa)tdc.a(11);
    tbz localtbz = (tbz)tdc.a(17);
    boolean bool = txw.a(this.a).a();
    if ((!txw.a(this.a).a(bool)) && (txw.a(this.a).a(bool) == null))
    {
      CommentEntry localCommentEntry = uqh.a(txw.a(this.a).a(bool) - txw.a(this.a).a(bool).size());
      txw.a(this.a).c(localCommentEntry, bool);
      txw.a(this.a).a(localCommentEntry, bool);
    }
    txw.a(this.a).a(paramCommentEntry, bool);
    veg.b("Q.qqstory.player.CommentFloatDialog", "after add comment. mCommentCount = %d, mFanCommentCount = %d, mFanCommentCount = %d.", Integer.valueOf(txw.a(this.a).a.mCommentCount), Integer.valueOf(txw.a(this.a).a.mFanCommentCount), Integer.valueOf(txw.a(this.a).a.mFriendCommentCount));
    int i;
    if (txw.a(this.a).a.mDenyComment == 1)
    {
      i = 1;
      if (i != 0)
      {
        bcpw.a(BaseApplication.getContext(), 1, ajyc.a(2131702167), 0).a();
        paramCommentEntry.status = 2;
      }
      txw.a(this.a).p();
      ThreadManager.getUIHandler().postDelayed(new CommentFloatDialog.OnCommentHelperCallback.1(this), 50L);
      txw.a(this.a).a = ((CommentLikeFeedItem)localuwa.a(txw.a(this.a).a));
      if (!txw.a(this.a).a()) {
        break label347;
      }
      if (!bool) {
        break label334;
      }
      paramCommentEntry.type = 4;
      paramCommentEntry.pbType = 1;
      label313:
      localtbz.a(paramCommentEntry);
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
      paramCommentEntry.pbType = txw.a(this.a).a.getCommentLikeType();
      localtbz.b(paramCommentEntry);
    }
  }
  
  public void b(int paramInt)
  {
    boolean bool = txw.a(this.a).a();
    Object localObject = txw.a(this.a).a(bool);
    if ((paramInt < 0) || (paramInt >= ((List)localObject).size()))
    {
      veg.d("Q.qqstory.player.CommentFloatDialog", "delete comment error , IndexOutOfBoundsException , need index = %d , size = %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(((List)localObject).size()) });
      return;
    }
    localObject = (CommentEntry)txw.a(this.a).a(bool).get(paramInt);
    if (((CommentEntry)localObject).status != 0)
    {
      txw.a(this.a).a((CommentEntry)localObject, bool);
      return;
    }
    if (!bbev.d(this.a.getContext()))
    {
      bcpw.a(BaseApplication.getContext(), 1, ajyc.a(2131702168), 0).a();
      veg.d("Q.qqstory.player.CommentFloatDialog", "delete comment failed. invalidate network.");
      return;
    }
    ((CommentEntry)localObject).status = 1;
    szh.a((CommentEntry)localObject, new tyc(this, (CommentEntry)localObject, bool));
  }
  
  public void b(CommentEntry paramCommentEntry)
  {
    szv.a(txw.a(this.a).a, paramCommentEntry, txw.c(this.a), txw.a(this.a), new tyd(this));
  }
  
  public void c()
  {
    Object localObject = txw.a(this.a).a("CommentFloatDialog");
    if (localObject != null) {
      ((wde)localObject).a(false);
    }
    localObject = txw.a(this.a).getLayoutParams();
    if (localObject == null) {
      localObject = new ViewGroup.LayoutParams(-1, this.a.getContext().getResources().getDimensionPixelOffset(2131298774));
    }
    for (;;)
    {
      txw.a(this.a).setLayoutParams((ViewGroup.LayoutParams)localObject);
      return;
      ((ViewGroup.LayoutParams)localObject).height = this.a.getContext().getResources().getDimensionPixelOffset(2131298776);
    }
  }
  
  public void d()
  {
    boolean bool = false;
    Object localObject = txw.a(this.a).a("CommentFloatDialog");
    if (localObject != null)
    {
      if (txw.a(this.a) != null)
      {
        if (!txw.a(this.a).a(txw.a(this.a).a())) {
          bool = true;
        }
        ((wde)localObject).a(bool);
      }
    }
    else
    {
      localObject = txw.a(this.a).getLayoutParams();
      if (localObject != null) {
        break label119;
      }
      localObject = new ViewGroup.LayoutParams(-1, this.a.getContext().getResources().getDimensionPixelOffset(2131298774));
    }
    for (;;)
    {
      txw.a(this.a).setLayoutParams((ViewGroup.LayoutParams)localObject);
      return;
      ((wde)localObject).a(false);
      break;
      label119:
      ((ViewGroup.LayoutParams)localObject).height = this.a.getContext().getResources().getDimensionPixelOffset(2131298774);
    }
  }
  
  public void f_(int paramInt)
  {
    txw.a(this.a).setSelectionFromBottom(txw.a(this.a).a() + paramInt, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tyb
 * JD-Core Version:    0.7.0.1
 */