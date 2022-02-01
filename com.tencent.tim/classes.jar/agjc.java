import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

class agjc
  implements agig.a
{
  agjc(agjb paramagjb, String paramString) {}
  
  public void IZ(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.i("FileMultiMsgManager<FileAssistant>", 1, this.a.jdField_a_of_type_Agir$h.mFileName + " start upload Discfile success");
      }
      agir.h.a(this.a.jdField_a_of_type_Agir$h).putString("_m_ForwardUuid", this.fb);
      this.a.jdField_a_of_type_Agir$j.w(this.fb, agir.h.a(this.a.jdField_a_of_type_Agir$h));
    }
    for (;;)
    {
      agir.a(this.a.jdField_a_of_type_Agir$h.this$0).a().jp(agir.h.a(this.a.jdField_a_of_type_Agir$h));
      return;
      QLog.e("FileMultiMsg", 1, this.a.jdField_a_of_type_Agir$h.mFileName + " sendDiscFile faild");
      this.a.jdField_a_of_type_Agir$j.ch(agir.j(this.a.jdField_a_of_type_Agir$h.mFileSize, false), true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agjc
 * JD-Core Version:    0.7.0.1
 */