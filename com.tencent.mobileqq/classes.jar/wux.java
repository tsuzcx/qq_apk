class wux
  implements xdh
{
  wux(wus paramwus) {}
  
  public void a()
  {
    wsv.b("Q.qqstory.publish.edit.StoryDoodle", "用户点击重新拉取地理贴纸");
    wus.a(this.a);
  }
  
  public void a(String paramString)
  {
    wsv.b("Q.qqstory.publish.edit.StoryDoodle", "用户点击下载：" + paramString);
    wwe localwwe = this.a.a;
    if (this.a.a.a()) {}
    for (String str = "2";; str = "1")
    {
      localwwe.a("download_face", 0, 0, new String[] { str, paramString });
      wtb.b("0X80075DD");
      if (!((xak)urr.a(8)).a(paramString, true)) {
        wsv.d("Q.qqstory.publish.edit.StoryDoodle", "用户点击下载启动失败");
      }
      return;
    }
  }
  
  public void b(String paramString)
  {
    wsv.b("Q.qqstory.publish.edit.StoryDoodle", "用户点击下载取消：" + paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wux
 * JD-Core Version:    0.7.0.1
 */