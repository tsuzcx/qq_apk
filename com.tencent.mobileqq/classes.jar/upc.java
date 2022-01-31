import android.support.annotation.NonNull;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class upc
  extends QQUIEventReceiver<uoh, tna>
{
  public upc(@NonNull uoh paramuoh)
  {
    super(paramuoh);
  }
  
  public void a(@NonNull uoh paramuoh, @NonNull tna paramtna)
  {
    urk.a(this.TAG, "play video groupId=%s, %s", paramtna.jdField_a_of_type_Tjs, paramtna.b);
    if ((uoh.a(paramuoh).equals(paramtna.jdField_a_of_type_JavaLangString)) && ((paramtna.jdField_a_of_type_Tjs instanceof tjh)))
    {
      uiw localuiw = ((tjh)paramtna.jdField_a_of_type_Tjs).a;
      if (localuiw != null) {
        paramuoh.a(localuiw.jdField_a_of_type_JavaLangString, paramtna.b, true);
      }
    }
  }
  
  public Class acceptEventClass()
  {
    return tna.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     upc
 * JD-Core Version:    0.7.0.1
 */