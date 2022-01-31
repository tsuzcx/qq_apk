import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import com.tencent.mobileqq.activity.EmosmActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emosm.EmosmUtils;
import com.tencent.mobileqq.emosm.view.DragSortAdapter;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.vaswebviewplugin.EmojiHomeUiPlugin;
import java.lang.ref.WeakReference;
import java.util.List;

public class alh
  implements AdapterView.OnItemClickListener
{
  public alh(EmosmActivity paramEmosmActivity) {}
  
  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (this.a.jdField_a_of_type_Boolean) {}
    do
    {
      return;
      paramView = (EmoticonPackage)this.a.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortAdapter.getItem(paramInt);
      if (this.a.b)
      {
        this.a.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortAdapter.setSelected(paramInt);
        this.a.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortAdapter.notifyDataSetChanged();
        paramAdapterView = this.a.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortAdapter.getSelectedPackages();
        if ((paramAdapterView != null) && (paramAdapterView.size() > 0))
        {
          this.a.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
          return;
        }
        this.a.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
        return;
      }
    } while (!EmosmUtils.showNetEnable(this.a));
    this.a.jdField_a_of_type_Boolean = true;
    paramAdapterView = paramView.epId;
    boolean bool = false;
    if (paramView.jobType == 2)
    {
      paramAdapterView = paramView.kinId;
      bool = true;
    }
    if (1 == this.a.getIntent().getExtras().getInt("emojimall_src", 3)) {
      EmojiHomeUiPlugin.openEmojiDetailPage((Activity)this.a.jdField_a_of_type_JavaLangRefWeakReference.get(), this.a.app.getAccount(), 8, paramAdapterView, this.a.app.getSid(), bool);
    }
    for (;;)
    {
      ReportController.b(this.a.app, "CliOper", "", "", "ep_mall", "Clk_ep_mine_detail", 0, 0, paramView.epId, "", "", "");
      return;
      EmojiHomeUiPlugin.openEmojiDetailPage((Activity)this.a.jdField_a_of_type_JavaLangRefWeakReference.get(), this.a.app.getAccount(), 4, paramAdapterView, this.a.app.getSid(), bool);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     alh
 * JD-Core Version:    0.7.0.1
 */