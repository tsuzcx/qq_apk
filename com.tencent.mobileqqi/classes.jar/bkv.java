import com.tencent.biz.pubaccount.assistant.PubAccountAssistantSettingActivity;
import com.tencent.mobileqq.data.PublicAccountInfo;
import java.util.Comparator;

public class bkv
  implements Comparator
{
  public bkv(PubAccountAssistantSettingActivity paramPubAccountAssistantSettingActivity) {}
  
  public int a(PublicAccountInfo paramPublicAccountInfo1, PublicAccountInfo paramPublicAccountInfo2)
  {
    try
    {
      if (paramPublicAccountInfo1.mCompareSpell != null) {
        return paramPublicAccountInfo1.mCompareSpell.compareTo(paramPublicAccountInfo2.mCompareSpell);
      }
      if (paramPublicAccountInfo1.name != null)
      {
        int i = paramPublicAccountInfo1.name.compareTo(paramPublicAccountInfo2.mCompareSpell);
        return i;
      }
    }
    catch (Exception paramPublicAccountInfo1) {}
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     bkv
 * JD-Core Version:    0.7.0.1
 */