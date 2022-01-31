import android.text.TextUtils;
import com.tencent.TMG.sdk.AVContext;
import com.tencent.TMG.sdk.AVRoomMulti;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.process.CmGameUtil;
import com.tencent.mobileqq.apollo.process.chanel.CmGameAvHandler;
import com.tencent.mobileqq.apollo.process.data.CmGameOpenIdFinder;
import com.tencent.mobileqq.apollo.tmg_opensdk.AVManager;
import java.util.ArrayList;
import org.json.JSONArray;

public class yqj
  implements Runnable
{
  public yqj(CmGameAvHandler paramCmGameAvHandler, JSONArray paramJSONArray) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_OrgJsonJSONArray.length() <= 0)
    {
      CmGameAvHandler.a(this.jdField_a_of_type_ComTencentMobileqqApolloProcessChanelCmGameAvHandler).clear();
      AVManager.a(BaseApplicationImpl.getContext()).a().getRoom().cancelAllView(new yqk(this));
    }
    for (;;)
    {
      return;
      CmGameAvHandler.a(this.jdField_a_of_type_ComTencentMobileqqApolloProcessChanelCmGameAvHandler).clear();
      String[] arrayOfString = new String[this.jdField_a_of_type_OrgJsonJSONArray.length()];
      String str3 = CmGameUtil.a().getCurrentAccountUin();
      int i = 0;
      while (i < this.jdField_a_of_type_OrgJsonJSONArray.length())
      {
        try
        {
          CmGameOpenIdFinder localCmGameOpenIdFinder = CmGameUtil.a(CmGameAvHandler.a(this.jdField_a_of_type_ComTencentMobileqqApolloProcessChanelCmGameAvHandler));
          if (localCmGameOpenIdFinder != null)
          {
            String str2 = localCmGameOpenIdFinder.c(this.jdField_a_of_type_OrgJsonJSONArray.get(i).toString());
            String str1 = str2;
            if (TextUtils.isEmpty(str2)) {
              str1 = localCmGameOpenIdFinder.a(this.jdField_a_of_type_OrgJsonJSONArray.get(i).toString());
            }
            arrayOfString[i] = str1;
            CmGameAvHandler.a(this.jdField_a_of_type_ComTencentMobileqqApolloProcessChanelCmGameAvHandler).add(str1);
            CmGameAvHandler.a(this.jdField_a_of_type_ComTencentMobileqqApolloProcessChanelCmGameAvHandler, arrayOfString, str3);
          }
        }
        catch (Exception localException)
        {
          label175:
          break label175;
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     yqj
 * JD-Core Version:    0.7.0.1
 */