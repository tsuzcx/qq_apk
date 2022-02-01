import java.util.List;

class qgo
  implements qgy.e
{
  qgo(qgn paramqgn) {}
  
  public void a(qgy.c paramc, String paramString, boolean paramBoolean) {}
  
  public void bok()
  {
    qgn.a(this.a, this.a.a.a(qgn.a(this.a), 5));
    List localList = qgn.a(this.a).nP;
    if ((qgn.a(this.a) == null) && (localList.size() > 0)) {
      qgn.a(this.a, ((qgy.d)localList.get(0)).d);
    }
    label193:
    for (;;)
    {
      qgn.a(this.a).d(qgn.a(this.a), "");
      ram.w("Q.qqstory.player.data.SimpleDataProvider", "current group:%s", new Object[] { qgn.a(this.a) });
      return;
      int i = 0;
      for (;;)
      {
        if (i >= localList.size()) {
          break label193;
        }
        if (((qgy.d)localList.get(i)).d.equals(qgn.a(this.a)))
        {
          i -= 1;
          if (i < 0) {
            break;
          }
          qgn.a(this.a, ((qgy.d)localList.get(i)).d);
          break;
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qgo
 * JD-Core Version:    0.7.0.1
 */