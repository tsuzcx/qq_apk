import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;

final class tsz
  implements bfoq
{
  tsz(QQUserUIItem paramQQUserUIItem, bfol parambfol) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      paramView = "16384";
      if ((this.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.qq))) {
        new tky().a(this.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.qq, this.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.isFriend(), paramView);
      }
      break;
    }
    for (;;)
    {
      this.jdField_a_of_type_Bfol.dismiss();
      return;
      paramView = "2";
      break;
      paramView = "1";
      break;
      paramView = "4";
      break;
      veg.d("Q.qqstory.player.PlayModeUtils", "report user error because evil uin is empty.");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tsz
 * JD-Core Version:    0.7.0.1
 */