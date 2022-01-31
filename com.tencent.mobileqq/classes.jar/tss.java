import mqq.app.QQPermissionCallback;

class tss
  implements QQPermissionCallback
{
  tss(tsp paramtsp) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt) {}
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    tsp.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tss
 * JD-Core Version:    0.7.0.1
 */