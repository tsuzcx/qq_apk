import android.widget.ImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.CardProfile;

class alhs
  implements ajqh.d
{
  alhs(alhr paramalhr, CardProfile paramCardProfile, ImageView paramImageView) {}
  
  public void cA(String paramString, boolean paramBoolean)
  {
    this.this$0.a(this.b, this.bI, paramBoolean);
    QQAppInterface localQQAppInterface = this.this$0.app;
    String str1;
    if (this.b.type == 3)
    {
      str1 = "1";
      if (!paramBoolean) {
        break label69;
      }
    }
    label69:
    for (String str2 = "2";; str2 = "1")
    {
      ajqh.b(localQQAppInterface, "detail_like", paramString, str1, "", "", str2);
      return;
      str1 = "2";
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alhs
 * JD-Core Version:    0.7.0.1
 */