import com.tencent.mobileqq.activity.selectmember.TroopAddFrdsInnerFrame;
import com.tencent.mobileqq.data.TroopMemberInfo;
import java.util.Comparator;

public class ycc
  implements Comparator
{
  private ycc(TroopAddFrdsInnerFrame paramTroopAddFrdsInnerFrame) {}
  
  public int a(TroopMemberInfo paramTroopMemberInfo1, TroopMemberInfo paramTroopMemberInfo2)
  {
    int k = 0;
    int j = 0;
    int i;
    if (this.a.f == TroopAddFrdsInnerFrame.e)
    {
      i = paramTroopMemberInfo1.addState - paramTroopMemberInfo2.addState;
      if (i == 0) {
        if (paramTroopMemberInfo1.commonFrdCnt == -2147483648)
        {
          i = 0;
          if (paramTroopMemberInfo2.commonFrdCnt != -2147483648) {
            break label68;
          }
          label53:
          i = j - i;
        }
      }
    }
    label68:
    do
    {
      do
      {
        do
        {
          do
          {
            return i;
            i = paramTroopMemberInfo1.commonFrdCnt;
            break;
            j = paramTroopMemberInfo2.commonFrdCnt;
            break label53;
            return i;
            i = k;
          } while (this.a.f != TroopAddFrdsInnerFrame.d);
          i = k;
        } while (paramTroopMemberInfo1 == null);
        i = k;
      } while (paramTroopMemberInfo1.displayedNamePinyinFirst == null);
      i = k;
    } while (paramTroopMemberInfo2 == null);
    return paramTroopMemberInfo1.displayedNamePinyinFirst.compareToIgnoreCase(paramTroopMemberInfo2.displayedNamePinyinFirst);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ycc
 * JD-Core Version:    0.7.0.1
 */