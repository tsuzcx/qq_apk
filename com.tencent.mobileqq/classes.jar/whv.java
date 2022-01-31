import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.tips.ComicTipsBar;
import cooperation.comic.VipComicJumpActivity;
import cooperation.comic.VipComicReportUtils;
import org.json.JSONObject;

public class whv
  implements View.OnClickListener
{
  public whv(ComicTipsBar paramComicTipsBar, View paramView) {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsComicTipsBar.jdField_a_of_type_Boolean) {
      paramView = new JSONObject();
    }
    try
    {
      paramView.put("from", "19");
      label27:
      Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsComicTipsBar.jdField_a_of_type_AndroidAppActivity, VipComicJumpActivity.class);
      localIntent.putExtra("options", paramView.toString());
      this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsComicTipsBar.jdField_a_of_type_AndroidAppActivity.startActivity(localIntent);
      for (;;)
      {
        this.jdField_a_of_type_AndroidViewView.postDelayed(new whw(this), 2500L);
        if (!this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsComicTipsBar.jdField_a_of_type_Boolean) {
          break;
        }
        VipComicReportUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsComicTipsBar.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "3009", "2", "40039", this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsComicTipsBar.b, new String[0]);
        return;
        this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsComicTipsBar.jdField_a_of_type_AndroidAppActivity.finish();
      }
      VipComicReportUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsComicTipsBar.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "3006", "2", "40025", this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsComicTipsBar.b, new String[] { "2" });
      return;
    }
    catch (Exception localException)
    {
      break label27;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     whv
 * JD-Core Version:    0.7.0.1
 */