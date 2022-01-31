import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.PanelAdapter.ViewHolder;
import com.tencent.mobileqq.activity.aio.PlusPanel;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.data.TroopAIOAppInfo;
import com.tencent.mobileqq.troop.troop_apps.entry.ui.BulkSendMessageFragment;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import java.net.URI;
import java.net.URISyntaxException;

public class ujw
{
  public static void a(PlusPanel paramPlusPanel, PanelAdapter.ViewHolder paramViewHolder)
  {
    if (paramPlusPanel == null) {
      return;
    }
    switch (paramViewHolder.a)
    {
    default: 
      b(paramPlusPanel, paramViewHolder);
      return;
    }
    paramViewHolder = new Bundle();
    paramViewHolder.putString("extra.GROUP_UIN", paramPlusPanel.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    paramViewHolder.putString("selfSet_leftViewText", "取消");
    BulkSendMessageFragment.a(paramPlusPanel.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), paramViewHolder);
  }
  
  private static void b(PlusPanel paramPlusPanel, PanelAdapter.ViewHolder paramViewHolder)
  {
    if (paramViewHolder.a >= 0) {}
    do
    {
      do
      {
        return;
        localObject1 = null;
        if (paramPlusPanel.jdField_a_of_type_AndroidUtilSparseArray != null) {
          localObject1 = (TroopAIOAppInfo)paramPlusPanel.jdField_a_of_type_AndroidUtilSparseArray.get(paramViewHolder.b);
        }
      } while ((localObject1 == null) || (((TroopAIOAppInfo)localObject1).url == null));
      Object localObject1 = ((TroopAIOAppInfo)localObject1).url.replace("$UIN$", paramPlusPanel.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()).replace("$GCODE$", paramPlusPanel.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a).replace("$APPID$", String.valueOf(paramViewHolder.b));
      int j = 0;
      int i = j;
      try
      {
        if (TextUtils.equals(new URI((String)localObject1).getScheme(), "mqqapi"))
        {
          localObject2 = JumpParser.a(paramPlusPanel.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramPlusPanel.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), (String)localObject1);
          i = j;
          if (localObject2 != null)
          {
            ((JumpAction)localObject2).b();
            i = 1;
          }
        }
      }
      catch (URISyntaxException localURISyntaxException)
      {
        for (;;)
        {
          Object localObject2;
          i = j;
        }
      }
    } while (i != 0);
    localObject2 = new Intent(paramPlusPanel.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), QQBrowserActivity.class);
    ((Intent)localObject2).putExtra("url", (String)localObject1);
    ((Intent)localObject2).putExtra("selfSet_leftViewText", "返回");
    paramPlusPanel.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().startActivity((Intent)localObject2);
    paramPlusPanel.b(paramViewHolder.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ujw
 * JD-Core Version:    0.7.0.1
 */