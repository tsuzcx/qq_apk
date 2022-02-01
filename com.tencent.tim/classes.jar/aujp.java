import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import rx.functions.Action1;

class aujp
  implements Action1<aujl>
{
  aujp(aujo paramaujo, HashSet paramHashSet) {}
  
  public void a(aujl paramaujl)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ResourceGrabViewModel", 2, "ResourceNameOnClickListener subscribe call :" + paramaujl);
    }
    if (TextUtils.equals(paramaujl.type, "text_color"))
    {
      aujo.a(this.b, paramaujl, this.bP);
      return;
    }
    aujo.b(this.b, paramaujl, this.bP);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aujp
 * JD-Core Version:    0.7.0.1
 */