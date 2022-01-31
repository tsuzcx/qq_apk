import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.Iterator;
import java.util.List;

class vgj
  extends QQUIEventReceiver<vga, vmd>
{
  public vgj(@NonNull vga paramvga)
  {
    super(paramvga);
  }
  
  public void a(@NonNull vga paramvga, @NonNull vmd paramvmd)
  {
    vgk localvgk = paramvga.jdField_a_of_type_Vgk;
    int i = paramvmd.jdField_a_of_type_Int;
    paramvmd = paramvmd.jdField_a_of_type_JavaUtilList;
    paramvga = paramvga.jdField_a_of_type_Vot;
    if (localvgk != null)
    {
      if (i != 0)
      {
        ved.b(this.TAG, "DoodleEmojiPoiPostersReceiver, location failed.");
        paramvga.jdField_a_of_type_Boolean = false;
        localvgk.a(paramvga);
        vej.a("0X80076CD");
        vej.b("0X80075E2");
        return;
      }
      ved.b(this.TAG, "DoodleEmojiPoiPostersReceiver, location success.");
      paramvga.jdField_a_of_type_JavaUtilList.clear();
      paramvmd = paramvmd.iterator();
      while (paramvmd.hasNext())
      {
        tee localtee = (tee)paramvmd.next();
        if ((TextUtils.isEmpty(localtee.d)) || (TextUtils.isEmpty(localtee.a)) || (TextUtils.isEmpty(localtee.b))) {
          ved.d(this.TAG, "find illegal content : url=%s, name=%s, des=%s", new Object[] { localtee.d, localtee.a, localtee.b });
        }
        vou localvou = new vou();
        localvou.d = localtee.d;
        localvou.b = localtee.a;
        localvou.c = localtee.b;
        localvou.a = localtee.c;
        localvou.e = localtee.e;
        paramvga.jdField_a_of_type_JavaUtilList.add(localvou);
      }
      paramvga.jdField_a_of_type_Boolean = false;
      localvgk.a(paramvga);
      return;
    }
    ved.b(this.TAG, "DoodleEmojiPoiPostersReceiver adapter is null");
  }
  
  public Class acceptEventClass()
  {
    return vmd.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vgj
 * JD-Core Version:    0.7.0.1
 */