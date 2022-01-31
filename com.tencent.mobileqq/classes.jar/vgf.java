class vgf
  implements vop
{
  vgf(vga paramvga) {}
  
  public void a()
  {
    ved.b("Q.qqstory.publish.edit.StoryDoodle", "用户点击重新拉取地理贴纸");
    vga.a(this.a);
  }
  
  public void a(String paramString)
  {
    ved.b("Q.qqstory.publish.edit.StoryDoodle", "用户点击下载：" + paramString);
    vhm localvhm = this.a.a;
    if (this.a.a.a()) {}
    for (String str = "2";; str = "1")
    {
      localvhm.a("download_face", 0, 0, new String[] { str, paramString });
      vej.b("0X80075DD");
      if (!((vls)tcz.a(8)).a(paramString, true)) {
        ved.d("Q.qqstory.publish.edit.StoryDoodle", "用户点击下载启动失败");
      }
      return;
    }
  }
  
  public void b(String paramString)
  {
    ved.b("Q.qqstory.publish.edit.StoryDoodle", "用户点击下载取消：" + paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vgf
 * JD-Core Version:    0.7.0.1
 */