import java.util.Comparator;

class amny
  implements Comparator<amnv.a>
{
  amny(amnv paramamnv) {}
  
  public int a(amnv.a parama1, amnv.a parama2)
  {
    int j = Long.signum(parama1.mSearchScene - parama2.mSearchScene);
    int i = j;
    if (j == 0)
    {
      j = Long.signum(parama1.mProximity - parama2.mProximity);
      i = j;
      if (j == 0)
      {
        j = Long.signum(parama1.dCW - parama2.dCW);
        i = j;
        if (j == 0) {
          i = Long.signum(-parama1.mTime + parama2.mTime);
        }
      }
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amny
 * JD-Core Version:    0.7.0.1
 */