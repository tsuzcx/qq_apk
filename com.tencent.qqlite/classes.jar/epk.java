import com.tencent.mobileqq.troop.jsp.TroopNoticeJsHandler;
import org.json.JSONArray;
import org.json.JSONException;

public class epk
  implements Runnable
{
  public epk(TroopNoticeJsHandler paramTroopNoticeJsHandler, String paramString) {}
  
  public void run()
  {
    try
    {
      JSONArray localJSONArray = new JSONArray(this.jdField_a_of_type_JavaLangString);
      int i = 0;
      int j = localJSONArray.length();
      while (i < j)
      {
        String str = localJSONArray.get(i).toString();
        this.jdField_a_of_type_ComTencentMobileqqTroopJspTroopNoticeJsHandler.c(str);
        i += 1;
      }
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     epk
 * JD-Core Version:    0.7.0.1
 */