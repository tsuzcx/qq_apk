import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.qphone.base.util.QLog;

class pva
  implements ppv.b<pvd, pvd.a>
{
  pva(puz parampuz, pma parampma, pmb parampmb) {}
  
  public void a(@NonNull pvd parampvd, @Nullable pvd.a parama, @NonNull ErrorMessage paramErrorMessage)
  {
    if ((paramErrorMessage.isFail()) || (parama == null))
    {
      QLog.w("Q.qqstory.msgTab.MsgTabStoryNodeConfigManager", 1, "get active fail" + paramErrorMessage.getErrorMessage());
      return;
    }
    if (parama.active == 1)
    {
      this.jdField_a_of_type_Puz.sq(true);
      this.jdField_a_of_type_Pma.vH(2);
      this.jdField_a_of_type_Puz.aJ = 2;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.msgTab.MsgTabStoryNodeConfigManager", 2, "active value is " + parama.active);
    }
    this.b.fe(parama.Aw);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pva
 * JD-Core Version:    0.7.0.1
 */