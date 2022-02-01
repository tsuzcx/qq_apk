import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mobileqq.activity.EmosmActivity;
import com.tencent.mobileqq.emosm.view.DragSortListView;
import com.tencent.mobileqq.widget.QQBlurView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class uwm
  implements View.OnClickListener
{
  public uwm(EmosmActivity paramEmosmActivity) {}
  
  public void onClick(View paramView)
  {
    if (!this.this$0.aVU)
    {
      this.this$0.De.setText(2131693338);
      this.this$0.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.setDragEnabled(true);
      this.this$0.jdField_a_of_type_Afie.setEditMode(true);
      this.this$0.aVU = true;
      this.this$0.jdField_a_of_type_Afie.notifyDataSetChanged();
      this.this$0.W.setVisibility(0);
      EmosmActivity.a(this.this$0).setVisibility(0);
      EmosmActivity.a(this.this$0).setVisibility(0);
      this.this$0.W.setEnabled(false);
      this.this$0.setTitle(String.format(this.this$0.getResources().getString(2131693337), new Object[] { Integer.valueOf(0) }));
      this.this$0.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.setPadding(0, 0, 0, aqnm.dip2px(44.0F));
      anot.a(this.this$0.app, "CliOper", "", "", "EmosSetting", "EpsEdit", 0, 0, "", "", "", "");
      if (this.this$0.mLaunchMode == 1) {
        anot.a(this.this$0.app, "dc00898", "", "", "0X800AB0F", "0X800AB0F", 0, 0, "", "", "", "");
      }
    }
    while ((this.this$0.bGO != 2) && (this.this$0.bGO != 1)) {
      for (;;)
      {
        this.this$0.xd(this.this$0.aVU);
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        anot.a(this.this$0.app, "dc00898", "", "", "0X800AB16", "0X800AB16", 0, 0, "", "", "", "");
      }
    }
    this.this$0.De.setText(2131693336);
    this.this$0.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.setDragEnabled(false);
    this.this$0.jdField_a_of_type_Afie.setEditMode(false);
    this.this$0.bNH();
    this.this$0.aVU = false;
    this.this$0.jdField_a_of_type_Afie.notifyDataSetChanged();
    this.this$0.jdField_a_of_type_Afie.cZI();
    this.this$0.W.setVisibility(8);
    EmosmActivity.a(this.this$0).setVisibility(8);
    EmosmActivity.a(this.this$0).setVisibility(8);
    if (this.this$0.mLaunchMode == 2) {
      this.this$0.setTitle(2131693089);
    }
    for (;;)
    {
      this.this$0.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.setPadding(0, 0, 0, 0);
      break;
      this.this$0.setTitle(2131693347);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     uwm
 * JD-Core Version:    0.7.0.1
 */