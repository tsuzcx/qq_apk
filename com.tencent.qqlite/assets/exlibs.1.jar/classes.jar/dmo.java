import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.adapter.QfileRecentImageExpandableListAdapter.ImageHolder;
import com.tencent.mobileqq.filemanager.activity.recentfile.QfileBaseRecentFileTabView;
import com.tencent.mobileqq.filemanager.activity.recentfile.QfileRecentFileBaseExpandableListAdapter.RecentItemHolder;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;

class dmo
  implements View.OnClickListener
{
  dmo(dmn paramdmn, View paramView) {}
  
  public void onClick(View paramView)
  {
    paramView = this.jdField_a_of_type_AndroidViewView.getTag();
    if ((paramView instanceof QfileRecentImageExpandableListAdapter.ImageHolder)) {}
    for (paramView = (FileManagerEntity)((QfileRecentImageExpandableListAdapter.ImageHolder)paramView).a;; paramView = (FileManagerEntity)((QfileRecentFileBaseExpandableListAdapter.RecentItemHolder)paramView).a)
    {
      if (QfileBaseRecentFileTabView.d(this.jdField_a_of_type_Dmn.a).a().b(paramView.nSessionId)) {}
      this.jdField_a_of_type_Dmn.a.a(paramView);
      QfileBaseRecentFileTabView.a(this.jdField_a_of_type_Dmn.a);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     dmo
 * JD-Core Version:    0.7.0.1
 */