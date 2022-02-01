import android.util.Pair;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class ahjm
  extends acnd
{
  ahjm(ahjl paramahjl) {}
  
  protected void E(String paramString, List<Pair<String, String>> paramList)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("onGetTroopMemberListBy0x787 uin: ").append(paramString).append(" memberList size: ");
    if (paramList == null) {}
    for (int i = 0;; i = paramList.size())
    {
      QLog.i("Forward.Preview.Dialog", 2, i);
      if ((ahjl.a(this.this$0).equals(paramString)) && (ahjl.a(this.this$0) != null))
      {
        this.this$0.hideLoadingView();
        ahjl.a(this.this$0).kT(paramList);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahjm
 * JD-Core Version:    0.7.0.1
 */