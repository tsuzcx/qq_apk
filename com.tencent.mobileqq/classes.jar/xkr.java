import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.RecentItemBaseBuilder;
import com.tencent.widget.SwipRightMenuBuilder.SwipRightMenuItem;
import com.tencent.widget.SwipTextViewMenuBuilder;

public class xkr
  extends SwipTextViewMenuBuilder
{
  public xkr(RecentItemBaseBuilder paramRecentItemBaseBuilder, int paramInt1, int paramInt2, int[] paramArrayOfInt1, int paramInt3, int[] paramArrayOfInt2, int[] paramArrayOfInt3, int[] paramArrayOfInt4)
  {
    super(paramInt1, paramInt2, paramArrayOfInt1, paramInt3, paramArrayOfInt2, paramArrayOfInt3, paramArrayOfInt4);
  }
  
  public void a(int paramInt, Object paramObject, SwipRightMenuBuilder.SwipRightMenuItem[] paramArrayOfSwipRightMenuItem)
  {
    if ((paramArrayOfSwipRightMenuItem == null) || (paramArrayOfSwipRightMenuItem.length <= 0)) {
      return;
    }
    if ((paramObject instanceof RecentBaseData)) {}
    for (int j = ((RecentBaseData)paramObject).f;; j = 0)
    {
      int i;
      if (paramArrayOfSwipRightMenuItem.length < 0)
      {
        paramInt = j & 0xF0;
        if (paramInt == 32)
        {
          paramArrayOfSwipRightMenuItem[0].b = 2;
          paramArrayOfSwipRightMenuItem[0].a = 1;
          i = 1;
        }
      }
      for (;;)
      {
        label61:
        paramInt = i;
        int k;
        if (i < paramArrayOfSwipRightMenuItem.length)
        {
          paramInt = i;
          if ((paramObject instanceof RecentBaseData))
          {
            paramInt = i;
            if (((RecentBaseData)paramObject).a())
            {
              k = 0xF0000 & j;
              if (k != 65536) {
                break label267;
              }
              paramArrayOfSwipRightMenuItem[i].b = 4;
              paramArrayOfSwipRightMenuItem[i].a = 1;
              paramInt = i + 1;
            }
          }
        }
        for (;;)
        {
          i = paramInt;
          if (paramInt < paramArrayOfSwipRightMenuItem.length)
          {
            i = paramInt;
            if ((0x300000 & j) == 2097152)
            {
              paramArrayOfSwipRightMenuItem[paramInt].b = 6;
              paramArrayOfSwipRightMenuItem[paramInt].a = 1;
              i = paramInt + 1;
            }
          }
          paramInt = i;
          if (i < paramArrayOfSwipRightMenuItem.length)
          {
            paramInt = i;
            if ((j & 0xF) == 1)
            {
              paramArrayOfSwipRightMenuItem[i].b = 0;
              paramArrayOfSwipRightMenuItem[i].a = 0;
              paramInt = i + 1;
            }
          }
          while (paramInt < paramArrayOfSwipRightMenuItem.length)
          {
            paramArrayOfSwipRightMenuItem[paramInt].b = -1;
            paramArrayOfSwipRightMenuItem[paramInt].a = -1;
            paramInt += 1;
          }
          break;
          if (paramInt != 16) {
            break label301;
          }
          paramArrayOfSwipRightMenuItem[0].b = 3;
          paramArrayOfSwipRightMenuItem[0].a = 0;
          i = 1;
          break label61;
          label267:
          paramInt = i;
          if (k == 131072)
          {
            paramArrayOfSwipRightMenuItem[i].b = 5;
            paramArrayOfSwipRightMenuItem[i].a = 1;
            paramInt = i + 1;
          }
        }
        label301:
        i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xkr
 * JD-Core Version:    0.7.0.1
 */