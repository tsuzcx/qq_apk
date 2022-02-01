import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;

class ayow
  implements qsi.a
{
  ayow(ayov paramayov) {}
  
  public boolean Kt()
  {
    return false;
  }
  
  public void bqc()
  {
    this.b.dismiss();
  }
  
  public void tl(boolean paramBoolean)
  {
    if (ayov.a(this.b).Kv())
    {
      rar.a("video_edit", "repost_comment", 0, 0, new String[] { "", "", "", ayov.a(this.b).a.getStringExtra("vip_forward_vid") });
      return;
    }
    rar.a("video_edit", "repost_emoji", 0, 0, new String[] { "", "", "", ayov.a(this.b).a.getStringExtra("vip_forward_vid") });
  }
  
  public void tm(boolean paramBoolean)
  {
    if ((!ayov.a(this.b).Ks()) && (!ayov.a(this.b).Kw())) {
      this.b.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayow
 * JD-Core Version:    0.7.0.1
 */