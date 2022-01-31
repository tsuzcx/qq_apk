import com.tencent.qphone.base.util.QLog;

class wtu
  implements bgxw
{
  public void a(bgya parambgya, int paramInt)
  {
    if (paramInt <= 1) {
      return;
    }
    wtt.a().a(parambgya.a, paramInt);
  }
  
  public void a(bgya parambgya, boolean paramBoolean)
  {
    if (parambgya == null) {
      return;
    }
    parambgya.e = false;
    if (paramBoolean) {
      parambgya.d = true;
    }
    for (;;)
    {
      wtt.a().a(parambgya, paramBoolean);
      wtt.a(wtt.a(), parambgya.a);
      return;
      QLog.e("PlayDownloadManagerWrap", 1, "download failed with id: " + parambgya.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     wtu
 * JD-Core Version:    0.7.0.1
 */