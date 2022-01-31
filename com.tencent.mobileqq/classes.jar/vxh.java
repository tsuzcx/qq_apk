import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import com.tencent.biz.qqstory.troop.memories.TroopStoryItemInfo;
import com.tencent.biz.qqstory.troop.memories.TroopStoryMemoriesListAdapter;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;

public class vxh
  extends bfwe
{
  public View a;
  public TextView a;
  public URLImageView a;
  public TextView b;
  public URLImageView b;
  
  public vxh(TroopStoryMemoriesListAdapter paramTroopStoryMemoriesListAdapter, View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131362938));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131370647));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131377264));
    this.jdField_b_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131379104));
  }
  
  public void a(TroopStoryItemInfo paramTroopStoryItemInfo, int paramInt)
  {
    TroopStoryMemoriesListAdapter.a(this.jdField_b_of_type_ComTencentBizQqstoryTroopMemoriesTroopStoryMemoriesListAdapter, paramTroopStoryItemInfo, this.jdField_a_of_type_ComTencentImageURLImageView, this.jdField_a_of_type_AndroidWidgetTextView);
    this.jdField_b_of_type_AndroidWidgetTextView.setText(vxy.d(paramTroopStoryItemInfo.publishTime));
    Drawable localDrawable = this.jdField_b_of_type_ComTencentBizQqstoryTroopMemoriesTroopStoryMemoriesListAdapter.a.getResources().getDrawable(2130845995);
    try
    {
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mLoadingDrawable = localDrawable;
      localURLDrawableOptions.mFailedDrawable = localDrawable;
      localURLDrawableOptions.mMemoryCacheKeySuffix = "troop_story_message";
      paramTroopStoryItemInfo = URLDrawable.getDrawable(paramTroopStoryItemInfo.videoThumbUrl, localURLDrawableOptions);
      paramTroopStoryItemInfo.setTag(bavw.b(vzl.a(this.jdField_b_of_type_ComTencentBizQqstoryTroopMemoriesTroopStoryMemoriesListAdapter.a, 50.0F), vzl.a(this.jdField_b_of_type_ComTencentBizQqstoryTroopMemoriesTroopStoryMemoriesListAdapter.a, 70.0F), vzl.a(this.jdField_b_of_type_ComTencentBizQqstoryTroopMemoriesTroopStoryMemoriesListAdapter.a, 3.0F)));
      paramTroopStoryItemInfo.setDecodeHandler(bavw.i);
      this.jdField_b_of_type_ComTencentImageURLImageView.setImageDrawable(paramTroopStoryItemInfo);
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(new vxi(this, paramInt));
      return;
    }
    catch (Exception paramTroopStoryItemInfo)
    {
      for (;;)
      {
        this.jdField_b_of_type_ComTencentImageURLImageView.setImageDrawable(localDrawable);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vxh
 * JD-Core Version:    0.7.0.1
 */