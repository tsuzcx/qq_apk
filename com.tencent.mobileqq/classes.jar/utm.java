class utm
  implements vbw
{
  utm(uth paramuth) {}
  
  public void a()
  {
    urk.b("Q.qqstory.publish.edit.StoryDoodle", "用户点击重新拉取地理贴纸");
    uth.a(this.a);
  }
  
  public void a(String paramString)
  {
    urk.b("Q.qqstory.publish.edit.StoryDoodle", "用户点击下载：" + paramString);
    uut localuut = this.a.a;
    if (this.a.a.a()) {}
    for (String str = "2";; str = "1")
    {
      localuut.a("download_face", 0, 0, new String[] { str, paramString });
      urq.b("0X80075DD");
      if (!((uyz)sqg.a(8)).a(paramString, true)) {
        urk.d("Q.qqstory.publish.edit.StoryDoodle", "用户点击下载启动失败");
      }
      return;
    }
  }
  
  public void b(String paramString)
  {
    urk.b("Q.qqstory.publish.edit.StoryDoodle", "用户点击下载取消：" + paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     utm
 * JD-Core Version:    0.7.0.1
 */