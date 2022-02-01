import java.util.List;

class xme
  implements xmu
{
  xme(xmc paramxmc) {}
  
  public void a()
  {
    xmc.a(this.a, this.a.a.a(xmc.a(this.a), 5));
    List localList = xmc.a(this.a).a;
    if ((xmc.a(this.a) == null) && (localList.size() > 0)) {
      xmc.a(this.a, ((xmt)localList.get(0)).a);
    }
    label199:
    for (;;)
    {
      yuk.d("Q.qqstory.player.data.SimpleDataProvider", "current group:%s", new Object[] { xmc.a(this.a) });
      xmc.a(this.a).a(xmc.a(this.a), "");
      return;
      int i = 0;
      for (;;)
      {
        if (i >= localList.size()) {
          break label199;
        }
        if (((xmt)localList.get(i)).a.equals(xmc.a(this.a)))
        {
          if (localList.size() <= i + 1) {
            break;
          }
          xmc.a(this.a, ((xmt)localList.get(i + 1)).a);
          break;
        }
        i += 1;
      }
    }
  }
  
  public void a(xms paramxms, String paramString, boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xme
 * JD-Core Version:    0.7.0.1
 */