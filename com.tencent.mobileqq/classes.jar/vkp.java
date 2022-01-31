import java.util.List;

class vkp
  implements vlf
{
  vkp(vkn paramvkn) {}
  
  public void a()
  {
    vkn.a(this.a, this.a.a.a(vkn.a(this.a), 5));
    List localList = vkn.a(this.a).a;
    if ((vkn.a(this.a) == null) && (localList.size() > 0)) {
      vkn.a(this.a, ((vle)localList.get(0)).a);
    }
    label199:
    for (;;)
    {
      wsv.d("Q.qqstory.player.data.SimpleDataProvider", "current group:%s", new Object[] { vkn.a(this.a) });
      vkn.a(this.a).a(vkn.a(this.a), "");
      return;
      int i = 0;
      for (;;)
      {
        if (i >= localList.size()) {
          break label199;
        }
        if (((vle)localList.get(i)).a.equals(vkn.a(this.a)))
        {
          if (localList.size() <= i + 1) {
            break;
          }
          vkn.a(this.a, ((vle)localList.get(i + 1)).a);
          break;
        }
        i += 1;
      }
    }
  }
  
  public void a(vld paramvld, String paramString, boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vkp
 * JD-Core Version:    0.7.0.1
 */