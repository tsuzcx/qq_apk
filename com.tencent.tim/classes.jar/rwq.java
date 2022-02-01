import java.util.Comparator;

class rwq
  implements Comparator<rwo>
{
  rwq(rwp paramrwp) {}
  
  public int a(rwo paramrwo1, rwo paramrwo2)
  {
    if (paramrwo1.mPriority > paramrwo2.mPriority) {
      return 1;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rwq
 * JD-Core Version:    0.7.0.1
 */