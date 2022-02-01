import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

class aszi
  implements aszd.a
{
  aszi(aszh paramaszh) {}
  
  public void kK(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 1) {
      synchronized (aszh.a(this.this$0))
      {
        Object localObject2 = (List)aszh.a(this.this$0).get(Integer.valueOf(paramInt2));
        if (localObject2 != null)
        {
          aszh.a(this.this$0).remove(Integer.valueOf(paramInt2));
          aszh.a(this.this$0);
        }
        if (localObject2 != null)
        {
          ??? = ((List)localObject2).iterator();
          if (((Iterator)???).hasNext())
          {
            localObject2 = (aszh.a)((Iterator)???).next();
            aszh.a(this.this$0).b(((aszh.a)localObject2).eok, ((aszh.a)localObject2).eor, ((aszh.a)localObject2).mCmd, new Object[] { ((aszh.a)localObject2).mData }, null);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aszi
 * JD-Core Version:    0.7.0.1
 */