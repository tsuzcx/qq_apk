import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

final class xqo
  implements jox
{
  public void loaded(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopSignItemBuilder", 2, "checkUpByBusinessId:2833|param:" + paramString + "|code:" + paramInt);
    }
    if ((paramInt == 0) && (paramString == null))
    {
      paramString = xqk.c.gS.entrySet().iterator();
      while (paramString.hasNext()) {
        ((xqk.c.a)((Map.Entry)paramString.next()).getValue()).N(paramInt);
      }
      xqk.c.gS.clear();
    }
  }
  
  public void progress(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xqo
 * JD-Core Version:    0.7.0.1
 */