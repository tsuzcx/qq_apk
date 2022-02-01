class wtw
  implements wvd
{
  wtw(wtv paramwtv) {}
  
  public void a(boolean paramBoolean, wuz paramwuz)
  {
    yuk.b("WeatherDataProvider", "WeatherLbsListener: onLbsUpdate, isSuccess=" + paramBoolean);
    if ((paramBoolean) && (paramwuz != null))
    {
      this.a.a(paramwuz.b, paramwuz.a);
      return;
    }
    this.a.a(false, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wtw
 * JD-Core Version:    0.7.0.1
 */