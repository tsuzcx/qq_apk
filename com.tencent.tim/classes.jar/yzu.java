import com.tencent.mobileqq.activity.contacts.alphabet.AlphabetFriendFragment;
import com.tencent.mobileqq.activity.contacts.base.tabs.ContactsBaseFragment;
import com.tencent.mobileqq.activity.contacts.device.DeviceFragment;
import com.tencent.mobileqq.activity.contacts.friend.FriendFragment;
import com.tencent.mobileqq.activity.contacts.mayknow.RecommendFriendFragment;
import com.tencent.mobileqq.activity.contacts.phone.PhoneContactFragment;
import com.tencent.mobileqq.activity.contacts.publicaccount.PublicAccountFragment;
import com.tencent.mobileqq.activity.contacts.troop.TroopFragment;

public class yzu
{
  public static ContactsBaseFragment a(int paramInt)
  {
    Object localObject;
    switch (paramInt)
    {
    default: 
      localObject = new FriendFragment();
    }
    for (;;)
    {
      ((ContactsBaseFragment)localObject).EQ(paramInt);
      return localObject;
      localObject = new RecommendFriendFragment();
      continue;
      localObject = new FriendFragment();
      continue;
      localObject = new TroopFragment();
      continue;
      localObject = new PublicAccountFragment();
      continue;
      localObject = new DeviceFragment();
      continue;
      localObject = new PhoneContactFragment();
      continue;
      localObject = new AlphabetFriendFragment();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yzu
 * JD-Core Version:    0.7.0.1
 */