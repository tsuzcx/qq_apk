class rbj
  implements rjk.a<Boolean, rjm.c>
{
  rbj(rbh paramrbh, long paramLong, int paramInt) {}
  
  public Void a(Boolean paramBoolean, rjm.c paramc)
  {
    if ((!paramBoolean.booleanValue()) || (paramc == null) || (paramc.thumbnail == null))
    {
      ram.e("Q.qqstory.record.EditLocalVideoPlayer", "Generate thumbnail error! thumbnail = (null)");
      return null;
    }
    ram.d("Q.qqstory.record.EditLocalVideoPlayer", "Generate thumbnail index = %d", Integer.valueOf(paramc.index));
    if (paramc.index >= this.this$0.a.length)
    {
      ram.e("Q.qqstory.record.EditLocalVideoPlayer", "Generate thumbnail index = %d OutOfArrayBounds", new Object[] { Integer.valueOf(paramc.index) });
      return null;
    }
    ram.d("Q.qqstory.record.EditLocalVideoPlayer.Flow", "thumbnailProgress index: %d thumbnail done!", Integer.valueOf(paramc.index));
    this.this$0.a[paramc.index] = rbh.a.a(this.this$0.a[paramc.index], paramc.thumbnail);
    this.this$0.a[paramc.index].azr = paramc.thumbnailPath;
    if (paramc.Ce > 0L)
    {
      this.this$0.a[paramc.index].startTime = ((int)paramc.Ce / 1000);
      ram.d("Q.qqstory.record.EditLocalVideoPlayer.Flow", "fix start time : %d ", Integer.valueOf(this.this$0.a[paramc.index].startTime));
      if ((this.this$0.a[paramc.index].endTime <= 0) && (this.this$0.a.length == 1))
      {
        this.this$0.a[paramc.index].endTime = ((int)this.wU);
        ram.d("Q.qqstory.record.EditLocalVideoPlayer.Flow", "fix end time : %d ", Integer.valueOf(this.agy));
      }
    }
    this.this$0.bsf();
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rbj
 * JD-Core Version:    0.7.0.1
 */