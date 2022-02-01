import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.colornote.settings.ColorNoteSettingFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aedh
  implements CompoundButton.OnCheckedChangeListener
{
  public aedh(ColorNoteSettingFragment paramColorNoteSettingFragment, QQAppInterface paramQQAppInterface) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    aeay.y(this.val$app, paramBoolean);
    if (!paramBoolean) {
      new aeaz().l(null);
    }
    ((aebm)this.val$app.getBusinessHandler(168)).Hf(paramBoolean);
    if (paramBoolean) {}
    for (int i = 1;; i = 2)
    {
      anot.a(null, "dc00898", "", "", "0X800A8B0", "0X800A8B0", i, 0, "", "", "", "");
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aedh
 * JD-Core Version:    0.7.0.1
 */