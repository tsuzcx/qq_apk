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

public class vqz
  implements wjj
{
  private vqz(vqu paramvqu) {}
  
  public void S_()
  {
    int i = vqu.a(this.a).b();
    vqu.a(this.a).setSelectionFromBottom(i, 0);
  }
  
  public void a()
  {
    vqu.a(this.a).p();
  }
  
  public void a(CommentEntry paramCommentEntry)
  {
    woy localwoy = (woy)uwa.a(11);
    uux localuux = (uux)uwa.a(17);
    boolean bool = vqu.a(this.a).a();
    if ((!vqu.a(this.a).a(bool)) && (vqu.a(this.a).a(bool) == null))
    {
      CommentEntry localCommentEntry = wjf.a(vqu.a(this.a).a(bool) - vqu.a(this.a).a(bool).size());
      vqu.a(this.a).c(localCommentEntry, bool);
      vqu.a(this.a).a(localCommentEntry, bool);
    }
    vqu.a(this.a).a(paramCommentEntry, bool);
    wxe.b("Q.qqstory.player.CommentFloatDialog", "after add comment. mCommentCount = %d, mFanCommentCount = %d, mFanCommentCount = %d.", Integer.valueOf(vqu.a(this.a).a.mCommentCount), Integer.valueOf(vqu.a(this.a).a.mFanCommentCount), Integer.valueOf(vqu.a(this.a).a.mFriendCommentCount));
    int i;
    if (vqu.a(this.a).a.mDenyComment == 1)
    {
      i = 1;
      if (i != 0)
      {
        QQToast.a(BaseApplication.getContext(), 1, alud.a(2131702562), 0).a();
        paramCommentEntry.status = 2;
      }
      vqu.a(this.a).p();
      ThreadManager.getUIHandler().postDelayed(new CommentFloatDialog.OnCommentHelperCallback.1(this), 50L);
      vqu.a(this.a).a = ((CommentLikeFeedItem)localwoy.a(vqu.a(this.a).a));
      if (!vqu.a(this.a).a()) {
        break label347;
      }
      if (!bool) {
        break label334;
      }
      paramCommentEntry.type = 4;
      paramCommentEntry.pbType = 1;
      label313:
      localuux.a(paramCommentEntry);
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
      paramCommentEntry.pbType = vqu.a(this.a).a.getCommentLikeType();
      localuux.b(paramCommentEntry);
    }
  }
  
  public void b(int paramInt)
  {
    boolean bool = vqu.a(this.a).a();
    Object localObject = vqu.a(this.a).a(bool);
    if ((paramInt < 0) || (paramInt >= ((List)localObject).size()))
    {
      wxe.d("Q.qqstory.player.CommentFloatDialog", "delete comment error , IndexOutOfBoundsException , need index = %d , size = %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(((List)localObject).size()) });
      return;
    }
    localObject = (CommentEntry)vqu.a(this.a).a(bool).get(paramInt);
    if (((CommentEntry)localObject).status != 0)
    {
      vqu.a(this.a).a((CommentEntry)localObject, bool);
      return;
    }
    if (!bdin.d(this.a.getContext()))
    {
      QQToast.a(BaseApplication.getContext(), 1, alud.a(2131702563), 0).a();
      wxe.d("Q.qqstory.player.CommentFloatDialog", "delete comment failed. invalidate network.");
      return;
    }
    ((CommentEntry)localObject).status = 1;
    usf.a((CommentEntry)localObject, new vra(this, (CommentEntry)localObject, bool));
  }
  
  public void b(CommentEntry paramCommentEntry)
  {
    ust.a(vqu.a(this.a).a, paramCommentEntry, vqu.c(this.a), vqu.a(this.a), new vrb(this));
  }
  
  public void c()
  {
    Object localObject = vqu.a(this.a).a("CommentFloatDialog");
    if (localObject != null) {
      ((xwc)localObject).a(false);
    }
    localObject = vqu.a(this.a).getLayoutParams();
    if (localObject == null) {
      localObject = new ViewGroup.LayoutParams(-1, this.a.getContext().getResources().getDimensionPixelOffset(2131298802));
    }
    for (;;)
    {
      vqu.a(this.a).setLayoutParams((ViewGroup.LayoutParams)localObject);
      return;
      ((ViewGroup.LayoutParams)localObject).height = this.a.getContext().getResources().getDimensionPixelOffset(2131298804);
    }
  }
  
  public void d()
  {
    boolean bool = false;
    Object localObject = vqu.a(this.a).a("CommentFloatDialog");
    if (localObject != null)
    {
      if (vqu.a(this.a) != null)
      {
        if (!vqu.a(this.a).a(vqu.a(this.a).a())) {
          bool = true;
        }
        ((xwc)localObject).a(bool);
      }
    }
    else
    {
      localObject = vqu.a(this.a).getLayoutParams();
      if (localObject != null) {
        break label119;
      }
      localObject = new ViewGroup.LayoutParams(-1, this.a.getContext().getResources().getDimensionPixelOffset(2131298802));
    }
    for (;;)
    {
      vqu.a(this.a).setLayoutParams((ViewGroup.LayoutParams)localObject);
      return;
      ((xwc)localObject).a(false);
      break;
      label119:
      ((ViewGroup.LayoutParams)localObject).height = this.a.getContext().getResources().getDimensionPixelOffset(2131298802);
    }
  }
  
  public void h_(int paramInt)
  {
    vqu.a(this.a).setSelectionFromBottom(vqu.a(this.a).a() + paramInt, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vqz
 * JD-Core Version:    0.7.0.1
 */