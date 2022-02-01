import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.annotation.CallSuper;
import android.view.ViewGroup;
import com.tencent.biz.qqstory.msgTabNode.roundwithdashdemo2018.views.RoundBorderImageView;
import com.tencent.biz.qqstory.msgTabNode.roundwithdashdemo2018.widgets.StoryMsgNodeFrameLayout;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import java.util.List;

public class pwp
  extends prp<puh>
{
  public StoryMsgNodeFrameLayout a = (StoryMsgNodeFrameLayout)this.itemView;
  private Drawable mDefaultDrawable;
  
  public pwp(ViewGroup paramViewGroup, int paramInt)
  {
    super(paramViewGroup, paramInt);
  }
  
  @CallSuper
  public void r(puh parampuh)
  {
    super.P(parampuh);
    this.a.setTag(parampuh.unionId);
    s(parampuh);
  }
  
  protected void rt(String paramString)
  {
    if (this.mDefaultDrawable == null) {
      this.mDefaultDrawable = getContext().getResources().getDrawable(2130847483);
    }
    rpq.a(this.a.a, paramString, this.mDefaultDrawable, this.mDefaultDrawable, this.a.bkR, this.a.bkQ, "msg_tab_thumb");
  }
  
  protected void ru(String paramString)
  {
    Drawable localDrawable = getContext().getResources().getDrawable(2130847483);
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mMemoryCacheKeySuffix = "msg_tab_thumb";
    localURLDrawableOptions.mPlayGifImage = true;
    localURLDrawableOptions.mGifRoundCorner = rpq.dip2px(getContext(), 3.0F);
    localURLDrawableOptions.mRequestHeight = this.a.bkQ;
    localURLDrawableOptions.mRequestWidth = this.a.bkR;
    localURLDrawableOptions.mLoadingDrawable = localDrawable;
    localURLDrawableOptions.mFailedDrawable = localDrawable;
    paramString = URLDrawable.getDrawable(paramString, localURLDrawableOptions);
    paramString.setURLDrawableListener(new pwq(this));
    if ((paramString.getStatus() == 1) && (paramString.getCurrDrawable() != null)) {}
    for (;;)
    {
      this.a.a.setImageDrawable(paramString);
      return;
      if ((paramString.getStatus() == 3) || (paramString.getStatus() == 2)) {
        paramString.restartDownload();
      } else {
        paramString.startDownload();
      }
    }
  }
  
  protected void s(puh parampuh)
  {
    this.a.setDisplayState(0);
    if ((parampuh.iO != null) && (!parampuh.iO.isEmpty())) {
      this.a.dR(parampuh.iO.size(), parampuh.iO.size() - parampuh.unreadCount);
    }
    this.a.n(parampuh);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pwp
 * JD-Core Version:    0.7.0.1
 */