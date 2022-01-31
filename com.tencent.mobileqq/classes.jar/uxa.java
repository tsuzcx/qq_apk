import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.doodle.DoodlePanel;
import com.tencent.mobileqq.scribble.ScribbleMsgUtils;
import com.tencent.mobileqq.widget.QQToast;

class uxa
  implements Runnable
{
  uxa(uwz paramuwz, int paramInt) {}
  
  public void run()
  {
    this.jdField_a_of_type_Uwz.a.d();
    if (this.jdField_a_of_type_Int == ScribbleMsgUtils.d)
    {
      this.jdField_a_of_type_Uwz.a.c();
      return;
    }
    QQToast.a(this.jdField_a_of_type_Uwz.a.getContext(), 2131439095, 0).b(DoodlePanel.a(this.jdField_a_of_type_Uwz.a).a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     uxa
 * JD-Core Version:    0.7.0.1
 */