import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import com.tencent.biz.qqstory.troop.memories.TroopStoryItemInfo;
import com.tencent.biz.qqstory.troop.memories.TroopStoryMemoriesListAdapter;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import java.io.File;

public class zdb
  extends zdd
{
  public zdb(TroopStoryMemoriesListAdapter paramTroopStoryMemoriesListAdapter, View paramView)
  {
    super(paramTroopStoryMemoriesListAdapter, paramView);
  }
  
  public void a(TroopStoryItemInfo paramTroopStoryItemInfo, int paramInt)
  {
    TroopStoryMemoriesListAdapter.a(this.jdField_a_of_type_ComTencentBizQqstoryTroopMemoriesTroopStoryMemoriesListAdapter, paramTroopStoryItemInfo, this.jdField_a_of_type_ComTencentImageURLImageView, this.jdField_a_of_type_AndroidWidgetTextView);
    this.jdField_b_of_type_AndroidWidgetTextView.setText(zdu.d(paramTroopStoryItemInfo.publishTime));
    Drawable localDrawable = this.jdField_a_of_type_ComTencentBizQqstoryTroopMemoriesTroopStoryMemoriesListAdapter.a.getResources().getDrawable(2130846906);
    try
    {
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mLoadingDrawable = localDrawable;
      localURLDrawableOptions.mFailedDrawable = localDrawable;
      localURLDrawableOptions.mMemoryCacheKeySuffix = "troop_story_message";
      paramTroopStoryItemInfo = URLDrawable.getDrawable(new File(paramTroopStoryItemInfo.videoThumbUrl), localURLDrawableOptions);
      paramTroopStoryItemInfo.setTag(bgxc.b(UIUtils.dip2px(this.jdField_a_of_type_ComTencentBizQqstoryTroopMemoriesTroopStoryMemoriesListAdapter.a, 50.0F), UIUtils.dip2px(this.jdField_a_of_type_ComTencentBizQqstoryTroopMemoriesTroopStoryMemoriesListAdapter.a, 70.0F), UIUtils.dip2px(this.jdField_a_of_type_ComTencentBizQqstoryTroopMemoriesTroopStoryMemoriesListAdapter.a, 3.0F)));
      paramTroopStoryItemInfo.setDecodeHandler(bgxc.j);
      this.jdField_b_of_type_ComTencentImageURLImageView.setImageDrawable(paramTroopStoryItemInfo);
      paramTroopStoryItemInfo = this.jdField_a_of_type_ComTencentBizQqstoryTroopMemoriesTroopStoryMemoriesListAdapter.a.getResources().getDrawable(2130839466);
      paramTroopStoryItemInfo.setBounds(0, 0, 26, 26);
      this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawables(paramTroopStoryItemInfo, null, null, null);
      this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(10);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(anvx.a(2131715154));
      ((Animatable)paramTroopStoryItemInfo).start();
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(new zdc(this));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zdb
 * JD-Core Version:    0.7.0.1
 */