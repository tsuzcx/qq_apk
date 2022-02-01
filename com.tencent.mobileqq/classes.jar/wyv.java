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

public class wyv
  extends wro<wvn>
{
  private Drawable a;
  public StoryMsgNodeFrameLayout a;
  
  public wyv(ViewGroup paramViewGroup, int paramInt)
  {
    super(paramViewGroup, paramInt);
    this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeRoundwithdashdemo2018WidgetsStoryMsgNodeFrameLayout = ((StoryMsgNodeFrameLayout)this.itemView);
  }
  
  @CallSuper
  public void a(wvn paramwvn)
  {
    super.a(paramwvn);
    this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeRoundwithdashdemo2018WidgetsStoryMsgNodeFrameLayout.setTag(paramwvn.jdField_a_of_type_JavaLangString);
    b(paramwvn);
  }
  
  protected void b(String paramString)
  {
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = a().getResources().getDrawable(2130846618);
    }
    zps.a(this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeRoundwithdashdemo2018WidgetsStoryMsgNodeFrameLayout.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeRoundwithdashdemo2018ViewsRoundBorderImageView, paramString, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeRoundwithdashdemo2018WidgetsStoryMsgNodeFrameLayout.b, this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeRoundwithdashdemo2018WidgetsStoryMsgNodeFrameLayout.jdField_a_of_type_Int, "msg_tab_thumb");
  }
  
  protected void b(wvn paramwvn)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeRoundwithdashdemo2018WidgetsStoryMsgNodeFrameLayout.setDisplayState(0);
    if ((paramwvn.jdField_a_of_type_JavaUtilList != null) && (!paramwvn.jdField_a_of_type_JavaUtilList.isEmpty())) {
      this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeRoundwithdashdemo2018WidgetsStoryMsgNodeFrameLayout.a(paramwvn.jdField_a_of_type_JavaUtilList.size(), paramwvn.jdField_a_of_type_JavaUtilList.size() - paramwvn.b);
    }
    this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeRoundwithdashdemo2018WidgetsStoryMsgNodeFrameLayout.a(paramwvn);
  }
  
  protected void c(String paramString)
  {
    Drawable localDrawable = a().getResources().getDrawable(2130846618);
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mMemoryCacheKeySuffix = "msg_tab_thumb";
    localURLDrawableOptions.mPlayGifImage = true;
    localURLDrawableOptions.mGifRoundCorner = zps.a(a(), 3.0F);
    localURLDrawableOptions.mRequestHeight = this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeRoundwithdashdemo2018WidgetsStoryMsgNodeFrameLayout.jdField_a_of_type_Int;
    localURLDrawableOptions.mRequestWidth = this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeRoundwithdashdemo2018WidgetsStoryMsgNodeFrameLayout.b;
    localURLDrawableOptions.mLoadingDrawable = localDrawable;
    localURLDrawableOptions.mFailedDrawable = localDrawable;
    paramString = URLDrawable.getDrawable(paramString, localURLDrawableOptions);
    paramString.setURLDrawableListener(new wyw(this));
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
 * Qualified Name:     wyv
 * JD-Core Version:    0.7.0.1
 */