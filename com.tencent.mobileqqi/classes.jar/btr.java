import com.tencent.biz.troop.TroopMemberApiPlugin;

class btr
  implements Runnable
{
  btr(btq parambtq) {}
  
  public void run()
  {
    try
    {
      TroopMemberApiPlugin.a(this.a.a, this.a.a.i, this.a.a.e);
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      this.a.a.callJs(this.a.a.i, new String[] { "[]" });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     btr
 * JD-Core Version:    0.7.0.1
 */