import java.util.List;

public class atij
  implements acci
{
  public int type = -2;
  
  public void a(byte[] paramArrayOfByte, boolean paramBoolean1, int paramInt, List<atiu> paramList, boolean paramBoolean2) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != this.type) {
      return;
    }
    paramObject = (Object[])paramObject;
    a((byte[])paramObject[0], paramBoolean, ((Integer)paramObject[1]).intValue(), (List)paramObject[2], ((Boolean)paramObject[3]).booleanValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atij
 * JD-Core Version:    0.7.0.1
 */