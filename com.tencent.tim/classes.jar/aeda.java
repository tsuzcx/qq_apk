import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.colornote.settings.HistoryFormItem;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

class aeda
  implements View.OnClickListener
{
  aeda(aecz paramaecz, HistoryFormItem paramHistoryFormItem) {}
  
  public void onClick(View paramView)
  {
    ColorNote localColorNote = (ColorNote)aecz.a(this.jdField_a_of_type_Aecz).get(this.jdField_a_of_type_ComTencentMobileqqColornoteSettingsHistoryFormItem.getIndex());
    Bundle localBundle = new Bundle();
    if (aecz.a(this.jdField_a_of_type_Aecz) == 17104896) {
      if ((localColorNote.getServiceType() == 16908288) || (localColorNote.getServiceType() == 16908290)) {
        localBundle.putBoolean("isFromFavourite", true);
      }
    }
    for (;;)
    {
      aeay.a(paramView.getContext(), localColorNote, localBundle);
      if (QLog.isColorLevel()) {
        QLog.d("BaseSectionAdapter", 0, "getAllViews#onClick: index: " + this.jdField_a_of_type_ComTencentMobileqqColornoteSettingsHistoryFormItem.getIndex());
      }
      anot.a(null, "dc00898", "", "", "0X800AA7F", "0X800AA7F", aebs.gW(aecz.a(this.jdField_a_of_type_Aecz)), 0, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqColornoteSettingsHistoryFormItem.getIndex() + 1), "", "", "");
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (aecz.a(this.jdField_a_of_type_Aecz) == 16908289) {
        localBundle.putBoolean("history_note", true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aeda
 * JD-Core Version:    0.7.0.1
 */