import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.widget.StoryCoverView;

public class xtu
{
  public ImageView a;
  public StoryCoverView a;
  
  public xtu(xtt paramxtt, View paramView)
  {
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131364398));
    this.jdField_a_of_type_ComTencentBizQqstoryWidgetStoryCoverView = ((StoryCoverView)paramView.findViewById(2131381055));
  }
  
  void a(yap paramyap, int paramInt)
  {
    if (paramyap.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem == null)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryWidgetStoryCoverView.setImageDrawable(this.jdField_a_of_type_Xtt.a.getResources().getDrawable(2130846622));
      this.jdField_a_of_type_ComTencentBizQqstoryWidgetStoryCoverView.setPollLayout(null, -1, null);
      this.jdField_a_of_type_ComTencentBizQqstoryWidgetStoryCoverView.setRateLayout(null, -1, -1L, -1);
      this.jdField_a_of_type_AndroidWidgetImageView.setTag(Integer.valueOf(paramInt));
      ImageView localImageView = this.jdField_a_of_type_AndroidWidgetImageView;
      if (!paramyap.jdField_a_of_type_Boolean) {
        break label186;
      }
      paramInt = 2130840569;
      label78:
      localImageView.setImageResource(paramInt);
      if (!paramyap.b) {
        break label192;
      }
      this.jdField_a_of_type_ComTencentBizQqstoryWidgetStoryCoverView.setAlpha(1.0F);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new xtv(this));
      return;
      if (TextUtils.isEmpty(paramyap.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVideoThumbnailUrl)) {
        break;
      }
      xtt.a(this.jdField_a_of_type_Xtt, this.jdField_a_of_type_ComTencentBizQqstoryWidgetStoryCoverView.jdField_a_of_type_AndroidWidgetImageView, paramyap.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVideoThumbnailUrl);
      this.jdField_a_of_type_ComTencentBizQqstoryWidgetStoryCoverView.setPollLayout(paramyap.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.getPollLayout(), -1, null);
      this.jdField_a_of_type_ComTencentBizQqstoryWidgetStoryCoverView.setRateLayout(paramyap.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.getInteractLayout(), -1, -1L, -1);
      break;
      label186:
      paramInt = 2130840565;
      break label78;
      label192:
      this.jdField_a_of_type_ComTencentBizQqstoryWidgetStoryCoverView.setAlpha(0.6F);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xtu
 * JD-Core Version:    0.7.0.1
 */