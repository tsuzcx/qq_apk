import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

class wli
  implements AdapterView.OnItemClickListener
{
  wli(wlh paramwlh) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    int j = ((ShareActionSheetBuilder.ActionSheetItem)wlh.a(this.this$0)[0].get(paramInt)).action;
    wlh.a(this.this$0).dismiss();
    int i = 0;
    switch (j)
    {
    }
    for (;;)
    {
      if (i != 0) {
        anot.a(null, "dc00898", "", "", "0X800A11B", "0X800A11B", i, 0, "", "", "", "");
      }
      if (QLog.isColorLevel()) {
        QLog.i("IntimateInfoShareHelper", 2, "intimate shareAction: " + paramInt + "," + j);
      }
      this.this$0.b(j, wlh.a(this.this$0));
      EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
      return;
      i = 1;
      continue;
      i = 2;
      continue;
      i = 3;
      continue;
      i = 4;
      continue;
      i = 5;
      continue;
      i = 6;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wli
 * JD-Core Version:    0.7.0.1
 */