import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.c;
import com.tencent.mobileqq.msgbackup.fragment.MsgBackupDateFragment;

public class ajfj
  implements IphonePickerView.c
{
  public ajfj(MsgBackupDateFragment paramMsgBackupDateFragment) {}
  
  public void dn()
  {
    if ((MsgBackupDateFragment.a(this.a) != null) && (MsgBackupDateFragment.a(this.a).isShowing()))
    {
      MsgBackupDateFragment.a(this.a).dismiss();
      MsgBackupDateFragment.b(this.a);
      MsgBackupDateFragment.a(this.a);
      MsgBackupDateFragment.b(this.a, MsgBackupDateFragment.b(this.a));
    }
  }
  
  public void w(int paramInt1, int paramInt2)
  {
    switch (paramInt1)
    {
    }
    for (;;)
    {
      MsgBackupDateFragment.a(this.a, MsgBackupDateFragment.b(this.a));
      MsgBackupDateFragment.a(this.a);
      if ((MsgBackupDateFragment.a(this.a) != null) && ((paramInt1 == 0) || (paramInt1 == 1))) {
        MsgBackupDateFragment.a(this.a).LV(2);
      }
      return;
      if (MsgBackupDateFragment.b(this.a) == 1)
      {
        MsgBackupDateFragment.b(this.a, paramInt2);
      }
      else if (MsgBackupDateFragment.b(this.a) == 2)
      {
        MsgBackupDateFragment.c(this.a, paramInt2);
        continue;
        if (MsgBackupDateFragment.b(this.a) == 1)
        {
          MsgBackupDateFragment.d(this.a, paramInt2);
        }
        else if (MsgBackupDateFragment.b(this.a) == 2)
        {
          MsgBackupDateFragment.e(this.a, paramInt2);
          continue;
          if (MsgBackupDateFragment.b(this.a) == 1) {
            MsgBackupDateFragment.f(this.a, paramInt2);
          } else if (MsgBackupDateFragment.b(this.a) == 2) {
            MsgBackupDateFragment.g(this.a, paramInt2);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajfj
 * JD-Core Version:    0.7.0.1
 */