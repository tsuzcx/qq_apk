import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.Iterator;
import java.util.List;

class wzk
  extends QQUIEventReceiver<wzb, xfe>
{
  public wzk(@NonNull wzb paramwzb)
  {
    super(paramwzb);
  }
  
  public void a(@NonNull wzb paramwzb, @NonNull xfe paramxfe)
  {
    wzl localwzl = paramwzb.jdField_a_of_type_Wzl;
    int i = paramxfe.jdField_a_of_type_Int;
    paramxfe = paramxfe.jdField_a_of_type_JavaUtilList;
    paramwzb = paramwzb.jdField_a_of_type_Xhu;
    if (localwzl != null)
    {
      if (i != 0)
      {
        wxe.b(this.TAG, "DoodleEmojiPoiPostersReceiver, location failed.");
        paramwzb.jdField_a_of_type_Boolean = false;
        localwzl.a(paramwzb);
        wxk.a("0X80076CD");
        wxk.b("0X80075E2");
        return;
      }
      wxe.b(this.TAG, "DoodleEmojiPoiPostersReceiver, location success.");
      paramwzb.jdField_a_of_type_JavaUtilList.clear();
      paramxfe = paramxfe.iterator();
      while (paramxfe.hasNext())
      {
        uxf localuxf = (uxf)paramxfe.next();
        if ((TextUtils.isEmpty(localuxf.d)) || (TextUtils.isEmpty(localuxf.a)) || (TextUtils.isEmpty(localuxf.b))) {
          wxe.d(this.TAG, "find illegal content : url=%s, name=%s, des=%s", new Object[] { localuxf.d, localuxf.a, localuxf.b });
        }
        xhv localxhv = new xhv();
        localxhv.d = localuxf.d;
        localxhv.b = localuxf.a;
        localxhv.c = localuxf.b;
        localxhv.a = localuxf.c;
        localxhv.e = localuxf.e;
        paramwzb.jdField_a_of_type_JavaUtilList.add(localxhv);
      }
      paramwzb.jdField_a_of_type_Boolean = false;
      localwzl.a(paramwzb);
      return;
    }
    wxe.b(this.TAG, "DoodleEmojiPoiPostersReceiver adapter is null");
  }
  
  public Class acceptEventClass()
  {
    return xfe.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wzk
 * JD-Core Version:    0.7.0.1
 */