class pvx
  implements pvi.b
{
  private long Ax;
  
  pvx(pvv parampvv) {}
  
  public void onFinish()
  {
    if (this.Ax != 0L) {
      rar.b("msgtab", "preload_time", (int)(System.currentTimeMillis() - this.Ax), 0, new String[0]);
    }
  }
  
  public void onStart()
  {
    this.Ax = System.currentTimeMillis();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pvx
 * JD-Core Version:    0.7.0.1
 */