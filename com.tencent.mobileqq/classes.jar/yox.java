import android.view.View;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.activity.aio.item.ApolloItemBuilder;
import com.tencent.mobileqq.activity.aio.item.ItemBuilderFactory;
import com.tencent.mobileqq.apollo.script.SpriteUIHandler;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForApollo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;

public class yox
  implements Runnable
{
  public yox(SpriteUIHandler paramSpriteUIHandler, long paramLong, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    try
    {
      Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteUIHandler.a();
      if (localObject1 == null)
      {
        QLog.e("cmshow_scripted_SpriteUIHandler", 1, "adatper is null.");
        return;
      }
      int i = AIOUtils.a(this.jdField_a_of_type_Long, (ListAdapter)localObject1);
      if (i >= 0)
      {
        XListView localXListView = this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteUIHandler.a();
        Object localObject2 = (ChatMessage)((ChatAdapter1)localObject1).getItem(i);
        if ((localXListView != null) && (localObject2 != null) && ((localObject2 instanceof MessageForApollo)))
        {
          localObject1 = ((ChatAdapter1)localObject1).a.a((ChatMessage)localObject2, (BaseAdapter)localObject1);
          if ((localObject1 instanceof ApolloItemBuilder))
          {
            localObject1 = (ApolloItemBuilder)localObject1;
            localObject2 = (BaseChatItemLayout)AIOUtils.a(localXListView, AIOUtils.a(this.jdField_a_of_type_Long, localXListView.getAdapter()));
            if (localObject2 != null)
            {
              ((ApolloItemBuilder)localObject1).a((View)localObject2, this.jdField_a_of_type_Int, this.b);
              localXListView.getFirstVisiblePosition();
              int j = localXListView.getLastVisiblePosition();
              i = 0;
              while (i < j)
              {
                BaseChatItemLayout localBaseChatItemLayout = (BaseChatItemLayout)AIOUtils.a(localXListView, i);
                if (localBaseChatItemLayout != null) {
                  ((ApolloItemBuilder)localObject1).a(localBaseChatItemLayout, (BaseChatItemLayout)localObject2, this.jdField_a_of_type_Int, this.b);
                }
                i += 1;
              }
            }
          }
        }
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("cmshow_scripted_SpriteUIHandler", 1, "[onActionDownloadNotify], error.", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     yox
 * JD-Core Version:    0.7.0.1
 */