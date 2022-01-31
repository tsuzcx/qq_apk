import android.graphics.drawable.Drawable;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.apollo.view.ApolloPanel;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.QLog;

public class yzb
  implements Runnable
{
  public yzb(ApolloPanel paramApolloPanel, BusinessInfoCheckUpdate.AppInfo paramAppInfo, String paramString) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.a(this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo);
      ((RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a.getManager(35)).a(this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo);
      Object localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mPlayGifImage = true;
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = ApolloPanel.a(this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel);
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = ApolloPanel.a(this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel);
      localObject = URLDrawable.getDrawable(this.jdField_a_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject);
      if (((URLDrawable)localObject).getStatus() != 1)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ApolloPanel", 2, "[parseShopRedTouchManager] shopDrawable not ready");
        }
        ((URLDrawable)localObject).startDownload();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel.jdField_a_of_type_ComTencentImageURLImageView != null) {
        this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     yzb
 * JD-Core Version:    0.7.0.1
 */