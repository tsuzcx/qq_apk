import java.util.Comparator;

class ysg
  implements Comparator<ytv>
{
  ysg(ysf paramysf) {}
  
  public int a(ytv paramytv1, ytv paramytv2)
  {
    if ((!paramytv1.isReaded()) && (paramytv2.isReaded())) {
      return -1;
    }
    if ((paramytv1.isReaded()) && (!paramytv2.isReaded())) {
      return 1;
    }
    return (int)(paramytv2.Kz - paramytv1.Kz);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     ysg
 * JD-Core Version:    0.7.0.1
 */