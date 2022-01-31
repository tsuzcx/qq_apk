import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.HelloListActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.recent.cur.DragRelativeLayout;
import com.tencent.mobileqq.activity.recent.cur.DragTextView;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.ConversationFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.international.LocaleUtil;
import com.tencent.mobileqq.utils.MsgUtils;
import com.tencent.mobileqq.utils.TimeFormatterUtils;
import com.tencent.widget.XCursorAdapter;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class cwh
  extends XCursorAdapter
{
  private long jdField_a_of_type_Long;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  protected LayoutInflater a;
  private HashMap jdField_a_of_type_JavaUtilHashMap;
  private Drawable b;
  private Drawable c;
  
  public cwh(HelloListActivity paramHelloListActivity, Cursor paramCursor)
  {
    super(paramHelloListActivity, paramCursor);
    this.jdField_a_of_type_AndroidViewLayoutInflater = ((LayoutInflater)paramHelloListActivity.getSystemService("layout_inflater"));
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    b();
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130839634);
    this.b = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130839632);
    this.c = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130839636);
  }
  
  private String a(String paramString, long paramLong)
  {
    Object localObject = (HashMap)this.jdField_a_of_type_JavaUtilHashMap.get(paramString + "_" + LocaleUtil.a());
    if ((localObject == null) || (!a()))
    {
      localObject = new HashMap();
      this.jdField_a_of_type_JavaUtilHashMap.put(paramString + "_" + LocaleUtil.a(), localObject);
    }
    for (paramString = (String)localObject;; paramString = (String)localObject)
    {
      localObject = TimeFormatterUtils.a(1000L * paramLong, false);
      paramString.put(paramLong + "", localObject);
      paramString = (String)localObject;
      String str;
      do
      {
        return paramString;
        str = (String)((HashMap)localObject).get(paramLong + "");
        paramString = str;
      } while (str != null);
      ((HashMap)localObject).clear();
    }
  }
  
  private boolean a()
  {
    if (System.currentTimeMillis() >= this.jdField_a_of_type_Long)
    {
      b();
      this.jdField_a_of_type_JavaUtilHashMap.clear();
      return false;
    }
    return true;
  }
  
  private void b()
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.add(5, 1);
    localCalendar.set(10, 0);
    localCalendar.set(12, 0);
    localCalendar.set(13, 0);
    this.jdField_a_of_type_Long = localCalendar.getTimeInMillis();
  }
  
  public View a(Context paramContext, Cursor paramCursor, ViewGroup paramViewGroup)
  {
    return this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903247, paramViewGroup, false);
  }
  
  public void a(Cursor paramCursor)
  {
    if (HelloListActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityHelloListActivity).a() == -1)
    {
      super.a(paramCursor);
      notifyDataSetChanged();
    }
  }
  
  public void a(View paramView, Context paramContext, Cursor paramCursor)
  {
    String str = paramCursor.getString(paramCursor.getColumnIndex("senderuin"));
    paramContext = (cwi)paramView.getTag();
    if (paramContext == null)
    {
      paramContext = new cwi(null);
      paramContext.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131231770));
      paramContext.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131231771));
      paramContext.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131231090));
      paramContext.b = ((TextView)paramView.findViewById(2131231772));
      paramContext.c = ((TextView)paramView.findViewById(2131231769));
      paramContext.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView = ((DragTextView)paramView.findViewById(2131231773));
      paramView.setTag(paramContext);
      paramContext.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setOnModeChangeListener(HelloListActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityHelloListActivity));
      paramContext.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(0);
    }
    for (paramView = paramContext;; paramView = paramContext)
    {
      QQMessageFacade.Message localMessage = this.jdField_a_of_type_ComTencentMobileqqActivityHelloListActivity.b.a().a(str, 1001);
      paramContext = a(str, paramCursor.getLong(paramCursor.getColumnIndex("time")));
      paramView.c.setText(paramContext);
      int i;
      if (paramCursor.getInt(paramCursor.getColumnIndex("issend")) == 1)
      {
        i = 1;
        paramContext = paramCursor.getString(paramCursor.getColumnIndex("friendnick"));
        if ((paramContext != null) && (!paramContext.equals("")) && (!str.equals(paramContext))) {
          break label532;
        }
        if (!HelloListActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityHelloListActivity).containsKey(str)) {
          HelloListActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityHelloListActivity).a(str);
        }
        paramContext = str;
      }
      label532:
      for (;;)
      {
        paramCursor = paramCursor.getString(paramCursor.getColumnIndex("pyFaceUrl"));
        HelloListActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityHelloListActivity).put(str, paramCursor);
        paramView.jdField_a_of_type_AndroidWidgetTextView.setText(paramContext);
        int j = this.jdField_a_of_type_ComTencentMobileqqActivityHelloListActivity.b.a().a(str, 1001);
        if ((i == 0) && (j > 0))
        {
          paramView.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setVisibility(0);
          if (j > 99) {
            paramView.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setText("99+");
          }
        }
        for (;;)
        {
          paramView.b.setText(localMessage.msg);
          MsgUtils.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityHelloListActivity.b, localMessage, paramView.b, 1001, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, this.c, this.b);
          paramCursor = this.jdField_a_of_type_ComTencentMobileqqActivityHelloListActivity.b.b(str);
          if (paramCursor != null) {
            paramView.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(paramCursor);
          }
          paramCursor = new ProfileActivity.AllInOne(str, -1);
          paramCursor.g = paramContext;
          paramView.jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(2130838008, paramCursor);
          paramView.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setTag(paramCursor);
          paramView.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityHelloListActivity);
          return;
          i = 0;
          break;
          paramView.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setText(String.valueOf(j));
          continue;
          paramView.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setVisibility(8);
        }
      }
    }
  }
  
  public long getItemId(int paramInt)
  {
    a().moveToPosition(paramInt);
    return Long.valueOf(a().getString(a().getColumnIndex("senderuin"))).longValue();
  }
  
  public void notifyDataSetChanged()
  {
    if (HelloListActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityHelloListActivity).a() == -1) {
      super.notifyDataSetChanged();
    }
  }
  
  public void notifyDataSetInvalidated()
  {
    if (HelloListActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityHelloListActivity).a() == -1) {
      super.notifyDataSetInvalidated();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     cwh
 * JD-Core Version:    0.7.0.1
 */