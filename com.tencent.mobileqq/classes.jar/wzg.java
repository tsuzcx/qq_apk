class wzg
  implements xhq
{
  wzg(wzb paramwzb) {}
  
  public void a()
  {
    wxe.b("Q.qqstory.publish.edit.StoryDoodle", "用户点击重新拉取地理贴纸");
    wzb.a(this.a);
  }
  
  public void a(String paramString)
  {
    wxe.b("Q.qqstory.publish.edit.StoryDoodle", "用户点击下载：" + paramString);
    xan localxan = this.a.a;
    if (this.a.a.a()) {}
    for (String str = "2";; str = "1")
    {
      localxan.a("download_face", 0, 0, new String[] { str, paramString });
      wxk.b("0X80075DD");
      if (!((xet)uwa.a(8)).a(paramString, true)) {
        wxe.d("Q.qqstory.publish.edit.StoryDoodle", "用户点击下载启动失败");
      }
      return;
    }
  }
  
  public void b(String paramString)
  {
    wxe.b("Q.qqstory.publish.edit.StoryDoodle", "用户点击下载取消：" + paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wzg
 * JD-Core Version:    0.7.0.1
 */