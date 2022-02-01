import com.tencent.biz.qqstory.database.PublishVideoEntry;

class poi
  extends axrh
{
  private long mStartTime;
  
  poi(pog parampog, PublishVideoEntry paramPublishVideoEntry, pog.d paramd, String paramString) {}
  
  public void ax(String paramString, boolean paramBoolean)
  {
    ram.i(pog.TAG, "[vs_publish_flow] | fakeid:" + this.c.fakeVid + " music onStart download");
    this.mStartTime = System.currentTimeMillis();
  }
  
  public void c(String paramString, boolean paramBoolean, int paramInt)
  {
    ram.i(pog.TAG, "[vs_publish_flow] | fakeid:" + this.c.fakeVid + " music onStart download onFinish ");
    this.c.backgroundMusicPath = paramString;
    long l1 = System.currentTimeMillis();
    long l2 = this.mStartTime;
    switch (paramInt)
    {
    default: 
      this.a.setCode(paramInt);
      this.a.setMessage("unknown error the music download failed");
    }
    for (;;)
    {
      sqn.n("edit_music_download", sqn.a(this.a.getCode(), l1 - l2, this.atW, rox.getFileSize(paramString)));
      pog.a(this.this$0, "needAndStartDownloadMusic");
      return;
      this.a.setCode(0);
      this.a.setMessage("music downloadSuccess");
      continue;
      this.a.setCode(-2);
      this.a.setMessage("none network");
    }
  }
  
  public void onCancel(String paramString)
  {
    this.a.setCode(-3);
    this.a.setMessage("task canceled");
    pog.a(this.this$0, "needAndStartDownloadMusic");
  }
  
  public void onProgress(String paramString, int paramInt) {}
  
  public void vS(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     poi
 * JD-Core Version:    0.7.0.1
 */