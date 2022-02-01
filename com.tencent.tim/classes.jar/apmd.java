public class apmd
  implements Comparable<apmd>
{
  public String iconUrl;
  public int id;
  public String name;
  public int priority;
  
  public apmd(int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    this.id = paramInt1;
    this.name = paramString1;
    this.iconUrl = paramString2;
    this.priority = paramInt2;
  }
  
  public int a(apmd paramapmd)
  {
    if (this.priority < paramapmd.priority) {
      return -1;
    }
    if (this.priority > paramapmd.priority) {
      return 1;
    }
    return 0;
  }
  
  public String toString()
  {
    return "TroopHonor{id=" + this.id + ", name='" + this.name + '\'' + ", iconUrl='" + this.iconUrl + '\'' + ", priority='" + this.priority + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apmd
 * JD-Core Version:    0.7.0.1
 */