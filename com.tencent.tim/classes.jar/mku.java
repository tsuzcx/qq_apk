import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;

public class mku
{
  private static final String ajm = acfp.m(2131721533);
  private static final String ajn = acfp.m(2131721536);
  private static final String ajo = acfp.m(2131721534);
  private static final String ajp = acfp.m(2131721532);
  private static final String ajq = acfp.m(2131721535);
  
  private static AladdinConfig a()
  {
    return Aladdin.getConfig(303);
  }
  
  public static String kc()
  {
    return a().getString("ugc_add_account_description", ajm);
  }
  
  public static String kd()
  {
    return a().getString("ugc_add_account_use_original_account_button_description", ajn);
  }
  
  public static String ke()
  {
    return a().getString("ugc_add_account_edit_account_button_description", ajo);
  }
  
  public static String kf()
  {
    return a().getString("ugc_add_account_complete_toast_wording", ajp);
  }
  
  public static String kg()
  {
    return a().getString("ugc_add_account_tips_wording", ajq);
  }
  
  public static int pv()
  {
    return a().getIntegerFromString("ugc_add_account_tips_show_time", 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mku
 * JD-Core Version:    0.7.0.1
 */