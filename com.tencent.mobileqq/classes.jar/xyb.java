import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.Iterator;
import java.util.List;

class xyb
  extends QQUIEventReceiver<xxs, yds>
{
  public xyb(@NonNull xxs paramxxs)
  {
    super(paramxxs);
  }
  
  public void a(@NonNull xxs paramxxs, @NonNull yds paramyds)
  {
    xyc localxyc = paramxxs.jdField_a_of_type_Xyc;
    int i = paramyds.jdField_a_of_type_Int;
    paramyds = paramyds.jdField_a_of_type_JavaUtilList;
    paramxxs = paramxxs.jdField_a_of_type_Ygb;
    if (localxyc != null)
    {
      if (i != 0)
      {
        xvv.b(this.TAG, "DoodleEmojiPoiPostersReceiver, location failed.");
        paramxxs.jdField_a_of_type_Boolean = false;
        localxyc.a(paramxxs);
        xwb.a("0X80076CD");
        xwb.b("0X80075E2");
        return;
      }
      xvv.b(this.TAG, "DoodleEmojiPoiPostersReceiver, location success.");
      paramxxs.jdField_a_of_type_JavaUtilList.clear();
      paramyds = paramyds.iterator();
      while (paramyds.hasNext())
      {
        vwc localvwc = (vwc)paramyds.next();
        if ((TextUtils.isEmpty(localvwc.d)) || (TextUtils.isEmpty(localvwc.a)) || (TextUtils.isEmpty(localvwc.b))) {
          xvv.d(this.TAG, "find illegal content : url=%s, name=%s, des=%s", new Object[] { localvwc.d, localvwc.a, localvwc.b });
        }
        ygc localygc = new ygc();
        localygc.d = localvwc.d;
        localygc.b = localvwc.a;
        localygc.c = localvwc.b;
        localygc.a = localvwc.c;
        localygc.e = localvwc.e;
        paramxxs.jdField_a_of_type_JavaUtilList.add(localygc);
      }
      paramxxs.jdField_a_of_type_Boolean = false;
      localxyc.a(paramxxs);
      return;
    }
    xvv.b(this.TAG, "DoodleEmojiPoiPostersReceiver adapter is null");
  }
  
  public Class acceptEventClass()
  {
    return yds.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xyb
 * JD-Core Version:    0.7.0.1
 */