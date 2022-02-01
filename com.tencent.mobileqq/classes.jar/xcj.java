import java.util.List;

class xcj
  implements xda
{
  xcj(xci paramxci) {}
  
  public void a()
  {
    xci.a(this.a, this.a.a.a(xci.a(this.a), 5));
    List localList = xci.a(this.a).a;
    if ((xci.a(this.a) == null) && (localList.size() > 0)) {
      xci.a(this.a, ((xcz)localList.get(0)).a);
    }
    label193:
    for (;;)
    {
      xci.a(this.a).a(xci.a(this.a), "");
      ykq.d("Q.qqstory.player.data.SimpleDataProvider", "current group:%s", new Object[] { xci.a(this.a) });
      return;
      int i = 0;
      for (;;)
      {
        if (i >= localList.size()) {
          break label193;
        }
        if (((xcz)localList.get(i)).a.equals(xci.a(this.a)))
        {
          i -= 1;
          if (i < 0) {
            break;
          }
          xci.a(this.a, ((xcz)localList.get(i)).a);
          break;
        }
        i += 1;
      }
    }
  }
  
  public void a(xcy paramxcy, String paramString, boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xcj
 * JD-Core Version:    0.7.0.1
 */