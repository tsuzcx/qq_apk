import android.view.View;
import com.tencent.mobileqq.activity.aio.item.TroopSignItemBuilder.TroopSignVideoItemBuilder;
import com.tencent.mobileqq.activity.aio.item.TroopSignItemBuilder.TroopSignVideoItemBuilder.IOnOfflineResCallback;
import com.tencent.mobileqq.activity.aio.item.TroopSignItemBuilder.TroopSignVideoItemBuilder.SignVideoItemHolder;
import com.tencent.mobileqq.troop.widget.TroopSignVideoView;
import java.io.File;

public class vpu
  implements TroopSignItemBuilder.TroopSignVideoItemBuilder.IOnOfflineResCallback
{
  public vpu(TroopSignItemBuilder.TroopSignVideoItemBuilder paramTroopSignVideoItemBuilder, String paramString, TroopSignItemBuilder.TroopSignVideoItemBuilder.SignVideoItemHolder paramSignVideoItemHolder) {}
  
  public void a(int paramInt)
  {
    if (new File(this.jdField_a_of_type_JavaLangString).exists())
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopSignItemBuilder$TroopSignVideoItemBuilder$SignVideoItemHolder.a.a(this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopSignItemBuilder$TroopSignVideoItemBuilder$SignVideoItemHolder.e.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vpu
 * JD-Core Version:    0.7.0.1
 */