class aydr
  implements aypj.a<Boolean, aypl.c>
{
  aydr(aydp paramaydp) {}
  
  public Void a(Boolean paramBoolean, aypl.c paramc)
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
    this.this$0.a[paramc.index] = aydp.a.a(this.this$0.a[paramc.index], paramc.thumbnail);
    this.this$0.a[paramc.index].azr = paramc.thumbnailPath;
    this.this$0.bsf();
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     aydr
 * JD-Core Version:    0.7.0.1
 */