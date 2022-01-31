import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.widget.StoryCoverView;

public class unh
{
  public ImageView a;
  public StoryCoverView a;
  
  public unh(ung paramung, View paramView)
  {
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131363986));
    this.jdField_a_of_type_ComTencentBizQqstoryWidgetStoryCoverView = ((StoryCoverView)paramView.findViewById(2131379104));
  }
  
  void a(uuc paramuuc, int paramInt)
  {
    if (paramuuc.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem == null)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryWidgetStoryCoverView.setImageDrawable(this.jdField_a_of_type_Ung.a.getResources().getDrawable(2130845710));
      this.jdField_a_of_type_ComTencentBizQqstoryWidgetStoryCoverView.setPollLayout(null, -1, null);
      this.jdField_a_of_type_ComTencentBizQqstoryWidgetStoryCoverView.setRateLayout(null, -1, -1L, -1);
      this.jdField_a_of_type_AndroidWidgetImageView.setTag(Integer.valueOf(paramInt));
      ImageView localImageView = this.jdField_a_of_type_AndroidWidgetImageView;
      if (!paramuuc.jdField_a_of_type_Boolean) {
        break label186;
      }
      paramInt = 2130840202;
      label78:
      localImageView.setImageResource(paramInt);
      if (!paramuuc.b) {
        break label192;
      }
      this.jdField_a_of_type_ComTencentBizQqstoryWidgetStoryCoverView.setAlpha(1.0F);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new uni(this));
      return;
      if (TextUtils.isEmpty(paramuuc.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVideoThumbnailUrl)) {
        break;
      }
      ung.a(this.jdField_a_of_type_Ung, this.jdField_a_of_type_ComTencentBizQqstoryWidgetStoryCoverView.jdField_a_of_type_AndroidWidgetImageView, paramuuc.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVideoThumbnailUrl);
      this.jdField_a_of_type_ComTencentBizQqstoryWidgetStoryCoverView.setPollLayout(paramuuc.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.getPollLayout(), -1, null);
      this.jdField_a_of_type_ComTencentBizQqstoryWidgetStoryCoverView.setRateLayout(paramuuc.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.getInteractLayout(), -1, -1L, -1);
      break;
      label186:
      paramInt = 2130840198;
      break label78;
      label192:
      this.jdField_a_of_type_ComTencentBizQqstoryWidgetStoryCoverView.setAlpha(0.6F);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     unh
 * JD-Core Version:    0.7.0.1
 */