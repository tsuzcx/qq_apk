import android.content.AsyncQueryHandler;
import android.content.Context;
import android.database.Cursor;
import com.tencent.mobileqq.adapter.ForwardFriendListAdapter;
import java.util.Map;

public final class fcs
  extends AsyncQueryHandler
{
  public fcs(ForwardFriendListAdapter paramForwardFriendListAdapter, Context paramContext)
  {
    super(paramContext.getContentResolver());
  }
  
  public void onQueryComplete(int paramInt, Object paramObject, Cursor paramCursor)
  {
    if (paramCursor == null) {}
    label266:
    for (;;)
    {
      return;
      int j = this.a.getGroupCount();
      int k = (int)this.a.getGroupId(j - 1);
      int i = 0;
      for (;;)
      {
        if (i >= j) {
          break label266;
        }
        long l = this.a.getGroupId(i);
        if (l == paramInt)
        {
          if (i == 0)
          {
            this.a.c = 0;
            this.a.jdField_b_of_type_JavaUtilMap.clear();
          }
          if ((j <= 1) && (!this.a.jdField_b_of_type_JavaUtilMap.containsKey(Long.valueOf(l))))
          {
            paramObject = this.a;
            paramObject.c += paramCursor.getCount();
            this.a.jdField_b_of_type_JavaUtilMap.put(Long.valueOf(l), Boolean.valueOf(true));
          }
          if (l == k)
          {
            this.a.jdField_b_of_type_Int = this.a.c;
            this.a.c = 0;
            this.a.jdField_b_of_type_JavaUtilMap.clear();
          }
          this.a.a.put(Integer.valueOf(i), paramCursor);
          this.a.setChildrenCursor(i, paramCursor);
          if ((l != this.a.getGroupId(1)) || (paramCursor == null)) {
            break;
          }
          new Thread(new fct(this)).start();
          return;
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     fcs
 * JD-Core Version:    0.7.0.1
 */