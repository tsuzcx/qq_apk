import com.tencent.mobileqq.activity.history.ChatHistoryBaseFragment;
import com.tencent.mobileqq.activity.history.ChatHistoryBaseTenDocFragment;
import com.tencent.mobileqq.activity.history.ChatHistoryC2CAllFragment;
import com.tencent.mobileqq.activity.history.ChatHistoryC2CDateFragment;
import com.tencent.mobileqq.activity.history.ChatHistoryC2CEmotionFragment;
import com.tencent.mobileqq.activity.history.ChatHistoryC2CFileFragment;
import com.tencent.mobileqq.activity.history.ChatHistoryC2CLinkFragment;
import com.tencent.mobileqq.activity.history.ChatHistoryC2CMediaFragment;
import com.tencent.mobileqq.activity.history.ChatHistoryTroopAllFragment;
import com.tencent.mobileqq.activity.history.ChatHistoryTroopDateFragment;
import com.tencent.mobileqq.activity.history.ChatHistoryTroopEmotionFragment;
import com.tencent.mobileqq.activity.history.ChatHistoryTroopFileFragment;
import com.tencent.mobileqq.activity.history.ChatHistoryTroopLinkFragment;
import com.tencent.mobileqq.activity.history.ChatHistoryTroopMediaFragment;
import com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment;

public class ziy
{
  public static ChatHistoryBaseFragment a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return new ChatHistoryC2CAllFragment();
    case 2131364479: 
      return new ChatHistoryC2CAllFragment();
    case 2131364482: 
      return new ChatHistoryC2CFileFragment();
    case 2131364484: 
      return new ChatHistoryC2CMediaFragment();
    case 2131364481: 
      return new ChatHistoryC2CEmotionFragment();
    case 2131364483: 
      return new ChatHistoryC2CLinkFragment();
    case 2131364485: 
      return new ChatHistoryBaseTenDocFragment();
    case 2131364480: 
      return new ChatHistoryC2CDateFragment();
    case 2131364486: 
      return new ChatHistoryTroopAllFragment();
    case 2131364491: 
      return new ChatHistoryTroopMediaFragment();
    case 2131364488: 
      return new ChatHistoryTroopEmotionFragment();
    case 2131364489: 
      return new ChatHistoryTroopFileFragment();
    case 2131364490: 
      return new ChatHistoryTroopLinkFragment();
    case 2131364493: 
      return new ChatHistoryBaseTenDocFragment();
    case 2131364487: 
      return new ChatHistoryTroopDateFragment();
    }
    return new ChatHistoryTroopMemberFragment();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     ziy
 * JD-Core Version:    0.7.0.1
 */