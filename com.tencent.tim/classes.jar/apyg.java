import java.util.ArrayList;

public class apyg
{
  public apyg c;
  public String id;
  public int level;
  public ArrayList<apyg> list;
  public String name;
  
  private apyg() {}
  
  public apyg(int paramInt, String paramString1, String paramString2)
  {
    this.level = paramInt;
    this.id = paramString1;
    this.name = paramString2;
  }
  
  public String BD()
  {
    String str = this.name;
    apyg localapyg = this;
    while (localapyg.c != null)
    {
      localapyg = localapyg.c;
      str = localapyg.name + "-" + str;
    }
    return str;
  }
  
  public void a(apyg paramapyg)
  {
    if (this.list == null) {
      this.list = new ArrayList();
    }
    this.list.add(paramapyg);
  }
  
  public boolean a(apyg paramapyg)
  {
    if ((paramapyg != null) && (paramapyg.level + 1 == this.level))
    {
      this.c = paramapyg;
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apyg
 * JD-Core Version:    0.7.0.1
 */