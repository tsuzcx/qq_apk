import com.tencent.biz.qqstory.takevideo.doodle.ui.face.FaceListPage.a;

class rch
  implements FaceListPage.a
{
  rch(rcc paramrcc) {}
  
  public void bsI()
  {
    ram.d("Q.qqstory.publish.edit.StoryDoodle", "用户点击重新拉取地理贴纸");
    rcc.a(this.this$0);
  }
  
  public void cancel(String paramString)
  {
    ram.d("Q.qqstory.publish.edit.StoryDoodle", "用户点击下载取消：" + paramString);
  }
  
  public void fM(String paramString)
  {
    ram.d("Q.qqstory.publish.edit.StoryDoodle", "用户点击下载：" + paramString);
    rdc localrdc = this.this$0.b;
    if (this.this$0.b.La()) {}
    for (String str = "2";; str = "1")
    {
      localrdc.c("download_face", 0, 0, new String[] { str, paramString });
      ras.sp("0X80075DD");
      if (!((rgp)psx.a(8)).s(paramString, true)) {
        ram.w("Q.qqstory.publish.edit.StoryDoodle", "用户点击下载启动失败");
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rch
 * JD-Core Version:    0.7.0.1
 */