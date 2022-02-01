import QQService.EVIPSPEC;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.utils.ContactUtils;
import java.util.Comparator;

public class exu
  implements Comparator
{
  public static final int a = -1;
  
  public int a(exs paramexs)
  {
    if (paramexs.jdField_a_of_type_Int != -1) {
      return paramexs.jdField_a_of_type_Int;
    }
    Friends localFriends = paramexs.jdField_a_of_type_ComTencentMobileqqDataFriends;
    int k = ContactUtils.a(localFriends.status, localFriends.detalStatusFlag, localFriends.isMqqOnLine, localFriends.sqqOnLineState, localFriends.iTermType);
    int j;
    int i;
    if ((k != 6) && (k != 0))
    {
      j = 65536;
      if (!localFriends.isServiceEnabled(EVIPSPEC.E_SP_SUPERVIP)) {
        break label148;
      }
      i = 4096;
      switch (k)
      {
      case 5: 
      case 6: 
      default: 
        label79:
        i = j | i | (int)localFriends.getLastLoginType();
      }
    }
    for (;;)
    {
      paramexs.jdField_a_of_type_Int = i;
      return i;
      j = 131072;
      break;
      label148:
      if (localFriends.isServiceEnabled(EVIPSPEC.E_SP_QQVIP))
      {
        i = 8192;
        break label79;
      }
      if (localFriends.isServiceEnabled(EVIPSPEC.E_SP_SUPERQQ))
      {
        i = 12288;
        break label79;
      }
      i = 16384;
      break label79;
      i = j | i | 0x1;
      continue;
      i = j | i | 0x2;
      continue;
      i = j | i | 0x3;
    }
  }
  
  public int a(exs paramexs1, exs paramexs2)
  {
    return a(paramexs1) - a(paramexs2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     exu
 * JD-Core Version:    0.7.0.1
 */