import com.tencent.mobileqq.activity.RegisterActivity;

class bgq
  implements Runnable
{
  bgq(bgp parambgp) {}
  
  public void run()
  {
    RegisterActivity.d(this.a.a);
    RegisterActivity.a(this.a.a, "请重新发送短信");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     bgq
 * JD-Core Version:    0.7.0.1
 */