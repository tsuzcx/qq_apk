import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.selectmember.CreateFaceToFaceDiscussionActivity;
import com.tencent.mobileqq.app.QQAppInterface;

public class clg
  extends Handler
{
  public clg(CreateFaceToFaceDiscussionActivity paramCreateFaceToFaceDiscussionActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 0)
    {
      this.a.app.a(new clh(this));
      paramMessage = this.a.jdField_a_of_type_AndroidOsHandler.obtainMessage(0);
      this.a.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(paramMessage, this.a.jdField_a_of_type_Long);
    }
    while ((1 != paramMessage.what) || (this.a.jdField_b_of_type_Boolean)) {
      return;
    }
    this.a.jdField_a_of_type_JavaLangStringBuffer.delete(0, this.a.jdField_a_of_type_JavaLangStringBuffer.length());
    this.a.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130838694);
    this.a.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130838694);
    this.a.c.setImageResource(2130838694);
    this.a.d.setImageResource(2130838694);
    this.a.e.setEnabled(true);
    this.a.f.setEnabled(true);
    this.a.g.setEnabled(true);
    this.a.h.setEnabled(true);
    this.a.i.setEnabled(true);
    this.a.j.setEnabled(true);
    this.a.k.setEnabled(true);
    this.a.l.setEnabled(true);
    this.a.m.setEnabled(true);
    this.a.n.setEnabled(true);
    this.a.o.setEnabled(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     clg
 * JD-Core Version:    0.7.0.1
 */