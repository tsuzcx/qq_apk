import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.Iterator;
import java.util.List;

class wvb
  extends QQUIEventReceiver<wus, xav>
{
  public wvb(@NonNull wus paramwus)
  {
    super(paramwus);
  }
  
  public void a(@NonNull wus paramwus, @NonNull xav paramxav)
  {
    wvc localwvc = paramwus.jdField_a_of_type_Wvc;
    int i = paramxav.jdField_a_of_type_Int;
    paramxav = paramxav.jdField_a_of_type_JavaUtilList;
    paramwus = paramwus.jdField_a_of_type_Xdl;
    if (localwvc != null)
    {
      if (i != 0)
      {
        wsv.b(this.TAG, "DoodleEmojiPoiPostersReceiver, location failed.");
        paramwus.jdField_a_of_type_Boolean = false;
        localwvc.a(paramwus);
        wtb.a("0X80076CD");
        wtb.b("0X80075E2");
        return;
      }
      wsv.b(this.TAG, "DoodleEmojiPoiPostersReceiver, location success.");
      paramwus.jdField_a_of_type_JavaUtilList.clear();
      paramxav = paramxav.iterator();
      while (paramxav.hasNext())
      {
        usw localusw = (usw)paramxav.next();
        if ((TextUtils.isEmpty(localusw.d)) || (TextUtils.isEmpty(localusw.a)) || (TextUtils.isEmpty(localusw.b))) {
          wsv.d(this.TAG, "find illegal content : url=%s, name=%s, des=%s", new Object[] { localusw.d, localusw.a, localusw.b });
        }
        xdm localxdm = new xdm();
        localxdm.d = localusw.d;
        localxdm.b = localusw.a;
        localxdm.c = localusw.b;
        localxdm.a = localusw.c;
        localxdm.e = localusw.e;
        paramwus.jdField_a_of_type_JavaUtilList.add(localxdm);
      }
      paramwus.jdField_a_of_type_Boolean = false;
      localwvc.a(paramwus);
      return;
    }
    wsv.b(this.TAG, "DoodleEmojiPoiPostersReceiver adapter is null");
  }
  
  public Class acceptEventClass()
  {
    return xav.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wvb
 * JD-Core Version:    0.7.0.1
 */