import com.tencent.mobileqq.adapter.NewFriendMoreSysMsgAdapter;
import com.tencent.widget.SwipRightMenuBuilder.SwipRightMenuItem;
import com.tencent.widget.SwipTextViewMenuBuilder;

public class yev
  extends SwipTextViewMenuBuilder
{
  public yev(NewFriendMoreSysMsgAdapter paramNewFriendMoreSysMsgAdapter, int paramInt1, int paramInt2, int[] paramArrayOfInt1, int paramInt3, int[] paramArrayOfInt2, int[] paramArrayOfInt3, int[] paramArrayOfInt4)
  {
    super(paramInt1, paramInt2, paramArrayOfInt1, paramInt3, paramArrayOfInt2, paramArrayOfInt3, paramArrayOfInt4);
  }
  
  public void a(int paramInt, Object paramObject, SwipRightMenuBuilder.SwipRightMenuItem[] paramArrayOfSwipRightMenuItem)
  {
    paramInt = 0;
    if ((paramArrayOfSwipRightMenuItem == null) || (paramArrayOfSwipRightMenuItem.length <= 0)) {}
    for (;;)
    {
      return;
      if (paramArrayOfSwipRightMenuItem.length < 0)
      {
        paramArrayOfSwipRightMenuItem[0].b = 0;
        paramArrayOfSwipRightMenuItem[0].a = 0;
        paramInt = 1;
      }
      while (paramInt < paramArrayOfSwipRightMenuItem.length)
      {
        paramArrayOfSwipRightMenuItem[paramInt].b = -1;
        paramArrayOfSwipRightMenuItem[paramInt].a = -1;
        paramInt += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     yev
 * JD-Core Version:    0.7.0.1
 */