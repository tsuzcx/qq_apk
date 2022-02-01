import android.util.Pair;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class ahmf
  extends acnd
{
  ahmf(ahme paramahme) {}
  
  protected void E(String paramString, List<Pair<String, String>> paramList)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("onGetTroopMemberListBy0x787 uin: ").append(paramString).append(" memberList size: ");
    if (paramList == null) {}
    for (int i = 0;; i = paramList.size())
    {
      QLog.i("ForwardTroopMemberControllerForMiniPie", 2, i);
      if ((ahme.a(this.this$0).equals(paramString)) && (ahme.a(this.this$0) != null))
      {
        ahme.a(this.this$0);
        ahme.a(this.this$0).kT(paramList);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahmf
 * JD-Core Version:    0.7.0.1
 */