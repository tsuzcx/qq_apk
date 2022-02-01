import android.view.View;
import com.tencent.mobileqq.activity.EmosmActivity;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emosm.view.DragSortListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class uwi
  implements ajdq<List<EmoticonPackage>>
{
  public uwi(EmosmActivity paramEmosmActivity) {}
  
  public void fP(List<EmoticonPackage> paramList)
  {
    this.this$0.pg.clear();
    if (this.this$0.jdField_a_of_type_Afie != null) {
      this.this$0.jdField_a_of_type_Afie.cZI();
    }
    if ((paramList != null) && (paramList.size() > 0))
    {
      EmoticonPackage localEmoticonPackage;
      if (this.this$0.mLaunchMode == 1)
      {
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          localEmoticonPackage = (EmoticonPackage)paramList.next();
          if ((3 != localEmoticonPackage.jobType) && (1 != localEmoticonPackage.jobType) && (5 != localEmoticonPackage.jobType)) {
            this.this$0.pg.add(localEmoticonPackage);
          }
        }
      }
      if (this.this$0.mLaunchMode == 2)
      {
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          localEmoticonPackage = (EmoticonPackage)paramList.next();
          if ((3 == localEmoticonPackage.jobType) || (5 == localEmoticonPackage.jobType)) {
            this.this$0.pg.add(localEmoticonPackage);
          }
        }
      }
    }
    if (this.this$0.mLaunchMode == 1)
    {
      if (this.this$0.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.findHeaderViewPosition(this.this$0.bK) == -1) {
        this.this$0.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.addHeaderView(this.this$0.bK);
      }
      this.this$0.bK.setVisibility(0);
      this.this$0.bNG();
      if (this.this$0.mLaunchMode != 2) {
        break label344;
      }
      this.this$0.setTitle(2131693089);
    }
    for (;;)
    {
      if (this.this$0.jdField_a_of_type_Afie != null) {
        this.this$0.jdField_a_of_type_Afie.notifyDataSetChanged();
      }
      return;
      if (this.this$0.pg.isEmpty())
      {
        this.this$0.bK.setVisibility(8);
        break;
      }
      this.this$0.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.removeHeaderView(this.this$0.bK);
      break;
      label344:
      this.this$0.setTitle(2131693347);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     uwi
 * JD-Core Version:    0.7.0.1
 */