import com.tencent.biz.common.offline.AsyncBack;
import com.tencent.mobileqq.activity.aio.item.TroopSignItemBuilder.TroopSignVideoItemBuilder;
import com.tencent.mobileqq.activity.aio.item.TroopSignItemBuilder.TroopSignVideoItemBuilder.IOnOfflineResCallback;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public final class vkt
  implements AsyncBack
{
  public void a(int paramInt) {}
  
  public void a(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopSignItemBuilder", 2, "checkUpByBusinessId:2833|param:" + paramString + "|code:" + paramInt);
    }
    if ((paramInt == 0) && (paramString == null))
    {
      paramString = TroopSignItemBuilder.TroopSignVideoItemBuilder.a.entrySet().iterator();
      while (paramString.hasNext()) {
        ((TroopSignItemBuilder.TroopSignVideoItemBuilder.IOnOfflineResCallback)((Map.Entry)paramString.next()).getValue()).a(paramInt);
      }
      TroopSignItemBuilder.TroopSignVideoItemBuilder.a.clear();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vkt
 * JD-Core Version:    0.7.0.1
 */