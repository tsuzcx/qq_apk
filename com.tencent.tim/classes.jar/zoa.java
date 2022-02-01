import com.tencent.mobileqq.activity.miniaio.MiniMsgTabFragment;
import com.tencent.mobileqq.mini.mainpage.MainPageFragment;
import com.tencent.mobileqq.mini.out.activity.PermissionSettingFragment;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.widget.share.ShareActionSheet.OnItemClickListener;
import com.tencent.qphone.base.util.QLog;

public class zoa
  implements ShareActionSheet.OnItemClickListener
{
  public zoa(MiniMsgTabFragment paramMiniMsgTabFragment) {}
  
  public void onItemClick(ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem, ShareActionSheet paramShareActionSheet)
  {
    int i = paramActionSheetItem.action;
    int j = paramActionSheetItem.uinType;
    paramActionSheetItem = paramActionSheetItem.uin;
    switch (i)
    {
    default: 
      QLog.e("MiniMsgTabFragment", 1, "handleShareChatItemClick with invalid case:" + i);
    case 2: 
    case 73: 
    case 3: 
    case 9: 
    case 10: 
    case 70: 
    case 82: 
    case 76: 
    case 77: 
    case 14: 
    case 78: 
      do
      {
        return;
        MiniMsgTabFragment.a(this.this$0, 1, null);
        return;
        MiniMsgTabFragment.a(this.this$0, 5, null);
        return;
        MiniMsgTabFragment.a(this.this$0, 6, null);
        return;
        MiniMsgTabFragment.a(this.this$0, 7, null);
        return;
        MiniMsgTabFragment.a(this.this$0, 13, null);
        return;
        MiniMsgTabFragment.a(this.this$0, 8, null);
        return;
        MiniMsgTabFragment.a(this.this$0, 10, null);
        return;
      } while (MiniMsgTabFragment.a(this.this$0) == -1);
      if (MiniMsgTabFragment.a(this.this$0))
      {
        MainPageFragment.launchForMiniGame(this.this$0.getActivity(), MiniMsgTabFragment.a(this.this$0), 1, true);
        return;
      }
      MainPageFragment.launch(this.this$0.getActivity(), MiniMsgTabFragment.a(this.this$0), MiniMsgTabFragment.a(this.this$0));
      return;
    case 11: 
      MiniMsgTabFragment.a(this.this$0, 11, null);
      return;
    case 74: 
    case 75: 
      MiniMsgTabFragment.a(this.this$0, 2, null);
      return;
    case 79: 
    case 80: 
      MiniMsgTabFragment.a(this.this$0, 3, null);
      return;
    case 72: 
      MiniMsgTabFragment.a(this.this$0, paramActionSheetItem, j);
      return;
    case 81: 
      MiniMsgTabFragment.a(this.this$0, 9, null);
      return;
    case 83: 
      if (this.this$0.getActivity() != null)
      {
        PermissionSettingFragment.launchForResult(this.this$0.getActivity(), MiniMsgTabFragment.a(this.this$0), MiniMsgTabFragment.b(this.this$0), 5);
        return;
      }
      QLog.e("MiniMsgTabFragment", 1, "handleShareChatItemClick getActivity is null when ACTION_SETTING");
      return;
    case 128: 
      MiniMsgTabFragment.a(this.this$0, 14, null);
      return;
    case 158: 
      MiniMsgTabFragment.a(this.this$0, 15, null);
      return;
    }
    MiniMsgTabFragment.a(this.this$0, 16, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zoa
 * JD-Core Version:    0.7.0.1
 */