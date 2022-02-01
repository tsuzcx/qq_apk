import com.tencent.qphone.base.util.QLog;

public class lvl
{
  private static volatile lvl a;
  private boolean alB;
  
  public static lvl a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new lvl();
      }
      return a;
    }
    finally {}
  }
  
  private void q(String paramString1, int paramInt, String paramString2)
  {
    paramString1 = new lwc.a().a("name", paramString1).a("resCode", "" + paramInt).a("version", paramString2).build();
    if (paramInt == 0)
    {
      lwc.f("0X800A832", "", "", "", paramString1);
      return;
    }
    lwc.f("0X800A833", "", "", "", paramString1);
  }
  
  public boolean CM()
  {
    return this.alB;
  }
  
  public void load(String paramString)
  {
    QLog.i("PTSSoLoader", 1, "[load], name = " + paramString);
    anmc.a().a(paramString, new lvm(this, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lvl
 * JD-Core Version:    0.7.0.1
 */