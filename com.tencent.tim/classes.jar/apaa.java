import android.text.TextUtils.EllipsizeCallback;
import android.widget.TextView;

final class apaa
  implements TextUtils.EllipsizeCallback
{
  apaa(aozz.a parama, String paramString) {}
  
  public void ellipsized(int paramInt1, int paramInt2)
  {
    if (paramInt1 == paramInt2)
    {
      this.a.aap.setText(this.cnC);
      return;
    }
    String str = this.cnC.substring(0, paramInt1);
    this.a.aap.setText(new aofk(jqc.dR(jqc.dS(str + "...")), 3, 14));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apaa
 * JD-Core Version:    0.7.0.1
 */