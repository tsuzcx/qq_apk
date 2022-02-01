import android.widget.TextView;

class avmp
  implements avfw.a
{
  avmp(avml paramavml) {}
  
  public void Wz(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      avoc.e("ReaderSplashImpl", "jumpToPlugin: openPlugin: failed");
      if (avml.a(this.a) != null) {
        avml.a(this.a).setText("跳转失败，请返回重试");
      }
      return;
    }
    avoc.i("ReaderSplashImpl", "jumpToPlugin: openPlugin: succeed");
    avml.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avmp
 * JD-Core Version:    0.7.0.1
 */