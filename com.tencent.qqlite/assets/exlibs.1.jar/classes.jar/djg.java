import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.adapter.QfileWeiYunImageExpandableListAdapter.ImageHolder;
import com.tencent.mobileqq.filemanager.activity.cloudfile.QfileBaseCloudFileTabView;
import com.tencent.mobileqq.filemanager.activity.cloudfile.QfileCloudFileBaseExpandableListAdapter.CloudItemHolder;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.data.FMDataCache;
import com.tencent.mobileqq.filemanager.data.WeiYunFileInfo;
import com.tencent.qphone.base.util.QLog;

class djg
  implements View.OnClickListener
{
  djg(djf paramdjf, View paramView) {}
  
  public void onClick(View paramView)
  {
    paramView = this.jdField_a_of_type_AndroidViewView.getTag();
    if ((paramView instanceof QfileWeiYunImageExpandableListAdapter.ImageHolder))
    {
      paramView = (WeiYunFileInfo)((QfileWeiYunImageExpandableListAdapter.ImageHolder)this.jdField_a_of_type_AndroidViewView.getTag()).a;
      if ((FMDataCache.a(paramView.a)) && (QLog.isColorLevel())) {
        QLog.d(QfileBaseCloudFileTabView.a, 2, "there is a bug ");
      }
      QfileBaseCloudFileTabView.c(this.jdField_a_of_type_Djf.a).a().a(paramView);
      QfileBaseCloudFileTabView.a(this.jdField_a_of_type_Djf.a);
    }
    do
    {
      return;
      if ((paramView instanceof QfileCloudFileBaseExpandableListAdapter.CloudItemHolder))
      {
        paramView = (WeiYunFileInfo)((QfileCloudFileBaseExpandableListAdapter.CloudItemHolder)this.jdField_a_of_type_AndroidViewView.getTag()).a;
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e(QfileBaseCloudFileTabView.a, 2, "unknow Object");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     djg
 * JD-Core Version:    0.7.0.1
 */