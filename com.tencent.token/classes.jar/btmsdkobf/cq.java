package btmsdkobf;

import java.util.ArrayList;

class cq
  implements Runnable
{
  cq(be parambe, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    String str1 = be.d(this.a);
    long l = System.currentTimeMillis();
    String str2 = be.a(this.c).getString(str1, null);
    if ((str2 != null) && (str2.length() > 8192)) {}
    Object localObject1;
    do
    {
      return;
      localObject1 = new ArrayList();
      localObject2 = new bd();
      ((bd)localObject2).fr = this.a;
      ((bd)localObject2).ft = l;
      ((bd)localObject2).fs = 1;
      ((bd)localObject2).errorCode = this.b;
      ((ArrayList)localObject1).add(localObject2);
      localObject1 = be.a((ArrayList)localObject1);
    } while (localObject1 == null);
    Object localObject2 = new StringBuilder();
    if (str2 != null) {
      ((StringBuilder)localObject2).append(str2);
    }
    ((StringBuilder)localObject2).append((String)localObject1);
    be.a(this.c).putString(str1, ((StringBuilder)localObject2).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.cq
 * JD-Core Version:    0.7.0.1
 */