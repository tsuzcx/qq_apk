import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.troop.homework.recite.data.ArticleInfo;
import com.tencent.mobileqq.troop.homework.recite.ui.SelectReciteParagraphFragment;
import com.tencent.mobileqq.troop.homework.recite.ui.SelectReciteParagraphFragment.a;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.json.JSONException;

public class apjz
  implements View.OnClickListener
{
  public apjz(SelectReciteParagraphFragment paramSelectReciteParagraphFragment) {}
  
  public void onClick(View paramView)
  {
    for (;;)
    {
      try
      {
        if (!this.a.dg.isEmpty())
        {
          localObject = new ArrayList(this.a.dg);
          SelectReciteParagraphFragment.a(this.a, apkp.a(this.a.mTroopUin, this.a.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataArticleInfo.title, this.a.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataArticleInfo.kid, (List)localObject, this.a.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiSelectReciteParagraphFragment$a.getCount()));
          this.a.getActivity().finish();
          aqfr.b("Grp_edu", "Grp_recite", "Clk_Success", 0, 0, new String[] { this.a.mTroopUin, String.valueOf(this.a.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataArticleInfo.type - 1) });
          String str1 = this.a.mTroopUin;
          String str2 = this.a.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataArticleInfo.title;
          if (localObject == null) {
            continue;
          }
          localObject = String.valueOf(((List)localObject).size());
          aqfr.b("Grp_edu", "Grp_recite", "Section_Count", 0, 0, new String[] { str1, str2, localObject });
        }
      }
      catch (JSONException localJSONException)
      {
        Object localObject;
        int i;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("SelectReciteParagraphFragment", 2, localJSONException, new Object[0]);
        continue;
      }
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      i = this.a.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataArticleInfo.paragraphs.size();
      localObject = String.valueOf(i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apjz
 * JD-Core Version:    0.7.0.1
 */