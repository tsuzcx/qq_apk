import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.Iterator;
import java.util.List;

class ywq
  extends QQUIEventReceiver<ywh, zck>
{
  public ywq(@NonNull ywh paramywh)
  {
    super(paramywh);
  }
  
  public void a(@NonNull ywh paramywh, @NonNull zck paramzck)
  {
    ywr localywr = paramywh.jdField_a_of_type_Ywr;
    int i = paramzck.jdField_a_of_type_Int;
    paramzck = paramzck.jdField_a_of_type_JavaUtilList;
    paramywh = paramywh.jdField_a_of_type_Zfa;
    if (localywr != null)
    {
      if (i != 0)
      {
        yuk.b(this.TAG, "DoodleEmojiPoiPostersReceiver, location failed.");
        paramywh.jdField_a_of_type_Boolean = false;
        localywr.a(paramywh);
        yuq.a("0X80076CD");
        yuq.b("0X80075E2");
        return;
      }
      yuk.b(this.TAG, "DoodleEmojiPoiPostersReceiver, location success.");
      paramywh.jdField_a_of_type_JavaUtilList.clear();
      paramzck = paramzck.iterator();
      while (paramzck.hasNext())
      {
        wum localwum = (wum)paramzck.next();
        if ((TextUtils.isEmpty(localwum.d)) || (TextUtils.isEmpty(localwum.a)) || (TextUtils.isEmpty(localwum.b))) {
          yuk.d(this.TAG, "find illegal content : url=%s, name=%s, des=%s", new Object[] { localwum.d, localwum.a, localwum.b });
        }
        zfb localzfb = new zfb();
        localzfb.d = localwum.d;
        localzfb.b = localwum.a;
        localzfb.c = localwum.b;
        localzfb.a = localwum.c;
        localzfb.e = localwum.e;
        paramywh.jdField_a_of_type_JavaUtilList.add(localzfb);
      }
      paramywh.jdField_a_of_type_Boolean = false;
      localywr.a(paramywh);
      return;
    }
    yuk.b(this.TAG, "DoodleEmojiPoiPostersReceiver adapter is null");
  }
  
  public Class acceptEventClass()
  {
    return zck.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ywq
 * JD-Core Version:    0.7.0.1
 */