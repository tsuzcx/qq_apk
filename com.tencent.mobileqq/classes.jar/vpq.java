import android.os.Handler;
import android.view.View;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.item.TroopSignItemBuilder.TroopSignVideoItemBuilder;
import com.tencent.mobileqq.activity.aio.item.TroopSignItemBuilder.TroopSignVideoItemBuilder.SignVideoItemHolder;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie.OnListViewScrollStateListener;
import com.tencent.mobileqq.troop.widget.TroopSignVideoView;

public class vpq
  implements TroopChatPie.OnListViewScrollStateListener
{
  public vpq(TroopSignItemBuilder.TroopSignVideoItemBuilder paramTroopSignVideoItemBuilder, TroopSignItemBuilder.TroopSignVideoItemBuilder.SignVideoItemHolder paramSignVideoItemHolder, BaseChatItemLayout paramBaseChatItemLayout) {}
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopSignItemBuilder$TroopSignVideoItemBuilder$SignVideoItemHolder.a.l();
      TroopSignItemBuilder.TroopSignVideoItemBuilder.a().removeCallbacksAndMessages(null);
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.getParent() != null)
    {
      TroopSignItemBuilder.TroopSignVideoItemBuilder.b().postDelayed(new vpr(this), 200L);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopSignItemBuilder$TroopSignVideoItemBuilder$SignVideoItemHolder.a.a();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopSignItemBuilder$TroopSignVideoItemBuilder$SignVideoItemHolder.d.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vpq
 * JD-Core Version:    0.7.0.1
 */