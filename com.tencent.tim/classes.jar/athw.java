import java.util.Comparator;

final class athw
  implements Comparator<atiu>
{
  public int a(atiu paramatiu1, atiu paramatiu2)
  {
    if ((paramatiu1.getCloudFileType() == 1) && (paramatiu2.getCloudFileType() != 1)) {}
    do
    {
      do
      {
        return -1;
        if ((paramatiu1.getCloudFileType() != 1) && (paramatiu2.getCloudFileType() == 1)) {
          return 1;
        }
      } while (paramatiu1.getSortTime() > paramatiu2.getSortTime());
      if (paramatiu1.getSortTime() < paramatiu2.getSortTime()) {
        return 1;
      }
    } while (paramatiu1.getSortSeq() < paramatiu2.getSortSeq());
    if (paramatiu1.getSortSeq() > paramatiu2.getSortSeq()) {
      return 1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     athw
 * JD-Core Version:    0.7.0.1
 */