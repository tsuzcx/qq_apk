class ywm
  implements zew
{
  ywm(ywh paramywh) {}
  
  public void a()
  {
    yuk.b("Q.qqstory.publish.edit.StoryDoodle", "用户点击重新拉取地理贴纸");
    ywh.a(this.a);
  }
  
  public void a(String paramString)
  {
    yuk.b("Q.qqstory.publish.edit.StoryDoodle", "用户点击下载：" + paramString);
    yxt localyxt = this.a.a;
    if (this.a.a.a()) {}
    for (String str = "2";; str = "1")
    {
      localyxt.a("download_face", 0, 0, new String[] { str, paramString });
      yuq.b("0X80075DD");
      if (!((zbz)wth.a(8)).a(paramString, true)) {
        yuk.d("Q.qqstory.publish.edit.StoryDoodle", "用户点击下载启动失败");
      }
      return;
    }
  }
  
  public void b(String paramString)
  {
    yuk.b("Q.qqstory.publish.edit.StoryDoodle", "用户点击下载取消：" + paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ywm
 * JD-Core Version:    0.7.0.1
 */