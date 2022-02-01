import android.content.Context;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.colornote.data.ColorNote.a;
import com.tencent.qphone.base.util.QLog;

public class avkf
  implements aebf
{
  private Long g;
  private Context mContext;
  
  public avkf(Context paramContext, Long paramLong)
  {
    this.g = paramLong;
    this.mContext = paramContext;
  }
  
  public ColorNote getColorNote()
  {
    ColorNote.a locala = new ColorNote.a();
    if (QLog.isColorLevel()) {
      QLog.i("FavColorNoteServiceInfo", 2, "getColorNote: colorNote key [" + "qfav" + "]");
    }
    String str1 = this.mContext.getString(2131689770);
    String str2 = this.mContext.getString(2131693407);
    locala.a(17104896);
    locala.a("" + this.g + "-4");
    locala.b(str1);
    locala.c(str2);
    locala.d("resdrawable://2130845034");
    return locala.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avkf
 * JD-Core Version:    0.7.0.1
 */