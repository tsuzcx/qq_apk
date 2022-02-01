package wf7;

public class ch
{
  static ch hb;
  protected au ha;
  protected final String hc = "free_wifi_marks_high_threshold";
  protected final String hd = "free_wifi_marks_low_threshold";
  private int he = -1;
  private int hf = -1;
  protected final String hg = "one_click_link_count";
  protected final String hh = "one_click_link_score";
  
  public static final ch aP()
  {
    try
    {
      if (hb == null) {
        hb = new ch();
      }
      ch localch = hb;
      return localch;
    }
    finally {}
  }
  
  public void a(au paramau)
  {
    this.ha = paramau;
  }
  
  public int aQ()
  {
    return this.ha.getInt("one_click_link_score", 4);
  }
  
  public String aR()
  {
    return this.ha.getString("push_offline_wifi_uid", "");
  }
  
  public int f(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.he < 0) {
        this.he = this.ha.getInt("free_wifi_marks_high_threshold", 4);
      }
      return this.he;
    }
    if (this.hf < 0) {
      this.hf = this.ha.getInt("free_wifi_marks_low_threshold", 1);
    }
    return this.hf;
  }
  
  public boolean getBoolean(String paramString, boolean paramBoolean)
  {
    return this.ha.getBoolean(paramString, paramBoolean);
  }
  
  public String getString(String paramString1, String paramString2)
  {
    return this.ha.getString(paramString1, paramString2);
  }
  
  public void putString(String paramString1, String paramString2)
  {
    this.ha.b(paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     wf7.ch
 * JD-Core Version:    0.7.0.1
 */