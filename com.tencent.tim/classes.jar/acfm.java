import java.util.ArrayList;
import java.util.HashMap;

public class acfm
  implements acci
{
  public void b(boolean paramBoolean, ArrayList<ArrayList<String>> paramArrayList, ArrayList<String> paramArrayList1) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt == 1)
    {
      paramObject = (HashMap)paramObject;
      b(paramBoolean, (ArrayList)paramObject.get("mq_kandian_svc_results"), (ArrayList)paramObject.get("mq_kandian_svc_sentences"));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acfm
 * JD-Core Version:    0.7.0.1
 */