class vgi
  implements vos
{
  vgi(vgd paramvgd) {}
  
  public void a()
  {
    veg.b("Q.qqstory.publish.edit.StoryDoodle", "用户点击重新拉取地理贴纸");
    vgd.a(this.a);
  }
  
  public void a(String paramString)
  {
    veg.b("Q.qqstory.publish.edit.StoryDoodle", "用户点击下载：" + paramString);
    vhp localvhp = this.a.a;
    if (this.a.a.a()) {}
    for (String str = "2";; str = "1")
    {
      localvhp.a("download_face", 0, 0, new String[] { str, paramString });
      vem.b("0X80075DD");
      if (!((vlv)tdc.a(8)).a(paramString, true)) {
        veg.d("Q.qqstory.publish.edit.StoryDoodle", "用户点击下载启动失败");
      }
      return;
    }
  }
  
  public void b(String paramString)
  {
    veg.b("Q.qqstory.publish.edit.StoryDoodle", "用户点击下载取消：" + paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vgi
 * JD-Core Version:    0.7.0.1
 */