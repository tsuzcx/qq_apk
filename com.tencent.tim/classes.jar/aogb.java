import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class aogb
  implements acci
{
  protected void H(boolean paramBoolean, List<String> paramList) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt == 1) {
      try
      {
        if ((paramObject instanceof List))
        {
          H(paramBoolean, (List)paramObject);
          return;
        }
        if (!paramBoolean)
        {
          H(false, null);
          return;
        }
      }
      catch (Exception paramObject)
      {
        QLog.e("ParticipleObserver", 1, paramObject, new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aogb
 * JD-Core Version:    0.7.0.1
 */