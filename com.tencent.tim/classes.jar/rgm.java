public class rgm
{
  public int brg;
  public int color;
  public int size;
  public int state;
  public String text;
  
  public void b(rgm paramrgm)
  {
    this.text = paramrgm.text;
    this.color = paramrgm.color;
    this.size = paramrgm.size;
    this.state = paramrgm.state;
    this.brg = paramrgm.brg;
  }
  
  public String toString()
  {
    return "TextInfo{text='" + this.text + '\'' + ", textColor=" + this.color + ", size=" + this.size + ", state=" + this.state + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rgm
 * JD-Core Version:    0.7.0.1
 */