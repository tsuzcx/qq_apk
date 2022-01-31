class ued
  implements nbs
{
  ued(ueb paramueb, boolean paramBoolean) {}
  
  public void loaded(String paramString, int paramInt)
  {
    wsv.a("Q.qqstory.recommendAlbum.logic.StoryAlbumResourceDownloader", "checkResource loaded code = %d ", Integer.valueOf(paramInt));
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
    if (this.jdField_a_of_type_Boolean) {
      ueb.a(this.jdField_a_of_type_Ueb);
    }
    wsv.a("Q.qqstory.recommendAlbum.logic.StoryAlbumResourceDownloader", "checkResource download success", Integer.valueOf(paramInt));
  }
  
  public void progress(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ued
 * JD-Core Version:    0.7.0.1
 */