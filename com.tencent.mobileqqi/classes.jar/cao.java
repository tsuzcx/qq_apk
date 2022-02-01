import android.content.res.Resources;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mobileqq.activity.ChatBackgroundSettingActivity;
import com.tencent.mobileqq.activity.ChatBackgroundSettingActivity.PicInfo;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.transfile.HttpDownloadFileProcessor;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class cao
  implements AdapterView.OnItemClickListener
{
  public cao(ChatBackgroundSettingActivity paramChatBackgroundSettingActivity) {}
  
  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    this.a.b();
    Object localObject = (ChatBackgroundSettingActivity.PicInfo)paramView.getTag();
    String str1 = this.a.jdField_b_of_type_JavaLangString;
    if (localObject == null)
    {
      this.a.jdField_b_of_type_JavaLangString = "none";
      paramView.findViewById(2131231326).setVisibility(0);
      this.a.jdField_b_of_type_Int = paramInt;
      if ((str1 != null) && (str1.trim().length() != 0)) {
        break label457;
      }
    }
    label457:
    for (paramAdapterView = "null";; paramAdapterView = str1)
    {
      str1 = this.a.jdField_b_of_type_JavaLangString;
      if (str1 != null)
      {
        paramView = str1;
        if (str1.trim().length() != 0) {}
      }
      else
      {
        paramView = "null";
      }
      if (QLog.isColorLevel()) {
        QLog.d(ChatBackgroundSettingActivity.c(), 2, "oldPicPath is:" + paramAdapterView + ",newPicPath is:" + paramView);
      }
      if (!paramAdapterView.equals(paramView))
      {
        if ((ChatBackgroundSettingActivity.a(this.a) == null) || (ChatBackgroundSettingActivity.a(this.a).trim().length() == 0)) {
          ChatBackgroundSettingActivity.a(this.a, this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a());
        }
        this.a.v_();
        ChatBackgroundSettingActivity.a(this.a);
      }
      do
      {
        return;
        String str2 = AppConstants.aW + ((ChatBackgroundSettingActivity.PicInfo)localObject).jdField_b_of_type_JavaLangString + ".png";
        File localFile = new File(str2);
        localObject = (HttpDownloadFileProcessor)this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a(((ChatBackgroundSettingActivity.PicInfo)localObject).c);
        if ((localFile.exists()) && ((localObject == null) || (((HttpDownloadFileProcessor)localObject).f())))
        {
          this.a.jdField_b_of_type_JavaLangString = str2;
          paramView.findViewById(2131231327).setVisibility(8);
          paramView.findViewById(2131231328).setVisibility(8);
          paramView.findViewById(2131231326).setVisibility(0);
          this.a.jdField_b_of_type_Int = paramInt;
          break;
        }
      } while ((paramAdapterView == null) || (this.a.jdField_b_of_type_Int >= paramAdapterView.getCount()));
      if (this.a.jdField_b_of_type_Int == -1)
      {
        paramAdapterView = this.a.a.findViewById(2131231326);
        if (paramAdapterView != null) {
          paramAdapterView.setVisibility(0);
        }
        paramAdapterView.setContentDescription(paramView.getResources().getString(2131561797));
        return;
      }
      paramAdapterView = paramAdapterView.getChildAt(this.a.jdField_b_of_type_Int).findViewById(2131231326);
      if (paramAdapterView != null) {
        paramAdapterView.setVisibility(0);
      }
      paramAdapterView.setContentDescription(paramView.getResources().getString(2131561797));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     cao
 * JD-Core Version:    0.7.0.1
 */