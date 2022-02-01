import java.util.List;

class xij
  implements xiz
{
  xij(xih paramxih) {}
  
  public void a()
  {
    xih.a(this.a, this.a.a.a(xih.a(this.a), 5));
    List localList = xih.a(this.a).a;
    if ((xih.a(this.a) == null) && (localList.size() > 0)) {
      xih.a(this.a, ((xiy)localList.get(0)).a);
    }
    label199:
    for (;;)
    {
      yqp.d("Q.qqstory.player.data.SimpleDataProvider", "current group:%s", new Object[] { xih.a(this.a) });
      xih.a(this.a).a(xih.a(this.a), "");
      return;
      int i = 0;
      for (;;)
      {
        if (i >= localList.size()) {
          break label199;
        }
        if (((xiy)localList.get(i)).a.equals(xih.a(this.a)))
        {
          if (localList.size() <= i + 1) {
            break;
          }
          xih.a(this.a, ((xiy)localList.get(i + 1)).a);
          break;
        }
        i += 1;
      }
    }
  }
  
  public void a(xix paramxix, String paramString, boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xij
 * JD-Core Version:    0.7.0.1
 */