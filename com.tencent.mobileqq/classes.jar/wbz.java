import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.widget.StoryCoverView;

public class wbz
{
  public ImageView a;
  public StoryCoverView a;
  
  public wbz(wby paramwby, View paramView)
  {
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131364047));
    this.jdField_a_of_type_ComTencentBizQqstoryWidgetStoryCoverView = ((StoryCoverView)paramView.findViewById(2131379783));
  }
  
  void a(wiu paramwiu, int paramInt)
  {
    if (paramwiu.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem == null)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryWidgetStoryCoverView.setImageDrawable(this.jdField_a_of_type_Wby.a.getResources().getDrawable(2130846089));
      this.jdField_a_of_type_ComTencentBizQqstoryWidgetStoryCoverView.setPollLayout(null, -1, null);
      this.jdField_a_of_type_ComTencentBizQqstoryWidgetStoryCoverView.setRateLayout(null, -1, -1L, -1);
      this.jdField_a_of_type_AndroidWidgetImageView.setTag(Integer.valueOf(paramInt));
      ImageView localImageView = this.jdField_a_of_type_AndroidWidgetImageView;
      if (!paramwiu.jdField_a_of_type_Boolean) {
        break label186;
      }
      paramInt = 2130840305;
      label78:
      localImageView.setImageResource(paramInt);
      if (!paramwiu.b) {
        break label192;
      }
      this.jdField_a_of_type_ComTencentBizQqstoryWidgetStoryCoverView.setAlpha(1.0F);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new wca(this));
      return;
      if (TextUtils.isEmpty(paramwiu.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVideoThumbnailUrl)) {
        break;
      }
      wby.a(this.jdField_a_of_type_Wby, this.jdField_a_of_type_ComTencentBizQqstoryWidgetStoryCoverView.jdField_a_of_type_AndroidWidgetImageView, paramwiu.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVideoThumbnailUrl);
      this.jdField_a_of_type_ComTencentBizQqstoryWidgetStoryCoverView.setPollLayout(paramwiu.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.getPollLayout(), -1, null);
      this.jdField_a_of_type_ComTencentBizQqstoryWidgetStoryCoverView.setRateLayout(paramwiu.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.getInteractLayout(), -1, -1L, -1);
      break;
      label186:
      paramInt = 2130840301;
      break label78;
      label192:
      this.jdField_a_of_type_ComTencentBizQqstoryWidgetStoryCoverView.setAlpha(0.6F);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wbz
 * JD-Core Version:    0.7.0.1
 */