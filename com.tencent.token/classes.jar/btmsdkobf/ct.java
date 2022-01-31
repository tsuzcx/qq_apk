package btmsdkobf;

import java.util.ArrayList;

class ct
  implements Runnable
{
  ct(be parambe, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    String str = be.d(this.a);
    long l = System.currentTimeMillis();
    Object localObject1 = new ArrayList();
    Object localObject2 = new bd();
    ((bd)localObject2).fr = this.a;
    ((bd)localObject2).ft = l;
    ((bd)localObject2).fs = 1;
    ((bd)localObject2).errorCode = this.b;
    ((ArrayList)localObject1).add(localObject2);
    localObject1 = be.a((ArrayList)localObject1);
    if (localObject1 != null)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      be.a(this.c).putString(str, ((StringBuilder)localObject2).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.ct
 * JD-Core Version:    0.7.0.1
 */