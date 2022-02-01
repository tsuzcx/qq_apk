import android.os.Bundle;
import android.view.View;
import com.tencent.biz.qqstory.shareGroup.infocard.QQStoryShareGroupProfileActivity;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.activity.TroopInfoActivity;
import com.tencent.mobileqq.troop.utils.TroopUtils;

public class xcy
  implements bjoe
{
  public xcy(QQStoryShareGroupProfileActivity paramQQStoryShareGroupProfileActivity, bjnw parambjnw) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (UIUtils.isFastDoubleClick()) {}
    do
    {
      return;
      this.jdField_a_of_type_Bjnw.e();
      paramView = this.jdField_a_of_type_Bjnw.a(paramInt);
    } while (!amtj.a(2131710151).equals(paramView));
    paramView = TroopInfoActivity.a(this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardQQStoryShareGroupProfileActivity.c, 0);
    paramView.putInt("extra_last_open_from", this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardQQStoryShareGroupProfileActivity.a);
    TroopUtils.openTroopInfoActivity(this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardQQStoryShareGroupProfileActivity, paramView, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xcy
 * JD-Core Version:    0.7.0.1
 */