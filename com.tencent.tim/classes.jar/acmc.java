import com.tencent.mobileqq.data.Stranger;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import java.util.List;
import tencent.im.oidb.cmd0x5d4.oidb_0x5d4.DelResult;

public class acmc
  implements acci
{
  public void B(boolean paramBoolean, List<Stranger> paramList) {}
  
  public void C(boolean paramBoolean, List<Stranger> paramList) {}
  
  public void a(boolean paramBoolean, PBRepeatMessageField<oidb_0x5d4.DelResult> paramPBRepeatMessageField) {}
  
  public void fN(List<String> paramList) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt == 4) {
      a(paramBoolean, (PBRepeatMessageField)paramObject);
    }
    do
    {
      return;
      if (paramInt == 2)
      {
        B(paramBoolean, (List)paramObject);
        return;
      }
      if (paramInt == 3)
      {
        C(paramBoolean, (List)paramObject);
        return;
      }
    } while (paramInt != 5);
    fN((List)paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acmc
 * JD-Core Version:    0.7.0.1
 */