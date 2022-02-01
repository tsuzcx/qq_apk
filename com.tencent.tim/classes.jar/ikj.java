import com.tencent.ttpic.util.Coffee;
import com.tencent.ttpic.util.DecryptListener;

final class ikj
  implements DecryptListener
{
  public byte[] decrypt(byte[] paramArrayOfByte)
  {
    return Coffee.drink(paramArrayOfByte, Coffee.getDefaultSign());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ikj
 * JD-Core Version:    0.7.0.1
 */