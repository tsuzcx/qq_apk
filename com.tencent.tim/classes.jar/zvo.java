import com.tencent.mobileqq.activity.photo.LocalMediaInfo;

class zvo
  implements awdr.a
{
  zvo(zvm paramzvm, LocalMediaInfo paramLocalMediaInfo) {}
  
  public void bX(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if ((this.f.rotation == 90) && (this.f.mediaWidth < this.f.mediaHeight))
      {
        int i = this.f.mediaHeight;
        this.f.mediaHeight = this.f.mediaWidth;
        this.f.mediaWidth = i;
        this.f.setPanoramaType();
      }
    }
    else {
      return;
    }
    this.f.setPanoramaType();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zvo
 * JD-Core Version:    0.7.0.1
 */