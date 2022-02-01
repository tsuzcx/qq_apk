import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;

public class kqc
{
  public static boolean Al()
  {
    return a().getIntegerFromString("comment_and_biu_combine_switch", 0) == 1;
  }
  
  public static boolean Am()
  {
    return a().getIntegerFromString("biu_editor_checkbox_default_status", 0) == 1;
  }
  
  public static boolean An()
  {
    return a().getIntegerFromString("biu_editor_checkbox_enable_remember", 0) == 1;
  }
  
  public static boolean Ao()
  {
    return a().getIntegerFromString("biu_editor_checkbox_hidden", 0) == 1;
  }
  
  public static boolean Ap()
  {
    return a().getIntegerFromString("biu_feed_card_white_jump", 1) == 1;
  }
  
  public static boolean Aq()
  {
    return a().getIntegerFromString("biu_feed_card_gray_jump", 1) == 1;
  }
  
  public static boolean Ar()
  {
    return a().getIntegerFromString("biu_feed_card_btn_jump", 1) == 1;
  }
  
  private static AladdinConfig a()
  {
    return Aladdin.getConfig(278);
  }
  
  public static String iA()
  {
    return a().getString("biu_editor_guide_wording", "");
  }
  
  public static String iB()
  {
    return a().getString("biu_editor_confirm_btn_wording", "");
  }
  
  public static String iC()
  {
    return a().getString("biu_editor_checkbox_wording", "");
  }
  
  public static String iD()
  {
    if (Al()) {
      return a().getString("operate_cell_aladding_keys", "");
    }
    return "";
  }
  
  public static String iz()
  {
    return a().getString("comment_guide_wording", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kqc
 * JD-Core Version:    0.7.0.1
 */