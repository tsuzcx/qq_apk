public class ujc
  implements uha
{
  public String a;
  
  public void copy(Object paramObject)
  {
    if ((paramObject instanceof ujc)) {
      this.a = ((ujc)paramObject).a;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ujc
 * JD-Core Version:    0.7.0.1
 */