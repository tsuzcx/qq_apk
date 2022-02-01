import java.util.Comparator;

class ilv
  implements Comparator<ilw>
{
  ilv(ilu paramilu) {}
  
  public int a(ilw paramilw1, ilw paramilw2)
  {
    int j = -1;
    int i;
    if (paramilw1 == paramilw2) {
      i = 0;
    }
    label99:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return i;
              i = j;
            } while (paramilw1 == null);
            if (paramilw2 == null) {
              return 1;
            }
            if ((!paramilw1.tW()) || (!paramilw2.tW())) {
              break label99;
            }
            if (paramilw1.lO == paramilw2.lO) {
              break;
            }
            i = j;
          } while (paramilw2.lO > paramilw1.lO);
          return 1;
          if (paramilw1.lN == paramilw2.lN) {
            break;
          }
          i = j;
        } while (paramilw2.lN > paramilw1.lN);
        return 1;
        return 0;
        if (paramilw1.tW()) {
          return 1;
        }
        i = j;
      } while (paramilw2.tW());
      if (paramilw1.lN == paramilw2.lN) {
        break;
      }
      i = j;
    } while (paramilw2.lN > paramilw1.lN);
    return 1;
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ilv
 * JD-Core Version:    0.7.0.1
 */