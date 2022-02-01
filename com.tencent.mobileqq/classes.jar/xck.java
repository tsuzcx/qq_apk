import java.util.List;

class xck
  implements xda
{
  xck(xci paramxci) {}
  
  public void a()
  {
    xci.a(this.a, this.a.a.a(xci.a(this.a), 5));
    List localList = xci.a(this.a).a;
    if ((xci.a(this.a) == null) && (localList.size() > 0)) {
      xci.a(this.a, ((xcz)localList.get(0)).a);
    }
    label199:
    for (;;)
    {
      ykq.d("Q.qqstory.player.data.SimpleDataProvider", "current group:%s", new Object[] { xci.a(this.a) });
      xci.a(this.a).a(xci.a(this.a), "");
      return;
      int i = 0;
      for (;;)
      {
        if (i >= localList.size()) {
          break label199;
        }
        if (((xcz)localList.get(i)).a.equals(xci.a(this.a)))
        {
          if (localList.size() <= i + 1) {
            break;
          }
          xci.a(this.a, ((xcz)localList.get(i + 1)).a);
          break;
        }
        i += 1;
      }
    }
  }
  
  public void a(xcy paramxcy, String paramString, boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xck
 * JD-Core Version:    0.7.0.1
 */