import android.view.View;
import com.tencent.image.Utils;
import java.io.File;

class akbq
  implements ausj.a
{
  akbq(akbp paramakbp, ausj paramausj, File paramFile, String paramString) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    this.val$actionSheet.dismiss();
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      xtm.a(akbp.a(this.a), this.val$file, Utils.Crc64String(this.val$file.getAbsolutePath()));
      return;
    }
    akbp.a(this.a, this.bSY);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akbq
 * JD-Core Version:    0.7.0.1
 */