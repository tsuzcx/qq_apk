import android.view.View;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.colornote.settings.HistoryFormItem;
import com.tencent.mobileqq.colornote.settings.HistoryFormItem.a;
import com.tencent.mobileqq.widget.QQToast;
import java.util.List;

class aedb
  implements HistoryFormItem.a
{
  aedb(aecz paramaecz, HistoryFormItem paramHistoryFormItem) {}
  
  public void f(View paramView, int paramInt, boolean paramBoolean)
  {
    aeaz localaeaz = new aeaz();
    ColorNote localColorNote2;
    if ((aeba.canAddColorNote()) && (this.jdField_a_of_type_ComTencentMobileqqColornoteSettingsHistoryFormItem.isEnable())) {
      localColorNote2 = (ColorNote)aecz.a(this.jdField_a_of_type_Aecz).get(paramInt);
    }
    try
    {
      ColorNote localColorNote1 = (ColorNote)localColorNote2.clone();
      if (localColorNote1 != null)
      {
        localColorNote1.setType(0);
        localaeaz.cm(localColorNote1.parseBundle());
      }
      this.jdField_a_of_type_ComTencentMobileqqColornoteSettingsHistoryFormItem.setEnable(false);
      aecz.a(this.jdField_a_of_type_Aecz, localColorNote2, paramInt);
      QQToast.a(paramView.getContext(), 2, acfp.m(2131691744), 500).show();
      return;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      for (;;)
      {
        localCloneNotSupportedException.printStackTrace();
        Object localObject = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aedb
 * JD-Core Version:    0.7.0.1
 */