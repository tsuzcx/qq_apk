import com.tencent.mobileqq.activity.contact.newfriend.NewFriendMoreSysMsgSuspiciousFragment.a;

public class ysp
  extends auve
{
  public ysp(NewFriendMoreSysMsgSuspiciousFragment.a parama, int paramInt1, int paramInt2, int[] paramArrayOfInt1, int paramInt3, int[] paramArrayOfInt2, int[] paramArrayOfInt3, int[] paramArrayOfInt4)
  {
    super(paramInt1, paramInt2, paramArrayOfInt1, paramInt3, paramArrayOfInt2, paramArrayOfInt3, paramArrayOfInt4);
  }
  
  public void a(int paramInt, Object paramObject, auvd.b[] paramArrayOfb)
  {
    paramInt = 0;
    if ((paramArrayOfb == null) || (paramArrayOfb.length <= 0)) {}
    for (;;)
    {
      return;
      if (paramArrayOfb.length < 0)
      {
        paramArrayOfb[0].dOf = 0;
        paramArrayOfb[0].dOe = 0;
        paramInt = 1;
      }
      while (paramInt < paramArrayOfb.length)
      {
        paramArrayOfb[paramInt].dOf = -1;
        paramArrayOfb[paramInt].dOe = -1;
        paramInt += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     ysp
 * JD-Core Version:    0.7.0.1
 */