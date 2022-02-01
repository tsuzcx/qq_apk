import android.app.Dialog;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment;
import com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment.40.1;
import com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment.c;
import com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment.e;
import com.tencent.mobileqq.widget.QQToast;

public class zil
  extends acdv
{
  public zil(ChatHistoryTroopMemberFragment paramChatHistoryTroopMemberFragment) {}
  
  protected void a(boolean paramBoolean, Long paramLong)
  {
    if (this.this$0.G != null) {
      this.this$0.G.dismiss();
    }
  }
  
  protected void a(boolean paramBoolean, Long paramLong1, Long paramLong2)
  {
    if (paramBoolean)
    {
      anot.a(this.this$0.app, "CliOper", "", "", "0X80040F5", "0X80040F5", 0, 0, "", "", "", "");
      this.this$0.a(paramLong2 + "");
      if (this.this$0.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment$c != null) {
        this.this$0.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment$c.bSJ();
      }
      if (this.this$0.aaC)
      {
        this.this$0.wN(paramLong2 + "");
        if (this.this$0.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment$e != null) {
          this.this$0.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment$e.notifyDataSetChanged();
        }
      }
    }
    for (;;)
    {
      if (this.this$0.G != null) {
        this.this$0.G.dismiss();
      }
      return;
      QQToast.a(this.this$0.getActivity(), 1, this.this$0.getString(2131695183), 0).show(this.this$0.getActivity().getTitleBarHeight());
    }
  }
  
  protected void a(boolean paramBoolean1, String paramString, boolean paramBoolean2, int paramInt1, int paramInt2, boolean paramBoolean3)
  {
    this.this$0.getActivity().runOnUiThread(new ChatHistoryTroopMemberFragment.40.1(this, paramBoolean1, paramString, paramBoolean2, paramInt1, paramInt2, paramBoolean3));
  }
  
  protected void b(boolean paramBoolean, Long paramLong)
  {
    if (this.this$0.G != null) {
      this.this$0.G.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zil
 * JD-Core Version:    0.7.0.1
 */