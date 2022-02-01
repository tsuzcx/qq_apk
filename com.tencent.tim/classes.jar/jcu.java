import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.QavOperationMenuView;
import com.tencent.av.ui.beauty.BeautySeekView.a;

public class jcu
  implements BeautySeekView.a
{
  public jcu(QavOperationMenuView paramQavOperationMenuView) {}
  
  public void j(String paramString, int paramInt1, int paramInt2)
  {
    switch (paramInt1)
    {
    case 1: 
    default: 
    case 2: 
      do
      {
        return;
      } while (this.a.mApp == null);
      this.a.mApp.c(paramString, paramInt2, false);
      return;
    }
    if (this.a.mApp != null) {
      this.a.mApp.c(paramString, paramInt2, true);
    }
    jjk.onClick(2131374122);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jcu
 * JD-Core Version:    0.7.0.1
 */