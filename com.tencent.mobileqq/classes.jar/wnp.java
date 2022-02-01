import java.util.List;

class wnp
  implements wof
{
  wnp(wnn paramwnn) {}
  
  public void a()
  {
    wnn.a(this.a, this.a.a.a(wnn.a(this.a), 5));
    List localList = wnn.a(this.a).a;
    if ((wnn.a(this.a) == null) && (localList.size() > 0)) {
      wnn.a(this.a, ((woe)localList.get(0)).a);
    }
    label199:
    for (;;)
    {
      xvv.d("Q.qqstory.player.data.SimpleDataProvider", "current group:%s", new Object[] { wnn.a(this.a) });
      wnn.a(this.a).a(wnn.a(this.a), "");
      return;
      int i = 0;
      for (;;)
      {
        if (i >= localList.size()) {
          break label199;
        }
        if (((woe)localList.get(i)).a.equals(wnn.a(this.a)))
        {
          if (localList.size() <= i + 1) {
            break;
          }
          wnn.a(this.a, ((woe)localList.get(i + 1)).a);
          break;
        }
        i += 1;
      }
    }
  }
  
  public void a(wod paramwod, String paramString, boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wnp
 * JD-Core Version:    0.7.0.1
 */