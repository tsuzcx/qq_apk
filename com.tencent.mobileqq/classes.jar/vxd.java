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
import java.io.File;

public class vxd
  extends vxh
{
  public vxd(TroopStoryMemoriesListAdapter paramTroopStoryMemoriesListAdapter, View paramView)
  {
    super(paramTroopStoryMemoriesListAdapter, paramView);
  }
  
  public void a(TroopStoryItemInfo paramTroopStoryItemInfo, int paramInt)
  {
    TroopStoryMemoriesListAdapter.a(this.jdField_a_of_type_ComTencentBizQqstoryTroopMemoriesTroopStoryMemoriesListAdapter, paramTroopStoryItemInfo, this.jdField_a_of_type_ComTencentImageURLImageView, this.jdField_a_of_type_AndroidWidgetTextView);
    Drawable localDrawable = this.jdField_a_of_type_ComTencentBizQqstoryTroopMemoriesTroopStoryMemoriesListAdapter.a.getResources().getDrawable(2130845995);
    try
    {
      Object localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = localDrawable;
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = localDrawable;
      ((URLDrawable.URLDrawableOptions)localObject).mMemoryCacheKeySuffix = "troop_story_message";
      localObject = URLDrawable.getDrawable(new File(paramTroopStoryItemInfo.videoThumbUrl), (URLDrawable.URLDrawableOptions)localObject);
      ((URLDrawable)localObject).setTag(bavw.b(vzl.a(this.jdField_a_of_type_ComTencentBizQqstoryTroopMemoriesTroopStoryMemoriesListAdapter.a, 50.0F), vzl.a(this.jdField_a_of_type_ComTencentBizQqstoryTroopMemoriesTroopStoryMemoriesListAdapter.a, 70.0F), vzl.a(this.jdField_a_of_type_ComTencentBizQqstoryTroopMemoriesTroopStoryMemoriesListAdapter.a, 3.0F)));
      ((URLDrawable)localObject).setDecodeHandler(bavw.i);
      this.jdField_b_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject);
      localDrawable = this.jdField_a_of_type_ComTencentBizQqstoryTroopMemoriesTroopStoryMemoriesListAdapter.a.getResources().getDrawable(2130845992);
      localDrawable.setBounds(0, 0, 26, 26);
      this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(10);
      this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawables(localDrawable, null, null, null);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(ajya.a(2131715799));
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-65536);
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(new vxe(this, paramTroopStoryItemInfo));
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        this.jdField_b_of_type_ComTencentImageURLImageView.setImageDrawable(localDrawable);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vxd
 * JD-Core Version:    0.7.0.1
 */