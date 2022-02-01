import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.troop.filemanager.data.TroopMemberListRefresher.1.1;
import java.util.List;

public class apes
  extends acnd
{
  apes(aper paramaper) {}
  
  protected void a(String paramString, boolean paramBoolean, List<TroopMemberInfo> paramList, int paramInt1, long paramLong, int paramInt2)
  {
    if ((!TextUtils.isEmpty(this.b.troopUin)) && (!this.b.troopUin.equals(paramString))) {}
    while ((!paramBoolean) || (this.b.dB == null)) {
      return;
    }
    ThreadManager.post(new TroopMemberListRefresher.1.1(this), 5, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apes
 * JD-Core Version:    0.7.0.1
 */