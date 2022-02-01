import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.annotation.CallSuper;
import android.view.ViewGroup;
import com.tencent.biz.qqstory.msgTabNode.roundwithdashdemo2018.views.RoundBorderImageView;
import com.tencent.biz.qqstory.msgTabNode.roundwithdashdemo2018.widgets.StoryMsgNodeFrameLayout;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import java.util.List;

public class wpg
  extends wia<wly>
{
  private Drawable a;
  public StoryMsgNodeFrameLayout a;
  
  public wpg(ViewGroup paramViewGroup, int paramInt)
  {
    super(paramViewGroup, paramInt);
    this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeRoundwithdashdemo2018WidgetsStoryMsgNodeFrameLayout = ((StoryMsgNodeFrameLayout)this.itemView);
  }
  
  @CallSuper
  public void a(wly paramwly)
  {
    super.a(paramwly);
    this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeRoundwithdashdemo2018WidgetsStoryMsgNodeFrameLayout.setTag(paramwly.jdField_a_of_type_JavaLangString);
    b(paramwly);
  }
  
  protected void b(String paramString)
  {
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = a().getResources().getDrawable(2130846622);
    }
    UIUtils.setImageByURLDrawable(this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeRoundwithdashdemo2018WidgetsStoryMsgNodeFrameLayout.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeRoundwithdashdemo2018ViewsRoundBorderImageView, paramString, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeRoundwithdashdemo2018WidgetsStoryMsgNodeFrameLayout.b, this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeRoundwithdashdemo2018WidgetsStoryMsgNodeFrameLayout.jdField_a_of_type_Int, "msg_tab_thumb");
  }
  
  protected void b(wly paramwly)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeRoundwithdashdemo2018WidgetsStoryMsgNodeFrameLayout.setDisplayState(0);
    if ((paramwly.jdField_a_of_type_JavaUtilList != null) && (!paramwly.jdField_a_of_type_JavaUtilList.isEmpty())) {
      this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeRoundwithdashdemo2018WidgetsStoryMsgNodeFrameLayout.a(paramwly.jdField_a_of_type_JavaUtilList.size(), paramwly.jdField_a_of_type_JavaUtilList.size() - paramwly.b);
    }
    this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeRoundwithdashdemo2018WidgetsStoryMsgNodeFrameLayout.a(paramwly);
  }
  
  protected void c(String paramString)
  {
    Drawable localDrawable = a().getResources().getDrawable(2130846622);
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mMemoryCacheKeySuffix = "msg_tab_thumb";
    localURLDrawableOptions.mPlayGifImage = true;
    localURLDrawableOptions.mGifRoundCorner = UIUtils.dip2px(a(), 3.0F);
    localURLDrawableOptions.mRequestHeight = this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeRoundwithdashdemo2018WidgetsStoryMsgNodeFrameLayout.jdField_a_of_type_Int;
    localURLDrawableOptions.mRequestWidth = this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeRoundwithdashdemo2018WidgetsStoryMsgNodeFrameLayout.b;
    localURLDrawableOptions.mLoadingDrawable = localDrawable;
    localURLDrawableOptions.mFailedDrawable = localDrawable;
    paramString = URLDrawable.getDrawable(paramString, localURLDrawableOptions);
    paramString.setURLDrawableListener(new wph(this));
    if ((paramString.getStatus() == 1) && (paramString.getCurrDrawable() != null)) {}
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeRoundwithdashdemo2018WidgetsStoryMsgNodeFrameLayout.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeRoundwithdashdemo2018ViewsRoundBorderImageView.setImageDrawable(paramString);
      return;
      if ((paramString.getStatus() == 3) || (paramString.getStatus() == 2)) {
        paramString.restartDownload();
      } else {
        paramString.startDownload();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wpg
 * JD-Core Version:    0.7.0.1
 */