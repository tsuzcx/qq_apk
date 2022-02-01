import java.util.Comparator;

class aujd
  implements Comparator<atio>
{
  aujd(auja paramauja) {}
  
  public int a(atio paramatio1, atio paramatio2)
  {
    long l2 = 9223372036854775807L;
    if (paramatio1.dirType < paramatio2.dirType) {
      return -1;
    }
    if (paramatio1.dirType > paramatio2.dirType) {
      return 1;
    }
    long l3;
    long l1;
    if (paramatio1.dirType == 6)
    {
      l3 = paramatio1.getCreateTime();
      l1 = l3;
      if (l3 == 0L) {
        l1 = 9223372036854775807L;
      }
      l3 = paramatio2.getCreateTime();
      if (l3 != 0L) {
        break label151;
      }
    }
    for (;;)
    {
      if (l1 > l2) {
        return -1;
      }
      if (l1 < l2) {
        return 1;
      }
      return 0;
      if (paramatio1.getSortTime() > paramatio2.getSortTime()) {
        return -1;
      }
      if (paramatio1.getSortTime() < paramatio2.getSortTime()) {
        return 1;
      }
      if (paramatio1.getSortSeq() < paramatio2.getSortSeq()) {
        return -1;
      }
      if (paramatio1.getSortSeq() > paramatio2.getSortSeq()) {
        return 1;
      }
      return 0;
      label151:
      l2 = l3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aujd
 * JD-Core Version:    0.7.0.1
 */