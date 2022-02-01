class ysr
  implements zbb
{
  ysr(ysm paramysm) {}
  
  public void a()
  {
    yqp.b("Q.qqstory.publish.edit.StoryDoodle", "用户点击重新拉取地理贴纸");
    ysm.a(this.a);
  }
  
  public void a(String paramString)
  {
    yqp.b("Q.qqstory.publish.edit.StoryDoodle", "用户点击下载：" + paramString);
    yty localyty = this.a.a;
    if (this.a.a.a()) {}
    for (String str = "2";; str = "1")
    {
      localyty.a("download_face", 0, 0, new String[] { str, paramString });
      yqv.b("0X80075DD");
      if (!((yye)wpm.a(8)).a(paramString, true)) {
        yqp.d("Q.qqstory.publish.edit.StoryDoodle", "用户点击下载启动失败");
      }
      return;
    }
  }
  
  public void b(String paramString)
  {
    yqp.b("Q.qqstory.publish.edit.StoryDoodle", "用户点击下载取消：" + paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ysr
 * JD-Core Version:    0.7.0.1
 */