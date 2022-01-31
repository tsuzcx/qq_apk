import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.Iterator;
import java.util.List;

class vgm
  extends QQUIEventReceiver<vgd, vmg>
{
  public vgm(@NonNull vgd paramvgd)
  {
    super(paramvgd);
  }
  
  public void a(@NonNull vgd paramvgd, @NonNull vmg paramvmg)
  {
    vgn localvgn = paramvgd.jdField_a_of_type_Vgn;
    int i = paramvmg.jdField_a_of_type_Int;
    paramvmg = paramvmg.jdField_a_of_type_JavaUtilList;
    paramvgd = paramvgd.jdField_a_of_type_Vow;
    if (localvgn != null)
    {
      if (i != 0)
      {
        veg.b(this.TAG, "DoodleEmojiPoiPostersReceiver, location failed.");
        paramvgd.jdField_a_of_type_Boolean = false;
        localvgn.a(paramvgd);
        vem.a("0X80076CD");
        vem.b("0X80075E2");
        return;
      }
      veg.b(this.TAG, "DoodleEmojiPoiPostersReceiver, location success.");
      paramvgd.jdField_a_of_type_JavaUtilList.clear();
      paramvmg = paramvmg.iterator();
      while (paramvmg.hasNext())
      {
        teh localteh = (teh)paramvmg.next();
        if ((TextUtils.isEmpty(localteh.d)) || (TextUtils.isEmpty(localteh.a)) || (TextUtils.isEmpty(localteh.b))) {
          veg.d(this.TAG, "find illegal content : url=%s, name=%s, des=%s", new Object[] { localteh.d, localteh.a, localteh.b });
        }
        vox localvox = new vox();
        localvox.d = localteh.d;
        localvox.b = localteh.a;
        localvox.c = localteh.b;
        localvox.a = localteh.c;
        localvox.e = localteh.e;
        paramvgd.jdField_a_of_type_JavaUtilList.add(localvox);
      }
      paramvgd.jdField_a_of_type_Boolean = false;
      localvgn.a(paramvgd);
      return;
    }
    veg.b(this.TAG, "DoodleEmojiPoiPostersReceiver adapter is null");
  }
  
  public Class acceptEventClass()
  {
    return vmg.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vgm
 * JD-Core Version:    0.7.0.1
 */