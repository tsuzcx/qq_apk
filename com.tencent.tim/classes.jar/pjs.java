class pjs
  implements jox
{
  pjs(pjq parampjq, boolean paramBoolean) {}
  
  public void loaded(String paramString, int paramInt)
  {
    ram.b("Q.qqstory.recommendAlbum.logic.StoryAlbumResourceDownloader", "checkResource loaded code = %d ", Integer.valueOf(paramInt));
    switch (paramInt)
    {
    case -1: 
    case 1: 
    case 2: 
    case 3: 
    case 4: 
    case 5: 
    case 6: 
    case 7: 
    default: 
      return;
    }
    if (this.aAg) {
      pjq.a(this.this$0);
    }
    ram.b("Q.qqstory.recommendAlbum.logic.StoryAlbumResourceDownloader", "checkResource download success", Integer.valueOf(paramInt));
  }
  
  public void progress(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pjs
 * JD-Core Version:    0.7.0.1
 */