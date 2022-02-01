class pwd
  extends acbo
{
  pwd(pvz parampvz) {}
  
  protected void wc(int paramInt)
  {
    if (paramInt == 1)
    {
      ram.d(pvz.access$100() + ".VASH", "Friend Cache Inited!");
      pvz.aCs = true;
      this.this$0.a.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pwd
 * JD-Core Version:    0.7.0.1
 */