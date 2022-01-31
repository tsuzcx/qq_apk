import android.app.Activity;
import android.content.res.Resources;
import android.os.IBinder;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.activity.aio.photo.AIOImageListScene;
import com.tencent.mobileqq.activity.aio.photo.AIORichMediaInfo;
import com.tencent.mobileqq.activity.aio.photo.AIOShortVideoData;
import com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.QZoneClickReport;
import java.util.ArrayList;

public class vkw
  implements ActionSheet.OnButtonClickListener
{
  public vkw(AIOImageListScene paramAIOImageListScene, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (paramView != null)
    {
      paramView = this.jdField_a_of_type_ComTencentWidgetActionSheet.a(paramInt);
      if (paramView == null) {
        return;
      }
      if (!TextUtils.isEmpty(paramView))
      {
        if (!paramView.equals(AIOImageListScene.c(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListScene).getResources().getString(2131436681))) {
          break label195;
        }
        paramInt = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListScene.a();
        if (paramInt != 1) {
          break label94;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListScene.o();
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListScene.a("Multi_Forward_Contacts", this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListScene.jdField_a_of_type_JavaUtilArrayList.size());
      }
    }
    label195:
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      return;
      label94:
      if ((paramInt == 2) && (!this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListScene.jdField_a_of_type_JavaUtilArrayList.isEmpty()) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListScene.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.asBinder().pingBinder()))
      {
        paramView = (AIOShortVideoData)((AIORichMediaInfo)this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListScene.jdField_a_of_type_JavaUtilArrayList.get(0)).a;
        paramView = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListScene.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.a(paramView.g, paramView.f, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListScene.c);
        ForwardBaseOption.a(AIOImageListScene.d(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListScene), paramView);
        continue;
        if (paramView.equals(AIOImageListScene.e(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListScene).getResources().getString(2131435873)))
        {
          if (LocalMultiProcConfig.getInt4Uin(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListScene.jdField_a_of_type_JavaLangString + "__qzone_pic_permission__" + this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListScene.b, -1, Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListScene.jdField_a_of_type_JavaLangString).longValue()) == 0)
          {
            paramView = new QQCustomDialog(AIOImageListScene.f(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListScene), 2131624515);
            paramView.setContentView(2130968851);
            paramView.setTitle(AIOImageListScene.g(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListScene).getString(2131429880));
            paramView.setMessage(AIOImageListScene.h(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListScene).getString(2131429882));
            paramView.setNegativeButton(AIOImageListScene.i(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListScene).getString(2131429883), new vkx(this));
            paramView.setCanceledOnTouchOutside(false);
            paramView.setCancelable(false);
            paramView.show();
            QZoneClickReport.startReportImediately(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListScene.jdField_a_of_type_JavaLangString, "40", "1");
          }
          else if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListScene.jdField_a_of_type_JavaUtilArrayList.size() > 20)
          {
            QQToast.a(AIOImageListScene.k(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListScene), 2131435874, 0).a();
          }
          else
          {
            this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListScene.p();
          }
        }
        else if (paramView.equals(AIOImageListScene.l(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListScene).getResources().getString(2131435863))) {
          if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListScene.jdField_a_of_type_JavaUtilArrayList.size() > 20) {
            QQToast.a(AIOImageListScene.m(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListScene), 2131435874, 0).a();
          } else {
            this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListScene.q();
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vkw
 * JD-Core Version:    0.7.0.1
 */