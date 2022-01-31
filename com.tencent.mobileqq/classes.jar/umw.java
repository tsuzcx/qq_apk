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

public class umw
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
    }
    for (;;)
    {
      paramPlusPanel.b(paramViewHolder.b);
      return;
      Bundle localBundle = new Bundle();
      localBundle.putString("extra.GROUP_UIN", paramPlusPanel.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
      localBundle.putString("selfSet_leftViewText", "取消");
      BulkSendMessageFragment.a(paramPlusPanel.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), localBundle);
    }
  }
  
  private static void b(PlusPanel paramPlusPanel, PanelAdapter.ViewHolder paramViewHolder)
  {
    if (paramViewHolder.a >= 0) {}
    do
    {
      Object localObject;
      do
      {
        return;
        localObject = null;
        if (paramPlusPanel.jdField_a_of_type_AndroidUtilSparseArray != null) {
          localObject = (TroopAIOAppInfo)paramPlusPanel.jdField_a_of_type_AndroidUtilSparseArray.get(paramViewHolder.b);
        }
      } while ((localObject == null) || (((TroopAIOAppInfo)localObject).url == null));
      paramViewHolder = ((TroopAIOAppInfo)localObject).url.replace("$UIN$", paramPlusPanel.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()).replace("$GCODE$", paramPlusPanel.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a).replace("$APPID$", String.valueOf(paramViewHolder.b));
      int j = 0;
      int i = j;
      try
      {
        if (TextUtils.equals(new URI(paramViewHolder).getScheme(), "mqqapi"))
        {
          localObject = JumpParser.a(paramPlusPanel.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramPlusPanel.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), paramViewHolder);
          i = j;
          if (localObject != null)
          {
            ((JumpAction)localObject).b();
            i = 1;
          }
        }
      }
      catch (URISyntaxException localURISyntaxException)
      {
        for (;;)
        {
          i = j;
        }
      }
    } while (i != 0);
    localObject = new Intent(paramPlusPanel.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), QQBrowserActivity.class);
    ((Intent)localObject).putExtra("url", paramViewHolder);
    ((Intent)localObject).putExtra("selfSet_leftViewText", "返回");
    paramPlusPanel.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().startActivity((Intent)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     umw
 * JD-Core Version:    0.7.0.1
 */