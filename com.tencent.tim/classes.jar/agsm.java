import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.colornote.data.ColorNote.a;
import com.tencent.qphone.base.util.QLog;

public class agsm
  implements aebf
{
  public ColorNote getColorNote()
  {
    ColorNote.a locala = new ColorNote.a();
    locala.a(17039360);
    String str = ahbr.F(-1, "");
    if (QLog.isColorLevel()) {
      QLog.i("DefaultFileColorNoteServiceInfo", 2, "getColorNote: file colorNote key [" + str + "]");
    }
    locala.a(str);
    locala.b("default_file");
    locala.c("0MB");
    locala.d("resdrawable://2130845244");
    return locala.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agsm
 * JD-Core Version:    0.7.0.1
 */