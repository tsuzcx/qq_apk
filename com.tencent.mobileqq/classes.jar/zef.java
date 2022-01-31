import com.tencent.mobileqq.app.ContactSorter;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.SpecialCareInfo;
import com.tencent.mobileqq.utils.ContactUtils;
import java.util.Comparator;

public class zef
  implements Comparator
{
  public zef(FriendsManager paramFriendsManager) {}
  
  private String a(SpecialCareInfo paramSpecialCareInfo)
  {
    Friends localFriends = this.a.a(paramSpecialCareInfo.uin);
    if (localFriends == null) {
      return paramSpecialCareInfo.uin;
    }
    return ContactUtils.a(localFriends) + localFriends.uin;
  }
  
  public int a(SpecialCareInfo paramSpecialCareInfo1, SpecialCareInfo paramSpecialCareInfo2)
  {
    return ContactSorter.a(a(paramSpecialCareInfo1), a(paramSpecialCareInfo2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zef
 * JD-Core Version:    0.7.0.1
 */