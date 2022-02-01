import com.tencent.qphone.base.util.QLog;

class sxt
  implements sxv
{
  sxt(sxn paramsxn) {}
  
  public void onEnterAnimationEnd()
  {
    if (QLog.isColorLevel()) {
      QLog.d("GalleryComponent", 2, "image list onEnterAnimationEnd");
    }
    this.a.onEnterAnimationEnd();
  }
  
  public void onEnterAnimationStart()
  {
    this.a.onEnterAnimationStart();
  }
  
  public void onExitAnimationEnd()
  {
    if (QLog.isColorLevel()) {
      QLog.d("GalleryComponent", 2, "image list onExitAnimationEnd");
    }
    this.a.onExitAnimationEnd();
  }
  
  public void onExitAnimationStart()
  {
    this.a.onExitAnimationStart();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     sxt
 * JD-Core Version:    0.7.0.1
 */